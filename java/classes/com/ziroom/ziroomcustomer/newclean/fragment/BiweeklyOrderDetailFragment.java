package com.ziroom.ziroomcustomer.newclean.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.h.a;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.util.u;
import org.greenrobot.eventbus.ThreadMode;

public class BiweeklyOrderDetailFragment
  extends BaseFragment
{
  private static String s = "BiweeklyOrderDetailFragment";
  private boolean A = false;
  private String B;
  private String C;
  private String D;
  private String E;
  private String F;
  private LinearLayout G;
  private TextView H;
  private boolean I = false;
  private boolean J = false;
  private View a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private SimpleDraweeView p;
  private PullToRefreshScrollView q;
  private Context r;
  private String t;
  private String u;
  private final int v = 17;
  private final int w = 18;
  private final int x = 19;
  private String y;
  private String z;
  
  private void a(View paramView)
  {
    this.a = paramView.findViewById(2131693967);
    this.b = ((SimpleDraweeView)paramView.findViewById(2131690047));
    this.c = ((TextView)paramView.findViewById(2131690371));
    this.d = ((TextView)paramView.findViewById(2131694530));
    this.e = ((ImageView)paramView.findViewById(2131690054));
    this.f = ((ImageView)paramView.findViewById(2131690055));
    this.g = ((ImageView)paramView.findViewById(2131690056));
    this.h = ((ImageView)paramView.findViewById(2131690057));
    this.i = ((ImageView)paramView.findViewById(2131690058));
    this.j = ((TextView)paramView.findViewById(2131690374));
    this.k = ((TextView)paramView.findViewById(2131690307));
    this.l = ((TextView)paramView.findViewById(2131690308));
    this.m = ((TextView)paramView.findViewById(2131690305));
    this.n = ((TextView)paramView.findViewById(2131689956));
    this.o = ((TextView)paramView.findViewById(2131690048));
    this.p = ((SimpleDraweeView)paramView.findViewById(2131693966));
    this.q = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.G = ((LinearLayout)paramView.findViewById(2131689838));
    this.H = ((TextView)paramView.findViewById(2131693965));
  }
  
  private void a(com.ziroom.ziroomcustomer.newclean.d.h paramh)
  {
    if (paramh.getEmployeeDetailVO() == null)
    {
      this.a.setVisibility(8);
      if (!TextUtils.isEmpty(paramh.getPlanServiceDate())) {
        break label392;
      }
      this.k.setText(paramh.getConstructionDate());
      label37:
      this.l.setText(this.y);
      this.m.setText(paramh.getOrderNum());
      if (!TextUtils.isEmpty(paramh.getOperateName())) {
        break label406;
      }
      this.I = false;
      e();
      label78:
      if (paramh.getHurryDisplayCode() != 1) {
        break label475;
      }
      this.H.setVisibility(0);
      this.J = true;
      e();
    }
    for (;;)
    {
      this.H.setOnClickListener(new BiweeklyOrderDetailFragment.5(this, paramh));
      return;
      if (TextUtils.isEmpty(paramh.getEmployeeDetailVO().getCleanerId()))
      {
        this.a.setVisibility(8);
        break;
      }
      this.z = paramh.getEmployeeDetailVO().getCleanerId();
      this.B = paramh.getOrderId();
      this.C = paramh.getOrderNum();
      this.a.setVisibility(0);
      this.b.setController(com.freelxl.baselibrary.f.c.frescoController(paramh.getEmployeeDetailVO().getHeadPic()));
      this.c.setText(paramh.getEmployeeDetailVO().getName());
      this.d.setVisibility(8);
      if (!TextUtils.isEmpty(paramh.getEmployeeDetailVO().getSocre()))
      {
        com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar((int)(Double.parseDouble(paramh.getEmployeeDetailVO().getSocre()) + 0.5D), this.e, this.f, this.g, this.h, this.i);
        label271:
        if (!TextUtils.isEmpty(paramh.getEmployeeDetailVO().getServeNum())) {
          break label348;
        }
        this.j.setVisibility(8);
      }
      for (;;)
      {
        this.o.setText("联系Ta");
        this.o.setOnClickListener(new BiweeklyOrderDetailFragment.3(this, paramh));
        break;
        com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar(5, this.e, this.f, this.g, this.h, this.i);
        break label271;
        label348:
        this.j.setVisibility(0);
        this.j.setText(paramh.getEmployeeDetailVO().getServeNum() + "单");
      }
      label392:
      this.k.setText(paramh.getPlanServiceDate());
      break label37;
      label406:
      if ("2".equals(paramh.getOperateCode())) {
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("biweekly_clean_detail_data", paramh));
      }
      this.I = true;
      e();
      this.n.setText(paramh.getOperateName());
      this.n.setOnClickListener(new BiweeklyOrderDetailFragment.4(this, paramh));
      break label78;
      label475:
      this.H.setVisibility(8);
      this.J = false;
      e();
    }
  }
  
  private void b(com.ziroom.ziroomcustomer.newclean.d.h paramh)
  {
    paramh = paramh.getOrderId();
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getRealName();
    n.setForCleanReminder(this.r, paramh, "5b4af223-8f1b-4f3e-8306-fa04fc81b24d", "18701270189", "", (String)localObject, new BiweeklyOrderDetailFragment.6(this, new com.ziroom.ziroomcustomer.newServiceList.utils.h(e.class)));
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    this.F = localBundle.getString("billId");
    this.D = localBundle.getString("rentContractCode");
    this.E = localBundle.getString("hireContractCode");
    this.y = localBundle.getString("contractAddress");
    this.t = localBundle.getString("date");
    this.u = localBundle.getString("time");
    this.q.setMode(PullToRefreshBase.b.b);
    this.q.setOnRefreshListener(new BiweeklyOrderDetailFragment.1(this));
    d();
  }
  
  private void d()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    n.getBiweeklyCleanDetail(getActivity(), (String)localObject, this.D, this.E, this.F, new BiweeklyOrderDetailFragment.2(this, new m(com.ziroom.ziroomcustomer.newclean.d.h.class, new a())));
  }
  
  private void e()
  {
    if ((this.I) || (this.J))
    {
      this.G.setVisibility(0);
      if (this.I)
      {
        this.n.setVisibility(0);
        if (!this.J) {
          break label89;
        }
        this.H.setVisibility(0);
      }
      for (;;)
      {
        if ((!this.J) || (!this.I)) {
          break label101;
        }
        this.H.setBackgroundResource(2130840000);
        return;
        this.n.setVisibility(8);
        break;
        label89:
        this.H.setVisibility(8);
      }
      label101:
      this.H.setBackgroundResource(2130839996);
      return;
    }
    this.G.setVisibility(8);
  }
  
  private void f()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    if (this.A)
    {
      this.A = false;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.createShareOrder(this.r, this.B, this.C, "2c9094833db58ad9013db58dfe070002", this.z);
      return;
    }
    com.ziroom.ziroomcustomer.newServiceList.utils.j.toShareCoupon(this.r, this.p, this.B, this.C, "2c9094833db58ad9013db58dfe070002", this.z);
  }
  
  private void g()
  {
    if ((this.q != null) && (this.q.isRefreshing())) {
      this.q.onRefreshComplete();
    }
  }
  
  public static BiweeklyOrderDetailFragment getInstance(Bundle paramBundle)
  {
    BiweeklyOrderDetailFragment localBiweeklyOrderDetailFragment = new BiweeklyOrderDetailFragment();
    localBiweeklyOrderDetailFragment.setArguments(paramBundle);
    return localBiweeklyOrderDetailFragment;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 17) && (paramInt2 == -1)) {
      c();
    }
    if ((paramInt1 == 19) && (paramInt2 == -1))
    {
      this.A = true;
      f();
      c();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.r = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903898, paramViewGroup, false);
    org.greenrobot.eventbus.c.getDefault().register(this);
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if ("biweekly_fragment_detail_refresh".equals(paramc.getType()))
    {
      u.d("sdjfkds", "========   Subscribe biweekly_fragment_detail zhixing ");
      d();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/BiweeklyOrderDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */