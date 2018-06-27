package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class AppointmentSuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.g.setText(localIntent.getStringExtra("phone"));
    this.f.setText(localIntent.getStringExtra("name"));
    this.e.setText(localIntent.getStringExtra("address"));
    this.d.setText(localIntent.getStringExtra("time"));
    this.c.setText(localIntent.getStringExtra("title"));
  }
  
  private void b()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131689922));
    this.d = ((TextView)findViewById(2131689923));
    this.e = ((TextView)findViewById(2131689924));
    this.f = ((TextView)findViewById(2131689925));
    this.g = ((TextView)findViewById(2131689926));
    this.b = ((TextView)findViewById(2131689927));
  }
  
  private void e()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      startActivity(new Intent(this, MainActivity.class));
      return;
    }
    this.b.setClickable(false);
    showProgressNoCancel("", 3000L);
    new Thread()
    {
      public void run()
      {
        super.run();
        try
        {
          Thread.sleep(3000L);
          AppointmentSuccessActivity.this.dismissProgress();
          Intent localIntent = new Intent(AppointmentSuccessActivity.this, ZiroomOrderListActivity.class);
          AppointmentSuccessActivity.this.startActivityAndFinish(localIntent);
          AppointmentSuccessActivity.a(AppointmentSuccessActivity.this).setClickable(true);
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
    setContentView(2130903096);
    b();
    e();
    a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    startActivity(new Intent(this, MainActivity.class));
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/AppointmentSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */