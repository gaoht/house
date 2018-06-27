package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.b.p;
import com.megvii.zhimasdk.b.a.e.c.i;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@Deprecated
public class o
  implements p
{
  public com.megvii.zhimasdk.b.a.h.b a;
  protected final com.megvii.zhimasdk.b.a.e.b b;
  protected final com.megvii.zhimasdk.b.a.e.b.d c;
  protected final com.megvii.zhimasdk.b.a.b d;
  protected final com.megvii.zhimasdk.b.a.e.g e;
  protected final com.megvii.zhimasdk.b.a.n.h f;
  protected final com.megvii.zhimasdk.b.a.n.g g;
  protected final com.megvii.zhimasdk.b.a.b.j h;
  @Deprecated
  protected final com.megvii.zhimasdk.b.a.b.n i;
  protected final com.megvii.zhimasdk.b.a.b.o j;
  @Deprecated
  protected final com.megvii.zhimasdk.b.a.b.b k;
  protected final com.megvii.zhimasdk.b.a.b.c l;
  @Deprecated
  protected final com.megvii.zhimasdk.b.a.b.b m;
  protected final com.megvii.zhimasdk.b.a.b.c n;
  protected final com.megvii.zhimasdk.b.a.b.q o;
  protected final com.megvii.zhimasdk.b.a.l.e p;
  protected com.megvii.zhimasdk.b.a.e.o q;
  protected final com.megvii.zhimasdk.b.a.a.h r;
  protected final com.megvii.zhimasdk.b.a.a.h s;
  private final r t;
  private int u;
  private int v;
  private final int w;
  private com.megvii.zhimasdk.b.a.n x;
  
  public o(com.megvii.zhimasdk.b.a.h.b paramb, com.megvii.zhimasdk.b.a.n.h paramh, com.megvii.zhimasdk.b.a.e.b paramb1, com.megvii.zhimasdk.b.a.b paramb2, com.megvii.zhimasdk.b.a.e.g paramg, com.megvii.zhimasdk.b.a.e.b.d paramd, com.megvii.zhimasdk.b.a.n.g paramg1, com.megvii.zhimasdk.b.a.b.j paramj, com.megvii.zhimasdk.b.a.b.o paramo, com.megvii.zhimasdk.b.a.b.c paramc1, com.megvii.zhimasdk.b.a.b.c paramc2, com.megvii.zhimasdk.b.a.b.q paramq, com.megvii.zhimasdk.b.a.l.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramb, "AliLog");
    com.megvii.zhimasdk.b.a.o.a.a(paramh, "Request executor");
    com.megvii.zhimasdk.b.a.o.a.a(paramb1, "Client connection manager");
    com.megvii.zhimasdk.b.a.o.a.a(paramb2, "Connection reuse strategy");
    com.megvii.zhimasdk.b.a.o.a.a(paramg, "Connection keep alive strategy");
    com.megvii.zhimasdk.b.a.o.a.a(paramd, "Route planner");
    com.megvii.zhimasdk.b.a.o.a.a(paramg1, "HTTP protocol processor");
    com.megvii.zhimasdk.b.a.o.a.a(paramj, "HTTP request retry handler");
    com.megvii.zhimasdk.b.a.o.a.a(paramo, "Redirect strategy");
    com.megvii.zhimasdk.b.a.o.a.a(paramc1, "Target authentication strategy");
    com.megvii.zhimasdk.b.a.o.a.a(paramc2, "Proxy authentication strategy");
    com.megvii.zhimasdk.b.a.o.a.a(paramq, "User token handler");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    this.a = paramb;
    this.t = new r(paramb);
    this.f = paramh;
    this.b = paramb1;
    this.d = paramb2;
    this.e = paramg;
    this.c = paramd;
    this.g = paramg1;
    this.h = paramj;
    this.j = paramo;
    this.l = paramc1;
    this.n = paramc2;
    this.o = paramq;
    this.p = parame;
    if ((paramo instanceof n))
    {
      this.i = ((n)paramo).a();
      if (!(paramc1 instanceof b)) {
        break label315;
      }
      this.k = ((b)paramc1).a();
      label232:
      if (!(paramc2 instanceof b)) {
        break label323;
      }
    }
    label315:
    label323:
    for (this.m = ((b)paramc2).a();; this.m = null)
    {
      this.q = null;
      this.u = 0;
      this.v = 0;
      this.r = new com.megvii.zhimasdk.b.a.a.h();
      this.s = new com.megvii.zhimasdk.b.a.a.h();
      this.w = this.p.a("http.protocol.max-redirects", 100);
      return;
      this.i = null;
      break;
      this.k = null;
      break label232;
    }
  }
  
  private v a(com.megvii.zhimasdk.b.a.q paramq)
  {
    if ((paramq instanceof com.megvii.zhimasdk.b.a.l)) {
      return new q((com.megvii.zhimasdk.b.a.l)paramq);
    }
    return new v(paramq);
  }
  
  private void a(w paramw, com.megvii.zhimasdk.b.a.n.e parame)
  {
    localb = paramw.b();
    paramw = paramw.a();
    i1 = 0;
    for (;;)
    {
      parame.a("http.request", paramw);
      i2 = i1 + 1;
      try
      {
        if (!this.q.c()) {
          this.q.a(localb, parame, this.p);
        }
        for (;;)
        {
          a(localb, parame);
          return;
          this.q.b(com.megvii.zhimasdk.b.a.l.c.a(this.p));
        }
        try
        {
          this.q.close();
          if (this.h.a(localIOException1, i2, parame))
          {
            i1 = i2;
            if (!this.a.d()) {
              continue;
            }
            this.a.d("I/O exception (" + localIOException1.getClass().getName() + ") caught when connecting to " + localb + ": " + localIOException1.getMessage());
            if (this.a.a()) {
              this.a.a(localIOException1.getMessage(), localIOException1);
            }
            this.a.d("Retrying connect to " + localb);
            i1 = i2;
            continue;
          }
          throw localIOException1;
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
      }
      catch (IOException localIOException1) {}
    }
  }
  
  private s b(w paramw, com.megvii.zhimasdk.b.a.n.e parame)
  {
    v localv = paramw.a();
    com.megvii.zhimasdk.b.a.e.b.b localb = paramw.b();
    paramw = null;
    for (;;)
    {
      this.u += 1;
      localv.o();
      if (!localv.k())
      {
        this.a.a("Cannot retry non-repeatable request");
        if (paramw != null) {
          throw new com.megvii.zhimasdk.b.a.b.l("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", paramw);
        }
        throw new com.megvii.zhimasdk.b.a.b.l("Cannot retry request with a non-repeatable request entity.");
      }
      try
      {
        if (!this.q.c())
        {
          if (!localb.e())
          {
            this.a.a("Reopening the direct connection.");
            this.q.a(localb, parame, this.p);
          }
        }
        else
        {
          if (this.a.a()) {
            this.a.a("Attempt " + this.u + " to execute request");
          }
          return this.f.a(localv, this.q, parame);
        }
        this.a.a("Proxied connection. Need to start over.");
        return null;
      }
      catch (IOException localIOException)
      {
        this.a.a("Closing the connection.");
      }
      try
      {
        this.q.close();
        if (this.h.a(localIOException, localv.n(), parame))
        {
          if (this.a.d()) {
            this.a.d("I/O exception (" + localIOException.getClass().getName() + ") caught when processing request to " + localb + ": " + localIOException.getMessage());
          }
          if (this.a.a()) {
            this.a.a(localIOException.getMessage(), localIOException);
          }
          paramw = localIOException;
          if (!this.a.d()) {
            continue;
          }
          this.a.d("Retrying request to " + localb);
          paramw = localIOException;
          continue;
        }
        if ((localIOException instanceof z))
        {
          paramw = new z(localb.a().e() + " failed to respond");
          paramw.setStackTrace(localIOException.getStackTrace());
          throw paramw;
        }
        throw localIOException;
      }
      catch (IOException paramw)
      {
        for (;;) {}
      }
    }
  }
  
  private void b()
  {
    com.megvii.zhimasdk.b.a.e.o localo = this.q;
    if (localo != null) {
      this.q = null;
    }
    try
    {
      localo.j();
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        try
        {
          localo.i();
          return;
        }
        catch (IOException localIOException1)
        {
          this.a.a("Error releasing connection", localIOException1);
        }
        localIOException2 = localIOException2;
        if (this.a.a()) {
          this.a.a(localIOException2.getMessage(), localIOException2);
        }
      }
    }
  }
  
  protected w a(w paramw, s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.e.b.b localb = paramw.b();
    v localv = paramw.a();
    com.megvii.zhimasdk.b.a.l.e locale = localv.g();
    Object localObject2;
    Object localObject1;
    if (com.megvii.zhimasdk.b.a.b.d.b.b(locale))
    {
      localObject2 = (com.megvii.zhimasdk.b.a.n)parame.a("http.target_host");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localb.a();
      }
      if (((com.megvii.zhimasdk.b.a.n)localObject1).b() >= 0) {
        break label544;
      }
      localObject2 = this.b.a().a((com.megvii.zhimasdk.b.a.n)localObject1);
      localObject1 = new com.megvii.zhimasdk.b.a.n(((com.megvii.zhimasdk.b.a.n)localObject1).a(), ((com.megvii.zhimasdk.b.a.e.c.e)localObject2).a(), ((com.megvii.zhimasdk.b.a.n)localObject1).c());
    }
    label544:
    for (;;)
    {
      boolean bool1 = this.t.a((com.megvii.zhimasdk.b.a.n)localObject1, params, this.l, this.r, parame);
      com.megvii.zhimasdk.b.a.n localn = localb.d();
      localObject2 = localn;
      if (localn == null) {
        localObject2 = localb.a();
      }
      boolean bool2 = this.t.a((com.megvii.zhimasdk.b.a.n)localObject2, params, this.n, this.s, parame);
      if ((bool1) && (this.t.c((com.megvii.zhimasdk.b.a.n)localObject1, params, this.l, this.r, parame))) {}
      do
      {
        do
        {
          return paramw;
        } while ((bool2) && (this.t.c((com.megvii.zhimasdk.b.a.n)localObject2, params, this.n, this.s, parame)));
        if ((!com.megvii.zhimasdk.b.a.b.d.b.a(locale)) || (!this.j.a(localv, params, parame))) {
          break;
        }
        if (this.v >= this.w) {
          throw new com.megvii.zhimasdk.b.a.b.m("Maximum redirects (" + this.w + ") exceeded");
        }
        this.v += 1;
        this.x = null;
        paramw = this.j.b(localv, params, parame);
        paramw.a(localv.m().e());
        localObject1 = paramw.j();
        params = com.megvii.zhimasdk.b.a.b.f.d.b((URI)localObject1);
        if (params == null) {
          throw new ab("Redirect URI does not specify a valid host name: " + localObject1);
        }
        if (!localb.a().equals(params))
        {
          this.a.a("Resetting target auth web_state");
          this.r.a();
          localObject2 = this.s.c();
          if ((localObject2 != null) && (((com.megvii.zhimasdk.b.a.a.c)localObject2).c()))
          {
            this.a.a("Resetting proxy auth web_state");
            this.s.a();
          }
        }
        paramw = a(paramw);
        paramw.a(locale);
        parame = b(params, paramw, parame);
        params = new w(paramw, parame);
        paramw = params;
      } while (!this.a.a());
      this.a.a("Redirecting to '" + localObject1 + "' via " + parame);
      return params;
      return null;
    }
  }
  
  public s a(com.megvii.zhimasdk.b.a.n paramn, com.megvii.zhimasdk.b.a.q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    int i1 = 0;
    parame.a("http.auth.target-scope", this.r);
    parame.a("http.auth.proxy-scope", this.s);
    Object localObject1 = a(paramq);
    ((v)localObject1).a(this.p);
    Object localObject2 = b(paramn, (com.megvii.zhimasdk.b.a.q)localObject1, parame);
    this.x = ((com.megvii.zhimasdk.b.a.n)((v)localObject1).g().a("http.virtual-host"));
    if ((this.x != null) && (this.x.b() == -1)) {
      if (paramn == null) {
        break label485;
      }
    }
    boolean bool;
    Object localObject3;
    for (com.megvii.zhimasdk.b.a.n localn = paramn;; localn = ((com.megvii.zhimasdk.b.a.e.b.b)localObject2).a())
    {
      int i2 = localn.b();
      if (i2 != -1) {
        this.x = new com.megvii.zhimasdk.b.a.n(this.x.a(), i2, this.x.c());
      }
      localObject1 = new w((v)localObject1, (com.megvii.zhimasdk.b.a.e.b.b)localObject2);
      localObject2 = null;
      bool = false;
      localn = paramn;
      paramn = (com.megvii.zhimasdk.b.a.n)localObject2;
      while (i1 == 0)
      {
        for (;;)
        {
          try
          {
            localObject2 = ((w)localObject1).a();
            localb = ((w)localObject1).b();
            localObject3 = parame.a("http.user-token");
            if (this.q == null)
            {
              paramn = this.b.a(localb, localObject3);
              if ((paramq instanceof com.megvii.zhimasdk.b.a.b.c.a)) {
                ((com.megvii.zhimasdk.b.a.b.c.a)paramq).a(paramn);
              }
              l1 = com.megvii.zhimasdk.b.a.b.d.b.c(this.p);
            }
          }
          catch (com.megvii.zhimasdk.b.a.i.c.e paramn)
          {
            com.megvii.zhimasdk.b.a.e.b.b localb;
            paramq = new InterruptedIOException("Connection has been shut down");
            paramq.initCause(paramn);
            throw paramq;
            if ((paramn != null) && (paramn.b() != null) && (paramn.b().f())) {
              continue;
            }
            if (!bool) {
              continue;
            }
            this.q.k();
            a();
            return paramn;
            localURI = ((v)localObject2).j();
            paramn = localn;
            if (!localURI.isAbsolute()) {
              continue;
            }
            paramn = com.megvii.zhimasdk.b.a.b.f.d.b(localURI);
            continue;
            paramn.a(this.p);
            this.f.a(paramn, this.g, parame);
            bool = this.d.a(paramn, parame);
            if (!bool) {
              continue;
            }
            long l1 = this.e.a(paramn, parame);
            if (!this.a.a()) {
              continue;
            }
            if (l1 <= 0L) {
              break label1083;
            }
            localObject2 = "for " + l1 + " " + TimeUnit.MILLISECONDS;
            this.a.a("Connection can be kept alive " + (String)localObject2);
            this.q.a(l1, TimeUnit.MILLISECONDS);
            localObject2 = a((w)localObject1, paramn, parame);
            if (localObject2 != null) {
              continue;
            }
            i1 = 1;
            if (this.q == null) {
              break label1080;
            }
            if (localObject3 != null) {
              break label1073;
            }
            localObject2 = this.o.a(parame);
            parame.a("http.user-token", localObject2);
            if (localObject2 == null) {
              break label1080;
            }
            this.q.a(localObject2);
            break label1080;
            if (!bool) {
              continue;
            }
            com.megvii.zhimasdk.b.a.o.f.a(paramn.b());
            this.q.k();
            if (((w)localObject2).b().equals(((w)localObject1).b())) {
              break label1091;
            }
            a();
            break label1091;
            this.q.close();
            if ((this.s.b().compareTo(com.megvii.zhimasdk.b.a.a.b.b) <= 0) || (this.s.c() == null) || (!this.s.c().c())) {
              continue;
            }
            this.a.a("Resetting proxy auth web_state");
            this.s.a();
            if ((this.r.b().compareTo(com.megvii.zhimasdk.b.a.a.b.b) <= 0) || (this.r.c() == null) || (!this.r.c().c())) {
              continue;
            }
            this.a.a("Resetting target auth web_state");
            this.r.a();
            continue;
          }
          catch (com.megvii.zhimasdk.b.a.m paramn)
          {
            b();
            throw paramn;
            paramn.a(new com.megvii.zhimasdk.b.a.e.a(paramn.b(), this.q, bool));
            return paramn;
          }
          catch (IOException paramn)
          {
            b();
            throw paramn;
          }
          catch (RuntimeException paramn)
          {
            label485:
            b();
            throw paramn;
          }
          try
          {
            this.q = paramn.a(l1, TimeUnit.MILLISECONDS);
            if ((com.megvii.zhimasdk.b.a.l.c.f(this.p)) && (this.q.c()))
            {
              this.a.a("Stale connection check");
              if (this.q.d())
              {
                this.a.a("Stale connection detected");
                this.q.close();
              }
            }
            if ((paramq instanceof com.megvii.zhimasdk.b.a.b.c.a)) {
              ((com.megvii.zhimasdk.b.a.b.c.a)paramq).a(this.q);
            }
          }
          catch (InterruptedException paramn)
          {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
          }
        }
        try
        {
          a((w)localObject1, parame);
          paramn = ((v)localObject2).j().getUserInfo();
          if (paramn != null) {
            this.r.a(new com.megvii.zhimasdk.b.a.i.a.b(), new com.megvii.zhimasdk.b.a.a.r(paramn));
          }
          if (this.x == null) {
            break label604;
          }
          paramn = this.x;
          localn = paramn;
          if (paramn == null) {
            localn = localb.a();
          }
          ((v)localObject2).l();
          a((v)localObject2, localb);
          parame.a("http.target_host", localn);
          parame.a("http.route", localb);
          parame.a("http.connection", this.q);
          this.f.a((com.megvii.zhimasdk.b.a.q)localObject2, this.g, parame);
          paramn = b((w)localObject1, parame);
          if (paramn != null) {
            break label631;
          }
        }
        catch (y paramn)
        {
          if (!this.a.a()) {
            break label552;
          }
          this.a.a(paramn.getMessage());
          paramn = paramn.a();
        }
      }
    }
    for (;;)
    {
      label552:
      label604:
      URI localURI;
      label631:
      label1073:
      localObject2 = localObject3;
      continue;
      label1080:
      break;
      label1083:
      localObject2 = "indefinitely";
      continue;
      label1091:
      localObject1 = localObject2;
    }
  }
  
  protected void a()
  {
    try
    {
      this.q.i();
      this.q = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.a.a("IOException releasing connection", localIOException);
      }
    }
  }
  
  protected void a(com.megvii.zhimasdk.b.a.e.b.b paramb, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.e.b.a locala = new com.megvii.zhimasdk.b.a.e.b.a();
    com.megvii.zhimasdk.b.a.e.b.b localb = this.q.h();
    int i1 = locala.a(paramb, localb);
    switch (i1)
    {
    default: 
      throw new IllegalStateException("Unknown step indicator " + i1 + " from RouteDirector.");
    case 1: 
    case 2: 
      this.q.a(paramb, parame, this.p);
    case 0: 
    case 3: 
    case 4: 
    case 5: 
      while (i1 <= 0)
      {
        return;
        boolean bool = b(paramb, parame);
        this.a.a("Tunnel to target created.");
        this.q.a(bool, this.p);
        continue;
        int i2 = localb.c() - 1;
        bool = a(paramb, i2, parame);
        this.a.a("Tunnel to proxy created.");
        this.q.a(paramb.a(i2), bool, this.p);
        continue;
        this.q.a(parame, this.p);
      }
    }
    throw new com.megvii.zhimasdk.b.a.m("Unable to establish route: planned = " + paramb + "; current = " + localb);
  }
  
  /* Error */
  protected void a(v paramv, com.megvii.zhimasdk.b.a.e.b.b paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 513	com/megvii/zhimasdk/b/a/i/b/v:j	()Ljava/net/URI;
    //   4: astore_3
    //   5: aload_2
    //   6: invokevirtual 380	com/megvii/zhimasdk/b/a/e/b/b:d	()Lcom/megvii/zhimasdk/b/a/n;
    //   9: ifnull +41 -> 50
    //   12: aload_2
    //   13: invokevirtual 287	com/megvii/zhimasdk/b/a/e/b/b:e	()Z
    //   16: ifne +34 -> 50
    //   19: aload_3
    //   20: invokevirtual 578	java/net/URI:isAbsolute	()Z
    //   23: ifne +19 -> 42
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 317	com/megvii/zhimasdk/b/a/e/b/b:a	()Lcom/megvii/zhimasdk/b/a/n;
    //   31: iconst_1
    //   32: invokestatic 693	com/megvii/zhimasdk/b/a/b/f/d:a	(Ljava/net/URI;Lcom/megvii/zhimasdk/b/a/n;Z)Ljava/net/URI;
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 696	com/megvii/zhimasdk/b/a/i/b/v:a	(Ljava/net/URI;)V
    //   41: return
    //   42: aload_3
    //   43: invokestatic 699	com/megvii/zhimasdk/b/a/b/f/d:a	(Ljava/net/URI;)Ljava/net/URI;
    //   46: astore_2
    //   47: goto -11 -> 36
    //   50: aload_3
    //   51: invokevirtual 578	java/net/URI:isAbsolute	()Z
    //   54: ifeq +13 -> 67
    //   57: aload_3
    //   58: aconst_null
    //   59: iconst_1
    //   60: invokestatic 693	com/megvii/zhimasdk/b/a/b/f/d:a	(Ljava/net/URI;Lcom/megvii/zhimasdk/b/a/n;Z)Ljava/net/URI;
    //   63: astore_2
    //   64: goto -28 -> 36
    //   67: aload_3
    //   68: invokestatic 699	com/megvii/zhimasdk/b/a/b/f/d:a	(Ljava/net/URI;)Ljava/net/URI;
    //   71: astore_2
    //   72: goto -36 -> 36
    //   75: astore_2
    //   76: new 424	com/megvii/zhimasdk/b/a/ab
    //   79: dup
    //   80: new 222	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 701
    //   90: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 704	com/megvii/zhimasdk/b/a/i/b/v:h	()Lcom/megvii/zhimasdk/b/a/ae;
    //   97: invokeinterface 707 1 0
    //   102: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aload_2
    //   109: invokespecial 708	com/megvii/zhimasdk/b/a/ab:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	o
    //   0	113	1	paramv	v
    //   0	113	2	paramb	com.megvii.zhimasdk.b.a.e.b.b
    //   4	64	3	localURI	URI
    // Exception table:
    //   from	to	target	type
    //   0	36	75	java/net/URISyntaxException
    //   36	41	75	java/net/URISyntaxException
    //   42	47	75	java/net/URISyntaxException
    //   50	64	75	java/net/URISyntaxException
    //   67	72	75	java/net/URISyntaxException
  }
  
  protected boolean a(com.megvii.zhimasdk.b.a.e.b.b paramb, int paramInt, com.megvii.zhimasdk.b.a.n.e parame)
  {
    throw new com.megvii.zhimasdk.b.a.m("Proxy chains are not supported.");
  }
  
  protected com.megvii.zhimasdk.b.a.e.b.b b(com.megvii.zhimasdk.b.a.n paramn, com.megvii.zhimasdk.b.a.q paramq, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.e.b.d locald = this.c;
    if (paramn != null) {}
    for (;;)
    {
      return locald.a(paramn, paramq, parame);
      paramn = (com.megvii.zhimasdk.b.a.n)paramq.g().a("http.default-host");
    }
  }
  
  protected boolean b(com.megvii.zhimasdk.b.a.e.b.b paramb, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.n localn1 = paramb.d();
    com.megvii.zhimasdk.b.a.n localn2 = paramb.a();
    Object localObject;
    for (;;)
    {
      if (!this.q.c()) {
        this.q.a(paramb, parame, this.p);
      }
      localObject = c(paramb, parame);
      ((com.megvii.zhimasdk.b.a.q)localObject).a(this.p);
      parame.a("http.target_host", localn2);
      parame.a("http.route", paramb);
      parame.a("http.proxy_host", localn1);
      parame.a("http.connection", this.q);
      parame.a("http.request", localObject);
      this.f.a((com.megvii.zhimasdk.b.a.q)localObject, this.g, parame);
      localObject = this.f.a((com.megvii.zhimasdk.b.a.q)localObject, this.q, parame);
      ((s)localObject).a(this.p);
      this.f.a((s)localObject, this.g, parame);
      if (((s)localObject).a().b() < 200) {
        throw new com.megvii.zhimasdk.b.a.m("Unexpected response to CONNECT request: " + ((s)localObject).a());
      }
      if (com.megvii.zhimasdk.b.a.b.d.b.b(this.p))
      {
        if ((!this.t.a(localn1, (s)localObject, this.n, this.s, parame)) || (!this.t.c(localn1, (s)localObject, this.n, this.s, parame))) {
          break;
        }
        if (this.d.a((s)localObject, parame))
        {
          this.a.a("Connection kept alive");
          com.megvii.zhimasdk.b.a.o.f.a(((s)localObject).b());
        }
        else
        {
          this.q.close();
        }
      }
    }
    if (((s)localObject).a().b() > 299)
    {
      paramb = ((s)localObject).b();
      if (paramb != null) {
        ((s)localObject).a(new com.megvii.zhimasdk.b.a.g.c(paramb));
      }
      this.q.close();
      throw new y("CONNECT refused by proxy: " + ((s)localObject).a(), (s)localObject);
    }
    this.q.k();
    return false;
  }
  
  protected com.megvii.zhimasdk.b.a.q c(com.megvii.zhimasdk.b.a.e.b.b paramb, com.megvii.zhimasdk.b.a.n.e parame)
  {
    parame = paramb.a();
    paramb = parame.a();
    int i2 = parame.b();
    int i1 = i2;
    if (i2 < 0) {
      i1 = this.b.a().a(parame.c()).a();
    }
    parame = new StringBuilder(paramb.length() + 6);
    parame.append(paramb);
    parame.append(':');
    parame.append(Integer.toString(i1));
    return new com.megvii.zhimasdk.b.a.k.g("CONNECT", parame.toString(), com.megvii.zhimasdk.b.a.l.f.b(this.p));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */