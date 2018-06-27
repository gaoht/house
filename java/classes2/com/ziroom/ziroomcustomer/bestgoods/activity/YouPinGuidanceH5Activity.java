package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.freelxl.baselibrary.webview.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.bestgoods.dialog.YouPinSelectCityPop;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;
import com.ziroom.ziroomcustomer.webview.a;
import java.io.IOException;

@com.maa.android.agent.instrumentation.Instrumented
public class YouPinGuidanceH5Activity
  extends BaseActivity
  implements View.OnClickListener
{
  String a = "";
  private Context b;
  private ImageView c;
  private ImageView d;
  private FrameLayout e;
  private TextView f;
  private ScrollBridgeWebView g;
  private YouPinSelectCityPop r = null;
  private boolean s = false;
  private boolean t = false;
  private a u;
  private String v;
  private ImageView w;
  private String x = "";
  private TextView y;
  private BroadcastReceiver z = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("youpin_city_select"))
      {
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("cityName");
        String str = paramAnonymousIntent.getStringExtra("cityCode");
        YouPinGuidanceH5Activity.a(YouPinGuidanceH5Activity.this, paramAnonymousIntent.getBooleanExtra("isColsePop", false));
        YouPinGuidanceH5Activity.this.d(paramAnonymousContext);
        YouPinGuidanceH5Activity.this.a = str;
        YouPinGuidanceH5Activity.a(YouPinGuidanceH5Activity.this, paramAnonymousContext);
        YouPinGuidanceH5Activity.b(YouPinGuidanceH5Activity.this, YouPinGuidanceH5Activity.a(YouPinGuidanceH5Activity.this));
        aa.putString(YouPinGuidanceH5Activity.b(YouPinGuidanceH5Activity.this), "currentYouPinCityName", paramAnonymousContext);
        aa.putString(YouPinGuidanceH5Activity.b(YouPinGuidanceH5Activity.this), "currentYouPinCityCode", str);
      }
    }
  };
  
  private void a()
  {
    this.w = ((ImageView)findViewById(2131690588));
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((ImageView)findViewById(2131692745));
    this.y = ((TextView)findViewById(2131690048));
    this.e = ((FrameLayout)findViewById(2131692743));
    this.f = ((TextView)findViewById(2131692744));
    this.g = ((ScrollBridgeWebView)findViewById(2131689545));
  }
  
  private void b()
  {
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.w.setOnClickListener(this);
  }
  
  private void e()
  {
    aa.getString(this.b, "currentYouPinCityName", "");
    aa.getString(this.b, "currentYouPinCityCode", "");
    Object localObject = b.c;
    String str = b.d;
    this.x = ((String)localObject);
    this.a = str;
    this.f.setText(this.x);
    aa.putString(this.b, "currentYouPinCityName", this.x);
    aa.putString(this.b, "currentYouPinCityCode", this.a);
    this.v = getIntent().getStringExtra("youpinH5url");
    if (TextUtils.isEmpty(this.v)) {
      this.v = ad.getOther(this.b, "youpinH5url");
    }
    e(this.v);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("youpin_city_select");
    this.b.registerReceiver(this.z, (IntentFilter)localObject);
  }
  
  private void e(String paramString)
  {
    Object localObject = this.g.getSettings().getUserAgentString();
    this.g.getSettings().setUserAgentString((String)localObject + "HybridAPP/" + "5.6.0" + "/android");
    this.g.getSettings().setJavaScriptEnabled(true);
    this.g.getSettings().setSupportZoom(true);
    this.g.getSettings().setBuiltInZoomControls(true);
    this.g.getSettings().setDisplayZoomControls(false);
    this.g.setWebViewClient(new a(this.g));
    localObject = this.g;
    WebChromeClient local1 = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
      }
    };
    if (!(localObject instanceof WebView))
    {
      ((ScrollBridgeWebView)localObject).setWebChromeClient(local1);
      this.u = new a();
      this.u.init(this, this.g);
      if (!TextUtils.isEmpty(paramString)) {
        if (!paramString.contains("?")) {
          break label249;
        }
      }
    }
    label249:
    for (paramString = paramString + "&app_version=" + "5.6.0" + "&cityCode=" + this.a + "&os=android";; paramString = paramString + "?app_version=" + "5.6.0" + "&cityCode=" + this.a + "&os=android")
    {
      localObject = this.g;
      if ((localObject instanceof WebView)) {
        break label295;
      }
      ((ScrollBridgeWebView)localObject).loadUrl(paramString);
      return;
      VdsAgent.setWebChromeClient((WebView)localObject, local1);
      break;
    }
    label295:
    WebviewInstrumentation.loadUrl((WebView)localObject, paramString);
  }
  
  private void f()
  {
    if (this.t)
    {
      if (this.s) {
        finish();
      }
      while (this.r == null) {
        return;
      }
      this.r.checkCityIsSelect();
      return;
    }
    if (this.g.canGoBack())
    {
      this.g.goBack();
      return;
    }
    finish();
  }
  
  private void g()
  {
    if (this.r == null) {
      this.r = new YouPinSelectCityPop(this.b);
    }
    this.r.show(this.f);
  }
  
  protected void d(String paramString)
  {
    if (this.f != null) {
      this.f.setText(paramString);
    }
  }
  
  public void onBackPressed()
  {
    f();
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690588: 
      finish();
      return;
    case 2131689492: 
      f();
      return;
    case 2131690048: 
    case 2131692745: 
      j.toServiceOrderList(this.b, "type_youpin", "");
      return;
    }
    this.t = true;
    this.s = false;
    g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903567);
    this.b = this;
    a();
    b();
    e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.z != null) {
        this.b.unregisterReceiver(this.z);
      }
      if (this.g != null)
      {
        this.g.destroy();
        this.g = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  class a
    extends c
  {
    public a(BridgeWebView paramBridgeWebView)
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
      if (paramWebResourceRequest.getUrl().toString().endsWith("WebViewJavascriptBridge.js")) {
        try
        {
          paramWebResourceRequest = new WebResourceResponse("text/javascript", "UTF-8", YouPinGuidanceH5Activity.this.getAssets().open("WebViewJavascriptBridge.js"));
          return paramWebResourceRequest;
        }
        catch (IOException paramWebResourceRequest)
        {
          paramWebResourceRequest.printStackTrace();
        }
      }
      return paramWebView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinGuidanceH5Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */