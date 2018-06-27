package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.h;
import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.k.i;
import com.megvii.zhimasdk.b.a.k.s;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.p;

public abstract class b<T extends p>
  implements com.megvii.zhimasdk.b.a.j.d<T>
{
  protected final g a;
  protected final com.megvii.zhimasdk.b.a.o.d b;
  protected final s c;
  
  @Deprecated
  public b(g paramg, s params, com.megvii.zhimasdk.b.a.l.e parame)
  {
    a.a(paramg, "Session input buffer");
    this.a = paramg;
    this.b = new com.megvii.zhimasdk.b.a.o.d(128);
    if (params != null) {}
    for (;;)
    {
      this.c = params;
      return;
      params = i.b;
    }
  }
  
  protected abstract void a(T paramT);
  
  public void b(T paramT)
  {
    a.a(paramT, "HTTP message");
    a(paramT);
    paramT = paramT.f();
    while (paramT.hasNext())
    {
      com.megvii.zhimasdk.b.a.e locale = paramT.a();
      this.a.a(this.c.a(this.b, locale));
    }
    this.b.a();
    this.a.a(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */