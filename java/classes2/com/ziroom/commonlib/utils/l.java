package com.ziroom.commonlib.utils;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class l
{
  public static final String a;
  public static String b = "";
  private static Boolean c = Boolean.valueOf(true);
  private static Boolean d = Boolean.valueOf(false);
  private static char e = 'v';
  private static String f = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static String g;
  private static int h;
  private static String i;
  private static String j;
  private static SimpleDateFormat k;
  private static SimpleDateFormat l;
  
  static
  {
    a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ziroom/WebLog/";
    g = e.getCurrentTime() + ".txt";
    h = 1;
    i = "ZiroomCustomer";
    j = ".log";
    k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    l = new SimpleDateFormat("yyyyMMdd");
  }
  
  private static Date a()
  {
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.set(5, localCalendar.get(5) - h);
    return localCalendar.getTime();
  }
  
  private static void a(String paramString1, String paramString2, char paramChar)
  {
    if (r.isNull(paramString2)) {}
    for (;;)
    {
      return;
      if (c.booleanValue())
      {
        if (('e' == paramChar) && (('e' == e) || ('v' == e))) {
          Log.e(paramString1, "LogUtil " + paramString2);
        }
        while (d.booleanValue())
        {
          delFile();
          a(String.valueOf(paramChar), paramString1, paramString2);
          return;
          if (('w' == paramChar) && (('w' == e) || ('v' == e))) {
            Log.w(paramString1, "LogUtil " + paramString2);
          } else if (('d' == paramChar) && (('d' == e) || ('v' == e))) {
            Log.d(paramString1, "LogUtil " + paramString2);
          } else if (('i' == paramChar) && (('d' == e) || ('v' == e))) {
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
    String str = l.format(localDate);
    paramString1 = k.format(localDate) + "    " + paramString1 + "    " + paramString2 + "    " + paramString3;
    paramString2 = new File(f, i + str + j);
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
  
  private static void b(com.alibaba.fastjson.e parame)
    throws Exception
  {
    parame.put("time", e.getCurrentTime());
    d("LogUtil printObj", parame.toJSONString());
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(parame.toJSONString());
    parame = new StringWriter();
    new PrintWriter(parame).close();
    localStringBuffer.append(parame.toString());
    parame = new File(a);
    if (!parame.exists()) {
      parame.mkdirs();
    }
    g = e.getCurrentTime() + ".txt";
    parame = new File(parame, g);
    if (parame.exists()) {
      localStringBuffer.insert(0, "\n\n-------------网络日志---------------\n\n");
    }
    try
    {
      parame = new FileOutputStream(parame, true);
      parame.write(localStringBuffer.toString().getBytes());
      parame.close();
      return;
    }
    catch (FileNotFoundException parame)
    {
      parame.printStackTrace();
      return;
    }
    catch (IOException parame)
    {
      parame.printStackTrace();
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
    Object localObject = l.format(a());
    localObject = new File(f, i + (String)localObject + j);
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
  
  public static String generateTag(StackTraceElement paramStackTraceElement)
  {
    String str = paramStackTraceElement.getClassName();
    paramStackTraceElement = String.format("%s.%s(L:%d)", new Object[] { str.substring(str.lastIndexOf(".") + 1), paramStackTraceElement.getMethodName(), Integer.valueOf(paramStackTraceElement.getLineNumber()) });
    if (TextUtils.isEmpty(b)) {
      return paramStackTraceElement;
    }
    return b + ":" + paramStackTraceElement;
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
    int n = 0;
    int i2 = paramString2.length();
    int m = 2000;
    int i1 = 0;
    while (n < 100) {
      if (i2 > m)
      {
        Log.e(paramString1 + "__ziroom__" + n, paramString2.substring(i1, m));
        n += 1;
        i1 = m;
        m += 2000;
      }
      else
      {
        Log.e(paramString1 + "__ziroom__" + n, paramString2.substring(i1, i2));
      }
    }
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
  
  public static void writeWebLog(com.alibaba.fastjson.e parame)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          l.a(this.a);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }).start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */