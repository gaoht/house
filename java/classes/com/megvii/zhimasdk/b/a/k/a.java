package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.h;
import com.megvii.zhimasdk.b.a.p;

public abstract class a
  implements p
{
  protected q a = new q();
  @Deprecated
  protected com.megvii.zhimasdk.b.a.l.e b;
  
  protected a()
  {
    this(null);
  }
  
  @Deprecated
  protected a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    this.b = parame;
  }
  
  public void a(com.megvii.zhimasdk.b.a.e parame)
  {
    this.a.a(parame);
  }
  
  @Deprecated
  public void a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    this.b = ((com.megvii.zhimasdk.b.a.l.e)com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters"));
  }
  
  public void a(String paramString1, String paramString2)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString1, "Header name");
    this.a.a(new b(paramString1, paramString2));
  }
  
  public void a(com.megvii.zhimasdk.b.a.e[] paramArrayOfe)
  {
    this.a.a(paramArrayOfe);
  }
  
  public boolean a(String paramString)
  {
    return this.a.c(paramString);
  }
  
  public void b(com.megvii.zhimasdk.b.a.e parame)
  {
    this.a.b(parame);
  }
  
  public void b(String paramString1, String paramString2)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString1, "Header name");
    this.a.c(new b(paramString1, paramString2));
  }
  
  public com.megvii.zhimasdk.b.a.e[] b(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public com.megvii.zhimasdk.b.a.e c(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public void d(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      h localh = this.a.c();
      while (localh.hasNext()) {
        if (paramString.equalsIgnoreCase(localh.a().c())) {
          localh.remove();
        }
      }
    }
  }
  
  public h e(String paramString)
  {
    return this.a.d(paramString);
  }
  
  public com.megvii.zhimasdk.b.a.e[] e()
  {
    return this.a.b();
  }
  
  public h f()
  {
    return this.a.c();
  }
  
  @Deprecated
  public com.megvii.zhimasdk.b.a.l.e g()
  {
    if (this.b == null) {
      this.b = new com.megvii.zhimasdk.b.a.l.b();
    }
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */