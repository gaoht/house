package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class b
{
  private static long a(File paramFile)
  {
    long l2 = paramFile.lastModified();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static SharedPreferences a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i = 0;; i = 4) {
      return paramContext.getSharedPreferences("multidex.version", i);
    }
  }
  
  private static List<a> a(Context paramContext, File paramFile1, File paramFile2, String paramString)
    throws IOException
  {
    Log.i("MultiDex", "loading existing secondary dex files");
    paramFile1 = paramFile1.getName() + ".classes";
    paramContext = a(paramContext);
    int j = paramContext.getInt(paramString + "dex.number", 1);
    ArrayList localArrayList = new ArrayList(j - 1);
    int i = 2;
    while (i <= j)
    {
      a locala = new a(paramFile2, paramFile1 + i + ".zip");
      if (locala.isFile())
      {
        locala.a = b(locala);
        long l1 = paramContext.getLong(paramString + "dex.crc." + i, -1L);
        long l2 = paramContext.getLong(paramString + "dex.time." + i, -1L);
        long l3 = locala.lastModified();
        if ((l2 != l3) || (l1 != locala.a)) {
          throw new IOException("Invalid extracted dex: " + locala + " (key \"" + paramString + "\"), expected modification time: " + l2 + ", modification time: " + l3 + ", expected crc: " + l1 + ", file crc: " + locala.a);
        }
        localArrayList.add(locala);
        i += 1;
      }
      else
      {
        throw new IOException("Missing extracted secondary dex file '" + locala.getPath() + "'");
      }
    }
    return localArrayList;
  }
  
  /* Error */
  static List<? extends File> a(Context paramContext, File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: ldc 39
    //   2: new 49	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   9: ldc -108
    //   11: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 149	java/io/File:getPath	()Ljava/lang/String;
    //   18: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc -105
    //   23: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload 4
    //   28: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc -105
    //   33: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc -100
    //   42: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 47	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   51: pop
    //   52: aload_1
    //   53: invokestatic 96	android/support/multidex/b:b	(Ljava/io/File;)J
    //   56: lstore 5
    //   58: new 12	java/io/File
    //   61: dup
    //   62: aload_2
    //   63: ldc -98
    //   65: invokespecial 159	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   68: astore 11
    //   70: new 161	java/io/RandomAccessFile
    //   73: dup
    //   74: aload 11
    //   76: ldc -93
    //   78: invokespecial 164	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   81: astore 10
    //   83: aconst_null
    //   84: astore 8
    //   86: aconst_null
    //   87: astore 9
    //   89: aload 10
    //   91: invokevirtual 168	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   94: astore 7
    //   96: ldc 39
    //   98: new 49	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   105: ldc -86
    //   107: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 11
    //   112: invokevirtual 149	java/io/File:getPath	()Ljava/lang/String;
    //   115: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 47	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   124: pop
    //   125: aload 7
    //   127: invokevirtual 176	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   130: astore 8
    //   132: ldc 39
    //   134: new 49	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   141: aload 11
    //   143: invokevirtual 149	java/io/File:getPath	()Ljava/lang/String;
    //   146: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc -78
    //   151: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 47	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   160: pop
    //   161: iload 4
    //   163: ifne +128 -> 291
    //   166: aload_0
    //   167: aload_1
    //   168: lload 5
    //   170: aload_3
    //   171: invokestatic 181	android/support/multidex/b:a	(Landroid/content/Context;Ljava/io/File;JLjava/lang/String;)Z
    //   174: istore 4
    //   176: iload 4
    //   178: ifne +113 -> 291
    //   181: aload_0
    //   182: aload_1
    //   183: aload_2
    //   184: aload_3
    //   185: invokestatic 183	android/support/multidex/b:a	(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/util/List;
    //   188: astore 9
    //   190: aload 9
    //   192: astore_0
    //   193: aload 8
    //   195: ifnull +250 -> 445
    //   198: aload 8
    //   200: invokevirtual 188	java/nio/channels/FileLock:release	()V
    //   203: aconst_null
    //   204: astore_1
    //   205: aload 7
    //   207: ifnull +8 -> 215
    //   210: aload 7
    //   212: invokestatic 191	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   215: aload 10
    //   217: invokestatic 191	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   220: aload_1
    //   221: ifnull +167 -> 388
    //   224: aload_1
    //   225: athrow
    //   226: astore 9
    //   228: ldc 39
    //   230: ldc -63
    //   232: aload 9
    //   234: invokestatic 197	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   237: pop
    //   238: aload_1
    //   239: aload_2
    //   240: invokestatic 200	android/support/multidex/b:a	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   243: astore_2
    //   244: aload_0
    //   245: aload_3
    //   246: aload_1
    //   247: invokestatic 202	android/support/multidex/b:a	(Ljava/io/File;)J
    //   250: lload 5
    //   252: aload_2
    //   253: invokestatic 205	android/support/multidex/b:a	(Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   256: aload_2
    //   257: astore_0
    //   258: goto -65 -> 193
    //   261: astore_0
    //   262: aload 8
    //   264: astore_2
    //   265: aload 7
    //   267: astore_1
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 188	java/nio/channels/FileLock:release	()V
    //   276: aload_1
    //   277: ifnull +7 -> 284
    //   280: aload_1
    //   281: invokestatic 191	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   284: aload 10
    //   286: invokestatic 191	android/support/multidex/b:a	(Ljava/io/Closeable;)V
    //   289: aload_0
    //   290: athrow
    //   291: ldc 39
    //   293: ldc -49
    //   295: invokestatic 47	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   298: pop
    //   299: aload_1
    //   300: aload_2
    //   301: invokestatic 200	android/support/multidex/b:a	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   304: astore_2
    //   305: aload_0
    //   306: aload_3
    //   307: aload_1
    //   308: invokestatic 202	android/support/multidex/b:a	(Ljava/io/File;)J
    //   311: lload 5
    //   313: aload_2
    //   314: invokestatic 205	android/support/multidex/b:a	(Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   317: aload_2
    //   318: astore_0
    //   319: goto -126 -> 193
    //   322: astore_1
    //   323: ldc 39
    //   325: new 49	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   332: ldc -47
    //   334: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 11
    //   339: invokevirtual 149	java/io/File:getPath	()Ljava/lang/String;
    //   342: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 212	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   351: pop
    //   352: goto -147 -> 205
    //   355: astore_2
    //   356: ldc 39
    //   358: new 49	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   365: ldc -47
    //   367: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 11
    //   372: invokevirtual 149	java/io/File:getPath	()Ljava/lang/String;
    //   375: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 212	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   384: pop
    //   385: goto -109 -> 276
    //   388: ldc 39
    //   390: new 49	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   397: ldc -42
    //   399: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_0
    //   403: invokeinterface 218 1 0
    //   408: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: ldc -36
    //   413: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 47	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   422: pop
    //   423: aload_0
    //   424: areturn
    //   425: astore_0
    //   426: aload 9
    //   428: astore_2
    //   429: aload 8
    //   431: astore_1
    //   432: goto -164 -> 268
    //   435: astore_0
    //   436: aload 7
    //   438: astore_1
    //   439: aload 9
    //   441: astore_2
    //   442: goto -174 -> 268
    //   445: aconst_null
    //   446: astore_1
    //   447: goto -242 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	paramContext	Context
    //   0	450	1	paramFile1	File
    //   0	450	2	paramFile2	File
    //   0	450	3	paramString	String
    //   0	450	4	paramBoolean	boolean
    //   56	256	5	l	long
    //   94	343	7	localFileChannel	java.nio.channels.FileChannel
    //   84	346	8	localFileLock	java.nio.channels.FileLock
    //   87	104	9	localList	List
    //   226	214	9	localIOException	IOException
    //   81	204	10	localRandomAccessFile	java.io.RandomAccessFile
    //   68	303	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   181	190	226	java/io/IOException
    //   132	161	261	finally
    //   166	176	261	finally
    //   181	190	261	finally
    //   228	256	261	finally
    //   291	317	261	finally
    //   198	203	322	java/io/IOException
    //   272	276	355	java/io/IOException
    //   89	96	425	finally
    //   96	132	435	finally
  }
  
  private static List<a> a(File paramFile1, File paramFile2)
    throws IOException
  {
    String str3 = paramFile1.getName() + ".classes";
    a(paramFile2, str3);
    localArrayList = new ArrayList();
    localZipFile = new ZipFile(paramFile1);
    try
    {
      paramFile1 = localZipFile.getEntry("classes" + 2 + ".dex");
      k = 2;
    }
    finally
    {
      for (;;)
      {
        try
        {
          int k;
          a locala;
          int i;
          int j;
          label369:
          localZipFile.close();
          throw paramFile1;
          k += 1;
          paramFile1 = localZipFile.getEntry("classes" + k + ".dex");
          continue;
          try
          {
            localZipFile.close();
            return localArrayList;
          }
          catch (IOException paramFile1)
          {
            Log.w("MultiDex", "Failed to close resource", paramFile1);
            return localArrayList;
          }
        }
        catch (IOException paramFile2)
        {
          Log.w("MultiDex", "Failed to close resource", paramFile2);
          continue;
        }
        continue;
        String str2 = "failed";
      }
    }
    if (paramFile1 != null)
    {
      locala = new a(paramFile2, str3 + k + ".zip");
      localArrayList.add(locala);
      Log.i("MultiDex", "Extraction is needed for file " + locala);
      i = 0;
      j = 0;
      for (;;)
      {
        if ((j >= 3) || (i != 0)) {
          break label369;
        }
        j += 1;
        a(localZipFile, paramFile1, locala, str3);
        try
        {
          locala.a = b(locala);
          i = 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            StringBuilder localStringBuilder;
            String str1;
            Log.w("MultiDex", "Failed to read crc from " + locala.getAbsolutePath(), localIOException);
            i = 0;
          }
        }
        localStringBuilder = new StringBuilder().append("Extraction ");
        if (i == 0) {
          break label508;
        }
        str1 = "succeeded";
        Log.i("MultiDex", str1 + " - length " + locala.getAbsolutePath() + ": " + locala.length() + " - crc: " + locala.a);
        if (i != 0) {
          break label505;
        }
        locala.delete();
        if (!locala.exists()) {
          break label505;
        }
        Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + locala.getPath() + "'");
      }
      if (i == 0) {
        throw new IOException("Could not create zip file " + locala.getAbsolutePath() + " for secondary dex (" + k + ")");
      }
    }
  }
  
  private static void a(Context paramContext, String paramString, long paramLong1, long paramLong2, List<a> paramList)
  {
    paramContext = a(paramContext).edit();
    paramContext.putLong(paramString + "timestamp", paramLong1);
    paramContext.putLong(paramString + "crc", paramLong2);
    paramContext.putInt(paramString + "dex.number", paramList.size() + 1);
    paramList = paramList.iterator();
    int i = 2;
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      paramContext.putLong(paramString + "dex.crc." + i, locala.a);
      paramContext.putLong(paramString + "dex.time." + i, locala.lastModified());
      i += 1;
    }
    paramContext.commit();
  }
  
  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("MultiDex", "Failed to close resource", paramCloseable);
    }
  }
  
  private static void a(File paramFile, String paramString)
  {
    paramString = paramFile.listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        paramAnonymousFile = paramAnonymousFile.getName();
        return (!paramAnonymousFile.startsWith(this.a)) && (!paramAnonymousFile.equals("MultiDex.lock"));
      }
    });
    if (paramString == null)
    {
      Log.w("MultiDex", "Failed to list secondary dex dir content (" + paramFile.getPath() + ").");
      return;
    }
    int j = paramString.length;
    int i = 0;
    label58:
    if (i < j)
    {
      paramFile = paramString[i];
      Log.i("MultiDex", "Trying to delete old file " + paramFile.getPath() + " of size " + paramFile.length());
      if (paramFile.delete()) {
        break label152;
      }
      Log.w("MultiDex", "Failed to delete old file " + paramFile.getPath());
    }
    for (;;)
    {
      i += 1;
      break label58;
      break;
      label152:
      Log.i("MultiDex", "Deleted old file " + paramFile.getPath());
    }
  }
  
  private static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
    throws IOException, FileNotFoundException
  {
    paramZipFile = paramZipFile.getInputStream(paramZipEntry);
    paramString = File.createTempFile("tmp-" + paramString, ".zip", paramFile.getParentFile());
    Log.i("MultiDex", "Extracting " + paramString.getPath());
    try
    {
      ZipOutputStream localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramString)));
      ZipEntry localZipEntry;
      int i;
      Log.i("MultiDex", "Renaming to " + paramFile.getPath());
    }
    finally
    {
      try
      {
        localZipEntry = new ZipEntry("classes.dex");
        localZipEntry.setTime(paramZipEntry.getTime());
        localZipOutputStream.putNextEntry(localZipEntry);
        paramZipEntry = new byte['䀀'];
        for (i = paramZipFile.read(paramZipEntry); i != -1; i = paramZipFile.read(paramZipEntry)) {
          localZipOutputStream.write(paramZipEntry, 0, i);
        }
        localZipOutputStream.closeEntry();
        localZipOutputStream.close();
        if (paramString.setReadOnly()) {
          break label242;
        }
        throw new IOException("Failed to mark readonly \"" + paramString.getAbsolutePath() + "\" (tmp of \"" + paramFile.getAbsolutePath() + "\")");
      }
      finally
      {
        localZipOutputStream.close();
      }
      paramZipEntry = finally;
      a(paramZipFile);
      paramString.delete();
    }
    label242:
    if (!paramString.renameTo(paramFile)) {
      throw new IOException("Failed to rename \"" + paramString.getAbsolutePath() + "\" to \"" + paramFile.getAbsolutePath() + "\"");
    }
    a(paramZipFile);
    paramString.delete();
  }
  
  private static boolean a(Context paramContext, File paramFile, long paramLong, String paramString)
  {
    paramContext = a(paramContext);
    return (paramContext.getLong(paramString + "timestamp", -1L) != a(paramFile)) || (paramContext.getLong(paramString + "crc", -1L) != paramLong);
  }
  
  private static long b(File paramFile)
    throws IOException
  {
    long l2 = c.a(paramFile);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static class a
    extends File
  {
    public long a = -1L;
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/multidex/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */