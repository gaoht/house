package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ap
{
  public static String a = null;
  private static JSONObject d = new JSONObject();
  Application.ActivityLifecycleCallbacks b = new Application.ActivityLifecycleCallbacks()
  {
    public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public void onActivityDestroyed(Activity paramAnonymousActivity) {}
    
    public void onActivityPaused(Activity paramAnonymousActivity)
    {
      ap.b(ap.this, paramAnonymousActivity);
    }
    
    public void onActivityResumed(Activity paramAnonymousActivity)
    {
      ap.a(ap.this, paramAnonymousActivity);
    }
    
    public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public void onActivityStarted(Activity paramAnonymousActivity) {}
    
    public void onActivityStopped(Activity paramAnonymousActivity) {}
  };
  private final Map<String, Long> c = new HashMap();
  private Application e = null;
  
  public ap(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      this.e = paramActivity.getApplication();
      a(paramActivity);
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.e.registerActivityLifecycleCallbacks(this.b);
    if (a == null) {
      b(paramActivity);
    }
  }
  
  private void b(Activity arg1)
  {
    a = ???.getPackageName() + "." + ???.getLocalClassName();
    synchronized (this.c)
    {
      this.c.put(a, Long.valueOf(System.currentTimeMillis()));
      return;
    }
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      synchronized (d)
      {
        if (d.length() > 0)
        {
          w.a(paramContext).a(bd.a(), d, w.a.a);
          d = new JSONObject();
        }
        return;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  private void c(Activity arg1)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: getfield 36	com/umeng/analytics/pro/ap:c	Ljava/util/Map;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 36	com/umeng/analytics/pro/ap:c	Ljava/util/Map;
    //   13: getstatic 21	com/umeng/analytics/pro/ap:a	Ljava/lang/String;
    //   16: invokeinterface 127 2 0
    //   21: ifeq +39 -> 60
    //   24: invokestatic 85	java/lang/System:currentTimeMillis	()J
    //   27: aload_0
    //   28: getfield 36	com/umeng/analytics/pro/ap:c	Ljava/util/Map;
    //   31: getstatic 21	com/umeng/analytics/pro/ap:a	Ljava/lang/String;
    //   34: invokeinterface 131 2 0
    //   39: checkcast 87	java/lang/Long
    //   42: invokevirtual 134	java/lang/Long:longValue	()J
    //   45: lsub
    //   46: lstore_2
    //   47: aload_0
    //   48: getfield 36	com/umeng/analytics/pro/ap:c	Ljava/util/Map;
    //   51: getstatic 21	com/umeng/analytics/pro/ap:a	Ljava/lang/String;
    //   54: invokeinterface 137 2 0
    //   59: pop
    //   60: aload_1
    //   61: monitorexit
    //   62: getstatic 28	com/umeng/analytics/pro/ap:d	Lorg/json/JSONObject;
    //   65: astore_1
    //   66: aload_1
    //   67: monitorenter
    //   68: new 23	org/json/JSONObject
    //   71: dup
    //   72: invokespecial 26	org/json/JSONObject:<init>	()V
    //   75: putstatic 28	com/umeng/analytics/pro/ap:d	Lorg/json/JSONObject;
    //   78: getstatic 28	com/umeng/analytics/pro/ap:d	Lorg/json/JSONObject;
    //   81: ldc -117
    //   83: getstatic 21	com/umeng/analytics/pro/ap:a	Ljava/lang/String;
    //   86: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: getstatic 28	com/umeng/analytics/pro/ap:d	Lorg/json/JSONObject;
    //   93: ldc -112
    //   95: lload_2
    //   96: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload_1
    //   101: monitorexit
    //   102: return
    //   103: astore 4
    //   105: aload_1
    //   106: monitorexit
    //   107: aload 4
    //   109: athrow
    //   110: astore_1
    //   111: return
    //   112: astore 4
    //   114: aload_1
    //   115: monitorexit
    //   116: aload 4
    //   118: athrow
    //   119: astore 4
    //   121: goto -21 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	ap
    //   1	95	2	l	long
    //   103	5	4	localObject1	Object
    //   112	5	4	localObject2	Object
    //   119	1	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	60	103	finally
    //   60	62	103	finally
    //   105	107	103	finally
    //   2	9	110	java/lang/Throwable
    //   62	68	110	java/lang/Throwable
    //   107	110	110	java/lang/Throwable
    //   116	119	110	java/lang/Throwable
    //   68	100	112	finally
    //   100	102	112	finally
    //   114	116	112	finally
    //   68	100	119	java/lang/Throwable
  }
  
  public void a()
  {
    if (this.e != null) {
      this.e.unregisterActivityLifecycleCallbacks(this.b);
    }
  }
  
  public void a(Context paramContext)
  {
    c(null);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */