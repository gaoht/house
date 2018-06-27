package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newServiceList.model.e;
import com.ziroom.ziroomcustomer.util.af;

public class ComplainsDetailActivity
  extends BaseActivity
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private e f;
  private TextView g;
  private ImageView r;
  private Handler s = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        ComplainsDetailActivity.a(ComplainsDetailActivity.this, (e)locall.getObject());
        ComplainsDetailActivity.a(ComplainsDetailActivity.this);
      }
      for (;;)
      {
        ComplainsDetailActivity.this.dismissProgress();
        return;
        af.showToast(ComplainsDetailActivity.b(ComplainsDetailActivity.this), locall.getMessage());
      }
    }
  };
  
  private void a()
  {
    String str = getIntent().getStringExtra("complainId");
    o.getNewComplainDetail(this.a, this.s, str);
  }
  
  private void b()
  {
    this.b = ((TextView)findViewById(2131690423));
    this.c = ((TextView)findViewById(2131690053));
    this.d = ((TextView)findViewById(2131690048));
    this.e = ((TextView)findViewById(2131690424));
    this.g = ((TextView)findViewById(2131689848));
    this.r = ((ImageView)findViewById(2131689492));
    this.r.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ComplainsDetailActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.b.setText(this.f.getSubmitDate());
    this.c.setText(this.f.getToComplainName());
    this.d.setText(this.f.getOrderNum());
    this.e.setText(this.f.getOrderZt());
    this.g.setText(this.f.getOrderStateName());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903161);
    this.a = this;
    b();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/ComplainsDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */