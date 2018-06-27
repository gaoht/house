package com.xiaomi.push.service.timers;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.smack.g;

@TargetApi(21)
public class c
  implements a.a
{
  Context a;
  JobScheduler b;
  private boolean c = false;
  
  c(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((JobScheduler)paramContext.getSystemService("jobscheduler"));
  }
  
  public void a()
  {
    this.c = false;
    this.b.cancel(1);
  }
  
  void a(long paramLong)
  {
    JobInfo.Builder localBuilder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), XMJobService.class.getName()));
    localBuilder.setMinimumLatency(paramLong);
    localBuilder.setOverrideDeadline(paramLong);
    localBuilder.setRequiredNetworkType(1);
    localBuilder.setPersisted(false);
    JobInfo localJobInfo = localBuilder.build();
    b.c("schedule Job = " + localJobInfo.getId() + " in " + paramLong);
    this.b.schedule(localBuilder.build());
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.c)) {
      return;
    }
    long l2 = g.c();
    long l1 = l2;
    if (paramBoolean)
    {
      a();
      l1 = l2 - SystemClock.elapsedRealtime() % l2;
    }
    this.c = true;
    a(l1);
  }
  
  public boolean b()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/timers/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */