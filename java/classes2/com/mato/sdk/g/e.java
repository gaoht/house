package com.mato.sdk.g;

public final class e
{
  private e()
  {
    throw new AssertionError();
  }
  
  private static String a(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return paramObject.toString();
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 != null) {
        break label15;
      }
      if (paramObject2 != null) {
        break label23;
      }
    }
    label15:
    while (paramObject1.equals(paramObject2)) {
      return true;
    }
    label23:
    return false;
  }
  
  private static int[] a(Integer[] paramArrayOfInteger)
  {
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    int i = 0;
    while (i < paramArrayOfInteger.length)
    {
      arrayOfInt[i] = paramArrayOfInteger[i].intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static long[] a(Long[] paramArrayOfLong)
  {
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = paramArrayOfLong[i].longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public static Integer[] a(int[] paramArrayOfInt)
  {
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static Long[] a(long[] paramArrayOfLong)
  {
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    return arrayOfLong;
  }
  
  private static <V> int b(V paramV1, V paramV2)
  {
    if (paramV1 == null)
    {
      if (paramV2 == null) {
        return 0;
      }
      return -1;
    }
    if (paramV2 == null) {
      return 1;
    }
    return ((Comparable)paramV1).compareTo(paramV2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */