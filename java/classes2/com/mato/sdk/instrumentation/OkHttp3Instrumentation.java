package com.mato.sdk.instrumentation;

import com.mato.sdk.proxy.Address;
import com.mato.sdk.proxy.a;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;

public class OkHttp3Instrumentation
{
  private static OkHttpClient a(OkHttpClient paramOkHttpClient)
  {
    if (paramOkHttpClient == null) {}
    for (;;)
    {
      return paramOkHttpClient;
      Object localObject1 = paramOkHttpClient.proxy();
      ProxySelector localProxySelector = paramOkHttpClient.proxySelector();
      if (((localObject1 == null) || (((Proxy)localObject1).equals(Proxy.NO_PROXY))) && (localProxySelector == null))
      {
        localObject1 = InstrumentationUtils.getHttpProxy();
        if (localObject1 != null) {
          return paramOkHttpClient.newBuilder().proxy((Proxy)localObject1).build();
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
              return paramOkHttpClient.newBuilder().proxy(null).build();
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
            for (int i = 1; i != 0; i = 0) {
              return paramOkHttpClient.newBuilder().proxySelector(ProxySelector.getDefault()).build();
            }
          }
        }
      }
    }
  }
  
  public static Call newCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    Object localObject1 = paramOkHttpClient;
    Proxy localProxy;
    ProxySelector localProxySelector;
    if (paramOkHttpClient != null)
    {
      localProxy = paramOkHttpClient.proxy();
      localProxySelector = paramOkHttpClient.proxySelector();
      if (((localProxy != null) && (!localProxy.equals(Proxy.NO_PROXY))) || (localProxySelector != null)) {
        break label70;
      }
      localProxy = InstrumentationUtils.getHttpProxy();
      localObject1 = paramOkHttpClient;
      if (localProxy != null) {
        localObject1 = paramOkHttpClient.newBuilder().proxy(localProxy).build();
      }
    }
    label70:
    Object localObject2;
    for (;;)
    {
      return ((OkHttpClient)localObject1).newCall(paramRequest);
      localObject2 = InstrumentationUtils.getLastAddress();
      Address localAddress = a.b().g();
      localObject1 = paramOkHttpClient;
      if (localObject2 != null)
      {
        localObject1 = paramOkHttpClient;
        if (localAddress == null)
        {
          localObject2 = ((Address)localObject2).getHttpProxy();
          if (localProxy == null) {
            break;
          }
          localObject1 = paramOkHttpClient;
          if (localProxy.equals(localObject2)) {
            localObject1 = paramOkHttpClient.newBuilder().proxy(null).build();
          }
        }
      }
    }
    localObject1 = localProxySelector.select(URI.create("http://www.baidu.com/")).iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((Proxy)((Iterator)localObject1).next()).equals(localObject2));
    for (int i = 1;; i = 0)
    {
      localObject1 = paramOkHttpClient;
      if (i == 0) {
        break;
      }
      localObject1 = paramOkHttpClient.newBuilder().proxySelector(ProxySelector.getDefault()).build();
      break;
    }
  }
  
  public static OkHttpClient newOkHttpClient()
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    Proxy localProxy = InstrumentationUtils.getHttpProxy();
    if (localProxy != null) {
      localBuilder.proxy(localProxy);
    }
    return localBuilder.build();
  }
  
  public static OkHttpClient.Builder newOkHttpClientBuilder()
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
    Proxy localProxy = InstrumentationUtils.getHttpProxy();
    if (localProxy != null) {
      localBuilder.proxy(localProxy);
    }
    return localBuilder;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/OkHttp3Instrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */