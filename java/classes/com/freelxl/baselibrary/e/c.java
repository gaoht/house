package com.freelxl.baselibrary.e;

import android.text.TextUtils;
import com.freelxl.baselibrary.f.d;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

@Instrumented
public class c
  extends a
{
  public String httpGet(h paramh)
    throws Exception
  {
    Object localObject = paramh.getUrl();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      throw new Exception("----- HTTP Request url is null-----");
    }
    paramh.getMethod();
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    d.e("HttpClientStack", "httpGet url =  " + (String)localObject);
    HttpParams localHttpParams;
    try
    {
      localObject = new HttpGet(new URI((String)localObject));
      localHttpParams = ((HttpGet)localObject).getParams();
      HttpConnectionParams.setConnectionTimeout(localHttpParams, 20000);
      paramh = paramh.a();
      if ((paramh != null) && (!paramh.isEmpty()))
      {
        paramh = paramh.entrySet().iterator();
        while (paramh.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramh.next();
          ((HttpGet)localObject).setHeader((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          return null;
        }
      }
    }
    catch (Exception paramh)
    {
      paramh.printStackTrace();
    }
    label265:
    for (;;)
    {
      HttpConnectionParams.setSoTimeout(localHttpParams, 20000);
      if (!(localDefaultHttpClient instanceof HttpClient)) {}
      for (paramh = localDefaultHttpClient.execute((HttpUriRequest)localObject);; paramh = ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, (HttpUriRequest)localObject))
      {
        if (paramh.getStatusLine().getStatusCode() != 200) {
          break label265;
        }
        paramh = paramh.getEntity();
        if (paramh == null) {
          break;
        }
        paramh = EntityUtils.toString(paramh);
        d.e("HttpClientStack", "response - get =  " + paramh);
        return paramh;
      }
    }
  }
  
  public String httpPost(h paramh)
    throws Exception
  {
    Object localObject2 = paramh.getUrl();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      throw new Exception("----- HTTP Request url is null-----");
    }
    paramh.getMethod();
    Object localObject3 = paramh.b();
    d.e("HttpClientStack", "httpPost url= " + (String)localObject2 + " & params= " + localObject3);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    Object localObject1 = new ArrayList();
    new JSONObject();
    Map.Entry localEntry;
    if ((localObject3 != null) && (!((Map)localObject3).isEmpty()))
    {
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject3).next();
        if (localEntry.getValue() != null) {
          ((List)localObject1).add(new BasicNameValuePair((String)localEntry.getKey(), localEntry.getValue().toString()));
        }
      }
    }
    try
    {
      localObject2 = new HttpPost(new URI((String)localObject2));
      localObject3 = ((HttpPost)localObject2).getParams();
      paramh = paramh.a();
      if ((paramh != null) && (!paramh.isEmpty()))
      {
        paramh = paramh.entrySet().iterator();
        while (paramh.hasNext())
        {
          localEntry = (Map.Entry)paramh.next();
          ((HttpPost)localObject2).setHeader((String)localEntry.getKey(), localEntry.getValue().toString());
          continue;
          return null;
        }
      }
    }
    catch (Exception paramh)
    {
      paramh.printStackTrace();
    }
    label423:
    for (;;)
    {
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject3, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject3, 20000);
      localObject1 = new UrlEncodedFormEntity((List)localObject1, "UTF-8");
      ((HttpPost)localObject2).setEntity((HttpEntity)localObject1);
      if (!(localDefaultHttpClient instanceof HttpClient)) {}
      for (paramh = localDefaultHttpClient.execute((HttpUriRequest)localObject2);; paramh = ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, (HttpUriRequest)localObject2))
      {
        if (paramh.getStatusLine().getStatusCode() != 200) {
          break label423;
        }
        paramh = paramh.getEntity();
        if (localObject1 == null) {
          break;
        }
        paramh = EntityUtils.toString(paramh, "UTF-8");
        d.e("HttpClientStack", "response - post =  " + paramh);
        return paramh;
      }
    }
  }
  
  public String httpsPost(h paramh)
    throws Exception
  {
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */