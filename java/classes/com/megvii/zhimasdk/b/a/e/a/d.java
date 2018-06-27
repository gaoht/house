package com.megvii.zhimasdk.b.a.e.a;

import com.megvii.zhimasdk.b.a.e.b.b;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import java.net.InetAddress;

@Deprecated
public class d
{
  public static final n a = new n("127.0.0.255", 0, "no-host");
  public static final b b = new b(a);
  
  public static n a(e parame)
  {
    a.a(parame, "Parameters");
    n localn = (n)parame.a("http.route.default-proxy");
    parame = localn;
    if (localn != null)
    {
      parame = localn;
      if (a.equals(localn)) {
        parame = null;
      }
    }
    return parame;
  }
  
  public static b b(e parame)
  {
    a.a(parame, "Parameters");
    b localb = (b)parame.a("http.route.forced-route");
    parame = localb;
    if (localb != null)
    {
      parame = localb;
      if (b.equals(localb)) {
        parame = null;
      }
    }
    return parame;
  }
  
  public static InetAddress c(e parame)
  {
    a.a(parame, "Parameters");
    return (InetAddress)parame.a("http.route.local-address");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */