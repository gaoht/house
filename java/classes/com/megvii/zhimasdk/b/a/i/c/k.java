package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.b.f;
import com.megvii.zhimasdk.b.a.e.q;
import com.megvii.zhimasdk.b.a.m.a;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Deprecated
class k
  extends a<com.megvii.zhimasdk.b.a.e.b.b, q>
{
  public com.megvii.zhimasdk.b.a.h.b a;
  private final f b;
  
  public k(com.megvii.zhimasdk.b.a.h.b paramb, String paramString, com.megvii.zhimasdk.b.a.e.b.b paramb1, q paramq, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramb1, paramq, paramLong, paramTimeUnit);
    this.a = paramb;
    this.b = new f(paramb1);
  }
  
  f a()
  {
    return this.b;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = super.a(paramLong);
    if ((bool) && (this.a.a())) {
      this.a.a("Connection " + this + " expired @ " + new Date(h()));
    }
    return bool;
  }
  
  com.megvii.zhimasdk.b.a.e.b.b b()
  {
    return (com.megvii.zhimasdk.b.a.e.b.b)f();
  }
  
  com.megvii.zhimasdk.b.a.e.b.b c()
  {
    return this.b.j();
  }
  
  public boolean d()
  {
    return !((q)g()).c();
  }
  
  public void e()
  {
    q localq = (q)g();
    try
    {
      localq.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.a.a("I/O error closing connection", localIOException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */