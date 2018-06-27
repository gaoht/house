package com.ziroom.ziroomcustomer.account.swipemenulistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewParent;

public class MySwipeMenuListView
  extends SwipeMenuListView
{
  private GestureDetector a = new GestureDetector(paramContext, this.b);
  private GestureDetector.OnGestureListener b = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      Log.w("MyLog", "onScroll");
      if (((paramAnonymousFloat2 == 0.0F) || (paramAnonymousFloat1 == 0.0F)) || (Math.abs(paramAnonymousFloat2) >= Math.abs(paramAnonymousFloat1))) {
        return true;
      }
      MySwipeMenuListView.a(MySwipeMenuListView.this, false);
      return false;
    }
  };
  
  public MySwipeMenuListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MySwipeMenuListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MySwipeMenuListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setParentScrollAble(boolean paramBoolean)
  {
    Log.w("MyLog", "setParentScrollAble -- " + paramBoolean);
    ViewParent localViewParent = getParent();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.a.onTouchEvent(paramMotionEvent);
    Log.w("MyLog", "-- " + bool + " --");
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/swipemenulistview/MySwipeMenuListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */