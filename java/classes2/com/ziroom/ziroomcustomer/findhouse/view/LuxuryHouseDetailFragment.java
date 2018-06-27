package com.ziroom.ziroomcustomer.findhouse.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
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
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayout.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.threelib.ziroomshare.f.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
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
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.QuestionListBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ResidentialInfo;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ResidentialInfo.item;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Roommate;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Service;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Share;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.SignDuration;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Sublet;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Tag;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.TipBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.TipBean.TipContent;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend.Tip;
import com.ziroom.ziroomcustomer.home.ScanPhotoActivity;
import com.ziroom.ziroomcustomer.model.BookingOrderTextEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.KeeperInfo;
import com.ziroom.ziroomcustomer.model.SearchCondition;
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
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
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

public class LuxuryHouseDetailFragment
  extends BaseFragment
  implements View.OnClickListener, b.b, ObservableScrollView.a
{
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private LinearLayout E;
  private LinearLayout F;
  private SimpleDraweeView G;
  private MyGridView H;
  private TextView I;
  private TextView J;
  private SimpleDraweeView K;
  private FlexboxLayout L;
  private TextView M;
  private TextView N;
  private TextView O;
  private ConvenientBanner P;
  private SimpleDraweeView Q;
  private FlexboxLayout R;
  private LinearLayout S;
  private SimpleDraweeView T;
  private TextView U;
  private TextView V;
  private TextView W;
  private TextView X;
  private MyGridView Y;
  private LinearLayout Z;
  ImageView a;
  private RecyclerView aa;
  private LinearLayout ab;
  private HorizontalScrollView ac;
  private View ad;
  private View ae;
  private Context af;
  private b.a ag;
  private a ah;
  private int ai;
  private float aj;
  private LayoutInflater ak;
  private e al;
  private Dialog am;
  private int an;
  private int ao;
  private int ap = 300;
  private int aq = 800;
  private int ar = 1000;
  private int as = 800;
  private int at;
  private float au = -1.0F;
  private float av = -1.0F;
  private boolean aw = false;
  private BroadcastReceiver ax = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getIntExtra("type", 0) == 17) && (paramAnonymousIntent.getIntExtra("status", 0) == 1)) {
        LuxuryHouseDetailFragment.d(LuxuryHouseDetailFragment.this).getCollectFormServer();
      }
    }
  };
  RelativeLayout b;
  Button c;
  Button d;
  ImageView e;
  RelativeLayout f;
  private View g;
  private View h;
  private ImageView i;
  private boolean j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private View o;
  private ObservableScrollView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private SimpleDraweeView u;
  private SimpleDraweeView v;
  private SimpleDraweeView w;
  private ImageView x;
  private TextView y;
  private TextView z;
  
  private TranslateAnimation a(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramInt1, paramInt2, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(paramInt3);
    localTranslateAnimation.setInterpolator(paramInterpolator);
    localTranslateAnimation.setFillAfter(paramBoolean);
    if (paramInt4 > 0) {
      localTranslateAnimation.setStartOffset(paramInt4);
    }
    return localTranslateAnimation;
  }
  
  private void a(final View paramView1, View paramView2, final View paramView3)
  {
    if ((paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (paramView1.getVisibility() != 0) || (paramView2.getVisibility() != 0)) {
      return;
    }
    this.f.setVisibility(0);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    int i1 = ac.getStatusHeight(this.af);
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
        LuxuryHouseDetailFragment.this.f.setVisibility(8);
        paramView3.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    paramView2.setInterpolator(new AccelerateDecelerateInterpolator());
    paramView2.setDuration(600L).start();
  }
  
  private void a(List<String> paramList, LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Intent localIntent = new Intent(this.af, ScanPhotoActivity.class);
    Bundle localBundle = new Bundle();
    localArrayList.addAll(paramList);
    localBundle.putSerializable("photos", localArrayList);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("mHouse_type", 0);
    ScanPhotoActivity.a = paramLinkedHashMap;
    startActivity(localIntent);
  }
  
  private void c()
  {
    this.g = this.ae.findViewById(2131694590);
    this.k = ((ImageView)this.ae.findViewById(2131696059));
    this.i = ((ImageView)this.ae.findViewById(2131694340));
    this.l = ((ImageView)this.ae.findViewById(2131696060));
    this.m = ((ImageView)this.ae.findViewById(2131690673));
    this.n = ((ImageView)this.ae.findViewById(2131689492));
    this.h = this.ae.findViewById(2131696034);
    this.o = this.ae.findViewById(2131692780);
    this.p = ((ObservableScrollView)this.ae.findViewById(2131690031));
    this.K = ((SimpleDraweeView)this.ae.findViewById(2131696093));
    this.L = ((FlexboxLayout)this.ae.findViewById(2131696096));
    this.q = ((TextView)this.ae.findViewById(2131690978));
    this.r = ((TextView)this.ae.findViewById(2131696099));
    this.s = ((TextView)this.ae.findViewById(2131690979));
    this.t = ((TextView)this.ae.findViewById(2131696097));
    this.v = ((SimpleDraweeView)this.ae.findViewById(2131696098));
    this.u = ((SimpleDraweeView)this.ae.findViewById(2131696098));
    this.w = ((SimpleDraweeView)this.ae.findViewById(2131696069));
    this.x = ((ImageView)this.ae.findViewById(2131696070));
    this.y = ((TextView)this.ae.findViewById(2131696068));
    this.z = ((TextView)this.ae.findViewById(2131696071));
    this.A = ((TextView)this.ae.findViewById(2131696061));
    this.B = ((TextView)this.ae.findViewById(2131696062));
    this.C = ((TextView)this.ae.findViewById(2131696063));
    this.D = ((TextView)this.ae.findViewById(2131696064));
    this.E = ((LinearLayout)this.ae.findViewById(2131696084));
    this.F = ((LinearLayout)this.ae.findViewById(2131696087));
    this.G = ((SimpleDraweeView)this.ae.findViewById(2131696086));
    this.H = ((MyGridView)this.ae.findViewById(2131696090));
    this.I = ((TextView)this.ae.findViewById(2131696088));
    this.J = ((TextView)this.ae.findViewById(2131696089));
    this.M = ((TextView)this.ae.findViewById(2131696072));
    this.P = ((ConvenientBanner)this.ae.findViewById(2131696073));
    this.S = ((LinearLayout)this.ae.findViewById(2131696077));
    this.Q = ((SimpleDraweeView)this.ae.findViewById(2131696074));
    this.N = ((TextView)this.ae.findViewById(2131696075));
    this.O = ((TextView)this.ae.findViewById(2131696078));
    this.R = ((FlexboxLayout)this.ae.findViewById(2131696076));
    this.T = ((SimpleDraweeView)this.ae.findViewById(2131696080));
    this.U = ((TextView)this.ae.findViewById(2131696081));
    this.V = ((TextView)this.ae.findViewById(2131696082));
    this.X = ((TextView)this.ae.findViewById(2131696079));
    this.Y = ((MyGridView)this.ae.findViewById(2131696083));
    this.Z = ((LinearLayout)this.ae.findViewById(2131696423));
    this.aa = ((RecyclerView)this.ae.findViewById(2131695973));
    this.W = ((TextView)this.ae.findViewById(2131694733));
    this.a = ((ImageView)this.ae.findViewById(2131695260));
    this.b = ((RelativeLayout)this.ae.findViewById(2131696056));
    this.c = ((Button)this.ae.findViewById(2131696057));
    this.d = ((Button)this.ae.findViewById(2131696058));
    this.ab = ((LinearLayout)this.ae.findViewById(2131696095));
    this.ac = ((HorizontalScrollView)this.ae.findViewById(2131696091));
    this.ad = this.ae.findViewById(2131696094);
    this.e = ((ImageView)this.ae.findViewById(2131694342));
    this.f = ((RelativeLayout)this.ae.findViewById(2131694341));
    int i1 = (int)((this.ai - 36.0F * this.aj) / 1.5F);
    ((ConstraintLayout.LayoutParams)this.P.getLayoutParams()).height = i1;
    this.p.setOnScrollChangedCallback(this);
    ViewGroup.LayoutParams localLayoutParams = this.K.getLayoutParams();
    localLayoutParams.height = (this.ai * 3 / 2);
    this.K.setLayoutParams(localLayoutParams);
    this.q.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void d()
  {
    TranslateAnimation localTranslateAnimation = a(0, this.ao, new AccelerateDecelerateInterpolator(), this.aq, true, this.ap);
    localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        LuxuryHouseDetailFragment.h(LuxuryHouseDetailFragment.this).startAnimation(this.a);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.K.startAnimation(localTranslateAnimation);
  }
  
  public static LuxuryHouseDetailFragment getInstance(RentHouseDetail paramRentHouseDetail)
  {
    LuxuryHouseDetailFragment localLuxuryHouseDetailFragment = new LuxuryHouseDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("detail_json", com.alibaba.fastjson.e.toJSONString(paramRentHouseDetail));
    localLuxuryHouseDetailFragment.setArguments(localBundle);
    d.d("fragment", "======getInstance");
    return localLuxuryHouseDetailFragment;
  }
  
  public void dismissSubletCode()
  {
    if ((this.am != null) && (this.am.isShowing())) {
      this.am.dismiss();
    }
  }
  
  public Context getViewContext()
  {
    return this.af;
  }
  
  public void growingIo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    GrowingIO.getInstance().setPageGroup(this, "YZDetail");
    GrowingIO.getInstance().setPS1(this, paramString2);
    GrowingIO.getInstance().setPS4(this, paramString3);
    GrowingIO.getInstance().setPS3(this, com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
  }
  
  public void initHoustTips(RentHouseDetail.TipBean paramTipBean) {}
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.af = paramContext;
    this.ah = ((a)paramContext);
    d.d("fragment", "======onAttach");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    String str1 = getArguments().getString("id");
    String str2 = getArguments().getString("houseId");
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_back", "", b(), "");
      this.ah.onBackClick();
      return;
    case 2131696059: 
      this.ag.init3D();
      return;
    case 2131696060: 
      if (this.i.getVisibility() == 0) {
        this.i.setVisibility(8);
      }
      if (ApplicationEx.c.isLoginState())
      {
        startActivity(new Intent(this.af, MyCollectionsActivity.class));
        return;
      }
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.af);
      return;
    case 2131690673: 
      this.ag.initShare();
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_top_share", "hid=" + str2 + "&rid=" + str1, b(), "");
      onEvent("NC_entire_detail_share");
      return;
    case 2131690978: 
      this.ag.initHouseCode();
      return;
    case 2131696099: 
      this.ag.initHouseInfo();
      return;
    case 2131696097: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_pay", "", b(), "");
      this.ag.initPayType();
      return;
    case 2131696069: 
    case 2131696071: 
      this.ag.initAroundBaiduMap();
      return;
    case 2131696078: 
      this.ag.initResblockHouseList();
      return;
    case 2131696072: 
      this.ag.initDistrictDetail();
      return;
    case 2131696056: 
      showNews("house_detail_collect");
      paramView = ApplicationEx.c.getUser();
      if ((paramView == null) || (TextUtils.isEmpty(paramView.getUid())))
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.af);
        return;
      }
      if (!this.ag.getCollect()) {
        a(this.a, this.l, this.e);
      }
      this.ag.updateCollect();
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_top_store", "hid=" + str2 + "&rid=" + str1, b(), "");
      onEvent("NC_entire_detail_collect");
      return;
    case 2131696057: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_look", "hid=" + str2 + "&rid=" + str1, b(), "");
      paramView = ApplicationEx.c.getUser();
      if ((paramView == null) || (TextUtils.isEmpty(paramView.getUid())))
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.af);
        return;
      }
      this.ag.submitBtnA();
      onEvent("NC_entire_detail_reserve");
      return;
    case 2131696058: 
      com.ziroom.ziroomcustomer.a.a.onClickEvent("house_look", "hid=" + str2 + "&rid=" + str1, b(), "");
      paramView = ApplicationEx.c.getUser();
      if ((paramView == null) || (TextUtils.isEmpty(paramView.getUid())))
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.af);
        return;
      }
      this.ag.submitBtnB();
      onEvent("NC_entire_detail_signup");
      return;
    }
    this.ag.initHxPicDetail();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.af = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.ae = paramLayoutInflater.inflate(2130904693, null);
    this.ak = LayoutInflater.from(this.af);
    paramLayoutInflater = getResources().getDisplayMetrics();
    this.ai = paramLayoutInflater.widthPixels;
    this.aj = paramLayoutInflater.density;
    c();
    paramLayoutInflater = getArguments().getString("detail_json");
    if ((this.ag != null) && (!TextUtils.isEmpty(paramLayoutInflater))) {
      this.ag.init(paramLayoutInflater);
    }
    paramLayoutInflater = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.af).registerReceiver(this.ax, paramLayoutInflater);
    return this.ae;
  }
  
  public void onDestroy()
  {
    LocalBroadcastManager.getInstance(this.af).unregisterReceiver(this.ax);
    if (this.ag != null) {
      this.ag.detachView();
    }
    super.onDestroy();
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
  
  public void onResume()
  {
    super.onResume();
    if (this.ag != null) {
      this.ag.getCollectFormServer();
    }
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / 500.0F;
    this.g.setAlpha(f1);
    this.h.setAlpha(f1);
    if (f1 > 0.75D)
    {
      this.j = true;
      this.m.setImageResource(2130840338);
      this.n.setImageResource(2130840141);
      this.l.setImageResource(2130840223);
      this.o.setVisibility(0);
      return;
    }
    this.j = false;
    this.m.setImageResource(2130840339);
    this.n.setImageResource(2130840142);
    this.l.setImageResource(2130840224);
    this.o.setVisibility(8);
  }
  
  public void saveHouseCode2Clipboard(String paramString) {}
  
  public void setPresenter(b.a parama)
  {
    this.ag = parama;
  }
  
  public void show3D(String paramString)
  {
    if ((isDetached()) || (!isAdded())) {
      return;
    }
    if (ae.isNull(paramString))
    {
      this.k.setVisibility(8);
      return;
    }
    this.k.setVisibility(0);
  }
  
  public void show3D(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      JsBridgeWebActivity.start(this.af, paramString1, paramString2);
    }
  }
  
  public void showActivitys(List<RentHouseDetail.ActivityArray> paramList) {}
  
  public void showActivitysPop(List<RentHouseDetail.ActivityArray> paramList) {}
  
  public void showAround(RentHouseDetail.ResidentialInfo paramResidentialInfo)
  {
    if ((!isDetached()) && (isAdded()))
    {
      int i1 = (int)(ac.getScreenHeight(this.af) / 375.0F * 100.0F);
      i1 = Math.min(com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this.af), 900);
      float f1 = i1 / 339 * 100;
      paramResidentialInfo = paramResidentialInfo.getLng() + "," + paramResidentialInfo.getLat();
      this.w.setController(c.frescoController("http://api.map.baidu.com/staticimage?width=" + i1 + "&height=" + (int)f1 + "&center=" + paramResidentialInfo + "&zoom=17"));
      paramResidentialInfo = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
      paramResidentialInfo.setDuration(1500L);
      paramResidentialInfo.setRepeatCount(99999);
      this.x.setAnimation(paramResidentialInfo);
      paramResidentialInfo.start();
    }
  }
  
  public void showAroundAll(RentHouseDetail.ResidentialInfo paramResidentialInfo) {}
  
  public void showAroundBaiduMap(String paramString1, String paramString2, String paramString3, List<SurroundBean> paramList)
  {
    Intent localIntent = new Intent(this.af, ResblockMapActivity.class);
    localIntent.putExtra("surround", (Serializable)paramList);
    localIntent.putExtra("lat", paramString3);
    localIntent.putExtra("lng", paramString2);
    localIntent.putExtra("resblock_name", paramString1);
    startActivity(localIntent);
  }
  
  public void showAroundPoi(List<SurroundBean> paramList) {}
  
  public void showBanner(final RentHouseDetail.Banner paramBanner)
  {
    if ((isDetached()) || (!isAdded())) {
      return;
    }
    if ((paramBanner == null) || (ae.isNull(paramBanner.getPhoto())))
    {
      this.r.setVisibility(8);
      this.u.setVisibility(8);
      return;
    }
    this.u.setVisibility(0);
    this.u.setController(c.frescoController(paramBanner.getPhoto()));
    if (ae.isNull(paramBanner.getLink()))
    {
      this.r.setVisibility(8);
      return;
    }
    this.r.setVisibility(0);
    this.r.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        JsBridgeWebActivity.start(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this), "", paramBanner.getLink());
      }
    });
  }
  
  public void showBigPic(String paramString)
  {
    if ((isDetached()) || (!isAdded())) {
      return;
    }
    this.K.setController(c.frescoController(paramString, new ControllerListener()
    {
      public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable) {}
      
      public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
      {
        paramAnonymousString = (ImageInfo)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          return;
        }
        paramAnonymousObject = LuxuryHouseDetailFragment.h(LuxuryHouseDetailFragment.this).getLayoutParams();
        ((ViewGroup.LayoutParams)paramAnonymousObject).width = (((ViewGroup.LayoutParams)paramAnonymousObject).height * paramAnonymousString.getWidth() / paramAnonymousString.getHeight());
        LuxuryHouseDetailFragment.h(LuxuryHouseDetailFragment.this).setLayoutParams((ViewGroup.LayoutParams)paramAnonymousObject);
        LuxuryHouseDetailFragment.i(LuxuryHouseDetailFragment.this).getLayoutParams().height = ((ViewGroup.LayoutParams)paramAnonymousObject).height;
        LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, ((ViewGroup.LayoutParams)paramAnonymousObject).width);
        final int i = LuxuryHouseDetailFragment.j(LuxuryHouseDetailFragment.this);
        LuxuryHouseDetailFragment.n(LuxuryHouseDetailFragment.this).post(new Runnable()
        {
          public void run()
          {
            LuxuryHouseDetailFragment.b(LuxuryHouseDetailFragment.this, (i - LuxuryHouseDetailFragment.k(LuxuryHouseDetailFragment.this)) / 2);
            LuxuryHouseDetailFragment.c(LuxuryHouseDetailFragment.this, LuxuryHouseDetailFragment.l(LuxuryHouseDetailFragment.this));
            LuxuryHouseDetailFragment.n(LuxuryHouseDetailFragment.this).scrollTo(LuxuryHouseDetailFragment.m(LuxuryHouseDetailFragment.this), 0);
            LuxuryHouseDetailFragment.o(LuxuryHouseDetailFragment.this);
          }
        });
      }
      
      public void onIntermediateImageFailed(String paramAnonymousString, Throwable paramAnonymousThrowable) {}
      
      public void onIntermediateImageSet(String paramAnonymousString, Object paramAnonymousObject) {}
      
      public void onRelease(String paramAnonymousString) {}
      
      public void onSubmit(String paramAnonymousString, Object paramAnonymousObject) {}
    }));
  }
  
  public void showBookDialog(final BookingOrderTextEntity paramBookingOrderTextEntity)
  {
    paramBookingOrderTextEntity = BookingOrderDialog.getInstance(paramBookingOrderTextEntity);
    paramBookingOrderTextEntity.setOnComfirmSignListener(new BookingOrderDialog.a()
    {
      public void comfirmSign()
      {
        LuxuryHouseDetailFragment.d(LuxuryHouseDetailFragment.this).doBook();
        paramBookingOrderTextEntity.dismiss();
      }
    });
    FragmentManager localFragmentManager;
    if (isStateEnable())
    {
      localFragmentManager = getActivity().getFragmentManager();
      if (!(paramBookingOrderTextEntity instanceof DialogFragment)) {
        paramBookingOrderTextEntity.show(localFragmentManager, "booking");
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)paramBookingOrderTextEntity, localFragmentManager, "booking");
  }
  
  public void showBottom(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, boolean paramBoolean4, long paramLong, boolean paramBoolean5)
  {
    if (paramLong > 0L)
    {
      this.al = new e(1000L * paramLong, 1000L);
      this.al.start();
    }
    if (paramBoolean1)
    {
      this.b.setVisibility(0);
      if (!paramBoolean3) {
        break label121;
      }
      this.c.setVisibility(0);
      this.c.setText(paramString1);
      this.c.setEnabled(paramBoolean2);
    }
    for (;;)
    {
      if (!paramBoolean5) {
        break label133;
      }
      this.d.setVisibility(0);
      this.d.setText(paramString2);
      this.d.setEnabled(paramBoolean4);
      return;
      this.b.setVisibility(8);
      break;
      label121:
      this.c.setVisibility(8);
    }
    label133:
    this.d.setVisibility(8);
  }
  
  public void showCarousel(List<String> paramList1, final List<String> paramList2, final LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    if (this.K != null)
    {
      this.ac.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.ad.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getAction())
          {
          default: 
          case 0: 
          case 2: 
            do
            {
              return true;
              LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, paramAnonymousMotionEvent.getX());
              LuxuryHouseDetailFragment.b(LuxuryHouseDetailFragment.this, paramAnonymousMotionEvent.getY());
              return true;
            } while ((LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this) <= 0.0F) || (LuxuryHouseDetailFragment.b(LuxuryHouseDetailFragment.this) <= 0.0F) || (Math.sqrt(Math.pow(Math.abs(LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this) - paramAnonymousMotionEvent.getX()), 2.0D) + Math.pow(Math.abs(LuxuryHouseDetailFragment.b(LuxuryHouseDetailFragment.this) - paramAnonymousMotionEvent.getY()), 2.0D)) <= 100.0D));
            LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, -1.0F);
            LuxuryHouseDetailFragment.b(LuxuryHouseDetailFragment.this, -1.0F);
            LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, paramList2, paramLinkedHashMap);
            LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, true);
            return true;
          }
          LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, -1.0F);
          LuxuryHouseDetailFragment.b(LuxuryHouseDetailFragment.this, -1.0F);
          if (LuxuryHouseDetailFragment.c(LuxuryHouseDetailFragment.this))
          {
            LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, false);
            return true;
          }
          LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, paramList2, paramLinkedHashMap);
          return true;
        }
      });
    }
  }
  
  public void showCollection(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          this.d.setText("已收藏");
        }
        this.a.setImageResource(2130840221);
      }
    }
    else {
      return;
    }
    if (paramBoolean2) {
      this.d.setText("立即收藏");
    }
    this.a.setImageResource(2130840220);
  }
  
  public void showCoordination(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void showCountTimeFinish()
  {
    this.d.setText("立即签约");
    this.d.setBackgroundColor(Color.parseColor("#FFA000"));
    this.d.setEnabled(true);
  }
  
  public void showEnsure(final RentHouseDetail.Ensure paramEnsure)
  {
    if ((isDetached()) || (!isAdded())) {}
    do
    {
      do
      {
        return;
      } while ((paramEnsure == null) || (paramEnsure.getDetailed() == null) || (paramEnsure.getDetailed().size() < 1));
      this.Y.setAdapter(new BaseAdapter()
      {
        public int getCount()
        {
          return paramEnsure.getDetailed().size();
        }
        
        public Object getItem(int paramAnonymousInt)
        {
          return paramEnsure.getDetailed().get(paramAnonymousInt);
        }
        
        public long getItemId(int paramAnonymousInt)
        {
          return paramAnonymousInt;
        }
        
        public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
        {
          paramAnonymousView = (RentHouseDetail.Ensure.Detail)paramEnsure.getDetailed().get(paramAnonymousInt);
          paramAnonymousViewGroup = LayoutInflater.from(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this)).inflate(2130904229, null);
          SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)paramAnonymousViewGroup.findViewById(2131695065);
          TextView localTextView1 = (TextView)paramAnonymousViewGroup.findViewById(2131695066);
          TextView localTextView2 = (TextView)paramAnonymousViewGroup.findViewById(2131695067);
          localSimpleDraweeView.setController(c.frescoController(paramAnonymousView.getIcon()));
          localTextView1.setText(paramAnonymousView.getTitle());
          localTextView2.setText(paramAnonymousView.getDesc());
          return paramAnonymousViewGroup;
        }
      });
    } while (ae.isNull(paramEnsure.getTitle()));
    this.X.setText(paramEnsure.getTitle());
  }
  
  public void showEnsureAll(RentHouseDetail.Ensure paramEnsure) {}
  
  public void showHeader(String paramString) {}
  
  public void showHouseCode(String paramString)
  {
    if (isDetached()) {
      return;
    }
    com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this.af).setTitle("房源编号").setContent(paramString).build().show();
    if (getActivity() != null) {
      ((ClipboardManager)getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", paramString));
    }
    g.textToast(this.af, "已复制房源编号");
  }
  
  public void showHouseConfig(List<RentHouseDetail.Config> paramList) {}
  
  public void showHouseInfo(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      JsBridgeWebActivity.start(this.af, paramString1, paramString2);
    }
  }
  
  public void showHouseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, List<RentHouseDetail.Tag> paramList, RentHouseDetail.ActivityBean paramActivityBean)
  {
    if ((isDetached()) || (!isAdded())) {
      return;
    }
    this.q.setText(paramString1);
    this.s.setText(paramString2);
    this.A.setText(paramString3);
    this.D.setText(paramString4);
    this.C.setText(paramString5);
    this.B.setText(paramString6);
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.L.setVisibility(0);
      this.L.removeAllViews();
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (RentHouseDetail.Tag)paramString1.next();
        paramString3 = new TextView(this.af);
        paramString3.setTextSize(2, 12.0F);
        paramString3.setTextColor(this.af.getResources().getColor(2131624587));
        paramString3.setGravity(17);
        paramString4 = new FlexboxLayout.LayoutParams(-2, (int)(24.0F * this.aj));
        paramString4.rightMargin = ((int)(16.0F * this.aj));
        paramString4.bottomMargin = ((int)(12.0F * this.aj));
        paramString3.setLayoutParams(paramString4);
        int i1 = (int)(10.0F * this.aj);
        paramString3.setPadding(i1, 0, i1, 0);
        paramString3.setBackgroundResource(2130839626);
        paramString3.setText(paramString2.getTitle());
        this.L.addView(paramString3);
      }
    }
    if (ae.isNull(paramString7))
    {
      this.z.setVisibility(8);
      return;
    }
    this.z.setVisibility(0);
    this.z.setText(paramString7);
  }
  
  public void showHouseInfoSpace(RentHouseDetail.Space paramSpace) {}
  
  public void showHouseTips(RentHouseDetail.TipBean.TipContent paramTipContent) {}
  
  public void showHousekeeper(final KeeperInfo paramKeeperInfo)
  {
    if ((isDetached()) || (!isAdded())) {
      return;
    }
    if (paramKeeperInfo == null)
    {
      this.T.setVisibility(8);
      this.V.setVisibility(8);
      this.W.setVisibility(8);
      this.U.setVisibility(8);
      return;
    }
    this.T.setVisibility(0);
    this.V.setVisibility(0);
    this.W.setVisibility(0);
    this.U.setVisibility(0);
    this.T.setController(c.frescoController(paramKeeperInfo.getHeadCorn()));
    this.W.setText(paramKeeperInfo.getKeeperPresent());
    this.U.setText(paramKeeperInfo.getKeeperName());
    this.V.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.a.a.onClickEvent("house_detail_callzo", "lxgj=" + paramKeeperInfo.getKeeperPhone(), LuxuryHouseDetailFragment.f(LuxuryHouseDetailFragment.this), "");
        if (!TextUtils.isEmpty(paramKeeperInfo.getKeeperPhone()))
        {
          com.ziroom.commonlibrary.g.b.a.onCallSteward();
          ah.callPhone(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this), paramKeeperInfo.getKeeperPhone());
          return;
        }
        g.textToast(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this), "未获取到管家电话");
      }
    });
  }
  
  public void showHuxingInfo(String paramString) {}
  
  public void showHxPicDetail(List<String> paramList1, List<String> paramList2, LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    paramList1 = new ArrayList();
    Intent localIntent = new Intent(this.af, ScanPhotoActivity.class);
    Bundle localBundle = new Bundle();
    paramList1.addAll(paramList2);
    localBundle.putSerializable("photos", paramList1);
    localIntent.putExtra("position", 0);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("mHouse_type", 0);
    ScanPhotoActivity.a = paramLinkedHashMap;
    startActivity(localIntent);
  }
  
  public void showIntroduce(String paramString)
  {
    if ((isDetached()) || (!isAdded())) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.y.setVisibility(0);
      this.y.setText(paramString);
      return;
    }
    this.y.setVisibility(8);
  }
  
  public void showNews(String paramString)
  {
    if ((isDetached()) || (!isAdded())) {
      return;
    }
    if (!ad.getBoolean(this.af, paramString)) {
      this.i.setVisibility(0);
    }
    for (;;)
    {
      ad.setBoolean(this.af, paramString, true);
      return;
      this.i.setVisibility(8);
    }
  }
  
  public void showPayType(PayType paramPayType)
  {
    if ((!isDetached()) && (isAdded()) && (paramPayType != null)) {
      new RentHouseDetailPayTypePop(this.af).show(this.K, paramPayType);
    }
  }
  
  public void showPicNumsign(int paramInt, String paramString)
  {
    if (isDetached()) {}
    while (8 != paramInt) {
      return;
    }
    if (("zxpzz".equals(paramString)) || ("tzpzz".equals(paramString)))
    {
      this.ab.setVisibility(4);
      return;
    }
    this.ab.setVisibility(0);
  }
  
  public void showQuestions(RentHouseDetail.QuestionListBean paramQuestionListBean) {}
  
  public void showRecommend(List<RentHouseRecommend> paramList)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.Z.setVisibility(0);
        float f1 = getResources().getDisplayMetrics().density;
        Object localObject = new LinearLayout.LayoutParams(-1, (int)((this.ai - 44.0F * f1) * 2.0F / 3.0F) + (int)(getResources().getDisplayMetrics().density * 104.0F + 0.5F));
        this.aa.setPadding((int)(f1 * 18.0F), 0, (int)(f1 * 18.0F), 0);
        this.aa.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new LinearLayoutManager(this.af);
        ((LinearLayoutManager)localObject).setOrientation(0);
        this.aa.setLayoutManager((RecyclerView.h)localObject);
        paramList = new b(paramList);
        this.aa.setAdapter(paramList);
      }
    }
    else {
      return;
    }
    this.Z.setVisibility(8);
  }
  
  public void showResblockIntroduce(final RentHouseDetail.ResidentialInfo paramResidentialInfo)
  {
    if ((isDetached()) || (!isAdded()) || (paramResidentialInfo == null)) {
      return;
    }
    this.N.setText(paramResidentialInfo.getName());
    if (ae.isNull(paramResidentialInfo.getRank())) {
      this.Q.setVisibility(8);
    }
    int i1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      i1 = paramResidentialInfo.getHouse_num();
      localObject1 = new SpannableString("同小区在租 " + paramResidentialInfo.getHouse_num() + " 套房源");
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.af.getResources().getColor(2131624587)), 6, String.valueOf(i1).length() + 6, 34);
      this.O.setText((CharSequence)localObject1);
      this.R.removeAllViews();
      localObject1 = paramResidentialInfo.getFacilities();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break;
      }
      i1 = 0;
      while (i1 < ((List)localObject1).size())
      {
        localObject2 = new TextView(this.af);
        ((TextView)localObject2).setTextColor(this.af.getResources().getColor(2131624417));
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setText((CharSequence)((List)localObject1).get(i1));
        this.R.addView((View)localObject2);
        if (i1 != ((List)localObject1).size() - 1)
        {
          localObject2 = new View(this.af);
          localObject3 = new FlexboxLayout.LayoutParams(ah.dip2px(this.af, 0.5F), ah.dip2px(this.af, 10.0F));
          int i2 = ah.dip2px(this.af, 8.0F);
          ((FlexboxLayout.LayoutParams)localObject3).leftMargin = i2;
          ((FlexboxLayout.LayoutParams)localObject3).rightMargin = i2;
          ((View)localObject2).setBackgroundColor(this.af.getResources().getColor(2131624587));
          this.R.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        i1 += 1;
      }
      this.Q.setVisibility(0);
      this.Q.setController(c.frescoController(paramResidentialInfo.getRank()));
    }
    if (paramResidentialInfo.getItem() != null)
    {
      if (this.Q.getVisibility() == 8)
      {
        localObject1 = (ConstraintLayout.LayoutParams)this.S.getLayoutParams();
        ((ConstraintLayout.LayoutParams)localObject1).i = 2131696076;
        ((ConstraintLayout.LayoutParams)localObject1).topMargin = ((int)(32.0F * this.aj));
        this.S.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      i1 = 0;
      if (i1 < paramResidentialInfo.getItem().size())
      {
        localObject1 = LayoutInflater.from(this.af).inflate(2130904231, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131690049);
        localObject3 = (TextView)((View)localObject1).findViewById(2131691546);
        RentHouseDetail.ResidentialInfo.item localitem = (RentHouseDetail.ResidentialInfo.item)paramResidentialInfo.getItem().get(i1);
        if (localitem == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((TextView)localObject2).setText(localitem.getName());
          ((TextView)localObject3).setText(localitem.getValue());
          this.S.addView((View)localObject1, new LinearLayout.LayoutParams(-1, ah.dip2px(this.af, 46.0F)));
          if (i1 != paramResidentialInfo.getItem().size() - 1)
          {
            localObject1 = new View(this.af);
            ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, ah.dip2px(this.af, 0.5F)));
            ((View)localObject1).setBackgroundColor(this.af.getResources().getColor(2131624046));
            this.S.addView((View)localObject1);
          }
        }
      }
    }
    if ((this.P != null) && (paramResidentialInfo.getPhotos() != null) && (paramResidentialInfo.getPhotos().size() > 0))
    {
      this.P.setVisibility(0);
      this.P.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
      {
        public LuxuryHouseDetailFragment.a createHolder()
        {
          return new LuxuryHouseDetailFragment.a(LuxuryHouseDetailFragment.this, null);
        }
      }, paramResidentialInfo.getPhotos(), null).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setCoverBottomViewVisible(true).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
      {
        public void onItemClick(int paramAnonymousInt)
        {
          ArrayList localArrayList = new ArrayList();
          Intent localIntent = new Intent(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this), ScanPhotoActivity.class);
          Bundle localBundle = new Bundle();
          localArrayList.addAll(paramResidentialInfo.getPhotos());
          localBundle.putSerializable("photos", localArrayList);
          localIntent.putExtra("position", paramAnonymousInt);
          localIntent.putExtras(localBundle);
          localIntent.putExtra("mHouse_type", 1);
          LuxuryHouseDetailFragment.this.startActivity(localIntent);
        }
      }).setPointViewVisible(true);
      this.P.startTurning(5000L);
      if (paramResidentialInfo.getPhotos().size() == 1)
      {
        this.P.setCanLoop(false);
        return;
      }
      this.P.setCanLoop(true);
      return;
    }
    this.P.setVisibility(8);
  }
  
  public void showRoomInfo(String paramString, List<RentHouseDetail.Roommate> paramList) {}
  
  public void showService(RentHouseDetail.Service paramService) {}
  
  public void showServiceAll(RentHouseDetail.Service paramService) {}
  
  public void showShare(String paramString1, RentHouseDetail.Share paramShare, int paramInt, String paramString2, View.OnClickListener paramOnClickListener)
  {
    if (paramShare == null) {
      return;
    }
    com.ziroom.threelib.ziroomshare.f.newBuilder(this.af).setFlag(31).setShareTitle(paramShare.getTitle()).setShareUrl(paramShare.getUrl()).setShareContent(paramShare.getContent()).setSharePicUrl(paramString1).build().addShareItem(0, paramInt, paramString2, paramOnClickListener).show();
  }
  
  public void showSignEndDate(RentHouseDetail.SignDuration paramSignDuration) {}
  
  public void showSubleDialog()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this.af).setTitle("发起者休息中").setContent("转租发起者暂时关闭了咨询，建议您先收藏房源，并时刻关注房源状态").setButtonText("我知道了").build().show();
  }
  
  public void showSubletDesc(RentHouseDetail.Sublet paramSublet) {}
  
  public void showSubletRecommend(String paramString) {}
  
  public void showSubsidiary(List<RentHouseDetail.Space> paramList, String paramString)
  {
    if ((!isDetached()) && (isAdded()))
    {
      if (ae.notNull(paramString))
      {
        this.G.setVisibility(0);
        this.G.setController(c.frescoController(paramString));
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
                LuxuryHouseDetailFragment.d(LuxuryHouseDetailFragment.this).clickTabInitData(((Integer)paramAnonymousView.getTag()).intValue());
              }
            });
            paramString.setTag(Integer.valueOf(i1));
            paramString.setShowColor("#C79167");
            paramString.setStr(((RentHouseDetail.Space)paramList.get(i1)).getName());
            this.F.addView(paramString);
            i1 += 1;
            continue;
            this.G.setVisibility(8);
            break;
          }
        }
        this.ag.clickTabInitData(0);
      }
    }
  }
  
  public void showSubsidiaryAll(List<RentHouseDetail.Space> paramList)
  {
    new RentHouseDetailSpacePop(this.af).show(this.K, paramList);
  }
  
  public void showWillUnrent(RentHouseDetail paramRentHouseDetail) {}
  
  public void showWillUnrentPop(RentHouseDetail paramRentHouseDetail) {}
  
  public void toAppointment(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent(this.af, InitiateAppointActivity.class);
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
    Intent localIntent = new Intent(this.af, CertInformationActivity.class);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("phone", paramString1);
    if (com.freelxl.baselibrary.f.f.notNull(paramString2)) {
      localIntent.putExtra("type", 2);
    }
    startActivity(localIntent);
  }
  
  public void toCertInfoConfirm(HouseDetail paramHouseDetail, CertInfoEntity paramCertInfoEntity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.af, SignedCertInfoConfirmActivity.class);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("phone", paramString);
    localIntent.putExtra("cert_info", paramCertInfoEntity);
    localIntent.putExtra("type", paramInt);
    startActivity(localIntent);
  }
  
  public void toCertInput(CertInfoEntity paramCertInfoEntity, HouseDetail paramHouseDetail, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.af, CertInformationActivity.class);
    localIntent.putExtra("cert_info", paramCertInfoEntity);
    localIntent.putExtra("phone", paramString);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("type", paramInt);
    startActivity(localIntent);
  }
  
  public void toCertStatus(HouseDetail paramHouseDetail, CertInfoEntity paramCertInfoEntity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.af, CertificationInfoActivity.class);
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
      Intent localIntent = new Intent(this.af, DistrictDetailActivity.class);
      localIntent.putExtra("resblockId", paramRentHouseDetail.getResblock().getId());
      localIntent.putExtra("houseDetail", paramRentHouseDetail);
      startActivity(localIntent);
    }
  }
  
  public void toResblockHouseList(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.af, HouseListActivity.class);
    SearchCondition localSearchCondition = new SearchCondition();
    localSearchCondition.setResblock_id(paramString1);
    localIntent.putExtra("searchCondition", localSearchCondition);
    localIntent.putExtra("etSearch", paramString2);
    this.af.startActivity(localIntent);
  }
  
  public void toSign(HouseDetail paramHouseDetail, String paramString)
  {
    Intent localIntent = new Intent(this.af, SignerDataActivity.class);
    localIntent.putExtra("detail", paramHouseDetail);
    localIntent.putExtra("phone", paramString);
    startActivity(localIntent);
  }
  
  public void toSublet(final String paramString1, String paramString2)
  {
    View localView = this.ak.inflate(2130903835, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this.af, 2131427591).create();
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
          LuxuryHouseDetailFragment.d(LuxuryHouseDetailFragment.this).contactSublet();
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
    View localView = this.ak.inflate(2130903858, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    final EditText localEditText = (EditText)localView.findViewById(2131693896);
    this.am = new Dialog(this.af, 2131427591);
    Dialog localDialog = this.am;
    if (!(localDialog instanceof Dialog)) {
      localDialog.show();
    }
    for (;;)
    {
      this.am.setContentView(localView);
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
            LuxuryHouseDetailFragment.d(LuxuryHouseDetailFragment.this).checkSubletCode(VdsAgent.trackEditTextSilent(localEditText).toString());
          }
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LuxuryHouseDetailFragment.g(LuxuryHouseDetailFragment.this).dismiss();
        }
      });
      return;
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
  
  public void toSubletContact(final String paramString1, final String paramString2, final String paramString3)
  {
    View localView1 = this.ak.inflate(2130905157, null);
    final PopupWindow localPopupWindow = new PopupWindow(localView1, -1, -1);
    View localView2 = this.ae.findViewById(2131696058);
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
            ah.sendMessages(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this), paramString3, paramAnonymousView);
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
            ah.callPhone(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this), paramString3);
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
    label231:
    label242:
    for (;;)
    {
      return;
      int i2 = this.F.getChildCount();
      int i1 = 0;
      if (i1 < i2)
      {
        TextLineView localTextLineView = (TextLineView)this.F.getChildAt(i1);
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
      this.I.setTextColor(Color.parseColor("#C79167"));
      this.J.setTextColor(Color.parseColor("#C79167"));
      if ((ae.notNull(paramSpace.getArea())) && (!"0".equals(paramSpace.getArea())))
      {
        this.I.setText("面积 · " + paramSpace.getArea() + "m²");
        if (!ae.notNull(paramSpace.getFace())) {
          break label231;
        }
        this.J.setText("朝向 · " + paramSpace.getFace());
      }
      for (;;)
      {
        if (paramSpace.getConfig() == null) {
          break label242;
        }
        paramSpace = new d(paramSpace.getConfig());
        this.H.setAdapter(paramSpace);
        return;
        this.I.setText("面积 · 暂无数据");
        break;
        this.J.setText("朝向 · 暂无数据");
      }
    }
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      paramContext = x.makeUrl(paramString);
      this.b.setController(c.frescoController(paramContext));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
  
  private class b
    extends RecyclerView.a<LuxuryHouseDetailFragment.c>
  {
    private List<RentHouseRecommend> b;
    private int c;
    
    public b()
    {
      List localList;
      this.b = localList;
      this.c = ((int)(LuxuryHouseDetailFragment.k(LuxuryHouseDetailFragment.this) - 36.0F * LuxuryHouseDetailFragment.p(LuxuryHouseDetailFragment.this)));
    }
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public void onBindViewHolder(LuxuryHouseDetailFragment.c paramc, int paramInt)
    {
      final RentHouseRecommend localRentHouseRecommend = (RentHouseRecommend)this.b.get(paramInt);
      if (localRentHouseRecommend != null)
      {
        paramc.a.setController(c.frescoController(localRentHouseRecommend.getPhoto()));
        paramc.c.setText("¥" + localRentHouseRecommend.getPrice());
        paramc.b.setText(localRentHouseRecommend.getName());
        paramc.d.setText(localRentHouseRecommend.getSubway_station_info());
        if ((localRentHouseRecommend.getTips() == null) || (localRentHouseRecommend.getTips().size() < 1))
        {
          paramc.e.setVisibility(8);
          paramc.itemView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this), RentHouseDetailActivity.class);
              paramAnonymousView.putExtra("house_id", localRentHouseRecommend.getHouse_id());
              paramAnonymousView.putExtra("id", localRentHouseRecommend.getId());
              LuxuryHouseDetailFragment.this.startActivity(paramAnonymousView);
            }
          });
        }
      }
      else
      {
        return;
      }
      paramc.e.setVisibility(0);
      paramc.e.removeAllViews();
      paramInt = 0;
      label155:
      Object localObject;
      TextView localTextView;
      if (paramInt < localRentHouseRecommend.getTips().size())
      {
        localObject = (RentHouseRecommend.Tip)localRentHouseRecommend.getTips().get(paramInt);
        localTextView = new TextView(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this));
        localTextView.setTextSize(2, 10.0F);
        if (localRentHouseRecommend.getType() != 8) {
          break label350;
        }
        localTextView.setTextColor(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this).getResources().getColor(2131624587));
        localTextView.setBackgroundResource(2130839635);
      }
      for (;;)
      {
        localTextView.setText(((RentHouseRecommend.Tip)localObject).getTitle());
        localTextView.setGravity(17);
        float f = LuxuryHouseDetailFragment.this.getResources().getDisplayMetrics().density;
        int i = (int)(6.0F * f);
        int j = (int)(3.0F * f);
        localTextView.setPadding(i, j, i, j);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(f * 6.0F));
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramc.e.addView(localTextView);
        paramInt += 1;
        break label155;
        break;
        label350:
        localTextView.setTextColor(LuxuryHouseDetailFragment.e(LuxuryHouseDetailFragment.this).getResources().getColor(2131624417));
        localTextView.setBackgroundResource(2130839627);
      }
    }
    
    public LuxuryHouseDetailFragment.c onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LuxuryHouseDetailFragment.q(LuxuryHouseDetailFragment.this).inflate(2130904458, paramViewGroup, false);
      LuxuryHouseDetailFragment.c localc = new LuxuryHouseDetailFragment.c(LuxuryHouseDetailFragment.this, paramViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.c * 2 / 3 + (int)(LuxuryHouseDetailFragment.p(LuxuryHouseDetailFragment.this) * 96.0F + 0.5F));
      localLayoutParams.setMargins(0, 0, (int)(LuxuryHouseDetailFragment.p(LuxuryHouseDetailFragment.this) * 6.0F), 0);
      paramViewGroup.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.c, this.c * 2 / 3);
      localc.a = ((SimpleDraweeView)paramViewGroup.findViewById(2131691098));
      localc.a.setLayoutParams(localLayoutParams);
      localc.c = ((TextView)paramViewGroup.findViewById(2131689912));
      localc.b = ((TextView)paramViewGroup.findViewById(2131690049));
      localc.d = ((TextView)paramViewGroup.findViewById(2131690748));
      localc.e = ((LinearLayout)paramViewGroup.findViewById(2131689834));
      return localc;
    }
  }
  
  private class c
    extends RecyclerView.u
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    LinearLayout e;
    
    public c(View paramView)
    {
      super();
    }
  }
  
  private class d
    extends BaseAdapter
  {
    private List<RentHouseDetail.Config> b;
    
    public d()
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
        paramView = LuxuryHouseDetailFragment.q(LuxuryHouseDetailFragment.this).inflate(2130904464, paramViewGroup, false);
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
  
  class e
    extends CountDownTimer
  {
    public e(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      if (LuxuryHouseDetailFragment.d(LuxuryHouseDetailFragment.this) != null) {
        LuxuryHouseDetailFragment.d(LuxuryHouseDetailFragment.this).countTimeFinish();
      }
    }
    
    public void onTick(long paramLong)
    {
      if ((!LuxuryHouseDetailFragment.this.isDetached()) && (LuxuryHouseDetailFragment.this.d != null)) {
        LuxuryHouseDetailFragment.this.d.setText("距可签约\n" + m.secToTime((int)paramLong / 1000));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/LuxuryHouseDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */