package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class SwipeLayout
  extends LinearLayout
{
  private ViewDragHelper a = ViewDragHelper.create(this, new a(null));
  private View b;
  private View c;
  private int d;
  private final double e = 800.0D;
  private int f;
  
  public SwipeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SwipeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.a.continueSettling(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void onFinishInflate()
  {
    this.b = getChildAt(0);
    this.c = getChildAt(1);
    this.c.setVisibility(8);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.shouldInterceptTouchEvent(paramMotionEvent)) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.d = this.c.getMeasuredWidth();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  private class a
    extends ViewDragHelper.Callback
  {
    private a() {}
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      if (paramView == SwipeLayout.a(SwipeLayout.this)) {
        return Math.min(Math.max(-SwipeLayout.this.getPaddingLeft() - SwipeLayout.c(SwipeLayout.this), paramInt1), 0);
      }
      paramInt2 = SwipeLayout.this.getPaddingLeft();
      int i = SwipeLayout.a(SwipeLayout.this).getMeasuredWidth();
      int j = SwipeLayout.c(SwipeLayout.this);
      int k = SwipeLayout.this.getPaddingLeft();
      int m = SwipeLayout.a(SwipeLayout.this).getMeasuredWidth();
      int n = SwipeLayout.this.getPaddingRight();
      return Math.min(Math.max(paramInt1, paramInt2 + i - j), k + m + n);
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return SwipeLayout.c(SwipeLayout.this);
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      SwipeLayout.a(SwipeLayout.this, paramInt1);
      if (paramView == SwipeLayout.a(SwipeLayout.this)) {
        SwipeLayout.b(SwipeLayout.this).offsetLeftAndRight(paramInt3);
      }
      for (;;)
      {
        if (SwipeLayout.b(SwipeLayout.this).getVisibility() == 8) {
          SwipeLayout.b(SwipeLayout.this).setVisibility(0);
        }
        SwipeLayout.this.invalidate();
        return;
        SwipeLayout.a(SwipeLayout.this).offsetLeftAndRight(paramInt3);
      }
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      int j = 1;
      super.onViewReleased(paramView, paramFloat1, paramFloat2);
      int i;
      if (paramFloat1 > 800.0D) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {}
        for (i = -SwipeLayout.c(SwipeLayout.this);; i = 0)
        {
          SwipeLayout.e(SwipeLayout.this).smoothSlideViewTo(SwipeLayout.a(SwipeLayout.this), i, 0);
          ViewCompat.postInvalidateOnAnimation(SwipeLayout.this);
          return;
          i = j;
          if (paramFloat1 < -800.0D) {
            break;
          }
          i = j;
          if (SwipeLayout.d(SwipeLayout.this) <= -SwipeLayout.c(SwipeLayout.this) / 2) {
            break;
          }
          if (SwipeLayout.d(SwipeLayout.this) <= -SwipeLayout.c(SwipeLayout.this) / 2) {
            break label135;
          }
          i = 0;
          break;
        }
        label135:
        i = 0;
      }
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      return (paramView == SwipeLayout.a(SwipeLayout.this)) || (paramView == SwipeLayout.b(SwipeLayout.this));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/SwipeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */