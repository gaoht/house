package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.reflect.a;
import com.xiaomi.channel.commonutils.string.d;

public class e
{
  private static String a = null;
  private static String b = null;
  private static String c = null;
  
  public static String a()
  {
    String str = null;
    if (Build.VERSION.SDK_INT > 8) {
      str = Build.SERIAL;
    }
    return str;
  }
  
  public static String a(Context paramContext)
  {
    if (b == null)
    {
      String str1 = c(paramContext);
      paramContext = b(paramContext);
      String str2 = a();
      b = "a-" + d.b(new StringBuilder().append(str1).append(paramContext).append(str2).toString());
    }
    return b;
  }
  
  @TargetApi(17)
  public static int b()
  {
    if (Build.VERSION.SDK_INT < 17) {}
    Object localObject;
    do
    {
      return -1;
      localObject = a.a("android.os.UserHandle", "myUserId", new Object[0]);
    } while (localObject == null);
    return ((Integer)Integer.class.cast(localObject)).intValue();
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      b.a(paramContext);
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    int i = 10;
    String str = d(paramContext);
    for (;;)
    {
      if ((str == null) && (i > 0)) {
        try
        {
          Thread.sleep(500L);
          str = d(paramContext);
          i -= 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    }
    return localInterruptedException;
  }
  
  public static String d(Context paramContext)
  {
    if (a != null)
    {
      paramContext = a;
      return paramContext;
    }
    for (;;)
    {
      try
      {
        if (g.a())
        {
          Object localObject = a.a("miui.telephony.TelephonyManager", "getDefault", new Object[0]);
          if (localObject != null)
          {
            localObject = a.a(localObject, "getMiuiDeviceId", new Object[0]);
            if ((localObject != null) && ((localObject instanceof String)))
            {
              str = (String)String.class.cast(localObject);
              localObject = str;
              if (str == null)
              {
                localObject = str;
                if (h(paramContext)) {
                  localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
                }
              }
              paramContext = (Context)localObject;
              if (localObject == null) {
                break;
              }
              a = (String)localObject;
              return (String)localObject;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        b.a(paramContext);
        return null;
      }
      String str = null;
    }
  }
  
  /* Error */
  public static String e(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/xiaomi/channel/commonutils/android/e:c	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 16	com/xiaomi/channel/commonutils/android/e:c	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 34	com/xiaomi/channel/commonutils/android/e:b	(Landroid/content/Context;)Ljava/lang/String;
    //   22: astore_0
    //   23: invokestatic 36	com/xiaomi/channel/commonutils/android/e:a	()Ljava/lang/String;
    //   26: astore_1
    //   27: new 38	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   34: aload_0
    //   35: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 55	com/xiaomi/channel/commonutils/string/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   48: putstatic 16	com/xiaomi/channel/commonutils/android/e:c	Ljava/lang/String;
    //   51: getstatic 16	com/xiaomi/channel/commonutils/android/e:c	Ljava/lang/String;
    //   54: astore_0
    //   55: goto -42 -> 13
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    //   26	13	1	str	String
    // Exception table:
    //   from	to	target	type
    //   3	13	58	finally
    //   18	55	58	finally
  }
  
  public static String f(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperatorName();
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      b.a(paramContext);
    }
    return null;
  }
  
  private static boolean h(Context paramContext)
  {
    String str = paramContext.getPackageName();
    return paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", str) == 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */