package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class MyAppointsActivity
  extends BaseActivity
{
  @OnClick({2131689930, 2131689931, 2131689932, 2131689933, 2131689929})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131689931: 
    case 2131689932: 
    default: 
      return;
    case 2131689929: 
      finish();
      return;
    }
    startActivity(new Intent(this, MyAppointActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903097);
    ButterKnife.bind(this);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAppointsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */