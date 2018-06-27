package com.ziroom.ziroomcustomer.repay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.util.ae;

public class RepayPayStatusActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  private String d;
  private Handler e;
  private Runnable f;
  private e g;
  @BindView(2131692230)
  TextView pay_status_content;
  @BindView(2131692231)
  TextView pay_status_state_btn;
  @BindView(2131692228)
  ImageView pay_status_state_img;
  @BindView(2131692229)
  TextView pay_status_state_tv;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("contract_code");
    this.d = getIntent().getStringExtra("serialNo");
  }
  
  private void b()
  {
    j.getReimbursementStatus(this.b, this.d, new com.ziroom.commonlibrary.a.a(this.b, new c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          RepayPayStatusActivity.a(RepayPayStatusActivity.this, com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + ""));
          RepayPayStatusActivity.b(RepayPayStatusActivity.this);
        }
        for (;;)
        {
          dismissProgress();
          return;
          RepayPayStatusActivity.this.showToast(paramAnonymouse.get("message") + "");
        }
      }
    });
    this.e.removeCallbacks(this.f);
    this.e = null;
  }
  
  private void e()
  {
    if (this.g == null) {
      return;
    }
    String str = this.g.getString("dealSts") + "";
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      if (!ae.notNull(this.g.getString("dealDesc"))) {
        break label241;
      }
      this.pay_status_content.setText(this.g.getString("dealDesc"));
      this.pay_status_content.setVisibility(0);
      return;
      if (!str.equals("02")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("03")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("04")) {
        break;
      }
      i = 2;
      break;
      this.pay_status_state_img.setBackgroundResource(2130840407);
      this.pay_status_state_tv.setText("还款处理中，请稍候");
      continue;
      this.pay_status_state_img.setBackgroundResource(2130840406);
      this.pay_status_state_tv.setText("还款成功");
      continue;
      this.pay_status_state_img.setBackgroundResource(2130840408);
      this.pay_status_state_tv.setText("还款失败");
    }
    label241:
    this.pay_status_content.setVisibility(4);
  }
  
  public void onBackPressed() {}
  
  @OnClick({2131692231})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    setResult(153, getIntent());
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903457);
    this.a = ButterKnife.bind(this);
    this.b = this;
    a();
    showProgress("");
    this.e = new Handler();
    this.f = new Runnable()
    {
      public void run()
      {
        RepayPayStatusActivity.a(RepayPayStatusActivity.this);
      }
    };
    this.e.postDelayed(this.f, 3000L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayPayStatusActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */