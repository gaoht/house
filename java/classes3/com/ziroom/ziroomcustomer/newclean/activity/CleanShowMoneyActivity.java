package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class CleanShowMoneyActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private TextView c;
  private LinearLayout d;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131692410));
    this.b = ((TextView)findViewById(2131692412));
    this.c = ((TextView)findViewById(2131692407));
    this.d = ((LinearLayout)findViewById(2131692406));
    String str1 = getIntent().getStringExtra("clean_money");
    String str2 = getIntent().getStringExtra("coupon_money");
    String str3 = getIntent().getStringExtra("all_money");
    if (!TextUtils.isEmpty(str1)) {
      this.a.setText(str1 + "元");
    }
    if (!TextUtils.isEmpty(str2)) {
      this.b.setText("-" + str2 + "元");
    }
    if (!TextUtils.isEmpty(str3)) {}
    for (;;)
    {
      try
      {
        int i = Integer.valueOf(str3).intValue();
        if (i <= 0) {
          continue;
        }
        this.c.setText(i + "");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CleanShowMoneyActivity.this.finish();
        }
      });
      return;
      this.c.setText("0");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903498);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanShowMoneyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */