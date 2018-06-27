package com.g.a;

import android.content.Context;
import android.os.Handler;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  public static boolean a = false;
  public static AtomicBoolean b = new AtomicBoolean(false);
  public static final Map c = new TreeMap();
  public static boolean d = false;
  public static Context e = null;
  public static Handler f = null;
  public static long g = 0L;
  public static boolean h = false;
  public static boolean i = true;
  public static boolean j = true;
  public static String k = "";
  public static String l = "Default";
  public static boolean m = false;
  public static boolean n = false;
  public static int o = 2;
  public static long p = 30000L;
  
  public static String a(Context paramContext)
  {
    if ((z.b(l)) || (l.equals("Default"))) {
      l = v.b(paramContext, "TD_app_pefercen_profile", "TD_channelId", "Default");
    }
    return l;
  }
  
  public static String a(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null))
    {
      h.dForInternal(new String[] { "Context or Service is null" });
      return "";
    }
    if (!z.b(k)) {
      return k;
    }
    return v.b(paramContext, "TD_app_pefercen_profile", "TD_appId_" + parama.b(), "");
  }
  
  private static void a(int paramInt)
  {
    try
    {
      bs localbs = new bs();
      switch (paramInt)
      {
      }
      for (;;)
      {
        localbs.setFrameWork("Native");
        return;
        localbs.setFrameWork("Cocos2d");
        return;
        localbs.setFrameWork("Unity");
        return;
        localbs.setFrameWork("AIR");
        return;
        localbs.setFrameWork("PhoneGap");
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(String paramString, a parama)
  {
    if (parama != null) {
      v.a(e, "TD_app_pefercen_profile", "TD_appId_" + parama.b(), paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, a parama)
  {
    if (e != null) {
      f = new Handler(e.getMainLooper());
    }
    Object localObject;
    if ((paramString1 != null) && (!paramString1.trim().isEmpty()) && (paramString1.contains("-"))) {
      localObject = null;
    }
    try
    {
      paramString1 = paramString1.split("-")[1];
      for (k = paramString1;; k = paramString1)
      {
        if ((paramString2 != null) && (!paramString2.trim().isEmpty())) {
          l = paramString2;
        }
        a(k, parama);
        setChannelId(l);
        bp.b().a(k, parama);
        a(cf.a);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        paramString1 = (String)localObject;
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    try
    {
      long l1 = v.b(e, "TD_app_pefercen_profile", "isDeveloper", 0L);
      if (l1 != 0L) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static String b()
  {
    try
    {
      String str = new bs().b();
      return str;
    }
    catch (Throwable localThrowable) {}
    return "Native";
  }
  
  public static void setChannelId(String paramString)
  {
    v.a(e, "TD_app_pefercen_profile", "TD_channelId", paramString);
  }
  
  public static void setDeveloperMode(boolean paramBoolean)
  {
    try
    {
      Context localContext = e;
      if (paramBoolean) {}
      for (long l1 = 1L;; l1 = 0L)
      {
        v.a(localContext, "TD_app_pefercen_profile", "isDeveloper", l1);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */