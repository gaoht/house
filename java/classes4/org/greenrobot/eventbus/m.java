package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.a.a;
import org.greenrobot.eventbus.a.b;

class m
{
  private static final Map<Class<?>, List<l>> a = new ConcurrentHashMap();
  private static final a[] e = new a[4];
  private List<b> b;
  private final boolean c;
  private final boolean d;
  
  m(List<b> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramList;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  private List<l> a(a parama)
  {
    ArrayList localArrayList = new ArrayList(parama.a);
    parama.a();
    a[] arrayOfa = e;
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        if (e[i] == null)
        {
          e[i] = parama;
          return localArrayList;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  static void a()
  {
    a.clear();
  }
  
  private List<l> b(Class<?> paramClass)
  {
    a locala = b();
    locala.a(paramClass);
    while (locala.f != null)
    {
      locala.h = b(locala);
      if (locala.h != null)
      {
        paramClass = locala.h.getSubscriberMethods();
        int j = paramClass.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramClass[i];
          if (locala.a(((l)localObject).a, ((l)localObject).c)) {
            locala.a.add(localObject);
          }
          i += 1;
        }
      }
      c(locala);
      locala.b();
    }
    return a(locala);
  }
  
  private a b(a parama)
  {
    Object localObject;
    if ((parama.h != null) && (parama.h.getSuperSubscriberInfo() != null))
    {
      localObject = parama.h.getSuperSubscriberInfo();
      if (parama.f == ((a)localObject).getSubscriberClass()) {
        return (a)localObject;
      }
    }
    if (this.b != null)
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = ((b)((Iterator)localObject).next()).getSubscriberInfo(parama.f);
        if (locala != null) {
          return locala;
        }
      }
    }
    return null;
  }
  
  private a b()
  {
    a[] arrayOfa = e;
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        a locala = e[i];
        if (locala == null) {
          break label48;
        }
        e[i] = null;
        return locala;
      }
      finally {}
      return new a();
      label48:
      i += 1;
    }
  }
  
  private List<l> c(Class<?> paramClass)
  {
    a locala = b();
    locala.a(paramClass);
    while (locala.f != null)
    {
      c(locala);
      locala.b();
    }
    return a(locala);
  }
  
  private void c(a parama)
  {
    Method localMethod;
    label259:
    do
    {
      try
      {
        Method[] arrayOfMethod1 = parama.f.getDeclaredMethods();
        int j = arrayOfMethod1.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            return;
          }
          localMethod = arrayOfMethod1[i];
          int k = localMethod.getModifiers();
          if (((k & 0x1) == 0) || ((k & 0x1448) != 0)) {
            break label259;
          }
          localObject = localMethod.getParameterTypes();
          if (localObject.length != 1) {
            break;
          }
          j localj = (j)localMethod.getAnnotation(j.class);
          if (localj != null)
          {
            localObject = localObject[0];
            if (parama.a(localMethod, (Class)localObject))
            {
              ThreadMode localThreadMode = localj.threadMode();
              parama.a.add(new l(localMethod, (Class)localObject, localThreadMode, localj.priority(), localj.sticky()));
            }
          }
          i += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        do
        {
          for (;;)
          {
            Method[] arrayOfMethod2 = parama.f.getMethods();
            parama.g = true;
          }
        } while ((!this.c) || (!localMethod.isAnnotationPresent(j.class)));
        parama = localMethod.getDeclaringClass().getName() + "." + localMethod.getName();
        throw new e("@Subscribe method " + parama + "must have exactly 1 parameter but has " + localObject.length);
      }
    } while ((!this.c) || (!localMethod.isAnnotationPresent(j.class)));
    parama = localMethod.getDeclaringClass().getName() + "." + localMethod.getName();
    throw new e(parama + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
  }
  
  List<l> a(Class<?> paramClass)
  {
    List localList = (List)a.get(paramClass);
    if (localList != null) {
      return localList;
    }
    if (this.d) {}
    for (localList = c(paramClass); localList.isEmpty(); localList = b(paramClass)) {
      throw new e("Subscriber " + paramClass + " and its super classes have no public methods with the @Subscribe annotation");
    }
    a.put(paramClass, localList);
    return localList;
  }
  
  static class a
  {
    final List<l> a = new ArrayList();
    final Map<Class, Object> b = new HashMap();
    final Map<String, Class> c = new HashMap();
    final StringBuilder d = new StringBuilder(128);
    Class<?> e;
    Class<?> f;
    boolean g;
    a h;
    
    private boolean b(Method paramMethod, Class<?> paramClass)
    {
      this.d.setLength(0);
      this.d.append(paramMethod.getName());
      this.d.append('>').append(paramClass.getName());
      paramClass = this.d.toString();
      paramMethod = paramMethod.getDeclaringClass();
      Class localClass = (Class)this.c.put(paramClass, paramMethod);
      if ((localClass == null) || (localClass.isAssignableFrom(paramMethod))) {
        return true;
      }
      this.c.put(paramClass, localClass);
      return false;
    }
    
    void a()
    {
      this.a.clear();
      this.b.clear();
      this.c.clear();
      this.d.setLength(0);
      this.e = null;
      this.f = null;
      this.g = false;
      this.h = null;
    }
    
    void a(Class<?> paramClass)
    {
      this.f = paramClass;
      this.e = paramClass;
      this.g = false;
      this.h = null;
    }
    
    boolean a(Method paramMethod, Class<?> paramClass)
    {
      Object localObject = this.b.put(paramClass, paramMethod);
      if (localObject == null) {
        return true;
      }
      if ((localObject instanceof Method))
      {
        if (!b((Method)localObject, paramClass)) {
          throw new IllegalStateException();
        }
        this.b.put(paramClass, this);
      }
      return b(paramMethod, paramClass);
    }
    
    void b()
    {
      if (this.g) {
        this.f = null;
      }
      String str;
      do
      {
        return;
        this.f = this.f.getSuperclass();
        str = this.f.getName();
      } while ((!str.startsWith("java.")) && (!str.startsWith("javax.")) && (!str.startsWith("android.")));
      this.f = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */