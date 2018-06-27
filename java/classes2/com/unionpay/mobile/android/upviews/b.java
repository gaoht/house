package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import java.util.ArrayList;
import java.util.Timer;

@Instrumented
public final class b
  extends WebView
  implements Handler.Callback
{
  private WebSettings a = null;
  private Handler b = null;
  private a c = null;
  private Timer d = new Timer();
  private boolean e = false;
  private ArrayList<String> f = null;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext);
    this.c = parama;
    setScrollBarStyle(33554432);
    this.a = getSettings();
    this.a.setJavaScriptEnabled(true);
    paramContext = new c((byte)0);
    if (!(this instanceof WebView)) {
      setWebChromeClient(paramContext);
    }
    for (;;)
    {
      setWebViewClient(new d((byte)0));
      return;
      VdsAgent.setWebChromeClient((WebView)this, paramContext);
    }
  }
  
  private final void a()
  {
    String str = String.format("<div align=\"center\">%s</div>", new Object[] { "&#x7F51;&#x9875;&#x52A0;&#x8F7D;&#x5931;&#x8D25;&#xFF0C;&#x8BF7;&#x91CD;&#x8BD5;" });
    if (!(this instanceof WebView))
    {
      loadData(str, "text/html", "utf-8");
      return;
    }
    WebviewInstrumentation.loadData((WebView)this, str, "text/html", "utf-8");
  }
  
  public final void a(String paramString)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    if ((paramString != null) && (paramString.length() > 0)) {
      this.f.add(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    Message localMessage = this.b.obtainMessage(0);
    localMessage.obj = paramString;
    this.b.sendMessage(localMessage);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if (this.c != null) {
          this.c.t();
        }
        String str = "";
        if (paramMessage.obj != null) {
          str = (String)paramMessage.obj;
        }
        Log.e("uppay", "url = " + str);
        if (!(this instanceof WebView))
        {
          loadUrl(str);
          return true;
        }
        WebviewInstrumentation.loadUrl((WebView)this, str);
        return true;
        a();
        if (paramMessage.what == 1) {
          this.e = true;
        }
      } while (this.c == null);
      this.c.u();
      return true;
    } while ((this.c == null) || (!(this.c instanceof b)));
    ((b)this.c).c((String)paramMessage.obj);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void t();
    
    public abstract void u();
  }
  
  public static abstract interface b
    extends b.a
  {
    public abstract void c(String paramString);
  }
  
  private final class c
    extends WebChromeClient
  {
    private c() {}
    
    public final void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        b.a(b.this).sendEmptyMessage(1);
      }
    }
  }
  
  @Instrumented
  private final class d
    extends WebViewClient
  {
    private d() {}
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      b.c(b.this).cancel();
      b.c(b.this).purge();
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      b.a(b.this, new Timer());
      paramWebView = new c(this);
      b.c(b.this).schedule(paramWebView, 30000L);
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      b.d(b.this);
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      String str;
      if ((b.e(b.this) == null) || (b.e(b.this).size() == 0)) {
        str = null;
      }
      for (;;)
      {
        if (str != null)
        {
          paramWebView = b.a(b.this).obtainMessage(4);
          paramWebView.obj = paramString;
          b.a(b.this).sendMessage(paramWebView);
          return true;
          if ((paramString != null) && (paramString.length() > 0))
          {
            int i = 0;
            for (;;)
            {
              if ((b.e(b.this) == null) || (i >= b.e(b.this).size())) {
                break label170;
              }
              if (paramString.startsWith((String)b.e(b.this).get(i)))
              {
                str = (String)b.e(b.this).get(i);
                break;
              }
              i += 1;
            }
          }
        }
        else
        {
          if (!(paramWebView instanceof WebView))
          {
            paramWebView.loadUrl(paramString);
            return true;
          }
          WebviewInstrumentation.loadUrl((WebView)paramWebView, paramString);
          return true;
        }
        label170:
        str = null;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upviews/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */