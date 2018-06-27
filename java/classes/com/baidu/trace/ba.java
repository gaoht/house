package com.baidu.trace;

import com.baidu.trace.c.f.a;

final class ba
  extends Thread
{
  ba(f.a parama) {}
  
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
    //   11: getstatic 28	com/baidu/trace/c/f$a:a	Lcom/baidu/trace/c/f$a;
    //   14: aload_0
    //   15: getfield 10	com/baidu/trace/ba:a	Lcom/baidu/trace/c/f$a;
    //   18: if_acmpne +18 -> 36
    //   21: getstatic 33	com/baidu/trace/az:a	I
    //   24: ifle +6 -> 30
    //   27: invokestatic 38	com/baidu/trace/b/a:e	()V
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    //   36: getstatic 41	com/baidu/trace/c/f$a:b	Lcom/baidu/trace/c/f$a;
    //   39: aload_0
    //   40: getfield 10	com/baidu/trace/ba:a	Lcom/baidu/trace/c/f$a;
    //   43: if_acmpne -13 -> 30
    //   46: getstatic 43	com/baidu/trace/az:b	I
    //   49: ifle -19 -> 30
    //   52: invokestatic 38	com/baidu/trace/b/a:e	()V
    //   55: return
    //   56: astore_1
    //   57: goto -48 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ba
    //   31	4	1	localObject	Object
    //   56	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	9	31	finally
    //   9	11	31	finally
    //   2	9	56	java/lang/InterruptedException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */