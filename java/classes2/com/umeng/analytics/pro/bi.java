package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;

public class bi
  implements az
{
  private static bi l = null;
  private final long a = 1296000000L;
  private final long b = 129600000L;
  private final int c = 1800000;
  private final int d = 10000;
  private cc e;
  private be f;
  private long g = 1296000000L;
  private int h = 10000;
  private long i = 0L;
  private long j = 0L;
  private Context k;
  
  private bi(Context paramContext, be parambe)
  {
    this.k = paramContext;
    this.e = cc.a(paramContext);
    this.f = parambe;
  }
  
  public static bi a(Context paramContext, be parambe)
  {
    try
    {
      if (l == null)
      {
        l = new bi(paramContext, parambe);
        l.a(af.a(paramContext).b());
      }
      paramContext = l;
      return paramContext;
    }
    finally {}
  }
  
  public void a(af.a parama)
  {
    this.g = parama.a(1296000000L);
    int m = parama.b(0);
    if (m == 0)
    {
      if ((AnalyticsConfig.sLatentWindow <= 0) || (AnalyticsConfig.sLatentWindow > 1800000))
      {
        this.h = 10000;
        return;
      }
      this.h = AnalyticsConfig.sLatentWindow;
      return;
    }
    this.h = m;
  }
  
  public boolean a()
  {
    if (this.e.h()) {}
    long l1;
    do
    {
      do
      {
        return false;
      } while (this.f.f());
      l1 = System.currentTimeMillis() - this.f.m();
      if (l1 > this.g)
      {
        String str = aa.a(this.k);
        this.i = bt.a(this.h, str);
        this.j = l1;
        return true;
      }
    } while (l1 <= 129600000L);
    this.i = 0L;
    this.j = l1;
    return true;
  }
  
  public long b()
  {
    return this.i;
  }
  
  public long c()
  {
    return this.j;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */