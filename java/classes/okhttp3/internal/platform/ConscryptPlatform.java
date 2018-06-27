package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

public class ConscryptPlatform
  extends Platform
{
  public static Platform buildIfSupported()
  {
    try
    {
      Class.forName("org.conscrypt.ConscryptEngineSocket");
      if (!Conscrypt.isAvailable()) {
        return null;
      }
      Conscrypt.setUseEngineSocketByDefault(true);
      ConscryptPlatform localConscryptPlatform = new ConscryptPlatform();
      return localConscryptPlatform;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  private Provider getProvider()
  {
    return new OpenSSLProvider();
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      if (paramString != null)
      {
        Conscrypt.setUseSessionTickets(paramSSLSocket, true);
        Conscrypt.setHostname(paramSSLSocket, paramString);
      }
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])Platform.alpnProtocolNames(paramList).toArray(new String[0]));
      return;
    }
    super.configureTlsExtensions(paramSSLSocket, paramString, paramList);
  }
  
  public SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS", getProvider());
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
    if (Conscrypt.isConscrypt(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return super.getSelectedProtocol(paramSSLSocket);
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    if (!Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      return super.trustManager(paramSSLSocketFactory);
    }
    try
    {
      paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, Object.class, "sslParameters");
      if (paramSSLSocketFactory != null)
      {
        paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "x509TrustManager");
        return paramSSLSocketFactory;
      }
      return null;
    }
    catch (Exception paramSSLSocketFactory)
    {
      throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", paramSSLSocketFactory);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/okhttp3/internal/platform/ConscryptPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */