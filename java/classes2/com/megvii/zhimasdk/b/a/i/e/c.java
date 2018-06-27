package com.megvii.zhimasdk.b.a.i.e;

import com.megvii.zhimasdk.b.a.aa;
import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.g.d;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.p;

public class c
  implements d
{
  public static final c a = new c();
  private final int b;
  
  public c()
  {
    this(-1);
  }
  
  public c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public long a(p paramp)
  {
    a.a(paramp, "HTTP message");
    e locale = paramp.c("Transfer-Encoding");
    int i;
    if (locale != null)
    {
      do
      {
        try
        {
          paramp = locale.e();
          i = paramp.length;
          if ("identity".equalsIgnoreCase(locale.d())) {
            return -1L;
          }
        }
        catch (aa paramp)
        {
          throw new ab("Invalid Transfer-Encoding header value: " + locale, paramp);
        }
      } while ((i <= 0) || (!"chunked".equalsIgnoreCase(paramp[(i - 1)].a())));
      return -2L;
    }
    if (paramp.c("Content-Length") != null)
    {
      paramp = paramp.b("Content-Length");
      i = paramp.length - 1;
      label133:
      if (i < 0) {
        break label176;
      }
      locale = paramp[i];
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong(locale.d());
        if (l < 0L) {
          break;
        }
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i -= 1;
      }
      break label133;
      return this.b;
      label176:
      long l = -1L;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */