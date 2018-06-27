package com.mob.commons.clt;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ActivityTracker;
import com.mob.tools.utils.ActivityTracker.Tracker;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ActClt
  extends a
  implements PublicMemberKeeper
{
  private boolean a;
  private Activity b;
  private SharePrefrenceHelper c;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  
  ActClt()
  {
    new Thread()
    {
      public void run()
      {
        final boolean bool1 = com.mob.commons.a.u();
        final boolean bool2 = com.mob.commons.a.x();
        if ((bool1) || (bool2))
        {
          if (bool2) {
            ActClt.a(ActClt.this);
          }
          if (bool1) {
            ActClt.b(ActClt.this);
          }
          com.mob.commons.a.a(0L, false);
          if (DeviceHelper.getInstance(MobSDK.getContext()).amIOnForeground()) {
            ActClt.a(ActClt.this, -1L);
          }
          ActClt.b(ActClt.this, SystemClock.elapsedRealtime());
          ActivityTracker.getInstance(MobSDK.getContext()).addTracker(new ActivityTracker.Tracker()
          {
            public void onCreated(Activity paramAnonymous2Activity, Bundle paramAnonymous2Bundle) {}
            
            public void onDestroyed(Activity paramAnonymous2Activity)
            {
              onStopped(paramAnonymous2Activity);
            }
            
            public void onPaused(Activity paramAnonymous2Activity) {}
            
            public void onResumed(Activity paramAnonymous2Activity)
            {
              if (!ActClt.c(ActClt.this))
              {
                if (ActClt.d(ActClt.this) == -1L) {
                  ActClt.a(ActClt.this, SystemClock.elapsedRealtime() - ActClt.e(ActClt.this));
                }
                ActClt.b(ActClt.this, SystemClock.elapsedRealtime());
                com.mob.commons.a.a(0L, true);
                if ((bool2) && (ActClt.f(ActClt.this) == 0L)) {
                  ActClt.c(ActClt.this, com.mob.commons.a.a());
                }
                if (bool1) {
                  ActClt.b(ActClt.this);
                }
                a.startCollectors(new Class[] { DvcClt.class, PkgClt.class, RtClt.class, VplClt.class, DClt.class });
              }
              ActClt.a(ActClt.this, true);
              ActClt.a(ActClt.this, paramAnonymous2Activity);
            }
            
            public void onSaveInstanceState(Activity paramAnonymous2Activity, Bundle paramAnonymous2Bundle) {}
            
            public void onStarted(Activity paramAnonymous2Activity) {}
            
            public void onStopped(Activity paramAnonymous2Activity)
            {
              if ((ActClt.g(ActClt.this) == null) || (paramAnonymous2Activity.equals(ActClt.g(ActClt.this))))
              {
                ActClt.a(ActClt.this, false);
                ActClt.a(ActClt.this, null);
                com.mob.commons.a.a(SystemClock.elapsedRealtime(), true);
                if (bool2)
                {
                  ActClt.h(ActClt.this);
                  ActClt.c(ActClt.this, 0L);
                }
              }
            }
          });
        }
      }
    }.start();
  }
  
  private void g()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", "PV");
      localHashMap.put("datetime", Long.valueOf(com.mob.commons.a.a()));
      b.a().a(com.mob.commons.a.a(), localHashMap);
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  private void h()
  {
    try
    {
      if (this.c == null)
      {
        this.c = new SharePrefrenceHelper(MobSDK.getContext());
        this.c.open("top_time");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void i()
  {
    try
    {
      h();
      Object localObject1 = (HashMap)this.c.get("top_time");
      if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty())) {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        long l1 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
        long l2 = ((Long)((Map.Entry)localObject2).getValue()).longValue();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", "BACK_INFO");
        ((HashMap)localObject2).put("datetime", Long.valueOf(com.mob.commons.a.a()));
        HashMap localHashMap = new HashMap();
        localHashMap.put("runtimes", Long.valueOf(l2));
        ((HashMap)localObject2).put("data", localHashMap);
        b.a().a(l1, (HashMap)localObject2);
        continue;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
    this.c.remove("top_time");
  }
  
  private void j()
  {
    try
    {
      h();
      HashMap localHashMap = (HashMap)this.c.get("top_time");
      if (localHashMap == null) {
        localHashMap = new HashMap();
      }
      for (;;)
      {
        long l3 = com.mob.commons.a.a();
        if (this.d == 0L) {}
        for (long l1 = SystemClock.elapsedRealtime() - this.e;; l1 = l3 - l1)
        {
          long l2 = l1;
          if (this.f > 0L) {
            l2 = l1 + this.f;
          }
          this.f = -2L;
          localHashMap.put(Long.valueOf(l3), Long.valueOf(l2));
          this.c.put("top_time", localHashMap);
          i();
          return;
          l1 = this.d;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/ActClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */