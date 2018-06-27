package com.unionpay;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.unionpay.utils.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;

@Instrumented
public class WebViewJavascriptBridge
  implements Serializable
{
  ab _messageHandler;
  Map _messageHandlers;
  Map _responseCallbacks;
  long _uniqueId;
  Activity mContext;
  WebView mWebView;
  
  public WebViewJavascriptBridge(Activity paramActivity, WebView paramWebView, ab paramab)
  {
    this.mContext = paramActivity;
    this.mWebView = paramWebView;
    this._messageHandler = paramab;
    this._messageHandlers = new HashMap();
    this._responseCallbacks = new HashMap();
    this._uniqueId = 0L;
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.addJavascriptInterface(this, "_WebViewJavascriptBridge");
    this.mWebView.setWebViewClient(new aa(this, (byte)0));
    paramActivity = this.mWebView;
    paramWebView = new z(this, (byte)0);
    if (!(paramActivity instanceof WebView))
    {
      paramActivity.setWebChromeClient(paramWebView);
      return;
    }
    VdsAgent.setWebChromeClient((WebView)paramActivity, paramWebView);
  }
  
  private void _callbackJs(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("responseId", paramString1);
    localHashMap.put("responseData", paramString2);
    _dispatchMessage(localHashMap);
  }
  
  private void _dispatchMessage(Map paramMap)
  {
    paramMap = new JSONObject(paramMap).toString();
    g.a("test", "sending:" + paramMap);
    paramMap = String.format("javascript:WebViewJavascriptBridge._handleMessageFromJava('%s');", new Object[] { doubleEscapeString(paramMap) });
    this.mContext.runOnUiThread(new x(this, paramMap));
  }
  
  private void _sendData(String paramString1, ac paramac, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString1);
    if (paramac != null)
    {
      paramString1 = new StringBuilder("java_cb_");
      long l = this._uniqueId + 1L;
      this._uniqueId = l;
      paramString1 = l;
      this._responseCallbacks.put(paramString1, paramac);
      localHashMap.put("callbackId", paramString1);
    }
    if (paramString2 != null) {
      localHashMap.put("handlerName", paramString2);
    }
    _dispatchMessage(localHashMap);
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    for (;;)
    {
      try
      {
        Object localObject = new Scanner(paramInputStream, "UTF-8").useDelimiter("\\A");
        if (((Scanner)localObject).hasNext()) {
          localObject = ((Scanner)localObject).next();
        }
        localObject = "";
      }
      catch (IOException paramInputStream)
      {
        try
        {
          paramInputStream.close();
          return (String)localObject;
        }
        catch (IOException paramInputStream)
        {
          continue;
        }
        paramInputStream = paramInputStream;
        localObject = "";
        paramInputStream.printStackTrace();
        return (String)localObject;
      }
    }
  }
  
  private String doubleEscapeString(String paramString)
  {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f");
  }
  
  private void loadWebViewJavascriptBridgeJs(WebView paramWebView)
  {
    String str = convertStreamToString(getClass().getResourceAsStream("res/webviewjavascriptbridge.js"));
    str = "javascript:" + str;
    if (!(paramWebView instanceof WebView))
    {
      paramWebView.loadUrl(str);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)paramWebView, str);
  }
  
  @JavascriptInterface
  public void _handleMessageFromJs(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramString2 != null)
    {
      ((ac)this._responseCallbacks.get(paramString2)).a(paramString3);
      this._responseCallbacks.remove(paramString2);
      return;
    }
    if (paramString4 != null) {}
    for (paramString2 = new y(this, paramString4);; paramString2 = null)
    {
      if (paramString5 != null)
      {
        paramString4 = (ab)this._messageHandlers.get(paramString5);
        paramString3 = paramString4;
        if (paramString4 == null) {
          g.b("test", "WVJB Warning: No handler for " + paramString5);
        }
      }
      else
      {
        paramString3 = this._messageHandler;
      }
      try
      {
        this.mContext.runOnUiThread(new w(this, paramString3, paramString1, paramString2));
        return;
      }
      catch (Exception paramString1)
      {
        g.b("test", "WebViewJavascriptBridge: WARNING: java handler threw. " + paramString1.getMessage());
        return;
      }
    }
  }
  
  public void callHandler(String paramString)
  {
    callHandler(paramString, null, null);
  }
  
  public void callHandler(String paramString1, String paramString2)
  {
    callHandler(paramString1, paramString2, null);
  }
  
  public void callHandler(String paramString1, String paramString2, ac paramac)
  {
    _sendData(paramString2, paramac, paramString1);
  }
  
  public void registerHandler(String paramString, ab paramab)
  {
    this._messageHandlers.put(paramString, paramab);
  }
  
  public void send(String paramString)
  {
    send(paramString, null);
  }
  
  public void send(String paramString, ac paramac)
  {
    _sendData(paramString, paramac, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/unionpay/WebViewJavascriptBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */