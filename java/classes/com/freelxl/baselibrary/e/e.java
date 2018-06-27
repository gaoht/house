package com.freelxl.baselibrary.e;

import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;

@Instrumented
public class e
  extends a
{
  private String a = "UTF-8";
  private Integer b = Integer.valueOf(20000);
  private Integer c = Integer.valueOf(20000);
  private String d = null;
  private Integer e = null;
  
  private URLConnection a(URL paramURL)
    throws IOException
  {
    if ((this.d != null) && (this.e != null)) {
      return paramURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.d, this.e.intValue())));
    }
    if (!(paramURL instanceof URL)) {
      return paramURL.openConnection();
    }
    return HttpInstrumentation.openConnection((URL)paramURL);
  }
  
  private void a(URLConnection paramURLConnection)
  {
    if (this.b != null) {
      paramURLConnection.setConnectTimeout(this.b.intValue());
    }
    if (this.c != null) {
      paramURLConnection.setReadTimeout(this.c.intValue());
    }
  }
  
  public String getCharset()
  {
    return this.a;
  }
  
  public Integer getConnectTimeout()
  {
    return this.b;
  }
  
  public String getProxyHost()
  {
    return this.d;
  }
  
  public Integer getProxyPort()
  {
    return this.e;
  }
  
  public Integer getSocketTimeout()
  {
    return this.c;
  }
  
  /* Error */
  public String httpGet(h paramh)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 98	com/freelxl/baselibrary/e/h:getUrl	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +13 -> 25
    //   15: new 93	java/lang/Exception
    //   18: dup
    //   19: ldc 106
    //   21: invokespecial 109	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: aload_1
    //   26: invokevirtual 112	com/freelxl/baselibrary/e/h:getMethod	()I
    //   29: pop
    //   30: ldc 114
    //   32: new 116	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   39: ldc 119
    //   41: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_2
    //   45: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 131	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: new 60	java/net/URL
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 132	java/net/URL:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 134	com/freelxl/baselibrary/e/e:a	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   66: checkcast 136	java/net/HttpURLConnection
    //   69: astore_2
    //   70: aload_2
    //   71: ldc -118
    //   73: invokevirtual 141	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: ldc -113
    //   79: aload_0
    //   80: getfield 20	com/freelxl/baselibrary/e/e:a	Ljava/lang/String;
    //   83: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_2
    //   87: ldc -108
    //   89: ldc -106
    //   91: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: invokevirtual 153	com/freelxl/baselibrary/e/h:a	()Ljava/util/Map;
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +95 -> 195
    //   103: aload_1
    //   104: invokeinterface 158 1 0
    //   109: ifne +86 -> 195
    //   112: aload_1
    //   113: invokeinterface 162 1 0
    //   118: invokeinterface 168 1 0
    //   123: astore_1
    //   124: aload_1
    //   125: invokeinterface 173 1 0
    //   130: ifeq +65 -> 195
    //   133: aload_1
    //   134: invokeinterface 177 1 0
    //   139: checkcast 179	java/util/Map$Entry
    //   142: astore_3
    //   143: aload_3
    //   144: invokeinterface 182 1 0
    //   149: ifnonnull +21 -> 170
    //   152: aload_2
    //   153: aload_3
    //   154: invokeinterface 185 1 0
    //   159: checkcast 187	java/lang/String
    //   162: ldc -67
    //   164: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: goto -43 -> 124
    //   170: aload_2
    //   171: aload_3
    //   172: invokeinterface 185 1 0
    //   177: checkcast 187	java/lang/String
    //   180: aload_3
    //   181: invokeinterface 182 1 0
    //   186: invokevirtual 192	java/lang/Object:toString	()Ljava/lang/String;
    //   189: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -68 -> 124
    //   195: aload_0
    //   196: aload_2
    //   197: invokespecial 194	com/freelxl/baselibrary/e/e:a	(Ljava/net/URLConnection;)V
    //   200: new 196	java/lang/StringBuffer
    //   203: dup
    //   204: invokespecial 197	java/lang/StringBuffer:<init>	()V
    //   207: astore_3
    //   208: aload_2
    //   209: invokevirtual 201	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   212: astore_1
    //   213: new 203	java/io/InputStreamReader
    //   216: dup
    //   217: aload_1
    //   218: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   221: astore_2
    //   222: new 208	java/io/BufferedReader
    //   225: dup
    //   226: aload_2
    //   227: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   230: astore 5
    //   232: aload 5
    //   234: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   237: astore 4
    //   239: aload 4
    //   241: ifnull +54 -> 295
    //   244: aload_3
    //   245: aload 4
    //   247: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   250: pop
    //   251: goto -19 -> 232
    //   254: astore 6
    //   256: aload_2
    //   257: astore 4
    //   259: aload_1
    //   260: astore_3
    //   261: aload 5
    //   263: astore_2
    //   264: aload 6
    //   266: astore_1
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 220	java/io/BufferedReader:close	()V
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 221	java/io/InputStreamReader:close	()V
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 224	java/io/InputStream:close	()V
    //   293: aload_1
    //   294: athrow
    //   295: aload 5
    //   297: ifnull +8 -> 305
    //   300: aload 5
    //   302: invokevirtual 220	java/io/BufferedReader:close	()V
    //   305: aload_2
    //   306: ifnull +7 -> 313
    //   309: aload_2
    //   310: invokevirtual 221	java/io/InputStreamReader:close	()V
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 224	java/io/InputStream:close	()V
    //   321: ldc 114
    //   323: new 116	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   330: ldc -30
    //   332: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_3
    //   336: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   339: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 131	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload_3
    //   349: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   352: areturn
    //   353: astore_1
    //   354: aconst_null
    //   355: astore_2
    //   356: aconst_null
    //   357: astore_3
    //   358: goto -91 -> 267
    //   361: astore 5
    //   363: aconst_null
    //   364: astore_2
    //   365: aload_1
    //   366: astore_3
    //   367: aload 5
    //   369: astore_1
    //   370: goto -103 -> 267
    //   373: astore 6
    //   375: aconst_null
    //   376: astore 5
    //   378: aload_2
    //   379: astore 4
    //   381: aload_1
    //   382: astore_3
    //   383: aload 6
    //   385: astore_1
    //   386: aload 5
    //   388: astore_2
    //   389: goto -122 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	e
    //   0	392	1	paramh	h
    //   7	382	2	localObject1	Object
    //   142	241	3	localObject2	Object
    //   1	379	4	localObject3	Object
    //   230	71	5	localBufferedReader	java.io.BufferedReader
    //   361	7	5	localObject4	Object
    //   376	11	5	localObject5	Object
    //   254	11	6	localObject6	Object
    //   373	11	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   232	239	254	finally
    //   244	251	254	finally
    //   208	213	353	finally
    //   213	222	361	finally
    //   222	232	373	finally
  }
  
  /* Error */
  public String httpPost(h paramh)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 98	com/freelxl/baselibrary/e/h:getUrl	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +13 -> 22
    //   12: new 93	java/lang/Exception
    //   15: dup
    //   16: ldc 106
    //   18: invokespecial 109	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_1
    //   23: invokevirtual 112	com/freelxl/baselibrary/e/h:getMethod	()I
    //   26: pop
    //   27: aload_1
    //   28: invokevirtual 230	com/freelxl/baselibrary/e/h:b	()Ljava/util/Map;
    //   31: astore 4
    //   33: new 196	java/lang/StringBuffer
    //   36: dup
    //   37: invokespecial 197	java/lang/StringBuffer:<init>	()V
    //   40: astore_3
    //   41: aload 4
    //   43: ifnull +154 -> 197
    //   46: aload 4
    //   48: invokeinterface 158 1 0
    //   53: ifne +144 -> 197
    //   56: aload 4
    //   58: invokeinterface 162 1 0
    //   63: invokeinterface 168 1 0
    //   68: astore 4
    //   70: aload 4
    //   72: invokeinterface 173 1 0
    //   77: ifeq +109 -> 186
    //   80: aload 4
    //   82: invokeinterface 177 1 0
    //   87: checkcast 179	java/util/Map$Entry
    //   90: astore 5
    //   92: aload_3
    //   93: aload 5
    //   95: invokeinterface 185 1 0
    //   100: checkcast 187	java/lang/String
    //   103: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: ldc -24
    //   108: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   111: pop
    //   112: aload 5
    //   114: invokeinterface 182 1 0
    //   119: ifnonnull +27 -> 146
    //   122: aload_3
    //   123: ldc -67
    //   125: aload_0
    //   126: getfield 20	com/freelxl/baselibrary/e/e:a	Ljava/lang/String;
    //   129: invokestatic 238	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: aload_3
    //   137: ldc -16
    //   139: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: goto -73 -> 70
    //   146: aload_3
    //   147: new 116	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   154: aload 5
    //   156: invokeinterface 182 1 0
    //   161: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc -67
    //   166: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 20	com/freelxl/baselibrary/e/e:a	Ljava/lang/String;
    //   176: invokestatic 238	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   179: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   182: pop
    //   183: goto -47 -> 136
    //   186: aload_3
    //   187: aload_3
    //   188: invokevirtual 246	java/lang/StringBuffer:length	()I
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual 250	java/lang/StringBuffer:deleteCharAt	(I)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: aload_3
    //   198: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   201: invokevirtual 254	java/lang/String:getBytes	()[B
    //   204: astore 5
    //   206: aload_0
    //   207: new 60	java/net/URL
    //   210: dup
    //   211: aload_2
    //   212: invokespecial 132	java/net/URL:<init>	(Ljava/lang/String;)V
    //   215: invokespecial 134	com/freelxl/baselibrary/e/e:a	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   218: checkcast 136	java/net/HttpURLConnection
    //   221: astore 4
    //   223: aload 4
    //   225: iconst_1
    //   226: invokevirtual 258	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   229: aload 4
    //   231: ldc_w 260
    //   234: invokevirtual 141	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   237: aload 4
    //   239: ldc -113
    //   241: aload_0
    //   242: getfield 20	com/freelxl/baselibrary/e/e:a	Ljava/lang/String;
    //   245: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 4
    //   250: ldc -108
    //   252: ldc -106
    //   254: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 4
    //   259: ldc_w 262
    //   262: new 116	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   269: aload 5
    //   271: arraylength
    //   272: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: ldc -67
    //   277: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_1
    //   287: invokevirtual 153	com/freelxl/baselibrary/e/h:a	()Ljava/util/Map;
    //   290: astore_1
    //   291: aload_1
    //   292: ifnull +100 -> 392
    //   295: aload_1
    //   296: invokeinterface 158 1 0
    //   301: ifne +91 -> 392
    //   304: aload_1
    //   305: invokeinterface 162 1 0
    //   310: invokeinterface 168 1 0
    //   315: astore 6
    //   317: aload 6
    //   319: invokeinterface 173 1 0
    //   324: ifeq +68 -> 392
    //   327: aload 6
    //   329: invokeinterface 177 1 0
    //   334: checkcast 179	java/util/Map$Entry
    //   337: astore_1
    //   338: aload_1
    //   339: invokeinterface 182 1 0
    //   344: ifnonnull +22 -> 366
    //   347: aload 4
    //   349: aload_1
    //   350: invokeinterface 185 1 0
    //   355: checkcast 187	java/lang/String
    //   358: ldc -67
    //   360: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto -46 -> 317
    //   366: aload 4
    //   368: aload_1
    //   369: invokeinterface 185 1 0
    //   374: checkcast 187	java/lang/String
    //   377: aload_1
    //   378: invokeinterface 182 1 0
    //   383: invokevirtual 192	java/lang/Object:toString	()Ljava/lang/String;
    //   386: invokevirtual 146	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: goto -72 -> 317
    //   392: aload_0
    //   393: aload 4
    //   395: invokespecial 194	com/freelxl/baselibrary/e/e:a	(Ljava/net/URLConnection;)V
    //   398: new 196	java/lang/StringBuffer
    //   401: dup
    //   402: invokespecial 197	java/lang/StringBuffer:<init>	()V
    //   405: astore_1
    //   406: ldc 114
    //   408: new 116	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 267
    //   418: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_2
    //   422: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 269
    //   428: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_3
    //   432: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   435: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 131	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   444: aload 4
    //   446: invokevirtual 273	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   449: astore_2
    //   450: aload_2
    //   451: aload 5
    //   453: invokevirtual 279	java/io/OutputStream:write	([B)V
    //   456: aload_2
    //   457: invokevirtual 282	java/io/OutputStream:flush	()V
    //   460: aload 4
    //   462: invokevirtual 201	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   465: astore 4
    //   467: new 203	java/io/InputStreamReader
    //   470: dup
    //   471: aload 4
    //   473: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   476: astore_3
    //   477: new 208	java/io/BufferedReader
    //   480: dup
    //   481: aload_3
    //   482: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   485: astore_2
    //   486: aload_2
    //   487: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   490: astore 5
    //   492: aload 5
    //   494: ifnull +54 -> 548
    //   497: aload_1
    //   498: aload 5
    //   500: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   503: pop
    //   504: goto -18 -> 486
    //   507: astore_1
    //   508: iconst_0
    //   509: ifeq +11 -> 520
    //   512: new 284	java/lang/NullPointerException
    //   515: dup
    //   516: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   519: athrow
    //   520: aload_2
    //   521: ifnull +7 -> 528
    //   524: aload_2
    //   525: invokevirtual 220	java/io/BufferedReader:close	()V
    //   528: aload_3
    //   529: ifnull +7 -> 536
    //   532: aload_3
    //   533: invokevirtual 221	java/io/InputStreamReader:close	()V
    //   536: aload 4
    //   538: ifnull +8 -> 546
    //   541: aload 4
    //   543: invokevirtual 224	java/io/InputStream:close	()V
    //   546: aload_1
    //   547: athrow
    //   548: ldc 114
    //   550: new 116	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 287
    //   560: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_1
    //   564: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   567: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 131	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: iconst_0
    //   577: ifeq +11 -> 588
    //   580: new 284	java/lang/NullPointerException
    //   583: dup
    //   584: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   587: athrow
    //   588: aload_2
    //   589: ifnull +7 -> 596
    //   592: aload_2
    //   593: invokevirtual 220	java/io/BufferedReader:close	()V
    //   596: aload_3
    //   597: ifnull +7 -> 604
    //   600: aload_3
    //   601: invokevirtual 221	java/io/InputStreamReader:close	()V
    //   604: aload 4
    //   606: ifnull +8 -> 614
    //   609: aload 4
    //   611: invokevirtual 224	java/io/InputStream:close	()V
    //   614: aload_1
    //   615: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   618: areturn
    //   619: astore_1
    //   620: aconst_null
    //   621: astore_2
    //   622: aconst_null
    //   623: astore_3
    //   624: aconst_null
    //   625: astore 4
    //   627: goto -119 -> 508
    //   630: astore_1
    //   631: aconst_null
    //   632: astore_2
    //   633: aconst_null
    //   634: astore_3
    //   635: goto -127 -> 508
    //   638: astore_1
    //   639: aconst_null
    //   640: astore_2
    //   641: goto -133 -> 508
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	e
    //   0	644	1	paramh	h
    //   4	637	2	localObject1	Object
    //   40	595	3	localObject2	Object
    //   31	595	4	localObject3	Object
    //   90	409	5	localObject4	Object
    //   315	13	6	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   486	492	507	finally
    //   497	504	507	finally
    //   548	576	507	finally
    //   444	467	619	finally
    //   467	477	630	finally
    //   477	486	638	finally
  }
  
  /* Error */
  public String httpsPost(h paramh)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 98	com/freelxl/baselibrary/e/h:getUrl	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +13 -> 22
    //   12: new 93	java/lang/Exception
    //   15: dup
    //   16: ldc 106
    //   18: invokespecial 109	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_1
    //   23: invokevirtual 112	com/freelxl/baselibrary/e/h:getMethod	()I
    //   26: pop
    //   27: aload_1
    //   28: invokevirtual 230	com/freelxl/baselibrary/e/h:b	()Ljava/util/Map;
    //   31: astore_2
    //   32: new 196	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 197	java/lang/StringBuffer:<init>	()V
    //   39: astore 4
    //   41: aload_2
    //   42: ifnull +155 -> 197
    //   45: aload_2
    //   46: invokeinterface 158 1 0
    //   51: ifne +146 -> 197
    //   54: aload_2
    //   55: invokeinterface 162 1 0
    //   60: invokeinterface 168 1 0
    //   65: astore_2
    //   66: aload_2
    //   67: invokeinterface 173 1 0
    //   72: ifeq +112 -> 184
    //   75: aload_2
    //   76: invokeinterface 177 1 0
    //   81: checkcast 179	java/util/Map$Entry
    //   84: astore 5
    //   86: aload 4
    //   88: aload 5
    //   90: invokeinterface 185 1 0
    //   95: checkcast 187	java/lang/String
    //   98: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   101: ldc -24
    //   103: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: pop
    //   107: aload 5
    //   109: invokeinterface 182 1 0
    //   114: ifnonnull +29 -> 143
    //   117: aload 4
    //   119: ldc -67
    //   121: aload_0
    //   122: getfield 20	com/freelxl/baselibrary/e/e:a	Ljava/lang/String;
    //   125: invokestatic 238	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: pop
    //   132: aload 4
    //   134: ldc -16
    //   136: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   139: pop
    //   140: goto -74 -> 66
    //   143: aload 4
    //   145: new 116	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   152: aload 5
    //   154: invokeinterface 182 1 0
    //   159: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: ldc -67
    //   164: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: aload_0
    //   171: getfield 20	com/freelxl/baselibrary/e/e:a	Ljava/lang/String;
    //   174: invokestatic 238	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   180: pop
    //   181: goto -49 -> 132
    //   184: aload 4
    //   186: aload 4
    //   188: invokevirtual 246	java/lang/StringBuffer:length	()I
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual 250	java/lang/StringBuffer:deleteCharAt	(I)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: aload 4
    //   199: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   202: invokevirtual 254	java/lang/String:getBytes	()[B
    //   205: astore 5
    //   207: new 60	java/net/URL
    //   210: dup
    //   211: aload_3
    //   212: invokespecial 132	java/net/URL:<init>	(Ljava/lang/String;)V
    //   215: astore_2
    //   216: aload_2
    //   217: instanceof 60
    //   220: ifne +169 -> 389
    //   223: aload_2
    //   224: invokevirtual 67	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   227: astore_2
    //   228: aload_2
    //   229: checkcast 290	javax/net/ssl/HttpsURLConnection
    //   232: astore_2
    //   233: aload_2
    //   234: aload_1
    //   235: invokevirtual 293	com/freelxl/baselibrary/e/h:getObj	()Ljava/lang/Object;
    //   238: checkcast 295	javax/net/ssl/SSLContext
    //   241: invokevirtual 299	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   244: invokevirtual 303	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   247: aload_2
    //   248: iconst_1
    //   249: invokevirtual 304	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   252: aload_2
    //   253: iconst_1
    //   254: invokevirtual 307	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   257: aload_2
    //   258: ldc_w 260
    //   261: invokevirtual 308	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   264: aload_2
    //   265: ldc -113
    //   267: aload_0
    //   268: getfield 20	com/freelxl/baselibrary/e/e:a	Ljava/lang/String;
    //   271: invokevirtual 309	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_2
    //   275: ldc -108
    //   277: ldc -106
    //   279: invokevirtual 309	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload_2
    //   283: ldc_w 262
    //   286: new 116	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   293: aload 5
    //   295: arraylength
    //   296: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: ldc -67
    //   301: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokevirtual 309	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_1
    //   311: invokevirtual 153	com/freelxl/baselibrary/e/h:a	()Ljava/util/Map;
    //   314: astore_1
    //   315: aload_1
    //   316: ifnull +111 -> 427
    //   319: aload_1
    //   320: invokeinterface 158 1 0
    //   325: ifne +102 -> 427
    //   328: aload_1
    //   329: invokeinterface 162 1 0
    //   334: invokeinterface 168 1 0
    //   339: astore_1
    //   340: aload_1
    //   341: invokeinterface 173 1 0
    //   346: ifeq +81 -> 427
    //   349: aload_1
    //   350: invokeinterface 177 1 0
    //   355: checkcast 179	java/util/Map$Entry
    //   358: astore 6
    //   360: aload 6
    //   362: invokeinterface 182 1 0
    //   367: ifnonnull +33 -> 400
    //   370: aload_2
    //   371: aload 6
    //   373: invokeinterface 185 1 0
    //   378: checkcast 187	java/lang/String
    //   381: ldc -67
    //   383: invokevirtual 309	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: goto -46 -> 340
    //   389: aload_2
    //   390: checkcast 60	java/net/URL
    //   393: invokestatic 71	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   396: astore_2
    //   397: goto -169 -> 228
    //   400: aload_2
    //   401: aload 6
    //   403: invokeinterface 185 1 0
    //   408: checkcast 187	java/lang/String
    //   411: aload 6
    //   413: invokeinterface 182 1 0
    //   418: invokevirtual 192	java/lang/Object:toString	()Ljava/lang/String;
    //   421: invokevirtual 309	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: goto -84 -> 340
    //   427: aload_0
    //   428: aload_2
    //   429: invokespecial 194	com/freelxl/baselibrary/e/e:a	(Ljava/net/URLConnection;)V
    //   432: new 196	java/lang/StringBuffer
    //   435: dup
    //   436: invokespecial 197	java/lang/StringBuffer:<init>	()V
    //   439: astore_1
    //   440: ldc 114
    //   442: new 116	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 267
    //   452: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_3
    //   456: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc_w 269
    //   462: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 4
    //   467: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   470: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 131	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: aload_2
    //   480: invokevirtual 310	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   483: astore_3
    //   484: aload_3
    //   485: aload 5
    //   487: invokevirtual 279	java/io/OutputStream:write	([B)V
    //   490: aload_3
    //   491: invokevirtual 282	java/io/OutputStream:flush	()V
    //   494: aload_2
    //   495: invokevirtual 311	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   498: astore 4
    //   500: new 203	java/io/InputStreamReader
    //   503: dup
    //   504: aload 4
    //   506: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   509: astore_3
    //   510: new 208	java/io/BufferedReader
    //   513: dup
    //   514: aload_3
    //   515: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   518: astore_2
    //   519: aload_2
    //   520: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   523: astore 5
    //   525: aload 5
    //   527: ifnull +54 -> 581
    //   530: aload_1
    //   531: aload 5
    //   533: invokevirtual 217	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   536: pop
    //   537: goto -18 -> 519
    //   540: astore_1
    //   541: iconst_0
    //   542: ifeq +11 -> 553
    //   545: new 284	java/lang/NullPointerException
    //   548: dup
    //   549: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   552: athrow
    //   553: aload_2
    //   554: ifnull +7 -> 561
    //   557: aload_2
    //   558: invokevirtual 220	java/io/BufferedReader:close	()V
    //   561: aload_3
    //   562: ifnull +7 -> 569
    //   565: aload_3
    //   566: invokevirtual 221	java/io/InputStreamReader:close	()V
    //   569: aload 4
    //   571: ifnull +8 -> 579
    //   574: aload 4
    //   576: invokevirtual 224	java/io/InputStream:close	()V
    //   579: aload_1
    //   580: athrow
    //   581: ldc 114
    //   583: new 116	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 287
    //   593: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   600: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 131	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   609: iconst_0
    //   610: ifeq +11 -> 621
    //   613: new 284	java/lang/NullPointerException
    //   616: dup
    //   617: invokespecial 285	java/lang/NullPointerException:<init>	()V
    //   620: athrow
    //   621: aload_2
    //   622: ifnull +7 -> 629
    //   625: aload_2
    //   626: invokevirtual 220	java/io/BufferedReader:close	()V
    //   629: aload_3
    //   630: ifnull +7 -> 637
    //   633: aload_3
    //   634: invokevirtual 221	java/io/InputStreamReader:close	()V
    //   637: aload 4
    //   639: ifnull +8 -> 647
    //   642: aload 4
    //   644: invokevirtual 224	java/io/InputStream:close	()V
    //   647: aload_1
    //   648: invokevirtual 227	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   651: areturn
    //   652: astore_1
    //   653: aconst_null
    //   654: astore_2
    //   655: aconst_null
    //   656: astore_3
    //   657: aconst_null
    //   658: astore 4
    //   660: goto -119 -> 541
    //   663: astore_1
    //   664: aconst_null
    //   665: astore_2
    //   666: aconst_null
    //   667: astore_3
    //   668: goto -127 -> 541
    //   671: astore_1
    //   672: aconst_null
    //   673: astore_2
    //   674: goto -133 -> 541
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	e
    //   0	677	1	paramh	h
    //   31	643	2	localObject1	Object
    //   4	664	3	localObject2	Object
    //   39	620	4	localObject3	Object
    //   84	448	5	localObject4	Object
    //   358	54	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   519	525	540	finally
    //   530	537	540	finally
    //   581	609	540	finally
    //   479	500	652	finally
    //   500	510	663	finally
    //   510	519	671	finally
  }
  
  public void setCharset(String paramString)
  {
    this.a = paramString;
  }
  
  public void setConnectTimeout(Integer paramInteger)
  {
    this.b = paramInteger;
  }
  
  public void setProxyHost(String paramString)
  {
    this.d = paramString;
  }
  
  public void setProxyPort(Integer paramInteger)
  {
    this.e = paramInteger;
  }
  
  public void setSocketTimeout(Integer paramInteger)
  {
    this.c = paramInteger;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */