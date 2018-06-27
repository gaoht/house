package com.growingio.android.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.provider.Settings;
import java.lang.reflect.Method;

public class PermissionUtil
{
  private static boolean a;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  private static boolean e = false;
  private static boolean f = false;
  private static boolean g;
  
  public static void a(Context paramContext)
  {
    if (e) {
      return;
    }
    a = a(paramContext, "android.permission.INTERNET");
    b = a(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    c = a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE");
    d = a(paramContext, "android.permission.SYSTEM_ALERT_WINDOW");
    f = a(paramContext, "android.permission.READ_PHONE_STATE");
    g = a(paramContext, "android.permission.ACCESS_WIFI_STATE");
    e = true;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (paramString.equals("android.permission.SYSTEM_ALERT_WINDOW"))) {
      try
      {
        boolean bool = ((Boolean)Settings.class.getDeclaredMethod("canDrawOverlays", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue();
        return bool;
      }
      catch (Exception localException) {}
    }
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean c()
  {
    return c;
  }
  
  public static boolean d()
  {
    return d;
  }
  
  public static boolean e()
  {
    return f;
  }
  
  public static boolean f()
  {
    return g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/PermissionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */