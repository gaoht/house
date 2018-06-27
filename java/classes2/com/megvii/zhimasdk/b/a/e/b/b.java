package com.megvii.zhimasdk.b.a.e.b;

import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
  implements e, Cloneable
{
  private final n a;
  private final InetAddress b;
  private final List<n> c;
  private final e.b d;
  private final e.a e;
  private final boolean f;
  
  public b(n paramn)
  {
    this(paramn, null, Collections.emptyList(), false, e.b.a, e.a.a);
  }
  
  public b(n paramn1, InetAddress paramInetAddress, n paramn2, boolean paramBoolean) {}
  
  private b(n paramn, InetAddress paramInetAddress, List<n> paramList, boolean paramBoolean, e.b paramb, e.a parama)
  {
    a.a(paramn, "Target host");
    this.a = paramn;
    this.b = paramInetAddress;
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.c = new ArrayList(paramList);
      if (paramb == e.b.b)
      {
        if (this.c == null) {
          break label108;
        }
        bool = true;
        label64:
        a.a(bool, "Proxy required if tunnelled");
      }
      this.f = paramBoolean;
      if (paramb == null) {
        break label114;
      }
      label82:
      this.d = paramb;
      if (parama == null) {
        break label122;
      }
    }
    for (;;)
    {
      this.e = parama;
      return;
      this.c = null;
      break;
      label108:
      bool = false;
      break label64;
      label114:
      paramb = e.b.a;
      break label82;
      label122:
      parama = e.a.a;
    }
  }
  
  public b(n paramn, InetAddress paramInetAddress, boolean paramBoolean)
  {
    this(paramn, paramInetAddress, Collections.emptyList(), paramBoolean, e.b.a, e.a.a);
  }
  
  public b(n paramn, InetAddress paramInetAddress, n[] paramArrayOfn, boolean paramBoolean, e.b paramb, e.a parama) {}
  
  public final n a()
  {
    return this.a;
  }
  
  public final n a(int paramInt)
  {
    a.b(paramInt, "Hop index");
    int i = c();
    if (paramInt < i) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(bool, "Hop index exceeds tracked route length");
      if (paramInt >= i - 1) {
        break;
      }
      return (n)this.c.get(paramInt);
    }
    return this.a;
  }
  
  public final InetAddress b()
  {
    return this.b;
  }
  
  public final int c()
  {
    if (this.c != null) {
      return this.c.size() + 1;
    }
    return 1;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final n d()
  {
    if ((this.c != null) && (!this.c.isEmpty())) {
      return (n)this.c.get(0);
    }
    return null;
  }
  
  public final boolean e()
  {
    return this.d == e.b.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        break;
      }
      paramObject = (b)paramObject;
    } while ((this.f == ((b)paramObject).f) && (this.d == ((b)paramObject).d) && (this.e == ((b)paramObject).e) && (g.a(this.a, ((b)paramObject).a)) && (g.a(this.b, ((b)paramObject).b)) && (g.a(this.c, ((b)paramObject).c)));
    return false;
    return false;
  }
  
  public final boolean f()
  {
    return this.e == e.a.b;
  }
  
  public final boolean g()
  {
    return this.f;
  }
  
  public final int hashCode()
  {
    int i = g.a(g.a(17, this.a), this.b);
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = g.a(i, (n)localIterator.next());
      }
    }
    int j = i;
    return g.a(g.a(g.a(j, this.f), this.d), this.e);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(c() * 30 + 50);
    if (this.b != null)
    {
      localStringBuilder.append(this.b);
      localStringBuilder.append("->");
    }
    localStringBuilder.append('{');
    if (this.d == e.b.b) {
      localStringBuilder.append('t');
    }
    if (this.e == e.a.b) {
      localStringBuilder.append('l');
    }
    if (this.f) {
      localStringBuilder.append('s');
    }
    localStringBuilder.append("}->");
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((n)localIterator.next());
        localStringBuilder.append("->");
      }
    }
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */