package com.ziroom.ziroomcustomer.newchat.chatcenter.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class c
  extends FragmentPagerAdapter
{
  List<Fragment> a;
  
  public c(FragmentManager paramFragmentManager, List<Fragment> paramList)
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */