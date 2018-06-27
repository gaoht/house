package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@com.maa.android.agent.instrumentation.Instrumented
public class ChatAndHelpNoticeActivity
  extends BaseActivity
{
  private ImageView a;
  private WebView b;
  private TextView c;
  private String d;
  private String e;
  
  private void d(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    this.b.getSettings().setDefaultFontSize(18);
    WebView localWebView = this.b;
    if (!(localWebView instanceof WebView)) {
      localWebView.loadDataWithBaseURL("file://", paramString, "text/html", "utf-8", "about:blank");
    }
    for (;;)
    {
      this.b.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
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
      WebviewInstrumentation.loadDataWithBaseURL((WebView)localWebView, "file://", paramString, "text/html", "utf-8", "about:blank");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903129);
    this.e = getIntent().getStringExtra("title");
    this.d = getIntent().getStringExtra("content");
    this.a = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131689752));
    this.b = ((WebView)findViewById(2131689860));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ChatAndHelpNoticeActivity.this.finish();
      }
    });
    this.c.setText(this.e);
    d(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/ChatAndHelpNoticeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */