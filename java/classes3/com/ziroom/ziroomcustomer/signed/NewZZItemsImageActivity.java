package com.ziroom.ziroomcustomer.signed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class NewZZItemsImageActivity
  extends BaseActivity
{
  private String a;
  private Unbinder b;
  @BindView(2131697098)
  SimpleDraweeView img;
  
  @OnClick({2131697098})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904984);
    this.b = ButterKnife.bind(this);
    this.a = getIntent().getStringExtra("imgUrl");
    this.a = "http://qidian.qpic.cn/qdbimg/349573/1003447582/180";
    this.img.setController(c.frescoController(this.a));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZItemsImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */