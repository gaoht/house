package com.growingio.android.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;

public class PersistUtil
{
  private static SharedPreferences a;
  
  public static String a()
  {
    return a.getString("device_id", null);
  }
  
  public static void a(int paramInt)
  {
    a.edit().remove("cs" + paramInt).commit();
  }
  
  public static void a(int paramInt, String paramString)
  {
    a.edit().putString("cs" + paramInt, paramString).commit();
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext.getSharedPreferences("growing_persist_data", 0);
  }
  
  public static void a(SparseArray<String> paramSparseArray)
  {
    int i = 0;
    while (i < 10)
    {
      String str = a.getString("cs" + i, null);
      if (!TextUtils.isEmpty(str)) {
        paramSparseArray.put(i, str);
      }
      i += 1;
    }
  }
  
  public static void a(String paramString)
  {
    a.edit().putString("device_id", paramString).commit();
  }
  
  public static String b()
  {
    return a.getString("host_info", null);
  }
  
  public static void b(String paramString)
  {
    a.edit().putString("host_info", paramString).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/PersistUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */