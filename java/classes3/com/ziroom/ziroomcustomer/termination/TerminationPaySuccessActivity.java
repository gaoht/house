package com.ziroom.ziroomcustomer.termination;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.EvaluateActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.Map;

public class TerminationPaySuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private TextView b;
  private TextView c;
  private View d;
  private Button e;
  private Button f;
  private String g;
  private String r;
  private ImageView s;
  private String t;
  private String u;
  private Handler v = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return false;
        TerminationPaySuccessActivity.this.dismissProgress();
        if (((l)paramAnonymousMessage.obj).getSuccess().booleanValue())
        {
          TerminationPaySuccessActivity.this.showToast("您已经评价过了!");
        }
        else
        {
          paramAnonymousMessage = new Intent(TerminationPaySuccessActivity.this, EvaluateActivity.class);
          paramAnonymousMessage.putExtra("contract_code", TerminationPaySuccessActivity.e(TerminationPaySuccessActivity.this));
          paramAnonymousMessage.putExtra("questionType", TerminationPaySuccessActivity.d(TerminationPaySuccessActivity.this));
          paramAnonymousMessage.putExtra("uid", TerminationPaySuccessActivity.a(TerminationPaySuccessActivity.this));
          paramAnonymousMessage.putExtra("stewardType", TerminationPaySuccessActivity.c(TerminationPaySuccessActivity.this));
          paramAnonymousMessage.putExtra("type", 2);
          TerminationPaySuccessActivity.this.startActivity(paramAnonymousMessage);
        }
      }
    }
  });
  private String w = null;
  private String x = null;
  private String y = null;
  
  private void a()
  {
    this.g = getIntent().getStringExtra("backRentOrderCode");
    this.r = getIntent().getStringExtra("isFull");
    this.t = getIntent().getStringExtra("money");
    this.u = getIntent().getStringExtra("contractCode");
  }
  
  private void b()
  {
    this.d = findViewById(2131692070);
    this.c = ((TextView)findViewById(2131690909));
    this.b = ((TextView)findViewById(2131692067));
    this.s = ((ImageView)findViewById(2131692065));
    this.e = ((Button)findViewById(2131697641));
    this.f = ((Button)findViewById(2131692068));
    if ("1".equals(this.r))
    {
      this.c.setVisibility(8);
      this.f.setText("去评价管家");
      this.d.setVisibility(8);
    }
    this.b.setText(this.t);
  }
  
  private void d(final String paramString)
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString + "");
    g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.s + e.a.u).tag(this).params(localHashMap).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        TerminationPaySuccessActivity.a(TerminationPaySuccessActivity.this, "fwgj");
        TerminationPaySuccessActivity.b(TerminationPaySuccessActivity.this, "JYPJ");
        TerminationPaySuccessActivity.c(TerminationPaySuccessActivity.this, paramAnonymouse.getString("gjAccount"));
        if (TextUtils.isEmpty(TerminationPaySuccessActivity.a(TerminationPaySuccessActivity.this)))
        {
          TerminationPaySuccessActivity.this.showToast("未找到当前管家信息,无法评价!");
          return;
        }
        showProgress();
        d.checkHasEvaluate(TerminationPaySuccessActivity.b(TerminationPaySuccessActivity.this), TerminationPaySuccessActivity.this, ApplicationEx.c.getUserId(TerminationPaySuccessActivity.this), "ziroomer", TerminationPaySuccessActivity.a(TerminationPaySuccessActivity.this), TerminationPaySuccessActivity.c(TerminationPaySuccessActivity.this), TerminationPaySuccessActivity.d(TerminationPaySuccessActivity.this), paramString);
      }
    });
  }
  
  private void e()
  {
    this.s.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public void onBackPressed() {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131697641: 
    case 2131692068: 
      do
      {
        return;
        paramView = new Intent(getApplicationContext(), MainActivity.class);
        paramView.putExtra("FRAGMENT_TYPE", 4);
        startActivity(paramView);
        return;
        if ("支付剩余款项".equals(this.f.getText().toString()))
        {
          paramView = new Intent(getApplicationContext(), TerminationPayActivity.class);
          paramView.putExtra("backRentOrderCode", this.g);
          startActivity(paramView);
          return;
        }
      } while (!"去评价管家".equals(this.f.getText().toString()));
      d(this.u);
      return;
    }
    startActivity(new Intent(this.a, MainActivity.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905168);
    this.a = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/TerminationPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */