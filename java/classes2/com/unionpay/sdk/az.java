package com.unionpay.sdk;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class az
  implements HostnameVerifier
{
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */