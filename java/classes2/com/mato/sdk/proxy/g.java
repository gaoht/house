package com.mato.sdk.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.mato.sdk.g.i;

public final class g
  extends k
{
  private static final String a = "matosdk_preference";
  private static final String b = "wsg_support";
  private static final String c = "config";
  private static final String d = "precache_md5";
  private static final String e = "ndk_crash_mark";
  private static final String f = "sdk_crash_mark";
  private static final String g = "sdk_disable_mark";
  private static final String h = "app_exist_time";
  private static final String i = "app_url_counts";
  private static final String j = "start_up_fail";
  private static final String k = "bypass_reason";
  private static g l;
  private static int m;
  private static int n;
  
  private g(Context paramContext) {}
  
  public static g a(Context paramContext)
  {
    if (l == null) {
      l = new g(paramContext);
    }
    return l;
  }
  
  private static String b(Context paramContext)
  {
    paramContext = i.l(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "matosdk_preference";
    }
    return "matosdk_preference" + "_" + paramContext;
  }
  
  public final void a(int paramInt)
  {
    b("app_exist_time", paramInt);
  }
  
  public final void a(String paramString)
  {
    d("start_up_fail", paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    d(paramString1 + "_config", paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    b("ndk_crash_mark", paramBoolean);
  }
  
  public final boolean a()
  {
    return a("ndk_crash_mark", false);
  }
  
  public final void b(int paramInt)
  {
    b("app_url_counts", paramInt);
  }
  
  public final void b(String paramString)
  {
    d("bypass_reason", paramString);
  }
  
  public final void b(boolean paramBoolean)
  {
    b("sdk_crash_mark", paramBoolean);
  }
  
  public final boolean b()
  {
    return a("sdk_crash_mark", false);
  }
  
  public final int c(int paramInt)
  {
    return a("wsg_support", -1);
  }
  
  public final void c(String paramString)
  {
    d("config", paramString);
  }
  
  public final void c(boolean paramBoolean)
  {
    b("sdk_disable_mark", paramBoolean);
  }
  
  public final boolean c()
  {
    return a("sdk_disable_mark", false);
  }
  
  public final int d()
  {
    return a("app_exist_time", 0);
  }
  
  public final void d(int paramInt)
  {
    b("wsg_support", paramInt);
  }
  
  public final void d(String paramString)
  {
    d("precache_md5", paramString);
  }
  
  public final int e()
  {
    return a("app_url_counts", 0);
  }
  
  public final void e(String paramString)
  {
    g(paramString + "_config");
  }
  
  public final String f()
  {
    return b("start_up_fail", "");
  }
  
  public final String f(String paramString)
  {
    return b(paramString + "_config", "");
  }
  
  public final String g()
  {
    return b("bypass_reason", "");
  }
  
  public final String h()
  {
    return b("config", "");
  }
  
  public final String i()
  {
    return b("precache_md5", "");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */