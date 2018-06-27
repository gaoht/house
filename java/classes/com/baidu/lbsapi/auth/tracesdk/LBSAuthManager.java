package com.baidu.lbsapi.auth.tracesdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LBSAuthManager
{
  public static final int CODE_AUTHENTICATE_SUCC = 0;
  public static final int CODE_AUTHENTICATING = 602;
  public static final int CODE_INNER_ERROR = -1;
  public static final int CODE_KEY_NOT_EXIST = 101;
  public static final int CODE_NETWORK_FAILED = -11;
  public static final int CODE_NETWORK_INVALID = -10;
  public static final int CODE_UNAUTHENTICATE = 601;
  public static final String VERSION = "1.0.21.20161104";
  private static Context a;
  private static l d = null;
  private static int e = 0;
  private static Hashtable f = new Hashtable();
  private static LBSAuthManager g;
  private c b = null;
  private e c = null;
  private final Handler h = new h(this, Looper.getMainLooper());
  
  private LBSAuthManager(Context paramContext)
  {
    a = paramContext;
    if ((d != null) && (!d.isAlive())) {
      d = null;
    }
    a.b("BaiduApiAuth SDK Version:1.0.21.20161104");
    d();
  }
  
  private int a(String paramString)
  {
    i = -1;
    int j = i;
    try
    {
      paramString = new JSONObject(paramString);
      j = i;
      if (!paramString.has("status"))
      {
        j = i;
        paramString.put("status", -1);
      }
      j = i;
      int k = paramString.getInt("status");
      i = k;
      j = k;
      long l1;
      long l2;
      if (paramString.has("current"))
      {
        i = k;
        if (k == 0)
        {
          j = k;
          l1 = paramString.getLong("current");
          j = k;
          l2 = System.currentTimeMillis();
          j = k;
          if ((l2 - l1) / 3600000.0D < 24.0D) {
            break label162;
          }
          i = 601;
        }
      }
      for (;;)
      {
        j = i;
        if ((!paramString.has("current")) || (i != 602)) {
          break;
        }
        j = i;
        l1 = paramString.getLong("current");
        j = i;
        if ((System.currentTimeMillis() - l1) / 1000L <= 180.0D) {
          break;
        }
        return 601;
        label162:
        j = k;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        j = k;
        boolean bool = localSimpleDateFormat.format(Long.valueOf(l2)).equals(localSimpleDateFormat.format(Long.valueOf(l1)));
        i = k;
        if (!bool) {
          i = 601;
        }
      }
      return i;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return j;
    }
  }
  
  /* Error */
  private String a(int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 159	java/io/FileInputStream
    //   6: dup
    //   7: new 161	java/io/File
    //   10: dup
    //   11: new 163	java/lang/StringBuilder
    //   14: dup
    //   15: ldc -91
    //   17: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: iload_1
    //   21: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc -84
    //   26: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore 4
    //   40: new 185	java/io/InputStreamReader
    //   43: dup
    //   44: aload 4
    //   46: invokespecial 188	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: astore 5
    //   51: new 190	java/io/BufferedReader
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 193	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_3
    //   61: aload_3
    //   62: invokevirtual 196	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore_2
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 199	java/io/BufferedReader:close	()V
    //   74: aload 5
    //   76: ifnull +8 -> 84
    //   79: aload 5
    //   81: invokevirtual 200	java/io/InputStreamReader:close	()V
    //   84: aload_2
    //   85: astore_3
    //   86: aload 4
    //   88: ifnull +10 -> 98
    //   91: aload 4
    //   93: invokevirtual 201	java/io/FileInputStream:close	()V
    //   96: aload_2
    //   97: astore_3
    //   98: aload_3
    //   99: areturn
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_2
    //   103: aconst_null
    //   104: astore 5
    //   106: aconst_null
    //   107: astore 4
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 199	java/io/BufferedReader:close	()V
    //   117: aload 5
    //   119: ifnull +8 -> 127
    //   122: aload 5
    //   124: invokevirtual 200	java/io/InputStreamReader:close	()V
    //   127: aload 6
    //   129: astore_3
    //   130: aload 4
    //   132: ifnull -34 -> 98
    //   135: aload 4
    //   137: invokevirtual 201	java/io/FileInputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_2
    //   145: aconst_null
    //   146: astore 5
    //   148: aconst_null
    //   149: astore 4
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 199	java/io/BufferedReader:close	()V
    //   159: aload 5
    //   161: ifnull +8 -> 169
    //   164: aload 5
    //   166: invokevirtual 200	java/io/InputStreamReader:close	()V
    //   169: aload 6
    //   171: astore_3
    //   172: aload 4
    //   174: ifnull -76 -> 98
    //   177: aload 4
    //   179: invokevirtual 201	java/io/FileInputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_2
    //   185: aconst_null
    //   186: astore 5
    //   188: aconst_null
    //   189: astore 4
    //   191: aconst_null
    //   192: astore_3
    //   193: aload_3
    //   194: ifnull +7 -> 201
    //   197: aload_3
    //   198: invokevirtual 199	java/io/BufferedReader:close	()V
    //   201: aload 5
    //   203: ifnull +8 -> 211
    //   206: aload 5
    //   208: invokevirtual 200	java/io/InputStreamReader:close	()V
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 201	java/io/FileInputStream:close	()V
    //   221: aload_2
    //   222: athrow
    //   223: astore_2
    //   224: aconst_null
    //   225: astore 5
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -36 -> 193
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_3
    //   235: goto -42 -> 193
    //   238: astore_2
    //   239: goto -46 -> 193
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_2
    //   245: aconst_null
    //   246: astore 5
    //   248: goto -97 -> 151
    //   251: astore_2
    //   252: aconst_null
    //   253: astore_2
    //   254: goto -103 -> 151
    //   257: astore_2
    //   258: aload_3
    //   259: astore_2
    //   260: goto -109 -> 151
    //   263: astore_2
    //   264: aconst_null
    //   265: astore_2
    //   266: aconst_null
    //   267: astore 5
    //   269: goto -160 -> 109
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_2
    //   275: goto -166 -> 109
    //   278: astore_2
    //   279: aload_3
    //   280: astore_2
    //   281: goto -172 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	LBSAuthManager
    //   0	284	1	paramInt	int
    //   65	32	2	str	String
    //   100	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   102	12	2	localObject1	Object
    //   142	1	2	localIOException1	IOException
    //   144	12	2	localObject2	Object
    //   184	38	2	localObject3	Object
    //   223	1	2	localObject4	Object
    //   232	1	2	localObject5	Object
    //   238	1	2	localObject6	Object
    //   242	1	2	localIOException2	IOException
    //   244	1	2	localObject7	Object
    //   251	1	2	localIOException3	IOException
    //   253	1	2	localObject8	Object
    //   257	1	2	localIOException4	IOException
    //   259	1	2	localObject9	Object
    //   263	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   265	1	2	localObject10	Object
    //   272	1	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   274	1	2	localObject11	Object
    //   278	1	2	localFileNotFoundException4	java.io.FileNotFoundException
    //   280	1	2	localObject12	Object
    //   60	220	3	localObject13	Object
    //   38	179	4	localFileInputStream	java.io.FileInputStream
    //   49	219	5	localInputStreamReader	java.io.InputStreamReader
    //   1	169	6	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   3	40	100	java/io/FileNotFoundException
    //   3	40	142	java/io/IOException
    //   3	40	184	finally
    //   40	51	223	finally
    //   51	61	232	finally
    //   61	66	238	finally
    //   40	51	242	java/io/IOException
    //   51	61	251	java/io/IOException
    //   61	66	257	java/io/IOException
    //   40	51	263	java/io/FileNotFoundException
    //   51	61	272	java/io/FileNotFoundException
    //   61	66	278	java/io/FileNotFoundException
  }
  
  private String a(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    Object localObject;
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i) {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        }
      }
    }
    do
    {
      return (String)localObject;
      paramContext = null;
      try
      {
        localObject = a(i);
        paramContext = (Context)localObject;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      localObject = paramContext;
    } while (paramContext != null);
    return a.getPackageName();
  }
  
  private String a(Context paramContext, String paramString)
  {
    Object localObject2 = "";
    String str = paramContext.getPackageName();
    Object localObject1 = localObject2;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      localObject1 = localObject2;
      if (paramContext.metaData == null)
      {
        localObject1 = localObject2;
        paramContext = (LBSAuthManagerListener)f.get(paramString);
        if (paramContext != null)
        {
          localObject1 = localObject2;
          paramContext.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
        }
      }
      else
      {
        localObject1 = localObject2;
        paramContext = paramContext.metaData.getString("com.baidu.lbsapi.API_KEY");
        if (paramContext != null)
        {
          localObject1 = paramContext;
          if (!paramContext.equals("")) {}
        }
        else
        {
          localObject1 = paramContext;
          localObject2 = (LBSAuthManagerListener)f.get(paramString);
          if (localObject2 != null)
          {
            localObject1 = paramContext;
            ((LBSAuthManagerListener)localObject2).onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
          }
        }
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = (LBSAuthManagerListener)f.get(paramString);
      if (paramContext != null) {
        paramContext.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
      }
      return (String)localObject1;
    }
    return "";
  }
  
  private void a(String paramString1, String paramString2)
  {
    int j = -1;
    Object localObject = paramString1;
    if (paramString1 == null) {}
    int i;
    try
    {
      localObject = e();
      paramString1 = this.h.obtainMessage();
      i = j;
      try
      {
        localObject = new JSONObject((String)localObject);
        i = j;
        if (!((JSONObject)localObject).has("status"))
        {
          i = j;
          ((JSONObject)localObject).put("status", -1);
        }
        i = j;
        if (!((JSONObject)localObject).has("current"))
        {
          i = j;
          ((JSONObject)localObject).put("current", System.currentTimeMillis());
        }
        i = j;
        c(((JSONObject)localObject).toString());
        i = j;
        if (((JSONObject)localObject).has("current"))
        {
          i = j;
          ((JSONObject)localObject).remove("current");
        }
        i = j;
        j = ((JSONObject)localObject).getInt("status");
        i = j;
        paramString1.what = j;
        i = j;
        paramString1.obj = ((JSONObject)localObject).toString();
        i = j;
        localObject = new Bundle();
        i = j;
        ((Bundle)localObject).putString("listenerKey", paramString2);
        i = j;
        paramString1.setData((Bundle)localObject);
        i = j;
        this.h.sendMessage(paramString1);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          paramString1.what = i;
          paramString1.obj = new JSONObject();
          Bundle localBundle = new Bundle();
          localBundle.putString("listenerKey", paramString2);
          paramString1.setData(localBundle);
          this.h.sendMessage(paramString1);
        }
      }
      d.c();
      e -= 1;
      if (a.a) {
        a.a("httpRequest called mAuthCounter-- = " + e);
      }
      if ((e == 0) && (d != null))
      {
        d.a();
        d = null;
      }
      return;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean, String paramString1, Hashtable paramHashtable, String paramString2)
  {
    String str = a(a, paramString2);
    if ((str == null) || (str.equals(""))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
    a.a("url:https://api.map.baidu.com/sdkcs/verify");
    localHashMap.put("output", "json");
    localHashMap.put("ak", str);
    a.a("ak:" + str);
    localHashMap.put("mcode", b.a(a));
    localHashMap.put("from", "lbs_yunsdk");
    if ((paramHashtable != null) && (paramHashtable.size() > 0))
    {
      paramHashtable = paramHashtable.entrySet().iterator();
      while (paramHashtable.hasNext())
      {
        Object localObject = (Map.Entry)paramHashtable.next();
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str, localObject);
        }
      }
    }
    paramHashtable = "";
    try
    {
      str = com.baidu.a.a.a.a.b.a.a(a);
      paramHashtable = str;
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
    a.a("cuid:" + paramHashtable);
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("cuid", paramHashtable);
      localHashMap.put("pcn", a.getPackageName());
      localHashMap.put("version", "1.0.21.20161104");
      paramHashtable = "";
    }
    try
    {
      str = b.c(a);
      paramHashtable = str;
    }
    catch (Exception localException2)
    {
      label330:
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("macaddr", paramHashtable);
      paramHashtable = "";
    }
    try
    {
      str = b.a();
      paramHashtable = str;
    }
    catch (Exception localException1)
    {
      label359:
      label371:
      label476:
      label483:
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("language", paramHashtable);
      if (paramBoolean)
      {
        if (!paramBoolean) {
          break label476;
        }
        paramHashtable = "1";
        localHashMap.put("force", paramHashtable);
      }
      if (paramString1 != null) {
        break label483;
      }
      localHashMap.put("from_service", "");
    }
    for (;;)
    {
      this.b = new c(a);
      this.b.a(localHashMap, new j(this, paramString2));
      return;
      localHashMap.put("cuid", "");
      break;
      localHashMap.put("macaddr", "");
      break label330;
      localHashMap.put("language", "");
      break label359;
      paramHashtable = "0";
      break label371;
      localHashMap.put("from_service", paramString1);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, Hashtable paramHashtable, String[] paramArrayOfString, String paramString2)
  {
    String str = a(a, paramString2);
    if ((str == null) || (str.equals(""))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", "https://api.map.baidu.com/sdkcs/verify");
    localHashMap.put("output", "json");
    localHashMap.put("ak", str);
    localHashMap.put("from", "lbs_yunsdk");
    if ((paramHashtable != null) && (paramHashtable.size() > 0))
    {
      paramHashtable = paramHashtable.entrySet().iterator();
      while (paramHashtable.hasNext())
      {
        Object localObject = (Map.Entry)paramHashtable.next();
        str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str, localObject);
        }
      }
    }
    paramHashtable = "";
    try
    {
      str = com.baidu.a.a.a.a.b.a.a(a);
      paramHashtable = str;
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("cuid", paramHashtable);
      localHashMap.put("pcn", a.getPackageName());
      localHashMap.put("version", "1.0.21.20161104");
      paramHashtable = "";
    }
    try
    {
      str = b.c(a);
      paramHashtable = str;
    }
    catch (Exception localException2)
    {
      label268:
      label297:
      label309:
      label416:
      label423:
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("macaddr", paramHashtable);
      paramHashtable = "";
    }
    try
    {
      str = b.a();
      paramHashtable = str;
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
    if (!TextUtils.isEmpty(paramHashtable))
    {
      localHashMap.put("language", paramHashtable);
      if (paramBoolean)
      {
        if (!paramBoolean) {
          break label416;
        }
        paramHashtable = "1";
        localHashMap.put("force", paramHashtable);
      }
      if (paramString1 != null) {
        break label423;
      }
      localHashMap.put("from_service", "");
    }
    for (;;)
    {
      this.c = new e(a);
      this.c.a(localHashMap, paramArrayOfString, new k(this, paramString2));
      return;
      localHashMap.put("cuid", "");
      break;
      localHashMap.put("macaddr", "");
      break label268;
      localHashMap.put("language", "");
      break label297;
      paramHashtable = "0";
      break label309;
      localHashMap.put("from_service", paramString1);
    }
  }
  
  private boolean b(String paramString)
  {
    String str = a(a, paramString);
    paramString = e();
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("ak")) {
        return true;
      }
      paramString = paramString.getString("ak");
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    return (str != null) && (paramString != null) && (!str.equals(paramString));
  }
  
  private void c(String paramString)
  {
    a.getSharedPreferences("authStatus_" + a(a), 0).edit().putString("status", paramString).commit();
  }
  
  private void d()
  {
    try
    {
      if (d == null)
      {
        Object localObject1 = new l("auth");
        d = (l)localObject1;
        ((l)localObject1).start();
        for (;;)
        {
          localObject1 = d.a;
          if (localObject1 != null) {
            break;
          }
          try
          {
            if (a.a) {
              a.a("wait for create auth thread.");
            }
            Thread.sleep(3L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    finally {}
  }
  
  private String e()
  {
    return a.getSharedPreferences("authStatus_" + a(a), 0).getString("status", "{\"status\":601}");
  }
  
  public static LBSAuthManager getInstance(Context paramContext)
  {
    if (g == null) {}
    for (;;)
    {
      try
      {
        if (g == null) {
          g = new LBSAuthManager(paramContext);
        }
        return g;
      }
      finally {}
      if (paramContext == null)
      {
        if (a.a)
        {
          a.c("input context is null");
          new RuntimeException("here").printStackTrace();
        }
      }
      else {
        a = paramContext;
      }
    }
  }
  
  /* Error */
  public int authenticate(boolean paramBoolean, String paramString, Hashtable paramHashtable, LBSAuthManagerListener paramLBSAuthManagerListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 163	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 540	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   13: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   16: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 6
    //   21: aload 4
    //   23: ifnull +14 -> 37
    //   26: getstatic 51	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:f	Ljava/util/Hashtable;
    //   29: aload 6
    //   31: aload 4
    //   33: invokevirtual 544	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: pop
    //   37: aload_0
    //   38: getstatic 73	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:a	Landroid/content/Context;
    //   41: aload 6
    //   43: invokespecial 368	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +14 -> 64
    //   53: aload 4
    //   55: ldc_w 256
    //   58: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq +9 -> 70
    //   64: ldc 2
    //   66: monitorexit
    //   67: bipush 101
    //   69: ireturn
    //   70: getstatic 44	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:e	I
    //   73: iconst_1
    //   74: iadd
    //   75: putstatic 44	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:e	I
    //   78: getstatic 357	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   81: ifeq +25 -> 106
    //   84: new 163	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 546
    //   91: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: getstatic 44	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:e	I
    //   97: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 361	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: invokespecial 314	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:e	()Ljava/lang/String;
    //   110: astore 4
    //   112: getstatic 357	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   115: ifeq +24 -> 139
    //   118: new 163	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 548
    //   125: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 4
    //   130: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 361	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: aload 4
    //   142: invokespecial 550	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:a	(Ljava/lang/String;)I
    //   145: istore 5
    //   147: iload 5
    //   149: sipush 601
    //   152: if_icmpne +25 -> 177
    //   155: aload_0
    //   156: new 93	org/json/JSONObject
    //   159: dup
    //   160: invokespecial 364	org/json/JSONObject:<init>	()V
    //   163: ldc 97
    //   165: sipush 602
    //   168: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   171: invokevirtual 324	org/json/JSONObject:toString	()Ljava/lang/String;
    //   174: invokespecial 326	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:c	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: invokespecial 88	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:d	()V
    //   181: getstatic 357	com/baidu/lbsapi/auth/tracesdk/a:a	Z
    //   184: ifeq +28 -> 212
    //   187: new 163	java/lang/StringBuilder
    //   190: dup
    //   191: ldc_w 552
    //   194: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: getstatic 42	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:d	Lcom/baidu/lbsapi/auth/tracesdk/l;
    //   200: getfield 507	com/baidu/lbsapi/auth/tracesdk/l:a	Landroid/os/Handler;
    //   203: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 361	com/baidu/lbsapi/auth/tracesdk/a:a	(Ljava/lang/String;)V
    //   212: getstatic 42	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:d	Lcom/baidu/lbsapi/auth/tracesdk/l;
    //   215: ifnull +12 -> 227
    //   218: getstatic 42	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:d	Lcom/baidu/lbsapi/auth/tracesdk/l;
    //   221: getfield 507	com/baidu/lbsapi/auth/tracesdk/l:a	Landroid/os/Handler;
    //   224: ifnonnull +24 -> 248
    //   227: ldc 2
    //   229: monitorexit
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_2
    //   233: ldc 2
    //   235: monitorexit
    //   236: aload_2
    //   237: athrow
    //   238: astore 4
    //   240: aload 4
    //   242: invokevirtual 152	org/json/JSONException:printStackTrace	()V
    //   245: goto -68 -> 177
    //   248: getstatic 42	com/baidu/lbsapi/auth/tracesdk/LBSAuthManager:d	Lcom/baidu/lbsapi/auth/tracesdk/l;
    //   251: getfield 507	com/baidu/lbsapi/auth/tracesdk/l:a	Landroid/os/Handler;
    //   254: new 557	com/baidu/lbsapi/auth/tracesdk/i
    //   257: dup
    //   258: aload_0
    //   259: iload 5
    //   261: iload_1
    //   262: aload 6
    //   264: aload_2
    //   265: aload_3
    //   266: invokespecial 560	com/baidu/lbsapi/auth/tracesdk/i:<init>	(Lcom/baidu/lbsapi/auth/tracesdk/LBSAuthManager;IZLjava/lang/String;Ljava/lang/String;Ljava/util/Hashtable;)V
    //   269: invokevirtual 564	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   272: pop
    //   273: ldc 2
    //   275: monitorexit
    //   276: iload 5
    //   278: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	LBSAuthManager
    //   0	279	1	paramBoolean	boolean
    //   0	279	2	paramString	String
    //   0	279	3	paramHashtable	Hashtable
    //   0	279	4	paramLBSAuthManagerListener	LBSAuthManagerListener
    //   145	132	5	i	int
    //   19	244	6	str	String
    // Exception table:
    //   from	to	target	type
    //   3	21	232	finally
    //   26	37	232	finally
    //   37	48	232	finally
    //   53	64	232	finally
    //   64	67	232	finally
    //   70	106	232	finally
    //   106	139	232	finally
    //   139	147	232	finally
    //   155	177	232	finally
    //   177	212	232	finally
    //   212	227	232	finally
    //   227	230	232	finally
    //   240	245	232	finally
    //   248	276	232	finally
    //   155	177	238	org/json/JSONException
  }
  
  public String getCUID()
  {
    if (a == null) {}
    do
    {
      return "";
      try
      {
        String str = com.baidu.a.a.a.a.b.a.a(a);
        return str;
      }
      catch (Exception localException) {}
    } while (!a.a);
    localException.printStackTrace();
    return "";
  }
  
  public String getDeviceID()
  {
    if (a == null) {}
    do
    {
      return "";
      try
      {
        String str = com.baidu.a.a.a.a.b.a.b(a);
        return str;
      }
      catch (Exception localException) {}
    } while (!a.a);
    localException.printStackTrace();
    return "";
  }
  
  public String getIMEI()
  {
    if (a == null) {}
    do
    {
      return "";
      try
      {
        String str = com.baidu.a.a.a.a.b.a.c(a);
        return str;
      }
      catch (Exception localException) {}
    } while (!a.a);
    localException.printStackTrace();
    return "";
  }
  
  public String getKey()
  {
    if (a == null) {
      return "";
    }
    try
    {
      String str = getPublicKey(a);
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  public String getMCode()
  {
    if (a == null) {
      return "";
    }
    return b.a(a);
  }
  
  public String getPublicKey(Context paramContext)
    throws PackageManager.NameNotFoundException
  {
    String str = paramContext.getPackageName();
    return paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.getString("com.baidu.lbsapi.API_KEY");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/tracesdk/LBSAuthManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */