package com.baidu.trace;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class av
{
  private static Context a;
  private static final Set<String> b = new HashSet();
  private static final Set<String> c = new HashSet();
  private static av d;
  private static a e = a.a;
  
  /* Error */
  public static av a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	com/baidu/trace/av:d	Lcom/baidu/trace/av;
    //   6: ifnonnull +37 -> 43
    //   9: new 2	com/baidu/trace/av
    //   12: dup
    //   13: invokespecial 39	com/baidu/trace/av:<init>	()V
    //   16: putstatic 38	com/baidu/trace/av:d	Lcom/baidu/trace/av;
    //   19: getstatic 45	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 21
    //   24: if_icmpge +28 -> 52
    //   27: getstatic 51	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnonnull +29 -> 61
    //   35: getstatic 31	com/baidu/trace/av$a:a	Lcom/baidu/trace/av$a;
    //   38: astore_0
    //   39: aload_0
    //   40: putstatic 33	com/baidu/trace/av:e	Lcom/baidu/trace/av$a;
    //   43: getstatic 38	com/baidu/trace/av:d	Lcom/baidu/trace/av;
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: getstatic 55	android/os/Build:SUPPORTED_ABIS	[Ljava/lang/String;
    //   55: iconst_0
    //   56: aaload
    //   57: astore_0
    //   58: goto -27 -> 31
    //   61: aload_0
    //   62: ldc 57
    //   64: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +18 -> 85
    //   70: aload_0
    //   71: ldc 65
    //   73: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +9 -> 85
    //   79: getstatic 67	com/baidu/trace/av$a:b	Lcom/baidu/trace/av$a;
    //   82: putstatic 33	com/baidu/trace/av:e	Lcom/baidu/trace/av$a;
    //   85: aload_0
    //   86: ldc 57
    //   88: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   91: ifeq +18 -> 109
    //   94: aload_0
    //   95: ldc 69
    //   97: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifeq +9 -> 109
    //   103: getstatic 71	com/baidu/trace/av$a:c	Lcom/baidu/trace/av$a;
    //   106: putstatic 33	com/baidu/trace/av:e	Lcom/baidu/trace/av$a;
    //   109: aload_0
    //   110: ldc 73
    //   112: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   115: ifeq +18 -> 133
    //   118: aload_0
    //   119: ldc 69
    //   121: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +16 -> 140
    //   127: getstatic 74	com/baidu/trace/av$a:e	Lcom/baidu/trace/av$a;
    //   130: putstatic 33	com/baidu/trace/av:e	Lcom/baidu/trace/av$a;
    //   133: getstatic 33	com/baidu/trace/av:e	Lcom/baidu/trace/av$a;
    //   136: astore_0
    //   137: goto -98 -> 39
    //   140: getstatic 76	com/baidu/trace/av$a:d	Lcom/baidu/trace/av$a;
    //   143: putstatic 33	com/baidu/trace/av:e	Lcom/baidu/trace/av$a;
    //   146: goto -13 -> 133
    //   149: astore_0
    //   150: ldc 2
    //   152: monitorexit
    //   153: aload_0
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	107	0	localObject1	Object
    //   149	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	31	149	finally
    //   35	39	149	finally
    //   39	43	149	finally
    //   43	47	149	finally
    //   52	58	149	finally
    //   61	85	149	finally
    //   85	109	149	finally
    //   109	133	149	finally
    //   133	137	149	finally
    //   140	146	149	finally
  }
  
  public static void a(Context paramContext)
  {
    if (a == null) {
      a = paramContext;
    }
  }
  
  /* Error */
  private static void a(java.io.InputStream paramInputStream, java.io.FileOutputStream paramFileOutputStream)
    throws java.io.IOException
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray <illegal type>
    //   5: astore_3
    //   6: aload_0
    //   7: aload_3
    //   8: invokevirtual 88	java/io/InputStream:read	([B)I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpeq +24 -> 38
    //   17: aload_1
    //   18: aload_3
    //   19: iconst_0
    //   20: iload_2
    //   21: invokevirtual 94	java/io/FileOutputStream:write	([BII)V
    //   24: goto -18 -> 6
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 97	java/io/InputStream:close	()V
    //   32: aload_1
    //   33: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   36: aload_3
    //   37: athrow
    //   38: aload_1
    //   39: invokevirtual 101	java/io/FileOutputStream:flush	()V
    //   42: aload_0
    //   43: invokevirtual 97	java/io/InputStream:close	()V
    //   46: aload_1
    //   47: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   50: return
    //   51: astore_0
    //   52: return
    //   53: astore_0
    //   54: return
    //   55: astore_0
    //   56: return
    //   57: astore_0
    //   58: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramInputStream	java.io.InputStream
    //   0	59	1	paramFileOutputStream	java.io.FileOutputStream
    //   11	10	2	i	int
    //   5	14	3	arrayOfByte	byte[]
    //   27	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	27	finally
    //   17	24	27	finally
    //   38	42	27	finally
    //   42	46	51	java/io/IOException
    //   46	50	53	java/io/IOException
    //   28	32	55	java/io/IOException
    //   32	36	57	java/io/IOException
  }
  
  private static void a(Throwable paramThrowable)
  {
    Log.e(av.class.getSimpleName(), "loadException", paramThrowable);
    paramThrowable = c.iterator();
    while (paramThrowable.hasNext())
    {
      String str = (String)paramThrowable.next();
      Log.e(av.class.getSimpleName(), str + " Failed to load.");
    }
  }
  
  /* Error */
  private boolean a(String paramString, a parama)
  {
    // Byte code:
    //   0: new 134	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: new 134	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   15: astore 4
    //   17: aload 4
    //   19: ldc -104
    //   21: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: invokevirtual 154	com/baidu/trace/av$a:b	()Ljava/lang/String;
    //   28: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc -100
    //   33: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_3
    //   38: aload 4
    //   40: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore 6
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 4
    //   61: aload 5
    //   63: astore_2
    //   64: bipush 8
    //   66: getstatic 45	android/os/Build$VERSION:SDK_INT	I
    //   69: if_icmpgt +54 -> 123
    //   72: aload 5
    //   74: astore_2
    //   75: getstatic 79	com/baidu/trace/av:a	Landroid/content/Context;
    //   78: invokevirtual 161	android/content/Context:getPackageCodePath	()Ljava/lang/String;
    //   81: astore_3
    //   82: aload 5
    //   84: astore_2
    //   85: new 163	java/util/zip/ZipFile
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 166	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: new 168	java/io/File
    //   97: dup
    //   98: invokestatic 169	com/baidu/trace/av:b	()Ljava/lang/String;
    //   101: aload_1
    //   102: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_3
    //   107: aload 6
    //   109: invokevirtual 176	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   112: astore_2
    //   113: aload_2
    //   114: ifnonnull +15 -> 129
    //   117: aload_3
    //   118: invokevirtual 177	java/util/zip/ZipFile:close	()V
    //   121: iconst_0
    //   122: ireturn
    //   123: ldc -77
    //   125: astore_3
    //   126: goto -44 -> 82
    //   129: aload_3
    //   130: aload_2
    //   131: invokevirtual 183	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   134: new 90	java/io/FileOutputStream
    //   137: dup
    //   138: aload_1
    //   139: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: invokestatic 188	com/baidu/trace/av:a	(Ljava/io/InputStream;Ljava/io/FileOutputStream;)V
    //   145: aload_3
    //   146: invokevirtual 177	java/util/zip/ZipFile:close	()V
    //   149: iconst_1
    //   150: ireturn
    //   151: astore_3
    //   152: aload 4
    //   154: astore_1
    //   155: aload_1
    //   156: astore_2
    //   157: ldc 2
    //   159: invokevirtual 109	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   162: ldc -66
    //   164: aload_3
    //   165: invokestatic 116	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   168: pop
    //   169: aload_1
    //   170: ifnull -49 -> 121
    //   173: aload_1
    //   174: invokevirtual 177	java/util/zip/ZipFile:close	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_1
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_1
    //   183: aload_2
    //   184: ifnull +7 -> 191
    //   187: aload_2
    //   188: invokevirtual 177	java/util/zip/ZipFile:close	()V
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_1
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_1
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_1
    //   203: aload_3
    //   204: astore_2
    //   205: goto -22 -> 183
    //   208: astore_2
    //   209: aload_3
    //   210: astore_1
    //   211: aload_2
    //   212: astore_3
    //   213: goto -58 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	av
    //   0	216	1	paramString	String
    //   0	216	2	parama	a
    //   7	139	3	localObject1	Object
    //   151	59	3	localException	Exception
    //   212	1	3	locala	a
    //   15	138	4	localStringBuilder	StringBuilder
    //   56	27	5	localObject2	Object
    //   53	55	6	str	String
    // Exception table:
    //   from	to	target	type
    //   64	72	151	java/lang/Exception
    //   75	82	151	java/lang/Exception
    //   85	94	151	java/lang/Exception
    //   173	177	179	java/io/IOException
    //   64	72	182	finally
    //   75	82	182	finally
    //   85	94	182	finally
    //   157	169	182	finally
    //   117	121	193	java/io/IOException
    //   145	149	196	java/io/IOException
    //   187	191	199	java/io/IOException
    //   94	113	202	finally
    //   129	145	202	finally
    //   94	113	208	java/lang/Exception
    //   129	145	208	java/lang/Exception
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!a(paramString2, a.b)) {
      return b(paramString1, paramString2);
    }
    return d(paramString2, paramString1);
  }
  
  private static String b()
  {
    File localFile = new File(a.getFilesDir(), "libs");
    localFile.mkdirs();
    return localFile.getAbsolutePath();
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (a(paramString2, a.a)) {
      return d(paramString2, paramString1);
    }
    return false;
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    if (!a(paramString2, a.d)) {
      return a(paramString1, paramString2);
    }
    return d(paramString2, paramString1);
  }
  
  /* Error */
  private boolean d(String arg1, String paramString2)
  {
    // Byte code:
    //   0: new 168	java/io/File
    //   3: dup
    //   4: invokestatic 169	com/baidu/trace/av:b	()Ljava/lang/String;
    //   7: aload_1
    //   8: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: invokevirtual 212	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   14: invokestatic 221	java/lang/System:load	(Ljava/lang/String;)V
    //   17: getstatic 27	com/baidu/trace/av:b	Ljava/util/Set;
    //   20: astore_1
    //   21: aload_1
    //   22: monitorenter
    //   23: getstatic 27	com/baidu/trace/av:b	Ljava/util/Set;
    //   26: aload_2
    //   27: invokeinterface 225 2 0
    //   32: pop
    //   33: aload_1
    //   34: monitorexit
    //   35: iconst_1
    //   36: ireturn
    //   37: astore_3
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    //   42: astore_3
    //   43: getstatic 29	com/baidu/trace/av:c	Ljava/util/Set;
    //   46: astore_1
    //   47: aload_1
    //   48: monitorenter
    //   49: getstatic 29	com/baidu/trace/av:c	Ljava/util/Set;
    //   52: aload_2
    //   53: invokeinterface 225 2 0
    //   58: pop
    //   59: aload_1
    //   60: monitorexit
    //   61: aload_3
    //   62: invokestatic 227	com/baidu/trace/av:a	(Ljava/lang/Throwable;)V
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_2
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	av
    //   0	72	2	paramString2	String
    //   37	4	3	localObject	Object
    //   42	20	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   23	35	37	finally
    //   0	23	42	java/lang/Throwable
    //   38	42	42	java/lang/Throwable
    //   49	61	67	finally
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 27	com/baidu/trace/av:b	Ljava/util/Set;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: getstatic 27	com/baidu/trace/av:b	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 230 2 0
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
    //   31: invokestatic 233	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   34: getstatic 27	com/baidu/trace/av:b	Ljava/util/Set;
    //   37: astore_3
    //   38: aload_3
    //   39: monitorenter
    //   40: getstatic 27	com/baidu/trace/av:b	Ljava/util/Set;
    //   43: aload_1
    //   44: invokeinterface 225 2 0
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
    //   63: aload_1
    //   64: invokestatic 237	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore_3
    //   68: iconst_0
    //   69: istore_2
    //   70: getstatic 240	com/baidu/trace/av$1:a	[I
    //   73: getstatic 33	com/baidu/trace/av:e	Lcom/baidu/trace/av$a;
    //   76: invokevirtual 244	com/baidu/trace/av$a:ordinal	()I
    //   79: iaload
    //   80: tableswitch	default:+140->220, 1:+36->116, 2:+79->159, 3:+89->169, 4:+99->179, 5:+130->210
    //   116: aload_0
    //   117: aload_3
    //   118: getstatic 71	com/baidu/trace/av$a:c	Lcom/baidu/trace/av$a;
    //   121: invokespecial 193	com/baidu/trace/av:a	(Ljava/lang/String;Lcom/baidu/trace/av$a;)Z
    //   124: ifne +25 -> 149
    //   127: aload_0
    //   128: aload_1
    //   129: aload_3
    //   130: invokespecial 214	com/baidu/trace/av:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   133: istore_2
    //   134: goto -110 -> 24
    //   137: astore 4
    //   139: aload_3
    //   140: monitorexit
    //   141: aload 4
    //   143: athrow
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    //   149: aload_0
    //   150: aload_3
    //   151: aload_1
    //   152: invokespecial 197	com/baidu/trace/av:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   155: istore_2
    //   156: goto -132 -> 24
    //   159: aload_0
    //   160: aload_1
    //   161: aload_3
    //   162: invokespecial 214	com/baidu/trace/av:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   165: istore_2
    //   166: goto -142 -> 24
    //   169: aload_0
    //   170: aload_1
    //   171: aload_3
    //   172: invokespecial 195	com/baidu/trace/av:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   175: istore_2
    //   176: goto -152 -> 24
    //   179: aload_0
    //   180: aload_3
    //   181: getstatic 74	com/baidu/trace/av$a:e	Lcom/baidu/trace/av$a;
    //   184: invokespecial 193	com/baidu/trace/av:a	(Ljava/lang/String;Lcom/baidu/trace/av$a;)Z
    //   187: ifne +13 -> 200
    //   190: aload_0
    //   191: aload_1
    //   192: aload_3
    //   193: invokespecial 246	com/baidu/trace/av:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   196: istore_2
    //   197: goto -173 -> 24
    //   200: aload_0
    //   201: aload_3
    //   202: aload_1
    //   203: invokespecial 197	com/baidu/trace/av:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   206: istore_2
    //   207: goto -183 -> 24
    //   210: aload_0
    //   211: aload_1
    //   212: aload_3
    //   213: invokespecial 246	com/baidu/trace/av:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   216: istore_2
    //   217: goto -193 -> 24
    //   220: goto -196 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	av
    //   0	223	1	paramString	String
    //   1	216	2	bool	boolean
    //   62	1	3	localThrowable	Throwable
    //   67	146	3	str	String
    //   55	5	4	localObject1	Object
    //   137	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	52	55	finally
    //   4	10	62	java/lang/Throwable
    //   28	40	62	java/lang/Throwable
    //   57	62	62	java/lang/Throwable
    //   139	144	62	java/lang/Throwable
    //   10	24	137	finally
    //   4	10	144	finally
    //   28	40	144	finally
    //   57	62	144	finally
    //   63	68	144	finally
    //   70	116	144	finally
    //   116	134	144	finally
    //   139	144	144	finally
    //   149	156	144	finally
    //   159	166	144	finally
    //   169	176	144	finally
    //   179	197	144	finally
    //   200	207	144	finally
    //   210	217	144	finally
  }
  
  static enum a
  {
    private String f;
    
    private a(String paramString)
    {
      this.f = paramString;
    }
    
    public static a[] a()
    {
      return (a[])g.clone();
    }
    
    public final String b()
    {
      return this.f;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */