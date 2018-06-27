package com.ziroom.ziroomcustomer.ziroomstation;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class ShowEvaluateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = ShowEvaluateActivity.class.getSimpleName();
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903522);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/ShowEvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */