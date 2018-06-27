package com.tencent.smtt.sdk;

import android.os.Message;

class u
  implements Runnable
{
  u(SystemWebChromeClient paramSystemWebChromeClient, WebView.WebViewTransport paramWebViewTransport, Message paramMessage) {}
  
  public void run()
  {
    WebView localWebView = this.a.getWebView();
    if (localWebView != null) {
      ((android.webkit.WebView.WebViewTransport)this.b.obj).setWebView(localWebView.a());
    }
    this.b.sendToTarget();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */