package com.megvii.zhimasdk.b.a.g;

import com.megvii.zhimasdk.b.a.c;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.o.h;
import com.megvii.zhimasdk.b.a.y;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;

public final class e
  implements Serializable
{
  public static final e a = a("application/atom+xml", c.c);
  public static final e b = a("application/x-www-form-urlencoded", c.c);
  public static final e c = a("application/json", c.a);
  public static final e d = a("application/octet-stream", (Charset)null);
  public static final e e = a("application/svg+xml", c.c);
  public static final e f = a("application/xhtml+xml", c.c);
  public static final e g = a("application/xml", c.c);
  public static final e h = a("multipart/form-data", c.c);
  public static final e i = a("text/html", c.c);
  public static final e j = a("text/plain", c.c);
  public static final e k = a("text/xml", c.c);
  public static final e l = a("*/*", (Charset)null);
  public static final e m = j;
  public static final e n = d;
  private final String o;
  private final Charset p;
  private final y[] q;
  
  e(String paramString, Charset paramCharset)
  {
    this.o = paramString;
    this.p = paramCharset;
    this.q = null;
  }
  
  public static e a(String paramString1, String paramString2)
  {
    if (!h.b(paramString2)) {}
    for (paramString2 = Charset.forName(paramString2);; paramString2 = null) {
      return a(paramString1, paramString2);
    }
  }
  
  public static e a(String paramString, Charset paramCharset)
  {
    paramString = ((String)a.b(paramString, "MIME type")).toLowerCase(Locale.ENGLISH);
    a.a(a(paramString), "MIME type may not contain reserved characters");
    return new e(paramString, paramCharset);
  }
  
  private static boolean a(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      int i2 = paramString.charAt(i1);
      if ((i2 == 34) || (i2 == 44) || (i2 == 59)) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public Charset a()
  {
    return this.p;
  }
  
  public String toString()
  {
    d locald = new d(64);
    locald.a(this.o);
    if (this.q != null)
    {
      locald.a("; ");
      com.megvii.zhimasdk.b.a.k.e.b.a(locald, this.q, false);
    }
    for (;;)
    {
      return locald.toString();
      if (this.p != null)
      {
        locald.a("; charset=");
        locald.a(this.p.name());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */