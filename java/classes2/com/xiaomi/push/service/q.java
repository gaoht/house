package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.l;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;

public class q
  extends XMPushService.h
{
  private XMPushService b;
  private byte[] c;
  private String d;
  private String e;
  private String f;
  
  public q(XMPushService paramXMPushService, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    super(9);
    this.b = paramXMPushService;
    this.d = paramString1;
    this.c = paramArrayOfByte;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  public void a()
  {
    Object localObject1 = o.a(this.b);
    if (localObject1 == null)
    {
      try
      {
        n localn = o.a(this.b, this.d, this.e, this.f);
        localObject1 = localn;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          b.a(localIOException);
        }
      }
      catch (JSONException localJSONException)
      {
        b.a(localJSONException);
      }
      if (localObject1 != null) {
        break label71;
      }
      b.d("no account for mipush");
      r.a(this.b, 70000002, "no account.");
    }
    label71:
    ak.b localb;
    do
    {
      return;
      break;
      localObject2 = ak.a().c("5");
      if (((Collection)localObject2).isEmpty())
      {
        localObject1 = ((n)localObject1).a(this.b);
        aa.a(this.b, (ak.b)localObject1);
        ak.a().a((ak.b)localObject1);
      }
      for (;;)
      {
        if (!this.b.f()) {
          break label222;
        }
        try
        {
          if (((ak.b)localObject1).m != ak.c.c) {
            break;
          }
          aa.a(this.b, this.d, this.c);
          return;
        }
        catch (l locall)
        {
          b.a(locall);
          this.b.a(10, locall);
          return;
        }
        localb = (ak.b)((Collection)localObject2).iterator().next();
      }
    } while (localb.m != ak.c.a);
    Object localObject2 = this.b;
    XMPushService localXMPushService = this.b;
    localXMPushService.getClass();
    ((XMPushService)localObject2).a(new XMPushService.a(localXMPushService, localb));
    return;
    label222:
    this.b.a(true);
  }
  
  public String b()
  {
    return "register app";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */