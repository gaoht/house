package com.ziroom.ziroomcustomer.payment.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.a;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.payment.activity.PayWebViewActivity;
import com.ziroom.ziroomcustomer.payment.d.d;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.util.u;

@Instrumented
public class b
  extends WebViewClient
{
  boolean a = true;
  Handler b = new Handler();
  int c = 0;
  Runnable d = new Runnable()
  {
    public void run()
    {
      ((PayWebViewActivity)b.a(b.this)).showProgressNoCancel("", 33000L);
      if (b.this.c < 10)
      {
        com.ziroom.ziroomcustomer.payment.d.b.getHuifuBandCardResult(b.a(b.this), b.b(b.this), new i(b.a(b.this), new d(Object.class))
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            super.onFailure(paramAnonymous2Throwable);
            ((PayWebViewActivity)this.b).dismissProgress();
          }
          
          public void onSuccess(int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2Object);
            paramAnonymous2Object = e.parseObject(paramAnonymous2Object.toString());
            if ("4".equals(((e)paramAnonymous2Object).get("BindResult")))
            {
              ((PayWebViewActivity)this.b).dismissProgress();
              ((PayWebViewActivity)this.b).setResult(90);
              ((PayWebViewActivity)this.b).finish();
              return;
            }
            if ("3".equals(((e)paramAnonymous2Object).get("BindResult")))
            {
              ((PayWebViewActivity)this.b).dismissProgress();
              b.c(b.this);
              return;
            }
            paramAnonymous2Object = b.this;
            ((b)paramAnonymous2Object).c += 1;
            b.this.b.postDelayed(b.this.d, 3000L);
          }
        });
        return;
      }
      ((PayWebViewActivity)b.a(b.this)).dismissProgress();
      b.a(b.this).setResult(92);
      b.a(b.this).finish();
    }
  };
  private a e;
  private WebView f;
  private Activity g;
  private String h;
  
  public b(WebView paramWebView)
  {
    this.f = paramWebView;
  }
  
  public b(WebView paramWebView, Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.f = paramWebView;
    this.g = paramActivity;
    this.h = paramString1;
  }
  
  private void a()
  {
    this.g.setResult(91);
    this.g.finish();
  }
  
  public a getmOnReceivedError()
  {
    return this.e;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    u.e("yangxj", "onLoadResource==" + paramString);
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    u.e("yangxj", "onPageStarted==" + paramString);
    if (paramString.contains("chinapnr/bindBankRetUrl.do"))
    {
      paramWebView = this.f;
      if (!(paramWebView instanceof WebView)) {
        paramWebView.loadUrl("");
      }
      for (;;)
      {
        this.b.post(this.d);
        return;
        WebviewInstrumentation.loadUrl((WebView)paramWebView, "");
      }
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    u.e("yangxj", "onReceivedHttpAuthRequest==" + paramString1 + "---------" + paramString2);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    if (this.e != null) {
      this.e.onReceivedError();
    }
  }
  
  public void setmOnReceivedError(a parama)
  {
    this.e = parama;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    u.e("yangxj", "onPageStarted==" + paramString + "---------" + paramString.contains("chinapnr/bindBankRetUrl.do"));
    if (paramString.contains("chinapnr/bindBankRetUrl.do"))
    {
      this.g.setResult(90);
      this.g.finish();
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onReceivedError();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */