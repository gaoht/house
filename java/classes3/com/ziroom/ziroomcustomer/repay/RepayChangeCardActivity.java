package com.ziroom.ziroomcustomer.repay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;

public class RepayChangeCardActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private com.ziroom.ziroomcustomer.repay.a.a c;
  @BindView(2131690143)
  TextView change_card_state_btn;
  @BindView(2131690141)
  ImageView change_card_state_img;
  @BindView(2131690142)
  TextView change_card_state_tv;
  private String d;
  private Handler e;
  private Runnable f;
  
  private void a()
  {
    this.c = ((com.ziroom.ziroomcustomer.repay.a.a)getIntent().getSerializableExtra("bound_card"));
    this.d = getIntent().getStringExtra("contractCode");
  }
  
  private void b()
  {
    if (this.c == null) {}
    do
    {
      return;
      if (this.c.getStatus() == 1)
      {
        this.change_card_state_img.setBackgroundResource(2130840406);
        this.change_card_state_tv.setText("银行卡换绑成功");
        this.change_card_state_btn.setText("确定");
        if (this.e != null) {
          this.e.removeCallbacks(this.f);
        }
        this.e = null;
        return;
      }
      if (this.c.getStatus() == 2)
      {
        this.change_card_state_img.setBackgroundResource(2130840408);
        this.change_card_state_tv.setText("银行卡换绑失败");
        this.change_card_state_btn.setText("确定");
        if (this.e != null) {
          this.e.removeCallbacks(this.f);
        }
        this.e = null;
        return;
      }
    } while (this.c.getStatus() != 3);
    this.change_card_state_img.setBackgroundResource(2130840407);
    this.change_card_state_tv.setText("  绑卡处理中，请稍后");
    this.change_card_state_btn.setText("回到还款首页");
  }
  
  private void e()
  {
    j.getBoundCardState(this.b, this.d, new com.ziroom.commonlibrary.a.a(this.b, new c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        dismissProgress();
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          if (paramAnonymouse.get("data") != null)
          {
            RepayChangeCardActivity.a(RepayChangeCardActivity.this, (com.ziroom.ziroomcustomer.repay.a.a)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "", com.ziroom.ziroomcustomer.repay.a.a.class));
            RepayChangeCardActivity.b(RepayChangeCardActivity.this);
          }
          return;
        }
        RepayChangeCardActivity.this.showToast(paramAnonymouse.get("message") + "");
      }
    });
  }
  
  public void onBackPressed() {}
  
  @OnClick({2131690143})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131690143: 
      do
      {
        return;
      } while (this.c == null);
      if (this.c.getStatus() == 1)
      {
        paramView = new Intent(this, RepayCardActivity.class);
        paramView.putExtra("bound_card", this.c);
        paramView.putExtra("contractCode", this.d);
        startActivity(paramView);
      }
      for (;;)
      {
        finish();
        return;
        if (this.c.getStatus() == 2)
        {
          paramView = new Intent(this, RepayCardActivity.class);
          paramView.putExtra("bound_card", this.c);
          paramView.putExtra("contractCode", this.d);
          startActivity(paramView);
        }
        else if (this.c.getStatus() == 3)
        {
          paramView = new Intent(this, RepayInfoActivity.class);
          paramView.putExtra("contractCode", this.d);
          startActivity(paramView);
        }
      }
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903127);
    this.a = ButterKnife.bind(this);
    this.b = this;
    a();
    b();
    this.e = new Handler();
    this.f = new Runnable()
    {
      public void run()
      {
        RepayChangeCardActivity.a(RepayChangeCardActivity.this);
      }
    };
    this.e.postDelayed(this.f, 5000L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.e != null) {
      this.e.removeCallbacks(this.f);
    }
    this.e = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayChangeCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */