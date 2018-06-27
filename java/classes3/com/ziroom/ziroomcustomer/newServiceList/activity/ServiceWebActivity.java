package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@com.maa.android.agent.instrumentation.Instrumented
public class ServiceWebActivity
  extends BaseActivity
{
  private Context a;
  private WebView b;
  private String c;
  private TextView d;
  
  private void a()
  {
    this.b = ((WebView)findViewById(2131690681));
    this.d = ((TextView)findViewById(2131689541));
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ServiceWebActivity.this.finish();
      }
    });
    String str = getIntent().getStringExtra("title_name");
    if (!TextUtils.isEmpty(str)) {
      this.d.setText(str);
    }
    this.c = getIntent().getStringExtra("url");
    setWeb(this.c);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903190);
    this.a = this;
    a();
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.onResume();
  }
  
  public void setWeb(String paramString)
  {
    this.b.setWebViewClient(new WebViewClient()
    {
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
    this.b.setInitialScale(1);
    Object localObject = this.b.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setSupportZoom(true);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setDisplayZoomControls(false);
    this.b.getSettings().setCacheMode(2);
    localObject = this.b;
    if (!(localObject instanceof WebView))
    {
      ((WebView)localObject).loadUrl(paramString);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localObject, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/ServiceWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */