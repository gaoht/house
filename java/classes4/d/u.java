package d;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class u
{
  public static final u NONE = new u()
  {
    public u deadlineNanoTime(long paramAnonymousLong)
    {
      return this;
    }
    
    public void throwIfReached()
      throws IOException
    {}
    
    public u timeout(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      return this;
    }
  };
  private long deadlineNanoTime;
  private boolean hasDeadline;
  private long timeoutNanos;
  
  public u clearDeadline()
  {
    this.hasDeadline = false;
    return this;
  }
  
  public u clearTimeout()
  {
    this.timeoutNanos = 0L;
    return this;
  }
  
  public final u deadline(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("duration <= 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    return deadlineNanoTime(System.nanoTime() + paramTimeUnit.toNanos(paramLong));
  }
  
  public long deadlineNanoTime()
  {
    if (!this.hasDeadline) {
      throw new IllegalStateException("No deadline");
    }
    return this.deadlineNanoTime;
  }
  
  public u deadlineNanoTime(long paramLong)
  {
    this.hasDeadline = true;
    this.deadlineNanoTime = paramLong;
    return this;
  }
  
  public boolean hasDeadline()
  {
    return this.hasDeadline;
  }
  
  public void throwIfReached()
    throws IOException
  {
    if (Thread.interrupted()) {
      throw new InterruptedIOException("thread interrupted");
    }
    if ((this.hasDeadline) && (this.deadlineNanoTime - System.nanoTime() <= 0L)) {
      throw new InterruptedIOException("deadline reached");
    }
  }
  
  public u timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    this.timeoutNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public long timeoutNanos()
  {
    return this.timeoutNanos;
  }
  
  public final void waitUntilNotified(Object paramObject)
    throws InterruptedIOException
  {
    long l2 = 0L;
    for (;;)
    {
      boolean bool;
      long l1;
      long l3;
      try
      {
        bool = hasDeadline();
        l1 = timeoutNanos();
        if ((!bool) && (l1 == 0L))
        {
          paramObject.wait();
          return;
        }
        l3 = System.nanoTime();
        if ((bool) && (l1 != 0L))
        {
          l1 = Math.min(l1, deadlineNanoTime() - l3);
          if (l1 > 0L)
          {
            l2 = l1 / 1000000L;
            paramObject.wait(l2, (int)(l1 - l2 * 1000000L));
            l2 = System.nanoTime() - l3;
          }
          if (l2 < l1) {
            break;
          }
          throw new InterruptedIOException("timeout");
        }
      }
      catch (InterruptedException paramObject)
      {
        throw new InterruptedIOException("interrupted");
      }
      if (bool)
      {
        l1 = deadlineNanoTime();
        l1 -= l3;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */