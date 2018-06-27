package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;

public class AnalyticsConfig
{
  public static boolean ACTIVITY_DURATION_OPEN;
  public static boolean CATCH_EXCEPTION;
  public static String GPU_RENDERER;
  public static String GPU_VENDER;
  static double[] a = null;
  private static String b = null;
  private static String c = null;
  private static String d = null;
  private static int e;
  public static long kContinueSessionMillis;
  public static String mWrapperType = null;
  public static String mWrapperVersion = null;
  public static boolean sEncrypt;
  public static int sLatentWindow;
  
  static
  {
    e = 0;
    GPU_VENDER = "";
    GPU_RENDERER = "";
    ACTIVITY_DURATION_OPEN = true;
    CATCH_EXCEPTION = true;
    kContinueSessionMillis = 30000L;
    sEncrypt = false;
  }
  
  static void a(Context paramContext, int paramInt)
  {
    e = paramInt;
    cc.a(paramContext).a(e);
  }
  
  static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      b = paramString;
    }
    do
    {
      return;
      str = bv.p(paramContext);
      if (TextUtils.isEmpty(str)) {
        break;
      }
      b = str;
    } while (str.equals(paramString));
    by.d("Appkey和AndroidManifest.xml中配置的不一致 ");
    return;
    String str = cc.a(paramContext).c();
    if (!TextUtils.isEmpty(str)) {
      if (!str.equals(paramString))
      {
        by.d("Appkey和上次配置的不一致 ");
        cc.a(paramContext).a(paramString);
      }
    }
    for (;;)
    {
      b = paramString;
      return;
      cc.a(paramContext).a(paramString);
    }
  }
  
  static void a(String paramString)
  {
    c = paramString;
  }
  
  static void a(boolean paramBoolean)
  {
    sEncrypt = paramBoolean;
  }
  
  static void b(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      d = paramString;
      cc.a(paramContext).c(d);
    }
  }
  
  public static String getAppkey(Context paramContext)
  {
    if (TextUtils.isEmpty(b))
    {
      b = bv.p(paramContext);
      if (TextUtils.isEmpty(b)) {
        b = cc.a(paramContext).c();
      }
    }
    return b;
  }
  
  public static String getChannel(Context paramContext)
  {
    if (TextUtils.isEmpty(c)) {
      c = bv.s(paramContext);
    }
    return c;
  }
  
  public static double[] getLocation()
  {
    return a;
  }
  
  public static String getSDKVersion(Context paramContext)
  {
    return "6.1.1";
  }
  
  public static String getSecretKey(Context paramContext)
  {
    if (TextUtils.isEmpty(d)) {
      d = cc.a(paramContext).e();
    }
    return d;
  }
  
  public static int getVerticalType(Context paramContext)
  {
    if (e == 0) {
      e = cc.a(paramContext).f();
    }
    return e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/AnalyticsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */