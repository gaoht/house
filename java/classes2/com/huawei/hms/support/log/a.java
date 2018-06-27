package com.huawei.hms.support.log;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class a
  extends f
{
  private static a c = new a();
  private String d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  
  public a(String paramString1, String paramString2, LogLevel paramLogLevel)
  {
    super(paramString2, 409600L);
    this.a = paramLogLevel;
    this.d = paramString1;
    try
    {
      a();
      c();
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("AndroidLogger", "AndroidLogger init error", paramString1);
    }
  }
  
  public static void a()
  {
    if (!c.isAlive()) {
      c.start();
    }
  }
  
  private void b(String paramString1, LogLevel paramLogLevel, String paramString2)
  {
    if (!c(paramLogLevel)) {
      return;
    }
    paramString1 = this.d + "." + paramString1;
    switch (paramLogLevel.value())
    {
    default: 
      Log.w(paramString1, "[" + paramLogLevel.toString() + "] " + paramString2);
      return;
    case 2: 
      Log.v(paramString1, paramString2);
      return;
    case 3: 
      Log.d(paramString1, paramString2);
      return;
    case 4: 
      Log.i(paramString1, paramString2);
      return;
    case 5: 
      Log.w(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  private void c()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.util.Log");
        bool1 = localClass.getField("HWLog").getBoolean(null);
        boolean bool3 = localClass.getField("HWModuleLog").getBoolean(null);
        if (!bool1) {
          if ((bool3) && (Log.isLoggable(this.d, 3)))
          {
            break label139;
            this.e = bool1;
            if (localClass.getField("HWINFO").getBoolean(null)) {
              break label144;
            }
            bool1 = bool2;
            if (bool3)
            {
              bool1 = bool2;
              if (Log.isLoggable(this.d, 4)) {
                break label144;
              }
            }
            this.f = bool1;
          }
          else
          {
            bool1 = false;
            continue;
          }
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        Log.w("AndroidLogger", "reading configuration error:" + localException.getMessage());
        return;
      }
      label139:
      continue;
      label144:
      boolean bool1 = true;
    }
  }
  
  private boolean c(LogLevel paramLogLevel)
  {
    switch (paramLogLevel.value())
    {
    case 2: 
    default: 
      return false;
    case 3: 
      return this.e;
    case 4: 
      return this.f;
    }
    return this.g;
  }
  
  public void a(e parame)
  {
    c.a(new b(parame, this));
  }
  
  public boolean a(LogLevel paramLogLevel)
  {
    return this.a.value() <= paramLogLevel.value();
  }
  
  public void b(e parame)
  {
    try
    {
      String str = parame.e();
      b(parame.b, parame.c, str);
      a(parame.b, parame.c, parame.d() + str);
      return;
    }
    catch (OutOfMemoryError parame)
    {
      Log.e("AndroidLogger", "write error");
    }
  }
  
  public static class a
    extends com.huawei.hms.support.log.b.a
  {
    private BlockingQueue<a.b> a = new LinkedBlockingQueue();
    
    public a()
    {
      super();
    }
    
    public void a(a.b paramb)
    {
      this.a.offer(paramb);
    }
    
    protected boolean a()
    {
      return true;
    }
    
    protected boolean b()
    {
      try
      {
        Object localObject = (a.b)this.a.poll(3L, TimeUnit.SECONDS);
        if (localObject != null) {
          if (!e.a(((a.b)localObject).a))
          {
            ((a.b)localObject).b.b(((a.b)localObject).a);
          }
          else
          {
            localObject = ((a.b)localObject).a;
            if (localObject != null) {
              return false;
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return true;
    }
    
    protected void c() {}
  }
  
  public static class b
  {
    e a;
    f b;
    
    public b(e parame, f paramf)
    {
      if ((parame == null) && (paramf == null)) {
        throw new NullPointerException("record and logger is null");
      }
      this.b = paramf;
      this.a = parame;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/log/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */