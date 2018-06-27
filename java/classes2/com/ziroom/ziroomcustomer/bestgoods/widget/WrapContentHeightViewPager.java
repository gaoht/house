package com.ziroom.ziroomcustomer.bestgoods.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class WrapContentHeightViewPager
  extends ViewPager
{
  private int a;
  private int b = 0;
  private HashMap<Integer, View> c = new LinkedHashMap();
  private boolean d = true;
  
  public WrapContentHeightViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public WrapContentHeightViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean isScrollble()
  {
    return this.d;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.c.size() > this.a)
    {
      View localView = (View)this.c.get(Integer.valueOf(this.a));
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      this.b = localView.getMeasuredHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.d) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void resetHeight(int paramInt)
  {
    this.a = paramInt;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.c.size() > paramInt)
    {
      localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
      if (localLayoutParams != null) {
        break label47;
      }
      localLayoutParams = new LinearLayout.LayoutParams(-1, this.b);
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      return;
      label47:
      localLayoutParams.height = this.b;
    }
  }
  
  public void setObjectForPosition(View paramView, int paramInt)
  {
    this.c.put(Integer.valueOf(paramInt), paramView);
  }
  
  public void setScrollble(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/widget/WrapContentHeightViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */