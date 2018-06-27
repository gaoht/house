package com.baidu.trace.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public final class f
  extends Thread
{
  private Context a = null;
  private Handler b;
  private boolean c = true;
  private int d = 10;
  
  public f(Context paramContext, Handler paramHandler)
  {
    this.a = paramContext;
    this.b = paramHandler;
  }
  
  public final void a()
  {
    this.c = false;
  }
  
  public final void b()
  {
    a.e();
    this.d -= 1;
    try
    {
      sleep(6000L);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public final void run()
  {
    while (this.c) {
      if (d.a(this.a))
      {
        e locale = new e(this);
        a.a(a.a.a, locale);
      }
      else
      {
        this.c = false;
        if (this.b != null) {
          this.b.obtainMessage(19).sendToTarget();
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */