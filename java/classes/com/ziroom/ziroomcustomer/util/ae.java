package com.ziroom.ziroomcustomer.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ae
{
  private static byte a(String paramString1, String paramString2)
  {
    return (byte)((byte)(Byte.decode("0x" + paramString1).byteValue() << 4) | Byte.decode("0x" + paramString2).byteValue());
  }
  
  public static String byte2HexStr(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + "0" + str2;; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toUpperCase();
  }
  
  public static boolean checkNameChese(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length())
    {
      if (!isChinese(arrayOfChar[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean checkPhoneChese(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length())
    {
      if (isChinese(arrayOfChar[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean equalStr(String paramString)
  {
    int j = paramString.charAt(0);
    int i = 0;
    while (i < paramString.length())
    {
      if (j != paramString.charAt(i)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String gbk2utf8(String paramString)
  {
    try
    {
      paramString = new String(paramString.getBytes("ISO-8859-1"), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2 + 1;
      arrayOfByte[i] = a(paramString.substring(i * 2, k), paramString.substring(k, k + 1));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String hexStr2Str(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    paramString = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length)
    {
      paramString[i] = ((byte)("0123456789ABCDEF".indexOf(arrayOfChar[(i * 2)]) * 16 + "0123456789ABCDEF".indexOf(arrayOfChar[(i * 2 + 1)]) & 0xFF));
      i += 1;
    }
    return new String(paramString);
  }
  
  public static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
  }
  
  public static boolean isNull(String paramString)
  {
    return (paramString == null) || ("".equals(paramString)) || ("null".equals(paramString));
  }
  
  public static boolean isOrderNumeric(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int[] arrayOfInt = new int[arrayOfChar.length];
    int i = 0;
    while (i < arrayOfChar.length)
    {
      arrayOfInt[i] = arrayOfChar[i];
      i += 1;
    }
    i = 0;
    while (i < paramString.length())
    {
      if ((i > 0) && (arrayOfInt[i] != arrayOfInt[(i - 1)] + 1)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isOrderNumeric_(String paramString)
  {
    paramString = paramString.toCharArray();
    int[] arrayOfInt = new int[paramString.length];
    int i = 0;
    while (i < paramString.length)
    {
      arrayOfInt[i] = paramString[i];
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt.length)
    {
      if ((i > 0) && (arrayOfInt[i] != arrayOfInt[(i - 1)] - 1)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isSimplePsw(String paramString)
  {
    return Pattern.compile("password").matcher(paramString).matches();
  }
  
  public static boolean notNull(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString));
  }
  
  public static String parseNull(String paramString1, String paramString2, String paramString3)
  {
    if ((!notNull(paramString1)) || ((notNull(paramString2)) && (paramString1.equals(paramString2)))) {
      return paramString3;
    }
    return paramString1;
  }
  
  public static boolean pswLength(String paramString)
  {
    return (paramString.length() > 5) && (paramString.length() < 17);
  }
  
  public static String str2HexStr(String paramString)
  {
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuilder localStringBuilder = new StringBuilder("");
    paramString = paramString.getBytes();
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuilder.append(arrayOfChar[((paramString[i] & 0xF0) >> 4)]);
      localStringBuilder.append(arrayOfChar[(paramString[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String stringToUnicode(String paramString)
    throws Exception
  {
    String str1 = "";
    int i = 0;
    if (i < paramString.length())
    {
      int j = paramString.charAt(i);
      String str2 = Integer.toHexString(j);
      if (j > 128) {}
      for (str1 = str1 + "\\u" + str2;; str1 = str1 + "\\u00" + str2)
      {
        i += 1;
        break;
      }
    }
    return str1;
  }
  
  public static String unicode2String(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.split("\\\\u");
    int i = 1;
    while (i < paramString.length)
    {
      localStringBuffer.append((char)Integer.parseInt(paramString[i], 16));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String unicodeToString(String paramString)
  {
    int j = paramString.length() / 6;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      String str2 = paramString.substring(i * 6, (i + 1) * 6);
      String str1 = str2.substring(2, 4) + "00";
      str2 = str2.substring(4);
      int k = Integer.valueOf(str1, 16).intValue();
      localStringBuilder.append(new String(Character.toChars(Integer.valueOf(str2, 16).intValue() + k)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */