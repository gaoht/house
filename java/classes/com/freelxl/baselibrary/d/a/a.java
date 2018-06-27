package com.freelxl.baselibrary.d.a;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;

public class a
{
  public static b addProgressRequestListener(RequestBody paramRequestBody, com.freelxl.baselibrary.d.c.b paramb)
  {
    return new b(paramRequestBody, paramb);
  }
  
  public static OkHttpClient addProgressResponseListener(OkHttpClient paramOkHttpClient, com.freelxl.baselibrary.d.c.b paramb)
  {
    paramOkHttpClient.newBuilder().addNetworkInterceptor(new Interceptor()
    {
      public Response intercept(Interceptor.Chain paramAnonymousChain)
        throws IOException
      {
        paramAnonymousChain = paramAnonymousChain.proceed(paramAnonymousChain.request());
        return paramAnonymousChain.newBuilder().body(new c(paramAnonymousChain.body(), this.a)).build();
      }
    }).build();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */