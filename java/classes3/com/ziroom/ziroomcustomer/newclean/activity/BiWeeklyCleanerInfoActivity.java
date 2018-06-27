package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.newclean.fragment.BiWeeklyCleanerEvalFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.BiWeeklyCleanerInfoFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.BiweeklyCleanerIdentFragment;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StickyNavLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StickyNavLayout.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StickyNavLayout.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BiWeeklyCleanerInfoActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, StickyNavLayout.a, StickyNavLayout.b
{
  private static int e;
  private final String a = "BiWeeklyCleanerInfoActivity";
  private List<Fragment> b = new ArrayList();
  private FragmentPagerAdapter c;
  @BindView(2131690047)
  SimpleDraweeView ci_cleaner_header;
  private int d;
  private List<TextView> f = new ArrayList();
  private com.ziroom.ziroomcustomer.newclean.d.j g = new com.ziroom.ziroomcustomer.newclean.d.j();
  @BindView(2131690054)
  ImageView iv_star1;
  @BindView(2131690055)
  ImageView iv_star2;
  @BindView(2131690056)
  ImageView iv_star3;
  @BindView(2131690057)
  ImageView iv_star4;
  @BindView(2131690058)
  ImageView iv_star5;
  @BindView(2131690026)
  ImageView mIndicator;
  @BindView(2131690044)
  StickyNavLayout myStickyNavLayout;
  private b r;
  @BindView(2131690053)
  TextView tv_address;
  @BindView(2131690052)
  TextView tv_age;
  @BindView(2131690061)
  TextView tv_customer_eval;
  @BindView(2131690049)
  TextView tv_name;
  @BindView(2131690003)
  TextView tv_num;
  @BindView(2131690048)
  TextView tv_order;
  @BindView(2131690063)
  TextView tv_personal_info;
  @BindView(2131690059)
  TextView tv_score;
  @BindView(2131690062)
  TextView tv_ziru_identification;
  @BindView(2131689836)
  View view_title_line;
  @BindView(2131690064)
  ViewPager viewpager_content;
  
  private void a()
  {
    e = getResources().getDisplayMetrics().widthPixels / 3;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mIndicator.getLayoutParams();
    localLayoutParams.width = e;
    localLayoutParams.leftMargin = (e * 1);
    int i = (e - com.ziroom.ziroomcustomer.util.n.dip2px(this, 50.0F)) / 2;
    this.mIndicator.setPadding(i, 0, i, 0);
    this.mIndicator.setLayoutParams(localLayoutParams);
  }
  
  private void a(a parama, float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mIndicator.getLayoutParams();
    if (parama == a.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * e + this.d * e));
    }
    for (;;)
    {
      this.mIndicator.setLayoutParams(localLayoutParams);
      return;
      if (parama == a.b) {
        localLayoutParams.leftMargin = ((int)(e * paramFloat + this.d * e));
      }
    }
  }
  
  private void a(final com.ziroom.ziroomcustomer.newclean.d.j paramj)
  {
    this.ci_cleaner_header.setController(c.frescoController(paramj.getHeadPic()));
    this.tv_name.setText(paramj.getName());
    this.tv_age.setText(paramj.getAge() + "岁");
    this.tv_address.setText(paramj.getNativePlace());
    if (!TextUtils.isEmpty(paramj.getSocre()))
    {
      int i = (int)(Double.parseDouble(paramj.getSocre()) + 0.5D);
      this.tv_score.setText(paramj.getSocre());
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar(i, this.iv_star1, this.iv_star2, this.iv_star3, this.iv_star4, this.iv_star5);
      if (!TextUtils.isEmpty(paramj.getServeNum())) {
        break label189;
      }
      this.tv_num.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramj.getPhone())) {
        break label236;
      }
      this.tv_order.setVisibility(8);
      return;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar(5, this.iv_star1, this.iv_star2, this.iv_star3, this.iv_star4, this.iv_star5);
      break;
      label189:
      this.tv_num.setVisibility(0);
      this.tv_num.setText("共服务" + paramj.getServeNum() + "次");
    }
    label236:
    this.tv_order.setVisibility(0);
    this.tv_order.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ah.callPhone(BiWeeklyCleanerInfoActivity.this, paramj.getPhone());
      }
    });
  }
  
  private void b()
  {
    String str = getIntent().getStringExtra("cleanerId");
    this.f.add(this.tv_customer_eval);
    this.f.add(this.tv_ziru_identification);
    this.f.add(this.tv_personal_info);
    this.myStickyNavLayout.setStickInListener(this);
    this.myStickyNavLayout.setStickOutListener(this);
    this.b.removeAll(this.b);
    this.b.add(BiWeeklyCleanerEvalFragment.getInstance(str));
    this.b.add(BiweeklyCleanerIdentFragment.getInstance(str));
    this.b.add(new BiWeeklyCleanerInfoFragment());
    this.c = new FragmentPagerAdapter(getSupportFragmentManager())
    {
      public int getCount()
      {
        return 3;
      }
      
      public Fragment getItem(int paramAnonymousInt)
      {
        return (Fragment)BiWeeklyCleanerInfoActivity.a(BiWeeklyCleanerInfoActivity.this).get(paramAnonymousInt);
      }
    };
    this.viewpager_content.setAdapter(this.c);
    this.viewpager_content.setOffscreenPageLimit(3);
    b(0);
    this.viewpager_content.setCurrentItem(0, false);
    this.viewpager_content.setOnPageChangeListener(this);
  }
  
  private void b(int paramInt)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((TextView)localIterator.next()).setTextColor(Color.parseColor("#999999"));
    }
    ((TextView)this.f.get(paramInt)).setTextColor(Color.parseColor("#ffa000"));
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.e.n.getBiweeklyCleanerInfo(this, getIntent().getStringExtra("cleanerId"), new com.freelxl.baselibrary.d.c.a(new m(com.ziroom.ziroomcustomer.newclean.d.j.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newclean.d.j paramAnonymousj)
      {
        if (paramAnonymousj != null)
        {
          BiWeeklyCleanerInfoActivity.a(BiWeeklyCleanerInfoActivity.this, paramAnonymousj);
          if (BiWeeklyCleanerInfoActivity.b(BiWeeklyCleanerInfoActivity.this) != null) {
            BiWeeklyCleanerInfoActivity.b(BiWeeklyCleanerInfoActivity.this).onHasData();
          }
          BiWeeklyCleanerInfoActivity.this.setmCleanerInfo(BiWeeklyCleanerInfoActivity.c(BiWeeklyCleanerInfoActivity.this));
        }
        BiWeeklyCleanerInfoActivity.b(BiWeeklyCleanerInfoActivity.this, paramAnonymousj);
      }
    });
  }
  
  public com.ziroom.ziroomcustomer.newclean.d.j getmCleanerInfo()
  {
    return this.g;
  }
  
  @OnClick({2131690061, 2131690062, 2131690063, 2131689492})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690061: 
      b(0);
      this.viewpager_content.setCurrentItem(0, false);
      return;
    case 2131690062: 
      b(1);
      this.viewpager_content.setCurrentItem(1, false);
      return;
    case 2131690063: 
      b(2);
      this.viewpager_content.setCurrentItem(2, false);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903115);
    ButterKnife.bind(this);
    a();
    b();
    e();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    u.d("BiWeeklyCleanerInfoActivity", "onPageScrollStateChanged----position----" + paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    u.d("BiWeeklyCleanerInfoActivity", "===== " + paramInt1 + "  " + paramFloat + "  " + paramInt2);
    if ((this.d == 0) && (paramInt1 == 0)) {
      a(a.b, paramFloat);
    }
    do
    {
      return;
      if ((this.d == 1) && (paramInt1 == 0))
      {
        a(a.a, paramFloat);
        return;
      }
      if ((this.d == 1) && (paramInt1 == 1))
      {
        a(a.b, paramFloat);
        return;
      }
      if ((this.d == 2) && (paramInt1 == 1))
      {
        a(a.a, paramFloat);
        return;
      }
    } while ((this.d != 2) || (paramInt1 != 2));
    a(a.b, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    u.d("BiWeeklyCleanerInfoActivity", "onPageSelected----position----" + paramInt);
    b(paramInt);
    this.d = paramInt;
  }
  
  public void setOnHasDataClickListener(b paramb)
  {
    this.r = paramb;
  }
  
  public void setmCleanerInfo(com.ziroom.ziroomcustomer.newclean.d.j paramj)
  {
    this.g = paramj;
  }
  
  public void stickIn()
  {
    this.view_title_line.setVisibility(8);
  }
  
  public void stickOut()
  {
    this.view_title_line.setVisibility(0);
  }
  
  static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onHasData();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiWeeklyCleanerInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */