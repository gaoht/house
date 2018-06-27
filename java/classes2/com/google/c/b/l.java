package com.google.c.b;

import com.google.c.a;
import com.google.c.a.b;
import com.google.c.f;
import com.google.c.q;
import java.util.Map;

public final class l
  extends r
{
  public b encode(String paramString, a parama, int paramInt1, int paramInt2, Map<f, ?> paramMap)
    throws q
  {
    if (parama != a.i) {
      throw new IllegalArgumentException("Can only encode ITF, but got " + parama);
    }
    return super.encode(paramString, parama, paramInt1, paramInt2, paramMap);
  }
  
  public byte[] encode(String paramString)
  {
    int m = paramString.length();
    if (m % 2 != 0) {
      throw new IllegalArgumentException("The lenght of the input should be even");
    }
    if (m > 80) {
      throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + m);
    }
    byte[] arrayOfByte = new byte[m * 9 + 9];
    int j = a(arrayOfByte, 0, new int[] { 1, 1, 1, 1 }, 1);
    int i = 0;
    while (i < m)
    {
      int n = Character.digit(paramString.charAt(i), 10);
      int i1 = Character.digit(paramString.charAt(i + 1), 10);
      int[] arrayOfInt = new int[18];
      int k = 0;
      while (k < 5)
      {
        arrayOfInt[(k << 1)] = k.a[n][k];
        arrayOfInt[((k << 1) + 1)] = k.a[i1][k];
        k += 1;
      }
      j += a(arrayOfByte, j, arrayOfInt, 1);
      i += 2;
    }
    a(arrayOfByte, j, new int[] { 3, 1, 1 }, 1);
    return arrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */