package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.newServiceList.a.p;
import com.ziroom.ziroomcustomer.newServiceList.fragment.OrderStatusAcceptedFragment;
import com.ziroom.ziroomcustomer.newServiceList.fragment.OrderStatusAllFragment;
import com.ziroom.ziroomcustomer.newServiceList.fragment.OrderStatusEvalFragment;
import com.ziroom.ziroomcustomer.newServiceList.fragment.OrderStatusPayFragment;
import com.ziroom.ziroomcustomer.newServiceList.fragment.OrderStatusVisitFragment;
import com.ziroom.ziroomcustomer.newServiceList.model.i;
import com.ziroom.ziroomcustomer.newServiceList.model.k;
import com.ziroom.ziroomcustomer.newServiceList.model.v;
import com.ziroom.ziroomcustomer.newServiceList.model.w;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class ZiroomOrderListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static int W;
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private ImageView D;
  private ImageView E;
  private View F;
  private RelativeLayout G;
  private ImageView H;
  private ImageView I;
  private Context J;
  private String K;
  private boolean L = true;
  private String M = "type_all";
  private String N = "all";
  private List<v> O = new ArrayList();
  private View P;
  private List<com.ziroom.ziroomcustomer.newServiceList.model.u> Q = new ArrayList();
  private List<w> R = new ArrayList();
  private ViewPager S;
  private FragmentPagerAdapter T;
  private boolean U = false;
  private String V;
  private int X = 0;
  private List<Integer> Y = new ArrayList();
  protected ArrayList<Fragment> a = new ArrayList();
  private TextView b;
  private LinearLayout c;
  private ListView d;
  private ImageView e;
  private ImageView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private RelativeLayout v;
  private RelativeLayout w;
  private RelativeLayout x;
  private RelativeLayout y;
  private RelativeLayout z;
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((LinearLayout)findViewById(2131691006));
    this.d = ((ListView)findViewById(2131692313));
    this.e = ((ImageView)findViewById(2131689492));
    this.F = findViewById(2131692314);
    this.f = ((ImageView)findViewById(2131690724));
    this.P = findViewById(2131692315);
    this.g = ((TextView)findViewById(2131692297));
    this.r = ((TextView)findViewById(2131692300));
    this.s = ((TextView)findViewById(2131692303));
    this.t = ((TextView)findViewById(2131692306));
    this.u = ((TextView)findViewById(2131692309));
    this.v = ((RelativeLayout)findViewById(2131692296));
    this.w = ((RelativeLayout)findViewById(2131692299));
    this.x = ((RelativeLayout)findViewById(2131692302));
    this.y = ((RelativeLayout)findViewById(2131692305));
    this.z = ((RelativeLayout)findViewById(2131692308));
    this.A = ((ImageView)findViewById(2131692298));
    this.B = ((ImageView)findViewById(2131692301));
    this.C = ((ImageView)findViewById(2131692304));
    this.D = ((ImageView)findViewById(2131692307));
    this.E = ((ImageView)findViewById(2131692310));
    this.S = ((ViewPager)findViewById(2131690606));
    this.G = ((RelativeLayout)findViewById(2131690603));
    this.H = ((ImageView)findViewById(2131692311));
    this.I = ((ImageView)findViewById(2131692312));
    this.c.setVisibility(0);
    this.P.setVisibility(0);
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (paramInt == 0)
    {
      this.I.setVisibility(0);
      this.H.setVisibility(8);
    }
    while (this.X == paramInt)
    {
      a(ServiceDetailActivity.a.b, paramFloat);
      return;
      this.I.setVisibility(8);
      this.H.setVisibility(0);
    }
    a(ServiceDetailActivity.a.a, paramFloat);
  }
  
  private void a(ServiceDetailActivity.a parama, float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
    if (parama == ServiceDetailActivity.a.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * W + this.X * W));
    }
    for (;;)
    {
      this.G.setLayoutParams(localLayoutParams);
      return;
      if (parama == ServiceDetailActivity.a.b) {
        localLayoutParams.leftMargin = ((int)(W * paramFloat + this.X * W));
      }
    }
  }
  
  private void b()
  {
    this.Q.add(new com.ziroom.ziroomcustomer.newServiceList.model.u(this.g, "all"));
    this.Q.add(new com.ziroom.ziroomcustomer.newServiceList.model.u(this.r, "accepted"));
    this.Q.add(new com.ziroom.ziroomcustomer.newServiceList.model.u(this.s, "visit"));
    this.Q.add(new com.ziroom.ziroomcustomer.newServiceList.model.u(this.t, "pay"));
    this.Q.add(new com.ziroom.ziroomcustomer.newServiceList.model.u(this.u, "eval"));
    this.e.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.N = "all";
      paramInt = 0;
      label12:
      if (paramInt >= this.Q.size()) {
        return;
      }
      if (!this.N.equals(((com.ziroom.ziroomcustomer.newServiceList.model.u)this.Q.get(paramInt)).getTvName())) {
        break label136;
      }
      ((com.ziroom.ziroomcustomer.newServiceList.model.u)this.Q.get(paramInt)).getTvText().setTextColor(40960);
    }
    for (;;)
    {
      paramInt += 1;
      break label12;
      if (paramInt == 1)
      {
        this.N = "accepted";
        break;
      }
      if (paramInt == 2)
      {
        this.N = "visit";
        break;
      }
      if (paramInt == 3)
      {
        this.N = "pay";
        break;
      }
      if (paramInt != 4) {
        break;
      }
      this.N = "eval";
      break;
      label136:
      ((com.ziroom.ziroomcustomer.newServiceList.model.u)this.Q.get(paramInt)).getTvText().setTextColor(-6710887);
    }
  }
  
  private void e()
  {
    int j = 0;
    this.b.setText("生活服务订单");
    this.g.setTextColor(40960);
    this.K = getIntent().getStringExtra("order_status_type");
    this.V = getIntent().getStringExtra("order_bus_type");
    if (TextUtils.isEmpty(this.V)) {
      this.V = "";
    }
    this.O.add(new v("全部", false, "type_all"));
    this.O.add(new v("保洁", false, "type_clean"));
    this.O.add(new v("搬家", false, "type_move"));
    this.O.add(new v("维修", false, "type_repair"));
    this.O.add(new v("优品", false, "type_youpin"));
    this.O.add(new v("租住服务", false, "type_zuzhu"));
    int i = 0;
    while (i < this.O.size())
    {
      this.R.add(new w(((v)this.O.get(i)).getTypeName(), false));
      i += 1;
    }
    p localp = new p(this.J, this.R);
    localp.setDownDataChangeListener(new ZiroomOrderListActivity.1(this));
    this.d.setAdapter(localp);
    this.a.add(OrderStatusAllFragment.getInstance(this.V));
    this.a.add(OrderStatusAcceptedFragment.getInstance(this.V));
    this.a.add(OrderStatusVisitFragment.getInstance(this.V));
    this.a.add(OrderStatusPayFragment.getInstance(this.V));
    this.a.add(OrderStatusEvalFragment.getInstance(this.V));
    this.T = new ZiroomOrderListActivity.2(this, getSupportFragmentManager());
    this.c.setVisibility(8);
    this.P.setVisibility(8);
    this.S.setAdapter(this.T);
    this.S.setOffscreenPageLimit(5);
    this.S.addOnPageChangeListener(new ZiroomOrderListActivity.3(this));
    if ("onlyEval".equals(this.K))
    {
      this.N = "eval";
      b(4);
      this.S.setCurrentItem(4);
      if (TextUtils.isEmpty(this.V)) {
        break label639;
      }
      i = j;
      label489:
      if (i >= this.O.size()) {
        break label631;
      }
      if (this.V.equals(((v)this.O.get(i)).getTypeCode()))
      {
        if (!"全部".equals(((v)this.O.get(i)).getTypeName())) {
          break label605;
        }
        this.b.setText("生活服务订单");
      }
    }
    for (;;)
    {
      i += 1;
      break label489;
      if (!"onlyPay".equals(this.K)) {
        break;
      }
      this.N = "pay";
      b(3);
      this.S.setCurrentItem(3);
      break;
      label605:
      this.b.setText(((v)this.O.get(i)).getTypeName());
    }
    label631:
    this.M = this.V;
    label639:
    f();
  }
  
  private void f()
  {
    this.Y.clear();
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    if ("type_clean".equals(this.M))
    {
      this.Y.add(Integer.valueOf(1000));
      this.Y.add(Integer.valueOf(1100));
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.n.getGataWayServiceListNum(this.J, this.Y, new ZiroomOrderListActivity.4(this, new e(k.class)));
      return;
      if ("type_move".equals(this.M))
      {
        this.Y.add(Integer.valueOf(1001));
        this.Y.add(Integer.valueOf(1301));
      }
      else if ("type_repair".equals(this.M))
      {
        this.Y.add(Integer.valueOf(1002));
      }
      else if ("type_youpin".equals(this.M))
      {
        this.Y.add(Integer.valueOf(1003));
      }
      else if ("type_zuzhu".equals(this.M))
      {
        this.Y.add(Integer.valueOf(1004));
      }
      else if ("type_all".equals(this.M))
      {
        this.Y.add(Integer.valueOf(1000));
        this.Y.add(Integer.valueOf(1100));
        this.Y.add(Integer.valueOf(1001));
        this.Y.add(Integer.valueOf(1002));
        this.Y.add(Integer.valueOf(1003));
        this.Y.add(Integer.valueOf(1004));
        this.Y.add(Integer.valueOf(1301));
      }
    }
  }
  
  private void g()
  {
    W = getResources().getDisplayMetrics().widthPixels / 5;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
    localLayoutParams.width = W;
    localLayoutParams.leftMargin = (W * 1);
    int i = (W - com.ziroom.ziroomcustomer.util.n.dip2px(this, 45.0F)) / 2;
    this.G.setPadding(i, 0, i, 0);
    this.G.setLayoutParams(localLayoutParams);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131692314: 
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131689541: 
    case 2131690724: 
      if (this.L)
      {
        this.L = false;
        com.ziroom.ziroomcustomer.newServiceList.utils.j.showArrow(true, this.f);
        com.ziroom.ziroomcustomer.newServiceList.utils.j.showSelectTypeView(true, this.c);
        return;
      }
      this.L = true;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.showArrow(false, this.f);
      com.ziroom.ziroomcustomer.newServiceList.utils.j.showSelectTypeView(false, this.c);
      return;
    case 2131692296: 
      this.S.setCurrentItem(0);
      b(0);
      return;
    case 2131692299: 
      this.S.setCurrentItem(1);
      b(1);
      return;
    case 2131692302: 
      this.S.setCurrentItem(2);
      b(2);
      return;
    case 2131692305: 
      this.S.setCurrentItem(3);
      b(3);
      return;
    }
    this.S.setCurrentItem(4);
    b(4);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903473);
    this.J = this;
    org.greenrobot.eventbus.c.getDefault().register(this);
    a();
    g();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if ("refresh_service_order_list".equals(paramc.getType()))
    {
      com.ziroom.ziroomcustomer.util.u.d("refresh_service_order_list", "======dd  refresh_service_order_list success");
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("service_orderlist_typename", new i(this.M, this.N)));
      f();
    }
    if ("service_orderlist_refresh_order_num".equals(paramc.getType())) {
      f();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/ZiroomOrderListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */