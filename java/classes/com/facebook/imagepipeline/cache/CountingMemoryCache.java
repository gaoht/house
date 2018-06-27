package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.BitmapCreationObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingMemoryCache<K, V>
  implements MemoryTrimmable, MemoryCache<K, V>
{
  @VisibleForTesting
  static final long PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
  private final CacheTrimStrategy mCacheTrimStrategy;
  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mCachedEntries;
  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
  @GuardedBy("this")
  private long mLastCacheParamsCheck;
  @GuardedBy("this")
  protected MemoryCacheParams mMemoryCacheParams;
  private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
  @VisibleForTesting
  @GuardedBy("this")
  final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
  private final ValueDescriptor<V> mValueDescriptor;
  
  public CountingMemoryCache(ValueDescriptor<V> paramValueDescriptor, CacheTrimStrategy paramCacheTrimStrategy, Supplier<MemoryCacheParams> paramSupplier, PlatformBitmapFactory paramPlatformBitmapFactory, boolean paramBoolean)
  {
    this.mValueDescriptor = paramValueDescriptor;
    this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCacheTrimStrategy = paramCacheTrimStrategy;
    this.mMemoryCacheParamsSupplier = paramSupplier;
    this.mMemoryCacheParams = ((MemoryCacheParams)this.mMemoryCacheParamsSupplier.get());
    this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
    if (paramBoolean) {
      paramPlatformBitmapFactory.setCreationListener(new PlatformBitmapFactory.BitmapCreationObserver()
      {
        public void onBitmapCreated(Bitmap paramAnonymousBitmap, Object paramAnonymousObject)
        {
          CountingMemoryCache.this.mOtherEntries.put(paramAnonymousBitmap, paramAnonymousObject);
        }
      });
    }
  }
  
  /* Error */
  private boolean canCacheNewValue(V paramV)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/facebook/imagepipeline/cache/CountingMemoryCache:mValueDescriptor	Lcom/facebook/imagepipeline/cache/ValueDescriptor;
    //   6: aload_1
    //   7: invokeinterface 137 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: aload_0
    //   15: getfield 104	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   18: getfield 141	com/facebook/imagepipeline/cache/MemoryCacheParams:maxCacheEntrySize	I
    //   21: if_icmpgt +49 -> 70
    //   24: aload_0
    //   25: invokevirtual 145	com/facebook/imagepipeline/cache/CountingMemoryCache:getInUseCount	()I
    //   28: aload_0
    //   29: getfield 104	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   32: getfield 148	com/facebook/imagepipeline/cache/MemoryCacheParams:maxCacheEntries	I
    //   35: iconst_1
    //   36: isub
    //   37: if_icmpgt +33 -> 70
    //   40: aload_0
    //   41: invokevirtual 151	com/facebook/imagepipeline/cache/CountingMemoryCache:getInUseSizeInBytes	()I
    //   44: istore_3
    //   45: aload_0
    //   46: getfield 104	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   49: getfield 154	com/facebook/imagepipeline/cache/MemoryCacheParams:maxCacheSize	I
    //   52: istore 4
    //   54: iload_3
    //   55: iload 4
    //   57: iload_2
    //   58: isub
    //   59: if_icmpgt +11 -> 70
    //   62: iconst_1
    //   63: istore 5
    //   65: aload_0
    //   66: monitorexit
    //   67: iload 5
    //   69: ireturn
    //   70: iconst_0
    //   71: istore 5
    //   73: goto -8 -> 65
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	CountingMemoryCache
    //   0	81	1	paramV	V
    //   12	47	2	i	int
    //   44	16	3	j	int
    //   52	7	4	k	int
    //   63	9	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	54	76	finally
  }
  
  /* Error */
  private void decreaseClientCount(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 162	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: getfield 165	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   11: ifle +22 -> 33
    //   14: iconst_1
    //   15: istore_2
    //   16: iload_2
    //   17: invokestatic 169	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   20: aload_1
    //   21: aload_1
    //   22: getfield 165	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   25: iconst_1
    //   26: isub
    //   27: putfield 165	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -19 -> 16
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	CountingMemoryCache
    //   0	43	1	paramEntry	Entry<K, V>
    //   15	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	38	finally
    //   16	30	38	finally
  }
  
  /* Error */
  private void increaseClientCount(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 162	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: getfield 175	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   11: ifne +22 -> 33
    //   14: iconst_1
    //   15: istore_2
    //   16: iload_2
    //   17: invokestatic 169	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   20: aload_1
    //   21: aload_1
    //   22: getfield 165	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   25: iconst_1
    //   26: iadd
    //   27: putfield 165	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -19 -> 16
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	CountingMemoryCache
    //   0	43	1	paramEntry	Entry<K, V>
    //   15	20	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	38	finally
    //   16	30	38	finally
  }
  
  /* Error */
  private void makeOrphan(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic 162	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_1
    //   10: getfield 175	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   13: ifne +15 -> 28
    //   16: iload_2
    //   17: invokestatic 169	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   20: aload_1
    //   21: iconst_1
    //   22: putfield 175	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -14 -> 16
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	CountingMemoryCache
    //   0	38	1	paramEntry	Entry<K, V>
    //   1	29	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	16	33	finally
    //   16	25	33	finally
  }
  
  private void makeOrphans(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          makeOrphan((Entry)paramArrayList.next());
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private boolean maybeAddToExclusives(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 175	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   6: ifne +29 -> 35
    //   9: aload_1
    //   10: getfield 165	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   13: ifne +22 -> 35
    //   16: aload_0
    //   17: getfield 88	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   20: aload_1
    //   21: getfield 204	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:key	Ljava/lang/Object;
    //   24: aload_1
    //   25: invokevirtual 208	com/facebook/imagepipeline/cache/CountingLruMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: pop
    //   29: iconst_1
    //   30: istore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_2
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -6 -> 31
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	CountingMemoryCache
    //   0	45	1	paramEntry	Entry<K, V>
    //   30	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	29	40	finally
  }
  
  private void maybeClose(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        CloseableReference.closeSafely(referenceToClose((Entry)paramArrayList.next()));
      }
    }
  }
  
  private void maybeEvictEntries()
  {
    try
    {
      ArrayList localArrayList = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
      makeOrphans(localArrayList);
      maybeClose(localArrayList);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      return;
    }
    finally {}
  }
  
  private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null)) {
      paramEntry.observer.onExclusivityChanged(paramEntry.key, true);
    }
  }
  
  private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null)) {
      paramEntry.observer.onExclusivityChanged(paramEntry.key, false);
    }
  }
  
  private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        maybeNotifyExclusiveEntryRemoval((Entry)paramArrayList.next());
      }
    }
  }
  
  /* Error */
  private void maybeUpdateCacheParams()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/facebook/imagepipeline/cache/CountingMemoryCache:mLastCacheParamsCheck	J
    //   6: lstore_1
    //   7: getstatic 65	com/facebook/imagepipeline/cache/CountingMemoryCache:PARAMS_INTERCHECK_INTERVAL_MS	J
    //   10: lstore_3
    //   11: invokestatic 110	android/os/SystemClock:uptimeMillis	()J
    //   14: lstore 5
    //   16: lload_1
    //   17: lload_3
    //   18: ladd
    //   19: lload 5
    //   21: lcmp
    //   22: ifle +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokestatic 110	android/os/SystemClock:uptimeMillis	()J
    //   32: putfield 112	com/facebook/imagepipeline/cache/CountingMemoryCache:mLastCacheParamsCheck	J
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 94	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParamsSupplier	Lcom/facebook/common/internal/Supplier;
    //   40: invokeinterface 100 1 0
    //   45: checkcast 102	com/facebook/imagepipeline/cache/MemoryCacheParams
    //   48: putfield 104	com/facebook/imagepipeline/cache/CountingMemoryCache:mMemoryCacheParams	Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    //   51: goto -26 -> 25
    //   54: astore 7
    //   56: aload_0
    //   57: monitorexit
    //   58: aload 7
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	CountingMemoryCache
    //   6	11	1	l1	long
    //   10	8	3	l2	long
    //   14	6	5	l3	long
    //   54	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	54	finally
    //   28	51	54	finally
  }
  
  private CloseableReference<V> newClientReference(final Entry<K, V> paramEntry)
  {
    try
    {
      increaseClientCount(paramEntry);
      paramEntry = CloseableReference.of(paramEntry.valueRef.get(), new ResourceReleaser()
      {
        public void release(V paramAnonymousV)
        {
          CountingMemoryCache.this.releaseClientReference(paramEntry);
        }
      });
      return paramEntry;
    }
    finally
    {
      paramEntry = finally;
      throw paramEntry;
    }
  }
  
  /* Error */
  @Nullable
  private CloseableReference<V> referenceToClose(Entry<K, V> paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 162	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: getfield 175	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:isOrphan	Z
    //   11: ifeq +19 -> 30
    //   14: aload_1
    //   15: getfield 165	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:clientCount	I
    //   18: ifne +12 -> 30
    //   21: aload_1
    //   22: getfield 264	com/facebook/imagepipeline/cache/CountingMemoryCache$Entry:valueRef	Lcom/facebook/common/references/CloseableReference;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aconst_null
    //   31: astore_1
    //   32: goto -6 -> 26
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	CountingMemoryCache
    //   0	40	1	paramEntry	Entry<K, V>
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void releaseClientReference(Entry<K, V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    for (;;)
    {
      try
      {
        decreaseClientCount(paramEntry);
        boolean bool = maybeAddToExclusives(paramEntry);
        CloseableReference localCloseableReference = referenceToClose(paramEntry);
        CloseableReference.closeSafely(localCloseableReference);
        if (bool)
        {
          maybeNotifyExclusiveEntryInsertion(paramEntry);
          maybeUpdateCacheParams();
          maybeEvictEntries();
          return;
        }
      }
      finally {}
      paramEntry = null;
    }
  }
  
  /* Error */
  @Nullable
  private ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_0
    //   4: invokestatic 286	java/lang/Math:max	(II)I
    //   7: istore_1
    //   8: iload_2
    //   9: iconst_0
    //   10: invokestatic 286	java/lang/Math:max	(II)I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 88	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   18: invokevirtual 289	com/facebook/imagepipeline/cache/CountingLruMap:getCount	()I
    //   21: iload_1
    //   22: if_icmpgt +24 -> 46
    //   25: aload_0
    //   26: getfield 88	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   29: invokevirtual 291	com/facebook/imagepipeline/cache/CountingLruMap:getSizeInBytes	()I
    //   32: istore_3
    //   33: iload_3
    //   34: iload_2
    //   35: if_icmpgt +11 -> 46
    //   38: aconst_null
    //   39: astore 4
    //   41: aload_0
    //   42: monitorexit
    //   43: aload 4
    //   45: areturn
    //   46: new 181	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 292	java/util/ArrayList:<init>	()V
    //   53: astore 5
    //   55: aload_0
    //   56: getfield 88	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   59: invokevirtual 289	com/facebook/imagepipeline/cache/CountingLruMap:getCount	()I
    //   62: iload_1
    //   63: if_icmpgt +18 -> 81
    //   66: aload 5
    //   68: astore 4
    //   70: aload_0
    //   71: getfield 88	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   74: invokevirtual 291	com/facebook/imagepipeline/cache/CountingLruMap:getSizeInBytes	()I
    //   77: iload_2
    //   78: if_icmple -37 -> 41
    //   81: aload_0
    //   82: getfield 88	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   85: invokevirtual 295	com/facebook/imagepipeline/cache/CountingLruMap:getFirstKey	()Ljava/lang/Object;
    //   88: astore 4
    //   90: aload_0
    //   91: getfield 88	com/facebook/imagepipeline/cache/CountingMemoryCache:mExclusiveEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   94: aload 4
    //   96: invokevirtual 298	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: aload 5
    //   102: aload_0
    //   103: getfield 90	com/facebook/imagepipeline/cache/CountingMemoryCache:mCachedEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   106: aload 4
    //   108: invokevirtual 298	com/facebook/imagepipeline/cache/CountingLruMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: invokevirtual 301	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: goto -60 -> 55
    //   118: astore 4
    //   120: aload_0
    //   121: monitorexit
    //   122: aload 4
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	CountingMemoryCache
    //   0	125	1	paramInt1	int
    //   0	125	2	paramInt2	int
    //   32	4	3	i	int
    //   39	68	4	localObject1	Object
    //   118	5	4	localObject2	Object
    //   53	48	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	33	118	finally
    //   46	55	118	finally
    //   55	66	118	finally
    //   70	81	118	finally
    //   81	115	118	finally
  }
  
  private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> paramValueDescriptor)
  {
    new ValueDescriptor()
    {
      public int getSizeInBytes(CountingMemoryCache.Entry<K, V> paramAnonymousEntry)
      {
        return paramValueDescriptor.getSizeInBytes(paramAnonymousEntry.valueRef.get());
      }
    };
  }
  
  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference)
  {
    return cache(paramK, paramCloseableReference, null);
  }
  
  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference, EntryStateObserver<K> paramEntryStateObserver)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramCloseableReference);
    maybeUpdateCacheParams();
    for (;;)
    {
      try
      {
        Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
        localObject = (Entry)this.mCachedEntries.remove(paramK);
        if (localObject == null) {
          break label123;
        }
        makeOrphan((Entry)localObject);
        localObject = referenceToClose((Entry)localObject);
        if (canCacheNewValue(paramCloseableReference.get()))
        {
          paramCloseableReference = Entry.of(paramK, paramCloseableReference, paramEntryStateObserver);
          this.mCachedEntries.put(paramK, paramCloseableReference);
          paramK = newClientReference(paramCloseableReference);
          CloseableReference.closeSafely((CloseableReference)localObject);
          maybeNotifyExclusiveEntryRemoval(localEntry);
          maybeEvictEntries();
          return paramK;
        }
      }
      finally {}
      paramK = null;
      continue;
      label123:
      Object localObject = null;
    }
  }
  
  public void clear()
  {
    try
    {
      ArrayList localArrayList1 = this.mExclusiveEntries.clear();
      ArrayList localArrayList2 = this.mCachedEntries.clear();
      makeOrphans(localArrayList2);
      maybeClose(localArrayList2);
      maybeNotifyExclusiveEntryRemoval(localArrayList1);
      maybeUpdateCacheParams();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean contains(Predicate<K> paramPredicate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	com/facebook/imagepipeline/cache/CountingMemoryCache:mCachedEntries	Lcom/facebook/imagepipeline/cache/CountingLruMap;
    //   6: aload_1
    //   7: invokevirtual 330	com/facebook/imagepipeline/cache/CountingLruMap:getMatchingEntries	(Lcom/android/internal/util/Predicate;)Ljava/util/ArrayList;
    //   10: invokevirtual 333	java/util/ArrayList:isEmpty	()Z
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +9 -> 24
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_2
    //   26: goto -6 -> 20
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	CountingMemoryCache
    //   0	34	1	paramPredicate	Predicate<K>
    //   13	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  @Nullable
  public CloseableReference<V> get(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    for (;;)
    {
      try
      {
        Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
        paramK = (Entry)this.mCachedEntries.get(paramK);
        if (paramK != null)
        {
          paramK = newClientReference(paramK);
          maybeNotifyExclusiveEntryRemoval(localEntry);
          maybeUpdateCacheParams();
          maybeEvictEntries();
          return paramK;
        }
      }
      finally {}
      paramK = null;
    }
  }
  
  public int getCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getEvictionQueueCount()
  {
    try
    {
      int i = this.mExclusiveEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getEvictionQueueSizeInBytes()
  {
    try
    {
      int i = this.mExclusiveEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getInUseCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      int j = this.mExclusiveEntries.getCount();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getInUseSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      int j = this.mExclusiveEntries.getSizeInBytes();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int removeAll(Predicate<K> paramPredicate)
  {
    try
    {
      ArrayList localArrayList = this.mExclusiveEntries.removeAll(paramPredicate);
      paramPredicate = this.mCachedEntries.removeAll(paramPredicate);
      makeOrphans(paramPredicate);
      maybeClose(paramPredicate);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return paramPredicate.size();
    }
    finally {}
  }
  
  @Nullable
  public CloseableReference<V> reuse(K paramK)
  {
    boolean bool = false;
    Preconditions.checkNotNull(paramK);
    for (;;)
    {
      try
      {
        Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
        if (localEntry != null)
        {
          paramK = (Entry)this.mCachedEntries.remove(paramK);
          Preconditions.checkNotNull(paramK);
          if (paramK.clientCount == 0) {
            bool = true;
          }
          Preconditions.checkState(bool);
          paramK = paramK.valueRef;
          i = 1;
          if (i != 0) {
            maybeNotifyExclusiveEntryRemoval(localEntry);
          }
          return paramK;
        }
      }
      finally {}
      paramK = null;
      int i = 0;
    }
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    double d = this.mCacheTrimStrategy.getTrimRatio(paramMemoryTrimType);
    try
    {
      paramMemoryTrimType = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, (int)((1.0D - d) * this.mCachedEntries.getSizeInBytes()) - getInUseSizeInBytes()));
      makeOrphans(paramMemoryTrimType);
      maybeClose(paramMemoryTrimType);
      maybeNotifyExclusiveEntryRemoval(paramMemoryTrimType);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return;
    }
    finally {}
  }
  
  public static abstract interface CacheTrimStrategy
  {
    public abstract double getTrimRatio(MemoryTrimType paramMemoryTrimType);
  }
  
  @VisibleForTesting
  static class Entry<K, V>
  {
    public int clientCount;
    public boolean isOrphan;
    public final K key;
    @Nullable
    public final CountingMemoryCache.EntryStateObserver<K> observer;
    public final CloseableReference<V> valueRef;
    
    private Entry(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      this.key = Preconditions.checkNotNull(paramK);
      this.valueRef = ((CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(paramCloseableReference)));
      this.clientCount = 0;
      this.isOrphan = false;
      this.observer = paramEntryStateObserver;
    }
    
    @VisibleForTesting
    static <K, V> Entry<K, V> of(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      return new Entry(paramK, paramCloseableReference, paramEntryStateObserver);
    }
  }
  
  public static abstract interface EntryStateObserver<K>
  {
    public abstract void onExclusivityChanged(K paramK, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/CountingMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */