package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.c;
import com.megvii.zhimasdk.b.a.f.e;
import com.megvii.zhimasdk.b.a.f.g;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.m;
import java.util.Locale;

public class ac
  implements c
{
  public void a(b paramb, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Cookie origin");
    parame = parame.a().toLowerCase(Locale.ENGLISH);
    if (paramb.d() == null) {
      throw new g("Invalid cookie web_state: domain not specified");
    }
    String str = paramb.d().toLowerCase(Locale.ENGLISH);
    if (((paramb instanceof com.megvii.zhimasdk.b.a.f.a)) && (((com.megvii.zhimasdk.b.a.f.a)paramb).b("domain")))
    {
      if (!str.startsWith(".")) {
        throw new g("Domain attribute \"" + paramb.d() + "\" violates RFC 2109: domain must start with a dot");
      }
      int i = str.indexOf('.', 1);
      if (((i < 0) || (i == str.length() - 1)) && (!str.equals(".local"))) {
        throw new g("Domain attribute \"" + paramb.d() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
      }
      if (!a(parame, str)) {
        throw new g("Domain attribute \"" + paramb.d() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
      }
      if (parame.substring(0, parame.length() - str.length()).indexOf('.') != -1) {
        throw new g("Domain attribute \"" + paramb.d() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
      }
    }
    else if (!paramb.d().equals(parame))
    {
      throw new g("Illegal domain attribute: \"" + paramb.d() + "\"." + "Domain of origin: \"" + parame + "\"");
    }
  }
  
  public void a(m paramm, String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for domain attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new l("Blank value for domain attribute");
    }
    String str2 = paramString.toLowerCase(Locale.ENGLISH);
    String str1 = str2;
    if (!paramString.startsWith(".")) {
      str1 = '.' + str2;
    }
    paramm.d(str1);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return (paramString1.equals(paramString2)) || ((paramString2.startsWith(".")) && (paramString1.endsWith(paramString2)));
  }
  
  public boolean b(b paramb, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Cookie");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "Cookie origin");
    parame = parame.a().toLowerCase(Locale.ENGLISH);
    paramb = paramb.d();
    if (!a(parame, paramb)) {}
    while (parame.substring(0, parame.length() - paramb.length()).indexOf('.') != -1) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */