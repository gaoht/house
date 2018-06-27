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

public class CreditEducationInfoActivity
  extends CreditBaseActivity
  implements View.OnClickListener, a.b
{
  private ImageView d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  
  protected int c()
  {
    return R.layout.credit_activity_personal_info;
  }
  
  protected void d()
  {
    this.d = ((ImageView)findViewById(R.id.credit_iv_close));
    this.e = ((LinearLayout)findViewById(R.id.credit_ll_education));
    this.f = ((TextView)findViewById(R.id.credit_tv_education_name));
    this.g = ((TextView)findViewById(R.id.credit_tv_education_start));
    this.h = ((TextView)findViewById(R.id.credit_tv_education_end));
    this.i = ((TextView)findViewById(R.id.credit_tv_school_name));
    this.j = ((TextView)findViewById(R.id.credit_tv_education_type));
    this.d.setOnClickListener(this);
    this.e.setVisibility(0);
  }
  
  protected a.a e()
  {
    return new b(this);
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
  
  public void setEducationEnd(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void setEducationName(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void setEducationStart(String paramString)
  {
    this.g.setText(paramString);
  }
  
  public void setEducationType(String paramString)
  {
    this.j.setText(paramString);
  }
  
  public void setPresenter(a.a parama)
  {
    this.a = parama;
  }
  
  public void setSchoolName(String paramString)
  {
    this.i.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditEducationInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */