package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.b.c.c;
import com.megvii.zhimasdk.b.a.b.c.j;
import com.megvii.zhimasdk.b.a.b.f;
import com.megvii.zhimasdk.b.a.b.f.d;
import com.megvii.zhimasdk.b.a.h.b;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;
import java.io.Closeable;
import java.net.URI;

public abstract class h
  implements Closeable
{
  public b b = new b(getClass());
  
  private static n a(j paramj)
  {
    n localn = null;
    URI localURI = paramj.j();
    paramj = localn;
    if (localURI.isAbsolute())
    {
      localn = d.b(localURI);
      paramj = localn;
      if (localn == null) {
        throw new f("URI does not specify a valid host name: " + localURI);
      }
    }
    return paramj;
  }
  
  public c a(j paramj, e parame)
  {
    a.a(paramj, "HTTP request");
    return a(a(paramj), paramj, parame);
  }
  
  protected abstract c a(n paramn, q paramq, e parame);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */