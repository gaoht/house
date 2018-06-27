package com.ziroom.commonlib.utils;

import android.text.format.Time;
import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class e
{
  public static String a = "yyyyMMdd";
  public static String b = "yyyy-MM-dd";
  public static String c = "yyyy-MM-dd HH:mm:ss";
  public static String d = "yyyy/MM/dd HH:mm:ss";
  public static String e = "yyyy年MM月";
  public static String f = "yyyy年MM月dd日 HH:mm";
  public static String g = "MM月dd日 HH:mm";
  public static String h = "MM月dd日";
  public static String i = "dd日";
  public static String j = "HH:mm";
  public static String k = "yyyy.MM.dd";
  public static String l = "yyyy/MM/dd";
  
  private static String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 10)) {
      return "0" + Integer.toString(paramInt);
    }
    return "" + paramInt;
  }
  
  private static Date a(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTime(paramDate);
    if ((localGregorianCalendar.get(11) == 0) && (localGregorianCalendar.get(12) == 0) && (localGregorianCalendar.get(13) == 0)) {
      return new Date(paramDate.getTime());
    }
    return new Date(paramDate.getTime() - localGregorianCalendar.get(11) * 60 * 60 * 1000 - localGregorianCalendar.get(12) * 60 * 1000 - localGregorianCalendar.get(13) * 1000 - 86400000L);
  }
  
  public static String changeFormatDate(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new SimpleDateFormat(paramString2);
    paramString3 = new SimpleDateFormat(paramString3);
    try
    {
      paramString1 = paramString3.format(paramString2.parse(paramString1));
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static Date changeFormatToDate(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new SimpleDateFormat(paramString2);
    paramString3 = new SimpleDateFormat(paramString3);
    try
    {
      paramString1 = paramString3.parse(paramString3.format(paramString2.parse(paramString1)));
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String date2Str(Date paramDate, String paramString)
  {
    if (paramDate == null) {
      return "";
    }
    return new SimpleDateFormat(paramString).format(paramDate);
  }
  
  public static int differentDaysByMillisecond(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString1 = localSimpleDateFormat.parse(paramString1);
      long l1 = (localSimpleDateFormat.parse(paramString2).getTime() - paramString1.getTime()) / 86400000L;
      return (int)l1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return 0;
  }
  
  public static boolean equalsIngoreHMS(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.setTime(paramDate1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    paramDate1 = GregorianCalendar.getInstance();
    paramDate1.setTime(paramDate2);
    paramDate1.set(11, 0);
    paramDate1.set(12, 0);
    paramDate1.set(13, 0);
    paramDate1.set(14, 0);
    return localCalendar.equals(paramDate1);
  }
  
  public static String getCurrentTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localCalendar.getTime());
  }
  
  public static String getCurrentTime(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat(paramString).format(localCalendar.getTime());
  }
  
  public static Date getDateAfter(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.set(5, localCalendar.get(5) + paramInt);
    return localCalendar.getTime();
  }
  
  public static Date getDateBefore(Date paramDate, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.set(5, localCalendar.get(5) - paramInt);
    return localCalendar.getTime();
  }
  
  public static List<Date> getDateFromStartAndEnd(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCalendar1.compareTo(paramCalendar2) >= 0) {
      return localArrayList;
    }
    do
    {
      localArrayList.add(paramCalendar1.getTime());
      paramCalendar1.add(5, 1);
    } while (paramCalendar1.compareTo(paramCalendar2) != 0);
    return localArrayList;
  }
  
  public static long getDaysBetween(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    paramDate1 = Calendar.getInstance();
    paramDate1.setTime(paramDate2);
    paramDate1.set(11, 0);
    paramDate1.set(12, 0);
    paramDate1.set(13, 0);
    paramDate1.set(14, 0);
    return (paramDate1.getTime().getTime() - localCalendar.getTime().getTime()) / 86400000L;
  }
  
  public static Date getMonthFirstDay(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
    Calendar localCalendar = Calendar.getInstance();
    try
    {
      localCalendar.setTime(localSimpleDateFormat.parse(paramString));
      localCalendar.set(5, localCalendar.getMinimum(5));
      localCalendar.getTime();
      return localCalendar.getTime();
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static Date getNextMonthFirstDay(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
    Calendar localCalendar = Calendar.getInstance();
    try
    {
      localCalendar.setTime(localSimpleDateFormat.parse(paramString));
      localCalendar.set(5, localCalendar.getMinimum(5));
      localCalendar.add(2, 1);
      localCalendar.getTime();
      return localCalendar.getTime();
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String getNowDate()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(localTime.year), Integer.valueOf(localTime.month + 1), Integer.valueOf(localTime.monthDay) });
  }
  
  public static int getNowDay()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.monthDay;
  }
  
  public static int getNowHour()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.hour;
  }
  
  public static int getNowMonth()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.month;
  }
  
  public static String getNowTime()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(localTime.hour), Integer.valueOf(localTime.minute), Integer.valueOf(localTime.second) });
  }
  
  public static int getNowYear()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.year;
  }
  
  public static long getTimeLength(String paramString1, String paramString2)
  {
    long l1 = string2Long(paramString1, c);
    return string2Long(paramString2, c) - l1;
  }
  
  public static long getTimeLength(String paramString1, String paramString2, String paramString3)
  {
    long l1 = string2Long(paramString1, paramString3);
    return string2Long(paramString2, paramString3) - l1;
  }
  
  public static boolean isLessThanToday(Date paramDate)
  {
    boolean bool = true;
    if (paramDate == null) {
      return false;
    }
    if (a(new Date()).compareTo(a(paramDate)) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static String long2String(long paramLong)
  {
    if (paramLong > 0L)
    {
      SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat(f);
      SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat(g);
      SimpleDateFormat localSimpleDateFormat3 = new SimpleDateFormat(j);
      Date localDate1 = new Date(paramLong);
      Date localDate2 = new Date();
      paramLong = getDaysBetween(localDate1, localDate2);
      if (0L == paramLong) {
        return "今天 " + localSimpleDateFormat3.format(localDate1);
      }
      if (1L == paramLong) {
        return "昨天 " + localSimpleDateFormat3.format(localDate1);
      }
      if (localDate1.getYear() == localDate2.getYear()) {
        return localSimpleDateFormat2.format(localDate1);
      }
      return localSimpleDateFormat1.format(localDate1);
    }
    return "";
  }
  
  public static String long2String(long paramLong, String paramString)
  {
    if (paramLong > 0L) {
      return new SimpleDateFormat(paramString).format(new Date(paramLong));
    }
    return "";
  }
  
  public static String sec2HourMinSec(int paramInt)
  {
    int n = 60;
    if (paramInt <= 0) {
      return "00小时00";
    }
    int m = paramInt / 60;
    if (m < 60) {
      return a(m) + "分" + a(paramInt % 60) + "秒";
    }
    if (paramInt <= 3660)
    {
      if (m > 60)
      {
        paramInt -= 3600;
        m = n;
      }
      for (;;)
      {
        return a(m) + "分" + a(paramInt) + "秒";
        paramInt %= 60;
        new StringBuilder().append(a(m)).append("分").append(a(paramInt)).append("秒").toString();
      }
    }
    paramInt = m / 60;
    if (paramInt > 99) {
      return "99小时59分59";
    }
    m %= 60;
    return a(paramInt) + "小时" + a(m) + "分";
  }
  
  public static Date str2Date(String paramString1, String paramString2)
  {
    if (r.isNull(paramString1)) {
      return null;
    }
    try
    {
      paramString1 = new SimpleDateFormat(paramString2).parse(paramString1);
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static long string2Long(String paramString1, String paramString2)
  {
    try
    {
      long l1 = new SimpleDateFormat(paramString2).parse(paramString1).getTime();
      return l1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
      Log.v("util", "TimeStrToLong():" + paramString1);
    }
    return 0L;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */