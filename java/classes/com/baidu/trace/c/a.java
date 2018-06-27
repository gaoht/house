package com.baidu.trace.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.trace.LBSTraceService;
import com.baidu.trace.api.bos.OnBosListener;
import com.baidu.trace.b.d;
import com.baidu.trace.h;
import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.ProtocolType;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class a
{
  public static ExecutorService a = null;
  public static ProtocolType b = ProtocolType.HTTPS;
  private static final Pattern c = Pattern.compile("[0-9A-Fa-f]{4}");
  private static a d = null;
  private static b e = null;
  private static WeakReference<Context> f = null;
  private static boolean g = false;
  private static int h = 5;
  private static int i = Integer.MAX_VALUE;
  private static long j = 60L;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 52	com/baidu/trace/c/a:f	Ljava/lang/ref/WeakReference;
    //   6: ifnull +13 -> 19
    //   9: getstatic 52	com/baidu/trace/c/a:f	Ljava/lang/ref/WeakReference;
    //   12: invokevirtual 136	java/lang/ref/WeakReference:clear	()V
    //   15: aconst_null
    //   16: putstatic 52	com/baidu/trace/c/a:f	Ljava/lang/ref/WeakReference;
    //   19: getstatic 54	com/baidu/trace/c/a:g	Z
    //   22: ifeq +11 -> 33
    //   25: getstatic 56	com/baidu/trace/c/a:a	Ljava/util/concurrent/ExecutorService;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnonnull +7 -> 37
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: getstatic 56	com/baidu/trace/c/a:a	Ljava/util/concurrent/ExecutorService;
    //   40: invokeinterface 141 1 0
    //   45: ifne +12 -> 57
    //   48: getstatic 56	com/baidu/trace/c/a:a	Ljava/util/concurrent/ExecutorService;
    //   51: invokeinterface 145 1 0
    //   56: pop
    //   57: aconst_null
    //   58: putstatic 48	com/baidu/trace/c/a:d	Lcom/baidu/trace/c/a$a;
    //   61: aconst_null
    //   62: putstatic 50	com/baidu/trace/c/a:e	Lcom/baidu/trace/c/a$b;
    //   65: aconst_null
    //   66: putstatic 56	com/baidu/trace/c/a:a	Ljava/util/concurrent/ExecutorService;
    //   69: iconst_0
    //   70: putstatic 54	com/baidu/trace/c/a:g	Z
    //   73: goto -40 -> 33
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    //   82: astore_0
    //   83: goto -26 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	2	0	localExecutorService	ExecutorService
    //   76	5	0	localObject	Object
    //   82	1	0	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	19	76	finally
    //   19	29	76	finally
    //   37	57	76	finally
    //   57	73	76	finally
    //   37	57	82	java/lang/Exception
  }
  
  public static void a(Context paramContext, Class<?> paramClass)
  {
    for (;;)
    {
      try
      {
        if (f == null) {
          f = new WeakReference(paramContext);
        }
        if (g)
        {
          paramContext = a;
          if (paramContext != null) {
            return;
          }
        }
        d = new a();
        e = new b((byte)0);
        if (LBSTraceService.class.getSimpleName().equals(paramClass.getSimpleName()))
        {
          a = Executors.newSingleThreadExecutor();
          g = true;
        }
        else
        {
          a = new ThreadPoolExecutor(h, i, j, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
      }
      finally {}
    }
  }
  
  public static void a(BaseRequest paramBaseRequest, int paramInt1, String paramString1, c paramc, int paramInt2, String paramString2, Object paramObject)
  {
    d locald = new d();
    locald.a = paramInt1;
    locald.b = paramInt2;
    locald.c = paramString1;
    locald.d = paramc;
    locald.e = paramString2;
    locald.f = paramBaseRequest;
    locald.g = paramObject;
    if ((a != null) && (!a.isShutdown())) {
      a.execute(locald);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramInt1 < 0) || (paramInt2 <= 0) || (paramInt2 < paramInt1) || (paramLong < 0L)) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      try
      {
        if ((a instanceof ThreadPoolExecutor))
        {
          ThreadPoolExecutor localThreadPoolExecutor = (ThreadPoolExecutor)a;
          localThreadPoolExecutor.setCorePoolSize(paramInt1);
          localThreadPoolExecutor.setMaximumPoolSize(paramInt2);
          localThreadPoolExecutor.setKeepAliveTime(paramLong, TimeUnit.SECONDS);
        }
        else
        {
          h = paramInt1;
          i = paramInt2;
          j = paramLong;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private static String b(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 85
    //   6: areturn
    //   7: new 227	java/io/BufferedReader
    //   10: dup
    //   11: new 229	java/io/InputStreamReader
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 232	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   19: invokespecial 235	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore_1
    //   23: new 237	java/lang/StringBuffer
    //   26: dup
    //   27: invokespecial 238	java/lang/StringBuffer:<init>	()V
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 241	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +26 -> 63
    //   40: aload_0
    //   41: aload_2
    //   42: invokevirtual 244	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   45: pop
    //   46: goto -15 -> 31
    //   49: astore_2
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 247	java/io/BufferedReader:close	()V
    //   58: aload_0
    //   59: invokevirtual 248	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   62: areturn
    //   63: aload_1
    //   64: ifnull -6 -> 58
    //   67: aload_1
    //   68: invokevirtual 247	java/io/BufferedReader:close	()V
    //   71: goto -13 -> 58
    //   74: astore_1
    //   75: goto -17 -> 58
    //   78: astore_0
    //   79: aload_0
    //   80: athrow
    //   81: astore_0
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 247	java/io/BufferedReader:close	()V
    //   93: aload_0
    //   94: athrow
    //   95: astore_0
    //   96: aload_0
    //   97: athrow
    //   98: astore_1
    //   99: goto -41 -> 58
    //   102: astore_1
    //   103: goto -10 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramInputStream	java.io.InputStream
    //   22	46	1	localBufferedReader	java.io.BufferedReader
    //   74	16	1	localIOException1	java.io.IOException
    //   98	1	1	localIOException2	java.io.IOException
    //   102	1	1	localIOException3	java.io.IOException
    //   35	7	2	str	String
    //   49	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   31	36	49	java/lang/Exception
    //   40	46	49	java/lang/Exception
    //   67	71	74	java/io/IOException
    //   67	71	78	finally
    //   54	58	81	finally
    //   31	36	84	finally
    //   40	46	84	finally
    //   89	93	95	finally
    //   54	58	98	java/io/IOException
    //   89	93	102	java/io/IOException
  }
  
  static final class a
    extends Handler
  {
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
    }
  }
  
  static final class b
    implements HostnameVerifier
  {
    public final boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return "api.map.baidu.com".equals(paramString);
    }
  }
  
  public static enum c
  {
    static
    {
      c localc = a;
      localc = b;
    }
    
    private c() {}
  }
  
  @Instrumented
  static final class d
    implements Runnable
  {
    protected int a;
    protected int b;
    protected String c;
    protected a.c d;
    protected String e;
    protected BaseRequest f;
    protected Object g;
    
    private String a(ProtocolType paramProtocolType, String paramString)
      throws Exception
    {
      paramString = a(paramString);
      if (paramString == null) {
        return "";
      }
      if (ProtocolType.HTTPS == paramProtocolType)
      {
        if (!(paramString instanceof URL)) {}
        for (paramProtocolType = paramString.openConnection();; paramProtocolType = HttpInstrumentation.openConnection((URL)paramString))
        {
          paramProtocolType = (HttpsURLConnection)paramProtocolType;
          if (!a(paramProtocolType)) {
            break;
          }
          return b(paramProtocolType);
        }
      }
      if (!(paramString instanceof URL)) {}
      for (paramProtocolType = paramString.openConnection();; paramProtocolType = HttpInstrumentation.openConnection((URL)paramString))
      {
        paramProtocolType = (HttpURLConnection)paramProtocolType;
        break;
      }
      return "";
    }
    
    private URL a(String paramString)
    {
      try
      {
        if (a.c.a == this.d) {
          return new URL(paramString + "?" + this.e);
        }
        if (a.c.b == this.d)
        {
          paramString = new URL(paramString);
          return paramString;
        }
      }
      catch (MalformedURLException paramString)
      {
        return null;
      }
      return null;
    }
    
    private boolean a(HttpURLConnection paramHttpURLConnection)
    {
      try
      {
        paramHttpURLConnection.setRequestMethod(this.d.name());
        paramHttpURLConnection.setConnectTimeout(10000);
        paramHttpURLConnection.setReadTimeout(15000);
        paramHttpURLConnection.setUseCaches(false);
        return true;
      }
      catch (ProtocolException paramHttpURLConnection) {}
      return false;
    }
    
    /* Error */
    private String b(HttpURLConnection paramHttpURLConnection)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 6
      //   3: aconst_null
      //   4: astore 7
      //   6: aconst_null
      //   7: astore 8
      //   9: aconst_null
      //   10: astore 9
      //   12: aload 6
      //   14: astore_3
      //   15: aload 7
      //   17: astore 5
      //   19: aload 8
      //   21: astore 4
      //   23: aload_1
      //   24: instanceof 48
      //   27: ifeq +330 -> 357
      //   30: aload 6
      //   32: astore_3
      //   33: aload 7
      //   35: astore 5
      //   37: aload 8
      //   39: astore 4
      //   41: aload_1
      //   42: checkcast 48	javax/net/ssl/HttpsURLConnection
      //   45: invokestatic 165	com/baidu/trace/c/a:d	()Lcom/baidu/trace/c/a$b;
      //   48: invokevirtual 169	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
      //   51: aload 6
      //   53: astore_3
      //   54: aload 7
      //   56: astore 5
      //   58: aload 8
      //   60: astore 4
      //   62: getstatic 90	com/baidu/trace/c/a$c:b	Lcom/baidu/trace/c/a$c;
      //   65: aload_0
      //   66: getfield 70	com/baidu/trace/c/a$d:d	Lcom/baidu/trace/c/a$c;
      //   69: if_acmpne +205 -> 274
      //   72: aload 6
      //   74: astore_3
      //   75: aload 7
      //   77: astore 5
      //   79: aload 8
      //   81: astore 4
      //   83: aload_1
      //   84: ldc -85
      //   86: ldc -83
      //   88: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   91: aload 6
      //   93: astore_3
      //   94: aload 7
      //   96: astore 5
      //   98: aload 8
      //   100: astore 4
      //   102: aload_1
      //   103: iconst_1
      //   104: invokevirtual 180	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   107: aload 6
      //   109: astore_3
      //   110: aload 7
      //   112: astore 5
      //   114: aload 8
      //   116: astore 4
      //   118: aload_1
      //   119: iconst_1
      //   120: invokevirtual 183	java/net/HttpURLConnection:setDoInput	(Z)V
      //   123: aload 6
      //   125: astore_3
      //   126: aload 7
      //   128: astore 5
      //   130: aload 8
      //   132: astore 4
      //   134: new 185	java/io/BufferedWriter
      //   137: dup
      //   138: new 187	java/io/OutputStreamWriter
      //   141: dup
      //   142: aload_1
      //   143: invokevirtual 191	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   146: ldc -128
      //   148: invokespecial 194	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   151: invokespecial 197	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   154: astore_2
      //   155: aload 6
      //   157: astore_3
      //   158: aload 7
      //   160: astore 5
      //   162: aload 8
      //   164: astore 4
      //   166: aload_2
      //   167: aload_0
      //   168: getfield 81	com/baidu/trace/c/a$d:e	Ljava/lang/String;
      //   171: invokevirtual 200	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   174: aload 6
      //   176: astore_3
      //   177: aload 7
      //   179: astore 5
      //   181: aload 8
      //   183: astore 4
      //   185: aload_2
      //   186: invokevirtual 203	java/io/BufferedWriter:flush	()V
      //   189: aload 6
      //   191: astore_3
      //   192: aload 7
      //   194: astore 5
      //   196: aload 8
      //   198: astore 4
      //   200: aload_2
      //   201: invokevirtual 206	java/io/BufferedWriter:close	()V
      //   204: aload 6
      //   206: astore_3
      //   207: aload 7
      //   209: astore 5
      //   211: aload 8
      //   213: astore 4
      //   215: aload_1
      //   216: invokevirtual 209	java/net/HttpURLConnection:connect	()V
      //   219: aload 6
      //   221: astore_3
      //   222: aload 7
      //   224: astore 5
      //   226: aload 8
      //   228: astore 4
      //   230: aload_1
      //   231: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   234: astore_2
      //   235: aload_2
      //   236: astore_3
      //   237: aload_2
      //   238: astore 5
      //   240: aload_2
      //   241: astore 4
      //   243: aload_2
      //   244: invokestatic 216	com/baidu/trace/c/a:a	(Ljava/io/InputStream;)Ljava/lang/String;
      //   247: astore 6
      //   249: aload 6
      //   251: astore_3
      //   252: aload_2
      //   253: ifnull +7 -> 260
      //   256: aload_2
      //   257: invokevirtual 219	java/io/InputStream:close	()V
      //   260: aload_3
      //   261: astore_2
      //   262: aload_1
      //   263: ifnull +9 -> 272
      //   266: aload_1
      //   267: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
      //   270: aload_3
      //   271: astore_2
      //   272: aload_2
      //   273: areturn
      //   274: aload 9
      //   276: astore_2
      //   277: aload 6
      //   279: astore_3
      //   280: aload 7
      //   282: astore 5
      //   284: aload 8
      //   286: astore 4
      //   288: getstatic 68	com/baidu/trace/c/a$c:a	Lcom/baidu/trace/c/a$c;
      //   291: aload_0
      //   292: getfield 70	com/baidu/trace/c/a$d:d	Lcom/baidu/trace/c/a$c;
      //   295: if_acmpne -60 -> 235
      //   298: aload 6
      //   300: astore_3
      //   301: aload 7
      //   303: astore 5
      //   305: aload 8
      //   307: astore 4
      //   309: aload_1
      //   310: ldc -85
      //   312: ldc -83
      //   314: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   317: aload 6
      //   319: astore_3
      //   320: aload 7
      //   322: astore 5
      //   324: aload 8
      //   326: astore 4
      //   328: sipush 200
      //   331: aload_1
      //   332: invokevirtual 226	java/net/HttpURLConnection:getResponseCode	()I
      //   335: if_icmpne +404 -> 739
      //   338: aload 6
      //   340: astore_3
      //   341: aload 7
      //   343: astore 5
      //   345: aload 8
      //   347: astore 4
      //   349: aload_1
      //   350: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   353: astore_2
      //   354: goto +387 -> 741
      //   357: aload 9
      //   359: astore_2
      //   360: aload 6
      //   362: astore_3
      //   363: aload 7
      //   365: astore 5
      //   367: aload 8
      //   369: astore 4
      //   371: aload_1
      //   372: instanceof 61
      //   375: ifeq -140 -> 235
      //   378: aload 6
      //   380: astore_3
      //   381: aload 7
      //   383: astore 5
      //   385: aload 8
      //   387: astore 4
      //   389: getstatic 68	com/baidu/trace/c/a$c:a	Lcom/baidu/trace/c/a$c;
      //   392: aload_0
      //   393: getfield 70	com/baidu/trace/c/a$d:d	Lcom/baidu/trace/c/a$c;
      //   396: if_acmpne +46 -> 442
      //   399: aload 9
      //   401: astore_2
      //   402: aload 6
      //   404: astore_3
      //   405: aload 7
      //   407: astore 5
      //   409: aload 8
      //   411: astore 4
      //   413: sipush 200
      //   416: aload_1
      //   417: invokevirtual 226	java/net/HttpURLConnection:getResponseCode	()I
      //   420: if_icmpne -185 -> 235
      //   423: aload 6
      //   425: astore_3
      //   426: aload 7
      //   428: astore 5
      //   430: aload 8
      //   432: astore 4
      //   434: aload_1
      //   435: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   438: astore_2
      //   439: goto -204 -> 235
      //   442: aload 9
      //   444: astore_2
      //   445: aload 6
      //   447: astore_3
      //   448: aload 7
      //   450: astore 5
      //   452: aload 8
      //   454: astore 4
      //   456: getstatic 90	com/baidu/trace/c/a$c:b	Lcom/baidu/trace/c/a$c;
      //   459: aload_0
      //   460: getfield 70	com/baidu/trace/c/a$d:d	Lcom/baidu/trace/c/a$c;
      //   463: if_acmpne -228 -> 235
      //   466: aload 6
      //   468: astore_3
      //   469: aload 7
      //   471: astore 5
      //   473: aload 8
      //   475: astore 4
      //   477: aload_1
      //   478: iconst_1
      //   479: invokevirtual 180	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   482: aload 6
      //   484: astore_3
      //   485: aload 7
      //   487: astore 5
      //   489: aload 8
      //   491: astore 4
      //   493: aload_1
      //   494: iconst_1
      //   495: invokevirtual 183	java/net/HttpURLConnection:setDoInput	(Z)V
      //   498: aload 6
      //   500: astore_3
      //   501: aload 7
      //   503: astore 5
      //   505: aload 8
      //   507: astore 4
      //   509: aload_1
      //   510: ldc -85
      //   512: ldc -83
      //   514: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   517: aload 6
      //   519: astore_3
      //   520: aload 7
      //   522: astore 5
      //   524: aload 8
      //   526: astore 4
      //   528: new 185	java/io/BufferedWriter
      //   531: dup
      //   532: new 187	java/io/OutputStreamWriter
      //   535: dup
      //   536: aload_1
      //   537: invokevirtual 191	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   540: ldc -128
      //   542: invokespecial 194	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   545: invokespecial 197	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   548: astore_2
      //   549: aload 6
      //   551: astore_3
      //   552: aload 7
      //   554: astore 5
      //   556: aload 8
      //   558: astore 4
      //   560: aload_2
      //   561: aload_0
      //   562: getfield 81	com/baidu/trace/c/a$d:e	Ljava/lang/String;
      //   565: invokevirtual 200	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   568: aload 6
      //   570: astore_3
      //   571: aload 7
      //   573: astore 5
      //   575: aload 8
      //   577: astore 4
      //   579: aload_2
      //   580: invokevirtual 203	java/io/BufferedWriter:flush	()V
      //   583: aload 6
      //   585: astore_3
      //   586: aload 7
      //   588: astore 5
      //   590: aload 8
      //   592: astore 4
      //   594: aload_2
      //   595: invokevirtual 206	java/io/BufferedWriter:close	()V
      //   598: aload 6
      //   600: astore_3
      //   601: aload 7
      //   603: astore 5
      //   605: aload 8
      //   607: astore 4
      //   609: aload_1
      //   610: invokevirtual 209	java/net/HttpURLConnection:connect	()V
      //   613: aload 6
      //   615: astore_3
      //   616: aload 7
      //   618: astore 5
      //   620: aload 8
      //   622: astore 4
      //   624: aload_1
      //   625: invokevirtual 213	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   628: astore_2
      //   629: goto -394 -> 235
      //   632: astore_1
      //   633: aload_1
      //   634: athrow
      //   635: astore_2
      //   636: aload_3
      //   637: astore 4
      //   639: ldc -28
      //   641: ldc -26
      //   643: invokestatic 232	com/baidu/trace/a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   646: ldc 34
      //   648: astore_2
      //   649: aload_3
      //   650: ifnull +7 -> 657
      //   653: aload_3
      //   654: invokevirtual 219	java/io/InputStream:close	()V
      //   657: aload_1
      //   658: ifnull -386 -> 272
      //   661: aload_1
      //   662: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
      //   665: ldc 34
      //   667: areturn
      //   668: astore_1
      //   669: aload_1
      //   670: athrow
      //   671: astore_2
      //   672: ldc 34
      //   674: astore_2
      //   675: aload 5
      //   677: ifnull +8 -> 685
      //   680: aload 5
      //   682: invokevirtual 219	java/io/InputStream:close	()V
      //   685: aload_1
      //   686: ifnull -414 -> 272
      //   689: aload_1
      //   690: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
      //   693: ldc 34
      //   695: areturn
      //   696: astore_1
      //   697: aload_1
      //   698: athrow
      //   699: astore_2
      //   700: aload 4
      //   702: ifnull +8 -> 710
      //   705: aload 4
      //   707: invokevirtual 219	java/io/InputStream:close	()V
      //   710: aload_1
      //   711: ifnull +7 -> 718
      //   714: aload_1
      //   715: invokevirtual 222	java/net/HttpURLConnection:disconnect	()V
      //   718: aload_2
      //   719: athrow
      //   720: astore_1
      //   721: aload_1
      //   722: athrow
      //   723: astore_2
      //   724: goto -464 -> 260
      //   727: astore_3
      //   728: goto -71 -> 657
      //   731: astore_3
      //   732: goto -47 -> 685
      //   735: astore_3
      //   736: goto -26 -> 710
      //   739: aconst_null
      //   740: astore_2
      //   741: goto -506 -> 235
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	744	0	this	d
      //   0	744	1	paramHttpURLConnection	HttpURLConnection
      //   154	475	2	localObject1	Object
      //   635	1	2	localSSLHandshakeException	javax.net.ssl.SSLHandshakeException
      //   648	1	2	str1	String
      //   671	1	2	localException	Exception
      //   674	1	2	str2	String
      //   699	20	2	localObject2	Object
      //   723	1	2	localIOException1	java.io.IOException
      //   740	1	2	localObject3	Object
      //   14	640	3	localObject4	Object
      //   727	1	3	localIOException2	java.io.IOException
      //   731	1	3	localIOException3	java.io.IOException
      //   735	1	3	localIOException4	java.io.IOException
      //   21	685	4	localObject5	Object
      //   17	664	5	localObject6	Object
      //   1	613	6	str3	String
      //   4	613	7	localObject7	Object
      //   7	614	8	localObject8	Object
      //   10	433	9	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   256	260	632	finally
      //   23	30	635	javax/net/ssl/SSLHandshakeException
      //   41	51	635	javax/net/ssl/SSLHandshakeException
      //   62	72	635	javax/net/ssl/SSLHandshakeException
      //   83	91	635	javax/net/ssl/SSLHandshakeException
      //   102	107	635	javax/net/ssl/SSLHandshakeException
      //   118	123	635	javax/net/ssl/SSLHandshakeException
      //   134	155	635	javax/net/ssl/SSLHandshakeException
      //   166	174	635	javax/net/ssl/SSLHandshakeException
      //   185	189	635	javax/net/ssl/SSLHandshakeException
      //   200	204	635	javax/net/ssl/SSLHandshakeException
      //   215	219	635	javax/net/ssl/SSLHandshakeException
      //   230	235	635	javax/net/ssl/SSLHandshakeException
      //   243	249	635	javax/net/ssl/SSLHandshakeException
      //   288	298	635	javax/net/ssl/SSLHandshakeException
      //   309	317	635	javax/net/ssl/SSLHandshakeException
      //   328	338	635	javax/net/ssl/SSLHandshakeException
      //   349	354	635	javax/net/ssl/SSLHandshakeException
      //   371	378	635	javax/net/ssl/SSLHandshakeException
      //   389	399	635	javax/net/ssl/SSLHandshakeException
      //   413	423	635	javax/net/ssl/SSLHandshakeException
      //   434	439	635	javax/net/ssl/SSLHandshakeException
      //   456	466	635	javax/net/ssl/SSLHandshakeException
      //   477	482	635	javax/net/ssl/SSLHandshakeException
      //   493	498	635	javax/net/ssl/SSLHandshakeException
      //   509	517	635	javax/net/ssl/SSLHandshakeException
      //   528	549	635	javax/net/ssl/SSLHandshakeException
      //   560	568	635	javax/net/ssl/SSLHandshakeException
      //   579	583	635	javax/net/ssl/SSLHandshakeException
      //   594	598	635	javax/net/ssl/SSLHandshakeException
      //   609	613	635	javax/net/ssl/SSLHandshakeException
      //   624	629	635	javax/net/ssl/SSLHandshakeException
      //   653	657	668	finally
      //   23	30	671	java/lang/Exception
      //   41	51	671	java/lang/Exception
      //   62	72	671	java/lang/Exception
      //   83	91	671	java/lang/Exception
      //   102	107	671	java/lang/Exception
      //   118	123	671	java/lang/Exception
      //   134	155	671	java/lang/Exception
      //   166	174	671	java/lang/Exception
      //   185	189	671	java/lang/Exception
      //   200	204	671	java/lang/Exception
      //   215	219	671	java/lang/Exception
      //   230	235	671	java/lang/Exception
      //   243	249	671	java/lang/Exception
      //   288	298	671	java/lang/Exception
      //   309	317	671	java/lang/Exception
      //   328	338	671	java/lang/Exception
      //   349	354	671	java/lang/Exception
      //   371	378	671	java/lang/Exception
      //   389	399	671	java/lang/Exception
      //   413	423	671	java/lang/Exception
      //   434	439	671	java/lang/Exception
      //   456	466	671	java/lang/Exception
      //   477	482	671	java/lang/Exception
      //   493	498	671	java/lang/Exception
      //   509	517	671	java/lang/Exception
      //   528	549	671	java/lang/Exception
      //   560	568	671	java/lang/Exception
      //   579	583	671	java/lang/Exception
      //   594	598	671	java/lang/Exception
      //   609	613	671	java/lang/Exception
      //   624	629	671	java/lang/Exception
      //   680	685	696	finally
      //   23	30	699	finally
      //   41	51	699	finally
      //   62	72	699	finally
      //   83	91	699	finally
      //   102	107	699	finally
      //   118	123	699	finally
      //   134	155	699	finally
      //   166	174	699	finally
      //   185	189	699	finally
      //   200	204	699	finally
      //   215	219	699	finally
      //   230	235	699	finally
      //   243	249	699	finally
      //   288	298	699	finally
      //   309	317	699	finally
      //   328	338	699	finally
      //   349	354	699	finally
      //   371	378	699	finally
      //   389	399	699	finally
      //   413	423	699	finally
      //   434	439	699	finally
      //   456	466	699	finally
      //   477	482	699	finally
      //   493	498	699	finally
      //   509	517	699	finally
      //   528	549	699	finally
      //   560	568	699	finally
      //   579	583	699	finally
      //   594	598	699	finally
      //   609	613	699	finally
      //   624	629	699	finally
      //   639	646	699	finally
      //   705	710	720	finally
      //   256	260	723	java/io/IOException
      //   653	657	727	java/io/IOException
      //   680	685	731	java/io/IOException
      //   705	710	735	java/io/IOException
    }
    
    public final void run()
    {
      if (this.f.isCanceled())
      {
        com.baidu.trace.a.a("request has been canceled!");
        return;
      }
      if ((a.b() != null) && (a.b().get() != null) && (!d.a((Context)a.b().get())))
      {
        a.c().post(new b(this));
        return;
      }
      Object localObject = new StringBuffer();
      for (;;)
      {
        try
        {
          if ((ProtocolType.HTTPS != a.b) && (3 != this.a)) {
            continue;
          }
          ((StringBuffer)localObject).append(a(ProtocolType.HTTPS, "https://api.map.baidu.com/sdkproxy/v2/lbs_tracesdk/trace/v3/" + this.c));
        }
        catch (Exception localException)
        {
          com.baidu.trace.a.a("http request failed");
          continue;
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (3 != this.a) || (3 == this.b)) {
            continue;
          }
          BaseRequest localBaseRequest = this.f;
          localObject = ((StringBuffer)localObject).toString();
          int i = this.b;
          OnBosListener localOnBosListener = (OnBosListener)this.g;
          a.a locala = a.c();
          h.a(localBaseRequest, i, true, 0, a.a((String)localObject), localOnBosListener, locala);
          return;
          a.c().post(new c(this, (StringBuffer)localObject));
        }
        if (!this.f.isCanceled()) {
          continue;
        }
        com.baidu.trace.a.a("request has been canceled!");
        return;
        if (ProtocolType.HTTP == a.b) {
          ((StringBuffer)localObject).append(a(ProtocolType.HTTP, "http://api.map.baidu.com/sdkproxy/v2/lbs_tracesdk/trace/v3/" + this.c));
        }
      }
    }
    
    public final String toString()
    {
      return "TaskRunnable [tag=" + this.f.getTag() + ", serviceTag=" + this.a + ", operateType=" + this.b + ", action=" + this.c + ", requestType=" + this.d + ", parameters=" + this.e + "]";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */