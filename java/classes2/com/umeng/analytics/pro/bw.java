package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bw
{
  public static final String a = System.getProperty("line.separator");
  private static final String b = "helper";
  
  public static String a(File paramFile)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    MessageDigest localMessageDigest;
    try
    {
      if (!paramFile.isFile()) {
        return "";
      }
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    return String.format("%1$032x", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
  }
  
  public static String a(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new InputStreamReader(paramInputStream);
    char[] arrayOfChar = new char['Ѐ'];
    StringWriter localStringWriter = new StringWriter();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (-1 == i) {
        break;
      }
      localStringWriter.write(arrayOfChar, 0, i);
    }
    return localStringWriter.toString();
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject1 = paramString.getBytes();
      Object localObject2 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject2).reset();
      ((MessageDigest)localObject2).update((byte[])localObject1);
      localObject1 = ((MessageDigest)localObject2).digest();
      localObject2 = new StringBuffer();
      while (i < localObject1.length)
      {
        ((StringBuffer)localObject2).append(String.format("%02X", new Object[] { Byte.valueOf(localObject1[i]) }));
        i += 1;
      }
      localObject1 = ((StringBuffer)localObject2).toString();
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return paramString.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
  }
  
  /* Error */
  public static String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 36
    //   2: astore 4
    //   4: aload 4
    //   6: astore 5
    //   8: aload 4
    //   10: astore 6
    //   12: aload_0
    //   13: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +148 -> 164
    //   19: aload 4
    //   21: astore 5
    //   23: aload_0
    //   24: invokevirtual 145	java/lang/String:length	()I
    //   27: iload_1
    //   28: if_icmpge +117 -> 145
    //   31: aload 4
    //   33: astore 5
    //   35: aload_0
    //   36: invokevirtual 145	java/lang/String:length	()I
    //   39: istore_2
    //   40: aload 4
    //   42: astore 5
    //   44: aload_0
    //   45: iconst_0
    //   46: iload_2
    //   47: invokevirtual 149	java/lang/String:substring	(II)Ljava/lang/String;
    //   50: astore 4
    //   52: aload 4
    //   54: astore 5
    //   56: aload 5
    //   58: astore 4
    //   60: aload 5
    //   62: ldc -105
    //   64: invokevirtual 154	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   67: arraylength
    //   68: istore_3
    //   69: iload_1
    //   70: istore_2
    //   71: aload 5
    //   73: astore 4
    //   75: aload 4
    //   77: astore 6
    //   79: iload_3
    //   80: iload_1
    //   81: if_icmple +83 -> 164
    //   84: iload_2
    //   85: iconst_1
    //   86: isub
    //   87: istore_2
    //   88: aload 4
    //   90: astore 5
    //   92: iload_2
    //   93: aload_0
    //   94: invokevirtual 145	java/lang/String:length	()I
    //   97: if_icmple +53 -> 150
    //   100: aload 4
    //   102: astore 5
    //   104: aload_0
    //   105: invokevirtual 145	java/lang/String:length	()I
    //   108: istore_3
    //   109: aload 4
    //   111: astore 5
    //   113: aload_0
    //   114: iconst_0
    //   115: iload_3
    //   116: invokevirtual 149	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: astore 4
    //   121: aload 4
    //   123: astore 5
    //   125: aload 5
    //   127: astore 4
    //   129: aload 5
    //   131: ldc -105
    //   133: invokevirtual 154	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   136: arraylength
    //   137: istore_3
    //   138: aload 5
    //   140: astore 4
    //   142: goto -67 -> 75
    //   145: iload_1
    //   146: istore_2
    //   147: goto -107 -> 40
    //   150: iload_2
    //   151: istore_3
    //   152: goto -43 -> 109
    //   155: astore_0
    //   156: aload_0
    //   157: invokestatic 160	com/umeng/analytics/pro/by:e	(Ljava/lang/Throwable;)V
    //   160: aload 5
    //   162: astore 6
    //   164: aload 6
    //   166: areturn
    //   167: astore_0
    //   168: aload 4
    //   170: astore 5
    //   172: goto -16 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramString	String
    //   0	175	1	paramInt	int
    //   39	112	2	i	int
    //   68	84	3	j	int
    //   2	167	4	localObject1	Object
    //   6	165	5	localObject2	Object
    //   10	155	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	155	java/lang/Exception
    //   23	31	155	java/lang/Exception
    //   35	40	155	java/lang/Exception
    //   44	52	155	java/lang/Exception
    //   92	100	155	java/lang/Exception
    //   104	109	155	java/lang/Exception
    //   113	121	155	java/lang/Exception
    //   60	69	167	java/lang/Exception
    //   129	138	167	java/lang/Exception
  }
  
  public static void a(File paramFile, String paramString)
    throws IOException
  {
    a(paramFile, paramString.getBytes());
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      paramFile.flush();
      return;
    }
    finally
    {
      a(paramFile);
    }
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (Exception paramOutputStream) {}
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 183	java/io/File:exists	()Z
    //   4: istore_1
    //   5: iload_1
    //   6: ifne +9 -> 15
    //   9: aconst_null
    //   10: invokestatic 186	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   13: aconst_null
    //   14: areturn
    //   15: new 46	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 189	java/io/FileInputStream:available	()I
    //   28: newarray <illegal type>
    //   30: astore_2
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 192	java/io/FileInputStream:read	([B)I
    //   36: pop
    //   37: new 76	java/lang/String
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 194	java/lang/String:<init>	([B)V
    //   45: astore_2
    //   46: aload_0
    //   47: invokestatic 186	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   50: aload_2
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_0
    //   55: aload_0
    //   56: invokestatic 186	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_3
    //   64: aload_0
    //   65: astore_2
    //   66: aload_3
    //   67: invokestatic 186	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: aload_0
    //   74: astore_3
    //   75: goto -9 -> 66
    //   78: astore_2
    //   79: goto -24 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramFile	File
    //   4	2	1	bool	boolean
    //   30	41	2	localObject1	Object
    //   72	1	2	localObject2	Object
    //   78	1	2	localThrowable	Throwable
    //   63	12	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	5	52	java/lang/Throwable
    //   15	24	52	java/lang/Throwable
    //   0	5	61	finally
    //   15	24	61	finally
    //   24	46	72	finally
    //   24	46	78	java/lang/Throwable
  }
  
  public static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i = 0;
      while (i < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      by.c("helper", "getMD5 error", paramString);
    }
    return "";
  }
  
  public static byte[] b(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void c(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */