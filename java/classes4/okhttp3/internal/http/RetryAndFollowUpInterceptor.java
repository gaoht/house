package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.StreamAllocation;

public final class RetryAndFollowUpInterceptor
  implements Interceptor
{
  private static final int MAX_FOLLOW_UPS = 20;
  private Object callStackTrace;
  private volatile boolean canceled;
  private final OkHttpClient client;
  private final boolean forWebSocket;
  private volatile StreamAllocation streamAllocation;
  
  public RetryAndFollowUpInterceptor(OkHttpClient paramOkHttpClient, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.forWebSocket = paramBoolean;
  }
  
  private Address createAddress(HttpUrl paramHttpUrl)
  {
    CertificatePinner localCertificatePinner = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramHttpUrl.isHttps())
    {
      localSSLSocketFactory = this.client.sslSocketFactory();
      localHostnameVerifier = this.client.hostnameVerifier();
      localCertificatePinner = this.client.certificatePinner();
    }
    for (;;)
    {
      return new Address(paramHttpUrl.host(), paramHttpUrl.port(), this.client.dns(), this.client.socketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private Request followUpRequest(Response paramResponse, Route paramRoute)
    throws IOException
  {
    Proxy localProxy = null;
    if (paramResponse == null) {
      throw new IllegalStateException();
    }
    int i = paramResponse.code();
    String str = paramResponse.request().method();
    switch (i)
    {
    }
    label384:
    do
    {
      do
      {
        HttpUrl localHttpUrl;
        do
        {
          do
          {
            do
            {
              return null;
              if (paramRoute != null) {}
              for (localProxy = paramRoute.proxy(); localProxy.type() != Proxy.Type.HTTP; localProxy = this.client.proxy()) {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
              }
              return this.client.proxyAuthenticator().authenticate(paramRoute, paramResponse);
              return this.client.authenticator().authenticate(paramRoute, paramResponse);
            } while (((!str.equals("GET")) && (!str.equals("HEAD"))) || (!this.client.followRedirects()));
            paramRoute = paramResponse.header("Location");
          } while (paramRoute == null);
          localHttpUrl = paramResponse.request().url().resolve(paramRoute);
        } while ((localHttpUrl == null) || ((!localHttpUrl.scheme().equals(paramResponse.request().url().scheme())) && (!this.client.followSslRedirects())));
        Request.Builder localBuilder = paramResponse.request().newBuilder();
        boolean bool;
        if (HttpMethod.permitsRequestBody(str))
        {
          bool = HttpMethod.redirectsWithBody(str);
          if (!HttpMethod.redirectsToGet(str)) {
            break label384;
          }
          localBuilder.method("GET", null);
        }
        for (;;)
        {
          if (!bool)
          {
            localBuilder.removeHeader("Transfer-Encoding");
            localBuilder.removeHeader("Content-Length");
            localBuilder.removeHeader("Content-Type");
          }
          if (!sameConnection(paramResponse, localHttpUrl)) {
            localBuilder.removeHeader("Authorization");
          }
          return localBuilder.url(localHttpUrl).build();
          paramRoute = localProxy;
          if (bool) {
            paramRoute = paramResponse.request().body();
          }
          localBuilder.method(str, paramRoute);
        }
      } while ((!this.client.retryOnConnectionFailure()) || ((paramResponse.request().body() instanceof UnrepeatableRequestBody)) || ((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 408)) || (retryAfter(paramResponse, 0) > 0));
      return paramResponse.request();
    } while (((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 503)) || (retryAfter(paramResponse, Integer.MAX_VALUE) != 0));
    return paramResponse.request();
  }
  
  private boolean isRecoverable(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramIOException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramIOException instanceof InterruptedIOException))
      {
        if (((paramIOException instanceof SocketTimeoutException)) && (!paramBoolean)) {}
        for (paramBoolean = bool;; paramBoolean = false) {
          return paramBoolean;
        }
      }
    } while ((((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private boolean recover(IOException paramIOException, StreamAllocation paramStreamAllocation, boolean paramBoolean, Request paramRequest)
  {
    paramStreamAllocation.streamFailed(paramIOException);
    if (!this.client.retryOnConnectionFailure()) {}
    while (((paramBoolean) && ((paramRequest.body() instanceof UnrepeatableRequestBody))) || (!isRecoverable(paramIOException, paramBoolean)) || (!paramStreamAllocation.hasMoreRoutes())) {
      return false;
    }
    return true;
  }
  
  private int retryAfter(Response paramResponse, int paramInt)
  {
    paramResponse = paramResponse.header("Retry-After");
    if (paramResponse == null) {
      return paramInt;
    }
    if (paramResponse.matches("\\d+")) {
      return Integer.valueOf(paramResponse).intValue();
    }
    return Integer.MAX_VALUE;
  }
  
  private boolean sameConnection(Response paramResponse, HttpUrl paramHttpUrl)
  {
    paramResponse = paramResponse.request().url();
    return (paramResponse.host().equals(paramHttpUrl.host())) && (paramResponse.port() == paramHttpUrl.port()) && (paramResponse.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void cancel()
  {
    this.canceled = true;
    StreamAllocation localStreamAllocation = this.streamAllocation;
    if (localStreamAllocation != null) {
      localStreamAllocation.cancel();
    }
  }
  
  /* Error */
  public Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 296 1 0
    //   6: astore 4
    //   8: aload_1
    //   9: checkcast 298	okhttp3/internal/http/RealInterceptorChain
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 302	okhttp3/internal/http/RealInterceptorChain:call	()Lokhttp3/Call;
    //   19: astore 8
    //   21: aload 7
    //   23: invokevirtual 306	okhttp3/internal/http/RealInterceptorChain:eventListener	()Lokhttp3/EventListener;
    //   26: astore 9
    //   28: new 257	okhttp3/internal/connection/StreamAllocation
    //   31: dup
    //   32: aload_0
    //   33: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   36: invokevirtual 310	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   39: aload_0
    //   40: aload 4
    //   42: invokevirtual 165	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   45: invokespecial 312	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   48: aload 8
    //   50: aload 9
    //   52: aload_0
    //   53: getfield 314	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   56: invokespecial 317	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 287	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   65: iconst_0
    //   66: istore_2
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 285	okhttp3/internal/http/RetryAndFollowUpInterceptor:canceled	Z
    //   74: ifeq +18 -> 92
    //   77: aload_1
    //   78: invokevirtual 320	okhttp3/internal/connection/StreamAllocation:release	()V
    //   81: new 94	java/io/IOException
    //   84: dup
    //   85: ldc_w 322
    //   88: invokespecial 323	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    //   92: aload 7
    //   94: aload 4
    //   96: aload_1
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 327	okhttp3/internal/http/RealInterceptorChain:proceed	(Lokhttp3/Request;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/http/HttpCodec;Lokhttp3/internal/connection/RealConnection;)Lokhttp3/Response;
    //   102: astore 6
    //   104: aload 6
    //   106: astore 4
    //   108: aload 5
    //   110: ifnull +28 -> 138
    //   113: aload 6
    //   115: invokevirtual 330	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   118: aload 5
    //   120: invokevirtual 330	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   123: aconst_null
    //   124: invokevirtual 335	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   127: invokevirtual 337	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   130: invokevirtual 340	okhttp3/Response$Builder:priorResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   133: invokevirtual 337	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   136: astore 4
    //   138: aload_0
    //   139: aload 4
    //   141: aload_1
    //   142: invokevirtual 344	okhttp3/internal/connection/StreamAllocation:route	()Lokhttp3/Route;
    //   145: invokespecial 346	okhttp3/internal/http/RetryAndFollowUpInterceptor:followUpRequest	(Lokhttp3/Response;Lokhttp3/Route;)Lokhttp3/Request;
    //   148: astore 6
    //   150: aload 6
    //   152: ifnonnull +88 -> 240
    //   155: aload_0
    //   156: getfield 27	okhttp3/internal/http/RetryAndFollowUpInterceptor:forWebSocket	Z
    //   159: ifne +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 320	okhttp3/internal/connection/StreamAllocation:release	()V
    //   166: aload 4
    //   168: areturn
    //   169: astore 6
    //   171: aload_0
    //   172: aload 6
    //   174: invokevirtual 350	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   177: aload_1
    //   178: iconst_0
    //   179: aload 4
    //   181: invokespecial 352	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   184: ifne -114 -> 70
    //   187: aload 6
    //   189: invokevirtual 350	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   192: athrow
    //   193: astore 4
    //   195: aload_1
    //   196: aconst_null
    //   197: invokevirtual 261	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   200: aload_1
    //   201: invokevirtual 320	okhttp3/internal/connection/StreamAllocation:release	()V
    //   204: aload 4
    //   206: athrow
    //   207: astore 6
    //   209: aload 6
    //   211: instanceof 354
    //   214: ifne +21 -> 235
    //   217: iconst_1
    //   218: istore_3
    //   219: aload_0
    //   220: aload 6
    //   222: aload_1
    //   223: iload_3
    //   224: aload 4
    //   226: invokespecial 352	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   229: ifne -159 -> 70
    //   232: aload 6
    //   234: athrow
    //   235: iconst_0
    //   236: istore_3
    //   237: goto -18 -> 219
    //   240: aload 4
    //   242: invokevirtual 357	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   245: invokestatic 363	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   248: iload_2
    //   249: iconst_1
    //   250: iadd
    //   251: istore_2
    //   252: iload_2
    //   253: bipush 20
    //   255: if_icmple +35 -> 290
    //   258: aload_1
    //   259: invokevirtual 320	okhttp3/internal/connection/StreamAllocation:release	()V
    //   262: new 128	java/net/ProtocolException
    //   265: dup
    //   266: new 365	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 368
    //   276: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: iload_2
    //   280: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 133	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   289: athrow
    //   290: aload 6
    //   292: invokevirtual 222	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   295: instanceof 227
    //   298: ifeq +23 -> 321
    //   301: aload_1
    //   302: invokevirtual 320	okhttp3/internal/connection/StreamAllocation:release	()V
    //   305: new 380	java/net/HttpRetryException
    //   308: dup
    //   309: ldc_w 382
    //   312: aload 4
    //   314: invokevirtual 102	okhttp3/Response:code	()I
    //   317: invokespecial 385	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   320: athrow
    //   321: aload_0
    //   322: aload 4
    //   324: aload 6
    //   326: invokevirtual 165	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   329: invokespecial 210	okhttp3/internal/http/RetryAndFollowUpInterceptor:sameConnection	(Lokhttp3/Response;Lokhttp3/HttpUrl;)Z
    //   332: ifne +55 -> 387
    //   335: aload_1
    //   336: invokevirtual 320	okhttp3/internal/connection/StreamAllocation:release	()V
    //   339: new 257	okhttp3/internal/connection/StreamAllocation
    //   342: dup
    //   343: aload_0
    //   344: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   347: invokevirtual 310	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   350: aload_0
    //   351: aload 6
    //   353: invokevirtual 165	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   356: invokespecial 312	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   359: aload 8
    //   361: aload 9
    //   363: aload_0
    //   364: getfield 314	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   367: invokespecial 317	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   370: astore_1
    //   371: aload_0
    //   372: aload_1
    //   373: putfield 287	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   376: aload 4
    //   378: astore 5
    //   380: aload 6
    //   382: astore 4
    //   384: goto -314 -> 70
    //   387: aload_1
    //   388: invokevirtual 389	okhttp3/internal/connection/StreamAllocation:codec	()Lokhttp3/internal/http/HttpCodec;
    //   391: ifnull +38 -> 429
    //   394: new 96	java/lang/IllegalStateException
    //   397: dup
    //   398: new 365	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   405: ldc_w 391
    //   408: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 4
    //   413: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   416: ldc_w 396
    //   419: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokespecial 397	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   428: athrow
    //   429: goto -53 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	RetryAndFollowUpInterceptor
    //   0	432	1	paramChain	okhttp3.Interceptor.Chain
    //   66	214	2	i	int
    //   218	19	3	bool	boolean
    //   6	174	4	localObject1	Object
    //   193	184	4	localRequest1	Request
    //   382	30	4	localObject2	Object
    //   68	311	5	localRequest2	Request
    //   102	49	6	localObject3	Object
    //   169	19	6	localRouteException	okhttp3.internal.connection.RouteException
    //   207	174	6	localIOException	IOException
    //   12	81	7	localRealInterceptorChain	RealInterceptorChain
    //   19	341	8	localCall	okhttp3.Call
    //   26	336	9	localEventListener	okhttp3.EventListener
    // Exception table:
    //   from	to	target	type
    //   92	104	169	okhttp3/internal/connection/RouteException
    //   92	104	193	finally
    //   171	193	193	finally
    //   209	217	193	finally
    //   219	235	193	finally
    //   92	104	207	java/io/IOException
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  public void setCallStackTrace(Object paramObject)
  {
    this.callStackTrace = paramObject;
  }
  
  public StreamAllocation streamAllocation()
  {
    return this.streamAllocation;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/http/RetryAndFollowUpInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */