package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class HouseBillPaySuccessActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  
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
    paramView = new Intent(this, MainActivity.class);
    paramView.putExtra("FRAGMENT_TYPE", 7);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903203);
    this.b = this;
    this.a = ButterKnife.bind(this);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/HouseBillPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */