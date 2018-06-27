package com.megvii.zhimasdk.b.a.d;

public class b
  implements Cloneable
{
  public static final b a = new a().a();
  private final int b;
  private final int c;
  
  b(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public static a d()
  {
    return new a();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  protected b c()
  {
    return (b)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[maxLineLength=").append(this.b).append(", maxHeaderCount=").append(this.c).append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    private int a = -1;
    private int b = -1;
    
    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public b a()
    {
      return new b(this.a, this.b);
    }
    
    public a b(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */