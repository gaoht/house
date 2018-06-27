package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.f.k;
import com.megvii.zhimasdk.b.a.i.d.af;
import com.megvii.zhimasdk.b.a.i.d.n;
import com.megvii.zhimasdk.b.a.i.d.v;
import com.megvii.zhimasdk.b.a.i.d.y;
import com.megvii.zhimasdk.b.a.u;

@Deprecated
public abstract class a
  extends h
{
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  private com.megvii.zhimasdk.b.a.l.e c;
  private com.megvii.zhimasdk.b.a.n.h d;
  private com.megvii.zhimasdk.b.a.e.b e;
  private com.megvii.zhimasdk.b.a.b f;
  private com.megvii.zhimasdk.b.a.e.g g;
  private k h;
  private com.megvii.zhimasdk.b.a.a.f i;
  private com.megvii.zhimasdk.b.a.n.b j;
  private com.megvii.zhimasdk.b.a.n.i k;
  private com.megvii.zhimasdk.b.a.b.j l;
  private com.megvii.zhimasdk.b.a.b.o m;
  private com.megvii.zhimasdk.b.a.b.c n;
  private com.megvii.zhimasdk.b.a.b.c o;
  private com.megvii.zhimasdk.b.a.b.h p;
  private com.megvii.zhimasdk.b.a.b.i q;
  private com.megvii.zhimasdk.b.a.e.b.d r;
  private com.megvii.zhimasdk.b.a.b.q s;
  private com.megvii.zhimasdk.b.a.b.g t;
  private com.megvii.zhimasdk.b.a.b.d u;
  
  protected a(com.megvii.zhimasdk.b.a.e.b paramb, com.megvii.zhimasdk.b.a.l.e parame)
  {
    this.c = parame;
    this.e = paramb;
  }
  
  private com.megvii.zhimasdk.b.a.n.g I()
  {
    int i2 = 0;
    try
    {
      if (this.k == null)
      {
        localObject1 = H();
        int i3 = ((com.megvii.zhimasdk.b.a.n.b)localObject1).a();
        com.megvii.zhimasdk.b.a.r[] arrayOfr = new com.megvii.zhimasdk.b.a.r[i3];
        int i1 = 0;
        while (i1 < i3)
        {
          arrayOfr[i1] = ((com.megvii.zhimasdk.b.a.n.b)localObject1).a(i1);
          i1 += 1;
        }
        i3 = ((com.megvii.zhimasdk.b.a.n.b)localObject1).b();
        u[] arrayOfu = new u[i3];
        i1 = i2;
        while (i1 < i3)
        {
          arrayOfu[i1] = ((com.megvii.zhimasdk.b.a.n.b)localObject1).b(i1);
          i1 += 1;
        }
        this.k = new com.megvii.zhimasdk.b.a.n.i(arrayOfr, arrayOfu);
      }
      Object localObject1 = this.k;
      return (com.megvii.zhimasdk.b.a.n.g)localObject1;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.o A()
  {
    try
    {
      if (this.m == null) {
        this.m = new m();
      }
      com.megvii.zhimasdk.b.a.b.o localo = this.m;
      return localo;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.c B()
  {
    try
    {
      if (this.n == null) {
        this.n = k();
      }
      com.megvii.zhimasdk.b.a.b.c localc = this.n;
      return localc;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.c C()
  {
    try
    {
      if (this.o == null) {
        this.o = l();
      }
      com.megvii.zhimasdk.b.a.b.c localc = this.o;
      return localc;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.h D()
  {
    try
    {
      if (this.p == null) {
        this.p = m();
      }
      com.megvii.zhimasdk.b.a.b.h localh = this.p;
      return localh;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.i E()
  {
    try
    {
      if (this.q == null) {
        this.q = n();
      }
      com.megvii.zhimasdk.b.a.b.i locali = this.q;
      return locali;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.e.b.d F()
  {
    try
    {
      if (this.r == null) {
        this.r = o();
      }
      com.megvii.zhimasdk.b.a.e.b.d locald = this.r;
      return locald;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.q G()
  {
    try
    {
      if (this.s == null) {
        this.s = p();
      }
      com.megvii.zhimasdk.b.a.b.q localq = this.s;
      return localq;
    }
    finally {}
  }
  
  protected final com.megvii.zhimasdk.b.a.n.b H()
  {
    try
    {
      if (this.j == null) {
        this.j = b();
      }
      com.megvii.zhimasdk.b.a.n.b localb = this.j;
      return localb;
    }
    finally {}
  }
  
  /* Error */
  protected final com.megvii.zhimasdk.b.a.b.c.c a(com.megvii.zhimasdk.b.a.n paramn, com.megvii.zhimasdk.b.a.q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc -103
    //   3: invokestatic 158	com/megvii/zhimasdk/b/a/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: invokevirtual 161	com/megvii/zhimasdk/b/a/i/b/a:c	()Lcom/megvii/zhimasdk/b/a/n/e;
    //   13: astore 4
    //   15: aload_3
    //   16: ifnonnull +164 -> 180
    //   19: aload 4
    //   21: astore_3
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 164	com/megvii/zhimasdk/b/a/i/b/a:a	(Lcom/megvii/zhimasdk/b/a/q;)Lcom/megvii/zhimasdk/b/a/l/e;
    //   27: astore 4
    //   29: aload_3
    //   30: ldc -90
    //   32: aload 4
    //   34: invokestatic 171	com/megvii/zhimasdk/b/a/b/d/a:a	(Lcom/megvii/zhimasdk/b/a/l/e;)Lcom/megvii/zhimasdk/b/a/b/a/a;
    //   37: invokeinterface 176 3 0
    //   42: aload_0
    //   43: aload_0
    //   44: invokevirtual 179	com/megvii/zhimasdk/b/a/i/b/a:s	()Lcom/megvii/zhimasdk/b/a/n/h;
    //   47: aload_0
    //   48: invokevirtual 182	com/megvii/zhimasdk/b/a/i/b/a:r	()Lcom/megvii/zhimasdk/b/a/e/b;
    //   51: aload_0
    //   52: invokevirtual 186	com/megvii/zhimasdk/b/a/i/b/a:x	()Lcom/megvii/zhimasdk/b/a/b;
    //   55: aload_0
    //   56: invokevirtual 190	com/megvii/zhimasdk/b/a/i/b/a:y	()Lcom/megvii/zhimasdk/b/a/e/g;
    //   59: aload_0
    //   60: invokevirtual 192	com/megvii/zhimasdk/b/a/i/b/a:F	()Lcom/megvii/zhimasdk/b/a/e/b/d;
    //   63: aload_0
    //   64: invokespecial 194	com/megvii/zhimasdk/b/a/i/b/a:I	()Lcom/megvii/zhimasdk/b/a/n/g;
    //   67: aload_0
    //   68: invokevirtual 198	com/megvii/zhimasdk/b/a/i/b/a:z	()Lcom/megvii/zhimasdk/b/a/b/j;
    //   71: aload_0
    //   72: invokevirtual 200	com/megvii/zhimasdk/b/a/i/b/a:A	()Lcom/megvii/zhimasdk/b/a/b/o;
    //   75: aload_0
    //   76: invokevirtual 202	com/megvii/zhimasdk/b/a/i/b/a:B	()Lcom/megvii/zhimasdk/b/a/b/c;
    //   79: aload_0
    //   80: invokevirtual 204	com/megvii/zhimasdk/b/a/i/b/a:C	()Lcom/megvii/zhimasdk/b/a/b/c;
    //   83: aload_0
    //   84: invokevirtual 206	com/megvii/zhimasdk/b/a/i/b/a:G	()Lcom/megvii/zhimasdk/b/a/b/q;
    //   87: aload 4
    //   89: invokevirtual 209	com/megvii/zhimasdk/b/a/i/b/a:a	(Lcom/megvii/zhimasdk/b/a/n/h;Lcom/megvii/zhimasdk/b/a/e/b;Lcom/megvii/zhimasdk/b/a/b;Lcom/megvii/zhimasdk/b/a/e/g;Lcom/megvii/zhimasdk/b/a/e/b/d;Lcom/megvii/zhimasdk/b/a/n/g;Lcom/megvii/zhimasdk/b/a/b/j;Lcom/megvii/zhimasdk/b/a/b/o;Lcom/megvii/zhimasdk/b/a/b/c;Lcom/megvii/zhimasdk/b/a/b/c;Lcom/megvii/zhimasdk/b/a/b/q;Lcom/megvii/zhimasdk/b/a/l/e;)Lcom/megvii/zhimasdk/b/a/b/p;
    //   92: astore 7
    //   94: aload_0
    //   95: invokevirtual 192	com/megvii/zhimasdk/b/a/i/b/a:F	()Lcom/megvii/zhimasdk/b/a/e/b/d;
    //   98: astore 8
    //   100: aload_0
    //   101: invokevirtual 212	com/megvii/zhimasdk/b/a/i/b/a:u	()Lcom/megvii/zhimasdk/b/a/b/g;
    //   104: astore 5
    //   106: aload_0
    //   107: invokevirtual 216	com/megvii/zhimasdk/b/a/i/b/a:w	()Lcom/megvii/zhimasdk/b/a/b/d;
    //   110: astore 6
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 5
    //   116: ifnull +201 -> 317
    //   119: aload 6
    //   121: ifnull +196 -> 317
    //   124: aload_1
    //   125: ifnull +74 -> 199
    //   128: aload_1
    //   129: astore 4
    //   131: aload 8
    //   133: aload 4
    //   135: aload_2
    //   136: aload_3
    //   137: invokeinterface 221 4 0
    //   142: astore 4
    //   144: aload 7
    //   146: aload_1
    //   147: aload_2
    //   148: aload_3
    //   149: invokeinterface 226 4 0
    //   154: invokestatic 231	com/megvii/zhimasdk/b/a/i/b/i:a	(Lcom/megvii/zhimasdk/b/a/s;)Lcom/megvii/zhimasdk/b/a/b/c/c;
    //   157: astore_1
    //   158: aload 5
    //   160: aload_1
    //   161: invokeinterface 236 2 0
    //   166: ifeq +140 -> 306
    //   169: aload 6
    //   171: aload 4
    //   173: invokeinterface 241 2 0
    //   178: aload_1
    //   179: areturn
    //   180: new 243	com/megvii/zhimasdk/b/a/n/c
    //   183: dup
    //   184: aload_3
    //   185: aload 4
    //   187: invokespecial 246	com/megvii/zhimasdk/b/a/n/c:<init>	(Lcom/megvii/zhimasdk/b/a/n/e;Lcom/megvii/zhimasdk/b/a/n/e;)V
    //   190: astore_3
    //   191: goto -169 -> 22
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: aload_0
    //   200: aload_2
    //   201: invokevirtual 164	com/megvii/zhimasdk/b/a/i/b/a:a	(Lcom/megvii/zhimasdk/b/a/q;)Lcom/megvii/zhimasdk/b/a/l/e;
    //   204: ldc -8
    //   206: invokeinterface 253 2 0
    //   211: checkcast 255	com/megvii/zhimasdk/b/a/n
    //   214: astore 4
    //   216: goto -85 -> 131
    //   219: astore_1
    //   220: aload 5
    //   222: aload_1
    //   223: invokeinterface 258 2 0
    //   228: ifeq +12 -> 240
    //   231: aload 6
    //   233: aload 4
    //   235: invokeinterface 241 2 0
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: new 260	com/megvii/zhimasdk/b/a/b/f
    //   246: dup
    //   247: aload_1
    //   248: invokespecial 263	com/megvii/zhimasdk/b/a/b/f:<init>	(Ljava/lang/Throwable;)V
    //   251: athrow
    //   252: astore_1
    //   253: aload 5
    //   255: aload_1
    //   256: invokeinterface 258 2 0
    //   261: ifeq +12 -> 273
    //   264: aload 6
    //   266: aload 4
    //   268: invokeinterface 241 2 0
    //   273: aload_1
    //   274: instanceof 147
    //   277: ifeq +8 -> 285
    //   280: aload_1
    //   281: checkcast 147	com/megvii/zhimasdk/b/a/m
    //   284: athrow
    //   285: aload_1
    //   286: instanceof 265
    //   289: ifeq +8 -> 297
    //   292: aload_1
    //   293: checkcast 265	java/io/IOException
    //   296: athrow
    //   297: new 267	java/lang/reflect/UndeclaredThrowableException
    //   300: dup
    //   301: aload_1
    //   302: invokespecial 268	java/lang/reflect/UndeclaredThrowableException:<init>	(Ljava/lang/Throwable;)V
    //   305: athrow
    //   306: aload 6
    //   308: aload 4
    //   310: invokeinterface 270 2 0
    //   315: aload_1
    //   316: areturn
    //   317: aload 7
    //   319: aload_1
    //   320: aload_2
    //   321: aload_3
    //   322: invokeinterface 226 4 0
    //   327: invokestatic 231	com/megvii/zhimasdk/b/a/i/b/i:a	(Lcom/megvii/zhimasdk/b/a/s;)Lcom/megvii/zhimasdk/b/a/b/c/c;
    //   330: astore_1
    //   331: aload_1
    //   332: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	a
    //   0	333	1	paramn	com.megvii.zhimasdk.b.a.n
    //   0	333	2	paramq	com.megvii.zhimasdk.b.a.q
    //   0	333	3	parame	com.megvii.zhimasdk.b.a.n.e
    //   13	296	4	localObject	Object
    //   104	150	5	localg	com.megvii.zhimasdk.b.a.b.g
    //   110	197	6	locald	com.megvii.zhimasdk.b.a.b.d
    //   92	226	7	localp	com.megvii.zhimasdk.b.a.b.p
    //   98	34	8	locald1	com.megvii.zhimasdk.b.a.e.b.d
    // Exception table:
    //   from	to	target	type
    //   9	15	194	finally
    //   22	114	194	finally
    //   180	191	194	finally
    //   195	197	194	finally
    //   144	158	219	java/lang/RuntimeException
    //   131	144	242	com/megvii/zhimasdk/b/a/m
    //   144	158	242	com/megvii/zhimasdk/b/a/m
    //   158	178	242	com/megvii/zhimasdk/b/a/m
    //   199	216	242	com/megvii/zhimasdk/b/a/m
    //   220	240	242	com/megvii/zhimasdk/b/a/m
    //   240	242	242	com/megvii/zhimasdk/b/a/m
    //   253	273	242	com/megvii/zhimasdk/b/a/m
    //   273	285	242	com/megvii/zhimasdk/b/a/m
    //   285	297	242	com/megvii/zhimasdk/b/a/m
    //   297	306	242	com/megvii/zhimasdk/b/a/m
    //   306	315	242	com/megvii/zhimasdk/b/a/m
    //   317	331	242	com/megvii/zhimasdk/b/a/m
    //   144	158	252	java/lang/Exception
  }
  
  protected com.megvii.zhimasdk.b.a.b.p a(com.megvii.zhimasdk.b.a.n.h paramh, com.megvii.zhimasdk.b.a.e.b paramb, com.megvii.zhimasdk.b.a.b paramb1, com.megvii.zhimasdk.b.a.e.g paramg, com.megvii.zhimasdk.b.a.e.b.d paramd, com.megvii.zhimasdk.b.a.n.g paramg1, com.megvii.zhimasdk.b.a.b.j paramj, com.megvii.zhimasdk.b.a.b.o paramo, com.megvii.zhimasdk.b.a.b.c paramc1, com.megvii.zhimasdk.b.a.b.c paramc2, com.megvii.zhimasdk.b.a.b.q paramq, com.megvii.zhimasdk.b.a.l.e parame)
  {
    return new o(this.a, paramh, paramb, paramb1, paramg, paramd, paramg1, paramj, paramo, paramc1, paramc2, paramq, parame);
  }
  
  protected abstract com.megvii.zhimasdk.b.a.l.e a();
  
  protected com.megvii.zhimasdk.b.a.l.e a(com.megvii.zhimasdk.b.a.q paramq)
  {
    return new g(null, q(), paramq.g(), null);
  }
  
  public void a(com.megvii.zhimasdk.b.a.b.j paramj)
  {
    try
    {
      this.l = paramj;
      return;
    }
    finally
    {
      paramj = finally;
      throw paramj;
    }
  }
  
  public void a(com.megvii.zhimasdk.b.a.r paramr)
  {
    try
    {
      H().b(paramr);
      this.k = null;
      return;
    }
    finally
    {
      paramr = finally;
      throw paramr;
    }
  }
  
  public void a(com.megvii.zhimasdk.b.a.r paramr, int paramInt)
  {
    try
    {
      H().b(paramr, paramInt);
      this.k = null;
      return;
    }
    finally
    {
      paramr = finally;
      throw paramr;
    }
  }
  
  public void a(u paramu)
  {
    try
    {
      H().b(paramu);
      this.k = null;
      return;
    }
    finally
    {
      paramu = finally;
      throw paramu;
    }
  }
  
  protected abstract com.megvii.zhimasdk.b.a.n.b b();
  
  protected com.megvii.zhimasdk.b.a.n.e c()
  {
    com.megvii.zhimasdk.b.a.n.a locala = new com.megvii.zhimasdk.b.a.n.a();
    locala.a("http.scheme-registry", r().a());
    locala.a("http.authscheme-registry", t());
    locala.a("http.cookiespec-registry", v());
    locala.a("http.cookie-store", D());
    locala.a("http.auth.credentials-provider", E());
    return locala;
  }
  
  public void close()
  {
    r().b();
  }
  
  protected com.megvii.zhimasdk.b.a.e.b d()
  {
    com.megvii.zhimasdk.b.a.e.c.i locali = com.megvii.zhimasdk.b.a.i.c.p.a();
    com.megvii.zhimasdk.b.a.l.e locale = q();
    String str = (String)locale.a("http.connection-manager.factory-class-name");
    if (str != null) {}
    for (;;)
    {
      try
      {
        com.megvii.zhimasdk.b.a.e.c localc = (com.megvii.zhimasdk.b.a.e.c)Class.forName(str).newInstance();
        if (localc != null) {
          return localc.a(locale, locali);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new IllegalStateException("Invalid class name: " + str);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalAccessError(localIllegalAccessException.getMessage());
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new InstantiationError(localInstantiationException.getMessage());
      }
      return new com.megvii.zhimasdk.b.a.i.c.d(locali);
      Object localObject = null;
    }
  }
  
  protected com.megvii.zhimasdk.b.a.a.f e()
  {
    com.megvii.zhimasdk.b.a.a.f localf = new com.megvii.zhimasdk.b.a.a.f();
    localf.a("Basic", new com.megvii.zhimasdk.b.a.i.a.c());
    localf.a("Digest", new com.megvii.zhimasdk.b.a.i.a.e());
    localf.a("NTLM", new com.megvii.zhimasdk.b.a.i.a.l());
    return localf;
  }
  
  protected k f()
  {
    k localk = new k();
    localk.a("best-match", new com.megvii.zhimasdk.b.a.i.d.l());
    localk.a("compatibility", new n());
    localk.a("netscape", new v());
    localk.a("rfc2109", new y());
    localk.a("rfc2965", new af());
    localk.a("ignoreCookies", new com.megvii.zhimasdk.b.a.i.d.r());
    return localk;
  }
  
  protected com.megvii.zhimasdk.b.a.n.h g()
  {
    return new com.megvii.zhimasdk.b.a.n.h();
  }
  
  protected com.megvii.zhimasdk.b.a.b h()
  {
    return new com.megvii.zhimasdk.b.a.i.b();
  }
  
  protected com.megvii.zhimasdk.b.a.e.g i()
  {
    return new j();
  }
  
  protected com.megvii.zhimasdk.b.a.b.j j()
  {
    return new l();
  }
  
  protected com.megvii.zhimasdk.b.a.b.c k()
  {
    return new x();
  }
  
  protected com.megvii.zhimasdk.b.a.b.c l()
  {
    return new t();
  }
  
  protected com.megvii.zhimasdk.b.a.b.h m()
  {
    return new e();
  }
  
  protected com.megvii.zhimasdk.b.a.b.i n()
  {
    return new f();
  }
  
  protected com.megvii.zhimasdk.b.a.e.b.d o()
  {
    return new com.megvii.zhimasdk.b.a.i.c.i(r().a());
  }
  
  protected com.megvii.zhimasdk.b.a.b.q p()
  {
    return new p();
  }
  
  public final com.megvii.zhimasdk.b.a.l.e q()
  {
    try
    {
      if (this.c == null) {
        this.c = a();
      }
      com.megvii.zhimasdk.b.a.l.e locale = this.c;
      return locale;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.e.b r()
  {
    try
    {
      if (this.e == null) {
        this.e = d();
      }
      com.megvii.zhimasdk.b.a.e.b localb = this.e;
      return localb;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.n.h s()
  {
    try
    {
      if (this.d == null) {
        this.d = g();
      }
      com.megvii.zhimasdk.b.a.n.h localh = this.d;
      return localh;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.a.f t()
  {
    try
    {
      if (this.i == null) {
        this.i = e();
      }
      com.megvii.zhimasdk.b.a.a.f localf = this.i;
      return localf;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.g u()
  {
    try
    {
      com.megvii.zhimasdk.b.a.b.g localg = this.t;
      return localg;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final k v()
  {
    try
    {
      if (this.h == null) {
        this.h = f();
      }
      k localk = this.h;
      return localk;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.d w()
  {
    try
    {
      com.megvii.zhimasdk.b.a.b.d locald = this.u;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final com.megvii.zhimasdk.b.a.b x()
  {
    try
    {
      if (this.f == null) {
        this.f = h();
      }
      com.megvii.zhimasdk.b.a.b localb = this.f;
      return localb;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.e.g y()
  {
    try
    {
      if (this.g == null) {
        this.g = i();
      }
      com.megvii.zhimasdk.b.a.e.g localg = this.g;
      return localg;
    }
    finally {}
  }
  
  public final com.megvii.zhimasdk.b.a.b.j z()
  {
    try
    {
      if (this.l == null) {
        this.l = j();
      }
      com.megvii.zhimasdk.b.a.b.j localj = this.l;
      return localj;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */