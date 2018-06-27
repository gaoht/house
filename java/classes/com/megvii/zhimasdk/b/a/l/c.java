package com.megvii.zhimasdk.b.a.l;

import com.megvii.zhimasdk.b.a.o.a;

@Deprecated
public final class c
{
  public static int a(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.socket.timeout", 0);
  }
  
  public static void a(e parame, int paramInt)
  {
    a.a(parame, "HTTP parameters");
    parame.b("http.socket.timeout", paramInt);
  }
  
  public static void a(e parame, boolean paramBoolean)
  {
    a.a(parame, "HTTP parameters");
    parame.b("http.tcp.nodelay", paramBoolean);
  }
  
  public static void b(e parame, int paramInt)
  {
    a.a(parame, "HTTP parameters");
    parame.b("http.socket.buffer-size", paramInt);
  }
  
  public static boolean b(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.socket.reuseaddr", false);
  }
  
  public static void c(e parame, int paramInt)
  {
    a.a(parame, "HTTP parameters");
    parame.b("http.connection.timeout", paramInt);
  }
  
  public static boolean c(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.tcp.nodelay", true);
  }
  
  public static int d(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.socket.linger", -1);
  }
  
  public static int e(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.connection.timeout", 0);
  }
  
  public static boolean f(e parame)
  {
    a.a(parame, "HTTP parameters");
    return parame.a("http.connection.stalecheck", true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/l/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */