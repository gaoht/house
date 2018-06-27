package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.telephony.TelephonyManager;

public class ag
{
  public static final Uri a = Uri.parse("content://telephony/carriers");
  public static final Uri b = Uri.parse("content://telephony/carriers/preferapn");
  public static final Uri c = Uri.parse("content://telephony/carriers/current");
  private static final String d = ag.class.getSimpleName();
  
  public static boolean IsNetNetwork(Context paramContext)
  {
    return getCurrentApn(paramContext) == 2;
  }
  
  public static boolean IsWapNetWork(Context paramContext)
  {
    return getCurrentApn(paramContext) == 1;
  }
  
  private static ConnectivityManager a(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  private static NetworkInfo b(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getActiveNetworkInfo();
  }
  
  private static int c(Context paramContext)
  {
    paramContext = b(paramContext);
    if (paramContext != null) {
      return paramContext.getType();
    }
    return -1;
  }
  
  public static int getCurrentApn(Context paramContext)
  {
    paramContext = b(paramContext);
    if (paramContext != null)
    {
      if ((paramContext.getState() == NetworkInfo.State.CONNECTED) && (paramContext.getExtraInfo() != null) && (paramContext.getExtraInfo().toLowerCase().endsWith("wap")))
      {
        u.d(d, paramContext.getExtraInfo().toLowerCase());
        return 1;
      }
      return 2;
    }
    return -1;
  }
  
  public static String getWebType(int paramInt)
  {
    if ((paramInt >= 4) && (paramInt <= 5)) {
      return "联通";
    }
    return "电信";
  }
  
  public static boolean goNetSetting(Context paramContext)
  {
    if (isNetAvailable(paramContext)) {
      return true;
    }
    Intent localIntent = new Intent("android.settings.WIRELESS_SETTINGS");
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
    return false;
  }
  
  public static boolean isConnectionFast(Context paramContext)
  {
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    default: 
      return false;
    case 7: 
      return false;
    case 4: 
      u.d(d, "电信2g NETWORK_TYPE_CDMA");
      return false;
    case 2: 
      u.d(d, "移动联通2g NETWORK_TYPE_EDGE");
      return false;
    case 5: 
      u.d(d, "电信3g NETWORK_TYPE_EVDO_0");
      return true;
    case 6: 
      u.d(d, "电信3g NETWORK_TYPE_EVDO_A");
      return true;
    case 1: 
      u.d(d, "移动联通2g NETWORK_TYPE_GPRS");
      return false;
    case 8: 
      u.d(d, "联通3g NETWORK_TYPE_HSDPA");
      return true;
    case 10: 
      return true;
    case 9: 
      return true;
    case 3: 
      u.d(d, "联通3g NETWORK_TYPE_UMTS");
      return true;
    }
    return false;
  }
  
  public static boolean isCtwap(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = b(paramContext);
      bool1 = bool2;
      if (paramContext != null) {
        if (paramContext.getExtraInfo() != null)
        {
          bool1 = bool2;
          if (!paramContext.getExtraInfo().equals("")) {}
        }
        else
        {
          bool1 = bool2;
          if (paramContext.getExtraInfo().toLowerCase().contains("ctwap")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isMobileNetWrok(Context paramContext)
  {
    return c(paramContext) == 0;
  }
  
  public static boolean isNetAvailable(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = b(paramContext);
      if ((paramContext != null) && (paramContext.isAvailable()))
      {
        u.d(d, "PhoneWrap.CheckNetWrokAvailable network:" + paramContext.getTypeName() + " subTypeName:" + paramContext.getSubtypeName() + "." + paramContext.getExtraInfo() + " isAvailable:" + paramContext.isAvailable());
        return true;
      }
    }
    return false;
  }
  
  public static boolean isWifiNetWork(Context paramContext)
  {
    return c(paramContext) == 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */