package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;

class bm
  extends XMPushService.h
{
  bm(XMPushService paramXMPushService, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    super(paramInt);
  }
  
  public void a()
  {
    try
    {
      aa.a(this.d, this.b, this.c);
      return;
    }
    catch (l locall)
    {
      b.a(locall);
      this.d.a(10, locall);
    }
  }
  
  public String b()
  {
    return "send mi push message";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */