package com.hyphenate.util;

public class PerfUtils
{
  public static int getSpeed(long paramLong1, long paramLong2)
  {
    return (int)((float)paramLong1 / (float)(paramLong2 / 1000L));
  }
  
  public static int getTimeSpendSecond(long paramLong)
  {
    int j = (int)(System.currentTimeMillis() - paramLong);
    int i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/PerfUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */