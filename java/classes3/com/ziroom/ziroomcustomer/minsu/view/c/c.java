package com.ziroom.ziroomcustomer.minsu.view.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.freelxl.baselibrary.d.b;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.commonlibrary.login.a.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.e.e;
import com.ziroom.ziroomcustomer.util.u;

public class c
  extends com.freelxl.baselibrary.webview.c
{
  private BridgeWebView a;
  private Activity b;
  private boolean c = true;
  
  public c(BridgeWebView paramBridgeWebView)
  {
    super(paramBridgeWebView);
    this.a = paramBridgeWebView;
  }
  
  public c(BridgeWebView paramBridgeWebView, Activity paramActivity, boolean paramBoolean)
  {
    super(paramBridgeWebView);
    this.a = paramBridgeWebView;
    this.b = paramActivity;
    this.c = paramBoolean;
  }
  
  private boolean a(String paramString)
  {
    if (("http://www.baidu.com/".equals(paramString)) || ("https://www.baidu.com/".equals(paramString)))
    {
      a.logout(this.b, new a.a()
      {
        public void onLogoutFinish(boolean paramAnonymousBoolean)
        {
          a.startLoginActivity(c.a(c.this));
          c.a(c.this).finish();
        }
      });
      return true;
    }
    if (("http://www.qiehuan.com/".equals(paramString)) || ("https://www.qiehuan.com/".equals(paramString)))
    {
      paramString = new Intent(this.b, MainActivity.class);
      paramString.putExtra("minsu", "minsu");
      this.b.startActivity(paramString);
      this.b.finish();
      return true;
    }
    return false;
  }
  
  private String b(String paramString)
  {
    if ((this.c) && ((paramString.contains("ziroom.com")) || (paramString.contains("ziroomstay.com")))) {}
    for (String str = e.convertUrl(paramString);; str = paramString)
    {
      u.e("webview", "override baseUrl = " + paramString + "--------resultUrl" + str);
      return str;
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    u.e("lanzhihong", "onLoadResource==" + paramString);
    if (a(paramString)) {
      return;
    }
    super.onLoadResource(paramWebView, b(paramString));
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    ((MinsuWebActivity)this.b).dismissProgress();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    ((MinsuWebActivity)this.b).showProgress("", 20000L);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (paramSslError.getPrimaryError() == 5)
    {
      if (b.isSSLCertOk(paramSslError.getCertificate(), b.a)) {
        paramSslErrorHandler.proceed();
      }
      return;
    }
    paramSslErrorHandler.cancel();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (a(paramString)) {}
    while (paramString.contains("method")) {
      return true;
    }
    return super.shouldOverrideUrlLoading(this.a, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */