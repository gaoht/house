package com.megvii.zhimasdk.b.a.b.e;

import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.h.b;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;

public class e
  implements r
{
  public b a = new b(getClass());
  
  public void a(q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "HTTP request");
    if (paramq.h().a().equalsIgnoreCase("CONNECT")) {
      paramq.b("Proxy-Connection", "Keep-Alive");
    }
    do
    {
      return;
      parame = a.a(parame).a();
      if (parame == null)
      {
        this.a.a("Connection route not set in the context");
        return;
      }
      if (((parame.c() == 1) || (parame.e())) && (!paramq.a("Connection"))) {
        paramq.a("Connection", "Keep-Alive");
      }
    } while ((parame.c() != 2) || (parame.e()) || (paramq.a("Proxy-Connection")));
    paramq.a("Proxy-Connection", "Keep-Alive");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */