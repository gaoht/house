package com.ziroom.ziroomcustomer.minsu.landlord.b;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuChatListFragment;
import com.ziroom.ziroomcustomer.minsu.landlord.fragment.MinsuLLHouseFragment;
import com.ziroom.ziroomcustomer.minsu.landlord.fragment.MinsuLLMyFragment;
import com.ziroom.ziroomcustomer.minsu.landlord.fragment.MinsuLLOrderFragment;

public class c
  extends FragmentPagerAdapter
{
  BaseFragment a = new MinsuLLOrderFragment();
  BaseFragment b = new MinsuLLHouseFragment();
  BaseFragment c = new MinsuChatListFragment();
  BaseFragment d;
  
  public c(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    paramFragmentManager = new Bundle();
    paramFragmentManager.putInt("customerType", 1);
    this.c.setArguments(paramFragmentManager);
    this.d = new MinsuLLMyFragment();
  }
  
  public int getCount()
  {
    return 4;
  }
  
  public Fragment getItem(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      if (this.a == null) {
        this.a = new MinsuLLOrderFragment();
      }
      return this.a;
    case 1: 
      if (this.b == null) {
        this.b = new MinsuLLHouseFragment();
      }
      return this.b;
    case 2: 
      if (this.c == null)
      {
        this.c = new MinsuChatListFragment();
        Bundle localBundle = new Bundle();
        localBundle.putInt("customerType", 1);
        this.c.setArguments(localBundle);
      }
      return this.c;
    }
    if (this.d == null) {
      this.d = new MinsuLLMyFragment();
    }
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */