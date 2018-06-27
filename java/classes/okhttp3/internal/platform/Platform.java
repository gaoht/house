package okhttp3.internal.platform;

import d.c;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

public class Platform
{
  public static final int INFO = 4;
  private static final Platform PLATFORM = ;
  public static final int WARN = 5;
  private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());
  
  public static List<String> alpnProtocolNames(List<Protocol> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localProtocol.toString());
      }
    }
    return localArrayList;
  }
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    c localc = new c();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localc.writeByte(localProtocol.toString().length());
        localc.writeUtf8(localProtocol.toString());
      }
    }
    return localc.readByteArray();
  }
  
  private static Platform findPlatform()
  {
    Object localObject1 = AndroidPlatform.buildIfSupported();
    if (localObject1 != null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return (Platform)localObject1;
          if (!isConscryptPreferred()) {
            break;
          }
          localObject2 = ConscryptPlatform.buildIfSupported();
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = Jdk9Platform.buildIfSupported();
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = JdkWithJettyBootPlatform.buildIfSupported();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return new Platform();
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  public static boolean isConscryptPreferred()
  {
    if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
      return true;
    }
    return "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    Class localClass = paramObject.getClass();
    while (localClass != Object.class) {
      try
      {
        Object localObject = localClass.getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        if ((localObject == null) || (!paramClass.isInstance(localObject))) {
          break label110;
        }
        localObject = paramClass.cast(localObject);
        return (T)localObject;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    if (!paramString.equals("delegate"))
    {
      paramObject = readFieldOrNull(paramObject, Object.class, "delegate");
      if (paramObject != null) {
        return (T)readFieldOrNull(paramObject, paramClass, paramString);
      }
    }
    return null;
    label110:
    return null;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory paramSSLSocketFactory)
  {
    X509TrustManager localX509TrustManager = trustManager(paramSSLSocketFactory);
    if (localX509TrustManager == null) {
      throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + paramSSLSocketFactory.getClass());
    }
    return buildCertificateChainCleaner(localX509TrustManager);
  }
  
  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    return new BasicCertificateChainCleaner(buildTrustRootIndex(paramX509TrustManager));
  }
  
  public TrustRootIndex buildTrustRootIndex(X509TrustManager paramX509TrustManager)
  {
    return new BasicTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix()
  {
    return "OkHttp";
  }
  
  public SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException);
    }
  }
  
  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public Object getStackTraceForCloseable(String paramString)
  {
    if (logger.isLoggable(Level.FINE)) {
      return new Throwable(paramString);
    }
    return null;
  }
  
  public boolean isCleartextTrafficPermitted(String paramString)
  {
    return true;
  }
  
  public void log(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 5) {}
    for (Level localLevel = Level.WARNING;; localLevel = Level.INFO)
    {
      logger.log(localLevel, paramString, paramThrowable);
      return;
    }
  }
  
  public void logCloseableLeak(String paramString, Object paramObject)
  {
    String str = paramString;
    if (paramObject == null) {
      str = paramString + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    }
    log(5, str, (Throwable)paramObject);
  }
  
  protected X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
      if (paramSSLSocketFactory == null) {
        return null;
      }
      paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
      return paramSSLSocketFactory;
    }
    catch (ClassNotFoundException paramSSLSocketFactory) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/okhttp3/internal/platform/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */