package com.google.c.b;

import com.google.c.a;
import com.google.c.a.b;
import com.google.c.f;
import java.util.Map;

public final class h
  extends r
{
  public b encode(String paramString, a parama, int paramInt1, int paramInt2, Map<f, ?> paramMap)
    throws com.google.c.q
  {
    if (parama != a.h) {
      throw new IllegalArgumentException("Can only encode EAN_13, but got " + parama);
    }
    return super.encode(paramString, parama, paramInt1, paramInt2, paramMap);
  }
  
  public byte[] encode(String paramString)
  {
    if (paramString.length() != 13) {
      throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + paramString.length());
    }
    int i = Integer.parseInt(paramString.substring(0, 1));
    int n = g.a[i];
    byte[] arrayOfByte = new byte[95];
    int j = a(arrayOfByte, 0, q.b, 1);
    i = 1;
    j += 0;
    int k;
    while (i <= 6)
    {
      int m = Integer.parseInt(paramString.substring(i, i + 1));
      k = m;
      if ((n >> 6 - i & 0x1) == 1) {
        k = m + 10;
      }
      j += a(arrayOfByte, j, q.e[k], 0);
      i += 1;
    }
    j += a(arrayOfByte, j, q.c, 0);
    i = 7;
    while (i <= 12)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfByte, j, q.d[k], 1);
      i += 1;
    }
    a(arrayOfByte, j, q.b, 1);
    return arrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */