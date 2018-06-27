package com.superrtc.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Executor;

public class f
  extends Thread
  implements Executor
{
  private final Object a = new Object();
  private Handler b = null;
  private boolean c = false;
  private long d;
  
  public boolean checkOnLooperThread()
  {
    return Thread.currentThread().getId() == this.d;
  }
  
  /* Error */
  public void execute(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/superrtc/a/f:c	Z
    //   6: ifne +14 -> 20
    //   9: ldc 46
    //   11: ldc 48
    //   13: invokestatic 54	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 27	com/superrtc/a/f:b	Landroid/os/Handler;
    //   24: aload_1
    //   25: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   28: pop
    //   29: goto -12 -> 17
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	f
    //   0	37	1	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
    //   20	29	32	finally
  }
  
  public void requestStart()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        this.c = true;
        this.b = null;
        start();
        synchronized (this.a)
        {
          Handler localHandler = this.b;
          if (localHandler == null) {
            try
            {
              this.a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.e("LooperExecutor", "Can not start looper thread");
              this.c = false;
            }
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void requestStop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/superrtc/a/f:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 29	com/superrtc/a/f:c	Z
    //   19: aload_0
    //   20: getfield 27	com/superrtc/a/f:b	Landroid/os/Handler;
    //   23: new 8	com/superrtc/a/f$1
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 78	com/superrtc/a/f$1:<init>	(Lcom/superrtc/a/f;)V
    //   31: invokevirtual 60	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   34: pop
    //   35: goto -24 -> 11
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	f
    //   6	2	1	bool	boolean
    //   38	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   14	35	38	finally
  }
  
  public void run()
  {
    
    synchronized (this.a)
    {
      Log.d("LooperExecutor", "Looper thread started.");
      this.b = new Handler();
      this.d = Thread.currentThread().getId();
      this.a.notify();
      Looper.loop();
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */