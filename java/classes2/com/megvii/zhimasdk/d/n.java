package com.megvii.zhimasdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class n
{
  private static String a = "PushSharePreference";
  private Context b;
  private String c = "YueSuoPing";
  
  public n(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public String a(String paramString)
  {
    return this.b.getSharedPreferences(this.c, 0).getString(paramString, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.b.getSharedPreferences(this.c, 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */