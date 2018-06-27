package com.freelxl.baselibrary.e;

import android.os.Build.VERSION;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@Instrumented
public class f
{
  private a a;
  
  public f()
  {
    if (this.a == null)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.a = new e();
      }
    }
    else {
      return;
    }
    this.a = new c();
  }
  
  public static boolean httpGetImg(String paramString)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    com.freelxl.baselibrary.f.d.e("url = ", paramString);
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
  
  public String request(h paramh)
    throws Exception
  {
    if (paramh == null) {
      throw new Exception("HTTP Request is null");
    }
    Object localObject1;
    Object localObject2;
    HashMap localHashMap;
    switch (paramh.getMethod())
    {
    case 2: 
    case 3: 
    case 7: 
    default: 
      return "";
    case 0: 
      try
      {
        paramh = this.a.httpGet(paramh);
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    case 1: 
      try
      {
        paramh = this.a.httpPost(paramh);
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    case 4: 
      try
      {
        paramh = this.a.httpGet(paramh);
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    case 5: 
      try
      {
        paramh = this.a.httpPost(paramh);
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    case 6: 
      try
      {
        paramh = this.a.httpGet(paramh);
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    case 8: 
      try
      {
        paramh = com.freelxl.baselibrary.f.a.c.createEncryption("DES").decrypt(this.a.httpGet(paramh), "", "");
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    case 9: 
      localObject1 = com.freelxl.baselibrary.f.a.c.createEncryption("DES");
      localObject2 = paramh.b();
      localObject1 = ((com.freelxl.baselibrary.f.a.d)localObject1).encrypt(com.alibaba.fastjson.a.toJSONString(localObject2), "vpRZ1kmU", "ZiR00mYi");
      localObject2 = com.freelxl.baselibrary.f.h.toMd5(com.alibaba.fastjson.a.toJSONString(localObject2).getBytes());
      localHashMap = new HashMap();
      localHashMap.put("p", localObject1);
      localHashMap.put("sign", localObject2);
      paramh.setParams(localHashMap);
      try
      {
        paramh = this.a.httpPost(paramh);
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    case 11: 
      localObject1 = com.freelxl.baselibrary.f.a.c.createEncryption("DES");
      localObject2 = paramh.b();
      localObject1 = ((com.freelxl.baselibrary.f.a.d)localObject1).encrypt(com.alibaba.fastjson.a.toJSONString(localObject2), "vpRZ1kmU", "ZiR00mYi");
      localObject2 = com.freelxl.baselibrary.f.h.toMd5(com.alibaba.fastjson.a.toJSONString(localObject2).getBytes());
      localHashMap = new HashMap();
      localHashMap.put("p", localObject1);
      localHashMap.put("sign", localObject2);
      paramh.setParams(localHashMap);
      try
      {
        paramh = this.a.httpPost(paramh);
        return paramh;
      }
      catch (Exception paramh)
      {
        paramh.printStackTrace();
        return "";
      }
    }
    return this.a.httpsPost(paramh);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */