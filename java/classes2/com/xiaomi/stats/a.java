package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak.b;
import com.xiaomi.push.service.ak.b.a;
import com.xiaomi.push.service.ak.c;

class a
  implements ak.b.a
{
  private XMPushService a;
  private ak.b b;
  private com.xiaomi.smack.a c;
  private ak.c d;
  private int e;
  private boolean f = false;
  
  a(XMPushService paramXMPushService, ak.b paramb)
  {
    this.a = paramXMPushService;
    this.d = ak.c.b;
    this.b = paramb;
  }
  
  private void b()
  {
    this.b.b(this);
  }
  
  private void c()
  {
    b();
    if (!this.f) {}
    while (this.e == 11) {
      return;
    }
    com.xiaomi.push.thrift.b localb2 = f.a().f();
    Object localObject = localb2;
    switch (c.a[this.d.ordinal()])
    {
    default: 
      localObject = localb2;
    }
    while (localObject != null)
    {
      ((com.xiaomi.push.thrift.b)localObject).b(this.c.d());
      ((com.xiaomi.push.thrift.b)localObject).d(this.b.b);
      ((com.xiaomi.push.thrift.b)localObject).c = 1;
      try
      {
        ((com.xiaomi.push.thrift.b)localObject).a((byte)Integer.parseInt(this.b.h));
        f.a().a((com.xiaomi.push.thrift.b)localObject);
        return;
        if (this.e == 17)
        {
          localb2.b = com.xiaomi.push.thrift.a.I.a();
          localObject = localb2;
          continue;
        }
        if (this.e == 21)
        {
          localb2.b = com.xiaomi.push.thrift.a.P.a();
          localObject = localb2;
          continue;
        }
        try
        {
          localObject = d.c(f.b().a());
          localb2.b = ((d.a)localObject).a.a();
          localb2.c(((d.a)localObject).b);
          localObject = localb2;
        }
        catch (NullPointerException localNullPointerException)
        {
          localb1 = null;
        }
        continue;
        localb2.b = com.xiaomi.push.thrift.a.E.a();
        com.xiaomi.push.thrift.b localb1 = localb2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  void a()
  {
    this.b.a(this);
    this.c = this.a.h();
  }
  
  public void a(ak.c paramc1, ak.c paramc2, int paramInt)
  {
    if ((!this.f) && (paramc1 == ak.c.b))
    {
      this.d = paramc2;
      this.e = paramInt;
      this.f = true;
    }
    this.a.a(new b(this, 4));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/stats/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */