package com.megvii.zhimasdk.b.a.i.c.a;

import com.megvii.zhimasdk.b.a.o.a;
import java.util.Date;
import java.util.concurrent.locks.Condition;

@Deprecated
public class h
{
  private final Condition a;
  private final f b;
  private Thread c;
  private boolean d;
  
  public h(Condition paramCondition, f paramf)
  {
    a.a(paramCondition, "Condition");
    this.a = paramCondition;
    this.b = paramf;
  }
  
  public void a()
  {
    if (this.c == null) {
      throw new IllegalStateException("Nobody waiting on this object.");
    }
    this.a.signalAll();
  }
  
  public boolean a(Date paramDate)
  {
    if (this.c != null) {
      throw new IllegalStateException("A thread is already waiting on this object.\ncaller: " + Thread.currentThread() + "\nwaiter: " + this.c);
    }
    if (this.d) {
      throw new InterruptedException("Operation interrupted");
    }
    this.c = Thread.currentThread();
    if (paramDate != null) {}
    boolean bool;
    for (;;)
    {
      try
      {
        bool = this.a.awaitUntil(paramDate);
        if (!this.d) {
          break;
        }
        throw new InterruptedException("Operation interrupted");
      }
      finally
      {
        this.c = null;
      }
      this.a.await();
      bool = true;
    }
    this.c = null;
    return bool;
  }
  
  public void b()
  {
    this.d = true;
    this.a.signalAll();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */