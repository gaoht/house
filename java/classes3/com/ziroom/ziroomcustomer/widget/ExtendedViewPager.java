package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class ExtendedViewPager
  extends ViewPager
{
  private boolean a = false;
  
  public ExtendedViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendedViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof TouchImageView)) {
      return ((TouchImageView)paramView).canScrollHorizontallyFroyo(-paramInt1);
    }
    return super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean isLocked()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!this.a) {}
    try
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setLocked(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void toggleLock()
  {
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ExtendedViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */