package com.ziroom.credit.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class b
  extends WebViewClient
{
  private WebView a;
  private Activity b;
  
  public b(WebView paramWebView)
  {
    this.a = paramWebView;
  }
  
  public b(WebView paramWebView, Activity paramActivity)
  {
    this.a = paramWebView;
    this.b = paramActivity;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    Log.e("yangxj", "onLoadResource==" + paramString);
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    Log.e("yangxj", "onPageFinished==" + paramString);
    if (paramString.contains("api/userInfoApiController/callbacktUserAuthResult"))
    {
      this.b.setResult(272);
      this.b.finish();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    Log.e("yangxj", "onPageStarted==" + paramString);
    if (paramString.contains("toagreePage")) {}
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */