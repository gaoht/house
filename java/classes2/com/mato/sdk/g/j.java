package com.mato.sdk.g;

import android.util.Base64;
import com.mato.sdk.b.g;

public final class j
{
  private static final String a = "utf-8";
  private static final String b = g.a;
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    for (;;)
    {
      int[] arrayOfInt;
      int i1;
      int j;
      int m;
      try
      {
        paramString1 = paramString1.getBytes("utf-8");
        paramString2 = paramString2.getBytes("utf-8");
        if (paramString1.length == 0) {
          return Base64.encodeToString(paramString1, 2);
        }
        arrayOfInt = a(paramString1, true);
        paramString1 = a(paramString2, false);
        i1 = arrayOfInt.length - 1;
        if (i1 <= 0)
        {
          paramString1 = a(arrayOfInt, false);
          continue;
        }
        if (paramString1.length >= 4) {
          break label180;
        }
        paramString2 = new int[4];
        System.arraycopy(paramString1, 0, paramString2, 0, paramString1.length);
        paramString1 = paramString2;
        i = arrayOfInt[i1];
        j = 52 / (i1 + 1) + 6;
        k = 0;
      }
      catch (Throwable paramString1)
      {
        return null;
      }
      int n = arrayOfInt[0];
      int i2;
      int i = arrayOfInt[i1] + ((paramString1[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4));
      arrayOfInt[i1] = i;
      j -= 1;
      int k = m;
      break label183;
      label180:
      continue;
      label183:
      if (j > 0)
      {
        m = k - 1640531527;
        i2 = m >>> 2 & 0x3;
        n = 0;
        k = i;
        i = n;
        while (i < i1)
        {
          n = arrayOfInt[(i + 1)];
          int i3 = arrayOfInt[i];
          k = ((k ^ paramString1[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
          arrayOfInt[i] = k;
          i += 1;
        }
      }
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    int[] arrayOfInt = a(paramArrayOfByte1, true);
    paramArrayOfByte1 = a(paramArrayOfByte2, false);
    int i1 = arrayOfInt.length - 1;
    if (i1 <= 0) {
      return a(arrayOfInt, false);
    }
    if (paramArrayOfByte1.length < 4)
    {
      paramArrayOfByte2 = new int[4];
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = paramArrayOfByte2;
    }
    for (;;)
    {
      int i = arrayOfInt[i1];
      int j = 52 / (i1 + 1) + 6;
      int m;
      for (int k = 0; j > 0; k = m)
      {
        m = k - 1640531527;
        int i2 = m >>> 2 & 0x3;
        int n = 0;
        k = i;
        i = n;
        while (i < i1)
        {
          n = arrayOfInt[(i + 1)];
          int i3 = arrayOfInt[i];
          k = ((k ^ paramArrayOfByte1[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
          arrayOfInt[i] = k;
          i += 1;
        }
        n = arrayOfInt[0];
        i = arrayOfInt[i1] + ((paramArrayOfByte1[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4));
        arrayOfInt[i1] = i;
        j -= 1;
      }
      break;
    }
  }
  
  private static byte[] a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = paramArrayOfInt.length << 2;
    int i;
    if (paramBoolean)
    {
      int k = paramArrayOfInt[(paramArrayOfInt.length - 1)];
      i = k;
      if (k > j) {
        return null;
      }
    }
    else
    {
      i = j;
    }
    byte[] arrayOfByte = new byte[i];
    j = 0;
    while (j < i)
    {
      arrayOfByte[j] = ((byte)(paramArrayOfInt[(j >>> 2)] >>> ((j & 0x3) << 3)));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private static int[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    int[] arrayOfInt;
    if ((paramArrayOfByte.length & 0x3) == 0)
    {
      i = paramArrayOfByte.length >>> 2;
      if (!paramBoolean) {
        break label85;
      }
      arrayOfInt = new int[i + 1];
      arrayOfInt[i] = paramArrayOfByte.length;
    }
    for (;;)
    {
      int j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        int k = i >>> 2;
        arrayOfInt[k] |= (paramArrayOfByte[i] & 0xFF) << ((i & 0x3) << 3);
        i += 1;
      }
      i = (paramArrayOfByte.length >>> 2) + 1;
      break;
      label85:
      arrayOfInt = new int[i];
    }
    return arrayOfInt;
  }
  
  private static int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length - 1;
    if (i1 <= 0) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[i1];
      int j = 52 / (i1 + 1);
      int k = 0;
      j += 6;
      while (j > 0)
      {
        int m = k - 1640531527;
        int i2 = m >>> 2 & 0x3;
        int n = 0;
        k = i;
        i = n;
        while (i < i1)
        {
          n = paramArrayOfInt1[(i + 1)];
          i3 = paramArrayOfInt1[i];
          k = ((k ^ arrayOfInt[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
          paramArrayOfInt1[i] = k;
          i += 1;
        }
        n = paramArrayOfInt1[0];
        int i3 = paramArrayOfInt1[i1];
        i = ((arrayOfInt[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
        paramArrayOfInt1[i1] = i;
        j -= 1;
        k = m;
      }
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    for (;;)
    {
      int[] arrayOfInt;
      int m;
      int j;
      int i1;
      try
      {
        paramString1 = Base64.decode(paramString1, 2);
        paramString2 = paramString2.getBytes("utf-8");
        if (paramString1.length == 0) {
          return new String(paramString1, "utf-8");
        }
        arrayOfInt = a(paramString1, false);
        paramString1 = a(paramString2, false);
        m = arrayOfInt.length - 1;
        if (m <= 0)
        {
          paramString1 = a(arrayOfInt, true);
          continue;
        }
        if (paramString1.length < 4)
        {
          paramString2 = new int[4];
          System.arraycopy(paramString1, 0, paramString2, 0, paramString1.length);
          paramString1 = paramString2;
          i = arrayOfInt[0];
          j = (52 / (m + 1) + 6) * -1640531527;
          break label181;
          i1 = arrayOfInt[m];
          i = arrayOfInt[0] - ((paramString1[(i & 0x3 ^ n)] ^ i1) + (k ^ j) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
          arrayOfInt[0] = i;
          j += 1640531527;
        }
        else
        {
          continue;
        }
        if (j == 0) {
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        return null;
      }
      label181:
      int n = j >>> 2 & 0x3;
      int k = i;
      int i = m;
      while (i > 0)
      {
        i1 = arrayOfInt[(i - 1)];
        k = arrayOfInt[i] - ((k ^ j) + (i1 ^ paramString1[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
        arrayOfInt[i] = k;
        i -= 1;
      }
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    int[] arrayOfInt = a(paramArrayOfByte1, false);
    paramArrayOfByte1 = a(paramArrayOfByte2, false);
    int m = arrayOfInt.length - 1;
    if (m <= 0) {
      return a(arrayOfInt, true);
    }
    if (paramArrayOfByte1.length < 4)
    {
      paramArrayOfByte2 = new int[4];
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = paramArrayOfByte2;
    }
    for (;;)
    {
      int i = arrayOfInt[0];
      int j = (52 / (m + 1) + 6) * -1640531527;
      while (j != 0)
      {
        int n = j >>> 2 & 0x3;
        int k = i;
        i = m;
        while (i > 0)
        {
          i1 = arrayOfInt[(i - 1)];
          k = arrayOfInt[i] - ((k ^ j) + (i1 ^ paramArrayOfByte1[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
          arrayOfInt[i] = k;
          i -= 1;
        }
        int i1 = arrayOfInt[m];
        i = arrayOfInt[0] - ((paramArrayOfByte1[(i & 0x3 ^ n)] ^ i1) + (k ^ j) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
        arrayOfInt[0] = i;
        j += 1640531527;
      }
      break;
    }
  }
  
  private static int[] b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramArrayOfInt1.length - 1;
    if (m <= 0) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[0];
      int j = (52 / (m + 1) + 6) * -1640531527;
      while (j != 0)
      {
        int n = j >>> 2 & 0x3;
        int k = i;
        i = m;
        while (i > 0)
        {
          i1 = paramArrayOfInt1[(i - 1)];
          k = paramArrayOfInt1[i] - ((k ^ j) + (i1 ^ arrayOfInt[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
          paramArrayOfInt1[i] = k;
          i -= 1;
        }
        int i1 = paramArrayOfInt1[m];
        i = paramArrayOfInt1[0] - ((arrayOfInt[(i & 0x3 ^ n)] ^ i1) + (k ^ j) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
        paramArrayOfInt1[0] = i;
        j += 1640531527;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */