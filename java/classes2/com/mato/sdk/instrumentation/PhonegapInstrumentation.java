package com.mato.sdk.instrumentation;

import org.apache.cordova.CordovaWebView;

public class PhonegapInstrumentation
{
  public static void loadUrl(CordovaWebView paramCordovaWebView, String paramString, int paramInt)
  {
    if (paramCordovaWebView != null) {
      InstrumentationUtils.a();
    }
    paramCordovaWebView.loadUrl(paramString, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/PhonegapInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */