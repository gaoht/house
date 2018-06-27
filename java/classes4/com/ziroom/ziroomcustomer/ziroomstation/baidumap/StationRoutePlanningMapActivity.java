package com.ziroom.ziroomcustomer.ziroomstation.baidumap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ZoomControls;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.RoutePlanningFragment;
import com.ziroom.ziroomcustomer.util.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StationRoutePlanningMapActivity
  extends BaseActivity
{
  private ViewPager a;
  private ArrayList<Fragment> b;
  private b c;
  private MapView d;
  private RoutePlanningFragment e;
  private int f;
  private List<TransitRouteLine> g;
  private ArrayList<HashMap<String, Object>> r;
  private ImageView s;
  private TextView t;
  private BaiduMap u;
  private RelativeLayout v;
  
  private void a()
  {
    int j = 0;
    Object localObject = getIntent().getStringExtra("key");
    this.g = ((List)ApplicationEx.c.getData((String)localObject));
    this.r = ((ArrayList)ApplicationEx.c.getData("data"));
    this.f = getIntent().getIntExtra("position", 0);
    this.b = new ArrayList();
    int i = 0;
    while (i < this.g.size())
    {
      this.e = new RoutePlanningFragment((TransitRouteLine)this.g.get(i), (HashMap)this.r.get(i));
      this.b.add(this.e);
      i += 1;
    }
    b(this.f);
    this.a.setOffscreenPageLimit(this.g.size());
    this.a.setPageMargin(-20);
    int k = this.d.getChildCount();
    i = j;
    while (i < k)
    {
      localObject = this.d.getChildAt(i);
      if (((localObject instanceof ImageView)) || ((localObject instanceof ZoomControls))) {
        ((View)localObject).setVisibility(4);
      }
      if ((localObject instanceof ZoomControls)) {
        ((View)localObject).setVisibility(4);
      }
      i += 1;
    }
    this.c = new b(getSupportFragmentManager());
    this.a.setAdapter(this.c);
    this.a.setCurrentItem(this.f);
    this.v.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return StationRoutePlanningMapActivity.a(StationRoutePlanningMapActivity.this).dispatchTouchEvent(paramAnonymousMotionEvent);
      }
    });
    this.a.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        if (StationRoutePlanningMapActivity.a(StationRoutePlanningMapActivity.this) != null) {
          StationRoutePlanningMapActivity.a(StationRoutePlanningMapActivity.this).invalidate();
        }
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        StationRoutePlanningMapActivity.a(StationRoutePlanningMapActivity.this, paramAnonymousInt);
      }
    });
  }
  
  private void b()
  {
    this.a = ((ViewPager)findViewById(2131691037));
    this.d = ((MapView)findViewById(2131690529));
    this.u = this.d.getMap();
    this.v = ((RelativeLayout)findViewById(2131691357));
    this.t = ((TextView)findViewById(2131692246));
    this.s = ((ImageView)findViewById(2131689492));
    this.s.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        StationRoutePlanningMapActivity.this.finish();
      }
    });
  }
  
  private void b(int paramInt)
  {
    this.u.clear();
    TransitRouteLine localTransitRouteLine = (TransitRouteLine)this.g.get(paramInt);
    a locala = new a(this.u);
    locala.setData(localTransitRouteLine);
    locala.addToMap();
    locala.zoomToSpan();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903462);
    b();
    a();
  }
  
  private class a
    extends c
  {
    public a(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public BitmapDescriptor getStartMarker()
    {
      return BitmapDescriptorFactory.fromResource(2130838844);
    }
    
    public BitmapDescriptor getTerminalMarker()
    {
      return BitmapDescriptorFactory.fromResource(2130838784);
    }
  }
  
  public class b
    extends FragmentPagerAdapter
  {
    public b(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return StationRoutePlanningMapActivity.b(StationRoutePlanningMapActivity.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)StationRoutePlanningMapActivity.b(StationRoutePlanningMapActivity.this).get(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/baidumap/StationRoutePlanningMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */