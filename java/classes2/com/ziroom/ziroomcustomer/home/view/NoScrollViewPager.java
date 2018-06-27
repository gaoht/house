package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;

public class NoScrollViewPager
  extends ViewPager
{
  public NoScrollViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public NoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getCurrentItem() == 0) {}
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    View localView = getChildAt(getCurrentItem());
    if (localView != null)
    {
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      paramInt2 = localView.getMeasuredHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    if (paramFloat == 0.0F) {
      requestLayout();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getCurrentItem() == 0) {}
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/NoScrollViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */