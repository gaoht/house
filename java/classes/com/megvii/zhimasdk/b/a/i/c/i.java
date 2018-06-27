package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.m;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;

@Deprecated
public class i
  implements com.megvii.zhimasdk.b.a.e.b.d
{
  protected final com.megvii.zhimasdk.b.a.e.c.i a;
  
  public i(com.megvii.zhimasdk.b.a.e.c.i parami)
  {
    a.a(parami, "Scheme registry");
    this.a = parami;
  }
  
  public com.megvii.zhimasdk.b.a.e.b.b a(n paramn, q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    a.a(paramq, "HTTP request");
    parame = com.megvii.zhimasdk.b.a.e.a.d.b(paramq.g());
    if (parame != null) {
      return parame;
    }
    com.megvii.zhimasdk.b.a.o.b.a(paramn, "Target host");
    parame = com.megvii.zhimasdk.b.a.e.a.d.c(paramq.g());
    paramq = com.megvii.zhimasdk.b.a.e.a.d.a(paramq.g());
    boolean bool;
    try
    {
      com.megvii.zhimasdk.b.a.e.c.e locale = this.a.a(paramn.c());
      bool = locale.d();
      if (paramq == null) {
        return new com.megvii.zhimasdk.b.a.e.b.b(paramn, parame, bool);
      }
    }
    catch (IllegalStateException paramn)
    {
      throw new m(paramn.getMessage());
    }
    return new com.megvii.zhimasdk.b.a.e.b.b(paramn, parame, paramq, bool);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */