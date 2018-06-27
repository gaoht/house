package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.u;

@com.maa.android.agent.instrumentation.Instrumented
public class TurnSignWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private LinearLayout b;
  private TextView c;
  private TextView d;
  private WebView e;
  private ProgressBar f;
  private String g;
  private String r;
  
  private void a()
  {
    this.d = ((TextView)findViewById(2131689533));
    this.c = ((TextView)findViewById(2131697666));
    this.f = ((ProgressBar)findViewById(2131690188));
    this.e = ((WebView)findViewById(2131695910));
    this.b = ((LinearLayout)findViewById(2131690105));
    this.g = getIntent().getStringExtra("url");
    this.r = "0";
    Object localObject1 = ApplicationEx.c.getUser();
    if (localObject1 != null) {
      this.r = ((UserInfo)localObject1).getUid();
    }
    Object localObject2;
    if (this.g != null)
    {
      localObject1 = this.e;
      localObject2 = this.g;
      if (!(localObject1 instanceof WebView)) {
        ((WebView)localObject1).loadUrl((String)localObject2);
      }
    }
    else
    {
      localObject1 = this.e.getSettings();
      ((WebSettings)localObject1).setJavaScriptEnabled(true);
      ((WebSettings)localObject1).setUseWideViewPort(true);
      localObject1 = this.e;
      localObject2 = new a();
      if ((localObject1 instanceof WebView)) {
        break label243;
      }
      ((WebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
    }
    for (;;)
    {
      this.e.setLayerType(1, null);
      this.c.setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (TurnSignWebActivity.a(TurnSignWebActivity.this).canGoBack())
          {
            TurnSignWebActivity.b(TurnSignWebActivity.this).setVisibility(0);
            TurnSignWebActivity.a(TurnSignWebActivity.this).goBack();
            return;
          }
          TurnSignWebActivity.this.finish();
        }
      });
      this.e.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          u.e("WebView_URL", "url = " + paramAnonymousString);
        }
        
        public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          u.e("url", "错了错了错了错了  ddd" + paramAnonymousString2 + "ddd" + paramAnonymousString1);
          TurnSignWebActivity.a(TurnSignWebActivity.this).setVisibility(8);
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
      WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
      break;
      label243:
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
    }
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
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
    setContentView(2130905179);
    this.a = this;
    a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.e.canGoBack()))
    {
      this.c.setVisibility(0);
      this.e.goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a
    extends WebChromeClient
  {
    a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      TurnSignWebActivity.c(TurnSignWebActivity.this).setProgress(paramInt);
      if (paramInt == 100) {
        TurnSignWebActivity.c(TurnSignWebActivity.this).setVisibility(8);
      }
      for (;;)
      {
        super.onProgressChanged(paramWebView, paramInt);
        return;
        TurnSignWebActivity.c(TurnSignWebActivity.this).setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/TurnSignWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */