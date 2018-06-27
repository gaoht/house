package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.b.f;
import com.megvii.zhimasdk.b.a.e.e;
import com.megvii.zhimasdk.b.a.e.q;
import com.megvii.zhimasdk.b.a.o.a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
public class d
  implements com.megvii.zhimasdk.b.a.e.b
{
  private static final AtomicLong b = new AtomicLong();
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  private final com.megvii.zhimasdk.b.a.e.c.i c;
  private final com.megvii.zhimasdk.b.a.e.d d;
  private k e;
  private o f;
  private volatile boolean g;
  
  public d()
  {
    this(p.a());
  }
  
  public d(com.megvii.zhimasdk.b.a.e.c.i parami)
  {
    a.a(parami, "Scheme registry");
    this.c = parami;
    this.d = a(parami);
  }
  
  private void a(com.megvii.zhimasdk.b.a.i parami)
  {
    try
    {
      parami.e();
      return;
    }
    catch (IOException parami)
    {
      while (!this.a.a()) {}
      this.a.a("I/O exception shutting down connection", parami);
    }
  }
  
  private void c()
  {
    if (!this.g) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Connection manager has been shut down");
      return;
    }
  }
  
  public com.megvii.zhimasdk.b.a.e.c.i a()
  {
    return this.c;
  }
  
  protected com.megvii.zhimasdk.b.a.e.d a(com.megvii.zhimasdk.b.a.e.c.i parami)
  {
    return new g(parami);
  }
  
  public final e a(com.megvii.zhimasdk.b.a.e.b.b paramb, Object paramObject)
  {
    return new d.1(this, paramb, paramObject);
  }
  
  /* Error */
  public void a(com.megvii.zhimasdk.b.a.e.o paramo, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 101
    //   4: ldc 103
    //   6: invokestatic 104	com/megvii/zhimasdk/b/a/o/a:a	(ZLjava/lang/String;)V
    //   9: aload_1
    //   10: checkcast 101	com/megvii/zhimasdk/b/a/i/c/o
    //   13: astore 6
    //   15: aload 6
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 51	com/megvii/zhimasdk/b/a/i/c/d:a	Lcom/megvii/zhimasdk/b/a/h/b;
    //   22: invokevirtual 75	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   25: ifeq +29 -> 54
    //   28: aload_0
    //   29: getfield 51	com/megvii/zhimasdk/b/a/i/c/d:a	Lcom/megvii/zhimasdk/b/a/h/b;
    //   32: new 106	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   39: ldc 109
    //   41: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 122	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   54: aload 6
    //   56: invokevirtual 126	com/megvii/zhimasdk/b/a/i/c/o:n	()Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   59: ifnonnull +7 -> 66
    //   62: aload 6
    //   64: monitorexit
    //   65: return
    //   66: aload 6
    //   68: invokevirtual 130	com/megvii/zhimasdk/b/a/i/c/o:p	()Lcom/megvii/zhimasdk/b/a/e/b;
    //   71: aload_0
    //   72: if_acmpne +40 -> 112
    //   75: iconst_1
    //   76: istore 5
    //   78: iload 5
    //   80: ldc -124
    //   82: invokestatic 89	com/megvii/zhimasdk/b/a/o/b:a	(ZLjava/lang/String;)V
    //   85: aload_0
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 82	com/megvii/zhimasdk/b/a/i/c/d:g	Z
    //   91: ifeq +27 -> 118
    //   94: aload_0
    //   95: aload 6
    //   97: invokespecial 134	com/megvii/zhimasdk/b/a/i/c/d:a	(Lcom/megvii/zhimasdk/b/a/i;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: aload 6
    //   104: monitorexit
    //   105: return
    //   106: astore_1
    //   107: aload 6
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    //   112: iconst_0
    //   113: istore 5
    //   115: goto -37 -> 78
    //   118: aload 6
    //   120: invokevirtual 136	com/megvii/zhimasdk/b/a/i/c/o:c	()Z
    //   123: ifeq +17 -> 140
    //   126: aload 6
    //   128: invokevirtual 139	com/megvii/zhimasdk/b/a/i/c/o:q	()Z
    //   131: ifne +9 -> 140
    //   134: aload_0
    //   135: aload 6
    //   137: invokespecial 134	com/megvii/zhimasdk/b/a/i/c/d:a	(Lcom/megvii/zhimasdk/b/a/i;)V
    //   140: aload 6
    //   142: invokevirtual 139	com/megvii/zhimasdk/b/a/i/c/o:q	()Z
    //   145: ifeq +96 -> 241
    //   148: aload_0
    //   149: getfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   152: astore 7
    //   154: aload 4
    //   156: ifnull +117 -> 273
    //   159: aload 4
    //   161: astore_1
    //   162: aload 7
    //   164: lload_2
    //   165: aload_1
    //   166: invokevirtual 146	com/megvii/zhimasdk/b/a/i/c/k:a	(JLjava/util/concurrent/TimeUnit;)V
    //   169: aload_0
    //   170: getfield 51	com/megvii/zhimasdk/b/a/i/c/d:a	Lcom/megvii/zhimasdk/b/a/h/b;
    //   173: invokevirtual 75	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   176: ifeq +65 -> 241
    //   179: lload_2
    //   180: lconst_0
    //   181: lcmp
    //   182: ifle +98 -> 280
    //   185: new 106	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   192: ldc -108
    //   194: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: lload_2
    //   198: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   201: ldc -103
    //   203: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 4
    //   208: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore_1
    //   215: aload_0
    //   216: getfield 51	com/megvii/zhimasdk/b/a/i/c/d:a	Lcom/megvii/zhimasdk/b/a/h/b;
    //   219: new 106	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   226: ldc -101
    //   228: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokevirtual 122	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   241: aload 6
    //   243: invokevirtual 158	com/megvii/zhimasdk/b/a/i/c/o:o	()Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   246: pop
    //   247: aload_0
    //   248: aconst_null
    //   249: putfield 160	com/megvii/zhimasdk/b/a/i/c/d:f	Lcom/megvii/zhimasdk/b/a/i/c/o;
    //   252: aload_0
    //   253: getfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   256: invokevirtual 162	com/megvii/zhimasdk/b/a/i/c/k:d	()Z
    //   259: ifeq +8 -> 267
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   267: aload_0
    //   268: monitorexit
    //   269: aload 6
    //   271: monitorexit
    //   272: return
    //   273: getstatic 168	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   276: astore_1
    //   277: goto -115 -> 162
    //   280: ldc -86
    //   282: astore_1
    //   283: goto -68 -> 215
    //   286: astore_1
    //   287: aload 6
    //   289: invokevirtual 158	com/megvii/zhimasdk/b/a/i/c/o:o	()Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   292: pop
    //   293: aload_0
    //   294: aconst_null
    //   295: putfield 160	com/megvii/zhimasdk/b/a/i/c/d:f	Lcom/megvii/zhimasdk/b/a/i/c/o;
    //   298: aload_0
    //   299: getfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   302: invokevirtual 162	com/megvii/zhimasdk/b/a/i/c/k:d	()Z
    //   305: ifeq +8 -> 313
    //   308: aload_0
    //   309: aconst_null
    //   310: putfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   313: aload_1
    //   314: athrow
    //   315: astore_1
    //   316: aload_0
    //   317: monitorexit
    //   318: aload_1
    //   319: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	d
    //   0	320	1	paramo	com.megvii.zhimasdk.b.a.e.o
    //   0	320	2	paramLong	long
    //   0	320	4	paramTimeUnit	TimeUnit
    //   76	38	5	bool	boolean
    //   13	275	6	localo	o
    //   152	11	7	localk	k
    // Exception table:
    //   from	to	target	type
    //   18	54	106	finally
    //   54	65	106	finally
    //   66	75	106	finally
    //   78	87	106	finally
    //   102	105	106	finally
    //   107	110	106	finally
    //   269	272	106	finally
    //   318	320	106	finally
    //   118	140	286	finally
    //   140	154	286	finally
    //   162	179	286	finally
    //   185	215	286	finally
    //   215	241	286	finally
    //   273	277	286	finally
    //   87	102	315	finally
    //   241	267	315	finally
    //   267	269	315	finally
    //   287	313	315	finally
    //   313	315	315	finally
    //   316	318	315	finally
  }
  
  com.megvii.zhimasdk.b.a.e.o b(com.megvii.zhimasdk.b.a.e.b.b paramb, Object paramObject)
  {
    a.a(paramb, "Route");
    for (;;)
    {
      try
      {
        c();
        if (this.a.a()) {
          this.a.a("Get connection for route " + paramb);
        }
        if (this.f == null)
        {
          bool = true;
          com.megvii.zhimasdk.b.a.o.b.a(bool, "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
          if ((this.e != null) && (!this.e.b().equals(paramb)))
          {
            this.e.e();
            this.e = null;
          }
          if (this.e == null)
          {
            paramObject = Long.toString(b.getAndIncrement());
            q localq = this.d.a();
            this.e = new k(this.a, (String)paramObject, paramb, localq, 0L, TimeUnit.MILLISECONDS);
          }
          long l = System.currentTimeMillis();
          if (this.e.a(l))
          {
            this.e.e();
            this.e.a().h();
          }
          this.f = new o(this, this.d, this.e);
          paramb = this.f;
          return paramb;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 82	com/megvii/zhimasdk/b/a/i/c/d:g	Z
    //   7: aload_0
    //   8: getfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   18: invokevirtual 189	com/megvii/zhimasdk/b/a/i/c/k:e	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 160	com/megvii/zhimasdk/b/a/i/c/d:f	Lcom/megvii/zhimasdk/b/a/i/c/o;
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 141	com/megvii/zhimasdk/b/a/i/c/d:e	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 160	com/megvii/zhimasdk/b/a/i/c/d:f	Lcom/megvii/zhimasdk/b/a/i/c/o;
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	d
    //   34	12	1	localObject1	Object
    //   47	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	34	finally
    //   2	7	47	finally
    //   21	33	47	finally
    //   35	47	47	finally
    //   48	50	47	finally
  }
  
  protected void finalize()
  {
    try
    {
      b();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */