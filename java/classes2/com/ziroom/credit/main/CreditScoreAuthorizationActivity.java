package com.ziroom.credit.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.router.activityrouter.Routers;

public class CreditScoreAuthorizationActivity
  extends CreditBaseActivity
  implements View.OnClickListener, u.b
{
  private Button d;
  private TextView e;
  private CheckBox f;
  private boolean g = false;
  
  public void AuthorizationSuccess(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.g)
      {
        setResult(-1);
        finish();
      }
    }
    else {
      return;
    }
    Routers.open(this, "ziroomCustomer://zrCreditModule/homeView");
    finish();
  }
  
  protected int c()
  {
    return R.layout.credit_activity_score_authorization;
  }
  
  protected void d()
  {
    setTitleText("自如分授权");
    this.d = ((Button)findViewById(R.id.credit_btn_open));
    this.e = ((TextView)findViewById(R.id.credit_tv_message));
    this.f = ((CheckBox)findViewById(R.id.credit_cb_agree));
    if (getIntent().getIntExtra("CreditStatic", 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      this.d.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
          CreditScoreAuthorizationActivity.a(CreditScoreAuthorizationActivity.this).setEnabled(paramAnonymousBoolean);
        }
      });
      return;
    }
  }
  
  protected u.a e()
  {
    return new v(this);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  protected void initData() {}
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = paramView.getId();
    if (i == R.id.credit_btn_open) {
      ((v)this.a).gotoAuthorization();
    }
    while ((i == R.id.credit_cb_agree) || (i != R.id.credit_tv_message)) {
      return;
    }
    ((v)this.a).getAgreeUrl();
  }
  
  public void setAgreeUrl(String paramString)
  {
    Routers.open(this, "ziroomCustomer://zrRentModule/h5WJFunction?url=" + paramString + "&title=自如服务信用协议");
  }
  
  public void setPresenter(u.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditScoreAuthorizationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */