package com.baidu.platform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.mapapi.VersionInfo;
import com.baidu.platform.comjni.map.commonmemcache.a;
import java.io.File;

public class f
{
  public static String A;
  private static final String B = f.class.getSimpleName();
  private static boolean C = true;
  private static int D = 0;
  private static int E = 0;
  static a a = new a();
  static String b = "02";
  static String c;
  static String d;
  static String e;
  static String f;
  static int g;
  static int h;
  static int i;
  static int j;
  static int k;
  static int l;
  static String m;
  static String n;
  static String o = "baidu";
  static String p = "baidu";
  static String q = "";
  static String r = "";
  static String s = "";
  static String t;
  static String u;
  static String v = "-1";
  static String w = "-1";
  public static Context x;
  public static final int y = Integer.parseInt(Build.VERSION.SDK);
  public static float z = 1.0F;
  
  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cpu", q);
    localBundle.putString("resid", b);
    localBundle.putString("channel", o);
    localBundle.putString("glr", r);
    localBundle.putString("glv", s);
    localBundle.putString("mb", f());
    localBundle.putString("sv", h());
    localBundle.putString("os", j());
    localBundle.putInt("dpi_x", k());
    localBundle.putInt("dpi_y", k());
    localBundle.putString("net", m);
    localBundle.putString("cuid", m());
    localBundle.putByteArray("signature", a(x));
    localBundle.putString("pcn", x.getPackageName());
    localBundle.putInt("screen_x", g());
    localBundle.putInt("screen_y", i());
    return localBundle;
  }
  
  public static void a(String paramString)
  {
    m = paramString;
    e();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    v = paramString2;
    w = paramString1;
    e();
  }
  
  public static byte[] a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void b()
  {
    if (a != null) {
      a.a();
    }
  }
  
  public static void b(Context paramContext)
  {
    x = paramContext;
    t = paramContext.getFilesDir().getAbsolutePath();
    u = paramContext.getCacheDir().getAbsolutePath();
    d = Build.MODEL;
    e = "Android" + Build.VERSION.SDK;
    c = paramContext.getPackageName();
    c(paramContext);
    d(paramContext);
    e(paramContext);
    f(paramContext);
    try
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      if (paramContext.isProviderEnabled("gps"))
      {
        i1 = 1;
        D = i1;
        if (!paramContext.isProviderEnabled("network")) {
          break label126;
        }
      }
      label126:
      for (int i1 = 1;; i1 = 0)
      {
        E = i1;
        return;
        i1 = 0;
        break;
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.w("baidumapsdk", "LocationManager error");
    }
  }
  
  public static String c()
  {
    if (a != null) {
      return a.b();
    }
    return null;
  }
  
  private static void c(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      f = VersionInfo.getApiVersion();
      if ((f != null) && (!f.equals(""))) {
        f = f.replace('_', '.');
      }
      g = paramContext.versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      f = "1.0.0";
      g = 1;
    }
  }
  
  public static String d()
  {
    return m;
  }
  
  private static void d(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (paramContext != null) {}
    for (paramContext = paramContext.getDefaultDisplay();; paramContext = null)
    {
      if (paramContext != null)
      {
        h = paramContext.getWidth();
        i = paramContext.getHeight();
        paramContext.getMetrics(localDisplayMetrics);
      }
      z = localDisplayMetrics.density;
      j = (int)localDisplayMetrics.xdpi;
      k = (int)localDisplayMetrics.ydpi;
      if (y > 3) {}
      for (l = localDisplayMetrics.densityDpi;; l = 160)
      {
        if (l == 0) {
          l = 160;
        }
        return;
      }
    }
  }
  
  public static void e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cpu", q);
    localBundle.putString("resid", b);
    localBundle.putString("channel", o);
    localBundle.putString("glr", r);
    localBundle.putString("glv", s);
    localBundle.putString("mb", f());
    localBundle.putString("sv", h());
    localBundle.putString("os", j());
    localBundle.putInt("dpi_x", k());
    localBundle.putInt("dpi_y", k());
    localBundle.putString("net", m);
    localBundle.putString("cuid", m());
    localBundle.putString("pcn", x.getPackageName());
    localBundle.putInt("screen_x", g());
    localBundle.putInt("screen_y", i());
    localBundle.putString("appid", v);
    localBundle.putString("duid", w);
    if (!TextUtils.isEmpty(A)) {
      localBundle.putString("token", A);
    }
    if (a != null) {
      a.a(localBundle);
    }
  }
  
  private static void e(Context paramContext)
  {
    n = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String f()
  {
    return d;
  }
  
  private static void f(Context paramContext)
  {
    m = "0";
  }
  
  public static int g()
  {
    return h;
  }
  
  public static String h()
  {
    return f;
  }
  
  public static int i()
  {
    return i;
  }
  
  public static String j()
  {
    return e;
  }
  
  public static int k()
  {
    return l;
  }
  
  public static String l()
  {
    return t;
  }
  
  public static String m()
  {
    try
    {
      String str1 = CommonParam.a(x);
      String str3 = str1;
      if (str1 == null) {
        str3 = "";
      }
      return str3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "";
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */