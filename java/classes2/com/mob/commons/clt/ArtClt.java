package com.mob.commons.clt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.d;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ArtClt
  extends a
  implements PublicMemberKeeper
{
  private boolean a(long paramLong)
  {
    for (;;)
    {
      HashMap localHashMap1;
      int i;
      try
      {
        localObject1 = MobSDK.getContext().getSystemService("usagestats");
        if (localObject1 == null) {
          return false;
        }
        ReflectHelper.importClass("android.app.usage.UsageStatsManager");
        List localList = null;
        if (Build.VERSION.SDK_INT >= 21) {
          localList = (List)ReflectHelper.invokeInstanceMethod(localObject1, "queryUsageStats", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        }
        if ((Build.VERSION.SDK_INT >= 28) || ((localList != null) && (!localList.isEmpty()))) {
          break label691;
        }
        localObject1 = ReflectHelper.invokeInstanceMethod(ReflectHelper.getInstanceField(localObject1, "mService"), "queryUsageStats", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()), "com.android.settings" });
        if (localObject1 == null) {
          break label691;
        }
        localList = (List)ReflectHelper.invokeInstanceMethod(localObject1, "getList", new Object[0]);
        if ((localList == null) || (localList.isEmpty())) {
          break label694;
        }
        long l1 = d.f();
        long l2 = com.mob.commons.a.a();
        if ((l1 > 0L) && (l2 < l1)) {
          return true;
        }
        localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        i = localList.size();
        ReflectHelper.importClass("android.app.usage.UsageStats");
        i -= 1;
        if (i >= 0)
        {
          Object localObject6 = localList.get(i);
          if (Build.VERSION.SDK_INT < 21) {
            break label696;
          }
          l1 = ((Long)ReflectHelper.invokeInstanceMethod(localObject6, "getLastTimeUsed", new Object[0])).longValue();
          if (l1 <= 0L) {
            break label696;
          }
          String str = (String)ReflectHelper.invokeInstanceMethod(localObject6, "getPackageName", new Object[0]);
          if (a(str)) {
            break label696;
          }
          localObject1 = (Long)localHashMap2.get(str);
          if ((localObject1 != null) && (((Long)localObject1).longValue() > l1)) {
            break label696;
          }
          localHashMap2.put(str, Long.valueOf(l1));
          Object localObject3 = ReflectHelper.invokeInstanceMethod(localObject6, "getFirstTimeStamp", new Object[0]);
          Object localObject4 = ReflectHelper.invokeInstanceMethod(localObject6, "getLastTimeStamp", new Object[0]);
          Object localObject5 = ReflectHelper.invokeInstanceMethod(localObject6, "getTotalTimeInForeground", new Object[0]);
          Object localObject2 = null;
          localObject1 = null;
          if (Build.VERSION.SDK_INT < 28)
          {
            localObject1 = ReflectHelper.getInstanceField(localObject6, "mLaunchCount");
            localObject2 = ReflectHelper.getInstanceField(localObject6, "mLastEvent");
          }
          localObject6 = new HashMap();
          ((HashMap)localObject6).put("packageName", str);
          ((HashMap)localObject6).put("firstTimeStamp", localObject3);
          ((HashMap)localObject6).put("lastTimeStamp", localObject4);
          ((HashMap)localObject6).put("lastTimeUsed", Long.valueOf(l1));
          ((HashMap)localObject6).put("totalTimeInForeground", localObject5);
          if (localObject1 != null) {
            ((HashMap)localObject6).put("launchCount", localObject1);
          }
          if (localObject2 != null) {
            ((HashMap)localObject6).put("lastEvent", localObject2);
          }
          localHashMap1.put(str, localObject6);
        }
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
        return false;
      }
      if (localHashMap1.isEmpty()) {
        return false;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = localHashMap1.entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(((Map.Entry)((Iterator)localObject1).next()).getValue());
      }
      if (localArrayList.size() > 0)
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("type", "XM_APP_RUNTIMES");
        ((HashMap)localObject1).put("list", localArrayList);
        ((HashMap)localObject1).put("datetime", Long.valueOf(com.mob.commons.a.a()));
        b.a().a(com.mob.commons.a.a(), (HashMap)localObject1);
        d.c(com.mob.commons.a.a() + paramLong);
        return true;
        label691:
        continue;
        label694:
        return false;
        label696:
        i -= 1;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = MobSDK.getContext().getPackageManager().getPackageInfo(paramString, 0);
      int i;
      if ((paramString.applicationInfo.flags & 0x1) == 1)
      {
        i = 1;
        j = paramString.applicationInfo.flags;
        if ((j & 0x80) != 1) {
          break label68;
        }
      }
      label68:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
        i = 0;
        break;
      }
      return true;
    }
    catch (Throwable paramString) {}
  }
  
  protected File a()
  {
    return c.a("comm/locks/.artc_lock");
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    long l = com.mob.commons.a.w();
    if ((l > 0L) && (a(l)))
    {
      a(1, l);
      return;
    }
    d();
  }
  
  protected boolean b()
  {
    return com.mob.commons.a.w() > 0L;
  }
  
  protected void c()
  {
    b(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/ArtClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */