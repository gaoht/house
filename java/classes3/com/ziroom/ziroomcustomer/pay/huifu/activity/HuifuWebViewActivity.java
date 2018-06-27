package com.ziroom.ziroomcustomer.pay.huifu.activity;

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
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.pay.huifu.views.a;
import com.ziroom.ziroomcustomer.pay.huifu.views.b;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;

@com.maa.android.agent.instrumentation.Instrumented
public class HuifuWebViewActivity
  extends BaseActivity
{
  private WebView a;
  private String b = "";
  private String c = "";
  private String d = "";
  private CommonTitle e;
  
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
    this.b = getIntent().getStringExtra("url");
    this.c = getIntent().getStringExtra("title");
    this.d = getIntent().getStringExtra("orderId");
    this.a = ((WebView)findViewById(2131690928));
    this.a.getSettings().setJavaScriptEnabled(true);
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    if (!(localObject1 instanceof WebView))
    {
      ((WebView)localObject1).loadUrl((String)localObject2);
      this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
      this.a.getSettings().setUseWideViewPort(true);
      this.a.setBackgroundColor(0);
      localObject1 = new a(this);
      localObject2 = this.a;
      if ((localObject2 instanceof WebView)) {
        break label187;
      }
      ((WebView)localObject2).setWebChromeClient((WebChromeClient)localObject1);
    }
    for (;;)
    {
      localObject1 = new b(this.a, this, false, this.d);
      this.a.setWebViewClient((WebViewClient)localObject1);
      return;
      WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
      break;
      label187:
      VdsAgent.setWebChromeClient((WebView)localObject2, (WebChromeClient)localObject1);
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
          HuifuWebViewActivity.a(HuifuWebViewActivity.this).reload();
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
          HuifuWebViewActivity.a(HuifuWebViewActivity.this).reload();
        }
      });
    }
  }
  
  public void setTitle()
  {
    this.e = ((CommonTitle)findViewById(2131691272));
    this.e.showRightText(false, null);
    this.e.setMiddleText("银行卡管理");
    this.e.setLeftButtonType(2);
    this.e.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HuifuWebViewActivity.this.finish();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/activity/HuifuWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */