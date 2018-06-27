package com.google.c.b;

import com.google.c.j;

public final class g
  extends q
{
  static final int[] a = { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
  private final int[] f = new int[4];
  
  private static void a(StringBuilder paramStringBuilder, int paramInt)
    throws j
  {
    int i = 0;
    while (i < 10)
    {
      if (paramInt == a[i])
      {
        paramStringBuilder.insert(0, (char)(i + 48));
        return;
      }
      i += 1;
    }
    throw j.getNotFoundInstance();
  }
  
  protected int a(com.google.c.a.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt = this.f;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int n = parama.getSize();
    int i = paramArrayOfInt[1];
    int j = 0;
    int m;
    for (int k = 0; (j < 6) && (i < n); k = m)
    {
      int i1 = a(parama, arrayOfInt, i, e);
      paramStringBuilder.append((char)(i1 % 10 + 48));
      int i2 = arrayOfInt.length;
      m = 0;
      while (m < i2)
      {
        i += arrayOfInt[m];
        m += 1;
      }
      m = k;
      if (i1 >= 10) {
        m = k | 1 << 5 - j;
      }
      j += 1;
    }
    a(paramStringBuilder, k);
    i = a(parama, i, true, c)[1];
    j = 0;
    while ((j < 6) && (i < n))
    {
      paramStringBuilder.append((char)(a(parama, arrayOfInt, i, d) + 48));
      m = arrayOfInt.length;
      k = 0;
      while (k < m)
      {
        i += arrayOfInt[k];
        k += 1;
      }
      j += 1;
    }
    return i;
  }
  
  com.google.c.a a()
  {
    return com.google.c.a.h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */