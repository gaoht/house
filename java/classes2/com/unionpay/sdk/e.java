package com.unionpay.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
public class e
{
  public static int a = 60000;
  public static int b = 60000;
  public static volatile HashMap c = new HashMap();
  private static Context d = null;
  private static volatile HashMap e = new HashMap();
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    d = paramContext;
    a(paramString1, paramString2);
    return a(paramString1, paramString3, paramString4, paramArrayOfByte);
  }
  
  private static d a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    Object localObject3 = new d();
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (a(paramString1, 2) != null)
      {
        localObject1 = localObject3;
        paramString2 = a(a(paramString1, 2), paramString2, paramString3, paramArrayOfByte, paramString1);
        localObject1 = paramString2;
        localObject2 = paramString2;
        if (paramString2.a == 600)
        {
          localObject1 = paramString2;
          a(paramString1, null, 2);
          return paramString2;
        }
      }
      else
      {
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (a(paramString1, 1) != null)
        {
          localObject1 = localObject3;
          localObject3 = a(a(paramString1, 1), paramString2, paramString3, paramArrayOfByte, paramString1);
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (((d)localObject3).a != 600)
          {
            localObject1 = localObject3;
            a(paramString1, a(paramString1, 1), 2);
            localObject1 = localObject3;
            String str = a(paramString1, 1);
            localObject2 = localObject3;
            if (str != null)
            {
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (!str.equalsIgnoreCase(a(paramString1, 3)))
              {
                localObject2 = localObject3;
                localObject1 = localObject3;
                if (d != null)
                {
                  localObject1 = localObject3;
                  PreferenceManager.getDefaultSharedPreferences(d).edit().putString(r.d(paramString1), a(paramString1, 1)).apply();
                  localObject1 = localObject3;
                  a(paramString1, a(paramString1, 1), 3);
                  localObject2 = localObject3;
                }
              }
            }
          }
        }
        localObject3 = localObject2;
        localObject1 = localObject2;
        if (((d)localObject2).a == 600)
        {
          localObject3 = localObject2;
          localObject1 = localObject2;
          if (a(paramString1, 3) != null)
          {
            localObject1 = localObject2;
            localObject2 = a(a(paramString1, 3), paramString2, paramString3, paramArrayOfByte, paramString1);
            localObject3 = localObject2;
            localObject1 = localObject2;
            if (((d)localObject2).a != 600)
            {
              localObject1 = localObject2;
              a(paramString1, a(paramString1, 3), 2);
              localObject3 = localObject2;
            }
          }
        }
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((d)localObject3).a == 600)
        {
          localObject1 = localObject3;
          paramString2 = a(a(paramString1, 4), paramString2, paramString3, paramArrayOfByte, paramString1);
          localObject1 = paramString2;
          localObject2 = paramString2;
          if (paramString2.a != 600)
          {
            localObject1 = paramString2;
            a(paramString1, a(paramString1, 4), 2);
            return paramString2;
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      localObject2 = localObject1;
    }
    return (d)localObject2;
  }
  
  private static d a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    try
    {
      if (paramString2.startsWith("https://")) {
        c.put(Long.valueOf(Thread.currentThread().getId()), paramString4);
      }
      URL localURL = new URL(paramString2);
      if (j.a()) {}
      for (paramString1 = localURL;; paramString1 = new URL(localURL.getProtocol(), paramString1, localURL.getPort(), localURL.getFile()))
      {
        paramString4 = a(paramString1, paramString4, true);
        if (paramString4 != null) {
          break;
        }
        return new d(600, "");
      }
      paramString1 = paramString4;
      if (paramString2.toLowerCase().startsWith("https"))
      {
        paramString1 = paramString4;
        if (!paramString3.trim().isEmpty()) {
          paramString1 = a(paramString4, paramString3);
        }
      }
      paramString1 = a(paramArrayOfByte, paramString1);
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return new d(600, "");
  }
  
  /* Error */
  private static d a(byte[] paramArrayOfByte, URLConnection paramURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: arraylength
    //   11: ifeq +7 -> 18
    //   14: aload_1
    //   15: ifnonnull +16 -> 31
    //   18: new 12	com/unionpay/sdk/e$d
    //   21: dup
    //   22: sipush 600
    //   25: ldc -125
    //   27: invokespecial 134	com/unionpay/sdk/e$d:<init>	(ILjava/lang/String;)V
    //   30: areturn
    //   31: aload_1
    //   32: checkcast 167	java/net/HttpURLConnection
    //   35: astore 5
    //   37: new 169	java/lang/StringBuffer
    //   40: dup
    //   41: invokespecial 170	java/lang/StringBuffer:<init>	()V
    //   44: astore 6
    //   46: aload 5
    //   48: ldc -84
    //   50: invokevirtual 175	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   53: aload 5
    //   55: invokevirtual 179	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   58: astore_1
    //   59: aload_1
    //   60: aload_0
    //   61: invokevirtual 185	java/io/OutputStream:write	([B)V
    //   64: aload_1
    //   65: invokevirtual 188	java/io/OutputStream:close	()V
    //   68: aload 5
    //   70: invokevirtual 191	java/net/HttpURLConnection:getResponseCode	()I
    //   73: istore_2
    //   74: iload_2
    //   75: sipush 400
    //   78: if_icmple +103 -> 181
    //   81: aload 5
    //   83: invokevirtual 195	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   86: astore_0
    //   87: new 197	java/io/BufferedReader
    //   90: dup
    //   91: new 199	java/io/InputStreamReader
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   99: invokespecial 205	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 208	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   107: astore_3
    //   108: aload_3
    //   109: ifnull +81 -> 190
    //   112: aload 6
    //   114: aload_3
    //   115: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   118: pop
    //   119: aload 6
    //   121: bipush 10
    //   123: invokevirtual 215	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   126: pop
    //   127: goto -24 -> 103
    //   130: astore_3
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 188	java/io/OutputStream:close	()V
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 216	java/io/BufferedReader:close	()V
    //   147: aload 5
    //   149: ifnull +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   157: ldc 22
    //   159: putstatic 24	com/unionpay/sdk/e:a	I
    //   162: ldc 22
    //   164: putstatic 26	com/unionpay/sdk/e:b	I
    //   167: new 12	com/unionpay/sdk/e$d
    //   170: dup
    //   171: iload_2
    //   172: aload 6
    //   174: invokevirtual 222	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   177: invokespecial 134	com/unionpay/sdk/e$d:<init>	(ILjava/lang/String;)V
    //   180: areturn
    //   181: aload 5
    //   183: invokevirtual 225	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   186: astore_0
    //   187: goto -100 -> 87
    //   190: aload_1
    //   191: ifnull +7 -> 198
    //   194: aload_1
    //   195: invokevirtual 188	java/io/OutputStream:close	()V
    //   198: aload_0
    //   199: invokevirtual 216	java/io/BufferedReader:close	()V
    //   202: aload 5
    //   204: ifnull +8 -> 212
    //   207: aload 5
    //   209: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   212: ldc 22
    //   214: putstatic 24	com/unionpay/sdk/e:a	I
    //   217: ldc 22
    //   219: putstatic 26	com/unionpay/sdk/e:b	I
    //   222: goto -55 -> 167
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 188	java/io/OutputStream:close	()V
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 216	java/io/BufferedReader:close	()V
    //   244: aload 5
    //   246: ifnull +8 -> 254
    //   249: aload 5
    //   251: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   254: ldc 22
    //   256: putstatic 24	com/unionpay/sdk/e:a	I
    //   259: ldc 22
    //   261: putstatic 26	com/unionpay/sdk/e:b	I
    //   264: aload_0
    //   265: athrow
    //   266: astore_1
    //   267: goto -69 -> 198
    //   270: astore_0
    //   271: goto -69 -> 202
    //   274: astore_0
    //   275: goto -63 -> 212
    //   278: astore_1
    //   279: goto -140 -> 139
    //   282: astore_0
    //   283: goto -136 -> 147
    //   286: astore_0
    //   287: goto -130 -> 157
    //   290: astore_1
    //   291: goto -55 -> 236
    //   294: astore_1
    //   295: goto -51 -> 244
    //   298: astore_1
    //   299: goto -45 -> 254
    //   302: astore_0
    //   303: goto -75 -> 228
    //   306: astore 4
    //   308: aload_0
    //   309: astore_3
    //   310: aload 4
    //   312: astore_0
    //   313: goto -85 -> 228
    //   316: astore_0
    //   317: sipush 600
    //   320: istore_2
    //   321: aconst_null
    //   322: astore_0
    //   323: aload 4
    //   325: astore_1
    //   326: goto -195 -> 131
    //   329: astore_0
    //   330: sipush 600
    //   333: istore_2
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -205 -> 131
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_0
    //   342: goto -211 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramArrayOfByte	byte[]
    //   0	345	1	paramURLConnection	URLConnection
    //   73	261	2	i	int
    //   1	114	3	str	String
    //   130	111	3	localThrowable	Throwable
    //   309	1	3	arrayOfByte	byte[]
    //   3	1	4	localObject1	Object
    //   306	18	4	localObject2	Object
    //   35	215	5	localHttpURLConnection	java.net.HttpURLConnection
    //   44	129	6	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   103	108	130	java/lang/Throwable
    //   112	127	130	java/lang/Throwable
    //   46	59	225	finally
    //   194	198	266	java/lang/Throwable
    //   198	202	270	java/lang/Throwable
    //   207	212	274	java/lang/Throwable
    //   135	139	278	java/lang/Throwable
    //   143	147	282	java/lang/Throwable
    //   152	157	286	java/lang/Throwable
    //   232	236	290	java/lang/Throwable
    //   240	244	294	java/lang/Throwable
    //   249	254	298	java/lang/Throwable
    //   59	74	302	finally
    //   81	87	302	finally
    //   87	103	302	finally
    //   181	187	302	finally
    //   103	108	306	finally
    //   112	127	306	finally
    //   46	59	316	java/lang/Throwable
    //   59	74	329	java/lang/Throwable
    //   81	87	339	java/lang/Throwable
    //   87	103	339	java/lang/Throwable
    //   181	187	339	java/lang/Throwable
  }
  
  private static String a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!r.b(paramString))
        {
          boolean bool = e.containsKey(paramString);
          if (bool) {}
        }
        else
        {
          paramString = null;
          return paramString;
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
  
  public static String a(String paramString, File paramFile)
  {
    return b(paramString, null, paramFile);
  }
  
  public static String a(String paramString1, String paramString2, File paramFile)
  {
    return b(paramString1, paramString2, paramFile);
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return b(paramString1, paramString2, paramBoolean);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    return b(paramString, null, paramBoolean);
  }
  
  private static URLConnection a(URL paramURL, String paramString, boolean paramBoolean)
  {
    try
    {
      if (!(paramURL instanceof URL)) {}
      for (paramURL = paramURL.openConnection();; paramURL = HttpInstrumentation.openConnection((URL)paramURL))
      {
        paramURL.setRequestProperty("Accept-Encoding", "");
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
    catch (Throwable paramURL) {}
  }
  
  private static X509Certificate a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().isEmpty())) {
      return null;
    }
    paramString = new ByteArrayInputStream(paramString.getBytes());
    try
    {
      X509Certificate localX509Certificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramString);
      try
      {
        paramString.close();
        return localX509Certificate;
      }
      catch (Throwable paramString)
      {
        return localX509Certificate;
      }
      try
      {
        paramString.close();
        throw ((Throwable)localObject);
      }
      catch (Throwable paramString)
      {
        for (;;) {}
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      try
      {
        paramString.close();
        return null;
      }
      catch (Throwable paramString)
      {
        return null;
      }
    }
    finally
    {
      localObject = finally;
    }
  }
  
  private static HttpsURLConnection a(URLConnection paramURLConnection, String paramString)
  {
    try
    {
      paramURLConnection = (HttpsURLConnection)paramURLConnection;
      SSLContext localSSLContext = SSLContext.getInstance("TLSv1.2");
      localSSLContext.init(null, new TrustManager[] { new b(a(paramString)) }, null);
      paramURLConnection.setHostnameVerifier(new az());
      paramURLConnection.setSSLSocketFactory(localSSLContext.getSocketFactory());
      return paramURLConnection;
    }
    catch (Throwable paramURLConnection) {}
    return null;
  }
  
  public static SSLSocketFactory a(X509Certificate paramX509Certificate)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { new b(paramX509Certificate) }, null);
      paramX509Certificate = localSSLContext.getSocketFactory();
      return paramX509Certificate;
    }
    catch (Throwable paramX509Certificate) {}
    return null;
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 227	com/unionpay/sdk/r:b	(Ljava/lang/String;)Z
    //   7: ifne +15 -> 22
    //   10: getstatic 37	com/unionpay/sdk/e:e	Ljava/util/HashMap;
    //   13: aload_0
    //   14: invokevirtual 231	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +7 -> 26
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: new 6	com/unionpay/sdk/e$a
    //   29: dup
    //   30: invokespecial 353	com/unionpay/sdk/e$a:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_0
    //   36: putfield 355	com/unionpay/sdk/e$a:e	Ljava/lang/String;
    //   39: aload_3
    //   40: aload_1
    //   41: putfield 244	com/unionpay/sdk/e$a:a	Ljava/lang/String;
    //   44: aload_3
    //   45: getstatic 35	com/unionpay/sdk/e:d	Landroid/content/Context;
    //   48: invokestatic 71	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   51: aload_0
    //   52: invokestatic 82	com/unionpay/sdk/r:d	(Ljava/lang/String;)Ljava/lang/String;
    //   55: aconst_null
    //   56: invokeinterface 359 3 0
    //   61: putfield 242	com/unionpay/sdk/e$a:c	Ljava/lang/String;
    //   64: aload_3
    //   65: aload_0
    //   66: invokestatic 365	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   69: invokevirtual 368	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   72: putfield 238	com/unionpay/sdk/e$a:b	Ljava/lang/String;
    //   75: getstatic 37	com/unionpay/sdk/e:e	Ljava/util/HashMap;
    //   78: aload_0
    //   79: aload_3
    //   80: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -62 -> 22
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    //   93: astore_1
    //   94: goto -19 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramString1	String
    //   0	97	1	paramString2	String
    //   17	2	2	bool	boolean
    //   33	47	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   3	18	87	finally
    //   26	64	87	finally
    //   64	75	87	finally
    //   75	84	87	finally
    //   64	75	93	java/lang/Throwable
  }
  
  private static void a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!r.b(paramString1))
        {
          boolean bool = e.containsKey(paramString1);
          if (bool) {}
        }
        else
        {
          return;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramInputStream);
      localObject1 = localObject2;
      paramInputStream = new byte['Ѐ'];
      localObject1 = localObject2;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        localObject1 = localObject2;
        int i = localGZIPInputStream.read(paramInputStream, 0, paramInputStream.length);
        if (i == -1) {
          break;
        }
        localObject1 = localObject2;
        localByteArrayOutputStream.write(paramInputStream, 0, i);
      }
      localObject1 = localObject2;
      paramInputStream = localByteArrayOutputStream.toByteArray();
      localObject1 = paramInputStream;
      localByteArrayOutputStream.flush();
      localObject1 = paramInputStream;
      localByteArrayOutputStream.close();
      localObject1 = paramInputStream;
      localGZIPInputStream.close();
      return paramInputStream;
    }
    catch (Throwable paramInputStream) {}
    return (byte[])localObject1;
  }
  
  /* Error */
  private static String b(String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: new 118	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 121	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: aconst_null
    //   13: iconst_0
    //   14: invokestatic 129	com/unionpay/sdk/e:a	(Ljava/net/URL;Ljava/lang/String;Z)Ljava/net/URLConnection;
    //   17: checkcast 167	java/net/HttpURLConnection
    //   20: astore 4
    //   22: aload_0
    //   23: invokevirtual 151	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   26: ldc -103
    //   28: invokevirtual 96	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: ifeq +230 -> 261
    //   34: aload_1
    //   35: invokestatic 227	com/unionpay/sdk/r:b	(Ljava/lang/String;)Z
    //   38: ifne +223 -> 261
    //   41: getstatic 33	com/unionpay/sdk/e:c	Ljava/util/HashMap;
    //   44: invokestatic 102	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   47: invokevirtual 106	java/lang/Thread:getId	()J
    //   50: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   53: aload 5
    //   55: invokevirtual 393	java/net/URL:getHost	()Ljava/lang/String;
    //   58: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload 4
    //   64: aload_1
    //   65: invokestatic 162	com/unionpay/sdk/e:a	(Ljava/net/URLConnection;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 191	java/net/HttpURLConnection:getResponseCode	()I
    //   73: sipush 200
    //   76: if_icmpne +127 -> 203
    //   79: aload_0
    //   80: invokevirtual 225	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   83: astore_1
    //   84: new 395	java/io/FileOutputStream
    //   87: dup
    //   88: aload_2
    //   89: invokespecial 398	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   92: astore_2
    //   93: ldc_w 400
    //   96: invokestatic 405	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   99: astore 4
    //   101: sipush 4096
    //   104: newarray <illegal type>
    //   106: astore 5
    //   108: aload_1
    //   109: aload 5
    //   111: invokevirtual 408	java/io/InputStream:read	([B)I
    //   114: istore_3
    //   115: iload_3
    //   116: iconst_m1
    //   117: if_icmpeq +54 -> 171
    //   120: aload_2
    //   121: aload 5
    //   123: iconst_0
    //   124: iload_3
    //   125: invokevirtual 409	java/io/FileOutputStream:write	([BII)V
    //   128: aload 4
    //   130: aload 5
    //   132: iconst_0
    //   133: iload_3
    //   134: invokevirtual 412	java/security/MessageDigest:update	([BII)V
    //   137: goto -29 -> 108
    //   140: astore 4
    //   142: aload_2
    //   143: invokevirtual 413	java/io/FileOutputStream:close	()V
    //   146: aload_1
    //   147: invokevirtual 314	java/io/InputStream:close	()V
    //   150: aload 4
    //   152: athrow
    //   153: astore_1
    //   154: aload_0
    //   155: astore 4
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: areturn
    //   171: aload_2
    //   172: invokevirtual 413	java/io/FileOutputStream:close	()V
    //   175: aload_1
    //   176: invokevirtual 314	java/io/InputStream:close	()V
    //   179: aload 4
    //   181: invokevirtual 416	java/security/MessageDigest:digest	()[B
    //   184: invokestatic 419	com/unionpay/sdk/r:a	([B)Ljava/lang/String;
    //   187: astore_1
    //   188: aload_1
    //   189: astore_2
    //   190: aload_0
    //   191: ifnull -22 -> 169
    //   194: aload_0
    //   195: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   198: aload_1
    //   199: areturn
    //   200: astore_0
    //   201: aload_1
    //   202: areturn
    //   203: aload_0
    //   204: ifnull -37 -> 167
    //   207: aload_0
    //   208: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   211: goto -44 -> 167
    //   214: astore_0
    //   215: goto -48 -> 167
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_0
    //   222: ifnull +7 -> 229
    //   225: aload_0
    //   226: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   229: aload_1
    //   230: athrow
    //   231: astore_0
    //   232: goto -65 -> 167
    //   235: astore_0
    //   236: goto -7 -> 229
    //   239: astore_1
    //   240: aload 4
    //   242: astore_0
    //   243: goto -22 -> 221
    //   246: astore_1
    //   247: goto -26 -> 221
    //   250: astore_0
    //   251: aconst_null
    //   252: astore 4
    //   254: goto -97 -> 157
    //   257: astore_0
    //   258: goto -101 -> 157
    //   261: aload 4
    //   263: astore_0
    //   264: goto -195 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramString1	String
    //   0	267	1	paramString2	String
    //   0	267	2	paramFile	File
    //   114	20	3	i	int
    //   20	109	4	localObject1	Object
    //   140	11	4	localObject2	Object
    //   155	107	4	str	String
    //   8	123	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	108	140	finally
    //   108	115	140	finally
    //   120	137	140	finally
    //   69	101	153	java/lang/Throwable
    //   142	153	153	java/lang/Throwable
    //   171	188	153	java/lang/Throwable
    //   194	198	200	java/lang/Throwable
    //   207	211	214	java/lang/Throwable
    //   0	22	218	finally
    //   162	167	231	java/lang/Throwable
    //   225	229	235	java/lang/Throwable
    //   22	69	239	finally
    //   69	101	246	finally
    //   142	153	246	finally
    //   171	188	246	finally
    //   0	22	250	java/lang/Throwable
    //   22	69	257	java/lang/Throwable
  }
  
  /* Error */
  private static String b(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: invokestatic 227	com/unionpay/sdk/r:b	(Ljava/lang/String;)Z
    //   13: ifeq +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 169	java/lang/StringBuffer
    //   21: dup
    //   22: invokespecial 170	java/lang/StringBuffer:<init>	()V
    //   25: astore 7
    //   27: new 118	java/net/URL
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 121	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore 8
    //   37: aload 8
    //   39: aconst_null
    //   40: iconst_0
    //   41: invokestatic 129	com/unionpay/sdk/e:a	(Ljava/net/URL;Ljava/lang/String;Z)Ljava/net/URLConnection;
    //   44: checkcast 167	java/net/HttpURLConnection
    //   47: astore_3
    //   48: aload_0
    //   49: invokevirtual 151	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   52: ldc -103
    //   54: invokevirtual 96	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +289 -> 346
    //   60: aload_1
    //   61: invokestatic 227	com/unionpay/sdk/r:b	(Ljava/lang/String;)Z
    //   64: ifne +282 -> 346
    //   67: getstatic 33	com/unionpay/sdk/e:c	Ljava/util/HashMap;
    //   70: invokestatic 102	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   73: invokevirtual 106	java/lang/Thread:getId	()J
    //   76: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aload 8
    //   81: invokevirtual 393	java/net/URL:getHost	()Ljava/lang/String;
    //   84: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_3
    //   89: aload_1
    //   90: invokestatic 162	com/unionpay/sdk/e:a	(Ljava/net/URLConnection;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   93: astore_0
    //   94: aload_0
    //   95: ldc_w 421
    //   98: invokevirtual 175	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 191	java/net/HttpURLConnection:getResponseCode	()I
    //   105: sipush 200
    //   108: if_icmpne +129 -> 237
    //   111: iload_2
    //   112: ifeq +51 -> 163
    //   115: aload 7
    //   117: new 61	java/lang/String
    //   120: dup
    //   121: aload_0
    //   122: invokevirtual 225	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   125: invokestatic 423	com/unionpay/sdk/e:a	(Ljava/io/InputStream;)[B
    //   128: ldc_w 425
    //   131: invokespecial 428	java/lang/String:<init>	([BLjava/lang/String;)V
    //   134: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   137: pop
    //   138: aload 6
    //   140: astore_1
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 216	java/io/BufferedReader:close	()V
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   157: aload 7
    //   159: invokevirtual 222	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   162: areturn
    //   163: new 197	java/io/BufferedReader
    //   166: dup
    //   167: new 199	java/io/InputStreamReader
    //   170: dup
    //   171: aload_0
    //   172: invokevirtual 225	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   175: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   178: invokespecial 205	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 208	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   186: astore_3
    //   187: aload_3
    //   188: ifnull +46 -> 234
    //   191: aload 7
    //   193: ldc_w 430
    //   196: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   199: pop
    //   200: aload 7
    //   202: aload_3
    //   203: invokevirtual 212	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   206: pop
    //   207: goto -25 -> 182
    //   210: astore_3
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 216	java/io/BufferedReader:close	()V
    //   219: aload_0
    //   220: ifnull -63 -> 157
    //   223: aload_0
    //   224: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   227: goto -70 -> 157
    //   230: astore_0
    //   231: goto -74 -> 157
    //   234: goto -93 -> 141
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_0
    //   250: aload 4
    //   252: astore_3
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 216	java/io/BufferedReader:close	()V
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 219	java/net/HttpURLConnection:disconnect	()V
    //   269: aload_1
    //   270: athrow
    //   271: astore_0
    //   272: goto -27 -> 245
    //   275: astore_1
    //   276: goto -127 -> 149
    //   279: astore_0
    //   280: goto -123 -> 157
    //   283: astore_1
    //   284: goto -65 -> 219
    //   287: astore_3
    //   288: goto -27 -> 261
    //   291: astore_0
    //   292: goto -23 -> 269
    //   295: astore_1
    //   296: aload_3
    //   297: astore_0
    //   298: aload 4
    //   300: astore_3
    //   301: goto -48 -> 253
    //   304: astore_1
    //   305: aload 4
    //   307: astore_3
    //   308: goto -55 -> 253
    //   311: astore 4
    //   313: aload_1
    //   314: astore_3
    //   315: aload 4
    //   317: astore_1
    //   318: goto -65 -> 253
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_0
    //   324: aload 5
    //   326: astore_1
    //   327: goto -116 -> 211
    //   330: astore_0
    //   331: aload_3
    //   332: astore_0
    //   333: aload 5
    //   335: astore_1
    //   336: goto -125 -> 211
    //   339: astore_1
    //   340: aload 5
    //   342: astore_1
    //   343: goto -132 -> 211
    //   346: aload_3
    //   347: astore_0
    //   348: goto -254 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramString1	String
    //   0	351	1	paramString2	String
    //   0	351	2	paramBoolean	boolean
    //   47	156	3	localObject1	Object
    //   210	1	3	localThrowable1	Throwable
    //   252	6	3	localObject2	Object
    //   287	10	3	localThrowable2	Throwable
    //   300	47	3	localObject3	Object
    //   4	302	4	localObject4	Object
    //   311	5	4	localObject5	Object
    //   1	340	5	localObject6	Object
    //   7	132	6	localObject7	Object
    //   25	176	7	localStringBuffer	StringBuffer
    //   35	45	8	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   182	187	210	java/lang/Throwable
    //   191	207	210	java/lang/Throwable
    //   223	227	230	java/lang/Throwable
    //   27	48	247	finally
    //   241	245	271	java/lang/Throwable
    //   145	149	275	java/lang/Throwable
    //   153	157	279	java/lang/Throwable
    //   215	219	283	java/lang/Throwable
    //   257	261	287	java/lang/Throwable
    //   265	269	291	java/lang/Throwable
    //   48	94	295	finally
    //   94	111	304	finally
    //   115	138	304	finally
    //   163	182	304	finally
    //   182	187	311	finally
    //   191	207	311	finally
    //   27	48	321	java/lang/Throwable
    //   48	94	330	java/lang/Throwable
    //   94	111	339	java/lang/Throwable
    //   115	138	339	java/lang/Throwable
    //   163	182	339	java/lang/Throwable
  }
  
  static final class a
  {
    String a = null;
    String b = null;
    String c = null;
    String d = null;
    String e = null;
  }
  
  static final class b
    implements X509TrustManager
  {
    X509Certificate a;
    
    b(X509Certificate paramX509Certificate)
    {
      this.a = paramX509Certificate;
    }
    
    public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    {
      if (paramArrayOfX509Certificate.length == 0) {
        throw new CertificateException("No server certificate found!");
      }
      if (!paramArrayOfX509Certificate[0].getIssuerDN().equals(this.a.getSubjectDN())) {
        throw new CertificateException("Parent certificate of server was different than expected signing certificate");
      }
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
        if (localObject.length >= 2) {
          paramString = localObject[(localObject.length - 2)] + "." + localObject[(localObject.length - 1)];
        }
        for (;;)
        {
          if (!e.c.containsKey(Long.valueOf(Thread.currentThread().getId()))) {
            throw new CertificateException("No valid host provided!");
          }
          if (!((String)e.c.get(Long.valueOf(Thread.currentThread().getId()))).endsWith(paramString)) {
            throw new CertificateException("Server certificate has incorrect host name!");
          }
          paramArrayOfX509Certificate[0].verify(this.a.getPublicKey());
          paramArrayOfX509Certificate[0].checkValidity();
          return;
        }
        return;
      }
      catch (Throwable paramArrayOfX509Certificate) {}
    }
    
    public final X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
  
  public static class d
  {
    public int a;
    public String b;
    
    d()
    {
      this(600, "");
    }
    
    d(int paramInt, String paramString)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */