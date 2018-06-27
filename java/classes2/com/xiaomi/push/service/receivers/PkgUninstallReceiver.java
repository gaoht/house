package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.h;

public class PkgUninstallReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("android.intent.action.PACKAGE_REMOVED".equals(paramIntent.getAction())))
    {
      boolean bool = paramIntent.getExtras().getBoolean("android.intent.extra.REPLACING");
      paramIntent = paramIntent.getData();
      if ((paramIntent == null) || (bool)) {}
    }
    try
    {
      Intent localIntent = new Intent(paramContext, XMPushService.class);
      localIntent.setAction(ap.a);
      localIntent.putExtra("uninstall_pkg_name", paramIntent.getEncodedSchemeSpecificPart());
      paramContext.startService(localIntent);
      h.a(paramContext.getApplicationContext(), paramIntent.getEncodedSchemeSpecificPart());
      return;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/receivers/PkgUninstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */