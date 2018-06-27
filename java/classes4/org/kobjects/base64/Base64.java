package org.kobjects.base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64
{
  static final char[] charTab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  static int decode(char paramChar)
  {
    if ((paramChar >= 'A') && (paramChar <= 'Z')) {
      return paramChar - 'A';
    }
    if ((paramChar >= 'a') && (paramChar <= 'z')) {
      return paramChar - 'a' + 26;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0' + 26 + 26;
    }
    switch (paramChar)
    {
    default: 
      throw new RuntimeException("unexpected code: " + paramChar);
    case '+': 
      return 62;
    case '/': 
      return 63;
    }
    return 0;
  }
  
  public static void decode(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    int j = paramString.length();
    for (;;)
    {
      if ((i < j) && (paramString.charAt(i) <= ' '))
      {
        i += 1;
      }
      else
      {
        if (i == j) {}
        int k;
        do
        {
          do
          {
            return;
            k = (decode(paramString.charAt(i)) << 18) + (decode(paramString.charAt(i + 1)) << 12) + (decode(paramString.charAt(i + 2)) << 6) + decode(paramString.charAt(i + 3));
            paramOutputStream.write(k >> 16 & 0xFF);
          } while (paramString.charAt(i + 2) == '=');
          paramOutputStream.write(k >> 8 & 0xFF);
        } while (paramString.charAt(i + 3) == '=');
        paramOutputStream.write(k & 0xFF);
        i += 4;
      }
    }
  }
  
  public static byte[] decode(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      decode(paramString, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      throw new RuntimeException();
    }
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, null).toString();
  }
  
  public static StringBuffer encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    StringBuffer localStringBuffer = paramStringBuffer;
    if (paramStringBuffer == null) {
      localStringBuffer = new StringBuffer(paramArrayOfByte.length * 3 / 2);
    }
    int k = 0;
    int j = paramInt1;
    while (j <= paramInt2 - 3)
    {
      int i = (paramArrayOfByte[j] & 0xFF) << 16 | (paramArrayOfByte[(j + 1)] & 0xFF) << 8 | paramArrayOfByte[(j + 2)] & 0xFF;
      localStringBuffer.append(charTab[(i >> 18 & 0x3F)]);
      localStringBuffer.append(charTab[(i >> 12 & 0x3F)]);
      localStringBuffer.append(charTab[(i >> 6 & 0x3F)]);
      localStringBuffer.append(charTab[(i & 0x3F)]);
      i = k + 1;
      if (k >= 14)
      {
        localStringBuffer.append("\r\n");
        i = 0;
      }
      j += 3;
      k = i;
    }
    if (j == paramInt1 + paramInt2 - 2)
    {
      paramInt1 = paramArrayOfByte[j];
      paramInt1 = (paramArrayOfByte[(j + 1)] & 0xFF) << 8 | (paramInt1 & 0xFF) << 16;
      localStringBuffer.append(charTab[(paramInt1 >> 18 & 0x3F)]);
      localStringBuffer.append(charTab[(paramInt1 >> 12 & 0x3F)]);
      localStringBuffer.append(charTab[(paramInt1 >> 6 & 0x3F)]);
      localStringBuffer.append("=");
    }
    while (j != paramInt1 + paramInt2 - 1) {
      return localStringBuffer;
    }
    paramInt1 = (paramArrayOfByte[j] & 0xFF) << 16;
    localStringBuffer.append(charTab[(paramInt1 >> 18 & 0x3F)]);
    localStringBuffer.append(charTab[(paramInt1 >> 12 & 0x3F)]);
    localStringBuffer.append("==");
    return localStringBuffer;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/kobjects/base64/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */