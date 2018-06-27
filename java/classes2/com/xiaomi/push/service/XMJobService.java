package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;

public class XMJobService
  extends Service
{
  static Service a = null;
  private IBinder b = null;
  
  static Service a()
  {
    return a;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.b != null) {
      return this.b;
    }
    return new Binder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 21) {
      this.b = new a(this).a;
    }
    a = this;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a = null;
  }
  
  @TargetApi(21)
  static class a
    extends JobService
  {
    Binder a = null;
    private Handler b;
    
    a(Service paramService)
    {
      com.xiaomi.channel.commonutils.reflect.a.a(this, "attachBaseContext", new Object[] { paramService });
    }
    
    public boolean onStartJob(JobParameters paramJobParameters)
    {
      b.a("Job started " + paramJobParameters.getJobId());
      Intent localIntent = new Intent(this, XMPushService.class);
      localIntent.setAction("com.xiaomi.push.timer");
      localIntent.setPackage(getPackageName());
      startService(localIntent);
      if (this.b == null) {
        this.b = new a(this);
      }
      this.b.sendMessage(Message.obtain(this.b, 1, paramJobParameters));
      return true;
    }
    
    public boolean onStopJob(JobParameters paramJobParameters)
    {
      b.a("Job stop " + paramJobParameters.getJobId());
      return false;
    }
    
    private static class a
      extends Handler
    {
      JobService a;
      
      a(JobService paramJobService)
      {
        super();
        this.a = paramJobService;
      }
      
      public void handleMessage(Message paramMessage)
      {
        switch (paramMessage.what)
        {
        }
        do
        {
          return;
          paramMessage = (JobParameters)paramMessage.obj;
          b.a("Job finished " + paramMessage.getJobId());
          this.a.jobFinished(paramMessage, false);
        } while (paramMessage.getJobId() != 1);
        com.xiaomi.push.service.timers.a.a(false);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/XMJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */