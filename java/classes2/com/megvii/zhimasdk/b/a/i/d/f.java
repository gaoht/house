package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import com.megvii.zhimasdk.b.a.o.a;

public class f
  implements c
{
  public void a(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    String str = parame.a();
    parame = paramb.d();
    if (parame == null) {
      throw new g("Cookie domain may not be null");
    }
    if (str.contains("."))
    {
      if (!str.endsWith(parame))
      {
        paramb = parame;
        if (parame.startsWith(".")) {
          paramb = parame.substring(1, parame.length());
        }
        if (!str.equals(paramb)) {
          throw new g("Illegal domain attribute \"" + paramb + "\". Domain of origin: \"" + str + "\"");
        }
      }
    }
    else if (!str.equals(parame)) {
      throw new g("Illegal domain attribute \"" + parame + "\". Domain of origin: \"" + str + "\"");
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
    String str = parame.a();
    parame = paramb.d();
    if (parame == null) {
      return false;
    }
    if (str.equals(parame)) {
      return true;
    }
    paramb = parame;
    if (!parame.startsWith(".")) {
      paramb = '.' + parame;
    }
    if ((str.endsWith(paramb)) || (str.equals(paramb.substring(1)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */