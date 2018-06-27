package com.freelxl.baselibrary.webview;

import android.graphics.Bitmap;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

public class h
  extends WebViewClient
{
  private X5_BridgeWebView b;
  
  public h(X5_BridgeWebView paramX5_BridgeWebView)
  {
    this.b = paramX5_BridgeWebView;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ("WebViewJavascriptBridge.js" != null) {
      g.webViewLoadLocalJs(paramWebView, "WebViewJavascriptBridge.js");
    }
    if (this.b.getStartupMessage() != null)
    {
      paramWebView = this.b.getStartupMessage().iterator();
      while (paramWebView.hasNext())
      {
        paramString = (f)paramWebView.next();
        this.b.a(paramString);
      }
      this.b.setStartupMessage(null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
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
      this.b.h();
      return true;
    }
    if (paramString.startsWith("yy://return/"))
    {
      this.b.a(paramString);
      return true;
    }
    label54:
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/webview/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */