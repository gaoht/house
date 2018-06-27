package in.srain.cube.views.ptr.b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class b
{
  public static int a;
  public static int b;
  public static float c;
  public static int d;
  public static int e;
  
  public static int designedDP2px(float paramFloat)
  {
    float f = paramFloat;
    if (d != 320) {
      f = d * paramFloat / 320.0F;
    }
    return dp2px(f);
  }
  
  public static int dp2px(float paramFloat)
  {
    return (int)(c * paramFloat + 0.5F);
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    a = localDisplayMetrics.widthPixels;
    b = localDisplayMetrics.heightPixels;
    c = localDisplayMetrics.density;
    d = (int)(a / localDisplayMetrics.density);
    e = (int)(b / localDisplayMetrics.density);
  }
  
  public static void setPadding(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramView.setPadding(designedDP2px(paramFloat1), dp2px(paramFloat2), designedDP2px(paramFloat3), dp2px(paramFloat4));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */