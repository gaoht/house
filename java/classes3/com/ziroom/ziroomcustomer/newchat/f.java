package com.ziroom.ziroomcustomer.newchat;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

public class f
  extends PagerAdapter
{
  private List<View> a;
  
  public f(List<View> paramList)
  {
    this.a = paramList;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)this.a.get(paramInt));
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)this.a.get(paramInt));
    return this.a.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */