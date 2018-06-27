package com.mob;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.mob.commons.MobProductCollector;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import java.util.HashMap;

public class MobSDK
  implements PublicMemberKeeper
{
  private static Context a;
  private static String b;
  private static String c;
  
  private static void a(String paramString1, String paramString2)
  {
    Object localObject2;
    if (paramString1 != null)
    {
      localObject3 = paramString1;
      str = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      localObject2 = null;
    }
    try
    {
      localObject1 = a.getPackageManager().getPackageInfo(a.getPackageName(), 128).applicationInfo.metaData;
      localObject2 = localObject1;
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      for (;;) {}
    }
    localObject1 = paramString1;
    if (paramString1 == null)
    {
      localObject1 = paramString1;
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("Mob-AppKey");
      }
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = paramString2;
      if (localObject2 != null) {
        paramString1 = ((Bundle)localObject2).getString("Mob-AppSecret");
      }
    }
    Object localObject3 = localObject1;
    String str = paramString1;
    if (paramString1 == null)
    {
      localObject3 = localObject1;
      str = paramString1;
      if (localObject2 != null)
      {
        str = ((Bundle)localObject2).getString("Mob-AppSeret");
        localObject3 = localObject1;
      }
    }
    b = (String)localObject3;
    c = str;
  }
  
  private static boolean a()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length <= 0)) {
          continue;
        }
        int j = arrayOfStackTraceElement.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        localStackTraceElement = arrayOfStackTraceElement[i];
        str = localStackTraceElement.getClassName();
        if (!"android.app.Instrumentation".equals(str)) {
          continue;
        }
        bool1 = "callApplicationOnCreate".equals(localStackTraceElement.getMethodName());
        if (!bool1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        int i;
        StackTraceElement localStackTraceElement;
        String str;
        boolean bool3;
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      if (!bool1) {
        Log.e("MobSDK", "Please invoke MobSDK.init(context) method in your application onCreate()");
      }
      return bool1;
      if ("android.app.ActivityThread".equals(str))
      {
        bool3 = "handleBindApplication".equals(localStackTraceElement.getMethodName());
        bool1 = bool2;
        if (bool3) {}
      }
      else
      {
        i += 1;
      }
    }
  }
  
  public static void addUserWatcher(MobUser.UserWatcher paramUserWatcher)
  {
    if (paramUserWatcher != null) {}
    try
    {
      MobUser.a(paramUserWatcher);
      return;
    }
    finally
    {
      paramUserWatcher = finally;
      throw paramUserWatcher;
    }
  }
  
  private static void b()
  {
    
    try
    {
      new MobSDK.1().start();
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  public static void clearUser()
  {
    try
    {
      MobUser.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static HashMap<String, String> exchangeIds(String[] paramArrayOfString)
  {
    return MobUser.a(paramArrayOfString);
  }
  
  public static String getAppSecret()
  {
    return c;
  }
  
  public static String getAppkey()
  {
    return b;
  }
  
  public static Context getContext()
  {
    if (a == null) {}
    try
    {
      Object localObject = DeviceHelper.currentActivityThread();
      if (localObject != null)
      {
        localObject = (Context)ReflectHelper.invokeInstanceMethod(localObject, "getApplication", new Object[0]);
        if (localObject != null) {
          init((Context)localObject);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().w(localThrowable);
      }
    }
    return a;
  }
  
  public static void getUser(MobUser.OnUserGotListener paramOnUserGotListener)
  {
    try
    {
      MobUser.a(new MobSDK.2(paramOnUserGotListener));
      return;
    }
    finally
    {
      paramOnUserGotListener = finally;
      throw paramOnUserGotListener;
    }
  }
  
  public static void init(Context paramContext)
  {
    try
    {
      init(paramContext, null, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void init(Context paramContext, String paramString)
  {
    try
    {
      init(paramContext, paramString, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (a == null)
      {
        a = paramContext.getApplicationContext();
        a(paramString1, paramString2);
        a.a();
        a();
        b();
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static final boolean isMob()
  {
    return com.mob.commons.a.b();
  }
  
  public static void removeUserWatcher(MobUser.UserWatcher paramUserWatcher)
  {
    if (paramUserWatcher != null) {}
    try
    {
      MobUser.b(paramUserWatcher);
      return;
    }
    finally
    {
      paramUserWatcher = finally;
      throw paramUserWatcher;
    }
  }
  
  public static void setUser(String paramString1, String paramString2, String paramString3, HashMap<String, Object> paramHashMap)
  {
    try
    {
      setUser(paramString1, paramString2, paramString3, paramHashMap, null);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void setUser(String paramString1, String paramString2, String paramString3, HashMap<String, Object> paramHashMap, String paramString4)
  {
    try
    {
      MobUser.a(paramString1, paramString2, paramString3, paramHashMap, paramString4);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/mob/MobSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */