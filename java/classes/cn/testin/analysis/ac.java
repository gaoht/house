package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(14)
public class ac
  implements Application.ActivityLifecycleCallbacks
{
  private aa a;
  private AtomicInteger b;
  private boolean c = true;
  
  public ac(aa paramaa)
  {
    this.a = paramaa;
    this.b = new AtomicInteger();
    a();
  }
  
  public void a()
  {
    if (a.p) {
      ba.a(a.d, this.a.d());
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    ba.b(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    ba.a(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    try
    {
      if (this.b.get() == 0)
      {
        ar.b("switch to foreground!");
        if (!this.c) {
          this.a.e();
        }
      }
      this.c = false;
      this.b.incrementAndGet();
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        ar.b(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    try
    {
      this.b.decrementAndGet();
      if (this.b.get() == 0)
      {
        ar.b("switch to background!");
        this.a.f();
      }
      return;
    }
    catch (Exception paramActivity)
    {
      ar.b(paramActivity);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */