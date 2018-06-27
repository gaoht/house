package com.ziroom.credit.main;

import android.content.Intent;
import android.text.TextUtils;
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
import com.ziroom.credit.base.b;

public class CreditPersonalInfoActivity
  extends CreditBaseActivity
  implements View.OnClickListener
{
  private ImageView d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private TextView h;
  private LinearLayout i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private LinearLayout o;
  private TextView p;
  private TextView q;
  private TextView r;
  
  private void e()
  {
    String str1 = getIntent().getStringExtra("industryName");
    String str2 = getIntent().getStringExtra("companyName");
    String str3 = getIntent().getStringExtra("companyAddr");
    if (!TextUtils.isEmpty(str1)) {
      this.p.setText(str1);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2)) {
        this.q.setText(str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        this.r.setText(str3);
      }
      return;
      this.p.setText("暂无");
    }
  }
  
  private void f()
  {
    String str1 = getIntent().getStringExtra("degreeStr");
    String str2 = getIntent().getStringExtra("entranceDateStr");
    String str3 = getIntent().getStringExtra("graduateDateStr");
    String str4 = getIntent().getStringExtra("schoolName");
    String str5 = getIntent().getStringExtra("educationTypeStr");
    if (!TextUtils.isEmpty(str1)) {
      this.j.setText(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      this.k.setText(str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      this.l.setText(str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      this.m.setText(str4);
    }
    if (!TextUtils.isEmpty(str5)) {
      this.n.setText(str5);
    }
  }
  
  private void g()
  {
    String str1 = getIntent().getStringExtra("userName");
    String str2 = getIntent().getStringExtra("certName");
    String str3 = getIntent().getStringExtra("certificateNum");
    if (!TextUtils.isEmpty(str1)) {
      this.f.setText(str1);
    }
    this.g.setText(str2);
    if (!TextUtils.isEmpty(str3)) {
      this.h.setText(str3);
    }
  }
  
  protected b b()
  {
    return null;
  }
  
  protected int c()
  {
    return R.layout.credit_activity_personal_info;
  }
  
  protected void d()
  {
    this.d = ((ImageView)findViewById(R.id.credit_iv_close));
    this.e = ((LinearLayout)findViewById(R.id.credit_ll_identity_info));
    this.f = ((TextView)findViewById(R.id.credit_tv_identity_name));
    this.g = ((TextView)findViewById(R.id.credit_tv_identity_type));
    this.h = ((TextView)findViewById(R.id.credit_tv_identity_num));
    this.o = ((LinearLayout)findViewById(R.id.credit_ll_work_info));
    this.p = ((TextView)findViewById(R.id.credit_tv_work_name));
    this.q = ((TextView)findViewById(R.id.credit_tv_company_name));
    this.r = ((TextView)findViewById(R.id.credit_tv_company_address));
    this.i = ((LinearLayout)findViewById(R.id.credit_ll_education));
    this.j = ((TextView)findViewById(R.id.credit_tv_education_name));
    this.k = ((TextView)findViewById(R.id.credit_tv_education_start));
    this.l = ((TextView)findViewById(R.id.credit_tv_education_end));
    this.m = ((TextView)findViewById(R.id.credit_tv_school_name));
    this.n = ((TextView)findViewById(R.id.credit_tv_education_type));
    this.d.setOnClickListener(this);
  }
  
  protected void initData()
  {
    String str = getIntent().getStringExtra("type");
    if (str.equals("identity"))
    {
      this.e.setVisibility(0);
      g();
    }
    do
    {
      return;
      if (str.equals("school"))
      {
        this.i.setVisibility(0);
        f();
        return;
      }
    } while (!str.equals("work"));
    this.o.setVisibility(0);
    e();
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditPersonalInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */