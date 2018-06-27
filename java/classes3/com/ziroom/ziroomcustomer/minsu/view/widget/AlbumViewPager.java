package com.ziroom.ziroomcustomer.minsu.view.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

public class AlbumViewPager
  extends ViewPager
  implements MatrixImageView.c
{
  private boolean a = false;
  private View.OnClickListener b;
  
  public AlbumViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setOnSingleTapListener(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void startDrag()
  {
    this.a = true;
  }
  
  public void stopDrag()
  {
    this.a = false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/widget/AlbumViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */