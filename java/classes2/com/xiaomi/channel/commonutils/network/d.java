package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.xiaomi.channel.commonutils.string.c;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

@Instrumented
public class d
{
  public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
  public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return -1;
      }
    }
    catch (Exception paramContext)
    {
      return -1;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return -1;
      }
    }
    catch (Exception paramContext)
    {
      return -1;
    }
    return paramContext.getType();
  }
  
  /* Error */
  public static b a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 6
    //   12: new 67	com/xiaomi/channel/commonutils/network/b
    //   15: dup
    //   16: invokespecial 70	com/xiaomi/channel/commonutils/network/b:<init>	()V
    //   19: astore 10
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 73	com/xiaomi/channel/commonutils/network/d:b	(Ljava/lang/String;)Ljava/net/URL;
    //   26: invokestatic 76	com/xiaomi/channel/commonutils/network/d:b	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   29: astore 11
    //   31: aload 11
    //   33: sipush 10000
    //   36: invokevirtual 82	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   39: aload 11
    //   41: sipush 15000
    //   44: invokevirtual 85	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   47: aload_2
    //   48: astore_0
    //   49: aload_2
    //   50: ifnonnull +6 -> 56
    //   53: ldc 87
    //   55: astore_0
    //   56: aload 11
    //   58: aload_0
    //   59: invokevirtual 91	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   62: aload_3
    //   63: ifnull +86 -> 149
    //   66: aload_3
    //   67: invokeinterface 97 1 0
    //   72: invokeinterface 103 1 0
    //   77: astore_1
    //   78: aload_1
    //   79: invokeinterface 109 1 0
    //   84: ifeq +65 -> 149
    //   87: aload_1
    //   88: invokeinterface 113 1 0
    //   93: checkcast 115	java/lang/String
    //   96: astore_0
    //   97: aload 11
    //   99: aload_0
    //   100: aload_3
    //   101: aload_0
    //   102: invokeinterface 119 2 0
    //   107: checkcast 115	java/lang/String
    //   110: invokevirtual 123	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: goto -35 -> 78
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_0
    //   119: aload 6
    //   121: astore_2
    //   122: aload_1
    //   123: athrow
    //   124: astore_3
    //   125: aload_2
    //   126: astore_1
    //   127: aload_0
    //   128: astore_2
    //   129: aload_3
    //   130: astore_0
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 128	java/io/OutputStream:close	()V
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 131	java/io/BufferedReader:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: aload 4
    //   151: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +384 -> 538
    //   157: aload 11
    //   159: iconst_1
    //   160: invokevirtual 141	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   163: aload 4
    //   165: invokevirtual 145	java/lang/String:getBytes	()[B
    //   168: astore_3
    //   169: aload 11
    //   171: invokevirtual 149	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   174: astore_0
    //   175: aload_0
    //   176: astore_1
    //   177: aload 9
    //   179: astore_2
    //   180: aload_0
    //   181: aload_3
    //   182: iconst_0
    //   183: aload_3
    //   184: arraylength
    //   185: invokevirtual 153	java/io/OutputStream:write	([BII)V
    //   188: aload_0
    //   189: astore_1
    //   190: aload 9
    //   192: astore_2
    //   193: aload_0
    //   194: invokevirtual 156	java/io/OutputStream:flush	()V
    //   197: aload_0
    //   198: astore_1
    //   199: aload 9
    //   201: astore_2
    //   202: aload_0
    //   203: invokevirtual 128	java/io/OutputStream:close	()V
    //   206: aload 10
    //   208: aload 11
    //   210: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   213: putfield 162	com/xiaomi/channel/commonutils/network/b:a	I
    //   216: ldc -92
    //   218: new 166	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   225: ldc -87
    //   227: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 10
    //   232: getfield 162	com/xiaomi/channel/commonutils/network/b:a	I
    //   235: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 186	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   244: pop
    //   245: iconst_0
    //   246: istore 5
    //   248: aload 11
    //   250: iload 5
    //   252: invokevirtual 190	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   255: astore_1
    //   256: aload 11
    //   258: iload 5
    //   260: invokevirtual 193	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   263: astore_0
    //   264: aload_1
    //   265: ifnonnull +77 -> 342
    //   268: aload_0
    //   269: ifnonnull +73 -> 342
    //   272: new 130	java/io/BufferedReader
    //   275: dup
    //   276: new 195	java/io/InputStreamReader
    //   279: dup
    //   280: new 6	com/xiaomi/channel/commonutils/network/d$a
    //   283: dup
    //   284: aload 11
    //   286: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   289: invokespecial 202	com/xiaomi/channel/commonutils/network/d$a:<init>	(Ljava/io/InputStream;)V
    //   292: invokespecial 203	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   295: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   303: astore_1
    //   304: new 211	java/lang/StringBuffer
    //   307: dup
    //   308: invokespecial 212	java/lang/StringBuffer:<init>	()V
    //   311: astore_2
    //   312: ldc -42
    //   314: invokestatic 220	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   317: astore_3
    //   318: aload_1
    //   319: ifnull +102 -> 421
    //   322: aload_2
    //   323: aload_1
    //   324: invokevirtual 223	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   327: pop
    //   328: aload_2
    //   329: aload_3
    //   330: invokevirtual 223	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   333: pop
    //   334: aload_0
    //   335: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   338: astore_1
    //   339: goto -21 -> 318
    //   342: aload 10
    //   344: getfield 226	com/xiaomi/channel/commonutils/network/b:b	Ljava/util/Map;
    //   347: aload_1
    //   348: aload_0
    //   349: invokeinterface 230 3 0
    //   354: pop
    //   355: iload 5
    //   357: iconst_1
    //   358: iadd
    //   359: iconst_1
    //   360: iadd
    //   361: istore 5
    //   363: goto -115 -> 248
    //   366: astore_0
    //   367: new 130	java/io/BufferedReader
    //   370: dup
    //   371: new 195	java/io/InputStreamReader
    //   374: dup
    //   375: new 6	com/xiaomi/channel/commonutils/network/d$a
    //   378: dup
    //   379: aload 11
    //   381: invokevirtual 233	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   384: invokespecial 202	com/xiaomi/channel/commonutils/network/d$a:<init>	(Ljava/io/InputStream;)V
    //   387: invokespecial 203	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   390: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   393: astore_0
    //   394: goto -95 -> 299
    //   397: astore_3
    //   398: aconst_null
    //   399: astore_0
    //   400: aload 7
    //   402: astore_2
    //   403: aload_0
    //   404: astore_1
    //   405: new 63	java/io/IOException
    //   408: dup
    //   409: aload_3
    //   410: invokevirtual 236	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   413: invokespecial 238	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   416: athrow
    //   417: astore_0
    //   418: goto -287 -> 131
    //   421: aload 10
    //   423: aload_2
    //   424: invokevirtual 239	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   427: putfield 242	com/xiaomi/channel/commonutils/network/b:c	Ljava/lang/String;
    //   430: aload_0
    //   431: invokevirtual 131	java/io/BufferedReader:close	()V
    //   434: iconst_0
    //   435: ifeq +11 -> 446
    //   438: new 244	java/lang/NullPointerException
    //   441: dup
    //   442: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   445: athrow
    //   446: iconst_0
    //   447: ifeq +11 -> 458
    //   450: new 244	java/lang/NullPointerException
    //   453: dup
    //   454: invokespecial 245	java/lang/NullPointerException:<init>	()V
    //   457: athrow
    //   458: aload 10
    //   460: areturn
    //   461: astore_0
    //   462: ldc -92
    //   464: ldc -9
    //   466: aload_0
    //   467: invokestatic 251	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   470: pop
    //   471: aload 10
    //   473: areturn
    //   474: astore_1
    //   475: ldc -92
    //   477: ldc -9
    //   479: aload_1
    //   480: invokestatic 251	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   483: pop
    //   484: goto -337 -> 147
    //   487: astore_0
    //   488: aconst_null
    //   489: astore_1
    //   490: aload 8
    //   492: astore_2
    //   493: goto -362 -> 131
    //   496: astore_3
    //   497: aconst_null
    //   498: astore_1
    //   499: aload_0
    //   500: astore_2
    //   501: aload_3
    //   502: astore_0
    //   503: goto -372 -> 131
    //   506: astore_3
    //   507: aload 7
    //   509: astore_2
    //   510: goto -107 -> 403
    //   513: astore_3
    //   514: aconst_null
    //   515: astore_1
    //   516: aload_0
    //   517: astore_2
    //   518: aload_1
    //   519: astore_0
    //   520: goto -117 -> 403
    //   523: astore_1
    //   524: aload_0
    //   525: astore_2
    //   526: aconst_null
    //   527: astore_0
    //   528: goto -406 -> 122
    //   531: astore_1
    //   532: aload 6
    //   534: astore_2
    //   535: goto -413 -> 122
    //   538: goto -332 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	paramContext	Context
    //   0	541	1	paramString1	String
    //   0	541	2	paramString2	String
    //   0	541	3	paramMap	Map<String, String>
    //   0	541	4	paramString3	String
    //   246	116	5	i	int
    //   10	523	6	localObject1	Object
    //   4	504	7	localObject2	Object
    //   1	490	8	localObject3	Object
    //   7	193	9	localObject4	Object
    //   19	453	10	localb	b
    //   29	351	11	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   21	47	116	java/io/IOException
    //   56	62	116	java/io/IOException
    //   66	78	116	java/io/IOException
    //   78	113	116	java/io/IOException
    //   149	175	116	java/io/IOException
    //   206	245	116	java/io/IOException
    //   248	264	116	java/io/IOException
    //   342	355	116	java/io/IOException
    //   367	394	116	java/io/IOException
    //   122	124	124	finally
    //   272	299	366	java/io/IOException
    //   21	47	397	java/lang/Throwable
    //   56	62	397	java/lang/Throwable
    //   66	78	397	java/lang/Throwable
    //   78	113	397	java/lang/Throwable
    //   149	175	397	java/lang/Throwable
    //   206	245	397	java/lang/Throwable
    //   248	264	397	java/lang/Throwable
    //   272	299	397	java/lang/Throwable
    //   342	355	397	java/lang/Throwable
    //   367	394	397	java/lang/Throwable
    //   180	188	417	finally
    //   193	197	417	finally
    //   202	206	417	finally
    //   405	417	417	finally
    //   438	446	461	java/io/IOException
    //   450	458	461	java/io/IOException
    //   135	139	474	java/io/IOException
    //   143	147	474	java/io/IOException
    //   21	47	487	finally
    //   56	62	487	finally
    //   66	78	487	finally
    //   78	113	487	finally
    //   149	175	487	finally
    //   206	245	487	finally
    //   248	264	487	finally
    //   272	299	487	finally
    //   342	355	487	finally
    //   367	394	487	finally
    //   299	318	496	finally
    //   322	339	496	finally
    //   421	434	496	finally
    //   180	188	506	java/lang/Throwable
    //   193	197	506	java/lang/Throwable
    //   202	206	506	java/lang/Throwable
    //   299	318	513	java/lang/Throwable
    //   322	339	513	java/lang/Throwable
    //   421	434	513	java/lang/Throwable
    //   180	188	523	java/io/IOException
    //   193	197	523	java/io/IOException
    //   202	206	523	java/io/IOException
    //   299	318	531	java/io/IOException
    //   322	339	531	java/io/IOException
    //   421	434	531	java/io/IOException
  }
  
  public static b a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    return a(paramContext, paramString, "POST", null, a(paramMap));
  }
  
  public static InputStream a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2)
  {
    return a(paramContext, paramURL, paramBoolean, paramString1, paramString2, null, null);
  }
  
  public static InputStream a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2, Map<String, String> paramMap, b paramb)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context");
    }
    if (paramURL == null) {
      throw new IllegalArgumentException("url");
    }
    URL localURL;
    if (!paramBoolean) {
      localURL = new URL(a(paramURL.toString()));
    }
    for (;;)
    {
      try
      {
        HttpURLConnection.setFollowRedirects(true);
        paramContext = b(paramContext, localURL);
        paramContext.setConnectTimeout(10000);
        paramContext.setReadTimeout(15000);
        if (!TextUtils.isEmpty(paramString1)) {
          paramContext.setRequestProperty("User-Agent", paramString1);
        }
        if (paramString2 != null) {
          paramContext.setRequestProperty("Cookie", paramString2);
        }
        if (paramMap != null)
        {
          paramString1 = paramMap.keySet().iterator();
          if (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            paramContext.setRequestProperty(paramString2, (String)paramMap.get(paramString2));
            continue;
          }
        }
        localURL = paramURL;
      }
      catch (IOException paramContext)
      {
        throw paramContext;
        if ((paramb != null) && ((paramURL.getProtocol().equals("http")) || (paramURL.getProtocol().equals("https"))))
        {
          paramb.a = paramContext.getResponseCode();
          if (paramb.b != null) {
            break label315;
          }
          paramb.b = new HashMap();
          break label315;
          paramURL = paramContext.getHeaderFieldKey(i);
          paramString1 = paramContext.getHeaderField(i);
          if ((paramURL != null) || (paramString1 != null)) {}
        }
        else
        {
          return new a(paramContext.getInputStream());
        }
        if ((TextUtils.isEmpty(paramURL)) || (TextUtils.isEmpty(paramString1))) {
          break label321;
        }
        paramb.b.put(paramURL, paramString1);
      }
      catch (Throwable paramContext)
      {
        throw new IOException(paramContext.getMessage());
      }
      continue;
      label315:
      int i = 0;
      continue;
      label321:
      i += 1;
    }
  }
  
  public static String a(Context paramContext, URL paramURL)
  {
    return a(paramContext, paramURL, false, null, "UTF-8", null);
  }
  
  public static String a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    localContext = null;
    try
    {
      paramContext = a(paramContext, paramURL, paramBoolean, paramString1, paramString3);
      localContext = paramContext;
      paramURL = new StringBuilder(1024);
      localContext = paramContext;
      paramString1 = new BufferedReader(new InputStreamReader(paramContext, paramString2));
      localContext = paramContext;
      paramString2 = new char['က'];
      for (;;)
      {
        localContext = paramContext;
        int i = paramString1.read(paramString2);
        if (-1 == i) {
          break;
        }
        localContext = paramContext;
        paramURL.append(paramString2, 0, i);
      }
      try
      {
        localContext.close();
        throw paramContext;
        if (paramContext != null) {}
        try
        {
          paramContext.close();
          return paramURL.toString();
        }
        catch (IOException paramContext)
        {
          for (;;)
          {
            Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + paramContext.toString());
          }
        }
      }
      catch (IOException paramURL)
      {
        for (;;)
        {
          Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + paramURL.toString());
        }
      }
    }
    finally
    {
      if (localContext == null) {}
    }
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new String();
      return String.format("%s&key=%s", new Object[] { paramString, c.a(String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[] { paramString })) });
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString1, Map<String, String> paramMap, java.io.File paramFile, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_2
    //   13: invokevirtual 349	java/io/File:exists	()Z
    //   16: ifne +7 -> 23
    //   19: aconst_null
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: aload_2
    //   24: invokevirtual 352	java/io/File:getName	()Ljava/lang/String;
    //   27: astore 6
    //   29: new 275	java/net/URL
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 279	java/net/URL:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: aload_0
    //   39: instanceof 275
    //   42: ifne +176 -> 218
    //   45: aload_0
    //   46: invokevirtual 356	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   49: astore_0
    //   50: aload_0
    //   51: checkcast 78	java/net/HttpURLConnection
    //   54: astore 10
    //   56: aload 10
    //   58: sipush 15000
    //   61: invokevirtual 85	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   64: aload 10
    //   66: sipush 10000
    //   69: invokevirtual 82	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   72: aload 10
    //   74: iconst_1
    //   75: invokevirtual 359	java/net/HttpURLConnection:setDoInput	(Z)V
    //   78: aload 10
    //   80: iconst_1
    //   81: invokevirtual 141	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   84: aload 10
    //   86: iconst_0
    //   87: invokevirtual 362	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   90: aload 10
    //   92: ldc_w 256
    //   95: invokevirtual 91	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   98: aload 10
    //   100: ldc_w 364
    //   103: ldc_w 366
    //   106: invokevirtual 123	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 10
    //   111: ldc_w 368
    //   114: ldc_w 370
    //   117: invokevirtual 123	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_1
    //   121: ifnull +108 -> 229
    //   124: aload_1
    //   125: invokeinterface 373 1 0
    //   130: invokeinterface 103 1 0
    //   135: astore_0
    //   136: aload_0
    //   137: invokeinterface 109 1 0
    //   142: ifeq +87 -> 229
    //   145: aload_0
    //   146: invokeinterface 113 1 0
    //   151: checkcast 375	java/util/Map$Entry
    //   154: astore_1
    //   155: aload 10
    //   157: aload_1
    //   158: invokeinterface 378 1 0
    //   163: checkcast 115	java/lang/String
    //   166: aload_1
    //   167: invokeinterface 381 1 0
    //   172: checkcast 115	java/lang/String
    //   175: invokevirtual 123	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: goto -42 -> 136
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_1
    //   186: aload 7
    //   188: astore_3
    //   189: aload_2
    //   190: athrow
    //   191: astore_2
    //   192: aload_1
    //   193: ifnull +7 -> 200
    //   196: aload_1
    //   197: invokevirtual 384	java/io/FileInputStream:close	()V
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   208: aload_3
    //   209: ifnull +7 -> 216
    //   212: aload_3
    //   213: invokevirtual 131	java/io/BufferedReader:close	()V
    //   216: aload_2
    //   217: athrow
    //   218: aload_0
    //   219: checkcast 275	java/net/URL
    //   222: invokestatic 392	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   225: astore_0
    //   226: goto -176 -> 50
    //   229: aload 10
    //   231: aload 6
    //   233: invokevirtual 395	java/lang/String:length	()I
    //   236: bipush 77
    //   238: iadd
    //   239: aload_2
    //   240: invokevirtual 398	java/io/File:length	()J
    //   243: l2i
    //   244: iadd
    //   245: aload_3
    //   246: invokevirtual 395	java/lang/String:length	()I
    //   249: iadd
    //   250: invokevirtual 401	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   253: new 386	java/io/DataOutputStream
    //   256: dup
    //   257: aload 10
    //   259: invokevirtual 149	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   262: invokespecial 404	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   265: astore_0
    //   266: aload_0
    //   267: ldc_w 406
    //   270: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   273: aload_0
    //   274: new 166	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 411
    //   284: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_3
    //   288: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 413
    //   294: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_2
    //   298: invokevirtual 352	java/io/File:getName	()Ljava/lang/String;
    //   301: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc_w 415
    //   307: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc_w 417
    //   313: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   322: aload_0
    //   323: ldc_w 417
    //   326: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   329: new 383	java/io/FileInputStream
    //   332: dup
    //   333: aload_2
    //   334: invokespecial 420	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   337: astore_1
    //   338: aload_0
    //   339: astore_3
    //   340: aload 9
    //   342: astore 5
    //   344: aload_1
    //   345: astore 6
    //   347: sipush 1024
    //   350: newarray <illegal type>
    //   352: astore_2
    //   353: aload_0
    //   354: astore_3
    //   355: aload 9
    //   357: astore 5
    //   359: aload_1
    //   360: astore 6
    //   362: aload_1
    //   363: aload_2
    //   364: invokevirtual 423	java/io/FileInputStream:read	([B)I
    //   367: istore 4
    //   369: iload 4
    //   371: iconst_m1
    //   372: if_icmpeq +36 -> 408
    //   375: aload_0
    //   376: astore_3
    //   377: aload 9
    //   379: astore 5
    //   381: aload_1
    //   382: astore 6
    //   384: aload_0
    //   385: aload_2
    //   386: iconst_0
    //   387: iload 4
    //   389: invokevirtual 424	java/io/DataOutputStream:write	([BII)V
    //   392: aload_0
    //   393: astore_3
    //   394: aload 9
    //   396: astore 5
    //   398: aload_1
    //   399: astore 6
    //   401: aload_0
    //   402: invokevirtual 425	java/io/DataOutputStream:flush	()V
    //   405: goto -52 -> 353
    //   408: aload_0
    //   409: astore_3
    //   410: aload 9
    //   412: astore 5
    //   414: aload_1
    //   415: astore 6
    //   417: aload_0
    //   418: ldc_w 417
    //   421: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   424: aload_0
    //   425: astore_3
    //   426: aload 9
    //   428: astore 5
    //   430: aload_1
    //   431: astore 6
    //   433: aload_0
    //   434: ldc_w 427
    //   437: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   440: aload_0
    //   441: astore_3
    //   442: aload 9
    //   444: astore 5
    //   446: aload_1
    //   447: astore 6
    //   449: aload_0
    //   450: ldc_w 429
    //   453: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   456: aload_0
    //   457: astore_3
    //   458: aload 9
    //   460: astore 5
    //   462: aload_1
    //   463: astore 6
    //   465: aload_0
    //   466: ldc_w 427
    //   469: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   472: aload_0
    //   473: astore_3
    //   474: aload 9
    //   476: astore 5
    //   478: aload_1
    //   479: astore 6
    //   481: aload_0
    //   482: ldc_w 417
    //   485: invokevirtual 409	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   488: aload_0
    //   489: astore_3
    //   490: aload 9
    //   492: astore 5
    //   494: aload_1
    //   495: astore 6
    //   497: aload_0
    //   498: invokevirtual 425	java/io/DataOutputStream:flush	()V
    //   501: aload_0
    //   502: astore_3
    //   503: aload 9
    //   505: astore 5
    //   507: aload_1
    //   508: astore 6
    //   510: new 211	java/lang/StringBuffer
    //   513: dup
    //   514: invokespecial 212	java/lang/StringBuffer:<init>	()V
    //   517: astore 11
    //   519: aload_0
    //   520: astore_3
    //   521: aload 9
    //   523: astore 5
    //   525: aload_1
    //   526: astore 6
    //   528: new 130	java/io/BufferedReader
    //   531: dup
    //   532: new 195	java/io/InputStreamReader
    //   535: dup
    //   536: new 6	com/xiaomi/channel/commonutils/network/d$a
    //   539: dup
    //   540: aload 10
    //   542: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   545: invokespecial 202	com/xiaomi/channel/commonutils/network/d$a:<init>	(Ljava/io/InputStream;)V
    //   548: invokespecial 203	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   551: invokespecial 206	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   554: astore_2
    //   555: aload_2
    //   556: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   559: astore_3
    //   560: aload_3
    //   561: ifnull +13 -> 574
    //   564: aload 11
    //   566: aload_3
    //   567: invokevirtual 223	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   570: pop
    //   571: goto -16 -> 555
    //   574: aload 11
    //   576: invokevirtual 239	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   579: astore_3
    //   580: aload_1
    //   581: ifnull +7 -> 588
    //   584: aload_1
    //   585: invokevirtual 384	java/io/FileInputStream:close	()V
    //   588: aload_0
    //   589: ifnull +7 -> 596
    //   592: aload_0
    //   593: invokevirtual 387	java/io/DataOutputStream:close	()V
    //   596: aload_3
    //   597: astore_0
    //   598: aload_2
    //   599: ifnull -578 -> 21
    //   602: aload_2
    //   603: invokevirtual 131	java/io/BufferedReader:close	()V
    //   606: aload_3
    //   607: areturn
    //   608: astore_0
    //   609: ldc -92
    //   611: ldc -9
    //   613: aload_0
    //   614: invokestatic 251	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   617: pop
    //   618: aload_3
    //   619: areturn
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_0
    //   623: aconst_null
    //   624: astore_1
    //   625: aload 8
    //   627: astore 5
    //   629: aload_0
    //   630: astore_3
    //   631: aload_1
    //   632: astore 6
    //   634: new 63	java/io/IOException
    //   637: dup
    //   638: aload_2
    //   639: invokevirtual 236	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   642: invokespecial 238	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   645: athrow
    //   646: astore_2
    //   647: aload_3
    //   648: astore_0
    //   649: aload 5
    //   651: astore_3
    //   652: aload 6
    //   654: astore_1
    //   655: goto -463 -> 192
    //   658: astore_0
    //   659: ldc -92
    //   661: ldc -9
    //   663: aload_0
    //   664: invokestatic 251	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   667: pop
    //   668: goto -452 -> 216
    //   671: astore_2
    //   672: aconst_null
    //   673: astore_0
    //   674: aconst_null
    //   675: astore_1
    //   676: aload 5
    //   678: astore_3
    //   679: goto -487 -> 192
    //   682: astore_2
    //   683: aconst_null
    //   684: astore_1
    //   685: aload 5
    //   687: astore_3
    //   688: goto -496 -> 192
    //   691: astore 5
    //   693: aload_2
    //   694: astore_3
    //   695: aload 5
    //   697: astore_2
    //   698: goto -506 -> 192
    //   701: astore_2
    //   702: aconst_null
    //   703: astore_1
    //   704: aload 8
    //   706: astore 5
    //   708: goto -79 -> 629
    //   711: astore_2
    //   712: aload 8
    //   714: astore 5
    //   716: goto -87 -> 629
    //   719: astore_3
    //   720: aload_2
    //   721: astore 5
    //   723: aload_3
    //   724: astore_2
    //   725: goto -96 -> 629
    //   728: astore_2
    //   729: aconst_null
    //   730: astore_1
    //   731: aload 7
    //   733: astore_3
    //   734: goto -545 -> 189
    //   737: astore_2
    //   738: aload 7
    //   740: astore_3
    //   741: goto -552 -> 189
    //   744: astore 5
    //   746: aload_2
    //   747: astore_3
    //   748: aload 5
    //   750: astore_2
    //   751: goto -562 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	754	0	paramString1	String
    //   0	754	1	paramMap	Map<String, String>
    //   0	754	2	paramFile	java.io.File
    //   0	754	3	paramString2	String
    //   367	21	4	i	int
    //   1	685	5	localObject1	Object
    //   691	5	5	localObject2	Object
    //   706	16	5	localObject3	Object
    //   744	5	5	localIOException	IOException
    //   27	626	6	localObject4	Object
    //   10	729	7	localObject5	Object
    //   4	709	8	localObject6	Object
    //   7	515	9	localObject7	Object
    //   54	487	10	localHttpURLConnection	HttpURLConnection
    //   517	58	11	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   29	50	181	java/io/IOException
    //   50	120	181	java/io/IOException
    //   124	136	181	java/io/IOException
    //   136	178	181	java/io/IOException
    //   218	226	181	java/io/IOException
    //   229	266	181	java/io/IOException
    //   189	191	191	finally
    //   584	588	608	java/io/IOException
    //   592	596	608	java/io/IOException
    //   602	606	608	java/io/IOException
    //   29	50	620	java/lang/Throwable
    //   50	120	620	java/lang/Throwable
    //   124	136	620	java/lang/Throwable
    //   136	178	620	java/lang/Throwable
    //   218	226	620	java/lang/Throwable
    //   229	266	620	java/lang/Throwable
    //   347	353	646	finally
    //   362	369	646	finally
    //   384	392	646	finally
    //   401	405	646	finally
    //   417	424	646	finally
    //   433	440	646	finally
    //   449	456	646	finally
    //   465	472	646	finally
    //   481	488	646	finally
    //   497	501	646	finally
    //   510	519	646	finally
    //   528	555	646	finally
    //   634	646	646	finally
    //   196	200	658	java/io/IOException
    //   204	208	658	java/io/IOException
    //   212	216	658	java/io/IOException
    //   29	50	671	finally
    //   50	120	671	finally
    //   124	136	671	finally
    //   136	178	671	finally
    //   218	226	671	finally
    //   229	266	671	finally
    //   266	338	682	finally
    //   555	560	691	finally
    //   564	571	691	finally
    //   574	580	691	finally
    //   266	338	701	java/lang/Throwable
    //   347	353	711	java/lang/Throwable
    //   362	369	711	java/lang/Throwable
    //   384	392	711	java/lang/Throwable
    //   401	405	711	java/lang/Throwable
    //   417	424	711	java/lang/Throwable
    //   433	440	711	java/lang/Throwable
    //   449	456	711	java/lang/Throwable
    //   465	472	711	java/lang/Throwable
    //   481	488	711	java/lang/Throwable
    //   497	501	711	java/lang/Throwable
    //   510	519	711	java/lang/Throwable
    //   528	555	711	java/lang/Throwable
    //   555	560	719	java/lang/Throwable
    //   564	571	719	java/lang/Throwable
    //   574	580	719	java/lang/Throwable
    //   266	338	728	java/io/IOException
    //   347	353	737	java/io/IOException
    //   362	369	737	java/io/IOException
    //   384	392	737	java/io/IOException
    //   401	405	737	java/io/IOException
    //   417	424	737	java/io/IOException
    //   433	440	737	java/io/IOException
    //   449	456	737	java/io/IOException
    //   465	472	737	java/io/IOException
    //   481	488	737	java/io/IOException
    //   497	501	737	java/io/IOException
    //   510	519	737	java/io/IOException
    //   528	555	737	java/io/IOException
    //   555	560	744	java/io/IOException
    //   564	571	744	java/io/IOException
    //   574	580	744	java/io/IOException
  }
  
  public static String a(URL paramURL)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramURL.getProtocol()).append("://").append("10.0.0.172").append(paramURL.getPath());
    if (!TextUtils.isEmpty(paramURL.getQuery())) {
      localStringBuilder.append("?").append(paramURL.getQuery());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
          try
          {
            localStringBuffer.append(URLEncoder.encode((String)localEntry.getKey(), "UTF-8"));
            localStringBuffer.append("=");
            localStringBuffer.append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
            localStringBuffer.append("&");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + localUnsupportedEncodingException.toString());
            Log.d("com.xiaomi.common.Network", "map: " + paramMap.toString());
            return null;
          }
        }
      }
      if (localUnsupportedEncodingException.length() <= 0) {
        break label215;
      }
    }
    label215:
    for (paramMap = localUnsupportedEncodingException.deleteCharAt(localUnsupportedEncodingException.length() - 1);; paramMap = localUnsupportedEncodingException)
    {
      return paramMap.toString();
      return null;
    }
  }
  
  public static HttpURLConnection b(Context paramContext, URL paramURL)
  {
    if (!"http".equals(paramURL.getProtocol()))
    {
      if (!(paramURL instanceof URL)) {}
      for (paramContext = paramURL.openConnection();; paramContext = HttpInstrumentation.openConnection((URL)paramURL)) {
        return (HttpURLConnection)paramContext;
      }
    }
    if (c(paramContext)) {
      return (HttpURLConnection)paramURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
    }
    if (!b(paramContext))
    {
      if (!(paramURL instanceof URL)) {}
      for (paramContext = paramURL.openConnection();; paramContext = HttpInstrumentation.openConnection((URL)paramURL)) {
        return (HttpURLConnection)paramContext;
      }
    }
    String str = paramURL.getHost();
    paramContext = new URL(a(paramURL));
    if (!(paramContext instanceof URL)) {}
    for (paramContext = paramContext.openConnection();; paramContext = HttpInstrumentation.openConnection((URL)paramContext))
    {
      paramContext = (HttpURLConnection)paramContext;
      paramContext.addRequestProperty("X-Online-Host", str);
      return paramContext;
    }
  }
  
  private static URL b(String paramString)
  {
    return new URL(paramString);
  }
  
  public static boolean b(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso())) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          continue;
        }
        try
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if (paramContext == null) {
            continue;
          }
          paramContext = paramContext.getExtraInfo();
          if ((TextUtils.isEmpty(paramContext)) || (paramContext.length() < 3) || (paramContext.contains("ctwap"))) {
            continue;
          }
          return paramContext.regionMatches(true, paramContext.length() - 3, "wap", 0, 3);
        }
        catch (Exception paramContext)
        {
          return false;
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean c(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso())) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    paramContext = paramContext.getExtraInfo();
    if ((TextUtils.isEmpty(paramContext)) || (paramContext.length() < 3)) {
      return false;
    }
    return paramContext.contains("ctwap");
  }
  
  public static boolean d(Context paramContext)
  {
    return a(paramContext) >= 0;
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected())) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean f(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 42
    //   3: invokevirtual 48	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 50	android/net/ConnectivityManager
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokevirtual 54	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull -8 -> 14
    //   25: iconst_1
    //   26: aload_0
    //   27: invokevirtual 60	android/net/NetworkInfo:getType	()I
    //   30: if_icmpne +7 -> 37
    //   33: iconst_1
    //   34: istore_1
    //   35: iload_1
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_1
    //   39: goto -4 -> 35
    //   42: astore_0
    //   43: iconst_0
    //   44: ireturn
    //   45: astore_0
    //   46: iconst_0
    //   47: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramContext	Context
    //   34	5	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   16	21	42	java/lang/Exception
    //   0	10	45	java/lang/Exception
  }
  
  public static boolean g(Context paramContext)
  {
    paramContext = j(paramContext);
    if (paramContext == null) {}
    while ((paramContext.getType() != 0) || (13 != paramContext.getSubtype())) {
      return false;
    }
    return true;
  }
  
  public static boolean h(Context paramContext)
  {
    paramContext = j(paramContext);
    if (paramContext == null) {}
    while (paramContext.getType() != 0) {
      return false;
    }
    String str = paramContext.getSubtypeName();
    if (("TD-SCDMA".equalsIgnoreCase(str)) || ("CDMA2000".equalsIgnoreCase(str)) || ("WCDMA".equalsIgnoreCase(str))) {
      return true;
    }
    switch (paramContext.getSubtype())
    {
    case 4: 
    case 7: 
    case 11: 
    case 13: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean i(Context paramContext)
  {
    paramContext = j(paramContext);
    if (paramContext == null) {}
    while (paramContext.getType() != 0) {
      return false;
    }
    switch (paramContext.getSubtype())
    {
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      return false;
    }
    return true;
  }
  
  public static NetworkInfo j(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String k(Context paramContext)
  {
    if (f(paramContext)) {
      return "wifi";
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return "";
      }
    }
    catch (Exception paramContext)
    {
      return "";
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return "";
      }
    }
    catch (Exception paramContext)
    {
      return "";
    }
    return (paramContext.getTypeName() + "-" + paramContext.getSubtypeName() + "-" + paramContext.getExtraInfo()).toLowerCase();
  }
  
  public static final class a
    extends FilterInputStream
  {
    private boolean a;
    
    public a(InputStream paramInputStream)
    {
      super();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.a)
      {
        paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          return paramInt1;
        }
      }
      this.a = true;
      return -1;
    }
  }
  
  public static class b
  {
    public int a;
    public Map<String, String> b;
    
    public String toString()
    {
      return String.format("resCode = %1$d, headers = %2$s", new Object[] { Integer.valueOf(this.a), this.b.toString() });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/network/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */