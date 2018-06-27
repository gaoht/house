package okhttp3.internal.connection;

import d.c;
import d.d;
import d.e;
import d.t;
import d.u;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection.Builder;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;

public final class RealConnection
  extends Http2Connection.Listener
  implements Connection
{
  private static final int MAX_TUNNEL_ATTEMPTS = 21;
  private static final String NPE_THROW_WITH_NULL = "throw with null exception";
  public int allocationLimit = 1;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  private final ConnectionPool connectionPool;
  private Handshake handshake;
  private Http2Connection http2Connection;
  public long idleAtNanos = Long.MAX_VALUE;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  private d sink;
  private Socket socket;
  private e source;
  public int successCount;
  
  public RealConnection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.connectionPool = paramConnectionPool;
    this.route = paramRoute;
  }
  
  /* Error */
  private void connectSocket(int paramInt1, int paramInt2, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   4: invokevirtual 76	okhttp3/Route:proxy	()Ljava/net/Proxy;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   13: invokevirtual 80	okhttp3/Route:address	()Lokhttp3/Address;
    //   16: astore 5
    //   18: aload 6
    //   20: invokevirtual 86	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   23: getstatic 92	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   26: if_acmpeq +14 -> 40
    //   29: aload 6
    //   31: invokevirtual 86	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 95	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +89 -> 126
    //   40: aload 5
    //   42: invokevirtual 101	okhttp3/Address:socketFactory	()Ljavax/net/SocketFactory;
    //   45: invokevirtual 107	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   48: astore 5
    //   50: aload_0
    //   51: aload 5
    //   53: putfield 109	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   56: aload 4
    //   58: aload_3
    //   59: aload_0
    //   60: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   63: invokevirtual 113	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   66: aload 6
    //   68: invokevirtual 119	okhttp3/EventListener:connectStart	(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   71: aload_0
    //   72: getfield 109	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   75: iload_2
    //   76: invokevirtual 125	java/net/Socket:setSoTimeout	(I)V
    //   79: invokestatic 131	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   82: aload_0
    //   83: getfield 109	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   86: aload_0
    //   87: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   90: invokevirtual 113	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   93: iload_1
    //   94: invokevirtual 134	okhttp3/internal/platform/Platform:connectSocket	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 109	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   102: invokestatic 139	d/l:source	(Ljava/net/Socket;)Ld/t;
    //   105: invokestatic 143	d/l:buffer	(Ld/t;)Ld/e;
    //   108: putfield 145	okhttp3/internal/connection/RealConnection:source	Ld/e;
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 109	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   116: invokestatic 148	d/l:sink	(Ljava/net/Socket;)Ld/s;
    //   119: invokestatic 151	d/l:buffer	(Ld/s;)Ld/d;
    //   122: putfield 153	okhttp3/internal/connection/RealConnection:sink	Ld/d;
    //   125: return
    //   126: new 121	java/net/Socket
    //   129: dup
    //   130: aload 6
    //   132: invokespecial 156	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   135: astore 5
    //   137: goto -87 -> 50
    //   140: astore_3
    //   141: new 68	java/net/ConnectException
    //   144: dup
    //   145: new 158	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   152: ldc -95
    //   154: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   161: invokevirtual 113	okhttp3/Route:socketAddress	()Ljava/net/InetSocketAddress;
    //   164: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 175	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   173: astore 4
    //   175: aload 4
    //   177: aload_3
    //   178: invokevirtual 179	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   181: pop
    //   182: aload 4
    //   184: athrow
    //   185: astore_3
    //   186: ldc 15
    //   188: aload_3
    //   189: invokevirtual 182	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 188	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq -70 -> 125
    //   198: new 66	java/io/IOException
    //   201: dup
    //   202: aload_3
    //   203: invokespecial 191	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	RealConnection
    //   0	207	1	paramInt1	int
    //   0	207	2	paramInt2	int
    //   0	207	3	paramCall	Call
    //   0	207	4	paramEventListener	EventListener
    //   16	120	5	localObject	Object
    //   7	124	6	localProxy	Proxy
    // Exception table:
    //   from	to	target	type
    //   79	97	140	java/net/ConnectException
    //   97	125	185	java/lang/NullPointerException
  }
  
  /* Error */
  private void connectTls(ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 61	okhttp3/internal/connection/RealConnection:route	Lokhttp3/Route;
    //   12: invokevirtual 80	okhttp3/Route:address	()Lokhttp3/Address;
    //   15: astore 6
    //   17: aload 6
    //   19: invokevirtual 200	okhttp3/Address:sslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: getfield 109	okhttp3/internal/connection/RealConnection:rawSocket	Ljava/net/Socket;
    //   28: aload 6
    //   30: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   33: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   36: aload 6
    //   38: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   41: invokevirtual 213	okhttp3/HttpUrl:port	()I
    //   44: iconst_1
    //   45: invokevirtual 218	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   48: checkcast 220	javax/net/ssl/SSLSocket
    //   51: astore_3
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 226	okhttp3/internal/connection/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 232	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   64: ifeq +23 -> 87
    //   67: invokestatic 131	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   70: aload_3
    //   71: aload 6
    //   73: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   76: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   79: aload 6
    //   81: invokevirtual 236	okhttp3/Address:protocols	()Ljava/util/List;
    //   84: invokevirtual 240	okhttp3/internal/platform/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   87: aload_3
    //   88: invokevirtual 243	javax/net/ssl/SSLSocket:startHandshake	()V
    //   91: aload_3
    //   92: invokevirtual 247	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   95: astore_1
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 251	okhttp3/internal/connection/RealConnection:isValid	(Ljavax/net/ssl/SSLSession;)Z
    //   101: ifne +56 -> 157
    //   104: new 66	java/io/IOException
    //   107: dup
    //   108: ldc -3
    //   110: invokespecial 254	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   113: athrow
    //   114: astore_2
    //   115: aload_3
    //   116: astore_1
    //   117: aload_2
    //   118: astore_3
    //   119: aload_1
    //   120: astore_2
    //   121: aload_3
    //   122: invokestatic 260	okhttp3/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   125: ifeq +262 -> 387
    //   128: aload_1
    //   129: astore_2
    //   130: new 66	java/io/IOException
    //   133: dup
    //   134: aload_3
    //   135: invokespecial 191	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   138: athrow
    //   139: astore_1
    //   140: aload_2
    //   141: ifnull +10 -> 151
    //   144: invokestatic 131	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   147: aload_2
    //   148: invokevirtual 264	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   151: aload_2
    //   152: invokestatic 268	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   155: aload_1
    //   156: athrow
    //   157: aload_1
    //   158: invokestatic 273	okhttp3/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;
    //   161: astore_2
    //   162: aload 6
    //   164: invokevirtual 277	okhttp3/Address:hostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   167: aload 6
    //   169: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   172: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   175: aload_1
    //   176: invokeinterface 283 3 0
    //   181: ifne +96 -> 277
    //   184: aload_2
    //   185: invokevirtual 286	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   188: iconst_0
    //   189: invokeinterface 291 2 0
    //   194: checkcast 293	java/security/cert/X509Certificate
    //   197: astore_1
    //   198: new 295	javax/net/ssl/SSLPeerUnverifiedException
    //   201: dup
    //   202: new 158	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 297
    //   212: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   220: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   223: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc_w 299
    //   229: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokestatic 305	okhttp3/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   236: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 307
    //   242: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_1
    //   246: invokevirtual 311	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   249: invokeinterface 316 1 0
    //   254: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 318
    //   260: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_1
    //   264: invokestatic 324	okhttp3/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   267: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokespecial 325	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   276: athrow
    //   277: aload 6
    //   279: invokevirtual 329	okhttp3/Address:certificatePinner	()Lokhttp3/CertificatePinner;
    //   282: aload 6
    //   284: invokevirtual 204	okhttp3/Address:url	()Lokhttp3/HttpUrl;
    //   287: invokevirtual 209	okhttp3/HttpUrl:host	()Ljava/lang/String;
    //   290: aload_2
    //   291: invokevirtual 286	okhttp3/Handshake:peerCertificates	()Ljava/util/List;
    //   294: invokevirtual 333	okhttp3/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   297: aload 4
    //   299: astore_1
    //   300: aload 5
    //   302: invokevirtual 232	okhttp3/ConnectionSpec:supportsTlsExtensions	()Z
    //   305: ifeq +11 -> 316
    //   308: invokestatic 131	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   311: aload_3
    //   312: invokevirtual 337	okhttp3/internal/platform/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   315: astore_1
    //   316: aload_0
    //   317: aload_3
    //   318: putfield 339	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 339	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   326: invokestatic 139	d/l:source	(Ljava/net/Socket;)Ld/t;
    //   329: invokestatic 143	d/l:buffer	(Ld/t;)Ld/e;
    //   332: putfield 145	okhttp3/internal/connection/RealConnection:source	Ld/e;
    //   335: aload_0
    //   336: aload_0
    //   337: getfield 339	okhttp3/internal/connection/RealConnection:socket	Ljava/net/Socket;
    //   340: invokestatic 148	d/l:sink	(Ljava/net/Socket;)Ld/s;
    //   343: invokestatic 151	d/l:buffer	(Ld/s;)Ld/d;
    //   346: putfield 153	okhttp3/internal/connection/RealConnection:sink	Ld/d;
    //   349: aload_0
    //   350: aload_2
    //   351: putfield 341	okhttp3/internal/connection/RealConnection:handshake	Lokhttp3/Handshake;
    //   354: aload_1
    //   355: ifnull +25 -> 380
    //   358: aload_1
    //   359: invokestatic 346	okhttp3/Protocol:get	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   362: astore_1
    //   363: aload_0
    //   364: aload_1
    //   365: putfield 348	okhttp3/internal/connection/RealConnection:protocol	Lokhttp3/Protocol;
    //   368: aload_3
    //   369: ifnull +10 -> 379
    //   372: invokestatic 131	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   375: aload_3
    //   376: invokevirtual 264	okhttp3/internal/platform/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   379: return
    //   380: getstatic 351	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   383: astore_1
    //   384: goto -21 -> 363
    //   387: aload_1
    //   388: astore_2
    //   389: aload_3
    //   390: athrow
    //   391: astore_3
    //   392: aload 5
    //   394: astore_1
    //   395: goto -276 -> 119
    //   398: astore_1
    //   399: aload_3
    //   400: astore_2
    //   401: goto -261 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	RealConnection
    //   0	404	1	paramConnectionSpecSelector	ConnectionSpecSelector
    //   1	1	2	localObject1	Object
    //   114	4	2	localAssertionError1	AssertionError
    //   120	281	2	localObject2	Object
    //   22	368	3	localObject3	Object
    //   391	9	3	localAssertionError2	AssertionError
    //   3	295	4	localObject4	Object
    //   6	387	5	localConnectionSpec	ConnectionSpec
    //   15	268	6	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   52	87	114	java/lang/AssertionError
    //   87	114	114	java/lang/AssertionError
    //   157	277	114	java/lang/AssertionError
    //   277	297	114	java/lang/AssertionError
    //   300	316	114	java/lang/AssertionError
    //   316	354	114	java/lang/AssertionError
    //   358	363	114	java/lang/AssertionError
    //   363	368	114	java/lang/AssertionError
    //   380	384	114	java/lang/AssertionError
    //   23	52	139	finally
    //   121	128	139	finally
    //   130	139	139	finally
    //   389	391	139	finally
    //   23	52	391	java/lang/AssertionError
    //   52	87	398	finally
    //   87	114	398	finally
    //   157	277	398	finally
    //   277	297	398	finally
    //   300	316	398	finally
    //   316	354	398	finally
    //   358	363	398	finally
    //   363	368	398	finally
    //   380	384	398	finally
  }
  
  private void connectTunnel(int paramInt1, int paramInt2, int paramInt3, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    Request localRequest = createTunnelRequest();
    HttpUrl localHttpUrl = localRequest.url();
    int i = 0;
    for (;;)
    {
      if (i < 21)
      {
        connectSocket(paramInt1, paramInt2, paramCall, paramEventListener);
        localRequest = createTunnel(paramInt2, paramInt3, localRequest, localHttpUrl);
        if (localRequest != null) {}
      }
      else
      {
        return;
      }
      Util.closeQuietly(this.rawSocket);
      this.rawSocket = null;
      this.sink = null;
      this.source = null;
      paramEventListener.connectEnd(paramCall, this.route.socketAddress(), this.route.proxy(), null);
      i += 1;
    }
  }
  
  private Request createTunnel(int paramInt1, int paramInt2, Request paramRequest, HttpUrl paramHttpUrl)
    throws IOException
  {
    String str = "CONNECT " + Util.hostHeader(paramHttpUrl, true) + " HTTP/1.1";
    Response localResponse;
    do
    {
      paramHttpUrl = new Http1Codec(null, null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      paramHttpUrl.writeRequest(paramRequest.headers(), str);
      paramHttpUrl.finishRequest();
      localResponse = paramHttpUrl.readResponseHeaders(false).request(paramRequest).build();
      long l2 = HttpHeaders.contentLength(localResponse);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramRequest = paramHttpUrl.newFixedLengthSource(l1);
      Util.skipAll(paramRequest, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
      paramRequest.close();
      switch (localResponse.code())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + localResponse.code());
      case 200: 
        if ((!this.source.buffer().exhausted()) || (!this.sink.buffer().exhausted())) {
          throw new IOException("TLS tunnel buffered too many bytes!");
        }
        return null;
      }
      paramHttpUrl = this.route.address().proxyAuthenticator().authenticate(this.route, localResponse);
      if (paramHttpUrl == null) {
        throw new IOException("Failed to authenticate with proxy");
      }
      paramRequest = paramHttpUrl;
    } while (!"close".equalsIgnoreCase(localResponse.header("Connection")));
    return paramHttpUrl;
  }
  
  private Request createTunnelRequest()
  {
    return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }
  
  private void establishProtocol(ConnectionSpecSelector paramConnectionSpecSelector, int paramInt, Call paramCall, EventListener paramEventListener)
    throws IOException
  {
    if (this.route.address().sslSocketFactory() == null)
    {
      this.protocol = Protocol.HTTP_1_1;
      this.socket = this.rawSocket;
    }
    do
    {
      return;
      paramEventListener.secureConnectStart(paramCall);
      connectTls(paramConnectionSpecSelector);
      paramEventListener.secureConnectEnd(paramCall, this.handshake);
    } while (this.protocol != Protocol.HTTP_2);
    this.socket.setSoTimeout(0);
    this.http2Connection = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(paramInt).build();
    this.http2Connection.start();
  }
  
  private boolean isValid(SSLSession paramSSLSession)
  {
    return (!"NONE".equals(paramSSLSession.getProtocol())) && (!"SSL_NULL_WITH_NULL_NULL".equals(paramSSLSession.getCipherSuite()));
  }
  
  public static RealConnection testConnection(ConnectionPool paramConnectionPool, Route paramRoute, Socket paramSocket, long paramLong)
  {
    paramConnectionPool = new RealConnection(paramConnectionPool, paramRoute);
    paramConnectionPool.socket = paramSocket;
    paramConnectionPool.idleAtNanos = paramLong;
    return paramConnectionPool;
  }
  
  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Call arg6, EventListener paramEventListener)
  {
    if (this.protocol != null) {
      throw new IllegalStateException("already connected");
    }
    Object localObject = this.route.address().connectionSpecs();
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector((List)localObject);
    if (this.route.address().sslSocketFactory() == null)
    {
      if (!((List)localObject).contains(ConnectionSpec.CLEARTEXT)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
      }
      localObject = this.route.address().url().host();
      if (!Platform.get().isCleartextTrafficPermitted((String)localObject)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + (String)localObject + " not permitted by network security policy"));
      }
    }
    for (;;)
    {
      try
      {
        if (this.route.requiresTunnel())
        {
          connectTunnel(paramInt1, paramInt2, paramInt3, ???, paramEventListener);
          Socket localSocket = this.rawSocket;
          if (localSocket == null)
          {
            if ((!this.route.requiresTunnel()) || (this.rawSocket != null)) {
              break label389;
            }
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
          }
        }
        else
        {
          connectSocket(paramInt1, paramInt2, ???, paramEventListener);
        }
        establishProtocol(localConnectionSpecSelector, paramInt4, ???, paramEventListener);
        paramEventListener.connectEnd(???, this.route.socketAddress(), this.route.proxy(), this.protocol);
        continue;
      }
      catch (IOException localIOException)
      {
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        this.http2Connection = null;
        paramEventListener.connectFailed(???, this.route.socketAddress(), this.route.proxy(), null, localIOException);
        if (localObject == null)
        {
          localObject = new RouteException(localIOException);
          if ((paramBoolean) && (localConnectionSpecSelector.connectionFailed(localIOException))) {
            continue;
          }
          throw ((Throwable)localObject);
        }
        ((RouteException)localObject).addConnectException(localIOException);
        continue;
      }
      label389:
      if (this.http2Connection == null) {
        break;
      }
      synchronized (this.connectionPool)
      {
        this.allocationLimit = this.http2Connection.maxConcurrentStreams();
        return;
      }
      localObject = null;
    }
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  public boolean isEligible(Address paramAddress, @Nullable Route paramRoute)
  {
    if ((this.allocations.size() >= this.allocationLimit) || (this.noNewStreams)) {}
    do
    {
      do
      {
        return false;
      } while (!Internal.instance.equalsNonHost(this.route.address(), paramAddress));
      if (paramAddress.url().host().equals(route().address().url().host())) {
        return true;
      }
    } while ((this.http2Connection == null) || (paramRoute == null) || (paramRoute.proxy().type() != Proxy.Type.DIRECT) || (this.route.proxy().type() != Proxy.Type.DIRECT) || (!this.route.socketAddress().equals(paramRoute.socketAddress())) || (paramRoute.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE) || (!supportsUrl(paramAddress.url())));
    try
    {
      paramAddress.certificatePinner().check(paramAddress.url().host(), handshake().peerCertificates());
      return true;
    }
    catch (SSLPeerUnverifiedException paramAddress) {}
    return false;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.socket.isClosed()) || (this.socket.isInputShutdown()) || (this.socket.isOutputShutdown())) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (this.http2Connection == null) {
          break;
        }
      } while (!this.http2Connection.isShutdown());
      return false;
    } while (!paramBoolean);
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        paramBoolean = this.source.exhausted();
        return !paramBoolean;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public boolean isMultiplexed()
  {
    return this.http2Connection != null;
  }
  
  public HttpCodec newCodec(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, StreamAllocation paramStreamAllocation)
    throws SocketException
  {
    if (this.http2Connection != null) {
      return new Http2Codec(paramOkHttpClient, paramChain, paramStreamAllocation, this.http2Connection);
    }
    this.socket.setSoTimeout(paramChain.readTimeoutMillis());
    this.source.timeout().timeout(paramChain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
    this.sink.timeout().timeout(paramChain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    return new Http1Codec(paramOkHttpClient, paramStreamAllocation, this.source, this.sink);
  }
  
  public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation paramStreamAllocation)
  {
    new RealWebSocket.Streams(true, this.source, this.sink)
    {
      public void close()
        throws IOException
      {
        paramStreamAllocation.streamFinished(true, paramStreamAllocation.codec(), -1L, null);
      }
    };
  }
  
  public void onSettings(Http2Connection paramHttp2Connection)
  {
    synchronized (this.connectionPool)
    {
      this.allocationLimit = paramHttp2Connection.maxConcurrentStreams();
      return;
    }
  }
  
  public void onStream(Http2Stream paramHttp2Stream)
    throws IOException
  {
    paramHttp2Stream.close(ErrorCode.REFUSED_STREAM);
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public Route route()
  {
    return this.route;
  }
  
  public Socket socket()
  {
    return this.socket;
  }
  
  public boolean supportsUrl(HttpUrl paramHttpUrl)
  {
    if (paramHttpUrl.port() != this.route.address().url().port()) {
      return false;
    }
    if (!paramHttpUrl.host().equals(this.route.address().url().host()))
    {
      if ((this.handshake != null) && (OkHostnameVerifier.INSTANCE.verify(paramHttpUrl.host(), (X509Certificate)this.handshake.peerCertificates().get(0)))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
    if (this.handshake != null) {}
    for (Object localObject = this.handshake.cipherSuite();; localObject = "none") {
      return localObject + " protocol=" + this.protocol + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/connection/RealConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */