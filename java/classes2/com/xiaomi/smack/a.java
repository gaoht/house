package com.xiaomi.smack;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak.b;
import com.xiaomi.push.service.am;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
{
  public static boolean a = false;
  private static final AtomicInteger o = new AtomicInteger(0);
  protected int b = 0;
  protected long c = -1L;
  protected volatile long d = 0L;
  protected volatile long e = 0L;
  protected int f;
  protected final Map<f, a> g = new ConcurrentHashMap();
  protected final Map<f, a> h = new ConcurrentHashMap();
  protected com.xiaomi.smack.debugger.a i = null;
  protected String j = "";
  protected String k = "";
  protected final int l = o.getAndIncrement();
  protected b m;
  protected XMPushService n;
  private LinkedList<Pair<Integer, Long>> p = new LinkedList();
  private final Collection<d> q = new CopyOnWriteArrayList();
  private int r = 2;
  private long s = 0L;
  
  static
  {
    try
    {
      a = Boolean.getBoolean("smack.debugEnabled");
      g.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected a(XMPushService paramXMPushService, b paramb)
  {
    this.m = paramb;
    this.n = paramXMPushService;
    i();
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return "connected";
    }
    if (paramInt == 0) {
      return "connecting";
    }
    if (paramInt == 2) {
      return "disconnected";
    }
    return "unknown";
  }
  
  private void b(int paramInt)
  {
    localLinkedList = this.p;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.p.clear();
        return;
      }
      finally {}
      this.p.add(new Pair(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis())));
      if (this.p.size() > 6) {
        this.p.remove(0);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Exception paramException)
  {
    if (paramInt1 != this.r) {
      com.xiaomi.channel.commonutils.logger.b.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[] { a(this.r), a(paramInt1), am.a(paramInt2) }));
    }
    if (com.xiaomi.channel.commonutils.network.d.d(this.n)) {
      b(paramInt1);
    }
    if (paramInt1 == 1)
    {
      this.n.a(10);
      if (this.r != 0) {
        com.xiaomi.channel.commonutils.logger.b.a("try set connected while not connecting.");
      }
      this.r = paramInt1;
      paramException = this.q.iterator();
      while (paramException.hasNext()) {
        ((d)paramException.next()).a(this);
      }
    }
    if (paramInt1 == 0)
    {
      if (this.r != 2) {
        com.xiaomi.channel.commonutils.logger.b.a("try set connecting while not disconnected.");
      }
      this.r = paramInt1;
      paramException = this.q.iterator();
      while (paramException.hasNext()) {
        ((d)paramException.next()).b(this);
      }
    }
    if (paramInt1 == 2)
    {
      this.n.a(10);
      Object localObject;
      if (this.r == 0)
      {
        Iterator localIterator = this.q.iterator();
        if (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          if (paramException == null) {}
          for (localObject = new CancellationException("disconnect while connecting");; localObject = paramException)
          {
            locald.a(this, (Exception)localObject);
            break;
          }
        }
      }
      else if (this.r == 1)
      {
        localObject = this.q.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((d)((Iterator)localObject).next()).a(this, paramInt2, paramException);
        }
      }
      this.r = paramInt1;
    }
  }
  
  public abstract void a(ak.b paramb);
  
  public void a(d paramd)
  {
    if (paramd == null) {}
    while (this.q.contains(paramd)) {
      return;
    }
    this.q.add(paramd);
  }
  
  public void a(f paramf, com.xiaomi.smack.filter.a parama)
  {
    if (paramf == null) {
      throw new NullPointerException("Packet listener is null.");
    }
    parama = new a(paramf, parama);
    this.g.put(paramf, parama);
  }
  
  public abstract void a(com.xiaomi.smack.packet.d paramd);
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	com/xiaomi/smack/a:r	I
    //   6: ifne +50 -> 56
    //   9: new 258	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 261
    //   19: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokestatic 270	com/xiaomi/channel/commonutils/string/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   26: iconst_0
    //   27: bipush 8
    //   29: invokevirtual 274	java/lang/String:substring	(II)Ljava/lang/String;
    //   32: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 185	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: aload_1
    //   43: putfield 103	com/xiaomi/smack/a:j	Ljava/lang/String;
    //   46: aload_0
    //   47: iconst_1
    //   48: iconst_0
    //   49: aconst_null
    //   50: invokevirtual 279	com/xiaomi/smack/a:a	(IILjava/lang/Exception;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: ldc_w 281
    //   59: invokestatic 185	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   62: goto -9 -> 53
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	a
    //   0	70	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	53	65	finally
    //   56	62	65	finally
  }
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(com.xiaomi.slim.b[] paramArrayOfb);
  
  public abstract void a(com.xiaomi.smack.packet.d[] paramArrayOfd);
  
  public boolean a()
  {
    return false;
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 115	com/xiaomi/smack/a:s	J
    //   6: lstore_3
    //   7: lload_3
    //   8: lload_1
    //   9: lcmp
    //   10: iflt +11 -> 21
    //   13: iconst_1
    //   14: istore 5
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 5
    //   20: ireturn
    //   21: iconst_0
    //   22: istore 5
    //   24: goto -8 -> 16
    //   27: astore 6
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 6
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	a
    //   0	34	1	paramLong	long
    //   6	2	3	l1	long
    //   14	9	5	bool	boolean
    //   27	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
  }
  
  public abstract void b(int paramInt, Exception paramException);
  
  public abstract void b(com.xiaomi.slim.b paramb);
  
  public void b(d paramd)
  {
    this.q.remove(paramd);
  }
  
  public void b(f paramf, com.xiaomi.smack.filter.a parama)
  {
    if (paramf == null) {
      throw new NullPointerException("Packet listener is null.");
    }
    parama = new a(paramf, parama);
    this.h.put(paramf, parama);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public b c()
  {
    return this.m;
  }
  
  public String d()
  {
    return this.m.e();
  }
  
  public String e()
  {
    return this.m.c();
  }
  
  public int f()
  {
    return this.f;
  }
  
  public long g()
  {
    return this.e;
  }
  
  public void h()
  {
    b(0, null);
  }
  
  protected void i()
  {
    Object localObject3 = null;
    if ((this.m.f()) && (this.i == null)) {}
    try
    {
      str = System.getProperty("smack.debuggerClass");
      localObject2 = localObject3;
      if (str == null) {}
    }
    catch (Throwable localThrowable)
    {
      try
      {
        String str;
        localObject2 = Class.forName(str);
        if (localObject2 == null)
        {
          this.i = new com.xiaomi.measite.smack.a(this);
          return;
          localThrowable = localThrowable;
          Object localObject1 = null;
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        for (;;)
        {
          localException1.printStackTrace();
          localObject2 = localObject3;
        }
        try
        {
          this.i = ((com.xiaomi.smack.debugger.a)((Class)localObject2).getConstructor(new Class[] { a.class, Writer.class, Reader.class }).newInstance(new Object[] { this }));
          return;
        }
        catch (Exception localException2)
        {
          throw new IllegalArgumentException("Can't initialize the configured debugger!", localException2);
        }
      }
    }
  }
  
  public boolean j()
  {
    return this.r == 0;
  }
  
  public boolean k()
  {
    return this.r == 1;
  }
  
  public int l()
  {
    return this.b;
  }
  
  public int m()
  {
    return this.r;
  }
  
  public void n()
  {
    try
    {
      this.s = System.currentTimeMillis();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 147	java/lang/System:currentTimeMillis	()J
    //   5: lstore_2
    //   6: aload_0
    //   7: getfield 115	com/xiaomi/smack/a:s	J
    //   10: lstore 4
    //   12: invokestatic 348	com/xiaomi/smack/g:b	()I
    //   15: istore_1
    //   16: lload_2
    //   17: lload 4
    //   19: lsub
    //   20: iload_1
    //   21: i2l
    //   22: lcmp
    //   23: ifge +11 -> 34
    //   26: iconst_1
    //   27: istore 6
    //   29: aload_0
    //   30: monitorexit
    //   31: iload 6
    //   33: ireturn
    //   34: iconst_0
    //   35: istore 6
    //   37: goto -8 -> 29
    //   40: astore 7
    //   42: aload_0
    //   43: monitorexit
    //   44: aload 7
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	a
    //   15	6	1	i1	int
    //   5	12	2	l1	long
    //   10	8	4	l2	long
    //   27	9	6	bool	boolean
    //   40	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	40	finally
  }
  
  public void p()
  {
    synchronized (this.p)
    {
      this.p.clear();
      return;
    }
  }
  
  protected static class a
  {
    private f a;
    private com.xiaomi.smack.filter.a b;
    
    public a(f paramf, com.xiaomi.smack.filter.a parama)
    {
      this.a = paramf;
      this.b = parama;
    }
    
    public void a(com.xiaomi.slim.b paramb)
    {
      this.a.a(paramb);
    }
    
    public void a(com.xiaomi.smack.packet.d paramd)
    {
      if ((this.b == null) || (this.b.a(paramd))) {
        this.a.b(paramd);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */