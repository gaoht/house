package com.unionpay.sdk;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.UUID;

class af
  extends bh
{
  private static volatile af a = null;
  private HashMap b = new HashMap();
  private bg c = t.a();
  private boolean d = false;
  
  static
  {
    try
    {
      ar.a().register(a());
      return;
    }
    catch (Throwable localThrowable)
    {
      k.a(localThrowable);
    }
  }
  
  public static af a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new af();
      }
      return a;
    }
    finally {}
  }
  
  private final void a(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().isEmpty()))
    {
      long l3 = o.c();
      long l4 = o.e();
      long l2 = l4 - l3;
      long l1 = l2;
      if (l2 < 500L) {
        l1 = -1000L;
      }
      if (ag.a)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.format("sessionStartTime   = %d\n", new Object[] { Long.valueOf(l3) }));
        localStringBuilder.append(String.format("sessionTempEndTime = %d\n", new Object[] { Long.valueOf(l4) }));
        localStringBuilder.append(String.format("duration           = %d", new Object[] { Long.valueOf(l1) }));
        k.a(new String[] { localStringBuilder.toString() });
      }
      this.c.a(paramString, (int)l1 / 1000);
    }
  }
  
  public final void onTDEBEventSession(ag.a parama)
  {
    long l2 = 0L;
    int i = 1;
    if ((parama == null) || (parama.a == null)) {}
    do
    {
      int j;
      do
      {
        return;
        j = Integer.parseInt(String.valueOf(parama.a.get("apiType")));
      } while ((j != 1) && (j != 2) && (j != 3) && (j != 6) && (j != 7));
      parama.a.put("controller", a());
    } while (String.valueOf(parama.a.get("occurTime")).trim().isEmpty());
    parama = parama.a;
    try
    {
      switch (Integer.parseInt(String.valueOf(parama.get("apiType"))))
      {
      case 1: 
        c.a().a(true);
        return;
      }
    }
    catch (Throwable parama)
    {
      k.a(parama);
      return;
    }
    long l1 = o.c();
    long l3 = o.e();
    if (l3 > l1)
    {
      l1 = l3;
      label188:
      l3 = Long.valueOf(String.valueOf(parama.get("occurTime"))).longValue();
      if (l3 - l1 > d.k)
      {
        k.a("[Session] - New session!");
        a(o.b());
        parama = UUID.randomUUID().toString();
        l1 = o.e();
        if (0L != l1) {
          break label703;
        }
        l1 = l2;
        label252:
        if ((d.c == null) || (!j.c(d.c))) {
          break label713;
        }
      }
    }
    for (;;)
    {
      if (d.c != null) {
        l.a(d.c, "UPpref_longtime", "UPpref.session.key", parama);
      }
      if (d.c != null) {
        l.a(d.c, "UPpref_longtime", "UPpref.start.key", l3);
      }
      k.a(String.format("sessionId: %s, status: %s", new Object[] { parama, String.valueOf(this.c.a(parama, l3, l1, i)) }));
      o.a("");
      this.d = true;
      for (;;)
      {
        c.a().a(true);
        return;
        k.a("[Session] - Same session as before!");
      }
      String str = String.valueOf(parama.get("pageName"));
      if (parama.containsKey("sessionEnd"))
      {
        a(o.b());
        c.a().a(true);
        return;
      }
      o.a(Long.valueOf(String.valueOf(parama.get("occurTime"))).longValue());
      o.a(str);
      this.d = false;
      return;
      l1 = Long.valueOf(String.valueOf(parama.get("occurTime"))).longValue();
      str = String.valueOf(parama.get("pageName"));
      if (d.c == null) {}
      for (parama = "";; parama = l.b(d.c, "UPpref_shorttime", "UPpref.lastactivity.key", ""))
      {
        if ((this.b.containsKey(str)) || (str == null)) {
          break label563;
        }
        if (d.c != null) {
          l.a(d.c, "UPpref_shorttime", "UPpref.actstart.key", l1);
        }
        d.j = this.c.a(o.b(), str, l1, parama, SystemClock.elapsedRealtime());
        if (this.b.containsKey(str)) {
          break;
        }
        this.b.put(str, Long.valueOf(d.j));
        return;
      }
      label563:
      break;
      str = String.valueOf(parama.get("pageName"));
      if (!this.b.containsKey(str)) {
        break;
      }
      if (!this.b.containsKey(str)) {
        parama = Long.valueOf(d.j);
      }
      for (;;)
      {
        l1 = parama.longValue();
        if (l1 != -1L) {
          this.c.a(l1, SystemClock.elapsedRealtime());
        }
        k.b(new String[] { "pages.size(): ", String.valueOf(this.b.size()) });
        if (!this.d) {
          break;
        }
        o.a(str);
        return;
        parama = (Long)this.b.get(str);
        this.b.remove(str);
      }
      return;
      break label188;
      label703:
      l1 = l3 - l1;
      break label252;
      label713:
      i = -1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */