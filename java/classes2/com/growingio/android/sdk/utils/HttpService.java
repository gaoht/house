package com.growingio.android.sdk.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.maa.android.agent.instrumentation.Instrumented;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

@Instrumented
public class HttpService
{
  public static SSLSocketFactory a;
  private String b;
  private String c;
  private Map<String, String> d;
  private byte[] e;
  private long f;
  private long g;
  private Map<String, List<String>> h;
  
  private HttpService(String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte, long paramLong)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    this.f = paramLong;
  }
  
  /* Error */
  private Pair<Integer, byte[]> a(DNSService.HostInformation paramHostInformation)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: iconst_0
    //   7: istore_3
    //   8: new 53	android/util/Pair
    //   11: dup
    //   12: iconst_0
    //   13: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: iconst_0
    //   17: newarray <illegal type>
    //   19: invokespecial 62	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   22: astore 7
    //   24: aload_0
    //   25: getfield 34	com/growingio/android/sdk/utils/HttpService:c	Ljava/lang/String;
    //   28: ldc 64
    //   30: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: istore 5
    //   35: new 72	java/net/URL
    //   38: dup
    //   39: aload_0
    //   40: getfield 32	com/growingio/android/sdk/utils/HttpService:b	Ljava/lang/String;
    //   43: invokespecial 75	java/net/URL:<init>	(Ljava/lang/String;)V
    //   46: astore 8
    //   48: aload 8
    //   50: astore 6
    //   52: aload_1
    //   53: astore 12
    //   55: aload_1
    //   56: ifnonnull +57 -> 113
    //   59: invokestatic 80	com/growingio/android/sdk/utils/DNSService:a	()Lcom/growingio/android/sdk/utils/DNSService;
    //   62: aload 8
    //   64: invokevirtual 84	java/net/URL:getHost	()Ljava/lang/String;
    //   67: iconst_1
    //   68: invokevirtual 87	com/growingio/android/sdk/utils/DNSService:a	(Ljava/lang/String;Z)Lcom/growingio/android/sdk/utils/DNSService$HostInformation;
    //   71: astore 9
    //   73: aload 8
    //   75: astore 6
    //   77: aload 9
    //   79: astore 12
    //   81: aload 9
    //   83: astore_1
    //   84: aload_0
    //   85: aload 9
    //   87: invokespecial 90	com/growingio/android/sdk/utils/HttpService:b	(Lcom/growingio/android/sdk/utils/DNSService$HostInformation;)Z
    //   90: ifeq +23 -> 113
    //   93: aload 9
    //   95: astore_1
    //   96: new 72	java/net/URL
    //   99: dup
    //   100: aload_0
    //   101: getfield 32	com/growingio/android/sdk/utils/HttpService:b	Ljava/lang/String;
    //   104: invokespecial 75	java/net/URL:<init>	(Ljava/lang/String;)V
    //   107: astore 6
    //   109: aload 9
    //   111: astore 12
    //   113: aload 6
    //   115: instanceof 72
    //   118: ifne +246 -> 364
    //   121: aload 6
    //   123: invokevirtual 94	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   126: astore_1
    //   127: aload_1
    //   128: checkcast 96	java/net/HttpURLConnection
    //   131: astore_1
    //   132: aload_1
    //   133: sipush 10000
    //   136: invokevirtual 100	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   139: aload_1
    //   140: ldc 101
    //   142: invokevirtual 104	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   145: aload_0
    //   146: getfield 40	com/growingio/android/sdk/utils/HttpService:f	J
    //   149: lconst_0
    //   150: lcmp
    //   151: ifle +11 -> 162
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 40	com/growingio/android/sdk/utils/HttpService:f	J
    //   159: invokevirtual 108	java/net/HttpURLConnection:setIfModifiedSince	(J)V
    //   162: aload_1
    //   163: instanceof 110
    //   166: ifeq +19 -> 185
    //   169: getstatic 112	com/growingio/android/sdk/utils/HttpService:a	Ljavax/net/ssl/SSLSocketFactory;
    //   172: ifnull +13 -> 185
    //   175: aload_0
    //   176: aload_1
    //   177: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   180: aload 12
    //   182: invokespecial 115	com/growingio/android/sdk/utils/HttpService:a	(Ljavax/net/ssl/HttpsURLConnection;Lcom/growingio/android/sdk/utils/DNSService$HostInformation;)V
    //   185: aload_0
    //   186: getfield 36	com/growingio/android/sdk/utils/HttpService:d	Ljava/util/Map;
    //   189: invokeinterface 121 1 0
    //   194: invokeinterface 127 1 0
    //   199: astore 9
    //   201: aload 9
    //   203: invokeinterface 133 1 0
    //   208: ifeq +168 -> 376
    //   211: aload 9
    //   213: invokeinterface 137 1 0
    //   218: checkcast 66	java/lang/String
    //   221: astore 8
    //   223: aload_1
    //   224: aload 8
    //   226: aload_0
    //   227: getfield 36	com/growingio/android/sdk/utils/HttpService:d	Ljava/util/Map;
    //   230: aload 8
    //   232: invokeinterface 141 2 0
    //   237: checkcast 66	java/lang/String
    //   240: invokevirtual 145	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -42 -> 201
    //   246: astore 13
    //   248: aload_1
    //   249: astore 10
    //   251: aconst_null
    //   252: astore 8
    //   254: aconst_null
    //   255: astore 9
    //   257: aload 6
    //   259: astore 11
    //   261: aload 7
    //   263: astore 6
    //   265: aload 12
    //   267: astore_1
    //   268: aload 10
    //   270: astore 7
    //   272: aload 13
    //   274: astore 10
    //   276: aload 11
    //   278: ifnull +460 -> 738
    //   281: aload_1
    //   282: ifnonnull +456 -> 738
    //   285: aload 10
    //   287: instanceof 147
    //   290: ifeq +448 -> 738
    //   293: invokestatic 80	com/growingio/android/sdk/utils/DNSService:a	()Lcom/growingio/android/sdk/utils/DNSService;
    //   296: aload 11
    //   298: invokevirtual 84	java/net/URL:getHost	()Ljava/lang/String;
    //   301: iconst_0
    //   302: invokevirtual 87	com/growingio/android/sdk/utils/DNSService:a	(Ljava/lang/String;Z)Lcom/growingio/android/sdk/utils/DNSService$HostInformation;
    //   305: astore_1
    //   306: aload_0
    //   307: aload_1
    //   308: invokespecial 90	com/growingio/android/sdk/utils/HttpService:b	(Lcom/growingio/android/sdk/utils/DNSService$HostInformation;)Z
    //   311: ifeq +446 -> 757
    //   314: ldc -107
    //   316: invokestatic 153	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   319: aload_0
    //   320: aload_1
    //   321: invokespecial 155	com/growingio/android/sdk/utils/HttpService:a	(Lcom/growingio/android/sdk/utils/DNSService$HostInformation;)Landroid/util/Pair;
    //   324: astore_1
    //   325: aload 7
    //   327: ifnull +8 -> 335
    //   330: aload 7
    //   332: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   335: aload 9
    //   337: ifnull +8 -> 345
    //   340: aload 9
    //   342: invokevirtual 163	java/io/OutputStream:close	()V
    //   345: aload_1
    //   346: astore 7
    //   348: aload 8
    //   350: ifnull +11 -> 361
    //   353: aload 8
    //   355: invokevirtual 166	java/io/InputStream:close	()V
    //   358: aload_1
    //   359: astore 7
    //   361: aload 7
    //   363: areturn
    //   364: aload 6
    //   366: checkcast 72	java/net/URL
    //   369: invokestatic 171	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   372: astore_1
    //   373: goto -246 -> 127
    //   376: aload_0
    //   377: getfield 34	com/growingio/android/sdk/utils/HttpService:c	Ljava/lang/String;
    //   380: ldc -83
    //   382: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   385: ifne +317 -> 702
    //   388: aload_1
    //   389: aload_0
    //   390: getfield 34	com/growingio/android/sdk/utils/HttpService:c	Ljava/lang/String;
    //   393: invokevirtual 176	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   396: aload_1
    //   397: iconst_1
    //   398: invokevirtual 180	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   401: aload_1
    //   402: invokevirtual 184	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   405: astore 9
    //   407: aload_0
    //   408: getfield 38	com/growingio/android/sdk/utils/HttpService:e	[B
    //   411: ifnull +12 -> 423
    //   414: aload 9
    //   416: aload_0
    //   417: getfield 38	com/growingio/android/sdk/utils/HttpService:e	[B
    //   420: invokevirtual 188	java/io/OutputStream:write	([B)V
    //   423: aload 9
    //   425: invokevirtual 191	java/io/OutputStream:flush	()V
    //   428: aload 9
    //   430: invokevirtual 163	java/io/OutputStream:close	()V
    //   433: aload_1
    //   434: invokevirtual 195	java/net/HttpURLConnection:getResponseCode	()I
    //   437: istore 4
    //   439: iload 4
    //   441: sipush 400
    //   444: if_icmplt +688 -> 1132
    //   447: iconst_1
    //   448: istore_2
    //   449: aload_0
    //   450: aload_1
    //   451: invokevirtual 199	java/net/HttpURLConnection:getLastModified	()J
    //   454: putfield 201	com/growingio/android/sdk/utils/HttpService:g	J
    //   457: aload_0
    //   458: aload_1
    //   459: invokevirtual 205	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   462: putfield 207	com/growingio/android/sdk/utils/HttpService:h	Ljava/util/Map;
    //   465: iload_2
    //   466: ifeq +248 -> 714
    //   469: aload_1
    //   470: invokevirtual 211	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   473: astore 8
    //   475: ldc -43
    //   477: aload_1
    //   478: ldc -41
    //   480: invokevirtual 219	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   483: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   486: ifeq +643 -> 1129
    //   489: new 225	java/util/zip/GZIPInputStream
    //   492: dup
    //   493: aload_1
    //   494: invokevirtual 228	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   497: invokespecial 231	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   500: astore 9
    //   502: aload 9
    //   504: astore 8
    //   506: new 53	android/util/Pair
    //   509: dup
    //   510: iload 4
    //   512: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: aload 8
    //   517: invokestatic 234	com/growingio/android/sdk/utils/HttpService:a	(Ljava/io/InputStream;)[B
    //   520: invokespecial 62	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   523: astore 9
    //   525: aload 8
    //   527: invokevirtual 166	java/io/InputStream:close	()V
    //   530: aload 9
    //   532: getfield 238	android/util/Pair:first	Ljava/lang/Object;
    //   535: checkcast 55	java/lang/Integer
    //   538: invokevirtual 241	java/lang/Integer:intValue	()I
    //   541: istore_2
    //   542: iload_2
    //   543: sipush 200
    //   546: if_icmpne +177 -> 723
    //   549: iconst_1
    //   550: istore_2
    //   551: aload_1
    //   552: ifnull +7 -> 559
    //   555: aload_1
    //   556: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   559: iconst_0
    //   560: ifeq +11 -> 571
    //   563: new 243	java/lang/NullPointerException
    //   566: dup
    //   567: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   570: athrow
    //   571: aload 8
    //   573: ifnull +547 -> 1120
    //   576: aload 8
    //   578: invokevirtual 166	java/io/InputStream:close	()V
    //   581: aload 9
    //   583: astore 6
    //   585: aconst_null
    //   586: astore_1
    //   587: getstatic 250	com/growingio/android/sdk/collection/GConfig:DEBUG	Z
    //   590: ifeq +70 -> 660
    //   593: ldc -4
    //   595: new 254	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 257
    //   605: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 6
    //   610: getfield 238	android/util/Pair:first	Ljava/lang/Object;
    //   613: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   616: ldc_w 266
    //   619: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload_0
    //   623: getfield 32	com/growingio/android/sdk/utils/HttpService:b	Ljava/lang/String;
    //   626: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc_w 268
    //   632: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: new 66	java/lang/String
    //   638: dup
    //   639: aload 6
    //   641: getfield 271	android/util/Pair:second	Ljava/lang/Object;
    //   644: checkcast 272	[B
    //   647: invokespecial 274	java/lang/String:<init>	([B)V
    //   650: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   659: pop
    //   660: aload 6
    //   662: astore 7
    //   664: iload 5
    //   666: ifeq -305 -> 361
    //   669: aload 6
    //   671: astore 7
    //   673: iload_2
    //   674: ifne -313 -> 361
    //   677: aload_1
    //   678: astore 7
    //   680: aload_1
    //   681: ifnonnull +13 -> 694
    //   684: aload 6
    //   686: getfield 238	android/util/Pair:first	Ljava/lang/Object;
    //   689: invokestatic 286	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   692: astore 7
    //   694: aload 7
    //   696: invokestatic 153	com/growingio/android/sdk/collection/DiagnoseLog:a	(Ljava/lang/String;)V
    //   699: aload 6
    //   701: areturn
    //   702: aload_1
    //   703: ldc_w 288
    //   706: ldc -43
    //   708: invokevirtual 145	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: goto -278 -> 433
    //   714: aload_1
    //   715: invokevirtual 228	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   718: astore 8
    //   720: goto -245 -> 475
    //   723: iconst_0
    //   724: istore_2
    //   725: goto -174 -> 551
    //   728: astore_1
    //   729: aload 9
    //   731: astore 6
    //   733: aconst_null
    //   734: astore_1
    //   735: goto -148 -> 587
    //   738: aload_1
    //   739: ifnull +18 -> 757
    //   742: aload 10
    //   744: instanceof 290
    //   747: ifeq +10 -> 757
    //   750: invokestatic 80	com/growingio/android/sdk/utils/DNSService:a	()Lcom/growingio/android/sdk/utils/DNSService;
    //   753: aload_1
    //   754: invokevirtual 293	com/growingio/android/sdk/utils/DNSService:b	(Lcom/growingio/android/sdk/utils/DNSService$HostInformation;)V
    //   757: aload_0
    //   758: aload 10
    //   760: invokespecial 296	com/growingio/android/sdk/utils/HttpService:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   763: astore_1
    //   764: aload 7
    //   766: ifnull +8 -> 774
    //   769: aload 7
    //   771: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   774: aload 9
    //   776: ifnull +8 -> 784
    //   779: aload 9
    //   781: invokevirtual 163	java/io/OutputStream:close	()V
    //   784: aload 8
    //   786: ifnull +329 -> 1115
    //   789: aload 8
    //   791: invokevirtual 166	java/io/InputStream:close	()V
    //   794: iload_3
    //   795: istore_2
    //   796: goto -209 -> 587
    //   799: astore 7
    //   801: iload_3
    //   802: istore_2
    //   803: goto -216 -> 587
    //   806: astore_1
    //   807: aconst_null
    //   808: astore 8
    //   810: aconst_null
    //   811: astore 9
    //   813: aload 10
    //   815: astore 6
    //   817: aload 6
    //   819: ifnull +8 -> 827
    //   822: aload 6
    //   824: invokevirtual 158	java/net/HttpURLConnection:disconnect	()V
    //   827: aload 9
    //   829: ifnull +8 -> 837
    //   832: aload 9
    //   834: invokevirtual 163	java/io/OutputStream:close	()V
    //   837: aload 8
    //   839: ifnull +8 -> 847
    //   842: aload 8
    //   844: invokevirtual 166	java/io/InputStream:close	()V
    //   847: aload_1
    //   848: athrow
    //   849: astore_1
    //   850: goto -279 -> 571
    //   853: astore 6
    //   855: goto -510 -> 345
    //   858: astore 6
    //   860: aload_1
    //   861: areturn
    //   862: astore 7
    //   864: goto -80 -> 784
    //   867: astore 6
    //   869: goto -32 -> 837
    //   872: astore 6
    //   874: goto -27 -> 847
    //   877: astore 7
    //   879: aconst_null
    //   880: astore 8
    //   882: aconst_null
    //   883: astore 9
    //   885: aload_1
    //   886: astore 6
    //   888: aload 7
    //   890: astore_1
    //   891: goto -74 -> 817
    //   894: astore 7
    //   896: aconst_null
    //   897: astore 8
    //   899: aload_1
    //   900: astore 6
    //   902: aload 7
    //   904: astore_1
    //   905: goto -88 -> 817
    //   908: astore 7
    //   910: aconst_null
    //   911: astore 9
    //   913: aload_1
    //   914: astore 6
    //   916: aload 7
    //   918: astore_1
    //   919: goto -102 -> 817
    //   922: astore 7
    //   924: aconst_null
    //   925: astore 9
    //   927: aload_1
    //   928: astore 6
    //   930: aload 7
    //   932: astore_1
    //   933: goto -116 -> 817
    //   936: astore_1
    //   937: aload 7
    //   939: astore 6
    //   941: goto -124 -> 817
    //   944: astore 10
    //   946: aconst_null
    //   947: astore 12
    //   949: aconst_null
    //   950: astore 8
    //   952: aconst_null
    //   953: astore 9
    //   955: aload 7
    //   957: astore 6
    //   959: aload 12
    //   961: astore 7
    //   963: goto -687 -> 276
    //   966: astore 10
    //   968: aconst_null
    //   969: astore 13
    //   971: aconst_null
    //   972: astore 12
    //   974: aconst_null
    //   975: astore 9
    //   977: aload 8
    //   979: astore 11
    //   981: aload 7
    //   983: astore 6
    //   985: aload 13
    //   987: astore 7
    //   989: aload 12
    //   991: astore 8
    //   993: goto -717 -> 276
    //   996: astore 10
    //   998: aconst_null
    //   999: astore_1
    //   1000: aconst_null
    //   1001: astore 8
    //   1003: aconst_null
    //   1004: astore 9
    //   1006: aload 6
    //   1008: astore 11
    //   1010: aload 7
    //   1012: astore 6
    //   1014: aload_1
    //   1015: astore 7
    //   1017: aload 12
    //   1019: astore_1
    //   1020: goto -744 -> 276
    //   1023: astore 10
    //   1025: aconst_null
    //   1026: astore 8
    //   1028: aload 6
    //   1030: astore 11
    //   1032: aload 7
    //   1034: astore 6
    //   1036: aload_1
    //   1037: astore 7
    //   1039: aload 12
    //   1041: astore_1
    //   1042: goto -766 -> 276
    //   1045: astore 10
    //   1047: aconst_null
    //   1048: astore 9
    //   1050: aload 6
    //   1052: astore 11
    //   1054: aload 7
    //   1056: astore 6
    //   1058: aload_1
    //   1059: astore 7
    //   1061: aload 12
    //   1063: astore_1
    //   1064: goto -788 -> 276
    //   1067: astore 10
    //   1069: aconst_null
    //   1070: astore 9
    //   1072: aload 6
    //   1074: astore 11
    //   1076: aload 7
    //   1078: astore 6
    //   1080: aload_1
    //   1081: astore 7
    //   1083: aload 12
    //   1085: astore_1
    //   1086: goto -810 -> 276
    //   1089: astore 10
    //   1091: aconst_null
    //   1092: astore 13
    //   1094: aload 6
    //   1096: astore 11
    //   1098: aload 9
    //   1100: astore 6
    //   1102: aload_1
    //   1103: astore 7
    //   1105: aload 13
    //   1107: astore 9
    //   1109: aload 12
    //   1111: astore_1
    //   1112: goto -836 -> 276
    //   1115: iload_3
    //   1116: istore_2
    //   1117: goto -530 -> 587
    //   1120: aload 9
    //   1122: astore 6
    //   1124: aconst_null
    //   1125: astore_1
    //   1126: goto -539 -> 587
    //   1129: goto -623 -> 506
    //   1132: iconst_0
    //   1133: istore_2
    //   1134: goto -685 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	this	HttpService
    //   0	1137	1	paramHostInformation	DNSService.HostInformation
    //   448	686	2	i	int
    //   7	1109	3	j	int
    //   437	74	4	k	int
    //   33	632	5	bool	boolean
    //   50	773	6	localObject1	Object
    //   853	1	6	localIOException1	IOException
    //   858	1	6	localIOException2	IOException
    //   867	1	6	localIOException3	IOException
    //   872	1	6	localIOException4	IOException
    //   886	237	6	localObject2	Object
    //   22	748	7	localObject3	Object
    //   799	1	7	localIOException5	IOException
    //   862	1	7	localIOException6	IOException
    //   877	12	7	localObject4	Object
    //   894	9	7	localObject5	Object
    //   908	9	7	localObject6	Object
    //   922	34	7	localObject7	Object
    //   961	143	7	localObject8	Object
    //   46	981	8	localObject9	Object
    //   71	1050	9	localObject10	Object
    //   1	813	10	localObject11	Object
    //   944	1	10	localThrowable1	Throwable
    //   966	1	10	localThrowable2	Throwable
    //   996	1	10	localThrowable3	Throwable
    //   1023	1	10	localThrowable4	Throwable
    //   1045	1	10	localThrowable5	Throwable
    //   1067	1	10	localThrowable6	Throwable
    //   1089	1	10	localThrowable7	Throwable
    //   4	1093	11	localObject12	Object
    //   53	1057	12	localObject13	Object
    //   246	27	13	localThrowable8	Throwable
    //   969	137	13	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   132	162	246	java/lang/Throwable
    //   162	185	246	java/lang/Throwable
    //   185	201	246	java/lang/Throwable
    //   201	243	246	java/lang/Throwable
    //   376	407	246	java/lang/Throwable
    //   433	439	246	java/lang/Throwable
    //   449	465	246	java/lang/Throwable
    //   469	475	246	java/lang/Throwable
    //   702	711	246	java/lang/Throwable
    //   714	720	246	java/lang/Throwable
    //   576	581	728	java/io/IOException
    //   789	794	799	java/io/IOException
    //   35	48	806	finally
    //   59	73	806	finally
    //   84	93	806	finally
    //   96	109	806	finally
    //   113	127	806	finally
    //   127	132	806	finally
    //   364	373	806	finally
    //   563	571	849	java/io/IOException
    //   340	345	853	java/io/IOException
    //   353	358	858	java/io/IOException
    //   779	784	862	java/io/IOException
    //   832	837	867	java/io/IOException
    //   842	847	872	java/io/IOException
    //   132	162	877	finally
    //   162	185	877	finally
    //   185	201	877	finally
    //   201	243	877	finally
    //   376	407	877	finally
    //   433	439	877	finally
    //   449	465	877	finally
    //   469	475	877	finally
    //   702	711	877	finally
    //   714	720	877	finally
    //   407	423	894	finally
    //   423	433	894	finally
    //   475	502	908	finally
    //   506	525	922	finally
    //   525	542	922	finally
    //   285	325	936	finally
    //   742	757	936	finally
    //   757	764	936	finally
    //   35	48	944	java/lang/Throwable
    //   59	73	966	java/lang/Throwable
    //   84	93	966	java/lang/Throwable
    //   96	109	966	java/lang/Throwable
    //   113	127	996	java/lang/Throwable
    //   127	132	996	java/lang/Throwable
    //   364	373	996	java/lang/Throwable
    //   407	423	1023	java/lang/Throwable
    //   423	433	1023	java/lang/Throwable
    //   475	502	1045	java/lang/Throwable
    //   506	525	1067	java/lang/Throwable
    //   525	542	1089	java/lang/Throwable
  }
  
  private String a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof UnknownHostException)) {
      return "uh";
    }
    if ((paramThrowable instanceof SocketTimeoutException)) {
      return "timeout";
    }
    if ((paramThrowable instanceof SSLException)) {
      return "ssl";
    }
    if ((paramThrowable instanceof IOException)) {
      return "io";
    }
    if ((paramThrowable instanceof ArrayIndexOutOfBoundsException))
    {
      LogUtil.e("GrowingIO.HttpService", "performRequest: bad response");
      return "aioob";
    }
    LogUtil.e("GrowingIO.HttpService", "performRequest: unknown exception");
    paramThrowable.printStackTrace();
    return "other";
  }
  
  private void a(HttpsURLConnection paramHttpsURLConnection, final DNSService.HostInformation paramHostInformation)
  {
    paramHttpsURLConnection.setSSLSocketFactory(a);
    if (paramHostInformation != null)
    {
      final String str = paramHostInformation.c();
      paramHttpsURLConnection.setRequestProperty("Host", str);
      paramHttpsURLConnection.setHostnameVerifier(new HostnameVerifier()
      {
        public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
        {
          boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(str, paramAnonymousSSLSession);
          if (!bool) {
            DNSService.a().a(paramHostInformation);
          }
          return bool;
        }
      });
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[' '];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private boolean b(DNSService.HostInformation paramHostInformation)
  {
    if (paramHostInformation != null)
    {
      String str = paramHostInformation.b();
      if (!TextUtils.isEmpty(str))
      {
        this.b = this.b.replaceFirst(paramHostInformation.c(), str);
        return true;
      }
    }
    return false;
  }
  
  public Map<String, List<String>> a()
  {
    return this.h;
  }
  
  public Pair<Integer, byte[]> b()
  {
    return a(null);
  }
  
  public long c()
  {
    return this.g;
  }
  
  public static class Builder
  {
    private String a;
    private String b = "GET";
    private Map<String, String> c = new HashMap();
    private byte[] d = new byte[0];
    private long e = 0L;
    
    public Builder a(long paramLong)
    {
      this.e = paramLong;
      return this;
    }
    
    public Builder a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public Builder a(Map<String, String> paramMap)
    {
      this.c = paramMap;
      return this;
    }
    
    public Builder a(byte[] paramArrayOfByte)
    {
      this.d = paramArrayOfByte;
      return this;
    }
    
    public HttpService a()
    {
      return new HttpService(this.a, this.b, this.c, this.d, this.e, null);
    }
    
    public Builder b(String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/HttpService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */