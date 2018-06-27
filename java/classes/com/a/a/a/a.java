package com.a.a.a;

public class a
{
  private static byte[] a;
  private static byte[] b;
  
  static
  {
    int k = 0;
    a = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
    b = new byte['ÿ'];
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 255) {
        break;
      }
      b[i] = -1;
      i += 1;
    }
    while (j < a.length)
    {
      b[a[j]] = ((byte)j);
      j += 1;
    }
    b[9] = -2;
    b[10] = -2;
    b[13] = -2;
    b[32] = -2;
    b[61] = -3;
  }
  
  public static final String decode(String paramString)
  {
    return new String(decode(paramString.getBytes()));
  }
  
  public static final byte[] decode(byte[] paramArrayOfByte)
    throws IllegalArgumentException
  {
    int n = 0;
    int j = 0;
    int k = 0;
    int m = j;
    if (k < paramArrayOfByte.length)
    {
      int i = b[paramArrayOfByte[k]];
      if (i >= 0)
      {
        paramArrayOfByte[j] = i;
        j += 1;
      }
      while (i != -1)
      {
        k += 1;
        break;
      }
      throw new IllegalArgumentException("Invalid base 64 string");
    }
    while ((m > 0) && (paramArrayOfByte[(m - 1)] == -3)) {
      m -= 1;
    }
    byte[] arrayOfByte = new byte[m * 3 / 4];
    j = 0;
    k = n;
    while (k < arrayOfByte.length - 2)
    {
      arrayOfByte[k] = ((byte)(paramArrayOfByte[j] << 2 & 0xFF | paramArrayOfByte[(j + 1)] >>> 4 & 0x3));
      arrayOfByte[(k + 1)] = ((byte)(paramArrayOfByte[(j + 1)] << 4 & 0xFF | paramArrayOfByte[(j + 2)] >>> 2 & 0xF));
      arrayOfByte[(k + 2)] = ((byte)(paramArrayOfByte[(j + 2)] << 6 & 0xFF | paramArrayOfByte[(j + 3)] & 0x3F));
      j += 4;
      k += 3;
    }
    if (k < arrayOfByte.length) {
      arrayOfByte[k] = ((byte)(paramArrayOfByte[j] << 2 & 0xFF | paramArrayOfByte[(j + 1)] >>> 4 & 0x3));
    }
    k += 1;
    if (k < arrayOfByte.length)
    {
      m = paramArrayOfByte[(j + 1)];
      arrayOfByte[k] = ((byte)(paramArrayOfByte[(j + 2)] >>> 2 & 0xF | m << 4 & 0xFF));
    }
    return arrayOfByte;
  }
  
  public static final String encode(String paramString)
  {
    return new String(encode(paramString.getBytes()));
  }
  
  public static final byte[] encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0);
  }
  
  public static final byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    paramInt = paramInt / 4 * 4;
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = (paramArrayOfByte.length + 2) / 3 * 4;
    int j = paramInt;
    if (i > 0) {
      j = paramInt + (paramInt - 1) / i;
    }
    byte[] arrayOfByte = new byte[j];
    int m = 0;
    paramInt = 0;
    for (;;)
    {
      if (m + 3 <= paramArrayOfByte.length)
      {
        int i2 = m + 1;
        int n = paramArrayOfByte[m];
        int i1 = i2 + 1;
        i2 = paramArrayOfByte[i2];
        m = i1 + 1;
        n = (i2 & 0xFF) << 8 | (n & 0xFF) << 16 | (paramArrayOfByte[i1] & 0xFF) << 0;
        i1 = paramInt + 1;
        arrayOfByte[paramInt] = a[((n & 0xFC0000) >> 18)];
        paramInt = i1 + 1;
        arrayOfByte[i1] = a[((n & 0x3F000) >> 12)];
        i1 = paramInt + 1;
        arrayOfByte[paramInt] = a[((n & 0xFC0) >> 6)];
        paramInt = i1 + 1;
        arrayOfByte[i1] = a[(n & 0x3F)];
        k += 4;
        if ((paramInt < j) && (i > 0) && (k % i == 0))
        {
          n = paramInt + 1;
          arrayOfByte[paramInt] = 10;
          paramInt = n;
        }
      }
      else
      {
        if (paramArrayOfByte.length - m == 2)
        {
          i = (paramArrayOfByte[m] & 0xFF) << 16 | (paramArrayOfByte[(m + 1)] & 0xFF) << 8;
          j = paramInt + 1;
          arrayOfByte[paramInt] = a[((i & 0xFC0000) >> 18)];
          paramInt = j + 1;
          arrayOfByte[j] = a[((i & 0x3F000) >> 12)];
          j = paramInt + 1;
          arrayOfByte[paramInt] = a[((i & 0xFC0) >> 6)];
          arrayOfByte[j] = 61;
        }
        while (paramArrayOfByte.length - m != 1) {
          return arrayOfByte;
        }
        i = (paramArrayOfByte[m] & 0xFF) << 16;
        j = paramInt + 1;
        arrayOfByte[paramInt] = a[((i & 0xFC0000) >> 18)];
        paramInt = j + 1;
        arrayOfByte[j] = a[((i & 0x3F000) >> 12)];
        i = paramInt + 1;
        arrayOfByte[paramInt] = 61;
        arrayOfByte[i] = 61;
        return arrayOfByte;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */