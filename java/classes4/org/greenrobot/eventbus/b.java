package org.greenrobot.eventbus;

import android.util.Log;
import java.util.concurrent.ExecutorService;

final class b
  implements Runnable
{
  private final i a;
  private final c b;
  private volatile boolean c;
  
  b(c paramc)
  {
    this.b = paramc;
    this.a = new i();
  }
  
  public void enqueue(n paramn, Object paramObject)
  {
    paramn = h.a(paramn, paramObject);
    try
    {
      this.a.a(paramn);
      if (!this.c)
      {
        this.c = true;
        this.b.a().execute(this);
      }
      return;
    }
    finally {}
  }
  
  public void run()
  {
    try
    {
      h localh2 = this.a.a(1000);
      localh1 = localh2;
      if (localh2 != null) {}
    }
    catch (InterruptedException localInterruptedException)
    {
      h localh1;
      localInterruptedException = localInterruptedException;
      Log.w("Event", Thread.currentThread().getName() + " was interruppted", localInterruptedException);
      return;
    }
    finally
    {
      this.c = false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */