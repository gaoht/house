package com.megvii.zhimasdk.b.a.k;

public class u
{
  private final int a;
  private final int b;
  private int c;
  
  public u(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }
    if (paramInt1 > paramInt2) {
      throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
    }
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt1;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < this.a) {
      throw new IndexOutOfBoundsException("pos: " + paramInt + " < lowerBound: " + this.a);
    }
    if (paramInt > this.b) {
      throw new IndexOutOfBoundsException("pos: " + paramInt + " > upperBound: " + this.b);
    }
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.c >= this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(Integer.toString(this.a));
    localStringBuilder.append('>');
    localStringBuilder.append(Integer.toString(this.c));
    localStringBuilder.append('>');
    localStringBuilder.append(Integer.toString(this.b));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */