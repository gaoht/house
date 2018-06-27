package com.ziroom.ziroomcustomer.home;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.a.e;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.findhouse.SearchHouseActivity;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomeRent;
import com.ziroom.ziroomcustomer.home.bean.HomeRent.Cartoon;
import com.ziroom.ziroomcustomer.home.bean.HomeRentItem;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView;
import com.ziroom.ziroomcustomer.home.view.HomeRentItemView.a;
import com.ziroom.ziroomcustomer.home.view.ZiroomerListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.newchat.chatcenter.ChatCenterActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newrepair.mvp.RepairHomeActivity;
import com.ziroom.ziroomcustomer.social.activity.ac.AcMainActivity;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HomePageFragmentChildRent
  extends BaseFragment
{
  private Button A;
  private int B;
  private float C;
  private int D;
  private BroadcastReceiver E = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("select_city")) {
        HomePageFragmentChildRent.a(HomePageFragmentChildRent.this);
      }
    }
  };
  private Context a;
  private HomeRentItemView b;
  private LottieAnimationView c;
  private LottieAnimationView d;
  private HomeRentItemView e;
  private HomeRentItemView f;
  private HomeRentItemView g;
  private HomeRentItemView h;
  private HomeRentItemView i;
  private HomeRentItemView j;
  private HomeRentItemView k;
  private HomeRentItemView l;
  private HomeRentItemView m;
  private ConvenientBanner n;
  private View o;
  private View p;
  private View q;
  private View r;
  private View s;
  private View t;
  private View u;
  private View v;
  private View w;
  private View x;
  private ContentBean y;
  private SearchCondition z;
  
  private void a(View paramView)
  {
    this.b = ((HomeRentItemView)paramView.findViewById(2131694117));
    this.c = ((LottieAnimationView)paramView.findViewById(2131694118));
    this.d = ((LottieAnimationView)paramView.findViewById(2131694119));
    this.e = ((HomeRentItemView)paramView.findViewById(2131694120));
    this.f = ((HomeRentItemView)paramView.findViewById(2131694122));
    this.g = ((HomeRentItemView)paramView.findViewById(2131694124));
    this.h = ((HomeRentItemView)paramView.findViewById(2131694126));
    this.i = ((HomeRentItemView)paramView.findViewById(2131694128));
    this.j = ((HomeRentItemView)paramView.findViewById(2131694130));
    this.l = ((HomeRentItemView)paramView.findViewById(2131694133));
    this.k = ((HomeRentItemView)paramView.findViewById(2131694132));
    this.m = ((HomeRentItemView)paramView.findViewById(2131694134));
    this.n = ((ConvenientBanner)paramView.findViewById(2131690977));
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i1 = (int)((localDisplayMetrics.widthPixels - localDisplayMetrics.density * 36.0F) / 2.5F);
    ((LinearLayout.LayoutParams)this.n.getLayoutParams()).height = i1;
    this.o = paramView.findViewById(2131694079);
    this.p = paramView.findViewById(2131694121);
    this.q = paramView.findViewById(2131694123);
    this.r = paramView.findViewById(2131694125);
    this.s = paramView.findViewById(2131694127);
    this.t = paramView.findViewById(2131694129);
    this.u = paramView.findViewById(2131694131);
    this.v = paramView.findViewById(2131690792);
    this.w = paramView.findViewById(2131694088);
    this.x = paramView.findViewById(2131694090);
    this.A = ((Button)paramView.findViewById(2131694135));
    this.b.setClickable(true);
    this.e.setClickable(true);
    this.f.setClickable(true);
    this.g.setClickable(true);
    this.h.setClickable(true);
    this.i.setClickable(true);
    this.j.setClickable(true);
    this.l.setClickable(true);
    this.k.setClickable(true);
    GrowingIO.setViewContent(this.b, "首页精选专题");
    GrowingIO.setViewContent(this.e, "首页推荐1");
    GrowingIO.setViewContent(this.f, "首页推荐2");
    GrowingIO.setViewContent(this.g, "首页推荐3");
    GrowingIO.setViewContent(this.h, "首页推荐4");
    GrowingIO.setViewContent(this.i, "首页推荐5");
    GrowingIO.setViewContent(this.n, "自如友家整租首页轮播图");
    GrowingIO.setViewContent(this.k, "首页生活服务");
    GrowingIO.setViewContent(this.j, "转租房源推荐");
    GrowingIO.setViewContent(this.l, "周末活动");
    this.z = new SearchCondition();
  }
  
  private void a(HomeRent paramHomeRent)
  {
    if (paramHomeRent != null)
    {
      if ((paramHomeRent.getBrand_img() != null) && (paramHomeRent.getBrand_img().getContent() != null) && (paramHomeRent.getBrand_img().getContent().size() > 0))
      {
        int i1 = (int)(Math.random() * 100.0D);
        int i2 = paramHomeRent.getBrand_img().getContent().size();
        this.y = ((ContentBean)paramHomeRent.getBrand_img().getContent().get(i1 % i2));
        if ((getParentFragment() != null) && (getUserVisibleHint()) && (this.y != null)) {
          ((a)getParentFragment()).onBrandImgReady(this.y);
        }
      }
      if ((getParentFragment() != null) && (paramHomeRent.getBrand_img() != null)) {
        ((a)getParentFragment()).onSearchConditionReady(paramHomeRent.getBrand_img().getMore());
      }
      e(paramHomeRent);
      f(paramHomeRent);
      g(paramHomeRent);
      h(paramHomeRent);
      i(paramHomeRent);
      j(paramHomeRent);
      d(paramHomeRent);
      b(paramHomeRent);
      c(paramHomeRent);
      k(paramHomeRent);
      l(paramHomeRent);
    }
  }
  
  private void b(final HomeRent paramHomeRent)
  {
    if ((this.n != null) && (paramHomeRent.getBanner_center() != null) && (paramHomeRent.getBanner_center().getContent() != null) && (paramHomeRent.getBanner_center().getContent().size() > 0))
    {
      this.n.setVisibility(0);
      this.v.setVisibility(0);
      GrowingIO.setViewContent(this.n, "自如友家整租首页轮播图");
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < paramHomeRent.getBanner_center().getContent().size())
      {
        localArrayList.add(((ContentBean)paramHomeRent.getBanner_center().getContent().get(i1)).getPic());
        i1 += 1;
      }
      this.n.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
      {
        public HomePageFragmentChildRent.b createHolder()
        {
          return new HomePageFragmentChildRent.b(HomePageFragmentChildRent.this, null);
        }
      }, localArrayList, null).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setCoverBottomViewVisible(true).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
      {
        public void onItemClick(int paramAnonymousInt)
        {
          JSONObject localJSONObject = new JSONObject();
          ContentBean localContentBean = (ContentBean)paramHomeRent.getBanner_center().getContent().get(paramAnonymousInt);
          if (localContentBean != null) {}
          try
          {
            localJSONObject.put("position", paramAnonymousInt);
            localJSONObject.put("title", localContentBean.getTitle());
            localJSONObject.put("link", localContentBean.getLink());
            HashMap localHashMap = new HashMap();
            localHashMap.put("title", localContentBean.getTitle());
            localHashMap.put("link", localContentBean.getLink());
            MobclickAgent.onEvent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), "home_rent_banner", localHashMap);
            JsBridgeWebActivity.start(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), localContentBean.getTitle(), localContentBean.getLink(), true, localContentBean.getSubtitle(), localContentBean.getPic(), false);
            GrowingIO.getInstance().track("sy_banner", localJSONObject);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }).setPointViewVisible(true);
      this.n.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      });
      this.n.startTurning(5000L);
      return;
    }
    this.n.setVisibility(8);
    this.v.setVisibility(8);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = null;
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i1)
      {
      default: 
        label76:
        paramString = (String)localObject;
      }
      break;
    }
    while (paramString != null)
    {
      startActivity(paramString);
      return;
      if (!paramString.equals("card_clean")) {
        break label76;
      }
      i1 = 0;
      break label76;
      if (!paramString.equals("move_truck")) {
        break label76;
      }
      i1 = 1;
      break label76;
      if (!paramString.equals("banjia")) {
        break label76;
      }
      i1 = 2;
      break label76;
      if (!paramString.equals("baojie")) {
        break label76;
      }
      i1 = 3;
      break label76;
      if (!paramString.equals("weixiu")) {
        break label76;
      }
      i1 = 4;
      break label76;
      if (!paramString.equals("kefu")) {
        break label76;
      }
      i1 = 5;
      break label76;
      paramString = new Intent(this.a, CleanStoredCardBuyActivity.class);
      continue;
      paramString = new Intent(this.a, MovingIndexActivity.class);
      paramString.putExtra("productCode", "8a90a5f8593e65b501593e65b5200000");
      continue;
      paramString = new Intent(this.a, MoveTypeActivity.class);
      continue;
      paramString = new Intent(this.a, CleanHomeActivity.class);
      continue;
      paramString = new Intent(this.a, RepairHomeActivity.class);
      continue;
      paramString = new Intent(this.a, ChatCenterActivity.class);
    }
  }
  
  private void c()
  {
    u.d("HomePageFragmentChildRent", "=====initData:" + this.D);
    j.getHomeRentChild(this.a, this.D, "rent", new e(this.a, new q(HomeRent.class))
    {
      public void onSuccess(int paramAnonymousInt, HomeRent paramAnonymousHomeRent)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousHomeRent);
        HomePageFragmentChildRent.a(HomePageFragmentChildRent.this, paramAnonymousHomeRent);
      }
    });
  }
  
  private void c(HomeRent paramHomeRent)
  {
    if ((this.l != null) && (paramHomeRent.getActivities_v2() != null) && (paramHomeRent.getActivities_v2().getContent() != null) && (paramHomeRent.getActivities_v2().getContent().size() > 0))
    {
      this.l.setVisibility(0);
      this.x.setVisibility(0);
      HomeRentItem localHomeRentItem = paramHomeRent.getActivities_v2();
      paramHomeRent = null;
      if ("1".equals(localHomeRentItem.getLink())) {
        paramHomeRent = new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), AcMainActivity.class);
            paramAnonymousView.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
            HomePageFragmentChildRent.b(HomePageFragmentChildRent.this).startActivity(paramAnonymousView);
          }
        };
      }
      this.l.setData(localHomeRentItem.getTitle(), localHomeRentItem.getSubtitle(), paramHomeRent, new HomeRentItemView.a(this.a, localHomeRentItem.getContent(), 2130904452)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          paramAnonymousTextView1 = paramAnonymousSimpleDraweeView.getLayoutParams();
          paramAnonymousTextView1.width = n.dip2px(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), 201.0F);
          paramAnonymousTextView1.height = (paramAnonymousTextView1.width * 134 / 201);
          paramAnonymousSimpleDraweeView.setLayoutParams(paramAnonymousTextView1);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null) {
                JsBridgeWebActivity.start(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), paramAnonymousContentBean.getTitle(), paramAnonymousContentBean.getLink(), true, paramAnonymousContentBean.getSubtitle(), paramAnonymousContentBean.getPic(), false);
              }
            }
          });
        }
        
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (HomePageFragmentChildRent.a)paramAnonymousu;
          ContentBean localContentBean = a(paramAnonymousInt);
          String str = x.makeUrl(localContentBean.getPic(), getProportion());
          paramAnonymousu.e.setController(c.frescoController(str));
          paramAnonymousu.b.setVisibility(0);
          paramAnonymousu.b.setText(localContentBean.getTitle());
          if (TextUtils.isEmpty(localContentBean.getSubtitle())) {
            paramAnonymousu.d.setVisibility(8);
          }
          for (;;)
          {
            a(localContentBean, paramAnonymousu.a, paramAnonymousu.e, paramAnonymousu.b, paramAnonymousu.d);
            return;
            paramAnonymousu.d.setText(localContentBean.getSubtitle());
            paramAnonymousu.d.setVisibility(0);
          }
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          return new HomePageFragmentChildRent.a(a(paramAnonymousViewGroup, false));
        }
      });
      return;
    }
    this.l.setVisibility(8);
    this.x.setVisibility(8);
  }
  
  private void d(final HomeRent paramHomeRent)
  {
    if ((this.j != null) && (paramHomeRent.getRooms_turn() != null) && (paramHomeRent.getRooms_turn().getContent() != null) && (paramHomeRent.getRooms_turn().getContent().size() > 0))
    {
      this.u.setVisibility(0);
      this.j.setVisibility(0);
      paramHomeRent = paramHomeRent.getRooms_turn();
      this.j.setData(paramHomeRent.getTitle(), paramHomeRent.getSubtitle(), new View.OnClickListener()new HomeRentItemView.a
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramHomeRent != null)
          {
            paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HouseListActivity.class);
            paramAnonymousView.putExtra("searchCondition", HomePageFragmentChildRent.c(HomePageFragmentChildRent.this));
            paramAnonymousView.putExtra("more", paramHomeRent.getMore());
            HomePageFragmentChildRent.this.startActivity(paramAnonymousView);
          }
        }
      }, new HomeRentItemView.a(this.a, paramHomeRent.getContent(), 2130904222, 0.8F)
      {
        public void onBindViewHolder(RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          paramAnonymousu = (HomePageFragmentChildRent.d)paramAnonymousu;
          final ContentBean localContentBean = a(paramAnonymousInt);
          String str = x.makeUrl(localContentBean.getPic(), getProportion());
          paramAnonymousu.h.setController(c.frescoController(str));
          paramAnonymousu.d.setVisibility(0);
          paramAnonymousu.d.setText(localContentBean.getTitle());
          if (TextUtils.isEmpty(localContentBean.getSubtitle())) {
            paramAnonymousu.f.setVisibility(8);
          }
          for (;;)
          {
            paramAnonymousu.g.setController(c.frescoController(localContentBean.customer_avatar));
            paramAnonymousu.b.setText(localContentBean.getCustomer_name());
            paramAnonymousu.c.setText(localContentBean.getDescribe());
            paramAnonymousu.e.setText(localContentBean.getPin_text());
            paramAnonymousu.a.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (localContentBean != null)
                {
                  paramAnonymous2View = new Intent();
                  paramAnonymous2View.putExtra("house_id", localContentBean.getHouse_id());
                  paramAnonymous2View.putExtra("id", localContentBean.getId());
                  paramAnonymous2View.setClass(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), RentHouseDetailActivity.class);
                  HomePageFragmentChildRent.this.startActivity(paramAnonymous2View);
                }
              }
            });
            return;
            paramAnonymousu.f.setText(localContentBean.getSubtitle());
            paramAnonymousu.f.setVisibility(0);
          }
        }
        
        public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          return new HomePageFragmentChildRent.d(a(paramAnonymousViewGroup, false));
        }
      });
      return;
    }
    this.j.setVisibility(8);
    this.u.setVisibility(8);
  }
  
  private void e(HomeRent paramHomeRent)
  {
    if ((this.b != null) && (paramHomeRent.getRooms() != null) && (paramHomeRent.getRooms().getContent() != null) && (paramHomeRent.getRooms().getContent().size() > 0))
    {
      this.o.setVisibility(0);
      this.b.setVisibility(0);
      HomeRentItem localHomeRentItem = paramHomeRent.getRooms();
      this.b.setData(localHomeRentItem.getTitle(), localHomeRentItem.getSubtitle(), null, new HomeRentItemView.a(this.a, localHomeRentItem.getContent(), 2130904218, 0.4F)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null)
              {
                if ((TextUtils.isEmpty(paramAnonymousContentBean.getRgb())) || (!"minsu".equals(paramAnonymousContentBean.getRgb()))) {
                  break label125;
                }
                paramAnonymous2View = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), MinsuWebActivity.class);
                paramAnonymous2View.putExtra("url", paramAnonymousContentBean.getLink());
                paramAnonymous2View.putExtra("title", paramAnonymousContentBean.getSubtitle());
                paramAnonymous2View.putExtra("shareTitle", paramAnonymousContentBean.getTitle());
                paramAnonymous2View.putExtra("isShowShare", true);
                HomePageFragmentChildRent.b(HomePageFragmentChildRent.this).startActivity(paramAnonymous2View);
              }
              label125:
              do
              {
                do
                {
                  return;
                  if (!"0".equals(paramAnonymousContentBean.getTypes())) {
                    break;
                  }
                } while (!"suggestion_poi".equals(paramAnonymousContentBean.getLink()));
                paramAnonymous2View = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), SearchHouseActivity.class);
                paramAnonymous2View.putExtra("type", 1);
                HomePageFragmentChildRent.b(HomePageFragmentChildRent.this).startActivity(paramAnonymous2View);
                return;
              } while (!"1".equals(paramAnonymousContentBean.getTypes()));
              JsBridgeWebActivity.start(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), paramAnonymousContentBean.getTitle(), paramAnonymousContentBean.getLink(), true, paramAnonymousContentBean.getSubtitle(), paramAnonymousContentBean.getPic(), false);
            }
          });
        }
      });
      if ((paramHomeRent.getCartoon() == null) || (!"1".equals(paramHomeRent.getCartoon().getShowSwitch())))
      {
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        return;
      }
      this.c.setOnClickListener(new c(paramHomeRent.getCartoon().getLink()));
      this.d.setOnClickListener(new c(paramHomeRent.getCartoon().getLink()));
      this.c.setVisibility(0);
      this.c.setAnimation("lottie_home_rent_part1.json");
      this.c.loop(false);
      this.c.playAnimation();
      this.d.setAnimation("lottie_home_rent_part2.json");
      this.d.loop(true);
      this.c.addAnimatorListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          HomePageFragmentChildRent.d(HomePageFragmentChildRent.this).setVisibility(8);
          HomePageFragmentChildRent.e(HomePageFragmentChildRent.this).setVisibility(0);
          HomePageFragmentChildRent.e(HomePageFragmentChildRent.this).playAnimation();
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      return;
    }
    this.b.setVisibility(8);
    this.o.setVisibility(8);
  }
  
  private void f(final HomeRent paramHomeRent)
  {
    if ((this.e != null) && (paramHomeRent.getRecom1() != null) && (paramHomeRent.getRecom1().getContent() != null) && (paramHomeRent.getRecom1().getContent().size() > 0))
    {
      this.p.setVisibility(0);
      this.e.setVisibility(0);
      HomeRentItem localHomeRentItem = paramHomeRent.getRecom1();
      this.e.setData(localHomeRentItem.getTitle(), localHomeRentItem.getSubtitle(), new View.OnClickListener()new HomeRentItemView.a
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramHomeRent.getRecom1() != null)
          {
            paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HouseListActivity.class);
            paramAnonymousView.putExtra("searchCondition", HomePageFragmentChildRent.c(HomePageFragmentChildRent.this));
            paramAnonymousView.putExtra("more", paramHomeRent.getRecom1().getMore());
            HomePageFragmentChildRent.this.startActivity(paramAnonymousView);
          }
        }
      }, new HomeRentItemView.a(this.a, localHomeRentItem.getContent(), 2130904220, 0.8F)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          paramAnonymousTextView1 = paramAnonymousSimpleDraweeView.getLayoutParams();
          paramAnonymousTextView1.width = ((int)(HomePageFragmentChildRent.f(HomePageFragmentChildRent.this) * 0.6F));
          paramAnonymousTextView1.height = ((int)(paramAnonymousTextView1.width / 225.0F * 150.0F));
          paramAnonymousSimpleDraweeView.setLayoutParams(paramAnonymousTextView1);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null)
              {
                paramAnonymous2View = new Intent();
                paramAnonymous2View.putExtra("house_id", paramAnonymousContentBean.getHouse_id());
                paramAnonymous2View.putExtra("id", paramAnonymousContentBean.getId());
                paramAnonymous2View.setClass(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), RentHouseDetailActivity.class);
                HomePageFragmentChildRent.this.startActivity(paramAnonymous2View);
              }
            }
          });
        }
      });
      return;
    }
    this.e.setVisibility(8);
    this.p.setVisibility(8);
  }
  
  private void g(final HomeRent paramHomeRent)
  {
    if ((this.f != null) && (paramHomeRent.getRecom2() != null) && (paramHomeRent.getRecom2().getContent() != null) && (paramHomeRent.getRecom2().getContent().size() > 0))
    {
      this.f.setVisibility(0);
      this.q.setVisibility(0);
      HomeRentItem localHomeRentItem = paramHomeRent.getRecom2();
      this.f.setData(localHomeRentItem.getTitle(), localHomeRentItem.getSubtitle(), new View.OnClickListener()new HomeRentItemView.a
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramHomeRent.getRecom2() != null)
          {
            paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HouseListActivity.class);
            paramAnonymousView.putExtra("searchCondition", HomePageFragmentChildRent.c(HomePageFragmentChildRent.this));
            paramAnonymousView.putExtra("more", paramHomeRent.getRecom2().getMore());
            HomePageFragmentChildRent.this.startActivity(paramAnonymousView);
          }
        }
      }, new HomeRentItemView.a(this.a, localHomeRentItem.getContent(), 2130904220, 0.8F)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          paramAnonymousTextView1 = paramAnonymousSimpleDraweeView.getLayoutParams();
          paramAnonymousTextView1.width = ((int)(HomePageFragmentChildRent.f(HomePageFragmentChildRent.this) * 0.6F));
          paramAnonymousTextView1.height = ((int)(paramAnonymousTextView1.width / 225.0F * 150.0F));
          paramAnonymousSimpleDraweeView.setLayoutParams(paramAnonymousTextView1);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null)
              {
                paramAnonymous2View = new Intent();
                paramAnonymous2View.putExtra("house_id", paramAnonymousContentBean.getHouse_id());
                paramAnonymous2View.putExtra("id", paramAnonymousContentBean.getId());
                paramAnonymous2View.setClass(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), RentHouseDetailActivity.class);
                HomePageFragmentChildRent.this.startActivity(paramAnonymous2View);
              }
            }
          });
        }
      });
      return;
    }
    this.f.setVisibility(8);
    this.q.setVisibility(8);
  }
  
  private void h(final HomeRent paramHomeRent)
  {
    if ((this.g != null) && (paramHomeRent.getRecom3() != null) && (paramHomeRent.getRecom3().getContent() != null) && (paramHomeRent.getRecom3().getContent().size() > 0))
    {
      this.g.setVisibility(0);
      this.r.setVisibility(0);
      HomeRentItem localHomeRentItem = paramHomeRent.getRecom3();
      this.g.setData(localHomeRentItem.getTitle(), localHomeRentItem.getSubtitle(), new View.OnClickListener()new HomeRentItemView.a
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramHomeRent.getRecom3() != null)
          {
            paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HouseListActivity.class);
            paramAnonymousView.putExtra("searchCondition", HomePageFragmentChildRent.c(HomePageFragmentChildRent.this));
            paramAnonymousView.putExtra("more", paramHomeRent.getRecom3().getMore());
            HomePageFragmentChildRent.this.startActivity(paramAnonymousView);
          }
        }
      }, new HomeRentItemView.a(this.a, localHomeRentItem.getContent(), 2130904220, 0.8F)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          paramAnonymousTextView1 = paramAnonymousSimpleDraweeView.getLayoutParams();
          paramAnonymousTextView1.width = ((int)(HomePageFragmentChildRent.f(HomePageFragmentChildRent.this) * 0.6F));
          paramAnonymousTextView1.height = ((int)(paramAnonymousTextView1.width / 225.0F * 150.0F));
          paramAnonymousSimpleDraweeView.setLayoutParams(paramAnonymousTextView1);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null)
              {
                paramAnonymous2View = new Intent();
                paramAnonymous2View.putExtra("house_id", paramAnonymousContentBean.getHouse_id());
                paramAnonymous2View.putExtra("id", paramAnonymousContentBean.getId());
                paramAnonymous2View.setClass(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), RentHouseDetailActivity.class);
                HomePageFragmentChildRent.this.startActivity(paramAnonymous2View);
              }
            }
          });
        }
      });
      return;
    }
    this.g.setVisibility(8);
    this.r.setVisibility(8);
  }
  
  private void i(final HomeRent paramHomeRent)
  {
    if ((this.h != null) && (paramHomeRent.getRecom4() != null) && (paramHomeRent.getRecom4().getContent() != null) && (paramHomeRent.getRecom4().getContent().size() > 0))
    {
      this.h.setVisibility(0);
      this.s.setVisibility(0);
      HomeRentItem localHomeRentItem = paramHomeRent.getRecom4();
      this.h.setData(localHomeRentItem.getTitle(), localHomeRentItem.getSubtitle(), new View.OnClickListener()new HomeRentItemView.a
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramHomeRent.getRecom4() != null)
          {
            if ("1".equals(paramHomeRent.getRecom4().getMore_type())) {
              JsBridgeWebActivity.start(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), paramHomeRent.getRecom4().getTitle(), paramHomeRent.getRecom4().getLink());
            }
          }
          else {
            return;
          }
          paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HouseListActivity.class);
          paramAnonymousView.putExtra("searchCondition", HomePageFragmentChildRent.c(HomePageFragmentChildRent.this));
          paramAnonymousView.putExtra("more", paramHomeRent.getRecom4().getMore());
          HomePageFragmentChildRent.this.startActivity(paramAnonymousView);
        }
      }, new HomeRentItemView.a(this.a, localHomeRentItem.getContent(), 2130904220, 0.8F)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          paramAnonymousTextView1 = paramAnonymousSimpleDraweeView.getLayoutParams();
          paramAnonymousTextView1.width = ((int)(HomePageFragmentChildRent.f(HomePageFragmentChildRent.this) * 0.6F));
          paramAnonymousTextView1.height = ((int)(paramAnonymousTextView1.width / 225.0F * 150.0F));
          paramAnonymousSimpleDraweeView.setLayoutParams(paramAnonymousTextView1);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null)
              {
                paramAnonymous2View = new Intent();
                paramAnonymous2View.putExtra("house_id", paramAnonymousContentBean.getHouse_id());
                paramAnonymous2View.putExtra("id", paramAnonymousContentBean.getId());
                paramAnonymous2View.setClass(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), RentHouseDetailActivity.class);
                HomePageFragmentChildRent.this.startActivity(paramAnonymous2View);
              }
            }
          });
        }
      });
      return;
    }
    this.h.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  private void j(final HomeRent paramHomeRent)
  {
    if ((this.i != null) && (paramHomeRent.getRecom5() != null) && (paramHomeRent.getRecom5().getContent() != null) && (paramHomeRent.getRecom5().getContent().size() > 0))
    {
      this.i.setVisibility(0);
      this.t.setVisibility(0);
      HomeRentItem localHomeRentItem = paramHomeRent.getRecom5();
      this.i.setData(localHomeRentItem.getTitle(), localHomeRentItem.getSubtitle(), new View.OnClickListener()new HomeRentItemView.a
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramHomeRent.getRecom5() != null)
          {
            if ("1".equals(paramHomeRent.getRecom5().getMore_type())) {
              JsBridgeWebActivity.start(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), paramHomeRent.getRecom5().getTitle(), paramHomeRent.getRecom5().getLink());
            }
          }
          else {
            return;
          }
          paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HouseListActivity.class);
          paramAnonymousView.putExtra("searchCondition", HomePageFragmentChildRent.c(HomePageFragmentChildRent.this));
          paramAnonymousView.putExtra("more", paramHomeRent.getRecom5().getMore());
          HomePageFragmentChildRent.this.startActivity(paramAnonymousView);
        }
      }, new HomeRentItemView.a(this.a, localHomeRentItem.getContent(), 2130904220, 0.8F)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          paramAnonymousTextView1 = paramAnonymousSimpleDraweeView.getLayoutParams();
          paramAnonymousTextView1.width = ((int)(HomePageFragmentChildRent.f(HomePageFragmentChildRent.this) * 0.6F));
          paramAnonymousTextView1.height = ((int)(paramAnonymousTextView1.width / 225.0F * 150.0F));
          paramAnonymousSimpleDraweeView.setLayoutParams(paramAnonymousTextView1);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null)
              {
                paramAnonymous2View = new Intent();
                paramAnonymous2View.putExtra("house_id", paramAnonymousContentBean.getHouse_id());
                paramAnonymous2View.putExtra("id", paramAnonymousContentBean.getId());
                paramAnonymous2View.setClass(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), RentHouseDetailActivity.class);
                HomePageFragmentChildRent.this.startActivity(paramAnonymous2View);
              }
            }
          });
        }
      });
      return;
    }
    this.i.setVisibility(8);
    this.t.setVisibility(8);
  }
  
  private void k(HomeRent paramHomeRent)
  {
    if ((this.k != null) && (paramHomeRent.getService() != null) && (paramHomeRent.getService().getContent() != null) && (paramHomeRent.getService().getContent().size() > 0))
    {
      this.k.setVisibility(0);
      this.w.setVisibility(0);
      paramHomeRent = paramHomeRent.getService();
      this.k.setData(paramHomeRent.getTitle(), paramHomeRent.getSubtitle(), null, new HomeRentItemView.a(this.a, paramHomeRent.getContent(), 2130904221, 0.5F)
      {
        protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
        {
          super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
          ViewGroup.LayoutParams localLayoutParams = paramAnonymousSimpleDraweeView.getLayoutParams();
          localLayoutParams.width = ((int)(HomePageFragmentChildRent.f(HomePageFragmentChildRent.this) * 0.44F));
          localLayoutParams.height = ((int)(localLayoutParams.width / 165.0F * 100.0F));
          paramAnonymousSimpleDraweeView.setLayoutParams(localLayoutParams);
          paramAnonymousTextView1.setVisibility(8);
          paramAnonymousTextView2.setVisibility(8);
          paramAnonymousView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (paramAnonymousContentBean != null)
              {
                if (!"0".equals(paramAnonymousContentBean.getTypes())) {
                  break label45;
                }
                HomePageFragmentChildRent.a(HomePageFragmentChildRent.this, paramAnonymousContentBean.getLink());
              }
              label45:
              while (!"1".equals(paramAnonymousContentBean.getTypes())) {
                return;
              }
              paramAnonymous2View = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HomeWebActivity.class);
              paramAnonymous2View.putExtra("ziru", "homeService");
              paramAnonymous2View.putExtra("url", paramAnonymousContentBean.getLink());
              paramAnonymous2View.putExtra("title", paramAnonymousContentBean.getTitle());
              paramAnonymous2View.putExtra("content", paramAnonymousContentBean.getSubtitle());
              paramAnonymous2View.putExtra("pic", paramAnonymousContentBean.getPic());
              HomePageFragmentChildRent.this.startActivity(paramAnonymous2View);
            }
          });
        }
      });
      return;
    }
    this.k.setVisibility(8);
    this.w.setVisibility(8);
  }
  
  private void l(final HomeRent paramHomeRent)
  {
    if ((this.m != null) && (paramHomeRent.getLeaves() != null) && (paramHomeRent.getLeaves().getContent() != null) && (paramHomeRent.getLeaves().getContent().size() > 0))
    {
      this.m.setVisibility(0);
      paramHomeRent = paramHomeRent.getLeaves();
      Object localObject = new LinearLayoutManager(this.a);
      ((LinearLayoutManager)localObject).setOrientation(1);
      this.m.setView((RecyclerView.h)localObject);
      localObject = new ArrayList();
      if ((paramHomeRent.getContent() != null) && (paramHomeRent.getContent().size() <= 3))
      {
        ((List)localObject).addAll(paramHomeRent.getContent());
        this.A.setVisibility(8);
      }
      for (;;)
      {
        this.m.setData(paramHomeRent.getTitle(), paramHomeRent.getSubtitle(), null, new HomeRentItemView.a(this.a, (List)localObject, 2130904602, 0.5F)
        {
          protected void a(final ContentBean paramAnonymousContentBean, View paramAnonymousView, SimpleDraweeView paramAnonymousSimpleDraweeView, TextView paramAnonymousTextView1, TextView paramAnonymousTextView2)
          {
            super.a(paramAnonymousContentBean, paramAnonymousView, paramAnonymousSimpleDraweeView, paramAnonymousTextView1, paramAnonymousTextView2);
            paramAnonymousTextView1 = paramAnonymousSimpleDraweeView.getLayoutParams();
            paramAnonymousTextView1.width = ((int)(HomePageFragmentChildRent.f(HomePageFragmentChildRent.this) * 0.48F));
            paramAnonymousTextView1.height = ((int)(paramAnonymousTextView1.width / 3.0F * 2.0F));
            paramAnonymousSimpleDraweeView.setLayoutParams(paramAnonymousTextView1);
            paramAnonymousView.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (paramAnonymousContentBean != null)
                {
                  paramAnonymous2View = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), HomeWebActivity.class);
                  paramAnonymous2View.putExtra("url", paramAnonymousContentBean.getLink());
                  paramAnonymous2View.putExtra("title", paramAnonymousContentBean.getTitle());
                  paramAnonymous2View.putExtra("content", paramAnonymousContentBean.getSubtitle());
                  paramAnonymous2View.putExtra("pic", paramAnonymousContentBean.getPic());
                  paramAnonymous2View.putExtra("ziru", "homeService");
                  HomePageFragmentChildRent.b(HomePageFragmentChildRent.this).startActivity(paramAnonymous2View);
                }
              }
            });
          }
        });
        this.A.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), ZiroomerListActivity.class);
            paramAnonymousView.putExtra("ziroomers", (Serializable)paramHomeRent.getContent());
            paramAnonymousView.putExtra("title", paramHomeRent.getTitle());
            HomePageFragmentChildRent.b(HomePageFragmentChildRent.this).startActivity(paramAnonymousView);
          }
        });
        return;
        if (paramHomeRent.getContent() != null)
        {
          ((List)localObject).addAll(paramHomeRent.getContent().subList(0, 3));
          this.A.setVisibility(0);
        }
      }
    }
    this.m.setVisibility(8);
    this.A.setVisibility(8);
  }
  
  public static HomePageFragmentChildRent newInstance(int paramInt)
  {
    u.d("HomePageFragmentChildRent", "=====" + paramInt);
    HomePageFragmentChildRent localHomePageFragmentChildRent = new HomePageFragmentChildRent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localHomePageFragmentChildRent.setArguments(localBundle);
    return localHomePageFragmentChildRent;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.a = paramContext;
    paramContext = getResources().getDisplayMetrics();
    this.B = paramContext.widthPixels;
    this.C = paramContext.density;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.D = getArguments().getInt("type", 1);
    paramBundle = GrowingIO.getInstance();
    paramBundle.setPageGroup(this, "YZHomePage");
    paramBundle.setPS3(this, com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
    paramBundle.setPS4(this, "首页");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    u.d("HomePageFragmentChildRent", "=====onCreateView:" + this.D);
    paramLayoutInflater = View.inflate(getActivity(), 2130903920, null);
    paramViewGroup = new IntentFilter();
    paramViewGroup.addAction("select_city");
    getActivity().registerReceiver(this.E, paramViewGroup);
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if ((getActivity() != null) && (this.E != null)) {
      getActivity().unregisterReceiver(this.E);
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getParentFragment() != null) && (getUserVisibleHint()) && (this.y != null)) {
      ((a)getParentFragment()).onBrandImgReady(this.y);
    }
  }
  
  public static class a
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected TextView d;
    protected SimpleDraweeView e;
    
    public a(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131689541));
      this.d = ((TextView)paramView.findViewById(2131690071));
      this.c = ((TextView)paramView.findViewById(2131692733));
      this.e = ((SimpleDraweeView)paramView.findViewById(2131691098));
    }
  }
  
  private class b
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private b() {}
    
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
  
  private class c
    implements View.OnClickListener
  {
    private String b;
    
    public c(String paramString)
    {
      this.b = paramString;
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      if (TextUtils.isEmpty(this.b)) {
        return;
      }
      JsBridgeWebActivity.start(HomePageFragmentChildRent.b(HomePageFragmentChildRent.this), "", this.b);
    }
  }
  
  public static class d
    extends RecyclerView.u
  {
    protected View a;
    protected TextView b;
    protected TextView c;
    protected TextView d;
    protected TextView e;
    protected TextView f;
    protected SimpleDraweeView g;
    protected SimpleDraweeView h;
    
    public d(View paramView)
    {
      super();
      this.a = paramView;
      this.d = ((TextView)paramView.findViewById(2131689541));
      this.f = ((TextView)paramView.findViewById(2131690071));
      this.b = ((TextView)paramView.findViewById(2131691821));
      this.c = ((TextView)paramView.findViewById(2131695052));
      this.e = ((TextView)paramView.findViewById(2131692733));
      this.h = ((SimpleDraweeView)paramView.findViewById(2131691098));
      this.g = ((SimpleDraweeView)paramView.findViewById(2131690070));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/HomePageFragmentChildRent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */