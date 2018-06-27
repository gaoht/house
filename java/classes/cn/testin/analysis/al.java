package cn.testin.analysis;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class al
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static String e;
  
  public static float a(float paramFloat)
  {
    return paramFloat / Resources.getSystem().getDisplayMetrics().scaledDensity;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    return (int)(paramInt / f + 0.5F);
  }
  
  public static TelephonyManager a(Context paramContext)
  {
    return (TelephonyManager)paramContext.getSystemService("phone");
  }
  
  public static String a()
  {
    return Build.BRAND;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      a = paramString;
    } while (TextUtils.isEmpty(paramString));
    au.b(paramContext, a);
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static String b(Context paramContext)
  {
    if (m(paramContext)) {
      return "pad";
    }
    return "mobile";
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      ar.a(paramContext);
    }
    return false;
  }
  
  public static int c()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String c(Context paramContext)
  {
    String str2 = "";
    String str1 = str2;
    if (b(paramContext, "android.permission.READ_PHONE_STATE")) {}
    try
    {
      str1 = a(paramContext).getDeviceId();
      if (!TextUtils.isEmpty(str1))
      {
        paramContext = str1;
        if (!str1.matches("0+")) {}
      }
      else
      {
        paramContext = "";
        ar.a("There is no access to obtain imei or imei is zeros");
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        str1 = str2;
      }
    }
  }
  
  public static String d()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String d(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    a = au.d(paramContext);
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    for (;;)
    {
      try
      {
        str2 = c(paramContext);
        str3 = at.a(paramContext);
        if (((!TextUtils.isEmpty(str2)) || (Build.VERSION.SDK_INT < 23) || (a.k)) && ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)))) {
          continue;
        }
        a = UUID.randomUUID().toString();
        ar.a("client is created by UUID");
        au.b(paramContext, a);
      }
      catch (Exception paramContext)
      {
        String str2;
        String str3;
        String[] arrayOfString;
        String str1;
        ar.a(paramContext);
        continue;
      }
      return a;
      arrayOfString = new String[3];
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      arrayOfString[2] = "";
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (Build.VERSION.SDK_INT >= 9) {
            str1 = Build.SERIAL;
          }
        }
      }
      arrayOfString[0] = str1;
      arrayOfString[1] = str3;
      arrayOfString[2] = (Build.BRAND + "/" + Build.MODEL);
      a = as.a(arrayOfString[0] + arrayOfString[1] + arrayOfString[2].toLowerCase(Locale.getDefault()));
    }
  }
  
  public static String e(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    try
    {
      b = paramContext.getPackageManager().getPackageInfo(f(paramContext), 0).versionName;
      if (b == null) {
        return "0";
      }
      paramContext = b;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ar.a(paramContext);
    }
    return "";
  }
  
  public static String f(Context paramContext)
  {
    return paramContext.getPackageName();
  }
  
  public static String g(Context paramContext)
  {
    if (!TextUtils.isEmpty(d)) {
      return d;
    }
    d = paramContext.getResources().getConfiguration().locale.getLanguage().toLowerCase();
    return d;
  }
  
  public static String h(Context paramContext)
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        c = paramContext.getNetworkCountryIso().toLowerCase();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ar.a(paramContext);
      }
    }
    return c;
  }
  
  public static int i(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int j(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static String k(Context paramContext)
  {
    if (e != null) {
      return e;
    }
    e = "";
    try
    {
      int i = Process.myPid();
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == i) {
          e = localRunningAppProcessInfo.processName;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ar.a(localException);
      }
    }
    if (TextUtils.isEmpty(e)) {
      e = paramContext.getPackageName();
    }
    return e;
  }
  
  public static boolean l(Context paramContext)
  {
    return k(paramContext).equals(paramContext.getPackageName());
  }
  
  private static boolean m(Context paramContext)
  {
    return (paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */