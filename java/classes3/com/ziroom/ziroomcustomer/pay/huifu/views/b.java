package com.ziroom.ziroomcustomer.pay.huifu.views;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HufuBandCardResult;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HufuBandCardResult.DataBean;
import com.ziroom.ziroomcustomer.util.u;

@Instrumented
public class b
  extends WebViewClient
{
  boolean a = true;
  private WebView b;
  private Activity c;
  private boolean d;
  private String e;
  
  public b(WebView paramWebView)
  {
    this.b = paramWebView;
  }
  
  public b(WebView paramWebView, Activity paramActivity, boolean paramBoolean, String paramString)
  {
    this.b = paramWebView;
    this.c = paramActivity;
    this.d = paramBoolean;
    this.e = paramString;
  }
  
  private void a()
  {
    com.freelxl.baselibrary.widget.a.show(this.c, "", false, true);
    new Thread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        for (;;)
        {
          if (b.this.a) {
            try
            {
              Thread.sleep(3000L);
              i += 1;
              if (i > 20)
              {
                b.this.a = false;
                b.a(b.this).setResult(92);
                b.a(b.this).finish();
              }
              com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuBandCardResult(b.a(b.this), b.b(b.this), new i.a()
              {
                public void onParse(String paramAnonymous2String, k paramAnonymous2k) {}
                
                public void onSuccess(k paramAnonymous2k)
                {
                  u.e("yangxj-----", com.alibaba.fastjson.a.toJSONString(paramAnonymous2k));
                  if (!paramAnonymous2k.getSuccess().booleanValue()) {
                    g.textToast(b.a(b.this), paramAnonymous2k.getMessage());
                  }
                  do
                  {
                    return;
                    paramAnonymous2k = (HufuBandCardResult)paramAnonymous2k.getObject();
                    if (paramAnonymous2k.data.BindResult.equals("4"))
                    {
                      b.a(b.this).setResult(90);
                      b.a(b.this).finish();
                      b.this.a = false;
                      return;
                    }
                  } while (!paramAnonymous2k.data.BindResult.equals("3"));
                  b.a(b.this).setResult(91);
                  b.a(b.this).finish();
                  b.this.a = false;
                }
              });
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
      }
    }).start();
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
      paramWebView = this.b;
      if (!(paramWebView instanceof WebView)) {
        paramWebView.loadUrl("");
      }
      for (;;)
      {
        a();
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
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    u.e("yangxj", "onPageStarted==" + paramString + "---------" + paramString.contains("chinapnr/bindBankRetUrl.do"));
    if (paramString.contains("chinapnr/bindBankRetUrl.do"))
    {
      this.c.setResult(90);
      this.c.finish();
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */