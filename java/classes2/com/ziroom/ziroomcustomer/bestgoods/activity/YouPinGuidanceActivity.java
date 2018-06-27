package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.ad;
import com.ziroom.ziroomcustomer.bestgoods.a.ag;
import com.ziroom.ziroomcustomer.bestgoods.a.w;
import com.ziroom.ziroomcustomer.bestgoods.a.y;
import com.ziroom.ziroomcustomer.bestgoods.c.d;
import com.ziroom.ziroomcustomer.bestgoods.dialog.YouPinSelectCityPop;
import com.ziroom.ziroomcustomer.bestgoods.model.al;
import com.ziroom.ziroomcustomer.bestgoods.model.al.a;
import com.ziroom.ziroomcustomer.bestgoods.model.al.b;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.t.a;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class YouPinGuidanceActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private TextView E;
  private TextView F;
  private TextView G;
  private TextView H;
  private List<String> I = new ArrayList();
  private ad J;
  private ag K;
  private com.ziroom.ziroomcustomer.bestgoods.a.t L;
  private y M;
  private w N;
  private al O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private PopupWindow S;
  private FrameLayout T;
  private TextView U;
  private YouPinSelectCityPop V = null;
  private boolean W = false;
  private boolean X = false;
  private String Y;
  private String Z;
  private Context a;
  private ImageView aa;
  private BroadcastReceiver ab = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("youpin_city_select"))
      {
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("cityName");
        String str = paramAnonymousIntent.getStringExtra("cityCode");
        YouPinGuidanceActivity.a(YouPinGuidanceActivity.this, paramAnonymousIntent.getBooleanExtra("isColsePop", false));
        YouPinGuidanceActivity.this.d(paramAnonymousContext);
        aa.putString(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), "currentYouPinCityName", paramAnonymousContext);
        aa.putString(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), "currentYouPinCityCode", str);
      }
    }
  };
  private boolean ac = false;
  private ImageView b;
  private ImageView c;
  private ConvenientBanner d;
  private MyGridView e;
  private ListViewForScrollView f;
  private RecyclerView g;
  private RecyclerView r;
  private RecyclerView s;
  private SimpleDraweeView t;
  private SimpleDraweeView u;
  private SimpleDraweeView v;
  private SimpleDraweeView w;
  private SimpleDraweeView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ImageView)findViewById(2131692745));
    this.T = ((FrameLayout)findViewById(2131692743));
    this.U = ((TextView)findViewById(2131692744));
    this.aa = ((ImageView)findViewById(2131692766));
    String str1 = aa.getString(this.a, "currentYouPinCityName", "");
    String str2 = aa.getString(this.a, "currentYouPinCityCode", "");
    if (TextUtils.isEmpty(str1))
    {
      this.U.setText("北京");
      aa.putString(this.a, "currentYouPinCityName", "北京");
      aa.putString(this.a, "currentYouPinCityCode", "110000");
    }
    for (;;)
    {
      this.d = ((ConvenientBanner)findViewById(2131692746));
      this.e = ((MyGridView)findViewById(2131692749));
      this.f = ((ListViewForScrollView)findViewById(2131692750));
      this.g = ((RecyclerView)findViewById(2131692752));
      this.r = ((RecyclerView)findViewById(2131692754));
      this.s = ((RecyclerView)findViewById(2131692757));
      this.t = ((SimpleDraweeView)findViewById(2131692758));
      this.u = ((SimpleDraweeView)findViewById(2131692761));
      this.v = ((SimpleDraweeView)findViewById(2131692762));
      this.w = ((SimpleDraweeView)findViewById(2131692763));
      this.x = ((SimpleDraweeView)findViewById(2131692764));
      this.P = ((TextView)findViewById(2131692736));
      this.Q = ((TextView)findViewById(2131692739));
      this.R = ((TextView)findViewById(2131692765));
      this.y = ((TextView)findViewById(2131692747));
      this.z = ((TextView)findViewById(2131692748));
      this.A = ((TextView)findViewById(2131692693));
      this.B = ((TextView)findViewById(2131692751));
      this.C = ((TextView)findViewById(2131692753));
      this.D = ((TextView)findViewById(2131692688));
      this.E = ((TextView)findViewById(2131692755));
      this.F = ((TextView)findViewById(2131692756));
      this.G = ((TextView)findViewById(2131692759));
      this.H = ((TextView)findViewById(2131692760));
      return;
      this.U.setText(str1);
      aa.putString(this.a, "currentYouPinCityName", str1);
      aa.putString(this.a, "currentYouPinCityCode", str2);
    }
  }
  
  private void a(BDLocation paramBDLocation)
  {
    if ((paramBDLocation != null) && (!TextUtils.isEmpty(paramBDLocation.getCity())))
    {
      this.Y = paramBDLocation.getCity();
      if (this.Y.endsWith("市")) {
        this.Y = this.Y.substring(0, this.Y.length() - 1);
      }
      paramBDLocation = com.ziroom.ziroomcustomer.bestgoods.a.getCityByName(this.Y);
      if (paramBDLocation != null) {
        break label80;
      }
    }
    label80:
    for (this.Z = "000000";; this.Z = paramBDLocation.getCode())
    {
      f();
      return;
    }
  }
  
  private void a(final List<al.b> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.I.clear();
    int i = 0;
    while (i < paramList.size())
    {
      this.I.add(((al.b)paramList.get(i)).getCarouselFigureUrl());
      i += 1;
    }
    this.d.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public com.ziroom.ziroomcustomer.newServiceList.view.c createHolder()
      {
        return new com.ziroom.ziroomcustomer.newServiceList.view.c();
      }
    }, this.I).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setPointViewVisible(true).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt) {}
    });
    this.d.startTurning(5000L);
    this.d.setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        Object localObject = ((al.b)paramList.get(paramAnonymousInt)).getCarouseState();
        if ("1".equals(localObject))
        {
          localObject = new Intent(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), YouPinGoodsListActivity.class);
          ((Intent)localObject).putExtra("typeCode", ((al.b)paramList.get(paramAnonymousInt)).getCarouseJumpcategoryCode());
          ((Intent)localObject).putExtra("typeName", ((al.b)paramList.get(paramAnonymousInt)).getCarouseJumpcategoryClass());
          YouPinGuidanceActivity.this.startActivityAndFinish((Intent)localObject);
        }
        do
        {
          return;
          if ("2".equals(localObject))
          {
            localObject = new Intent(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), GoodsDetailAc.class);
            ((Intent)localObject).putExtra("productCode", ((al.b)paramList.get(paramAnonymousInt)).getCarouseJumpProductCode());
            ((Intent)localObject).putExtra("skuCode", ((al.b)paramList.get(paramAnonymousInt)).getCarouseJumpSkuCode());
            YouPinGuidanceActivity.this.startActivity((Intent)localObject);
            return;
          }
        } while (!"3".equals(localObject));
        localObject = ((al.b)paramList.get(paramAnonymousInt)).getJumpTitle();
        String str1 = ((al.b)paramList.get(paramAnonymousInt)).getCarouselFigureSkipUrl();
        String str2 = ((al.b)paramList.get(paramAnonymousInt)).getShareContent();
        String str3 = ((al.b)paramList.get(paramAnonymousInt)).getCarouselFigureUrl();
        JsBridgeWebActivity.start(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), (String)localObject, str1, true, str2, str3, false);
      }
    });
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.aa.setOnClickListener(this);
  }
  
  private void e()
  {
    if (!aa.getBoolean(this.a, "isFirstIntoYouPinGuidance", false))
    {
      if (!com.ziroom.ziroomcustomer.util.t.isLocating()) {
        break label84;
      }
      u.d("YouPinGuidanceActivity", "====isLocating:true");
      com.ziroom.ziroomcustomer.util.t.addListener(new t.a()
      {
        public void onReceiveLocation(boolean paramAnonymousBoolean, BDLocation paramAnonymousBDLocation)
        {
          YouPinGuidanceActivity.a(YouPinGuidanceActivity.this, paramAnonymousBDLocation);
        }
      });
    }
    for (;;)
    {
      aa.putBoolean(this.a, "isFirstIntoYouPinGuidance", true);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("youpin_city_select");
      this.a.registerReceiver(this.ab, localIntentFilter);
      j();
      return;
      label84:
      u.d("YouPinGuidanceActivity", "====isLocating:false");
      a(ApplicationEx.c.getLocation());
    }
  }
  
  private void f()
  {
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this.a).create();
    View localView = LayoutInflater.from(this.a).inflate(2130904658, null);
    Object localObject1 = (TextView)localView.findViewById(2131690084);
    Object localObject2 = (TextView)localView.findViewById(2131693670);
    ((TextView)localObject1).setText("系统当前定位城市是" + this.Y + "，是否切换到" + this.Y);
    ((TextView)localObject2).setText("否");
    ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localAlertDialog.dismiss();
        aa.putBoolean(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), "isSwitchYouPinCity", false);
      }
    });
    localObject1 = (TextView)localView.findViewById(2131693671);
    localView.findViewById(2131689863).setVisibility(0);
    ((TextView)localObject1).setVisibility(0);
    ((TextView)localObject1).setText("是");
    ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        aa.putBoolean(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), "isSwitchYouPinCity", true);
        aa.putString(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), "currentYouPinCityName", YouPinGuidanceActivity.b(YouPinGuidanceActivity.this));
        aa.putString(YouPinGuidanceActivity.a(YouPinGuidanceActivity.this), "currentYouPinCityCode", YouPinGuidanceActivity.c(YouPinGuidanceActivity.this));
        localAlertDialog.dismiss();
        YouPinGuidanceActivity.d(YouPinGuidanceActivity.this).setText(YouPinGuidanceActivity.b(YouPinGuidanceActivity.this));
      }
    });
    localAlertDialog.setCanceledOnTouchOutside(false);
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localObject1 = localAlertDialog.getWindow();
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = ((int)(this.a.getResources().getDisplayMetrics().density * 245.0F + 0.5F));
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localAlertDialog.getWindow().setContentView(localView);
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  private void g()
  {
    if (this.X)
    {
      if (this.W) {
        finish();
      }
      while (this.V == null) {
        return;
      }
      this.V.checkCityIsSelect();
      return;
    }
    finish();
  }
  
  private void h()
  {
    if (this.V == null) {
      this.V = new YouPinSelectCityPop(this.a);
    }
    this.V.show(this.U);
  }
  
  private void i()
  {
    if (this.O == null) {}
    do
    {
      return;
      localObject = this.O.getBannerState();
      if ("1".equals(localObject))
      {
        localObject = new Intent(this.a, YouPinGoodsListActivity.class);
        ((Intent)localObject).putExtra("typeCode", this.O.getBannerCategoryCode());
        ((Intent)localObject).putExtra("typeName", this.O.getBannerCategoryClass());
        startActivityAndFinish((Intent)localObject);
        return;
      }
      if ("2".equals(localObject))
      {
        localObject = new Intent(this.a, GoodsDetailAc.class);
        ((Intent)localObject).putExtra("productCode", this.O.getBannerProductCode());
        ((Intent)localObject).putExtra("skuCode", this.O.getBannerSkuCode());
        startActivity((Intent)localObject);
        return;
      }
    } while (!"3".equals(localObject));
    Object localObject = this.O.getBannerUrl();
    String str = this.O.getBannerImageUrl();
    JsBridgeWebActivity.start(this.a, "", (String)localObject, true, "", str, false);
  }
  
  private void j()
  {
    n.getYoupinGuidanceInfo(this.a, "0", new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(al.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, al paramAnonymousal)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousal);
        if (paramAnonymousal != null)
        {
          YouPinGuidanceActivity.a(YouPinGuidanceActivity.this, paramAnonymousal);
          YouPinGuidanceActivity.e(YouPinGuidanceActivity.this);
        }
      }
    });
  }
  
  private void k()
  {
    this.y.setText(this.O.getFeaturedTitle());
    this.z.setText(this.O.getFeaturedDesc());
    this.A.setText(this.O.getSkuGroupTitle());
    this.B.setText(this.O.getSkuGroupName());
    this.C.setText(this.O.getDesignerTitle());
    this.D.setText(this.O.getDesignerDesc());
    this.E.setText(this.O.getBuyName());
    this.F.setText(this.O.getBuyDesc());
    this.G.setText(this.O.getAboutProductName());
    this.H.setText(this.O.getAboutProductDesc());
    if ((this.O.getCarouselFigures() != null) && (this.O.getCarouselFigures().size() > 0))
    {
      a(this.O.getCarouselFigures());
      this.d.setVisibility(0);
    }
    for (;;)
    {
      if ((this.O.getFeaturedTypes() != null) && (this.O.getFeaturedTypes().size() > 0))
      {
        this.J = new ad(this.a, this.O.getFeaturedTypes());
        this.e.setAdapter(this.J);
      }
      if ((this.O.getProductsActivityList() != null) && (this.O.getProductsActivityList().size() > 0))
      {
        this.K = new ag(this.a, this.O.getProductsActivityList());
        this.f.setAdapter(this.K);
      }
      if ((this.O.getSkuGroupList() != null) && (this.O.getSkuGroupList().size() > 0))
      {
        this.L = new com.ziroom.ziroomcustomer.bestgoods.a.t(this.a, this.O.getSkuGroupList());
        this.g.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        this.g.setAdapter(this.L);
      }
      if ((this.O.getDesignerList() != null) && (this.O.getDesignerList().size() > 0))
      {
        this.N = new w(this.a, this.O.getDesignerList());
        this.r.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        this.r.setAdapter(this.N);
      }
      if ((this.O.getTimeToBuyList() != null) && (this.O.getTimeToBuyList().size() > 0))
      {
        this.M = new y(this.a, this.O.getTimeToBuyList());
        this.s.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        this.s.setAdapter(this.M);
      }
      this.t.setController(com.freelxl.baselibrary.f.c.frescoController(this.O.getBannerImageUrl()));
      this.u.setController(com.freelxl.baselibrary.f.c.frescoController(this.O.getAboutProductUrl()));
      if ((this.O.getBottomTitleList() != null) && (this.O.getBottomTitleList().size() > 0))
      {
        this.v.setController(com.freelxl.baselibrary.f.c.frescoController(((al.a)this.O.getBottomTitleList().get(0)).getBottomTitleUrl()));
        this.P.setText(((al.a)this.O.getBottomTitleList().get(0)).getBottomTitleDesc());
        if (this.O.getBottomTitleList().size() > 1)
        {
          this.w.setController(com.freelxl.baselibrary.f.c.frescoController(((al.a)this.O.getBottomTitleList().get(1)).getBottomTitleUrl()));
          this.Q.setText(((al.a)this.O.getBottomTitleList().get(1)).getBottomTitleDesc());
        }
        if (this.O.getBottomTitleList().size() > 2)
        {
          this.x.setController(com.freelxl.baselibrary.f.c.frescoController(((al.a)this.O.getBottomTitleList().get(2)).getBottomTitleUrl()));
          this.R.setText(((al.a)this.O.getBottomTitleList().get(2)).getBottomTitleDesc());
        }
      }
      return;
      this.d.setVisibility(8);
    }
  }
  
  protected void d(String paramString)
  {
    if (this.U != null) {
      this.U.setText(paramString);
    }
  }
  
  public void onBackPressed()
  {
    g();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      g();
      return;
    case 2131692745: 
      j.toServiceOrderList(this.a, "type_youpin", "");
      return;
    case 2131692758: 
      i();
      return;
    case 2131692743: 
      this.X = true;
      this.W = false;
      h();
      return;
    }
    d.toYouPinShoppingCart(this.a);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903566);
    this.a = this;
    a();
    b();
    e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.a.unregisterReceiver(this.ab);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.S != null) && (this.ac)) {
      this.S.dismiss();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinGuidanceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */