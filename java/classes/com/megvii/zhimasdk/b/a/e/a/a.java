package com.megvii.zhimasdk.b.a.e.a;

import com.megvii.zhimasdk.b.a.l.e;

@Deprecated
public final class a
{
  private static final b a = new a.1();
  
  public static b a(e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    b localb = (b)parame.a("http.conn-manager.max-per-route");
    parame = localb;
    if (localb == null) {
      parame = a;
    }
    return parame;
  }
  
  public static void a(e parame, int paramInt)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    parame.b("http.conn-manager.max-total", paramInt);
  }
  
  @Deprecated
  public static void a(e parame, long paramLong)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    parame.b("http.conn-manager.timeout", paramLong);
  }
  
  public static void a(e parame, b paramb)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    parame.a("http.conn-manager.max-per-route", paramb);
  }
  
  public static int b(e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    return parame.a("http.conn-manager.max-total", 20);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */