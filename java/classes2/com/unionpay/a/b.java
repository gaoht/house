package com.unionpay.a;

import android.content.Context;
import android.text.TextUtils;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class b
  implements X509TrustManager
{
  private X509TrustManager a = null;
  private Context b;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
    paramContext = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    paramContext.init(null);
    paramContext = paramContext.getTrustManagers();
    if (paramContext.length == 0) {
      throw new NoSuchAlgorithmException("no trust manager found");
    }
    this.a = ((X509TrustManager)paramContext[0]);
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    for (;;)
    {
      int i;
      try
      {
        paramString = paramArrayOfX509Certificate[0].getIssuerX500Principal();
        localArrayList = new ArrayList(0);
        localArrayList.add(".*O=(GeoTrust Inc\\.|VeriSign\\\\, Inc\\.|Symantec Corporation).*");
        String str = com.unionpay.utils.b.a(this.b);
        if (TextUtils.isEmpty(str)) {
          break label231;
        }
        localArrayList.add(str);
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        ArrayList localArrayList;
        throw new CertificateException();
      }
      if (i < localArrayList.size())
      {
        if (Pattern.compile((String)localArrayList.get(i)).matcher(paramString.getName()).matches())
        {
          i = 1;
          if (i == 0) {
            throw new CertificateException();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        paramArrayOfX509Certificate = paramArrayOfX509Certificate[0].getSubjectX500Principal();
        paramString = new ArrayList(0);
        paramString.add(".*CN=.*(\\.95516\\.com|\\.chinaunionpay\\.com|\\.unionpay\\.com|\\.unionpaysecure\\.com|\\.95516\\.net).*");
        i = 0;
        if (i < paramString.size()) {
          if (!Pattern.compile((String)paramString.get(i)).matcher(paramArrayOfX509Certificate.getName()).matches()) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            throw new CertificateException();
            i += 1;
            break;
          }
          return;
        }
      }
      else
      {
        i = 0;
        continue;
        label231:
        i = 0;
      }
    }
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */