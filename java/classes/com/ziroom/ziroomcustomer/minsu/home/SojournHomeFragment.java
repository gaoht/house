package com.ziroom.ziroomcustomer.minsu.home;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.home.HomePageFragment;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponConfigInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponConfigInfoBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFirstCouponLoginBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFirstCouponLoginBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFirstCouponLoginBean.LunboBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBeanToday;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBeanToday.DataBean;
import com.ziroom.ziroomcustomer.minsu.dialog.d.a;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.f;
import com.ziroom.ziroomcustomer.minsu.f.g;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.m;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.a;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.b;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.c;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.d;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.f;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.g;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.h;
import com.ziroom.ziroomcustomer.minsu.home.b.a.a.i;
import com.ziroom.ziroomcustomer.minsu.home.b.a.b;
import com.ziroom.ziroomcustomer.minsu.home.b.b.a;
import com.ziroom.ziroomcustomer.minsu.home.b.b.a.b;
import com.ziroom.ziroomcustomer.minsu.home.b.c.a;
import com.ziroom.ziroomcustomer.minsu.home.b.c.a.a;
import com.ziroom.ziroomcustomer.minsu.home.view.MinsuHomeRecyclerViewHouseItem;
import com.ziroom.ziroomcustomer.minsu.home.view.MinsuHomeRecyclerViewInv;
import com.ziroom.ziroomcustomer.minsu.home.view.MinsuHomeRecyclerViewTop;
import com.ziroom.ziroomcustomer.minsu.home.view.SojournHomeItemView;
import com.ziroom.ziroomcustomer.minsu.home.view.SojournHomeItemView.a.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.util.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class SojournHomeFragment
  extends HomePageFragment
  implements EMMessageListener
{
  public static String t = "https://zhuanti.ziroom.com/zhuanti/minsu/activity/mscy/zrms.html";
  private com.ziroom.ziroomcustomer.minsu.home.b.a A;
  private com.ziroom.ziroomcustomer.minsu.home.b.b B;
  private MinsuHouseBeanToday C;
  private com.ziroom.ziroomcustomer.minsu.home.b.c D;
  private MinsuFirstCouponLoginBean E;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private Unbinder J;
  private f K;
  private List<String> L = new ArrayList();
  private List<a.b> M = new ArrayList();
  private List<a.b> N = new ArrayList();
  private boolean O = true;
  private boolean P = false;
  private boolean Q = false;
  private long R = 0L;
  private int S = 0;
  private int T = 0;
  private View.OnClickListener U = new SojournHomeFragment.6(this);
  private Handler V = new SojournHomeFragment.9(this);
  private Handler W = new SojournHomeFragment.18(this);
  @BindView(2131694362)
  SimpleDraweeView img_landlord;
  @BindView(2131694116)
  ImageView iv_search;
  @BindView(2131694668)
  SimpleDraweeView iv_top_banner;
  @BindView(2131694118)
  LottieAnimationView lav_home;
  @BindView(2131694166)
  ConvenientBanner minsu_home_ad_banner;
  @BindView(2131694360)
  MinsuHomeRecyclerViewInv minsu_home_inv;
  @BindView(2131694163)
  SojournHomeItemView minsu_home_mdd;
  @BindView(2131694171)
  SojournHomeItemView minsu_home_pinp;
  @BindView(2131694361)
  SojournHomeItemView minsu_home_qds;
  @BindView(2131694363)
  SojournHomeItemView minsu_home_story;
  @BindView(2131694165)
  MinsuHomeRecyclerViewHouseItem minsu_home_today;
  @BindView(2131694167)
  MinsuHomeRecyclerViewTop minsu_home_top;
  @BindView(2131694164)
  SojournHomeItemView minsu_home_zry;
  @BindView(2131694359)
  SojournHomeItemView minsu_home_zryhd;
  @BindView(2131694173)
  TextView to_minsu_customer_service;
  @BindView(2131694028)
  TextView tv_title_top;
  public BroadcastReceiver u = new SojournHomeFragment.16(this);
  public BroadcastReceiver v = new SojournHomeFragment.17(this);
  public BroadcastReceiver w = new SojournHomeFragment.19(this);
  private Activity x;
  private com.ziroom.ziroomcustomer.minsu.home.c.a y;
  private com.ziroom.ziroomcustomer.minsu.home.a.a z;
  
  public SojournHomeFragment()
  {
    super(2130903987);
  }
  
  private void a(MinsuCouponConfigInfoBean.DataBean paramDataBean)
  {
    int i = paramDataBean.getMgVersion();
    new SojournHomeFragment.8(this, paramDataBean.getMgUrl(), i).start();
  }
  
  private void a(MinsuCouponConfigInfoBean paramMinsuCouponConfigInfoBean)
  {
    if ((paramMinsuCouponConfigInfoBean != null) && (paramMinsuCouponConfigInfoBean.getData() != null))
    {
      paramMinsuCouponConfigInfoBean = paramMinsuCouponConfigInfoBean.getData();
      switch (paramMinsuCouponConfigInfoBean.getMgStatus())
      {
      case 0: 
      default: 
      case 1: 
        do
        {
          return;
          paramMinsuCouponConfigInfoBean = m.getLocalLottieFilePath();
        } while (TextUtils.isEmpty(paramMinsuCouponConfigInfoBean));
        this.F = m.loadLottieFromScCard(this.x, this.lav_home, paramMinsuCouponConfigInfoBean);
        return;
      }
      a(paramMinsuCouponConfigInfoBean);
      return;
    }
    i();
  }
  
  private void a(MinsuFirstCouponLoginBean.DataBean paramDataBean)
  {
    com.ziroom.ziroomcustomer.minsu.dialog.d.newBuilder(this.x).setTitle(paramDataBean.getContentHint()).setUrl(paramDataBean.getPicHint()).setButtonText(paramDataBean.getButtonHint()).setOnClickListener(new SojournHomeFragment.7(this, paramDataBean)).show();
  }
  
  private void a(MinsuFirstCouponLoginBean.LunboBean paramLunboBean)
  {
    a.b localb = new a.b();
    localb.setImg(paramLunboBean.getImg());
    localb.setTarget(paramLunboBean.getTarget());
    localb.setApp(paramLunboBean.getApp());
    localb.setTitle(paramLunboBean.getTitle());
    localb.setDescription(paramLunboBean.getDescription());
    k.CmsToWebActivity(this.x, localb);
  }
  
  private void a(MinsuFirstCouponLoginBean paramMinsuFirstCouponLoginBean)
  {
    paramMinsuFirstCouponLoginBean = paramMinsuFirstCouponLoginBean.getData();
    int i = paramMinsuFirstCouponLoginBean.getMgClickSwitch();
    if (paramMinsuFirstCouponLoginBean != null) {}
    switch (i)
    {
    default: 
      return;
    case 1: 
      a(paramMinsuFirstCouponLoginBean);
      return;
    }
    a(paramMinsuFirstCouponLoginBean.getLunbo());
  }
  
  private void a(a.b paramb, SimpleDraweeView paramSimpleDraweeView)
  {
    String str = paramb.getTarget();
    if (ae.notNull(str)) {
      paramSimpleDraweeView.setOnClickListener(new SojournHomeFragment.10(this, paramb, str));
    }
  }
  
  private void a(a.b paramb, SojournHomeItemView.a.a parama)
  {
    if (!TextUtils.isEmpty(paramb.getTitle()))
    {
      paramb = paramb.getTitle().split("&\\|");
      if (paramb.length >= 2)
      {
        parama.b.setText(paramb[0]);
        parama.c.setText(paramb[1]);
        return;
      }
      if (paramb.length >= 1)
      {
        parama.c.setVisibility(8);
        parama.b.setText(paramb[0]);
        return;
      }
      parama.b.setVisibility(8);
      parama.c.setVisibility(8);
      return;
    }
    parama.b.setVisibility(8);
    parama.c.setVisibility(8);
  }
  
  private void a(MinsuHomeRecyclerViewHouseItem paramMinsuHomeRecyclerViewHouseItem, List<MinsuHouseBean.DataBean.ListBean> paramList, int paramInt)
  {
    paramMinsuHomeRecyclerViewHouseItem.setData(paramList, paramInt);
    paramMinsuHomeRecyclerViewHouseItem.setOnClickListener(new SojournHomeFragment.11(this, paramList));
  }
  
  private void a(List<a.b> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      this.L.clear();
      int i = 0;
      while (i < paramList.size())
      {
        this.L.add(((a.b)paramList.get(i)).getImg());
        i += 1;
      }
      this.minsu_home_ad_banner.setPages(new SojournHomeFragment.13(this), this.L, new SojournHomeFragment.14(this)).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c);
      this.minsu_home_ad_banner.startTurning(1500L);
      this.minsu_home_ad_banner.setOnItemClickListener(new SojournHomeFragment.15(this, paramList));
    } while ((this.L == null) || (this.L.size() <= 0));
    if (this.L.size() == 1)
    {
      this.minsu_home_ad_banner.setPointViewVisible(false);
      this.minsu_home_ad_banner.setCanLoop(false);
      return;
    }
    this.minsu_home_ad_banner.setPointViewVisible(true);
    this.minsu_home_ad_banner.setCanLoop(true);
  }
  
  private void b(View paramView)
  {
    paramView = this.iv_top_banner.getLayoutParams();
    paramView.height = (this.p * 3 / 4);
    this.iv_top_banner.setLayoutParams(paramView);
    this.iv_search.setOnClickListener(new SojournHomeFragment.1(this));
    this.K = new f(this.x);
    this.to_minsu_customer_service.setOnClickListener(new SojournHomeFragment.12(this));
    this.lav_home.setOnClickListener(this.U);
  }
  
  private void f()
  {
    this.y = new com.ziroom.ziroomcustomer.minsu.home.c.a(this);
    this.a.register(this.y);
    this.z = com.ziroom.ziroomcustomer.minsu.home.a.a.getInstance(this.a);
  }
  
  private void g()
  {
    if (this.z != null)
    {
      this.z.getMinsuHomeCms(this, this.x);
      this.z.getMinsuHomeServer(this, this.x);
      this.z.getMinSuCouponConfigInfo(this, this.x);
    }
  }
  
  public static SojournHomeFragment getInstance()
  {
    SojournHomeFragment localSojournHomeFragment = new SojournHomeFragment();
    localSojournHomeFragment.setArguments(new Bundle());
    return localSojournHomeFragment;
  }
  
  private void h()
  {
    if (SystemClock.elapsedRealtime() - this.R < 1999L) {}
    do
    {
      return;
      this.R = SystemClock.elapsedRealtime();
    } while (this.z == null);
    this.z.getTodaySpecial(this, this.x);
  }
  
  private void i()
  {
    this.lav_home.setVisibility(8);
    this.F = false;
  }
  
  private void j()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.u, localIntentFilter);
    localIntentFilter = new IntentFilter("action_em_login_succ");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.v, localIntentFilter);
    localIntentFilter = new IntentFilter("action_today_special_load_data");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.w, localIntentFilter);
  }
  
  private void k()
  {
    this.E = null;
    this.z.getMinsuLottieData(this, this.x);
  }
  
  private void l()
  {
    if ((this.P) && (this.Q))
    {
      if (!this.O) {
        break label43;
      }
      g();
      com.ziroom.ziroomcustomer.minsu.d.b.getIntance(this.x);
      this.O = false;
    }
    for (;;)
    {
      d();
      return;
      label43:
      h();
    }
  }
  
  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    if (paramFloat <= 0.0F)
    {
      this.iv_search.setVisibility(0);
      this.iv_search.setAlpha(1.0F);
      this.iv_search.setTranslationY(0.0F);
      return;
    }
    if (paramFloat >= 1.0F)
    {
      this.iv_search.setVisibility(8);
      return;
    }
    if (paramFloat <= 0.85D)
    {
      this.iv_search.setVisibility(0);
      paramFloat = paramFloat / 85.0F * 100.0F;
      this.iv_search.setAlpha(1.0F - paramFloat * (paramFloat * paramFloat));
      return;
    }
    this.iv_search.setVisibility(8);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (paramInt2 >= this.p * 3 / 4)
    {
      this.iv_search.setTranslationY(0.0F);
      return;
    }
    this.iv_search.setTranslationY(-paramInt2);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.J = ButterKnife.bind(this, paramView);
    this.x = getActivity();
    b(paramView);
    f();
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    label771:
    label845:
    label972:
    label1072:
    label1193:
    label1205:
    label1217:
    label1229:
    label1395:
    label1516:
    label1990:
    label2020:
    do
    {
      do
      {
        return;
        if (!parama.equals("home_cms")) {
          break;
        }
        i = 0;
        break;
        if (!parama.equals("home_house")) {
          break;
        }
        i = 1;
        break;
        if (!parama.equals("home_today")) {
          break;
        }
        i = 2;
        break;
        if (!parama.equals("home_landlord_status")) {
          break;
        }
        i = 3;
        break;
        if (!parama.equals("home_cms_error")) {
          break;
        }
        i = 4;
        break;
        if (!parama.equals("home_house_error")) {
          break;
        }
        i = 5;
        break;
        if (!parama.equals("home_today_error")) {
          break;
        }
        i = 6;
        break;
        if (!parama.equals("home_landlord_status_error")) {
          break;
        }
        i = 7;
        break;
        if (!parama.equals("home_coupon_configinfo")) {
          break;
        }
        i = 8;
        break;
        if (!parama.equals("home_coupon_configinfo_error")) {
          break;
        }
        i = 9;
        break;
        if (!parama.equals("home_first_lottie_error")) {
          break;
        }
        i = 10;
        break;
        if (!parama.equals("home_first_lottie")) {
          break;
        }
        i = 11;
        break;
        this.A = this.y.getmHomeCmsBean();
        if ((this.A != null) && (this.A.getData() != null) && (this.A.getData().getBanner() != null) && (!s.isEmpty(this.A.getData().getBanner().getLunbo())))
        {
          this.img_landlord.setVisibility(0);
          parama = x.makeUrl(((a.b)this.A.getData().getBanner().getLunbo().get(0)).getImg());
          com.freelxl.baselibrary.f.c.loadHolderImage(this.img_landlord, parama);
          this.img_landlord.setOnClickListener(new SojournHomeFragment.20(this));
          if ((this.A != null) && (this.A.getData() != null) && (this.A.getData().getSyt() != null))
          {
            this.tv_title_top.setText(this.A.getData().getSyt().getTitle());
            this.g.setText(this.A.getData().getSyt().getSubtitle());
            if (!s.isEmpty(this.A.getData().getSyt().getLunbo()))
            {
              i = ad.getRandom(0, this.A.getData().getSyt().getLunbo().size() - 1);
              parama = (a.b)this.A.getData().getSyt().getLunbo().get(i);
              String str = x.makeUrl(parama.getImg());
              com.freelxl.baselibrary.f.c.loadHolderImage(this.iv_top_banner, str);
              a(parama, this.iv_top_banner);
            }
          }
          if ((this.A == null) || (this.A.getData() == null) || (this.A.getData().getMdd() == null) || (s.isEmpty(this.A.getData().getMdd().getLunbo()))) {
            break label1193;
          }
          this.minsu_home_mdd.setVisibility(0);
          this.minsu_home_mdd.setData(this.A.getData().getMdd().getTitle(), this.A.getData().getMdd().getSubtitle(), null, new SojournHomeFragment.21(this, this.x, this.A.getData().getMdd().getLunbo(), 2130904895, 0.4F));
          if ((this.A == null) || (this.A.getData() == null) || (this.A.getData().getJchd() == null) || (s.isEmpty(this.A.getData().getJchd().getLunbo()))) {
            break label1205;
          }
          this.minsu_home_ad_banner.setVisibility(0);
          a(this.A.getData().getJchd().getLunbo());
          if ((this.A == null) || (this.A.getData() == null) || (this.A.getData().getZry() == null) || (s.isEmpty(this.A.getData().getZry().getLunbo()))) {
            break label1217;
          }
          this.minsu_home_zry.setVisibility(0);
          this.minsu_home_zry.setData(this.A.getData().getZry().getTitle(), this.A.getData().getZry().getSubtitle(), new SojournHomeFragment.22(this), new SojournHomeFragment.23(this, this.x, this.A.getData().getZry().getLunbo(), 2130904896, 1.0F));
          if ((this.A == null) || (this.A.getData() == null) || (this.A.getData().getZryhd() == null) || (s.isEmpty(this.A.getData().getZryhd().getLunbo()))) {
            break label1229;
          }
          this.minsu_home_zryhd.setVisibility(0);
          this.minsu_home_zryhd.setData("", "", null, new SojournHomeFragment.24(this, this.x, this.A.getData().getZryhd().getLunbo(), 2130904895, 1.0F));
        }
        for (;;)
        {
          if ((this.A != null) && (this.A.getData() != null) && (this.A.getData().getQds() != null) && (!s.isEmpty(this.A.getData().getQds().getLunbo())))
          {
            this.minsu_home_qds.setVisibility(0);
            this.M.clear();
            i = 0;
            for (;;)
            {
              if (i < 2)
              {
                this.M.add(this.A.getData().getQds().getLunbo().get(i));
                i += 1;
                continue;
                this.img_landlord.setVisibility(8);
                break;
                this.minsu_home_mdd.setVisibility(8);
                break label771;
                this.minsu_home_ad_banner.setVisibility(8);
                break label845;
                this.minsu_home_zry.setVisibility(8);
                break label972;
                this.minsu_home_zryhd.setVisibility(8);
                break label1072;
              }
            }
            this.minsu_home_qds.setData("", "", null, new SojournHomeFragment.25(this, this.x, this.M, 2130904895, 1.0F));
            if ((this.A == null) || (this.A.getData() == null) || (this.A.getData().getPpg() == null) || (s.isEmpty(this.A.getData().getPpg().getLunbo()))) {
              break label1516;
            }
            this.minsu_home_pinp.setVisibility(0);
            this.minsu_home_pinp.setData(this.A.getData().getPpg().getTitle(), this.A.getData().getPpg().getSubtitle(), null, new SojournHomeFragment.26(this, this.x, this.A.getData().getPpg().getLunbo(), 2130904897, 1.0F));
          }
        }
        for (;;)
        {
          if ((this.A != null) && (this.A.getData() != null) && (this.A.getData().getFdgs() != null) && (!s.isEmpty(this.A.getData().getFdgs().getLunbo())))
          {
            this.minsu_home_story.setVisibility(0);
            this.N.clear();
            i = 0;
            for (;;)
            {
              if (i < 3)
              {
                this.N.add(this.A.getData().getFdgs().getLunbo().get(i));
                i += 1;
                continue;
                this.minsu_home_qds.setVisibility(8);
                break;
                this.minsu_home_pinp.setVisibility(8);
                break label1395;
              }
            }
            parama = new SojournHomeFragment.2(this, this.x, 1, false);
            this.minsu_home_story.setView(parama);
            this.minsu_home_story.getHead_line().setVisibility(8);
            this.minsu_home_story.setData(this.A.getData().getFdgs().getTitle(), this.A.getData().getFdgs().getSubtitle(), new SojournHomeFragment.3(this), new SojournHomeFragment.4(this, this.x, this.N, 2130904906, 0.5F));
            return;
          }
        }
        this.minsu_home_story.setVisibility(8);
        return;
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_HOUSE==  ");
        this.B = this.y.getmHomeHouseBean();
        if ((this.B != null) && (this.B.getData() != null) && (this.B.getData().getTOP50() != null) && (!s.isEmpty(this.B.getData().getTOP50().getList())))
        {
          this.minsu_home_top.setVisibility(0);
          this.minsu_home_top.setTitle(this.B.getData().getTOP50().getTop50ListShareTitle());
          this.minsu_home_top.setData(this.B.getData().getTOP50().getList());
          if ((this.B == null) || (this.B.getData() == null) || (this.B.getData().getTODAYDISCOUNT() == null) || (s.isEmpty(this.B.getData().getTODAYDISCOUNT().getList()))) {
            break label1990;
          }
          this.minsu_home_today.setVisibility(0);
          this.minsu_home_today.setTitle(this.B.getData().getTODAYDISCOUNT().getZhTitle() + "&" + this.B.getData().getTODAYDISCOUNT().getEnTitle());
          a(this.minsu_home_today, this.B.getData().getTODAYDISCOUNT().getList(), 1);
          com.ziroom.ziroomcustomer.minsu.c.c.getInstance().start(this.B.getData().getTODAYDISCOUNT().getList());
        }
        for (;;)
        {
          if ((this.B == null) || (this.B.getData() == null) || (this.B.getData().getMINSUINVENTORY() == null)) {
            break label2020;
          }
          this.minsu_home_inv.setVisibility(0);
          this.minsu_home_inv.setData(this.B.getData().getMINSUINVENTORY());
          this.minsu_home_inv.setMoreClick(new SojournHomeFragment.5(this));
          return;
          this.minsu_home_top.setVisibility(8);
          break;
          this.minsu_home_today.setVisibility(8);
          this.minsu_home_zry.getHead_line().setVisibility(8);
          com.ziroom.ziroomcustomer.minsu.c.c.getInstance().stop();
        }
        this.minsu_home_inv.setVisibility(8);
        return;
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_TODAY==  ");
        com.ziroom.ziroomcustomer.minsu.c.c.getInstance().stop();
        this.C = this.y.getmHomeTodayBean();
        if ((this.C != null) && (this.C.getData() != null) && (this.C.getData().getList() != null) && (!s.isEmpty(this.C.getData().getList())))
        {
          this.minsu_home_today.setVisibility(0);
          this.minsu_home_today.setTitle(this.C.getData().getZhTitle() + "&" + this.C.getData().getEnTitle());
          a(this.minsu_home_today, this.C.getData().getList(), 1);
          com.ziroom.ziroomcustomer.minsu.c.c.getInstance().start(this.C.getData().getList());
          return;
        }
        this.minsu_home_zry.getHead_line().setVisibility(8);
        this.minsu_home_today.setVisibility(8);
        return;
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_LANDLORD_STATUS==  ");
        this.D = this.y.getmHomeLandlordBean();
        if ((this.D != null) && (this.D.getData() != null) && (this.D.getData().getWHETHERLANDLORD() != null))
        {
          this.S = this.D.getData().getWHETHERLANDLORD().getWhetherLandlord();
          this.T = this.D.getData().getWHETHERLANDLORD().getHasOrder();
          if (this.S == 0)
          {
            k.CmsToWebActivity(this.x, (a.b)this.A.getData().getBanner().getLunbo().get(0));
            return;
          }
          k.landlordActivity(this.x);
          return;
        }
        this.minsu_home_today.setVisibility(8);
        return;
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_CMS_ERROR==  ");
        this.minsu_home_pinp.setVisibility(8);
        this.minsu_home_ad_banner.setVisibility(8);
        this.minsu_home_zry.setVisibility(8);
        this.minsu_home_qds.setVisibility(8);
        this.minsu_home_zryhd.setVisibility(8);
        this.minsu_home_mdd.setVisibility(8);
        this.minsu_home_story.setVisibility(8);
        return;
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_SERVER_ERROR==  ");
        this.minsu_home_top.setVisibility(8);
        this.minsu_home_today.setVisibility(8);
        this.minsu_home_inv.setVisibility(8);
        return;
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_TODAY_ERROR==  ");
        this.minsu_home_today.setVisibility(8);
        return;
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_LANDLORD_STATUS_ERROR==  ");
        return;
        i();
        a(this.y.getmHomeCouponConfigInfoBean());
        return;
        i();
        return;
        this.E = null;
        this.I = false;
        return;
        this.E = this.y.getHomeFirstCouponLoginBean();
      } while (!this.I);
      this.I = false;
    } while (this.E == null);
    a(this.E);
  }
  
  protected void c()
  {
    this.o = false;
    super.c();
  }
  
  protected void e()
  {
    super.e();
    com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().clearStack();
    k.toMinsuSearchList(this.x);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    j();
  }
  
  public void onCmdMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.u);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.v);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.w);
    this.J.unbind();
    com.ziroom.ziroomcustomer.minsu.c.c.getInstance().stop();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.y);
    super.onDestroyView();
  }
  
  public void onMessageChanged(EMMessage paramEMMessage, Object paramObject)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
  }
  
  public void onMessageDelivered(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
  }
  
  public void onMessageRead(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
  }
  
  public void onMessageRecalled(List<EMMessage> paramList) {}
  
  public void onMessageReceived(List<EMMessage> paramList)
  {
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
  
  public void onPause()
  {
    super.onPause();
    this.I = false;
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.BACKGROUND)
  public void onReceiveDownLoadEvent(g paramg)
  {
    if ((paramg != null) && (paramg.getStatus() == 1) && ((paramg.getData() instanceof File)))
    {
      paramg = m.unZip(((File)paramg.getData()).getPath(), paramg.getFilePath(), "jsonfile", paramg.getName());
      if (!TextUtils.isEmpty(paramg))
      {
        Message localMessage = new Message();
        localMessage.what = 1;
        localMessage.obj = paramg;
        this.V.sendMessage(localMessage);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.Q = true;
    l();
    com.ziroom.ziroomcustomer.util.j.getInstance().pushActivity(getActivity());
    try
    {
      if (EMClient.getInstance().isLoggedInBefore()) {
        EMClient.getInstance().chatManager().addMessageListener(this);
      }
      com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().clearStack();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        com.freelxl.baselibrary.f.d.e("huanxin", "e = " + localException.getMessage());
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      EMClient.getInstance().chatManager().removeMessageListener(this);
      com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(getActivity());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.freelxl.baselibrary.f.d.e("huanxin", "e = " + localException.getMessage());
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ad.getUserAgent(getActivity());
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean)
  {
    super.onVisibilityChangedToUser(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      this.P = true;
      l();
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().clearStack();
      return;
      if (this.P) {
        this.P = false;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/SojournHomeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */