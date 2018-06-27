package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class CertInformationAuditActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  @BindView(2131690106)
  TextView content_text;
  private String d;
  @BindView(2131689533)
  TextView title;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("title");
    this.d = getIntent().getStringExtra("content");
    if (ae.notNull(this.c)) {
      this.title.setText(this.c);
    }
    while (ae.notNull(this.d))
    {
      this.content_text.setText(this.d);
      return;
      this.title.setVisibility(8);
    }
    this.content_text.setVisibility(8);
  }
  
  @OnClick({2131690105})
  public void onClic(View paramView)
  {
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
    setContentView(2130903124);
    this.b = this;
    this.a = ButterKnife.bind(this);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/CertInformationAuditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */