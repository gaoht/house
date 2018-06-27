package com.google.c.b;

import com.google.c.d;
import com.google.c.e;
import com.google.c.g;
import com.google.c.j;
import com.google.c.l;
import com.google.c.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
  extends m
{
  static final int[][] a;
  
  static
  {
    int[] arrayOfInt1 = { 2, 1, 2, 2, 2, 2 };
    int[] arrayOfInt2 = { 1, 2, 1, 2, 2, 3 };
    int[] arrayOfInt3 = { 1, 3, 1, 2, 2, 2 };
    int[] arrayOfInt4 = { 2, 2, 1, 2, 1, 3 };
    int[] arrayOfInt5 = { 2, 2, 1, 3, 1, 2 };
    int[] arrayOfInt6 = { 1, 1, 2, 2, 3, 2 };
    int[] arrayOfInt7 = { 1, 2, 2, 1, 3, 2 };
    int[] arrayOfInt8 = { 1, 2, 2, 2, 3, 1 };
    int[] arrayOfInt9 = { 1, 1, 3, 2, 2, 2 };
    int[] arrayOfInt10 = { 2, 2, 3, 2, 1, 1 };
    int[] arrayOfInt11 = { 2, 1, 3, 2, 1, 2 };
    int[] arrayOfInt12 = { 2, 2, 3, 1, 1, 2 };
    int[] arrayOfInt13 = { 3, 1, 1, 2, 2, 2 };
    int[] arrayOfInt14 = { 3, 2, 1, 1, 2, 2 };
    int[] arrayOfInt15 = { 3, 2, 1, 2, 2, 1 };
    int[] arrayOfInt16 = { 3, 2, 2, 1, 1, 2 };
    int[] arrayOfInt17 = { 1, 1, 1, 3, 2, 3 };
    int[] arrayOfInt18 = { 1, 3, 1, 3, 2, 1 };
    int[] arrayOfInt19 = { 1, 3, 2, 3, 1, 1 };
    int[] arrayOfInt20 = { 2, 1, 1, 3, 1, 3 };
    int[] arrayOfInt21 = { 2, 3, 1, 1, 1, 3 };
    int[] arrayOfInt22 = { 1, 3, 2, 1, 3, 1 };
    int[] arrayOfInt23 = { 1, 1, 3, 1, 2, 3 };
    int[] arrayOfInt24 = { 2, 1, 3, 1, 1, 3 };
    int[] arrayOfInt25 = { 2, 1, 3, 3, 1, 1 };
    int[] arrayOfInt26 = { 3, 1, 1, 1, 2, 3 };
    int[] arrayOfInt27 = { 3, 1, 1, 3, 2, 1 };
    int[] arrayOfInt28 = { 3, 1, 2, 1, 1, 3 };
    int[] arrayOfInt29 = { 3, 1, 4, 1, 1, 1 };
    int[] arrayOfInt30 = { 2, 2, 1, 4, 1, 1 };
    int[] arrayOfInt31 = { 1, 1, 1, 2, 2, 4 };
    int[] arrayOfInt32 = { 1, 1, 1, 4, 2, 2 };
    int[] arrayOfInt33 = { 1, 2, 1, 1, 2, 4 };
    int[] arrayOfInt34 = { 1, 4, 1, 1, 2, 2 };
    int[] arrayOfInt35 = { 1, 4, 2, 1, 1, 2 };
    int[] arrayOfInt36 = { 2, 4, 1, 2, 1, 1 };
    int[] arrayOfInt37 = { 2, 2, 1, 1, 1, 4 };
    int[] arrayOfInt38 = { 1, 1, 1, 2, 4, 2 };
    int[] arrayOfInt39 = { 1, 2, 4, 2, 1, 1 };
    int[] arrayOfInt40 = { 4, 2, 1, 2, 1, 1 };
    int[] arrayOfInt41 = { 2, 1, 4, 1, 2, 1 };
    int[] arrayOfInt42 = { 1, 1, 1, 3, 4, 1 };
    int[] arrayOfInt43 = { 1, 1, 4, 1, 1, 3 };
    int[] arrayOfInt44 = { 4, 1, 1, 3, 1, 1 };
    int[] arrayOfInt45 = { 1, 1, 3, 1, 4, 1 };
    int[] arrayOfInt46 = { 4, 1, 1, 1, 3, 1 };
    int[] arrayOfInt47 = { 2, 1, 1, 4, 1, 2 };
    int[] arrayOfInt48 = { 2, 3, 3, 1, 1, 1, 2 };
    a = new int[][] { arrayOfInt1, { 2, 2, 2, 1, 2, 2 }, { 2, 2, 2, 2, 2, 1 }, arrayOfInt2, { 1, 2, 1, 3, 2, 2 }, arrayOfInt3, { 1, 2, 2, 2, 1, 3 }, { 1, 2, 2, 3, 1, 2 }, { 1, 3, 2, 2, 1, 2 }, arrayOfInt4, arrayOfInt5, { 2, 3, 1, 2, 1, 2 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, { 1, 2, 3, 1, 2, 2 }, { 1, 2, 3, 2, 2, 1 }, arrayOfInt10, { 2, 2, 1, 1, 3, 2 }, { 2, 2, 1, 2, 3, 1 }, arrayOfInt11, arrayOfInt12, { 3, 1, 2, 1, 3, 1 }, arrayOfInt13, arrayOfInt14, arrayOfInt15, { 3, 1, 2, 2, 1, 2 }, arrayOfInt16, { 3, 2, 2, 2, 1, 1 }, { 2, 1, 2, 1, 2, 3 }, { 2, 1, 2, 3, 2, 1 }, { 2, 3, 2, 1, 2, 1 }, arrayOfInt17, { 1, 3, 1, 1, 2, 3 }, arrayOfInt18, { 1, 1, 2, 3, 1, 3 }, { 1, 3, 2, 1, 1, 3 }, arrayOfInt19, arrayOfInt20, arrayOfInt21, { 2, 3, 1, 3, 1, 1 }, { 1, 1, 2, 1, 3, 3 }, { 1, 1, 2, 3, 3, 1 }, arrayOfInt22, arrayOfInt23, { 1, 1, 3, 3, 2, 1 }, { 1, 3, 3, 1, 2, 1 }, { 3, 1, 3, 1, 2, 1 }, { 2, 1, 1, 3, 3, 1 }, { 2, 3, 1, 1, 3, 1 }, arrayOfInt24, arrayOfInt25, { 2, 1, 3, 1, 3, 1 }, arrayOfInt26, arrayOfInt27, { 3, 3, 1, 1, 2, 1 }, arrayOfInt28, { 3, 1, 2, 3, 1, 1 }, { 3, 3, 2, 1, 1, 1 }, arrayOfInt29, arrayOfInt30, { 4, 3, 1, 1, 1, 1 }, arrayOfInt31, arrayOfInt32, arrayOfInt33, { 1, 2, 1, 4, 2, 1 }, arrayOfInt34, { 1, 4, 1, 2, 2, 1 }, { 1, 1, 2, 2, 1, 4 }, { 1, 1, 2, 4, 1, 2 }, { 1, 2, 2, 1, 1, 4 }, { 1, 2, 2, 4, 1, 1 }, arrayOfInt35, { 1, 4, 2, 2, 1, 1 }, arrayOfInt36, arrayOfInt37, { 4, 1, 3, 1, 1, 1 }, { 2, 4, 1, 1, 1, 2 }, { 1, 3, 4, 1, 1, 1 }, arrayOfInt38, { 1, 2, 1, 1, 4, 2 }, { 1, 2, 1, 2, 4, 1 }, { 1, 1, 4, 2, 1, 2 }, { 1, 2, 4, 1, 1, 2 }, arrayOfInt39, { 4, 1, 1, 2, 1, 2 }, { 4, 2, 1, 1, 1, 2 }, arrayOfInt40, { 2, 1, 2, 1, 4, 1 }, arrayOfInt41, { 4, 1, 2, 1, 2, 1 }, { 1, 1, 1, 1, 4, 3 }, arrayOfInt42, { 1, 3, 1, 1, 4, 1 }, arrayOfInt43, { 1, 1, 4, 3, 1, 1 }, { 4, 1, 1, 1, 1, 3 }, arrayOfInt44, arrayOfInt45, { 1, 1, 4, 1, 3, 1 }, { 3, 1, 1, 1, 4, 1 }, arrayOfInt46, arrayOfInt47, { 2, 1, 1, 2, 1, 4 }, { 2, 1, 1, 2, 3, 2 }, arrayOfInt48 };
  }
  
  private static int a(com.google.c.a.a parama, int[] paramArrayOfInt, int paramInt)
    throws j
  {
    a(parama, paramInt, paramArrayOfInt);
    int i = 64;
    int k = -1;
    paramInt = 0;
    while (paramInt < a.length)
    {
      int m = a(paramArrayOfInt, a[paramInt], 179);
      int j = i;
      if (m < i)
      {
        k = paramInt;
        j = m;
      }
      paramInt += 1;
      i = j;
    }
    if (k >= 0) {
      return k;
    }
    throw j.getNotFoundInstance();
  }
  
  private static int[] a(com.google.c.a.a parama)
    throws j
  {
    int i4 = parama.getSize();
    int j = parama.getNextSet(0);
    int[] arrayOfInt = new int[6];
    int i5 = arrayOfInt.length;
    int i1 = j;
    int i = 0;
    int k = 0;
    int m;
    int i2;
    for (;;)
    {
      if (i1 < i4) {
        if ((parama.get(i1) ^ i))
        {
          arrayOfInt[k] += 1;
          m = k;
          k = j;
          j = m;
          i1 += 1;
          m = j;
          j = k;
          k = m;
        }
        else if (k == i5 - 1)
        {
          int n = 64;
          i2 = -1;
          m = 103;
          label102:
          if (m <= 105)
          {
            int i3 = a(arrayOfInt, a[m], 179);
            if (i3 >= n) {
              break label278;
            }
            i2 = m;
            n = i3;
          }
        }
      }
    }
    label242:
    label278:
    for (;;)
    {
      m += 1;
      break label102;
      if ((i2 >= 0) && (parama.isRange(Math.max(0, j - (i1 - j) / 2), j, false))) {
        return new int[] { j, i1, i2 };
      }
      m = arrayOfInt[0] + arrayOfInt[1] + j;
      System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i5 - 2);
      arrayOfInt[(i5 - 2)] = 0;
      arrayOfInt[(i5 - 1)] = 0;
      j = k - 1;
      k = m;
      arrayOfInt[j] = 1;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        break;
        m = k + 1;
        k = j;
        j = m;
        break label242;
      }
      throw j.getNotFoundInstance();
    }
  }
  
  public l decodeRow(int paramInt, com.google.c.a.a parama, Map<e, ?> paramMap)
    throws j, g, d
  {
    Object localObject2 = a(parama);
    int m = localObject2[2];
    switch (m)
    {
    default: 
      throw g.getFormatInstance();
    case 103: 
      i = 101;
    }
    int i4;
    int n;
    int k;
    int i5;
    int i6;
    int i2;
    int i3;
    int j;
    int i10;
    int i9;
    int i8;
    int i7;
    for (;;)
    {
      paramMap = new StringBuilder(20);
      localObject1 = new ArrayList(20);
      i4 = localObject2[0];
      n = localObject2[1];
      localObject3 = new int[6];
      k = 1;
      i5 = 0;
      i1 = 0;
      i6 = 0;
      i2 = 0;
      i3 = 0;
      j = i;
      i = i3;
      if (i != 0) {
        break label1065;
      }
      i10 = 0;
      i9 = 0;
      i8 = a(parama, (int[])localObject3, n);
      ((List)localObject1).add(Byte.valueOf((byte)i8));
      if (i8 != 106) {
        k = 1;
      }
      i7 = i1;
      i6 = m;
      if (i8 != 106)
      {
        i7 = i1 + 1;
        i6 = m + i7 * i8;
      }
      i1 = localObject3.length;
      m = 0;
      i3 = n;
      while (m < i1)
      {
        i3 += localObject3[m];
        m += 1;
      }
      i = 100;
      continue;
      i = 99;
    }
    switch (i8)
    {
    default: 
      switch (j)
      {
      default: 
        m = i;
        i = k;
        i1 = j;
        k = 0;
        j = i;
        i = i1;
        label319:
        i1 = i;
        if (i5 != 0) {
          if (i != 101) {
            break label1058;
          }
        }
        break;
      }
      break;
    }
    label1058:
    for (int i1 = 100;; i1 = 101)
    {
      i5 = k;
      k = i1;
      i = i2;
      i2 = i8;
      i4 = j;
      j = m;
      i1 = i7;
      m = i6;
      i6 = i;
      i = j;
      j = k;
      k = i4;
      i4 = n;
      n = i3;
      break;
      throw g.getFormatInstance();
      if (i8 < 64)
      {
        paramMap.append((char)(i8 + 32));
        m = i;
        i = j;
        i1 = 0;
        j = k;
        k = i1;
        break label319;
      }
      if (i8 < 96)
      {
        paramMap.append((char)(i8 - 64));
        m = i;
        i = j;
        i1 = 0;
        j = k;
        k = i1;
        break label319;
      }
      i1 = k;
      if (i8 != 106) {
        i1 = 0;
      }
      m = i9;
      i4 = i;
      k = j;
      switch (i8)
      {
      default: 
        k = j;
        i4 = i;
        m = i9;
      }
      for (;;)
      {
        j = i1;
        i = k;
        k = m;
        m = i4;
        break;
        m = 1;
        k = 100;
        i4 = i;
        continue;
        k = 100;
        m = i9;
        i4 = i;
        continue;
        k = 99;
        m = i9;
        i4 = i;
        continue;
        i4 = 1;
        m = i9;
        k = j;
      }
      if (i8 < 96)
      {
        paramMap.append((char)(i8 + 32));
        m = i;
        i = j;
        i1 = 0;
        j = k;
        k = i1;
        break label319;
      }
      i1 = k;
      if (i8 != 106) {
        i1 = 0;
      }
      m = i10;
      i4 = i;
      k = j;
      switch (i8)
      {
      default: 
        k = j;
        i4 = i;
        m = i10;
      }
      for (;;)
      {
        j = i1;
        i = k;
        k = m;
        m = i4;
        break;
        m = 1;
        k = 101;
        i4 = i;
        continue;
        k = 101;
        m = i10;
        i4 = i;
        continue;
        k = 99;
        m = i10;
        i4 = i;
        continue;
        i4 = 1;
        m = i10;
        k = j;
      }
      if (i8 < 100)
      {
        if (i8 < 10) {
          paramMap.append('0');
        }
        paramMap.append(i8);
        m = i;
        i = j;
        i1 = 0;
        j = k;
        k = i1;
        break label319;
      }
      if (i8 != 106) {
        k = 0;
      }
      switch (i8)
      {
      case 103: 
      case 104: 
      case 105: 
      default: 
        break;
      case 100: 
        m = i;
        j = k;
        i = 100;
        k = 0;
        break;
      case 102: 
        m = i;
        i = j;
        i1 = 0;
        j = k;
        k = i1;
        break;
      case 101: 
        m = i;
        j = k;
        i = 101;
        k = 0;
        break;
      case 106: 
        m = 1;
        i = j;
        i1 = 0;
        j = k;
        k = i1;
        break label319;
      }
    }
    label1065:
    int i = parama.getNextUnset(n);
    if (!parama.isRange(i, Math.min(parama.getSize(), (i - i4) / 2 + i), false)) {
      throw j.getNotFoundInstance();
    }
    if ((m - i1 * i6) % 103 != i6) {
      throw d.getChecksumInstance();
    }
    m = paramMap.length();
    if (m == 0) {
      throw j.getNotFoundInstance();
    }
    if ((m > 0) && (k != 0))
    {
      if (j != 99) {
        break label1243;
      }
      paramMap.delete(m - 2, m);
    }
    float f1;
    float f2;
    for (;;)
    {
      f1 = (localObject2[1] + localObject2[0]) / 2.0F;
      f2 = (i + i4) / 2.0F;
      j = ((List)localObject1).size();
      parama = new byte[j];
      i = 0;
      while (i < j)
      {
        parama[i] = ((Byte)((List)localObject1).get(i)).byteValue();
        i += 1;
      }
      label1243:
      paramMap.delete(m - 1, m);
    }
    paramMap = paramMap.toString();
    Object localObject1 = new n(f1, paramInt);
    localObject2 = new n(f2, paramInt);
    Object localObject3 = com.google.c.a.e;
    return new l(paramMap, parama, new n[] { localObject1, localObject2 }, (com.google.c.a)localObject3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */