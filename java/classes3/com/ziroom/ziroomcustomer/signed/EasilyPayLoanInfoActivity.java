package com.ziroom.ziroomcustomer.signed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.signed.a.g;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.Timer;
import java.util.TimerTask;

public class EasilyPayLoanInfoActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  @BindView(2131690511)
  ImageView back_iv;
  private g c;
  private a d;
  private String e;
  @BindView(2131690517)
  TextView easily_btn;
  private boolean f;
  private final Timer g = new Timer();
  @BindView(2131690518)
  TextView loan_cancle;
  @BindView(2131690521)
  TextView loan_first_payment;
  @BindView(2131690520)
  TextView loan_hint;
  @BindView(2131690526)
  TextView loan_interest;
  @BindView(2131690523)
  TextView loan_loan_periods;
  @BindView(2131690525)
  TextView loan_principal;
  @BindView(2131690522)
  TextView loan_principal_sum;
  @BindView(2131690524)
  TextView loan_should_pay;
  @BindView(2131690519)
  TextView loan_title;
  @BindView(2131690528)
  TextView loan_to_pay_money;
  @BindView(2131690527)
  RelativeLayout loan_to_pay_money_rl;
  private TimerTask r = new TimerTask()
  {
    public void run()
    {
      EasilyPayLoanInfoActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          EasilyPayLoanInfoActivity.f(EasilyPayLoanInfoActivity.this);
        }
      });
    }
  };
  
  private void a()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((localUserInfo != null) && (ApplicationEx.c.isLoginState()))
    {
      j.getLoanstatus(this, localUserInfo.getUid(), this.e, new com.ziroom.commonlibrary.a.a(this, new c())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ("0".equals(paramAnonymouse.get("code") + ""))
          {
            EasilyPayLoanInfoActivity.a(EasilyPayLoanInfoActivity.this, (g)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data").toString(), g.class));
            EasilyPayLoanInfoActivity.b(EasilyPayLoanInfoActivity.this, EasilyPayLoanInfoActivity.a(EasilyPayLoanInfoActivity.this));
          }
          for (;;)
          {
            dismissProgress();
            return;
            EasilyPayLoanInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
            if (EasilyPayLoanInfoActivity.b(EasilyPayLoanInfoActivity.this) != null) {
              EasilyPayLoanInfoActivity.b(EasilyPayLoanInfoActivity.this).cancel();
            }
          }
        }
      });
      return;
    }
    showToast("登录信息过期");
  }
  
  private void a(g paramg)
  {
    if (paramg == null) {
      return;
    }
    if ("processing".equals(paramg.getLoanStatus()))
    {
      this.loan_title.setText("已提交，正在审核中");
      this.loan_hint.setText(paramg.getLoanStatusMsg());
      this.easily_btn.setVisibility(8);
      this.loan_to_pay_money_rl.setVisibility(8);
    }
    label517:
    for (;;)
    {
      if (ae.notNull(paramg.getFirstPayment())) {
        this.loan_first_payment.setText(paramg.getFirstPayment());
      }
      if (ae.notNull(paramg.getPrincipalSum())) {
        this.loan_principal_sum.setText(paramg.getPrincipalSum());
      }
      this.loan_loan_periods.setText(paramg.getLoanPeriods() + " 期");
      if (ae.notNull(paramg.getShouldPay())) {
        this.loan_should_pay.setText(paramg.getShouldPay());
      }
      if (ae.notNull(paramg.getPrincipal())) {
        this.loan_principal.setText(paramg.getPrincipal());
      }
      if (ae.notNull(paramg.getInterest())) {
        this.loan_interest.setText(paramg.getInterest());
      }
      this.loan_to_pay_money.setText(ah.changeF2Y(paramg.getPayAmount() + ""));
      if (1 != paramg.getIsCancle()) {
        break;
      }
      this.loan_cancle.setVisibility(0);
      return;
      if ("fail".equals(paramg.getLoanStatus()))
      {
        this.loan_title.setText("抱歉，贷款审核不通过");
        this.loan_hint.setText(paramg.getLoanStatusMsg());
        this.easily_btn.setText("重新发起支付");
        this.easily_btn.setVisibility(0);
        this.loan_to_pay_money_rl.setVisibility(0);
        if (this.g != null) {
          this.g.cancel();
        }
      }
      else if ("success".equals(paramg.getLoanStatus()))
      {
        this.loan_title.setText("已通过，请在" + paramg.getExpirationDate() + "前支付首笔款项");
        this.loan_hint.setText(paramg.getLoanStatusMsg());
        if (1 == paramg.getIsPay())
        {
          this.easily_btn.setText("支付¥" + ah.changeF2Y(new StringBuilder().append(paramg.getPayAmount()).append("").toString()));
          this.easily_btn.setVisibility(0);
          this.loan_to_pay_money_rl.setVisibility(0);
        }
        for (;;)
        {
          if (this.g == null) {
            break label517;
          }
          this.g.cancel();
          break;
          if (1 == paramg.getIsConfirm())
          {
            this.easily_btn.setText("确认贷款");
            this.easily_btn.setVisibility(0);
            this.loan_to_pay_money_rl.setVisibility(0);
          }
          else
          {
            this.easily_btn.setVisibility(8);
            this.loan_to_pay_money_rl.setVisibility(8);
          }
        }
      }
    }
    this.loan_cancle.setVisibility(8);
  }
  
  private void b()
  {
    j.loanConfirm(this, this.e, new com.ziroom.commonlibrary.a.a(this, new c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ("0".equals(paramAnonymouse.get("code") + "")) {
          EasilyPayLoanInfoActivity.c(EasilyPayLoanInfoActivity.this);
        }
        for (;;)
        {
          dismissProgress();
          return;
          EasilyPayLoanInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
        }
      }
    });
  }
  
  private void e()
  {
    if (this.f)
    {
      setResult(66, getIntent());
      finish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.ziroom.ziroomcustomer.easily_pay");
    sendBroadcast(localIntent);
    finish();
  }
  
  private void f()
  {
    if ((ApplicationEx.c.getUser() != null) && (ApplicationEx.c.isLoginState()))
    {
      j.cancelLoan(this, this.e, new com.ziroom.commonlibrary.a.a(this, new c())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ("0".equals(paramAnonymouse.get("code") + "")) {
            EasilyPayLoanInfoActivity.c(EasilyPayLoanInfoActivity.this);
          }
          for (;;)
          {
            dismissProgress();
            return;
            EasilyPayLoanInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
          }
        }
      });
      return;
    }
    showToast("登录信息过期");
  }
  
  private void g()
  {
    this.e = getIntent().getStringExtra("mContractCode");
    this.f = getIntent().getBooleanExtra("isBack", false);
    if (!this.f)
    {
      this.back_iv.setVisibility(8);
      return;
    }
    this.back_iv.setVisibility(0);
  }
  
  public void onBackPressed()
  {
    if (this.f) {
      super.onBackPressed();
    }
  }
  
  @OnClick({2131690511, 2131690518, 2131690517})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690517: 
      if ("重新发起支付".equals(this.easily_btn.getText().toString()))
      {
        paramView = new Intent(this.b, HouseBillInfoActivity.class);
        paramView.putExtra("uniqueCode", this.e);
        paramView.putExtra("period", this.c.getPeriod() + "");
        paramView.putExtra("payType", "fz");
        startActivity(paramView);
        e();
        return;
      }
      if ("确认贷款".equals(this.easily_btn.getText().toString()))
      {
        d.newBuilder(this).setContent("点击确认按钮后，您的贷款申请将被确认").setTitle("确认贷款").setButtonText("确认贷款", "我再想想").setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView)
          {
            EasilyPayLoanInfoActivity.d(EasilyPayLoanInfoActivity.this);
          }
          
          public void onRightClick(View paramAnonymousView) {}
        }).show();
        return;
      }
      com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, this.c.getPayAmount(), "fz", this.c.getCwOrderIds(), this.c.getSystemId());
      return;
    case 2131690518: 
      d.newBuilder(this).setContent("点击确认关闭后贷款申请将被关闭，请您继续选择其他付款方式完成本期房租支付").setTitle("确认关闭贷款申请").setButtonText("确认关闭", "我再想想").setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView)
        {
          EasilyPayLoanInfoActivity.e(EasilyPayLoanInfoActivity.this);
        }
        
        public void onRightClick(View paramAnonymousView) {}
      }).show();
      return;
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903166);
    this.a = ButterKnife.bind(this);
    this.b = this;
    g();
    a();
    this.g.schedule(this.r, 0L, 5000L);
    this.d = new a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.ziroomcustomer.payresult");
    registerReceiver(this.d, paramBundle);
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.d);
    this.g.cancel();
    this.r.cancel();
    super.onDestroy();
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("code", -1);
      paramIntent.getStringExtra("payType");
      if (i == 1) {
        EasilyPayLoanInfoActivity.c(EasilyPayLoanInfoActivity.this);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/EasilyPayLoanInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */