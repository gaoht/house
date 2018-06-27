package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ak
{
  private static ak a;
  private ConcurrentHashMap<String, HashMap<String, b>> b = new ConcurrentHashMap();
  private List<a> c = new ArrayList();
  
  public static ak a()
  {
    try
    {
      if (a == null) {
        a = new ak();
      }
      ak localak = a;
      return localak;
    }
    finally {}
  }
  
  private String d(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("@");
      str = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  public void a(Context paramContext)
  {
    try
    {
      paramContext = this.b.values().iterator();
      while (paramContext.hasNext())
      {
        Iterator localIterator = ((HashMap)paramContext.next()).values().iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).a(c.a, 1, 3, null, null);
        }
      }
    }
    finally {}
  }
  
  public void a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = this.b.values().iterator();
      while (paramContext.hasNext())
      {
        Iterator localIterator = ((HashMap)paramContext.next()).values().iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).a(c.a, 2, paramInt, null, null);
        }
      }
    }
    finally {}
  }
  
  public void a(a parama)
  {
    try
    {
      this.c.add(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(b paramb)
  {
    try
    {
      HashMap localHashMap2 = (HashMap)this.b.get(paramb.h);
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        localHashMap1 = new HashMap();
        this.b.put(paramb.h, localHashMap1);
      }
      localHashMap1.put(d(paramb.b), paramb);
      paramb = this.c.iterator();
      while (paramb.hasNext()) {
        ((a)paramb.next()).a();
      }
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramString);
      if (localHashMap != null)
      {
        localHashMap.clear();
        this.b.remove(paramString);
      }
      paramString = this.c.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).a();
      }
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramString1);
      if (localHashMap != null)
      {
        localHashMap.remove(d(paramString2));
        if (localHashMap.isEmpty()) {
          this.b.remove(paramString1);
        }
      }
      paramString1 = this.c.iterator();
      while (paramString1.hasNext()) {
        ((a)paramString1.next()).a();
      }
    }
    finally {}
  }
  
  /* Error */
  public b b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/xiaomi/push/service/ak:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 106	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 82	java/util/HashMap
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_1
    //   25: aload_0
    //   26: aload_2
    //   27: invokespecial 115	com/xiaomi/push/service/ak:d	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 9	com/xiaomi/push/service/ak$b
    //   36: astore_1
    //   37: goto -17 -> 20
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ak
    //   0	45	1	paramString1	String
    //   0	45	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	14	40	finally
    //   24	37	40	finally
  }
  
  public ArrayList<b> b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((HashMap)localIterator.next()).values());
      }
    }
    finally {}
    return localArrayList1;
  }
  
  public List<String> b(String paramString)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator1 = this.b.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
        while (localIterator2.hasNext())
        {
          b localb = (b)localIterator2.next();
          if (paramString.equals(localb.a)) {
            localArrayList.add(localb.h);
          }
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public int c()
  {
    try
    {
      int i = this.b.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public Collection<b> c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/xiaomi/push/service/ak:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 154	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +15 -> 25
    //   13: new 31	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 32	java/util/ArrayList:<init>	()V
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: getfield 29	com/xiaomi/push/service/ak:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: aload_1
    //   30: invokevirtual 106	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 82	java/util/HashMap
    //   36: invokevirtual 157	java/util/HashMap:clone	()Ljava/lang/Object;
    //   39: checkcast 82	java/util/HashMap
    //   42: invokevirtual 83	java/util/HashMap:values	()Ljava/util/Collection;
    //   45: astore_1
    //   46: goto -25 -> 21
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ak
    //   0	54	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	21	49	finally
    //   25	46	49	finally
  }
  
  public void d()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void e()
  {
    try
    {
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public static class b
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public b k;
    public Context l;
    ak.c m = ak.c.a;
    private int n = 0;
    private List<a> o = new ArrayList();
    private XMPushService p;
    private XMPushService.b q = new XMPushService.b(this);
    
    public b() {}
    
    public b(XMPushService paramXMPushService)
    {
      this.p = paramXMPushService;
      a(new al(this));
    }
    
    public long a()
    {
      return 1000L * ((Math.random() * 20.0D - 10.0D) + (this.n + 1) * 15);
    }
    
    public String a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknown";
      case 1: 
        return "OPEN";
      case 2: 
        return "CLOSE";
      }
      return "KICK";
    }
    
    public void a(a parama)
    {
      synchronized (this.o)
      {
        this.o.add(parama);
        return;
      }
    }
    
    public void a(ak.c paramc, int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      boolean bool = true;
      synchronized (this.o)
      {
        Iterator localIterator = this.o.iterator();
        if (localIterator.hasNext()) {
          ((a)localIterator.next()).a(this.m, paramc, paramInt2);
        }
      }
      if (this.m != paramc)
      {
        com.xiaomi.channel.commonutils.logger.b.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[] { this.m, paramc, a(paramInt1), am.a(paramInt2), paramString1, paramString2, this.h }));
        this.m = paramc;
      }
      if (this.k == null) {
        com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
      }
      do
      {
        return;
        if (paramInt1 == 2)
        {
          this.k.a(this.l, this, paramInt2);
          return;
        }
        if (paramInt1 == 3)
        {
          this.k.a(this.l, this, paramString2, paramString1);
          return;
        }
      } while (paramInt1 != 1);
      if (paramc == ak.c.c)
      {
        if ((bool) || (!"wait".equals(paramString2))) {
          break label251;
        }
        this.n += 1;
      }
      for (;;)
      {
        this.k.a(this.l, this, bool, paramInt2, paramString1);
        return;
        bool = false;
        break;
        label251:
        if (bool) {
          this.n = 0;
        }
      }
    }
    
    public void b(a parama)
    {
      synchronized (this.o)
      {
        this.o.remove(parama);
        return;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(ak.c paramc1, ak.c paramc2, int paramInt);
    }
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */