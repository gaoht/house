package cn.jiguang.net;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cn.jiguang.f.e;
import cn.jiguang.f.h;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

@Instrumented
public class HttpUtils
{
  public static final String ENCODING_UTF_8;
  public static final String EQUAL_SIGN = "=";
  public static final String HTTP_DEFUALT_PROXY;
  public static final String PARAMETERS_SEPARATOR = "&";
  public static final String PATHS_SEPARATOR = "/";
  public static final String URL_AND_PARA_SEPARATOR = "?";
  private static SSLContext a;
  private static TrustManager b;
  private static boolean c;
  private static final SimpleDateFormat d;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[23];
    int j = 0;
    Object localObject1 = "\023%9EV";
    int i = 22;
    Object localObject2 = arrayOfString;
    Object localObject4 = localObject2;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int i1 = 0;
    int m = 0;
    int i4 = i;
    Object localObject3 = localObject1;
    int i3 = j;
    localObject2 = localObject4;
    int n = k;
    int i2;
    if (k <= 1)
    {
      i2 = i;
      label65:
      n = m;
      label68:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 110;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label68;
        ENCODING_UTF_8 = (String)localObject1;
        localObject1 = "wAQX@v_N_\\";
        i = 23;
        j = i3;
        break;
        HTTP_DEFUALT_PROXY = (String)localObject1;
        localObject1 = "垙呼斟攠";
        i = -1;
        j = i3;
        break;
      }
      i1 = n;
      n = k;
      localObject2 = localObject4;
      i3 = j;
      localObject3 = localObject1;
      i4 = i2;
      i2 = i4;
      localObject1 = localObject3;
      j = i3;
      localObject4 = localObject2;
      k = n;
      m = i1;
      if (n > i1) {
        break label65;
      }
      localObject1 = new String((char[])localObject3).intern();
      switch (i4)
      {
      case 22: 
      case 23: 
      default: 
        localObject2[i3] = localObject1;
        j = 1;
        localObject1 = "缗纭镦讇";
        i = 0;
        localObject2 = arrayOfString;
        break;
      case 0: 
        localObject2[i3] = localObject1;
        j = 2;
        localObject1 = "\026>,<";
        i = 1;
        localObject2 = arrayOfString;
        break;
      case 1: 
        localObject2[i3] = localObject1;
        j = 3;
        localObject1 = "讱氳跺斞";
        i = 2;
        localObject2 = arrayOfString;
        break;
      case 2: 
        localObject2[i3] = localObject1;
        j = 4;
        localObject1 = ".\005\013\030N6\036\f\034N\003\t\034\r\0362\030\020\006N#\003\r\007\034|";
        i = 3;
        localObject2 = arrayOfString;
        break;
      case 3: 
        localObject2[i3] = localObject1;
        j = 5;
        localObject1 = "\016\005\013\030;2\030\023\033";
        i = 4;
        localObject2 = arrayOfString;
        break;
      case 4: 
        localObject2[i3] = localObject1;
        j = 6;
        localObject1 = "\013\020\023\016\0014\034\032\f;\024=:\020\r#\001\013\001\001(";
        i = 5;
        localObject2 = arrayOfString;
        break;
      case 5: 
        localObject2[i3] = localObject1;
        j = 7;
        localObject1 = "\023?4\006\0011Q\032\020\013%\001\013\001\001(";
        i = 6;
        localObject2 = arrayOfString;
        break;
      case 6: 
        localObject2[i3] = localObject1;
        j = 8;
        localObject1 = "\025\"3奙赋";
        i = 7;
        localObject2 = arrayOfString;
        break;
      case 7: 
        localObject2[i3] = localObject1;
        j = 9;
        localObject1 = ".\005\013\030N6\036\f\034Nf\024\r\032\0014K";
        i = 8;
        localObject2 = arrayOfString;
        break;
      case 8: 
        localObject2[i3] = localObject1;
        j = 10;
        localObject1 = ".\005\013\030N6\036\f\034N\017>:\020\r#\001\013\001\001(Q\032\032\034)\003E";
        i = 9;
        localObject2 = arrayOfString;
        break;
      case 9: 
        localObject2[i3] = localObject1;
        j = 11;
        localObject1 = "\025\005\036\013\005\t\007\032\032\b*\036\b-\0344\036\r";
        i = 10;
        localObject2 = arrayOfString;
        break;
      case 10: 
        localObject2[i3] = localObject1;
        j = 12;
        localObject1 = "\005\020\034\000\013k2\020\006\0324\036\023";
        i = 11;
        localObject2 = arrayOfString;
        break;
      case 11: 
        localObject2[i3] = localObject1;
        j = 13;
        localObject1 = "%\020\034\000\013k\022\020\006\0324\036\023";
        i = 12;
        localObject2 = arrayOfString;
        break;
      case 12: 
        localObject2[i3] = localObject1;
        j = 14;
        localObject1 = "\003\t\017\001\034#\002";
        i = 13;
        localObject2 = arrayOfString;
        break;
      case 13: 
        localObject2[i3] = localObject1;
        j = 15;
        localObject1 = "#\t\017\001\034#\002";
        i = 14;
        localObject2 = arrayOfString;
        break;
      case 14: 
        localObject2[i3] = localObject1;
        j = 16;
        localObject1 = "\022=,";
        i = 15;
        localObject2 = arrayOfString;
        break;
      case 15: 
        localObject2[i3] = localObject1;
        j = 17;
        localObject1 = "%\034\b\t\036";
        i = 16;
        localObject2 = arrayOfString;
        break;
      case 16: 
        localObject2[i3] = localObject1;
        j = 18;
        localObject1 = "%\036\021\006\013%\005\026\036\0072\b";
        i = 17;
        localObject2 = arrayOfString;
        break;
      case 17: 
        localObject2[i3] = localObject1;
        j = 19;
        localObject1 = "u\026\b\t\036";
        i = 18;
        localObject2 = arrayOfString;
        break;
      case 18: 
        localObject2[i3] = localObject1;
        j = 20;
        localObject1 = "'\037\033\032\001/\025Q\030\0134\034\026\033\035/\036\021F/\0052:;=\031?:<9\t#47=\0220+-";
        i = 19;
        localObject2 = arrayOfString;
        break;
      case 19: 
        localObject2[i3] = localObject1;
        j = 21;
        localObject1 = "3\037\026\037\0176";
        i = 20;
        localObject2 = arrayOfString;
        break;
      case 20: 
        localObject2[i3] = localObject1;
        j = 22;
        localObject1 = "\0034:DN\"Q2%#f\b\006\021\027f97R\003+K\f\033N<";
        i = 21;
        localObject2 = arrayOfString;
        break;
      case 21: 
        localObject2[i3] = localObject1;
        z = arrayOfString;
        a = null;
        b = null;
        d = new SimpleDateFormat(z[22], Locale.ENGLISH);
        return;
        i = 70;
        continue;
        i = 113;
        continue;
        i = 127;
        continue;
        i = 104;
      }
    }
  }
  
  private static void a(HttpRequest paramHttpRequest, HttpURLConnection paramHttpURLConnection)
  {
    if ((paramHttpRequest == null) || (paramHttpURLConnection == null)) {}
    do
    {
      return;
      setURLConnection(paramHttpRequest.getRequestProperties(), paramHttpURLConnection);
      if (paramHttpRequest.getConnectTimeout() >= 0) {
        paramHttpURLConnection.setConnectTimeout(paramHttpRequest.getConnectTimeout());
      }
    } while (paramHttpRequest.getReadTimeout() < 0);
    paramHttpURLConnection.setReadTimeout(paramHttpRequest.getReadTimeout());
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, HttpResponse paramHttpResponse)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    paramHttpResponse.setResponseCode(paramHttpURLConnection.getResponseCode());
    paramHttpResponse.setResponseHeader(z[15], paramHttpURLConnection.getHeaderField(z[14]));
    paramHttpResponse.setResponseHeader(z[13], paramHttpURLConnection.getHeaderField(z[12]));
  }
  
  public static String appendParaToUrl(String paramString1, String paramString2, String paramString3)
  {
    if (h.a(paramString1)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (!paramString1.contains("?")) {
      localStringBuilder.append("?");
    }
    for (;;)
    {
      return paramString2 + "=" + paramString3;
      localStringBuilder.append("&");
    }
  }
  
  public static void createSSLConnection()
  {
    try
    {
      if (c)
      {
        localObject = SSLContext.getInstance(z[16]);
        a = (SSLContext)localObject;
        ((SSLContext)localObject).init(null, null, new SecureRandom());
        return;
      }
      b = new e();
      Object localObject = b;
      SSLContext localSSLContext = SSLContext.getInstance(z[16]);
      a = localSSLContext;
      localSSLContext.init(null, new TrustManager[] { localObject }, null);
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return;
    }
    catch (KeyManagementException localKeyManagementException)
    {
      localKeyManagementException.printStackTrace();
    }
  }
  
  public static HttpURLConnection getHttpURLConnectionWithProxy(Context paramContext, String paramString)
  {
    paramString = new URL(paramString);
    if ((paramContext != null) && (paramContext.getPackageManager().checkPermission(z[20], paramContext.getPackageName()) == 0))
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService(z[18])).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() != 1))
      {
        paramContext = paramContext.getExtraInfo();
        if ((paramContext != null) && ((paramContext.equals(z[17])) || (paramContext.equals(z[19])) || (paramContext.equals(z[21]))))
        {
          paramContext = new InetSocketAddress(HTTP_DEFUALT_PROXY, 80);
          return (HttpURLConnection)paramString.openConnection(new Proxy(Proxy.Type.HTTP, paramContext));
        }
      }
    }
    if (!(paramString instanceof URL)) {}
    for (paramContext = paramString.openConnection();; paramContext = HttpInstrumentation.openConnection((URL)paramString)) {
      return (HttpURLConnection)paramContext;
    }
  }
  
  public static String getUrlWithParas(String paramString, Map<String, String> paramMap)
  {
    String str = paramString;
    if (h.a(paramString)) {
      str = "";
    }
    paramString = new StringBuilder(str);
    paramMap = joinParas(paramMap);
    if (!h.a(paramMap)) {
      paramString.append("?").append(paramMap);
    }
    return paramString.toString();
  }
  
  public static String getUrlWithValueEncodeParas(String paramString, Map<String, String> paramMap)
  {
    String str = paramString;
    if (h.a(paramString)) {
      str = "";
    }
    paramString = new StringBuilder(str);
    paramMap = joinParasWithEncodedValue(paramMap);
    if (!h.a(paramMap)) {
      paramString.append("?").append(paramMap);
    }
    return paramString.toString();
  }
  
  /* Error */
  public static HttpResponse httpGet(Context paramContext, HttpRequest paramHttpRequest)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 155	cn/jiguang/net/HttpResponse
    //   9: dup
    //   10: aload_1
    //   11: invokevirtual 315	cn/jiguang/net/HttpRequest:getUrl	()Ljava/lang/String;
    //   14: invokespecial 316	cn/jiguang/net/HttpResponse:<init>	(Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 315	cn/jiguang/net/HttpRequest:getUrl	()Ljava/lang/String;
    //   23: invokestatic 318	cn/jiguang/net/HttpUtils:getHttpURLConnectionWithProxy	(Landroid/content/Context;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: instanceof 320
    //   33: ifeq +54 -> 87
    //   36: aload_2
    //   37: astore_0
    //   38: invokestatic 322	cn/jiguang/net/HttpUtils:createSSLConnection	()V
    //   41: aload_2
    //   42: astore_0
    //   43: getstatic 104	cn/jiguang/net/HttpUtils:a	Ljavax/net/ssl/SSLContext;
    //   46: ifnull +18 -> 64
    //   49: aload_2
    //   50: astore_0
    //   51: aload_2
    //   52: checkcast 320	javax/net/ssl/HttpsURLConnection
    //   55: getstatic 104	cn/jiguang/net/HttpUtils:a	Ljavax/net/ssl/SSLContext;
    //   58: invokevirtual 326	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   61: invokevirtual 330	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   64: aload_2
    //   65: astore_0
    //   66: getstatic 106	cn/jiguang/net/HttpUtils:b	Ljavax/net/ssl/TrustManager;
    //   69: ifnull +18 -> 87
    //   72: aload_2
    //   73: astore_0
    //   74: aload_2
    //   75: checkcast 320	javax/net/ssl/HttpsURLConnection
    //   78: getstatic 106	cn/jiguang/net/HttpUtils:b	Ljavax/net/ssl/TrustManager;
    //   81: checkcast 332	javax/net/ssl/HostnameVerifier
    //   84: invokevirtual 336	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   87: aload_2
    //   88: astore_0
    //   89: aload_1
    //   90: aload_2
    //   91: invokestatic 338	cn/jiguang/net/HttpUtils:a	(Lcn/jiguang/net/HttpRequest;Ljava/net/HttpURLConnection;)V
    //   94: aload_2
    //   95: astore_0
    //   96: aload_1
    //   97: invokevirtual 342	cn/jiguang/net/HttpRequest:isHaveRspData	()Z
    //   100: ifeq +34 -> 134
    //   103: aload_2
    //   104: astore_0
    //   105: aload_2
    //   106: invokevirtual 346	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   109: invokestatic 350	cn/jiguang/net/HttpUtils:readInputStream	(Ljava/io/InputStream;)[B
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +20 -> 134
    //   117: aload_2
    //   118: astore_0
    //   119: aload_3
    //   120: new 34	java/lang/String
    //   123: dup
    //   124: aload_1
    //   125: getstatic 42	cn/jiguang/net/HttpUtils:ENCODING_UTF_8	Ljava/lang/String;
    //   128: invokespecial 353	java/lang/String:<init>	([BLjava/lang/String;)V
    //   131: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   134: aload_2
    //   135: astore_0
    //   136: aload_2
    //   137: aload_3
    //   138: invokestatic 358	cn/jiguang/net/HttpUtils:a	(Ljava/net/HttpURLConnection;Lcn/jiguang/net/HttpResponse;)V
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   149: aload_3
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_2
    //   155: astore_0
    //   156: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   159: iconst_5
    //   160: aaload
    //   161: new 175	java/lang/StringBuilder
    //   164: dup
    //   165: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   168: bipush 9
    //   170: aaload
    //   171: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_1
    //   175: invokevirtual 364	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   178: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_2
    //   188: astore_0
    //   189: aload_3
    //   190: sipush 3004
    //   193: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   196: aload_2
    //   197: astore_0
    //   198: aload_3
    //   199: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   202: bipush 6
    //   204: aaload
    //   205: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   208: aload_2
    //   209: ifnull -60 -> 149
    //   212: aload_2
    //   213: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   216: goto -67 -> 149
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: astore_0
    //   224: aload_3
    //   225: sipush 2998
    //   228: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   231: aload_2
    //   232: astore_0
    //   233: aload_3
    //   234: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   237: iconst_1
    //   238: aaload
    //   239: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: astore_0
    //   244: aload_1
    //   245: instanceof 371
    //   248: ifeq +67 -> 315
    //   251: aload_2
    //   252: astore_0
    //   253: aload_3
    //   254: sipush 3001
    //   257: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   260: aload_2
    //   261: astore_0
    //   262: aload_3
    //   263: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   266: iconst_3
    //   267: aaload
    //   268: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   271: aload_2
    //   272: astore_0
    //   273: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   276: iconst_5
    //   277: aaload
    //   278: new 175	java/lang/StringBuilder
    //   281: dup
    //   282: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   285: bipush 10
    //   287: aaload
    //   288: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: aload_1
    //   292: invokevirtual 372	java/io/IOException:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_2
    //   305: ifnull -156 -> 149
    //   308: aload_2
    //   309: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   312: goto -163 -> 149
    //   315: aload_2
    //   316: astore_0
    //   317: aload_1
    //   318: instanceof 374
    //   321: ifeq +41 -> 362
    //   324: aload_2
    //   325: astore_0
    //   326: aload_3
    //   327: sipush 3003
    //   330: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   333: aload_2
    //   334: astore_0
    //   335: aload_3
    //   336: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   339: iconst_0
    //   340: aaload
    //   341: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   344: goto -73 -> 271
    //   347: astore_2
    //   348: aload_0
    //   349: astore_1
    //   350: aload_2
    //   351: astore_0
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   360: aload_0
    //   361: athrow
    //   362: aload_2
    //   363: astore_0
    //   364: aload_1
    //   365: instanceof 376
    //   368: ifeq -97 -> 271
    //   371: aload_2
    //   372: astore_0
    //   373: aload_3
    //   374: sipush 3005
    //   377: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   380: aload_2
    //   381: astore_0
    //   382: aload_3
    //   383: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   386: bipush 8
    //   388: aaload
    //   389: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   392: aload_2
    //   393: astore_0
    //   394: iconst_1
    //   395: putstatic 196	cn/jiguang/net/HttpUtils:c	Z
    //   398: goto -127 -> 271
    //   401: aload_2
    //   402: astore_0
    //   403: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   406: iconst_5
    //   407: aaload
    //   408: new 175	java/lang/StringBuilder
    //   411: dup
    //   412: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   415: iconst_4
    //   416: aaload
    //   417: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   420: aload_1
    //   421: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   424: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: aload_2
    //   434: astore_0
    //   435: aload_3
    //   436: sipush 3006
    //   439: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   442: aload_2
    //   443: astore_0
    //   444: aload_3
    //   445: new 175	java/lang/StringBuilder
    //   448: dup
    //   449: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   452: bipush 7
    //   454: aaload
    //   455: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   462: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   471: aload_2
    //   472: ifnull -323 -> 149
    //   475: aload_2
    //   476: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   479: goto -330 -> 149
    //   482: astore_0
    //   483: aconst_null
    //   484: astore_2
    //   485: aload_2
    //   486: astore_0
    //   487: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   490: iconst_5
    //   491: aaload
    //   492: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   495: bipush 11
    //   497: aaload
    //   498: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: aload_2
    //   502: astore_0
    //   503: aload_3
    //   504: sipush 3007
    //   507: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   510: aload_2
    //   511: astore_0
    //   512: aload_3
    //   513: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   516: bipush 11
    //   518: aaload
    //   519: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   522: aload_2
    //   523: ifnull -374 -> 149
    //   526: aload_2
    //   527: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   530: goto -381 -> 149
    //   533: astore_0
    //   534: aconst_null
    //   535: astore_1
    //   536: goto -184 -> 352
    //   539: astore_0
    //   540: goto -55 -> 485
    //   543: astore_1
    //   544: goto -143 -> 401
    //   547: astore_1
    //   548: goto -326 -> 222
    //   551: astore_1
    //   552: goto -398 -> 154
    //   555: astore_1
    //   556: aconst_null
    //   557: astore_2
    //   558: goto -157 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	paramContext	Context
    //   0	561	1	paramHttpRequest	HttpRequest
    //   26	308	2	localHttpURLConnection	HttpURLConnection
    //   347	129	2	localObject1	Object
    //   484	74	2	localObject2	Object
    //   17	496	3	localHttpResponse	HttpResponse
    // Exception table:
    //   from	to	target	type
    //   18	27	151	java/net/MalformedURLException
    //   18	27	219	java/io/IOException
    //   29	36	347	finally
    //   38	41	347	finally
    //   43	49	347	finally
    //   51	64	347	finally
    //   66	72	347	finally
    //   74	87	347	finally
    //   89	94	347	finally
    //   96	103	347	finally
    //   105	113	347	finally
    //   119	134	347	finally
    //   136	141	347	finally
    //   156	187	347	finally
    //   189	196	347	finally
    //   198	208	347	finally
    //   224	231	347	finally
    //   233	242	347	finally
    //   244	251	347	finally
    //   253	260	347	finally
    //   262	271	347	finally
    //   273	304	347	finally
    //   317	324	347	finally
    //   326	333	347	finally
    //   335	344	347	finally
    //   364	371	347	finally
    //   373	380	347	finally
    //   382	392	347	finally
    //   394	398	347	finally
    //   403	433	347	finally
    //   435	442	347	finally
    //   444	471	347	finally
    //   487	501	347	finally
    //   503	510	347	finally
    //   512	522	347	finally
    //   18	27	482	java/lang/StackOverflowError
    //   18	27	533	finally
    //   29	36	539	java/lang/StackOverflowError
    //   38	41	539	java/lang/StackOverflowError
    //   43	49	539	java/lang/StackOverflowError
    //   51	64	539	java/lang/StackOverflowError
    //   66	72	539	java/lang/StackOverflowError
    //   74	87	539	java/lang/StackOverflowError
    //   89	94	539	java/lang/StackOverflowError
    //   96	103	539	java/lang/StackOverflowError
    //   105	113	539	java/lang/StackOverflowError
    //   119	134	539	java/lang/StackOverflowError
    //   136	141	539	java/lang/StackOverflowError
    //   29	36	543	java/lang/Exception
    //   38	41	543	java/lang/Exception
    //   43	49	543	java/lang/Exception
    //   51	64	543	java/lang/Exception
    //   66	72	543	java/lang/Exception
    //   74	87	543	java/lang/Exception
    //   89	94	543	java/lang/Exception
    //   96	103	543	java/lang/Exception
    //   105	113	543	java/lang/Exception
    //   119	134	543	java/lang/Exception
    //   136	141	543	java/lang/Exception
    //   29	36	547	java/io/IOException
    //   38	41	547	java/io/IOException
    //   43	49	547	java/io/IOException
    //   51	64	547	java/io/IOException
    //   66	72	547	java/io/IOException
    //   74	87	547	java/io/IOException
    //   89	94	547	java/io/IOException
    //   96	103	547	java/io/IOException
    //   105	113	547	java/io/IOException
    //   119	134	547	java/io/IOException
    //   136	141	547	java/io/IOException
    //   29	36	551	java/net/MalformedURLException
    //   38	41	551	java/net/MalformedURLException
    //   43	49	551	java/net/MalformedURLException
    //   51	64	551	java/net/MalformedURLException
    //   66	72	551	java/net/MalformedURLException
    //   74	87	551	java/net/MalformedURLException
    //   89	94	551	java/net/MalformedURLException
    //   96	103	551	java/net/MalformedURLException
    //   105	113	551	java/net/MalformedURLException
    //   119	134	551	java/net/MalformedURLException
    //   136	141	551	java/net/MalformedURLException
    //   18	27	555	java/lang/Exception
  }
  
  public static HttpResponse httpGet(Context paramContext, String paramString)
  {
    return httpGet(paramContext, new HttpRequest(paramString));
  }
  
  public static void httpGet(Context paramContext, HttpRequest paramHttpRequest, HttpUtils.HttpListener paramHttpListener)
  {
    new a(paramContext, paramHttpListener).execute(new HttpRequest[] { paramHttpRequest });
  }
  
  public static void httpGet(Context paramContext, String paramString, HttpUtils.HttpListener paramHttpListener)
  {
    new b(paramHttpListener, paramContext).execute(new String[] { paramString });
  }
  
  public static String httpGetString(Context paramContext, HttpRequest paramHttpRequest)
  {
    paramContext = httpGet(paramContext, paramHttpRequest);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getResponseBody();
  }
  
  public static String httpGetString(Context paramContext, String paramString)
  {
    paramContext = httpGet(paramContext, new HttpRequest(paramString));
    if (paramContext == null) {
      return null;
    }
    return paramContext.getResponseBody();
  }
  
  /* Error */
  public static HttpResponse httpPost(Context paramContext, HttpRequest paramHttpRequest)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 155	cn/jiguang/net/HttpResponse
    //   9: dup
    //   10: aload_1
    //   11: invokevirtual 315	cn/jiguang/net/HttpRequest:getUrl	()Ljava/lang/String;
    //   14: invokespecial 316	cn/jiguang/net/HttpResponse:<init>	(Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 315	cn/jiguang/net/HttpRequest:getUrl	()Ljava/lang/String;
    //   23: invokestatic 318	cn/jiguang/net/HttpUtils:getHttpURLConnectionWithProxy	(Landroid/content/Context;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: instanceof 320
    //   33: ifeq +54 -> 87
    //   36: aload_2
    //   37: astore_0
    //   38: invokestatic 322	cn/jiguang/net/HttpUtils:createSSLConnection	()V
    //   41: aload_2
    //   42: astore_0
    //   43: getstatic 104	cn/jiguang/net/HttpUtils:a	Ljavax/net/ssl/SSLContext;
    //   46: ifnull +18 -> 64
    //   49: aload_2
    //   50: astore_0
    //   51: aload_2
    //   52: checkcast 320	javax/net/ssl/HttpsURLConnection
    //   55: getstatic 104	cn/jiguang/net/HttpUtils:a	Ljavax/net/ssl/SSLContext;
    //   58: invokevirtual 326	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   61: invokevirtual 330	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   64: aload_2
    //   65: astore_0
    //   66: getstatic 106	cn/jiguang/net/HttpUtils:b	Ljavax/net/ssl/TrustManager;
    //   69: ifnull +18 -> 87
    //   72: aload_2
    //   73: astore_0
    //   74: aload_2
    //   75: checkcast 320	javax/net/ssl/HttpsURLConnection
    //   78: getstatic 106	cn/jiguang/net/HttpUtils:b	Ljavax/net/ssl/TrustManager;
    //   81: checkcast 332	javax/net/ssl/HostnameVerifier
    //   84: invokevirtual 336	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   87: aload_2
    //   88: astore_0
    //   89: aload_1
    //   90: aload_2
    //   91: invokestatic 338	cn/jiguang/net/HttpUtils:a	(Lcn/jiguang/net/HttpRequest;Ljava/net/HttpURLConnection;)V
    //   94: aload_2
    //   95: astore_0
    //   96: aload_2
    //   97: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   100: iconst_2
    //   101: aaload
    //   102: invokevirtual 408	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: astore_0
    //   107: aload_2
    //   108: iconst_1
    //   109: invokevirtual 412	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   112: aload_2
    //   113: astore_0
    //   114: aload_2
    //   115: iconst_1
    //   116: invokevirtual 415	java/net/HttpURLConnection:setDoInput	(Z)V
    //   119: aload_2
    //   120: astore_0
    //   121: aload_1
    //   122: invokevirtual 419	cn/jiguang/net/HttpRequest:getParas	()[B
    //   125: astore 4
    //   127: aload 4
    //   129: ifnull +14 -> 143
    //   132: aload_2
    //   133: astore_0
    //   134: aload_2
    //   135: invokevirtual 423	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   138: aload 4
    //   140: invokevirtual 429	java/io/OutputStream:write	([B)V
    //   143: aload_2
    //   144: astore_0
    //   145: aload_1
    //   146: invokevirtual 342	cn/jiguang/net/HttpRequest:isHaveRspData	()Z
    //   149: ifeq +34 -> 183
    //   152: aload_2
    //   153: astore_0
    //   154: aload_2
    //   155: invokevirtual 346	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   158: invokestatic 350	cn/jiguang/net/HttpUtils:readInputStream	(Ljava/io/InputStream;)[B
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +20 -> 183
    //   166: aload_2
    //   167: astore_0
    //   168: aload_3
    //   169: new 34	java/lang/String
    //   172: dup
    //   173: aload_1
    //   174: getstatic 42	cn/jiguang/net/HttpUtils:ENCODING_UTF_8	Ljava/lang/String;
    //   177: invokespecial 353	java/lang/String:<init>	([BLjava/lang/String;)V
    //   180: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   183: aload_2
    //   184: astore_0
    //   185: aload_2
    //   186: aload_3
    //   187: invokestatic 358	cn/jiguang/net/HttpUtils:a	(Ljava/net/HttpURLConnection;Lcn/jiguang/net/HttpResponse;)V
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   198: aload_3
    //   199: areturn
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: astore_0
    //   205: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   208: iconst_5
    //   209: aaload
    //   210: new 175	java/lang/StringBuilder
    //   213: dup
    //   214: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   217: bipush 9
    //   219: aaload
    //   220: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload_1
    //   224: invokevirtual 364	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_2
    //   237: astore_0
    //   238: aload_3
    //   239: sipush 3004
    //   242: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   245: aload_2
    //   246: astore_0
    //   247: aload_3
    //   248: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   251: bipush 6
    //   253: aaload
    //   254: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   257: aload_2
    //   258: ifnull -60 -> 198
    //   261: aload_2
    //   262: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   265: goto -67 -> 198
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_2
    //   272: astore_0
    //   273: aload_3
    //   274: sipush 2998
    //   277: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   280: aload_2
    //   281: astore_0
    //   282: aload_3
    //   283: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   286: iconst_1
    //   287: aaload
    //   288: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   291: aload_2
    //   292: astore_0
    //   293: aload_1
    //   294: instanceof 371
    //   297: ifeq +67 -> 364
    //   300: aload_2
    //   301: astore_0
    //   302: aload_3
    //   303: sipush 3001
    //   306: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   309: aload_2
    //   310: astore_0
    //   311: aload_3
    //   312: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   315: iconst_3
    //   316: aaload
    //   317: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   320: aload_2
    //   321: astore_0
    //   322: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   325: iconst_5
    //   326: aaload
    //   327: new 175	java/lang/StringBuilder
    //   330: dup
    //   331: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   334: bipush 10
    //   336: aaload
    //   337: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload_1
    //   341: invokevirtual 372	java/io/IOException:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: aload_2
    //   354: ifnull -156 -> 198
    //   357: aload_2
    //   358: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   361: goto -163 -> 198
    //   364: aload_2
    //   365: astore_0
    //   366: aload_1
    //   367: instanceof 374
    //   370: ifeq +41 -> 411
    //   373: aload_2
    //   374: astore_0
    //   375: aload_3
    //   376: sipush 3003
    //   379: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   382: aload_2
    //   383: astore_0
    //   384: aload_3
    //   385: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   388: iconst_0
    //   389: aaload
    //   390: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   393: goto -73 -> 320
    //   396: astore_2
    //   397: aload_0
    //   398: astore_1
    //   399: aload_2
    //   400: astore_0
    //   401: aload_1
    //   402: ifnull +7 -> 409
    //   405: aload_1
    //   406: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   409: aload_0
    //   410: athrow
    //   411: aload_2
    //   412: astore_0
    //   413: aload_1
    //   414: instanceof 376
    //   417: ifeq -97 -> 320
    //   420: aload_2
    //   421: astore_0
    //   422: aload_3
    //   423: sipush 3005
    //   426: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   429: aload_2
    //   430: astore_0
    //   431: aload_3
    //   432: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   435: bipush 8
    //   437: aaload
    //   438: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   441: aload_2
    //   442: astore_0
    //   443: iconst_1
    //   444: putstatic 196	cn/jiguang/net/HttpUtils:c	Z
    //   447: goto -127 -> 320
    //   450: aload_2
    //   451: astore_0
    //   452: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   455: iconst_5
    //   456: aaload
    //   457: new 175	java/lang/StringBuilder
    //   460: dup
    //   461: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   464: iconst_4
    //   465: aaload
    //   466: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   469: aload_1
    //   470: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   473: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aload_2
    //   483: astore_0
    //   484: aload_3
    //   485: sipush 3006
    //   488: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   491: aload_2
    //   492: astore_0
    //   493: aload_3
    //   494: new 175	java/lang/StringBuilder
    //   497: dup
    //   498: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   501: bipush 7
    //   503: aaload
    //   504: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   507: aload_1
    //   508: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   511: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   520: aload_2
    //   521: ifnull -323 -> 198
    //   524: aload_2
    //   525: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   528: goto -330 -> 198
    //   531: astore_0
    //   532: aconst_null
    //   533: astore_2
    //   534: aload_2
    //   535: astore_0
    //   536: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   539: iconst_5
    //   540: aaload
    //   541: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   544: bipush 11
    //   546: aaload
    //   547: invokestatic 369	cn/jiguang/d/d:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload_2
    //   551: astore_0
    //   552: aload_3
    //   553: sipush 3007
    //   556: invokevirtual 158	cn/jiguang/net/HttpResponse:setResponseCode	(I)V
    //   559: aload_2
    //   560: astore_0
    //   561: aload_3
    //   562: getstatic 102	cn/jiguang/net/HttpUtils:z	[Ljava/lang/String;
    //   565: bipush 11
    //   567: aaload
    //   568: invokevirtual 356	cn/jiguang/net/HttpResponse:setResponseBody	(Ljava/lang/String;)V
    //   571: aload_2
    //   572: ifnull -374 -> 198
    //   575: aload_2
    //   576: invokevirtual 361	java/net/HttpURLConnection:disconnect	()V
    //   579: goto -381 -> 198
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_1
    //   585: goto -184 -> 401
    //   588: astore_0
    //   589: goto -55 -> 534
    //   592: astore_1
    //   593: goto -143 -> 450
    //   596: astore_1
    //   597: goto -326 -> 271
    //   600: astore_1
    //   601: goto -398 -> 203
    //   604: astore_1
    //   605: aconst_null
    //   606: astore_2
    //   607: goto -157 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	paramContext	Context
    //   0	610	1	paramHttpRequest	HttpRequest
    //   26	357	2	localHttpURLConnection	HttpURLConnection
    //   396	129	2	localObject1	Object
    //   533	74	2	localObject2	Object
    //   17	545	3	localHttpResponse	HttpResponse
    //   125	14	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	27	200	java/net/MalformedURLException
    //   18	27	268	java/io/IOException
    //   29	36	396	finally
    //   38	41	396	finally
    //   43	49	396	finally
    //   51	64	396	finally
    //   66	72	396	finally
    //   74	87	396	finally
    //   89	94	396	finally
    //   96	105	396	finally
    //   107	112	396	finally
    //   114	119	396	finally
    //   121	127	396	finally
    //   134	143	396	finally
    //   145	152	396	finally
    //   154	162	396	finally
    //   168	183	396	finally
    //   185	190	396	finally
    //   205	236	396	finally
    //   238	245	396	finally
    //   247	257	396	finally
    //   273	280	396	finally
    //   282	291	396	finally
    //   293	300	396	finally
    //   302	309	396	finally
    //   311	320	396	finally
    //   322	353	396	finally
    //   366	373	396	finally
    //   375	382	396	finally
    //   384	393	396	finally
    //   413	420	396	finally
    //   422	429	396	finally
    //   431	441	396	finally
    //   443	447	396	finally
    //   452	482	396	finally
    //   484	491	396	finally
    //   493	520	396	finally
    //   536	550	396	finally
    //   552	559	396	finally
    //   561	571	396	finally
    //   18	27	531	java/lang/StackOverflowError
    //   18	27	582	finally
    //   29	36	588	java/lang/StackOverflowError
    //   38	41	588	java/lang/StackOverflowError
    //   43	49	588	java/lang/StackOverflowError
    //   51	64	588	java/lang/StackOverflowError
    //   66	72	588	java/lang/StackOverflowError
    //   74	87	588	java/lang/StackOverflowError
    //   89	94	588	java/lang/StackOverflowError
    //   96	105	588	java/lang/StackOverflowError
    //   107	112	588	java/lang/StackOverflowError
    //   114	119	588	java/lang/StackOverflowError
    //   121	127	588	java/lang/StackOverflowError
    //   134	143	588	java/lang/StackOverflowError
    //   145	152	588	java/lang/StackOverflowError
    //   154	162	588	java/lang/StackOverflowError
    //   168	183	588	java/lang/StackOverflowError
    //   185	190	588	java/lang/StackOverflowError
    //   29	36	592	java/lang/Exception
    //   38	41	592	java/lang/Exception
    //   43	49	592	java/lang/Exception
    //   51	64	592	java/lang/Exception
    //   66	72	592	java/lang/Exception
    //   74	87	592	java/lang/Exception
    //   89	94	592	java/lang/Exception
    //   96	105	592	java/lang/Exception
    //   107	112	592	java/lang/Exception
    //   114	119	592	java/lang/Exception
    //   121	127	592	java/lang/Exception
    //   134	143	592	java/lang/Exception
    //   145	152	592	java/lang/Exception
    //   154	162	592	java/lang/Exception
    //   168	183	592	java/lang/Exception
    //   185	190	592	java/lang/Exception
    //   29	36	596	java/io/IOException
    //   38	41	596	java/io/IOException
    //   43	49	596	java/io/IOException
    //   51	64	596	java/io/IOException
    //   66	72	596	java/io/IOException
    //   74	87	596	java/io/IOException
    //   89	94	596	java/io/IOException
    //   96	105	596	java/io/IOException
    //   107	112	596	java/io/IOException
    //   114	119	596	java/io/IOException
    //   121	127	596	java/io/IOException
    //   134	143	596	java/io/IOException
    //   145	152	596	java/io/IOException
    //   154	162	596	java/io/IOException
    //   168	183	596	java/io/IOException
    //   185	190	596	java/io/IOException
    //   29	36	600	java/net/MalformedURLException
    //   38	41	600	java/net/MalformedURLException
    //   43	49	600	java/net/MalformedURLException
    //   51	64	600	java/net/MalformedURLException
    //   66	72	600	java/net/MalformedURLException
    //   74	87	600	java/net/MalformedURLException
    //   89	94	600	java/net/MalformedURLException
    //   96	105	600	java/net/MalformedURLException
    //   107	112	600	java/net/MalformedURLException
    //   114	119	600	java/net/MalformedURLException
    //   121	127	600	java/net/MalformedURLException
    //   134	143	600	java/net/MalformedURLException
    //   145	152	600	java/net/MalformedURLException
    //   154	162	600	java/net/MalformedURLException
    //   168	183	600	java/net/MalformedURLException
    //   185	190	600	java/net/MalformedURLException
    //   18	27	604	java/lang/Exception
  }
  
  public static HttpResponse httpPost(Context paramContext, String paramString)
  {
    return httpPost(paramContext, new HttpRequest(paramString));
  }
  
  public static String httpPostString(Context paramContext, String paramString)
  {
    paramContext = httpPost(paramContext, new HttpRequest(paramString));
    if (paramContext == null) {
      return null;
    }
    return paramContext.getResponseBody();
  }
  
  public static String httpPostString(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    paramContext = httpPost(paramContext, new HttpRequest(paramString, paramMap));
    if (paramContext == null) {
      return null;
    }
    return paramContext.getResponseBody();
  }
  
  public static String joinParas(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue());
      if (paramMap.hasNext()) {
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String joinParasWithEncodedValue(Map<String, String> paramMap)
  {
    localStringBuilder = new StringBuilder("");
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      try
      {
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localStringBuilder.append((String)localEntry.getKey()).append("=").append(URLEncoder.encode((String)localEntry.getValue(), ENCODING_UTF_8));
          if (paramMap.hasNext()) {
            localStringBuilder.append("&");
          }
        }
        return localStringBuilder.toString();
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
      }
    }
  }
  
  public static long parseGmtTime(String paramString)
  {
    try
    {
      long l = d.parse(paramString).getTime();
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1L;
  }
  
  public static byte[] readInputStream(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void setURLConnection(Map<String, String> paramMap, HttpURLConnection paramHttpURLConnection)
  {
    if ((paramMap == null) || (paramMap.size() == 0) || (paramHttpURLConnection == null)) {}
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (!h.a((String)localEntry.getKey())) {
          paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/net/HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */