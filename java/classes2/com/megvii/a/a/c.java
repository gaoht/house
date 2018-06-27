package com.megvii.a.a;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class c
{
  private static Context a;
  private static c b;
  
  private c(Context paramContext)
  {
    a = paramContext;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new c(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isFile()) {
        paramFile.delete();
      }
      while (!paramFile.isDirectory()) {
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
      paramFile.delete();
      return;
    }
    d.b("SoProtect", "所删除的文件不存在！\n");
  }
  
  private void a(File paramFile, String paramString)
  {
    try
    {
      paramFile = paramFile.listFiles(new a(paramString));
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        a(paramFile[i]);
        i += 1;
      }
      return;
    }
    catch (Exception paramFile)
    {
      d.a("SoProtect", paramFile.toString());
    }
  }
  
  /* Error */
  private static boolean a(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_1
    //   12: invokevirtual 30	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 36	java/io/File:delete	()Z
    //   22: pop
    //   23: aload_1
    //   24: invokevirtual 77	java/io/File:createNewFile	()Z
    //   27: pop
    //   28: new 79	java/io/BufferedInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_0
    //   37: new 84	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: aload 5
    //   48: astore 4
    //   50: aload_0
    //   51: astore 6
    //   53: aload_1
    //   54: astore 5
    //   56: new 88	java/io/BufferedOutputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 91	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore_3
    //   65: sipush 1024
    //   68: newarray <illegal type>
    //   70: astore 4
    //   72: aload_0
    //   73: aload 4
    //   75: invokevirtual 95	java/io/BufferedInputStream:read	([B)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpeq +64 -> 145
    //   84: aload_3
    //   85: aload 4
    //   87: iconst_0
    //   88: iload_2
    //   89: invokevirtual 99	java/io/BufferedOutputStream:write	([BII)V
    //   92: goto -20 -> 72
    //   95: astore 5
    //   97: aload_3
    //   98: astore 4
    //   100: aload_1
    //   101: astore_3
    //   102: aload 4
    //   104: astore_1
    //   105: aload 5
    //   107: astore 4
    //   109: ldc 47
    //   111: aload 4
    //   113: invokevirtual 100	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   116: invokestatic 69	com/megvii/a/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 104	java/io/BufferedInputStream:close	()V
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 105	java/io/BufferedOutputStream:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: aload_3
    //   146: invokevirtual 108	java/io/BufferedOutputStream:flush	()V
    //   149: aload_1
    //   150: invokevirtual 109	java/io/FileOutputStream:flush	()V
    //   153: aload_1
    //   154: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   157: aload_0
    //   158: invokevirtual 104	java/io/BufferedInputStream:close	()V
    //   161: aload_3
    //   162: invokevirtual 105	java/io/BufferedOutputStream:close	()V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore_0
    //   168: ldc 47
    //   170: aload_0
    //   171: invokevirtual 110	java/io/IOException:toString	()Ljava/lang/String;
    //   174: invokestatic 69	com/megvii/a/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: ldc 47
    //   182: aload_0
    //   183: invokevirtual 110	java/io/IOException:toString	()Ljava/lang/String;
    //   186: invokestatic 69	com/megvii/a/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_3
    //   192: aconst_null
    //   193: astore_0
    //   194: aconst_null
    //   195: astore_1
    //   196: aload 7
    //   198: astore 4
    //   200: aload_0
    //   201: astore 6
    //   203: aload_1
    //   204: astore 5
    //   206: ldc 47
    //   208: aload_3
    //   209: invokevirtual 110	java/io/IOException:toString	()Ljava/lang/String;
    //   212: invokestatic 69	com/megvii/a/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_1
    //   216: ifnull +7 -> 223
    //   219: aload_1
    //   220: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   223: aload_0
    //   224: ifnull +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 104	java/io/BufferedInputStream:close	()V
    //   231: aload 7
    //   233: ifnull +8 -> 241
    //   236: aload 7
    //   238: invokevirtual 105	java/io/BufferedOutputStream:close	()V
    //   241: iconst_0
    //   242: ireturn
    //   243: astore_0
    //   244: ldc 47
    //   246: aload_0
    //   247: invokevirtual 110	java/io/IOException:toString	()Ljava/lang/String;
    //   250: invokestatic 69	com/megvii/a/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_3
    //   256: aconst_null
    //   257: astore_0
    //   258: aconst_null
    //   259: astore_1
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   268: aload_0
    //   269: ifnull +7 -> 276
    //   272: aload_0
    //   273: invokevirtual 104	java/io/BufferedInputStream:close	()V
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 105	java/io/BufferedOutputStream:close	()V
    //   286: aload_3
    //   287: athrow
    //   288: astore_0
    //   289: ldc 47
    //   291: aload_0
    //   292: invokevirtual 110	java/io/IOException:toString	()Ljava/lang/String;
    //   295: invokestatic 69	com/megvii/a/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: goto -12 -> 286
    //   301: astore_3
    //   302: aconst_null
    //   303: astore_1
    //   304: goto -44 -> 260
    //   307: astore_3
    //   308: aload 6
    //   310: astore_0
    //   311: aload 5
    //   313: astore_1
    //   314: goto -54 -> 260
    //   317: astore 5
    //   319: aload_3
    //   320: astore 4
    //   322: aload 5
    //   324: astore_3
    //   325: goto -65 -> 260
    //   328: astore 4
    //   330: aload_3
    //   331: astore 5
    //   333: aload 4
    //   335: astore_3
    //   336: aload_1
    //   337: astore 4
    //   339: aload 5
    //   341: astore_1
    //   342: goto -82 -> 260
    //   345: astore_3
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -152 -> 196
    //   351: astore_3
    //   352: goto -156 -> 196
    //   355: astore 4
    //   357: aload_3
    //   358: astore 7
    //   360: aload 4
    //   362: astore_3
    //   363: goto -167 -> 196
    //   366: astore 4
    //   368: aconst_null
    //   369: astore_1
    //   370: aconst_null
    //   371: astore 5
    //   373: aload_3
    //   374: astore_0
    //   375: aload 5
    //   377: astore_3
    //   378: goto -269 -> 109
    //   381: astore 4
    //   383: aconst_null
    //   384: astore_3
    //   385: aconst_null
    //   386: astore_1
    //   387: goto -278 -> 109
    //   390: astore 4
    //   392: aload_1
    //   393: astore_3
    //   394: aconst_null
    //   395: astore_1
    //   396: goto -287 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramInputStream	InputStream
    //   0	399	1	paramFile	File
    //   78	11	2	i	int
    //   10	152	3	localObject1	Object
    //   191	18	3	localIOException1	IOException
    //   255	32	3	localObject2	Object
    //   301	1	3	localObject3	Object
    //   307	13	3	localObject4	Object
    //   324	12	3	localObject5	Object
    //   345	1	3	localIOException2	IOException
    //   351	7	3	localIOException3	IOException
    //   362	32	3	localObject6	Object
    //   4	317	4	localObject7	Object
    //   328	6	4	localObject8	Object
    //   337	1	4	localFile1	File
    //   355	6	4	localIOException4	IOException
    //   366	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   381	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   390	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   7	48	5	localFile2	File
    //   95	11	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   204	108	5	localFile3	File
    //   317	6	5	localObject9	Object
    //   331	45	5	localObject10	Object
    //   51	258	6	localInputStream	InputStream
    //   1	358	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   65	72	95	java/io/FileNotFoundException
    //   72	79	95	java/io/FileNotFoundException
    //   84	92	95	java/io/FileNotFoundException
    //   145	153	95	java/io/FileNotFoundException
    //   153	165	167	java/io/IOException
    //   123	127	179	java/io/IOException
    //   131	135	179	java/io/IOException
    //   139	143	179	java/io/IOException
    //   11	23	191	java/io/IOException
    //   23	37	191	java/io/IOException
    //   219	223	243	java/io/IOException
    //   227	231	243	java/io/IOException
    //   236	241	243	java/io/IOException
    //   11	23	255	finally
    //   23	37	255	finally
    //   264	268	288	java/io/IOException
    //   272	276	288	java/io/IOException
    //   281	286	288	java/io/IOException
    //   37	46	301	finally
    //   56	65	307	finally
    //   206	215	307	finally
    //   65	72	317	finally
    //   72	79	317	finally
    //   84	92	317	finally
    //   145	153	317	finally
    //   109	119	328	finally
    //   37	46	345	java/io/IOException
    //   56	65	351	java/io/IOException
    //   65	72	355	java/io/IOException
    //   72	79	355	java/io/IOException
    //   84	92	355	java/io/IOException
    //   145	153	355	java/io/IOException
    //   11	23	366	java/io/FileNotFoundException
    //   23	37	366	java/io/FileNotFoundException
    //   37	46	381	java/io/FileNotFoundException
    //   56	65	390	java/io/FileNotFoundException
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    paramString2 = c.class.getClassLoader().getResourceAsStream(paramString2);
    if (paramString2 != null)
    {
      if (paramString1 == null) {
        d.a("SoProtect", "apse file cann't be null...");
      }
      boolean bool = a(paramString2, paramFile);
      try
      {
        paramString2.close();
        return bool;
      }
      catch (IOException paramString1)
      {
        d.a("SoProtect", paramString1.toString());
        return bool;
      }
    }
    d.b("SoProtect", "error: can't find " + paramString3 + " in apk");
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = Build.CPU_ABI;
    String str2 = "lib" + paramString3 + "_" + paramString4 + ".so";
    if ("x86".equals(str1)) {
      paramString4 = "lib/x86/" + str2;
    }
    File localFile;
    for (;;)
    {
      try
      {
        paramString2 = new File(paramString1 + File.separator + paramString2);
        localFile = new File(paramString2.toString() + File.separator + str2);
        if (!localFile.exists()) {
          break;
        }
        d.b("SoProtect", "file " + localFile.toString() + " is exist");
        return true;
      }
      catch (Exception paramString1)
      {
        d.a("SoProtect", paramString1.toString());
        return false;
      }
      if ("armeabi-v7a".equals(str1))
      {
        paramString4 = "lib/armeabi-v7a/" + str2;
      }
      else
      {
        d.a("SoProtect", "apse is not support for this mode");
        return false;
      }
    }
    a(paramString2, "lib" + paramString3);
    paramString2.mkdirs();
    boolean bool = a(paramString1, paramString4, str2, localFile);
    if ((!bool) && (str1.equals("armeabi-v7a")))
    {
      d.b("SoProtect", String.format("%s arch copy failed, try to copy %s arch", new Object[] { "armeabi-v7a", "armeabi" }));
      return a(paramString1, "lib/armeabi/" + str2, str2, localFile);
    }
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    try
    {
      System.loadLibrary("livenessdetection_v2.4.4");
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool = false;
      }
      String str = paramString1 + "_bak";
      File localFile = a.getFilesDir();
      if (!a(localFile.toString(), str, paramString1, paramString2)) {
        break label231;
      }
      paramString2 = "lib" + paramString1 + "_" + paramString2 + ".so";
      paramString2 = str + File.separator + paramString2;
      paramString2 = new File(localFile.toString() + File.separator + paramString2);
      d.a("copy lib to " + paramString2.toString());
      if (!paramString2.exists()) {
        break label208;
      }
      try
      {
        System.load(paramString2.toString());
        return true;
      }
      catch (UnsatisfiedLinkError paramString1)
      {
        d.a("SoProtect", paramString1.toString());
        return bool;
      }
      label208:
      d.b("SoProtect", String.format(Locale.ENGLISH, "error can't find %1$s lib in plugins_lib", new Object[] { paramString1 }));
      return bool;
      label231:
      d.a("SoProtect", String.format(Locale.ENGLISH, "error copy %1$s lib fail", new Object[] { paramString1 }));
    }
    if (bool) {
      return true;
    }
    return bool;
  }
  
  final class a
    implements FileFilter
  {
    private String a = "";
    
    public a(String paramString)
    {
      this.a = paramString;
    }
    
    public final boolean accept(File paramFile)
    {
      return paramFile.getName().startsWith(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */