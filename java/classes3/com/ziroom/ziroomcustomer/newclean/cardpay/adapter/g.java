package com.ziroom.ziroomcustomer.newclean.cardpay.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.CleanGiftBuyCardFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.CleanGiftCardManageFragment;

public class g
  extends FragmentPagerAdapter
{
  private String[] a;
  private CleanGiftCardManageFragment b;
  private CleanGiftBuyCardFragment c;
  
  public g(FragmentManager paramFragmentManager, String[] paramArrayOfString)
  {
    super(paramFragmentManager);
    this.a = paramArrayOfString;
    this.b = CleanGiftCardManageFragment.getInstance();
    this.c = CleanGiftBuyCardFragment.getInstance();
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public BaseFragment getItem(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.b == null) {
        this.b = CleanGiftCardManageFragment.getInstance();
      }
      return this.b;
    }
    if (paramInt == 0)
    {
      if (this.c == null) {
        this.c = CleanGiftBuyCardFragment.getInstance();
      }
      return this.c;
    }
    return null;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    return this.a[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/adapter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */