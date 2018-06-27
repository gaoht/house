package com.alipay.b.h;

final class c
  implements Runnable
{
  c(b paramb) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 25	android/os/Process:setThreadPriority	(I)V
    //   4: aload_0
    //   5: getfield 12	com/alipay/b/h/c:a	Lcom/alipay/b/h/b;
    //   8: invokestatic 30	com/alipay/b/h/b:a	(Lcom/alipay/b/h/b;)Ljava/util/LinkedList;
    //   11: invokevirtual 36	java/util/LinkedList:isEmpty	()Z
    //   14: ifne +53 -> 67
    //   17: aload_0
    //   18: getfield 12	com/alipay/b/h/c:a	Lcom/alipay/b/h/b;
    //   21: invokestatic 30	com/alipay/b/h/b:a	(Lcom/alipay/b/h/b;)Ljava/util/LinkedList;
    //   24: iconst_0
    //   25: invokevirtual 40	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   28: checkcast 6	java/lang/Runnable
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 12	com/alipay/b/h/c:a	Lcom/alipay/b/h/b;
    //   36: invokestatic 30	com/alipay/b/h/b:a	(Lcom/alipay/b/h/b;)Ljava/util/LinkedList;
    //   39: iconst_0
    //   40: invokevirtual 43	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   43: pop
    //   44: aload_1
    //   45: ifnull -41 -> 4
    //   48: aload_1
    //   49: invokeinterface 45 1 0
    //   54: goto -50 -> 4
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 12	com/alipay/b/h/c:a	Lcom/alipay/b/h/b;
    //   62: invokestatic 49	com/alipay/b/h/b:b	(Lcom/alipay/b/h/b;)Ljava/lang/Thread;
    //   65: pop
    //   66: return
    //   67: aload_0
    //   68: getfield 12	com/alipay/b/h/c:a	Lcom/alipay/b/h/b;
    //   71: invokestatic 49	com/alipay/b/h/b:b	(Lcom/alipay/b/h/b;)Ljava/lang/Thread;
    //   74: pop
    //   75: return
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 12	com/alipay/b/h/c:a	Lcom/alipay/b/h/b;
    //   81: invokestatic 49	com/alipay/b/h/b:b	(Lcom/alipay/b/h/b;)Ljava/lang/Thread;
    //   84: pop
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	c
    //   31	18	1	localRunnable	Runnable
    //   57	1	1	localException	Exception
    //   76	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	57	java/lang/Exception
    //   4	44	57	java/lang/Exception
    //   48	54	57	java/lang/Exception
    //   0	4	76	finally
    //   4	44	76	finally
    //   48	54	76	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/b/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */