package com.mob.tools.network;

import android.content.Context;
import android.os.Build.VERSION;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.conn.ssl.SSLSocketFactory;

@Instrumented
public class NetworkHelper
{
  public static int connectionTimeout;
  public static int readTimout;
  
  private HttpURLConnection getConnection(String paramString, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    paramString = new URL(paramString);
    if (!(paramString instanceof URL)) {
      paramString = paramString.openConnection();
    }
    for (;;)
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramString;
      try
      {
        paramString = ReflectHelper.getInstanceField(localHttpURLConnection, "methodTokens");
        if (paramString == null)
        {
          try
          {
            localObject1 = ReflectHelper.getStaticField("HttpURLConnection", "PERMITTED_USER_METHODS");
            paramString = "PERMITTED_USER_METHODS";
            i = 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Object localObject1;
              SimpleX509TrustManager localSimpleX509TrustManager;
              SecureRandom localSecureRandom;
              localObject2 = "PERMITTED_USER_METHODS";
              i = 1;
              str = paramString;
              paramString = (String)localObject2;
              continue;
              ReflectHelper.setInstanceField(localHttpURLConnection, paramString, localObject2);
              continue;
              i = paramNetworkTimeOut.connectionTimeout;
              continue;
              i = paramNetworkTimeOut.readTimout;
            }
          }
          if (localObject1 != null)
          {
            localObject1 = (String[])localObject1;
            localObject2 = new String[localObject1.length + 1];
            System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
            localObject2[localObject1.length] = "PATCH";
            if (i != 0) {
              ReflectHelper.setStaticField("HttpURLConnection", paramString, localObject2);
            }
          }
          else
          {
            if (Build.VERSION.SDK_INT < 8) {
              System.setProperty("http.keepAlive", "false");
            }
            if ((localHttpURLConnection instanceof HttpsURLConnection))
            {
              paramString = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
              localObject1 = (HttpsURLConnection)localHttpURLConnection;
              localObject2 = SSLContext.getInstance("TLS");
              localSimpleX509TrustManager = new SimpleX509TrustManager(null);
              localSecureRandom = new SecureRandom();
              ((SSLContext)localObject2).init(null, new TrustManager[] { localSimpleX509TrustManager }, localSecureRandom);
              ((HttpsURLConnection)localObject1).setSSLSocketFactory(((SSLContext)localObject2).getSocketFactory());
              ((HttpsURLConnection)localObject1).setHostnameVerifier(paramString);
            }
            if (paramNetworkTimeOut != null) {
              break label288;
            }
            i = connectionTimeout;
            if (i > 0) {
              localHttpURLConnection.setConnectTimeout(i);
            }
            if (paramNetworkTimeOut != null) {
              break label296;
            }
            i = readTimout;
            if (i > 0) {
              localHttpURLConnection.setReadTimeout(i);
            }
            return localHttpURLConnection;
            paramString = HttpInstrumentation.openConnection((URL)paramString);
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString = null;
          continue;
          label288:
          label296:
          Object localObject2 = "methodTokens";
          int i = 0;
          String str = paramString;
          paramString = (String)localObject2;
        }
      }
    }
  }
  
  private HTTPPart getDataPostHttpPart(HttpURLConnection paramHttpURLConnection, String paramString, byte[] paramArrayOfByte)
    throws Throwable
  {
    paramHttpURLConnection = new ByteArrayPart();
    paramHttpURLConnection.append(paramArrayOfByte);
    return paramHttpURLConnection;
  }
  
  private HTTPPart getFilePostHTTPPart(HttpURLConnection paramHttpURLConnection, String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2)
    throws Throwable
  {
    String str = UUID.randomUUID().toString();
    paramHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
    MultiPart localMultiPart = new MultiPart();
    paramHttpURLConnection = new StringPart();
    if (paramArrayList1 != null)
    {
      paramString = paramArrayList1.iterator();
      while (paramString.hasNext())
      {
        paramArrayList1 = (KVPair)paramString.next();
        paramHttpURLConnection.append("--").append(str).append("\r\n");
        paramHttpURLConnection.append("Content-Disposition: form-data; name=\"").append(paramArrayList1.name).append("\"\r\n\r\n");
        paramHttpURLConnection.append((String)paramArrayList1.value).append("\r\n");
      }
    }
    localMultiPart.append(paramHttpURLConnection);
    paramArrayList1 = paramArrayList2.iterator();
    if (paramArrayList1.hasNext())
    {
      paramArrayList2 = (KVPair)paramArrayList1.next();
      StringPart localStringPart = new StringPart();
      paramHttpURLConnection = new File((String)paramArrayList2.value);
      localStringPart.append("--").append(str).append("\r\n");
      localStringPart.append("Content-Disposition: form-data; name=\"").append(paramArrayList2.name).append("\"; filename=\"").append(paramHttpURLConnection.getName()).append("\"\r\n");
      paramString = URLConnection.getFileNameMap().getContentTypeFor((String)paramArrayList2.value);
      if (paramString != null)
      {
        paramHttpURLConnection = paramString;
        if (paramString.length() > 0) {}
      }
      else
      {
        if ((!((String)paramArrayList2.value).toLowerCase().endsWith("jpg")) && (!((String)paramArrayList2.value).toLowerCase().endsWith("jpeg"))) {
          break label397;
        }
        paramHttpURLConnection = "image/jpeg";
      }
      for (;;)
      {
        localStringPart.append("Content-Type: ").append(paramHttpURLConnection).append("\r\n\r\n");
        localMultiPart.append(localStringPart);
        paramHttpURLConnection = new FilePart();
        paramHttpURLConnection.setFile((String)paramArrayList2.value);
        localMultiPart.append(paramHttpURLConnection);
        paramHttpURLConnection = new StringPart();
        paramHttpURLConnection.append("\r\n");
        localMultiPart.append(paramHttpURLConnection);
        break;
        label397:
        if (((String)paramArrayList2.value).toLowerCase().endsWith("png"))
        {
          paramHttpURLConnection = "image/png";
        }
        else if (((String)paramArrayList2.value).toLowerCase().endsWith("gif"))
        {
          paramHttpURLConnection = "image/gif";
        }
        else
        {
          paramHttpURLConnection = new FileInputStream((String)paramArrayList2.value);
          paramString = URLConnection.guessContentTypeFromStream(paramHttpURLConnection);
          paramHttpURLConnection.close();
          if (paramString != null)
          {
            paramHttpURLConnection = paramString;
            if (paramString.length() > 0) {}
          }
          else
          {
            paramHttpURLConnection = "application/octet-stream";
          }
        }
      }
    }
    paramHttpURLConnection = new StringPart();
    paramHttpURLConnection.append("--").append(str).append("--\r\n");
    localMultiPart.append(paramHttpURLConnection);
    return localMultiPart;
  }
  
  private Object getHttpPatch(String paramString)
    throws Throwable
  {
    HttpEntityEnclosingRequestBase local5 = new HttpEntityEnclosingRequestBase()
    {
      public String getMethod()
      {
        return "PATCH";
      }
    };
    ReflectHelper.invokeInstanceMethod(local5, "setURI", new Object[] { URI.create(paramString) });
    return local5;
  }
  
  private HTTPPart getTextPostHTTPPart(HttpURLConnection paramHttpURLConnection, String paramString, ArrayList<KVPair<String>> paramArrayList)
    throws Throwable
  {
    paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    paramHttpURLConnection = new StringPart();
    if (paramArrayList != null) {
      paramHttpURLConnection.append(kvPairsToUrl(paramArrayList));
    }
    return paramHttpURLConnection;
  }
  
  private void httpPatchImpl(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, long paramLong, ArrayList<KVPair<String>> paramArrayList2, OnReadListener paramOnReadListener, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPatch: " + paramString, new Object[0]);
    ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
    ReflectHelper.importClass("org.apache.http.params.BasicHttpParams");
    ReflectHelper.importClass("org.apache.http.params.HttpConnectionParams");
    ReflectHelper.importClass("org.apache.http.HttpVersion");
    ReflectHelper.importClass("org.apache.http.params.HttpProtocolParams");
    ReflectHelper.importClass("org.apache.http.conn.scheme.SchemeRegistry");
    ReflectHelper.importClass("org.apache.http.conn.scheme.PlainSocketFactory");
    ReflectHelper.importClass("org.apache.http.conn.scheme.Scheme");
    ReflectHelper.importClass("org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager");
    ReflectHelper.importClass("org.apache.http.impl.client.DefaultHttpClient");
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = getHttpPatch(str);
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (KVPair)paramString.next();
        ReflectHelper.invokeInstanceMethod(paramArrayList1, "setHeader", new Object[] { paramArrayList2.name, paramArrayList2.value });
      }
    }
    paramString = new FilePart();
    paramString.setOnReadListener(paramOnReadListener);
    paramString.setFile((String)paramKVPair.value);
    paramString.setOffset(paramLong);
    paramString = ReflectHelper.newInstance("InputStreamEntity", new Object[] { paramString.toInputStream(), Long.valueOf(paramString.length() - paramLong) });
    ReflectHelper.invokeInstanceMethod(paramString, "setContentEncoding", new Object[] { "application/offset+octet-stream" });
    ReflectHelper.invokeInstanceMethod(paramArrayList1, "setEntity", new Object[] { paramString });
    paramString = ReflectHelper.newInstance("BasicHttpParams", new Object[0]);
    int i;
    int j;
    if (paramNetworkTimeOut == null)
    {
      i = connectionTimeout;
      if (i > 0) {
        ReflectHelper.invokeStaticMethod("HttpConnectionParams", "setConnectionTimeout", new Object[] { paramString, Integer.valueOf(i) });
      }
      if (paramNetworkTimeOut != null) {
        break label798;
      }
      j = readTimout;
      label382:
      if (j > 0) {
        ReflectHelper.invokeStaticMethod("HttpConnectionParams", "setSoTimeout", new Object[] { paramString, Integer.valueOf(i) });
      }
      ReflectHelper.invokeInstanceMethod(paramArrayList1, "setParams", new Object[] { paramString });
      if (!str.startsWith("https://")) {
        break label808;
      }
      paramString = KeyStore.getInstance(KeyStore.getDefaultType());
      paramString.load(null, null);
      paramOnReadListener = new SSLSocketFactoryEx(paramString);
      paramOnReadListener.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      paramString = ReflectHelper.newInstance("BasicHttpParams", new Object[0]);
      ReflectHelper.invokeStaticMethod("HttpProtocolParams", "setVersion", new Object[] { paramString, ReflectHelper.getStaticField("HttpVersion", "HTTP_1_1") });
      ReflectHelper.invokeStaticMethod("HttpProtocolParams", "setContentCharset", new Object[] { paramString, "UTF-8" });
      paramKVPair = ReflectHelper.newInstance("SchemeRegistry", new Object[0]);
      paramArrayList2 = ReflectHelper.newInstance("Scheme", new Object[] { "http", ReflectHelper.invokeStaticMethod("PlainSocketFactory", "getSocketFactory", new Object[0]), Integer.valueOf(80) });
      paramOnReadListener = ReflectHelper.newInstance("Scheme", new Object[] { "https", paramOnReadListener, Integer.valueOf(443) });
      ReflectHelper.invokeInstanceMethod(paramKVPair, "register", new Object[] { paramArrayList2 });
      ReflectHelper.invokeInstanceMethod(paramKVPair, "register", new Object[] { paramOnReadListener });
      paramString = ReflectHelper.newInstance("DefaultHttpClient", new Object[] { ReflectHelper.newInstance("ThreadSafeClientConnManager", new Object[] { paramString, paramKVPair }), paramString });
      label691:
      paramArrayList1 = ReflectHelper.invokeInstanceMethod(paramString, "execute", new Object[] { paramArrayList1 });
      paramString = ReflectHelper.invokeInstanceMethod(paramString, "getConnectionManager", new Object[0]);
      if (paramHttpResponseCallback == null) {
        break label840;
      }
    }
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl(paramArrayList1));
        ReflectHelper.invokeInstanceMethod(paramString, "shutdown", new Object[0]);
        return;
      }
      catch (Throwable paramArrayList1)
      {
        label798:
        label808:
        throw paramArrayList1;
      }
      finally
      {
        ReflectHelper.invokeInstanceMethod(paramString, "shutdown", new Object[0]);
      }
      i = paramNetworkTimeOut.connectionTimeout;
      break;
      j = paramNetworkTimeOut.readTimout;
      break label382;
      paramString = ReflectHelper.newInstance("DefaultHttpClient", new Object[0]);
      break label691;
      label840:
      ReflectHelper.invokeInstanceMethod(paramString, "shutdown", new Object[0]);
    }
  }
  
  private String kvPairsToUrl(ArrayList<KVPair<String>> paramArrayList)
    throws Throwable
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      paramArrayList = (KVPair)localIterator.next();
      String str = Data.urlEncode(paramArrayList.name, "utf-8");
      if (paramArrayList.value != null) {}
      for (paramArrayList = Data.urlEncode((String)paramArrayList.value, "utf-8");; paramArrayList = "")
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append(str).append('=').append(paramArrayList);
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public String downloadCache(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    return downloadCache(paramContext, paramString1, paramString2, paramBoolean, paramNetworkTimeOut, null);
  }
  
  public String downloadCache(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, NetworkTimeOut paramNetworkTimeOut, FileDownloadListener paramFileDownloadListener)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("downloading: " + paramString1, new Object[0]);
    Object localObject;
    if (paramBoolean)
    {
      localObject = new File(ResHelper.getCachePath(paramContext, paramString2), Data.MD5(paramString1));
      if ((paramBoolean) && (((File)localObject).exists()))
      {
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        if (paramFileDownloadListener != null) {
          paramFileDownloadListener.onProgress(100, ((File)localObject).length(), ((File)localObject).length());
        }
        return ((File)localObject).getAbsolutePath();
      }
    }
    HttpURLConnection localHttpURLConnection = getConnection(paramString1, paramNetworkTimeOut);
    localHttpURLConnection.connect();
    int i = localHttpURLConnection.getResponseCode();
    int j;
    if (i == 200)
    {
      Map localMap = localHttpURLConnection.getHeaderFields();
      if (localMap != null)
      {
        paramNetworkTimeOut = (List)localMap.get("Content-Disposition");
        if ((paramNetworkTimeOut != null) && (paramNetworkTimeOut.size() > 0))
        {
          String[] arrayOfString = ((String)paramNetworkTimeOut.get(0)).split(";");
          j = arrayOfString.length;
          paramNetworkTimeOut = null;
          i = 0;
          for (;;)
          {
            localObject = paramNetworkTimeOut;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i];
            if (((String)localObject).trim().startsWith("filename"))
            {
              localObject = localObject.split("=")[1];
              paramNetworkTimeOut = (NetworkTimeOut)localObject;
              if (((String)localObject).startsWith("\""))
              {
                paramNetworkTimeOut = (NetworkTimeOut)localObject;
                if (((String)localObject).endsWith("\"")) {
                  paramNetworkTimeOut = ((String)localObject).substring(1, ((String)localObject).length() - 1);
                }
              }
            }
            i += 1;
          }
        }
      }
      localObject = null;
      paramNetworkTimeOut = (NetworkTimeOut)localObject;
      if (localObject == null)
      {
        localObject = Data.MD5(paramString1);
        if (localMap == null) {
          break label1119;
        }
        paramNetworkTimeOut = (List)localMap.get("Content-Type");
        if ((paramNetworkTimeOut == null) || (paramNetworkTimeOut.size() <= 0)) {
          break label1119;
        }
        paramNetworkTimeOut = (String)paramNetworkTimeOut.get(0);
        if (paramNetworkTimeOut != null) {
          break label576;
        }
        paramNetworkTimeOut = "";
        if (!paramNetworkTimeOut.startsWith("image/")) {
          break label586;
        }
        paramNetworkTimeOut = paramNetworkTimeOut.substring("image/".length());
        localObject = new StringBuilder().append((String)localObject).append(".");
        paramString1 = paramNetworkTimeOut;
        if ("jpeg".equals(paramNetworkTimeOut)) {
          paramString1 = "jpg";
        }
        paramNetworkTimeOut = paramString1;
      }
    }
    for (;;)
    {
      paramContext = new File(ResHelper.getCachePath(paramContext, paramString2), paramNetworkTimeOut);
      if ((paramBoolean) && (paramContext.exists()))
      {
        localHttpURLConnection.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        if (paramFileDownloadListener != null) {
          paramFileDownloadListener.onProgress(100, paramContext.length(), paramContext.length());
        }
        return paramContext.getAbsolutePath();
        label576:
        paramNetworkTimeOut = paramNetworkTimeOut.trim();
        break;
        label586:
        i = paramString1.lastIndexOf('/');
        paramNetworkTimeOut = null;
        if (i > 0) {
          paramNetworkTimeOut = paramString1.substring(i + 1);
        }
        if ((paramNetworkTimeOut == null) || (paramNetworkTimeOut.length() <= 0)) {
          break label1119;
        }
        i = paramNetworkTimeOut.lastIndexOf('.');
        if ((i <= 0) || (paramNetworkTimeOut.length() - i >= 10)) {
          break label1119;
        }
        paramNetworkTimeOut = (String)localObject + paramNetworkTimeOut.substring(i);
        continue;
      }
      if (!paramContext.getParentFile().exists()) {
        paramContext.getParentFile().mkdirs();
      }
      if (paramContext.exists()) {
        paramContext.delete();
      }
      if (paramFileDownloadListener != null) {}
      try
      {
        if (paramFileDownloadListener.isCanceled())
        {
          if (!paramContext.exists()) {
            break label1126;
          }
          paramContext.delete();
          break label1126;
        }
        paramString1 = localHttpURLConnection.getInputStream();
        int k = localHttpURLConnection.getContentLength();
        paramString2 = new FileOutputStream(paramContext);
        paramNetworkTimeOut = new byte['Ѐ'];
        j = 0;
        for (i = paramString1.read(paramNetworkTimeOut);; i = paramString1.read(paramNetworkTimeOut))
        {
          if (i > 0)
          {
            paramString2.write(paramNetworkTimeOut, 0, i);
            j += i;
            if (paramFileDownloadListener == null) {
              continue;
            }
            if (k > 0) {
              break label875;
            }
          }
          label875:
          for (i = 100;; i = j * 100 / k)
          {
            paramFileDownloadListener.onProgress(i, j, k);
            if (!paramFileDownloadListener.isCanceled()) {
              break;
            }
            if (paramFileDownloadListener == null) {
              break label914;
            }
            if (!paramFileDownloadListener.isCanceled()) {
              break label899;
            }
            if (paramContext.exists()) {
              paramContext.delete();
            }
            paramString2.flush();
            paramString1.close();
            paramString2.close();
            return null;
          }
        }
        label899:
        paramFileDownloadListener.onProgress(100, paramContext.length(), paramContext.length());
        label914:
        paramString2.flush();
        paramString1.close();
        paramString2.close();
        localHttpURLConnection.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return paramContext.getAbsolutePath();
      }
      catch (Throwable paramString1)
      {
        if (paramContext.exists()) {
          paramContext.delete();
        }
        throw paramString1;
      }
      paramString1 = new StringBuilder();
      paramString2 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getErrorStream(), Charset.forName("utf-8")));
      for (paramContext = paramString2.readLine(); paramContext != null; paramContext = paramString2.readLine())
      {
        if (paramString1.length() > 0) {
          paramString1.append('\n');
        }
        paramString1.append(paramContext);
      }
      paramString2.close();
      localHttpURLConnection.disconnect();
      paramContext = new HashMap();
      paramContext.put("error", paramString1.toString());
      paramContext.put("status", Integer.valueOf(i));
      throw new Throwable(new Hashon().fromHashMap(paramContext));
      label1119:
      paramNetworkTimeOut = (NetworkTimeOut)localObject;
    }
    label1126:
    return null;
  }
  
  public void getHttpPostResponse(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPost: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    paramNetworkTimeOut.setDoOutput(true);
    paramNetworkTimeOut.setChunkedStreamingMode(0);
    ArrayList localArrayList;
    if ((paramKVPair != null) && (paramKVPair.value != null) && (new File((String)paramKVPair.value).exists()))
    {
      localArrayList = new ArrayList();
      localArrayList.add(paramKVPair);
    }
    for (paramString = getFilePostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1, localArrayList); paramArrayList2 != null; paramString = getTextPostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1))
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramKVPair = (KVPair)paramArrayList1.next();
        paramNetworkTimeOut.setRequestProperty(paramKVPair.name, (String)paramKVPair.value);
      }
    }
    paramNetworkTimeOut.connect();
    paramArrayList1 = paramNetworkTimeOut.getOutputStream();
    paramString = paramString.toInputStream();
    paramKVPair = new byte[65536];
    for (int i = paramString.read(paramKVPair); i > 0; i = paramString.read(paramKVPair)) {
      paramArrayList1.write(paramKVPair, 0, i);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramNetworkTimeOut));
        paramNetworkTimeOut.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      finally
      {
        paramNetworkTimeOut.disconnect();
      }
      paramNetworkTimeOut.disconnect();
    }
  }
  
  public String httpGet(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpGet: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = getConnection(str, paramNetworkTimeOut);
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (KVPair)paramString.next();
        paramArrayList1.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramArrayList1.connect();
    int i = paramArrayList1.getResponseCode();
    if (i == 200)
    {
      paramArrayList2 = new StringBuilder();
      paramNetworkTimeOut = new BufferedReader(new InputStreamReader(paramArrayList1.getInputStream(), Charset.forName("utf-8")));
      for (paramString = paramNetworkTimeOut.readLine(); paramString != null; paramString = paramNetworkTimeOut.readLine())
      {
        if (paramArrayList2.length() > 0) {
          paramArrayList2.append('\n');
        }
        paramArrayList2.append(paramString);
      }
      paramNetworkTimeOut.close();
      paramArrayList1.disconnect();
      paramString = paramArrayList2.toString();
      MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramArrayList2 = new StringBuilder();
    paramNetworkTimeOut = new BufferedReader(new InputStreamReader(paramArrayList1.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramNetworkTimeOut.readLine(); paramString != null; paramString = paramNetworkTimeOut.readLine())
    {
      if (paramArrayList2.length() > 0) {
        paramArrayList2.append('\n');
      }
      paramArrayList2.append(paramString);
    }
    paramNetworkTimeOut.close();
    paramArrayList1.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramArrayList2.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramString));
  }
  
  public ArrayList<KVPair<String[]>> httpHead(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpHead: " + paramString, new Object[0]);
    paramKVPair = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      paramKVPair = paramString;
      if (paramArrayList1.length() > 0) {
        paramKVPair = paramString + "?" + paramArrayList1;
      }
    }
    paramString = getConnection(paramKVPair, paramNetworkTimeOut);
    paramString.setRequestMethod("HEAD");
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramKVPair = (KVPair)paramArrayList1.next();
        paramString.setRequestProperty(paramKVPair.name, (String)paramKVPair.value);
      }
    }
    paramString.connect();
    paramKVPair = paramString.getHeaderFields();
    paramArrayList1 = new ArrayList();
    if (paramKVPair != null)
    {
      paramKVPair = paramKVPair.entrySet().iterator();
      while (paramKVPair.hasNext())
      {
        paramArrayList2 = (Map.Entry)paramKVPair.next();
        paramNetworkTimeOut = (List)paramArrayList2.getValue();
        if (paramNetworkTimeOut == null)
        {
          paramArrayList1.add(new KVPair((String)paramArrayList2.getKey(), new String[0]));
        }
        else
        {
          String[] arrayOfString = new String[paramNetworkTimeOut.size()];
          int i = 0;
          while (i < arrayOfString.length)
          {
            arrayOfString[i] = ((String)paramNetworkTimeOut.get(i));
            i += 1;
          }
          paramArrayList1.add(new KVPair((String)paramArrayList2.getKey(), arrayOfString));
        }
      }
    }
    paramString.disconnect();
    MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
    return paramArrayList1;
  }
  
  public void httpPatch(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, long paramLong, ArrayList<KVPair<String>> paramArrayList2, OnReadListener paramOnReadListener, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      httpPatchImpl23(paramString, paramArrayList1, paramKVPair, paramLong, paramArrayList2, paramOnReadListener, paramHttpResponseCallback, paramNetworkTimeOut);
      return;
    }
    httpPatchImpl(paramString, paramArrayList1, paramKVPair, paramLong, paramArrayList2, paramOnReadListener, paramHttpResponseCallback, paramNetworkTimeOut);
  }
  
  public void httpPatchImpl23(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, long paramLong, ArrayList<KVPair<String>> paramArrayList2, OnReadListener paramOnReadListener, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPatch: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramString = getConnection(str, paramNetworkTimeOut);
    paramString.setDoOutput(true);
    paramString.setChunkedStreamingMode(0);
    paramString.setRequestMethod("PATCH");
    paramString.setRequestProperty("Content-Type", "application/offset+octet-stream");
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (KVPair)paramArrayList1.next();
        paramString.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramString.connect();
    paramArrayList1 = paramString.getOutputStream();
    paramArrayList2 = new FilePart();
    paramArrayList2.setOnReadListener(paramOnReadListener);
    paramArrayList2.setFile((String)paramKVPair.value);
    paramArrayList2.setOffset(paramLong);
    paramKVPair = paramArrayList2.toInputStream();
    paramArrayList2 = new byte[65536];
    for (int i = paramKVPair.read(paramArrayList2); i > 0; i = paramKVPair.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, i);
    }
    paramArrayList1.flush();
    paramKVPair.close();
    paramArrayList1.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramString));
        paramString.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList1)
      {
        throw paramArrayList1;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  public String httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList, int paramInt, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    final HashMap localHashMap = new HashMap();
    httpPost(paramString, paramArrayList, paramInt, new HttpResponseCallback()
    {
      public void onResponse(HttpConnection paramAnonymousHttpConnection)
        throws Throwable
      {
        int i = paramAnonymousHttpConnection.getResponseCode();
        if ((i == 200) || (i < 300))
        {
          localStringBuilder = new StringBuilder();
          localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getInputStream(), Charset.forName("utf-8")));
          for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append('\n');
            }
            localStringBuilder.append(paramAnonymousHttpConnection);
          }
          localBufferedReader.close();
          localHashMap.put("resp", localStringBuilder.toString());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getErrorStream(), Charset.forName("utf-8")));
        for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append('\n');
          }
          localStringBuilder.append(paramAnonymousHttpConnection);
        }
        localBufferedReader.close();
        paramAnonymousHttpConnection = new HashMap();
        paramAnonymousHttpConnection.put("error", localStringBuilder.toString());
        paramAnonymousHttpConnection.put("status", Integer.valueOf(i));
        throw new Throwable(new Hashon().fromHashMap(paramAnonymousHttpConnection));
      }
    }, paramNetworkTimeOut);
    return (String)localHashMap.get("resp");
  }
  
  public String httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, int paramInt, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramKVPair != null) && (paramKVPair.value != null) && (new File((String)paramKVPair.value).exists())) {
      localArrayList.add(paramKVPair);
    }
    return httpPostFiles(paramString, paramArrayList1, localArrayList, paramArrayList2, paramInt, paramNetworkTimeOut);
  }
  
  public String httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    return httpPost(paramString, paramArrayList1, paramKVPair, paramArrayList2, 0, paramNetworkTimeOut);
  }
  
  public void httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList, int paramInt, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPost: " + paramString, new Object[0]);
    paramString = getConnection(paramString, paramNetworkTimeOut);
    paramString.setDoOutput(true);
    paramString.setRequestProperty("Connection", "Keep-Alive");
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramNetworkTimeOut = (KVPair)paramArrayList.next();
        paramString.setRequestProperty(paramNetworkTimeOut.name, (String)paramNetworkTimeOut.value);
      }
    }
    paramNetworkTimeOut = new StringPart();
    paramNetworkTimeOut.append(null);
    paramString.connect();
    paramArrayList = paramString.getOutputStream();
    paramNetworkTimeOut = paramNetworkTimeOut.toInputStream();
    byte[] arrayOfByte = new byte[65536];
    for (paramInt = paramNetworkTimeOut.read(arrayOfByte); paramInt > 0; paramInt = paramNetworkTimeOut.read(arrayOfByte)) {
      paramArrayList.write(arrayOfByte, 0, paramInt);
    }
    paramArrayList.flush();
    paramNetworkTimeOut.close();
    paramArrayList.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramString));
        paramString.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList)
      {
        throw paramArrayList;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  public void httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, ArrayList<KVPair<String>> paramArrayList3, int paramInt, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPost: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    paramNetworkTimeOut.setDoOutput(true);
    paramNetworkTimeOut.setRequestProperty("Connection", "Keep-Alive");
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramArrayList1 = getFilePostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1, paramArrayList2);
      paramString = paramArrayList1;
      if (paramInt < 0) {
        break label167;
      }
      paramNetworkTimeOut.setChunkedStreamingMode(paramInt);
      paramString = paramArrayList1;
    }
    label167:
    while (paramArrayList3 != null)
    {
      paramArrayList1 = paramArrayList3.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (KVPair)paramArrayList1.next();
        paramNetworkTimeOut.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
      paramString = getTextPostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1);
      paramNetworkTimeOut.setFixedLengthStreamingMode((int)paramString.length());
    }
    paramNetworkTimeOut.connect();
    paramArrayList1 = paramNetworkTimeOut.getOutputStream();
    paramString = paramString.toInputStream();
    paramArrayList2 = new byte[65536];
    for (paramInt = paramString.read(paramArrayList2); paramInt > 0; paramInt = paramString.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, paramInt);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramNetworkTimeOut));
        paramNetworkTimeOut.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      finally
      {
        paramNetworkTimeOut.disconnect();
      }
      paramNetworkTimeOut.disconnect();
    }
  }
  
  public void httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, ArrayList<KVPair<String>> paramArrayList3, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    httpPost(paramString, paramArrayList1, paramArrayList2, paramArrayList3, 0, paramHttpResponseCallback, paramNetworkTimeOut);
  }
  
  public void httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, byte[] paramArrayOfByte, ArrayList<KVPair<String>> paramArrayList2, int paramInt, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPost: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    paramNetworkTimeOut.setDoOutput(true);
    paramNetworkTimeOut.setRequestProperty("Connection", "Keep-Alive");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayList1 = getDataPostHttpPart(paramNetworkTimeOut, paramString, paramArrayOfByte);
      paramString = paramArrayList1;
      if (paramInt < 0) {
        break label164;
      }
      paramNetworkTimeOut.setChunkedStreamingMode(paramInt);
      paramString = paramArrayList1;
    }
    label164:
    while (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayOfByte = (KVPair)paramArrayList1.next();
        paramNetworkTimeOut.setRequestProperty(paramArrayOfByte.name, (String)paramArrayOfByte.value);
      }
      paramString = getTextPostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1);
      paramNetworkTimeOut.setFixedLengthStreamingMode((int)paramString.length());
    }
    paramNetworkTimeOut.connect();
    paramArrayList1 = paramNetworkTimeOut.getOutputStream();
    paramString = paramString.toInputStream();
    paramArrayOfByte = new byte[65536];
    for (paramInt = paramString.read(paramArrayOfByte); paramInt > 0; paramInt = paramString.read(paramArrayOfByte)) {
      paramArrayList1.write(paramArrayOfByte, 0, paramInt);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramNetworkTimeOut));
        paramNetworkTimeOut.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      finally
      {
        paramNetworkTimeOut.disconnect();
      }
      paramNetworkTimeOut.disconnect();
    }
  }
  
  public String httpPostFiles(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, ArrayList<KVPair<String>> paramArrayList3, int paramInt, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    final HashMap localHashMap = new HashMap();
    httpPost(paramString, paramArrayList1, paramArrayList2, paramArrayList3, paramInt, new HttpResponseCallback()
    {
      public void onResponse(HttpConnection paramAnonymousHttpConnection)
        throws Throwable
      {
        int i = paramAnonymousHttpConnection.getResponseCode();
        if ((i == 200) || (i < 300))
        {
          localStringBuilder = new StringBuilder();
          localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getInputStream(), Charset.forName("utf-8")));
          for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append('\n');
            }
            localStringBuilder.append(paramAnonymousHttpConnection);
          }
          localBufferedReader.close();
          localHashMap.put("resp", localStringBuilder.toString());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getErrorStream(), Charset.forName("utf-8")));
        for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append('\n');
          }
          localStringBuilder.append(paramAnonymousHttpConnection);
        }
        localBufferedReader.close();
        paramAnonymousHttpConnection = new HashMap();
        paramAnonymousHttpConnection.put("error", localStringBuilder.toString());
        paramAnonymousHttpConnection.put("status", Integer.valueOf(i));
        throw new Throwable(new Hashon().fromHashMap(paramAnonymousHttpConnection));
      }
    }, paramNetworkTimeOut);
    return (String)localHashMap.get("resp");
  }
  
  public String httpPostFiles(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, ArrayList<KVPair<String>> paramArrayList3, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    return httpPostFiles(paramString, paramArrayList1, paramArrayList2, paramArrayList3, 0, paramNetworkTimeOut);
  }
  
  public String httpPostFilesChecked(String paramString, ArrayList<KVPair<String>> paramArrayList1, byte[] paramArrayOfByte, ArrayList<KVPair<String>> paramArrayList2, int paramInt, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    final HashMap localHashMap = new HashMap();
    httpPost(paramString, paramArrayList1, paramArrayOfByte, paramArrayList2, paramInt, new HttpResponseCallback()
    {
      public void onResponse(HttpConnection paramAnonymousHttpConnection)
        throws Throwable
      {
        int i = paramAnonymousHttpConnection.getResponseCode();
        if ((i == 200) || (i < 300))
        {
          localStringBuilder = new StringBuilder();
          localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getInputStream(), Charset.forName("utf-8")));
          for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append('\n');
            }
            localStringBuilder.append(paramAnonymousHttpConnection);
          }
          localBufferedReader.close();
          localHashMap.put("resp", localStringBuilder.toString());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getErrorStream(), Charset.forName("utf-8")));
        for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append('\n');
          }
          localStringBuilder.append(paramAnonymousHttpConnection);
        }
        localBufferedReader.close();
        paramAnonymousHttpConnection = new HashMap();
        paramAnonymousHttpConnection.put("error", localStringBuilder.toString());
        paramAnonymousHttpConnection.put("status", Integer.valueOf(i));
        throw new Throwable(new Hashon().fromHashMap(paramAnonymousHttpConnection));
      }
    }, paramNetworkTimeOut);
    return (String)localHashMap.get("resp");
  }
  
  public String httpPut(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    return httpPut(paramString, paramArrayList1, paramKVPair, paramArrayList2, paramNetworkTimeOut, null);
  }
  
  public String httpPut(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut, OnReadListener paramOnReadListener)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPut: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = getConnection(str, paramNetworkTimeOut);
    paramArrayList1.setDoOutput(true);
    paramArrayList1.setChunkedStreamingMode(0);
    paramArrayList1.setRequestMethod("PUT");
    paramArrayList1.setRequestProperty("Content-Type", "application/octet-stream");
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (KVPair)paramString.next();
        paramArrayList1.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramArrayList1.connect();
    paramString = paramArrayList1.getOutputStream();
    paramArrayList2 = new FilePart();
    if (paramOnReadListener != null) {
      paramArrayList2.setOnReadListener(paramOnReadListener);
    }
    paramArrayList2.setFile((String)paramKVPair.value);
    paramKVPair = paramArrayList2.toInputStream();
    paramArrayList2 = new byte[65536];
    for (int i = paramKVPair.read(paramArrayList2); i > 0; i = paramKVPair.read(paramArrayList2)) {
      paramString.write(paramArrayList2, 0, i);
    }
    paramString.flush();
    paramKVPair.close();
    paramString.close();
    i = paramArrayList1.getResponseCode();
    if ((i == 200) || (i == 201))
    {
      paramKVPair = new StringBuilder();
      paramArrayList2 = new BufferedReader(new InputStreamReader(paramArrayList1.getInputStream(), Charset.forName("utf-8")));
      for (paramString = paramArrayList2.readLine(); paramString != null; paramString = paramArrayList2.readLine())
      {
        if (paramKVPair.length() > 0) {
          paramKVPair.append('\n');
        }
        paramKVPair.append(paramString);
      }
      paramArrayList2.close();
      paramArrayList1.disconnect();
      paramString = paramKVPair.toString();
      MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramKVPair = new StringBuilder();
    paramArrayList1 = new BufferedReader(new InputStreamReader(paramArrayList1.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramArrayList1.readLine(); paramString != null; paramString = paramArrayList1.readLine())
    {
      if (paramKVPair.length() > 0) {
        paramKVPair.append('\n');
      }
      paramKVPair.append(paramString);
    }
    paramArrayList1.close();
    paramString = new HashMap();
    paramString.put("error", paramKVPair.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramString));
  }
  
  public String jsonPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    final HashMap localHashMap = new HashMap();
    jsonPost(paramString, paramArrayList1, paramArrayList2, paramNetworkTimeOut, new HttpResponseCallback()
    {
      public void onResponse(HttpConnection paramAnonymousHttpConnection)
        throws Throwable
      {
        int i = paramAnonymousHttpConnection.getResponseCode();
        if ((i == 200) || (i == 201))
        {
          localStringBuilder = new StringBuilder();
          localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getInputStream(), Charset.forName("utf-8")));
          for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append('\n');
            }
            localStringBuilder.append(paramAnonymousHttpConnection);
          }
          localBufferedReader.close();
          localHashMap.put("res", localStringBuilder.toString());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getErrorStream(), Charset.forName("utf-8")));
        for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append('\n');
          }
          localStringBuilder.append(paramAnonymousHttpConnection);
        }
        localBufferedReader.close();
        paramAnonymousHttpConnection = new HashMap();
        paramAnonymousHttpConnection.put("error", localStringBuilder.toString());
        paramAnonymousHttpConnection.put("status", Integer.valueOf(i));
        throw new Throwable(new Hashon().fromHashMap(paramAnonymousHttpConnection));
      }
    });
    if (localHashMap.containsKey("res")) {
      return (String)localHashMap.get("res");
    }
    return null;
  }
  
  public void jsonPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut, HttpResponseCallback paramHttpResponseCallback)
    throws Throwable
  {
    HashMap localHashMap = new HashMap();
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      KVPair localKVPair = (KVPair)paramArrayList1.next();
      localHashMap.put(localKVPair.name, localKVPair.value);
    }
    jsonPost(paramString, localHashMap, paramArrayList2, paramNetworkTimeOut, paramHttpResponseCallback);
  }
  
  public void jsonPost(String paramString, HashMap<String, Object> paramHashMap, ArrayList<KVPair<String>> paramArrayList, NetworkTimeOut paramNetworkTimeOut, HttpResponseCallback paramHttpResponseCallback)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("jsonPost: " + paramString, new Object[0]);
    paramString = getConnection(paramString, paramNetworkTimeOut);
    paramString.setDoOutput(true);
    paramString.setChunkedStreamingMode(0);
    paramString.setRequestProperty("content-type", "application/json");
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramNetworkTimeOut = (KVPair)paramArrayList.next();
        paramString.setRequestProperty(paramNetworkTimeOut.name, (String)paramNetworkTimeOut.value);
      }
    }
    paramArrayList = new StringPart();
    if (paramHashMap != null) {
      paramArrayList.append(new Hashon().fromHashMap(paramHashMap));
    }
    paramString.connect();
    paramHashMap = paramString.getOutputStream();
    paramArrayList = paramArrayList.toInputStream();
    paramNetworkTimeOut = new byte[65536];
    for (int i = paramArrayList.read(paramNetworkTimeOut); i > 0; i = paramArrayList.read(paramNetworkTimeOut)) {
      paramHashMap.write(paramNetworkTimeOut, 0, i);
    }
    paramHashMap.flush();
    paramArrayList.close();
    paramHashMap.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramString));
        paramString.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramHashMap)
      {
        throw paramHashMap;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  public void rawGet(String paramString, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    rawGet(paramString, null, paramHttpResponseCallback, paramNetworkTimeOut);
  }
  
  public void rawGet(String paramString, RawNetworkCallback paramRawNetworkCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    rawGet(paramString, null, paramRawNetworkCallback, paramNetworkTimeOut);
  }
  
  public void rawGet(String paramString, ArrayList<KVPair<String>> paramArrayList, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("rawGet: " + paramString, new Object[0]);
    paramString = getConnection(paramString, paramNetworkTimeOut);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramNetworkTimeOut = (KVPair)paramArrayList.next();
        paramString.setRequestProperty(paramNetworkTimeOut.name, (String)paramNetworkTimeOut.value);
      }
    }
    paramString.connect();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramString));
        paramString.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList)
      {
        throw paramArrayList;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  public void rawGet(String paramString, ArrayList<KVPair<String>> paramArrayList, RawNetworkCallback paramRawNetworkCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("rawGet: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (KVPair)paramString.next();
        paramNetworkTimeOut.setRequestProperty(paramArrayList.name, (String)paramArrayList.value);
      }
    }
    paramNetworkTimeOut.connect();
    int i = paramNetworkTimeOut.getResponseCode();
    if (i == 200)
    {
      if (paramRawNetworkCallback != null) {
        paramRawNetworkCallback.onResponse(paramNetworkTimeOut.getInputStream());
      }
      paramNetworkTimeOut.disconnect();
      MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return;
    }
    paramArrayList = new StringBuilder();
    paramRawNetworkCallback = new BufferedReader(new InputStreamReader(paramNetworkTimeOut.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramRawNetworkCallback.readLine(); paramString != null; paramString = paramRawNetworkCallback.readLine())
    {
      if (paramArrayList.length() > 0) {
        paramArrayList.append('\n');
      }
      paramArrayList.append(paramString);
    }
    paramRawNetworkCallback.close();
    paramNetworkTimeOut.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramArrayList.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramString));
  }
  
  public void rawPost(String paramString, ArrayList<KVPair<String>> paramArrayList, HTTPPart paramHTTPPart, int paramInt, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("rawpost: " + paramString, new Object[0]);
    paramString = getConnection(paramString, paramNetworkTimeOut);
    paramString.setDoOutput(true);
    if (paramInt >= 0) {
      paramString.setChunkedStreamingMode(0);
    }
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramNetworkTimeOut = (KVPair)paramArrayList.next();
        paramString.setRequestProperty(paramNetworkTimeOut.name, (String)paramNetworkTimeOut.value);
      }
    }
    paramString.connect();
    paramArrayList = paramString.getOutputStream();
    paramHTTPPart = paramHTTPPart.toInputStream();
    paramNetworkTimeOut = new byte[65536];
    for (paramInt = paramHTTPPart.read(paramNetworkTimeOut); paramInt > 0; paramInt = paramHTTPPart.read(paramNetworkTimeOut)) {
      paramArrayList.write(paramNetworkTimeOut, 0, paramInt);
    }
    paramArrayList.flush();
    paramHTTPPart.close();
    paramArrayList.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramString));
        paramString.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList)
      {
        throw paramArrayList;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  public void rawPost(String paramString, ArrayList<KVPair<String>> paramArrayList, HTTPPart paramHTTPPart, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    rawPost(paramString, paramArrayList, paramHTTPPart, 0, paramHttpResponseCallback, paramNetworkTimeOut);
  }
  
  /* Error */
  public void rawPost(String paramString, ArrayList<KVPair<String>> paramArrayList, HTTPPart paramHTTPPart, RawNetworkCallback paramRawNetworkCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    // Byte code:
    //   0: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: invokestatic 344	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   8: new 177	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 880
    //   18: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokevirtual 352	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   35: pop
    //   36: aload_0
    //   37: aload_1
    //   38: aload 5
    //   40: invokespecial 554	com/mob/tools/network/NetworkHelper:getConnection	(Ljava/lang/String;Lcom/mob/tools/network/NetworkHelper$NetworkTimeOut;)Ljava/net/HttpURLConnection;
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_1
    //   48: invokevirtual 706	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   51: aload 5
    //   53: iconst_0
    //   54: invokevirtual 709	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   57: aload_2
    //   58: ifnull +46 -> 104
    //   61: aload_2
    //   62: invokevirtual 200	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   65: astore_1
    //   66: aload_1
    //   67: invokeinterface 206 1 0
    //   72: ifeq +32 -> 104
    //   75: aload_1
    //   76: invokeinterface 210 1 0
    //   81: checkcast 212	com/mob/tools/network/KVPair
    //   84: astore_2
    //   85: aload 5
    //   87: aload_2
    //   88: getfield 225	com/mob/tools/network/KVPair:name	Ljava/lang/String;
    //   91: aload_2
    //   92: getfield 231	com/mob/tools/network/KVPair:value	Ljava/lang/Object;
    //   95: checkcast 64	java/lang/String
    //   98: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -35 -> 66
    //   104: aload 5
    //   106: invokevirtual 557	java/net/HttpURLConnection:connect	()V
    //   109: aload 5
    //   111: invokevirtual 721	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   114: astore_1
    //   115: aload_3
    //   116: invokevirtual 724	com/mob/tools/network/HTTPPart:toInputStream	()Ljava/io/InputStream;
    //   119: astore_2
    //   120: ldc_w 725
    //   123: newarray <illegal type>
    //   125: astore_3
    //   126: aload_2
    //   127: aload_3
    //   128: invokevirtual 647	java/io/InputStream:read	([B)I
    //   131: istore 6
    //   133: iload 6
    //   135: ifle +21 -> 156
    //   138: aload_1
    //   139: aload_3
    //   140: iconst_0
    //   141: iload 6
    //   143: invokevirtual 728	java/io/OutputStream:write	([BII)V
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 647	java/io/InputStream:read	([B)I
    //   151: istore 6
    //   153: goto -20 -> 133
    //   156: aload_1
    //   157: invokevirtual 729	java/io/OutputStream:flush	()V
    //   160: aload_2
    //   161: invokevirtual 655	java/io/InputStream:close	()V
    //   164: aload_1
    //   165: invokevirtual 730	java/io/OutputStream:close	()V
    //   168: aload 5
    //   170: invokevirtual 560	java/net/HttpURLConnection:getResponseCode	()I
    //   173: istore 6
    //   175: iload 6
    //   177: sipush 200
    //   180: if_icmpne +99 -> 279
    //   183: aload 4
    //   185: ifnull +86 -> 271
    //   188: aload 5
    //   190: invokevirtual 633	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   193: astore_1
    //   194: aload 4
    //   196: aload_1
    //   197: invokeinterface 875 2 0
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 655	java/io/InputStream:close	()V
    //   210: aload 5
    //   212: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   215: invokestatic 344	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   218: new 177	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 503
    //   228: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   234: lload 7
    //   236: lsub
    //   237: invokevirtual 506	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokevirtual 352	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   250: pop
    //   251: return
    //   252: astore_2
    //   253: aload_2
    //   254: athrow
    //   255: astore_2
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 655	java/io/InputStream:close	()V
    //   264: aload 5
    //   266: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   269: aload_2
    //   270: athrow
    //   271: aload 5
    //   273: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   276: goto -61 -> 215
    //   279: new 177	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   286: astore_2
    //   287: new 658	java/io/BufferedReader
    //   290: dup
    //   291: new 660	java/io/InputStreamReader
    //   294: dup
    //   295: aload 5
    //   297: invokevirtual 663	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   300: ldc_w 509
    //   303: invokestatic 669	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   306: invokespecial 672	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   309: invokespecial 675	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 678	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +31 -> 350
    //   322: aload_2
    //   323: invokevirtual 515	java/lang/StringBuilder:length	()I
    //   326: ifle +10 -> 336
    //   329: aload_2
    //   330: bipush 10
    //   332: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_2
    //   337: aload_1
    //   338: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_3
    //   343: invokevirtual 678	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   346: astore_1
    //   347: goto -29 -> 318
    //   350: aload_3
    //   351: invokevirtual 679	java/io/BufferedReader:close	()V
    //   354: aload 5
    //   356: invokevirtual 613	java/net/HttpURLConnection:disconnect	()V
    //   359: new 681	java/util/HashMap
    //   362: dup
    //   363: invokespecial 682	java/util/HashMap:<init>	()V
    //   366: astore_1
    //   367: aload_1
    //   368: ldc_w 684
    //   371: aload_2
    //   372: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   378: pop
    //   379: aload_1
    //   380: ldc_w 690
    //   383: iload 6
    //   385: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: new 33	java/lang/Throwable
    //   395: dup
    //   396: new 692	com/mob/tools/utils/Hashon
    //   399: dup
    //   400: invokespecial 693	com/mob/tools/utils/Hashon:<init>	()V
    //   403: aload_1
    //   404: invokevirtual 697	com/mob/tools/utils/Hashon:fromHashMap	(Ljava/util/HashMap;)Ljava/lang/String;
    //   407: invokespecial 698	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   410: athrow
    //   411: astore_1
    //   412: goto -202 -> 210
    //   415: astore_1
    //   416: goto -152 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	NetworkHelper
    //   0	419	1	paramString	String
    //   0	419	2	paramArrayList	ArrayList<KVPair<String>>
    //   0	419	3	paramHTTPPart	HTTPPart
    //   0	419	4	paramRawNetworkCallback	RawNetworkCallback
    //   0	419	5	paramNetworkTimeOut	NetworkTimeOut
    //   131	253	6	i	int
    //   3	232	7	l	long
    // Exception table:
    //   from	to	target	type
    //   194	202	252	java/lang/Throwable
    //   194	202	255	finally
    //   253	255	255	finally
    //   206	210	411	java/lang/Throwable
    //   260	264	415	java/lang/Throwable
  }
  
  public static class NetworkTimeOut
  {
    public int connectionTimeout;
    public int readTimout;
  }
  
  public static final class SimpleX509TrustManager
    implements X509TrustManager
  {
    private X509TrustManager standardTrustManager;
    
    public SimpleX509TrustManager(KeyStore paramKeyStore)
    {
      try
      {
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
        localTrustManagerFactory.init(paramKeyStore);
        paramKeyStore = localTrustManagerFactory.getTrustManagers();
        if ((paramKeyStore == null) || (paramKeyStore.length == 0)) {
          throw new NoSuchAlgorithmException("no trust manager found.");
        }
      }
      catch (Exception paramKeyStore)
      {
        MobLog.getInstance().d("failed to initialize the standard trust manager: " + paramKeyStore.getMessage(), new Object[0]);
        this.standardTrustManager = null;
        return;
      }
      this.standardTrustManager = ((X509TrustManager)paramKeyStore[0]);
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      if (paramArrayOfX509Certificate == null) {
        throw new IllegalArgumentException("there were no certificates.");
      }
      if (paramArrayOfX509Certificate.length == 1)
      {
        paramArrayOfX509Certificate[0].checkValidity();
        return;
      }
      if (this.standardTrustManager != null)
      {
        this.standardTrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      throw new CertificateException("there were one more certificates but no trust manager found.");
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/network/NetworkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */