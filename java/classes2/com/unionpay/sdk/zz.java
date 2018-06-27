package com.unionpay.sdk;

import android.app.Activity;
import android.content.Context;
import java.util.Map;

public final class zz
  implements y
{
  private static volatile zz a = null;
  
  public zz()
  {
    a = this;
  }
  
  /* Error */
  static zz a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/unionpay/sdk/zz:a	Lcom/unionpay/sdk/zz;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 12	com/unionpay/sdk/zz:a	Lcom/unionpay/sdk/zz;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/unionpay/sdk/zz
    //   21: dup
    //   22: invokespecial 18	com/unionpay/sdk/zz:<init>	()V
    //   25: putstatic 12	com/unionpay/sdk/zz:a	Lcom/unionpay/sdk/zz;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 12	com/unionpay/sdk/zz:a	Lcom/unionpay/sdk/zz;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localzz	zz
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   41	46	46	finally
  }
  
  public final void a(Activity paramActivity)
  {
    try
    {
      ag.a(paramActivity);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      ag.a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      ag.a(paramContext, paramString1, paramString2);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Map paramMap)
  {
    try
    {
      ag.a(paramContext, paramString1, paramString2, paramMap);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final void a(Context paramContext, Throwable paramThrowable)
  {
    try
    {
      ag.a(paramContext, paramThrowable);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final String b(Context paramContext)
  {
    try
    {
      paramContext = ag.b(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public final void b(Activity paramActivity)
  {
    try
    {
      ag.b(paramActivity);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    try
    {
      d.b = paramBoolean;
      if (UPAgent.LOG_ON) {
        k.a("[PreSettings] setReportUncaughtExceptions: " + paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void onPageEnd(Context paramContext, String paramString)
  {
    try
    {
      ag.b(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final void onPageStart(Context paramContext, String paramString)
  {
    try
    {
      ag.a(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final void onResume(Activity paramActivity, String paramString1, String paramString2)
  {
    try
    {
      ag.a(paramActivity, paramString1, paramString2);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/zz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */