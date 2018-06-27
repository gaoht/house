package cn.testin.analysis;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class aw
{
  private static ScheduledExecutorService a = Executors.newScheduledThreadPool(10);
  
  public static ScheduledFuture a(Runnable paramRunnable, long paramLong)
  {
    return a(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
  }
  
  public static ScheduledFuture a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return a.schedule(paramRunnable, paramLong, paramTimeUnit);
  }
  
  public static void a(ScheduledFuture paramScheduledFuture, boolean paramBoolean)
  {
    if ((paramScheduledFuture != null) && (!paramScheduledFuture.isCancelled())) {
      paramScheduledFuture.cancel(paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */