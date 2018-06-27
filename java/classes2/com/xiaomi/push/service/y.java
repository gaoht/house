package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.r;

final class y
  extends XMPushService.h
{
  y(int paramInt, XMPushService paramXMPushService, ab paramab, String paramString1, String paramString2)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      ab localab = s.a(this.b, this.c);
      localab.h.a("error", this.d);
      localab.h.a("reason", this.e);
      aa.a(this.b, localab);
      return;
    }
    catch (l locall)
    {
      b.a(locall);
      this.b.a(10, locall);
    }
  }
  
  public String b()
  {
    return "send wrong message ack for message.";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */