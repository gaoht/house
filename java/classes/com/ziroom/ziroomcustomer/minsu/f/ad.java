package com.ziroom.ziroomcustomer.minsu.f;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import com.b.c.c.k;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLimitRulesBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLimitRulesBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MsHistorySBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ad
{
  private static String a;
  
  public static Map<String, String> ConvertObjMap2String(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      if ((paramMap.getValue() instanceof String))
      {
        localHashMap.put(paramMap.getKey(), (String)paramMap.getValue());
      }
      else if ((paramMap.getValue() instanceof Integer))
      {
        localHashMap.put(paramMap.getKey(), String.valueOf(paramMap.getValue()));
      }
      else if ((paramMap == null) || (paramMap.getValue() == null))
      {
        com.freelxl.baselibrary.f.d.e("lanzhihong", "Utils.ConvertObjMap2String=== null");
      }
      else
      {
        localHashMap.put(paramMap.getKey(), String.valueOf(paramMap.getValue()));
        if ("Utils.ConvertObjMap2String===" + paramMap.getValue() + "======" + paramMap.getValue() == null) {}
        for (paramMap = "null";; paramMap = paramMap.getValue().getClass())
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", paramMap);
          break;
        }
      }
    }
    return localHashMap;
  }
  
  public static String GetNetworkType()
  {
    Object localObject = ((ConnectivityManager)ApplicationEx.c.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
      if (((NetworkInfo)localObject).getType() == 1) {
        localObject = "WIFI";
      }
    }
    for (;;)
    {
      com.freelxl.baselibrary.f.d.e("lanzhihong", "Network Type : " + (String)localObject);
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
          com.freelxl.baselibrary.f.d.e("lanzhihong", "Network getSubtype : " + Integer.valueOf(i).toString());
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
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF).toUpperCase();
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean checkImg(Activity paramActivity, String paramString)
  {
    Object localObject = aa.getString(ApplicationEx.c, "limitRulesBean", "");
    HashMap localHashMap;
    double d1;
    double d2;
    if (!ae.isNull((String)localObject))
    {
      localObject = (MinsuLimitRulesBean)com.alibaba.fastjson.a.parseObject((String)localObject, MinsuLimitRulesBean.class);
      if ((localObject != null) && (((MinsuLimitRulesBean)localObject).data != null))
      {
        localHashMap = new HashMap();
        if (((MinsuLimitRulesBean)localObject).data.minPixel > 0) {
          localHashMap.put("minPixel", Integer.valueOf(((MinsuLimitRulesBean)localObject).data.minPixel));
        }
        if (((MinsuLimitRulesBean)localObject).data.minPixel > 0) {
          localHashMap.put("minDpi", Integer.valueOf(((MinsuLimitRulesBean)localObject).data.minDpi));
        }
        if (((MinsuLimitRulesBean)localObject).data.minPixel > 0) {
          localHashMap.put("widthScale", Integer.valueOf(((MinsuLimitRulesBean)localObject).data.widthScale));
        }
        if (((MinsuLimitRulesBean)localObject).data.minPixel > 0) {
          localHashMap.put("heightScale", Integer.valueOf(((MinsuLimitRulesBean)localObject).data.heightScale));
        }
        if (((MinsuLimitRulesBean)localObject).data.minPixel > 0) {
          localHashMap.put("maxSize", Integer.valueOf(((MinsuLimitRulesBean)localObject).data.maxSize));
        }
        if (((MinsuLimitRulesBean)localObject).data.widthPixel > 0) {
          localHashMap.put("widthPixel", Integer.valueOf(((MinsuLimitRulesBean)localObject).data.widthPixel));
        }
        if (((MinsuLimitRulesBean)localObject).data.heightPixel > 0) {
          localHashMap.put("heightPixel", Integer.valueOf(((MinsuLimitRulesBean)localObject).data.heightPixel));
        }
        d1 = ((MinsuLimitRulesBean)localObject).data.upperLimitRate;
        d2 = ((MinsuLimitRulesBean)localObject).data.lowerLimitRate;
      }
    }
    try
    {
      boolean bool = validatePicture(paramActivity, new File(paramString), localHashMap, d1, d2);
      return bool;
    }
    catch (com.b.a.d paramActivity)
    {
      paramActivity.printStackTrace();
      return true;
    }
    catch (IOException paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
    catch (com.b.c.e paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static boolean checkInMainProcess()
  {
    int i = Process.myPid();
    Object localObject1 = ((ActivityManager)ApplicationEx.c.getSystemService("activity")).getRunningAppProcesses();
    if (localObject1 == null) {}
    label117:
    Object localObject2;
    for (localObject1 = "";; localObject2 = null)
    {
      Iterator localIterator;
      PackageManager localPackageManager;
      if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("com.ziroom.ziroomcustomer")))
      {
        return true;
        localIterator = ((List)localObject1).iterator();
        localPackageManager = ApplicationEx.c.getPackageManager();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label117;
        }
        localObject1 = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        try
        {
          if (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i) {
            continue;
          }
          localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(((ActivityManager.RunningAppProcessInfo)localObject1).processName, 128));
          localObject1 = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
        }
        catch (Exception localException) {}
        return false;
      }
    }
  }
  
  public static String createFileName()
  {
    int i = new Random().nextInt(10000);
    StringBuilder localStringBuilder = new StringBuilder();
    new DateFormat();
    return ah.toMd5((DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + String.valueOf(i)).getBytes());
  }
  
  public static File createImageFile()
  {
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    Object localObject = new StringBuilder();
    new DateFormat();
    localObject = DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + "";
    try
    {
      localFile = File.createTempFile((String)localObject, ".jpg", localFile);
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  public static void deleteFile(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label25;
      }
      paramFile.delete();
    }
    for (;;)
    {
      paramFile.delete();
      return;
      label25:
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
  }
  
  public static double div(double paramDouble1, double paramDouble2)
  {
    return div(paramDouble1, paramDouble2, 2);
  }
  
  public static double div(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
    }
    return new BigDecimal(Double.toString(paramDouble1)).divide(new BigDecimal(Double.toString(paramDouble2)), paramInt, 4).doubleValue();
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(paramContext.density * f + 0.5D);
  }
  
  public static String getAppMetaData(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager != null)
        {
          paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
          if ((paramContext != null) && (paramContext.metaData != null))
          {
            paramContext = paramContext.metaData.getString(paramString);
            return paramContext;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static String getApplicationName()
  {
    Object localObject2 = null;
    try
    {
      localPackageManager = ApplicationEx.c.getPackageManager();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      for (;;)
      {
        PackageManager localPackageManager;
        ApplicationInfo localApplicationInfo;
        label23:
        Object localObject1 = null;
      }
    }
    try
    {
      localApplicationInfo = localPackageManager.getApplicationInfo(h.getPackageName(ApplicationEx.c), 0);
      localObject2 = localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      break label23;
    }
    return (String)localPackageManager.getApplicationLabel((ApplicationInfo)localObject2);
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = 1;
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  public static int getBitmapDegree(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static ExifInterface getExif(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String getImageType(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 507	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 508	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: iconst_3
    //   14: newarray <illegal type>
    //   16: astore_2
    //   17: aload_1
    //   18: astore_0
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: aload_2
    //   23: arraylength
    //   24: invokevirtual 512	java/io/FileInputStream:read	([BII)I
    //   27: pop
    //   28: aload_1
    //   29: astore_0
    //   30: aload_2
    //   31: invokestatic 514	com/ziroom/ziroomcustomer/minsu/f/ad:a	([B)Ljava/lang/String;
    //   34: astore_2
    //   35: aload_2
    //   36: astore_0
    //   37: aload_1
    //   38: ifnull +9 -> 47
    //   41: aload_1
    //   42: invokevirtual 517	java/io/FileInputStream:close	()V
    //   45: aload_2
    //   46: astore_0
    //   47: ldc_w 519
    //   50: aload_0
    //   51: invokevirtual 523	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifeq +52 -> 106
    //   57: ldc_w 525
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: astore_0
    //   68: aload_2
    //   69: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   72: aload_3
    //   73: astore_0
    //   74: aload_1
    //   75: ifnull -28 -> 47
    //   78: aload_1
    //   79: invokevirtual 517	java/io/FileInputStream:close	()V
    //   82: aload_3
    //   83: astore_0
    //   84: goto -37 -> 47
    //   87: astore_0
    //   88: aload_3
    //   89: astore_0
    //   90: goto -43 -> 47
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 517	java/io/FileInputStream:close	()V
    //   104: aload_1
    //   105: athrow
    //   106: ldc_w 519
    //   109: aload_0
    //   110: invokevirtual 523	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +7 -> 120
    //   116: ldc_w 525
    //   119: areturn
    //   120: ldc_w 528
    //   123: aload_0
    //   124: invokevirtual 523	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +7 -> 134
    //   130: ldc_w 530
    //   133: areturn
    //   134: aload_0
    //   135: astore_1
    //   136: ldc_w 532
    //   139: aload_0
    //   140: invokevirtual 523	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq -82 -> 61
    //   146: ldc_w 534
    //   149: areturn
    //   150: astore_0
    //   151: aload_2
    //   152: astore_0
    //   153: goto -106 -> 47
    //   156: astore_0
    //   157: goto -53 -> 104
    //   160: astore_1
    //   161: goto -65 -> 96
    //   164: astore_2
    //   165: goto -99 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   10	69	1	localObject1	Object
    //   93	12	1	localObject2	Object
    //   135	1	1	str	String
    //   160	1	1	localObject3	Object
    //   16	30	2	localObject4	Object
    //   63	89	2	localException1	Exception
    //   164	1	2	localException2	Exception
    //   1	88	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	63	java/lang/Exception
    //   78	82	87	java/io/IOException
    //   2	11	93	finally
    //   41	45	150	java/io/IOException
    //   100	104	156	java/io/IOException
    //   13	17	160	finally
    //   19	28	160	finally
    //   30	35	160	finally
    //   68	72	160	finally
    //   13	17	164	java/lang/Exception
    //   19	28	164	java/lang/Exception
    //   30	35	164	java/lang/Exception
  }
  
  public static String getIp(Context paramContext)
  {
    if (netType2Int(GetNetworkType()) == 4) {
      return getWifiIpAddress(paramContext);
    }
    return getIpAddress();
  }
  
  public static String getIpAddress()
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
  
  public static String getMac()
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      while (localEnumeration.hasMoreElements())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration.nextElement();
        Object localObject = localNetworkInterface.getHardwareAddress();
        if ((localObject != null) && (localObject.length != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject[i]) }));
            i += 1;
          }
          if (localStringBuilder.length() > 0) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          }
          localObject = localStringBuilder.toString();
          if (localNetworkInterface.getName().contains("wlan")) {
            a = (String)localObject;
          }
        }
      }
      return a;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String getMonthFromDate(int paramInt)
  {
    paramInt += 1;
    char[] arrayOfChar = "零一二三四五六七八九十".toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt <= 10) {
      localStringBuffer.append(arrayOfChar[paramInt]);
    }
    for (;;)
    {
      if ("零".equals(localStringBuffer.toString()))
      {
        localStringBuffer.setLength(0);
        localStringBuffer.append("十二");
      }
      return localStringBuffer.toString() + "月";
      localStringBuffer.append("十").append(arrayOfChar[(paramInt % 10)]);
    }
  }
  
  public static String getMonthFromDateLL(int paramInt)
  {
    String str2 = com.ziroom.ziroomcustomer.minsu.c.b.getInstance().getMonthTitle(paramInt + 1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getMonthFromDate(paramInt);
    }
    return str1;
  }
  
  public static String getNumberFormat(double paramDouble, int paramInt)
  {
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setMaximumFractionDigits(paramInt);
    localNumberFormat.setGroupingUsed(false);
    return localNumberFormat.format(paramDouble);
  }
  
  public static Map<String, Object> getPhoneInfo()
  {
    Object localObject1 = (TelephonyManager)ApplicationEx.c.getSystemService("phone");
    String str1 = ((TelephonyManager)localObject1).getDeviceId();
    String str2 = ((TelephonyManager)localObject1).getLine1Number();
    String str3 = ((TelephonyManager)localObject1).getSimSerialNumber();
    String str4 = ((TelephonyManager)localObject1).getSubscriberId();
    String str5 = Build.MODEL;
    String str6 = Build.BRAND;
    String str7 = Build.VERSION.RELEASE;
    double d1 = com.ziroom.commonlibrary.b.a.getLatitude(ApplicationEx.c);
    double d2 = com.ziroom.commonlibrary.b.a.getLongitude(ApplicationEx.c);
    Object localObject2 = com.ziroom.commonlibrary.b.a.getBDLocation(ApplicationEx.c);
    localObject1 = new HashMap();
    ((Map)localObject1).put("versionName", h.getVersion(ApplicationEx.c));
    ((Map)localObject1).put("versionCode", Integer.valueOf(100032));
    ((Map)localObject1).put("deviceId", str1);
    ((Map)localObject1).put("phoneModel", str5);
    ((Map)localObject1).put("phoneBrand", str6);
    ((Map)localObject1).put("imei", str3);
    ((Map)localObject1).put("imsi", str4);
    ((Map)localObject1).put("macAddress", getMac());
    ((Map)localObject1).put("tel", str2);
    ((Map)localObject1).put("osVersion", str7);
    ((Map)localObject1).put("osType", "1");
    ((Map)localObject1).put("appName", "ziroom");
    ((Map)localObject1).put("netWork", netType2Int(GetNetworkType()) + "");
    ((Map)localObject1).put("channelName", getAppMetaData(ApplicationEx.c, "UMENG_CHANNEL"));
    ((Map)localObject1).put("deviceIP", getIp(ApplicationEx.c));
    if ((d2 > 0.0D) && (d1 > 0.0D))
    {
      str1 = getNumberFormat(d2, 15);
      str2 = getNumberFormat(d1, 15);
      ((Map)localObject1).put("locationCoordinate", str1 + "," + str2);
    }
    if (localObject2 != null)
    {
      str1 = ((BDLocation)localObject2).getCity();
      if (ae.notNull(str1)) {
        ((Map)localObject1).put("locationCityName", Base64.encodeToString(str1.getBytes(), 2));
      }
      localObject2 = ((BDLocation)localObject2).getCityCode();
      if (ae.notNull((String)localObject2)) {
        ((Map)localObject1).put("locationCityCode", (String)localObject2 + "");
      }
    }
    return (Map<String, Object>)localObject1;
  }
  
  public static Map<String, Object> getPhoneInfo2()
  {
    Object localObject = com.ziroom.commonlibrary.b.a.getBDLocation(ApplicationEx.c);
    Map localMap = getPhoneInfo();
    if (localObject != null)
    {
      localObject = ((BDLocation)localObject).getCity();
      if (ae.notNull((String)localObject)) {
        localMap.put("locationCityName", Base64.encodeToString(((String)localObject).substring(0, 2).getBytes(), 2));
      }
    }
    return localMap;
  }
  
  public static String getPriceFormat(int paramInt)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.applyPattern("##,##0.00");
    return localDecimalFormat.format(paramInt / 100.0D);
  }
  
  public static String getPriceInt(int paramInt)
  {
    return String.valueOf(paramInt / 100);
  }
  
  public static int getRandom(int paramInt1, int paramInt2)
  {
    return (int)(paramInt1 + Math.random() * (paramInt2 - paramInt1 + 1));
  }
  
  public static String getRealFilePath2(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    if (paramUri == null) {}
    do
    {
      String str;
      do
      {
        return null;
        str = paramUri.getScheme();
        if (str == null) {
          return paramUri.getPath();
        }
        if ("file".equals(str)) {
          return paramUri.getPath();
        }
      } while (!"content".equals(str));
      paramUri = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    } while (paramUri == null);
    paramContext = (Context)localObject;
    if (paramUri.moveToFirst())
    {
      int i = paramUri.getColumnIndex("_data");
      paramContext = (Context)localObject;
      if (i > -1) {
        paramContext = paramUri.getString(i);
      }
    }
    paramUri.close();
    return paramContext;
  }
  
  public static String getStaticPicFromBaiduMap(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return "http://api.map.baidu.com/staticimage?width=" + paramInt1 + "&height=" + paramInt2 + "&center=" + paramString + "&zoom=" + paramInt3 + "&scale=1";
  }
  
  public static String getTime2d(long paramLong)
  {
    return String.format("%02d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static String getTopActivityName()
  {
    return ((ActivityManager.RunningTaskInfo)((ActivityManager)ApplicationEx.c.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
  }
  
  public static String getUserAgent(Context paramContext)
  {
    Object localObject = "";
    if (ae.isNull(""))
    {
      String str = com.ziroom.ziroomcustomer.util.ad.getOther(ApplicationEx.c, "mUserAgent");
      localObject = str;
      if (ae.isNull(str))
      {
        localObject = new WebView(ApplicationEx.c).getSettings().getUserAgentString();
        com.ziroom.ziroomcustomer.util.ad.putOther(paramContext, "mUserAgent", (String)localObject);
      }
    }
    return (String)localObject;
  }
  
  public static String getWeekFromDate(String paramString)
  {
    String str = "星期";
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar localCalendar = Calendar.getInstance();
    try
    {
      localCalendar.setTime(localSimpleDateFormat.parse(paramString));
      if (localCalendar.get(7) == 2) {
        str = "星期" + "一";
      }
      paramString = str;
      if (localCalendar.get(7) == 3) {
        paramString = str + "二";
      }
      str = paramString;
      if (localCalendar.get(7) == 4) {
        str = paramString + "三";
      }
      paramString = str;
      if (localCalendar.get(7) == 5) {
        paramString = str + "四";
      }
      str = paramString;
      if (localCalendar.get(7) == 6) {
        str = paramString + "五";
      }
      paramString = str;
      if (localCalendar.get(7) == 7) {
        paramString = str + "六";
      }
      str = paramString;
      if (localCalendar.get(7) == 1) {
        str = paramString + "日";
      }
      return str;
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String getWifiIpAddress(Context paramContext)
  {
    int i = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getIpAddress();
    return String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i & 0xFF), Integer.valueOf(i >> 8 & 0xFF), Integer.valueOf(i >> 16 & 0xFF), Integer.valueOf(i >> 24 & 0xFF) });
  }
  
  public static void hideSoftInput(Activity paramActivity)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if ((paramActivity.getWindow().getAttributes().softInputMode != 2) && (paramActivity.getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 2);
    }
  }
  
  public static boolean isKeyboardShown(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    DisplayMetrics localDisplayMetrics = paramView.getResources().getDisplayMetrics();
    return paramView.getBottom() - localRect.bottom > localDisplayMetrics.density * 100.0F;
  }
  
  public static boolean isMinsuLandlord()
  {
    return com.ziroom.ziroomcustomer.util.ad.getBoolean(ApplicationEx.c, "isMinsuLandlord");
  }
  
  public static boolean isNullOrNumber(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    return Pattern.compile("^\\d+$").matcher(paramString).matches();
  }
  
  public static boolean isNumber(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^\\d+$").matcher(paramString).matches();
  }
  
  public static boolean isNumeric(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      System.out.println(paramString.charAt(i));
      if (!Character.isDigit(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
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
  
  public static void putIntentShare(Intent paramIntent, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split("&\\|");
    if (paramString.length >= 1) {
      paramIntent.putExtra("title", paramString[0]);
    }
    if (paramString.length >= 2)
    {
      paramIntent.putExtra("shareTitle", paramString[1]);
      paramIntent.putExtra("content", paramString[1]);
    }
    if (paramString.length >= 3)
    {
      paramString = paramString[2];
      paramIntent.putExtra("allBoolParams", paramString);
      if (ae.notNull(paramString))
      {
        paramString = paramString.split("=");
        if (paramString.length >= 2)
        {
          int i = Integer.parseInt(paramString[1]);
          if ((i & 0x2) == 0)
          {
            bool1 = true;
            if ((i & 0x1) == 0) {
              break label152;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramIntent.putExtra("isShowShare", bool2);
      paramIntent.putExtra("isLogin", bool1);
      return;
      bool1 = false;
      break;
      label152:
      bool2 = false;
      continue;
      bool2 = true;
    }
  }
  
  public static void putIntentShareTitle(Intent paramIntent, String paramString)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    paramString = paramString.split("&");
    if (paramString.length >= 1) {
      paramIntent.putExtra("shareTitle", paramString[0]);
    }
    boolean bool1;
    if (paramString.length >= 2)
    {
      paramString = paramString[1];
      paramIntent.putExtra("allBoolParams", paramString);
      if (ae.notNull(paramString))
      {
        paramString = paramString.split("=");
        if (paramString.length >= 2)
        {
          int i = Integer.parseInt(paramString[1]);
          if ((i & 0x1) != 0)
          {
            bool1 = true;
            if ((i & 0x2) != 0) {
              break label117;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramIntent.putExtra("isShowShare", bool1);
      paramIntent.putExtra("isLogin", bool2);
      return;
      bool1 = false;
      break;
      label117:
      bool2 = false;
      continue;
      bool1 = true;
      bool2 = bool3;
    }
  }
  
  public static void putLookHouseHistory(MsHistorySBean paramMsHistorySBean)
  {
    if (paramMsHistorySBean == null) {
      return;
    }
    j.putHouseDetailHistory(ApplicationEx.c, paramMsHistorySBean);
  }
  
  public static int px2sp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  /* Error */
  public static String savePic(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: invokestatic 1122	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 1124
    //   6: invokevirtual 523	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 1126
    //   15: ldc_w 1128
    //   18: invokestatic 1134	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   21: pop
    //   22: ldc -97
    //   24: astore_0
    //   25: aload_0
    //   26: areturn
    //   27: new 70	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   34: astore_1
    //   35: new 311	android/text/format/DateFormat
    //   38: dup
    //   39: invokespecial 312	android/text/format/DateFormat:<init>	()V
    //   42: pop
    //   43: aload_1
    //   44: ldc_w 314
    //   47: getstatic 320	java/util/Locale:CHINA	Ljava/util/Locale;
    //   50: invokestatic 326	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   53: invokestatic 330	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;Ljava/util/Calendar;)Ljava/lang/CharSequence;
    //   56: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: ldc_w 354
    //   62: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_1
    //   69: new 246	java/io/File
    //   72: dup
    //   73: ldc_w 1136
    //   76: invokespecial 249	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: invokevirtual 1139	java/io/File:mkdirs	()Z
    //   82: pop
    //   83: new 70	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 1136
    //   93: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_3
    //   104: new 1141	java/io/FileOutputStream
    //   107: dup
    //   108: aload_3
    //   109: invokespecial 1142	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: aload_0
    //   116: getstatic 1148	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   119: bipush 100
    //   121: aload_2
    //   122: invokevirtual 1154	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   125: pop
    //   126: aload_3
    //   127: astore_0
    //   128: aload_2
    //   129: ifnull -104 -> 25
    //   132: aload_2
    //   133: invokevirtual 1157	java/io/FileOutputStream:flush	()V
    //   136: aload_2
    //   137: invokevirtual 1158	java/io/FileOutputStream:close	()V
    //   140: aload_3
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   147: aload_3
    //   148: areturn
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_0
    //   153: astore_1
    //   154: aload_3
    //   155: invokevirtual 1159	java/io/FileNotFoundException:printStackTrace	()V
    //   158: aload_0
    //   159: ifnull +11 -> 170
    //   162: aload_0
    //   163: invokevirtual 1157	java/io/FileOutputStream:flush	()V
    //   166: aload_0
    //   167: invokevirtual 1158	java/io/FileOutputStream:close	()V
    //   170: ldc -97
    //   172: areturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   178: goto -8 -> 170
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_1
    //   185: ifnull +11 -> 196
    //   188: aload_1
    //   189: invokevirtual 1157	java/io/FileOutputStream:flush	()V
    //   192: aload_1
    //   193: invokevirtual 1158	java/io/FileOutputStream:close	()V
    //   196: aload_0
    //   197: athrow
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   203: goto -7 -> 196
    //   206: astore_0
    //   207: goto -23 -> 184
    //   210: astore_3
    //   211: aload_2
    //   212: astore_0
    //   213: goto -61 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramBitmap	Bitmap
    //   34	159	1	localObject	Object
    //   198	2	1	localIOException	IOException
    //   112	100	2	localFileOutputStream	java.io.FileOutputStream
    //   103	45	3	str	String
    //   149	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   210	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   132	140	142	java/io/IOException
    //   104	113	149	java/io/FileNotFoundException
    //   162	170	173	java/io/IOException
    //   104	113	181	finally
    //   188	196	198	java/io/IOException
    //   115	126	206	finally
    //   154	158	206	finally
    //   115	126	210	java/io/FileNotFoundException
  }
  
  public static void setIsMinsuLandlord(boolean paramBoolean)
  {
    com.ziroom.ziroomcustomer.util.ad.setBoolean(ApplicationEx.c, "isMinsuLandlord", paramBoolean);
  }
  
  public static void shouErrorMessage(String paramString)
  {
    ApplicationEx localApplicationEx = ApplicationEx.c;
    String str = paramString;
    if (f.isNull(paramString)) {
      str = ApplicationEx.c.getString(2131297278);
    }
    g.textToast(localApplicationEx, str);
  }
  
  public static void showDialog(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (ae.isNull(paramString))) {
      return;
    }
    paramString = new com.ziroom.ziroomcustomer.minsu.dialog.a(paramActivity, paramString);
    paramString.setCancelable(false);
    paramString.showCancel(false);
    new TextView(paramActivity).setTextColor(paramActivity.getResources().getColor(2131624475));
    paramString.setOnConfirmListener(new ad.2(paramString));
    paramString.show();
  }
  
  public static void showImDialog(x paramx)
  {
    
    if (com.ziroom.ziroomcustomer.base.e.isApplicationInForeground())
    {
      g.textToast(ApplicationEx.c, ApplicationEx.c.getString(2131297533));
      if (paramx != null) {
        paramx.onSuccess(Boolean.valueOf(false));
      }
      paramx = new com.ziroom.ziroomcustomer.minsu.view.a(ApplicationEx.c, 2131297346, 2131297532, null, new ad.1(paramx), true, "登录");
      Window localWindow = paramx.getWindow();
      if (localWindow != null)
      {
        localWindow.setType(2003);
        paramx.show();
      }
    }
    Looper.loop();
  }
  
  public static void showPublishHouseDialog(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramActivity).setTitle("提示").setBtnConfirmText("发布房源").setContent("您还没有已上架的房源,快去发布房源吧!").setOnConfirmClickListener(new ad.3(paramActivity)).build().show();
  }
  
  public static boolean validatePicture(Activity paramActivity, File paramFile, Map<String, Integer> paramMap, double paramDouble1, double paramDouble2)
    throws com.b.a.d, IOException, com.b.c.e
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (paramFile == null) || (!paramFile.exists())) {
      return true;
    }
    Object localObject1 = getImageType(paramFile.getAbsolutePath());
    if (ae.isNull((String)localObject1))
    {
      if (!paramFile.getName().endsWith("jpg"))
      {
        showDialog(paramActivity, "图片只支持JPEG格式,请选择其它图片!");
        return false;
      }
    }
    else if (!"jpg".equalsIgnoreCase((String)localObject1))
    {
      showDialog(paramActivity, "照片类型不符合(JPG)!");
      return false;
    }
    localObject1 = com.b.a.c.readMetadata(new FileInputStream(paramFile));
    Iterator localIterator = ((com.b.c.d)localObject1).getDirectories().iterator();
    Object localObject2;
    int i1;
    int i2;
    int k;
    int n;
    com.b.c.b localb;
    int m;
    int j;
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (com.b.c.b)localIterator.next();
      i1 = ((com.b.c.b)localObject2).getInt(3);
      i2 = ((com.b.c.b)localObject2).getInt(1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("不符合照片上传规则:");
      ((StringBuilder)localObject2).append("\r\n");
      u.d("exif", "widthPixel==" + i1 + "==heightPixel===" + i2);
      if ((paramMap.containsKey("minPixel")) && (i1 * i2 < ((Integer)paramMap.get("minPixel")).intValue()))
      {
        ((StringBuilder)localObject2).append("当前照片");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("*");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append("像素不能低于");
        ((StringBuilder)localObject2).append(((Integer)paramMap.get("widthPixel")).intValue());
        ((StringBuilder)localObject2).append("*");
        ((StringBuilder)localObject2).append(((Integer)paramMap.get("heightPixel")).intValue());
        ((StringBuilder)localObject2).append("像素;");
        showDialog(paramActivity, ((StringBuilder)localObject2).toString());
        return false;
      }
      k = -1;
      n = -1;
      if (((com.b.c.d)localObject1).containsDirectoryOfType(com.b.c.i.b.class))
      {
        localb = ((com.b.c.d)localObject1).getFirstDirectoryOfType(com.b.c.i.b.class);
        m = k;
        if (localb != null)
        {
          m = k;
          if (localb.containsTag(8)) {
            m = localb.getInt(8);
          }
        }
        j = n;
        i = m;
        if (localb != null)
        {
          j = n;
          i = m;
          if (localb.containsTag(10))
          {
            j = localb.getInt(10);
            i = m;
          }
        }
        label461:
        if ((i != -1) && (j != -1) && (i != 1))
        {
          m = i;
          if (j != 1) {
            break label1296;
          }
        }
        localb = ((com.b.c.d)localObject1).getFirstDirectoryOfType(k.class);
        k = i;
        if (localb != null)
        {
          k = i;
          if (localb.containsTag(282)) {
            k = localb.getInt(282);
          }
        }
        m = k;
        if (localb == null) {
          break label1296;
        }
        m = k;
        if (!localb.containsTag(283)) {
          break label1296;
        }
        i = localb.getInt(283);
      }
    }
    for (;;)
    {
      u.d("exif", "widthDpi==" + k + "==heightDpi===" + i);
      if ((k != -1) && (i != -1) && (paramMap.containsKey("minDpi")) && ((k < ((Integer)paramMap.get("minDpi")).intValue()) || (i < ((Integer)paramMap.get("minDpi")).intValue())))
      {
        ((StringBuilder)localObject2).append("当前照片分辨率");
        ((StringBuilder)localObject2).append(Math.min(k, i));
        ((StringBuilder)localObject2).append("DPI小于最小分辨率");
        ((StringBuilder)localObject2).append(((Integer)paramMap.get("minDpi")).intValue());
        ((StringBuilder)localObject2).append("DPI;");
        showDialog(paramActivity, ((StringBuilder)localObject2).toString());
        return false;
        j = n;
        i = k;
        if (!((com.b.c.d)localObject1).containsDirectoryOfType(com.b.c.c.d.class)) {
          break label461;
        }
        localb = ((com.b.c.d)localObject1).getFirstDirectoryOfType(com.b.c.c.d.class);
        m = k;
        if (localb != null)
        {
          m = k;
          if (localb.containsTag(282)) {
            m = localb.getInt(282);
          }
        }
        j = n;
        i = m;
        if (localb == null) {
          break label461;
        }
        j = n;
        i = m;
        if (!localb.containsTag(283)) {
          break label461;
        }
        j = localb.getInt(283);
        i = m;
        break label461;
      }
      if ((paramMap.containsKey("widthScale")) && (paramMap.containsKey("heightScale")))
      {
        i = ((Integer)paramMap.get("widthScale")).intValue();
        j = ((Integer)paramMap.get("heightScale")).intValue();
        double d2 = div(i * Double.valueOf(paramDouble1).doubleValue(), j, 10);
        double d3 = div(i * Double.valueOf(paramDouble2).doubleValue(), j, 10);
        if (i2 > i1)
        {
          d1 = div(i2, i1, 10);
          k = j;
          j = i;
        }
        for (;;)
        {
          u.d("exif", "picScale==" + d1 + "===minScale===" + d3 + "====maxScale==" + d2);
          if ((d1 >= d3) && (d1 <= d2)) {
            break;
          }
          ((StringBuilder)localObject2).append("当前照片比例");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(i2);
          ((StringBuilder)localObject2).append("不等于上传比例");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(";");
          showDialog(paramActivity, ((StringBuilder)localObject2).toString());
          return false;
          d1 = div(i1, i2, 10);
          k = i;
        }
      }
      double d1 = div(paramFile.length(), 1024.0D);
      u.d("exif", "picSize==" + d1);
      if ((!paramMap.containsKey("maxSize")) || (d1 <= ((Integer)paramMap.get("maxSize")).intValue())) {
        break;
      }
      ((StringBuilder)localObject2).append("当前照片大小");
      ((StringBuilder)localObject2).append(d1);
      ((StringBuilder)localObject2).append("KB");
      ((StringBuilder)localObject2).append("大于照片最大上传大小");
      ((StringBuilder)localObject2).append(((Integer)paramMap.get("maxSize")).intValue());
      ((StringBuilder)localObject2).append("KB;");
      showDialog(paramActivity, ((StringBuilder)localObject2).toString());
      return false;
      return true;
      label1296:
      i = j;
      k = m;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */