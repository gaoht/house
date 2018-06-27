package com.baidu.lbsapi.auth.tracesdk;

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
  private HashMap c = null;
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
        break label141;
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
      if (a.a) {
        paramContext.printStackTrace();
      }
      return null;
    }
    return "wifi";
    label141:
    return null;
  }
  
  /* Error */
  private void a(HttpsURLConnection paramHttpsURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: new 90	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 92
    //   15: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 19	com/baidu/lbsapi/auth/tracesdk/g:b	Ljava/lang/String;
    //   22: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 104	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 21	com/baidu/lbsapi/auth/tracesdk/g:c	Ljava/util/HashMap;
    //   35: ifnonnull +13 -> 48
    //   38: aload_0
    //   39: ldc 106
    //   41: invokestatic 111	com/baidu/lbsapi/auth/tracesdk/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   44: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   47: return
    //   48: iconst_1
    //   49: istore 4
    //   51: aload_1
    //   52: invokevirtual 117	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   55: astore 6
    //   57: aload 6
    //   59: astore 8
    //   61: new 119	java/io/BufferedWriter
    //   64: dup
    //   65: new 121	java/io/OutputStreamWriter
    //   68: dup
    //   69: aload 6
    //   71: ldc 123
    //   73: invokespecial 126	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   76: invokespecial 129	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   79: astore 7
    //   81: aload 6
    //   83: astore 8
    //   85: aload 7
    //   87: aload_0
    //   88: getfield 21	com/baidu/lbsapi/auth/tracesdk/g:c	Ljava/util/HashMap;
    //   91: invokestatic 132	com/baidu/lbsapi/auth/tracesdk/g:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   94: invokevirtual 135	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   97: aload 6
    //   99: astore 8
    //   101: aload_0
    //   102: getfield 21	com/baidu/lbsapi/auth/tracesdk/g:c	Ljava/util/HashMap;
    //   105: invokestatic 132	com/baidu/lbsapi/auth/tracesdk/g:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   108: invokestatic 104	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   111: aload 6
    //   113: astore 8
    //   115: aload 7
    //   117: invokevirtual 138	java/io/BufferedWriter:flush	()V
    //   120: aload 6
    //   122: astore 8
    //   124: aload 7
    //   126: invokevirtual 141	java/io/BufferedWriter:close	()V
    //   129: aload 6
    //   131: astore 8
    //   133: aload_1
    //   134: invokevirtual 144	javax/net/ssl/HttpsURLConnection:connect	()V
    //   137: aload_1
    //   138: invokevirtual 148	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   141: astore 9
    //   143: aload_1
    //   144: invokevirtual 152	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   147: istore_2
    //   148: sipush 200
    //   151: iload_2
    //   152: if_icmpne +959 -> 1111
    //   155: new 154	java/io/BufferedReader
    //   158: dup
    //   159: new 156	java/io/InputStreamReader
    //   162: dup
    //   163: aload 9
    //   165: ldc 123
    //   167: invokespecial 159	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   170: invokespecial 162	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   173: astore 7
    //   175: new 164	java/lang/StringBuffer
    //   178: dup
    //   179: invokespecial 165	java/lang/StringBuffer:<init>	()V
    //   182: astore 8
    //   184: aload 7
    //   186: invokevirtual 168	java/io/BufferedReader:read	()I
    //   189: istore_3
    //   190: iload_3
    //   191: iconst_m1
    //   192: if_icmpeq +235 -> 427
    //   195: aload 8
    //   197: iload_3
    //   198: i2c
    //   199: invokevirtual 171	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   202: pop
    //   203: goto -19 -> 184
    //   206: astore 8
    //   208: aload 7
    //   210: astore 10
    //   212: aload 8
    //   214: astore 7
    //   216: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   219: ifeq +31 -> 250
    //   222: aload 7
    //   224: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   227: new 90	java/lang/StringBuilder
    //   230: dup
    //   231: ldc -82
    //   233: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 7
    //   238: invokevirtual 177	java/io/IOException:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 104	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: bipush -11
    //   253: new 90	java/lang/StringBuilder
    //   256: dup
    //   257: ldc -77
    //   259: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: aload 7
    //   264: invokevirtual 177	java/io/IOException:getMessage	()Ljava/lang/String;
    //   267: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 182	com/baidu/lbsapi/auth/tracesdk/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   276: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   279: aload 9
    //   281: ifnull +42 -> 323
    //   284: aload 10
    //   286: ifnull +37 -> 323
    //   289: iload_2
    //   290: istore_3
    //   291: aload 6
    //   293: astore 8
    //   295: iload_2
    //   296: istore 4
    //   298: iload_2
    //   299: istore 5
    //   301: aload 10
    //   303: invokevirtual 183	java/io/BufferedReader:close	()V
    //   306: iload_2
    //   307: istore_3
    //   308: aload 6
    //   310: astore 8
    //   312: iload_2
    //   313: istore 4
    //   315: iload_2
    //   316: istore 5
    //   318: aload 9
    //   320: invokevirtual 186	java/io/InputStream:close	()V
    //   323: aload_1
    //   324: ifnull +772 -> 1096
    //   327: iload_2
    //   328: istore_3
    //   329: aload 6
    //   331: astore 8
    //   333: iload_2
    //   334: istore 4
    //   336: iload_2
    //   337: istore 5
    //   339: aload_1
    //   340: invokevirtual 189	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   343: iconst_0
    //   344: istore 4
    //   346: iload_2
    //   347: istore 5
    //   349: iload 4
    //   351: istore_2
    //   352: iload 5
    //   354: istore_3
    //   355: aload 6
    //   357: ifnull +14 -> 371
    //   360: aload 6
    //   362: invokevirtual 192	java/io/OutputStream:close	()V
    //   365: iload 5
    //   367: istore_3
    //   368: iload 4
    //   370: istore_2
    //   371: iload_2
    //   372: ifeq +519 -> 891
    //   375: sipush 200
    //   378: iload_3
    //   379: if_icmpeq +512 -> 891
    //   382: new 90	java/lang/StringBuilder
    //   385: dup
    //   386: ldc -62
    //   388: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: iload_3
    //   392: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 104	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   401: aload_0
    //   402: bipush -11
    //   404: new 90	java/lang/StringBuilder
    //   407: dup
    //   408: ldc -62
    //   410: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   413: iload_3
    //   414: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 182	com/baidu/lbsapi/auth/tracesdk/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   423: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   426: return
    //   427: aload_0
    //   428: aload 8
    //   430: invokevirtual 198	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   433: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   436: aload 9
    //   438: ifnull +26 -> 464
    //   441: aload 7
    //   443: ifnull +21 -> 464
    //   446: aload 6
    //   448: astore 8
    //   450: aload 7
    //   452: invokevirtual 183	java/io/BufferedReader:close	()V
    //   455: aload 6
    //   457: astore 8
    //   459: aload 9
    //   461: invokevirtual 186	java/io/InputStream:close	()V
    //   464: aload_1
    //   465: ifnull +640 -> 1105
    //   468: aload 6
    //   470: astore 8
    //   472: aload_1
    //   473: invokevirtual 189	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   476: iload_2
    //   477: istore 5
    //   479: goto -130 -> 349
    //   482: astore 7
    //   484: aconst_null
    //   485: astore 9
    //   487: iconst_m1
    //   488: istore_2
    //   489: aload 11
    //   491: astore 10
    //   493: aload 9
    //   495: ifnull +42 -> 537
    //   498: aload 10
    //   500: ifnull +37 -> 537
    //   503: iload_2
    //   504: istore_3
    //   505: aload 6
    //   507: astore 8
    //   509: iload_2
    //   510: istore 4
    //   512: iload_2
    //   513: istore 5
    //   515: aload 10
    //   517: invokevirtual 183	java/io/BufferedReader:close	()V
    //   520: iload_2
    //   521: istore_3
    //   522: aload 6
    //   524: astore 8
    //   526: iload_2
    //   527: istore 4
    //   529: iload_2
    //   530: istore 5
    //   532: aload 9
    //   534: invokevirtual 186	java/io/InputStream:close	()V
    //   537: aload_1
    //   538: ifnull +19 -> 557
    //   541: iload_2
    //   542: istore_3
    //   543: aload 6
    //   545: astore 8
    //   547: iload_2
    //   548: istore 4
    //   550: iload_2
    //   551: istore 5
    //   553: aload_1
    //   554: invokevirtual 189	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   557: iload_2
    //   558: istore_3
    //   559: aload 6
    //   561: astore 8
    //   563: iload_2
    //   564: istore 4
    //   566: iload_2
    //   567: istore 5
    //   569: aload 7
    //   571: athrow
    //   572: astore 7
    //   574: aload 6
    //   576: astore_1
    //   577: aload 7
    //   579: astore 6
    //   581: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   584: ifeq +8 -> 592
    //   587: aload 6
    //   589: invokevirtual 199	java/net/MalformedURLException:printStackTrace	()V
    //   592: aload_0
    //   593: bipush -11
    //   595: new 90	java/lang/StringBuilder
    //   598: dup
    //   599: ldc -55
    //   601: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   604: aload 6
    //   606: invokevirtual 202	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   609: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 182	com/baidu/lbsapi/auth/tracesdk/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   618: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   621: iload_3
    //   622: istore 4
    //   624: aload_1
    //   625: ifnull +463 -> 1088
    //   628: aload_1
    //   629: invokevirtual 192	java/io/OutputStream:close	()V
    //   632: iconst_0
    //   633: istore_2
    //   634: goto -263 -> 371
    //   637: astore_1
    //   638: iload 4
    //   640: istore_2
    //   641: iload 5
    //   643: istore_3
    //   644: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   647: ifeq -276 -> 371
    //   650: aload_1
    //   651: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   654: iload 4
    //   656: istore_2
    //   657: iload 5
    //   659: istore_3
    //   660: goto -289 -> 371
    //   663: astore_1
    //   664: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   667: ifeq +7 -> 674
    //   670: aload_1
    //   671: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   674: iconst_0
    //   675: istore_2
    //   676: goto -305 -> 371
    //   679: astore_1
    //   680: iconst_m1
    //   681: istore_3
    //   682: aconst_null
    //   683: astore 6
    //   685: aload 6
    //   687: astore 8
    //   689: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   692: ifeq +11 -> 703
    //   695: aload 6
    //   697: astore 8
    //   699: aload_1
    //   700: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   703: aload 6
    //   705: astore 8
    //   707: aload_0
    //   708: bipush -11
    //   710: new 90	java/lang/StringBuilder
    //   713: dup
    //   714: ldc -77
    //   716: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   719: aload_1
    //   720: invokevirtual 177	java/io/IOException:getMessage	()Ljava/lang/String;
    //   723: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 182	com/baidu/lbsapi/auth/tracesdk/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   732: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   735: iload_3
    //   736: istore 4
    //   738: aload 6
    //   740: ifnull +348 -> 1088
    //   743: aload 6
    //   745: invokevirtual 192	java/io/OutputStream:close	()V
    //   748: iconst_0
    //   749: istore_2
    //   750: goto -379 -> 371
    //   753: astore_1
    //   754: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   757: ifeq +7 -> 764
    //   760: aload_1
    //   761: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   764: iconst_0
    //   765: istore_2
    //   766: goto -395 -> 371
    //   769: astore_1
    //   770: iconst_m1
    //   771: istore_3
    //   772: aconst_null
    //   773: astore 6
    //   775: aload 6
    //   777: astore 8
    //   779: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   782: ifeq +11 -> 793
    //   785: aload 6
    //   787: astore 8
    //   789: aload_1
    //   790: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   793: aload 6
    //   795: astore 8
    //   797: aload_0
    //   798: bipush -11
    //   800: new 90	java/lang/StringBuilder
    //   803: dup
    //   804: ldc -52
    //   806: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   809: aload_1
    //   810: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 182	com/baidu/lbsapi/auth/tracesdk/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   822: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   825: iload_3
    //   826: istore 4
    //   828: aload 6
    //   830: ifnull +258 -> 1088
    //   833: aload 6
    //   835: invokevirtual 192	java/io/OutputStream:close	()V
    //   838: iconst_0
    //   839: istore_2
    //   840: goto -469 -> 371
    //   843: astore_1
    //   844: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   847: ifeq +7 -> 854
    //   850: aload_1
    //   851: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   854: iconst_0
    //   855: istore_2
    //   856: goto -485 -> 371
    //   859: astore_1
    //   860: aconst_null
    //   861: astore 8
    //   863: aload 8
    //   865: ifnull +8 -> 873
    //   868: aload 8
    //   870: invokevirtual 192	java/io/OutputStream:close	()V
    //   873: aload_1
    //   874: athrow
    //   875: astore 6
    //   877: getstatic 78	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   880: ifeq -7 -> 873
    //   883: aload 6
    //   885: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   888: goto -15 -> 873
    //   891: aload_0
    //   892: getfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   895: ifnonnull +19 -> 914
    //   898: ldc -49
    //   900: invokestatic 104	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   903: aload_0
    //   904: iconst_m1
    //   905: ldc -47
    //   907: invokestatic 182	com/baidu/lbsapi/auth/tracesdk/ErrorMessage:a	(ILjava/lang/String;)Ljava/lang/String;
    //   910: putfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   913: return
    //   914: new 90	java/lang/StringBuilder
    //   917: dup
    //   918: ldc -45
    //   920: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   923: aload_0
    //   924: getfield 23	com/baidu/lbsapi/auth/tracesdk/g:d	Ljava/lang/String;
    //   927: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokestatic 104	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   936: return
    //   937: astore_1
    //   938: goto -75 -> 863
    //   941: astore 6
    //   943: aload_1
    //   944: astore 8
    //   946: aload 6
    //   948: astore_1
    //   949: goto -86 -> 863
    //   952: astore_1
    //   953: iconst_m1
    //   954: istore_3
    //   955: goto -180 -> 775
    //   958: astore_1
    //   959: iload_2
    //   960: istore_3
    //   961: goto -186 -> 775
    //   964: astore_1
    //   965: iload 4
    //   967: istore_3
    //   968: goto -193 -> 775
    //   971: astore_1
    //   972: iconst_m1
    //   973: istore_3
    //   974: goto -289 -> 685
    //   977: astore_1
    //   978: iload_2
    //   979: istore_3
    //   980: goto -295 -> 685
    //   983: astore_1
    //   984: iload 5
    //   986: istore_3
    //   987: goto -302 -> 685
    //   990: astore 6
    //   992: iconst_m1
    //   993: istore_3
    //   994: aload 7
    //   996: astore_1
    //   997: goto -416 -> 581
    //   1000: astore 7
    //   1002: iconst_m1
    //   1003: istore_3
    //   1004: aload 6
    //   1006: astore_1
    //   1007: aload 7
    //   1009: astore 6
    //   1011: goto -430 -> 581
    //   1014: astore 7
    //   1016: aload 6
    //   1018: astore_1
    //   1019: aload 7
    //   1021: astore 6
    //   1023: iload_2
    //   1024: istore_3
    //   1025: goto -444 -> 581
    //   1028: astore 7
    //   1030: iconst_m1
    //   1031: istore_2
    //   1032: aload 11
    //   1034: astore 10
    //   1036: goto -543 -> 493
    //   1039: astore 7
    //   1041: aload 11
    //   1043: astore 10
    //   1045: goto -552 -> 493
    //   1048: astore 8
    //   1050: aload 7
    //   1052: astore 10
    //   1054: aload 8
    //   1056: astore 7
    //   1058: goto -565 -> 493
    //   1061: astore 7
    //   1063: goto -570 -> 493
    //   1066: astore 7
    //   1068: aconst_null
    //   1069: astore 9
    //   1071: iconst_m1
    //   1072: istore_2
    //   1073: goto -857 -> 216
    //   1076: astore 7
    //   1078: iconst_m1
    //   1079: istore_2
    //   1080: goto -864 -> 216
    //   1083: astore 7
    //   1085: goto -869 -> 216
    //   1088: iconst_0
    //   1089: istore_2
    //   1090: iload 4
    //   1092: istore_3
    //   1093: goto -722 -> 371
    //   1096: iconst_0
    //   1097: istore 4
    //   1099: iload_2
    //   1100: istore 5
    //   1102: goto -753 -> 349
    //   1105: iload_2
    //   1106: istore 5
    //   1108: goto -759 -> 349
    //   1111: aconst_null
    //   1112: astore 7
    //   1114: goto -678 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1117	0	this	g
    //   0	1117	1	paramHttpsURLConnection	HttpsURLConnection
    //   147	959	2	i	int
    //   189	904	3	j	int
    //   49	1049	4	k	int
    //   299	808	5	m	int
    //   55	779	6	localObject1	Object
    //   875	9	6	localIOException1	java.io.IOException
    //   941	6	6	localObject2	Object
    //   990	15	6	localMalformedURLException1	MalformedURLException
    //   1009	13	6	localMalformedURLException2	MalformedURLException
    //   4	447	7	localObject3	Object
    //   482	88	7	localObject4	Object
    //   572	423	7	localMalformedURLException3	MalformedURLException
    //   1000	8	7	localMalformedURLException4	MalformedURLException
    //   1014	6	7	localMalformedURLException5	MalformedURLException
    //   1028	1	7	localObject5	Object
    //   1039	12	7	localObject6	Object
    //   1056	1	7	localObject7	Object
    //   1061	1	7	localObject8	Object
    //   1066	1	7	localIOException2	java.io.IOException
    //   1076	1	7	localIOException3	java.io.IOException
    //   1083	1	7	localIOException4	java.io.IOException
    //   1112	1	7	localObject9	Object
    //   59	137	8	localObject10	Object
    //   206	7	8	localIOException5	java.io.IOException
    //   293	652	8	localObject11	Object
    //   1048	7	8	localObject12	Object
    //   141	929	9	localInputStream	java.io.InputStream
    //   7	1046	10	localObject13	Object
    //   1	1041	11	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   175	184	206	java/io/IOException
    //   184	190	206	java/io/IOException
    //   195	203	206	java/io/IOException
    //   427	436	206	java/io/IOException
    //   137	143	482	finally
    //   301	306	572	java/net/MalformedURLException
    //   318	323	572	java/net/MalformedURLException
    //   339	343	572	java/net/MalformedURLException
    //   515	520	572	java/net/MalformedURLException
    //   532	537	572	java/net/MalformedURLException
    //   553	557	572	java/net/MalformedURLException
    //   569	572	572	java/net/MalformedURLException
    //   360	365	637	java/io/IOException
    //   628	632	663	java/io/IOException
    //   51	57	679	java/io/IOException
    //   743	748	753	java/io/IOException
    //   51	57	769	java/lang/Exception
    //   833	838	843	java/io/IOException
    //   51	57	859	finally
    //   868	873	875	java/io/IOException
    //   61	81	937	finally
    //   85	97	937	finally
    //   101	111	937	finally
    //   115	120	937	finally
    //   124	129	937	finally
    //   133	137	937	finally
    //   301	306	937	finally
    //   318	323	937	finally
    //   339	343	937	finally
    //   450	455	937	finally
    //   459	464	937	finally
    //   472	476	937	finally
    //   515	520	937	finally
    //   532	537	937	finally
    //   553	557	937	finally
    //   569	572	937	finally
    //   689	695	937	finally
    //   699	703	937	finally
    //   707	735	937	finally
    //   779	785	937	finally
    //   789	793	937	finally
    //   797	825	937	finally
    //   581	592	941	finally
    //   592	621	941	finally
    //   61	81	952	java/lang/Exception
    //   85	97	952	java/lang/Exception
    //   101	111	952	java/lang/Exception
    //   115	120	952	java/lang/Exception
    //   124	129	952	java/lang/Exception
    //   133	137	952	java/lang/Exception
    //   450	455	958	java/lang/Exception
    //   459	464	958	java/lang/Exception
    //   472	476	958	java/lang/Exception
    //   301	306	964	java/lang/Exception
    //   318	323	964	java/lang/Exception
    //   339	343	964	java/lang/Exception
    //   515	520	964	java/lang/Exception
    //   532	537	964	java/lang/Exception
    //   553	557	964	java/lang/Exception
    //   569	572	964	java/lang/Exception
    //   61	81	971	java/io/IOException
    //   85	97	971	java/io/IOException
    //   101	111	971	java/io/IOException
    //   115	120	971	java/io/IOException
    //   124	129	971	java/io/IOException
    //   133	137	971	java/io/IOException
    //   450	455	977	java/io/IOException
    //   459	464	977	java/io/IOException
    //   472	476	977	java/io/IOException
    //   301	306	983	java/io/IOException
    //   318	323	983	java/io/IOException
    //   339	343	983	java/io/IOException
    //   515	520	983	java/io/IOException
    //   532	537	983	java/io/IOException
    //   553	557	983	java/io/IOException
    //   569	572	983	java/io/IOException
    //   51	57	990	java/net/MalformedURLException
    //   61	81	1000	java/net/MalformedURLException
    //   85	97	1000	java/net/MalformedURLException
    //   101	111	1000	java/net/MalformedURLException
    //   115	120	1000	java/net/MalformedURLException
    //   124	129	1000	java/net/MalformedURLException
    //   133	137	1000	java/net/MalformedURLException
    //   450	455	1014	java/net/MalformedURLException
    //   459	464	1014	java/net/MalformedURLException
    //   472	476	1014	java/net/MalformedURLException
    //   143	148	1028	finally
    //   155	175	1039	finally
    //   175	184	1048	finally
    //   184	190	1048	finally
    //   195	203	1048	finally
    //   427	436	1048	finally
    //   216	250	1061	finally
    //   250	279	1061	finally
    //   137	143	1066	java/io/IOException
    //   143	148	1076	java/io/IOException
    //   155	175	1083	java/io/IOException
  }
  
  private static String b(HashMap paramHashMap)
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
      a.a("https URL: " + this.b);
      str = a(this.a);
      if ((str == null) || (str.equals("")))
      {
        a.c("Current network is not available.");
        this.d = ErrorMessage.a(-10, "Current network is not available.");
        return null;
      }
      a.a("checkNetwork = " + str);
      if (!str.equals("cmwap")) {
        break label202;
      }
      localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject1;
        String str;
        if (a.a)
        {
          localMalformedURLException.printStackTrace();
          a.a(localMalformedURLException.getMessage());
        }
        this.d = ErrorMessage.a(-11, "Auth server could not be parsed as a URL.");
        return null;
        if (!str.equals("ctwap")) {
          break;
        }
        localObject2 = (HttpsURLConnection)localMalformedURLException.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
      }
      if ((localObject2 instanceof URL)) {
        break label264;
      }
      for (Object localObject2 = ((URL)localObject2).openConnection();; localObject2 = HttpInstrumentation.openConnection((URL)localObject2))
      {
        localObject2 = (HttpsURLConnection)localObject2;
        break;
      }
    }
    catch (Exception localException)
    {
      label202:
      label264:
      if (!a.a) {
        break label293;
      }
      localException.printStackTrace();
      a.a(localException.getMessage());
      label293:
      this.d = ErrorMessage.a(-11, "Init httpsurlconnection failed.");
    }
    ((HttpsURLConnection)localObject1).setDoInput(true);
    ((HttpsURLConnection)localObject1).setDoOutput(true);
    ((HttpsURLConnection)localObject1).setRequestMethod("POST");
    ((HttpsURLConnection)localObject1).setConnectTimeout(50000);
    ((HttpsURLConnection)localObject1).setReadTimeout(50000);
    return (HttpsURLConnection)localObject1;
    return null;
  }
  
  private HashMap c(HashMap paramHashMap)
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
  
  protected String a(HashMap paramHashMap)
  {
    this.c = c(paramHashMap);
    this.b = ((String)this.c.get("url"));
    paramHashMap = b();
    if (paramHashMap == null)
    {
      a.c("syncConnect failed,httpsURLConnection is null");
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
      if (a.a) {
        localException.printStackTrace();
      }
      return false;
    }
    a.a("checkNetwork end");
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/tracesdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */