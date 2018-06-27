package com.a.a;

import com.a.a.a.l;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class b
{
  private static final TimeZone a = TimeZone.getTimeZone("UTC");
  
  public static a convertToLocalTime(a parama)
  {
    long l = parama.getCalendar().getTimeInMillis();
    parama = new GregorianCalendar();
    parama.setTimeInMillis(l);
    return new l(parama);
  }
  
  public static a convertToUTCTime(a parama)
  {
    long l = parama.getCalendar().getTimeInMillis();
    parama = new GregorianCalendar(a);
    parama.setGregorianChange(new Date(Long.MIN_VALUE));
    parama.setTimeInMillis(l);
    return new l(parama);
  }
  
  public static a create()
  {
    return new l();
  }
  
  public static a create(int paramInt1, int paramInt2, int paramInt3)
  {
    l locall = new l();
    locall.setYear(paramInt1);
    locall.setMonth(paramInt2);
    locall.setDay(paramInt3);
    return locall;
  }
  
  public static a create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    l locall = new l();
    locall.setYear(paramInt1);
    locall.setMonth(paramInt2);
    locall.setDay(paramInt3);
    locall.setHour(paramInt4);
    locall.setMinute(paramInt5);
    locall.setSecond(paramInt6);
    locall.setNanoSecond(paramInt7);
    return locall;
  }
  
  public static a createFromCalendar(Calendar paramCalendar)
  {
    return new l(paramCalendar);
  }
  
  public static a createFromISO8601(String paramString)
    throws c
  {
    return new l(paramString);
  }
  
  public static a getCurrentDateTime()
  {
    return new l(new GregorianCalendar());
  }
  
  public static a setLocalTimeZone(a parama)
  {
    parama = parama.getCalendar();
    parama.setTimeZone(TimeZone.getDefault());
    return new l(parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */