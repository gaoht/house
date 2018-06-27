package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

public class al
  extends y
{
  private static final String a = "uop";
  private Context b;
  
  public al(Context paramContext)
  {
    super("uop");
    this.b = paramContext;
  }
  
  public String f()
  {
    String str = "";
    SharedPreferences localSharedPreferences = ba.a(this.b);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("uopdta", "");
    }
    return str;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */