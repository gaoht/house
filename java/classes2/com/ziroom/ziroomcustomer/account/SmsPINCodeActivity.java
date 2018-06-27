package com.ziroom.ziroomcustomer.account;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;

public class SmsPINCodeActivity
  extends Activity
  implements View.OnClickListener, GridPasswordView.a
{
  private TextView a;
  private TextView b;
  private TextView c;
  private GridPasswordView d;
  private TextView e;
  private String f;
  private String g;
  private String h;
  private final int i = 1;
  private final int j = 60;
  private final int k = 1000;
  private Handler l = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.arg1 > 0)
      {
        SmsPINCodeActivity.b(SmsPINCodeActivity.this).setText(paramAnonymousMessage.arg1 + SmsPINCodeActivity.a(SmsPINCodeActivity.this));
        Message localMessage = obtainMessage(1);
        int i = paramAnonymousMessage.arg1 - 1;
        paramAnonymousMessage.arg1 = i;
        localMessage.arg1 = i;
        sendMessageDelayed(localMessage, 1000L);
        return;
      }
      SmsPINCodeActivity.b(SmsPINCodeActivity.this).setText(SmsPINCodeActivity.c(SmsPINCodeActivity.this));
      SmsPINCodeActivity.b(SmsPINCodeActivity.this).setOnClickListener(SmsPINCodeActivity.this);
    }
  };
  
  private void a()
  {
    this.c.setOnClickListener(null);
    this.l.removeMessages(1);
    Message localMessage = this.l.obtainMessage(1);
    localMessage.arg1 = 60;
    localMessage.sendToTarget();
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(com.ziroom.commonlibrary.login.a.getToken(this))) {
      return;
    }
    com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == 2131690416)
    {
      a();
      if (TextUtils.isEmpty(com.ziroom.commonlibrary.login.a.getToken(this))) {}
    }
    else
    {
      return;
    }
    com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903507);
    getIntent();
    this.h = ApplicationEx.c.getUser().getLogin_name_mobile();
    this.a = ((TextView)findViewById(2131689822));
    this.b = ((TextView)findViewById(2131691707));
    this.c = ((TextView)findViewById(2131690416));
    this.d = ((GridPasswordView)findViewById(2131691708));
    this.e = ((TextView)findViewById(2131689835));
    this.f = getResources().getString(2131296985);
    this.g = getResources().getString(2131296984);
    this.a.setText(getResources().getString(2131297021));
    this.b.setText(this.h + "");
    this.e.setText(getString(2131297023));
    a();
    if (!TextUtils.isEmpty(com.ziroom.commonlibrary.login.a.getToken(this))) {}
    for (;;)
    {
      this.d.setPasswordVisibility(true);
      this.d.setOnPasswordChangedListener(this);
      this.d.performClick();
      return;
      com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.l.removeMessages(1);
  }
  
  public void onInputFinish(String paramString)
  {
    a(paramString);
  }
  
  public void onTextChanged(String paramString) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/SmsPINCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */