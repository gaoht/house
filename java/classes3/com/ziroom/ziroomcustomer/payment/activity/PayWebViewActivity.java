package com.ziroom.ziroomcustomer.payment.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.ziroom.ziroomcustomer.payment.views.b;
import com.ziroom.ziroomcustomer.payment.views.b.a;

@com.maa.android.agent.instrumentation.Instrumented
public class PayWebViewActivity
  extends BaseActivity
{
  private WebView a;
  private LinearLayout b;
  private ProgressBar c;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      finish();
    }
    return false;
  }
  
  public void initViews()
  {
    setContentView(2130903211);
    final String str1 = getIntent().getStringExtra("url");
    getIntent().getStringExtra("title");
    Object localObject = getIntent().getStringExtra("orderId");
    String str2 = getIntent().getStringExtra("cwOrderId");
    this.a = ((WebView)findViewById(2131690928));
    this.b = ((LinearLayout)findViewById(2131690929));
    this.c = ((ProgressBar)findViewById(2131690188));
    this.a.getSettings().setJavaScriptEnabled(true);
    WebView localWebView = this.a;
    a locala;
    if (!(localWebView instanceof WebView))
    {
      localWebView.loadUrl(str1);
      this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
      this.a.getSettings().setUseWideViewPort(true);
      this.a.setBackgroundColor(0);
      localWebView = this.a;
      locala = new a();
      if ((localWebView instanceof WebView)) {
        break label244;
      }
      localWebView.setWebChromeClient(locala);
    }
    for (;;)
    {
      localObject = new b(this.a, this, false, (String)localObject, str2);
      this.a.setWebViewClient((WebViewClient)localObject);
      ((b)localObject).setmOnReceivedError(new b.a()
      {
        public void onReceivedError()
        {
          PayWebViewActivity.a(PayWebViewActivity.this).setVisibility(0);
          PayWebViewActivity.b(PayWebViewActivity.this).setVisibility(8);
        }
      });
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = PayWebViewActivity.b(PayWebViewActivity.this);
          String str = str1;
          if (!(paramAnonymousView instanceof WebView)) {
            paramAnonymousView.loadUrl(str);
          }
          for (;;)
          {
            PayWebViewActivity.a(PayWebViewActivity.this).setVisibility(8);
            PayWebViewActivity.b(PayWebViewActivity.this).setVisibility(0);
            return;
            WebviewInstrumentation.loadUrl((WebView)paramAnonymousView, str);
          }
        }
      });
      return;
      WebviewInstrumentation.loadUrl((WebView)localWebView, str1);
      break;
      label244:
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
          PayWebViewActivity.b(PayWebViewActivity.this).reload();
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
          PayWebViewActivity.b(PayWebViewActivity.this).reload();
        }
      });
    }
  }
  
  public void setTitle()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.showRightText(false, null);
    localCommonTitle.setMiddleText("银行卡管理");
    localCommonTitle.setLeftButtonType(2);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PayWebViewActivity.this.finish();
      }
    });
  }
  
  class a
    extends WebChromeClient
  {
    a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      PayWebViewActivity.c(PayWebViewActivity.this).setProgress(paramInt);
      if (paramInt == 100) {
        PayWebViewActivity.c(PayWebViewActivity.this).setVisibility(8);
      }
      for (;;)
      {
        super.onProgressChanged(paramWebView, paramInt);
        return;
        PayWebViewActivity.c(PayWebViewActivity.this).setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/PayWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */