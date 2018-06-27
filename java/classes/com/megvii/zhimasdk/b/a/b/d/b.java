package com.megvii.zhimasdk.b.a.b.d;

import com.megvii.zhimasdk.b.a.l.c;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.o.a;

@Deprecated
public class b
{
  public static boolean a(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.protocol.handle-redirects", true);
  }
  
  public static boolean b(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.protocol.handle-authentication", true);
  }
  
  public static long c(e parame)
  {
    a.a(parame, "HTTP parameters");
    Long localLong = (Long)parame.a("http.conn-manager.timeout");
    if (localLong != null) {
      return localLong.longValue();
    }
    return c.e(parame);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */