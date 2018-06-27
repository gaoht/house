package com.ziroom.ziroomcustomer.ziroomstation.carouselimg;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BaseViewPager
  extends ViewPager
{
  private boolean a = true;
  
  public BaseViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/carouselimg/BaseViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */