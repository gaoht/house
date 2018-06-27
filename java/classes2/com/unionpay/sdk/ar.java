package com.unionpay.sdk;

import java.lang.reflect.InvocationTargetException;
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

final class ar
{
  private static volatile ar a = null;
  private final ConcurrentMap b = new ConcurrentHashMap();
  private final ThreadLocal c = new as(this);
  private final ThreadLocal d = new at(this);
  private final Map e = new HashMap();
  
  public static ar a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ar();
      }
      return a;
    }
    finally {}
  }
  
  private Set a(Class paramClass)
  {
    return (Set)this.b.get(paramClass);
  }
  
  private static Set b(Class paramClass)
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
  
  private void b()
  {
    if (((Boolean)this.d.get()).booleanValue()) {
      return;
    }
    this.d.set(Boolean.valueOf(true));
    Object localObject1;
    try
    {
      Object localObject2;
      for (;;)
      {
        a locala = (a)((ConcurrentLinkedQueue)this.c.get()).poll();
        if (locala == null) {
          break label250;
        }
        if (locala.b.a())
        {
          localObject1 = locala.a;
          localObject2 = locala.b;
          try
          {
            if ((ag.a) && ((localObject1 instanceof ag.a))) {
              k.b(new String[] { "[dispatch] ", String.valueOf(((ag.a)localObject1).a.get("apiType")), ((av)localObject2).toString() });
            }
            ((av)localObject2).handleEvent(localObject1);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localObject1 = "Could not dispatch event: " + localObject1.getClass() + " to handler " + localObject2;
            localObject2 = localInvocationTargetException.getCause();
            if (localObject2 == null) {
              break label215;
            }
          }
        }
      }
      throw new RuntimeException((String)localObject1 + ": " + ((Throwable)localObject2).getMessage(), (Throwable)localObject2);
    }
    finally
    {
      this.d.set(Boolean.valueOf(false));
    }
    label215:
    throw new RuntimeException((String)localObject1 + ": " + localThrowable.getMessage(), localThrowable);
    label250:
    this.d.set(Boolean.valueOf(false));
  }
  
  public final void post(Object paramObject)
  {
    int i = 0;
    if (ag.a)
    {
      k.b(new String[] { "[post] ", paramObject.getClass().getName() });
      if ((paramObject instanceof ag.a)) {
        k.b(new String[] { "[post] ", String.valueOf(((ag.a)paramObject).a.get("apiType")) });
      }
    }
    if (paramObject == null) {
      throw new NullPointerException("Event to post must not be null.");
    }
    Object localObject3 = paramObject.getClass();
    Object localObject2 = (Set)this.e.get(localObject3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = b((Class)localObject3);
      this.e.put(localObject3, localObject1);
    }
    localObject1 = ((Set)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = a((Class)((Iterator)localObject1).next());
      if ((localObject2 != null) && (!((Set)localObject2).isEmpty()))
      {
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (av)((Iterator)localObject2).next();
          ((ConcurrentLinkedQueue)this.c.get()).offer(new a(paramObject, (av)localObject3));
        }
      }
    }
    for (;;)
    {
      break;
      if ((i == 0) && (!(paramObject instanceof aw))) {
        post(new aw(this, paramObject));
      }
      b();
      return;
      i = 1;
    }
  }
  
  public final void register(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Object to register must not be null.");
    }
    Map localMap = au.a(paramObject);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
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
      if (!((Set)paramObject).addAll((Set)localMap.get(localClass))) {
        throw new IllegalArgumentException("Object already registered.");
      }
    }
  }
  
  public final void unregister(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Object to unregister must not be null.");
    }
    Iterator localIterator1 = au.a(paramObject).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (Map.Entry)localIterator1.next();
      Set localSet = a((Class)((Map.Entry)localObject).getKey());
      localObject = (Collection)((Map.Entry)localObject).getValue();
      if ((localSet == null) || (!localSet.containsAll((Collection)localObject))) {
        throw new IllegalArgumentException("Missing event handler for a method. Is " + paramObject.getClass() + " registered?");
      }
      Iterator localIterator2 = localSet.iterator();
      while (localIterator2.hasNext())
      {
        av localav = (av)localIterator2.next();
        if (((Collection)localObject).contains(localav)) {
          localav.b();
        }
      }
      localSet.removeAll((Collection)localObject);
    }
  }
  
  static final class a
  {
    final Object a;
    final av b;
    
    public a(Object paramObject, av paramav)
    {
      this.a = paramObject;
      this.b = paramav;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */