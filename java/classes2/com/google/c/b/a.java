package com.google.c.b;

import com.google.c.e;
import com.google.c.j;
import com.google.c.l;
import com.google.c.n;
import java.util.Map;

public final class a
  extends m
{
  static final char[] a = "0123456789-$:/.+ABCDTN".toCharArray();
  static final int[] b = { 3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14, 26, 41 };
  private static final char[] c = { 69, 42, 65, 66, 67, 68, 84, 78 };
  
  private static char a(int[] paramArrayOfInt)
  {
    int i3 = paramArrayOfInt.length;
    int j = Integer.MAX_VALUE;
    int m = 0;
    int k;
    int n;
    for (int i = 0;; i = n)
    {
      k = i;
      if (m >= i3) {
        break;
      }
      k = j;
      if (paramArrayOfInt[m] < j) {
        k = paramArrayOfInt[m];
      }
      n = i;
      if (paramArrayOfInt[m] > i) {
        n = paramArrayOfInt[m];
      }
      m += 1;
      j = k;
    }
    do
    {
      m = 0;
      i = 0;
      int i1;
      for (n = 0; m < i3; n = i1)
      {
        int i2 = i;
        i1 = n;
        if (paramArrayOfInt[m] > k)
        {
          i2 = i | 1 << i3 - 1 - m;
          i1 = n + 1;
        }
        m += 1;
        i = i2;
      }
      if ((n == 2) || (n == 3))
      {
        m = 0;
        while (m < b.length)
        {
          if (b[m] == i) {
            return a[m];
          }
          m += 1;
        }
      }
      i = k - 1;
      k = i;
    } while (i > j);
    return '!';
  }
  
  static boolean a(char[] paramArrayOfChar, char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramArrayOfChar != null)
    {
      j = paramArrayOfChar.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfChar[i] == paramChar) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static int[] a(com.google.c.a.a parama)
    throws j
  {
    int i1 = parama.getSize();
    int i = parama.getNextSet(0);
    int[] arrayOfInt = new int[7];
    int i2 = arrayOfInt.length;
    int m = i;
    int j = 0;
    int k = 0;
    while (m < i1)
    {
      int n;
      if ((parama.get(m) ^ j))
      {
        arrayOfInt[k] += 1;
        n = j;
        j = k;
        k = i;
        i = n;
        n = m + 1;
        m = i;
        i = k;
        k = j;
        j = m;
        m = n;
      }
      else
      {
        if (k == i2 - 1) {
          try
          {
            if ((a(c, a(arrayOfInt))) && (parama.isRange(Math.max(0, i - (m - i) / 2), i, false))) {
              return new int[] { i, m };
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            i += arrayOfInt[0] + arrayOfInt[1];
            System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i2 - 2);
            arrayOfInt[(i2 - 2)] = 0;
            arrayOfInt[(i2 - 1)] = 0;
            k -= 1;
          }
        }
        for (;;)
        {
          arrayOfInt[k] = 1;
          n = k;
          k = i;
          i = j ^ 0x1;
          j = n;
          break;
          k += 1;
        }
      }
    }
    throw j.getNotFoundInstance();
  }
  
  public l decodeRow(int paramInt, com.google.c.a.a parama, Map<e, ?> paramMap)
    throws j
  {
    paramMap = a(parama);
    paramMap[1] = 0;
    int i = parama.getNextSet(paramMap[1]);
    int n = parama.getSize();
    Object localObject1 = new StringBuilder();
    Object localObject2 = new int[7];
    for (;;)
    {
      int j = 0;
      while (j < localObject2.length)
      {
        localObject2[j] = 0;
        j += 1;
      }
      a(parama, i, (int[])localObject2);
      char c1 = a((int[])localObject2);
      if (c1 == '!') {
        throw j.getNotFoundInstance();
      }
      ((StringBuilder)localObject1).append(c1);
      int m = localObject2.length;
      j = 0;
      int k = i;
      while (j < m)
      {
        k += localObject2[j];
        j += 1;
      }
      m = parama.getNextSet(k);
      if (m >= n)
      {
        k = 0;
        int i1 = localObject2.length;
        j = 0;
        while (j < i1)
        {
          k += localObject2[j];
          j += 1;
        }
        if ((m != n) && ((m - i - k) / 2 < k)) {
          throw j.getNotFoundInstance();
        }
        if (((StringBuilder)localObject1).length() < 2) {
          throw j.getNotFoundInstance();
        }
        c1 = ((StringBuilder)localObject1).charAt(0);
        if (!a(c, c1)) {
          throw j.getNotFoundInstance();
        }
        j = 1;
        for (;;)
        {
          if (j < ((StringBuilder)localObject1).length())
          {
            if ((((StringBuilder)localObject1).charAt(j) == c1) && (j + 1 != ((StringBuilder)localObject1).length())) {
              ((StringBuilder)localObject1).delete(j + 1, ((StringBuilder)localObject1).length() - 1);
            }
          }
          else
          {
            if (((StringBuilder)localObject1).length() > 6) {
              break;
            }
            throw j.getNotFoundInstance();
          }
          j += 1;
        }
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        ((StringBuilder)localObject1).deleteCharAt(0);
        float f1 = (paramMap[1] + paramMap[0]) / 2.0F;
        float f2 = (i + m) / 2.0F;
        parama = ((StringBuilder)localObject1).toString();
        paramMap = new n(f1, paramInt);
        localObject1 = new n(f2, paramInt);
        localObject2 = com.google.c.a.b;
        return new l(parama, null, new n[] { paramMap, localObject1 }, (com.google.c.a)localObject2);
      }
      i = m;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */