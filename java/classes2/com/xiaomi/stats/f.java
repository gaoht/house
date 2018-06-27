package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.channel.commonutils.stats.a.a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.at;
import com.xiaomi.push.thrift.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.thrift.protocol.k.a;

public class f
{
  private String a;
  private boolean b = false;
  private int c;
  private long d;
  private e e;
  private com.xiaomi.channel.commonutils.stats.a f = com.xiaomi.channel.commonutils.stats.a.a();
  
  private com.xiaomi.push.thrift.b a(a.a parama)
  {
    com.xiaomi.push.thrift.b localb = null;
    if (parama.a == 0)
    {
      if ((parama.c instanceof com.xiaomi.push.thrift.b)) {
        localb = (com.xiaomi.push.thrift.b)parama.c;
      }
      return localb;
    }
    localb = f();
    localb.a(com.xiaomi.push.thrift.a.ac.a());
    localb.c(parama.a);
    localb.c(parama.b);
    return localb;
  }
  
  public static f a()
  {
    return a.a;
  }
  
  private c b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    c localc = new c(this.a, localArrayList);
    if (!d.f(this.e.a)) {
      localc.a(com.xiaomi.channel.commonutils.android.e.f(this.e.a));
    }
    org.apache.thrift.transport.b localb = new org.apache.thrift.transport.b(paramInt);
    org.apache.thrift.protocol.e locale = new k.a().a(localb);
    try
    {
      localc.b(locale);
      localLinkedList = this.f.c();
    }
    catch (org.apache.thrift.f localf2)
    {
      try
      {
        LinkedList localLinkedList;
        while (localLinkedList.size() > 0)
        {
          com.xiaomi.push.thrift.b localb1 = a((a.a)localLinkedList.getLast());
          if (localb1 != null) {
            localb1.b(locale);
          }
          if (localb.a_() > paramInt) {
            return localc;
          }
          if (localb1 != null) {
            localArrayList.add(localb1);
          }
          localLinkedList.removeLast();
        }
      }
      catch (NoSuchElementException localNoSuchElementException)
      {
        return localc;
        localf2 = localf2;
      }
      catch (org.apache.thrift.f localf1) {}
    }
    return localc;
  }
  
  public static e b()
  {
    synchronized (a.a)
    {
      e locale = a.a.e;
      return locale;
    }
  }
  
  private void g()
  {
    if ((this.b) && (System.currentTimeMillis() - this.d > this.c))
    {
      this.b = false;
      this.d = 0L;
    }
  }
  
  public void a(int paramInt)
  {
    int i = 604800000;
    if (paramInt > 0)
    {
      paramInt *= 1000;
      if (paramInt <= 604800000) {
        break label88;
      }
      paramInt = i;
    }
    label88:
    for (;;)
    {
      if ((this.c != paramInt) || (!this.b))
      {
        this.b = true;
        this.d = System.currentTimeMillis();
        this.c = paramInt;
        com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + paramInt + " start = " + this.d);
      }
      return;
    }
  }
  
  public void a(XMPushService paramXMPushService)
  {
    try
    {
      this.e = new e(paramXMPushService);
      this.a = "";
      at.a().a(new g(this));
      return;
    }
    finally
    {
      paramXMPushService = finally;
      throw paramXMPushService;
    }
  }
  
  void a(com.xiaomi.push.thrift.b paramb)
  {
    try
    {
      this.f.a(paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  boolean d()
  {
    g();
    return (this.b) && (this.f.b() > 0);
  }
  
  c e()
  {
    c localc = null;
    try
    {
      if (d())
      {
        int i = 750;
        if (!d.f(this.e.a)) {
          i = 375;
        }
        localc = b(i);
      }
      return localc;
    }
    finally {}
  }
  
  com.xiaomi.push.thrift.b f()
  {
    try
    {
      com.xiaomi.push.thrift.b localb = new com.xiaomi.push.thrift.b();
      localb.a(d.k(this.e.a));
      localb.a = 0;
      localb.c = 1;
      localb.d((int)(System.currentTimeMillis() / 1000L));
      if (this.e.b != null) {
        localb.e(this.e.b.f());
      }
      return localb;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static class a
  {
    static final f a = new f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/stats/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */