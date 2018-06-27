package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@com.maa.android.agent.instrumentation.Instrumented
public class StationWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView a;
  private WebView b;
  private View c;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131689541));
    this.b = ((WebView)findViewById(2131689860));
    this.c = findViewById(2131690078);
  }
  
  private void b()
  {
    this.c.setOnClickListener(this);
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
    WebSettings localWebSettings = this.b.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setDisplayZoomControls(false);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.densityDpi;
    if (i == 240) {
      localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
    }
    for (;;)
    {
      localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
      this.b.setDownloadListener(new a(null));
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setJavaScriptCanOpenWindowsAutomatically(false);
      localWebSettings.setCacheMode(2);
      return;
      if (i == 160) {
        localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
      } else if (i == 120) {
        localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
      } else if (i == 320) {
        localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
      } else if (i == 213) {
        localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
      } else {
        localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
      }
    }
  }
  
  private void e()
  {
    String str;
    WebView localWebView;
    if (getIntent().getExtras() != null)
    {
      str = getIntent().getExtras().getString("title", "自如驿");
      this.a.setText(str);
      str = getIntent().getExtras().getString("url", "");
      localWebView = this.b;
      if (!(localWebView instanceof WebView)) {
        localWebView.loadUrl(str);
      }
    }
    else
    {
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localWebView, str);
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
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
    setContentView(2130903523);
    a();
    b();
    e();
  }
  
  protected void onResume()
  {
    String str;
    int i;
    if (this.a != null)
    {
      str = this.a.getText().toString();
      i = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      super.onResume();
      return;
      if (!str.equals("入住与退款规则")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("自如驿退款细则")) {
        break;
      }
      i = 1;
      break;
      a("zinn_book_agree_duration");
      continue;
      a("zinn_payback_rules_duration");
    }
  }
  
  private class a
    implements DownloadListener
  {
    private a() {}
    
    public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      StationWebActivity.this.startActivity(paramString1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */