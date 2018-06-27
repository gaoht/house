package com.megvii.zhimasdk.b.a.b.d;

import com.megvii.zhimasdk.b.a.b.a.a.a;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.n;
import java.net.InetAddress;
import java.util.Collection;

@Deprecated
public final class a
{
  public static com.megvii.zhimasdk.b.a.b.a.a a(e parame)
  {
    a.a locala = com.megvii.zhimasdk.b.a.b.a.a.g().d(parame.a("http.socket.timeout", 0)).b(parame.a("http.connection.stalecheck", true)).c(parame.a("http.connection.timeout", 0)).a(parame.a("http.protocol.expect-continue", false)).a((n)parame.a("http.route.default-proxy")).a((InetAddress)parame.a("http.route.local-address")).b((Collection)parame.a("http.auth.proxy-scheme-pref")).a((Collection)parame.a("http.auth.target-scheme-pref")).f(parame.a("http.protocol.handle-authentication", true)).e(parame.a("http.protocol.allow-circular-redirects", false)).b((int)parame.a("http.conn-manager.timeout", 0L)).a((String)parame.a("http.protocol.cookie-policy")).a(parame.a("http.protocol.max-redirects", 50)).c(parame.a("http.protocol.handle-redirects", true));
    if (!parame.a("http.protocol.reject-relative-redirect", false)) {}
    for (boolean bool = true;; bool = false) {
      return locala.d(bool).a();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */