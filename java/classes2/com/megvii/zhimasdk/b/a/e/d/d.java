package com.megvii.zhimasdk.b.a.e.d;

import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class d
{
  private String a;
  private Set<KeyManager> b = new HashSet();
  private Set<TrustManager> c = new HashSet();
  private SecureRandom d;
  
  public d a(KeyStore paramKeyStore)
  {
    return a(paramKeyStore, null);
  }
  
  public d a(KeyStore paramKeyStore, i parami)
  {
    int j = 0;
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(paramKeyStore);
    paramKeyStore = localTrustManagerFactory.getTrustManagers();
    if (paramKeyStore != null)
    {
      if (parami != null)
      {
        i = 0;
        while (i < paramKeyStore.length)
        {
          localTrustManagerFactory = paramKeyStore[i];
          if ((localTrustManagerFactory instanceof X509TrustManager)) {
            paramKeyStore[i] = new a((X509TrustManager)localTrustManagerFactory, parami);
          }
          i += 1;
        }
      }
      int k = paramKeyStore.length;
      int i = j;
      while (i < k)
      {
        parami = paramKeyStore[i];
        this.c.add(parami);
        i += 1;
      }
    }
    return this;
  }
  
  public SSLContext a()
  {
    Object localObject;
    SSLContext localSSLContext;
    if (this.a != null)
    {
      localObject = this.a;
      localSSLContext = SSLContext.getInstance((String)localObject);
      if (this.b.isEmpty()) {
        break label109;
      }
      localObject = (KeyManager[])this.b.toArray(new KeyManager[this.b.size()]);
      label54:
      if (this.c.isEmpty()) {
        break label114;
      }
    }
    label109:
    label114:
    for (TrustManager[] arrayOfTrustManager = (TrustManager[])this.c.toArray(new TrustManager[this.c.size()]);; arrayOfTrustManager = null)
    {
      localSSLContext.init((KeyManager[])localObject, arrayOfTrustManager, this.d);
      return localSSLContext;
      localObject = "TLS";
      break;
      localObject = null;
      break label54;
    }
  }
  
  static class a
    implements X509TrustManager
  {
    private final X509TrustManager a;
    private final i b;
    
    a(X509TrustManager paramX509TrustManager, i parami)
    {
      this.a = paramX509TrustManager;
      this.b = parami;
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    {
      this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    }
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    {
      if (!this.b.a(paramArrayOfX509Certificate, paramString)) {
        this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return this.a.getAcceptedIssuers();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */