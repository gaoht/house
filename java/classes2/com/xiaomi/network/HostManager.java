package com.xiaomi.network;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.network.d;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class HostManager
{
  private static HostManagerFactory factory;
  protected static boolean hostLoaded = false;
  protected static Map<String, ArrayList<String>> mReservedHosts = new HashMap();
  private static String sAppName;
  private static String sAppVersion;
  private static HostManager sInstance;
  private final long MAX_REQUEST_FAILURE_CNT = 15L;
  private String currentISP = "isp_prov_city_country_ip";
  private long lastRemoteRequestTimestamp = 0L;
  protected Map<String, Fallbacks> mHostsMapping = new HashMap();
  private long remoteRequestFailureCount = 0L;
  protected Context sAppContext;
  private HostFilter sHostFilter;
  protected HttpGet sHttpGetter;
  private String sUserId = "0";
  
  protected HostManager(Context paramContext, HostFilter paramHostFilter, HttpGet paramHttpGet, String paramString1, String paramString2, String paramString3)
  {
    this.sAppContext = paramContext.getApplicationContext();
    if (this.sAppContext == null) {
      this.sAppContext = paramContext;
    }
    this.sHttpGetter = paramHttpGet;
    if (paramHostFilter == null)
    {
      this.sHostFilter = new a(this);
      this.sUserId = paramString1;
      if (paramString2 == null) {
        break label120;
      }
      label96:
      sAppName = paramString2;
      if (paramString3 == null) {
        break label129;
      }
    }
    for (;;)
    {
      sAppVersion = paramString3;
      return;
      this.sHostFilter = paramHostFilter;
      break;
      label120:
      paramString2 = paramContext.getPackageName();
      break label96;
      label129:
      paramString3 = getVersionName();
    }
  }
  
  public static void addReservedHost(String paramString1, String paramString2)
  {
    ArrayList localArrayList = (ArrayList)mReservedHosts.get(paramString1);
    localMap = mReservedHosts;
    if (localArrayList == null) {}
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramString2);
        mReservedHosts.put(paramString1, localArrayList);
        return;
      }
      finally {}
      if (!localArrayList.contains(paramString2)) {
        localArrayList.add(paramString2);
      }
    }
  }
  
  public static HostManager getInstance()
  {
    try
    {
      if (sInstance == null) {
        throw new IllegalStateException("the host manager is not initialized yet.");
      }
    }
    finally {}
    HostManager localHostManager = sInstance;
    return localHostManager;
  }
  
  private String getVersionName()
  {
    try
    {
      Object localObject = this.sAppContext.getPackageManager().getPackageInfo(this.sAppContext.getPackageName(), 16384);
      if (localObject != null)
      {
        localObject = ((PackageInfo)localObject).versionName;
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return "0";
  }
  
  /* Error */
  public static void init(Context paramContext, HostFilter paramHostFilter, HttpGet paramHttpGet, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 122	com/xiaomi/network/HostManager:sInstance	Lcom/xiaomi/network/HostManager;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 149	com/xiaomi/network/HostManager:factory	Lcom/xiaomi/network/HostManager$HostManagerFactory;
    //   12: ifnonnull +25 -> 37
    //   15: new 2	com/xiaomi/network/HostManager
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: aload_2
    //   22: aload_3
    //   23: aload 4
    //   25: aload 5
    //   27: invokespecial 151	com/xiaomi/network/HostManager:<init>	(Landroid/content/Context;Lcom/xiaomi/network/HostFilter;Lcom/xiaomi/network/HostManager$HttpGet;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   30: putstatic 122	com/xiaomi/network/HostManager:sInstance	Lcom/xiaomi/network/HostManager;
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: getstatic 149	com/xiaomi/network/HostManager:factory	Lcom/xiaomi/network/HostManager$HostManagerFactory;
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokeinterface 155 5 0
    //   49: putstatic 122	com/xiaomi/network/HostManager:sInstance	Lcom/xiaomi/network/HostManager;
    //   52: goto -19 -> 33
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	Context
    //   0	61	1	paramHostFilter	HostFilter
    //   0	61	2	paramHttpGet	HttpGet
    //   0	61	3	paramString1	String
    //   0	61	4	paramString2	String
    //   0	61	5	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   3	33	55	finally
    //   37	52	55	finally
  }
  
  public static <T> String join(Collection<T> paramCollection, String paramString)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localStringBuilder.append(paramCollection.next());
      if (paramCollection.hasNext()) {
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String join(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArrayOfString[0]);
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramArrayOfString[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private ArrayList<Fallback> requestRemoteFallbacks(ArrayList<String> paramArrayList)
  {
    purge();
    Object localObject3;
    synchronized (this.mHostsMapping)
    {
      checkHostMapping();
      localObject3 = this.mHostsMapping.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (!paramArrayList.contains(localObject4)) {
          paramArrayList.add(localObject4);
        }
      }
    }
    synchronized (mReservedHosts)
    {
      localObject3 = mReservedHosts.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (!paramArrayList.contains(localObject4)) {
          paramArrayList.add(localObject4);
        }
      }
    }
    if (!paramArrayList.contains(getHost())) {
      paramArrayList.add(getHost());
    }
    Object localObject4 = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((ArrayList)localObject4).add(null);
      i += 1;
    }
    for (;;)
    {
      int j;
      try
      {
        if (!d.f(this.sAppContext)) {
          break label764;
        }
        ??? = "wifi";
        localObject3 = getRemoteFallbackJSON(paramArrayList, (String)???, this.sUserId);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = new JSONObject((String)localObject3);
          if ("OK".equalsIgnoreCase(((JSONObject)localObject3).getString("S")))
          {
            JSONObject localJSONObject1 = ((JSONObject)localObject3).getJSONObject("R");
            String str1 = localJSONObject1.getString("province");
            String str2 = localJSONObject1.getString("city");
            String str3 = localJSONObject1.getString("isp");
            String str4 = localJSONObject1.getString("ip");
            String str5 = localJSONObject1.getString("country");
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject((String)???);
            localObject3 = ???;
            if (((String)???).equals("wap")) {
              localObject3 = getActiveNetworkLabel();
            }
            com.xiaomi.channel.commonutils.logger.b.a("get bucket: ip = " + str4 + " net = " + str3 + (String)localObject3 + " hosts = " + localJSONObject2.toString());
            i = 0;
            if (i < paramArrayList.size())
            {
              localObject3 = (String)paramArrayList.get(i);
              ??? = localJSONObject2.optJSONArray((String)localObject3);
              if (??? == null)
              {
                com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + (String)localObject3);
              }
              else
              {
                localObject3 = new Fallback((String)localObject3);
                j = 0;
                if (j < ((JSONArray)???).length())
                {
                  String str6 = ((JSONArray)???).getString(j);
                  if (TextUtils.isEmpty(str6)) {
                    break label772;
                  }
                  ((Fallback)localObject3).a(new c(str6, ((JSONArray)???).length() - j));
                  break label772;
                }
                ((ArrayList)localObject4).set(i, localObject3);
                ((Fallback)localObject3).g = str5;
                ((Fallback)localObject3).c = str1;
                ((Fallback)localObject3).e = str3;
                ((Fallback)localObject3).f = str4;
                ((Fallback)localObject3).d = str2;
                if (localJSONObject1.has("stat-percent")) {
                  ((Fallback)localObject3).a(localJSONObject1.getDouble("stat-percent"));
                }
                if (localJSONObject1.has("stat-domain")) {
                  ((Fallback)localObject3).b(localJSONObject1.getString("stat-domain"));
                }
                if (localJSONObject1.has("ttl")) {
                  ((Fallback)localObject3).a(localJSONObject1.getInt("ttl") * 1000L);
                }
                setCurrentISP(((Fallback)localObject3).e());
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        com.xiaomi.channel.commonutils.logger.b.a("failed to get bucket " + localException.getMessage());
        i = 0;
        if (i < paramArrayList.size())
        {
          localObject2 = (Fallback)((ArrayList)localObject4).get(i);
          if (localObject2 != null) {
            updateFallbacks((String)paramArrayList.get(i), (Fallback)localObject2);
          }
          i += 1;
          continue;
        }
        persist();
        return (ArrayList<Fallback>)localObject4;
      }
      i += 1;
      continue;
      label764:
      Object localObject2 = "wap";
      continue;
      label772:
      j += 1;
    }
  }
  
  public static void setHostManagerFactory(HostManagerFactory paramHostManagerFactory)
  {
    try
    {
      factory = paramHostManagerFactory;
      sInstance = null;
      return;
    }
    finally
    {
      paramHostManagerFactory = finally;
      throw paramHostManagerFactory;
    }
  }
  
  protected boolean checkHostMapping()
  {
    synchronized (this.mHostsMapping)
    {
      if (!hostLoaded)
      {
        hostLoaded = true;
        this.mHostsMapping.clear();
        try
        {
          String str = loadHosts();
          if (!TextUtils.isEmpty(str))
          {
            fromJSON(str);
            com.xiaomi.channel.commonutils.logger.b.a("loading the new hosts succeed");
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          com.xiaomi.channel.commonutils.logger.b.a("load host exception " + localThrowable.getMessage());
          return false;
        }
      }
      return true;
    }
  }
  
  public void clear()
  {
    synchronized (this.mHostsMapping)
    {
      this.mHostsMapping.clear();
      return;
    }
  }
  
  protected void fromJSON(String paramString)
  {
    synchronized (this.mHostsMapping)
    {
      this.mHostsMapping.clear();
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        Fallbacks localFallbacks = new Fallbacks().fromJSON(paramString.getJSONObject(i));
        this.mHostsMapping.put(localFallbacks.getHost(), localFallbacks);
        i += 1;
      }
      return;
    }
  }
  
  public String getActiveNetworkLabel()
  {
    if (this.sAppContext == null) {
      return "unknown";
    }
    try
    {
      Object localObject = (ConnectivityManager)this.sAppContext.getSystemService("connectivity");
      if (localObject == null) {
        return "unknown";
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return "unknown";
      }
      if (((NetworkInfo)localObject).getType() == 1)
      {
        localObject = (WifiManager)this.sAppContext.getSystemService("wifi");
        if ((localObject != null) && (((WifiManager)localObject).getConnectionInfo() != null)) {
          return "WIFI-" + ((WifiManager)localObject).getConnectionInfo().getSSID();
        }
      }
      else
      {
        localObject = ((NetworkInfo)localObject).getTypeName() + "-" + ((NetworkInfo)localObject).getSubtypeName();
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable) {}
    return "unknown";
  }
  
  public Fallback getFallbacksByHost(String paramString)
  {
    return getFallbacksByHost(paramString, true);
  }
  
  public Fallback getFallbacksByHost(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the host is empty");
    }
    Object localObject;
    if (!this.sHostFilter.a(paramString)) {
      localObject = null;
    }
    Fallback localFallback;
    do
    {
      return (Fallback)localObject;
      localFallback = getLocalFallback(paramString);
      if (localFallback == null) {
        break;
      }
      localObject = localFallback;
    } while (localFallback.b());
    if ((paramBoolean) && (d.d(this.sAppContext)))
    {
      localObject = requestRemoteFallback(paramString);
      if (localObject != null) {
        return (Fallback)localObject;
      }
    }
    return new b(this, paramString, localFallback);
  }
  
  public Fallback getFallbacksByURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the url is empty");
    }
    return getFallbacksByHost(new URL(paramString).getHost(), true);
  }
  
  protected String getHost()
  {
    return "resolver.gslb.mi-idc.com";
  }
  
  protected Fallback getLocalFallback(String paramString)
  {
    synchronized (this.mHostsMapping)
    {
      checkHostMapping();
      paramString = (Fallbacks)this.mHostsMapping.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.getFallback();
        if (paramString != null) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  protected String getProcessName()
  {
    Object localObject = ((ActivityManager)this.sAppContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == Process.myPid()) {
          return localRunningAppProcessInfo.processName;
        }
      }
    }
    return "com.xiaomi";
  }
  
  protected String getRemoteFallbackJSON(ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.xiaomi.channel.commonutils.network.a("type", paramString1));
    localArrayList.add(new com.xiaomi.channel.commonutils.network.a("uuid", paramString2));
    localArrayList.add(new com.xiaomi.channel.commonutils.network.a("list", join(paramArrayList, ",")));
    paramArrayList = getLocalFallback("resolver.gslb.mi-idc.com");
    paramString1 = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", new Object[] { "resolver.gslb.mi-idc.com" });
    if (paramArrayList == null)
    {
      ((ArrayList)localObject).add(paramString1);
      paramArrayList = (ArrayList<String>)localObject;
      paramString1 = paramArrayList.iterator();
      paramArrayList = null;
    }
    for (;;)
    {
      if (!paramString1.hasNext()) {
        break label283;
      }
      paramArrayList = Uri.parse((String)paramString1.next()).buildUpon();
      paramString2 = localArrayList.iterator();
      for (;;)
      {
        if (paramString2.hasNext())
        {
          localObject = (com.xiaomi.channel.commonutils.network.c)paramString2.next();
          paramArrayList.appendQueryParameter(((com.xiaomi.channel.commonutils.network.c)localObject).a(), ((com.xiaomi.channel.commonutils.network.c)localObject).b());
          continue;
          paramArrayList = paramArrayList.a(paramString1);
          break;
        }
      }
      try
      {
        if (this.sHttpGetter == null) {
          return d.a(this.sAppContext, new URL(paramArrayList.toString()));
        }
        paramArrayList = this.sHttpGetter.a(paramArrayList.toString());
        return paramArrayList;
      }
      catch (IOException paramArrayList)
      {
        com.xiaomi.channel.commonutils.logger.b.a("network ioErr: " + paramArrayList.getMessage());
      }
    }
    label283:
    if (paramArrayList != null) {
      throw paramArrayList;
    }
    return null;
  }
  
  /* Error */
  protected String loadHosts()
  {
    // Byte code:
    //   0: new 580	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 76	com/xiaomi/network/HostManager:sAppContext	Landroid/content/Context;
    //   8: invokevirtual 584	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: aload_0
    //   12: invokevirtual 586	com/xiaomi/network/HostManager:getProcessName	()Ljava/lang/String;
    //   15: invokespecial 589	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 592	java/io/File:isFile	()Z
    //   23: ifeq +109 -> 132
    //   26: new 594	java/io/BufferedReader
    //   29: dup
    //   30: new 596	java/io/InputStreamReader
    //   33: dup
    //   34: new 598	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 601	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 604	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 607	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: new 167	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 610	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +50 -> 119
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: aload 4
    //   77: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: goto -22 -> 59
    //   84: astore_3
    //   85: aload_2
    //   86: astore_1
    //   87: new 167	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 397
    //   97: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 288	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   113: aload_2
    //   114: invokestatic 614	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   117: aconst_null
    //   118: areturn
    //   119: aload_2
    //   120: astore_1
    //   121: aload_3
    //   122: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_3
    //   126: aload_2
    //   127: invokestatic 614	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   130: aload_3
    //   131: areturn
    //   132: aconst_null
    //   133: invokestatic 614	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_3
    //   141: aload_1
    //   142: astore_2
    //   143: aload_3
    //   144: invokestatic 614	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/Reader;)V
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: aload_1
    //   151: astore_3
    //   152: goto -9 -> 143
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_2
    //   158: goto -73 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	HostManager
    //   18	103	1	localObject1	Object
    //   138	13	1	localObject2	Object
    //   48	100	2	localObject3	Object
    //   149	1	2	localObject4	Object
    //   157	1	2	localObject5	Object
    //   58	17	3	localStringBuilder	StringBuilder
    //   84	38	3	localThrowable1	Throwable
    //   125	27	3	localObject6	Object
    //   155	1	3	localThrowable2	Throwable
    //   65	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   51	59	84	java/lang/Throwable
    //   61	67	84	java/lang/Throwable
    //   74	81	84	java/lang/Throwable
    //   121	126	84	java/lang/Throwable
    //   0	49	138	finally
    //   51	59	149	finally
    //   61	67	149	finally
    //   74	81	149	finally
    //   87	113	149	finally
    //   121	126	149	finally
    //   0	49	155	java/lang/Throwable
  }
  
  /* Error */
  public void persist()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 199	com/xiaomi/network/HostManager:purge	()V
    //   4: aload_0
    //   5: getfield 52	com/xiaomi/network/HostManager:mHostsMapping	Ljava/util/Map;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: new 618	java/io/BufferedWriter
    //   14: dup
    //   15: new 620	java/io/OutputStreamWriter
    //   18: dup
    //   19: aload_0
    //   20: getfield 76	com/xiaomi/network/HostManager:sAppContext	Landroid/content/Context;
    //   23: aload_0
    //   24: invokevirtual 586	com/xiaomi/network/HostManager:getProcessName	()Ljava/lang/String;
    //   27: iconst_0
    //   28: invokevirtual 624	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   31: invokespecial 627	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   34: invokespecial 630	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   37: astore_2
    //   38: aload_0
    //   39: invokevirtual 634	com/xiaomi/network/HostManager:toJSON	()Lorg/json/JSONArray;
    //   42: invokevirtual 635	org/json/JSONArray:toString	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +8 -> 58
    //   53: aload_2
    //   54: aload_3
    //   55: invokevirtual 638	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   58: aload_2
    //   59: invokevirtual 641	java/io/BufferedWriter:close	()V
    //   62: aload_1
    //   63: monitorexit
    //   64: return
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 644	java/io/IOException:printStackTrace	()V
    //   70: goto -8 -> 62
    //   73: astore_2
    //   74: aload_1
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 645	org/json/JSONException:printStackTrace	()V
    //   83: goto -21 -> 62
    //   86: astore_2
    //   87: aload_2
    //   88: invokevirtual 646	java/lang/Exception:printStackTrace	()V
    //   91: goto -29 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	HostManager
    //   37	22	2	localBufferedWriter	java.io.BufferedWriter
    //   65	2	2	localIOException	IOException
    //   73	4	2	localObject	Object
    //   78	2	2	localJSONException	org.json.JSONException
    //   86	2	2	localException	Exception
    //   45	10	3	str	String
    // Exception table:
    //   from	to	target	type
    //   11	58	65	java/io/IOException
    //   58	62	65	java/io/IOException
    //   11	58	73	finally
    //   58	62	73	finally
    //   62	64	73	finally
    //   66	70	73	finally
    //   74	76	73	finally
    //   79	83	73	finally
    //   87	91	73	finally
    //   11	58	78	org/json/JSONException
    //   58	62	78	org/json/JSONException
    //   11	58	86	java/lang/Exception
    //   58	62	86	java/lang/Exception
  }
  
  public void purge()
  {
    synchronized (this.mHostsMapping)
    {
      Iterator localIterator1 = this.mHostsMapping.values().iterator();
      if (localIterator1.hasNext()) {
        ((Fallbacks)localIterator1.next()).purge(false);
      }
    }
    int i = 0;
    for (;;)
    {
      if (i == 0)
      {
        Iterator localIterator2 = this.mHostsMapping.keySet().iterator();
        String str;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          str = (String)localIterator2.next();
        } while (!((Fallbacks)this.mHostsMapping.get(str)).getFallbacks().isEmpty());
        this.mHostsMapping.remove(str);
        i = 0;
      }
      else
      {
        return;
        i = 1;
      }
    }
  }
  
  public void refreshFallbacks()
  {
    for (;;)
    {
      int i;
      synchronized (this.mHostsMapping)
      {
        checkHostMapping();
        ArrayList localArrayList = new ArrayList(this.mHostsMapping.keySet());
        i = localArrayList.size() - 1;
        if (i >= 0)
        {
          Fallbacks localFallbacks = (Fallbacks)this.mHostsMapping.get(localArrayList.get(i));
          if ((localFallbacks == null) || (localFallbacks.getFallback() == null)) {
            break label140;
          }
          localArrayList.remove(i);
          break label140;
        }
        ??? = requestRemoteFallbacks(localArrayList);
        i = 0;
        if (i < localArrayList.size())
        {
          if (((ArrayList)???).get(i) != null) {
            updateFallbacks((String)localArrayList.get(i), (Fallback)((ArrayList)???).get(i));
          }
          i += 1;
        }
      }
      return;
      label140:
      i -= 1;
    }
  }
  
  protected Fallback requestRemoteFallback(String paramString)
  {
    if (System.currentTimeMillis() - this.lastRemoteRequestTimestamp > this.remoteRequestFailureCount * 60L * 1000L)
    {
      this.lastRemoteRequestTimestamp = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      paramString = (Fallback)requestRemoteFallbacks(localArrayList).get(0);
      if (paramString != null)
      {
        this.remoteRequestFailureCount = 0L;
        return paramString;
      }
      if (this.remoteRequestFailureCount < 15L) {
        this.remoteRequestFailureCount += 1L;
      }
    }
    return null;
  }
  
  public void setCurrentISP(String paramString)
  {
    this.currentISP = paramString;
  }
  
  protected JSONArray toJSON()
  {
    synchronized (this.mHostsMapping)
    {
      JSONArray localJSONArray1 = new JSONArray();
      Iterator localIterator = this.mHostsMapping.values().iterator();
      if (localIterator.hasNext()) {
        localJSONArray1.put(((Fallbacks)localIterator.next()).toJSON());
      }
    }
    return localJSONArray2;
  }
  
  public void updateFallbacks(String paramString, Fallback paramFallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFallback == null)) {
      throw new IllegalArgumentException("the argument is invalid " + paramString + ", " + paramFallback);
    }
    if (this.sHostFilter.a(paramString)) {
      synchronized (this.mHostsMapping)
      {
        checkHostMapping();
        if (this.mHostsMapping.containsKey(paramString))
        {
          ((Fallbacks)this.mHostsMapping.get(paramString)).addFallback(paramFallback);
          return;
        }
        Fallbacks localFallbacks = new Fallbacks(paramString);
        localFallbacks.addFallback(paramFallback);
        this.mHostsMapping.put(paramString, localFallbacks);
      }
    }
  }
  
  public static abstract interface HostManagerFactory
  {
    public abstract HostManager a(Context paramContext, HostFilter paramHostFilter, HostManager.HttpGet paramHttpGet, String paramString);
  }
  
  public static abstract interface HttpGet
  {
    public abstract String a(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/HostManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */