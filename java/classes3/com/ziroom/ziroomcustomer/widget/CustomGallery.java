package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Gallery;

public class CustomGallery
  extends Gallery
  implements GestureDetector.OnGestureListener
{
  private ViewPager a;
  private float b;
  private float c;
  private int d;
  
  public CustomGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public ViewPager getmPager()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.requestDisallowInterceptTouchEvent(true);
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      this.b = f1;
      this.c = f2;
      return true;
      this.d = ((int)(this.b - f1));
      i = (int)(this.c - f2);
      if ((Math.abs(this.d) > 10) && (Math.abs(i / this.d) < 1)) {}
      for (i = 1; i != 0; i = 0) {
        return true;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.requestDisallowInterceptTouchEvent(true);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setmPager(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/CustomGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */