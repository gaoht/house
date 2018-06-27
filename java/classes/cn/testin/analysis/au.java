package cn.testin.analysis;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class au
{
  private static Integer a;
  private static Boolean b;
  
  public static int a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramSharedPreferences != null)
    {
      i = paramInt;
      if (!TextUtils.isEmpty(paramString)) {
        i = paramSharedPreferences.getInt(paramString, paramInt);
      }
    }
    return i;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("TESTIN_AB", 0);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return a(a(paramContext), paramString);
  }
  
  public static String a(SharedPreferences paramSharedPreferences, String paramString)
  {
    return b(paramSharedPreferences, paramString, "");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a = Integer.valueOf(paramInt);
    b(b(paramContext), "appStatus", paramInt);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(a(paramContext), paramString1, paramString2);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    if (paramSharedPreferences == null) {}
    while (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramSharedPreferences.edit().remove(paramString1).apply();
      return;
    }
    paramSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = b(a.d);
    int j = localSharedPreferences.getInt(paramString + "ApiTimes", -1);
    int i = localSharedPreferences.getInt(paramString + "ApiInterval", -1);
    if ((j == -1) || (i == -1)) {
      return;
    }
    j = localSharedPreferences.getInt(paramString + "ApiCurTimes", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (!paramBoolean) {
      localEditor.putInt(paramString + "ApiCurTimes", j - 1);
    }
    for (;;)
    {
      localEditor.apply();
      return;
      long l1 = localSharedPreferences.getLong(paramString + "ApiLastTime", 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > i)
      {
        localEditor.putLong(paramString + "ApiLastTime", l2);
        localEditor.putInt(paramString + "ApiCurTimes", 1);
      }
      else
      {
        localEditor.putInt(paramString + "ApiCurTimes", j + 1);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = b(a.d);
    int i = localSharedPreferences.getInt(paramString + "ApiTimes", -1);
    int j = localSharedPreferences.getInt(paramString + "ApiInterval", -1);
    if ((i == -1) || (j == -1)) {}
    long l;
    do
    {
      return true;
      l = localSharedPreferences.getLong(paramString + "ApiLastTime", 0L);
    } while ((System.currentTimeMillis() - l > j) || (localSharedPreferences.getInt(paramString + "ApiCurTimes", 0) < i));
    return false;
  }
  
  public static int b(SharedPreferences paramSharedPreferences, String paramString)
  {
    return a(paramSharedPreferences, paramString, 0);
  }
  
  public static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences("TESTIN_AB_EXP" + a.e, 0);
  }
  
  public static String b(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramSharedPreferences != null)
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        str = paramSharedPreferences.getString(paramString1, paramString2);
      }
    }
    return str;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(a(paramContext), "DID", paramString);
  }
  
  public static void b(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    if (paramSharedPreferences == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  public static SharedPreferences c(Context paramContext)
  {
    return paramContext.getSharedPreferences("visualeditor.changes" + a.e, 0);
  }
  
  public static String d(Context paramContext)
  {
    return a(a(paramContext), "DID");
  }
  
  public static int e(Context paramContext)
  {
    if (a == null) {
      a = Integer.valueOf(b(b(paramContext), "appStatus"));
    }
    return a.intValue();
  }
  
  public static boolean f(Context paramContext)
  {
    int i = e(paramContext);
    return (i == 10009) || (i == 10005);
  }
  
  public static void g(Context paramContext)
  {
    paramContext = a(paramContext);
    if (!paramContext.contains("isFirstStart")) {}
    for (boolean bool = true;; bool = false)
    {
      b = Boolean.valueOf(bool);
      paramContext.edit().putBoolean("isFirstStart", b.booleanValue()).apply();
      return;
    }
  }
  
  public static boolean h(Context paramContext)
  {
    if (b == null) {
      if (a(paramContext).contains("isFirstStart")) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      b = Boolean.valueOf(bool);
      return b.booleanValue();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */