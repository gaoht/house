package com.ziroom.ziroomcustomer.ziroomapartment.zramain;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnScrollChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientOptiBanner;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.ContentBean.SmallPic;
import com.ziroom.ziroomcustomer.home.bean.HomeRentItem;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView.a;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.BannerBean.LunboBeanXXX;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.HeadBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.HeadBean.LunboBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.IconBean.LunboBeanX;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuProjectListOptiActivity;
import java.util.ArrayList;
import java.util.List;

public class ZraMainActivity
  extends BaseActivity
  implements a.b
{
  a.a a;
  Context b;
  @BindView(2131697853)
  TextView btnZryuMainSeeMoreZryu;
  @BindView(2131691146)
  ConvenientOptiBanner cbZryuMainLunbo;
  @BindView(2131691153)
  HomeRentItemView hrivZryuMainMoreZryu;
  @BindView(2131691144)
  HomeRentItemView hrivZryuMainRecomHouseType;
  @BindView(2131697852)
  HomeRentItemView hrivZryuMainRecomZryu;
  @BindView(2131691151)
  HomeRentItemView hrivZryuMainSocialAc;
  @BindView(2131691149)
  HomeRentItemView hrivZryuMainYuPerson;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131697840)
  LinearLayout llZryuMainBannerActivity;
  @BindView(2131697846)
  LinearLayout llZryuMainBannerLife;
  @BindView(2131697843)
  LinearLayout llZryuMainBannerPerson;
  @BindView(2131697849)
  LinearLayout llZryuMainBannerService;
  @BindView(2131697856)
  LinearLayout llZryuMainSeeAllZryu;
  @BindView(2131697859)
  LinearLayout llZryuMainTopSearch;
  @BindView(2131697858)
  RelativeLayout rlTopBasement;
  @BindView(2131697841)
  SimpleDraweeView sdvZryuMainBannerActivity;
  @BindView(2131697847)
  SimpleDraweeView sdvZryuMainBannerLife;
  @BindView(2131697844)
  SimpleDraweeView sdvZryuMainBannerPerson;
  @BindView(2131697850)
  SimpleDraweeView sdvZryuMainBannerService;
  @BindView(2131697854)
  SimpleDraweeView sdvZryuMainTopPic;
  @BindView(2131691143)
  ScrollView svZraMain;
  @BindView(2131697860)
  TextView tvSearchTip;
  @BindView(2131697861)
  TextView tvTitleRight;
  @BindView(2131690796)
  TextView tvZiruyuEmail;
  @BindView(2131690797)
  TextView tvZiruyuTel;
  @BindView(2131697842)
  TextView tvZryuMainBannerActivity;
  @BindView(2131697848)
  TextView tvZryuMainBannerLife;
  @BindView(2131697845)
  TextView tvZryuMainBannerPerson;
  @BindView(2131697851)
  TextView tvZryuMainBannerService;
  @BindView(2131695872)
  TextView tvZryuMainSubtitle;
  @BindView(2131697855)
  TextView tvZryuMainTitle;
  @BindView(2131697857)
  TextView tvZryuMainTotal;
  @BindView(2131691147)
  View viewLunboBelow;
  @BindView(2131691154)
  View viewMoreZryuBelow;
  @BindView(2131691145)
  View viewRecomHouseTypeBelow;
  @BindView(2131691148)
  View viewRecommendZryuBelow;
  @BindView(2131691152)
  View viewSocialAcBelow;
  @BindView(2131691150)
  View viewYuPersonBelow;
  
  private void a()
  {
    this.cbZryuMainLunbo.setClickable(true);
    b();
  }
  
  private void a(LinearLayout paramLinearLayout, SimpleDraweeView paramSimpleDraweeView, TextView paramTextView, final ZraMainBean.IconBean.LunboBeanX paramLunboBeanX)
  {
    paramSimpleDraweeView.setController(c.frescoController(x.makeUrl(paramLunboBeanX.img)));
    paramTextView.setText(paramLunboBeanX.title);
    paramLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZraMainActivity.a(ZraMainActivity.this, paramLunboBeanX.app, paramLunboBeanX.target, paramLunboBeanX.title, true, paramLunboBeanX.img, paramLunboBeanX.description);
      }
    });
  }
  
  private void a(SimpleDraweeView paramSimpleDraweeView, TextView paramTextView, String paramString1, String paramString2)
  {
    paramSimpleDraweeView.setController(c.frescoController(x.makeUrl(paramString1, 1.0F)));
    paramTextView.setText(paramString2);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    if ("0".equals(paramString1)) {
      JsBridgeWebActivity.start(this.b, paramString3, paramString2, paramBoolean, paramString5, paramString4, false);
    }
    do
    {
      return;
      if ("1".equals(paramString1))
      {
        com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(this.b, paramString2);
        return;
      }
    } while (!"3".equals(paramString1));
  }
  
  private void b()
  {
    this.svZraMain.setOnScrollChangeListener(new View.OnScrollChangeListener()
    {
      public void onScrollChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        float f = paramAnonymousInt2 / n.dip2px(ZraMainActivity.this.b, 170.0F);
        ZraMainActivity.this.tvZryuMainTotal.setText(paramAnonymousInt2 + "");
        ZraMainActivity.this.tvZryuMainTitle.setAlpha(1.0F - f);
        ZraMainActivity.this.tvZryuMainSubtitle.setAlpha(1.0F - f);
        paramAnonymousView = (LinearLayout.LayoutParams)ZraMainActivity.this.llZryuMainSeeAllZryu.getLayoutParams();
        paramAnonymousView.setMargins((int)(n.dip2px(ZraMainActivity.this.b, 27.0F) * f), 0, 0, 0);
        ZraMainActivity.this.llZryuMainSeeAllZryu.setLayoutParams(paramAnonymousView);
        if (f > 0.9D)
        {
          ZraMainActivity.this.rlTopBasement.setAlpha(1.0F);
          ZraMainActivity.this.tvTitleRight.setTextColor(ZraMainActivity.this.getResources().getColor(2131624597));
          ZraMainActivity.this.ivBack.setImageResource(2130840141);
          return;
        }
        ZraMainActivity.this.rlTopBasement.setAlpha(0.0F);
        ZraMainActivity.this.ivBack.setImageResource(2130840142);
        ZraMainActivity.this.tvTitleRight.setTextColor(ZraMainActivity.this.getResources().getColor(2131624583));
      }
    });
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903253);
    ButterKnife.bind(this);
    this.b = this;
    a();
    this.a = new b(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.start();
  }
  
  @OnClick({2131697859, 2131697856, 2131697840, 2131697843, 2131697846, 2131697849, 2131697853, 2131689492, 2131697861})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131697859: 
      af.showToast(this, "跳首页搜索");
      return;
    case 2131697856: 
      paramView = new Intent(this.b, ZryuProjectListOptiActivity.class);
      if (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) {
        paramView.putExtra("citycode", com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode());
      }
      this.b.startActivity(paramView);
      return;
    case 2131697840: 
      af.showToast(this.b, "到寓活动");
      return;
    case 2131697843: 
      af.showToast(this.b, "到寓人物");
      return;
    case 2131697846: 
      af.showToast(this.b, "到寓生活");
      return;
    case 2131697849: 
      af.showToast(this.b, "到寓服务");
      return;
    case 2131697853: 
      paramView = new Intent(this.b, ZryuProjectListOptiActivity.class);
      if (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) {
        paramView.putExtra("citycode", com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode());
      }
      this.b.startActivity(paramView);
      return;
    case 2131689492: 
      finish();
      return;
    }
    af.showToast(this.b, "打开秒懂");
  }
  
  public void setPresenter(a.a parama) {}
  
  public void showBanner(List<ZraMainBean.IconBean.LunboBeanX> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      if (i < paramList.size())
      {
        switch (i)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          a(this.llZryuMainBannerActivity, this.sdvZryuMainBannerActivity, this.tvZryuMainBannerActivity, (ZraMainBean.IconBean.LunboBeanX)paramList.get(i));
          continue;
          a(this.llZryuMainBannerPerson, this.sdvZryuMainBannerPerson, this.tvZryuMainBannerPerson, (ZraMainBean.IconBean.LunboBeanX)paramList.get(i));
          continue;
          a(this.llZryuMainBannerLife, this.sdvZryuMainBannerLife, this.tvZryuMainBannerLife, (ZraMainBean.IconBean.LunboBeanX)paramList.get(i));
          continue;
          a(this.llZryuMainBannerService, this.sdvZryuMainBannerService, this.tvZryuMainBannerService, (ZraMainBean.IconBean.LunboBeanX)paramList.get(i));
        }
      }
    }
  }
  
  public void showBusinessInfo(String paramString1, String paramString2)
  {
    this.tvZiruyuEmail.setText("邮箱：" + paramString1);
    this.tvZiruyuTel.setText("联系电话：" + paramString2);
  }
  
  public void showLunboAd(final List<ZraMainBean.BannerBean.LunboBeanXXX> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.cbZryuMainLunbo.setVisibility(8);
      this.viewLunboBelow.setVisibility(8);
      return;
    }
    this.cbZryuMainLunbo.setVisibility(0);
    this.viewLunboBelow.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(x.makeUrl(((ZraMainBean.BannerBean.LunboBeanXXX)paramList.get(i)).img));
      i += 1;
    }
    this.cbZryuMainLunbo.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public ZraMainActivity.a createHolder()
      {
        return new ZraMainActivity.a(ZraMainActivity.this, null);
      }
    }, localArrayList).setPageIndicator(new int[] { 2130839327, 2130839326 }).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        ZraMainBean.BannerBean.LunboBeanXXX localLunboBeanXXX = (ZraMainBean.BannerBean.LunboBeanXXX)paramList.get(paramAnonymousInt);
        ZraMainActivity.a(ZraMainActivity.this, localLunboBeanXXX.app, localLunboBeanXXX.target, localLunboBeanXXX.title, true, localLunboBeanXXX.img, localLunboBeanXXX.description);
      }
    }).setPointViewVisible(true);
    this.cbZryuMainLunbo.startTurning(5000L);
  }
  
  public void showMoreZra(HomeRentItem paramHomeRentItem)
  {
    if ((this.hrivZryuMainMoreZryu != null) && (paramHomeRentItem != null) && (paramHomeRentItem.getContent() != null) && (paramHomeRentItem.getContent().size() > 0))
    {
      this.viewMoreZryuBelow.setVisibility(0);
      this.hrivZryuMainMoreZryu.setVisibility(0);
      this.hrivZryuMainMoreZryu.setData(paramHomeRentItem.getTitle(), paramHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this.b, paramHomeRentItem.getContent(), 2130904614, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (ZraMainActivity.b)paramAnonymousu;
          final ContentBean localContentBean = a(paramAnonymousInt);
          String str = x.makeUrl(localContentBean.getPic(), getProportion());
          paramAnonymousu.e.setController(c.frescoController(str));
          paramAnonymousu.c.setVisibility(0);
          paramAnonymousu.c.setText(localContentBean.getTitle());
          if (TextUtils.isEmpty(localContentBean.getSubtitle()))
          {
            paramAnonymousu.d.setVisibility(8);
            if (!TextUtils.isEmpty(localContentBean.price)) {
              break label132;
            }
            paramAnonymousu.b.setVisibility(8);
          }
          for (;;)
          {
            paramAnonymousu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (localContentBean != null) {
                  ZraMainActivity.a(ZraMainActivity.this, localContentBean.getType(), localContentBean.getLink(), localContentBean.getShare_title(), true, localContentBean.getPic(), localContentBean.getShare_content());
                }
              }
            });
            return;
            paramAnonymousu.d.setText(localContentBean.getSubtitle());
            paramAnonymousu.d.setVisibility(0);
            break;
            label132:
            paramAnonymousu.b.setText(localContentBean.price);
            paramAnonymousu.b.setVisibility(0);
          }
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          return new ZraMainActivity.b(a(paramAnonymousViewGroup, false));
        }
      });
      return;
    }
    this.hrivZryuMainMoreZryu.setVisibility(8);
    this.viewMoreZryuBelow.setVisibility(8);
  }
  
  public void showPerson(HomeRentItem paramHomeRentItem)
  {
    if ((this.hrivZryuMainYuPerson != null) && (paramHomeRentItem != null) && (paramHomeRentItem.getContent() != null) && (paramHomeRentItem.getContent().size() > 0))
    {
      this.viewYuPersonBelow.setVisibility(0);
      this.hrivZryuMainYuPerson.setVisibility(0);
      this.hrivZryuMainYuPerson.setData(paramHomeRentItem.getTitle(), paramHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this.b, paramHomeRentItem.getContent(), 2130904618, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (ZraMainActivity.f)paramAnonymousu;
          final ContentBean localContentBean = a(paramAnonymousInt);
          String str1 = x.makeUrl(localContentBean.getPic(), getProportion());
          String str2 = x.makeUrl(localContentBean.headPic, getProportion());
          paramAnonymousu.d.setController(c.frescoController(str1));
          paramAnonymousu.e.setController(c.frescoController(str2));
          paramAnonymousu.b.setVisibility(0);
          paramAnonymousu.b.setText(localContentBean.getTitle());
          if (TextUtils.isEmpty(localContentBean.getSubtitle())) {
            paramAnonymousu.c.setVisibility(8);
          }
          for (;;)
          {
            paramAnonymousu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (localContentBean != null) {
                  ZraMainActivity.a(ZraMainActivity.this, localContentBean.getType(), localContentBean.getLink(), localContentBean.getShare_title(), true, localContentBean.getPic(), localContentBean.getShare_content());
                }
              }
            });
            return;
            paramAnonymousu.c.setText(localContentBean.getSubtitle());
            paramAnonymousu.c.setVisibility(0);
          }
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          return new ZraMainActivity.f(a(paramAnonymousViewGroup, false));
        }
      });
      return;
    }
    this.hrivZryuMainYuPerson.setVisibility(8);
    this.viewYuPersonBelow.setVisibility(8);
  }
  
  public void showRecommendApartment(HomeRentItem paramHomeRentItem)
  {
    if ((this.hrivZryuMainRecomZryu != null) && (paramHomeRentItem != null) && (paramHomeRentItem.getContent() != null) && (paramHomeRentItem.getContent().size() > 0))
    {
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.b);
      localLinearLayoutManager.setOrientation(1);
      this.hrivZryuMainRecomZryu.setView(localLinearLayoutManager);
      this.viewRecommendZryuBelow.setVisibility(0);
      this.hrivZryuMainRecomZryu.setVisibility(0);
      this.hrivZryuMainRecomZryu.setData(paramHomeRentItem.getTitle(), paramHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this.b, paramHomeRentItem.getContent(), 2130904616, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (ZraMainActivity.d)paramAnonymousu;
          final ContentBean localContentBean = a(paramAnonymousInt);
          String str = x.makeUrl(localContentBean.getPic(), getProportion());
          paramAnonymousu.b.setController(c.frescoController(str));
          paramAnonymousu.c.setText(localContentBean.getTitle());
          paramAnonymousu.d.setText(localContentBean.titleTag);
          paramAnonymousu.e.setText(localContentBean.subtitle);
          paramAnonymousu.f.setText(localContentBean.price);
          if ((localContentBean.smallList != null) && (localContentBean.smallList.size() > 0))
          {
            paramAnonymousu.g.setVisibility(0);
            paramAnonymousu.h.setVisibility(0);
            paramAnonymousu.i.setVisibility(0);
            paramAnonymousu.l.setVisibility(0);
            paramAnonymousu.j.setVisibility(0);
            paramAnonymousu.m.setVisibility(0);
            paramAnonymousu.k.setVisibility(0);
            paramAnonymousu.n.setVisibility(0);
            int i = 0;
            if (i < localContentBean.smallList.size())
            {
              switch (i)
              {
              }
              for (;;)
              {
                i += 1;
                break;
                ZraMainActivity.a(ZraMainActivity.this, paramAnonymousu.i, paramAnonymousu.l, ((ContentBean.SmallPic)localContentBean.smallList.get(i)).smaPic, ((ContentBean.SmallPic)localContentBean.smallList.get(i)).smaTitle);
                continue;
                ZraMainActivity.a(ZraMainActivity.this, paramAnonymousu.j, paramAnonymousu.m, ((ContentBean.SmallPic)localContentBean.smallList.get(i)).smaPic, ((ContentBean.SmallPic)localContentBean.smallList.get(i)).smaTitle);
                continue;
                ZraMainActivity.a(ZraMainActivity.this, paramAnonymousu.k, paramAnonymousu.n, ((ContentBean.SmallPic)localContentBean.smallList.get(i)).smaPic, ((ContentBean.SmallPic)localContentBean.smallList.get(i)).smaTitle);
              }
            }
            switch (localContentBean.smallList.size())
            {
            default: 
              if (paramAnonymousInt == getItemCount() - 1) {
                paramAnonymousu.o.setVisibility(8);
              }
              break;
            }
          }
          for (;;)
          {
            paramAnonymousu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (localContentBean != null) {
                  ZraMainActivity.a(ZraMainActivity.this, localContentBean.getType(), localContentBean.getLink(), localContentBean.getShare_title(), true, localContentBean.getPic(), localContentBean.getShare_content());
                }
              }
            });
            return;
            paramAnonymousu.j.setVisibility(8);
            paramAnonymousu.m.setVisibility(8);
            paramAnonymousu.k.setVisibility(8);
            paramAnonymousu.n.setVisibility(8);
            break;
            paramAnonymousu.k.setVisibility(8);
            paramAnonymousu.n.setVisibility(8);
            break;
            paramAnonymousu.g.setVisibility(8);
            paramAnonymousu.h.setVisibility(8);
            break;
            paramAnonymousu.o.setVisibility(0);
          }
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          return new ZraMainActivity.d(a(paramAnonymousViewGroup, false));
        }
      });
      return;
    }
    this.hrivZryuMainRecomZryu.setVisibility(8);
    this.viewRecommendZryuBelow.setVisibility(8);
  }
  
  public void showRecommendHouseType(HomeRentItem paramHomeRentItem)
  {
    if ((this.hrivZryuMainRecomHouseType != null) && (paramHomeRentItem != null) && (paramHomeRentItem.getContent() != null) && (paramHomeRentItem.getContent().size() > 0))
    {
      this.viewRecomHouseTypeBelow.setVisibility(0);
      this.hrivZryuMainRecomHouseType.setVisibility(0);
      this.hrivZryuMainRecomHouseType.setData(paramHomeRentItem.getTitle(), paramHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this.b, paramHomeRentItem.getContent(), 2130904615, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (ZraMainActivity.c)paramAnonymousu;
          final ContentBean localContentBean = a(paramAnonymousInt);
          String str = x.makeUrl(localContentBean.getPic(), getProportion());
          paramAnonymousu.e.setController(c.frescoController(str));
          paramAnonymousu.c.setVisibility(0);
          paramAnonymousu.c.setText(localContentBean.getTitle());
          if (TextUtils.isEmpty(localContentBean.getSubtitle()))
          {
            paramAnonymousu.d.setVisibility(8);
            if (!TextUtils.isEmpty(localContentBean.price)) {
              break label132;
            }
            paramAnonymousu.b.setVisibility(8);
          }
          for (;;)
          {
            paramAnonymousu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (localContentBean != null) {
                  ZraMainActivity.a(ZraMainActivity.this, localContentBean.getType(), localContentBean.getLink(), localContentBean.getShare_title(), true, localContentBean.getPic(), localContentBean.getShare_content());
                }
              }
            });
            return;
            paramAnonymousu.d.setText(localContentBean.getSubtitle());
            paramAnonymousu.d.setVisibility(0);
            break;
            label132:
            paramAnonymousu.b.setText(localContentBean.price);
            paramAnonymousu.b.setVisibility(0);
          }
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          return new ZraMainActivity.c(a(paramAnonymousViewGroup, false));
        }
      });
      return;
    }
    this.hrivZryuMainRecomHouseType.setVisibility(8);
    this.viewRecomHouseTypeBelow.setVisibility(8);
  }
  
  public void showSocialAc(HomeRentItem paramHomeRentItem)
  {
    if ((this.hrivZryuMainSocialAc != null) && (paramHomeRentItem != null) && (paramHomeRentItem.getContent() != null) && (paramHomeRentItem.getContent().size() > 0))
    {
      this.viewSocialAcBelow.setVisibility(0);
      this.hrivZryuMainSocialAc.setVisibility(0);
      this.hrivZryuMainSocialAc.setData(paramHomeRentItem.getTitle(), paramHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this.b, paramHomeRentItem.getContent(), 2130904617, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (ZraMainActivity.e)paramAnonymousu;
          final ContentBean localContentBean = a(paramAnonymousInt);
          String str = x.makeUrl(localContentBean.getPic(), getProportion());
          paramAnonymousu.d.setController(c.frescoController(str));
          paramAnonymousu.b.setVisibility(0);
          paramAnonymousu.b.setText(localContentBean.getTitle());
          if (TextUtils.isEmpty(localContentBean.getSubtitle())) {
            paramAnonymousu.c.setVisibility(8);
          }
          for (;;)
          {
            paramAnonymousu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (localContentBean != null) {
                  ZraMainActivity.a(ZraMainActivity.this, localContentBean.getType(), localContentBean.getLink(), localContentBean.getShare_title(), true, localContentBean.getPic(), localContentBean.getShare_content());
                }
              }
            });
            return;
            paramAnonymousu.c.setText(localContentBean.getSubtitle());
            paramAnonymousu.c.setVisibility(0);
          }
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          return new ZraMainActivity.e(a(paramAnonymousViewGroup, false));
        }
      });
      return;
    }
    this.hrivZryuMainSocialAc.setVisibility(8);
    this.viewSocialAcBelow.setVisibility(8);
  }
  
  public void showTop(final ZraMainBean.HeadBean paramHeadBean)
  {
    this.sdvZryuMainTopPic.setController(c.frescoController(x.makeUrl(paramHeadBean.lunbo.img)));
    this.sdvZryuMainTopPic.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = ZraMainActivity.this;
        String str1 = paramHeadBean.lunbo.app;
        String str2 = paramHeadBean.lunbo.target;
        String str3 = paramHeadBean.lunbo.title;
        if (paramHeadBean.lunbo.allBoolParamas != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ZraMainActivity.a(paramAnonymousView, str1, str2, str3, bool, paramHeadBean.lunbo.img, paramHeadBean.lunbo.description);
          return;
        }
      }
    });
    this.tvZryuMainTitle.setText(paramHeadBean.title);
    this.tvZryuMainSubtitle.setText(paramHeadBean.subtitle);
    this.tvZryuMainTotal.setText(paramHeadBean.projectNums);
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
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
      return this.b;
    }
  }
  
  public static class b
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected TextView d;
    protected SimpleDraweeView e;
    
    public b(View paramView)
    {
      super();
      this.a = paramView;
      this.c = ((TextView)paramView.findViewById(2131689541));
      this.d = ((TextView)paramView.findViewById(2131690071));
      this.b = ((TextView)paramView.findViewById(2131690073));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131691098));
    }
  }
  
  public static class c
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected TextView d;
    protected SimpleDraweeView e;
    
    public c(View paramView)
    {
      super();
      this.a = paramView;
      this.c = ((TextView)paramView.findViewById(2131689541));
      this.d = ((TextView)paramView.findViewById(2131690071));
      this.b = ((TextView)paramView.findViewById(2131690073));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131691098));
    }
  }
  
  public static class d
    extends RecyclerView.u
  {
    protected View a;
    protected SimpleDraweeView b;
    protected TextView c;
    protected TextView d;
    protected TextView e;
    protected TextView f;
    protected ImageView g;
    protected LinearLayout h;
    protected SimpleDraweeView i;
    protected SimpleDraweeView j;
    protected SimpleDraweeView k;
    protected TextView l;
    protected TextView m;
    protected TextView n;
    protected View o;
    
    public d(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((SimpleDraweeView)paramView.findViewById(2131695869));
      this.c = ((TextView)paramView.findViewById(2131695870));
      this.d = ((TextView)paramView.findViewById(2131695871));
      this.e = ((TextView)paramView.findViewById(2131695872));
      this.f = ((TextView)paramView.findViewById(2131695873));
      this.g = ((ImageView)paramView.findViewById(2131695874));
      this.h = ((LinearLayout)paramView.findViewById(2131695875));
      this.i = ((SimpleDraweeView)paramView.findViewById(2131695876));
      this.j = ((SimpleDraweeView)paramView.findViewById(2131695878));
      this.k = ((SimpleDraweeView)paramView.findViewById(2131695880));
      this.l = ((TextView)paramView.findViewById(2131695877));
      this.m = ((TextView)paramView.findViewById(2131695879));
      this.n = ((TextView)paramView.findViewById(2131695881));
      this.o = paramView.findViewById(2131695882);
    }
  }
  
  public static class e
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected SimpleDraweeView d;
    
    public e(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131689541));
      this.c = ((TextView)paramView.findViewById(2131690071));
      this.d = ((SimpleDraweeView)paramView.findViewById(2131691098));
    }
  }
  
  public static class f
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected SimpleDraweeView d;
    protected SimpleDraweeView e;
    
    public f(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131689541));
      this.c = ((TextView)paramView.findViewById(2131690071));
      this.d = ((SimpleDraweeView)paramView.findViewById(2131691098));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131692685));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/zramain/ZraMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */