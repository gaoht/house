package org.greenrobot.eventbus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class c
{
  public static String a = "EventBus";
  static volatile c b;
  private static final d c = new d();
  private static final Map<Class<?>, List<Class<?>>> d = new HashMap();
  private final Map<Class<?>, CopyOnWriteArrayList<n>> e = new HashMap();
  private final Map<Object, List<Class<?>>> f = new HashMap();
  private final Map<Class<?>, Object> g = new ConcurrentHashMap();
  private final ThreadLocal<a> h = new ThreadLocal()
  {
    protected c.a a()
    {
      return new c.a();
    }
  };
  private final f i = new f(this, Looper.getMainLooper(), 10);
  private final b j = new b(this);
  private final a k = new a(this);
  private final m l;
  private final ExecutorService m;
  private final boolean n;
  private final boolean o;
  private final boolean p;
  private final boolean q;
  private final boolean r;
  private final boolean s;
  private final int t;
  
  public c()
  {
    this(c);
  }
  
  c(d paramd)
  {
    if (paramd.k != null) {}
    for (int i1 = paramd.k.size();; i1 = 0)
    {
      this.t = i1;
      this.l = new m(paramd.k, paramd.h, paramd.g);
      this.o = paramd.a;
      this.p = paramd.b;
      this.q = paramd.c;
      this.r = paramd.d;
      this.n = paramd.e;
      this.s = paramd.f;
      this.m = paramd.i;
      return;
    }
  }
  
  private static List<Class<?>> a(Class<?> paramClass)
  {
    synchronized (d)
    {
      Object localObject2 = (List)d.get(paramClass);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        for (localObject1 = paramClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass())
        {
          ((List)localObject2).add(localObject1);
          a((List)localObject2, ((Class)localObject1).getInterfaces());
        }
        d.put(paramClass, localObject2);
        localObject1 = localObject2;
      }
      return (List<Class<?>>)localObject1;
    }
  }
  
  private void a(Object paramObject, Class<?> paramClass)
  {
    paramClass = (List)this.e.get(paramClass);
    int i2;
    if (paramClass != null)
    {
      int i1 = paramClass.size();
      i2 = 0;
      if (i2 < i1)
      {
        n localn = (n)paramClass.get(i2);
        if (localn.a != paramObject) {
          break label91;
        }
        localn.c = false;
        paramClass.remove(i2);
        i2 -= 1;
        i1 -= 1;
      }
    }
    label91:
    for (;;)
    {
      i2 += 1;
      break;
      return;
    }
  }
  
  private void a(Object paramObject, a parama)
    throws Error
  {
    Class localClass = paramObject.getClass();
    boolean bool;
    if (this.s)
    {
      List localList = a(localClass);
      int i2 = localList.size();
      int i1 = 0;
      bool = false;
      while (i1 < i2)
      {
        bool |= a(paramObject, parama, (Class)localList.get(i1));
        i1 += 1;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (this.p) {
          Log.d(a, "No subscribers registered for event " + localClass);
        }
        if ((this.r) && (localClass != g.class) && (localClass != k.class)) {
          post(new g(this, paramObject));
        }
      }
      return;
      bool = a(paramObject, parama, localClass);
    }
  }
  
  private void a(Object paramObject, l paraml)
  {
    Class localClass = paraml.c;
    n localn = new n(paramObject, paraml);
    Object localObject = (CopyOnWriteArrayList)this.e.get(localClass);
    if (localObject == null)
    {
      localObject = new CopyOnWriteArrayList();
      this.e.put(localClass, localObject);
    }
    label324:
    label325:
    for (;;)
    {
      int i2 = ((CopyOnWriteArrayList)localObject).size();
      int i1 = 0;
      for (;;)
      {
        if (i1 <= i2)
        {
          if ((i1 == i2) || (paraml.d > ((n)((CopyOnWriteArrayList)localObject).get(i1)).b.d)) {
            ((CopyOnWriteArrayList)localObject).add(i1, localn);
          }
        }
        else
        {
          List localList = (List)this.f.get(paramObject);
          localObject = localList;
          if (localList == null)
          {
            localObject = new ArrayList();
            this.f.put(paramObject, localObject);
          }
          ((List)localObject).add(localClass);
          if (!paraml.e) {
            break label324;
          }
          if (!this.s) {
            break;
          }
          paramObject = this.g.entrySet().iterator();
          while (((Iterator)paramObject).hasNext())
          {
            paraml = (Map.Entry)((Iterator)paramObject).next();
            if (localClass.isAssignableFrom((Class)paraml.getKey())) {
              b(localn, paraml.getValue());
            }
          }
          if (!((CopyOnWriteArrayList)localObject).contains(localn)) {
            break label325;
          }
          throw new e("Subscriber " + paramObject.getClass() + " already registered to event " + localClass);
        }
        i1 += 1;
      }
      b(localn, this.g.get(localClass));
      return;
    }
  }
  
  static void a(List<Class<?>> paramList, Class<?>[] paramArrayOfClass)
  {
    int i2 = paramArrayOfClass.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Class<?> localClass = paramArrayOfClass[i1];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        a(paramList, localClass.getInterfaces());
      }
      i1 += 1;
    }
  }
  
  private void a(n paramn, Object paramObject, Throwable paramThrowable)
  {
    if ((paramObject instanceof k)) {
      if (this.o)
      {
        Log.e(a, "SubscriberExceptionEvent subscriber " + paramn.a.getClass() + " threw an exception", paramThrowable);
        paramn = (k)paramObject;
        Log.e(a, "Initial event " + paramn.c + " caused exception in " + paramn.d, paramn.b);
      }
    }
    do
    {
      return;
      if (this.n) {
        throw new e("Invoking subscriber failed", paramThrowable);
      }
      if (this.o) {
        Log.e(a, "Could not dispatch event: " + paramObject.getClass() + " to subscribing class " + paramn.a.getClass(), paramThrowable);
      }
    } while (!this.q);
    post(new k(this, paramThrowable, paramObject, paramn.a));
  }
  
  private void a(n paramn, Object paramObject, boolean paramBoolean)
  {
    switch (2.a[paramn.b.b.ordinal()])
    {
    default: 
      throw new IllegalStateException("Unknown thread mode: " + paramn.b.b);
    case 1: 
      a(paramn, paramObject);
      return;
    case 2: 
      if (paramBoolean)
      {
        a(paramn, paramObject);
        return;
      }
      this.i.a(paramn, paramObject);
      return;
    case 3: 
      if (paramBoolean)
      {
        this.j.enqueue(paramn, paramObject);
        return;
      }
      a(paramn, paramObject);
      return;
    }
    this.k.enqueue(paramn, paramObject);
  }
  
  private boolean a(Object paramObject, a parama, Class<?> paramClass)
  {
    try
    {
      paramClass = (CopyOnWriteArrayList)this.e.get(paramClass);
      if ((paramClass == null) || (paramClass.isEmpty())) {
        break label127;
      }
      paramClass = paramClass.iterator();
    }
    finally
    {
      try
      {
        boolean bool;
        do
        {
          n localn;
          a(localn, paramObject, parama.c);
          bool = parama.f;
          parama.e = null;
          parama.d = null;
          parama.f = false;
        } while (!bool);
        return true;
      }
      finally
      {
        parama.e = null;
        parama.d = null;
        parama.f = false;
      }
      paramObject = finally;
    }
    if (paramClass.hasNext())
    {
      localn = (n)paramClass.next();
      parama.e = paramObject;
      parama.d = localn;
    }
    label127:
    return false;
  }
  
  private void b(n paramn, Object paramObject)
  {
    if (paramObject != null) {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label23;
      }
    }
    label23:
    for (boolean bool = true;; bool = false)
    {
      a(paramn, paramObject, bool);
      return;
    }
  }
  
  public static d builder()
  {
    return new d();
  }
  
  public static void clearCaches()
  {
    m.a();
    d.clear();
  }
  
  public static c getDefault()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new c();
      }
      return b;
    }
    finally {}
  }
  
  ExecutorService a()
  {
    return this.m;
  }
  
  void a(h paramh)
  {
    Object localObject = paramh.a;
    n localn = paramh.b;
    h.a(paramh);
    if (localn.c) {
      a(localn, localObject);
    }
  }
  
  void a(n paramn, Object paramObject)
  {
    try
    {
      paramn.b.a.invoke(paramn.a, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      a(paramn, paramObject, localInvocationTargetException.getCause());
      return;
    }
    catch (IllegalAccessException paramn)
    {
      throw new IllegalStateException("Unexpected exception", paramn);
    }
  }
  
  public void cancelEventDelivery(Object paramObject)
  {
    a locala = (a)this.h.get();
    if (!locala.b) {
      throw new e("This method may only be called from inside event handling methods on the posting thread");
    }
    if (paramObject == null) {
      throw new e("Event may not be null");
    }
    if (locala.e != paramObject) {
      throw new e("Only the currently handled event may be aborted");
    }
    if (locala.d.b.b != ThreadMode.POSTING) {
      throw new e(" event handlers may only abort the incoming event");
    }
    locala.f = true;
  }
  
  public <T> T getStickyEvent(Class<T> paramClass)
  {
    synchronized (this.g)
    {
      paramClass = paramClass.cast(this.g.get(paramClass));
      return paramClass;
    }
  }
  
  public boolean hasSubscriberForEvent(Class<?> paramClass)
  {
    paramClass = a(paramClass);
    if (paramClass != null)
    {
      int i2 = paramClass.size();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = (Class)paramClass.get(i1);
        try
        {
          localObject = (CopyOnWriteArrayList)this.e.get(localObject);
          if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty())) {
            return true;
          }
        }
        finally {}
        i1 += 1;
      }
    }
    return false;
  }
  
  public boolean isRegistered(Object paramObject)
  {
    try
    {
      boolean bool = this.f.containsKey(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  /* Error */
  public void post(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	org/greenrobot/eventbus/c:h	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 440	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 10	org/greenrobot/eventbus/c$a
    //   10: astore_3
    //   11: aload_3
    //   12: getfield 466	org/greenrobot/eventbus/c$a:a	Ljava/util/List;
    //   15: astore 4
    //   17: aload 4
    //   19: aload_1
    //   20: invokeinterface 171 2 0
    //   25: pop
    //   26: aload_3
    //   27: getfield 441	org/greenrobot/eventbus/c$a:b	Z
    //   30: ifne +96 -> 126
    //   33: invokestatic 92	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   36: invokestatic 391	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   39: if_acmpne +33 -> 72
    //   42: iconst_1
    //   43: istore_2
    //   44: aload_3
    //   45: iload_2
    //   46: putfield 384	org/greenrobot/eventbus/c$a:c	Z
    //   49: aload_3
    //   50: iconst_1
    //   51: putfield 441	org/greenrobot/eventbus/c$a:b	Z
    //   54: aload_3
    //   55: getfield 387	org/greenrobot/eventbus/c$a:f	Z
    //   58: ifeq +19 -> 77
    //   61: new 310	org/greenrobot/eventbus/e
    //   64: dup
    //   65: ldc_w 468
    //   68: invokespecial 317	org/greenrobot/eventbus/e:<init>	(Ljava/lang/String;)V
    //   71: athrow
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -30 -> 44
    //   77: aload 4
    //   79: invokeinterface 469 1 0
    //   84: ifne +32 -> 116
    //   87: aload_0
    //   88: aload 4
    //   90: iconst_0
    //   91: invokeinterface 203 2 0
    //   96: aload_3
    //   97: invokespecial 471	org/greenrobot/eventbus/c:a	(Ljava/lang/Object;Lorg/greenrobot/eventbus/c$a;)V
    //   100: goto -23 -> 77
    //   103: astore_1
    //   104: aload_3
    //   105: iconst_0
    //   106: putfield 441	org/greenrobot/eventbus/c$a:b	Z
    //   109: aload_3
    //   110: iconst_0
    //   111: putfield 384	org/greenrobot/eventbus/c$a:c	Z
    //   114: aload_1
    //   115: athrow
    //   116: aload_3
    //   117: iconst_0
    //   118: putfield 441	org/greenrobot/eventbus/c$a:b	Z
    //   121: aload_3
    //   122: iconst_0
    //   123: putfield 384	org/greenrobot/eventbus/c$a:c	Z
    //   126: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	c
    //   0	127	1	paramObject	Object
    //   43	31	2	bool	boolean
    //   10	112	3	locala	a
    //   15	74	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   77	100	103	finally
  }
  
  public void postSticky(Object paramObject)
  {
    synchronized (this.g)
    {
      this.g.put(paramObject.getClass(), paramObject);
      post(paramObject);
      return;
    }
  }
  
  public void register(Object paramObject)
  {
    Object localObject = paramObject.getClass();
    localObject = this.l.a((Class)localObject);
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramObject, (l)((Iterator)localObject).next());
      }
    }
    finally {}
  }
  
  public void removeAllStickyEvents()
  {
    synchronized (this.g)
    {
      this.g.clear();
      return;
    }
  }
  
  public <T> T removeStickyEvent(Class<T> paramClass)
  {
    synchronized (this.g)
    {
      paramClass = paramClass.cast(this.g.remove(paramClass));
      return paramClass;
    }
  }
  
  public boolean removeStickyEvent(Object paramObject)
  {
    synchronized (this.g)
    {
      Class localClass = paramObject.getClass();
      if (paramObject.equals(this.g.get(localClass)))
      {
        this.g.remove(localClass);
        return true;
      }
      return false;
    }
  }
  
  public String toString()
  {
    return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
  }
  
  public void unregister(Object paramObject)
  {
    try
    {
      Object localObject = (List)this.f.get(paramObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a(paramObject, (Class)((Iterator)localObject).next());
        }
        this.f.remove(paramObject);
      }
    }
    finally {}
    for (;;)
    {
      return;
      Log.w(a, "Subscriber to unregister was not registered before: " + paramObject.getClass());
    }
  }
  
  static final class a
  {
    final List<Object> a = new ArrayList();
    boolean b;
    boolean c;
    n d;
    Object e;
    boolean f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */