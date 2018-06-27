package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newrepair.b.u;

public class RepairSubmitSuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Button a;
  private String b;
  private Intent c;
  private TextView d;
  
  private void a()
  {
    u localu = (u)getIntent().getSerializableExtra("repariInfo");
    this.a = ((Button)findViewById(2131692335));
    this.d = ((TextView)findViewById(2131692332));
    this.a.setOnClickListener(this);
    this.a.setText("查看订单列表");
    this.d.setText("您的订单已提交成功");
    TextView localTextView1 = (TextView)findViewById(2131692333);
    TextView localTextView2 = (TextView)findViewById(2131692334);
    if (localu != null)
    {
      localTextView1.setText(localu.getPromise());
      localTextView2.setText(localu.getPromiseRemark());
      return;
    }
    localTextView1.setText("");
    localTextView2.setText("");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    showProgressNoCancel("", 3000L);
    new Thread()
    {
      public void run()
      {
        super.run();
        try
        {
          Thread.sleep(3000L);
          RepairSubmitSuccessActivity.a(RepairSubmitSuccessActivity.this, new Intent(RepairSubmitSuccessActivity.this, ZiroomOrderListActivity.class));
          RepairSubmitSuccessActivity.this.startActivityAndFinish(RepairSubmitSuccessActivity.a(RepairSubmitSuccessActivity.this));
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }.start();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903480);
    this.b = getIntent().getStringExtra("orderId");
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/RepairSubmitSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */