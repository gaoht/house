package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class PreferenceUtils
{
  public static String a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0);
    Object localObject1 = localSharedPreferences.getString("uid", "");
    Object localObject2 = localSharedPreferences.getString("tag1", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (((String)localObject1).length() == 32) {
        if (!c.a((String)localObject1)) {}
      }
      for (;;)
      {
        localObject2 = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject2).remove("uid");
        ((SharedPreferences.Editor)localObject2).commit();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          a(paramContext, (String)localObject1, "tag1");
        }
        return (String)localObject1;
        localObject1 = "";
        continue;
        localObject2 = e(paramContext, (String)localObject1);
        if (((String)localObject2).length() == 32)
        {
          localObject1 = localObject2;
          if (c.a((String)localObject2)) {}
        }
        else
        {
          localObject1 = "";
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      return e(paramContext, (String)localObject2);
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return e(paramContext, paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(paramString, ""));
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("utf-8");
      paramString1 = b.a(d.a(b.a(paramString2), paramString1));
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    String str1 = e.c(paramContext);
    String str2 = (str1 + "23456789abcdef12123456786789abcd").substring(0, 32);
    str1 = a(paramString1 + str1, str2);
    paramString1 = str1;
    if (str1 == null) {
      paramString1 = "";
    }
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
    paramContext.putString(paramString2, paramString1);
    paramContext.commit();
  }
  
  public static String b(Context paramContext)
  {
    return b(paramContext, "last_pay_method", "tag2");
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0);
    String str = localSharedPreferences.getString(paramString1, "");
    paramString2 = localSharedPreferences.getString(paramString2, "");
    if (!TextUtils.isEmpty(str))
    {
      paramContext = localSharedPreferences.edit();
      paramContext.remove(paramString1);
      paramContext.commit();
    }
    while (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    return e(paramContext, paramString2);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new String(d.b(b.a(paramString2), b.a(paramString1)), "utf-8").trim();
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "";
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "tag1");
  }
  
  public static String c(Context paramContext)
  {
    return b(paramContext, "last_user", "tag3");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "tag2");
  }
  
  public static void d(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "tag3");
  }
  
  public static native String decPrefData(String paramString1, String paramString2);
  
  private static String e(Context paramContext, String paramString)
  {
    paramContext = e.c(paramContext);
    paramString = b(paramString, (paramContext + "23456789abcdef12123456786789abcd").substring(0, 32));
    if (paramString == null) {
      return "";
    }
    if (!paramString.endsWith(paramContext)) {
      return "";
    }
    return paramString.substring(0, paramString.length() - paramContext.length());
  }
  
  public static native String forConfig(int paramInt, String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/PreferenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */