package com.ziroom.ziroomcustomer.ziroomstation.utils;

import com.maa.android.agent.instrumentation.Instrumented;

@Instrumented
public class d
{
  private String a = "UTF-8";
  private Integer b = Integer.valueOf(20000);
  
  /* Error */
  public String httpUploadTo(String paramString1, byte[] paramArrayOfByte, String paramString2, java.util.Map<String, Object> paramMap1, java.util.Map<String, Object> paramMap2)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: ldc 32
    //   2: new 34	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   9: ldc 37
    //   11: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 43
    //   20: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_3
    //   24: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 53	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: new 55	java/net/URL
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 58	java/net/URL:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: instanceof 55
    //   46: ifne +182 -> 228
    //   49: aload_1
    //   50: invokevirtual 62	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: astore_1
    //   54: aload_1
    //   55: checkcast 64	java/net/HttpURLConnection
    //   58: astore_1
    //   59: aload_1
    //   60: iconst_1
    //   61: invokevirtual 68	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   64: aload_1
    //   65: iconst_1
    //   66: invokevirtual 71	java/net/HttpURLConnection:setDoInput	(Z)V
    //   69: aload_1
    //   70: iconst_0
    //   71: invokevirtual 74	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   74: aload_1
    //   75: ldc 76
    //   77: invokevirtual 79	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ldc 81
    //   83: ldc 83
    //   85: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_1
    //   89: ldc 88
    //   91: ldc 15
    //   93: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_1
    //   97: ldc 90
    //   99: ldc 92
    //   101: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload 4
    //   106: ifnull +133 -> 239
    //   109: aload 4
    //   111: invokeinterface 98 1 0
    //   116: ifne +123 -> 239
    //   119: aload 4
    //   121: invokeinterface 102 1 0
    //   126: invokeinterface 108 1 0
    //   131: astore 4
    //   133: aload 4
    //   135: invokeinterface 113 1 0
    //   140: ifeq +99 -> 239
    //   143: aload 4
    //   145: invokeinterface 117 1 0
    //   150: checkcast 119	java/util/Map$Entry
    //   153: astore_3
    //   154: aload_1
    //   155: aload_3
    //   156: invokeinterface 122 1 0
    //   161: checkcast 124	java/lang/String
    //   164: aload_3
    //   165: invokeinterface 127 1 0
    //   170: invokevirtual 128	java/lang/Object:toString	()Ljava/lang/String;
    //   173: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: ldc 32
    //   178: new 34	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   185: ldc -126
    //   187: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_3
    //   191: invokeinterface 122 1 0
    //   196: checkcast 124	java/lang/String
    //   199: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc -124
    //   204: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: invokeinterface 127 1 0
    //   213: invokevirtual 128	java/lang/Object:toString	()Ljava/lang/String;
    //   216: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 53	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: goto -92 -> 133
    //   228: aload_1
    //   229: checkcast 55	java/net/URL
    //   232: invokestatic 137	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   235: astore_1
    //   236: goto -182 -> 54
    //   239: aload_1
    //   240: aload_0
    //   241: getfield 25	com/ziroom/ziroomcustomer/ziroomstation/utils/d:b	Ljava/lang/Integer;
    //   244: invokevirtual 141	java/lang/Integer:intValue	()I
    //   247: invokevirtual 145	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   250: aload_1
    //   251: invokevirtual 148	java/net/HttpURLConnection:connect	()V
    //   254: new 150	java/lang/StringBuffer
    //   257: dup
    //   258: invokespecial 151	java/lang/StringBuffer:<init>	()V
    //   261: astore 5
    //   263: aload_1
    //   264: invokevirtual 155	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   267: astore_3
    //   268: aload_3
    //   269: aload_2
    //   270: invokevirtual 161	java/io/OutputStream:write	([B)V
    //   273: aload_3
    //   274: invokevirtual 164	java/io/OutputStream:flush	()V
    //   277: aload_1
    //   278: invokevirtual 168	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   281: astore 4
    //   283: new 170	java/io/InputStreamReader
    //   286: dup
    //   287: aload 4
    //   289: invokespecial 173	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   292: astore_3
    //   293: new 175	java/io/BufferedReader
    //   296: dup
    //   297: aload_3
    //   298: invokespecial 178	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 181	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   306: astore 6
    //   308: aload 6
    //   310: ifnull +55 -> 365
    //   313: aload 5
    //   315: aload 6
    //   317: invokevirtual 184	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   320: pop
    //   321: goto -19 -> 302
    //   324: astore_1
    //   325: iconst_0
    //   326: ifeq +11 -> 337
    //   329: new 186	java/lang/NullPointerException
    //   332: dup
    //   333: invokespecial 187	java/lang/NullPointerException:<init>	()V
    //   336: athrow
    //   337: aload_2
    //   338: ifnull +7 -> 345
    //   341: aload_2
    //   342: invokevirtual 190	java/io/BufferedReader:close	()V
    //   345: aload_3
    //   346: ifnull +7 -> 353
    //   349: aload_3
    //   350: invokevirtual 191	java/io/InputStreamReader:close	()V
    //   353: aload 4
    //   355: ifnull +8 -> 363
    //   358: aload 4
    //   360: invokevirtual 194	java/io/InputStream:close	()V
    //   363: aload_1
    //   364: athrow
    //   365: ldc 32
    //   367: new 34	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   374: ldc -60
    //   376: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 5
    //   381: invokevirtual 197	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   384: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 53	com/freelxl/baselibrary/f/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_1
    //   394: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   397: iconst_0
    //   398: ifeq +11 -> 409
    //   401: new 186	java/lang/NullPointerException
    //   404: dup
    //   405: invokespecial 187	java/lang/NullPointerException:<init>	()V
    //   408: athrow
    //   409: aload_2
    //   410: ifnull +7 -> 417
    //   413: aload_2
    //   414: invokevirtual 190	java/io/BufferedReader:close	()V
    //   417: aload_3
    //   418: ifnull +7 -> 425
    //   421: aload_3
    //   422: invokevirtual 191	java/io/InputStreamReader:close	()V
    //   425: aload 4
    //   427: ifnull +8 -> 435
    //   430: aload 4
    //   432: invokevirtual 194	java/io/InputStream:close	()V
    //   435: aload 5
    //   437: invokevirtual 197	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   440: areturn
    //   441: astore_1
    //   442: aconst_null
    //   443: astore_2
    //   444: aconst_null
    //   445: astore_3
    //   446: aconst_null
    //   447: astore 4
    //   449: goto -124 -> 325
    //   452: astore_1
    //   453: aconst_null
    //   454: astore_2
    //   455: aconst_null
    //   456: astore_3
    //   457: goto -132 -> 325
    //   460: astore_1
    //   461: aconst_null
    //   462: astore_2
    //   463: goto -138 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	d
    //   0	466	1	paramString1	String
    //   0	466	2	paramArrayOfByte	byte[]
    //   0	466	3	paramString2	String
    //   0	466	4	paramMap1	java.util.Map<String, Object>
    //   0	466	5	paramMap2	java.util.Map<String, Object>
    //   306	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   302	308	324	finally
    //   313	321	324	finally
    //   365	397	324	finally
    //   263	283	441	finally
    //   283	293	452	finally
    //   293	302	460	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */