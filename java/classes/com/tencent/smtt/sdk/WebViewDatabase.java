package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase
{
  private static WebViewDatabase a;
  private Context b;
  
  protected WebViewDatabase(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static WebViewDatabase a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new WebViewDatabase(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static WebViewDatabase getInstance(Context paramContext)
  {
    return a(paramContext);
  }
  
  public void clearFormData()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().g(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
  }
  
  public void clearHttpAuthUsernamePassword()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().e(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public void clearUsernamePassword()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().c(this.b);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
  }
  
  public boolean hasFormData()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().f(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
  }
  
  public boolean hasHttpAuthUsernamePassword()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().d(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
  }
  
  @Deprecated
  public boolean hasUsernamePassword()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().b(this.b);
    }
    return android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/tencent/smtt/sdk/WebViewDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */