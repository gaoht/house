package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class DiskStorageCache
  implements FileCache, DiskTrimmable
{
  private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30L);
  private static final long FUTURE_TIMESTAMP_THRESHOLD_MS;
  private static final String SHARED_PREFS_FILENAME_PREFIX = "disk_entries_list";
  public static final int START_OF_VERSIONING = 1;
  private static final Class<?> TAG = DiskStorageCache.class;
  private static final double TRIMMING_LOWER_BOUND = 0.02D;
  private static final long UNINITIALIZED = -1L;
  private final CacheErrorLogger mCacheErrorLogger;
  private final CacheEventListener mCacheEventListener;
  @GuardedBy("mLock")
  private long mCacheSizeLastUpdateTime;
  private long mCacheSizeLimit;
  private final long mCacheSizeLimitMinimum;
  private final CacheStats mCacheStats;
  private final Clock mClock;
  private final CountDownLatch mCountDownLatch;
  private final long mDefaultCacheSizeLimit;
  private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
  private final boolean mIndexPopulateAtStartupEnabled;
  private boolean mIndexReady;
  private final Object mLock = new Object();
  private final long mLowDiskSpaceCacheSizeLimit;
  @VisibleForTesting
  @GuardedBy("mLock")
  final Set<String> mResourceIndex;
  private final StatFsHelper mStatFsHelper;
  private final DiskStorage mStorage;
  
  static
  {
    FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2L);
  }
  
  public DiskStorageCache(DiskStorage paramDiskStorage, EntryEvictionComparatorSupplier paramEntryEvictionComparatorSupplier, Params paramParams, CacheEventListener paramCacheEventListener, CacheErrorLogger paramCacheErrorLogger, @Nullable DiskTrimmableRegistry paramDiskTrimmableRegistry, final Context paramContext, Executor paramExecutor, boolean paramBoolean)
  {
    this.mLowDiskSpaceCacheSizeLimit = paramParams.mLowDiskSpaceCacheSizeLimit;
    this.mDefaultCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mStatFsHelper = StatFsHelper.getInstance();
    this.mStorage = paramDiskStorage;
    this.mEntryEvictionComparatorSupplier = paramEntryEvictionComparatorSupplier;
    this.mCacheSizeLastUpdateTime = -1L;
    this.mCacheEventListener = paramCacheEventListener;
    this.mCacheSizeLimitMinimum = paramParams.mCacheSizeLimitMinimum;
    this.mCacheErrorLogger = paramCacheErrorLogger;
    this.mCacheStats = new CacheStats();
    if (paramDiskTrimmableRegistry != null) {
      paramDiskTrimmableRegistry.registerDiskTrimmable(this);
    }
    this.mClock = SystemClock.get();
    this.mIndexPopulateAtStartupEnabled = paramBoolean;
    this.mResourceIndex = new HashSet();
    if (this.mIndexPopulateAtStartupEnabled)
    {
      this.mCountDownLatch = new CountDownLatch(1);
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          synchronized (DiskStorageCache.this.mLock)
          {
            DiskStorageCache.this.maybeUpdateFileCacheSize();
            DiskStorageCache.this.mCountDownLatch.countDown();
            return;
          }
        }
      });
    }
    for (;;)
    {
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          DiskStorageCache.maybeDeleteSharedPreferencesFile(paramContext, DiskStorageCache.this.mStorage.getStorageName());
        }
      });
      return;
      this.mCountDownLatch = new CountDownLatch(0);
    }
  }
  
  private BinaryResource endInsert(DiskStorage.Inserter paramInserter, CacheKey paramCacheKey, String paramString)
    throws IOException
  {
    synchronized (this.mLock)
    {
      paramInserter = paramInserter.commit(paramCacheKey);
      this.mResourceIndex.add(paramString);
      this.mCacheStats.increment(paramInserter.size(), 1L);
      return paramInserter;
    }
  }
  
  @GuardedBy("mLock")
  private void evictAboveSize(long paramLong, CacheEventListener.EvictionReason paramEvictionReason)
    throws IOException
  {
    for (;;)
    {
      long l3;
      Object localObject2;
      try
      {
        Object localObject1 = getSortedEntries(this.mStorage.getEntries());
        l3 = this.mCacheStats.getSize();
        localObject1 = ((Collection)localObject1).iterator();
        i = 0;
        l1 = 0L;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DiskStorage.Entry)((Iterator)localObject1).next();
          if (l1 <= l3 - paramLong) {}
        }
        else
        {
          this.mCacheStats.increment(-l1, -i);
          this.mStorage.purgeUnexpectedResources();
          return;
        }
      }
      catch (IOException paramEvictionReason)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + paramEvictionReason.getMessage(), paramEvictionReason);
        throw paramEvictionReason;
      }
      long l4 = this.mStorage.remove((DiskStorage.Entry)localObject2);
      this.mResourceIndex.remove(((DiskStorage.Entry)localObject2).getId());
      int j = i;
      long l2 = l1;
      if (l4 > 0L)
      {
        j = i + 1;
        l2 = l1 + l4;
        localObject2 = SettableCacheEvent.obtain().setResourceId(((DiskStorage.Entry)localObject2).getId()).setEvictionReason(paramEvictionReason).setItemSize(l4).setCacheSize(l3 - l2).setCacheLimit(paramLong);
        this.mCacheEventListener.onEviction((CacheEvent)localObject2);
        ((SettableCacheEvent)localObject2).recycle();
      }
      int i = j;
      long l1 = l2;
    }
  }
  
  private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> paramCollection)
  {
    long l1 = this.mClock.now();
    long l2 = FUTURE_TIMESTAMP_THRESHOLD_MS;
    ArrayList localArrayList1 = new ArrayList(paramCollection.size());
    ArrayList localArrayList2 = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      DiskStorage.Entry localEntry = (DiskStorage.Entry)paramCollection.next();
      if (localEntry.getTimestamp() > l2 + l1) {
        localArrayList1.add(localEntry);
      } else {
        localArrayList2.add(localEntry);
      }
    }
    Collections.sort(localArrayList2, this.mEntryEvictionComparatorSupplier.get());
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  private static void maybeDeleteSharedPreferencesFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getApplicationContext();
      paramContext = paramContext.getFilesDir().getParent() + File.separator + "shared_prefs" + File.separator + "disk_entries_list" + paramString;
      paramContext = new File(paramContext + ".xml");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      return;
    }
    catch (Exception paramContext)
    {
      FLog.e(TAG, "Fail to delete SharedPreference from file system. ");
    }
  }
  
  private void maybeEvictFilesInCacheDir()
    throws IOException
  {
    synchronized (this.mLock)
    {
      boolean bool = maybeUpdateFileCacheSize();
      updateFileCacheSizeLimit();
      long l = this.mCacheStats.getSize();
      if ((l > this.mCacheSizeLimit) && (!bool))
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
      }
      if (l > this.mCacheSizeLimit) {
        evictAboveSize(this.mCacheSizeLimit * 9L / 10L, CacheEventListener.EvictionReason.CACHE_FULL);
      }
      return;
    }
  }
  
  @GuardedBy("mLock")
  private boolean maybeUpdateFileCacheSize()
  {
    long l = this.mClock.now();
    if ((!this.mCacheStats.isInitialized()) || (this.mCacheSizeLastUpdateTime == -1L) || (l - this.mCacheSizeLastUpdateTime > FILECACHE_SIZE_UPDATE_PERIOD_MS)) {
      return maybeUpdateFileCacheSizeAndIndex();
    }
    return false;
  }
  
  @GuardedBy("mLock")
  private boolean maybeUpdateFileCacheSizeAndIndex()
  {
    int j = 0;
    int i = 0;
    int k = 0;
    long l1 = -1L;
    long l3 = this.mClock.now();
    long l4 = FUTURE_TIMESTAMP_THRESHOLD_MS;
    Object localObject;
    if ((this.mIndexPopulateAtStartupEnabled) && (this.mResourceIndex.isEmpty())) {
      localObject = this.mResourceIndex;
    }
    for (;;)
    {
      int n;
      try
      {
        Iterator localIterator = this.mStorage.getEntries().iterator();
        long l2 = 0L;
        int m = 0;
        if (localIterator.hasNext())
        {
          DiskStorage.Entry localEntry = (DiskStorage.Entry)localIterator.next();
          l2 += localEntry.getSize();
          if (localEntry.getTimestamp() > l3 + l4)
          {
            n = (int)(k + localEntry.getSize());
            l1 = Math.max(localEntry.getTimestamp() - l3, l1);
            j = i + 1;
            k = 1;
            i = n;
            n = k;
            m += 1;
            k = i;
            i = j;
            j = n;
            continue;
            if (this.mIndexPopulateAtStartupEnabled)
            {
              localObject = new HashSet();
              continue;
            }
            localObject = null;
            continue;
          }
          if (this.mIndexPopulateAtStartupEnabled) {
            ((Set)localObject).add(localEntry.getId());
          }
        }
        else
        {
          if (j != 0) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i + " files , with a total size of " + k + " bytes, and a maximum time delta of " + l1 + "ms", null);
          }
          if ((this.mCacheStats.getCount() != m) || (this.mCacheStats.getSize() != l2))
          {
            if ((this.mIndexPopulateAtStartupEnabled) && (this.mResourceIndex != localObject))
            {
              this.mIndexReady = true;
              this.mCacheStats.set(l2, m);
            }
          }
          else
          {
            this.mCacheSizeLastUpdateTime = l3;
            return true;
          }
          if (!this.mIndexPopulateAtStartupEnabled) {
            continue;
          }
          this.mResourceIndex.clear();
          this.mResourceIndex.addAll((Collection)localObject);
          continue;
        }
        n = i;
      }
      catch (IOException localIOException)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + localIOException.getMessage(), localIOException);
        return false;
      }
      int i1 = j;
      i = k;
      j = n;
      k = i1;
    }
  }
  
  private DiskStorage.Inserter startInsert(String paramString, CacheKey paramCacheKey)
    throws IOException
  {
    maybeEvictFilesInCacheDir();
    return this.mStorage.insert(paramString, paramCacheKey);
  }
  
  private void trimBy(double paramDouble)
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
        long l = this.mCacheStats.getSize();
        evictAboveSize(l - (l * paramDouble), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + localIOException.getMessage(), localIOException);
        }
      }
    }
  }
  
  @GuardedBy("mLock")
  private void updateFileCacheSizeLimit()
  {
    if (this.mStorage.isExternal()) {}
    for (StatFsHelper.StorageType localStorageType = StatFsHelper.StorageType.EXTERNAL; this.mStatFsHelper.testLowDiskSpace(localStorageType, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize()); localStorageType = StatFsHelper.StorageType.INTERNAL)
    {
      this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
      return;
    }
    this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
  }
  
  @VisibleForTesting
  protected void awaitIndex()
  {
    try
    {
      this.mCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      FLog.e(TAG, "Memory Index is not ready yet. ");
    }
  }
  
  public void clearAll()
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mStorage.clearAll();
        this.mResourceIndex.clear();
        this.mCacheEventListener.onCleared();
        this.mCacheStats.reset();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + localIOException.getMessage(), localIOException);
        }
      }
    }
  }
  
  public long clearOldEntries(long paramLong)
  {
    long l1 = 0L;
    Object localObject1 = this.mLock;
    long l3 = l1;
    for (;;)
    {
      int j;
      try
      {
        long l5 = this.mClock.now();
        l3 = l1;
        Object localObject2 = this.mStorage.getEntries();
        l3 = l1;
        long l6 = this.mCacheStats.getSize();
        i = 0;
        l2 = 0L;
        l3 = l1;
        localObject2 = ((Collection)localObject2).iterator();
        l3 = l1;
        if (((Iterator)localObject2).hasNext())
        {
          l3 = l1;
          Object localObject4 = (DiskStorage.Entry)((Iterator)localObject2).next();
          l3 = l1;
          long l4 = Math.max(1L, Math.abs(l5 - ((DiskStorage.Entry)localObject4).getTimestamp()));
          if (l4 >= paramLong)
          {
            l3 = l1;
            l4 = this.mStorage.remove((DiskStorage.Entry)localObject4);
            l3 = l1;
            this.mResourceIndex.remove(((DiskStorage.Entry)localObject4).getId());
            j = i;
            l3 = l2;
            if (l4 <= 0L) {
              break label401;
            }
            j = i + 1;
            l2 += l4;
            l3 = l1;
            localObject4 = SettableCacheEvent.obtain().setResourceId(((DiskStorage.Entry)localObject4).getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(l4).setCacheSize(l6 - l2);
            l3 = l1;
            this.mCacheEventListener.onEviction((CacheEvent)localObject4);
            l3 = l1;
            ((SettableCacheEvent)localObject4).recycle();
            l3 = l2;
            break label401;
          }
          l3 = l1;
          l4 = Math.max(l1, l4);
          l1 = l2;
          l3 = l4;
          break label416;
        }
        l3 = l1;
        this.mStorage.purgeUnexpectedResources();
        l3 = l1;
        if (i > 0)
        {
          l3 = l1;
          maybeUpdateFileCacheSize();
          l3 = l1;
          this.mCacheStats.increment(-l2, -i);
          l3 = l1;
        }
      }
      catch (IOException localIOException)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + localIOException.getMessage(), localIOException);
        continue;
      }
      finally {}
      return l3;
      label401:
      int i = j;
      long l2 = l3;
      l3 = l1;
      l1 = l2;
      label416:
      l2 = l1;
      l1 = l3;
    }
  }
  
  public long getCount()
  {
    return this.mCacheStats.getCount();
  }
  
  public DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException
  {
    return this.mStorage.getDumpInfo();
  }
  
  /* Error */
  public BinaryResource getResource(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: invokestatic 299	com/facebook/cache/disk/SettableCacheEvent:obtain	()Lcom/facebook/cache/disk/SettableCacheEvent;
    //   3: aload_1
    //   4: invokevirtual 535	com/facebook/cache/disk/SettableCacheEvent:setCacheKey	(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/cache/disk/SettableCacheEvent;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 104	com/facebook/cache/disk/DiskStorageCache:mLock	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_1
    //   19: invokestatic 541	com/facebook/cache/common/CacheKeyUtil:getResourceIds	(Lcom/facebook/cache/common/CacheKey;)Ljava/util/List;
    //   22: astore 8
    //   24: iconst_0
    //   25: istore_2
    //   26: aconst_null
    //   27: astore_3
    //   28: aconst_null
    //   29: astore 4
    //   31: iload_2
    //   32: aload 8
    //   34: invokeinterface 544 1 0
    //   39: if_icmpge +47 -> 86
    //   42: aload 8
    //   44: iload_2
    //   45: invokeinterface 547 2 0
    //   50: checkcast 549	java/lang/String
    //   53: astore 5
    //   55: aload 6
    //   57: aload 5
    //   59: invokevirtual 303	com/facebook/cache/disk/SettableCacheEvent:setResourceId	(Ljava/lang/String;)Lcom/facebook/cache/disk/SettableCacheEvent;
    //   62: pop
    //   63: aload_0
    //   64: getfield 122	com/facebook/cache/disk/DiskStorageCache:mStorage	Lcom/facebook/cache/disk/DiskStorage;
    //   67: aload 5
    //   69: aload_1
    //   70: invokeinterface 552 3 0
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +47 -> 124
    //   80: aload_3
    //   81: astore 4
    //   83: aload 5
    //   85: astore_3
    //   86: aload 4
    //   88: ifnonnull +49 -> 137
    //   91: aload_0
    //   92: getfield 128	com/facebook/cache/disk/DiskStorageCache:mCacheEventListener	Lcom/facebook/cache/common/CacheEventListener;
    //   95: aload 6
    //   97: invokeinterface 555 2 0
    //   102: aload_0
    //   103: getfield 157	com/facebook/cache/disk/DiskStorageCache:mResourceIndex	Ljava/util/Set;
    //   106: aload_3
    //   107: invokeinterface 293 2 0
    //   112: pop
    //   113: aload 7
    //   115: monitorexit
    //   116: aload 6
    //   118: invokevirtual 326	com/facebook/cache/disk/SettableCacheEvent:recycle	()V
    //   121: aload 4
    //   123: areturn
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: aload_3
    //   129: astore 4
    //   131: aload 5
    //   133: astore_3
    //   134: goto -103 -> 31
    //   137: aload_0
    //   138: getfield 128	com/facebook/cache/disk/DiskStorageCache:mCacheEventListener	Lcom/facebook/cache/common/CacheEventListener;
    //   141: aload 6
    //   143: invokeinterface 558 2 0
    //   148: aload_0
    //   149: getfield 157	com/facebook/cache/disk/DiskStorageCache:mResourceIndex	Ljava/util/Set;
    //   152: aload_3
    //   153: invokeinterface 210 2 0
    //   158: pop
    //   159: goto -46 -> 113
    //   162: astore_1
    //   163: aload 7
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload_0
    //   170: getfield 133	com/facebook/cache/disk/DiskStorageCache:mCacheErrorLogger	Lcom/facebook/cache/common/CacheErrorLogger;
    //   173: getstatic 467	com/facebook/cache/common/CacheErrorLogger$CacheErrorCategory:GENERIC_IO	Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    //   176: getstatic 75	com/facebook/cache/disk/DiskStorageCache:TAG	Ljava/lang/Class;
    //   179: ldc_w 559
    //   182: aload_1
    //   183: invokeinterface 284 5 0
    //   188: aload 6
    //   190: aload_1
    //   191: invokevirtual 563	com/facebook/cache/disk/SettableCacheEvent:setException	(Ljava/io/IOException;)Lcom/facebook/cache/disk/SettableCacheEvent;
    //   194: pop
    //   195: aload_0
    //   196: getfield 128	com/facebook/cache/disk/DiskStorageCache:mCacheEventListener	Lcom/facebook/cache/common/CacheEventListener;
    //   199: aload 6
    //   201: invokeinterface 566 2 0
    //   206: aload 6
    //   208: invokevirtual 326	com/facebook/cache/disk/SettableCacheEvent:recycle	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: aload 6
    //   216: invokevirtual 326	com/facebook/cache/disk/SettableCacheEvent:recycle	()V
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	DiskStorageCache
    //   0	221	1	paramCacheKey	CacheKey
    //   25	103	2	i	int
    //   27	126	3	localObject1	Object
    //   29	101	4	localObject2	Object
    //   53	79	5	str	String
    //   7	208	6	localSettableCacheEvent	SettableCacheEvent
    //   22	21	8	localList	List
    // Exception table:
    //   from	to	target	type
    //   18	24	162	finally
    //   31	76	162	finally
    //   91	113	162	finally
    //   113	116	162	finally
    //   137	159	162	finally
    //   163	166	162	finally
    //   9	18	168	java/io/IOException
    //   166	168	168	java/io/IOException
    //   9	18	213	finally
    //   166	168	213	finally
    //   169	206	213	finally
  }
  
  public long getSize()
  {
    return this.mCacheStats.getSize();
  }
  
  public boolean hasKey(CacheKey paramCacheKey)
  {
    for (;;)
    {
      int i;
      synchronized (this.mLock)
      {
        if (hasKeySync(paramCacheKey)) {
          return true;
        }
        try
        {
          List localList = CacheKeyUtil.getResourceIds(paramCacheKey);
          i = 0;
          if (i < localList.size())
          {
            String str = (String)localList.get(i);
            if (this.mStorage.contains(str, paramCacheKey))
            {
              this.mResourceIndex.add(str);
              return true;
            }
          }
          else
          {
            return false;
          }
        }
        catch (IOException paramCacheKey)
        {
          return false;
        }
      }
      i += 1;
    }
  }
  
  public boolean hasKeySync(CacheKey paramCacheKey)
  {
    for (;;)
    {
      int i;
      synchronized (this.mLock)
      {
        paramCacheKey = CacheKeyUtil.getResourceIds(paramCacheKey);
        i = 0;
        if (i < paramCacheKey.size())
        {
          String str = (String)paramCacheKey.get(i);
          if (this.mResourceIndex.contains(str)) {
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      i += 1;
    }
  }
  
  public BinaryResource insert(CacheKey paramCacheKey, WriterCallback paramWriterCallback)
    throws IOException
  {
    SettableCacheEvent localSettableCacheEvent = SettableCacheEvent.obtain().setCacheKey(paramCacheKey);
    this.mCacheEventListener.onWriteAttempt(localSettableCacheEvent);
    String str;
    synchronized (this.mLock)
    {
      str = CacheKeyUtil.getFirstResourceId(paramCacheKey);
      localSettableCacheEvent.setResourceId(str);
    }
    try
    {
      ??? = startInsert(str, paramCacheKey);
      try
      {
        ((DiskStorage.Inserter)???).writeData(paramWriterCallback, paramCacheKey);
        paramCacheKey = endInsert((DiskStorage.Inserter)???, paramCacheKey, str);
        localSettableCacheEvent.setItemSize(paramCacheKey.size()).setCacheSize(this.mCacheStats.getSize());
        this.mCacheEventListener.onWriteSuccess(localSettableCacheEvent);
        if (!((DiskStorage.Inserter)???).cleanUp()) {
          FLog.e(TAG, "Failed to delete temp file");
        }
        return paramCacheKey;
      }
      finally
      {
        if (((DiskStorage.Inserter)???).cleanUp()) {
          break label153;
        }
        FLog.e(TAG, "Failed to delete temp file");
      }
      paramCacheKey = finally;
      throw paramCacheKey;
    }
    catch (IOException paramCacheKey)
    {
      label153:
      localSettableCacheEvent.setException(paramCacheKey);
      this.mCacheEventListener.onWriteException(localSettableCacheEvent);
      FLog.e(TAG, "Failed inserting a file into the cache", paramCacheKey);
      throw paramCacheKey;
    }
    finally
    {
      localSettableCacheEvent.recycle();
    }
  }
  
  public boolean isEnabled()
  {
    return this.mStorage.isEnabled();
  }
  
  public boolean isIndexReady()
  {
    return (this.mIndexReady) || (!this.mIndexPopulateAtStartupEnabled);
  }
  
  public boolean probe(CacheKey paramCacheKey)
  {
    Object localObject1 = null;
    List localList = null;
    Object localObject3 = null;
    localObject2 = localObject1;
    for (;;)
    {
      try
      {
        localObject6 = this.mLock;
        localObject2 = localObject1;
        localObject1 = localList;
      }
      catch (IOException localIOException)
      {
        Object localObject6;
        int i;
        label115:
        paramCacheKey = SettableCacheEvent.obtain().setCacheKey(paramCacheKey).setResourceId((String)localObject2).setException(localIOException);
        this.mCacheEventListener.onReadException(paramCacheKey);
        paramCacheKey.recycle();
        return false;
      }
      for (;;)
      {
        try
        {
          localList = CacheKeyUtil.getResourceIds(paramCacheKey);
          i = 0;
          localObject2 = localObject3;
          localObject1 = localObject2;
          if (i < localList.size())
          {
            localObject1 = localObject2;
            localObject2 = (String)localList.get(i);
          }
        }
        finally
        {
          localObject2 = localIOException;
          break label115;
        }
        try
        {
          if (this.mStorage.touch((String)localObject2, paramCacheKey))
          {
            this.mResourceIndex.add(localObject2);
            return true;
          }
          i += 1;
        }
        finally
        {
          break label115;
        }
      }
    }
    localObject1 = localObject2;
    return false;
    localObject1 = localObject2;
    throw ((Throwable)localObject3);
  }
  
  public void remove(CacheKey paramCacheKey)
  {
    synchronized (this.mLock)
    {
      try
      {
        paramCacheKey = CacheKeyUtil.getResourceIds(paramCacheKey);
        int i = 0;
        while (i < paramCacheKey.size())
        {
          String str = (String)paramCacheKey.get(i);
          this.mStorage.remove(str);
          this.mResourceIndex.remove(str);
          i += 1;
        }
        paramCacheKey = finally;
      }
      catch (IOException paramCacheKey)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + paramCacheKey.getMessage(), paramCacheKey);
        return;
      }
    }
  }
  
  public void trimToMinimum()
  {
    synchronized (this.mLock)
    {
      maybeUpdateFileCacheSize();
      long l = this.mCacheStats.getSize();
      if ((this.mCacheSizeLimitMinimum <= 0L) || (l <= 0L) || (l < this.mCacheSizeLimitMinimum)) {
        return;
      }
      double d = 1.0D - this.mCacheSizeLimitMinimum / l;
      if (d > 0.02D) {
        trimBy(d);
      }
      return;
    }
  }
  
  public void trimToNothing()
  {
    clearAll();
  }
  
  @VisibleForTesting
  static class CacheStats
  {
    private long mCount = -1L;
    private boolean mInitialized = false;
    private long mSize = -1L;
    
    public long getCount()
    {
      try
      {
        long l = this.mCount;
        return l;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public long getSize()
    {
      try
      {
        long l = this.mSize;
        return l;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void increment(long paramLong1, long paramLong2)
    {
      try
      {
        if (this.mInitialized)
        {
          this.mSize += paramLong1;
          this.mCount += paramLong2;
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public boolean isInitialized()
    {
      try
      {
        boolean bool = this.mInitialized;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void reset()
    {
      try
      {
        this.mInitialized = false;
        this.mCount = -1L;
        this.mSize = -1L;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void set(long paramLong1, long paramLong2)
    {
      try
      {
        this.mCount = paramLong2;
        this.mSize = paramLong1;
        this.mInitialized = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  public static class Params
  {
    public final long mCacheSizeLimitMinimum;
    public final long mDefaultCacheSizeLimit;
    public final long mLowDiskSpaceCacheSizeLimit;
    
    public Params(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mCacheSizeLimitMinimum = paramLong1;
      this.mLowDiskSpaceCacheSizeLimit = paramLong2;
      this.mDefaultCacheSizeLimit = paramLong3;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/disk/DiskStorageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */