package com.g.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class as
{
  private static volatile as a;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  
  static
  {
    try
    {
      ad.a().register(a());
      a = null;
      b = false;
      c = false;
      d = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static as a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new as();
      }
      return a;
    }
    finally {}
  }
  
  private static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle != null) {
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext()) {
          if (((String)localIterator.next()).equalsIgnoreCase(paramString))
          {
            paramBundle = String.valueOf(paramBundle.get(paramString));
            return paramBundle;
          }
        }
      }
      catch (Throwable paramBundle) {}
    }
    return null;
  }
  
  private void a(Context paramContext, a parama)
  {
    if (!d)
    {
      String str = "TalkingData AppCpa SDK init...\n\tSDK_VERSION is: Android+TD+V4.0.3 gp Type:" + c.b() + "\n\tApp ID is: " + c.a(paramContext, parama) + "\n\tApp Channel is: " + c.a(paramContext) + "\n\tSDK_OVC is: " + "TDOVC+02f8c47c76990b100d7d365a654ea35d+SaaS";
      if ((c.a) || (h.a)) {
        Log.i("TDLog", str);
      }
      str = i.n();
      bp.b().setAppId(c.a(paramContext, parama));
      if (!TextUtils.isEmpty(str)) {
        bm.a().setDeepLink(str);
      }
    }
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      if (z.a(22)) {
        return w.b();
      }
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).processName;
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (Process.myPid() == localRunningAppProcessInfo.pid)
          {
            boolean bool = localRunningAppProcessInfo.processName.equals(paramContext);
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      av.postSDKError(paramContext);
    }
    return false;
  }
  
  private static void b()
  {
    try
    {
      if (i.e() == 0L)
      {
        i.setInitTime(System.currentTimeMillis());
        return;
      }
      if (System.currentTimeMillis() - i.e() > 86400000L)
      {
        z.d = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  private static void c()
  {
    try
    {
      be localbe = new be();
      localbe.b = "env";
      localbe.c = "getProp";
      TreeMap localTreeMap = new TreeMap();
      localTreeMap.put("sysproperty", z.a());
      localbe.d = localTreeMap;
      localbe.a = a.b;
      ad.a().post(localbe);
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public static void sendInitEvent(a parama)
  {
    try
    {
      Object localObject = new TreeMap();
      if (System.currentTimeMillis() - i.e() <= 5000L) {}
      for (boolean bool = true;; bool = false)
      {
        ((Map)localObject).put("first", Boolean.valueOf(bool));
        be localbe = new be();
        localbe.b = "app";
        localbe.c = "init";
        localbe.d = ((Map)localObject);
        localbe.a = parama;
        ad.a().post(localbe);
        localObject = new bd();
        ((bd)localObject).a = parama;
        ((bd)localObject).b = bd.a.a;
        ad.a().post(localObject);
        if (bool) {
          c();
        }
        return;
      }
      return;
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
    }
  }
  
  public final void onTDEBEventInitEvent(db.a parama)
  {
    Object localObject1;
    a locala;
    Object localObject2;
    Object localObject3;
    try
    {
      if (Integer.parseInt(String.valueOf(parama.a.get("apiType"))) != 1) {
        return;
      }
      localObject1 = String.valueOf(parama.a.get("action"));
      locala = (a)parama.a.get("service");
      if ((((String)localObject1).equals("install")) && (locala.b().equals("TRACKING")))
      {
        localObject2 = new be();
        localObject3 = parama.a.get("data");
        ((be)localObject2).b = String.valueOf(parama.a.get("domain"));
        ((be)localObject2).c = ((String)localObject1);
        if ((localObject3 != null) && ((localObject3 instanceof Map))) {
          ((be)localObject2).d = ((Map)localObject3);
        }
        ((be)localObject2).a = locala;
        ad.a().post(localObject2);
        return;
      }
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
      return;
    }
    Context localContext;
    if (((String)localObject1).equals("init"))
    {
      localContext = c.e;
      localObject1 = String.valueOf(parama.a.get("appId"));
      parama = String.valueOf(parama.a.get("channelId"));
      localObject2 = localContext.getPackageManager().getApplicationInfo(localContext.getPackageName(), 128).metaData;
      localObject3 = a((Bundle)localObject2, "TD_APP_ID");
      localObject2 = a((Bundle)localObject2, "TD_CHANNEL_ID");
      if (z.b((String)localObject3)) {
        break label383;
      }
      localObject1 = localObject3;
      if (z.b((String)localObject2)) {
        break label386;
      }
      parama = (db.a)localObject2;
      label258:
      localObject2 = z.a(localContext, "ChannelConfig.json");
      if (z.b((String)localObject2)) {
        break label389;
      }
      parama = (db.a)localObject2;
      label276:
      if (z.b(parama)) {
        break label392;
      }
    }
    for (;;)
    {
      if (z.b((String)localObject1))
      {
        h.eForDeveloper("[SDKInit] TD AppId is null");
        return;
      }
      c.a((String)localObject1, parama, locala);
      aw.a();
      if (a(localContext))
      {
        ao.a();
        ar.a();
        ap.a();
        aq.a();
      }
      b();
      c.a = true;
      if (locala.b().equals("TRACKING")) {
        a(localContext, locala);
      }
      sendInitEvent(locala);
      return;
      if (((String)localObject1).equals("sendInit")) {
        sendInitEvent(locala);
      }
      return;
      label383:
      break;
      label386:
      break label258;
      label389:
      break label276;
      label392:
      parama = "Default";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */