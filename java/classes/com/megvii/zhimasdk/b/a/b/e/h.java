package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.h.b;
import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;

@Deprecated
public class h
  extends d
{
  public void a(q paramq, e parame)
  {
    a.a(paramq, "HTTP request");
    a.a(parame, "HTTP context");
    if (paramq.h().a().equalsIgnoreCase("CONNECT")) {}
    while (paramq.a("Authorization")) {
      return;
    }
    com.megvii.zhimasdk.b.a.a.h localh = (com.megvii.zhimasdk.b.a.a.h)parame.a("http.auth.target-scope");
    if (localh == null)
    {
      this.a.a("Target auth web_state not set in the context");
      return;
    }
    if (this.a.a()) {
      this.a.a("Target auth web_state: " + localh.b());
    }
    a(localh, paramq, parame);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */