package com.ziroom.ziroomcustomer.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.text.DecimalFormat;

public class WithdrawSucceedActivity
  extends BaseActivity
{
  private void a()
  {
    Object localObject = (TextView)findViewById(2131692662);
    TextView localTextView2 = (TextView)findViewById(2131692661);
    TextView localTextView1 = (TextView)findViewById(2131692663);
    findViewById(2131692664).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        WithdrawSucceedActivity.this.finish();
        WithdrawSucceedActivity.this.overridePendingTransition(2130968678, 0);
      }
    });
    findViewById(2131692660).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        WithdrawSucceedActivity.this.finish();
        WithdrawSucceedActivity.this.overridePendingTransition(2130968678, 0);
      }
    });
    String str1 = getIntent().getStringExtra("cardName");
    String str2 = getIntent().getStringExtra("cardNum");
    String str3 = getIntent().getStringExtra("money");
    localTextView2.setText(str1);
    ((TextView)localObject).setText(str2.replaceAll("(?<=.{4})(.{8})", "********").replaceAll(".{4}(?!$)", "$0 "));
    localObject = new DecimalFormat("######0.00").format(Double.valueOf(str3));
    localTextView1.setText((String)localObject + "元");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903547);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/WithdrawSucceedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */