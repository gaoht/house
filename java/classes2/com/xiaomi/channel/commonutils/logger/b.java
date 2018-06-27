package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b
{
  private static int a = 2;
  private static LoggerInterface b = new a();
  private static final HashMap<Integer, Long> c = new HashMap();
  private static final HashMap<Integer, String> d = new HashMap();
  private static final Integer e = Integer.valueOf(-1);
  private static AtomicInteger f = new AtomicInteger(1);
  
  public static int a()
  {
    return a;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt >= a) {
      b.log(paramString);
    }
  }
  
  public static void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt >= a) {
      b.log(paramString, paramThrowable);
    }
  }
  
  public static void a(int paramInt, Throwable paramThrowable)
  {
    if (paramInt >= a) {
      b.log("", paramThrowable);
    }
  }
  
  public static void a(LoggerInterface paramLoggerInterface)
  {
    b = paramLoggerInterface;
  }
  
  public static void a(Integer paramInteger)
  {
    if ((a > 1) || (!c.containsKey(paramInteger))) {
      return;
    }
    long l1 = ((Long)c.remove(paramInteger)).longValue();
    paramInteger = (String)d.remove(paramInteger);
    long l2 = System.currentTimeMillis();
    b.log(paramInteger + " ends in " + (l2 - l1) + " ms");
  }
  
  public static void a(String paramString)
  {
    a(2, "[Thread:" + Thread.currentThread().getId() + "] " + paramString);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    a(4, paramString, paramThrowable);
  }
  
  public static void a(Throwable paramThrowable)
  {
    a(4, paramThrowable);
  }
  
  public static void b(String paramString)
  {
    a(0, paramString);
  }
  
  public static void c(String paramString)
  {
    a(1, "[Thread:" + Thread.currentThread().getId() + "] " + paramString);
  }
  
  public static void d(String paramString)
  {
    a(4, paramString);
  }
  
  public static Integer e(String paramString)
  {
    if (a <= 1)
    {
      Integer localInteger = Integer.valueOf(f.incrementAndGet());
      c.put(localInteger, Long.valueOf(System.currentTimeMillis()));
      d.put(localInteger, paramString);
      b.log(paramString + " starts");
      return localInteger;
    }
    return e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/logger/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */