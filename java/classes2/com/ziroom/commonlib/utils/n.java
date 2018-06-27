package com.ziroom.commonlib.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class n
{
  public static String GetNetworkType()
  {
    Object localObject = ((ConnectivityManager)d.a.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
      if (((NetworkInfo)localObject).getType() == 1) {
        localObject = "WIFI";
      }
    }
    for (;;)
    {
      l.e("lanzhihong", "Network Type : " + (String)localObject);
      return (String)localObject;
      if (((NetworkInfo)localObject).getType() == 0)
      {
        String str = ((NetworkInfo)localObject).getSubtypeName();
        int i = ((NetworkInfo)localObject).getSubtype();
        switch (i)
        {
        default: 
          if ((!str.equalsIgnoreCase("TD-SCDMA")) && (!str.equalsIgnoreCase("WCDMA")))
          {
            localObject = str;
            if (!str.equalsIgnoreCase("CDMA2000")) {
              break;
            }
          }
          else
          {
            localObject = "3G";
          }
          break;
        }
        for (;;)
        {
          l.e("lanzhihong", "Network getSubtype : " + Integer.valueOf(i).toString());
          break;
          localObject = "2G";
          continue;
          localObject = "3G";
          continue;
          localObject = "4G";
        }
      }
      localObject = "";
    }
  }
  
  private static String a()
  {
    int i = ((WifiManager)d.a.getSystemService("wifi")).getConnectionInfo().getIpAddress();
    return String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
  }
  
  private static String b()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      Object localObject = localInetAddress.getHostAddress().toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, String> getHeaderMap(Context paramContext)
  {
    paramContext = new HashMap();
    String str1 = m.getUid();
    String str2 = m.getToken();
    paramContext.put("Client-Version", f.getAppVersion());
    paramContext.put("Client-Type", "1");
    paramContext.put("User-Agent", f.getUserAgent());
    if (r.notNull(str1)) {
      paramContext.put("uid", str1);
    }
    if (r.notNull(str2)) {
      paramContext.put("token", str2);
    }
    paramContext.put("source", "1");
    if (r.notNull(c.c)) {
      paramContext.put("cityCode", c.c);
    }
    return paramContext;
  }
  
  public static Map<String, String> getHeaderMap2(Context paramContext)
  {
    paramContext = new HashMap();
    String str1 = m.getUid();
    String str2 = m.getToken();
    paramContext.put("Client-Version", f.getAppVersion());
    paramContext.put("Client-Type", "1");
    paramContext.put("User-Agent", f.getUserAgent());
    if (r.notNull(str1)) {
      paramContext.put("uid", str1);
    }
    if (r.notNull(str2)) {
      paramContext.put("token", str2);
    }
    paramContext.put("source", "1");
    if (r.notNull(c.c)) {
      paramContext.put("cityCode", c.c);
    }
    return paramContext;
  }
  
  public static String getIp()
  {
    if (netType2Int(GetNetworkType()) == 4) {
      return a();
    }
    return b();
  }
  
  public static Map<String, Object> getPhoneInfo()
  {
    Object localObject = (TelephonyManager)d.a.getSystemService("phone");
    String str1 = ((TelephonyManager)localObject).getDeviceId();
    String str2 = ((TelephonyManager)localObject).getLine1Number();
    String str3 = ((TelephonyManager)localObject).getSimSerialNumber();
    String str4 = ((TelephonyManager)localObject).getSubscriberId();
    String str5 = Build.MODEL;
    String str6 = Build.BRAND;
    String str7 = Build.VERSION.RELEASE;
    double d1 = k.getLatitude();
    double d2 = k.getLongitude();
    localObject = new HashMap();
    ((Map)localObject).put("versionName", f.getVersion());
    ((Map)localObject).put("versionCode", Integer.valueOf(c.e));
    ((Map)localObject).put("deviceId", str1);
    ((Map)localObject).put("phoneModel", str5);
    ((Map)localObject).put("phoneBrand", str6);
    ((Map)localObject).put("imei", str3);
    ((Map)localObject).put("imsi", str4);
    ((Map)localObject).put("macAddress", f.getMac());
    ((Map)localObject).put("tel", str2);
    ((Map)localObject).put("osVersion", str7);
    ((Map)localObject).put("osType", "1");
    ((Map)localObject).put("appName", c.d);
    ((Map)localObject).put("netWork", netType2Int(GetNetworkType()) + "");
    ((Map)localObject).put("channelName", f.getMetaData("UMENG_CHANNEL"));
    ((Map)localObject).put("deviceIP", getIp());
    if ((d2 > 0.0D) && (d1 > 0.0D))
    {
      str1 = r.getNumberFormat(d2, 15);
      str2 = r.getNumberFormat(d1, 15);
      ((Map)localObject).put("locationCoordinate", str1 + "," + str2);
    }
    return (Map<String, Object>)localObject;
  }
  
  public static boolean isGpsEnabled()
  {
    List localList = ((LocationManager)d.a.getSystemService("location")).getProviders(true);
    return (localList != null) && (localList.size() > 0);
  }
  
  public static boolean isNetworkAvailable()
  {
    Object localObject = d.a;
    Application localApplication = d.a;
    localObject = (ConnectivityManager)((Application)localObject).getSystemService("connectivity");
    if (localObject == null) {}
    for (;;)
    {
      return false;
      localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          if (localObject[i].getState() == NetworkInfo.State.CONNECTED) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static String map2GetUrl(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString.contains("?")) {
      localStringBuilder.append("&");
    }
    for (;;)
    {
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramMap = (Map.Entry)localIterator.next();
            String str = (String)paramMap.getKey();
            Object localObject = paramMap.getValue();
            if (localObject != null)
            {
              paramMap = (Map<String, String>)localObject;
              if ((localObject instanceof String)) {}
              try
              {
                paramMap = URLEncoder.encode(localObject.toString(), "UTF-8");
                localStringBuilder.append(str).append("=").append(paramMap).append("&");
                continue;
                localStringBuilder.append("?");
              }
              catch (UnsupportedEncodingException paramMap)
              {
                for (;;)
                {
                  paramMap.printStackTrace();
                  paramMap = (Map<String, String>)localObject;
                }
              }
            }
          }
        }
      }
    }
    return paramString + localStringBuilder.toString();
  }
  
  public static int netType2Int(String paramString)
  {
    int j = 1;
    label48:
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        j = -1;
      case 1: 
        return j;
        if (!paramString.equals("WIFI")) {
          break label48;
        }
        i = 0;
        continue;
        if (!paramString.equals("2G")) {
          break label48;
        }
        i = 1;
        continue;
        if (!paramString.equals("3G")) {
          break label48;
        }
        i = 2;
        continue;
        if (!paramString.equals("4G")) {
          break label48;
        }
        i = 3;
      }
    }
    return 4;
    return 2;
    return 3;
  }
  
  public static void openWirelessSettings(Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 10)
    {
      paramContext.startActivity(new Intent("android.settings.SETTINGS"));
      return;
    }
    paramContext.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */