package com.mato.sdk.instrumentation;

import android.util.Log;
import com.mato.sdk.proxy.Address;
import com.mato.sdk.proxy.a;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.DNSUtil.HostAddress;

public class SmackInstrumentation
{
  private static final String a = SmackInstrumentation.class.getSimpleName();
  
  public static ConnectionConfiguration newConnConfig(String paramString)
  {
    DNSUtil.HostAddress localHostAddress = DNSUtil.resolveXMPPDomain(paramString);
    return newConnConfig(localHostAddress.getHost(), localHostAddress.getPort(), paramString);
  }
  
  public static ConnectionConfiguration newConnConfig(String paramString, int paramInt)
  {
    return newConnConfig(paramString, paramInt, paramString);
  }
  
  public static ConnectionConfiguration newConnConfig(String paramString1, int paramInt, String paramString2)
  {
    Address localAddress = a.b().g();
    if (localAddress != null)
    {
      Log.d(a, "XMPP set wspx proxy");
      return new ConnectionConfiguration(paramString1, paramInt, paramString2, ProxyInfo.forHttpProxy(localAddress.getHost(), localAddress.getPort(), null, null));
    }
    return new ConnectionConfiguration(paramString1, paramInt, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/SmackInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */