package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class OwnerConfirmSuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  Unbinder a;
  private String b;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131691989)
  TextView btnBackOwnerZoon;
  private String c;
  private String d;
  @BindView(2131691986)
  SimpleDraweeView sdvResultIcon;
  @BindView(2131691988)
  TextView tvResultDesc;
  @BindView(2131691987)
  TextView tvResultTitle;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    this.b = getIntent().getStringExtra("pageTitle");
    this.c = getIntent().getStringExtra("title");
    this.d = getIntent().getStringExtra("content");
  }
  
  public void initData() {}
  
  public void initView()
  {
    this.btnBack.setOnClickListener(this);
    if (!ae.isNull(this.b)) {
      this.tvTitle.setText(this.b);
    }
    if (!ae.isNull(this.c)) {
      this.tvResultTitle.setText(this.c);
    }
    if (!ae.isNull(this.d)) {
      this.tvResultDesc.setText(this.d);
    }
  }
  
  public void onBackPressed()
  {
    setResult(999);
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903402);
    this.a = ButterKnife.bind(this);
    a();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131691989})
  public void onViewClicked()
  {
    startActivity(new Intent(this, OwnerZoneActivity.class));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerConfirmSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */