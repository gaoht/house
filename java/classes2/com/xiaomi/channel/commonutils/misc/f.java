package com.xiaomi.channel.commonutils.misc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class f
{
  private static volatile f a;
  private ScheduledThreadPoolExecutor b = new ScheduledThreadPoolExecutor(1);
  private SparseArray<ScheduledFuture> c = new SparseArray();
  private Object d = new Object();
  private SharedPreferences e;
  
  private f(Context paramContext)
  {
    this.e = paramContext.getSharedPreferences("mipush_extra", 0);
  }
  
  public static f a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new f(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private static String a(int paramInt)
  {
    return "last_job_time" + paramInt;
  }
  
  private ScheduledFuture a(a parama)
  {
    synchronized (this.d)
    {
      parama = (ScheduledFuture)this.c.get(parama.a());
      return parama;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0);
  }
  
  public void a(Runnable paramRunnable, int paramInt)
  {
    this.b.schedule(paramRunnable, paramInt, TimeUnit.SECONDS);
  }
  
  public boolean a(a parama, int paramInt)
  {
    return a(parama, paramInt, 0);
  }
  
  public boolean a(a parama, int paramInt1, int paramInt2)
  {
    if ((parama == null) || (a(parama) != null)) {
      return false;
    }
    ??? = a(parama.a());
    Object localObject2 = new g(this, parama, (String)???);
    long l = this.e.getLong((String)???, 0L);
    l = Math.abs(System.currentTimeMillis() - l) / 1000L;
    int i = paramInt2;
    if (l < paramInt1 - paramInt2) {
      i = (int)(paramInt1 - l);
    }
    localObject2 = this.b.scheduleAtFixedRate((Runnable)localObject2, i, paramInt1, TimeUnit.SECONDS);
    synchronized (this.d)
    {
      this.c.put(parama.a(), localObject2);
      return true;
    }
  }
  
  public static abstract class a
    implements Runnable
  {
    public abstract int a();
  }
  
  private static class b
    implements Runnable
  {
    f.a c;
    
    public b(f.a parama)
    {
      this.c = parama;
    }
    
    void a() {}
    
    void b() {}
    
    public void run()
    {
      a();
      this.c.run();
      b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/misc/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */