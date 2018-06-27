package com.mato.sdk.e.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class k
{
  private final String a = com.mato.sdk.b.g.b("");
  private final Context b;
  private final i c;
  private final c d;
  private e e;
  
  public k(Context paramContext, i parami)
  {
    this.b = paramContext;
    this.c = parami;
    this.d = c.a(paramContext, 1);
  }
  
  private void a(g paramg)
  {
    if ((paramg != null) && (paramg.a(this.d.b))) {
      new l(paramg.c).a(this.d.b, this.d.c, this.d.d);
    }
    if (this.c != null)
    {
      paramg.u = this.d;
      this.c.c(paramg);
    }
  }
  
  private void a(String paramString)
  {
    new l(paramString).a(this.d.b, this.d.c, this.d.d);
  }
  
  private static boolean c()
  {
    return com.mato.sdk.proxy.a.b().g() == null;
  }
  
  private static com.mato.sdk.d.h d()
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add("www.baidu.com");
    localArrayList1.add("www.sina.com.cn");
    localArrayList1.add("www.qq.com");
    localArrayList1.add("www.163.com");
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("http://www.baidu.com");
    localArrayList2.add("http://www.sina.com.cn");
    localArrayList2.add("http://www.qq.com");
    localArrayList2.add("http://www.163.com");
    return new com.mato.sdk.d.h(localArrayList1, localArrayList2);
  }
  
  private void e()
  {
    Object localObject2 = com.mato.sdk.proxy.a.b().i().G();
    Object localObject1 = localObject2;
    if (!com.mato.sdk.c.a.e.a((com.mato.sdk.d.h)localObject2))
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add("www.baidu.com");
      ((List)localObject1).add("www.sina.com.cn");
      ((List)localObject1).add("www.qq.com");
      ((List)localObject1).add("www.163.com");
      localObject2 = new ArrayList();
      ((List)localObject2).add("http://www.baidu.com");
      ((List)localObject2).add("http://www.sina.com.cn");
      ((List)localObject2).add("http://www.qq.com");
      ((List)localObject2).add("http://www.163.com");
      localObject1 = new com.mato.sdk.d.h((List)localObject1, (List)localObject2);
    }
    this.e = new e(this.b, new i()
    {
      public final void a(g paramAnonymousg)
      {
        if (k.a(k.this) != null) {
          k.a(k.this).a(paramAnonymousg);
        }
      }
      
      public final void b(g paramAnonymousg)
      {
        if (k.a(k.this) != null) {
          k.a(k.this).b(paramAnonymousg);
        }
      }
      
      public final void c(g paramAnonymousg)
      {
        k.a(k.this, paramAnonymousg);
      }
      
      public final void d(g paramAnonymousg)
      {
        if (k.a(k.this) != null) {
          k.a(k.this).d(paramAnonymousg);
        }
      }
    }, (com.mato.sdk.d.h)localObject1, this.d);
    this.e.start();
  }
  
  private void f()
  {
    new Thread(new Runnable()
    {
      public final void run()
      {
        g localg = new g();
        localg.a = false;
        try
        {
          localg.l = k.b(k.this);
          localg.k = com.mato.sdk.g.i.f(k.c(k.this));
          localg.f = com.mato.sdk.b.h.a(k.c(k.this), null).a();
          localg.e = com.mato.sdk.g.i.a(k.c(k.this), "unknown");
          localg.d = com.mato.sdk.g.i.b(k.c(k.this), "unknown");
          localg.h = com.mato.sdk.g.i.h(k.c(k.this));
          localg.i = e.c();
          localg.g = e.d();
          localg.a(k.d(k.this).b);
          new l(localg.c).b(k.d(k.this).b, "wspx-diagnose-one", "netdiagnosis.gzip");
          if (k.a(k.this) != null)
          {
            localg.u = k.d(k.this);
            k.a(k.this).c(localg);
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          do
          {
            localThrowable = localThrowable;
          } while (k.a(k.this) == null);
          localg.u = k.d(k.this);
          k.a(k.this).c(localg);
          return;
        }
        finally
        {
          localObject = finally;
          if (k.a(k.this) != null)
          {
            localg.u = k.d(k.this);
            k.a(k.this).c(localg);
          }
          throw ((Throwable)localObject);
        }
      }
    }).start();
  }
  
  private String g()
  {
    int i = com.mato.sdk.proxy.a.b().n();
    if (com.mato.sdk.g.i.a(i, 8)) {
      return com.mato.sdk.proxy.g.a(this.b).b("start_up_fail", "");
    }
    if (com.mato.sdk.g.i.a(i, 2)) {
      return "No network";
    }
    return "Unknown";
  }
  
  public final void a()
  {
    com.mato.sdk.b.a.a();
    com.mato.sdk.b.a.d();
    if (com.mato.sdk.proxy.a.b().g() == null) {}
    for (int i = 1; i != 0; i = 0)
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          g localg = new g();
          localg.a = false;
          try
          {
            localg.l = k.b(k.this);
            localg.k = com.mato.sdk.g.i.f(k.c(k.this));
            localg.f = com.mato.sdk.b.h.a(k.c(k.this), null).a();
            localg.e = com.mato.sdk.g.i.a(k.c(k.this), "unknown");
            localg.d = com.mato.sdk.g.i.b(k.c(k.this), "unknown");
            localg.h = com.mato.sdk.g.i.h(k.c(k.this));
            localg.i = e.c();
            localg.g = e.d();
            localg.a(k.d(k.this).b);
            new l(localg.c).b(k.d(k.this).b, "wspx-diagnose-one", "netdiagnosis.gzip");
            if (k.a(k.this) != null)
            {
              localg.u = k.d(k.this);
              k.a(k.this).c(localg);
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            do
            {
              localThrowable = localThrowable;
            } while (k.a(k.this) == null);
            localg.u = k.d(k.this);
            k.a(k.this).c(localg);
            return;
          }
          finally
          {
            localObject = finally;
            if (k.a(k.this) != null)
            {
              localg.u = k.d(k.this);
              k.a(k.this).c(localg);
            }
            throw ((Throwable)localObject);
          }
        }
      }).start();
      return;
    }
    Object localObject2 = com.mato.sdk.proxy.a.b().i().G();
    Object localObject1 = localObject2;
    if (!com.mato.sdk.c.a.e.a((com.mato.sdk.d.h)localObject2))
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add("www.baidu.com");
      ((List)localObject1).add("www.sina.com.cn");
      ((List)localObject1).add("www.qq.com");
      ((List)localObject1).add("www.163.com");
      localObject2 = new ArrayList();
      ((List)localObject2).add("http://www.baidu.com");
      ((List)localObject2).add("http://www.sina.com.cn");
      ((List)localObject2).add("http://www.qq.com");
      ((List)localObject2).add("http://www.163.com");
      localObject1 = new com.mato.sdk.d.h((List)localObject1, (List)localObject2);
    }
    this.e = new e(this.b, new i()
    {
      public final void a(g paramAnonymousg)
      {
        if (k.a(k.this) != null) {
          k.a(k.this).a(paramAnonymousg);
        }
      }
      
      public final void b(g paramAnonymousg)
      {
        if (k.a(k.this) != null) {
          k.a(k.this).b(paramAnonymousg);
        }
      }
      
      public final void c(g paramAnonymousg)
      {
        k.a(k.this, paramAnonymousg);
      }
      
      public final void d(g paramAnonymousg)
      {
        if (k.a(k.this) != null) {
          k.a(k.this).d(paramAnonymousg);
        }
      }
    }, (com.mato.sdk.d.h)localObject1, this.d);
    this.e.start();
  }
  
  public final void b()
  {
    if (this.e != null) {
      this.e.a();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */