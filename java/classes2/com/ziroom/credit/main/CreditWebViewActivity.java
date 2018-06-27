package com.ziroom.credit.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlib.utils.r;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.credit.view.a;
import java.net.URLDecoder;

@Instrumented
public class CreditWebViewActivity
  extends CreditBaseActivity
{
  private WebView d;
  private String e = "";
  private String f = "芝麻认证";
  
  protected com.ziroom.credit.base.b b()
  {
    return null;
  }
  
  protected int c()
  {
    return R.layout.credit_activity_web;
  }
  
  protected void d()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      this.e = ((Intent)localObject1).getStringExtra("ZiMaUrl");
      localObject1 = ((Intent)localObject1).getStringExtra("title");
      if (localObject1 != null) {
        this.f = ((String)localObject1);
      }
    }
    this.d = ((WebView)findViewById(R.id.credit_wv_web));
    this.d.getSettings().setJavaScriptEnabled(true);
    localObject1 = this.d;
    Object localObject2 = this.e;
    if (!(localObject1 instanceof WebView))
    {
      ((WebView)localObject1).loadUrl((String)localObject2);
      this.d.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
      this.d.getSettings().setUseWideViewPort(true);
      this.d.setBackgroundColor(0);
      localObject1 = new a(this);
      localObject2 = this.d;
      if ((localObject2 instanceof WebView)) {
        break label181;
      }
      ((WebView)localObject2).setWebChromeClient((WebChromeClient)localObject1);
    }
    for (;;)
    {
      localObject1 = new com.ziroom.credit.view.b(this.d, this);
      this.d.setWebViewClient((WebViewClient)localObject1);
      setTitleText(this.f);
      return;
      WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
      break;
      label181:
      VdsAgent.setWebChromeClient((WebView)localObject2, (WebChromeClient)localObject1);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      finish();
    }
    return false;
  }
  
  public void initData() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.d != null) {
      this.d.destroy();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.d != null) {
      this.d.post(new Runnable()
      {
        public void run()
        {
          CreditWebViewActivity.a(CreditWebViewActivity.this).reload();
        }
      });
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.d != null) {
      this.d.post(new Runnable()
      {
        public void run()
        {
          CreditWebViewActivity.a(CreditWebViewActivity.this).reload();
        }
      });
    }
  }
  
  public String toURLDecoded(String paramString)
  {
    if (r.isNull(paramString)) {
      return "";
    }
    try
    {
      paramString = URLDecoder.decode(new String(paramString.getBytes(), "UTF-8"), "UTF-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */