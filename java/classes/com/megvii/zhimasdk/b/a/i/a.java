package com.megvii.zhimasdk.b.a.i;

import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.i.f.j;
import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.l;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.t;
import java.io.IOException;
import java.net.SocketTimeoutException;

@Deprecated
public abstract class a
  implements com.megvii.zhimasdk.b.a.i
{
  private final com.megvii.zhimasdk.b.a.i.e.b a = l();
  private final com.megvii.zhimasdk.b.a.i.e.a b = k();
  private f c = null;
  private g d = null;
  private com.megvii.zhimasdk.b.a.j.b e = null;
  private com.megvii.zhimasdk.b.a.j.c<s> f = null;
  private com.megvii.zhimasdk.b.a.j.d<q> g = null;
  private e h = null;
  
  protected e a(com.megvii.zhimasdk.b.a.j.e parame1, com.megvii.zhimasdk.b.a.j.e parame2)
  {
    return new e(parame1, parame2);
  }
  
  protected com.megvii.zhimasdk.b.a.j.c<s> a(f paramf, t paramt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    return new com.megvii.zhimasdk.b.a.i.f.i(paramf, null, paramt, parame);
  }
  
  protected com.megvii.zhimasdk.b.a.j.d<q> a(g paramg, com.megvii.zhimasdk.b.a.l.e parame)
  {
    return new j(paramg, null, parame);
  }
  
  public s a()
  {
    j();
    s locals = (s)this.f.a();
    if (locals.a().b() >= 200) {
      this.h.b();
    }
    return locals;
  }
  
  protected void a(f paramf, g paramg, com.megvii.zhimasdk.b.a.l.e parame)
  {
    this.c = ((f)com.megvii.zhimasdk.b.a.o.a.a(paramf, "Input session buffer"));
    this.d = ((g)com.megvii.zhimasdk.b.a.o.a.a(paramg, "Output session buffer"));
    if ((paramf instanceof com.megvii.zhimasdk.b.a.j.b)) {
      this.e = ((com.megvii.zhimasdk.b.a.j.b)paramf);
    }
    this.f = a(paramf, n(), parame);
    this.g = a(paramg, parame);
    this.h = a(paramf.b(), paramg.b());
  }
  
  public void a(l paraml)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paraml, "HTTP request");
    j();
    if (paraml.c() == null) {
      return;
    }
    this.a.a(this.d, paraml, paraml.c());
  }
  
  public void a(q paramq)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    j();
    this.g.b(paramq);
    this.h.a();
  }
  
  public void a(s params)
  {
    com.megvii.zhimasdk.b.a.o.a.a(params, "HTTP response");
    j();
    params.a(this.b.b(this.c, params));
  }
  
  public boolean a(int paramInt)
  {
    j();
    try
    {
      boolean bool = this.c.a(paramInt);
      return bool;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
    return false;
  }
  
  public void b()
  {
    j();
    o();
  }
  
  public boolean d()
  {
    if (!c()) {}
    while (p()) {
      return true;
    }
    try
    {
      this.c.a(1);
      boolean bool = p();
      return bool;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return false;
    }
    catch (IOException localIOException) {}
    return true;
  }
  
  protected abstract void j();
  
  protected com.megvii.zhimasdk.b.a.i.e.a k()
  {
    return new com.megvii.zhimasdk.b.a.i.e.a(new com.megvii.zhimasdk.b.a.i.e.c());
  }
  
  protected com.megvii.zhimasdk.b.a.i.e.b l()
  {
    return new com.megvii.zhimasdk.b.a.i.e.b(new com.megvii.zhimasdk.b.a.i.e.d());
  }
  
  protected t n()
  {
    return c.a;
  }
  
  protected void o()
  {
    this.d.a();
  }
  
  protected boolean p()
  {
    return (this.e != null) && (this.e.c());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */