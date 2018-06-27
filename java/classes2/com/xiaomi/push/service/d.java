package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.f.a;
import com.xiaomi.xmpush.thrift.ab;
import java.util.ArrayList;
import java.util.Iterator;

public class d
  extends f.a
{
  private XMPushService a;
  
  public d(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }
  
  public int a()
  {
    return 15;
  }
  
  public void run()
  {
    Iterator localIterator = g.a(this.a).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.xiaomi.push.service.module.b)localIterator.next();
      if (((com.xiaomi.push.service.module.b)localObject).a() < System.currentTimeMillis())
      {
        if (g.a(this.a).a(((com.xiaomi.push.service.module.b)localObject).b()) == 0) {
          com.xiaomi.channel.commonutils.logger.b.a("GeofenceDbCleaner delete a geofence message failed message_id:" + ((com.xiaomi.push.service.module.b)localObject).b());
        }
        localObject = s.a(((com.xiaomi.push.service.module.b)localObject).d());
        s.a(this.a, (ab)localObject, false, false, true);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */