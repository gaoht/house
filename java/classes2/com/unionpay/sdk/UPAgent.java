package com.unionpay.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.Map;

public class UPAgent
{
  public static boolean ENABLE_MULTI_PROCESS_POST = false;
  public static boolean LOG_ON = true;
  private static y a;
  
  private static void a(Context paramContext)
  {
    try
    {
      d.c = paramContext.getApplicationContext();
      if (a == null)
      {
        long l = System.currentTimeMillis();
        a = zz.a();
        if (ag.a) {
          k.b(new String[] { "dynamic load cost " + (System.currentTimeMillis() - l) });
        }
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static final String getDeviceId(Context paramContext)
  {
    try
    {
      a(paramContext);
      paramContext = a.b(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    finally {}
  }
  
  public static final int getNFCStatus(Context paramContext)
  {
    return h.b(paramContext);
  }
  
  public static final void init(Context paramContext)
  {
    try
    {
      a(paramContext);
      a.a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    finally {}
  }
  
  public static final void init(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      a(paramContext);
      a.a(paramContext, paramString1, paramString2);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    finally {}
  }
  
  public static final void onError(Context paramContext, Throwable paramThrowable)
  {
    try
    {
      a(paramContext);
      a.a(paramContext, paramThrowable);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static final void onEvent(Context paramContext, String paramString)
  {
    onEvent(paramContext, paramString, "", null);
  }
  
  public static final void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    onEvent(paramContext, paramString1, paramString2, null);
  }
  
  public static final void onEvent(Context paramContext, String paramString1, String paramString2, Map paramMap)
  {
    try
    {
      a(paramContext);
      a.a(paramContext, paramString1, paramString2, paramMap);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static final void onPageEnd(Context paramContext, String paramString)
  {
    try
    {
      a(paramContext);
      a.onPageEnd(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static final void onPageStart(Context paramContext, String paramString)
  {
    try
    {
      a(paramContext);
      a.onPageStart(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static final void onPause(Activity paramActivity)
  {
    try
    {
      a(paramActivity);
      a.b(paramActivity);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static final void onResume(Activity paramActivity)
  {
    try
    {
      a(paramActivity);
      a.a(paramActivity);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static final void onResume(Activity paramActivity, String paramString1, String paramString2)
  {
    try
    {
      a(paramActivity);
      a.onResume(paramActivity, paramString1, paramString2);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static final void removeGlobalKV(String paramString)
  {
    if ((LOG_ON) && (paramString != null)) {
      Log.i("UPLog", "removeGlobalKV# key:" + paramString);
    }
    d.a.remove(paramString);
  }
  
  public static final void setAdditionalVersionNameAndCode(String paramString, long paramLong)
  {
    try
    {
      ag.a(paramString, paramLong);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static final void setGlobalKV(String paramString, Object paramObject)
  {
    if ((LOG_ON) && (paramString != null) && (paramObject != null)) {
      Log.i("UPLog", "setGlobalKV# key:" + paramString + " value:" + paramObject.toString());
    }
    d.a.put(paramString, paramObject);
  }
  
  public static void setPushDisabled() {}
  
  public static final void setReportUncaughtExceptions(boolean paramBoolean)
  {
    try
    {
      d.b = paramBoolean;
      if (LOG_ON) {
        Log.i("UPLog", "[PreSettings] setReportUncaughtExceptions: " + paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/UPAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */