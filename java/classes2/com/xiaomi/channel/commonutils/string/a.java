package com.xiaomi.channel.commonutils.string;

public class a
{
  private static final String a;
  private static char[] b;
  private static byte[] c;
  
  static
  {
    int m = 0;
    a = System.getProperty("line.separator");
    b = new char[64];
    int i = 65;
    int j = 0;
    while (i <= 90)
    {
      b[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 97;
    while (i <= 122)
    {
      b[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 48;
    while (i <= 57)
    {
      b[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    char[] arrayOfChar = b;
    int k = j + 1;
    arrayOfChar[j] = '+';
    b[k] = '/';
    c = new byte[''];
    j = 0;
    for (;;)
    {
      k = m;
      if (j >= c.length) {
        break;
      }
      c[j] = -1;
      j += 1;
    }
    while (k < 64)
    {
      c[b[k]] = ((byte)k);
      k += 1;
    }
  }
  
  public static byte[] a(String paramString)
  {
    return a(paramString.toCharArray());
  }
  
  public static byte[] a(char[] paramArrayOfChar)
  {
    return a(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static byte[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 % 4 != 0) {
      throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
    while ((i > 0) && (paramArrayOfChar[(paramInt1 + i - 1)] == '=')) {
      i -= 1;
    }
    int k = i * 3 / 4;
    byte[] arrayOfByte = new byte[k];
    int m = paramInt1 + i;
    paramInt2 = 0;
    int n;
    int j;
    if (paramInt1 < m)
    {
      i = paramInt1 + 1;
      n = paramArrayOfChar[paramInt1];
      paramInt1 = i + 1;
      int i1 = paramArrayOfChar[i];
      if (paramInt1 < m)
      {
        i = paramArrayOfChar[paramInt1];
        paramInt1 += 1;
        if (paramInt1 >= m) {
          break label157;
        }
        j = paramArrayOfChar[paramInt1];
        paramInt1 += 1;
      }
      for (;;)
      {
        if ((n <= 127) && (i1 <= 127) && (i <= 127) && (j <= 127)) {
          break label164;
        }
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
        i = 65;
        break;
        label157:
        j = 65;
      }
      label164:
      int i2 = c[n];
      i1 = c[i1];
      n = c[i];
      j = c[j];
      if ((i2 < 0) || (i1 < 0) || (n < 0) || (j < 0)) {
        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
      }
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = ((byte)(i2 << 2 | i1 >>> 4));
      if (i >= k) {
        break label306;
      }
      paramInt2 = i + 1;
      arrayOfByte[i] = ((byte)((i1 & 0xF) << 4 | n >>> 2));
    }
    for (;;)
    {
      if (paramInt2 < k)
      {
        i = paramInt2 + 1;
        arrayOfByte[paramInt2] = ((byte)((n & 0x3) << 6 | j));
        paramInt2 = i;
      }
      for (;;)
      {
        break;
        return arrayOfByte;
      }
      label306:
      paramInt2 = i;
    }
  }
  
  public static char[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static char[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = (paramInt2 * 4 + 2) / 3;
    char[] arrayOfChar = new char[(paramInt2 + 2) / 3 * 4];
    int i1 = paramInt1 + paramInt2;
    paramInt2 = 0;
    if (paramInt1 < i1)
    {
      int j = paramInt1 + 1;
      int i2 = paramArrayOfByte[paramInt1] & 0xFF;
      int k;
      if (j < i1)
      {
        paramInt1 = paramArrayOfByte[j] & 0xFF;
        k = j + 1;
        j = paramInt1;
        paramInt1 = k;
        label75:
        if (paramInt1 >= i1) {
          break label218;
        }
        k = paramInt1 + 1;
        int m = paramArrayOfByte[paramInt1] & 0xFF;
        paramInt1 = k;
        k = m;
        label102:
        m = paramInt2 + 1;
        arrayOfChar[paramInt2] = b[(i2 >>> 2)];
        paramInt2 = m + 1;
        arrayOfChar[m] = b[((i2 & 0x3) << 4 | j >>> 4)];
        if (paramInt2 >= n) {
          break label224;
        }
        i = b[((j & 0xF) << 2 | k >>> 6)];
        label168:
        arrayOfChar[paramInt2] = i;
        paramInt2 += 1;
        if (paramInt2 >= n) {
          break label230;
        }
      }
      label218:
      label224:
      label230:
      for (int i = b[(k & 0x3F)];; i = 61)
      {
        arrayOfChar[paramInt2] = i;
        paramInt2 += 1;
        break;
        k = 0;
        paramInt1 = j;
        j = k;
        break label75;
        k = 0;
        break label102;
        i = 61;
        break label168;
      }
    }
    return arrayOfChar;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/string/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */