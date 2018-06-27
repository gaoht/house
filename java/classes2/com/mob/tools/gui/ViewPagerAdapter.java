package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;

public abstract class ViewPagerAdapter
{
  private MobViewPager parent;
  
  public abstract int getCount();
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public void invalidate()
  {
    if (this.parent != null) {
      this.parent.setAdapter(this);
    }
  }
  
  public void onScreenChange(int paramInt1, int paramInt2) {}
  
  public void onScreenChanging(float paramFloat) {}
  
  final void setMobViewPager(MobViewPager paramMobViewPager)
  {
    this.parent = paramMobViewPager;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/ViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */