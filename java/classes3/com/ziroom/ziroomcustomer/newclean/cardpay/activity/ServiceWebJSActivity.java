package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.webview.b;
import com.ziroom.ziroomcustomer.webview.b.a;
import com.ziroom.ziroomcustomer.webview.d;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class ServiceWebJSActivity
  extends BaseActivity
  implements View.OnClickListener, PlatformActionListener
{
  protected BridgeWebView a;
  private Context b;
  private d c;
  private View d;
  private String e;
  private TextView f;
  
  private void a()
  {
    new b().toBuyServiceCard(this.a, new b.a()
    {
      public void onJsLinkCallBack(Object paramAnonymousObject)
      {
        ServiceWebJSActivity.this.finish();
      }
    });
  }
  
  private void b()
  {
    this.d = findViewById(2131689492);
    this.a = ((BridgeWebView)findViewById(2131689545));
    this.f = ((TextView)findViewById(2131689541));
  }
  
  private void e()
  {
    this.d.setOnClickListener(this);
  }
  
  private void f()
  {
    Object localObject1 = getIntent().getStringExtra("title_name");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.f.setText((CharSequence)localObject1);
    }
    this.c = new d(this);
    localObject1 = this.a;
    Object localObject2 = this.c;
    if (!(localObject1 instanceof WebView)) {
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
    }
    for (;;)
    {
      this.e = getIntent().getExtras().getString("url", "http://www.ziroom.com");
      localObject1 = this.a;
      localObject2 = this.e;
      if ((localObject1 instanceof WebView)) {
        break;
      }
      ((BridgeWebView)localObject1).loadUrl((String)localObject2);
      return;
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
    }
    WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
  }
  
  public void onBackPressed()
  {
    if (this.a.canGoBack())
    {
      this.a.goBack();
      return;
    }
    super.onBackPressed();
  }
  
  public void onCancel(Platform paramPlatform, int paramInt) {}
  
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
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903481);
    this.b = this;
    b();
    e();
    f();
    a();
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable) {}
  
  protected void onRestart()
  {
    super.onRestart();
    this.a.reload();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/ServiceWebJSActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */