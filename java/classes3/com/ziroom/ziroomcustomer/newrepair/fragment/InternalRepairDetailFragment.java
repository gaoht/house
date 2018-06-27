package com.ziroom.ziroomcustomer.newrepair.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.newrepair.a.f;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairPlanActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.UrgencyRepairActivity;
import com.ziroom.ziroomcustomer.newrepair.widget.StarBar;
import com.ziroom.ziroomcustomer.newrepair.widget.ZiScroListView;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;

public class InternalRepairDetailFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private static InternalRepairDetailFragment c;
  private static final Object d = new Object();
  private Context a;
  private View b;
  private RelativeLayout e;
  private SimpleDraweeView f;
  private TextView g;
  private StarBar h;
  private TextView i;
  private ImageView j;
  private LinearLayout k;
  private TextView l;
  private RelativeLayout m;
  private TextView n;
  private ZiScroListView o;
  private f p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private Button w;
  private LinearLayout x;
  private com.ziroom.ziroomcustomer.newrepair.b.c y;
  private int z;
  
  private void c()
  {
    this.e = ((RelativeLayout)this.b.findViewById(2131690369));
    this.k = ((LinearLayout)this.b.findViewById(2131694801));
    this.o = ((ZiScroListView)this.b.findViewById(2131691016));
    this.q = ((TextView)this.b.findViewById(2131693265));
    this.r = ((TextView)this.b.findViewById(2131694802));
    this.s = ((TextView)this.b.findViewById(2131694803));
    this.t = ((TextView)this.b.findViewById(2131694804));
    this.u = ((TextView)this.b.findViewById(2131694805));
    this.v = ((TextView)this.b.findViewById(2131694807));
    this.x = ((LinearLayout)this.b.findViewById(2131694808));
    this.w = ((Button)this.b.findViewById(2131690460));
  }
  
  public static InternalRepairDetailFragment getInstance()
  {
    synchronized (d)
    {
      if (c == null) {
        c = new InternalRepairDetailFragment();
      }
      InternalRepairDetailFragment localInternalRepairDetailFragment = c;
      return localInternalRepairDetailFragment;
    }
  }
  
  public void initData(com.ziroom.ziroomcustomer.newrepair.b.c paramc)
  {
    this.y = paramc;
    this.p = new f(this.a, this.y.getWxxmList());
    this.o.setAdapter(this.p);
    paramc = this.y.getYyTime();
    Object localObject1 = this.y.getSignTime();
    Object localObject2 = this.y.getSfyyTime();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.q.setText("上门时间");
      this.r.setText(m.TimeL2S(m.TimeS2L((String)localObject1, m.c), m.d));
      this.s.setText(this.y.getCPhone());
      this.t.setText(this.y.getAddress());
      this.u.setText(this.y.getBillnum());
      this.v.setText(m.TimeL2S(m.TimeS2L(this.y.getCreateTime(), m.c), m.d));
      this.z = this.y.getNewState();
      paramc = this.y.getSName();
      localObject1 = this.y.getSPic();
      if ((this.z != 0) && (this.z != 5)) {
        break label752;
      }
      this.x.setVisibility(0);
      this.w.setOnClickListener(this);
      label224:
      if ((this.z < 5) || (TextUtils.isEmpty(paramc))) {
        break label776;
      }
      this.e.setVisibility(0);
      this.f = ((SimpleDraweeView)this.b.findViewById(2131694706));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.f.setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject1));
      }
      this.g = ((TextView)this.b.findViewById(2131694798));
      this.h = ((StarBar)this.b.findViewById(2131690000));
      this.h.setEnabled(false);
      this.h.setClickable(false);
      this.h.setStarMark((float)Math.round(this.y.getSStar()));
      this.i = ((TextView)this.b.findViewById(2131694799));
      this.j = ((ImageView)this.b.findViewById(2131694800));
      if ((this.z == 10) || (this.z == 50)) {
        break label764;
      }
      this.j.setOnClickListener(this);
      label405:
      this.h.setStarMark((float)Math.round(this.y.getSStar()));
      this.g.setText(this.y.getSName());
      this.i.setText("" + this.y.getSCount() + "单");
    }
    for (;;)
    {
      if ((this.z == 25) || (this.z == 30) || (this.z == 35) || (this.z == 50))
      {
        this.k.setVisibility(0);
        this.l = ((TextView)this.b.findViewById(2131692617));
        this.l.setOnClickListener(this);
        this.m = ((RelativeLayout)this.b.findViewById(2131689760));
        if ((this.z == 35) && (this.y.getIsPay() == 1))
        {
          this.m.setVisibility(0);
          this.n = ((TextView)this.b.findViewById(2131689761));
          this.m.setOnClickListener(this);
          return;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            this.q.setText("预约时间");
            this.r.setText(m.TimeL2S(m.TimeS2L((String)localObject2, m.c), m.d));
            break;
          }
          if (TextUtils.isEmpty(paramc)) {
            break;
          }
          this.q.setText("预约时间");
          localObject1 = this.r;
          localObject2 = new StringBuilder().append(m.getFormatDate(m.strToDate(paramc, m.c), m.l)).append(" ");
          if (TextUtils.isEmpty(this.y.getTimeInterval()) == true) {}
          for (paramc = "";; paramc = this.y.getTimeInterval())
          {
            ((TextView)localObject1).setText(paramc);
            break;
          }
          label752:
          this.x.setVisibility(8);
          break label224;
          label764:
          this.j.setVisibility(8);
          break label405;
          label776:
          this.e.setVisibility(8);
          continue;
        }
        this.m.setVisibility(8);
        return;
      }
    }
    this.k.setVisibility(8);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131689760: 
    default: 
    case 2131694800: 
      do
      {
        return;
        paramView = this.y.getSPhone();
      } while (TextUtils.isEmpty(paramView));
      ah.callPhone(this.a, paramView);
      return;
    case 2131692617: 
      paramView = new Intent(this.a, InternalRepairPlanActivity.class);
      if ((this.z == 20) || (this.z == 25) || (this.z == 30)) {
        paramView.putExtra("isDetail", false);
      }
      for (;;)
      {
        paramView.putExtra("isReview", true);
        paramView.putExtra("mailBillId", this.y.getMainBillCode());
        startActivity(paramView);
        return;
        paramView.putExtra("isDetail", true);
      }
    }
    ((UrgencyRepairActivity)this.a).showCancelOrderDialog();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.b = View.inflate(getActivity(), 2130904112, null);
    c();
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/fragment/InternalRepairDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */