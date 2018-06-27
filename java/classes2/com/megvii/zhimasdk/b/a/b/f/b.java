package com.megvii.zhimasdk.b.a.b.f;

import com.megvii.zhimasdk.b.a.o.a;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class b
{
  public static final TimeZone a;
  private static final String[] b = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
  private static final Date c;
  
  static
  {
    a = TimeZone.getTimeZone("GMT");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeZone(a);
    localCalendar.set(2000, 0, 1, 0, 0, 0);
    localCalendar.set(14, 0);
    c = localCalendar.getTime();
  }
  
  public static Date a(String paramString, String[] paramArrayOfString)
  {
    return a(paramString, paramArrayOfString, null);
  }
  
  public static Date a(String paramString, String[] paramArrayOfString, Date paramDate)
  {
    a.a(paramString, "Date value");
    label15:
    String str;
    int j;
    int i;
    if (paramArrayOfString != null)
    {
      if (paramDate == null) {
        break label125;
      }
      str = paramString;
      if (paramString.length() > 1)
      {
        str = paramString;
        if (paramString.startsWith("'"))
        {
          str = paramString;
          if (paramString.endsWith("'")) {
            str = paramString.substring(1, paramString.length() - 1);
          }
        }
      }
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label139;
      }
      Object localObject = a.a(paramArrayOfString[i]);
      ((SimpleDateFormat)localObject).set2DigitYearStart(paramDate);
      paramString = new ParsePosition(0);
      localObject = ((SimpleDateFormat)localObject).parse(str, paramString);
      if (paramString.getIndex() != 0)
      {
        return (Date)localObject;
        paramArrayOfString = b;
        break;
        label125:
        paramDate = c;
        break label15;
      }
      i += 1;
    }
    label139:
    return null;
  }
  
  static final class a
  {
    private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> a = new ThreadLocal()
    {
      protected SoftReference<Map<String, SimpleDateFormat>> a()
      {
        return new SoftReference(new HashMap());
      }
    };
    
    public static SimpleDateFormat a(String paramString)
    {
      Object localObject = (Map)((SoftReference)a.get()).get();
      if (localObject == null)
      {
        localObject = new HashMap();
        a.set(new SoftReference(localObject));
      }
      for (;;)
      {
        SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)((Map)localObject).get(paramString);
        SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
        if (localSimpleDateFormat2 == null)
        {
          localSimpleDateFormat1 = new SimpleDateFormat(paramString, Locale.US);
          localSimpleDateFormat1.setTimeZone(TimeZone.getTimeZone("GMT"));
          ((Map)localObject).put(paramString, localSimpleDateFormat1);
        }
        return localSimpleDateFormat1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */