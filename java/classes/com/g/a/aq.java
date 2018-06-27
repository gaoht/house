package com.g.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class aq
{
  private static volatile aq a;
  private static Map b = new TreeMap();
  
  private aq()
  {
    try
    {
      if (b())
      {
        c();
        d();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public static aq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aq();
      }
      return a;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (z.a(21))
      {
        localObject1 = w.a().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (e)((Iterator)localObject1).next();
          if ((!((e)localObject2).c.startsWith("android.")) && (!((e)localObject2).c.equals("system"))) {
            localArrayList.add(((e)localObject2).c);
          }
        }
      }
      localObject2 = (ActivityManager)c.e.getSystemService("activity");
    }
    catch (Throwable localThrowable1)
    {
      av.postSDKError(localThrowable1);
      return;
    }
    Object localObject1 = c.e.getPackageManager();
    Object localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next()).processName;
        try
        {
          if (((PackageManager)localObject1).getLaunchIntentForPackage(str2) != null) {
            localThrowable1.add(str2);
          }
        }
        catch (Throwable localThrowable2) {}
      }
    }
    String str1 = localThrowable1.toString();
    b.put("ras", str1);
    i.setCollectRunningTime(System.currentTimeMillis());
  }
  
  private void d()
  {
    be localbe = new be();
    localbe.b = "env";
    localbe.c = "apps";
    localbe.d = b;
    localbe.a = a.b;
    ad.a().post(localbe);
  }
  
  boolean b()
  {
    try
    {
      long l1 = i.g();
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > 10800000L) {
        return true;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */