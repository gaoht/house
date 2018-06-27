package com.google.c.b;

import com.google.c.a;
import com.google.c.a.b;
import com.google.c.q;
import java.util.Map;

public final class f
  extends r
{
  private static void a(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < 9)
    {
      if ((1 << i & paramInt) == 0) {}
      for (int j = 1;; j = 2)
      {
        paramArrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
  }
  
  public b encode(String paramString, a parama, int paramInt1, int paramInt2, Map<com.google.c.f, ?> paramMap)
    throws q
  {
    if (parama != a.c) {
      throw new IllegalArgumentException("Can only encode CODE_39, but got " + parama);
    }
    return super.encode(paramString, parama, paramInt1, paramInt2, paramMap);
  }
  
  public byte[] encode(String paramString)
  {
    int m = paramString.length();
    if (m > 80) {
      throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + m);
    }
    int[] arrayOfInt1 = new int[9];
    int i = m + 25;
    int j = 0;
    int k;
    while (j < m)
    {
      k = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(j));
      a(e.a[k], arrayOfInt1);
      int n = arrayOfInt1.length;
      k = 0;
      while (k < n)
      {
        i += arrayOfInt1[k];
        k += 1;
      }
      j += 1;
    }
    byte[] arrayOfByte = new byte[i];
    a(e.a[39], arrayOfInt1);
    i = a(arrayOfByte, 0, arrayOfInt1, 1);
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = 1;
    j = a(arrayOfByte, i, arrayOfInt2, 0) + i;
    i = m - 1;
    while (i >= 0)
    {
      k = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(i));
      a(e.a[k], arrayOfInt1);
      j += a(arrayOfByte, j, arrayOfInt1, 1);
      j += a(arrayOfByte, j, arrayOfInt2, 0);
      i -= 1;
    }
    a(e.a[39], arrayOfInt1);
    a(arrayOfByte, j, arrayOfInt1, 1);
    return arrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */