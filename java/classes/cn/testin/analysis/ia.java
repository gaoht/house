package cn.testin.analysis;

public enum ia
{
  private final int[] k;
  private final int l;
  
  private ia(int[] paramArrayOfInt, int paramInt)
  {
    this.k = paramArrayOfInt;
    this.l = paramInt;
  }
  
  public static ia a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 0: 
      return a;
    case 1: 
      return b;
    case 2: 
      return c;
    case 3: 
      return d;
    case 4: 
      return e;
    case 5: 
      return h;
    case 7: 
      return f;
    case 8: 
      return g;
    case 9: 
      return i;
    }
    return j;
  }
  
  public int a(ic paramic)
  {
    int n = paramic.a();
    if (n <= 9) {
      n = 0;
    }
    for (;;)
    {
      return this.k[n];
      if (n <= 26) {
        n = 1;
      } else {
        n = 2;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */