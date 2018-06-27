package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.b.r;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.dialog.b.a;
import com.ziroom.ziroomcustomer.bestgoods.dialog.c.a;
import com.ziroom.ziroomcustomer.bestgoods.dialog.e;
import com.ziroom.ziroomcustomer.bestgoods.fragment.GoodsDetailFr;
import com.ziroom.ziroomcustomer.bestgoods.fragment.GoodsEvalFr;
import com.ziroom.ziroomcustomer.bestgoods.fragment.GoodsEvalFr.b;
import com.ziroom.ziroomcustomer.bestgoods.fragment.GoodsSpecificationFr;
import com.ziroom.ziroomcustomer.bestgoods.fragment.GoodsSpecificationFr.a;
import com.ziroom.ziroomcustomer.bestgoods.model.ay;
import com.ziroom.ziroomcustomer.bestgoods.model.f;
import com.ziroom.ziroomcustomer.bestgoods.model.i.a;
import com.ziroom.ziroomcustomer.bestgoods.model.i.b;
import com.ziroom.ziroomcustomer.bestgoods.model.i.d;
import com.ziroom.ziroomcustomer.bestgoods.model.i.d.a;
import com.ziroom.ziroomcustomer.bestgoods.model.s;
import com.ziroom.ziroomcustomer.bestgoods.widget.ScrollGridLayoutManager;
import com.ziroom.ziroomcustomer.bestgoods.widget.WrapContentHeightViewPager;
import com.ziroom.ziroomcustomer.home.ScanPhotoActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.BadgeView;
import com.ziroom.ziroomcustomer.widget.HouseListXListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsDetailAc
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, GoodsEvalFr.b, GoodsSpecificationFr.a, ObservableScrollView.a
{
  private ObservableScrollView A;
  private ConvenientBanner B;
  private TextView C;
  private TextView D;
  private TextView E;
  private RelativeLayout F;
  private RelativeLayout G;
  private TextView H;
  private TextView I;
  private RelativeLayout J;
  private RelativeLayout K;
  private SimpleDraweeView L;
  private LinearLayout M;
  private TextView N;
  private TextView O;
  private TextView P;
  private View Q;
  private WrapContentHeightViewPager R;
  private FragmentStatePagerAdapter S;
  private List<Fragment> T = new ArrayList();
  private GoodsDetailFr U;
  private GoodsSpecificationFr V;
  private RecyclerView W;
  private GoodsEvalFr X;
  private LinearLayout Y;
  private LinearLayout Z;
  private Context a;
  private TextView aA;
  private MyGridView aB;
  private RelativeLayout aC;
  private e aD;
  private RelativeLayout aE;
  private TextView aF;
  private TextView aG;
  private TextView aH;
  private FlowLayout aI;
  private FlowLayout aJ;
  private List<ay> aK = new ArrayList();
  private List<String> aL = new ArrayList();
  private List<String> aM = new ArrayList();
  private String aN;
  private UserInfo aO;
  private String aP;
  private String aQ;
  private boolean aR;
  private boolean aS;
  private PlatformActionListener aT = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
    {
      com.ziroom.commonlib.utils.l.d("#########分享取消回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享取消");
    }
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      GoodsDetailAc.this.showToast("分享成功");
      com.ziroom.commonlib.utils.l.d("#########分享完成回调: 平台  ", "=====" + paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功====" + getClass().getSimpleName());
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      GoodsDetailAc.this.showToast("分享失败");
      com.ziroom.commonlib.utils.l.d("#########分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败====" + getClass().getSimpleName());
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  private LinearLayout aa;
  private BadgeView ab;
  private TextView ac;
  private TextView ad;
  private com.ziroom.ziroomcustomer.bestgoods.dialog.a ae;
  private String af;
  private String ag;
  private int ah;
  private int ai;
  private int aj;
  private int ak;
  private int al;
  private int am;
  private int an;
  private com.ziroom.ziroomcustomer.bestgoods.model.i ao;
  private List<String> ap = new ArrayList();
  private List<f> aq;
  private com.ziroom.ziroomcustomer.bestgoods.model.j ar;
  private int as = 0;
  private float at = -1.0F;
  private float au = -1.0F;
  private RelativeLayout av;
  private RelativeLayout aw;
  private TextView ax;
  private TextView ay;
  private TextView az;
  private Intent b;
  private com.ziroom.ziroomcustomer.bestgoods.c.a c;
  private LinearLayout d;
  private TextView e;
  private ImageView f;
  private ImageView g;
  private View r;
  private int s;
  private LinearLayout t;
  private TextView u;
  private TextView v;
  private TextView w;
  private View x;
  private ImageView y;
  private LinearLayout z;
  
  private void a()
  {
    View localView = findViewById(2131689541);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.ah = ac.getScreenWidth(this);
    this.z = ((LinearLayout)findViewById(2131689998));
    this.d = ((LinearLayout)findViewById(2131691583));
    this.f = ((ImageView)findViewById(2131689492));
    this.e = ((TextView)findViewById(2131689541));
    this.e.setText("商品详情");
    this.e.setPadding(0, 0, 0, 0);
    this.g = ((ImageView)findViewById(2131690673));
    this.r = findViewById(2131696034);
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        GoodsDetailAc.a(GoodsDetailAc.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = ac.getScreenHeight(GoodsDetailAc.b(GoodsDetailAc.this));
        int j = ac.getStatusHeight(GoodsDetailAc.b(GoodsDetailAc.this));
        GoodsDetailAc.a(GoodsDetailAc.this, GoodsDetailAc.a(GoodsDetailAc.this).getHeight());
        Log.e("TAG_tree", "" + GoodsDetailAc.c(GoodsDetailAc.this));
        GoodsDetailAc.b(GoodsDetailAc.this, GoodsDetailAc.d(GoodsDetailAc.this).getHeight());
        int k = GoodsDetailAc.e(GoodsDetailAc.this).getHeight();
        GoodsDetailAc.c(GoodsDetailAc.this, i - GoodsDetailAc.f(GoodsDetailAc.this) - GoodsDetailAc.c(GoodsDetailAc.this) - j - k);
      }
    });
    this.y = ((ImageView)findViewById(2131690708));
    this.y.setTag("humanControlled");
    this.A = ((ObservableScrollView)findViewById(2131689506));
    this.B = ((ConvenientBanner)findViewById(2131690264));
    this.F = ((RelativeLayout)findViewById(2131690369));
    this.aJ = ((FlowLayout)findViewById(2131690725));
    this.L = ((SimpleDraweeView)findViewById(2131690027));
    this.L.setLayoutParams(new LinearLayout.LayoutParams(this.ah, Integer.parseInt(new DecimalFormat("0").format(this.ah / 2.28D))));
    this.x = findViewById(2131690713);
    this.Q = findViewById(2131690707);
    e();
    this.M = ((LinearLayout)findViewById(2131690702));
    this.M.setTag("humanControlled");
    this.N = ((TextView)findViewById(2131690704));
    this.O = ((TextView)findViewById(2131690705));
    this.P = ((TextView)findViewById(2131690706));
    this.t = ((LinearLayout)findViewById(2131690689));
    this.u = ((TextView)findViewById(2131690710));
    this.v = ((TextView)findViewById(2131690711));
    this.w = ((TextView)findViewById(2131690712));
    this.R = ((WrapContentHeightViewPager)findViewById(2131690690));
    this.R.setOffscreenPageLimit(2);
    this.G = ((RelativeLayout)findViewById(2131690726));
    this.H = ((TextView)findViewById(2131690727));
    this.H.setText("已选择");
    this.I = ((TextView)findViewById(2131690729));
    this.J = ((RelativeLayout)findViewById(2131690730));
    this.K = ((RelativeLayout)findViewById(2131690734));
    this.Y = ((LinearLayout)findViewById(2131690692));
    this.Z = ((LinearLayout)findViewById(2131690693));
    this.aa = ((LinearLayout)findViewById(2131690696));
    this.ab = new BadgeView(this.a, this.aa, n.dip2px(this.a, 6.0F), 0);
    this.ab.setBadgeMargin(n.dip2px(this.a, 21.0F), n.dip2px(this.a, 6.0F));
    this.ab.setBadgeBackgroundColor(Color.parseColor("#FE3824"));
    this.ab.setSingleLine(true);
    this.ab.setGravity(17);
    this.ab.setTextSize(10.0F);
    this.ac = ((TextView)findViewById(2131690699));
    this.ad = ((TextView)findViewById(2131690700));
    this.av = ((RelativeLayout)findViewById(2131690738));
    this.aw = ((RelativeLayout)findViewById(2131690740));
    this.ax = ((TextView)findViewById(2131690741));
    this.ay = ((TextView)findViewById(2131690743));
    this.aA = ((TextView)findViewById(2131690744));
    this.aB = ((MyGridView)findViewById(2131690745));
    this.aC = ((RelativeLayout)findViewById(2131690714));
    this.aC.setLayoutParams(new LinearLayout.LayoutParams(this.ah, this.ah));
    this.aE = ((RelativeLayout)findViewById(2131690715));
    this.aF = ((TextView)findViewById(2131689912));
    this.aH = ((TextView)findViewById(2131690718));
    this.aG = ((TextView)findViewById(2131690717));
    this.C = ((TextView)findViewById(2131690720));
    this.D = ((TextView)findViewById(2131689991));
    this.E = ((TextView)findViewById(2131690722));
    this.aI = ((FlowLayout)findViewById(2131690723));
    this.az = ((TextView)findViewById(2131690721));
  }
  
  private void a(int paramInt, com.ziroom.ziroomcustomer.bestgoods.model.j paramj)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.ao != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.ao.getSkuImgUrl())) {
        localObject1 = this.ao.getSkuImgUrl();
      }
    }
    u.d("sjdglkdgfgs", "========传进来的数据   skuCode==  " + this.ag);
    localObject2 = new HashMap();
    ((Map)localObject2).put("categoryCode", this.ao.getCategoryCode());
    ((Map)localObject2).put("productCode", this.af);
    ((Map)localObject2).put("skuCode", this.ag);
    ((Map)localObject2).put("picUrl", localObject1);
    ((Map)localObject2).put("skuName", this.ao.getSkuName());
    if (this.ao.getActivityType() == null) {
      ((Map)localObject2).put("price", this.ao.getPrice());
    }
    for (;;)
    {
      ((Map)localObject2).put("btnState", Integer.valueOf(paramInt));
      ((Map)localObject2).put("specificationName", this.ao.getSpecificationName());
      ((Map)localObject2).put("specificationCode", this.ao.getSpecificationCode());
      ((Map)localObject2).put("providerName", this.ao.getProviderName());
      ((Map)localObject2).put("providerCode", this.ao.getProviderCode());
      ((Map)localObject2).put("productName", this.ao.getProductName());
      ((Map)localObject2).put("activityPrice", this.ao.getActivityPrice());
      paramj = new com.ziroom.ziroomcustomer.bestgoods.dialog.c(this, paramj, (Map)localObject2);
      paramj.show();
      paramj.setOnFlLikeItemClickListener(new c.a()
      {
        public void addGoods(int paramAnonymousInt)
        {
          GoodsDetailAc.d(GoodsDetailAc.this, GoodsDetailAc.l(GoodsDetailAc.this) + paramAnonymousInt);
          if (!GoodsDetailAc.m(GoodsDetailAc.this).isShown()) {
            GoodsDetailAc.m(GoodsDetailAc.this).show();
          }
        }
        
        public void upDateUi(String paramAnonymousString1, String paramAnonymousString2)
        {
          if (!TextUtils.isEmpty(paramAnonymousString1))
          {
            GoodsDetailAc.a(GoodsDetailAc.this, paramAnonymousString1);
            GoodsDetailAc.k(GoodsDetailAc.this);
          }
        }
      });
      return;
      ((Map)localObject2).put("price", this.ao.getActivityPrice());
    }
  }
  
  private void a(b paramb, float paramFloat)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.x.getLayoutParams();
    if (paramb == b.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * this.ai + this.as * this.ai) + this.ak);
    }
    for (;;)
    {
      this.x.setLayoutParams(localLayoutParams);
      this.Q.setLayoutParams(localLayoutParams);
      return;
      if (paramb == b.b) {
        localLayoutParams.leftMargin = ((int)(this.ai * paramFloat + this.as * this.ai) + this.ak);
      }
    }
  }
  
  private void a(final com.ziroom.ziroomcustomer.bestgoods.model.i parami)
  {
    b(parami);
    parami = parami.getBanner();
    if ((parami != null) && (parami.size() > 0))
    {
      String str = ((i.a)parami.get(0)).getImgUrl();
      if (!TextUtils.isEmpty(str))
      {
        this.L.setController(com.freelxl.baselibrary.f.c.frescoController(str));
        this.L.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(GoodsDetailAc.b(GoodsDetailAc.this), GoodsDetailAc.class);
            paramAnonymousView.putExtra("productCode", ((i.a)parami.get(0)).getProductCode());
            paramAnonymousView.putExtra("skuCode", ((i.a)parami.get(0)).getSKUCode());
            GoodsDetailAc.this.startActivity(paramAnonymousView);
          }
        });
        return;
      }
      this.L.setVisibility(8);
      return;
    }
    this.L.setVisibility(8);
  }
  
  private void a(final List<f> paramList)
  {
    paramList = new com.ziroom.ziroomcustomer.bestgoods.dialog.b(this, paramList);
    paramList.setLoginStateListener(new b.a()
    {
      public void resetCouponData(boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          GoodsDetailAc.a(GoodsDetailAc.this, null);
          paramList.dismiss();
        }
      }
    });
    paramList.show();
  }
  
  private void b()
  {
    this.b = getIntent();
    this.aR = this.b.getBooleanExtra("isGoodsListActivity", false);
    this.aQ = this.b.getStringExtra("typeCode");
    this.aS = this.b.getBooleanExtra("isShowSafeCheck", false);
    this.af = this.b.getStringExtra("productCode");
    this.ag = this.b.getStringExtra("skuCode");
    if (com.ziroom.ziroomcustomer.base.b.d != null) {
      GrowingIO.getInstance().setPS3(this, com.ziroom.ziroomcustomer.base.b.d);
    }
    if (ae.notNull(this.ag)) {
      GrowingIO.getInstance().setPS1(this, this.ag);
    }
    h();
  }
  
  private void b(int paramInt)
  {
    if (checkNet(this.a))
    {
      showProgressNoCancel("", 30000L);
      HashMap localHashMap = new HashMap();
      localHashMap.put("productCode", this.af);
      localHashMap.put("skuCode", this.ag);
      com.ziroom.ziroomcustomer.e.j.getGoodsPropertyV2(this, localHashMap, new d(new com.ziroom.ziroomcustomer.newrepair.utils.b(com.ziroom.ziroomcustomer.bestgoods.model.j.class), paramInt));
      return;
    }
    g.textToast(this.a, "请保证网络畅通");
  }
  
  private void b(com.ziroom.ziroomcustomer.bestgoods.model.i parami)
  {
    parami = parami.getCarouselFigures();
    if (parami != null)
    {
      this.ap = new ArrayList();
      int i = 0;
      while (i < parami.size())
      {
        this.ap.add(((i.b)parami.get(i)).getCarouselFigureUrl());
        i += 1;
      }
    }
    this.B.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public com.ziroom.ziroomcustomer.newServiceList.view.c createHolder()
      {
        return new com.ziroom.ziroomcustomer.newServiceList.view.c();
      }
    }, this.ap).setPageIndicator(new int[] { 2130839324, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        if (GoodsDetailAc.g(GoodsDetailAc.this).size() > paramAnonymousInt)
        {
          ArrayList localArrayList = new ArrayList();
          Intent localIntent = new Intent(GoodsDetailAc.b(GoodsDetailAc.this), ScanPhotoActivity.class);
          Bundle localBundle = new Bundle();
          localArrayList.addAll(GoodsDetailAc.g(GoodsDetailAc.this));
          localBundle.putSerializable("photos", localArrayList);
          localIntent.putExtra("position", paramAnonymousInt);
          localIntent.putExtra("mHouse_type", 1);
          localIntent.putExtras(localBundle);
          GoodsDetailAc.this.startActivity(localIntent);
        }
      }
    }).setPointViewVisible(true);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0)
    {
      this.u.setTextColor(getResources().getColor(2131624039));
      this.w.setTextColor(getResources().getColor(2131624042));
      this.v.setTextColor(getResources().getColor(2131624042));
      this.N.setTextColor(getResources().getColor(2131624039));
      this.P.setTextColor(getResources().getColor(2131624042));
      this.O.setTextColor(getResources().getColor(2131624042));
      return;
    }
    if (paramInt == 2)
    {
      this.w.setTextColor(getResources().getColor(2131624039));
      this.u.setTextColor(getResources().getColor(2131624042));
      this.v.setTextColor(getResources().getColor(2131624042));
      this.P.setTextColor(getResources().getColor(2131624039));
      this.N.setTextColor(getResources().getColor(2131624042));
      this.O.setTextColor(getResources().getColor(2131624042));
      return;
    }
    this.v.setTextColor(getResources().getColor(2131624039));
    this.u.setTextColor(getResources().getColor(2131624042));
    this.w.setTextColor(getResources().getColor(2131624042));
    this.O.setTextColor(getResources().getColor(2131624039));
    this.N.setTextColor(getResources().getColor(2131624042));
    this.P.setTextColor(getResources().getColor(2131624042));
  }
  
  private void e()
  {
    this.ai = (this.ah / 3);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.x.getLayoutParams();
    this.ak = ((this.ai - n.dip2px(this.a, 35.0F)) / 2);
    localLayoutParams.leftMargin = (this.ak * 1);
    this.x.setLayoutParams(localLayoutParams);
    this.Q.setLayoutParams(localLayoutParams);
  }
  
  private void f()
  {
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.R.addOnPageChangeListener(this);
    this.F.setOnClickListener(this);
    this.A.setOnScrollChangedCallback(this);
    this.Z.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.ad.setOnClickListener(this);
    this.av.setOnClickListener(this);
    this.aA.setOnClickListener(this);
  }
  
  private void g()
  {
    new e(this.a, this.af).show();
  }
  
  private void h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", this.af);
    localHashMap.put("skuCode", this.ag);
    if (checkNet(this.a))
    {
      showProgress("");
      com.ziroom.ziroomcustomer.e.j.getGoodsDetailData(this, localHashMap, new c(new com.ziroom.ziroomcustomer.newrepair.utils.b(com.ziroom.ziroomcustomer.bestgoods.model.i.class)));
      return;
    }
    g.textToast(this.a, "请保证网络畅通");
    i();
  }
  
  private void i()
  {
    View localView = showEmptyView(this.z, "连接失败，请稍后再试");
    this.y.setVisibility(8);
    this.g.setVisibility(8);
    localView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        GoodsDetailAc.k(GoodsDetailAc.this);
      }
    });
  }
  
  private void j()
  {
    this.y.setVisibility(0);
    this.g.setVisibility(0);
    this.C.setText(this.ao.getSkuName());
    if (!TextUtils.isEmpty(this.ao.getBriefIntroductions()))
    {
      this.E.setVisibility(0);
      this.E.setText(this.ao.getBriefIntroductions());
      this.I.setText(this.ao.getStyleName() + this.ao.getSpecificationName());
      this.U = GoodsDetailFr.newInstance(this.ao.getGoodDetail(), (ArrayList)this.ao.getQualityInspection(), this.aS);
      this.X = GoodsEvalFr.newInstance(this.af, this.am);
      this.X.setOnInitViewListener(this);
      this.V = GoodsSpecificationFr.newInstance((ArrayList)this.ao.getSpecificationParam(), this.am);
      this.V.setOnInitViewListener(this);
      this.T.clear();
      this.T.add(this.U);
      this.T.add(this.V);
      this.T.add(this.X);
      GrowingIO.getInstance().ignoreFragment(this, this.U);
      this.S = new FragmentStatePagerAdapter(getSupportFragmentManager())
      {
        public int getCount()
        {
          return GoodsDetailAc.r(GoodsDetailAc.this).size();
        }
        
        public Fragment getItem(int paramAnonymousInt)
        {
          return (Fragment)GoodsDetailAc.r(GoodsDetailAc.this).get(paramAnonymousInt);
        }
      };
      this.R.setAdapter(this.S);
      this.R.setCurrentItem(0);
      c(0);
      if (this.ao.getActivityType() == null) {
        break label672;
      }
      this.aE.setVisibility(0);
      if (this.ao.getActivityType().intValue() != 1) {
        break label581;
      }
      this.aE.setBackgroundColor(-214229);
      if (this.ao.getTimeSub() != null)
      {
        this.aD = new e(this.ao.getTimeSub().longValue(), 1000L);
        this.aD.start();
      }
      label370:
      this.aG.setText(this.ao.getActivityTypeText());
      this.aF.setText(this.ao.getActivityPrice() + "");
      this.D.setText(String.format("%.2f", new Object[] { this.ao.getPrice() }));
      this.D.getPaint().setFlags(16);
      this.D.setTextColor(Color.parseColor("#CCCCCC"));
      this.az.setTextColor(Color.parseColor("#CCCCCC"));
    }
    Object localObject1;
    int i;
    Object localObject2;
    for (;;)
    {
      this.aL.clear();
      if ((this.ao.getProductTag() == null) || (this.ao.getProductTag().length <= 0)) {
        break label1182;
      }
      this.aI.setVisibility(0);
      this.aI.removeAllViews();
      localObject1 = this.ao.getProductTag();
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.aL.add(localObject2);
        i += 1;
      }
      this.E.setVisibility(8);
      break;
      label581:
      if (this.aD != null) {
        this.aD.cancel();
      }
      this.aE.setBackgroundColor(-4611232);
      if (this.ao.getActivityEnd() == null) {
        break label370;
      }
      localObject1 = com.ziroom.ziroomcustomer.newServiceList.utils.i.getMin2Data(this.ao.getActivityEnd().longValue());
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label370;
      }
      localObject1 = ((String)localObject1).substring(5);
      this.aH.setText("截止日期 " + (String)localObject1);
      break label370;
      label672:
      this.aE.setVisibility(8);
      this.D.setText(String.format("%.2f", new Object[] { this.ao.getPrice() }));
      this.D.getPaint().setFlags(0);
      this.D.setTextColor(Color.parseColor("#444444"));
      this.az.setTextColor(Color.parseColor("#444444"));
    }
    com.ziroom.ziroomcustomer.bestgoods.c.d.setFlowLayoutData(this.a, this.aL, this.aI);
    this.aM.clear();
    if ((this.ao.getProductSerTypeList() != null) && (this.ao.getProductSerTypeList().size() > 0))
    {
      this.F.setVisibility(0);
      this.aJ.setVisibility(0);
      this.aJ.removeAllViews();
      com.ziroom.ziroomcustomer.bestgoods.c.d.setFlPromise(this.a, this.ao.getProductSerTypeList(), this.aJ);
    }
    for (;;)
    {
      label838:
      if ((this.ao.getSkuListEntityList() != null) && (this.ao.getSkuListEntityList().size() > 0))
      {
        this.aK.clear();
        this.av.setVisibility(0);
        this.aw.setVisibility(0);
        this.aP = ((i.d)this.ao.getSkuListEntityList().get(0)).getGroupName();
        this.ax.setText(this.aP);
        localObject1 = ((i.d)this.ao.getSkuListEntityList().get(0)).getGroupPrice();
        localObject2 = new DecimalFormat("0.00");
        this.ay.setText(((DecimalFormat)localObject2).format(localObject1) + "");
        i = 0;
        for (;;)
        {
          if (i < ((i.d)this.ao.getSkuListEntityList().get(0)).getGroupDetail().size())
          {
            localObject1 = new ay();
            ((ay)localObject1).setPicUrl(((i.d.a)((i.d)this.ao.getSkuListEntityList().get(0)).getGroupDetail().get(i)).getSkuImg());
            ((ay)localObject1).setTitle(((i.d.a)((i.d)this.ao.getSkuListEntityList().get(0)).getGroupDetail().get(i)).getSkuName());
            ((ay)localObject1).setPrice(((i.d.a)((i.d)this.ao.getSkuListEntityList().get(0)).getGroupDetail().get(i)).getPrice());
            ((ay)localObject1).setAmount(((i.d.a)((i.d)this.ao.getSkuListEntityList().get(0)).getGroupDetail().get(i)).getAmount());
            this.aK.add(localObject1);
            i += 1;
            continue;
            label1182:
            this.aI.setVisibility(8);
            break;
            this.F.setVisibility(8);
            this.aJ.setVisibility(8);
            break label838;
          }
        }
        this.aB.setAdapter(new com.ziroom.ziroomcustomer.bestgoods.a.aa(this.a, this.aK));
        this.aN = ((i.d)this.ao.getSkuListEntityList().get(0)).getGroupCode();
        return;
      }
    }
    this.av.setVisibility(8);
    this.aw.setVisibility(8);
  }
  
  private void k()
  {
    if (checkNet(this.a))
    {
      showProgressNoCancel("", 30000L);
      HashMap localHashMap = new HashMap();
      localHashMap.put("productCode", this.af);
      com.ziroom.ziroomcustomer.e.j.getGoodsCoupon(this, localHashMap, new a(new com.ziroom.ziroomcustomer.newrepair.utils.a(f.class, false, "list")));
      return;
    }
    g.textToast(this.a, "请保证网络畅通");
  }
  
  public void getScrollView(final RecyclerView paramRecyclerView)
  {
    this.W = paramRecyclerView;
    paramRecyclerView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (GoodsDetailAc.h(GoodsDetailAc.this) == -1.0F) {
          GoodsDetailAc.a(GoodsDetailAc.this, paramAnonymousMotionEvent.getRawY());
        }
        switch (paramAnonymousMotionEvent.getAction())
        {
        default: 
          Log.e("TAG_default", paramAnonymousMotionEvent.getY() + "");
          return false;
        case 0: 
          GoodsDetailAc.a(GoodsDetailAc.this, paramAnonymousMotionEvent.getRawY());
          Log.e("TAG_DOWN", GoodsDetailAc.h(GoodsDetailAc.this) + "");
          return false;
        case 2: 
          float f = paramAnonymousMotionEvent.getRawY() - GoodsDetailAc.h(GoodsDetailAc.this);
          GoodsDetailAc.a(GoodsDetailAc.this, paramAnonymousMotionEvent.getRawY());
          int i = ((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
          Log.e("TAG_GVF", "" + i);
          int j = GoodsDetailAc.i(GoodsDetailAc.this).getVisibility();
          if ((i == 0) && (f > 0.0F))
          {
            Log.e("TAG_TOUCH", "fp = 0,向下滑");
            ((ScrollGridLayoutManager)paramRecyclerView.getLayoutManager()).setScrollEnabled(false);
            paramRecyclerView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            Log.e("TAG_MOVE", paramAnonymousMotionEvent.getY() + "");
            return false;
            if ((i == 0) && (f < 0.0F) && (j == 8))
            {
              Log.e("TAG_TOUCH", "fp = 0,向上滑，顶部隐藏");
              ((ScrollGridLayoutManager)paramRecyclerView.getLayoutManager()).setScrollEnabled(false);
              paramRecyclerView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            else if (((i >= 0) && (f < 0.0F)) || (j == 0))
            {
              Log.e("TAG_TOUCH", "fp >= 0,向上滑||顶部显示");
              ((ScrollGridLayoutManager)paramRecyclerView.getLayoutManager()).setScrollEnabled(true);
              paramRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
            }
          }
        case 1: 
          Log.e("TAG_UP", paramAnonymousMotionEvent.getY() + "");
          return false;
        }
        Log.e("TAG_CANCEL", paramAnonymousMotionEvent.getY() + "");
        return false;
      }
    });
  }
  
  public void getScrollView(final HouseListXListView paramHouseListXListView)
  {
    paramHouseListXListView.setClickable(true);
    paramHouseListXListView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (GoodsDetailAc.j(GoodsDetailAc.this) == -1.0F) {
          GoodsDetailAc.b(GoodsDetailAc.this, paramAnonymousMotionEvent.getRawY());
        }
        float f;
        int i;
        int j;
        switch (paramAnonymousMotionEvent.getAction())
        {
        default: 
          Log.e("TAG_default", paramAnonymousMotionEvent.getY() + "");
          return false;
        case 0: 
          GoodsDetailAc.b(GoodsDetailAc.this, paramAnonymousMotionEvent.getRawY());
          Log.e("TAG_DOWN", GoodsDetailAc.j(GoodsDetailAc.this) + "");
          f = paramAnonymousMotionEvent.getRawY() - GoodsDetailAc.j(GoodsDetailAc.this);
          GoodsDetailAc.b(GoodsDetailAc.this, paramAnonymousMotionEvent.getRawY());
          i = paramHouseListXListView.getFirstVisiblePosition();
          j = GoodsDetailAc.i(GoodsDetailAc.this).getVisibility();
          if ((i == 0) && (f > 0.0F))
          {
            Log.e("TAG_TOUCH", "fp = 0,向下滑");
            paramHouseListXListView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            Log.e("TAG_DOWN", paramAnonymousMotionEvent.getY() + "");
            return false;
            if ((i == 0) && (f < 0.0F) && (j == 8))
            {
              Log.e("TAG_TOUCH", "fp = 0,向上滑，顶部隐藏");
              paramHouseListXListView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            else if (((i >= 0) && (f < 0.0F)) || (j == 0))
            {
              Log.e("TAG_TOUCH", "fp >= 0,向上滑||顶部显示");
              paramHouseListXListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
          }
        case 2: 
          f = paramAnonymousMotionEvent.getRawY() - GoodsDetailAc.j(GoodsDetailAc.this);
          GoodsDetailAc.b(GoodsDetailAc.this, paramAnonymousMotionEvent.getRawY());
          i = paramHouseListXListView.getFirstVisiblePosition();
          j = GoodsDetailAc.i(GoodsDetailAc.this).getVisibility();
          if ((i == 0) && (f > 0.0F))
          {
            Log.e("TAG_TOUCH", "fp = 0,向下滑");
            paramHouseListXListView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            Log.e("TAG_MOVE", paramAnonymousMotionEvent.getY() + "");
            return false;
            if ((i == 0) && (f < 0.0F) && (j == 8))
            {
              Log.e("TAG_TOUCH", "fp = 0,向上滑，顶部隐藏");
              paramHouseListXListView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            else if (((i >= 0) && (f < 0.0F)) || (j == 0))
            {
              Log.e("TAG_TOUCH", "fp >= 0,向上滑||顶部显示");
              paramHouseListXListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
          }
        case 1: 
          Log.e("TAG_UP", paramAnonymousMotionEvent.getY() + "");
          return false;
        }
        Log.e("TAG_CANCEL", paramAnonymousMotionEvent.getY() + "");
        return false;
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.aO = ApplicationEx.c.getUser();
    switch (paramView.getId())
    {
    default: 
    case 2131689492: 
    case 2131690708: 
    case 2131690673: 
    case 2131690369: 
    case 2131690704: 
    case 2131690710: 
    case 2131690706: 
    case 2131690712: 
    case 2131690705: 
    case 2131690711: 
    case 2131690699: 
    case 2131690693: 
    case 2131690696: 
    case 2131690700: 
    case 2131690726: 
    case 2131690734: 
      do
      {
        return;
        if (this.aR)
        {
          paramView = new Intent(this.a, YouPinGoodsListActivity.class);
          paramView.putExtra("typeCode", this.aQ);
          startActivityAndFinish(paramView);
          return;
        }
        finish();
        return;
        this.A.smoothScrollTo(0, 0);
        return;
        showShare();
        return;
        g();
        return;
        c(0);
        this.R.setCurrentItem(0, false);
        return;
        c(2);
        this.R.setCurrentItem(2, false);
        return;
        c(1);
        this.R.setCurrentItem(1, false);
        return;
        if (this.aO == null)
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
          return;
        }
        if (this.ar != null)
        {
          if (this.ae == null)
          {
            a(1, this.ar);
            return;
          }
          this.ae.setData(null, 1);
          this.ae.show();
          return;
        }
        b(1);
        return;
        startActivity(new Intent(this, ChatWebViewActivity.class));
        return;
        if (this.aO == null)
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
          return;
        }
        paramView = new Intent(this.a, YouPinShoppingCartActivity.class);
        paramView.putExtra("cityCode", com.ziroom.ziroomcustomer.minsu.f.aa.getString(this.a, "currentYouPinCityCode", "000000"));
        startActivity(paramView);
        return;
        if (this.aO == null)
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
          return;
        }
        if (this.ar != null)
        {
          if (this.ae == null)
          {
            a(2, this.ar);
            return;
          }
          this.ae.setData(null, 2);
          this.ae.show();
          return;
        }
        b(2);
        return;
        if (this.ar != null)
        {
          if (this.ae == null)
          {
            a(0, this.ar);
            return;
          }
          this.ae.setData(null, 0);
          this.ae.show();
          return;
        }
        b(0);
        return;
      } while (this.ao == null);
      paramView = this.ao.getDeliveryArea();
      if (TextUtils.isEmpty(paramView))
      {
        g.textToast(this.a, "暂无配送区域");
        return;
      }
      JsBridgeWebActivity.start(this.a, "配送区域", paramView, false, "", "", false);
      return;
    case 2131690730: 
      if ((this.aq != null) && (this.aq.size() > 0))
      {
        a(this.aq);
        return;
      }
      if ((this.aq == null) || (this.aq.size() == 0))
      {
        k();
        return;
      }
      g.textToast(this.a, "暂无可领优惠券");
      return;
    case 2131690738: 
      paramView = new Intent(this.a, YouPinGroupListActivity_New.class);
      paramView.putExtra("groupCode", this.aN);
      paramView.putExtra("productCode", this.af);
      paramView.putExtra("groupName", this.aP);
      startActivity(paramView);
      return;
    }
    if (this.aO == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    new com.ziroom.ziroomcustomer.bestgoods.dialog.d(this.a, this.aN, this.aP).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903193);
    this.a = this;
    MobSDK.init(this.a);
    this.c = com.ziroom.ziroomcustomer.bestgoods.c.a.getAppManager();
    this.c.addReservePageCount(GoodsDetailAc.class.getName(), 5);
    this.c.addActivity(this);
    GrowingIO.getInstance().setPageGroup(this, "GoodsDetail");
    a();
    f();
    b();
  }
  
  protected void onDestroy()
  {
    this.c.removeAc(this);
    this.c = null;
    if (this.aD != null) {
      this.aD.cancel();
    }
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.aR)
      {
        paramKeyEvent = new Intent(this.a, YouPinGoodsListActivity.class);
        paramKeyEvent.putExtra("typeCode", this.aQ);
        startActivityAndFinish(paramKeyEvent);
      }
      for (;;)
      {
        return true;
        finish();
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.as == paramInt1)
    {
      a(b.b, paramFloat);
      return;
    }
    a(b.a, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.R.resetHeight(paramInt);
    this.as = paramInt;
    c(paramInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.an = r.getShoppingNum(this.a, com.ziroom.ziroomcustomer.base.b.d);
    if (this.an != 0)
    {
      this.ab.setText("" + this.an);
      this.ab.show();
      return;
    }
    this.ab.hide();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / 500.0F;
    this.d.setAlpha(f1);
    int i;
    if (f1 > 0.75D)
    {
      this.g.setImageResource(2130840338);
      this.f.setImageResource(2130840141);
      this.r.setVisibility(0);
      i = this.t.getScrollY();
      paramInt1 = this.A.getScrollY();
      Log.e("TAG_指示器的ScrollY", "" + i);
      Log.e("TAG_滚动视图的ScroollY", "" + paramInt1);
      Log.e("TAG_垂直滚动起源", "" + paramInt2);
      Log.e("TAG_指示器初始化的顶部高度", "" + this.al);
      paramInt2 = this.M.getVisibility();
      i = this.al - this.s;
      if ((paramInt2 == 0) || (i > paramInt1)) {
        break label282;
      }
      Log.e("TAG_滚动高度大于指示器初始化距顶部高度", "ll_ind gone,topY<=SY");
      this.M.setVisibility(0);
      if (this.W != null) {
        ((ScrollGridLayoutManager)this.W.getLayoutManager()).setScrollEnabled(true);
      }
    }
    label282:
    while ((paramInt2 == 8) || (i <= paramInt1))
    {
      return;
      this.g.setImageResource(2130840339);
      this.f.setImageResource(2130840142);
      this.r.setVisibility(8);
      break;
    }
    Log.e("TAG_滚动高度小于指示器初始化距顶部高度", "ll_ind vis,topY>SY");
    this.M.setVisibility(8);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.al = this.t.getTop();
      Log.e("TAG_window", "" + this.al);
    }
  }
  
  public void setObjectForPosition(View paramView, int paramInt)
  {
    if (this.R != null) {
      this.R.setObjectForPosition(paramView, paramInt);
    }
  }
  
  public void showShare()
  {
    if (checkNet(this.a))
    {
      s locals = this.ao.getShareInfo();
      com.ziroom.commonlibrary.f.a.setLocalIcon(2130839940);
      com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter((FragmentActivity)this.a, locals.getShareUrl(), locals.getShareTitle(), locals.getShareTopic(), locals.getShareImg(), this.aT);
      return;
    }
    g.textToast(this.a, "网络连接错误");
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      GoodsDetailAc.this.dismissProgress();
      g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "请稍后再试");
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        GoodsDetailAc.a(GoodsDetailAc.this, (List)paraml.getObject());
        if ((GoodsDetailAc.u(GoodsDetailAc.this) != null) && (GoodsDetailAc.u(GoodsDetailAc.this).size() > 0)) {
          GoodsDetailAc.b(GoodsDetailAc.this, GoodsDetailAc.u(GoodsDetailAc.this));
        }
      }
      for (;;)
      {
        GoodsDetailAc.this.dismissProgress();
        return;
        g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "暂无可领优惠券");
        continue;
        paraml = paraml.getMessage();
        if (paraml != null) {
          GoodsDetailAc.this.showToast(paraml);
        } else {
          g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "请稍后再试");
        }
      }
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  class c
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public c(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      GoodsDetailAc.this.dismissProgress();
      g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "请稍后再试");
      GoodsDetailAc.q(GoodsDetailAc.this);
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        GoodsDetailAc.a(GoodsDetailAc.this, (com.ziroom.ziroomcustomer.bestgoods.model.i)paraml.getObject());
        if (GoodsDetailAc.n(GoodsDetailAc.this) != null)
        {
          GoodsDetailAc.b(GoodsDetailAc.this, GoodsDetailAc.n(GoodsDetailAc.this));
          GoodsDetailAc.o(GoodsDetailAc.this);
          GoodsDetailAc.this.closeEmpty(GoodsDetailAc.p(GoodsDetailAc.this));
        }
        for (;;)
        {
          GoodsDetailAc.this.dismissProgress();
          return;
          g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "请稍后再试");
          GoodsDetailAc.q(GoodsDetailAc.this);
        }
      }
      paraml = paraml.getMessage();
      if (paraml != null) {
        g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), paraml);
      }
      for (;;)
      {
        GoodsDetailAc.q(GoodsDetailAc.this);
        break;
        g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "请稍后再试");
      }
    }
  }
  
  class d
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    private int c;
    
    public d(com.freelxl.baselibrary.d.f.a parama, int paramInt)
    {
      super();
      this.c = paramInt;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      GoodsDetailAc.this.dismissProgress();
      GoodsDetailAc.this.showToast("请稍后再试");
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        GoodsDetailAc.a(GoodsDetailAc.this, (com.ziroom.ziroomcustomer.bestgoods.model.j)paraml.getObject());
        if (GoodsDetailAc.t(GoodsDetailAc.this) != null) {
          GoodsDetailAc.a(GoodsDetailAc.this, this.c, GoodsDetailAc.t(GoodsDetailAc.this));
        }
      }
      for (;;)
      {
        GoodsDetailAc.this.dismissProgress();
        return;
        g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "暂无可选物品");
        continue;
        paraml = paraml.getMessage();
        if (!TextUtils.isEmpty(paraml)) {
          g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), paraml);
        } else {
          g.textToast(GoodsDetailAc.b(GoodsDetailAc.this), "请稍后再试");
        }
      }
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
      if (GoodsDetailAc.s(GoodsDetailAc.this) == null) {
        return;
      }
      GoodsDetailAc.s(GoodsDetailAc.this).setEnabled(true);
      GoodsDetailAc.k(GoodsDetailAc.this);
    }
    
    public void onTick(long paramLong)
    {
      if (GoodsDetailAc.s(GoodsDetailAc.this) == null) {
        return;
      }
      GoodsDetailAc.s(GoodsDetailAc.this).setText("距结束 " + com.ziroom.ziroomcustomer.bestgoods.c.d.secToTime((int)paramLong / 1000));
      GoodsDetailAc.s(GoodsDetailAc.this).setEnabled(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/GoodsDetailAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */