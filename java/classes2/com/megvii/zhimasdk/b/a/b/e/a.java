package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.b.i;
import com.megvii.zhimasdk.b.a.e.b.b;
import com.megvii.zhimasdk.b.a.f.j;
import com.megvii.zhimasdk.b.a.n.f;

public class a
  extends f
{
  public a() {}
  
  public a(com.megvii.zhimasdk.b.a.n.e parame)
  {
    super(parame);
  }
  
  public static a a(com.megvii.zhimasdk.b.a.n.e parame)
  {
    if ((parame instanceof a)) {
      return (a)parame;
    }
    return new a(parame);
  }
  
  private <T> com.megvii.zhimasdk.b.a.d.a<T> b(String paramString, Class<T> paramClass)
  {
    return (com.megvii.zhimasdk.b.a.d.a)a(paramString, com.megvii.zhimasdk.b.a.d.a.class);
  }
  
  public com.megvii.zhimasdk.b.a.e.b.e a()
  {
    return (com.megvii.zhimasdk.b.a.e.b.e)a("http.route", b.class);
  }
  
  public void a(com.megvii.zhimasdk.b.a.b.a parama)
  {
    a("http.auth.auth-cache", parama);
  }
  
  public com.megvii.zhimasdk.b.a.b.h b()
  {
    return (com.megvii.zhimasdk.b.a.b.h)a("http.cookie-store", com.megvii.zhimasdk.b.a.b.h.class);
  }
  
  public com.megvii.zhimasdk.b.a.f.h c()
  {
    return (com.megvii.zhimasdk.b.a.f.h)a("http.cookie-spec", com.megvii.zhimasdk.b.a.f.h.class);
  }
  
  public com.megvii.zhimasdk.b.a.f.e d()
  {
    return (com.megvii.zhimasdk.b.a.f.e)a("http.cookie-origin", com.megvii.zhimasdk.b.a.f.e.class);
  }
  
  public com.megvii.zhimasdk.b.a.d.a<j> e()
  {
    return b("http.cookiespec-registry", j.class);
  }
  
  public com.megvii.zhimasdk.b.a.d.a<com.megvii.zhimasdk.b.a.a.e> f()
  {
    return b("http.authscheme-registry", com.megvii.zhimasdk.b.a.a.e.class);
  }
  
  public i g()
  {
    return (i)a("http.auth.credentials-provider", i.class);
  }
  
  public com.megvii.zhimasdk.b.a.b.a h()
  {
    return (com.megvii.zhimasdk.b.a.b.a)a("http.auth.auth-cache", com.megvii.zhimasdk.b.a.b.a.class);
  }
  
  public com.megvii.zhimasdk.b.a.a.h i()
  {
    return (com.megvii.zhimasdk.b.a.a.h)a("http.auth.target-scope", com.megvii.zhimasdk.b.a.a.h.class);
  }
  
  public com.megvii.zhimasdk.b.a.a.h j()
  {
    return (com.megvii.zhimasdk.b.a.a.h)a("http.auth.proxy-scope", com.megvii.zhimasdk.b.a.a.h.class);
  }
  
  public com.megvii.zhimasdk.b.a.b.a.a k()
  {
    com.megvii.zhimasdk.b.a.b.a.a locala = (com.megvii.zhimasdk.b.a.b.a.a)a("http.request-config", com.megvii.zhimasdk.b.a.b.a.a.class);
    if (locala != null) {
      return locala;
    }
    return com.megvii.zhimasdk.b.a.b.a.a.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */