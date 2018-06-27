package com.mato.sdk.instrumentation;

import android.webkit.WebView;
import java.util.Map;

public class WebviewInstrumentation
{
  public static void loadData(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (paramWebView != null) {
      InstrumentationUtils.a();
    }
    paramWebView.loadData(paramString1, paramString2, paramString3);
  }
  
  public static void loadDataWithBaseURL(WebView paramWebView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramWebView != null) {
      InstrumentationUtils.a();
    }
    paramWebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static void loadUrl(WebView paramWebView, String paramString)
  {
    if (paramWebView != null) {
      InstrumentationUtils.a();
    }
    paramWebView.loadUrl(paramString);
  }
  
  public static void loadUrl(WebView paramWebView, String paramString, Map<String, String> paramMap)
  {
    if (paramWebView != null) {
      InstrumentationUtils.a();
    }
    paramWebView.loadUrl(paramString, paramMap);
  }
  
  public static void postUrl(WebView paramWebView, String paramString, byte[] paramArrayOfByte)
  {
    if (paramWebView != null) {
      InstrumentationUtils.a();
    }
    paramWebView.postUrl(paramString, paramArrayOfByte);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/WebviewInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */