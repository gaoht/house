package com.freelxl.baselibrary.f;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;

public class e
{
  private static javax.net.ssl.SSLSocketFactory a;
  private static long b = 0L;
  
  public static long getAvailableSpace(File paramFile)
  {
    try
    {
      paramFile = new StatFs(paramFile.getPath());
      long l = paramFile.getBlockSize();
      int i = paramFile.getAvailableBlocks();
      return i * l;
    }
    catch (Throwable paramFile)
    {
      com.freelxl.baselibrary.c.a.e(paramFile.getMessage(), paramFile);
    }
    return -1L;
  }
  
  public static StackTraceElement getCallerStackTraceElement()
  {
    return Thread.currentThread().getStackTrace()[4];
  }
  
  public static Charset getCharsetFromHttpRequest(HttpRequestBase paramHttpRequestBase)
  {
    boolean bool2 = false;
    if (paramHttpRequestBase == null) {
      return null;
    }
    paramHttpRequestBase = paramHttpRequestBase.getFirstHeader("Content-Type");
    int i;
    NameValuePair localNameValuePair;
    if (paramHttpRequestBase != null)
    {
      paramHttpRequestBase = paramHttpRequestBase.getElements();
      int j = paramHttpRequestBase.length;
      i = 0;
      if (i < j)
      {
        localNameValuePair = paramHttpRequestBase[i].getParameterByName("charset");
        if (localNameValuePair == null) {}
      }
    }
    for (paramHttpRequestBase = localNameValuePair.getValue();; paramHttpRequestBase = null)
    {
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(paramHttpRequestBase)) {}
      try
      {
        bool1 = Charset.isSupported(paramHttpRequestBase);
        if (!bool1) {
          break;
        }
        return Charset.forName(paramHttpRequestBase);
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
    }
  }
  
  public static StackTraceElement getCurrentStackTraceElement()
  {
    return Thread.currentThread().getStackTrace()[3];
  }
  
  public static String getDiskCacheDir(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      File localFile = paramContext.getExternalCacheDir();
      localObject1 = localObject2;
      if (localFile != null) {
        localObject1 = localFile.getPath();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramContext = paramContext.getCacheDir();
      localObject2 = localObject1;
      if (paramContext != null)
      {
        localObject2 = localObject1;
        if (paramContext.exists()) {
          localObject2 = paramContext.getPath();
        }
      }
    }
    return (String)localObject2 + File.separator + paramString;
  }
  
  public static String getFileNameFromHttpResponse(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {}
    for (;;)
    {
      return null;
      paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Disposition");
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.getElements();
        int j = paramHttpResponse.length;
        int i = 0;
        while (i < j)
        {
          NameValuePair localNameValuePair = paramHttpResponse[i].getParameterByName("filename");
          if (localNameValuePair != null)
          {
            paramHttpResponse = localNameValuePair.getValue();
            return a.toCharset(paramHttpResponse, "UTF-8", paramHttpResponse.length());
          }
          i += 1;
        }
      }
    }
  }
  
  public static String getSubString(String paramString, int paramInt1, int paramInt2)
  {
    return new String(paramString.substring(paramInt1, paramInt2));
  }
  
  public static String getUserAgent(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = paramContext.getString(((Integer)Class.forName("com.android.internal.R$string").getDeclaredField("web_user_agent").get(null)).intValue());
        Object localObject1 = paramContext;
        if (TextUtils.isEmpty(paramContext)) {
          localObject1 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1";
        }
        Object localObject2 = Locale.getDefault();
        paramContext = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0)
        {
          paramContext.append(str);
          paramContext.append("; ");
          str = ((Locale)localObject2).getLanguage();
          if (str == null) {
            continue;
          }
          paramContext.append(str.toLowerCase());
          localObject2 = ((Locale)localObject2).getCountry();
          if (localObject2 != null)
          {
            paramContext.append("-");
            paramContext.append(((String)localObject2).toLowerCase());
          }
          if ("REL".equals(Build.VERSION.CODENAME))
          {
            localObject2 = Build.MODEL;
            if (((String)localObject2).length() > 0)
            {
              paramContext.append("; ");
              paramContext.append((String)localObject2);
            }
          }
          localObject2 = Build.ID;
          if (((String)localObject2).length() > 0)
          {
            paramContext.append(" Build/");
            paramContext.append((String)localObject2);
          }
          return String.format((String)localObject1, new Object[] { paramContext, "Mobile " });
        }
      }
      catch (Throwable paramContext)
      {
        paramContext = null;
        continue;
        paramContext.append("1.0");
        continue;
        paramContext.append("en");
        continue;
      }
      paramContext = null;
    }
  }
  
  public static boolean isShakeClick()
  {
    long l = System.currentTimeMillis();
    boolean bool = false;
    if (l - b < 1000L) {
      bool = true;
    }
    b = l;
    return bool;
  }
  
  public static boolean isSupportRange(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {}
    do
    {
      do
      {
        return false;
        Header localHeader = paramHttpResponse.getFirstHeader("Accept-Ranges");
        if (localHeader != null) {
          return "bytes".equals(localHeader.getValue());
        }
        paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Range");
      } while (paramHttpResponse == null);
      paramHttpResponse = paramHttpResponse.getValue();
    } while ((paramHttpResponse == null) || (!paramHttpResponse.startsWith("bytes")));
    return true;
  }
  
  public static long sizeOfString(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    long l = 0L;
    if (TextUtils.isEmpty(paramString1)) {
      return 0L;
    }
    int k = paramString1.length();
    if (k < 100) {
      return paramString1.getBytes(paramString2).length;
    }
    int i = 0;
    if (i < k)
    {
      int j = i + 100;
      if (j < k) {}
      for (;;)
      {
        l += getSubString(paramString1, i, j).getBytes(paramString2).length;
        i += 100;
        break;
        j = k;
      }
    }
    return l;
  }
  
  public static void trustAllHttpsURLConnection()
  {
    X509TrustManager local1;
    if (a == null) {
      local1 = new X509TrustManager()
      {
        public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
        
        public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString) {}
        
        public X509Certificate[] getAcceptedIssuers()
        {
          return null;
        }
      };
    }
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { local1 }, null);
      a = localSSLContext.getSocketFactory();
      if (a != null)
      {
        HttpsURLConnection.setDefaultSSLSocketFactory(a);
        HttpsURLConnection.setDefaultHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.freelxl.baselibrary.c.a.e(localThrowable.getMessage(), localThrowable);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */