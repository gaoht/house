package com.mato.sdk.e.d;

import android.os.Build.VERSION;
import com.mato.sdk.f.d;
import com.mato.sdk.f.h.a;
import com.mato.sdk.f.h.b;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Iterator;
import java.util.List;

final class b
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final List<g> b;
  private final String c;
  private final String d;
  
  b(String paramString1, String paramString2, List<g> paramList)
  {
    this.c = paramString2;
    this.b = paramList;
    this.d = paramString1;
  }
  
  /* Error */
  private static void a(g paramg)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: iconst_1
    //   10: istore_2
    //   11: aload_0
    //   12: invokevirtual 136	com/mato/sdk/e/d/g:b	()Ljava/lang/String;
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 138	com/mato/sdk/e/d/g:c	()Ljava/lang/String;
    //   20: pop
    //   21: invokestatic 144	com/mato/sdk/instrumentation/InstrumentationUtils:getHttpProxy	()Ljava/net/Proxy;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnonnull +4 -> 32
    //   31: return
    //   32: new 146	java/net/URL
    //   35: dup
    //   36: aload_0
    //   37: invokevirtual 138	com/mato/sdk/e/d/g:c	()Ljava/lang/String;
    //   40: invokespecial 149	java/net/URL:<init>	(Ljava/lang/String;)V
    //   43: astore 8
    //   45: aload 8
    //   47: invokevirtual 152	java/net/URL:getProtocol	()Ljava/lang/String;
    //   50: ldc -102
    //   52: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: istore_3
    //   56: aload_0
    //   57: getfield 66	com/mato/sdk/e/d/g:a	Lcom/mato/sdk/e/d/f;
    //   60: astore 9
    //   62: iload_3
    //   63: ifne +271 -> 334
    //   66: aload 9
    //   68: iload_2
    //   69: putfield 161	com/mato/sdk/e/d/f:a	Z
    //   72: aload 8
    //   74: aload 4
    //   76: invokevirtual 165	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   79: checkcast 167	java/net/HttpURLConnection
    //   82: astore 4
    //   84: iload_3
    //   85: ifeq +254 -> 339
    //   88: ldc 21
    //   90: astore 6
    //   92: ldc -87
    //   94: invokestatic 174	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 5
    //   99: aload 5
    //   101: astore 6
    //   103: aload 7
    //   105: astore 5
    //   107: new 44	java/lang/StringBuffer
    //   110: dup
    //   111: aload 6
    //   113: invokespecial 175	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   116: astore 6
    //   118: aload 7
    //   120: astore 5
    //   122: aload 6
    //   124: ldc -79
    //   126: invokevirtual 77	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: ldc -77
    //   131: invokevirtual 77	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: aload_0
    //   135: invokevirtual 182	com/mato/sdk/e/d/g:a	()I
    //   138: invokevirtual 185	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   141: pop
    //   142: aload 7
    //   144: astore 5
    //   146: invokestatic 190	com/mato/sdk/b/a:a	()Lcom/mato/sdk/b/a;
    //   149: pop
    //   150: aload 7
    //   152: astore 5
    //   154: invokestatic 193	com/mato/sdk/b/a:f	()Z
    //   157: pop
    //   158: aload 7
    //   160: astore 5
    //   162: aload 6
    //   164: invokevirtual 82	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   167: pop
    //   168: aload 7
    //   170: astore 5
    //   172: aload 4
    //   174: ldc -61
    //   176: aload 6
    //   178: invokevirtual 82	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   181: invokevirtual 199	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 7
    //   186: astore 5
    //   188: aload 4
    //   190: iconst_0
    //   191: invokevirtual 203	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   194: aload 7
    //   196: astore 5
    //   198: aload 4
    //   200: iconst_0
    //   201: invokevirtual 206	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   204: aload 7
    //   206: astore 5
    //   208: aload 4
    //   210: aload_0
    //   211: invokevirtual 210	com/mato/sdk/e/d/g:e	()J
    //   214: l2i
    //   215: sipush 1000
    //   218: imul
    //   219: invokevirtual 214	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   222: aload 7
    //   224: astore 5
    //   226: getstatic 220	android/os/Build$VERSION:SDK_INT	I
    //   229: bipush 13
    //   231: if_icmple +16 -> 247
    //   234: aload 7
    //   236: astore 5
    //   238: aload 4
    //   240: ldc -34
    //   242: ldc -32
    //   244: invokevirtual 227	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 7
    //   249: astore 5
    //   251: aload 4
    //   253: invokevirtual 230	java/net/HttpURLConnection:getResponseCode	()I
    //   256: istore_1
    //   257: aload 7
    //   259: astore 5
    //   261: aload_0
    //   262: getfield 66	com/mato/sdk/e/d/g:a	Lcom/mato/sdk/e/d/f;
    //   265: iload_1
    //   266: putfield 232	com/mato/sdk/e/d/f:b	I
    //   269: iload_1
    //   270: sipush 200
    //   273: if_icmpne +138 -> 411
    //   276: aload 7
    //   278: astore 5
    //   280: aload 4
    //   282: invokevirtual 236	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   285: astore_0
    //   286: aload_0
    //   287: ifnull +28 -> 315
    //   290: aload_0
    //   291: astore 5
    //   293: sipush 1024
    //   296: newarray <illegal type>
    //   298: astore 6
    //   300: aload_0
    //   301: astore 5
    //   303: aload_0
    //   304: aload 6
    //   306: invokevirtual 242	java/io/InputStream:read	([B)I
    //   309: istore_1
    //   310: iload_1
    //   311: iconst_m1
    //   312: if_icmpne -12 -> 300
    //   315: aload_0
    //   316: ifnull +7 -> 323
    //   319: aload_0
    //   320: invokevirtual 244	java/io/InputStream:close	()V
    //   323: aload 4
    //   325: ifnull -294 -> 31
    //   328: aload 4
    //   330: invokevirtual 247	java/net/HttpURLConnection:disconnect	()V
    //   333: return
    //   334: iconst_0
    //   335: istore_2
    //   336: goto -270 -> 66
    //   339: aload 7
    //   341: astore 5
    //   343: aload 4
    //   345: ldc -7
    //   347: aload_0
    //   348: invokevirtual 182	com/mato/sdk/e/d/g:a	()I
    //   351: invokestatic 253	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   354: invokevirtual 199	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 7
    //   359: astore 5
    //   361: aload 4
    //   363: ldc -1
    //   365: ldc_w 257
    //   368: invokevirtual 199	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 7
    //   373: astore 5
    //   375: aload 4
    //   377: ldc_w 259
    //   380: ldc_w 261
    //   383: invokevirtual 199	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: goto -202 -> 184
    //   389: astore_0
    //   390: aload 5
    //   392: ifnull +8 -> 400
    //   395: aload 5
    //   397: invokevirtual 244	java/io/InputStream:close	()V
    //   400: aload 4
    //   402: ifnull -371 -> 31
    //   405: aload 4
    //   407: invokevirtual 247	java/net/HttpURLConnection:disconnect	()V
    //   410: return
    //   411: aload 7
    //   413: astore 5
    //   415: aload 4
    //   417: invokevirtual 264	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   420: astore_0
    //   421: goto -135 -> 286
    //   424: astore_0
    //   425: aconst_null
    //   426: astore 5
    //   428: aload 6
    //   430: astore 4
    //   432: aload 5
    //   434: ifnull +8 -> 442
    //   437: aload 5
    //   439: invokevirtual 244	java/io/InputStream:close	()V
    //   442: aload 4
    //   444: ifnull +8 -> 452
    //   447: aload 4
    //   449: invokevirtual 247	java/net/HttpURLConnection:disconnect	()V
    //   452: aload_0
    //   453: athrow
    //   454: astore_0
    //   455: goto -132 -> 323
    //   458: astore_0
    //   459: goto -59 -> 400
    //   462: astore 5
    //   464: goto -22 -> 442
    //   467: astore_0
    //   468: aconst_null
    //   469: astore 5
    //   471: goto -39 -> 432
    //   474: astore 6
    //   476: aload_0
    //   477: astore 5
    //   479: aload 6
    //   481: astore_0
    //   482: goto -50 -> 432
    //   485: astore_0
    //   486: aconst_null
    //   487: astore 4
    //   489: goto -99 -> 390
    //   492: astore 5
    //   494: goto -391 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	paramg	g
    //   256	57	1	i	int
    //   10	326	2	bool1	boolean
    //   55	30	3	bool2	boolean
    //   24	464	4	localObject1	Object
    //   1	437	5	localObject2	Object
    //   462	1	5	localIOException	java.io.IOException
    //   469	9	5	localg	g
    //   492	1	5	localException	Exception
    //   4	425	6	localObject3	Object
    //   474	6	6	localObject4	Object
    //   7	405	7	localObject5	Object
    //   43	30	8	localURL	java.net.URL
    //   60	7	9	localf	f
    // Exception table:
    //   from	to	target	type
    //   107	118	389	java/lang/Exception
    //   122	142	389	java/lang/Exception
    //   146	150	389	java/lang/Exception
    //   154	158	389	java/lang/Exception
    //   162	168	389	java/lang/Exception
    //   172	184	389	java/lang/Exception
    //   188	194	389	java/lang/Exception
    //   198	204	389	java/lang/Exception
    //   208	222	389	java/lang/Exception
    //   226	234	389	java/lang/Exception
    //   238	247	389	java/lang/Exception
    //   251	257	389	java/lang/Exception
    //   261	269	389	java/lang/Exception
    //   280	286	389	java/lang/Exception
    //   293	300	389	java/lang/Exception
    //   303	310	389	java/lang/Exception
    //   343	357	389	java/lang/Exception
    //   361	371	389	java/lang/Exception
    //   375	386	389	java/lang/Exception
    //   415	421	389	java/lang/Exception
    //   32	62	424	finally
    //   66	84	424	finally
    //   319	323	454	java/io/IOException
    //   395	400	458	java/io/IOException
    //   437	442	462	java/io/IOException
    //   92	99	467	finally
    //   107	118	467	finally
    //   122	142	467	finally
    //   146	150	467	finally
    //   154	158	467	finally
    //   162	168	467	finally
    //   172	184	467	finally
    //   188	194	467	finally
    //   198	204	467	finally
    //   208	222	467	finally
    //   226	234	467	finally
    //   238	247	467	finally
    //   251	257	467	finally
    //   261	269	467	finally
    //   280	286	467	finally
    //   343	357	467	finally
    //   361	371	467	finally
    //   375	386	467	finally
    //   415	421	467	finally
    //   293	300	474	finally
    //   303	310	474	finally
    //   32	62	485	java/lang/Exception
    //   66	84	485	java/lang/Exception
    //   92	99	492	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    paramString = new e(new e.a().a(com.mato.sdk.g.b.a(paramString.getBytes())).c(this.c).b("speedTestX.gzip").a(this.d).a(new h.a()
    {
      public final void a(Throwable paramAnonymousThrowable)
      {
        b.b();
      }
    }).a(new h.b()
    {
      private static void a(d paramAnonymousd)
      {
        if (paramAnonymousd.a == 200)
        {
          b.b();
          return;
        }
        b.b();
      }
    }));
    com.mato.sdk.proxy.a.b().a(paramString);
  }
  
  private static void a(boolean paramBoolean, HttpURLConnection paramHttpURLConnection, g paramg)
    throws ProtocolException
  {
    if (paramBoolean) {
      localObject = "";
    }
    try
    {
      String str = System.getProperty("http.agent");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    Object localObject = new StringBuffer((String)localObject);
    ((StringBuffer)localObject).append(" X-Maa-Backend-Type").append(":").append(paramg.a());
    com.mato.sdk.b.a.a();
    com.mato.sdk.b.a.f();
    ((StringBuffer)localObject).toString();
    paramHttpURLConnection.addRequestProperty("User-Agent", ((StringBuffer)localObject).toString());
    for (;;)
    {
      paramHttpURLConnection.setUseCaches(false);
      paramHttpURLConnection.setInstanceFollowRedirects(false);
      paramHttpURLConnection.setReadTimeout((int)paramg.e() * 1000);
      if (Build.VERSION.SDK_INT > 13) {
        paramHttpURLConnection.setRequestProperty("Connection", "close");
      }
      return;
      paramHttpURLConnection.addRequestProperty("X-Maa-Backend-Type", String.valueOf(paramg.a()));
      paramHttpURLConnection.addRequestProperty("X-Maa-Accelerate", "true");
      paramHttpURLConnection.addRequestProperty("X-Maa-Accelerate-Error-Bypass", "false");
    }
  }
  
  private void c()
  {
    Object localObject = new StringBuffer();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      localg.a.a();
      ((StringBuffer)localObject).append(localg.a.b()).append("\n");
    }
    localObject = ((StringBuffer)localObject).toString();
    localObject = new e(new e.a().a(com.mato.sdk.g.b.a(((String)localObject).getBytes())).c(this.c).b("speedTestX.gzip").a(this.d).a(new h.a()
    {
      public final void a(Throwable paramAnonymousThrowable)
      {
        b.b();
      }
    }).a(new h.b()
    {
      private static void a(d paramAnonymousd)
      {
        if (paramAnonymousd.a == 200)
        {
          b.b();
          return;
        }
        b.b();
      }
    }));
    com.mato.sdk.proxy.a.b().a((com.mato.sdk.f.e)localObject);
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 37	com/mato/sdk/e/d/b:b	Ljava/util/List;
    //   7: invokeinterface 51 1 0
    //   12: astore 7
    //   14: aload 7
    //   16: invokeinterface 57 1 0
    //   21: ifeq +252 -> 273
    //   24: aload 7
    //   26: invokeinterface 61 1 0
    //   31: checkcast 63	com/mato/sdk/e/d/g
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 136	com/mato/sdk/e/d/g:b	()Ljava/lang/String;
    //   41: pop
    //   42: aload 4
    //   44: invokevirtual 138	com/mato/sdk/e/d/g:c	()Ljava/lang/String;
    //   47: pop
    //   48: invokestatic 144	com/mato/sdk/instrumentation/InstrumentationUtils:getHttpProxy	()Ljava/net/Proxy;
    //   51: astore 5
    //   53: aload 5
    //   55: ifnull -41 -> 14
    //   58: new 146	java/net/URL
    //   61: dup
    //   62: aload 4
    //   64: invokevirtual 138	com/mato/sdk/e/d/g:c	()Ljava/lang/String;
    //   67: invokespecial 149	java/net/URL:<init>	(Ljava/lang/String;)V
    //   70: astore 8
    //   72: aload 8
    //   74: invokevirtual 152	java/net/URL:getProtocol	()Ljava/lang/String;
    //   77: ldc -102
    //   79: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: istore_3
    //   83: aload 4
    //   85: getfield 66	com/mato/sdk/e/d/g:a	Lcom/mato/sdk/e/d/f;
    //   88: astore 9
    //   90: iload_3
    //   91: ifne +108 -> 199
    //   94: iconst_1
    //   95: istore_2
    //   96: aload 9
    //   98: iload_2
    //   99: putfield 161	com/mato/sdk/e/d/f:a	Z
    //   102: aload 8
    //   104: aload 5
    //   106: invokevirtual 165	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   109: checkcast 167	java/net/HttpURLConnection
    //   112: astore 5
    //   114: iload_3
    //   115: aload 5
    //   117: aload 4
    //   119: invokestatic 270	com/mato/sdk/e/d/b:a	(ZLjava/net/HttpURLConnection;Lcom/mato/sdk/e/d/g;)V
    //   122: aload 5
    //   124: invokevirtual 230	java/net/HttpURLConnection:getResponseCode	()I
    //   127: istore_1
    //   128: aload 4
    //   130: getfield 66	com/mato/sdk/e/d/g:a	Lcom/mato/sdk/e/d/f;
    //   133: iload_1
    //   134: putfield 232	com/mato/sdk/e/d/f:b	I
    //   137: iload_1
    //   138: sipush 200
    //   141: if_icmpne +63 -> 204
    //   144: aload 5
    //   146: invokevirtual 236	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   149: astore 4
    //   151: aload 4
    //   153: ifnull +23 -> 176
    //   156: sipush 1024
    //   159: newarray <illegal type>
    //   161: astore 8
    //   163: aload 4
    //   165: aload 8
    //   167: invokevirtual 242	java/io/InputStream:read	([B)I
    //   170: istore_1
    //   171: iload_1
    //   172: iconst_m1
    //   173: if_icmpne -10 -> 163
    //   176: aload 4
    //   178: ifnull +8 -> 186
    //   181: aload 4
    //   183: invokevirtual 244	java/io/InputStream:close	()V
    //   186: aload 5
    //   188: ifnull -174 -> 14
    //   191: aload 5
    //   193: invokevirtual 247	java/net/HttpURLConnection:disconnect	()V
    //   196: goto -182 -> 14
    //   199: iconst_0
    //   200: istore_2
    //   201: goto -105 -> 96
    //   204: aload 5
    //   206: invokevirtual 264	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   209: astore 4
    //   211: goto -60 -> 151
    //   214: astore 4
    //   216: aconst_null
    //   217: astore 5
    //   219: aconst_null
    //   220: astore 4
    //   222: aload 4
    //   224: ifnull +8 -> 232
    //   227: aload 4
    //   229: invokevirtual 244	java/io/InputStream:close	()V
    //   232: aload 5
    //   234: ifnull -220 -> 14
    //   237: aload 5
    //   239: invokevirtual 247	java/net/HttpURLConnection:disconnect	()V
    //   242: goto -228 -> 14
    //   245: astore 4
    //   247: aconst_null
    //   248: astore 5
    //   250: aload 6
    //   252: ifnull +8 -> 260
    //   255: aload 6
    //   257: invokevirtual 244	java/io/InputStream:close	()V
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 247	java/net/HttpURLConnection:disconnect	()V
    //   270: aload 4
    //   272: athrow
    //   273: invokestatic 275	com/mato/sdk/g/a/a:b	()Lcom/mato/sdk/g/a/a;
    //   276: new 6	com/mato/sdk/e/d/b$1
    //   279: dup
    //   280: aload_0
    //   281: invokespecial 276	com/mato/sdk/e/d/b$1:<init>	(Lcom/mato/sdk/e/d/b;)V
    //   284: ldc2_w 277
    //   287: invokevirtual 281	com/mato/sdk/g/a/a:a	(Ljava/lang/Runnable;J)Lcom/mato/sdk/g/a/b;
    //   290: pop
    //   291: return
    //   292: astore 4
    //   294: goto -108 -> 186
    //   297: astore 4
    //   299: goto -67 -> 232
    //   302: astore 6
    //   304: goto -44 -> 260
    //   307: astore 4
    //   309: goto -59 -> 250
    //   312: astore 7
    //   314: aload 4
    //   316: astore 6
    //   318: aload 7
    //   320: astore 4
    //   322: goto -72 -> 250
    //   325: astore 4
    //   327: aconst_null
    //   328: astore 4
    //   330: goto -108 -> 222
    //   333: astore 8
    //   335: goto -113 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	b
    //   127	47	1	i	int
    //   95	106	2	bool1	boolean
    //   82	33	3	bool2	boolean
    //   34	176	4	localObject1	Object
    //   214	1	4	localException1	Exception
    //   220	8	4	localObject2	Object
    //   245	26	4	localObject3	Object
    //   292	1	4	localIOException1	java.io.IOException
    //   297	1	4	localIOException2	java.io.IOException
    //   307	8	4	localObject4	Object
    //   320	1	4	localObject5	Object
    //   325	1	4	localException2	Exception
    //   328	1	4	localObject6	Object
    //   51	215	5	localObject7	Object
    //   1	255	6	localObject8	Object
    //   302	1	6	localIOException3	java.io.IOException
    //   316	1	6	localObject9	Object
    //   12	13	7	localIterator	Iterator
    //   312	7	7	localObject10	Object
    //   70	96	8	localObject11	Object
    //   333	1	8	localException3	Exception
    //   88	9	9	localf	f
    // Exception table:
    //   from	to	target	type
    //   58	90	214	java/lang/Exception
    //   96	114	214	java/lang/Exception
    //   58	90	245	finally
    //   96	114	245	finally
    //   181	186	292	java/io/IOException
    //   227	232	297	java/io/IOException
    //   255	260	302	java/io/IOException
    //   114	137	307	finally
    //   144	151	307	finally
    //   204	211	307	finally
    //   156	163	312	finally
    //   163	171	312	finally
    //   114	137	325	java/lang/Exception
    //   144	151	325	java/lang/Exception
    //   204	211	325	java/lang/Exception
    //   156	163	333	java/lang/Exception
    //   163	171	333	java/lang/Exception
  }
  
  public final void a(int paramInt, String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (paramInt == localg.a()) {
        localg.a.a(paramString);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */