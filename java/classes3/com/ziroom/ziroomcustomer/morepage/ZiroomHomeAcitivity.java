package com.ziroom.ziroomcustomer.morepage;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@Instrumented
public class ZiroomHomeAcitivity
  extends BaseActivity
{
  private WebView a = null;
  
  public void back(View paramView)
  {
    setResult(2, getIntent());
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904943);
    this.a = ((WebView)findViewById(2131696929));
    this.a.setWebViewClient(new WebViewClient());
    this.a.setWebViewClient(new WebViewClient());
    this.a.getSettings().setSupportZoom(true);
    this.a.getSettings().setBuiltInZoomControls(true);
    this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
    this.a.getSettings().setUseWideViewPort(true);
    this.a.getSettings().setLoadWithOverviewMode(true);
    this.a.getSettings().setJavaScriptEnabled(true);
    paramBundle = this.a;
    if (!(paramBundle instanceof WebView))
    {
      paramBundle.loadUrl("file:///android_asset/more/ziruyoujia.html");
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)paramBundle, "file:///android_asset/more/ziruyoujia.html");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/morepage/ZiroomHomeAcitivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */