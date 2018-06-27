package com.megvii.zhimasdk.a;

import com.maa.android.agent.instrumentation.Instrumented;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class c
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f = "http://";
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 != "")
    {
      this.a = paramString1;
      if (!this.a.startsWith("http://")) {
        break label92;
      }
      this.a = this.a.substring(7);
    }
    while (this.a.endsWith("/"))
    {
      this.a = this.a.substring(0, this.a.length() - 1);
      continue;
      throw new NullPointerException("endpoint is null");
      label92:
      if (this.a.startsWith("https://"))
      {
        this.a = this.a.substring(8);
        this.f = "https://";
      }
    }
    if (paramString2 != "")
    {
      this.b = paramString2;
      if (paramString3 != "")
      {
        this.c = paramString3;
        if (paramString4 == "") {
          break label188;
        }
        this.e = paramString4;
        this.d = "";
      }
    }
    else
    {
      throw new NullPointerException("accessKeyID is null");
    }
    throw new NullPointerException("accessKeySecret is null");
    label188:
    throw new NullPointerException("projectName is null");
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString2 = paramString2.getBytes("UTF-8");
    paramString1 = paramString1.getBytes("UTF-8");
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec(paramString2, "HmacSHA1"));
    return new String(b.a(localMac.doFinal(paramString1)));
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramArrayOfByte)).toString(16).toUpperCase();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (paramArrayOfByte.length() + i < 32)
      {
        localStringBuilder.append("0");
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString() + paramArrayOfByte;
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new d("LogClientError", "Not Supported signature method MD5", paramArrayOfByte, "");
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      if ((paramString1 != null) && (paramString1.has("errorCode")) && (paramString1.has("errorMessage"))) {
        throw new d(paramString1.getString("errorCode"), paramString1.getString("errorMessage"), paramString2);
      }
    }
    catch (JSONException paramString1) {}
  }
  
  /* Error */
  private byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 216	java/util/zip/Deflater
    //   5: dup
    //   6: invokespecial 217	java/util/zip/Deflater:<init>	()V
    //   9: astore 4
    //   11: new 219	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_1
    //   16: arraylength
    //   17: invokespecial 222	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 226	java/util/zip/Deflater:setInput	([B)V
    //   29: aload_3
    //   30: astore_2
    //   31: aload 4
    //   33: invokevirtual 229	java/util/zip/Deflater:finish	()V
    //   36: aload_3
    //   37: astore_2
    //   38: sipush 10240
    //   41: newarray <illegal type>
    //   43: astore_1
    //   44: aload_3
    //   45: astore_2
    //   46: aload 4
    //   48: invokevirtual 233	java/util/zip/Deflater:finished	()Z
    //   51: ifne +56 -> 107
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: aload_1
    //   58: iconst_0
    //   59: aload 4
    //   61: aload_1
    //   62: invokevirtual 237	java/util/zip/Deflater:deflate	([B)I
    //   65: invokevirtual 241	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: goto -24 -> 44
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: new 183	com/megvii/zhimasdk/a/d
    //   77: dup
    //   78: ldc -71
    //   80: ldc -13
    //   82: ldc 23
    //   84: invokespecial 210	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   87: athrow
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 246	java/util/zip/Deflater:end	()V
    //   94: aload_2
    //   95: invokevirtual 249	java/io/ByteArrayOutputStream:size	()I
    //   98: ifeq +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
    //   105: aload_1
    //   106: athrow
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: invokevirtual 256	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore_1
    //   114: aload 4
    //   116: invokevirtual 246	java/util/zip/Deflater:end	()V
    //   119: aload_3
    //   120: invokevirtual 249	java/io/ByteArrayOutputStream:size	()I
    //   123: ifeq +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 252	java/io/ByteArrayOutputStream:close	()V
    //   130: aload_1
    //   131: areturn
    //   132: astore_2
    //   133: goto -28 -> 105
    //   136: astore_1
    //   137: goto -48 -> 89
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -69 -> 74
    //   146: astore_2
    //   147: aload_1
    //   148: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	c
    //   0	149	1	paramArrayOfByte	byte[]
    //   1	108	2	localObject1	Object
    //   132	1	2	localIOException1	java.io.IOException
    //   142	1	2	localObject2	Object
    //   146	1	2	localIOException2	java.io.IOException
    //   20	107	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   9	106	4	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   23	29	71	java/lang/Exception
    //   31	36	71	java/lang/Exception
    //   38	44	71	java/lang/Exception
    //   46	54	71	java/lang/Exception
    //   56	68	71	java/lang/Exception
    //   109	114	71	java/lang/Exception
    //   23	29	88	finally
    //   31	36	88	finally
    //   38	44	88	finally
    //   46	54	88	finally
    //   56	68	88	finally
    //   74	88	88	finally
    //   109	114	88	finally
    //   94	105	132	java/io/IOException
    //   11	21	136	finally
    //   11	21	140	java/lang/Exception
    //   119	130	146	java/io/IOException
  }
  
  public Map<String, String> a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("x-log-apiversion", "0.6.0");
    localHashMap.put("x-log-signaturemethod", "hmac-sha1");
    localHashMap.put("Content-Type", "application/json");
    localHashMap.put("Date", a());
    localHashMap.put("Content-MD5", a(paramArrayOfByte2));
    localHashMap.put("Content-Length", String.valueOf(paramArrayOfByte2.length));
    localHashMap.put("x-log-bodyrawsize", String.valueOf(paramArrayOfByte1.length));
    localHashMap.put("x-log-compresstype", "deflate");
    localHashMap.put("Host", this.e + "." + this.a);
    paramArrayOfByte1 = new StringBuilder("POST\n").append((String)localHashMap.get("Content-MD5") + "\n").append((String)localHashMap.get("Content-Type") + "\n").append((String)localHashMap.get("Date") + "\n");
    paramArrayOfByte2 = this.d;
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2 != ""))
    {
      localHashMap.put("x-acs-security-token", paramArrayOfByte2);
      paramArrayOfByte1.append("x-acs-security-token:" + (String)localHashMap.get("x-acs-security-token") + "\n");
    }
    paramArrayOfByte1.append("x-log-apiversion:0.6.0\n").append("x-log-bodyrawsize:" + (String)localHashMap.get("x-log-bodyrawsize") + "\n").append("x-log-compresstype:deflate\n").append("x-log-signaturemethod:hmac-sha1\n").append("/logstores/" + paramString + "/shards/lb");
    paramString = paramArrayOfByte1.toString();
    try
    {
      paramString = a(paramString, this.c);
      localHashMap.put("Authorization", "LOG " + this.b + ":" + paramString);
      return localHashMap;
    }
    catch (Exception paramString)
    {
      throw new d("LogClientError", "fail to get encode signature", paramString, "");
    }
  }
  
  public void a(e parame, String paramString)
  {
    String str = this.f + this.e + "." + this.a + "/logstores/" + paramString + "/shards/lb";
    try
    {
      parame = parame.a().getBytes("UTF-8");
      byte[] arrayOfByte = b(parame);
      a(str, a(paramString, parame, arrayOfByte), arrayOfByte);
      return;
    }
    catch (UnsupportedEncodingException parame)
    {
      throw new d("LogClientError", "Failed to pass log to utf-8 bytes", parame, "");
    }
  }
  
  /* Error */
  public void a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 358	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 359	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: instanceof 358
    //   15: ifne +108 -> 123
    //   18: aload 5
    //   20: invokevirtual 363	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: astore 5
    //   25: aload 5
    //   27: checkcast 365	java/net/HttpURLConnection
    //   30: astore 5
    //   32: aload 5
    //   34: ldc_w 367
    //   37: invokevirtual 370	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   40: aload 5
    //   42: iconst_1
    //   43: invokevirtual 374	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   46: aload_2
    //   47: invokeinterface 378 1 0
    //   52: invokeinterface 384 1 0
    //   57: astore_2
    //   58: aload_2
    //   59: invokeinterface 389 1 0
    //   64: ifeq +106 -> 170
    //   67: aload_2
    //   68: invokeinterface 393 1 0
    //   73: checkcast 395	java/util/Map$Entry
    //   76: astore 6
    //   78: aload 5
    //   80: aload 6
    //   82: invokeinterface 398 1 0
    //   87: checkcast 27	java/lang/String
    //   90: aload 6
    //   92: invokeinterface 401 1 0
    //   97: checkcast 27	java/lang/String
    //   100: invokevirtual 404	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: goto -45 -> 58
    //   106: astore_1
    //   107: new 183	com/megvii/zhimasdk/a/d
    //   110: dup
    //   111: ldc -71
    //   113: ldc_w 406
    //   116: aload_1
    //   117: ldc 23
    //   119: invokespecial 190	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   122: athrow
    //   123: aload 5
    //   125: checkcast 358	java/net/URL
    //   128: invokestatic 411	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   131: astore 5
    //   133: goto -108 -> 25
    //   136: astore_1
    //   137: new 183	com/megvii/zhimasdk/a/d
    //   140: dup
    //   141: ldc -71
    //   143: ldc_w 413
    //   146: aload_1
    //   147: ldc 23
    //   149: invokespecial 190	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   152: athrow
    //   153: astore_1
    //   154: new 183	com/megvii/zhimasdk/a/d
    //   157: dup
    //   158: ldc -71
    //   160: ldc_w 415
    //   163: aload_1
    //   164: ldc 23
    //   166: invokespecial 190	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   169: athrow
    //   170: new 417	java/io/DataOutputStream
    //   173: dup
    //   174: aload 5
    //   176: invokevirtual 421	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   179: invokespecial 424	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   182: astore_2
    //   183: aload_2
    //   184: aload_3
    //   185: invokevirtual 426	java/io/DataOutputStream:write	([B)V
    //   188: aload_2
    //   189: invokevirtual 429	java/io/DataOutputStream:flush	()V
    //   192: aload_2
    //   193: invokevirtual 430	java/io/DataOutputStream:close	()V
    //   196: aload 5
    //   198: invokevirtual 433	java/net/HttpURLConnection:getResponseCode	()I
    //   201: istore 4
    //   203: aload 5
    //   205: ldc_w 435
    //   208: invokevirtual 438	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   211: astore_2
    //   212: aload_2
    //   213: astore_1
    //   214: aload_2
    //   215: ifnonnull +6 -> 221
    //   218: ldc 23
    //   220: astore_1
    //   221: iload 4
    //   223: sipush 200
    //   226: if_icmpeq +213 -> 439
    //   229: aload 5
    //   231: invokevirtual 442	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   234: astore_2
    //   235: aload_2
    //   236: ifnull +161 -> 397
    //   239: new 444	java/io/BufferedReader
    //   242: dup
    //   243: new 446	java/io/InputStreamReader
    //   246: dup
    //   247: aload_2
    //   248: invokespecial 449	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   251: invokespecial 452	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   254: astore_2
    //   255: new 454	java/lang/StringBuffer
    //   258: dup
    //   259: invokespecial 455	java/lang/StringBuffer:<init>	()V
    //   262: astore_3
    //   263: aload_2
    //   264: invokevirtual 458	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   267: astore 5
    //   269: aload 5
    //   271: ifnull +64 -> 335
    //   274: aload_3
    //   275: aload 5
    //   277: invokevirtual 461	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   280: pop
    //   281: goto -18 -> 263
    //   284: astore_1
    //   285: new 183	com/megvii/zhimasdk/a/d
    //   288: dup
    //   289: ldc_w 463
    //   292: ldc_w 465
    //   295: ldc 23
    //   297: invokespecial 210	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   300: athrow
    //   301: astore_2
    //   302: new 183	com/megvii/zhimasdk/a/d
    //   305: dup
    //   306: ldc -71
    //   308: new 172	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 467
    //   318: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aload_2
    //   329: ldc 23
    //   331: invokespecial 190	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   334: athrow
    //   335: aload_2
    //   336: invokevirtual 468	java/io/BufferedReader:close	()V
    //   339: aload_0
    //   340: aload_3
    //   341: invokevirtual 469	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   344: aload_1
    //   345: invokespecial 471	com/megvii/zhimasdk/a/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: new 183	com/megvii/zhimasdk/a/d
    //   351: dup
    //   352: ldc_w 463
    //   355: new 172	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 473
    //   365: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: iload 4
    //   370: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   373: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc_w 475
    //   379: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_3
    //   383: invokevirtual 469	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   386: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload_1
    //   393: invokespecial 210	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   396: athrow
    //   397: new 183	com/megvii/zhimasdk/a/d
    //   400: dup
    //   401: ldc_w 463
    //   404: new 172	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 473
    //   414: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: iload 4
    //   419: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   422: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 477
    //   428: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: aload_1
    //   435: invokespecial 210	com/megvii/zhimasdk/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   438: athrow
    //   439: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	c
    //   0	440	1	paramString	String
    //   0	440	2	paramMap	Map<String, String>
    //   0	440	3	paramArrayOfByte	byte[]
    //   201	217	4	i	int
    //   8	268	5	localObject	Object
    //   76	15	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   0	10	106	java/net/MalformedURLException
    //   10	25	136	java/io/IOException
    //   25	32	136	java/io/IOException
    //   123	133	136	java/io/IOException
    //   32	40	153	java/net/ProtocolException
    //   196	212	284	java/io/IOException
    //   229	235	284	java/io/IOException
    //   239	263	284	java/io/IOException
    //   263	269	284	java/io/IOException
    //   274	281	284	java/io/IOException
    //   335	397	284	java/io/IOException
    //   397	439	284	java/io/IOException
    //   170	196	301	java/io/IOException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */