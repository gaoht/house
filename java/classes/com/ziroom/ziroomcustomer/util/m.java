package com.ziroom.ziroomcustomer.util;

import android.text.format.Time;
import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class m
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
  
  public static String DateTimeToStr(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return String.format("%d-%02d-%02d %d:%02d:%02d", new Object[] { Integer.valueOf(paramDate.getYear() + 1900), Integer.valueOf(paramDate.getMonth() + 1), Integer.valueOf(paramDate.getDate()), Integer.valueOf(paramDate.getHours()), Integer.valueOf(paramDate.getMinutes()), Integer.valueOf(paramDate.getSeconds()) });
  }
  
  public static String DateToStr(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(paramDate.getYear() + 1900), Integer.valueOf(paramDate.getMonth() + 1), Integer.valueOf(paramDate.getDate()) });
  }
  
  public static int GetDateYear(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINESE);
    localCalendar.setTime(paramDate);
    return localCalendar.get(1);
  }
  
  public static String GetMinsuTodayDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat("yyyy-MM-dd ").format(localCalendar.getTime());
  }
  
  public static String GetNowDate()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return String.format("%d-%02d-%02d", new Object[] { Integer.valueOf(localTime.year), Integer.valueOf(localTime.month + 1), Integer.valueOf(localTime.monthDay) });
  }
  
  public static int GetNowDateDay()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINESE);
    localCalendar.setTime(new Date());
    return localCalendar.get(5);
  }
  
  public static int GetNowDateMon()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINESE);
    localCalendar.setTime(new Date());
    return localCalendar.get(2) + 1;
  }
  
  public static String GetNowDateTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localCalendar.getTime());
  }
  
  public static int GetNowDateYear()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINESE);
    localCalendar.setTime(new Date());
    return localCalendar.get(1);
  }
  
  public static int GetNowDay()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.monthDay;
  }
  
  public static int GetNowHour()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.hour;
  }
  
  public static int GetNowMonth()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.month;
  }
  
  public static String GetNowTime()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(localTime.hour), Integer.valueOf(localTime.minute), Integer.valueOf(localTime.second) });
  }
  
  public static int GetNowYear()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.year;
  }
  
  public static String StrToNorDate(String paramString)
  {
    if (ae.isNull(paramString)) {
      paramString = "";
    }
    String[] arrayOfString;
    do
    {
      return paramString;
      arrayOfString = paramString.split("-");
    } while (arrayOfString.length < 3);
    paramString = new StringBuffer();
    paramString.append(arrayOfString[0]);
    paramString.append("年");
    paramString.append(arrayOfString[1]);
    paramString.append("月");
    paramString.append(arrayOfString[2]);
    paramString.append("日");
    return paramString.toString();
  }
  
  public static String TimeL2S(long paramLong)
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
  
  public static String TimeL2S(long paramLong, String paramString)
  {
    if (paramLong > 0L) {
      return new SimpleDateFormat(paramString).format(new Date(paramLong));
    }
    return "";
  }
  
  public static long TimeS2L(String paramString1, String paramString2)
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
  
  public static String TimeToStr(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(paramDate.getHours()), Integer.valueOf(paramDate.getMinutes()), Integer.valueOf(paramDate.getSeconds()) });
  }
  
  public static int cacluteMonthDay(int paramInt1, int paramInt2, int paramInt3)
  {
    int m;
    int n;
    int i2;
    if (paramInt2 <= 2) {
      if (paramInt1 % 4 == 0)
      {
        m = 1;
        if (paramInt2 != 1) {
          break label221;
        }
        n = 31;
        i1 = 1;
        i2 = 1;
        label28:
        if ((paramInt2 != 2) || (m == 0)) {
          break label136;
        }
        m = n + 29;
        label43:
        paramInt1 += 1;
        n = i2 + 1;
        i2 = i1 + 1;
      }
    }
    for (int i1 = paramInt1;; i1 = paramInt1)
    {
      i2 += paramInt2;
      paramInt2 = 1;
      paramInt1 = m;
      m = i2;
      label75:
      label104:
      int i3;
      if (paramInt2 <= paramInt3 - n)
      {
        i2 = m + paramInt2 - 1;
        if (i2 % 12 != 0)
        {
          m = i2 % 12;
          i3 = getMonthProper(m);
          if (i3 != 1) {
            break label164;
          }
          paramInt1 += 31;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        m = i2;
        break label75;
        m = 0;
        break;
        label136:
        m = n;
        if (paramInt2 != 2) {
          break label43;
        }
        m = n + 28;
        break label43;
        m = i2 % 12 + 1;
        break label104;
        label164:
        if (i3 == 0)
        {
          paramInt1 += 30;
        }
        else if (m == 2)
        {
          if (i1 % 4 == 0) {}
          for (m = 1;; m = 0)
          {
            if (m == 0) {
              break label208;
            }
            paramInt1 += 29;
            break;
          }
          label208:
          paramInt1 += 28;
          continue;
          return paramInt1;
        }
      }
      label221:
      i1 = 0;
      i2 = 0;
      n = 0;
      break label28;
      i2 = 0;
      n = 0;
      m = 0;
    }
  }
  
  public static int[] caculateDayAndMonth2(String paramString1, String paramString2, SimpleDateFormat paramSimpleDateFormat)
  {
    arrayOfInt = new int[3];
    l2 = 0L;
    try
    {
      l1 = paramSimpleDateFormat.parse(paramString1).getTime();
    }
    catch (ParseException paramString1)
    {
      try
      {
        label41:
        paramString1.setTimeInMillis(l2);
        paramString2.setTimeInMillis(l1);
        i1 = paramString1.get(1);
        n = paramString2.get(1);
        i2 = paramString1.get(2) + 1;
        i3 = paramString2.get(2) + 1;
        m = paramString1.get(5);
        i4 = paramString2.get(5);
        if (i3 == i2) {
          if (i4 == m)
          {
            n = (n - i1) * 12;
            m = 0;
            arrayOfInt[1] = n;
            arrayOfInt[2] = m;
            return arrayOfInt;
            paramString1 = paramString1;
            l1 = 0L;
            paramString1.printStackTrace();
          }
        }
      }
      catch (Exception paramSimpleDateFormat)
      {
        for (;;)
        {
          int i1;
          int n;
          int i2;
          int i3;
          int m;
          int i4;
          paramSimpleDateFormat.printStackTrace();
          continue;
          if (i4 > m)
          {
            m = i4 - m;
            n = (n - i1) * 12 - i2 + i3;
          }
          else
          {
            n = (n - i1) * 12 - i2 + i3 - 1;
            m = cacluteMonthDay(i1, i2 - 1, 1) - m + i4;
            continue;
            if (i4 == m)
            {
              m = 0;
              n = (n - i1) * 12 - i2 + i3;
            }
            else if (i4 > m)
            {
              m = i4 - m;
              n = (n - i1) * 12 - i2 + i3;
            }
            else
            {
              n = (n - i1) * 12 - i2 + i3 - 1;
              m = cacluteMonthDay(i1, i2, 1) - m + i4;
            }
          }
        }
      }
    }
    try
    {
      l2 = paramSimpleDateFormat.parse(paramString2).getTime();
      if (l1 <= l2) {
        break label351;
      }
      arrayOfInt[0] = 1;
    }
    catch (ParseException paramString1)
    {
      l2 = l1;
      break label166;
      long l3 = l1;
      l1 = l2;
      l2 = l3;
      break label41;
    }
    paramString1 = Calendar.getInstance();
    paramString1.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    paramString2 = Calendar.getInstance();
    paramString2.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
  }
  
  public static long caculateLeftTime(String paramString1, String paramString2, SimpleDateFormat paramSimpleDateFormat)
  {
    try
    {
      long l1 = paramSimpleDateFormat.parse(paramString1).getTime();
      long l2 = paramSimpleDateFormat.parse(paramString2).getTime();
      return l2 - l1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return 0L;
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
  
  public static List<Date> dateToWeek(Date paramDate)
  {
    paramDate.getDay();
    ArrayList localArrayList = new ArrayList();
    long l1 = paramDate.getTime();
    int m = 0;
    while (m < 7)
    {
      paramDate = new Date();
      paramDate.setTime(Long.valueOf(l1).longValue() + m * 24 * 3600000);
      localArrayList.add(m, paramDate);
      m += 1;
    }
    return localArrayList;
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
  
  public static String getDateByTimestamp(long paramLong, String paramString)
  {
    return new SimpleDateFormat(paramString).format(new Date(paramLong));
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
  
  public static String getDateStr(String paramString1, String paramString2)
  {
    return getFormatDate(strToDate(paramString1, c), paramString2);
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
  
  public static String getFormatDate(Date paramDate, String paramString)
  {
    if (paramDate == null) {
      return "";
    }
    return new SimpleDateFormat(paramString).format(paramDate);
  }
  
  public static String getHourMinute(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return new SimpleDateFormat(j).format(paramDate);
  }
  
  public static int getIDay(String paramString)
  {
    return Integer.valueOf(paramString.substring(paramString.length() - 2)).intValue();
  }
  
  public static int getIMon(String paramString)
  {
    return Integer.valueOf(paramString.substring(5, 7)).intValue();
  }
  
  public static String getMon(int paramInt)
  {
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return "" + paramInt;
  }
  
  public static String getMonthDay(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return new SimpleDateFormat(h).format(paramDate);
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
  
  public static int getMonthProper(int paramInt)
  {
    int i1 = 0;
    int[] arrayOfInt1 = new int[7];
    int[] tmp10_8 = arrayOfInt1;
    tmp10_8[0] = 1;
    int[] tmp14_10 = tmp10_8;
    tmp14_10[1] = 3;
    int[] tmp18_14 = tmp14_10;
    tmp18_14[2] = 5;
    int[] tmp22_18 = tmp18_14;
    tmp22_18[3] = 7;
    int[] tmp27_22 = tmp22_18;
    tmp27_22[4] = 8;
    int[] tmp32_27 = tmp27_22;
    tmp32_27[5] = 10;
    int[] tmp37_32 = tmp32_27;
    tmp37_32[6] = 12;
    tmp37_32;
    int[] arrayOfInt2 = new int[4];
    int[] tmp51_49 = arrayOfInt2;
    tmp51_49[0] = 4;
    int[] tmp55_51 = tmp51_49;
    tmp55_51[1] = 6;
    int[] tmp60_55 = tmp55_51;
    tmp60_55[2] = 9;
    int[] tmp65_60 = tmp60_55;
    tmp65_60[3] = 11;
    tmp65_60;
    int m = 0;
    while (m < arrayOfInt1.length)
    {
      if (arrayOfInt1[m] == paramInt)
      {
        m = 1;
        return m;
      }
      m += 1;
    }
    int n = 0;
    for (;;)
    {
      if (n >= arrayOfInt2.length) {
        break label125;
      }
      m = i1;
      if (arrayOfInt2[n] == paramInt) {
        break;
      }
      n += 1;
    }
    label125:
    return -1;
  }
  
  public static String getNextMonthDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(2, 1);
    return new SimpleDateFormat(e).format(localCalendar.getTime());
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
  
  public static String getNowMonthDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new SimpleDateFormat(e).format(localCalendar.getTime());
  }
  
  public static String getStringByFormat(String paramString1, String paramString2)
  {
    try
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString1));
      paramString1 = new SimpleDateFormat(paramString2).format(localGregorianCalendar.getTime());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String getTime(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(1000L * paramLong));
  }
  
  public static long getTimeLength(String paramString1, String paramString2)
  {
    long l1 = TimeS2L(paramString1, c);
    return TimeS2L(paramString2, c) - l1;
  }
  
  public static long getTimeLength(String paramString1, String paramString2, String paramString3)
  {
    long l1 = TimeS2L(paramString1, paramString3);
    return TimeS2L(paramString2, paramString3) - l1;
  }
  
  public static String getTimeString(long paramLong)
  {
    return new SimpleDateFormat("mm:ss").format(new Date(paramLong));
  }
  
  public static String getTimeString(long paramLong, String paramString)
  {
    return new SimpleDateFormat(paramString).format(new Date(paramLong));
  }
  
  public static String getWeekOfDate(int paramInt)
  {
    return new String[] { "周日", "周一", "周二", "周三", "周四", "周五", "周六" }[(paramInt - 1)];
  }
  
  public static String getWeekOfDate(Date paramDate)
  {
    int m = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int n = localCalendar.get(7) - 1;
    if (n < 0) {}
    for (;;)
    {
      return new String[] { "周日", "周一", "周二", "周三", "周四", "周五", "周六" }[m];
      m = n;
    }
  }
  
  public static String getYearMonth(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return new SimpleDateFormat(e).format(paramDate);
  }
  
  public static boolean isLessThanToday(Date paramDate)
  {
    boolean bool = true;
    if (paramDate == null) {
      return false;
    }
    if (wholePointDate(new Date()).compareTo(wholePointDate(paramDate)) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isTodayDate(Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance(Locale.getDefault());
    return (localCalendar.get(2) == paramCalendar.get(2)) && (localCalendar.get(1) == paramCalendar.get(1)) && (localCalendar.get(5) == paramCalendar.get(5));
  }
  
  public static String nextMonthDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(2, 1);
    return new SimpleDateFormat("yyyy-MM").format(localCalendar.getTime());
  }
  
  public static String secToTime(int paramInt)
  {
    int n = 60;
    if (paramInt <= 0) {
      return "00小时00";
    }
    int m = paramInt / 60;
    if (m < 60) {
      return unitFormat(m) + "分" + unitFormat(paramInt % 60) + "秒";
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
        return unitFormat(m) + "分" + unitFormat(paramInt) + "秒";
        paramInt %= 60;
        new StringBuilder().append(unitFormat(m)).append("分").append(unitFormat(paramInt)).append("秒").toString();
      }
    }
    paramInt = m / 60;
    if (paramInt > 99) {
      return "99小时59分59";
    }
    m %= 60;
    return unitFormat(paramInt) + "小时" + unitFormat(m) + "分";
  }
  
  public static Date strToDate(String paramString1, String paramString2)
  {
    if (ae.isNull(paramString1)) {
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
  
  public static String unitFormat(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 10)) {
      return "0" + Integer.toString(paramInt);
    }
    return "" + paramInt;
  }
  
  public static Date wholePointDate(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTime(paramDate);
    if ((localGregorianCalendar.get(11) == 0) && (localGregorianCalendar.get(12) == 0) && (localGregorianCalendar.get(13) == 0)) {
      return new Date(paramDate.getTime());
    }
    return new Date(paramDate.getTime() - localGregorianCalendar.get(11) * 60 * 60 * 1000 - localGregorianCalendar.get(12) * 60 * 1000 - localGregorianCalendar.get(13) * 1000 - 86400000L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */