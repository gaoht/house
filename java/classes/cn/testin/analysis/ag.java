package cn.testin.analysis;

import com.maa.android.agent.instrumentation.Instrumented;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

@Instrumented
public class ag
  extends ah
{
  private final String a = "httpPost";
  private int e = 1;
  private int f = 10000;
  private int g = 10000;
  private boolean h = true;
  
  public ag(String paramString1, String paramString2, af paramaf)
  {
    super(paramString1, paramString2, paramaf);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.d != null) {
      this.d.a(paramInt, paramString);
    }
  }
  
  private boolean a(Throwable paramThrowable, int paramInt)
  {
    ar.c("httpPost", paramThrowable.getMessage());
    if (paramInt >= this.e) {}
    do
    {
      do
      {
        return false;
      } while (((paramThrowable instanceof MalformedURLException)) || ((paramThrowable instanceof UnknownHostException)) || ((paramThrowable instanceof p)));
      if ((paramThrowable instanceof IOException)) {
        return true;
      }
    } while (!(paramThrowable instanceof Exception));
    return true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      String str = new String(c(), "utf-8");
      ar.c("httpPost", "result:" + str);
      if (this.d != null) {
        this.d.a(str);
      }
      return;
    }
    catch (q localq)
    {
      a(1005, "无可用网络");
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      a(1002, "URL不正确");
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      a(1007, "HOST解析失败");
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      a(1001, "连接超时");
      return;
    }
    catch (IOException localIOException)
    {
      a(1003, "IO异常");
      return;
    }
    catch (p localp)
    {
      a(1000, "连接服务器失败" + localp.a());
      return;
    }
    catch (Exception localException)
    {
      ar.a(localException);
      a(1004, "未知错误");
    }
  }
  
  /* Error */
  public byte[] c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc 19
    //   5: new 81	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: getfield 121	cn/testin/analysis/ag:b	Ljava/lang/String;
    //   16: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 123
    //   21: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 125	cn/testin/analysis/ag:c	Ljava/lang/String;
    //   28: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 52	cn/testin/analysis/ar:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iconst_0
    //   38: istore_1
    //   39: iconst_1
    //   40: istore_3
    //   41: aconst_null
    //   42: astore 4
    //   44: iload_3
    //   45: ifeq +564 -> 609
    //   48: iload_1
    //   49: ifle +27 -> 76
    //   52: ldc 19
    //   54: new 81	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   61: ldc 127
    //   63: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 129	cn/testin/analysis/ar:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: new 131	java/net/URL
    //   79: dup
    //   80: aload_0
    //   81: getfield 121	cn/testin/analysis/ag:b	Ljava/lang/String;
    //   84: invokespecial 133	java/net/URL:<init>	(Ljava/lang/String;)V
    //   87: astore 6
    //   89: aload 6
    //   91: instanceof 131
    //   94: ifne +301 -> 395
    //   97: aload 6
    //   99: invokevirtual 137	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   102: astore 4
    //   104: aload 4
    //   106: checkcast 139	java/net/HttpURLConnection
    //   109: astore 4
    //   111: aload 4
    //   113: instanceof 141
    //   116: ifeq +23 -> 139
    //   119: getstatic 147	cn/testin/analysis/a:q	Ljavax/net/ssl/SSLSocketFactory;
    //   122: astore 5
    //   124: aload 5
    //   126: ifnull +13 -> 139
    //   129: aload 4
    //   131: checkcast 141	javax/net/ssl/HttpsURLConnection
    //   134: aload 5
    //   136: invokevirtual 151	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   139: aload 4
    //   141: iconst_1
    //   142: invokevirtual 154	java/net/HttpURLConnection:setDoInput	(Z)V
    //   145: aload 4
    //   147: iconst_1
    //   148: invokevirtual 157	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   151: aload 4
    //   153: iconst_0
    //   154: invokevirtual 160	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   157: aload 4
    //   159: ldc -94
    //   161: ldc -92
    //   163: invokevirtual 167	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_0
    //   167: getfield 29	cn/testin/analysis/ag:h	Z
    //   170: ifeq +30 -> 200
    //   173: aload 4
    //   175: ldc -87
    //   177: ldc -85
    //   179: invokevirtual 167	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 4
    //   184: ldc -83
    //   186: ldc -85
    //   188: invokevirtual 167	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 4
    //   193: ldc -82
    //   195: ldc -85
    //   197: invokevirtual 167	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 4
    //   202: aload_0
    //   203: getfield 27	cn/testin/analysis/ag:g	I
    //   206: invokevirtual 178	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   209: aload 4
    //   211: aload_0
    //   212: getfield 25	cn/testin/analysis/ag:f	I
    //   215: invokevirtual 181	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   218: aload 4
    //   220: ldc -73
    //   222: ldc 76
    //   224: invokevirtual 167	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 4
    //   229: ldc -71
    //   231: invokevirtual 188	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   234: aload 4
    //   236: invokevirtual 192	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   239: astore 7
    //   241: aload_0
    //   242: getfield 29	cn/testin/analysis/ag:h	Z
    //   245: ifeq +163 -> 408
    //   248: aload_0
    //   249: getfield 125	cn/testin/analysis/ag:c	Ljava/lang/String;
    //   252: invokevirtual 195	java/lang/String:getBytes	()[B
    //   255: invokestatic 200	cn/testin/analysis/am:a	([B)[B
    //   258: astore 5
    //   260: aload 7
    //   262: aload 5
    //   264: invokevirtual 206	java/io/OutputStream:write	([B)V
    //   267: aload 7
    //   269: invokevirtual 209	java/io/OutputStream:flush	()V
    //   272: aload 7
    //   274: invokevirtual 212	java/io/OutputStream:close	()V
    //   277: aload 4
    //   279: invokevirtual 215	java/net/HttpURLConnection:getResponseCode	()I
    //   282: istore_2
    //   283: ldc 19
    //   285: new 81	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   292: ldc -39
    //   294: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 6
    //   299: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: ldc -34
    //   304: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload_2
    //   308: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 52	cn/testin/analysis/ar:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: iload_2
    //   318: sipush 200
    //   321: if_icmpne +109 -> 430
    //   324: aload 4
    //   326: invokevirtual 226	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   329: astore 5
    //   331: aload 4
    //   333: invokevirtual 229	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   336: astore 6
    //   338: aload 6
    //   340: ifnull +80 -> 420
    //   343: aload 6
    //   345: ldc -85
    //   347: invokevirtual 233	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   350: ifeq +70 -> 420
    //   353: aload 5
    //   355: invokestatic 236	cn/testin/analysis/am:a	(Ljava/io/InputStream;)[B
    //   358: astore 6
    //   360: iconst_0
    //   361: ifeq +11 -> 372
    //   364: new 238	java/lang/NullPointerException
    //   367: dup
    //   368: invokespecial 239	java/lang/NullPointerException:<init>	()V
    //   371: athrow
    //   372: aload 5
    //   374: ifnull +8 -> 382
    //   377: aload 5
    //   379: invokevirtual 242	java/io/InputStream:close	()V
    //   382: aload 4
    //   384: ifnull +8 -> 392
    //   387: aload 4
    //   389: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   392: aload 6
    //   394: areturn
    //   395: aload 6
    //   397: checkcast 131	java/net/URL
    //   400: invokestatic 250	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   403: astore 4
    //   405: goto -301 -> 104
    //   408: aload_0
    //   409: getfield 125	cn/testin/analysis/ag:c	Ljava/lang/String;
    //   412: invokevirtual 195	java/lang/String:getBytes	()[B
    //   415: astore 5
    //   417: goto -157 -> 260
    //   420: aload 5
    //   422: invokestatic 252	cn/testin/analysis/am:b	(Ljava/io/InputStream;)[B
    //   425: astore 6
    //   427: goto -67 -> 360
    //   430: new 58	cn/testin/analysis/p
    //   433: dup
    //   434: aload 4
    //   436: invokevirtual 215	java/net/HttpURLConnection:getResponseCode	()I
    //   439: invokespecial 254	cn/testin/analysis/p:<init>	(I)V
    //   442: athrow
    //   443: astore 9
    //   445: aconst_null
    //   446: astore 7
    //   448: aconst_null
    //   449: astore 6
    //   451: aload 4
    //   453: astore 5
    //   455: aload 9
    //   457: astore 4
    //   459: aload_0
    //   460: aload 4
    //   462: iload_1
    //   463: invokespecial 256	cn/testin/analysis/ag:a	(Ljava/lang/Throwable;I)Z
    //   466: istore_3
    //   467: aload 7
    //   469: ifnull +8 -> 477
    //   472: aload 7
    //   474: invokevirtual 212	java/io/OutputStream:close	()V
    //   477: aload 6
    //   479: ifnull +8 -> 487
    //   482: aload 6
    //   484: invokevirtual 242	java/io/InputStream:close	()V
    //   487: aload 5
    //   489: ifnull +8 -> 497
    //   492: aload 5
    //   494: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   497: iload_1
    //   498: iconst_1
    //   499: iadd
    //   500: istore_1
    //   501: goto -457 -> 44
    //   504: astore 7
    //   506: aload 7
    //   508: invokestatic 117	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   511: goto -139 -> 372
    //   514: astore 5
    //   516: aload 5
    //   518: invokestatic 117	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   521: goto -139 -> 382
    //   524: astore 7
    //   526: aload 7
    //   528: invokestatic 117	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   531: goto -54 -> 477
    //   534: astore 6
    //   536: aload 6
    //   538: invokestatic 117	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   541: goto -54 -> 487
    //   544: astore 4
    //   546: aconst_null
    //   547: astore 7
    //   549: aconst_null
    //   550: astore 6
    //   552: aload 8
    //   554: astore 5
    //   556: aload 7
    //   558: ifnull +8 -> 566
    //   561: aload 7
    //   563: invokevirtual 212	java/io/OutputStream:close	()V
    //   566: aload 6
    //   568: ifnull +8 -> 576
    //   571: aload 6
    //   573: invokevirtual 242	java/io/InputStream:close	()V
    //   576: aload 5
    //   578: ifnull +8 -> 586
    //   581: aload 5
    //   583: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   586: aload 4
    //   588: athrow
    //   589: astore 7
    //   591: aload 7
    //   593: invokestatic 117	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   596: goto -30 -> 566
    //   599: astore 6
    //   601: aload 6
    //   603: invokestatic 117	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   606: goto -30 -> 576
    //   609: aload 4
    //   611: ifnull +6 -> 617
    //   614: aload 4
    //   616: athrow
    //   617: new 62	java/lang/Exception
    //   620: dup
    //   621: ldc 119
    //   623: invokespecial 257	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   626: athrow
    //   627: astore 8
    //   629: aconst_null
    //   630: astore 7
    //   632: aconst_null
    //   633: astore 6
    //   635: aload 4
    //   637: astore 5
    //   639: aload 8
    //   641: astore 4
    //   643: goto -87 -> 556
    //   646: astore 8
    //   648: aconst_null
    //   649: astore 6
    //   651: aload 4
    //   653: astore 5
    //   655: aload 8
    //   657: astore 4
    //   659: goto -103 -> 556
    //   662: astore 8
    //   664: aload 5
    //   666: astore 6
    //   668: aconst_null
    //   669: astore 7
    //   671: aload 4
    //   673: astore 5
    //   675: aload 8
    //   677: astore 4
    //   679: goto -123 -> 556
    //   682: astore 4
    //   684: goto -128 -> 556
    //   687: astore 4
    //   689: aconst_null
    //   690: astore 5
    //   692: aconst_null
    //   693: astore 7
    //   695: aconst_null
    //   696: astore 6
    //   698: goto -239 -> 459
    //   701: astore 6
    //   703: aconst_null
    //   704: astore 9
    //   706: aload 4
    //   708: astore 5
    //   710: aload 6
    //   712: astore 4
    //   714: aload 9
    //   716: astore 6
    //   718: goto -259 -> 459
    //   721: astore 7
    //   723: aload 5
    //   725: astore 6
    //   727: aconst_null
    //   728: astore 9
    //   730: aload 4
    //   732: astore 5
    //   734: aload 7
    //   736: astore 4
    //   738: aload 9
    //   740: astore 7
    //   742: goto -283 -> 459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	this	ag
    //   38	463	1	i	int
    //   282	40	2	j	int
    //   40	427	3	bool	boolean
    //   42	419	4	localObject1	Object
    //   544	92	4	localObject2	Object
    //   641	37	4	localObject3	Object
    //   682	1	4	localObject4	Object
    //   687	20	4	localException1	Exception
    //   712	25	4	localObject5	Object
    //   122	371	5	localObject6	Object
    //   514	3	5	localIOException1	IOException
    //   554	179	5	localObject7	Object
    //   87	396	6	localObject8	Object
    //   534	3	6	localIOException2	IOException
    //   550	22	6	localObject9	Object
    //   599	3	6	localIOException3	IOException
    //   633	64	6	localObject10	Object
    //   701	10	6	localException2	Exception
    //   716	10	6	localObject11	Object
    //   239	234	7	localOutputStream	java.io.OutputStream
    //   504	3	7	localIOException4	IOException
    //   524	3	7	localIOException5	IOException
    //   547	15	7	localObject12	Object
    //   589	3	7	localIOException6	IOException
    //   630	64	7	localObject13	Object
    //   721	14	7	localException3	Exception
    //   740	1	7	localObject14	Object
    //   1	552	8	localObject15	Object
    //   627	13	8	localObject16	Object
    //   646	10	8	localObject17	Object
    //   662	14	8	localObject18	Object
    //   443	13	9	localException4	Exception
    //   704	35	9	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   111	124	443	java/lang/Exception
    //   129	139	443	java/lang/Exception
    //   139	200	443	java/lang/Exception
    //   200	241	443	java/lang/Exception
    //   277	317	443	java/lang/Exception
    //   324	331	443	java/lang/Exception
    //   430	443	443	java/lang/Exception
    //   364	372	504	java/io/IOException
    //   377	382	514	java/io/IOException
    //   472	477	524	java/io/IOException
    //   482	487	534	java/io/IOException
    //   76	104	544	finally
    //   104	111	544	finally
    //   395	405	544	finally
    //   561	566	589	java/io/IOException
    //   571	576	599	java/io/IOException
    //   111	124	627	finally
    //   129	139	627	finally
    //   139	200	627	finally
    //   200	241	627	finally
    //   277	317	627	finally
    //   324	331	627	finally
    //   430	443	627	finally
    //   241	260	646	finally
    //   260	277	646	finally
    //   408	417	646	finally
    //   331	338	662	finally
    //   343	360	662	finally
    //   420	427	662	finally
    //   459	467	682	finally
    //   76	104	687	java/lang/Exception
    //   104	111	687	java/lang/Exception
    //   395	405	687	java/lang/Exception
    //   241	260	701	java/lang/Exception
    //   260	277	701	java/lang/Exception
    //   408	417	701	java/lang/Exception
    //   331	338	721	java/lang/Exception
    //   343	360	721	java/lang/Exception
    //   420	427	721	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */