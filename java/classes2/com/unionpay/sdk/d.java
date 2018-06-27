package com.unionpay.sdk;

import android.content.Context;
import android.os.Handler;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.TreeMap;

final class d
{
  static final Map a = new TreeMap();
  static boolean b = false;
  static Context c = null;
  static Handler d = null;
  static FileChannel e;
  static long f = 0L;
  static String g = "";
  static String h = "";
  static String i = "Default";
  static long j;
  static long k = 30000L;
  
  static String a(Context paramContext)
  {
    if (r.b(g)) {
      g = l.b(paramContext, "UP_app_pefercen_profile", "UP_appId", "");
    }
    return g;
  }
  
  static void a(String paramString1, String paramString2)
  {
    if (c != null) {
      d = new Handler(c.getMainLooper());
    }
    Object localObject;
    if ((paramString1 != null) && (!paramString1.trim().isEmpty()) && (paramString1.contains("-"))) {
      localObject = null;
    }
    try
    {
      paramString1 = paramString1.split("-")[1];
      for (g = paramString1;; g = paramString1)
      {
        ag.d();
        if ((paramString2 != null) && (!paramString2.trim().isEmpty())) {
          i = paramString2;
        }
        paramString1 = new StringBuilder();
        paramString1.append("Analytics SDK Initializing...");
        paramString1.append("\n\tSDK_VERSION is: ");
        paramString1.append("Android+UP+V2.2.8");
        paramString1.append("\n\tApp ID is: ");
        paramString1.append(g);
        paramString1.append("\n\tApp Channel is: ");
        paramString1.append(i);
        k.a(paramString1.toString());
        l.a(c, "UP_app_pefercen_profile", "UP_appId", g);
        l.a(c, "UP_app_pefercen_profile", "UP_channelId", i);
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
  
  static String b(Context paramContext)
  {
    if ((r.b(i)) || (i.equals("Default"))) {
      i = l.b(paramContext, "UP_app_pefercen_profile", "UP_channelId", "");
    }
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */