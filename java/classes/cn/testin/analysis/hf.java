package cn.testin.analysis;

public final class hf
{
  public static final hf a = new hf(285, 256, 0);
  private final int[] b;
  private final int[] c;
  private final hg d;
  private final hg e;
  private final int f;
  private final int g;
  private final int h;
  
  public hf(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = paramInt1;
    this.f = paramInt2;
    this.h = paramInt3;
    this.b = new int[paramInt2];
    this.c = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.b[i] = paramInt3;
      int j = paramInt3 * 2;
      paramInt3 = j;
      if (j >= paramInt2) {
        paramInt3 = (j ^ paramInt1) & paramInt2 - 1;
      }
      i += 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2 - 1)
    {
      this.c[this.b[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.d = new hg(this, new int[] { 0 });
    this.e = new hg(this, new int[] { 1 });
  }
  
  static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  int a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  hg a()
  {
    return this.d;
  }
  
  hg a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.d;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new hg(this, arrayOfInt);
  }
  
  int b(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.c[paramInt];
  }
  
  hg b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
  
  int c(int paramInt)
  {
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.b[(this.f - this.c[paramInt] - 1)];
  }
  
  int c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.b[((this.c[paramInt1] + this.c[paramInt2]) % (this.f - 1))];
  }
  
  public int d()
  {
    return this.h;
  }
  
  public String toString()
  {
    return "GF(0x" + Integer.toHexString(this.g) + ',' + this.f + ')';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */