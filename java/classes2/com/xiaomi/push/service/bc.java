package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.channel.commonutils.logger.b;

class bc
  implements ServiceConnection
{
  bc(XMPushService paramXMPushService) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    b.b("onServiceConnected " + paramIBinder);
    paramComponentName = XMJobService.a();
    if (paramComponentName != null)
    {
      this.a.startForeground(XMPushService.i(), XMPushService.a(this.a));
      paramComponentName.startForeground(XMPushService.i(), XMPushService.a(this.a));
      paramComponentName.stopForeground(true);
      this.a.unbindService(this);
      return;
    }
    b.a("XMService connected but innerService is null " + paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */