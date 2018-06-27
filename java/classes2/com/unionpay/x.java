package com.unionpay;

import android.webkit.WebView;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;

@Instrumented
final class x
  implements Runnable
{
  x(WebViewJavascriptBridge paramWebViewJavascriptBridge, String paramString) {}
  
  public final void run()
  {
    WebView localWebView = this.b.mWebView;
    String str = this.a;
    if (!(localWebView instanceof WebView))
    {
      localWebView.loadUrl(str);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localWebView, str);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */