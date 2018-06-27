package com.huawei.hms.support.api.push.a;

import com.huawei.hms.support.log.LogLevel;
import com.huawei.hms.support.log.d;

public abstract class b
{
  private static d a = null;
  
  public static void a()
  {
    a = d.b("PushLog");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (f()) {
      a.a(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (f()) {
      a.a(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (f()) {
      a.b(paramString1, paramString2);
    }
  }
  
  public static boolean b()
  {
    return (f()) && (a.c(LogLevel.DEBUG));
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (f()) {
      a.c(paramString1, paramString2);
    }
  }
  
  public static boolean c()
  {
    return (f()) && (a.c(LogLevel.INFO));
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (f()) {
      a.d(paramString1, paramString2);
    }
  }
  
  public static boolean d()
  {
    return (f()) && (a.c(LogLevel.WARN));
  }
  
  public static boolean e()
  {
    return (f()) && (a.c(LogLevel.ERROR));
  }
  
  private static boolean f()
  {
    return a != null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */