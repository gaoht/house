package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.periodclean.fragment.PeriodCleanStateFrament;
import com.ziroom.ziroomcustomer.newclean.periodclean.fragment.PeriodcleanDetailFragment;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;

public class PeriodCleanerOrderDetailActivity
  extends BaseActivity
{
  private static int d;
  protected ArrayList<Fragment> a = new ArrayList();
  private FragmentPagerAdapter b;
  private int c;
  private String e;
  @BindView(2131690026)
  ImageView indicator;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690023)
  ImageView ivChat;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131690025)
  TextView tvOrderDetail;
  @BindView(2131690024)
  TextView tvOrderState;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131690028)
  ViewPager vpDetail;
  
  private void a()
  {
    this.b = new FragmentPagerAdapter(getSupportFragmentManager())
    {
      public int getCount()
      {
        return 2;
      }
      
      public Fragment getItem(int paramAnonymousInt)
      {
        return (Fragment)PeriodCleanerOrderDetailActivity.this.a.get(paramAnonymousInt);
      }
    };
    this.vpDetail.setAdapter(this.b);
    this.vpDetail.setOffscreenPageLimit(2);
    this.vpDetail.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        if ((PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this) == 0) && (paramAnonymousInt1 == 0)) {
          PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this, PeriodCleanerOrderDetailActivity.a.b, paramAnonymousFloat);
        }
        do
        {
          return;
          if ((PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this) == 1) && (paramAnonymousInt1 == 0))
          {
            PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this, PeriodCleanerOrderDetailActivity.a.a, paramAnonymousFloat);
            return;
          }
          if ((PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this) == 1) && (paramAnonymousInt1 == 1))
          {
            PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this, PeriodCleanerOrderDetailActivity.a.b, paramAnonymousFloat);
            return;
          }
          if ((PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this) == 2) && (paramAnonymousInt1 == 1))
          {
            PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this, PeriodCleanerOrderDetailActivity.a.a, paramAnonymousFloat);
            return;
          }
        } while ((PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this) != 2) || (paramAnonymousInt1 != 2));
        PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this, PeriodCleanerOrderDetailActivity.a.b, paramAnonymousFloat);
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        PeriodCleanerOrderDetailActivity.a(PeriodCleanerOrderDetailActivity.this, paramAnonymousInt);
        PeriodCleanerOrderDetailActivity.this.b(paramAnonymousInt);
      }
    });
    this.vpDetail.setCurrentItem(1);
    b(1);
  }
  
  private void a(a parama, float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.indicator.getLayoutParams();
    if (parama == a.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * d + this.c * d));
    }
    for (;;)
    {
      this.indicator.setLayoutParams(localLayoutParams);
      return;
      if (parama == a.b) {
        localLayoutParams.leftMargin = ((int)(d * paramFloat + this.c * d));
      }
    }
  }
  
  private void b()
  {
    d = getResources().getDisplayMetrics().widthPixels / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.indicator.getLayoutParams();
    localLayoutParams.width = d;
    localLayoutParams.leftMargin = (d * 1);
    int i = (d - n.dip2px(this, 60.0F)) / 2;
    this.indicator.setPadding(i, 0, i, 0);
    this.indicator.setLayoutParams(localLayoutParams);
  }
  
  protected void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.tvOrderState.setTextColor(40960);
      this.tvOrderDetail.setTextColor(-12303292);
    }
    while (paramInt != 1) {
      return;
    }
    this.tvOrderState.setTextColor(-12303292);
    this.tvOrderDetail.setTextColor(40960);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903422);
    ButterKnife.bind(this);
    this.e = getIntent().getStringExtra("orderId");
    this.a.add(PeriodCleanStateFrament.getInstance(this.e));
    this.a.add(PeriodcleanDetailFragment.getInstance(this.e));
    a();
    b();
  }
  
  @OnClick({2131689492, 2131690024, 2131690025, 2131690023})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690023: 
      j.toChat(this);
      return;
    case 2131690024: 
      this.vpDetail.setCurrentItem(0);
      b(0);
      return;
    }
    this.vpDetail.setCurrentItem(1);
    b(1);
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanerOrderDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */