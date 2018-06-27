package com.ziroom.ziroomcustomer.findhouse.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
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
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.threelib.ziroomshare.f.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceH5Activity;
import com.ziroom.ziroomcustomer.findhouse.model.ResblockPoiOverlay;
import com.ziroom.ziroomcustomer.findhouse.model.SurroundBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.b.a;
import com.ziroom.ziroomcustomer.findhouse.presenter.b.b;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.PayType;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ActivityArray;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ActivityBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Banner;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Config;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Ensure;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Ensure.Detail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.QuestionBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.QuestionListBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ResidentialInfo;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ResidentialInfo.item;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Roommate;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Service;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Service.Detail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Share;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.SignDuration;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.SignDurationInfo;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Sublet;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Tag;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.TipBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.TipBean.TipContent;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend.Tip;
import com.ziroom.ziroomcustomer.home.ScanPhotoActivity;
import com.ziroom.ziroomcustomer.home.ZiRuWebViewActivity;
import com.ziroom.ziroomcustomer.model.BookingOrderTextEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.KeeperInfo;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.InitiateAppointActivity;
import com.ziroom.ziroomcustomer.my.MyCollectionsActivity;
import com.ziroom.ziroomcustomer.signed.CertInformationActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import com.ziroom.ziroomcustomer.signed.SignedCertInfoConfirmActivity;
import com.ziroom.ziroomcustomer.signed.SignerDataActivity;
import com.ziroom.ziroomcustomer.signed.widget.TextLineView;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.AutoLineFeedLayout;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import com.ziroom.ziroomcustomer.widget.ExpandableTextViewNewLine;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.MyGridView;
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

public class RentHouseDetailFragment
  extends BaseFragment
  implements View.OnClickListener, b.b, ObservableScrollView.a
{
  TextView A;
  GridView B;
  LinearLayout C;
  ExpandableTextViewNewLine D;
  LinearLayout E;
  LinearLayout F;
  TextView G;
  TextView H;
  TextView I;
  TextView J;
  ExpandableTextViewNewLine K;
  TextView L;
  LinearLayout M;
  LinearLayout N;
  SimpleDraweeView O;
  MyGridView P;
  TextView Q;
  TextView R;
  LinearLayout S;
  TextView T;
  LinearLayout U;
  ListViewForScrollView V;
  TextView W;
  TextView X;
  TextView Y;
  TextView Z;
  LinearLayout a;
  TextView aA;
  TextView aB;
  LinearLayout aC;
  TextView aD;
  SimpleDraweeView aE;
  TextView aF;
  LinearLayout aG;
  RecyclerView aH;
  ObservableScrollView aI;
  LinearLayout aJ;
  View aK;
  View aL;
  ImageView aM;
  ImageView aN;
  ImageView aO;
  ImageView aP;
  RelativeLayout aQ;
  Button aR;
  Button aS;
  RelativeLayout aT;
  LinearLayout aU;
  TextView aV;
  LinearLayoutForListView aW;
  ImageView aX;
  RelativeLayout aY;
  private final String aZ = "RentHouseDetailActivity";
  TextView aa;
  TextView ab;
  LinearLayout ac;
  LinearLayout ad;
  View ae;
  SimpleDraweeView af;
  TextView ag;
  TextView ah;
  LinearLayout ai;
  TextView aj;
  LinearLayout ak;
  LinearLayout al;
  TextView am;
  TextView an;
  LinearLayout ao;
  ListViewForScrollView ap;
  TextView aq;
  LinearLayout ar;
  LinearLayout as;
  TextView at;
  TextureMapView au;
  ImageView av;
  ListViewForScrollView aw;
  LinearLayout ax;
  SimpleDraweeView ay;
  TextView az;
  LinearLayout b;
  private Map<String, Integer> ba;
  private List<Integer> bb = new ArrayList();
  private List<TextView> bc = new ArrayList();
  private List<String> bd = new ArrayList();
  private int be;
  private b.a bf;
  private int bg;
  private float bh;
  private boolean bi;
  private Dialog bj;
  private LayoutInflater bk;
  private i bl;
  private View bm;
  private Context bn;
  private a bo;
  private CycleViewPager.a bp = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (RentHouseDetailFragment.this.d.isCycle())
      {
        paramAnonymousView = new ArrayList();
        Intent localIntent = new Intent(RentHouseDetailFragment.a(RentHouseDetailFragment.this), ScanPhotoActivity.class);
        Bundle localBundle = new Bundle();
        paramAnonymousView.addAll(RentHouseDetailFragment.b(RentHouseDetailFragment.this));
        localBundle.putSerializable("photos", paramAnonymousView);
        localIntent.putExtra("position", paramAnonymousInt - 1);
        localIntent.putExtras(localBundle);
        localIntent.putExtra("mHouse_type", 0);
        ScanPhotoActivity.a = RentHouseDetailFragment.c(RentHouseDetailFragment.this);
        RentHouseDetailFragment.this.startActivity(localIntent);
        RentHouseDetailFragment.this.onEvent("NC_entire_detail_photo");
      }
    }
  };
  private CycleViewPager.b bq = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      int i = 0;
      if (i < RentHouseDetailFragment.d(RentHouseDetailFragment.this).size())
      {
        TextView localTextView = (TextView)RentHouseDetailFragment.d(RentHouseDetailFragment.this).get(i);
        if (i + 1 >= RentHouseDetailFragment.d(RentHouseDetailFragment.this).size())
        {
          if (((Integer)RentHouseDetailFragment.e(RentHouseDetailFragment.this).get(i)).intValue() <= paramAnonymousInt) {
            RentHouseDetailFragment.a(RentHouseDetailFragment.this, i);
          }
          label85:
          if (Build.VERSION.SDK_INT < 16) {
            break label174;
          }
          localTextView.setBackground(null);
        }
        for (;;)
        {
          localTextView.setTextColor(Color.parseColor("#B2FFFFFF"));
          i += 1;
          break;
          if ((((Integer)RentHouseDetailFragment.e(RentHouseDetailFragment.this).get(i)).intValue() > paramAnonymousInt) || (paramAnonymousInt > ((Integer)RentHouseDetailFragment.e(RentHouseDetailFragment.this).get(i + 1)).intValue())) {
            break label85;
          }
          RentHouseDetailFragment.a(RentHouseDetailFragment.this, i);
          break label85;
          label174:
          localTextView.setBackgroundDrawable(null);
        }
      }
      ((TextView)RentHouseDetailFragment.d(RentHouseDetailFragment.this).get(RentHouseDetailFragment.f(RentHouseDetailFragment.this))).setBackgroundResource(2130838624);
      ((TextView)RentHouseDetailFragment.d(RentHouseDetailFragment.this).get(RentHouseDetailFragment.f(RentHouseDetailFragment.this))).setTextColor(ApplicationEx.c.getResources().getColor(2131624583));
      RentHouseDetailFragment.g(RentHouseDetailFragment.this).updateHouseInfo(((TextView)RentHouseDetailFragment.d(RentHouseDetailFragment.this).get(RentHouseDetailFragment.f(RentHouseDetailFragment.this))).getText().toString());
    }
  };
  private BaiduMap br;
  private LatLng bs;
  private PoiSearch bt;
  private String bu;
  private PlatformActionListener bv = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      g.textToast(RentHouseDetailFragment.a(RentHouseDetailFragment.this), "分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      paramAnonymousThrowable.printStackTrace();
      g.textToast(RentHouseDetailFragment.a(RentHouseDetailFragment.this), "分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  private BroadcastReceiver bw = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getIntExtra("type", 0) == 17) && (paramAnonymousIntent.getIntExtra("status", 0) == 1)) {
        RentHouseDetailFragment.g(RentHouseDetailFragment.this).getCollectFormServer();
      }
    }
  };
  View c;
  CycleViewPager d;
  LinearLayout e;
  ImageView f;
  ImageView g;
  ImageView h;
  HorizontalScrollView i;
  FrameLayout j;
  TextView k;
  TextView l;
  TextView m;
  @BindView(2131692780)
  View mVTitleDivider;
  AutoLineFeedLayout n;
  TextView o;
  TextView p;
  TextView q;
  TextView r;
  TextView s;
  LinearLayout t;
  TextView u;
  TextView v;
  SimpleDraweeView w;
  LinearLayout x;
  TextView y;
  TextView z;
  
  private BitmapDescriptor a(PoiInfo paramPoiInfo, int paramInt)
  {
    if (paramPoiInfo == null) {
      return null;
    }
    View localView = LayoutInflater.from(this.bn).inflate(paramInt, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    TextView localTextView = (TextView)localView.findViewById(2131690049);
    localTextView.setText(paramPoiInfo.name);
    localTextView.setPadding((int)(this.bh * 10.0F), 0, (int)(this.bh * 10.0F), (int)(5.0F * this.bh));
    return BitmapDescriptorFactory.fromView(localView);
  }
  
  private void a(final View paramView1, View paramView2, final View paramView3)
  {
    if ((paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (paramView1.getVisibility() != 0) || (paramView2.getVisibility() != 0)) {
      return;
    }
    this.aY.setVisibility(0);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    int i1 = ac.getStatusHeight(this.bn);
    paramView1.getLocationInWindow(arrayOfInt1);
    paramView2.getLocationInWindow(arrayOfInt2);
    arrayOfInt1[1] -= i1;
    arrayOfInt2[1] -= i1;
    paramView3.setTranslationX(arrayOfInt1[0]);
    paramView3.setTranslationY(arrayOfInt1[1]);
    paramView3.setVisibility(0);
    final float f1 = arrayOfInt1[0];
    f1 = paramView1.getWidth() / 2.0F + f1;
    float f2 = arrayOfInt1[1] + paramView1.getHeight() / 2.0F;
    float f3 = arrayOfInt2[0] + paramView2.getWidth() / 2.0F;
    float f4 = arrayOfInt2[1] + paramView2.getHeight() / 2.0F;
    float f5 = Math.abs(f3 - f1);
    float f6 = Math.abs(f2 - f4);
    paramView1 = new Path();
    paramView1.moveTo(f1, f2);
    paramView1.cubicTo(f5 / 8.0F + f1, f2 - f6 / 3.0F, f1 + f5 * 7.0F / 8.0F, f2 - f6 / 3.0F, f3, f4);
    paramView1 = new PathMeasure(paramView1, false);
    f1 = paramView1.getLength();
    paramView2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramView2.setTarget(paramView3);
    paramView2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f1 = f2 - 0.33333334F;
        if (f1 < 0.0F) {}
        for (f1 = f1 * 3.0F + 2.0F;; f1 = 2.0F - f1 * 3.0F / 2.0F)
        {
          paramView3.setScaleX(f1);
          paramView3.setScaleY(f1);
          int i = paramView3.getMeasuredWidth();
          int j = paramView3.getMeasuredHeight();
          paramAnonymousValueAnimator = new float[2];
          float[] arrayOfFloat = new float[2];
          paramView1.getPosTan(f2 * f1, paramAnonymousValueAnimator, arrayOfFloat);
          paramView3.setX(paramAnonymousValueAnimator[0] - i / 2.0F);
          paramView3.setY(paramAnonymousValueAnimator[1] - j / 2.0F);
          return;
        }
      }
    });
    paramView2.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        RentHouseDetailFragment.this.aY.setVisibility(8);
        paramView3.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    paramView2.setInterpolator(new AccelerateDecelerateInterpolator());
    paramView2.setDuration(600L).start();
  }
  
  private void a(PoiResult paramPoiResult)
  {
    if ((paramPoiResult != null) && (paramPoiResult.getAllPoi() != null) && (paramPoiResult.getAllPoi().size() > 0))
    {
      ResblockPoiOverlay localResblockPoiOverlay = new ResblockPoiOverlay(this.br);
      localResblockPoiOverlay.setData(paramPoiResult);
      localResblockPoiOverlay.setBitmapDescriptor(b(paramPoiResult));
      localResblockPoiOverlay.addToMap();
      localResblockPoiOverlay.zoomToSpan();
      return;
    }
    g.textToast(this.bn, "未找到相关结果");
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
  
  private void b(String paramString)
  {
    this.bt = PoiSearch.newInstance();
    OnGetPoiSearchResultListener local2 = new OnGetPoiSearchResultListener()
    {
      public void onGetPoiDetailResult(PoiDetailResult paramAnonymousPoiDetailResult) {}
      
      public void onGetPoiIndoorResult(PoiIndoorResult paramAnonymousPoiIndoorResult) {}
      
      public void onGetPoiResult(PoiResult paramAnonymousPoiResult)
      {
        if ((RentHouseDetailFragment.this.isDetached()) || (RentHouseDetailFragment.this.getActivity() == null)) {}
        do
        {
          return;
          if ((paramAnonymousPoiResult == null) || (paramAnonymousPoiResult.error == SearchResult.ERRORNO.RESULT_NOT_FOUND))
          {
            g.textToast(RentHouseDetailFragment.a(RentHouseDetailFragment.this), "未找到相关结果");
            return;
          }
        } while (paramAnonymousPoiResult.error != SearchResult.ERRORNO.NO_ERROR);
        RentHouseDetailFragment.a(RentHouseDetailFragment.this, paramAnonymousPoiResult);
      }
    };
    this.bt.setOnGetPoiSearchResultListener(local2);
    c(paramString);
  }
  
  private void c()
  {
    this.bk = LayoutInflater.from(this.bn);
    this.d = ((CycleViewPager)getChildFragmentManager().findFragmentById(2131690882));
    GrowingIO.getInstance().ignoreFragment(getActivity(), this.d);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.bg = localDisplayMetrics.widthPixels;
    this.bh = localDisplayMetrics.density;
    this.j.setLayoutParams(new LinearLayout.LayoutParams(this.bg, this.bg * 3 / 4));
    this.aI.setOnScrollChangedCallback(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.aO.setOnClickListener(this);
    this.aN.setOnClickListener(this);
    this.aQ.setOnClickListener(this);
    this.aR.setOnClickListener(this);
    this.aS.setOnClickListener(this);
    this.ad.setOnClickListener(this);
    this.ah.setOnClickListener(this);
    this.aM.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.Z.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    this.ab.setOnClickListener(this);
    this.an.setOnClickListener(this);
    this.at.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.au.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.aq.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  private void c(String paramString)
  {
    this.br.clear();
    d();
    if (ae.notNull(paramString))
    {
      Object localObject = new LatLng(this.bs.latitude - 0.027D, this.bs.longitude + 0.032D);
      LatLng localLatLng = new LatLng(this.bs.latitude + 0.027D, this.bs.longitude - 0.032D);
      localObject = new LatLngBounds.Builder().include((LatLng)localObject).include(localLatLng).build();
      this.bt.searchInBound(new PoiBoundSearchOption().bound((LatLngBounds)localObject).keyword(paramString));
    }
  }
  
  private void d()
  {
    Object localObject = BitmapDescriptorFactory.fromResource(2130839008);
    localObject = new MarkerOptions().position(this.bs).icon((BitmapDescriptor)localObject);
    ((Marker)this.br.addOverlay((OverlayOptions)localObject)).setToTop();
  }
  
  private void e() {}
  
  public static RentHouseDetailFragment getInstance(RentHouseDetail paramRentHouseDetail)
  {
    RentHouseDetailFragment localRentHouseDetailFragment = new RentHouseDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("detail_json", com.alibaba.fastjson.e.toJSONString(paramRentHouseDetail));
    localRentHouseDetailFragment.setArguments(localBundle);
    d.d("fragment", "======getInstance");
    return localRentHouseDetailFragment;
  }
  
  protected String a()
  {
    String str1 = getArguments().getString("id");
    String str2 = getArguments().getString("houseId");
    return "rid=" + str1 + "&hid=" + str2;
  }
  
  public void dismissSubletCode()
  {
    if ((this.bj != null) && (this.bj.isShowing())) {
      this.bj.dismiss();
    }
  }
  
  public Context getViewContext()
  {
    return getActivity();
  }
  
  public void growingIo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    GrowingIO.getInstance().setPageGroup(this, "YZDetail");
    switch (paramInt)
    {
    }
    for (;;)
    {
      GrowingIO.getInstance().setPS4(this, paramString3);
      GrowingIO.getInstance().setPS3(this, com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
      return;
      GrowingIO.getInstance().setPS2(this, paramString2);
      continue;
      GrowingIO.getInstance().setPS2(this, paramString2);
      continue;
      GrowingIO.getInstance().setPS1(this, paramString1);
    }
  }
  
  public void initHoustTips(RentHouseDetail.TipBean paramTipBean)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if ((paramTipBean == null) || (TextUtils.isEmpty(paramTipBean.getTitle())))
      {
        this.ad.setVisibility(8);
        this.ae.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.ad.setVisibility(0);
    this.ae.setVisibility(0);
    this.ag.setText(paramTipBean.getTitle());
    this.af.setController(c.frescoController(paramTipBean.getIcon()));
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.bn = paramContext;
    this.bo = ((a)paramContext);
    d.d("fragment", "======onAttach");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    String str1 = getArguments().getString("id");
    String str2 = getArguments().getString("houseId");
    if (this.bf == null)
    {
      MobclickAgent.onEvent(this.bn, "app_RentHouseDetailActivity_2");
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_back", "", b(), "");
      this.bo.onBackClick();
      return;
    case 2131696408: 
      this.bf.showActivitysPop();
      return;
    case 2131696059: 
      this.bf.init3D();
      return;
    case 2131696056: 
      showNews("house_detail_collect");
      paramView = ApplicationEx.c.getUser();
      if ((paramView == null) || (TextUtils.isEmpty(paramView.getUid())))
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.bn);
        return;
      }
      if (!this.bf.getCollect()) {
        a(this.aP, this.h, this.aX);
      }
      this.bf.updateCollect();
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_top_store", "hid=" + str2 + "&rid=" + str1, b(), "");
      onEvent("NC_entire_detail_collect");
      return;
    case 2131690673: 
      this.bf.initShare();
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_top_share", "hid=" + str2 + "&rid=" + str1, b(), "");
      onEvent("NC_entire_detail_share");
      return;
    case 2131692622: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_top_check", "", b(), "");
      paramView = new Intent(this.bn, ZiRuWebViewActivity.class);
      paramView.putExtra("ziru", "houseinfo_correct");
      startActivity(paramView);
      return;
    case 2131696057: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_look", "hid=" + str2 + "&rid=" + str1, b(), "");
      paramView = ApplicationEx.c.getUser();
      if ((paramView == null) || (TextUtils.isEmpty(paramView.getUid())))
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.bn);
        return;
      }
      this.bf.submitBtnA();
      onEvent("NC_entire_detail_reserve");
      return;
    case 2131696058: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_look", "hid=" + str2 + "&rid=" + str1, b(), "");
      paramView = ApplicationEx.c.getUser();
      if ((paramView == null) || (TextUtils.isEmpty(paramView.getUid())))
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.bn);
        return;
      }
      this.bf.submitBtnB();
      onEvent("NC_entire_detail_signup");
      return;
    case 2131696417: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_careful", "", b(), "");
      this.bf.showHouseTips();
      return;
    case 2131696444: 
      this.bf.initWillUnrent();
      return;
    case 2131696403: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_pay", "", b(), "");
      this.bf.initPayType();
      return;
    case 2131696437: 
      paramView = new Intent(this.bn, HomeWebActivity.class);
      paramView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/zjlc/b.html");
      paramView.putExtra("title", "转租流程说明");
      startActivity(paramView);
      return;
    case 2131696085: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_peitao_more", "", b(), "");
      this.bf.initSpaceAll();
      return;
    case 2131696397: 
      this.bf.initEnsureAll();
      return;
    case 2131696398: 
      this.bf.initEnsureAll();
      return;
    case 2131696399: 
      this.bf.initEnsureAll();
      return;
    case 2131696400: 
      this.bf.initEnsureAll();
      return;
    case 2131696401: 
      this.bf.initEnsureAll();
      return;
    case 2131696429: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_service_more", "", b(), "");
      this.bf.initServiceAll();
      return;
    case 2131696389: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_more", "", b(), "");
      this.bf.initAroundDetail();
      return;
    case 2131696407: 
      this.bf.initAroundBaiduMap();
      return;
    case 2131696404: 
      this.bf.initHouseCode();
      return;
    case 2131696425: 
      this.bf.initDistrictDetail();
      return;
    case 2131696060: 
      if (this.f.getVisibility() == 0) {
        this.f.setVisibility(8);
      }
      if (ApplicationEx.c.isLoginState())
      {
        startActivity(new Intent(this.bn, MyCollectionsActivity.class));
        return;
      }
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.bn);
      return;
    }
    this.bf.initHxPicDetail();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    d.d("fragment", "======onCreateView");
    paramLayoutInflater = paramLayoutInflater.inflate(2130903978, paramViewGroup, false);
    this.bm = paramLayoutInflater;
    this.f = ((ImageView)paramLayoutInflater.findViewById(2131694340));
    this.g = ((ImageView)paramLayoutInflater.findViewById(2131696059));
    this.c = paramLayoutInflater.findViewById(2131690678);
    this.b = ((LinearLayout)paramLayoutInflater.findViewById(2131696408));
    this.h = ((ImageView)paramLayoutInflater.findViewById(2131696060));
    this.mVTitleDivider = paramLayoutInflater.findViewById(2131692780);
    this.a = ((LinearLayout)paramLayoutInflater.findViewById(2131690884));
    this.e = ((LinearLayout)paramLayoutInflater.findViewById(2131696414));
    this.i = ((HorizontalScrollView)paramLayoutInflater.findViewById(2131690883));
    this.j = ((FrameLayout)paramLayoutInflater.findViewById(2131690881));
    this.k = ((TextView)paramLayoutInflater.findViewById(2131696402));
    this.l = ((TextView)paramLayoutInflater.findViewById(2131696403));
    this.m = ((TextView)paramLayoutInflater.findViewById(2131696404));
    this.n = ((AutoLineFeedLayout)paramLayoutInflater.findViewById(2131696406));
    this.o = ((TextView)paramLayoutInflater.findViewById(2131696061));
    this.p = ((TextView)paramLayoutInflater.findViewById(2131696062));
    this.q = ((TextView)paramLayoutInflater.findViewById(2131696063));
    this.r = ((TextView)paramLayoutInflater.findViewById(2131696064));
    this.s = ((TextView)paramLayoutInflater.findViewById(2131696407));
    this.t = ((LinearLayout)paramLayoutInflater.findViewById(2131696102));
    this.u = ((TextView)paramLayoutInflater.findViewById(2131696103));
    this.v = ((TextView)paramLayoutInflater.findViewById(2131696104));
    this.x = ((LinearLayout)paramLayoutInflater.findViewById(2131691320));
    this.y = ((TextView)paramLayoutInflater.findViewById(2131696410));
    this.z = ((TextView)paramLayoutInflater.findViewById(2131696411));
    this.A = ((TextView)paramLayoutInflater.findViewById(2131696412));
    this.B = ((GridView)paramLayoutInflater.findViewById(2131696413));
    this.C = ((LinearLayout)paramLayoutInflater.findViewById(2131696409));
    this.D = ((ExpandableTextViewNewLine)paramLayoutInflater.findViewById(2131696415));
    this.E = ((LinearLayout)paramLayoutInflater.findViewById(2131696435));
    this.F = ((LinearLayout)paramLayoutInflater.findViewById(2131696440));
    this.G = ((TextView)paramLayoutInflater.findViewById(2131696436));
    this.H = ((TextView)paramLayoutInflater.findViewById(2131696437));
    this.I = ((TextView)paramLayoutInflater.findViewById(2131696438));
    this.J = ((TextView)paramLayoutInflater.findViewById(2131696439));
    this.K = ((ExpandableTextViewNewLine)paramLayoutInflater.findViewById(2131696441));
    this.L = ((TextView)paramLayoutInflater.findViewById(2131696085));
    this.M = ((LinearLayout)paramLayoutInflater.findViewById(2131696084));
    this.N = ((LinearLayout)paramLayoutInflater.findViewById(2131696087));
    this.O = ((SimpleDraweeView)paramLayoutInflater.findViewById(2131696086));
    this.P = ((MyGridView)paramLayoutInflater.findViewById(2131696090));
    this.Q = ((TextView)paramLayoutInflater.findViewById(2131696088));
    this.R = ((TextView)paramLayoutInflater.findViewById(2131696089));
    this.S = ((LinearLayout)paramLayoutInflater.findViewById(2131696442));
    this.T = ((TextView)paramLayoutInflater.findViewById(2131696443));
    this.U = ((LinearLayout)paramLayoutInflater.findViewById(2131696427));
    this.V = ((ListViewForScrollView)paramLayoutInflater.findViewById(2131696428));
    this.W = ((TextView)paramLayoutInflater.findViewById(2131696396));
    this.X = ((TextView)paramLayoutInflater.findViewById(2131696397));
    this.Y = ((TextView)paramLayoutInflater.findViewById(2131696398));
    this.Z = ((TextView)paramLayoutInflater.findViewById(2131696399));
    this.aa = ((TextView)paramLayoutInflater.findViewById(2131696400));
    this.ab = ((TextView)paramLayoutInflater.findViewById(2131696401));
    this.ac = ((LinearLayout)paramLayoutInflater.findViewById(2131696395));
    this.ad = ((LinearLayout)paramLayoutInflater.findViewById(2131696417));
    this.ae = paramLayoutInflater.findViewById(2131696416);
    this.af = ((SimpleDraweeView)paramLayoutInflater.findViewById(2131696418));
    this.w = ((SimpleDraweeView)paramLayoutInflater.findViewById(2131696405));
    this.ag = ((TextView)paramLayoutInflater.findViewById(2131690975));
    this.ah = ((TextView)paramLayoutInflater.findViewById(2131696444));
    this.ai = ((LinearLayout)paramLayoutInflater.findViewById(2131696431));
    this.aj = ((TextView)paramLayoutInflater.findViewById(2131696432));
    this.ak = ((LinearLayout)paramLayoutInflater.findViewById(2131696433));
    this.al = ((LinearLayout)paramLayoutInflater.findViewById(2131696434));
    this.am = ((TextView)paramLayoutInflater.findViewById(2131696280));
    this.an = ((TextView)paramLayoutInflater.findViewById(2131696429));
    this.ao = ((LinearLayout)paramLayoutInflater.findViewById(2131690693));
    this.ap = ((ListViewForScrollView)paramLayoutInflater.findViewById(2131696430));
    this.aq = ((TextView)paramLayoutInflater.findViewById(2131696425));
    this.ar = ((LinearLayout)paramLayoutInflater.findViewById(2131696426));
    this.as = ((LinearLayout)paramLayoutInflater.findViewById(2131696424));
    this.at = ((TextView)paramLayoutInflater.findViewById(2131696389));
    this.au = ((TextureMapView)paramLayoutInflater.findViewById(2131690823));
    this.av = ((ImageView)paramLayoutInflater.findViewById(2131696070));
    this.aw = ((ListViewForScrollView)paramLayoutInflater.findViewById(2131696390));
    this.ax = ((LinearLayout)paramLayoutInflater.findViewById(2131696419));
    this.ay = ((SimpleDraweeView)paramLayoutInflater.findViewById(2131696420));
    this.az = ((TextView)paramLayoutInflater.findViewById(2131696421));
    this.aA = ((TextView)paramLayoutInflater.findViewById(2131696082));
    this.aB = ((TextView)paramLayoutInflater.findViewById(2131696422));
    this.aC = ((LinearLayout)paramLayoutInflater.findViewById(2131696391));
    this.aD = ((TextView)paramLayoutInflater.findViewById(2131696392));
    this.aE = ((SimpleDraweeView)paramLayoutInflater.findViewById(2131696393));
    this.aF = ((TextView)paramLayoutInflater.findViewById(2131696394));
    this.aG = ((LinearLayout)paramLayoutInflater.findViewById(2131696423));
    this.aH = ((RecyclerView)paramLayoutInflater.findViewById(2131695973));
    this.aI = ((ObservableScrollView)paramLayoutInflater.findViewById(2131690031));
    this.aJ = ((LinearLayout)paramLayoutInflater.findViewById(2131691583));
    this.aK = paramLayoutInflater.findViewById(2131694590);
    this.aL = paramLayoutInflater.findViewById(2131696034);
    this.aM = ((ImageView)paramLayoutInflater.findViewById(2131689492));
    this.aN = ((ImageView)paramLayoutInflater.findViewById(2131692622));
    this.aO = ((ImageView)paramLayoutInflater.findViewById(2131690673));
    this.aP = ((ImageView)paramLayoutInflater.findViewById(2131695260));
    this.aQ = ((RelativeLayout)paramLayoutInflater.findViewById(2131696056));
    this.aR = ((Button)paramLayoutInflater.findViewById(2131696057));
    this.aS = ((Button)paramLayoutInflater.findViewById(2131696058));
    this.aT = ((RelativeLayout)paramLayoutInflater.findViewById(2131694339));
    this.aU = ((LinearLayout)paramLayoutInflater.findViewById(2131696100));
    this.aV = ((TextView)paramLayoutInflater.findViewById(2131690939));
    this.aW = ((LinearLayoutForListView)paramLayoutInflater.findViewById(2131696101));
    this.aX = ((ImageView)paramLayoutInflater.findViewById(2131694342));
    this.aY = ((RelativeLayout)paramLayoutInflater.findViewById(2131694341));
    c();
    paramViewGroup = getArguments().getString("detail_json");
    if ((this.bf != null) && (!TextUtils.isEmpty(paramViewGroup))) {
      this.bf.init(paramViewGroup);
    }
    paramViewGroup = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.bn).registerReceiver(this.bw, paramViewGroup);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    LocalBroadcastManager.getInstance(this.bn).unregisterReceiver(this.bw);
    if (this.bt != null) {
      this.bt.destroy();
    }
    if (this.au != null) {
      this.au.onDestroy();
    }
    this.au = null;
    if (this.bf != null) {
      this.bf.detachView();
    }
    super.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if ((this.bj != null) && (this.bj.isShowing())) {
      this.bj.dismiss();
    }
    if (this.bl != null) {
      this.bl.cancel();
    }
  }
  
  public void onEvent(String paramString)
  {
    HashMap localHashMap = new HashMap();
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      localHashMap.put("uid", localUserInfo.getUid());
    }
    localHashMap.put("houseCODE", getArguments().getString("houseId"));
    a(paramString, localHashMap);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.au != null) {
      this.au.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.bf != null) {
      this.bf.getCollectFormServer();
    }
    if (this.au != null) {
      this.au.onResume();
    }
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / 500.0F;
    this.aK.setAlpha(f1);
    this.aL.setAlpha(f1);
    if (f1 > 0.75D)
    {
      this.bi = true;
      this.aN.setImageResource(2130840202);
      this.aO.setImageResource(2130840338);
      this.aM.setImageResource(2130840141);
      this.h.setImageResource(2130840223);
      this.mVTitleDivider.setVisibility(0);
    }
    for (;;)
    {
      if (this.bf != null) {
        showCollection(this.bf.getCollect(), this.bf.ismIsWillUnrent());
      }
      return;
      this.bi = false;
      this.aN.setImageResource(2130840203);
      this.aO.setImageResource(2130840339);
      this.aM.setImageResource(2130840142);
      this.h.setImageResource(2130840224);
      this.mVTitleDivider.setVisibility(8);
    }
  }
  
  public void saveHouseCode2Clipboard(String paramString)
  {
    if (getActivity() != null) {
      ((ClipboardManager)getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", paramString));
    }
  }
  
  public void setPresenter(b.a parama)
  {
    this.bf = parama;
  }
  
  public void show3D(String paramString)
  {
    if (ae.isNull(paramString))
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
  }
  
  public void show3D(String paramString1, String paramString2) {}
  
  public void showActivitys(List<RentHouseDetail.ActivityArray> paramList)
  {
    if (paramList == null)
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    int i1;
    for (;;)
    {
      return;
      this.c.setVisibility(0);
      this.b.setVisibility(0);
      this.b.removeAllViews();
      i1 = 0;
      while (i1 < paramList.size())
      {
        if (paramList.get(i1) != null) {
          break label75;
        }
        i1 += 1;
      }
    }
    label75:
    View localView = View.inflate(getViewContext(), 2130905219, null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131690097);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131693178);
    TextView localTextView = (TextView)localView.findViewById(2131689541);
    if (i1 == 0)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      ah.setTextColor(localTextView, "【" + ((RentHouseDetail.ActivityArray)paramList.get(i1)).getName() + "】" + ((RentHouseDetail.ActivityArray)paramList.get(i1)).getTitle(), 0, ("【" + ((RentHouseDetail.ActivityArray)paramList.get(i1)).getName() + "】").length());
      this.b.addView(localView);
      break;
      localImageView1.setVisibility(4);
      localImageView2.setVisibility(8);
    }
  }
  
  public void showActivitysPop(List<RentHouseDetail.ActivityArray> paramList)
  {
    HouseActivityPop localHouseActivityPop = new HouseActivityPop(getViewContext());
    localHouseActivityPop.show(this.b, paramList);
    localHouseActivityPop.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        ah.backgroundAlpha(1.0F, RentHouseDetailFragment.this.getActivity());
      }
    });
  }
  
  public void showAround(RentHouseDetail.ResidentialInfo paramResidentialInfo)
  {
    if ((isDetached()) || (!isAdded())) {}
    do
    {
      return;
      this.au.setVisibility(0);
      float f1 = this.bg / 375 * 180;
      this.au.setLayoutParams(new FrameLayout.LayoutParams(-1, (int)f1));
      this.br = this.au.getMap();
      this.br.getUiSettings().setAllGesturesEnabled(false);
      this.au.showZoomControls(false);
      this.au.showScaleControl(false);
      this.br.setBuildingsEnabled(false);
      this.br.clear();
      this.br.setOnMapClickListener(new BaiduMap.OnMapClickListener()
      {
        public void onMapClick(LatLng paramAnonymousLatLng)
        {
          RentHouseDetailFragment.g(RentHouseDetailFragment.this).initAroundBaiduMap();
        }
        
        public boolean onMapPoiClick(MapPoi paramAnonymousMapPoi)
        {
          return false;
        }
      });
      this.br.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener()
      {
        public boolean onMarkerClick(Marker paramAnonymousMarker)
        {
          RentHouseDetailFragment.g(RentHouseDetailFragment.this).initAroundBaiduMap();
          return true;
        }
      });
      this.bs = new LatLng(Double.parseDouble(paramResidentialInfo.getLat()), Double.parseDouble(paramResidentialInfo.getLng()));
      MapStatusUpdate localMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(this.bs).zoom(15.0F).build());
      Object localObject = BitmapDescriptorFactory.fromResource(2130839008);
      localObject = new MarkerOptions().position(this.bs).icon((BitmapDescriptor)localObject).zIndex(17);
      ((Marker)this.br.addOverlay((OverlayOptions)localObject)).setToTop();
      this.br.setMapStatus(localMapStatusUpdate);
    } while ((paramResidentialInfo.getSubway() == null) || (paramResidentialInfo.getSubway().size() <= 0));
    this.aw.setAdapter(new a(paramResidentialInfo.getSubway()));
  }
  
  public void showAroundAll(RentHouseDetail.ResidentialInfo paramResidentialInfo)
  {
    new RentHouseDetailAroundPop(this.bn).show(this.at, paramResidentialInfo);
  }
  
  public void showAroundBaiduMap(String paramString1, String paramString2, String paramString3, List<SurroundBean> paramList)
  {
    Intent localIntent = new Intent(this.bn, ResblockMapActivity.class);
    localIntent.putExtra("surround", (Serializable)paramList);
    localIntent.putExtra("lat", paramString3);
    localIntent.putExtra("lng", paramString2);
    localIntent.putExtra("resblock_name", paramString1);
    startActivity(localIntent);
  }
  
  public void showAroundPoi(List<SurroundBean> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    do
    {
      return;
      paramList = ((SurroundBean)paramList.get(0)).getKeywords();
    } while ((paramList == null) || (paramList.size() < 1));
    this.bu = ((String)paramList.get(0));
    b(this.bu);
  }
  
  public void showBanner(final RentHouseDetail.Banner paramBanner)
  {
    if ((paramBanner == null) || (ae.isNull(paramBanner.getPhoto()))) {
      this.w.setVisibility(8);
    }
    do
    {
      return;
      this.t.setVisibility(8);
      this.w.setVisibility(0);
      this.w.setController(c.frescoController(paramBanner.getPhoto()));
    } while (ae.isNull(paramBanner.getLink()));
    this.w.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        JsBridgeWebActivity.start(RentHouseDetailFragment.a(RentHouseDetailFragment.this), paramBanner.getTitle(), paramBanner.getLink());
      }
    });
  }
  
  public void showBigPic(String paramString) {}
  
  public void showBookDialog(final BookingOrderTextEntity paramBookingOrderTextEntity)
  {
    paramBookingOrderTextEntity = BookingOrderDialog.getInstance(paramBookingOrderTextEntity);
    paramBookingOrderTextEntity.setOnComfirmSignListener(new BookingOrderDialog.a()
    {
      public void comfirmSign()
      {
        RentHouseDetailFragment.g(RentHouseDetailFragment.this).doBook();
        paramBookingOrderTextEntity.dismiss();
      }
    });
    android.app.FragmentManager localFragmentManager;
    if (isStateEnable())
    {
      localFragmentManager = getActivity().getFragmentManager();
      if (!(paramBookingOrderTextEntity instanceof android.app.DialogFragment)) {
        paramBookingOrderTextEntity.show(localFragmentManager, "booking");
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialogFragment((android.app.DialogFragment)paramBookingOrderTextEntity, localFragmentManager, "booking");
  }
  
  public void showBottom(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, boolean paramBoolean4, long paramLong, boolean paramBoolean5)
  {
    if (paramLong > 0L)
    {
      this.bl = new i(1000L * paramLong, 1000L);
      this.bl.start();
    }
    if (paramBoolean1)
    {
      this.aQ.setVisibility(0);
      if (!paramBoolean3) {
        break label154;
      }
      this.aR.setVisibility(0);
      if (!paramBoolean2) {
        break label138;
      }
      this.aR.setTextColor(Color.parseColor("#444444"));
      label78:
      this.aR.setText(paramString1);
      this.aR.setEnabled(paramBoolean2);
    }
    for (;;)
    {
      if (!paramBoolean5) {
        break label166;
      }
      this.aS.setVisibility(0);
      this.aS.setText(paramString2);
      this.aS.setEnabled(paramBoolean4);
      return;
      this.aQ.setVisibility(8);
      break;
      label138:
      this.aR.setTextColor(Color.parseColor("#DDDDDD"));
      break label78;
      label154:
      this.aR.setVisibility(8);
    }
    label166:
    this.aS.setVisibility(8);
  }
  
  public void showCarousel(List<String> paramList1, List<String> paramList2, LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    if (this.a != null)
    {
      this.ba = paramLinkedHashMap;
      paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
      if (paramLinkedHashMap.hasNext())
      {
        final Map.Entry localEntry = (Map.Entry)paramLinkedHashMap.next();
        TextView localTextView = new TextView(ApplicationEx.c);
        localTextView.setText((CharSequence)localEntry.getKey());
        localTextView.setTextColor(Color.parseColor("#B2FFFFFF"));
        localTextView.setTextSize(12.0F);
        localTextView.setGravity(16);
        label109:
        LinearLayout.LayoutParams localLayoutParams;
        if (Build.VERSION.SDK_INT >= 16)
        {
          localTextView.setBackground(null);
          localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
          if (!"房源".equals(localEntry.getKey())) {
            break label263;
          }
        }
        label263:
        for (int i1 = (int)(getResources().getDisplayMetrics().density * 20.0F + 0.5D);; i1 = (int)(getResources().getDisplayMetrics().density * 40.0F + 0.5D))
        {
          localLayoutParams.setMargins(i1, 0, 0, 0);
          localLayoutParams.gravity = 16;
          localTextView.setLayoutParams(localLayoutParams);
          localTextView.setTag(2131690557, localEntry.getValue());
          this.bb.add(localEntry.getValue());
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              RentHouseDetailFragment.this.d.setCurrentItem(((Integer)localEntry.getValue()).intValue());
            }
          });
          this.bc.add(localTextView);
          this.a.addView(localTextView);
          break;
          localTextView.setBackgroundDrawable(null);
          break label109;
        }
      }
      this.d.setCycle(true);
      this.bd = paramList2;
      this.d.setIsPageNumVisible(false);
      this.d.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
      this.d.setPosChangeListener(this.bq);
      this.d.setData(this.bn, paramList1, this.bp);
      this.d.setWheel(false);
    }
  }
  
  public void showCollection(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          this.aS.setText("已收藏");
        }
        this.aP.setImageResource(2130840221);
      }
    }
    else {
      return;
    }
    if (paramBoolean2) {
      this.aS.setText("立即收藏");
    }
    this.aP.setImageResource(2130840220);
  }
  
  public void showCoordination(final String paramString1, String paramString2, final String paramString3, String paramString4, final String paramString5)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break label38;
      }
      this.aC.setVisibility(8);
    }
    label38:
    do
    {
      return;
      this.aC.setVisibility(0);
      this.aD.setText(paramString1);
      int i1 = (int)(this.bg - 36.0F * this.bh);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, i1 / 3 * 2);
      localLayoutParams.setMargins((int)(this.bh * 18.0F), 0, (int)(this.bh * 18.0F), 0);
      this.aE.setLayoutParams(localLayoutParams);
      this.aE.setController(c.frescoController(paramString2));
      this.aF.setText(paramString4);
    } while (TextUtils.isEmpty(paramString3));
    this.aE.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ((!TextUtils.isEmpty(paramString5)) && ("1".equals(paramString5)))
        {
          if ("youpin".equals(paramString3))
          {
            paramAnonymousView = ad.getOther(RentHouseDetailFragment.a(RentHouseDetailFragment.this), "youpinH5url");
            if (!TextUtils.isEmpty(paramAnonymousView))
            {
              Intent localIntent = new Intent(RentHouseDetailFragment.a(RentHouseDetailFragment.this), YouPinGuidanceH5Activity.class);
              localIntent.putExtra("youpinH5url", paramAnonymousView);
              RentHouseDetailFragment.this.startActivity(localIntent);
            }
          }
          else
          {
            return;
          }
          paramAnonymousView = new Intent(RentHouseDetailFragment.a(RentHouseDetailFragment.this), YouPinGuidanceActivity.class);
          RentHouseDetailFragment.this.startActivity(paramAnonymousView);
          return;
        }
        JsBridgeWebActivity.start(RentHouseDetailFragment.a(RentHouseDetailFragment.this), paramString1, paramString3);
      }
    });
  }
  
  public void showCountTimeFinish()
  {
    this.aS.setText("立即签约");
    this.aS.setBackgroundColor(Color.parseColor("#FFA000"));
    this.aS.setEnabled(true);
  }
  
  public void showEnsure(RentHouseDetail.Ensure paramEnsure)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (paramEnsure == null) {
        break label185;
      }
      this.ac.setVisibility(0);
      this.ao.setVisibility(8);
      this.W.setText(paramEnsure.getTitle());
      paramEnsure = paramEnsure.getDetailed();
      if (paramEnsure != null) {
        break label65;
      }
      this.ac.setVisibility(8);
    }
    label65:
    do
    {
      return;
      if (paramEnsure.size() > 0) {
        this.Y.setText(((RentHouseDetail.Ensure.Detail)paramEnsure.get(0)).getTitle());
      }
      if (paramEnsure.size() > 1) {
        this.Z.setText(((RentHouseDetail.Ensure.Detail)paramEnsure.get(1)).getTitle());
      }
      if (paramEnsure.size() > 2) {
        this.aa.setText(((RentHouseDetail.Ensure.Detail)paramEnsure.get(2)).getTitle());
      }
    } while (paramEnsure.size() <= 3);
    this.ab.setText(((RentHouseDetail.Ensure.Detail)paramEnsure.get(3)).getTitle());
    return;
    label185:
    this.ac.setVisibility(8);
  }
  
  public void showEnsureAll(RentHouseDetail.Ensure paramEnsure)
  {
    new RentHouseDetailEnsuresPop(this.bn).show(this.X, paramEnsure);
  }
  
  public void showHeader(String paramString)
  {
    if ((!isDetached()) && (isAdded()))
    {
      e();
      this.m.setFocusable(true);
      this.m.setFocusableInTouchMode(true);
      this.m.requestFocus();
      this.aI.smoothScrollTo(0, 0);
      this.aK.setAlpha(0.0F);
      this.aL.setAlpha(0.0F);
    }
  }
  
  public void showHouseCode(String paramString)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this.bn).setTitle("房源编号").setContent(paramString).build().show();
    g.textToast(this.bn, "已复制房源编号");
  }
  
  public void showHouseConfig(List<RentHouseDetail.Config> paramList) {}
  
  public void showHouseInfo(String paramString1, String paramString2) {}
  
  public void showHouseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, List<RentHouseDetail.Tag> paramList, final RentHouseDetail.ActivityBean paramActivityBean)
  {
    if ((!isDetached()) && (isAdded()))
    {
      this.x.setVisibility(0);
      this.C.setVisibility(8);
      this.m.setText(paramString1);
      this.k.setText(paramString2);
      this.o.setText(paramString3);
      this.r.setText(paramString4);
      this.q.setText(paramString5);
      this.p.setText(paramString6);
      this.m.setText(paramString1);
      this.s.setText(paramString7);
      int i1;
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.n.setVisibility(0);
        this.n.removeAllViews();
        i1 = 0;
      }
      while (i1 < paramList.size())
      {
        paramString1 = (TextView)this.bk.inflate(2130904465, this.n, false);
        paramString1.setText(((RentHouseDetail.Tag)paramList.get(i1)).getTitle());
        if (1 == ((RentHouseDetail.Tag)paramList.get(i1)).getHot())
        {
          paramString1.setTextColor(this.bn.getResources().getColor(2131624588));
          paramString1.setBackgroundResource(2130837778);
        }
        this.n.addView(paramString1);
        i1 += 1;
        continue;
        this.n.setVisibility(8);
      }
      if ((paramActivityBean != null) && (!TextUtils.isEmpty(paramActivityBean.getTitle())))
      {
        this.t.setVisibility(0);
        this.u.setText(paramActivityBean.getSlogan());
        this.v.setText(paramActivityBean.getTitle());
        if (!TextUtils.isEmpty(paramActivityBean.getLink())) {
          this.t.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              JsBridgeWebActivity.start(RentHouseDetailFragment.a(RentHouseDetailFragment.this), paramActivityBean.getTitle(), paramActivityBean.getLink());
            }
          });
        }
      }
    }
  }
  
  public void showHouseInfoSpace(RentHouseDetail.Space paramSpace)
  {
    if ((!isDetached()) && (isAdded()) && (paramSpace != null))
    {
      this.x.setVisibility(8);
      this.C.setVisibility(0);
      this.y.setText("面积：" + paramSpace.getArea() + "㎡");
      if (TextUtils.isEmpty(paramSpace.getFace())) {
        break label187;
      }
      this.z.setVisibility(0);
      this.z.setText("朝向:  " + paramSpace.getFace());
    }
    for (;;)
    {
      this.A.setText(paramSpace.getName() + "配置");
      paramSpace = paramSpace.getConfig();
      if ((paramSpace != null) && (paramSpace.size() >= 1)) {
        break;
      }
      this.B.setVisibility(8);
      this.A.setVisibility(8);
      return;
      label187:
      this.z.setVisibility(8);
    }
    this.B.setVisibility(0);
    this.A.setVisibility(0);
    this.B.setAdapter(new g(paramSpace));
  }
  
  public void showHouseTips(RentHouseDetail.TipBean.TipContent paramTipContent)
  {
    new HouseTipsPop(this.bn).show(this.aM, paramTipContent);
  }
  
  public void showHousekeeper(final KeeperInfo paramKeeperInfo)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (paramKeeperInfo != null)
      {
        this.ax.setVisibility(0);
        this.ay.setController(c.frescoController(paramKeeperInfo.getHeadCorn()));
        this.az.setText(paramKeeperInfo.getKeeperName());
        this.aB.setText(paramKeeperInfo.getKeeperPresent());
        this.aA.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_callzo", "lxgj=" + paramKeeperInfo.getKeeperPhone(), RentHouseDetailFragment.h(RentHouseDetailFragment.this), "");
            if (!TextUtils.isEmpty(paramKeeperInfo.getKeeperPhone()))
            {
              com.ziroom.commonlibrary.g.b.a.onCallSteward();
              ah.callPhone(RentHouseDetailFragment.a(RentHouseDetailFragment.this), paramKeeperInfo.getKeeperPhone());
            }
          }
        });
      }
    }
    else {
      return;
    }
    this.ax.setVisibility(8);
  }
  
  public void showHuxingInfo(String paramString) {}
  
  public void showHxPicDetail(List<String> paramList1, List<String> paramList2, LinkedHashMap<String, Integer> paramLinkedHashMap) {}
  
  public void showIntroduce(String paramString)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.D.setText(paramString);
        this.e.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.e.setVisibility(8);
  }
  
  public void showNews(String paramString)
  {
    if (!ad.getBoolean(this.bn, paramString)) {
      this.f.setVisibility(0);
    }
    for (;;)
    {
      ad.setBoolean(this.bn, paramString, true);
      return;
      this.f.setVisibility(8);
    }
  }
  
  public void showPayType(PayType paramPayType)
  {
    if (paramPayType != null) {
      new RentHouseDetailPayTypePop(this.bn).show(this.l, paramPayType);
    }
  }
  
  public void showPicNumsign(int paramInt, String paramString) {}
  
  public void showQuestions(RentHouseDetail.QuestionListBean paramQuestionListBean)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if ((paramQuestionListBean == null) || (paramQuestionListBean.getContent() == null) || (paramQuestionListBean.getContent().size() < 1)) {
        this.aU.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.aV.setText(paramQuestionListBean.getTitle());
    this.aW.setDividerVisibility(true);
    paramQuestionListBean = new b(paramQuestionListBean.getContent());
    this.aW.setAdapter(paramQuestionListBean);
  }
  
  public void showRecommend(List<RentHouseRecommend> paramList)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.aG.setVisibility(0);
        float f1 = getResources().getDisplayMetrics().density;
        Object localObject = new LinearLayout.LayoutParams(-1, (int)((this.bg - 44.0F * f1) * 2.0F / 3.0F) + (int)(getResources().getDisplayMetrics().density * 104.0F + 0.5F));
        this.aH.setPadding((int)(f1 * 18.0F), 0, (int)(f1 * 18.0F), 0);
        this.aH.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new LinearLayoutManager(this.bn);
        ((LinearLayoutManager)localObject).setOrientation(0);
        this.aH.setLayoutManager((RecyclerView.h)localObject);
        paramList = new c(paramList);
        this.aH.setAdapter(paramList);
      }
    }
    else {
      return;
    }
    this.aG.setVisibility(8);
  }
  
  public void showResblockIntroduce(RentHouseDetail.ResidentialInfo paramResidentialInfo)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if ((paramResidentialInfo == null) || (paramResidentialInfo.getItem() == null) || (paramResidentialInfo.getItem().size() <= 0)) {
        break label275;
      }
      this.as.setVisibility(0);
      int i1 = 0;
      if (i1 < paramResidentialInfo.getItem().size())
      {
        View localView = LayoutInflater.from(this.bn).inflate(2130904231, null);
        TextView localTextView1 = (TextView)localView.findViewById(2131690049);
        TextView localTextView2 = (TextView)localView.findViewById(2131691546);
        RentHouseDetail.ResidentialInfo.item localitem = (RentHouseDetail.ResidentialInfo.item)paramResidentialInfo.getItem().get(i1);
        if (localitem == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localTextView1.setText(localitem.getName());
          localTextView2.setText(localitem.getValue());
          this.ar.addView(localView, new LinearLayout.LayoutParams(-1, ah.dip2px(this.bn, 46.0F)));
          if (i1 != paramResidentialInfo.getItem().size() - 1)
          {
            localView = new View(this.bn);
            localView.setLayoutParams(new LinearLayout.LayoutParams(-1, ah.dip2px(this.bn, 0.5F)));
            localView.setBackgroundColor(this.bn.getResources().getColor(2131624046));
            this.ar.addView(localView);
          }
        }
      }
      if (paramResidentialInfo.getMore() == 0) {
        this.aq.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.aq.setVisibility(0);
    return;
    label275:
    this.as.setVisibility(8);
  }
  
  public void showRoomInfo(String paramString, List<RentHouseDetail.Roommate> paramList)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if ((paramList == null) || (paramList.size() == 0)) {
        this.U.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.U.setVisibility(0);
    this.V.setAdapter(new e(paramString, paramList));
  }
  
  public void showService(RentHouseDetail.Service paramService)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (paramService == null) {
        break label99;
      }
      this.ac.setVisibility(8);
      this.ao.setVisibility(0);
      this.am.setText(paramService.getTitle());
      paramService = paramService.getDetail();
      if ((paramService == null) || (paramService.size() == 0)) {
        this.ao.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.ao.setVisibility(0);
    this.ap.setAdapter(new f(paramService));
    return;
    label99:
    this.ao.setVisibility(8);
  }
  
  public void showServiceAll(RentHouseDetail.Service paramService)
  {
    new RentHouseDetailServicePop(this.bn).show(this.an, paramService);
  }
  
  public void showShare(String paramString1, RentHouseDetail.Share paramShare, int paramInt, String paramString2, View.OnClickListener paramOnClickListener)
  {
    if (paramShare == null) {
      return;
    }
    com.ziroom.threelib.ziroomshare.f.newBuilder(this.bn).setFlag(31).setShareTitle(paramShare.getTitle()).setShareUrl(paramShare.getUrl()).setShareContent(paramShare.getContent()).setSharePicUrl(paramString1).build().addShareItem(0, paramInt, paramString2, paramOnClickListener).show();
  }
  
  public void showSignEndDate(RentHouseDetail.SignDuration paramSignDuration)
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    if ((paramSignDuration == null) || (paramSignDuration.getItem() == null) || (paramSignDuration.getItem().size() < 1))
    {
      this.ai.setVisibility(8);
      return;
    }
    this.aj.setText(paramSignDuration.getTitle());
    if (paramSignDuration.getItem().size() > 1)
    {
      this.al.setVisibility(0);
      RentHouseDetail.SignDurationInfo localSignDurationInfo = (RentHouseDetail.SignDurationInfo)paramSignDuration.getItem().get(1);
      ((SimpleDraweeView)this.al.getChildAt(0)).setController(c.frescoController(localSignDurationInfo.getIcon()));
      ((TextView)this.al.getChildAt(1)).setText(localSignDurationInfo.getDesc());
    }
    for (;;)
    {
      paramSignDuration = (RentHouseDetail.SignDurationInfo)paramSignDuration.getItem().get(0);
      ((SimpleDraweeView)this.ak.getChildAt(0)).setController(c.frescoController(paramSignDuration.getIcon()));
      ((TextView)this.ak.getChildAt(1)).setText(paramSignDuration.getDesc());
      return;
      this.al.setVisibility(8);
    }
  }
  
  public void showSubleDialog()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this.bn).setTitle("发起者休息中").setContent("转租发起者暂时关闭了咨询，建议您先收藏房源，并时刻关注房源状态").setButtonText("知道了").build().show();
  }
  
  public void showSubletDesc(RentHouseDetail.Sublet paramSublet)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (paramSublet == null) {
        break label158;
      }
      if (1 != paramSublet.getContactable()) {
        break label146;
      }
      this.J.setVisibility(0);
    }
    for (;;)
    {
      this.E.setVisibility(0);
      this.G.setText("预计" + paramSublet.getCheckin_date() + "可入住，需签约至" + paramSublet.getSigning_max_date());
      this.I.setText("转租者：" + paramSublet.getCustomer_name());
      this.J.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RentHouseDetailFragment.g(RentHouseDetailFragment.this).contactSublet();
        }
      });
      this.H.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(RentHouseDetailFragment.a(RentHouseDetailFragment.this), HomeWebActivity.class);
          paramAnonymousView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/zjlc/b.html");
          paramAnonymousView.putExtra("title", "转租流程说明");
          RentHouseDetailFragment.this.startActivity(paramAnonymousView);
        }
      });
      return;
      label146:
      this.J.setVisibility(8);
    }
    label158:
    this.E.setVisibility(8);
  }
  
  public void showSubletRecommend(String paramString)
  {
    if ((!isDetached()) && (isAdded()))
    {
      d.d("RentHouseDetailActivity", "===" + paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        this.F.setVisibility(0);
        this.K.setText(paramString);
      }
    }
    else
    {
      return;
    }
    this.F.setVisibility(8);
  }
  
  public void showSubsidiary(List<RentHouseDetail.Space> paramList, String paramString)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (ae.notNull(paramString))
      {
        this.O.setVisibility(0);
        this.O.setController(c.frescoController(paramString));
      }
      while ((paramList != null) && (paramList.size() > 0))
      {
        int i1 = 0;
        for (;;)
        {
          if (i1 < paramList.size())
          {
            paramString = (TextLineView)View.inflate(getActivity(), 2130905224, null);
            paramString.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                RentHouseDetailFragment.g(RentHouseDetailFragment.this).clickTabInitData(((Integer)paramAnonymousView.getTag()).intValue());
              }
            });
            paramString.setTag(Integer.valueOf(i1));
            paramString.setStr(((RentHouseDetail.Space)paramList.get(i1)).getName());
            this.N.addView(paramString);
            i1 += 1;
            continue;
            this.O.setVisibility(8);
            break;
          }
        }
        this.bf.clickTabInitData(0);
      }
    }
  }
  
  public void showSubsidiaryAll(List<RentHouseDetail.Space> paramList)
  {
    new RentHouseDetailSpacePop(this.bn).show(this.L, paramList);
  }
  
  public void showWillUnrent(RentHouseDetail paramRentHouseDetail)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (paramRentHouseDetail != null)
      {
        this.S.setVisibility(0);
        this.T.setText(paramRentHouseDetail.getWill_unrent_date_text());
      }
    }
    else {
      return;
    }
    this.S.setVisibility(8);
  }
  
  public void showWillUnrentPop(RentHouseDetail paramRentHouseDetail)
  {
    new RentHouseDetailWillUnrentPop(this.bn).show(this.ah, paramRentHouseDetail);
  }
  
  public void toAppointment(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent(this.bn, InitiateAppointActivity.class);
    localIntent.putExtra("house_code", paramString1);
    localIntent.putExtra("mHouse_id", paramString2);
    localIntent.putExtra("mHouse_type", paramInt);
    localIntent.putExtra("villageId", paramString3);
    localIntent.putExtra("house_title", paramString4);
    localIntent.putExtra("house_price", paramString5);
    localIntent.putExtra("house_area", paramString6);
    localIntent.putExtra("house_photo", paramString7);
    startActivity(localIntent);
  }
  
  public void toBook(HouseDetail paramHouseDetail, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.bn, CertInformationActivity.class);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("phone", paramString1);
    if (com.freelxl.baselibrary.f.f.notNull(paramString2)) {
      localIntent.putExtra("type", 2);
    }
    startActivity(localIntent);
  }
  
  public void toCertInfoConfirm(HouseDetail paramHouseDetail, CertInfoEntity paramCertInfoEntity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.bn, SignedCertInfoConfirmActivity.class);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("phone", paramString);
    localIntent.putExtra("cert_info", paramCertInfoEntity);
    localIntent.putExtra("type", paramInt);
    startActivity(localIntent);
  }
  
  public void toCertInput(CertInfoEntity paramCertInfoEntity, HouseDetail paramHouseDetail, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.bn, CertInformationActivity.class);
    localIntent.putExtra("cert_info", paramCertInfoEntity);
    localIntent.putExtra("phone", paramString);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("type", paramInt);
    startActivity(localIntent);
  }
  
  public void toCertStatus(HouseDetail paramHouseDetail, CertInfoEntity paramCertInfoEntity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.bn, CertificationInfoActivity.class);
    localIntent.putExtra("cert_info", paramCertInfoEntity);
    localIntent.putExtra("phone", paramString);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("type", paramInt);
    startActivity(localIntent);
  }
  
  public void toDistrictDetail(RentHouseDetail paramRentHouseDetail)
  {
    if ((paramRentHouseDetail != null) && (paramRentHouseDetail.getResblock() != null))
    {
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_resblockdetail", "lpid=" + paramRentHouseDetail.getResblock().getId(), b(), "");
      Intent localIntent = new Intent(this.bn, DistrictDetailActivity.class);
      localIntent.putExtra("resblockId", paramRentHouseDetail.getResblock().getId());
      localIntent.putExtra("houseDetail", paramRentHouseDetail);
      startActivity(localIntent);
    }
  }
  
  public void toResblockHouseList(String paramString1, String paramString2) {}
  
  public void toSign(HouseDetail paramHouseDetail, String paramString)
  {
    Intent localIntent = new Intent(this.bn, SignerDataActivity.class);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("phone", paramString);
    startActivity(localIntent);
  }
  
  public void toSublet(final String paramString1, String paramString2)
  {
    View localView = this.bk.inflate(2130903835, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this.bn, 2131427591).create();
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localAlertDialog.setContentView(localView);
      localTextView.setText(paramString2);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new HashMap();
          UserInfo localUserInfo = ApplicationEx.c.getUser();
          if (localUserInfo != null) {
            paramAnonymousView.put("uid", localUserInfo.getUid());
          }
          paramAnonymousView.put("houseCODE", paramString1);
          w.onEventValueToZiroomAndUmeng("sublet_entire_housedetail_imsignN_contact", paramAnonymousView);
          RentHouseDetailFragment.g(RentHouseDetailFragment.this).contactSublet();
          localAlertDialog.dismiss();
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localAlertDialog.dismiss();
        }
      });
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  public void toSubletCode(final String paramString1, String paramString2)
  {
    View localView = this.bk.inflate(2130903858, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    final EditText localEditText = (EditText)localView.findViewById(2131693896);
    this.bj = new Dialog(this.bn, 2131427591);
    Dialog localDialog = this.bj;
    if (!(localDialog instanceof Dialog)) {
      localDialog.show();
    }
    for (;;)
    {
      this.bj.setContentView(localView);
      localTextView.setText(paramString2);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(localEditText).toString()))
          {
            paramAnonymousView = new HashMap();
            UserInfo localUserInfo = ApplicationEx.c.getUser();
            if (localUserInfo != null) {
              paramAnonymousView.put("uid", localUserInfo.getUid());
            }
            paramAnonymousView.put("houseCODE", paramString1);
            w.onEventValueToZiroomAndUmeng("sublet_entire_housedetail_imsignY_confirm_code", paramAnonymousView);
            RentHouseDetailFragment.g(RentHouseDetailFragment.this).checkSubletCode(VdsAgent.trackEditTextSilent(localEditText).toString());
          }
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RentHouseDetailFragment.i(RentHouseDetailFragment.this).dismiss();
        }
      });
      return;
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
  
  public void toSubletContact(final String paramString1, final String paramString2, final String paramString3)
  {
    View localView1 = this.bk.inflate(2130905157, null);
    final PopupWindow localPopupWindow = new PopupWindow(localView1, -1, -1);
    View localView2 = this.bm.findViewById(2131696058);
    if (!(localPopupWindow instanceof PopupWindow)) {
      localPopupWindow.showAtLocation(localView2, 80, 0, 0);
    }
    for (;;)
    {
      ((Button)localView1.findViewById(2131697607)).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(paramString3))
          {
            paramAnonymousView = "您好，我对您发布的转租房\"" + paramString2 + "\"很感兴趣，想和您详细了解一下。";
            ah.sendMessages(RentHouseDetailFragment.a(RentHouseDetailFragment.this), paramString3, paramAnonymousView);
            localPopupWindow.dismiss();
            paramAnonymousView = new HashMap();
            UserInfo localUserInfo = ApplicationEx.c.getUser();
            if (localUserInfo != null) {
              paramAnonymousView.put("uid", localUserInfo.getUid());
            }
            paramAnonymousView.put("houseCODE", paramString1);
            w.onEventValueToZiroomAndUmeng("sublet_entire_housedetail_message", paramAnonymousView);
          }
        }
      });
      ((Button)localView1.findViewById(2131692520)).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(paramString3))
          {
            ah.callPhone(RentHouseDetailFragment.a(RentHouseDetailFragment.this), paramString3);
            localPopupWindow.dismiss();
            paramAnonymousView = new HashMap();
            UserInfo localUserInfo = ApplicationEx.c.getUser();
            if (localUserInfo != null) {
              paramAnonymousView.put("uid", localUserInfo.getUid());
            }
            paramAnonymousView.put("houseCODE", paramString1);
            w.onEventValueToZiroomAndUmeng("sublet_entire_housedetail_phone", paramAnonymousView);
          }
        }
      });
      ((Button)localView1.findViewById(2131693804)).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localPopupWindow.dismiss();
        }
      });
      localView1.findViewById(2131694517).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localPopupWindow.dismiss();
        }
      });
      return;
      VdsAgent.showAtLocation((PopupWindow)localPopupWindow, localView2, 80, 0, 0);
    }
  }
  
  public void updataSubsidiary(int paramInt, RentHouseDetail.Space paramSpace)
  {
    if (paramSpace == null) {}
    label205:
    label216:
    for (;;)
    {
      return;
      int i2 = this.N.getChildCount();
      int i1 = 0;
      if (i1 < i2)
      {
        TextLineView localTextLineView = (TextLineView)this.N.getChildAt(i1);
        if (i1 == paramInt) {
          localTextLineView.setShow(true, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localTextLineView.setShow(false, false);
        }
      }
      if ((ae.notNull(paramSpace.getArea())) && (!"0".equals(paramSpace.getArea())))
      {
        this.Q.setText("面积 · " + paramSpace.getArea() + "m²");
        if (!ae.notNull(paramSpace.getFace())) {
          break label205;
        }
        this.R.setText("朝向 · " + paramSpace.getFace());
      }
      for (;;)
      {
        if (paramSpace.getConfig() == null) {
          break label216;
        }
        paramSpace = new h(paramSpace.getConfig());
        this.P.setAdapter(paramSpace);
        return;
        this.Q.setText("面积 · 暂无数据");
        break;
        this.R.setText("朝向 · 暂无数据");
      }
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private List<String> b;
    
    a()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = RentHouseDetailFragment.j(RentHouseDetailFragment.this).inflate(2130904457, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        String str = (String)getItem(paramInt);
        paramViewGroup.a.setText("· " + str);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      TextView a;
      
      private a() {}
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private List<RentHouseDetail.QuestionBean> b;
    
    public b()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = LayoutInflater.from(RentHouseDetailFragment.a(RentHouseDetailFragment.this)).inflate(2130904230, null, false);
      paramViewGroup = (TextView)paramView.findViewById(2131689541);
      final Object localObject = (TextView)paramView.findViewById(2131695068);
      localObject = (RentHouseDetail.QuestionBean)this.b.get(paramInt);
      if (localObject == null) {
        return paramView;
      }
      paramViewGroup.setText(((RentHouseDetail.QuestionBean)localObject).getTitle());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_QA", "", RentHouseDetailFragment.n(RentHouseDetailFragment.this), "");
          paramAnonymousView = HouseDetailQuestionDialog.getInstance(localObject.getTitle(), localObject.getDesc(), localObject.getLink(), localObject.getLink_title());
          android.support.v4.app.FragmentManager localFragmentManager = RentHouseDetailFragment.this.getChildFragmentManager();
          if (!(paramAnonymousView instanceof android.support.v4.app.DialogFragment))
          {
            paramAnonymousView.show(localFragmentManager, "question");
            return;
          }
          VdsAgent.showDialogFragment((android.support.v4.app.DialogFragment)paramAnonymousView, localFragmentManager, "question");
        }
      });
      return paramView;
    }
  }
  
  private class c
    extends RecyclerView.a<RentHouseDetailFragment.d>
  {
    private List<RentHouseRecommend> b;
    private int c;
    
    public c()
    {
      List localList;
      this.b = localList;
      this.c = ((int)(RentHouseDetailFragment.l(RentHouseDetailFragment.this) - 36.0F * RentHouseDetailFragment.m(RentHouseDetailFragment.this)));
    }
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public void onBindViewHolder(RentHouseDetailFragment.d paramd, int paramInt)
    {
      final RentHouseRecommend localRentHouseRecommend = (RentHouseRecommend)this.b.get(paramInt);
      if (localRentHouseRecommend != null)
      {
        paramd.a.setController(c.frescoController(localRentHouseRecommend.getPhoto()));
        paramd.c.setText("¥" + localRentHouseRecommend.getPrice());
        paramd.b.setText(localRentHouseRecommend.getName());
        paramd.d.setText(localRentHouseRecommend.getSubway_station_info());
        if ((localRentHouseRecommend.getTips() != null) && (localRentHouseRecommend.getTips().size() >= 1)) {
          break label138;
        }
        paramd.e.setVisibility(8);
      }
      for (;;)
      {
        paramd.itemView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(RentHouseDetailFragment.a(RentHouseDetailFragment.this), RentHouseDetailActivity.class);
            paramAnonymousView.putExtra("house_id", localRentHouseRecommend.getHouse_id());
            paramAnonymousView.putExtra("id", localRentHouseRecommend.getId());
            RentHouseDetailFragment.this.startActivity(paramAnonymousView);
          }
        });
        return;
        label138:
        paramd.e.setVisibility(0);
        paramd.e.removeAllViews();
        paramInt = 0;
        while (paramInt < localRentHouseRecommend.getTips().size())
        {
          Object localObject = (RentHouseRecommend.Tip)localRentHouseRecommend.getTips().get(paramInt);
          TextView localTextView = new TextView(RentHouseDetailFragment.a(RentHouseDetailFragment.this));
          localTextView.setTextSize(2, 10.0F);
          localTextView.setTextColor(Color.parseColor("#6db4d6"));
          localTextView.setBackgroundResource(2130837954);
          localTextView.setText(((RentHouseRecommend.Tip)localObject).getTitle());
          localTextView.setGravity(17);
          float f = RentHouseDetailFragment.this.getResources().getDisplayMetrics().density;
          int i = (int)(6.0F * f);
          int j = (int)(3.0F * f);
          localTextView.setPadding(i, j, i, j);
          localObject = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(f * 6.0F));
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramd.e.addView(localTextView);
          paramInt += 1;
        }
      }
    }
    
    public RentHouseDetailFragment.d onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = RentHouseDetailFragment.j(RentHouseDetailFragment.this).inflate(2130904458, paramViewGroup, false);
      RentHouseDetailFragment.d locald = new RentHouseDetailFragment.d(RentHouseDetailFragment.this, paramViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.c * 2 / 3 + (int)(RentHouseDetailFragment.m(RentHouseDetailFragment.this) * 96.0F + 0.5F));
      localLayoutParams.setMargins(0, 0, (int)(RentHouseDetailFragment.m(RentHouseDetailFragment.this) * 6.0F), 0);
      paramViewGroup.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.c * 2 / 3);
      locald.a = ((SimpleDraweeView)paramViewGroup.findViewById(2131691098));
      locald.a.setLayoutParams(localLayoutParams);
      locald.c = ((TextView)paramViewGroup.findViewById(2131689912));
      locald.b = ((TextView)paramViewGroup.findViewById(2131690049));
      locald.d = ((TextView)paramViewGroup.findViewById(2131690748));
      locald.e = ((LinearLayout)paramViewGroup.findViewById(2131689834));
      return locald;
    }
  }
  
  private class d
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    LinearLayout e;
    
    public d(View paramView)
    {
      super();
    }
  }
  
  private class e
    extends BaseAdapter
  {
    private List<RentHouseDetail.Roommate> b;
    private String c;
    
    e(List<RentHouseDetail.Roommate> paramList)
    {
      List localList;
      this.b = localList;
      this.c = paramList;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = RentHouseDetailFragment.j(RentHouseDetailFragment.this).inflate(2130904459, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689822));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131689912));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131695572));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131695573));
        paramViewGroup.f = ((TextView)paramView.findViewById(2131695574));
        paramView.setTag(paramViewGroup);
      }
      final RentHouseDetail.Roommate localRoommate;
      for (;;)
      {
        localRoommate = (RentHouseDetail.Roommate)getItem(paramInt);
        paramViewGroup.a.setText(localRoommate.getTitle());
        paramViewGroup.b.setText(localRoommate.getStatus_text());
        if (!"ycz".equals(localRoommate.getStatus())) {
          break;
        }
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.f.setVisibility(0);
        paramViewGroup.d.setText(localRoommate.getRoommate_gender());
        paramViewGroup.f.setText(localRoommate.getRoommate_horoscope());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.f.setVisibility(8);
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.c.setText(localRoommate.getPrice_text());
      if (this.c.equals(localRoommate.getId()))
      {
        paramViewGroup.e.setText("当前房源");
        paramViewGroup.e.setTextColor(Color.parseColor("#444444"));
        paramViewGroup.e.setOnClickListener(null);
        return paramView;
      }
      paramViewGroup.e.setText("查看房间");
      paramViewGroup.e.setTextColor(Color.parseColor("#FFA000"));
      paramViewGroup.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_mate", "orid=" + RentHouseDetailFragment.e.a(RentHouseDetailFragment.e.this) + "&&nrid=" + localRoommate.getId(), RentHouseDetailFragment.k(RentHouseDetailFragment.this), "");
          paramAnonymousView = new Intent(RentHouseDetailFragment.a(RentHouseDetailFragment.this), RentHouseDetailActivity.class);
          paramAnonymousView.putExtra("id", localRoommate.getId());
          paramAnonymousView.putExtra("house_id", localRoommate.getHouse_id());
          RentHouseDetailFragment.this.startActivity(paramAnonymousView);
        }
      });
      return paramView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      TextView f;
      
      private a() {}
    }
  }
  
  private class f
    extends BaseAdapter
  {
    private List<RentHouseDetail.Service.Detail> b;
    
    f()
    {
      List localList;
      this.b = localList;
    }
    
    private Spannable a(String paramString1, String paramString2)
    {
      SpannableString localSpannableString = new SpannableString("");
      if (TextUtils.isEmpty(paramString1)) {
        return localSpannableString;
      }
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = new SpannableString(paramString1);
        paramString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F3F3F")), 0, paramString1.length(), 33);
        return paramString2;
      }
      paramString2 = new SpannableString(paramString1 + " · " + paramString2);
      paramString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3F3F3F")), 0, paramString1.length() + 3, 33);
      paramString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FF999999")), paramString1.length() + 3, paramString2.length(), 33);
      return paramString2;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = RentHouseDetailFragment.j(RentHouseDetailFragment.this).inflate(2130904462, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131691098));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690695));
        paramView.setTag(paramViewGroup);
      }
      RentHouseDetail.Service.Detail localDetail;
      for (;;)
      {
        localDetail = (RentHouseDetail.Service.Detail)getItem(paramInt);
        if (localDetail != null) {
          break;
        }
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setController(c.frescoController(localDetail.getIcon()));
      paramViewGroup.b.setText(a(localDetail.getTitle(), localDetail.getSub_title()));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RentHouseDetailFragment.g(RentHouseDetailFragment.this).initServiceAll();
        }
      });
      return paramView;
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      
      private a() {}
    }
  }
  
  private class g
    extends BaseAdapter
  {
    private List<RentHouseDetail.Config> b;
    
    g()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = RentHouseDetailFragment.j(RentHouseDetailFragment.this).inflate(2130904463, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        RentHouseDetail.Config localConfig = (RentHouseDetail.Config)getItem(paramInt);
        if (localConfig != null)
        {
          String str2 = localConfig.getName();
          String str1 = str2;
          if (str2.contains("/")) {
            str1 = str2.substring(0, str2.indexOf("/"));
          }
          paramViewGroup.b.setText(str1);
          c.frescoHierarchyController(paramViewGroup.a, ScalingUtils.ScaleType.FIT_CENTER, 2130839305);
          paramViewGroup.a.setController(c.frescoController(localConfig.getIcon()));
        }
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      
      private a() {}
    }
  }
  
  private class h
    extends BaseAdapter
  {
    private List<RentHouseDetail.Config> b;
    
    public h()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      RentHouseDetail.Config localConfig;
      if (paramView == null)
      {
        paramView = RentHouseDetailFragment.j(RentHouseDetailFragment.this).inflate(2130904464, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695576));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
        paramView.setTag(paramViewGroup);
        localConfig = (RentHouseDetail.Config)getItem(paramInt);
        if (localConfig != null)
        {
          if (!ae.notNull(localConfig.getName())) {
            break label126;
          }
          paramViewGroup.b.setText(localConfig.getName());
        }
      }
      for (;;)
      {
        paramViewGroup.a.setController(c.frescoController(localConfig.getIcon()));
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label126:
        paramViewGroup.b.setText("");
      }
    }
    
    private class a
    {
      SimpleDraweeView a;
      TextView b;
      
      private a() {}
    }
  }
  
  class i
    extends CountDownTimer
  {
    public i(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      if (RentHouseDetailFragment.g(RentHouseDetailFragment.this) != null) {
        RentHouseDetailFragment.g(RentHouseDetailFragment.this).countTimeFinish();
      }
    }
    
    public void onTick(long paramLong)
    {
      if ((!RentHouseDetailFragment.this.isDetached()) && (RentHouseDetailFragment.this.aS != null)) {
        RentHouseDetailFragment.this.aS.setText("距可签约\n" + m.secToTime((int)paramLong / 1000));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */