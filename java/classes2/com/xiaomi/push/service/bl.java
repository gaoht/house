package com.xiaomi.push.service;

import com.xiaomi.smack.a;

class bl
  extends XMPushService.h
{
  bl(XMPushService paramXMPushService, int paramInt)
  {
    super(paramInt);
  }
  
  public void a()
  {
    if (XMPushService.c(this.b) != null)
    {
      XMPushService.c(this.b).h();
      XMPushService.a(this.b, null);
    }
  }
  
  public String b()
  {
    return "disconnect for disable push";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */