package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.threelib.ziroomshare.c.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailConfigBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseIsCollectResutBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseIsCollectResutBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.HouseTopInfoVoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.HouseTopInfoVoBean.HouseTopColumnVoListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.ListCheckRuleVoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.ListHouseFacServBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.ListHouseFacServBean.SubEnumValsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.ListHouseFacilitiesBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.PicDisListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.TenantEvalVoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MsHistorySBean;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinsuTopHouseDetailLiteActivity
  extends BaseActivity
{
  private float A;
  private int B;
  private int C = 0;
  private Context a;
  private String b;
  @BindView(2131690078)
  ImageView btn_back;
  @BindView(2131691394)
  ImageView btn_collect;
  @BindView(2131691363)
  TextView btn_confirm;
  @BindView(2131691381)
  View btn_eva_all;
  @BindView(2131691386)
  View btn_fac_all;
  @BindView(2131691362)
  View btn_landlord_call;
  @BindView(2131691390)
  View btn_rule_unfold;
  @BindView(2131691393)
  ImageView btn_share;
  private int c;
  private String d;
  private String e;
  private boolean f;
  @BindView(2131691369)
  FlowLayout fl_image_tag;
  private boolean g = false;
  @BindView(2131691387)
  LinearLayout ll_fac_container;
  @BindView(2131691388)
  ListViewForScrollView lv_rule;
  @BindView(2131691365)
  ObservableScrollView osv_main;
  private MinsuTopHouseDetailBean r;
  @BindView(2131691379)
  RelativeLayout rl_eva_container;
  @BindView(2131691392)
  View rl_title_container;
  private List<MinsuHouseDetailConfigBean> s;
  @BindView(2131691367)
  SimpleDraweeView sdv_detail;
  private List<MinsuTopHouseDetailBean.ListCheckRuleVoBean> t;
  @BindView(2131691384)
  TextView tv_eva_author;
  @BindView(2131691383)
  TextView tv_eva_content;
  @BindView(2131691382)
  TextView tv_eva_count;
  @BindView(2131691396)
  TextView tv_price;
  @BindView(2131691368)
  TextView tv_title;
  private List<MinsuTopHouseDetailBean.ListCheckRuleVoBean> u;
  private com.freelxl.baselibrary.a.a v;
  @BindView(2131690815)
  View v_bg;
  @BindView(2131691395)
  View v_title_bottom;
  private ArrayList<String> w;
  private ArrayList<String> x;
  private float y = -1.0F;
  private float z = -1.0F;
  
  private int a(List<String> paramList, TextView paramTextView, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    for (int i = 0; localIterator.hasNext(); i = (int)(ab.length(paramTextView, (String)localIterator.next()) + paramInt * 2) + i) {}
    return (ac.getScreenWidth(ApplicationEx.c) - i - n.dip2px(this.a, 18.0F) - n.dip2px(this.a, 18.0F)) / (paramList.size() - 1);
  }
  
  private void a()
  {
    this.b = getIntent().getStringExtra("fid");
    this.c = getIntent().getIntExtra("rentWay", 0);
    this.d = getIntent().getStringExtra("startTime");
    this.e = getIntent().getStringExtra("endTime");
    e();
  }
  
  private void a(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    this.w = new ArrayList();
    this.x = new ArrayList();
    paramMinsuTopHouseDetailBean = paramMinsuTopHouseDetailBean.getPicDisList();
    if (paramMinsuTopHouseDetailBean == null) {}
    for (;;)
    {
      return;
      paramMinsuTopHouseDetailBean = paramMinsuTopHouseDetailBean.iterator();
      while (paramMinsuTopHouseDetailBean.hasNext())
      {
        MinsuTopHouseDetailBean.PicDisListBean localPicDisListBean = (MinsuTopHouseDetailBean.PicDisListBean)paramMinsuTopHouseDetailBean.next();
        this.w.add(localPicDisListBean.getEleValue());
        this.x.add(localPicDisListBean.getEleKey());
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.r == null) {}
    for (int i = 0;; i = this.r.getMinDay())
    {
      com.ziroom.ziroomcustomer.minsu.f.k.toMinsuTimeSelectingActivity(this, this.d, this.e, this.b, this.c, i, paramBoolean);
      return;
    }
  }
  
  private void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.sdv_detail.getLayoutParams();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    localLayoutParams.height = (localDisplayMetrics.heightPixels - f() - n.dip2px(this.a, 106.0F));
    this.sdv_detail.setLayoutParams(localLayoutParams);
    this.A = (localLayoutParams.height * 0.7F);
    this.rl_title_container.post(new Runnable()
    {
      public void run()
      {
        MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, MinsuTopHouseDetailLiteActivity.this.rl_title_container.getHeight());
      }
    });
    this.sdv_detail.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          return false;
          MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMotionEvent.getX());
          MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMotionEvent.getY());
          continue;
          if ((MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this) > 0.0F) && (MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this) > 0.0F) && (Math.sqrt(Math.pow(Math.abs(MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this) - paramAnonymousMotionEvent.getX()), 2.0D) + Math.pow(Math.abs(MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this) - paramAnonymousMotionEvent.getY()), 2.0D)) > 100.0D))
          {
            MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, -1.0F);
            MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this, -1.0F);
            MinsuTopHouseDetailLiteActivity.c(MinsuTopHouseDetailLiteActivity.this);
            return true;
            MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, -1.0F);
            MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this, -1.0F);
          }
        }
      }
    });
    this.osv_main.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f1 = 0.0F;
        float f3 = paramAnonymousInt2 - MinsuTopHouseDetailLiteActivity.d(MinsuTopHouseDetailLiteActivity.this);
        float f4 = MinsuTopHouseDetailLiteActivity.d(MinsuTopHouseDetailLiteActivity.this) * 3.0F / 7.0F - MinsuTopHouseDetailLiteActivity.e(MinsuTopHouseDetailLiteActivity.this);
        float f2 = f3 / f4;
        com.freelxl.baselibrary.f.d.e("TAG->onScroll", "scroll:" + f3 + "-------limit:" + f4 + "-----newAlpha" + f2);
        View localView = MinsuTopHouseDetailLiteActivity.this.v_bg;
        if (f2 < 0.0F) {}
        for (;;)
        {
          localView.setAlpha(f1);
          if (f2 < 0.75D) {
            break;
          }
          if (MinsuTopHouseDetailLiteActivity.f(MinsuTopHouseDetailLiteActivity.this) != 1)
          {
            MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this, 1);
            MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, MinsuTopHouseDetailLiteActivity.g(MinsuTopHouseDetailLiteActivity.this));
            MinsuTopHouseDetailLiteActivity.this.btn_share.setImageResource(2130840338);
            MinsuTopHouseDetailLiteActivity.this.btn_back.setImageResource(2130840141);
            MinsuTopHouseDetailLiteActivity.this.v_title_bottom.setVisibility(0);
          }
          return;
          f1 = f2;
        }
        MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this, 0);
        MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, MinsuTopHouseDetailLiteActivity.g(MinsuTopHouseDetailLiteActivity.this));
        MinsuTopHouseDetailLiteActivity.this.btn_share.setImageResource(2130840339);
        MinsuTopHouseDetailLiteActivity.this.btn_back.setImageResource(2130840142);
        MinsuTopHouseDetailLiteActivity.this.v_title_bottom.setVisibility(8);
      }
    });
  }
  
  private void b(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean.getEvaluateCount() == 0) || (paramMinsuTopHouseDetailBean.getTenantEvalVo() == null))
    {
      this.rl_eva_container.setVisibility(8);
      return;
    }
    this.rl_eva_container.setVisibility(0);
    this.tv_eva_count.setText(paramMinsuTopHouseDetailBean.getEvaluateCount() + " 条");
    this.tv_eva_content.setText(paramMinsuTopHouseDetailBean.getTenantEvalVo().getEvalContent());
    this.tv_eva_author.setText(paramMinsuTopHouseDetailBean.getTenantEvalVo().getEvalDate() + " " + paramMinsuTopHouseDetailBean.getTenantEvalVo().getCustomerName());
    if ((paramMinsuTopHouseDetailBean.getEvaluateCount() == 1) && (TextUtils.isEmpty(paramMinsuTopHouseDetailBean.getTenantEvalVo().getLandlordEvalContent())))
    {
      this.btn_eva_all.setVisibility(8);
      return;
    }
    this.btn_eva_all.setVisibility(0);
  }
  
  private void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramBoolean)
    {
      this.btn_collect.setImageResource(2130840221);
      return;
    }
    ImageView localImageView = this.btn_collect;
    if (this.C == 0) {}
    for (int i = 2130840222;; i = 2130840220)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void c(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramMinsuTopHouseDetailBean.getListHouseFacilities())))
    {
      this.ll_fac_container.setVisibility(8);
      this.btn_fac_all.setVisibility(8);
    }
    for (;;)
    {
      return;
      Object localObject1 = paramMinsuTopHouseDetailBean.getListHouseFacServ().iterator();
      int i = 0;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MinsuTopHouseDetailBean.ListHouseFacServBean)((Iterator)localObject1).next();
        if (((MinsuTopHouseDetailBean.ListHouseFacServBean)localObject2).getSubEnumVals() == null) {}
        for (int j = 0;; j = ((MinsuTopHouseDetailBean.ListHouseFacServBean)localObject2).getSubEnumVals().size())
        {
          i = j + i;
          break;
        }
      }
      localObject1 = this.btn_fac_all;
      if (i > 5) {}
      for (i = 0;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        this.ll_fac_container.setVisibility(0);
        Iterator localIterator = paramMinsuTopHouseDetailBean.getListHouseFacilities().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (MinsuTopHouseDetailBean.ListHouseFacilitiesBean)localIterator.next();
          LinearLayout localLinearLayout = new LinearLayout(this);
          localLinearLayout.setOrientation(1);
          localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
          localObject2 = new SimpleDraweeView(this);
          Object localObject3 = new LinearLayout.LayoutParams(n.dip2px(this, 32.0F), n.dip2px(this, 32.0F));
          ((LinearLayout.LayoutParams)localObject3).gravity = 1;
          ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((SimpleDraweeView)localObject2).setController(com.freelxl.baselibrary.f.c.frescoController(((MinsuTopHouseDetailBean.ListHouseFacilitiesBean)localObject1).getIconThrUrl()));
          localLinearLayout.addView((View)localObject2);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, n.dip2px(this, 4.0F), 0, 0);
          localObject3 = new TextView(this);
          ((TextView)localObject3).setTextSize(12.0F);
          ((TextView)localObject3).setSingleLine();
          ((TextView)localObject3).setTextColor(getResources().getColor(2131624039));
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((TextView)localObject3).setGravity(17);
          localObject2 = ((MinsuTopHouseDetailBean.ListHouseFacilitiesBean)localObject1).getText();
          localObject1 = localObject2;
          if (((String)localObject2).length() >= 5) {
            localObject1 = ((String)localObject2).substring(0, 4) + "...";
          }
          ((TextView)localObject3).setText((CharSequence)localObject1);
          localLinearLayout.addView((View)localObject3);
          this.ll_fac_container.addView(localLinearLayout);
        }
      }
      i = paramMinsuTopHouseDetailBean.getListHouseFacilities().size();
      while (i < 5)
      {
        paramMinsuTopHouseDetailBean = new LinearLayout(this);
        paramMinsuTopHouseDetailBean.setOrientation(1);
        paramMinsuTopHouseDetailBean.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
        this.ll_fac_container.addView(paramMinsuTopHouseDetailBean);
        i += 1;
      }
    }
  }
  
  private void d(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramMinsuTopHouseDetailBean.getListHouseFacServ()))) {
      return;
    }
    this.s = new ArrayList();
    paramMinsuTopHouseDetailBean = paramMinsuTopHouseDetailBean.getListHouseFacServ().iterator();
    while (paramMinsuTopHouseDetailBean.hasNext())
    {
      Object localObject1 = (MinsuTopHouseDetailBean.ListHouseFacServBean)paramMinsuTopHouseDetailBean.next();
      Object localObject2;
      if (!"".equals(((MinsuTopHouseDetailBean.ListHouseFacServBean)localObject1).getKey()))
      {
        localObject2 = new MinsuHouseDetailConfigBean();
        ((MinsuHouseDetailConfigBean)localObject2).setIcPath(null);
        ((MinsuHouseDetailConfigBean)localObject2).setName(((MinsuTopHouseDetailBean.ListHouseFacServBean)localObject1).getText());
        ((MinsuHouseDetailConfigBean)localObject2).setType(0);
        this.s.add(localObject2);
      }
      localObject1 = ((MinsuTopHouseDetailBean.ListHouseFacServBean)localObject1).getSubEnumVals().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MinsuTopHouseDetailBean.ListHouseFacServBean.SubEnumValsBean)((Iterator)localObject1).next();
        MinsuHouseDetailConfigBean localMinsuHouseDetailConfigBean = new MinsuHouseDetailConfigBean();
        localMinsuHouseDetailConfigBean.setIcPath(((MinsuTopHouseDetailBean.ListHouseFacServBean.SubEnumValsBean)localObject2).getIconThrUrl());
        localMinsuHouseDetailConfigBean.setName(((MinsuTopHouseDetailBean.ListHouseFacServBean.SubEnumValsBean)localObject2).getText());
        localMinsuHouseDetailConfigBean.setType(1);
        this.s.add(localMinsuHouseDetailConfigBean);
      }
    }
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getTopHouseDetail(this, this.b, this.c, this.d, new s(this, new p(MinsuTopHouseDetailBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuTopHouseDetailBean paramAnonymousMinsuTopHouseDetailBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuTopHouseDetailBean);
        if (paramAnonymousMinsuTopHouseDetailBean != null)
        {
          MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.this.tv_title.setText(paramAnonymousMinsuTopHouseDetailBean.getHouseName());
          MinsuTopHouseDetailLiteActivity.this.tv_price.setText("¥" + paramAnonymousMinsuTopHouseDetailBean.getHousePrice() / 100 + "/晚");
          MinsuTopHouseDetailLiteActivity.this.sdv_detail.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuTopHouseDetailBean.getDefaultPic()));
          MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.c(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.d(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.e(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.f(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.h(MinsuTopHouseDetailLiteActivity.this);
          MinsuTopHouseDetailLiteActivity.g(MinsuTopHouseDetailLiteActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.this.updateConfirmButton(paramAnonymousMinsuTopHouseDetailBean);
          paramAnonymousMinsuTopHouseDetailBean = new MsHistorySBean();
          paramAnonymousMinsuTopHouseDetailBean.fid = MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this).getFid();
          paramAnonymousMinsuTopHouseDetailBean.rentWay = MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this).getRentWay();
          ad.putLookHouseHistory(paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailLiteActivity.this.tv_title.setFocusable(false);
          MinsuTopHouseDetailLiteActivity.this.tv_title.setFocusableInTouchMode(false);
          MinsuTopHouseDetailLiteActivity.this.tv_title.clearFocus();
        }
      }
    });
  }
  
  private void e(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    int i = 0;
    if (this.t == null)
    {
      this.t = new ArrayList();
      this.u = new ArrayList();
    }
    for (;;)
    {
      this.btn_rule_unfold.setVisibility(0);
      while ((i < 3) && (i < paramMinsuTopHouseDetailBean.getListCheckRuleVo().size()))
      {
        this.u.add(paramMinsuTopHouseDetailBean.getListCheckRuleVo().get(i));
        i += 1;
      }
      this.t.clear();
      this.u.clear();
    }
    this.t.addAll(paramMinsuTopHouseDetailBean.getListCheckRuleVo());
    paramMinsuTopHouseDetailBean = new MinsuTopHouseDetailBean.ListCheckRuleVoBean();
    paramMinsuTopHouseDetailBean.setClickType(-1);
    paramMinsuTopHouseDetailBean.setName("出租日历");
    paramMinsuTopHouseDetailBean.setVal("查看");
    this.t.add(paramMinsuTopHouseDetailBean);
    this.v = new com.freelxl.baselibrary.a.a(this, this.u, 2130904314)
    {
      public void convert(b paramAnonymousb, MinsuTopHouseDetailBean.ListCheckRuleVoBean paramAnonymousListCheckRuleVoBean)
      {
        paramAnonymousb.setText(2131694588, paramAnonymousListCheckRuleVoBean.getName());
        paramAnonymousb.setText(2131691546, paramAnonymousListCheckRuleVoBean.getVal());
        Resources localResources = MinsuTopHouseDetailLiteActivity.this.getResources();
        if (paramAnonymousListCheckRuleVoBean.getClickType() != 0) {}
        for (int i = 2131624480;; i = 2131624039)
        {
          paramAnonymousb.setTextColor(2131691546, localResources.getColor(i));
          return;
        }
      }
    };
    h();
    this.lv_rule.setAdapter(this.v);
    this.lv_rule.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (MinsuTopHouseDetailBean.ListCheckRuleVoBean)MinsuTopHouseDetailLiteActivity.j(MinsuTopHouseDetailLiteActivity.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView.getClickType() == 0) {
          return;
        }
        if (paramAnonymousAdapterView.getClickType() == -1)
        {
          MinsuTopHouseDetailLiteActivity.b(MinsuTopHouseDetailLiteActivity.this, false);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.getType();
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuInfoActivity(MinsuTopHouseDetailLiteActivity.this, Integer.parseInt(paramAnonymousAdapterView), MinsuTopHouseDetailLiteActivity.k(MinsuTopHouseDetailLiteActivity.this), MinsuTopHouseDetailLiteActivity.l(MinsuTopHouseDetailLiteActivity.this));
      }
    });
  }
  
  private int f()
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  private void f(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramMinsuTopHouseDetailBean.getHouseNameInfoList())))
    {
      this.fl_image_tag.setVisibility(8);
      return;
    }
    this.fl_image_tag.setVisibility(0);
    this.fl_image_tag.removeAllViews();
    paramMinsuTopHouseDetailBean = paramMinsuTopHouseDetailBean.getHouseNameInfoList();
    int m = n.dip2px(this.a, 12.0F);
    int k = 0;
    int i = 0;
    label61:
    TextView localTextView;
    LinearLayout.LayoutParams localLayoutParams;
    if (k < paramMinsuTopHouseDetailBean.size())
    {
      localTextView = new TextView(this);
      localTextView.setTextSize(12.0F);
      localTextView.setGravity(17);
      localTextView.setTextColor(getResources().getColor(2131624583));
      localTextView.setBackgroundResource(2130839595);
      localTextView.setPadding(m, 0, m, 0);
      localTextView.setSingleLine();
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      if (k == 0) {
        break label221;
      }
      int j = i;
      if (i == 0) {
        j = a(paramMinsuTopHouseDetailBean, localTextView, m);
      }
      i = j;
    }
    label221:
    for (;;)
    {
      localLayoutParams.setMargins(0, 0, i, 0);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setText((CharSequence)paramMinsuTopHouseDetailBean.get(k));
      this.fl_image_tag.addView(localTextView);
      k += 1;
      break label61;
      break;
    }
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this, MinsuScanPhotoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("texts", this.x);
    localBundle.putSerializable("photos", this.w);
    localIntent.putExtra("position", 0);
    localIntent.putExtra("mHouse_type", 0);
    localIntent.putExtras(localBundle);
    startActivity(localIntent);
  }
  
  private void h()
  {
    if ((ae.isNull(this.d)) || (ae.isNull(this.e)) || (this.r == null) || (this.r.getLongTermDays() == null) || (this.g)) {}
    for (;;)
    {
      return;
      try
      {
        long l = m.getDaysBetween(m.strToDate(this.d, m.b), m.strToDate(this.e, m.b));
        com.freelxl.baselibrary.f.d.d("lanzhihong", "startTime===" + this.d + "==endTime===" + this.e + "===day==" + l);
        if (l >= Integer.parseInt(this.r.getLongTermDays()))
        {
          String str1 = this.r.getCheckOutRulesTitle();
          String str2 = this.r.getLongTermName();
          String str3 = this.r.getLongTermType();
          String str4 = this.r.getCurRulesType();
          Iterator localIterator = this.t.iterator();
          while (localIterator.hasNext())
          {
            MinsuTopHouseDetailBean.ListCheckRuleVoBean localListCheckRuleVoBean = (MinsuTopHouseDetailBean.ListCheckRuleVoBean)localIterator.next();
            if (localListCheckRuleVoBean.getType().equals(str4))
            {
              localListCheckRuleVoBean.setType(str3);
              localListCheckRuleVoBean.setName(str1);
              localListCheckRuleVoBean.setVal(str2);
            }
          }
          this.v.notifyDataSetChanged();
          this.g = true;
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void i()
  {
    if (!ApplicationEx.c.isLoginState()) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.isCollectHouse(this, this.r.getFid(), this.r.getRentWay(), new t(this, new r(MinsuHouseIsCollectResutBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseIsCollectResutBean paramAnonymousMinsuHouseIsCollectResutBean)
      {
        if ((paramAnonymousMinsuHouseIsCollectResutBean != null) && (paramAnonymousMinsuHouseIsCollectResutBean.checkSuccess(MinsuTopHouseDetailLiteActivity.this)))
        {
          MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, "1".equals(paramAnonymousMinsuHouseIsCollectResutBean.data.isCollection));
          return;
        }
        if (paramAnonymousMinsuHouseIsCollectResutBean == null) {}
        for (paramAnonymousMinsuHouseIsCollectResutBean = null;; paramAnonymousMinsuHouseIsCollectResutBean = paramAnonymousMinsuHouseIsCollectResutBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuHouseIsCollectResutBean);
          return;
        }
      }
    });
  }
  
  private void j()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.unCollectHouse(this, this.b, this.c, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseCancelCollectResultBean localMinsuHouseCancelCollectResultBean = (MinsuHouseCancelCollectResultBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCancelCollectResultBean != null) && (localMinsuHouseCancelCollectResultBean.checkSuccess(MinsuTopHouseDetailLiteActivity.this)) && ("0".equals(localMinsuHouseCancelCollectResultBean.data.delCollResult)))
        {
          MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, false);
          paramAnonymousk = MinsuTopHouseDetailLiteActivity.this.getIntent();
          if (MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this) != null)
          {
            paramAnonymousk.putExtra("fid", MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this).getFid());
            paramAnonymousk.putExtra("rentWay", MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this).getRentWay());
          }
          paramAnonymousk.putExtra("isCollect", MinsuTopHouseDetailLiteActivity.g(MinsuTopHouseDetailLiteActivity.this));
          MinsuTopHouseDetailLiteActivity.this.setResult(101, paramAnonymousk);
          g.textToast(MinsuTopHouseDetailLiteActivity.this, "取消收藏成功");
          return;
        }
        if (localMinsuHouseCancelCollectResultBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseCancelCollectResultBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void k()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    if ((this.r != null) && (ae.notNull(this.r.getLandlordUid())) && (this.r.getLandlordUid().equals(com.ziroom.ziroomcustomer.minsu.e.d.getUid())))
    {
      g.textToast(this, getString(2131296555));
      return;
    }
    Intent localIntent = new Intent(this, MinsuImInfoActivity.class);
    localIntent.putExtra("fid", this.b);
    localIntent.putExtra("fid", "1");
    localIntent.putExtra("rentWay", this.y);
    localIntent.putExtra("startTime", this.d);
    localIntent.putExtra("endTime", this.e);
    if ((this.r == null) || (ae.notNull(this.r.getLandlordName()))) {
      localIntent.putExtra("lName", this.r.getLandlordName());
    }
    startActivity(localIntent);
  }
  
  private boolean l()
  {
    return (ae.notNull(this.d)) && (ae.notNull(this.e));
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, MinsuHouseEvaluationListActivity.class);
    localIntent.putExtra("fid", this.b);
    localIntent.putExtra("rentWay", this.c);
    localIntent.putExtra("llname", this.r.getLandlordName());
    startActivity(localIntent);
    com.ziroom.ziroomcustomer.minsu.f.k.animStartAlpha(this);
  }
  
  public void collectHouse()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.collectHouse(this, this.b, this.c, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseCollectResultBean localMinsuHouseCollectResultBean = (MinsuHouseCollectResultBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCollectResultBean != null) && (localMinsuHouseCollectResultBean.checkSuccess(MinsuTopHouseDetailLiteActivity.this)) && (localMinsuHouseCollectResultBean.data != null) && ("0".equals(localMinsuHouseCollectResultBean.data.collResult)))
        {
          MinsuTopHouseDetailLiteActivity.a(MinsuTopHouseDetailLiteActivity.this, true);
          paramAnonymousk = MinsuTopHouseDetailLiteActivity.this.getIntent();
          if (MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this) != null)
          {
            paramAnonymousk.putExtra("fid", MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this).getFid());
            paramAnonymousk.putExtra("rentWay", MinsuTopHouseDetailLiteActivity.i(MinsuTopHouseDetailLiteActivity.this).getRentWay());
          }
          paramAnonymousk.putExtra("isCollect", MinsuTopHouseDetailLiteActivity.g(MinsuTopHouseDetailLiteActivity.this));
          MinsuTopHouseDetailLiteActivity.this.setResult(101, paramAnonymousk);
          g.textToast(MinsuTopHouseDetailLiteActivity.this, "收藏成功");
          return;
        }
        if (localMinsuHouseCollectResultBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseCollectResultBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 113))
    {
      this.d = paramIntent.getStringExtra("startDate");
      this.e = paramIntent.getStringExtra("endDate");
      updateConfirmButton(this.r);
      if (!paramIntent.getBooleanExtra("isToNext", false)) {
        h();
      }
    }
    else
    {
      return;
    }
    toOrder();
  }
  
  @OnClick({2131690078, 2131691393, 2131691394, 2131691363, 2131691362, 2131691381, 2131691367, 2131691386, 2131691390})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.s == null) || (this.s.size() <= 0));
      com.ziroom.ziroomcustomer.minsu.f.k.toMinsuServiceListActivity(this, this.s);
      return;
      g();
      return;
      finish();
      return;
      shareHouse();
      return;
      if ((!ApplicationEx.c.isLoginState()) || (this.r == null))
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this);
        return;
      }
      if (this.f)
      {
        j();
        return;
      }
      collectHouse();
      return;
      if (l())
      {
        toOrder();
        return;
      }
      a(true);
      return;
      k();
      return;
      m();
      return;
      this.btn_rule_unfold.setVisibility(8);
    } while ((this.v == null) || (this.t == null));
    this.v.setDatas(this.t);
    this.v.notifyDataSetChanged();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903281);
    ButterKnife.bind(this);
    this.a = this;
    b();
    a();
    this.tv_title.setFocusable(true);
    this.tv_title.setFocusableInTouchMode(true);
    this.tv_title.requestFocus();
    this.tv_title.requestFocusFromTouch();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  public void shareHouse()
  {
    com.ziroom.threelib.ziroomshare.c localc;
    StringBuilder localStringBuilder;
    MinsuTopHouseDetailBean.HouseTopInfoVoBean.HouseTopColumnVoListBean localHouseTopColumnVoListBean;
    if (this.r != null)
    {
      localc = com.ziroom.threelib.ziroomshare.c.getInstance();
      if (localc != null)
      {
        localc.setOnPlatformClickListener(new c.a()
        {
          public void onPlatformClick(Platform paramAnonymousPlatform) {}
        });
        localStringBuilder = new StringBuilder();
        localObject = this.r.getHouseTopInfoVo().getHouseTopColumnVoList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localHouseTopColumnVoListBean = (MinsuTopHouseDetailBean.HouseTopInfoVoBean.HouseTopColumnVoListBean)((Iterator)localObject).next();
          if (localHouseTopColumnVoListBean.getColumnType() == 202) {
            if (localHouseTopColumnVoListBean.getColumnContent() != null) {
              break label134;
            }
          }
        }
      }
    }
    label134:
    for (Object localObject = "";; localObject = localHouseTopColumnVoListBean.getColumnContent())
    {
      localStringBuilder.append((String)localObject);
      localc.shareFromCenter(this, this.r.getHouseShareUrl(), this.r.getHouseTopInfoVo().getTopShareTitle(), localStringBuilder.toString(), this.r.getDefaultPic());
      return;
    }
  }
  
  public void toOrder()
  {
    if (!ApplicationEx.c.isLoginState()) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
    while (this.r == null) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.f.k.toMinsuApplyActivity(this, OrderStatusEnum.YD, this.b, this.r.getHouseName(), this.c, this.d, this.e, this.r.getLandlordName(), "");
  }
  
  public void updateConfirmButton(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean != null) && (paramMinsuTopHouseDetailBean.getHouseStatus() == 40))
    {
      paramMinsuTopHouseDetailBean = paramMinsuTopHouseDetailBean.getOrderTypeName();
      this.btn_confirm.setBackgroundColor(getResources().getColor(2131624480));
      TextView localTextView = this.btn_confirm;
      if (l()) {}
      for (;;)
      {
        localTextView.setText(paramMinsuTopHouseDetailBean);
        return;
        paramMinsuTopHouseDetailBean = "选择日期";
      }
    }
    this.btn_confirm.setBackgroundColor(getResources().getColor(2131624046));
    this.btn_confirm.setText(getString(2131297080));
    this.btn_confirm.setEnabled(false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTopHouseDetailLiteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */