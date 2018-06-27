package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.reflect.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if ((!com.xiaomi.channel.commonutils.misc.b.a(paramContext)) && (paramContext.get(0) != null) && (((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity != null))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getPackageName();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      return null;
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
      if (paramContext != null) {
        return paramContext.versionName;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a(paramContext);
        paramContext = null;
      }
    }
    return "1.0";
  }
  
  public static int b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
      if (paramContext != null) {
        return paramContext.versionCode;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a(paramContext);
        paramContext = null;
      }
    }
    return 0;
  }
  
  public static boolean b(Context paramContext)
  {
    return TextUtils.equals(paramContext.getPackageName(), a(paramContext));
  }
  
  public static int c(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int i = Process.myPid();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  @TargetApi(19)
  public static a d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (Build.VERSION.SDK_INT < 19)) {
      return a.a;
    }
    try
    {
      Integer localInteger = (Integer)a.a(AppOpsManager.class, "OP_POST_NOTIFICATION");
      if (localInteger == null) {
        return a.a;
      }
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      paramContext = (Integer)a.a((AppOpsManager)paramContext.getSystemService("appops"), "checkOpNoThrow", new Object[] { localInteger, Integer.valueOf(localApplicationInfo.uid), paramString });
      if ((paramContext != null) && (paramContext.intValue() == 0)) {
        return a.b;
      }
      paramContext = a.c;
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return a.a;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        String[] arrayOfString = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).pkgList;
        int i = 0;
        label74:
        if ((arrayOfString != null) && (i < arrayOfString.length)) {
          if (!paramContext.contains(arrayOfString[i]))
          {
            paramContext.add(arrayOfString[i]);
            if (paramContext.size() != 1) {
              break label148;
            }
            localStringBuilder.append(((String)paramContext.get(0)).hashCode() % 100000);
          }
        }
        for (;;)
        {
          i += 1;
          break label74;
          break;
          label148:
          localStringBuilder.append("#").append(arrayOfString[i].hashCode() % 100000);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static Signature[] e(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 64).signatures;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static boolean f(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 8192);
      if (paramContext == null) {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return true;
  }
  
  public static enum a
  {
    private final int d;
    
    private a(int paramInt)
    {
      this.d = paramInt;
    }
    
    public int a()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */