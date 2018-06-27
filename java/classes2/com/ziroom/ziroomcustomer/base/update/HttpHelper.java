package com.ziroom.ziroomcustomer.base.update;

import com.maa.android.agent.instrumentation.Instrumented;

@Instrumented
public class HttpHelper
{
  /* Error */
  public static String httpGet(String paramString)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 16	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 19	java/net/URL:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: instanceof 16
    //   15: ifne +138 -> 153
    //   18: aload_0
    //   19: invokevirtual 23	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: astore_0
    //   23: aload_0
    //   24: checkcast 25	java/net/HttpURLConnection
    //   27: astore_0
    //   28: aload_0
    //   29: ldc 27
    //   31: invokevirtual 30	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: ldc 32
    //   37: ldc 34
    //   39: invokevirtual 38	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: ldc 40
    //   45: ldc 42
    //   47: invokevirtual 38	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: sipush 10000
    //   54: invokevirtual 46	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   57: aload_0
    //   58: sipush 10000
    //   61: invokevirtual 49	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   64: new 51	java/lang/StringBuffer
    //   67: dup
    //   68: invokespecial 52	java/lang/StringBuffer:<init>	()V
    //   71: astore_2
    //   72: aload_0
    //   73: invokevirtual 56	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   76: astore_0
    //   77: new 58	java/io/InputStreamReader
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 61	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   85: astore_1
    //   86: new 63	java/io/BufferedReader
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   94: astore 4
    //   96: aload 4
    //   98: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnull +61 -> 164
    //   106: aload_2
    //   107: aload_3
    //   108: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   111: pop
    //   112: goto -16 -> 96
    //   115: astore 5
    //   117: aload_0
    //   118: astore_2
    //   119: aload_1
    //   120: astore_3
    //   121: aload 4
    //   123: astore_1
    //   124: aload 5
    //   126: astore_0
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 77	java/io/BufferedReader:close	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 81	java/io/InputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: aload_0
    //   154: checkcast 16	java/net/URL
    //   157: invokestatic 86	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   160: astore_0
    //   161: goto -138 -> 23
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 77	java/io/BufferedReader:close	()V
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 81	java/io/InputStream:close	()V
    //   190: aload_2
    //   191: invokevirtual 89	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   194: areturn
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -73 -> 127
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: astore_2
    //   209: aload 4
    //   211: astore_0
    //   212: goto -85 -> 127
    //   215: astore 5
    //   217: aconst_null
    //   218: astore 4
    //   220: aload_1
    //   221: astore_3
    //   222: aload_0
    //   223: astore_2
    //   224: aload 5
    //   226: astore_0
    //   227: aload 4
    //   229: astore_1
    //   230: goto -103 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramString	String
    //   85	145	1	localObject1	Object
    //   71	153	2	localObject2	Object
    //   1	221	3	localObject3	Object
    //   94	76	4	localBufferedReader	java.io.BufferedReader
    //   203	7	4	localObject4	Object
    //   218	10	4	localObject5	Object
    //   115	10	5	localObject6	Object
    //   215	10	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   96	102	115	finally
    //   106	112	115	finally
    //   72	77	195	finally
    //   77	86	203	finally
    //   86	96	215	finally
  }
  
  /* Error */
  public static String httpPost(String paramString, java.util.Map<String, Object> paramMap)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +13 -> 17
    //   7: new 14	java/lang/Exception
    //   10: dup
    //   11: ldc 100
    //   13: invokespecial 101	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 51	java/lang/StringBuffer
    //   20: dup
    //   21: invokespecial 52	java/lang/StringBuffer:<init>	()V
    //   24: astore_2
    //   25: aload_1
    //   26: ifnull +117 -> 143
    //   29: aload_1
    //   30: invokeinterface 106 1 0
    //   35: ifne +108 -> 143
    //   38: aload_1
    //   39: invokeinterface 110 1 0
    //   44: invokeinterface 116 1 0
    //   49: astore_1
    //   50: aload_1
    //   51: invokeinterface 121 1 0
    //   56: ifeq +76 -> 132
    //   59: aload_1
    //   60: invokeinterface 125 1 0
    //   65: checkcast 127	java/util/Map$Entry
    //   68: astore_3
    //   69: aload_2
    //   70: aload_3
    //   71: invokeinterface 130 1 0
    //   76: checkcast 132	java/lang/String
    //   79: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: ldc -122
    //   84: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   87: pop
    //   88: aload_2
    //   89: new 136	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   96: aload_3
    //   97: invokeinterface 140 1 0
    //   102: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: ldc -111
    //   107: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: ldc 34
    //   115: invokestatic 155	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   121: pop
    //   122: aload_2
    //   123: ldc -99
    //   125: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: goto -79 -> 50
    //   132: aload_2
    //   133: aload_2
    //   134: invokevirtual 161	java/lang/StringBuffer:length	()I
    //   137: iconst_1
    //   138: isub
    //   139: invokevirtual 165	java/lang/StringBuffer:deleteCharAt	(I)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: ldc -89
    //   145: new 136	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   152: ldc -87
    //   154: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_2
    //   158: invokevirtual 89	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   161: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   170: pop
    //   171: aload_2
    //   172: invokevirtual 89	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   175: invokevirtual 179	java/lang/String:getBytes	()[B
    //   178: astore_1
    //   179: new 16	java/net/URL
    //   182: dup
    //   183: aload_0
    //   184: invokespecial 19	java/net/URL:<init>	(Ljava/lang/String;)V
    //   187: astore_0
    //   188: aload_0
    //   189: instanceof 16
    //   192: ifne +248 -> 440
    //   195: aload_0
    //   196: invokevirtual 23	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   199: astore_0
    //   200: aload_0
    //   201: checkcast 25	java/net/HttpURLConnection
    //   204: astore_2
    //   205: aload_2
    //   206: iconst_1
    //   207: invokevirtual 183	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   210: aload_2
    //   211: ldc -71
    //   213: invokevirtual 30	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   216: aload_2
    //   217: ldc 32
    //   219: ldc 34
    //   221: invokevirtual 38	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_2
    //   225: ldc 40
    //   227: ldc 42
    //   229: invokevirtual 38	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_2
    //   233: ldc -69
    //   235: new 136	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   242: aload_1
    //   243: arraylength
    //   244: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc -111
    //   249: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 38	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_2
    //   259: sipush 10000
    //   262: invokevirtual 46	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   265: aload_2
    //   266: sipush 10000
    //   269: invokevirtual 49	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   272: new 51	java/lang/StringBuffer
    //   275: dup
    //   276: invokespecial 52	java/lang/StringBuffer:<init>	()V
    //   279: astore 7
    //   281: aload_2
    //   282: invokevirtual 194	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   285: astore_0
    //   286: aload_0
    //   287: aload_1
    //   288: invokevirtual 200	java/io/OutputStream:write	([B)V
    //   291: aload_0
    //   292: invokevirtual 203	java/io/OutputStream:flush	()V
    //   295: aload_2
    //   296: invokevirtual 56	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   299: astore_1
    //   300: new 58	java/io/InputStreamReader
    //   303: dup
    //   304: aload_1
    //   305: invokespecial 61	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   308: astore_3
    //   309: new 63	java/io/BufferedReader
    //   312: dup
    //   313: aload_3
    //   314: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   317: astore_0
    //   318: aload_0
    //   319: astore 6
    //   321: aload_3
    //   322: astore 5
    //   324: aload_1
    //   325: astore 4
    //   327: aload_0
    //   328: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   331: astore_2
    //   332: aload_2
    //   333: ifnull +118 -> 451
    //   336: aload_0
    //   337: astore 6
    //   339: aload_3
    //   340: astore 5
    //   342: aload_1
    //   343: astore 4
    //   345: aload 7
    //   347: aload_2
    //   348: invokevirtual 74	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   351: pop
    //   352: goto -34 -> 318
    //   355: astore_2
    //   356: aload_0
    //   357: astore 6
    //   359: aload_3
    //   360: astore 5
    //   362: aload_1
    //   363: astore 4
    //   365: aload_2
    //   366: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   369: iconst_0
    //   370: ifeq +11 -> 381
    //   373: new 208	java/lang/NullPointerException
    //   376: dup
    //   377: invokespecial 209	java/lang/NullPointerException:<init>	()V
    //   380: athrow
    //   381: aload_0
    //   382: ifnull +7 -> 389
    //   385: aload_0
    //   386: invokevirtual 77	java/io/BufferedReader:close	()V
    //   389: aload_3
    //   390: ifnull +7 -> 397
    //   393: aload_3
    //   394: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   397: aload_1
    //   398: ifnull +7 -> 405
    //   401: aload_1
    //   402: invokevirtual 81	java/io/InputStream:close	()V
    //   405: ldc -89
    //   407: new 136	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   414: ldc -45
    //   416: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload 7
    //   421: invokevirtual 89	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   424: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 175	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   433: pop
    //   434: aload 7
    //   436: invokevirtual 89	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   439: areturn
    //   440: aload_0
    //   441: checkcast 16	java/net/URL
    //   444: invokestatic 86	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   447: astore_0
    //   448: goto -248 -> 200
    //   451: iconst_0
    //   452: ifeq +11 -> 463
    //   455: new 208	java/lang/NullPointerException
    //   458: dup
    //   459: invokespecial 209	java/lang/NullPointerException:<init>	()V
    //   462: athrow
    //   463: aload_0
    //   464: ifnull +7 -> 471
    //   467: aload_0
    //   468: invokevirtual 77	java/io/BufferedReader:close	()V
    //   471: aload_3
    //   472: ifnull +7 -> 479
    //   475: aload_3
    //   476: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   479: aload_1
    //   480: ifnull -75 -> 405
    //   483: aload_1
    //   484: invokevirtual 81	java/io/InputStream:close	()V
    //   487: goto -82 -> 405
    //   490: astore_0
    //   491: aconst_null
    //   492: astore_2
    //   493: aconst_null
    //   494: astore_3
    //   495: aconst_null
    //   496: astore_1
    //   497: iconst_0
    //   498: ifeq +11 -> 509
    //   501: new 208	java/lang/NullPointerException
    //   504: dup
    //   505: invokespecial 209	java/lang/NullPointerException:<init>	()V
    //   508: athrow
    //   509: aload_2
    //   510: ifnull +7 -> 517
    //   513: aload_2
    //   514: invokevirtual 77	java/io/BufferedReader:close	()V
    //   517: aload_3
    //   518: ifnull +7 -> 525
    //   521: aload_3
    //   522: invokevirtual 78	java/io/InputStreamReader:close	()V
    //   525: aload_1
    //   526: ifnull +7 -> 533
    //   529: aload_1
    //   530: invokevirtual 81	java/io/InputStream:close	()V
    //   533: aload_0
    //   534: athrow
    //   535: astore_0
    //   536: aconst_null
    //   537: astore_2
    //   538: aconst_null
    //   539: astore_3
    //   540: goto -43 -> 497
    //   543: astore_0
    //   544: aconst_null
    //   545: astore_2
    //   546: goto -49 -> 497
    //   549: astore_0
    //   550: aload 6
    //   552: astore_2
    //   553: aload 5
    //   555: astore_3
    //   556: aload 4
    //   558: astore_1
    //   559: goto -62 -> 497
    //   562: astore_2
    //   563: aconst_null
    //   564: astore_0
    //   565: aconst_null
    //   566: astore_3
    //   567: aconst_null
    //   568: astore_1
    //   569: goto -213 -> 356
    //   572: astore_2
    //   573: aconst_null
    //   574: astore_0
    //   575: aconst_null
    //   576: astore_3
    //   577: goto -221 -> 356
    //   580: astore_2
    //   581: aconst_null
    //   582: astore_0
    //   583: goto -227 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	paramString	String
    //   0	586	1	paramMap	java.util.Map<String, Object>
    //   24	324	2	localObject1	Object
    //   355	11	2	localException1	Exception
    //   492	61	2	localObject2	Object
    //   562	1	2	localException2	Exception
    //   572	1	2	localException3	Exception
    //   580	1	2	localException4	Exception
    //   68	509	3	localObject3	Object
    //   325	232	4	localMap	java.util.Map<String, Object>
    //   322	232	5	localObject4	Object
    //   319	232	6	str	String
    //   279	156	7	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   327	332	355	java/lang/Exception
    //   345	352	355	java/lang/Exception
    //   281	300	490	finally
    //   300	309	535	finally
    //   309	318	543	finally
    //   327	332	549	finally
    //   345	352	549	finally
    //   365	369	549	finally
    //   281	300	562	java/lang/Exception
    //   300	309	572	java/lang/Exception
    //   309	318	580	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/HttpHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */