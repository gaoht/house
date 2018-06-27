package com.megvii.zhimasdk.b.a.e.b;

import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.g;
import java.net.InetAddress;

public final class f
  implements e, Cloneable
{
  private final n a;
  private final InetAddress b;
  private boolean c;
  private n[] d;
  private e.b e;
  private e.a f;
  private boolean g;
  
  public f(b paramb)
  {
    this(paramb.a(), paramb.b());
  }
  
  public f(n paramn, InetAddress paramInetAddress)
  {
    a.a(paramn, "Target host");
    this.a = paramn;
    this.b = paramInetAddress;
    this.e = e.b.a;
    this.f = e.a.a;
  }
  
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
      return this.d[paramInt];
    }
    return this.a;
  }
  
  public final void a(n paramn, boolean paramBoolean)
  {
    a.a(paramn, "Proxy host");
    if (!this.c) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Already connected");
      this.c = true;
      this.d = new n[] { paramn };
      this.g = paramBoolean;
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!this.c) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Already connected");
      this.c = true;
      this.g = paramBoolean;
      return;
    }
  }
  
  public final InetAddress b()
  {
    return this.b;
  }
  
  public final void b(n paramn, boolean paramBoolean)
  {
    a.a(paramn, "Proxy host");
    com.megvii.zhimasdk.b.a.o.b.a(this.c, "No tunnel unless connected");
    com.megvii.zhimasdk.b.a.o.b.a(this.d, "No tunnel without proxy");
    n[] arrayOfn = new n[this.d.length + 1];
    System.arraycopy(this.d, 0, arrayOfn, 0, this.d.length);
    arrayOfn[(arrayOfn.length - 1)] = paramn;
    this.d = arrayOfn;
    this.g = paramBoolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    com.megvii.zhimasdk.b.a.o.b.a(this.c, "No tunnel unless connected");
    com.megvii.zhimasdk.b.a.o.b.a(this.d, "No tunnel without proxy");
    this.e = e.b.b;
    this.g = paramBoolean;
  }
  
  public final int c()
  {
    int i = 0;
    if (this.c)
    {
      if (this.d == null) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return this.d.length + 1;
  }
  
  public final void c(boolean paramBoolean)
  {
    com.megvii.zhimasdk.b.a.o.b.a(this.c, "No layered protocol unless connected");
    this.f = e.a.b;
    this.g = paramBoolean;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final n d()
  {
    if (this.d == null) {
      return null;
    }
    return this.d[0];
  }
  
  public final boolean e()
  {
    return this.e == e.b.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
    } while ((this.c == ((f)paramObject).c) && (this.g == ((f)paramObject).g) && (this.e == ((f)paramObject).e) && (this.f == ((f)paramObject).f) && (g.a(this.a, ((f)paramObject).a)) && (g.a(this.b, ((f)paramObject).b)) && (g.a(this.d, ((f)paramObject).d)));
    return false;
  }
  
  public final boolean f()
  {
    return this.f == e.a.b;
  }
  
  public final boolean g()
  {
    return this.g;
  }
  
  public void h()
  {
    this.c = false;
    this.d = null;
    this.e = e.b.a;
    this.f = e.a.a;
    this.g = false;
  }
  
  public final int hashCode()
  {
    int i = g.a(g.a(17, this.a), this.b);
    int k = i;
    if (this.d != null)
    {
      n[] arrayOfn = this.d;
      int m = arrayOfn.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i = g.a(i, arrayOfn[j]);
        j += 1;
      }
    }
    return g.a(g.a(g.a(g.a(k, this.c), this.g), this.e), this.f);
  }
  
  public final boolean i()
  {
    return this.c;
  }
  
  public final b j()
  {
    if (!this.c) {
      return null;
    }
    return new b(this.a, this.b, this.d, this.g, this.e, this.f);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(c() * 30 + 50);
    localStringBuilder.append("RouteTracker[");
    if (this.b != null)
    {
      localStringBuilder.append(this.b);
      localStringBuilder.append("->");
    }
    localStringBuilder.append('{');
    if (this.c) {
      localStringBuilder.append('c');
    }
    if (this.e == e.b.b) {
      localStringBuilder.append('t');
    }
    if (this.f == e.a.b) {
      localStringBuilder.append('l');
    }
    if (this.g) {
      localStringBuilder.append('s');
    }
    localStringBuilder.append("}->");
    if (this.d != null)
    {
      n[] arrayOfn = this.d;
      int j = arrayOfn.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfn[i]);
        localStringBuilder.append("->");
        i += 1;
      }
    }
    localStringBuilder.append(this.a);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */