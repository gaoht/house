package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class bd
{
  private static final String a = "session_start_time";
  private static final String b = "session_end_time";
  private static final String c = "session_id";
  private static String f = null;
  private static Context g = null;
  private final String d = "a_start_time";
  private final String e = "a_end_time";
  
  public static String a()
  {
    return g(g);
  }
  
  private String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    ar localar = ar.b(paramContext);
    String str = b(paramContext);
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("__e", l);
      w.a(g).a(str, localJSONObject, w.a.c);
      a(paramContext);
      paramSharedPreferences = paramSharedPreferences.edit();
      paramSharedPreferences.putString("session_id", str);
      paramSharedPreferences.putLong("session_start_time", System.currentTimeMillis());
      paramSharedPreferences.putLong("session_end_time", 0L);
      paramSharedPreferences.putLong("a_start_time", l);
      paramSharedPreferences.putLong("a_end_time", 0L);
      paramSharedPreferences.putInt("versioncode", Integer.parseInt(bv.a(paramContext)));
      paramSharedPreferences.putString("versionname", bv.b(paramContext));
      paramSharedPreferences.commit();
      localar.a(Boolean.valueOf(true));
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.remove("session_start_time");
    paramSharedPreferences.remove("session_end_time");
    paramSharedPreferences.remove("a_start_time");
    paramSharedPreferences.remove("a_end_time");
    paramSharedPreferences.commit();
  }
  
  private boolean b(SharedPreferences paramSharedPreferences)
  {
    long l1 = paramSharedPreferences.getLong("a_start_time", 0L);
    long l2 = paramSharedPreferences.getLong("a_end_time", 0L);
    long l3 = System.currentTimeMillis();
    if ((l1 != 0L) && (l3 - l1 < AnalyticsConfig.kContinueSessionMillis)) {
      by.e("onResume called before onPause");
    }
    while (l3 - l2 <= AnalyticsConfig.kContinueSessionMillis) {
      return false;
    }
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      l2 = paramSharedPreferences.getLong("session_end_time", 0L);
      l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
    }
    try
    {
      paramSharedPreferences = new JSONObject();
      paramSharedPreferences.put("__f", l1);
      w.a(g).a(str, paramSharedPreferences, w.a.d);
      return true;
    }
    catch (Throwable paramSharedPreferences)
    {
      for (;;) {}
    }
  }
  
  public static String g(Context paramContext)
  {
    if (f == null) {
      f = ba.a(paramContext).getString("session_id", null);
    }
    return f;
  }
  
  public boolean a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = ba.a(paramContext);
    String str = localSharedPreferences.getString("session_id", null);
    if (str == null) {
      return false;
    }
    long l1 = localSharedPreferences.getLong("session_start_time", 0L);
    long l2 = localSharedPreferences.getLong("session_end_time", 0L);
    if ((l2 != 0L) && (Math.abs(l2 - l1) > 86400000L)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("__ii", str);
      localJSONObject.put("__e", l1);
      localJSONObject.put("__f", l2);
      Object localObject1 = AnalyticsConfig.getLocation();
      if (localObject1 != null)
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("lat", localObject1[0]);
        ((JSONObject)localObject2).put("lng", localObject1[1]);
        ((JSONObject)localObject2).put("ts", System.currentTimeMillis());
        localJSONObject.put("__d", localObject2);
      }
      Object localObject2 = Class.forName("android.net.TrafficStats");
      localObject1 = ((Class)localObject2).getMethod("getUidRxBytes", new Class[] { Integer.TYPE });
      localObject2 = ((Class)localObject2).getMethod("getUidTxBytes", new Class[] { Integer.TYPE });
      int i = paramContext.getApplicationInfo().uid;
      if (i == -1) {
        return false;
      }
      l1 = ((Long)((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(i) })).longValue();
      l2 = ((Long)((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(i) })).longValue();
      if ((l1 <= 0L) || (l2 <= 0L)) {}
      for (;;)
      {
        w.a(paramContext).a(str, localJSONObject, w.a.e);
        bf.a(g);
        ap.b(g);
        a(localSharedPreferences);
        return true;
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("download_traffic", l1);
        ((JSONObject)localObject1).put("upload_traffic", l2);
        localJSONObject.put("__c", localObject1);
      }
      return false;
    }
    catch (Throwable paramContext) {}
  }
  
  public String b(Context paramContext)
  {
    String str = bv.c(paramContext);
    paramContext = AnalyticsConfig.getAppkey(paramContext);
    long l = System.currentTimeMillis();
    if (paramContext == null) {
      throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l).append(paramContext).append(str);
    f = bw.a(localStringBuilder.toString());
    return f;
  }
  
  public void c(Context paramContext)
  {
    g = paramContext;
    SharedPreferences localSharedPreferences = ba.a(paramContext);
    if (localSharedPreferences == null) {
      return;
    }
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("versioncode", 0);
    int j = Integer.parseInt(bv.a(g));
    if ((i != 0) && (j != i)) {}
    try
    {
      localEditor.putInt("vers_code", i);
      localEditor.putString("vers_name", localSharedPreferences.getString("versionname", ""));
      localEditor.commit();
      if (g(paramContext) == null) {
        a(paramContext, localSharedPreferences);
      }
      e(g);
      ar.b(g).b();
      f(g);
      ar.b(g).a();
      return;
      if (b(localSharedPreferences))
      {
        paramContext = a(paramContext, localSharedPreferences);
        by.c("Start new session: " + paramContext);
        return;
      }
      paramContext = localSharedPreferences.getString("session_id", null);
      localEditor.putLong("a_start_time", System.currentTimeMillis());
      localEditor.putLong("a_end_time", 0L);
      localEditor.commit();
      by.c("Extend current session: " + paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void d(Context paramContext)
  {
    paramContext = ba.a(paramContext);
    if (paramContext == null) {
      return;
    }
    if ((paramContext.getLong("a_start_time", 0L) == 0L) && (AnalyticsConfig.ACTIVITY_DURATION_OPEN))
    {
      by.e("onPause called before onResume");
      return;
    }
    long l = System.currentTimeMillis();
    paramContext = paramContext.edit();
    paramContext.putLong("a_start_time", 0L);
    paramContext.putLong("a_end_time", l);
    paramContext.putLong("session_end_time", l);
    paramContext.commit();
  }
  
  public boolean e(Context paramContext)
  {
    boolean bool2 = false;
    Object localObject = ba.a(paramContext);
    if (localObject == null) {}
    while (((SharedPreferences)localObject).getString("session_id", null) == null) {
      return false;
    }
    long l1 = ((SharedPreferences)localObject).getLong("a_start_time", 0L);
    long l2 = ((SharedPreferences)localObject).getLong("a_end_time", 0L);
    boolean bool1 = bool2;
    if (l1 > 0L)
    {
      bool1 = bool2;
      if (l2 == 0L)
      {
        bool1 = true;
        d(paramContext);
      }
    }
    l2 = ((SharedPreferences)localObject).getLong("session_end_time", 0L);
    try
    {
      localObject = new JSONObject();
      l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      ((JSONObject)localObject).put("__f", l1);
      w.a(g).a(a(), (JSONObject)localObject, w.a.d);
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    a(paramContext);
    return bool1;
  }
  
  public void f(Context paramContext)
  {
    Object localObject = ba.a(paramContext);
    if (localObject == null) {
      return;
    }
    String str = b(paramContext);
    localObject = ((SharedPreferences)localObject).edit();
    long l = System.currentTimeMillis();
    ((SharedPreferences.Editor)localObject).putString("session_id", str);
    ((SharedPreferences.Editor)localObject).putLong("session_start_time", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).putLong("session_end_time", 0L);
    ((SharedPreferences.Editor)localObject).putLong("a_start_time", l);
    ((SharedPreferences.Editor)localObject).putLong("a_end_time", 0L);
    ((SharedPreferences.Editor)localObject).putInt("versioncode", Integer.parseInt(bv.a(paramContext)));
    ((SharedPreferences.Editor)localObject).putString("versionname", bv.b(paramContext));
    try
    {
      paramContext = new JSONObject();
      paramContext.put("__e", l);
      w.a(g).a(str, paramContext, w.a.c);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */