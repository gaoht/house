package com.ziroom.commonlibrary.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.string;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;

public class PhoneMailActivity
  extends BaseLoginActivity
{
  private final String b = "PhoneMailActivity";
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private TextView i;
  private LoginLabeledEditText j;
  private Button k;
  private TextView l;
  private TextView m;
  private LoginLabeledEditText.a n = new LoginLabeledEditText.a()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() == 0)
      {
        PhoneMailActivity.a(PhoneMailActivity.this).setEnabled(false);
        return;
      }
      PhoneMailActivity.a(PhoneMailActivity.this).setEnabled(true);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private com.ziroom.commonlibrary.a.a.b<e> o = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(PhoneMailActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null)
      {
        if ((!paramAnonymouse.containsKey("hasPhone")) || (!paramAnonymouse.getBoolean("hasPhone").booleanValue())) {
          break label254;
        }
        if ((!paramAnonymouse.containsKey("isAllowUnbind")) || (!paramAnonymouse.getBoolean("isAllowUnbind").booleanValue())) {
          break label215;
        }
        if (!paramAnonymouse.containsKey("forceCode")) {
          break label153;
        }
        str = paramAnonymouse.getString("forceCode");
        if ((!paramAnonymouse.containsKey("username")) || (paramAnonymouse.getString("username") == null)) {
          break label159;
        }
        paramAnonymouse = PhoneMailActivity.this.getString(R.string.login_msg_tip_bind_phone_a).replace("#username#", paramAnonymouse.getString("username"));
        c.newBuilder(this.b).setTitle("提示").setBtnConfirmText("继续绑定").setBtnCancelText("取消").setContent(paramAnonymouse).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean) {}
            switch (PhoneMailActivity.b(PhoneMailActivity.this))
            {
            default: 
              return;
            case 3: 
              PhoneMailActivity.a(PhoneMailActivity.this, str);
              return;
            }
            PhoneMailActivity.b(PhoneMailActivity.this, str);
          }
        }).build().show();
      }
      label153:
      label159:
      label215:
      label254:
      while ((!paramAnonymouse.containsKey("hasPhone")) || (paramAnonymouse.getBoolean("hasPhone").booleanValue()))
      {
        do
        {
          final String str;
          for (;;)
          {
            return;
            str = "";
          }
          paramAnonymouse = PhoneMailActivity.this.getString(R.string.login_msg_tip_bind_phone_b);
          c.newBuilder(this.b).setTitle("提示").setBtnConfirmText("换其他手机号").setBtnCancelText("取消").setContent(paramAnonymouse).setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean) {}
              switch (PhoneMailActivity.b(PhoneMailActivity.this))
              {
              default: 
                return;
              case 3: 
                PhoneMailActivity.a(PhoneMailActivity.this, str);
                return;
              }
              PhoneMailActivity.b(PhoneMailActivity.this, str);
            }
          }).build().show();
          return;
        } while ((!paramAnonymouse.containsKey("isAllowUnbind")) || (paramAnonymouse.getBoolean("isAllowUnbind").booleanValue()));
        g.textToast(PhoneMailActivity.this, PhoneMailActivity.this.getString(R.string.login_msg_tip_bind_phone_c));
        return;
      }
      switch (PhoneMailActivity.b(PhoneMailActivity.this))
      {
      default: 
        return;
      case 3: 
        PhoneMailActivity.a(PhoneMailActivity.this, null);
        return;
      }
      PhoneMailActivity.b(PhoneMailActivity.this, null);
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> p = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(PhoneMailActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("exist")) && (paramAnonymouse.getBoolean("exist").booleanValue())) {
        switch (PhoneMailActivity.b(PhoneMailActivity.this))
        {
        }
      }
      do
      {
        do
        {
          return;
          c.newBuilder(this.b).setTitle("提示").setContent("该手机号已注册").setBtnCancelText("知道了").setBtnConfirmText("立即登录").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean)
              {
                PhoneMailActivity.this.a("existing_account_hint_login");
                paramAnonymous2View = new Intent(PhoneMailActivity.this, LoginActivity.class);
                paramAnonymous2View.putExtra("LoginActivity_phone", PhoneMailActivity.c(PhoneMailActivity.this));
                PhoneMailActivity.this.startActivity(paramAnonymous2View);
              }
            }
          }).build().show();
          return;
          c.newBuilder(this.b).setTitle("提示").setContent("该邮箱已注册").setBtnCancelText("知道了").setBtnConfirmText("立即登录").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean)
              {
                PhoneMailActivity.this.a("existing_account_hint_login");
                paramAnonymous2View = new Intent(PhoneMailActivity.this, LoginActivity.class);
                paramAnonymous2View.putExtra("LoginActivity_phone", PhoneMailActivity.c(PhoneMailActivity.this));
                PhoneMailActivity.this.startActivity(paramAnonymous2View);
              }
            }
          }).build().show();
          return;
          PhoneMailActivity.d(PhoneMailActivity.this);
          return;
          g.textToast(PhoneMailActivity.this, PhoneMailActivity.this.getString(R.string.login_msg_bind_phone_registered));
          return;
          g.textToast(PhoneMailActivity.this, PhoneMailActivity.this.getString(R.string.login_msg_bind_email_registered));
          return;
        } while ((paramAnonymouse == null) || (!paramAnonymouse.containsKey("exist")) || (paramAnonymouse.getBoolean("exist").booleanValue()));
        switch (PhoneMailActivity.b(PhoneMailActivity.this))
        {
        case 5: 
        case 6: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        default: 
          return;
        case 1: 
          PhoneMailActivity.e(PhoneMailActivity.this);
          return;
        case 16: 
          PhoneMailActivity.f(PhoneMailActivity.this);
          return;
        case 2: 
          if (PhoneMailActivity.g(PhoneMailActivity.this) != null)
          {
            g.textToast(PhoneMailActivity.this, PhoneMailActivity.this.getString(R.string.login_msg_email_unregister));
            return;
          }
          break;
        }
      } while (PhoneMailActivity.c(PhoneMailActivity.this) == null);
      c.newBuilder(this.b).setTitle("提示").setContent("该手机号未注册").setBtnCancelText("知道了").setBtnConfirmText("直接注册").setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
        {
          if (paramAnonymous2Boolean)
          {
            paramAnonymous2View = new Intent(PhoneMailActivity.this, PhoneMailActivity.class);
            paramAnonymous2View.putExtra("PhoneMailActivity_type", 1);
            paramAnonymous2View.putExtra("PhoneMailActivity_phone", PhoneMailActivity.c(PhoneMailActivity.this));
            PhoneMailActivity.this.startActivity(paramAnonymous2View);
          }
        }
      }).build().show();
      return;
      PhoneMailActivity.a(PhoneMailActivity.this, null);
      return;
      PhoneMailActivity.h(PhoneMailActivity.this);
      return;
      PhoneMailActivity.b(PhoneMailActivity.this, null);
      return;
      PhoneMailActivity.i(PhoneMailActivity.this);
    }
  };
  
  private void b()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, VCodeActivity.class);
    localIntent1.putExtra("ValidateCodeActivity_phone", this.d);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type", 1);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type_busi", 1);
    Intent localIntent2 = new Intent();
    localIntent2.setClass(getApplicationContext(), PassSettingActivity.class);
    localIntent2.putExtra("PassSettingActivity_phone", this.d);
    localIntent2.putExtra("PassSettingActivity_type", 5);
    localIntent1.putExtra("ValidateCodeActivity_after_intent", localIntent2);
    startActivity(localIntent1);
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, VCodeActivity.class);
    localIntent.putExtra("ValidateCodeActivity_vcode_type", 1);
    localIntent.putExtra("ValidateCodeActivity_vcode_type_busi", 2);
    localIntent.putExtra("ValidateCodeActivity_phone", this.d);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("ValidateCodeActivity_force_code", paramString);
    }
    paramString = new Intent();
    paramString.setClass(getApplicationContext(), PassSettingActivity.class);
    paramString.putExtra("PassSettingActivity_phone", this.d);
    paramString.putExtra("PassSettingActivity_type", 6);
    localIntent.putExtra("ValidateCodeActivity_after_intent", paramString);
    startActivity(localIntent);
  }
  
  private void c()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, VCodeActivity.class);
    localIntent1.putExtra("ValidateCodeActivity_email", this.e);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type", 2);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type_busi", 1);
    Intent localIntent2 = new Intent();
    localIntent2.setClass(getApplicationContext(), PassSettingActivity.class);
    localIntent2.putExtra("PassSettingActivity_email", this.e);
    localIntent2.putExtra("PassSettingActivity_type", 8);
    localIntent1.putExtra("ValidateCodeActivity_after_intent", localIntent2);
    startActivity(localIntent1);
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, VCodeActivity.class);
    localIntent.putExtra("ValidateCodeActivity_vcode_type", 1);
    localIntent.putExtra("ValidateCodeActivity_vcode_type_busi", 34);
    localIntent.putExtra("ValidateCodeActivity_phone", this.d);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("ValidateCodeActivity_force_code", paramString);
    }
    startActivity(localIntent);
  }
  
  private void d()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, VCodeActivity.class);
    if (this.d != null)
    {
      localIntent1.putExtra("ValidateCodeActivity_phone", this.d);
      localIntent1.putExtra("ValidateCodeActivity_vcode_type", 1);
      localIntent1.putExtra("ValidateCodeActivity_vcode_type_busi", 3);
      localIntent2 = new Intent();
      localIntent2.setClass(getApplicationContext(), PassSettingActivity.class);
      localIntent2.putExtra("PassSettingActivity_phone", this.d);
      localIntent2.putExtra("PassSettingActivity_type", 3);
      localIntent1.putExtra("ValidateCodeActivity_after_intent", localIntent2);
      startActivity(localIntent1);
    }
    while (this.e == null) {
      return;
    }
    localIntent1.putExtra("ValidateCodeActivity_email", this.e);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type", 2);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type_busi", 3);
    Intent localIntent2 = new Intent();
    localIntent2.setClass(getApplicationContext(), PassSettingActivity.class);
    localIntent2.putExtra("PassSettingActivity_email", this.e);
    localIntent2.putExtra("PassSettingActivity_type", 3);
    localIntent1.putExtra("ValidateCodeActivity_after_intent", localIntent2);
    startActivity(localIntent1);
  }
  
  private void e()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, VCodeActivity.class);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type", 2);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type_busi", 2);
    localIntent1.putExtra("ValidateCodeActivity_email", this.e);
    Intent localIntent2 = new Intent();
    localIntent2.setClass(getApplicationContext(), PassSettingActivity.class);
    localIntent2.putExtra("PassSettingActivity_email", this.e);
    localIntent2.putExtra("PassSettingActivity_type", 6);
    localIntent1.putExtra("ValidateCodeActivity_after_intent", localIntent2);
    startActivity(localIntent1);
  }
  
  private void f()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, VCodeActivity.class);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type", 1);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type_busi", 18);
    localIntent1.putExtra("ValidateCodeActivity_phone", this.d);
    Intent localIntent2 = new Intent();
    localIntent2.setClass(getApplicationContext(), PhoneMailActivity.class);
    localIntent2.putExtra("PhoneMailActivity_phone", this.d);
    localIntent2.putExtra("PhoneMailActivity_type", 7);
    localIntent1.putExtra("ValidateCodeActivity_after_intent", localIntent2);
    startActivity(localIntent1);
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, VCodeActivity.class);
    localIntent.putExtra("ValidateCodeActivity_vcode_type", 1);
    localIntent.putExtra("ValidateCodeActivity_vcode_type_busi", 5);
    localIntent.putExtra("ValidateCodeActivity_phone", this.d);
    startActivity(localIntent);
  }
  
  private void h()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setClass(this, VCodeActivity.class);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type", 2);
    localIntent1.putExtra("ValidateCodeActivity_vcode_type_busi", 18);
    localIntent1.putExtra("ValidateCodeActivity_email", this.e);
    Intent localIntent2 = new Intent();
    localIntent2.setClass(getApplicationContext(), PhoneMailActivity.class);
    localIntent2.putExtra("PhoneMailActivity_email", this.e);
    localIntent2.putExtra("PhoneMailActivity_type", 8);
    localIntent1.putExtra("ValidateCodeActivity_after_intent", localIntent2);
    startActivity(localIntent1);
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, VCodeActivity.class);
    localIntent.putExtra("ValidateCodeActivity_vcode_type", 2);
    localIntent.putExtra("ValidateCodeActivity_vcode_type_busi", 34);
    localIntent.putExtra("ValidateCodeActivity_email", this.e);
    startActivity(localIntent);
  }
  
  protected void a()
  {
    super.a();
    Object localObject = getIntent();
    this.c = ((Intent)localObject).getIntExtra("PhoneMailActivity_type", 0);
    this.d = ((Intent)localObject).getStringExtra("PhoneMailActivity_phone");
    this.e = ((Intent)localObject).getStringExtra("PhoneMailActivity_email");
    this.i = ((TextView)findViewById(R.id.tv_title));
    this.k = ((Button)findViewById(R.id.btn));
    this.l = ((TextView)findViewById(R.id.tv_tips));
    this.j = ((LoginLabeledEditText)findViewById(R.id.llet));
    this.j.addTextChangedListener(this.n);
    switch (this.c)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
    case 1: 
    case 16: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return;
            this.j.setMaxLength(11);
            this.j.setInputType(3);
            this.i.setText("手机号注册");
            this.j.setBottomHint("请输入手机号");
            this.j.setTopHint("手机号");
            this.m = ((TextView)findViewById(R.id.tv_tips2));
            this.m.setVisibility(0);
            localObject = new SpannableString("已有账号？登录");
            i1 = "已有账号？登录".length();
            ((SpannableString)localObject).setSpan(new a(null), i1 - 2, i1, 33);
            ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFA000")), i1 - 2, i1, 33);
            this.m.setText((CharSequence)localObject);
            this.m.setMovementMethod(LinkMovementMethod.getInstance());
            this.l = ((TextView)findViewById(R.id.tv_tips));
            this.l.setVisibility(0);
            this.l.setText("邮箱注册");
          } while (TextUtils.isEmpty(this.d));
          this.j.setText(this.d);
          this.j.setSelection(this.d.length());
          return;
          this.i.setText("邮箱注册");
          this.j.setBottomHint("请输入邮箱");
          this.j.setTopHint("邮箱");
          this.m = ((TextView)findViewById(R.id.tv_tips2));
          this.m.setVisibility(0);
          localObject = new SpannableString("已有账号？登录");
          int i1 = "已有账号？登录".length();
          ((SpannableString)localObject).setSpan(new a(null), i1 - 2, i1, 33);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFA000")), i1 - 2, i1, 33);
          this.m.setText((CharSequence)localObject);
          this.m.setMovementMethod(LinkMovementMethod.getInstance());
          this.l = ((TextView)findViewById(R.id.tv_tips));
          this.l.setVisibility(0);
          this.l.setText("手机号注册");
        } while (TextUtils.isEmpty(this.e));
        this.j.setText(this.e);
        this.j.setSelection(this.e.length());
        return;
        this.i.setText(getString(R.string.login_title_forget_pass));
        this.j.setBottomHint("请输入手机号/邮箱");
        this.j.setTopHint("手机号/邮箱");
        if (!TextUtils.isEmpty(this.d))
        {
          this.j.setText(this.d);
          this.j.setSelection(this.d.length());
          return;
        }
      } while (TextUtils.isEmpty(this.e));
      this.j.setText(this.e);
      this.j.setSelection(this.e.length());
      return;
    case 3: 
      this.i.setText(getString(R.string.login_title_bind_phone));
      this.j.setMaxLength(11);
      this.j.setInputType(3);
      this.j.setTopHint("手机号");
      this.j.setBottomHint("请输入手机号");
      this.l.setVisibility(0);
      this.l.setText(getString(R.string.login_binding_phone_tip));
      return;
    case 4: 
      this.i.setText(getString(R.string.login_title_bind_email));
      this.j.setTopHint("邮箱");
      this.j.setBottomHint("请输入邮箱");
      this.l.setVisibility(0);
      this.l.setText(getString(R.string.login_binding_email_tip));
      return;
    case 7: 
      this.j.setMaxLength(11);
      this.j.setInputType(3);
      this.h = getIntent().getStringExtra("ValidateCodeActivity_vid");
      this.f = getIntent().getStringExtra("PhoneMailActivity_phone");
      this.i.setText(getString(R.string.login_title_bind_phone_new));
      this.j.setTopHint("新手机号");
      this.j.setBottomHint("请输入新手机号");
      this.l.setVisibility(0);
      this.l.setText(getString(R.string.login_modify_phone_tip));
      return;
    case 8: 
      this.h = getIntent().getStringExtra("ValidateCodeActivity_vid");
      this.g = getIntent().getStringExtra("PhoneMailActivity_email");
      this.i.setText(getString(R.string.login_title_bind_email_new));
      this.j.setTopHint("新邮箱");
      this.j.setBottomHint("请输入新邮箱");
      this.l.setVisibility(0);
      this.l.setText(getString(R.string.login_modify_email_tip));
      return;
    case 5: 
      this.i.setText(getString(R.string.login_title_bind_phone_old));
      this.j.setText(this.d);
      this.j.setEnabled(false);
      this.l.setVisibility(0);
      this.l.setText("");
      return;
    case 6: 
      this.i.setText(getString(R.string.login_title_bind_email_old));
      this.j.setText(this.e);
      this.j.setEnabled(false);
      this.l.setVisibility(0);
      this.l.setText("");
      return;
    }
    this.j.setMaxLength(11);
    this.j.setInputType(3);
    this.i.setText("验证码登录");
    this.j.setText(this.d);
    this.j.setTopHint("手机号");
    this.j.setBottomHint("请输入手机号");
    this.l.setVisibility(0);
    this.l.setText("");
    this.k.setText("获取验证码");
  }
  
  public void onBtnClick(View paramView)
  {
    if (paramView.getId() == R.id.btn) {
      switch (this.c)
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        paramView = this.j.getText().toString();
        if (this.j.isEnabled())
        {
          bool1 = h.isMobile(paramView);
          bool2 = h.isEmail(paramView);
          if ((!bool1) && ((this.c == 9) || (this.c == 3) || (this.c == 7) || (this.c == 5))) {
            g.textToast(this, getString(R.string.login_msg_phone_invalid));
          }
        }
        break;
      }
    }
    while (paramView.getId() != R.id.tv_tips)
    {
      boolean bool1;
      boolean bool2;
      for (;;)
      {
        return;
        a("click_boundphone_next");
        continue;
        a("boundmail_inputmail_next");
        continue;
        a("login_forgetpass_next");
        continue;
        a("phone_register_next");
      }
      if ((!bool2) && ((this.c == 16) || (this.c == 4) || (this.c == 8) || (this.c == 6)))
      {
        g.textToast(this, getString(R.string.login_msg_email_invalid));
        return;
      }
      if ((!bool1) && (this.c == 1))
      {
        g.textToast(this, getString(R.string.login_msg_phone_invalid));
        return;
      }
      if (bool1)
      {
        this.d = paramView;
        this.e = null;
      }
      for (;;)
      {
        switch (this.c)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        default: 
          return;
        case 1: 
        case 2: 
        case 4: 
        case 8: 
        case 16: 
          com.ziroom.commonlibrary.d.a.verifyAccount(this, this.d, this.e, null, this.p);
          return;
          if (bool2)
          {
            this.d = null;
            this.e = paramView;
          }
          else
          {
            this.d = null;
            this.e = null;
            g.textToast(this, getString(R.string.login_msg_phone_email_invalid));
            return;
            switch (this.c)
            {
            default: 
              break;
            case 5: 
              this.d = paramView;
              break;
            case 6: 
              this.e = paramView;
            }
          }
          break;
        }
      }
      f();
      return;
      h();
      return;
      paramView = a.getToken(this);
      com.ziroom.commonlibrary.d.a.accountStatus(this, this.d, paramView, this.o);
      return;
      g();
      return;
    }
    switch (this.c)
    {
    default: 
      return;
    case 1: 
      paramView = new Intent(this, PhoneMailActivity.class);
      paramView.putExtra("PhoneMailActivity_type", 16);
      startActivity(paramView);
      return;
    }
    paramView = new Intent(this, PhoneMailActivity.class);
    paramView.putExtra("PhoneMailActivity_type", 1);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(4);
    setContentView(R.layout.activity_phone_mail);
    a();
  }
  
  private class a
    extends ClickableSpan
  {
    private a() {}
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      PhoneMailActivity.this.a("login_click_existing_account_login");
      paramView = new Intent(PhoneMailActivity.this, LoginActivity.class);
      PhoneMailActivity.this.startActivity(paramView);
      PhoneMailActivity.this.finish();
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setColor(Color.parseColor("#FFFFA000"));
      paramTextPaint.bgColor = -1;
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/PhoneMailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */