package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;
import com.xiaomi.xmpush.thrift.ab;

final class t
  extends XMPushService.h
{
  t(int paramInt, XMPushService paramXMPushService, ab paramab)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      aa.a(this.b, aa.a(this.c.j(), this.c.h()));
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
    return "send app absent message.";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */