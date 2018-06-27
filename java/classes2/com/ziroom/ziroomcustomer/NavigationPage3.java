package com.ziroom.ziroomcustomer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.List;

public class NavigationPage3
  extends BaseActivity
{
  private ViewPager a;
  private List<NavigationFragment> b;
  private FragmentManager c;
  private LinearLayout d;
  private ArrayList<Integer> e;
  
  private void a()
  {
    this.b = new ArrayList();
    int i = 0;
    while (i < this.e.size())
    {
      this.b.add(NavigationFragment.getInstance(this.e, i));
      i += 1;
    }
    this.a.setAdapter(new a(this.c, this.b));
    this.a.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        int i = 0;
        while (i < NavigationPage3.a(NavigationPage3.this).getChildCount())
        {
          NavigationPage3.a(NavigationPage3.this).getChildAt(i).setBackgroundResource(2130839317);
          i += 1;
        }
        NavigationPage3.a(NavigationPage3.this).getChildAt(paramAnonymousInt).setBackgroundResource(2130839332);
      }
    });
  }
  
  private void b()
  {
    this.a = ((ViewPager)findViewById(2131691905));
    this.d = ((LinearLayout)findViewById(2131691906));
    this.d.removeAllViews();
    int i = 0;
    if (i < this.e.size())
    {
      View localView = new View(this);
      int j = n.dip2px(this, 6.0F);
      int k = n.dip2px(this, 5.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
      localLayoutParams.leftMargin = k;
      localLayoutParams.rightMargin = k;
      localView.setLayoutParams(localLayoutParams);
      if (i == 0) {
        localView.setBackgroundResource(2130839332);
      }
      for (;;)
      {
        this.d.addView(localView);
        i += 1;
        break;
        localView.setBackgroundResource(2130839317);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903386);
    this.c = getSupportFragmentManager();
    this.e = new ArrayList();
    this.e.add(Integer.valueOf(2130838512));
    this.e.add(Integer.valueOf(2130838513));
    this.e.add(Integer.valueOf(2130838514));
    this.e.add(Integer.valueOf(2130838515));
    this.e.add(Integer.valueOf(2130838516));
    b();
    a();
  }
  
  class a
    extends FragmentPagerAdapter
  {
    private List<NavigationFragment> b;
    
    public a(List<NavigationFragment> paramList)
    {
      super();
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)this.b.get(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/NavigationPage3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */