package cn.jiguang.a.a.c.a.a;

import cn.jiguang.e.c;

public final class a
{
  private static Object a;
  private static Class b;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "6D\004C\003;E7R\022<G\037E\037\001Y\004T\0071";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 102;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "4_\022C\t<UXP\026%\0377R\022<G\037E\037\001Y\004T\0071";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        b = null;
        return;
        i = 85;
        break label99;
        i = 49;
        break label99;
        i = 118;
        break label99;
        i = 49;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  public static final Object a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = c.a(b(), z[0], new Object[0]);
        a = localObject1;
        if (localObject1 == null) {
          a = c();
        }
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  public static final Class b()
  {
    if (b == null) {
      b = Class.forName(z[1]);
    }
    return b;
  }
  
  /* Error */
  private static Object c()
  {
    // Byte code:
    //   0: new 60	android/os/Handler
    //   3: dup
    //   4: invokestatic 66	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   7: invokespecial 69	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   10: astore_1
    //   11: new 4	java/lang/Object
    //   14: dup
    //   15: invokespecial 71	java/lang/Object:<init>	()V
    //   18: astore_0
    //   19: aload_1
    //   20: new 73	cn/jiguang/a/a/c/a/a/b
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 76	cn/jiguang/a/a/c/a/a/b:<init>	(Ljava/lang/Object;)V
    //   28: invokevirtual 80	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: getstatic 38	cn/jiguang/a/a/c/a/a/a:a	Ljava/lang/Object;
    //   35: ifnonnull +35 -> 70
    //   38: invokestatic 66	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   41: invokestatic 83	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   44: if_acmpeq +26 -> 70
    //   47: aload_0
    //   48: monitorenter
    //   49: aload_0
    //   50: ldc2_w 84
    //   53: invokevirtual 89	java/lang/Object:wait	(J)V
    //   56: aload_0
    //   57: monitorexit
    //   58: goto +12 -> 70
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: goto -11 -> 56
    //   70: aconst_null
    //   71: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	45	0	localObject1	Object
    //   10	10	1	localHandler	android.os.Handler
    //   61	4	1	localObject2	Object
    //   66	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   49	56	61	finally
    //   56	58	61	finally
    //   62	64	61	finally
    //   49	56	66	java/lang/InterruptedException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/c/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */