package com.megvii.zhimasdk.b.a.m;

import java.util.concurrent.TimeUnit;

public abstract class a<T, C>
{
  private final String a;
  private final T b;
  private final C c;
  private final long d;
  private final long e;
  private long f;
  private long g;
  private volatile Object h;
  
  public a(String paramString, T paramT, C paramC, long paramLong, TimeUnit paramTimeUnit)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramT, "Route");
    com.megvii.zhimasdk.b.a.o.a.a(paramC, "Connection");
    com.megvii.zhimasdk.b.a.o.a.a(paramTimeUnit, "Time unit");
    this.a = paramString;
    this.b = paramT;
    this.c = paramC;
    this.d = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (this.e = (this.d + paramTimeUnit.toMillis(paramLong));; this.e = Long.MAX_VALUE)
    {
      this.g = this.e;
      return;
    }
  }
  
  /* Error */
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: ldc 34
    //   5: invokestatic 30	com/megvii/zhimasdk/b/a/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_0
    //   10: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   13: putfield 66	com/megvii/zhimasdk/b/a/m/a:f	J
    //   16: lload_1
    //   17: lconst_0
    //   18: lcmp
    //   19: ifle +29 -> 48
    //   22: aload_0
    //   23: getfield 66	com/megvii/zhimasdk/b/a/m/a:f	J
    //   26: aload_3
    //   27: lload_1
    //   28: invokevirtual 54	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   31: ladd
    //   32: lstore_1
    //   33: aload_0
    //   34: lload_1
    //   35: aload_0
    //   36: getfield 56	com/megvii/zhimasdk/b/a/m/a:e	J
    //   39: invokestatic 72	java/lang/Math:min	(JJ)J
    //   42: putfield 58	com/megvii/zhimasdk/b/a/m/a:g	J
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: ldc2_w 59
    //   51: lstore_1
    //   52: goto -19 -> 33
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	a
    //   0	60	1	paramLong	long
    //   0	60	3	paramTimeUnit	TimeUnit
    // Exception table:
    //   from	to	target	type
    //   2	16	55	finally
    //   22	33	55	finally
    //   33	45	55	finally
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/megvii/zhimasdk/b/a/m/a:g	J
    //   6: lstore_3
    //   7: lload_1
    //   8: lload_3
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
    //   6	3	3	l	long
    //   14	9	5	bool	boolean
    //   27	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
  }
  
  public T f()
  {
    return (T)this.b;
  }
  
  public C g()
  {
    return (C)this.c;
  }
  
  public long h()
  {
    try
    {
      long l = this.g;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][route:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][web_state:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */