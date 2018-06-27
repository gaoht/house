package com.megvii.zhimasdk.b.a.i.e;

import com.megvii.zhimasdk.b.a.g.d;
import com.megvii.zhimasdk.b.a.i.f.f;
import com.megvii.zhimasdk.b.a.i.f.h;
import com.megvii.zhimasdk.b.a.i.f.m;
import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.p;
import java.io.OutputStream;

@Deprecated
public class b
{
  private final d a;
  
  public b(d paramd)
  {
    this.a = ((d)a.a(paramd, "Content length strategy"));
  }
  
  protected OutputStream a(g paramg, p paramp)
  {
    long l = this.a.a(paramp);
    if (l == -2L) {
      return new f(paramg);
    }
    if (l == -1L) {
      return new m(paramg);
    }
    return new h(paramg, l);
  }
  
  public void a(g paramg, p paramp, k paramk)
  {
    a.a(paramg, "Session output buffer");
    a.a(paramp, "HTTP message");
    a.a(paramk, "HTTP entity");
    paramg = a(paramg, paramp);
    paramk.a(paramg);
    paramg.close();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */