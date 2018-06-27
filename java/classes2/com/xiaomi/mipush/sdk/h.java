package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.am;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class h
{
  private static ActivityInfo a(PackageManager paramPackageManager, Intent paramIntent, Class<?> paramClass)
  {
    paramPackageManager = paramPackageManager.queryBroadcastReceivers(paramIntent, 16384).iterator();
    while (paramPackageManager.hasNext())
    {
      paramIntent = ((ResolveInfo)paramPackageManager.next()).activityInfo;
      if ((paramIntent != null) && (paramClass.getCanonicalName().equals(paramIntent.name))) {
        return paramIntent;
      }
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    new Thread(new i(paramContext)).start();
  }
  
  private static void a(ActivityInfo paramActivityInfo, Boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean[0].booleanValue() != paramActivityInfo.enabled) {
      throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[] { paramActivityInfo.name, paramArrayOfBoolean[0] }));
    }
    if (paramArrayOfBoolean[1].booleanValue() != paramActivityInfo.exported) {
      throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[] { paramActivityInfo.name, paramArrayOfBoolean[1] }));
    }
  }
  
  private static boolean a(PackageInfo paramPackageInfo, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    paramPackageInfo = paramPackageInfo.services;
    int j = paramPackageInfo.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (a(paramArrayOfString, paramPackageInfo[i].name)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean a(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramString == null)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (TextUtils.equals(paramArrayOfString[i], paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static void c(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    Object localObject2 = new Intent(am.o);
    ((Intent)localObject2).setPackage(str);
    try
    {
      localObject2 = a((PackageManager)localObject1, (Intent)localObject2, Class.forName("com.xiaomi.push.service.receivers.PingReceiver"));
      if (MiPushClient.shouldUseMIUIPush(paramContext)) {
        break label232;
      }
      if (localObject2 != null) {
        break label206;
      }
      throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[] { "com.xiaomi.push.service.receivers.PingReceiver" }));
    }
    catch (ClassNotFoundException paramContext)
    {
      b.a(paramContext);
    }
    paramContext = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    paramContext.setPackage(str);
    paramContext = ((PackageManager)localObject1).queryBroadcastReceivers(paramContext, 16384).iterator();
    int i = 0;
    if (paramContext.hasNext())
    {
      localObject1 = ((ResolveInfo)paramContext.next()).activityInfo;
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(((ActivityInfo)localObject1).name)) && (PushMessageReceiver.class.isAssignableFrom(Class.forName(((ActivityInfo)localObject1).name))))
        {
          boolean bool = ((ActivityInfo)localObject1).enabled;
          if (bool)
          {
            i = 1;
            j = i;
            if (i == 0) {
              continue;
            }
            if (i != 0) {
              break label282;
            }
            throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
            label206:
            a((ActivityInfo)localObject2, new Boolean[] { Boolean.valueOf(true), Boolean.valueOf(false) });
            break;
            label232:
            if (localObject2 == null) {
              break;
            }
            a((ActivityInfo)localObject2, new Boolean[] { Boolean.valueOf(true), Boolean.valueOf(false) });
            break;
          }
        }
        i = 0;
        continue;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        b.a(localClassNotFoundException);
        int j = i;
        i = j;
      }
      label282:
      return;
    }
  }
  
  private static void c(Context paramContext, PackageInfo paramPackageInfo)
  {
    HashSet localHashSet = new HashSet();
    paramContext = paramContext.getPackageName() + ".permission.MIPUSH_RECEIVE";
    localHashSet.addAll(Arrays.asList(new String[] { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", paramContext, "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE", "android.permission.GET_TASKS", "android.permission.VIBRATE" }));
    int j;
    if (paramPackageInfo.permissions != null)
    {
      PermissionInfo[] arrayOfPermissionInfo = paramPackageInfo.permissions;
      j = arrayOfPermissionInfo.length;
      i = 0;
      if (i < j) {
        if (!paramContext.equals(arrayOfPermissionInfo[i].name)) {}
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", new Object[] { paramContext }));
        i += 1;
        break;
      }
      if (paramPackageInfo.requestedPermissions != null)
      {
        paramContext = paramPackageInfo.requestedPermissions;
        j = paramContext.length;
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          paramPackageInfo = paramContext[i];
          if ((!TextUtils.isEmpty(paramPackageInfo)) && (localHashSet.contains(paramPackageInfo)))
          {
            localHashSet.remove(paramPackageInfo);
            if (!localHashSet.isEmpty()) {}
          }
        }
        else
        {
          if (localHashSet.isEmpty()) {
            break;
          }
          throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", new Object[] { localHashSet.iterator().next() }));
        }
        i += 1;
      }
      return;
    }
  }
  
  private static void d(Context paramContext, PackageInfo paramPackageInfo)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
    localHashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
    if (MiPushClient.shouldUseMIUIPush(paramContext))
    {
      if (!a(paramPackageInfo, new String[] { "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService" })) {}
    }
    else
    {
      localHashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
      localHashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
    }
    int j;
    int i;
    if (paramPackageInfo.services != null)
    {
      paramContext = paramPackageInfo.services;
      j = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        paramPackageInfo = paramContext[i];
        if ((!TextUtils.isEmpty(paramPackageInfo.name)) && (localHashMap2.containsKey(paramPackageInfo.name)))
        {
          Object localObject = (b)localHashMap2.remove(paramPackageInfo.name);
          boolean bool1 = ((b)localObject).b;
          boolean bool2 = ((b)localObject).c;
          localObject = ((b)localObject).d;
          if (bool1 != paramPackageInfo.enabled) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[] { paramPackageInfo.name, Boolean.valueOf(bool1) }));
          }
          if (bool2 != paramPackageInfo.exported) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[] { paramPackageInfo.name, Boolean.valueOf(bool2) }));
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.equals((CharSequence)localObject, paramPackageInfo.permission))) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", new Object[] { paramPackageInfo.name, localObject }));
          }
          localHashMap1.put(paramPackageInfo.name, paramPackageInfo.processName);
          if (!localHashMap2.isEmpty()) {}
        }
      }
      else
      {
        if (localHashMap2.isEmpty()) {
          break;
        }
        throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[] { localHashMap2.keySet().iterator().next() }));
      }
      i += 1;
    }
    if (!TextUtils.equals((CharSequence)localHashMap1.get(PushMessageHandler.class.getCanonicalName()), (CharSequence)localHashMap1.get(MessageHandleService.class.getCanonicalName()))) {
      throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", new Object[] { PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName() }));
    }
    if ((localHashMap1.containsKey("com.xiaomi.push.service.XMJobService")) && (localHashMap1.containsKey("com.xiaomi.push.service.XMPushService")) && (!TextUtils.equals((CharSequence)localHashMap1.get("com.xiaomi.push.service.XMJobService"), (CharSequence)localHashMap1.get("com.xiaomi.push.service.XMPushService")))) {
      throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", new Object[] { "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService" }));
    }
  }
  
  public static class a
    extends RuntimeException
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  public static class b
  {
    public String a;
    public boolean b;
    public boolean c;
    public String d;
    
    public b(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
    {
      this.a = paramString1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramString2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */