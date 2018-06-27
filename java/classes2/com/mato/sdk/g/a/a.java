package com.mato.sdk.g.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static a a = new a();
  private ScheduledThreadPoolExecutor b = null;
  private final List<b> c = new ArrayList();
  
  private a()
  {
    this.b.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
    this.b.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
  }
  
  private b a(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("task can not be null");
    }
    try
    {
      ScheduledFuture localScheduledFuture1 = this.b.scheduleAtFixedRate(paramRunnable, 0L, paramInt, TimeUnit.MILLISECONDS);
      if (localScheduledFuture1 == null) {
        return null;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    catch (Exception localException)
    {
      ScheduledFuture localScheduledFuture2;
      for (;;)
      {
        new StringBuilder("unknown exception: ").append(localException.getMessage());
        localScheduledFuture2 = null;
      }
      paramRunnable = new b(localScheduledFuture2, paramRunnable);
      this.c.add(paramRunnable);
    }
    return paramRunnable;
  }
  
  public static a b()
  {
    return a;
  }
  
  public final b a(c paramc)
  {
    if (paramc == null) {
      throw new IllegalArgumentException("task can not be null");
    }
    try
    {
      ScheduledFuture localScheduledFuture1 = this.b.scheduleAtFixedRate(paramc, paramc.c(), paramc.a(), TimeUnit.MILLISECONDS);
      if (localScheduledFuture1 == null) {
        return null;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    catch (Exception localException)
    {
      ScheduledFuture localScheduledFuture2;
      for (;;)
      {
        new StringBuilder("unknown exception: ").append(localException.getMessage());
        localScheduledFuture2 = null;
      }
      paramc = new b(localScheduledFuture2, paramc);
      this.c.add(paramc);
    }
    return paramc;
  }
  
  public final b a(Runnable paramRunnable, long paramLong)
  {
    try
    {
      ScheduledFuture localScheduledFuture1 = this.b.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
      if (localScheduledFuture1 == null) {
        return null;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    catch (Exception localException)
    {
      ScheduledFuture localScheduledFuture2;
      for (;;)
      {
        new StringBuilder("unknown exception: ").append(localException.getMessage());
        localScheduledFuture2 = null;
      }
      return new b(localScheduledFuture2, paramRunnable);
    }
  }
  
  public final void a()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */