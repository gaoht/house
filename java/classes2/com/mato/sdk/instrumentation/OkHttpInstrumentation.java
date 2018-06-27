package com.mato.sdk.instrumentation;

import com.mato.sdk.proxy.Address;
import com.mato.sdk.proxy.a;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

public class OkHttpInstrumentation
{
  private static final String a = OkHttpInstrumentation.class.getSimpleName();
  
  static void a(OkHttpClient paramOkHttpClient)
  {
    if (paramOkHttpClient == null) {}
    for (;;)
    {
      return;
      Object localObject1 = paramOkHttpClient.getProxy();
      ProxySelector localProxySelector = paramOkHttpClient.getProxySelector();
      if (((localObject1 == null) || (((Proxy)localObject1).equals(Proxy.NO_PROXY))) && (localProxySelector == null))
      {
        localObject1 = InstrumentationUtils.getHttpProxy();
        if (localObject1 != null) {
          paramOkHttpClient.setProxy((Proxy)localObject1);
        }
      }
      else
      {
        Object localObject2 = InstrumentationUtils.getLastAddress();
        Address localAddress = a.b().g();
        if ((localObject2 != null) && (localAddress == null))
        {
          localObject2 = ((Address)localObject2).getHttpProxy();
          if (localObject1 != null)
          {
            if (((Proxy)localObject1).equals(localObject2)) {
              paramOkHttpClient.setProxy(null);
            }
          }
          else
          {
            localObject1 = localProxySelector.select(URI.create("http://www.baidu.com/")).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
            } while (!((Proxy)((Iterator)localObject1).next()).equals(localObject2));
            for (int i = 1; i != 0; i = 0)
            {
              paramOkHttpClient.setProxySelector(ProxySelector.getDefault());
              return;
            }
          }
        }
      }
    }
  }
  
  private static boolean a()
  {
    return false;
  }
  
  public static Call newCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    a(paramOkHttpClient);
    return paramOkHttpClient.newCall(paramRequest);
  }
  
  public static OkHttpClient newOkHttpClient()
    throws IOException, UnknownHostException
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    Proxy localProxy = InstrumentationUtils.getHttpProxy();
    if (localProxy != null) {
      localOkHttpClient.setProxy(localProxy);
    }
    return localOkHttpClient;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/OkHttpInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */