package com.ziroom.ziroomcustomer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class c
  extends FragmentPagerAdapter
{
  List<Fragment> a = null;
  List<Long> b = null;
  
  public c(FragmentManager paramFragmentManager, List<Fragment> paramList, List<Long> paramList1)
  {
    super(paramFragmentManager);
    this.a = paramList;
    this.b = paramList1;
    if ((this.b != null) && (this.a != null) && (this.b.size() != this.a.size())) {
      throw new IllegalArgumentException("fragmentList的长度必须和idList长度一致");
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.b == null) {
      return super.getItemId(paramInt);
    }
    return ((Long)this.b.get(paramInt)).longValue();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return super.getItemPosition(paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */