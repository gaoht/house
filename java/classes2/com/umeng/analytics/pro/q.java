package com.umeng.analytics.pro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class q
{
  public static final int a = 1;
  private static final int b = 1000;
  private static final int c = 1001;
  private static final int d = 1002;
  
  private static long a(long paramLong, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int j = localCalendar.get(11);
    int k = localCalendar.get(12) / 6;
    int m = localCalendar.get(13);
    int i = 0;
    if (paramInt == 1002) {
      i = 360 - (localCalendar.get(12) % 6 * 60 + m);
    }
    for (;;)
    {
      return i * 1000;
      if (paramInt == 1001)
      {
        paramInt = 60 - m % 60;
        i = paramInt;
        if ((k + 1 + j * 10) % 6 == 0) {
          i = paramInt + 60;
        }
      }
    }
  }
  
  public static String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    int j = localCalendar.get(12) / 6;
    paramLong = b(paramLong);
    return String.valueOf(j + 1 + i * 10 - 1 + paramLong * 240L);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return e(paramLong1) == e(paramLong2);
  }
  
  public static long b(long paramLong)
  {
    long l1 = 0L;
    try
    {
      long l3 = new SimpleDateFormat("yyyy", Locale.getDefault()).parse("1970").getTime();
      long l2 = (paramLong - l3) / 86400000L;
      if ((paramLong - l3) % 86400000L > 0L) {
        l1 = 1L;
      }
      return l1 + l2;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static long c(long paramLong)
  {
    return a(paramLong, 1001);
  }
  
  public static long d(long paramLong)
  {
    return a(paramLong, 1002);
  }
  
  private static int e(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(5);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */