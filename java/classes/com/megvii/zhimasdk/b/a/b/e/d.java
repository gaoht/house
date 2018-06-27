package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.a.a;
import com.megvii.zhimasdk.b.a.a.c;
import com.megvii.zhimasdk.b.a.a.h;
import com.megvii.zhimasdk.b.a.a.i;
import com.megvii.zhimasdk.b.a.a.l;
import com.megvii.zhimasdk.b.a.a.m;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;
import java.util.Queue;

@Deprecated
abstract class d
  implements r
{
  final com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  
  private com.megvii.zhimasdk.b.a.e a(c paramc, m paramm, q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.b.a(paramc, "Auth scheme");
    if ((paramc instanceof l)) {
      return ((l)paramc).a(paramm, paramq, parame);
    }
    return paramc.a(paramm, paramq);
  }
  
  private void a(c paramc)
  {
    com.megvii.zhimasdk.b.a.o.b.a(paramc, "Auth scheme");
  }
  
  void a(h paramh, q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    c localc = paramh.c();
    Object localObject = paramh.d();
    switch (d.1.a[paramh.b().ordinal()])
    {
    }
    for (;;)
    {
      if (localc != null) {}
      try
      {
        paramq.a(a(localc, (m)localObject, paramq, parame));
        for (;;)
        {
          return;
          a(localc);
          if (!localc.c()) {
            break;
          }
          return;
          Queue localQueue = paramh.e();
          if (localQueue == null) {
            break label256;
          }
          while (!localQueue.isEmpty())
          {
            localObject = (a)localQueue.remove();
            localc = ((a)localObject).a();
            localObject = ((a)localObject).b();
            paramh.a(localc, (m)localObject);
            if (this.a.a()) {
              this.a.a("Generating response to an authentication challenge using " + localc.a() + " scheme");
            }
            try
            {
              paramq.a(a(localc, (m)localObject, paramq, parame));
              return;
            }
            catch (i locali) {}
            if (this.a.c()) {
              this.a.c(localc + " authentication error: " + locali.getMessage());
            }
          }
        }
        label256:
        a(localc);
      }
      catch (i paramh)
      {
        while (!this.a.b()) {}
        this.a.b(localc + " authentication error: " + paramh.getMessage());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */