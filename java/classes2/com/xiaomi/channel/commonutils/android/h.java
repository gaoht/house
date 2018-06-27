package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.util.Map;

public abstract class h
{
  public static void a(Context paramContext) {}
  
  public static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (paramString1 != null) && (paramString2 != null)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */