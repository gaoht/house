package com.g.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

@TargetApi(14)
public class bv
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    try
    {
      c.m = false;
      cx.b(paramActivity, a.a);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    c.n = true;
    c.m = true;
    try
    {
      cx.a(paramActivity, a.a);
      c.h = true;
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */