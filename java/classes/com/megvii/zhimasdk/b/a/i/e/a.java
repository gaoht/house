package com.megvii.zhimasdk.b.a.i.e;

import com.megvii.zhimasdk.b.a.g.b;
import com.megvii.zhimasdk.b.a.g.d;
import com.megvii.zhimasdk.b.a.i.f.e;
import com.megvii.zhimasdk.b.a.i.f.g;
import com.megvii.zhimasdk.b.a.i.f.l;
import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.p;

@Deprecated
public class a
{
  private final d a;
  
  public a(d paramd)
  {
    this.a = ((d)com.megvii.zhimasdk.b.a.o.a.a(paramd, "Content length strategy"));
  }
  
  protected b a(f paramf, p paramp)
  {
    b localb = new b();
    long l = this.a.a(paramp);
    if (l == -2L)
    {
      localb.a(true);
      localb.a(-1L);
      localb.a(new e(paramf));
    }
    for (;;)
    {
      paramf = paramp.c("Content-Type");
      if (paramf != null) {
        localb.a(paramf);
      }
      paramf = paramp.c("Content-Encoding");
      if (paramf != null) {
        localb.b(paramf);
      }
      return localb;
      if (l == -1L)
      {
        localb.a(false);
        localb.a(-1L);
        localb.a(new l(paramf));
      }
      else
      {
        localb.a(false);
        localb.a(l);
        localb.a(new g(paramf, l));
      }
    }
  }
  
  public k b(f paramf, p paramp)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramf, "Session input buffer");
    com.megvii.zhimasdk.b.a.o.a.a(paramp, "HTTP message");
    return a(paramf, paramp);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */