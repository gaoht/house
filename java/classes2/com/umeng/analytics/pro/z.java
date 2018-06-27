package com.umeng.analytics.pro;

import android.content.Context;
import android.provider.Settings.Secure;

public class z
  extends y
{
  private static final String a = "android_id";
  private Context b;
  
  public z(Context paramContext)
  {
    super("android_id");
    this.b = paramContext;
  }
  
  public String f()
  {
    try
    {
      String str = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */