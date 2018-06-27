package com.unionpay.sdk;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class au
{
  private static final Map a = new HashMap();
  
  static Map a(Object paramObject)
  {
    Object localObject = paramObject.getClass();
    HashMap localHashMap = new HashMap();
    if (!a.containsKey(localObject)) {
      a((Class)localObject);
    }
    localObject = (Map)a.get(localObject);
    if (!((Map)localObject).isEmpty())
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = ((Set)localEntry.getValue()).iterator();
        while (localIterator.hasNext()) {
          localHashSet.add(new av(paramObject, (Method)localIterator.next()));
        }
        localHashMap.put(localEntry.getKey(), localHashSet);
      }
    }
    return localHashMap;
  }
  
  private static void a(Class paramClass)
  {
    HashMap localHashMap = new HashMap();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if ((localMethod.getName().startsWith("onTDEBEvent")) && (localMethod.getParameterTypes().length == 1))
      {
        Object localObject1 = localMethod.getParameterTypes();
        if (localObject1.length != 1) {
          throw new IllegalArgumentException("Method " + localMethod + " must have one and only one argument.");
        }
        Object localObject2 = localObject1[0];
        if (((Class)localObject2).isInterface()) {
          throw new IllegalArgumentException("Method " + localMethod + " must have a argument whose type is a class which can be instantialized.");
        }
        if ((localMethod.getModifiers() & 0x1) == 0) {
          throw new IllegalArgumentException("Method " + localMethod + " must be 'public'.");
        }
        Set localSet = (Set)localHashMap.get(localObject2);
        localObject1 = localSet;
        if (localSet == null)
        {
          localObject1 = new HashSet();
          localHashMap.put(localObject2, localObject1);
        }
        ((Set)localObject1).add(localMethod);
      }
      i += 1;
    }
    a.put(paramClass, localHashMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */