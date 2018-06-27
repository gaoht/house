package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@com.maa.android.agent.instrumentation.Instrumented
public class YouPinWebAc
  extends BaseActivity
  implements View.OnClickListener
{
  private WebView a;
  private ImageView b;
  private TextView c;
  private Context d;
  private String e;
  
  private void a()
  {
    this.d = this;
    this.a = ((WebView)findViewById(2131692732));
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131689541));
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
  }
  
  private void e()
  {
    if (checkNet(this.d))
    {
      showProgress("页面加载中，请稍候...");
      Object localObject = getIntent();
      this.e = ((Intent)localObject).getStringExtra("skipUrl");
      localObject = ((Intent)localObject).getStringExtra("title");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.c.setText((CharSequence)localObject);
      }
      setWeb(this.e);
      return;
    }
    dismissProgress();
    g.textToast(this.d, "请检查网络连接");
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
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903560);
    a();
    b();
    e();
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.onResume();
  }
  
  public void setWeb(String paramString)
  {
    this.a.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        YouPinWebAc.this.dismissProgress();
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
    this.a.setInitialScale(1);
    Object localObject = this.a.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setSupportZoom(true);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setDisplayZoomControls(false);
    this.a.getSettings().setCacheMode(1);
    localObject = this.a;
    if (!(localObject instanceof WebView))
    {
      ((WebView)localObject).loadUrl(paramString);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localObject, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinWebAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */