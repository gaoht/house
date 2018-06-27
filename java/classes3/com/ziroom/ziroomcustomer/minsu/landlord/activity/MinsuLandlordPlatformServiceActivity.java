package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.f;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralCleaningActivity;

public class MinsuLandlordPlatformServiceActivity
  extends BaseActivity
{
  f a;
  private String b;
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setMiddleText(getString(2131297114));
    localCommonTitle.setLeftButtonType(0);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLandlordPlatformServiceActivity.this.finish();
      }
    });
  }
  
  private void b()
  {
    this.b = getIntent().getStringExtra("phone400");
    f();
  }
  
  private void e()
  {
    if (this.a == null)
    {
      this.a = new f(this);
      this.a.init();
    }
    if (this.a != null) {
      this.a.showPop();
    }
  }
  
  private void f()
  {
    if (this.a == null)
    {
      this.a = new f(this);
      this.a.init();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903301);
    ButterKnife.bind(this);
    a();
    b();
  }
  
  @OnClick({2131691549, 2131690693})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691549: 
      paramView = new Intent(this, GeneralCleaningActivity.class);
      paramView.putExtra("ServiceInfoId", "8a90a28956f928920156f9c0472f000a");
      paramView.putExtra("ServiceInfoName", "民宿保洁");
      startActivity(paramView);
      return;
    }
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordPlatformServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */