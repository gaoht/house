package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.r;

final class w
  extends XMPushService.h
{
  w(int paramInt, XMPushService paramXMPushService, ab paramab)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      ab localab = s.a(this.b, this.c);
      localab.m().a("miui_message_unrecognized", "1");
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
    return "send ack message for unrecognized new miui message.";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */