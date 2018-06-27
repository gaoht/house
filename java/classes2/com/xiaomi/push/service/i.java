package com.xiaomi.push.service;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.concurrent.RejectedExecutionException;

public class i
{
  private static long a;
  private static long b = a;
  private static long c;
  private final c d;
  private final a e;
  
  static
  {
    long l = 0L;
    if (SystemClock.elapsedRealtime() > 0L) {
      l = SystemClock.elapsedRealtime();
    }
    a = l;
  }
  
  public i()
  {
    this(false);
  }
  
  public i(String paramString)
  {
    this(paramString, false);
  }
  
  public i(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    this.d = new c(paramString, paramBoolean);
    this.e = new a(this.d);
  }
  
  public i(boolean paramBoolean)
  {
    this("Timer-" + e(), paramBoolean);
  }
  
  static long a()
  {
    try
    {
      long l = SystemClock.elapsedRealtime();
      if (l > b) {
        a += l - b;
      }
      b = l;
      l = a;
      return l;
    }
    finally {}
  }
  
  private void b(b paramb, long paramLong)
  {
    synchronized (this.d)
    {
      if (c.b(this.d)) {
        throw new IllegalStateException("Timer was canceled");
      }
    }
    paramLong = a() + paramLong;
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + paramLong);
    }
    d locald = new d();
    locald.e = paramb.a;
    locald.d = paramb;
    locald.c = paramLong;
    c.a(this.d, locald);
  }
  
  private static long e()
  {
    try
    {
      long l = c;
      c = 1L + l;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt, b paramb)
  {
    synchronized (this.d)
    {
      c.a(this.d).a(paramInt, paramb);
      return;
    }
  }
  
  public void a(b paramb)
  {
    if ((b.a() < 1) && (Thread.currentThread() != this.d))
    {
      b.d("run job outside job job thread");
      throw new RejectedExecutionException("Run job outside job thread");
    }
    paramb.run();
  }
  
  public void a(b paramb, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("delay < 0: " + paramLong);
    }
    b(paramb, paramLong);
  }
  
  public boolean a(int paramInt)
  {
    synchronized (this.d)
    {
      boolean bool = c.a(this.d).a(paramInt);
      return bool;
    }
  }
  
  public void b()
  {
    this.d.a();
  }
  
  public void b(int paramInt)
  {
    synchronized (this.d)
    {
      c.a(this.d).b(paramInt);
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.d)
    {
      c.a(this.d).c();
      return;
    }
  }
  
  public boolean d()
  {
    return this.d.b();
  }
  
  private static final class a
  {
    private final i.c a;
    
    a(i.c paramc)
    {
      this.a = paramc;
    }
    
    /* Error */
    protected void finalize()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/xiaomi/push/service/i$a:a	Lcom/xiaomi/push/service/i$c;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 15	com/xiaomi/push/service/i$a:a	Lcom/xiaomi/push/service/i$c;
      //   11: iconst_1
      //   12: invokestatic 22	com/xiaomi/push/service/i$c:a	(Lcom/xiaomi/push/service/i$c;Z)Z
      //   15: pop
      //   16: aload_0
      //   17: getfield 15	com/xiaomi/push/service/i$a:a	Lcom/xiaomi/push/service/i$c;
      //   20: invokevirtual 25	java/lang/Object:notify	()V
      //   23: aload_1
      //   24: monitorexit
      //   25: aload_0
      //   26: invokespecial 27	java/lang/Object:finalize	()V
      //   29: return
      //   30: astore_2
      //   31: aload_1
      //   32: monitorexit
      //   33: aload_2
      //   34: athrow
      //   35: astore_1
      //   36: aload_0
      //   37: invokespecial 27	java/lang/Object:finalize	()V
      //   40: aload_1
      //   41: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	42	0	this	a
      //   35	6	1	localObject1	Object
      //   30	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   7	25	30	finally
      //   31	33	30	finally
      //   0	7	35	finally
      //   33	35	35	finally
    }
  }
  
  public static abstract class b
    implements Runnable
  {
    protected int a;
    
    public b(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  private static final class c
    extends Thread
  {
    private volatile long a = 0L;
    private volatile boolean b = false;
    private long c = 50L;
    private boolean d;
    private boolean e;
    private a f = new a(null);
    
    c(String paramString, boolean paramBoolean)
    {
      setName(paramString);
      setDaemon(paramBoolean);
      start();
    }
    
    private void a(i.d paramd)
    {
      this.f.a(paramd);
      notify();
    }
    
    public void a()
    {
      try
      {
        this.d = true;
        this.f.c();
        notify();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public boolean b()
    {
      return (this.b) && (SystemClock.uptimeMillis() - this.a > 600000L);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 64	com/xiaomi/push/service/i$c:d	Z
      //   6: ifeq +6 -> 12
      //   9: aload_0
      //   10: monitorexit
      //   11: return
      //   12: aload_0
      //   13: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   16: invokevirtual 80	com/xiaomi/push/service/i$c$a:b	()Z
      //   19: ifeq +29 -> 48
      //   22: aload_0
      //   23: getfield 61	com/xiaomi/push/service/i$c:e	Z
      //   26: ifeq +13 -> 39
      //   29: aload_0
      //   30: monitorexit
      //   31: return
      //   32: astore 6
      //   34: aload_0
      //   35: monitorexit
      //   36: aload 6
      //   38: athrow
      //   39: aload_0
      //   40: invokevirtual 83	java/lang/Object:wait	()V
      //   43: aload_0
      //   44: monitorexit
      //   45: goto -45 -> 0
      //   48: invokestatic 85	com/xiaomi/push/service/i:a	()J
      //   51: lstore_2
      //   52: aload_0
      //   53: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   56: invokevirtual 88	com/xiaomi/push/service/i$c$a:a	()Lcom/xiaomi/push/service/i$d;
      //   59: astore 6
      //   61: aload 6
      //   63: getfield 93	com/xiaomi/push/service/i$d:a	Ljava/lang/Object;
      //   66: astore 7
      //   68: aload 7
      //   70: monitorenter
      //   71: aload 6
      //   73: getfield 94	com/xiaomi/push/service/i$d:b	Z
      //   76: ifeq +19 -> 95
      //   79: aload_0
      //   80: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   83: iconst_0
      //   84: invokevirtual 97	com/xiaomi/push/service/i$c$a:c	(I)V
      //   87: aload 7
      //   89: monitorexit
      //   90: aload_0
      //   91: monitorexit
      //   92: goto -92 -> 0
      //   95: aload 6
      //   97: getfield 98	com/xiaomi/push/service/i$d:c	J
      //   100: lload_2
      //   101: lsub
      //   102: lstore 4
      //   104: aload 7
      //   106: monitorexit
      //   107: lload 4
      //   109: lconst_0
      //   110: lcmp
      //   111: ifle +69 -> 180
      //   114: lload 4
      //   116: lstore_2
      //   117: lload 4
      //   119: aload_0
      //   120: getfield 30	com/xiaomi/push/service/i$c:c	J
      //   123: lcmp
      //   124: ifle +8 -> 132
      //   127: aload_0
      //   128: getfield 30	com/xiaomi/push/service/i$c:c	J
      //   131: lstore_2
      //   132: aload_0
      //   133: aload_0
      //   134: getfield 30	com/xiaomi/push/service/i$c:c	J
      //   137: ldc2_w 27
      //   140: ladd
      //   141: putfield 30	com/xiaomi/push/service/i$c:c	J
      //   144: aload_0
      //   145: getfield 30	com/xiaomi/push/service/i$c:c	J
      //   148: ldc2_w 99
      //   151: lcmp
      //   152: ifle +10 -> 162
      //   155: aload_0
      //   156: ldc2_w 99
      //   159: putfield 30	com/xiaomi/push/service/i$c:c	J
      //   162: aload_0
      //   163: lload_2
      //   164: invokevirtual 103	java/lang/Object:wait	(J)V
      //   167: aload_0
      //   168: monitorexit
      //   169: goto -169 -> 0
      //   172: astore 6
      //   174: aload 7
      //   176: monitorexit
      //   177: aload 6
      //   179: athrow
      //   180: aload_0
      //   181: ldc2_w 27
      //   184: putfield 30	com/xiaomi/push/service/i$c:c	J
      //   187: aload 6
      //   189: getfield 93	com/xiaomi/push/service/i$d:a	Ljava/lang/Object;
      //   192: astore 7
      //   194: aload 7
      //   196: monitorenter
      //   197: iconst_0
      //   198: istore_1
      //   199: aload_0
      //   200: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   203: invokevirtual 88	com/xiaomi/push/service/i$c$a:a	()Lcom/xiaomi/push/service/i$d;
      //   206: getfield 98	com/xiaomi/push/service/i$d:c	J
      //   209: aload 6
      //   211: getfield 98	com/xiaomi/push/service/i$d:c	J
      //   214: lcmp
      //   215: ifeq +13 -> 228
      //   218: aload_0
      //   219: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   222: aload 6
      //   224: invokestatic 106	com/xiaomi/push/service/i$c$a:a	(Lcom/xiaomi/push/service/i$c$a;Lcom/xiaomi/push/service/i$d;)I
      //   227: istore_1
      //   228: aload 6
      //   230: getfield 94	com/xiaomi/push/service/i$d:b	Z
      //   233: ifeq +27 -> 260
      //   236: aload_0
      //   237: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   240: aload_0
      //   241: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   244: aload 6
      //   246: invokestatic 106	com/xiaomi/push/service/i$c$a:a	(Lcom/xiaomi/push/service/i$c$a;Lcom/xiaomi/push/service/i$d;)I
      //   249: invokevirtual 97	com/xiaomi/push/service/i$c$a:c	(I)V
      //   252: aload 7
      //   254: monitorexit
      //   255: aload_0
      //   256: monitorexit
      //   257: goto -257 -> 0
      //   260: aload 6
      //   262: aload 6
      //   264: getfield 98	com/xiaomi/push/service/i$d:c	J
      //   267: invokevirtual 108	com/xiaomi/push/service/i$d:a	(J)V
      //   270: aload_0
      //   271: getfield 35	com/xiaomi/push/service/i$c:f	Lcom/xiaomi/push/service/i$c$a;
      //   274: iload_1
      //   275: invokevirtual 97	com/xiaomi/push/service/i$c$a:c	(I)V
      //   278: aload 6
      //   280: lconst_0
      //   281: putfield 98	com/xiaomi/push/service/i$d:c	J
      //   284: aload 7
      //   286: monitorexit
      //   287: aload_0
      //   288: monitorexit
      //   289: aload_0
      //   290: invokestatic 73	android/os/SystemClock:uptimeMillis	()J
      //   293: putfield 24	com/xiaomi/push/service/i$c:a	J
      //   296: aload_0
      //   297: iconst_1
      //   298: putfield 26	com/xiaomi/push/service/i$c:b	Z
      //   301: aload 6
      //   303: getfield 111	com/xiaomi/push/service/i$d:d	Lcom/xiaomi/push/service/i$b;
      //   306: invokevirtual 115	com/xiaomi/push/service/i$b:run	()V
      //   309: aload_0
      //   310: iconst_0
      //   311: putfield 26	com/xiaomi/push/service/i$c:b	Z
      //   314: goto -314 -> 0
      //   317: astore 6
      //   319: aload_0
      //   320: monitorenter
      //   321: aload_0
      //   322: iconst_1
      //   323: putfield 64	com/xiaomi/push/service/i$c:d	Z
      //   326: aload_0
      //   327: monitorexit
      //   328: aload 6
      //   330: athrow
      //   331: astore 6
      //   333: aload 7
      //   335: monitorexit
      //   336: aload 6
      //   338: athrow
      //   339: astore 6
      //   341: aload_0
      //   342: monitorexit
      //   343: aload 6
      //   345: athrow
      //   346: astore 6
      //   348: goto -305 -> 43
      //   351: astore 6
      //   353: goto -186 -> 167
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	356	0	this	c
      //   198	77	1	i	int
      //   51	113	2	l1	long
      //   102	16	4	l2	long
      //   32	5	6	localObject1	Object
      //   59	37	6	locald1	i.d
      //   172	130	6	locald2	i.d
      //   317	12	6	localObject2	Object
      //   331	6	6	localObject3	Object
      //   339	5	6	localObject4	Object
      //   346	1	6	localInterruptedException1	InterruptedException
      //   351	1	6	localInterruptedException2	InterruptedException
      //   66	268	7	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   2	11	32	finally
      //   12	31	32	finally
      //   34	36	32	finally
      //   39	43	32	finally
      //   43	45	32	finally
      //   48	71	32	finally
      //   90	92	32	finally
      //   117	132	32	finally
      //   132	162	32	finally
      //   162	167	32	finally
      //   167	169	32	finally
      //   177	180	32	finally
      //   180	197	32	finally
      //   255	257	32	finally
      //   287	289	32	finally
      //   336	339	32	finally
      //   71	90	172	finally
      //   95	107	172	finally
      //   174	177	172	finally
      //   289	314	317	finally
      //   199	228	331	finally
      //   228	255	331	finally
      //   260	287	331	finally
      //   333	336	331	finally
      //   321	328	339	finally
      //   341	343	339	finally
      //   39	43	346	java/lang/InterruptedException
      //   162	167	351	java/lang/InterruptedException
    }
    
    private static final class a
    {
      private int a = 256;
      private i.d[] b = new i.d[this.a];
      private int c = 0;
      private int d = 0;
      
      private int b(i.d paramd)
      {
        int i = 0;
        while (i < this.b.length)
        {
          if (this.b[i] == paramd) {
            return i;
          }
          i += 1;
        }
        return -1;
      }
      
      private void d(int paramInt)
      {
        int j = paramInt * 2 + 1;
        int i = paramInt;
        paramInt = j;
        if ((paramInt < this.c) && (this.c > 0))
        {
          if ((paramInt + 1 >= this.c) || (this.b[(paramInt + 1)].c >= this.b[paramInt].c)) {
            break label127;
          }
          paramInt += 1;
        }
        label127:
        for (;;)
        {
          if (this.b[i].c < this.b[paramInt].c) {
            return;
          }
          i.d locald = this.b[i];
          this.b[i] = this.b[paramInt];
          this.b[paramInt] = locald;
          j = paramInt * 2 + 1;
          i = paramInt;
          paramInt = j;
          break;
        }
      }
      
      private void e()
      {
        int j = this.c - 1;
        int k;
        for (int i = (j - 1) / 2; this.b[j].c < this.b[i].c; i = k)
        {
          i.d locald = this.b[j];
          this.b[j] = this.b[i];
          this.b[i] = locald;
          k = (i - 1) / 2;
          j = i;
        }
      }
      
      public i.d a()
      {
        return this.b[0];
      }
      
      public void a(int paramInt, i.b paramb)
      {
        paramInt = 0;
        while (paramInt < this.c)
        {
          if (this.b[paramInt].d == paramb) {
            this.b[paramInt].a();
          }
          paramInt += 1;
        }
        d();
      }
      
      public void a(i.d paramd)
      {
        if (this.b.length == this.c)
        {
          arrayOfd = new i.d[this.c * 2];
          System.arraycopy(this.b, 0, arrayOfd, 0, this.c);
          this.b = arrayOfd;
        }
        i.d[] arrayOfd = this.b;
        int i = this.c;
        this.c = (i + 1);
        arrayOfd[i] = paramd;
        e();
      }
      
      public boolean a(int paramInt)
      {
        boolean bool2 = false;
        int i = 0;
        for (;;)
        {
          boolean bool1 = bool2;
          if (i < this.c)
          {
            if (this.b[i].e == paramInt) {
              bool1 = true;
            }
          }
          else {
            return bool1;
          }
          i += 1;
        }
      }
      
      public void b(int paramInt)
      {
        int i = 0;
        while (i < this.c)
        {
          if (this.b[i].e == paramInt) {
            this.b[i].a();
          }
          i += 1;
        }
        d();
      }
      
      public boolean b()
      {
        return this.c == 0;
      }
      
      public void c()
      {
        this.b = new i.d[this.a];
        this.c = 0;
      }
      
      public void c(int paramInt)
      {
        if ((paramInt >= 0) && (paramInt < this.c))
        {
          i.d[] arrayOfd1 = this.b;
          i.d[] arrayOfd2 = this.b;
          int i = this.c - 1;
          this.c = i;
          arrayOfd1[paramInt] = arrayOfd2[i];
          this.b[this.c] = null;
          d(paramInt);
        }
      }
      
      public void d()
      {
        int j;
        for (int i = 0; i < this.c; i = j + 1)
        {
          j = i;
          if (this.b[i].b)
          {
            this.d += 1;
            c(i);
            j = i - 1;
          }
        }
      }
    }
  }
  
  static class d
  {
    final Object a = new Object();
    boolean b;
    long c;
    i.b d;
    int e;
    private long f;
    
    void a(long paramLong)
    {
      synchronized (this.a)
      {
        this.f = paramLong;
        return;
      }
    }
    
    public boolean a()
    {
      for (boolean bool = true;; bool = false) {
        synchronized (this.a)
        {
          if ((!this.b) && (this.c > 0L))
          {
            this.b = true;
            return bool;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */