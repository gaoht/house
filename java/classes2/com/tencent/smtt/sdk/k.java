package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class k
{
  static boolean a = false;
  private static k c = null;
  private static int f = 0;
  private static int g = 0;
  private static int h = 3;
  private static String j = null;
  private aw b = null;
  private boolean d = false;
  private boolean e = false;
  private File i = null;
  
  public static k a(boolean paramBoolean)
  {
    if ((c == null) && (paramBoolean)) {}
    try
    {
      if (c == null) {
        c = new k();
      }
      return c;
    }
    finally {}
  }
  
  static void a(int paramInt)
  {
    f = paramInt;
  }
  
  private void b(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(j, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.i, "count.prop")), null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static int d()
  {
    return f;
  }
  
  /* Error */
  private int i()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 70	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 46	com/tencent/smtt/sdk/k:i	Ljava/io/File;
    //   10: ldc 72
    //   12: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 93	java/io/File:exists	()Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +26 -> 50
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 95	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: iload_1
    //   40: ireturn
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   48: iconst_0
    //   49: ireturn
    //   50: new 98	java/io/BufferedInputStream
    //   53: dup
    //   54: new 100	java/io/FileInputStream
    //   57: dup
    //   58: aload 4
    //   60: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 104	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: new 55	java/util/Properties
    //   75: dup
    //   76: invokespecial 56	java/util/Properties:<init>	()V
    //   79: astore 6
    //   81: aload 5
    //   83: astore 4
    //   85: aload 6
    //   87: aload 5
    //   89: invokevirtual 107	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   92: aload 5
    //   94: astore 4
    //   96: aload 6
    //   98: getstatic 34	com/tencent/smtt/sdk/k:j	Ljava/lang/String;
    //   101: ldc 109
    //   103: invokevirtual 113	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 118	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   109: invokevirtual 121	java/lang/Integer:intValue	()I
    //   112: istore_2
    //   113: iload_2
    //   114: istore_1
    //   115: aload 5
    //   117: ifnull -78 -> 39
    //   120: aload 5
    //   122: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   125: iload_2
    //   126: ireturn
    //   127: astore 4
    //   129: aload 4
    //   131: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   134: iload_2
    //   135: ireturn
    //   136: astore 6
    //   138: aconst_null
    //   139: astore 5
    //   141: aload 5
    //   143: astore 4
    //   145: aload 6
    //   147: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   150: aload 5
    //   152: ifnull -113 -> 39
    //   155: aload 5
    //   157: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore 5
    //   173: aconst_null
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +8 -> 186
    //   181: aload 4
    //   183: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   186: aload 5
    //   188: athrow
    //   189: astore 4
    //   191: aload 4
    //   193: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   196: goto -10 -> 186
    //   199: astore 5
    //   201: goto -25 -> 176
    //   204: astore 6
    //   206: goto -65 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	k
    //   1	114	1	k	int
    //   112	23	2	m	int
    //   22	2	3	bool	boolean
    //   15	3	4	localFile	File
    //   41	18	4	localIOException1	IOException
    //   70	25	4	localObject1	Object
    //   127	3	4	localIOException2	IOException
    //   143	1	4	localObject2	Object
    //   162	3	4	localIOException3	IOException
    //   174	8	4	localObject3	Object
    //   189	3	4	localIOException4	IOException
    //   66	90	5	localBufferedInputStream	java.io.BufferedInputStream
    //   171	16	5	localObject4	Object
    //   199	1	5	localObject5	Object
    //   79	18	6	localProperties	Properties
    //   136	10	6	localException1	Exception
    //   204	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   120	125	127	java/io/IOException
    //   2	23	136	java/lang/Exception
    //   50	68	136	java/lang/Exception
    //   155	160	162	java/io/IOException
    //   2	23	171	finally
    //   50	68	171	finally
    //   181	186	189	java/io/IOException
    //   72	81	199	finally
    //   85	92	199	finally
    //   96	113	199	finally
    //   145	150	199	finally
    //   72	81	204	java/lang/Exception
    //   85	92	204	java/lang/Exception
    //   96	113	204	java/lang/Exception
  }
  
  public aw a()
  {
    if (this.d) {
      return this.b;
    }
    return null;
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, ah paramah)
  {
    int n = 1;
    int m = 0;
    Object localObject1;
    int k;
    label193:
    Object localObject3;
    Object localObject4;
    Object localObject2;
    for (;;)
    {
      try
      {
        TbsLog.addLog(999, null, new Object[0]);
        TbsLog.initIfNeed(paramContext);
        g += 1;
        if (paramah != null)
        {
          if (g == 1)
          {
            bool = true;
            paramah.b = bool;
          }
        }
        else
        {
          TbsCoreLoadStat.getInstance().a();
          if (paramah != null) {
            paramah.a("tbs_rename_task", (byte)1);
          }
          localObject1 = ai.a();
          if (g != 1) {
            continue;
          }
          bool = true;
          ((ai)localObject1).b(paramContext, bool);
          if (paramah != null) {
            paramah.a("tbs_rename_task", (byte)2);
          }
          TbsShareManager.forceToLoadX5ForThirdApp(paramContext, true);
          if (paramah != null) {
            paramah.a("can_load_x5", (byte)1);
          }
          paramBoolean2 = QbSdk.a(paramContext, paramBoolean1, paramBoolean2);
          if (paramah != null) {
            paramah.a("can_load_x5", (byte)2);
          }
          if (Build.VERSION.SDK_INT < 7) {
            continue;
          }
          paramBoolean1 = true;
          break label671;
          if (k == 0) {
            break label573;
          }
          paramBoolean1 = this.d;
          if (!paramBoolean1) {
            continue;
          }
          return;
        }
        boolean bool = false;
        continue;
        bool = false;
        continue;
        paramBoolean1 = false;
        break label671;
        k = 0;
        continue;
        try
        {
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break label409;
          }
          TbsLog.addLog(995, null, new Object[0]);
          if (paramah != null) {
            paramah.a("read_core_info", (byte)1);
          }
          paramBoolean1 = TbsShareManager.h(paramContext);
          if (paramah != null) {
            paramah.a("read_core_info", (byte)2);
          }
          if (!paramBoolean1) {
            break label395;
          }
          localObject3 = new File(TbsShareManager.b(paramContext));
          localObject4 = ai.a().g(paramContext);
          localObject1 = TbsShareManager.d(paramContext);
          localObject2 = localObject4;
          if (localObject4 != null) {
            break;
          }
          this.d = false;
          QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
        }
        catch (Throwable paramah)
        {
          TbsLog.e("SDKEngine", "useSystemWebView by exception: " + paramah);
          if (paramah != null) {
            break label558;
          }
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 326);
        label345:
        this.d = false;
        QbSdk.a(paramContext, "SDKEngine::useSystemWebView by exception: " + paramah);
        label374:
        this.i = ai.i(paramContext);
        this.e = true;
        continue;
        this.d = false;
      }
      finally {}
      label395:
      QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
      continue;
      label409:
      TbsLog.addLog(996, null, new Object[0]);
      localObject2 = ai.a().g(paramContext);
      k = n;
      if (f != 25436)
      {
        if (f != 25437) {
          break label685;
        }
        k = n;
      }
      label455:
      if (k == 0) {
        break label691;
      }
      localObject1 = paramContext.getApplicationContext();
      label466:
      if (localObject2 != null) {
        break label697;
      }
      this.d = false;
      QbSdk.a(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
    }
    for (;;)
    {
      localObject4 = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath());
      k = m;
      while (k < localObject4.length) {
        k += 1;
      }
      this.b = new aw(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), (String[])localObject4, QbSdk.d, paramah);
      this.d = true;
      break label374;
      label558:
      TbsCoreLoadStat.getInstance().a(paramContext, 327, paramah);
      break label345;
      label573:
      paramah = "can_load_x5=" + paramBoolean2 + "; is_compatible=" + paramBoolean1;
      TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + paramah);
      if ((QbSdk.a) && (this.d)) {
        break label374;
      }
      this.d = false;
      TbsCoreLoadStat.getInstance().a(paramContext, 405, new Throwable(paramah));
      break label374;
      label671:
      if ((!paramBoolean2) || (!paramBoolean1)) {
        break label193;
      }
      k = 1;
      break;
      label685:
      k = 0;
      break label455;
      label691:
      localObject1 = paramContext;
      break label466;
      label697:
      localObject3 = localObject2;
    }
  }
  
  void a(String paramString)
  {
    j = paramString;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  boolean b(boolean paramBoolean)
  {
    a = paramBoolean;
    return paramBoolean;
  }
  
  aw c()
  {
    return this.b;
  }
  
  public String e()
  {
    if ((this.b == null) || (QbSdk.a)) {
      return "system webview get nothing...";
    }
    return this.b.a();
  }
  
  boolean f()
  {
    int k;
    if (a)
    {
      if (j == null) {
        return false;
      }
      k = i();
      if (k != 0) {
        break label32;
      }
      b(1);
    }
    for (;;)
    {
      return a;
      label32:
      if (k + 1 > h) {
        break;
      }
      b(k + 1);
    }
  }
  
  boolean g()
  {
    return this.e;
  }
  
  public boolean h()
  {
    return QbSdk.useSoftWare();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */