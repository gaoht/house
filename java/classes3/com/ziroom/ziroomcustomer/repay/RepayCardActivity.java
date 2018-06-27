package com.ziroom.ziroomcustomer.repay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.signed.BoundCardActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class RepayCardActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private com.ziroom.ziroomcustomer.repay.a.a c;
  private String d;
  @BindView(2131692212)
  ImageView repay_bound_card_iv;
  @BindView(2131692209)
  TextView repay_card_code;
  @BindView(2131692206)
  LinearLayout repay_card_ll;
  @BindView(2131692207)
  TextView repay_card_name;
  @BindView(2131692211)
  TextView repay_card_text_tv;
  @BindView(2131692208)
  TextView repay_card_type;
  
  private void a()
  {
    this.repay_card_ll.setBackgroundResource(2130840144);
    this.repay_card_type.setVisibility(8);
    this.repay_card_name.setVisibility(8);
    this.repay_card_code.setVisibility(8);
    this.repay_bound_card_iv.setVisibility(8);
    this.repay_card_text_tv.setText("绑定还款银行卡");
  }
  
  private void b()
  {
    if (this.c == null)
    {
      a();
      return;
    }
    if ((ae.isNull(this.c.getBankName())) && (ae.isNull(this.c.getUserBankNo())))
    {
      a();
      return;
    }
    this.repay_card_ll.setBackgroundResource(2130839960);
    this.repay_card_text_tv.setText("解绑当前银行卡");
    this.repay_card_name.setText(this.c.getBankName());
    this.repay_card_code.setText(this.c.getUserBankNo());
    this.repay_card_name.setVisibility(0);
    this.repay_card_code.setVisibility(0);
  }
  
  private void e()
  {
    this.c = ((com.ziroom.ziroomcustomer.repay.a.a)getIntent().getSerializableExtra("bound_card"));
    this.d = getIntent().getStringExtra("contractCode");
  }
  
  private void f()
  {
    if (this.c == null)
    {
      showToast("银行卡信息获取失败");
      return;
    }
    j.deleteCard(this, this.d, new com.ziroom.commonlibrary.a.a(this.b, new c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        dismissProgress();
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          RepayCardActivity.b(RepayCardActivity.this);
          return;
        }
        RepayCardActivity.this.showToast(paramAnonymouse.get("message") + "");
      }
    });
  }
  
  @OnClick({2131692210, 2131690511, 2131692206})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692206: 
    case 2131692210: 
      if ("解绑当前银行卡".equals(this.repay_card_text_tv.getText().toString()))
      {
        d.newBuilder(this).setContent("确定解绑当前银行卡？").setTitle("").setButtonText("取消", "确认").setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            RepayCardActivity.a(RepayCardActivity.this);
          }
        }).show();
        return;
      }
      paramView = new Intent(this, BoundCardActivity.class);
      paramView.putExtra("mBoundCardType", 3);
      paramView.putExtra("contract_code", this.d);
      startActivity(paramView);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903455);
    this.a = ButterKnife.bind(this);
    this.b = this;
    e();
    b();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    this.c = ((com.ziroom.ziroomcustomer.repay.a.a)getIntent().getSerializableExtra("bound_card"));
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */