package com.ziroom.ziroomcustomer.social.activity.ac;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.d.b;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.social.view.SelectCityPop;
import com.ziroom.ziroomcustomer.social.view.SelectCityPop.a;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.maa.android.agent.instrumentation.Instrumented
public class AcMainActivity
  extends BaseActivity
{
  com.ziroom.ziroomcustomer.webview.a a;
  private final String b = "http://www.ziroom.com";
  private String c;
  private String d;
  private List<com.ziroom.ziroomcustomer.social.model.c> e;
  private List<String> f;
  private String g;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131690674)
  ProgressBar mPb;
  @BindView(2131692499)
  ScrollBridgeWebView mSbwv;
  @BindView(2131692497)
  TextView mTvCity;
  private boolean r;
  private f<List<com.ziroom.ziroomcustomer.social.model.c>> s = new f(this, new e(com.ziroom.ziroomcustomer.social.model.c.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      AcMainActivity.a(AcMainActivity.this, new ArrayList());
      AcMainActivity.b(AcMainActivity.this, new ArrayList());
      paramAnonymousThrowable = new com.ziroom.ziroomcustomer.social.model.c();
      paramAnonymousThrowable.setName("北京");
      paramAnonymousThrowable.setCode("110000");
      AcMainActivity.a(AcMainActivity.this).add(paramAnonymousThrowable);
      AcMainActivity.a(AcMainActivity.this, new ArrayList());
      AcMainActivity.c(AcMainActivity.this).add("北京");
      AcMainActivity.b(AcMainActivity.this, "北京");
      AcMainActivity.a(AcMainActivity.this, "110000");
      AcMainActivity.c(AcMainActivity.this, "http://www.ziroom.com");
      AcMainActivity.b(AcMainActivity.this);
    }
    
    public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.social.model.c> paramAnonymousList)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousList);
      AcMainActivity.a(AcMainActivity.this, new ArrayList());
      if ((paramAnonymousList == null) || (paramAnonymousList.size() == 0))
      {
        AcMainActivity.b(AcMainActivity.this, new ArrayList());
        paramAnonymousList = new com.ziroom.ziroomcustomer.social.model.c();
        paramAnonymousList.setName("北京");
        paramAnonymousList.setCode("110000");
        paramAnonymousList.setUrl("http://www.ziroom.com");
        AcMainActivity.a(AcMainActivity.this).add(paramAnonymousList);
        AcMainActivity.c(AcMainActivity.this).add("北京");
        if (!TextUtils.isEmpty(AcMainActivity.d(AcMainActivity.this))) {
          break label233;
        }
        AcMainActivity.b(AcMainActivity.this, "北京");
        AcMainActivity.a(AcMainActivity.this, "110000");
        AcMainActivity.c(AcMainActivity.this, "http://www.ziroom.com");
      }
      label233:
      label348:
      for (;;)
      {
        AcMainActivity.this.mTvCity.setText(AcMainActivity.e(AcMainActivity.this));
        AcMainActivity.b(AcMainActivity.this);
        return;
        AcMainActivity.b(AcMainActivity.this, paramAnonymousList);
        paramAnonymousList = AcMainActivity.a(AcMainActivity.this).iterator();
        com.ziroom.ziroomcustomer.social.model.c localc;
        while (paramAnonymousList.hasNext())
        {
          localc = (com.ziroom.ziroomcustomer.social.model.c)paramAnonymousList.next();
          AcMainActivity.c(AcMainActivity.this).add(localc.getName());
        }
        break;
        paramAnonymousList = AcMainActivity.a(AcMainActivity.this).iterator();
        while (paramAnonymousList.hasNext())
        {
          localc = (com.ziroom.ziroomcustomer.social.model.c)paramAnonymousList.next();
          if (AcMainActivity.d(AcMainActivity.this).equals(localc.getCode()))
          {
            AcMainActivity.b(AcMainActivity.this, localc.getName());
            AcMainActivity.c(AcMainActivity.this, localc.getUrl());
          }
        }
        for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0) {
            break label348;
          }
          AcMainActivity.b(AcMainActivity.this, "北京");
          AcMainActivity.a(AcMainActivity.this, "110000");
          AcMainActivity.c(AcMainActivity.this, "http://www.ziroom.com");
          break;
        }
      }
    }
  };
  
  private void a()
  {
    j.acCity(this, this.s);
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(this.g)) {
      this.g = "http://www.ziroom.com";
    }
    if (this.g.contains("?")) {}
    ScrollBridgeWebView localScrollBridgeWebView;
    for (String str = this.g + "&app_version=" + "5.6.0" + "&os=android";; str = this.g + "?app_version=" + "5.6.0" + "&os=android")
    {
      localScrollBridgeWebView = this.mSbwv;
      if ((localScrollBridgeWebView instanceof WebView)) {
        break;
      }
      localScrollBridgeWebView.loadUrl(str);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localScrollBridgeWebView, str);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903510);
    ButterKnife.bind(this);
    this.d = getIntent().getStringExtra("cityCode");
    this.r = getIntent().getBooleanExtra("backToMain", false);
    paramBundle = this.mSbwv;
    Object localObject = new WebChromeClient();
    if (!(paramBundle instanceof WebView))
    {
      paramBundle.setWebChromeClient((WebChromeClient)localObject);
      paramBundle = this.mSbwv.getSettings().getUserAgentString();
      this.mSbwv.getSettings().setUserAgentString(paramBundle + "HybridAPP/" + "5.6.0" + "/android");
      this.mSbwv.getSettings().setJavaScriptEnabled(true);
      this.mSbwv.setWebViewClient(new a(this.mSbwv));
      paramBundle = this.mSbwv;
      localObject = new WebChromeClient()
      {
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          if ((!AcMainActivity.this.isFinishing()) && (AcMainActivity.this.mPb != null))
          {
            if ((paramAnonymousInt > 0) && (paramAnonymousInt < 100))
            {
              AcMainActivity.this.mPb.setProgress(paramAnonymousInt);
              AcMainActivity.this.mPb.setVisibility(0);
            }
          }
          else {
            return;
          }
          AcMainActivity.this.mPb.setVisibility(8);
        }
      };
      if ((paramBundle instanceof WebView)) {
        break label213;
      }
      paramBundle.setWebChromeClient((WebChromeClient)localObject);
    }
    for (;;)
    {
      this.a = new com.ziroom.ziroomcustomer.webview.a();
      this.a.init(this, this.mSbwv);
      a();
      return;
      VdsAgent.setWebChromeClient((WebView)paramBundle, (WebChromeClient)localObject);
      break;
      label213:
      VdsAgent.setWebChromeClient((WebView)paramBundle, (WebChromeClient)localObject);
    }
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.r = paramIntent.getBooleanExtra("backToMain", false);
      paramIntent = paramIntent.getStringExtra("cityCode");
      if (!TextUtils.isEmpty(paramIntent)) {
        this.d = paramIntent;
      }
    }
  }
  
  @OnClick({2131689492, 2131692496, 2131692498})
  public void onViewClicked(View paramView)
  {
    Intent localIntent = new Intent();
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (ApplicationEx.c.isLoginState())
      {
        startActivity(new Intent(this, AcEnrollListActivityNew.class));
        return;
      }
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
      if (this.r)
      {
        localIntent.setClass(this, MainActivity.class);
        startActivityAndFinish(localIntent);
        return;
      }
      finish();
      return;
      paramView = new SelectCityPop(this);
    } while ((this.f == null) || (this.f.size() <= 0));
    paramView.show(this.mTvCity, this.f, new SelectCityPop.a()
    {
      public void onAcCitySelected(String paramAnonymousString)
      {
        AcMainActivity.this.mTvCity.setText(paramAnonymousString);
        Iterator localIterator = AcMainActivity.a(AcMainActivity.this).iterator();
        while (localIterator.hasNext())
        {
          com.ziroom.ziroomcustomer.social.model.c localc = (com.ziroom.ziroomcustomer.social.model.c)localIterator.next();
          if (paramAnonymousString.equals(localc.getName()))
          {
            AcMainActivity.a(AcMainActivity.this, localc.getCode());
            AcMainActivity.b(AcMainActivity.this, paramAnonymousString);
            AcMainActivity.c(AcMainActivity.this, localc.getUrl());
          }
        }
        AcMainActivity.b(AcMainActivity.this);
      }
    });
  }
  
  class a
    extends com.freelxl.baselibrary.webview.c
  {
    public a(BridgeWebView paramBridgeWebView)
    {
      super();
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (paramSslError.getPrimaryError() == 5)
      {
        if (b.isSSLCertOk(paramSslError.getCertificate(), b.a)) {
          paramSslErrorHandler.proceed();
        }
        paramWebView = Uri.parse(AcMainActivity.f(AcMainActivity.this));
        if ((paramWebView != null) && (paramWebView.getHost() != null) && (!paramWebView.getHost().contains("ziroom.com"))) {
          paramSslErrorHandler.proceed();
        }
        return;
      }
      paramSslErrorHandler.cancel();
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
      if (paramWebResourceRequest.getUrl().toString().endsWith("WebViewJavascriptBridge.js")) {
        try
        {
          paramWebResourceRequest = new WebResourceResponse("text/javascript", "UTF-8", AcMainActivity.this.getAssets().open("WebViewJavascriptBridge.js"));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */