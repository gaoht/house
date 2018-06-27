package com.xiaomi.push.service;

import com.xiaomi.push.protobuf.b.b;
import com.xiaomi.smack.e;
import java.util.Map;

class bd
  extends com.xiaomi.smack.b
{
  bd(XMPushService paramXMPushService, Map paramMap, int paramInt, String paramString, e parame)
  {
    super(paramMap, paramInt, paramString, parame);
  }
  
  public byte[] a()
  {
    try
    {
      Object localObject = new b.b();
      ((b.b)localObject).a(at.a().c());
      localObject = ((b.b)localObject).c();
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      com.xiaomi.channel.commonutils.logger.b.a("getOBBString err: " + localException.toString());
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */