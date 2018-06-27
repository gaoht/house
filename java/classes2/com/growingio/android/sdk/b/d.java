package com.growingio.android.sdk.b;

import android.annotation.SuppressLint;
import java.nio.ByteOrder;
import java.util.Arrays;

final class d
{
  private static final boolean b;
  
  static
  {
    boolean bool2 = true;
    if (!d.class.desiredAssertionStatus())
    {
      bool1 = true;
      a = bool1;
      if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) {
        break label37;
      }
    }
    label37:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      b = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int a(int paramInt)
  {
    return paramInt + 32 + paramInt / 6;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return 506832829 * paramInt1 >>> paramInt2;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 128) && (paramInt2 >= 0))
    {
      paramArrayOfByte[paramInt1] = ((byte)paramInt2);
      return paramInt1 + 1;
    }
    if ((paramInt2 < 16384) && (paramInt2 > 0))
    {
      i = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = ((byte)(paramInt2 | 0x80));
      paramArrayOfByte[i] = ((byte)(paramInt2 >>> 7));
      return i + 1;
    }
    if ((paramInt2 < 2097152) && (paramInt2 > 0))
    {
      i = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = ((byte)(paramInt2 | 0x80));
      paramInt1 = i + 1;
      paramArrayOfByte[i] = ((byte)(paramInt2 >>> 7 | 0x80));
      paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 14));
      return paramInt1 + 1;
    }
    if ((paramInt2 < 268435456) && (paramInt2 > 0))
    {
      i = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = ((byte)(paramInt2 | 0x80));
      paramInt1 = i + 1;
      paramArrayOfByte[i] = ((byte)(paramInt2 >>> 7 | 0x80));
      i = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 14 | 0x80));
      paramArrayOfByte[i] = ((byte)(paramInt2 >>> 21));
      return i + 1;
    }
    int i = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 | 0x80));
    paramInt1 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt2 >>> 7 | 0x80));
    i = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 14 | 0x80));
    paramInt1 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt2 >>> 21 | 0x80));
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 28));
    return paramInt1 + 1;
  }
  
  @SuppressLint({"Assert"})
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!a) && (paramInt2 < 0)) {
      throw new AssertionError();
    }
    if ((!a) && (paramInt3 > 64)) {
      throw new AssertionError();
    }
    if ((!a) && (paramInt3 < 4)) {
      throw new AssertionError();
    }
    if ((!a) && (paramInt2 >= 65536)) {
      throw new AssertionError();
    }
    if ((paramInt3 < 12) && (paramInt2 < 2048))
    {
      paramInt3 -= 4;
      if ((!a) && (paramInt3 >= 8)) {
        throw new AssertionError();
      }
      i = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = ((byte)(paramInt3 << 2 | 0x1 | paramInt2 >>> 8 << 5));
      paramArrayOfByte[i] = ((byte)paramInt2);
      return i + 1;
    }
    int i = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = ((byte)(paramInt3 - 1 << 2 | 0x2));
    paramInt1 = i + 1;
    paramArrayOfByte[i] = ((byte)paramInt2);
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 8));
    return paramInt1 + 1;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int j = a(paramArrayOfByte2, paramInt3, paramInt2);
    int i = c(paramInt2);
    a locala = a.a();
    short[] arrayOfShort = locala.a(i);
    i = 0;
    while (i < paramInt2)
    {
      Arrays.fill(arrayOfShort, (short)0);
      j = a(paramArrayOfByte1, paramInt1 + i, Math.min(paramInt2 - i, 32768), paramArrayOfByte2, j, arrayOfShort);
      i += 32768;
    }
    locala.a(arrayOfShort);
    return j - paramInt3;
  }
  
  @SuppressLint({"Assert"})
  private static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, short[] paramArrayOfShort)
  {
    if ((!a) && (paramInt2 > 32768)) {
      throw new AssertionError();
    }
    int k = paramInt1 + paramInt2;
    int i = c(paramInt2);
    int m = 32 - d(i);
    if ((!a) && ((i - 1 & i) != 0)) {
      throw new AssertionError("table must be power of two");
    }
    if ((!a) && (-1 >>> m != i - 1)) {
      throw new AssertionError();
    }
    int j;
    int[] arrayOfInt;
    int i1;
    if (paramInt2 >= 15)
    {
      int n = paramInt1 + paramInt2 - 15;
      i = paramInt1;
      j = paramInt1;
      if (j <= n)
      {
        if ((!a) && (i > j)) {
          throw new AssertionError();
        }
        arrayOfInt = a(paramArrayOfByte1, j, n, paramInt1, m, paramArrayOfShort, 32);
        j = arrayOfInt[0];
        i1 = arrayOfInt[1];
        if (b(arrayOfInt[2]) + j > n)
        {
          paramInt2 = i;
          paramInt1 = paramInt3;
        }
      }
    }
    for (;;)
    {
      paramInt3 = paramInt1;
      if (paramInt2 < k) {
        paramInt3 = a(paramArrayOfByte2, paramInt1, paramArrayOfByte1, paramInt2, k - paramInt2, false);
      }
      return paramInt3;
      if ((!a) && (i + 16 > k)) {
        throw new AssertionError();
      }
      arrayOfInt = a(paramArrayOfByte1, paramInt1, paramInt2, j, paramArrayOfByte2, a(paramArrayOfByte2, paramInt3, paramArrayOfByte1, i, j - i, true), paramArrayOfShort, m, i1);
      i = arrayOfInt[0];
      paramInt3 = arrayOfInt[1];
      j = i;
      break;
      paramInt2 = i;
      paramInt1 = paramInt3;
      continue;
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
    }
  }
  
  @SuppressLint({"Assert"})
  private static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = 0;
    if ((!a) && (paramInt3 < paramInt2)) {
      throw new AssertionError();
    }
    if (e.a)
    {
      i = j;
      while ((paramInt2 + i <= paramInt3 - 4) && (e.a(paramArrayOfByte2, paramInt2 + i) == e.a(paramArrayOfByte1, paramInt1 + i))) {
        i += 4;
      }
      j = i;
      if (b)
      {
        j = i;
        if (paramInt2 + i <= paramInt3 - 4)
        {
          i += (Integer.numberOfTrailingZeros(e.a(paramArrayOfByte2, paramInt2 + i) ^ e.a(paramArrayOfByte1, paramInt1 + i)) >> 3);
          return i;
        }
      }
      for (;;)
      {
        i = j;
        if (paramInt2 + j >= paramInt3) {
          break;
        }
        i = j;
        if (paramArrayOfByte1[(paramInt1 + j)] != paramArrayOfByte2[(paramInt2 + j)]) {
          break;
        }
        j += 1;
      }
    }
    j = paramInt3 - paramInt2;
    paramInt3 = i;
    for (;;)
    {
      if (paramInt3 >= j) {
        break label216;
      }
      i = paramInt3;
      if (paramArrayOfByte1[(paramInt1 + paramInt3)] != paramArrayOfByte2[(paramInt2 + paramInt3)]) {
        break;
      }
      paramInt3 += 1;
    }
    label216:
    return j;
  }
  
  private static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    e.a(paramInt2, paramInt2 + paramInt3, paramArrayOfByte2.length);
    int j = paramInt3 - 1;
    int i;
    if (j < 60)
    {
      i = paramInt1 + 1;
      paramArrayOfByte1[paramInt1] = ((byte)(j << 2 | 0x0));
      paramInt1 = i;
      if (paramBoolean)
      {
        paramInt1 = i;
        if (paramInt3 <= 16)
        {
          e.a(paramArrayOfByte2, paramInt2, paramArrayOfByte1, i);
          e.a(paramArrayOfByte2, paramInt2 + 8, paramArrayOfByte1, i + 8);
          return i + paramInt3;
        }
      }
    }
    else
    {
      if (j >= 256) {
        break label138;
      }
      i = paramInt1 + 1;
      paramArrayOfByte1[paramInt1] = -16;
      paramInt1 = i + 1;
      paramArrayOfByte1[i] = ((byte)j);
    }
    for (;;)
    {
      e.a(paramInt2, paramInt2 + paramInt3, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
      return paramInt1 + paramInt3;
      label138:
      int k;
      if (j < 65536)
      {
        i = paramInt1 + 1;
        paramArrayOfByte1[paramInt1] = -12;
        k = i + 1;
        paramArrayOfByte1[i] = ((byte)j);
        paramInt1 = k + 1;
        paramArrayOfByte1[k] = ((byte)(j >>> 8));
      }
      else if (j < 16777216)
      {
        i = paramInt1 + 1;
        paramArrayOfByte1[paramInt1] = -8;
        paramInt1 = i + 1;
        paramArrayOfByte1[i] = ((byte)j);
        i = paramInt1 + 1;
        paramArrayOfByte1[paramInt1] = ((byte)(j >>> 8));
        paramInt1 = i + 1;
        paramArrayOfByte1[i] = ((byte)(j >>> 16));
      }
      else
      {
        i = paramInt1 + 1;
        paramArrayOfByte1[paramInt1] = -4;
        paramInt1 = i + 1;
        paramArrayOfByte1[i] = ((byte)j);
        i = paramInt1 + 1;
        paramArrayOfByte1[paramInt1] = ((byte)(j >>> 8));
        k = i + 1;
        paramArrayOfByte1[i] = ((byte)(j >>> 16));
        paramInt1 = k + 1;
        paramArrayOfByte1[k] = ((byte)(j >>> 24));
      }
    }
  }
  
  @SuppressLint({"Assert"})
  private static int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort, int paramInt5)
  {
    int i = paramInt1 + 1;
    paramInt1 = 0;
    for (;;)
    {
      if (b(paramInt5) + i <= paramInt2)
      {
        int j = e.a(paramArrayOfByte, i);
        int k = a(j, paramInt4);
        paramInt1 = paramArrayOfShort[k] + paramInt3;
        if ((!a) && (paramInt1 < 0)) {
          throw new AssertionError();
        }
        if ((!a) && (paramInt1 >= i)) {
          throw new AssertionError();
        }
        paramArrayOfShort[k] = ((short)(i - paramInt3));
        if (j != e.a(paramArrayOfByte, paramInt1)) {}
      }
      else
      {
        return new int[] { i, paramInt1, paramInt5 };
      }
      i += b(paramInt5);
      paramInt5 += 1;
    }
  }
  
  @SuppressLint({"Assert"})
  private static int[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, short[] paramArrayOfShort, int paramInt5, int paramInt6)
  {
    int i = a(paramArrayOfByte1, paramInt6 + 4, paramArrayOfByte1, paramInt3 + 4, paramInt1 + paramInt2) + 4;
    if ((!a) && (!e.a(paramArrayOfByte1, paramInt3, paramArrayOfByte1, paramInt6, i))) {
      throw new AssertionError();
    }
    int j = paramInt3 + i;
    int k = b(paramArrayOfByte2, paramInt4, paramInt3 - paramInt6, i);
    if (j >= paramInt1 + paramInt2 - 15) {
      return new int[] { j, k };
    }
    long l;
    if (e.a)
    {
      l = e.b(paramArrayOfByte1, j - 1);
      paramInt3 = (int)l;
    }
    for (i = (int)(l >>> 8);; i = e.a(paramArrayOfByte1, j))
    {
      paramArrayOfShort[a(paramInt3, paramInt5)] = ((short)(j - paramInt1 - 1));
      paramInt3 = a(i, paramInt5);
      int m = paramInt1 + paramArrayOfShort[paramInt3];
      paramArrayOfShort[paramInt3] = ((short)(j - paramInt1));
      paramInt3 = j;
      paramInt4 = k;
      paramInt6 = m;
      if (i == e.a(paramArrayOfByte1, m)) {
        break;
      }
      return new int[] { j, k };
      paramInt3 = e.a(paramArrayOfByte1, j - 1);
    }
  }
  
  private static int b(int paramInt)
  {
    return paramInt >>> 5;
  }
  
  private static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3;
    paramInt3 = paramInt1;
    paramInt1 = i;
    while (paramInt1 >= 68)
    {
      paramInt3 = a(paramArrayOfByte, paramInt3, paramInt2, 64);
      paramInt1 -= 64;
    }
    int j = paramInt1;
    i = paramInt3;
    if (paramInt1 > 64)
    {
      i = a(paramArrayOfByte, paramInt3, paramInt2, 60);
      j = paramInt1 - 60;
    }
    return a(paramArrayOfByte, i, paramInt2, j);
  }
  
  @SuppressLint({"Assert"})
  private static int c(int paramInt)
  {
    int i = 256;
    while ((i < 16384) && (i < paramInt)) {
      i <<= 1;
    }
    if ((!a) && ((i - 1 & i) != 0)) {
      throw new AssertionError("hash must be power of two");
    }
    if ((!a) && (i > 16384)) {
      throw new AssertionError("hash table too large");
    }
    return i;
  }
  
  private static int d(int paramInt)
  {
    if (paramInt == 0) {
      return -1;
    }
    return Integer.numberOfLeadingZeros(paramInt) ^ 0x1F;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */