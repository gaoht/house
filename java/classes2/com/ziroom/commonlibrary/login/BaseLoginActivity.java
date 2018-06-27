package com.ziroom.commonlibrary.login;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.widget.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.R.anim;
import com.ziroom.commonlibrary.R.id;

public class BaseLoginActivity
  extends FragmentActivity
{
  protected NotificationManager a;
  private final String b = "BaseLoginActivity";
  private BroadcastReceiver c = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      d.d("BaseLoginActivity", "====broadcastReceiver");
      switch (paramAnonymousIntent.getIntExtra("type", 0))
      {
      case 21: 
      default: 
        return;
      }
      BaseLoginActivity.this.dismissProgress();
      BaseLoginActivity.this.finish();
    }
  };
  
  protected void a()
  {
    ImageView localImageView = (ImageView)findViewById(R.id.iv_login_back);
    if (localImageView != null) {
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          BaseLoginActivity.this.finish();
        }
      });
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    MobclickAgent.onEvent(this, paramString);
  }
  
  public void dismissProgress()
  {
    if ((a.getDialog() != null) && (a.isShowing())) {
      a.dismiss();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(3);
    setRequestedOrientation(1);
    this.a = ((NotificationManager)getSystemService("notification"));
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.c, paramBundle);
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.c);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null)) {
      return ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean showProgress(String paramString)
  {
    if ((a.getDialog() != null) && (a.isShowing())) {
      a.dismiss();
    }
    a.show(this, paramString, false, true);
    return true;
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
  }
  
  public void startActivityAndFinish(Intent paramIntent)
  {
    startActivity(paramIntent);
    super.finish();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
    overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/BaseLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */