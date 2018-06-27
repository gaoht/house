package com.mato.sdk.e.b.a;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.mato.sdk.b.g;
import com.mato.sdk.e.b.d.a;
import com.mato.sdk.e.b.e;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static final String a = g.b("");
  private static final int b = 3;
  private final String c;
  private final boolean d;
  private a e;
  private final e f;
  private final String g;
  
  public c(e parame, String paramString, boolean paramBoolean)
  {
    this.g = parame.e().a;
    this.f = parame;
    this.c = paramString;
    this.d = paramBoolean;
  }
  
  private static String a(HttpURLConnection paramHttpURLConnection)
  {
    String str2 = paramHttpURLConnection.getHeaderField("Location");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramHttpURLConnection.getHeaderField("location");
    }
    return str1;
  }
  
  /* Error */
  private static HttpURLConnection a(String paramString)
    throws java.net.MalformedURLException, java.io.IOException
  {
    // Byte code:
    //   0: invokestatic 84	com/mato/sdk/instrumentation/InstrumentationUtils:getHttpProxy	()Ljava/net/Proxy;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnull +32 -> 37
    //   8: new 86	java/net/URL
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 89	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 93	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   20: checkcast 60	java/net/HttpURLConnection
    //   23: astore_0
    //   24: aload_0
    //   25: iconst_0
    //   26: invokevirtual 97	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: aconst_null
    //   33: areturn
    //   34: astore_1
    //   35: aload_0
    //   36: areturn
    //   37: aconst_null
    //   38: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	paramString	String
    //   3	14	1	localProxy	java.net.Proxy
    //   34	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   8	24	31	java/lang/Exception
    //   24	29	34	java/lang/Exception
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, boolean paramBoolean, String paramString)
    throws ProtocolException
  {
    if (paramBoolean)
    {
      paramHttpURLConnection.addRequestProperty("x-maa-accelerate", "true");
      paramHttpURLConnection.addRequestProperty("x-maa-accelerate-error-bypass", "false");
    }
    for (;;)
    {
      paramHttpURLConnection.addRequestProperty("x-maa-netdiagnosis", paramString);
      paramHttpURLConnection.setReadTimeout(10000);
      paramHttpURLConnection.setConnectTimeout(10000);
      paramHttpURLConnection.setRequestMethod("GET");
      if (Build.VERSION.SDK_INT > 13) {
        paramHttpURLConnection.setRequestProperty("Connection", "close");
      }
      return;
      paramHttpURLConnection.addRequestProperty("x-maa-accelerate", "false");
    }
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt >= 300) && (paramInt < 400);
  }
  
  /* Error */
  private int c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aload_0
    //   4: getfield 53	com/mato/sdk/e/b/a/c:c	Ljava/lang/String;
    //   7: astore 11
    //   9: iconst_0
    //   10: istore_1
    //   11: iconst_0
    //   12: istore_3
    //   13: aconst_null
    //   14: astore 6
    //   16: aload 6
    //   18: astore 7
    //   20: aload 12
    //   22: astore 10
    //   24: aload 6
    //   26: astore 9
    //   28: aload_0
    //   29: getfield 51	com/mato/sdk/e/b/a/c:f	Lcom/mato/sdk/e/b/e;
    //   32: invokevirtual 149	com/mato/sdk/e/b/e:b	()Z
    //   35: istore 4
    //   37: iload 4
    //   39: ifeq +15 -> 54
    //   42: aload 6
    //   44: ifnull +8 -> 52
    //   47: aload 6
    //   49: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   52: iconst_m1
    //   53: ireturn
    //   54: aload 6
    //   56: astore 7
    //   58: aload 12
    //   60: astore 10
    //   62: aload 6
    //   64: astore 9
    //   66: aload 11
    //   68: invokestatic 154	com/mato/sdk/e/b/a/c:a	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnonnull +16 -> 91
    //   78: aload 5
    //   80: ifnull +8 -> 88
    //   83: aload 5
    //   85: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   88: bipush -2
    //   90: ireturn
    //   91: aload 5
    //   93: astore 7
    //   95: aload 12
    //   97: astore 10
    //   99: aload 5
    //   101: astore 9
    //   103: aload_0
    //   104: getfield 156	com/mato/sdk/e/b/a/c:e	Lcom/mato/sdk/e/b/a/c$a;
    //   107: aload 11
    //   109: iload_3
    //   110: invokevirtual 159	com/mato/sdk/e/b/a/c$a:a	(Ljava/lang/String;Z)V
    //   113: aload 5
    //   115: astore 7
    //   117: aload 12
    //   119: astore 10
    //   121: aload 5
    //   123: astore 9
    //   125: aload_0
    //   126: getfield 55	com/mato/sdk/e/b/a/c:d	Z
    //   129: istore 4
    //   131: aload 5
    //   133: astore 7
    //   135: aload 12
    //   137: astore 10
    //   139: aload 5
    //   141: astore 9
    //   143: aload_0
    //   144: getfield 49	com/mato/sdk/e/b/a/c:g	Ljava/lang/String;
    //   147: astore 6
    //   149: iload 4
    //   151: ifeq +268 -> 419
    //   154: aload 5
    //   156: astore 7
    //   158: aload 12
    //   160: astore 10
    //   162: aload 5
    //   164: astore 9
    //   166: aload 5
    //   168: ldc 103
    //   170: ldc 105
    //   172: invokevirtual 109	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload 5
    //   177: astore 7
    //   179: aload 12
    //   181: astore 10
    //   183: aload 5
    //   185: astore 9
    //   187: aload 5
    //   189: ldc 111
    //   191: ldc 113
    //   193: invokevirtual 109	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 5
    //   198: astore 7
    //   200: aload 12
    //   202: astore 10
    //   204: aload 5
    //   206: astore 9
    //   208: aload 5
    //   210: ldc 115
    //   212: aload 6
    //   214: invokevirtual 109	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 5
    //   219: astore 7
    //   221: aload 12
    //   223: astore 10
    //   225: aload 5
    //   227: astore 9
    //   229: aload 5
    //   231: sipush 10000
    //   234: invokevirtual 119	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   237: aload 5
    //   239: astore 7
    //   241: aload 12
    //   243: astore 10
    //   245: aload 5
    //   247: astore 9
    //   249: aload 5
    //   251: sipush 10000
    //   254: invokevirtual 122	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   257: aload 5
    //   259: astore 7
    //   261: aload 12
    //   263: astore 10
    //   265: aload 5
    //   267: astore 9
    //   269: aload 5
    //   271: ldc 124
    //   273: invokevirtual 127	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   276: aload 5
    //   278: astore 7
    //   280: aload 12
    //   282: astore 10
    //   284: aload 5
    //   286: astore 9
    //   288: getstatic 132	android/os/Build$VERSION:SDK_INT	I
    //   291: bipush 13
    //   293: if_icmple +24 -> 317
    //   296: aload 5
    //   298: astore 7
    //   300: aload 12
    //   302: astore 10
    //   304: aload 5
    //   306: astore 9
    //   308: aload 5
    //   310: ldc -122
    //   312: ldc -120
    //   314: invokevirtual 139	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload 5
    //   319: astore 7
    //   321: aload 12
    //   323: astore 10
    //   325: aload 5
    //   327: astore 9
    //   329: aload 5
    //   331: invokevirtual 162	java/net/HttpURLConnection:getResponseCode	()I
    //   334: istore_2
    //   335: iload_2
    //   336: sipush 200
    //   339: if_icmpne +136 -> 475
    //   342: aload 5
    //   344: astore 7
    //   346: aload 12
    //   348: astore 10
    //   350: aload 5
    //   352: astore 9
    //   354: aload 5
    //   356: invokevirtual 166	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   359: astore 6
    //   361: aload 6
    //   363: astore 10
    //   365: aload 5
    //   367: astore 9
    //   369: sipush 1024
    //   372: newarray <illegal type>
    //   374: astore 7
    //   376: aload 6
    //   378: astore 10
    //   380: aload 5
    //   382: astore 9
    //   384: aload 6
    //   386: aload 7
    //   388: invokevirtual 172	java/io/InputStream:read	([B)I
    //   391: istore_1
    //   392: iload_1
    //   393: iconst_m1
    //   394: if_icmpne -18 -> 376
    //   397: aload 6
    //   399: ifnull +8 -> 407
    //   402: aload 6
    //   404: invokevirtual 174	java/io/InputStream:close	()V
    //   407: aload 5
    //   409: ifnull +8 -> 417
    //   412: aload 5
    //   414: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   417: iconst_0
    //   418: ireturn
    //   419: aload 5
    //   421: astore 7
    //   423: aload 12
    //   425: astore 10
    //   427: aload 5
    //   429: astore 9
    //   431: aload 5
    //   433: ldc 103
    //   435: ldc 113
    //   437: invokevirtual 109	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: goto -244 -> 196
    //   443: astore 5
    //   445: aconst_null
    //   446: astore 6
    //   448: aload 7
    //   450: astore 5
    //   452: aload 6
    //   454: ifnull +8 -> 462
    //   457: aload 6
    //   459: invokevirtual 174	java/io/InputStream:close	()V
    //   462: aload 5
    //   464: ifnull +8 -> 472
    //   467: aload 5
    //   469: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   472: bipush -10
    //   474: ireturn
    //   475: aload 5
    //   477: astore 7
    //   479: aload 12
    //   481: astore 10
    //   483: aload 5
    //   485: astore 9
    //   487: iload_2
    //   488: invokestatic 142	com/mato/sdk/e/b/a/c:b	(I)Z
    //   491: ifeq +177 -> 668
    //   494: iload_1
    //   495: iconst_1
    //   496: iadd
    //   497: istore_2
    //   498: iload_2
    //   499: iconst_3
    //   500: if_icmple +15 -> 515
    //   503: aload 5
    //   505: ifnull +8 -> 513
    //   508: aload 5
    //   510: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   513: iconst_0
    //   514: ireturn
    //   515: iload_3
    //   516: istore 4
    //   518: iload_2
    //   519: iconst_3
    //   520: if_icmpne +6 -> 526
    //   523: iconst_1
    //   524: istore 4
    //   526: aload 5
    //   528: astore 7
    //   530: aload 12
    //   532: astore 10
    //   534: aload 5
    //   536: astore 9
    //   538: aload 5
    //   540: ldc 58
    //   542: invokevirtual 63	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   545: astore 6
    //   547: aload 5
    //   549: astore 7
    //   551: aload 6
    //   553: astore 8
    //   555: aload 12
    //   557: astore 10
    //   559: aload 5
    //   561: astore 9
    //   563: aload 6
    //   565: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   568: ifeq +24 -> 592
    //   571: aload 5
    //   573: astore 7
    //   575: aload 12
    //   577: astore 10
    //   579: aload 5
    //   581: astore 9
    //   583: aload 5
    //   585: ldc 71
    //   587: invokevirtual 63	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   590: astore 8
    //   592: aload 5
    //   594: astore 7
    //   596: aload 12
    //   598: astore 10
    //   600: aload 5
    //   602: astore 9
    //   604: aload_0
    //   605: getfield 53	com/mato/sdk/e/b/a/c:c	Ljava/lang/String;
    //   608: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   611: istore_3
    //   612: iload_3
    //   613: ifeq +16 -> 629
    //   616: aload 5
    //   618: ifnull -105 -> 513
    //   621: aload 5
    //   623: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   626: goto -113 -> 513
    //   629: aload 5
    //   631: astore 6
    //   633: aload 8
    //   635: astore 11
    //   637: iload_2
    //   638: istore_1
    //   639: iload 4
    //   641: istore_3
    //   642: aload 5
    //   644: ifnull -628 -> 16
    //   647: aload 5
    //   649: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   652: aload 5
    //   654: astore 6
    //   656: aload 8
    //   658: astore 11
    //   660: iload_2
    //   661: istore_1
    //   662: iload 4
    //   664: istore_3
    //   665: goto -649 -> 16
    //   668: aload 5
    //   670: ifnull -157 -> 513
    //   673: aload 5
    //   675: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   678: goto -165 -> 513
    //   681: astore 5
    //   683: aload 10
    //   685: ifnull +8 -> 693
    //   688: aload 10
    //   690: invokevirtual 174	java/io/InputStream:close	()V
    //   693: aload 9
    //   695: ifnull +8 -> 703
    //   698: aload 9
    //   700: invokevirtual 152	java/net/HttpURLConnection:disconnect	()V
    //   703: aload 5
    //   705: athrow
    //   706: astore 6
    //   708: goto -301 -> 407
    //   711: astore 6
    //   713: goto -251 -> 462
    //   716: astore 6
    //   718: goto -25 -> 693
    //   721: astore 7
    //   723: goto -271 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	c
    //   10	652	1	i	int
    //   334	327	2	j	int
    //   12	653	3	bool1	boolean
    //   35	628	4	bool2	boolean
    //   71	361	5	localHttpURLConnection	HttpURLConnection
    //   443	1	5	localThrowable1	Throwable
    //   450	224	5	localObject1	Object
    //   681	23	5	localObject2	Object
    //   14	641	6	localObject3	Object
    //   706	1	6	localIOException1	java.io.IOException
    //   711	1	6	localIOException2	java.io.IOException
    //   716	1	6	localIOException3	java.io.IOException
    //   18	577	7	localObject4	Object
    //   721	1	7	localThrowable2	Throwable
    //   553	104	8	localObject5	Object
    //   26	673	9	localObject6	Object
    //   22	667	10	localObject7	Object
    //   7	652	11	localObject8	Object
    //   1	596	12	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	443	java/lang/Throwable
    //   66	73	443	java/lang/Throwable
    //   103	113	443	java/lang/Throwable
    //   125	131	443	java/lang/Throwable
    //   143	149	443	java/lang/Throwable
    //   166	175	443	java/lang/Throwable
    //   187	196	443	java/lang/Throwable
    //   208	217	443	java/lang/Throwable
    //   229	237	443	java/lang/Throwable
    //   249	257	443	java/lang/Throwable
    //   269	276	443	java/lang/Throwable
    //   288	296	443	java/lang/Throwable
    //   308	317	443	java/lang/Throwable
    //   329	335	443	java/lang/Throwable
    //   354	361	443	java/lang/Throwable
    //   431	440	443	java/lang/Throwable
    //   487	494	443	java/lang/Throwable
    //   538	547	443	java/lang/Throwable
    //   563	571	443	java/lang/Throwable
    //   583	592	443	java/lang/Throwable
    //   604	612	443	java/lang/Throwable
    //   28	37	681	finally
    //   66	73	681	finally
    //   103	113	681	finally
    //   125	131	681	finally
    //   143	149	681	finally
    //   166	175	681	finally
    //   187	196	681	finally
    //   208	217	681	finally
    //   229	237	681	finally
    //   249	257	681	finally
    //   269	276	681	finally
    //   288	296	681	finally
    //   308	317	681	finally
    //   329	335	681	finally
    //   354	361	681	finally
    //   369	376	681	finally
    //   384	392	681	finally
    //   431	440	681	finally
    //   487	494	681	finally
    //   538	547	681	finally
    //   563	571	681	finally
    //   583	592	681	finally
    //   604	612	681	finally
    //   402	407	706	java/io/IOException
    //   457	462	711	java/io/IOException
    //   688	693	716	java/io/IOException
    //   369	376	721	java/lang/Throwable
    //   384	392	721	java/lang/Throwable
  }
  
  public final b a()
  {
    Object localObject = this.c;
    boolean bool = this.d;
    localObject = new b(this.c);
    ((b)localObject).b = System.currentTimeMillis();
    try
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      this.e = new a(localCountDownLatch, (b)localObject, this.d);
      this.f.a(this.e);
      int i = c();
      if ((i == 0) && (!this.e.a()) && (!this.f.b())) {
        localCountDownLatch.await(30L, TimeUnit.SECONDS);
      }
      this.f.b(this.e);
      return (b)localObject;
    }
    catch (Exception localException) {}
    return (b)localObject;
  }
  
  static final class a
    implements d.a
  {
    private final CountDownLatch a;
    private final b b;
    private final a c;
    private final boolean d;
    private boolean e;
    
    public a(CountDownLatch paramCountDownLatch, b paramb, boolean paramBoolean)
    {
      this.a = paramCountDownLatch;
      this.b = paramb;
      this.c = new a((byte)0);
      this.d = paramBoolean;
      this.e = false;
    }
    
    private void b()
    {
      try
      {
        this.e = true;
        this.a.countDown();
        return;
      }
      finally {}
    }
    
    private boolean b(String paramString)
    {
      boolean bool2 = true;
      Object localObject;
      boolean bool3;
      try
      {
        if (this.c.a == null) {
          return false;
        }
        localObject = Uri.parse(this.c.a);
        bool3 = ((Uri)localObject).getScheme().equalsIgnoreCase("https");
        if (((!bool3) || (!paramString.contains(((Uri)localObject).getHost()))) && (!paramString.contains(this.c.a))) {
          break label296;
        }
        c.b();
        localObject = this.c.a;
        localObject = new a();
        if (!((a)localObject).a(paramString))
        {
          c.b();
          this.b.e = 578;
          return true;
        }
        if (this.c.c > ((a)localObject).a) {
          return false;
        }
      }
      finally {}
      boolean bool4 = this.d;
      if (!((a)localObject).b.contains("P"))
      {
        if (!((a)localObject).b.contains("p")) {
          break label305;
        }
        break label300;
        if (bool4 != bool1) {
          return false;
        }
        bool1 = bool2;
        if (!((a)localObject).b.contains("S")) {
          if (!((a)localObject).b.contains("s")) {
            break label310;
          }
        }
      }
      label296:
      label300:
      label305:
      label310:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if (bool3 != bool1) {
          return false;
        }
        if ((c.a(((a)localObject).c)) && (!this.c.b))
        {
          c.b();
          int i = ((a)localObject).c;
          this.c.d = paramString;
          return false;
        }
        c.b();
        bool1 = c.b.a(this.b, (a)localObject);
        return bool1;
        return false;
        bool1 = true;
        break;
        bool1 = false;
        break;
      }
    }
    
    public final void a(String paramString)
    {
      if (b(paramString)) {
        try
        {
          this.e = true;
          this.a.countDown();
          return;
        }
        finally {}
      }
    }
    
    public final void a(String paramString, boolean paramBoolean)
    {
      try
      {
        c.b();
        if (Uri.parse(paramString).getScheme().equalsIgnoreCase("https"))
        {
          this.c.b = true;
          if (this.c.d != null) {
            a(this.c.d);
          }
          return;
        }
        this.c.a = paramString;
        this.c.b = paramBoolean;
        this.c.c = System.currentTimeMillis();
        return;
      }
      finally {}
    }
    
    public final boolean a()
    {
      try
      {
        boolean bool = this.e;
        return bool;
      }
      finally {}
    }
    
    static final class a
    {
      public String a;
      public boolean b;
      public long c;
      public String d;
    }
  }
  
  static final class b
  {
    private final b a;
    private final a b;
    
    private b(b paramb, a parama)
    {
      this.a = paramb;
      this.b = parama;
    }
    
    private void a()
    {
      int i = 1;
      this.a.d = this.b.b;
      if ((this.b.c >= 600) || (this.b.c == -1))
      {
        switch (this.b.c)
        {
        default: 
          c.b();
          a(false);
        }
        do
        {
          return;
          c.b();
          c();
          return;
          c.b();
          this.a.e = -1;
          this.a.g = this.b.d;
          this.a.h = this.b.e;
          this.a.i = this.b.f;
          this.a.j = -1;
          this.a.k = -1;
          this.a.a = this.b.j;
          return;
        } while ((!this.b.b.equalsIgnoreCase("XP")) || (this.b.d != -1) || (this.b.f != -1) || (this.b.g != -1) || (this.b.e != -1) || (this.b.h != -1) || (!this.b.m.equalsIgnoreCase("TUNNEL_UNAVAILABLE")));
        if (this.b.j.equals(""))
        {
          c.b();
          c();
          return;
        }
        c.b();
        a(true);
        return;
      }
      c.b();
      this.a.e = this.b.c;
      this.a.a = this.b.j;
      this.a.f = this.b.k;
      this.a.g = this.b.d;
      this.a.d = this.b.b;
      this.a.h = this.b.e;
      this.a.i = this.b.f;
      this.a.j = this.b.g;
      a locala = this.b;
      if ((locala.l >= 0) && (locala.i >= 0) && (locala.l != locala.i)) {
        if (i == 0) {
          break label488;
        }
      }
      label488:
      for (this.a.k = -1;; this.a.k = this.b.h)
      {
        this.a.l = this.b.i;
        this.a.c();
        return;
        i = 0;
        break;
      }
    }
    
    private void a(boolean paramBoolean)
    {
      this.a.e = -1;
      this.a.g = this.b.d;
      if ((paramBoolean) && (this.a.g == -1)) {
        this.a.g = 0;
      }
      this.a.h = -1;
      this.a.i = -1;
      this.a.j = -1;
      this.a.k = -1;
      this.a.a = this.b.j;
    }
    
    public static boolean a(b paramb, a parama)
    {
      int j = 0;
      paramb = new b(paramb, parama);
      paramb.a.d = paramb.b.b;
      if ((paramb.b.c >= 600) || (paramb.b.c == -1))
      {
        switch (paramb.b.c)
        {
        default: 
          c.b();
          paramb.a(false);
        }
        do
        {
          return true;
          c.b();
          paramb.c();
          return true;
          c.b();
          paramb.a.e = -1;
          paramb.a.g = paramb.b.d;
          paramb.a.h = paramb.b.e;
          paramb.a.i = paramb.b.f;
          paramb.a.j = -1;
          paramb.a.k = -1;
          paramb.a.a = paramb.b.j;
          return true;
        } while ((!paramb.b.b.equalsIgnoreCase("XP")) || (paramb.b.d != -1) || (paramb.b.f != -1) || (paramb.b.g != -1) || (paramb.b.e != -1) || (paramb.b.h != -1) || (!paramb.b.m.equalsIgnoreCase("TUNNEL_UNAVAILABLE")));
        if (paramb.b.j.equals(""))
        {
          c.b();
          paramb.c();
          return true;
        }
        c.b();
        paramb.a(true);
        return true;
      }
      c.b();
      paramb.a.e = paramb.b.c;
      paramb.a.a = paramb.b.j;
      paramb.a.f = paramb.b.k;
      paramb.a.g = paramb.b.d;
      paramb.a.d = paramb.b.b;
      paramb.a.h = paramb.b.e;
      paramb.a.i = paramb.b.f;
      paramb.a.j = paramb.b.g;
      parama = paramb.b;
      int i = j;
      if (parama.l >= 0)
      {
        i = j;
        if (parama.i >= 0)
        {
          i = j;
          if (parama.l != parama.i) {
            i = 1;
          }
        }
      }
      if (i != 0) {}
      for (paramb.a.k = -1;; paramb.a.k = paramb.b.h)
      {
        paramb.a.l = paramb.b.i;
        paramb.a.c();
        return true;
      }
    }
    
    private void b()
    {
      if ((this.b.b.equalsIgnoreCase("XP")) && (this.b.d == -1) && (this.b.f == -1) && (this.b.g == -1) && (this.b.e == -1) && (this.b.h == -1) && (this.b.m.equalsIgnoreCase("TUNNEL_UNAVAILABLE")))
      {
        if (this.b.j.equals(""))
        {
          c.b();
          c();
        }
      }
      else {
        return;
      }
      c.b();
      a(true);
    }
    
    private void c()
    {
      this.a.e = -1;
      this.a.g = -1;
      this.a.h = -1;
      this.a.i = -1;
      this.a.j = -1;
      this.a.k = -1;
    }
    
    private void d()
    {
      this.a.e = -1;
      this.a.g = this.b.d;
      this.a.h = this.b.e;
      this.a.i = this.b.f;
      this.a.j = -1;
      this.a.k = -1;
      this.a.a = this.b.j;
    }
    
    private void e()
    {
      this.a.e = this.b.c;
      this.a.a = this.b.j;
      this.a.f = this.b.k;
      this.a.g = this.b.d;
      this.a.d = this.b.b;
      this.a.h = this.b.e;
      this.a.i = this.b.f;
      this.a.j = this.b.g;
      a locala = this.b;
      int i;
      if ((locala.l >= 0) && (locala.i >= 0) && (locala.l != locala.i))
      {
        i = 1;
        if (i == 0) {
          break label183;
        }
      }
      label183:
      for (this.a.k = -1;; this.a.k = this.b.h)
      {
        this.a.l = this.b.i;
        this.a.c();
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */