package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class l
  implements Serializable
{
  private static final long a = 1L;
  private List<String> b = new ArrayList();
  private String c;
  private long d;
  private long e;
  private String f;
  
  public l(List<String> paramList, long paramLong1, String paramString, long paramLong2)
  {
    this.b = paramList;
    this.d = paramLong1;
    this.c = paramString;
    this.e = paramLong2;
    f();
  }
  
  private void f()
  {
    this.f = q.a(this.e);
  }
  
  public List<String> a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public long c()
  {
    return this.d;
  }
  
  public long d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */