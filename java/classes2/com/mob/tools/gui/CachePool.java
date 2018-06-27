package com.mob.tools.gui;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.Iterator;
import java.util.LinkedList;

public class CachePool<K, V>
{
  private int capacity;
  private OnRemoveListener<K, V> listener;
  private LinkedList<CachePool<K, V>.Node<K, V>> pool;
  private int poolSize;
  
  public CachePool(int paramInt)
  {
    this.capacity = paramInt;
    this.pool = new LinkedList();
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/mob/tools/gui/CachePool:pool	Ljava/util/LinkedList;
    //   6: ifnull +29 -> 35
    //   9: aload_0
    //   10: getfield 29	com/mob/tools/gui/CachePool:capacity	I
    //   13: ifle +22 -> 35
    //   16: aload_0
    //   17: getfield 38	com/mob/tools/gui/CachePool:listener	Lcom/mob/tools/gui/CachePool$OnRemoveListener;
    //   20: ifnonnull +18 -> 38
    //   23: aload_0
    //   24: getfield 34	com/mob/tools/gui/CachePool:pool	Ljava/util/LinkedList;
    //   27: invokevirtual 40	java/util/LinkedList:clear	()V
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 42	com/mob/tools/gui/CachePool:poolSize	I
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 34	com/mob/tools/gui/CachePool:pool	Ljava/util/LinkedList;
    //   42: invokevirtual 46	java/util/LinkedList:size	()I
    //   45: ifle -15 -> 30
    //   48: aload_0
    //   49: getfield 34	com/mob/tools/gui/CachePool:pool	Ljava/util/LinkedList;
    //   52: invokevirtual 50	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   55: checkcast 9	com/mob/tools/gui/CachePool$Node
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull -22 -> 38
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 42	com/mob/tools/gui/CachePool:poolSize	I
    //   68: aload_1
    //   69: invokestatic 54	com/mob/tools/gui/CachePool$Node:access$200	(Lcom/mob/tools/gui/CachePool$Node;)I
    //   72: isub
    //   73: putfield 42	com/mob/tools/gui/CachePool:poolSize	I
    //   76: aload_0
    //   77: getfield 38	com/mob/tools/gui/CachePool:listener	Lcom/mob/tools/gui/CachePool$OnRemoveListener;
    //   80: ifnull -42 -> 38
    //   83: aload_0
    //   84: getfield 38	com/mob/tools/gui/CachePool:listener	Lcom/mob/tools/gui/CachePool$OnRemoveListener;
    //   87: aload_1
    //   88: getfield 58	com/mob/tools/gui/CachePool$Node:key	Ljava/lang/Object;
    //   91: aload_1
    //   92: getfield 61	com/mob/tools/gui/CachePool$Node:value	Ljava/lang/Object;
    //   95: invokeinterface 65 3 0
    //   100: goto -62 -> 38
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	CachePool
    //   58	34	1	localNode	Node
    //   103	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	103	finally
    //   30	35	103	finally
    //   38	59	103	finally
    //   63	100	103	finally
  }
  
  public V get(K paramK)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (this.pool != null)
        {
          int i = this.capacity;
          if (i > 0) {
            try
            {
              if (this.poolSize <= this.capacity) {
                continue;
              }
              localObject = (Node)this.pool.removeLast();
              if (localObject == null) {
                continue;
              }
              this.poolSize -= ((Node)localObject).size;
              if (this.listener == null) {
                continue;
              }
              this.listener.onRemove(((Node)localObject).key, ((Node)localObject).value);
              continue;
              paramK = null;
            }
            catch (Throwable paramK)
            {
              MobLog.getInstance().w(paramK);
            }
          }
        }
        return paramK;
      }
      finally {}
      Iterator localIterator = this.pool.iterator();
      if (localIterator.hasNext())
      {
        Node localNode = (Node)localIterator.next();
        if (localNode != null)
        {
          if (paramK == null)
          {
            localObject = localNode;
            if (localNode.key == null) {}
          }
          else
          {
            if ((paramK == null) || (!paramK.equals(localNode.key))) {
              continue;
            }
            localObject = localNode;
          }
          if (localObject != null)
          {
            this.pool.set(0, localObject);
            Node.access$102((Node)localObject, System.currentTimeMillis());
            paramK = ((Node)localObject).value;
          }
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public boolean put(K paramK, V paramV)
  {
    try
    {
      boolean bool = put(paramK, paramV, 1);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public boolean put(K paramK, V paramV, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.pool != null)
        {
          int i = this.capacity;
          if (i > 0) {
            try
            {
              Node localNode = new Node(null);
              localNode.key = paramK;
              localNode.value = paramV;
              Node.access$102(localNode, System.currentTimeMillis());
              Node.access$202(localNode, paramInt);
              this.pool.add(0, localNode);
              this.poolSize += paramInt;
              if (this.poolSize <= this.capacity) {
                continue;
              }
              paramK = (Node)this.pool.removeLast();
              if (paramK == null) {
                continue;
              }
              this.poolSize -= paramK.size;
              if (this.listener == null) {
                continue;
              }
              this.listener.onRemove(paramK.key, paramK.value);
              continue;
              bool = false;
            }
            catch (Throwable paramK)
            {
              MobLog.getInstance().w(paramK);
            }
          }
        }
        return bool;
      }
      finally {}
      boolean bool = true;
    }
  }
  
  public void setOnRemoveListener(OnRemoveListener<K, V> paramOnRemoveListener)
  {
    this.listener = paramOnRemoveListener;
  }
  
  public int size()
  {
    try
    {
      int i = this.poolSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void trimBeforeTime(long paramLong)
  {
    int i;
    try
    {
      if ((this.pool != null) && (this.capacity > 0))
      {
        i = this.pool.size() - 1;
        Node localNode;
        if (i >= 0)
        {
          if (((Node)this.pool.get(i)).cacheTime >= paramLong) {
            break label194;
          }
          localNode = (Node)this.pool.remove(i);
          if (localNode == null) {
            break label191;
          }
          this.poolSize -= localNode.size;
          if (this.listener == null) {
            break label191;
          }
          this.listener.onRemove(localNode.key, localNode.value);
          break label191;
        }
        while (this.poolSize > this.capacity)
        {
          localNode = (Node)this.pool.removeLast();
          if (localNode != null)
          {
            this.poolSize -= localNode.size;
            if (this.listener != null) {
              this.listener.onRemove(localNode.key, localNode.value);
            }
          }
        }
      }
    }
    finally {}
    return;
    for (;;)
    {
      label191:
      break;
      label194:
      i -= 1;
    }
  }
  
  private class Node<K, V>
  {
    private long cacheTime;
    public K key;
    private int size;
    public V value;
    
    private Node() {}
  }
  
  public static abstract interface OnRemoveListener<K, V>
  {
    public abstract void onRemove(K paramK, V paramV);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/CachePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */