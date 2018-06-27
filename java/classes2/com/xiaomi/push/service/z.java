package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;
import com.xiaomi.xmpush.thrift.ab;

final class z
  extends XMPushService.h
{
  z(int paramInt, XMPushService paramXMPushService, ab paramab, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      ab localab = s.a(this.b, this.c, this.d, this.e, this.f);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */