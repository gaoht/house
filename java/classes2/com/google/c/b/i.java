package com.google.c.b;

import com.google.c.a;
import com.google.c.a.b;
import com.google.c.f;
import java.util.Map;

public final class i
  extends r
{
  public b encode(String paramString, a parama, int paramInt1, int paramInt2, Map<f, ?> paramMap)
    throws com.google.c.q
  {
    if (parama != a.g) {
      throw new IllegalArgumentException("Can only encode EAN_8, but got " + parama);
    }
    return super.encode(paramString, parama, paramInt1, paramInt2, paramMap);
  }
  
  public byte[] encode(String paramString)
  {
    if (paramString.length() != 8) {
      throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + paramString.length());
    }
    byte[] arrayOfByte = new byte[67];
    int j = a(arrayOfByte, 0, q.b, 1) + 0;
    int i = 0;
    int k;
    while (i <= 3)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfByte, j, q.d[k], 0);
      i += 1;
    }
    j += a(arrayOfByte, j, q.c, 0);
    i = 4;
    while (i <= 7)
    {
      k = Integer.parseInt(paramString.substring(i, i + 1));
      j += a(arrayOfByte, j, q.d[k], 1);
      i += 1;
    }
    a(arrayOfByte, j, q.b, 1);
    return arrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */