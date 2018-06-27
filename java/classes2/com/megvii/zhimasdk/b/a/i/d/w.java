package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.Locale;

public class w
  implements c
{
  public void a(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    parame = parame.a();
    paramb = paramb.d();
    if (paramb == null) {
      throw new g("Cookie domain may not be null");
    }
    if (!paramb.equals(parame))
    {
      if (paramb.indexOf('.') == -1) {
        throw new g("Domain attribute \"" + paramb + "\" does not match the host \"" + parame + "\"");
      }
      if (!paramb.startsWith(".")) {
        throw new g("Domain attribute \"" + paramb + "\" violates RFC 2109: domain must start with a dot");
      }
      int i = paramb.indexOf('.', 1);
      if ((i < 0) || (i == paramb.length() - 1)) {
        throw new g("Domain attribute \"" + paramb + "\" violates RFC 2109: domain must contain an embedded dot");
      }
      parame = parame.toLowerCase(Locale.ENGLISH);
      if (!parame.endsWith(paramb)) {
        throw new g("Illegal domain attribute \"" + paramb + "\". Domain of origin: \"" + parame + "\"");
      }
      if (parame.substring(0, parame.length() - paramb.length()).indexOf('.') != -1) {
        throw new g("Domain attribute \"" + paramb + "\" violates RFC 2109: host minus domain may not contain any dots");
      }
    }
  }
  
  public void a(m paramm, String paramString)
  {
    a.a(paramm, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for domain attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new l("Blank value for domain attribute");
    }
    paramm.d(paramString);
  }
  
  public boolean b(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    parame = parame.a();
    paramb = paramb.d();
    if (paramb == null) {}
    while ((!parame.equals(paramb)) && ((!paramb.startsWith(".")) || (!parame.endsWith(paramb)))) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */