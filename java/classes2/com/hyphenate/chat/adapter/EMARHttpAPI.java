package com.hyphenate.chat.adapter;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.cloud.CustomMultiPartEntity.ProgressListener;
import com.hyphenate.cloud.EMHttpClient;
import com.hyphenate.cloud.HttpClientConfig;
import com.hyphenate.util.EMLog;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;

@Instrumented
public class EMARHttpAPI
{
  public static int HIGH_SPEED_DOWNLOAD_BUF_SIZE = 30720;
  public static String Method_DELETE;
  public static String Method_GET = "GET";
  public static String Method_POST = "POST";
  public static String Method_PUT = "PUT";
  public static int REQUEST_AUTHENTICATION_FAILED = 0;
  public static int REQUEST_FAILED_CODE = 0;
  public static final String TAG = "EMARHttpAPI";
  final boolean tokenRetrieved = false;
  
  static
  {
    Method_DELETE = "DELETE";
    REQUEST_FAILED_CODE = 408;
    REQUEST_AUTHENTICATION_FAILED = 400;
  }
  
  private static HttpResponse _httpExecute(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws ClientProtocolException, IOException, KeyStoreException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, CertificateException, ConnectTimeoutException
  {
    Object localObject = null;
    DefaultHttpClient localDefaultHttpClient = HttpClientConfig.getDefaultHttpClient(paramString1, HttpClientConfig.getTimeout(paramMap));
    if (paramString3.equals(Method_POST))
    {
      paramString1 = new HttpPost(paramString1);
      paramString1.setEntity(new StringEntity(paramString2, "UTF-8"));
    }
    for (;;)
    {
      paramString2 = (String)localObject;
      if (paramString1 != null)
      {
        if (paramMap != null)
        {
          paramMap = paramMap.entrySet().iterator();
          for (;;)
          {
            if (paramMap.hasNext())
            {
              paramString2 = (Map.Entry)paramMap.next();
              paramString1.setHeader((String)paramString2.getKey(), (String)paramString2.getValue());
              continue;
              if (paramString3.equals(Method_PUT))
              {
                paramString1 = new HttpPut(paramString1);
                paramString1.setEntity(new StringEntity(paramString2, "UTF-8"));
                break;
              }
              if (paramString3.equals(Method_GET))
              {
                paramString1 = new HttpGet(paramString1);
                break;
              }
              if (!paramString3.equals(Method_DELETE)) {
                break label222;
              }
              paramString1 = new HttpDelete(paramString1);
              break;
            }
          }
        }
        if (!(localDefaultHttpClient instanceof HttpClient)) {
          paramString2 = localDefaultHttpClient.execute(paramString1);
        }
      }
      else
      {
        return paramString2;
      }
      return ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, paramString1);
      label222:
      paramString1 = null;
    }
  }
  
  public static int download(String paramString1, String paramString2, Map<String, String> paramMap, EMARHttpCallback paramEMARHttpCallback)
  {
    int i = REQUEST_FAILED_CODE;
    int j;
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      EMLog.e("EMARHttpAPI", "invalid remoteUrl");
      j = i;
    }
    do
    {
      do
      {
        do
        {
          return j;
          paramString1 = processUrl(HttpClientConfig.getFileRemoteUrl(paramString1));
          EMLog.d("EMARHttpAPI", "download file: remote url : " + paramString1 + " , local file : " + paramString2);
          Object localObject = new File(paramString2);
          EMLog.d("EMARHttpAPI", "local exists:" + ((File)localObject).exists());
          if (!((File)localObject).getParentFile().exists()) {
            ((File)localObject).getParentFile().mkdirs();
          }
          localObject = HttpClientConfig.getDefaultHttpClient(paramString1, 300000);
          for (;;)
          {
            try
            {
              paramString1 = new HttpGet(paramString1);
              processHeaders(paramString1, paramMap);
              if ((localObject instanceof HttpClient)) {
                continue;
              }
              paramString1 = ((DefaultHttpClient)localObject).execute(paramString1);
              j = paramString1.getStatusLine().getStatusCode();
              i = j;
              switch (i)
              {
              default: 
                try
                {
                  EMLog.e("EMARHttpAPI", "error response code is :" + i);
                  return i;
                }
                catch (Exception paramString2) {}
              }
            }
            catch (Exception paramString2)
            {
              long l;
              continue;
            }
            paramMap = paramString2.getMessage();
            paramString1 = paramMap;
            if (paramMap == null)
            {
              paramString2 = paramString2.toString();
              paramString1 = paramString2;
              if (paramString2 == null) {
                paramString1 = "failed to download file";
              }
            }
            EMLog.e("EMARHttpAPI", paramString1);
            return i;
            paramString1 = ApacheHttpClientInstrumentation.execute((HttpClient)localObject, paramString1);
          }
          if (onDownloadCompleted(paramString1, paramEMARHttpCallback, paramString2) <= 0L) {
            return REQUEST_FAILED_CODE;
          }
          j = i;
        } while (paramEMARHttpCallback == null);
        EMLog.e("EMARHttpAPI", "download successfully");
        return i;
        l = EMHttpClient.getInstance().chatConfig().o();
        j = i;
      } while (System.currentTimeMillis() - l > 600000L);
      j = i;
    } while (paramEMARHttpCallback == null);
    EMLog.e("EMARHttpAPI", "unauthorized file");
    return i;
  }
  
  private static String getMimeType(File paramFile)
  {
    paramFile = paramFile.getName();
    if ((paramFile.endsWith(".3gp")) || (paramFile.endsWith(".amr"))) {
      return "audio/3gp";
    }
    if ((paramFile.endsWith(".jpe")) || (paramFile.endsWith(".jpeg")) || (paramFile.endsWith(".jpg"))) {
      return "image/jpeg";
    }
    if (paramFile.endsWith(".amr")) {
      return "audio/amr";
    }
    if (paramFile.endsWith(".mp4")) {
      return "video/mp4";
    }
    return "image/png";
  }
  
  /* Error */
  private static ByteArrayBuffer getResponseContent(HttpResponse paramHttpResponse)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: getstatic 46	com/hyphenate/chat/adapter/EMARHttpAPI:HIGH_SPEED_DOWNLOAD_BUF_SIZE	I
    //   12: istore_1
    //   13: iload_1
    //   14: newarray <illegal type>
    //   16: astore 7
    //   18: new 318	org/apache/http/util/ByteArrayBuffer
    //   21: dup
    //   22: iload_1
    //   23: invokespecial 321	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   26: astore 8
    //   28: aload_0
    //   29: invokeinterface 325 1 0
    //   34: invokeinterface 331 1 0
    //   39: astore_0
    //   40: aload_0
    //   41: astore 5
    //   43: aload_0
    //   44: astore 4
    //   46: aload_0
    //   47: astore 6
    //   49: aload_0
    //   50: aload 7
    //   52: invokevirtual 337	java/io/InputStream:read	([B)I
    //   55: i2l
    //   56: lstore_2
    //   57: lload_2
    //   58: ldc2_w 338
    //   61: lcmp
    //   62: ifeq +48 -> 110
    //   65: aload_0
    //   66: astore 5
    //   68: aload_0
    //   69: astore 4
    //   71: aload_0
    //   72: astore 6
    //   74: aload 8
    //   76: aload 7
    //   78: iconst_0
    //   79: lload_2
    //   80: l2i
    //   81: invokevirtual 342	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   84: goto -44 -> 40
    //   87: astore_0
    //   88: aload 5
    //   90: astore 4
    //   92: aload_0
    //   93: invokevirtual 345	java/lang/IllegalStateException:printStackTrace	()V
    //   96: aload 5
    //   98: astore 4
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: aload 4
    //   105: invokevirtual 348	java/io/InputStream:close	()V
    //   108: aload_0
    //   109: athrow
    //   110: aload_0
    //   111: invokevirtual 348	java/io/InputStream:close	()V
    //   114: aload 8
    //   116: areturn
    //   117: astore_0
    //   118: aload 6
    //   120: astore 4
    //   122: aload_0
    //   123: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   126: aload 6
    //   128: astore 4
    //   130: aload_0
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramHttpResponse	HttpResponse
    //   12	11	1	i	int
    //   56	24	2	l	long
    //   1	128	4	localObject	Object
    //   7	90	5	localHttpResponse1	HttpResponse
    //   4	123	6	localHttpResponse2	HttpResponse
    //   16	61	7	arrayOfByte	byte[]
    //   26	89	8	localByteArrayBuffer	ByteArrayBuffer
    // Exception table:
    //   from	to	target	type
    //   28	40	87	java/lang/IllegalStateException
    //   49	57	87	java/lang/IllegalStateException
    //   74	84	87	java/lang/IllegalStateException
    //   28	40	102	finally
    //   49	57	102	finally
    //   74	84	102	finally
    //   92	96	102	finally
    //   100	102	102	finally
    //   122	126	102	finally
    //   130	132	102	finally
    //   28	40	117	java/io/IOException
    //   49	57	117	java/io/IOException
    //   74	84	117	java/io/IOException
  }
  
  public static int httpExecute(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, StringBuilder paramStringBuilder)
  {
    int k = REQUEST_FAILED_CODE;
    int i = k;
    int j = k;
    try
    {
      paramString1 = _httpExecute(paramString1, paramMap, paramString2, paramString3);
      i = k;
      j = k;
      paramMap = getResponseContent(paramString1);
      i = k;
      j = k;
      paramStringBuilder.delete(0, paramStringBuilder.length());
      i = k;
      j = k;
      paramStringBuilder.append(new String(paramMap.buffer(), 0, paramMap.length()));
      i = k;
      j = k;
      k = paramString1.getStatusLine().getStatusCode();
      i = k;
      j = k;
      EMLog.d("EMARHttpAPI", "httpExecute code: " + k);
      return k;
    }
    catch (ConnectTimeoutException paramString1)
    {
      EMLog.e("EMARHttpAPI", "ConnectTimeoutException");
      EMLog.e("EMARHttpAPI", "can't catch exceptions");
      return i;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        EMLog.e("EMARHttpAPI", paramString1.getMessage());
        paramString1.printStackTrace();
        i = j;
      }
    }
  }
  
  /* Error */
  private static long onDownloadCompleted(HttpResponse paramHttpResponse, EMARHttpCallback paramEMARHttpCallback, String paramString)
    throws IOException, java.lang.IllegalStateException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 325 1 0
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: lconst_0
    //   12: lreturn
    //   13: aload_0
    //   14: invokeinterface 380 1 0
    //   19: lstore 9
    //   21: aload_0
    //   22: invokeinterface 331 1 0
    //   27: astore_0
    //   28: new 203	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 11
    //   38: new 382	java/io/FileOutputStream
    //   41: dup
    //   42: aload 11
    //   44: invokespecial 385	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: astore_2
    //   48: getstatic 46	com/hyphenate/chat/adapter/EMARHttpAPI:HIGH_SPEED_DOWNLOAD_BUF_SIZE	I
    //   51: newarray <illegal type>
    //   53: astore 12
    //   55: iconst_0
    //   56: istore_3
    //   57: lconst_0
    //   58: lstore 7
    //   60: aload_0
    //   61: aload 12
    //   63: invokevirtual 337	java/io/InputStream:read	([B)I
    //   66: istore 6
    //   68: iload 6
    //   70: iconst_m1
    //   71: if_icmpeq +142 -> 213
    //   74: lload 7
    //   76: iload 6
    //   78: i2l
    //   79: ladd
    //   80: lstore 7
    //   82: ldc2_w 386
    //   85: lload 7
    //   87: lmul
    //   88: lload 9
    //   90: ldiv
    //   91: l2i
    //   92: istore 5
    //   94: ldc 20
    //   96: new 185	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   103: iload 5
    //   105: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: ldc_w 389
    //   111: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 201	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: iload 5
    //   122: bipush 100
    //   124: if_icmpeq +14 -> 138
    //   127: iload_3
    //   128: istore 4
    //   130: iload 5
    //   132: iload_3
    //   133: iconst_5
    //   134: iadd
    //   135: if_icmple +20 -> 155
    //   138: aload_1
    //   139: ifnull +92 -> 231
    //   142: aload_1
    //   143: lload 9
    //   145: l2d
    //   146: lload 7
    //   148: l2d
    //   149: invokevirtual 395	com/hyphenate/chat/adapter/EMARHttpCallback:onProgress	(DD)V
    //   152: goto +79 -> 231
    //   155: aload_2
    //   156: aload 12
    //   158: iconst_0
    //   159: iload 6
    //   161: invokevirtual 400	java/io/OutputStream:write	([BII)V
    //   164: iload 4
    //   166: istore_3
    //   167: goto -107 -> 60
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: aload_2
    //   179: invokevirtual 401	java/io/OutputStream:close	()V
    //   182: aload_0
    //   183: invokevirtual 348	java/io/InputStream:close	()V
    //   186: aload_1
    //   187: athrow
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 345	java/lang/IllegalStateException:printStackTrace	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   200: aload_0
    //   201: athrow
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 402	java/io/FileNotFoundException:printStackTrace	()V
    //   207: aload_0
    //   208: invokevirtual 348	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: athrow
    //   213: aload 11
    //   215: invokevirtual 404	java/io/File:length	()J
    //   218: lstore 7
    //   220: aload_2
    //   221: invokevirtual 401	java/io/OutputStream:close	()V
    //   224: aload_0
    //   225: invokevirtual 348	java/io/InputStream:close	()V
    //   228: lload 7
    //   230: lreturn
    //   231: iload 5
    //   233: istore 4
    //   235: goto -80 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramHttpResponse	HttpResponse
    //   0	238	1	paramEMARHttpCallback	EMARHttpCallback
    //   0	238	2	paramString	String
    //   56	111	3	i	int
    //   128	106	4	j	int
    //   92	140	5	k	int
    //   66	94	6	m	int
    //   58	171	7	l1	long
    //   19	125	9	l2	long
    //   36	178	11	localFile	File
    //   53	104	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   60	68	170	java/io/IOException
    //   82	120	170	java/io/IOException
    //   142	152	170	java/io/IOException
    //   155	164	170	java/io/IOException
    //   213	220	170	java/io/IOException
    //   60	68	177	finally
    //   82	120	177	finally
    //   142	152	177	finally
    //   155	164	177	finally
    //   171	177	177	finally
    //   213	220	177	finally
    //   21	28	188	java/lang/IllegalStateException
    //   21	28	195	java/io/IOException
    //   38	48	202	java/io/FileNotFoundException
  }
  
  private static void processHeaders(HttpGet paramHttpGet, Map<String, String> paramMap)
  {
    paramHttpGet.addHeader("Authorization", "Bearer " + EMClient.getInstance().getOptions().getAccessToken());
    paramHttpGet.addHeader("Accept", "application/octet-stream");
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((!((String)localEntry.getKey()).equals("Authorization")) && (!((String)localEntry.getKey()).equals("Accept"))) {
          paramHttpGet.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
  }
  
  private static String processUrl(String paramString)
  {
    String str = paramString;
    if (paramString.contains("+")) {
      str = paramString.replaceAll("\\+", "%2B");
    }
    paramString = str;
    if (str.contains("#")) {
      paramString = str.replaceAll("#", "%23");
    }
    return paramString;
  }
  
  /* Error */
  public static int upload(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, StringBuilder paramStringBuilder, EMARHttpCallback paramEMARHttpCallback)
  {
    // Byte code:
    //   0: invokestatic 413	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   3: invokevirtual 417	com/hyphenate/chat/EMClient:getOptions	()Lcom/hyphenate/chat/EMOptions;
    //   6: invokevirtual 453	com/hyphenate/chat/EMOptions:getAppKey	()Ljava/lang/String;
    //   9: astore 10
    //   11: invokestatic 413	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   14: invokevirtual 456	com/hyphenate/chat/EMClient:getCurrentUser	()Ljava/lang/String;
    //   17: astore 11
    //   19: new 203	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 8
    //   29: getstatic 42	com/hyphenate/chat/adapter/EMARHttpAPI:REQUEST_FAILED_CODE	I
    //   32: istore 6
    //   34: ldc 20
    //   36: ldc_w 457
    //   39: invokestatic 201	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: new 459	com/hyphenate/cloud/CustomMultiPartEntity
    //   45: dup
    //   46: getstatic 465	c/a/a/a/a/a/d:b	Lc/a/a/a/a/a/d;
    //   49: aconst_null
    //   50: ldc 95
    //   52: invokestatic 471	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   55: aconst_null
    //   56: invokespecial 474	com/hyphenate/cloud/CustomMultiPartEntity:<init>	(Lc/a/a/a/a/a/d;Ljava/lang/String;Ljava/nio/charset/Charset;Lcom/hyphenate/cloud/CustomMultiPartEntity$ProgressListener;)V
    //   59: astore 9
    //   61: aload 10
    //   63: ifnull +20 -> 83
    //   66: aload 9
    //   68: ldc_w 476
    //   71: new 478	c/a/a/a/a/a/a/e
    //   74: dup
    //   75: aload 10
    //   77: invokespecial 479	c/a/a/a/a/a/a/e:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 483	com/hyphenate/cloud/CustomMultiPartEntity:addPart	(Ljava/lang/String;Lc/a/a/a/a/a/a/b;)V
    //   83: aload 11
    //   85: ifnull +20 -> 105
    //   88: aload 9
    //   90: ldc_w 485
    //   93: new 478	c/a/a/a/a/a/a/e
    //   96: dup
    //   97: aload 11
    //   99: invokespecial 479	c/a/a/a/a/a/a/e:<init>	(Ljava/lang/String;)V
    //   102: invokevirtual 483	com/hyphenate/cloud/CustomMultiPartEntity:addPart	(Ljava/lang/String;Lc/a/a/a/a/a/a/b;)V
    //   105: aload 8
    //   107: invokestatic 487	com/hyphenate/chat/adapter/EMARHttpAPI:getMimeType	(Ljava/io/File;)Ljava/lang/String;
    //   110: astore 10
    //   112: aload_0
    //   113: ldc_w 489
    //   116: invokevirtual 493	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   119: iflt +433 -> 552
    //   122: aload_0
    //   123: aload_0
    //   124: ldc_w 489
    //   127: invokevirtual 496	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   130: iconst_1
    //   131: iadd
    //   132: invokevirtual 500	java/lang/String:substring	(I)Ljava/lang/String;
    //   135: astore_0
    //   136: aload_2
    //   137: ifnull +410 -> 547
    //   140: aload_2
    //   141: invokevirtual 503	java/lang/String:isEmpty	()Z
    //   144: ifne +403 -> 547
    //   147: ldc 20
    //   149: new 185	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 505
    //   159: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_2
    //   163: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 201	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 9
    //   174: ldc_w 507
    //   177: new 509	c/a/a/a/a/a/a/d
    //   180: dup
    //   181: aload 8
    //   183: aload_2
    //   184: aload 10
    //   186: ldc 95
    //   188: invokespecial 512	c/a/a/a/a/a/a/d:<init>	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   191: invokevirtual 483	com/hyphenate/cloud/CustomMultiPartEntity:addPart	(Ljava/lang/String;Lc/a/a/a/a/a/a/b;)V
    //   194: aload 9
    //   196: new 6	com/hyphenate/chat/adapter/EMARHttpAPI$1
    //   199: dup
    //   200: aload 9
    //   202: invokevirtual 513	com/hyphenate/cloud/CustomMultiPartEntity:getContentLength	()J
    //   205: aload 5
    //   207: invokespecial 516	com/hyphenate/chat/adapter/EMARHttpAPI$1:<init>	(JLcom/hyphenate/chat/adapter/EMARHttpCallback;)V
    //   210: invokevirtual 520	com/hyphenate/cloud/CustomMultiPartEntity:setListener	(Lcom/hyphenate/cloud/CustomMultiPartEntity$ProgressListener;)V
    //   213: new 88	org/apache/http/client/methods/HttpPost
    //   216: dup
    //   217: aload_1
    //   218: invokestatic 180	com/hyphenate/cloud/HttpClientConfig:getFileRemoteUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   221: invokespecial 91	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   224: astore_0
    //   225: aload_0
    //   226: aload 9
    //   228: invokevirtual 102	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   231: aload_3
    //   232: ifnull +72 -> 304
    //   235: aload_3
    //   236: invokeinterface 108 1 0
    //   241: invokeinterface 114 1 0
    //   246: astore_2
    //   247: aload_2
    //   248: invokeinterface 120 1 0
    //   253: ifeq +51 -> 304
    //   256: aload_2
    //   257: invokeinterface 124 1 0
    //   262: checkcast 126	java/util/Map$Entry
    //   265: astore_3
    //   266: aload_0
    //   267: aload_3
    //   268: invokeinterface 129 1 0
    //   273: checkcast 82	java/lang/String
    //   276: aload_3
    //   277: invokeinterface 132 1 0
    //   282: checkcast 82	java/lang/String
    //   285: invokevirtual 521	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -41 -> 247
    //   291: astore_0
    //   292: ldc 20
    //   294: aload_0
    //   295: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   298: invokestatic 176	com/hyphenate/util/EMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: iload 6
    //   303: ireturn
    //   304: aload_0
    //   305: ldc_w 523
    //   308: aload 8
    //   310: invokevirtual 286	java/io/File:getName	()Ljava/lang/String;
    //   313: invokevirtual 521	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_1
    //   317: ldc -36
    //   319: invokestatic 80	com/hyphenate/cloud/HttpClientConfig:getDefaultHttpClient	(Ljava/lang/String;I)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   322: astore_2
    //   323: new 525	org/apache/http/params/BasicHttpParams
    //   326: dup
    //   327: invokespecial 526	org/apache/http/params/BasicHttpParams:<init>	()V
    //   330: astore_3
    //   331: aload_3
    //   332: ldc_w 528
    //   335: ldc 95
    //   337: invokeinterface 534 3 0
    //   342: pop
    //   343: aload_2
    //   344: aload_3
    //   345: invokevirtual 538	org/apache/http/impl/client/DefaultHttpClient:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   348: aload_2
    //   349: instanceof 149
    //   352: ifne +162 -> 514
    //   355: aload_2
    //   356: aload_0
    //   357: invokevirtual 227	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   360: astore_0
    //   361: aload_0
    //   362: invokeinterface 233 1 0
    //   367: invokeinterface 238 1 0
    //   372: istore 7
    //   374: iload 7
    //   376: istore 6
    //   378: iload 6
    //   380: tableswitch	default:+20->400, 200:+23->403
    //   400: iload 6
    //   402: ireturn
    //   403: aload_0
    //   404: invokestatic 355	com/hyphenate/chat/adapter/EMARHttpAPI:getResponseContent	(Lorg/apache/http/HttpResponse;)Lorg/apache/http/util/ByteArrayBuffer;
    //   407: astore_0
    //   408: ldc 20
    //   410: new 185	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 540
    //   420: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: new 82	java/lang/String
    //   426: dup
    //   427: aload_0
    //   428: invokevirtual 364	org/apache/http/util/ByteArrayBuffer:buffer	()[B
    //   431: iconst_0
    //   432: aload_0
    //   433: invokevirtual 365	org/apache/http/util/ByteArrayBuffer:length	()I
    //   436: invokespecial 367	java/lang/String:<init>	([BII)V
    //   439: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 201	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload 4
    //   450: new 82	java/lang/String
    //   453: dup
    //   454: aload_0
    //   455: invokevirtual 364	org/apache/http/util/ByteArrayBuffer:buffer	()[B
    //   458: iconst_0
    //   459: aload_0
    //   460: invokevirtual 365	org/apache/http/util/ByteArrayBuffer:length	()I
    //   463: invokespecial 367	java/lang/String:<init>	([BII)V
    //   466: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: iload 6
    //   472: ireturn
    //   473: astore_0
    //   474: ldc 20
    //   476: new 185	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 542
    //   486: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_1
    //   490: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 176	com/hyphenate/util/EMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: iload 6
    //   501: ireturn
    //   502: astore_0
    //   503: ldc 20
    //   505: ldc_w 371
    //   508: invokestatic 176	com/hyphenate/util/EMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: iload 6
    //   513: ireturn
    //   514: aload_2
    //   515: checkcast 149	org/apache/http/client/HttpClient
    //   518: aload_0
    //   519: invokestatic 158	com/mato/sdk/instrumentation/ApacheHttpClientInstrumentation:execute	(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   522: astore_0
    //   523: goto -162 -> 361
    //   526: astore_0
    //   527: ldc 20
    //   529: aload_0
    //   530: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   533: invokestatic 176	com/hyphenate/util/EMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: iload 6
    //   538: ireturn
    //   539: astore_0
    //   540: goto -13 -> 527
    //   543: astore_0
    //   544: goto -41 -> 503
    //   547: aload_0
    //   548: astore_2
    //   549: goto -377 -> 172
    //   552: goto -416 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	paramString1	String
    //   0	555	1	paramString2	String
    //   0	555	2	paramString3	String
    //   0	555	3	paramMap	Map<String, String>
    //   0	555	4	paramStringBuilder	StringBuilder
    //   0	555	5	paramEMARHttpCallback	EMARHttpCallback
    //   32	505	6	i	int
    //   372	3	7	j	int
    //   27	282	8	localFile	File
    //   59	168	9	localCustomMultiPartEntity	com.hyphenate.cloud.CustomMultiPartEntity
    //   9	176	10	str1	String
    //   17	81	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   66	83	291	java/lang/Exception
    //   88	105	291	java/lang/Exception
    //   403	470	473	java/lang/Exception
    //   403	470	502	org/apache/http/conn/ConnectTimeoutException
    //   474	499	502	org/apache/http/conn/ConnectTimeoutException
    //   348	361	526	java/lang/Exception
    //   361	374	526	java/lang/Exception
    //   514	523	526	java/lang/Exception
    //   474	499	539	java/lang/Exception
    //   348	361	543	org/apache/http/conn/ConnectTimeoutException
    //   361	374	543	org/apache/http/conn/ConnectTimeoutException
    //   514	523	543	org/apache/http/conn/ConnectTimeoutException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMARHttpAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */