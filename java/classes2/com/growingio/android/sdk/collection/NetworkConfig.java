package com.growingio.android.sdk.collection;

import android.text.TextUtils;

public class NetworkConfig
{
  private static String a = null;
  private static String b = null;
  private static NetworkConfig e = new NetworkConfig();
  private String c;
  private String d;
  
  public static NetworkConfig a()
  {
    return e;
  }
  
  public static String i()
  {
    if (TextUtils.isEmpty(b)) {
      return "https://www.growingio.com";
    }
    return b;
  }
  
  public static String j()
  {
    return i() + "/mobile/events";
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.d)) {
      return "";
    }
    return "-" + this.d;
  }
  
  public void b(String paramString)
  {
    b = paramString;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.c)) {
      return String.format("https://api%s.growingio.com/v2", new Object[] { b() });
    }
    return this.c + "/v2";
  }
  
  public void c(String paramString)
  {
    a = paramString;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.c)) {
      return String.format("https://api%s.growingio.com/custom", new Object[] { b() });
    }
    return this.c + "/custom";
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d = paramString;
  }
  
  public String e()
  {
    return String.format("https://crashapi%s.growingio.com/v2", new Object[] { b() });
  }
  
  public String f()
  {
    return String.format("https://tags%s.growingio.com", new Object[] { b() });
  }
  
  public String g()
  {
    return String.format("wss://ws%s.growingio.com", new Object[] { b() }) + "/app/%s/circle/%s";
  }
  
  public String h()
  {
    if (TextUtils.isEmpty(a)) {
      return String.format("https://t%s.growingio.com/app", new Object[] { b() });
    }
    return a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/NetworkConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */