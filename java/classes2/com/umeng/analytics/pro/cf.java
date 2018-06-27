package com.umeng.analytics.pro;

public class cf
  extends cm
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  private static final dk j = new dk("TApplicationException");
  private static final da k = new da("message", (byte)11, (short)1);
  private static final da l = new da("type", (byte)8, (short)2);
  private static final long m = 1L;
  protected int i = 0;
  
  public cf() {}
  
  public cf(int paramInt)
  {
    this.i = paramInt;
  }
  
  public cf(int paramInt, String paramString)
  {
    super(paramString);
    this.i = paramInt;
  }
  
  public cf(String paramString)
  {
    super(paramString);
  }
  
  public static cf a(df paramdf)
    throws cm
  {
    paramdf.j();
    String str = null;
    int n = 0;
    da localda = paramdf.l();
    if (localda.b == 0)
    {
      paramdf.k();
      return new cf(n, str);
    }
    switch (localda.c)
    {
    default: 
      di.a(paramdf, localda.b);
    }
    for (;;)
    {
      paramdf.m();
      break;
      if (localda.b == 11)
      {
        str = paramdf.z();
      }
      else
      {
        di.a(paramdf, localda.b);
        continue;
        if (localda.b == 8) {
          n = paramdf.w();
        } else {
          di.a(paramdf, localda.b);
        }
      }
    }
  }
  
  public int a()
  {
    return this.i;
  }
  
  public void b(df paramdf)
    throws cm
  {
    paramdf.a(j);
    if (getMessage() != null)
    {
      paramdf.a(k);
      paramdf.a(getMessage());
      paramdf.c();
    }
    paramdf.a(l);
    paramdf.a(this.i);
    paramdf.c();
    paramdf.d();
    paramdf.b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */