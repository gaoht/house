package com.ziroom.ziroomcustomer.newServiceList.utils;

import android.text.TextUtils;
import android.text.format.Time;
import com.hyphenate.util.DateUtils;
import com.hyphenate.util.TimeInfo;
import com.ziroom.ziroomcustomer.util.m;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class i
{
  private static boolean a(long paramLong)
  {
    TimeInfo localTimeInfo = DateUtils.getYesterdayStartAndEndTime();
    return (paramLong > localTimeInfo.getStartTime()) && (paramLong < localTimeInfo.getEndTime());
  }
  
  private static boolean b(long paramLong)
  {
    TimeInfo localTimeInfo = DateUtils.getTodayStartAndEndTime();
    return (paramLong > localTimeInfo.getStartTime()) && (paramLong < localTimeInfo.getEndTime());
  }
  
  public static int daysBetween(Date paramDate)
    throws ParseException
  {
    Date localDate = getNowTimeDate();
    Object localObject = new SimpleDateFormat("yyyy-MM-dd");
    paramDate = ((SimpleDateFormat)localObject).parse(((SimpleDateFormat)localObject).format(paramDate));
    localDate = ((SimpleDateFormat)localObject).parse(((SimpleDateFormat)localObject).format(localDate));
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTime(paramDate);
    long l = ((Calendar)localObject).getTimeInMillis();
    ((Calendar)localObject).setTime(localDate);
    return Integer.parseInt(String.valueOf((((Calendar)localObject).getTimeInMillis() - l) / 86400000L));
  }
  
  public static String getAllData(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate);
  }
  
  public static String getCandleTime(String paramString)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.substring(5, 10).replace("-", "/");
    }
    return str;
  }
  
  public static String getCleanerTime()
  {
    Object localObject = new Date(new Date(System.currentTimeMillis()).getTime() + 259200000L);
    localObject = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject);
    return (String)localObject + " 10:00";
  }
  
  public static String getDateStr(String paramString, long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Object localObject = null;
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      paramString = new Date(paramString.getTime() + 24L * paramLong * 60L * 60L * 1000L);
      return new SimpleDateFormat("yyyy-MM-dd").format(paramString);
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
  }
  
  public static String getDayTime(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      paramString1.substring(12, 15).replace("星期", "周");
    }
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    int i;
    try
    {
      localCalendar1.setTime(localSimpleDateFormat.parse(m.GetNowDate()));
      localCalendar1.set(10, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar2.setTime(localSimpleDateFormat.parse(paramString2));
      localCalendar2.set(10, 0);
      localCalendar2.set(12, 0);
      localCalendar2.set(13, 0);
      i = (int)((localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis()) / 86400000L);
      if (i == 0) {
        return "今天";
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    if (i == 1) {
      return "明天";
    }
    if (i == 2) {
      return "后天";
    }
    return paramString1.substring(12, 15).replace("星期", "周");
  }
  
  public static String getFormatTime(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new SimpleDateFormat(paramString2);
      paramString1 = paramString2.parse(paramString1);
      paramString1 = paramString2.format(paramString1) + "";
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String getLong2Data(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("HH:mm:ss").format(localDate);
  }
  
  public static String getMin2Data(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(localDate);
  }
  
  public static String getMuchDateStr(String paramString, int paramInt)
  {
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      localCalendar.add(5, paramInt);
      paramString = localCalendar.getTime();
      paramString = new SimpleDateFormat("yyyy-MM-dd").format(paramString).replaceAll("-", "/");
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String getNewMuchDateStr(String paramString, int paramInt)
  {
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      localCalendar.add(5, paramInt);
      paramString = localCalendar.getTime();
      paramString = new SimpleDateFormat("yyyy-MM-dd").format(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String getNextMonth(String paramString, int paramInt)
  {
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      localCalendar.add(2, paramInt);
      paramString = localCalendar.getTime();
      paramString = new SimpleDateFormat("yyyy-MM-dd").format(paramString).replaceAll("-", "/");
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String getNowDate()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(localTime.year), Integer.valueOf(localTime.month + 1), Integer.valueOf(localTime.monthDay) });
  }
  
  public static String getNowDateTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localCalendar.getTime());
  }
  
  public static Date getNowTimeDate()
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.parse(localSimpleDateFormat.format(localDate), new ParsePosition(8));
  }
  
  public static long getSecondDiff(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      Date localDate = localSimpleDateFormat.parse(getNowDateTime());
      paramString = localSimpleDateFormat.parse(paramString);
      long l = (localDate.getTime() - paramString.getTime()) / 1000L;
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static String getSimpleWeekOfDate(String paramString)
  {
    int i = 0;
    Object localObject = new SimpleDateFormat("yyyy-MM-dd");
    String str = null;
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      str = new SimpleDateFormat("EEEE").format(paramString);
      paramString = null;
      localObject = new String[7];
      localObject[0] = "星期日";
      localObject[1] = "星期一";
      localObject[2] = "星期二";
      localObject[3] = "星期三";
      localObject[4] = "星期四";
      localObject[5] = "星期五";
      localObject[6] = "星期六";
      while (i < localObject.length)
      {
        if (str.equals(localObject[i])) {
          paramString = new String[] { "周日", "周一", "周二", "周三", "周四", "周五", "周六" }[i];
        }
        i += 1;
      }
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    return paramString;
  }
  
  public static long getStr2TimeStamp(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static String getSys2Data(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("yyyy/MM/dd").format(localDate);
  }
  
  public static String getSysData(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  public static String getTimePick(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      new StringBuilder().append(paramString1.substring(12, 15).replace("星期", "周")).append("(").append(paramString1.substring(5, 11)).append(")").toString();
    }
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    int i;
    try
    {
      localCalendar1.setTime(localSimpleDateFormat.parse(m.GetNowDate()));
      localCalendar1.set(10, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar2.setTime(localSimpleDateFormat.parse(paramString2));
      localCalendar2.set(10, 0);
      localCalendar2.set(12, 0);
      localCalendar2.set(13, 0);
      i = (int)((localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis()) / 86400000L);
      if (i == 0) {
        return "今天(" + paramString1.substring(5, 11) + ")";
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    if (i == 1) {
      return "明天(" + paramString1.substring(5, 11) + ")";
    }
    if (i == 2) {
      return "后天(" + paramString1.substring(5, 11) + ")";
    }
    return paramString1.substring(12, 15).replace("星期", "周") + "(" + paramString1.substring(5, 11) + ")";
  }
  
  public static String getTimePick(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      new StringBuilder().append(paramString1.substring(12, 15).replace("星期", "周")).append("(").append(paramString1.substring(5, 11)).append(")").toString();
    }
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    int i;
    try
    {
      localCalendar1.setTime(localSimpleDateFormat.parse(paramString3));
      localCalendar1.set(10, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar2.setTime(localSimpleDateFormat.parse(paramString2));
      localCalendar2.set(10, 0);
      localCalendar2.set(12, 0);
      localCalendar2.set(13, 0);
      i = (int)((localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis()) / 86400000L);
      if (i == 0) {
        return "今天(" + paramString1.substring(5, 11) + ")";
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    if (i == 1) {
      return "明天(" + paramString1.substring(5, 11) + ")";
    }
    if (i == 2) {
      return "后天(" + paramString1.substring(5, 11) + ")";
    }
    return paramString1.substring(12, 15).replace("星期", "周") + "(" + paramString1.substring(5, 11) + ")";
  }
  
  public static String getTimestampString(Date paramDate)
  {
    boolean bool = Locale.getDefault().getLanguage().startsWith("zh");
    if (b(paramDate.getTime()))
    {
      if (bool) {
        return new SimpleDateFormat("HH:mm", Locale.CHINESE).format(paramDate);
      }
      return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(paramDate);
    }
    try
    {
      paramDate = daysBetween(paramDate) + "天前";
      return paramDate;
    }
    catch (Exception paramDate) {}
    return "";
  }
  
  public static String getWeekOfDate(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar localCalendar = null;
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      localCalendar = Calendar.getInstance();
      if (paramString != null) {
        localCalendar.setTime(paramString);
      }
      int j = localCalendar.get(7) - 1;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      return new String[] { "周日", "周一", "周二", "周三", "周四", "周五", "周六" }[i];
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localCalendar;
      }
    }
  }
  
  public static String getYdTime(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "9:00-13:00";
    case 2: 
      return "13:00-17:00";
    }
    return "17:00-24:00";
  }
  
  public static String getZzTimestampString(Date paramDate)
  {
    boolean bool = Locale.getDefault().getLanguage().startsWith("zh");
    long l = paramDate.getTime();
    String str;
    if (b(l)) {
      str = "HH:mm";
    }
    while (bool)
    {
      return new SimpleDateFormat(str, Locale.CHINESE).format(paramDate);
      if (a(l))
      {
        if (bool) {
          str = "昨天HH:mm";
        } else {
          return "Yesterday " + new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(paramDate);
        }
      }
      else if (bool) {
        str = "M月d日 HH:mm";
      } else {
        str = "MMM dd HH:mm";
      }
    }
    return new SimpleDateFormat(str, Locale.ENGLISH).format(paramDate);
  }
  
  public long dateDiff(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    long l1 = 0L;
    try
    {
      long l2 = localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime();
      l1 = l2;
      l2 /= 86400000L;
      return l2;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return l1;
  }
  
  public List<String> getAppointDateList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (dateDiff(paramString1, paramString2) == 0L)
    {
      localArrayList.add("今天");
      localArrayList.add("明天");
      localArrayList.add("后天");
      i = 3;
      while (i < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString2, i));
        i += 1;
      }
    }
    if (dateDiff(paramString1, paramString2) == 1L)
    {
      localArrayList.add("明天");
      localArrayList.add("后天");
      i = 2;
      while (i < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString2, i));
        i += 1;
      }
    }
    if (dateDiff(paramString1, paramString2) == 2L)
    {
      localArrayList.add("后天");
      i = 1;
      while (i < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString2, i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List<String> getGeneralDateList(int paramInt, String paramString)
  {
    int i = 2;
    int j = 1;
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      localArrayList.add("今天");
      localArrayList.add("明天");
      localArrayList.add("后天");
      paramInt = 3;
      while (paramInt < 7)
      {
        localArrayList.add(getNextMuchDateStr(paramString, paramInt));
        paramInt += 1;
      }
    }
    if (paramInt == 2)
    {
      localArrayList.add("明天");
      localArrayList.add("后天");
      paramInt = i;
      while (paramInt < 7)
      {
        localArrayList.add(getNextMuchDateStr(getNewMuchDateStr(paramString, 1), paramInt));
        paramInt += 1;
      }
    }
    if (paramInt == 3)
    {
      localArrayList.add("后天");
      paramInt = j;
      while (paramInt < 7)
      {
        localArrayList.add(getNextMuchDateStr(getNewMuchDateStr(paramString, 2), paramInt));
        paramInt += 1;
      }
    }
    return localArrayList;
  }
  
  public List<String> getNDateList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 7)
    {
      localArrayList.add(getNextMuchDateStr(paramString, i));
      i += 1;
    }
    return localArrayList;
  }
  
  public String getNextMuchDateStr(String paramString, int paramInt)
  {
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      localCalendar.add(5, paramInt);
      paramString = localCalendar.getTime();
      paramString = new SimpleDateFormat("MM月dd日").format(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public List<String> getNormalDateList(int paramInt, String paramString)
  {
    int i = 1;
    int j = 2;
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      localArrayList.add("今天(" + getNextMuchDateStr(paramString, 0) + ")");
      localArrayList.add("明天(" + getNextMuchDateStr(paramString, 1) + ")");
      localArrayList.add("后天(" + getNextMuchDateStr(paramString, 2) + ")");
      paramInt = 3;
      while (paramInt < 7)
      {
        localArrayList.add(getSimpleWeekOfDate(getNewMuchDateStr(paramString, paramInt + 1)) + "(" + getNextMuchDateStr(paramString, paramInt) + ")");
        paramInt += 1;
      }
    }
    if (paramInt == 2)
    {
      localArrayList.add("明天(" + getNextMuchDateStr(paramString, 1) + ")");
      localArrayList.add("后天(" + getNextMuchDateStr(paramString, 2) + ")");
      paramInt = j;
      while (paramInt < 7)
      {
        localArrayList.add(getSimpleWeekOfDate(getNewMuchDateStr(paramString, paramInt + 1)) + "(" + getNextMuchDateStr(getNewMuchDateStr(paramString, 1), paramInt) + ")");
        paramInt += 1;
      }
    }
    if (paramInt == 3)
    {
      localArrayList.add("后天(" + getNextMuchDateStr(paramString, 2) + ")");
      paramInt = i;
      while (paramInt < 7)
      {
        localArrayList.add(getSimpleWeekOfDate(getNewMuchDateStr(paramString, paramInt + 2)) + "(" + getNextMuchDateStr(getNewMuchDateStr(paramString, 2), paramInt) + ")");
        paramInt += 1;
      }
    }
    return localArrayList;
  }
  
  public List<String> getSevenDateList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 7)
    {
      localArrayList.add(getMuchDateStr(paramString, i));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/utils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */