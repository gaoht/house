package com.ziroom.commonlibrary.login;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.string;
import com.ziroom.commonlibrary.g.c;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText.a;

public class PassSettingActivity
  extends BaseLoginActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private final String b = "PassSettingActivity";
  private TextView c;
  private RelativeLayout d;
  private LoginLabeledEditText e;
  private LoginLabeledEditText f;
  private CheckBox g;
  private CheckBox h;
  private Button i;
  private boolean j = true;
  private boolean k;
  private int l;
  private String m;
  private String n;
  private String o;
  private String p;
  private com.ziroom.commonlibrary.a.a.b<e> q = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
      {
        paramAnonymousThrowable = ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode();
        if ("40003".equals(paramAnonymousThrowable)) {
          com.ziroom.commonlibrary.g.a.a.handleMessage(PassSettingActivity.this, paramAnonymousThrowable, PassSettingActivity.this.getString(R.string.login_msg_old_pass_error));
        }
      }
      else
      {
        return;
      }
      if ("40001".equals(paramAnonymousThrowable))
      {
        paramAnonymousThrowable = new Intent(PassSettingActivity.this, LoginActivity.class);
        PassSettingActivity.this.startActivity(paramAnonymousThrowable);
        PassSettingActivity.this.finish();
        return;
      }
      com.ziroom.commonlibrary.g.a.a.handleMessage(PassSettingActivity.this, paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (PassSettingActivity.a(PassSettingActivity.this) == 3) {
        g.textToast(PassSettingActivity.this, PassSettingActivity.this.getString(R.string.login_msg_reset_pass_success));
      }
      for (;;)
      {
        if (paramAnonymouse != null)
        {
          if ((paramAnonymouse.containsKey("uid")) && (paramAnonymouse.containsKey("token"))) {
            a.setLoginInfo(PassSettingActivity.this, paramAnonymouse.getString("token"), paramAnonymouse.getString("uid"));
          }
          Intent localIntent = new Intent("com.ziroom.commonlibrary.login.broadcast");
          localIntent.putExtra("type", 6);
          localIntent.putExtra("token", paramAnonymouse.getString("token"));
          localIntent.putExtra("uid", paramAnonymouse.getString("uid"));
          LocalBroadcastManager.getInstance(PassSettingActivity.this).sendBroadcast(localIntent);
        }
        return;
        g.textToast(PassSettingActivity.this, PassSettingActivity.this.getString(R.string.login_msg_modify_pass_success));
      }
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> r = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(PassSettingActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null)
      {
        if ((paramAnonymouse.containsKey("uid")) && (paramAnonymouse.containsKey("token"))) {
          a.setLoginInfo(PassSettingActivity.this, paramAnonymouse.getString("token"), paramAnonymouse.getString("uid"));
        }
        g.textToast(PassSettingActivity.this, PassSettingActivity.this.getString(R.string.login_msg_register_success));
        Intent localIntent = new Intent("com.ziroom.commonlibrary.login.broadcast");
        localIntent.putExtra("type", 2);
        localIntent.putExtra("token", paramAnonymouse.getString("token"));
        localIntent.putExtra("uid", paramAnonymouse.getString("uid"));
        LocalBroadcastManager.getInstance(PassSettingActivity.this).sendBroadcast(localIntent);
      }
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> s = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(PassSettingActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      PassSettingActivity.this.finish();
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (!TextUtils.isEmpty(PassSettingActivity.b(PassSettingActivity.this)))
      {
        PassSettingActivity.this.a("boundphone_pass_finish");
        g.textToast(PassSettingActivity.this, PassSettingActivity.this.getString(R.string.login_msg_bind_phone_success));
      }
      for (;;)
      {
        paramAnonymouse = new Intent("com.ziroom.commonlibrary.login.broadcast");
        paramAnonymouse.putExtra("type", 3);
        LocalBroadcastManager.getInstance(PassSettingActivity.this).sendBroadcast(paramAnonymouse);
        return;
        if (!TextUtils.isEmpty(PassSettingActivity.c(PassSettingActivity.this)))
        {
          PassSettingActivity.this.a("boundmail_pass_finish");
          g.textToast(PassSettingActivity.this, PassSettingActivity.this.getString(R.string.login_msg_bind_email_success));
        }
      }
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> t = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(PassSettingActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      PassSettingActivity.this.finish();
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      g.textToast(PassSettingActivity.this, PassSettingActivity.this.getString(R.string.login_msg_set_username_pass_success));
      paramAnonymouse = new Intent("com.ziroom.commonlibrary.login.broadcast");
      paramAnonymouse.putExtra("type", 5);
      LocalBroadcastManager.getInstance(PassSettingActivity.this).sendBroadcast(paramAnonymouse);
      PassSettingActivity.this.finish();
    }
  };
  private LoginLabeledEditText.a u = new LoginLabeledEditText.a()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      PassSettingActivity localPassSettingActivity = PassSettingActivity.this;
      boolean bool;
      if (paramAnonymousEditable.length() <= 0)
      {
        bool = true;
        PassSettingActivity.a(localPassSettingActivity, bool);
        if (!PassSettingActivity.d(PassSettingActivity.this)) {
          break label81;
        }
        PassSettingActivity.e(PassSettingActivity.this).setVisibility(8);
      }
      for (;;)
      {
        if ((!PassSettingActivity.f(PassSettingActivity.this)) && (!PassSettingActivity.d(PassSettingActivity.this))) {
          break label95;
        }
        PassSettingActivity.g(PassSettingActivity.this).setEnabled(false);
        return;
        bool = false;
        break;
        label81:
        PassSettingActivity.e(PassSettingActivity.this).setVisibility(0);
      }
      label95:
      PassSettingActivity.g(PassSettingActivity.this).setEnabled(true);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private LoginLabeledEditText.a v = new LoginLabeledEditText.a()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      PassSettingActivity localPassSettingActivity = PassSettingActivity.this;
      boolean bool;
      if (paramAnonymousEditable.length() <= 0)
      {
        bool = true;
        PassSettingActivity.b(localPassSettingActivity, bool);
        if (!PassSettingActivity.f(PassSettingActivity.this)) {
          break label81;
        }
        PassSettingActivity.h(PassSettingActivity.this).setVisibility(8);
      }
      for (;;)
      {
        if ((!PassSettingActivity.f(PassSettingActivity.this)) && (!PassSettingActivity.d(PassSettingActivity.this))) {
          break label95;
        }
        PassSettingActivity.g(PassSettingActivity.this).setEnabled(false);
        return;
        bool = false;
        break;
        label81:
        PassSettingActivity.h(PassSettingActivity.this).setVisibility(0);
      }
      label95:
      PassSettingActivity.g(PassSettingActivity.this).setEnabled(true);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  protected void a()
  {
    super.a();
    this.c = ((TextView)findViewById(R.id.tv_title));
    this.e = ((LoginLabeledEditText)findViewById(R.id.llet_pass));
    this.g = ((CheckBox)findViewById(R.id.cb_pass_visible));
    this.i = ((Button)findViewById(R.id.btn));
    Intent localIntent = getIntent();
    this.l = localIntent.getIntExtra("PassSettingActivity_type", 0);
    this.p = c.getToken(this);
    this.m = localIntent.getStringExtra("PassSettingActivity_phone");
    this.n = localIntent.getStringExtra("PassSettingActivity_email");
    this.o = localIntent.getStringExtra("PassSettingActivity_username");
    this.e.addTextChangedListener(this.u);
    switch (this.l)
    {
    default: 
      finish();
      throw new RuntimeException("PassSettingActivity：缺少或不存在此种启动类型！");
    case 5: 
    case 8: 
      this.c.setText(getResources().getText(R.string.login_title_set_pass));
      this.e.setTopHint("密码");
      this.e.setBottomHint("请输入密码");
      this.i.setText(getResources().getText(R.string.login_pass_resetting_login));
    }
    for (;;)
    {
      this.g.setChecked(false);
      this.g.setOnCheckedChangeListener(this);
      this.i.setEnabled(false);
      return;
      this.c.setText(getResources().getText(R.string.login_title_set_pass));
      this.e.setTopHint("密码");
      this.e.setBottomHint("请输入密码");
      this.i.setText(getResources().getText(R.string.finish));
      continue;
      this.c.setText(getResources().getText(R.string.login_title_reset_pass));
      this.e.setTopHint("新密码");
      this.e.setBottomHint("请输入新密码");
      this.i.setText(getResources().getText(R.string.finish));
      continue;
      this.c.setText(getResources().getText(R.string.login_title_reset_pass));
      this.e.setTopHint("新密码");
      this.e.setBottomHint("请输入新密码");
      this.i.setText(getResources().getText(R.string.login_pass_resetting_login));
      continue;
      if (TextUtils.isEmpty(this.p))
      {
        com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
        finish();
        return;
      }
      this.k = true;
      this.d = ((RelativeLayout)findViewById(R.id.rl_pass_old));
      this.d.setVisibility(0);
      this.f = ((LoginLabeledEditText)findViewById(R.id.llet_pass_old));
      this.h = ((CheckBox)findViewById(R.id.cb_pass_old_visible));
      this.c.setText(getResources().getText(R.string.login_title_modify_pass));
      this.f.setTopHint("原密码");
      this.f.setBottomHint("请输入原密码");
      this.e.setTopHint("新密码");
      this.e.setBottomHint("请输入新密码");
      this.f.addTextChangedListener(this.v);
      this.h.setChecked(false);
      this.h.setOnCheckedChangeListener(this);
      this.i.setText(getResources().getText(R.string.finish));
    }
  }
  
  public void onBtnClick(View paramView)
  {
    if (paramView.getId() == R.id.btn)
    {
      paramView = this.e.getText().toString();
      switch (this.l)
      {
      }
    }
    String str1;
    do
    {
      String str2;
      do
      {
        do
        {
          return;
          if (!com.ziroom.commonlibrary.g.b.verifyPass(paramView))
          {
            g.textToast(this, getString(R.string.login_msg_pass_invalid));
            return;
          }
          str1 = getIntent().getStringExtra("ValidateCodeActivity_vid");
          com.ziroom.commonlibrary.d.a.resetPassword(this, this.m, this.n, str1, paramView, this.q);
          return;
          a("login_newpass_finish");
          if (!com.ziroom.commonlibrary.g.b.verifyPass(paramView))
          {
            g.textToast(this, getString(R.string.login_msg_pass_invalid));
            return;
          }
          str1 = a.getToken(this);
          if (TextUtils.isEmpty(str1))
          {
            com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
            return;
          }
          str2 = getIntent().getStringExtra("ValidateCodeActivity_vid");
          if (!TextUtils.isEmpty(this.m))
          {
            com.ziroom.commonlibrary.d.a.modifyPasswordV2(this, 1, str2, paramView, str1, this.q);
            return;
          }
        } while (TextUtils.isEmpty(this.n));
        com.ziroom.commonlibrary.d.a.modifyPasswordV2(this, 2, str2, paramView, str1, this.q);
        return;
        if (!com.ziroom.commonlibrary.g.b.verifyPass(paramView))
        {
          g.textToast(this, getString(R.string.login_msg_new_pass_invalid));
          return;
        }
        str1 = this.f.getText().toString();
        if (paramView.equals(str1))
        {
          g.textToast(this, getString(R.string.login_msg_pass_same));
          return;
        }
        if (TextUtils.isEmpty(this.p))
        {
          com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
          return;
        }
        com.ziroom.commonlibrary.d.a.modifyPassword(this, str1, paramView, this.p, this.q);
        return;
        a("phone_register_loginpass_finish");
        if (!com.ziroom.commonlibrary.g.b.verifyPass(paramView))
        {
          g.textToast(this, getString(R.string.login_msg_pass_invalid));
          return;
        }
        str1 = getIntent().getStringExtra("ValidateCodeActivity_vid");
        com.ziroom.commonlibrary.d.a.register(this, this.m, this.n, paramView, str1, this.r);
        return;
        if (!com.ziroom.commonlibrary.g.b.verifyPass(paramView))
        {
          g.textToast(this, getString(R.string.login_msg_pass_invalid));
          return;
        }
        str1 = a.getToken(getApplicationContext());
        str2 = getIntent().getStringExtra("ValidateCodeActivity_vid");
        if (TextUtils.isEmpty(str1))
        {
          com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
          return;
        }
        if (!TextUtils.isEmpty(this.m))
        {
          com.ziroom.commonlibrary.d.a.bindPhone(this, this.m, paramView, str2, str1, this.s);
          return;
        }
      } while (TextUtils.isEmpty(this.n));
      com.ziroom.commonlibrary.d.a.bindEmail(this, this.n, paramView, str2, str1, this.s);
      return;
      if (!com.ziroom.commonlibrary.g.b.verifyPass(paramView))
      {
        g.textToast(this, getString(R.string.login_msg_pass_invalid));
        return;
      }
      str1 = a.getToken(getApplicationContext());
      if (TextUtils.isEmpty(str1))
      {
        com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
        return;
      }
    } while (TextUtils.isEmpty(this.o));
    com.ziroom.commonlibrary.d.a.setUsernamePass(this, this.o, paramView, str1, this.t);
  }
  
  @Instrumented
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
    LoginLabeledEditText localLoginLabeledEditText = null;
    if (paramCompoundButton.getId() == R.id.cb_pass_visible)
    {
      localLoginLabeledEditText = this.e;
      if (localLoginLabeledEditText != null)
      {
        if (!paramBoolean) {
          break label81;
        }
        localLoginLabeledEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        paramCompoundButton.setText("隐藏");
      }
    }
    for (;;)
    {
      localLoginLabeledEditText.postInvalidate();
      localLoginLabeledEditText.setSelection(localLoginLabeledEditText.getText().length());
      return;
      if (paramCompoundButton.getId() != R.id.cb_pass_old_visible) {
        break;
      }
      localLoginLabeledEditText = this.f;
      break;
      label81:
      localLoginLabeledEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      paramCompoundButton.setText("显示");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(4);
    setContentView(R.layout.activity_pass_settting);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/PassSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */