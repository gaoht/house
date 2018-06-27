package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.b;

public class ZryuSignPaySuccessActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  private String d;
  private String e;
  private boolean f;
  private String g;
  @BindView(2131693032)
  TextView pay_status_btn1;
  @BindView(2131693033)
  TextView pay_status_btn2;
  @BindView(2131692230)
  TextView pay_status_content;
  @BindView(2131693031)
  TextView pay_status_tv;
  private String r;
  private String s;
  
  private void a()
  {
    this.pay_status_tv.setText("支付¥" + this.g);
    if (!TextUtils.isEmpty(this.s)) {
      this.pay_status_content.setText(this.s);
    }
    if ("1".equals(this.e))
    {
      if (this.f)
      {
        if ("0".equals(this.r))
        {
          this.pay_status_btn1.setVisibility(0);
          this.pay_status_btn1.setText("去物业交割");
          return;
        }
        this.pay_status_btn1.setVisibility(8);
        return;
      }
      this.pay_status_btn1.setVisibility(0);
      this.pay_status_btn1.setText("继续支付");
      return;
    }
    if (this.f)
    {
      this.pay_status_btn1.setVisibility(8);
      this.pay_status_btn2.setText("完成");
      return;
    }
    this.pay_status_btn1.setVisibility(0);
    this.pay_status_btn1.setText("继续支付");
  }
  
  private void b()
  {
    this.c = getIntent().getStringExtra("contractId");
    this.d = getIntent().getStringExtra("contractCode");
    this.e = getIntent().getStringExtra("period");
    this.f = getIntent().getBooleanExtra("isPaySuccess", false);
    this.g = getIntent().getStringExtra("money");
    this.r = getIntent().getStringExtra("signType");
    this.s = getIntent().getStringExtra("payStatusContent");
  }
  
  public void onBackPressed() {}
  
  @OnClick({2131689492, 2131693032, 2131693033})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131693032: 
      ApplicationEx.c.addToZryuSign(this);
      if (this.f)
      {
        b.toDelivery(this.b, this.c);
        return;
      }
      b.toBillsInfo(this.b, this.c, this.d, "1007", this.e);
      return;
    }
    if ("1".equals(this.e))
    {
      ApplicationEx.c.finishZryuSign();
      paramView = new Intent(this.b, ZryuLeaseInfoActivity.class);
      paramView.putExtra("contractId", this.c);
      paramView.putExtra("deCode", "XQ");
      startActivity(paramView);
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903615);
    this.a = ButterKnife.bind(this);
    this.b = this;
    b();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */