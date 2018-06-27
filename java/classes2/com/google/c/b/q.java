package com.google.c.b;

import com.google.c.d;
import com.google.c.e;
import com.google.c.g;
import com.google.c.k;
import com.google.c.l;
import com.google.c.n;
import com.google.c.o;
import java.util.Arrays;
import java.util.Map;

public abstract class q
  extends m
{
  static final int[] b = { 1, 1, 1 };
  static final int[] c = { 1, 1, 1, 1, 1 };
  static final int[][] d = { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, { 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2 }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
  static final int[][] e = new int[20][];
  private final StringBuilder a = new StringBuilder(20);
  private final p f = new p();
  private final j g = new j();
  
  static
  {
    System.arraycopy(d, 0, e, 0, 10);
    int i = 10;
    while (i < 20)
    {
      int[] arrayOfInt1 = d[(i - 10)];
      int[] arrayOfInt2 = new int[arrayOfInt1.length];
      int j = 0;
      while (j < arrayOfInt1.length)
      {
        arrayOfInt2[j] = arrayOfInt1[(arrayOfInt1.length - j - 1)];
        j += 1;
      }
      e[i] = arrayOfInt2;
      i += 1;
    }
  }
  
  static int a(com.google.c.a.a parama, int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
    throws com.google.c.j
  {
    a(parama, paramInt, paramArrayOfInt);
    int i = 122;
    int j = -1;
    int m = paramArrayOfInt1.length;
    paramInt = 0;
    if (paramInt < m)
    {
      int k = a(paramArrayOfInt, paramArrayOfInt1[paramInt], 179);
      if (k >= i) {
        break label70;
      }
      j = paramInt;
      i = k;
    }
    label70:
    for (;;)
    {
      paramInt += 1;
      break;
      if (j >= 0) {
        return j;
      }
      throw com.google.c.j.getNotFoundInstance();
    }
  }
  
  private static boolean a(CharSequence paramCharSequence)
    throws g
  {
    int k = paramCharSequence.length();
    if (k == 0) {}
    int j;
    do
    {
      return false;
      int i = k - 2;
      j = 0;
      while (i >= 0)
      {
        int m = paramCharSequence.charAt(i) - '0';
        if ((m < 0) || (m > 9)) {
          throw g.getFormatInstance();
        }
        j += m;
        i -= 2;
      }
      j *= 3;
      i = k - 1;
      while (i >= 0)
      {
        k = paramCharSequence.charAt(i) - '0';
        if ((k < 0) || (k > 9)) {
          throw g.getFormatInstance();
        }
        j += k;
        i -= 2;
      }
    } while (j % 10 != 0);
    return true;
  }
  
  static int[] a(com.google.c.a.a parama)
    throws com.google.c.j
  {
    int[] arrayOfInt2 = new int[b.length];
    int i = 0;
    Object localObject = null;
    boolean bool = false;
    while (!bool)
    {
      Arrays.fill(arrayOfInt2, 0, b.length, 0);
      int[] arrayOfInt1 = a(parama, i, false, b, arrayOfInt2);
      int k = arrayOfInt1[0];
      int j = arrayOfInt1[1];
      int m = k - (j - k);
      i = j;
      localObject = arrayOfInt1;
      if (m >= 0)
      {
        bool = parama.isRange(m, k, false);
        i = j;
        localObject = arrayOfInt1;
      }
    }
    return (int[])localObject;
  }
  
  static int[] a(com.google.c.a.a parama, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
    throws com.google.c.j
  {
    return a(parama, paramInt, paramBoolean, paramArrayOfInt, new int[paramArrayOfInt.length]);
  }
  
  static int[] a(com.google.c.a.a parama, int paramInt, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws com.google.c.j
  {
    int m = paramArrayOfInt1.length;
    int n = parama.getSize();
    int j;
    int i;
    label26:
    int k;
    if (paramBoolean)
    {
      paramInt = parama.getNextUnset(paramInt);
      j = paramInt;
      i = 0;
      if (j >= n) {
        break label215;
      }
      if (!(parama.get(j) ^ paramBoolean)) {
        break label88;
      }
      paramArrayOfInt2[i] += 1;
      k = i;
      i = paramInt;
    }
    for (;;)
    {
      j += 1;
      paramInt = i;
      i = k;
      break label26;
      paramInt = parama.getNextSet(paramInt);
      break;
      label88:
      if (i == m - 1)
      {
        if (a(paramArrayOfInt2, paramArrayOfInt1, 179) < 122) {
          return new int[] { paramInt, j };
        }
        k = paramInt + (paramArrayOfInt2[0] + paramArrayOfInt2[1]);
        System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, m - 2);
        paramArrayOfInt2[(m - 2)] = 0;
        paramArrayOfInt2[(m - 1)] = 0;
        paramInt = i - 1;
        i = k;
      }
      for (;;)
      {
        paramArrayOfInt2[paramInt] = 1;
        if (paramBoolean) {
          break label207;
        }
        paramBoolean = true;
        k = paramInt;
        break;
        k = i + 1;
        i = paramInt;
        paramInt = k;
      }
      label207:
      paramBoolean = false;
      k = paramInt;
    }
    label215:
    throw com.google.c.j.getNotFoundInstance();
  }
  
  protected abstract int a(com.google.c.a.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws com.google.c.j;
  
  abstract com.google.c.a a();
  
  boolean a(String paramString)
    throws d, g
  {
    return a(paramString);
  }
  
  int[] a(com.google.c.a.a parama, int paramInt)
    throws com.google.c.j
  {
    return a(parama, paramInt, false, b);
  }
  
  public l decodeRow(int paramInt, com.google.c.a.a parama, Map<e, ?> paramMap)
    throws com.google.c.j, d, g
  {
    return decodeRow(paramInt, parama, a(parama), paramMap);
  }
  
  public l decodeRow(int paramInt, com.google.c.a.a parama, int[] paramArrayOfInt, Map<e, ?> paramMap)
    throws com.google.c.j, d, g
  {
    if (paramMap == null) {}
    int[] arrayOfInt;
    for (paramMap = null;; paramMap = (o)paramMap.get(e.h))
    {
      if (paramMap != null) {
        paramMap.foundPossibleResultPoint(new n((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt));
      }
      localObject = this.a;
      ((StringBuilder)localObject).setLength(0);
      int i = a(parama, paramArrayOfInt, (StringBuilder)localObject);
      if (paramMap != null) {
        paramMap.foundPossibleResultPoint(new n(i, paramInt));
      }
      arrayOfInt = a(parama, i);
      if (paramMap != null) {
        paramMap.foundPossibleResultPoint(new n((arrayOfInt[0] + arrayOfInt[1]) / 2.0F, paramInt));
      }
      i = arrayOfInt[1];
      int j = i - arrayOfInt[0] + i;
      if ((j < parama.getSize()) && (parama.isRange(i, j, false))) {
        break;
      }
      throw com.google.c.j.getNotFoundInstance();
    }
    paramMap = ((StringBuilder)localObject).toString();
    if (!a(paramMap)) {
      throw d.getChecksumInstance();
    }
    float f1 = (paramArrayOfInt[1] + paramArrayOfInt[0]) / 2.0F;
    float f2 = (arrayOfInt[1] + arrayOfInt[0]) / 2.0F;
    Object localObject = a();
    paramArrayOfInt = new l(paramMap, null, new n[] { new n(f1, paramInt), new n(f2, paramInt) }, (com.google.c.a)localObject);
    try
    {
      parama = this.f.a(paramInt, parama, arrayOfInt[1]);
      paramArrayOfInt.putAllMetadata(parama.getResultMetadata());
      paramArrayOfInt.addResultPoints(parama.getResultPoints());
      if ((localObject == com.google.c.a.h) || (localObject == com.google.c.a.o))
      {
        parama = this.g.a(paramMap);
        if (parama != null) {
          paramArrayOfInt.putMetadata(com.google.c.m.g, parama);
        }
      }
      return paramArrayOfInt;
    }
    catch (k parama)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */