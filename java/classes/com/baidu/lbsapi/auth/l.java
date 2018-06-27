package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

class l
  extends Thread
{
  Handler a = null;
  private Object b = new Object();
  private boolean c = false;
  
  l() {}
  
  l(String paramString)
  {
    super(paramString);
  }
  
  public void a()
  {
    if (a.a) {
      a.a("Looper thread quit()");
    }
    this.a.getLooper().quit();
  }
  
  public void b()
  {
    synchronized (this.b)
    {
      try
      {
        if (!this.c) {
          this.b.wait();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public void c()
  {
    synchronized (this.b)
    {
      this.c = true;
      this.b.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.a = new Handler();
    if (a.a) {
      a.a("new Handler() finish!!");
    }
    Looper.loop();
    if (a.a) {
      a.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */