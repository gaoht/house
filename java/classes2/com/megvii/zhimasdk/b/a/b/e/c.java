package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.a.g;
import com.megvii.zhimasdk.b.a.a.h;
import com.megvii.zhimasdk.b.a.b.i;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;

public class c
  implements r
{
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  
  private void a(n paramn, com.megvii.zhimasdk.b.a.a.c paramc, h paramh, i parami)
  {
    String str = paramc.a();
    if (this.a.a()) {
      this.a.a("Re-using cached '" + str + "' auth scheme for " + paramn);
    }
    paramn = parami.a(new g(paramn, g.b, str));
    if (paramn != null)
    {
      if ("BASIC".equalsIgnoreCase(paramc.a())) {
        paramh.a(com.megvii.zhimasdk.b.a.a.b.b);
      }
      for (;;)
      {
        paramh.a(paramc, paramn);
        return;
        paramh.a(com.megvii.zhimasdk.b.a.a.b.e);
      }
    }
    this.a.a("No credentials for preemptive authentication");
  }
  
  public void a(q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    Object localObject2 = a.a(parame);
    Object localObject1 = ((a)localObject2).h();
    if (localObject1 == null)
    {
      this.a.a("Auth cache not set in the context");
      return;
    }
    parame = ((a)localObject2).g();
    if (parame == null)
    {
      this.a.a("Credentials provider not set in the context");
      return;
    }
    com.megvii.zhimasdk.b.a.e.b.e locale = ((a)localObject2).a();
    if (locale == null)
    {
      this.a.a("Route info not set in the context");
      return;
    }
    paramq = ((a)localObject2).o();
    if (paramq == null)
    {
      this.a.a("Target host not set in the context");
      return;
    }
    if (paramq.b() < 0) {
      paramq = new n(paramq.a(), locale.a().b(), paramq.c());
    }
    for (;;)
    {
      h localh = ((a)localObject2).i();
      if ((localh != null) && (localh.b() == com.megvii.zhimasdk.b.a.a.b.a))
      {
        com.megvii.zhimasdk.b.a.a.c localc = ((com.megvii.zhimasdk.b.a.b.a)localObject1).a(paramq);
        if (localc != null) {
          a(paramq, localc, localh, parame);
        }
      }
      paramq = locale.d();
      localObject2 = ((a)localObject2).j();
      if ((paramq == null) || (localObject2 == null) || (((h)localObject2).b() != com.megvii.zhimasdk.b.a.a.b.a)) {
        break;
      }
      localObject1 = ((com.megvii.zhimasdk.b.a.b.a)localObject1).a(paramq);
      if (localObject1 == null) {
        break;
      }
      a(paramq, (com.megvii.zhimasdk.b.a.a.c)localObject1, (h)localObject2, parame);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */