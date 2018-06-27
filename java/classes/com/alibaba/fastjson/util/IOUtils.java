package com.alibaba.fastjson.util;

import com.alibaba.fastjson.d;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

public class IOUtils
{
  public static final char[] ASCII_CHARS;
  public static final char[] CA;
  public static final Properties DEFAULT_PROPERTIES = new Properties();
  public static final char[] DIGITS;
  static final char[] DigitOnes;
  static final char[] DigitTens;
  public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
  public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
  public static final String FASTJSON_PROPERTIES = "fastjson.properties";
  public static final int[] IA;
  public static final Charset UTF8 = Charset.forName("UTF-8");
  static final char[] digits;
  public static final boolean[] firstIdentifierFlags;
  public static final boolean[] identifierFlags;
  public static final char[] replaceChars;
  static final int[] sizeTable;
  public static final byte[] specicalFlags_doubleQuotes;
  public static final boolean[] specicalFlags_doubleQuotesFlags;
  public static final byte[] specicalFlags_singleQuotes;
  public static final boolean[] specicalFlags_singleQuotesFlags;
  
  static
  {
    DIGITS = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    firstIdentifierFlags = new boolean['Ā'];
    int i = 0;
    if (i < firstIdentifierFlags.length)
    {
      if ((i >= 65) && (i <= 90)) {
        firstIdentifierFlags[i] = true;
      }
      for (;;)
      {
        i = (char)(i + 1);
        break;
        if ((i >= 97) && (i <= 122)) {
          firstIdentifierFlags[i] = true;
        } else if (i == 95) {
          firstIdentifierFlags[i] = true;
        }
      }
    }
    identifierFlags = new boolean['Ā'];
    i = 0;
    if (i < identifierFlags.length)
    {
      if ((i >= 65) && (i <= 90)) {
        identifierFlags[i] = true;
      }
      for (;;)
      {
        i = (char)(i + 1);
        break;
        if ((i >= 97) && (i <= 122)) {
          identifierFlags[i] = true;
        } else if (i == 95) {
          identifierFlags[i] = true;
        } else if ((i >= 48) && (i <= 57)) {
          identifierFlags[i] = true;
        }
      }
    }
    try
    {
      new PropertiesInitializer().autoConfig();
      specicalFlags_doubleQuotes = new byte['¡'];
      specicalFlags_singleQuotes = new byte['¡'];
      specicalFlags_doubleQuotesFlags = new boolean['¡'];
      specicalFlags_singleQuotesFlags = new boolean['¡'];
      replaceChars = new char[93];
      specicalFlags_doubleQuotes[0] = 4;
      specicalFlags_doubleQuotes[1] = 4;
      specicalFlags_doubleQuotes[2] = 4;
      specicalFlags_doubleQuotes[3] = 4;
      specicalFlags_doubleQuotes[4] = 4;
      specicalFlags_doubleQuotes[5] = 4;
      specicalFlags_doubleQuotes[6] = 4;
      specicalFlags_doubleQuotes[7] = 4;
      specicalFlags_doubleQuotes[8] = 1;
      specicalFlags_doubleQuotes[9] = 1;
      specicalFlags_doubleQuotes[10] = 1;
      specicalFlags_doubleQuotes[11] = 4;
      specicalFlags_doubleQuotes[12] = 1;
      specicalFlags_doubleQuotes[13] = 1;
      specicalFlags_doubleQuotes[34] = 1;
      specicalFlags_doubleQuotes[92] = 1;
      specicalFlags_singleQuotes[0] = 4;
      specicalFlags_singleQuotes[1] = 4;
      specicalFlags_singleQuotes[2] = 4;
      specicalFlags_singleQuotes[3] = 4;
      specicalFlags_singleQuotes[4] = 4;
      specicalFlags_singleQuotes[5] = 4;
      specicalFlags_singleQuotes[6] = 4;
      specicalFlags_singleQuotes[7] = 4;
      specicalFlags_singleQuotes[8] = 1;
      specicalFlags_singleQuotes[9] = 1;
      specicalFlags_singleQuotes[10] = 1;
      specicalFlags_singleQuotes[11] = 4;
      specicalFlags_singleQuotes[12] = 1;
      specicalFlags_singleQuotes[13] = 1;
      specicalFlags_singleQuotes[92] = 1;
      specicalFlags_singleQuotes[39] = 1;
      i = 14;
      while (i <= 31)
      {
        specicalFlags_doubleQuotes[i] = 4;
        specicalFlags_singleQuotes[i] = 4;
        i += 1;
      }
      i = 127;
      while (i < 160)
      {
        specicalFlags_doubleQuotes[i] = 4;
        specicalFlags_singleQuotes[i] = 4;
        i += 1;
      }
      i = 0;
      if (i < 161)
      {
        boolean[] arrayOfBoolean = specicalFlags_doubleQuotesFlags;
        if (specicalFlags_doubleQuotes[i] != 0)
        {
          k = 1;
          label637:
          arrayOfBoolean[i] = k;
          arrayOfBoolean = specicalFlags_singleQuotesFlags;
          if (specicalFlags_singleQuotes[i] == 0) {
            break label671;
          }
        }
        label671:
        for (int k = 1;; k = 0)
        {
          arrayOfBoolean[i] = k;
          i += 1;
          break;
          k = 0;
          break label637;
        }
      }
      replaceChars[0] = '0';
      replaceChars[1] = '1';
      replaceChars[2] = '2';
      replaceChars[3] = '3';
      replaceChars[4] = '4';
      replaceChars[5] = '5';
      replaceChars[6] = '6';
      replaceChars[7] = '7';
      replaceChars[8] = 'b';
      replaceChars[9] = 't';
      replaceChars[10] = 'n';
      replaceChars[11] = 'v';
      replaceChars[12] = 'f';
      replaceChars[13] = 'r';
      replaceChars[34] = '"';
      replaceChars[39] = '\'';
      replaceChars[47] = '/';
      replaceChars[92] = '\\';
      ASCII_CHARS = new char[] { 48, 48, 48, 49, 48, 50, 48, 51, 48, 52, 48, 53, 48, 54, 48, 55, 48, 56, 48, 57, 48, 65, 48, 66, 48, 67, 48, 68, 48, 69, 48, 70, 49, 48, 49, 49, 49, 50, 49, 51, 49, 52, 49, 53, 49, 54, 49, 55, 49, 56, 49, 57, 49, 65, 49, 66, 49, 67, 49, 68, 49, 69, 49, 70, 50, 48, 50, 49, 50, 50, 50, 51, 50, 52, 50, 53, 50, 54, 50, 55, 50, 56, 50, 57, 50, 65, 50, 66, 50, 67, 50, 68, 50, 69, 50, 70 };
      digits = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      DigitTens = new char[] { 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 53, 53, 53, 53, 53, 53, 53, 53, 53, 53, 54, 54, 54, 54, 54, 54, 54, 54, 54, 54, 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 57, 57, 57, 57, 57, 57, 57, 57, 57, 57 };
      DigitOnes = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
      sizeTable = new int[] { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
      CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
      IA = new int['Ā'];
      Arrays.fill(IA, -1);
      int j = CA.length;
      i = 0;
      while (i < j)
      {
        IA[CA[i]] = i;
        i += 1;
      }
      IA[61] = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void decode(CharsetDecoder paramCharsetDecoder, ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    try
    {
      paramByteBuffer = paramCharsetDecoder.decode(paramByteBuffer, paramCharBuffer, true);
      if (!paramByteBuffer.isUnderflow()) {
        paramByteBuffer.throwException();
      }
      paramCharsetDecoder = paramCharsetDecoder.flush(paramCharBuffer);
      if (!paramCharsetDecoder.isUnderflow()) {
        paramCharsetDecoder.throwException();
      }
      return;
    }
    catch (CharacterCodingException paramCharsetDecoder)
    {
      throw new d("utf8 decode error, " + paramCharsetDecoder.getMessage(), paramCharsetDecoder);
    }
  }
  
  public static byte[] decodeBase64(String paramString)
  {
    int i2 = 0;
    int k = paramString.length();
    if (k == 0) {
      return new byte[0];
    }
    int n = k - 1;
    int i = 0;
    while ((i < n) && (IA[(paramString.charAt(i) & 0xFF)] < 0)) {
      i += 1;
    }
    for (;;)
    {
      if ((n > 0) && (IA[(paramString.charAt(n) & 0xFF)] < 0))
      {
        n -= 1;
      }
      else
      {
        int j;
        int m;
        if (paramString.charAt(n) == '=') {
          if (paramString.charAt(n - 1) == '=')
          {
            j = 2;
            m = n - i + 1;
            if (k <= 76) {
              break label388;
            }
            if (paramString.charAt(76) != '\r') {
              break label383;
            }
            k = m / 78;
          }
        }
        label140:
        int i6;
        byte[] arrayOfByte;
        int i3;
        label383:
        label388:
        for (int i1 = k << 1;; i1 = 0)
        {
          i6 = ((m - i1) * 6 >> 3) - j;
          arrayOfByte = new byte[i6];
          int i7 = i6 / 3;
          m = 0;
          k = 0;
          while (k < i7 * 3)
          {
            int[] arrayOfInt = IA;
            int i4 = i + 1;
            i = arrayOfInt[paramString.charAt(i)];
            arrayOfInt = IA;
            i3 = i4 + 1;
            i4 = arrayOfInt[paramString.charAt(i4)];
            arrayOfInt = IA;
            int i5 = i3 + 1;
            int i8 = arrayOfInt[paramString.charAt(i3)];
            arrayOfInt = IA;
            i3 = i5 + 1;
            i = i8 << 6 | i << 18 | i4 << 12 | arrayOfInt[paramString.charAt(i5)];
            i4 = k + 1;
            arrayOfByte[k] = ((byte)(i >> 16));
            k = i4 + 1;
            arrayOfByte[i4] = ((byte)(i >> 8));
            i4 = k + 1;
            arrayOfByte[k] = ((byte)i);
            i = i3;
            k = i4;
            if (i1 > 0)
            {
              i5 = m + 1;
              m = i5;
              i = i3;
              k = i4;
              if (i5 == 19)
              {
                i = i3 + 2;
                m = 0;
                k = i4;
              }
            }
          }
          j = 1;
          break;
          j = 0;
          break;
          k = 0;
          break label140;
        }
        if (k < i6)
        {
          i1 = i;
          m = 0;
          i = i2;
          for (;;)
          {
            i2 = i;
            if (i1 > n - j) {
              break;
            }
            i3 = IA[paramString.charAt(i1)];
            i = i2 + 1;
            m = i3 << 18 - i2 * 6 | m;
            i1 += 1;
          }
          j = 16;
          i = k;
          while (i < i6)
          {
            arrayOfByte[i] = ((byte)(m >> j));
            j -= 8;
            i += 1;
          }
        }
        return arrayOfByte;
      }
    }
  }
  
  public static byte[] decodeBase64(String paramString, int paramInt1, int paramInt2)
  {
    int n = 0;
    if (paramInt2 == 0) {
      return new byte[0];
    }
    int k = paramInt1 + paramInt2 - 1;
    while ((paramInt1 < k) && (IA[paramString.charAt(paramInt1)] < 0)) {
      paramInt1 += 1;
    }
    for (;;)
    {
      if ((k > 0) && (IA[paramString.charAt(k)] < 0))
      {
        k -= 1;
      }
      else
      {
        int i;
        int j;
        if (paramString.charAt(k) == '=') {
          if (paramString.charAt(k - 1) == '=')
          {
            i = 2;
            j = k - paramInt1 + 1;
            if (paramInt2 <= 76) {
              break label375;
            }
            if (paramString.charAt(76) != '\r') {
              break label370;
            }
            paramInt2 = j / 78;
          }
        }
        label127:
        int i4;
        byte[] arrayOfByte;
        int i1;
        label370:
        label375:
        for (int m = paramInt2 << 1;; m = 0)
        {
          i4 = ((j - m) * 6 >> 3) - i;
          arrayOfByte = new byte[i4];
          int i5 = i4 / 3;
          j = 0;
          paramInt2 = 0;
          while (paramInt2 < i5 * 3)
          {
            int[] arrayOfInt = IA;
            int i2 = paramInt1 + 1;
            paramInt1 = arrayOfInt[paramString.charAt(paramInt1)];
            arrayOfInt = IA;
            i1 = i2 + 1;
            i2 = arrayOfInt[paramString.charAt(i2)];
            arrayOfInt = IA;
            int i3 = i1 + 1;
            int i6 = arrayOfInt[paramString.charAt(i1)];
            arrayOfInt = IA;
            i1 = i3 + 1;
            paramInt1 = i6 << 6 | paramInt1 << 18 | i2 << 12 | arrayOfInt[paramString.charAt(i3)];
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 16));
            paramInt2 = i2 + 1;
            arrayOfByte[i2] = ((byte)(paramInt1 >> 8));
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)paramInt1);
            paramInt1 = i1;
            paramInt2 = i2;
            if (m > 0)
            {
              i3 = j + 1;
              j = i3;
              paramInt1 = i1;
              paramInt2 = i2;
              if (i3 == 19)
              {
                paramInt1 = i1 + 2;
                j = 0;
                paramInt2 = i2;
              }
            }
          }
          i = 1;
          break;
          i = 0;
          break;
          paramInt2 = 0;
          break label127;
        }
        if (paramInt2 < i4)
        {
          m = paramInt1;
          j = 0;
          paramInt1 = n;
          for (;;)
          {
            n = paramInt1;
            if (m > k - i) {
              break;
            }
            i1 = IA[paramString.charAt(m)];
            paramInt1 = n + 1;
            j = i1 << 18 - n * 6 | j;
            m += 1;
          }
          i = 16;
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt1 < i4)
          {
            arrayOfByte[paramInt1] = ((byte)(j >> paramInt2));
            paramInt2 -= 8;
            paramInt1 += 1;
          }
        }
        return arrayOfByte;
      }
    }
  }
  
  public static byte[] decodeBase64(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int n = 0;
    if (paramInt2 == 0) {
      return new byte[0];
    }
    int k = paramInt1 + paramInt2 - 1;
    while ((paramInt1 < k) && (IA[paramArrayOfChar[paramInt1]] < 0)) {
      paramInt1 += 1;
    }
    for (;;)
    {
      if ((k > 0) && (IA[paramArrayOfChar[k]] < 0))
      {
        k -= 1;
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfChar[k] == '=') {
          if (paramArrayOfChar[(k - 1)] == '=')
          {
            i = 2;
            j = k - paramInt1 + 1;
            if (paramInt2 <= 76) {
              break label357;
            }
            if (paramArrayOfChar[76] != '\r') {
              break label352;
            }
            paramInt2 = j / 78;
          }
        }
        label117:
        int i4;
        byte[] arrayOfByte;
        int i1;
        label352:
        label357:
        for (int m = paramInt2 << 1;; m = 0)
        {
          i4 = ((j - m) * 6 >> 3) - i;
          arrayOfByte = new byte[i4];
          int i5 = i4 / 3;
          j = 0;
          paramInt2 = 0;
          while (paramInt2 < i5 * 3)
          {
            int[] arrayOfInt = IA;
            int i2 = paramInt1 + 1;
            paramInt1 = arrayOfInt[paramArrayOfChar[paramInt1]];
            arrayOfInt = IA;
            i1 = i2 + 1;
            i2 = arrayOfInt[paramArrayOfChar[i2]];
            arrayOfInt = IA;
            int i3 = i1 + 1;
            int i6 = arrayOfInt[paramArrayOfChar[i1]];
            arrayOfInt = IA;
            i1 = i3 + 1;
            paramInt1 = i6 << 6 | paramInt1 << 18 | i2 << 12 | arrayOfInt[paramArrayOfChar[i3]];
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 16));
            paramInt2 = i2 + 1;
            arrayOfByte[i2] = ((byte)(paramInt1 >> 8));
            i2 = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)paramInt1);
            paramInt1 = i1;
            paramInt2 = i2;
            if (m > 0)
            {
              i3 = j + 1;
              j = i3;
              paramInt1 = i1;
              paramInt2 = i2;
              if (i3 == 19)
              {
                paramInt1 = i1 + 2;
                j = 0;
                paramInt2 = i2;
              }
            }
          }
          i = 1;
          break;
          i = 0;
          break;
          paramInt2 = 0;
          break label117;
        }
        if (paramInt2 < i4)
        {
          m = paramInt1;
          j = 0;
          paramInt1 = n;
          for (;;)
          {
            n = paramInt1;
            if (m > k - i) {
              break;
            }
            i1 = IA[paramArrayOfChar[m]];
            paramInt1 = n + 1;
            j = i1 << 18 - n * 6 | j;
            m += 1;
          }
          i = 16;
          paramInt1 = paramInt2;
          paramInt2 = i;
          while (paramInt1 < i4)
          {
            arrayOfByte[paramInt1] = ((byte)(j >> paramInt2));
            paramInt2 -= 8;
            paramInt1 += 1;
          }
        }
        return arrayOfByte;
      }
    }
  }
  
  public static int decodeUTF8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    int k = paramInt1 + paramInt2;
    int j = 0;
    int m = Math.min(paramInt2, paramArrayOfChar.length);
    int i = paramInt1;
    for (;;)
    {
      paramInt1 = j;
      paramInt2 = i;
      if (j >= m) {
        break;
      }
      paramInt1 = j;
      paramInt2 = i;
      if (paramArrayOfByte[i] < 0) {
        break;
      }
      paramArrayOfChar[j] = ((char)paramArrayOfByte[i]);
      j += 1;
      i += 1;
    }
    paramArrayOfChar[paramInt1] = ((char)(paramInt2 ^ j << 6 ^ 0xF80));
    paramInt1 += 1;
    paramInt2 = i + 1;
    for (;;)
    {
      if (paramInt2 >= k) {
        return paramInt1;
      }
      i = paramInt2 + 1;
      j = paramArrayOfByte[paramInt2];
      if (j >= 0)
      {
        paramArrayOfChar[paramInt1] = ((char)j);
        paramInt1 += 1;
        paramInt2 = i;
      }
      else
      {
        if ((j >> 5 == -2) && ((j & 0x1E) != 0)) {
          if (i < k)
          {
            paramInt2 = paramArrayOfByte[i];
            if ((paramInt2 & 0xC0) == 128) {
              break;
            }
          }
        }
        int n;
        do
        {
          do
          {
            char c;
            do
            {
              do
              {
                do
                {
                  return -1;
                  if (j >> 4 != -2) {
                    break;
                  }
                } while (i + 1 >= k);
                paramInt2 = i + 1;
                i = paramArrayOfByte[i];
                m = paramArrayOfByte[paramInt2];
              } while (((j == -32) && ((i & 0xE0) == 128)) || ((i & 0xC0) != 128) || ((m & 0xC0) != 128));
              c = (char)(m ^ 0xFFFE1F80 ^ i << 6 ^ j << 12);
            } while (Character.isSurrogate(c));
            paramArrayOfChar[paramInt1] = c;
            paramInt1 += 1;
            paramInt2 += 1;
            break;
          } while ((j >> 3 != -2) || (i + 2 >= k));
          paramInt2 = i + 1;
          i = paramArrayOfByte[i];
          n = paramInt2 + 1;
          m = paramArrayOfByte[paramInt2];
          paramInt2 = n + 1;
          n = paramArrayOfByte[n];
          j = j << 18 ^ i << 12 ^ m << 6 ^ 0x381F80 ^ n;
        } while (((i & 0xC0) != 128) || ((m & 0xC0) != 128) || ((n & 0xC0) != 128) || (!Character.isSupplementaryCodePoint(j)));
        i = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = Character.highSurrogate(j);
        paramInt1 = i + 1;
        paramArrayOfChar[i] = Character.lowSurrogate(j);
      }
    }
    return paramInt1;
  }
  
  public static int encodeUTF8(char[] paramArrayOfChar, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int m = paramInt1 + paramInt2;
    int j = 0;
    int k = Math.min(paramInt2, paramArrayOfByte.length);
    paramInt2 = j;
    while ((paramInt2 < 0 + k) && (paramArrayOfChar[paramInt1] < ''))
    {
      paramArrayOfByte[paramInt2] = ((byte)paramArrayOfChar[paramInt1]);
      paramInt2 += 1;
      paramInt1 += 1;
    }
    for (;;)
    {
      if (paramInt2 < m)
      {
        j = paramInt2 + 1;
        int i = paramArrayOfChar[paramInt2];
        if (i < 128)
        {
          k = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)i);
          paramInt2 = j;
          paramInt1 = k;
        }
        for (;;)
        {
          break;
          if (i < 2048)
          {
            paramInt2 = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
            paramInt1 = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = ((byte)(i & 0x3F | 0x80));
            paramInt2 = j;
          }
          else if ((i >= 55296) && (i < 57344))
          {
            paramInt2 = j - 1;
            if (Character.isHighSurrogate(i)) {
              if (m - paramInt2 < 2) {
                paramInt2 = -1;
              }
            }
            for (;;)
            {
              if (paramInt2 < 0)
              {
                paramInt2 = paramInt1 + 1;
                paramArrayOfByte[paramInt1] = 63;
                paramInt1 = paramInt2;
                paramInt2 = j;
                break;
                char c = paramArrayOfChar[(paramInt2 + 1)];
                if (Character.isLowSurrogate(c))
                {
                  paramInt2 = Character.toCodePoint(i, c);
                }
                else
                {
                  throw new d("encodeUTF8 error", new MalformedInputException(1));
                  paramInt2 = i;
                  if (Character.isLowSurrogate(i)) {
                    throw new d("encodeUTF8 error", new MalformedInputException(1));
                  }
                }
              }
            }
            k = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 18 | 0xF0));
            paramInt1 = k + 1;
            paramArrayOfByte[k] = ((byte)(paramInt2 >> 12 & 0x3F | 0x80));
            k = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 6 & 0x3F | 0x80));
            paramInt1 = k + 1;
            paramArrayOfByte[k] = ((byte)(paramInt2 & 0x3F | 0x80));
            paramInt2 = j + 1;
          }
          else
          {
            paramInt2 = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >> 12 | 0xE0));
            k = paramInt2 + 1;
            paramArrayOfByte[paramInt2] = ((byte)(i >> 6 & 0x3F | 0x80));
            paramInt1 = k + 1;
            paramArrayOfByte[k] = ((byte)(i & 0x3F | 0x80));
            paramInt2 = j;
          }
        }
      }
      return paramInt1;
      j = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
    }
  }
  
  public static boolean firstIdentifier(char paramChar)
  {
    return (paramChar < firstIdentifierFlags.length) && (firstIdentifierFlags[paramChar] != 0);
  }
  
  public static void getChars(byte paramByte, int paramInt, char[] paramArrayOfChar)
  {
    int i = 0;
    int j = paramByte;
    int k = paramInt;
    if (paramByte < 0)
    {
      i = 45;
      j = -paramByte;
      k = paramInt;
    }
    for (;;)
    {
      paramByte = 52429 * j >>> 19;
      k -= 1;
      paramArrayOfChar[k] = digits[(j - ((paramByte << 3) + (paramByte << 1)))];
      if (paramByte == 0)
      {
        if (i != 0) {
          paramArrayOfChar[(k - 1)] = i;
        }
        return;
      }
      j = paramByte;
    }
  }
  
  public static void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar)
  {
    int j;
    int i;
    if (paramInt1 < 0)
    {
      j = -paramInt1;
      i = 45;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    for (;;)
    {
      int k = paramInt1;
      j = paramInt2;
      if (paramInt2 >= 65536)
      {
        j = paramInt2 / 100;
        paramInt2 -= (j << 6) + (j << 5) + (j << 2);
        paramInt1 -= 1;
        paramArrayOfChar[paramInt1] = DigitOnes[paramInt2];
        paramInt1 -= 1;
        paramArrayOfChar[paramInt1] = DigitTens[paramInt2];
        paramInt2 = j;
      }
      else
      {
        do
        {
          j = paramInt1;
          paramInt1 = 52429 * j >>> 19;
          k -= 1;
          paramArrayOfChar[k] = digits[(j - ((paramInt1 << 3) + (paramInt1 << 1)))];
        } while (paramInt1 != 0);
        if (i != 0) {
          paramArrayOfChar[(k - 1)] = i;
        }
        return;
        i = 0;
        j = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = j;
      }
    }
  }
  
  public static void getChars(long paramLong, int paramInt, char[] paramArrayOfChar)
  {
    int i;
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      i = 45;
    }
    for (;;)
    {
      int j;
      if (paramLong > 2147483647L)
      {
        long l = paramLong / 100L;
        j = (int)(paramLong - ((l << 6) + (l << 5) + (l << 2)));
        paramInt -= 1;
        paramArrayOfChar[paramInt] = DigitOnes[j];
        paramInt -= 1;
        paramArrayOfChar[paramInt] = DigitTens[j];
        paramLong = l;
      }
      else
      {
        int k = (int)paramLong;
        j = paramInt;
        paramInt = k;
        while (paramInt >= 65536)
        {
          k = paramInt / 100;
          paramInt -= (k << 6) + (k << 5) + (k << 2);
          j -= 1;
          paramArrayOfChar[j] = DigitOnes[paramInt];
          j -= 1;
          paramArrayOfChar[j] = DigitTens[paramInt];
          paramInt = k;
          continue;
          paramInt = k;
        }
        for (;;)
        {
          k = 52429 * paramInt >>> 19;
          j -= 1;
          paramArrayOfChar[j] = digits[(paramInt - ((k << 3) + (k << 1)))];
          if (k != 0) {
            break;
          }
          if (i != 0) {
            paramArrayOfChar[(j - 1)] = i;
          }
          return;
        }
        i = 0;
      }
    }
  }
  
  public static String getStringProperty(String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = System.getProperty(paramString);
      localObject1 = localObject2;
    }
    catch (SecurityException localSecurityException)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = DEFAULT_PROPERTIES.getProperty(paramString);
    }
    return (String)localObject2;
  }
  
  public static boolean isIdent(char paramChar)
  {
    return (paramChar < identifierFlags.length) && (identifierFlags[paramChar] != 0);
  }
  
  public static void loadPropertiesFromFile()
  {
    InputStream localInputStream = (InputStream)AccessController.doPrivileged(new PrivilegedAction()
    {
      public InputStream run()
      {
        ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
        if (localClassLoader != null) {
          return localClassLoader.getResourceAsStream("fastjson.properties");
        }
        return ClassLoader.getSystemResourceAsStream("fastjson.properties");
      }
    });
    if (localInputStream != null) {}
    try
    {
      DEFAULT_PROPERTIES.load(localInputStream);
      localInputStream.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public static int stringSize(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (paramInt <= sizeTable[i]) {
        return i + 1;
      }
      i += 1;
    }
  }
  
  public static int stringSize(long paramLong)
  {
    int i = 1;
    long l = 10L;
    while (i < 19)
    {
      if (paramLong < l) {
        return i;
      }
      l *= 10L;
      i += 1;
    }
    return 19;
  }
  
  static class PropertiesInitializer
  {
    public void autoConfig()
    {
      IOUtils.loadPropertiesFromFile();
      TypeUtils.compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty("fastjson.compatibleWithJavaBean"));
      TypeUtils.compatibleWithFieldName = "true".equals(IOUtils.getStringProperty("fastjson.compatibleWithFieldName"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */