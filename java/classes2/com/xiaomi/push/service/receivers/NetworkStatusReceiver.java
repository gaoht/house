package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.p;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.push.service.aw;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver
  extends BroadcastReceiver
{
  private static int a = 1;
  private static int b = 1;
  private static int c = 2;
  private static BlockingQueue<Runnable> d = new LinkedBlockingQueue();
  private static ThreadPoolExecutor e = new ThreadPoolExecutor(a, b, c, TimeUnit.SECONDS, d);
  private static boolean f = false;
  private boolean g = false;
  
  public NetworkStatusReceiver()
  {
    this.g = true;
  }
  
  public NetworkStatusReceiver(Object paramObject)
  {
    f = true;
  }
  
  private void a(Context paramContext)
  {
    if ((!u.a(paramContext).c()) && (com.xiaomi.mipush.sdk.a.a(paramContext).i()) && (!com.xiaomi.mipush.sdk.a.a(paramContext).n())) {}
    try
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName(paramContext, "com.xiaomi.push.service.XMPushService"));
      localIntent.setAction("com.xiaomi.push.network_status_changed");
      paramContext.startService(localIntent);
      if ((d.d(paramContext)) && (u.a(paramContext).g()))
      {
        u.a(paramContext).d();
        aw.a().b("NewWork Changed");
      }
      if (d.d(paramContext))
      {
        if ("disable_syncing".equals(p.a(paramContext).a())) {
          MiPushClient.disablePush(paramContext);
        }
        if ("enable_syncing".equals(p.a(paramContext).a())) {
          MiPushClient.enablePush(paramContext);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a(localException);
      }
    }
  }
  
  public static boolean a()
  {
    return f;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.g) {
      return;
    }
    e.execute(new a(this, paramContext));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/receivers/NetworkStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */