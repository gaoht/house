package com.mato.sdk.g;

import com.mato.sdk.c.d.e;
import com.mato.sdk.d.k;

public final class a
{
  private a()
  {
    throw new AssertionError();
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Integer)e.a(k.a(paramArrayOfInt), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBoolean)).intValue();
  }
  
  private static long a(long[] paramArrayOfLong, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramArrayOfLong.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Long)e.a(k.a(paramArrayOfLong), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramBoolean)).longValue();
  }
  
  public static <V> V a(V[] paramArrayOfV, V paramV1, V paramV2, boolean paramBoolean)
  {
    if (e.a(paramArrayOfV)) {}
    label12:
    label72:
    for (;;)
    {
      return paramV2;
      int i = 0;
      if (i < paramArrayOfV.length) {
        if (!k.a(paramV1, paramArrayOfV[i])) {}
      }
      for (;;)
      {
        if (i == -1) {
          break label72;
        }
        if (i == 0)
        {
          if (!paramBoolean) {
            break;
          }
          return paramArrayOfV[(paramArrayOfV.length - 1)];
          i += 1;
          break label12;
        }
        return paramArrayOfV[(i - 1)];
        i = -1;
      }
    }
  }
  
  public static <V> V a(V[] paramArrayOfV, V paramV, boolean paramBoolean)
  {
    return (V)e.a(paramArrayOfV, paramV, null, true);
  }
  
  public static <V> boolean a(V[] paramArrayOfV)
  {
    return (paramArrayOfV == null) || (paramArrayOfV.length == 0);
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Integer)e.b(k.a(paramArrayOfInt), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramBoolean)).intValue();
  }
  
  private static long b(long[] paramArrayOfLong, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramArrayOfLong.length == 0) {
      throw new IllegalArgumentException("The length of source array must be greater than 0.");
    }
    return ((Long)e.b(k.a(paramArrayOfLong), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramBoolean)).longValue();
  }
  
  public static <V> V b(V[] paramArrayOfV, V paramV1, V paramV2, boolean paramBoolean)
  {
    if (e.a(paramArrayOfV)) {}
    label12:
    label73:
    for (;;)
    {
      return paramV2;
      int i = 0;
      if (i < paramArrayOfV.length) {
        if (!k.a(paramV1, paramArrayOfV[i])) {}
      }
      for (;;)
      {
        if (i == -1) {
          break label73;
        }
        if (i == paramArrayOfV.length - 1)
        {
          if (!paramBoolean) {
            break;
          }
          return paramArrayOfV[0];
          i += 1;
          break label12;
        }
        return paramArrayOfV[(i + 1)];
        i = -1;
      }
    }
  }
  
  public static <V> V b(V[] paramArrayOfV, V paramV, boolean paramBoolean)
  {
    return (V)e.b(paramArrayOfV, paramV, null, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */