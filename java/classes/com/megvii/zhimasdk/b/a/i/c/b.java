package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.b.f;
import com.megvii.zhimasdk.b.a.e.d;
import com.megvii.zhimasdk.b.a.e.q;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import java.io.InterruptedIOException;

@Deprecated
public abstract class b
{
  protected final d a;
  protected final q b;
  protected volatile com.megvii.zhimasdk.b.a.e.b.b c;
  protected volatile Object d;
  protected volatile f e;
  
  protected b(d paramd, com.megvii.zhimasdk.b.a.e.b.b paramb)
  {
    a.a(paramd, "Connection operator");
    this.a = paramd;
    this.b = paramd.a();
    this.c = paramb;
    this.e = null;
  }
  
  public Object a()
  {
    return this.d;
  }
  
  public void a(com.megvii.zhimasdk.b.a.e.b.b paramb, com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    a.a(paramb, "Route");
    a.a(parame1, "HTTP parameters");
    boolean bool;
    n localn2;
    d locald;
    q localq;
    if (this.e != null)
    {
      if (!this.e.i())
      {
        bool = true;
        com.megvii.zhimasdk.b.a.o.b.a(bool, "Connection already open");
      }
    }
    else
    {
      this.e = new f(paramb);
      localn2 = paramb.d();
      locald = this.a;
      localq = this.b;
      if (localn2 == null) {
        break label122;
      }
    }
    label122:
    for (n localn1 = localn2;; localn1 = paramb.a())
    {
      locald.a(localq, localn1, paramb.b(), parame, parame1);
      paramb = this.e;
      if (paramb != null) {
        break label131;
      }
      throw new InterruptedIOException("Request aborted");
      bool = false;
      break;
    }
    label131:
    if (localn2 == null)
    {
      paramb.a(this.b.h());
      return;
    }
    paramb.a(localn2, this.b.h());
  }
  
  public void a(com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    a.a(parame1, "HTTP parameters");
    com.megvii.zhimasdk.b.a.o.b.a(this.e, "Route tracker");
    com.megvii.zhimasdk.b.a.o.b.a(this.e.i(), "Connection not open");
    com.megvii.zhimasdk.b.a.o.b.a(this.e.e(), "Protocol layering without a tunnel not supported");
    if (!this.e.f()) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Multiple protocol layering not supported");
      n localn = this.e.a();
      this.a.a(this.b, localn, parame, parame1);
      this.e.c(this.b.h());
      return;
    }
  }
  
  public void a(n paramn, boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    a.a(paramn, "Next proxy");
    a.a(parame, "Parameters");
    com.megvii.zhimasdk.b.a.o.b.a(this.e, "Route tracker");
    com.megvii.zhimasdk.b.a.o.b.a(this.e.i(), "Connection not open");
    this.b.a(null, paramn, paramBoolean, parame);
    this.e.b(paramn, paramBoolean);
  }
  
  public void a(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public void a(boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    a.a(parame, "HTTP parameters");
    com.megvii.zhimasdk.b.a.o.b.a(this.e, "Route tracker");
    com.megvii.zhimasdk.b.a.o.b.a(this.e.i(), "Connection not open");
    if (!this.e.e()) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Connection is already tunnelled");
      this.b.a(null, this.e.a(), paramBoolean, parame);
      this.e.b(paramBoolean);
      return;
    }
  }
  
  protected void b()
  {
    this.e = null;
    this.d = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */