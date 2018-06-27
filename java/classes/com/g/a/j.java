package com.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@Instrumented
public class j
{
  public static int a = 60000;
  public static int b = 60000;
  public static volatile HashMap c = new HashMap();
  private static Context d = null;
  private static volatile HashMap e = new HashMap();
  
  public static c a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    d = paramContext;
    b(paramString1, paramString2);
    return a(paramString1, paramString2, paramString3, paramString4, paramArrayOfByte);
  }
  
  private static c a(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    localObject1 = new c(600);
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            try
            {
              if (a(paramString1, 2) != null)
              {
                paramString3 = a(a(paramString1, 2), paramString3, paramString4, paramArrayOfByte, paramString1);
                localObject2 = paramString3;
                paramString2 = paramString3;
              }
            }
            catch (Throwable paramString1)
            {
              Object localObject2;
              paramString2 = (String)localObject1;
              continue;
            }
            try
            {
              if (paramString3.a == 600)
              {
                paramString2 = paramString3;
                a(paramString1, null, 2);
                localObject2 = paramString3;
              }
              return (c)localObject2;
            }
            catch (Throwable paramString1)
            {
              av.postSDKError(paramString1);
              return paramString2;
            }
          }
          paramString2 = (String)localObject1;
          if (a(paramString1, 1) != null)
          {
            localObject2 = a(a(paramString1, 1), paramString3, paramString4, paramArrayOfByte, paramString1);
            paramString2 = (String)localObject2;
            localObject1 = localObject2;
          }
          for (;;)
          {
            try
            {
              if (((c)localObject2).a != 600)
              {
                localObject1 = localObject2;
                a(paramString1, a(paramString1, 1), 2);
                localObject1 = localObject2;
                a(paramString1);
                paramString2 = (String)localObject2;
              }
            }
            catch (Throwable paramString1)
            {
              paramString2 = (String)localObject1;
              continue;
            }
            try
            {
              if ((paramString2.a != 600) || (a(paramString1, 3) == null)) {
                break label301;
              }
              localObject1 = a(a(paramString1, 3), paramString3, paramString4, paramArrayOfByte, paramString1);
              paramString2 = (String)localObject1;
              localObject1 = paramString2;
              if (paramString2.a != 600)
              {
                localObject1 = paramString2;
                a(paramString1, a(paramString1, 3), 2);
              }
              localObject1 = paramString2;
            }
            catch (Throwable paramString1)
            {
              continue;
              localObject1 = paramString2;
            }
          }
          localObject2 = localObject1;
          paramString2 = (String)localObject1;
        } while (((c)localObject1).a != 600);
        localObject2 = localObject1;
        paramString2 = (String)localObject1;
      } while (a(paramString1, 4) == null);
      paramString2 = (String)localObject1;
      paramString3 = a(a(paramString1, 4), paramString3, paramString4, paramArrayOfByte, paramString1);
      localObject2 = paramString3;
      paramString2 = paramString3;
    } while (paramString3.a == 600);
    paramString2 = paramString3;
    a(paramString1, a(paramString1, 4), 2);
    return paramString3;
  }
  
  private static c a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    try
    {
      if (paramString2.startsWith("https://")) {
        c.put(Long.valueOf(Thread.currentThread().getId()), paramString4);
      }
      if ((paramString2.toLowerCase().startsWith("https")) && (paramString3.trim().isEmpty())) {}
      for (paramString1 = a(new URL(paramString2), paramString4, true); paramString1 == null; paramString1 = a(a(paramString2, paramString1), paramString4, true)) {
        return new c(600, "");
      }
      paramString4 = paramString1;
      if (paramString2.toLowerCase().startsWith("https"))
      {
        paramString4 = paramString1;
        if (!paramString3.trim().isEmpty()) {
          paramString4 = a(paramString1, paramString3);
        }
      }
      paramString1 = a(paramArrayOfByte, paramString4);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      av.postSDKError(paramString1);
    }
    return new c(600, "");
  }
  
  /* Error */
  private static c a(byte[] paramArrayOfByte, URLConnection paramURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: arraylength
    //   11: ifeq +7 -> 18
    //   14: aload_1
    //   15: ifnonnull +16 -> 31
    //   18: new 12	com/g/a/j$c
    //   21: dup
    //   22: sipush 600
    //   25: ldc 120
    //   27: invokespecial 123	com/g/a/j$c:<init>	(ILjava/lang/String;)V
    //   30: areturn
    //   31: aload_1
    //   32: checkcast 134	java/net/HttpURLConnection
    //   35: astore 6
    //   37: new 136	java/lang/StringBuffer
    //   40: dup
    //   41: invokespecial 137	java/lang/StringBuffer:<init>	()V
    //   44: astore 7
    //   46: aload 6
    //   48: ldc -117
    //   50: invokevirtual 142	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   53: aload 6
    //   55: invokevirtual 146	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   58: astore_1
    //   59: aload_1
    //   60: aload_0
    //   61: invokevirtual 152	java/io/OutputStream:write	([B)V
    //   64: aload_1
    //   65: invokevirtual 155	java/io/OutputStream:close	()V
    //   68: aload 6
    //   70: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   73: istore_2
    //   74: iload_2
    //   75: sipush 400
    //   78: if_icmple +118 -> 196
    //   81: aload 6
    //   83: invokevirtual 163	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   86: astore_0
    //   87: new 165	java/io/BufferedReader
    //   90: dup
    //   91: new 167	java/io/InputStreamReader
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 170	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   99: invokespecial 173	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore 4
    //   104: aload 4
    //   106: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +94 -> 205
    //   114: aload 7
    //   116: aload_3
    //   117: invokevirtual 180	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   120: pop
    //   121: aload 7
    //   123: bipush 10
    //   125: invokevirtual 183	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: goto -25 -> 104
    //   132: astore_3
    //   133: aload_0
    //   134: astore_3
    //   135: aload 4
    //   137: astore_0
    //   138: aload_1
    //   139: ifnull +7 -> 146
    //   142: aload_1
    //   143: invokevirtual 155	java/io/OutputStream:close	()V
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 184	java/io/BufferedReader:close	()V
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 187	java/io/InputStream:close	()V
    //   162: aload 6
    //   164: ifnull +8 -> 172
    //   167: aload 6
    //   169: invokevirtual 190	java/net/HttpURLConnection:disconnect	()V
    //   172: ldc 22
    //   174: putstatic 24	com/g/a/j:a	I
    //   177: ldc 22
    //   179: putstatic 26	com/g/a/j:b	I
    //   182: new 12	com/g/a/j$c
    //   185: dup
    //   186: iload_2
    //   187: aload 7
    //   189: invokevirtual 193	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   192: invokespecial 123	com/g/a/j$c:<init>	(ILjava/lang/String;)V
    //   195: areturn
    //   196: aload 6
    //   198: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   201: astore_0
    //   202: goto -115 -> 87
    //   205: aload_1
    //   206: ifnull +7 -> 213
    //   209: aload_1
    //   210: invokevirtual 155	java/io/OutputStream:close	()V
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 184	java/io/BufferedReader:close	()V
    //   223: aload_0
    //   224: ifnull +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 187	java/io/InputStream:close	()V
    //   231: aload 6
    //   233: ifnull +8 -> 241
    //   236: aload 6
    //   238: invokevirtual 190	java/net/HttpURLConnection:disconnect	()V
    //   241: ldc 22
    //   243: putstatic 24	com/g/a/j:a	I
    //   246: ldc 22
    //   248: putstatic 26	com/g/a/j:b	I
    //   251: goto -69 -> 182
    //   254: astore_0
    //   255: aload_0
    //   256: invokestatic 70	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   259: goto -18 -> 241
    //   262: astore_0
    //   263: aload_0
    //   264: invokestatic 70	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   267: goto -95 -> 172
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_0
    //   275: aload 5
    //   277: astore 4
    //   279: aload_1
    //   280: ifnull +7 -> 287
    //   283: aload_1
    //   284: invokevirtual 155	java/io/OutputStream:close	()V
    //   287: aload 4
    //   289: ifnull +8 -> 297
    //   292: aload 4
    //   294: invokevirtual 184	java/io/BufferedReader:close	()V
    //   297: aload_0
    //   298: ifnull +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 187	java/io/InputStream:close	()V
    //   305: aload 6
    //   307: ifnull +8 -> 315
    //   310: aload 6
    //   312: invokevirtual 190	java/net/HttpURLConnection:disconnect	()V
    //   315: ldc 22
    //   317: putstatic 24	com/g/a/j:a	I
    //   320: ldc 22
    //   322: putstatic 26	com/g/a/j:b	I
    //   325: aload_3
    //   326: athrow
    //   327: astore_0
    //   328: aload_0
    //   329: invokestatic 70	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   332: goto -17 -> 315
    //   335: astore_1
    //   336: goto -123 -> 213
    //   339: astore_1
    //   340: goto -117 -> 223
    //   343: astore_0
    //   344: goto -113 -> 231
    //   347: astore_1
    //   348: goto -202 -> 146
    //   351: astore_0
    //   352: goto -198 -> 154
    //   355: astore_0
    //   356: goto -194 -> 162
    //   359: astore_1
    //   360: goto -73 -> 287
    //   363: astore_1
    //   364: goto -67 -> 297
    //   367: astore_0
    //   368: goto -63 -> 305
    //   371: astore_3
    //   372: aconst_null
    //   373: astore_0
    //   374: aload 5
    //   376: astore 4
    //   378: goto -99 -> 279
    //   381: astore_3
    //   382: aload 5
    //   384: astore 4
    //   386: goto -107 -> 279
    //   389: astore_3
    //   390: goto -111 -> 279
    //   393: astore_0
    //   394: sipush 600
    //   397: istore_2
    //   398: aconst_null
    //   399: astore 4
    //   401: aconst_null
    //   402: astore_0
    //   403: aload_3
    //   404: astore_1
    //   405: aload 4
    //   407: astore_3
    //   408: goto -270 -> 138
    //   411: astore_0
    //   412: sipush 600
    //   415: istore_2
    //   416: aconst_null
    //   417: astore_0
    //   418: aconst_null
    //   419: astore_3
    //   420: goto -282 -> 138
    //   423: astore_0
    //   424: aconst_null
    //   425: astore_0
    //   426: aconst_null
    //   427: astore_3
    //   428: goto -290 -> 138
    //   431: astore_3
    //   432: aconst_null
    //   433: astore 4
    //   435: aload_0
    //   436: astore_3
    //   437: aload 4
    //   439: astore_0
    //   440: goto -302 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	paramArrayOfByte	byte[]
    //   0	443	1	paramURLConnection	URLConnection
    //   73	343	2	i	int
    //   4	113	3	str	String
    //   132	1	3	localThrowable1	Throwable
    //   134	25	3	arrayOfByte1	byte[]
    //   270	56	3	localObject1	Object
    //   371	1	3	localObject2	Object
    //   381	1	3	localObject3	Object
    //   389	15	3	localObject4	Object
    //   407	21	3	localObject5	Object
    //   431	1	3	localThrowable2	Throwable
    //   436	1	3	arrayOfByte2	byte[]
    //   102	336	4	localObject6	Object
    //   1	382	5	localObject7	Object
    //   35	276	6	localHttpURLConnection	java.net.HttpURLConnection
    //   44	144	7	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   104	110	132	java/lang/Throwable
    //   114	129	132	java/lang/Throwable
    //   236	241	254	java/lang/Throwable
    //   167	172	262	java/lang/Throwable
    //   46	59	270	finally
    //   310	315	327	java/lang/Throwable
    //   209	213	335	java/lang/Throwable
    //   218	223	339	java/lang/Throwable
    //   227	231	343	java/lang/Throwable
    //   142	146	347	java/lang/Throwable
    //   150	154	351	java/lang/Throwable
    //   158	162	355	java/lang/Throwable
    //   283	287	359	java/lang/Throwable
    //   292	297	363	java/lang/Throwable
    //   301	305	367	java/lang/Throwable
    //   59	74	371	finally
    //   81	87	371	finally
    //   196	202	371	finally
    //   87	104	381	finally
    //   104	110	389	finally
    //   114	129	389	finally
    //   46	59	393	java/lang/Throwable
    //   59	74	411	java/lang/Throwable
    //   81	87	423	java/lang/Throwable
    //   196	202	423	java/lang/Throwable
    //   87	104	431	java/lang/Throwable
  }
  
  private static String a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!z.b(paramString))
        {
          boolean bool = e.containsKey(paramString);
          if (bool) {}
        }
        else
        {
          paramString = null;
          return paramString;
        }
        if (e == null)
        {
          paramString = null;
          continue;
        }
        paramString = (a)e.get(paramString);
        if (paramString == null)
        {
          paramString = null;
          continue;
          paramString = paramString.b;
          continue;
          paramString = paramString.d;
          continue;
          paramString = paramString.c;
          continue;
          paramString = paramString.a;
          continue;
        }
        switch (paramInt)
        {
        }
      }
      finally {}
      paramString = null;
    }
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return b(paramString1, paramString2, paramBoolean);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    return b(paramString, null, paramBoolean);
  }
  
  private static URL a(String paramString1, String paramString2)
  {
    paramString1 = new URL(paramString1);
    if (r.a()) {
      return paramString1;
    }
    return new URL(paramString1.getProtocol(), paramString2, paramString1.getPort(), paramString1.getFile());
  }
  
  private static URLConnection a(URL paramURL, String paramString, boolean paramBoolean)
  {
    try
    {
      if (!(paramURL instanceof URL)) {}
      for (paramURL = paramURL.openConnection();; paramURL = HttpInstrumentation.openConnection((URL)paramURL))
      {
        paramURL.setRequestProperty("Accept-Encoding", "");
        paramURL.setRequestProperty("User-Agent", "");
        if (paramString != null)
        {
          paramURL.setRequestProperty("Host", paramString);
          paramURL.setRequestProperty("Content-Type", "");
        }
        paramURL.setDoInput(true);
        if (paramBoolean) {
          paramURL.setDoOutput(true);
        }
        paramURL.setConnectTimeout(a);
        paramURL.setReadTimeout(b);
        return paramURL;
      }
      return null;
    }
    catch (Throwable paramURL)
    {
      av.postSDKError(paramURL);
    }
  }
  
  private static HttpsURLConnection a(URLConnection paramURLConnection, String paramString)
  {
    try
    {
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)paramURLConnection;
      if (z.a(16)) {}
      for (paramURLConnection = SSLContext.getInstance("TLSv1.2");; paramURLConnection = SSLContext.getInstance("TLSv1"))
      {
        paramURLConnection.init(null, new TrustManager[] { new b(b(paramString)) }, null);
        localHttpsURLConnection.setHostnameVerifier(new k());
        localHttpsURLConnection.setSSLSocketFactory(paramURLConnection.getSocketFactory());
        return localHttpsURLConnection;
      }
      return null;
    }
    catch (Throwable paramURLConnection)
    {
      av.postSDKError(paramURLConnection);
    }
  }
  
  public static SSLSocketFactory a(boolean paramBoolean, X509Certificate paramX509Certificate)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      if ((paramBoolean) && (paramX509Certificate != null)) {
        localSSLContext.init(null, new TrustManager[] { new b(paramX509Certificate) }, null);
      }
      for (;;)
      {
        return localSSLContext.getSocketFactory();
        localSSLContext.init(null, null, null);
      }
      return null;
    }
    catch (Throwable paramX509Certificate)
    {
      av.postSDKError(paramX509Certificate);
    }
  }
  
  private static void a(String paramString)
  {
    String str = a(paramString, 1);
    if ((str != null) && (!str.equalsIgnoreCase(a(paramString, 3))) && (d != null))
    {
      PreferenceManager.getDefaultSharedPreferences(d).edit().putString(z.d(paramString), a(paramString, 1)).apply();
      a(paramString, a(paramString, 1), 3);
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!z.b(paramString1))
        {
          boolean bool = e.containsKey(paramString1);
          if (bool) {}
        }
        else
        {
          return;
        }
        if (e == null) {
          continue;
        }
        paramString1 = (a)e.get(paramString1);
        switch (paramInt)
        {
        case 1: 
          paramString1.b = paramString2;
          break;
        case 2: 
          paramString1.d = paramString2;
        }
      }
      finally {}
      continue;
      paramString1.c = paramString2;
      continue;
      paramString1.a = paramString2;
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramInputStream);
      paramInputStream = new byte['Ѐ'];
      localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int i = localGZIPInputStream.read(paramInputStream, 0, paramInputStream.length);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramInputStream, 0, i);
      }
      av.postSDKError(localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      paramInputStream = null;
    }
    for (;;)
    {
      return paramInputStream;
      paramInputStream = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        localThrowable1.close();
        return paramInputStream;
      }
      catch (Throwable localThrowable2) {}
    }
  }
  
  /* Error */
  private static String b(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: invokestatic 200	com/g/a/z:b	(Ljava/lang/String;)Z
    //   13: ifeq +7 -> 20
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_1
    //   19: areturn
    //   20: new 136	java/lang/StringBuffer
    //   23: dup
    //   24: invokespecial 137	java/lang/StringBuffer:<init>	()V
    //   27: astore 8
    //   29: new 113	java/net/URL
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   37: astore 9
    //   39: aload 9
    //   41: aconst_null
    //   42: iconst_0
    //   43: invokestatic 118	com/g/a/j:a	(Ljava/net/URL;Ljava/lang/String;Z)Ljava/net/URLConnection;
    //   46: checkcast 134	java/net/HttpURLConnection
    //   49: astore 4
    //   51: aload_0
    //   52: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   55: ldc 104
    //   57: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   60: ifeq +350 -> 410
    //   63: aload_1
    //   64: invokestatic 200	com/g/a/z:b	(Ljava/lang/String;)Z
    //   67: ifne +343 -> 410
    //   70: getstatic 33	com/g/a/j:c	Ljava/util/HashMap;
    //   73: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   76: invokevirtual 88	java/lang/Thread:getId	()J
    //   79: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   82: aload 9
    //   84: invokevirtual 370	java/net/URL:getHost	()Ljava/lang/String;
    //   87: invokevirtual 98	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload 4
    //   93: aload_1
    //   94: invokestatic 129	com/g/a/j:a	(Ljava/net/URLConnection;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   97: astore_0
    //   98: aload_0
    //   99: ldc_w 372
    //   102: invokevirtual 142	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   109: istore_3
    //   110: iload_3
    //   111: sipush 200
    //   114: if_icmpne +145 -> 259
    //   117: iload_2
    //   118: ifeq +51 -> 169
    //   121: aload 8
    //   123: new 74	java/lang/String
    //   126: dup
    //   127: aload_0
    //   128: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   131: invokestatic 374	com/g/a/j:a	(Ljava/io/InputStream;)[B
    //   134: ldc_w 376
    //   137: invokespecial 379	java/lang/String:<init>	([BLjava/lang/String;)V
    //   140: invokevirtual 180	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload 7
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 184	java/io/BufferedReader:close	()V
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 190	java/net/HttpURLConnection:disconnect	()V
    //   163: aload 8
    //   165: invokevirtual 193	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   168: areturn
    //   169: new 165	java/io/BufferedReader
    //   172: dup
    //   173: new 167	java/io/InputStreamReader
    //   176: dup
    //   177: aload_0
    //   178: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   181: invokespecial 170	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   184: invokespecial 173	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   192: astore 4
    //   194: aload 4
    //   196: ifnull +60 -> 256
    //   199: aload 8
    //   201: ldc_w 381
    //   204: invokevirtual 180	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   207: pop
    //   208: aload 8
    //   210: aload 4
    //   212: invokevirtual 180	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   215: pop
    //   216: goto -28 -> 188
    //   219: astore 5
    //   221: aload_1
    //   222: astore 4
    //   224: aload 5
    //   226: astore_1
    //   227: aload_1
    //   228: invokestatic 70	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   231: aload 4
    //   233: ifnull +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 184	java/io/BufferedReader:close	()V
    //   241: aload_0
    //   242: ifnull -79 -> 163
    //   245: aload_0
    //   246: invokevirtual 190	java/net/HttpURLConnection:disconnect	()V
    //   249: goto -86 -> 163
    //   252: astore_0
    //   253: goto -90 -> 163
    //   256: goto -109 -> 147
    //   259: iload_3
    //   260: invokestatic 384	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   263: astore 4
    //   265: iconst_0
    //   266: ifeq +11 -> 277
    //   269: new 386	java/lang/NullPointerException
    //   272: dup
    //   273: invokespecial 387	java/lang/NullPointerException:<init>	()V
    //   276: athrow
    //   277: aload 4
    //   279: astore_1
    //   280: aload_0
    //   281: ifnull -263 -> 18
    //   284: aload_0
    //   285: invokevirtual 190	java/net/HttpURLConnection:disconnect	()V
    //   288: aload 4
    //   290: areturn
    //   291: astore_0
    //   292: aload 4
    //   294: areturn
    //   295: astore_1
    //   296: aconst_null
    //   297: astore_0
    //   298: aload 6
    //   300: astore 4
    //   302: aload 4
    //   304: ifnull +8 -> 312
    //   307: aload 4
    //   309: invokevirtual 184	java/io/BufferedReader:close	()V
    //   312: aload_0
    //   313: ifnull +7 -> 320
    //   316: aload_0
    //   317: invokevirtual 190	java/net/HttpURLConnection:disconnect	()V
    //   320: aload_1
    //   321: athrow
    //   322: astore_1
    //   323: goto -46 -> 277
    //   326: astore_1
    //   327: goto -172 -> 155
    //   330: astore_0
    //   331: goto -168 -> 163
    //   334: astore_1
    //   335: goto -94 -> 241
    //   338: astore 4
    //   340: goto -28 -> 312
    //   343: astore_0
    //   344: goto -24 -> 320
    //   347: astore_1
    //   348: aload 4
    //   350: astore_0
    //   351: aload 6
    //   353: astore 4
    //   355: goto -53 -> 302
    //   358: astore_1
    //   359: aload 6
    //   361: astore 4
    //   363: goto -61 -> 302
    //   366: astore 5
    //   368: aload_1
    //   369: astore 4
    //   371: aload 5
    //   373: astore_1
    //   374: goto -72 -> 302
    //   377: astore_1
    //   378: goto -76 -> 302
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_0
    //   384: aload 5
    //   386: astore 4
    //   388: goto -161 -> 227
    //   391: astore_1
    //   392: aload 4
    //   394: astore_0
    //   395: aload 5
    //   397: astore 4
    //   399: goto -172 -> 227
    //   402: astore_1
    //   403: aload 5
    //   405: astore 4
    //   407: goto -180 -> 227
    //   410: aload 4
    //   412: astore_0
    //   413: goto -315 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramString1	String
    //   0	416	1	paramString2	String
    //   0	416	2	paramBoolean	boolean
    //   109	151	3	i	int
    //   49	259	4	localObject1	Object
    //   338	11	4	localThrowable1	Throwable
    //   353	58	4	localObject2	Object
    //   1	1	5	localObject3	Object
    //   219	6	5	localThrowable2	Throwable
    //   366	38	5	localObject4	Object
    //   4	356	6	localObject5	Object
    //   7	138	7	localObject6	Object
    //   27	182	8	localStringBuffer	StringBuffer
    //   37	46	9	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   188	194	219	java/lang/Throwable
    //   199	216	219	java/lang/Throwable
    //   245	249	252	java/lang/Throwable
    //   284	288	291	java/lang/Throwable
    //   29	51	295	finally
    //   269	277	322	java/lang/Throwable
    //   151	155	326	java/lang/Throwable
    //   159	163	330	java/lang/Throwable
    //   236	241	334	java/lang/Throwable
    //   307	312	338	java/lang/Throwable
    //   316	320	343	java/lang/Throwable
    //   51	98	347	finally
    //   98	110	358	finally
    //   121	144	358	finally
    //   169	188	358	finally
    //   188	194	366	finally
    //   199	216	366	finally
    //   227	231	377	finally
    //   29	51	381	java/lang/Throwable
    //   51	98	391	java/lang/Throwable
    //   98	110	402	java/lang/Throwable
    //   121	144	402	java/lang/Throwable
    //   169	188	402	java/lang/Throwable
  }
  
  private static X509Certificate b(String paramString)
  {
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localByteArrayInputStream = new ByteArrayInputStream(paramString.getBytes());
      try
      {
        X509Certificate localX509Certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(localByteArrayInputStream);
        paramString = localX509Certificate;
        if (localByteArrayInputStream == null) {
          continue;
        }
        try
        {
          localByteArrayInputStream.close();
          return localX509Certificate;
        }
        catch (Throwable paramString)
        {
          return localX509Certificate;
        }
        try
        {
          localByteArrayInputStream.close();
          throw paramString;
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        if (localByteArrayInputStream != null) {}
        try
        {
          localByteArrayInputStream.close();
          return null;
        }
        catch (Throwable paramString)
        {
          return null;
        }
      }
      finally
      {
        paramString = finally;
        if (localByteArrayInputStream == null) {}
      }
    }
  }
  
  /* Error */
  private static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 200	com/g/a/z:b	(Ljava/lang/String;)Z
    //   7: ifne +15 -> 22
    //   10: getstatic 37	com/g/a/j:e	Ljava/util/HashMap;
    //   13: aload_0
    //   14: invokevirtual 204	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +7 -> 26
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: getstatic 37	com/g/a/j:e	Ljava/util/HashMap;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull -9 -> 22
    //   34: new 6	com/g/a/j$a
    //   37: dup
    //   38: invokespecial 410	com/g/a/j$a:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_0
    //   44: putfield 412	com/g/a/j$a:e	Ljava/lang/String;
    //   47: aload_3
    //   48: aload_1
    //   49: putfield 217	com/g/a/j$a:a	Ljava/lang/String;
    //   52: aload_3
    //   53: getstatic 35	com/g/a/j:d	Landroid/content/Context;
    //   56: invokestatic 326	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   59: aload_0
    //   60: invokestatic 335	com/g/a/z:d	(Ljava/lang/String;)Ljava/lang/String;
    //   63: aconst_null
    //   64: invokeinterface 416 3 0
    //   69: putfield 215	com/g/a/j$a:c	Ljava/lang/String;
    //   72: aload_3
    //   73: aload_0
    //   74: invokestatic 422	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   77: invokevirtual 425	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   80: putfield 211	com/g/a/j$a:b	Ljava/lang/String;
    //   83: getstatic 37	com/g/a/j:e	Ljava/util/HashMap;
    //   86: aload_0
    //   87: aload_3
    //   88: invokevirtual 98	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: goto -70 -> 22
    //   95: astore_0
    //   96: goto -74 -> 22
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramString1	String
    //   0	105	1	paramString2	String
    //   17	2	2	bool	boolean
    //   29	59	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	92	95	java/lang/Throwable
    //   3	18	99	finally
    //   26	30	99	finally
    //   34	92	99	finally
  }
  
  static class a
  {
    String a = null;
    String b = null;
    String c = null;
    String d = null;
    String e = null;
  }
  
  static class b
    implements X509TrustManager
  {
    X509Certificate a;
    
    b(X509Certificate paramX509Certificate)
    {
      this.a = paramX509Certificate;
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    {
      if ((paramArrayOfX509Certificate.length != 0) || (!paramArrayOfX509Certificate[0].getIssuerDN().equals(this.a.getSubjectDN()))) {}
      label236:
      for (;;)
      {
        try
        {
          Object localObject = paramArrayOfX509Certificate[0].getSubjectDN().getName();
          int i = ((String)localObject).indexOf("CN=");
          paramString = (String)localObject;
          if (i >= 0)
          {
            localObject = ((String)localObject).substring(i + 3);
            i = ((String)localObject).indexOf(",");
            paramString = (String)localObject;
            if (i >= 0) {
              paramString = ((String)localObject).substring(0, i);
            }
          }
          localObject = paramString.split("\\.");
          if (localObject.length < 2) {
            break label236;
          }
          paramString = localObject[(localObject.length - 2)] + "." + localObject[(localObject.length - 1)];
          if (!j.c.containsKey(Long.valueOf(Thread.currentThread().getId()))) {
            throw new CertificateException("No valid host provided!");
          }
        }
        catch (Throwable paramArrayOfX509Certificate)
        {
          av.postSDKError(paramArrayOfX509Certificate);
          if ((paramArrayOfX509Certificate instanceof CertificateException)) {}
          return;
        }
        if (!((String)j.c.get(Long.valueOf(Thread.currentThread().getId()))).endsWith(paramString)) {
          throw new CertificateException("Server certificate has incorrect host name!");
        }
        paramArrayOfX509Certificate[0].verify(this.a.getPublicKey());
        paramArrayOfX509Certificate[0].checkValidity();
        return;
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
  
  public static class c
  {
    public int a;
    public String b;
    
    c(int paramInt)
    {
      this(paramInt, "");
    }
    
    c(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public String b()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */