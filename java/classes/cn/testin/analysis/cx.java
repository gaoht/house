package cn.testin.analysis;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class cx
  implements Application.ActivityLifecycleCallbacks
{
  public cx(cu paramcu) {}
  
  private void a()
  {
    if (cu.d(this.a))
    {
      cu.e(this.a);
      return;
    }
    cu.c(this.a).a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    cu.c(this.a).b(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    cu.c(this.a).a(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    cu.c(this.a).b(paramActivity);
    a();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */