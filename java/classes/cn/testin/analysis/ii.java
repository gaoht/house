package cn.testin.analysis;

public final class ii
  extends gc
{
  private final float a;
  private final int b;
  
  ii(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramFloat1, paramFloat2, paramFloat3, 1);
  }
  
  private ii(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
    this.b = paramInt;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramFloat2 - b()) <= paramFloat1)
    {
      bool1 = bool2;
      if (Math.abs(paramFloat3 - a()) <= paramFloat1)
      {
        paramFloat1 = Math.abs(paramFloat1 - this.a);
        if (paramFloat1 > 1.0F)
        {
          bool1 = bool2;
          if (paramFloat1 > this.a) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  ii b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = this.b + 1;
    return new ii((this.b * a() + paramFloat2) / i, (this.b * b() + paramFloat1) / i, (this.b * this.a + paramFloat3) / i, i);
  }
  
  public float c()
  {
    return this.a;
  }
  
  int d()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */