package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingLruMap<K, V>
{
  @GuardedBy("this")
  private final LinkedHashMap<K, V> mMap = new LinkedHashMap();
  @GuardedBy("this")
  private int mSizeInBytes = 0;
  private final ValueDescriptor<V> mValueDescriptor;
  
  public CountingLruMap(ValueDescriptor<V> paramValueDescriptor)
  {
    this.mValueDescriptor = paramValueDescriptor;
  }
  
  private int getValueSizeInBytes(V paramV)
  {
    if (paramV == null) {
      return 0;
    }
    return this.mValueDescriptor.getSizeInBytes(paramV);
  }
  
  public ArrayList<V> clear()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      this.mSizeInBytes = 0;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean contains(K paramK)
  {
    try
    {
      boolean bool = this.mMap.containsKey(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @Nullable
  public V get(K paramK)
  {
    try
    {
      paramK = this.mMap.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public int getCount()
  {
    try
    {
      int i = this.mMap.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  @Nullable
  public K getFirstKey()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/facebook/imagepipeline/cache/CountingLruMap:mMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 80	java/util/LinkedHashMap:isEmpty	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_2
    //   19: areturn
    //   20: aload_0
    //   21: getfield 27	com/facebook/imagepipeline/cache/CountingLruMap:mMap	Ljava/util/LinkedHashMap;
    //   24: invokevirtual 84	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   27: invokeinterface 90 1 0
    //   32: invokeinterface 95 1 0
    //   37: astore_2
    //   38: goto -22 -> 16
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	CountingLruMap
    //   9	2	1	bool	boolean
    //   15	23	2	localObject1	Object
    //   41	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	41	finally
    //   20	38	41	finally
  }
  
  @VisibleForTesting
  ArrayList<K> getKeys()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.keySet());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> paramPredicate)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList(this.mMap.entrySet().size());
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey()))) {
          localArrayList.add(localEntry);
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public int getSizeInBytes()
  {
    try
    {
      int i = this.mSizeInBytes;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  ArrayList<V> getValues()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public V put(K paramK, V paramV)
  {
    try
    {
      Object localObject = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(localObject);
      this.mMap.put(paramK, paramV);
      this.mSizeInBytes += getValueSizeInBytes(paramV);
      return (V)localObject;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  @Nullable
  public V remove(K paramK)
  {
    try
    {
      paramK = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public ArrayList<V> removeAll(@Nullable Predicate<K> paramPredicate)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey())))
        {
          localArrayList.add(localEntry.getValue());
          this.mSizeInBytes -= getValueSizeInBytes(localEntry.getValue());
          localIterator.remove();
        }
      }
    }
    finally {}
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/CountingLruMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */