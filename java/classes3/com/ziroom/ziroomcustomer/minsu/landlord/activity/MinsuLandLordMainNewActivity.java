package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.b;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil.NeedOtherCheckUpdate;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuPersonalDataActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseTodayHintBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseTodayHintBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordInfo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordInfo.Customer;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordInfo.Medal;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLlBannerBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuUploadPicNewBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.l;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.landlord.fragment.MinsuLLNeadDealOrderFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification.QApersonalActivity;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView.b;
import com.ziroom.ziroomcustomer.minsu.view.IntellectDeviceView;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinsuLandLordMainNewActivity
  extends BaseActivity
  implements EMMessageListener, SearchListScrollView.b
{
  public static MinsuLandLordMainNewActivity a;
  public static String b;
  private int A;
  private int B;
  private int C;
  private float D;
  private double E = 1.0667D;
  private float F;
  private float G;
  private float H;
  private b I;
  private BroadcastReceiver J;
  private AnimationDrawable K;
  private Boolean L = Boolean.valueOf(false);
  private List<String> M;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d N;
  private List<String> O = new ArrayList();
  private boolean P = false;
  private boolean Q = false;
  private Handler R = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if ((MinsuLandLordMainNewActivity.i(MinsuLandLordMainNewActivity.this)) && (MinsuLandLordMainNewActivity.j(MinsuLandLordMainNewActivity.this)))
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 开始同步 环信");
        MinsuLandLordMainNewActivity.this.getUnReadMsgCount();
      }
    }
  };
  @BindView(2131691403)
  AppBarLayout appBarLayout;
  @BindView(2131690079)
  View bottomLine;
  public BroadcastReceiver c = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      int j = paramAnonymousIntent.getIntExtra("status", 0);
      if (EMClient.getInstance().isLoggedInBefore()) {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 没有登陆 环信");
      }
      if ((i == 17) && (j == 1))
      {
        MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, true);
        MinsuLandLordMainNewActivity.h(MinsuLandLordMainNewActivity.this).sendEmptyMessage(1);
      }
      if ((j == 1) && (MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this) != null)) {
        MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this).LoadData();
      }
    }
  };
  @BindView(2131690977)
  ConvenientBanner cb;
  @BindView(2131691486)
  ImageView closeToday;
  @BindView(2131691402)
  SearchListScrollView coordinatorLayout;
  public BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MinsuLandLordMainNewActivity.b(MinsuLandLordMainNewActivity.this, true);
      MinsuLandLordMainNewActivity.h(MinsuLandLordMainNewActivity.this).sendEmptyMessage(1);
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 登录 成功 了  ！ 登陆 环信");
    }
  };
  private long e;
  private int f = 0;
  @BindView(2131691480)
  FrameLayout flPhoto;
  private String[] g = { "待处理", "待评价", "进行中" };
  @BindView(2131696887)
  LinearLayout llMyinfo;
  @BindView(2131691484)
  RelativeLayout llTodayHint;
  @BindView(2131696890)
  LinearLayout ll_emblem;
  @BindView(2131696889)
  FrameLayout ll_emblem_bg;
  @BindView(2131696880)
  IntellectDeviceView myinfoEvaluation;
  @BindView(2131696881)
  IntellectDeviceView myinfoHouseMessage;
  @BindView(2131691481)
  SimpleDraweeView myinfoIvIcon;
  @BindView(2131696878)
  IntellectDeviceView myinfoMessage;
  @BindView(2131696885)
  IntellectDeviceView myinfoMove;
  @BindView(2131696879)
  IntellectDeviceView myinfoOrders;
  @BindView(2131696882)
  IntellectDeviceView myinfoOverage;
  @BindView(2131696883)
  IntellectDeviceView myinfoPrePaidCard;
  @BindView(2131696352)
  TextView myinfoTvLogin;
  @BindView(2131692018)
  TextView myinfoTvName;
  @BindView(2131696888)
  TextView myinfoTvRole;
  @BindView(2131691477)
  RelativeLayout myinfoUserinfoWrap;
  @BindView(2131696884)
  IntellectDeviceView myinfoVoucher;
  private List<MinsuLlBannerBean> r = new ArrayList();
  private int s;
  @BindView(2131691476)
  SwipeRefreshLayout swipeRefreshLayout;
  private String t = "";
  @BindView(2131690261)
  TabLayout tabs;
  @BindView(2131691485)
  SimpleDraweeView todayHintPic;
  @BindView(2131691474)
  TextView tvChangeMode;
  @BindView(2131691475)
  TextView tvReleaseHouse;
  @BindView(2131691479)
  TextView tv_emblem_hint;
  @BindView(2131691483)
  ImageView tv_icon_emblem;
  @BindView(2131691482)
  TextView tv_icon_status;
  private boolean u = false;
  private com.ziroom.ziroomcustomer.minsu.landlord.b.b v;
  @BindView(2131690262)
  ViewPager viewpage;
  private int w;
  private int x;
  private int y;
  private int z;
  
  private void a()
  {
    this.I = new b();
    registerReceiver(this.I, new IntentFilter("minsu_eva_commitsuccess"));
  }
  
  private void a(float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    this.myinfoTvName.getLocationOnScreen(arrayOfInt);
    float f1 = (int)(arrayOfInt[0] - (this.x - this.w * this.E));
    float f2 = (int)(this.D * 20.0F + (int)Math.round(this.w * this.E / 2.0D));
    float f3 = f1 - f2;
    paramFloat = Math.min(Math.max(f2, paramFloat), f1);
    int i = Math.round(255.0F * (1.0F - Math.abs((paramFloat - f2) / f3)));
    this.myinfoTvName.setTextColor(Color.argb(i, 68, 68, 68));
    this.myinfoTvRole.setTextColor(Color.argb(i, 68, 68, 68));
    this.myinfoTvLogin.setTextColor(Color.argb(i, 68, 68, 68));
    Log.w("TAG", "startX:" + f2 + ",endX:" + f1 + ",;distanceX:" + f3 + ",currentX:" + paramFloat + ",alpha:" + i + ",llMyinfo.getX():" + this.llMyinfo.getX() + ",namePositions[0]:" + arrayOfInt[0]);
  }
  
  private void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        if (paramInt2 + paramInt3 < 1)
        {
          if (paramInt1 > 0) {
            MinsuLandLordMainNewActivity.this.myinfoMessage.setShowMessage(true);
          }
          for (;;)
          {
            MinsuLandLordMainNewActivity.this.myinfoMessage.setMessageText(null);
            return;
            MinsuLandLordMainNewActivity.this.myinfoMessage.setShowMessage(false);
          }
        }
        MinsuLandLordMainNewActivity.this.myinfoMessage.setShowMessage(false);
        if (paramInt2 + paramInt3 > 0)
        {
          if (paramInt2 + paramInt3 > 99)
          {
            MinsuLandLordMainNewActivity.this.myinfoMessage.setMessageText("99+");
            return;
          }
          MinsuLandLordMainNewActivity.this.myinfoMessage.setMessageText(paramInt2 + paramInt3 + "");
          return;
        }
        MinsuLandLordMainNewActivity.this.myinfoMessage.setMessageText(null);
      }
    }, 110L);
  }
  
  private void a(ImageView paramImageView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n.dip2px(this, 16.0F), n.dip2px(this, 26.0F));
    localLayoutParams.setMargins(0, 0, 0, n.dip2px(this, 3.0F));
    localLayoutParams.gravity = 80;
    paramImageView.setLayoutParams(localLayoutParams);
    this.ll_emblem.addView(paramImageView);
  }
  
  private void a(final MinsuLLHouseTodayHintBean paramMinsuLLHouseTodayHintBean)
  {
    if ((q().booleanValue()) && (!TextUtils.isEmpty(paramMinsuLLHouseTodayHintBean.getData().getActIntroduc())))
    {
      int j = ac.getScreenWidth(this) - ab.dp2px(this, 86.0F);
      int i = j * 151 / 100;
      if (j * 151 / 100 + ab.dp2px(this, 160.0F) <= com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenHeight(this)) {}
      for (;;)
      {
        this.todayHintPic.getLayoutParams().width = j;
        this.todayHintPic.getLayoutParams().height = i;
        this.llTodayHint.setVisibility(0);
        this.todayHintPic.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(this, 5.0F));
        this.todayHintPic.setController(com.freelxl.baselibrary.f.c.frescoController(paramMinsuLLHouseTodayHintBean.getData().getActIntroducPic()));
        GenericDraweeHierarchy localGenericDraweeHierarchy = (GenericDraweeHierarchy)this.todayHintPic.getHierarchy();
        localGenericDraweeHierarchy.getRoundingParams();
        RoundingParams localRoundingParams = new RoundingParams();
        localRoundingParams.setCornersRadius(30.0F);
        localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
        this.closeToday.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            com.ziroom.ziroomcustomer.util.ad.saveMinsuMainTodayHint(MinsuLandLordMainNewActivity.this, Boolean.valueOf(false), com.ziroom.ziroomcustomer.util.m.GetNowDateTime());
            MinsuLandLordMainNewActivity.this.llTodayHint.setVisibility(8);
          }
        });
        this.todayHintPic.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            JsBridgeWebActivity.start(MinsuLandLordMainNewActivity.this, "", paramMinsuLLHouseTodayHintBean.getData().getActIntroduc());
          }
        });
        return;
        i = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenHeight(this) - ab.dp2px(this, 160.0F);
        j = i * 100 / 151;
      }
    }
    this.llTodayHint.setVisibility(8);
  }
  
  private void a(List<MinsuLandlordInfo.Medal> paramList, MinsuLandlordInfo paramMinsuLandlordInfo)
  {
    List localList = com.ziroom.ziroomcustomer.minsu.f.u.getEmblemHistory(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMinsuLandlordInfo.medalMsgFront);
    this.ll_emblem.removeAllViews();
    int i = 0;
    if (i < paramList.size())
    {
      ImageView localImageView = new ImageView(this);
      if (com.ziroom.ziroomcustomer.util.s.isEmpty(localList)) {
        if (((MinsuLandlordInfo.Medal)paramList.get(i)).isLighten == 1) {
          a(paramList, localStringBuilder, i, localImageView);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        b(localImageView);
        localImageView.setImageDrawable(getResources().getDrawable(2130840278));
        continue;
        if (i < localList.size())
        {
          if ((((MinsuLandlordInfo.Medal)paramList.get(i)).isLighten == 1) && (((MinsuLandlordInfo.Medal)paramList.get(i)).isLighten != ((MinsuLandlordInfo.Medal)localList.get(i)).isLighten))
          {
            a(paramList, localStringBuilder, i, localImageView);
          }
          else
          {
            b(localImageView);
            if (((MinsuLandlordInfo.Medal)paramList.get(i)).isLighten == 0) {
              localImageView.setImageDrawable(getResources().getDrawable(2130840278));
            } else {
              localImageView.setImageDrawable(getResources().getDrawable(2130840279));
            }
          }
        }
        else if (((MinsuLandlordInfo.Medal)paramList.get(i)).isLighten == 1)
        {
          a(paramList, localStringBuilder, i, localImageView);
        }
        else
        {
          b(localImageView);
          localImageView.setImageDrawable(getResources().getDrawable(2130840278));
        }
      }
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localStringBuilder.append(paramMinsuLandlordInfo.medalMsgLater);
    if (this.L.booleanValue() == true)
    {
      this.tv_emblem_hint.setVisibility(0);
      this.tv_emblem_hint.setText(localStringBuilder.toString());
      this.L = Boolean.valueOf(false);
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.minsu.f.u.putEmblemHistory(this, paramList);
      return;
      this.tv_emblem_hint.setVisibility(8);
    }
  }
  
  private void a(List<MinsuLandlordInfo.Medal> paramList, StringBuilder paramStringBuilder, int paramInt, ImageView paramImageView)
  {
    a(paramImageView);
    this.L = Boolean.valueOf(true);
    paramStringBuilder.append(((MinsuLandlordInfo.Medal)paramList.get(paramInt)).medalMsg);
    paramStringBuilder.append("、");
    paramImageView.setImageDrawable(getResources().getDrawable(2130839053));
    this.K = ((AnimationDrawable)paramImageView.getDrawable());
    this.K.start();
  }
  
  private void b()
  {
    this.cb.setVisibility(8);
    this.v = new com.ziroom.ziroomcustomer.minsu.landlord.b.b(getSupportFragmentManager(), this.g);
    this.viewpage.setAdapter(this.v);
    this.tabs.setupWithViewPager(this.viewpage);
    this.viewpage.setOffscreenPageLimit(3);
    setIndicator(this, this.tabs, 30, 30);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, ac.getScreenHeight(this) - ah.dip2px(this, 102.0F));
    this.viewpage.setLayoutParams(localLayoutParams);
    this.coordinatorLayout.setOnScrollListener(this);
    this.viewpage.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        MinsuLandLordMainNewActivity.this.coordinatorLayout.getHelper().setCurrentScrollableContainer(MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this).getItem(paramAnonymousInt));
        if (MinsuLandLordMainNewActivity.this.tv_emblem_hint.getVisibility() == 0) {
          MinsuLandLordMainNewActivity.this.tv_emblem_hint.setVisibility(8);
        }
      }
    });
    this.coordinatorLayout.getHelper().setCurrentScrollableContainer(this.v.getItem(0));
    this.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
    {
      public void onRefresh()
      {
        com.ziroom.ziroomcustomer.util.u.e("yangxj", "下拉刷新");
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this).LoadData();
            MinsuLandLordMainNewActivity.b(MinsuLandLordMainNewActivity.this);
            MinsuLandLordMainNewActivity.this.swipeRefreshLayout.setRefreshing(false);
          }
        }, 1000L);
      }
    });
  }
  
  private void b(int paramInt)
  {
    float f1 = this.H;
    float f2 = ((this.tvChangeMode.getBottom() - this.tvChangeMode.getTop() - this.flPhoto.getHeight()) / 2.0F - f1) / (this.C - this.z);
    float f3 = paramInt - this.z;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.flPhoto.getLayoutParams();
    localLayoutParams.topMargin = Math.round(f2 * f3 + f1);
    this.flPhoto.setLayoutParams(localLayoutParams);
    this.flPhoto.requestLayout();
  }
  
  private void b(ImageView paramImageView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n.dip2px(this, 14.0F), n.dip2px(this, 14.0F));
    localLayoutParams.setMargins(0, 0, 0, n.dip2px(this, 3.0F));
    localLayoutParams.gravity = 80;
    paramImageView.setLayoutParams(localLayoutParams);
    this.ll_emblem.addView(paramImageView);
  }
  
  private void c(int paramInt)
  {
    float f1 = this.F;
    float f2 = ((this.B - this.flPhoto.getWidth()) / 2.0F - f1) * 1.0F / (this.z - this.w);
    float f3 = paramInt - this.w;
    float f4 = (this.tvChangeMode.getTop() + this.tvChangeMode.getBottom()) / 2.0F;
    float f5 = this.G;
    float f6 = (f4 - f5) * 1.0F / (this.z - this.w) * (paramInt - this.w) + f5;
    this.H = f6;
    Log.i("TAG", "tvChangeMode.getTop:" + this.tvChangeMode.getTop() + ",tvChangeMode.getBottom():" + this.tvChangeMode.getBottom() + ", topMargin:" + f6 + ",endY:" + f4 + ",startY:" + f5);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.flPhoto.getLayoutParams();
    localLayoutParams.leftMargin = Math.round(f2 * f3 + f1);
    localLayoutParams.topMargin = Math.round(f6);
    this.flPhoto.setLayoutParams(localLayoutParams);
    this.flPhoto.requestLayout();
  }
  
  private void d(int paramInt)
  {
    int i = (int)(this.x - paramInt * this.E);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    this.myinfoIvIcon.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.myinfoIvIcon.requestLayout();
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).height = i;
    ((RelativeLayout.LayoutParams)localObject).width = i;
    this.F = (this.D * 20.0F + (int)Math.round(paramInt * this.E / 2.0D));
    this.G = (this.D * 129.0F - paramInt - i - paramInt / 2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)this.F);
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.G);
    this.flPhoto.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.flPhoto.requestLayout();
    i = (int)(this.y - Math.round(0.4D * paramInt));
    localObject = (FrameLayout.LayoutParams)this.tv_icon_emblem.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = i;
    ((FrameLayout.LayoutParams)localObject).height = i;
    this.tv_icon_emblem.requestLayout();
    float f1 = paramInt * 0.2571F / this.D;
    localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.tv_icon_status.setTextSize(12.0F - f1);
    this.tv_icon_status.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.tv_icon_status.requestLayout();
    localObject = this.bottomLine;
    if (this.G < this.tvReleaseHouse.getHeight()) {}
    for (paramInt = 8;; paramInt = 0)
    {
      ((View)localObject).setVisibility(paramInt);
      return;
    }
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      g.textToast(this, "图片获取失败");
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      g.textToast(this, "图片获取失败");
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.uploadImg(this, paramString, 3, new com.ziroom.ziroomcustomer.minsu.f.s(this, new p(MinsuUploadPicNewBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuUploadPicNewBean paramAnonymousMinsuUploadPicNewBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuUploadPicNewBean);
        if (paramAnonymousMinsuUploadPicNewBean != null) {
          MinsuLandLordMainNewActivity.this.myinfoIvIcon.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuUploadPicNewBean.picUrl));
        }
      }
    });
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLlInfoCenter(this, new t(null, new p(MinsuLandlordInfo.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuLandLordMainNewActivity.c(MinsuLandLordMainNewActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLandlordInfo paramAnonymousMinsuLandlordInfo)
      {
        if (paramAnonymousMinsuLandlordInfo != null)
        {
          MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, paramAnonymousMinsuLandlordInfo.authCode.intValue());
          MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, paramAnonymousMinsuLandlordInfo.phone400);
          MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, paramAnonymousMinsuLandlordInfo.photoRules);
          String str = paramAnonymousMinsuLandlordInfo.customer.nickName;
          MinsuLandLordMainNewActivity.this.myinfoTvName.setVisibility(0);
          MinsuLandLordMainNewActivity.this.myinfoTvLogin.setVisibility(8);
          if (ae.notNull(str))
          {
            if (!ae.notNull(str)) {
              break label306;
            }
            label88:
            MinsuLandLordMainNewActivity.this.myinfoTvName.setText(str);
            MinsuLandLordMainNewActivity.this.myinfoTvRole.setText(paramAnonymousMinsuLandlordInfo.landlordTimeMsg);
            if (paramAnonymousMinsuLandlordInfo.angelLandlordOffOn != 1) {
              break label317;
            }
            MinsuLandLordMainNewActivity.this.ll_emblem_bg.setVisibility(0);
            MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, paramAnonymousMinsuLandlordInfo.medalList, paramAnonymousMinsuLandlordInfo);
            label144:
            if (paramAnonymousMinsuLandlordInfo.isAngelLandlord != 1) {
              break label344;
            }
            MinsuLandLordMainNewActivity.this.tv_icon_emblem.setVisibility(0);
            label163:
            MinsuLandLordMainNewActivity.this.myinfoIvIcon.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuLandlordInfo.userPicUrl));
            if ((MinsuLandLordMainNewActivity.this.myinfoIvIcon != null) && (MinsuLandLordMainNewActivity.this.tv_icon_status != null))
            {
              MinsuLandLordMainNewActivity.this.myinfoIvIcon.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuLandlordInfo.userPicUrl));
              if (TextUtils.isEmpty(paramAnonymousMinsuLandlordInfo.userPicAuditMsg)) {
                break label359;
              }
              ((GenericDraweeHierarchy)MinsuLandLordMainNewActivity.this.myinfoIvIcon.getHierarchy()).setOverlayImage(new ColorDrawable(1291845632));
              MinsuLandLordMainNewActivity.this.tv_icon_status.setText(paramAnonymousMinsuLandlordInfo.userPicAuditMsg);
            }
          }
          for (;;)
          {
            if (paramAnonymousMinsuLandlordInfo.waitEvaNum > 0)
            {
              if (paramAnonymousMinsuLandlordInfo.waitEvaNum > 99)
              {
                MinsuLandLordMainNewActivity.this.myinfoEvaluation.setMessageText("99+");
                return;
                str = paramAnonymousMinsuLandlordInfo.customer.realName;
                break;
                label306:
                str = paramAnonymousMinsuLandlordInfo.customer.customerMobile;
                break label88;
                label317:
                MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, Boolean.valueOf(false));
                MinsuLandLordMainNewActivity.this.ll_emblem_bg.setVisibility(8);
                break label144;
                label344:
                MinsuLandLordMainNewActivity.this.tv_icon_emblem.setVisibility(8);
                break label163;
                label359:
                ((GenericDraweeHierarchy)MinsuLandLordMainNewActivity.this.myinfoIvIcon.getHierarchy()).setOverlayImage(new ColorDrawable(16777215));
                MinsuLandLordMainNewActivity.this.tv_icon_status.setText(null);
                continue;
              }
              MinsuLandLordMainNewActivity.this.myinfoEvaluation.setMessageText(paramAnonymousMinsuLandlordInfo.waitEvaNum + "");
              return;
            }
          }
          MinsuLandLordMainNewActivity.this.myinfoEvaluation.setMessageText(null);
          return;
        }
        MinsuLandLordMainNewActivity.c(MinsuLandLordMainNewActivity.this);
      }
    });
  }
  
  private void f()
  {
    this.myinfoIvIcon.setController(com.freelxl.baselibrary.f.c.frescoController(""));
    this.tv_icon_status.setText(null);
    this.myinfoTvRole.setText("");
    this.myinfoTvLogin.setVisibility(0);
    this.myinfoTvName.setVisibility(8);
    this.ll_emblem_bg.setVisibility(8);
    this.tv_icon_emblem.setVisibility(8);
    this.myinfoEvaluation.setMessageText(null);
    this.v.resetData();
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLlBanner(this, new t(this, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        paramAnonymouse = ((com.alibaba.fastjson.e)paramAnonymouse.get("data")).get("lunbotu").toString();
        MinsuLandLordMainNewActivity.b(MinsuLandLordMainNewActivity.this, com.alibaba.fastjson.a.parseArray(paramAnonymouse, MinsuLlBannerBean.class));
        MinsuLandLordMainNewActivity.d(MinsuLandLordMainNewActivity.this);
      }
    });
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.util.ad.saveVersion(this, Integer.parseInt(ah.getAppVersion(ApplicationEx.c)));
    i();
    j();
  }
  
  private void i()
  {
    new com.ziroom.ziroomcustomer.util.a().getAdvertisement();
  }
  
  private void j()
  {
    UpdateUtil.getInstance().checkUpdate(this, false);
    UpdateUtil.getInstance().setNeedOtherCheckUpdate(new UpdateUtil.NeedOtherCheckUpdate()
    {
      public void checkUpdate()
      {
        new com.ziroom.ziroomcustomer.f.a(MinsuLandLordMainNewActivity.this).checkPgyUpdate(false);
      }
    });
  }
  
  private void k()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.c, localIntentFilter);
    localIntentFilter = new IntentFilter("action_em_login_succ");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.d, localIntentFilter);
    this.J = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        MinsuLandLordMainNewActivity.c(MinsuLandLordMainNewActivity.this);
      }
    };
    localIntentFilter = new IntentFilter(getString(2131296569));
    LocalBroadcastManager.getInstance(this).registerReceiver(this.J, localIntentFilter);
  }
  
  private Boolean l()
  {
    if (ApplicationEx.c.getUser() == null)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, LoginActivity.class);
      startActivityForResult(localIntent, 121);
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  private void m()
  {
    if ((this.r == null) || (this.r.size() == 0)) {
      return;
    }
    this.cb.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((MinsuLlBannerBean)localIterator.next()).getImg());
    }
    int i = (int)(getResources().getDisplayMetrics().widthPixels / 3.75F);
    ((LinearLayout.LayoutParams)this.cb.getLayoutParams()).height = i;
    this.cb.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public MinsuLandLordMainNewActivity.a createHolder()
      {
        return new MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, null);
      }
    }, localArrayList, new ConvenientBanner.b()
    {
      public void configGio(ViewPager paramAnonymousViewPager)
      {
        if ((paramAnonymousViewPager != null) && (paramAnonymousViewPager.getAdapter() != null) && (paramAnonymousViewPager.getAdapter().getCount() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < paramAnonymousViewPager.getAdapter().getCount())
          {
            localArrayList.add("自如友家整租首页轮播图-" + i);
            i += 1;
          }
          GrowingIO.getInstance();
          GrowingIO.trackBanner(paramAnonymousViewPager, localArrayList);
        }
      }
    }).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setCoverBottomViewVisible(true).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        if (MinsuLandLordMainNewActivity.this.tv_emblem_hint.getVisibility() == 0)
        {
          MinsuLandLordMainNewActivity.this.tv_emblem_hint.setVisibility(8);
          return;
        }
        MinsuLlBannerBean localMinsuLlBannerBean = (MinsuLlBannerBean)MinsuLandLordMainNewActivity.e(MinsuLandLordMainNewActivity.this).get(paramAnonymousInt);
        if (localMinsuLlBannerBean.getDescription() != null) {}
        for (String[] arrayOfString = localMinsuLlBannerBean.getDescription().split("&\\|");; arrayOfString = null)
        {
          if ((arrayOfString != null) && (arrayOfString.length == 3))
          {
            MinsuLandLordMainNewActivity localMinsuLandLordMainNewActivity = MinsuLandLordMainNewActivity.a;
            String str1 = arrayOfString[0];
            String str2 = localMinsuLlBannerBean.getTarget();
            if ((arrayOfString[2].contains("allBoolParams")) && (arrayOfString[2].contains("1"))) {}
            for (boolean bool = true;; bool = false)
            {
              JsBridgeWebActivity.start(localMinsuLandLordMainNewActivity, str1, str2, bool, arrayOfString[1], localMinsuLlBannerBean.getImg(), false);
              return;
            }
          }
          JsBridgeWebActivity.start(MinsuLandLordMainNewActivity.a, localMinsuLlBannerBean.getTitle(), localMinsuLlBannerBean.getTarget(), false, localMinsuLlBannerBean.getDescription(), localMinsuLlBannerBean.getImg(), false);
          return;
        }
      }
    }).setPointViewVisible(true);
    this.cb.startTurning(2500L);
  }
  
  private void n()
  {
    this.M = new ArrayList();
    this.M.add("相册选择");
    this.M.add("拍照");
    this.N = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MinsuLandLordMainNewActivity.f(MinsuLandLordMainNewActivity.this).dismiss();
        if (paramAnonymousInt == 1)
        {
          paramAnonymousAdapterView = new Intent("android.media.action.IMAGE_CAPTURE");
          MinsuLandLordMainNewActivity.this.startActivityForResult(paramAnonymousAdapterView, 257);
        }
        while (paramAnonymousInt != 0) {
          return;
        }
        paramAnonymousAdapterView = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        MinsuLandLordMainNewActivity.this.startActivityForResult(paramAnonymousAdapterView, 258);
      }
    }, this.O, this.M);
    com.ziroom.ziroomcustomer.minsu.landlordrelease.view.d locald = this.N;
    View localView = getWindow().getDecorView();
    if (!(locald instanceof PopupWindow))
    {
      locald.showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locald, localView, 80, 0, 0);
  }
  
  private int o()
  {
    if (!EMClient.getInstance().isLoggedInBefore()) {}
    EMConversation localEMConversation;
    do
    {
      return 0;
      localEMConversation = EMClient.getInstance().chatManager().getConversation("ms_ziroom", EMConversation.EMConversationType.Chat, true);
    } while (localEMConversation == null);
    return localEMConversation.getUnreadMsgCount();
  }
  
  private void p()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.setHouseTodayDiscountHint(this, true, new t(this, new r(MinsuLLHouseTodayHintBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuLLHouseTodayHintBean paramAnonymousMinsuLLHouseTodayHintBean)
      {
        if ((paramAnonymousMinsuLLHouseTodayHintBean != null) && (paramAnonymousMinsuLLHouseTodayHintBean.getData() != null)) {
          MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, paramAnonymousMinsuLLHouseTodayHintBean);
        }
      }
    });
  }
  
  private Boolean q()
  {
    boolean bool = com.ziroom.ziroomcustomer.util.ad.getMinsuMainTodayHint(this).booleanValue();
    String str = com.ziroom.ziroomcustomer.util.ad.getMinsuMainTodayHintTime(this);
    if ((TextUtils.isEmpty(str)) && (bool)) {
      return Boolean.valueOf(true);
    }
    if (com.ziroom.ziroomcustomer.util.m.differentDaysByMillisecond(str, com.ziroom.ziroomcustomer.util.m.GetNowDateTime()) > 5) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  private void r()
  {
    this.D = getResources().getDimension(2131230981);
    this.w = ((int)(this.D * 27.0F));
    this.C = ((int)(this.D * 94.0F));
    this.x = ((int)(this.D * 64.0F));
    this.y = ((int)(this.D * 24.0F));
    this.A = ((int)(this.D * 20.0F));
    this.z = ((int)(this.D * 65.0F));
    this.B = getWindowManager().getDefaultDisplay().getWidth();
  }
  
  public void UpLoadData()
  {
    if (this.v != null) {
      this.v.getItem(0).FristLoadData();
    }
  }
  
  public void getCertification()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCertification(this, new com.ziroom.ziroomcustomer.minsu.f.s(this, new r(CertificationBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          g.textToast(MinsuLandLordMainNewActivity.this, "获取认证信息失败，请稍后再试");
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, CertificationBean paramAnonymousCertificationBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousCertificationBean);
        if (!paramAnonymousCertificationBean.checkSuccess(MinsuLandLordMainNewActivity.this))
        {
          g.textToast(MinsuLandLordMainNewActivity.this, "获取认证信息失败，请稍后再试");
          return;
        }
        if ((paramAnonymousCertificationBean != null) && (paramAnonymousCertificationBean.getData() != null))
        {
          if ("1".equals(paramAnonymousCertificationBean.getData().getFullFlag()))
          {
            k.toHouseRelease(MinsuLandLordMainNewActivity.this);
            return;
          }
          Intent localIntent = new Intent(MinsuLandLordMainNewActivity.this, QApersonalActivity.class);
          localIntent.putExtra("isCantactAuth", paramAnonymousCertificationBean.getData().getIsContactAuth());
          localIntent.putExtra("isIdentityAuth", paramAnonymousCertificationBean.getData().getIsIdentityAuth());
          localIntent.putExtra("isFinishHead", paramAnonymousCertificationBean.getData().getIsFinishHead());
          MinsuLandLordMainNewActivity.this.startActivity(localIntent);
          return;
        }
        g.textToast(MinsuLandLordMainNewActivity.this, "获取认证信息失败，请稍后再试");
      }
    });
  }
  
  public void getUnReadMsgCount()
  {
    if (ae.isNull(com.ziroom.ziroomcustomer.minsu.e.d.getUid())) {
      return;
    }
    final int i = com.ziroom.ziroomcustomer.minsu.chat.j.getUnReadMsgSize(1);
    final int j = o();
    com.ziroom.ziroomcustomer.util.u.i("huanxin msgcount", " size = " + i + " customerServiceUnRead = " + j);
    a(this.f, i, j);
    f.getUnreadNum(this, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(com.alibaba.fastjson.e.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        com.freelxl.baselibrary.f.d.d("OKHttp", "Push ZRK getUnreadNum success,detail as below");
        if ((paramAnonymouse != null) && (paramAnonymouse.getInteger("unread").intValue() != MinsuLandLordMainNewActivity.g(MinsuLandLordMainNewActivity.this)))
        {
          MinsuLandLordMainNewActivity.b(MinsuLandLordMainNewActivity.this, paramAnonymouse.getInteger("unread").intValue());
          MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this, MinsuLandLordMainNewActivity.g(MinsuLandLordMainNewActivity.this), i, j);
        }
      }
    }, com.ziroom.ziroomcustomer.service.d.buildGetUnreadNum(this, com.ziroom.ziroomcustomer.service.d.a, h.toMd5(com.ziroom.ziroomcustomer.minsu.e.d.getUid().getBytes()), com.ziroom.ziroomcustomer.service.e.getLastSyncTime(this)));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle != null) {}
        for (paramIntent = com.ziroom.ziroomcustomer.minsu.f.ad.savePic((Bitmap)localBundle.get("data"));; paramIntent = com.ziroom.ziroomcustomer.minsu.f.ad.getRealFilePath2(this, paramIntent.getData()))
        {
          d(paramIntent);
          return;
        }
      } while (paramIntent == null);
      d(com.ziroom.ziroomcustomer.minsu.f.ad.getRealFilePath2(this, paramIntent.getData()));
      return;
      this.v.getItem(1).FristLoadData();
      return;
      this.v.getItem(0).FristLoadData();
      return;
    } while ((paramInt2 != -1) || (TextUtils.isEmpty(b)));
    k.toAppointmentPhotographer(this, b);
  }
  
  public void onCmdMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903297);
    ButterKnife.bind(this);
    k();
    if (ApplicationEx.c.isLoginState()) {
      if (MainActivity.b != null) {
        MainActivity.b.finish();
      }
    }
    for (;;)
    {
      b();
      p();
      h();
      g();
      r();
      a();
      return;
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      startActivityForResult(paramBundle, 121);
    }
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.I);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.c);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.J);
    super.onDestroy();
    a = null;
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
      if (l - this.e > 2000L)
      {
        showToast("再按一次可退出程序");
        this.e = l;
        return true;
      }
      ApplicationEx.c.AppExit(this);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onMessageChanged(EMMessage paramEMMessage, Object paramObject)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
  }
  
  public void onMessageDelivered(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
  }
  
  public void onMessageRead(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
  }
  
  public void onMessageRecalled(List<EMMessage> paramList) {}
  
  public void onMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EMMessage localEMMessage = (EMMessage)paramList.next();
      try
      {
        if ("ZIROOM_MINSU_IM".equals(localEMMessage.getStringAttribute("ziroomFlag"))) {
          ApplicationEx.c.getNotifier().onNewMsg(localEMMessage);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a = this;
    e();
    try
    {
      if (EMClient.getInstance().isLoggedInBefore()) {
        EMClient.getInstance().chatManager().addMessageListener(this);
      }
      getUnReadMsgCount();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        com.ziroom.ziroomcustomer.util.u.e("huanxin", "e = " + localException.getMessage());
      }
    }
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    float f1 = paramInt1 / 100.0F;
    this.bottomLine.setAlpha(Math.abs(f1));
    View localView;
    if (paramInt1 > 0)
    {
      this.swipeRefreshLayout.setNestedScrollingEnabled(false);
      this.swipeRefreshLayout.setEnabled(false);
      d(Math.max(Math.min(this.w, paramInt1), 0));
      c(Math.max(Math.min(this.z, paramInt1), this.w));
      b(Math.max(Math.min(this.C, paramInt1), this.z));
      a(this.flPhoto.getLeft());
      localView = this.bottomLine;
      if (paramInt1 < this.C) {
        break label148;
      }
    }
    label148:
    for (paramInt1 = paramInt2;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      this.swipeRefreshLayout.setNestedScrollingEnabled(true);
      this.swipeRefreshLayout.setEnabled(true);
      break;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      EMClient.getInstance().chatManager().removeMessageListener(this);
      com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        com.ziroom.ziroomcustomer.util.u.e("huanxin", "e = " + localException.getMessage());
      }
    }
  }
  
  @OnClick({2131691475, 2131691473, 2131691479, 2131696889, 2131691481, 2131696352, 2131692018, 2131696878, 2131696879, 2131696880, 2131696881, 2131696882, 2131696883, 2131696884, 2131696885, 2131691474})
  public void onViewClicked(View paramView)
  {
    if (this.tv_emblem_hint.getVisibility() == 0) {
      this.tv_emblem_hint.setVisibility(8);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      switch (paramView.getId())
                      {
                      default: 
                        return;
                      case 2131691474: 
                        k.toMainActivity(this);
                        return;
                      case 2131691475: 
                        getCertification();
                        return;
                      case 2131696889: 
                        k.toLandlordAngelActivity(this);
                        return;
                      }
                    } while (l().booleanValue() == true);
                    n();
                    return;
                    paramView = new Intent();
                    paramView.setClass(this, LoginActivity.class);
                    startActivityForResult(paramView, 121);
                    return;
                    startActivityForResult(new Intent(this, MinsuPersonalDataActivity.class), 289);
                    return;
                  } while (l().booleanValue() == true);
                  startActivity(new Intent(this, MinsuLandlordChartListAvtivity.class));
                  return;
                } while (l().booleanValue() == true);
                startActivity(new Intent(this, MinsuLandlordMyOrderActivity.class));
                return;
              } while (l().booleanValue() == true);
              k.toLLEvaListActivity(this);
              return;
            } while (l().booleanValue() == true);
            startActivity(new Intent(this, MinsuLandlordHouseAvtivity.class));
            return;
          } while (l().booleanValue() == true);
          k.goWeb(this, com.ziroom.ziroomcustomer.minsu.b.d.g + "/personal/43e881/toMyBankAcount");
          return;
        } while (l().booleanValue() == true);
        k.goWeb(this, com.ziroom.ziroomcustomer.minsu.b.d.g + "/profitMgt/43e881/profit");
        return;
      } while (l().booleanValue() == true);
      paramView = new Intent(this, MinsuWebActivity.class);
      paramView.putExtra("isShowShare", false);
      paramView.putExtra("url", com.ziroom.ziroomcustomer.minsu.b.d.j + "/zhuanti/minsu/zhinan/?sourceType=1");
      paramView.putExtra("isLoadTitle", false);
      startActivity(paramView);
      return;
    } while (l().booleanValue() == true);
    paramView = new Intent(this, MinsuLandlordMoreActivity.class);
    paramView.putExtra("authCode", this.s);
    paramView.putExtra("phone", this.t);
    startActivity(paramView);
  }
  
  public void setIndicator(Context paramContext, TabLayout paramTabLayout, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramTabLayout.getClass();
    try
    {
      localObject1 = ((Class)localObject1).getDeclaredField("mTabStrip");
      ((Field)localObject1).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        paramTabLayout = (LinearLayout)((Field)localObject1).get(paramTabLayout);
        localObject1 = new DisplayMetrics();
        ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        int i = (int)(((DisplayMetrics)localObject1).density * paramInt1);
        paramInt2 = (int)(((DisplayMetrics)localObject1).density * paramInt2);
        paramInt1 = 0;
        while (paramInt1 < paramTabLayout.getChildCount())
        {
          paramContext = paramTabLayout.getChildAt(paramInt1);
          paramContext.setPadding(0, 0, 0, 0);
          localObject1 = new LinearLayout.LayoutParams(0, -1, 1.0F);
          ((LinearLayout.LayoutParams)localObject1).leftMargin = i;
          ((LinearLayout.LayoutParams)localObject1).rightMargin = paramInt2;
          paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramContext.invalidate();
          paramInt1 += 1;
          continue;
          localNoSuchFieldException = localNoSuchFieldException;
          localNoSuchFieldException.printStackTrace();
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException paramTabLayout)
      {
        for (;;)
        {
          paramTabLayout.printStackTrace();
          paramTabLayout = null;
        }
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
      this.b.setController(com.freelxl.baselibrary.f.c.frescoController(paramContext));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    public b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this) != null) {
        MinsuLandLordMainNewActivity.a(MinsuLandLordMainNewActivity.this).getItem(1).FristLoadData();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandLordMainNewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */