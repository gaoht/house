package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ScrollControlerViewPager
  extends ViewPager
{
  private boolean a = false;
  
  public ScrollControlerViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollControlerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setCurrentItem(int paramInt)
  {
    super.setCurrentItem(paramInt);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    super.setCurrentItem(paramInt, paramBoolean);
  }
  
  public void setNoScroll(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ScrollControlerViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */