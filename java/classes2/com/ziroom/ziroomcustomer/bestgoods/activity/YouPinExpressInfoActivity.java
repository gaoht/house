package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class YouPinExpressInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private RelativeLayout c;
  private TextView d;
  private EditText e;
  private EditText f;
  private EditText g;
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((TextView)findViewById(2131692715));
    this.c = ((RelativeLayout)findViewById(2131692716));
    this.d = ((TextView)findViewById(2131692718));
    this.e = ((EditText)findViewById(2131692720));
    this.f = ((EditText)findViewById(2131692722));
    this.g = ((EditText)findViewById(2131692724));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private void e() {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903554);
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinExpressInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */