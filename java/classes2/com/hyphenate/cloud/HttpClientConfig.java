package com.hyphenate.cloud;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpClientConfig
{
  private static final String EASEMOB_PLATFORM = "Android";
  private static final String EASEMOB_USERSERVER_DOMAIN_ID = "hyphenate.com";
  public static int EM_DEFAULT_TIMEOUT = 60000;
  public static String EM_TIME_OUT_KEY = "em_timeout";
  
  public static String getBaseUrlByAppKey()
  {
    return EMHttpClient.getInstance().chatConfig().f();
  }
  
  public static DefaultHttpClient getDefaultHttpClient()
  {
    return getDefaultHttpClient("", EM_DEFAULT_TIMEOUT);
  }
  
  public static DefaultHttpClient getDefaultHttpClient(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, paramInt1);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, getDefaultUserAgent());
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    if (paramBoolean) {}
    for (Object localObject = SSLCustomSocketFactory.getSocketFactory();; localObject = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory())
    {
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, paramInt2));
      localObject = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      ((DefaultHttpClient)localObject).setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
      ((DefaultHttpClient)localObject).setReuseStrategy(new DefaultConnectionReuseStrategy());
      return (DefaultHttpClient)localObject;
    }
  }
  
  public static DefaultHttpClient getDefaultHttpClient(String paramString, int paramInt)
  {
    boolean bool2 = false;
    int j = 443;
    int i = j;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      i = j;
      bool1 = bool2;
      if (paramString.toLowerCase().startsWith("https://"))
      {
        paramString = paramString.substring("https://".length()).split("\\.");
        i = j;
        bool1 = bool2;
        if (paramString.length > 3) {
          try
          {
            i = Integer.parseInt(paramString[0]);
            if ((i < 0) || (i > 255)) {
              throw new NumberFormatException();
            }
          }
          catch (NumberFormatException paramString)
          {
            paramString.printStackTrace();
            bool1 = bool2;
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      return getDefaultHttpClient(paramInt, bool1, i);
      i = Integer.parseInt(paramString[1]);
      if ((i < 0) || (i > 255)) {
        throw new NumberFormatException();
      }
      i = Integer.parseInt(paramString[2]);
      if ((i < 0) || (i > 255)) {
        throw new NumberFormatException();
      }
      i = j;
      if (paramString[3].indexOf(':') != -1)
      {
        i = Integer.parseInt(paramString[3].substring(0, paramString[3].indexOf(':')));
        if ((i < 0) || (i > 255)) {
          throw new NumberFormatException();
        }
        String str = paramString[3].substring(paramString[3].indexOf(':') + 1);
        paramString = str;
        if (str.indexOf('/') != -1) {
          paramString = str.substring(0, str.indexOf('/'));
        }
      }
      try
      {
        i = Integer.parseInt(paramString);
        bool1 = true;
      }
      catch (NumberFormatException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          i = j;
        }
      }
    }
  }
  
  private static String getDefaultUserAgent()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Easemob-SDK(Android) ");
    EMClient.getInstance();
    return "3.4.0";
  }
  
  public static String getEaseMobUserServerDomainId()
  {
    return "hyphenate.com";
  }
  
  public static String getFileDirRemoteUrl()
  {
    String str = getBaseUrlByAppKey();
    return str + "/chatfiles/";
  }
  
  public static String getFileRemoteUrl(String paramString)
  {
    if (paramString.startsWith("http")) {
      return paramString;
    }
    String str = getFileDirRemoteUrl();
    return str + paramString;
  }
  
  public static int getTimeout(Map<String, String> paramMap)
  {
    int j = EM_DEFAULT_TIMEOUT;
    int i = j;
    if (paramMap != null)
    {
      i = j;
      if (paramMap.get(EM_TIME_OUT_KEY) != null)
      {
        i = Integer.valueOf((String)paramMap.get(EM_TIME_OUT_KEY)).intValue();
        paramMap.remove(EM_TIME_OUT_KEY);
      }
    }
    return i;
  }
  
  public static class SSLCustomSocketFactory
    extends org.apache.http.conn.ssl.SSLSocketFactory
  {
    private static final String KEY_PASS = "";
    private static final String TAG = "SSLCustomSocketFactory";
    static org.apache.http.conn.ssl.SSLSocketFactory mSocketFactory;
    static SSLContext sslContext;
    
    public SSLCustomSocketFactory(KeyStore paramKeyStore)
      throws Throwable
    {
      super();
    }
    
    /* Error */
    public static org.apache.http.conn.ssl.SSLSocketFactory getSocketFactory()
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: getstatic 33	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory:mSocketFactory	Lorg/apache/http/conn/ssl/SSLSocketFactory;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +192 -> 200
      //   11: ldc 35
      //   13: invokestatic 41	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
      //   16: astore 4
      //   18: invokestatic 46	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
      //   21: invokevirtual 50	com/hyphenate/chat/EMClient:getContext	()Landroid/content/Context;
      //   24: invokevirtual 56	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   27: astore 5
      //   29: aload 5
      //   31: ldc 58
      //   33: invokevirtual 64	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
      //   36: astore 6
      //   38: invokestatic 70	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
      //   41: invokestatic 73	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
      //   44: astore_3
      //   45: aload_3
      //   46: aconst_null
      //   47: aconst_null
      //   48: invokevirtual 77	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
      //   51: iconst_0
      //   52: istore_0
      //   53: iload_0
      //   54: aload 6
      //   56: arraylength
      //   57: if_icmpge +171 -> 228
      //   60: aload 6
      //   62: iload_0
      //   63: aaload
      //   64: astore_1
      //   65: aload 5
      //   67: new 79	java/lang/StringBuilder
      //   70: dup
      //   71: invokespecial 82	java/lang/StringBuilder:<init>	()V
      //   74: ldc 84
      //   76: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: aload_1
      //   80: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   86: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   89: astore_1
      //   90: aload 4
      //   92: aload_1
      //   93: invokevirtual 99	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
      //   96: astore_2
      //   97: getstatic 105	java/lang/System:out	Ljava/io/PrintStream;
      //   100: new 79	java/lang/StringBuilder
      //   103: dup
      //   104: invokespecial 82	java/lang/StringBuilder:<init>	()V
      //   107: ldc 107
      //   109: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: aload_2
      //   113: checkcast 109	java/security/cert/X509Certificate
      //   116: invokevirtual 113	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
      //   119: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   122: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   125: invokevirtual 122	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   128: aload_3
      //   129: new 79	java/lang/StringBuilder
      //   132: dup
      //   133: invokespecial 82	java/lang/StringBuilder:<init>	()V
      //   136: ldc 124
      //   138: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   141: iload_0
      //   142: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   145: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   148: aload_2
      //   149: invokevirtual 131	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
      //   152: aload_1
      //   153: ifnull +7 -> 160
      //   156: aload_1
      //   157: invokevirtual 136	java/io/InputStream:close	()V
      //   160: iload_0
      //   161: iconst_1
      //   162: iadd
      //   163: istore_0
      //   164: goto -111 -> 53
      //   167: astore_2
      //   168: aconst_null
      //   169: astore_1
      //   170: aload_2
      //   171: invokevirtual 139	java/lang/Exception:printStackTrace	()V
      //   174: aload_1
      //   175: ifnull -15 -> 160
      //   178: aload_1
      //   179: invokevirtual 136	java/io/InputStream:close	()V
      //   182: goto -22 -> 160
      //   185: astore_1
      //   186: ldc 15
      //   188: aload_1
      //   189: invokevirtual 142	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   192: invokestatic 148	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   195: pop
      //   196: aload_1
      //   197: invokevirtual 149	java/lang/Throwable:printStackTrace	()V
      //   200: getstatic 33	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory:mSocketFactory	Lorg/apache/http/conn/ssl/SSLSocketFactory;
      //   203: astore_1
      //   204: ldc 2
      //   206: monitorexit
      //   207: aload_1
      //   208: areturn
      //   209: astore_2
      //   210: aconst_null
      //   211: astore_1
      //   212: aload_1
      //   213: ifnull +7 -> 220
      //   216: aload_1
      //   217: invokevirtual 136	java/io/InputStream:close	()V
      //   220: aload_2
      //   221: athrow
      //   222: astore_1
      //   223: ldc 2
      //   225: monitorexit
      //   226: aload_1
      //   227: athrow
      //   228: ldc 15
      //   230: new 79	java/lang/StringBuilder
      //   233: dup
      //   234: invokespecial 82	java/lang/StringBuilder:<init>	()V
      //   237: ldc -105
      //   239: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   242: aload_3
      //   243: invokevirtual 154	java/security/KeyStore:getType	()Ljava/lang/String;
      //   246: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   249: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   252: invokestatic 159	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   255: new 2	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory
      //   258: dup
      //   259: aload_3
      //   260: invokespecial 160	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory:<init>	(Ljava/security/KeyStore;)V
      //   263: astore_1
      //   264: aload_1
      //   265: new 9	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory$1
      //   268: dup
      //   269: invokespecial 161	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory$1:<init>	()V
      //   272: invokevirtual 165	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
      //   275: ldc -89
      //   277: invokestatic 172	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
      //   280: putstatic 174	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory:sslContext	Ljavax/net/ssl/SSLContext;
      //   283: invokestatic 179	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
      //   286: invokestatic 182	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
      //   289: astore_2
      //   290: aload_2
      //   291: aload_3
      //   292: invokevirtual 185	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
      //   295: getstatic 174	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory:sslContext	Ljavax/net/ssl/SSLContext;
      //   298: aconst_null
      //   299: aload_2
      //   300: invokevirtual 189	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
      //   303: aconst_null
      //   304: invokevirtual 192	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
      //   307: aload_1
      //   308: putstatic 33	com/hyphenate/cloud/HttpClientConfig$SSLCustomSocketFactory:mSocketFactory	Lorg/apache/http/conn/ssl/SSLSocketFactory;
      //   311: goto -111 -> 200
      //   314: astore_2
      //   315: goto -103 -> 212
      //   318: astore_2
      //   319: goto -107 -> 212
      //   322: astore_2
      //   323: goto -153 -> 170
      // Local variable table:
      //   start	length	slot	name	signature
      //   52	112	0	i	int
      //   6	173	1	localObject1	Object
      //   185	12	1	localThrowable	Throwable
      //   203	14	1	localSSLSocketFactory	org.apache.http.conn.ssl.SSLSocketFactory
      //   222	5	1	localObject2	Object
      //   263	45	1	localSSLCustomSocketFactory	SSLCustomSocketFactory
      //   96	53	2	localCertificate	java.security.cert.Certificate
      //   167	4	2	localException1	Exception
      //   209	12	2	localObject3	Object
      //   289	11	2	localTrustManagerFactory	javax.net.ssl.TrustManagerFactory
      //   314	1	2	localObject4	Object
      //   318	1	2	localObject5	Object
      //   322	1	2	localException2	Exception
      //   44	248	3	localKeyStore	KeyStore
      //   16	75	4	localCertificateFactory	java.security.cert.CertificateFactory
      //   27	39	5	localAssetManager	android.content.res.AssetManager
      //   36	25	6	arrayOfString	String[]
      // Exception table:
      //   from	to	target	type
      //   65	90	167	java/lang/Exception
      //   11	51	185	java/lang/Throwable
      //   53	60	185	java/lang/Throwable
      //   156	160	185	java/lang/Throwable
      //   178	182	185	java/lang/Throwable
      //   216	220	185	java/lang/Throwable
      //   220	222	185	java/lang/Throwable
      //   228	311	185	java/lang/Throwable
      //   65	90	209	finally
      //   3	7	222	finally
      //   11	51	222	finally
      //   53	60	222	finally
      //   156	160	222	finally
      //   178	182	222	finally
      //   186	200	222	finally
      //   200	204	222	finally
      //   216	220	222	finally
      //   220	222	222	finally
      //   228	311	222	finally
      //   90	152	314	finally
      //   170	174	318	finally
      //   90	152	322	java/lang/Exception
    }
    
    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException, UnknownHostException
    {
      return (SSLSocket)sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/cloud/HttpClientConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */