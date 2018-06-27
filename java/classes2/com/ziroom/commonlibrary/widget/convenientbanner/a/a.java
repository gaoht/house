package com.ziroom.commonlibrary.widget.convenientbanner.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.widget.convenientbanner.b.b;
import com.ziroom.commonlibrary.widget.convenientbanner.view.CBLoopViewPager;
import java.util.List;

public class a<T>
  extends PagerAdapter
{
  protected List<T> a;
  protected com.ziroom.commonlibrary.widget.convenientbanner.b.a b;
  private boolean c = true;
  private CBLoopViewPager d;
  private final int e = 300;
  
  public a(com.ziroom.commonlibrary.widget.convenientbanner.b.a parama, List<T> paramList)
  {
    this.b = parama;
    this.a = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    int j = this.d.getCurrentItem();
    int i;
    if (j == 0) {
      i = this.d.getFristItem();
    }
    for (;;)
    {
      try
      {
        this.d.setCurrentItem(i, false);
        return;
      }
      catch (IllegalStateException paramViewGroup) {}
      i = j;
      if (j == getCount() - 1) {
        i = this.d.getLastItem();
      }
    }
  }
  
  public int getCount()
  {
    if (this.c) {
      return getRealCount() * 300;
    }
    return getRealCount();
  }
  
  public int getRealCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b localb;
    if (paramView == null)
    {
      localb = (b)this.b.createHolder();
      paramView = localb.createView(paramViewGroup.getContext());
      paramView.setTag(R.id.cb_item_tag, localb);
    }
    for (;;)
    {
      if ((this.a != null) && (!this.a.isEmpty())) {
        localb.UpdateUI(paramViewGroup.getContext(), paramInt, this.a.get(paramInt));
      }
      return paramView;
      localb = (b)paramView.getTag(R.id.cb_item_tag);
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = getView(toRealPosition(paramInt), null, paramViewGroup);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setCanLoop(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setViewPager(CBLoopViewPager paramCBLoopViewPager)
  {
    this.d = paramCBLoopViewPager;
  }
  
  public int toRealPosition(int paramInt)
  {
    int i = getRealCount();
    if (i == 0) {
      return 0;
    }
    return paramInt % i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/convenientbanner/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */