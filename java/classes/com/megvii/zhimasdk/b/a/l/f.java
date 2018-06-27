package com.megvii.zhimasdk.b.a.l;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.n.d;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.v;
import java.nio.charset.Charset;

@Deprecated
public final class f
{
  public static String a(e parame)
  {
    a.a(parame, "HTTP parameters");
    String str = (String)parame.a("http.protocol.element-charset");
    parame = str;
    if (str == null) {
      parame = d.b.name();
    }
    return parame;
  }
  
  public static void a(e parame, ac paramac)
  {
    a.a(parame, "HTTP parameters");
    parame.a("http.protocol.version", paramac);
  }
  
  public static void a(e parame, String paramString)
  {
    a.a(parame, "HTTP parameters");
    parame.a("http.protocol.content-charset", paramString);
  }
  
  public static ac b(e parame)
  {
    a.a(parame, "HTTP parameters");
    parame = parame.a("http.protocol.version");
    if (parame == null) {
      return v.c;
    }
    return (ac)parame;
  }
  
  public static void b(e parame, String paramString)
  {
    a.a(parame, "HTTP parameters");
    parame.a("http.useragent", paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/l/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */