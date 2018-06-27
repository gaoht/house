package com.megvii.zhimasdk.c;

import java.io.PrintStream;
import java.util.ArrayList;

public class c
{
  private final ArrayList<a> a;
  private final ArrayList<Runnable> b;
  private int c;
  private int d;
  private int e;
  private int f = 5;
  private int g;
  private int h;
  
  public c()
  {
    this(0, 2, 2, 5);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.a = new ArrayList();
    this.b = new ArrayList();
  }
  
  private void a()
  {
    try
    {
      if ((this.a.size() > 0) && (this.b.size() > 0))
      {
        a locala = (a)this.a.get(0);
        this.a.remove(locala);
        Runnable localRunnable = (Runnable)this.b.get(0);
        this.b.remove(localRunnable);
        a.a(locala, localRunnable);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private boolean a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 65	com/megvii/zhimasdk/c/c$a:a	(Lcom/megvii/zhimasdk/c/c$a;)Ljava/lang/Runnable;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 39	com/megvii/zhimasdk/c/c:a	Ljava/util/ArrayList;
    //   21: invokevirtual 48	java/util/ArrayList:size	()I
    //   24: aload_0
    //   25: getfield 30	com/megvii/zhimasdk/c/c:c	I
    //   28: if_icmple +54 -> 82
    //   31: aload_0
    //   32: getfield 41	com/megvii/zhimasdk/c/c:b	Ljava/util/ArrayList;
    //   35: invokevirtual 48	java/util/ArrayList:size	()I
    //   38: ifne +17 -> 55
    //   41: aload_0
    //   42: getfield 39	com/megvii/zhimasdk/c/c:a	Ljava/util/ArrayList;
    //   45: aload_1
    //   46: invokevirtual 56	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   49: pop
    //   50: iconst_1
    //   51: istore_2
    //   52: goto -39 -> 13
    //   55: aload_0
    //   56: getfield 41	com/megvii/zhimasdk/c/c:b	Ljava/util/ArrayList;
    //   59: iconst_0
    //   60: invokevirtual 52	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   63: checkcast 58	java/lang/Runnable
    //   66: astore_3
    //   67: aload_0
    //   68: getfield 41	com/megvii/zhimasdk/c/c:b	Ljava/util/ArrayList;
    //   71: aload_3
    //   72: invokevirtual 56	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   75: pop
    //   76: aload_1
    //   77: aload_3
    //   78: invokestatic 68	com/megvii/zhimasdk/c/c$a:b	(Lcom/megvii/zhimasdk/c/c$a;Ljava/lang/Runnable;)Ljava/lang/Runnable;
    //   81: pop
    //   82: iconst_0
    //   83: istore_2
    //   84: goto -71 -> 13
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	c
    //   0	92	1	parama	a
    //   12	72	2	bool	boolean
    //   6	72	3	localRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   2	7	87	finally
    //   17	50	87	finally
    //   55	82	87	finally
  }
  
  /* Error */
  private boolean b(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/megvii/zhimasdk/c/c:a	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 56	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 39	com/megvii/zhimasdk/c/c:a	Ljava/util/ArrayList;
    //   15: invokevirtual 48	java/util/ArrayList:size	()I
    //   18: aload_0
    //   19: getfield 32	com/megvii/zhimasdk/c/c:d	I
    //   22: if_icmpge +22 -> 44
    //   25: aload_0
    //   26: getfield 39	com/megvii/zhimasdk/c/c:a	Ljava/util/ArrayList;
    //   29: aload_1
    //   30: invokevirtual 74	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_0
    //   35: invokespecial 76	com/megvii/zhimasdk/c/c:a	()V
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_2
    //   43: ireturn
    //   44: iconst_1
    //   45: istore_2
    //   46: goto -6 -> 40
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   0	54	1	parama	a
    //   39	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	38	49	finally
  }
  
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      try
      {
        throw new NullPointerException("runner");
      }
      finally {}
    }
    Object localObject2 = null;
    Object localObject1;
    if (!this.a.isEmpty())
    {
      localObject1 = (a)this.a.get(0);
      this.a.remove(localObject1);
    }
    for (;;)
    {
      if (localObject1 != null) {
        a.a((a)localObject1, paramRunnable);
      }
      return;
      if ((this.g >= this.e) && (!paramBoolean))
      {
        localObject1 = localObject2;
        if (!this.b.contains(paramRunnable))
        {
          this.b.add(paramRunnable);
          localObject1 = localObject2;
        }
      }
      else
      {
        int i = this.h;
        this.h = (i + 1);
        localObject1 = new a(i);
        ((a)localObject1).setPriority(this.f);
        ((a)localObject1).start();
        this.g += 1;
      }
    }
  }
  
  private class a
    extends Thread
  {
    private Runnable b;
    
    public a(int paramInt) {}
    
    private void a(Runnable paramRunnable)
    {
      try
      {
        this.b = paramRunnable;
        notify();
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          Runnable localRunnable = this.b;
          if (localRunnable == null) {}
          try
          {
            wait(30000L);
            if (this.b != null) {
              break label98;
            }
            if (c.a(c.this, this))
            {
              c.a(c.this);
              System.out.println("Thread died timeout:" + c.b(c.this));
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
          if (this.b == null) {
            continue;
          }
        }
        finally {}
        try
        {
          label98:
          this.b.run();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        finally
        {
          this.b = null;
          if (c.b(c.this, this))
          {
            c.a(c.this);
            System.out.println("Thread died free: " + c.b(c.this));
            return;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */