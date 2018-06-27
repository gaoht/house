package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;
import com.ziroom.ziroomcustomer.webview.d;

@com.maa.android.agent.instrumentation.Instrumented
public class ZryuCircleSeeHouseActivity
  extends BaseActivity
{
  protected ScrollBridgeWebView a;
  private d b;
  private String c = "http://www.ziroom.com/zhuanti/zr_inn/";
  
  private void a()
  {
    this.c = getIntent().getStringExtra("fPanoramicUrl");
    findViewById(2131691035).setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZryuCircleSeeHouseActivity.this.finish();
      }
    });
    this.a = ((ScrollBridgeWebView)findViewById(2131689545));
    this.b = new d(this);
    ScrollBridgeWebView localScrollBridgeWebView = this.a;
    d locald = this.b;
    if (!(localScrollBridgeWebView instanceof WebView))
    {
      localScrollBridgeWebView.setWebChromeClient(locald);
      return;
    }
    VdsAgent.setWebChromeClient((WebView)localScrollBridgeWebView, locald);
  }
  
  private void b()
  {
    ScrollBridgeWebView localScrollBridgeWebView = this.a;
    String str = this.c;
    if (!(localScrollBridgeWebView instanceof WebView))
    {
      localScrollBridgeWebView.loadUrl(str);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localScrollBridgeWebView, str);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905247);
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuCircleSeeHouseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */