package com.ziroom.commonlibrary.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.commonlibrary.R.anim;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.string;

public class UsernameActivity
  extends BaseLoginActivity
{
  private EditText b;
  private Button c;
  private String d;
  private Handler e = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      UsernameActivity.b(UsernameActivity.this).requestFocus();
      paramAnonymousMessage = (InputMethodManager)UsernameActivity.this.getSystemService("input_method");
      paramAnonymousMessage.showSoftInput(UsernameActivity.b(UsernameActivity.this), 2);
      paramAnonymousMessage.toggleSoftInput(2, 1);
    }
  };
  private TextWatcher f = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() == 0)
      {
        UsernameActivity.c(UsernameActivity.this).setEnabled(false);
        return;
      }
      UsernameActivity.c(UsernameActivity.this).setEnabled(true);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private com.ziroom.commonlibrary.a.a.b<e> g = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(UsernameActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null) {
        if (!paramAnonymouse.containsKey("exist")) {
          break label51;
        }
      }
      label51:
      for (boolean bool = paramAnonymouse.getBoolean("exist").booleanValue(); bool; bool = true)
      {
        g.textToast(UsernameActivity.this, UsernameActivity.this.getString(R.string.login_msg_username_exist));
        return;
      }
      paramAnonymouse = a.getToken(UsernameActivity.this);
      if (TextUtils.isEmpty(paramAnonymouse))
      {
        com.ziroom.commonlibrary.g.a.a.handleMessage(UsernameActivity.this, "40005");
        return;
      }
      com.ziroom.commonlibrary.d.a.userInfo(UsernameActivity.this, paramAnonymouse, UsernameActivity.d(UsernameActivity.this));
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> h = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(UsernameActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      boolean bool;
      String str;
      if (paramAnonymouse != null)
      {
        bool = paramAnonymouse.containsKey("hasPassword");
        str = a.getToken(UsernameActivity.this.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
          break label47;
        }
        com.ziroom.commonlibrary.g.a.a.handleMessage(UsernameActivity.this, "40005");
      }
      label47:
      do
      {
        return;
        if ((bool) && (paramAnonymouse.getBoolean("hasPassword").booleanValue()))
        {
          com.ziroom.commonlibrary.d.a.setUsernamePass(UsernameActivity.this, UsernameActivity.e(UsernameActivity.this), null, str, UsernameActivity.f(UsernameActivity.this));
          return;
        }
      } while ((!bool) || (paramAnonymouse.getBoolean("hasPassword").booleanValue()));
      paramAnonymouse = new Intent(UsernameActivity.this, PassSettingActivity.class);
      paramAnonymouse.putExtra("PassSettingActivity_type", 7);
      paramAnonymouse.putExtra("PassSettingActivity_username", UsernameActivity.e(UsernameActivity.this));
      UsernameActivity.this.startActivity(paramAnonymouse);
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> i = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(UsernameActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      g.textToast(UsernameActivity.this, UsernameActivity.this.getString(R.string.login_msg_set_username_success));
      paramAnonymouse = new Intent("com.ziroom.commonlibrary.login.broadcast");
      paramAnonymouse.putExtra("type", 5);
      LocalBroadcastManager.getInstance(UsernameActivity.this).sendBroadcast(paramAnonymouse);
      UsernameActivity.this.finish();
    }
  };
  private BroadcastReceiver j = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      if (i == 5) {
        UsernameActivity.this.finish();
      }
      while (i != 7) {
        return;
      }
      UsernameActivity.this.dismissProgress();
      UsernameActivity.this.finish();
    }
  };
  
  protected void a()
  {
    super.a();
    this.d = getIntent().getStringExtra("username");
    this.b = ((EditText)findViewById(R.id.llet));
    this.c = ((Button)findViewById(R.id.btn));
    this.b.addTextChangedListener(this.f);
    if (!TextUtils.isEmpty(this.d)) {
      this.b.setText(this.d);
    }
    this.b.post(new Runnable()
    {
      public void run()
      {
        UsernameActivity.a(UsernameActivity.this).sendEmptyMessage(0);
      }
    });
    this.b.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          ((InputMethodManager)UsernameActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(UsernameActivity.b(UsernameActivity.this).getWindowToken(), 0);
        }
      }
    });
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.push_stay_300, R.anim.push_top_to_bottom_out);
  }
  
  public void onBtnClick(View paramView)
  {
    if (paramView.getId() == R.id.btn)
    {
      this.d = VdsAgent.trackEditTextSilent(this.b).toString().trim();
      if (com.ziroom.commonlibrary.g.b.verifyUsername(this.d)) {
        com.ziroom.commonlibrary.d.a.verifyAccount(this, null, null, this.d, this.g);
      }
    }
    else
    {
      return;
    }
    g.textToast(getApplicationContext(), getString(R.string.login_msg_username_invalid));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_username);
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.j, paramBundle);
    a();
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.j);
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/UsernameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */