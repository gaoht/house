package com.unionpay.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

public final class d
{
  public static String a()
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
  
  public static final String a(Context paramContext)
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
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String c(Context paramContext)
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
  
  public static Location d(Context paramContext)
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
  
  public static String e(Context paramContext)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */