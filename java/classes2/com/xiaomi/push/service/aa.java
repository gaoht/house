package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.d;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.u;
import java.nio.ByteBuffer;
import org.apache.thrift.f;

final class aa
{
  static com.xiaomi.slim.b a(XMPushService paramXMPushService, byte[] paramArrayOfByte)
  {
    com.xiaomi.xmpush.thrift.ab localab = new com.xiaomi.xmpush.thrift.ab();
    try
    {
      aq.a(localab, paramArrayOfByte);
      paramXMPushService = a(o.a(paramXMPushService), paramXMPushService, localab);
      return paramXMPushService;
    }
    catch (f paramXMPushService)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramXMPushService);
    }
    return null;
  }
  
  static com.xiaomi.slim.b a(n paramn, Context paramContext, com.xiaomi.xmpush.thrift.ab paramab)
  {
    try
    {
      paramContext = new com.xiaomi.slim.b();
      paramContext.a(5);
      paramContext.c(paramn.a);
      paramContext.b(paramab.f);
      paramContext.a("SECMSG", "message");
      String str = paramn.a;
      paramab.g.b = str.substring(0, str.indexOf("@"));
      paramab.g.d = str.substring(str.indexOf("/") + 1);
      paramContext.a(aq.a(paramab), paramn.c);
      paramContext.a((short)1);
      com.xiaomi.channel.commonutils.logger.b.a("try send mi push message. packagename:" + paramab.f + " action:" + paramab.a);
      return paramContext;
    }
    catch (NullPointerException paramn)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramn);
    }
    return null;
  }
  
  static com.xiaomi.xmpush.thrift.ab a(String paramString1, String paramString2)
  {
    ae localae = new ae();
    localae.b(paramString2);
    localae.c("package uninstalled");
    localae.a(d.j());
    localae.a(false);
    return a(paramString1, paramString2, localae, com.xiaomi.xmpush.thrift.a.i);
  }
  
  static <T extends org.apache.thrift.a<T, ?>> com.xiaomi.xmpush.thrift.ab a(String paramString1, String paramString2, T paramT, com.xiaomi.xmpush.thrift.a parama)
  {
    paramT = aq.a(paramT);
    com.xiaomi.xmpush.thrift.ab localab = new com.xiaomi.xmpush.thrift.ab();
    u localu = new u();
    localu.a = 5L;
    localu.b = "fakeid";
    localab.a(localu);
    localab.a(ByteBuffer.wrap(paramT));
    localab.a(parama);
    localab.c(true);
    localab.b(paramString1);
    localab.a(false);
    localab.a(paramString2);
    return localab;
  }
  
  static void a(XMPushService paramXMPushService)
  {
    if (o.a(paramXMPushService.getApplicationContext()) != null)
    {
      ak.b localb = o.a(paramXMPushService.getApplicationContext()).a(paramXMPushService);
      a(paramXMPushService, localb);
      ak.a().a(localb);
    }
  }
  
  static void a(XMPushService paramXMPushService, ak.b paramb)
  {
    paramb.a(new ab(paramXMPushService));
  }
  
  static void a(XMPushService paramXMPushService, com.xiaomi.xmpush.thrift.ab paramab)
  {
    com.xiaomi.smack.a locala = paramXMPushService.h();
    if (locala != null)
    {
      if (locala.a())
      {
        paramXMPushService = a(o.a(paramXMPushService), paramXMPushService, paramab);
        if (paramXMPushService != null) {
          locala.b(paramXMPushService);
        }
        return;
      }
      throw new l("Don't support XMPP connection.");
    }
    throw new l("try send msg while connection is null.");
  }
  
  static void a(XMPushService paramXMPushService, String paramString, byte[] paramArrayOfByte)
  {
    com.xiaomi.smack.a locala = paramXMPushService.h();
    if (locala != null)
    {
      if (locala.a())
      {
        com.xiaomi.slim.b localb = a(paramXMPushService, paramArrayOfByte);
        if (localb != null) {
          locala.b(localb);
        }
      }
      else
      {
        throw new l("Don't support XMPP connection.");
      }
      r.a(paramXMPushService, paramString, paramArrayOfByte, 70000003, "not a valid message");
      return;
    }
    throw new l("try send msg while connection is null.");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */