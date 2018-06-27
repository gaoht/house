package com.mato.sdk.instrumentation;

import com.squareup.okhttp.OkUrlFactory;
import java.net.HttpURLConnection;
import java.net.URL;

public class OkHttpUrlConnectionInstrumentation
{
  public static HttpURLConnection open(OkUrlFactory paramOkUrlFactory, URL paramURL)
  {
    if (paramOkUrlFactory != null) {
      OkHttpInstrumentation.a(paramOkUrlFactory.client());
    }
    return paramOkUrlFactory.open(paramURL);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/OkHttpUrlConnectionInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */