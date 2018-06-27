package com.freelxl.baselibrary.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.aw;
import com.airbnb.lottie.aw.a;
import com.airbnb.lottie.bf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.util.EncodingUtils;

public class h
{
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
  
  public static String checkNetworkInfo(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
      return "WIFI";
    }
    if (paramContext.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED) {
      return "3G";
    }
    return "";
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
  
  public static String getChannelCode(Context paramContext)
  {
    paramContext = a(paramContext, "CHANNEL");
    if (paramContext != null) {
      return paramContext;
    }
    return "C_000";
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
  
  public static String getMac(Context paramContext)
  {
    return ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
  }
  
  public static String getPackageName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
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
  
  public static String hiddenPhone(String paramString)
  {
    if (f.isNull(paramString)) {
      return "";
    }
    if (isMobile(paramString)) {
      return paramString.substring(0, 3) + "****" + paramString.substring(7, 11);
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
  
  public static boolean isEmail(String paramString)
  {
    return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(paramString).matches();
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
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
  
  public static boolean loadLottieFromScCard(Context paramContext, LottieAnimationView paramLottieAnimationView, String paramString)
  {
    boolean bool = false;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        aw.a.fromInputStream(paramContext, new FileInputStream(paramString), new bf()
        {
          public void onCompositionLoaded(aw paramAnonymousaw)
          {
            if (paramAnonymousaw != null)
            {
              this.a.setVisibility(0);
              this.a.setComposition(paramAnonymousaw);
              this.a.loop(true);
              this.a.playAnimation();
            }
          }
        });
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */