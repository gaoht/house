package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.signed.a.f;
import com.ziroom.ziroomcustomer.util.ae;

public class EasilyPayInfoActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  @BindView(2131690516)
  TextView interest;
  @BindView(2131690513)
  TextView loan_periods;
  @BindView(2131690515)
  TextView principal;
  @BindView(2131690512)
  TextView principal_sum;
  @BindView(2131690514)
  TextView should_pay;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("contract_code");
  }
  
  private void a(f paramf)
  {
    if (paramf == null) {}
    do
    {
      return;
      if (ae.notNull(paramf.getPrincipalSum())) {
        this.principal_sum.setText("¥" + paramf.getPrincipalSum());
      }
      if (ae.notNull(paramf.getLoanPeriods())) {
        this.loan_periods.setText(paramf.getLoanPeriods() + " 期");
      }
      if (ae.notNull(paramf.getShouldPay())) {
        this.should_pay.setText("¥" + paramf.getShouldPay());
      }
      if (ae.notNull(paramf.getPrincipal())) {
        this.principal.setText("¥" + paramf.getPrincipal());
      }
    } while (!ae.notNull(paramf.getInterest()));
    this.interest.setText("¥" + paramf.getInterest());
  }
  
  private void b()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((localUserInfo != null) && (ApplicationEx.c.isLoginState()))
    {
      j.getLoanData(this, localUserInfo.getUid(), this.c, new com.ziroom.commonlibrary.a.a(this, new c())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ("0".equals(paramAnonymouse.get("code") + ""))
          {
            paramAnonymouse = (f)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data").toString(), f.class);
            EasilyPayInfoActivity.a(EasilyPayInfoActivity.this, paramAnonymouse);
          }
          for (;;)
          {
            dismissProgress();
            return;
            EasilyPayInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
          }
        }
      });
      return;
    }
    showToast("登录信息过期");
  }
  
  @OnClick({2131690517, 2131690511})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690511: 
      finish();
      return;
    }
    paramView = new Intent(getApplicationContext(), BoundCardActivity.class);
    paramView.putExtra("mBoundCardType", 4);
    paramView.putExtra("contract_code", this.c);
    startActivity(paramView);
    ApplicationEx.c.addActivity(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903165);
    this.a = ButterKnife.bind(this);
    this.b = this;
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/EasilyPayInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */