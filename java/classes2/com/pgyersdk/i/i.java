package com.pgyersdk.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class i
{
  private static SharedPreferences a = null;
  
  public static String a(Context paramContext, String paramString)
  {
    if (a == null) {
      a = paramContext.getSharedPreferences("pgyersdk", 0);
    }
    return a.getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a == null) {
      a = paramContext.getSharedPreferences("pgyersdk", 0);
    }
    a.edit().putString(paramString1, paramString2).commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a == null) {
      return;
    }
    a.edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */