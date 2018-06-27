package com.superrtc.call;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class u
{
  public static void awaitUninterruptibly(CountDownLatch paramCountDownLatch)
  {
    executeUninterruptibly(new b()
    {
      public void run()
        throws InterruptedException
      {
        this.a.await();
      }
    });
  }
  
  public static boolean awaitUninterruptibly(CountDownLatch paramCountDownLatch, long paramLong)
  {
    boolean bool1 = false;
    long l3 = SystemClock.elapsedRealtime();
    int i = 0;
    long l1 = paramLong;
    for (;;)
    {
      int j;
      long l2;
      try
      {
        boolean bool2 = paramCountDownLatch.await(l1, TimeUnit.MILLISECONDS);
        bool1 = bool2;
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        j = 1;
        i = 1;
        l2 = paramLong - (SystemClock.elapsedRealtime() - l3);
        l1 = l2;
      }
      if (l2 <= 0L) {
        i = j;
      }
    }
  }
  
  public static void executeUninterruptibly(b paramb)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramb.run();
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = 1;
      }
    }
  }
  
  public static <V> V invokeUninterruptibly(Handler paramHandler, final Callable<V> paramCallable)
  {
    a locala = new a();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          this.a.a = paramCallable.call();
          localCountDownLatch.countDown();
          return;
        }
        catch (Exception localException)
        {
          throw new RuntimeException("Callable threw exception: " + localException);
        }
      }
    });
    awaitUninterruptibly(localCountDownLatch);
    return (V)locala.a;
  }
  
  public static void invokeUninterruptibly(Handler paramHandler, Runnable paramRunnable)
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        this.a.run();
        localCountDownLatch.countDown();
      }
    });
    awaitUninterruptibly(localCountDownLatch);
  }
  
  public static void joinUninterruptibly(Thread paramThread)
  {
    executeUninterruptibly(new b()
    {
      public void run()
        throws InterruptedException
      {
        this.a.join();
      }
    });
  }
  
  public static boolean joinUninterruptibly(Thread paramThread, long paramLong)
  {
    long l2 = SystemClock.elapsedRealtime();
    int i = 0;
    long l1 = paramLong;
    for (;;)
    {
      if (l1 > 0L) {}
      try
      {
        paramThread.join(l1);
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        if (paramThread.isAlive()) {
          break;
        }
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        l1 = paramLong - (SystemClock.elapsedRealtime() - l2);
        i = 1;
      }
    }
    return false;
  }
  
  class a
  {
    public V a;
  }
  
  public static abstract interface b
  {
    public abstract void run()
      throws InterruptedException;
  }
  
  public static class c
  {
    private Thread a = Thread.currentThread();
    
    public void checkIsOnValidThread()
    {
      if (this.a == null) {
        this.a = Thread.currentThread();
      }
      if (Thread.currentThread() != this.a) {
        throw new IllegalStateException("Wrong thread");
      }
    }
    
    public void detachThread()
    {
      this.a = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */