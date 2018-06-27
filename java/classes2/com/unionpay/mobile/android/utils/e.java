package com.unionpay.mobile.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

public final class e
{
  public static String a()
  {
    if (Locale.getDefault().toString().startsWith("zh")) {
      return "zh_CN";
    }
    return "en_US";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (Activity)paramContext;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 4160).versionName;
      return c.bD.a;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static String b()
  {
    if (new File("/system/bin/su").exists()) {
      return "1";
    }
    return "0";
  }
  
  public static String b(Context paramContext)
  {
    paramContext = ((Activity)paramContext).getPackageName();
    if (paramContext != null) {
      return paramContext;
    }
    return "";
  }
  
  public static String c()
  {
    String str = Build.MODEL.trim();
    if (str != null) {
      str.replace(" ", "");
    }
    return str;
  }
  
  public static final String c(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if ((paramContext != null) && (paramContext.getMacAddress() != null))
      {
        paramContext = paramContext.getMacAddress().replaceAll(":", "");
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      return "";
    }
    return "";
  }
  
  public static String d()
  {
    return (a.I + "*" + a.t).trim();
  }
  
  public static String d(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (!new File("/system/bin/su").exists()) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        str1 = c(paramContext);
      }
      catch (Exception localException)
      {
        int i;
        String str1;
        String str3;
        String str2 = "";
        continue;
      }
      if (str1 != null)
      {
        str3 = str1;
        if (str1.length() != 0) {}
      }
      else
      {
        str3 = PreferenceUtils.a(paramContext);
      }
      j.a("uppay", "user=" + str3);
      return str3;
      i = 0;
      continue;
      str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
  }
  
  public static String e()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      Object localObject2 = ((Class)localObject1).newInstance();
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject2, new Object[] { "gsm.version.baseband", "no message" });
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String f()
  {
    return TimeZone.getDefault().getDisplayName(false, 0);
  }
  
  public static String f(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null) {
      return "disConnect";
    }
    if (paramContext.isAvailable())
    {
      if (paramContext.getType() == 0)
      {
        if (paramContext.getState() == NetworkInfo.State.CONNECTED) {
          return "mobile:" + paramContext.getExtraInfo();
        }
        return "mobile";
      }
      if (paramContext.getType() == 1) {
        return "wifi";
      }
      return "other";
    }
    return "disConnect";
  }
  
  public static Location g(Context paramContext)
  {
    paramContext = (LocationManager)paramContext.getSystemService("location");
    try
    {
      if (paramContext.isProviderEnabled("gps")) {
        return paramContext.getLastKnownLocation("gps");
      }
      if (paramContext.isProviderEnabled("network"))
      {
        paramContext = paramContext.getLastKnownLocation("network");
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String h(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = paramContext.getLine1Number();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */