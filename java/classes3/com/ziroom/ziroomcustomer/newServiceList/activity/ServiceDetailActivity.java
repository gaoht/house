package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;

public class ServiceDetailActivity
  extends BaseActivity
{
  private static int t;
  protected ViewPager a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected ImageView e;
  protected TextView f;
  protected ArrayList<Fragment> g = new ArrayList();
  private ImageView r;
  private ImageView s;
  private int u;
  private FragmentPagerAdapter v;
  
  private void a(a parama, float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.r.getLayoutParams();
    if (parama == a.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * t + this.u * t));
    }
    for (;;)
    {
      this.r.setLayoutParams(localLayoutParams);
      return;
      if (parama == a.b) {
        localLayoutParams.leftMargin = ((int)(t * paramFloat + this.u * t));
      }
    }
  }
  
  private void b()
  {
    this.f = ((TextView)findViewById(2131689956));
    this.a = ((ViewPager)findViewById(2131690028));
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((TextView)findViewById(2131690024));
    this.d = ((TextView)findViewById(2131690025));
    this.r = ((ImageView)findViewById(2131690026));
    this.s = ((ImageView)findViewById(2131689492));
    this.e = ((ImageView)findViewById(2131690023));
  }
  
  private void e()
  {
    this.v = new FragmentPagerAdapter(getSupportFragmentManager())
    {
      public int getCount()
      {
        return 2;
      }
      
      public Fragment getItem(int paramAnonymousInt)
      {
        return (Fragment)ServiceDetailActivity.this.g.get(paramAnonymousInt);
      }
    };
    this.a.setAdapter(this.v);
    this.a.setOffscreenPageLimit(2);
    this.a.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        if ((ServiceDetailActivity.a(ServiceDetailActivity.this) == 0) && (paramAnonymousInt1 == 0)) {
          ServiceDetailActivity.a(ServiceDetailActivity.this, ServiceDetailActivity.a.b, paramAnonymousFloat);
        }
        do
        {
          return;
          if ((ServiceDetailActivity.a(ServiceDetailActivity.this) == 1) && (paramAnonymousInt1 == 0))
          {
            ServiceDetailActivity.a(ServiceDetailActivity.this, ServiceDetailActivity.a.a, paramAnonymousFloat);
            return;
          }
          if ((ServiceDetailActivity.a(ServiceDetailActivity.this) == 1) && (paramAnonymousInt1 == 1))
          {
            ServiceDetailActivity.a(ServiceDetailActivity.this, ServiceDetailActivity.a.b, paramAnonymousFloat);
            return;
          }
          if ((ServiceDetailActivity.a(ServiceDetailActivity.this) == 2) && (paramAnonymousInt1 == 1))
          {
            ServiceDetailActivity.a(ServiceDetailActivity.this, ServiceDetailActivity.a.a, paramAnonymousFloat);
            return;
          }
        } while ((ServiceDetailActivity.a(ServiceDetailActivity.this) != 2) || (paramAnonymousInt1 != 2));
        ServiceDetailActivity.a(ServiceDetailActivity.this, ServiceDetailActivity.a.b, paramAnonymousFloat);
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        ServiceDetailActivity.a(ServiceDetailActivity.this, paramAnonymousInt);
        ServiceDetailActivity.this.b(paramAnonymousInt);
      }
    });
    this.s.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ServiceDetailActivity.this.finish();
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.toChat(ServiceDetailActivity.this);
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ServiceDetailActivity.this.a.setCurrentItem(0);
        ServiceDetailActivity.this.b(0);
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ServiceDetailActivity.this.a.setCurrentItem(1);
        ServiceDetailActivity.this.b(1);
      }
    });
    b(0);
  }
  
  private void f()
  {
    t = getResources().getDisplayMetrics().widthPixels / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.r.getLayoutParams();
    localLayoutParams.width = t;
    localLayoutParams.leftMargin = (t * 1);
    int i = (t - n.dip2px(this, 60.0F)) / 2;
    this.r.setPadding(i, 0, i, 0);
    this.r.setLayoutParams(localLayoutParams);
  }
  
  protected void a() {}
  
  protected void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.c.setTextColor(40960);
      this.d.setTextColor(-12303292);
    }
    while (paramInt != 1) {
      return;
    }
    this.c.setTextColor(-12303292);
    this.d.setTextColor(40960);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903184);
    b();
    f();
    e();
    a();
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/ServiceDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */