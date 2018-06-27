package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class TypefaceCompatUtil
{
  private static final String CACHE_FILE_PREFIX = ".font";
  private static final String TAG = "TypefaceCompatUtil";
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static ByteBuffer copyToDirectBuffer(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = getTempFile(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = copyToFile(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = mmap(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  public static boolean copyToFile(File paramFile, Resources paramResources, int paramInt)
  {
    Resources localResources = null;
    try
    {
      paramResources = paramResources.openRawResource(paramInt);
      localResources = paramResources;
      boolean bool = copyToFile(paramFile, paramResources);
      return bool;
    }
    finally
    {
      closeQuietly(localResources);
    }
  }
  
  /* Error */
  public static boolean copyToFile(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 58	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: iconst_0
    //   6: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   9: astore_3
    //   10: aload_3
    //   11: astore_0
    //   12: sipush 1024
    //   15: newarray <illegal type>
    //   17: astore 4
    //   19: aload_3
    //   20: astore_0
    //   21: aload_1
    //   22: aload 4
    //   24: invokevirtual 67	java/io/InputStream:read	([B)I
    //   27: istore_2
    //   28: iload_2
    //   29: iconst_m1
    //   30: if_icmpeq +57 -> 87
    //   33: aload_3
    //   34: astore_0
    //   35: aload_3
    //   36: aload 4
    //   38: iconst_0
    //   39: iload_2
    //   40: invokevirtual 71	java/io/FileOutputStream:write	([BII)V
    //   43: goto -24 -> 19
    //   46: astore_0
    //   47: aload_3
    //   48: astore_1
    //   49: aload_0
    //   50: astore_3
    //   51: aload_1
    //   52: astore_0
    //   53: ldc 11
    //   55: new 73	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   62: ldc 76
    //   64: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 84	java/io/IOException:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 93	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: aload_1
    //   82: invokestatic 56	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload_3
    //   88: invokestatic 56	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   91: iconst_1
    //   92: ireturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: invokestatic 56	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: goto -7 -> 96
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -58 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramFile	File
    //   0	112	1	paramInputStream	java.io.InputStream
    //   27	13	2	i	int
    //   9	79	3	localObject	Object
    //   106	1	3	localIOException	IOException
    //   17	20	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	19	46	java/io/IOException
    //   21	28	46	java/io/IOException
    //   35	43	46	java/io/IOException
    //   0	10	93	finally
    //   12	19	102	finally
    //   21	28	102	finally
    //   35	43	102	finally
    //   53	81	102	finally
    //   0	10	106	java/io/IOException
  }
  
  public static File getTempFile(Context paramContext)
  {
    String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
    int i = 0;
    while (i < 100)
    {
      File localFile = new File(paramContext.getCacheDir(), str + i);
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool) {
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  /* Error */
  public static ByteBuffer mmap(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc -128
    //   9: aload_1
    //   10: invokevirtual 134	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_2
    //   14: new 136	java/io/FileInputStream
    //   17: dup
    //   18: aload_2
    //   19: invokevirtual 142	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   22: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   25: astore 5
    //   27: aload 5
    //   29: invokevirtual 149	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 155	java/nio/channels/FileChannel:size	()J
    //   37: lstore_3
    //   38: aload_0
    //   39: getstatic 161	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   42: lconst_0
    //   43: lload_3
    //   44: invokevirtual 165	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   47: astore_0
    //   48: aload 5
    //   50: ifnull +12 -> 62
    //   53: iconst_0
    //   54: ifeq +52 -> 106
    //   57: aload 5
    //   59: invokevirtual 166	java/io/FileInputStream:close	()V
    //   62: aload_2
    //   63: ifnull +11 -> 74
    //   66: iconst_0
    //   67: ifeq +62 -> 129
    //   70: aload_2
    //   71: invokevirtual 167	android/os/ParcelFileDescriptor:close	()V
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: new 169	java/lang/NullPointerException
    //   80: dup
    //   81: invokespecial 170	java/lang/NullPointerException:<init>	()V
    //   84: athrow
    //   85: astore_0
    //   86: aload_0
    //   87: athrow
    //   88: astore_1
    //   89: aload_2
    //   90: ifnull +11 -> 101
    //   93: aload_0
    //   94: ifnull +89 -> 183
    //   97: aload_2
    //   98: invokevirtual 167	android/os/ParcelFileDescriptor:close	()V
    //   101: aload_1
    //   102: athrow
    //   103: astore_0
    //   104: aconst_null
    //   105: areturn
    //   106: aload 5
    //   108: invokevirtual 166	java/io/FileInputStream:close	()V
    //   111: goto -49 -> 62
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -28 -> 89
    //   120: astore_0
    //   121: new 169	java/lang/NullPointerException
    //   124: dup
    //   125: invokespecial 170	java/lang/NullPointerException:<init>	()V
    //   128: athrow
    //   129: aload_2
    //   130: invokevirtual 167	android/os/ParcelFileDescriptor:close	()V
    //   133: aload_0
    //   134: areturn
    //   135: astore_1
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload 5
    //   141: ifnull +12 -> 153
    //   144: aload_1
    //   145: ifnull +21 -> 166
    //   148: aload 5
    //   150: invokevirtual 166	java/io/FileInputStream:close	()V
    //   153: aload_0
    //   154: athrow
    //   155: astore 5
    //   157: aload_1
    //   158: aload 5
    //   160: invokevirtual 174	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   163: goto -10 -> 153
    //   166: aload 5
    //   168: invokevirtual 166	java/io/FileInputStream:close	()V
    //   171: goto -18 -> 153
    //   174: astore_2
    //   175: aload_0
    //   176: aload_2
    //   177: invokevirtual 174	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   180: goto -79 -> 101
    //   183: aload_2
    //   184: invokevirtual 167	android/os/ParcelFileDescriptor:close	()V
    //   187: goto -86 -> 101
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -54 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramContext	Context
    //   0	196	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	196	2	paramUri	android.net.Uri
    //   37	7	3	l	long
    //   25	124	5	localFileInputStream	FileInputStream
    //   155	12	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   57	62	76	java/lang/Throwable
    //   14	27	85	java/lang/Throwable
    //   77	85	85	java/lang/Throwable
    //   106	111	85	java/lang/Throwable
    //   153	155	85	java/lang/Throwable
    //   157	163	85	java/lang/Throwable
    //   166	171	85	java/lang/Throwable
    //   86	88	88	finally
    //   5	14	103	java/io/IOException
    //   70	74	103	java/io/IOException
    //   97	101	103	java/io/IOException
    //   101	103	103	java/io/IOException
    //   121	129	103	java/io/IOException
    //   129	133	103	java/io/IOException
    //   175	180	103	java/io/IOException
    //   183	187	103	java/io/IOException
    //   14	27	114	finally
    //   57	62	114	finally
    //   77	85	114	finally
    //   106	111	114	finally
    //   148	153	114	finally
    //   153	155	114	finally
    //   157	163	114	finally
    //   166	171	114	finally
    //   70	74	120	java/lang/Throwable
    //   27	48	135	java/lang/Throwable
    //   136	138	138	finally
    //   148	153	155	java/lang/Throwable
    //   97	101	174	java/lang/Throwable
    //   27	48	190	finally
  }
  
  private static ByteBuffer mmap(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      try
      {
        paramFile = localFileInputStream.getChannel();
        long l = paramFile.size();
        paramFile = paramFile.map(FileChannel.MapMode.READ_ONLY, 0L, l);
        if ((localFileInputStream == null) || (0 != 0)) {
          try
          {
            localFileInputStream.close();
            return paramFile;
          }
          catch (Throwable paramFile)
          {
            throw new NullPointerException();
          }
        }
        localFileInputStream.close();
        return paramFile;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1 = localThrowable1;
        try
        {
          throw localThrowable1;
        }
        finally
        {
          if ((localFileInputStream == null) || (localThrowable1 != null)) {
            try
            {
              localFileInputStream.close();
              throw paramFile;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                localThrowable1.addSuppressed(localThrowable2);
              }
            }
          }
          localThrowable2.close();
        }
      }
      finally
      {
        for (;;)
        {
          paramFile = finally;
          Object localObject = null;
        }
      }
      return null;
    }
    catch (IOException paramFile) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/graphics/TypefaceCompatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */