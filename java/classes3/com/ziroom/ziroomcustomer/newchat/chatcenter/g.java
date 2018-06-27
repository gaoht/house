package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.ziroom.ziroomcustomer.util.u;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class g
{
  private static String a(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    StringBuffer localStringBuffer = new StringBuffer();
    JSONObject localJSONObject = new JSONObject();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = String.valueOf(paramMap.get(str1));
      localStringBuffer.append(str1).append('=').append(str2).append('&');
      try
      {
        localJSONObject.put(str1, str2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    try
    {
      paramMap = localStringBuffer.toString();
      return paramMap;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
    return null;
  }
  
  public static String sendHttpPost(Context paramContext, String paramString, Map<String, Object> paramMap)
    throws IOException
  {
    localObject = null;
    u.e("dssgd", "请求方法:" + paramString);
    for (;;)
    {
      try
      {
        paramContext = a(paramMap);
        u.e("HTTPUTIL", "请求的参数:" + paramContext);
        paramContext.getBytes(Charset.forName("UTF-8"));
        paramContext = new URL(paramString);
        if ((paramContext instanceof URL)) {
          continue;
        }
        paramContext = paramContext.openConnection();
        paramContext = (HttpURLConnection)paramContext;
        try
        {
          paramContext.setConnectTimeout(10000);
          paramContext.setReadTimeout(10000);
          paramContext.setRequestMethod("POST");
          paramContext.setRequestProperty("Connection", "Close");
          paramContext.setRequestProperty("Charset", "utf-8");
          paramContext.setRequestProperty("Content-Type", "application/json");
          paramContext.setUseCaches(false);
          paramString = a.toJSONBytes(paramMap, new SerializerFeature[0]);
          if (paramString != null)
          {
            paramContext.setRequestProperty("Content-Length", String.valueOf(paramString.length));
            paramContext.setDoOutput(true);
            paramMap = paramContext.getOutputStream();
            localObject = new BufferedOutputStream(paramMap);
            ((OutputStream)localObject).write(paramString);
            ((OutputStream)localObject).flush();
            ((OutputStream)localObject).close();
            paramMap.close();
          }
          paramContext.connect();
          int i = paramContext.getResponseCode();
          u.e("HTTPUTIL", "返回的状态码:" + i);
          if (i != 200) {
            continue;
          }
          paramString = paramContext.getInputStream();
          paramMap = new BufferedReader(new InputStreamReader(paramString));
          localObject = new StringBuilder();
          String str = paramMap.readLine();
          if (str == null) {
            continue;
          }
          ((StringBuilder)localObject).append(str);
          continue;
          if (paramContext == null) {
            continue;
          }
        }
        finally {}
      }
      finally
      {
        paramContext = (Context)localObject;
        continue;
      }
      paramContext.disconnect();
      throw paramString;
      paramContext = HttpInstrumentation.openConnection((URL)paramContext);
    }
    localObject = ((StringBuilder)localObject).toString();
    u.e("HTTPUTIL", "返回的结果:" + (String)localObject);
    paramString.close();
    paramMap.close();
    if (paramContext != null) {
      paramContext.disconnect();
    }
    return (String)localObject;
    if (paramContext != null) {
      paramContext.disconnect();
    }
    return null;
  }
  
  public static String sendHttpPut(Context paramContext, String paramString, Map<String, Object> paramMap)
    throws IOException
  {
    localObject = null;
    u.e("dssgd", "请求方法:" + paramString);
    for (;;)
    {
      try
      {
        paramContext = a(paramMap);
        u.e("HTTPUTIL", "请求的参数:" + paramContext);
        paramContext.getBytes(Charset.forName("UTF-8"));
        paramContext = new URL(paramString);
        if ((paramContext instanceof URL)) {
          continue;
        }
        paramContext = paramContext.openConnection();
        paramContext = (HttpURLConnection)paramContext;
        try
        {
          paramContext.setConnectTimeout(10000);
          paramContext.setReadTimeout(10000);
          paramContext.setRequestMethod("PUT");
          paramContext.setRequestProperty("Connection", "Close");
          paramContext.setRequestProperty("Charset", "utf-8");
          paramContext.setRequestProperty("Content-Type", "application/json");
          paramContext.setUseCaches(false);
          paramString = a.toJSONBytes(paramMap, new SerializerFeature[0]);
          if (paramString != null)
          {
            paramContext.setRequestProperty("Content-Length", String.valueOf(paramString.length));
            paramContext.setDoOutput(true);
            paramMap = paramContext.getOutputStream();
            localObject = new BufferedOutputStream(paramMap);
            ((OutputStream)localObject).write(paramString);
            ((OutputStream)localObject).flush();
            ((OutputStream)localObject).close();
            paramMap.close();
          }
          paramContext.connect();
          int i = paramContext.getResponseCode();
          u.e("HTTPUTIL", "返回的状态码:" + i);
          if (i != 200) {
            continue;
          }
          paramString = paramContext.getInputStream();
          paramMap = new BufferedReader(new InputStreamReader(paramString));
          localObject = new StringBuilder();
          String str = paramMap.readLine();
          if (str == null) {
            continue;
          }
          ((StringBuilder)localObject).append(str);
          continue;
          if (paramContext == null) {
            continue;
          }
        }
        finally {}
      }
      finally
      {
        paramContext = (Context)localObject;
        continue;
      }
      paramContext.disconnect();
      throw paramString;
      paramContext = HttpInstrumentation.openConnection((URL)paramContext);
    }
    localObject = ((StringBuilder)localObject).toString();
    u.e("HTTPUTIL", "返回的结果:" + (String)localObject);
    paramString.close();
    paramMap.close();
    if (paramContext != null) {
      paramContext.disconnect();
    }
    return (String)localObject;
    if (paramContext != null) {
      paramContext.disconnect();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */