package com.g.a;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class ag
{
  private static final Map a = new ConcurrentHashMap();
  
  static Map a(Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      Map.Entry localEntry;
      HashSet localHashSet;
      try
      {
        Object localObject = paramObject.getClass();
        if (!a.containsKey(localObject)) {
          a((Class)localObject);
        }
        localObject = (Map)a.get(localObject);
        if ((localObject != null) && (!((Map)localObject).isEmpty()))
        {
          localObject = ((Map)localObject).entrySet().iterator();
          if (((Iterator)localObject).hasNext())
          {
            localEntry = (Map.Entry)((Iterator)localObject).next();
            localHashSet = new HashSet();
            Iterator localIterator = ((Set)localEntry.getValue()).iterator();
            if (!localIterator.hasNext()) {
              break label157;
            }
            localHashSet.add(new ah(paramObject, (Method)localIterator.next()));
            continue;
          }
        }
        return localHashMap;
      }
      catch (Throwable paramObject)
      {
        av.postSDKError((Throwable)paramObject);
      }
      label157:
      localHashMap.put(localEntry.getKey(), localHashSet);
    }
  }
  
  private static void a(Class paramClass)
  {
    for (;;)
    {
      int i;
      try
      {
        HashMap localHashMap = new HashMap();
        Method[] arrayOfMethod = paramClass.getDeclaredMethods();
        int j = arrayOfMethod.length;
        i = 0;
        if (i < j)
        {
          Method localMethod = arrayOfMethod[i];
          if ((localMethod.getName().startsWith("onTDEBEvent")) && (localMethod.getParameterTypes().length == 1))
          {
            Object localObject1 = localMethod.getParameterTypes();
            if (localObject1.length != 1) {
              h.eForInternal(new String[] { "Method " + localMethod + " must have one and only one argument." });
            }
            Object localObject2 = localObject1[0];
            if (((Class)localObject2).isInterface()) {
              h.eForInternal(new String[] { "Method " + localMethod + " must have a argument whose type is a class which can be instantialized." });
            }
            if ((localMethod.getModifiers() & 0x1) == 0) {
              h.eForInternal(new String[] { "Method " + localMethod + " must be 'public'." });
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
        }
        else
        {
          a.put(paramClass, localHashMap);
          return;
        }
      }
      catch (Throwable paramClass)
      {
        av.postSDKError(paramClass);
        return;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */