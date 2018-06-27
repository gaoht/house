package com.baidu.trace.b;

import android.os.Handler;

public final class h
  extends Thread
{
  private Handler a;
  private boolean b = true;
  
  public h(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public final void a()
  {
    this.b = false;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc2_w 22
    //   6: invokevirtual 29	java/lang/Object:wait	(J)V
    //   9: aload_0
    //   10: monitorexit
    //   11: aload_0
    //   12: getfield 17	com/baidu/trace/b/h:a	Landroid/os/Handler;
    //   15: ifnull +22 -> 37
    //   18: aload_0
    //   19: getfield 15	com/baidu/trace/b/h:b	Z
    //   22: ifeq +15 -> 37
    //   25: aload_0
    //   26: getfield 17	com/baidu/trace/b/h:a	Landroid/os/Handler;
    //   29: bipush 24
    //   31: invokevirtual 35	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   34: invokevirtual 40	android/os/Message:sendToTarget	()V
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: goto -35 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	h
    //   38	4	1	localObject	Object
    //   43	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	38	finally
    //   9	11	38	finally
    //   2	9	43	java/lang/InterruptedException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */