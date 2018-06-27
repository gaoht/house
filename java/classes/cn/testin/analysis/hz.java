package cn.testin.analysis;

final class hz
{
  private static final int[][] a;
  private final hy b;
  private final byte c;
  
  static
  {
    int[] arrayOfInt1 = { 20375, 6 };
    int[] arrayOfInt2 = { 19104, 7 };
    int[] arrayOfInt3 = { 30660, 8 };
    int[] arrayOfInt4 = { 5769, 16 };
    int[] arrayOfInt5 = { 14854, 27 };
    a = new int[][] { { 21522, 0 }, { 20773, 1 }, { 24188, 2 }, { 23371, 3 }, { 17913, 4 }, { 16590, 5 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, { 29427, 9 }, { 32170, 10 }, { 30877, 11 }, { 26159, 12 }, { 25368, 13 }, { 27713, 14 }, { 26998, 15 }, arrayOfInt4, { 5054, 17 }, { 7399, 18 }, { 6608, 19 }, { 1890, 20 }, { 597, 21 }, { 3340, 22 }, { 2107, 23 }, { 13663, 24 }, { 12392, 25 }, { 16177, 26 }, arrayOfInt5, { 9396, 28 }, { 8579, 29 }, { 11994, 30 }, { 11245, 31 } };
  }
  
  private hz(int paramInt)
  {
    this.b = hy.a(paramInt >> 3 & 0x3);
    this.c = ((byte)(paramInt & 0x7));
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return Integer.bitCount(paramInt1 ^ paramInt2);
  }
  
  static hz b(int paramInt1, int paramInt2)
  {
    hz localhz = c(paramInt1, paramInt2);
    if (localhz != null) {
      return localhz;
    }
    return c(paramInt1 ^ 0x5412, paramInt2 ^ 0x5412);
  }
  
  private static hz c(int paramInt1, int paramInt2)
  {
    int j = Integer.MAX_VALUE;
    int[][] arrayOfInt = a;
    int n = arrayOfInt.length;
    int k = 0;
    int i = 0;
    int[] arrayOfInt1;
    int i1;
    int m;
    if (k < n)
    {
      arrayOfInt1 = arrayOfInt[k];
      i1 = arrayOfInt1[0];
      if ((i1 == paramInt1) || (i1 == paramInt2)) {
        return new hz(arrayOfInt1[1]);
      }
      m = a(paramInt1, i1);
      if (m >= j) {
        break label139;
      }
      i = arrayOfInt1[1];
      j = m;
    }
    label139:
    for (;;)
    {
      if (paramInt1 != paramInt2)
      {
        m = a(paramInt2, i1);
        if (m < j)
        {
          i = arrayOfInt1[1];
          j = m;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (j <= 3) {
          return new hz(i);
        }
        return null;
      }
    }
  }
  
  hy a()
  {
    return this.b;
  }
  
  byte b()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof hz)) {}
    do
    {
      return false;
      paramObject = (hz)paramObject;
    } while ((this.b != ((hz)paramObject).b) || (this.c != ((hz)paramObject).c));
    return true;
  }
  
  public int hashCode()
  {
    return this.b.ordinal() << 3 | this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */