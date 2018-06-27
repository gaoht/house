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
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.signed.h;
import com.ziroom.ziroomcustomer.signed.h.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class LeaseSubletSuccessActivity
  extends BaseActivity
{
  private Context a;
  private String b;
  private Unbinder c;
  private String d;
  private String e;
  private String f;
  @BindView(2131690854)
  TextView lease_sublet_success_btn;
  @BindView(2131690853)
  TextView sublet_success_text;
  @BindView(2131690852)
  TextView sublet_success_title;
  
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
    paramView = new Intent(this.a, SubletInitiatorDetailActivity.class);
    paramView.putExtra("contract_code", this.b);
    paramView.putExtra("isFromSuccess", true);
    startActivity(paramView);
    finish();
    w.onEvent(this.a, "subletdetail ");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904842);
    this.a = this;
    w.onEvent(this.a, "sublet_publish_result_finish ");
    this.c = ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("lease");
    this.d = getIntent().getStringExtra("success_text");
    this.e = getIntent().getStringExtra("success_tip");
    this.f = getIntent().getStringExtra("activity_info");
    if (ae.notNull(this.f)) {}
    try
    {
      paramBundle = e.parseObject(this.f);
      if ((paramBundle != null) && (paramBundle.get("imgUrl") != null) && (ae.notNull(paramBundle.get("imgUrl").toString()))) {
        h.creatDialog(this.a, paramBundle.get("imgUrl").toString(), false, true, paramBundle.get("skipUrl") + "", paramBundle, new h.a()
        {
          public void closeDialog() {}
          
          public void toMoveHouseWeb(String paramAnonymousString)
          {
            if (ae.notNull(paramAnonymousString)) {
              JsBridgeWebActivity.start(LeaseSubletSuccessActivity.a(LeaseSubletSuccessActivity.this), null, paramAnonymousString);
            }
          }
        });
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    if (ae.notNull(this.e)) {
      this.sublet_success_text.setText(this.e + "");
    }
    if (ae.notNull(this.d)) {
      this.sublet_success_title.setText(this.d + "");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
    this.c.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */