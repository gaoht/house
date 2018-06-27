package com.ziroom.ziroomcustomer.activity;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@com.maa.android.agent.instrumentation.Instrumented
public class MessageDetailActivity
  extends BaseActivity
{
  private NotificationManager a;
  private ImageView b;
  private WebView c;
  private ProgressDialog d = null;
  
  private void a()
  {
    this.a = ((NotificationManager)getSystemService("notification"));
    this.a.cancel(0);
    this.b = ((ImageView)findViewById(2131696817));
    this.c = ((WebView)findViewById(2131690928));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MessageDetailActivity.this.finish();
      }
    });
    this.c.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        MessageDetailActivity.this.dismissProgress();
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        MessageDetailActivity.this.showProgress("页面加载中，请稍后..");
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
    this.c.getSettings().setBuiltInZoomControls(true);
    this.c.getSettings().setSupportZoom(true);
    this.c.zoomOut();
    String str = getIntent().getStringExtra("content");
    if ((!str.subSequence(0, 7).equals("http://")) && (!str.subSequence(0, 8).equals("https://"))) {
      str = "http://" + str;
    }
    for (;;)
    {
      WebView localWebView = this.c;
      if (!(localWebView instanceof WebView))
      {
        localWebView.loadUrl(str);
        return;
      }
      WebviewInstrumentation.loadUrl((WebView)localWebView, str);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904877);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/MessageDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */