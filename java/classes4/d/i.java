package d;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class i
  extends u
{
  private u a;
  
  public i(u paramu)
  {
    if (paramu == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramu;
  }
  
  public u clearDeadline()
  {
    return this.a.clearDeadline();
  }
  
  public u clearTimeout()
  {
    return this.a.clearTimeout();
  }
  
  public long deadlineNanoTime()
  {
    return this.a.deadlineNanoTime();
  }
  
  public u deadlineNanoTime(long paramLong)
  {
    return this.a.deadlineNanoTime(paramLong);
  }
  
  public final u delegate()
  {
    return this.a;
  }
  
  public boolean hasDeadline()
  {
    return this.a.hasDeadline();
  }
  
  public final i setDelegate(u paramu)
  {
    if (paramu == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramu;
    return this;
  }
  
  public void throwIfReached()
    throws IOException
  {
    this.a.throwIfReached();
  }
  
  public u timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.timeout(paramLong, paramTimeUnit);
  }
  
  public long timeoutNanos()
  {
    return this.a.timeoutNanos();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */