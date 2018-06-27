package com.huawei.hms.support.log;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private static Map<String, d> a = new HashMap();
  private static String b = "log.log";
  private static LogLevel c = LogLevel.INFO;
  private a d = null;
  private String e;
  private final g f = new g();
  
  public static void a(LogLevel paramLogLevel)
  {
    c = paramLogLevel;
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  private void a(String paramString1, String paramString2, LogLevel paramLogLevel, String paramString3, Throwable paramThrowable)
  {
    paramString1 = new e.a(paramString1, paramLogLevel).a(this.e).a(this.f.a()).a();
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.a("[").a(paramString3).a("]");
    }
    paramString1.a(paramString2);
    if (paramThrowable != null) {
      paramString1.b(paramThrowable);
    }
    paramString1.a(this.d);
  }
  
  public static d b(String paramString)
  {
    try
    {
      paramString = f(b, paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static d f(String paramString1, String paramString2)
  {
    try
    {
      Log.i("LogAdaptor", "createAppLog, file:" + paramString1 + ", module:" + paramString2);
      d locald2 = (d)a.get(paramString2);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d();
        locald1.g(paramString1, paramString2);
        locald1.b(c);
        a.put(paramString2, locald1);
      }
      return locald1;
    }
    finally {}
  }
  
  private void g(String paramString1, String paramString2)
  {
    this.e = paramString2;
    this.d = new a(paramString2, paramString1, LogLevel.INFO);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, LogLevel.DEBUG, null, null);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramString1, paramString2, LogLevel.ERROR, null, paramThrowable);
  }
  
  public void b(LogLevel paramLogLevel)
  {
    this.d.b(paramLogLevel);
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, LogLevel.INFO, null, null);
  }
  
  public void c(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, LogLevel.WARN, null, null);
  }
  
  public boolean c(LogLevel paramLogLevel)
  {
    return this.d.a(paramLogLevel);
  }
  
  public void d(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, LogLevel.ERROR, null, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/log/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */