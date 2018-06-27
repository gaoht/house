package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class e
  extends FragmentPagerAdapter
{
  List<Fragment> a;
  
  public e(FragmentManager paramFragmentManager, List<Fragment> paramList)
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
    if (this.a == null) {
      return null;
    }
    return (Fragment)this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return super.getItemPosition(paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */