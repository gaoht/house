package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcoloreggs.eggs.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

@Instrumented
public class q
{
  private static void a(String paramString1, String paramString2, String paramString3, Map<String, Object> paramMap, String paramString4)
  {
    if (a.a)
    {
      e locale = new e();
      locale.put("url", paramString1 + "   ----  old");
      locale.put("webType", paramString3 + "");
      if ("POST".equals(paramString3))
      {
        paramString1 = new StringBuilder();
        paramString1.append("{");
        if ((paramMap != null) && (!paramMap.isEmpty()))
        {
          paramString3 = paramMap.entrySet().iterator();
          while (paramString3.hasNext())
          {
            paramMap = (Map.Entry)paramString3.next();
            if (paramMap.getValue() == null) {
              paramString1.append("\"" + (String)paramMap.getKey() + "\":\"\",");
            } else {
              paramString1.append("\"" + (String)paramMap.getKey() + "\":\"" + paramMap.getValue().toString() + "\",");
            }
          }
        }
        paramString1.delete(paramString1.length() - 1, paramString1.length());
        paramString1.append("}");
        locale.put("params", paramString1.toString());
      }
      locale.put("code", paramString2 + "");
      locale.put("resp", paramString4 + "");
      paramString1 = locale.get("url").toString();
      if ((!paramString1.substring(paramString1.length() - 4, paramString1.length()).equals(".jpg")) && (!paramString1.substring(paramString1.length() - 4, paramString1.length()).equals(".png")) && (!paramString1.substring(paramString1.length() - 4, paramString1.length()).equals(".JPG")) && (!paramString1.substring(paramString1.length() - 4, paramString1.length()).equals(".PNG")) && (!paramString1.substring(paramString1.length() - 5, paramString1.length()).equals(".jpeg"))) {
        l.writeWebLog(locale);
      }
    }
  }
  
  public static String httpGet(String paramString)
  {
    Object localObject1 = new DefaultHttpClient();
    u.e("url", paramString);
    try
    {
      Object localObject2 = new HttpGet(new URI(paramString));
      if (!(localObject1 instanceof HttpClient)) {
        localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject2);
      }
      while (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
      {
        localObject2 = ((HttpResponse)localObject1).getEntity();
        if (localObject2 != null)
        {
          localObject2 = EntityUtils.toString((HttpEntity)localObject2, "UTF-8");
          u.e("net", (String)localObject2);
          a(paramString, ((HttpResponse)localObject1).getStatusLine().getStatusCode() + "", "get", null, (String)localObject2);
          return (String)localObject2;
          localObject1 = ApacheHttpClientInstrumentation.execute((HttpClient)localObject1, (HttpUriRequest)localObject2);
        }
        else
        {
          a(paramString, ((HttpResponse)localObject1).getStatusLine().getStatusCode() + "", "get", null, "");
          break label227;
        }
      }
      a(paramString, ((HttpResponse)localObject1).getStatusLine().getStatusCode() + "", "get", null, "");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    label227:
    return null;
  }
  
  public static boolean httpGetImg(String paramString)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    u.e("url", paramString);
    try
    {
      paramString = new HttpGet(new URI(paramString));
      if (!(localDefaultHttpClient instanceof HttpClient)) {}
      for (paramString = localDefaultHttpClient.execute(paramString); paramString.getStatusLine().getStatusCode() == 200; paramString = ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, paramString)) {
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static String httpPost(String paramString, Map<String, Object> paramMap)
  {
    Object localObject1 = new DefaultHttpClient();
    Object localObject2 = new ArrayList();
    new e();
    Object localObject3;
    if ((paramMap == null) || ((paramMap != null) && (!paramMap.isEmpty())))
    {
      localObject3 = paramMap.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        if (localEntry.getValue() == null) {
          ((List)localObject2).add(new BasicNameValuePair((String)localEntry.getKey(), ""));
        } else {
          ((List)localObject2).add(new BasicNameValuePair((String)localEntry.getKey(), localEntry.getValue().toString()));
        }
      }
    }
    u.e("url == ", paramString + localObject2.toString());
    try
    {
      localObject3 = new HttpPost(new URI(paramString));
      localObject2 = new UrlEncodedFormEntity((List)localObject2, "UTF-8");
      ((HttpPost)localObject3).setEntity((HttpEntity)localObject2);
      if (!(localObject1 instanceof HttpClient)) {}
      for (localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject3);; localObject1 = ApacheHttpClientInstrumentation.execute((HttpClient)localObject1, (HttpUriRequest)localObject3))
      {
        u.e("httpResponse == ", ((HttpResponse)localObject1).getStatusLine().getStatusCode() + "");
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200) {
          break label396;
        }
        localObject3 = ((HttpResponse)localObject1).getEntity();
        if (localObject2 == null) {
          break;
        }
        localObject2 = EntityUtils.toString((HttpEntity)localObject3);
        u.e("httpResponse == ", (String)localObject2);
        a(paramString, ((HttpResponse)localObject1).getStatusLine().getStatusCode() + "", "POST", paramMap, (String)localObject2);
        return (String)localObject2;
      }
      a(paramString, ((HttpResponse)localObject1).getStatusLine().getStatusCode() + "", "POST", paramMap, "");
      break label445;
      label396:
      a(paramString, ((HttpResponse)localObject1).getStatusLine().getStatusCode() + "", "POST", paramMap, "");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    label445:
    return null;
  }
  
  public static String httpRasGet(String paramString)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    u.e("url", paramString);
    try
    {
      paramString = new HttpGet(new URI(paramString));
      paramString.setHeader("zmcsrc", "ANDROID");
      if (!(localDefaultHttpClient instanceof HttpClient)) {}
      for (paramString = localDefaultHttpClient.execute(paramString); paramString.getStatusLine().getStatusCode() == 200; paramString = ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, paramString))
      {
        paramString = paramString.getEntity();
        if (paramString == null) {
          break;
        }
        paramString = EntityUtils.toString(paramString);
        u.e("net", paramString);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String httpRsaPost(String paramString, Map<String, Object> paramMap)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    ArrayList localArrayList = new ArrayList();
    new e();
    u.e("url == ", paramString + paramMap);
    if ((paramMap == null) || ((paramMap != null) && (!paramMap.isEmpty())))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localEntry.getValue() == null) {
          localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), ""));
        } else {
          localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), localEntry.getValue().toString()));
        }
      }
    }
    try
    {
      paramString = new HttpPost(new URI(paramString));
      paramString.setHeader("zmcsrc", "ANDROID");
      paramMap = new UrlEncodedFormEntity(localArrayList, "UTF-8");
      paramString.setEntity(paramMap);
      if (!(localDefaultHttpClient instanceof HttpClient)) {}
      for (paramString = localDefaultHttpClient.execute(paramString); paramString.getStatusLine().getStatusCode() == 200; paramString = ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, paramString))
      {
        paramString = paramString.getEntity();
        if (paramMap == null) {
          break;
        }
        paramString = EntityUtils.toString(paramString);
        u.e("httpResponse == ", paramString);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String httpUpload(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramString = new URL(paramString);
      if (!(paramString instanceof URL))
      {
        paramString = paramString.openConnection();
        localHttpURLConnection = (HttpURLConnection)paramString;
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setRequestProperty("Content-Type", "image/jpeg");
        localHttpURLConnection.setRequestProperty("Cache-Control", "no-cache");
        localHttpURLConnection.setRequestProperty("Charsert", "UTF-8");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.connect();
        paramString = localHttpURLConnection.getOutputStream();
        paramString.write(paramArrayOfByte);
        paramString.flush();
        paramString.close();
        localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
        paramString = (String)localObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        HttpURLConnection localHttpURLConnection;
        for (;;)
        {
          BufferedReader localBufferedReader;
          paramArrayOfByte = localBufferedReader.readLine();
          if (paramArrayOfByte == null) {
            break;
          }
          if (paramString != null)
          {
            paramArrayOfByte = paramString + paramArrayOfByte;
            paramString = paramArrayOfByte;
            continue;
            paramString = HttpInstrumentation.openConnection((URL)paramString);
          }
          else
          {
            paramString = paramArrayOfByte;
          }
        }
        localHttpURLConnection.disconnect();
        return paramString;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
      paramString = null;
    }
    paramArrayOfByte.printStackTrace();
    return paramString;
  }
  
  public static String httpUploadTo(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = null;
    u.e("pic: ", paramString1 + paramArrayOfByte + paramString2);
    try
    {
      paramString1 = new URL(paramString1);
      if (!(paramString1 instanceof URL))
      {
        paramString1 = paramString1.openConnection();
        localHttpURLConnection = (HttpURLConnection)paramString1;
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------------0xKhTmLbOuNdArY");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.connect();
        paramString1 = localHttpURLConnection.getOutputStream();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("-----------------------------------0xKhTmLbOuNdArY\r\n");
        localStringBuilder.append("Content-Disposition: form-data; name=\"iosImage\"; filename=\"" + paramString2 + "\"\r\n");
        localStringBuilder.append("Content-Type: image/jpeg\r\n\r\n");
        paramString1.write(localStringBuilder.toString().getBytes("utf-8"));
        paramString1.write(paramArrayOfByte);
        paramString1.write("\r\n-----------------------------------0xKhTmLbOuNdArY--\r\n".getBytes("utf-8"));
        paramString1.flush();
        paramString1.close();
        paramString2 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
        paramString1 = (String)localObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        HttpURLConnection localHttpURLConnection;
        for (;;)
        {
          paramArrayOfByte = paramString2.readLine();
          if (paramArrayOfByte == null) {
            break;
          }
          if (paramString1 != null)
          {
            paramArrayOfByte = paramString1 + paramArrayOfByte;
            paramString1 = paramArrayOfByte;
            continue;
            paramString1 = HttpInstrumentation.openConnection((URL)paramString1);
          }
          else
          {
            paramString1 = paramArrayOfByte;
          }
        }
        localHttpURLConnection.disconnect();
        return paramString1;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
      paramString1 = null;
    }
    paramArrayOfByte.printStackTrace();
    return paramString1;
  }
  
  public static String httpsGet(String paramString, SSLSocketFactory paramSSLSocketFactory)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
    ConnManagerParams.setTimeout(localBasicHttpParams, 10000L);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", paramSSLSocketFactory, 443));
    paramSSLSocketFactory = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
    u.e("url", paramString);
    try
    {
      paramString = new HttpGet(new URI(paramString));
      if (!(paramSSLSocketFactory instanceof HttpClient)) {}
      for (paramString = paramSSLSocketFactory.execute(paramString);; paramString = ApacheHttpClientInstrumentation.execute((HttpClient)paramSSLSocketFactory, paramString))
      {
        d.e("statuscode --", paramString.getStatusLine().getStatusCode() + "");
        if (paramString.getStatusLine().getStatusCode() != 200) {
          break;
        }
        paramString = paramString.getEntity();
        if (paramString == null) {
          break;
        }
        paramString = EntityUtils.toString(paramString, "UTF-8");
        u.e("net", paramString);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String httpsPost(String paramString, Map<String, Object> paramMap, Context paramContext, SSLSocketFactory paramSSLSocketFactory)
  {
    u.e("url", paramString + paramMap);
    paramContext = new BasicHttpParams();
    HttpProtocolParams.setVersion(paramContext, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(paramContext, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue(paramContext, true);
    ConnManagerParams.setTimeout(paramContext, 10000L);
    HttpConnectionParams.setConnectionTimeout(paramContext, 10000);
    HttpConnectionParams.setSoTimeout(paramContext, 10000);
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ((SchemeRegistry)localObject).register(new Scheme("https", paramSSLSocketFactory, 443));
    paramContext = new DefaultHttpClient(new ThreadSafeClientConnManager(paramContext, (SchemeRegistry)localObject), paramContext);
    paramSSLSocketFactory = new ArrayList();
    new e();
    if ((paramMap == null) || ((paramMap != null) && (!paramMap.isEmpty())))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        if (((Map.Entry)localObject).getValue() == null) {
          paramSSLSocketFactory.add(new BasicNameValuePair((String)((Map.Entry)localObject).getKey(), ""));
        } else {
          paramSSLSocketFactory.add(new BasicNameValuePair((String)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue().toString()));
        }
      }
    }
    try
    {
      paramString = new HttpPost(new URI(paramString));
      paramMap = new UrlEncodedFormEntity(paramSSLSocketFactory, "UTF-8");
      paramString.setEntity(paramMap);
      if (!(paramContext instanceof HttpClient)) {}
      for (paramString = paramContext.execute(paramString);; paramString = ApacheHttpClientInstrumentation.execute((HttpClient)paramContext, paramString))
      {
        u.e("code ==========", paramString.getStatusLine().getStatusCode() + " ");
        if (paramString.getStatusLine().getStatusCode() != 200) {
          break;
        }
        paramString = paramString.getEntity();
        u.e("entity ==========", paramMap.toString() + " ");
        if (paramMap == null) {
          break;
        }
        paramString = EntityUtils.toString(paramString);
        u.e("net", paramString);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */