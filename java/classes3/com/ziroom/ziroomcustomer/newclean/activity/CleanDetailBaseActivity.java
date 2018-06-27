package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.view.CleanEvalWidget;
import com.ziroom.ziroomcustomer.newclean.view.CleanPayWidght;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;

public class CleanDetailBaseActivity
  extends BaseActivity
{
  private static int D;
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private int E;
  private FragmentPagerAdapter F;
  protected ViewPager a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  protected ArrayList<Fragment> f = new ArrayList();
  protected CleanPayWidght g;
  protected CleanEvalWidget r;
  protected View s;
  protected SimpleDraweeView t;
  protected LinearLayout u;
  protected TextView v;
  protected TextView w;
  protected LinearLayout x;
  protected LinearLayout y;
  protected CardView z;
  
  private void a(a parama, float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.A.getLayoutParams();
    if (parama == a.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * D + this.E * D));
    }
    for (;;)
    {
      this.A.setLayoutParams(localLayoutParams);
      return;
      if (parama == a.b) {
        localLayoutParams.leftMargin = ((int)(D * paramFloat + this.E * D));
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
    this.A = ((ImageView)findViewById(2131690026));
    this.B = ((ImageView)findViewById(2131689492));
    this.C = ((ImageView)findViewById(2131690023));
    this.g = ((CleanPayWidght)findViewById(2131690200));
    this.r = ((CleanEvalWidget)findViewById(2131690030));
    this.s = findViewById(2131690029);
    this.t = ((SimpleDraweeView)findViewById(2131690027));
    this.u = ((LinearLayout)findViewById(2131689838));
    this.v = ((TextView)findViewById(2131689846));
    this.w = ((TextView)findViewById(2131690199));
    this.x = ((LinearLayout)findViewById(2131690197));
    this.y = ((LinearLayout)findViewById(2131690198));
    this.z = ((CardView)findViewById(2131689955));
  }
  
  private void e()
  {
    this.F = new FragmentPagerAdapter(getSupportFragmentManager())
    {
      public int getCount()
      {
        return 2;
      }
      
      public Fragment getItem(int paramAnonymousInt)
      {
        return (Fragment)CleanDetailBaseActivity.this.f.get(paramAnonymousInt);
      }
    };
    this.a.setAdapter(this.F);
    this.a.setOffscreenPageLimit(2);
    this.a.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        if ((CleanDetailBaseActivity.a(CleanDetailBaseActivity.this) == 0) && (paramAnonymousInt1 == 0)) {
          CleanDetailBaseActivity.a(CleanDetailBaseActivity.this, CleanDetailBaseActivity.a.b, paramAnonymousFloat);
        }
        do
        {
          return;
          if ((CleanDetailBaseActivity.a(CleanDetailBaseActivity.this) == 1) && (paramAnonymousInt1 == 0))
          {
            CleanDetailBaseActivity.a(CleanDetailBaseActivity.this, CleanDetailBaseActivity.a.a, paramAnonymousFloat);
            return;
          }
          if ((CleanDetailBaseActivity.a(CleanDetailBaseActivity.this) == 1) && (paramAnonymousInt1 == 1))
          {
            CleanDetailBaseActivity.a(CleanDetailBaseActivity.this, CleanDetailBaseActivity.a.b, paramAnonymousFloat);
            return;
          }
          if ((CleanDetailBaseActivity.a(CleanDetailBaseActivity.this) == 2) && (paramAnonymousInt1 == 1))
          {
            CleanDetailBaseActivity.a(CleanDetailBaseActivity.this, CleanDetailBaseActivity.a.a, paramAnonymousFloat);
            return;
          }
        } while ((CleanDetailBaseActivity.a(CleanDetailBaseActivity.this) != 2) || (paramAnonymousInt1 != 2));
        CleanDetailBaseActivity.a(CleanDetailBaseActivity.this, CleanDetailBaseActivity.a.b, paramAnonymousFloat);
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        CleanDetailBaseActivity.a(CleanDetailBaseActivity.this, paramAnonymousInt);
        CleanDetailBaseActivity.this.b(paramAnonymousInt);
      }
    });
    this.B.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanDetailBaseActivity.this.finish();
      }
    });
    this.C.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanDetailBaseActivity.this.startActivity(new Intent(CleanDetailBaseActivity.this, ChatWebViewActivity.class));
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanDetailBaseActivity.this.a.setCurrentItem(0);
        CleanDetailBaseActivity.this.b(0);
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanDetailBaseActivity.this.a.setCurrentItem(1);
        CleanDetailBaseActivity.this.b(1);
      }
    });
    b(0);
  }
  
  private void f()
  {
    D = getResources().getDisplayMetrics().widthPixels / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.A.getLayoutParams();
    localLayoutParams.width = D;
    localLayoutParams.leftMargin = (D * 1);
    int i = (D - n.dip2px(this, 60.0F)) / 2;
    this.A.setPadding(i, 0, i, 0);
    this.A.setLayoutParams(localLayoutParams);
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
    setContentView(2130903136);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanDetailBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */