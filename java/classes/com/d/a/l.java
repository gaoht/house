package com.d.a;

import android.util.Log;
import com.d.b.a;
import com.d.b.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class l
  implements Cloneable
{
  private static final m i = new f();
  private static final m j = new d();
  private static Class[] k = { Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class };
  private static Class[] l = { Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class };
  private static Class[] m = { Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class };
  private static final HashMap<Class, HashMap<String, Method>> n = new HashMap();
  private static final HashMap<Class, HashMap<String, Method>> o = new HashMap();
  String a;
  protected com.d.b.d b;
  Method c = null;
  Class d;
  i e = null;
  final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  final Object[] g = new Object[1];
  private Method h = null;
  private m p;
  private Object q;
  
  private l(com.d.b.d paramd)
  {
    this.b = paramd;
    if (paramd != null) {
      this.a = paramd.getName();
    }
  }
  
  private l(String paramString)
  {
    this.a = paramString;
  }
  
  static String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      return paramString1;
    }
    char c1 = Character.toUpperCase(paramString2.charAt(0));
    paramString2 = paramString2.substring(1);
    return paramString1 + c1 + paramString2;
  }
  
  private Method a(Class paramClass1, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    String str = a(paramString, this.a);
    if (paramClass2 == null) {
      try
      {
        paramString = paramClass1.getMethod(str, null);
        return paramString;
      }
      catch (NoSuchMethodException paramString) {}
    }
    try
    {
      paramClass1 = paramClass1.getDeclaredMethod(str, null);
      try
      {
        paramClass1.setAccessible(true);
        return paramClass1;
      }
      catch (NoSuchMethodException paramClass2) {}
    }
    catch (NoSuchMethodException paramClass1)
    {
      for (;;)
      {
        Class[] arrayOfClass;
        int i2;
        int i1;
        Class localClass;
        paramClass1 = null;
      }
    }
    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.a + ": " + paramString);
    return paramClass1;
    arrayOfClass = new Class[1];
    if (this.d.equals(Float.class))
    {
      paramString = k;
      i2 = paramString.length;
      i1 = 0;
      paramClass2 = localMethod1;
    }
    for (;;)
    {
      if (i1 >= i2) {
        break label253;
      }
      localClass = paramString[i1];
      arrayOfClass[0] = localClass;
      try
      {
        localMethod1 = paramClass1.getMethod(str, arrayOfClass);
        paramClass2 = localMethod1;
        this.d = localClass;
        return localMethod1;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        try
        {
          Method localMethod2 = paramClass1.getDeclaredMethod(str, arrayOfClass);
          paramClass2 = localMethod2;
          localMethod2.setAccessible(true);
          paramClass2 = localMethod2;
          this.d = localClass;
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          i1 += 1;
        }
      }
      if (this.d.equals(Integer.class))
      {
        paramString = l;
        break;
      }
      if (this.d.equals(Double.class))
      {
        paramString = m;
        break;
      }
      paramString = new Class[1];
      paramString[0] = this.d;
      break;
    }
    label253:
    Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.a + " with value type " + this.d);
    return paramClass2;
  }
  
  private Method a(Class paramClass1, HashMap<Class, HashMap<String, Method>> paramHashMap, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    try
    {
      this.f.writeLock().lock();
      HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
      if (localHashMap != null) {
        localMethod1 = (Method)localHashMap.get(this.a);
      }
      Method localMethod2 = localMethod1;
      if (localMethod1 == null)
      {
        localMethod2 = a(paramClass1, paramString, paramClass2);
        paramString = localHashMap;
        if (localHashMap == null)
        {
          paramString = new HashMap();
          paramHashMap.put(paramClass1, paramString);
        }
        paramString.put(this.a, localMethod2);
      }
      return localMethod2;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  private void a(Object paramObject, h paramh)
  {
    if (this.b != null) {
      paramh.setValue(this.b.get(paramObject));
    }
    try
    {
      if (this.h == null) {
        b(paramObject.getClass());
      }
      paramh.setValue(this.h.invoke(paramObject, new Object[0]));
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
    }
  }
  
  private void b(Class paramClass)
  {
    this.h = a(paramClass, o, "get", null);
  }
  
  public static l ofFloat(com.d.b.d<?, Float> paramd, float... paramVarArgs)
  {
    return new a(paramd, paramVarArgs);
  }
  
  public static l ofFloat(String paramString, float... paramVarArgs)
  {
    return new a(paramString, paramVarArgs);
  }
  
  public static l ofInt(com.d.b.d<?, Integer> paramd, int... paramVarArgs)
  {
    return new b(paramd, paramVarArgs);
  }
  
  public static l ofInt(String paramString, int... paramVarArgs)
  {
    return new b(paramString, paramVarArgs);
  }
  
  public static l ofKeyframe(com.d.b.d paramd, h... paramVarArgs)
  {
    i locali = i.ofKeyframe(paramVarArgs);
    if ((locali instanceof g)) {
      return new b(paramd, (g)locali);
    }
    if ((locali instanceof e)) {
      return new a(paramd, (e)locali);
    }
    paramd = new l(paramd);
    paramd.e = locali;
    paramd.d = paramVarArgs[0].getType();
    return paramd;
  }
  
  public static l ofKeyframe(String paramString, h... paramVarArgs)
  {
    i locali = i.ofKeyframe(paramVarArgs);
    if ((locali instanceof g)) {
      return new b(paramString, (g)locali);
    }
    if ((locali instanceof e)) {
      return new a(paramString, (e)locali);
    }
    paramString = new l(paramString);
    paramString.e = locali;
    paramString.d = paramVarArgs[0].getType();
    return paramString;
  }
  
  public static <V> l ofObject(com.d.b.d paramd, m<V> paramm, V... paramVarArgs)
  {
    paramd = new l(paramd);
    paramd.setObjectValues(paramVarArgs);
    paramd.setEvaluator(paramm);
    return paramd;
  }
  
  public static l ofObject(String paramString, m paramm, Object... paramVarArgs)
  {
    paramString = new l(paramString);
    paramString.setObjectValues(paramVarArgs);
    paramString.setEvaluator(paramm);
    return paramString;
  }
  
  void a()
  {
    m localm;
    if (this.p == null)
    {
      if (this.d != Integer.class) {
        break label44;
      }
      localm = i;
    }
    for (;;)
    {
      this.p = localm;
      if (this.p != null) {
        this.e.setEvaluator(this.p);
      }
      return;
      label44:
      if (this.d == Float.class) {
        localm = j;
      } else {
        localm = null;
      }
    }
  }
  
  void a(float paramFloat)
  {
    this.q = this.e.getValue(paramFloat);
  }
  
  void a(Class paramClass)
  {
    this.c = a(paramClass, n, "set", this.d);
  }
  
  void a(Object paramObject)
  {
    Object localObject;
    if (this.b != null)
    {
      try
      {
        this.b.get(paramObject);
        Iterator localIterator = this.e.e.iterator();
        while (localIterator.hasNext())
        {
          localObject = (h)localIterator.next();
          if (!((h)localObject).hasValue()) {
            ((h)localObject).setValue(this.b.get(paramObject));
          }
        }
        localClass = paramObject.getClass();
      }
      catch (ClassCastException localClassCastException)
      {
        Log.e("PropertyValuesHolder", "No such property (" + this.b.getName() + ") on target object " + paramObject + ". Trying reflection instead");
        this.b = null;
      }
    }
    else
    {
      Class localClass;
      if (this.c == null) {
        a(localClass);
      }
      localObject = this.e.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        if (!localh.hasValue())
        {
          if (this.h == null) {
            b(localClass);
          }
          try
          {
            localh.setValue(this.h.invoke(paramObject, new Object[0]));
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
          }
        }
      }
    }
  }
  
  Object b()
  {
    return this.q;
  }
  
  void b(Object paramObject)
  {
    a(paramObject, (h)this.e.e.get(0));
  }
  
  void c(Object paramObject)
  {
    a(paramObject, (h)this.e.e.get(this.e.e.size() - 1));
  }
  
  public l clone()
  {
    try
    {
      l locall = (l)super.clone();
      locall.a = this.a;
      locall.b = this.b;
      locall.e = this.e.clone();
      locall.p = this.p;
      return locall;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  void d(Object paramObject)
  {
    if (this.b != null) {
      this.b.set(paramObject, b());
    }
    if (this.c != null) {}
    try
    {
      this.g[0] = b();
      this.c.invoke(paramObject, this.g);
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
    }
  }
  
  public String getPropertyName()
  {
    return this.a;
  }
  
  public void setEvaluator(m paramm)
  {
    this.p = paramm;
    this.e.setEvaluator(paramm);
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    this.d = Float.TYPE;
    this.e = i.ofFloat(paramVarArgs);
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    this.d = Integer.TYPE;
    this.e = i.ofInt(paramVarArgs);
  }
  
  public void setKeyframes(h... paramVarArgs)
  {
    int i1 = 0;
    int i2 = paramVarArgs.length;
    h[] arrayOfh = new h[Math.max(i2, 2)];
    this.d = paramVarArgs[0].getType();
    while (i1 < i2)
    {
      arrayOfh[i1] = paramVarArgs[i1];
      i1 += 1;
    }
    this.e = new i(arrayOfh);
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    this.d = paramVarArgs[0].getClass();
    this.e = i.ofObject(paramVarArgs);
  }
  
  public void setProperty(com.d.b.d paramd)
  {
    this.b = paramd;
  }
  
  public void setPropertyName(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return this.a + ": " + this.e.toString();
  }
  
  static class a
    extends l
  {
    e h;
    float i;
    private a j;
    
    public a(com.d.b.d paramd, e parame)
    {
      super(null);
      this.d = Float.TYPE;
      this.e = parame;
      this.h = ((e)this.e);
      if ((paramd instanceof a)) {
        this.j = ((a)this.b);
      }
    }
    
    public a(com.d.b.d paramd, float... paramVarArgs)
    {
      super(null);
      setFloatValues(paramVarArgs);
      if ((paramd instanceof a)) {
        this.j = ((a)this.b);
      }
    }
    
    public a(String paramString, e parame)
    {
      super(null);
      this.d = Float.TYPE;
      this.e = parame;
      this.h = ((e)this.e);
    }
    
    public a(String paramString, float... paramVarArgs)
    {
      super(null);
      setFloatValues(paramVarArgs);
    }
    
    void a(float paramFloat)
    {
      this.i = this.h.getFloatValue(paramFloat);
    }
    
    void a(Class paramClass)
    {
      if (this.b != null) {
        return;
      }
      super.a(paramClass);
    }
    
    Object b()
    {
      return Float.valueOf(this.i);
    }
    
    public a clone()
    {
      a locala = (a)super.clone();
      locala.h = ((e)locala.e);
      return locala;
    }
    
    void d(Object paramObject)
    {
      if (this.j != null) {
        this.j.setValue(paramObject, this.i);
      }
      do
      {
        return;
        if (this.b != null)
        {
          this.b.set(paramObject, Float.valueOf(this.i));
          return;
        }
      } while (this.c == null);
      try
      {
        this.g[0] = Float.valueOf(this.i);
        this.c.invoke(paramObject, this.g);
        return;
      }
      catch (InvocationTargetException paramObject)
      {
        Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
        return;
      }
      catch (IllegalAccessException paramObject)
      {
        Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
      }
    }
    
    public void setFloatValues(float... paramVarArgs)
    {
      super.setFloatValues(paramVarArgs);
      this.h = ((e)this.e);
    }
  }
  
  static class b
    extends l
  {
    g h;
    int i;
    private b j;
    
    public b(com.d.b.d paramd, g paramg)
    {
      super(null);
      this.d = Integer.TYPE;
      this.e = paramg;
      this.h = ((g)this.e);
      if ((paramd instanceof b)) {
        this.j = ((b)this.b);
      }
    }
    
    public b(com.d.b.d paramd, int... paramVarArgs)
    {
      super(null);
      setIntValues(paramVarArgs);
      if ((paramd instanceof b)) {
        this.j = ((b)this.b);
      }
    }
    
    public b(String paramString, g paramg)
    {
      super(null);
      this.d = Integer.TYPE;
      this.e = paramg;
      this.h = ((g)this.e);
    }
    
    public b(String paramString, int... paramVarArgs)
    {
      super(null);
      setIntValues(paramVarArgs);
    }
    
    void a(float paramFloat)
    {
      this.i = this.h.getIntValue(paramFloat);
    }
    
    void a(Class paramClass)
    {
      if (this.b != null) {
        return;
      }
      super.a(paramClass);
    }
    
    Object b()
    {
      return Integer.valueOf(this.i);
    }
    
    public b clone()
    {
      b localb = (b)super.clone();
      localb.h = ((g)localb.e);
      return localb;
    }
    
    void d(Object paramObject)
    {
      if (this.j != null) {
        this.j.setValue(paramObject, this.i);
      }
      do
      {
        return;
        if (this.b != null)
        {
          this.b.set(paramObject, Integer.valueOf(this.i));
          return;
        }
      } while (this.c == null);
      try
      {
        this.g[0] = Integer.valueOf(this.i);
        this.c.invoke(paramObject, this.g);
        return;
      }
      catch (InvocationTargetException paramObject)
      {
        Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
        return;
      }
      catch (IllegalAccessException paramObject)
      {
        Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
      }
    }
    
    public void setIntValues(int... paramVarArgs)
    {
      super.setIntValues(paramVarArgs);
      this.h = ((g)this.e);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */