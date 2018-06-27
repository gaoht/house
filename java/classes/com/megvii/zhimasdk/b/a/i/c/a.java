package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.b;
import com.megvii.zhimasdk.b.a.e.o;
import com.megvii.zhimasdk.b.a.l;
import com.megvii.zhimasdk.b.a.s;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
public abstract class a
  implements o, com.megvii.zhimasdk.b.a.n.e
{
  private final b a;
  private volatile com.megvii.zhimasdk.b.a.e.q b;
  private volatile boolean c;
  private volatile boolean d;
  private volatile long e;
  
  protected a(b paramb, com.megvii.zhimasdk.b.a.e.q paramq)
  {
    this.a = paramb;
    this.b = paramq;
    this.c = false;
    this.d = false;
    this.e = Long.MAX_VALUE;
  }
  
  public s a()
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    l();
    return localq.a();
  }
  
  public Object a(String paramString)
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    if ((localq instanceof com.megvii.zhimasdk.b.a.n.e)) {
      return ((com.megvii.zhimasdk.b.a.n.e)localq).a(paramString);
    }
    return null;
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L)
    {
      this.e = paramTimeUnit.toMillis(paramLong);
      return;
    }
    this.e = -1L;
  }
  
  protected final void a(com.megvii.zhimasdk.b.a.e.q paramq)
  {
    if ((q()) || (paramq == null)) {
      throw new e();
    }
  }
  
  public void a(l paraml)
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    l();
    localq.a(paraml);
  }
  
  public void a(com.megvii.zhimasdk.b.a.q paramq)
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    l();
    localq.a(paramq);
  }
  
  public void a(s params)
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    l();
    localq.a(params);
  }
  
  public void a(String paramString, Object paramObject)
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    if ((localq instanceof com.megvii.zhimasdk.b.a.n.e)) {
      ((com.megvii.zhimasdk.b.a.n.e)localq).a(paramString, paramObject);
    }
  }
  
  public boolean a(int paramInt)
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    return localq.a(paramInt);
  }
  
  public void b()
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    localq.b();
  }
  
  public void b(int paramInt)
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    localq.b(paramInt);
  }
  
  public boolean c()
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    if (localq == null) {
      return false;
    }
    return localq.c();
  }
  
  public boolean d()
  {
    if (q()) {}
    com.megvii.zhimasdk.b.a.e.q localq;
    do
    {
      return true;
      localq = o();
    } while (localq == null);
    return localq.d();
  }
  
  public InetAddress f()
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    return localq.f();
  }
  
  public int g()
  {
    com.megvii.zhimasdk.b.a.e.q localq = o();
    a(localq);
    return localq.g();
  }
  
  /* Error */
  public void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/megvii/zhimasdk/b/a/i/c/a:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 31	com/megvii/zhimasdk/b/a/i/c/a:d	Z
    //   19: aload_0
    //   20: getfield 25	com/megvii/zhimasdk/b/a/i/c/a:a	Lcom/megvii/zhimasdk/b/a/e/b;
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 35	com/megvii/zhimasdk/b/a/i/c/a:e	J
    //   28: getstatic 107	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   31: invokeinterface 112 5 0
    //   36: goto -25 -> 11
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	a
    //   6	2	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   14	36	39	finally
  }
  
  /* Error */
  public void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/megvii/zhimasdk/b/a/i/c/a:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 31	com/megvii/zhimasdk/b/a/i/c/a:d	Z
    //   19: aload_0
    //   20: invokevirtual 47	com/megvii/zhimasdk/b/a/i/c/a:l	()V
    //   23: aload_0
    //   24: invokevirtual 117	com/megvii/zhimasdk/b/a/i/c/a:e	()V
    //   27: aload_0
    //   28: getfield 25	com/megvii/zhimasdk/b/a/i/c/a:a	Lcom/megvii/zhimasdk/b/a/e/b;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 35	com/megvii/zhimasdk/b/a/i/c/a:e	J
    //   36: getstatic 107	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   39: invokeinterface 112 5 0
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    //   52: astore_2
    //   53: goto -26 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	a
    //   6	2	1	bool	boolean
    //   47	4	2	localObject	Object
    //   52	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	23	47	finally
    //   23	27	47	finally
    //   27	44	47	finally
    //   23	27	52	java/io/IOException
  }
  
  public void k()
  {
    this.c = true;
  }
  
  public void l()
  {
    this.c = false;
  }
  
  public SSLSession m()
  {
    Object localObject = o();
    a((com.megvii.zhimasdk.b.a.e.q)localObject);
    if (!c()) {
      return null;
    }
    localObject = ((com.megvii.zhimasdk.b.a.e.q)localObject).i();
    if ((localObject instanceof SSLSocket)) {}
    for (localObject = ((SSLSocket)localObject).getSession();; localObject = null) {
      return (SSLSession)localObject;
    }
  }
  
  protected void n()
  {
    try
    {
      this.b = null;
      this.e = Long.MAX_VALUE;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected com.megvii.zhimasdk.b.a.e.q o()
  {
    return this.b;
  }
  
  protected b p()
  {
    return this.a;
  }
  
  protected boolean q()
  {
    return this.d;
  }
  
  public boolean r()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */