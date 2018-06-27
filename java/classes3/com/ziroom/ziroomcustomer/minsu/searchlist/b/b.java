package com.ziroom.ziroomcustomer.minsu.searchlist.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.BaseSearchListFragment;
import java.util.List;

public class b
  extends FragmentPagerAdapter
{
  private List<BaseSearchListFragment> a;
  
  public b(FragmentManager paramFragmentManager, List<BaseSearchListFragment> paramList)
  {
    super(paramFragmentManager);
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return ((BaseSearchListFragment)this.a.get(paramInt)).getTitle();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */