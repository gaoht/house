package com.mato.sdk.instrumentation;

import android.util.Log;
import com.mato.sdk.b.g;
import com.mato.sdk.proxy.Address;
import com.mato.sdk.proxy.a;
import java.io.IOException;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.URI;
import org.apache.http.HttpException;

public class CommonsHttpClientInstrumentation
{
  private static final String a = CommonsHttpClientInstrumentation.class.getSimpleName();
  
  private static void a(HostConfiguration paramHostConfiguration)
  {
    if (paramHostConfiguration == null) {}
    Address localAddress;
    do
    {
      do
      {
        return;
      } while ((paramHostConfiguration.getProxyHost() != null) && (paramHostConfiguration.getProxyPort() != -1));
      localAddress = a.b().g();
    } while (localAddress == null);
    paramHostConfiguration.setProxy(localAddress.getHost(), localAddress.getPort());
  }
  
  private static boolean a(HttpMethod paramHttpMethod)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramHttpMethod != null) {}
    try
    {
      bool1 = InstrumentationUtils.a(paramHttpMethod.getURI().getScheme());
      if (bool1) {
        Log.d(g.a, "bypass");
      }
      return bool1;
    }
    catch (Exception paramHttpMethod)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  public static int executeMethod(HttpClient paramHttpClient, HostConfiguration paramHostConfiguration, HttpMethod paramHttpMethod, HttpState paramHttpState)
    throws IOException, HttpException
  {
    if (!a(paramHttpMethod))
    {
      if (paramHostConfiguration == null) {
        break label23;
      }
      a(paramHostConfiguration);
    }
    for (;;)
    {
      return paramHttpClient.executeMethod(paramHostConfiguration, paramHttpMethod, paramHttpState);
      label23:
      if (paramHttpClient != null) {
        a(paramHttpClient.getHostConfiguration());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/CommonsHttpClientInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */