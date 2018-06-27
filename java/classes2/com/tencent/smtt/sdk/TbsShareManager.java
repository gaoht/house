package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import java.io.File;
import java.io.IOException;

public class TbsShareManager
{
  private static Context a;
  private static boolean b;
  private static String c = null;
  private static int d = 0;
  private static String e = null;
  private static boolean f = false;
  private static boolean g = false;
  private static String h = null;
  private static boolean i = false;
  private static boolean j = false;
  
  static int a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, paramBoolean);
    return d;
  }
  
  static Context a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  static void a(Context paramContext)
  {
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      a(paramContext, localTbsLinuxToolsJni, ai.a().g(paramContext));
      localTbsLinuxToolsJni.a(ai.a().h(paramContext).getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int m = paramFile.length;
    int k = 0;
    label41:
    File localFile;
    if (k < m)
    {
      localFile = paramFile[k];
      if (!localFile.isFile()) {
        break label107;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label92;
      }
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      k += 1;
      break label41;
      break;
      label92:
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "644");
      continue;
      label107:
      if (localFile.isDirectory()) {
        a(paramContext, paramTbsLinuxToolsJni, localFile);
      } else {
        TbsLog.e("TbsShareManager", "unknown file type.", true);
      }
    }
  }
  
  private static File b(Context paramContext, String paramString)
  {
    paramContext = ai.a().h(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
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
  
  static String b(Context paramContext)
  {
    h(paramContext);
    return c;
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    if (g(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static int c(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ldc -104
    //   9: invokestatic 154	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   12: astore 9
    //   14: aload 9
    //   16: ifnonnull +28 -> 44
    //   19: iconst_0
    //   20: ifeq +11 -> 31
    //   23: new 156	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 156	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: return
    //   44: new 159	java/io/BufferedInputStream
    //   47: dup
    //   48: new 161	java/io/FileInputStream
    //   51: dup
    //   52: aload 9
    //   54: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_3
    //   61: new 169	java/util/Properties
    //   64: dup
    //   65: invokespecial 170	java/util/Properties:<init>	()V
    //   68: astore 6
    //   70: aload 6
    //   72: aload_3
    //   73: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   76: aload 6
    //   78: ldc -81
    //   80: iconst_0
    //   81: invokestatic 179	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   84: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   87: pop
    //   88: iload_1
    //   89: ifeq +61 -> 150
    //   92: invokestatic 70	com/tencent/smtt/sdk/ai:a	()Lcom/tencent/smtt/sdk/ai;
    //   95: aload_0
    //   96: invokevirtual 73	com/tencent/smtt/sdk/ai:g	(Landroid/content/Context;)Ljava/io/File;
    //   99: invokevirtual 84	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   102: astore 8
    //   104: aload_0
    //   105: invokevirtual 187	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   108: invokevirtual 190	android/content/Context:getPackageName	()Ljava/lang/String;
    //   111: astore 7
    //   113: aload_0
    //   114: invokestatic 194	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   117: istore_2
    //   118: aload 6
    //   120: ldc -60
    //   122: aload 7
    //   124: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   127: pop
    //   128: aload 6
    //   130: ldc -58
    //   132: aload 8
    //   134: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   137: pop
    //   138: aload 6
    //   140: ldc -56
    //   142: iload_2
    //   143: invokestatic 203	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   146: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   149: pop
    //   150: new 205	java/io/BufferedOutputStream
    //   153: dup
    //   154: new 207	java/io/FileOutputStream
    //   157: dup
    //   158: aload 9
    //   160: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   163: invokespecial 211	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   166: astore_0
    //   167: aload 6
    //   169: aload_0
    //   170: aconst_null
    //   171: invokevirtual 215	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   182: aload_0
    //   183: ifnull -140 -> 43
    //   186: aload_0
    //   187: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   190: return
    //   191: astore_0
    //   192: return
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_0
    //   197: aload 5
    //   199: astore_3
    //   200: aload 4
    //   202: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   213: aload_3
    //   214: ifnull -171 -> 43
    //   217: aload_3
    //   218: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   221: return
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   233: aload 4
    //   235: ifnull +8 -> 243
    //   238: aload 4
    //   240: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   243: aload_0
    //   244: athrow
    //   245: astore_3
    //   246: goto -13 -> 233
    //   249: astore_3
    //   250: goto -7 -> 243
    //   253: astore_0
    //   254: goto -41 -> 213
    //   257: astore_0
    //   258: goto -227 -> 31
    //   261: astore_3
    //   262: goto -80 -> 182
    //   265: astore_0
    //   266: goto -41 -> 225
    //   269: astore 5
    //   271: aload_0
    //   272: astore 4
    //   274: aload 5
    //   276: astore_0
    //   277: goto -52 -> 225
    //   280: astore 4
    //   282: aload_0
    //   283: astore 5
    //   285: aload 4
    //   287: astore_0
    //   288: aload_3
    //   289: astore 4
    //   291: aload 5
    //   293: astore_3
    //   294: goto -69 -> 225
    //   297: astore 4
    //   299: aload_3
    //   300: astore_0
    //   301: aload 5
    //   303: astore_3
    //   304: goto -104 -> 200
    //   307: astore 4
    //   309: aload_3
    //   310: astore 5
    //   312: aload_0
    //   313: astore_3
    //   314: aload 5
    //   316: astore_0
    //   317: goto -117 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   0	320	1	paramBoolean	boolean
    //   117	26	2	k	int
    //   60	170	3	localObject1	Object
    //   245	1	3	localException1	Exception
    //   249	1	3	localException2	Exception
    //   261	28	3	localException3	Exception
    //   293	21	3	localObject2	Object
    //   1	1	4	localObject3	Object
    //   193	46	4	localThrowable1	Throwable
    //   272	1	4	localContext	Context
    //   280	6	4	localObject4	Object
    //   289	1	4	localObject5	Object
    //   297	1	4	localThrowable2	Throwable
    //   307	1	4	localThrowable3	Throwable
    //   4	194	5	localObject6	Object
    //   269	6	5	localObject7	Object
    //   283	32	5	localObject8	Object
    //   68	100	6	localProperties	java.util.Properties
    //   111	12	7	str1	String
    //   102	31	8	str2	String
    //   12	147	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   35	43	191	java/lang/Exception
    //   186	190	191	java/lang/Exception
    //   217	221	191	java/lang/Exception
    //   6	14	193	java/lang/Throwable
    //   44	61	193	java/lang/Throwable
    //   6	14	222	finally
    //   44	61	222	finally
    //   229	233	245	java/lang/Exception
    //   238	243	249	java/lang/Exception
    //   209	213	253	java/lang/Exception
    //   23	31	257	java/lang/Exception
    //   178	182	261	java/lang/Exception
    //   61	88	265	finally
    //   92	150	265	finally
    //   150	167	265	finally
    //   167	174	269	finally
    //   200	205	280	finally
    //   61	88	297	java/lang/Throwable
    //   92	150	297	java/lang/Throwable
    //   150	167	297	java/lang/Throwable
    //   167	174	307	java/lang/Throwable
  }
  
  static Context d(Context paramContext)
  {
    h(paramContext);
    if (e != null)
    {
      paramContext = a(paramContext, e);
      if (ai.a().b(paramContext)) {}
    }
    else
    {
      return null;
    }
    return paramContext;
  }
  
  /* Error */
  static String e(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc -104
    //   9: invokestatic 154	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +23 -> 37
    //   17: aload 4
    //   19: astore_0
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 156	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: new 159	java/io/BufferedInputStream
    //   40: dup
    //   41: new 161	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: new 169	java/util/Properties
    //   58: dup
    //   59: invokespecial 170	java/util/Properties:<init>	()V
    //   62: astore_3
    //   63: aload_2
    //   64: astore_0
    //   65: aload_3
    //   66: aload_2
    //   67: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_2
    //   71: astore_0
    //   72: aload_3
    //   73: ldc -60
    //   75: ldc -30
    //   77: invokevirtual 230	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_2
    //   82: astore_0
    //   83: ldc -30
    //   85: aload_3
    //   86: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: istore_1
    //   90: iload_1
    //   91: ifne +76 -> 167
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   102: aload_3
    //   103: astore_0
    //   104: goto -72 -> 32
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_0
    //   112: aload_3
    //   113: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   116: aload 4
    //   118: astore_0
    //   119: aload_2
    //   120: ifnull -88 -> 32
    //   123: aload_2
    //   124: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   127: aload 4
    //   129: astore_0
    //   130: goto -98 -> 32
    //   133: astore_0
    //   134: aload 4
    //   136: astore_0
    //   137: goto -105 -> 32
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   151: aload_2
    //   152: athrow
    //   153: astore_0
    //   154: ldc 2
    //   156: monitorexit
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: goto -9 -> 151
    //   163: astore_0
    //   164: goto -62 -> 102
    //   167: aload 4
    //   169: astore_0
    //   170: aload_2
    //   171: ifnull -139 -> 32
    //   174: aload_2
    //   175: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   178: aload 4
    //   180: astore_0
    //   181: goto -149 -> 32
    //   184: astore_2
    //   185: goto -42 -> 143
    //   188: astore_3
    //   189: goto -79 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   89	2	1	bool	boolean
    //   52	72	2	localBufferedInputStream	java.io.BufferedInputStream
    //   140	35	2	localObject1	Object
    //   184	1	2	localObject2	Object
    //   62	41	3	localObject3	Object
    //   107	6	3	localThrowable1	Throwable
    //   188	1	3	localThrowable2	Throwable
    //   1	178	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	107	java/lang/Throwable
    //   37	53	107	java/lang/Throwable
    //   24	32	133	java/lang/Exception
    //   123	127	133	java/lang/Exception
    //   174	178	133	java/lang/Exception
    //   6	13	140	finally
    //   37	53	140	finally
    //   24	32	153	finally
    //   98	102	153	finally
    //   123	127	153	finally
    //   147	151	153	finally
    //   151	153	153	finally
    //   174	178	153	finally
    //   147	151	159	java/lang/Exception
    //   98	102	163	java/lang/Exception
    //   55	63	184	finally
    //   65	70	184	finally
    //   72	81	184	finally
    //   83	90	184	finally
    //   112	116	184	finally
    //   55	63	188	java/lang/Throwable
    //   65	70	188	java/lang/Throwable
    //   72	81	188	java/lang/Throwable
    //   83	90	188	java/lang/Throwable
  }
  
  /* Error */
  static int f(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ldc -104
    //   8: invokestatic 154	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnonnull +22 -> 35
    //   16: iload_2
    //   17: istore_1
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 156	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: new 159	java/io/BufferedInputStream
    //   38: dup
    //   39: new 161	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_3
    //   51: aload_3
    //   52: astore_0
    //   53: new 169	java/util/Properties
    //   56: dup
    //   57: invokespecial 170	java/util/Properties:<init>	()V
    //   60: astore 4
    //   62: aload_3
    //   63: astore_0
    //   64: aload 4
    //   66: aload_3
    //   67: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_3
    //   71: astore_0
    //   72: aload 4
    //   74: ldc -20
    //   76: ldc -30
    //   78: invokevirtual 230	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 4
    //   83: aload_3
    //   84: astore_0
    //   85: ldc -30
    //   87: aload 4
    //   89: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +110 -> 202
    //   95: aload_3
    //   96: astore_0
    //   97: aload 4
    //   99: invokestatic 241	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   102: iconst_0
    //   103: invokestatic 247	java/lang/Math:max	(II)I
    //   106: istore_2
    //   107: iload_2
    //   108: istore_1
    //   109: aload_3
    //   110: ifnull -80 -> 30
    //   113: aload_3
    //   114: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   117: iload_2
    //   118: istore_1
    //   119: goto -89 -> 30
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   127: iload_2
    //   128: istore_1
    //   129: goto -99 -> 30
    //   132: astore_0
    //   133: ldc 2
    //   135: monitorexit
    //   136: aload_0
    //   137: athrow
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_3
    //   142: aload_3
    //   143: astore_0
    //   144: aload 4
    //   146: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   149: aload_3
    //   150: ifnull +7 -> 157
    //   153: aload_3
    //   154: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   157: bipush -2
    //   159: istore_1
    //   160: goto -130 -> 30
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   181: goto -7 -> 174
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   189: goto -32 -> 157
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   197: iload_2
    //   198: istore_1
    //   199: goto -169 -> 30
    //   202: iload_2
    //   203: istore_1
    //   204: aload_3
    //   205: ifnull -175 -> 30
    //   208: aload_3
    //   209: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   212: iload_2
    //   213: istore_1
    //   214: goto -184 -> 30
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   222: iload_2
    //   223: istore_1
    //   224: goto -194 -> 30
    //   227: astore_3
    //   228: goto -62 -> 166
    //   231: astore 4
    //   233: goto -91 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramContext	Context
    //   17	207	1	k	int
    //   1	222	2	m	int
    //   50	104	3	localBufferedInputStream	java.io.BufferedInputStream
    //   163	46	3	localObject1	Object
    //   227	1	3	localObject2	Object
    //   60	38	4	localObject3	Object
    //   138	7	4	localThrowable1	Throwable
    //   231	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   113	117	122	java/lang/Exception
    //   22	30	132	finally
    //   113	117	132	finally
    //   123	127	132	finally
    //   153	157	132	finally
    //   170	174	132	finally
    //   174	176	132	finally
    //   177	181	132	finally
    //   185	189	132	finally
    //   193	197	132	finally
    //   208	212	132	finally
    //   218	222	132	finally
    //   5	12	138	java/lang/Throwable
    //   35	51	138	java/lang/Throwable
    //   5	12	163	finally
    //   35	51	163	finally
    //   170	174	176	java/lang/Exception
    //   153	157	184	java/lang/Exception
    //   22	30	192	java/lang/Exception
    //   208	212	217	java/lang/Exception
    //   53	62	227	finally
    //   64	70	227	finally
    //   72	83	227	finally
    //   85	95	227	finally
    //   97	107	227	finally
    //   144	149	227	finally
    //   53	62	231	java/lang/Throwable
    //   64	70	231	java/lang/Throwable
    //   72	83	231	java/lang/Throwable
    //   85	95	231	java/lang/Throwable
    //   97	107	231	java/lang/Throwable
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    l(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + d + " mAvailableCorePath is " + c + " mSrcPackageName is " + e);
    if ((!i(paramContext)) && (!j(paramContext)))
    {
      d = 0;
      c = null;
      e = null;
      TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
    }
    if ((d > 0) && ((QbSdk.a(paramContext, d)) || (f)))
    {
      d = 0;
      c = null;
      e = null;
      TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
    }
    return d;
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    if ((paramContext == null) || (ai.a().a(paramContext, null))) {}
    int k;
    do
    {
      return false;
      k = getSharedTbsCoreVersion(paramContext, "com.tencent.x5sdk.demo");
    } while (k <= 0);
    Object localObject = a(paramContext, "com.tencent.x5sdk.demo");
    localObject = ai.a().g((Context)localObject).getAbsolutePath();
    writeProperties(paramContext, Integer.toString(k), "com.tencent.x5sdk.demo", (String)localObject, "1");
    return true;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean)
  {
    int k = 0;
    try
    {
      if (!isThirdPartyApp(paramContext)) {
        return;
      }
      Object localObject = ai.a().h(paramContext);
      if (localObject != null) {
        if (paramBoolean)
        {
          localObject = new File((File)localObject, "core_info");
          if ((localObject != null) && (((File)localObject).exists())) {}
        }
        else
        {
          localObject = getCoreProviderAppList();
          int m = localObject.length;
          while (k < m)
          {
            String str = localObject[k];
            int n = getSharedTbsCoreVersion(paramContext, str);
            if (n > 0)
            {
              Context localContext = a(paramContext, str);
              c = ai.a().b(paramContext, localContext).getAbsolutePath();
              e = str;
              d = n;
              if (QbSdk.canLoadX5FirstTimeThirdApp(paramContext))
              {
                k = b.b(paramContext);
                writeProperties(paramContext, Integer.toString(d), e, c, Integer.toString(k));
                return;
              }
              d = 0;
              c = null;
              e = null;
            }
            k += 1;
          }
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  static boolean g(Context paramContext)
  {
    try
    {
      if (d == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (d == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        return false;
      }
      if ((d != 0) && (getSharedTbsCoreVersion(paramContext, e) == d)) {
        return true;
      }
      c = null;
      d = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.addLog(992, null, new Object[0]);
    }
    return false;
  }
  
  public static boolean getCoreDisabled()
  {
    return f;
  }
  
  public static boolean getCoreFormOwn()
  {
    return i;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.x5sdk.demo", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone" };
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    String[] arrayOfString = getCoreProviderAppList();
    int m = arrayOfString.length;
    long l2 = 0L;
    int k = 0;
    if (k < m)
    {
      String str = arrayOfString[k];
      long l1;
      if (str.equalsIgnoreCase("com.tencent.mm")) {
        l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 10000000000L;
      }
      for (;;)
      {
        k += 1;
        l2 = l1;
        break;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 100000L;
        }
        else
        {
          l1 = l2;
          if (str.equalsIgnoreCase("com.qzone")) {
            l1 = l2 + getSharedTbsCoreVersion(paramContext, str);
          }
        }
      }
    }
    return l2;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    if (paramContext != null) {
      return ai.a().c(paramContext);
    }
    return 0;
  }
  
  static boolean h(Context paramContext)
  {
    return b(paramContext, true);
  }
  
  private static boolean i(Context paramContext)
  {
    if (e == null) {}
    while (d != getSharedTbsCoreVersion(paramContext, e)) {
      return false;
    }
    return true;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    for (;;)
    {
      int k;
      try
      {
        if ((a != null) && (a.equals(paramContext.getApplicationContext()))) {
          return b;
        }
        a = paramContext.getApplicationContext();
        paramContext = a.getPackageName();
        String[] arrayOfString = getCoreProviderAppList();
        int m = arrayOfString.length;
        k = 0;
        if (k < m)
        {
          if (!paramContext.equals(arrayOfString[k])) {
            break label78;
          }
          b = false;
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        b = true;
        return true;
      }
      label78:
      k += 1;
    }
  }
  
  private static boolean j(Context paramContext)
  {
    boolean bool2 = false;
    String[] arrayOfString = getCoreProviderAppList();
    int m = arrayOfString.length;
    int k = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (k < m)
      {
        String str = arrayOfString[k];
        if ((d > 0) && (d == getSharedTbsCoreVersion(paramContext, str)))
        {
          Context localContext = a(paramContext, str);
          if (ai.a().b(paramContext))
          {
            c = ai.a().b(paramContext, localContext).getAbsolutePath();
            e = str;
            bool1 = true;
          }
        }
      }
      else
      {
        return bool1;
      }
      k += 1;
    }
  }
  
  private static boolean k(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  /* Error */
  private static void l(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 36	com/tencent/smtt/sdk/TbsShareManager:j	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: ldc -104
    //   18: invokestatic 154	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnonnull +29 -> 52
    //   26: iconst_0
    //   27: ifeq -16 -> 11
    //   30: new 156	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   43: goto -32 -> 11
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: new 159	java/io/BufferedInputStream
    //   55: dup
    //   56: new 161	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_2
    //   68: aload_2
    //   69: astore_0
    //   70: new 169	java/util/Properties
    //   73: dup
    //   74: invokespecial 170	java/util/Properties:<init>	()V
    //   77: astore_3
    //   78: aload_2
    //   79: astore_0
    //   80: aload_3
    //   81: aload_2
    //   82: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   85: aload_2
    //   86: astore_0
    //   87: aload_3
    //   88: ldc -20
    //   90: ldc -30
    //   92: invokevirtual 230	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 4
    //   97: aload_2
    //   98: astore_0
    //   99: ldc -30
    //   101: aload 4
    //   103: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifne +17 -> 123
    //   109: aload_2
    //   110: astore_0
    //   111: aload 4
    //   113: invokestatic 241	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: iconst_0
    //   117: invokestatic 247	java/lang/Math:max	(II)I
    //   120: putstatic 24	com/tencent/smtt/sdk/TbsShareManager:d	I
    //   123: aload_2
    //   124: astore_0
    //   125: aload_3
    //   126: ldc -60
    //   128: ldc -30
    //   130: invokevirtual 230	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 4
    //   135: aload_2
    //   136: astore_0
    //   137: ldc -30
    //   139: aload 4
    //   141: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifne +10 -> 154
    //   147: aload_2
    //   148: astore_0
    //   149: aload 4
    //   151: putstatic 26	com/tencent/smtt/sdk/TbsShareManager:e	Ljava/lang/String;
    //   154: aload_2
    //   155: astore_0
    //   156: getstatic 26	com/tencent/smtt/sdk/TbsShareManager:e	Ljava/lang/String;
    //   159: ifnull +34 -> 193
    //   162: aload_2
    //   163: astore_0
    //   164: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   167: ifnull +26 -> 193
    //   170: aload_2
    //   171: astore_0
    //   172: getstatic 26	com/tencent/smtt/sdk/TbsShareManager:e	Ljava/lang/String;
    //   175: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   178: invokevirtual 190	android/content/Context:getPackageName	()Ljava/lang/String;
    //   181: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: ifeq +113 -> 297
    //   187: aload_2
    //   188: astore_0
    //   189: iconst_1
    //   190: putstatic 34	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   193: aload_2
    //   194: astore_0
    //   195: aload_3
    //   196: ldc -58
    //   198: ldc -30
    //   200: invokevirtual 230	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   203: astore 4
    //   205: aload_2
    //   206: astore_0
    //   207: ldc -30
    //   209: aload 4
    //   211: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifne +10 -> 224
    //   217: aload_2
    //   218: astore_0
    //   219: aload 4
    //   221: putstatic 22	com/tencent/smtt/sdk/TbsShareManager:c	Ljava/lang/String;
    //   224: aload_2
    //   225: astore_0
    //   226: aload_3
    //   227: ldc -56
    //   229: ldc -30
    //   231: invokevirtual 230	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   234: astore 4
    //   236: aload_2
    //   237: astore_0
    //   238: ldc -30
    //   240: aload 4
    //   242: invokevirtual 234	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifne +10 -> 255
    //   248: aload_2
    //   249: astore_0
    //   250: aload 4
    //   252: putstatic 32	com/tencent/smtt/sdk/TbsShareManager:h	Ljava/lang/String;
    //   255: aload_2
    //   256: astore_0
    //   257: aload_3
    //   258: ldc -81
    //   260: ldc_w 352
    //   263: invokevirtual 230	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   266: invokestatic 357	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   269: putstatic 28	com/tencent/smtt/sdk/TbsShareManager:f	Z
    //   272: aload_2
    //   273: astore_0
    //   274: iconst_1
    //   275: putstatic 36	com/tencent/smtt/sdk/TbsShareManager:j	Z
    //   278: aload_2
    //   279: ifnull -268 -> 11
    //   282: aload_2
    //   283: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   286: goto -275 -> 11
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   294: goto -283 -> 11
    //   297: aload_2
    //   298: astore_0
    //   299: iconst_0
    //   300: putstatic 34	com/tencent/smtt/sdk/TbsShareManager:i	Z
    //   303: goto -110 -> 193
    //   306: astore_3
    //   307: aload_2
    //   308: astore_0
    //   309: aload_3
    //   310: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   313: aload_2
    //   314: ifnull -303 -> 11
    //   317: aload_2
    //   318: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   321: goto -310 -> 11
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   329: goto -318 -> 11
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_0
    //   335: aload_0
    //   336: ifnull +7 -> 343
    //   339: aload_0
    //   340: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   343: aload_2
    //   344: athrow
    //   345: astore_0
    //   346: aload_0
    //   347: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   350: goto -7 -> 343
    //   353: astore_2
    //   354: goto -19 -> 335
    //   357: astore_3
    //   358: aconst_null
    //   359: astore_2
    //   360: goto -53 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramContext	Context
    //   6	2	1	bool	boolean
    //   67	251	2	localBufferedInputStream	java.io.BufferedInputStream
    //   332	12	2	localObject1	Object
    //   353	1	2	localObject2	Object
    //   359	1	2	localObject3	Object
    //   77	181	3	localProperties	java.util.Properties
    //   306	4	3	localThrowable1	Throwable
    //   357	1	3	localThrowable2	Throwable
    //   95	156	4	str	String
    // Exception table:
    //   from	to	target	type
    //   30	38	38	java/lang/Exception
    //   3	7	46	finally
    //   30	38	46	finally
    //   39	43	46	finally
    //   282	286	46	finally
    //   290	294	46	finally
    //   317	321	46	finally
    //   325	329	46	finally
    //   339	343	46	finally
    //   343	345	46	finally
    //   346	350	46	finally
    //   282	286	289	java/lang/Exception
    //   70	78	306	java/lang/Throwable
    //   80	85	306	java/lang/Throwable
    //   87	97	306	java/lang/Throwable
    //   99	109	306	java/lang/Throwable
    //   111	123	306	java/lang/Throwable
    //   125	135	306	java/lang/Throwable
    //   137	147	306	java/lang/Throwable
    //   149	154	306	java/lang/Throwable
    //   156	162	306	java/lang/Throwable
    //   164	170	306	java/lang/Throwable
    //   172	187	306	java/lang/Throwable
    //   189	193	306	java/lang/Throwable
    //   195	205	306	java/lang/Throwable
    //   207	217	306	java/lang/Throwable
    //   219	224	306	java/lang/Throwable
    //   226	236	306	java/lang/Throwable
    //   238	248	306	java/lang/Throwable
    //   250	255	306	java/lang/Throwable
    //   257	272	306	java/lang/Throwable
    //   274	278	306	java/lang/Throwable
    //   299	303	306	java/lang/Throwable
    //   317	321	324	java/lang/Exception
    //   15	22	332	finally
    //   52	68	332	finally
    //   339	343	345	java/lang/Exception
    //   70	78	353	finally
    //   80	85	353	finally
    //   87	97	353	finally
    //   99	109	353	finally
    //   111	123	353	finally
    //   125	135	353	finally
    //   137	147	353	finally
    //   149	154	353	finally
    //   156	162	353	finally
    //   164	170	353	finally
    //   172	187	353	finally
    //   189	193	353	finally
    //   195	205	353	finally
    //   207	217	353	finally
    //   219	224	353	finally
    //   226	236	353	finally
    //   238	248	353	finally
    //   250	255	353	finally
    //   257	272	353	finally
    //   274	278	353	finally
    //   299	303	353	finally
    //   309	313	353	finally
    //   15	22	357	java/lang/Throwable
    //   52	68	357	java/lang/Throwable
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    if (paramInt == 0) {}
    label379:
    for (;;)
    {
      try
      {
        k(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65135);
        return;
      }
      finally {}
      int m = f(paramContext);
      if (m < 0)
      {
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65134);
      }
      else if (paramInt == m)
      {
        c(paramContext, paramBoolean);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65133);
      }
      else if (paramInt < m)
      {
        k(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(65132);
      }
      else
      {
        Object localObject1 = getCoreProviderAppList();
        if (paramBoolean)
        {
          localObject1 = new String[1];
          localObject1[0] = paramContext.getApplicationContext().getPackageName();
        }
        m = localObject1.length;
        for (;;)
        {
          if (k >= m) {
            break label379;
          }
          Object localObject2 = localObject1[k];
          if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
          {
            Context localContext = a(paramContext, (String)localObject2);
            String str = ai.a().g(localContext).getAbsolutePath();
            int n = b.b(paramContext);
            if (ai.a().b(localContext))
            {
              if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
              {
                TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + paramInt);
                localObject1 = ai.a().g(paramContext);
              }
              try
              {
                j.b((File)localObject1);
                TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, str, Integer.toString(n));
                try
                {
                  localObject1 = b(paramContext, "core_info");
                  if ((g) || (localObject1 == null)) {
                    break;
                  }
                  localObject2 = new TbsLinuxToolsJni(a);
                  ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
                  ((TbsLinuxToolsJni)localObject2).a(ai.a().h(paramContext).getAbsolutePath(), "755");
                  g = true;
                }
                catch (Throwable paramContext)
                {
                  paramContext.printStackTrace();
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  localThrowable.printStackTrace();
                }
              }
            }
          }
          k += 1;
        }
      }
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: ldc -104
    //   12: invokestatic 154	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnonnull +40 -> 57
    //   20: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   23: invokestatic 367	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   26: sipush 65131
    //   29: invokevirtual 371	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 156	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 156	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: return
    //   57: new 159	java/io/BufferedInputStream
    //   60: dup
    //   61: new 161	java/io/FileInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore 7
    //   74: new 169	java/util/Properties
    //   77: dup
    //   78: invokespecial 170	java/util/Properties:<init>	()V
    //   81: astore 10
    //   83: aload 10
    //   85: aload 7
    //   87: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   90: aload_1
    //   91: invokestatic 241	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: istore 6
    //   96: iload 6
    //   98: istore 5
    //   100: iload 5
    //   102: ifeq +116 -> 218
    //   105: aload 10
    //   107: ldc -20
    //   109: aload_1
    //   110: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   113: pop
    //   114: aload 10
    //   116: ldc -81
    //   118: iconst_0
    //   119: invokestatic 179	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   122: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   125: pop
    //   126: aload 10
    //   128: ldc -60
    //   130: aload_2
    //   131: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   134: pop
    //   135: aload 10
    //   137: ldc -58
    //   139: aload_3
    //   140: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   143: pop
    //   144: aload 10
    //   146: ldc -56
    //   148: aload 4
    //   150: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   153: pop
    //   154: new 205	java/io/BufferedOutputStream
    //   157: dup
    //   158: new 207	java/io/FileOutputStream
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 208	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   166: invokespecial 211	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   169: astore_0
    //   170: aload 10
    //   172: aload_0
    //   173: aconst_null
    //   174: invokevirtual 215	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   177: iconst_0
    //   178: putstatic 36	com/tencent/smtt/sdk/TbsShareManager:j	Z
    //   181: getstatic 346	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   184: invokestatic 367	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   187: sipush 65130
    //   190: invokevirtual 371	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   193: aload 7
    //   195: ifnull +8 -> 203
    //   198: aload 7
    //   200: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   203: aload_0
    //   204: ifnull -148 -> 56
    //   207: aload_0
    //   208: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   211: return
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   217: return
    //   218: aload 10
    //   220: ldc -81
    //   222: iconst_1
    //   223: invokestatic 179	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   226: invokevirtual 183	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   229: pop
    //   230: goto -76 -> 154
    //   233: astore_2
    //   234: aload 7
    //   236: astore_0
    //   237: aload 8
    //   239: astore_1
    //   240: aload_2
    //   241: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   252: aload_1
    //   253: ifnull -197 -> 56
    //   256: aload_1
    //   257: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   260: return
    //   261: astore_0
    //   262: goto -49 -> 213
    //   265: astore_0
    //   266: aconst_null
    //   267: astore 7
    //   269: aload 9
    //   271: astore_1
    //   272: aload 7
    //   274: ifnull +8 -> 282
    //   277: aload 7
    //   279: invokevirtual 218	java/io/BufferedInputStream:close	()V
    //   282: aload_1
    //   283: ifnull +7 -> 290
    //   286: aload_1
    //   287: invokevirtual 219	java/io/BufferedOutputStream:close	()V
    //   290: aload_0
    //   291: athrow
    //   292: astore 11
    //   294: goto -194 -> 100
    //   297: astore_2
    //   298: aload_2
    //   299: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   302: goto -20 -> 282
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   310: goto -20 -> 290
    //   313: astore_0
    //   314: aload_0
    //   315: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   318: goto -66 -> 252
    //   321: astore_0
    //   322: aload_0
    //   323: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   326: goto -282 -> 44
    //   329: astore_0
    //   330: goto -117 -> 213
    //   333: astore_1
    //   334: aload_1
    //   335: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   338: goto -135 -> 203
    //   341: astore_0
    //   342: aload 9
    //   344: astore_1
    //   345: goto -73 -> 272
    //   348: astore_2
    //   349: aload_0
    //   350: astore_1
    //   351: aload_2
    //   352: astore_0
    //   353: goto -81 -> 272
    //   356: astore_2
    //   357: aload_0
    //   358: astore 7
    //   360: aload_2
    //   361: astore_0
    //   362: goto -90 -> 272
    //   365: astore_2
    //   366: aconst_null
    //   367: astore_0
    //   368: aload 8
    //   370: astore_1
    //   371: goto -131 -> 240
    //   374: astore_2
    //   375: aload_0
    //   376: astore_1
    //   377: aload 7
    //   379: astore_0
    //   380: goto -140 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramContext	Context
    //   0	383	1	paramString1	String
    //   0	383	2	paramString2	String
    //   0	383	3	paramString3	String
    //   0	383	4	paramString4	String
    //   7	94	5	k	int
    //   94	3	6	m	int
    //   72	306	7	localObject1	Object
    //   4	365	8	localObject2	Object
    //   1	342	9	localObject3	Object
    //   81	138	10	localProperties	java.util.Properties
    //   292	1	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   207	211	212	java/lang/Exception
    //   74	90	233	java/lang/Throwable
    //   90	96	233	java/lang/Throwable
    //   105	154	233	java/lang/Throwable
    //   154	170	233	java/lang/Throwable
    //   218	230	233	java/lang/Throwable
    //   256	260	261	java/lang/Exception
    //   9	16	265	finally
    //   20	32	265	finally
    //   57	74	265	finally
    //   90	96	292	java/lang/Exception
    //   277	282	297	java/lang/Exception
    //   286	290	305	java/lang/Exception
    //   248	252	313	java/lang/Exception
    //   36	44	321	java/lang/Exception
    //   48	56	329	java/lang/Exception
    //   198	203	333	java/lang/Exception
    //   74	90	341	finally
    //   90	96	341	finally
    //   105	154	341	finally
    //   154	170	341	finally
    //   218	230	341	finally
    //   170	193	348	finally
    //   240	244	356	finally
    //   9	16	365	java/lang/Throwable
    //   20	32	365	java/lang/Throwable
    //   57	74	365	java/lang/Throwable
    //   170	193	374	java/lang/Throwable
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/TbsShareManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */