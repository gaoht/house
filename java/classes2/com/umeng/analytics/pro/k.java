package com.umeng.analytics.pro;

import java.io.Serializable;

public class k
  implements Serializable
{
  private static final long a = 1L;
  private String b = null;
  private long c = 0L;
  private long d = 0L;
  private String e = null;
  
  private k() {}
  
  public k(String paramString, long paramLong1, long paramLong2)
  {
    this(paramString, paramLong1, paramLong2, null);
  }
  
  public k(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    this.b = paramString1;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramString2;
  }
  
  public k a()
  {
    this.d += 1L;
    return this;
  }
  
  public k a(k paramk)
  {
    this.d = (paramk.e() + this.d);
    this.c = paramk.d();
    return this;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public long d()
  {
    return this.c;
  }
  
  public long e()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */