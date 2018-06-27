package com.xiaomi.push.service;

import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.c;

class a
  extends XMPushService.h
{
  private XMPushService b = null;
  private c[] c;
  private com.xiaomi.slim.b[] d;
  
  public a(XMPushService paramXMPushService, com.xiaomi.slim.b[] paramArrayOfb)
  {
    super(4);
    this.b = paramXMPushService;
    this.d = paramArrayOfb;
  }
  
  public a(XMPushService paramXMPushService, c[] paramArrayOfc)
  {
    super(4);
    this.b = paramXMPushService;
    this.c = paramArrayOfc;
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
    return "batch send message.";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */