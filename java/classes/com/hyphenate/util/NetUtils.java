package com.hyphenate.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public class NetUtils
{
  private static final int HIGH_SPEED_DOWNLOAD_BUF_SIZE = 30720;
  private static final int HIGH_SPEED_UPLOAD_BUF_SIZE = 10240;
  private static final int LOW_SPEED_DOWNLOAD_BUF_SIZE = 2024;
  private static final int LOW_SPEED_UPLOAD_BUF_SIZE = 1024;
  private static final int MAX_SPEED_DOWNLOAD_BUF_SIZE = 102400;
  private static final int MAX_SPEED_UPLOAD_BUF_SIZE = 102400;
  private static final String TAG = "net";
  
  public static int getDownloadBufSize(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1)) {
      return 102400;
    }
    if ((Build.VERSION.SDK_INT >= 13) && (paramContext != null) && (paramContext.getType() == 9)) {
      return 102400;
    }
    if ((paramContext == null) && (isConnectionFast(paramContext.getType(), paramContext.getSubtype()))) {
      return 30720;
    }
    return 2024;
  }
  
  public static String getNetworkType(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      int i = localNetworkInfo.getType();
      if ((Build.VERSION.SDK_INT >= 13) && (i == 9)) {
        return "ETHERNET";
      }
      if (i == 1) {
        return "WIFI";
      }
      switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
      {
      default: 
        return "unkonw network";
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        return "2G";
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        return "3G";
      }
      return "4G";
    }
    return "no network";
  }
  
  public static int getUploadBufSize(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1)) {
      return 102400;
    }
    if ((Build.VERSION.SDK_INT >= 13) && (paramContext != null) && (paramContext.getType() == 9)) {
      return 102400;
    }
    if ((paramContext == null) && (isConnectionFast(paramContext.getType(), paramContext.getSubtype()))) {
      return 10240;
    }
    return 1024;
  }
  
  public static String getWiFiSSID(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    try
    {
      paramContext = paramContext.getConnectionInfo().getSSID();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  @TargetApi(13)
  public static boolean hasDataConnection(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(1);
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected()))
      {
        EMLog.d("net", "has wifi connection");
        return true;
      }
      localNetworkInfo = paramContext.getNetworkInfo(0);
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected()))
      {
        EMLog.d("net", "has mobile connection");
        return true;
      }
      if (Build.VERSION.SDK_INT >= 13)
      {
        paramContext = paramContext.getNetworkInfo(9);
        if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
        {
          EMLog.d("net", "has ethernet connection");
          return true;
        }
      }
      EMLog.d("net", "no data connection");
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean hasNetwork(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
      return false;
    }
    return false;
  }
  
  private static boolean isConnectionFast(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {}
    do
    {
      do
      {
        return true;
      } while ((Build.VERSION.SDK_INT >= 13) && (paramInt1 == 9));
      if (paramInt1 != 0) {
        break;
      }
      switch (paramInt2)
      {
      }
    } while (((Build.VERSION.SDK_INT >= 11) && ((paramInt2 == 14) || (paramInt2 == 13))) || ((Build.VERSION.SDK_INT >= 9) && (paramInt2 == 12)));
    if ((Build.VERSION.SDK_INT >= 8) && (paramInt2 == 11))
    {
      return false;
      return false;
      return false;
      return false;
      return false;
    }
    return false;
  }
  
  public static boolean isEthernetConnected(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 13)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(9);
      if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
      {
        EMLog.d("net", "ethernet is connected");
        return true;
      }
    }
    return false;
  }
  
  @Deprecated
  public static boolean isEthernetConnection(Context paramContext)
  {
    return isEthernetConnected(paramContext);
  }
  
  public static boolean isMobileConnected(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(0);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
    {
      EMLog.d("net", "mobile is connected");
      return true;
    }
    return false;
  }
  
  @Deprecated
  public static boolean isMobileConnection(Context paramContext)
  {
    return isMobileConnected(paramContext);
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
    {
      EMLog.d("net", "wifi is connected");
      return true;
    }
    return false;
  }
  
  @Deprecated
  public static boolean isWifiConnection(Context paramContext)
  {
    return isWifiConnected(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/util/NetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */