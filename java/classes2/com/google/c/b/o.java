package com.google.c.b;

import com.google.c.a;
import com.google.c.a.b;
import com.google.c.f;
import com.google.c.p;
import com.google.c.q;
import java.util.Map;

public class o
  implements p
{
  private final h a = new h();
  
  private static String a(String paramString)
  {
    int i = paramString.length();
    String str;
    if (i == 11)
    {
      i = 0;
      int j = 0;
      if (i < 11)
      {
        int m = paramString.charAt(i);
        if (i % 2 == 0) {}
        for (int k = 3;; k = 1)
        {
          j += k * (m - 48);
          i += 1;
          break;
        }
      }
      str = paramString + (1000 - j) % 10;
    }
    do
    {
      return '0' + str;
      str = paramString;
    } while (i == 12);
    throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + paramString.length());
  }
  
  public b encode(String paramString, a parama, int paramInt1, int paramInt2)
    throws q
  {
    return encode(paramString, parama, paramInt1, paramInt2, null);
  }
  
  public b encode(String paramString, a parama, int paramInt1, int paramInt2, Map<f, ?> paramMap)
    throws q
  {
    if (parama != a.o) {
      throw new IllegalArgumentException("Can only encode UPC-A, but got " + parama);
    }
    return this.a.encode(a(paramString), a.h, paramInt1, paramInt2, paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */