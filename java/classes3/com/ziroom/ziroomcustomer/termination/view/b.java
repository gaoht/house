package com.ziroom.ziroomcustomer.termination.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class b<CalendarCard extends View>
  extends PagerAdapter
{
  private CalendarCard[] a;
  
  public b(CalendarCard[] paramArrayOfCalendarCard)
  {
    this.a = paramArrayOfCalendarCard;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView(paramViewGroup);
  }
  
  public CalendarCard[] getAllItems()
  {
    return this.a;
  }
  
  public int getCount()
  {
    return Integer.MAX_VALUE;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildCount() == this.a.length) {
      paramViewGroup.removeView(this.a[(paramInt % this.a.length)]);
    }
    paramViewGroup.addView(this.a[(paramInt % this.a.length)], 0);
    return this.a[(paramInt % this.a.length)];
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */