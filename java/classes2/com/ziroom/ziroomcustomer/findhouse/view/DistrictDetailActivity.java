package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus.Builder;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.b;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.findhouse.b.e;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.EnvBean;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.IntroBean;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.PropertyBean;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.RankBean;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.Share;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.SpaceBean;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.SurroundBean;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.SurroundBean.DataBean;
import com.ziroom.ziroomcustomer.findhouse.model.HouseItem;
import com.ziroom.ziroomcustomer.findhouse.model.ResblockPoiOverlay;
import com.ziroom.ziroomcustomer.findhouse.model.SurroundBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend.Tip;
import com.ziroom.ziroomcustomer.home.ScanPhotoActivity;
import com.ziroom.ziroomcustomer.newServiceList.view.NewsTitleTextView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.AutoLineFeedLayout;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import com.ziroom.ziroomcustomer.widget.ExpandableTextViewNewLine;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView.a;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DistrictDetailActivity
  extends BaseActivity
  implements ObservableScrollView.a
{
  private float A;
  private int B;
  private CycleViewPager.a C = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (DistrictDetailActivity.f(DistrictDetailActivity.this).isCycle())
      {
        paramAnonymousView = new ArrayList();
        Intent localIntent = new Intent(DistrictDetailActivity.g(DistrictDetailActivity.this), ScanPhotoActivity.class);
        Bundle localBundle = new Bundle();
        paramAnonymousView.addAll(DistrictDetailActivity.h(DistrictDetailActivity.this));
        localBundle.putSerializable("photos", paramAnonymousView);
        localIntent.putExtra("position", paramAnonymousInt - 1);
        localIntent.putExtras(localBundle);
        localIntent.putExtra("mHouse_type", 0);
        ScanPhotoActivity.a = DistrictDetailActivity.i(DistrictDetailActivity.this);
        DistrictDetailActivity.this.startActivity(localIntent);
      }
    }
  };
  private CycleViewPager.b D = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      int i = 0;
      if (i < DistrictDetailActivity.j(DistrictDetailActivity.this).size())
      {
        TextView localTextView = (TextView)DistrictDetailActivity.j(DistrictDetailActivity.this).get(i);
        if (i + 1 >= DistrictDetailActivity.j(DistrictDetailActivity.this).size()) {
          if (((Integer)DistrictDetailActivity.k(DistrictDetailActivity.this).get(i)).intValue() <= paramAnonymousInt) {
            DistrictDetailActivity.a(DistrictDetailActivity.this, i);
          }
        }
        for (;;)
        {
          localTextView.setBackground(null);
          localTextView.setTextColor(Color.parseColor("#B2FFFFFF"));
          i += 1;
          break;
          if ((((Integer)DistrictDetailActivity.k(DistrictDetailActivity.this).get(i)).intValue() <= paramAnonymousInt) && (paramAnonymousInt <= ((Integer)DistrictDetailActivity.k(DistrictDetailActivity.this).get(i + 1)).intValue())) {
            DistrictDetailActivity.a(DistrictDetailActivity.this, i);
          }
        }
      }
      ((TextView)DistrictDetailActivity.j(DistrictDetailActivity.this).get(DistrictDetailActivity.l(DistrictDetailActivity.this))).setBackgroundResource(2130838624);
      ((TextView)DistrictDetailActivity.j(DistrictDetailActivity.this).get(DistrictDetailActivity.l(DistrictDetailActivity.this))).setTextColor(ApplicationEx.c.getResources().getColor(2131624583));
    }
  };
  private BaiduMap E;
  private LatLng F;
  private double G = 5.4D;
  private int H = -1;
  private int I = 16;
  private int J = 16;
  private int K = 40960;
  private int L = -6710887;
  private PoiSearch M;
  private int N;
  private PlatformActionListener O = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      DistrictDetailActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      paramAnonymousThrowable.printStackTrace();
      DistrictDetailActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  List<DistrictDetail.SurroundBean.DataBean> a;
  @BindView(2131695957)
  AutoLineFeedLayout alflDistrictInfoTag;
  private CycleViewPager b;
  private DistrictDetail c;
  private String d;
  private Context e;
  @BindView(2131695960)
  ExpandableTextViewNewLine etvDistrictOverview;
  @BindView(2131695963)
  ExpandableTextViewNewLine etvDistrictPropertyManager;
  private Map<String, Integer> f;
  @BindView(2131690881)
  FrameLayout flCarousel;
  private List<Integer> g = new ArrayList();
  @BindView(2131690883)
  HorizontalScrollView hscCarousel;
  @BindView(2131695966)
  HorizontalScrollView hsvSurroundTrafficTitles;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131695970)
  ImageView ivMapCenter;
  @BindView(2131690673)
  ImageView ivShare;
  @BindView(2131695971)
  LinearLayout llAround;
  @BindView(2131690884)
  LinearLayout llCarousel;
  @BindView(2131695972)
  LinearLayout llDistrictDetailRecommend;
  @BindView(2131690889)
  LinearLayoutForListView llDistrictIntroduce;
  @BindView(2131695958)
  LinearLayout llDistrictOverview;
  @BindView(2131695961)
  LinearLayout llDistrictPropertyManager;
  @BindView(2131695954)
  LinearLayout llDistrictRank;
  @BindView(2131695953)
  LinearLayout llDistrictRankAndLabel;
  @BindView(2131695964)
  LinearLayout llDistrictSurroundTraffic;
  @BindView(2131695967)
  LinearLayout llDistrictSurroundTrafficTitle;
  @BindView(2131691583)
  LinearLayout llHeader;
  @BindView(2131690892)
  LinearLayoutForListView llHouse;
  @BindView(2131695969)
  TextureMapView mvDistrictSurroundTraffic;
  @BindView(2131690031)
  ObservableScrollView osv;
  private List<TextView> r = new ArrayList();
  @BindView(2131695968)
  RelativeLayout rlTrafficMap;
  @BindView(2131695973)
  RecyclerView rvRecommend;
  private List<String> s = new ArrayList();
  @BindView(2131695955)
  SimpleDraweeView sdvDistrictOrderIcon;
  private int t;
  @BindView(2131690886)
  TextView tvDistrictConcern;
  @BindView(2131690888)
  TextView tvDistrictIntroduce;
  @BindView(2131690890)
  TextView tvDistrictIntroduceMore;
  @BindView(2131695956)
  TextView tvDistrictLabelTitle;
  @BindView(2131690885)
  TextView tvDistrictName;
  @BindView(2131695959)
  TextView tvDistrictOverviewTitle;
  @BindView(2131695962)
  TextView tvDistrictPropertyManagerTitle;
  @BindView(2131690887)
  TextView tvDistrictSubtitle;
  @BindView(2131690891)
  TextView tvHouse;
  @BindView(2131690893)
  TextView tvHouseMore;
  @BindView(2131695965)
  TextView tvTrafficName;
  private LayoutInflater u;
  private String v;
  @BindView(2131694590)
  View vHeader;
  @BindView(2131696034)
  View vHeaderDivider;
  @BindView(2131690894)
  ViewStub vsError;
  private String w;
  private String x;
  private String y;
  private int z;
  
  private BitmapDescriptor a(PoiInfo paramPoiInfo, int paramInt)
  {
    if (paramPoiInfo == null) {
      return null;
    }
    View localView = getLayoutInflater().inflate(paramInt, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    TextView localTextView = (TextView)localView.findViewById(2131690049);
    localTextView.setText(paramPoiInfo.name);
    localTextView.setPadding((int)(this.A * 10.0F), 0, (int)(this.A * 10.0F), (int)(5.0F * this.A));
    return BitmapDescriptorFactory.fromView(localView);
  }
  
  private void a()
  {
    ButterKnife.bind(this);
    this.z = getResources().getDisplayMetrics().widthPixels;
    this.A = getResources().getDisplayMetrics().density;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.flCarousel.getLayoutParams();
    localLayoutParams.height = (this.z / 4 * 3);
    this.flCarousel.setLayoutParams(localLayoutParams);
    this.b = ((CycleViewPager)getSupportFragmentManager().findFragmentById(2131690882));
    GrowingIO.getInstance().ignoreFragment(this, this.b);
    this.osv.setOnScrollChangedCallback(this);
  }
  
  private void a(PoiResult paramPoiResult)
  {
    if ((paramPoiResult != null) && (paramPoiResult.getAllPoi() != null) && (paramPoiResult.getAllPoi().size() > 0))
    {
      ResblockPoiOverlay localResblockPoiOverlay = new ResblockPoiOverlay(this.E);
      localResblockPoiOverlay.setData(paramPoiResult);
      localResblockPoiOverlay.setBitmapDescriptor(b(paramPoiResult));
      localResblockPoiOverlay.addToMap();
      localResblockPoiOverlay.zoomToSpan();
      return;
    }
    com.freelxl.baselibrary.f.g.textToast(this, "未找到相关结果");
  }
  
  private void a(List<RentHouseRecommend> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.llDistrictDetailRecommend.setVisibility(0);
      float f1 = getResources().getDisplayMetrics().density;
      Object localObject = new LinearLayout.LayoutParams(-1, (int)((this.z - 44.0F * f1) * 2.0F / 3.0F) + (int)(getResources().getDisplayMetrics().density * 104.0F + 0.5F));
      this.rvRecommend.setPadding((int)(f1 * 18.0F), 0, (int)(f1 * 18.0F), 0);
      this.rvRecommend.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayoutManager(this);
      ((LinearLayoutManager)localObject).setOrientation(0);
      this.rvRecommend.setLayoutManager((RecyclerView.h)localObject);
      paramList = new a(paramList);
      this.rvRecommend.setAdapter(paramList);
      return;
    }
    this.llDistrictDetailRecommend.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.tvTrafficName.setVisibility(i);
      this.rlTrafficMap.setVisibility(i);
      return;
    }
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
    if (TextUtils.isEmpty(this.d))
    {
      o();
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("resblock_id", this.d);
    com.ziroom.ziroomcustomer.e.g.getCommonHouseSign(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.b + e.b.ad).tag(this).params(localHashMap).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.a(this.e, new e(DistrictDetail.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        DistrictDetailActivity.b(DistrictDetailActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, DistrictDetail paramAnonymousDistrictDetail)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousDistrictDetail);
        DistrictDetailActivity.a(DistrictDetailActivity.this, paramAnonymousDistrictDetail);
        if (DistrictDetailActivity.this.vsError.getParent() == null) {
          DistrictDetailActivity.this.vsError.setVisibility(8);
        }
        DistrictDetailActivity.this.osv.setVisibility(0);
        DistrictDetailActivity.a(DistrictDetailActivity.this);
      }
    });
  }
  
  private void b(int paramInt)
  {
    int n = 0;
    this.llDistrictSurroundTrafficTitle.measure(this.llDistrictSurroundTrafficTitle.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.llDistrictSurroundTrafficTitle.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.llDistrictSurroundTrafficTitle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    if (k < this.llDistrictSurroundTrafficTitle.getChildCount())
    {
      localObject = (NewsTitleTextView)this.llDistrictSurroundTrafficTitle.getChildAt(k);
      int i1 = ((NewsTitleTextView)localObject).getMeasuredWidth();
      m = j;
      if (k < paramInt) {
        m = j + i1;
      }
      i += i1;
      if (paramInt != k)
      {
        ((NewsTitleTextView)localObject).setTextColor(this.L);
        ((NewsTitleTextView)localObject).setIsHorizontaline(false);
      }
      for (;;)
      {
        k += 1;
        j = m;
        break;
        ((NewsTitleTextView)localObject).setTextColor(this.K);
        ((NewsTitleTextView)localObject).setIsHorizontaline(true);
      }
    }
    if ((this.H == -1) && (this.llDistrictSurroundTrafficTitle != null) && (this.llDistrictSurroundTrafficTitle.getChildCount() > paramInt) && (this.llDistrictSurroundTrafficTitle.getChildAt(paramInt) != null)) {
      this.H = this.llDistrictSurroundTrafficTitle.getChildAt(paramInt).getMeasuredWidth();
    }
    k = n;
    if (paramInt > 0)
    {
      if (paramInt == this.llDistrictSurroundTrafficTitle.getChildCount() - 1) {
        k = n;
      }
    }
    else
    {
      m = getWindowManager().getDefaultDisplay().getWidth();
      n = j - (m - this.H) / 2;
      if (this.N >= paramInt) {
        break label331;
      }
      if (k + (this.H + j) >= m / 2) {
        ((HorizontalScrollView)this.llDistrictSurroundTrafficTitle.getParent()).setScrollX(n * 2);
      }
    }
    for (;;)
    {
      this.N = paramInt;
      return;
      k = this.llDistrictSurroundTrafficTitle.getChildAt(paramInt - 1).getMeasuredWidth();
      break;
      label331:
      if (i - j >= m / 2) {
        ((HorizontalScrollView)this.llDistrictSurroundTrafficTitle.getParent()).setScrollX(n * 2);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.tvHouse.setVisibility(i);
      this.llHouse.setVisibility(i);
      this.tvHouseMore.setVisibility(i);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.tvDistrictIntroduce.setVisibility(i);
      this.llDistrictIntroduce.setVisibility(i);
      this.tvDistrictIntroduceMore.setVisibility(i);
      return;
    }
  }
  
  private void d(String paramString)
  {
    this.M = PoiSearch.newInstance();
    OnGetPoiSearchResultListener local11 = new OnGetPoiSearchResultListener()
    {
      public void onGetPoiDetailResult(PoiDetailResult paramAnonymousPoiDetailResult) {}
      
      public void onGetPoiIndoorResult(PoiIndoorResult paramAnonymousPoiIndoorResult) {}
      
      public void onGetPoiResult(PoiResult paramAnonymousPoiResult)
      {
        if ((paramAnonymousPoiResult == null) || (paramAnonymousPoiResult.error == SearchResult.ERRORNO.RESULT_NOT_FOUND)) {
          com.freelxl.baselibrary.f.g.textToast(DistrictDetailActivity.this, "未找到相关结果");
        }
        while (paramAnonymousPoiResult.error != SearchResult.ERRORNO.NO_ERROR) {
          return;
        }
        DistrictDetailActivity.a(DistrictDetailActivity.this, paramAnonymousPoiResult);
      }
    };
    this.M.setOnGetPoiSearchResultListener(local11);
    e(paramString);
  }
  
  private void e()
  {
    if (this.c == null) {
      return;
    }
    h();
    n();
    g();
    f();
    m();
    l();
    i();
    a(null);
  }
  
  private void e(String paramString)
  {
    this.E.clear();
    k();
    if (ae.notNull(paramString))
    {
      Object localObject = new LatLng(this.F.latitude - 0.027D, this.F.longitude + 0.032D);
      LatLng localLatLng = new LatLng(this.F.latitude + 0.027D, this.F.longitude - 0.032D);
      localObject = new LatLngBounds.Builder().include((LatLng)localObject).include(localLatLng).build();
      this.M.searchInBound(new PoiBoundSearchOption().bound((LatLngBounds)localObject).keyword(paramString));
    }
  }
  
  private void f()
  {
    if (this.c != null)
    {
      if (this.c.environment != null)
      {
        this.v = this.c.environment.title;
        this.w = this.c.environment.desc;
      }
      if (this.c.property != null)
      {
        this.x = this.c.property.title;
        this.y = this.c.property.desc;
      }
    }
    if ((ae.notNull(this.w)) && (ae.notNull(this.v)))
    {
      this.llDistrictOverview.setVisibility(0);
      this.tvDistrictOverviewTitle.setText(this.v);
      this.etvDistrictOverview.setText(this.w);
    }
    while ((ae.notNull(this.y)) && (ae.notNull(this.x)))
    {
      this.llDistrictPropertyManager.setVisibility(0);
      this.tvDistrictPropertyManagerTitle.setText(this.x);
      this.etvDistrictPropertyManager.setText(this.y);
      return;
      this.llDistrictOverview.setVisibility(8);
    }
    this.llDistrictPropertyManager.setVisibility(8);
  }
  
  private void f(String paramString)
  {
    if (ae.isNull(paramString)) {
      this.llAround.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.llAround.setVisibility(0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      float f1 = this.e.getResources().getDisplayMetrics().density;
      this.llAround.removeAllViews();
      int i = 0;
      while (i < localArrayList.size())
      {
        paramString = new TextView(this);
        paramString.setTextSize(2, 14.0F);
        paramString.setTextColor(getResources().getColor(2131624416));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = ((int)(24.0F * f1));
        paramString.setLayoutParams(localLayoutParams);
        paramString.setText((CharSequence)localArrayList.get(i));
        this.llAround.addView(paramString);
        i += 1;
      }
    }
  }
  
  private void g()
  {
    if ((this.c.rank == null) && ((this.c.tag == null) || (this.c.tag.size() <= 0)))
    {
      this.llDistrictRankAndLabel.setVisibility(8);
      return;
    }
    if (this.c.rank != null)
    {
      this.llDistrictRank.setVisibility(0);
      if (ae.notNull(this.c.rank.icon)) {
        this.sdvDistrictOrderIcon.setController(com.freelxl.baselibrary.f.c.frescoController(this.c.rank.icon));
      }
      this.tvDistrictLabelTitle.setText(this.c.rank.desc);
    }
    for (;;)
    {
      List localList = this.c.tag;
      if ((localList == null) || (localList.size() <= 0)) {
        break label224;
      }
      this.alflDistrictInfoTag.setVisibility(0);
      this.alflDistrictInfoTag.removeAllViews();
      int i = 0;
      while (i < localList.size())
      {
        TextView localTextView = (TextView)this.u.inflate(2130904465, this.alflDistrictInfoTag, false);
        localTextView.setText((CharSequence)localList.get(i));
        this.alflDistrictInfoTag.addView(localTextView);
        i += 1;
      }
      break;
      this.llDistrictRank.setVisibility(8);
    }
    label224:
    this.alflDistrictInfoTag.setVisibility(8);
  }
  
  private void h()
  {
    if ((this.c.getSpace() == null) || (this.c.getSpace().size() < 1)) {
      return;
    }
    List localList = this.c.getSpace();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int j = 0;
    int k = 1;
    if (j < localList.size())
    {
      DistrictDetail.SpaceBean localSpaceBean = (DistrictDetail.SpaceBean)localList.get(j);
      int i = k;
      String str;
      if (localSpaceBean.getPhotos_min() != null)
      {
        i = k;
        if (localSpaceBean.getPhotos_min().size() > 0)
        {
          localArrayList1.addAll(localSpaceBean.getPhotos_big());
          localArrayList2.addAll(localSpaceBean.getPhotos_min());
          str = localSpaceBean.getTitle();
          if (!localLinkedHashMap.containsKey(str)) {
            break label246;
          }
          i = 1;
          while (localLinkedHashMap.containsKey(str + i)) {
            i += 1;
          }
          localLinkedHashMap.put(str + i, Integer.valueOf(k));
        }
      }
      for (i = k + localSpaceBean.getPhotos_min().size();; i = k + localSpaceBean.getPhotos_min().size())
      {
        j += 1;
        k = i;
        break;
        label246:
        localLinkedHashMap.put(str, Integer.valueOf(k));
      }
    }
    showCarousel(localArrayList1, localArrayList2, localLinkedHashMap);
  }
  
  private void i()
  {
    if ((TextUtils.isEmpty(this.c.getLat())) || (TextUtils.isEmpty(this.c.getLng())))
    {
      a(false);
      return;
    }
    a(true);
    int i = getResources().getDisplayMetrics().widthPixels;
    Object localObject = this.mvDistrictSurroundTraffic.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = (i / 3 * 2);
    this.mvDistrictSurroundTraffic.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.E = this.mvDistrictSurroundTraffic.getMap();
    this.E.getUiSettings().setAllGesturesEnabled(false);
    this.mvDistrictSurroundTraffic.showZoomControls(false);
    this.mvDistrictSurroundTraffic.showScaleControl(false);
    this.E.setOnMapClickListener(new BaiduMap.OnMapClickListener()
    {
      public void onMapClick(LatLng paramAnonymousLatLng)
      {
        DistrictDetailActivity.m(DistrictDetailActivity.this);
      }
      
      public boolean onMapPoiClick(MapPoi paramAnonymousMapPoi)
      {
        return false;
      }
    });
    this.E.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        DistrictDetailActivity.m(DistrictDetailActivity.this);
        return true;
      }
    });
    this.F = new LatLng(Double.parseDouble(this.c.getLat()), Double.parseDouble(this.c.getLng()));
    localObject = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(this.F).zoom(17.0F).build());
    this.E.setMapStatus((MapStatusUpdate)localObject);
    j();
  }
  
  private void j()
  {
    Object localObject1 = new ViewPager.LayoutParams();
    ((ViewPager.LayoutParams)localObject1).width = -2;
    ((ViewPager.LayoutParams)localObject1).height = -2;
    localObject1 = new ArrayList();
    if ((this.c.surround != null) && (this.c.surround.data != null) && (this.c.surround.data.size() > 0))
    {
      this.tvTrafficName.setText(this.c.surround.title);
      this.hsvSurroundTrafficTitles.setVisibility(0);
      this.a = this.c.surround.data;
      f(((DistrictDetail.SurroundBean.DataBean)this.a.get(this.B)).desc);
      d((String)((DistrictDetail.SurroundBean.DataBean)this.a.get(this.B)).keywords.get(0));
      this.llDistrictSurroundTrafficTitle.removeAllViews();
      int i = 0;
      if (i < this.a.size())
      {
        String str = ((DistrictDetail.SurroundBean.DataBean)this.a.get(i)).title;
        Object localObject2 = this.u.inflate(2130903664, null);
        ((TextView)((View)localObject2).findViewById(2131691097)).setText(str);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new NewsTitleTextView(this);
        if (this.H == -1) {
          this.H = ((int)(this.z / this.G));
        }
        ((NewsTitleTextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(this.H, -1));
        ((NewsTitleTextView)localObject2).setTextSize(this.I);
        ((NewsTitleTextView)localObject2).setText(str);
        ((NewsTitleTextView)localObject2).setGravity(17);
        ((NewsTitleTextView)localObject2).setLineSize(this.A * 30.0F, this.A * 2.0F);
        ((NewsTitleTextView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = 0;
            for (;;)
            {
              if (i < DistrictDetailActivity.this.llDistrictSurroundTrafficTitle.getChildCount())
              {
                if ((NewsTitleTextView)DistrictDetailActivity.this.llDistrictSurroundTrafficTitle.getChildAt(i) == paramAnonymousView)
                {
                  DistrictDetailActivity.a(DistrictDetailActivity.this, ((DistrictDetail.SurroundBean.DataBean)DistrictDetailActivity.this.a.get(i)).desc);
                  DistrictDetailActivity.b(DistrictDetailActivity.this, i);
                  DistrictDetailActivity.c(DistrictDetailActivity.this, i);
                  DistrictDetailActivity.b(DistrictDetailActivity.this, (String)((DistrictDetail.SurroundBean.DataBean)DistrictDetailActivity.this.a.get(i)).keywords.get(0));
                }
              }
              else {
                return;
              }
              i += 1;
            }
          }
        });
        if (i == this.B)
        {
          ((NewsTitleTextView)localObject2).setTextColor(this.K);
          ((NewsTitleTextView)localObject2).setTextSize(this.J);
          ((NewsTitleTextView)localObject2).setIsHorizontaline(true);
        }
        for (;;)
        {
          ((NewsTitleTextView)localObject2).setIsVerticalLine(false);
          ((NewsTitleTextView)localObject2).setHorizontalineColor(this.K);
          this.llDistrictSurroundTrafficTitle.addView((View)localObject2);
          i += 1;
          break;
          ((NewsTitleTextView)localObject2).setTextColor(this.L);
          ((NewsTitleTextView)localObject2).setTextSize(this.I);
          ((NewsTitleTextView)localObject2).setIsHorizontaline(false);
        }
      }
    }
    else
    {
      this.hsvSurroundTrafficTitles.setVisibility(8);
    }
  }
  
  private void k()
  {
    Object localObject = BitmapDescriptorFactory.fromResource(2130839008);
    localObject = new MarkerOptions().position(this.F).icon((BitmapDescriptor)localObject);
    ((Marker)this.E.addOverlay((OverlayOptions)localObject)).setToTop();
  }
  
  private void l()
  {
    if (this.c.getRooms() == null)
    {
      b(false);
      return;
    }
    b(true);
    if (this.c.getRooms().size() < 4) {
      this.tvHouseMore.setVisibility(8);
    }
    for (;;)
    {
      int j = Math.min(this.c.getRooms().size(), 3);
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ((List)localObject).add(this.c.getRooms().get(i));
        i += 1;
      }
      this.tvHouseMore.setVisibility(0);
    }
    Object localObject = new d((List)localObject, this);
    ((d)localObject).setIsDividerShow(false);
    this.llHouse.setDividerVisibility(true);
    this.llHouse.setDividerIndent(18, 18);
    this.llHouse.setAdapter((BaseAdapter)localObject);
    this.llHouse.setOnItemClickListener(new LinearLayoutForListView.a()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        HouseItem localHouseItem = (HouseItem)DistrictDetailActivity.n(DistrictDetailActivity.this).getRooms().get(paramAnonymousInt);
        Intent localIntent = new Intent(DistrictDetailActivity.g(DistrictDetailActivity.this), RentHouseDetailActivity.class);
        localIntent.putExtra("id", localHouseItem.getId());
        localIntent.putExtra("house_id", localHouseItem.getHouse_id());
        DistrictDetailActivity.g(DistrictDetailActivity.this).startActivity(localIntent);
      }
    });
  }
  
  private void m()
  {
    if (this.c.getIntro() == null)
    {
      c(false);
      return;
    }
    c(true);
    Object localObject = this.c.getIntro();
    this.tvDistrictIntroduce.setText(((DistrictDetail.IntroBean)localObject).getTitle());
    this.tvDistrictIntroduceMore.setText(((DistrictDetail.IntroBean)localObject).getTotal_title());
    localObject = new com.ziroom.ziroomcustomer.findhouse.a.a(this, this.c.getIntro().getData());
    this.llDistrictIntroduce.setAdapter((BaseAdapter)localObject);
  }
  
  private void n()
  {
    this.tvDistrictName.setText(this.c.getResblock_name());
    this.tvDistrictSubtitle.setText(this.c.getSubway_primary());
    if ((this.c.getQq_share() == null) || (TextUtils.isEmpty(this.c.getQq_share().getUrl())))
    {
      this.ivShare.setVisibility(8);
      return;
    }
    this.ivShare.setVisibility(0);
  }
  
  private void o()
  {
    this.vsError.setVisibility(0);
    ((ImageView)findViewById(2131695976)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        DistrictDetailActivity.this.finish();
      }
    });
    ((ImageView)findViewById(2131690082)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        DistrictDetailActivity.o(DistrictDetailActivity.this);
      }
    });
  }
  
  private void p()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      localObject = new SurroundBean();
      DistrictDetail.SurroundBean.DataBean localDataBean = (DistrictDetail.SurroundBean.DataBean)this.a.get(i);
      ((SurroundBean)localObject).setKeywords(localDataBean.keywords);
      ((SurroundBean)localObject).setTitle(localDataBean.title);
      localArrayList.add(localObject);
      i += 1;
    }
    Object localObject = new Intent(this.e, ResblockMapActivity.class);
    ((Intent)localObject).putExtra("surround", (Serializable)localArrayList);
    ((Intent)localObject).putExtra("lat", this.c.getLat());
    ((Intent)localObject).putExtra("lng", this.c.getLng());
    ((Intent)localObject).putExtra("resblock_name", this.c.getResblock_name());
    startActivity((Intent)localObject);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903205);
    ButterKnife.bind(this);
    this.e = this;
    this.d = getIntent().getStringExtra("resblockId");
    this.u = LayoutInflater.from(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    if (this.M != null) {
      this.M.destroy();
    }
    if (this.mvDistrictSurroundTraffic != null) {
      this.mvDistrictSurroundTraffic.onDestroy();
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mvDistrictSurroundTraffic.onResume();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / 500.0F;
    this.vHeader.setAlpha(f1);
    this.vHeaderDivider.setAlpha(f1);
    if (f1 > 0.75D)
    {
      this.ivShare.setImageResource(2130840338);
      this.ivBack.setImageResource(2130840141);
      return;
    }
    this.ivShare.setImageResource(2130840339);
    this.ivBack.setImageResource(2130840142);
  }
  
  @OnClick({2131690890, 2131690893, 2131695968, 2131689492, 2131690673})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690890: 
      new DistrictInfoPop(this).show(this.ivBack, this.c.getIntro());
      return;
    case 2131690893: 
      paramView = new Intent(this, HouseListActivity.class);
      paramView.putExtra("etSearch", this.c.getResblock_name());
      startActivity(paramView);
      return;
    case 2131695968: 
      p();
      return;
    case 2131689492: 
      finish();
      return;
    }
    showShare((String)((DistrictDetail.SpaceBean)this.c.getSpace().get(0)).getPhotos_min().get(0), this.c.getQq_share(), this.c.getQzone_share(), this.c.getWeibo_share(), this.c.getWechat_share(), this.c.getMoments_share());
  }
  
  public void showCarousel(List<String> paramList1, List<String> paramList2, LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    if ((!isFinishing()) && (this.llCarousel != null))
    {
      this.f = paramLinkedHashMap;
      paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
      if (paramLinkedHashMap.hasNext())
      {
        final Map.Entry localEntry = (Map.Entry)paramLinkedHashMap.next();
        TextView localTextView = new TextView(ApplicationEx.c);
        localTextView.setText((CharSequence)localEntry.getKey());
        localTextView.setTextColor(Color.parseColor("#B2FFFFFF"));
        localTextView.setTextSize(12.0F);
        localTextView.setGravity(16);
        localTextView.setBackground(null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        if ("房源".equals(localEntry.getKey())) {}
        for (int i = (int)(getResources().getDisplayMetrics().density * 20.0F + 0.5D);; i = (int)(getResources().getDisplayMetrics().density * 40.0F + 0.5D))
        {
          localLayoutParams.setMargins(i, 0, 0, 0);
          localLayoutParams.gravity = 16;
          localTextView.setLayoutParams(localLayoutParams);
          localTextView.setTag(2131690557, localEntry.getValue());
          this.g.add(localEntry.getValue());
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              DistrictDetailActivity.f(DistrictDetailActivity.this).setCurrentItem(((Integer)localEntry.getValue()).intValue());
            }
          });
          this.r.add(localTextView);
          this.llCarousel.addView(localTextView);
          break;
        }
      }
      this.b.setCycle(true);
      this.s = paramList2;
      this.b.setIsPageNumVisible(false);
      this.b.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
      this.b.setPosChangeListener(this.D);
      this.b.setData(this, paramList1, this.C);
      this.b.setWheel(false);
    }
  }
  
  public void showShare(String paramString, DistrictDetail.Share paramShare1, DistrictDetail.Share paramShare2, DistrictDetail.Share paramShare3, DistrictDetail.Share paramShare4, DistrictDetail.Share paramShare5)
  {
    if ((paramShare1 == null) || (paramShare2 == null) || (paramShare3 == null) || (paramShare4 == null) || (paramShare5 == null) || (!"1".equals(paramShare1.getActive()))) {
      return;
    }
    com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter(this, paramShare1.getUrl(), paramShare1.getTitle(), paramShare1.getContent(), paramString, this.O);
  }
  
  private class a
    extends RecyclerView.a<DistrictDetailActivity.b>
  {
    private List<RentHouseRecommend> b;
    private int c;
    
    public a()
    {
      List localList;
      this.b = localList;
      this.c = ((int)(DistrictDetailActivity.c(DistrictDetailActivity.this) - 36.0F * DistrictDetailActivity.d(DistrictDetailActivity.this)));
    }
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public void onBindViewHolder(DistrictDetailActivity.b paramb, int paramInt)
    {
      final RentHouseRecommend localRentHouseRecommend = (RentHouseRecommend)this.b.get(paramInt);
      if (localRentHouseRecommend != null)
      {
        paramb.a.setController(com.freelxl.baselibrary.f.c.frescoController(localRentHouseRecommend.getPhoto()));
        paramb.c.setText("¥" + localRentHouseRecommend.getPrice());
        paramb.b.setText(localRentHouseRecommend.getName());
        paramb.d.setText(localRentHouseRecommend.getSubway_station_info());
        if ((localRentHouseRecommend.getTips() != null) && (localRentHouseRecommend.getTips().size() >= 1)) {
          break label138;
        }
        paramb.e.setVisibility(8);
      }
      for (;;)
      {
        paramb.itemView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(DistrictDetailActivity.this, RentHouseDetailActivity.class);
            paramAnonymousView.putExtra("house_id", localRentHouseRecommend.getHouse_id());
            paramAnonymousView.putExtra("id", localRentHouseRecommend.getId());
            DistrictDetailActivity.this.startActivity(paramAnonymousView);
          }
        });
        return;
        label138:
        paramb.e.setVisibility(0);
        paramb.e.removeAllViews();
        paramInt = 0;
        while (paramInt < localRentHouseRecommend.getTips().size())
        {
          Object localObject = (RentHouseRecommend.Tip)localRentHouseRecommend.getTips().get(paramInt);
          TextView localTextView = new TextView(DistrictDetailActivity.this);
          localTextView.setTextSize(2, 10.0F);
          localTextView.setTextColor(Color.parseColor("#6db4d6"));
          localTextView.setBackgroundResource(2130837954);
          localTextView.setText(((RentHouseRecommend.Tip)localObject).getTitle());
          localTextView.setGravity(17);
          float f = DistrictDetailActivity.this.getResources().getDisplayMetrics().density;
          int i = (int)(6.0F * f);
          int j = (int)(3.0F * f);
          localTextView.setPadding(i, j, i, j);
          localObject = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(f * 6.0F));
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramb.e.addView(localTextView);
          paramInt += 1;
        }
      }
    }
    
    public DistrictDetailActivity.b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = DistrictDetailActivity.e(DistrictDetailActivity.this).inflate(2130904458, paramViewGroup, false);
      DistrictDetailActivity.b localb = new DistrictDetailActivity.b(DistrictDetailActivity.this, paramViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.c * 2 / 3 + (int)(DistrictDetailActivity.d(DistrictDetailActivity.this) * 96.0F + 0.5F));
      localLayoutParams.setMargins(0, 0, (int)(DistrictDetailActivity.d(DistrictDetailActivity.this) * 6.0F), 0);
      paramViewGroup.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.c * 2 / 3);
      localb.a = ((SimpleDraweeView)paramViewGroup.findViewById(2131691098));
      localb.a.setLayoutParams(localLayoutParams);
      localb.c = ((TextView)paramViewGroup.findViewById(2131689912));
      localb.b = ((TextView)paramViewGroup.findViewById(2131690049));
      localb.d = ((TextView)paramViewGroup.findViewById(2131690748));
      localb.e = ((LinearLayout)paramViewGroup.findViewById(2131689834));
      return localb;
    }
  }
  
  private class b
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    LinearLayout e;
    
    public b(View paramView)
    {
      super();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/DistrictDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */