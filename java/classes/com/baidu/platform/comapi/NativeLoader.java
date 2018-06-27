package com.baidu.platform.comapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NativeLoader
{
  private static Context a;
  private static final Set<String> b = new HashSet();
  private static final Set<String> c = new HashSet();
  private static NativeLoader d;
  private static a e = a.a;
  
  @TargetApi(21)
  private static a a()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (String str = Build.CPU_ABI; str == null; str = Build.SUPPORTED_ABIS[0]) {
      return a.a;
    }
    if ((str.contains("arm")) && (str.contains("v7"))) {
      e = a.b;
    }
    if ((str.contains("arm")) && (str.contains("64"))) {
      e = a.c;
    }
    if (str.contains("x86")) {
      if (!str.contains("64")) {
        break label105;
      }
    }
    label105:
    for (e = a.e;; e = a.d) {
      return e;
    }
  }
  
  private String a(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib/").append(parama.a()).append("/");
    return localStringBuilder.toString();
  }
  
  private void a(Throwable paramThrowable)
  {
    Log.e(NativeLoader.class.getSimpleName(), "loadException", paramThrowable);
    paramThrowable = c.iterator();
    while (paramThrowable.hasNext())
    {
      String str = (String)paramThrowable.next();
      Log.e(NativeLoader.class.getSimpleName(), str + " Failed to load.");
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!copyNativeLibrary(paramString2, a.b)) {
      return b(paramString1, paramString2);
    }
    return f(paramString2, paramString1);
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (copyNativeLibrary(paramString2, a.a)) {
      return f(paramString2, paramString1);
    }
    Log.e(NativeLoader.class.getSimpleName(), "found lib" + paramString1 + ".so error");
    return false;
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    if (!copyNativeLibrary(paramString2, a.c)) {
      return a(paramString1, paramString2);
    }
    return f(paramString2, paramString1);
  }
  
  private boolean d(String paramString1, String paramString2)
  {
    if (!copyNativeLibrary(paramString2, a.d)) {
      return a(paramString1, paramString2);
    }
    return f(paramString2, paramString1);
  }
  
  private boolean e(String paramString1, String paramString2)
  {
    if (!copyNativeLibrary(paramString2, a.e)) {
      return d(paramString1, paramString2);
    }
    return f(paramString2, paramString1);
  }
  
  /* Error */
  private boolean f(String arg1, String paramString2)
  {
    // Byte code:
    //   0: new 151	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 154	com/baidu/platform/comapi/NativeLoader:getCustomizeNativePath	()Ljava/lang/String;
    //   8: aload_1
    //   9: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokevirtual 160	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   15: invokestatic 166	java/lang/System:load	(Ljava/lang/String;)V
    //   18: getstatic 27	com/baidu/platform/comapi/NativeLoader:b	Ljava/util/Set;
    //   21: astore_1
    //   22: aload_1
    //   23: monitorenter
    //   24: getstatic 27	com/baidu/platform/comapi/NativeLoader:b	Ljava/util/Set;
    //   27: aload_2
    //   28: invokeinterface 170 2 0
    //   33: pop
    //   34: aload_1
    //   35: monitorexit
    //   36: iconst_1
    //   37: ireturn
    //   38: astore_3
    //   39: aload_1
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    //   43: astore_3
    //   44: getstatic 29	com/baidu/platform/comapi/NativeLoader:c	Ljava/util/Set;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: getstatic 29	com/baidu/platform/comapi/NativeLoader:c	Ljava/util/Set;
    //   53: aload_2
    //   54: invokeinterface 170 2 0
    //   59: pop
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_0
    //   63: aload_3
    //   64: invokespecial 172	com/baidu/platform/comapi/NativeLoader:a	(Ljava/lang/Throwable;)V
    //   67: iconst_0
    //   68: ireturn
    //   69: astore_2
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	NativeLoader
    //   0	74	2	paramString2	String
    //   38	4	3	localObject	Object
    //   43	21	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	36	38	finally
    //   39	41	38	finally
    //   0	24	43	java/lang/Throwable
    //   41	43	43	java/lang/Throwable
    //   50	62	69	finally
    //   70	72	69	finally
  }
  
  public static NativeLoader getInstance()
  {
    try
    {
      if (d == null)
      {
        d = new NativeLoader();
        e = a();
      }
      NativeLoader localNativeLoader = d;
      return localNativeLoader;
    }
    finally {}
  }
  
  public static void setContext(Context paramContext)
  {
    a = paramContext;
  }
  
  /* Error */
  protected boolean copyNativeLibrary(String paramString, a parama)
  {
    // Byte code:
    //   0: new 80	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: aload_2
    //   9: invokespecial 189	com/baidu/platform/comapi/NativeLoader:a	(Lcom/baidu/platform/comapi/NativeLoader$a;)Ljava/lang/String;
    //   12: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 4
    //   24: new 191	java/util/zip/ZipFile
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 194	com/baidu/platform/comapi/NativeLoader:getCodePath	()Ljava/lang/String;
    //   32: invokespecial 196	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: new 151	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: invokevirtual 154	com/baidu/platform/comapi/NativeLoader:getCustomizeNativePath	()Ljava/lang/String;
    //   46: aload_1
    //   47: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_3
    //   52: astore_2
    //   53: aload_3
    //   54: aload 4
    //   56: invokevirtual 200	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnonnull +13 -> 76
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 203	java/util/zip/ZipFile:close	()V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_3
    //   77: astore_2
    //   78: aload_0
    //   79: aload_3
    //   80: aload 4
    //   82: invokevirtual 207	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   85: new 209	java/io/FileOutputStream
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 212	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: invokevirtual 216	com/baidu/platform/comapi/NativeLoader:copyStream	(Ljava/io/InputStream;Ljava/io/FileOutputStream;)V
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 203	java/util/zip/ZipFile:close	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: ldc 2
    //   114: invokevirtual 101	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   117: ldc -38
    //   119: aload 4
    //   121: invokestatic 108	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   124: pop
    //   125: aload_1
    //   126: ifnull -52 -> 74
    //   129: aload_1
    //   130: invokevirtual 203	java/util/zip/ZipFile:close	()V
    //   133: iconst_0
    //   134: ireturn
    //   135: astore_1
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 203	java/util/zip/ZipFile:close	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_1
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_1
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: goto -20 -> 141
    //   164: astore 4
    //   166: aload_3
    //   167: astore_1
    //   168: goto -58 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	NativeLoader
    //   0	171	1	paramString	String
    //   0	171	2	parama	a
    //   35	132	3	localZipFile	java.util.zip.ZipFile
    //   22	59	4	localObject	Object
    //   106	14	4	localException1	Exception
    //   164	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	36	106	java/lang/Exception
    //   129	133	135	java/io/IOException
    //   24	36	138	finally
    //   70	74	151	java/io/IOException
    //   100	104	154	java/io/IOException
    //   145	149	157	java/io/IOException
    //   38	51	160	finally
    //   53	61	160	finally
    //   78	96	160	finally
    //   112	125	160	finally
    //   38	51	164	java/lang/Exception
    //   53	61	164	java/lang/Exception
    //   78	96	164	java/lang/Exception
  }
  
  /* Error */
  protected final void copyStream(java.io.InputStream paramInputStream, java.io.FileOutputStream paramFileOutputStream)
    throws java.io.IOException
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray <illegal type>
    //   5: astore 4
    //   7: aload_1
    //   8: aload 4
    //   10: invokevirtual 224	java/io/InputStream:read	([B)I
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_m1
    //   16: if_icmpeq +27 -> 43
    //   19: aload_2
    //   20: aload 4
    //   22: iconst_0
    //   23: iload_3
    //   24: invokevirtual 228	java/io/FileOutputStream:write	([BII)V
    //   27: goto -20 -> 7
    //   30: astore 4
    //   32: aload_1
    //   33: invokevirtual 229	java/io/InputStream:close	()V
    //   36: aload_2
    //   37: invokevirtual 230	java/io/FileOutputStream:close	()V
    //   40: aload 4
    //   42: athrow
    //   43: aload_2
    //   44: invokevirtual 233	java/io/FileOutputStream:flush	()V
    //   47: aload_1
    //   48: invokevirtual 229	java/io/InputStream:close	()V
    //   51: aload_2
    //   52: invokevirtual 230	java/io/FileOutputStream:close	()V
    //   55: return
    //   56: astore_1
    //   57: return
    //   58: astore_1
    //   59: return
    //   60: astore_1
    //   61: return
    //   62: astore_1
    //   63: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	NativeLoader
    //   0	64	1	paramInputStream	java.io.InputStream
    //   0	64	2	paramFileOutputStream	java.io.FileOutputStream
    //   13	11	3	i	int
    //   5	16	4	arrayOfByte	byte[]
    //   30	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	30	finally
    //   19	27	30	finally
    //   43	47	30	finally
    //   47	51	56	java/io/IOException
    //   51	55	58	java/io/IOException
    //   32	36	60	java/io/IOException
    //   36	40	62	java/io/IOException
  }
  
  @TargetApi(8)
  protected String getCodePath()
  {
    if (8 <= Build.VERSION.SDK_INT) {
      return a.getPackageCodePath();
    }
    return "";
  }
  
  protected String getCustomizeNativePath()
  {
    File localFile = new File(a.getFilesDir(), "libs");
    localFile.mkdirs();
    return localFile.getAbsolutePath();
  }
  
  protected boolean loadCustomizeNativeLibrary(String paramString)
  {
    String str = System.mapLibraryName(paramString);
    switch (1.a[e.ordinal()])
    {
    default: 
      return false;
    case 1: 
      return c(paramString, str);
    case 2: 
      return a(paramString, str);
    case 3: 
      return b(paramString, str);
    case 4: 
      return e(paramString, str);
    }
    return d(paramString, str);
  }
  
  /* Error */
  public boolean loadLibrary(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 27	com/baidu/platform/comapi/NativeLoader:b	Ljava/util/Set;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: getstatic 27	com/baidu/platform/comapi/NativeLoader:b	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 274 2 0
    //   19: ifeq +9 -> 28
    //   22: aload_3
    //   23: monitorexit
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: aload_3
    //   29: monitorexit
    //   30: aload_1
    //   31: invokestatic 276	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   34: getstatic 27	com/baidu/platform/comapi/NativeLoader:b	Ljava/util/Set;
    //   37: astore_3
    //   38: aload_3
    //   39: monitorenter
    //   40: getstatic 27	com/baidu/platform/comapi/NativeLoader:b	Ljava/util/Set;
    //   43: aload_1
    //   44: invokeinterface 170 2 0
    //   49: pop
    //   50: aload_3
    //   51: monitorexit
    //   52: goto -28 -> 24
    //   55: astore 4
    //   57: aload_3
    //   58: monitorexit
    //   59: aload 4
    //   61: athrow
    //   62: astore_3
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 278	com/baidu/platform/comapi/NativeLoader:loadCustomizeNativeLibrary	(Ljava/lang/String;)Z
    //   68: istore_2
    //   69: goto -45 -> 24
    //   72: astore 4
    //   74: aload_3
    //   75: monitorexit
    //   76: aload 4
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	NativeLoader
    //   0	84	1	paramString	String
    //   1	68	2	bool	boolean
    //   62	13	3	localThrowable	Throwable
    //   55	5	4	localObject1	Object
    //   72	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	52	55	finally
    //   57	59	55	finally
    //   4	10	62	java/lang/Throwable
    //   30	40	62	java/lang/Throwable
    //   59	62	62	java/lang/Throwable
    //   76	79	62	java/lang/Throwable
    //   10	24	72	finally
    //   28	30	72	finally
    //   74	76	72	finally
    //   4	10	79	finally
    //   30	40	79	finally
    //   59	62	79	finally
    //   63	69	79	finally
    //   76	79	79	finally
  }
  
  private static enum a
  {
    private String f;
    
    private a(String paramString)
    {
      this.f = paramString;
    }
    
    public String a()
    {
      return this.f;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/NativeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */