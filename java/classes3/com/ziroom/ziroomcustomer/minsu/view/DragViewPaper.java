package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class DragViewPaper
  extends ViewPager
{
  private ViewGroup a;
  private boolean b = true;
  private double c;
  private double d;
  private double e;
  private double f;
  
  public DragViewPaper(Context paramContext)
  {
    super(paramContext);
  }
  
  public DragViewPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setControlMove(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.c = f1;
      this.d = f2;
      return;
    }
    this.e = f1;
    this.f = f2;
    if (Math.abs(this.d - this.f) >= Math.abs(this.c - this.e)) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      if ((this.a == null) || (this.b)) {
        break;
      }
      this.a.requestDisallowInterceptTouchEvent(true);
      return;
    }
    this.a.requestDisallowInterceptTouchEvent(false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    setControlMove(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    setControlMove(paramMotionEvent);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setControlMove(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setNestedpParent(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/DragViewPaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */