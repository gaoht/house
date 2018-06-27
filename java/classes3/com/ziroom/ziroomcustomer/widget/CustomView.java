package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class CustomView
  extends LinearLayout
{
  private Scroller a;
  private GestureDetector b;
  private int c;
  
  public CustomView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClickable(true);
    setLongClickable(true);
    this.a = new Scroller(paramContext);
    this.b = new GestureDetector(paramContext, new a());
    paramContext = (WindowManager)paramContext.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.c = paramAttributeSet.heightPixels;
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      postInvalidate();
    }
    super.computeScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    this.a.startScroll(this.a.getFinalX(), this.a.getFinalY(), paramInt1, paramInt2);
    invalidate();
  }
  
  public void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - this.a.getFinalX(), paramInt2 - this.a.getFinalY());
  }
  
  class a
    implements GestureDetector.OnGestureListener
  {
    a() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent) {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = (int)((paramFloat2 - 0.5D) / 2.0D);
      Log.i("CustomView", i + ".");
      CustomView.this.smoothScrollBy(0, i);
      return false;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/CustomView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */