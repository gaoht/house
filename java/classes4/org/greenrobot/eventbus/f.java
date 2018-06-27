package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;

final class f
  extends Handler
{
  private final i a;
  private final int b;
  private final c c;
  private boolean d;
  
  f(c paramc, Looper paramLooper, int paramInt)
  {
    super(paramLooper);
    this.c = paramc;
    this.b = paramInt;
    this.a = new i();
  }
  
  void a(n paramn, Object paramObject)
  {
    paramn = h.a(paramn, paramObject);
    try
    {
      this.a.a(paramn);
      if (!this.d)
      {
        this.d = true;
        if (!sendMessage(obtainMessage())) {
          throw new e("Could not send handler message");
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 63	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 28	org/greenrobot/eventbus/f:a	Lorg/greenrobot/eventbus/i;
    //   8: invokevirtual 66	org/greenrobot/eventbus/i:a	()Lorg/greenrobot/eventbus/h;
    //   11: astore 4
    //   13: aload 4
    //   15: astore_1
    //   16: aload 4
    //   18: ifnonnull +32 -> 50
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 28	org/greenrobot/eventbus/f:a	Lorg/greenrobot/eventbus/i;
    //   27: invokevirtual 66	org/greenrobot/eventbus/i:a	()Lorg/greenrobot/eventbus/h;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +16 -> 48
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 40	org/greenrobot/eventbus/f:d	Z
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 40	org/greenrobot/eventbus/f:d	Z
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_0
    //   51: getfield 19	org/greenrobot/eventbus/f:c	Lorg/greenrobot/eventbus/c;
    //   54: aload_1
    //   55: invokevirtual 69	org/greenrobot/eventbus/c:a	(Lorg/greenrobot/eventbus/h;)V
    //   58: invokestatic 63	android/os/SystemClock:uptimeMillis	()J
    //   61: lload_2
    //   62: lsub
    //   63: aload_0
    //   64: getfield 21	org/greenrobot/eventbus/f:b	I
    //   67: i2l
    //   68: lcmp
    //   69: iflt -65 -> 4
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 44	org/greenrobot/eventbus/f:obtainMessage	()Landroid/os/Message;
    //   77: invokevirtual 48	org/greenrobot/eventbus/f:sendMessage	(Landroid/os/Message;)Z
    //   80: ifne +26 -> 106
    //   83: new 50	org/greenrobot/eventbus/e
    //   86: dup
    //   87: ldc 52
    //   89: invokespecial 55	org/greenrobot/eventbus/e:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 40	org/greenrobot/eventbus/f:d	Z
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: aload_0
    //   107: iconst_1
    //   108: putfield 40	org/greenrobot/eventbus/f:d	Z
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	f
    //   0	112	1	paramMessage	android.os.Message
    //   3	59	2	l	long
    //   11	6	4	localh	h
    // Exception table:
    //   from	to	target	type
    //   0	4	93	finally
    //   4	13	93	finally
    //   21	23	93	finally
    //   50	93	93	finally
    //   104	106	93	finally
    //   23	31	101	finally
    //   35	42	101	finally
    //   48	50	101	finally
    //   102	104	101	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */