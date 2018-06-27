package com.alibaba.fastjson.util;

public class IdentityHashMap<K, V>
{
  private final Entry<K, V>[] buckets;
  private final int indexMask;
  
  public IdentityHashMap()
  {
    this(1024);
  }
  
  public IdentityHashMap(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.buckets = new Entry[paramInt];
  }
  
  public final V get(K paramK)
  {
    int i = System.identityHashCode(paramK);
    int j = this.indexMask;
    for (Entry localEntry = this.buckets[(i & j)]; localEntry != null; localEntry = localEntry.next) {
      if (paramK == localEntry.key) {
        return (V)localEntry.value;
      }
    }
    return null;
  }
  
  public boolean put(K paramK, V paramV)
  {
    int i = System.identityHashCode(paramK);
    int j = i & this.indexMask;
    for (Entry localEntry = this.buckets[j]; localEntry != null; localEntry = localEntry.next) {
      if (paramK == localEntry.key)
      {
        localEntry.value = paramV;
        return true;
      }
    }
    paramK = new Entry(paramK, paramV, i, this.buckets[j]);
    this.buckets[j] = paramK;
    return false;
  }
  
  protected static final class Entry<K, V>
  {
    public final int hashCode;
    public final K key;
    public final Entry<K, V> next;
    public V value;
    
    public Entry(K paramK, V paramV, int paramInt, Entry<K, V> paramEntry)
    {
      this.key = paramK;
      this.value = paramV;
      this.next = paramEntry;
      this.hashCode = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/IdentityHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */