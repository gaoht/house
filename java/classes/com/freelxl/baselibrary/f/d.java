package com.freelxl.baselibrary.f;

import android.os.Environment;
import android.util.Log;
import com.freelxl.baselibrary.b.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class d
{
  private static Boolean a = c.getInstance().LogSwitch();
  private static Boolean b = Boolean.valueOf(false);
  private static char c = 'v';
  private static String d = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static int e = 1;
  private static String f = "ZiroomCustomer";
  private static String g = ".log";
  private static SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static SimpleDateFormat i = new SimpleDateFormat("yyyyMMdd");
  
  private static Date a()
  {
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.set(5, localCalendar.get(5) - e);
    return localCalendar.getTime();
  }
  
  private static void a(String paramString1, String paramString2, char paramChar)
  {
    if (f.isNull(paramString2)) {}
    for (;;)
    {
      return;
      if (a.booleanValue())
      {
        if (('e' == paramChar) && (('e' == c) || ('v' == c))) {
          Log.e(paramString1, "LogUtil " + paramString2);
        }
        while (b.booleanValue())
        {
          delFile();
          a(String.valueOf(paramChar), paramString1, paramString2);
          return;
          if (('w' == paramChar) && (('w' == c) || ('v' == c))) {
            Log.w(paramString1, "LogUtil " + paramString2);
          } else if (('d' == paramChar) && (('d' == c) || ('v' == c))) {
            Log.d(paramString1, "LogUtil " + paramString2);
          } else if (('i' == paramChar) && (('d' == c) || ('v' == c))) {
            Log.i(paramString1, "LogUtil " + paramString2);
          } else {
            Log.v(paramString1, "LogUtil " + paramString2);
          }
        }
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    Date localDate = new Date();
    String str = i.format(localDate);
    paramString1 = h.format(localDate) + "    " + paramString1 + "    " + paramString2 + "    " + paramString3;
    paramString2 = new File(d, f + str + g);
    try
    {
      paramString2 = new FileWriter(paramString2, true);
      paramString3 = new BufferedWriter(paramString2);
      paramString3.write(paramString1);
      paramString3.newLine();
      paramString3.close();
      paramString2.close();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void d(String paramString, Object paramObject)
  {
    a(paramString, paramObject.toString(), 'd');
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 'd');
  }
  
  public static void delFile()
  {
    Object localObject = i.format(a());
    localObject = new File(d, f + (String)localObject + g);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  public static void e(String paramString, Object paramObject)
  {
    a(paramString, paramObject.toString(), 'e');
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 'e');
  }
  
  public static void i(String paramString, Object paramObject)
  {
    a(paramString, paramObject.toString(), 'i');
  }
  
  public static void i(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 'i');
  }
  
  public static void logBigData(String paramString1, String paramString2)
  {
    int k = 0;
    if (!a.booleanValue()) {}
    int n;
    int m;
    for (;;)
    {
      return;
      n = paramString2.length();
      int j = 2000;
      m = 0;
      while (k < 100)
      {
        if (n <= j) {
          break label87;
        }
        Log.e(paramString1 + "_ymq__" + k, paramString2.substring(m, j));
        k += 1;
        m = j;
        j += 2000;
      }
    }
    label87:
    Log.e(paramString1 + "_ymq__" + k, paramString2.substring(m, n));
  }
  
  public static void v(String paramString, Object paramObject)
  {
    a(paramString, paramObject.toString(), 'v');
  }
  
  public static void v(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 'v');
  }
  
  public static void w(String paramString, Object paramObject)
  {
    a(paramString, paramObject.toString(), 'w');
  }
  
  public static void w(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 'w');
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */