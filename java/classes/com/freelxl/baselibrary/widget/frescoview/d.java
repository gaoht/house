package com.freelxl.baselibrary.widget.frescoview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class d
  extends GestureDetector.SimpleOnGestureListener
{
  private GestureDetector.SimpleOnGestureListener a = new GestureDetector.SimpleOnGestureListener();
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return this.a.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.a.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.a.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.a.onLongPress(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.a.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    this.a.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return this.a.onSingleTapConfirmed(paramMotionEvent);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return this.a.onSingleTapUp(paramMotionEvent);
  }
  
  public void setListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    this.a = paramSimpleOnGestureListener;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */