package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html.ImageGetter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep.TransitRouteStepType;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.VerticalDrawerLayout;
import com.ziroom.ziroomcustomer.widget.VerticalDrawerLayout.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HouseMapRoutePlanActivity
  extends BaseHouseMapActivity
{
  private List<BikingRouteLine> A;
  private com.ziroom.ziroomcustomer.util.b.b B = null;
  private int C = 1;
  private LayoutInflater D;
  private int E;
  private float F;
  private OnGetRoutePlanResultListener G = new OnGetRoutePlanResultListener()
  {
    public void onGetBikingRouteResult(BikingRouteResult paramAnonymousBikingRouteResult)
    {
      if (((paramAnonymousBikingRouteResult == null) || (paramAnonymousBikingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousBikingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousBikingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousBikingRouteResult.getRouteLines().size() >= 1)
        {
          HouseMapRoutePlanActivity.d(HouseMapRoutePlanActivity.this, paramAnonymousBikingRouteResult.getRouteLines());
          HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).selectItem(0);
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this), null, null, (BikingRouteLine)paramAnonymousBikingRouteResult.getRouteLines().get(0), null);
          return;
        }
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
      HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
    }
    
    public void onGetDrivingRouteResult(DrivingRouteResult paramAnonymousDrivingRouteResult)
    {
      if (((paramAnonymousDrivingRouteResult == null) || (paramAnonymousDrivingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousDrivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousDrivingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousDrivingRouteResult.getRouteLines().size() >= 1)
        {
          HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this, paramAnonymousDrivingRouteResult.getRouteLines());
          HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).selectItem(0);
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this), null, (DrivingRouteLine)paramAnonymousDrivingRouteResult.getRouteLines().get(0), null, null);
          return;
        }
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
      HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
    }
    
    public void onGetTransitRouteResult(TransitRouteResult paramAnonymousTransitRouteResult)
    {
      if (((paramAnonymousTransitRouteResult == null) || (paramAnonymousTransitRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousTransitRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousTransitRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousTransitRouteResult.getRouteLines().size() >= 1)
        {
          HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this, paramAnonymousTransitRouteResult.getRouteLines());
          HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).selectItem(0);
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this), (TransitRouteLine)paramAnonymousTransitRouteResult.getRouteLines().get(0), null, null, null);
          HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
          return;
        }
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
      HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
    }
    
    public void onGetWalkingRouteResult(WalkingRouteResult paramAnonymousWalkingRouteResult)
    {
      if (((paramAnonymousWalkingRouteResult == null) || (paramAnonymousWalkingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)) || (paramAnonymousWalkingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR))
      {
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      if (paramAnonymousWalkingRouteResult.error == SearchResult.ERRORNO.NO_ERROR)
      {
        if (paramAnonymousWalkingRouteResult.getRouteLines().size() >= 1)
        {
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, paramAnonymousWalkingRouteResult.getRouteLines());
          HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).selectItem(0);
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this), null, null, null, (WalkingRouteLine)paramAnonymousWalkingRouteResult.getRouteLines().get(0));
          return;
        }
        HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
        HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
        return;
      }
      HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this).notifyDataSetChanged();
      HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
    }
  };
  private a g;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131690814)
  MapView mMapView;
  @BindView(2131690820)
  RadioButton mRbBike;
  @BindView(2131690819)
  RadioButton mRbDrive;
  @BindView(2131690818)
  RadioButton mRbTransit;
  @BindView(2131690821)
  RadioButton mRbWalk;
  @BindView(2131690817)
  RadioGroup mRgType;
  @BindView(2131690816)
  RelativeLayout mRlList;
  @BindView(2131690822)
  TextView mTvEmpty;
  @BindView(2131690049)
  TextView mTvName;
  @BindView(2131690815)
  View mVBg;
  @BindView(2131690813)
  VerticalDrawerLayout mVdlRoot;
  private PlanNode r;
  private PlanNode s;
  private String t;
  private BaiduMap u;
  private String v;
  private RoutePlanSearch w = null;
  private List<WalkingRouteLine> x;
  private List<TransitRouteLine> y;
  private List<DrivingRouteLine> z;
  
  private void a(int paramInt, TransitRouteLine paramTransitRouteLine, DrivingRouteLine paramDrivingRouteLine, BikingRouteLine paramBikingRouteLine, WalkingRouteLine paramWalkingRouteLine)
  {
    this.u.clear();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramTransitRouteLine == null);
          paramDrivingRouteLine = new c(this.u);
          this.u.setOnMarkerClickListener(paramDrivingRouteLine);
          this.B = paramDrivingRouteLine;
          paramDrivingRouteLine.setData(paramTransitRouteLine);
          paramDrivingRouteLine.addToMap();
          paramDrivingRouteLine.zoomToSpan();
          return;
        } while (paramDrivingRouteLine == null);
        paramTransitRouteLine = new c(this.u);
        this.u.setOnMarkerClickListener(paramTransitRouteLine);
        this.B = paramTransitRouteLine;
        paramTransitRouteLine.setData(paramDrivingRouteLine);
        paramTransitRouteLine.addToMap();
        paramTransitRouteLine.zoomToSpan();
        return;
      } while (paramBikingRouteLine == null);
      paramTransitRouteLine = new c(this.u);
      this.u.setOnMarkerClickListener(paramTransitRouteLine);
      this.B = paramTransitRouteLine;
      paramTransitRouteLine.setData(paramBikingRouteLine);
      paramTransitRouteLine.addToMap();
      paramTransitRouteLine.zoomToSpan();
      return;
    } while (paramWalkingRouteLine == null);
    paramTransitRouteLine = new c(this.u);
    this.u.setOnMarkerClickListener(paramTransitRouteLine);
    this.B = paramTransitRouteLine;
    paramTransitRouteLine.setData(paramWalkingRouteLine);
    paramTransitRouteLine.addToMap();
    paramTransitRouteLine.zoomToSpan();
  }
  
  private String b(int paramInt)
  {
    if (paramInt < 60) {
      return "小于1分钟";
    }
    if ((paramInt >= 60) && (paramInt < 3600)) {
      return paramInt / 60 + "分钟";
    }
    return paramInt / 3600 + "小时" + paramInt % 3600 / 60 + "分钟";
  }
  
  private void b()
  {
    this.D = LayoutInflater.from(this);
    Object localObject = getResources().getDisplayMetrics();
    this.E = ((DisplayMetrics)localObject).heightPixels;
    this.F = ((DisplayMetrics)localObject).density;
    this.u = this.mMapView.getMap();
    this.u.setBuildingsEnabled(true);
    this.mVdlRoot.setEdge((int)(95.0F * this.F), (int)(((DisplayMetrics)localObject).heightPixels - 320.0F * this.F));
    this.mVdlRoot.setListener(new VerticalDrawerLayout.a()
    {
      public void onDrawerClosed(View paramAnonymousView)
      {
        HouseMapRoutePlanActivity.this.mVBg.setVisibility(8);
        HouseMapRoutePlanActivity.this.mVdlRoot.lockDrawer(false);
      }
      
      public void onDrawerOpened(View paramAnonymousView) {}
      
      public void onDrawerSlide(View paramAnonymousView, float paramAnonymousFloat)
      {
        if (paramAnonymousFloat >= 0.0F)
        {
          HouseMapRoutePlanActivity.this.mVBg.setVisibility(0);
          HouseMapRoutePlanActivity.this.mVBg.setAlpha(0.2F * paramAnonymousFloat);
        }
        while (paramAnonymousFloat >= 0.0F) {
          return;
        }
        HouseMapRoutePlanActivity.this.mVBg.setVisibility(8);
        HouseMapRoutePlanActivity.this.mVdlRoot.lockDrawer(false);
      }
      
      public void onDrawerStateChanged(int paramAnonymousInt) {}
    });
    this.mLv.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          HouseMapRoutePlanActivity.this.mVdlRoot.lockDrawer(false);
          if (HouseMapRoutePlanActivity.this.mVdlRoot.getDrawerOffset() > 0.99D) {
            HouseMapRoutePlanActivity.this.mVdlRoot.lockDrawer(true);
          }
          return;
        }
        HouseMapRoutePlanActivity.this.mVdlRoot.lockDrawer(true);
      }
    });
    this.g = new a(new b()
    {
      public void onRouteSeleced(int paramAnonymousInt, TransitRouteLine paramAnonymousTransitRouteLine, DrivingRouteLine paramAnonymousDrivingRouteLine, BikingRouteLine paramAnonymousBikingRouteLine, WalkingRouteLine paramAnonymousWalkingRouteLine)
      {
        HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, paramAnonymousInt, paramAnonymousTransitRouteLine, paramAnonymousDrivingRouteLine, paramAnonymousBikingRouteLine, paramAnonymousWalkingRouteLine);
      }
    });
    this.mLv.setAdapter(this.g);
    localObject = new TextView(this);
    ((TextView)localObject).setText("通勤数据来源于百度地图");
    ((TextView)localObject).setTextColor(Color.parseColor("#dddddd"));
    ((TextView)localObject).setTextSize(12.0F);
    ((TextView)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    ((TextView)localObject).setPadding((int)(this.F * 18.0F), (int)(this.F * 22.0F), (int)(this.F * 18.0F), (int)(this.F * 22.0F));
    this.mLv.addFooterView((View)localObject);
    this.w = RoutePlanSearch.newInstance();
    this.w.setOnGetRoutePlanResultListener(this.G);
    this.mRgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousRadioGroup, paramAnonymousInt);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this);
          return;
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, 1);
          continue;
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, 2);
          continue;
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, 3);
          continue;
          HouseMapRoutePlanActivity.a(HouseMapRoutePlanActivity.this, 4);
        }
      }
    });
    switch (this.C)
    {
    default: 
      return;
    case 1: 
      this.mRbTransit.setChecked(true);
      return;
    case 2: 
      this.mRbDrive.setChecked(true);
      return;
    case 3: 
      this.mRbBike.setChecked(true);
      return;
    }
    this.mRbWalk.setChecked(true);
  }
  
  private String c(int paramInt)
  {
    if (paramInt > 1000)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat(".0");
      return localDecimalFormat.format(paramInt / 1000.0F) + "公里";
    }
    return paramInt + "米";
  }
  
  private void e()
  {
    if ((this.r != null) && (this.s != null)) {
      this.u.clear();
    }
    switch (this.C)
    {
    default: 
      return;
    case 1: 
      this.w.transitSearch(new TransitRoutePlanOption().city(this.v).from(this.r).to(this.s));
      return;
    case 2: 
      this.w.drivingSearch(new DrivingRoutePlanOption().from(this.r).to(this.s));
      return;
    case 3: 
      this.w.bikingSearch(new BikingRoutePlanOption().from(this.r).to(this.s));
      return;
    }
    this.w.walkingSearch(new WalkingRoutePlanOption().from(this.r).to(this.s));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903201);
    ButterKnife.bind(this);
    paramBundle = (LatLng)getIntent().getParcelableExtra("start");
    LatLng localLatLng = (LatLng)getIntent().getParcelableExtra("end");
    this.C = getIntent().getIntExtra("type", 1);
    this.t = getIntent().getStringExtra("name");
    if ((paramBundle != null) && (localLatLng != null))
    {
      this.r = PlanNode.withLocation(paramBundle);
      this.s = PlanNode.withLocation(localLatLng);
      this.v = (com.ziroom.ziroomcustomer.base.b.c + "市");
      this.mTvName.setText(this.t);
      b();
    }
  }
  
  protected void onDestroy()
  {
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
    super.onResume();
    this.mMapView.onResume();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690815: 
      this.mVdlRoot.slideToBottom();
      return;
    }
    finish();
  }
  
  private class a
    extends BaseAdapter
  {
    private int b;
    private HouseMapRoutePlanActivity.b c;
    private int d = Color.parseColor("#ffa000");
    private int e = Color.parseColor("#999999");
    private int f = Color.parseColor("#444444");
    private Html.ImageGetter g = new Html.ImageGetter()
    {
      public Drawable getDrawable(String paramAnonymousString)
      {
        int i = Integer.parseInt(paramAnonymousString);
        paramAnonymousString = HouseMapRoutePlanActivity.this.getResources().getDrawable(i, null);
        paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
        return paramAnonymousString;
      }
    };
    
    public a(HouseMapRoutePlanActivity.b paramb)
    {
      this.c = paramb;
    }
    
    public int getCount()
    {
      switch (HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this))
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return 0;
            } while (HouseMapRoutePlanActivity.e(HouseMapRoutePlanActivity.this) == null);
            return HouseMapRoutePlanActivity.e(HouseMapRoutePlanActivity.this).size();
          } while (HouseMapRoutePlanActivity.f(HouseMapRoutePlanActivity.this) == null);
          return HouseMapRoutePlanActivity.f(HouseMapRoutePlanActivity.this).size();
        } while (HouseMapRoutePlanActivity.g(HouseMapRoutePlanActivity.this) == null);
        return HouseMapRoutePlanActivity.g(HouseMapRoutePlanActivity.this).size();
      } while (HouseMapRoutePlanActivity.h(HouseMapRoutePlanActivity.this) == null);
      return HouseMapRoutePlanActivity.h(HouseMapRoutePlanActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      switch (HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this))
      {
      default: 
        return null;
      case 1: 
        return HouseMapRoutePlanActivity.e(HouseMapRoutePlanActivity.this).get(paramInt);
      case 2: 
        return HouseMapRoutePlanActivity.f(HouseMapRoutePlanActivity.this).get(paramInt);
      case 3: 
        return HouseMapRoutePlanActivity.g(HouseMapRoutePlanActivity.this).get(paramInt);
      }
      return HouseMapRoutePlanActivity.h(HouseMapRoutePlanActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this) << paramInt + 16;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      View localView;
      StringBuilder localStringBuilder;
      if (paramView == null)
      {
        localView = HouseMapRoutePlanActivity.i(HouseMapRoutePlanActivity.this).inflate(2130904233, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((CheckBox)localView.findViewById(2131694828));
        paramViewGroup.b = ((TextView)localView.findViewById(2131695069));
        paramViewGroup.c = ((TextView)localView.findViewById(2131690073));
        localView.setTag(paramViewGroup);
        localStringBuilder = new StringBuilder("");
        paramView = "";
        switch (HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this))
        {
        }
      }
      Object localObject1;
      for (;;)
      {
        if (!TextUtils.isEmpty(localStringBuilder))
        {
          localObject1 = new SpannableString(localStringBuilder);
          int i = 0;
          Object localObject2;
          for (;;)
          {
            i = localStringBuilder.indexOf("#arrow#", i);
            if (i <= 0) {
              break;
            }
            localObject2 = HouseMapRoutePlanActivity.this.getResources().getDrawable(2130840362);
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
            ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1)
            {
              public void draw(Canvas paramAnonymousCanvas, CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, Paint paramAnonymousPaint)
              {
                Drawable localDrawable = getDrawable();
                paramAnonymousCanvas.save();
                int i = (int)(paramAnonymousInt5 - localDrawable.getBounds().bottom - paramViewGroup.b.getLineSpacingExtra());
                u.d("tag", "====start:" + paramAnonymousInt1 + ",end:" + paramAnonymousInt2 + ",x:" + paramAnonymousFloat + ",y:" + paramAnonymousInt4 + ",top:" + paramAnonymousInt3 + ",bottom:" + paramAnonymousInt5);
                u.d("tag", "====transY:" + i + ",b.getBounds().bottom:" + localDrawable.getBounds().bottom + ",finalVh.tvRoute.getLineSpacingExtra():" + paramViewGroup.b.getLineSpacingExtra());
                paramAnonymousInt2 = i;
                if (this.mVerticalAlignment == 1)
                {
                  paramAnonymousInt3 = paramAnonymousCharSequence.length();
                  paramAnonymousInt1 = 0;
                }
                for (;;)
                {
                  paramAnonymousInt2 = i;
                  if (paramAnonymousInt1 < paramAnonymousInt3)
                  {
                    if (Character.isLetterOrDigit(paramAnonymousCharSequence.charAt(paramAnonymousInt1))) {
                      paramAnonymousInt2 = i - paramAnonymousPaint.getFontMetricsInt().descent;
                    }
                  }
                  else
                  {
                    paramAnonymousCanvas.translate(paramAnonymousFloat, paramAnonymousInt2 + (int)(HouseMapRoutePlanActivity.this.getResources().getDisplayMetrics().density * 3.0F));
                    localDrawable.draw(paramAnonymousCanvas);
                    paramAnonymousCanvas.restore();
                    return;
                  }
                  paramAnonymousInt1 += 1;
                }
              }
            }, i, i + 7, 33);
            i += 6;
          }
          paramViewGroup = (a)paramView.getTag();
          localView = paramView;
          break;
          paramView = (TransitRouteLine)getItem(paramInt);
          localObject1 = paramView.getAllStep();
          int j = 0;
          int m = 0;
          i = 0;
          int k = 0;
          while (k < ((List)localObject1).size())
          {
            localObject2 = (TransitRouteLine.TransitStep)((List)localObject1).get(k);
            if (((TransitRouteLine.TransitStep)localObject2).getStepType() == TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING)
            {
              j += ((TransitRouteLine.TransitStep)localObject2).getDistance();
              k += 1;
            }
            else
            {
              m += ((TransitRouteLine.TransitStep)localObject2).getVehicleInfo().getZonePrice();
              if (i != 0) {
                localStringBuilder.append("#arrow#");
              }
              for (;;)
              {
                localStringBuilder.append(((TransitRouteLine.TransitStep)localObject2).getVehicleInfo().getTitle());
                break;
                i = 1;
              }
            }
          }
          paramView = "约" + HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this, paramView.getDuration()) + "，约步行" + HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this, j);
          continue;
          paramView = (DrivingRouteLine)getItem(paramInt);
          localStringBuilder.append("方案" + (paramInt + 1));
          paramView = "行驶距离" + HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this, paramView.getDistance()) + "，大约需要" + HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this, paramView.getDuration()) + "，路过" + paramView.getLightNum() + "个红绿灯";
          continue;
          paramView = (BikingRouteLine)getItem(paramInt);
          localStringBuilder.append("方案" + (paramInt + 1));
          paramView = "距离" + HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this, paramView.getDistance()) + "，骑行大约需要" + HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this, paramView.getDuration());
          continue;
          paramView = (WalkingRouteLine)getItem(paramInt);
          localStringBuilder.append("方案" + (paramInt + 1));
          paramView = "距离" + HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this, paramView.getDistance()) + "，步行大约需要" + HouseMapRoutePlanActivity.b(HouseMapRoutePlanActivity.this, paramView.getDuration());
          continue;
          if (this.b != paramInt) {
            break label789;
          }
          paramViewGroup.b.setTextColor(this.d);
          paramViewGroup.c.setTextColor(this.f);
          paramViewGroup.a.setChecked(true);
        }
      }
      for (;;)
      {
        paramViewGroup.b.setText((CharSequence)localObject1);
        paramViewGroup.c.setText(paramView);
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (HouseMapRoutePlanActivity.a.a(HouseMapRoutePlanActivity.a.this) != null) {
              switch (HouseMapRoutePlanActivity.c(HouseMapRoutePlanActivity.this))
              {
              }
            }
            for (;;)
            {
              HouseMapRoutePlanActivity.a.a(HouseMapRoutePlanActivity.a.this, paramInt);
              HouseMapRoutePlanActivity.a.this.notifyDataSetChanged();
              return;
              HouseMapRoutePlanActivity.a.a(HouseMapRoutePlanActivity.a.this).onRouteSeleced(1, (TransitRouteLine)HouseMapRoutePlanActivity.a.this.getItem(paramInt), null, null, null);
              continue;
              HouseMapRoutePlanActivity.a.a(HouseMapRoutePlanActivity.a.this).onRouteSeleced(2, null, (DrivingRouteLine)HouseMapRoutePlanActivity.a.this.getItem(paramInt), null, null);
              continue;
              HouseMapRoutePlanActivity.a.a(HouseMapRoutePlanActivity.a.this).onRouteSeleced(3, null, null, (BikingRouteLine)HouseMapRoutePlanActivity.a.this.getItem(paramInt), null);
              continue;
              HouseMapRoutePlanActivity.a.a(HouseMapRoutePlanActivity.a.this).onRouteSeleced(4, null, null, null, (WalkingRouteLine)HouseMapRoutePlanActivity.a.this.getItem(paramInt));
            }
          }
        });
        return localView;
        label789:
        paramViewGroup.b.setTextColor(this.e);
        paramViewGroup.c.setTextColor(this.e);
        paramViewGroup.a.setChecked(false);
      }
    }
    
    public void selectItem(int paramInt)
    {
      this.b = paramInt;
      notifyDataSetChanged();
      HouseMapRoutePlanActivity.this.mLv.setEmptyView(HouseMapRoutePlanActivity.this.mTvEmpty);
    }
    
    private class a
    {
      CheckBox a;
      TextView b;
      TextView c;
      
      private a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void onRouteSeleced(int paramInt, TransitRouteLine paramTransitRouteLine, DrivingRouteLine paramDrivingRouteLine, BikingRouteLine paramBikingRouteLine, WalkingRouteLine paramWalkingRouteLine);
  }
  
  private class c
    extends com.ziroom.ziroomcustomer.util.b.b
  {
    private RouteLine<RouteStep> b = null;
    
    public c(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public List<OverlayOptions> getOverlayOptions()
    {
      Object localObject = null;
      if (this.b == null) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      if (this.b.getStarting() != null) {
        localArrayList1.add(new MarkerOptions().position(this.b.getStarting().getLocation()).icon(BitmapDescriptorFactory.fromResource(2130840343)).zIndex(10));
      }
      if (this.b.getTerminal() != null) {
        localArrayList1.add(new MarkerOptions().position(this.b.getTerminal().getLocation()).icon(BitmapDescriptorFactory.fromResource(2130840370)).zIndex(10));
      }
      if ((this.b.getAllStep() != null) && (this.b.getAllStep().size() > 0))
      {
        Iterator localIterator = this.b.getAllStep().iterator();
        if (localIterator.hasNext())
        {
          List localList = ((RouteStep)localIterator.next()).getWayPoints();
          if ((localList == null) || (localList.size() <= 0)) {
            break label299;
          }
          ArrayList localArrayList2 = new ArrayList();
          if (localObject != null) {
            localArrayList2.add(localObject);
          }
          localArrayList2.addAll(localList);
          if (localArrayList2.size() > 2) {
            localArrayList1.add(new PolylineOptions().points(localArrayList2).width(10).color(Color.parseColor("#018eff")).zIndex(0));
          }
          localObject = (LatLng)localList.get(localList.size() - 1);
        }
      }
      label299:
      for (;;)
      {
        break;
        return localArrayList1;
      }
    }
    
    public boolean onMarkerClick(Marker paramMarker)
    {
      return false;
    }
    
    public boolean onPolylineClick(Polyline paramPolyline)
    {
      return false;
    }
    
    public void setData(RouteLine paramRouteLine)
    {
      this.b = paramRouteLine;
    }
    
    public void zoomToSpan()
    {
      if ((HouseMapRoutePlanActivity.d(HouseMapRoutePlanActivity.this) == null) || (this.b == null) || (this.b.getStarting() == null) || (this.b.getTerminal() == null)) {
        return;
      }
      double d3 = Math.max(this.b.getStarting().getLocation().latitude, this.b.getTerminal().getLocation().latitude);
      double d1 = Math.min(this.b.getStarting().getLocation().latitude, this.b.getTerminal().getLocation().latitude);
      double d5 = Math.max(this.b.getStarting().getLocation().longitude, this.b.getTerminal().getLocation().longitude);
      double d2 = Math.min(this.b.getStarting().getLocation().longitude, this.b.getTerminal().getLocation().longitude);
      d3 += (d3 - d1) / 8.0D;
      double d4 = (d3 - d1) / 4.0D;
      d5 += (d5 - d2) / 8.0D;
      double d6 = (d5 - d2) / 8.0D;
      LatLngBounds localLatLngBounds = new LatLngBounds.Builder().include(new LatLng(d3, d5)).include(new LatLng(d1 - d4, d2 - d6)).build();
      HouseMapRoutePlanActivity.d(HouseMapRoutePlanActivity.this).setMapStatus(MapStatusUpdateFactory.newLatLngBounds(localLatLngBounds));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HouseMapRoutePlanActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */