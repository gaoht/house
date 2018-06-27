package com.mato.sdk.g.a;

import java.util.concurrent.ScheduledFuture;

public final class b
{
  private final ScheduledFuture<?> a;
  private final Runnable b;
  
  public b(ScheduledFuture<?> paramScheduledFuture, Runnable paramRunnable)
  {
    this.a = paramScheduledFuture;
    this.b = paramRunnable;
  }
  
  private boolean c()
  {
    return this.a.isCancelled();
  }
  
  private boolean d()
  {
    return this.a.isDone();
  }
  
  public final Runnable a()
  {
    return this.b;
  }
  
  public final boolean b()
  {
    return this.a.cancel(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */