package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.a.h;
import com.megvii.zhimasdk.b.a.e.n;
import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;

@Deprecated
public class g
  extends d
{
  public void a(q paramq, e parame)
  {
    a.a(paramq, "HTTP request");
    a.a(parame, "HTTP context");
    if (paramq.a("Proxy-Authorization")) {}
    do
    {
      return;
      localObject = (n)parame.a("http.connection");
      if (localObject == null)
      {
        this.a.a("HTTP connection not set in the context");
        return;
      }
    } while (((n)localObject).h().e());
    Object localObject = (h)parame.a("http.auth.proxy-scope");
    if (localObject == null)
    {
      this.a.a("Proxy auth web_state not set in the context");
      return;
    }
    if (this.a.a()) {
      this.a.a("Proxy auth web_state: " + ((h)localObject).b());
    }
    a((h)localObject, paramq, parame);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */