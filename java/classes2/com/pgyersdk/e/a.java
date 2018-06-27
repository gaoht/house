package com.pgyersdk.e;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.pgyersdk.i.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  static String a = "";
  public static b b = null;
  private static boolean c = false;
  
  private static String a(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  public static Map a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    NetworkInfo localNetworkInfo;
    if ((m.a().a(paramContext, "android.permission.INTERNET")) && (m.a().a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
    {
      localHashMap.put("network_permission", "true");
      localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo == null) || (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED)) {
        break label159;
      }
      localHashMap.put("network_state", "true");
      localHashMap.put("network_type", localNetworkInfo.getTypeName());
      if (localNetworkInfo.getType() != 0) {
        break label142;
      }
      localHashMap.put("network_subtype", localNetworkInfo.getSubtypeName());
      localHashMap.put("network_apn", localNetworkInfo.getExtraInfo());
    }
    for (;;)
    {
      return localHashMap;
      localHashMap.put("network_permission", "false");
      return localHashMap;
      label142:
      if (localNetworkInfo.getType() == 1)
      {
        a(paramContext, localHashMap);
        continue;
        label159:
        localHashMap.put("network_state", "false");
      }
    }
  }
  
  public static Map a(Context paramContext, Map paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (m.a().a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      ((Map)localObject).put("wifi_permission", "true");
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      paramMap = paramContext.getConnectionInfo();
      ((Map)localObject).put("wifi_mac_address", paramMap.getMacAddress());
      if (paramContext.getWifiState() != 3) {
        break label298;
      }
      ((Map)localObject).put("wifi_state", "true");
      ((Map)localObject).put("wifi_ip_address", a(paramMap.getIpAddress()));
      ((Map)localObject).put("wifi_ssid", paramMap.getSSID());
      ((Map)localObject).put("wifi_bssid", paramMap.getBSSID());
      ((Map)localObject).put("wifi_rssi", paramMap.getRssi() + "dB");
      ((Map)localObject).put("wifi_link_speed", paramMap.getLinkSpeed() + "Mbps");
      paramContext = paramContext.getConfiguredNetworks();
      if (paramContext != null) {
        break label237;
      }
      ((Map)localObject).put("wifi_state", "false");
    }
    for (;;)
    {
      return (Map)localObject;
      ((Map)localObject).put("wifi_permission", "false");
      return (Map)localObject;
      label237:
      int j = paramContext.size();
      int i = 0;
      while (i < j)
      {
        ((Map)localObject).put("wifi_config_" + i, ((WifiConfiguration)paramContext.get(i)).toString());
        i += 1;
      }
    }
    label298:
    ((Map)localObject).put("wifi_state", "false");
    return (Map)localObject;
  }
  
  public static String[] a()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l2;
    long l1;
    if (Build.VERSION.SDK_INT < 18)
    {
      l2 = localStatFs.getBlockSize();
      l1 = localStatFs.getBlockCount();
    }
    for (long l3 = localStatFs.getAvailableBlocks();; l3 = localStatFs.getAvailableBlocksLong())
    {
      arrayOfString[0] = m.a().a(l1 * l2);
      arrayOfString[1] = m.a().a(l2 * l3);
      return arrayOfString;
      l2 = localStatFs.getBlockSizeLong();
      l1 = localStatFs.getBlockCountLong();
    }
  }
  
  public static String[] b()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    StatFs localStatFs;
    long l2;
    long l1;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      if (Build.VERSION.SDK_INT >= 18) {
        break label104;
      }
      l2 = localStatFs.getBlockSize();
      l1 = localStatFs.getBlockCount();
    }
    for (long l3 = localStatFs.getAvailableBlocks();; l3 = localStatFs.getAvailableBlocksLong())
    {
      arrayOfString[0] = m.a().a(l1 * l2);
      arrayOfString[1] = m.a().a(l2 * l3);
      return arrayOfString;
      label104:
      l2 = localStatFs.getBlockSizeLong();
      l1 = localStatFs.getBlockCountLong();
    }
  }
  
  public static String[] b(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    if (Build.VERSION.SDK_INT < 16)
    {
      try
      {
        paramContext = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        l2 = 0L;
      }
      catch (IOException paramContext)
      {
        try
        {
          for (;;)
          {
            str = paramContext.readLine();
            if (str == null) {
              break;
            }
            long l2 = l1;
            if (str != null)
            {
              l2 = l1;
              if (str.contains("MemTotal")) {
                l2 = Long.parseLong(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim()) * 1024L;
              }
            }
          }
          paramContext.close();
          return new String[] { m.a().a(l1), m.a().a(localMemoryInfo.availMem) };
        }
        catch (IOException paramContext)
        {
          long l1;
          for (;;) {}
        }
        paramContext = paramContext;
        l1 = 0L;
      }
      l1 = l2;
    }
    for (;;)
    {
      String str;
      m.a().a("DeviceHelper", paramContext);
      continue;
      l1 = localMemoryInfo.totalMem;
    }
  }
  
  public static boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String[] c(Context paramContext)
  {
    paramContext = d(paramContext);
    return new String[] { paramContext.widthPixels + "*" + paramContext.heightPixels, String.valueOf(paramContext.density), String.valueOf(paramContext.densityDpi) };
  }
  
  public static DisplayMetrics d(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  /* Error */
  public static void f(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/pgyersdk/e/a:b	Lcom/pgyersdk/e/b;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getstatic 20	com/pgyersdk/e/a:b	Lcom/pgyersdk/e/b;
    //   19: invokevirtual 381	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   22: aconst_null
    //   23: putstatic 20	com/pgyersdk/e/a:b	Lcom/pgyersdk/e/b;
    //   26: iconst_0
    //   27: putstatic 14	com/pgyersdk/e/a:c	Z
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: astore_0
    //   41: goto -11 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	paramContext	Context
    //   6	2	1	localb	b
    // Exception table:
    //   from	to	target	type
    //   3	7	34	finally
    //   15	30	34	finally
    //   15	30	40	java/lang/Exception
  }
  
  public static String g(Context paramContext)
  {
    return a;
  }
  
  public static String h(Context paramContext)
  {
    int i = Integer.valueOf(c(paramContext)[2]).intValue();
    if (i < 160) {
      return "mdpi";
    }
    if ((i >= 160) && (i <= 240)) {
      return "hdpi";
    }
    if ((i > 240) && (i <= 320)) {
      return "xhdpi";
    }
    if ((i > 320) && (i <= 480)) {
      return "xxhdpi";
    }
    return "xxxhdpi";
  }
  
  public void e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        boolean bool = c;
        if (!bool) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        IntentFilter localIntentFilter;
        continue;
      }
      finally {}
      return;
      localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
      b = new b(this);
      paramContext.registerReceiver(b, localIntentFilter);
      c = true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */