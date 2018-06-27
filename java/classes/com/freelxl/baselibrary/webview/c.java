package com.freelxl.baselibrary.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

public class c
  extends WebViewClient
{
  private BridgeWebView a;
  
  public c(BridgeWebView paramBridgeWebView)
  {
    this.a = paramBridgeWebView;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ("WebViewJavascriptBridge.js" != null) {
      b.webViewLoadLocalJs(paramWebView, "WebViewJavascriptBridge.js");
    }
    if (this.a.getStartupMessage() != null)
    {
      paramWebView = this.a.getStartupMessage().iterator();
      while (paramWebView.hasNext())
      {
        paramString = (f)paramWebView.next();
        this.a.a(paramString);
      }
      this.a.setStartupMessage(null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      paramString = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      if (!paramString.startsWith("yy://")) {
        break label54;
      }
      this.a.b();
      return true;
    }
    if (paramString.startsWith("yy://return/"))
    {
      this.a.a(paramString);
      return true;
    }
    label54:
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/webview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */