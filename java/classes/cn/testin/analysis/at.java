package cn.testin.analysis;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.RandomAccessFile;

public class at
{
  private static String a = "";
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
    case 16: 
      return 1;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      return 2;
    }
    return 3;
  }
  
  public static String a(Context paramContext)
  {
    int i = 0;
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (a.k))
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "/sys/class/net/wlan0/address";
      arrayOfString[1] = "/sys/class/net/eth0/address";
      arrayOfString[2] = "/sys/devices/virtual/net/wlan0/address";
      int j = arrayOfString.length;
      while (i < j)
      {
        String str1 = arrayOfString[i];
        try
        {
          String str2 = new RandomAccessFile(str1, "r").readLine();
          if (!TextUtils.isEmpty(str2))
          {
            a = str2;
            ar.f("found address in:" + str1);
            str2 = a;
            return str2;
          }
        }
        catch (Exception localException)
        {
          ar.f("not found address in:" + str1);
          i += 1;
        }
      }
    }
    if ((TextUtils.isEmpty(a)) && (al.b(paramContext, "android.permission.ACCESS_WIFI_STATE"))) {}
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null) {
        a = paramContext.getConnectionInfo().getMacAddress();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ar.a(paramContext);
      }
    }
    return a;
  }
  
  public static String b(Context paramContext)
  {
    switch (c(paramContext))
    {
    case -2: 
    case -1: 
    default: 
      return "unknown";
    case 0: 
      return "wifi";
    case 1: 
      return "2g";
    case 2: 
      return "3g";
    case 3: 
      return "4g";
    }
    return "";
  }
  
  public static int c(Context paramContext)
  {
    if (!al.b(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
      return -3;
    }
    int i;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isAvailable())) {
          break label87;
        }
        if (paramContext.getType() == 1) {
          i = 0;
        } else if (paramContext.getType() == 0) {
          i = a(paramContext.getSubtype());
        }
      }
    }
    catch (Exception paramContext)
    {
      ar.a(paramContext);
      i = -3;
    }
    label87:
    return -2;
    return i;
  }
  
  public static boolean d(Context paramContext)
  {
    int i = c(paramContext);
    return (i == 0) || (-3 == i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */