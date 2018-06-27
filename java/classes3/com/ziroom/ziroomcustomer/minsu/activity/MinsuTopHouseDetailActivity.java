package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
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
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.l;
import com.ziroom.threelib.ziroomshare.c.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseSupportURIActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
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
import com.ziroom.ziroomcustomer.minsu.bean.MinsuTopHouseDetailBean.HouseTopInfoVoBean.LabelTipsTopListBean;
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
import com.ziroom.ziroomcustomer.minsu.f.o;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.fragment.MinsuTopHouseDetailOtherRoomFragment;
import com.ziroom.ziroomcustomer.minsu.view.CustomViewPager;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MinsuTopHouseDetailActivity
  extends BaseSupportURIActivity
{
  private boolean A = false;
  private float B = -1.0F;
  private float C = -1.0F;
  private float D;
  private int E;
  private int F = 0;
  private final int G = 800;
  private PlatformActionListener H = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      MinsuTopHouseDetailActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      MinsuTopHouseDetailActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
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
  @BindView(2131691373)
  TextView btn_pic_word_unfold;
  @BindView(2131691390)
  View btn_rule_unfold;
  @BindView(2131691393)
  ImageView btn_share;
  private int c;
  @BindView(2131691391)
  CustomViewPager cvp_other_room;
  private String d;
  private String e;
  private String f;
  @BindView(2131691385)
  FlowLayout fl_house_info_tag;
  @BindView(2131691369)
  FlowLayout fl_image_tag;
  private boolean g;
  @BindView(2131691387)
  LinearLayout ll_fac_container;
  @BindView(2131691355)
  View ll_more_house;
  @BindView(2131691372)
  LinearLayout ll_pic_word_container;
  @BindView(2131691389)
  View ll_rule_unfold_container;
  @BindView(2131691388)
  ListViewForScrollView lv_rule;
  @BindView(2131691365)
  ObservableScrollView osv_main;
  private boolean r = false;
  @BindView(2131691379)
  RelativeLayout rl_eva_container;
  @BindView(2131691392)
  View rl_title_container;
  private MinsuTopHouseDetailBean s;
  @BindView(2131691367)
  SimpleDraweeView sdv_detail;
  @BindView(2131691376)
  SimpleDraweeView sdv_landlord_head;
  @BindView(2131691374)
  SimpleDraweeView sdv_top_list;
  @BindView(2131691371)
  SimpleDraweeView sdv_top_special_icon;
  private List<MinsuHouseDetailConfigBean> t;
  @BindView(2131691384)
  TextView tv_eva_author;
  @BindView(2131691383)
  TextView tv_eva_content;
  @BindView(2131691382)
  TextView tv_eva_count;
  @BindView(2131691378)
  TextView tv_house_address;
  @BindView(2131691375)
  TextView tv_landlord_name;
  @BindView(2131691377)
  TextView tv_landlord_recommend;
  @BindView(2131690979)
  TextView tv_price;
  @BindView(2131691368)
  TextView tv_title;
  @BindView(2131691370)
  TextView tv_top_special_title;
  private List<MinsuTopHouseDetailBean.ListCheckRuleVoBean> u;
  private List<MinsuTopHouseDetailBean.ListCheckRuleVoBean> v;
  @BindView(2131690815)
  View v_bg;
  @BindView(2131691395)
  View v_title_bottom;
  private com.freelxl.baselibrary.a.a w;
  private ArrayList<String> x;
  private ArrayList<String> y;
  private List<MinsuTopHouseDetailOtherRoomFragment> z = new ArrayList();
  
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
    this.f = getIntent().getStringExtra("from");
    e();
  }
  
  private void a(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean == null) || (paramMinsuTopHouseDetailBean.getHouseTopInfoVo() == null) || (paramMinsuTopHouseDetailBean.getHouseTopInfoVo().getHouseTopColumnVoList() == null)) {
      return;
    }
    this.ll_pic_word_container.removeAllViews();
    int m = n.dip2px(this.a, 800.0F);
    int i = 0;
    int j = 0;
    if (i < paramMinsuTopHouseDetailBean.getHouseTopInfoVo().getHouseTopColumnVoList().size())
    {
      View localView = o.generateView(this.a, (MinsuTopHouseDetailBean.HouseTopInfoVoBean.HouseTopColumnVoListBean)paramMinsuTopHouseDetailBean.getHouseTopInfoVo().getHouseTopColumnVoList().get(i), i);
      int k = j;
      if (localView != null)
      {
        this.ll_pic_word_container.addView(localView);
        if (j != 0) {
          break label223;
        }
        k = View.MeasureSpec.makeMeasureSpec(0, 0);
        int n = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.ll_pic_word_container.measure(k, n);
        k = this.ll_pic_word_container.getMeasuredHeight();
        if (k > m) {
          break label171;
        }
        localView.setTag(Boolean.valueOf(false));
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        label171:
        if (k - localView.getHeight() / 2 <= m)
        {
          localView.setTag(Boolean.valueOf(false));
          k = j;
        }
        else
        {
          localView.setTag(Boolean.valueOf(true));
          localView.setVisibility(8);
          k = 1;
          continue;
          label223:
          localView.setTag(Boolean.valueOf(true));
          localView.setVisibility(8);
          k = j;
        }
      }
    }
    this.A = false;
    if (j != 0)
    {
      this.btn_pic_word_unfold.setVisibility(0);
      return;
    }
    this.btn_pic_word_unfold.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    if (i < this.ll_pic_word_container.getChildCount())
    {
      View localView = this.ll_pic_word_container.getChildAt(i);
      if (((Boolean)localView.getTag()).booleanValue()) {
        if (!paramBoolean) {
          break label56;
        }
      }
      label56:
      for (int j = 0;; j = 8)
      {
        localView.setVisibility(j);
        i += 1;
        break;
      }
    }
  }
  
  private void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.sdv_detail.getLayoutParams();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    localLayoutParams.height = (localDisplayMetrics.heightPixels - f() - n.dip2px(this.a, 106.0F));
    this.sdv_detail.setLayoutParams(localLayoutParams);
    this.D = (localLayoutParams.height * 0.7F);
    this.rl_title_container.post(new Runnable()
    {
      public void run()
      {
        MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, MinsuTopHouseDetailActivity.this.rl_title_container.getHeight());
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
          MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, paramAnonymousMotionEvent.getX());
          MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this, paramAnonymousMotionEvent.getY());
          continue;
          if ((MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this) > 0.0F) && (MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this) > 0.0F) && (Math.sqrt(Math.pow(Math.abs(MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this) - paramAnonymousMotionEvent.getX()), 2.0D) + Math.pow(Math.abs(MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this) - paramAnonymousMotionEvent.getY()), 2.0D)) > 100.0D))
          {
            MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, -1.0F);
            MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this, -1.0F);
            MinsuTopHouseDetailActivity.c(MinsuTopHouseDetailActivity.this);
            return true;
            MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, -1.0F);
            MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this, -1.0F);
          }
        }
      }
    });
    this.osv_main.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f1 = 0.0F;
        float f3 = paramAnonymousInt2 - MinsuTopHouseDetailActivity.d(MinsuTopHouseDetailActivity.this);
        float f4 = MinsuTopHouseDetailActivity.d(MinsuTopHouseDetailActivity.this) * 3.0F / 7.0F - MinsuTopHouseDetailActivity.e(MinsuTopHouseDetailActivity.this);
        float f2 = f3 / f4;
        com.freelxl.baselibrary.f.d.e("TAG->onScroll", "scroll:" + f3 + "-------limit:" + f4 + "-----newAlpha" + f2);
        View localView = MinsuTopHouseDetailActivity.this.v_bg;
        if (f2 < 0.0F) {}
        for (;;)
        {
          localView.setAlpha(f1);
          if (f2 < 0.75D) {
            break;
          }
          if (MinsuTopHouseDetailActivity.f(MinsuTopHouseDetailActivity.this) != 1)
          {
            MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this, 1);
            MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, MinsuTopHouseDetailActivity.g(MinsuTopHouseDetailActivity.this));
            MinsuTopHouseDetailActivity.this.btn_share.setImageResource(2130840338);
            MinsuTopHouseDetailActivity.this.btn_back.setImageResource(2130840141);
            MinsuTopHouseDetailActivity.this.v_title_bottom.setVisibility(0);
          }
          return;
          f1 = f2;
        }
        MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this, 0);
        MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, MinsuTopHouseDetailActivity.g(MinsuTopHouseDetailActivity.this));
        MinsuTopHouseDetailActivity.this.btn_share.setImageResource(2130840339);
        MinsuTopHouseDetailActivity.this.btn_back.setImageResource(2130840142);
        MinsuTopHouseDetailActivity.this.v_title_bottom.setVisibility(8);
      }
    });
    this.sdv_top_list.setAspectRatio(1.5F);
  }
  
  private void b(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    this.x = new ArrayList();
    this.y = new ArrayList();
    paramMinsuTopHouseDetailBean = paramMinsuTopHouseDetailBean.getPicDisList();
    if (paramMinsuTopHouseDetailBean == null) {}
    for (;;)
    {
      return;
      paramMinsuTopHouseDetailBean = paramMinsuTopHouseDetailBean.iterator();
      while (paramMinsuTopHouseDetailBean.hasNext())
      {
        MinsuTopHouseDetailBean.PicDisListBean localPicDisListBean = (MinsuTopHouseDetailBean.PicDisListBean)paramMinsuTopHouseDetailBean.next();
        this.x.add(localPicDisListBean.getEleValue());
        this.y.add(localPicDisListBean.getEleKey());
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.s == null) {}
    for (int i = 0;; i = this.s.getMinDay())
    {
      com.ziroom.ziroomcustomer.minsu.f.k.toMinsuTimeSelectingActivity(this, this.d, this.e, this.b, this.c, i, paramBoolean);
      return;
    }
  }
  
  private void c(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
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
  
  private void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (paramBoolean)
    {
      this.btn_collect.setImageResource(2130840221);
      return;
    }
    ImageView localImageView = this.btn_collect;
    if (this.F == 0) {}
    for (int i = 2130840222;; i = 2130840220)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void d(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
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
  
  private void d(String paramString)
  {
    if (this.c == 0)
    {
      this.ll_more_house.setVisibility(8);
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.landlistOk(this, paramString, this.b, this.c, 1, 100, false, true, new t(this, new com.freelxl.baselibrary.d.f.d(MinsuHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseBean paramAnonymousMinsuHouseBean)
      {
        if ((paramAnonymousMinsuHouseBean != null) && (paramAnonymousMinsuHouseBean.checkSuccess(MinsuTopHouseDetailActivity.this)))
        {
          if (paramAnonymousMinsuHouseBean.data.total < 1)
          {
            MinsuTopHouseDetailActivity.this.ll_more_house.setVisibility(8);
            return;
          }
          MinsuTopHouseDetailActivity.this.ll_more_house.setVisibility(0);
          MinsuTopHouseDetailActivity.m(MinsuTopHouseDetailActivity.this).clear();
          paramAnonymousMinsuHouseBean = paramAnonymousMinsuHouseBean.data.list.iterator();
          while (paramAnonymousMinsuHouseBean.hasNext())
          {
            MinsuTopHouseDetailOtherRoomFragment localMinsuTopHouseDetailOtherRoomFragment = MinsuTopHouseDetailOtherRoomFragment.newInstance((MinsuHouseBean.DataBean.ListBean)paramAnonymousMinsuHouseBean.next());
            MinsuTopHouseDetailActivity.m(MinsuTopHouseDetailActivity.this).add(localMinsuTopHouseDetailOtherRoomFragment);
          }
          paramAnonymousMinsuHouseBean = new MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, MinsuTopHouseDetailActivity.this.getSupportFragmentManager());
          MinsuTopHouseDetailActivity.this.cvp_other_room.setAdapter(paramAnonymousMinsuHouseBean);
          MinsuTopHouseDetailActivity.this.cvp_other_room.setPageMargin(com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(MinsuTopHouseDetailActivity.this, 10));
          MinsuTopHouseDetailActivity.this.cvp_other_room.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
          {
            public void onPageScrollStateChanged(int paramAnonymous2Int) {}
            
            public void onPageScrolled(int paramAnonymous2Int1, float paramAnonymous2Float, int paramAnonymous2Int2)
            {
              if (MinsuTopHouseDetailActivity.this.cvp_other_room != null) {
                MinsuTopHouseDetailActivity.this.cvp_other_room.invalidate();
              }
            }
            
            public void onPageSelected(int paramAnonymous2Int) {}
          });
          return;
        }
        if (paramAnonymousMinsuHouseBean == null) {}
        for (paramAnonymousMinsuHouseBean = null;; paramAnonymousMinsuHouseBean = paramAnonymousMinsuHouseBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuHouseBean);
          return;
        }
      }
    });
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getTopHouseDetail(this, this.b, this.c, this.d, new s(this, new p(MinsuTopHouseDetailBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuTopHouseDetailBean paramAnonymousMinsuTopHouseDetailBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuTopHouseDetailBean);
        TextView localTextView;
        if (paramAnonymousMinsuTopHouseDetailBean != null)
        {
          MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          localTextView = MinsuTopHouseDetailActivity.this.tv_title;
          if (paramAnonymousMinsuTopHouseDetailBean.getHouseName() != null) {
            break label432;
          }
          str = "";
          localTextView.setText(str);
          MinsuTopHouseDetailActivity.this.tv_price.setText("价格：¥" + paramAnonymousMinsuTopHouseDetailBean.getHousePrice() / 100 + "/晚");
          MinsuTopHouseDetailActivity.this.sdv_detail.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuTopHouseDetailBean.getDefaultPic()));
          MinsuTopHouseDetailActivity.this.tv_house_address.setText("地址：" + paramAnonymousMinsuTopHouseDetailBean.getHouseAddr());
          MinsuTopHouseDetailActivity.this.tv_landlord_name.setText("我是房东" + paramAnonymousMinsuTopHouseDetailBean.getLandlordName() + "！");
          MinsuTopHouseDetailActivity.this.tv_landlord_recommend.setText(paramAnonymousMinsuTopHouseDetailBean.getCustomerIntroduce());
          MinsuTopHouseDetailActivity.this.sdv_landlord_head.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuTopHouseDetailBean.getLandlordIcon()));
          MinsuTopHouseDetailActivity.this.sdv_top_list.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuTopHouseDetailBean.getHouseTopInfoVo().getTopMiddlePic()));
          MinsuTopHouseDetailActivity.this.sdv_top_special_icon.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMinsuTopHouseDetailBean.getHouseTopInfoVo().getTopTitlePic()));
          localTextView = MinsuTopHouseDetailActivity.this.tv_top_special_title;
          if (paramAnonymousMinsuTopHouseDetailBean.getHouseTopInfoVo().getTopTitle() != null) {
            break label440;
          }
        }
        label432:
        label440:
        for (String str = "";; str = paramAnonymousMinsuTopHouseDetailBean.getHouseTopInfoVo().getTopTitle())
        {
          localTextView.setText(str);
          MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.c(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.d(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.e(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.f(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.h(MinsuTopHouseDetailActivity.this);
          MinsuTopHouseDetailActivity.g(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.h(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.this.updateConfirmButton(paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, paramAnonymousMinsuTopHouseDetailBean.getLandlordUid());
          paramAnonymousMinsuTopHouseDetailBean = new MsHistorySBean();
          paramAnonymousMinsuTopHouseDetailBean.fid = MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this).getFid();
          paramAnonymousMinsuTopHouseDetailBean.rentWay = MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this).getRentWay();
          ad.putLookHouseHistory(paramAnonymousMinsuTopHouseDetailBean);
          MinsuTopHouseDetailActivity.this.tv_title.setFocusable(false);
          MinsuTopHouseDetailActivity.this.tv_title.setFocusableInTouchMode(false);
          MinsuTopHouseDetailActivity.this.tv_title.clearFocus();
          return;
          str = paramAnonymousMinsuTopHouseDetailBean.getHouseName();
          break;
        }
      }
    });
  }
  
  private void e(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramMinsuTopHouseDetailBean.getListHouseFacServ()))) {
      return;
    }
    this.t = new ArrayList();
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
        this.t.add(localObject2);
      }
      localObject1 = ((MinsuTopHouseDetailBean.ListHouseFacServBean)localObject1).getSubEnumVals().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MinsuTopHouseDetailBean.ListHouseFacServBean.SubEnumValsBean)((Iterator)localObject1).next();
        MinsuHouseDetailConfigBean localMinsuHouseDetailConfigBean = new MinsuHouseDetailConfigBean();
        localMinsuHouseDetailConfigBean.setIcPath(((MinsuTopHouseDetailBean.ListHouseFacServBean.SubEnumValsBean)localObject2).getIconThrUrl());
        localMinsuHouseDetailConfigBean.setName(((MinsuTopHouseDetailBean.ListHouseFacServBean.SubEnumValsBean)localObject2).getText());
        localMinsuHouseDetailConfigBean.setType(1);
        this.t.add(localMinsuHouseDetailConfigBean);
      }
    }
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
    int i = 0;
    if (this.u == null)
    {
      this.u = new ArrayList();
      this.v = new ArrayList();
    }
    for (;;)
    {
      this.ll_rule_unfold_container.setVisibility(0);
      while ((i < 3) && (i < paramMinsuTopHouseDetailBean.getListCheckRuleVo().size()))
      {
        this.v.add(paramMinsuTopHouseDetailBean.getListCheckRuleVo().get(i));
        i += 1;
      }
      this.u.clear();
      this.v.clear();
    }
    this.u.addAll(paramMinsuTopHouseDetailBean.getListCheckRuleVo());
    paramMinsuTopHouseDetailBean = new MinsuTopHouseDetailBean.ListCheckRuleVoBean();
    paramMinsuTopHouseDetailBean.setClickType(-1);
    paramMinsuTopHouseDetailBean.setName("出租日历");
    paramMinsuTopHouseDetailBean.setVal("查看");
    this.u.add(paramMinsuTopHouseDetailBean);
    this.w = new com.freelxl.baselibrary.a.a(this, this.v, 2130904314)
    {
      public void convert(b paramAnonymousb, MinsuTopHouseDetailBean.ListCheckRuleVoBean paramAnonymousListCheckRuleVoBean)
      {
        paramAnonymousb.setText(2131694588, paramAnonymousListCheckRuleVoBean.getName());
        paramAnonymousb.setText(2131691546, paramAnonymousListCheckRuleVoBean.getVal());
        Resources localResources = MinsuTopHouseDetailActivity.this.getResources();
        if (paramAnonymousListCheckRuleVoBean.getClickType() != 0) {}
        for (int i = 2131624480;; i = 2131624039)
        {
          paramAnonymousb.setTextColor(2131691546, localResources.getColor(i));
          return;
        }
      }
    };
    h();
    this.lv_rule.setAdapter(this.w);
    this.lv_rule.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (MinsuTopHouseDetailBean.ListCheckRuleVoBean)MinsuTopHouseDetailActivity.j(MinsuTopHouseDetailActivity.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView.getClickType() == 0) {
          return;
        }
        if (paramAnonymousAdapterView.getClickType() == -1)
        {
          MinsuTopHouseDetailActivity.b(MinsuTopHouseDetailActivity.this, false);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.getType();
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuInfoActivity(MinsuTopHouseDetailActivity.this, Integer.parseInt(paramAnonymousAdapterView), MinsuTopHouseDetailActivity.k(MinsuTopHouseDetailActivity.this), MinsuTopHouseDetailActivity.l(MinsuTopHouseDetailActivity.this));
      }
    });
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this, MinsuScanPhotoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("texts", this.y);
    localBundle.putSerializable("photos", this.x);
    localIntent.putExtra("position", 0);
    localIntent.putExtra("mHouse_type", 0);
    localIntent.putExtras(localBundle);
    startActivity(localIntent);
  }
  
  private void g(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramMinsuTopHouseDetailBean.getHouseNameInfoList())))
    {
      this.fl_house_info_tag.setVisibility(8);
      return;
    }
    this.fl_house_info_tag.setVisibility(0);
    this.fl_house_info_tag.removeAllViews();
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
      localTextView.setTextColor(Color.parseColor("#444444"));
      localTextView.setBackgroundResource(2130839594);
      localTextView.setPadding(m, 0, m, 0);
      localTextView.setSingleLine();
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      if (k == 0) {
        break label217;
      }
      int j = i;
      if (i == 0) {
        j = a(paramMinsuTopHouseDetailBean, localTextView, m);
      }
      i = j;
    }
    label217:
    for (;;)
    {
      localLayoutParams.setMargins(i, 0, 0, 0);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setText((CharSequence)paramMinsuTopHouseDetailBean.get(k));
      this.fl_house_info_tag.addView(localTextView);
      k += 1;
      break label61;
      break;
    }
  }
  
  private void h()
  {
    if ((ae.isNull(this.d)) || (ae.isNull(this.e)) || (this.s == null) || (this.s.getLongTermDays() == null) || (this.r)) {}
    for (;;)
    {
      return;
      try
      {
        long l = m.getDaysBetween(m.strToDate(this.d, m.b), m.strToDate(this.e, m.b));
        com.freelxl.baselibrary.f.d.d("lanzhihong", "startTime===" + this.d + "==endTime===" + this.e + "===day==" + l);
        if (l >= Integer.parseInt(this.s.getLongTermDays()))
        {
          String str1 = this.s.getCheckOutRulesTitle();
          String str2 = this.s.getLongTermName();
          String str3 = this.s.getLongTermType();
          String str4 = this.s.getCurRulesType();
          Iterator localIterator = this.u.iterator();
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
          this.w.notifyDataSetChanged();
          this.r = true;
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void h(MinsuTopHouseDetailBean paramMinsuTopHouseDetailBean)
  {
    if ((paramMinsuTopHouseDetailBean == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramMinsuTopHouseDetailBean.getHouseTopInfoVo().getLabelTipsTopList()))) {
      this.fl_image_tag.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.fl_image_tag.setVisibility(0);
      this.fl_image_tag.removeAllViews();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramMinsuTopHouseDetailBean.getHouseTopInfoVo().getLabelTipsTopList().size())
      {
        localArrayList.add(((MinsuTopHouseDetailBean.HouseTopInfoVoBean.LabelTipsTopListBean)paramMinsuTopHouseDetailBean.getHouseTopInfoVo().getLabelTipsTopList().get(i)).getName());
        i += 1;
      }
      int j = n.dip2px(this.a, 16.0F);
      int k = n.dip2px(this.a, 12.0F);
      int m = n.dip2px(this.a, 12.0F);
      i = 0;
      while (i < localArrayList.size())
      {
        paramMinsuTopHouseDetailBean = new TextView(this);
        paramMinsuTopHouseDetailBean.setTextSize(12.0F);
        paramMinsuTopHouseDetailBean.setGravity(17);
        paramMinsuTopHouseDetailBean.setTextColor(getResources().getColor(2131624583));
        paramMinsuTopHouseDetailBean.setBackgroundResource(2130839595);
        paramMinsuTopHouseDetailBean.setPadding(m, 0, m, 0);
        paramMinsuTopHouseDetailBean.setSingleLine();
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (i != 0) {}
        localLayoutParams.setMargins(0, k, j, 0);
        localLayoutParams.height = n.dip2px(this.a, 28.0F);
        paramMinsuTopHouseDetailBean.setLayoutParams(localLayoutParams);
        paramMinsuTopHouseDetailBean.setText((CharSequence)localArrayList.get(i));
        this.fl_image_tag.addView(paramMinsuTopHouseDetailBean);
        i += 1;
      }
    }
  }
  
  private void i()
  {
    if (!ApplicationEx.c.isLoginState()) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.isCollectHouse(this, this.s.getFid(), this.s.getRentWay(), new t(this, new r(MinsuHouseIsCollectResutBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseIsCollectResutBean paramAnonymousMinsuHouseIsCollectResutBean)
      {
        if ((paramAnonymousMinsuHouseIsCollectResutBean != null) && (paramAnonymousMinsuHouseIsCollectResutBean.checkSuccess(MinsuTopHouseDetailActivity.this)))
        {
          MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, "1".equals(paramAnonymousMinsuHouseIsCollectResutBean.data.isCollection));
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
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCancelCollectResultBean != null) && (localMinsuHouseCancelCollectResultBean.checkSuccess(MinsuTopHouseDetailActivity.this)) && ("0".equals(localMinsuHouseCancelCollectResultBean.data.delCollResult)))
        {
          MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, false);
          paramAnonymousk = MinsuTopHouseDetailActivity.this.getIntent();
          if (MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this) != null)
          {
            paramAnonymousk.putExtra("fid", MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this).getFid());
            paramAnonymousk.putExtra("rentWay", MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this).getRentWay());
          }
          paramAnonymousk.putExtra("isCollect", MinsuTopHouseDetailActivity.g(MinsuTopHouseDetailActivity.this));
          MinsuTopHouseDetailActivity.this.setResult(101, paramAnonymousk);
          g.textToast(MinsuTopHouseDetailActivity.this, "取消收藏成功");
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
    if ((this.s != null) && (ae.notNull(this.s.getLandlordUid())) && (this.s.getLandlordUid().equals(com.ziroom.ziroomcustomer.minsu.e.d.getUid())))
    {
      g.textToast(this, getString(2131296555));
      return;
    }
    if ("MinsuChatDetail".equals(this.f))
    {
      finish();
      return;
    }
    Intent localIntent = new Intent(this, MinsuImInfoActivity.class);
    localIntent.putExtra("fid", this.b);
    localIntent.putExtra("isTop50Online", "1");
    localIntent.putExtra("rentWay", this.c);
    localIntent.putExtra("startTime", this.d);
    localIntent.putExtra("endTime", this.e);
    if ((this.s == null) || (ae.notNull(this.s.getLandlordName()))) {
      localIntent.putExtra("lName", this.s.getLandlordName());
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
    localIntent.putExtra("llname", this.s.getLandlordName());
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
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCollectResultBean != null) && (localMinsuHouseCollectResultBean.checkSuccess(MinsuTopHouseDetailActivity.this)) && (localMinsuHouseCollectResultBean.data != null) && ("0".equals(localMinsuHouseCollectResultBean.data.collResult)))
        {
          MinsuTopHouseDetailActivity.a(MinsuTopHouseDetailActivity.this, true);
          paramAnonymousk = MinsuTopHouseDetailActivity.this.getIntent();
          if (MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this) != null)
          {
            paramAnonymousk.putExtra("fid", MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this).getFid());
            paramAnonymousk.putExtra("rentWay", MinsuTopHouseDetailActivity.i(MinsuTopHouseDetailActivity.this).getRentWay());
          }
          paramAnonymousk.putExtra("isCollect", MinsuTopHouseDetailActivity.g(MinsuTopHouseDetailActivity.this));
          MinsuTopHouseDetailActivity.this.setResult(101, paramAnonymousk);
          g.textToast(MinsuTopHouseDetailActivity.this, "收藏成功");
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
      updateConfirmButton(this.s);
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
  
  @OnClick({2131690078, 2131691393, 2131691394, 2131691363, 2131691362, 2131691376, 2131691381, 2131691367, 2131691386, 2131691374, 2131691373, 2131691390})
  @Instrumented
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    label299:
    do
    {
      do
      {
        do
        {
          return;
          finish();
          return;
          shareHouse();
          return;
          if ((!ApplicationEx.c.isLoginState()) || (this.s == null))
          {
            com.ziroom.commonlibrary.login.a.startLoginActivity(this);
            return;
          }
          if (this.g)
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
          b(true);
          return;
          k();
          return;
          m();
          return;
          g();
          return;
        } while ((this.t == null) || (this.t.size() <= 0));
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuServiceListActivity(this, this.t);
        return;
        startActivity(new Intent(this.a, MinsuTopHouseListActivity.class));
        return;
        if (!this.A) {
          this.btn_pic_word_unfold.setVisibility(8);
        }
        if (!this.A)
        {
          bool1 = true;
          a(bool1);
          if (this.A) {
            break label299;
          }
        }
        for (boolean bool1 = bool2;; bool1 = false)
        {
          this.A = bool1;
          return;
          bool1 = false;
          break;
        }
        this.ll_rule_unfold_container.setVisibility(8);
      } while ((this.w == null) || (this.u == null));
      this.w.setDatas(this.u);
      this.w.notifyDataSetChanged();
      return;
    } while ((this.s == null) || (TextUtils.isEmpty(this.s.getLandlordUid())));
    com.ziroom.ziroomcustomer.minsu.f.k.toLandlordDetailActivty(this, this.s.getLandlordUid());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903280);
    this.a = this;
    ButterKnife.bind(this);
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
    if (this.s != null)
    {
      localc = com.ziroom.threelib.ziroomshare.c.getInstance();
      if (localc != null)
      {
        localc.setOnPlatformClickListener(new c.a()
        {
          public void onPlatformClick(Platform paramAnonymousPlatform) {}
        });
        localStringBuilder = new StringBuilder();
        localObject = this.s.getHouseTopInfoVo().getHouseTopColumnVoList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localHouseTopColumnVoListBean = (MinsuTopHouseDetailBean.HouseTopInfoVoBean.HouseTopColumnVoListBean)((Iterator)localObject).next();
          if (localHouseTopColumnVoListBean.getColumnType() == 202) {
            if (localHouseTopColumnVoListBean.getColumnContent() != null) {
              break label138;
            }
          }
        }
      }
    }
    label138:
    for (Object localObject = "";; localObject = localHouseTopColumnVoListBean.getColumnContent())
    {
      localStringBuilder.append((String)localObject);
      localc.shareFromCenter(this, this.s.getHouseShareUrl(), this.s.getHouseTopInfoVo().getTopShareTitle(), localStringBuilder.toString(), this.s.getDefaultPic(), this.H);
      return;
    }
  }
  
  public void toOrder()
  {
    if (!ApplicationEx.c.isLoginState()) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
    while (this.s == null) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.f.k.toMinsuApplyActivity(this, OrderStatusEnum.YD, this.b, this.s.getHouseName(), this.c, this.d, this.e, this.s.getLandlordName(), "");
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
  
  private class a
    extends FragmentPagerAdapter
  {
    a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return MinsuTopHouseDetailActivity.m(MinsuTopHouseDetailActivity.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)MinsuTopHouseDetailActivity.m(MinsuTopHouseDetailActivity.this).get(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTopHouseDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */