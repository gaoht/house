package com.mato.sdk.instrumentation;

import android.util.Log;
import com.mato.sdk.b.g;
import com.mato.sdk.proxy.Address;
import com.mato.sdk.proxy.a;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class ApacheHttpClientInstrumentation
{
  private static final String a = "ApacheHttpClientInstrumentation";
  
  private static void a(HttpClient paramHttpClient)
  {
    if (paramHttpClient == null) {}
    Address localAddress2;
    do
    {
      Address localAddress1;
      HttpHost localHttpHost;
      do
      {
        return;
        localAddress1 = InstrumentationUtils.getLastAddress();
        localAddress2 = a.b().g();
        paramHttpClient = paramHttpClient.getParams();
        localHttpHost = (HttpHost)paramHttpClient.getParameter("http.route.default-proxy");
        if (localHttpHost == null) {
          break;
        }
      } while ((localAddress1 == null) || (!localAddress1.getHost().equals(localHttpHost.getHostName())) || (localAddress1.getPort() != localHttpHost.getPort()) || (localAddress2 != null));
      Log.d("ApacheHttpClientInstrumentation", "clear proxy");
      paramHttpClient.setParameter("http.route.default-proxy", null);
      return;
    } while (localAddress2 == null);
    paramHttpClient.setParameter("http.route.default-proxy", new HttpHost(localAddress2.getHost(), localAddress2.getPort()));
  }
  
  private static boolean a(HttpHost paramHttpHost)
  {
    boolean bool = true;
    if (paramHttpHost != null) {
      bool = InstrumentationUtils.a(paramHttpHost.getSchemeName());
    }
    if (bool) {
      Log.d(g.a, "bypass");
    }
    return bool;
  }
  
  private static boolean a(HttpUriRequest paramHttpUriRequest)
  {
    boolean bool = true;
    if (paramHttpUriRequest != null) {
      bool = InstrumentationUtils.a(paramHttpUriRequest.getURI());
    }
    if (bool) {
      Log.d(g.a, "bypass");
    }
    return bool;
  }
  
  public static <T> T execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException
  {
    if (!a(paramHttpHost)) {
      a(paramHttpClient);
    }
    return (T)paramHttpClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public static <T> T execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException
  {
    if (!a(paramHttpHost)) {
      a(paramHttpClient);
    }
    return (T)paramHttpClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public static <T> T execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws IOException, ClientProtocolException
  {
    if (!a(paramHttpUriRequest)) {
      a(paramHttpClient);
    }
    return (T)paramHttpClient.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public static <T> T execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws IOException, ClientProtocolException
  {
    if (!a(paramHttpUriRequest)) {
      a(paramHttpClient);
    }
    return (T)paramHttpClient.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public static HttpResponse execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest)
    throws IOException
  {
    if (!a(paramHttpHost)) {
      a(paramHttpClient);
    }
    return paramHttpClient.execute(paramHttpHost, paramHttpRequest);
  }
  
  public static HttpResponse execute(HttpClient paramHttpClient, HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws IOException
  {
    if (!a(paramHttpHost)) {
      a(paramHttpClient);
    }
    return paramHttpClient.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public static HttpResponse execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    if (!a(paramHttpUriRequest)) {
      a(paramHttpClient);
    }
    return paramHttpClient.execute(paramHttpUriRequest);
  }
  
  public static HttpResponse execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws IOException
  {
    if (!a(paramHttpUriRequest)) {
      a(paramHttpClient);
    }
    return paramHttpClient.execute(paramHttpUriRequest, paramHttpContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/ApacheHttpClientInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */