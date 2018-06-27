package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ObservableScrollView
  extends ScrollView
{
  private boolean a = true;
  private a b;
  private MotionEvent c;
  
  public ObservableScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ObservableScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ObservableScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if ((this.a) && (Build.VERSION.SDK_INT < 11)) {
      return 0.0F;
    }
    return super.getBottomFadingEdgeStrength();
  }
  
  public MotionEvent getEvent()
  {
    return this.c;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if ((this.a) && (Build.VERSION.SDK_INT < 11)) {
      return 0.0F;
    }
    return super.getTopFadingEdgeStrength();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.c = paramMotionEvent;
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b != null) {
      this.b.onScroll(paramInt1, paramInt2);
    }
  }
  
  public void setOnScrollChangedCallback(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScroll(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ObservableScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */