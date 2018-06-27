package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.b.f;
import com.megvii.zhimasdk.b.a.e.d;
import com.megvii.zhimasdk.b.a.l;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.s;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
class o
  implements com.megvii.zhimasdk.b.a.e.o
{
  private final com.megvii.zhimasdk.b.a.e.b a;
  private final d b;
  private volatile k c;
  private volatile boolean d;
  private volatile long e;
  
  o(com.megvii.zhimasdk.b.a.e.b paramb, d paramd, k paramk)
  {
    a.a(paramb, "Connection manager");
    a.a(paramd, "Connection operator");
    a.a(paramk, "HTTP pool entry");
    this.a = paramb;
    this.b = paramd;
    this.c = paramk;
    this.d = false;
    this.e = Long.MAX_VALUE;
  }
  
  private com.megvii.zhimasdk.b.a.e.q r()
  {
    k localk = this.c;
    if (localk == null) {
      return null;
    }
    return (com.megvii.zhimasdk.b.a.e.q)localk.g();
  }
  
  private com.megvii.zhimasdk.b.a.e.q s()
  {
    k localk = this.c;
    if (localk == null) {
      throw new e();
    }
    return (com.megvii.zhimasdk.b.a.e.q)localk.g();
  }
  
  private k t()
  {
    k localk = this.c;
    if (localk == null) {
      throw new e();
    }
    return localk;
  }
  
  public s a()
  {
    return s().a();
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
  
  public void a(com.megvii.zhimasdk.b.a.e.b.b paramb, com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    a.a(paramb, "Route");
    a.a(parame1, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new e();
      }
    }
    finally {}
    Object localObject = this.c.a();
    com.megvii.zhimasdk.b.a.o.b.a(localObject, "Route tracker");
    boolean bool;
    com.megvii.zhimasdk.b.a.e.q localq;
    n localn;
    d locald;
    if (!((f)localObject).i())
    {
      bool = true;
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Connection already open");
      localq = (com.megvii.zhimasdk.b.a.e.q)this.c.g();
      localn = paramb.d();
      locald = this.b;
      if (localn == null) {
        break label150;
      }
    }
    label150:
    for (localObject = localn;; localObject = paramb.a())
    {
      locald.a(localq, (n)localObject, paramb.b(), parame, parame1);
      try
      {
        if (this.c != null) {
          break label159;
        }
        throw new InterruptedIOException();
      }
      finally {}
      bool = false;
      break;
    }
    label159:
    paramb = this.c.a();
    if (localn == null) {
      paramb.a(localq.h());
    }
    for (;;)
    {
      return;
      paramb.a(localn, localq.h());
    }
  }
  
  public void a(l paraml)
  {
    s().a(paraml);
  }
  
  public void a(com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    a.a(parame1, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new e();
      }
    }
    finally {}
    Object localObject = this.c.a();
    com.megvii.zhimasdk.b.a.o.b.a(localObject, "Route tracker");
    com.megvii.zhimasdk.b.a.o.b.a(((f)localObject).i(), "Connection not open");
    com.megvii.zhimasdk.b.a.o.b.a(((f)localObject).e(), "Protocol layering without a tunnel not supported");
    if (!((f)localObject).f()) {}
    com.megvii.zhimasdk.b.a.e.q localq;
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Multiple protocol layering not supported");
      localObject = ((f)localObject).a();
      localq = (com.megvii.zhimasdk.b.a.e.q)this.c.g();
      this.b.a(localq, (n)localObject, parame, parame1);
      try
      {
        if (this.c != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    this.c.a().c(localq.h());
  }
  
  public void a(n paramn, boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    a.a(paramn, "Next proxy");
    a.a(parame, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new e();
      }
    }
    finally {}
    Object localObject = this.c.a();
    com.megvii.zhimasdk.b.a.o.b.a(localObject, "Route tracker");
    com.megvii.zhimasdk.b.a.o.b.a(((f)localObject).i(), "Connection not open");
    localObject = (com.megvii.zhimasdk.b.a.e.q)this.c.g();
    ((com.megvii.zhimasdk.b.a.e.q)localObject).a(null, paramn, paramBoolean, parame);
    try
    {
      if (this.c == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.c.a().b(paramn, paramBoolean);
  }
  
  public void a(com.megvii.zhimasdk.b.a.q paramq)
  {
    s().a(paramq);
  }
  
  public void a(s params)
  {
    s().a(params);
  }
  
  public void a(Object paramObject)
  {
    t().a(paramObject);
  }
  
  public void a(boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    a.a(parame, "HTTP parameters");
    try
    {
      if (this.c == null) {
        throw new e();
      }
    }
    finally {}
    Object localObject = this.c.a();
    com.megvii.zhimasdk.b.a.o.b.a(localObject, "Route tracker");
    com.megvii.zhimasdk.b.a.o.b.a(((f)localObject).i(), "Connection not open");
    if (!((f)localObject).e()) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Connection is already tunnelled");
      localObject = ((f)localObject).a();
      com.megvii.zhimasdk.b.a.e.q localq = (com.megvii.zhimasdk.b.a.e.q)this.c.g();
      localq.a(null, (n)localObject, paramBoolean, parame);
      try
      {
        if (this.c != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    this.c.a().b(paramBoolean);
  }
  
  public boolean a(int paramInt)
  {
    return s().a(paramInt);
  }
  
  public void b()
  {
    s().b();
  }
  
  public void b(int paramInt)
  {
    s().b(paramInt);
  }
  
  public boolean c()
  {
    com.megvii.zhimasdk.b.a.e.q localq = r();
    if (localq != null) {
      return localq.c();
    }
    return false;
  }
  
  public void close()
  {
    k localk = this.c;
    if (localk != null)
    {
      com.megvii.zhimasdk.b.a.e.q localq = (com.megvii.zhimasdk.b.a.e.q)localk.g();
      localk.a().h();
      localq.close();
    }
  }
  
  public boolean d()
  {
    com.megvii.zhimasdk.b.a.e.q localq = r();
    if (localq != null) {
      return localq.d();
    }
    return true;
  }
  
  public void e()
  {
    k localk = this.c;
    if (localk != null)
    {
      com.megvii.zhimasdk.b.a.e.q localq = (com.megvii.zhimasdk.b.a.e.q)localk.g();
      localk.a().h();
      localq.e();
    }
  }
  
  public InetAddress f()
  {
    return s().f();
  }
  
  public int g()
  {
    return s().g();
  }
  
  public com.megvii.zhimasdk.b.a.e.b.b h()
  {
    return t().c();
  }
  
  public void i()
  {
    try
    {
      if (this.c == null) {
        return;
      }
      this.a.a(this, this.e, TimeUnit.MILLISECONDS);
      this.c = null;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/megvii/zhimasdk/b/a/i/c/o:c	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 41	com/megvii/zhimasdk/b/a/i/c/o:d	Z
    //   17: aload_0
    //   18: getfield 39	com/megvii/zhimasdk/b/a/i/c/o:c	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   21: invokevirtual 54	com/megvii/zhimasdk/b/a/i/c/k:g	()Ljava/lang/Object;
    //   24: checkcast 56	com/megvii/zhimasdk/b/a/e/q
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 195 1 0
    //   34: aload_0
    //   35: getfield 35	com/megvii/zhimasdk/b/a/i/c/o:a	Lcom/megvii/zhimasdk/b/a/e/b;
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 45	com/megvii/zhimasdk/b/a/i/c/o:e	J
    //   43: getstatic 207	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokeinterface 212 5 0
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 39	com/megvii/zhimasdk/b/a/i/c/o:c	Lcom/megvii/zhimasdk/b/a/i/c/k;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -31 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	o
    //   27	2	1	localq	com.megvii.zhimasdk.b.a.e.q
    //   59	4	1	localObject	Object
    //   64	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   12	28	59	finally
    //   28	34	59	finally
    //   34	58	59	finally
    //   60	62	59	finally
    //   28	34	64	java/io/IOException
  }
  
  public void k()
  {
    this.d = true;
  }
  
  public void l()
  {
    this.d = false;
  }
  
  public SSLSession m()
  {
    Socket localSocket = s().i();
    if ((localSocket instanceof SSLSocket)) {
      return ((SSLSocket)localSocket).getSession();
    }
    return null;
  }
  
  k n()
  {
    return this.c;
  }
  
  k o()
  {
    k localk = this.c;
    this.c = null;
    return localk;
  }
  
  public com.megvii.zhimasdk.b.a.e.b p()
  {
    return this.a;
  }
  
  public boolean q()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */