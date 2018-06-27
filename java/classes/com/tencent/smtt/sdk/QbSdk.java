package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.u;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
@Instrumented
public class QbSdk
{
  private static boolean A = false;
  private static boolean B = false;
  public static final int EXTENSION_INIT_FAILURE = -99999;
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  public static final int SVNVERSION = 439526;
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  static boolean a;
  static boolean b;
  static boolean c;
  static String d;
  static boolean e;
  static long f;
  static long g;
  static Object h;
  static volatile boolean i;
  static TbsListener j = new i();
  static Map<String, Object> k = null;
  private static int l;
  private static String m;
  private static Class<?> n;
  private static Object o;
  private static boolean p;
  private static String[] q;
  private static String r;
  private static String s;
  public static boolean sIsVersionPrinted = false;
  private static int t;
  private static int u;
  private static String v;
  private static String w;
  private static boolean x;
  private static TbsListener y;
  private static TbsListener z;
  
  static
  {
    l = 0;
    m = "";
    a = false;
    b = false;
    c = true;
    p = false;
    r = "NULL";
    s = "UNKNOWN";
    e = false;
    f = 0L;
    g = 0L;
    h = new Object();
    t = 0;
    u = 170;
    v = null;
    w = null;
    i = a;
    x = true;
    y = null;
    z = null;
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
  {
    if (!a(paramContext))
    {
      TbsLogReport.a(paramContext).a(216, "initForPatch return false!");
      return null;
    }
    paramBundle = u.a(o, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    TbsLogReport.a(paramContext).a(216, "incrUpdate return null!");
    return null;
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      paramContext = Integer.valueOf(-99999);
    }
    do
    {
      return paramContext;
      paramString = u.a(o, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
      paramContext = paramString;
    } while (paramString != null);
    return null;
  }
  
  static String a()
  {
    return m;
  }
  
  /* Error */
  static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 88	com/tencent/smtt/sdk/QbSdk:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 88	com/tencent/smtt/sdk/QbSdk:a	Z
    //   19: new 187	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   26: ldc -66
    //   28: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: putstatic 102	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/String;
    //   41: ldc -57
    //   43: new 187	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   50: ldc -55
    //   52: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 102	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/String;
    //   58: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 206	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: invokestatic 212	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   70: aload_0
    //   71: sipush 401
    //   74: new 214	java/lang/Throwable
    //   77: dup
    //   78: getstatic 102	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/String;
    //   81: invokespecial 217	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 220	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   87: goto -76 -> 11
    //   90: astore_0
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	90	finally
    //   15	87	90	finally
  }
  
  static boolean a(Context paramContext)
  {
    try
    {
      if (n != null) {
        return true;
      }
      File localFile1 = ai.a().g(paramContext);
      if (localFile1 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      File localFile2 = new File(localFile1, "tbs_sdk_extension_dex.jar");
      if (!localFile2.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      n = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), localFile2.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      o = n.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, paramContext });
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 20000);
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (!b(paramContext)) {
      return true;
    }
    paramContext = u.a(o, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43000), Integer.valueOf(paramInt2) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    paramContext = u.a(o, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43000) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: 439526; SDK_VERSION_CODE: 43000; SDK_VERSION_NAME: 3.0.0.1038");
      sIsVersionPrinted = true;
    }
    if ((a) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + s, false);
      TbsCoreLoadStat.getInstance().a(paramContext, 414, new Throwable(s));
      return false;
    }
    if (b)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable(r));
      return false;
    }
    if (!x) {
      c(paramContext);
    }
    File localFile2;
    try
    {
      localFile2 = ai.a().g(paramContext);
      if (localFile2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
        TbsCoreLoadStat.getInstance().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
        return false;
      }
    }
    catch (Throwable localThrowable1)
    {
      TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable1));
      TbsCoreLoadStat.getInstance().a(paramContext, 306, localThrowable1);
      return false;
    }
    int i1;
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      if (n != null) {
        return true;
      }
    }
    else
    {
      if (l == 0) {
        break label813;
      }
      int i2 = ai.a().a(true, paramContext);
      i1 = i2;
      if (l != i2)
      {
        n = null;
        o = null;
        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i2, true);
        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + l, true);
        TbsCoreLoadStat.getInstance().a(paramContext, 303, new Throwable("sTbsVersion: " + l + "; tbsCoreInstalledVer: " + i2));
        return false;
      }
    }
    for (;;)
    {
      l = i1;
      break;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.h(paramContext)) {}
      }
      for (File localFile1 = new File(TbsShareManager.b(paramContext), "tbs_sdk_extension_dex.jar");; localObject = new File(ai.a().g(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        paramBoolean = localFile1.exists();
        if (paramBoolean) {
          break label669;
        }
        try
        {
          TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
          i1 = ai.a().c(paramContext);
          if (!new File(localFile1.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
            break label587;
          }
          if (i1 <= 0) {
            break;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i1));
          return false;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          return false;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
        return false;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i1));
      return false;
      label587:
      if (i1 > 0)
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i1));
        return false;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i1));
      return false;
      label669:
      n = new DexClassLoader(((File)localObject).getAbsolutePath(), localFile2.getAbsolutePath(), ((File)localObject).getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      Object localObject = n.getConstructor(new Class[] { Context.class, Context.class });
      if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      for (o = ((Constructor)localObject).newInstance(new Object[] { paramContext, TbsShareManager.d(paramContext) });; o = ((Constructor)localObject).newInstance(new Object[] { paramContext, paramContext }))
      {
        u.a(o, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      label813:
      i1 = 0;
    }
  }
  
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 1;
    paramBoolean2 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (!TbsShareManager.g(paramContext)))
    {
      TbsCoreLoadStat.getInstance().a(paramContext, 302);
      paramBoolean1 = bool2;
    }
    label38:
    Object localObject3;
    do
    {
      return paramBoolean1;
      if (!a(paramContext, paramBoolean1))
      {
        TbsLog.e("QbSdk", "QbSdk.init failure!");
        return false;
      }
      localObject3 = u.a(o, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43000) });
      if (localObject3 == null) {
        break label976;
      }
      if (!(localObject3 instanceof String)) {
        break;
      }
      paramBoolean1 = bool2;
    } while (((String)localObject3).equalsIgnoreCase("AuthenticationFail"));
    if (!(localObject3 instanceof Bundle))
    {
      TbsCoreLoadStat.getInstance().a(paramContext, 330, new Throwable("" + localObject3));
      TbsLog.e("loaderror", "ret not instance of bundle");
      return false;
    }
    Bundle localBundle = (Bundle)localObject3;
    if (localBundle.isEmpty())
    {
      TbsCoreLoadStat.getInstance().a(paramContext, 331, new Throwable("" + localObject3));
      TbsLog.e("loaderror", "empty bundle");
      return false;
    }
    int i3 = localBundle.getInt("result_code", -1);
    if (i3 == 0)
    {
      paramBoolean1 = true;
      if (!TbsShareManager.isThirdPartyApp(paramContext)) {
        break label400;
      }
      k.a(TbsShareManager.c(paramContext));
      m = String.valueOf(TbsShareManager.c(paramContext));
      if (m.length() == 5) {
        m = "0" + m;
      }
      if (m.length() != 6) {
        m = "";
      }
    }
    label400:
    int i1;
    for (;;)
    {
      try
      {
        q = localBundle.getStringArray("tbs_jarfiles");
        if ((q instanceof String[])) {
          break label634;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sJarFiles not instanceof String[]: " + q));
        return false;
      }
      catch (Throwable localThrowable)
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 329, localThrowable);
        return false;
      }
      paramBoolean1 = false;
      break;
      if (Build.VERSION.SDK_INT >= 12) {
        m = localBundle.getString("tbs_core_version", "0");
      }
      try
      {
        l = Integer.parseInt(m);
        k.a(l);
        if (l == 0)
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sTbsVersion is 0"));
          return false;
          m = localBundle.getString("tbs_core_version");
          if (m != null) {
            continue;
          }
          m = "0";
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l = 0;
        continue;
        if (l > 0)
        {
          i1 = i2;
          if (l <= 25442) {}
        }
        else
        {
          if (l != 25472) {
            continue;
          }
          i1 = i2;
        }
        if (i1 != 0)
        {
          TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + l);
          j.b(ai.a().g(paramContext));
          TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("is_obsolete --> delete old core:" + l));
          return false;
          i1 = 0;
        }
      }
    }
    label634:
    d = localThrowable.getString("tbs_librarypath");
    Class localClass = null;
    Object localObject1 = localClass;
    if (i3 != 0) {}
    for (;;)
    {
      try
      {
        localObject1 = u.a(o, "getErrorCodeForLogReport", new Class[0], new Object[0]);
        switch (i3)
        {
        default: 
          TbsCoreLoadStat.getInstance().a(paramContext, 415, new Throwable("detail: " + localObject1 + "errcode" + i3));
        case 0: 
          paramBoolean2 = paramBoolean1;
          paramBoolean1 = paramBoolean2;
          if (paramBoolean2) {
            break label38;
          }
          TbsLog.e("loaderror", "319");
          return paramBoolean2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localClass;
        continue;
        if ((localObject2 instanceof Integer))
        {
          TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject2).intValue(), new Throwable("detail: " + localObject2));
          continue;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("detail: " + localObject2));
        continue;
        if ((localObject2 instanceof Integer))
        {
          TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject2).intValue(), new Throwable("detail: " + localObject2));
          continue;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 404, new Throwable("detail: " + localObject2));
        continue;
      }
      label976:
      Object localObject2 = o;
      localClass = Integer.TYPE;
      i1 = a.a();
      localObject2 = u.a(localObject2, "canLoadX5", new Class[] { localClass }, new Object[] { Integer.valueOf(i1) });
      if (localObject2 != null)
      {
        if ((localObject2 instanceof String))
        {
          paramBoolean1 = bool2;
          if (((String)localObject2).equalsIgnoreCase("AuthenticationFail")) {
            break;
          }
        }
        if (!(localObject2 instanceof Boolean)) {
          continue;
        }
        l = k.d();
        bool2 = a(paramContext, k.d());
        paramBoolean2 = bool1;
        if (((Boolean)localObject2).booleanValue())
        {
          paramBoolean2 = bool1;
          if (!bool2) {
            paramBoolean2 = true;
          }
        }
        paramBoolean1 = paramBoolean2;
        if (paramBoolean2) {
          break;
        }
        TbsLog.e("loaderror", "318");
        TbsLog.w("loaderror", "isX5Disable:" + bool2);
        TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject2);
        return paramBoolean2;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 308);
    }
  }
  
  protected static String b()
  {
    Object localObject = bg.b();
    if ((localObject != null) && (((bg)localObject).c()))
    {
      localObject = ((bg)localObject).d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String))) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      if (n != null) {
        return true;
      }
      File localFile = ai.a().g(paramContext);
      if (localFile == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.h(paramContext)) {}
      }
      for (localObject = new File(TbsShareManager.b(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject).exists(); localObject = new File(ai.a().g(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        return false;
        TbsCoreLoadStat.getInstance().a(paramContext, 304);
        return false;
      }
      n = new DexClassLoader(((File)localObject).getAbsolutePath(), localFile.getAbsolutePath(), ((File)localObject).getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
      return false;
    }
    Object localObject = n.getConstructor(new Class[] { Context.class, Context.class });
    if (TbsShareManager.isThirdPartyApp(paramContext)) {}
    for (o = ((Constructor)localObject).newInstance(new Object[] { paramContext, TbsShareManager.d(paramContext) });; o = ((Constructor)localObject).newInstance(new Object[] { paramContext, paramContext }))
    {
      u.a(o, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
    }
  }
  
  private static void c(Context paramContext)
  {
    int i6 = -1;
    x = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          i3 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (i3 < 0) {
            continue;
          }
          i1 = i3 + 1;
          if (i1 > 4)
          {
            return;
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
          }
          i3 = i1;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          int i2;
          int i5;
          Object localObject2;
          int i4;
          Object localObject3;
          int i3 = -1;
          int i1 = -1;
          continue;
          i1 = -1;
          continue;
        }
        try
        {
          i2 = ai.a().c(paramContext);
          if (i2 <= 0) {
            continue;
          }
          if (i3 > 4) {}
        }
        catch (Throwable localThrowable3)
        {
          i2 = -1;
          i3 = i1;
          i1 = i2;
          continue;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", i3).commit();
          i5 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          i3 = i1;
          localObject2 = localObject1;
          i4 = i2;
          if (i5 < 0) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject1).edit();
          i5 += 1;
          ((SharedPreferences.Editor)localObject2).putInt("tbs_preload_x5_counter", i5).commit();
          if (i5 <= 3) {
            continue;
          }
          try
          {
            i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
            localObject1 = ((SharedPreferences)localObject1).edit();
            if (i1 != i2) {
              continue;
            }
            j.a(ai.a().g(paramContext), false);
            paramContext = ad.a(paramContext).a();
            if (paramContext != null) {
              j.a(paramContext, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i1);
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
          catch (Throwable paramContext)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
            return;
          }
          localThrowable1 = localThrowable1;
          i3 = -1;
          localObject1 = null;
          i1 = -1;
        }
        catch (Throwable localThrowable4)
        {
          i3 = i1;
          i1 = i2;
          continue;
        }
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable1));
        i4 = i1;
        localObject3 = localObject1;
        i5 = -1;
        i1 = i3;
        localObject1 = localObject3;
        i2 = i4;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i1);
      }
      i2 = i6;
      if (i1 > 0)
      {
        i2 = i6;
        if (i1 <= 3)
        {
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
          bg.b().a(paramContext, null);
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
          i2 = 0;
        }
      }
      try
      {
        i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
        if (i1 > 0) {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_counter", i1 - 1).commit();
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
        }
      }
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
      return;
    }
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = u.a(o, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().a(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      TbsCoreLoadStat.getInstance().a(paramContext, 314);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    return a(paramContext, false, false);
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    try
    {
      if (n == null)
      {
        File localFile1 = ai.a().g(paramContext);
        if (localFile1 == null)
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          return false;
        }
        File localFile2 = new File(TbsShareManager.b(paramContext), "tbs_sdk_extension_dex.jar");
        if (!localFile2.exists())
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          return false;
        }
        n = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), localFile2.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      }
      if (o == null) {
        o = n.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, paramContext });
      }
      paramContext = u.a(o, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  public static void canOpenFile(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    new c(paramContext, paramString, paramValueCallback).start();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!a(paramContext, false)) {}
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: getstatic 115	com/tencent/smtt/sdk/QbSdk:t	I
    //   9: ifne +9 -> 18
    //   12: invokestatic 490	com/tencent/smtt/sdk/a:a	()I
    //   15: putstatic 115	com/tencent/smtt/sdk/QbSdk:t	I
    //   18: ldc -57
    //   20: new 187	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 631
    //   30: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: getstatic 115	com/tencent/smtt/sdk/QbSdk:t	I
    //   36: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 310	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: getstatic 446	android/os/Build$VERSION:SDK_INT	I
    //   48: bipush 7
    //   50: if_icmplt +12 -> 62
    //   53: getstatic 115	com/tencent/smtt/sdk/QbSdk:t	I
    //   56: getstatic 117	com/tencent/smtt/sdk/QbSdk:u	I
    //   59: if_icmpge +5 -> 64
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_0
    //   65: ifnull -3 -> 62
    //   68: new 633	java/io/BufferedInputStream
    //   71: dup
    //   72: new 635	java/io/FileInputStream
    //   75: dup
    //   76: new 234	java/io/File
    //   79: dup
    //   80: invokestatic 227	com/tencent/smtt/sdk/ai:a	()Lcom/tencent/smtt/sdk/ai;
    //   83: aload_0
    //   84: invokevirtual 230	com/tencent/smtt/sdk/ai:g	(Landroid/content/Context;)Ljava/io/File;
    //   87: ldc_w 637
    //   90: invokespecial 239	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: invokespecial 639	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: invokespecial 642	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 6
    //   101: new 644	java/util/Properties
    //   104: dup
    //   105: invokespecial 645	java/util/Properties:<init>	()V
    //   108: astore 8
    //   110: aload 8
    //   112: aload 6
    //   114: invokevirtual 648	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   117: aload 8
    //   119: ldc_w 650
    //   122: invokevirtual 653	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 9
    //   127: aload 8
    //   129: ldc_w 655
    //   132: invokevirtual 653	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 10
    //   137: aload 9
    //   139: invokestatic 456	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   142: istore_1
    //   143: aload 10
    //   145: invokestatic 456	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   148: istore_2
    //   149: getstatic 658	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   152: invokestatic 456	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   155: istore_3
    //   156: iload_3
    //   157: iload_1
    //   158: if_icmpgt +8 -> 166
    //   161: iload_3
    //   162: iload_2
    //   163: if_icmpge +43 -> 206
    //   166: ldc -57
    //   168: new 187	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 660
    //   178: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_3
    //   182: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 310	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 6
    //   193: ifnull -131 -> 62
    //   196: aload 6
    //   198: invokevirtual 663	java/io/BufferedInputStream:close	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_0
    //   204: iconst_0
    //   205: ireturn
    //   206: aload 8
    //   208: ldc_w 448
    //   211: invokevirtual 653	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokestatic 456	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   217: istore_1
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 663	java/io/BufferedInputStream:close	()V
    //   228: new 635	java/io/FileInputStream
    //   231: dup
    //   232: new 234	java/io/File
    //   235: dup
    //   236: aload_0
    //   237: invokestatic 665	com/tencent/smtt/sdk/ai:i	(Landroid/content/Context;)Ljava/io/File;
    //   240: ldc_w 667
    //   243: invokespecial 239	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   246: invokespecial 639	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   249: astore 6
    //   251: new 644	java/util/Properties
    //   254: dup
    //   255: invokespecial 645	java/util/Properties:<init>	()V
    //   258: astore 7
    //   260: aload 7
    //   262: aload 6
    //   264: invokevirtual 648	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   267: aload 7
    //   269: ldc_w 669
    //   272: invokevirtual 653	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   275: invokestatic 456	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   278: istore_2
    //   279: aload 7
    //   281: ldc_w 671
    //   284: invokevirtual 653	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic 456	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   290: istore_3
    //   291: iload_1
    //   292: ldc_w 672
    //   295: if_icmpeq +10 -> 305
    //   298: iload_2
    //   299: ldc_w 672
    //   302: if_icmpne +72 -> 374
    //   305: iconst_0
    //   306: istore_1
    //   307: iload_1
    //   308: istore_2
    //   309: aload 6
    //   311: ifnull +10 -> 321
    //   314: aload 6
    //   316: invokevirtual 675	java/io/InputStream:close	()V
    //   319: iload_1
    //   320: istore_2
    //   321: iload_2
    //   322: ifne +181 -> 503
    //   325: iload 4
    //   327: ireturn
    //   328: astore 6
    //   330: aconst_null
    //   331: astore_0
    //   332: aload 6
    //   334: invokevirtual 367	java/lang/Throwable:printStackTrace	()V
    //   337: ldc -57
    //   339: ldc_w 677
    //   342: invokestatic 310	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: ifnull -284 -> 62
    //   349: aload_0
    //   350: invokevirtual 663	java/io/BufferedInputStream:close	()V
    //   353: iconst_0
    //   354: ireturn
    //   355: astore_0
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aconst_null
    //   360: astore 6
    //   362: aload 6
    //   364: ifnull +8 -> 372
    //   367: aload 6
    //   369: invokevirtual 663	java/io/BufferedInputStream:close	()V
    //   372: aload_0
    //   373: athrow
    //   374: iload_1
    //   375: iload_2
    //   376: if_icmple +8 -> 384
    //   379: iconst_0
    //   380: istore_1
    //   381: goto -74 -> 307
    //   384: iload_1
    //   385: iload_2
    //   386: if_icmpne +193 -> 579
    //   389: iload_3
    //   390: ifle +16 -> 406
    //   393: iload_3
    //   394: aload_0
    //   395: invokestatic 681	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   398: if_icmpeq +8 -> 406
    //   401: iconst_0
    //   402: istore_1
    //   403: goto -96 -> 307
    //   406: aload 7
    //   408: ldc_w 683
    //   411: invokevirtual 653	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   414: invokestatic 686	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   417: ifeq +34 -> 451
    //   420: aload_0
    //   421: invokevirtual 690	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   424: invokestatic 695	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   427: getfield 699	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   430: ldc_w 701
    //   433: iconst_0
    //   434: invokeinterface 705 3 0
    //   439: istore 5
    //   441: iload 5
    //   443: ifne +8 -> 451
    //   446: iconst_1
    //   447: istore_1
    //   448: goto -141 -> 307
    //   451: iconst_0
    //   452: istore_1
    //   453: goto -146 -> 307
    //   456: astore_0
    //   457: aload 7
    //   459: astore_0
    //   460: ldc -57
    //   462: ldc_w 707
    //   465: invokestatic 310	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload_0
    //   469: ifnull +7 -> 476
    //   472: aload_0
    //   473: invokevirtual 675	java/io/InputStream:close	()V
    //   476: iconst_1
    //   477: istore_2
    //   478: goto -157 -> 321
    //   481: astore_0
    //   482: iconst_1
    //   483: istore_2
    //   484: goto -163 -> 321
    //   487: astore_0
    //   488: aconst_null
    //   489: astore 6
    //   491: aload 6
    //   493: ifnull +8 -> 501
    //   496: aload 6
    //   498: invokevirtual 675	java/io/InputStream:close	()V
    //   501: aload_0
    //   502: athrow
    //   503: iconst_0
    //   504: istore 4
    //   506: goto -181 -> 325
    //   509: astore 6
    //   511: goto -283 -> 228
    //   514: astore 6
    //   516: goto -144 -> 372
    //   519: astore_0
    //   520: iload_1
    //   521: istore_2
    //   522: goto -201 -> 321
    //   525: astore 6
    //   527: goto -26 -> 501
    //   530: astore_0
    //   531: goto -40 -> 491
    //   534: astore 7
    //   536: aload_0
    //   537: astore 6
    //   539: aload 7
    //   541: astore_0
    //   542: goto -51 -> 491
    //   545: astore_0
    //   546: aload 6
    //   548: astore_0
    //   549: goto -89 -> 460
    //   552: astore_0
    //   553: goto -191 -> 362
    //   556: astore 7
    //   558: aload_0
    //   559: astore 6
    //   561: aload 7
    //   563: astore_0
    //   564: goto -202 -> 362
    //   567: astore 7
    //   569: aload 6
    //   571: astore_0
    //   572: aload 7
    //   574: astore 6
    //   576: goto -244 -> 332
    //   579: iconst_0
    //   580: istore_1
    //   581: goto -274 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	paramContext	Context
    //   142	439	1	i1	int
    //   148	374	2	i2	int
    //   155	244	3	i3	int
    //   4	501	4	bool1	boolean
    //   439	3	5	bool2	boolean
    //   99	216	6	localObject1	Object
    //   328	5	6	localThrowable1	Throwable
    //   360	137	6	localObject2	Object
    //   509	1	6	localException1	Exception
    //   514	1	6	localException2	Exception
    //   525	1	6	localException3	Exception
    //   537	38	6	localObject3	Object
    //   1	457	7	localProperties1	java.util.Properties
    //   534	6	7	localObject4	Object
    //   556	6	7	localObject5	Object
    //   567	6	7	localThrowable2	Throwable
    //   108	99	8	localProperties2	java.util.Properties
    //   125	13	9	str1	String
    //   135	9	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   196	201	203	java/lang/Exception
    //   68	101	328	java/lang/Throwable
    //   349	353	355	java/lang/Exception
    //   68	101	358	finally
    //   228	251	456	java/lang/Throwable
    //   472	476	481	java/lang/Exception
    //   228	251	487	finally
    //   223	228	509	java/lang/Exception
    //   367	372	514	java/lang/Exception
    //   314	319	519	java/lang/Exception
    //   496	501	525	java/lang/Exception
    //   251	291	530	finally
    //   393	401	530	finally
    //   406	441	530	finally
    //   460	468	534	finally
    //   251	291	545	java/lang/Throwable
    //   393	401	545	java/lang/Throwable
    //   406	441	545	java/lang/Throwable
    //   101	156	552	finally
    //   166	191	552	finally
    //   206	218	552	finally
    //   332	345	556	finally
    //   101	156	567	java/lang/Throwable
    //   166	191	567	java/lang/Throwable
    //   206	218	567	java/lang/Throwable
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = u.a(o, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean))) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    try
    {
      new android.webkit.WebView(paramContext).clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      bg localbg;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          if (new WebView(paramContext).getWebViewClientExtension() != null)
          {
            localbg = bg.b();
            if ((localbg != null) && (localbg.c())) {
              localbg.d().a(paramContext, paramBoolean);
            }
          }
          return;
        }
        catch (Throwable paramContext) {}
        localThrowable = localThrowable;
        TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(localThrowable));
      }
    }
  }
  
  public static void closeFileReader(Context paramContext)
  {
    bg localbg = bg.b();
    localbg.a(paramContext, null);
    if (localbg.c()) {
      localbg.d().o();
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localbg.d().b();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    bg localbg;
    do
    {
      do
      {
        do
        {
          return false;
        } while (TbsDownloader.getOverSea(paramContext));
        localbg = bg.b();
      } while ((localbg == null) || (!localbg.c()));
    } while (localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
  }
  
  public static void forceSysWebView()
  {
    b = true;
    r = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l1 = 0L;
    if (paramContext != null) {
      l1 = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l1;
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i1 = 0;
    if ((q instanceof String[]))
    {
      int i2 = q.length;
      paramContext2 = new String[i2];
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i1 >= i2) {
          break;
        }
        paramContext2[i1] = (paramString + q[i1]);
        i1 += 1;
      }
    }
    paramContext1 = u.a(o, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return A;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    Object localObject = null;
    bg localbg = bg.b();
    localbg.a(paramContext, null);
    paramContext = (Context)localObject;
    if (localbg != null)
    {
      paramContext = (Context)localObject;
      if (localbg.c()) {
        paramContext = localbg.d().f();
      }
    }
    return paramContext;
  }
  
  public static String getQQBuildNumber()
  {
    return w;
  }
  
  public static boolean getTBSInstalling()
  {
    return B;
  }
  
  public static String getTID()
  {
    return v;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.a(paramContext, false);
    }
    return ai.a().c(paramContext);
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (k == null)
    {
      k = paramMap;
      return;
    }
    try
    {
      k.putAll(paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static void initX5Environment(Context paramContext, PreInitCallback paramPreInitCallback)
  {
    z = new g(paramContext, paramPreInitCallback);
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      ai.a().b(paramContext, true);
    }
    TbsDownloader.needDownload(paramContext, false, false, new h(paramContext, paramPreInitCallback));
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool2 = false;
    k localk = k.a(true);
    localk.a(paramContext, false, false, null);
    boolean bool1 = bool2;
    if (localk != null)
    {
      bool1 = bool2;
      if (localk.b()) {
        bool1 = localk.a().a(paramContext, paramString1, paramString2, paramBundle);
      }
    }
    return bool1;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Context localContext;
    int i1;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i1 = paramString1.indexOf("url=");
      if (i1 <= 0) {
        break label219;
      }
    }
    label177:
    label219:
    for (paramIntent = paramString1.substring(i1 + 4);; paramIntent = null)
    {
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent)) {}
      for (paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";; paramString1 = paramIntent)
      {
        if (d.a(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
        {
          paramString1 = bg.b();
          if ((paramString1 != null) && (paramString1.c()) && (paramString1.d().a(localContext, paramIntent, null, paramString2, null) == 0)) {
            return true;
          }
          if ((paramWebView instanceof android.webkit.WebView)) {
            break label177;
          }
          paramWebView.loadUrl(paramIntent);
        }
        for (;;)
        {
          return false;
          WebviewInstrumentation.loadUrl((android.webkit.WebView)paramWebView, paramIntent);
          continue;
          if (!(paramWebView instanceof android.webkit.WebView)) {
            paramWebView.loadUrl(paramString1);
          } else {
            WebviewInstrumentation.loadUrl((android.webkit.WebView)paramWebView, paramString1);
          }
        }
      }
    }
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = bg.b();
    if ((paramString2 != null) && (paramString2.c()))
    {
      paramContext = paramString2.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramContext != null) {
        if (!(paramContext instanceof Boolean)) {
          break label98;
        }
      }
    }
    label98:
    for (paramContext = (Boolean)paramContext;; paramContext = Boolean.valueOf(false))
    {
      return paramContext.booleanValue();
      return false;
      return false;
    }
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    k localk = k.a(false);
    boolean bool1 = bool2;
    if (localk != null)
    {
      bool1 = bool2;
      if (localk.g()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (ad.a(paramContext).c() == 2) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return false;
    }
    if (!b(paramContext)) {
      return true;
    }
    i1 = ai.a().c(paramContext);
    paramContext = u.a(o, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i1), Integer.valueOf(43000) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(Context paramContext, PreInitCallback paramPreInitCallback)
  {
    try
    {
      TbsLog.initIfNeed(paramContext);
      i = a;
      ah localah = new ah();
      localah.a("init_all", (byte)1);
      if (!p)
      {
        paramContext = new f(paramContext, localah, new e(Looper.getMainLooper(), paramPreInitCallback, paramContext, localah));
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        p = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void reset(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    try
    {
      TbsDownloader.stopDownload();
      TbsDownloader.b(paramContext);
      j.b(paramContext.getDir("tbs", 0));
      TbsLog.i("QbSdk", "delete downloaded apk success", true);
      ai.a.set(Integer.valueOf(0));
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring("QQ:".length());
    v = "0000000000000000".substring(paramString.length()) + paramString;
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    A = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    w = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    B = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    y = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return -100;
    }
    bg localbg = bg.b();
    localbg.a(paramContext, null);
    if (localbg.c())
    {
      if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487)) {
        return localbg.d().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
      }
      return -101;
    }
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return d.a(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return d.a(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = bg.b();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((bg)localObject).c())
          {
            localObject = ((bg)localObject).d().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    return d.a(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return false;
    }
    bg localbg = bg.b();
    localbg.a(paramContext, null);
    if (((paramHashMap == null) || (!"5".equals(paramHashMap.get("PosID"))) || (!localbg.c()) || ((Bundle)localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]) == null)) || (d.a(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0))
    {
      if (localbg.c()) {
        if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
        {
          if (localbg.d().a(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0) {
            return true;
          }
        }
        else {
          return false;
        }
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static void unForceSysWebView()
  {
    b = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean useSoftWare()
  {
    if (o == null) {
      return false;
    }
    Object localObject2 = u.a(o, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = o;
      localObject2 = Integer.TYPE;
      int i1 = a.a();
      localObject1 = u.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i1) });
    }
    if (localObject1 == null) {}
    for (boolean bool = false;; bool = ((Boolean)localObject1).booleanValue()) {
      return bool;
    }
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void onCoreInitFinished();
    
    public abstract void onViewInitFinished(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/tencent/smtt/sdk/QbSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */