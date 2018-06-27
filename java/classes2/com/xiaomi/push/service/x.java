package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.r;

final class x
  extends XMPushService.h
{
  x(int paramInt, XMPushService paramXMPushService, ab paramab, String paramString)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      ab localab = s.a(this.b, this.c);
      localab.m().a("absent_target_package", this.d);
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
    return "send app absent ack message for message.";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */