package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.sharedlife.c.e;
import java.text.DecimalFormat;

public class SharedLifeOrderDetailActivity
  extends BaseActivity
{
  private Context a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private a s;
  private String t;
  private String u;
  private e v;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.d = ((TextView)findViewById(2131692375));
    this.e = ((TextView)findViewById(2131692376));
    this.f = ((TextView)findViewById(2131692377));
    this.g = ((TextView)findViewById(2131692378));
    this.r = ((TextView)findViewById(2131692379));
    this.c = ((TextView)findViewById(2131690199));
  }
  
  private void b()
  {
    this.t = getIntent().getStringExtra("rentContractCode");
    this.u = getIntent().getStringExtra("orderCode");
    e();
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeOrderDetail(this, localUserInfo.getUid(), this.t, this.u, new d(this, new f(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          SharedLifeOrderDetailActivity.a(SharedLifeOrderDetailActivity.this, paramAnonymouse);
          SharedLifeOrderDetailActivity.a(SharedLifeOrderDetailActivity.this);
        }
      }
    });
  }
  
  private void f()
  {
    this.d.setText(this.v.getOrderCode());
    this.e.setText(this.v.getOrderStartTime());
    this.f.setText(this.v.getDeviceTypeName());
    if (this.v.getFeeType() == 1) {
      this.g.setText("预付费");
    }
    for (;;)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("######0.00");
      this.r.setText("￥" + localDecimalFormat.format(this.v.getOrderMoney() / 100) + "");
      if (this.v.getOrderState() != 3) {
        break;
      }
      this.c.setVisibility(0);
      return;
      if (this.v.getFeeType() == 2) {
        this.g.setText("后付费");
      }
    }
    this.c.setVisibility(8);
  }
  
  private void g()
  {
    this.s = new a();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.payresult");
    registerReceiver(this.s, localIntentFilter);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharedLifeOrderDetailActivity.this.finish();
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (SharedLifeOrderDetailActivity.b(SharedLifeOrderDetailActivity.this) == null) {
          return;
        }
        int i = SharedLifeOrderDetailActivity.b(SharedLifeOrderDetailActivity.this).getOrderMoney();
        paramAnonymousView = SharedLifeOrderDetailActivity.b(SharedLifeOrderDetailActivity.this).getBillNum();
        String str = SharedLifeOrderDetailActivity.b(SharedLifeOrderDetailActivity.this).getSystemId();
        com.ziroom.ziroomcustomer.payment.a.startPayActivty(SharedLifeOrderDetailActivity.this, i, "SharedLifeOrderDetailActivity", paramAnonymousView, str);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903490);
    this.a = this;
    a();
    b();
    g();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.s != null) {
      unregisterReceiver(this.s);
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getIntExtra("code", -1) == 1)
      {
        SharedLifeOrderDetailActivity.this.setResult(-1);
        SharedLifeOrderDetailActivity.this.finish();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeOrderDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */