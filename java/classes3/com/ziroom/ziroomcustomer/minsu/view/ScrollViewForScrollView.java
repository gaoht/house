package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

public class ScrollViewForScrollView
  extends ScrollView
{
  private int a;
  private int b;
  private int c;
  
  public ScrollViewForScrollView(Context paramContext)
  {
    super(paramContext);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public ScrollViewForScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public ScrollViewForScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.a = ((int)paramMotionEvent.getRawX());
        this.b = ((int)paramMotionEvent.getRawY());
      }
    } while (Math.abs((int)paramMotionEvent.getRawY() - this.b) <= this.c);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/ScrollViewForScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */