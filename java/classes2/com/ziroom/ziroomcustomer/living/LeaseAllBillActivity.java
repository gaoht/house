package com.ziroom.ziroomcustomer.living;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.e.c.b;
import com.ziroom.ziroomcustomer.activity.HouseBillPaySuccessActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.e.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import com.ziroom.ziroomcustomer.model.PayOrder;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LeaseAllBillActivity
  extends BaseActivity
{
  public static int a = 1;
  public static int b = 2;
  private String A = null;
  private int B = 0;
  private com.ziroom.commonlibrary.e.d C = new com.ziroom.commonlibrary.e.d();
  private String D;
  private PayOrder E;
  private String F;
  private String G;
  private String H;
  private String I;
  private String J;
  private a K;
  private BroadcastReceiver L = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      LeaseAllBillActivity.c(LeaseAllBillActivity.this);
    }
  };
  private BroadcastReceiver M = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      LeaseAllBillActivity.a(LeaseAllBillActivity.this, null);
    }
  };
  private BroadcastReceiver N = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (ae.isNull(LeaseAllBillActivity.a(LeaseAllBillActivity.this))) {
        return;
      }
      LeaseAllBillActivity.a(LeaseAllBillActivity.this, null);
      LeaseAllBillActivity.b(LeaseAllBillActivity.this);
    }
  };
  private Handler O = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      LeaseAllBillActivity.this.dismissProgress();
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4369: 
        if (locall.getSuccess().booleanValue())
        {
          LeaseAllBillActivity.a(LeaseAllBillActivity.this, (LeaseInfo)locall.getObject());
          if (("yqy".equals(LeaseAllBillActivity.d(LeaseAllBillActivity.this).getContractState())) || ("ysh".equals(LeaseAllBillActivity.d(LeaseAllBillActivity.this).getContractState())))
          {
            if (LeaseAllBillActivity.this.tv_lease_text != null) {
              LeaseAllBillActivity.this.tv_lease_text.setVisibility(0);
            }
            LeaseAllBillActivity.e(LeaseAllBillActivity.this);
            LeaseAllBillActivity.a(LeaseAllBillActivity.this, new com.ziroom.ziroomcustomer.adapter.g(LeaseAllBillActivity.this, LeaseAllBillActivity.d(LeaseAllBillActivity.this).getPayPlan(), LeaseAllBillActivity.d(LeaseAllBillActivity.this).getIsBlank(), LeaseAllBillActivity.d(LeaseAllBillActivity.this).getSysContractId(), LeaseAllBillActivity.f(LeaseAllBillActivity.this), LeaseAllBillActivity.g(LeaseAllBillActivity.this), b.d, LeaseAllBillActivity.d(LeaseAllBillActivity.this)));
            LeaseAllBillActivity.h(LeaseAllBillActivity.this);
            if (!ae.isNull(LeaseAllBillActivity.i(LeaseAllBillActivity.this))) {
              break label281;
            }
            if (LeaseAllBillActivity.this.lease_tab != null) {
              LeaseAllBillActivity.this.lease_tab.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          LeaseAllBillActivity.this.dismissProgress();
          return;
          if (LeaseAllBillActivity.this.tv_lease_text == null) {
            break;
          }
          LeaseAllBillActivity.this.tv_lease_text.setVisibility(8);
          break;
          label281:
          if (LeaseAllBillActivity.this.lease_tab != null)
          {
            LeaseAllBillActivity.this.lease_tab.setVisibility(8);
            continue;
            if (ae.isNull(LeaseAllBillActivity.i(LeaseAllBillActivity.this)))
            {
              LeaseAllBillActivity.j(LeaseAllBillActivity.this);
              if (LeaseAllBillActivity.this.lease_tab != null) {
                LeaseAllBillActivity.this.lease_tab.setVisibility(0);
              }
            }
            else if (LeaseAllBillActivity.this.lease_tab != null)
            {
              LeaseAllBillActivity.this.lease_tab.setVisibility(8);
            }
          }
        }
      }
      LeaseAllBillActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        LeaseAllBillActivity.b(LeaseAllBillActivity.this);
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(LeaseAllBillActivity.r(LeaseAllBillActivity.this), paramAnonymousMessage.getMessage(), 0);
    }
  };
  private View P;
  private int c = 0;
  private Context d;
  private Unbinder e;
  private LeaseInfo f;
  private com.ziroom.ziroomcustomer.adapter.g g;
  @BindView(2131696592)
  RelativeLayout lease_all_bill_relative;
  @BindView(2131696598)
  XListView lease_all_living_list;
  @BindView(2131696596)
  TextView lease_living_pay_btn;
  @BindView(2131696595)
  CheckBox lease_living_pay_cb;
  @BindView(2131696593)
  RelativeLayout lease_living_pay_layout;
  @BindView(2131696597)
  TextView lease_living_pay_money;
  @BindView(2131692829)
  LinearLayout lease_tab;
  @BindView(2131691914)
  ImageView mBack;
  @BindView(2131692830)
  RelativeLayout mHouseBillLayout;
  @BindView(2131692832)
  TextView mHouseBillLine;
  @BindView(2131692831)
  TextView mHouseBillText;
  @BindView(2131692838)
  XListView mLeaseAllBillList;
  @BindView(2131692833)
  RelativeLayout mLivingCostBillLayout;
  @BindView(2131692835)
  TextView mLivingCostBillLine;
  @BindView(2131692834)
  TextView mLivingCostBillText;
  private LivingCostBillAdapter r;
  private boolean s;
  private String t;
  @BindView(2131696580)
  TextView tv_lease_text;
  @BindView(2131689541)
  TextView tv_title;
  private int u = -1;
  private int v = 0;
  private PopupWindow w;
  private boolean x = true;
  private String y;
  private String z;
  
  private void a()
  {
    if (ae.isNull(this.F)) {
      this.F = "0";
    }
    b();
  }
  
  private void a(List<a> paramList)
  {
    if (this.r == null)
    {
      this.r = new LivingCostBillAdapter(paramList, this.d, this.z, this.s);
      this.lease_all_living_list.setAdapter(this.r);
    }
    for (;;)
    {
      this.lease_living_pay_money.setText("合计:¥0");
      this.r.setIsCheck(new LivingCostBillAdapter.a()
      {
        public void isCheck()
        {
          LeaseAllBillActivity.k(LeaseAllBillActivity.this);
        }
      });
      if (this.c == b)
      {
        this.mHouseBillText.setTextColor(Color.parseColor("#444444"));
        this.mHouseBillLine.setBackgroundColor(Color.parseColor("#ffffff"));
        this.mLivingCostBillText.setTextColor(Color.parseColor("#ffa000"));
        this.mLivingCostBillLine.setBackgroundColor(Color.parseColor("#ffa000"));
        this.lease_living_pay_layout.setVisibility(0);
      }
      return;
      this.r.getmList().remove(this.r.getmList().size() - 1);
      this.r.getmList().addAll(paramList);
      this.r.notifyDataSetChanged();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.r != null)
    {
      Iterator localIterator = this.r.getmList().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (ae.notNull(locala.getChildBillCode())) {
          locala.setCheck(paramBoolean);
        } else {
          locala.setCheck(false);
        }
      }
      this.r.notifyDataSetChanged();
      i();
    }
  }
  
  private void b()
  {
    this.y = (q.s + e.e.c);
    Map localMap = com.ziroom.ziroomcustomer.e.g.buildLeaseInfo(this.z, this.F);
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(this.y).params(ah.ConvertObjMap2String(localMap)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.d, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        if ("success".equals(paramAnonymouse.get("status")))
        {
          LeaseAllBillActivity.a(LeaseAllBillActivity.this, (LeaseInfo)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data").toString(), LeaseInfo.class));
          if (("yqy".equals(LeaseAllBillActivity.d(LeaseAllBillActivity.this).getContractState())) || ("ysh".equals(LeaseAllBillActivity.d(LeaseAllBillActivity.this).getContractState())))
          {
            if (LeaseAllBillActivity.this.tv_lease_text != null) {
              LeaseAllBillActivity.this.tv_lease_text.setVisibility(0);
            }
            LeaseAllBillActivity.e(LeaseAllBillActivity.this);
            LeaseAllBillActivity.a(LeaseAllBillActivity.this, new com.ziroom.ziroomcustomer.adapter.g(LeaseAllBillActivity.this, LeaseAllBillActivity.d(LeaseAllBillActivity.this).getPayPlan(), LeaseAllBillActivity.d(LeaseAllBillActivity.this).getIsBlank(), LeaseAllBillActivity.d(LeaseAllBillActivity.this).getSysContractId(), LeaseAllBillActivity.f(LeaseAllBillActivity.this), LeaseAllBillActivity.g(LeaseAllBillActivity.this), b.d, LeaseAllBillActivity.d(LeaseAllBillActivity.this)));
            LeaseAllBillActivity.h(LeaseAllBillActivity.this);
            if (!ae.isNull(LeaseAllBillActivity.i(LeaseAllBillActivity.this))) {
              break label247;
            }
            if (LeaseAllBillActivity.this.lease_tab != null) {
              LeaseAllBillActivity.this.lease_tab.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          dismissProgress();
          return;
          if (LeaseAllBillActivity.this.tv_lease_text == null) {
            break;
          }
          LeaseAllBillActivity.this.tv_lease_text.setVisibility(8);
          break;
          label247:
          if (LeaseAllBillActivity.this.lease_tab != null)
          {
            LeaseAllBillActivity.this.lease_tab.setVisibility(8);
            continue;
            if (ae.isNull(LeaseAllBillActivity.i(LeaseAllBillActivity.this)))
            {
              LeaseAllBillActivity.j(LeaseAllBillActivity.this);
              if (LeaseAllBillActivity.this.lease_tab != null) {
                LeaseAllBillActivity.this.lease_tab.setVisibility(0);
              }
            }
            else if (LeaseAllBillActivity.this.lease_tab != null)
            {
              LeaseAllBillActivity.this.lease_tab.setVisibility(8);
            }
          }
        }
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (a == paramInt)
    {
      this.c = a;
      this.mHouseBillText.setTextColor(Color.parseColor("#ffa000"));
      this.mHouseBillLine.setBackgroundColor(Color.parseColor("#ffa000"));
      this.mLivingCostBillText.setTextColor(Color.parseColor("#444444"));
      this.mLivingCostBillLine.setBackgroundColor(Color.parseColor("#ffffff"));
      this.lease_all_bill_relative.setVisibility(8);
      this.mLeaseAllBillList.setVisibility(0);
      e();
      this.lease_living_pay_layout.setVisibility(8);
    }
    while (b != paramInt) {
      return;
    }
    this.c = b;
    this.lease_all_bill_relative.setVisibility(0);
    this.mLeaseAllBillList.setVisibility(8);
    f();
  }
  
  private void e()
  {
    if ((this.g != null) && (this.c == a)) {
      this.mLeaseAllBillList.setAdapter(this.g);
    }
    for (;;)
    {
      this.mLeaseAllBillList.setPullRefreshEnable(false);
      this.mLeaseAllBillList.setPullLoadEnable(false);
      return;
      a();
    }
  }
  
  private void f()
  {
    if ((this.r != null) && (this.r.getmList().size() > 1))
    {
      this.lease_all_living_list.setAdapter(this.r);
      this.mHouseBillText.setTextColor(Color.parseColor("#444444"));
      this.mHouseBillLine.setBackgroundColor(Color.parseColor("#ffffff"));
      this.mLivingCostBillText.setTextColor(Color.parseColor("#ffa000"));
      this.mLivingCostBillLine.setBackgroundColor(Color.parseColor("#ffa000"));
      this.lease_living_pay_layout.setVisibility(0);
    }
    for (;;)
    {
      this.lease_all_living_list.setPullRefreshEnable(false);
      this.lease_all_living_list.setPullLoadEnable(false);
      this.lease_all_living_list.setXListViewListener(new XListView.a()
      {
        public void onLoadMore() {}
        
        public void onRefresh() {}
      });
      return;
      ArrayList localArrayList = new ArrayList();
      a locala = new a();
      locala.setEnd(true);
      localArrayList.add(locala);
      a(localArrayList);
      this.lease_all_living_list.setAdapter(this.r);
      this.mHouseBillText.setTextColor(Color.parseColor("#444444"));
      this.mHouseBillLine.setBackgroundColor(Color.parseColor("#ffffff"));
      this.mLivingCostBillText.setTextColor(Color.parseColor("#ffa000"));
      this.mLivingCostBillLine.setBackgroundColor(Color.parseColor("#ffa000"));
      this.lease_living_pay_layout.setVisibility(0);
      j();
    }
  }
  
  private void g()
  {
    this.H = getIntent().getStringExtra("NotPayHouse");
    this.G = getIntent().getStringExtra("notPayLiving");
    this.F = getIntent().getStringExtra("sysContractId");
    this.z = getIntent().getStringExtra("mContractCode");
    this.s = getIntent().getBooleanExtra("mInvalid", false);
  }
  
  private void h()
  {
    this.lease_all_living_list.stopRefresh();
    this.lease_all_living_list.stopLoadMore();
    this.lease_all_living_list.setRefreshTime("刚刚");
  }
  
  private void i()
  {
    this.B = 0;
    this.A = "";
    Iterator localIterator = this.r.getmList().iterator();
    boolean bool = true;
    a locala;
    if (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if (locala.isCheck())
      {
        this.B += locala.getShouldPayAmount();
        if (ae.notNull(locala.getSystemId())) {
          this.J = locala.getSystemId();
        }
        if (ae.isNull(this.A)) {
          this.A = (locala.getChildBillCode() + "");
        }
      }
    }
    for (;;)
    {
      break;
      this.A = (this.A + "," + locala.getChildBillCode());
      continue;
      if (ae.notNull(locala.getChildBillCode()))
      {
        bool = false;
        continue;
        this.lease_living_pay_cb.setChecked(bool);
        if (this.B > 0)
        {
          this.lease_living_pay_btn.setEnabled(true);
          this.lease_living_pay_btn.setBackgroundColor(Color.parseColor("#ffa000"));
        }
        for (;;)
        {
          this.lease_living_pay_money.setText("合计:¥" + ah.changeF2Y(new StringBuilder().append(this.B).append("").toString()));
          return;
          this.lease_living_pay_btn.setEnabled(false);
          this.lease_living_pay_btn.setBackgroundColor(Color.parseColor("#bebebe"));
        }
      }
    }
  }
  
  private void j()
  {
    this.t = (q.G + e.e.l);
    Map localMap = com.ziroom.ziroomcustomer.e.g.buildBillChildGroupMeter(this.z, 0, this.u, this.v);
    j.getReservationOrderText(this.d, new b(), localMap, true, this.t);
  }
  
  private void k()
  {
    int m = 0;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = -1;
    int k;
    while (j < this.f.getPayPlan().size())
    {
      LeasePayPlan localLeasePayPlan = (LeasePayPlan)this.f.getPayPlan().get(j);
      k = i;
      if (i == -1)
      {
        k = i;
        if (localLeasePayPlan.getCanPayRent() == 1) {
          k = j;
        }
      }
      i = k;
      if (k == -1)
      {
        i = k;
        if ("1".equals(localLeasePayPlan.getHasWyj()))
        {
          i = k;
          if (localLeasePayPlan.getContractWyjPayInfo() != null)
          {
            i = k;
            if ("wfk".equals(localLeasePayPlan.getContractWyjPayInfo().getStatus())) {
              i = j;
            }
          }
        }
      }
      j += 1;
    }
    if (i != -1)
    {
      j = i;
      for (;;)
      {
        k = m;
        if (j >= this.f.getPayPlan().size()) {
          break;
        }
        localArrayList.add(this.f.getPayPlan().get(j));
        j += 1;
      }
      while (k < i)
      {
        localArrayList.add(this.f.getPayPlan().get(k));
        k += 1;
      }
      this.f.setPayPlan(localArrayList);
    }
  }
  
  private void l()
  {
    startActivity(new Intent(this.d, HouseBillPaySuccessActivity.class));
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 3) {
      b();
    }
    if (paramInt2 == 66) {
      a();
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == 88)
        {
          this.u = -1;
          j();
          return;
        }
        if (paramInt2 != 98) {
          break;
        }
      } while ((this.D == null) || (!this.D.equals("jd_m_pay")));
      showProgress("");
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (LeaseAllBillActivity.p(LeaseAllBillActivity.this) == null) {
            SystemClock.sleep(2000L);
          }
          Handler localHandler = LeaseAllBillActivity.q(LeaseAllBillActivity.this);
          if (LeaseAllBillActivity.p(LeaseAllBillActivity.this) == null) {}
          for (String str = "";; str = LeaseAllBillActivity.p(LeaseAllBillActivity.this).getStand_num())
          {
            com.ziroom.ziroomcustomer.e.d.getWYPayState(localHandler, str);
            return;
          }
        }
      }, 5000L);
      return;
      if (paramInt2 != 17) {
        break;
      }
      j();
    } while (!ae.notNull(paramIntent.getStringExtra("message")));
    showToast(paramIntent.getStringExtra("message"));
    return;
    com.ziroom.commonlibrary.e.c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new c.b()
    {
      public void doBack(String paramAnonymousString)
      {
        if ("success".equals(paramAnonymousString)) {
          LeaseAllBillActivity.b(LeaseAllBillActivity.this);
        }
      }
    });
  }
  
  @OnClick({2131692830, 2131692833, 2131691914, 2131696596, 2131696580, 2131696594})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692830: 
      b(a);
      return;
    case 2131692833: 
      b(b);
      return;
    case 2131691914: 
      finish();
      return;
    case 2131696596: 
      this.I = "shfy";
      String str = this.A.toString();
      paramView = str;
      if (ae.notNull(str)) {
        paramView = str.replace("[", "").replace("]", "").replace(" ", "");
      }
      com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, this.B, this.I, paramView, this.J);
      com.ziroom.ziroomcustomer.e.g.buildGetBillInfo(this.z, this.A);
      return;
    case 2131696580: 
      paramView = new Intent(this.d, MyStewardInfoActivity.class);
      paramView.putExtra("contractCode", this.z);
      startActivity(paramView);
      return;
    }
    boolean bool2 = this.lease_living_pay_cb.isChecked();
    paramView = this.lease_living_pay_cb;
    if (!this.lease_living_pay_cb.isChecked()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramView.setChecked(bool1);
      if (!bool2) {
        break;
      }
      a(false);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904827);
    this.e = ButterKnife.bind(this);
    this.d = this;
    g();
    if (ae.notNull(this.G))
    {
      this.lease_tab.setVisibility(8);
      b(b);
      this.tv_title.setText("生活费用账单");
    }
    for (;;)
    {
      this.C.initWXAPI(this);
      registerReceiver(this.N, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
      registerReceiver(this.M, new IntentFilter("com.ziroom.ziroomcustomer.activity_2"));
      this.K = new a();
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.ziroom.ziroomcustomer.payresult");
      registerReceiver(this.K, paramBundle);
      registerReceiver(this.L, new IntentFilter("com.ziroom.ziroomcustomer.easily_pay"));
      this.lease_living_pay_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
          if (paramAnonymousBoolean) {
            LeaseAllBillActivity.a(LeaseAllBillActivity.this, paramAnonymousBoolean);
          }
        }
      });
      return;
      if (ae.notNull(this.H))
      {
        this.lease_tab.setVisibility(8);
        b(a);
        this.tv_title.setText("房租账单");
      }
      else
      {
        b(a);
        this.lease_tab.setVisibility(0);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.e.unbind();
    unregisterReceiver(this.N);
    unregisterReceiver(this.M);
    unregisterReceiver(this.K);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if ((this.w != null) && (this.w.isShowing()))
    {
      this.w.dismiss();
      this.x = true;
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    a();
  }
  
  public void onUPPay(PayOrder paramPayOrder)
  {
    if (paramPayOrder == null)
    {
      showToast("获取订单号失败！");
      return;
    }
    if (ae.isNull(paramPayOrder.getTrans_id()))
    {
      showToast("流水号为空");
      return;
    }
    com.ziroom.commonlibrary.e.c.doStartUnionPayPlugin(this, paramPayOrder.getTrans_id());
    MobclickAgent.onEvent(this, "5ZY_zhifubank");
  }
  
  public void showEmptyView(String paramString1, String paramString2)
  {
    if (this.lease_all_bill_relative == null) {}
    TextView localTextView2;
    do
    {
      return;
      this.P = showLivingEmptyView(this.lease_all_bill_relative, paramString1);
      TextView localTextView1 = (TextView)this.P.findViewById(2131690822);
      localTextView2 = (TextView)this.P.findViewById(2131696746);
      localTextView2.getPaint().setFlags(8);
      LinearLayout localLinearLayout = (LinearLayout)this.P.findViewById(2131696744);
      localTextView1.setText(paramString1);
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(LeaseAllBillActivity.r(LeaseAllBillActivity.this), LeaseHistoryLivingActivity.class);
          paramAnonymousView.putExtra("ContractCode", LeaseAllBillActivity.f(LeaseAllBillActivity.this));
          LeaseAllBillActivity.r(LeaseAllBillActivity.this).startActivity(paramAnonymousView);
        }
      });
      localLinearLayout.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LeaseAllBillActivity.j(LeaseAllBillActivity.this);
        }
      });
    } while (!"100047".equals(paramString2));
    localTextView2.setVisibility(8);
  }
  
  public View showLivingEmptyView(ViewGroup paramViewGroup, String paramString)
  {
    if (paramViewGroup == null) {
      return null;
    }
    paramString = paramViewGroup.findViewById(2131694408);
    if (paramString != null) {
      paramViewGroup.removeView(paramString);
    }
    paramString = LayoutInflater.from(this);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramViewGroup.getChildAt(i).setVisibility(8);
      i += 1;
    }
    return paramString.inflate(2130904855, paramViewGroup, true);
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getIntExtra("code", -1) == 1)
      {
        if (!"shfy".equals(LeaseAllBillActivity.a(LeaseAllBillActivity.this))) {
          return;
        }
        LeaseAllBillActivity.a(LeaseAllBillActivity.this, null);
        LeaseAllBillActivity.b(LeaseAllBillActivity.this);
        return;
      }
      LeaseAllBillActivity.a(LeaseAllBillActivity.this, null);
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      int i = ((Integer)paramString.get("error_code")).intValue();
      if (i == 0)
      {
        paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), a.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setCode(i + "");
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      Object localObject;
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (List)paramk.getObject();
        if (paramk != null)
        {
          if (paramk.size() < 1) {
            break label229;
          }
          if (LeaseAllBillActivity.l(LeaseAllBillActivity.this) == -1)
          {
            ((a)paramk.get(0)).setStart(true);
            localObject = new a();
            ((a)localObject).setEnd(true);
            paramk.add(localObject);
            LeaseAllBillActivity.a(LeaseAllBillActivity.this, null);
            LeaseAllBillActivity.a(LeaseAllBillActivity.this, paramk);
            LeaseAllBillActivity.this.closeEmpty(LeaseAllBillActivity.this.lease_all_bill_relative);
            LeaseAllBillActivity.this.lease_living_pay_cb.setChecked(true);
            LeaseAllBillActivity.a(LeaseAllBillActivity.this, LeaseAllBillActivity.this.lease_living_pay_cb.isChecked());
          }
        }
        else
        {
          label137:
          LeaseAllBillActivity.o(LeaseAllBillActivity.this);
        }
      }
      label229:
      do
      {
        return;
        LeaseAllBillActivity.m(LeaseAllBillActivity.this).getmList().remove(LeaseAllBillActivity.m(LeaseAllBillActivity.this).getmList().size() - 1);
        localObject = new a();
        ((a)localObject).setEnd(true);
        paramk.add(localObject);
        LeaseAllBillActivity.m(LeaseAllBillActivity.this).getmList().addAll(paramk);
        LeaseAllBillActivity.m(LeaseAllBillActivity.this).notifyDataSetChanged();
        break;
        if ((LeaseAllBillActivity.l(LeaseAllBillActivity.this) != -1) || (LeaseAllBillActivity.n(LeaseAllBillActivity.this) != LeaseAllBillActivity.b)) {
          break label137;
        }
        LeaseAllBillActivity.this.showEmptyView("您暂时还没有生活费用账单", "");
        break label137;
        localObject = paramk.getMessage();
        paramk = paramk.getCode();
        LeaseAllBillActivity.this.showToast((String)localObject + "");
      } while ((LeaseAllBillActivity.l(LeaseAllBillActivity.this) != -1) || (LeaseAllBillActivity.n(LeaseAllBillActivity.this) != LeaseAllBillActivity.b));
      LeaseAllBillActivity.this.showEmptyView((String)localObject + "", paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseAllBillActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */