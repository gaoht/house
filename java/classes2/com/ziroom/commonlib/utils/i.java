package com.ziroom.commonlib.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class i
{
  private static File a(String paramString)
  {
    if (r.isNull(paramString)) {
      return null;
    }
    return new File(paramString);
  }
  
  private static String a(long paramLong)
  {
    if (paramLong < 0L) {
      return "shouldn't be less than zero!";
    }
    if (paramLong < 1024L) {
      return String.format(Locale.getDefault(), "%.3fB", new Object[] { Double.valueOf(paramLong) });
    }
    if (paramLong < 1048576L) {
      return String.format(Locale.getDefault(), "%.3fKB", new Object[] { Double.valueOf(paramLong / 1024.0D) });
    }
    if (paramLong < 1073741824L) {
      return String.format(Locale.getDefault(), "%.3fMB", new Object[] { Double.valueOf(paramLong / 1048576.0D) });
    }
    return String.format(Locale.getDefault(), "%.3fGB", new Object[] { Double.valueOf(paramLong / 1.073741824E9D) });
  }
  
  private static boolean a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {
      return new File(Environment.getExternalStorageDirectory().getPath()).canWrite();
    }
    return false;
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    return b(paramInputStream).toByteArray();
  }
  
  /* Error */
  private static ByteArrayOutputStream b(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 93	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 100	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: sipush 1024
    //   17: newarray <illegal type>
    //   19: astore_3
    //   20: aload_0
    //   21: aload_3
    //   22: iconst_0
    //   23: sipush 1024
    //   26: invokevirtual 106	java/io/InputStream:read	([BII)I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +31 -> 63
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_1
    //   39: invokevirtual 110	java/io/ByteArrayOutputStream:write	([BII)V
    //   42: goto -22 -> 20
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   50: iconst_1
    //   51: anewarray 115	java/io/Closeable
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   61: aconst_null
    //   62: areturn
    //   63: iconst_1
    //   64: anewarray 115	java/io/Closeable
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: aastore
    //   71: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   74: aload_2
    //   75: areturn
    //   76: astore_2
    //   77: iconst_1
    //   78: anewarray 115	java/io/Closeable
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: aastore
    //   85: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
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
  
  private static String b()
  {
    if (!"mounted".equals(Environment.getExternalStorageState())) {
      return "sdcard unable!";
    }
    return Environment.getExternalStorageDirectory().getPath() + File.separator;
  }
  
  public static void closeIO(Closeable... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      try
      {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          Closeable localCloseable = paramVarArgs[i];
          if (localCloseable != null) {
            localCloseable.close();
          }
          i += 1;
        }
        return;
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  public static boolean copyOrMoveFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    for (;;)
    {
      return false;
      if ((paramFile1.exists()) && (paramFile1.isFile()) && ((!paramFile2.exists()) || (!paramFile2.isFile())) && (createOrExistsDir(paramFile2.getParentFile()))) {
        try
        {
          if (writeFileFromIS(paramFile2, new FileInputStream(paramFile1), false)) {
            if (paramBoolean)
            {
              paramBoolean = deleteFile(paramFile1);
              if (!paramBoolean) {}
            }
            else
            {
              return true;
            }
          }
        }
        catch (FileNotFoundException paramFile1)
        {
          paramFile1.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public static boolean copyOrMoveFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    return copyOrMoveFile(a(paramString1), a(paramString2), paramBoolean);
  }
  
  public static boolean createOrExistsDir(File paramFile)
  {
    if (paramFile != null) {
      if (paramFile.exists())
      {
        if (!paramFile.isDirectory()) {}
      }
      else {
        while (paramFile.mkdirs()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean createOrExistsFile(File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      return false;
      if (paramFile.exists()) {
        return paramFile.isFile();
      }
    } while (!createOrExistsDir(paramFile.getParentFile()));
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  public static boolean createOrExistsFile(String paramString)
  {
    return createOrExistsFile(a(paramString));
  }
  
  public static boolean delAllFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return true;
    }
    File[] arrayOfFile = paramString.listFiles();
    int i = 0;
    if (i < arrayOfFile.length)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isDirectory()) {
        delAllFile(localFile.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    paramString.delete();
    return false;
  }
  
  public static boolean deleteDir(File paramFile)
  {
    if (paramFile == null) {}
    int i;
    File localFile;
    do
    {
      do
      {
        return false;
        if (!paramFile.exists()) {
          return true;
        }
      } while (!paramFile.isDirectory());
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      i = 0;
      if (i >= j) {
        break label83;
      }
      localFile = arrayOfFile[i];
      if (!localFile.isFile()) {
        break;
      }
    } while (!deleteFile(localFile));
    while ((!localFile.isDirectory()) || (deleteDir(localFile)))
    {
      i += 1;
      break;
    }
    return false;
    label83:
    return paramFile.delete();
  }
  
  public static boolean deleteFile(File paramFile)
  {
    return (paramFile != null) && ((!paramFile.exists()) || ((paramFile.isFile()) && (paramFile.delete())));
  }
  
  public static boolean deleteFilesInDir(File paramFile)
  {
    if (paramFile == null) {}
    int i;
    File localFile;
    do
    {
      do
      {
        return false;
        if (!paramFile.exists()) {
          return true;
        }
      } while (!paramFile.isDirectory());
      paramFile = paramFile.listFiles();
      if ((paramFile == null) || (paramFile.length == 0)) {
        break label87;
      }
      int j = paramFile.length;
      i = 0;
      if (i >= j) {
        break label87;
      }
      localFile = paramFile[i];
      if (!localFile.isFile()) {
        break;
      }
    } while (!deleteFile(localFile));
    while ((!localFile.isDirectory()) || (deleteDir(localFile)))
    {
      i += 1;
      break;
    }
    return false;
    label87:
    return true;
  }
  
  public static boolean deleteFilesInDir(String paramString)
  {
    return deleteFilesInDir(a(paramString));
  }
  
  public static String getDiskCacheDir(Context paramContext)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable())) {
      return paramContext.getExternalCacheDir().getPath();
    }
    return paramContext.getCacheDir().getPath();
  }
  
  /* Error */
  public static int getFileLines(File paramFile)
  {
    // Byte code:
    //   0: new 221	java/io/BufferedInputStream
    //   3: dup
    //   4: new 157	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 224	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 7
    //   17: aload 7
    //   19: astore_0
    //   20: sipush 1024
    //   23: newarray <illegal type>
    //   25: astore 6
    //   27: iconst_1
    //   28: istore_1
    //   29: aload 7
    //   31: astore_0
    //   32: aload 7
    //   34: aload 6
    //   36: iconst_0
    //   37: sipush 1024
    //   40: invokevirtual 106	java/io/InputStream:read	([BII)I
    //   43: istore 4
    //   45: iload 4
    //   47: iconst_m1
    //   48: if_icmpeq +43 -> 91
    //   51: iconst_0
    //   52: istore_3
    //   53: iload_1
    //   54: istore_2
    //   55: iload_2
    //   56: istore_1
    //   57: iload_3
    //   58: iload 4
    //   60: if_icmpge -31 -> 29
    //   63: aload 6
    //   65: iload_3
    //   66: baload
    //   67: istore 5
    //   69: iload_2
    //   70: istore_1
    //   71: iload 5
    //   73: bipush 10
    //   75: if_icmpne +7 -> 82
    //   78: iload_2
    //   79: iconst_1
    //   80: iadd
    //   81: istore_1
    //   82: iload_3
    //   83: iconst_1
    //   84: iadd
    //   85: istore_3
    //   86: iload_1
    //   87: istore_2
    //   88: goto -33 -> 55
    //   91: iconst_1
    //   92: anewarray 115	java/io/Closeable
    //   95: dup
    //   96: iconst_0
    //   97: aload 7
    //   99: aastore
    //   100: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   103: iload_1
    //   104: ireturn
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 7
    //   110: iconst_1
    //   111: istore_1
    //   112: aload 7
    //   114: astore_0
    //   115: aload 6
    //   117: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   120: iconst_1
    //   121: anewarray 115	java/io/Closeable
    //   124: dup
    //   125: iconst_0
    //   126: aload 7
    //   128: aastore
    //   129: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   132: iload_1
    //   133: ireturn
    //   134: astore 6
    //   136: aconst_null
    //   137: astore_0
    //   138: iconst_1
    //   139: anewarray 115	java/io/Closeable
    //   142: dup
    //   143: iconst_0
    //   144: aload_0
    //   145: aastore
    //   146: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   149: aload 6
    //   151: athrow
    //   152: astore 6
    //   154: goto -16 -> 138
    //   157: astore 6
    //   159: iconst_1
    //   160: istore_1
    //   161: goto -49 -> 112
    //   164: astore 6
    //   166: goto -54 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramFile	File
    //   28	133	1	i	int
    //   54	34	2	j	int
    //   52	34	3	k	int
    //   43	18	4	m	int
    //   67	9	5	n	int
    //   25	39	6	arrayOfByte	byte[]
    //   105	11	6	localIOException1	IOException
    //   134	16	6	localObject1	Object
    //   152	1	6	localObject2	Object
    //   157	1	6	localIOException2	IOException
    //   164	1	6	localIOException3	IOException
    //   15	112	7	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   0	17	105	java/io/IOException
    //   0	17	134	finally
    //   20	27	152	finally
    //   32	45	152	finally
    //   115	120	152	finally
    //   20	27	157	java/io/IOException
    //   32	45	164	java/io/IOException
  }
  
  public static int getFileLines(String paramString)
  {
    return getFileLines(a(paramString));
  }
  
  public static String getFileSize(File paramFile)
  {
    if (!isFileExists(paramFile)) {
      return "";
    }
    return a(paramFile.length());
  }
  
  public static String getFileSize(String paramString)
  {
    return getFileSize(a(paramString));
  }
  
  @TargetApi(18)
  public static String getFreeSpace()
  {
    if (!"mounted".equals(Environment.getExternalStorageState())) {
      return "sdcard unable!";
    }
    StatFs localStatFs = new StatFs(b());
    long l = localStatFs.getAvailableBlocksLong();
    return a(localStatFs.getBlockSizeLong() * l);
  }
  
  public static File getRootPath()
  {
    if (a()) {
      return Environment.getExternalStorageDirectory();
    }
    return Environment.getDataDirectory();
  }
  
  public static boolean isDir(File paramFile)
  {
    return (isFileExists(paramFile)) && (paramFile.isDirectory());
  }
  
  public static boolean isFileExists(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists());
  }
  
  public static List<File> listFilesInDir(File paramFile)
  {
    if ((paramFile == null) || (!isDir(paramFile)))
    {
      paramFile = null;
      return paramFile;
    }
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = paramFile.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      paramFile = localArrayList;
      if (i >= j) {
        break;
      }
      paramFile = arrayOfFile[i];
      localArrayList.add(paramFile);
      if (paramFile.isDirectory()) {
        localArrayList.addAll(listFilesInDir(paramFile));
      }
      i += 1;
    }
  }
  
  public static List<File> listFilesInDir(File paramFile, boolean paramBoolean)
  {
    if (paramBoolean) {
      return listFilesInDir(paramFile);
    }
    if ((paramFile == null) || (!isDir(paramFile))) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramFile.listFiles());
    return localArrayList;
  }
  
  public static List<File> listFilesInDir(String paramString, boolean paramBoolean)
  {
    return listFilesInDir(a(paramString), paramBoolean);
  }
  
  public static List<File> listFilesInDirWithFilter(File paramFile, FilenameFilter paramFilenameFilter)
  {
    if ((paramFile == null) || (!isDir(paramFile)))
    {
      paramFile = null;
      return paramFile;
    }
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = paramFile.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      paramFile = localArrayList;
      if (i >= j) {
        break;
      }
      paramFile = arrayOfFile[i];
      if (paramFilenameFilter.accept(paramFile.getParentFile(), paramFile.getName())) {
        localArrayList.add(paramFile);
      }
      if (paramFile.isDirectory()) {
        localArrayList.addAll(listFilesInDirWithFilter(paramFile, paramFilenameFilter));
      }
      i += 1;
    }
  }
  
  public static List<File> listFilesInDirWithFilter(String paramString, FilenameFilter paramFilenameFilter)
  {
    return listFilesInDirWithFilter(a(paramString), paramFilenameFilter);
  }
  
  public static byte[] readFile2Bytes(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = a(new FileInputStream(paramFile));
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }
  
  public static byte[] readFile2Bytes(String paramString)
  {
    return readFile2Bytes(a(paramString));
  }
  
  /* Error */
  public static List<String> readFile2List(File paramFile, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: iload_1
    //   7: iload_2
    //   8: if_icmpgt -4 -> 4
    //   11: new 272	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 273	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_3
    //   21: invokestatic 17	com/ziroom/commonlib/utils/r:isNull	(Ljava/lang/String;)Z
    //   24: ifeq +55 -> 79
    //   27: new 324	java/io/BufferedReader
    //   30: dup
    //   31: new 326	java/io/FileReader
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 327	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   39: invokespecial 330	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_0
    //   43: iconst_1
    //   44: istore 4
    //   46: aload_0
    //   47: astore_3
    //   48: aload_0
    //   49: invokevirtual 333	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull +9 -> 65
    //   59: iload 4
    //   61: iload_2
    //   62: if_icmple +47 -> 109
    //   65: iconst_1
    //   66: anewarray 115	java/io/Closeable
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: aastore
    //   73: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   76: aload 5
    //   78: areturn
    //   79: new 324	java/io/BufferedReader
    //   82: dup
    //   83: new 335	java/io/InputStreamReader
    //   86: dup
    //   87: new 157	java/io/FileInputStream
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: aload_3
    //   96: invokespecial 338	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   99: invokespecial 330	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore_0
    //   103: iconst_1
    //   104: istore 4
    //   106: goto -60 -> 46
    //   109: iload_1
    //   110: iload 4
    //   112: if_icmpgt +21 -> 133
    //   115: iload 4
    //   117: iload_2
    //   118: if_icmpgt +15 -> 133
    //   121: aload_0
    //   122: astore_3
    //   123: aload 5
    //   125: aload 6
    //   127: invokeinterface 278 2 0
    //   132: pop
    //   133: iload 4
    //   135: iconst_1
    //   136: iadd
    //   137: istore 4
    //   139: goto -93 -> 46
    //   142: astore 5
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: astore_3
    //   148: aload 5
    //   150: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   153: iconst_1
    //   154: anewarray 115	java/io/Closeable
    //   157: dup
    //   158: iconst_0
    //   159: aload_0
    //   160: aastore
    //   161: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_3
    //   169: iconst_1
    //   170: anewarray 115	java/io/Closeable
    //   173: dup
    //   174: iconst_0
    //   175: aload_3
    //   176: aastore
    //   177: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   180: aload_0
    //   181: athrow
    //   182: astore_0
    //   183: goto -14 -> 169
    //   186: astore 5
    //   188: goto -42 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramFile	File
    //   0	191	1	paramInt1	int
    //   0	191	2	paramInt2	int
    //   0	191	3	paramString	String
    //   44	94	4	i	int
    //   18	106	5	localArrayList	ArrayList
    //   142	7	5	localIOException1	IOException
    //   186	1	5	localIOException2	IOException
    //   52	74	6	str	String
    // Exception table:
    //   from	to	target	type
    //   11	43	142	java/io/IOException
    //   79	103	142	java/io/IOException
    //   11	43	166	finally
    //   79	103	166	finally
    //   48	54	182	finally
    //   123	133	182	finally
    //   148	153	182	finally
    //   48	54	186	java/io/IOException
    //   123	133	186	java/io/IOException
  }
  
  public static List<String> readFile2List(File paramFile, String paramString)
  {
    return readFile2List(paramFile, 0, Integer.MAX_VALUE, paramString);
  }
  
  public static List<String> readFile2List(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return readFile2List(a(paramString1), paramInt1, paramInt2, paramString2);
  }
  
  public static List<String> readFile2List(String paramString1, String paramString2)
  {
    return readFile2List(a(paramString1), paramString2);
  }
  
  /* Error */
  public static String readFile2String(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 123	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_1
    //   15: invokestatic 17	com/ziroom/commonlib/utils/r:isNull	(Ljava/lang/String;)Z
    //   18: ifeq +74 -> 92
    //   21: new 324	java/io/BufferedReader
    //   24: dup
    //   25: new 335	java/io/InputStreamReader
    //   28: dup
    //   29: new 157	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 353	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: invokespecial 330	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_0
    //   44: aload_0
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 333	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +73 -> 125
    //   55: aload_0
    //   56: astore_1
    //   57: aload_2
    //   58: aload_3
    //   59: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 355
    //   65: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -25 -> 44
    //   72: astore_2
    //   73: aload_0
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   79: iconst_1
    //   80: anewarray 115	java/io/Closeable
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: aastore
    //   87: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   90: aconst_null
    //   91: areturn
    //   92: new 324	java/io/BufferedReader
    //   95: dup
    //   96: new 335	java/io/InputStreamReader
    //   99: dup
    //   100: new 157	java/io/FileInputStream
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   108: aload_1
    //   109: invokespecial 338	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   112: invokespecial 330	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   115: astore_0
    //   116: goto -72 -> 44
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_0
    //   122: goto -49 -> 73
    //   125: aload_0
    //   126: astore_1
    //   127: aload_2
    //   128: aload_2
    //   129: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   132: iconst_2
    //   133: isub
    //   134: aload_2
    //   135: invokevirtual 358	java/lang/StringBuilder:length	()I
    //   138: invokevirtual 361	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   141: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_2
    //   145: iconst_1
    //   146: anewarray 115	java/io/Closeable
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: aastore
    //   153: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   156: aload_2
    //   157: areturn
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_1
    //   161: iconst_1
    //   162: anewarray 115	java/io/Closeable
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: aastore
    //   169: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   172: aload_0
    //   173: athrow
    //   174: astore_0
    //   175: goto -14 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramFile	File
    //   0	178	1	paramString	String
    //   13	45	2	localStringBuilder	StringBuilder
    //   72	4	2	localIOException1	IOException
    //   119	16	2	localIOException2	IOException
    //   144	13	2	str1	String
    //   50	9	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   46	51	72	java/io/IOException
    //   57	69	72	java/io/IOException
    //   127	145	72	java/io/IOException
    //   6	44	119	java/io/IOException
    //   92	116	119	java/io/IOException
    //   6	44	158	finally
    //   92	116	158	finally
    //   46	51	174	finally
    //   57	69	174	finally
    //   75	79	174	finally
    //   127	145	174	finally
  }
  
  public static String readFile2String(String paramString1, String paramString2)
  {
    return readFile2String(a(paramString1), paramString2);
  }
  
  /* Error */
  public static boolean writeFileFromIS(File paramFile, InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: invokestatic 185	com/ziroom/commonlib/utils/i:createOrExistsFile	(Ljava/io/File;)Z
    //   14: ifeq -6 -> 8
    //   17: new 366	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 368	java/io/FileOutputStream
    //   24: dup
    //   25: aload_0
    //   26: iload_2
    //   27: invokespecial 371	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   30: invokespecial 374	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 4
    //   35: aload 4
    //   37: astore_0
    //   38: sipush 1024
    //   41: newarray <illegal type>
    //   43: astore 5
    //   45: aload 4
    //   47: astore_0
    //   48: aload_1
    //   49: aload 5
    //   51: iconst_0
    //   52: sipush 1024
    //   55: invokevirtual 106	java/io/InputStream:read	([BII)I
    //   58: istore_3
    //   59: iload_3
    //   60: iconst_m1
    //   61: if_icmpeq +46 -> 107
    //   64: aload 4
    //   66: astore_0
    //   67: aload 4
    //   69: aload 5
    //   71: iconst_0
    //   72: iload_3
    //   73: invokevirtual 377	java/io/OutputStream:write	([BII)V
    //   76: goto -31 -> 45
    //   79: astore 5
    //   81: aload 4
    //   83: astore_0
    //   84: aload 5
    //   86: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   89: iconst_2
    //   90: anewarray 115	java/io/Closeable
    //   93: dup
    //   94: iconst_0
    //   95: aload_1
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload 4
    //   101: aastore
    //   102: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: iconst_2
    //   108: anewarray 115	java/io/Closeable
    //   111: dup
    //   112: iconst_0
    //   113: aload_1
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload 4
    //   119: aastore
    //   120: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   123: iconst_1
    //   124: ireturn
    //   125: astore 4
    //   127: aconst_null
    //   128: astore_0
    //   129: iconst_2
    //   130: anewarray 115	java/io/Closeable
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: aload_0
    //   140: aastore
    //   141: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   144: aload 4
    //   146: athrow
    //   147: astore 4
    //   149: goto -20 -> 129
    //   152: astore 5
    //   154: aconst_null
    //   155: astore 4
    //   157: goto -76 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramFile	File
    //   0	160	1	paramInputStream	InputStream
    //   0	160	2	paramBoolean	boolean
    //   58	15	3	i	int
    //   33	85	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   125	20	4	localObject1	Object
    //   147	1	4	localObject2	Object
    //   155	1	4	localObject3	Object
    //   43	27	5	arrayOfByte	byte[]
    //   79	6	5	localIOException1	IOException
    //   152	1	5	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   38	45	79	java/io/IOException
    //   48	59	79	java/io/IOException
    //   67	76	79	java/io/IOException
    //   17	35	125	finally
    //   38	45	147	finally
    //   48	59	147	finally
    //   67	76	147	finally
    //   84	89	147	finally
    //   17	35	152	java/io/IOException
  }
  
  public static boolean writeFileFromIS(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return writeFileFromIS(a(paramString), paramInputStream, paramBoolean);
  }
  
  /* Error */
  public static boolean writeFileFromString(File paramFile, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: invokestatic 185	com/ziroom/commonlib/utils/i:createOrExistsFile	(Ljava/io/File;)Z
    //   14: ifeq -6 -> 8
    //   17: new 382	java/io/FileWriter
    //   20: dup
    //   21: aload_0
    //   22: iload_2
    //   23: invokespecial 383	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   26: astore_3
    //   27: aload_3
    //   28: astore_0
    //   29: aload_3
    //   30: aload_1
    //   31: invokevirtual 385	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   34: iconst_1
    //   35: anewarray 115	java/io/Closeable
    //   38: dup
    //   39: iconst_0
    //   40: aload_3
    //   41: aastore
    //   42: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   45: iconst_1
    //   46: ireturn
    //   47: astore 4
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: astore_0
    //   53: aload 4
    //   55: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   58: iconst_1
    //   59: anewarray 115	java/io/Closeable
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_0
    //   74: iconst_1
    //   75: anewarray 115	java/io/Closeable
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: invokestatic 119	com/ziroom/commonlib/utils/i:closeIO	([Ljava/io/Closeable;)V
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: goto -14 -> 74
    //   91: astore 4
    //   93: aload_3
    //   94: astore_1
    //   95: goto -44 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramFile	File
    //   0	98	1	paramString	String
    //   0	98	2	paramBoolean	boolean
    //   26	68	3	localFileWriter	java.io.FileWriter
    //   47	7	4	localIOException1	IOException
    //   91	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   17	27	47	java/io/IOException
    //   17	27	71	finally
    //   29	34	87	finally
    //   53	58	87	finally
    //   29	34	91	java/io/IOException
  }
  
  public static boolean writeFileFromString(String paramString1, String paramString2, boolean paramBoolean)
  {
    return writeFileFromString(a(paramString1), paramString2, paramBoolean);
  }
  
  /* Error */
  public void readFileByLines(String paramString)
  {
    // Byte code:
    //   0: new 19	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: getstatic 394	java/lang/System:out	Ljava/io/PrintStream;
    //   12: ldc_w 396
    //   15: invokevirtual 401	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18: new 324	java/io/BufferedReader
    //   21: dup
    //   22: new 326	java/io/FileReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 327	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   30: invokespecial 330	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_3
    //   34: iconst_1
    //   35: istore_2
    //   36: aload_3
    //   37: astore_1
    //   38: aload_3
    //   39: invokevirtual 333	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +49 -> 95
    //   49: aload_3
    //   50: astore_1
    //   51: getstatic 394	java/lang/System:out	Ljava/io/PrintStream;
    //   54: new 123	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 403
    //   64: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_2
    //   68: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 408
    //   74: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 401	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   88: iload_2
    //   89: iconst_1
    //   90: iadd
    //   91: istore_2
    //   92: goto -56 -> 36
    //   95: aload_3
    //   96: astore_1
    //   97: aload_3
    //   98: invokevirtual 409	java/io/BufferedReader:close	()V
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 409	java/io/BufferedReader:close	()V
    //   109: return
    //   110: astore 4
    //   112: aconst_null
    //   113: astore_3
    //   114: aload_3
    //   115: astore_1
    //   116: aload 4
    //   118: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   121: aload_3
    //   122: ifnull -13 -> 109
    //   125: aload_3
    //   126: invokevirtual 409	java/io/BufferedReader:close	()V
    //   129: return
    //   130: astore_1
    //   131: return
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 409	java/io/BufferedReader:close	()V
    //   143: aload_3
    //   144: athrow
    //   145: astore_1
    //   146: return
    //   147: astore_1
    //   148: goto -5 -> 143
    //   151: astore_3
    //   152: goto -17 -> 135
    //   155: astore 4
    //   157: goto -43 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	i
    //   0	160	1	paramString	String
    //   35	57	2	i	int
    //   33	93	3	localBufferedReader	java.io.BufferedReader
    //   132	12	3	localObject1	Object
    //   151	1	3	localObject2	Object
    //   42	36	4	str	String
    //   110	7	4	localIOException1	IOException
    //   155	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   9	34	110	java/io/IOException
    //   125	129	130	java/io/IOException
    //   9	34	132	finally
    //   105	109	145	java/io/IOException
    //   139	143	147	java/io/IOException
    //   38	44	151	finally
    //   51	88	151	finally
    //   97	101	151	finally
    //   116	121	151	finally
    //   38	44	155	java/io/IOException
    //   51	88	155	java/io/IOException
    //   97	101	155	java/io/IOException
  }
  
  /* Error */
  public void textToFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 382	java/io/FileWriter
    //   6: dup
    //   7: new 19	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 412	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 385	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   26: aload_3
    //   27: invokevirtual 415	java/io/FileWriter:flush	()V
    //   30: aload_3
    //   31: invokevirtual 416	java/io/FileWriter:close	()V
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   40: return
    //   41: astore 4
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   52: aload_2
    //   53: invokevirtual 415	java/io/FileWriter:flush	()V
    //   56: aload_2
    //   57: invokevirtual 416	java/io/FileWriter:close	()V
    //   60: return
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   66: return
    //   67: astore_1
    //   68: aload 4
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 415	java/io/FileWriter:flush	()V
    //   75: aload_2
    //   76: invokevirtual 416	java/io/FileWriter:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   86: goto -7 -> 79
    //   89: astore_3
    //   90: aload_1
    //   91: astore_2
    //   92: aload_3
    //   93: astore_1
    //   94: goto -23 -> 71
    //   97: astore 4
    //   99: aload_3
    //   100: astore_2
    //   101: goto -56 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	i
    //   0	104	1	paramString1	String
    //   0	104	2	paramString2	String
    //   18	13	3	localFileWriter	java.io.FileWriter
    //   89	11	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   41	28	4	localIOException1	IOException
    //   97	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   26	34	35	java/io/IOException
    //   3	19	41	java/io/IOException
    //   52	60	61	java/io/IOException
    //   3	19	67	finally
    //   71	79	81	java/io/IOException
    //   21	26	89	finally
    //   47	52	89	finally
    //   21	26	97	java/io/IOException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */