package com.d.a;

import android.view.View;
import com.d.b.d;
import com.d.c.a.a;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends n
{
  private static final Map<String, d> h = new HashMap();
  private Object i;
  private String j;
  private d k;
  
  static
  {
    h.put("alpha", k.a);
    h.put("pivotX", k.b);
    h.put("pivotY", k.c);
    h.put("translationX", k.d);
    h.put("translationY", k.e);
    h.put("rotation", k.f);
    h.put("rotationX", k.g);
    h.put("rotationY", k.h);
    h.put("scaleX", k.i);
    h.put("scaleY", k.j);
    h.put("scrollX", k.k);
    h.put("scrollY", k.l);
    h.put("x", k.m);
    h.put("y", k.n);
  }
  
  public j() {}
  
  private <T> j(T paramT, d<T, ?> paramd)
  {
    this.i = paramT;
    setProperty(paramd);
  }
  
  private j(Object paramObject, String paramString)
  {
    this.i = paramObject;
    setPropertyName(paramString);
  }
  
  public static <T> j ofFloat(T paramT, d<T, Float> paramd, float... paramVarArgs)
  {
    paramT = new j(paramT, paramd);
    paramT.setFloatValues(paramVarArgs);
    return paramT;
  }
  
  public static j ofFloat(Object paramObject, String paramString, float... paramVarArgs)
  {
    paramObject = new j(paramObject, paramString);
    ((j)paramObject).setFloatValues(paramVarArgs);
    return (j)paramObject;
  }
  
  public static <T> j ofInt(T paramT, d<T, Integer> paramd, int... paramVarArgs)
  {
    paramT = new j(paramT, paramd);
    paramT.setIntValues(paramVarArgs);
    return paramT;
  }
  
  public static j ofInt(Object paramObject, String paramString, int... paramVarArgs)
  {
    paramObject = new j(paramObject, paramString);
    ((j)paramObject).setIntValues(paramVarArgs);
    return (j)paramObject;
  }
  
  public static <T, V> j ofObject(T paramT, d<T, V> paramd, m<V> paramm, V... paramVarArgs)
  {
    paramT = new j(paramT, paramd);
    paramT.setObjectValues(paramVarArgs);
    paramT.setEvaluator(paramm);
    return paramT;
  }
  
  public static j ofObject(Object paramObject, String paramString, m paramm, Object... paramVarArgs)
  {
    paramObject = new j(paramObject, paramString);
    ((j)paramObject).setObjectValues(paramVarArgs);
    ((j)paramObject).setEvaluator(paramm);
    return (j)paramObject;
  }
  
  public static j ofPropertyValuesHolder(Object paramObject, l... paramVarArgs)
  {
    j localj = new j();
    localj.i = paramObject;
    localj.setValues(paramVarArgs);
    return localj;
  }
  
  void a()
  {
    if (!this.e)
    {
      if ((this.k == null) && (a.a) && ((this.i instanceof View)) && (h.containsKey(this.j))) {
        setProperty((d)h.get(this.j));
      }
      int n = this.f.length;
      int m = 0;
      while (m < n)
      {
        this.f[m].a(this.i);
        m += 1;
      }
      super.a();
    }
  }
  
  void a(float paramFloat)
  {
    super.a(paramFloat);
    int n = this.f.length;
    int m = 0;
    while (m < n)
    {
      this.f[m].d(this.i);
      m += 1;
    }
  }
  
  public j clone()
  {
    return (j)super.clone();
  }
  
  public String getPropertyName()
  {
    return this.j;
  }
  
  public Object getTarget()
  {
    return this.i;
  }
  
  public j setDuration(long paramLong)
  {
    super.setDuration(paramLong);
    return this;
  }
  
  public void setFloatValues(float... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        setValues(new l[] { l.ofFloat(this.k, paramVarArgs) });
        return;
      }
      setValues(new l[] { l.ofFloat(this.j, paramVarArgs) });
      return;
    }
    super.setFloatValues(paramVarArgs);
  }
  
  public void setIntValues(int... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        setValues(new l[] { l.ofInt(this.k, paramVarArgs) });
        return;
      }
      setValues(new l[] { l.ofInt(this.j, paramVarArgs) });
      return;
    }
    super.setIntValues(paramVarArgs);
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.k != null)
      {
        setValues(new l[] { l.ofObject(this.k, (m)null, paramVarArgs) });
        return;
      }
      setValues(new l[] { l.ofObject(this.j, (m)null, paramVarArgs) });
      return;
    }
    super.setObjectValues(paramVarArgs);
  }
  
  public void setProperty(d paramd)
  {
    if (this.f != null)
    {
      l locall = this.f[0];
      String str = locall.getPropertyName();
      locall.setProperty(paramd);
      this.g.remove(str);
      this.g.put(this.j, locall);
    }
    if (this.k != null) {
      this.j = paramd.getName();
    }
    this.k = paramd;
    this.e = false;
  }
  
  public void setPropertyName(String paramString)
  {
    if (this.f != null)
    {
      l locall = this.f[0];
      String str = locall.getPropertyName();
      locall.setPropertyName(paramString);
      this.g.remove(str);
      this.g.put(paramString, locall);
    }
    this.j = paramString;
    this.e = false;
  }
  
  public void setTarget(Object paramObject)
  {
    if (this.i != paramObject)
    {
      Object localObject = this.i;
      this.i = paramObject;
      if ((localObject == null) || (paramObject == null) || (localObject.getClass() != paramObject.getClass())) {}
    }
    else
    {
      return;
    }
    this.e = false;
  }
  
  public void setupEndValues()
  {
    a();
    int n = this.f.length;
    int m = 0;
    while (m < n)
    {
      this.f[m].c(this.i);
      m += 1;
    }
  }
  
  public void setupStartValues()
  {
    a();
    int n = this.f.length;
    int m = 0;
    while (m < n)
    {
      this.f[m].b(this.i);
      m += 1;
    }
  }
  
  public void start()
  {
    super.start();
  }
  
  public String toString()
  {
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.i;
    String str2 = str1;
    if (this.f != null)
    {
      int m = 0;
      for (;;)
      {
        str2 = str1;
        if (m >= this.f.length) {
          break;
        }
        str1 = str1 + "\n    " + this.f[m].toString();
        m += 1;
      }
    }
    return str2;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */