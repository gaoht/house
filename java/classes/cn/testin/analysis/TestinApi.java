package cn.testin.analysis;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import org.json.JSONArray;

public class TestinApi
{
  private static boolean a()
  {
    if ((TextUtils.isEmpty(a.e)) || (a.d == null)) {
      ar.e("请先调用init方法初始化sdk");
    }
    while (a(false)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(boolean paramBoolean)
  {
    if (au.f(a.d))
    {
      if (paramBoolean) {
        ar.e("该appkey已被终止使用");
      }
      return true;
    }
    return false;
  }
  
  public static void asyncGetExperiments()
  {
    asyncGetExperiments(null, 0);
  }
  
  public static void asyncGetExperiments(OnExpUpdateListener paramOnExpUpdateListener)
  {
    asyncGetExperiments(paramOnExpUpdateListener, 0);
  }
  
  public static void asyncGetExperiments(OnExpUpdateListener paramOnExpUpdateListener, int paramInt)
  {
    if (!a())
    {
      if (paramOnExpUpdateListener != null) {
        paramOnExpUpdateListener.onUpdate(false);
      }
      return;
    }
    aa.a().a(paramOnExpUpdateListener, paramInt);
  }
  
  private static boolean b()
  {
    if ((!al.l(a.d)) && (!a.n))
    {
      ar.e("sdk is not allowed to run in multiprocess!");
      a.e = null;
      a.d = null;
      return false;
    }
    return true;
  }
  
  public static void flush()
  {
    if (!a()) {
      return;
    }
    aa.a().a(5, new Object[0]);
  }
  
  public static boolean getBooleanFlag(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      return paramBoolean;
    }
    try
    {
      boolean bool = ((Boolean)aa.a().a(paramString, Boolean.valueOf(paramBoolean))).booleanValue();
      return bool;
    }
    catch (Throwable paramString)
    {
      ar.b(paramString);
    }
    return paramBoolean;
  }
  
  public static String getClientId(Context paramContext)
  {
    try
    {
      paramContext = al.d(paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ar.a(paramContext);
    }
    return null;
  }
  
  public static JSONArray getCurrentExperimentsInfo()
  {
    if (!a()) {
      return new JSONArray();
    }
    return aa.a().g();
  }
  
  public static double getDoubleFlag(String paramString, double paramDouble)
  {
    if (!a()) {
      return paramDouble;
    }
    try
    {
      double d = ((Number)aa.a().a(paramString, Double.valueOf(paramDouble))).doubleValue();
      return d;
    }
    catch (Throwable paramString)
    {
      ar.b(paramString);
    }
    return paramDouble;
  }
  
  public static float getFloatFlag(String paramString, float paramFloat)
  {
    if (!a()) {
      return paramFloat;
    }
    try
    {
      float f = ((Number)aa.a().a(paramString, Float.valueOf(paramFloat))).floatValue();
      return f;
    }
    catch (Throwable paramString)
    {
      ar.b(paramString);
    }
    return paramFloat;
  }
  
  public static int getIntegerFlag(String paramString, int paramInt)
  {
    if (!a()) {
      return paramInt;
    }
    try
    {
      int i = ((Number)aa.a().a(paramString, Integer.valueOf(paramInt))).intValue();
      return i;
    }
    catch (Throwable paramString)
    {
      ar.b(paramString);
    }
    return paramInt;
  }
  
  public static long getLongFlag(String paramString, long paramLong)
  {
    if (!a()) {
      return paramLong;
    }
    try
    {
      long l = ((Number)aa.a().a(paramString, Long.valueOf(paramLong))).longValue();
      return l;
    }
    catch (Throwable paramString)
    {
      ar.b(paramString);
    }
    return paramLong;
  }
  
  public static String getStringFlag(String paramString1, String paramString2)
  {
    if (!a()) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)aa.a().a(paramString1, paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      ar.b(paramString1);
    }
    return paramString2;
  }
  
  public static void init(Context paramContext, String paramString)
  {
    init(paramContext, paramString, null);
  }
  
  public static void init(Context paramContext, String paramString, TestinConfig paramTestinConfig)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      ar.g("context和appkey不能为空");
    }
    do
    {
      return;
      a.e = paramString;
      a.d = paramContext.getApplicationContext();
      if (paramTestinConfig != null) {
        paramTestinConfig.a(a.d);
      }
    } while ((!b()) || (a(true)));
    aa.a().a(a.d);
  }
  
  public static boolean isNewUser(Context paramContext)
  {
    return au.h(paramContext);
  }
  
  public static void setCachedCustomLabels(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    if (paramContext != null) {
      u.a(paramContext.getApplicationContext(), paramHashMap, true);
    }
  }
  
  @Deprecated
  public static void setCheckMac(boolean paramBoolean)
  {
    a.k = paramBoolean;
  }
  
  @Deprecated
  public static void setClientId(Context paramContext, String paramString)
  {
    al.a(paramContext, paramString);
  }
  
  @Deprecated
  public static void setCustomLabel(HashMap<String, Object> paramHashMap)
  {
    u.a(null, paramHashMap, false);
  }
  
  @Deprecated
  public static void setOnlyWifiUpload(boolean paramBoolean)
  {
    a.j = paramBoolean;
  }
  
  public static void supportWebView(WebView paramWebView, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 17) && (!paramBoolean)) {
      ar.c("Current api level is JellyBean or below that not support this feature!");
    }
    while (paramWebView == null) {
      return;
    }
    paramWebView.getSettings().setJavaScriptEnabled(true);
    paramWebView.addJavascriptInterface(new TestinJavaScriptInteface(), "testinApi");
  }
  
  public static void track(String paramString)
  {
    track(paramString, 1.0D);
  }
  
  public static void track(String paramString, double paramDouble)
  {
    if (!a()) {
      return;
    }
    aa.a().a(paramString, paramDouble);
  }
  
  @Deprecated
  public static void updateExptConfig()
  {
    updateExptConfig(null, 0);
  }
  
  @Deprecated
  public static void updateExptConfig(OnExpUpdateListener paramOnExpUpdateListener)
  {
    updateExptConfig(paramOnExpUpdateListener, 0);
  }
  
  @Deprecated
  public static void updateExptConfig(OnExpUpdateListener paramOnExpUpdateListener, int paramInt)
  {
    if (!a())
    {
      if (paramOnExpUpdateListener != null) {
        paramOnExpUpdateListener.onUpdate(false);
      }
      return;
    }
    aa.a().a(paramOnExpUpdateListener, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/TestinApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */