package com.huawei.hms.support.api.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

public abstract class a
{
  private static int a = -1;
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 18	com/huawei/hms/support/api/push/a/b:b	()Z
    //   8: ifeq +29 -> 37
    //   11: ldc 20
    //   13: new 22	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   20: ldc 27
    //   22: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: getstatic 10	com/huawei/hms/support/api/push/a/a:a	I
    //   28: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 41	com/huawei/hms/support/api/push/a/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iconst_m1
    //   38: getstatic 10	com/huawei/hms/support/api/push/a/a:a	I
    //   41: if_icmpeq +22 -> 63
    //   44: getstatic 10	com/huawei/hms/support/api/push/a/a:a	I
    //   47: istore_1
    //   48: iconst_1
    //   49: iload_1
    //   50: if_icmpne +8 -> 58
    //   53: ldc 2
    //   55: monitorexit
    //   56: iload_2
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_2
    //   60: goto -7 -> 53
    //   63: aload_0
    //   64: invokestatic 44	com/huawei/hms/support/api/push/a/a:c	(Landroid/content/Context;)Z
    //   67: ifeq +19 -> 86
    //   70: iconst_1
    //   71: putstatic 10	com/huawei/hms/support/api/push/a/a:a	I
    //   74: iconst_1
    //   75: getstatic 10	com/huawei/hms/support/api/push/a/a:a	I
    //   78: if_icmpeq -25 -> 53
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -30 -> 53
    //   86: iconst_0
    //   87: putstatic 10	com/huawei/hms/support/api/push/a/a:a	I
    //   90: goto -16 -> 74
    //   93: astore_0
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	Context
    //   47	4	1	i	int
    //   1	82	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	37	93	finally
    //   37	48	93	finally
    //   63	74	93	finally
    //   74	81	93	finally
    //   86	90	93	finally
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      try
      {
        if (paramContext.getPackageManager().getApplicationInfo(paramString, 0) != null)
        {
          if (b.b()) {
            b.a("CommFun", paramString + " is installed");
          }
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    String str = "0.0";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      do
      {
        paramContext = str;
      } while (!b.b());
      b.a("CommFun", "package not exist");
      return "0.0";
    }
    catch (Exception localException)
    {
      do
      {
        paramContext = str;
      } while (!b.b());
      b.a("CommFun", "getApkVersionName error", localException);
    }
    return "0.0";
  }
  
  private static boolean c(Context paramContext)
  {
    if (b.b()) {
      b.a("CommFun", "existFrameworkPush:" + a);
    }
    try
    {
      if (new File("/system/framework/" + "hwpush.jar").isFile())
      {
        if (b.b()) {
          b.a("CommFun", "push jarFile is exist");
        }
        paramContext = paramContext.getPackageManager().queryIntentServices(new Intent().setClassName("android", "com.huawei.android.pushagentproxy.PushService"), 128);
        if ((paramContext == null) || (paramContext.isEmpty()))
        {
          if (b.c())
          {
            b.b("CommFun", "framework push not exist, need vote apk or sdk to support pushservice");
            return false;
          }
        }
        else
        {
          if (b.c()) {
            b.b("CommFun", "framework push exist, use framework push first");
          }
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (b.b()) {
        b.d("CommFun", "get Apk version faild ,Exception e= " + paramContext.toString());
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */