package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.controller.BaseControllerListener;
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
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponBarShowBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponBarShowBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListShowBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListShowBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListShowBean.DataBean.CouponListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHdAchieveCouponBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.LabelTipsListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.ListCheckRuleVoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.ListHouseFacServBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.ListHouseFacServBean.SubEnumValsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.ListHouseFacilitiesBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.MercureInfoVoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.PicDisListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.TenantEvalVoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean.ToNightDiscountBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailConfigBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseIsCollectResutBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseIsCollectResutBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MsHistorySBean;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.dialog.e;
import com.ziroom.ziroomcustomer.minsu.dialog.e.a;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.i;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.fragment.MinsuHouseDetailBottomFragment;
import com.ziroom.ziroomcustomer.minsu.tenant.MinsuLandlordDetailActivty;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.CustomViewPager;
import com.ziroom.ziroomcustomer.minsu.view.FiveEvaluteButton;
import com.ziroom.ziroomcustomer.minsu.view.MinsuHouseDeatailFolderTextView;
import com.ziroom.ziroomcustomer.minsu.view.MinsuHouseDeatailFolderTextView.b;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class MinsuHouseDetailActivity
  extends BaseSupportURIActivity
  implements View.OnClickListener, ObservableScrollView.a
{
  private boolean A = false;
  private CountDownTimer B;
  private SimpleDateFormat C;
  private String D;
  private final int E = 1;
  private final int F = 2;
  private int G = 1;
  private PlatformActionListener H = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功   ====" + getClass().getSimpleName());
      MinsuHouseDetailActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败======4" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      MinsuHouseDetailActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  private int I = 0;
  private e J;
  private MinsuCouponListShowBean K;
  public BroadcastReceiver a = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      int j = paramAnonymousIntent.getIntExtra("status", 0);
      if ((i == 17) && (j == 1))
      {
        if ((MinsuHouseDetailActivity.n(MinsuHouseDetailActivity.this) != null) && (MinsuHouseDetailActivity.n(MinsuHouseDetailActivity.this).isShowing()))
        {
          MinsuHouseDetailActivity.n(MinsuHouseDetailActivity.this).dismiss();
          MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this, 1);
        }
      }
      else {
        return;
      }
      MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this, 2);
    }
  };
  private a b;
  private List<MinsuHouseDetailBottomFragment> c = new ArrayList();
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691224)
  LinearLayout couponArea;
  private String d;
  private int e;
  private List<String> f = new ArrayList();
  @BindView(2131691326)
  LinearLayout first_reduce_area;
  @BindView(2131691339)
  FiveEvaluteButton fiveEvalute;
  private MinsuHouseDetailBean g;
  @BindView(2131691348)
  TextView houseCertification;
  @BindView(2131691319)
  TextView houseName;
  @BindView(2131689700)
  ImageView image;
  @BindView(2131691345)
  SimpleDraweeView ivLImg;
  @BindView(2131690895)
  SimpleDraweeView ivMap;
  @BindView(2131691349)
  ImageView ivMapecenter;
  @BindView(2131691343)
  View lineEva;
  @BindView(2131691321)
  View line_coupon;
  @BindView(2131691325)
  View line_first_reduce;
  @BindView(2131691358)
  CustomViewPager listHouse;
  @BindView(2131691354)
  ListViewForScrollView listRules;
  @BindView(2131689838)
  LinearLayout llBottom;
  @BindView(2131691352)
  LinearLayout llConfig;
  @BindView(2131691336)
  RelativeLayout llEva;
  @BindView(2131691328)
  LinearLayout llHouseDetail;
  @BindView(2131691320)
  LinearLayout llHouseInfo;
  @BindView(2131691309)
  View ll_special_tonight_container;
  @BindView(2131691310)
  View ll_special_tonight_left_container;
  @BindView(2131691318)
  LinearLayout ll_tips_area;
  @BindView(2131691357)
  RelativeLayout pagerLayout;
  @BindView(2131691347)
  TextView personCertification;
  private String r;
  @BindView(2131691344)
  RelativeLayout rlLlInfo;
  private String s;
  @BindView(2131689919)
  ObservableScrollView svMain;
  private String t;
  @BindView(2131690053)
  TextView tvAddress;
  @BindView(2131691351)
  TextView tvConfigAll;
  @BindView(2131691350)
  TextView tvConfigName;
  @BindView(2131691359)
  TextView tvConsult;
  @BindView(2131691322)
  TextView tvCouponBar0;
  @BindView(2131691323)
  TextView tvCouponBar1;
  @BindView(2131691324)
  TextView tvCouponBar2;
  @BindView(2131691331)
  MinsuHouseDeatailFolderTextView tvDes1;
  @BindView(2131691334)
  MinsuHouseDeatailFolderTextView tvDes2;
  @BindView(2131691338)
  TextView tvEvaAll;
  @BindView(2131691341)
  MinsuHouseDeatailFolderTextView tvEvaDetail;
  @BindView(2131691342)
  TextView tvEvaTime;
  @BindView(2131691337)
  TextView tvEvaTitle;
  @BindView(2131691332)
  TextView tvFold1;
  @BindView(2131691335)
  TextView tvFold2;
  @BindView(2131691329)
  TextView tvHouseDetailTitle;
  @BindView(2131691356)
  TextView tvLMoreHouse;
  @BindView(2131691346)
  TextView tvLName;
  @BindView(2131691360)
  TextView tvOrderNow;
  @BindView(2131691316)
  TextView tvOriginalPrice;
  @BindView(2131689912)
  TextView tvPrice;
  @BindView(2131691353)
  TextView tvRulesName;
  @BindView(2131691330)
  TextView tvTitle1;
  @BindView(2131691333)
  TextView tvTitle2;
  @BindView(2131691327)
  TextView tv_first_reduce;
  @BindView(2131691317)
  TextView tv_price_original;
  @BindView(2131691313)
  TextView tv_special_tonight_hour;
  @BindView(2131691312)
  TextView tv_special_tonight_info;
  @BindView(2131691314)
  TextView tv_special_tonight_minutes;
  @BindView(2131691311)
  TextView tv_special_tonight_price;
  @BindView(2131691315)
  TextView tv_special_tonight_seconds;
  private ArrayList<String> u;
  private String v;
  @BindView(2131691308)
  ViewPager viewpagerhomepage;
  private int w = -1;
  private int x = -1;
  private boolean y;
  private com.freelxl.baselibrary.a.a z;
  
  private int a(List<String> paramList, TextView paramTextView, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    for (int i = 0; localIterator.hasNext(); i = (int)(ab.length(paramTextView, (String)localIterator.next()) + paramInt * 2) + i) {}
    return (ac.getScreenWidth(ApplicationEx.c) - i - b(18) - b(18)) / (paramList.size() - 1);
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.a, localIntentFilter);
  }
  
  private void a(double paramDouble1, double paramDouble2, String paramString)
  {
    if ((ae.isNull(paramDouble1 + "")) || (ae.isNull(paramDouble2 + "")) || (ae.isNull(paramString))) {
      return;
    }
    Intent localIntent = new Intent(this, MinsuHouseMapActivity.class);
    localIntent.putExtra("lat", String.valueOf(paramDouble2));
    localIntent.putExtra("lng", String.valueOf(paramDouble1));
    localIntent.putExtra("resblock_name", paramString);
    startActivity(localIntent);
  }
  
  private void a(Intent paramIntent)
  {
    if ("android.intent.action.VIEW".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getData();
      if (paramIntent != null)
      {
        this.d = paramIntent.getQueryParameter("fid");
        paramIntent = paramIntent.getQueryParameter("rentWay");
        if ((ae.notNull(paramIntent)) && (ad.isNumeric(paramIntent))) {
          this.e = Integer.parseInt(paramIntent);
        }
        v.onClick(this, "M-H5housedetail");
        com.freelxl.baselibrary.f.d.d("lanzhihong", "fid==" + this.d + "-----rentWay===" + this.e);
      }
    }
  }
  
  private void a(MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    if ((paramMinsuHouseDetailBean == null) || (paramMinsuHouseDetailBean.data == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramMinsuHouseDetailBean.data.houseNameInfoList)))
    {
      this.llHouseInfo.setVisibility(8);
      return;
    }
    this.llHouseInfo.setVisibility(0);
    this.llHouseInfo.removeAllViews();
    List localList = paramMinsuHouseDetailBean.data.houseNameInfoList;
    int k = 0;
    int i = 0;
    label63:
    label132:
    int m;
    TextView localTextView;
    LinearLayout.LayoutParams localLayoutParams;
    if (k < localList.size())
    {
      this.tvOrderNow.setText(paramMinsuHouseDetailBean.data.orderTypeName);
      if (paramMinsuHouseDetailBean.data.houseStatus != 40) {
        break label319;
      }
      this.tvOrderNow.setText(paramMinsuHouseDetailBean.data.orderTypeName);
      this.tvOrderNow.setBackgroundColor(getResources().getColor(2131624475));
      this.x = paramMinsuHouseDetailBean.data.orderType;
      m = b(5);
      int j = b(6);
      int n = b(12);
      localTextView = new TextView(this);
      localTextView.setTextSize(12.0F);
      localTextView.setGravity(17);
      localTextView.setTextColor(getResources().getColor(2131624039));
      localTextView.setBackgroundResource(2130839666);
      localTextView.setPadding(n, j, n, j);
      localTextView.setSingleLine();
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (k == 0) {
        break label361;
      }
      j = i;
      if (i == 0) {
        j = a(localList, localTextView, n);
      }
      i = j;
    }
    label319:
    label361:
    for (;;)
    {
      localLayoutParams.setMargins(i, m, 0, m);
      localTextView.setLayoutParams(localLayoutParams);
      localTextView.setText((CharSequence)localList.get(k));
      this.llHouseInfo.addView(localTextView);
      k += 1;
      break label63;
      break;
      this.tvOrderNow.setBackgroundColor(getResources().getColor(2131624046));
      this.tvOrderNow.setText(getString(2131297080));
      this.tvOrderNow.setEnabled(false);
      break label132;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((ae.isNull(paramString1)) || (ae.isNull(paramString2)) || (this.ivMap == null)) {
      return;
    }
    this.tvAddress.setText(paramString2);
    int i = Math.min(getResources().getDisplayMetrics().widthPixels, 900);
    paramString1 = ad.getStaticPicFromBaiduMap(paramString1, i, i / 3 * 2, 18);
    this.ivMap.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getHierarchy(ApplicationEx.c));
    this.ivMap.setController(com.freelxl.baselibrary.f.c.frescoController(paramString1));
    paramString1 = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramString1.setDuration(1500L);
    paramString1.setRepeatCount(99999);
    this.ivMapecenter.setAnimation(paramString1);
    paramString1.start();
  }
  
  private void a(List<MinsuHouseDetailConfigBean> paramList)
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toMinsuServiceListActivity(this, paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.g == null) || (this.g.data == null)) {}
    for (int i = 0;; i = this.g.data.minDay)
    {
      com.ziroom.ziroomcustomer.minsu.f.k.toMinsuTimeSelectingActivity(this, this.r, this.s, this.d, this.e, i, paramBoolean);
      return;
    }
  }
  
  private int b(int paramInt)
  {
    return ab.dp2px(ApplicationEx.c, paramInt);
  }
  
  private void b()
  {
    this.svMain.setOnScrollChangedCallback(this);
    this.fiveEvalute.setPadding(new int[] { 2, 2, 2, 2 });
    this.fiveEvalute.setSwitch(false);
  }
  
  private void b(final MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    int k = 0;
    int j = 0;
    if ((paramMinsuHouseDetailBean.data == null) || (paramMinsuHouseDetailBean.data.mercureInfoVo == null))
    {
      this.llHouseDetail.setVisibility(8);
      return;
    }
    Object localObject = paramMinsuHouseDetailBean.data.mercureInfoVo.mercureTitle;
    String str1 = paramMinsuHouseDetailBean.data.mercureInfoVo.mercureDesTitle;
    String str2 = paramMinsuHouseDetailBean.data.mercureInfoVo.houseAroundTitle;
    String str3 = paramMinsuHouseDetailBean.data.mercureInfoVo.mercureDesHouseInfo + paramMinsuHouseDetailBean.data.mercureInfoVo.houseDesc;
    String str4 = paramMinsuHouseDetailBean.data.mercureInfoVo.houseAroundDesc;
    int n = ab.getLineCountFromText(str3.trim(), this.tvDes1);
    int m = ab.getLineCountFromText(str4.trim(), this.tvDes2);
    View.OnClickListener local25 = new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseDetailActivity.this.tvFold1.setVisibility(0);
        MinsuHouseDetailActivity.this.tvDes1.setFold(false);
        MinsuHouseDetailActivity.this.tvDes2.setFold(false);
        MinsuHouseDetailActivity.c(MinsuHouseDetailActivity.this, paramMinsuHouseDetailBean);
        MinsuHouseDetailActivity.this.scrollTo();
      }
    };
    paramMinsuHouseDetailBean = new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseDetailActivity.this.tvFold2.setVisibility(8);
        MinsuHouseDetailActivity.this.tvFold1.setVisibility(0);
        MinsuHouseDetailActivity.this.tvDes1.setFold(false);
        MinsuHouseDetailActivity.this.tvDes2.setFold(false);
        MinsuHouseDetailActivity.c(MinsuHouseDetailActivity.this, paramMinsuHouseDetailBean);
        MinsuHouseDetailActivity.this.scrollTo();
      }
    };
    this.tvHouseDetailTitle.setText((CharSequence)localObject);
    this.tvTitle1.setText(str1);
    this.tvTitle2.setText(str2);
    this.tvDes1.setText(str3);
    this.tvDes2.setText(str4);
    this.tvDes1.setFoldLine(6);
    this.tvDes2.setFoldLine(6);
    if ((ae.isNull(str3)) && (ae.isNull(str4)))
    {
      this.llHouseDetail.setVisibility(8);
      return;
    }
    if (n > 6)
    {
      this.tvDes2.setVisibility(8);
      this.tvTitle2.setVisibility(8);
      this.tvDes1.setFoldLine(6);
      this.tvDes1.setIsUseFold(true);
      this.tvFold1.setVisibility(8);
      this.tvFold2.setVisibility(8);
    }
    for (;;)
    {
      this.tvDes1.setClickSpan(new MinsuHouseDeatailFolderTextView.b()
      {
        public void onClick()
        {
          MinsuHouseDetailActivity.this.tvDes2.setVisibility(0);
          MinsuHouseDetailActivity.this.tvTitle2.setVisibility(0);
          MinsuHouseDetailActivity.this.tvDes1.setIsUseFold(false);
          MinsuHouseDetailActivity.this.tvDes2.setIsUseFold(false);
          MinsuHouseDetailActivity.this.tvFold2.setVisibility(0);
          MinsuHouseDetailActivity.this.tvFold2.setOnClickListener(paramMinsuHouseDetailBean);
        }
      });
      this.tvDes2.setClickSpan(new MinsuHouseDeatailFolderTextView.b()
      {
        public void onClick()
        {
          MinsuHouseDetailActivity.this.tvDes2.setVisibility(0);
          MinsuHouseDetailActivity.this.tvTitle2.setVisibility(0);
          MinsuHouseDetailActivity.this.tvDes2.setIsUseFold(false);
          MinsuHouseDetailActivity.this.tvFold2.setVisibility(0);
          MinsuHouseDetailActivity.this.tvFold2.setOnClickListener(paramMinsuHouseDetailBean);
        }
      });
      return;
      int i;
      if ((n < 6) && (n + m > 6))
      {
        this.tvTitle2.setVisibility(0);
        this.tvDes2.setFoldLine(6 - n);
        this.tvDes2.setIsUseFold(true);
        this.tvDes1.setIsUseFold(false);
        this.tvFold1.setVisibility(8);
        localObject = this.tvTitle1;
        if (n > 0)
        {
          i = 0;
          label424:
          ((TextView)localObject).setVisibility(i);
          localObject = this.tvDes1;
          if (n <= 0) {
            break label496;
          }
          i = 0;
          label443:
          ((MinsuHouseDeatailFolderTextView)localObject).setVisibility(i);
          localObject = this.tvTitle2;
          if (m <= 0) {
            break label502;
          }
          i = 0;
          label462:
          ((TextView)localObject).setVisibility(i);
          localObject = this.tvDes2;
          if (m <= 0) {
            break label508;
          }
        }
        label496:
        label502:
        label508:
        for (i = j;; i = 8)
        {
          ((MinsuHouseDeatailFolderTextView)localObject).setVisibility(i);
          break;
          i = 8;
          break label424;
          i = 8;
          break label443;
          i = 8;
          break label462;
        }
      }
      if ((n < 6) && (n + m < 6))
      {
        this.tvDes1.setIsUseFold(false);
        this.tvDes2.setIsUseFold(false);
        this.tvFold1.setVisibility(8);
        this.tvFold2.setVisibility(8);
        localObject = this.tvTitle1;
        if (n > 0)
        {
          i = 0;
          label578:
          ((TextView)localObject).setVisibility(i);
          localObject = this.tvDes1;
          if (n <= 0) {
            break label651;
          }
          i = 0;
          label597:
          ((MinsuHouseDeatailFolderTextView)localObject).setVisibility(i);
          localObject = this.tvTitle2;
          if (m <= 0) {
            break label657;
          }
          i = 0;
          label616:
          ((TextView)localObject).setVisibility(i);
          localObject = this.tvDes2;
          if (m <= 0) {
            break label663;
          }
        }
        label651:
        label657:
        label663:
        for (i = k;; i = 8)
        {
          ((MinsuHouseDeatailFolderTextView)localObject).setVisibility(i);
          break;
          i = 8;
          break label578;
          i = 8;
          break label597;
          i = 8;
          break label616;
        }
      }
      if ((n < 6) && (n + m == 6))
      {
        this.tvDes1.setIsUseFold(false);
        this.tvDes2.setIsUseFold(false);
      }
      else if (n == 6)
      {
        this.tvDes2.setVisibility(8);
        this.tvTitle2.setVisibility(8);
        this.tvDes1.setFoldLine(6);
        this.tvDes1.setIsUseFold(true);
        this.tvDes2.setIsUseFold(false);
        this.tvFold1.setVisibility(8);
        this.tvFold1.setOnClickListener(local25);
      }
    }
  }
  
  private void c(final int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.houseDetailCouponList(this, new s(this, new com.freelxl.baselibrary.d.f.d(MinsuCouponListShowBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuCouponListShowBean paramAnonymousMinsuCouponListShowBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuCouponListShowBean);
        if ((paramAnonymousMinsuCouponListShowBean.checkSuccess(MinsuHouseDetailActivity.this)) && (paramAnonymousMinsuCouponListShowBean.data != null) && (paramAnonymousMinsuCouponListShowBean.data.couponList != null) && (paramAnonymousMinsuCouponListShowBean.data.couponList.size() > 0))
        {
          MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this, paramAnonymousMinsuCouponListShowBean);
          if ((paramInt == 1) && (!MinsuHouseDetailActivity.this.isFinishing())) {
            MinsuHouseDetailActivity.this.showCouponPopView();
          }
          return;
        }
        if (paramAnonymousMinsuCouponListShowBean == null) {}
        for (paramAnonymousMinsuCouponListShowBean = null;; paramAnonymousMinsuCouponListShowBean = paramAnonymousMinsuCouponListShowBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuCouponListShowBean);
          return;
        }
      }
    });
  }
  
  private void c(MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    if ((paramMinsuHouseDetailBean == null) || (paramMinsuHouseDetailBean.data == null)) {
      return;
    }
    this.v = paramMinsuHouseDetailBean.data.landlordUid;
    d(paramMinsuHouseDetailBean.data.landlordUid);
    this.houseName.setText(paramMinsuHouseDetailBean.data.houseName);
    this.ivLImg.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(this));
    this.ivLImg.setController(com.freelxl.baselibrary.f.c.frescoController(paramMinsuHouseDetailBean.data.landlordIcon));
    Object localObject2 = this.tvLName;
    Object localObject3 = new StringBuilder().append("房东:  ");
    Object localObject1;
    int i;
    if (ae.isNull(paramMinsuHouseDetailBean.data.landlordName))
    {
      localObject1 = " ";
      ((TextView)localObject2).setText((String)localObject1);
      localObject1 = this.personCertification;
      if (paramMinsuHouseDetailBean.data.isAuth != 0) {
        break label517;
      }
      i = 8;
      label146:
      ((TextView)localObject1).setVisibility(i);
      localObject1 = this.houseCertification;
      if (paramMinsuHouseDetailBean.data.isAuth != 0) {
        break label522;
      }
      i = 8;
      label169:
      ((TextView)localObject1).setVisibility(i);
      this.tvPrice.setText("¥ " + ad.getPriceInt(paramMinsuHouseDetailBean.data.housePrice) + "/晚");
      this.tvOriginalPrice.setText("¥ " + ad.getPriceInt(paramMinsuHouseDetailBean.data.housePrice) + "/晚");
      if ((paramMinsuHouseDetailBean.data.originalPrice == null) || (paramMinsuHouseDetailBean.data.originalPrice.intValue() <= 0)) {
        break label527;
      }
      this.tv_price_original.setVisibility(0);
      this.tv_price_original.getPaint().setFlags(16);
      this.tv_price_original.setText("￥" + ad.getPriceInt(paramMinsuHouseDetailBean.data.originalPrice.intValue()) + "");
      label346:
      if ((paramMinsuHouseDetailBean.data.labelTipsList == null) || (paramMinsuHouseDetailBean.data.labelTipsList.size() <= 0)) {
        break label600;
      }
      this.ll_tips_area.removeAllViews();
      localObject1 = paramMinsuHouseDetailBean.data.labelTipsList.iterator();
      label391:
      if (!((Iterator)localObject1).hasNext()) {
        break label600;
      }
      localObject2 = (MinsuHouseDetailBean.DataBean.LabelTipsListBean)((Iterator)localObject1).next();
      localObject3 = (TextView)LayoutInflater.from(this).inflate(2130904936, null);
      ((TextView)localObject3).setText(((MinsuHouseDetailBean.DataBean.LabelTipsListBean)localObject2).name);
      if (!getString(2131297164).equals(((MinsuHouseDetailBean.DataBean.LabelTipsListBean)localObject2).tipsType)) {
        break label539;
      }
      ((TextView)localObject3).setTextColor(getResources().getColor(2131624475));
    }
    for (;;)
    {
      this.ll_tips_area.addView((View)localObject3);
      ((LinearLayout.LayoutParams)((TextView)localObject3).getLayoutParams()).setMargins(b(0), 0, b(6), 0);
      break label391;
      localObject1 = paramMinsuHouseDetailBean.data.landlordName;
      break;
      label517:
      i = 0;
      break label146;
      label522:
      i = 0;
      break label169;
      label527:
      this.tv_price_original.setVisibility(8);
      break label346;
      label539:
      if (getString(2131297163).equals(((MinsuHouseDetailBean.DataBean.LabelTipsListBean)localObject2).tipsType))
      {
        ((TextView)localObject3).setTextSize(8.0F);
        ((TextView)localObject3).setTextColor(getResources().getColor(2131624487));
        ((TextView)localObject3).getPaint().setFakeBoldText(true);
        ((TextView)localObject3).setBackgroundResource(2130838659);
      }
    }
    label600:
    a(paramMinsuHouseDetailBean.data.longitude + "," + paramMinsuHouseDetailBean.data.latitude, paramMinsuHouseDetailBean.data.houseAddr);
    this.x = paramMinsuHouseDetailBean.data.orderType;
    a(paramMinsuHouseDetailBean);
    d(paramMinsuHouseDetailBean);
    b(paramMinsuHouseDetailBean);
    h();
    f(paramMinsuHouseDetailBean);
    l();
    q();
    e(paramMinsuHouseDetailBean);
    i();
  }
  
  private void d(MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    if ((paramMinsuHouseDetailBean == null) || (paramMinsuHouseDetailBean.data.tenantEvalVo == null) || (paramMinsuHouseDetailBean.data.evaluateCount == 0))
    {
      this.llEva.setVisibility(8);
      this.lineEva.setVisibility(8);
    }
    float f1;
    do
    {
      return;
      this.llEva.setVisibility(0);
      this.lineEva.setVisibility(0);
      this.fiveEvalute.setScore(paramMinsuHouseDetailBean.data.gradeStar);
      this.fiveEvalute.setCount(paramMinsuHouseDetailBean.data.evaluateCount);
      this.fiveEvalute.setTextColor(getResources().getColor(2131624042));
      this.tvEvaDetail.setText(paramMinsuHouseDetailBean.data.tenantEvalVo.evalContent);
      this.tvEvaTime.setText(paramMinsuHouseDetailBean.data.tenantEvalVo.evalDate + "  " + paramMinsuHouseDetailBean.data.tenantEvalVo.customerName);
      this.tvEvaDetail.setFold(false);
      this.tvEvaDetail.setIsUseFold(false);
      f1 = ab.getLineCountFromText(paramMinsuHouseDetailBean.data.tenantEvalVo.evalContent, this.tvEvaDetail);
      if ((paramMinsuHouseDetailBean.data.evaluateCount < 1) || ((paramMinsuHouseDetailBean.data.evaluateCount == 1) && ((paramMinsuHouseDetailBean.data.tenantEvalVo == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramMinsuHouseDetailBean.data.tenantEvalVo.landlordEvalContent))))) {
        this.tvEvaAll.setVisibility(8);
      }
    } while (f1 <= 3.0F);
    this.tvEvaDetail.setFold(false);
    this.tvEvaDetail.setFoldLine(3);
    this.tvEvaDetail.setIsUseFold(true);
    this.tvEvaDetail.invalidate();
    this.tvEvaDetail.setClickSpan(new MinsuHouseDeatailFolderTextView.b()
    {
      public void onClick()
      {
        MinsuHouseDetailActivity.this.tvEvaDetail.setFold(true);
        MinsuHouseDetailActivity.this.tvEvaDetail.setIsUseFold(false);
      }
    });
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.landlistOkNew(this, paramString, this.d, this.e, 1, 100, false, false, new t(this, new com.freelxl.baselibrary.d.f.d(MinsuHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseBean paramAnonymousMinsuHouseBean)
      {
        if ((paramAnonymousMinsuHouseBean != null) && (paramAnonymousMinsuHouseBean.checkSuccess(MinsuHouseDetailActivity.this)))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + paramAnonymousMinsuHouseBean.toString());
          if (paramAnonymousMinsuHouseBean.data.total < 1)
          {
            MinsuHouseDetailActivity.this.pagerLayout.setVisibility(8);
            MinsuHouseDetailActivity.this.tvLMoreHouse.setVisibility(8);
            return;
          }
          paramAnonymousMinsuHouseBean = paramAnonymousMinsuHouseBean.data.list.iterator();
          while (paramAnonymousMinsuHouseBean.hasNext())
          {
            MinsuHouseDetailBottomFragment localMinsuHouseDetailBottomFragment = MinsuHouseDetailBottomFragment.newInstance((MinsuHouseBean.DataBean.ListBean)paramAnonymousMinsuHouseBean.next());
            MinsuHouseDetailActivity.i(MinsuHouseDetailActivity.this).add(localMinsuHouseDetailBottomFragment);
          }
          paramAnonymousMinsuHouseBean = MinsuHouseDetailActivity.this.listHouse.getLayoutParams();
          paramAnonymousMinsuHouseBean.width = (ac.getScreenWidth(MinsuHouseDetailActivity.this) - ab.dp2px(MinsuHouseDetailActivity.this, 100.0F));
          MinsuHouseDetailActivity.this.listHouse.setLayoutParams(paramAnonymousMinsuHouseBean);
          paramAnonymousMinsuHouseBean = new MinsuHouseDetailActivity.b(MinsuHouseDetailActivity.this, MinsuHouseDetailActivity.this.getSupportFragmentManager());
          MinsuHouseDetailActivity.this.listHouse.setAdapter(paramAnonymousMinsuHouseBean);
          MinsuHouseDetailActivity.this.listHouse.setPageMargin(com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(MinsuHouseDetailActivity.this, 10));
          MinsuHouseDetailActivity.this.listHouse.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
          {
            public void onPageScrollStateChanged(int paramAnonymous2Int) {}
            
            public void onPageScrolled(int paramAnonymous2Int1, float paramAnonymous2Float, int paramAnonymous2Int2)
            {
              if (MinsuHouseDetailActivity.this.listHouse != null) {
                MinsuHouseDetailActivity.this.listHouse.invalidate();
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
    if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.d))) {
      return;
    }
    Intent localIntent = new Intent(this, MinsuLandlordDetailActivty.class);
    localIntent.putExtra("fid", this.d);
    localIntent.putExtra("uid", this.v);
    localIntent.putExtra("rentWay", this.e);
    startActivity(localIntent);
    v.onClick(this, "M-Landlord_home");
  }
  
  private void e(MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    this.f = new ArrayList();
    this.u = new ArrayList();
    paramMinsuHouseDetailBean = paramMinsuHouseDetailBean.data.picDisList;
    if (paramMinsuHouseDetailBean == null) {
      return;
    }
    paramMinsuHouseDetailBean = paramMinsuHouseDetailBean.iterator();
    while (paramMinsuHouseDetailBean.hasNext())
    {
      MinsuHouseDetailBean.DataBean.PicDisListBean localPicDisListBean = (MinsuHouseDetailBean.DataBean.PicDisListBean)paramMinsuHouseDetailBean.next();
      this.f.add(localPicDisListBean.eleValue);
      this.u.add(localPicDisListBean.eleKey);
    }
    if (this.b == null)
    {
      this.b = new a();
      this.viewpagerhomepage.setAdapter(this.b);
    }
    this.b.notifyDataSetChanged();
  }
  
  private void f()
  {
    if ((this.g != null) && (this.g.data != null))
    {
      v.onClick(this, "M-comment");
      Intent localIntent = new Intent(this, MinsuHouseEvaluationListActivity.class);
      localIntent.putExtra("fid", this.d);
      localIntent.putExtra("rentWay", this.e);
      localIntent.putExtra("llname", this.g.data.landlordName);
      startActivity(localIntent);
      com.ziroom.ziroomcustomer.minsu.f.k.animStartAlpha(this);
    }
  }
  
  private void f(MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    if ((paramMinsuHouseDetailBean == null) || (paramMinsuHouseDetailBean.data == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramMinsuHouseDetailBean.data.listHouseFacServ)))
    {
      this.llConfig.setVisibility(8);
      this.tvConfigAll.setVisibility(8);
    }
    for (;;)
    {
      return;
      Object localObject1 = paramMinsuHouseDetailBean.data.listHouseFacServ.iterator();
      int i = 0;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MinsuHouseDetailBean.DataBean.ListHouseFacServBean)((Iterator)localObject1).next();
        if (((MinsuHouseDetailBean.DataBean.ListHouseFacServBean)localObject2).subEnumVals == null) {}
        for (int j = 0;; j = ((MinsuHouseDetailBean.DataBean.ListHouseFacServBean)localObject2).subEnumVals.size())
        {
          i = j + i;
          break;
        }
      }
      localObject1 = this.tvConfigAll;
      if (i > 5) {}
      for (i = 0;; i = 8)
      {
        ((TextView)localObject1).setVisibility(i);
        this.llConfig.setVisibility(0);
        Iterator localIterator = paramMinsuHouseDetailBean.data.listHouseFacilities.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (MinsuHouseDetailBean.DataBean.ListHouseFacilitiesBean)localIterator.next();
          LinearLayout localLinearLayout = new LinearLayout(ApplicationEx.c);
          localLinearLayout.setOrientation(1);
          localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
          localObject2 = new SimpleDraweeView(ApplicationEx.c);
          Object localObject3 = new LinearLayout.LayoutParams(b(32), b(32));
          ((LinearLayout.LayoutParams)localObject3).gravity = 1;
          ((SimpleDraweeView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((SimpleDraweeView)localObject2).setController(com.freelxl.baselibrary.f.c.frescoController(((MinsuHouseDetailBean.DataBean.ListHouseFacilitiesBean)localObject1).iconThrUrl));
          localLinearLayout.addView((View)localObject2);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, b(4), 0, 0);
          localObject3 = new TextView(ApplicationEx.c);
          ((TextView)localObject3).setTextSize(12.0F);
          ((TextView)localObject3).setSingleLine();
          ((TextView)localObject3).setTextColor(getResources().getColor(2131624039));
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((TextView)localObject3).setGravity(17);
          localObject2 = ((MinsuHouseDetailBean.DataBean.ListHouseFacilitiesBean)localObject1).text;
          localObject1 = localObject2;
          if (((String)localObject2).length() >= 5) {
            localObject1 = ((String)localObject2).substring(0, 4) + "...";
          }
          ((TextView)localObject3).setText((CharSequence)localObject1);
          localLinearLayout.addView((View)localObject3);
          this.llConfig.addView(localLinearLayout);
        }
      }
      i = paramMinsuHouseDetailBean.data.listHouseFacilities.size();
      while (i < 5)
      {
        paramMinsuHouseDetailBean = new LinearLayout(ApplicationEx.c);
        paramMinsuHouseDetailBean.setOrientation(1);
        paramMinsuHouseDetailBean.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
        this.llConfig.addView(paramMinsuHouseDetailBean);
        i += 1;
      }
    }
  }
  
  private void g()
  {
    if (Build.VERSION.SDK_INT < 21) {
      com.freelxl.baselibrary.widget.a.show(this, null, false, true);
    }
    com.ziroom.ziroomcustomer.minsu.e.a.getHouseDetailV1(this, this.d, this.e, this.r, this.s, new s(this, new r(MinsuHouseDetailBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        com.freelxl.baselibrary.widget.a.dismiss();
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseDetailBean paramAnonymousMinsuHouseDetailBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseDetailBean);
        if ((paramAnonymousMinsuHouseDetailBean != null) && (paramAnonymousMinsuHouseDetailBean.checkSuccess(MinsuHouseDetailActivity.this)))
        {
          MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this, paramAnonymousMinsuHouseDetailBean);
          MinsuHouseDetailActivity.c(MinsuHouseDetailActivity.this);
          MinsuHouseDetailActivity.this.updateCouponBar();
          MsHistorySBean localMsHistorySBean = new MsHistorySBean();
          localMsHistorySBean.fid = MinsuHouseDetailActivity.d(MinsuHouseDetailActivity.this).data.fid;
          localMsHistorySBean.rentWay = MinsuHouseDetailActivity.d(MinsuHouseDetailActivity.this).data.rentWay;
          ad.putLookHouseHistory(localMsHistorySBean);
          MinsuHouseDetailActivity.b(MinsuHouseDetailActivity.this, paramAnonymousMinsuHouseDetailBean);
          com.freelxl.baselibrary.widget.a.dismiss();
          return;
        }
        if (paramAnonymousMinsuHouseDetailBean == null) {}
        for (paramAnonymousMinsuHouseDetailBean = null;; paramAnonymousMinsuHouseDetailBean = paramAnonymousMinsuHouseDetailBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuHouseDetailBean);
          break;
        }
      }
    });
  }
  
  private void g(MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    if ((paramMinsuHouseDetailBean == null) || (paramMinsuHouseDetailBean.data == null) || (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(paramMinsuHouseDetailBean.data.listHouseFacServ))) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramMinsuHouseDetailBean = paramMinsuHouseDetailBean.data.listHouseFacServ.iterator();
      while (paramMinsuHouseDetailBean.hasNext())
      {
        Object localObject1 = (MinsuHouseDetailBean.DataBean.ListHouseFacServBean)paramMinsuHouseDetailBean.next();
        if (!"".equals(((MinsuHouseDetailBean.DataBean.ListHouseFacServBean)localObject1).key))
        {
          localObject2 = new MinsuHouseDetailConfigBean();
          ((MinsuHouseDetailConfigBean)localObject2).setIcPath(null);
          ((MinsuHouseDetailConfigBean)localObject2).setName(((MinsuHouseDetailBean.DataBean.ListHouseFacServBean)localObject1).text);
          ((MinsuHouseDetailConfigBean)localObject2).setType(0);
          localArrayList.add(localObject2);
        }
        Object localObject2 = ((MinsuHouseDetailBean.DataBean.ListHouseFacServBean)localObject1).subEnumVals.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MinsuHouseDetailBean.DataBean.ListHouseFacServBean.SubEnumValsBean localSubEnumValsBean = (MinsuHouseDetailBean.DataBean.ListHouseFacServBean.SubEnumValsBean)((Iterator)localObject2).next();
          MinsuHouseDetailConfigBean localMinsuHouseDetailConfigBean = new MinsuHouseDetailConfigBean();
          localMinsuHouseDetailConfigBean.setIcPath(localSubEnumValsBean.iconThrUrl);
          localMinsuHouseDetailConfigBean.setName(localSubEnumValsBean.text);
          localMinsuHouseDetailConfigBean.setType(1);
          localArrayList.add(localMinsuHouseDetailConfigBean);
        }
        localObject1 = ((MinsuHouseDetailBean.DataBean.ListHouseFacServBean)localObject1).key;
      }
    } while (localArrayList.isEmpty());
    a(localArrayList);
  }
  
  private void h()
  {
    final MinsuHouseDetailBean localMinsuHouseDetailBean = this.g;
    if (localMinsuHouseDetailBean.data.listCheckRuleVo == null) {
      localMinsuHouseDetailBean.data.listCheckRuleVo = new ArrayList();
    }
    MinsuHouseDetailBean.DataBean.ListCheckRuleVoBean localListCheckRuleVoBean = new MinsuHouseDetailBean.DataBean.ListCheckRuleVoBean();
    localListCheckRuleVoBean.clickType = -1;
    localListCheckRuleVoBean.name = "出租日历";
    localListCheckRuleVoBean.val = "查看";
    localMinsuHouseDetailBean.data.listCheckRuleVo.add(localListCheckRuleVoBean);
    this.z = new com.freelxl.baselibrary.a.a(this, localMinsuHouseDetailBean.data.listCheckRuleVo, 2130904314)
    {
      public void convert(b paramAnonymousb, MinsuHouseDetailBean.DataBean.ListCheckRuleVoBean paramAnonymousListCheckRuleVoBean)
      {
        paramAnonymousb.setText(2131694588, paramAnonymousListCheckRuleVoBean.name);
        paramAnonymousb.setText(2131691546, paramAnonymousListCheckRuleVoBean.val);
        Resources localResources = MinsuHouseDetailActivity.this.getResources();
        if (paramAnonymousListCheckRuleVoBean.clickType != 0) {}
        for (int i = 2131624475;; i = 2131624039)
        {
          paramAnonymousb.setTextColor(2131691546, localResources.getColor(i));
          return;
        }
      }
    };
    q();
    this.listRules.setAdapter(this.z);
    this.listRules.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (MinsuHouseDetailBean.DataBean.ListCheckRuleVoBean)localMinsuHouseDetailBean.data.listCheckRuleVo.get(paramAnonymousInt);
        if (paramAnonymousAdapterView.clickType == 0) {
          return;
        }
        if (paramAnonymousAdapterView.clickType == -1)
        {
          MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this, false);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.type;
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuInfoActivity(MinsuHouseDetailActivity.this, Integer.parseInt(paramAnonymousAdapterView), MinsuHouseDetailActivity.e(MinsuHouseDetailActivity.this), MinsuHouseDetailActivity.f(MinsuHouseDetailActivity.this));
      }
    });
  }
  
  private void i()
  {
    if ((this.g != null) && (this.g.data.isToNightDiscount == 1) && (this.g.data.toNightDiscount != null))
    {
      this.ll_special_tonight_container.setVisibility(0);
      this.tvOriginalPrice.setVisibility(0);
      this.tvOriginalPrice.setPaintFlags(1297);
      if (this.g.data.toNightDiscount.remainTime > 0L) {
        j();
      }
      for (;;)
      {
        this.tv_special_tonight_price.setText(this.g.data.toNightDiscount.toNightDiscount * 10.0F + "折");
        this.tvPrice.setText("¥ " + ad.getPriceInt(this.g.data.toNightDiscount.tonightPrice) + "/晚");
        return;
        if (this.g.data.toNightDiscount.deadlineRemainTime > 0L) {
          k();
        }
      }
    }
    this.ll_special_tonight_container.setVisibility(8);
    this.tvOriginalPrice.setVisibility(8);
    this.tvPrice.setPaintFlags(1280);
  }
  
  private void j()
  {
    if (this.B != null) {
      this.B.cancel();
    }
    this.ll_special_tonight_left_container.setBackgroundColor(getResources().getColor(2131624495));
    this.tv_special_tonight_info.setText(this.g.data.toNightDiscount.openTime + " " + this.g.data.toNightDiscount.openTimeTips);
    this.B = new CountDownTimer(this.g.data.toNightDiscount.remainTime, 1000L)
    {
      public void onFinish()
      {
        MinsuHouseDetailActivity.h(MinsuHouseDetailActivity.this);
      }
      
      public void onTick(long paramAnonymousLong)
      {
        if (MinsuHouseDetailActivity.g(MinsuHouseDetailActivity.this) == null)
        {
          MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this, new SimpleDateFormat("HH:mm:ss"));
          MinsuHouseDetailActivity.g(MinsuHouseDetailActivity.this).setTimeZone(TimeZone.getTimeZone("GMT-00:00"));
        }
        String[] arrayOfString = MinsuHouseDetailActivity.g(MinsuHouseDetailActivity.this).format(new Date(paramAnonymousLong)).split(":");
        if ((arrayOfString.length < 3) || (MinsuHouseDetailActivity.this.tv_special_tonight_hour == null) || (MinsuHouseDetailActivity.this.tv_special_tonight_minutes == null) || (MinsuHouseDetailActivity.this.tv_special_tonight_seconds == null))
        {
          cancel();
          return;
        }
        MinsuHouseDetailActivity.this.tv_special_tonight_hour.setText(arrayOfString[0]);
        MinsuHouseDetailActivity.this.tv_special_tonight_minutes.setText(arrayOfString[1]);
        MinsuHouseDetailActivity.this.tv_special_tonight_seconds.setText(arrayOfString[2]);
      }
    }.start();
  }
  
  private void k()
  {
    if (this.B != null) {
      this.B.cancel();
    }
    if ((this.tvPrice == null) || (this.ll_special_tonight_left_container == null) || (this.tv_special_tonight_info == null) || (this.g == null) || (this.g.data == null) || (this.g.data.toNightDiscount == null)) {
      return;
    }
    this.ll_special_tonight_left_container.setBackgroundColor(getResources().getColor(2131624497));
    this.tv_special_tonight_info.setText(this.g.data.toNightDiscount.deadlineTimeTips);
    long l1 = this.g.data.toNightDiscount.deadlineRemainTime;
    if (this.g.data.toNightDiscount.remainTime > 0L) {
      l1 = this.g.data.toNightDiscount.deadlineRemainTime - this.g.data.toNightDiscount.remainTime;
    }
    l2 = l1;
    Object localObject;
    if (l1 <= 0L) {
      localObject = new SimpleDateFormat("HH:mm");
    }
    try
    {
      Date localDate = ((SimpleDateFormat)localObject).parse(this.g.data.toNightDiscount.deadlineTime);
      localObject = ((SimpleDateFormat)localObject).parse(this.g.data.toNightDiscount.openTime);
      l1 = localDate.getTime();
      l2 = ((Date)localObject).getTime();
      l2 = l1 - l2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        l2 = 1000L;
      }
    }
    this.B = new CountDownTimer(l2, 1000L)
    {
      public void onFinish()
      {
        if ((MinsuHouseDetailActivity.this.ll_special_tonight_container != null) && (MinsuHouseDetailActivity.this.tvPrice != null))
        {
          MinsuHouseDetailActivity.this.ll_special_tonight_container.setVisibility(8);
          MinsuHouseDetailActivity.this.tvPrice.setTextColor(Color.parseColor("#444444"));
          MinsuHouseDetailActivity.this.tvPrice.setPaintFlags(1280);
        }
      }
      
      public void onTick(long paramAnonymousLong)
      {
        if (MinsuHouseDetailActivity.g(MinsuHouseDetailActivity.this) == null)
        {
          MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this, new SimpleDateFormat("HH:mm:ss"));
          MinsuHouseDetailActivity.g(MinsuHouseDetailActivity.this).setTimeZone(TimeZone.getTimeZone("GMT-00:00"));
        }
        String[] arrayOfString = MinsuHouseDetailActivity.g(MinsuHouseDetailActivity.this).format(new Date(paramAnonymousLong)).split(":");
        if ((arrayOfString.length < 3) || (MinsuHouseDetailActivity.this.tv_special_tonight_hour == null) || (MinsuHouseDetailActivity.this.tv_special_tonight_minutes == null) || (MinsuHouseDetailActivity.this.tv_special_tonight_seconds == null))
        {
          cancel();
          return;
        }
        MinsuHouseDetailActivity.this.tv_special_tonight_hour.setText(arrayOfString[0]);
        MinsuHouseDetailActivity.this.tv_special_tonight_minutes.setText(arrayOfString[1]);
        MinsuHouseDetailActivity.this.tv_special_tonight_seconds.setText(arrayOfString[2]);
      }
    }.start();
  }
  
  private void l()
  {
    if ((this.g != null) && (this.g.data.houseStatus == 40))
    {
      String str = this.g.data.orderTypeName;
      this.tvOrderNow.setBackgroundColor(getResources().getColor(2131624475));
      TextView localTextView = this.tvOrderNow;
      if (m()) {}
      for (;;)
      {
        localTextView.setText(str);
        return;
        str = "选择日期";
      }
    }
    this.tvOrderNow.setBackgroundColor(getResources().getColor(2131624046));
    this.tvOrderNow.setText(getString(2131297080));
    this.tvOrderNow.setEnabled(false);
  }
  
  private boolean m()
  {
    return (ae.notNull(this.r)) && (ae.notNull(this.s));
  }
  
  private void n()
  {
    if (!com.ziroom.commonlibrary.login.a.getLoginState(this))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    if ((this.g != null) && (ae.notNull(this.g.data.landlordUid)) && (this.g.data.landlordUid.equals(com.ziroom.ziroomcustomer.minsu.e.d.getUid())))
    {
      g.textToast(this, getString(2131296555));
      return;
    }
    if ("MinsuChatDetail".equals(this.t))
    {
      finish();
      return;
    }
    Intent localIntent = new Intent(this, MinsuImInfoActivity.class);
    localIntent.putExtra("fid", this.d);
    localIntent.putExtra("isTop50Online", "0");
    localIntent.putExtra("rentWay", this.e);
    localIntent.putExtra("startTime", this.r);
    localIntent.putExtra("endTime", this.s);
    if ((this.g != null) && (this.g.data != null) && (ae.notNull(this.g.data.landlordName))) {
      localIntent.putExtra("lName", this.g.data.landlordName);
    }
    startActivity(localIntent);
  }
  
  private void o()
  {
    if (!ApplicationEx.c.isLoginState()) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.isCollectHouse(this, this.g.data.fid, this.g.data.rentWay, new t(this, new r(MinsuHouseIsCollectResutBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseIsCollectResutBean paramAnonymousMinsuHouseIsCollectResutBean)
      {
        if ((paramAnonymousMinsuHouseIsCollectResutBean != null) && (paramAnonymousMinsuHouseIsCollectResutBean.checkSuccess(MinsuHouseDetailActivity.this)))
        {
          MinsuHouseDetailActivity.b(MinsuHouseDetailActivity.this, "1".equals(paramAnonymousMinsuHouseIsCollectResutBean.data.isCollection));
          paramAnonymousMinsuHouseIsCollectResutBean = MinsuHouseDetailActivity.this.commonTitle;
          if (MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this)) {}
          for (paramAnonymousInt = 2130840221;; paramAnonymousInt = 2130840222)
          {
            paramAnonymousMinsuHouseIsCollectResutBean.showRightIv2nd(true, paramAnonymousInt);
            return;
          }
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
  
  private void p()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.unCollectHouse(this, this.d, this.e, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseCancelCollectResultBean localMinsuHouseCancelCollectResultBean = (MinsuHouseCancelCollectResultBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCancelCollectResultBean != null) && (localMinsuHouseCancelCollectResultBean.checkSuccess(MinsuHouseDetailActivity.this)) && ("0".equals(localMinsuHouseCancelCollectResultBean.data.delCollResult)))
        {
          paramAnonymousk = MinsuHouseDetailActivity.this.commonTitle;
          if (MinsuHouseDetailActivity.o(MinsuHouseDetailActivity.this) == 0) {}
          for (int i = 2130840222;; i = 2130840220)
          {
            paramAnonymousk.showRightIv2nd(true, i);
            MinsuHouseDetailActivity.b(MinsuHouseDetailActivity.this, false);
            paramAnonymousk = MinsuHouseDetailActivity.this.getIntent();
            paramAnonymousk.putExtra("fid", MinsuHouseDetailActivity.d(MinsuHouseDetailActivity.this).data.fid);
            paramAnonymousk.putExtra("rentWay", MinsuHouseDetailActivity.d(MinsuHouseDetailActivity.this).data.rentWay);
            paramAnonymousk.putExtra("isCollect", MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this));
            MinsuHouseDetailActivity.this.setResult(101, paramAnonymousk);
            com.freelxl.baselibrary.f.d.e("wzc_info", "取消收藏 ！ isCollect = " + MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this));
            g.textToast(MinsuHouseDetailActivity.this, "取消收藏成功");
            return;
          }
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
  
  private void q()
  {
    if ((ae.isNull(this.r)) || (ae.isNull(this.s)) || (this.g == null) || (this.g.data == null) || (this.g.data.longTermDays == null) || (this.A)) {}
    for (;;)
    {
      return;
      try
      {
        long l = m.getDaysBetween(m.strToDate(this.r, m.b), m.strToDate(this.s, m.b));
        com.freelxl.baselibrary.f.d.d("lanzhihong", "startTime===" + this.r + "==endTime===" + this.s + "===day==" + l);
        if (l >= this.g.data.longTermDays.intValue())
        {
          String str1 = this.g.data.checkOutRulesTitle;
          String str2 = this.g.data.longTermName;
          String str3 = this.g.data.longTermType;
          String str4 = this.g.data.curRulesType;
          Iterator localIterator = this.g.data.listCheckRuleVo.iterator();
          while (localIterator.hasNext())
          {
            MinsuHouseDetailBean.DataBean.ListCheckRuleVoBean localListCheckRuleVoBean = (MinsuHouseDetailBean.DataBean.ListCheckRuleVoBean)localIterator.next();
            if (localListCheckRuleVoBean.type.equals(str4))
            {
              localListCheckRuleVoBean.type = str3;
              localListCheckRuleVoBean.name = str1;
              localListCheckRuleVoBean.val = str2;
            }
          }
          this.z.notifyDataSetChanged();
          this.A = true;
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void r()
  {
    com.freelxl.baselibrary.f.d.i("wzc_info", " dismis image orietation == " + this.G);
    if (this.G == 1)
    {
      this.image.setVisibility(8);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (MinsuHouseDetailActivity.this.image.getVisibility() == 0) {
            MinsuHouseDetailActivity.this.image.setVisibility(8);
          }
        }
      }, 1100L);
    }
    while (this.G != 2) {
      return;
    }
    this.image.setVisibility(0);
  }
  
  public void achieveCoupon(final String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.achieveCoupon(this, paramString, new s(this, new r(MinsuHdAchieveCouponBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuHdAchieveCouponBean paramAnonymousMinsuHdAchieveCouponBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHdAchieveCouponBean);
        if (paramAnonymousMinsuHdAchieveCouponBean.checkSuccess(MinsuHouseDetailActivity.this)) {
          g.textToast(MinsuHouseDetailActivity.this, paramAnonymousMinsuHdAchieveCouponBean.message);
        }
        paramAnonymousMinsuHdAchieveCouponBean = MinsuHouseDetailActivity.m(MinsuHouseDetailActivity.this).data.couponList.iterator();
        while (paramAnonymousMinsuHdAchieveCouponBean.hasNext())
        {
          MinsuCouponListShowBean.DataBean.CouponListBean localCouponListBean = (MinsuCouponListShowBean.DataBean.CouponListBean)paramAnonymousMinsuHdAchieveCouponBean.next();
          if (paramString.equals(localCouponListBean.actSn)) {
            localCouponListBean.isCan = 0;
          }
        }
        if ((MinsuHouseDetailActivity.n(MinsuHouseDetailActivity.this) != null) && (MinsuHouseDetailActivity.n(MinsuHouseDetailActivity.this).isShowing())) {
          MinsuHouseDetailActivity.n(MinsuHouseDetailActivity.this).updateData(MinsuHouseDetailActivity.m(MinsuHouseDetailActivity.this));
        }
      }
    });
  }
  
  public void collectHouse()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.collectHouse(this, this.d, this.e, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        com.freelxl.baselibrary.f.d.i("wzc_info", " onSucc    1111 ");
        MinsuHouseCollectResultBean localMinsuHouseCollectResultBean = (MinsuHouseCollectResultBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCollectResultBean != null) && (localMinsuHouseCollectResultBean.checkSuccess(MinsuHouseDetailActivity.this)) && (localMinsuHouseCollectResultBean.data != null) && ("0".equals(localMinsuHouseCollectResultBean.data.collResult)))
        {
          com.freelxl.baselibrary.f.d.i("wzc_info", " onSucc    succ  2222 ");
          MinsuHouseDetailActivity.this.commonTitle.showRightIv2nd(true, 2130840221);
          MinsuHouseDetailActivity.b(MinsuHouseDetailActivity.this, true);
          paramAnonymousk = MinsuHouseDetailActivity.this.getIntent();
          paramAnonymousk.putExtra("fid", MinsuHouseDetailActivity.d(MinsuHouseDetailActivity.this).data.fid);
          paramAnonymousk.putExtra("rentWay", MinsuHouseDetailActivity.d(MinsuHouseDetailActivity.this).data.rentWay);
          paramAnonymousk.putExtra("isCollect", MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this));
          MinsuHouseDetailActivity.this.setResult(101, paramAnonymousk);
          com.freelxl.baselibrary.f.d.i("wzc_info", "加入收藏 成功 isCollect = " + MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this));
          g.textToast(MinsuHouseDetailActivity.this, "收藏成功");
          return;
        }
        com.freelxl.baselibrary.f.d.i("wzc_info", " onSucc    fail  1111 ");
        if (localMinsuHouseCollectResultBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseCollectResultBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  public void finish()
  {
    com.freelxl.baselibrary.f.d.i("wzc_info", "finish");
    super.finish();
  }
  
  public void finishAfterTransition()
  {
    com.freelxl.baselibrary.f.d.i("wzc_info", "finishAfterTransition");
    this.G = 2;
    super.finishAfterTransition();
  }
  
  public void initTitle()
  {
    this.commonTitle.setLeftButtonType(1);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseDetailActivity.this.supportFinishAfterTransition();
      }
    });
    this.commonTitle.setBottomLineVisible(false);
    this.commonTitle.showRightIc(true, 2130840339);
    this.commonTitle.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        v.onClick(MinsuHouseDetailActivity.this, "M-Product_detail_share_bottom");
        MinsuHouseDetailActivity.this.shareHouse();
      }
    });
    this.commonTitle.setBackground(getResources().getDrawable(2130838551));
    this.commonTitle.showRightIv2nd(true, 2130840222);
    this.commonTitle.setRightIv2ndListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(MinsuHouseDetailActivity.this);
          return;
        }
        if (MinsuHouseDetailActivity.a(MinsuHouseDetailActivity.this)) {
          MinsuHouseDetailActivity.b(MinsuHouseDetailActivity.this);
        }
        for (;;)
        {
          v.onClick(MinsuHouseDetailActivity.this, "M-Collection_detailwant");
          return;
          MinsuHouseDetailActivity.this.collectHouse();
        }
      }
    });
    this.commonTitle.updateTitleWidth();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 113))
    {
      this.r = paramIntent.getStringExtra("startDate");
      this.s = paramIntent.getStringExtra("endDate");
      l();
      if (!paramIntent.getBooleanExtra("isToNext", false)) {
        q();
      }
    }
    else
    {
      return;
    }
    toOrder();
  }
  
  public void onBackPressed()
  {
    com.freelxl.baselibrary.f.d.i("wzc_info", " onback press ");
    super.onBackPressed();
  }
  
  @OnClick({2131691338, 2131691344, 2131691351, 2131691360, 2131691359, 2131690895, 2131691224})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131691338: 
    case 2131691344: 
    case 2131691351: 
    case 2131691360: 
    case 2131691359: 
    case 2131690895: 
      do
      {
        return;
        f();
        return;
        e();
        return;
        g(this.g);
        return;
        if (m())
        {
          toOrder();
          return;
        }
        a(true);
        v.onClick(this, "M-Calendar_View");
        return;
        v.onClick(this, "M-Order_consultation");
        n();
        return;
      } while ((this.g == null) || (this.g.data == null));
      a(this.g.data.longitude, this.g.data.latitude, this.g.data.houseAddr);
      return;
    }
    showCoupon();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903279);
    ButterKnife.bind(this);
    paramBundle = getIntent();
    this.d = paramBundle.getStringExtra("fid");
    this.e = paramBundle.getIntExtra("rentWay", 0);
    this.r = paramBundle.getStringExtra("startTime");
    this.s = paramBundle.getStringExtra("endTime");
    this.w = paramBundle.getIntExtra("tag", -1);
    this.D = paramBundle.getStringExtra("image");
    this.t = paramBundle.getStringExtra("from");
    a(paramBundle);
    initTitle();
    g();
    b();
    a();
    i.houseDetail(this, this.d, this.e);
    com.freelxl.baselibrary.f.d.i("wzc_info", " onCreate");
  }
  
  protected void onDestroy()
  {
    if (this.B != null) {
      this.B.cancel();
    }
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.a);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    com.freelxl.baselibrary.f.d.i("wzc_info", " onPause ");
    super.onPause();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    paramInt1 = 2130840221;
    float f1 = paramInt2 / 500.0F;
    this.commonTitle.setHeaderAlpha(f1);
    if (f1 > 0.75D)
    {
      this.commonTitle.setLeftButtonType(2);
      this.commonTitle.setBottomLineVisible(true);
      this.commonTitle.showRightIc(true, 2130840338);
      localCommonTitle = this.commonTitle;
      if (this.y) {}
      for (;;)
      {
        localCommonTitle.showRightIv2nd(true, paramInt1);
        this.I = 1;
        return;
        paramInt1 = 2130840220;
      }
    }
    this.commonTitle.setBottomLineVisible(false);
    this.commonTitle.setLeftButtonType(1);
    this.commonTitle.showRightIc(true, 2130840339);
    CommonTitle localCommonTitle = this.commonTitle;
    if (this.y) {}
    for (;;)
    {
      localCommonTitle.showRightIv2nd(true, paramInt1);
      this.I = 0;
      return;
      paramInt1 = 2130840222;
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void scrollTo()
  {
    int[] arrayOfInt = new int[2];
    this.tvTitle1.getLocationOnScreen(arrayOfInt);
    this.svMain.scrollBy(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public void shareHouse()
  {
    if (this.g != null)
    {
      com.ziroom.threelib.ziroomshare.c localc = com.ziroom.threelib.ziroomshare.c.getInstance();
      if (localc != null)
      {
        localc.setOnPlatformClickListener(new c.a()
        {
          public void onPlatformClick(Platform paramAnonymousPlatform)
          {
            v.onClick(MinsuHouseDetailActivity.this, "M-Product_detail_share");
          }
        });
        l.d("#########分享参数", "url" + this.g.data.houseShareUrl);
        localc.shareFromCenter(this, this.g.data.houseShareUrl, this.g.data.houseName, this.g.data.mercureInfoVo.houseDesc, this.g.data.defaultPic, this.H);
      }
    }
  }
  
  public void showCoupon()
  {
    if (this.K != null)
    {
      showCouponPopView();
      return;
    }
    c(1);
  }
  
  public void showCouponPopView()
  {
    if ((this.K == null) || (this.K.data == null) || (this.K.data.couponList == null) || (this.K.data.couponList.isEmpty())) {
      return;
    }
    this.J = new e(this, new e.a()
    {
      public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        com.freelxl.baselibrary.f.d.i("wz", "p = " + paramAnonymousInt);
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.ziroomcustomer.minsu.f.k.toLoginActivity(MinsuHouseDetailActivity.this);
          return;
        }
        MinsuHouseDetailActivity.this.achieveCoupon(((MinsuCouponListShowBean.DataBean.CouponListBean)MinsuHouseDetailActivity.m(MinsuHouseDetailActivity.this).data.couponList.get(paramAnonymousInt)).actSn);
      }
    }, this.K);
    e locale = this.J;
    View localView = getWindow().getDecorView();
    if (!(locale instanceof PopupWindow))
    {
      locale.showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locale, localView, 80, 0, 0);
  }
  
  public void supportFinishAfterTransition()
  {
    com.freelxl.baselibrary.f.d.i("wzc_info", "supportFinishAfterTransition");
    super.supportFinishAfterTransition();
  }
  
  public void toOrder()
  {
    if (!ApplicationEx.c.isLoginState()) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
    label187:
    label189:
    do
    {
      for (;;)
      {
        return;
        if (this.g != null)
        {
          OrderStatusEnum localOrderStatusEnum = OrderStatusEnum.YD;
          String str2 = this.d;
          String str3 = this.g.data.houseName;
          int i = this.e;
          String str4 = this.r;
          String str5 = this.s;
          String str1;
          if (this.g.data != null)
          {
            str1 = this.g.data.landlordName;
            com.ziroom.ziroomcustomer.minsu.f.k.toMinsuApplyActivity(this, localOrderStatusEnum, str2, str3, i, str4, str5, str1, "");
            switch (this.w)
            {
            }
          }
          for (;;)
          {
            if (this.x == -1) {
              break label187;
            }
            if (1 != this.x) {
              break label189;
            }
            v.onClick(this, "M-To_order_liji");
            return;
            str1 = "";
            break;
            v.onClick(this, "M-Main_Path_tjcs");
            continue;
            v.onClick(this, "M-Main_Path_mstj");
            continue;
            v.onClick(this, "M-Main_Path_fxjc");
          }
        }
      }
    } while (2 != this.x);
    v.onClick(this, "M-To_order");
  }
  
  public void updateCouponBar()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.houseDetailCouponBar(this, new t(this, new com.freelxl.baselibrary.d.f.d(MinsuCouponBarShowBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuCouponBarShowBean paramAnonymousMinsuCouponBarShowBean)
      {
        if ((paramAnonymousMinsuCouponBarShowBean.checkSuccess(MinsuHouseDetailActivity.this)) && (paramAnonymousMinsuCouponBarShowBean.data != null))
        {
          if ((paramAnonymousMinsuCouponBarShowBean.data.barList != null) && (paramAnonymousMinsuCouponBarShowBean.data.barList.size() > 0))
          {
            MinsuHouseDetailActivity.this.couponArea.setVisibility(0);
            paramAnonymousInt = 0;
            if (paramAnonymousInt < 3)
            {
              TextView[] arrayOfTextView = new TextView[3];
              arrayOfTextView[0] = MinsuHouseDetailActivity.this.tvCouponBar0;
              arrayOfTextView[1] = MinsuHouseDetailActivity.this.tvCouponBar1;
              arrayOfTextView[2] = MinsuHouseDetailActivity.this.tvCouponBar2;
              if ((paramAnonymousMinsuCouponBarShowBean.data.barList.size() > paramAnonymousInt) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramAnonymousMinsuCouponBarShowBean.data.barList.get(paramAnonymousInt))))
              {
                String str = (String)paramAnonymousMinsuCouponBarShowBean.data.barList.get(paramAnonymousInt);
                arrayOfTextView[paramAnonymousInt].setText(str);
                arrayOfTextView[paramAnonymousInt].setVisibility(0);
              }
              for (;;)
              {
                paramAnonymousInt += 1;
                break;
                arrayOfTextView[paramAnonymousInt].setVisibility(8);
              }
            }
          }
          else
          {
            MinsuHouseDetailActivity.this.couponArea.setVisibility(8);
            MinsuHouseDetailActivity.this.line_coupon.setVisibility(8);
          }
          if (!TextUtils.isEmpty(paramAnonymousMinsuCouponBarShowBean.data.firstOrderReduce))
          {
            MinsuHouseDetailActivity.this.line_first_reduce.setVisibility(0);
            MinsuHouseDetailActivity.this.first_reduce_area.setVisibility(0);
            MinsuHouseDetailActivity.this.tv_first_reduce.setText(paramAnonymousMinsuCouponBarShowBean.data.firstOrderReduce);
            return;
          }
          MinsuHouseDetailActivity.this.first_reduce_area.setVisibility(8);
          MinsuHouseDetailActivity.this.line_first_reduce.setVisibility(8);
          return;
        }
        MinsuHouseDetailActivity.this.couponArea.setVisibility(8);
        MinsuHouseDetailActivity.this.line_coupon.setVisibility(8);
        MinsuHouseDetailActivity.this.first_reduce_area.setVisibility(8);
        MinsuHouseDetailActivity.this.line_first_reduce.setVisibility(8);
      }
    });
  }
  
  public class a
    extends PagerAdapter
  {
    private boolean b = true;
    
    public a() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      if (MinsuHouseDetailActivity.j(MinsuHouseDetailActivity.this) == null) {
        return 0;
      }
      return MinsuHouseDetailActivity.j(MinsuHouseDetailActivity.this).size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, final int paramInt)
    {
      View localView = LayoutInflater.from(MinsuHouseDetailActivity.this).inflate(2130904307, paramViewGroup, false);
      SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131695248);
      if ((paramInt == 0) && (this.b))
      {
        this.b = false;
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController((String)MinsuHouseDetailActivity.j(MinsuHouseDetailActivity.this).get(paramInt), new BaseControllerListener()
        {
          public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousString, paramAnonymousThrowable);
            MinsuHouseDetailActivity.k(MinsuHouseDetailActivity.this);
          }
          
          public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
          {
            super.onFinalImageSet(paramAnonymousString, paramAnonymousObject, paramAnonymousAnimatable);
            MinsuHouseDetailActivity.k(MinsuHouseDetailActivity.this);
          }
        }));
      }
      for (;;)
      {
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new ArrayList();
            Intent localIntent = new Intent(MinsuHouseDetailActivity.this, MinsuScanPhotoActivity.class);
            Bundle localBundle = new Bundle();
            paramAnonymousView.addAll(MinsuHouseDetailActivity.j(MinsuHouseDetailActivity.this));
            localBundle.putSerializable("texts", MinsuHouseDetailActivity.l(MinsuHouseDetailActivity.this));
            localBundle.putSerializable("photos", paramAnonymousView);
            localIntent.putExtra("position", paramInt);
            localIntent.putExtra("mHouse_type", 0);
            localIntent.putExtras(localBundle);
            MinsuHouseDetailActivity.this.startActivity(localIntent);
            v.onClick(MinsuHouseDetailActivity.this, "M-Big_Picture");
          }
        });
        paramViewGroup.addView(localView);
        return localView;
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController((String)MinsuHouseDetailActivity.j(MinsuHouseDetailActivity.this).get(paramInt)));
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView.equals(paramObject);
    }
  }
  
  public class b
    extends FragmentPagerAdapter
  {
    public b(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return MinsuHouseDetailActivity.i(MinsuHouseDetailActivity.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)MinsuHouseDetailActivity.i(MinsuHouseDetailActivity.this).get(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */