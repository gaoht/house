package com.ziroom.ziroomcustomer.newmovehouse.fragment;

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
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.a.a;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.ak;
import com.ziroom.ziroomcustomer.newclean.d.au.b;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.SupplierEmployeeInfoVOBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.UserOrderItemVOsBean;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class MoveSmallDetailFragment
  extends BaseFragment
{
  private TextView A;
  private LinearLayout B;
  private LinearLayout C;
  private SimpleDraweeView D;
  private PullToRefreshScrollView E;
  private ImageView F;
  private RelativeLayout G;
  private TextView H;
  private Context I;
  private com.ziroom.ziroomcustomer.newmovehouse.b.i J;
  private boolean K = false;
  private MovingVanDetail L;
  private boolean M = false;
  private String N;
  private String O;
  private boolean P;
  private ClipboardManager Q;
  private String R;
  private boolean S = true;
  private ak T;
  private boolean U = false;
  List<MovingVanDetail.UserOrderItemVOsBean> a = new ArrayList();
  final List<MovingVanDetail.UserOrderItemVOsBean> b = new ArrayList();
  final List<MovingVanDetail.UserOrderItemVOsBean> c = new ArrayList();
  private View d;
  private SimpleDraweeView e;
  private TextView f;
  private TextView g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private TextView m;
  private TextView n;
  private RelativeLayout o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private RelativeLayout u;
  private TextView v;
  private ImageView w;
  private ListViewForScrollView x;
  private TextView y;
  private TextView z;
  
  private void a(View paramView)
  {
    this.d = paramView.findViewById(2131693967);
    this.e = ((SimpleDraweeView)paramView.findViewById(2131690047));
    this.f = ((TextView)paramView.findViewById(2131690371));
    this.g = ((TextView)paramView.findViewById(2131694530));
    this.h = ((ImageView)paramView.findViewById(2131690054));
    this.i = ((ImageView)paramView.findViewById(2131690055));
    this.j = ((ImageView)paramView.findViewById(2131690056));
    this.k = ((ImageView)paramView.findViewById(2131690057));
    this.l = ((ImageView)paramView.findViewById(2131690058));
    this.m = ((TextView)paramView.findViewById(2131690374));
    this.n = ((TextView)paramView.findViewById(2131690048));
    this.o = ((RelativeLayout)paramView.findViewById(2131691572));
    this.p = ((TextView)paramView.findViewById(2131690307));
    this.q = ((TextView)paramView.findViewById(2131694699));
    this.r = ((TextView)paramView.findViewById(2131694703));
    this.s = ((TextView)paramView.findViewById(2131694701));
    this.t = ((TextView)paramView.findViewById(2131694704));
    this.u = ((RelativeLayout)paramView.findViewById(2131694562));
    this.v = ((TextView)paramView.findViewById(2131694563));
    this.w = ((ImageView)paramView.findViewById(2131690327));
    this.x = ((ListViewForScrollView)paramView.findViewById(2131691811));
    this.y = ((TextView)paramView.findViewById(2131689912));
    this.z = ((TextView)paramView.findViewById(2131690305));
    this.A = ((TextView)paramView.findViewById(2131694710));
    this.B = ((LinearLayout)paramView.findViewById(2131694034));
    this.C = ((LinearLayout)paramView.findViewById(2131694337));
    this.D = ((SimpleDraweeView)paramView.findViewById(2131693966));
    this.E = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.F = ((ImageView)paramView.findViewById(2131694559));
    this.G = ((RelativeLayout)paramView.findViewById(2131694711));
    this.H = ((TextView)paramView.findViewById(2131694573));
  }
  
  private void b(String paramString)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    String str2 = ((UserInfo)localObject).getUid();
    String str1 = "";
    localObject = str1;
    if (this.S)
    {
      localObject = str1;
      if (this.T != null) {
        localObject = this.T.getCouponCode();
      }
    }
    if (!this.S) {}
    for (str1 = "2";; str1 = "1")
    {
      n.getMoveDetail(this.I, paramString, str2, str1, (String)localObject, new MoveSmallDetailFragment.4(this, new m(MovingVanDetail.class, new a())));
      return;
    }
  }
  
  private void c()
  {
    org.greenrobot.eventbus.c.getDefault().register(this);
    Object localObject = getArguments();
    this.N = ((Bundle)localObject).getString("orderId");
    this.R = ((Bundle)localObject).getString("moveOrderType");
    this.Q = ((ClipboardManager)this.I.getSystemService("clipboard"));
    localObject = this.I.getSharedPreferences("service_detail_cooy", 0);
    this.P = ((SharedPreferences)localObject).getBoolean("type_move_small_copy", true);
    if (this.P)
    {
      this.F.setVisibility(0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("type_move_small_copy", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      this.n.setText("联系师傅");
      this.J = new com.ziroom.ziroomcustomer.newmovehouse.b.i(this.I, this.a);
      this.x.setAdapter(this.J);
      b(this.N);
      this.E.setMode(PullToRefreshBase.b.b);
      this.E.setOnRefreshListener(new MoveSmallDetailFragment.1(this));
      this.x.setOnItemClickListener(new MoveSmallDetailFragment.2(this));
      return;
      this.F.setVisibility(8);
    }
  }
  
  private void d()
  {
    this.r.setText(this.L.getOrderStartAddress());
    this.s.setText(this.L.getOrderEndAddress());
    boolean bool1 = TextUtils.isEmpty(this.L.getSpecialNeed());
    boolean bool2 = TextUtils.isEmpty(this.L.getUserMessage());
    String str = "";
    Object localObject;
    if ((bool1) && (bool2))
    {
      this.C.setVisibility(8);
      localObject = new DecimalFormat("######0.00");
      this.y.setText(((DecimalFormat)localObject).format(this.L.getActualAllAmount().longValue() / 100.0D) + "");
      this.z.setText(this.L.getLogicCode());
      this.A.setText(com.ziroom.ziroomcustomer.newServiceList.utils.i.getMin2Data(this.L.getCreateTime()));
      if (this.L.getSupplierEmployeeInfoVO() != null) {
        break label504;
      }
      this.d.setVisibility(8);
    }
    for (;;)
    {
      this.v.setText("展开");
      this.w.setBackgroundResource(2130839134);
      if (this.L.getUserOrderItemVOs() != null) {
        break label724;
      }
      this.x.setVisibility(8);
      if ((this.L.getRecommandCoupon() != null) && (!TextUtils.isEmpty(this.L.getRecommandCoupon().getCanUseCoupon())) && ("1".equals(this.L.getRecommandCoupon().getCanUseCoupon()))) {
        this.U = true;
      }
      this.J.setMoveFeeArrow(this.U);
      if (TextUtils.isEmpty(this.L.getAppointmentTimeStr())) {
        break label1129;
      }
      this.p.setText(this.L.getAppointmentTimeStr());
      label309:
      if (!TextUtils.isEmpty(this.L.getConnectPhone())) {
        break label1149;
      }
      this.q.setText("");
      label331:
      this.F.setOnClickListener(new MoveSmallDetailFragment.7(this));
      this.z.setOnLongClickListener(new MoveSmallDetailFragment.8(this));
      if (!TextUtils.isEmpty(this.L.getPayType())) {
        break label1166;
      }
      this.G.setVisibility(8);
      return;
      this.C.setVisibility(0);
      if ((!bool1) && (!bool2)) {
        localObject = this.L.getSpecialNeed() + " " + this.L.getUserMessage();
      }
      for (;;)
      {
        this.t.setText((CharSequence)localObject);
        break;
        if ((!bool1) && (bool2))
        {
          localObject = this.L.getSpecialNeed();
        }
        else
        {
          localObject = str;
          if (bool1)
          {
            localObject = str;
            if (!bool2) {
              localObject = this.L.getUserMessage();
            }
          }
        }
      }
      label504:
      if (!TextUtils.isEmpty(this.L.getSupplierEmployeeInfoVO().getEmployeeCode()))
      {
        this.O = this.L.getSupplierEmployeeInfoVO().getEmployeeCode();
        f();
      }
      this.d.setVisibility(0);
      this.e.setController(com.freelxl.baselibrary.f.c.frescoController(this.L.getSupplierEmployeeInfoVO().getHeadPicture()));
      this.f.setText(this.L.getSupplierEmployeeInfoVO().getTrueName());
      com.ziroom.ziroomcustomer.newServiceList.utils.j.getStar((int)Double.valueOf(this.L.getSupplierEmployeeInfoVO().getEvaluateScore()).doubleValue(), this.h, this.i, this.j, this.k, this.l);
      this.m.setText(this.L.getSupplierEmployeeInfoVO().getTotalOrderCount() + "单");
      this.n.setText("联系师傅");
      if (TextUtils.isEmpty(this.L.getSupplierEmployeeInfoVO().getContactWay()))
      {
        this.n.setVisibility(8);
      }
      else
      {
        this.n.setVisibility(0);
        this.n.setOnClickListener(new MoveSmallDetailFragment.5(this));
      }
    }
    label724:
    this.b.clear();
    this.c.clear();
    this.a.clear();
    int i4 = this.L.getUserOrderItemVOs().size();
    int i2 = 0;
    int i1 = 0;
    int i3 = 0;
    label771:
    if (i2 < i4)
    {
      this.b.add(this.L.getUserOrderItemVOs().get(i2));
      if (!"优惠金额".equals(((MovingVanDetail.UserOrderItemVOsBean)this.L.getUserOrderItemVOs().get(i2)).getItemName())) {
        break label1189;
      }
      i1 = i2;
      i3 = 1;
    }
    label978:
    label1129:
    label1149:
    label1166:
    label1189:
    for (;;)
    {
      i2 += 1;
      break label771;
      if (i3 == 0)
      {
        localObject = new MovingVanDetail.UserOrderItemVOsBean();
        ((MovingVanDetail.UserOrderItemVOsBean)localObject).setItemName("优惠金额");
        ((MovingVanDetail.UserOrderItemVOsBean)localObject).setItemAmount(0);
        this.b.add(localObject);
        i1 = this.b.size() - 1;
      }
      i2 = 0;
      if (i2 < this.b.size())
      {
        if (this.b.size() < 3) {
          this.c.add(this.b.get(i2));
        }
        do
        {
          for (;;)
          {
            i2 += 1;
            break;
            if (i1 >= 3) {
              break label978;
            }
            if (i2 < 3) {
              this.c.add(this.b.get(i2));
            }
          }
          if (i2 < 2) {
            this.c.add(this.b.get(i2));
          }
        } while (i2 != 2);
        this.c.add(this.b.get(i1));
      }
      if (this.b.size() <= 3)
      {
        this.a.addAll(this.b);
        this.J.notifyDataSetChanged();
        this.x.setVisibility(0);
        this.u.setVisibility(8);
        break;
      }
      this.u.setVisibility(0);
      this.a.addAll(this.c);
      this.J.notifyDataSetChanged();
      this.u.setOnClickListener(new MoveSmallDetailFragment.6(this));
      break;
      this.p.setText(com.ziroom.ziroomcustomer.newServiceList.utils.i.getMin2Data(this.L.getAppointmentTime()));
      break label309;
      this.q.setText(this.L.getConnectPhone());
      break label331;
      this.G.setVisibility(0);
      this.H.setText(this.L.getPayType());
      return;
    }
  }
  
  private void e()
  {
    if ((this.E != null) && (this.E.isRefreshing())) {
      this.E.onRefreshComplete();
    }
  }
  
  private void f()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    if (this.M)
    {
      this.M = false;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.createShareOrder(this.I, this.N, "", "2c9085f248ba3f3a0148bb151aca0003", this.O);
      return;
    }
    com.ziroom.ziroomcustomer.newServiceList.utils.j.toShareCoupon(this.I, this.D, this.N, "", "2c9085f248ba3f3a0148bb151aca0003", this.O);
  }
  
  public static MoveSmallDetailFragment getInstance(String paramString1, String paramString2)
  {
    MoveSmallDetailFragment localMoveSmallDetailFragment = new MoveSmallDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString1);
    localBundle.putString("moveOrderType", paramString2);
    localMoveSmallDetailFragment.setArguments(localBundle);
    return localMoveSmallDetailFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.I = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903970, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
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
    if ("move_small_detail_refresh".equals(paramc.getType())) {
      b(this.N);
    }
    int i1;
    if ("move_small_detail_cancle_state".equals(paramc.getType()))
    {
      i1 = ((Integer)paramc.getData()).intValue();
      if (i1 != 0) {
        break label184;
      }
      this.B.setVisibility(8);
    }
    for (;;)
    {
      this.B.setOnClickListener(new MoveSmallDetailFragment.3(this));
      if ("move_small_button_refresh_detail".equals(paramc.getType())) {
        b(this.N);
      }
      if ("move_small_button_refresh_cancle".equals(paramc.getType())) {
        b(this.N);
      }
      if ("move_detail_coupon_use_info".equals(paramc.getType()))
      {
        this.S = true;
        this.T = ((ak)paramc.getData());
        b(this.N);
      }
      if ("move_detail_coupon_not_use".equals(paramc.getType()))
      {
        this.S = false;
        this.T = null;
        b(this.N);
      }
      return;
      label184:
      if (i1 == 1) {
        this.B.setVisibility(0);
      } else {
        this.B.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/fragment/MoveSmallDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */