package com.xiaomi.push.service.timers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.android.j;

public final class a
{
  private static a a;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 11	com/xiaomi/push/service/timers/a:a	Lcom/xiaomi/push/service/timers/a$a;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 11	com/xiaomi/push/service/timers/a:a	Lcom/xiaomi/push/service/timers/a$a;
    //   18: invokeinterface 13 1 0
    //   23: goto -12 -> 11
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	locala	a
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	26	finally
    //   15	23	26	finally
  }
  
  public static void a(Context paramContext)
  {
    int k = 0;
    paramContext = paramContext.getApplicationContext();
    if ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))
    {
      a = new b(paramContext);
      return;
    }
    Object localObject1 = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject1).getPackageInfo(paramContext.getPackageName(), 4);
        j = k;
        if (((PackageInfo)localObject1).services != null)
        {
          localObject1 = ((PackageInfo)localObject1).services;
          int m = localObject1.length;
          i = 0;
          j = k;
          if (i < m)
          {
            Object localObject2 = localObject1[i];
            if (!"com.xiaomi.push.service.XMJobService".equals(((ServiceInfo)localObject2).name)) {
              continue;
            }
            boolean bool = "android.permission.BIND_JOB_SERVICE".equals(((ServiceInfo)localObject2).permission);
            if (!bool) {
              continue;
            }
            j = 1;
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        com.xiaomi.channel.commonutils.logger.b.a("check service err : " + localException.getMessage());
        int j = k;
        continue;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        a = new b(paramContext);
      }
      if ((j != 0) || (!j.b(paramContext))) {
        continue;
      }
      throw new RuntimeException("Should export service: com.xiaomi.push.service.XMJobService with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
      i += 1;
    }
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 11	com/xiaomi/push/service/timers/a:a	Lcom/xiaomi/push/service/timers/a$a;
    //   6: ifnonnull +12 -> 18
    //   9: ldc 111
    //   11: invokestatic 102	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: getstatic 11	com/xiaomi/push/service/timers/a:a	Lcom/xiaomi/push/service/timers/a$a;
    //   21: iload_0
    //   22: invokeinterface 113 2 0
    //   27: goto -13 -> 14
    //   30: astore_1
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramBoolean	boolean
    //   30	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	14	30	finally
    //   18	27	30	finally
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 11	com/xiaomi/push/service/timers/a:a	Lcom/xiaomi/push/service/timers/a$a;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +10 -> 18
    //   11: iconst_0
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: getstatic 11	com/xiaomi/push/service/timers/a:a	Lcom/xiaomi/push/service/timers/a$a;
    //   21: invokeinterface 116 1 0
    //   26: istore_0
    //   27: goto -14 -> 13
    //   30: astore_1
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	15	0	bool	boolean
    //   6	2	1	locala	a
    //   30	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	30	finally
    //   18	27	30	finally
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
    
    public abstract boolean b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/timers/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */