package com.megvii.zhimasdk.a;

public class b
{
  private static char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
  private static byte[] b = new byte['Ā'];
  
  static
  {
    int i = 0;
    while (i < 256)
    {
      b[i] = -1;
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      b[i] = ((byte)(i - 65));
      i += 1;
    }
    i = 97;
    while (i <= 122)
    {
      b[i] = ((byte)(i + 26 - 97));
      i += 1;
    }
    i = 48;
    while (i <= 57)
    {
      b[i] = ((byte)(i + 52 - 48));
      i += 1;
    }
    b[43] = 62;
    b[47] = 63;
  }
  
  public static char[] a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[(paramArrayOfByte.length + 2) / 3 * 4];
    int i = 0;
    int j = 0;
    int m;
    if (j < paramArrayOfByte.length)
    {
      m = (paramArrayOfByte[j] & 0xFF) << 8;
      if (j + 1 >= paramArrayOfByte.length) {
        break label220;
      }
      m |= paramArrayOfByte[(j + 1)] & 0xFF;
    }
    label107:
    label205:
    label220:
    for (int k = 1;; k = 0)
    {
      m <<= 8;
      if (j + 2 < paramArrayOfByte.length) {
        m |= paramArrayOfByte[(j + 2)] & 0xFF;
      }
      for (int n = 1;; n = 0)
      {
        char[] arrayOfChar2 = a;
        if (n != 0)
        {
          n = m & 0x3F;
          arrayOfChar1[(i + 3)] = arrayOfChar2[n];
          m >>= 6;
          arrayOfChar2 = a;
          if (k == 0) {
            break label205;
          }
        }
        for (k = m & 0x3F;; k = 64)
        {
          arrayOfChar1[(i + 2)] = arrayOfChar2[k];
          k = m >> 6;
          arrayOfChar1[(i + 1)] = a[(k & 0x3F)];
          arrayOfChar1[(i + 0)] = a[(k >> 6 & 0x3F)];
          j += 3;
          i += 4;
          break;
          n = 64;
          break label107;
        }
        return arrayOfChar1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */