package com.ziroom.ziroomcustomer.findhouse.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager.LayoutParams;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus.Builder;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.utils.DistanceUtil;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.model.MapPlanNode;
import com.ziroom.ziroomcustomer.findhouse.model.ResblockPoiOverlay;
import com.ziroom.ziroomcustomer.findhouse.model.SurroundBean;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.newServiceList.view.NewsTitleTextView;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResblockMapActivity
  extends BaseActivity
{
  private int A = 16;
  private int B = 40960;
  private int C = -6710887;
  private int D;
  private int E;
  private PoiSearch F;
  private String a;
  private List<SurroundBean> b;
  private String c = "";
  private String d = "";
  private final int e = 0;
  private BaiduMap f;
  private LatLng g;
  @BindView(2131696447)
  ConstraintLayout mClPoi;
  @BindView(2131696445)
  HorizontalScrollView mHsvTabs;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131691585)
  ImageView mIvSwitchMode;
  @BindView(2131691584)
  LinearLayout mLlSwitchMode;
  @BindView(2131696446)
  LinearLayout mLlTabs;
  @BindView(2131690823)
  MapView mMapView;
  @BindView(2131690544)
  TextView mTvPoiAddress;
  @BindView(2131696449)
  TextView mTvPoiDistance;
  @BindView(2131696448)
  TextView mTvPoiName;
  @BindView(2131689541)
  TextView mTvTitle;
  private int r;
  private float s;
  private int t = 10;
  private Marker u;
  private GeoCoder v;
  private OnGetGeoCoderResultListener w = new OnGetGeoCoderResultListener()
  {
    public void onGetGeoCodeResult(GeoCodeResult paramAnonymousGeoCodeResult) {}
    
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramAnonymousReverseGeoCodeResult)
    {
      if ((paramAnonymousReverseGeoCodeResult == null) || (paramAnonymousReverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR)) {
        return;
      }
      ResblockMapActivity.this.mTvPoiAddress.setText(paramAnonymousReverseGeoCodeResult.getAddress());
    }
  };
  private double x = 5.4D;
  private int y = -1;
  private int z = 16;
  
  private BitmapDescriptor a(PoiInfo paramPoiInfo, int paramInt)
  {
    if (paramPoiInfo == null) {
      return null;
    }
    View localView = getLayoutInflater().inflate(paramInt, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    TextView localTextView = (TextView)localView.findViewById(2131690049);
    localTextView.setText(paramPoiInfo.name);
    localTextView.setPadding((int)(this.s * 10.0F), 0, (int)(this.s * 10.0F), (int)(5.0F * this.s));
    return BitmapDescriptorFactory.fromView(localView);
  }
  
  private void a()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.r = localDisplayMetrics.widthPixels;
    this.s = localDisplayMetrics.density;
    this.b = ((List)getIntent().getSerializableExtra("surround"));
    this.c = getIntent().getStringExtra("lat");
    this.d = getIntent().getStringExtra("lng");
    this.a = getIntent().getStringExtra("resblock_name");
    b();
  }
  
  private void a(final View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { b.getScreenHeight(this) / 3, 0.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(0);
      }
    });
    localObjectAnimator.start();
  }
  
  private void a(Marker paramMarker)
  {
    if (paramMarker == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = paramMarker.getExtraInfo();
          } while (localObject1 == null);
          localObject1 = (PoiInfo)((Bundle)localObject1).getParcelable("PoiInfo");
        } while (localObject1 == null);
        if (this.u == null) {
          break;
        }
        localObject2 = this.u.getExtraInfo();
      } while (localObject2 == null);
      localObject2 = (PoiInfo)((Bundle)localObject2).getParcelable("PoiInfo");
    } while (localObject2 == null);
    this.u.setIcon(a((PoiInfo)localObject2, 2130904664));
    paramMarker.setIcon(a((PoiInfo)localObject1, 2130904665));
    paramMarker.setToTop();
    b(11);
    this.mTvPoiName.setText(((PoiInfo)localObject1).name);
    this.mTvPoiAddress.setText(((PoiInfo)localObject1).address);
    int i = (int)DistanceUtil.getDistance(this.g, paramMarker.getPosition());
    this.mTvPoiDistance.setText(i + "米");
    this.u = paramMarker;
  }
  
  private void a(LatLng paramLatLng)
  {
    b(10);
  }
  
  private void a(PoiResult paramPoiResult)
  {
    if ((paramPoiResult != null) && (paramPoiResult.getAllPoi() != null) && (paramPoiResult.getAllPoi().size() > 0))
    {
      ResblockPoiOverlay localResblockPoiOverlay = new ResblockPoiOverlay(this.f);
      this.f.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener()
      {
        public boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          ResblockMapActivity.a(ResblockMapActivity.this, paramAnonymousMarker);
          return true;
        }
      });
      localResblockPoiOverlay.setData(paramPoiResult);
      localResblockPoiOverlay.setBitmapDescriptor(b(paramPoiResult));
      localResblockPoiOverlay.addToMap();
      localResblockPoiOverlay.zoomToSpan();
      return;
    }
    g.textToast(this, "未找到相关结果");
  }
  
  private List<BitmapDescriptor> b(PoiResult paramPoiResult)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramPoiResult == null) || (paramPoiResult.getAllPoi() == null) || (paramPoiResult.getAllPoi().size() < 1)) {
      return localArrayList;
    }
    paramPoiResult = paramPoiResult.getAllPoi().iterator();
    while (paramPoiResult.hasNext()) {
      localArrayList.add(a((PoiInfo)paramPoiResult.next(), 2130904664));
    }
    return localArrayList;
  }
  
  private void b()
  {
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.d)))
    {
      this.mHsvTabs.setVisibility(8);
      this.mLlSwitchMode.setVisibility(8);
      g.textToast(this, "小区定位获取失败，请稍后再试");
      return;
    }
    this.f = this.mMapView.getMap();
    Object localObject = this.f.getUiSettings();
    ((UiSettings)localObject).setCompassEnabled(false);
    ((UiSettings)localObject).setOverlookingGesturesEnabled(false);
    ((UiSettings)localObject).setRotateGesturesEnabled(false);
    ((UiSettings)localObject).setScrollGesturesEnabled(true);
    this.mMapView.showZoomControls(false);
    this.mMapView.showScaleControl(false);
    this.f.setOnMapClickListener(new BaiduMap.OnMapClickListener()
    {
      public void onMapClick(LatLng paramAnonymousLatLng)
      {
        if (11 == ResblockMapActivity.a(ResblockMapActivity.this)) {
          ResblockMapActivity.a(ResblockMapActivity.this, paramAnonymousLatLng);
        }
      }
      
      public boolean onMapPoiClick(MapPoi paramAnonymousMapPoi)
      {
        return false;
      }
    });
    this.g = new LatLng(Double.parseDouble(this.c), Double.parseDouble(this.d));
    localObject = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(this.g).zoom(17.0F).build());
    this.f.setMapStatus((MapStatusUpdate)localObject);
    e();
  }
  
  private void b(int paramInt)
  {
    if (paramInt == this.t) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.t = paramInt;
      return;
      b(this.mClPoi);
      a(this.mLlSwitchMode);
      if (this.u != null)
      {
        PoiInfo localPoiInfo = (PoiInfo)this.u.getExtraInfo().getParcelable("PoiInfo");
        this.u.setIcon(a(localPoiInfo, 2130904664));
        continue;
        b(this.mLlSwitchMode);
        a(this.mClPoi);
      }
    }
  }
  
  private void b(final View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, b.getScreenHeight(this) / 3 });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(4);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localObjectAnimator.start();
  }
  
  private void c(int paramInt)
  {
    int n = 0;
    this.mLlTabs.measure(this.mLlTabs.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.mLlTabs.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.mLlTabs.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    if (k < this.mLlTabs.getChildCount())
    {
      localObject = (NewsTitleTextView)this.mLlTabs.getChildAt(k);
      int i1 = ((NewsTitleTextView)localObject).getMeasuredWidth();
      m = j;
      if (k < paramInt) {
        m = j + i1;
      }
      i += i1;
      if (paramInt != k)
      {
        ((NewsTitleTextView)localObject).setTextColor(this.C);
        ((NewsTitleTextView)localObject).setIsHorizontaline(false);
      }
      for (;;)
      {
        k += 1;
        j = m;
        break;
        ((NewsTitleTextView)localObject).setTextColor(this.B);
        ((NewsTitleTextView)localObject).setIsHorizontaline(true);
      }
    }
    if ((this.y == -1) && (this.mLlTabs != null) && (this.mLlTabs.getChildCount() > paramInt) && (this.mLlTabs.getChildAt(paramInt) != null)) {
      this.y = this.mLlTabs.getChildAt(paramInt).getMeasuredWidth();
    }
    k = n;
    if (paramInt > 0)
    {
      if (paramInt == this.mLlTabs.getChildCount() - 1) {
        k = n;
      }
    }
    else
    {
      m = getWindowManager().getDefaultDisplay().getWidth();
      n = j - (m - this.y) / 2;
      if (this.E >= paramInt) {
        break label331;
      }
      if (k + (this.y + j) >= m / 2) {
        ((HorizontalScrollView)this.mLlTabs.getParent()).setScrollX(n * 2);
      }
    }
    for (;;)
    {
      this.E = paramInt;
      return;
      k = this.mLlTabs.getChildAt(paramInt - 1).getMeasuredWidth();
      break;
      label331:
      if (i - j >= m / 2) {
        ((HorizontalScrollView)this.mLlTabs.getParent()).setScrollX(n * 2);
      }
    }
  }
  
  private void d(String paramString)
  {
    this.F = PoiSearch.newInstance();
    OnGetPoiSearchResultListener local6 = new OnGetPoiSearchResultListener()
    {
      public void onGetPoiDetailResult(PoiDetailResult paramAnonymousPoiDetailResult) {}
      
      public void onGetPoiIndoorResult(PoiIndoorResult paramAnonymousPoiIndoorResult) {}
      
      public void onGetPoiResult(PoiResult paramAnonymousPoiResult)
      {
        if (ResblockMapActivity.this.isFinishing()) {}
        do
        {
          return;
          if ((paramAnonymousPoiResult == null) || (paramAnonymousPoiResult.error == SearchResult.ERRORNO.RESULT_NOT_FOUND))
          {
            g.textToast(ResblockMapActivity.this, "未找到相关结果");
            return;
          }
        } while (paramAnonymousPoiResult.error != SearchResult.ERRORNO.NO_ERROR);
        ResblockMapActivity.a(ResblockMapActivity.this, paramAnonymousPoiResult);
      }
    };
    this.F.setOnGetPoiSearchResultListener(local6);
    e(paramString);
  }
  
  private void e()
  {
    Object localObject1 = new ViewPager.LayoutParams();
    ((ViewPager.LayoutParams)localObject1).width = -2;
    ((ViewPager.LayoutParams)localObject1).height = -2;
    localObject1 = new ArrayList();
    if ((this.b != null) && (this.b.size() > 0))
    {
      this.mHsvTabs.setVisibility(0);
      d((String)((SurroundBean)this.b.get(this.D)).keywords.get(0));
      this.mLlTabs.removeAllViews();
      int i = 0;
      if (i < this.b.size())
      {
        String str = ((SurroundBean)this.b.get(i)).title;
        Object localObject2 = LayoutInflater.from(this).inflate(2130903664, null);
        ((TextView)((View)localObject2).findViewById(2131691097)).setText(str);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new NewsTitleTextView(this);
        if (this.y == -1) {
          this.y = ((int)(this.r / this.x));
        }
        ((NewsTitleTextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(this.y, -1));
        ((NewsTitleTextView)localObject2).setTextSize(this.z);
        ((NewsTitleTextView)localObject2).setText(str);
        ((NewsTitleTextView)localObject2).setGravity(17);
        ((NewsTitleTextView)localObject2).setLineSize(this.s * 30.0F, this.s * 2.0F);
        ((NewsTitleTextView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = 0;
            for (;;)
            {
              if (i < ResblockMapActivity.this.mLlTabs.getChildCount())
              {
                if ((NewsTitleTextView)ResblockMapActivity.this.mLlTabs.getChildAt(i) == paramAnonymousView)
                {
                  ResblockMapActivity.a(ResblockMapActivity.this, i);
                  ResblockMapActivity.b(ResblockMapActivity.this, 10);
                  ResblockMapActivity.c(ResblockMapActivity.this, i);
                  ResblockMapActivity.a(ResblockMapActivity.this, (String)((SurroundBean)ResblockMapActivity.b(ResblockMapActivity.this).get(i)).keywords.get(0));
                }
              }
              else {
                return;
              }
              i += 1;
            }
          }
        });
        if (i == this.D)
        {
          ((NewsTitleTextView)localObject2).setTextColor(this.B);
          ((NewsTitleTextView)localObject2).setTextSize(this.A);
          ((NewsTitleTextView)localObject2).setIsHorizontaline(true);
        }
        for (;;)
        {
          ((NewsTitleTextView)localObject2).setIsVerticalLine(false);
          ((NewsTitleTextView)localObject2).setHorizontalineColor(this.B);
          this.mLlTabs.addView((View)localObject2);
          i += 1;
          break;
          ((NewsTitleTextView)localObject2).setTextColor(this.C);
          ((NewsTitleTextView)localObject2).setTextSize(this.z);
          ((NewsTitleTextView)localObject2).setIsHorizontaline(false);
        }
      }
    }
    else
    {
      this.mLlTabs.setVisibility(8);
    }
  }
  
  private void e(String paramString)
  {
    this.f.clear();
    f();
    if (ae.notNull(paramString))
    {
      Object localObject = new LatLng(this.g.latitude - 0.027D, this.g.longitude + 0.032D);
      LatLng localLatLng = new LatLng(this.g.latitude + 0.027D, this.g.longitude - 0.032D);
      localObject = new LatLngBounds.Builder().include((LatLng)localObject).include(localLatLng).build();
      this.F.searchInBound(new PoiBoundSearchOption().bound((LatLngBounds)localObject).keyword(paramString));
    }
  }
  
  private void f()
  {
    Object localObject = BitmapDescriptorFactory.fromResource(2130839008);
    localObject = new MarkerOptions().position(this.g).icon((BitmapDescriptor)localObject);
    ((Marker)this.f.addOverlay((OverlayOptions)localObject)).setToTop();
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this, ResblockMapRouteActivity.class);
    MapPlanNode localMapPlanNode = new MapPlanNode();
    localMapPlanNode.setName(this.a);
    localMapPlanNode.setLatlng(new LatLng(Double.parseDouble(this.c), Double.parseDouble(this.d)));
    localIntent.putExtra("start", localMapPlanNode);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903458);
    ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    if (this.v != null) {
      this.v.destroy();
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
  
  @OnClick({2131689492, 2131691585})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    g();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/ResblockMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */