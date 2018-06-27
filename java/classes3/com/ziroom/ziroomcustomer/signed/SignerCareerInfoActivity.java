package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.d.b.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.findhouse.b.d;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.signed.a.m;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignerCareerInfoActivity
  extends BaseActivity
{
  private m a;
  private String b = "";
  private Context c;
  @BindView(2131689859)
  SimpleDraweeView ivLogo;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131690073)
  TextView tvDesc;
  @BindView(2131692452)
  TextView tvRelated;
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.a = ((m)localIntent.getSerializableExtra("infoNative"));
    if (this.a == null)
    {
      String str1 = localIntent.getStringExtra("title");
      String str2 = localIntent.getStringExtra("logo");
      int i = localIntent.getIntExtra("status", 0);
      String str3 = localIntent.getStringExtra("desc");
      String str4 = localIntent.getStringExtra("link");
      this.a = new m();
      this.a.setDesc(str3);
      this.a.setLogo(str2);
      this.a.setStatus(i);
      this.a.setTitle(str1);
      this.a.setUrl(str4);
    }
    this.b = localIntent.getStringExtra("maimaiClass");
    a(this.a);
  }
  
  private void a(m paramm)
  {
    if (paramm == null) {
      return;
    }
    this.a = paramm;
    this.mBztb.setTitle(paramm.getTitle());
    this.ivLogo.setController(com.freelxl.baselibrary.f.c.frescoController(paramm.getLogo()));
    if (paramm.getStatus() == 0) {
      this.tvRelated.setText("去关联");
    }
    for (;;)
    {
      this.tvDesc.setText(paramm.getDesc());
      return;
      if (1 == paramm.getStatus()) {
        this.tvRelated.setText("解除关联");
      } else {
        this.tvRelated.setText("去关联");
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903502);
    ButterKnife.bind(this);
    this.c = this;
    a();
  }
  
  @OnClick({2131692452})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.a == null)
    {
      com.freelxl.baselibrary.f.g.textToast(this, "服务器异常，正在努力抢修中，请稍后再试!");
      return;
    }
    if (this.a.getStatus() == 0)
    {
      paramView = new Intent();
      paramView.putExtra("url", this.a.getUrl());
      paramView.putExtra("title", this.a.getTitle());
      paramView.putExtra("maimaiClass", this.b);
      paramView.setClass(this.c, CreditWebActivity.class);
      startActivity(paramView);
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this).setContent("确定要解除关联吗？").setButtonText("取消").setSecondButtonText("确认").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new HashMap();
        paramAnonymousView.put("token", com.ziroom.commonlibrary.login.a.getToken(SignerCareerInfoActivity.a(SignerCareerInfoActivity.this)));
        com.ziroom.ziroomcustomer.e.g.getCommonHouseSign(paramAnonymousView);
        com.freelxl.baselibrary.d.a.get(SignerCareerInfoActivity.b(SignerCareerInfoActivity.this).getUrl() + "?" + ah.encodeGetParams(paramAnonymousView)).tag(SignerCareerInfoActivity.this).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.a(SignerCareerInfoActivity.a(SignerCareerInfoActivity.this), new d(String.class))
        {
          public void onSuccess(int paramAnonymous2Int, List paramAnonymous2List)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2List);
            paramAnonymous2List = new Intent(SignerCareerInfoActivity.a(SignerCareerInfoActivity.this), SignerAptitudeActivity.class);
            SignerCareerInfoActivity.this.startActivity(paramAnonymous2List);
          }
        });
      }
    }).build().show();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerCareerInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */