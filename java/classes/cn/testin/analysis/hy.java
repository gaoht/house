package cn.testin.analysis;

public enum hy
{
  private static final hy[] e = { b, a, d, c };
  private final int f;
  
  private hy(int paramInt)
  {
    this.f = paramInt;
  }
  
  public static hy a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= e.length)) {
      throw new IllegalArgumentException();
    }
    return e[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */