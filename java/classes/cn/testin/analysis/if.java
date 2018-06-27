package cn.testin.analysis;

public final class if
  extends gc
{
  private final float a;
  
  if(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
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
  
  if b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new if((a() + paramFloat2) / 2.0F, (b() + paramFloat1) / 2.0F, (this.a + paramFloat3) / 2.0F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/if.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */