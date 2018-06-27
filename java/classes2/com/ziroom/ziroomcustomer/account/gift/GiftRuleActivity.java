package com.ziroom.ziroomcustomer.account.gift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@com.maa.android.agent.instrumentation.Instrumented
public class GiftRuleActivity
  extends BaseActivity
{
  private ImageView a;
  private WebView b;
  private String c;
  
  private void d(String paramString)
  {
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setUseWideViewPort(true);
    this.b.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    this.b.getSettings().setSupportZoom(true);
    this.b.getSettings().setBuiltInZoomControls(false);
    WebView localWebView = this.b;
    if (!(localWebView instanceof WebView))
    {
      localWebView.loadUrl(paramString);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localWebView, paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903088);
    this.c = getIntent().getStringExtra("rule");
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((WebView)findViewById(2131689860));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        GiftRuleActivity.this.finish();
      }
    });
    d(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/gift/GiftRuleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */