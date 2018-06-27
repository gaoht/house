package com.mato.sdk.proxy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mato.sdk.a.b.a;
import com.mato.sdk.b.j;
import com.mato.sdk.b.o;
import com.mato.sdk.d.m;
import com.mato.sdk.f.l;
import com.mato.sdk.instrumentation.InstrumentationUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class d
  extends a
{
  private static final String c = com.mato.sdk.b.g.b("");
  final AtomicReference<com.mato.sdk.b.f> b = new AtomicReference();
  private final Context d;
  private final b e;
  private final AtomicReference<com.mato.sdk.d.g> f = new AtomicReference();
  private final g g;
  private final com.mato.sdk.a.b h;
  private com.mato.sdk.c.a.g i;
  private q j;
  private final AtomicReference<Address> k = new AtomicReference();
  private boolean l;
  private boolean m;
  private boolean n;
  private com.mato.sdk.g.a.b o;
  private final AtomicBoolean p = new AtomicBoolean(false);
  private com.mato.sdk.e.c.f q;
  private com.mato.sdk.e.d.d r;
  private final List<com.mato.sdk.f.e<?>> s;
  private final com.mato.sdk.e.b.b[] t = new com.mato.sdk.e.b.b[2];
  private final AtomicInteger u = new AtomicInteger(0);
  private String v;
  private final Observer w = new Observer()
  {
    public final void update(Observable paramAnonymousObservable, Object paramAnonymousObject)
    {
      paramAnonymousObservable = (Boolean)paramAnonymousObject;
      d.a(d.this, paramAnonymousObservable.booleanValue());
    }
  };
  
  private d(Context paramContext, b paramb)
    throws p
  {
    this.d = com.mato.sdk.g.i.m(paramContext);
    this.e = paramb;
    this.g = g.a(this.d);
    this.s = new LinkedList();
    f.b(this.d);
    boolean bool = paramb.b().c();
    f.a(this.d, bool);
    paramb = this.g.b("config", "");
    if (!TextUtils.isEmpty(paramb)) {}
    for (paramb = com.mato.sdk.d.g.b(paramb);; paramb = null)
    {
      Object localObject = paramb;
      if (paramb == null) {
        localObject = new com.mato.sdk.d.g();
      }
      this.f.compareAndSet(null, localObject);
      f.a(paramContext, this.g);
      this.h = new com.mato.sdk.a.b(this.g);
      return;
    }
  }
  
  private void A()
  {
    int i1 = 0;
    J();
    com.mato.sdk.d.g localg = i();
    String str1 = f.b(this.d, localg.y());
    String str2 = this.e.d();
    if (!str2.equalsIgnoreCase(str1))
    {
      this.e.a(str1, localg.y());
      f.a(str2);
    }
    if (localg.y())
    {
      f(this.e.d());
      if (this.l) {
        break label168;
      }
      if (this.n)
      {
        this.g.a(false);
        this.g.b(false);
        if (i().A()) {
          break label130;
        }
        w();
      }
    }
    for (;;)
    {
      return;
      P();
      break;
      try
      {
        label130:
        H();
        U();
        V();
        if (Q())
        {
          aa();
          X();
          D();
          return;
        }
      }
      catch (p localp)
      {
        w();
        return;
        label168:
        U();
        V();
        if (!i().A())
        {
          s();
          return;
        }
        m localm = i().I();
        if (!f.a(this.d, localm)) {}
        while (i1 != 0)
        {
          try
          {
            if (this.r == null) {
              this.r = new com.mato.sdk.e.d.d(new com.mato.sdk.e.d.d.a()
              {
                private static final String b = "http.proxyHost";
                private static final String c = "http.proxyPort";
                private static final String d = "https.proxyHost";
                private static final String e = "https.proxyPort";
                private static String f;
                private static String g;
                private static String h;
                private static String i;
                
                public static void a(String paramAnonymousString, int paramAnonymousInt)
                {
                  f = System.getProperty("http.proxyHost");
                  g = System.getProperty("http.proxyPort");
                  h = System.getProperty("https.proxyHost");
                  i = System.getProperty("https.proxyPort");
                  System.setProperty("http.proxyHost", paramAnonymousString);
                  System.setProperty("http.proxyPort", paramAnonymousInt);
                  System.setProperty("https.proxyHost", paramAnonymousString);
                  System.setProperty("https.proxyPort", paramAnonymousInt);
                }
                
                private static void a(String paramAnonymousString1, String paramAnonymousString2)
                {
                  if (paramAnonymousString2 == null)
                  {
                    System.getProperties().remove(paramAnonymousString1);
                    return;
                  }
                  System.setProperty(paramAnonymousString1, paramAnonymousString2);
                }
                
                public static void b()
                {
                  a("http.proxyHost", f);
                  a("http.proxyPort", g);
                  a("https.proxyHost", h);
                  a("https.proxyPort", i);
                }
                
                public final void a()
                {
                  d.c(d.this);
                }
              });
            }
            this.r.a(i().I());
            return;
          }
          catch (Exception localException)
          {
            return;
          }
          i1 = 1;
        }
        B();
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private void B()
  {
    com.mato.sdk.d.k localk;
    if (Q())
    {
      aa();
      X();
      D();
      localk = i().H();
      if (!f.a(this.d, localk)) {}
    }
    try
    {
      if (this.q == null) {
        this.q = new com.mato.sdk.e.c.f(this.d, this.j);
      }
      this.q.a(localk);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void C()
  {
    Log.e(c, "Config parse error");
    if (this.l)
    {
      U();
      V();
      X();
    }
    while (!this.n) {
      return;
    }
    w();
  }
  
  private void D()
  {
    com.mato.sdk.d.h localh = i().F();
    if (!com.mato.sdk.c.a.e.a(localh)) {
      return;
    }
    try
    {
      com.mato.sdk.e.b.d.a(this.d, new Proxy.NetDiagnosisListener()
      {
        public final void onCompleted(String paramAnonymousString)
        {
          d.v();
        }
      }, localh);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.mato.sdk.c.b.f.b().a(localThrowable);
    }
  }
  
  private void E()
  {
    synchronized (this.s)
    {
      try
      {
        Iterator localIterator = this.s.iterator();
        while (localIterator.hasNext())
        {
          com.mato.sdk.f.e locale = (com.mato.sdk.f.e)localIterator.next();
          localIterator.remove();
          c().a(locale);
        }
        localObject = finally;
      }
      catch (Throwable localThrowable)
      {
        com.mato.sdk.c.b.f.b().a(localThrowable);
        return;
      }
    }
  }
  
  private void F()
  {
    this.m = false;
    com.mato.sdk.b.k.a(this.d, this.w);
    com.mato.sdk.c.b.g.a(this.d, this.e.b().c());
    J();
    com.mato.sdk.d.g localg = i();
    String str = f.b(this.d, localg.y());
    this.e.a(str, localg.y());
    if (localg.y()) {
      new com.mato.sdk.c.c.a(this.e.c(), this.e.d()).a();
    }
    f.a(str);
  }
  
  private void G()
  {
    new com.mato.sdk.c.c.a(this.e.c(), this.e.d()).a();
  }
  
  private void H()
    throws p
  {
    this.j = new q(new h(this, this.g.a("wsg_support", -1)), new i(this));
    int i1 = this.j.a();
    if (i1 != 0)
    {
      w();
      throw f.a(i1);
    }
    i1 = this.j.b();
    this.k.set(new Address("127.0.0.1", i1));
    this.l = true;
    InstrumentationUtils.init((Address)this.k.get());
    if (!h().e())
    {
      i1 = this.u.get();
      this.u.set(i1 | 0x2);
    }
    for (;;)
    {
      com.mato.sdk.c.a.a.a().a(this.e.c());
      com.mato.sdk.c.a.a.a().b();
      if (i().x())
      {
        ProxyOptions localProxyOptions = this.e.b();
        if ((localProxyOptions != null) && (localProxyOptions.b() != null)) {
          com.mato.sdk.c.a.a.a().a(new com.mato.sdk.c.a.e(localProxyOptions.b(), this.d));
        }
      }
      j();
      return;
      N();
    }
  }
  
  private void I()
  {
    if (!h().e())
    {
      int i1 = this.u.get();
      this.u.set(i1 | 0x2);
    }
    for (;;)
    {
      com.mato.sdk.c.a.a.a().a(this.e.c());
      com.mato.sdk.c.a.a.a().b();
      if (i().x())
      {
        ProxyOptions localProxyOptions = this.e.b();
        if ((localProxyOptions != null) && (localProxyOptions.b() != null)) {
          com.mato.sdk.c.a.a.a().a(new com.mato.sdk.c.a.e(localProxyOptions.b(), this.d));
        }
      }
      j();
      return;
      N();
    }
  }
  
  private void J()
  {
    Object localObject = i();
    com.mato.sdk.b.e locale = a();
    com.mato.sdk.c.c.a(((com.mato.sdk.d.g)localObject).b());
    localObject = ((com.mato.sdk.d.g)localObject).l();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      locale.a(locale.k() + (String)localObject);
    }
  }
  
  private void K()
  {
    J();
    com.mato.sdk.d.g localg = i();
    String str = f.b(this.d, localg.y());
    this.e.a(str, localg.y());
    if (localg.y()) {
      new com.mato.sdk.c.c.a(this.e.c(), this.e.d()).a();
    }
    f.a(str);
  }
  
  private void L()
  {
    J();
    com.mato.sdk.d.g localg = i();
    String str1 = f.b(this.d, localg.y());
    String str2 = this.e.d();
    if (!str2.equalsIgnoreCase(str1))
    {
      this.e.a(str1, localg.y());
      f.a(str2);
    }
    if (localg.y())
    {
      f(this.e.d());
      return;
    }
    P();
  }
  
  private boolean M()
  {
    if (this.g.a("sdk_disable_mark", false)) {}
    while ((this.g.a("ndk_crash_mark", false)) || (this.g.a("sdk_crash_mark", false))) {
      return true;
    }
    return false;
  }
  
  private void N()
  {
    Address localAddress = g();
    if (localAddress == null) {
      return;
    }
    if (this.e.b().d()) {
      com.mato.sdk.b.n.a(localAddress.getHost(), localAddress.getPort());
    }
    f();
  }
  
  private void O()
  {
    if (this.p.get())
    {
      this.p.set(false);
      f.a(this.d);
    }
    com.mato.sdk.b.n.a();
  }
  
  private void P()
  {
    if (this.j == null) {
      return;
    }
    try
    {
      this.j.a(5, "");
      return;
    }
    catch (j localj) {}
  }
  
  private boolean Q()
  {
    try
    {
      if (!this.j.d()) {
        return false;
      }
      this.j.a(j());
      return true;
    }
    catch (j localj)
    {
      com.mato.sdk.c.b.f.b().a(localj);
      w();
    }
    return false;
  }
  
  private void R()
  {
    this.g.a(false);
    this.g.b(false);
    if (!i().A()) {
      w();
    }
    for (;;)
    {
      return;
      try
      {
        H();
        U();
        V();
        if (Q())
        {
          aa();
          X();
          D();
          return;
        }
      }
      catch (p localp)
      {
        w();
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private void S()
  {
    w();
  }
  
  private void T()
  {
    if (!this.p.get()) {
      return;
    }
    this.p.set(false);
    f.a(this.d);
  }
  
  private void U()
  {
    try
    {
      long l1 = i().s() * 60000;
      if (this.o != null)
      {
        if (l1 == ((b)this.o.a()).a()) {
          return;
        }
        this.o.b();
      }
      b localb = new b(this, l1);
      this.o = com.mato.sdk.g.a.a.b().a(localb);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.mato.sdk.c.b.f.b().a(localThrowable);
    }
  }
  
  private void V()
  {
    com.mato.sdk.d.e locale = i().E();
    if ((locale == null) || (locale.b() == null)) {}
    for (int i1 = 0; i1 == 0; i1 = 1) {
      return;
    }
    try
    {
      com.mato.sdk.e.a.a.a().a(this.j);
      com.mato.sdk.e.a.a.a().a(locale);
      com.mato.sdk.e.a.a.a().b();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.mato.sdk.c.b.f.b().a(localThrowable);
    }
  }
  
  private boolean W()
  {
    Object localObject1 = this.g.b("config", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (localObject1 = com.mato.sdk.d.g.b((String)localObject1);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new com.mato.sdk.d.g();
      }
      return this.f.compareAndSet(null, localObject2);
    }
  }
  
  private void X()
  {
    Object localObject = this.e.c();
    com.mato.sdk.c.a.a locala = com.mato.sdk.c.a.a.a();
    if (locala.b((String)localObject))
    {
      locala.c();
      locala.a((String)localObject);
      locala.b();
    }
    localObject = null;
    for (;;)
    {
      com.mato.sdk.d.f localf;
      try
      {
        locala = com.mato.sdk.c.a.a.a();
        localf = i().a();
        if ((localf == null) || (localf.c() == 0) || (localf.a() <= 0)) {
          break label181;
        }
        i1 = 1;
        if (i1 == 0)
        {
          if (this.i != null) {
            localObject = this.i;
          }
          if (localObject == null) {
            break label180;
          }
          locala.b((com.mato.sdk.c.a.b)localObject);
          return;
        }
        if (this.i == null)
        {
          this.i = new com.mato.sdk.c.a.g(localf, this);
          locala.a(this.i);
          continue;
        }
        if (this.i.a(localf)) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        com.mato.sdk.c.b.f.b().a(localThrowable);
        return;
      }
      com.mato.sdk.c.a.g localg = this.i;
      this.i = new com.mato.sdk.c.a.g(localf, this);
      locala.a(this.i);
      continue;
      label180:
      return;
      label181:
      int i1 = 0;
    }
  }
  
  private void Y()
  {
    String str = this.e.c();
    com.mato.sdk.c.a.a locala = com.mato.sdk.c.a.a.a();
    if (locala.b(str))
    {
      locala.c();
      locala.a(str);
      locala.b();
    }
  }
  
  private void Z()
  {
    com.mato.sdk.c.a.g localg1 = null;
    for (;;)
    {
      com.mato.sdk.c.a.a locala;
      com.mato.sdk.d.f localf;
      try
      {
        locala = com.mato.sdk.c.a.a.a();
        localf = i().a();
        if ((localf == null) || (localf.c() == 0) || (localf.a() <= 0)) {
          break label148;
        }
        i1 = 1;
        if (i1 == 0)
        {
          if (this.i != null) {
            localg1 = this.i;
          }
          if (localg1 == null) {
            break label147;
          }
          locala.b(localg1);
          return;
        }
        if (this.i == null)
        {
          this.i = new com.mato.sdk.c.a.g(localf, this);
          locala.a(this.i);
          continue;
        }
        if (this.i.a(localf)) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        com.mato.sdk.c.b.f.b().a(localThrowable);
        return;
      }
      com.mato.sdk.c.a.g localg2 = this.i;
      this.i = new com.mato.sdk.c.a.g(localf, this);
      locala.a(this.i);
      continue;
      label147:
      return;
      label148:
      int i1 = 0;
    }
  }
  
  private static com.mato.sdk.g.a.b a(com.mato.sdk.g.a.c paramc)
  {
    return com.mato.sdk.g.a.a.b().a(paramc);
  }
  
  public static a a(Context paramContext, b paramb)
    throws p
  {
    System.currentTimeMillis();
    a.a(new d(paramContext, paramb));
    a.b().e();
    System.currentTimeMillis();
    return a.b();
  }
  
  private static d a(Context paramContext)
    throws p
  {
    paramContext = new d(paramContext, new b());
    paramContext.F();
    return paramContext;
  }
  
  private void a(com.mato.sdk.b.h paramh)
  {
    for (;;)
    {
      try
      {
        paramh.f();
        boolean bool = this.l;
        if (!bool) {
          break label153;
        }
        try
        {
          if ((paramh.e()) && (i().B())) {
            this.h.b(new a(this));
          }
          this.j.e();
          this.j.a(j());
          if (!paramh.e()) {
            continue;
          }
          int i1 = this.u.get();
          if ((i1 & 0x2) == 2) {
            this.u.set(i1 & 0xFFFFFFFD);
          }
          this.u.get();
          N();
          if ((paramh.b()) && (paramh.e())) {
            E();
          }
        }
        catch (j paramh)
        {
          w();
          continue;
        }
        return;
      }
      finally {}
      c(2);
      continue;
      label153:
      if ((this.n) && (paramh.b())) {
        E();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      w();
      return;
    }
    a(h());
  }
  
  private void aa()
  {
    if (!TextUtils.isEmpty(this.v)) {
      this.g.d("config", this.v);
    }
  }
  
  private void b(int paramInt)
  {
    paramInt = this.u.get();
    if ((paramInt & 0x2) == 2) {
      this.u.set(paramInt & 0xFFFFFFFD);
    }
    this.u.get();
    N();
  }
  
  /* Error */
  private void b(com.mato.sdk.f.e<?> parame)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 131	com/mato/sdk/proxy/d:s	Ljava/util/List;
    //   9: astore_3
    //   10: aload_3
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 131	com/mato/sdk/proxy/d:s	Ljava/util/List;
    //   16: invokeinterface 329 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 334 1 0
    //   30: ifeq +56 -> 86
    //   33: aload 4
    //   35: invokeinterface 338 1 0
    //   40: checkcast 340	com/mato/sdk/f/e
    //   43: aload_1
    //   44: invokevirtual 647	com/mato/sdk/f/e:a	(Lcom/mato/sdk/f/e;)Z
    //   47: ifeq -24 -> 23
    //   50: iconst_1
    //   51: istore_2
    //   52: iload_2
    //   53: ifne +14 -> 67
    //   56: aload_0
    //   57: getfield 131	com/mato/sdk/proxy/d:s	Ljava/util/List;
    //   60: aload_1
    //   61: invokeinterface 651 2 0
    //   66: pop
    //   67: aload_3
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload_3
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: invokestatic 319	com/mato/sdk/c/b/f:b	()Lcom/mato/sdk/c/b/f;
    //   79: aload_1
    //   80: invokevirtual 322	com/mato/sdk/c/b/f:a	(Ljava/lang/Throwable;)V
    //   83: goto -16 -> 67
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -36 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	d
    //   0	91	1	parame	com.mato.sdk.f.e<?>
    //   51	37	2	i1	int
    //   21	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   12	23	70	finally
    //   23	50	70	finally
    //   56	67	70	finally
    //   67	69	70	finally
    //   71	73	70	finally
    //   76	83	70	finally
    //   12	23	75	java/lang/Throwable
    //   23	50	75	java/lang/Throwable
    //   56	67	75	java/lang/Throwable
  }
  
  private void c(int paramInt)
  {
    int i1 = this.u.get();
    this.u.set(i1 | paramInt);
    this.u.get();
    if (this.p.get())
    {
      this.p.set(false);
      f.a(this.d);
    }
    com.mato.sdk.b.n.a();
  }
  
  private boolean d(String paramString)
  {
    com.mato.sdk.d.g localg = com.mato.sdk.d.g.b(paramString);
    if (localg != null)
    {
      this.f.set(localg);
      this.v = paramString;
      return true;
    }
    return false;
  }
  
  private void e(String paramString)
  {
    this.g.b(paramString);
    i().a(false);
    try
    {
      this.j.a(false);
      return;
    }
    catch (j paramString)
    {
      com.mato.sdk.c.b.f.b().a(paramString);
      w();
    }
  }
  
  private boolean f(String paramString)
  {
    if (this.j == null) {
      return false;
    }
    try
    {
      this.j.a(0, paramString);
      return true;
    }
    catch (j paramString) {}
    return false;
  }
  
  /* Error */
  private void w()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 353	com/mato/sdk/proxy/d:m	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 353	com/mato/sdk/proxy/d:m	Z
    //   19: invokestatic 658	com/mato/sdk/b/k:b	()V
    //   22: invokestatic 433	com/mato/sdk/c/a/a:a	()Lcom/mato/sdk/c/a/a;
    //   25: invokevirtual 578	com/mato/sdk/c/a/a:c	()V
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 216	com/mato/sdk/proxy/d:l	Z
    //   33: aload_0
    //   34: getfield 285	com/mato/sdk/proxy/d:j	Lcom/mato/sdk/proxy/q;
    //   37: ifnull +15 -> 52
    //   40: aload_0
    //   41: getfield 285	com/mato/sdk/proxy/d:j	Lcom/mato/sdk/proxy/q;
    //   44: invokevirtual 659	com/mato/sdk/proxy/q:c	()V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 285	com/mato/sdk/proxy/d:j	Lcom/mato/sdk/proxy/q;
    //   52: invokestatic 550	com/mato/sdk/g/a/a:b	()Lcom/mato/sdk/g/a/a;
    //   55: invokevirtual 660	com/mato/sdk/g/a/a:a	()V
    //   58: invokestatic 346	com/mato/sdk/proxy/d:c	()Lcom/mato/sdk/f/l;
    //   61: invokevirtual 661	com/mato/sdk/f/l:a	()V
    //   64: new 663	com/mato/sdk/c/b/d
    //   67: dup
    //   68: invokespecial 664	com/mato/sdk/c/b/d:<init>	()V
    //   71: invokestatic 667	com/mato/sdk/c/b/f:a	(Lcom/mato/sdk/c/b/f;)V
    //   74: aload_0
    //   75: iconst_4
    //   76: invokespecial 635	com/mato/sdk/proxy/d:c	(I)V
    //   79: getstatic 670	com/mato/sdk/proxy/a:a	Lcom/mato/sdk/proxy/a;
    //   82: invokestatic 611	com/mato/sdk/proxy/a:a	(Lcom/mato/sdk/proxy/a;)V
    //   85: goto -74 -> 11
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	d
    //   6	2	1	bool	boolean
    //   88	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	88	finally
    //   14	52	88	finally
    //   52	85	88	finally
  }
  
  private void x()
  {
    com.mato.sdk.d.k localk = i().H();
    if (!f.a(this.d, localk)) {
      return;
    }
    try
    {
      if (this.q == null) {
        this.q = new com.mato.sdk.e.c.f(this.d, this.j);
      }
      this.q.a(localk);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private boolean y()
  {
    m localm = i().I();
    return f.a(this.d, localm);
  }
  
  private void z()
  {
    try
    {
      if (this.r == null) {
        this.r = new com.mato.sdk.e.d.d(new com.mato.sdk.e.d.d.a()
        {
          private static final String b = "http.proxyHost";
          private static final String c = "http.proxyPort";
          private static final String d = "https.proxyHost";
          private static final String e = "https.proxyPort";
          private static String f;
          private static String g;
          private static String h;
          private static String i;
          
          public static void a(String paramAnonymousString, int paramAnonymousInt)
          {
            f = System.getProperty("http.proxyHost");
            g = System.getProperty("http.proxyPort");
            h = System.getProperty("https.proxyHost");
            i = System.getProperty("https.proxyPort");
            System.setProperty("http.proxyHost", paramAnonymousString);
            System.setProperty("http.proxyPort", paramAnonymousInt);
            System.setProperty("https.proxyHost", paramAnonymousString);
            System.setProperty("https.proxyPort", paramAnonymousInt);
          }
          
          private static void a(String paramAnonymousString1, String paramAnonymousString2)
          {
            if (paramAnonymousString2 == null)
            {
              System.getProperties().remove(paramAnonymousString1);
              return;
            }
            System.setProperty(paramAnonymousString1, paramAnonymousString2);
          }
          
          public static void b()
          {
            a("http.proxyHost", f);
            a("http.proxyPort", g);
            a("https.proxyHost", h);
            a("https.proxyPort", i);
          }
          
          public final void a()
          {
            d.c(d.this);
          }
        });
      }
      this.r.a(i().I());
      return;
    }
    catch (Exception localException) {}
  }
  
  final com.mato.sdk.e.b.b a(int paramInt)
  {
    return this.t[paramInt];
  }
  
  /* Error */
  public final java.net.Socket a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 216	com/mato/sdk/proxy/d:l	Z
    //   9: istore 4
    //   11: iload 4
    //   13: ifne +12 -> 25
    //   16: aload 6
    //   18: astore 5
    //   20: aload_0
    //   21: monitorexit
    //   22: aload 5
    //   24: areturn
    //   25: aload_1
    //   26: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: istore 4
    //   31: aload 6
    //   33: astore 5
    //   35: iload 4
    //   37: ifne -17 -> 20
    //   40: aload_1
    //   41: iload_2
    //   42: iload_3
    //   43: invokestatic 678	com/mato/sdk/instrumentation/InstrumentationUtils:connect	(Ljava/lang/String;II)Ljava/net/Socket;
    //   46: astore 5
    //   48: goto -28 -> 20
    //   51: astore_1
    //   52: aload 6
    //   54: astore 5
    //   56: goto -36 -> 20
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	d
    //   0	64	1	paramString	String
    //   0	64	2	paramInt1	int
    //   0	64	3	paramInt2	int
    //   9	27	4	bool	boolean
    //   18	37	5	localObject1	Object
    //   1	52	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	51	java/io/IOException
    //   5	11	59	finally
    //   25	31	59	finally
    //   40	48	59	finally
  }
  
  public final void a(com.mato.sdk.b.f paramf)
  {
    if (paramf == null) {}
    while (this.j == null) {
      return;
    }
    this.j.a(paramf.b(), paramf.a());
  }
  
  public final void a(com.mato.sdk.e.b.b paramb, int paramInt)
  {
    this.t[paramInt] = paramb;
    if (paramb != null) {
      Q();
    }
  }
  
  /* Error */
  public final void a(com.mato.sdk.f.e<?> parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 495	com/mato/sdk/proxy/d:g	()Lcom/mato/sdk/proxy/Address;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +15 -> 21
    //   9: aload_1
    //   10: aload_3
    //   11: invokevirtual 500	com/mato/sdk/proxy/Address:getHost	()Ljava/lang/String;
    //   14: aload_3
    //   15: invokevirtual 503	com/mato/sdk/proxy/Address:getPort	()I
    //   18: invokevirtual 688	com/mato/sdk/f/e:a	(Ljava/lang/String;I)V
    //   21: aload_0
    //   22: invokevirtual 420	com/mato/sdk/proxy/d:h	()Lcom/mato/sdk/b/h;
    //   25: invokevirtual 424	com/mato/sdk/b/h:e	()Z
    //   28: ifeq +11 -> 39
    //   31: invokestatic 346	com/mato/sdk/proxy/d:c	()Lcom/mato/sdk/f/l;
    //   34: aload_1
    //   35: invokevirtual 351	com/mato/sdk/f/l:a	(Lcom/mato/sdk/f/e;)V
    //   38: return
    //   39: aload_1
    //   40: ifnull -2 -> 38
    //   43: aload_0
    //   44: getfield 131	com/mato/sdk/proxy/d:s	Ljava/util/List;
    //   47: astore_3
    //   48: aload_3
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 131	com/mato/sdk/proxy/d:s	Ljava/util/List;
    //   54: invokeinterface 329 1 0
    //   59: astore 4
    //   61: aload 4
    //   63: invokeinterface 334 1 0
    //   68: ifeq +56 -> 124
    //   71: aload 4
    //   73: invokeinterface 338 1 0
    //   78: checkcast 340	com/mato/sdk/f/e
    //   81: aload_1
    //   82: invokevirtual 647	com/mato/sdk/f/e:a	(Lcom/mato/sdk/f/e;)Z
    //   85: ifeq -24 -> 61
    //   88: iconst_1
    //   89: istore_2
    //   90: iload_2
    //   91: ifne +14 -> 105
    //   94: aload_0
    //   95: getfield 131	com/mato/sdk/proxy/d:s	Ljava/util/List;
    //   98: aload_1
    //   99: invokeinterface 651 2 0
    //   104: pop
    //   105: aload_3
    //   106: monitorexit
    //   107: return
    //   108: astore_1
    //   109: aload_3
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: astore_1
    //   114: invokestatic 319	com/mato/sdk/c/b/f:b	()Lcom/mato/sdk/c/b/f;
    //   117: aload_1
    //   118: invokevirtual 322	com/mato/sdk/c/b/f:a	(Ljava/lang/Throwable;)V
    //   121: goto -16 -> 105
    //   124: iconst_0
    //   125: istore_2
    //   126: goto -36 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	d
    //   0	129	1	parame	com.mato.sdk.f.e<?>
    //   89	37	2	i1	int
    //   59	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   50	61	108	finally
    //   61	88	108	finally
    //   94	105	108	finally
    //   105	107	108	finally
    //   109	111	108	finally
    //   114	121	108	finally
    //   50	61	113	java/lang/Throwable
    //   61	88	113	java/lang/Throwable
    //   94	105	113	java/lang/Throwable
  }
  
  public final void a(String paramString)
  {
    this.e.a(paramString);
    if (paramString != null)
    {
      f(paramString);
      return;
    }
    P();
  }
  
  /* Error */
  public final void a(java.net.Socket paramSocket)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 216	com/mato/sdk/proxy/d:l	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 695	java/net/Socket:getLocalPort	()I
    //   18: invokestatic 699	com/mato/sdk/b/m:d	(I)V
    //   21: aload_1
    //   22: invokevirtual 702	java/net/Socket:close	()V
    //   25: goto -14 -> 11
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	d
    //   0	33	1	paramSocket	java.net.Socket
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
  
  final void b(String paramString)
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        boolean bool = this.m;
        if (bool) {
          return;
        }
        try
        {
          f.a(this);
          Object localObject = com.mato.sdk.d.g.b(paramString);
          if (localObject == null) {
            break label204;
          }
          this.f.set(localObject);
          this.v = paramString;
          i1 = 1;
          bool = i().A();
          if (!bool) {
            break label209;
          }
          this.g.c(false);
          this.g.b("");
          f.c(this);
          if (i1 == 0) {
            break label305;
          }
          J();
          paramString = i();
          localObject = f.b(this.d, paramString.y());
          String str = this.e.d();
          if (!str.equalsIgnoreCase((String)localObject))
          {
            this.e.a((String)localObject, paramString.y());
            f.a(str);
          }
          if (!paramString.y()) {
            break label234;
          }
          f(this.e.d());
          if (this.l) {
            break label241;
          }
          if (!this.n) {
            continue;
          }
          R();
        }
        catch (Throwable paramString)
        {
          com.mato.sdk.c.b.f.b().a(paramString);
        }
        continue;
        i1 = 0;
      }
      finally {}
      label204:
      continue;
      label209:
      this.g.c(true);
      f.b(this);
      Log.w(c, "SDK terminated");
      continue;
      label234:
      P();
      continue;
      label241:
      U();
      V();
      if (i().A()) {
        break;
      }
      s();
    }
    paramString = i().I();
    if (!f.a(this.d, paramString)) {}
    for (int i1 = i2;; i1 = 1)
    {
      if (i1 != 0)
      {
        z();
        break;
      }
      B();
      break;
      label305:
      Log.e(c, "Config parse error");
      if (this.l)
      {
        U();
        V();
        X();
        break;
      }
      if (!this.n) {
        break;
      }
      w();
      break;
    }
  }
  
  final void c(String paramString)
  {
    for (;;)
    {
      try
      {
        f.b(this, paramString);
        boolean bool = this.m;
        if (bool) {
          return;
        }
        try
        {
          if (this.l) {
            break label60;
          }
          if (!this.n) {
            continue;
          }
          f.b(this);
          w();
        }
        catch (Throwable paramString)
        {
          com.mato.sdk.c.b.f.b().a(paramString);
        }
        continue;
        if (!this.h.a()) {
          break label99;
        }
      }
      finally {}
      label60:
      e(paramString);
      Log.e(c, "Auth failure: " + paramString);
      label99:
      f.c(this);
      U();
    }
  }
  
  public final void e()
    throws p
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        F();
        boolean bool1;
        if (this.g.a("sdk_disable_mark", false))
        {
          bool1 = bool2;
          this.n = bool1;
          bool1 = this.n;
          if (this.n)
          {
            this.h.a(new a(this));
            com.mato.sdk.c.b.f.b().a();
            com.mato.sdk.b.d locald = new com.mato.sdk.b.d(this.g);
            com.mato.sdk.g.a.a.b().a(locald);
            f.a();
            this.g.a("");
          }
        }
        else
        {
          bool1 = bool2;
          if (this.g.a("ndk_crash_mark", false)) {
            continue;
          }
          bool1 = bool2;
          if (this.g.a("sdk_crash_mark", false)) {
            continue;
          }
          bool1 = false;
          continue;
        }
        H();
        long l1 = i().k();
        if (this.h.a(l1)) {
          this.h.a(new a(this));
        } else {
          X();
        }
      }
      finally {}
    }
  }
  
  public final void f()
  {
    if (!this.e.b().f()) {
      return;
    }
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        Address localAddress = d.this.g();
        if (localAddress == null) {
          return;
        }
        boolean bool = false;
        if (d.this.h().e()) {
          bool = n.a(d.a(d.this), localAddress.getHost(), localAddress.getPort());
        }
        if (bool)
        {
          d.b(d.this).set(true);
          return;
        }
        o.a();
      }
    };
    f.a(local1);
    f.a(local1, 1000L);
  }
  
  public final Address g()
  {
    if (this.u.get() != 0) {
      return null;
    }
    return (Address)this.k.get();
  }
  
  public final com.mato.sdk.b.h h()
  {
    com.mato.sdk.b.h localh2 = com.mato.sdk.b.k.a();
    com.mato.sdk.b.h localh1 = localh2;
    if (localh2 == null) {
      localh1 = com.mato.sdk.b.h.a(this.d, null);
    }
    return localh1;
  }
  
  public final com.mato.sdk.d.g i()
  {
    return (com.mato.sdk.d.g)this.f.get();
  }
  
  public final boolean j()
  {
    if (!h().b()) {}
    while (m().b()) {
      return false;
    }
    return true;
  }
  
  public final String k()
  {
    return this.e.d();
  }
  
  public final com.mato.sdk.b.f l()
  {
    return (com.mato.sdk.b.f)this.b.get();
  }
  
  public final com.mato.sdk.d.i m()
  {
    int i1 = h().c();
    return i().a(i1);
  }
  
  public final int n()
  {
    return this.u.get();
  }
  
  public final b o()
  {
    return this.e;
  }
  
  public final g p()
  {
    return this.g;
  }
  
  public final Context q()
  {
    return this.d;
  }
  
  public final boolean r()
  {
    return this.l;
  }
  
  final void s()
  {
    c(1);
    e("sdk disabled");
  }
  
  final int t()
  {
    com.mato.sdk.d.g localg = i();
    if (localg.x())
    {
      ProxyOptions localProxyOptions = this.e.b();
      if ((localProxyOptions != null) && (localProxyOptions.b() != null)) {
        return -1;
      }
    }
    return localg.a().c();
  }
  
  final com.mato.sdk.e.d.d u()
  {
    return this.r;
  }
  
  static final class a
    implements b.a
  {
    private final d a;
    
    public a(d paramd)
    {
      this.a = paramd;
    }
    
    public final void a(String paramString)
    {
      this.a.b(paramString);
    }
    
    public final void b(String paramString)
    {
      this.a.c(paramString);
    }
  }
  
  static final class b
    extends com.mato.sdk.g.a.c
  {
    private final d a;
    private final long b;
    
    public b(d paramd, long paramLong)
    {
      this.a = paramd;
      this.b = paramLong;
    }
    
    protected final long a()
    {
      return this.b;
    }
    
    protected final void b()
    {
      d.d(this.a).c(new d.a(this.a));
    }
    
    protected final long c()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */