package com.ziroom.ziroomcustomer.newclean.activity;

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
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.view.BiWeekCleanEvalWidght;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;

public class BiweeklyDetailBaseActivity
  extends BaseActivity
{
  private static int w;
  protected ViewPager a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  protected ArrayList<Fragment> f = new ArrayList();
  protected BiWeekCleanEvalWidght g;
  protected View r;
  protected SimpleDraweeView s;
  private ImageView t;
  private ImageView u;
  private ImageView v;
  private int x;
  private FragmentPagerAdapter y;
  
  private void a(CleanDetailBaseActivity.a parama, float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
    if (parama == CleanDetailBaseActivity.a.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * w + this.x * w));
    }
    for (;;)
    {
      this.t.setLayoutParams(localLayoutParams);
      return;
      if (parama == CleanDetailBaseActivity.a.b) {
        localLayoutParams.leftMargin = ((int)(w * paramFloat + this.x * w));
      }
    }
  }
  
  private void b()
  {
    this.e = ((TextView)findViewById(2131689956));
    this.a = ((ViewPager)findViewById(2131690028));
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((TextView)findViewById(2131690024));
    this.d = ((TextView)findViewById(2131690025));
    this.t = ((ImageView)findViewById(2131690026));
    this.u = ((ImageView)findViewById(2131689492));
    this.v = ((ImageView)findViewById(2131690023));
    this.g = ((BiWeekCleanEvalWidght)findViewById(2131690030));
    this.r = findViewById(2131690029);
    this.s = ((SimpleDraweeView)findViewById(2131690027));
  }
  
  private void e()
  {
    this.y = new FragmentPagerAdapter(getSupportFragmentManager())
    {
      public int getCount()
      {
        return 2;
      }
      
      public Fragment getItem(int paramAnonymousInt)
      {
        return (Fragment)BiweeklyDetailBaseActivity.this.f.get(paramAnonymousInt);
      }
    };
    this.a.setAdapter(this.y);
    this.a.setOffscreenPageLimit(2);
    this.a.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        if ((BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this) == 0) && (paramAnonymousInt1 == 0)) {
          BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this, CleanDetailBaseActivity.a.b, paramAnonymousFloat);
        }
        do
        {
          return;
          if ((BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this) == 1) && (paramAnonymousInt1 == 0))
          {
            BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this, CleanDetailBaseActivity.a.a, paramAnonymousFloat);
            return;
          }
          if ((BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this) == 1) && (paramAnonymousInt1 == 1))
          {
            BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this, CleanDetailBaseActivity.a.b, paramAnonymousFloat);
            return;
          }
          if ((BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this) == 2) && (paramAnonymousInt1 == 1))
          {
            BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this, CleanDetailBaseActivity.a.a, paramAnonymousFloat);
            return;
          }
        } while ((BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this) != 2) || (paramAnonymousInt1 != 2));
        BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this, CleanDetailBaseActivity.a.b, paramAnonymousFloat);
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        BiweeklyDetailBaseActivity.a(BiweeklyDetailBaseActivity.this, paramAnonymousInt);
        BiweeklyDetailBaseActivity.this.b(paramAnonymousInt);
      }
    });
    this.u.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiweeklyDetailBaseActivity.this.finish();
      }
    });
    this.v.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.toChat(BiweeklyDetailBaseActivity.this);
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiweeklyDetailBaseActivity.this.a.setCurrentItem(0);
        BiweeklyDetailBaseActivity.this.b(0);
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiweeklyDetailBaseActivity.this.a.setCurrentItem(1);
        BiweeklyDetailBaseActivity.this.b(1);
      }
    });
    b(0);
  }
  
  private void f()
  {
    w = getResources().getDisplayMetrics().widthPixels / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
    localLayoutParams.width = w;
    localLayoutParams.leftMargin = (w * 1);
    int i = (w - n.dip2px(this, 60.0F)) / 2;
    this.t.setPadding(i, 0, i, 0);
    this.t.setLayoutParams(localLayoutParams);
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
    setContentView(2130903110);
    b();
    f();
    e();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiweeklyDetailBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */