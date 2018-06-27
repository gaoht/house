package com.ziroom.credit.main;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.b.a;
import com.ziroom.credit.base.CreditBaseActivity;

public class CreditWorkInfoActivity
  extends CreditBaseActivity
  implements View.OnClickListener, ac.b
{
  private ImageView d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  protected int c()
  {
    return R.layout.credit_activity_personal_info;
  }
  
  protected void d()
  {
    this.d = ((ImageView)findViewById(R.id.credit_iv_close));
    this.e = ((LinearLayout)findViewById(R.id.credit_ll_work_info));
    this.f = ((TextView)findViewById(R.id.credit_tv_work_name));
    this.g = ((TextView)findViewById(R.id.credit_tv_company_name));
    this.h = ((TextView)findViewById(R.id.credit_tv_company_address));
    this.d.setOnClickListener(this);
    this.e.setVisibility(0);
  }
  
  protected ac.a e()
  {
    return new ad(this);
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
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a.closeAcAnim(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == R.id.credit_iv_close) {
      onBackPressed();
    }
  }
  
  public void setCompanyAddress(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void setCompanyName(String paramString)
  {
    this.g.setText(paramString);
  }
  
  public void setPresenter(ac.a parama)
  {
    this.a = parama;
  }
  
  public void setWorkName(String paramString)
  {
    this.f.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditWorkInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */