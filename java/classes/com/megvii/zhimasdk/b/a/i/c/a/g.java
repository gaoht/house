package com.megvii.zhimasdk.b.a.i.c.a;

import com.megvii.zhimasdk.b.a.e.c.i;
import com.megvii.zhimasdk.b.a.e.o;
import com.megvii.zhimasdk.b.a.i.c.p;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Deprecated
public class g
  implements com.megvii.zhimasdk.b.a.e.b
{
  public com.megvii.zhimasdk.b.a.h.b a;
  protected final i b;
  protected final a c;
  protected final d d;
  protected final com.megvii.zhimasdk.b.a.e.d e;
  protected final com.megvii.zhimasdk.b.a.e.a.c f;
  
  public g()
  {
    this(p.a());
  }
  
  public g(i parami)
  {
    this(parami, -1L, TimeUnit.MILLISECONDS);
  }
  
  public g(i parami, long paramLong, TimeUnit paramTimeUnit)
  {
    this(parami, paramLong, paramTimeUnit, new com.megvii.zhimasdk.b.a.e.a.c());
  }
  
  public g(i parami, long paramLong, TimeUnit paramTimeUnit, com.megvii.zhimasdk.b.a.e.a.c paramc)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parami, "Scheme registry");
    this.a = new com.megvii.zhimasdk.b.a.h.b(getClass());
    this.b = parami;
    this.f = paramc;
    this.e = a(parami);
    this.d = a(paramLong, paramTimeUnit);
    this.c = this.d;
  }
  
  @Deprecated
  public g(com.megvii.zhimasdk.b.a.l.e parame, i parami)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parami, "Scheme registry");
    this.a = new com.megvii.zhimasdk.b.a.h.b(getClass());
    this.b = parami;
    this.f = new com.megvii.zhimasdk.b.a.e.a.c();
    this.e = a(parami);
    this.d = ((d)a(parame));
    this.c = this.d;
  }
  
  public i a()
  {
    return this.b;
  }
  
  protected com.megvii.zhimasdk.b.a.e.d a(i parami)
  {
    return new com.megvii.zhimasdk.b.a.i.c.g(parami);
  }
  
  public com.megvii.zhimasdk.b.a.e.e a(com.megvii.zhimasdk.b.a.e.b.b paramb, Object paramObject)
  {
    return new g.1(this, this.d.a(paramb, paramObject), paramb);
  }
  
  @Deprecated
  protected a a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    return new d(this.e, parame);
  }
  
  protected d a(long paramLong, TimeUnit paramTimeUnit)
  {
    return new d(this.e, this.f, 20, paramLong, paramTimeUnit);
  }
  
  public void a(o paramo, long paramLong, TimeUnit paramTimeUnit)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramo instanceof c, "Connection class mismatch, connection not obtained from this manager");
    paramo = (c)paramo;
    boolean bool;
    if (paramo.s() != null)
    {
      if (paramo.p() != this) {
        break label58;
      }
      bool = true;
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Connection not obtained from this manager");
    }
    b localb;
    for (;;)
    {
      try
      {
        localb = (b)paramo.s();
        if (localb == null)
        {
          return;
          label58:
          bool = false;
          break;
        }
      }
      finally {}
      try
      {
        if ((paramo.c()) && (!paramo.r())) {
          paramo.e();
        }
        bool = paramo.r();
        if (this.a.a())
        {
          if (!bool) {
            break label140;
          }
          this.a.a("Released connection is reusable.");
        }
        paramo.n();
        this.d.a(localb, bool, paramLong, paramTimeUnit);
      }
      catch (IOException localIOException)
      {
        label140:
        if (!this.a.a()) {
          break label175;
        }
        this.a.a("Exception shutting down released connection.", localIOException);
        bool = paramo.r();
        if (!this.a.a()) {
          break label205;
        }
        if (!bool) {
          break label226;
        }
        this.a.a("Released connection is reusable.");
        for (;;)
        {
          paramo.n();
          this.d.a(localb, bool, paramLong, paramTimeUnit);
          break;
          this.a.a("Released connection is not reusable.");
        }
      }
      finally
      {
        bool = paramo.r();
        if (!this.a.a()) {
          break label270;
        }
        if (!bool) {
          break label291;
        }
        this.a.a("Released connection is reusable.");
      }
      return;
      this.a.a("Released connection is not reusable.");
    }
    for (;;)
    {
      label175:
      label205:
      label226:
      label270:
      paramo.n();
      this.d.a(localb, bool, paramLong, paramTimeUnit);
      throw ((Throwable)localObject);
      label291:
      this.a.a("Released connection is not reusable.");
    }
  }
  
  public void b()
  {
    this.a.a("Shutting down");
    this.d.a();
  }
  
  protected void finalize()
  {
    try
    {
      b();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */