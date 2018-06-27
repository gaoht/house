package com.ziroom.ziroomcustomer.payment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.util.u;

@com.maa.android.agent.instrumentation.Instrumented
public class JDPayWebViewActivity
  extends BaseActivity
{
  private WebView a;
  private LinearLayout b;
  private ProgressBar c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  private void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("payType", this.e);
    localIntent.putExtra("payChanel", this.f);
    localIntent.putExtra("orderCode", this.g);
    setResult(16, localIntent);
    finish();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      a();
    }
    return false;
  }
  
  public void initViews()
  {
    setContentView(2130903211);
    final String str = getIntent().getStringExtra("url");
    this.d = getIntent().getStringExtra("title");
    this.e = getIntent().getStringExtra("payType");
    this.f = getIntent().getStringExtra("payChanel");
    this.g = getIntent().getStringExtra("orderCode");
    this.a = ((WebView)findViewById(2131690928));
    this.b = ((LinearLayout)findViewById(2131690929));
    this.c = ((ProgressBar)findViewById(2131690188));
    this.a.getSettings().setJavaScriptEnabled(true);
    WebView localWebView = this.a;
    a locala;
    if (!(localWebView instanceof WebView))
    {
      localWebView.loadUrl(str);
      this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
      this.a.getSettings().setUseWideViewPort(true);
      this.a.setBackgroundColor(0);
      localWebView = this.a;
      locala = new a();
      if ((localWebView instanceof WebView)) {
        break label236;
      }
      localWebView.setWebChromeClient(locala);
    }
    for (;;)
    {
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = JDPayWebViewActivity.a(JDPayWebViewActivity.this);
          String str = str;
          if (!(paramAnonymousView instanceof WebView)) {
            paramAnonymousView.loadUrl(str);
          }
          for (;;)
          {
            JDPayWebViewActivity.b(JDPayWebViewActivity.this).setVisibility(8);
            JDPayWebViewActivity.a(JDPayWebViewActivity.this).setVisibility(0);
            return;
            WebviewInstrumentation.loadUrl((WebView)paramAnonymousView, str);
          }
        }
      });
      this.a.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          u.e("WebView_URL", "url = " + paramAnonymousString);
        }
        
        public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          Log.e("url", "错了错了错了错了  ddd" + paramAnonymousString2 + "ddd" + paramAnonymousString1);
          JDPayWebViewActivity.b(JDPayWebViewActivity.this).setVisibility(0);
          JDPayWebViewActivity.a(JDPayWebViewActivity.this).setVisibility(8);
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
      WebviewInstrumentation.loadUrl((WebView)localWebView, str);
      break;
      label236:
      VdsAgent.setWebChromeClient((WebView)localWebView, locala);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initViews();
    setTitle();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.post(new Runnable()
      {
        public void run()
        {
          JDPayWebViewActivity.a(JDPayWebViewActivity.this).reload();
        }
      });
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.post(new Runnable()
      {
        public void run()
        {
          JDPayWebViewActivity.a(JDPayWebViewActivity.this).reload();
        }
      });
    }
  }
  
  public void setTitle()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.showRightText(false, null);
    localCommonTitle.setMiddleText(this.d);
    localCommonTitle.setLeftButtonType(2);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        JDPayWebViewActivity.d(JDPayWebViewActivity.this);
      }
    });
  }
  
  class a
    extends WebChromeClient
  {
    a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JDPayWebViewActivity.c(JDPayWebViewActivity.this).setProgress(paramInt);
      if (paramInt == 100) {
        JDPayWebViewActivity.c(JDPayWebViewActivity.this).setVisibility(8);
      }
      for (;;)
      {
        super.onProgressChanged(paramWebView, paramInt);
        return;
        JDPayWebViewActivity.c(JDPayWebViewActivity.this).setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/JDPayWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */