package com.b.b;

import java.io.IOException;

public final class a
  extends IOException
{
  public a(int paramInt1, int paramInt2, long paramLong)
  {
    super(a(paramInt1, paramInt2, paramLong));
  }
  
  public a(String paramString)
  {
    super(paramString);
  }
  
  private static String a(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt1 < 0) {
      return String.format("Attempt to read from buffer using a negative index (%d)", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 < 0) {
      return String.format("Number of requested bytes cannot be negative (%d)", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt1 + paramInt2 - 1L > 2147483647L) {
      return String.format("Number of requested bytes summed with starting index exceed maximum range of signed 32 bit integers (requested index: %d, requested count: %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    return String.format("Attempt to read from beyond end of underlying data source (requested index: %d, requested count: %d, max index: %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong - 1L) });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */