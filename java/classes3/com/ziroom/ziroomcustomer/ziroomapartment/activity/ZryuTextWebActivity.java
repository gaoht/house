package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;

public class ZryuTextWebActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private String c;
  @BindView(2131689781)
  ImageView iv_hw_back;
  @BindView(2131689545)
  ScrollBridgeWebView webview;
  
  @OnClick({2131689781})
  @com.growingio.android.sdk.instrumentation.Instrumented
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
    setContentView(2130903620);
    this.a = ButterKnife.bind(this);
    this.b = this;
    this.c = getIntent().getStringExtra("contractId");
    j.zryuContractWebText(this.b, this.c, new c(this, new f(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        ScrollBridgeWebView localScrollBridgeWebView;
        if (paramAnonymouse != null)
        {
          localScrollBridgeWebView = ZryuTextWebActivity.this.webview;
          paramAnonymouse = paramAnonymouse.getString("contractPage");
          if (!(localScrollBridgeWebView instanceof WebView)) {
            localScrollBridgeWebView.loadDataWithBaseURL("", paramAnonymouse, "text/html", "UTF-8", "");
          }
        }
        else
        {
          return;
        }
        WebviewInstrumentation.loadDataWithBaseURL((WebView)localScrollBridgeWebView, "", paramAnonymouse, "text/html", "UTF-8", "");
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuTextWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */