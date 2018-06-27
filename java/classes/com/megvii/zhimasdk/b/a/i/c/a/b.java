package com.megvii.zhimasdk.b.a.i.c.a;

import com.megvii.zhimasdk.b.a.e.d;
import com.megvii.zhimasdk.b.a.e.q;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.concurrent.TimeUnit;

@Deprecated
public class b
  extends com.megvii.zhimasdk.b.a.i.c.b
{
  private final long f;
  private long g;
  private final long h;
  private long i;
  
  public b(d paramd, com.megvii.zhimasdk.b.a.e.b.b paramb, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramd, paramb);
    a.a(paramb, "HTTP route");
    this.f = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (this.h = (this.f + paramTimeUnit.toMillis(paramLong));; this.h = Long.MAX_VALUE)
    {
      this.i = this.h;
      return;
    }
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    this.g = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (paramLong = this.g + paramTimeUnit.toMillis(paramLong);; paramLong = Long.MAX_VALUE)
    {
      this.i = Math.min(this.h, paramLong);
      return;
    }
  }
  
  public boolean a(long paramLong)
  {
    return paramLong >= this.i;
  }
  
  protected void b()
  {
    super.b();
  }
  
  protected final q c()
  {
    return this.b;
  }
  
  protected final com.megvii.zhimasdk.b.a.e.b.b d()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */