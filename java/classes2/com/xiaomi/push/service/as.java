package com.xiaomi.push.service;

import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.d;

class as
  extends XMPushService.h
{
  private XMPushService b = null;
  private d c;
  private com.xiaomi.slim.b d;
  
  public as(XMPushService paramXMPushService, com.xiaomi.slim.b paramb)
  {
    super(4);
    this.b = paramXMPushService;
    this.d = paramb;
  }
  
  public as(XMPushService paramXMPushService, d paramd)
  {
    super(4);
    this.b = paramXMPushService;
    this.c = paramd;
  }
  
  public void a()
  {
    try
    {
      if (this.c != null)
      {
        this.b.a(this.c);
        return;
      }
      this.b.a(this.d);
      return;
    }
    catch (l locall)
    {
      com.xiaomi.channel.commonutils.logger.b.a(locall);
      this.b.a(10, locall);
    }
  }
  
  public String b()
  {
    return "send a message.";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */