package com.google.c.b;

import com.google.c.d;
import com.google.c.g;
import com.google.c.j;
import com.google.c.l;
import com.google.c.n;
import java.util.Map;

public final class e
  extends m
{
  static final int[] a = { 52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42 };
  private static final char[] b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
  private static final int c = a[39];
  private final boolean d;
  private final boolean e;
  
  public e()
  {
    this.d = false;
    this.e = false;
  }
  
  public e(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.e = false;
  }
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  private static char a(int paramInt)
    throws j
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i] == paramInt) {
        return b[i];
      }
      i += 1;
    }
    throw j.getNotFoundInstance();
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i4 = paramArrayOfInt.length;
    int i;
    for (int j = 0;; j = i)
    {
      i = Integer.MAX_VALUE;
      int k = 0;
      while (k < i4)
      {
        n = paramArrayOfInt[k];
        m = i;
        if (n < i)
        {
          m = i;
          if (n > j) {
            m = n;
          }
        }
        k += 1;
        i = m;
      }
      int n = 0;
      j = 0;
      int m = 0;
      int i2;
      int i1;
      for (k = 0; n < i4; k = i1)
      {
        int i5 = paramArrayOfInt[n];
        int i3 = j;
        i2 = m;
        i1 = k;
        if (paramArrayOfInt[n] > i)
        {
          i3 = j | 1 << i4 - 1 - n;
          i1 = k + 1;
          i2 = m + i5;
        }
        n += 1;
        j = i3;
        m = i2;
      }
      if (k == 3)
      {
        n = k;
        k = 0;
        for (;;)
        {
          i1 = j;
          if (k < i4)
          {
            i1 = j;
            if (n > 0)
            {
              i2 = paramArrayOfInt[k];
              i1 = n;
              if (paramArrayOfInt[k] <= i) {
                break label203;
              }
              i1 = n - 1;
              if (i2 << 1 < m) {
                break label203;
              }
              i1 = -1;
            }
          }
          return i1;
          label203:
          k += 1;
          n = i1;
        }
      }
      if (k <= 3) {
        return -1;
      }
    }
  }
  
  private static String a(CharSequence paramCharSequence)
    throws g
  {
    int j = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c1 = paramCharSequence.charAt(i);
      int k;
      if ((c1 == '+') || (c1 == '$') || (c1 == '%') || (c1 == '/'))
      {
        k = paramCharSequence.charAt(i + 1);
        switch (c1)
        {
        default: 
          c1 = '\000';
          label114:
          localStringBuilder.append(c1);
          i += 1;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((k >= 65) && (k <= 90))
        {
          c1 = (char)(k + 32);
          break label114;
        }
        throw g.getFormatInstance();
        if ((k >= 65) && (k <= 90))
        {
          c1 = (char)(k - 64);
          break label114;
        }
        throw g.getFormatInstance();
        if ((k >= 65) && (k <= 69))
        {
          c1 = (char)(k - 38);
          break label114;
        }
        if ((k >= 70) && (k <= 87))
        {
          c1 = (char)(k - 11);
          break label114;
        }
        throw g.getFormatInstance();
        if ((k >= 65) && (k <= 79))
        {
          c1 = (char)(k - 32);
          break label114;
        }
        if (k == 90)
        {
          c1 = ':';
          break label114;
        }
        throw g.getFormatInstance();
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static int[] a(com.google.c.a.a parama, int[] paramArrayOfInt)
    throws j
  {
    int i2 = parama.getSize();
    int i = parama.getNextSet(0);
    int i3 = paramArrayOfInt.length;
    int k = i;
    int m = 0;
    int n = 0;
    if (k < i2)
    {
      int j;
      if ((parama.get(k) ^ m))
      {
        paramArrayOfInt[n] += 1;
        j = m;
        m = i;
      }
      for (;;)
      {
        k += 1;
        i = m;
        m = j;
        break;
        if (n == i3 - 1)
        {
          if ((a(paramArrayOfInt) == c) && (parama.isRange(Math.max(0, i - (k - i >> 1)), i, false))) {
            return new int[] { i, k };
          }
          j = i + (paramArrayOfInt[0] + paramArrayOfInt[1]);
          System.arraycopy(paramArrayOfInt, 2, paramArrayOfInt, 0, i3 - 2);
          paramArrayOfInt[(i3 - 2)] = 0;
          paramArrayOfInt[(i3 - 1)] = 0;
        }
        for (i = n - 1;; i = n)
        {
          paramArrayOfInt[i] = 1;
          if (m != 0) {
            break label206;
          }
          i1 = 1;
          m = j;
          n = i;
          j = i1;
          break;
          n += 1;
          j = i;
        }
        label206:
        int i1 = 0;
        m = j;
        n = i;
        j = i1;
      }
    }
    throw j.getNotFoundInstance();
  }
  
  public l decodeRow(int paramInt, com.google.c.a.a parama, Map<com.google.c.e, ?> paramMap)
    throws j, d, g
  {
    Object localObject1 = new int[9];
    paramMap = a(parama, (int[])localObject1);
    int i = parama.getNextSet(paramMap[1]);
    int n = parama.getSize();
    Object localObject2 = new StringBuilder(20);
    for (;;)
    {
      a(parama, i, (int[])localObject1);
      int j = a((int[])localObject1);
      if (j < 0) {
        throw j.getNotFoundInstance();
      }
      char c1 = a(j);
      ((StringBuilder)localObject2).append(c1);
      int m = localObject1.length;
      j = 0;
      int k = i;
      while (j < m)
      {
        k += localObject1[j];
        j += 1;
      }
      m = parama.getNextSet(k);
      if (c1 == '*')
      {
        ((StringBuilder)localObject2).setLength(((StringBuilder)localObject2).length() - 1);
        k = 0;
        int i1 = localObject1.length;
        j = 0;
        while (j < i1)
        {
          k += localObject1[j];
          j += 1;
        }
        if ((m != n) && (m - i - k >> 1 < k)) {
          throw j.getNotFoundInstance();
        }
        if (this.d)
        {
          n = ((StringBuilder)localObject2).length() - 1;
          k = 0;
          j = 0;
          while (j < n)
          {
            k += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(((StringBuilder)localObject2).charAt(j));
            j += 1;
          }
          if (((StringBuilder)localObject2).charAt(n) != b[(k % 43)]) {
            throw d.getChecksumInstance();
          }
          ((StringBuilder)localObject2).setLength(n);
        }
        if (((StringBuilder)localObject2).length() == 0) {
          throw j.getNotFoundInstance();
        }
        if (this.e) {}
        for (parama = a((CharSequence)localObject2);; parama = ((StringBuilder)localObject2).toString())
        {
          float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
          float f2 = (i + m) / 2.0F;
          paramMap = new n(f1, paramInt);
          localObject1 = new n(f2, paramInt);
          localObject2 = com.google.c.a.c;
          return new l(parama, null, new n[] { paramMap, localObject1 }, (com.google.c.a)localObject2);
        }
      }
      i = m;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */