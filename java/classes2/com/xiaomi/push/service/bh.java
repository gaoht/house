package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

class bh
  implements Runnable
{
  bh(bg parambg, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = g.a(this.a).c(this.b).iterator();
    while (localIterator.hasNext())
    {
      com.xiaomi.push.service.module.b localb = (com.xiaomi.push.service.module.b)localIterator.next();
      if (XMPushService.a(localb.e(), this.c)) {
        if (localb.a() < System.currentTimeMillis())
        {
          if (g.a(this.a).a(localb.b()) == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("XMPushService remove some geofence message failed. message_id:" + localb.b());
          }
        }
        else
        {
          byte[] arrayOfByte = localb.d();
          if (arrayOfByte == null)
          {
            com.xiaomi.channel.commonutils.logger.b.a("Geo canBeShownMessage content null");
          }
          else
          {
            Intent localIntent = s.a(arrayOfByte, System.currentTimeMillis());
            if (localIntent == null)
            {
              com.xiaomi.channel.commonutils.logger.b.a("Geo canBeShownMessage intent null");
            }
            else
            {
              s.a(this.d.a, null, arrayOfByte, localIntent, true);
              if (g.a(this.d.a).a(localb.b()) == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("show some exit geofence message. then remove this message failed. message_id:" + localb.b());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */