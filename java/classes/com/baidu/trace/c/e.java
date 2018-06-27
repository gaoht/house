package com.baidu.trace.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.trace.TraceJniInterface;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.TraceLocation;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  public static String a = "4G";
  public static String b = "yingyan";
  public static String c = "com.baidu.trace";
  public static int d = 0;
  private static final Pattern e = Pattern.compile("^(?!_)[a-zA-Z0-9_\\-]{1,128}");
  private static final Pattern f = Pattern.compile("[a-zA-Z0-9_\\-一-龥]{1,128}");
  private static final SimpleDateFormat g;
  private static List<ScanResult> h;
  private static List<ScanResult> i;
  private static WifiManager j;
  private static boolean k = false;
  
  static
  {
    new DecimalFormat("#0.##");
    g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    j = null;
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    double d1 = a(paramLatLng1.latitude);
    double d2 = a(paramLatLng2.latitude);
    double d3 = a(paramLatLng1.longitude);
    double d4 = a(paramLatLng2.longitude);
    double d5 = Math.pow(Math.sin((d1 - d2) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(d1) * Math.cos(d2) * Math.pow(Math.sin((d3 - d4) / 2.0D), 2.0D) + d5)) * 2.0D * 6378.137D * 10000.0D) / 10L;
  }
  
  public static int a()
  {
    return (int)(System.currentTimeMillis() / 1000L);
  }
  
  public static void a(int paramInt1, int paramInt2, TreeMap<String, String> paramTreeMap)
  {
    if (paramInt1 > 0) {
      paramTreeMap.put("page_index", String.valueOf(paramInt1));
    }
    if (paramInt2 > 0) {
      paramTreeMap.put("page_size", String.valueOf(paramInt2));
    }
  }
  
  public static void a(Context paramContext)
  {
    if (k) {
      return;
    }
    Object localObject = paramContext.getPackageManager();
    b = paramContext.getApplicationInfo().loadLabel((PackageManager)localObject).toString();
    localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {}
    do
    {
      c(paramContext);
      k = true;
      return;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } while ((localObject == null) || (!((NetworkInfo)localObject).isAvailable()));
    if (1 == ((NetworkInfo)localObject).getType()) {
      a = "WIFI";
    }
    for (;;)
    {
      localObject = a;
      break;
      if (((NetworkInfo)localObject).getType() == 0)
      {
        String str = ((NetworkInfo)localObject).getSubtypeName();
        switch (((NetworkInfo)localObject).getSubtype())
        {
        default: 
          if ((str.equalsIgnoreCase("TD-SCDMA")) || (str.equalsIgnoreCase("WCDMA")) || (str.equalsIgnoreCase("CDMA2000"))) {
            a = "3G";
          }
          break;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          a = "2G";
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          a = "3G";
          break;
        case 13: 
          a = "4G";
          continue;
          a = str;
        }
      }
    }
  }
  
  public static void a(TraceLocation paramTraceLocation)
  {
    double[] arrayOfDouble = TraceJniInterface.wgsToBaidu(paramTraceLocation.getLatitude(), paramTraceLocation.getLongitude());
    if ((arrayOfDouble != null) && (2 == arrayOfDouble.length))
    {
      paramTraceLocation.setLatitude(arrayOfDouble[0]);
      paramTraceLocation.setLongitude(arrayOfDouble[1]);
      paramTraceLocation.setCoordType(CoordType.bd09ll);
      return;
    }
    paramTraceLocation.setCoordType(CoordType.wgs84);
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 <= paramInt3);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getRunningServices(128);
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if (paramString.equals(((ActivityManager.RunningServiceInfo)paramContext.next()).service.getClassName().toString())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {}
    while ((180.0D <= Math.abs(paramLatLng.longitude)) || (90.0D <= Math.abs(paramLatLng.latitude))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return f.matcher(paramString).matches();
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    int i2 = paramList1.size();
    int i3 = paramList2.size();
    int i4 = i2 + i3;
    if ((i2 == 0) || (i3 == 0)) {
      return false;
    }
    int n = 0;
    int m = 0;
    String str;
    if (n < i2)
    {
      str = ((ScanResult)paramList1.get(n)).BSSID;
      if (str != null) {}
    }
    for (;;)
    {
      n += 1;
      break;
      int i1 = 0;
      for (;;)
      {
        if (i1 < i3)
        {
          if (str.equals(((ScanResult)paramList2.get(i1)).BSSID))
          {
            m += 1;
            break;
          }
          i1 += 1;
          continue;
          n = (int)(i4 * 0.5F);
          if ((i2 <= 5) || (i3 <= 5)) {
            return m << 1 == i4;
          }
          return m << 1 > n;
        }
      }
    }
  }
  
  public static long b()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        if (paramContext.getSimSerialNumber() == null) {
          return "";
        }
        paramContext = paramContext.getSimSerialNumber();
        return paramContext;
      }
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return e.matcher(paramString).matches();
  }
  
  public static long c(String paramString)
  {
    try
    {
      long l = g.parse(paramString).getTime() / 1000L;
      return l;
    }
    catch (ParseException paramString) {}
    return 0L;
  }
  
  public static String c()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localCalendar.getTime());
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      c = paramContext.getPackageName();
      return c;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static boolean d(Context paramContext)
  {
    if (j == null) {
      j = (WifiManager)paramContext.getSystemService("wifi");
    }
    j.startScan();
    h = j.getScanResults();
    if ((i == null) || (i.size() == 0))
    {
      i = h;
      return false;
    }
    if (a(h, i)) {
      return true;
    }
    i = null;
    i = h;
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
      return true;
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    label49:
    label52:
    for (;;)
    {
      return true;
      int m;
      if (paramContext.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0)
      {
        m = 1;
        if (paramContext.checkSelfPermission("android.permission.CHANGE_WIFI_STATE") != 0) {
          break label49;
        }
      }
      for (int n = 1;; n = 0)
      {
        if ((m != 0) && (n != 0)) {
          break label52;
        }
        return false;
        m = 0;
        break;
      }
    }
  }
  
  public static boolean g(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    label49:
    label52:
    for (;;)
    {
      return true;
      int m;
      if (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
      {
        m = 1;
        if (paramContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
          break label49;
        }
      }
      for (int n = 1;; n = 0)
      {
        if ((m != 0) && (n != 0)) {
          break label52;
        }
        return false;
        m = 0;
        break;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */