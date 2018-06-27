package com.ziroom.ziroomcustomer.newServiceList.fragment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceH5Activity;
import com.ziroom.ziroomcustomer.bestgoods.model.an;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.home.HomePageFragment;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.a.d;
import com.ziroom.ziroomcustomer.newServiceList.b.b.a;
import com.ziroom.ziroomcustomer.newServiceList.model.aw;
import com.ziroom.ziroomcustomer.newServiceList.model.az;
import com.ziroom.ziroomcustomer.newServiceList.model.ba;
import com.ziroom.ziroomcustomer.newServiceList.model.ba.a;
import com.ziroom.ziroomcustomer.newServiceList.model.ba.b;
import com.ziroom.ziroomcustomer.newServiceList.model.bb;
import com.ziroom.ziroomcustomer.newServiceList.model.bc;
import com.ziroom.ziroomcustomer.newServiceList.model.bc.a;
import com.ziroom.ziroomcustomer.newServiceList.model.bc.b;
import com.ziroom.ziroomcustomer.newServiceList.model.bc.c;
import com.ziroom.ziroomcustomer.newServiceList.model.bc.d;
import com.ziroom.ziroomcustomer.newServiceList.model.bd;
import com.ziroom.ziroomcustomer.newServiceList.model.c.c;
import com.ziroom.ziroomcustomer.newServiceList.model.c.d;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newrepair.mvp.RepairHomeActivity;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.List;

public class HomePageServiceFragment
  extends HomePageFragment
{
  private SimpleDraweeView A;
  private MyGridView B;
  private RecyclerView C;
  private LinearLayout D;
  private LinearLayout E;
  private LinearLayout F;
  private TextView G;
  private TextView H;
  private View I;
  private ViewPager J;
  private RelativeLayout K;
  private LinearLayout L;
  private TextView M;
  private TextView N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private LinearLayout S;
  private LinearLayout T;
  private boolean U;
  private boolean V = false;
  private boolean W = false;
  private Intent X;
  private bd Y;
  private String Z = "";
  private float aa;
  private int ab;
  private boolean ac = true;
  private bb ad;
  private ImageView ae;
  private ImageView af;
  private long ag = 10L;
  private long ah = -1L;
  private Runnable ai = new Runnable()
  {
    public void run()
    {
      if (System.currentTimeMillis() - HomePageServiceFragment.a(HomePageServiceFragment.this) > 10L)
      {
        HomePageServiceFragment.a(HomePageServiceFragment.this, -1L);
        HomePageServiceFragment.b(HomePageServiceFragment.this).setAlpha(1.0F);
        return;
      }
      HomePageServiceFragment.d(HomePageServiceFragment.this).postDelayed(this, HomePageServiceFragment.c(HomePageServiceFragment.this));
    }
  };
  private BroadcastReceiver aj = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("select_city"))
      {
        HomePageServiceFragment.b(HomePageServiceFragment.this, com.ziroom.ziroomcustomer.base.b.c);
        if (ah.checkNet(HomePageServiceFragment.e(HomePageServiceFragment.this)))
        {
          HomePageServiceFragment.y(HomePageServiceFragment.this);
          HomePageServiceFragment.z(HomePageServiceFragment.this);
          HomePageServiceFragment.o(HomePageServiceFragment.this);
          HomePageServiceFragment.A(HomePageServiceFragment.this);
          if (HomePageServiceFragment.B(HomePageServiceFragment.this)) {
            HomePageServiceFragment.C(HomePageServiceFragment.this);
          }
        }
      }
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      if (i == 17) {
        HomePageServiceFragment.o(HomePageServiceFragment.this);
      }
      if (i == 7) {
        HomePageServiceFragment.o(HomePageServiceFragment.this);
      }
    }
  };
  private FragmentActivity t;
  private SimpleDraweeView u;
  private RelativeLayout v;
  private TextView w;
  private SimpleDraweeView x;
  private SimpleDraweeView y;
  private SimpleDraweeView z;
  
  public HomePageServiceFragment()
  {
    super(2130903903);
  }
  
  private void a(int paramInt1, int paramInt2, final TextView paramTextView)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(2000L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramTextView.setText(paramAnonymousValueAnimator.getAnimatedValue().toString());
        if (paramAnonymousValueAnimator.getAnimatedFraction() >= 1.0F) {
          Log.d("dsjgkldsj", "========  " + paramAnonymousValueAnimator.getAnimatedFraction());
        }
      }
    });
    localValueAnimator.start();
  }
  
  private void a(bc parambc)
  {
    if (parambc.getBanner() != null)
    {
      String str = parambc.getBanner().getImg();
      final aw localaw = com.ziroom.ziroomcustomer.newServiceList.utils.g.getBannerData(parambc.getBanner());
      this.u.setController(com.freelxl.baselibrary.f.c.frescoController(str));
      this.u.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.ziroomcustomer.newServiceList.utils.g.startActivityByPageBean(HomePageServiceFragment.e(HomePageServiceFragment.this), localaw);
        }
      });
    }
    if ((parambc.getShuffling() != null) && (parambc.getShuffling().size() > 0))
    {
      this.E.setVisibility(0);
      this.K.setVisibility(0);
      a(parambc.getShuffling());
      if ((parambc.getRecommend() == null) || (parambc.getRecommend().size() <= 0)) {
        break label201;
      }
      this.D.setVisibility(0);
      this.B.setVisibility(0);
      c(parambc.getRecommend());
    }
    for (;;)
    {
      if ((parambc.getEvaluate() == null) || (parambc.getEvaluate().size() <= 0)) {
        break label222;
      }
      this.F.setVisibility(0);
      this.C.setVisibility(0);
      b(parambc.getEvaluate());
      return;
      this.E.setVisibility(8);
      this.K.setVisibility(8);
      break;
      label201:
      this.B.setVisibility(8);
      this.D.setVisibility(8);
    }
    label222:
    this.F.setVisibility(8);
    this.C.setVisibility(8);
  }
  
  private void a(final bd parambd)
  {
    this.x.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (parambd.getMove().intValue() == 1)
        {
          HomePageServiceFragment.a(HomePageServiceFragment.this, MoveTypeActivity.class, true);
          return;
        }
        HomePageServiceFragment.a(HomePageServiceFragment.this, MoveTypeActivity.class, false);
      }
    });
    this.y.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (parambd.getClean().intValue() == 1)
        {
          HomePageServiceFragment.a(HomePageServiceFragment.this, CleanHomeActivity.class, true);
          return;
        }
        HomePageServiceFragment.a(HomePageServiceFragment.this, CleanHomeActivity.class, false);
      }
    });
    this.z.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (parambd.getMaintenance().intValue() == 1)
        {
          HomePageServiceFragment.a(HomePageServiceFragment.this, RepairHomeActivity.class, true);
          return;
        }
        HomePageServiceFragment.a(HomePageServiceFragment.this, RepairHomeActivity.class, false);
      }
    });
    this.A.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HomePageServiceFragment.a(HomePageServiceFragment.this, parambd.getFurnishings());
      }
    });
  }
  
  private void a(final com.ziroom.ziroomcustomer.newServiceList.model.c paramc)
  {
    if ((paramc != null) && (paramc.getHomeFloating() != null) && (paramc.getHomeFloating().getValid() == 1))
    {
      final String str = paramc.getHomeFloating().getUrl();
      this.l.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
      localLayoutParams.setMargins(0, ac.getScreenWidth(this.t) * 280 / 375 + ah.dip2px(this.t, 56.0F), 0, 0);
      this.l.setLayoutParams(localLayoutParams);
      paramc = paramc.getHomeFloating().getImage();
      if (this.l.getTag() == null)
      {
        this.l.setTag(paramc);
        this.l.setController(com.freelxl.baselibrary.f.c.frescoController(paramc));
      }
      for (;;)
      {
        this.l.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            JsBridgeWebActivity.start(HomePageServiceFragment.e(HomePageServiceFragment.this), "", str, false, "", paramc, false);
          }
        });
        return;
        if (!paramc.equals(this.l.getTag()))
        {
          this.l.setTag(paramc);
          this.l.setController(com.freelxl.baselibrary.f.c.frescoController(paramc));
        }
      }
    }
    this.l.setVisibility(8);
  }
  
  private void a(Class paramClass, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.X = new Intent(this.t, paramClass);
      this.t.startActivity(this.X);
      this.t.overridePendingTransition(2130968684, 2130968685);
      return;
    }
    com.freelxl.baselibrary.f.g.textToast(this.t, "敬请期待");
  }
  
  private void a(final Integer paramInteger)
  {
    com.ziroom.ziroomcustomer.e.n.getYoupinJumpInfo(this.t, new com.ziroom.ziroomcustomer.e.a.a(this.t, new com.ziroom.ziroomcustomer.e.c.m(an.class, new com.ziroom.ziroomcustomer.e.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if (paramInteger.intValue() == 1)
        {
          HomePageServiceFragment.a(HomePageServiceFragment.this, YouPinGuidanceActivity.class, true);
          return;
        }
        HomePageServiceFragment.a(HomePageServiceFragment.this, YouPinGuidanceActivity.class, false);
      }
      
      public void onSuccess(int paramAnonymousInt, an paramAnonymousan)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousan);
        if (paramAnonymousan != null)
        {
          paramAnonymousan = paramAnonymousan.getUrl();
          if (!TextUtils.isEmpty(paramAnonymousan))
          {
            ad.putOther(HomePageServiceFragment.e(HomePageServiceFragment.this), "youpinH5url", paramAnonymousan);
            Intent localIntent = new Intent(HomePageServiceFragment.e(HomePageServiceFragment.this), YouPinGuidanceH5Activity.class);
            localIntent.putExtra("youpinH5url", paramAnonymousan);
            HomePageServiceFragment.this.startActivity(localIntent);
          }
        }
        else
        {
          return;
        }
        ad.putOther(HomePageServiceFragment.e(HomePageServiceFragment.this), "youpinH5url", "");
        if (paramInteger.intValue() == 1)
        {
          HomePageServiceFragment.a(HomePageServiceFragment.this, YouPinGuidanceActivity.class, true);
          return;
        }
        HomePageServiceFragment.a(HomePageServiceFragment.this, YouPinGuidanceActivity.class, false);
      }
    });
  }
  
  private void a(List<bc.d> paramList)
  {
    paramList = com.ziroom.ziroomcustomer.newServiceList.utils.g.getShrfflingData(paramList);
    this.G.setText("1");
    this.H.setText("/" + paramList.size());
    int i = ac.getScreenWidth(this.t) - com.ziroom.ziroomcustomer.util.n.dip2px(this.t, 35.0F);
    int j = i * 9 / 16;
    this.K.getLayoutParams().height = j;
    this.J.getLayoutParams().width = i;
    this.J.getLayoutParams().height = j;
    this.J.setOffscreenPageLimit(2);
    this.J.setPageMargin(com.ziroom.ziroomcustomer.util.n.dip2px(this.t, 6.0F));
    paramList = new com.ziroom.ziroomcustomer.newServiceList.a.n(this.t, paramList);
    this.J.setAdapter(paramList);
    this.J.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        if (HomePageServiceFragment.f(HomePageServiceFragment.this) != null) {
          HomePageServiceFragment.f(HomePageServiceFragment.this).invalidate();
        }
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        HomePageServiceFragment.g(HomePageServiceFragment.this).setText(paramAnonymousInt + 1 + "");
      }
    });
  }
  
  private void b(View paramView)
  {
    this.u = ((SimpleDraweeView)paramView.findViewById(2131693986));
    this.v = ((RelativeLayout)paramView.findViewById(2131693987));
    this.w = ((TextView)paramView.findViewById(2131693989));
    this.ae = ((ImageView)paramView.findViewById(2131693988));
    this.af = ((ImageView)paramView.findViewById(2131690724));
    this.x = ((SimpleDraweeView)paramView.findViewById(2131693990));
    this.y = ((SimpleDraweeView)paramView.findViewById(2131693991));
    this.z = ((SimpleDraweeView)paramView.findViewById(2131693992));
    this.A = ((SimpleDraweeView)paramView.findViewById(2131693993));
    this.B = ((MyGridView)paramView.findViewById(2131693995));
    this.C = ((RecyclerView)paramView.findViewById(2131690278));
    this.D = ((LinearLayout)paramView.findViewById(2131693994));
    this.E = ((LinearLayout)paramView.findViewById(2131693996));
    this.F = ((LinearLayout)paramView.findViewById(2131694002));
    this.G = ((TextView)paramView.findViewById(2131693997));
    this.H = ((TextView)paramView.findViewById(2131693998));
    this.I = paramView.findViewById(2131690379);
    this.J = ((ViewPager)paramView.findViewById(2131694001));
    this.K = ((RelativeLayout)paramView.findViewById(2131694000));
    this.L = ((LinearLayout)paramView.findViewById(2131693985));
    this.S = ((LinearLayout)paramView.findViewById(2131694003));
    this.T = ((LinearLayout)paramView.findViewById(2131694004));
    this.M = ((TextView)paramView.findViewById(2131694006));
    this.N = ((TextView)paramView.findViewById(2131694009));
    this.O = ((TextView)paramView.findViewById(2131694012));
    this.P = ((TextView)paramView.findViewById(2131694007));
    this.Q = ((TextView)paramView.findViewById(2131694010));
    this.R = ((TextView)paramView.findViewById(2131694013));
  }
  
  private void b(List<bc.b> paramList)
  {
    paramList = new com.ziroom.ziroomcustomer.newServiceList.a.m(this.t, paramList);
    this.C.setLayoutManager(new LinearLayoutManager(this.t, 0, false));
    this.C.setAdapter(paramList);
  }
  
  private void c(List<bc.c> paramList)
  {
    paramList = com.ziroom.ziroomcustomer.newServiceList.utils.g.getRecommendData(paramList);
    paramList = new d(this.t, paramList);
    this.B.setVerticalSpacing(com.ziroom.ziroomcustomer.util.n.dip2px(this.t, 6.0F));
    this.B.setAdapter(paramList);
  }
  
  private void f()
  {
    b(com.ziroom.ziroomcustomer.base.b.c);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("select_city");
    localIntentFilter.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.t).registerReceiver(this.aj, localIntentFilter);
  }
  
  private void g()
  {
    if ((!this.V) || (!this.W)) {
      return;
    }
    h();
  }
  
  private void h()
  {
    i();
    j();
    k();
    m();
    n();
  }
  
  private void i()
  {
    com.ziroom.ziroomcustomer.e.n.requestServicePageSupport(this.t, new com.freelxl.baselibrary.d.c.a(new f(bd.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, bd paramAnonymousbd)
      {
        if (paramAnonymousbd != null)
        {
          HomePageServiceFragment.a(HomePageServiceFragment.this, paramAnonymousbd);
          HomePageServiceFragment.b(HomePageServiceFragment.this, paramAnonymousbd);
        }
      }
    });
  }
  
  private void j()
  {
    com.ziroom.ziroomcustomer.e.n.requestServicePageStaticContent(this.t, new com.freelxl.baselibrary.d.c.a(new f(bc.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        if (paramAnonymousbc != null) {
          HomePageServiceFragment.a(HomePageServiceFragment.this, paramAnonymousbc);
        }
      }
    });
  }
  
  private void k()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str = "";
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    com.ziroom.ziroomcustomer.e.n.requestServicePageDynamicContent(this.t, str, new com.freelxl.baselibrary.d.c.a(new f(ba.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final ba paramAnonymousba)
      {
        if (paramAnonymousba != null)
        {
          ViewGroup.LayoutParams localLayoutParams;
          if ((paramAnonymousba.getNotice() != null) && (!TextUtils.isEmpty(paramAnonymousba.getNotice().getTitle())))
          {
            HomePageServiceFragment.h(HomePageServiceFragment.this).setVisibility(0);
            HomePageServiceFragment.i(HomePageServiceFragment.this).setVisibility(0);
            localLayoutParams = HomePageServiceFragment.j(HomePageServiceFragment.this).getLayoutParams();
            localLayoutParams.width = com.ziroom.ziroomcustomer.util.n.dip2px(HomePageServiceFragment.e(HomePageServiceFragment.this), 28.0F);
            HomePageServiceFragment.j(HomePageServiceFragment.this).setLayoutParams(localLayoutParams);
            HomePageServiceFragment.j(HomePageServiceFragment.this).setBackgroundResource(2130840398);
            HomePageServiceFragment.k(HomePageServiceFragment.this).setVisibility(0);
            HomePageServiceFragment.l(HomePageServiceFragment.this).setText(paramAnonymousba.getNotice().getTitle());
            HomePageServiceFragment.h(HomePageServiceFragment.this).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                JsBridgeWebActivity.start(HomePageServiceFragment.e(HomePageServiceFragment.this), paramAnonymousba.getNotice().getTitle(), paramAnonymousba.getNotice().getUrl(), false, "", "", false);
              }
            });
          }
          do
          {
            return;
            if (paramAnonymousba.getPromotion() == null)
            {
              HomePageServiceFragment.h(HomePageServiceFragment.this).setVisibility(8);
              HomePageServiceFragment.i(HomePageServiceFragment.this).setVisibility(8);
              return;
            }
            if (paramAnonymousba.getPromotion().getIsReceive() == 0)
            {
              HomePageServiceFragment.h(HomePageServiceFragment.this).setVisibility(0);
              HomePageServiceFragment.i(HomePageServiceFragment.this).setVisibility(0);
              localLayoutParams = HomePageServiceFragment.j(HomePageServiceFragment.this).getLayoutParams();
              localLayoutParams.width = com.ziroom.ziroomcustomer.util.n.dip2px(HomePageServiceFragment.e(HomePageServiceFragment.this), 38.0F);
              HomePageServiceFragment.j(HomePageServiceFragment.this).setLayoutParams(localLayoutParams);
              HomePageServiceFragment.j(HomePageServiceFragment.this).setBackgroundResource(2130840396);
              HomePageServiceFragment.l(HomePageServiceFragment.this).setText(paramAnonymousba.getPromotion().getTitle());
              HomePageServiceFragment.h(HomePageServiceFragment.this).setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  if (!ApplicationEx.c.isLoginState())
                  {
                    com.ziroom.commonlibrary.login.a.startLoginActivity(HomePageServiceFragment.e(HomePageServiceFragment.this));
                    HomePageServiceFragment.a(HomePageServiceFragment.this, "receive_login");
                    return;
                  }
                  HomePageServiceFragment.m(HomePageServiceFragment.this);
                }
              });
              return;
            }
          } while (paramAnonymousba.getPromotion().getIsReceive() != 1);
          if ((!TextUtils.isEmpty(HomePageServiceFragment.n(HomePageServiceFragment.this))) && ("receive_login".equals(HomePageServiceFragment.n(HomePageServiceFragment.this))))
          {
            HomePageServiceFragment.a(HomePageServiceFragment.this, "");
            com.freelxl.baselibrary.f.g.textToast(HomePageServiceFragment.e(HomePageServiceFragment.this), "您已经领过了哦");
          }
          HomePageServiceFragment.h(HomePageServiceFragment.this).setVisibility(8);
          HomePageServiceFragment.i(HomePageServiceFragment.this).setVisibility(8);
          return;
        }
        HomePageServiceFragment.h(HomePageServiceFragment.this).setVisibility(8);
        HomePageServiceFragment.i(HomePageServiceFragment.this).setVisibility(8);
      }
    });
  }
  
  private void l()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getPhone();
    com.ziroom.ziroomcustomer.e.n.requestServicePageReceiveCoupon(this.t, (String)localObject, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.e(az.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        j.showGateFailureMessage(HomePageServiceFragment.e(HomePageServiceFragment.this), paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<az> paramAnonymousList)
      {
        if (paramAnonymousList != null)
        {
          HomePageServiceFragment.a(HomePageServiceFragment.this, "");
          HomePageServiceFragment.o(HomePageServiceFragment.this);
          new com.ziroom.ziroomcustomer.newServiceList.b.a(HomePageServiceFragment.e(HomePageServiceFragment.this), paramAnonymousList).show();
        }
      }
    });
  }
  
  private void m()
  {
    com.ziroom.ziroomcustomer.e.n.getCommonTemplateOnCityV2(this.t, Integer.valueOf(20), new com.freelxl.baselibrary.d.c.a(new f(com.ziroom.ziroomcustomer.newServiceList.model.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final com.ziroom.ziroomcustomer.newServiceList.model.c paramAnonymousc)
      {
        if ((paramAnonymousc != null) && (paramAnonymousc.getHome() != null) && (paramAnonymousc.getHome().getValid() == 1))
        {
          SharedPreferences localSharedPreferences = HomePageServiceFragment.e(HomePageServiceFragment.this).getSharedPreferences("home_service_page", 0);
          if (localSharedPreferences.getBoolean("service_page_bargain", true))
          {
            final com.ziroom.ziroomcustomer.newServiceList.b.b localb = new com.ziroom.ziroomcustomer.newServiceList.b.b(HomePageServiceFragment.e(HomePageServiceFragment.this), paramAnonymousc.getHome().getImage(), paramAnonymousc.getHome().getUrl(), "servicePage");
            localb.show();
            localb.setOnAnimationListener(new b.a()
            {
              public void change()
              {
                localb.dismiss();
                HomePageServiceFragment.a(HomePageServiceFragment.this, paramAnonymousc);
              }
            });
            paramAnonymousc = localSharedPreferences.edit();
            paramAnonymousc.putBoolean("service_page_bargain", false);
            paramAnonymousc.commit();
            return;
          }
          HomePageServiceFragment.a(HomePageServiceFragment.this, paramAnonymousc);
          return;
        }
        HomePageServiceFragment.a(HomePageServiceFragment.this, paramAnonymousc);
      }
    });
  }
  
  private void n()
  {
    com.ziroom.ziroomcustomer.e.n.getServicePageGains(this.t, new com.freelxl.baselibrary.d.c.a(new f(bb.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        HomePageServiceFragment.p(HomePageServiceFragment.this).setVisibility(8);
        HomePageServiceFragment.q(HomePageServiceFragment.this).setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, bb paramAnonymousbb)
      {
        if (paramAnonymousbb != null)
        {
          HomePageServiceFragment.p(HomePageServiceFragment.this).setVisibility(0);
          HomePageServiceFragment.q(HomePageServiceFragment.this).setVisibility(0);
          HomePageServiceFragment.a(HomePageServiceFragment.this, paramAnonymousbb);
          HomePageServiceFragment.s(HomePageServiceFragment.this).setText(HomePageServiceFragment.r(HomePageServiceFragment.this).getServicerTotalNum() + "");
          HomePageServiceFragment.t(HomePageServiceFragment.this).setText("+" + HomePageServiceFragment.r(HomePageServiceFragment.this).getServicerIncreaseNum());
          HomePageServiceFragment.u(HomePageServiceFragment.this).setText(HomePageServiceFragment.r(HomePageServiceFragment.this).getUserTotalNum() + "");
          HomePageServiceFragment.v(HomePageServiceFragment.this).setText("+" + HomePageServiceFragment.r(HomePageServiceFragment.this).getUserIncreaseNum());
          HomePageServiceFragment.w(HomePageServiceFragment.this).setText(HomePageServiceFragment.r(HomePageServiceFragment.this).getOrderTotalNum() + "");
          HomePageServiceFragment.x(HomePageServiceFragment.this).setText("+" + HomePageServiceFragment.r(HomePageServiceFragment.this).getOrderIncreaseNum());
          return;
        }
        HomePageServiceFragment.p(HomePageServiceFragment.this).setVisibility(8);
        HomePageServiceFragment.q(HomePageServiceFragment.this).setVisibility(8);
      }
    });
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    paramInt1 = this.ab;
    int i = com.ziroom.ziroomcustomer.util.n.dip2px(this.t, 120.0F);
    int j = ac.getScreenHeight(this.t);
    int k = com.ziroom.ziroomcustomer.util.n.dip2px(this.t, 150.0F);
    if ((paramInt2 / (paramInt1 + i - j - k) > 1.0D) && (this.ac))
    {
      this.ac = false;
      if (this.ad != null)
      {
        a(this.ad.getServicerTotalNum() - this.ad.getServicerIncreaseNum(), this.ad.getServicerTotalNum(), this.M);
        a(this.ad.getUserTotalNum() - this.ad.getUserIncreaseNum(), this.ad.getUserTotalNum(), this.N);
        a(this.ad.getOrderTotalNum() - this.ad.getOrderIncreaseNum(), this.ad.getOrderTotalNum(), this.O);
      }
    }
    if (this.ah == -1L)
    {
      this.l.setAlpha(0.3F);
      this.n.postDelayed(this.ai, this.ag);
    }
    this.ah = System.currentTimeMillis();
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.t = getActivity();
    this.U = true;
    b(paramView);
    f();
    this.V = true;
    g();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      LocalBroadcastManager.getInstance(this.t).unregisterReceiver(this.aj);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.aa = (com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this.t) * 339.0F / 375.0F);
    com.ziroom.ziroomcustomer.newServiceList.utils.b.setAllPartParams(this.t, this.u, this.x, this.y, this.z, this.A);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.L.measure(i, j);
    this.ab = this.L.getMeasuredHeight();
    Log.d("dsjgkldsj", "========  sc_service height=" + this.ab);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      this.W = true;
      if (this.U)
      {
        this.U = false;
        g();
        return;
      }
      i();
      m();
      return;
    }
    this.W = false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/fragment/HomePageServiceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */