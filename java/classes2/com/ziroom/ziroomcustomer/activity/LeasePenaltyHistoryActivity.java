package com.ziroom.ziroomcustomer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;

public class LeasePenaltyHistoryActivity
  extends Activity
{
  BasicZiroomToolBar a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private LeasePayPlan h;
  
  private void a()
  {
    this.h = ((LeasePayPlan)getIntent().getSerializableExtra("LeasePayPlan"));
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("支付详情");
    this.b = ((TextView)findViewById(2131695164));
    this.c = ((TextView)findViewById(2131692850));
    this.d = ((TextView)findViewById(2131696643));
    this.e = ((TextView)findViewById(2131691525));
    this.f = ((TextView)findViewById(2131696646));
    this.g = ((TextView)findViewById(2131696647));
    if (this.h == null) {}
    while (this.h.getContractWyjPayInfo() == null) {
      return;
    }
    LeaseInfo localLeaseInfo = (LeaseInfo)getIntent().getSerializableExtra("lease");
    this.f.setText("¥" + this.h.getContractWyjPayInfo().getReceivableMoney());
    this.b.setText("" + this.h.getContractCode());
    if (localLeaseInfo != null) {
      this.c.setText("" + localLeaseInfo.getAddress());
    }
    this.d.setText("" + this.h.getContractWyjPayInfo().getPenaltyNum() + "天");
    this.e.setText("" + this.h.getContractWyjPayInfo().getReceivableMoney() + "元");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904837);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeasePenaltyHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */