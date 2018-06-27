package com.ziroom.commonlib.utils;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class r
{
  private static byte a(String paramString1, String paramString2)
  {
    return (byte)((byte)(Byte.decode("0x" + paramString1).byteValue() << 4) | Byte.decode("0x" + paramString2).byteValue());
  }
  
  public static String buildRequestId()
  {
    String str1 = UUID.randomUUID().toString();
    String str2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    return str1.substring(0, 8) + ":" + str2;
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
  
  public static String byteArr2HexStr(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(k * 2);
    int i = 0;
    while (i < k)
    {
      int j = paramArrayOfByte[i];
      while (j < 0) {
        j += 256;
      }
      if (j < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toString(j, 16));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static InputStream bytes2InputStream(byte[] paramArrayOfByte)
  {
    return new ByteArrayInputStream(paramArrayOfByte);
  }
  
  /* Error */
  public static OutputStream bytes2OutputStream(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 102	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 103	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: aload_0
    //   12: invokevirtual 106	java/io/ByteArrayOutputStream:write	([B)V
    //   15: iconst_1
    //   16: anewarray 108	java/io/Closeable
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: invokestatic 114	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   26: aload_1
    //   27: areturn
    //   28: astore_1
    //   29: aconst_null
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   35: iconst_1
    //   36: anewarray 108	java/io/Closeable
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: aastore
    //   43: invokestatic 114	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   46: aconst_null
    //   47: areturn
    //   48: astore_0
    //   49: aload_2
    //   50: astore_1
    //   51: iconst_1
    //   52: anewarray 108	java/io/Closeable
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: invokestatic 114	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: goto -14 -> 51
    //   68: astore_2
    //   69: aload_0
    //   70: astore_1
    //   71: aload_2
    //   72: astore_0
    //   73: goto -22 -> 51
    //   76: astore_2
    //   77: aload_1
    //   78: astore_0
    //   79: aload_2
    //   80: astore_1
    //   81: goto -50 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramArrayOfByte	byte[]
    //   9	18	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   28	4	1	localIOException1	IOException
    //   50	31	1	localObject1	Object
    //   1	49	2	localObject2	Object
    //   68	4	2	localObject3	Object
    //   76	4	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   2	10	28	java/io/IOException
    //   2	10	48	finally
    //   10	15	64	finally
    //   31	35	68	finally
    //   10	15	76	java/io/IOException
  }
  
  public static boolean copyApkFromAssets(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = d.a.getAssets().open(paramString1);
      paramString2 = new File(paramString2);
      paramString2.createNewFile();
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i);
      }
      paramString2.close();
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    paramString1.close();
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
  
  public static String getFromAssets(String paramString)
  {
    try
    {
      Object localObject = d.a.getResources().getAssets().open(paramString);
      byte[] arrayOfByte = new byte[((InputStream)localObject).available()];
      ((InputStream)localObject).read(arrayOfByte);
      ((InputStream)localObject).close();
      localObject = new String(arrayOfByte, "utf-8");
      return (String)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "读取错误，请检查文件名" + paramString;
  }
  
  public static String getNumberFormat(double paramDouble, int paramInt)
  {
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    localNumberFormat.setGroupingUsed(false);
    return localNumberFormat.format(paramDouble);
  }
  
  public static byte[] hexStr2ByteArr(String paramString)
  {
    paramString = paramString.getBytes();
    int j = paramString.length;
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      String str = new String(paramString, i, 2);
      arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(str, 16));
      i += 2;
    }
    return arrayOfByte;
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
  
  /* Error */
  public static ByteArrayOutputStream input2OutputStream(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 102	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 103	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: sipush 1024
    //   17: newarray <illegal type>
    //   19: astore_3
    //   20: aload_0
    //   21: aload_3
    //   22: iconst_0
    //   23: sipush 1024
    //   26: invokevirtual 243	java/io/InputStream:read	([BII)I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +31 -> 63
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_1
    //   39: invokevirtual 244	java/io/ByteArrayOutputStream:write	([BII)V
    //   42: goto -22 -> 20
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   50: iconst_1
    //   51: anewarray 108	java/io/Closeable
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 114	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   61: aconst_null
    //   62: areturn
    //   63: iconst_1
    //   64: anewarray 108	java/io/Closeable
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: aastore
    //   71: invokestatic 114	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   74: aload_2
    //   75: areturn
    //   76: astore_2
    //   77: iconst_1
    //   78: anewarray 108	java/io/Closeable
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: aastore
    //   85: invokestatic 114	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramInputStream	InputStream
    //   29	10	1	i	int
    //   13	23	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   45	30	2	localIOException	IOException
    //   76	13	2	localObject	Object
    //   19	18	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	20	45	java/io/IOException
    //   20	30	45	java/io/IOException
    //   35	42	45	java/io/IOException
    //   6	20	76	finally
    //   20	30	76	finally
    //   35	42	76	finally
    //   46	50	76	finally
  }
  
  public static byte[] inputStream2Bytes(InputStream paramInputStream)
  {
    return input2OutputStream(paramInputStream).toByteArray();
  }
  
  public static String inputStream2String(InputStream paramInputStream, String paramString)
  {
    if ((paramInputStream == null) || (isNull(paramString))) {
      return null;
    }
    try
    {
      paramInputStream = new String(inputStream2Bytes(paramInputStream), paramString);
      return paramInputStream;
    }
    catch (UnsupportedEncodingException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0) || ("".equals(paramString)) || ("null".equals(paramString));
  }
  
  public static boolean isNull(String paramString)
  {
    return (paramString == null) || ("".equals(paramString)) || ("null".equals(paramString));
  }
  
  public static boolean notNull(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString));
  }
  
  public static byte[] outputStream2Bytes(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      return null;
    }
    return ((ByteArrayOutputStream)paramOutputStream).toByteArray();
  }
  
  public static String outputStream2String(OutputStream paramOutputStream, String paramString)
  {
    if (paramOutputStream == null) {
      return null;
    }
    try
    {
      paramOutputStream = new String(outputStream2Bytes(paramOutputStream), paramString);
      return paramOutputStream;
    }
    catch (UnsupportedEncodingException paramOutputStream)
    {
      paramOutputStream.printStackTrace();
    }
    return null;
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
  
  public static InputStream string2InputStream(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (isNull(paramString2))) {
      return null;
    }
    try
    {
      paramString1 = new ByteArrayInputStream(paramString1.getBytes(paramString2));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static OutputStream string2OutputStream(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (isNull(paramString2))) {
      return null;
    }
    try
    {
      paramString1 = bytes2OutputStream(paramString1.getBytes(paramString2));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static int stringToInt(String paramString)
  {
    if (isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */