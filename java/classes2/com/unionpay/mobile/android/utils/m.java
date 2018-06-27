package com.unionpay.mobile.android.utils;

final class m
  extends Thread
{
  m(k paramk) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 19	java/lang/Thread:run	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc2_w 20
    //   10: invokevirtual 27	java/lang/Object:wait	(J)V
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: getfield 10	com/unionpay/mobile/android/utils/m:a	Lcom/unionpay/mobile/android/utils/k;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: invokestatic 33	com/unionpay/mobile/android/utils/k:b	()Lorg/simalliance/openmobileapi/SEService;
    //   25: ifnull +12 -> 37
    //   28: invokestatic 33	com/unionpay/mobile/android/utils/k:b	()Lorg/simalliance/openmobileapi/SEService;
    //   31: invokevirtual 39	org/simalliance/openmobileapi/SEService:isConnected	()Z
    //   34: ifne +33 -> 67
    //   37: ldc 41
    //   39: ldc 43
    //   41: invokestatic 49	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: getfield 10	com/unionpay/mobile/android/utils/m:a	Lcom/unionpay/mobile/android/utils/k;
    //   49: invokestatic 52	com/unionpay/mobile/android/utils/k:b	(Lcom/unionpay/mobile/android/utils/k;)Landroid/os/Handler;
    //   52: ifnull +15 -> 67
    //   55: aload_0
    //   56: getfield 10	com/unionpay/mobile/android/utils/m:a	Lcom/unionpay/mobile/android/utils/k;
    //   59: invokestatic 52	com/unionpay/mobile/android/utils/k:b	(Lcom/unionpay/mobile/android/utils/k;)Landroid/os/Handler;
    //   62: iconst_2
    //   63: invokevirtual 58	android/os/Handler:sendEmptyMessage	(I)Z
    //   66: pop
    //   67: aload_1
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 61	java/lang/InterruptedException:printStackTrace	()V
    //   80: ldc 41
    //   82: new 63	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   89: aload_1
    //   90: invokevirtual 68	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 49	com/unionpay/mobile/android/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   102: pop
    //   103: goto -88 -> 15
    //   106: astore_2
    //   107: aload_1
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	m
    //   70	4	1	localObject1	Object
    //   75	33	1	localInterruptedException	InterruptedException
    //   106	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	70	finally
    //   4	6	75	java/lang/InterruptedException
    //   71	75	75	java/lang/InterruptedException
    //   22	37	106	finally
    //   37	67	106	finally
    //   67	69	106	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */