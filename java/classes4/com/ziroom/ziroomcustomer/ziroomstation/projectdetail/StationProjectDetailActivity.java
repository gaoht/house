package com.ziroom.ziroomcustomer.ziroomstation.projectdetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.e;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFluxSupportURIActivity;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.ScanPhotoActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailConfigBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.i;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.view.CustomViewPager;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.widget.ZiroomFlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.OrderCreateActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationInfoActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationProjectEvaluateActivity;
import com.ziroom.ziroomcustomer.ziroomstation.StationWebActivity;
import com.ziroom.ziroomcustomer.ziroomstation.baidumap.StationHouseMapLocationActivity;
import com.ziroom.ziroomcustomer.ziroomstation.model.DaysPrice;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails.DataBean.ListOrderPriceVoBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateHouseEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoom;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRuleBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRuleBean.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.TypePrice;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.b;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.c;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.c.a;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.f;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.g;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StationProjectDetailActivity
  extends BaseFluxSupportURIActivity
{
  private String A;
  private String B;
  private Calendar C;
  private Calendar D;
  private int E = 0;
  private int F = -1;
  private Map<String, Integer> G;
  private List<Integer> H = new ArrayList();
  private List<TextView> I = new ArrayList();
  private List<String> J = new ArrayList();
  private int K;
  private com.ziroom.ziroomcustomer.minsu.searchlist.a.a L;
  private com.ziroom.ziroomcustomer.minsu.searchlist.c.a M;
  private com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.c N;
  private StrategySearchListBean O;
  private List<DaysPrice> P;
  private String Q;
  private float R;
  private String S;
  private boolean T;
  private boolean U;
  private boolean V = false;
  private CycleViewPager.a W = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (StationProjectDetailActivity.this.b.isCycle())
      {
        paramAnonymousView = new ArrayList();
        Intent localIntent = new Intent(StationProjectDetailActivity.this, ScanPhotoActivity.class);
        Bundle localBundle = new Bundle();
        paramAnonymousView.addAll(StationProjectDetailActivity.y(StationProjectDetailActivity.this));
        localBundle.putSerializable("photos", paramAnonymousView);
        localIntent.putExtra("position", paramAnonymousInt - 1);
        localIntent.putExtras(localBundle);
        localIntent.putExtra("mHouse_type", 0);
        ScanPhotoActivity.a = StationProjectDetailActivity.z(StationProjectDetailActivity.this);
        StationProjectDetailActivity.this.startActivity(localIntent);
      }
    }
  };
  private CycleViewPager.b X = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      int i = 0;
      if (i < StationProjectDetailActivity.A(StationProjectDetailActivity.this).size())
      {
        TextView localTextView = (TextView)StationProjectDetailActivity.A(StationProjectDetailActivity.this).get(i);
        if (i + 1 >= StationProjectDetailActivity.A(StationProjectDetailActivity.this).size())
        {
          if (((Integer)StationProjectDetailActivity.B(StationProjectDetailActivity.this).get(i)).intValue() <= paramAnonymousInt) {
            StationProjectDetailActivity.c(StationProjectDetailActivity.this, i);
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
          if ((((Integer)StationProjectDetailActivity.B(StationProjectDetailActivity.this).get(i)).intValue() > paramAnonymousInt) || (paramAnonymousInt > ((Integer)StationProjectDetailActivity.B(StationProjectDetailActivity.this).get(i + 1)).intValue())) {
            break label85;
          }
          StationProjectDetailActivity.c(StationProjectDetailActivity.this, i);
          break label85;
          label174:
          localTextView.setBackgroundDrawable(null);
        }
      }
      ((TextView)StationProjectDetailActivity.A(StationProjectDetailActivity.this).get(StationProjectDetailActivity.C(StationProjectDetailActivity.this))).setBackgroundResource(2130838624);
      ((TextView)StationProjectDetailActivity.A(StationProjectDetailActivity.this).get(StationProjectDetailActivity.C(StationProjectDetailActivity.this))).setTextColor(ApplicationEx.c.getResources().getColor(2131624583));
    }
  };
  private PlatformActionListener Y = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      StationProjectDetailActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      StationProjectDetailActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  CycleViewPager b;
  @BindView(2131690078)
  ImageView btn_back;
  @BindView(2131690459)
  ImageView btn_call;
  @BindView(2131692541)
  TextView btn_cannot_order;
  @BindView(2131691363)
  TextView btn_confirm;
  @BindView(2131692561)
  View btn_end_time;
  @BindView(2131691381)
  View btn_eva_all;
  @BindView(2131691386)
  View btn_fac_all;
  @BindView(2131692576)
  TextView btn_panoramic;
  @BindView(2131692539)
  View btn_price_detail;
  @BindView(2131692554)
  View btn_project_intro_more;
  @BindView(2131691393)
  ImageView btn_share;
  @BindView(2131692558)
  View btn_start_time;
  @BindView(2131692549)
  View btn_station_location;
  @BindView(2131692573)
  View btn_strategy_more;
  @BindView(2131692578)
  View btn_title_check_in;
  @BindView(2131692581)
  View btn_title_check_out;
  private Context c;
  @BindView(2131692571)
  CustomViewPager cvp_wonderful_activities;
  private com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b d;
  private com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.b e;
  private com.freelxl.baselibrary.a.a f;
  private com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.a g;
  @BindView(2131692575)
  View iv_title_cover;
  @BindView(2131692537)
  View iv_total_price_right_icon;
  @BindView(2131691387)
  LinearLayout ll_fac_container;
  @BindView(2131692567)
  View ll_fac_out_container;
  @BindView(2131692569)
  View ll_rule_container;
  @BindView(2131692564)
  View ll_station_evaluate_container;
  @BindView(2131692572)
  View ll_strategy_container;
  @BindView(2131692557)
  View ll_time_selector_container;
  @BindView(2131692577)
  View ll_title_date_container;
  @BindView(2131692570)
  View ll_wonderful_activities_container;
  @BindView(2131691388)
  ListView lv_rule;
  @BindView(2131690884)
  LinearLayout mLlCarousel;
  @BindView(2131691365)
  ObservableScrollView osv_main;
  private List<StationWonderfulActivitiesFragment> r = new ArrayList();
  @BindView(2131691379)
  View rl_eva_container;
  @BindView(2131691392)
  View rl_title_container;
  @BindView(2131692566)
  RecyclerView rv_evaluate;
  @BindView(2131692563)
  RecyclerView rv_station_room;
  @BindView(2131692574)
  RecyclerView rv_strategy;
  private List<MinsuHouseDetailConfigBean> s;
  private float t;
  @BindView(2131692547)
  View tv_no_evaluate;
  @BindView(2131692546)
  TextView tv_project_eva_count;
  @BindView(2131692545)
  TextView tv_project_eva_grade;
  @BindView(2131692543)
  TextView tv_project_name;
  @BindView(2131692559)
  TextView tv_station_check_in_time;
  @BindView(2131692562)
  TextView tv_station_check_out_time;
  @BindView(2131692551)
  TextView tv_station_location;
  @BindView(2131692552)
  TextView tv_station_location_transport;
  @BindView(2131692555)
  TextView tv_station_project_intro;
  @BindView(2131692560)
  TextView tv_stay_in_count;
  @BindView(2131692579)
  TextView tv_title_check_in_info;
  @BindView(2131692582)
  TextView tv_title_check_out_info;
  @BindView(2131692580)
  TextView tv_title_date_check_in;
  @BindView(2131692583)
  TextView tv_title_date_check_out;
  private float u = -1.0F;
  private String v;
  @BindView(2131692556)
  View v_date_bottom_line;
  @BindView(2131692568)
  View v_fac_line;
  @BindView(2131691395)
  View v_title_bottom;
  private int w;
  private String x;
  private List<StationRuleBean.DataBean> y;
  private float z;
  @BindView(2131692548)
  ZiroomFlowLayout zfl_station_project_label_container;
  
  private ArrayList<DaysPrice> a(List<DaysPrice> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      DaysPrice localDaysPrice = new DaysPrice();
      ArrayList localArrayList2 = new ArrayList();
      localDaysPrice.dayDate = ((DaysPrice)paramList.get(i)).dayDate;
      Iterator localIterator = ((DaysPrice)paramList.get(i)).typePriceList.iterator();
      while (localIterator.hasNext())
      {
        TypePrice localTypePrice = (TypePrice)localIterator.next();
        if (localTypePrice.num != 0) {
          localArrayList2.add(localTypePrice);
        }
      }
      localDaysPrice.typePriceList = localArrayList2;
      localArrayList1.add(localDaysPrice);
      i += 1;
    }
    return localArrayList1;
  }
  
  private void a()
  {
    this.b = ((CycleViewPager)getSupportFragmentManager().findFragmentById(2131690882));
    GrowingIO.getInstance().ignoreFragment(this, this.b);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.t = (localDisplayMetrics.widthPixels / 2 - n.dip2px(this.c, 48.0F));
    this.v_date_bottom_line.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        StationProjectDetailActivity.a(StationProjectDetailActivity.this, StationProjectDetailActivity.this.v_date_bottom_line.getBottom() - n.dip2px(StationProjectDetailActivity.a(StationProjectDetailActivity.this), 48.0F));
        StationProjectDetailActivity.this.v_date_bottom_line.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
      }
    });
    this.osv_main.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f1 = 0.0F;
        float f2 = paramAnonymousInt2 / StationProjectDetailActivity.b(StationProjectDetailActivity.this);
        View localView = StationProjectDetailActivity.this.iv_title_cover;
        if (f2 < 0.0F)
        {
          localView.setAlpha(f1);
          if (f2 < 0.75D) {
            break label228;
          }
          if (StationProjectDetailActivity.c(StationProjectDetailActivity.this) != 1)
          {
            StationProjectDetailActivity.a(StationProjectDetailActivity.this, 1);
            StationProjectDetailActivity.this.rl_title_container.setBackgroundColor(Color.parseColor("#ffffff"));
            StationProjectDetailActivity.this.btn_call.setImageResource(2130840151);
            StationProjectDetailActivity.this.btn_back.setImageResource(2130840141);
            StationProjectDetailActivity.this.btn_share.setImageResource(2130840338);
            StationProjectDetailActivity.this.btn_panoramic.setTextColor(Color.parseColor("#666666"));
            StationProjectDetailActivity.this.v_title_bottom.setVisibility(0);
          }
        }
        for (;;)
        {
          if (paramAnonymousInt2 / StationProjectDetailActivity.d(StationProjectDetailActivity.this) > 1.0F) {
            break label325;
          }
          StationProjectDetailActivity.this.ll_title_date_container.setVisibility(8);
          if ((StationProjectDetailActivity.e(StationProjectDetailActivity.this) != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData() != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getIsShowPanoramic() == 1)) {
            StationProjectDetailActivity.this.btn_panoramic.setVisibility(0);
          }
          return;
          f1 = f2;
          break;
          label228:
          StationProjectDetailActivity.a(StationProjectDetailActivity.this, 0);
          StationProjectDetailActivity.this.rl_title_container.setBackground(StationProjectDetailActivity.this.getResources().getDrawable(2130838551));
          StationProjectDetailActivity.this.btn_call.setImageResource(2130840152);
          StationProjectDetailActivity.this.btn_back.setImageResource(2130840142);
          StationProjectDetailActivity.this.btn_share.setImageResource(2130840339);
          StationProjectDetailActivity.this.btn_panoramic.setTextColor(Color.parseColor("#ffffff"));
          StationProjectDetailActivity.this.v_title_bottom.setVisibility(8);
        }
        label325:
        StationProjectDetailActivity.this.ll_title_date_container.setVisibility(0);
        StationProjectDetailActivity.this.btn_panoramic.setVisibility(8);
      }
    });
    this.rv_evaluate.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
    this.g = new com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.a(this);
    this.rv_evaluate.setAdapter(this.g);
    this.rv_station_room.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
    this.rv_station_room.getItemAnimator().setChangeDuration(0L);
    this.e = new com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.b(this.c, null, true, new b.b()
    {
      public void onOtherBedSelect(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.ziroom.ziroomcustomer.minsu.f.k.toInventoryCalendarActivity((Activity)StationProjectDetailActivity.a(StationProjectDetailActivity.this), StationProjectDetailActivity.f(StationProjectDetailActivity.this), StationProjectDetailActivity.g(StationProjectDetailActivity.this), paramAnonymousString1, paramAnonymousString2 + " • " + paramAnonymousString3);
      }
      
      public void onSelect()
      {
        StationProjectDetailActivity.this.updateTotalPriceShow();
      }
      
      public void shouldSelectTime()
      {
        if ((StationProjectDetailActivity.h(StationProjectDetailActivity.this) == null) || (StationProjectDetailActivity.i(StationProjectDetailActivity.this) == null))
        {
          Object localObject = new SimpleDateFormat("yyyy-MM-dd");
          try
          {
            Activity localActivity = (Activity)StationProjectDetailActivity.a(StationProjectDetailActivity.this);
            if (TextUtils.isEmpty(StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getOpenTime())) {}
            for (localObject = null;; localObject = ((SimpleDateFormat)localObject).parse(StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getOpenTime()))
            {
              com.ziroom.ziroomcustomer.minsu.f.k.toCustomTimeSelectActivityForResult(localActivity, (Date)localObject, StationProjectDetailActivity.i(StationProjectDetailActivity.this), StationProjectDetailActivity.h(StationProjectDetailActivity.this));
              return;
            }
            return;
          }
          catch (ParseException localParseException)
          {
            com.ziroom.ziroomcustomer.minsu.f.k.toCustomTimeSelectActivityForResult((Activity)StationProjectDetailActivity.a(StationProjectDetailActivity.this), null, StationProjectDetailActivity.i(StationProjectDetailActivity.this), StationProjectDetailActivity.h(StationProjectDetailActivity.this));
          }
        }
      }
    });
    this.rv_station_room.setAdapter(this.e);
    this.rv_strategy.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
    this.N = new com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.c(this.c);
    this.rv_strategy.setAdapter(this.N);
  }
  
  private void a(com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b paramb)
  {
    ArrayList localArrayList1 = new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(paramb.getData().getListProImg());
    if (localArrayList2.size() > 0)
    {
      int j = 0;
      int k = 1;
      if (j < localArrayList2.size())
      {
        paramb = (b.a.g)localArrayList2.get(j);
        int i = k;
        String str;
        if (paramb.getUrl() != null)
        {
          i = k;
          if (paramb.getUrl().size() > 0)
          {
            localArrayList1.addAll(paramb.getUrl());
            str = paramb.getShowName();
            if (!localLinkedHashMap.containsKey(str)) {
              break label222;
            }
            i = 1;
            while (localLinkedHashMap.containsKey(str + i)) {
              i += 1;
            }
            localLinkedHashMap.put(str + i, Integer.valueOf(k));
          }
        }
        for (i = k + paramb.getUrl().size();; i = k + paramb.getUrl().size())
        {
          j += 1;
          k = i;
          break;
          label222:
          localLinkedHashMap.put(str, Integer.valueOf(k));
        }
      }
    }
    showCarousel(localArrayList1, localArrayList1, localLinkedHashMap);
  }
  
  private void b()
  {
    this.M = new com.ziroom.ziroomcustomer.minsu.searchlist.c.a(this);
    this.a.register(this.M);
    this.L = com.ziroom.ziroomcustomer.minsu.searchlist.a.a.getInstance(this.a);
  }
  
  private void d(String paramString)
  {
    paramString = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildRules(this.c, this.v, paramString);
    com.freelxl.baselibrary.d.a.post(q.B + com.ziroom.ziroomcustomer.ziroomstation.b.d.I).params(paramString).enqueue(new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(StationRuleBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, StationRuleBean paramAnonymousStationRuleBean)
      {
        StationProjectDetailActivity.b(StationProjectDetailActivity.this, paramAnonymousStationRuleBean.getData());
        StationProjectDetailActivity.D(StationProjectDetailActivity.this);
      }
    });
  }
  
  private Calendar e(String paramString)
  {
    Calendar localCalendar = null;
    if (ae.isNull(paramString)) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      return localCalendar;
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localCalendar;
      }
    }
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    this.C = ((Calendar)localIntent.getSerializableExtra("dateStart"));
    this.D = ((Calendar)localIntent.getSerializableExtra("dateEnd"));
    this.v = localIntent.getStringExtra("projectBid");
    this.A = localIntent.getStringExtra("startDate");
    this.B = localIntent.getStringExtra("endDate");
    if (ApplicationEx.c.getUser() != null) {
      this.S = ApplicationEx.c.getUser().getUid();
    }
    f();
  }
  
  private void f()
  {
    Map localMap = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildProjectDetail(this.c, this.v);
    com.freelxl.baselibrary.d.a.post(q.B + com.ziroom.ziroomcustomer.ziroomstation.b.d.H).params(localMap).enqueue(new com.ziroom.commonlibrary.a.a(this.c, new com.freelxl.baselibrary.d.f.d(com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b paramAnonymousb)
      {
        String str = null;
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        StationProjectDetailActivity.a(StationProjectDetailActivity.this, paramAnonymousb);
        StationProjectDetailActivity.j(StationProjectDetailActivity.this);
        if ((StationProjectDetailActivity.e(StationProjectDetailActivity.this) != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData() != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getCheckNotice() != null))
        {
          paramAnonymousb = new StringBuilder();
          localObject = StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getCheckNotice().iterator();
          while (((Iterator)localObject).hasNext()) {
            paramAnonymousb.append(((b.a.b)((Iterator)localObject).next()).getType()).append(",");
          }
          if (paramAnonymousb.length() > 0)
          {
            paramAnonymousb.deleteCharAt(paramAnonymousb.length() - 1);
            StationProjectDetailActivity.a(StationProjectDetailActivity.this, paramAnonymousb.toString());
          }
        }
        StationProjectDetailActivity.k(StationProjectDetailActivity.this);
        StationProjectDetailActivity.l(StationProjectDetailActivity.this);
        StationProjectDetailActivity.m(StationProjectDetailActivity.this);
        StationProjectDetailActivity.n(StationProjectDetailActivity.this);
        StationProjectDetailActivity.this.ll_time_selector_container.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public boolean onPreDraw()
          {
            StationProjectDetailActivity.b(StationProjectDetailActivity.this, StationProjectDetailActivity.this.ll_time_selector_container.getTop() - n.dip2px(StationProjectDetailActivity.a(StationProjectDetailActivity.this), 48.0F));
            StationProjectDetailActivity.this.ll_time_selector_container.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
          }
        });
        StationProjectDetailActivity.o(StationProjectDetailActivity.this);
        StationProjectDetailActivity.p(StationProjectDetailActivity.this);
        StationProjectDetailActivity.q(StationProjectDetailActivity.this);
        StationProjectDetailActivity.b(StationProjectDetailActivity.this, StationProjectDetailActivity.e(StationProjectDetailActivity.this));
        StationProjectDetailActivity.r(StationProjectDetailActivity.this);
        StationProjectDetailActivity.this.v_date_bottom_line.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public boolean onPreDraw()
          {
            StationProjectDetailActivity.a(StationProjectDetailActivity.this, StationProjectDetailActivity.this.v_date_bottom_line.getBottom() - n.dip2px(StationProjectDetailActivity.a(StationProjectDetailActivity.this), 48.0F));
            StationProjectDetailActivity.this.v_date_bottom_line.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
          }
        });
        Object localObject = StationProjectDetailActivity.this;
        if (ae.isNull(StationProjectDetailActivity.f(StationProjectDetailActivity.this)))
        {
          paramAnonymousb = null;
          StationProjectDetailActivity.a((StationProjectDetailActivity)localObject, paramAnonymousb);
          localObject = StationProjectDetailActivity.this;
          if (!ae.isNull(StationProjectDetailActivity.g(StationProjectDetailActivity.this))) {
            break label621;
          }
          paramAnonymousb = str;
          label319:
          StationProjectDetailActivity.b((StationProjectDetailActivity)localObject, paramAnonymousb);
          if ((StationProjectDetailActivity.e(StationProjectDetailActivity.this) != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData() != null))
          {
            paramAnonymousb = StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getOpenTime();
            str = StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getEndlineTime();
            if ((TextUtils.isEmpty(StationProjectDetailActivity.f(StationProjectDetailActivity.this))) || (TextUtils.isEmpty(StationProjectDetailActivity.g(StationProjectDetailActivity.this)))) {
              break label789;
            }
            paramAnonymousInt = paramAnonymousb.compareTo(StationProjectDetailActivity.f(StationProjectDetailActivity.this));
            int i = str.compareTo(StationProjectDetailActivity.g(StationProjectDetailActivity.this));
            if (paramAnonymousInt <= 0) {
              break label639;
            }
            StationProjectDetailActivity.a(StationProjectDetailActivity.this, false);
            StationProjectDetailActivity.this.showToast("所选日期暂时不能预订，换一个自如驿试试吧！");
            label451:
            com.freelxl.baselibrary.f.d.e("StationProjectDetailActivity", "stationOpenTime===" + paramAnonymousb + "------startDate===" + StationProjectDetailActivity.f(StationProjectDetailActivity.this));
            if (i <= 0) {
              break label667;
            }
            StationProjectDetailActivity.b(StationProjectDetailActivity.this, true);
            label503:
            com.freelxl.baselibrary.f.d.e("StationProjectDetailActivity", "stationEndlineTime===" + str + "------endDate===" + StationProjectDetailActivity.g(StationProjectDetailActivity.this));
            if ((StationProjectDetailActivity.s(StationProjectDetailActivity.this)) && (StationProjectDetailActivity.t(StationProjectDetailActivity.this)))
            {
              if ((StationProjectDetailActivity.i(StationProjectDetailActivity.this) != null) && (StationProjectDetailActivity.h(StationProjectDetailActivity.this) != null)) {
                break label704;
              }
              StationProjectDetailActivity.this.tv_stay_in_count.setVisibility(8);
            }
          }
        }
        for (;;)
        {
          StationProjectDetailActivity.u(StationProjectDetailActivity.this);
          return;
          paramAnonymousb = StationProjectDetailActivity.b(StationProjectDetailActivity.this, StationProjectDetailActivity.f(StationProjectDetailActivity.this));
          break;
          label621:
          paramAnonymousb = StationProjectDetailActivity.b(StationProjectDetailActivity.this, StationProjectDetailActivity.g(StationProjectDetailActivity.this));
          break label319;
          label639:
          if (paramAnonymousInt == 0)
          {
            StationProjectDetailActivity.a(StationProjectDetailActivity.this, true);
            break label451;
          }
          StationProjectDetailActivity.a(StationProjectDetailActivity.this, true);
          break label451;
          label667:
          if (paramAnonymousInt == 0)
          {
            StationProjectDetailActivity.b(StationProjectDetailActivity.this, true);
            break label503;
          }
          StationProjectDetailActivity.b(StationProjectDetailActivity.this, false);
          StationProjectDetailActivity.this.showToast("所选日期暂时不能预订，换一个自如驿试试吧！");
          break label503;
          label704:
          StationProjectDetailActivity.this.tv_stay_in_count.setVisibility(0);
          StationProjectDetailActivity.this.tv_stay_in_count.setText("共 " + m.getDaysBetween(new Date(StationProjectDetailActivity.i(StationProjectDetailActivity.this).getTimeInMillis()), new Date(StationProjectDetailActivity.h(StationProjectDetailActivity.this).getTimeInMillis())) + " 晚");
          continue;
          label789:
          StationProjectDetailActivity.a(StationProjectDetailActivity.this, true);
          StationProjectDetailActivity.b(StationProjectDetailActivity.this, true);
        }
      }
    });
  }
  
  private void g()
  {
    Object localObject = a(this.e.getBedData());
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((DaysPrice)((List)localObject).get(0)).typePriceList.size())
    {
      int j = 0;
      int k = 0;
      while (j < ((List)localObject).size())
      {
        k += (int)((TypePrice)((DaysPrice)((List)localObject).get(j)).typePriceList.get(i)).typePrice;
        j += 1;
      }
      localArrayList.add(new StationOrderCreateHouseEntity(((TypePrice)((DaysPrice)((List)localObject).get(0)).typePriceList.get(i)).availableCount, ((TypePrice)((DaysPrice)((List)localObject).get(0)).typePriceList.get(i)).num, ((TypePrice)((DaysPrice)((List)localObject).get(0)).typePriceList.get(i)).roomName + "/" + ((TypePrice)((DaysPrice)((List)localObject).get(0)).typePriceList.get(i)).typeName, k, ((TypePrice)((DaysPrice)((List)localObject).get(0)).typePriceList.get(i)).houseTypeBid, 0));
      i += 1;
    }
    localObject = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildOrderMoney(this.c, this.v, "", new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.C.getTimeInMillis())), new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.D.getTimeInMillis())), this.S, null, localArrayList);
    com.ziroom.ziroomcustomer.ziroomstation.b.c.getOrderMoney(this.c, (Map)localObject, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        paramAnonymousk = (OrderMoneyDetails)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())))
        {
          StationProjectDetailActivity.a(StationProjectDetailActivity.this, new ArrayList());
          StationProjectDetailActivity.b(StationProjectDetailActivity.this, paramAnonymousk.getData().getAmount());
          StationProjectDetailActivity.c(StationProjectDetailActivity.this, paramAnonymousk.getData().getPromptStr());
          List localList1 = paramAnonymousk.getData().getListOrderPriceVo();
          if (s.isEmpty(localList1)) {
            return;
          }
          int i = 0;
          if (i < localList1.size())
          {
            DaysPrice localDaysPrice = new DaysPrice();
            localDaysPrice.dayDate = m.changeFormatToDate(((OrderMoneyDetails.DataBean.ListOrderPriceVoBean)localList1.get(i)).getOrderDay(), m.b, m.l);
            ArrayList localArrayList = new ArrayList();
            List localList2 = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean)paramAnonymousk.getData().getListOrderPriceVo().get(i)).getListHouseTypePrice();
            if (s.isEmpty(localList2)) {}
            for (;;)
            {
              i += 1;
              break;
              int j = 0;
              while (j < localList2.size())
              {
                TypePrice localTypePrice = new TypePrice();
                localTypePrice.roomName = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList2.get(j)).getHouseTypeParentShowName();
                localTypePrice.typeName = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList2.get(j)).getHouseTypeName();
                localTypePrice.typePrice = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList2.get(j)).getPrice();
                localTypePrice.isPreferential = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList2.get(j)).getIsPreferential();
                localTypePrice.num = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList2.get(j)).getQuantity();
                localArrayList.add(localTypePrice);
                j += 1;
              }
              localDaysPrice.typePriceList = localArrayList;
              StationProjectDetailActivity.v(StationProjectDetailActivity.this).add(localDaysPrice);
            }
          }
          new com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view.b(StationProjectDetailActivity.a(StationProjectDetailActivity.this), StationProjectDetailActivity.v(StationProjectDetailActivity.this), StationProjectDetailActivity.w(StationProjectDetailActivity.this), StationProjectDetailActivity.x(StationProjectDetailActivity.this), new com.ziroom.ziroomcustomer.ziroomstation.a.a()
          {
            public void callback(int paramAnonymous2Int) {}
          }).showPriceWindow();
          return;
        }
        af.showToast(StationProjectDetailActivity.a(StationProjectDetailActivity.this), paramAnonymousk.getError_message());
      }
    }, true);
  }
  
  private void h()
  {
    if ((this.L != null) && (this.d != null) && (this.d.getData() != null)) {
      this.L.queryStrategyListFromStation(this, this, 1, this.d.getData().getCityCode(), this.d.getData().getBusinessAreas());
    }
  }
  
  private void i()
  {
    if ((this.d != null) && (this.d.getData() != null) && (this.C != null) && (this.D != null) && (this.d.getData().getCanOrder() != 1))
    {
      this.btn_cannot_order.setVisibility(0);
      this.btn_confirm.setVisibility(8);
      this.btn_price_detail.setVisibility(8);
      this.btn_cannot_order.setText(this.d.getData().getCanOrderTip());
      return;
    }
    this.btn_cannot_order.setVisibility(8);
    this.btn_confirm.setVisibility(0);
    this.btn_price_detail.setVisibility(8);
  }
  
  private void j()
  {
    if ((this.d != null) && (this.d.getData() != null) && (this.d.getData().getIsShowPanoramic() == 1))
    {
      this.btn_panoramic.setVisibility(0);
      return;
    }
    this.btn_panoramic.setVisibility(8);
  }
  
  private void k()
  {
    if ((this.C != null) && (this.D != null) && (this.v != null) && (this.d != null) && (this.d.getData() != null))
    {
      Map localMap = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildStationRoomPrice(this.c, this.v, m.getFormatDate(new Date(this.C.getTimeInMillis()), m.b), m.getFormatDate(new Date(this.D.getTimeInMillis()), m.b));
      com.freelxl.baselibrary.d.a.post(q.T + com.ziroom.ziroomcustomer.ziroomstation.b.d.e).params(localMap).enqueue(new com.ziroom.commonlibrary.a.a(this.c, new com.freelxl.baselibrary.d.f.d(StationRoom.class))
      {
        public void onSuccess(int paramAnonymousInt, StationRoom paramAnonymousStationRoom)
        {
          boolean bool = false;
          super.onSuccess(paramAnonymousInt, paramAnonymousStationRoom);
          if (paramAnonymousStationRoom.error_code == 200)
          {
            localObject1 = m.getFormatDate(StationProjectDetailActivity.i(StationProjectDetailActivity.this).getTime(), "MM月dd日 E");
            localObject2 = m.getFormatDate(StationProjectDetailActivity.h(StationProjectDetailActivity.this).getTime(), "MM月dd日 E");
            localObject3 = m.getFormatDate(StationProjectDetailActivity.i(StationProjectDetailActivity.this).getTime(), "MM.dd");
            str = m.getFormatDate(StationProjectDetailActivity.h(StationProjectDetailActivity.this).getTime(), "MM.dd");
            if ((StationProjectDetailActivity.s(StationProjectDetailActivity.this)) && (StationProjectDetailActivity.t(StationProjectDetailActivity.this)))
            {
              StationProjectDetailActivity.this.tv_station_check_in_time.setText((CharSequence)localObject1);
              StationProjectDetailActivity.this.tv_station_check_out_time.setText((CharSequence)localObject2);
              if ((!StationProjectDetailActivity.s(StationProjectDetailActivity.this)) || (!StationProjectDetailActivity.t(StationProjectDetailActivity.this))) {
                break label472;
              }
              StationProjectDetailActivity.this.tv_title_check_in_info.setText(StationProjectDetailActivity.this.getString(2131297473));
              StationProjectDetailActivity.this.tv_title_check_out_info.setText(StationProjectDetailActivity.this.getString(2131297475));
              StationProjectDetailActivity.this.tv_title_date_check_in.setText((CharSequence)localObject3);
              StationProjectDetailActivity.this.tv_title_date_check_out.setText(str);
              if ((StationProjectDetailActivity.e(StationProjectDetailActivity.this) != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData() != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getCanOrder() == 1))
              {
                StationProjectDetailActivity.this.btn_confirm.setText("立即预定");
                StationProjectDetailActivity.this.btn_price_detail.setVisibility(0);
              }
              if ((StationProjectDetailActivity.F(StationProjectDetailActivity.this) != null) && (paramAnonymousStationRoom.data != null) && (paramAnonymousStationRoom.data.size() > 0))
              {
                localObject1 = StationProjectDetailActivity.F(StationProjectDetailActivity.this);
                paramAnonymousStationRoom = paramAnonymousStationRoom.data;
                localObject2 = StationProjectDetailActivity.i(StationProjectDetailActivity.this);
                localObject3 = StationProjectDetailActivity.h(StationProjectDetailActivity.this);
                if ((StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getCanOrder() == 1) || (StationProjectDetailActivity.i(StationProjectDetailActivity.this) == null) || (StationProjectDetailActivity.h(StationProjectDetailActivity.this) == null)) {
                  bool = true;
                }
                ((com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.b)localObject1).updateBedData(paramAnonymousStationRoom, (Calendar)localObject2, (Calendar)localObject3, bool);
                StationProjectDetailActivity.this.updateTotalPriceShow();
              }
            }
          }
          label472:
          while (TextUtils.isEmpty(paramAnonymousStationRoom.error_message)) {
            for (;;)
            {
              Object localObject1;
              Object localObject2;
              Object localObject3;
              String str;
              return;
              if (StationProjectDetailActivity.E(StationProjectDetailActivity.this))
              {
                StationProjectDetailActivity.this.tv_station_check_in_time.setText((CharSequence)localObject1);
                StationProjectDetailActivity.this.tv_station_check_out_time.setText((CharSequence)localObject2);
              }
              else
              {
                StationProjectDetailActivity.this.tv_station_check_in_time.setText(StationProjectDetailActivity.this.getString(2131297487));
                StationProjectDetailActivity.this.tv_station_check_out_time.setText(StationProjectDetailActivity.this.getString(2131297487));
                continue;
                if (StationProjectDetailActivity.E(StationProjectDetailActivity.this))
                {
                  StationProjectDetailActivity.this.tv_title_check_in_info.setText(StationProjectDetailActivity.this.getString(2131297473));
                  StationProjectDetailActivity.this.tv_title_check_out_info.setText(StationProjectDetailActivity.this.getString(2131297475));
                  StationProjectDetailActivity.this.tv_title_date_check_in.setText((CharSequence)localObject3);
                  StationProjectDetailActivity.this.tv_title_date_check_out.setText(str);
                }
                else
                {
                  StationProjectDetailActivity.this.tv_title_check_in_info.setText(StationProjectDetailActivity.this.getString(2131297474));
                  StationProjectDetailActivity.this.tv_title_check_out_info.setText(StationProjectDetailActivity.this.getString(2131297476));
                  StationProjectDetailActivity.this.tv_title_date_check_in.setText("");
                  StationProjectDetailActivity.this.tv_title_date_check_out.setText("");
                }
              }
            }
          }
          af.showToast(StationProjectDetailActivity.a(StationProjectDetailActivity.this), paramAnonymousStationRoom.error_message);
          StationProjectDetailActivity.a(StationProjectDetailActivity.this, null);
          StationProjectDetailActivity.b(StationProjectDetailActivity.this, null);
          StationProjectDetailActivity.this.tv_stay_in_count.setVisibility(0);
          StationProjectDetailActivity.this.tv_stay_in_count.setText(null);
          StationProjectDetailActivity.this.tv_station_check_in_time.setText(StationProjectDetailActivity.this.getString(2131297487));
          StationProjectDetailActivity.this.tv_station_check_out_time.setText(StationProjectDetailActivity.this.getString(2131297487));
          StationProjectDetailActivity.this.tv_title_check_in_info.setText(StationProjectDetailActivity.this.getString(2131297474));
          StationProjectDetailActivity.this.tv_title_check_out_info.setText(StationProjectDetailActivity.this.getString(2131297476));
          StationProjectDetailActivity.this.tv_title_date_check_in.setText("");
          StationProjectDetailActivity.this.tv_title_date_check_out.setText("");
          if ((StationProjectDetailActivity.e(StationProjectDetailActivity.this) != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData() != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getCanOrder() == 1))
          {
            StationProjectDetailActivity.this.btn_confirm.setText("选择日期");
            StationProjectDetailActivity.this.btn_price_detail.setVisibility(8);
          }
          StationProjectDetailActivity.m(StationProjectDetailActivity.this);
        }
      });
    }
  }
  
  private void l()
  {
    if ((this.d != null) && (this.d.getData() != null))
    {
      this.tv_project_name.setText(this.d.getData().getProjectName());
      this.tv_station_project_intro.setText(this.d.getData().getProjectDesc());
      m();
    }
  }
  
  private void m()
  {
    this.zfl_station_project_label_container.removeAllViews();
    int i;
    int j;
    int k;
    Iterator localIterator;
    if ((this.d.getData().getLabels() != null) && (this.d.getData().getLabels().size() > 0))
    {
      this.zfl_station_project_label_container.setMaxLine(1);
      this.zfl_station_project_label_container.setVisibility(0);
      i = n.dip2px(this.c, 14.0F);
      j = n.dip2px(this.c, 9.0F);
      k = n.dip2px(this.c, 7.0F);
      localIterator = this.d.getData().getLabels().iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject = (b.a.f)localIterator.next();
      TextView localTextView = new TextView(this.c);
      localTextView.setText(((b.a.f)localObject).getLabel());
      localTextView.setPadding(j, k, j, k);
      localTextView.setTextColor(getResources().getColor(2131624494));
      localTextView.setTextSize(2, 12.0F);
      localTextView.setBackgroundResource(2130839676);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = i;
      this.zfl_station_project_label_container.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      continue;
      this.zfl_station_project_label_container.setVisibility(8);
    }
  }
  
  private void n()
  {
    if ((this.d != null) && (this.d.getData() != null) && (this.d.getData().getLat() >= 0.0D) && (this.d.getData().getLng() >= 0.0D))
    {
      this.tv_station_location.setText(this.d.getData().getTradeArea() + " · " + this.d.getData().getProjectAddress());
      this.tv_station_location_transport.setText(this.d.getData().getSubwayLine());
    }
  }
  
  private void o()
  {
    boolean bool2 = true;
    com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a.b localb;
    List localList;
    if ((this.d != null) && (this.d.getData() != null) && (this.d.getData().getHouseTypeList() != null))
    {
      localb = this.e;
      localList = this.d.getData().getHouseTypeList();
      bool1 = bool2;
      if (this.d.getData().getCanOrder() != 1)
      {
        bool1 = bool2;
        if (this.C != null) {
          if (this.D != null) {
            break label91;
          }
        }
      }
    }
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localb.setRoomData(localList, bool1);
      return;
    }
  }
  
  private void p()
  {
    Object localObject3;
    if ((this.d != null) && (this.d.getData() != null) && (this.d.getData().getPartFacilityVals() != null) && (this.d.getData().getPartFacilityVals().size() > 0))
    {
      this.ll_fac_out_container.setVisibility(0);
      this.v_fac_line.setVisibility(0);
      localObject3 = this.d.getData().getPartFacilityVals().iterator();
    }
    Object localObject1;
    Object localObject4;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (b.a.c)((Iterator)localObject3).next();
      localObject4 = new LinearLayout(this.c);
      ((LinearLayout)localObject4).setOrientation(1);
      ((LinearLayout)localObject4).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
      localObject2 = new SimpleDraweeView(this.c);
      Object localObject5 = new LinearLayout.LayoutParams(n.dip2px(this.c, 32.0F), n.dip2px(this.c, 32.0F));
      ((LinearLayout.LayoutParams)localObject5).gravity = 1;
      ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((SimpleDraweeView)localObject2).setController(com.freelxl.baselibrary.f.c.frescoController(((b.a.c)localObject1).getIconUrl()));
      ((LinearLayout)localObject4).addView((View)localObject2);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, n.dip2px(this.c, 4.0F), 0, 0);
      localObject5 = new TextView(this.c);
      ((TextView)localObject5).setTextSize(12.0F);
      ((TextView)localObject5).setSingleLine();
      ((TextView)localObject5).setTextColor(getResources().getColor(2131624039));
      ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject5).setGravity(17);
      localObject2 = ((b.a.c)localObject1).getText();
      localObject1 = localObject2;
      if (((String)localObject2).length() >= 5) {
        localObject1 = ((String)localObject2).substring(0, 4) + "...";
      }
      ((TextView)localObject5).setText((CharSequence)localObject1);
      ((LinearLayout)localObject4).addView((View)localObject5);
      this.ll_fac_container.addView((View)localObject4);
      continue;
      this.ll_fac_out_container.setVisibility(8);
      this.v_fac_line.setVisibility(8);
      return;
      break label506;
    }
    label372:
    int i = this.d.getData().getPartFacilityVals().size();
    while (i < 5)
    {
      localObject1 = new LinearLayout(this.c);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
      this.ll_fac_container.addView((View)localObject1);
      i += 1;
    }
    if ((this.d.getData().getSubFacilityVals() != null) && (this.d.getData().getSubFacilityVals().size() > 0))
    {
      this.btn_fac_all.setVisibility(0);
      this.s = new ArrayList();
      localObject1 = this.d.getData().getSubFacilityVals().iterator();
      for (;;)
      {
        label506:
        if (!((Iterator)localObject1).hasNext()) {
          break label372;
        }
        localObject2 = (b.a.c)((Iterator)localObject1).next();
        localObject3 = new MinsuHouseDetailConfigBean();
        ((MinsuHouseDetailConfigBean)localObject3).setIcPath(((b.a.c)localObject2).getIconUrl());
        ((MinsuHouseDetailConfigBean)localObject3).setName(((b.a.c)localObject2).getText());
        ((MinsuHouseDetailConfigBean)localObject3).setType(0);
        this.s.add(localObject3);
        if (((b.a.c)localObject2).getNodes() == null) {
          break;
        }
        localObject2 = ((b.a.c)localObject2).getNodes().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (b.a.c.a)((Iterator)localObject2).next();
          localObject4 = new MinsuHouseDetailConfigBean();
          ((MinsuHouseDetailConfigBean)localObject4).setIcPath(((b.a.c.a)localObject3).getIconUrl());
          ((MinsuHouseDetailConfigBean)localObject4).setName(((b.a.c.a)localObject3).getText());
          ((MinsuHouseDetailConfigBean)localObject4).setType(1);
          this.s.add(localObject4);
        }
      }
    }
    this.btn_fac_all.setVisibility(8);
  }
  
  private void q()
  {
    if ((this.d != null) && (this.d.getData() != null) && (this.d.getData().getCheckNotice() != null))
    {
      this.ll_rule_container.setVisibility(0);
      this.f = new com.freelxl.baselibrary.a.a(this.c, this.d.getData().getCheckNotice(), 2130904314)
      {
        public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, b.a.b paramAnonymousb1)
        {
          paramAnonymousb.setText(2131694588, paramAnonymousb1.getRuleName());
          paramAnonymousb.setText(2131691546, paramAnonymousb1.getRuleValue());
          Resources localResources = StationProjectDetailActivity.this.getResources();
          if (paramAnonymousb1.getClickType() != 0) {}
          for (int i = 2131624504;; i = 2131624494)
          {
            paramAnonymousb.setTextColor(2131691546, localResources.getColor(i));
            return;
          }
        }
      };
      this.lv_rule.setAdapter(this.f);
      this.lv_rule.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          Object localObject;
          if ((StationProjectDetailActivity.e(StationProjectDetailActivity.this) != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData() != null) && (StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getCheckNotice() != null))
          {
            paramAnonymousView = (b.a.b)StationProjectDetailActivity.e(StationProjectDetailActivity.this).getData().getCheckNotice().get(paramAnonymousInt);
            if ((paramAnonymousView.getClickType() != 1) || (StationProjectDetailActivity.G(StationProjectDetailActivity.this) == null)) {
              break label210;
            }
            paramAnonymousAdapterView = StationProjectDetailActivity.G(StationProjectDetailActivity.this).iterator();
            do
            {
              if (!paramAnonymousAdapterView.hasNext()) {
                break;
              }
              localObject = (StationRuleBean.DataBean)paramAnonymousAdapterView.next();
            } while (!paramAnonymousView.getType().equals(((StationRuleBean.DataBean)localObject).getRuleType()));
          }
          for (paramAnonymousAdapterView = ((StationRuleBean.DataBean)localObject).getContent();; paramAnonymousAdapterView = null)
          {
            if (!TextUtils.isEmpty(paramAnonymousAdapterView))
            {
              localObject = new Intent(StationProjectDetailActivity.a(StationProjectDetailActivity.this), StationInfoActivity.class);
              ((Intent)localObject).putExtra("title", paramAnonymousView.getRuleName());
              ((Intent)localObject).putExtra("content", paramAnonymousAdapterView);
              StationProjectDetailActivity.this.startActivity((Intent)localObject);
              StationProjectDetailActivity.this.overridePendingTransition(2130968591, 2130968592);
            }
            label210:
            do
            {
              return;
            } while (paramAnonymousView.getClickType() != 1);
            af.showToast(StationProjectDetailActivity.a(StationProjectDetailActivity.this), "数据刷新中，请稍后...");
            return;
          }
        }
      });
      return;
    }
    this.ll_rule_container.setVisibility(8);
  }
  
  private void r()
  {
    if ((this.d != null) && (this.d.getData() != null) && (this.d.getData().getActivity() != null) && (this.d.getData().getActivity().size() > 0))
    {
      this.ll_wonderful_activities_container.setVisibility(0);
      this.r.clear();
      Object localObject = this.d.getData().getActivity().iterator();
      while (((Iterator)localObject).hasNext())
      {
        StationWonderfulActivitiesFragment localStationWonderfulActivitiesFragment = StationWonderfulActivitiesFragment.newInstance((b.a.a)((Iterator)localObject).next());
        GrowingIO.getInstance().ignoreFragment(this, localStationWonderfulActivitiesFragment);
        this.r.add(localStationWonderfulActivitiesFragment);
      }
      localObject = new a(getSupportFragmentManager());
      this.cvp_wonderful_activities.setAdapter((PagerAdapter)localObject);
      this.cvp_wonderful_activities.setPageMargin(com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(this.c, 10));
      this.cvp_wonderful_activities.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          if (StationProjectDetailActivity.this.cvp_wonderful_activities != null) {
            StationProjectDetailActivity.this.cvp_wonderful_activities.invalidate();
          }
        }
        
        public void onPageSelected(int paramAnonymousInt) {}
      });
      return;
    }
    this.ll_wonderful_activities_container.setVisibility(8);
  }
  
  private void s()
  {
    TextView localTextView;
    if (this.d != null)
    {
      this.x = this.d.getData().getPraiseScore();
      this.w = this.d.getData().getPraiseCount();
      if ((this.g != null) && (this.d.getData() != null) && (this.d.getData().getHistoryDtoList() != null) && (this.d.getData().getHistoryDtoList().size() > 0))
      {
        this.ll_station_evaluate_container.setVisibility(0);
        this.g.setDatas(this.d.getData().getHistoryDtoList());
      }
    }
    else
    {
      if (this.w <= 0) {
        break label207;
      }
      this.rl_eva_container.setVisibility(0);
      this.tv_no_evaluate.setVisibility(8);
      this.tv_project_eva_count.setText(this.w + "条评价");
      localTextView = this.tv_project_eva_grade;
      if (!TextUtils.isEmpty(this.x)) {
        break label199;
      }
    }
    label199:
    for (String str = "0.0";; str = this.x)
    {
      localTextView.setText(str);
      return;
      this.ll_station_evaluate_container.setVisibility(8);
      break;
    }
    label207:
    this.rl_eva_container.setVisibility(8);
    this.tv_no_evaluate.setVisibility(0);
  }
  
  public void checkBookBtnAvailable()
  {
    if (this.z > 0.0F)
    {
      this.iv_total_price_right_icon.setVisibility(0);
      this.btn_price_detail.setClickable(true);
      return;
    }
    this.iv_total_price_right_icon.setVisibility(4);
    this.btn_price_detail.setClickable(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    if (this.F > 0) {
      this.osv_main.smoothScrollTo(0, this.F);
    }
    this.A = paramIntent.getStringExtra("startDate");
    this.B = paramIntent.getStringExtra("endDate");
    if (ae.isNull(this.A))
    {
      paramIntent = null;
      this.C = paramIntent;
      if (!ae.isNull(this.B)) {
        break label207;
      }
    }
    label207:
    for (paramIntent = (Intent)localObject;; paramIntent = e(this.B))
    {
      this.D = paramIntent;
      this.tv_stay_in_count.setVisibility(0);
      this.tv_stay_in_count.setText("共 " + m.getDaysBetween(new Date(this.C.getTimeInMillis()), new Date(this.D.getTimeInMillis())) + " 晚");
      i();
      this.V = true;
      k();
      return;
      paramIntent = e(this.A);
      break;
    }
  }
  
  @OnClick({2131691363, 2131692539, 2131691381, 2131692554, 2131692555, 2131692558, 2131692561, 2131691386, 2131690078, 2131690459, 2131692578, 2131692581, 2131691393, 2131692576, 2131692549, 2131692565, 2131692573})
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
      String str;
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
                        do
                        {
                          do
                          {
                            return;
                          } while ((this.d == null) || (this.d.getData() == null));
                          if ((this.C == null) || (this.D == null)) {
                            for (paramView = new SimpleDateFormat("yyyy-MM-dd");; paramView = paramView.parse(this.d.getData().getOpenTime())) {
                              try
                              {
                                localObject = (Activity)this.c;
                                if (TextUtils.isEmpty(this.d.getData().getOpenTime()))
                                {
                                  paramView = null;
                                  com.ziroom.ziroomcustomer.minsu.f.k.toCustomTimeSelectActivityForResult((Activity)localObject, paramView, this.C, this.D);
                                  return;
                                }
                              }
                              catch (ParseException paramView)
                              {
                                com.ziroom.ziroomcustomer.minsu.f.k.toCustomTimeSelectActivityForResult((Activity)this.c, null, this.C, this.D);
                                return;
                              }
                            }
                          }
                          if (this.z <= 0.0F)
                          {
                            if (this.F > 0) {
                              this.osv_main.smoothScrollTo(0, this.F);
                            }
                            af.showToast(this.c, "请先选择一个心仪的床位~");
                            return;
                          }
                        } while (ae.isNull(ApplicationEx.c.getUserId(this)));
                        paramView = new Intent(this.c, OrderCreateActivity.class);
                        if (this.d.getData().getListProImg().size() > 0) {
                          paramView.putExtra("projectPicUrl", ((b.a.g)this.d.getData().getListProImg().get(0)).getHeadImgUrl());
                        }
                        paramView.putExtra("projectName", this.d.getData().getProjectName());
                        paramView.putExtra("projectBid", this.v);
                        paramView.putExtra("startDate", this.C.getTimeInMillis());
                        paramView.putExtra("endDate", this.D.getTimeInMillis());
                        paramView.putExtra("dayRoomInfos", a(this.e.getBedData()));
                        startActivity(paramView);
                        return;
                        if (this.z <= 0.0F)
                        {
                          af.showToast(this.c, "请先选择一个心仪的床位~");
                          return;
                        }
                        g();
                        return;
                      } while ((this.d == null) || (this.d.getData() == null) || (this.w <= 0));
                      paramView = new Intent(this.c, StationProjectEvaluateActivity.class);
                      paramView.putExtra("project_id", this.v);
                      paramView.putExtra("eva_count", this.w);
                      paramView.putExtra("eva_grade", this.x);
                      paramView.putExtra("project_name", this.d.getData().getProjectName());
                      startActivity(paramView);
                      return;
                    } while ((this.d == null) || (this.d.getData() == null));
                    paramView = this.d.getData().getLng() + "," + this.d.getData().getLat();
                    localObject = new Intent(this.c, StationHouseMapLocationActivity.class);
                    ((Intent)localObject).putExtra("search_location", paramView);
                    if (this.d.getData().getProjectAddress() == null) {}
                    for (paramView = "";; paramView = this.d.getData().getProjectAddress())
                    {
                      ((Intent)localObject).putExtra("resblock_name", paramView);
                      startActivity((Intent)localObject);
                      return;
                    }
                  } while ((this.d == null) || (this.d.getData() == null));
                  for (paramView = new SimpleDateFormat("yyyy-MM-dd");; paramView = paramView.parse(this.d.getData().getOpenTime())) {
                    try
                    {
                      if ((!this.T) || (!this.U)) {
                        break;
                      }
                      localObject = (Activity)this.c;
                      if (TextUtils.isEmpty(this.d.getData().getOpenTime()))
                      {
                        paramView = null;
                        com.ziroom.ziroomcustomer.minsu.f.k.toCustomTimeSelectActivityForResult((Activity)localObject, paramView, this.C, this.D);
                        return;
                      }
                    }
                    catch (ParseException paramView)
                    {
                      com.ziroom.ziroomcustomer.minsu.f.k.toCustomTimeSelectActivityForResult((Activity)this.c, null, this.C, this.D);
                      return;
                    }
                  }
                  localObject = (Activity)this.c;
                  if (TextUtils.isEmpty(this.d.getData().getOpenTime())) {}
                  for (paramView = null;; paramView = paramView.parse(this.d.getData().getOpenTime()))
                  {
                    com.ziroom.ziroomcustomer.minsu.f.k.toCustomTimeSelectActivityForResult((Activity)localObject, paramView, null, null);
                    return;
                  }
                } while ((this.s == null) || (this.s.size() <= 0));
                com.ziroom.ziroomcustomer.minsu.f.k.toMinsuServiceListActivity(this, this.s);
                return;
              } while ((this.d == null) || (this.d.getData() == null));
              ah.callPhone(this.c, this.d.getData().getSellPhone());
              return;
              finish();
              return;
              if ((this.d != null) && (this.d.getData() != null) && (!TextUtils.isEmpty(this.d.getData().getShowHouseUrl())))
              {
                paramView = new Intent(this.c, StationWebActivity.class);
                paramView.putExtra("url", this.d.getData().getShowHouseUrl());
                paramView.putExtra("title", this.d.getData().getProjectName());
                startActivity(paramView);
                return;
              }
              af.showToast(this.c, "暂无更多");
              return;
            } while ((this.d == null) || (this.d.getData() == null) || (TextUtils.isEmpty(this.d.getData().getShareUrl())));
            paramView = com.ziroom.threelib.ziroomshare.c.getInstance();
          } while (paramView == null);
          paramView.shareFromCenter(this, this.d.getData().getShareUrl(), this.d.getData().getProjectName(), this.d.getData().getProjectDesc(), this.d.getData().getHeaderUrl(), this.Y);
          return;
        } while ((this.d == null) || (this.d.getData() == null));
        str = this.d.getData().getPanoramicUrl();
      } while (TextUtils.isEmpty(str));
      Object localObject = ad.getBrowserPackageName(this);
      PackageManager localPackageManager = getPackageManager();
      paramView = (View)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView = "com.android.browser";
        ah.getBrowserPackageName(this);
      }
      localObject = localPackageManager.getLaunchIntentForPackage(paramView);
      paramView = (View)localObject;
      if (localObject == null)
      {
        paramView = new Intent();
        ah.getBrowserPackageName(this);
      }
      paramView.setData(Uri.parse(str));
      paramView.setAction("android.intent.action.VIEW");
      startActivity(paramView);
      return;
    } while ((this.d == null) || (this.d.getData() == null) || (TextUtils.isEmpty(this.d.getData().getCityCode())) || (TextUtils.isEmpty(this.d.getData().getBusinessAreas())));
    com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().push();
    com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().reset();
    com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setCityCode(this.d.getData().getCityCode());
    com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setCityName(this.d.getData().getCityName());
    com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setHotReginBusiness(this.d.getData().getBusinessAreas());
    com.ziroom.ziroomcustomer.minsu.b.c.a = this.d.getData().getCityCode();
    com.ziroom.ziroomcustomer.minsu.f.k.toStrategySearchList(this.c);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903519);
    this.c = this;
    ButterKnife.bind(this);
    b();
    a();
    e();
    i.StationHouseDetail(this, this.v);
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.M);
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (parama.equals("strategy_query"))
        {
          i = 0;
          continue;
          if (parama.equals("strategy_query_error")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.O = this.M.getStrategySearchListBean();
    if ((this.O != null) && (this.O.getData() != null) && (this.O.getData().getList().size() > 0))
    {
      this.N.setData(this.O.getData().getList());
      this.ll_strategy_container.setVisibility(0);
      return;
    }
    this.ll_strategy_container.setVisibility(8);
    return;
    this.ll_strategy_container.setVisibility(8);
    this.N.setData(null);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void showCarousel(List<String> paramList1, List<String> paramList2, LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    if ((!isFinishing()) && (this.mLlCarousel != null))
    {
      this.G = paramLinkedHashMap;
      paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
      int i = 1;
      if (paramLinkedHashMap.hasNext())
      {
        final Map.Entry localEntry = (Map.Entry)paramLinkedHashMap.next();
        TextView localTextView = new TextView(ApplicationEx.c);
        localTextView.setText((CharSequence)localEntry.getKey());
        localTextView.setTextColor(Color.parseColor("#B2FFFFFF"));
        localTextView.setTextSize(12.0F);
        localTextView.setGravity(16);
        label119:
        LinearLayout.LayoutParams localLayoutParams;
        if (Build.VERSION.SDK_INT >= 16)
        {
          localTextView.setBackground(null);
          localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
          if (i == 0) {
            break label252;
          }
        }
        label252:
        for (i = ab.dp2px(this, 18.0F);; i = (int)(getResources().getDisplayMetrics().density * 40.0F + 0.5D))
        {
          localLayoutParams.setMargins(i, 0, 0, 0);
          localLayoutParams.gravity = 16;
          localTextView.setLayoutParams(localLayoutParams);
          localTextView.setTag(2131690557, localEntry.getValue());
          this.H.add(localEntry.getValue());
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              StationProjectDetailActivity.this.b.setCurrentItem(((Integer)localEntry.getValue()).intValue());
            }
          });
          this.I.add(localTextView);
          this.mLlCarousel.addView(localTextView);
          i = 0;
          break;
          localTextView.setBackgroundDrawable(null);
          break label119;
        }
      }
      this.b.setCycle(true);
      this.J = paramList2;
      this.b.setIsPageNumVisible(false);
      this.b.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
      this.b.setPosChangeListener(this.X);
      this.b.setData(this, paramList1, this.W);
      this.b.setWheel(false);
    }
  }
  
  public void updateTotalPriceShow()
  {
    this.z = 0.0F;
    if ((this.e != null) && (this.e.getBedData() != null))
    {
      Iterator localIterator1 = this.e.getBedData().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((DaysPrice)localIterator1.next()).typePriceList.iterator();
        while (localIterator2.hasNext())
        {
          TypePrice localTypePrice = (TypePrice)localIterator2.next();
          this.z = ((float)(this.z + localTypePrice.typePrice * localTypePrice.num));
        }
      }
    }
    checkBookBtnAvailable();
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
      return StationProjectDetailActivity.H(StationProjectDetailActivity.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)StationProjectDetailActivity.H(StationProjectDetailActivity.this).get(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/StationProjectDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */