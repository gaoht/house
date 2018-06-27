package com.ziroom.credit.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.ziroom.credit.main.CreditScoreAnalysisBrokenLineFragment;
import com.ziroom.credit.main.CreditScoreAnalysisRankFragment;
import com.ziroom.credit.main.CreditScoreAnalysisTotalFragment;
import java.util.List;

public class d
  extends FragmentPagerAdapter
{
  private List<Fragment> a = null;
  
  public d(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.a.add(new CreditScoreAnalysisTotalFragment());
    this.a.add(new CreditScoreAnalysisBrokenLineFragment());
    this.a.add(new CreditScoreAnalysisRankFragment());
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
  
  public int getItemPosition(Object paramObject)
  {
    return super.getItemPosition(paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */