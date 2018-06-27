package com.google.c.b;

import com.google.c.a;
import com.google.c.a.b;
import com.google.c.f;
import com.google.c.p;
import com.google.c.q;
import java.util.Map;

public abstract class n
  implements p
{
  private final int a;
  
  protected n(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected static int a(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt2 != 1)) {
      throw new IllegalArgumentException("startColor must be either 0 or 1, but got: " + paramInt2);
    }
    int i = (byte)paramInt2;
    int n = paramArrayOfInt.length;
    int j = 0;
    int k = 0;
    paramInt2 = paramInt1;
    paramInt1 = k;
    while (j < n)
    {
      int i1 = paramArrayOfInt[j];
      k = paramInt1;
      int m = 0;
      paramInt1 = paramInt2;
      paramInt2 = k;
      k = m;
      while (k < i1)
      {
        paramArrayOfByte[paramInt1] = i;
        paramInt1 += 1;
        paramInt2 += 1;
        k += 1;
      }
      i = (byte)(i ^ 0x1);
      k = j + 1;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
      j = k;
    }
    return paramInt1;
  }
  
  private b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    int k = this.a + i;
    int m = Math.max(paramInt1, k);
    int j = Math.max(1, paramInt2);
    k = m / k;
    paramInt1 = (m - i * k) / 2;
    b localb = new b(m, j);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      if (paramArrayOfByte[paramInt2] == 1) {
        localb.setRegion(paramInt1, 0, k, j);
      }
      paramInt2 += 1;
      paramInt1 += k;
    }
    return localb;
  }
  
  public b encode(String paramString, a parama, int paramInt1, int paramInt2)
    throws q
  {
    return encode(paramString, parama, paramInt1, paramInt2, null);
  }
  
  public b encode(String paramString, a parama, int paramInt1, int paramInt2, Map<f, ?> paramMap)
    throws q
  {
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("Found empty contents");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("Negative size is not allowed. Input: " + paramInt1 + 'x' + paramInt2);
    }
    return a(encode(paramString), paramInt1, paramInt2);
  }
  
  public abstract byte[] encode(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */