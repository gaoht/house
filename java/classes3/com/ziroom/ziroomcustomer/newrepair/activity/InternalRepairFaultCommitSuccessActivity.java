package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newrepair.b.u;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class InternalRepairFaultCommitSuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ObservableScrollView a;
  private ImageView b;
  private LinearLayout c;
  private TextView d;
  private TextView e;
  private Context f;
  private TextView g;
  private ImageView r;
  
  private void a()
  {
    this.f = this;
    this.r = ((ImageView)findViewById(2131689492));
    this.a = ((ObservableScrollView)findViewById(2131689506));
    this.b = ((ImageView)findViewById(2131691010));
    this.g = ((TextView)findViewById(2131691012));
    this.c = ((LinearLayout)findViewById(2131691013));
    this.d = ((TextView)findViewById(2131691014));
    this.e = ((TextView)findViewById(2131691015));
  }
  
  private void b()
  {
    this.r.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    u localu = (u)getIntent().getSerializableExtra("repariInfo");
    if (localu != null) {
      this.g.setText(localu.getPromise() + localu.getPromiseRemark());
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this.f, MainActivity.class);
    localIntent.putExtra("FRAGMENT_TYPE", 4);
    startActivityAndFinish(localIntent);
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
      f();
      return;
    case 2131691014: 
      showProgressNoCancel("", 3000L);
      new Thread()
      {
        public void run()
        {
          super.run();
          try
          {
            Intent localIntent = new Intent(InternalRepairFaultCommitSuccessActivity.a(InternalRepairFaultCommitSuccessActivity.this), ZiroomOrderListActivity.class);
            InternalRepairFaultCommitSuccessActivity.this.startActivity(localIntent);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }.start();
      return;
    }
    startActivity(new Intent(this.f, InternalRepairSelectActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903228);
    a();
    b();
    e();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairFaultCommitSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */