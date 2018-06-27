package cn.dreamtobe.kpswitch.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

public class d
{
  private static boolean a = false;
  private static int b = 50;
  
  public static int getStatusBarHeight(Context paramContext)
  {
    try
    {
      if (!a)
      {
        i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i > 0)
        {
          b = paramContext.getResources().getDimensionPixelSize(i);
          a = true;
          Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", new Object[] { Integer.valueOf(b) }));
        }
      }
      int i = b;
      return i;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */