package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.b.f;
import com.megvii.zhimasdk.b.a.e.q;
import com.megvii.zhimasdk.b.a.n;

@Deprecated
public abstract class c
  extends a
{
  protected volatile b a;
  
  protected c(com.megvii.zhimasdk.b.a.e.b paramb, b paramb1)
  {
    super(paramb, paramb1.b);
    this.a = paramb1;
  }
  
  public void a(com.megvii.zhimasdk.b.a.e.b.b paramb, com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    b localb = s();
    a(localb);
    localb.a(paramb, parame, parame1);
  }
  
  protected void a(b paramb)
  {
    if ((q()) || (paramb == null)) {
      throw new e();
    }
  }
  
  public void a(com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    b localb = s();
    a(localb);
    localb.a(parame, parame1);
  }
  
  public void a(n paramn, boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    b localb = s();
    a(localb);
    localb.a(paramn, paramBoolean, parame);
  }
  
  public void a(Object paramObject)
  {
    b localb = s();
    a(localb);
    localb.a(paramObject);
  }
  
  public void a(boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    b localb = s();
    a(localb);
    localb.a(paramBoolean, parame);
  }
  
  public void close()
  {
    Object localObject = s();
    if (localObject != null) {
      ((b)localObject).b();
    }
    localObject = o();
    if (localObject != null) {
      ((q)localObject).close();
    }
  }
  
  public void e()
  {
    Object localObject = s();
    if (localObject != null) {
      ((b)localObject).b();
    }
    localObject = o();
    if (localObject != null) {
      ((q)localObject).e();
    }
  }
  
  public com.megvii.zhimasdk.b.a.e.b.b h()
  {
    b localb = s();
    a(localb);
    if (localb.e == null) {
      return null;
    }
    return localb.e.j();
  }
  
  protected void n()
  {
    try
    {
      this.a = null;
      super.n();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Deprecated
  protected b s()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */