package com.umeng.analytics.pro;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class ao
  implements X509TrustManager
{
  X509TrustManager a;
  
  public ao()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      for (;;)
      {
        if (i < localObject.length)
        {
          if ((localObject[i] instanceof X509TrustManager)) {
            this.a = ((X509TrustManager)localObject[i]);
          }
        }
        else {
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException paramArrayOfX509Certificate) {}
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */