package com.ziroom.ziroomcustomer.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.activity.LeasePayDetailActivity;
import com.ziroom.ziroomcustomer.activity.LeasePenaltyHistoryActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.a.b;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.living.LeaseAllBillActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import com.ziroom.ziroomcustomer.payment.activity.UnionDKPayNoticeActivity;
import com.ziroom.ziroomcustomer.repay.RepayInfoActivity;
import com.ziroom.ziroomcustomer.signed.EasilyPayLoanInfoActivity;
import com.ziroom.ziroomcustomer.signed.LoanInfoActivity;
import com.ziroom.ziroomcustomer.signed.SignedJDPayWebActivity;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.Iterator;
import java.util.List;

public class g
  extends BaseAdapter
{
  private Context a;
  private List<LeasePayPlan> b;
  private int c = 0;
  private int d = 0;
  private String e;
  private String f;
  private String g;
  private boolean h = false;
  private String i;
  private LeaseInfo j;
  private a k;
  
  public g(Context paramContext, List<LeasePayPlan> paramList, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, LeaseInfo paramLeaseInfo)
  {
    this.f = paramString2;
    this.g = paramString3;
    this.a = paramContext;
    this.b = paramList;
    this.e = paramString1;
    this.h = paramBoolean;
    this.i = paramString4;
    this.j = paramLeaseInfo;
    d.e("lease", paramList.toString());
    paramContext = getFirstPayPeriod(paramList);
    if (paramContext != null) {
      this.c = paramContext.getPeriods().intValue();
    }
    paramContext = getWyjPayPeriod(paramList);
    if (paramContext != null) {
      this.d = paramContext.getPeriods().intValue();
    }
  }
  
  private void a(final LeasePayPlan paramLeasePayPlan)
  {
    if ((this.j.getIsZWhite() == 1) && (paramLeasePayPlan.getPeriods().intValue() == 1)) {
      j.checkContractHasPay(this.a, this.j.getContractCode(), new com.ziroom.commonlibrary.a.a(this.a, new k(new b()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          com.freelxl.baselibrary.f.g.textToast(this.b, "获取支付状态失败！");
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("hasPay")))
          {
            if (!paramAnonymouse.getBoolean("hasPay").booleanValue())
            {
              paramAnonymouse = ApplicationEx.c.getUser();
              if ((ApplicationEx.c.isLoginState()) && (paramAnonymouse != null))
              {
                paramAnonymouse = new Intent(this.b, LoanInfoActivity.class);
                paramAnonymouse.putExtra("detail", new HouseDetail(g.a(g.this).getHouseType(), g.a(g.this).getHouseCode(), g.a(g.this).getHouseId()));
                paramAnonymouse.putExtra("contract_code", paramLeasePayPlan.getContractCode());
                paramAnonymouse.putExtra("is_back_pre", true);
                if ("1".equals(g.a(g.this).getIsRenew())) {
                  paramAnonymouse.putExtra("old_contract_code", "old_contract_code");
                }
                if ((this.b instanceof Activity)) {
                  this.b.startActivity(paramAnonymouse);
                }
              }
            }
            do
            {
              return;
              if (2 == paramLeasePayPlan.getCanPayRent())
              {
                com.freelxl.baselibrary.f.g.textToast(this.b, "上期产生的违约金您还未缴清！", 0);
                return;
              }
              if (paramLeasePayPlan.getPayType() == 0)
              {
                paramAnonymouse = new Intent(this.b, HouseBillInfoActivity.class);
                paramAnonymouse.putExtra("uniqueCode", g.a(g.this).getContractCode());
                paramAnonymouse.putExtra("period", paramLeasePayPlan.getPeriods() + "");
                paramAnonymouse.putExtra("payType", "fz");
                String str = g.a(g.this).getPropertyState();
                if ((str != null) && ("yqr".equals(str))) {
                  paramAnonymouse.putExtra("wystate", "wystate");
                }
                if ("1".equals(g.a(g.this).getIsRenew())) {
                  paramAnonymouse.putExtra("old_contract_code", "old_contract_code");
                }
                ((LeaseAllBillActivity)this.b).startActivityForResult(paramAnonymouse, 66);
                return;
              }
              if (paramLeasePayPlan.getPayType() == 3)
              {
                paramAnonymouse = new Intent(this.b, EasilyPayLoanInfoActivity.class);
                paramAnonymouse.putExtra("mContractCode", g.a(g.this).getContractCode());
                paramAnonymouse.putExtra("isBack", true);
                ((LeaseAllBillActivity)this.b).startActivityForResult(paramAnonymouse, 66);
                return;
              }
            } while (paramLeasePayPlan.getPayType() != 2);
            paramAnonymouse = new Intent(this.b, RepayInfoActivity.class);
            paramAnonymouse.putExtra("contractCode", g.a(g.this).getContractCode());
            this.b.startActivity(paramAnonymouse);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(this.b, "获取支付状态失败！");
        }
      });
    }
    do
    {
      return;
      if (2 == paramLeasePayPlan.getCanPayRent())
      {
        com.freelxl.baselibrary.f.g.textToast(this.a, "上期产生的违约金您还未缴清！", 0);
        return;
      }
      if (paramLeasePayPlan.getPayType() == 0)
      {
        Intent localIntent = new Intent(this.a, HouseBillInfoActivity.class);
        localIntent.putExtra("uniqueCode", this.j.getContractCode());
        localIntent.putExtra("period", paramLeasePayPlan.getPeriods() + "");
        localIntent.putExtra("payType", "fz");
        paramLeasePayPlan = this.j.getPropertyState();
        if ((paramLeasePayPlan != null) && ("yqr".equals(paramLeasePayPlan))) {
          localIntent.putExtra("wystate", "wystate");
        }
        if ("1".equals(this.j.getIsRenew())) {
          localIntent.putExtra("old_contract_code", "old_contract_code");
        }
        ((LeaseAllBillActivity)this.a).startActivityForResult(localIntent, 66);
        return;
      }
      if (paramLeasePayPlan.getPayType() == 3)
      {
        paramLeasePayPlan = new Intent(this.a, EasilyPayLoanInfoActivity.class);
        paramLeasePayPlan.putExtra("mContractCode", this.j.getContractCode());
        paramLeasePayPlan.putExtra("isBack", true);
        ((LeaseAllBillActivity)this.a).startActivityForResult(paramLeasePayPlan, 66);
        return;
      }
    } while (paramLeasePayPlan.getPayType() != 2);
    paramLeasePayPlan = new Intent(this.a, RepayInfoActivity.class);
    paramLeasePayPlan.putExtra("contractCode", this.j.getContractCode());
    this.a.startActivity(paramLeasePayPlan);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public LeasePayPlan getFirstPayPeriod(List<LeasePayPlan> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (0 == 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LeasePayPlan localLeasePayPlan = (LeasePayPlan)paramList.next();
        if (localLeasePayPlan.getCanPayRent() == 1) {
          return localLeasePayPlan;
        }
      }
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904268, null);
      this.k = new a(null);
      this.k.a = ((TextView)paramView.findViewById(2131695139));
      this.k.r = ((TextView)paramView.findViewById(2131695152));
      this.k.b = ((TextView)paramView.findViewById(2131695143));
      this.k.d = ((TextView)paramView.findViewById(2131695145));
      this.k.e = ((TextView)paramView.findViewById(2131695148));
      this.k.f = ((TextView)paramView.findViewById(2131695140));
      this.k.h = ((Button)paramView.findViewById(2131690461));
      this.k.i = ((LinearLayout)paramView.findViewById(2131695150));
      this.k.j = ((TextView)paramView.findViewById(2131695156));
      this.k.k = ((TextView)paramView.findViewById(2131695155));
      this.k.l = ((TextView)paramView.findViewById(2131695161));
      this.k.m = ((Button)paramView.findViewById(2131695158));
      this.k.n = ((LinearLayout)paramView.findViewById(2131695133));
      this.k.g = ((TextView)paramView.findViewById(2131695135));
      this.k.p = ((TextView)paramView.findViewById(2131695153));
      this.k.q = ((TextView)paramView.findViewById(2131695149));
      this.k.o = ((LinearLayout)paramView.findViewById(2131695138));
      this.k.t = ((TextView)paramView.findViewById(2131695137));
      this.k.s = ((LinearLayout)paramView.findViewById(2131695136));
      this.k.u = paramView.findViewById(2131695132);
      this.k.v = ((TextView)paramView.findViewById(2131695147));
      this.k.w = ((TextView)paramView.findViewById(2131695160));
      this.k.c = ((TextView)paramView.findViewById(2131695134));
      paramView.setTag(this.k);
      if (this.h)
      {
        this.k.h.setEnabled(false);
        this.k.h.setVisibility(8);
        this.k.m.setEnabled(false);
        this.k.g.setEnabled(false);
        this.k.o.setEnabled(false);
        this.k.i.setEnabled(false);
        this.k.n.setVisibility(8);
        this.k.q.setVisibility(8);
        ((LeasePayPlan)this.b.get(paramInt)).setPayIsVisibility(false);
        ((LeasePayPlan)this.b.get(paramInt)).setPayWyjIsVisibility(false);
      }
      if (paramInt != 0) {
        break label1567;
      }
      if (this.j.getIsBindContract() != 0) {
        break label1503;
      }
      this.k.t.setText("去开启");
      this.k.s.setVisibility(0);
      label598:
      this.k.u.setVisibility(0);
      label609:
      this.k.s.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          boolean bool2 = false;
          VdsAgent.onClick(this, paramAnonymousView);
          if (g.a(g.this) != null)
          {
            paramAnonymousView = new Intent();
            if (g.a(g.this).getIsBindUid() != 1) {
              break label122;
            }
          }
          label122:
          for (boolean bool1 = true;; bool1 = false)
          {
            paramAnonymousView.putExtra("isBandUnionCard", bool1);
            bool1 = bool2;
            if (g.a(g.this).getIsBindContract() == 1) {
              bool1 = true;
            }
            paramAnonymousView.putExtra("isBandUnionDKContract", bool1);
            paramAnonymousView.putExtra("contractCode", g.a(g.this).getContractCode());
            paramAnonymousView.setClass(g.b(g.this), UnionDKPayNoticeActivity.class);
            ((BaseActivity)g.b(g.this)).startActivityForResult(paramAnonymousView, 1);
            return;
          }
        }
      });
      paramViewGroup = (LeasePayPlan)this.b.get(paramInt);
      if ((!"1".equals(this.j.getIsBlank())) && (!"1".equals(Integer.valueOf(this.j.getIsZWhite())))) {
        break label1594;
      }
      this.k.a.setText("贷款分期 房租账单");
      label687:
      this.k.r.setText("第" + paramViewGroup.getPeriods() + "期");
      this.k.b.setText(paramViewGroup.getReceivableCycle());
      this.k.d.setText(paramViewGroup.getReceivableDate());
      if (1 != this.j.getIsZWhite()) {
        break label1636;
      }
      if (("yfk".equals(paramViewGroup.getStatus())) && (!this.h)) {
        this.k.n.setVisibility(0);
      }
      this.k.q.setVisibility(8);
      this.k.s.setVisibility(8);
      label820:
      if (!paramViewGroup.getStatus().equals("qk")) {
        break label1713;
      }
      double d1 = Double.parseDouble(paramViewGroup.getFee());
      double d2 = Double.parseDouble(paramViewGroup.getPayFee());
      this.k.e.setText(ah.Number2(d1 - d2) + "");
      this.k.v.setText("需缴费用:");
      label900:
      setPayStatus(this.k.f, paramViewGroup);
      if (1 != paramViewGroup.getCanPayRent()) {
        break label1834;
      }
      if (paramViewGroup.getStatus().equals("qk"))
      {
        this.k.h.setText("支付详情");
        this.k.h.setBackgroundResource(2130837686);
        this.k.h.setTextColor(Color.parseColor("#999999"));
        this.k.h.setVisibility(0);
      }
      if ((this.h) || (paramViewGroup.getPeriods().intValue() != this.c)) {
        break label1802;
      }
      if ((paramViewGroup.getPayType() != 3) || (Float.parseFloat(this.k.e.getText().toString()) != 0.0F)) {
        break label1786;
      }
      this.k.h.setText("确认贷款");
      label1051:
      this.k.h.setBackgroundResource(2130837687);
      this.k.h.setTextColor(Color.parseColor("#ffa000"));
      this.k.h.setVisibility(0);
      ((LeasePayPlan)this.b.get(paramInt)).setPayIsVisibility(true);
      label1108:
      this.k.o.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramViewGroup.isPayIsVisibility()) {
            g.a(g.this, paramViewGroup);
          }
          while (paramViewGroup.getStatus().equals("wfk")) {
            return;
          }
          paramAnonymousView = new Intent(g.b(g.this), LeasePayDetailActivity.class);
          paramAnonymousView.putExtra("LeasePayPlan", paramViewGroup);
          paramAnonymousView.putExtra("contractCode", g.c(g.this));
          paramAnonymousView.putExtra("sysContractId", g.d(g.this));
          g.b(g.this).startActivity(paramAnonymousView);
        }
      });
      this.k.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("支付详情".equals(((TextView)paramAnonymousView).getText()))
          {
            paramAnonymousView = new Intent(g.b(g.this), LeasePayDetailActivity.class);
            paramAnonymousView.putExtra("LeasePayPlan", paramViewGroup);
            paramAnonymousView.putExtra("contractCode", g.c(g.this));
            paramAnonymousView.putExtra("sysContractId", g.d(g.this));
            g.b(g.this).startActivity(paramAnonymousView);
            return;
          }
          g.a(g.this, paramViewGroup);
        }
      });
      if (!"1".equals(paramViewGroup.getHasWyj())) {
        break label2133;
      }
      this.k.i.setVisibility(0);
      this.k.j.setText("请在全额支付第" + paramViewGroup.getPeriods() + "期房租账单后及时支付逾期违约金");
      this.k.k.setText(paramViewGroup.getContractWyjPayInfo().getPenaltyNum() + "");
      this.k.l.setText(paramViewGroup.getContractWyjPayInfo().getReceivableMoney() + "元");
      if ((!"wfk".equals(paramViewGroup.getContractWyjPayInfo().getStatus())) || (this.h)) {
        break label2034;
      }
      if (this.d != paramViewGroup.getPeriods().intValue()) {
        break label1935;
      }
      this.k.p.setText("待支付");
      this.k.m.setText("去支付");
      this.k.m.setBackgroundResource(2130837688);
      this.k.m.setTextColor(Color.parseColor("#ff6262"));
      this.k.m.setVisibility(0);
      ((LeasePayPlan)this.b.get(paramInt)).setPayWyjIsVisibility(true);
      this.k.w.setText("逾期违约金:");
      label1412:
      this.k.i.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramViewGroup.isPayWyjIsVisibility()) {
            if (paramViewGroup.getContractWyjPayInfo().getCanPayPenalty() == 1)
            {
              paramAnonymousView = new Intent(g.b(g.this), HouseBillInfoActivity.class);
              paramAnonymousView.putExtra("uniqueCode", g.a(g.this).getContractCode());
              paramAnonymousView.putExtra("period", paramViewGroup.getPeriods() + "");
              paramAnonymousView.putExtra("payType", "wyj");
              ((LeaseAllBillActivity)g.b(g.this)).startActivityForResult(paramAnonymousView, 66);
            }
          }
          while ("wfk".equals(paramViewGroup.getContractWyjPayInfo().getStatus()))
          {
            do
            {
              return;
            } while (paramViewGroup.getContractWyjPayInfo().getCanPayPenalty() != 2);
            com.freelxl.baselibrary.f.g.textToast(g.b(g.this), "支付完房租才能支付违约金!", 0);
            return;
          }
          paramAnonymousView = new Intent(g.b(g.this), LeasePenaltyHistoryActivity.class);
          paramAnonymousView.putExtra("lease", g.a(g.this));
          paramAnonymousView.putExtra("LeasePayPlan", paramViewGroup);
          paramAnonymousView.putExtra("contractCode", g.c(g.this));
          paramAnonymousView.putExtra("sysContractId", g.d(g.this));
          g.b(g.this).startActivity(paramAnonymousView);
        }
      });
      this.k.m.setEnabled(true);
      this.k.m.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("支付详情".equals(((Button)paramAnonymousView).getText() + ""))
          {
            paramAnonymousView = new Intent(g.b(g.this), LeasePenaltyHistoryActivity.class);
            paramAnonymousView.putExtra("lease", g.a(g.this));
            paramAnonymousView.putExtra("LeasePayPlan", paramViewGroup);
            paramAnonymousView.putExtra("contractCode", g.c(g.this));
            paramAnonymousView.putExtra("sysContractId", g.d(g.this));
            g.b(g.this).startActivity(paramAnonymousView);
          }
          do
          {
            return;
            if (paramViewGroup.getContractWyjPayInfo().getCanPayPenalty() == 1)
            {
              paramAnonymousView = new Intent(g.b(g.this), HouseBillInfoActivity.class);
              paramAnonymousView.putExtra("uniqueCode", g.a(g.this).getContractCode());
              paramAnonymousView.putExtra("period", paramViewGroup.getPeriods() + "");
              paramAnonymousView.putExtra("payType", "wyj");
              ((LeaseAllBillActivity)g.b(g.this)).startActivityForResult(paramAnonymousView, 66);
              return;
            }
          } while (paramViewGroup.getContractWyjPayInfo().getCanPayPenalty() != 2);
          com.freelxl.baselibrary.f.g.textToast(g.b(g.this), "支付完房租才能支付违约金!", 0);
        }
      });
    }
    for (;;)
    {
      this.k.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          switch (paramAnonymousView.getId())
          {
          default: 
            return;
          }
          if (g.a(g.this).getIsZWhite() == 1)
          {
            paramAnonymousView = new Intent(g.b(g.this), RepayInfoActivity.class);
            paramAnonymousView.putExtra("contractCode", g.a(g.this).getContractCode());
            g.b(g.this).startActivity(paramAnonymousView);
            return;
          }
          paramAnonymousView = new Intent(g.b(g.this), SignedJDPayWebActivity.class);
          paramAnonymousView.putExtra("url", "Http://sq.jd.com/I96d5m");
          paramAnonymousView.putExtra("title", "白条还款");
          g.b(g.this).startActivity(paramAnonymousView);
        }
      });
      paramViewGroup.setContractCode(this.g);
      return paramView;
      this.k = ((a)paramView.getTag());
      break;
      label1503:
      if (this.j.getIsBindContract() == 1)
      {
        this.k.t.setText("已开启");
        this.k.s.setVisibility(0);
        break label598;
      }
      if (this.j.getIsBindContract() != 2) {
        break label598;
      }
      this.k.s.setVisibility(8);
      break label598;
      label1567:
      this.k.u.setVisibility(8);
      this.k.s.setVisibility(8);
      break label609;
      label1594:
      this.k.a.setText("第" + paramViewGroup.getPeriods() + "期 房租账单");
      break label687;
      label1636:
      if ("1".equals(this.e))
      {
        this.k.n.setVisibility(0);
        this.k.q.setVisibility(8);
        this.k.s.setVisibility(8);
        break label820;
      }
      this.k.n.setVisibility(8);
      this.k.q.setVisibility(8);
      break label820;
      label1713:
      if (paramViewGroup.getStatus().equals("yfk"))
      {
        this.k.e.setText(paramViewGroup.getPayFee());
        this.k.v.setText("账单金额:");
        break label900;
      }
      this.k.v.setText("需缴费用:");
      this.k.e.setText(paramViewGroup.getFee());
      break label900;
      label1786:
      this.k.h.setText("去支付");
      break label1051;
      label1802:
      this.k.h.setVisibility(8);
      ((LeasePayPlan)this.b.get(paramInt)).setPayIsVisibility(false);
      break label1108;
      label1834:
      if ("yfk".equals(paramViewGroup.getStatus()))
      {
        this.k.h.setText("支付详情");
        this.k.h.setVisibility(0);
        this.k.h.setBackgroundResource(2130837686);
        this.k.h.setTextColor(Color.parseColor("#999999"));
        ((LeasePayPlan)this.b.get(paramInt)).setPayIsVisibility(false);
        break label1108;
      }
      this.k.h.setVisibility(8);
      break label1108;
      label1935:
      this.k.m.setVisibility(0);
      ((LeasePayPlan)this.b.get(paramInt)).setPayWyjIsVisibility(false);
      this.k.m.setText("支付详情");
      this.k.p.setText("支付成功");
      this.k.m.setBackgroundResource(2130837686);
      this.k.m.setTextColor(Color.parseColor("#999999"));
      this.k.w.setText("账单金额:");
      break label1412;
      label2034:
      this.k.m.setVisibility(0);
      ((LeasePayPlan)this.b.get(paramInt)).setPayWyjIsVisibility(false);
      this.k.m.setText("支付详情");
      this.k.p.setText("支付成功");
      this.k.m.setBackgroundResource(2130837686);
      this.k.m.setTextColor(Color.parseColor("#999999"));
      this.k.w.setText("逾期违约金:");
      break label1412;
      label2133:
      this.k.i.setVisibility(8);
    }
  }
  
  public LeasePayPlan getWyjPayPeriod(List<LeasePayPlan> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LeasePayPlan localLeasePayPlan = (LeasePayPlan)paramList.next();
        if ((localLeasePayPlan.getContractWyjPayInfo() != null) && ("wfk".equals(localLeasePayPlan.getContractWyjPayInfo().getStatus()))) {
          return localLeasePayPlan;
        }
      }
    }
    return null;
  }
  
  public void setPayStatus(TextView paramTextView, LeasePayPlan paramLeasePayPlan)
  {
    if (paramLeasePayPlan.getStatus().equals("yfk"))
    {
      paramTextView.setText("支付成功");
      return;
    }
    if (paramLeasePayPlan.getStatus().equals("wfk"))
    {
      paramTextView.setText("待支付");
      return;
    }
    if (paramLeasePayPlan.getStatus().equals("qk"))
    {
      paramTextView.setText("部分支付");
      return;
    }
    paramTextView.setText("");
  }
  
  private class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    Button h;
    LinearLayout i;
    TextView j;
    TextView k;
    TextView l;
    Button m;
    LinearLayout n;
    LinearLayout o;
    TextView p;
    TextView q;
    TextView r;
    LinearLayout s;
    TextView t;
    View u;
    TextView v;
    TextView w;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */