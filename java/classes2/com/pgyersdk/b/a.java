package com.pgyersdk.b;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.UUID;

public class a
{
  public static String a = null;
  public static String b = null;
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  public static String h = null;
  public static String i = null;
  public static String j = null;
  public static String k = "2.3.3";
  public static String l = "";
  public static String m = "iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAkFBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////+WABnwAAAAL3RSTlMAMtw091D6Sy7fTTbjpioQBe2vJ8G5tY16ZlLy6MeCDc+bkoZ7c1NAOyGeg1w6Gpvp7nkAAAFwSURBVEjH7dbHcoMwFIXhA0ggMLiAe4+70877v10wDtHCmHCXmfCv2HwjXUaDQFvbX+kjdR/abppZL2ZFPeRtsl9sZ8Cp85DpAwgWTOrxmFNUF5ArjmpxyC4qi+gbvHBcjw2qmlN5QK5H/efYpYOKNOP7jl6ZSHA5L+6teJXhgIOEw2K/ZqB6IqypupgU2lMMIMGn4l3dNDI/txKsSa942HG4YAQJDkoLJKSGBEf0S2tCzgH0e5uGeE5VWs+/79ksts2wpt8pLRl8Pywb4cjO6/3M69BtggPadRVPkGBN5VmrIcHWonM7GxJsuDR23ggiPGJi19UQ4atPvpXzziHDO66X3NuzIcF9FSNTXKNLBhDiGY9AFjNR1JDisPjMr8ncSvGZe3weQ/qpAzEe8X1CqkkGiLHDPHd227kcz8j0DECA7Y3Rmxk8zTCU3lW2LkPpLWmbclxzPx+cug4cdOr+DOqLPTzvkrp1pRe0tf2LvgDo0C+Y+R4NZwAAAABJRU5ErkJggg==";
  private static int n = -1;
  
  private static int a(Context paramContext, PackageManager paramPackageManager)
  {
    int i1 = 0;
    try
    {
      paramContext = paramPackageManager.getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null) {
        i1 = paramContext.getInt("buildNumber", 0);
      }
      return i1;
    }
    catch (Exception paramContext)
    {
      Log.e("PgyerSDK", "Exception thrown when accessing the application info:");
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = "0123456789ABCDEF".toCharArray();
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      int i2 = paramArrayOfByte[i1] & 0xFF;
      arrayOfChar2[(i1 * 2)] = arrayOfChar1[(i2 >>> 4)];
      arrayOfChar2[(i1 * 2 + 1)] = arrayOfChar1[(i2 & 0xF)];
      i1 += 1;
    }
    return new String(arrayOfChar2).replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
  }
  
  public static void a(Context paramContext)
  {
    e = Build.VERSION.RELEASE;
    f = Build.MODEL;
    g = Build.MANUFACTURER;
    d(paramContext);
    e(paramContext);
    g(paramContext);
    f(paramContext);
  }
  
  public static boolean a()
  {
    if (n == 1) {
      return true;
    }
    if (n == 0) {
      return false;
    }
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "/system/bin/";
    arrayOfString[1] = "/system/xbin/";
    arrayOfString[2] = "/system/sbin/";
    arrayOfString[3] = "/sbin/";
    arrayOfString[4] = "/vendor/bin/";
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < arrayOfString.length)
        {
          File localFile = new File(arrayOfString[i1] + "su");
          if ((localFile == null) || (!localFile.exists())) {
            break label108;
          }
          n = 1;
          return true;
        }
      }
      catch (Exception localException)
      {
        n = 0;
        return false;
      }
      label108:
      i1 += 1;
    }
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      j = localDisplayMetrics.widthPixels + " * " + localDisplayMetrics.heightPixels;
      return;
    }
    catch (Exception paramContext)
    {
      j = "resolution getting faild";
    }
  }
  
  public static void c(Context paramContext)
  {
    try
    {
      Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
      String str = "" + ((TelephonyManager)localObject).getDeviceId();
      localObject = "" + ((TelephonyManager)localObject).getSimSerialNumber();
      long l1 = ("" + Settings.Secure.getString(paramContext.getContentResolver(), "android_id")).hashCode();
      long l2 = str.hashCode();
      i = new UUID(l1, ((String)localObject).hashCode() | l2 << 32).toString();
      return;
    }
    catch (Exception paramContext)
    {
      i = "getting faild";
    }
  }
  
  private static void d(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext = paramContext.getFilesDir();
      if (paramContext != null) {
        a = paramContext.getAbsolutePath();
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("PgyerSDK", "Exception thrown when accessing the files dir:");
      paramContext.printStackTrace();
    }
  }
  
  private static void e(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      c = localPackageInfo.packageName;
      b = "" + localPackageInfo.versionCode;
      d = localPackageInfo.versionName;
      k = localPackageInfo.versionName;
      int i1 = a(paramContext, localPackageManager);
      if ((i1 != 0) && (i1 > localPackageInfo.versionCode)) {
        b = "" + i1;
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("PgyerSDK", "Exception thrown when accessing the package info:");
      paramContext.printStackTrace();
    }
  }
  
  private static void f(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      c(paramContext);
      b(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("PgyerSDK", "Exception thrown then accessing the device info:");
      paramContext.printStackTrace();
    }
  }
  
  private static void g(Context paramContext)
  {
    Object localObject = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((c != null) && (localObject != null)) {
      localObject = c + ":" + (String)localObject + ":" + h(paramContext);
    }
    try
    {
      paramContext = MessageDigest.getInstance("SHA-1");
      localObject = ((String)localObject).getBytes("UTF-8");
      paramContext.update((byte[])localObject, 0, localObject.length);
      h = a(paramContext.digest());
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static String h(Context paramContext)
  {
    String str2 = "HA" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.PRODUCT.length() % 10;
    String str1 = "";
    paramContext = str1;
    if (Build.VERSION.SDK_INT >= 9) {}
    try
    {
      paramContext = Build.class.getField("SERIAL").get(null).toString();
      return str2 + ":" + paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */