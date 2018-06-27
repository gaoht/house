package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.stats.f;

class ar
{
  private static int e = 300000;
  private XMPushService a;
  private int b;
  private long c;
  private int d = 0;
  
  public ar(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
    this.b = 500;
    this.c = 0L;
  }
  
  private int b()
  {
    int i = 0;
    if (this.d > 8) {
      i = 300000;
    }
    do
    {
      return i;
      if (this.d > 4) {
        return 60000;
      }
      if (this.d > 1) {
        return 10000;
      }
    } while (this.c == 0L);
    if (System.currentTimeMillis() - this.c < 300000L)
    {
      if (this.b >= e) {
        return this.b;
      }
      i = this.b;
      this.b = ((int)(this.b * 1.5D));
      return i;
    }
    this.b = 500;
    return 0;
  }
  
  public void a()
  {
    this.c = System.currentTimeMillis();
    this.a.a(1);
    this.d = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.b())
    {
      XMPushService localXMPushService1;
      XMPushService localXMPushService2;
      if (paramBoolean)
      {
        if (!this.a.b(1)) {
          this.d += 1;
        }
        this.a.a(1);
        localXMPushService1 = this.a;
        localXMPushService2 = this.a;
        localXMPushService2.getClass();
        localXMPushService1.a(new XMPushService.d(localXMPushService2));
      }
      do
      {
        do
        {
          return;
        } while (this.a.b(1));
        int i = b();
        if (!this.a.b(1)) {
          this.d += 1;
        }
        b.a("schedule reconnect in " + i + "ms");
        localXMPushService1 = this.a;
        localXMPushService2 = this.a;
        localXMPushService2.getClass();
        localXMPushService1.a(new XMPushService.d(localXMPushService2), i);
        if ((this.d == 2) && (f.a().c())) {
          ae.b();
        }
      } while (this.d != 3);
      ae.a();
      return;
    }
    b.c("should not reconnect as no client or network.");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */