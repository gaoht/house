package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.lang.reflect.Method;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;

public class an
  extends y
{
  private static final String a = "uuid";
  private static final String e = "yosuid";
  private static final String f = "23346339";
  private Context b = null;
  private String c = null;
  private String d = null;
  
  public an(Context paramContext)
  {
    super("uuid");
    this.b = paramContext;
    this.c = null;
    this.d = null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_0
    //   13: ldc 66
    //   15: ldc 68
    //   17: invokestatic 70	com/umeng/analytics/pro/an:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: putfield 31	com/umeng/analytics/pro/an:d	Ljava/lang/String;
    //   23: aload_0
    //   24: getfield 31	com/umeng/analytics/pro/an:d	Ljava/lang/String;
    //   27: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifne +8 -> 38
    //   33: aload_0
    //   34: getfield 31	com/umeng/analytics/pro/an:d	Ljava/lang/String;
    //   37: areturn
    //   38: aload_0
    //   39: ldc 78
    //   41: ldc 68
    //   43: invokestatic 70	com/umeng/analytics/pro/an:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: putfield 29	com/umeng/analytics/pro/an:c	Ljava/lang/String;
    //   49: aload_0
    //   50: getfield 29	com/umeng/analytics/pro/an:c	Ljava/lang/String;
    //   53: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +14 -> 70
    //   59: aload_0
    //   60: ldc 80
    //   62: ldc 68
    //   64: invokestatic 70	com/umeng/analytics/pro/an:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: putfield 29	com/umeng/analytics/pro/an:c	Ljava/lang/String;
    //   70: aload_0
    //   71: getfield 29	com/umeng/analytics/pro/an:c	Ljava/lang/String;
    //   74: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +250 -> 327
    //   80: new 82	java/net/URL
    //   83: dup
    //   84: ldc 84
    //   86: invokespecial 85	java/net/URL:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 89	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   92: checkcast 91	javax/net/ssl/HttpsURLConnection
    //   95: astore_1
    //   96: aload_1
    //   97: sipush 30000
    //   100: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   103: aload_1
    //   104: sipush 30000
    //   107: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   110: aload_1
    //   111: ldc 100
    //   113: invokevirtual 103	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   116: aload_1
    //   117: iconst_1
    //   118: invokevirtual 107	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   121: aload_1
    //   122: iconst_1
    //   123: invokevirtual 110	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   126: aload_1
    //   127: iconst_0
    //   128: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   131: aload_1
    //   132: ldc 115
    //   134: ldc 117
    //   136: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_1
    //   140: new 6	com/umeng/analytics/pro/an$1
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 124	com/umeng/analytics/pro/an$1:<init>	(Lcom/umeng/analytics/pro/an;)V
    //   148: invokevirtual 128	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   151: new 130	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   158: ldc -122
    //   160: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc -116
    //   165: ldc -114
    //   167: invokestatic 147	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc -107
    //   175: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc -105
    //   180: ldc -114
    //   182: invokestatic 147	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_3
    //   192: new 157	java/io/DataOutputStream
    //   195: dup
    //   196: aload_1
    //   197: invokevirtual 161	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   200: invokespecial 164	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   203: astore 6
    //   205: aload 6
    //   207: aload_3
    //   208: invokevirtual 167	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   211: aload 6
    //   213: invokevirtual 170	java/io/DataOutputStream:flush	()V
    //   216: aload_1
    //   217: invokevirtual 174	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   220: istore_2
    //   221: iload_2
    //   222: sipush 200
    //   225: if_icmpne +478 -> 703
    //   228: aload_1
    //   229: invokevirtual 178	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   232: astore_3
    //   233: aload_3
    //   234: astore 4
    //   236: new 180	java/io/BufferedReader
    //   239: dup
    //   240: new 182	java/io/InputStreamReader
    //   243: dup
    //   244: aload 4
    //   246: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   249: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   252: astore_3
    //   253: new 190	java/lang/StringBuffer
    //   256: dup
    //   257: invokespecial 191	java/lang/StringBuffer:<init>	()V
    //   260: astore 5
    //   262: aload_3
    //   263: invokevirtual 194	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   266: astore 7
    //   268: aload 7
    //   270: ifnull +62 -> 332
    //   273: aload 5
    //   275: aload 7
    //   277: invokevirtual 197	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   280: pop
    //   281: goto -19 -> 262
    //   284: astore 5
    //   286: aload 5
    //   288: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   291: aload 6
    //   293: ifnull +8 -> 301
    //   296: aload 6
    //   298: invokevirtual 200	java/io/DataOutputStream:close	()V
    //   301: aload_3
    //   302: ifnull +7 -> 309
    //   305: aload_3
    //   306: invokevirtual 201	java/io/BufferedReader:close	()V
    //   309: aload 4
    //   311: ifnull +8 -> 319
    //   314: aload 4
    //   316: invokevirtual 204	java/io/InputStream:close	()V
    //   319: aload_1
    //   320: ifnull +7 -> 327
    //   323: aload_1
    //   324: invokevirtual 207	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   327: aload_0
    //   328: getfield 31	com/umeng/analytics/pro/an:d	Ljava/lang/String;
    //   331: areturn
    //   332: aload 5
    //   334: ifnull +12 -> 346
    //   337: aload_0
    //   338: aload 5
    //   340: invokevirtual 208	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   343: putfield 31	com/umeng/analytics/pro/an:d	Ljava/lang/String;
    //   346: goto -55 -> 291
    //   349: astore 5
    //   351: aload 5
    //   353: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   356: goto -55 -> 301
    //   359: astore_3
    //   360: aload_3
    //   361: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   364: goto -55 -> 309
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   372: goto -53 -> 319
    //   375: astore 5
    //   377: aconst_null
    //   378: astore_3
    //   379: aconst_null
    //   380: astore_1
    //   381: aconst_null
    //   382: astore 4
    //   384: aload 7
    //   386: astore 6
    //   388: aload 5
    //   390: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   393: aload_3
    //   394: ifnull +7 -> 401
    //   397: aload_3
    //   398: invokevirtual 200	java/io/DataOutputStream:close	()V
    //   401: aload 6
    //   403: ifnull +8 -> 411
    //   406: aload 6
    //   408: invokevirtual 201	java/io/BufferedReader:close	()V
    //   411: aload_1
    //   412: ifnull +7 -> 419
    //   415: aload_1
    //   416: invokevirtual 204	java/io/InputStream:close	()V
    //   419: aload 4
    //   421: ifnull -94 -> 327
    //   424: aload 4
    //   426: invokevirtual 207	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   429: goto -102 -> 327
    //   432: astore_3
    //   433: aload_3
    //   434: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   437: goto -36 -> 401
    //   440: astore_3
    //   441: aload_3
    //   442: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   445: goto -34 -> 411
    //   448: astore_1
    //   449: aload_1
    //   450: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   453: goto -34 -> 419
    //   456: astore_1
    //   457: aconst_null
    //   458: astore 6
    //   460: aconst_null
    //   461: astore 4
    //   463: aconst_null
    //   464: astore_3
    //   465: aload 6
    //   467: ifnull +8 -> 475
    //   470: aload 6
    //   472: invokevirtual 200	java/io/DataOutputStream:close	()V
    //   475: aload 5
    //   477: ifnull +8 -> 485
    //   480: aload 5
    //   482: invokevirtual 201	java/io/BufferedReader:close	()V
    //   485: aload 4
    //   487: ifnull +8 -> 495
    //   490: aload 4
    //   492: invokevirtual 204	java/io/InputStream:close	()V
    //   495: aload_3
    //   496: ifnull +7 -> 503
    //   499: aload_3
    //   500: invokevirtual 207	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   503: aload_1
    //   504: athrow
    //   505: astore 6
    //   507: aload 6
    //   509: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   512: goto -37 -> 475
    //   515: astore 5
    //   517: aload 5
    //   519: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   522: goto -37 -> 485
    //   525: astore 4
    //   527: aload 4
    //   529: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   532: goto -37 -> 495
    //   535: astore 7
    //   537: aconst_null
    //   538: astore 6
    //   540: aconst_null
    //   541: astore 4
    //   543: aload_1
    //   544: astore_3
    //   545: aload 7
    //   547: astore_1
    //   548: goto -83 -> 465
    //   551: astore 7
    //   553: aconst_null
    //   554: astore 4
    //   556: aload_1
    //   557: astore_3
    //   558: aload 7
    //   560: astore_1
    //   561: goto -96 -> 465
    //   564: astore 7
    //   566: aload_1
    //   567: astore_3
    //   568: aload 7
    //   570: astore_1
    //   571: goto -106 -> 465
    //   574: astore 7
    //   576: aload_3
    //   577: astore 5
    //   579: aload_1
    //   580: astore_3
    //   581: aload 7
    //   583: astore_1
    //   584: goto -119 -> 465
    //   587: astore 7
    //   589: aload_3
    //   590: astore 5
    //   592: aload_1
    //   593: astore_3
    //   594: aload 7
    //   596: astore_1
    //   597: goto -132 -> 465
    //   600: astore 5
    //   602: aload_3
    //   603: astore 7
    //   605: aload 4
    //   607: astore_3
    //   608: aload_1
    //   609: astore 4
    //   611: aload 5
    //   613: astore_1
    //   614: aload 6
    //   616: astore 5
    //   618: aload 7
    //   620: astore 6
    //   622: goto -157 -> 465
    //   625: astore 5
    //   627: aconst_null
    //   628: astore 6
    //   630: aload_1
    //   631: astore 4
    //   633: aconst_null
    //   634: astore_3
    //   635: aload 6
    //   637: astore_1
    //   638: aload 7
    //   640: astore 6
    //   642: goto -254 -> 388
    //   645: astore 5
    //   647: aconst_null
    //   648: astore 8
    //   650: aload_1
    //   651: astore 4
    //   653: aload 6
    //   655: astore_3
    //   656: aload 8
    //   658: astore_1
    //   659: aload 7
    //   661: astore 6
    //   663: goto -275 -> 388
    //   666: astore 5
    //   668: aload_1
    //   669: astore 7
    //   671: aload 6
    //   673: astore_1
    //   674: aload_3
    //   675: astore 6
    //   677: aload_1
    //   678: astore_3
    //   679: aload 4
    //   681: astore_1
    //   682: aload 7
    //   684: astore 4
    //   686: goto -298 -> 388
    //   689: astore 5
    //   691: aconst_null
    //   692: astore_3
    //   693: goto -407 -> 286
    //   696: astore 5
    //   698: aconst_null
    //   699: astore_3
    //   700: goto -414 -> 286
    //   703: aconst_null
    //   704: astore_3
    //   705: aload 8
    //   707: astore 4
    //   709: goto -418 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	this	an
    //   0	712	1	paramString	String
    //   220	6	2	i	int
    //   191	115	3	localObject1	Object
    //   359	2	3	localException1	Exception
    //   367	2	3	localException2	Exception
    //   378	20	3	localObject2	Object
    //   432	2	3	localException3	Exception
    //   440	2	3	localException4	Exception
    //   464	241	3	localObject3	Object
    //   10	481	4	localObject4	Object
    //   525	3	4	localException5	Exception
    //   541	167	4	localObject5	Object
    //   7	267	5	localStringBuffer	StringBuffer
    //   284	55	5	localException6	Exception
    //   349	3	5	localException7	Exception
    //   375	106	5	localException8	Exception
    //   515	3	5	localException9	Exception
    //   577	14	5	localObject6	Object
    //   600	12	5	localObject7	Object
    //   616	1	5	localObject8	Object
    //   625	1	5	localException10	Exception
    //   645	1	5	localException11	Exception
    //   666	1	5	localException12	Exception
    //   689	1	5	localException13	Exception
    //   696	1	5	localException14	Exception
    //   203	268	6	localObject9	Object
    //   505	3	6	localException15	Exception
    //   538	138	6	localObject10	Object
    //   4	381	7	str	String
    //   535	11	7	localObject11	Object
    //   551	8	7	localObject12	Object
    //   564	5	7	localObject13	Object
    //   574	8	7	localObject14	Object
    //   587	8	7	localObject15	Object
    //   603	80	7	localObject16	Object
    //   1	705	8	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   253	262	284	java/lang/Exception
    //   262	268	284	java/lang/Exception
    //   273	281	284	java/lang/Exception
    //   337	346	284	java/lang/Exception
    //   296	301	349	java/lang/Exception
    //   305	309	359	java/lang/Exception
    //   314	319	367	java/lang/Exception
    //   80	96	375	java/lang/Exception
    //   397	401	432	java/lang/Exception
    //   406	411	440	java/lang/Exception
    //   415	419	448	java/lang/Exception
    //   80	96	456	finally
    //   470	475	505	java/lang/Exception
    //   480	485	515	java/lang/Exception
    //   490	495	525	java/lang/Exception
    //   96	205	535	finally
    //   205	221	551	finally
    //   228	233	551	finally
    //   236	253	564	finally
    //   253	262	574	finally
    //   262	268	574	finally
    //   273	281	574	finally
    //   337	346	574	finally
    //   286	291	587	finally
    //   388	393	600	finally
    //   96	205	625	java/lang/Exception
    //   205	221	645	java/lang/Exception
    //   286	291	666	java/lang/Exception
    //   228	233	689	java/lang/Exception
    //   236	253	696	java/lang/Exception
  }
  
  public String f()
  {
    try
    {
      if ((!TextUtils.isEmpty(a("ro.yunos.version", ""))) && (this.b != null))
      {
        SharedPreferences localSharedPreferences = ba.a(this.b);
        if (localSharedPreferences != null)
        {
          String str = localSharedPreferences.getString("yosuid", "");
          Object localObject = str;
          if (TextUtils.isEmpty(str))
          {
            this.d = b("23346339");
            if ((!TextUtils.isEmpty(this.d)) && (this.b != null) && (localSharedPreferences != null))
            {
              localObject = localSharedPreferences.edit();
              if (localObject != null) {
                ((SharedPreferences.Editor)localObject).putString("yosuid", this.d).commit();
              }
            }
            localObject = this.d;
          }
          return (String)localObject;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */