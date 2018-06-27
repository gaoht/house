package com.xiaomi.channel.commonutils.file;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.zip.GZIPOutputStream;

public class a
{
  public static final String[] a = { "jpg", "png", "bmp", "gif", "webp" };
  
  public static void a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null) {}
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramParcelFileDescriptor) {}
  }
  
  /* Error */
  public static void a(java.io.File paramFile1, java.io.File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 36	java/util/zip/ZipOutputStream
    //   7: dup
    //   8: new 38	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: iconst_0
    //   14: invokespecial 42	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   17: invokespecial 45	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_0
    //   21: aload_0
    //   22: aload_1
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokestatic 48	com/xiaomi/channel/commonutils/file/a:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   28: aload_0
    //   29: invokestatic 50	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   32: return
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 50	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   40: return
    //   41: astore_1
    //   42: aload_3
    //   43: astore_0
    //   44: aload_0
    //   45: astore_2
    //   46: new 52	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   53: ldc 56
    //   55: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: invokevirtual 64	java/io/IOException:getMessage	()Ljava/lang/String;
    //   62: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 72	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: invokestatic 50	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   75: return
    //   76: astore_1
    //   77: aload_2
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 50	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: goto -7 -> 79
    //   89: astore_1
    //   90: goto -46 -> 44
    //   93: astore_1
    //   94: goto -58 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramFile1	java.io.File
    //   0	97	1	paramFile2	java.io.File
    //   1	77	2	localFile	java.io.File
    //   3	40	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	21	33	java/io/FileNotFoundException
    //   4	21	41	java/io/IOException
    //   4	21	76	finally
    //   46	71	76	finally
    //   21	28	85	finally
    //   21	28	89	java/io/IOException
    //   21	28	93	java/io/FileNotFoundException
  }
  
  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.flush();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          paramOutputStream.close();
          return;
        }
        catch (IOException paramOutputStream) {}
        localIOException = localIOException;
      }
    }
  }
  
  public static void a(Reader paramReader)
  {
    if (paramReader != null) {}
    try
    {
      paramReader.close();
      return;
    }
    catch (IOException paramReader) {}
  }
  
  public static void a(Writer paramWriter)
  {
    if (paramWriter != null) {}
    try
    {
      paramWriter.close();
      return;
    }
    catch (IOException paramWriter) {}
  }
  
  /* Error */
  public static void a(java.util.zip.ZipOutputStream paramZipOutputStream, java.io.File paramFile, String paramString, java.io.FileFilter paramFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_2
    //   10: astore 7
    //   12: aload_2
    //   13: ifnonnull +7 -> 20
    //   16: ldc 92
    //   18: astore 7
    //   20: aload 10
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 98	java/io/File:isDirectory	()Z
    //   27: ifeq +268 -> 295
    //   30: aload_3
    //   31: ifnull +125 -> 156
    //   34: aload 10
    //   36: astore_2
    //   37: aload_1
    //   38: aload_3
    //   39: invokevirtual 102	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   42: astore 8
    //   44: aload 10
    //   46: astore_2
    //   47: aload_0
    //   48: new 104	java/util/zip/ZipEntry
    //   51: dup
    //   52: new 52	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   59: aload 7
    //   61: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 108	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 110	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   76: invokevirtual 114	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   79: aload 10
    //   81: astore_2
    //   82: aload 7
    //   84: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +81 -> 168
    //   90: ldc 92
    //   92: astore 7
    //   94: goto +382 -> 476
    //   97: aload 10
    //   99: astore_2
    //   100: iload 4
    //   102: aload 8
    //   104: arraylength
    //   105: if_icmpge +92 -> 197
    //   108: aload 10
    //   110: astore_2
    //   111: aload_0
    //   112: aload 8
    //   114: iload 4
    //   116: aaload
    //   117: new 52	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   124: aload 7
    //   126: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 8
    //   131: iload 4
    //   133: aaload
    //   134: invokevirtual 123	java/io/File:getName	()Ljava/lang/String;
    //   137: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: aconst_null
    //   144: invokestatic 48	com/xiaomi/channel/commonutils/file/a:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   147: iload 4
    //   149: iconst_1
    //   150: iadd
    //   151: istore 4
    //   153: goto -56 -> 97
    //   156: aload 10
    //   158: astore_2
    //   159: aload_1
    //   160: invokevirtual 126	java/io/File:listFiles	()[Ljava/io/File;
    //   163: astore 8
    //   165: goto -121 -> 44
    //   168: aload 10
    //   170: astore_2
    //   171: new 52	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   178: aload 7
    //   180: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: getstatic 108	java/io/File:separator	Ljava/lang/String;
    //   186: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore 7
    //   194: goto +282 -> 476
    //   197: aload 10
    //   199: astore_2
    //   200: aload_1
    //   201: new 128	com/xiaomi/channel/commonutils/file/b
    //   204: dup
    //   205: invokespecial 129	com/xiaomi/channel/commonutils/file/b:<init>	()V
    //   208: invokevirtual 102	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +75 -> 288
    //   216: aload 10
    //   218: astore_2
    //   219: aload_1
    //   220: arraylength
    //   221: istore 6
    //   223: iload 5
    //   225: istore 4
    //   227: iload 4
    //   229: iload 6
    //   231: if_icmpge +57 -> 288
    //   234: aload_1
    //   235: iload 4
    //   237: aaload
    //   238: astore 8
    //   240: aload 10
    //   242: astore_2
    //   243: aload_0
    //   244: aload 8
    //   246: new 52	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   253: aload 7
    //   255: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: getstatic 108	java/io/File:separator	Ljava/lang/String;
    //   261: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 8
    //   266: invokevirtual 123	java/io/File:getName	()Ljava/lang/String;
    //   269: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: aload_3
    //   276: invokestatic 48	com/xiaomi/channel/commonutils/file/a:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   279: iload 4
    //   281: iconst_1
    //   282: iadd
    //   283: istore 4
    //   285: goto -58 -> 227
    //   288: aconst_null
    //   289: astore_2
    //   290: aload_2
    //   291: invokestatic 131	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   294: return
    //   295: aload 10
    //   297: astore_2
    //   298: aload 7
    //   300: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   303: ifne +100 -> 403
    //   306: aload 10
    //   308: astore_2
    //   309: aload_0
    //   310: new 104	java/util/zip/ZipEntry
    //   313: dup
    //   314: aload 7
    //   316: invokespecial 110	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   319: invokevirtual 114	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   322: aload 10
    //   324: astore_2
    //   325: new 133	java/io/FileInputStream
    //   328: dup
    //   329: aload_1
    //   330: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   333: astore_1
    //   334: sipush 1024
    //   337: newarray <illegal type>
    //   339: astore_3
    //   340: aload_1
    //   341: aload_3
    //   342: invokevirtual 140	java/io/FileInputStream:read	([B)I
    //   345: istore 4
    //   347: aload_1
    //   348: astore_2
    //   349: iload 4
    //   351: iconst_m1
    //   352: if_icmpeq -62 -> 290
    //   355: aload_0
    //   356: aload_3
    //   357: iconst_0
    //   358: iload 4
    //   360: invokevirtual 144	java/util/zip/ZipOutputStream:write	([BII)V
    //   363: goto -23 -> 340
    //   366: astore_2
    //   367: aload_1
    //   368: astore_0
    //   369: aload_2
    //   370: astore_1
    //   371: aload_0
    //   372: astore_2
    //   373: new 52	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   380: ldc -110
    //   382: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_1
    //   386: invokevirtual 147	java/io/IOException:toString	()Ljava/lang/String;
    //   389: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 150	com/xiaomi/channel/commonutils/logger/b:d	(Ljava/lang/String;)V
    //   398: aload_0
    //   399: invokestatic 131	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   402: return
    //   403: aload 10
    //   405: astore_2
    //   406: new 152	java/util/Date
    //   409: dup
    //   410: invokespecial 153	java/util/Date:<init>	()V
    //   413: astore_3
    //   414: aload 10
    //   416: astore_2
    //   417: aload_0
    //   418: new 104	java/util/zip/ZipEntry
    //   421: dup
    //   422: new 52	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   429: aload_3
    //   430: invokevirtual 157	java/util/Date:getTime	()J
    //   433: invokestatic 161	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   436: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc -93
    //   441: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokespecial 110	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   450: invokevirtual 114	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   453: goto -131 -> 322
    //   456: astore_1
    //   457: aload 9
    //   459: astore_0
    //   460: goto -89 -> 371
    //   463: astore_0
    //   464: aload_2
    //   465: astore_1
    //   466: aload_1
    //   467: invokestatic 131	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   470: aload_0
    //   471: athrow
    //   472: astore_0
    //   473: goto -7 -> 466
    //   476: iconst_0
    //   477: istore 4
    //   479: goto -382 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   0	482	1	paramFile	java.io.File
    //   0	482	2	paramString	String
    //   0	482	3	paramFileFilter	java.io.FileFilter
    //   100	378	4	i	int
    //   7	217	5	j	int
    //   221	11	6	k	int
    //   10	305	7	str	String
    //   42	223	8	arrayOfFile	java.io.File[]
    //   4	454	9	localObject1	Object
    //   1	414	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   334	340	366	java/io/IOException
    //   340	347	366	java/io/IOException
    //   355	363	366	java/io/IOException
    //   23	30	456	java/io/IOException
    //   37	44	456	java/io/IOException
    //   47	79	456	java/io/IOException
    //   82	90	456	java/io/IOException
    //   100	108	456	java/io/IOException
    //   111	147	456	java/io/IOException
    //   159	165	456	java/io/IOException
    //   171	194	456	java/io/IOException
    //   200	212	456	java/io/IOException
    //   219	223	456	java/io/IOException
    //   243	279	456	java/io/IOException
    //   298	306	456	java/io/IOException
    //   309	322	456	java/io/IOException
    //   325	334	456	java/io/IOException
    //   406	414	456	java/io/IOException
    //   417	453	456	java/io/IOException
    //   23	30	463	finally
    //   37	44	463	finally
    //   47	79	463	finally
    //   82	90	463	finally
    //   100	108	463	finally
    //   111	147	463	finally
    //   159	165	463	finally
    //   171	194	463	finally
    //   200	212	463	finally
    //   219	223	463	finally
    //   243	279	463	finally
    //   298	306	463	finally
    //   309	322	463	finally
    //   325	334	463	finally
    //   373	398	463	finally
    //   406	414	463	finally
    //   417	453	463	finally
    //   334	340	472	finally
    //   340	347	472	finally
    //   355	363	472	finally
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).finish();
      ((GZIPOutputStream)localObject).close();
      localObject = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return (byte[])localObject;
    }
    catch (Exception localException) {}
    return paramArrayOfByte;
  }
  
  /* Error */
  public static byte[] b(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 168	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 169	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: sipush 8192
    //   11: newarray <illegal type>
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: iconst_0
    //   17: sipush 8192
    //   20: invokevirtual 189	java/io/InputStream:read	([BII)I
    //   23: istore_1
    //   24: iload_1
    //   25: ifle +28 -> 53
    //   28: aload_2
    //   29: aload_3
    //   30: iconst_0
    //   31: iload_1
    //   32: invokevirtual 190	java/io/ByteArrayOutputStream:write	([BII)V
    //   35: goto -21 -> 14
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   43: aload_0
    //   44: invokestatic 131	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   47: aload_2
    //   48: invokestatic 50	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   51: aconst_null
    //   52: areturn
    //   53: aload_2
    //   54: invokevirtual 183	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore_3
    //   58: aload_0
    //   59: invokestatic 131	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   62: aload_2
    //   63: invokestatic 50	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   66: aload_3
    //   67: areturn
    //   68: astore_3
    //   69: aload_0
    //   70: invokestatic 131	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   73: aload_2
    //   74: invokestatic 50	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/OutputStream;)V
    //   77: aload_3
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramInputStream	InputStream
    //   23	9	1	i	int
    //   7	67	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   13	17	3	arrayOfByte1	byte[]
    //   38	2	3	localException	Exception
    //   57	10	3	arrayOfByte2	byte[]
    //   68	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	24	38	java/lang/Exception
    //   28	35	38	java/lang/Exception
    //   53	58	38	java/lang/Exception
    //   14	24	68	finally
    //   28	35	68	finally
    //   39	43	68	finally
    //   53	58	68	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/file/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */