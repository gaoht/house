package com.google.c.a.a;

public final class a
{
  public static final a a = new a(4201, 4096);
  public static final a b = new a(1033, 1024);
  public static final a c = new a(67, 64);
  public static final a d = new a(19, 16);
  public static final a e = new a(285, 256);
  public static final a f = new a(301, 256);
  public static final a g = f;
  public static final a h = c;
  private int[] i;
  private int[] j;
  private b k;
  private b l;
  private final int m;
  private final int n;
  private boolean o = false;
  
  public a(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.m = paramInt2;
    if (paramInt2 <= 0) {
      b();
    }
  }
  
  static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  private void b()
  {
    this.i = new int[this.m];
    this.j = new int[this.m];
    int i2 = 0;
    int i1 = 1;
    while (i2 < this.m)
    {
      this.i[i2] = i1;
      int i3 = i1 << 1;
      i1 = i3;
      if (i3 >= this.m) {
        i1 = (i3 ^ this.n) & this.m - 1;
      }
      i2 += 1;
    }
    i1 = 0;
    while (i1 < this.m - 1)
    {
      this.j[this.i[i1]] = i1;
      i1 += 1;
    }
    this.k = new b(this, new int[] { 0 });
    this.l = new b(this, new int[] { 1 });
    this.o = true;
  }
  
  private void c()
  {
    if (!this.o) {
      b();
    }
  }
  
  int a(int paramInt)
  {
    c();
    return this.i[paramInt];
  }
  
  b a()
  {
    c();
    return this.k;
  }
  
  b a(int paramInt1, int paramInt2)
  {
    c();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.k;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new b(this, arrayOfInt);
  }
  
  int b(int paramInt)
  {
    c();
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.j[paramInt];
  }
  
  int c(int paramInt)
  {
    c();
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.i[(this.m - this.j[paramInt] - 1)];
  }
  
  int c(int paramInt1, int paramInt2)
  {
    c();
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    int i1;
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < this.m))
    {
      i1 = paramInt1;
      if (paramInt2 < this.m) {}
    }
    else
    {
      i1 = paramInt1 + 1;
    }
    paramInt1 = this.j[i1] + this.j[paramInt2];
    int[] arrayOfInt = this.i;
    paramInt2 = this.m;
    return arrayOfInt[(paramInt1 / this.m + paramInt1 % paramInt2)];
  }
  
  public int getSize()
  {
    return this.m;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */