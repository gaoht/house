package com.g.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ad
{
  private static volatile ad a = null;
  private final ConcurrentMap b = new ConcurrentHashMap();
  private final ThreadLocal c = new ae(this);
  private final ThreadLocal d = new af(this);
  private final Map e = new HashMap();
  
  public static ad a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ad();
      }
      return a;
    }
    finally {}
  }
  
  private Set c(Class paramClass)
  {
    try
    {
      LinkedList localLinkedList = new LinkedList();
      HashSet localHashSet = new HashSet();
      localLinkedList.add(paramClass);
      while (!localLinkedList.isEmpty())
      {
        paramClass = (Class)localLinkedList.remove(0);
        localHashSet.add(paramClass);
        paramClass = paramClass.getSuperclass();
        if (paramClass != null) {
          localLinkedList.add(paramClass);
        }
      }
      return localHashSet;
    }
    catch (Throwable paramClass)
    {
      av.postSDKError(paramClass);
      return null;
    }
  }
  
  Set a(Class paramClass)
  {
    try
    {
      paramClass = (Set)this.b.get(paramClass);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      av.postSDKError(paramClass);
    }
    return null;
  }
  
  protected void a(Object paramObject, ah paramah)
  {
    try
    {
      ((ConcurrentLinkedQueue)this.c.get()).offer(new a(paramObject, paramah));
      return;
    }
    catch (Throwable paramObject)
    {
      av.postSDKError((Throwable)paramObject);
    }
  }
  
  Set b(Class paramClass)
  {
    try
    {
      Set localSet2 = (Set)this.e.get(paramClass);
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = c(paramClass);
        this.e.put(paramClass, localSet1);
      }
      return localSet1;
    }
    catch (Throwable paramClass)
    {
      av.postSDKError(paramClass);
    }
    return null;
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/g/a/ad:d	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 97	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 115	java/lang/Boolean
    //   10: invokevirtual 118	java/lang/Boolean:booleanValue	()Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +15 -> 30
    //   18: aload_0
    //   19: getfield 40	com/g/a/ad:d	Ljava/lang/ThreadLocal;
    //   22: iconst_0
    //   23: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: invokevirtual 126	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   29: return
    //   30: aload_0
    //   31: getfield 40	com/g/a/ad:d	Ljava/lang/ThreadLocal;
    //   34: iconst_1
    //   35: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: invokevirtual 126	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   41: aload_0
    //   42: getfield 35	com/g/a/ad:c	Ljava/lang/ThreadLocal;
    //   45: invokevirtual 97	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   48: checkcast 99	java/util/concurrent/ConcurrentLinkedQueue
    //   51: invokevirtual 129	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   54: checkcast 6	com/g/a/ad$a
    //   57: astore_2
    //   58: aload_2
    //   59: ifnonnull +15 -> 74
    //   62: aload_0
    //   63: getfield 40	com/g/a/ad:d	Ljava/lang/ThreadLocal;
    //   66: iconst_0
    //   67: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: invokevirtual 126	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   73: return
    //   74: aload_2
    //   75: getfield 132	com/g/a/ad$a:b	Lcom/g/a/ah;
    //   78: invokevirtual 136	com/g/a/ah:a	()Z
    //   81: ifeq -40 -> 41
    //   84: aload_0
    //   85: aload_2
    //   86: getfield 139	com/g/a/ad$a:a	Ljava/lang/Object;
    //   89: aload_2
    //   90: getfield 132	com/g/a/ad$a:b	Lcom/g/a/ah;
    //   93: invokevirtual 141	com/g/a/ad:b	(Ljava/lang/Object;Lcom/g/a/ah;)V
    //   96: goto -55 -> 41
    //   99: astore_2
    //   100: aload_0
    //   101: getfield 40	com/g/a/ad:d	Ljava/lang/ThreadLocal;
    //   104: iconst_0
    //   105: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   108: invokevirtual 126	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   111: aload_2
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ad
    //   13	2	1	bool	boolean
    //   57	33	2	locala	a
    //   99	13	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	14	99	finally
    //   30	41	99	finally
    //   41	58	99	finally
    //   74	96	99	finally
  }
  
  protected void b(Object paramObject, ah paramah)
  {
    try
    {
      paramah.handleEvent(paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      av.postSDKError((Throwable)paramObject);
    }
  }
  
  public void post(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    int j;
    for (;;)
    {
      try
      {
        Object localObject1 = b(paramObject.getClass());
        j = 0;
        localObject1 = ((Set)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = a((Class)((Iterator)localObject1).next());
        int i = j;
        if (localObject2 != null)
        {
          i = j;
          if (!((Set)localObject2).isEmpty())
          {
            j = 1;
            localObject2 = ((Set)localObject2).iterator();
            i = j;
            if (((Iterator)localObject2).hasNext())
            {
              a(paramObject, (ah)((Iterator)localObject2).next());
              continue;
            }
          }
        }
        j = i;
      }
      catch (Throwable paramObject)
      {
        av.postSDKError((Throwable)paramObject);
        return;
      }
    }
    if ((j == 0) && (!(paramObject instanceof ai))) {
      post(new ai(this, paramObject));
    }
    b();
  }
  
  public void register(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      try
      {
        Map localMap = ag.a(paramObject);
        Iterator localIterator = localMap.keySet().iterator();
        boolean bool;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          Class localClass = (Class)localIterator.next();
          Object localObject = (Set)this.b.get(localClass);
          paramObject = localObject;
          if (localObject == null)
          {
            localObject = new CopyOnWriteArraySet();
            Set localSet = (Set)this.b.putIfAbsent(localClass, localObject);
            paramObject = localSet;
            if (localSet == null) {
              paramObject = localObject;
            }
          }
          bool = ((Set)paramObject).addAll((Set)localMap.get(localClass));
        } while (bool);
        return;
      }
      catch (Throwable paramObject)
      {
        av.postSDKError((Throwable)paramObject);
      }
    }
  }
  
  public void unregister(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramObject = ag.a(paramObject).entrySet().iterator();
        if (!((Iterator)paramObject).hasNext()) {
          break;
        }
        Object localObject = (Map.Entry)((Iterator)paramObject).next();
        Set localSet = a((Class)((Map.Entry)localObject).getKey());
        localObject = (Collection)((Map.Entry)localObject).getValue();
        if ((localSet == null) || (!localSet.containsAll((Collection)localObject))) {
          break;
        }
        Iterator localIterator = localSet.iterator();
        if (localIterator.hasNext())
        {
          ah localah = (ah)localIterator.next();
          if (((Collection)localObject).contains(localah)) {
            localah.b();
          }
        }
        else
        {
          localSet.removeAll((Collection)localObject);
        }
      }
      catch (Throwable paramObject)
      {
        av.postSDKError((Throwable)paramObject);
        return;
      }
    }
  }
  
  static class a
  {
    final Object a;
    final ah b;
    
    public a(Object paramObject, ah paramah)
    {
      this.a = paramObject;
      this.b = paramah;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */