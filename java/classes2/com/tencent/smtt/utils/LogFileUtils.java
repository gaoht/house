package com.tencent.smtt.utils;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static OutputStream a = null;
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      Log.e("LOG_FILE", "Couldn't close stream!", paramOutputStream);
    }
  }
  
  public static byte[] createHeaderText(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      paramString2 = String.format("%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static String createKey()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  public static byte[] encrypt(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Log.e("LOG_FILE", "encrypt exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  public static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Log.e("LOG_FILE", "encrypt exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_1
    //   7: aload_3
    //   8: invokestatic 125	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;Ljava/lang/String;)[B
    //   11: astore 5
    //   13: aload 6
    //   15: astore_1
    //   16: aload 5
    //   18: ifnull +8 -> 26
    //   21: aconst_null
    //   22: astore_3
    //   23: aload 5
    //   25: astore_1
    //   26: aload_0
    //   27: invokevirtual 131	java/io/File:getParentFile	()Ljava/io/File;
    //   30: invokevirtual 135	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: aload_0
    //   35: invokevirtual 138	java/io/File:isFile	()Z
    //   38: ifeq +31 -> 69
    //   41: aload_0
    //   42: invokevirtual 141	java/io/File:exists	()Z
    //   45: ifeq +24 -> 69
    //   48: aload_0
    //   49: invokevirtual 144	java/io/File:length	()J
    //   52: ldc2_w 145
    //   55: lcmp
    //   56: ifle +13 -> 69
    //   59: aload_0
    //   60: invokevirtual 149	java/io/File:delete	()Z
    //   63: pop
    //   64: aload_0
    //   65: invokevirtual 152	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   72: ifnonnull +23 -> 95
    //   75: new 154	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 156	java/io/FileOutputStream
    //   82: dup
    //   83: aload_0
    //   84: iload 4
    //   86: invokespecial 159	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   89: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   92: putstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   95: aload_3
    //   96: ifnull +29 -> 125
    //   99: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   102: aload_3
    //   103: invokevirtual 164	java/lang/String:getBytes	()[B
    //   106: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   109: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   112: ifnull +9 -> 121
    //   115: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   118: invokevirtual 171	java/io/OutputStream:flush	()V
    //   121: ldc 2
    //   123: monitorexit
    //   124: return
    //   125: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   128: aload_2
    //   129: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   132: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   135: aload_1
    //   136: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   139: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   142: iconst_2
    //   143: newarray <illegal type>
    //   145: dup
    //   146: iconst_0
    //   147: ldc -84
    //   149: bastore
    //   150: dup
    //   151: iconst_1
    //   152: ldc -84
    //   154: bastore
    //   155: invokevirtual 168	java/io/OutputStream:write	([B)V
    //   158: goto -49 -> 109
    //   161: astore_1
    //   162: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   165: ifnull +9 -> 174
    //   168: getstatic 10	com/tencent/smtt/utils/LogFileUtils:a	Ljava/io/OutputStream;
    //   171: invokevirtual 171	java/io/OutputStream:flush	()V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: ldc 25
    //   179: new 105	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   186: ldc -82
    //   188: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: invokevirtual 177	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   195: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc -77
    //   200: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload 4
    //   205: invokevirtual 182	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   208: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: aload_1
    //   212: invokestatic 33	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   215: pop
    //   216: goto -95 -> 121
    //   219: astore_0
    //   220: ldc 2
    //   222: monitorexit
    //   223: aload_0
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramFile	java.io.File
    //   0	225	1	paramString1	String
    //   0	225	2	paramArrayOfByte	byte[]
    //   0	225	3	paramString2	String
    //   0	225	4	paramBoolean	boolean
    //   11	13	5	arrayOfByte	byte[]
    //   1	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	69	161	finally
    //   69	95	161	finally
    //   99	109	161	finally
    //   125	158	161	finally
    //   109	121	176	java/lang/Throwable
    //   162	174	176	java/lang/Throwable
    //   174	176	176	java/lang/Throwable
    //   6	13	219	finally
    //   109	121	219	finally
    //   162	174	219	finally
    //   174	176	219	finally
    //   177	216	219	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/LogFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */