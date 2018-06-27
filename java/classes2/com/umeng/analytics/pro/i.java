package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class i
  implements Serializable
{
  private static final long a = 1L;
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private String g = null;
  
  public i() {}
  
  public i(List<String> paramList1, long paramLong1, long paramLong2, long paramLong3, List<String> paramList2, String paramString)
  {
    this.b = paramList1;
    this.c = paramList2;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramLong3;
    this.g = paramString;
  }
  
  public String a()
  {
    return d.a(this.b);
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(f paramf, l paraml)
  {
    a(paraml.b());
    this.f += 1L;
    this.e += paraml.c();
    this.d += paraml.d();
    paramf.a(this, false);
  }
  
  public void a(l paraml)
  {
    this.f = 1L;
    this.b = paraml.a();
    a(paraml.b());
    this.e = paraml.c();
    this.d = System.currentTimeMillis();
    this.g = q.a(System.currentTimeMillis());
  }
  
  public void a(String paramString)
  {
    int i = 0;
    try
    {
      if (this.c.size() < n.a().b()) {
        this.c.add(paramString);
      }
      while (this.c.size() > n.a().b())
      {
        while (i < this.c.size() - n.a().b())
        {
          this.c.remove(this.c.get(0));
          i += 1;
        }
        this.c.remove(this.c.get(0));
        this.c.add(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(List<String> paramList)
  {
    this.b = paramList;
  }
  
  public List<String> b()
  {
    return this.b;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public void b(List<String> paramList)
  {
    this.c = paramList;
  }
  
  public String c()
  {
    return d.a(this.c);
  }
  
  public void c(long paramLong)
  {
    this.f = paramLong;
  }
  
  public List<String> d()
  {
    return this.c;
  }
  
  public long e()
  {
    return this.d;
  }
  
  public long f()
  {
    return this.e;
  }
  
  public long g()
  {
    return this.f;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[key: ").append(this.b).append("] [label: ").append(this.c).append("][ totalTimeStamp").append(this.g).append("][ value").append(this.e).append("][ count").append(this.f).append("][ timeWindowNum").append(this.g).append("]");
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */