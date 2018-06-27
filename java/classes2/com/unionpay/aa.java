package com.unionpay;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unionpay.utils.g;

final class aa
  extends WebViewClient
{
  private aa(WebViewJavascriptBridge paramWebViewJavascriptBridge) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    g.a("test", "onPageFinished");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */