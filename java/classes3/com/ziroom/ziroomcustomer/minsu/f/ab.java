package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.util.ae;

public class ab
{
  private static Layout a(TextView paramTextView, String paramString)
  {
    return new StaticLayout(paramString, paramTextView.getPaint(), paramTextView.getWidth() - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, paramTextView.getLineSpacingMultiplier(), paramTextView.getLineSpacingExtra(), false);
  }
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int getLineCountFromText(String paramString, TextView paramTextView)
  {
    if ((paramTextView == null) || (ae.isNull(paramString))) {
      return 0;
    }
    return a(paramTextView, paramString).getLineCount();
  }
  
  public static float length(TextView paramTextView, String paramString)
  {
    return paramTextView.getPaint().measureText(paramString);
  }
  
  public static int px2dp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void width(View paramView, int paramInt)
  {
    paramView.getLayoutParams().width = paramInt;
  }
  
  public static void widthHeight(View paramView, int paramInt)
  {
    paramView.getLayoutParams().width = paramInt;
    paramView.getLayoutParams().height = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */