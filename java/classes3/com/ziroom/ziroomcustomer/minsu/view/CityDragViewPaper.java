package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.freelxl.baselibrary.f.d;

public class CityDragViewPaper
  extends ViewPager
{
  private double a;
  private double b;
  private double c;
  private double d;
  
  public CityDragViewPaper(Context paramContext)
  {
    super(paramContext);
  }
  
  public CityDragViewPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.a = f1;
      this.b = f2;
      continue;
      this.c = f1;
      this.d = f2;
      if (this.a > this.c)
      {
        if (getCurrentItem() == getChildCount() - 2)
        {
          d.d("lanzhihong", "最后一张  左");
          return true;
        }
        d.d("lanzhihong", "  左");
      }
      else if (this.c > this.a)
      {
        d.d("lanzhihong", "  右");
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return (a(paramMotionEvent)) || (super.dispatchTouchEvent(paramMotionEvent));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return (a(paramMotionEvent)) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (a(paramMotionEvent)) || (super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/CityDragViewPaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */