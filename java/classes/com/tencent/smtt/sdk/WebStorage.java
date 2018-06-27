package com.tencent.smtt.sdk;

import java.util.Map;

public class WebStorage
{
  private static WebStorage a;
  
  private static WebStorage a()
  {
    try
    {
      if (a == null) {
        a = new WebStorage();
      }
      WebStorage localWebStorage = a;
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    return a();
  }
  
  public void deleteAllData()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().n();
      return;
    }
    android.webkit.WebStorage.getInstance().deleteAllData();
  }
  
  public void deleteOrigin(String paramString)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().e(paramString);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteOrigin(paramString);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().a(paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getOrigins(paramValueCallback);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().b(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getQuotaForOrigin(paramString, paramValueCallback);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().a(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getUsageForOrigin(paramString, paramValueCallback);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().a(paramString, paramLong);
      return;
    }
    android.webkit.WebStorage.getInstance().setQuotaForOrigin(paramString, paramLong);
  }
  
  @Deprecated
  public static abstract interface QuotaUpdater
  {
    public abstract void updateQuota(long paramLong);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/tencent/smtt/sdk/WebStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */