package com.ziroom.ziroomcustomer.newchat.chatcenter.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MyViewPaper
  extends ViewPager
{
  private int a = 0;
  private boolean b = true;
  private HashMap<Integer, View> c = new LinkedHashMap();
  
  public MyViewPaper(Context paramContext)
  {
    super(paramContext);
  }
  
  public MyViewPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean isScrollble()
  {
    return this.b;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = (View)this.c.get(Integer.valueOf(getCurrentItem()));
    if (localView != null)
    {
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      this.a = localView.getMeasuredHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.a, 1073741824));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.b) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void resetHeight()
  {
    invalidate();
  }
  
  public void setObjectForPosition(View paramView, int paramInt)
  {
    this.c.put(Integer.valueOf(paramInt), paramView);
  }
  
  public void setScrollble(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/views/MyViewPaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */