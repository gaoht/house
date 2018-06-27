package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.VerticalDrawerLayout;
import com.ziroom.ziroomcustomer.widget.VerticalDrawerLayout.a;
import com.ziroom.ziroomcustomer.ziroomapartment.a.a.b;
import com.ziroom.ziroomcustomer.ziroomapartment.a.d;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuCityPop;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuCityPop.b;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.ZryuProjectDetailPop;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuCity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuConfig;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuListItem;
import java.util.Iterator;
import java.util.List;

public class ZryuMapActivity
  extends BaseActivity
{
  Unbinder a;
  LayoutInflater b;
  private BaiduMap c;
  private ZryuCity d;
  private List<ZryuCity> e;
  private List<ZryuListItem> f;
  private a g;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131692902)
  MapView mMapView;
  @BindView(2131692497)
  TextView mTvCity;
  @BindView(2131690815)
  View mVBg;
  @BindView(2131690813)
  VerticalDrawerLayout mVdlRoot;
  private ZryuProjectDetailPop r;
  private int s;
  private float t;
  private Marker u;
  private String v;
  private boolean w;
  
  private BitmapDescriptor a(ZryuListItem paramZryuListItem, boolean paramBoolean)
  {
    if (paramZryuListItem == null) {
      return null;
    }
    View localView = getLayoutInflater().inflate(2130904823, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    Object localObject = (TextView)localView.findViewById(2131690049);
    ((TextView)localObject).setText(paramZryuListItem.getProName());
    if (paramBoolean)
    {
      ((TextView)localObject).setBackgroundResource(2130837912);
      ((TextView)localObject).setPadding((int)(this.t * 10.0F), 0, (int)(this.t * 10.0F), (int)(5.0F * this.t));
      ((ImageView)localView.findViewById(2131690097)).setImageResource(ZryuConfig.getIconResource(paramZryuListItem.getProCode(), paramZryuListItem.getOpeningPeriod()));
      localObject = (ImageView)localView.findViewById(2131696577);
      if ((1 != paramZryuListItem.getOpeningPeriod()) && (2 != paramZryuListItem.getOpeningPeriod())) {
        break label164;
      }
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      return BitmapDescriptorFactory.fromView(localView);
      ((TextView)localObject).setBackgroundResource(2130837913);
      break;
      label164:
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  private void a()
  {
    this.b = LayoutInflater.from(this);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.s = localDisplayMetrics.widthPixels;
    this.t = localDisplayMetrics.density;
    this.mVdlRoot.setEdge(this.s / 375 * 87, this.s / 375 * 210);
    e();
    this.mVdlRoot.setListener(new VerticalDrawerLayout.a()
    {
      public void onDrawerClosed(View paramAnonymousView)
      {
        ZryuMapActivity.this.mVBg.setVisibility(8);
        ZryuMapActivity.this.mVdlRoot.lockDrawer(false);
      }
      
      public void onDrawerOpened(View paramAnonymousView)
      {
        if (ZryuMapActivity.this.mLv.getFirstVisiblePosition() != 0)
        {
          ZryuMapActivity.this.mVdlRoot.lockDrawer(true);
          return;
        }
        ZryuMapActivity.this.mVdlRoot.lockDrawer(false);
      }
      
      public void onDrawerSlide(View paramAnonymousView, float paramAnonymousFloat)
      {
        if (paramAnonymousFloat > 0.0F)
        {
          ZryuMapActivity.this.mVBg.setVisibility(0);
          ZryuMapActivity.this.mVBg.setAlpha(0.2F * paramAnonymousFloat);
        }
      }
      
      public void onDrawerStateChanged(int paramAnonymousInt) {}
    });
    this.g = new a(null);
    this.mLv.setAdapter(this.g);
    this.mLv.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          ZryuMapActivity.this.mVdlRoot.lockDrawer(false);
          if ((paramAnonymousAbsListView.getFirstVisiblePosition() != 0) && (ZryuMapActivity.this.mVdlRoot.getDrawerOffset() > 0.99D)) {
            ZryuMapActivity.this.mVdlRoot.lockDrawer(true);
          }
          return;
        }
        ZryuMapActivity.this.mVdlRoot.lockDrawer(true);
      }
    });
  }
  
  private void a(ZryuListItem paramZryuListItem)
  {
    Object localObject1 = a(paramZryuListItem, false);
    Object localObject2 = new LatLng(paramZryuListItem.getLat(), paramZryuListItem.getLng());
    localObject1 = new MarkerOptions().position((LatLng)localObject2).icon((BitmapDescriptor)localObject1).zIndex(17);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putParcelable("zryu", paramZryuListItem);
    ((MarkerOptions)localObject1).extraInfo((Bundle)localObject2);
    this.c.addOverlay((OverlayOptions)localObject1);
  }
  
  private void a(List<ZryuListItem> paramList)
  {
    double d3;
    double d1;
    double d4;
    double d2;
    double d6;
    double d5;
    if ((paramList != null) && (paramList.size() > 0))
    {
      Object localObject = (ZryuListItem)paramList.get(0);
      d3 = ((ZryuListItem)localObject).getLat();
      d1 = ((ZryuListItem)localObject).getLng();
      d4 = ((ZryuListItem)localObject).getLat();
      d2 = ((ZryuListItem)localObject).getLng();
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ZryuListItem localZryuListItem = (ZryuListItem)((Iterator)localObject).next();
        if (localZryuListItem.getLat() > d3)
        {
          d6 = localZryuListItem.getLat();
          d5 = d4;
          label104:
          if (localZryuListItem.getLng() <= d1) {
            break label182;
          }
          d3 = localZryuListItem.getLng();
          d4 = d2;
        }
        for (;;)
        {
          a(localZryuListItem);
          d2 = d4;
          d4 = d5;
          d1 = d3;
          d3 = d6;
          break;
          d5 = d4;
          d6 = d3;
          if (localZryuListItem.getLat() >= d4) {
            break label104;
          }
          d5 = localZryuListItem.getLat();
          d6 = d3;
          break label104;
          label182:
          d4 = d2;
          d3 = d1;
          if (localZryuListItem.getLng() < d2)
          {
            d4 = localZryuListItem.getLng();
            d3 = d1;
          }
        }
      }
      if (paramList.size() + 1 <= 10) {
        break label313;
      }
    }
    label313:
    for (int i = 10;; i = paramList.size() + 1)
    {
      d5 = (d3 - d4) / i;
      d6 = (d1 - d2) / i;
      paramList = new LatLngBounds.Builder().include(new LatLng(d3 + d5, d1 + d6)).include(new LatLng(d4 - d5, d2 - d6)).build();
      this.c.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(paramList));
      return;
    }
  }
  
  private void b()
  {
    this.v = getIntent().getStringExtra("citycode");
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getProjectSearchConditionV1(this, new d(this, new com.ziroom.ziroomcustomer.ziroomapartment.a.a.a())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("cityList")))
        {
          ZryuMapActivity.a(ZryuMapActivity.this, com.alibaba.fastjson.a.parseArray(paramAnonymouse.getString("cityList"), ZryuCity.class));
          if ((ZryuMapActivity.a(ZryuMapActivity.this) != null) && (ZryuMapActivity.a(ZryuMapActivity.this).size() > 0))
          {
            ZryuMapActivity.a(ZryuMapActivity.this, (ZryuCity)ZryuMapActivity.a(ZryuMapActivity.this).get(0));
            if (!TextUtils.isEmpty(ZryuMapActivity.b(ZryuMapActivity.this)))
            {
              paramAnonymouse = ZryuMapActivity.a(ZryuMapActivity.this).iterator();
              while (paramAnonymouse.hasNext())
              {
                ZryuCity localZryuCity = (ZryuCity)paramAnonymouse.next();
                if (ZryuMapActivity.b(ZryuMapActivity.this).equals(localZryuCity.getCityCode())) {
                  ZryuMapActivity.a(ZryuMapActivity.this, localZryuCity);
                }
              }
            }
            ZryuMapActivity.this.mTvCity.setText(ZryuMapActivity.c(ZryuMapActivity.this).getCityName());
            ZryuMapActivity.a(ZryuMapActivity.this, ZryuMapActivity.c(ZryuMapActivity.this).getCityCode());
          }
        }
      }
    });
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getProjectListV2(this, paramString, new d(this, new b(ZryuListItem.class))
    {
      public void onSuccess(int paramAnonymousInt, List<ZryuListItem> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        ZryuMapActivity.b(ZryuMapActivity.this, paramAnonymousList);
        ZryuMapActivity.d(ZryuMapActivity.this).notifyDataSetChanged();
        ZryuMapActivity.e(ZryuMapActivity.this);
        if (ZryuMapActivity.f(ZryuMapActivity.this)) {
          ZryuMapActivity.c(ZryuMapActivity.this, ZryuMapActivity.g(ZryuMapActivity.this));
        }
      }
    });
  }
  
  private void e()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(0, 0, 0, this.s / 375 * 185);
    this.mMapView.setLayoutParams(localLayoutParams);
    this.c = this.mMapView.getMap();
    this.c.setCompassPosition(new Point((int)(this.mMapView.getWidth() - 80.0F * this.t), (int)(this.mMapView.getHeight() - 100.0F * this.t)));
    this.c.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        if (ZryuMapActivity.h(ZryuMapActivity.this) != null)
        {
          ZryuListItem localZryuListItem = (ZryuListItem)ZryuMapActivity.h(ZryuMapActivity.this).getExtraInfo().getParcelable("zryu");
          ZryuMapActivity.h(ZryuMapActivity.this).setIcon(ZryuMapActivity.a(ZryuMapActivity.this, localZryuListItem, false));
          ZryuMapActivity.h(ZryuMapActivity.this).setZIndex(17);
        }
        ZryuMapActivity.a(ZryuMapActivity.this, paramAnonymousMarker);
        paramAnonymousMarker = (ZryuListItem)paramAnonymousMarker.getExtraInfo().getParcelable("zryu");
        ZryuMapActivity.h(ZryuMapActivity.this).setIcon(ZryuMapActivity.a(ZryuMapActivity.this, paramAnonymousMarker, true));
        ZryuMapActivity.h(ZryuMapActivity.this).setZIndex(18);
        if ((ZryuMapActivity.i(ZryuMapActivity.this) != null) && (ZryuMapActivity.i(ZryuMapActivity.this).isShowing()))
        {
          ZryuMapActivity.i(ZryuMapActivity.this).update(paramAnonymousMarker);
          return true;
        }
        ZryuMapActivity.a(ZryuMapActivity.this, new ZryuProjectDetailPop(ZryuMapActivity.this));
        ZryuMapActivity.i(ZryuMapActivity.this).setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public void onDismiss()
          {
            if (ZryuMapActivity.h(ZryuMapActivity.this) != null)
            {
              ZryuListItem localZryuListItem = (ZryuListItem)ZryuMapActivity.h(ZryuMapActivity.this).getExtraInfo().getParcelable("zryu");
              ZryuMapActivity.h(ZryuMapActivity.this).setIcon(ZryuMapActivity.a(ZryuMapActivity.this, localZryuListItem, false));
              ZryuMapActivity.a(ZryuMapActivity.this, null);
            }
          }
        });
        ZryuMapActivity.i(ZryuMapActivity.this).setTouchInterceptor(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            return false;
          }
        });
        ZryuMapActivity.i(ZryuMapActivity.this).show(ZryuMapActivity.this.mVdlRoot, paramAnonymousMarker);
        return true;
      }
    });
    this.c.setOnMapClickListener(new BaiduMap.OnMapClickListener()
    {
      public void onMapClick(LatLng paramAnonymousLatLng)
      {
        if ((ZryuMapActivity.i(ZryuMapActivity.this) != null) && (ZryuMapActivity.i(ZryuMapActivity.this).isShowing()))
        {
          ZryuMapActivity.i(ZryuMapActivity.this).dismiss();
          ZryuMapActivity.a(ZryuMapActivity.this, null);
        }
      }
      
      public boolean onMapPoiClick(MapPoi paramAnonymousMapPoi)
      {
        return false;
      }
    });
    this.c.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback()
    {
      public void onMapLoaded()
      {
        ZryuMapActivity.a(ZryuMapActivity.this, true);
        if (ZryuMapActivity.g(ZryuMapActivity.this) != null) {
          ZryuMapActivity.c(ZryuMapActivity.this, ZryuMapActivity.g(ZryuMapActivity.this));
        }
      }
    });
    this.mMapView.showZoomControls(false);
    this.mMapView.showScaleControl(false);
  }
  
  private void f()
  {
    this.c.clear();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SDKInitializer.initialize(getApplicationContext());
    setContentView(2130903586);
    this.a = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.unbind();
    }
    if (this.mMapView != null) {
      this.mMapView.onDestroy();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mMapView.onPause();
  }
  
  protected void onResume()
  {
    this.mMapView.onResume();
    super.onResume();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131692903: 
    case 2131692497: 
      do
      {
        return;
        finish();
        return;
      } while ((this.e == null) || (this.e.size() <= 0));
      new ZryuCityPop(this).show(this.mTvCity, this.e, new ZryuCityPop.b()
      {
        public void onCitySelect(ZryuCity paramAnonymousZryuCity)
        {
          if ((ZryuMapActivity.c(ZryuMapActivity.this) != null) && (paramAnonymousZryuCity != null) && (((ZryuMapActivity.c(ZryuMapActivity.this).getCityCode() != null) && (paramAnonymousZryuCity.getCityCode() != null) && (ZryuMapActivity.c(ZryuMapActivity.this).getCityCode().equals(paramAnonymousZryuCity.getCityCode()))) || ((ZryuMapActivity.c(ZryuMapActivity.this).getCityCode() == paramAnonymousZryuCity.getCityCode()) && (ZryuMapActivity.c(ZryuMapActivity.this).getCityCode() == null)))) {}
          while (paramAnonymousZryuCity == null) {
            return;
          }
          ZryuMapActivity.a(ZryuMapActivity.this, paramAnonymousZryuCity);
          if ((ZryuMapActivity.i(ZryuMapActivity.this) != null) && (ZryuMapActivity.i(ZryuMapActivity.this).isShowing()))
          {
            ZryuMapActivity.i(ZryuMapActivity.this).dismiss();
            ZryuMapActivity.a(ZryuMapActivity.this, null);
          }
          ZryuMapActivity.this.mTvCity.setText(ZryuMapActivity.c(ZryuMapActivity.this).getCityName());
          ZryuMapActivity.a(ZryuMapActivity.this, ZryuMapActivity.c(ZryuMapActivity.this).getCityCode());
          ZryuMapActivity.e(ZryuMapActivity.this);
          ZryuMapActivity.j(ZryuMapActivity.this).animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(paramAnonymousZryuCity.getCenterLat(), paramAnonymousZryuCity.getCenterLon())));
        }
      });
      return;
    }
    this.mVdlRoot.slideToBottom();
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      if (ZryuMapActivity.g(ZryuMapActivity.this) == null) {
        return 0;
      }
      return ZryuMapActivity.g(ZryuMapActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return ZryuMapActivity.g(ZryuMapActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final Object localObject1;
      label235:
      label255:
      label295:
      Object localObject2;
      TextView localTextView;
      if (paramView == null)
      {
        paramView = new a(null);
        localObject1 = ZryuMapActivity.this.b.inflate(2130904605, paramViewGroup, false);
        paramView.a = ((SimpleDraweeView)((View)localObject1).findViewById(2131691098));
        paramView.b = ((TextView)((View)localObject1).findViewById(2131690049));
        paramView.c = ((TextView)((View)localObject1).findViewById(2131689912));
        paramView.d = ((TextView)((View)localObject1).findViewById(2131690041));
        paramView.e = ((LinearLayout)((View)localObject1).findViewById(2131695864));
        ((View)localObject1).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject1;
        localObject1 = (ZryuListItem)ZryuMapActivity.g(ZryuMapActivity.this).get(paramInt);
        paramViewGroup.a.setController(c.frescoController(((ZryuListItem)localObject1).getHeadPic()));
        paramViewGroup.b.setText(((ZryuListItem)localObject1).getProName());
        if ((!ae.notNull(((ZryuListItem)localObject1).getPriceTag())) || (!ae.notNull(((ZryuListItem)localObject1).getMinPrice())) || (!ae.notNull(((ZryuListItem)localObject1).getMaxPrice()))) {
          break label476;
        }
        paramViewGroup.c.setText(((ZryuListItem)localObject1).getPriceTag() + ((ZryuListItem)localObject1).getMinPrice() + "-" + ((ZryuListItem)localObject1).getMaxPrice());
        if (!TextUtils.isEmpty(((ZryuListItem)localObject1).getProAddr())) {
          break label488;
        }
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.e.removeAllViews();
        if ((((ZryuListItem)localObject1).getTagList() == null) || (((ZryuListItem)localObject1).getTagList().size() <= 0)) {
          break label531;
        }
        Iterator localIterator = ((ZryuListItem)localObject1).getTagList().iterator();
        if (!localIterator.hasNext()) {
          break label531;
        }
        localObject2 = (String)localIterator.next();
        localTextView = new TextView(ZryuMapActivity.this);
        localTextView.setText((CharSequence)localObject2);
        if (((ZryuListItem)localObject1).getTagFlag() != 1) {
          break label511;
        }
        localTextView.setTextColor(Color.parseColor("#999999"));
        localTextView.setBackgroundResource(2130837908);
      }
      for (;;)
      {
        localTextView.setTextSize(10.0F);
        localTextView.setPadding((int)ZryuMapActivity.k(ZryuMapActivity.this) * 5, (int)ZryuMapActivity.k(ZryuMapActivity.this) * 3, (int)ZryuMapActivity.k(ZryuMapActivity.this) * 5, (int)ZryuMapActivity.k(ZryuMapActivity.this) * 3);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, (int)ZryuMapActivity.k(ZryuMapActivity.this) * 5, 0);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramViewGroup.e.addView(localTextView);
        break label295;
        paramViewGroup = (a)paramView.getTag();
        break;
        label476:
        paramViewGroup.c.setText("");
        break label235;
        label488:
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(((ZryuListItem)localObject1).getProAddr());
        break label255;
        label511:
        localTextView.setTextColor(Color.parseColor("#444444"));
        localTextView.setBackgroundResource(2130837909);
      }
      label531:
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (1 == localObject1.getProjectState())
          {
            g.textToast(ZryuMapActivity.this, "敬请期待");
            return;
          }
          com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(ZryuMapActivity.this, localObject1.getProFid());
        }
      });
      return paramView;
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      TextView c;
      TextView d;
      LinearLayout e;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */