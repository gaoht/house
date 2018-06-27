package com.xiaomi.push.service.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.reflect.a;
import com.xiaomi.push.service.am;
import com.xiaomi.smack.g;
import java.lang.reflect.Method;

class b
  implements a.a
{
  private PendingIntent a = null;
  private Context b = null;
  private volatile long c = 0L;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void a(AlarmManager paramAlarmManager, long paramLong, PendingIntent paramPendingIntent)
  {
    try
    {
      AlarmManager.class.getMethod("setExact", new Class[] { Integer.TYPE, Long.TYPE, PendingIntent.class }).invoke(paramAlarmManager, new Object[] { Integer.valueOf(0), Long.valueOf(paramLong), paramPendingIntent });
      return;
    }
    catch (Exception paramAlarmManager)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramAlarmManager);
    }
  }
  
  public void a()
  {
    if (this.a != null)
    {
      ((AlarmManager)this.b.getSystemService("alarm")).cancel(this.a);
      this.a = null;
      com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
    }
    this.c = 0L;
  }
  
  public void a(Intent paramIntent, long paramLong)
  {
    AlarmManager localAlarmManager = (AlarmManager)this.b.getSystemService("alarm");
    this.a = PendingIntent.getBroadcast(this.b, 0, paramIntent, 0);
    if (Build.VERSION.SDK_INT >= 23) {
      a.a(localAlarmManager, "setExactAndAllowWhileIdle", new Object[] { Integer.valueOf(0), Long.valueOf(paramLong), this.a });
    }
    for (;;)
    {
      com.xiaomi.channel.commonutils.logger.b.c("register timer " + paramLong);
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        a(localAlarmManager, paramLong, this.a);
      } else {
        localAlarmManager.set(0, paramLong, this.a);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l = g.c();
    if ((!paramBoolean) && (this.c == 0L)) {
      return;
    }
    if (paramBoolean) {
      a();
    }
    if ((paramBoolean) || (this.c == 0L)) {
      this.c = (l - SystemClock.elapsedRealtime() % l + System.currentTimeMillis());
    }
    for (;;)
    {
      Intent localIntent = new Intent(am.o);
      localIntent.setPackage(this.b.getPackageName());
      a(localIntent, this.c);
      return;
      this.c += l;
      if (this.c < System.currentTimeMillis()) {
        this.c = (l + System.currentTimeMillis());
      }
    }
  }
  
  public boolean b()
  {
    return this.c != 0L;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/timers/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */