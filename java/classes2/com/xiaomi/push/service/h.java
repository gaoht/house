package com.xiaomi.push.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.metok.geofencing.a;
import com.xiaomi.xmpush.thrift.j;
import java.util.ArrayList;
import java.util.Iterator;

public class h
{
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = e.a(paramContext).b(paramString);
    if ((localObject == null) || (((ArrayList)localObject).size() < 1)) {}
    for (;;)
    {
      return;
      if (e.a(paramContext).e(paramString) == 0) {
        b.a("appIsUninstalled. failed to delete geofencing with package name. name:" + paramString);
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        if (localj == null)
        {
          b.a("appIsUninstalled. failed to find geofence with package name. name:" + paramString);
          return;
        }
        a(localj.a(), paramContext);
        if (g.a(paramContext).b(localj.a()) == 0) {
          b.a("appIsUninstalled. failed to delete geoMessage with package name. name:" + paramString + ", geoId:" + localj.a());
        }
      }
    }
  }
  
  public static void a(String paramString, Context paramContext)
  {
    new a(paramContext).a(paramContext, "com.xiaomi.xmsf", paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.xiaomi.metok", 8192);
      if ((paramContext != null) && (paramContext.versionCode >= 20)) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    return TextUtils.equals(paramContext.getPackageName(), "com.xiaomi.xmsf");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */