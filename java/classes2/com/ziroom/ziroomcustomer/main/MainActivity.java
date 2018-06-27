package com.ziroom.ziroomcustomer.main;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.internal.Preconditions;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.main.discovery.DiscoveryFragment;
import com.ziroom.ziroomcustomer.main.find.FindFragment;
import com.ziroom.ziroomcustomer.main.landlord.LandlordFragment;
import com.ziroom.ziroomcustomer.model.rent.RentCondition;
import com.ziroom.ziroomcustomer.my.MyZiroomFragment;
import com.ziroom.ziroomcustomer.rent.list.RentHouseListFragment;
import com.ziroom.ziroomcustomer.rent.list.c.b;
import com.ziroom.ziroomcustomer.widget.ScrollControlerViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity
  extends BaseActivity
  implements View.OnClickListener, a.b
{
  private RelativeLayout A;
  private ImageView B;
  private TextView C;
  private long D;
  private a.a a;
  private ScrollControlerViewPager b;
  private LinearLayout c;
  private LinearLayout d;
  private RelativeLayout e;
  private ImageView f;
  private TextView g;
  private RelativeLayout r;
  private ImageView s;
  private TextView t;
  private RelativeLayout u;
  private ImageView v;
  private TextView w;
  private RelativeLayout x;
  private ImageView y;
  private TextView z;
  
  private void a()
  {
    this.b = ((ScrollControlerViewPager)findViewById(2131691141));
    this.c = ((LinearLayout)findViewById(2131696283));
    this.d = ((LinearLayout)findViewById(2131696284));
    this.e = ((RelativeLayout)findViewById(2131696285));
    this.f = ((ImageView)findViewById(2131696286));
    this.g = ((TextView)findViewById(2131696287));
    this.r = ((RelativeLayout)findViewById(2131696288));
    this.s = ((ImageView)findViewById(2131696289));
    this.t = ((TextView)findViewById(2131696290));
    this.u = ((RelativeLayout)findViewById(2131696291));
    this.v = ((ImageView)findViewById(2131696292));
    this.w = ((TextView)findViewById(2131696293));
    this.x = ((RelativeLayout)findViewById(2131696294));
    this.y = ((ImageView)findViewById(2131696295));
    this.z = ((TextView)findViewById(2131696296));
    this.A = ((RelativeLayout)findViewById(2131696297));
    this.B = ((ImageView)findViewById(2131696298));
    this.C = ((TextView)findViewById(2131696299));
    b();
    this.e.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.A.setOnClickListener(this);
  }
  
  private void b()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = RentHouseListFragment.newInstance(new RentCondition());
    new com.ziroom.ziroomcustomer.rent.list.d((c.b)localObject2);
    ((List)localObject1).add(localObject2);
    localObject2 = FindFragment.newInstance();
    new com.ziroom.ziroomcustomer.main.find.d((com.ziroom.ziroomcustomer.main.find.a.b)localObject2);
    ((List)localObject1).add(localObject2);
    ((List)localObject1).add(LandlordFragment.newInstance());
    ((List)localObject1).add(DiscoveryFragment.newInstance());
    ((List)localObject1).add(new MyZiroomFragment());
    localObject1 = new a(getSupportFragmentManager(), (List)localObject1);
    this.b = ((ScrollControlerViewPager)findViewById(2131691141));
    this.b.setAdapter((PagerAdapter)localObject1);
    this.b.setOffscreenPageLimit(5);
    this.b.setNoScroll(false);
    this.b.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        MainActivity.this.selectTab(paramAnonymousInt);
        MainActivity.a(MainActivity.this, "5slide_tab" + paramAnonymousInt);
      }
    });
  }
  
  private void e()
  {
    int i = Color.parseColor("#999999");
    this.f.setImageResource(2130840239);
    this.g.setTextColor(i);
    this.s.setImageResource(2130840236);
    this.t.setTextColor(i);
    this.v.setImageResource(2130840260);
    this.w.setTextColor(i);
    this.y.setImageResource(2130840269);
    this.z.setTextColor(i);
    this.B.setImageResource(2130840328);
    this.C.setTextColor(i);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696285: 
      selectTab(0);
      return;
    case 2131696288: 
      selectTab(1);
      return;
    case 2131696291: 
      selectTab(2);
      return;
    case 2131696294: 
      selectTab(3);
      return;
    }
    selectTab(4);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903252);
    a();
    this.a = new b(this);
    this.a.start();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.detachView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      long l = System.currentTimeMillis();
      if (l - this.D > 2000L)
      {
        g.textToast(ApplicationEx.c, "再按一次可退出程序");
        this.D = l;
        return true;
      }
      ApplicationEx.c.AppExit(this);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void selectTab(int paramInt)
  {
    int i = Color.parseColor("#444444");
    e();
    this.b.setCurrentItem(paramInt, false);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.f.setImageResource(2130840238);
      this.g.setTextColor(i);
      return;
    case 1: 
      this.s.setImageResource(2130840235);
      this.t.setTextColor(i);
      return;
    case 2: 
      this.v.setImageResource(2130840259);
      this.w.setTextColor(i);
      return;
    case 3: 
      this.y.setImageResource(2130840265);
      this.z.setTextColor(i);
      return;
    }
    this.B.setImageResource(2130840327);
    this.C.setTextColor(i);
  }
  
  public void setPresenter(a.a parama)
  {
    this.a = ((a.a)Preconditions.checkNotNull(parama));
  }
  
  private class a
    extends FragmentPagerAdapter
  {
    List<Fragment> a = null;
    
    public a(List<Fragment> paramList)
    {
      super();
      List localList;
      this.a = localList;
    }
    
    public int getCount()
    {
      return this.a.size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)this.a.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemPosition(Object paramObject)
    {
      return super.getItemPosition(paramObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */