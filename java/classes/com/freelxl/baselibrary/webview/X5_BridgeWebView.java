package com.freelxl.baselibrary.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
@Instrumented
public class X5_BridgeWebView
  extends com.tencent.smtt.sdk.WebView
{
  Map<String, d> b = new HashMap();
  Map<String, a> c = new HashMap();
  a d = new e();
  private final String e = "X5_BridgeWebView";
  private List<f> f = new ArrayList();
  private long g = 0L;
  
  public X5_BridgeWebView(Context paramContext)
  {
    super(paramContext);
    i();
  }
  
  public X5_BridgeWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
  }
  
  public X5_BridgeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i();
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
      long l = this.g + 1L;
      this.g = l;
      paramString2 = String.format("JAVA_CB_%s", new Object[] { l + "_" + SystemClock.currentThreadTimeMillis() });
      this.b.put(paramString2, paramd);
      localf.setCallbackId(paramString2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localf.setHandlerName(paramString1);
    }
    b(localf);
  }
  
  private void b(f paramf)
  {
    if (this.f != null)
    {
      this.f.add(paramf);
      return;
    }
    a(paramf);
  }
  
  private void i()
  {
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 19) {
      com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(true);
    }
    getSettings().setDomStorageEnabled(true);
    getSettings().setDatabaseEnabled(true);
    getSettings().setAppCacheEnabled(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().setUseWideViewPort(true);
    getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    getSettings().setLoadWithOverviewMode(true);
    setWebViewClient(g());
  }
  
  void a(f paramf)
  {
    paramf = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", new Object[] { paramf.toJson().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"") });
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!(this instanceof android.webkit.WebView)) {
        loadUrl(paramf);
      }
    }
    else {
      return;
    }
    WebviewInstrumentation.loadUrl((android.webkit.WebView)this, paramf);
  }
  
  void a(String paramString)
  {
    String str = g.getFunctionFromReturnUrl(paramString);
    d locald = (d)this.b.get(str);
    paramString = g.getDataFromReturnUrl(paramString);
    if (locald != null)
    {
      locald.onCallBack(paramString);
      this.b.remove(str);
    }
  }
  
  public void callHandler(String paramString1, String paramString2, d paramd)
  {
    a(paramString1, paramString2, paramd);
  }
  
  protected h g()
  {
    return new h(this);
  }
  
  public List<f> getStartupMessage()
  {
    return this.f;
  }
  
  void h()
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
            ((d)X5_BridgeWebView.this.b.get(paramAnonymousString)).onCallBack(localf.getResponseData());
            X5_BridgeWebView.this.b.remove(paramAnonymousString);
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
                  X5_BridgeWebView.a(X5_BridgeWebView.this, localf);
                }
              };
              if (TextUtils.isEmpty(localf.getHandlerName())) {
                break label200;
              }
            }
            for (a locala = (a)X5_BridgeWebView.this.c.get(localf.getHandlerName());; locala = X5_BridgeWebView.this.d)
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
  
  public void loadUrl(String paramString, d paramd)
  {
    if (!(this instanceof android.webkit.WebView)) {
      loadUrl(paramString);
    }
    for (;;)
    {
      this.b.put(g.parseFunctionName(paramString), paramd);
      return;
      WebviewInstrumentation.loadUrl((android.webkit.WebView)this, paramString);
    }
  }
  
  public void registerHandler(String paramString, a parama)
  {
    if (parama != null) {
      this.c.put(paramString, parama);
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
    this.d = parama;
  }
  
  public void setStartupMessage(List<f> paramList)
  {
    this.f = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/webview/X5_BridgeWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */