package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class aa
{
  public static void clearPreference(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    paramContext = paramSharedPreferences.edit();
    paramContext.clear();
    paramContext.commit();
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
  }
  
  public static float getFloat(Context paramContext, String paramString, float paramFloat)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat(paramString, paramFloat);
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, paramLong);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString2);
  }
  
  public static boolean hasKey(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).contains(paramString);
  }
  
  public static void putBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static void putFloat(Context paramContext, String paramString, float paramFloat)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putFloat(paramString, paramFloat).commit();
  }
  
  public static void putInt(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void putString(Context paramContext, String paramString1, String paramString2)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramString1, paramString2).commit();
  }
  
  public static void putputtingLong(Context paramContext, String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void removePreference(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */