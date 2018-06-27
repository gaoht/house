package com.ziroom.commonlibrary.widget.gridpasswordview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class c
{
  public static int dp2px(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(paramContext.density * f + 0.5D);
  }
  
  public static int px2sp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/gridpasswordview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */