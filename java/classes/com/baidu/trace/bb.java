package com.baidu.trace;

import android.os.Handler;

final class bb
  extends Thread
{
  bb(Handler paramHandler) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc2_w 18
    //   6: invokevirtual 25	java/lang/Object:wait	(J)V
    //   9: aload_0
    //   10: monitorexit
    //   11: getstatic 31	com/baidu/trace/bd:f	I
    //   14: ifle +32 -> 46
    //   17: aload_0
    //   18: getfield 10	com/baidu/trace/bb:a	Landroid/os/Handler;
    //   21: ifnull +25 -> 46
    //   24: aload_0
    //   25: getfield 10	com/baidu/trace/bb:a	Landroid/os/Handler;
    //   28: sipush 141
    //   31: invokevirtual 37	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   34: astore_1
    //   35: aload_1
    //   36: sipush 141
    //   39: putfield 42	android/os/Message:arg1	I
    //   42: aload_1
    //   43: invokevirtual 45	android/os/Message:sendToTarget	()V
    //   46: iconst_0
    //   47: putstatic 31	com/baidu/trace/bd:f	I
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: goto -48 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	bb
    //   34	9	1	localMessage	android.os.Message
    //   51	4	1	localObject	Object
    //   56	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	51	finally
    //   9	11	51	finally
    //   2	9	56	java/lang/InterruptedException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */