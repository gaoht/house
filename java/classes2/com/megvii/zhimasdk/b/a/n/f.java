package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.j;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.q;

public class f
  implements e
{
  private final e a;
  
  public f()
  {
    this.a = new a();
  }
  
  public f(e parame)
  {
    this.a = parame;
  }
  
  public static f b(e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    if ((parame instanceof f)) {
      return (f)parame;
    }
    return new f(parame);
  }
  
  public Object a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramClass, "Attribute class");
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    return (T)paramClass.cast(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
  }
  
  public j l()
  {
    return (j)a("http.connection", j.class);
  }
  
  public q m()
  {
    return (q)a("http.request", q.class);
  }
  
  public boolean n()
  {
    Boolean localBoolean = (Boolean)a("http.request_sent", Boolean.class);
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public n o()
  {
    return (n)a("http.target_host", n.class);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */