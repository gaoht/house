package com.ziroom.ziroomcustomer.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.provider.Telephony.Sms;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.util.EncodingUtils;

public class ah
{
  public static Map<String, String> ConvertObjMap2String(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if ((localEntry.getValue() instanceof String)) {
        localHashMap.put(localEntry.getKey(), (String)localEntry.getValue());
      } else if ((localEntry.getValue() instanceof Integer)) {
        localHashMap.put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
      } else if (localEntry.getValue() == null) {
        localHashMap.put(localEntry.getKey(), "");
      } else {
        localHashMap.put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
      }
    }
    return localHashMap;
  }
  
  public static String MD5Encode(String paramString)
  {
    return toMd5(paramString.getBytes());
  }
  
  public static String Number(double paramDouble)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.00");
    System.out.println(localDecimalFormat.format(paramDouble));
    return localDecimalFormat.format(paramDouble).replace(",", ".");
  }
  
  public static String Number(float paramFloat)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.00");
    System.out.println(localDecimalFormat.format(paramFloat));
    return localDecimalFormat.format(paramFloat).replace(",", ".");
  }
  
  public static double Number2(double paramDouble)
  {
    paramDouble = new BigDecimal(paramDouble).setScale(2, 4).doubleValue();
    Double.doubleToLongBits(paramDouble);
    return paramDouble;
  }
  
  public static String StrToNorDate(String paramString)
  {
    String[] arrayOfString = paramString.split("-");
    if (arrayOfString.length >= 3)
    {
      paramString = new StringBuffer();
      paramString.append(arrayOfString[0]);
      paramString.append("年");
      paramString.append(arrayOfString[1]);
      paramString.append("月");
      paramString.append(arrayOfString[2]);
      paramString.append("日");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public static String StringFilter(String paramString)
  {
    paramString = paramString.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!").replaceAll("：", ":").replace("，", ",").replace("。", ".").replace("……", "......");
    return Pattern.compile("[『』]").matcher(paramString).replaceAll("").trim();
  }
  
  public static String ToDBC(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  private static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get(paramString);
      if (paramContext != null)
      {
        paramContext = paramContext.toString();
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str).append(paramString);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String appendGetUrl(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      Object localObject;
      if (paramMap.get(str3) == null) {
        localObject = "";
      }
      for (;;)
      {
        try
        {
          str1 = URLEncoder.encode(str3, "utf-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          String str2;
          String str1 = str3;
        }
        try
        {
          str2 = URLEncoder.encode((String)localObject, "utf-8");
          localObject = str2;
          localStringBuilder.append("&" + str1 + "=" + (String)localObject);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;) {}
        }
        localObject = paramMap.get(str3).toString().trim();
        continue;
        localUnsupportedEncodingException1.printStackTrace();
      }
    }
    localStringBuilder.deleteCharAt(0);
    return localStringBuilder.toString();
  }
  
  public static String appendGetUrlParams(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = new StringBuilder().append(paramString);
    if (paramString.contains("?")) {}
    for (paramString = "&";; paramString = "?")
    {
      paramString = paramString;
      localObject = new HashMap();
      if (paramBoolean2) {
        ((Map)localObject).put("os", "android");
      }
      if (paramBoolean3) {
        ((Map)localObject).put("app_version", getVersion(ApplicationEx.c));
      }
      if (paramBoolean1) {
        ((Map)localObject).put("token", com.ziroom.commonlibrary.login.a.getToken(paramContext));
      }
      return paramString + appendGetUrl((Map)localObject);
    }
  }
  
  public static void backgroundAlpha(float paramFloat, Activity paramActivity)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    paramActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  public static void callPhone(Context paramContext, String paramString)
  {
    c.newBuilder(paramContext).setTitle("拨打电话").setContent("是否拨打" + paramString + "？").setBtnConfirmText("呼叫").setOnConfirmClickListener(new ah.3(paramString, paramContext)).build().show();
  }
  
  public static void callPhone(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = LayoutInflater.from(paramContext).inflate(2130903834, null);
    TextView localTextView = (TextView)paramString2.findViewById(2131689850);
    Button localButton1 = (Button)paramString2.findViewById(2131692249);
    Button localButton2 = (Button)paramString2.findViewById(2131690460);
    AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext, 2131427591).create();
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localAlertDialog.getWindow().setContentView(paramString2);
      localTextView.setText("确认要拨打" + paramString1 + "吗?");
      localButton1.setOnClickListener(new ah.4(localAlertDialog, paramString1, paramContext));
      localButton2.setOnClickListener(new ah.5(localAlertDialog));
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  public static String changeF2Y(String paramString)
  {
    if (!paramString.matches("\\-?[0-9]+")) {
      try
      {
        throw new Exception("金额格式有误");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    try
    {
      paramString = BigDecimal.valueOf(Long.valueOf(paramString).longValue()).divide(new BigDecimal(100)).toString();
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return "";
  }
  
  public static boolean checkCertCode(String paramString)
  {
    return Pattern.compile("^[A-Za-z0-9]+").matcher(paramString).matches();
  }
  
  public static boolean checkNet(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean checkSpecialChar(String paramString)
    throws PatternSyntaxException
  {
    return Pattern.compile(".*[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#¥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]+.*").matcher(paramString).matches();
  }
  
  public static boolean copyApkFromAssets(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new File(paramString2);
      paramString1.createNewFile();
      paramString1 = new FileOutputStream(paramString1);
      paramString2 = new byte['Ѐ'];
      for (;;)
      {
        int i = paramContext.read(paramString2);
        if (i <= 0) {
          break;
        }
        paramString1.write(paramString2, 0, i);
      }
      paramString1.close();
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    paramContext.close();
    return true;
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void downloadPdf(Context paramContext, String paramString)
  {
    downloadPdf(paramContext, paramString, "/");
  }
  
  public static void downloadPdf(Context paramContext, String paramString1, String paramString2)
  {
    if (!ae.isNull(paramString1))
    {
      d.i("downloadPdf", "下载PDF文件：" + paramString1);
      Object localObject = paramString1.substring(paramString1.lastIndexOf(paramString2)).substring(1);
      paramString2 = (String)localObject;
      if (!((String)localObject).endsWith(".pdf"))
      {
        paramString2 = (String)localObject;
        if (!((String)localObject).endsWith(".PDF")) {
          paramString2 = (String)localObject + ".pdf";
        }
      }
      localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ziroom/file");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new File((File)localObject, paramString2);
      if (!paramString2.exists()) {}
      try
      {
        paramString2.createNewFile();
        com.freelxl.baselibrary.d.a.get(paramString1).tag(paramContext).enqueue(new ah.6(paramContext, new com.freelxl.baselibrary.d.f.b(paramString2), paramContext));
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          g.textToast(paramContext, "pdf创建失败！");
          localIOException.printStackTrace();
        }
      }
    }
    g.textToast(paramContext, "下载链接为空！");
  }
  
  public static String encodeGetParams(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      Object localObject;
      if (paramMap.get(str3) == null) {
        localObject = "";
      }
      for (;;)
      {
        try
        {
          str1 = URLEncoder.encode(str3, "utf-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          String str2;
          String str1 = str3;
        }
        try
        {
          str2 = URLEncoder.encode((String)localObject, "utf-8");
          localObject = str2;
          localStringBuilder.append("&" + str1 + "=" + (String)localObject);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;) {}
        }
        localObject = ((String)paramMap.get(str3)).toString();
        continue;
        localUnsupportedEncodingException1.printStackTrace();
      }
    }
    localStringBuilder.deleteCharAt(0);
    return localStringBuilder.toString();
  }
  
  public static String formatDouble(double paramDouble)
  {
    return new DecimalFormat("0.00").format(paramDouble);
  }
  
  public static String formatIDCard(String paramString1, String paramString2)
  {
    String str = paramString1.replaceAll(paramString2, "");
    paramString1 = str;
    if (str.length() > 6) {
      paramString1 = str.substring(0, 6) + paramString2 + str.substring(6);
    }
    str = paramString1;
    if (paramString1.length() > 11) {
      str = paramString1.substring(0, 11) + paramString2 + paramString1.substring(11);
    }
    paramString1 = str;
    if (str.length() > 16) {
      paramString1 = str.substring(0, 16) + paramString2 + str.substring(16);
    }
    paramString2 = paramString1;
    if (paramString1.length() > 21) {
      paramString2 = paramString1.substring(0, 21);
    }
    return paramString2;
  }
  
  public static String getAppName(Context paramContext, int paramInt)
  {
    Object localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject1 == null) {
      return "";
    }
    localObject1 = ((List)localObject1).iterator();
    paramContext = paramContext.getPackageManager();
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext()) {
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      }
      try
      {
        if (((ActivityManager.RunningAppProcessInfo)localObject2).pid != paramInt) {
          continue;
        }
        paramContext.getApplicationLabel(paramContext.getApplicationInfo(((ActivityManager.RunningAppProcessInfo)localObject2).processName, 128));
        localObject2 = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
        return (String)localObject2;
      }
      catch (Exception localException) {}
      return null;
    }
  }
  
  public static String getAppVersion(Context paramContext)
  {
    Object localObject = null;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      return paramContext.versionCode + "";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static double[] getAround(double paramDouble1, double paramDouble2, int paramInt)
  {
    Double localDouble2 = Double.valueOf(paramDouble1);
    Double localDouble1 = Double.valueOf(paramDouble2);
    Double localDouble3 = Double.valueOf(111293.63611111112D);
    double d3 = paramInt;
    Double localDouble4 = Double.valueOf(Double.valueOf(1.0D / localDouble3.doubleValue()).doubleValue() * d3);
    paramDouble1 = localDouble2.doubleValue();
    paramDouble2 = localDouble4.doubleValue();
    double d1 = localDouble2.doubleValue();
    double d2 = localDouble4.doubleValue();
    localDouble2 = Double.valueOf(d3 * Double.valueOf(1.0D / Double.valueOf(localDouble3.doubleValue() * Math.cos(localDouble2.doubleValue() * 0.017453292500000002D)).doubleValue()).doubleValue());
    d3 = localDouble1.doubleValue();
    double d4 = localDouble2.doubleValue();
    double d5 = localDouble1.doubleValue();
    double d6 = localDouble2.doubleValue();
    return new double[] { Double.valueOf(paramDouble1 - paramDouble2).doubleValue(), Double.valueOf(d3 - d4).doubleValue(), Double.valueOf(d1 + d2).doubleValue(), Double.valueOf(d6 + d5).doubleValue() };
  }
  
  public static void getBrowserPackageName(Context paramContext)
  {
    new ah.2(paramContext).start();
  }
  
  public static String getChannelCode(Context paramContext)
  {
    paramContext = a(paramContext, "CHANNEL");
    if (paramContext != null) {
      return paramContext;
    }
    return "C_000";
  }
  
  /* Error */
  public static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 764	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 43	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 766
    //   17: aastore
    //   18: aload_2
    //   19: aload_3
    //   20: aconst_null
    //   21: invokevirtual 772	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +40 -> 66
    //   29: aload_1
    //   30: invokeinterface 777 1 0
    //   35: ifeq +31 -> 66
    //   38: aload_1
    //   39: aload_1
    //   40: ldc_w 766
    //   43: invokeinterface 780 2 0
    //   48: invokeinterface 783 2 0
    //   53: astore_0
    //   54: aload_1
    //   55: ifnull +9 -> 64
    //   58: aload_1
    //   59: invokeinterface 784 1 0
    //   64: aload_0
    //   65: areturn
    //   66: aload_1
    //   67: ifnull +9 -> 76
    //   70: aload_1
    //   71: invokeinterface 784 1 0
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aload 4
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: invokeinterface 784 1 0
    //   92: aload_0
    //   93: athrow
    //   94: astore_0
    //   95: goto -13 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   0	98	1	paramUri	Uri
    //   0	98	2	paramString	String
    //   0	98	3	paramArrayOfString	String[]
    //   1	79	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	25	78	finally
    //   29	54	94	finally
  }
  
  public static String getDeviceId(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String getFromAssets(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getResources().getAssets().open(paramString);
      byte[] arrayOfByte = new byte[paramContext.available()];
      paramContext.read(arrayOfByte);
      paramContext.close();
      paramContext = EncodingUtils.getString(arrayOfByte, "UTF-8");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramString;
  }
  
  @TargetApi(19)
  public static String getImageAbsolutePath(Activity paramActivity, Uri paramUri)
  {
    Object localObject = null;
    if ((paramActivity == null) || (paramUri == null)) {}
    label215:
    do
    {
      do
      {
        do
        {
          return null;
          if ((Build.VERSION.SDK_INT < 19) || (!DocumentsContract.isDocumentUri(paramActivity, paramUri))) {
            break label215;
          }
          if (!isExternalStorageDocument(paramUri)) {
            break;
          }
          paramActivity = DocumentsContract.getDocumentId(paramUri).split(":");
        } while (!"primary".equalsIgnoreCase(paramActivity[0]));
        return Environment.getExternalStorageDirectory() + "/" + paramActivity[1];
        if (isDownloadsDocument(paramUri))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          return getDataColumn(paramActivity, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
        }
      } while (!isMediaDocument(paramUri));
      String[] arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
      String str = arrayOfString[0];
      if ("image".equals(str)) {
        paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      }
      for (;;)
      {
        return getDataColumn(paramActivity, paramUri, "_id=?", new String[] { arrayOfString[1] });
        if ("video".equals(str))
        {
          paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        else
        {
          paramUri = (Uri)localObject;
          if ("audio".equals(str)) {
            paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
      if ("content".equalsIgnoreCase(paramUri.getScheme()))
      {
        if (isGooglePhotosUri(paramUri)) {
          return paramUri.getLastPathSegment();
        }
        return getDataColumn(paramActivity, paramUri, null, null);
      }
    } while (!"file".equalsIgnoreCase(paramUri.getScheme()));
    return paramUri.getPath();
  }
  
  public static int getInt(float paramFloat)
  {
    return new BigDecimal(paramFloat).setScale(0, 4).intValue();
  }
  
  public static String getIpAddress(Context paramContext)
  {
    if ("WIFI".equals(getNetWorkType(paramContext))) {
      try
      {
        InetAddress localInetAddress;
        do
        {
          paramContext = NetworkInterface.getNetworkInterfaces();
          Enumeration localEnumeration;
          while (!localEnumeration.hasMoreElements())
          {
            if (!paramContext.hasMoreElements()) {
              break;
            }
            localEnumeration = ((NetworkInterface)paramContext.nextElement()).getInetAddresses();
          }
          localInetAddress = (InetAddress)localEnumeration.nextElement();
        } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
        paramContext = localInetAddress.getHostAddress().toString();
        return paramContext;
      }
      catch (SocketException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String getLocation(Context paramContext)
  {
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    paramContext = localLocationManager.getLastKnownLocation("gps");
    if (paramContext == null) {
      paramContext = localLocationManager.getLastKnownLocation("network");
    }
    for (;;)
    {
      if (paramContext != null)
      {
        double d1 = paramContext.getLatitude();
        double d2 = paramContext.getLongitude();
        return d1 + "," + d2;
      }
      return "";
    }
  }
  
  public static String getMac(Context paramContext)
  {
    WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    paramContext = localWifiInfo.getMacAddress();
    if (ae.isNull(localWifiInfo.getMacAddress())) {
      paramContext = "123";
    }
    return paramContext;
  }
  
  public static String getNetWorkType(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      if (paramContext.getType() == 1) {
        paramContext = "WIFI";
      }
      String str;
      do
      {
        return paramContext;
        if (paramContext.getType() != 0) {
          break label176;
        }
        str = paramContext.getSubtypeName();
        switch (paramContext.getSubtype())
        {
        default: 
          if ((str.equalsIgnoreCase("TD-SCDMA")) || (str.equalsIgnoreCase("WCDMA"))) {
            break label160;
          }
          paramContext = str;
        }
      } while (!str.equalsIgnoreCase("CDMA2000"));
      label160:
      return "3G";
      return "2G";
      return "3G";
      return "4G";
    }
    label176:
    return "";
  }
  
  public static String getPhoneInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Product: " + Build.PRODUCT + ", CPU_ABI: " + Build.CPU_ABI + ", TAGS: " + Build.TAGS + ", VERSION_CODES.BASE: " + 1 + ", MODEL: " + Build.MODEL + ", SDK: " + Build.VERSION.SDK + ", VERSION.RELEASE: " + Build.VERSION.RELEASE + ", DEVICE: " + Build.DEVICE + ", DISPLAY: " + Build.DISPLAY + ", BRAND: " + Build.BRAND + ", BOARD: " + Build.BOARD + ", FINGERPRINT: " + Build.FINGERPRINT + ", ID: " + Build.ID + ", MANUFACTURER: " + Build.MANUFACTURER + ", USER: " + Build.USER);
    return localStringBuffer.toString();
  }
  
  public static String getRandom()
  {
    Random localRandom = new Random();
    String str = "";
    int i = 0;
    while (i < 6)
    {
      str = str + Math.abs(localRandom.nextInt(10));
      i += 1;
    }
    return str;
  }
  
  public static float getTextViewLength(TextView paramTextView, String paramString)
  {
    return paramTextView.getPaint().measureText(paramString);
  }
  
  public static String getVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String[] insert(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length;
    String[] arrayOfString = new String[i + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, i);
    arrayOfString[i] = paramString;
    return arrayOfString;
  }
  
  public static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean isDownloadsDocument(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isEmail(String paramString)
  {
    return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(paramString).matches();
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
  }
  
  public static boolean isExternalStorageDocument(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isGooglePhotosUri(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
  
  public static boolean isMediaDocument(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isMobile(String paramString)
  {
    return Pattern.compile("^[0-9]{11}$").matcher(paramString).matches();
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getAllNetworkInfo();
    boolean bool1 = bool2;
    int i;
    if (paramContext != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramContext.length)
      {
        if (paramContext[i].getState() == NetworkInfo.State.CONNECTED) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isNumber(String paramString)
  {
    return paramString.matches("[0-9]+");
  }
  
  public static boolean isPhone(String paramString)
  {
    Pattern localPattern1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");
    Pattern localPattern2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");
    if (paramString.length() > 9) {
      return localPattern1.matcher(paramString).matches();
    }
    return localPattern2.matcher(paramString).matches();
  }
  
  public static boolean isPsw(String paramString)
  {
    return Pattern.compile("\\d{9-16}$").matcher(paramString).matches();
  }
  
  public static boolean isTaxpayerNum(String paramString)
  {
    return Pattern.compile("^(?![A-Z]*$)[A-Z0-9]{15}$|^(?![A-Z]*$)[A-Z0-9]{18}$|^(?![A-Z]*$)[A-Z0-9]{20}$").matcher(paramString).matches();
  }
  
  public static boolean isWebUrl(String paramString)
  {
    return Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]").matcher(paramString).matches();
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int[] randomArray(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1 + 1;
    if ((paramInt2 < paramInt1) || (paramInt3 > i)) {
      return null;
    }
    int[] arrayOfInt1 = new int[i];
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt1 + i)
    {
      arrayOfInt1[(paramInt2 - paramInt1)] = paramInt2;
      paramInt2 += 1;
    }
    int[] arrayOfInt2 = new int[paramInt3];
    Random localRandom = new Random();
    paramInt1 = 0;
    for (paramInt2 = i; paramInt1 < arrayOfInt2.length; paramInt2 = paramInt3)
    {
      i = localRandom.nextInt();
      paramInt3 = paramInt2 - 1;
      paramInt2 = Math.abs(i % paramInt2);
      arrayOfInt2[paramInt1] = arrayOfInt1[paramInt2];
      arrayOfInt1[paramInt2] = arrayOfInt1[paramInt3];
      paramInt1 += 1;
    }
    return arrayOfInt2;
  }
  
  public static void sendMessages(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      localObject = Telephony.Sms.getDefaultSmsPackage(paramContext);
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("text/plain");
      localIntent.putExtra("address", paramString1);
      localIntent.putExtra("android.intent.extra.TEXT", paramString2);
      if (localObject != null) {
        localIntent.setPackage((String)localObject);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    Object localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse("sms:"));
    ((Intent)localObject).putExtra("sms_body", paramString2);
    ((Intent)localObject).putExtra("address", paramString1);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static double setDouble(Double paramDouble)
  {
    return Double.valueOf(new BigDecimal(paramDouble.doubleValue()).setScale(2, 4).doubleValue()).doubleValue();
  }
  
  public static float setFloat(float paramFloat)
  {
    return new BigDecimal(paramFloat).setScale(2, 4).floatValue();
  }
  
  public static void setImgHeight(View paramView, float paramFloat)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ah.7(paramView, paramFloat));
  }
  
  public static float setInt(float paramFloat)
  {
    return new BigDecimal(paramFloat).setScale(0, 4).floatValue();
  }
  
  public static void setLayoutY(View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramView.getLayoutParams());
    localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, paramInt, localMarginLayoutParams.rightMargin, localMarginLayoutParams.height + paramInt);
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(localMarginLayoutParams));
  }
  
  public static void setTextColor(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    paramString = new SpannableStringBuilder(paramString);
    paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA000")), paramInt1, paramInt1 + paramInt2, 33);
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void setTextColor(TextView paramTextView, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = new SpannableStringBuilder(paramString1);
    paramString1.setSpan(new ForegroundColorSpan(Color.parseColor(paramString2)), paramInt1, paramInt1 + paramInt2, 33);
    if (paramTextView != null) {
      paramTextView.setText(paramString1);
    }
  }
  
  public static void setTextColor(TextView paramTextView, String paramString1, List<Integer> paramList, int paramInt, String paramString2)
  {
    paramString1 = new SpannableStringBuilder(paramString1);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        paramString1.setSpan(new ForegroundColorSpan(Color.parseColor(paramString2)), i, i + paramInt, 33);
      }
    }
    if (paramTextView != null) {
      paramTextView.setText(paramString1);
    }
  }
  
  public static void setTextColorOwner(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    paramString = new SpannableStringBuilder(paramString);
    paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#CCA758")), paramInt1, paramInt1 + paramInt2, 33);
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void setTextColorOwner(TextView paramTextView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramString = new SpannableStringBuilder(paramString);
    ForegroundColorSpan localForegroundColorSpan1 = new ForegroundColorSpan(Color.parseColor("#CCA758"));
    ForegroundColorSpan localForegroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#CCA758"));
    paramString.setSpan(localForegroundColorSpan1, paramInt1, paramInt1 + paramInt2, 33);
    paramString.setSpan(localForegroundColorSpan2, paramInt3, paramInt3 + paramInt4, 33);
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void showBtnTip(Context paramContext, String paramString)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903644, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton = (Button)localView.findViewById(2131692249);
    paramContext = new AlertDialog.Builder(paramContext).create();
    paramContext.setView(localView, 0, 0, 0, 0);
    if (!(paramContext instanceof AlertDialog)) {
      paramContext.show();
    }
    for (;;)
    {
      localTextView.setText(paramString);
      localButton.setOnClickListener(new ah.1(paramContext));
      return;
      VdsAgent.showDialog((AlertDialog)paramContext);
    }
  }
  
  public static boolean showWebView(BaseActivity paramBaseActivity)
  {
    return false;
  }
  
  public static int stringToInteger(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= paramString.length()) {
          break;
        }
        int m = paramString.charAt(j);
        k = i;
        if (m >= 48)
        {
          k = i;
          if (m <= 57) {
            k = i * 10 + m - 48;
          }
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public static String toMd5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = a(localMessageDigest.digest(), "");
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      Log.v("util", "toMd5():" + paramArrayOfByte);
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */