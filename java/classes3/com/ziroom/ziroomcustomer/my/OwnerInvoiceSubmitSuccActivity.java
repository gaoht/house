package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;

public class OwnerInvoiceSubmitSuccActivity
  extends OwnerBaseActivity
{
  Unbinder a;
  private String b = OwnerInvoiceSubmitSuccActivity.class.getSimpleName();
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131692014)
  LinearLayout btnSeeDetail;
  private Context d;
  private String e;
  private String f;
  private String g;
  @BindView(2131691986)
  SimpleDraweeView sdvResultIcon;
  @BindView(2131691988)
  TextView tvResultDesc;
  @BindView(2131691987)
  TextView tvResultTitle;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void b()
  {
    this.g = getIntent().getStringExtra("beautyContractCode");
    this.f = getIntent().getStringExtra("hireContractCode");
    this.e = getIntent().getStringExtra("applyCode");
  }
  
  void a() {}
  
  public void initData() {}
  
  public void initView() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = this;
    setContentView(2130903412);
    this.a = ButterKnife.bind(this);
    b();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131690078, 2131692014})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this, OwnerInvoiceListActivity.class);
    paramView.putExtra("beautyContractCode", this.g);
    paramView.putExtra("hireContractCode", this.f);
    startActivity(paramView);
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceSubmitSuccActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */