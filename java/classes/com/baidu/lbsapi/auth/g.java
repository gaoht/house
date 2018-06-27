package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

@Instrumented
public class g
{
  private Context a;
  private String b = null;
  private HashMap<String, String> c = null;
  private String d = null;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private String a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isAvailable())) {
        break label135;
      }
      paramContext = paramContext.getExtraInfo();
      if ((paramContext != null) && ((paramContext.trim().toLowerCase().equals("cmwap")) || (paramContext.trim().toLowerCase().equals("uniwap")) || (paramContext.trim().toLowerCase().equals("3gwap")) || (paramContext.trim().toLowerCase().equals("ctwap"))))
      {
        if (paramContext.trim().toLowerCase().equals("ctwap")) {
          return "ctwap";
        }
        return "cmwap";
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    return "wifi";
    label135:
    return null;
  }
  
  /* Error */
  private void a(HttpsURLConnection paramHttpsURLConnection)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 11
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 10
    //   11: new 86	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   18: ldc 89
    //   20: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 20	com/baidu/lbsapi/auth/g:b	Ljava/lang/String;
    //   27: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 101	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 22	com/baidu/lbsapi/auth/g:c	Ljava/util/HashMap;
    //   40: ifnonnull +13 -> 53
    //   43: aload_0
    //   44: ldc 103
    //   46: invokestatic 108	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   49: putfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   52: return
    //   53: iconst_1
    //   54: istore 4
    //   56: aload_1
    //   57: invokevirtual 114	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   60: astore 6
    //   62: aload 6
    //   64: astore 9
    //   66: new 116	java/io/BufferedWriter
    //   69: dup
    //   70: new 118	java/io/OutputStreamWriter
    //   73: dup
    //   74: aload 6
    //   76: ldc 120
    //   78: invokespecial 123	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   81: invokespecial 126	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   84: astore 7
    //   86: aload 6
    //   88: astore 9
    //   90: aload 7
    //   92: aload_0
    //   93: getfield 22	com/baidu/lbsapi/auth/g:c	Ljava/util/HashMap;
    //   96: invokestatic 129	com/baidu/lbsapi/auth/g:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   99: invokevirtual 132	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   102: aload 6
    //   104: astore 9
    //   106: aload_0
    //   107: getfield 22	com/baidu/lbsapi/auth/g:c	Ljava/util/HashMap;
    //   110: invokestatic 129	com/baidu/lbsapi/auth/g:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   113: invokestatic 101	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   116: aload 6
    //   118: astore 9
    //   120: aload 7
    //   122: invokevirtual 135	java/io/BufferedWriter:flush	()V
    //   125: aload 6
    //   127: astore 9
    //   129: aload 7
    //   131: invokevirtual 138	java/io/BufferedWriter:close	()V
    //   134: aload 6
    //   136: astore 9
    //   138: aload_1
    //   139: invokevirtual 141	javax/net/ssl/HttpsURLConnection:connect	()V
    //   142: aload_1
    //   143: invokevirtual 145	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   146: astore 8
    //   148: aload_1
    //   149: invokevirtual 149	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   152: istore_2
    //   153: sipush 200
    //   156: iload_2
    //   157: if_icmpne +771 -> 928
    //   160: new 151	java/io/BufferedReader
    //   163: dup
    //   164: new 153	java/io/InputStreamReader
    //   167: dup
    //   168: aload 8
    //   170: ldc 120
    //   172: invokespecial 156	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   175: invokespecial 159	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   178: astore 7
    //   180: new 161	java/lang/StringBuffer
    //   183: dup
    //   184: invokespecial 162	java/lang/StringBuffer:<init>	()V
    //   187: astore 9
    //   189: aload 7
    //   191: invokevirtual 165	java/io/BufferedReader:read	()I
    //   194: istore_3
    //   195: iload_3
    //   196: iconst_m1
    //   197: if_icmpeq +225 -> 422
    //   200: aload 9
    //   202: iload_3
    //   203: i2c
    //   204: invokevirtual 168	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   207: pop
    //   208: goto -19 -> 189
    //   211: astore 9
    //   213: aload 7
    //   215: astore 10
    //   217: aload 9
    //   219: astore 7
    //   221: new 86	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   228: ldc -86
    //   230: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 7
    //   235: invokevirtual 173	java/io/IOException:getMessage	()Ljava/lang/String;
    //   238: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 101	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   247: aload_0
    //   248: new 86	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   255: ldc -81
    //   257: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 7
    //   262: invokevirtual 173	java/io/IOException:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 108	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   274: putfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   277: aload 8
    //   279: ifnull +36 -> 315
    //   282: aload 10
    //   284: ifnull +31 -> 315
    //   287: iload_2
    //   288: istore_3
    //   289: aload 6
    //   291: astore 9
    //   293: iload_2
    //   294: istore 4
    //   296: aload 10
    //   298: invokevirtual 176	java/io/BufferedReader:close	()V
    //   301: iload_2
    //   302: istore_3
    //   303: aload 6
    //   305: astore 9
    //   307: iload_2
    //   308: istore 4
    //   310: aload 8
    //   312: invokevirtual 179	java/io/InputStream:close	()V
    //   315: aload_1
    //   316: ifnull +599 -> 915
    //   319: iload_2
    //   320: istore_3
    //   321: aload 6
    //   323: astore 9
    //   325: iload_2
    //   326: istore 4
    //   328: aload_1
    //   329: invokevirtual 182	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   332: iconst_0
    //   333: istore 4
    //   335: iload_2
    //   336: istore_3
    //   337: iload 4
    //   339: istore_2
    //   340: iload_3
    //   341: istore 5
    //   343: aload 6
    //   345: ifnull +14 -> 359
    //   348: aload 6
    //   350: invokevirtual 185	java/io/OutputStream:close	()V
    //   353: iload_3
    //   354: istore 5
    //   356: iload 4
    //   358: istore_2
    //   359: iload_2
    //   360: ifeq +376 -> 736
    //   363: sipush 200
    //   366: iload 5
    //   368: if_icmpeq +368 -> 736
    //   371: new 86	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   378: ldc -69
    //   380: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 5
    //   385: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 101	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   394: aload_0
    //   395: new 86	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   402: ldc -69
    //   404: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: iload 5
    //   409: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 108	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   418: putfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   421: return
    //   422: aload_0
    //   423: aload 9
    //   425: invokevirtual 191	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   428: putfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   431: aload 8
    //   433: ifnull +26 -> 459
    //   436: aload 7
    //   438: ifnull +21 -> 459
    //   441: aload 6
    //   443: astore 9
    //   445: aload 7
    //   447: invokevirtual 176	java/io/BufferedReader:close	()V
    //   450: aload 6
    //   452: astore 9
    //   454: aload 8
    //   456: invokevirtual 179	java/io/InputStream:close	()V
    //   459: aload_1
    //   460: ifnull +463 -> 923
    //   463: aload 6
    //   465: astore 9
    //   467: aload_1
    //   468: invokevirtual 182	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   471: iload_2
    //   472: istore_3
    //   473: goto -136 -> 337
    //   476: astore 7
    //   478: aconst_null
    //   479: astore 8
    //   481: iconst_m1
    //   482: istore_2
    //   483: aload 11
    //   485: astore 10
    //   487: aload 8
    //   489: ifnull +36 -> 525
    //   492: aload 10
    //   494: ifnull +31 -> 525
    //   497: iload_2
    //   498: istore_3
    //   499: aload 6
    //   501: astore 9
    //   503: iload_2
    //   504: istore 4
    //   506: aload 10
    //   508: invokevirtual 176	java/io/BufferedReader:close	()V
    //   511: iload_2
    //   512: istore_3
    //   513: aload 6
    //   515: astore 9
    //   517: iload_2
    //   518: istore 4
    //   520: aload 8
    //   522: invokevirtual 179	java/io/InputStream:close	()V
    //   525: aload_1
    //   526: ifnull +16 -> 542
    //   529: iload_2
    //   530: istore_3
    //   531: aload 6
    //   533: astore 9
    //   535: iload_2
    //   536: istore 4
    //   538: aload_1
    //   539: invokevirtual 182	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   542: iload_2
    //   543: istore_3
    //   544: aload 6
    //   546: astore 9
    //   548: iload_2
    //   549: istore 4
    //   551: aload 7
    //   553: athrow
    //   554: astore 7
    //   556: aload 6
    //   558: astore_1
    //   559: aload 7
    //   561: astore 6
    //   563: aload_0
    //   564: new 86	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   571: ldc -81
    //   573: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 6
    //   578: invokevirtual 192	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   581: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 108	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   590: putfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   593: iload_3
    //   594: istore 5
    //   596: aload_1
    //   597: ifnull +313 -> 910
    //   600: aload_1
    //   601: invokevirtual 185	java/io/OutputStream:close	()V
    //   604: iconst_0
    //   605: istore_2
    //   606: iload_3
    //   607: istore 5
    //   609: goto -250 -> 359
    //   612: astore_1
    //   613: aload_1
    //   614: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   617: iload 4
    //   619: istore_2
    //   620: iload_3
    //   621: istore 5
    //   623: goto -264 -> 359
    //   626: astore_1
    //   627: aload_1
    //   628: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   631: iconst_0
    //   632: istore_2
    //   633: iload_3
    //   634: istore 5
    //   636: goto -277 -> 359
    //   639: astore_1
    //   640: aconst_null
    //   641: astore 6
    //   643: aload 6
    //   645: astore 9
    //   647: aload_0
    //   648: new 86	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   655: ldc -81
    //   657: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_1
    //   661: invokevirtual 173	java/io/IOException:getMessage	()Ljava/lang/String;
    //   664: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 108	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   673: putfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   676: iload_3
    //   677: istore 5
    //   679: aload 6
    //   681: ifnull +229 -> 910
    //   684: aload 6
    //   686: invokevirtual 185	java/io/OutputStream:close	()V
    //   689: iconst_0
    //   690: istore_2
    //   691: iload_3
    //   692: istore 5
    //   694: goto -335 -> 359
    //   697: astore_1
    //   698: aload_1
    //   699: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   702: iconst_0
    //   703: istore_2
    //   704: iload_3
    //   705: istore 5
    //   707: goto -348 -> 359
    //   710: astore_1
    //   711: aconst_null
    //   712: astore 9
    //   714: aload 9
    //   716: ifnull +8 -> 724
    //   719: aload 9
    //   721: invokevirtual 185	java/io/OutputStream:close	()V
    //   724: aload_1
    //   725: athrow
    //   726: astore 6
    //   728: aload 6
    //   730: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   733: goto -9 -> 724
    //   736: aload_0
    //   737: getfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   740: ifnonnull +18 -> 758
    //   743: ldc -61
    //   745: invokestatic 101	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   748: aload_0
    //   749: ldc -59
    //   751: invokestatic 108	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   754: putfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   757: return
    //   758: new 86	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   765: ldc -57
    //   767: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_0
    //   771: getfield 24	com/baidu/lbsapi/auth/g:d	Ljava/lang/String;
    //   774: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 101	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   783: return
    //   784: astore_1
    //   785: goto -71 -> 714
    //   788: astore 6
    //   790: aload_1
    //   791: astore 9
    //   793: aload 6
    //   795: astore_1
    //   796: goto -82 -> 714
    //   799: astore_1
    //   800: goto -157 -> 643
    //   803: astore_1
    //   804: iload_2
    //   805: istore_3
    //   806: goto -163 -> 643
    //   809: astore_1
    //   810: iload 4
    //   812: istore_3
    //   813: goto -170 -> 643
    //   816: astore 6
    //   818: aload 7
    //   820: astore_1
    //   821: goto -258 -> 563
    //   824: astore 7
    //   826: aload 6
    //   828: astore_1
    //   829: aload 7
    //   831: astore 6
    //   833: goto -270 -> 563
    //   836: astore 7
    //   838: aload 6
    //   840: astore_1
    //   841: aload 7
    //   843: astore 6
    //   845: iload_2
    //   846: istore_3
    //   847: goto -284 -> 563
    //   850: astore 7
    //   852: iconst_m1
    //   853: istore_2
    //   854: aload 11
    //   856: astore 10
    //   858: goto -371 -> 487
    //   861: astore 7
    //   863: aload 11
    //   865: astore 10
    //   867: goto -380 -> 487
    //   870: astore 9
    //   872: aload 7
    //   874: astore 10
    //   876: aload 9
    //   878: astore 7
    //   880: goto -393 -> 487
    //   883: astore 7
    //   885: goto -398 -> 487
    //   888: astore 7
    //   890: aconst_null
    //   891: astore 8
    //   893: iconst_m1
    //   894: istore_2
    //   895: goto -674 -> 221
    //   898: astore 7
    //   900: iconst_m1
    //   901: istore_2
    //   902: goto -681 -> 221
    //   905: astore 7
    //   907: goto -686 -> 221
    //   910: iconst_0
    //   911: istore_2
    //   912: goto -553 -> 359
    //   915: iconst_0
    //   916: istore 4
    //   918: iload_2
    //   919: istore_3
    //   920: goto -583 -> 337
    //   923: iload_2
    //   924: istore_3
    //   925: goto -588 -> 337
    //   928: aconst_null
    //   929: astore 7
    //   931: goto -500 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	934	0	this	g
    //   0	934	1	paramHttpsURLConnection	HttpsURLConnection
    //   152	772	2	i	int
    //   1	924	3	j	int
    //   54	863	4	k	int
    //   341	365	5	m	int
    //   60	625	6	localObject1	Object
    //   726	3	6	localIOException1	java.io.IOException
    //   788	6	6	localObject2	Object
    //   816	11	6	localMalformedURLException1	MalformedURLException
    //   831	13	6	localMalformedURLException2	MalformedURLException
    //   6	440	7	localObject3	Object
    //   476	76	7	localObject4	Object
    //   554	265	7	localMalformedURLException3	MalformedURLException
    //   824	6	7	localMalformedURLException4	MalformedURLException
    //   836	6	7	localMalformedURLException5	MalformedURLException
    //   850	1	7	localObject5	Object
    //   861	12	7	localObject6	Object
    //   878	1	7	localObject7	Object
    //   883	1	7	localObject8	Object
    //   888	1	7	localIOException2	java.io.IOException
    //   898	1	7	localIOException3	java.io.IOException
    //   905	1	7	localIOException4	java.io.IOException
    //   929	1	7	localObject9	Object
    //   146	746	8	localInputStream	java.io.InputStream
    //   64	137	9	localObject10	Object
    //   211	7	9	localIOException5	java.io.IOException
    //   291	501	9	localObject11	Object
    //   870	7	9	localObject12	Object
    //   9	866	10	localObject13	Object
    //   3	861	11	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   180	189	211	java/io/IOException
    //   189	195	211	java/io/IOException
    //   200	208	211	java/io/IOException
    //   422	431	211	java/io/IOException
    //   142	148	476	finally
    //   296	301	554	java/net/MalformedURLException
    //   310	315	554	java/net/MalformedURLException
    //   328	332	554	java/net/MalformedURLException
    //   506	511	554	java/net/MalformedURLException
    //   520	525	554	java/net/MalformedURLException
    //   538	542	554	java/net/MalformedURLException
    //   551	554	554	java/net/MalformedURLException
    //   348	353	612	java/io/IOException
    //   600	604	626	java/io/IOException
    //   56	62	639	java/io/IOException
    //   684	689	697	java/io/IOException
    //   56	62	710	finally
    //   719	724	726	java/io/IOException
    //   66	86	784	finally
    //   90	102	784	finally
    //   106	116	784	finally
    //   120	125	784	finally
    //   129	134	784	finally
    //   138	142	784	finally
    //   296	301	784	finally
    //   310	315	784	finally
    //   328	332	784	finally
    //   445	450	784	finally
    //   454	459	784	finally
    //   467	471	784	finally
    //   506	511	784	finally
    //   520	525	784	finally
    //   538	542	784	finally
    //   551	554	784	finally
    //   647	676	784	finally
    //   563	593	788	finally
    //   66	86	799	java/io/IOException
    //   90	102	799	java/io/IOException
    //   106	116	799	java/io/IOException
    //   120	125	799	java/io/IOException
    //   129	134	799	java/io/IOException
    //   138	142	799	java/io/IOException
    //   445	450	803	java/io/IOException
    //   454	459	803	java/io/IOException
    //   467	471	803	java/io/IOException
    //   296	301	809	java/io/IOException
    //   310	315	809	java/io/IOException
    //   328	332	809	java/io/IOException
    //   506	511	809	java/io/IOException
    //   520	525	809	java/io/IOException
    //   538	542	809	java/io/IOException
    //   551	554	809	java/io/IOException
    //   56	62	816	java/net/MalformedURLException
    //   66	86	824	java/net/MalformedURLException
    //   90	102	824	java/net/MalformedURLException
    //   106	116	824	java/net/MalformedURLException
    //   120	125	824	java/net/MalformedURLException
    //   129	134	824	java/net/MalformedURLException
    //   138	142	824	java/net/MalformedURLException
    //   445	450	836	java/net/MalformedURLException
    //   454	459	836	java/net/MalformedURLException
    //   467	471	836	java/net/MalformedURLException
    //   148	153	850	finally
    //   160	180	861	finally
    //   180	189	870	finally
    //   189	195	870	finally
    //   200	208	870	finally
    //   422	431	870	finally
    //   221	277	883	finally
    //   142	148	888	java/io/IOException
    //   148	153	898	java/io/IOException
    //   160	180	905	java/io/IOException
  }
  
  private static String b(HashMap<String, String> paramHashMap)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 1;
    if (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), "UTF-8"));
        localStringBuilder.append("=");
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  private HttpsURLConnection b()
  {
    try
    {
      localObject1 = new URL(this.b);
      str = a(this.a);
      if ((str == null) || (str.equals("")))
      {
        a.b("Current network is not available.");
        this.d = ErrorMessage.a("Current network is not available.");
        return null;
      }
      a.a("checkNetwork = " + str);
      if (!str.equals("cmwap")) {
        break label165;
      }
      localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject1;
        String str;
        a.a(localMalformedURLException.getMessage());
        this.d = ErrorMessage.a("Auth server could not be parsed as a URL.");
        return null;
        if (!str.equals("ctwap")) {
          break;
        }
        localObject2 = (HttpsURLConnection)localMalformedURLException.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
      }
      if ((localObject2 instanceof URL)) {
        break label227;
      }
      for (Object localObject2 = ((URL)localObject2).openConnection();; localObject2 = HttpInstrumentation.openConnection((URL)localObject2))
      {
        localObject2 = (HttpsURLConnection)localObject2;
        break;
      }
    }
    catch (Exception localException)
    {
      label165:
      label227:
      a.a(localException.getMessage());
      this.d = ErrorMessage.a("Init httpsurlconnection failed.");
    }
    ((HttpsURLConnection)localObject1).setDoInput(true);
    ((HttpsURLConnection)localObject1).setDoOutput(true);
    ((HttpsURLConnection)localObject1).setRequestMethod("POST");
    ((HttpsURLConnection)localObject1).setConnectTimeout(50000);
    ((HttpsURLConnection)localObject1).setReadTimeout(50000);
    return (HttpsURLConnection)localObject1;
    return null;
  }
  
  private HashMap<String, String> c(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((String)localIterator.next()).toString();
      localHashMap.put(str, paramHashMap.get(str));
    }
    return localHashMap;
  }
  
  protected String a(HashMap<String, String> paramHashMap)
  {
    this.c = c(paramHashMap);
    this.b = ((String)this.c.get("url"));
    paramHashMap = b();
    if (paramHashMap == null)
    {
      a.b("syncConnect failed,httpsURLConnection is null");
      return this.d;
    }
    a(paramHashMap);
    return this.d;
  }
  
  protected boolean a()
  {
    a.a("checkNetwork start");
    try
    {
      Object localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isAvailable();
        if (bool) {}
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    a.a("checkNetwork end");
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */