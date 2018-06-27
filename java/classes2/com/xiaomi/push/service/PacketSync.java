package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.protobuf.b.b;
import com.xiaomi.push.protobuf.b.d;
import com.xiaomi.push.protobuf.b.g;
import com.xiaomi.push.protobuf.b.h;
import com.xiaomi.push.protobuf.b.i;
import com.xiaomi.push.protobuf.b.j;
import com.xiaomi.push.protobuf.b.k;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.g;
import com.xiaomi.stats.h;
import java.util.Date;

public class PacketSync
{
  private XMPushService a;
  
  PacketSync(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }
  
  private void a(com.xiaomi.smack.packet.a parama)
  {
    parama = parama.c();
    if (!TextUtils.isEmpty(parama))
    {
      parama = parama.split(";");
      Fallback localFallback = HostManager.getInstance().getFallbacksByHost(com.xiaomi.smack.b.b(), false);
      if ((localFallback != null) && (parama.length > 0))
      {
        localFallback.a(parama);
        this.a.a(20, null);
        this.a.a(true);
      }
    }
  }
  
  private void b(d paramd)
  {
    Object localObject = paramd.m();
    String str = paramd.l();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
    {
      localObject = ak.a().b(str, (String)localObject);
      if (localObject != null) {
        g.a(this.a, ((ak.b)localObject).a, g.a(paramd.c()), true, System.currentTimeMillis());
      }
    }
  }
  
  private void c(com.xiaomi.slim.b paramb)
  {
    Object localObject = paramb.j();
    String str = Integer.toString(paramb.c());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
    {
      localObject = ak.a().b(str, (String)localObject);
      if (localObject != null) {
        g.a(this.a, ((ak.b)localObject).a, paramb.l(), true, System.currentTimeMillis());
      }
    }
  }
  
  public void a(com.xiaomi.slim.b paramb)
  {
    if (5 != paramb.c()) {
      c(paramb);
    }
    try
    {
      b(paramb);
      return;
    }
    catch (Exception localException)
    {
      com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + paramb.c() + " cmd = " + paramb.a() + " packetid = " + paramb.h() + " failure ", localException);
    }
  }
  
  public void a(d paramd)
  {
    if (!"5".equals(paramd.l())) {
      b(paramd);
    }
    Object localObject2 = paramd.l();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = "1";
      paramd.l("1");
    }
    if (((String)localObject1).equals("0")) {
      com.xiaomi.channel.commonutils.logger.b.a("Received wrong packet with chid = 0 : " + paramd.c());
    }
    String str;
    if ((paramd instanceof com.xiaomi.smack.packet.b))
    {
      localObject2 = paramd.p("kick");
      if (localObject2 == null) {
        break label269;
      }
      str = paramd.m();
      paramd = ((com.xiaomi.smack.packet.a)localObject2).a("type");
      localObject2 = ((com.xiaomi.smack.packet.a)localObject2).a("reason");
      com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + (String)localObject1 + " userid=" + str + " type=" + paramd + " reason=" + (String)localObject2);
      if ("wait".equals(paramd))
      {
        localObject1 = ak.a().b((String)localObject1, str);
        if (localObject1 != null)
        {
          this.a.a((ak.b)localObject1);
          ((ak.b)localObject1).a(ak.c.a, 3, 0, (String)localObject2, paramd);
        }
      }
    }
    do
    {
      return;
      this.a.a((String)localObject1, str, 3, (String)localObject2, paramd);
      ak.a().a((String)localObject1, str);
      return;
      if (!(paramd instanceof c)) {
        break;
      }
      localObject2 = (c)paramd;
      if (!"redir".equals(((c)localObject2).a())) {
        break;
      }
      paramd = ((c)localObject2).p("hosts");
    } while (paramd == null);
    a(paramd);
    return;
    label269:
    this.a.e().a(this.a, (String)localObject1, paramd);
  }
  
  public void b(com.xiaomi.slim.b paramb)
  {
    Object localObject2 = paramb.a();
    Object localObject1;
    switch (paramb.c())
    {
    default: 
      localObject1 = Integer.toString(paramb.c());
      if ("SECMSG".equals(paramb.a())) {
        if (!paramb.d()) {
          this.a.e().a(this.a, (String)localObject1, paramb);
        }
      }
      break;
    }
    Object localObject3;
    do
    {
      do
      {
        ak.b localb;
        do
        {
          do
          {
            do
            {
              return;
              if ("PING".equals(localObject2))
              {
                localObject1 = paramb.k();
                if ((localObject1 != null) && (localObject1.length > 0))
                {
                  localObject1 = b.j.b((byte[])localObject1);
                  if (((b.j)localObject1).f()) {
                    at.a().a(((b.j)localObject1).g());
                  }
                }
                if ("1".equals(paramb.h()))
                {
                  this.a.a();
                  return;
                }
                h.b();
                return;
              }
              if (!"SYNC".equals(localObject2)) {
                break;
              }
              if ("CONF".equals(paramb.b()))
              {
                paramb = b.b.b(paramb.k());
                at.a().a(paramb);
                return;
              }
              if (TextUtils.equals("U", paramb.b()))
              {
                localObject1 = b.k.b(paramb.k());
                com.xiaomi.push.log.b.a(this.a).a(((b.k)localObject1).d(), ((b.k)localObject1).f(), new Date(((b.k)localObject1).h()), new Date(((b.k)localObject1).j()), ((b.k)localObject1).n() * 1024, ((b.k)localObject1).l());
                localObject1 = new com.xiaomi.slim.b();
                ((com.xiaomi.slim.b)localObject1).a(0);
                ((com.xiaomi.slim.b)localObject1).a(paramb.a(), "UCA");
                ((com.xiaomi.slim.b)localObject1).a(paramb.h());
                this.a.a(new as(this.a, (com.xiaomi.slim.b)localObject1));
                return;
              }
            } while (!TextUtils.equals("P", paramb.b()));
            localObject1 = b.i.b(paramb.k());
            localObject2 = new com.xiaomi.slim.b();
            ((com.xiaomi.slim.b)localObject2).a(0);
            ((com.xiaomi.slim.b)localObject2).a(paramb.a(), "PCA");
            ((com.xiaomi.slim.b)localObject2).a(paramb.h());
            localObject3 = new b.i();
            if (((b.i)localObject1).e()) {
              ((b.i)localObject3).a(((b.i)localObject1).d());
            }
            ((com.xiaomi.slim.b)localObject2).a(((b.i)localObject3).c(), null);
            this.a.a(new as(this.a, (com.xiaomi.slim.b)localObject2));
            com.xiaomi.channel.commonutils.logger.b.a("ACK msgP: id = " + paramb.h());
            return;
          } while (!"NOTIFY".equals(paramb.a()));
          paramb = b.h.b(paramb.k());
          com.xiaomi.channel.commonutils.logger.b.a("notify by server err = " + paramb.d() + " desc = " + paramb.f());
          return;
          com.xiaomi.channel.commonutils.logger.b.a("Recv SECMSG errCode = " + paramb.e() + " errStr = " + paramb.f());
          return;
          if (!"BIND".equals(localObject2)) {
            break;
          }
          localObject2 = b.d.b(paramb.k());
          localObject3 = paramb.j();
          localb = ak.a().b((String)localObject1, (String)localObject3);
        } while (localb == null);
        if (((b.d)localObject2).d())
        {
          com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind succeeded, chid=" + paramb.c());
          localb.a(ak.c.c, 1, 0, null, null);
          return;
        }
        paramb = ((b.d)localObject2).f();
        if ("auth".equals(paramb))
        {
          if ("invalid-sig".equals(((b.d)localObject2).h()))
          {
            com.xiaomi.channel.commonutils.logger.b.a("SMACK: bind error invalid-sig token = " + localb.c + " sec = " + localb.i);
            h.a(0, com.xiaomi.push.thrift.a.Q.a(), 1, null, 0);
          }
          localb.a(ak.c.a, 1, 5, ((b.d)localObject2).h(), paramb);
          ak.a().a((String)localObject1, (String)localObject3);
        }
        for (;;)
        {
          com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind failed, chid=" + (String)localObject1 + " reason=" + ((b.d)localObject2).h());
          return;
          if ("cancel".equals(paramb))
          {
            localb.a(ak.c.a, 1, 7, ((b.d)localObject2).h(), paramb);
            ak.a().a((String)localObject1, (String)localObject3);
          }
          else if ("wait".equals(paramb))
          {
            this.a.a(localb);
            localb.a(ak.c.a, 1, 7, ((b.d)localObject2).h(), paramb);
          }
        }
      } while (!"KICK".equals(localObject2));
      localObject2 = b.g.b(paramb.k());
      localObject3 = paramb.j();
      paramb = ((b.g)localObject2).d();
      localObject2 = ((b.g)localObject2).f();
      com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + (String)localObject1 + " userid=" + (String)localObject3 + " type=" + paramb + " reason=" + (String)localObject2);
      if (!"wait".equals(paramb)) {
        break;
      }
      localObject1 = ak.a().b((String)localObject1, (String)localObject3);
    } while (localObject1 == null);
    this.a.a((ak.b)localObject1);
    ((ak.b)localObject1).a(ak.c.a, 3, 0, (String)localObject2, paramb);
    return;
    this.a.a((String)localObject1, (String)localObject3, 3, (String)localObject2, paramb);
    ak.a().a((String)localObject1, (String)localObject3);
  }
  
  public static abstract interface PacketReceiveHandler
    extends Parcelable
  {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/PacketSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */