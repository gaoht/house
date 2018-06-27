package com.ziroom.ziroomcustomer.termination.view;

import android.annotation.SuppressLint;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class a
{
  public static String[] a = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
  
  public static int getCurrentMonthDay()
  {
    return Calendar.getInstance().get(5);
  }
  
  public static String getCurrentWeekOfMonth(String paramString)
  {
    int k = 0;
    for (;;)
    {
      try
      {
        paramString = paramString.split("-");
        if ("".equals(paramString[0])) {
          break label94;
        }
        i = Integer.parseInt(paramString[0]);
        if (!"".equals(paramString[1]))
        {
          j = Integer.parseInt(paramString[1]);
          if (!"".equals(paramString[2])) {
            k = Integer.parseInt(paramString[2]);
          }
          paramString = getCurrentWeekOfMonth(new GregorianCalendar(i, j - 1, k));
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      int j = 0;
      continue;
      label94:
      int i = 0;
    }
  }
  
  public static String getCurrentWeekOfMonth(Calendar paramCalendar)
  {
    String str = "";
    int i = paramCalendar.get(7);
    if (i == 1) {
      paramCalendar = "星期天";
    }
    do
    {
      return paramCalendar;
      if (i == 2) {
        return "星期一";
      }
      if (i == 3) {
        return "星期二";
      }
      if (i == 4) {
        return "星期三";
      }
      if (i == 5) {
        return "星期四";
      }
      if (i == 6) {
        return "星期五";
      }
      paramCalendar = str;
    } while (i != 7);
    return "星期六";
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static Date getDateFromString(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt1).append("-");
    if (paramInt2 > 9) {}
    for (Object localObject = Integer.valueOf(paramInt2);; localObject = "0" + paramInt2)
    {
      localObject = localObject + "-01";
      try
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd").parse((String)localObject);
        return (Date)localObject;
      }
      catch (ParseException localParseException)
      {
        System.out.println(localParseException.getMessage());
      }
    }
    return null;
  }
  
  public static int getHour()
  {
    return Calendar.getInstance().get(11);
  }
  
  public static Calendar getIsMonth(String paramString)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString);
      return (Calendar)localObject;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static int getMinute()
  {
    return Calendar.getInstance().get(12);
  }
  
  public static int getMonth()
  {
    return Calendar.getInstance().get(2) + 1;
  }
  
  public static int getMonthDays(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if (paramInt2 > 12)
    {
      i = paramInt1 + 1;
      j = 1;
    }
    for (;;)
    {
      int[] arrayOfInt = new int[12];
      int[] tmp20_18 = arrayOfInt;
      tmp20_18[0] = 31;
      int[] tmp25_20 = tmp20_18;
      tmp25_20[1] = 28;
      int[] tmp30_25 = tmp25_20;
      tmp30_25[2] = 31;
      int[] tmp35_30 = tmp30_25;
      tmp35_30[3] = 30;
      int[] tmp40_35 = tmp35_30;
      tmp40_35[4] = 31;
      int[] tmp45_40 = tmp40_35;
      tmp45_40[5] = 30;
      int[] tmp50_45 = tmp45_40;
      tmp50_45[6] = 31;
      int[] tmp56_50 = tmp50_45;
      tmp56_50[7] = 31;
      int[] tmp62_56 = tmp56_50;
      tmp62_56[8] = 30;
      int[] tmp68_62 = tmp62_56;
      tmp68_62[9] = 31;
      int[] tmp74_68 = tmp68_62;
      tmp74_68[10] = 30;
      int[] tmp80_74 = tmp74_68;
      tmp80_74[11] = 31;
      tmp80_74;
      if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
        arrayOfInt[1] = 29;
      }
      return arrayOfInt[(j - 1)];
      i = paramInt1;
      j = paramInt2;
      if (paramInt2 < 1)
      {
        i = paramInt1 - 1;
        j = 12;
      }
    }
  }
  
  public static c getNextSunday()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 7 - getWeekDay() + 1);
    return new c(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5));
  }
  
  public static int getWeekDay()
  {
    return Calendar.getInstance().get(7);
  }
  
  public static int getWeekDayFromDate(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(getDateFromString(paramInt1, paramInt2));
    paramInt2 = localCalendar.get(7) - 1;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  public static String getWeekOfDate(Date paramDate)
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    if (paramDate != null) {
      localCalendar.setTime(paramDate);
    }
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }[i];
      i = j;
    }
  }
  
  public static int[] getWeekSunday(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    localCalendar.add(5, paramInt4);
    return new int[] { localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5) };
  }
  
  public static int getYear()
  {
    return Calendar.getInstance().get(1);
  }
  
  public static boolean isCurrentDay(String paramString, int paramInt, c paramc)
  {
    boolean bool = true;
    if (paramString == null) {
      return false;
    }
    paramString = paramString.split("-");
    if ((Integer.parseInt(paramString[0]) == paramc.a) && (Integer.parseInt(paramString[1]) == paramc.b) && (Integer.parseInt(paramString[2]) == paramInt)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isCurrentMonth(c paramc)
  {
    return (paramc.a == getYear()) && (paramc.b == getMonth());
  }
  
  public static boolean isToday(c paramc)
  {
    return (paramc.a == getYear()) && (paramc.b == getMonth()) && (paramc.c == getCurrentMonthDay());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */