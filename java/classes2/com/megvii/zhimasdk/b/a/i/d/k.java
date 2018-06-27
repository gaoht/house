package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.f.b;
import com.megvii.zhimasdk.b.a.f.h;
import com.megvii.zhimasdk.b.a.f.l;
import com.megvii.zhimasdk.b.a.f.n;
import com.megvii.zhimasdk.b.a.k.u;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.Iterator;
import java.util.List;

public class k
  implements h
{
  private final String[] a;
  private final boolean b;
  private ae c;
  private x d;
  private m e;
  
  public k()
  {
    this(null, false);
  }
  
  public k(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {}
    for (paramArrayOfString = null;; paramArrayOfString = (String[])paramArrayOfString.clone())
    {
      this.a = paramArrayOfString;
      this.b = paramBoolean;
      return;
    }
  }
  
  private ae c()
  {
    if (this.c == null) {
      this.c = new ae(this.a, this.b);
    }
    return this.c;
  }
  
  private x d()
  {
    if (this.d == null) {
      this.d = new x(this.a, this.b);
    }
    return this.d;
  }
  
  private m e()
  {
    if (this.e == null) {
      this.e = new m(this.a);
    }
    return this.e;
  }
  
  public int a()
  {
    return c().a();
  }
  
  public List<b> a(com.megvii.zhimasdk.b.a.e parame, com.megvii.zhimasdk.b.a.f.e parame1)
  {
    a.a(parame, "Header");
    a.a(parame1, "Cookie origin");
    Object localObject = parame.e();
    int m = localObject.length;
    int i = 0;
    int j = 0;
    int k = 0;
    t localt;
    while (i < m)
    {
      localt = localObject[i];
      if (localt.a("version") != null) {
        k = 1;
      }
      if (localt.a("expires") != null) {
        j = 1;
      }
      i += 1;
    }
    if ((j != 0) || (k == 0))
    {
      localt = t.a;
      if ((parame instanceof com.megvii.zhimasdk.b.a.d)) {
        localObject = ((com.megvii.zhimasdk.b.a.d)parame).a();
      }
      for (parame = new u(((com.megvii.zhimasdk.b.a.d)parame).b(), ((com.megvii.zhimasdk.b.a.o.d)localObject).c());; parame = new u(0, ((com.megvii.zhimasdk.b.a.o.d)localObject).c()))
      {
        parame = localt.a((com.megvii.zhimasdk.b.a.o.d)localObject, parame);
        return e().a(new f[] { parame }, parame1);
        parame = parame.d();
        if (parame == null) {
          throw new l("Header value is null");
        }
        localObject = new com.megvii.zhimasdk.b.a.o.d(parame.length());
        ((com.megvii.zhimasdk.b.a.o.d)localObject).a(parame);
      }
    }
    if ("Set-Cookie2".equals(parame.c())) {
      return c().a((f[])localObject, parame1);
    }
    return d().a((f[])localObject, parame1);
  }
  
  public List<com.megvii.zhimasdk.b.a.e> a(List<b> paramList)
  {
    a.a(paramList, "List of cookies");
    Iterator localIterator = paramList.iterator();
    int i = Integer.MAX_VALUE;
    int j = 1;
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (!(localb instanceof n)) {
        j = 0;
      }
      if (localb.h() >= i) {
        break label109;
      }
      i = localb.h();
    }
    label109:
    for (;;)
    {
      break;
      if (i > 0)
      {
        if (j != 0) {
          return c().a(paramList);
        }
        return d().a(paramList);
      }
      return e().a(paramList);
    }
  }
  
  public void a(b paramb, com.megvii.zhimasdk.b.a.f.e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    if (paramb.h() > 0)
    {
      if ((paramb instanceof n))
      {
        c().a(paramb, parame);
        return;
      }
      d().a(paramb, parame);
      return;
    }
    e().a(paramb, parame);
  }
  
  public com.megvii.zhimasdk.b.a.e b()
  {
    return c().b();
  }
  
  public boolean b(b paramb, com.megvii.zhimasdk.b.a.f.e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    if (paramb.h() > 0)
    {
      if ((paramb instanceof n)) {
        return c().b(paramb, parame);
      }
      return d().b(paramb, parame);
    }
    return e().b(paramb, parame);
  }
  
  public String toString()
  {
    return "best-match";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */