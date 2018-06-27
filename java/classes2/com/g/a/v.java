package com.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class v
{
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      paramContext.getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramContext.getSharedPreferences(paramString1, 0).edit().putString(paramString2, paramString3).commit();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static long b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l = paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, paramLong);
      return l;
    }
    catch (Throwable paramContext) {}
    return paramLong;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return paramString3;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/g/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */