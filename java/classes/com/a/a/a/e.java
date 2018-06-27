package com.a.a.a;

import com.a.a.a;
import com.a.a.c;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public final class e
{
  public static a parse(String paramString)
    throws c
  {
    return parse(paramString, new l());
  }
  
  public static a parse(String paramString, a parama)
    throws c
  {
    int n = 0;
    if (paramString == null) {
      throw new c("Parameter must not be null", 4);
    }
    if (paramString.length() == 0) {}
    label25:
    int j;
    int i;
    int k;
    int m;
    while (!paramString.hasNext())
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return parama;
                paramString = new i(paramString);
                if (paramString.ch(0) == '-') {
                  paramString.skip();
                }
                j = paramString.gatherInt("Invalid year in date string", 9999);
                if ((paramString.hasNext()) && (paramString.ch() != '-')) {
                  throw new c("Invalid date string, after year", 5);
                }
                i = j;
                if (paramString.ch(0) == '-') {
                  i = -j;
                }
                parama.setYear(i);
              } while (!paramString.hasNext());
              paramString.skip();
              i = paramString.gatherInt("Invalid month in date string", 12);
              if ((paramString.hasNext()) && (paramString.ch() != '-')) {
                throw new c("Invalid date string, after month", 5);
              }
              parama.setMonth(i);
            } while (!paramString.hasNext());
            paramString.skip();
            i = paramString.gatherInt("Invalid day in date string", 31);
            if ((paramString.hasNext()) && (paramString.ch() != 'T')) {
              throw new c("Invalid date string, after day", 5);
            }
            parama.setDay(i);
          } while (!paramString.hasNext());
          paramString.skip();
          parama.setHour(paramString.gatherInt("Invalid hour in date string", 23));
        } while (!paramString.hasNext());
        if (paramString.ch() == ':')
        {
          paramString.skip();
          i = paramString.gatherInt("Invalid minute in date string", 59);
          if ((paramString.hasNext()) && (paramString.ch() != ':') && (paramString.ch() != 'Z') && (paramString.ch() != '+') && (paramString.ch() != '-')) {
            throw new c("Invalid date string, after minute", 5);
          }
          parama.setMinute(i);
        }
      } while (!paramString.hasNext());
      if ((!paramString.hasNext()) || (paramString.ch() != ':')) {
        break;
      }
      paramString.skip();
      i = paramString.gatherInt("Invalid whole seconds in date string", 59);
      if ((paramString.hasNext()) && (paramString.ch() != '.') && (paramString.ch() != 'Z') && (paramString.ch() != '+') && (paramString.ch() != '-')) {
        throw new c("Invalid date string, after whole seconds", 5);
      }
      parama.setSecond(i);
      if (paramString.ch() == '.')
      {
        paramString.skip();
        i = paramString.pos();
        j = paramString.gatherInt("Invalid fractional seconds in date string", 999999999);
        if ((paramString.hasNext()) && (paramString.ch() != 'Z') && (paramString.ch() != '+') && (paramString.ch() != '-')) {
          throw new c("Invalid date string, after fractional second", 5);
        }
        i = paramString.pos() - i;
        for (;;)
        {
          k = i;
          m = j;
          if (i <= 9) {
            break;
          }
          j /= 10;
          i -= 1;
        }
        while (k < 9)
        {
          m *= 10;
          k += 1;
        }
        parama.setNanoSecond(m);
      }
    }
    if (paramString.ch() == 'Z')
    {
      paramString.skip();
      i = 0;
      j = 0;
      k = n;
    }
    for (;;)
    {
      parama.setTimeZone(new SimpleTimeZone((i * 60 * 1000 + k * 3600 * 1000) * j, ""));
      if (!paramString.hasNext()) {
        break label25;
      }
      throw new c("Invalid date string, extra chars at end", 5);
      if ((paramString.ch() == 'Z') || (paramString.ch() == '+') || (paramString.ch() == '-')) {
        break;
      }
      throw new c("Invalid date string, after time", 5);
      if (paramString.hasNext())
      {
        if (paramString.ch() == '+') {}
        for (i = 1;; i = -1)
        {
          paramString.skip();
          k = paramString.gatherInt("Invalid time zone hour in date string", 23);
          if (!paramString.hasNext()) {
            break label789;
          }
          if (paramString.ch() != ':') {
            break label778;
          }
          paramString.skip();
          m = paramString.gatherInt("Invalid time zone minute in date string", 59);
          j = i;
          i = m;
          break;
          if (paramString.ch() != '-') {
            break label767;
          }
        }
        label767:
        throw new c("Time zone must begin with 'Z', '+', or '-'", 5);
        label778:
        throw new c("Invalid date string, after time zone hour", 5);
        label789:
        j = i;
        i = 0;
      }
      else
      {
        i = 0;
        j = 0;
        k = n;
      }
    }
  }
  
  public static String render(a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    DecimalFormat localDecimalFormat;
    int j;
    if (parama.hasDate())
    {
      localDecimalFormat = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.ENGLISH));
      localStringBuffer.append(localDecimalFormat.format(parama.getYear()));
      if (parama.getMonth() == 0) {
        return localStringBuffer.toString();
      }
      localDecimalFormat.applyPattern("'-'00");
      localStringBuffer.append(localDecimalFormat.format(parama.getMonth()));
      if (parama.getDay() == 0) {
        return localStringBuffer.toString();
      }
      localStringBuffer.append(localDecimalFormat.format(parama.getDay()));
      if (parama.hasTime())
      {
        localStringBuffer.append('T');
        localDecimalFormat.applyPattern("00");
        localStringBuffer.append(localDecimalFormat.format(parama.getHour()));
        localStringBuffer.append(':');
        localStringBuffer.append(localDecimalFormat.format(parama.getMinute()));
        if ((parama.getSecond() != 0) || (parama.getNanoSecond() != 0))
        {
          double d1 = parama.getSecond();
          double d2 = parama.getNanoSecond() / 1.0E9D;
          localDecimalFormat.applyPattern(":00.#########");
          localStringBuffer.append(localDecimalFormat.format(d1 + d2));
        }
        if (parama.hasTimeZone())
        {
          long l = parama.getCalendar().getTimeInMillis();
          j = parama.getTimeZone().getOffset(l);
          if (j != 0) {
            break label309;
          }
          localStringBuffer.append('Z');
        }
      }
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label309:
      int i = j / 3600000;
      j = Math.abs(j % 3600000 / 60000);
      localDecimalFormat.applyPattern("+00;-00");
      localStringBuffer.append(localDecimalFormat.format(i));
      localDecimalFormat.applyPattern(":00");
      localStringBuffer.append(localDecimalFormat.format(j));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */