package com.umeng.analytics.pro;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.a;
import java.net.URLEncoder;

public class aw
{
  private String a;
  private String b = "10.0.0.172";
  private int c = 80;
  private Context d;
  private av e;
  
  public aw(Context paramContext)
  {
    this.d = paramContext;
    this.a = a(paramContext);
  }
  
  private String a(Context paramContext)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("Android");
    localStringBuffer1.append("/");
    localStringBuffer1.append("6.1.1");
    localStringBuffer1.append(" ");
    try
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(bv.v(paramContext));
      localStringBuffer2.append("/");
      localStringBuffer2.append(bv.b(paramContext));
      localStringBuffer2.append(" ");
      localStringBuffer2.append(Build.MODEL);
      localStringBuffer2.append("/");
      localStringBuffer2.append(Build.VERSION.RELEASE);
      localStringBuffer2.append(" ");
      localStringBuffer2.append(bw.a(AnalyticsConfig.getAppkey(paramContext)));
      localStringBuffer1.append(URLEncoder.encode(localStringBuffer2.toString(), "UTF-8"));
      return localStringBuffer1.toString();
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	com/umeng/analytics/pro/aw:e	Lcom/umeng/analytics/pro/av;
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: getfield 91	com/umeng/analytics/pro/aw:e	Lcom/umeng/analytics/pro/av;
    //   11: invokeinterface 95 1 0
    //   16: aload_0
    //   17: invokespecial 98	com/umeng/analytics/pro/aw:c	()Z
    //   20: ifeq +380 -> 400
    //   23: new 100	java/net/Proxy
    //   26: dup
    //   27: getstatic 106	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   30: new 108	java/net/InetSocketAddress
    //   33: dup
    //   34: aload_0
    //   35: getfield 22	com/umeng/analytics/pro/aw:b	Ljava/lang/String;
    //   38: aload_0
    //   39: getfield 24	com/umeng/analytics/pro/aw:c	I
    //   42: invokespecial 111	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   45: invokespecial 114	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   48: astore 5
    //   50: new 116	java/net/URL
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 119	java/net/URL:<init>	(Ljava/lang/String;)V
    //   58: aload 5
    //   60: invokevirtual 123	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   63: checkcast 125	java/net/HttpURLConnection
    //   66: astore 5
    //   68: aload 5
    //   70: astore 6
    //   72: aload 5
    //   74: ldc 127
    //   76: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   79: invokestatic 139	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: invokevirtual 143	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 5
    //   87: astore 6
    //   89: aload 5
    //   91: ldc -111
    //   93: aload_0
    //   94: getfield 31	com/umeng/analytics/pro/aw:a	Ljava/lang/String;
    //   97: invokevirtual 143	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 5
    //   102: astore 6
    //   104: aload 5
    //   106: ldc -109
    //   108: ldc -107
    //   110: invokevirtual 143	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload 5
    //   115: astore 6
    //   117: aload 5
    //   119: ldc -105
    //   121: ldc -107
    //   123: invokevirtual 143	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 5
    //   128: astore 6
    //   130: aload 5
    //   132: sipush 10000
    //   135: invokevirtual 155	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   138: aload 5
    //   140: astore 6
    //   142: aload 5
    //   144: sipush 30000
    //   147: invokevirtual 158	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   150: aload 5
    //   152: astore 6
    //   154: aload 5
    //   156: ldc -96
    //   158: invokevirtual 163	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   161: aload 5
    //   163: astore 6
    //   165: aload 5
    //   167: iconst_1
    //   168: invokevirtual 167	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   171: aload 5
    //   173: astore 6
    //   175: aload 5
    //   177: iconst_1
    //   178: invokevirtual 170	java/net/HttpURLConnection:setDoInput	(Z)V
    //   181: aload 5
    //   183: astore 6
    //   185: aload 5
    //   187: iconst_0
    //   188: invokevirtual 173	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   191: aload 5
    //   193: astore 6
    //   195: getstatic 176	android/os/Build$VERSION:SDK_INT	I
    //   198: bipush 8
    //   200: if_icmpge +15 -> 215
    //   203: aload 5
    //   205: astore 6
    //   207: ldc -78
    //   209: ldc -76
    //   211: invokestatic 183	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: pop
    //   215: aload 5
    //   217: astore 6
    //   219: aload 5
    //   221: invokevirtual 187	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   224: astore 7
    //   226: aload 5
    //   228: astore 6
    //   230: aload 7
    //   232: aload_1
    //   233: invokevirtual 193	java/io/OutputStream:write	([B)V
    //   236: aload 5
    //   238: astore 6
    //   240: aload 7
    //   242: invokevirtual 196	java/io/OutputStream:flush	()V
    //   245: aload 5
    //   247: astore 6
    //   249: aload 7
    //   251: invokevirtual 199	java/io/OutputStream:close	()V
    //   254: aload 5
    //   256: astore 6
    //   258: aload_0
    //   259: getfield 91	com/umeng/analytics/pro/aw:e	Lcom/umeng/analytics/pro/av;
    //   262: ifnull +16 -> 278
    //   265: aload 5
    //   267: astore 6
    //   269: aload_0
    //   270: getfield 91	com/umeng/analytics/pro/aw:e	Lcom/umeng/analytics/pro/av;
    //   273: invokeinterface 201 1 0
    //   278: aload 5
    //   280: astore 6
    //   282: aload 5
    //   284: invokevirtual 205	java/net/HttpURLConnection:getResponseCode	()I
    //   287: istore 4
    //   289: aload 5
    //   291: astore 6
    //   293: aload 5
    //   295: ldc -105
    //   297: invokevirtual 208	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore_1
    //   301: aload 5
    //   303: astore 6
    //   305: aload_1
    //   306: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   309: ifne +187 -> 496
    //   312: aload 5
    //   314: astore 6
    //   316: aload_1
    //   317: ldc -40
    //   319: invokevirtual 220	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   322: ifeq +174 -> 496
    //   325: iconst_1
    //   326: istore_3
    //   327: iload 4
    //   329: sipush 200
    //   332: if_icmpne +125 -> 457
    //   335: iload_3
    //   336: ifeq +121 -> 457
    //   339: aload 5
    //   341: astore 6
    //   343: new 222	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   350: ldc -31
    //   352: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 233	com/umeng/analytics/pro/by:c	(Ljava/lang/String;)V
    //   365: aload 5
    //   367: astore 6
    //   369: aload 5
    //   371: invokevirtual 237	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   374: astore_1
    //   375: aload_1
    //   376: invokestatic 240	com/umeng/analytics/pro/bw:b	(Ljava/io/InputStream;)[B
    //   379: astore_2
    //   380: aload 5
    //   382: astore 6
    //   384: aload_1
    //   385: invokestatic 243	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   388: aload 5
    //   390: ifnull +8 -> 398
    //   393: aload 5
    //   395: invokevirtual 246	java/net/HttpURLConnection:disconnect	()V
    //   398: aload_2
    //   399: areturn
    //   400: new 116	java/net/URL
    //   403: dup
    //   404: aload_2
    //   405: invokespecial 119	java/net/URL:<init>	(Ljava/lang/String;)V
    //   408: invokevirtual 249	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   411: checkcast 125	java/net/HttpURLConnection
    //   414: astore 5
    //   416: goto -348 -> 68
    //   419: astore_2
    //   420: aload 5
    //   422: astore 6
    //   424: aload_1
    //   425: invokestatic 243	com/umeng/analytics/pro/bw:c	(Ljava/io/InputStream;)V
    //   428: aload 5
    //   430: astore 6
    //   432: aload_2
    //   433: athrow
    //   434: astore_1
    //   435: aload 5
    //   437: astore 6
    //   439: ldc -5
    //   441: aload_1
    //   442: invokestatic 254	com/umeng/analytics/pro/by:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload 5
    //   447: ifnull +8 -> 455
    //   450: aload 5
    //   452: invokevirtual 246	java/net/HttpURLConnection:disconnect	()V
    //   455: aconst_null
    //   456: areturn
    //   457: aload 5
    //   459: ifnull +8 -> 467
    //   462: aload 5
    //   464: invokevirtual 246	java/net/HttpURLConnection:disconnect	()V
    //   467: aconst_null
    //   468: areturn
    //   469: astore_1
    //   470: aconst_null
    //   471: astore 6
    //   473: aload 6
    //   475: ifnull +8 -> 483
    //   478: aload 6
    //   480: invokevirtual 246	java/net/HttpURLConnection:disconnect	()V
    //   483: aload_1
    //   484: athrow
    //   485: astore_1
    //   486: goto -13 -> 473
    //   489: astore_1
    //   490: aconst_null
    //   491: astore 5
    //   493: goto -58 -> 435
    //   496: iconst_0
    //   497: istore_3
    //   498: goto -171 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	aw
    //   0	501	1	paramArrayOfByte	byte[]
    //   0	501	2	paramString	String
    //   326	172	3	i	int
    //   287	46	4	j	int
    //   48	444	5	localObject1	Object
    //   70	409	6	localObject2	Object
    //   224	26	7	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   375	380	419	finally
    //   72	85	434	java/lang/Throwable
    //   89	100	434	java/lang/Throwable
    //   104	113	434	java/lang/Throwable
    //   117	126	434	java/lang/Throwable
    //   130	138	434	java/lang/Throwable
    //   142	150	434	java/lang/Throwable
    //   154	161	434	java/lang/Throwable
    //   165	171	434	java/lang/Throwable
    //   175	181	434	java/lang/Throwable
    //   185	191	434	java/lang/Throwable
    //   195	203	434	java/lang/Throwable
    //   207	215	434	java/lang/Throwable
    //   219	226	434	java/lang/Throwable
    //   230	236	434	java/lang/Throwable
    //   240	245	434	java/lang/Throwable
    //   249	254	434	java/lang/Throwable
    //   258	265	434	java/lang/Throwable
    //   269	278	434	java/lang/Throwable
    //   282	289	434	java/lang/Throwable
    //   293	301	434	java/lang/Throwable
    //   305	312	434	java/lang/Throwable
    //   316	325	434	java/lang/Throwable
    //   343	365	434	java/lang/Throwable
    //   369	375	434	java/lang/Throwable
    //   384	388	434	java/lang/Throwable
    //   424	428	434	java/lang/Throwable
    //   432	434	434	java/lang/Throwable
    //   0	16	469	finally
    //   16	68	469	finally
    //   400	416	469	finally
    //   72	85	485	finally
    //   89	100	485	finally
    //   104	113	485	finally
    //   117	126	485	finally
    //   130	138	485	finally
    //   142	150	485	finally
    //   154	161	485	finally
    //   165	171	485	finally
    //   175	181	485	finally
    //   185	191	485	finally
    //   195	203	485	finally
    //   207	215	485	finally
    //   219	226	485	finally
    //   230	236	485	finally
    //   240	245	485	finally
    //   249	254	485	finally
    //   258	265	485	finally
    //   269	278	485	finally
    //   282	289	485	finally
    //   293	301	485	finally
    //   305	312	485	finally
    //   316	325	485	finally
    //   343	365	485	finally
    //   369	375	485	finally
    //   384	388	485	finally
    //   424	428	485	finally
    //   432	434	485	finally
    //   439	445	485	finally
    //   0	16	489	java/lang/Throwable
    //   16	68	489	java/lang/Throwable
    //   400	416	489	java/lang/Throwable
  }
  
  private void b()
  {
    String str1 = af.a(this.d).b().d("");
    String str2 = af.a(this.d).b().c("");
    if (!TextUtils.isEmpty(str1)) {
      a.f = bt.b(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      a.g = bt.b(str2);
    }
    a.h = new String[] { a.f, a.g };
    int i = bg.a(this.d).b();
    if (i != -1)
    {
      if (i != 0) {
        break label121;
      }
      a.h = new String[] { a.f, a.g };
    }
    label121:
    while (i != 1) {
      return;
    }
    a.h = new String[] { a.g, a.f };
  }
  
  private boolean c()
  {
    if (this.d.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.d.getPackageName()) != 0) {
      return false;
    }
    try
    {
      Object localObject = (ConnectivityManager)this.d.getSystemService("connectivity");
      if (!bv.a(this.d, "android.permission.ACCESS_NETWORK_STATE")) {
        return false;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() != 1))
      {
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (localObject != null) {
          if ((!((String)localObject).equals("cmwap")) && (!((String)localObject).equals("3gwap")))
          {
            boolean bool = ((String)localObject).equals("uniwap");
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_3
    //   4: invokestatic 348	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   7: invokestatic 352	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   10: astore 4
    //   12: aload_2
    //   13: astore_3
    //   14: aload 4
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 356	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   21: aload_2
    //   22: astore_3
    //   23: new 358	com/umeng/analytics/pro/bb
    //   26: dup
    //   27: aload 4
    //   29: invokespecial 361	com/umeng/analytics/pro/bb:<init>	(Ljava/security/KeyStore;)V
    //   32: astore 4
    //   34: aload_2
    //   35: astore_3
    //   36: aload 4
    //   38: getstatic 367	org/apache/http/conn/ssl/SSLSocketFactory:STRICT_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   41: invokevirtual 371	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   44: aload_2
    //   45: astore_3
    //   46: new 373	org/apache/http/client/methods/HttpGet
    //   49: dup
    //   50: ldc_w 375
    //   53: invokespecial 376	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload_2
    //   59: astore_3
    //   60: new 378	org/apache/http/params/BasicHttpParams
    //   63: dup
    //   64: invokespecial 379	org/apache/http/params/BasicHttpParams:<init>	()V
    //   67: astore 6
    //   69: aload_2
    //   70: astore_3
    //   71: aload 6
    //   73: getstatic 385	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   76: invokestatic 391	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   79: aload_2
    //   80: astore_3
    //   81: aload 6
    //   83: ldc_w 393
    //   86: invokestatic 397	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   89: aload_2
    //   90: astore_3
    //   91: aload 6
    //   93: iconst_1
    //   94: invokestatic 401	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   97: aload_2
    //   98: astore_3
    //   99: aload 6
    //   101: ldc2_w 402
    //   104: invokestatic 409	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   107: aload_2
    //   108: astore_3
    //   109: aload 6
    //   111: sipush 10000
    //   114: invokestatic 415	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   117: aload_2
    //   118: astore_3
    //   119: aload 6
    //   121: sipush 10000
    //   124: invokestatic 418	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   127: aload_2
    //   128: astore_3
    //   129: new 420	org/apache/http/conn/scheme/SchemeRegistry
    //   132: dup
    //   133: invokespecial 421	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   136: astore 7
    //   138: aload_2
    //   139: astore_3
    //   140: aload 7
    //   142: new 423	org/apache/http/conn/scheme/Scheme
    //   145: dup
    //   146: ldc_w 425
    //   149: invokestatic 431	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   152: bipush 80
    //   154: invokespecial 434	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   157: invokevirtual 438	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   160: pop
    //   161: aload_2
    //   162: astore_3
    //   163: aload 7
    //   165: new 423	org/apache/http/conn/scheme/Scheme
    //   168: dup
    //   169: ldc_w 440
    //   172: aload 4
    //   174: sipush 443
    //   177: invokespecial 434	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   180: invokevirtual 438	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   183: pop
    //   184: aload_2
    //   185: astore_3
    //   186: new 442	org/apache/http/impl/client/DefaultHttpClient
    //   189: dup
    //   190: new 444	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   193: dup
    //   194: aload 6
    //   196: aload 7
    //   198: invokespecial 447	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   201: aload 6
    //   203: invokespecial 450	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   206: aload 5
    //   208: invokevirtual 454	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   211: invokeinterface 460 1 0
    //   216: invokeinterface 465 1 0
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull +159 -> 382
    //   226: aload_2
    //   227: astore_3
    //   228: new 467	java/io/ByteArrayOutputStream
    //   231: dup
    //   232: invokespecial 468	java/io/ByteArrayOutputStream:<init>	()V
    //   235: astore 4
    //   237: aload_2
    //   238: astore_3
    //   239: sipush 1024
    //   242: newarray <illegal type>
    //   244: astore 5
    //   246: aload_2
    //   247: astore_3
    //   248: aload_2
    //   249: aload 5
    //   251: invokevirtual 474	java/io/InputStream:read	([B)I
    //   254: istore_1
    //   255: iload_1
    //   256: iconst_m1
    //   257: if_icmpeq +27 -> 284
    //   260: aload_2
    //   261: astore_3
    //   262: aload 4
    //   264: aload 5
    //   266: iconst_0
    //   267: iload_1
    //   268: invokevirtual 477	java/io/ByteArrayOutputStream:write	([BII)V
    //   271: goto -25 -> 246
    //   274: astore_2
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 478	java/io/InputStream:close	()V
    //   283: return
    //   284: aload_2
    //   285: astore_3
    //   286: aload 4
    //   288: invokevirtual 479	java/io/ByteArrayOutputStream:close	()V
    //   291: aload_2
    //   292: astore_3
    //   293: new 135	java/lang/String
    //   296: dup
    //   297: aload 4
    //   299: invokevirtual 483	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   302: ldc 82
    //   304: invokespecial 486	java/lang/String:<init>	([BLjava/lang/String;)V
    //   307: astore 4
    //   309: aload_2
    //   310: astore_3
    //   311: aload 4
    //   313: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   316: ifne +66 -> 382
    //   319: aload_2
    //   320: astore_3
    //   321: aload 4
    //   323: invokevirtual 489	java/lang/String:length	()I
    //   326: ifle +56 -> 382
    //   329: aload_2
    //   330: astore_3
    //   331: aload 4
    //   333: invokevirtual 489	java/lang/String:length	()I
    //   336: bipush 50
    //   338: if_icmpge +44 -> 382
    //   341: aload_2
    //   342: astore_3
    //   343: aload_0
    //   344: getfield 26	com/umeng/analytics/pro/aw:d	Landroid/content/Context;
    //   347: invokestatic 494	com/umeng/analytics/pro/ba:a	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   350: astore 5
    //   352: aload 5
    //   354: ifnull +28 -> 382
    //   357: aload_2
    //   358: astore_3
    //   359: aload 5
    //   361: invokeinterface 500 1 0
    //   366: ldc_w 502
    //   369: aload 4
    //   371: invokeinterface 508 3 0
    //   376: invokeinterface 511 1 0
    //   381: pop
    //   382: aload_2
    //   383: ifnull -100 -> 283
    //   386: aload_2
    //   387: invokevirtual 478	java/io/InputStream:close	()V
    //   390: return
    //   391: astore_2
    //   392: return
    //   393: astore_2
    //   394: aconst_null
    //   395: astore_3
    //   396: aload_3
    //   397: ifnull +7 -> 404
    //   400: aload_3
    //   401: invokevirtual 478	java/io/InputStream:close	()V
    //   404: aload_2
    //   405: athrow
    //   406: astore_2
    //   407: return
    //   408: astore_3
    //   409: goto -5 -> 404
    //   412: astore 4
    //   414: aload_2
    //   415: astore_3
    //   416: aload 4
    //   418: astore_2
    //   419: goto -23 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	aw
    //   254	14	1	i	int
    //   1	260	2	localInputStream	java.io.InputStream
    //   274	113	2	localThrowable1	Throwable
    //   391	1	2	localThrowable2	Throwable
    //   393	12	2	localObject1	Object
    //   406	9	2	localThrowable3	Throwable
    //   418	1	2	localObject2	Object
    //   3	398	3	localObject3	Object
    //   408	1	3	localThrowable4	Throwable
    //   415	1	3	localThrowable5	Throwable
    //   10	360	4	localObject4	Object
    //   412	5	4	localObject5	Object
    //   56	304	5	localObject6	Object
    //   67	135	6	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   136	61	7	localSchemeRegistry	org.apache.http.conn.scheme.SchemeRegistry
    // Exception table:
    //   from	to	target	type
    //   4	12	274	java/lang/Throwable
    //   14	21	274	java/lang/Throwable
    //   23	34	274	java/lang/Throwable
    //   36	44	274	java/lang/Throwable
    //   46	58	274	java/lang/Throwable
    //   60	69	274	java/lang/Throwable
    //   71	79	274	java/lang/Throwable
    //   81	89	274	java/lang/Throwable
    //   91	97	274	java/lang/Throwable
    //   99	107	274	java/lang/Throwable
    //   109	117	274	java/lang/Throwable
    //   119	127	274	java/lang/Throwable
    //   129	138	274	java/lang/Throwable
    //   140	161	274	java/lang/Throwable
    //   163	184	274	java/lang/Throwable
    //   186	222	274	java/lang/Throwable
    //   228	237	274	java/lang/Throwable
    //   239	246	274	java/lang/Throwable
    //   248	255	274	java/lang/Throwable
    //   262	271	274	java/lang/Throwable
    //   286	291	274	java/lang/Throwable
    //   293	309	274	java/lang/Throwable
    //   311	319	274	java/lang/Throwable
    //   321	329	274	java/lang/Throwable
    //   331	341	274	java/lang/Throwable
    //   343	352	274	java/lang/Throwable
    //   359	382	274	java/lang/Throwable
    //   386	390	391	java/lang/Throwable
    //   4	12	393	finally
    //   14	21	393	finally
    //   23	34	393	finally
    //   36	44	393	finally
    //   46	58	393	finally
    //   60	69	393	finally
    //   71	79	393	finally
    //   81	89	393	finally
    //   91	97	393	finally
    //   99	107	393	finally
    //   109	117	393	finally
    //   119	127	393	finally
    //   129	138	393	finally
    //   140	161	393	finally
    //   163	184	393	finally
    //   186	222	393	finally
    //   279	283	406	java/lang/Throwable
    //   400	404	408	java/lang/Throwable
    //   228	237	412	finally
    //   239	246	412	finally
    //   248	255	412	finally
    //   262	271	412	finally
    //   286	291	412	finally
    //   293	309	412	finally
    //   311	319	412	finally
    //   321	329	412	finally
    //   331	341	412	finally
    //   343	352	412	finally
    //   359	382	412	finally
  }
  
  public void a(av paramav)
  {
    this.e = paramav;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = null;
    b();
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte2 = arrayOfByte1;
      if (i < a.h.length)
      {
        arrayOfByte1 = a(paramArrayOfByte, a.h[i]);
        if (arrayOfByte1 == null) {
          break label59;
        }
        arrayOfByte2 = arrayOfByte1;
        if (this.e != null)
        {
          this.e.c();
          arrayOfByte2 = arrayOfByte1;
        }
      }
      return arrayOfByte2;
      label59:
      if (this.e != null) {
        this.e.d();
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */