package com.megvii.zhimasdk.b.a.b.a;

import com.megvii.zhimasdk.b.a.n;
import java.net.InetAddress;
import java.util.Collection;

public class a
  implements Cloneable
{
  public static final a a = new a().a();
  private final boolean b;
  private final n c;
  private final InetAddress d;
  private final boolean e;
  private final String f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final int j;
  private final boolean k;
  private final Collection<String> l;
  private final Collection<String> m;
  private final int n;
  private final int o;
  private final int p;
  
  a(boolean paramBoolean1, n paramn, InetAddress paramInetAddress, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, boolean paramBoolean6, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramBoolean1;
    this.c = paramn;
    this.d = paramInetAddress;
    this.e = paramBoolean2;
    this.f = paramString;
    this.g = paramBoolean3;
    this.h = paramBoolean4;
    this.i = paramBoolean5;
    this.j = paramInt1;
    this.k = paramBoolean6;
    this.l = paramCollection1;
    this.m = paramCollection2;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
  }
  
  public static a g()
  {
    return new a();
  }
  
  public String a()
  {
    return this.f;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean c()
  {
    return this.i;
  }
  
  public Collection<String> d()
  {
    return this.l;
  }
  
  public Collection<String> e()
  {
    return this.m;
  }
  
  protected a f()
  {
    return (a)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", expectContinueEnabled=").append(this.b);
    localStringBuilder.append(", proxy=").append(this.c);
    localStringBuilder.append(", localAddress=").append(this.d);
    localStringBuilder.append(", staleConnectionCheckEnabled=").append(this.e);
    localStringBuilder.append(", cookieSpec=").append(this.f);
    localStringBuilder.append(", redirectsEnabled=").append(this.g);
    localStringBuilder.append(", relativeRedirectsAllowed=").append(this.h);
    localStringBuilder.append(", maxRedirects=").append(this.j);
    localStringBuilder.append(", circularRedirectsAllowed=").append(this.i);
    localStringBuilder.append(", authenticationEnabled=").append(this.k);
    localStringBuilder.append(", targetPreferredAuthSchemes=").append(this.l);
    localStringBuilder.append(", proxyPreferredAuthSchemes=").append(this.m);
    localStringBuilder.append(", connectionRequestTimeout=").append(this.n);
    localStringBuilder.append(", connectTimeout=").append(this.o);
    localStringBuilder.append(", socketTimeout=").append(this.p);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    private boolean a;
    private n b;
    private InetAddress c;
    private boolean d = true;
    private String e;
    private boolean f = true;
    private boolean g = true;
    private boolean h;
    private int i = 50;
    private boolean j = true;
    private Collection<String> k;
    private Collection<String> l;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    
    public a a(int paramInt)
    {
      this.i = paramInt;
      return this;
    }
    
    public a a(n paramn)
    {
      this.b = paramn;
      return this;
    }
    
    public a a(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a a(InetAddress paramInetAddress)
    {
      this.c = paramInetAddress;
      return this;
    }
    
    public a a(Collection<String> paramCollection)
    {
      this.k = paramCollection;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }
    
    public a a()
    {
      return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }
    
    public a b(int paramInt)
    {
      this.m = paramInt;
      return this;
    }
    
    public a b(Collection<String> paramCollection)
    {
      this.l = paramCollection;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.n = paramInt;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.o = paramInt;
      return this;
    }
    
    public a d(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }
    
    public a e(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }
    
    public a f(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */