package cn.dreamtobe.kpswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class b
{
  private static volatile SharedPreferences a;
  
  private static SharedPreferences a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = paramContext.getSharedPreferences("keyboard.common", 0);
      }
      return a;
    }
    finally {}
  }
  
  public static int get(Context paramContext, int paramInt)
  {
    return a(paramContext).getInt("sp.key.keyboard.height", paramInt);
  }
  
  public static boolean save(Context paramContext, int paramInt)
  {
    return a(paramContext).edit().putInt("sp.key.keyboard.height", paramInt).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */