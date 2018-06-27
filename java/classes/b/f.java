package b;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class f
  implements Closeable
{
  private final Object a = new Object();
  private final List<e> b = new ArrayList();
  private final ScheduledExecutorService c = c.a();
  private ScheduledFuture<?> d;
  private boolean e;
  private boolean f;
  
  private void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < -1L) {
      throw new IllegalArgumentException("Delay must be >= -1");
    }
    if (paramLong == 0L)
    {
      cancel();
      return;
    }
    synchronized (this.a)
    {
      if (this.e) {
        return;
      }
    }
    c();
    if (paramLong != -1L) {
      this.d = this.c.schedule(new Runnable()
      {
        public void run()
        {
          synchronized (f.a(f.this))
          {
            f.a(f.this, null);
            f.this.cancel();
            return;
          }
        }
      }, paramLong, paramTimeUnit);
    }
  }
  
  private void a(List<e> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((e)paramList.next()).a();
    }
  }
  
  private void b()
  {
    if (this.f) {
      throw new IllegalStateException("Object already closed");
    }
  }
  
  private void c()
  {
    if (this.d != null)
    {
      this.d.cancel(true);
      this.d = null;
    }
  }
  
  e a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      b();
      paramRunnable = new e(this, paramRunnable);
      if (this.e)
      {
        paramRunnable.a();
        return paramRunnable;
      }
      this.b.add(paramRunnable);
    }
  }
  
  void a()
    throws CancellationException
  {
    synchronized (this.a)
    {
      b();
      if (this.e) {
        throw new CancellationException();
      }
    }
  }
  
  void a(e parame)
  {
    synchronized (this.a)
    {
      b();
      this.b.remove(parame);
      return;
    }
  }
  
  public void cancel()
  {
    synchronized (this.a)
    {
      b();
      if (this.e) {
        return;
      }
      c();
      this.e = true;
      ArrayList localArrayList = new ArrayList(this.b);
      a(localArrayList);
      return;
    }
  }
  
  public void cancelAfter(long paramLong)
  {
    a(paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.f) {
        return;
      }
      c();
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).close();
      }
    }
    this.b.clear();
    this.f = true;
  }
  
  public d getToken()
  {
    synchronized (this.a)
    {
      b();
      d locald = new d(this);
      return locald;
    }
  }
  
  public boolean isCancellationRequested()
  {
    synchronized (this.a)
    {
      b();
      boolean bool = this.e;
      return bool;
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested()) });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */