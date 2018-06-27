package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

public abstract class BasePool<V>
  implements Pool<V>
{
  private final Class<?> TAG = getClass();
  private boolean mAllowNewBuckets;
  @VisibleForTesting
  final SparseArray<Bucket<V>> mBuckets;
  @VisibleForTesting
  @GuardedBy("this")
  final Counter mFree;
  @VisibleForTesting
  final Set<V> mInUseValues;
  final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  final PoolParams mPoolParams;
  private final PoolStatsTracker mPoolStatsTracker;
  @VisibleForTesting
  @GuardedBy("this")
  final Counter mUsed;
  
  public BasePool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)Preconditions.checkNotNull(paramMemoryTrimmableRegistry));
    this.mPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
    this.mPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
    this.mBuckets = new SparseArray();
    initBuckets(new SparseIntArray(0));
    this.mInUseValues = Sets.newIdentityHashSet();
    this.mFree = new Counter();
    this.mUsed = new Counter();
  }
  
  private void ensurePoolSizeInvariant()
  {
    label39:
    for (;;)
    {
      try
      {
        if (isMaxSizeSoftCapExceeded()) {
          if (this.mFree.mNumBytes == 0)
          {
            break label39;
            Preconditions.checkState(bool);
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  private void initBuckets(SparseIntArray paramSparseIntArray)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic 63	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_0
    //   10: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   13: invokevirtual 119	android/util/SparseArray:clear	()V
    //   16: aload_0
    //   17: getfield 71	com/facebook/imagepipeline/memory/BasePool:mPoolParams	Lcom/facebook/imagepipeline/memory/PoolParams;
    //   20: getfield 123	com/facebook/imagepipeline/memory/PoolParams:bucketSizes	Landroid/util/SparseIntArray;
    //   23: astore 6
    //   25: aload 6
    //   27: ifnull +74 -> 101
    //   30: iload_2
    //   31: aload 6
    //   33: invokevirtual 127	android/util/SparseIntArray:size	()I
    //   36: if_icmpge +57 -> 93
    //   39: aload 6
    //   41: iload_2
    //   42: invokevirtual 131	android/util/SparseIntArray:keyAt	(I)I
    //   45: istore_3
    //   46: aload 6
    //   48: iload_2
    //   49: invokevirtual 134	android/util/SparseIntArray:valueAt	(I)I
    //   52: istore 4
    //   54: aload_1
    //   55: iload_3
    //   56: iconst_0
    //   57: invokevirtual 138	android/util/SparseIntArray:get	(II)I
    //   60: istore 5
    //   62: aload_0
    //   63: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   66: iload_3
    //   67: new 140	com/facebook/imagepipeline/memory/Bucket
    //   70: dup
    //   71: aload_0
    //   72: iload_3
    //   73: invokevirtual 143	com/facebook/imagepipeline/memory/BasePool:getSizeInBytes	(I)I
    //   76: iload 4
    //   78: iload 5
    //   80: invokespecial 146	com/facebook/imagepipeline/memory/Bucket:<init>	(III)V
    //   83: invokevirtual 150	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -60 -> 30
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 152	com/facebook/imagepipeline/memory/BasePool:mAllowNewBuckets	Z
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: aload_0
    //   102: iconst_1
    //   103: putfield 152	com/facebook/imagepipeline/memory/BasePool:mAllowNewBuckets	Z
    //   106: goto -8 -> 98
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	BasePool
    //   0	114	1	paramSparseIntArray	SparseIntArray
    //   1	89	2	i	int
    //   45	28	3	j	int
    //   52	25	4	k	int
    //   60	19	5	m	int
    //   23	24	6	localSparseIntArray	SparseIntArray
    // Exception table:
    //   from	to	target	type
    //   4	25	109	finally
    //   30	86	109	finally
    //   93	98	109	finally
    //   101	106	109	finally
  }
  
  @SuppressLint({"InvalidAccessToGuardedField"})
  private void logStats()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
    }
  }
  
  protected abstract V alloc(int paramInt);
  
  @VisibleForTesting
  boolean canAllocate(int paramInt)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        int i = this.mPoolParams.maxSizeHardCap;
        if (paramInt > i - this.mUsed.mNumBytes)
        {
          this.mPoolStatsTracker.onHardCapReached();
          return bool;
        }
        int j = this.mPoolParams.maxSizeSoftCap;
        if (paramInt > j - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
          trimToSize(j - paramInt);
        }
        if (paramInt > i - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
          this.mPoolStatsTracker.onHardCapReached();
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  @VisibleForTesting
  protected abstract void free(V paramV);
  
  public V get(int paramInt)
  {
    ensurePoolSizeInvariant();
    paramInt = getBucketedSize(paramInt);
    Object localObject5;
    try
    {
      Bucket localBucket1 = getBucket(paramInt);
      if (localBucket1 != null)
      {
        localObject5 = localBucket1.get();
        if (localObject5 != null)
        {
          Preconditions.checkState(this.mInUseValues.add(localObject5));
          paramInt = getBucketedSizeForValue(localObject5);
          i = getSizeInBytes(paramInt);
          this.mUsed.increment(i);
          this.mFree.decrement(i);
          this.mPoolStatsTracker.onValueReuse(i);
          logStats();
          if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject5)), Integer.valueOf(paramInt));
          }
          return (V)localObject5;
        }
      }
      i = getSizeInBytes(paramInt);
      if (!canAllocate(i)) {
        throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, i);
      }
    }
    finally {}
    this.mUsed.increment(i);
    if (localObject1 != null) {
      ((Bucket)localObject1).incrementInUseCount();
    }
    Object localObject2 = null;
    try
    {
      localObject5 = alloc(paramInt);
      localObject2 = localObject5;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          this.mUsed.decrement(i);
          Bucket localBucket2 = getBucket(paramInt);
          if (localBucket2 == null) {
            break label301;
          }
          localBucket2.decrementInUseCount();
          Throwables.propagateIfPossible(localThrowable);
        }
        finally {}
      }
    }
    try
    {
      Preconditions.checkState(this.mInUseValues.add(localObject2));
      trimToSoftCap();
      this.mPoolStatsTracker.onAlloc(i);
      logStats();
      if (FLog.isLoggable(2)) {
        FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject2)), Integer.valueOf(paramInt));
      }
      return (V)localObject2;
    }
    finally {}
  }
  
  /* Error */
  @VisibleForTesting
  Bucket<V> getBucket(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual 270	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 140	com/facebook/imagepipeline/memory/Bucket
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 4
    //   20: ifnonnull +15 -> 35
    //   23: aload_0
    //   24: getfield 152	com/facebook/imagepipeline/memory/BasePool:mAllowNewBuckets	Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifne +10 -> 39
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: areturn
    //   39: iconst_2
    //   40: invokestatic 161	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   43: ifeq +17 -> 60
    //   46: aload_0
    //   47: getfield 57	com/facebook/imagepipeline/memory/BasePool:TAG	Ljava/lang/Class;
    //   50: ldc_w 272
    //   53: iload_1
    //   54: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: invokestatic 275	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   60: aload_0
    //   61: iload_1
    //   62: invokevirtual 278	com/facebook/imagepipeline/memory/BasePool:newBucket	(I)Lcom/facebook/imagepipeline/memory/Bucket;
    //   65: astore_3
    //   66: aload_0
    //   67: getfield 80	com/facebook/imagepipeline/memory/BasePool:mBuckets	Landroid/util/SparseArray;
    //   70: iload_1
    //   71: aload_3
    //   72: invokevirtual 150	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   75: goto -40 -> 35
    //   78: astore_3
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_3
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	BasePool
    //   0	83	1	paramInt	int
    //   27	2	2	bool	boolean
    //   17	55	3	localBucket1	Bucket
    //   78	4	3	localObject	Object
    //   13	20	4	localBucket2	Bucket
    // Exception table:
    //   from	to	target	type
    //   2	15	78	finally
    //   23	28	78	finally
    //   39	60	78	finally
    //   60	75	78	finally
  }
  
  protected abstract int getBucketedSize(int paramInt);
  
  protected abstract int getBucketedSizeForValue(V paramV);
  
  protected abstract int getSizeInBytes(int paramInt);
  
  public Map<String, Integer> getStats()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < this.mBuckets.size())
      {
        int j = this.mBuckets.keyAt(i);
        Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
        localHashMap.put("buckets_used_" + getSizeInBytes(j), Integer.valueOf(localBucket.getInUseCount()));
        i += 1;
      }
      localHashMap.put("soft_cap", Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
      localHashMap.put("hard_cap", Integer.valueOf(this.mPoolParams.maxSizeHardCap));
      localHashMap.put("used_count", Integer.valueOf(this.mUsed.mCount));
      localHashMap.put("used_bytes", Integer.valueOf(this.mUsed.mNumBytes));
      localHashMap.put("free_count", Integer.valueOf(this.mFree.mCount));
      localHashMap.put("free_bytes", Integer.valueOf(this.mFree.mNumBytes));
      return localHashMap;
    }
    finally {}
  }
  
  protected void initialize()
  {
    this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
    this.mPoolStatsTracker.setBasePool(this);
  }
  
  /* Error */
  @VisibleForTesting
  boolean isMaxSizeSoftCapExceeded()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 102	com/facebook/imagepipeline/memory/BasePool:mUsed	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   6: getfield 112	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   9: aload_0
    //   10: getfield 100	com/facebook/imagepipeline/memory/BasePool:mFree	Lcom/facebook/imagepipeline/memory/BasePool$Counter;
    //   13: getfield 112	com/facebook/imagepipeline/memory/BasePool$Counter:mNumBytes	I
    //   16: iadd
    //   17: aload_0
    //   18: getfield 71	com/facebook/imagepipeline/memory/BasePool:mPoolParams	Lcom/facebook/imagepipeline/memory/PoolParams;
    //   21: getfield 189	com/facebook/imagepipeline/memory/PoolParams:maxSizeSoftCap	I
    //   24: if_icmple +22 -> 46
    //   27: iconst_1
    //   28: istore_1
    //   29: iload_1
    //   30: ifeq +12 -> 42
    //   33: aload_0
    //   34: getfield 75	com/facebook/imagepipeline/memory/BasePool:mPoolStatsTracker	Lcom/facebook/imagepipeline/memory/PoolStatsTracker;
    //   37: invokeinterface 337 1 0
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: iconst_0
    //   47: istore_1
    //   48: goto -19 -> 29
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	BasePool
    //   28	20	1	bool	boolean
    //   51	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	51	finally
    //   33	42	51	finally
  }
  
  protected boolean isReusable(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    return true;
  }
  
  Bucket<V> newBucket(int paramInt)
  {
    return new Bucket(getSizeInBytes(paramInt), Integer.MAX_VALUE, 0);
  }
  
  protected void onParamsChanged() {}
  
  public void release(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    int i = getBucketedSizeForValue(paramV);
    int j = getSizeInBytes(i);
    for (;;)
    {
      try
      {
        Bucket localBucket = getBucket(i);
        if (!this.mInUseValues.remove(paramV))
        {
          FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[] { Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i) });
          free(paramV);
          this.mPoolStatsTracker.onFree(j);
          logStats();
          return;
        }
        if ((localBucket == null) || (localBucket.isMaxLengthExceeded()) || (isMaxSizeSoftCapExceeded()) || (!isReusable(paramV)))
        {
          if (localBucket != null) {
            localBucket.decrementInUseCount();
          }
          if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
          }
          free(paramV);
          this.mUsed.decrement(j);
          this.mPoolStatsTracker.onFree(j);
          continue;
        }
        localBucket.release(paramV);
      }
      finally {}
      this.mFree.increment(j);
      this.mUsed.decrement(j);
      this.mPoolStatsTracker.onValueRelease(j);
      if (FLog.isLoggable(2)) {
        FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
      }
    }
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    trimToNothing();
  }
  
  @VisibleForTesting
  void trimToNothing()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList(this.mBuckets.size());
    Object localObject2 = new SparseIntArray();
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject3;
        if (i < this.mBuckets.size())
        {
          localObject3 = (Bucket)this.mBuckets.valueAt(i);
          if (((Bucket)localObject3).getFreeListSize() > 0) {
            localArrayList.add(localObject3);
          }
          ((SparseIntArray)localObject2).put(this.mBuckets.keyAt(i), ((Bucket)localObject3).getInUseCount());
          i += 1;
        }
        else
        {
          initBuckets((SparseIntArray)localObject2);
          this.mFree.reset();
          logStats();
          onParamsChanged();
          i = j;
          if (i >= localArrayList.size()) {
            break;
          }
          localObject2 = (Bucket)localArrayList.get(i);
          localObject3 = ((Bucket)localObject2).pop();
          if (localObject3 == null) {
            i += 1;
          } else {
            free(localObject3);
          }
        }
      }
      finally {}
    }
  }
  
  @VisibleForTesting
  void trimToSize(int paramInt)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = Math.min(this.mUsed.mNumBytes + this.mFree.mNumBytes - paramInt, this.mFree.mNumBytes);
        if (j <= 0) {
          return;
        }
        if (FLog.isLoggable(2)) {
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(j));
        }
        logStats();
        i = 0;
        if ((i >= this.mBuckets.size()) || (j <= 0))
        {
          logStats();
          if (!FLog.isLoggable(2)) {
            continue;
          }
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
          continue;
        }
        localBucket = (Bucket)this.mBuckets.valueAt(i);
      }
      finally {}
      Bucket localBucket;
      while (j > 0)
      {
        Object localObject2 = localBucket.pop();
        if (localObject2 == null) {
          break;
        }
        free(localObject2);
        j -= localBucket.mItemSize;
        this.mFree.decrement(localBucket.mItemSize);
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  void trimToSoftCap()
  {
    try
    {
      if (isMaxSizeSoftCapExceeded()) {
        trimToSize(this.mPoolParams.maxSizeSoftCap);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  @NotThreadSafe
  static class Counter
  {
    private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
    int mCount;
    int mNumBytes;
    
    public void decrement(int paramInt)
    {
      if ((this.mNumBytes >= paramInt) && (this.mCount > 0))
      {
        this.mCount -= 1;
        this.mNumBytes -= paramInt;
        return;
      }
      FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount) });
    }
    
    public void increment(int paramInt)
    {
      this.mCount += 1;
      this.mNumBytes += paramInt;
    }
    
    public void reset()
    {
      this.mCount = 0;
      this.mNumBytes = 0;
    }
  }
  
  public static class InvalidSizeException
    extends RuntimeException
  {
    public InvalidSizeException(Object paramObject)
    {
      super();
    }
  }
  
  public static class InvalidValueException
    extends RuntimeException
  {
    public InvalidValueException(Object paramObject)
    {
      super();
    }
  }
  
  public static class PoolSizeViolationException
    extends RuntimeException
  {
    public PoolSizeViolationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }
  
  public static class SizeTooLargeException
    extends BasePool.InvalidSizeException
  {
    public SizeTooLargeException(Object paramObject)
    {
      super();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/memory/BasePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */