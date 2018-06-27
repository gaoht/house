package com.alipay.sdk.auth;

import android.webkit.WebView;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;

@Instrumented
final class d
  implements Runnable
{
  d(AuthActivity paramAuthActivity, String paramString) {}
  
  public final void run()
  {
    try
    {
      WebView localWebView = AuthActivity.h(this.b);
      String str = "javascript:" + this.a;
      if (!(localWebView instanceof WebView))
      {
        localWebView.loadUrl(str);
        return;
      }
      WebviewInstrumentation.loadUrl((WebView)localWebView, str);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */