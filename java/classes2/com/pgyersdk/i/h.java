package com.pgyersdk.i;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class h
{
  public static Boolean a()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 9) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
      return Boolean.valueOf(false);
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}
  }
  
  public static void a(SharedPreferences.Editor paramEditor)
  {
    if (a().booleanValue())
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */