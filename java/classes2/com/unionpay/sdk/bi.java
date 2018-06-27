package com.unionpay.sdk;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class bi
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    if (ag.a) {
      k.b(new String[] { "Lifecycle callback onActivityPaused: ", paramActivity.getLocalClassName() });
    }
    ag.b(paramActivity, paramActivity.getLocalClassName(), false);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (ag.a) {
      k.b(new String[] { "Lifecycle callback onActivityResumed: ", paramActivity.getLocalClassName() });
    }
    ag.a(paramActivity, paramActivity.getLocalClassName(), false);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */