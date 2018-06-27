package com.ziroom.ziroomcustomer.base;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public class e
  implements Application.ActivityLifecycleCallbacks
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  
  public static boolean isApplicationInForeground()
  {
    return a > b;
  }
  
  public static boolean isApplicationVisible()
  {
    return c > d;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    b += 1;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a += 1;
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    c += 1;
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    d += 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/base/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */