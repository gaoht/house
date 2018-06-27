package com.mato.sdk.e.b.a;

public class a
{
  private static final int A = 14;
  private static final int B = 15;
  private static final int C = 19;
  private static final int D = 20;
  private static final int E = 23;
  private static final int F = 30;
  private static final int o = 0;
  private static final int p = 1;
  private static final int q = 3;
  private static final int r = 4;
  private static final int s = 5;
  private static final int t = 6;
  private static final int u = 7;
  private static final int v = 8;
  private static final int w = 9;
  private static final int x = 10;
  private static final int y = 11;
  private static final int z = 13;
  private String G;
  private int H;
  private int I;
  private String J;
  public long a = 0L;
  public String b = "";
  public int c = 200;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public String j = "";
  public String k = "";
  public int l = 0;
  public String m = "";
  public String n = "";
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("\""))
    {
      str = paramString;
      if (paramString.endsWith("\""))
      {
        int i1 = "\"".length();
        str = paramString.substring(i1, paramString.length() - i1);
      }
    }
    return str;
  }
  
  private static int c(String paramString)
  {
    return Integer.valueOf(paramString).intValue();
  }
  
  private long d()
  {
    return this.d + this.e + this.f + this.g + this.h;
  }
  
  public final boolean a()
  {
    return (this.b.contains("S")) || (this.b.contains("s"));
  }
  
  public final boolean a(String paramString)
  {
    try
    {
      paramString = paramString.split("\t");
      if ((paramString != null) && (paramString.length >= 24))
      {
        this.a = ((Double.valueOf(paramString[0]).doubleValue() * 1000.0D));
        this.b = paramString[1];
        b(paramString[3]);
        this.c = Integer.valueOf(paramString[5]).intValue();
        this.j = b(paramString[19]);
        this.m = b(paramString[20]);
        this.k = b(paramString[4]);
        this.n = b(paramString[30]);
        this.d = Integer.valueOf(paramString[6]).intValue();
        this.e = Integer.valueOf(paramString[7]).intValue();
        this.f = Integer.valueOf(paramString[8]).intValue();
        this.g = Integer.valueOf(paramString[9]).intValue();
        this.h = Integer.valueOf(paramString[10]).intValue();
        Integer.valueOf(paramString[11]).intValue();
        Integer.valueOf(paramString[23]).intValue();
        this.l = Integer.valueOf(paramString[13]).intValue();
        int i1 = Integer.valueOf(paramString[14]).intValue();
        int i2 = Integer.valueOf(paramString[15]).intValue();
        if (i2 <= 0)
        {
          this.i = i1;
          return true;
        }
        this.i = i2;
        return true;
      }
      return false;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public final boolean b()
  {
    return (this.b.contains("P")) || (this.b.contains("p"));
  }
  
  public final boolean c()
  {
    return (this.l >= 0) && (this.i >= 0) && (this.l != this.i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */