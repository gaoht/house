package cn.dreamtobe.kpswitch.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class e
{
  @TargetApi(16)
  static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return ((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
    }
    return false;
  }
  
  public static boolean isFullScreen(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) != 0;
  }
  
  @TargetApi(19)
  public static boolean isTranslucentStatus(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = bool2;
      if ((paramActivity.getWindow().getAttributes().flags & 0x4000000) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean refreshHeight(View paramView, int paramInt)
  {
    if (paramView.isInEditMode()) {}
    do
    {
      return false;
      Log.d("ViewUtil", String.format("refresh Height %d %d", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramInt) }));
    } while ((paramView.getHeight() == paramInt) || (Math.abs(paramView.getHeight() - paramInt) == d.getStatusBarHeight(paramView.getContext())));
    paramInt = c.getValidPanelHeight(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, paramInt));
    }
    for (;;)
    {
      return true;
      localLayoutParams.height = paramInt;
      paramView.requestLayout();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */