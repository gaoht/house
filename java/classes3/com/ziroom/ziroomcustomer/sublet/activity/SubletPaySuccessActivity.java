package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class SubletPaySuccessActivity
  extends BaseActivity
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private int e;
  private Unbinder f;
  @BindView(2131690854)
  TextView lease_sublet_success_btn;
  @BindView(2131690853)
  TextView sublet_success_text;
  @BindView(2131690852)
  TextView sublet_success_title;
  
  private void a()
  {
    Intent localIntent = new Intent(this, SubletInitiatorDetailActivity.class);
    localIntent.putExtra("contract_code", this.b);
    localIntent.putExtra("isFromSuccess", true);
    this.a.startActivity(localIntent);
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this, SubletReservationDetailActivity.class);
    localIntent.putExtra("reserveCode", this.d);
    localIntent.putExtra("isPaySuccess", this.e);
    this.a.startActivity(localIntent);
  }
  
  public void onBackPressed() {}
  
  @OnClick({2131690854})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = this.c;
    int i = -1;
    switch (paramView.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
      case 0: 
        b();
        return;
        if (paramView.equals("ZZYD"))
        {
          i = 0;
          continue;
          if (paramView.equals("QRYD")) {
            i = 1;
          }
        }
        break;
      }
    }
    a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905158);
    this.a = this;
    this.f = ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("contract_code");
    this.c = getIntent().getStringExtra("payType");
    this.d = getIntent().getStringExtra("reserveCode");
    this.e = getIntent().getIntExtra("isPaySuccess", 1);
    paramBundle = this.c;
    int i = -1;
    switch (paramBundle.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramBundle.equals("ZZYD"))
        {
          i = 0;
          continue;
          if (paramBundle.equals("QRYD")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.lease_sublet_success_btn.setText("查看预订单详情");
    return;
    this.lease_sublet_success_btn.setText("查看转租详情");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
    this.f.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */