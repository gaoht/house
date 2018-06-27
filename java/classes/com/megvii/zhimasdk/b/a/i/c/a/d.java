package com.megvii.zhimasdk.b.a.i.c.a;

import com.megvii.zhimasdk.b.a.e.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Deprecated
public class d
  extends a
{
  public com.megvii.zhimasdk.b.a.h.b f = new com.megvii.zhimasdk.b.a.h.b(getClass());
  protected final com.megvii.zhimasdk.b.a.e.d g;
  protected final com.megvii.zhimasdk.b.a.e.a.b h;
  protected final Set<b> i;
  protected final Queue<b> j;
  protected final Queue<h> k;
  protected final Map<com.megvii.zhimasdk.b.a.e.b.b, f> l;
  protected volatile boolean m;
  protected volatile int n;
  protected volatile int o;
  private final Lock p;
  private final long q;
  private final TimeUnit r;
  
  public d(com.megvii.zhimasdk.b.a.e.d paramd, com.megvii.zhimasdk.b.a.e.a.b paramb, int paramInt)
  {
    this(paramd, paramb, paramInt, -1L, TimeUnit.MILLISECONDS);
  }
  
  public d(com.megvii.zhimasdk.b.a.e.d paramd, com.megvii.zhimasdk.b.a.e.a.b paramb, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramd, "Connection operator");
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "Connections per route");
    this.p = this.b;
    this.i = this.c;
    this.g = paramd;
    this.h = paramb;
    this.n = paramInt;
    this.j = b();
    this.k = c();
    this.l = d();
    this.q = paramLong;
    this.r = paramTimeUnit;
  }
  
  @Deprecated
  public d(com.megvii.zhimasdk.b.a.e.d paramd, com.megvii.zhimasdk.b.a.l.e parame)
  {
    this(paramd, com.megvii.zhimasdk.b.a.e.a.a.a(parame), com.megvii.zhimasdk.b.a.e.a.a.b(parame));
  }
  
  private void b(b paramb)
  {
    paramb = paramb.c();
    if (paramb != null) {}
    try
    {
      paramb.close();
      return;
    }
    catch (IOException paramb)
    {
      this.f.a("I/O error closing connection", paramb);
    }
  }
  
  /* Error */
  protected b a(com.megvii.zhimasdk.b.a.e.b.b paramb, Object paramObject, long paramLong, TimeUnit paramTimeUnit, i parami)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: lload_3
    //   4: lconst_0
    //   5: lcmp
    //   6: ifle +22 -> 28
    //   9: new 140	java/util/Date
    //   12: dup
    //   13: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   16: aload 5
    //   18: lload_3
    //   19: invokevirtual 150	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   22: ladd
    //   23: invokespecial 153	java/util/Date:<init>	(J)V
    //   26: astore 10
    //   28: aconst_null
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   35: invokeinterface 158 1 0
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_1
    //   43: invokevirtual 161	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/e/b/b;Z)Lcom/megvii/zhimasdk/b/a/i/c/a/f;
    //   46: astore 11
    //   48: aconst_null
    //   49: astore 12
    //   51: aload 5
    //   53: astore 9
    //   55: aload 5
    //   57: ifnonnull +128 -> 185
    //   60: aload_0
    //   61: getfield 163	com/megvii/zhimasdk/b/a/i/c/a/d:m	Z
    //   64: ifne +133 -> 197
    //   67: iconst_1
    //   68: istore 8
    //   70: iload 8
    //   72: ldc -91
    //   74: invokestatic 170	com/megvii/zhimasdk/b/a/o/b:a	(ZLjava/lang/String;)V
    //   77: aload_0
    //   78: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   81: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   84: ifeq +87 -> 171
    //   87: aload_0
    //   88: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   91: new 175	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   98: ldc -78
    //   100: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: ldc -69
    //   109: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 93	com/megvii/zhimasdk/b/a/i/c/a/d:j	Ljava/util/Queue;
    //   116: invokeinterface 193 1 0
    //   121: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: ldc -58
    //   126: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 82	com/megvii/zhimasdk/b/a/i/c/a/d:i	Ljava/util/Set;
    //   133: invokeinterface 201 1 0
    //   138: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: ldc -53
    //   143: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 205	com/megvii/zhimasdk/b/a/i/c/a/d:o	I
    //   150: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc -49
    //   155: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 88	com/megvii/zhimasdk/b/a/i/c/a/d:n	I
    //   162: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   171: aload_0
    //   172: aload 11
    //   174: aload_2
    //   175: invokevirtual 216	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/f;Ljava/lang/Object;)Lcom/megvii/zhimasdk/b/a/i/c/a/b;
    //   178: astore 9
    //   180: aload 9
    //   182: ifnull +21 -> 203
    //   185: aload_0
    //   186: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   189: invokeinterface 219 1 0
    //   194: aload 9
    //   196: areturn
    //   197: iconst_0
    //   198: istore 8
    //   200: goto -130 -> 70
    //   203: aload 11
    //   205: invokevirtual 223	com/megvii/zhimasdk/b/a/i/c/a/f:d	()I
    //   208: ifle +378 -> 586
    //   211: iconst_1
    //   212: istore 7
    //   214: aload_0
    //   215: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   218: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   221: ifeq +69 -> 290
    //   224: aload_0
    //   225: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   228: new 175	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   235: ldc -31
    //   237: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 11
    //   242: invokevirtual 223	com/megvii/zhimasdk/b/a/i/c/a/f:d	()I
    //   245: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc -49
    //   250: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 11
    //   255: invokevirtual 227	com/megvii/zhimasdk/b/a/i/c/a/f:b	()I
    //   258: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: ldc -27
    //   263: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: ldc -25
    //   272: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: ldc -23
    //   281: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   290: iload 7
    //   292: ifeq +29 -> 321
    //   295: aload_0
    //   296: getfield 205	com/megvii/zhimasdk/b/a/i/c/a/d:o	I
    //   299: aload_0
    //   300: getfield 88	com/megvii/zhimasdk/b/a/i/c/a/d:n	I
    //   303: if_icmpge +18 -> 321
    //   306: aload_0
    //   307: aload 11
    //   309: aload_0
    //   310: getfield 84	com/megvii/zhimasdk/b/a/i/c/a/d:g	Lcom/megvii/zhimasdk/b/a/e/d;
    //   313: invokevirtual 236	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/f;Lcom/megvii/zhimasdk/b/a/e/d;)Lcom/megvii/zhimasdk/b/a/i/c/a/b;
    //   316: astore 5
    //   318: goto -267 -> 51
    //   321: iload 7
    //   323: ifeq +42 -> 365
    //   326: aload_0
    //   327: getfield 93	com/megvii/zhimasdk/b/a/i/c/a/d:j	Ljava/util/Queue;
    //   330: invokeinterface 239 1 0
    //   335: ifne +30 -> 365
    //   338: aload_0
    //   339: invokevirtual 242	com/megvii/zhimasdk/b/a/i/c/a/d:e	()V
    //   342: aload_0
    //   343: aload_1
    //   344: iconst_1
    //   345: invokevirtual 161	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/e/b/b;Z)Lcom/megvii/zhimasdk/b/a/i/c/a/f;
    //   348: astore 11
    //   350: aload_0
    //   351: aload 11
    //   353: aload_0
    //   354: getfield 84	com/megvii/zhimasdk/b/a/i/c/a/d:g	Lcom/megvii/zhimasdk/b/a/e/d;
    //   357: invokevirtual 236	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/f;Lcom/megvii/zhimasdk/b/a/e/d;)Lcom/megvii/zhimasdk/b/a/i/c/a/b;
    //   360: astore 5
    //   362: goto -311 -> 51
    //   365: aload_0
    //   366: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   369: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   372: ifeq +43 -> 415
    //   375: aload_0
    //   376: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   379: new 175	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   386: ldc -12
    //   388: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_1
    //   392: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   395: ldc -25
    //   397: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: ldc -23
    //   406: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   415: aload 12
    //   417: astore 13
    //   419: aload 12
    //   421: ifnonnull +27 -> 448
    //   424: aload_0
    //   425: aload_0
    //   426: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   429: invokeinterface 248 1 0
    //   434: aload 11
    //   436: invokevirtual 251	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Ljava/util/concurrent/locks/Condition;Lcom/megvii/zhimasdk/b/a/i/c/a/f;)Lcom/megvii/zhimasdk/b/a/i/c/a/h;
    //   439: astore 13
    //   441: aload 6
    //   443: aload 13
    //   445: invokevirtual 256	com/megvii/zhimasdk/b/a/i/c/a/i:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/h;)V
    //   448: aload 11
    //   450: aload 13
    //   452: invokevirtual 257	com/megvii/zhimasdk/b/a/i/c/a/f:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/h;)V
    //   455: aload_0
    //   456: getfield 97	com/megvii/zhimasdk/b/a/i/c/a/d:k	Ljava/util/Queue;
    //   459: aload 13
    //   461: invokeinterface 261 2 0
    //   466: pop
    //   467: aload 13
    //   469: aload 10
    //   471: invokevirtual 266	com/megvii/zhimasdk/b/a/i/c/a/h:a	(Ljava/util/Date;)Z
    //   474: istore 8
    //   476: aload 11
    //   478: aload 13
    //   480: invokevirtual 268	com/megvii/zhimasdk/b/a/i/c/a/f:b	(Lcom/megvii/zhimasdk/b/a/i/c/a/h;)V
    //   483: aload_0
    //   484: getfield 97	com/megvii/zhimasdk/b/a/i/c/a/d:k	Ljava/util/Queue;
    //   487: aload 13
    //   489: invokeinterface 271 2 0
    //   494: pop
    //   495: aload 13
    //   497: astore 12
    //   499: aload 9
    //   501: astore 5
    //   503: iload 8
    //   505: ifne -454 -> 51
    //   508: aload 13
    //   510: astore 12
    //   512: aload 9
    //   514: astore 5
    //   516: aload 10
    //   518: ifnull -467 -> 51
    //   521: aload 13
    //   523: astore 12
    //   525: aload 9
    //   527: astore 5
    //   529: aload 10
    //   531: invokevirtual 274	java/util/Date:getTime	()J
    //   534: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   537: lcmp
    //   538: ifgt -487 -> 51
    //   541: new 276	com/megvii/zhimasdk/b/a/e/h
    //   544: dup
    //   545: ldc_w 278
    //   548: invokespecial 281	com/megvii/zhimasdk/b/a/e/h:<init>	(Ljava/lang/String;)V
    //   551: athrow
    //   552: astore_1
    //   553: aload_0
    //   554: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   557: invokeinterface 219 1 0
    //   562: aload_1
    //   563: athrow
    //   564: astore_1
    //   565: aload 11
    //   567: aload 13
    //   569: invokevirtual 268	com/megvii/zhimasdk/b/a/i/c/a/f:b	(Lcom/megvii/zhimasdk/b/a/i/c/a/h;)V
    //   572: aload_0
    //   573: getfield 97	com/megvii/zhimasdk/b/a/i/c/a/d:k	Ljava/util/Queue;
    //   576: aload 13
    //   578: invokeinterface 271 2 0
    //   583: pop
    //   584: aload_1
    //   585: athrow
    //   586: iconst_0
    //   587: istore 7
    //   589: goto -375 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	d
    //   0	592	1	paramb	com.megvii.zhimasdk.b.a.e.b.b
    //   0	592	2	paramObject	Object
    //   0	592	3	paramLong	long
    //   0	592	5	paramTimeUnit	TimeUnit
    //   0	592	6	parami	i
    //   212	376	7	i1	int
    //   68	436	8	bool	boolean
    //   53	473	9	localObject1	Object
    //   1	529	10	localDate	java.util.Date
    //   46	520	11	localf	f
    //   49	475	12	localObject2	Object
    //   417	160	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	552	finally
    //   60	67	552	finally
    //   70	171	552	finally
    //   171	180	552	finally
    //   203	211	552	finally
    //   214	290	552	finally
    //   295	318	552	finally
    //   326	362	552	finally
    //   365	415	552	finally
    //   424	448	552	finally
    //   476	495	552	finally
    //   529	552	552	finally
    //   565	586	552	finally
    //   448	476	564	finally
  }
  
  protected b a(f paramf, com.megvii.zhimasdk.b.a.e.d paramd)
  {
    if (this.f.a()) {
      this.f.a("Creating new connection [" + paramf.a() + "]");
    }
    paramd = new b(paramd, paramf.a(), this.q, this.r);
    this.p.lock();
    try
    {
      paramf.b(paramd);
      this.o += 1;
      this.i.add(paramd);
      return paramd;
    }
    finally
    {
      this.p.unlock();
    }
  }
  
  protected b a(f paramf, Object paramObject)
  {
    b localb = null;
    this.p.lock();
    int i1 = 0;
    for (;;)
    {
      if (i1 == 0)
      {
        try
        {
          localb = paramf.a(paramObject);
          if (localb == null) {
            break label213;
          }
          if (this.f.a()) {
            this.f.a("Getting free connection [" + paramf.a() + "][" + paramObject + "]");
          }
          this.j.remove(localb);
          if (localb.a(System.currentTimeMillis()))
          {
            if (this.f.a()) {
              this.f.a("Closing expired free connection [" + paramf.a() + "][" + paramObject + "]");
            }
            b(localb);
            paramf.e();
            this.o -= 1;
            continue;
          }
        }
        finally
        {
          this.p.unlock();
        }
        this.i.add(localb);
        i1 = 1;
        continue;
        label213:
        if (this.f.a())
        {
          this.f.a("No free connections [" + paramf.a() + "][" + paramObject + "]");
          i1 = 1;
        }
      }
      else
      {
        this.p.unlock();
        return localb;
      }
      i1 = 1;
    }
  }
  
  public e a(com.megvii.zhimasdk.b.a.e.b.b paramb, Object paramObject)
  {
    return new d.1(this, new i(), paramb, paramObject);
  }
  
  protected f a(com.megvii.zhimasdk.b.a.e.b.b paramb)
  {
    return new f(paramb, this.h);
  }
  
  protected f a(com.megvii.zhimasdk.b.a.e.b.b paramb, boolean paramBoolean)
  {
    this.p.lock();
    try
    {
      f localf2 = (f)this.l.get(paramb);
      f localf1 = localf2;
      if (localf2 == null)
      {
        localf1 = localf2;
        if (paramBoolean)
        {
          localf1 = a(paramb);
          this.l.put(paramb, localf1);
        }
      }
      return localf1;
    }
    finally
    {
      this.p.unlock();
    }
  }
  
  protected h a(Condition paramCondition, f paramf)
  {
    return new h(paramCondition, paramf);
  }
  
  public void a()
  {
    this.p.lock();
    Object localObject2;
    try
    {
      boolean bool = this.m;
      if (bool) {
        return;
      }
      this.m = true;
      Iterator localIterator1 = this.i.iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = (b)localIterator1.next();
        localIterator1.remove();
        b((b)localObject2);
      }
      localIterator2 = this.j.iterator();
    }
    finally
    {
      this.p.unlock();
    }
    while (localIterator2.hasNext())
    {
      localObject2 = (b)localIterator2.next();
      localIterator2.remove();
      if (this.f.a()) {
        this.f.a("Closing connection [" + ((b)localObject2).d() + "][" + ((b)localObject2).a() + "]");
      }
      b((b)localObject2);
    }
    Iterator localIterator2 = this.k.iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (h)localIterator2.next();
      localIterator2.remove();
      ((h)localObject2).a();
    }
    this.l.clear();
    this.p.unlock();
  }
  
  protected void a(b paramb)
  {
    com.megvii.zhimasdk.b.a.e.b.b localb = paramb.d();
    if (this.f.a()) {
      this.f.a("Deleting connection [" + localb + "][" + paramb.a() + "]");
    }
    this.p.lock();
    try
    {
      b(paramb);
      f localf = a(localb, true);
      localf.c(paramb);
      this.o -= 1;
      if (localf.c()) {
        this.l.remove(localb);
      }
      return;
    }
    finally
    {
      this.p.unlock();
    }
  }
  
  /* Error */
  public void a(b paramb, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 352	com/megvii/zhimasdk/b/a/i/c/a/b:d	()Lcom/megvii/zhimasdk/b/a/e/b/b;
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   10: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   13: ifeq +48 -> 61
    //   16: aload_0
    //   17: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   20: new 175	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 371
    //   30: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 7
    //   35: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: ldc -25
    //   40: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 354	com/megvii/zhimasdk/b/a/i/c/a/b:a	()Ljava/lang/Object;
    //   47: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: ldc -23
    //   52: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 158 1 0
    //   70: aload_0
    //   71: getfield 163	com/megvii/zhimasdk/b/a/i/c/a/d:m	Z
    //   74: ifeq +18 -> 92
    //   77: aload_0
    //   78: aload_1
    //   79: invokespecial 303	com/megvii/zhimasdk/b/a/i/c/a/d:b	(Lcom/megvii/zhimasdk/b/a/i/c/a/b;)V
    //   82: aload_0
    //   83: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   86: invokeinterface 219 1 0
    //   91: return
    //   92: aload_0
    //   93: getfield 82	com/megvii/zhimasdk/b/a/i/c/a/d:i	Ljava/util/Set;
    //   96: aload_1
    //   97: invokeinterface 372 2 0
    //   102: pop
    //   103: aload_0
    //   104: aload 7
    //   106: iconst_1
    //   107: invokevirtual 161	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/e/b/b;Z)Lcom/megvii/zhimasdk/b/a/i/c/a/f;
    //   110: astore 8
    //   112: iload_2
    //   113: ifeq +159 -> 272
    //   116: aload 8
    //   118: invokevirtual 223	com/megvii/zhimasdk/b/a/i/c/a/f:d	()I
    //   121: iflt +151 -> 272
    //   124: aload_0
    //   125: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   128: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   131: ifeq +93 -> 224
    //   134: lload_3
    //   135: lconst_0
    //   136: lcmp
    //   137: ifle +127 -> 264
    //   140: new 175	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 374
    //   150: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: lload_3
    //   154: invokevirtual 377	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   157: ldc_w 379
    //   160: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 5
    //   165: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 6
    //   173: aload_0
    //   174: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   177: new 175	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 381
    //   187: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 7
    //   192: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: ldc -25
    //   197: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 354	com/megvii/zhimasdk/b/a/i/c/a/b:a	()Ljava/lang/Object;
    //   204: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: ldc_w 383
    //   210: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 6
    //   215: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   224: aload 8
    //   226: aload_1
    //   227: invokevirtual 385	com/megvii/zhimasdk/b/a/i/c/a/f:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/b;)V
    //   230: aload_1
    //   231: lload_3
    //   232: aload 5
    //   234: invokevirtual 388	com/megvii/zhimasdk/b/a/i/c/a/b:a	(JLjava/util/concurrent/TimeUnit;)V
    //   237: aload_0
    //   238: getfield 93	com/megvii/zhimasdk/b/a/i/c/a/d:j	Ljava/util/Queue;
    //   241: aload_1
    //   242: invokeinterface 261 2 0
    //   247: pop
    //   248: aload_0
    //   249: aload 8
    //   251: invokevirtual 391	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/f;)V
    //   254: aload_0
    //   255: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   258: invokeinterface 219 1 0
    //   263: return
    //   264: ldc_w 393
    //   267: astore 6
    //   269: goto -96 -> 173
    //   272: aload_0
    //   273: aload_1
    //   274: invokespecial 303	com/megvii/zhimasdk/b/a/i/c/a/d:b	(Lcom/megvii/zhimasdk/b/a/i/c/a/b;)V
    //   277: aload 8
    //   279: invokevirtual 304	com/megvii/zhimasdk/b/a/i/c/a/f:e	()V
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 205	com/megvii/zhimasdk/b/a/i/c/a/d:o	I
    //   287: iconst_1
    //   288: isub
    //   289: putfield 205	com/megvii/zhimasdk/b/a/i/c/a/d:o	I
    //   292: goto -44 -> 248
    //   295: astore_1
    //   296: aload_0
    //   297: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   300: invokeinterface 219 1 0
    //   305: aload_1
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	d
    //   0	307	1	paramb	b
    //   0	307	2	paramBoolean	boolean
    //   0	307	3	paramLong	long
    //   0	307	5	paramTimeUnit	TimeUnit
    //   171	97	6	str	String
    //   4	187	7	localb	com.megvii.zhimasdk.b.a.e.b.b
    //   110	168	8	localf	f
    // Exception table:
    //   from	to	target	type
    //   70	82	295	finally
    //   92	112	295	finally
    //   116	134	295	finally
    //   140	173	295	finally
    //   173	224	295	finally
    //   224	248	295	finally
    //   248	254	295	finally
    //   272	292	295	finally
  }
  
  /* Error */
  protected void a(f paramf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 158 1 0
    //   11: aload_1
    //   12: ifnull +78 -> 90
    //   15: aload_1
    //   16: invokevirtual 395	com/megvii/zhimasdk/b/a/i/c/a/f:f	()Z
    //   19: ifeq +71 -> 90
    //   22: aload_0
    //   23: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   26: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   29: ifeq +38 -> 67
    //   32: aload_0
    //   33: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   36: new 175	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 397
    //   46: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 286	com/megvii/zhimasdk/b/a/i/c/a/f:a	()Lcom/megvii/zhimasdk/b/a/e/b/b;
    //   53: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: ldc -23
    //   58: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   67: aload_1
    //   68: invokevirtual 400	com/megvii/zhimasdk/b/a/i/c/a/f:g	()Lcom/megvii/zhimasdk/b/a/i/c/a/h;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 356	com/megvii/zhimasdk/b/a/i/c/a/h:a	()V
    //   80: aload_0
    //   81: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 219 1 0
    //   89: return
    //   90: aload_0
    //   91: getfield 97	com/megvii/zhimasdk/b/a/i/c/a/d:k	Ljava/util/Queue;
    //   94: invokeinterface 239 1 0
    //   99: ifne +39 -> 138
    //   102: aload_0
    //   103: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   106: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   109: ifeq +13 -> 122
    //   112: aload_0
    //   113: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   116: ldc_w 402
    //   119: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   122: aload_0
    //   123: getfield 97	com/megvii/zhimasdk/b/a/i/c/a/d:k	Ljava/util/Queue;
    //   126: invokeinterface 404 1 0
    //   131: checkcast 263	com/megvii/zhimasdk/b/a/i/c/a/h
    //   134: astore_1
    //   135: goto -63 -> 72
    //   138: aload_2
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   144: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   147: ifeq -75 -> 72
    //   150: aload_0
    //   151: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   154: ldc_w 406
    //   157: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   160: aload_2
    //   161: astore_1
    //   162: goto -90 -> 72
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   170: invokeinterface 219 1 0
    //   175: aload_1
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	d
    //   0	177	1	paramf	f
    //   1	160	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	67	165	finally
    //   67	72	165	finally
    //   76	80	165	finally
    //   90	122	165	finally
    //   122	135	165	finally
    //   140	160	165	finally
  }
  
  protected Queue<b> b()
  {
    return new LinkedList();
  }
  
  protected Queue<h> c()
  {
    return new LinkedList();
  }
  
  protected Map<com.megvii.zhimasdk.b.a.e.b.b, f> d()
  {
    return new HashMap();
  }
  
  /* Error */
  protected void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 158 1 0
    //   9: aload_0
    //   10: getfield 93	com/megvii/zhimasdk/b/a/i/c/a/d:j	Ljava/util/Queue;
    //   13: invokeinterface 404 1 0
    //   18: checkcast 124	com/megvii/zhimasdk/b/a/i/c/a/b
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +18 -> 41
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 417	com/megvii/zhimasdk/b/a/i/c/a/d:a	(Lcom/megvii/zhimasdk/b/a/i/c/a/b;)V
    //   31: aload_0
    //   32: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   35: invokeinterface 219 1 0
    //   40: return
    //   41: aload_0
    //   42: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   45: invokevirtual 173	com/megvii/zhimasdk/b/a/h/b:a	()Z
    //   48: ifeq -17 -> 31
    //   51: aload_0
    //   52: getfield 62	com/megvii/zhimasdk/b/a/i/c/a/d:f	Lcom/megvii/zhimasdk/b/a/h/b;
    //   55: ldc_w 419
    //   58: invokevirtual 213	com/megvii/zhimasdk/b/a/h/b:a	(Ljava/lang/Object;)V
    //   61: goto -30 -> 31
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 77	com/megvii/zhimasdk/b/a/i/c/a/d:p	Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 219 1 0
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	d
    //   21	7	1	localb	b
    //   64	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	22	64	finally
    //   26	31	64	finally
    //   41	61	64	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */