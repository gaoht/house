package com.ziroom.ziroomcustomer.newclean.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newclean.b.v;
import com.ziroom.ziroomcustomer.newclean.d.ar;
import com.ziroom.ziroomcustomer.newclean.d.au;
import com.ziroom.ziroomcustomer.newclean.d.au.a;
import com.ziroom.ziroomcustomer.newclean.d.aw;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanServiceTimeChangeSelectActivity;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class GeneralDetailFragment
  extends BaseFragment
{
  private TextView A;
  private RelativeLayout B;
  private TextView C;
  private View D;
  private String E;
  private Context F;
  private boolean G = false;
  private String H;
  private String I;
  private ClipboardManager J;
  private boolean K;
  private TextView L;
  private TextView M;
  private View N;
  private LinearLayout O;
  private RelativeLayout P;
  private TextView Q;
  private RelativeLayout R;
  private TextView S;
  private RelativeLayout T;
  private ImageView U;
  private TextView V;
  private ListViewForScrollView W;
  private LinearLayout X;
  private List<au.a> Y = new ArrayList();
  private v Z;
  private PullToRefreshScrollView a;
  private boolean aa = false;
  private TextView ab;
  private TextView ac;
  private int ad = 0;
  private String ae = "";
  private au af;
  private View b;
  private SimpleDraweeView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private FlowLayout p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private LinearLayout u;
  private SimpleDraweeView v;
  private ImageView w;
  private RelativeLayout x;
  private TextView y;
  private RelativeLayout z;
  
  private void a(View paramView)
  {
    this.a = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.b = paramView.findViewById(2131693967);
    this.c = ((SimpleDraweeView)paramView.findViewById(2131690047));
    this.d = ((TextView)paramView.findViewById(2131690371));
    this.e = ((TextView)paramView.findViewById(2131694530));
    this.f = ((ImageView)paramView.findViewById(2131690054));
    this.g = ((ImageView)paramView.findViewById(2131690055));
    this.h = ((ImageView)paramView.findViewById(2131690056));
    this.i = ((ImageView)paramView.findViewById(2131690057));
    this.j = ((ImageView)paramView.findViewById(2131690058));
    this.k = ((TextView)paramView.findViewById(2131690374));
    this.l = ((TextView)paramView.findViewById(2131690048));
    this.m = ((TextView)paramView.findViewById(2131694329));
    this.n = ((TextView)paramView.findViewById(2131690666));
    this.o = ((TextView)paramView.findViewById(2131690053));
    this.p = ((FlowLayout)paramView.findViewById(2131690332));
    this.q = ((TextView)paramView.findViewById(2131689837));
    this.r = ((TextView)paramView.findViewById(2131690305));
    this.s = ((TextView)paramView.findViewById(2131690307));
    this.t = ((TextView)paramView.findViewById(2131689846));
    this.u = ((LinearLayout)paramView.findViewById(2131694034));
    this.v = ((SimpleDraweeView)paramView.findViewById(2131693966));
    this.w = ((ImageView)paramView.findViewById(2131694559));
    this.x = ((RelativeLayout)paramView.findViewById(2131694330));
    this.y = ((TextView)paramView.findViewById(2131694332));
    this.z = ((RelativeLayout)paramView.findViewById(2131694572));
    this.A = ((TextView)paramView.findViewById(2131694573));
    this.B = ((RelativeLayout)paramView.findViewById(2131694560));
    this.C = ((TextView)paramView.findViewById(2131692412));
    this.D = paramView.findViewById(2131694567);
    this.L = ((TextView)paramView.findViewById(2131694565));
    this.M = ((TextView)paramView.findViewById(2131694566));
    this.N = paramView.findViewById(2131694336);
    this.O = ((LinearLayout)paramView.findViewById(2131694337));
    this.P = ((RelativeLayout)paramView.findViewById(2131694568));
    this.Q = ((TextView)paramView.findViewById(2131694569));
    this.R = ((RelativeLayout)paramView.findViewById(2131694570));
    this.S = ((TextView)paramView.findViewById(2131694571));
    this.X = ((LinearLayout)paramView.findViewById(2131694561));
    this.T = ((RelativeLayout)paramView.findViewById(2131694562));
    this.U = ((ImageView)paramView.findViewById(2131690327));
    this.V = ((TextView)paramView.findViewById(2131694563));
    this.W = ((ListViewForScrollView)paramView.findViewById(2131691811));
    this.ab = ((TextView)paramView.findViewById(2131694035));
    this.ac = ((TextView)paramView.findViewById(2131694036));
  }
  
  private void a(ar paramar)
  {
    this.ac.setOnClickListener(new GeneralDetailFragment.6(this, paramar));
    this.b.setVisibility(0);
    this.c.setController(com.freelxl.baselibrary.f.c.frescoController(paramar.getHeadPic()));
    this.d.setText(paramar.getName());
    this.e.setVisibility(8);
    if (!TextUtils.isEmpty(paramar.getScore()))
    {
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar((int)(Double.parseDouble(paramar.getScore()) + 0.5D), this.f, this.g, this.h, this.i, this.j);
      if (!TextUtils.isEmpty(paramar.getServeNum())) {
        break label176;
      }
      this.k.setVisibility(8);
    }
    for (;;)
    {
      this.l.setText("联系师傅");
      this.l.setOnClickListener(new GeneralDetailFragment.7(this, paramar));
      return;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar(5, this.f, this.g, this.h, this.i, this.j);
      break;
      label176:
      this.k.setVisibility(0);
      this.k.setText(paramar.getServeNum() + "单");
    }
  }
  
  private void a(au paramau)
  {
    this.ae = paramau.getSerInfoCode();
    d();
    this.ac.setOnClickListener(new GeneralDetailFragment.9(this));
    label93:
    label112:
    label196:
    Object localObject1;
    label247:
    label290:
    int i1;
    if (TextUtils.isEmpty(paramau.getCleannerId()))
    {
      this.b.setVisibility(8);
      if (paramau.getAppointTime() == null) {
        break label470;
      }
      this.m.setText(i.getSys2Data(paramau.getOrderDate()) + " " + paramau.getAppointTime());
      if (!TextUtils.isEmpty(paramau.getServiceContent())) {
        break label526;
      }
      this.x.setVisibility(8);
      this.n.setText(paramau.getLinkPhone());
      this.o.setText(paramau.getAddress());
      this.r.setText(paramau.getOrderNum());
      this.s.setText(paramau.getCreateDate());
      if (paramau.getIsPay() != 0) {
        break label639;
      }
      if (paramau.getOrderPrice() != null) {
        break label548;
      }
      this.M.setVisibility(0);
      this.t.setVisibility(8);
      this.L.setVisibility(8);
      localObject1 = paramau.getRemark();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label872;
      }
      this.p.setVisibility(8);
      this.q.setText("未填写特殊需求");
      this.O.setVisibility(8);
      this.N.setVisibility(8);
      this.r.setOnLongClickListener(new GeneralDetailFragment.10(this, paramau));
      if (!TextUtils.isEmpty(paramau.getPayTypeName())) {
        break label1014;
      }
      this.z.setVisibility(8);
      this.D.setVisibility(0);
      if (paramau.getDiscountPrice() != 0) {
        break label1044;
      }
      this.B.setVisibility(8);
      this.P.setVisibility(8);
      i1 = 0;
      label317:
      if (!TextUtils.isEmpty(paramau.getPayAmount())) {
        break label1166;
      }
      this.R.setVisibility(8);
    }
    for (;;)
    {
      if ((paramau.getUserOrderItemVOs() == null) || (paramau.getUserOrderItemVOs().size() <= 0)) {
        break label1249;
      }
      this.X.setVisibility(0);
      this.Y.clear();
      this.Y.addAll(paramau.getUserOrderItemVOs());
      if (i1 > 0)
      {
        paramau = new au.a();
        paramau.setItemName("优惠金额");
        paramau.setItemAmount(Integer.valueOf(i1));
        this.Y.add(paramau);
      }
      this.Z.notifyDataSetChanged();
      this.T.setOnClickListener(new GeneralDetailFragment.2(this));
      return;
      this.H = paramau.getCleannerId();
      this.I = paramau.getOrderNum();
      e();
      break;
      label470:
      this.m.setText(i.getSys2Data(paramau.getOrderDate()) + " " + paramau.getPeriodStartPoint() + "-" + paramau.getPeriodEndPoint());
      break label93;
      label526:
      this.x.setVisibility(0);
      this.y.setText(paramau.getServiceContent());
      break label112;
      label548:
      this.M.setVisibility(8);
      this.t.setVisibility(0);
      try
      {
        localObject1 = new DecimalFormat("######0.00");
        if (paramau.getAllAmount() != null) {
          this.t.setText(((DecimalFormat)localObject1).format(paramau.getAllAmount()) + "");
        }
        this.L.setVisibility(0);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
      label639:
      if (paramau.getIsPay() != 1) {
        break label196;
      }
      if (!TextUtils.isEmpty(paramau.getPayAmount()))
      {
        this.M.setVisibility(8);
        this.t.setVisibility(0);
        try
        {
          DecimalFormat localDecimalFormat1 = new DecimalFormat("######0.00");
          if (paramau.getAllAmount() != null) {
            this.t.setText(localDecimalFormat1.format(paramau.getAllAmount()) + "");
          }
          this.L.setVisibility(0);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
      this.M.setVisibility(0);
      this.t.setVisibility(8);
      this.L.setVisibility(8);
      if (paramau.getOrderPrice() == null) {
        break label196;
      }
      this.M.setVisibility(8);
      this.t.setVisibility(0);
      try
      {
        DecimalFormat localDecimalFormat2 = new DecimalFormat("######0.00");
        if (paramau.getAllAmount() != null) {
          this.t.setText(localDecimalFormat2.format(paramau.getAllAmount()) + "");
        }
        this.L.setVisibility(0);
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          localException3.printStackTrace();
        }
      }
      label872:
      this.p.removeAllViews();
      this.O.setVisibility(0);
      this.N.setVisibility(0);
      Object localObject2 = com.ziroom.ziroomcustomer.newServiceList.utils.j.getSpaceTar(localException3, ",,");
      if (localObject2.length <= 0) {
        break label247;
      }
      if (localObject2.length == 1)
      {
        this.p.setVisibility(8);
        this.q.setText(localObject2[0]);
      }
      if (localObject2.length != 2) {
        break label247;
      }
      this.p.setVisibility(0);
      String[] arrayOfString = com.ziroom.ziroomcustomer.newServiceList.utils.j.getSpaceTar(localObject2[1], ",");
      if (TextUtils.isEmpty(localObject2[0])) {
        this.q.setVisibility(8);
      }
      for (;;)
      {
        com.ziroom.ziroomcustomer.newServiceList.utils.j.addDetailFlke(getActivity(), arrayOfString, this.p);
        break;
        this.q.setText(localObject2[0]);
      }
      label1014:
      this.D.setVisibility(0);
      this.z.setVisibility(0);
      this.A.setText(paramau.getPayTypeName());
      break label290;
      label1044:
      this.P.setVisibility(8);
      this.B.setVisibility(8);
      this.C.setText(paramau.getDiscountPrice() + "元");
      try
      {
        localObject2 = new DecimalFormat("######0.0");
        this.Q.setText("-" + ((DecimalFormat)localObject2).format(paramau.getDiscountPrice()) + "元");
        i1 = paramau.getDiscountPrice();
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        i1 = 0;
      }
      break label317;
      try
      {
        label1166:
        if (!TextUtils.isEmpty(paramau.getPayAmount()))
        {
          float f1 = Float.parseFloat(paramau.getPayAmount());
          DecimalFormat localDecimalFormat3 = new DecimalFormat("######0.00");
          this.R.setVisibility(0);
          this.S.setText(localDecimalFormat3.format(f1) + "");
        }
      }
      catch (Exception localException5)
      {
        localException5.printStackTrace();
      }
    }
    label1249:
    this.X.setVisibility(8);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.af == null) {}
    while ((("2c9084454b7835b0014b7841269101a9".equals(this.af.getSerInfoCode())) && ("detail".equals(paramString1)) && (!TextUtils.isEmpty(this.af.getCleannerId()))) || (TextUtils.isEmpty(this.af.getAppointTime()))) {
      return;
    }
    paramString1 = i.getSysData(this.af.getOrderDate()) + " " + this.af.getAppointTime().substring(0, 5);
    Intent localIntent = new Intent(getActivity(), PeriodCleanServiceTimeChangeSelectActivity.class);
    localIntent.putExtra("addressId", this.af.getAddressId());
    if ("2c9084454b7835b0014b7841269101a9".equals(this.af.getSerInfoCode()))
    {
      localIntent.putExtra("cleanerName", paramString2);
      localIntent.putExtra("cleanerId", this.af.getCleannerId());
    }
    localIntent.putExtra("serviceInfoId", this.af.getSerInfoCode());
    localIntent.putExtra("servicePmId", this.af.getSerPmCode());
    localIntent.putExtra("mOldStartTime", paramString1);
    localIntent.putExtra("mOrderCode", this.af.getOrderNum());
    localIntent.putExtra("orderStatus", this.af.getOrderStatus());
    localIntent.putExtra("isGeneralClean", true);
    startActivity(localIntent);
  }
  
  private void b(String paramString)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((UserInfo)localObject).getUid())
    {
      n.getGeneralOrderControl(getContext(), paramString, (String)localObject, new GeneralDetailFragment.4(this, new m(aw.class, new a()), paramString));
      return;
    }
  }
  
  private void c()
  {
    org.greenrobot.eventbus.c.getDefault().register(this);
    Bundle localBundle = getArguments();
    this.J = ((ClipboardManager)this.F.getSystemService("clipboard"));
    Object localObject = this.F.getSharedPreferences("service_detail_cooy", 0);
    this.K = ((SharedPreferences)localObject).getBoolean("type_general_clean_copy", true);
    if (this.K)
    {
      this.w.setVisibility(0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("type_general_clean_copy", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      this.w.setOnClickListener(new GeneralDetailFragment.1(this));
      this.E = localBundle.getString("orderId");
      this.Z = new v(this.F, this.Y);
      this.W.setAdapter(this.Z);
      f();
      this.a.setMode(PullToRefreshBase.b.b);
      this.a.setOnRefreshListener(new GeneralDetailFragment.3(this));
      return;
      this.w.setVisibility(8);
    }
  }
  
  private void d()
  {
    if ((this.ad != 0) && (!"8a90a5d85841edb0015847dd11110000".equals(this.ae)))
    {
      this.ac.setVisibility(0);
      return;
    }
    this.ac.setVisibility(8);
  }
  
  private void e()
  {
    n.getGeneralCleanerInfo(getActivity(), this.H, new GeneralDetailFragment.5(this, new m(ar.class, new a())));
  }
  
  private void f()
  {
    if (!ApplicationEx.c.isLoginState()) {
      return;
    }
    n.getGeneralDetail(getActivity(), this.E, new GeneralDetailFragment.8(this, new m(au.class, new a())));
  }
  
  private void g()
  {
    if ((this.a != null) && (this.a.isRefreshing())) {
      this.a.onRefreshComplete();
    }
  }
  
  public static GeneralDetailFragment getInstance(String paramString)
  {
    GeneralDetailFragment localGeneralDetailFragment = new GeneralDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localGeneralDetailFragment.setArguments(localBundle);
    return localGeneralDetailFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903910, paramViewGroup, false);
    this.F = getActivity();
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
    if ("general_detail_refresh".equals(paramc.getType()))
    {
      u.d("general_refresh", "======  general_detail_refresh success");
      f();
    }
    if ("general_button_refresh_detail".equals(paramc.getType())) {
      f();
    }
    if ("general_button_refresh_cancle".equals(paramc.getType())) {
      f();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/GeneralDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */