package com.hyphenate.cloud;

import android.util.Pair;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.NetUtils;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@Instrumented
class a
{
  public static String a = "GET";
  public static String b = "POST";
  public static String c = "PUT";
  public static String d = "DELETE";
  public static final int e = 3;
  private static final String f = "HttpClientManager";
  private static volatile long g = 0L;
  private static final int h = 120000;
  private static volatile boolean i = false;
  
  public static Pair<Integer, String> a(String paramString1, String paramString2, String paramString3)
    throws HyphenateException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Authorization", "Bearer " + EMClient.getInstance().getOptions().getAccessToken());
    try
    {
      paramString2 = a(paramString1, localHashMap, paramString2, paramString3);
      return paramString2;
    }
    catch (IOException paramString3)
    {
      paramString2 = " send request : " + paramString1 + " failed!";
      paramString1 = paramString2;
      if (paramString3 != null)
      {
        paramString1 = paramString2;
        if (paramString3.toString() != null) {
          paramString1 = paramString3.toString();
        }
      }
      EMLog.d("HttpClientManager", paramString1);
      throw new HyphenateException(1, paramString1);
    }
  }
  
  static Pair<Integer, String> a(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws HyphenateException, IOException
  {
    Pair localPair = b(paramString1, paramMap, paramString2, paramString3);
    if ((localPair != null) && (((Integer)localPair.first).intValue() == 401) && (System.currentTimeMillis() - g > 120000L) && (!i))
    {
      i = true;
      String str = EMClient.getInstance().getOptions().getAccessToken(true);
      i = false;
      g = System.currentTimeMillis();
      if (str != null)
      {
        paramMap.put("Authorization", "Bearer " + str);
        return b(paramString1, paramMap, paramString2, paramString3);
      }
    }
    return localPair;
  }
  
  static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.substring(paramString1.indexOf("/", 8));
    paramString1 = paramString1.substring(paramString1.indexOf("/", 1));
    paramString1 = paramString1.substring(paramString1.indexOf("/", 1));
    return paramString2 + paramString1;
  }
  
  static Map<String, String> a(Map<String, String> paramMap)
  {
    return paramMap;
  }
  
  static void a(String paramString, DefaultHttpClient paramDefaultHttpClient)
    throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, KeyManagementException, UnrecoverableKeyException
  {}
  
  public static Pair<Integer, String> b(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws IOException, HyphenateException
  {
    int j = 0;
    Object localObject4 = paramString1;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    label119:
    Object localObject6;
    if (j < 3)
    {
      EMLog.d("HttpClientManager", "try send request, request url: " + (String)localObject4 + " with number: " + j);
      try
      {
        localObject2 = e((String)localObject4, paramMap, paramString2, paramString3);
        localObject3 = ((HttpResponse)localObject2).getEntity();
        if (localObject3 == null) {
          break label347;
        }
        localObject3 = EntityUtils.toString((HttpEntity)localObject3, "UTF-8");
        localObject2 = new Pair(Integer.valueOf(((HttpResponse)localObject2).getStatusLine().getStatusCode()), localObject3);
        localObject1 = localObject2;
        localObject4 = null;
        localObject2 = null;
        localObject6 = null;
        localObject3 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject6;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject2 = localIOException;
          localObject3 = localObject1;
          localObject1 = null;
        }
      }
      catch (HyphenateException localHyphenateException)
      {
        for (;;)
        {
          localObject2 = null;
          localObject3 = localObject1;
          localObject1 = localHyphenateException;
        }
      }
      localObject6 = "failed to send request, request url: " + paramString1;
      if (localObject4 == null) {
        break label350;
      }
      if (((Exception)localObject4).getMessage() != null) {
        localObject4 = ((Exception)localObject4).getMessage();
      }
    }
    for (;;)
    {
      Object localObject8 = localObject1;
      Object localObject7 = localObject2;
      localObject6 = localObject3;
      if (((String)localObject4).toLowerCase().contains("refused"))
      {
        localObject8 = localObject1;
        localObject7 = localObject2;
        localObject6 = localObject3;
        if (NetUtils.hasNetwork(EMClient.getInstance().getContext()))
        {
          localObject4 = a(paramString1, EMHttpClient.getInstance().chatConfig().m());
          j += 1;
          localObject6 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject6;
          break;
          if (localHyphenateException.toString() == null) {
            break label350;
          }
          localObject5 = localHyphenateException.toString();
          continue;
          localObject6 = localObject1;
          localObject7 = localObject2;
          localObject8 = localObject3;
        }
      }
      if (localObject7 != null) {
        throw ((Throwable)localObject7);
      }
      if (localObject8 != null) {
        throw ((Throwable)localObject8);
      }
      return (Pair<Integer, String>)localObject6;
      label347:
      break label119;
      label350:
      Object localObject5 = localObject6;
    }
  }
  
  public static HttpResponse c(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws KeyStoreException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, IOException
  {
    return d(paramString1, a(paramMap), paramString2, paramString3);
  }
  
  public static HttpResponse d(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws ClientProtocolException, IOException, KeyStoreException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException
  {
    Object localObject = null;
    DefaultHttpClient localDefaultHttpClient = HttpClientConfig.getDefaultHttpClient(paramString1, HttpClientConfig.getTimeout(paramMap));
    if (paramString3.equals(b))
    {
      paramString1 = new HttpPost(paramString1);
      paramString1.setEntity(new StringEntity(paramString2, "UTF-8"));
    }
    for (;;)
    {
      paramString2 = (String)localObject;
      if (paramString1 != null)
      {
        if (paramMap != null)
        {
          paramMap = paramMap.entrySet().iterator();
          for (;;)
          {
            if (paramMap.hasNext())
            {
              paramString2 = (Map.Entry)paramMap.next();
              paramString1.setHeader((String)paramString2.getKey(), (String)paramString2.getValue());
              continue;
              if (paramString3.equals(c))
              {
                paramString1 = new HttpPut(paramString1);
                paramString1.setEntity(new StringEntity(paramString2, "UTF-8"));
                break;
              }
              if (paramString3.equals(a))
              {
                paramString1 = new HttpGet(paramString1);
                break;
              }
              if (!paramString3.equals(d)) {
                break label222;
              }
              paramString1 = new HttpDelete(paramString1);
              break;
            }
          }
        }
        if (!(localDefaultHttpClient instanceof HttpClient)) {
          paramString2 = localDefaultHttpClient.execute(paramString1);
        }
      }
      else
      {
        return paramString2;
      }
      return ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, paramString1);
      label222:
      paramString1 = null;
    }
  }
  
  private static HttpResponse e(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws HyphenateException, IOException
  {
    try
    {
      paramMap = c(paramString1, paramMap, paramString2, paramString3);
      return paramMap;
    }
    catch (IOException paramString1)
    {
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      if (paramString2 != null) {
        paramString2.printStackTrace();
      }
      paramMap = "http request failed : " + paramString1;
      paramString1 = paramMap;
      if (paramString2 != null)
      {
        paramString1 = paramMap;
        if (paramString2.toString() != null) {
          paramString1 = paramString2.toString();
        }
      }
      if (paramString1.contains("Unable to resolve host")) {
        throw new HyphenateException(2, "Unable to resolve host");
      }
      throw new HyphenateException(300, paramString1);
    }
  }
  
  private static String f(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws HyphenateException, IOException
  {
    Object localObject = null;
    try
    {
      paramString2 = c(paramString1, paramMap, paramString2, paramString3).getEntity();
      paramMap = (Map<String, String>)localObject;
      if (paramString2 != null) {
        paramMap = EntityUtils.toString(paramString2, "UTF-8");
      }
      return paramMap;
    }
    catch (IOException paramString1)
    {
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      if (paramString2 != null) {
        paramString2.printStackTrace();
      }
      paramMap = "http request failed : " + paramString1;
      paramString1 = paramMap;
      if (paramString2 != null)
      {
        paramString1 = paramMap;
        if (paramString2.toString() != null) {
          paramString1 = paramString2.toString();
        }
      }
      if (paramString1.contains("Unable to resolve host")) {
        throw new HyphenateException(2, "Unable to resolve host");
      }
      throw new HyphenateException(300, paramString1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/cloud/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */