package com.a.a.a;

import com.a.a.a;
import com.a.a.c;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class l
  implements a
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private TimeZone g = null;
  private int h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  
  public l() {}
  
  public l(String paramString)
    throws c
  {
    e.parse(paramString, this);
  }
  
  public l(Calendar paramCalendar)
  {
    Date localDate = paramCalendar.getTime();
    paramCalendar = paramCalendar.getTimeZone();
    GregorianCalendar localGregorianCalendar = (GregorianCalendar)Calendar.getInstance(Locale.US);
    localGregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
    localGregorianCalendar.setTimeZone(paramCalendar);
    localGregorianCalendar.setTime(localDate);
    this.a = localGregorianCalendar.get(1);
    this.b = (localGregorianCalendar.get(2) + 1);
    this.c = localGregorianCalendar.get(5);
    this.d = localGregorianCalendar.get(11);
    this.e = localGregorianCalendar.get(12);
    this.f = localGregorianCalendar.get(13);
    this.h = (localGregorianCalendar.get(14) * 1000000);
    this.g = localGregorianCalendar.getTimeZone();
    this.k = true;
    this.j = true;
    this.i = true;
  }
  
  public l(Date paramDate, TimeZone paramTimeZone)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(paramTimeZone);
    localGregorianCalendar.setTime(paramDate);
    this.a = localGregorianCalendar.get(1);
    this.b = (localGregorianCalendar.get(2) + 1);
    this.c = localGregorianCalendar.get(5);
    this.d = localGregorianCalendar.get(11);
    this.e = localGregorianCalendar.get(12);
    this.f = localGregorianCalendar.get(13);
    this.h = (localGregorianCalendar.get(14) * 1000000);
    this.g = paramTimeZone;
    this.k = true;
    this.j = true;
    this.i = true;
  }
  
  public int compareTo(Object paramObject)
  {
    long l = getCalendar().getTimeInMillis() - ((a)paramObject).getCalendar().getTimeInMillis();
    if (l != 0L) {
      return (int)Math.signum((float)l);
    }
    return (int)Math.signum((float)(this.h - ((a)paramObject).getNanoSecond()));
  }
  
  public Calendar getCalendar()
  {
    GregorianCalendar localGregorianCalendar = (GregorianCalendar)Calendar.getInstance(Locale.US);
    localGregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
    if (this.k) {
      localGregorianCalendar.setTimeZone(this.g);
    }
    localGregorianCalendar.set(1, this.a);
    localGregorianCalendar.set(2, this.b - 1);
    localGregorianCalendar.set(5, this.c);
    localGregorianCalendar.set(11, this.d);
    localGregorianCalendar.set(12, this.e);
    localGregorianCalendar.set(13, this.f);
    localGregorianCalendar.set(14, this.h / 1000000);
    return localGregorianCalendar;
  }
  
  public int getDay()
  {
    return this.c;
  }
  
  public int getHour()
  {
    return this.d;
  }
  
  public String getISO8601String()
  {
    return e.render(this);
  }
  
  public int getMinute()
  {
    return this.e;
  }
  
  public int getMonth()
  {
    return this.b;
  }
  
  public int getNanoSecond()
  {
    return this.h;
  }
  
  public int getSecond()
  {
    return this.f;
  }
  
  public TimeZone getTimeZone()
  {
    return this.g;
  }
  
  public int getYear()
  {
    return this.a;
  }
  
  public boolean hasDate()
  {
    return this.i;
  }
  
  public boolean hasTime()
  {
    return this.j;
  }
  
  public boolean hasTimeZone()
  {
    return this.k;
  }
  
  public void setDay(int paramInt)
  {
    if (paramInt < 1) {
      this.c = 1;
    }
    for (;;)
    {
      this.i = true;
      return;
      if (paramInt > 31) {
        this.c = 31;
      } else {
        this.c = paramInt;
      }
    }
  }
  
  public void setHour(int paramInt)
  {
    this.d = Math.min(Math.abs(paramInt), 23);
    this.j = true;
  }
  
  public void setMinute(int paramInt)
  {
    this.e = Math.min(Math.abs(paramInt), 59);
    this.j = true;
  }
  
  public void setMonth(int paramInt)
  {
    if (paramInt < 1) {
      this.b = 1;
    }
    for (;;)
    {
      this.i = true;
      return;
      if (paramInt > 12) {
        this.b = 12;
      } else {
        this.b = paramInt;
      }
    }
  }
  
  public void setNanoSecond(int paramInt)
  {
    this.h = paramInt;
    this.j = true;
  }
  
  public void setSecond(int paramInt)
  {
    this.f = Math.min(Math.abs(paramInt), 59);
    this.j = true;
  }
  
  public void setTimeZone(TimeZone paramTimeZone)
  {
    this.g = paramTimeZone;
    this.j = true;
    this.k = true;
  }
  
  public void setYear(int paramInt)
  {
    this.a = Math.min(Math.abs(paramInt), 9999);
    this.i = true;
  }
  
  public String toString()
  {
    return getISO8601String();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */