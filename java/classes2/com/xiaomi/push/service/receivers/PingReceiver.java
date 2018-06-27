package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.timers.a;

public class PingReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a.a(false);
    b.c(paramIntent.getPackage() + " is the package name");
    if (am.o.equals(paramIntent.getAction()))
    {
      if (TextUtils.equals(paramContext.getPackageName(), paramIntent.getPackage())) {
        b.c("Ping XMChannelService on timer");
      }
      try
      {
        paramIntent = new Intent(paramContext, XMPushService.class);
        paramIntent.putExtra("time_stamp", System.currentTimeMillis());
        paramIntent.setAction("com.xiaomi.push.timer");
        paramContext.startService(paramIntent);
        return;
      }
      catch (Exception paramContext)
      {
        b.a(paramContext);
        return;
      }
    }
    b.a("cancel the old ping timer");
    a.a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/receivers/PingReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */