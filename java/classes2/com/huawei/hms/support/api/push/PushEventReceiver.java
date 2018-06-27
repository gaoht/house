package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.push.a.a;
import com.huawei.hms.support.api.push.a.b;

public class PushEventReceiver
  extends BroadcastReceiver
{
  private static void a(Context paramContext, Intent paramIntent)
  {
    if (a.a(paramContext, "com.huawei.hwid"))
    {
      if (b.b()) {
        b.a("PushEventReceiver", "transfer this message to HMS to depose selfshow msg");
      }
      localIntent = new Intent(paramIntent.getAction());
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        localIntent.putExtras(paramIntent);
        localIntent.setFlags(32);
        localIntent.setPackage("com.huawei.hwid");
        paramContext.sendBroadcast(localIntent);
      }
    }
    while (!b.d())
    {
      Intent localIntent;
      do
      {
        return;
      } while (!b.b());
      b.a("PushEventReceiver", "self show failure, msg is null");
      return;
    }
    b.c("PushEventReceiver", "HMS is not installed, can't depose selfshow message");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      if (b.b()) {
        b.a("PushEventReceiver", "context== null or intent == null");
      }
    }
    do
    {
      return;
      String str = paramIntent.getAction();
      if (b.c()) {
        b.b("PushEventReceiver", "receive self show message, action is " + str);
      }
      if (("com.huawei.intent.action.PUSH".equals(str)) && (paramIntent.hasExtra("selfshow_info")))
      {
        a(paramContext, paramIntent);
        return;
      }
    } while (!b.b());
    b.a("PushEventReceiver", "invalid action.");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/PushEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */