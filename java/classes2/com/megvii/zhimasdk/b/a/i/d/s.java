package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.Locale;
import java.util.StringTokenizer;

public class s
  extends f
{
  private static boolean a(String paramString)
  {
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    return (paramString.endsWith(".COM")) || (paramString.endsWith(".EDU")) || (paramString.endsWith(".NET")) || (paramString.endsWith(".GOV")) || (paramString.endsWith(".MIL")) || (paramString.endsWith(".ORG")) || (paramString.endsWith(".INT"));
  }
  
  public void a(b paramb, e parame)
  {
    super.a(paramb, parame);
    parame = parame.a();
    paramb = paramb.d();
    if (parame.contains("."))
    {
      int i = new StringTokenizer(paramb, ".").countTokens();
      if (a(paramb))
      {
        if (i < 2) {
          throw new g("Domain attribute \"" + paramb + "\" violates the Netscape cookie specification for " + "special domains");
        }
      }
      else if (i < 3) {
        throw new g("Domain attribute \"" + paramb + "\" violates the Netscape cookie specification");
      }
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    parame = parame.a();
    paramb = paramb.d();
    if (paramb == null) {
      return false;
    }
    return parame.endsWith(paramb);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */