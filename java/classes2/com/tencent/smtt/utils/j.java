package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;

@SuppressLint({"NewApi"})
public class j
{
  public static String a = null;
  public static final a b = new l();
  private static final int c = "lib/".length();
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l2;
    if (paramInputStream == null)
    {
      l2 = -1L;
      return l2;
    }
    byte[] arrayOfByte = new byte['က'];
    int i;
    for (long l1 = 0L;; l1 += i)
    {
      i = paramInputStream.read(arrayOfByte);
      l2 = l1;
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static ByteArrayOutputStream a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    b(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream;
  }
  
  public static File a()
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      return localFile;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static File a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramContext = d(paramContext);
      if (paramContext != null) {
        break label23;
      }
    }
    label23:
    do
    {
      return null;
      paramContext = c(paramContext);
      break;
      paramContext = new File(paramContext);
      if ((paramContext != null) && (!paramContext.exists())) {
        paramContext.mkdirs();
      }
    } while (!paramContext.canWrite());
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
  }
  
  private static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = paramContext.getApplicationContext();
    try
    {
      String str = paramContext.getExternalFilesDir(paramString).getAbsolutePath();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      try
      {
        paramContext = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getApplicationInfo().packageName + File.separator + "files" + File.separator + paramString;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramContext == null) {
      str = "";
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return str;
                  try
                  {
                    localObject2 = Environment.getExternalStorageDirectory() + File.separator;
                    switch (paramInt)
                    {
                    default: 
                      return "";
                    }
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      localException.printStackTrace();
                      localObject2 = "";
                    }
                    localObject1 = localObject2;
                  }
                } while (((String)localObject2).equals(""));
                return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
                localObject1 = localObject2;
              } while (((String)localObject2).equals(""));
              return (String)localObject2 + "tbs" + File.separator + "backup" + File.separator + paramString;
              localObject1 = localObject2;
            } while (((String)localObject2).equals(""));
            return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
            if (((String)localObject2).equals("")) {
              return a(paramContext, "backup");
            }
            paramString = (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
            localObject1 = paramString;
          } while (!paramBoolean);
          localObject2 = new File(paramString);
          if (!((File)localObject2).exists()) {
            break;
          }
          localObject1 = paramString;
        } while (((File)localObject2).canWrite());
        if (((File)localObject2).exists()) {
          break;
        }
        ((File)localObject2).mkdirs();
        localObject1 = paramString;
      } while (((File)localObject2).canWrite());
      return a(paramContext, "backup");
      return a(paramContext, "backup");
      Object localObject1 = localObject2;
    } while (((String)localObject2).equals(""));
    return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
    if (a != null) {
      return a;
    }
    a = a(paramContext, "tbslog");
    return a;
  }
  
  /* Error */
  public static FileLock a(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokevirtual 181	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   10: invokevirtual 187	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 192	java/nio/channels/FileLock:isValid	()Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +65 -> 85
    //   23: aload_1
    //   24: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 196	java/nio/channels/OverlappingFileLockException:printStackTrace	()V
    //   34: aload_1
    //   35: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   52: aload_1
    //   53: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_0
    //   59: goto -18 -> 41
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   67: aload_0
    //   68: athrow
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   74: goto -7 -> 67
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   82: goto -55 -> 27
    //   85: aload_1
    //   86: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: goto -51 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   0	95	1	paramFileOutputStream	FileOutputStream
    //   18	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	19	29	java/nio/channels/OverlappingFileLockException
    //   34	38	40	java/lang/Exception
    //   6	19	47	java/lang/Exception
    //   52	56	58	java/lang/Exception
    //   6	19	62	finally
    //   30	34	62	finally
    //   48	52	62	finally
    //   63	67	69	java/lang/Exception
    //   23	27	77	java/lang/Exception
    //   85	89	91	java/lang/Exception
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void a(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    if (paramFileLock != null) {}
    try
    {
      paramFileLock.release();
      if (paramFileOutputStream == null) {}
    }
    catch (Exception paramFileLock)
    {
      for (;;)
      {
        try
        {
          paramFileOutputStream.close();
          return;
        }
        catch (Exception paramFileLock)
        {
          paramFileLock.printStackTrace();
        }
        paramFileLock = paramFileLock;
        paramFileLock.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    do
    {
      return true;
      if (paramContext == null) {
        break;
      }
    } while (paramContext.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
    return false;
    return false;
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      return true;
    }
    b(paramFile);
    return paramFile.mkdirs();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.getPath(), paramFile2.getPath());
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return a(paramFile1, paramFile2, paramFileFilter, b);
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return b(paramFile1, paramFile2, paramFileFilter, parama);
      }
      paramFile1 = paramFile1.listFiles();
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    while (i < j)
    {
      parama = paramFile1[i];
      if (!a(parama, new File(paramFile2, parama.getName()), paramFileFilter)) {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    paramString = new File(paramString);
    if (paramString.length() != paramLong1) {
      TbsLog.e("FileHelper", "file size doesn't match: " + paramString.length() + " vs " + paramLong1);
    }
    label123:
    do
    {
      return true;
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        try
        {
          localCRC32 = new CRC32();
          byte[] arrayOfByte = new byte[' '];
          for (;;)
          {
            int i = localFileInputStream.read(arrayOfByte);
            if (i <= 0) {
              break;
            }
            localCRC32.update(arrayOfByte, 0, i);
          }
          if (localFileInputStream == null) {
            break label123;
          }
        }
        finally {}
      }
      finally
      {
        for (;;)
        {
          CRC32 localCRC32;
          FileInputStream localFileInputStream = null;
        }
      }
      localFileInputStream.close();
      throw paramString;
      paramLong1 = localCRC32.getValue();
      TbsLog.i("FileHelper", "" + paramString.getName() + ": crc = " + paramLong1 + ", zipCrc = " + paramLong3);
      if (paramLong1 == paramLong3) {
        break;
      }
    } while (localFileInputStream == null);
    localFileInputStream.close();
    return true;
    if (localFileInputStream != null) {
      localFileInputStream.close();
    }
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a(String paramString1, String paramString2)
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null) {
      return a(paramString1, paramString2, str2, str1, q.a("ro.product.cpu.upgradeabi", "armeabi"));
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, b paramb)
  {
    // Byte code:
    //   0: new 319	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 320	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: iconst_0
    //   10: istore 6
    //   12: iconst_0
    //   13: istore 5
    //   15: aload_0
    //   16: invokevirtual 324	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   19: astore 10
    //   21: aload 10
    //   23: invokeinterface 329 1 0
    //   28: ifeq +320 -> 348
    //   31: aload 10
    //   33: invokeinterface 333 1 0
    //   38: checkcast 335	java/util/zip/ZipEntry
    //   41: astore 11
    //   43: aload 11
    //   45: invokevirtual 336	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   48: astore 13
    //   50: aload 13
    //   52: ifnull -31 -> 21
    //   55: aload 13
    //   57: ldc 21
    //   59: invokevirtual 340	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifne +14 -> 76
    //   65: aload 13
    //   67: ldc_w 342
    //   70: invokevirtual 340	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   73: ifeq -52 -> 21
    //   76: aload 13
    //   78: aload 13
    //   80: bipush 47
    //   82: invokevirtual 346	java/lang/String:lastIndexOf	(I)I
    //   85: invokevirtual 350	java/lang/String:substring	(I)Ljava/lang/String;
    //   88: astore 12
    //   90: iload 5
    //   92: istore 7
    //   94: iload 6
    //   96: istore 8
    //   98: aload 12
    //   100: ldc_w 352
    //   103: invokevirtual 355	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   106: ifeq +45 -> 151
    //   109: aload 13
    //   111: getstatic 29	com/tencent/smtt/utils/j:c	I
    //   114: aload_1
    //   115: iconst_0
    //   116: aload_1
    //   117: invokevirtual 27	java/lang/String:length	()I
    //   120: invokevirtual 359	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   123: ifeq +80 -> 203
    //   126: aload 13
    //   128: getstatic 29	com/tencent/smtt/utils/j:c	I
    //   131: aload_1
    //   132: invokevirtual 27	java/lang/String:length	()I
    //   135: iadd
    //   136: invokevirtual 363	java/lang/String:charAt	(I)C
    //   139: bipush 47
    //   141: if_icmpne +62 -> 203
    //   144: iconst_1
    //   145: istore 8
    //   147: iload 5
    //   149: istore 7
    //   151: aload_0
    //   152: aload 11
    //   154: invokevirtual 367	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   157: astore 13
    //   159: aload 4
    //   161: aload 13
    //   163: aload 11
    //   165: aload 12
    //   167: iconst_1
    //   168: invokevirtual 350	java/lang/String:substring	(I)Ljava/lang/String;
    //   171: invokeinterface 370 4 0
    //   176: istore 9
    //   178: iload 9
    //   180: ifne +178 -> 358
    //   183: aload 13
    //   185: ifnull +8 -> 193
    //   188: aload 13
    //   190: invokevirtual 371	java/io/InputStream:close	()V
    //   193: aload_0
    //   194: ifnull +7 -> 201
    //   197: aload_0
    //   198: invokevirtual 372	java/util/zip/ZipFile:close	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: aload_2
    //   204: ifnull +56 -> 260
    //   207: aload 13
    //   209: getstatic 29	com/tencent/smtt/utils/j:c	I
    //   212: aload_2
    //   213: iconst_0
    //   214: aload_2
    //   215: invokevirtual 27	java/lang/String:length	()I
    //   218: invokevirtual 359	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   221: ifeq +39 -> 260
    //   224: aload 13
    //   226: getstatic 29	com/tencent/smtt/utils/j:c	I
    //   229: aload_2
    //   230: invokevirtual 27	java/lang/String:length	()I
    //   233: iadd
    //   234: invokevirtual 363	java/lang/String:charAt	(I)C
    //   237: bipush 47
    //   239: if_icmpne +21 -> 260
    //   242: iconst_1
    //   243: istore 7
    //   245: iconst_1
    //   246: istore 5
    //   248: iload 6
    //   250: istore 8
    //   252: iload 6
    //   254: ifeq -103 -> 151
    //   257: goto -236 -> 21
    //   260: aload_3
    //   261: ifnull -240 -> 21
    //   264: aload 13
    //   266: getstatic 29	com/tencent/smtt/utils/j:c	I
    //   269: aload_3
    //   270: iconst_0
    //   271: aload_3
    //   272: invokevirtual 27	java/lang/String:length	()I
    //   275: invokevirtual 359	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   278: ifeq -257 -> 21
    //   281: aload 13
    //   283: getstatic 29	com/tencent/smtt/utils/j:c	I
    //   286: aload_3
    //   287: invokevirtual 27	java/lang/String:length	()I
    //   290: iadd
    //   291: invokevirtual 363	java/lang/String:charAt	(I)C
    //   294: bipush 47
    //   296: if_icmpne -275 -> 21
    //   299: iload 6
    //   301: ifne -280 -> 21
    //   304: iload 5
    //   306: istore 7
    //   308: iload 6
    //   310: istore 8
    //   312: iload 5
    //   314: ifeq -163 -> 151
    //   317: goto -296 -> 21
    //   320: astore_1
    //   321: aload 13
    //   323: ifnull +8 -> 331
    //   326: aload 13
    //   328: invokevirtual 371	java/io/InputStream:close	()V
    //   331: aload_1
    //   332: athrow
    //   333: astore_2
    //   334: aload_0
    //   335: astore_1
    //   336: aload_2
    //   337: astore_0
    //   338: aload_1
    //   339: ifnull +7 -> 346
    //   342: aload_1
    //   343: invokevirtual 372	java/util/zip/ZipFile:close	()V
    //   346: aload_0
    //   347: athrow
    //   348: aload_0
    //   349: ifnull +7 -> 356
    //   352: aload_0
    //   353: invokevirtual 372	java/util/zip/ZipFile:close	()V
    //   356: iconst_1
    //   357: ireturn
    //   358: iload 7
    //   360: istore 5
    //   362: iload 8
    //   364: istore 6
    //   366: aload 13
    //   368: ifnull -347 -> 21
    //   371: aload 13
    //   373: invokevirtual 371	java/io/InputStream:close	()V
    //   376: iload 7
    //   378: istore 5
    //   380: iload 8
    //   382: istore 6
    //   384: goto -363 -> 21
    //   387: astore_0
    //   388: aconst_null
    //   389: astore_1
    //   390: goto -52 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramString1	String
    //   0	393	1	paramString2	String
    //   0	393	2	paramString3	String
    //   0	393	3	paramString4	String
    //   0	393	4	paramb	b
    //   13	366	5	i	int
    //   10	373	6	j	int
    //   92	285	7	k	int
    //   96	285	8	m	int
    //   176	3	9	bool	boolean
    //   19	13	10	localEnumeration	java.util.Enumeration
    //   41	123	11	localZipEntry	ZipEntry
    //   88	78	12	str	String
    //   48	324	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   159	178	320	finally
    //   15	21	333	finally
    //   21	50	333	finally
    //   55	76	333	finally
    //   76	90	333	finally
    //   98	144	333	finally
    //   151	159	333	finally
    //   188	193	333	finally
    //   207	242	333	finally
    //   264	299	333	finally
    //   326	331	333	finally
    //   331	333	333	finally
    //   371	376	333	finally
    //   0	9	387	finally
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return a(paramString1, paramString3, paramString4, paramString5, new k(paramString2));
  }
  
  public static int b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = a(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static FileOutputStream b(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = a(paramContext, paramBoolean, paramString);
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static void b(File paramFile)
  {
    a(paramFile, false);
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    long l = z.a();
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + l);
      }
      return bool;
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, null);
  }
  
  /* Error */
  private static boolean b(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnull +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_2
    //   14: ifnull +15 -> 29
    //   17: aload_2
    //   18: aload_0
    //   19: invokeinterface 415 2 0
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokevirtual 90	java/io/File:exists	()Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 200	java/io/File:isFile	()Z
    //   40: istore 6
    //   42: iload 6
    //   44: ifne +29 -> 73
    //   47: iconst_0
    //   48: ifeq +11 -> 59
    //   51: new 417	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 418	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: iconst_0
    //   60: ifeq +11 -> 71
    //   63: new 417	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 418	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_1
    //   74: invokevirtual 90	java/io/File:exists	()Z
    //   77: ifeq +52 -> 129
    //   80: aload_3
    //   81: ifnull +44 -> 125
    //   84: aload_3
    //   85: aload_0
    //   86: aload_1
    //   87: invokeinterface 420 3 0
    //   92: istore 6
    //   94: iload 6
    //   96: ifeq +29 -> 125
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 417	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 418	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 417	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 418	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: iconst_1
    //   124: ireturn
    //   125: aload_1
    //   126: invokestatic 232	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   129: aload_1
    //   130: invokevirtual 423	java/io/File:getParentFile	()Ljava/io/File;
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 200	java/io/File:isFile	()Z
    //   138: ifeq +7 -> 145
    //   141: aload_2
    //   142: invokestatic 232	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   145: aload_2
    //   146: invokevirtual 90	java/io/File:exists	()Z
    //   149: ifne +40 -> 189
    //   152: aload_2
    //   153: invokevirtual 93	java/io/File:mkdirs	()Z
    //   156: istore 6
    //   158: iload 6
    //   160: ifne +29 -> 189
    //   163: iconst_0
    //   164: ifeq +11 -> 175
    //   167: new 417	java/lang/NullPointerException
    //   170: dup
    //   171: invokespecial 418	java/lang/NullPointerException:<init>	()V
    //   174: athrow
    //   175: iconst_0
    //   176: ifeq +11 -> 187
    //   179: new 417	java/lang/NullPointerException
    //   182: dup
    //   183: invokespecial 418	java/lang/NullPointerException:<init>	()V
    //   186: athrow
    //   187: iconst_0
    //   188: ireturn
    //   189: new 274	java/io/FileInputStream
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 276	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokevirtual 424	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   200: astore_2
    //   201: new 177	java/io/FileOutputStream
    //   204: dup
    //   205: aload_1
    //   206: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: invokevirtual 181	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   212: astore_3
    //   213: aload_2
    //   214: invokevirtual 427	java/nio/channels/FileChannel:size	()J
    //   217: lstore 4
    //   219: aload_3
    //   220: aload_2
    //   221: lconst_0
    //   222: lload 4
    //   224: invokevirtual 431	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   227: lload 4
    //   229: lcmp
    //   230: ifeq +49 -> 279
    //   233: aload_1
    //   234: invokestatic 232	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 432	java/nio/channels/FileChannel:close	()V
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 432	java/nio/channels/FileChannel:close	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: aload 7
    //   260: astore_2
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 432	java/nio/channels/FileChannel:close	()V
    //   269: aload_1
    //   270: ifnull +7 -> 277
    //   273: aload_1
    //   274: invokevirtual 432	java/nio/channels/FileChannel:close	()V
    //   277: aload_0
    //   278: athrow
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 432	java/nio/channels/FileChannel:close	()V
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 432	java/nio/channels/FileChannel:close	()V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: aload_3
    //   305: astore_1
    //   306: goto -45 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramFile1	File
    //   0	309	1	paramFile2	File
    //   0	309	2	paramFileFilter	FileFilter
    //   0	309	3	parama	a
    //   217	11	4	l	long
    //   40	119	6	bool	boolean
    //   1	258	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	42	255	finally
    //   73	80	255	finally
    //   84	94	255	finally
    //   125	129	255	finally
    //   129	145	255	finally
    //   145	158	255	finally
    //   189	201	255	finally
    //   201	213	297	finally
    //   213	237	303	finally
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean b(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 83	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 434	com/tencent/smtt/utils/j:a	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 138	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 146	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 83	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: new 177	java/io/FileOutputStream
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: sipush 8192
    //   60: newarray <illegal type>
    //   62: astore 6
    //   64: aload_0
    //   65: aload 6
    //   67: invokevirtual 48	java/io/InputStream:read	([B)I
    //   70: istore 4
    //   72: iload 4
    //   74: ifle +66 -> 140
    //   77: aload_2
    //   78: aload 6
    //   80: iconst_0
    //   81: iload 4
    //   83: invokevirtual 435	java/io/FileOutputStream:write	([BII)V
    //   86: goto -22 -> 64
    //   89: astore_1
    //   90: aload_2
    //   91: astore_0
    //   92: aload_3
    //   93: invokestatic 232	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   96: new 75	java/io/IOException
    //   99: dup
    //   100: new 138	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 437
    //   110: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_1
    //   121: invokespecial 440	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: athrow
    //   125: astore_2
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: astore_0
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   138: aload_0
    //   139: athrow
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   148: aload 5
    //   150: aload_1
    //   151: invokevirtual 443	java/util/zip/ZipEntry:getSize	()J
    //   154: aload_1
    //   155: invokevirtual 446	java/util/zip/ZipEntry:getTime	()J
    //   158: aload_1
    //   159: invokevirtual 449	java/util/zip/ZipEntry:getCrc	()J
    //   162: invokestatic 451	com/tencent/smtt/utils/j:a	(Ljava/lang/String;JJJ)Z
    //   165: ifeq +32 -> 197
    //   168: ldc_w 259
    //   171: new 138	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 453
    //   181: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 5
    //   186: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 272	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: iconst_0
    //   196: ireturn
    //   197: aload_3
    //   198: aload_1
    //   199: invokevirtual 446	java/util/zip/ZipEntry:getTime	()J
    //   202: invokevirtual 457	java/io/File:setLastModified	(J)Z
    //   205: ifne +29 -> 234
    //   208: ldc_w 259
    //   211: new 138	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 459
    //   221: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_3
    //   225: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 272	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: iconst_1
    //   235: ireturn
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -109 -> 130
    //   242: astore_0
    //   243: aload_2
    //   244: astore_1
    //   245: goto -115 -> 130
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -159 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramInputStream	InputStream
    //   0	254	1	paramZipEntry	ZipEntry
    //   0	254	2	paramString1	String
    //   0	254	3	paramString2	String
    //   70	12	4	i	int
    //   36	149	5	str	String
    //   62	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	64	89	java/io/IOException
    //   64	72	89	java/io/IOException
    //   77	86	89	java/io/IOException
    //   92	125	125	finally
    //   48	57	236	finally
    //   57	64	242	finally
    //   64	72	242	finally
    //   77	86	242	finally
    //   48	57	248	java/io/IOException
  }
  
  public static byte[] b(InputStream paramInputStream)
  {
    return a(paramInputStream).toByteArray();
  }
  
  public static File c()
  {
    File localFile = new File(a().getAbsolutePath() + "/" + ".tbs");
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static String c(Context paramContext)
  {
    return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
  }
  
  public static boolean c(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static FileOutputStream d(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("File '" + paramFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  static String d(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static abstract interface a
  {
    public abstract boolean a(File paramFile1, File paramFile2);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */