package com.ziroom.ziroomcustomer.living;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;

public class LeaseLivingInfoActivity
  extends BaseActivity
{
  private Unbinder a;
  private c b;
  @BindView(2131691914)
  ImageView iv_lease_back;
  @BindView(2131696638)
  TextView living_info_all_should;
  @BindView(2131696633)
  TextView living_info_before_num;
  @BindView(2131696632)
  RelativeLayout living_info_before_num_rl;
  @BindView(2131696631)
  TextView living_info_bill_start_date;
  @BindView(2131696635)
  TextView living_info_display_num;
  @BindView(2131696634)
  RelativeLayout living_info_display_num_rl;
  @BindView(2131696628)
  TextView living_info_money;
  @BindView(2131696639)
  TextView living_info_number_share;
  @BindView(2131696630)
  TextView living_info_order_code;
  @BindView(2131696629)
  TextView living_info_pay_type;
  @BindView(2131696642)
  TextView living_info_payed_time;
  @BindView(2131696641)
  RelativeLayout living_info_payed_time_rl;
  @BindView(2131696640)
  TextView living_info_should_pay;
  @BindView(2131696627)
  TextView living_info_title;
  @BindView(2131696637)
  TextView living_info_unit_price;
  @BindView(2131696636)
  RelativeLayout living_info_unit_price_rl;
  
  private void a()
  {
    if (this.b == null) {
      return;
    }
    this.living_info_all_should.setText(ah.Number(Float.parseFloat(ah.changeF2Y(new StringBuilder().append(this.b.getAllShouldPayAmount()).append("").toString()))) + "元");
    this.living_info_number_share.setText(this.b.getNumberShare() + "");
    this.living_info_money.setText(ah.changeF2Y(this.b.getShouldPayAmount() + ""));
    this.living_info_should_pay.setText(ah.changeF2Y(new StringBuilder().append(this.b.getShouldPayAmount()).append("").toString()) + "元");
    if (ae.notNull(this.b.getBeforeNum()))
    {
      this.living_info_before_num_rl.setVisibility(0);
      this.living_info_before_num.setText(this.b.getBeforeNum() + "");
      if (!ae.notNull(this.b.getDisplayNum())) {
        break label723;
      }
      this.living_info_display_num_rl.setVisibility(0);
      this.living_info_display_num.setText(this.b.getDisplayNum() + "");
      label293:
      if (ae.notNull(this.b.getChildBillCode())) {
        this.living_info_order_code.setText(this.b.getChildBillCode() + "");
      }
      if (!ae.notNull(this.b.getUnitPrice() + "")) {
        break label770;
      }
      this.living_info_unit_price_rl.setVisibility(0);
      if (!ae.notNull(this.b.getUnit())) {
        break label735;
      }
      this.living_info_unit_price.setText(this.b.getUnitPrice() + this.b.getUnit() + "");
      label432:
      if (!ae.notNull(this.b.getPayedTime())) {
        break label782;
      }
      this.living_info_payed_time.setText(this.b.getPayedTime().replace('-', '/') + "");
      label484:
      if (ae.isNull(this.b.getExpensesCategoryName())) {
        this.b.setExpensesCategoryName("");
      }
      if (ae.isNull(this.b.getMeterName())) {
        this.b.setMeterName("");
      }
      this.living_info_title.setText(this.b.getExpensesCategoryName() + "·" + this.b.getMeterName());
      if (this.b.getPayStatus() != 0) {
        break label794;
      }
      this.living_info_pay_type.setText("等待支付");
    }
    for (;;)
    {
      String str1 = "";
      if (ae.notNull(this.b.getBillStartDate())) {
        str1 = this.b.getBillStartDate().substring(0, 10).replace('-', '/');
      }
      String str2 = str1;
      if (ae.notNull(this.b.getBillEndDate())) {
        str2 = str1 + "-" + this.b.getBillEndDate().substring(0, 10).replace('-', '/');
      }
      this.living_info_bill_start_date.setText(str2 + "");
      return;
      this.living_info_before_num_rl.setVisibility(8);
      break;
      label723:
      this.living_info_display_num_rl.setVisibility(8);
      break label293;
      label735:
      this.living_info_unit_price.setText(this.b.getUnitPrice() + "");
      break label432;
      label770:
      this.living_info_unit_price_rl.setVisibility(8);
      break label432;
      label782:
      this.living_info_payed_time.setText("未获取到时间");
      break label484;
      label794:
      if (this.b.getPayStatus() == 1) {
        this.living_info_pay_type.setText("支付成功");
      }
    }
  }
  
  private void b()
  {
    this.b = ((c)getIntent().getSerializableExtra("infoMessage"));
  }
  
  @OnClick({2131691914})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904835);
    this.a = ButterKnife.bind(this);
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseLivingInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */