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
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class ZOEvaluateExpireActivity
  extends BaseActivity
  implements View.OnClickListener
{
  Unbinder a;
  private String b;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131691834)
  TextView btnBackMyZiroom;
  private String c;
  @BindView(2131691831)
  SimpleDraweeView sdvEvaluateResultIcon;
  @BindView(2131691833)
  TextView tvMyEvaluateDesc;
  @BindView(2131691832)
  TextView tvMyEvaluateResult;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    this.b = getIntent().getStringExtra("title");
    this.c = getIntent().getStringExtra("content");
  }
  
  public void initData() {}
  
  public void initView()
  {
    this.btnBack.setOnClickListener(this);
    if (!ae.isNull(this.b)) {
      this.tvMyEvaluateResult.setText(this.b);
    }
    if (!ae.isNull(this.c)) {
      this.tvMyEvaluateDesc.setText(this.c);
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
    setContentView(2130903368);
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
  
  @OnClick({2131691834})
  public void onViewClicked()
  {
    Intent localIntent = new Intent(this, MainActivity.class);
    localIntent.putExtra("FRAGMENT_TYPE", 7);
    startActivity(localIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/ZOEvaluateExpireActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */