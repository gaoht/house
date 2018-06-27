package com.ziroom.ziroomcustomer.gesturelock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;

public class LoginPwdVerifyActivity
  extends BaseActivity
{
  private String a;
  private String b;
  private String c;
  @BindView(2131691139)
  EditText edt_pwd;
  @BindView(2131695949)
  TextView myinfoTvTitle;
  @BindView(2131695950)
  TextView tv_rightButton;
  
  private void a()
  {
    this.myinfoTvTitle.setText("登录密码验证");
    this.tv_rightButton.setVisibility(8);
  }
  
  private void b()
  {
    this.c = VdsAgent.trackEditTextSilent(this.edt_pwd).toString();
    if (TextUtils.isEmpty(this.c)) {
      g.textToast(this, "密码不能为空");
    }
    String str;
    do
    {
      return;
      str = com.ziroom.commonlibrary.login.a.getToken(this);
    } while (TextUtils.isEmpty(str));
    j.delGestureLock(this, str, this.c, new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
        {
          String str = paramAnonymousThrowable.getMessage();
          paramAnonymousThrowable = str;
          if (TextUtils.isEmpty(str)) {
            paramAnonymousThrowable = "错误,请稍后重试";
          }
          g.textToast(LoginPwdVerifyActivity.this, paramAnonymousThrowable);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((LoginPwdVerifyActivity.a(LoginPwdVerifyActivity.this) != null) && (LoginPwdVerifyActivity.a(LoginPwdVerifyActivity.this).contains("MyAccountActivity")))
        {
          g.textToast(LoginPwdVerifyActivity.this, "验证成功，请设置您的手势密码");
          paramAnonymouse = new Intent(LoginPwdVerifyActivity.this, GestureLockActivity.class);
          paramAnonymouse.putExtra("type", 1);
          paramAnonymouse.setFlags(67108864);
          new com.ziroom.ziroomcustomer.gesturelock.view.a(LoginPwdVerifyActivity.this, -1).WriteStringPreference("null");
        }
        for (;;)
        {
          LoginPwdVerifyActivity.this.startActivity(paramAnonymouse);
          LoginPwdVerifyActivity.this.finish();
          return;
          try
          {
            paramAnonymouse = new Intent(LoginPwdVerifyActivity.this, Class.forName(LoginPwdVerifyActivity.b(LoginPwdVerifyActivity.this)));
            try
            {
              paramAnonymouse.putExtra("from", LoginPwdVerifyActivity.this.getClass().getName());
              paramAnonymouse.setFlags(67108864);
            }
            catch (ClassNotFoundException localClassNotFoundException1) {}
          }
          catch (ClassNotFoundException localClassNotFoundException2)
          {
            for (;;)
            {
              paramAnonymouse = null;
            }
          }
          localClassNotFoundException1.printStackTrace();
        }
      }
    });
  }
  
  @OnClick({2131695948, 2131691140})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131695948: 
      finish();
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903251);
    ButterKnife.bind(this);
    this.a = getIntent().getStringExtra("to");
    this.b = getIntent().getStringExtra("from");
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/gesturelock/LoginPwdVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */