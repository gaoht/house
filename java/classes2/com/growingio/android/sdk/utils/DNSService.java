package com.growingio.android.sdk.utils;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.maa.android.agent.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DNSService
{
  private static final Object e = new Object();
  private static DNSService f;
  private boolean a = true;
  private int b = 0;
  private final HttpDNSTask c = new HttpDNSTask(null);
  private final ArrayList<HostInformation> d = new ArrayList();
  
  public static DNSService a()
  {
    synchronized (e)
    {
      if (f == null)
      {
        f = new DNSService();
        f.b();
      }
      DNSService localDNSService = f;
      return localDNSService;
    }
  }
  
  private void b()
  {
    Object localObject = PersistUtil.b();
    if (localObject != null) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int j = ((JSONArray)localObject).length();
        int i = 0;
        while (i < j)
        {
          HostInformation localHostInformation = new HostInformation();
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          HostInformation.a(localHostInformation, localJSONObject.getLong("ttl"));
          HostInformation.b(localHostInformation, localJSONObject.getLong("queryTime"));
          HostInformation.a(localHostInformation, localJSONObject.getString("hostName"));
          HostInformation.b(localHostInformation, localJSONObject.getString("ip"));
          this.d.add(localHostInformation);
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void c()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        HostInformation localHostInformation = (HostInformation)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ttl", HostInformation.a(localHostInformation));
        localJSONObject.put("queryTime", HostInformation.b(localHostInformation));
        localJSONObject.put("hostName", HostInformation.c(localHostInformation));
        localJSONObject.put("ip", HostInformation.d(localHostInformation));
        localJSONArray.put(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      PersistUtil.b(localJSONArray.toString());
    }
  }
  
  private void c(HostInformation paramHostInformation)
  {
    this.d.add(paramHostInformation);
    c();
  }
  
  private boolean d()
  {
    String str2 = null;
    String str1 = str2;
    for (;;)
    {
      int i;
      try
      {
        if (Build.VERSION.SDK_INT >= 14)
        {
          str1 = str2;
          str2 = System.getProperty("http.proxyHost");
          str1 = str2;
          localObject = System.getProperty("http.proxyPort");
          if (localObject == null) {
            break label101;
          }
          str1 = str2;
          i = Integer.parseInt((String)localObject);
          str1 = str2;
        }
        else
        {
          str1 = str2;
          localObject = AppState.l().k();
          str1 = str2;
          str2 = Proxy.getHost((Context)localObject);
          str1 = str2;
          i = Proxy.getPort((Context)localObject);
          str1 = str2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = -1;
      }
      do
      {
        return false;
      } while ((str1 == null) || (i == -1));
      return true;
      label101:
      Object localObject = "-1";
    }
  }
  
  public HostInformation a(String paramString, ArrayList<HostInformation> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HostInformation localHostInformation = (HostInformation)paramArrayList.next();
      if (HostInformation.c(localHostInformation).equals(paramString)) {
        return localHostInformation;
      }
    }
    return null;
  }
  
  HostInformation a(String paramString, boolean paramBoolean)
  {
    if (!this.a)
    {
      LogUtil.e("GrowingIO.DNSService", "DNSService disable");
      return null;
    }
    if (d())
    {
      LogUtil.d("GrowingIO.DNSService", new Object[] { "ProxyExist" });
      return null;
    }
    if (!a(paramString))
    {
      LogUtil.d("GrowingIO.DNSService", new Object[] { "Unable to use HttpDNS: ", paramString });
      return null;
    }
    HostInformation localHostInformation = a(paramString, this.d);
    if ((localHostInformation != null) && (!localHostInformation.a()))
    {
      LogUtil.d("GrowingIO.DNSService", new Object[] { "Available hostInformation: ", localHostInformation });
      return localHostInformation;
    }
    b(localHostInformation);
    if (paramBoolean)
    {
      LogUtil.d("GrowingIO.DNSService", new Object[] { "onlyInCache" });
      return null;
    }
    this.c.a(paramString);
    return this.c.a();
  }
  
  void a(HostInformation paramHostInformation)
  {
    b(paramHostInformation);
    int i = this.b + 1;
    this.b = i;
    if (i >= 3) {
      this.a = false;
    }
  }
  
  public boolean a(String paramString)
  {
    return NetworkConfig.a().c().substring("http://".length()).indexOf(paramString) == 0;
  }
  
  void b(HostInformation paramHostInformation)
  {
    if (paramHostInformation == null) {
      return;
    }
    this.d.remove(paramHostInformation);
    c();
  }
  
  public static class HostInformation
  {
    private long a;
    private long b = System.currentTimeMillis() / 1000L;
    private String c;
    private String d;
    
    void a(long paramLong)
    {
      this.a = paramLong;
    }
    
    void a(String paramString)
    {
      this.d = paramString;
    }
    
    boolean a()
    {
      return this.b + this.a < System.currentTimeMillis() / 1000L;
    }
    
    String b()
    {
      return this.d;
    }
    
    public void b(String paramString)
    {
      this.c = paramString;
    }
    
    String c()
    {
      return this.c;
    }
    
    public String toString()
    {
      return "HostInformation [hostName=" + this.c + ", ip=" + this.d + ", ttl=" + this.a + ", queryTime=" + this.b + "]";
    }
  }
  
  @Instrumented
  private class HttpDNSTask
  {
    private String b;
    private int c;
    
    private HttpDNSTask() {}
    
    /* Error */
    public DNSService.HostInformation a()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: new 32	java/lang/StringBuilder
      //   6: dup
      //   7: invokespecial 33	java/lang/StringBuilder:<init>	()V
      //   10: ldc 35
      //   12: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   15: aload_0
      //   16: getfield 41	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:b	Ljava/lang/String;
      //   19: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   22: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   25: astore_3
      //   26: ldc 47
      //   28: iconst_2
      //   29: anewarray 4	java/lang/Object
      //   32: dup
      //   33: iconst_0
      //   34: ldc 49
      //   36: aastore
      //   37: dup
      //   38: iconst_1
      //   39: aload_3
      //   40: aastore
      //   41: invokestatic 55	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   44: new 57	java/net/URL
      //   47: dup
      //   48: aload_3
      //   49: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;)V
      //   52: astore_3
      //   53: aload_3
      //   54: instanceof 57
      //   57: ifne +142 -> 199
      //   60: aload_3
      //   61: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   64: astore_3
      //   65: aload_3
      //   66: checkcast 66	java/net/HttpURLConnection
      //   69: astore_3
      //   70: aload_3
      //   71: sipush 10000
      //   74: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   77: aload_3
      //   78: sipush 10000
      //   81: invokevirtual 73	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   84: aload_3
      //   85: invokevirtual 77	java/net/HttpURLConnection:getResponseCode	()I
      //   88: sipush 200
      //   91: if_icmpne +263 -> 354
      //   94: aload_3
      //   95: invokevirtual 81	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   98: astore 4
      //   100: new 83	java/io/BufferedReader
      //   103: dup
      //   104: new 85	java/io/InputStreamReader
      //   107: dup
      //   108: aload 4
      //   110: ldc 87
      //   112: invokespecial 90	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
      //   115: invokespecial 93	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   118: astore 5
      //   120: new 32	java/lang/StringBuilder
      //   123: dup
      //   124: invokespecial 33	java/lang/StringBuilder:<init>	()V
      //   127: astore 6
      //   129: aload 5
      //   131: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   134: astore 7
      //   136: aload 7
      //   138: ifnull +72 -> 210
      //   141: aload 6
      //   143: aload 7
      //   145: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: pop
      //   149: goto -20 -> 129
      //   152: astore 5
      //   154: aload 5
      //   156: invokevirtual 99	java/lang/Exception:printStackTrace	()V
      //   159: aload_3
      //   160: ifnull +7 -> 167
      //   163: aload_3
      //   164: invokevirtual 102	java/net/HttpURLConnection:disconnect	()V
      //   167: aload 4
      //   169: ifnull +8 -> 177
      //   172: aload 4
      //   174: invokevirtual 107	java/io/InputStream:close	()V
      //   177: aload_0
      //   178: getfield 109	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:c	I
      //   181: ifle +227 -> 408
      //   184: aload_0
      //   185: aload_0
      //   186: getfield 109	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:c	I
      //   189: iconst_1
      //   190: isub
      //   191: putfield 109	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:c	I
      //   194: aload_0
      //   195: invokevirtual 111	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:a	()Lcom/growingio/android/sdk/utils/DNSService$HostInformation;
      //   198: areturn
      //   199: aload_3
      //   200: checkcast 57	java/net/URL
      //   203: invokestatic 116	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
      //   206: astore_3
      //   207: goto -142 -> 65
      //   210: new 118	org/json/JSONObject
      //   213: dup
      //   214: aload 6
      //   216: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   219: invokespecial 119	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   222: astore 5
      //   224: aload 5
      //   226: ldc 121
      //   228: invokevirtual 125	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   231: astore 6
      //   233: aload 5
      //   235: ldc 127
      //   237: invokevirtual 131	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   240: astore 7
      //   242: aload 4
      //   244: astore 5
      //   246: aload 6
      //   248: ifnull +109 -> 357
      //   251: aload 4
      //   253: astore 5
      //   255: aload 6
      //   257: aload_0
      //   258: getfield 41	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:b	Ljava/lang/String;
      //   261: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   264: ifeq +93 -> 357
      //   267: ldc2_w 138
      //   270: lstore_1
      //   271: aload 7
      //   273: ifnonnull +70 -> 343
      //   276: aconst_null
      //   277: astore 5
      //   279: goto +198 -> 477
      //   282: new 141	com/growingio/android/sdk/utils/DNSService$HostInformation
      //   285: dup
      //   286: invokespecial 142	com/growingio/android/sdk/utils/DNSService$HostInformation:<init>	()V
      //   289: astore 6
      //   291: aload 6
      //   293: aload_0
      //   294: getfield 41	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:b	Ljava/lang/String;
      //   297: invokevirtual 144	com/growingio/android/sdk/utils/DNSService$HostInformation:b	(Ljava/lang/String;)V
      //   300: aload 6
      //   302: lload_1
      //   303: invokevirtual 147	com/growingio/android/sdk/utils/DNSService$HostInformation:a	(J)V
      //   306: aload 6
      //   308: aload 5
      //   310: invokevirtual 149	com/growingio/android/sdk/utils/DNSService$HostInformation:a	(Ljava/lang/String;)V
      //   313: aload_0
      //   314: getfield 18	com/growingio/android/sdk/utils/DNSService$HttpDNSTask:a	Lcom/growingio/android/sdk/utils/DNSService;
      //   317: aload 6
      //   319: invokestatic 152	com/growingio/android/sdk/utils/DNSService:a	(Lcom/growingio/android/sdk/utils/DNSService;Lcom/growingio/android/sdk/utils/DNSService$HostInformation;)V
      //   322: aload_3
      //   323: ifnull +7 -> 330
      //   326: aload_3
      //   327: invokevirtual 102	java/net/HttpURLConnection:disconnect	()V
      //   330: aload 4
      //   332: ifnull +8 -> 340
      //   335: aload 4
      //   337: invokevirtual 107	java/io/InputStream:close	()V
      //   340: aload 6
      //   342: areturn
      //   343: aload 7
      //   345: iconst_0
      //   346: invokevirtual 157	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   349: astore 5
      //   351: goto +126 -> 477
      //   354: aconst_null
      //   355: astore 5
      //   357: aload_3
      //   358: ifnull +7 -> 365
      //   361: aload_3
      //   362: invokevirtual 102	java/net/HttpURLConnection:disconnect	()V
      //   365: aload 5
      //   367: ifnull -190 -> 177
      //   370: aload 5
      //   372: invokevirtual 107	java/io/InputStream:close	()V
      //   375: goto -198 -> 177
      //   378: astore_3
      //   379: goto -202 -> 177
      //   382: astore_3
      //   383: aconst_null
      //   384: astore 4
      //   386: aload 5
      //   388: ifnull +8 -> 396
      //   391: aload 5
      //   393: invokevirtual 102	java/net/HttpURLConnection:disconnect	()V
      //   396: aload 4
      //   398: ifnull +8 -> 406
      //   401: aload 4
      //   403: invokevirtual 107	java/io/InputStream:close	()V
      //   406: aload_3
      //   407: athrow
      //   408: aconst_null
      //   409: areturn
      //   410: astore_3
      //   411: goto -71 -> 340
      //   414: astore_3
      //   415: goto -238 -> 177
      //   418: astore 4
      //   420: goto -14 -> 406
      //   423: astore 6
      //   425: aconst_null
      //   426: astore 4
      //   428: aload_3
      //   429: astore 5
      //   431: aload 6
      //   433: astore_3
      //   434: goto -48 -> 386
      //   437: astore 6
      //   439: aload_3
      //   440: astore 5
      //   442: aload 6
      //   444: astore_3
      //   445: goto -59 -> 386
      //   448: astore 6
      //   450: aload_3
      //   451: astore 5
      //   453: aload 6
      //   455: astore_3
      //   456: goto -70 -> 386
      //   459: astore 5
      //   461: aconst_null
      //   462: astore_3
      //   463: aconst_null
      //   464: astore 4
      //   466: goto -312 -> 154
      //   469: astore 5
      //   471: aconst_null
      //   472: astore 4
      //   474: goto -320 -> 154
      //   477: aload 5
      //   479: ifnonnull -197 -> 282
      //   482: ldc2_w 158
      //   485: lstore_1
      //   486: goto -204 -> 282
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	489	0	this	HttpDNSTask
      //   270	216	1	l	long
      //   25	337	3	localObject1	Object
      //   378	1	3	localIOException1	java.io.IOException
      //   382	25	3	localObject2	Object
      //   410	1	3	localIOException2	java.io.IOException
      //   414	15	3	localIOException3	java.io.IOException
      //   433	30	3	localObject3	Object
      //   98	304	4	localInputStream	java.io.InputStream
      //   418	1	4	localIOException4	java.io.IOException
      //   426	47	4	localObject4	Object
      //   1	129	5	localBufferedReader	java.io.BufferedReader
      //   152	3	5	localException1	Exception
      //   222	230	5	localObject5	Object
      //   459	1	5	localException2	Exception
      //   469	9	5	localException3	Exception
      //   127	214	6	localObject6	Object
      //   423	9	6	localObject7	Object
      //   437	6	6	localObject8	Object
      //   448	6	6	localObject9	Object
      //   134	210	7	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   100	129	152	java/lang/Exception
      //   129	136	152	java/lang/Exception
      //   141	149	152	java/lang/Exception
      //   210	242	152	java/lang/Exception
      //   255	267	152	java/lang/Exception
      //   282	322	152	java/lang/Exception
      //   343	351	152	java/lang/Exception
      //   370	375	378	java/io/IOException
      //   44	65	382	finally
      //   65	70	382	finally
      //   199	207	382	finally
      //   335	340	410	java/io/IOException
      //   172	177	414	java/io/IOException
      //   401	406	418	java/io/IOException
      //   70	100	423	finally
      //   100	129	437	finally
      //   129	136	437	finally
      //   141	149	437	finally
      //   210	242	437	finally
      //   255	267	437	finally
      //   282	322	437	finally
      //   343	351	437	finally
      //   154	159	448	finally
      //   44	65	459	java/lang/Exception
      //   65	70	459	java/lang/Exception
      //   199	207	459	java/lang/Exception
      //   70	100	469	java/lang/Exception
    }
    
    void a(String paramString)
    {
      this.b = paramString;
      this.c = 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/DNSService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */