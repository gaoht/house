package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.security.MessageDigest;

public class UPUtils
{
  public static String a(Context paramContext, String paramString)
  {
    paramString = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(paramString, "");
    paramContext = d.a(paramContext);
    paramString = b(paramString, (paramContext + "23456789abcdef12123456786789abcd").substring(0, 32));
    if (paramString == null) {
      return "";
    }
    if (!paramString.endsWith(paramContext)) {
      return "";
    }
    return paramString.substring(0, paramString.length() - paramContext.length());
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString);
      paramString = a.a(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("utf-8");
      paramString1 = a.a(c.a(a.a(paramString2), paramString1));
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "";
  }
  
  public static void a(Context paramContext, long paramLong, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    String str1 = d.a(paramContext);
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
  
  private static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new String(c.b(a.a(paramString2), a.a(paramString1)), "utf-8").trim();
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "";
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 3).edit();
    paramContext.remove(paramString);
    paramContext.commit();
  }
  
  public static long c(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).getLong(paramString, 0L);
  }
  
  public static native String forConfig(int paramInt, String paramString);
  
  public static native String forUrl(int paramInt);
  
  public static native String forWap(int paramInt, String paramString);
  
  public static native String getIssuer(int paramInt);
  
  public static native String getSubject(int paramInt);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/utils/UPUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */