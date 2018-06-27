package cn.jiguang.f;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class d
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "^y)@EW";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 26;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "!\003.J+T";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "3\025ZT\"";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = " (p\034O\022(p";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 102;
        break label91;
        i = 65;
        break label91;
        i = 28;
        break label91;
        i = 121;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  /* Error */
  public static java.util.ArrayList<String> a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 41	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 43	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 45	java/io/InputStreamReader
    //   11: dup
    //   12: aload_0
    //   13: getstatic 32	cn/jiguang/f/d:z	[Ljava/lang/String;
    //   16: iconst_2
    //   17: aaload
    //   18: invokespecial 48	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: new 50	java/io/BufferedReader
    //   27: dup
    //   28: aload_1
    //   29: sipush 2048
    //   32: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   35: astore_2
    //   36: aload_1
    //   37: astore_0
    //   38: aload_2
    //   39: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +61 -> 107
    //   49: aload_1
    //   50: astore_0
    //   51: aload 4
    //   53: invokevirtual 59	java/lang/String:trim	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload_1
    //   59: astore_0
    //   60: ldc 61
    //   62: aload 4
    //   64: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne -31 -> 36
    //   70: aload_1
    //   71: astore_0
    //   72: aload_3
    //   73: aload 4
    //   75: invokevirtual 68	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: goto -43 -> 36
    //   82: astore_2
    //   83: aload_1
    //   84: astore_0
    //   85: getstatic 32	cn/jiguang/f/d:z	[Ljava/lang/String;
    //   88: iconst_3
    //   89: aaload
    //   90: aload_2
    //   91: invokevirtual 71	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   94: invokestatic 77	cn/jiguang/d/d:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 80	java/io/InputStreamReader:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: aload_1
    //   108: astore_0
    //   109: aload_2
    //   110: invokevirtual 81	java/io/BufferedReader:close	()V
    //   113: aload_1
    //   114: invokevirtual 80	java/io/InputStreamReader:close	()V
    //   117: aload_3
    //   118: areturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   124: aload_3
    //   125: areturn
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   131: aload_3
    //   132: areturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 80	java/io/InputStreamReader:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_1
    //   155: goto -19 -> 136
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: goto -78 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInputStream	java.io.InputStream
    //   21	93	1	localInputStreamReader	java.io.InputStreamReader
    //   133	12	1	localObject1	Object
    //   154	1	1	localObject2	Object
    //   160	1	1	localObject3	Object
    //   35	4	2	localBufferedReader	java.io.BufferedReader
    //   82	28	2	localException1	Exception
    //   158	1	2	localException2	Exception
    //   7	125	3	localArrayList	java.util.ArrayList
    //   42	32	4	str	String
    // Exception table:
    //   from	to	target	type
    //   24	36	82	java/lang/Exception
    //   38	44	82	java/lang/Exception
    //   51	58	82	java/lang/Exception
    //   60	70	82	java/lang/Exception
    //   72	79	82	java/lang/Exception
    //   109	113	82	java/lang/Exception
    //   113	117	119	java/io/IOException
    //   101	105	126	java/io/IOException
    //   8	22	133	finally
    //   140	144	146	java/io/IOException
    //   24	36	154	finally
    //   38	44	154	finally
    //   51	58	154	finally
    //   60	70	154	finally
    //   72	79	154	finally
    //   85	97	154	finally
    //   109	113	154	finally
    //   8	22	158	java/lang/Exception
  }
  
  private static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    Object localObject = new StringBuilder().append(paramString);
    if (paramString.trim().length() == 0) {}
    int i;
    for (paramString = "";; paramString = File.separator)
    {
      paramString = new String((paramString + paramFile.getName()).getBytes(z[0]), z[1]);
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return;
      }
      int j = paramFile.length;
      i = 0;
      while (i < j)
      {
        a(paramFile[i], paramZipOutputStream, paramString);
        i += 1;
      }
    }
    localObject = new byte[1048576];
    paramFile = new BufferedInputStream(new FileInputStream(paramFile), 1048576);
    paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
    for (;;)
    {
      i = paramFile.read((byte[])localObject);
      if (i == -1) {
        break;
      }
      paramZipOutputStream.write((byte[])localObject, 0, i);
    }
    paramFile.close();
    paramZipOutputStream.flush();
    paramZipOutputStream.closeEntry();
  }
  
  public static void a(Collection<File> paramCollection, File paramFile)
  {
    paramFile = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile), 1048576));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a((File)paramCollection.next(), paramFile, "");
    }
    paramFile.close();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */