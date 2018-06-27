package com.facebook.common.util;

public class Hex
{
  private static final byte[] DIGITS;
  private static final char[] FIRST_CHAR;
  private static final char[] HEX_DIGITS;
  private static final char[] SECOND_CHAR;
  
  static
  {
    int k = 0;
    HEX_DIGITS = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    FIRST_CHAR = new char['Ā'];
    SECOND_CHAR = new char['Ā'];
    int j = 0;
    while (j < 256)
    {
      FIRST_CHAR[j] = HEX_DIGITS[(j >> 4 & 0xF)];
      SECOND_CHAR[j] = HEX_DIGITS[(j & 0xF)];
      j += 1;
    }
    DIGITS = new byte[103];
    j = 0;
    while (j <= 70)
    {
      DIGITS[j] = -1;
      j += 1;
    }
    for (int i = 0;; i = (byte)(i + 1))
    {
      j = k;
      if (i >= 10) {
        break;
      }
      DIGITS[(i + 48)] = i;
    }
    while (j < 6)
    {
      DIGITS[(j + 65)] = ((byte)(j + 10));
      DIGITS[(j + 97)] = ((byte)(j + 10));
      j = (byte)(j + 1);
    }
  }
  
  public static String byte2Hex(int paramInt)
  {
    if ((paramInt > 255) || (paramInt < 0)) {
      throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    }
    return String.valueOf(FIRST_CHAR[paramInt]) + String.valueOf(SECOND_CHAR[paramInt]);
  }
  
  public static byte[] decodeHex(String paramString)
  {
    int k = 1;
    int n = paramString.length();
    if ((n & 0x1) != 0) {
      throw new IllegalArgumentException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[n >> 1];
    int j = 0;
    int i = 0;
    int i1;
    if (j < n)
    {
      i1 = j + 1;
      j = paramString.charAt(j);
      if (j > 102) {
        j = k;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + paramString);
        int i2 = DIGITS[j];
        j = k;
        if (i2 == -1) {
          continue;
        }
        int m = i1 + 1;
        i1 = paramString.charAt(i1);
        j = k;
        if (i1 > 102) {
          continue;
        }
        i1 = DIGITS[i1];
        j = k;
        if (i1 == -1) {
          continue;
        }
        arrayOfByte[i] = ((byte)(i1 | i2 << 4));
        i += 1;
        j = m;
        break;
      }
      return arrayOfByte;
      j = 0;
    }
  }
  
  public static String encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k;
      if (i < paramArrayOfByte.length)
      {
        k = paramArrayOfByte[i] & 0xFF;
        if ((k != 0) || (!paramBoolean)) {}
      }
      else
      {
        return new String(arrayOfChar, 0, j);
      }
      int m = j + 1;
      arrayOfChar[j] = FIRST_CHAR[k];
      j = m + 1;
      arrayOfChar[m] = SECOND_CHAR[k];
      i += 1;
    }
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    return decodeHex(paramString.replaceAll(" ", ""));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/util/Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */