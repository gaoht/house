package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.util.e;

class bg
  extends BroadcastReceiver
{
  bg(XMPushService paramXMPushService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2;
    String str3;
    String str1;
    if (paramIntent.getAction().equals("com.xiaomi.metok.geofencing.state_change"))
    {
      str2 = paramIntent.getStringExtra("Location");
      str3 = paramIntent.getStringExtra("Describe");
      str1 = paramIntent.getStringExtra("State");
      if (!TextUtils.isEmpty(str3)) {}
    }
    else
    {
      return;
    }
    paramIntent = str1;
    if (!XMPushService.a(this.a, str1, str3, paramContext))
    {
      paramIntent = "Unknown";
      b.a(" updated geofence statue about geo_id:" + str3 + " falied. current_statue:" + "Unknown");
    }
    e.a(new bh(this, paramContext, str3, paramIntent));
    b.c("ownresilt结果:state= " + paramIntent + "\n describe=" + str3 + "\n location=" + str2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */