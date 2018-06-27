package com.ziroom.ziroomcustomer.newclean.periodclean.fragment;

import android.content.Context;
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
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.b.y;
import com.ziroom.ziroomcustomer.newclean.d.ak;
import com.ziroom.ziroomcustomer.newclean.d.ar;
import com.ziroom.ziroomcustomer.newclean.d.aw;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.ChargesBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.ItemBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.RecommendCoupon;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.ServiceContentBean;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class PeriodGeneralDetailFragment
  extends BaseFragment
{
  private TextView A;
  private View B;
  private String C;
  private Context D;
  private boolean E = false;
  private String F;
  private String G;
  private ClipboardManager H;
  private boolean I;
  private TextView J;
  private TextView K;
  private View L;
  private LinearLayout M;
  private RelativeLayout N;
  private TextView O;
  private TextView P;
  private RelativeLayout Q;
  private TextView R;
  private String S;
  private ImageView T;
  private RelativeLayout U;
  private TextView V;
  private RelativeLayout W;
  private TextView X;
  private TextView Y;
  private boolean Z = true;
  private PullToRefreshScrollView a;
  private ak aa;
  private ImageView ab;
  private RelativeLayout ac;
  private ImageView ad;
  private TextView ae;
  private ListViewForScrollView af;
  private LinearLayout ag;
  private List<PeriodGeneralDetailBean.ItemBean> ah = new ArrayList();
  private y ai;
  private boolean aj = false;
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
  private LinearLayout t;
  private SimpleDraweeView u;
  private ImageView v;
  private RelativeLayout w;
  private TextView x;
  private RelativeLayout y;
  private TextView z;
  
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
    this.s = ((TextView)paramView.findViewById(2131689846));
    this.t = ((LinearLayout)paramView.findViewById(2131694034));
    this.u = ((SimpleDraweeView)paramView.findViewById(2131693966));
    this.v = ((ImageView)paramView.findViewById(2131694559));
    this.w = ((RelativeLayout)paramView.findViewById(2131694330));
    this.x = ((TextView)paramView.findViewById(2131694332));
    this.y = ((RelativeLayout)paramView.findViewById(2131694572));
    this.z = ((TextView)paramView.findViewById(2131694573));
    this.A = ((TextView)paramView.findViewById(2131692412));
    this.B = paramView.findViewById(2131694567);
    this.J = ((TextView)paramView.findViewById(2131694565));
    this.K = ((TextView)paramView.findViewById(2131694566));
    this.L = paramView.findViewById(2131694336);
    this.M = ((LinearLayout)paramView.findViewById(2131694337));
    this.N = ((RelativeLayout)paramView.findViewById(2131694325));
    this.Q = ((RelativeLayout)paramView.findViewById(2131694326));
    this.R = ((TextView)paramView.findViewById(2131691194));
    this.O = ((TextView)paramView.findViewById(2131694035));
    this.P = ((TextView)paramView.findViewById(2131694036));
    this.T = ((ImageView)paramView.findViewById(2131691574));
    this.U = ((RelativeLayout)paramView.findViewById(2131694568));
    this.V = ((TextView)paramView.findViewById(2131694569));
    this.Y = ((TextView)paramView.findViewById(2131694742));
    this.W = ((RelativeLayout)paramView.findViewById(2131694570));
    this.X = ((TextView)paramView.findViewById(2131694571));
    this.ab = ((ImageView)paramView.findViewById(2131690408));
    this.ag = ((LinearLayout)paramView.findViewById(2131694561));
    this.ac = ((RelativeLayout)paramView.findViewById(2131694562));
    this.ad = ((ImageView)paramView.findViewById(2131690327));
    this.ae = ((TextView)paramView.findViewById(2131694563));
    this.af = ((ListViewForScrollView)paramView.findViewById(2131691811));
  }
  
  private void a(ar paramar)
  {
    this.b.setVisibility(0);
    this.c.setController(com.freelxl.baselibrary.f.c.frescoController(paramar.getHeadPic()));
    this.d.setText(paramar.getName());
    this.S = paramar.getName();
    this.e.setVisibility(8);
    if (!TextUtils.isEmpty(paramar.getScore()))
    {
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar((int)(Double.parseDouble(paramar.getScore()) + 0.5D), this.f, this.g, this.h, this.i, this.j);
      if (!TextUtils.isEmpty(paramar.getServeNum())) {
        break label168;
      }
      this.k.setVisibility(8);
    }
    for (;;)
    {
      this.l.setText("联系师傅");
      this.l.setOnClickListener(new PeriodGeneralDetailFragment.9(this, paramar));
      return;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar(5, this.f, this.g, this.h, this.i, this.j);
      break;
      label168:
      this.k.setVisibility(0);
      this.k.setText(paramar.getServeNum() + "单");
    }
  }
  
  private void a(PeriodGeneralDetailBean paramPeriodGeneralDetailBean)
  {
    boolean bool = true;
    this.P.setOnClickListener(new PeriodGeneralDetailFragment.11(this, paramPeriodGeneralDetailBean));
    this.N.setOnClickListener(new PeriodGeneralDetailFragment.12(this, paramPeriodGeneralDetailBean));
    if (TextUtils.isEmpty(paramPeriodGeneralDetailBean.getEmployeeCode())) {
      this.b.setVisibility(8);
    }
    for (;;)
    {
      if (paramPeriodGeneralDetailBean.getAppointDateTime() != null) {
        this.m.setText(paramPeriodGeneralDetailBean.getAppointDateTime());
      }
      if (paramPeriodGeneralDetailBean.getServiceContent() == null)
      {
        this.w.setVisibility(8);
        this.n.setText(paramPeriodGeneralDetailBean.getConnectPhone());
        this.o.setText(paramPeriodGeneralDetailBean.getAddressName());
        this.r.setText(paramPeriodGeneralDetailBean.getOrderNum());
        if ((paramPeriodGeneralDetailBean.getCharges() != null) && (paramPeriodGeneralDetailBean.getCharges().getNeedPay() != null))
        {
          this.K.setVisibility(8);
          this.s.setVisibility(0);
        }
      }
      try
      {
        Object localObject = new DecimalFormat("######0.00");
        this.s.setText(((DecimalFormat)localObject).format(paramPeriodGeneralDetailBean.getCharges().getTotal().longValue() / 100L) + "");
        this.X.setText(((DecimalFormat)localObject).format(paramPeriodGeneralDetailBean.getCharges().getNeedPay().longValue() / 100.0D) + "");
        this.J.setVisibility(0);
        localObject = paramPeriodGeneralDetailBean.getRemark();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.p.setVisibility(8);
          this.q.setText("未填写特殊需求");
          this.M.setVisibility(8);
          this.L.setVisibility(8);
          this.r.setOnLongClickListener(new PeriodGeneralDetailFragment.2(this, paramPeriodGeneralDetailBean));
          this.y.setVisibility(8);
          this.B.setVisibility(0);
          this.U.setVisibility(8);
          if ((paramPeriodGeneralDetailBean.getRecommandCoupon() == null) || (!"1".equals(paramPeriodGeneralDetailBean.getRecommandCoupon().getCanUseCoupon()))) {
            break label751;
          }
          if ((paramPeriodGeneralDetailBean.getCharges() == null) || (paramPeriodGeneralDetailBean.getCharges().getDiscount() == null)) {
            break label768;
          }
          i1 = (int)(paramPeriodGeneralDetailBean.getCharges().getDiscount().longValue() / 100L);
          if ((paramPeriodGeneralDetailBean.getUserOrderItemVOs() == null) || (paramPeriodGeneralDetailBean.getUserOrderItemVOs().size() <= 0)) {
            break label756;
          }
          this.ag.setVisibility(0);
          this.ah.clear();
          this.ah.addAll(paramPeriodGeneralDetailBean.getUserOrderItemVOs());
          localObject = new PeriodGeneralDetailBean.ItemBean();
          ((PeriodGeneralDetailBean.ItemBean)localObject).setItemName("优惠金额");
          ((PeriodGeneralDetailBean.ItemBean)localObject).setItemAmount(Integer.valueOf(i1));
          ((PeriodGeneralDetailBean.ItemBean)localObject).setCanShowCoupon(bool);
          this.ah.add(localObject);
          this.ai.notifyDataSetChanged();
          this.ac.setOnClickListener(new PeriodGeneralDetailFragment.3(this));
          this.af.setOnItemClickListener(new PeriodGeneralDetailFragment.4(this, paramPeriodGeneralDetailBean));
          return;
          this.F = paramPeriodGeneralDetailBean.getEmployeeCode();
          this.G = paramPeriodGeneralDetailBean.getOrderNum();
          g();
          d();
          continue;
          this.w.setVisibility(0);
          this.x.setText(paramPeriodGeneralDetailBean.getServiceContent().getDesc());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1;
          localException.printStackTrace();
          continue;
          this.p.removeAllViews();
          this.M.setVisibility(0);
          this.L.setVisibility(0);
          String[] arrayOfString1 = com.ziroom.ziroomcustomer.newServiceList.utils.j.getSpaceTar(localException, ",,");
          if (arrayOfString1.length > 0)
          {
            if (arrayOfString1.length == 1)
            {
              this.p.setVisibility(8);
              this.q.setText(arrayOfString1[0]);
            }
            if (arrayOfString1.length == 2)
            {
              this.p.setVisibility(0);
              String[] arrayOfString2 = com.ziroom.ziroomcustomer.newServiceList.utils.j.getSpaceTar(arrayOfString1[1], ",");
              if (TextUtils.isEmpty(arrayOfString1[0])) {
                this.q.setVisibility(8);
              }
              for (;;)
              {
                com.ziroom.ziroomcustomer.newServiceList.utils.j.addDetailFlke(getActivity(), arrayOfString2, this.p);
                break;
                this.q.setText(arrayOfString1[0]);
              }
              label751:
              bool = false;
              continue;
              label756:
              this.ag.setVisibility(8);
              continue;
              label768:
              i1 = 0;
            }
          }
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((UserInfo)localObject).getUid())
    {
      n.getGeneralOrderControl(getContext(), paramString, (String)localObject, new PeriodGeneralDetailFragment.6(this, new m(aw.class, new com.ziroom.ziroomcustomer.e.c.a.a())));
      return;
    }
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    this.H = ((ClipboardManager)this.D.getSystemService("clipboard"));
    Object localObject = this.D.getSharedPreferences("service_detail_cooy", 0);
    this.I = ((SharedPreferences)localObject).getBoolean("type_general_clean_copy", true);
    if (this.I)
    {
      this.v.setVisibility(0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("type_general_clean_copy", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      this.v.setOnClickListener(new PeriodGeneralDetailFragment.1(this));
      this.C = localBundle.getString("orderId");
      this.ai = new y(this.D, this.ah);
      this.af.setAdapter(this.ai);
      e();
      this.a.setMode(PullToRefreshBase.b.b);
      this.a.setOnRefreshListener(new PeriodGeneralDetailFragment.5(this));
      return;
      this.v.setVisibility(8);
    }
  }
  
  private void d()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodGeneralCleanerInfo(this.D, this.F, new PeriodGeneralDetailFragment.8(this, this.D, new f(ar.class)));
  }
  
  private void e()
  {
    if (!ApplicationEx.c.isLoginState()) {
      return;
    }
    String str2 = "1";
    String str3 = "";
    String str1 = str3;
    if (this.Z)
    {
      str1 = str3;
      if (this.aa != null) {
        str1 = this.aa.getCouponCode();
      }
    }
    if (!this.Z) {
      str2 = "2";
    }
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodGeneralDetailInfo(this.D, this.C, str2, str1, new PeriodGeneralDetailFragment.10(this, this.D, new f(PeriodGeneralDetailBean.class)));
  }
  
  private void f()
  {
    if ((this.a != null) && (this.a.isRefreshing())) {
      this.a.onRefreshComplete();
    }
  }
  
  private void g()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    if (this.E)
    {
      this.E = false;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.createShareOrder(getActivity(), this.C, this.G, "2c9085f24af1d728014b004be6b50d3b", this.F);
      return;
    }
    com.ziroom.ziroomcustomer.newServiceList.utils.j.toShareCoupon(getActivity(), this.u, this.C, this.G, "2c9085f24af1d728014b004be6b50d3b", this.F);
  }
  
  public static PeriodGeneralDetailFragment getInstance(String paramString)
  {
    PeriodGeneralDetailFragment localPeriodGeneralDetailFragment = new PeriodGeneralDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localPeriodGeneralDetailFragment.setArguments(localBundle);
    return localPeriodGeneralDetailFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903975, paramViewGroup, false);
    this.D = getActivity();
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
    if ("period_general_detail_refresh".equals(paramc.getType()))
    {
      u.d("general_refresh", "======  general_detail_refresh success");
      e();
    }
    int i1;
    if ("period_general_detail_cancle_state".equals(paramc.getType()))
    {
      i1 = ((Integer)paramc.getData()).intValue();
      u.d("general_refresh", "======  general_detail_cancle_state");
      if (i1 != 0) {
        break label133;
      }
      this.t.setVisibility(8);
    }
    for (;;)
    {
      if ("period_general_pay_modify_coupon_info".equals(paramc.getType()))
      {
        this.Z = true;
        this.aa = ((ak)paramc.getData());
        e();
      }
      if ("period_general_pay_modify_coupon_info_not_use".equals(paramc.getType()))
      {
        this.Z = false;
        this.aa = null;
        e();
      }
      return;
      label133:
      if (i1 == 1)
      {
        this.t.setVisibility(0);
        this.O.setOnClickListener(new PeriodGeneralDetailFragment.7(this));
      }
      else
      {
        this.t.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/fragment/PeriodGeneralDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */