package com.freelxl.baselibrary.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
@Instrumented
public class BridgeWebView
  extends WebView
{
  Map<String, d> a = new HashMap();
  Map<String, a> b = new HashMap();
  a c = new e();
  private final String d = "BridgeWebView";
  private List<f> e = new ArrayList();
  private long f = 0L;
  
  public BridgeWebView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public BridgeWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public BridgeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(String paramString1, String paramString2, d paramd)
  {
    f localf = new f();
    if (!TextUtils.isEmpty(paramString2)) {
      localf.setData(paramString2);
    }
    if (paramd != null)
    {
      paramString2 = new StringBuilder();
      long l = this.f + 1L;
      this.f = l;
      paramString2 = String.format("JAVA_CB_%s", new Object[] { l + "_" + SystemClock.currentThreadTimeMillis() });
      this.a.put(paramString2, paramd);
      localf.setCallbackId(paramString2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localf.setHandlerName(paramString1);
    }
    b(localf);
  }
  
  private void b(f paramf)
  {
    if (this.e != null)
    {
      this.e.add(paramf);
      return;
    }
    a(paramf);
  }
  
  private void c()
  {
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 19) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
    getSettings().setDomStorageEnabled(true);
    getSettings().setDatabaseEnabled(true);
    getSettings().setAppCacheEnabled(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().setUseWideViewPort(true);
    getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    getSettings().setLoadWithOverviewMode(true);
    setWebViewClient(a());
  }
  
  protected c a()
  {
    return new c(this);
  }
  
  void a(f paramf)
  {
    paramf = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", new Object[] { paramf.toJson().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"") });
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!(this instanceof WebView)) {
        loadUrl(paramf);
      }
    }
    else {
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)this, paramf);
  }
  
  void a(String paramString)
  {
    String str = b.getFunctionFromReturnUrl(paramString);
    d locald = (d)this.a.get(str);
    paramString = b.getDataFromReturnUrl(paramString);
    if (locald != null)
    {
      locald.onCallBack(paramString);
      this.a.remove(str);
    }
  }
  
  void b()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      loadUrl("javascript:WebViewJavascriptBridge._fetchQueue();", new d()
      {
        public void onCallBack(final String paramAnonymousString)
        {
          List localList;
          int i;
          do
          {
            try
            {
              localList = f.toArrayList(paramAnonymousString);
              if ((localList == null) || (localList.size() == 0)) {
                return;
              }
            }
            catch (Exception paramAnonymousString)
            {
              paramAnonymousString.printStackTrace();
              return;
            }
            i = 0;
          } while (i >= localList.size());
          f localf = (f)localList.get(i);
          paramAnonymousString = localf.getResponseId();
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            ((d)BridgeWebView.this.a.get(paramAnonymousString)).onCallBack(localf.getResponseData());
            BridgeWebView.this.a.remove(paramAnonymousString);
          }
          label137:
          label200:
          label209:
          for (;;)
          {
            i += 1;
            break;
            paramAnonymousString = localf.getCallbackId();
            if (!TextUtils.isEmpty(paramAnonymousString))
            {
              paramAnonymousString = new d()
              {
                public void onCallBack(String paramAnonymous2String)
                {
                  f localf = new f();
                  localf.setResponseId(paramAnonymousString);
                  localf.setResponseData(paramAnonymous2String);
                  BridgeWebView.a(BridgeWebView.this, localf);
                }
              };
              if (TextUtils.isEmpty(localf.getHandlerName())) {
                break label200;
              }
            }
            for (a locala = (a)BridgeWebView.this.b.get(localf.getHandlerName());; locala = BridgeWebView.this.c)
            {
              if (locala == null) {
                break label209;
              }
              locala.handler(localf.getData(), paramAnonymousString);
              break;
              paramAnonymousString = new d()
              {
                public void onCallBack(String paramAnonymous2String) {}
              };
              break label137;
            }
          }
        }
      });
    }
  }
  
  public void callHandler(String paramString1, String paramString2, d paramd)
  {
    a(paramString1, paramString2, paramd);
  }
  
  public List<f> getStartupMessage()
  {
    return this.e;
  }
  
  public void loadUrl(String paramString, d paramd)
  {
    if (!(this instanceof WebView)) {
      loadUrl(paramString);
    }
    for (;;)
    {
      this.a.put(b.parseFunctionName(paramString), paramd);
      return;
      WebviewInstrumentation.loadUrl((WebView)this, paramString);
    }
  }
  
  public void registerHandler(String paramString, a parama)
  {
    if (parama != null) {
      this.b.put(paramString, parama);
    }
  }
  
  public void send(String paramString)
  {
    send(paramString, null);
  }
  
  public void send(String paramString, d paramd)
  {
    a(null, paramString, paramd);
  }
  
  public void setDefaultHandler(a parama)
  {
    this.c = parama;
  }
  
  public void setStartupMessage(List<f> paramList)
  {
    this.e = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/webview/BridgeWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */