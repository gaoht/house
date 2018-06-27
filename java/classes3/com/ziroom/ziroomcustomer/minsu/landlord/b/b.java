package com.ziroom.ziroomcustomer.minsu.landlord.b;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.ziroom.ziroomcustomer.minsu.landlord.fragment.MinsuLLNeadDealOrderFragment;

public class b
  extends FragmentPagerAdapter
{
  private String[] a;
  private MinsuLLNeadDealOrderFragment b;
  private MinsuLLNeadDealOrderFragment c;
  private MinsuLLNeadDealOrderFragment d;
  
  public b(FragmentManager paramFragmentManager, String[] paramArrayOfString)
  {
    super(paramFragmentManager);
    this.a = paramArrayOfString;
    this.b = MinsuLLNeadDealOrderFragment.getInitstance(1);
    this.c = MinsuLLNeadDealOrderFragment.getInitstance(2);
    this.d = MinsuLLNeadDealOrderFragment.getInitstance(11);
  }
  
  public void LoadData()
  {
    if (this.b != null) {
      this.b.FristLoadData();
    }
    if (this.c != null) {
      this.c.FristLoadData();
    }
    if (this.d != null) {
      this.d.FristLoadData();
    }
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public MinsuLLNeadDealOrderFragment getItem(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.b == null) {
        this.b = MinsuLLNeadDealOrderFragment.getInitstance(1);
      }
      return this.b;
    }
    if (paramInt == 1)
    {
      if (this.c == null) {
        this.c = MinsuLLNeadDealOrderFragment.getInitstance(2);
      }
      return this.c;
    }
    if (this.d == null) {
      this.d = MinsuLLNeadDealOrderFragment.getInitstance(11);
    }
    return this.d;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    return this.a[paramInt];
  }
  
  public void resetData()
  {
    if (this.b != null) {
      this.b.resetData();
    }
    if (this.c != null) {
      this.c.resetData();
    }
    if (this.d != null) {
      this.d.resetData();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */