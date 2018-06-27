package com.ziroom.credit.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.ziroomhttp.a;
import com.ziroom.credit.R.anim;
import com.ziroom.credit.R.id;
import com.ziroom.credit.view.CreditCommonTitle;

public abstract class CreditBaseActivity<T extends b>
  extends FragmentActivity
{
  protected T a;
  protected FragmentActivity b;
  protected CreditCommonTitle c;
  
  protected void a()
  {
    this.c = ((CreditCommonTitle)findViewById(R.id.credit_commonTitle));
    if (this.c != null)
    {
      this.c.setLeftButtonType(0);
      this.c.showRightText(false, null);
      this.c.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CreditBaseActivity.this.finish();
        }
      });
    }
  }
  
  protected abstract T b();
  
  protected abstract int c();
  
  protected abstract void d();
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("animition", true)) {
      overridePendingTransition(R.anim.credit_push_left_in, R.anim.credit_push_left_out);
    }
  }
  
  protected abstract void initData();
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    requestWindowFeature(13);
    super.onCreate(paramBundle);
    setContentView(c());
    this.b = this;
    this.a = b();
    a();
    d();
    initData();
    getWindow().setSoftInputMode(3);
    setRequestedOrientation(1);
  }
  
  protected void onDestroy()
  {
    a.cancel(this);
    if (this.a != null) {
      this.a.detachView();
    }
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
  
  protected void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.start();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null)) {
      return ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTitleText(String paramString)
  {
    setTitleText(paramString, true);
  }
  
  public void setTitleText(String paramString, boolean paramBoolean)
  {
    if (this.c != null)
    {
      if (!paramBoolean) {
        break label28;
      }
      this.c.setLeftButtonType(0);
    }
    for (;;)
    {
      this.c.setMiddleText(paramString);
      return;
      label28:
      this.c.setLeftButtonType(3);
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    if (getIntent().getBooleanExtra("animition", true)) {
      overridePendingTransition(R.anim.credit_push_right_in, R.anim.credit_push_right_out);
    }
  }
  
  public void startActivityAndFinish(Intent paramIntent)
  {
    startActivity(paramIntent);
    super.finish();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
    if (getIntent().getBooleanExtra("animition", true)) {
      overridePendingTransition(R.anim.credit_push_right_in, R.anim.credit_push_right_out);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/base/CreditBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */