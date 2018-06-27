package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class BiweeklyCleanModifySuccessActivity
  extends BaseActivity
{
  private void a()
  {
    b();
  }
  
  private void b()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiweeklyCleanModifySuccessActivity.this.finish();
      }
    });
    findViewById(2131696484).setVisibility(8);
    ((ImageView)findViewById(2131696483)).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("改约成功");
  }
  
  private void e() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903114);
    a();
    e();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (getIntent().getBooleanExtra("isFormDetail", false))
    {
      finish();
      return;
    }
    paramView = new Intent(this, WeekCleanDetailActivity.class);
    paramView.putExtras(getIntent().getExtras());
    startActivityAndFinish(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiweeklyCleanModifySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */