package com.ziroom.ziroomcustomer.payment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.d.b;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;

@com.maa.android.agent.instrumentation.Instrumented
public class UnionDKPayNoticeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private WebView a;
  private Button b;
  private String c = "";
  private Boolean d = Boolean.valueOf(false);
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setMiddleText("代扣说明");
    localCommonTitle.setLeftButtonType(2);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UnionDKPayNoticeActivity.this.finish();
      }
    });
  }
  
  private void b()
  {
    setContentView(2130903537);
    this.a = ((WebView)findViewById(2131690928));
    this.b = ((Button)findViewById(2131692611));
    this.c = getIntent().getStringExtra("contractCode");
    this.d = Boolean.valueOf(getIntent().getBooleanExtra("isBandUnionDKContract", false));
  }
  
  private void d(String paramString)
  {
    if (paramString.isEmpty()) {
      return;
    }
    if (this.d.booleanValue()) {
      this.b.setVisibility(8);
    }
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.getSettings().setLoadWithOverviewMode(true);
    this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    this.a.getSettings().setDefaultFontSize(18);
    WebView localWebView = this.a;
    if (!(localWebView instanceof WebView)) {
      localWebView.loadDataWithBaseURL(null, paramString, "text/html", "utf-8", null);
    }
    for (;;)
    {
      this.a.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          UnionDKPayNoticeActivity.a(UnionDKPayNoticeActivity.this).setEnabled(true);
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (!(paramAnonymousWebView instanceof WebView)) {
            paramAnonymousWebView.loadUrl(paramAnonymousString);
          }
          for (;;)
          {
            return true;
            WebviewInstrumentation.loadUrl((WebView)paramAnonymousWebView, paramAnonymousString);
          }
        }
      });
      return;
      WebviewInstrumentation.loadDataWithBaseURL((WebView)localWebView, null, paramString, "text/html", "utf-8", null);
    }
  }
  
  private void e()
  {
    this.b.setOnClickListener(this);
  }
  
  private void f()
  {
    b.getUnionPayNoticeResult(this, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = (String)com.alibaba.fastjson.e.parseObject(paramAnonymousString).get("htmlStr");
        UnionDKPayNoticeActivity.a(UnionDKPayNoticeActivity.this, paramAnonymousString);
      }
    });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 3)
    {
      setResult(3);
      finish();
    }
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this, UnionDKAddBandCardActivity.class);
    paramView.putExtra("contractCode", this.c);
    paramView.putExtra("isSingle", false);
    startActivityForResult(paramView, 2);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    e();
    a();
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/UnionDKPayNoticeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */