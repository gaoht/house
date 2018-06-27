package com.google.c.d.a;

public enum b
{
  private final int[] k;
  private final int l;
  
  private b(int[] paramArrayOfInt, int paramInt)
  {
    this.k = paramArrayOfInt;
    this.l = paramInt;
  }
  
  public static b forBits(int paramInt)
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
  
  public int getBits()
  {
    return this.l;
  }
  
  public int getCharacterCountBits(c paramc)
  {
    int n = paramc.getVersionNumber();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */