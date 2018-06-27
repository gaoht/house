package cn.jiguang.c.f;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class d
{
  private static d e;
  private static final String[] z;
  private ArrayList<WeakReference<ScheduledFuture<?>>> a = new ArrayList();
  private ExecutorService b = Executors.newSingleThreadExecutor();
  private ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
  private long d = 5L;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "J\022p^\016z/vR\003";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 111;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "m\022wO\013q\rl\033\nf\031gK\033w\025l\001";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        e = new d();
        return;
        i = 30;
        break label99;
        i = 122;
        break label99;
        i = 2;
        break label99;
        i = 59;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  public static d a()
  {
    return e;
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (this.b.isShutdown()) {
      this.b = Executors.newSingleThreadExecutor();
    }
    this.b.execute(paramRunnable);
  }
  
  public final void b()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ScheduledFuture localScheduledFuture = (ScheduledFuture)((WeakReference)localIterator.next()).get();
        if (localScheduledFuture != null) {
          localScheduledFuture.cancel(false);
        }
      }
      this.a.clear();
    }
    catch (Exception localException)
    {
      cn.jiguang.d.d.g(z[0], z[1] + localException.getMessage());
      return;
    }
    if (!this.b.isShutdown()) {
      this.b.shutdown();
    }
    if (!this.c.isShutdown()) {
      this.c.shutdown();
    }
    this.b.awaitTermination(this.d, TimeUnit.SECONDS);
    this.c.awaitTermination(this.d, TimeUnit.SECONDS);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */