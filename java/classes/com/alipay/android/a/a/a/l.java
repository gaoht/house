package com.alipay.android.a.a.a;

import android.net.SSLCertificateSocketFactory;
import android.util.Log;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

@Instrumented
public final class l
  implements HttpClient
{
  public static long a = 160L;
  private static String[] d = { "text/", "application/xml", "application/json" };
  private static final HttpRequestInterceptor e = new m();
  final HttpClient b;
  RuntimeException c = new IllegalStateException("AndroidHttpClient created and never closed");
  private volatile b f;
  
  private l(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    this.b = new n(this, paramClientConnectionManager, paramHttpParams);
  }
  
  public static l a(String paramString)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpClientParams.setRedirecting(localBasicHttpParams, true);
    HttpClientParams.setAuthenticating(localBasicHttpParams, false);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, paramString);
    paramString = new SchemeRegistry();
    paramString.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    paramString.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(30000, null), 443));
    paramString = new ThreadSafeClientConnManager(localBasicHttpParams, paramString);
    ConnManagerParams.setTimeout(localBasicHttpParams, 60000L);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(10));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 50);
    Security.setProperty("networkaddress.cache.ttl", "-1");
    HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    return new l(paramString, localBasicHttpParams);
  }
  
  public static InputStream a(HttpEntity paramHttpEntity)
  {
    InputStream localInputStream = paramHttpEntity.getContent();
    if (localInputStream == null) {}
    do
    {
      do
      {
        return localInputStream;
        paramHttpEntity = paramHttpEntity.getContentEncoding();
      } while (paramHttpEntity == null);
      paramHttpEntity = paramHttpEntity.getValue();
    } while (paramHttpEntity == null);
    if (paramHttpEntity.contains("gzip")) {}
    for (paramHttpEntity = new GZIPInputStream(localInputStream);; paramHttpEntity = localInputStream) {
      return paramHttpEntity;
    }
  }
  
  public static AbstractHttpEntity a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < a) {
      return new ByteArrayEntity(paramArrayOfByte);
    }
    Object localObject = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream((OutputStream)localObject);
    localGZIPOutputStream.write(paramArrayOfByte);
    localGZIPOutputStream.close();
    localObject = new ByteArrayEntity(((ByteArrayOutputStream)localObject).toByteArray());
    ((AbstractHttpEntity)localObject).setContentEncoding("gzip");
    new StringBuilder("gzip size:").append(paramArrayOfByte.length).append("->").append(((AbstractHttpEntity)localObject).getContentLength());
    return (AbstractHttpEntity)localObject;
  }
  
  public static void a(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.addHeader("Accept-Encoding", "gzip");
  }
  
  public static long b(String paramString)
  {
    return u.a(paramString);
  }
  
  public static void b(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.addHeader("Connection", "Keep-Alive");
  }
  
  private static boolean b(HttpUriRequest paramHttpUriRequest)
  {
    Header[] arrayOfHeader = paramHttpUriRequest.getHeaders("content-encoding");
    int j;
    int i;
    if (arrayOfHeader != null)
    {
      j = arrayOfHeader.length;
      i = 0;
      if (i < j) {
        if (!"gzip".equalsIgnoreCase(arrayOfHeader[i].getValue())) {}
      }
    }
    for (;;)
    {
      return true;
      i += 1;
      break;
      paramHttpUriRequest = paramHttpUriRequest.getHeaders("content-type");
      if (paramHttpUriRequest != null)
      {
        int k = paramHttpUriRequest.length;
        i = 0;
        while (i < k)
        {
          arrayOfHeader = paramHttpUriRequest[i];
          String[] arrayOfString = d;
          int m = arrayOfString.length;
          j = 0;
          while (j < m)
          {
            String str = arrayOfString[j];
            if (arrayOfHeader.getValue().startsWith(str)) {
              return false;
            }
            j += 1;
          }
          i += 1;
        }
      }
    }
  }
  
  public final <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return (T)localHttpClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
    }
    return (T)ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public final <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return (T)localHttpClient.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
    }
    return (T)ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public final <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return (T)localHttpClient.execute(paramHttpUriRequest, paramResponseHandler);
    }
    return (T)ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpUriRequest, paramResponseHandler);
  }
  
  public final <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return (T)localHttpClient.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
    }
    return (T)ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return localHttpClient.execute(paramHttpHost, paramHttpRequest);
    }
    return ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpHost, paramHttpRequest);
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return localHttpClient.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
    }
    return ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return localHttpClient.execute(paramHttpUriRequest);
    }
    return ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpUriRequest);
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    HttpClient localHttpClient = this.b;
    if (!(localHttpClient instanceof HttpClient)) {
      return localHttpClient.execute(paramHttpUriRequest, paramHttpContext);
    }
    return ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramHttpUriRequest, paramHttpContext);
  }
  
  public final ClientConnectionManager getConnectionManager()
  {
    return this.b.getConnectionManager();
  }
  
  public final HttpParams getParams()
  {
    return this.b.getParams();
  }
  
  private final class a
    implements HttpRequestInterceptor
  {
    private a() {}
    
    public final void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    {
      paramHttpContext = l.a(l.this);
      if ((paramHttpContext != null) && (Log.isLoggable(paramHttpContext.a, paramHttpContext.b)) && ((paramHttpRequest instanceof HttpUriRequest)))
      {
        paramHttpRequest = l.a((HttpUriRequest)paramHttpRequest);
        Log.println(paramHttpContext.b, paramHttpContext.a, paramHttpRequest);
      }
    }
  }
  
  private static final class b
  {
    final String a;
    final int b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */