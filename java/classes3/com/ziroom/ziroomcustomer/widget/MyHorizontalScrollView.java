package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class MyHorizontalScrollView
  extends HorizontalScrollView
{
  private int a;
  private a b;
  
  public MyHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MyHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.a = ((int)paramMotionEvent.getY());
      }
      i = (int)paramMotionEvent.getY();
      i = this.a - i;
    } while (Math.abs(i) <= 30);
    if (this.b != null) {
      this.b.OnItemTextListener(i);
    }
    return false;
  }
  
  public void setOnItemTextListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void OnItemTextListener(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/MyHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */