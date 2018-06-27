package com.hyphenate.cloud;

import android.content.Context;
import android.text.TextUtils;
import c.a.a.a.a.a.a.d;
import c.a.a.a.a.a.a.e;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.NetUtils;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@Instrumented
class b
  extends CloudFileManager
{
  private static final long b = 10485760L;
  private static final int e = 20;
  boolean a = false;
  private long c;
  private Context d;
  
  public b()
  {
    this.d = EMClient.getInstance().getContext();
  }
  
  public b(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  public b(Context paramContext, String paramString)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  /* Error */
  private long a(HttpResponse paramHttpResponse, CloudOperationCallback paramCloudOperationCallback, String paramString)
    throws java.io.IOException, java.lang.IllegalStateException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 75 1 0
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: lconst_0
    //   12: lreturn
    //   13: aload_1
    //   14: invokeinterface 81 1 0
    //   19: lstore 10
    //   21: aload_1
    //   22: invokeinterface 85 1 0
    //   27: astore_1
    //   28: new 87	java/io/File
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 12
    //   38: new 92	java/io/FileOutputStream
    //   41: dup
    //   42: aload 12
    //   44: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: astore_3
    //   48: aload_0
    //   49: getfield 51	com/hyphenate/cloud/b:d	Landroid/content/Context;
    //   52: invokestatic 101	com/hyphenate/util/NetUtils:getDownloadBufSize	(Landroid/content/Context;)I
    //   55: newarray <illegal type>
    //   57: astore 13
    //   59: iconst_0
    //   60: istore 4
    //   62: lconst_0
    //   63: lstore 8
    //   65: aload_1
    //   66: aload 13
    //   68: invokevirtual 107	java/io/InputStream:read	([B)I
    //   71: istore 7
    //   73: iload 7
    //   75: iconst_m1
    //   76: if_icmpeq +142 -> 218
    //   79: lload 8
    //   81: iload 7
    //   83: i2l
    //   84: ladd
    //   85: lstore 8
    //   87: ldc2_w 108
    //   90: lload 8
    //   92: lmul
    //   93: lload 10
    //   95: ldiv
    //   96: l2i
    //   97: istore 6
    //   99: ldc 111
    //   101: new 113	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   108: iload 6
    //   110: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 120
    //   115: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 132	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: iload 6
    //   126: bipush 100
    //   128: if_icmpeq +16 -> 144
    //   131: iload 4
    //   133: istore 5
    //   135: iload 6
    //   137: iload 4
    //   139: iconst_5
    //   140: iadd
    //   141: if_icmple +18 -> 159
    //   144: aload_2
    //   145: ifnull +91 -> 236
    //   148: aload_2
    //   149: iload 6
    //   151: invokeinterface 138 2 0
    //   156: goto +80 -> 236
    //   159: aload_3
    //   160: aload 13
    //   162: iconst_0
    //   163: iload 7
    //   165: invokevirtual 144	java/io/OutputStream:write	([BII)V
    //   168: iload 5
    //   170: istore 4
    //   172: goto -107 -> 65
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   180: aload_2
    //   181: athrow
    //   182: astore_2
    //   183: aload_3
    //   184: invokevirtual 150	java/io/OutputStream:close	()V
    //   187: aload_1
    //   188: invokevirtual 151	java/io/InputStream:close	()V
    //   191: aload_2
    //   192: athrow
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 152	java/lang/IllegalStateException:printStackTrace	()V
    //   198: aload_1
    //   199: athrow
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   205: aload_1
    //   206: athrow
    //   207: astore_2
    //   208: aload_2
    //   209: invokevirtual 153	java/io/FileNotFoundException:printStackTrace	()V
    //   212: aload_1
    //   213: invokevirtual 151	java/io/InputStream:close	()V
    //   216: aload_2
    //   217: athrow
    //   218: aload 12
    //   220: invokevirtual 156	java/io/File:length	()J
    //   223: lstore 8
    //   225: aload_3
    //   226: invokevirtual 150	java/io/OutputStream:close	()V
    //   229: aload_1
    //   230: invokevirtual 151	java/io/InputStream:close	()V
    //   233: lload 8
    //   235: lreturn
    //   236: iload 6
    //   238: istore 5
    //   240: goto -81 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	b
    //   0	243	1	paramHttpResponse	HttpResponse
    //   0	243	2	paramCloudOperationCallback	CloudOperationCallback
    //   0	243	3	paramString	String
    //   60	111	4	i	int
    //   133	106	5	j	int
    //   97	140	6	k	int
    //   71	93	7	m	int
    //   63	171	8	l1	long
    //   19	75	10	l2	long
    //   36	183	12	localFile	File
    //   57	104	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	73	175	java/io/IOException
    //   87	124	175	java/io/IOException
    //   148	156	175	java/io/IOException
    //   159	168	175	java/io/IOException
    //   218	225	175	java/io/IOException
    //   65	73	182	finally
    //   87	124	182	finally
    //   148	156	182	finally
    //   159	168	182	finally
    //   176	182	182	finally
    //   218	225	182	finally
    //   21	28	193	java/lang/IllegalStateException
    //   21	28	200	java/io/IOException
    //   38	48	207	java/io/FileNotFoundException
  }
  
  public static String a(File paramFile)
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
  
  private String a(String paramString)
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
  
  private void a(final String paramString1, final String paramString2, final String paramString3, final String paramString4, Map<String, String> paramMap, final CloudOperationCallback paramCloudOperationCallback, final int paramInt, boolean paramBoolean)
  {
    EMLog.d("CloudFileManager", "sendFiletoServerHttpWithCountDown .....");
    File localFile = new File(paramString1);
    if (!localFile.isFile())
    {
      EMLog.e("CloudFileManager", "Source file doesn't exist");
      paramCloudOperationCallback.onError("Source file doesn't exist");
      return;
    }
    if (localFile.length() > 10485760L)
    {
      paramCloudOperationCallback.onError("file doesn't bigger than 10 M");
      return;
    }
    final Map localMap = a.a(paramMap);
    String str = HttpClientConfig.getFileRemoteUrl(paramString2);
    EMLog.d("CloudFileManager", " remote path url : " + str + " --countDown: " + paramInt);
    DefaultHttpClient localDefaultHttpClient = HttpClientConfig.getDefaultHttpClient(paramString2, HttpClientConfig.getTimeout(localMap));
    HttpPost localHttpPost;
    CustomMultiPartEntity localCustomMultiPartEntity;
    Object localObject;
    try
    {
      localHttpPost = new HttpPost(str);
      localCustomMultiPartEntity = new CustomMultiPartEntity(new CustomMultiPartEntity.ProgressListener()
      {
        public void transferred(long paramAnonymousLong)
        {
          int i = (int)((float)paramAnonymousLong / (float)b.a(b.this) * 100.0F);
          if ((i != 100) && (paramCloudOperationCallback != null)) {
            paramCloudOperationCallback.onProgress(i);
          }
        }
      });
      if (paramString3 != null) {
        localCustomMultiPartEntity.addPart("app", new e(paramString3));
      }
      if (paramString4 != null) {
        localCustomMultiPartEntity.addPart("id", new e(paramString4));
      }
      if (localMap == null) {
        break label374;
      }
      paramMap = localMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        localHttpPost.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
      if (paramMap == null) {
        break label914;
      }
    }
    catch (Exception paramMap) {}
    label266:
    label286:
    label374:
    label428:
    label537:
    int i;
    if (paramMap.getMessage() != null)
    {
      paramMap = paramMap.getMessage();
      EMLog.e("CloudFileManager", "sendFiletoServerHttp:" + paramMap);
      if ((!paramMap.toLowerCase().contains("refused")) || (!NetUtils.hasNetwork(this.d))) {
        break label964;
      }
      if (paramBoolean) {
        break label922;
      }
      new Thread()
      {
        public void run()
        {
          b.a(b.this, paramString1, this.b, paramString3, paramString4, localMap, paramCloudOperationCallback, 20, true);
        }
      }.start();
      return;
      if (paramString2.indexOf("/") <= 0) {
        break label979;
      }
      localObject = paramString2.substring(0, paramString2.lastIndexOf("/"));
      paramMap = paramString2.substring(paramString2.lastIndexOf("/"));
      localCustomMultiPartEntity.addPart("path", new e((String)localObject));
      localObject = a(localFile);
      EMLog.d("CloudFileManager", " remote file name : " + paramMap);
      localCustomMultiPartEntity.addPart("file", new d(localFile, paramMap, (String)localObject, "UTF-8"));
      this.c = localCustomMultiPartEntity.getContentLength();
      localHttpPost.setEntity(localCustomMultiPartEntity);
      if (EMHttpClient.getInstance().chatConfig().g()) {
        a.a(str, localDefaultHttpClient);
      }
      if (!(localDefaultHttpClient instanceof HttpClient))
      {
        paramMap = localDefaultHttpClient.execute(localHttpPost);
        i = paramMap.getStatusLine().getStatusCode();
        EMLog.d("CloudFileManager", "server responseCode:" + i + " localFilePath : " + paramString1);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      paramMap = EntityUtils.toString(paramMap.getEntity());
      paramMap = "Http response error : " + i + " error msg : " + paramMap;
      EMLog.e("CloudFileManager", paramMap);
      if (paramCloudOperationCallback == null) {
        break;
      }
      paramCloudOperationCallback.onError(paramMap);
      return;
      paramMap = ApacheHttpClientInstrumentation.execute((HttpClient)localDefaultHttpClient, localHttpPost);
      break label537;
      paramCloudOperationCallback.onProgress(100);
      paramCloudOperationCallback.onSuccess(EntityUtils.toString(paramMap.getEntity()));
      return;
      long l = EMHttpClient.getInstance().chatConfig().o();
      if (System.currentTimeMillis() - l <= 600000L)
      {
        if (paramCloudOperationCallback == null) {
          break;
        }
        paramCloudOperationCallback.onError("unauthorized file");
        return;
      }
      if (this.a)
      {
        paramCloudOperationCallback.onError("unauthorized file");
        return;
      }
      paramMap = EMClient.getInstance().getOptions().getAccessToken(true);
      this.a = true;
      if (paramMap == null)
      {
        paramCloudOperationCallback.onError("unauthorized token is null");
        return;
      }
      localMap.put("Authorization", "Bearer " + paramMap);
      if (!paramBoolean)
      {
        new Thread()
        {
          public void run()
          {
            b.a(b.this, paramString1, paramString2, paramString3, paramString4, localMap, paramCloudOperationCallback, 3, true);
          }
        }.start();
        return;
      }
      if (paramInt <= 0) {
        break;
      }
      paramInt -= 1;
      try
      {
        new Thread()
        {
          public void run()
          {
            b.a(b.this, paramString1, paramString2, paramString3, paramString4, localMap, paramCloudOperationCallback, paramInt, true);
          }
        }.start();
        return;
      }
      catch (Exception paramMap) {}
      break label266;
      label914:
      paramMap = "failed to upload the files";
      break label286;
      label922:
      if (paramInt > 0)
      {
        new Thread()
        {
          public void run()
          {
            b.a(b.this, paramString1, this.b, paramString3, paramString4, localMap, paramCloudOperationCallback, this.g, true);
          }
        }.start();
        return;
      }
      label964:
      if (paramCloudOperationCallback == null) {
        break;
      }
      paramCloudOperationCallback.onError(paramMap);
      return;
      label979:
      paramMap = paramString2;
      break label428;
    }
  }
  
  private void a(String paramString1, final String paramString2, Map<String, String> paramMap, final CloudOperationCallback paramCloudOperationCallback, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      paramCloudOperationCallback.onError("invalid remoteUrl");
      label21:
      return;
    }
    final Map localMap = a.a(paramMap);
    paramString1 = HttpClientConfig.getFileRemoteUrl(paramString1);
    EMLog.d("CloudFileManager", "remoteUrl:" + paramString1 + " localFilePath:" + paramString2);
    final String str = a(paramString1);
    EMLog.d("CloudFileManager", "download file: remote url : " + str + " , local file : " + paramString2);
    paramString1 = new File(paramString2);
    EMLog.d("CloudFileManager", "local exists:" + paramString1.exists());
    if (!paramString1.getParentFile().exists()) {
      paramString1.getParentFile().mkdirs();
    }
    paramString1 = HttpClientConfig.getDefaultHttpClient(str, HttpClientConfig.getTimeout(localMap));
    for (;;)
    {
      try
      {
        paramMap = new HttpGet(str);
        a(paramMap, localMap);
        a.a(str, paramString1);
        if (!(paramString1 instanceof HttpClient))
        {
          paramString1 = paramString1.execute(paramMap);
          int i = paramString1.getStatusLine().getStatusCode();
          switch (i)
          {
          case 200: 
            EMLog.e("CloudFileManager", "error response code is :" + i);
            if (paramCloudOperationCallback == null) {
              break label21;
            }
            paramCloudOperationCallback.onError(String.valueOf(i));
            return;
          }
        }
      }
      catch (Exception localException)
      {
        paramMap = localException.getMessage();
        paramString1 = paramMap;
        if (paramMap == null)
        {
          paramMap = localException.toString();
          paramString1 = paramMap;
          if (paramMap == null) {
            paramString1 = "failed to download file";
          }
        }
        if ((paramString1.toLowerCase().contains("refused")) && (NetUtils.hasNetwork(this.d)) && (paramInt > 0))
        {
          new Thread()
          {
            public void run()
            {
              try
              {
                b.a(b.this, this.a, paramString2, localMap, paramCloudOperationCallback, this.e);
                return;
              }
              catch (Exception localException)
              {
                if ((localException != null) && (localException.toString() != null))
                {
                  paramCloudOperationCallback.onError(localException.toString());
                  return;
                }
                paramCloudOperationCallback.onError("failed to download the file : " + this.a);
              }
            }
          }.start();
          return;
          paramString1 = ApacheHttpClientInstrumentation.execute((HttpClient)paramString1, paramMap);
          continue;
          if (a(paramString1, paramCloudOperationCallback, paramString2) <= 0L)
          {
            if (paramCloudOperationCallback == null) {
              break;
            }
            paramCloudOperationCallback.onError("downloaded content size is zero!");
            return;
          }
          if (paramCloudOperationCallback == null) {
            break;
          }
          paramCloudOperationCallback.onSuccess("download successfully");
          return;
          long l = EMHttpClient.getInstance().chatConfig().o();
          if (System.currentTimeMillis() - l <= 600000L)
          {
            if (paramCloudOperationCallback == null) {
              break;
            }
            paramCloudOperationCallback.onError("unauthorized file");
            return;
          }
          if (this.a)
          {
            if (paramCloudOperationCallback == null) {
              break;
            }
            paramCloudOperationCallback.onError("unauthorized file");
            return;
          }
          new Thread()
          {
            public void run()
            {
              String str = EMClient.getInstance().getOptions().getAccessToken(true);
              if (str == null) {
                paramCloudOperationCallback.onError("unauthorized token is null");
              }
              do
              {
                return;
                b.this.a = true;
                if (localMap != null)
                {
                  localMap.put("Authorization", "Bearer " + str);
                  b.this.a(str, paramString2, localMap, paramCloudOperationCallback);
                  return;
                }
                b.this.a = false;
              } while (paramCloudOperationCallback == null);
              paramCloudOperationCallback.onError("unauthorized token is null");
            }
          }.start();
          return;
        }
        EMLog.e("CloudFileManager", paramString1);
      }
      if (paramCloudOperationCallback == null) {
        break;
      }
      paramCloudOperationCallback.onError(paramString1);
      return;
    }
  }
  
  private void a(HttpGet paramHttpGet, Map<String, String> paramMap)
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
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, CloudOperationCallback paramCloudOperationCallback)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramMap, paramCloudOperationCallback, -1, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, CloudOperationCallback paramCloudOperationCallback)
  {
    try
    {
      b(paramString1, paramString2, paramString3, paramString4, paramMap, paramCloudOperationCallback);
      return;
    }
    catch (Exception paramString1)
    {
      EMLog.e("CloudFileManager", "uploadFile error:" + paramString1.toString());
      paramCloudOperationCallback.onError(paramString1.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, Map<String, String> paramMap, CloudOperationCallback paramCloudOperationCallback)
  {
    try
    {
      a(paramString1, paramString2, paramMap, paramCloudOperationCallback, 20);
      return;
    }
    catch (Exception paramMap)
    {
      do
      {
        paramString2 = "failed to download file : " + paramString1;
        paramString1 = paramString2;
        if (paramMap != null)
        {
          paramString1 = paramString2;
          if (paramMap.toString() != null) {
            paramString1 = paramMap.toString();
          }
        }
      } while (paramCloudOperationCallback == null);
      paramCloudOperationCallback.onError(paramString1);
    }
  }
  
  public void downloadFile(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, CloudOperationCallback paramCloudOperationCallback)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramCloudOperationCallback != null) {
        paramCloudOperationCallback.onError("remotefilepath is null or empty");
      }
      EMLog.e("CloudFileManager", "remotefilepath is null or empty");
      return;
    }
    a(HttpClientConfig.getFileRemoteUrl(paramString1), paramString2, paramMap, paramCloudOperationCallback);
  }
  
  public void uploadFileInBackground(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final Map<String, String> paramMap, final CloudOperationCallback paramCloudOperationCallback)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          b.a(b.this, paramString1, paramString2, paramString3, paramString4, paramMap, paramCloudOperationCallback);
          return;
        }
        catch (Exception localException)
        {
          if ((localException != null) && (localException.toString() != null))
          {
            EMLog.e("CloudFileManager", localException.toString());
            paramCloudOperationCallback.onError(localException.toString());
            return;
          }
          paramCloudOperationCallback.onError("failed to upload the file : " + paramString1 + " remote path : " + paramString2);
        }
      }
    }.start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/cloud/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */