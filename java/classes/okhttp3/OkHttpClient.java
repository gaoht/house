package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

public class OkHttpClient
  implements Cloneable, Call.Factory, WebSocket.Factory
{
  static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });
  final Authenticator authenticator;
  @Nullable
  final Cache cache;
  @Nullable
  final CertificateChainCleaner certificateChainCleaner;
  final CertificatePinner certificatePinner;
  final int connectTimeout;
  final ConnectionPool connectionPool;
  final List<ConnectionSpec> connectionSpecs;
  final CookieJar cookieJar;
  final Dispatcher dispatcher;
  final Dns dns;
  final EventListener.Factory eventListenerFactory;
  final boolean followRedirects;
  final boolean followSslRedirects;
  final HostnameVerifier hostnameVerifier;
  final List<Interceptor> interceptors;
  @Nullable
  final InternalCache internalCache;
  final List<Interceptor> networkInterceptors;
  final int pingInterval;
  final List<Protocol> protocols;
  @Nullable
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final int readTimeout;
  final boolean retryOnConnectionFailure;
  final SocketFactory socketFactory;
  @Nullable
  final SSLSocketFactory sslSocketFactory;
  final int writeTimeout;
  
  static
  {
    DEFAULT_CONNECTION_SPECS = Util.immutableList(new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT });
    okhttp3.internal.Internal.instance = new OkHttpClient.1();
  }
  
  public OkHttpClient()
  {
    this(new Builder());
  }
  
  OkHttpClient(Builder paramBuilder)
  {
    this.dispatcher = paramBuilder.dispatcher;
    this.proxy = paramBuilder.proxy;
    this.protocols = paramBuilder.protocols;
    this.connectionSpecs = paramBuilder.connectionSpecs;
    this.interceptors = Util.immutableList(paramBuilder.interceptors);
    this.networkInterceptors = Util.immutableList(paramBuilder.networkInterceptors);
    this.eventListenerFactory = paramBuilder.eventListenerFactory;
    this.proxySelector = paramBuilder.proxySelector;
    this.cookieJar = paramBuilder.cookieJar;
    this.cache = paramBuilder.cache;
    this.internalCache = paramBuilder.internalCache;
    this.socketFactory = paramBuilder.socketFactory;
    Object localObject = this.connectionSpecs.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      ConnectionSpec localConnectionSpec = (ConnectionSpec)((Iterator)localObject).next();
      if ((i != 0) || (localConnectionSpec.isTls())) {}
      for (i = 1;; i = 0) {
        break;
      }
    }
    if ((paramBuilder.sslSocketFactory != null) || (i == 0)) {
      this.sslSocketFactory = paramBuilder.sslSocketFactory;
    }
    for (this.certificateChainCleaner = paramBuilder.certificateChainCleaner;; this.certificateChainCleaner = CertificateChainCleaner.get((X509TrustManager)localObject))
    {
      this.hostnameVerifier = paramBuilder.hostnameVerifier;
      this.certificatePinner = paramBuilder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
      this.proxyAuthenticator = paramBuilder.proxyAuthenticator;
      this.authenticator = paramBuilder.authenticator;
      this.connectionPool = paramBuilder.connectionPool;
      this.dns = paramBuilder.dns;
      this.followSslRedirects = paramBuilder.followSslRedirects;
      this.followRedirects = paramBuilder.followRedirects;
      this.retryOnConnectionFailure = paramBuilder.retryOnConnectionFailure;
      this.connectTimeout = paramBuilder.connectTimeout;
      this.readTimeout = paramBuilder.readTimeout;
      this.writeTimeout = paramBuilder.writeTimeout;
      this.pingInterval = paramBuilder.pingInterval;
      if (!this.interceptors.contains(null)) {
        break;
      }
      throw new IllegalStateException("Null interceptor: " + this.interceptors);
      localObject = systemDefaultTrustManager();
      this.sslSocketFactory = systemDefaultSslSocketFactory((X509TrustManager)localObject);
    }
    if (this.networkInterceptors.contains(null)) {
      throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
    }
  }
  
  private SSLSocketFactory systemDefaultSslSocketFactory(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = Platform.get().getSSLContext();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw Util.assertionError("No System TLS", paramX509TrustManager);
    }
  }
  
  private X509TrustManager systemDefaultTrustManager()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length != 1) || (!(localObject[0] instanceof X509TrustManager))) {
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString((Object[])localObject));
      }
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw Util.assertionError("No System TLS", localGeneralSecurityException);
    }
    X509TrustManager localX509TrustManager = (X509TrustManager)localGeneralSecurityException[0];
    return localX509TrustManager;
  }
  
  public Authenticator authenticator()
  {
    return this.authenticator;
  }
  
  public Cache cache()
  {
    return this.cache;
  }
  
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public int connectTimeoutMillis()
  {
    return this.connectTimeout;
  }
  
  public ConnectionPool connectionPool()
  {
    return this.connectionPool;
  }
  
  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public CookieJar cookieJar()
  {
    return this.cookieJar;
  }
  
  public Dispatcher dispatcher()
  {
    return this.dispatcher;
  }
  
  public Dns dns()
  {
    return this.dns;
  }
  
  public EventListener.Factory eventListenerFactory()
  {
    return this.eventListenerFactory;
  }
  
  public boolean followRedirects()
  {
    return this.followRedirects;
  }
  
  public boolean followSslRedirects()
  {
    return this.followSslRedirects;
  }
  
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Interceptor> interceptors()
  {
    return this.interceptors;
  }
  
  InternalCache internalCache()
  {
    if (this.cache != null) {
      return this.cache.internalCache;
    }
    return this.internalCache;
  }
  
  public List<Interceptor> networkInterceptors()
  {
    return this.networkInterceptors;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this);
  }
  
  public Call newCall(Request paramRequest)
  {
    return RealCall.newRealCall(this, paramRequest, false);
  }
  
  public WebSocket newWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener)
  {
    paramRequest = new RealWebSocket(paramRequest, paramWebSocketListener, new Random(), this.pingInterval);
    paramRequest.connect(this);
    return paramRequest;
  }
  
  public int pingIntervalMillis()
  {
    return this.pingInterval;
  }
  
  public List<Protocol> protocols()
  {
    return this.protocols;
  }
  
  public Proxy proxy()
  {
    return this.proxy;
  }
  
  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }
  
  public int readTimeoutMillis()
  {
    return this.readTimeout;
  }
  
  public boolean retryOnConnectionFailure()
  {
    return this.retryOnConnectionFailure;
  }
  
  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public int writeTimeoutMillis()
  {
    return this.writeTimeout;
  }
  
  public static final class Builder
  {
    Authenticator authenticator;
    @Nullable
    Cache cache;
    @Nullable
    CertificateChainCleaner certificateChainCleaner;
    CertificatePinner certificatePinner;
    int connectTimeout;
    ConnectionPool connectionPool;
    List<ConnectionSpec> connectionSpecs;
    CookieJar cookieJar;
    Dispatcher dispatcher;
    Dns dns;
    EventListener.Factory eventListenerFactory;
    boolean followRedirects;
    boolean followSslRedirects;
    HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors = new ArrayList();
    @Nullable
    InternalCache internalCache;
    final List<Interceptor> networkInterceptors = new ArrayList();
    int pingInterval;
    List<Protocol> protocols;
    @Nullable
    Proxy proxy;
    Authenticator proxyAuthenticator;
    ProxySelector proxySelector;
    int readTimeout;
    boolean retryOnConnectionFailure;
    SocketFactory socketFactory;
    @Nullable
    SSLSocketFactory sslSocketFactory;
    int writeTimeout;
    
    public Builder()
    {
      this.dispatcher = new Dispatcher();
      this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
      this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
      this.eventListenerFactory = EventListener.factory(EventListener.NONE);
      this.proxySelector = ProxySelector.getDefault();
      this.cookieJar = CookieJar.NO_COOKIES;
      this.socketFactory = SocketFactory.getDefault();
      this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
      this.certificatePinner = CertificatePinner.DEFAULT;
      this.proxyAuthenticator = Authenticator.NONE;
      this.authenticator = Authenticator.NONE;
      this.connectionPool = new ConnectionPool();
      this.dns = Dns.SYSTEM;
      this.followSslRedirects = true;
      this.followRedirects = true;
      this.retryOnConnectionFailure = true;
      this.connectTimeout = 10000;
      this.readTimeout = 10000;
      this.writeTimeout = 10000;
      this.pingInterval = 0;
    }
    
    Builder(OkHttpClient paramOkHttpClient)
    {
      this.dispatcher = paramOkHttpClient.dispatcher;
      this.proxy = paramOkHttpClient.proxy;
      this.protocols = paramOkHttpClient.protocols;
      this.connectionSpecs = paramOkHttpClient.connectionSpecs;
      this.interceptors.addAll(paramOkHttpClient.interceptors);
      this.networkInterceptors.addAll(paramOkHttpClient.networkInterceptors);
      this.eventListenerFactory = paramOkHttpClient.eventListenerFactory;
      this.proxySelector = paramOkHttpClient.proxySelector;
      this.cookieJar = paramOkHttpClient.cookieJar;
      this.internalCache = paramOkHttpClient.internalCache;
      this.cache = paramOkHttpClient.cache;
      this.socketFactory = paramOkHttpClient.socketFactory;
      this.sslSocketFactory = paramOkHttpClient.sslSocketFactory;
      this.certificateChainCleaner = paramOkHttpClient.certificateChainCleaner;
      this.hostnameVerifier = paramOkHttpClient.hostnameVerifier;
      this.certificatePinner = paramOkHttpClient.certificatePinner;
      this.proxyAuthenticator = paramOkHttpClient.proxyAuthenticator;
      this.authenticator = paramOkHttpClient.authenticator;
      this.connectionPool = paramOkHttpClient.connectionPool;
      this.dns = paramOkHttpClient.dns;
      this.followSslRedirects = paramOkHttpClient.followSslRedirects;
      this.followRedirects = paramOkHttpClient.followRedirects;
      this.retryOnConnectionFailure = paramOkHttpClient.retryOnConnectionFailure;
      this.connectTimeout = paramOkHttpClient.connectTimeout;
      this.readTimeout = paramOkHttpClient.readTimeout;
      this.writeTimeout = paramOkHttpClient.writeTimeout;
      this.pingInterval = paramOkHttpClient.pingInterval;
    }
    
    public Builder addInterceptor(Interceptor paramInterceptor)
    {
      if (paramInterceptor == null) {
        throw new IllegalArgumentException("interceptor == null");
      }
      this.interceptors.add(paramInterceptor);
      return this;
    }
    
    public Builder addNetworkInterceptor(Interceptor paramInterceptor)
    {
      if (paramInterceptor == null) {
        throw new IllegalArgumentException("interceptor == null");
      }
      this.networkInterceptors.add(paramInterceptor);
      return this;
    }
    
    public Builder authenticator(Authenticator paramAuthenticator)
    {
      if (paramAuthenticator == null) {
        throw new NullPointerException("authenticator == null");
      }
      this.authenticator = paramAuthenticator;
      return this;
    }
    
    public OkHttpClient build()
    {
      return new OkHttpClient(this);
    }
    
    public Builder cache(@Nullable Cache paramCache)
    {
      this.cache = paramCache;
      this.internalCache = null;
      return this;
    }
    
    public Builder certificatePinner(CertificatePinner paramCertificatePinner)
    {
      if (paramCertificatePinner == null) {
        throw new NullPointerException("certificatePinner == null");
      }
      this.certificatePinner = paramCertificatePinner;
      return this;
    }
    
    public Builder connectTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      this.connectTimeout = Util.checkDuration("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public Builder connectionPool(ConnectionPool paramConnectionPool)
    {
      if (paramConnectionPool == null) {
        throw new NullPointerException("connectionPool == null");
      }
      this.connectionPool = paramConnectionPool;
      return this;
    }
    
    public Builder connectionSpecs(List<ConnectionSpec> paramList)
    {
      this.connectionSpecs = Util.immutableList(paramList);
      return this;
    }
    
    public Builder cookieJar(CookieJar paramCookieJar)
    {
      if (paramCookieJar == null) {
        throw new NullPointerException("cookieJar == null");
      }
      this.cookieJar = paramCookieJar;
      return this;
    }
    
    public Builder dispatcher(Dispatcher paramDispatcher)
    {
      if (paramDispatcher == null) {
        throw new IllegalArgumentException("dispatcher == null");
      }
      this.dispatcher = paramDispatcher;
      return this;
    }
    
    public Builder dns(Dns paramDns)
    {
      if (paramDns == null) {
        throw new NullPointerException("dns == null");
      }
      this.dns = paramDns;
      return this;
    }
    
    public Builder eventListener(EventListener paramEventListener)
    {
      if (paramEventListener == null) {
        throw new NullPointerException("eventListener == null");
      }
      this.eventListenerFactory = EventListener.factory(paramEventListener);
      return this;
    }
    
    public Builder eventListenerFactory(EventListener.Factory paramFactory)
    {
      if (paramFactory == null) {
        throw new NullPointerException("eventListenerFactory == null");
      }
      this.eventListenerFactory = paramFactory;
      return this;
    }
    
    public Builder followRedirects(boolean paramBoolean)
    {
      this.followRedirects = paramBoolean;
      return this;
    }
    
    public Builder followSslRedirects(boolean paramBoolean)
    {
      this.followSslRedirects = paramBoolean;
      return this;
    }
    
    public Builder hostnameVerifier(HostnameVerifier paramHostnameVerifier)
    {
      if (paramHostnameVerifier == null) {
        throw new NullPointerException("hostnameVerifier == null");
      }
      this.hostnameVerifier = paramHostnameVerifier;
      return this;
    }
    
    public List<Interceptor> interceptors()
    {
      return this.interceptors;
    }
    
    public List<Interceptor> networkInterceptors()
    {
      return this.networkInterceptors;
    }
    
    public Builder pingInterval(long paramLong, TimeUnit paramTimeUnit)
    {
      this.pingInterval = Util.checkDuration("interval", paramLong, paramTimeUnit);
      return this;
    }
    
    public Builder protocols(List<Protocol> paramList)
    {
      paramList = new ArrayList(paramList);
      if (!paramList.contains(Protocol.HTTP_1_1)) {
        throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + paramList);
      }
      if (paramList.contains(Protocol.HTTP_1_0)) {
        throw new IllegalArgumentException("protocols must not contain http/1.0: " + paramList);
      }
      if (paramList.contains(null)) {
        throw new IllegalArgumentException("protocols must not contain null");
      }
      paramList.remove(Protocol.SPDY_3);
      this.protocols = Collections.unmodifiableList(paramList);
      return this;
    }
    
    public Builder proxy(@Nullable Proxy paramProxy)
    {
      this.proxy = paramProxy;
      return this;
    }
    
    public Builder proxyAuthenticator(Authenticator paramAuthenticator)
    {
      if (paramAuthenticator == null) {
        throw new NullPointerException("proxyAuthenticator == null");
      }
      this.proxyAuthenticator = paramAuthenticator;
      return this;
    }
    
    public Builder proxySelector(ProxySelector paramProxySelector)
    {
      this.proxySelector = paramProxySelector;
      return this;
    }
    
    public Builder readTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      this.readTimeout = Util.checkDuration("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public Builder retryOnConnectionFailure(boolean paramBoolean)
    {
      this.retryOnConnectionFailure = paramBoolean;
      return this;
    }
    
    void setInternalCache(@Nullable InternalCache paramInternalCache)
    {
      this.internalCache = paramInternalCache;
      this.cache = null;
    }
    
    public Builder socketFactory(SocketFactory paramSocketFactory)
    {
      if (paramSocketFactory == null) {
        throw new NullPointerException("socketFactory == null");
      }
      this.socketFactory = paramSocketFactory;
      return this;
    }
    
    public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
    {
      if (paramSSLSocketFactory == null) {
        throw new NullPointerException("sslSocketFactory == null");
      }
      this.sslSocketFactory = paramSSLSocketFactory;
      this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(paramSSLSocketFactory);
      return this;
    }
    
    public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory, X509TrustManager paramX509TrustManager)
    {
      if (paramSSLSocketFactory == null) {
        throw new NullPointerException("sslSocketFactory == null");
      }
      if (paramX509TrustManager == null) {
        throw new NullPointerException("trustManager == null");
      }
      this.sslSocketFactory = paramSSLSocketFactory;
      this.certificateChainCleaner = CertificateChainCleaner.get(paramX509TrustManager);
      return this;
    }
    
    public Builder writeTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      this.writeTimeout = Util.checkDuration("timeout", paramLong, paramTimeUnit);
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/okhttp3/OkHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */