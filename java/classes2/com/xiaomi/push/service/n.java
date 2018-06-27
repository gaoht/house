package com.xiaomi.push.service;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.Locale;

public class n
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final int g;
  
  public n(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramInt;
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = Class.forName("miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return ("com.xiaomi.xmsf".equals(paramContext.getPackageName())) && (a());
  }
  
  private static boolean b(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.xiaomi.xmsf");
  }
  
  public ak.b a(XMPushService paramXMPushService)
  {
    ak.b localb = new ak.b(paramXMPushService);
    a(localb, paramXMPushService, paramXMPushService.e(), "c");
    return localb;
  }
  
  public ak.b a(ak.b paramb, Context paramContext, b paramb1, String paramString)
  {
    paramb.a = paramContext.getPackageName();
    paramb.b = this.a;
    paramb.i = this.c;
    paramb.c = this.b;
    paramb.h = "5";
    paramb.d = "XMPUSH-PASS";
    paramb.e = false;
    String str = "";
    if (b(paramContext)) {
      str = com.xiaomi.channel.commonutils.android.b.d(paramContext);
    }
    paramb.f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s", new Object[] { "sdk_ver", Integer.valueOf(26), "cpvn", "3_2_3", "cpvc", Integer.valueOf(30203), "aapn", str });
    if (b(paramContext)) {}
    for (str = "1000271";; str = this.d)
    {
      paramb.g = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", new Object[] { "appid", str, "locale", Locale.getDefault().toString(), "miid", k.a(paramContext).c() });
      if (a(paramContext)) {
        paramb.g += String.format(",%1$s:%2$s", new Object[] { "ab", paramString });
      }
      paramb.k = paramb1;
      return paramb;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */