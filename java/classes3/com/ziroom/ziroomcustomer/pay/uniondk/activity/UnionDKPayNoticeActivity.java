package com.ziroom.ziroomcustomer.pay.uniondk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayNotice;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayNotice.DataBean;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.util.u;

@com.maa.android.agent.instrumentation.Instrumented
public class UnionDKPayNoticeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private CommonTitle a;
  private WebView b;
  private Button c;
  private String d = "";
  private Boolean e = Boolean.valueOf(false);
  private Boolean f = Boolean.valueOf(false);
  
  private void a()
  {
    this.a = ((CommonTitle)findViewById(2131691272));
    this.a.setMiddleText("代扣说明");
    this.a.setLeftButtonType(2);
    this.a.setOnLeftButtonClickListener(new View.OnClickListener()
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
    this.b = ((WebView)findViewById(2131690928));
    this.c = ((Button)findViewById(2131692611));
    this.d = getIntent().getStringExtra("contractCode");
    this.e = Boolean.valueOf(getIntent().getBooleanExtra("isBandUnionCard", false));
    this.f = Boolean.valueOf(getIntent().getBooleanExtra("isBandUnionDKContract", false));
  }
  
  private void d(String paramString)
  {
    if (paramString.isEmpty()) {
      return;
    }
    if (this.f.booleanValue()) {
      this.c.setVisibility(8);
    }
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    this.b.getSettings().setDefaultFontSize(18);
    WebView localWebView = this.b;
    if (!(localWebView instanceof WebView)) {
      localWebView.loadDataWithBaseURL(null, paramString, "text/html", "utf-8", null);
    }
    for (;;)
    {
      this.b.setWebViewClient(new WebViewClient()
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
    this.c.setOnClickListener(this);
  }
  
  private void f()
  {
    showProgress("");
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayNoticeResult(this, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        u.e("yangxj----------", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        UnionDKPayNoticeActivity.this.dismissProgress();
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          paramAnonymousk = (UnionDKPayNotice)paramAnonymousk.getObject();
          if ((paramAnonymousk == null) || (paramAnonymousk.data == null)) {
            return;
          }
          if (!paramAnonymousk.isSuccess())
          {
            g.textToast(UnionDKPayNoticeActivity.this, paramAnonymousk.getError_message());
            return;
          }
          UnionDKPayNoticeActivity.a(UnionDKPayNoticeActivity.this, paramAnonymousk.data.htmlStr);
          return;
        }
        g.textToast(UnionDKPayNoticeActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      setResult(-1);
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
    paramView = new Intent(this, AddUnionDKPayBandCardActivity.class);
    paramView.putExtra("contractCode", this.d);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/activity/UnionDKPayNoticeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */