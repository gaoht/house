package com.unionpay.mobile.android.net;

import android.content.Context;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import com.unionpay.mobile.android.utils.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.ByteArrayBuffer;

@Instrumented
public final class c
{
  private HttpClient a = null;
  private HttpResponse b = null;
  private HttpEntity c = null;
  private byte[] d = null;
  private InputStream e = null;
  private d f = null;
  
  public c(d paramd, Context paramContext)
  {
    this.f = paramd;
    paramd = new BasicHttpParams();
    ConnManagerParams.setMaxTotalConnections(paramd, 20);
    HttpConnectionParams.setConnectionTimeout(paramd, 30000);
    HttpConnectionParams.setSoTimeout(paramd, 60000);
    HttpConnectionParams.setSocketBufferSize(paramd, 8192);
    HttpClientParams.setRedirecting(paramd, true);
    HttpProtocolParams.setUserAgent(paramd, "uppay");
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", new a(paramContext), 443));
    this.a = new DefaultHttpClient(new ThreadSafeClientConnManager(paramd, localSchemeRegistry), paramd);
    ((AbstractHttpClient)this.a).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
  }
  
  public final int a()
  {
    j.a("uppay", "HttpConn.connect() +++");
    if (this.f == null)
    {
      j.c("uppay", "params==null!!!");
      return 1;
    }
    if (this.f.a() == 1) {}
    Object localObject2;
    for (Object localObject1 = new HttpPost(this.f.b());; localObject1 = new HttpGet(this.f.b()))
    {
      if (this.f.d() != null) {
        ((HttpPost)localObject1).setEntity(new ByteArrayEntity(this.f.d()));
      }
      localObject2 = this.f.c();
      if (localObject2 == null) {
        break;
      }
      Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str4 = (String)localIterator.next();
        ((HttpUriRequest)localObject1).addHeader(str4, (String)((HashMap)localObject2).get(str4));
      }
    }
    int i;
    try
    {
      localObject2 = this.a;
      if (!(localObject2 instanceof HttpClient))
      {
        localObject1 = ((HttpClient)localObject2).execute((HttpUriRequest)localObject1);
        this.b = ((HttpResponse)localObject1);
        if (this.b.getStatusLine().getStatusCode() != 200) {
          break label355;
        }
        this.c = this.b.getEntity();
        if (this.c == null) {
          break label417;
        }
        localObject1 = new ByteArrayBuffer(2048);
        localObject2 = new byte['ࠀ'];
        this.e = this.c.getContent();
        for (;;)
        {
          i = this.e.read((byte[])localObject2, 0, localObject2.length);
          if (i == -1) {
            break;
          }
          if (i > 0) {
            ((ByteArrayBuffer)localObject1).append((byte[])localObject2, 0, i);
          }
        }
      }
    }
    catch (SSLHandshakeException localSSLHandshakeException)
    {
      j.a("uppay", "e0:" + localSSLHandshakeException.getMessage());
      i = 4;
      for (;;)
      {
        j.a("uppay", "HttpConn.connect() ---");
        return i;
        HttpResponse localHttpResponse = ApacheHttpClientInstrumentation.execute((HttpClient)localObject2, localSSLHandshakeException);
        break;
        this.d = localHttpResponse.toByteArray();
        i = 0;
        continue;
        if (this.b.getStatusLine().getStatusCode() == 401)
        {
          i = 8;
        }
        else
        {
          j.c("uppay", "http status code:" + this.b.getStatusLine().getStatusCode());
          i = 1;
        }
      }
    }
    catch (IOException localIOException)
    {
      if ("e1: " + localIOException != null) {}
      for (String str1 = localIOException.getMessage();; str1 = "e == null")
      {
        j.c("uppay", str1);
        i = 1;
        break;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if ("e2: " + localIllegalStateException != null) {}
      for (String str2 = localIllegalStateException.getMessage();; str2 = "e == null")
      {
        j.c("uppay", str2);
        i = 1;
        break;
      }
    }
    catch (Exception localException)
    {
      label355:
      label417:
      if ("e3: " + localException == null) {}
    }
    for (String str3 = localException.getMessage();; str3 = "e == null")
    {
      j.c("uppay", str3);
      i = 1;
      break;
    }
  }
  
  public final byte[] b()
  {
    return this.d;
  }
  
  public final String c()
  {
    if (this.d != null)
    {
      try
      {
        j.a("uppay", this.d.toString());
        String str1 = new String(this.d, "utf-8");
        j.c("uppay", "convert response to utf-8 error!!!!");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          j.a("uppay", "respon:" + str1);
          return str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          String str2;
          for (;;) {}
        }
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        str2 = null;
      }
      return str2;
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/net/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */