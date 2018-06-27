package com.baidu.location.b;

public class a
{
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public int d = -1;
  public int e = Integer.MAX_VALUE;
  public int f = Integer.MAX_VALUE;
  public long g = 0L;
  public int h = -1;
  public char i = '0';
  private boolean j = false;
  
  public a()
  {
    this.g = System.currentTimeMillis();
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, char paramChar)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.h = paramInt5;
    this.i = paramChar;
    this.g = System.currentTimeMillis();
  }
  
  public a(a parama)
  {
    this(parama.a, parama.b, parama.c, parama.d, parama.h, parama.i);
    this.g = parama.g;
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    return (l - this.g > 0L) && (l - this.g < 3000L);
  }
  
  public boolean a(a parama)
  {
    return (this.a == parama.a) && (this.b == parama.b) && (this.d == parama.d) && (this.c == parama.c);
  }
  
  public boolean b()
  {
    return (this.a > -1) && (this.b > 0);
  }
  
  public boolean c()
  {
    return (this.a == -1) && (this.b == -1) && (this.d == -1) && (this.c == -1);
  }
  
  public boolean d()
  {
    return (this.a > -1) && (this.b > -1) && (this.d == -1) && (this.c == -1);
  }
  
  public boolean e()
  {
    return (this.a > -1) && (this.b > -1) && (this.d > -1) && (this.c > -1);
  }
  
  public void f()
  {
    this.j = true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */