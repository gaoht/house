package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.b.b;
import com.ziroom.ziroomcustomer.newServiceList.b.b.a;
import com.ziroom.ziroomcustomer.newServiceList.model.c;
import com.ziroom.ziroomcustomer.newServiceList.model.c.f;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveSuccessBean;
import com.ziroom.ziroomcustomer.newmovehouse.mvp.OrderDetailActivity;
import com.ziroom.ziroomcustomer.util.w;

public class MovingVanSuccessActivity
  extends BaseActivity
{
  private String a;
  private TextView b;
  private TextView c;
  
  private void a()
  {
    b();
  }
  
  private void b()
  {
    this.b = ((TextView)findViewById(2131689541));
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovingVanSuccessActivity.this.finish();
      }
    });
    findViewById(2131696484).setVisibility(8);
    ((ImageView)findViewById(2131696483)).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("预约成功");
    this.c = ((TextView)findViewById(2131690360));
    findViewById(2131691814).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MovingVanSuccessActivity.this, CleanIndexActivity.class);
        paramAnonymousView.putExtra("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
        paramAnonymousView.putExtra("ServiceInfoName", "日常保洁");
        MovingVanSuccessActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131691816).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MovingVanSuccessActivity.this, CleanIndexActivity.class);
        paramAnonymousView.putExtra("ServiceInfoId", "2c9084434b783482014b784188290209");
        paramAnonymousView.putExtra("ServiceInfoName", "深度保洁");
        MovingVanSuccessActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131691817).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MovingVanSuccessActivity.this, CleanIndexActivity.class);
        paramAnonymousView.putExtra("ServiceInfoId", "2c9084454b7835b0014b78422b1e01cb");
        paramAnonymousView.putExtra("ServiceInfoName", "开荒保洁");
        MovingVanSuccessActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  private void e()
  {
    this.a = getIntent().getStringExtra("move_from");
    if ("moving_van".equals(this.a)) {
      this.b.setText("自如大搬");
    }
    for (;;)
    {
      g();
      f();
      return;
      if ("small_move".equals(this.a)) {
        this.b.setText("自如中搬");
      } else if ("move_xiaomian".equals(this.a)) {
        this.b.setText("自如小搬");
      }
    }
  }
  
  private void f()
  {
    n.getCommonTemplateOnCityV2(this, Integer.valueOf(20), new com.freelxl.baselibrary.d.c.a(new f(c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final c paramAnonymousc)
      {
        if ((paramAnonymousc != null) && (paramAnonymousc.getMoveOrderSuccess() != null) && (paramAnonymousc.getMoveOrderSuccess().getValid() == 1))
        {
          String str = paramAnonymousc.getMoveOrderSuccess().getUrl();
          paramAnonymousc = new b(MovingVanSuccessActivity.this, paramAnonymousc.getMoveOrderSuccess().getImage(), str, "");
          paramAnonymousc.show();
          paramAnonymousc.setOnAnimationListener(new b.a()
          {
            public void change()
            {
              paramAnonymousc.dismiss();
            }
          });
        }
      }
    });
  }
  
  private void g()
  {
    n.getMoveOrderSuccessTip(this, new com.freelxl.baselibrary.d.c.a(new f(MoveSuccessBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, MoveSuccessBean paramAnonymousMoveSuccessBean)
      {
        if ((paramAnonymousMoveSuccessBean != null) && (!TextUtils.isEmpty(paramAnonymousMoveSuccessBean.getContent()))) {
          MovingVanSuccessActivity.a(MovingVanSuccessActivity.this).setText(paramAnonymousMoveSuccessBean.getContent());
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903363);
    a();
    e();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      w.onEvent("truck_bookingsuccess_vieworder");
      if ("moving_van".equals(this.a))
      {
        paramView = new Intent(this, OrderDetailActivity.class);
        paramView.putExtra("orderId", getIntent().getStringExtra("orderId"));
        paramView.putExtra("moveOrderType", "move_van");
        startActivityAndFinish(paramView);
        return;
      }
      if ("move_xiaomian".equals(this.a))
      {
        paramView = new Intent(this, OrderDetailActivity.class);
        paramView.putExtra("orderId", getIntent().getStringExtra("orderId"));
        paramView.putExtra("moveOrderType", "move_xiaomian");
        startActivityAndFinish(paramView);
        return;
      }
    } while (!"small_move".equals(this.a));
    paramView = new Intent(this, OrderDetailActivity.class);
    paramView.putExtra("orderId", getIntent().getStringExtra("orderId"));
    paramView.putExtra("moveOrderType", "move_small");
    startActivity(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */