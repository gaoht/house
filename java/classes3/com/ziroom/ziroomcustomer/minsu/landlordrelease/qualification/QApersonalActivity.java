package com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuLandlordAuthInfoActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuPhoneInputActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.a.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;

public class QApersonalActivity
  extends BaseFluxActivity
{
  String b;
  String c;
  @BindView(2131691063)
  TextView contact_status;
  @BindView(2131691061)
  RelativeLayout contact_way;
  String d;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.b e;
  private c f;
  private Unbinder g;
  @BindView(2131691065)
  RelativeLayout identity_information;
  @BindView(2131691067)
  TextView identity_status;
  @BindView(2131691069)
  RelativeLayout personal_information;
  @BindView(2131691071)
  TextView personal_status;
  private CertificationBean r;
  @BindView(2131691074)
  Button release;
  @BindView(2131691073)
  ReleaseUsageAndTipsView release_usage_tips;
  private Boolean s = Boolean.valueOf(true);
  private Intent t;
  
  private void a()
  {
    this.e = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.b(this);
    this.a.register(this.e);
    this.f = c.getInstance(this.a);
  }
  
  private void b()
  {
    this.f.getCertification(this);
  }
  
  private void d(String paramString)
  {
    if ("1".equals(paramString))
    {
      this.contact_status.setText("已完成");
      this.contact_status.setTextColor(Color.parseColor("#999999"));
      return;
    }
    this.contact_status.setText("未完成");
    this.contact_status.setTextColor(Color.parseColor("#FF6262"));
  }
  
  private void e()
  {
    if (("1".equals(this.b)) && ("1".equals(this.c)) && ("1".equals(this.d)))
    {
      this.release.setEnabled(true);
      return;
    }
    this.release.setEnabled(false);
  }
  
  private void e(String paramString)
  {
    if ("1".equals(paramString))
    {
      this.identity_status.setText("已完成");
      this.identity_status.setTextColor(Color.parseColor("#999999"));
      return;
    }
    this.identity_status.setText("未完成");
    this.identity_status.setTextColor(Color.parseColor("#FF6262"));
  }
  
  private void f(String paramString)
  {
    if ("1".equals(paramString))
    {
      this.personal_status.setText("已完成");
      this.personal_status.setTextColor(Color.parseColor("#999999"));
      return;
    }
    this.personal_status.setText("未完成");
    this.personal_status.setTextColor(Color.parseColor("#FF6262"));
  }
  
  @OnClick({2131691059, 2131691061, 2131691065, 2131691069, 2131691074})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691059: 
      finish();
      return;
    case 2131691061: 
      this.t = new Intent(this, MinsuPhoneInputActivity.class);
      startActivity(this.t);
      return;
    case 2131691065: 
      this.t = new Intent(this, MinsuLandlordAuthInfoActivity.class);
      this.t.putExtra("flag", MinsuLandlordAuthInfoActivity.b);
      startActivity(this.t);
      return;
    case 2131691069: 
      this.t = new Intent(this, PersonalActivity.class);
      startActivity(this.t);
      return;
    }
    k.toHouseRelease(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903242);
    this.g = ButterKnife.bind(this);
    a();
    this.b = getIntent().getStringExtra("isCantactAuth");
    this.c = getIntent().getStringExtra("isIdentityAuth");
    this.d = getIntent().getStringExtra("isFinishHead");
    d(this.b);
    e(this.c);
    f(this.d);
    this.release_usage_tips.setCode("TIP_WHY_AUTH");
  }
  
  protected void onDestroy()
  {
    this.g.unbind();
    this.a.unregister(this.e);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    this.r = this.e.getCertificationBean();
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("certification")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("certification_error")) {
        break;
      }
      i = 1;
      break;
    } while ((this.r == null) || (this.r.getData() == null));
    this.b = this.r.getData().getIsContactAuth();
    this.c = this.r.getData().getIsIdentityAuth();
    this.d = this.r.getData().getIsFinishHead();
    d(this.b);
    e(this.c);
    f(this.d);
    e();
    return;
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("YF", "==HOME_TODAY_ERROR==  ");
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.s.booleanValue())
    {
      this.s = Boolean.valueOf(false);
      return;
    }
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/qualification/QApersonalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */