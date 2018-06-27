package com.megvii.zhimasdk.b;

import com.megvii.zhimasdk.b.a.e.d.g;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class n
  extends g
{
  final SSLContext a = SSLContext.getInstance("TLS");
  
  public n(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    paramKeyStore = new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
      
      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
      
      public X509Certificate[] getAcceptedIssuers()
      {
        return null;
      }
    };
    this.a.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public static KeyStore a()
  {
    try
    {
      localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localKeyStore.load(null, null);
        return localKeyStore;
      }
      catch (Throwable localThrowable2)
      {
        KeyStore localKeyStore;
        for (;;) {}
      }
      localThrowable1 = localThrowable1;
      localKeyStore = null;
    }
    return localKeyStore;
  }
  
  public static g b()
  {
    try
    {
      n localn = new n(a());
      localn.a(g.b);
      return localn;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return g.d();
  }
  
  public Socket a(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public Socket c()
  {
    return this.a.getSocketFactory().createSocket();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */