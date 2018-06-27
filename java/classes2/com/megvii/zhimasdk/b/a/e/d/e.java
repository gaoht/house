package com.megvii.zhimasdk.b.a.e.d;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

public class e
{
  public static SSLContext a()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, null, null);
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new f(localNoSuchAlgorithmException.getMessage(), localNoSuchAlgorithmException);
    }
    catch (KeyManagementException localKeyManagementException)
    {
      throw new f(localKeyManagementException.getMessage(), localKeyManagementException);
    }
  }
  
  public static d b()
  {
    return new d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */