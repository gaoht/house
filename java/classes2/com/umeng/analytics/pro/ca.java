package com.umeng.analytics.pro;

import android.content.Context;

public class ca
{
  public static final int a = 0;
  public static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 8;
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return false;
    }
    return true;
  }
  
  public static class a
    extends ca.h
  {
    private final long a = 15000L;
    private be b;
    
    public a(be parambe)
    {
      this.b = parambe;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b.c >= 15000L;
    }
  }
  
  public static class b
    extends ca.h
  {
    private bh a;
    private be b;
    
    public b(be parambe, bh parambh)
    {
      this.b = parambe;
      this.a = parambh;
    }
    
    public boolean a()
    {
      return this.a.d();
    }
    
    public boolean a(boolean paramBoolean)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.a.b();
      return l1 - this.b.c >= l2;
    }
  }
  
  public static class c
    extends ca.h
  {
    private long a;
    private long b = 0L;
    
    public c(int paramInt)
    {
      this.a = paramInt;
      this.b = System.currentTimeMillis();
    }
    
    public boolean a()
    {
      return System.currentTimeMillis() - this.b < this.a;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b >= this.a;
    }
  }
  
  public static class d
    extends ca.h
  {
    public boolean a(boolean paramBoolean)
    {
      return paramBoolean;
    }
  }
  
  public static class e
    extends ca.h
  {
    private static long a = 90000L;
    private static long b = 86400000L;
    private long c;
    private be d;
    
    public e(be parambe, long paramLong)
    {
      this.d = parambe;
      a(paramLong);
    }
    
    public static boolean a(int paramInt)
    {
      return paramInt >= a;
    }
    
    public void a(long paramLong)
    {
      if ((paramLong >= a) && (paramLong <= b))
      {
        this.c = paramLong;
        return;
      }
      this.c = a;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.d.c >= this.c;
    }
    
    public long b()
    {
      return this.c;
    }
  }
  
  public static class f
    extends ca.h
  {
    private long a = 86400000L;
    private be b;
    
    public f(be parambe)
    {
      this.b = parambe;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b.c >= this.a;
    }
  }
  
  public static class g
    extends ca.h
  {
    public boolean a(boolean paramBoolean)
    {
      return true;
    }
  }
  
  public static class h
  {
    public boolean a()
    {
      return true;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return true;
    }
  }
  
  public static class i
    extends ca.h
  {
    private Context a = null;
    
    public i(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return bv.k(this.a);
    }
  }
  
  public static class j
    extends ca.h
  {
    private final long a = 10800000L;
    private be b;
    
    public j(be parambe)
    {
      this.b = parambe;
    }
    
    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b.c >= 10800000L;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */