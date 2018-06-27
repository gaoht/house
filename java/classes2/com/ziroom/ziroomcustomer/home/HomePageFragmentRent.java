package com.ziroom.ziroomcustomer.home;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.testin.analysis.TestinApi;
import com.baidu.location.BDLocation;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.MoreBean;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.signed.s;
import com.ziroom.ziroomcustomer.util.p;
import com.ziroom.ziroomcustomer.util.p.a;
import com.ziroom.ziroomcustomer.util.t;
import com.ziroom.ziroomcustomer.util.t.a;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class HomePageFragmentRent
  extends HomePageFragment
  implements a
{
  private HomePageFragment_Entrust A;
  private List<Fragment> B;
  private int C;
  private int D;
  private boolean E = true;
  private MoreBean F;
  private int G = 200;
  private BroadcastReceiver H = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("select_city")) {
        HomePageFragmentRent.this.b(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getName());
      }
    }
  };
  private SimpleDraweeView t;
  private ImageView u;
  private LinearLayout v;
  private TextView w;
  private TextView x;
  private ViewPager y;
  private HomePageFragmentChildRent z;
  
  public HomePageFragmentRent()
  {
    super(2130903919);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localTextView = this.w;
      if (this.D == 0)
      {
        paramInt = Color.parseColor("#666666");
        this.D = paramInt;
        localTextView.setTextColor(paramInt);
        localTextView = this.x;
        if (this.C != 0) {
          break label104;
        }
        paramInt = Color.parseColor("#999999");
        this.C = paramInt;
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt);
        this.v.setBackgroundResource(2130837765);
        a(false);
        return;
        paramInt = this.D;
        break;
        label104:
        paramInt = this.C;
      }
    }
    TextView localTextView = this.w;
    if (this.C == 0)
    {
      paramInt = Color.parseColor("#999999");
      this.C = paramInt;
      localTextView.setTextColor(paramInt);
      localTextView = this.x;
      if (this.D != 0) {
        break label191;
      }
      paramInt = Color.parseColor("#666666");
      this.D = paramInt;
    }
    for (;;)
    {
      localTextView.setTextColor(paramInt);
      this.v.setBackgroundResource(2130837766);
      b(false);
      return;
      paramInt = this.C;
      break;
      label191:
      paramInt = this.D;
    }
  }
  
  private void a(BDLocation paramBDLocation)
  {
    Object localObject;
    if ((paramBDLocation != null) && (!TextUtils.isEmpty(paramBDLocation.getCity())))
    {
      localObject = paramBDLocation.getCity();
      paramBDLocation = (BDLocation)localObject;
      if (((String)localObject).endsWith("市")) {
        paramBDLocation = ((String)localObject).substring(0, ((String)localObject).length() - 1);
      }
      u.d("HomePageFragmentOrigin", "====" + paramBDLocation);
      paramBDLocation = com.ziroom.ziroomcustomer.base.b.getCityByName(paramBDLocation);
      localObject = new StringBuilder().append("====city is null:");
      if (paramBDLocation != null) {
        break label143;
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      u.d("HomePageFragmentOrigin", bool);
      if ((paramBDLocation != null) && (paramBDLocation.getCode() != null) && (!paramBDLocation.getCode().equals(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode())) && (this.E)) {
        a(paramBDLocation);
      }
      return;
    }
  }
  
  private void a(final com.ziroom.ziroomcustomer.base.a.b paramb)
  {
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this.b).create();
    View localView = LayoutInflater.from(this.b).inflate(2130904658, null);
    Object localObject = (TextView)localView.findViewById(2131690084);
    TextView localTextView = (TextView)localView.findViewById(2131693670);
    ((TextView)localObject).setText("系统当前定位城市是" + paramb.getName() + "，是否切换到" + paramb.getName());
    localTextView.setText("否");
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localAlertDialog.dismiss();
      }
    });
    localObject = (TextView)localView.findViewById(2131693671);
    localView.findViewById(2131689863).setVisibility(0);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText("是");
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.base.b.changeCity(paramb.getCode());
        localAlertDialog.dismiss();
      }
    });
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      paramb = localAlertDialog.getWindow();
      localObject = paramb.getAttributes();
      ((WindowManager.LayoutParams)localObject).width = ((int)(this.b.getResources().getDisplayMetrics().density * 245.0F + 0.5F));
      paramb.setAttributes((WindowManager.LayoutParams)localObject);
      localAlertDialog.getWindow().setContentView(localView);
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.u != null) {
      this.u.setVisibility(0);
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(0.0F, 1.0F));
    if (paramBoolean) {
      localAnimationSet.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F));
    }
    for (;;)
    {
      localAnimationSet.setDuration(300L);
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          if (HomePageFragmentRent.d(HomePageFragmentRent.this) != null) {
            HomePageFragmentRent.d(HomePageFragmentRent.this).setVisibility(0);
          }
        }
      });
      if (this.u != null) {
        this.u.startAnimation(localAnimationSet);
      }
      return;
      localAnimationSet.addAnimation(new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F));
      localAnimationSet.addAnimation(new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.u != null) {
      this.u.setVisibility(0);
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
    if (paramBoolean) {
      localAnimationSet.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.5F));
    }
    for (;;)
    {
      localAnimationSet.setDuration(300L);
      localAnimationSet.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          if (HomePageFragmentRent.d(HomePageFragmentRent.this) != null) {
            HomePageFragmentRent.d(HomePageFragmentRent.this).setVisibility(8);
          }
        }
      });
      if (this.u != null) {
        this.u.startAnimation(localAnimationSet);
      }
      return;
      localAnimationSet.addAnimation(new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F));
      localAnimationSet.addAnimation(new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F));
    }
  }
  
  private void f()
  {
    this.w.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HomePageFragmentRent.a(HomePageFragmentRent.this, 0);
        if ((HomePageFragmentRent.b(HomePageFragmentRent.this).getAdapter() != null) && (HomePageFragmentRent.b(HomePageFragmentRent.this).getAdapter().getCount() > 0)) {
          HomePageFragmentRent.b(HomePageFragmentRent.this).setCurrentItem(0);
        }
      }
    });
    this.x.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HomePageFragmentRent.a(HomePageFragmentRent.this, 1);
        if ((HomePageFragmentRent.b(HomePageFragmentRent.this).getAdapter() != null) && (HomePageFragmentRent.b(HomePageFragmentRent.this).getAdapter().getCount() > 1)) {
          HomePageFragmentRent.b(HomePageFragmentRent.this).setCurrentItem(1);
        }
      }
    });
  }
  
  private void g()
  {
    SearchCondition localSearchCondition = new SearchCondition();
    Object localObject = ApplicationEx.c.getLatlng_array();
    if ((localObject != null) && (localObject.length >= 4))
    {
      localSearchCondition.setMin_lat(String.valueOf(localObject[0]));
      localSearchCondition.setMin_lng(String.valueOf(localObject[1]));
      localSearchCondition.setMax_lat(String.valueOf(localObject[2]));
      localSearchCondition.setMax_lng(String.valueOf(localObject[3]));
    }
    if (ApplicationEx.c.getLocation() != null)
    {
      localObject = ApplicationEx.c.getLocation();
      if (!TextUtils.isEmpty(((BDLocation)localObject).getCity()))
      {
        String str = ((BDLocation)localObject).getCity();
        localObject = str;
        if (str != null)
        {
          localObject = str;
          if (str.endsWith("市")) {
            localObject = str.substring(0, str.length() - 1);
          }
        }
        if ((localObject != null) && (((String)localObject).equals(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getName())))
        {
          localSearchCondition.setClat(ApplicationEx.c.getLocation().getLatitude() + "");
          localSearchCondition.setClng(ApplicationEx.c.getLocation().getLongitude() + "");
        }
      }
    }
    localObject = new Intent(this.b, HouseListActivity.class);
    ((Intent)localObject).putExtra("searchCondition", localSearchCondition);
    startActivity((Intent)localObject);
  }
  
  private void h()
  {
    if ((ApplicationEx.c.isLoginState()) && (ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() > 0) && (ApplicationEx.g == 1)) {
      new s(this.b).showDialog();
    }
  }
  
  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    if ((this.y != null) && (this.y.getCurrentItem() == 0))
    {
      if (paramFloat <= 0.0F)
      {
        this.u.setVisibility(0);
        this.u.setAlpha(1.0F);
        this.u.setTranslationY(0.0F);
      }
    }
    else {
      return;
    }
    if (paramFloat >= 1.0F)
    {
      this.u.setVisibility(8);
      return;
    }
    if (paramFloat <= 0.85D)
    {
      this.u.setVisibility(0);
      paramFloat = paramFloat / 85.0F * 100.0F;
      this.u.setAlpha(1.0F - paramFloat * (paramFloat * paramFloat));
      return;
    }
    this.u.setVisibility(8);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (paramInt2 >= this.p * 3 / 4)
    {
      this.v.setY(paramInt2);
      this.u.setTranslationY(0.0F);
      return;
    }
    this.v.setY(this.p * 3 / 4);
    this.u.setTranslationY(-paramInt2);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.t = ((SimpleDraweeView)paramView.findViewById(2131694111));
    this.u = ((ImageView)paramView.findViewById(2131694116));
    this.v = ((LinearLayout)paramView.findViewById(2131694113));
    this.w = ((TextView)paramView.findViewById(2131694114));
    this.x = ((TextView)paramView.findViewById(2131694115));
    this.y = ((ViewPager)paramView.findViewById(2131694112));
    paramView = this.t.getLayoutParams();
    paramView.width = this.p;
    paramView.height = (this.p * 3 / 4);
    this.G = ((int)(this.p * 0.2F));
    this.t.setLayoutParams(paramView);
    final float f = this.b.getResources().getDisplayMetrics().density;
    p.showGuide(getActivity(), "home_rent", 2130904682, null, new p.a()
    {
      public void updateView(View paramAnonymousView)
      {
        ((RelativeLayout.LayoutParams)paramAnonymousView.findViewById(2131696039).getLayoutParams()).setMargins(0, (int)(HomePageFragmentRent.this.p * 3 / 4 + 18.0F * f), (int)(16.0F * f), 0);
      }
    });
    this.u.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        TestinApi.track("ahomesearch");
        HomePageFragmentRent.a(HomePageFragmentRent.this);
      }
    });
    f();
    this.B = new ArrayList();
    this.z = HomePageFragmentChildRent.newInstance(1);
    this.A = HomePageFragment_Entrust.newInstance();
    this.B.add(this.z);
    this.B.add(this.A);
    this.y.setFocusable(false);
    this.y.setAdapter(new a(getChildFragmentManager()));
    this.y.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        HomePageFragmentRent.a(HomePageFragmentRent.this, paramAnonymousInt);
      }
    });
    paramView = new IntentFilter();
    paramView.addAction("select_city");
    this.b.registerReceiver(this.H, paramView);
    if (t.isLocating())
    {
      u.d("HomePageFragmentOrigin", "====isLocating:true");
      t.addListener(new t.a()
      {
        public void onReceiveLocation(boolean paramAnonymousBoolean, BDLocation paramAnonymousBDLocation)
        {
          if (HomePageFragmentRent.this.isVisible()) {
            HomePageFragmentRent.a(HomePageFragmentRent.this, paramAnonymousBDLocation);
          }
        }
      });
    }
    for (;;)
    {
      h();
      return;
      u.d("HomePageFragmentOrigin", "====isLocating:false");
      a(ApplicationEx.c.getLocation());
    }
  }
  
  protected void c()
  {
    super.c();
    b(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getName());
  }
  
  protected void e()
  {
    super.e();
    g();
  }
  
  public void onBrandImgReady(final ContentBean paramContentBean)
  {
    if ((paramContentBean != null) && (this.t != null))
    {
      str = x.makeUrl(paramContentBean.getPic());
      this.t.setController(c.frescoResizeController(str, this.p, this.p * 3 / 4));
      this.t.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(paramContentBean.getLink())) {
            JsBridgeWebActivity.start(HomePageFragmentRent.this.b, paramContentBean.getTitle(), paramContentBean.getLink(), false, "", "", false);
          }
        }
      });
    }
    while (this.t == null)
    {
      String str;
      return;
    }
    this.t.setController(c.frescoResizeController("", this.p, this.p * 3 / 4));
    this.t.setOnClickListener(null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.b.unregisterReceiver(this.H);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public void onResume()
  {
    super.onResume();
    b(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getName());
  }
  
  public void onSearchConditionReady(MoreBean paramMoreBean)
  {
    this.F = paramMoreBean;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.E = paramBoolean;
  }
  
  private class a
    extends FragmentPagerAdapter
  {
    public a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      if (HomePageFragmentRent.c(HomePageFragmentRent.this) == null) {
        return 0;
      }
      return HomePageFragmentRent.c(HomePageFragmentRent.this).size();
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)HomePageFragmentRent.c(HomePageFragmentRent.this).get(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/HomePageFragmentRent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */