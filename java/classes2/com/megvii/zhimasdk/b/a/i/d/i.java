package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.f.m;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.h;

public class i
  implements c
{
  public void a(b paramb, e parame)
  {
    if (!b(paramb, parame)) {
      throw new g("Illegal path attribute \"" + paramb.e() + "\". Path of origin: \"" + parame.b() + "\"");
    }
  }
  
  public void a(m paramm, String paramString)
  {
    a.a(paramm, "Cookie");
    if (!h.b(paramString)) {}
    for (;;)
    {
      paramm.e(paramString);
      return;
      paramString = "/";
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    String str = parame.b();
    parame = paramb.e();
    paramb = parame;
    if (parame == null) {
      paramb = "/";
    }
    parame = paramb;
    if (paramb.length() > 1)
    {
      parame = paramb;
      if (paramb.endsWith("/")) {
        parame = paramb.substring(0, paramb.length() - 1);
      }
    }
    boolean bool = str.startsWith(parame);
    if ((bool) && (str.length() != parame.length()) && (!parame.endsWith("/"))) {
      return str.charAt(parame.length()) == '/';
    }
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */