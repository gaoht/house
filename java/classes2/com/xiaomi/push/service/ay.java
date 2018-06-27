package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.r;
import java.util.Map;

public class ay
{
  public static Runnable a;
  
  private static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("typed_shield_pref", 0).getString(paramString + "_title", paramString);
  }
  
  public static String a(ab paramab)
  {
    paramab = paramab.m().s();
    if (paramab == null) {
      return null;
    }
    return (String)paramab.get("__typed_shield_type");
  }
  
  @TargetApi(19)
  static void a(Context paramContext, ab paramab, Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    String str;
    do
    {
      return;
      str = a(paramab);
    } while ((TextUtils.isEmpty(str)) || (!"com.xiaomi.xmsf".equals(ac.a(paramab))));
    Bundle localBundle = paramNotification.extras;
    paramab = localBundle;
    if (localBundle == null) {
      paramab = new Bundle();
    }
    paramab.putString("miui.category", str);
    paramab.putString("miui.substName", a(paramContext, str));
    paramNotification.extras = paramab;
  }
  
  public static boolean a(Context paramContext, ab paramab)
  {
    if (!"com.xiaomi.xmsf".equals(ac.a(paramab))) {}
    do
    {
      return false;
      paramab = a(paramab);
    } while (TextUtils.isEmpty(paramab));
    paramContext = paramContext.getSharedPreferences("typed_shield_pref", 0);
    if ((!paramContext.contains(paramab + "_shield")) && (a != null)) {
      a.run();
    }
    return paramContext.getBoolean(paramab + "_shield", true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */