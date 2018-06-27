package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.util.w;

public class IssueHouseActivity
  extends BaseActivity
  implements View.OnClickListener
{
  @OnClick({2131691039, 2131691040, 2131689976})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691039: 
      w.onEvent("Longrent_landlord");
      startActivity(new Intent(this, OwnerZoneActivity.class));
      return;
    case 2131691040: 
      w.onEvent("M_landlord");
      k.landlordActivity(this);
      finish();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903235);
    ButterKnife.bind(this);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/IssueHouseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */