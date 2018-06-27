package com.google.c.b;

import com.google.c.e;
import com.google.c.g;
import com.google.c.j;
import com.google.c.l;
import com.google.c.n;
import java.util.Map;

public final class k
  extends m
{
  static final int[][] a;
  private static final int[] b = { 44, 24, 20, 18, 16, 14, 12, 10, 8, 6 };
  private static final int[] d = { 1, 1, 1, 1 };
  private static final int[] e = { 1, 1, 3 };
  private int c = -1;
  
  static
  {
    int[] arrayOfInt1 = { 1, 3, 1, 1, 3 };
    int[] arrayOfInt2 = { 1, 1, 1, 3, 3 };
    int[] arrayOfInt3 = { 1, 3, 1, 3, 1 };
    a = new int[][] { { 1, 1, 3, 3, 1 }, { 3, 1, 1, 1, 3 }, arrayOfInt1, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, { 1, 3, 3, 1, 1 }, arrayOfInt2, { 3, 1, 1, 3, 1 }, arrayOfInt3 };
  }
  
  private static int a(int[] paramArrayOfInt)
    throws j
  {
    int j = 107;
    int k = -1;
    int n = a.length;
    int i = 0;
    if (i < n)
    {
      int m = a(paramArrayOfInt, a[i], 204);
      if (m >= j) {
        break label61;
      }
      k = i;
      j = m;
    }
    label61:
    for (;;)
    {
      i += 1;
      break;
      if (k >= 0) {
        return k;
      }
      throw j.getNotFoundInstance();
    }
  }
  
  private void a(com.google.c.a.a parama, int paramInt)
    throws j
  {
    int i = this.c * 10;
    paramInt -= 1;
    for (;;)
    {
      if ((i <= 0) || (paramInt < 0) || (parama.get(paramInt)))
      {
        if (i == 0) {
          break;
        }
        throw j.getNotFoundInstance();
      }
      i -= 1;
      paramInt -= 1;
    }
  }
  
  private static void a(com.google.c.a.a parama, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    while (paramInt1 < paramInt2)
    {
      a(parama, paramInt1, arrayOfInt1);
      int i = 0;
      while (i < 5)
      {
        j = i << 1;
        arrayOfInt2[i] = arrayOfInt1[j];
        arrayOfInt3[i] = arrayOfInt1[(j + 1)];
        i += 1;
      }
      paramStringBuilder.append((char)(a(arrayOfInt2) + 48));
      paramStringBuilder.append((char)(a(arrayOfInt3) + 48));
      int j = arrayOfInt1.length;
      i = 0;
      while (i < j)
      {
        paramInt1 += arrayOfInt1[i];
        i += 1;
      }
    }
  }
  
  private static int[] b(com.google.c.a.a parama, int paramInt, int[] paramArrayOfInt)
    throws j
  {
    int i1 = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i1];
    int i2 = parama.getSize();
    int i = paramInt;
    int m = 0;
    int k = 0;
    int j = paramInt;
    paramInt = i;
    if (j < i2)
    {
      if ((parama.get(j) ^ k))
      {
        arrayOfInt[m] += 1;
        i = k;
        k = paramInt;
      }
      for (;;)
      {
        j += 1;
        paramInt = k;
        k = i;
        break;
        if (m == i1 - 1)
        {
          if (a(arrayOfInt, paramArrayOfInt, 204) < 107) {
            return new int[] { paramInt, j };
          }
          i = paramInt + (arrayOfInt[0] + arrayOfInt[1]);
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i1 - 2);
          arrayOfInt[(i1 - 2)] = 0;
          arrayOfInt[(i1 - 1)] = 0;
        }
        for (paramInt = m - 1;; paramInt = m)
        {
          arrayOfInt[paramInt] = 1;
          if (k != 0) {
            break label202;
          }
          n = 1;
          k = i;
          m = paramInt;
          i = n;
          break;
          m += 1;
          i = paramInt;
        }
        label202:
        int n = 0;
        k = i;
        m = paramInt;
        i = n;
      }
    }
    throw j.getNotFoundInstance();
  }
  
  private static int c(com.google.c.a.a parama)
    throws j
  {
    int i = parama.getSize();
    int j = parama.getNextSet(0);
    if (j == i) {
      throw j.getNotFoundInstance();
    }
    return j;
  }
  
  int[] a(com.google.c.a.a parama)
    throws j
  {
    int[] arrayOfInt = b(parama, c(parama), d);
    this.c = (arrayOfInt[1] - arrayOfInt[0] >> 2);
    a(parama, arrayOfInt[0]);
    return arrayOfInt;
  }
  
  int[] b(com.google.c.a.a parama)
    throws j
  {
    parama.reverse();
    try
    {
      int[] arrayOfInt = b(parama, c(parama), e);
      a(parama, arrayOfInt[0]);
      int i = arrayOfInt[0];
      arrayOfInt[0] = (parama.getSize() - arrayOfInt[1]);
      arrayOfInt[1] = (parama.getSize() - i);
      return arrayOfInt;
    }
    finally
    {
      parama.reverse();
    }
  }
  
  public l decodeRow(int paramInt, com.google.c.a.a parama, Map<e, ?> paramMap)
    throws g, j
  {
    int[] arrayOfInt = a(parama);
    Object localObject1 = b(parama);
    Object localObject2 = new StringBuilder(20);
    a(parama, arrayOfInt[1], localObject1[0], (StringBuilder)localObject2);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramMap != null) {}
    for (parama = (int[])paramMap.get(e.f);; parama = null)
    {
      paramMap = parama;
      if (parama == null) {
        paramMap = b;
      }
      int j = ((String)localObject2).length();
      int k = paramMap.length;
      int i = 0;
      if (i < k) {
        if (j != paramMap[i]) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          throw g.getFormatInstance();
          i += 1;
          break;
        }
        parama = new n(arrayOfInt[1], paramInt);
        paramMap = new n(localObject1[0], paramInt);
        localObject1 = com.google.c.a.i;
        return new l((String)localObject2, null, new n[] { parama, paramMap }, (com.google.c.a)localObject1);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */