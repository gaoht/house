package com.unionpay;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

final class z
  extends WebChromeClient
{
  private z(WebViewJavascriptBridge paramWebViewJavascriptBridge) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return true;
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramJsResult.cancel();
    paramWebView = Toast.makeText(this.a.mContext, paramString2, 0);
    if (!(paramWebView instanceof Toast)) {
      paramWebView.show();
    }
    for (;;)
    {
      return true;
      VdsAgent.showToast((Toast)paramWebView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */