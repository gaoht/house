package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.n;

public class ForCleaningAppointActivity
  extends BaseActivity
{
  private ForCleaningAppointActivity a;
  private ImageView b;
  private TextView c;
  private EditText d;
  private TextView e;
  private TextView f;
  private String g;
  private String r;
  private String s;
  private String t;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131690041));
    this.d = ((EditText)findViewById(2131689811));
    this.e = ((TextView)findViewById(2131690042));
    this.f = ((TextView)findViewById(2131689997));
  }
  
  private void b()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.s = localBundle.getString("uid");
      this.t = localBundle.getString("name");
      this.c.setText(localBundle.getString("contractAddress"));
      this.d.setText(localBundle.getString("phone"));
    }
    this.g = getIntent().getStringExtra("billId");
  }
  
  private void e()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ForCleaningAppointActivity.this.finish();
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(ForCleaningAppointActivity.a(ForCleaningAppointActivity.this), ForCleaningSelectTimeActivity.class);
        paramAnonymousView.putExtra("workBillId", ForCleaningAppointActivity.b(ForCleaningAppointActivity.this));
        ForCleaningAppointActivity.this.startActivityForResult(paramAnonymousView, 1);
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ForCleaningAppointActivity.c(ForCleaningAppointActivity.this);
      }
    });
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.r))
    {
      g.textToast(this.a, "请先选择预约时间");
      return;
    }
    String str = VdsAgent.trackEditTextSilent(this.d).toString();
    if ((TextUtils.isEmpty(str)) || (!h.isMobile(str)))
    {
      g.textToast(this, "请输入正确的手机号！");
      return;
    }
    n.submitForCleaningTime(this.a, this.g, this.t, str, this.r, new d(this.a, new a(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        ForCleaningAppointActivity.this.setResult(-1);
        paramAnonymouse = new Intent(ForCleaningAppointActivity.a(ForCleaningAppointActivity.this), BiweeklyCleanModifySuccessActivity.class);
        paramAnonymouse.putExtras(ForCleaningAppointActivity.this.getIntent().getExtras());
        ForCleaningAppointActivity.this.startActivity(paramAnonymouse);
        ForCleaningAppointActivity.this.finish();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.r = paramIntent.getStringExtra("appointDateTime");
      this.e.setText(this.r);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903174);
    this.a = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/ForCleaningAppointActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */