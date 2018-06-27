package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.freelxl.baselibrary.webview.X5_BridgeWebView;
import com.freelxl.baselibrary.webview.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.webview.X5_ScrollBridgeWebView;
import java.io.IOException;

@com.maa.android.agent.instrumentation.Instrumented
public class JsVideoWebViewActivity
  extends BaseActivity
{
  static X5_ScrollBridgeWebView a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  @BindView(2131689781)
  ImageView mIvBack;
  @BindView(2131689782)
  TextView mTvTitle;
  
  private void a()
  {
    this.b = getIntent().getStringExtra("url");
    this.f = getIntent().getStringExtra("title");
    this.g = getIntent().getStringExtra("backStack");
    if (TextUtils.isEmpty(this.f)) {
      this.f = "自如";
    }
    Object localObject1;
    Object localObject2;
    if (this.b != null)
    {
      if (this.b.contains("?")) {
        this.b += "&os=android";
      }
    }
    else
    {
      a = (X5_ScrollBridgeWebView)findViewById(2131690590);
      this.c = a.getToken(this);
      this.d = a.getUid(this);
      localObject1 = ((ApplicationEx)getApplication()).getUser();
      if (localObject1 != null) {
        this.e = ((UserInfo)localObject1).getMobile();
      }
      this.mIvBack.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("MainActivity".equals(JsVideoWebViewActivity.a(JsVideoWebViewActivity.this)))
          {
            paramAnonymousView = new Intent(JsVideoWebViewActivity.this, MainActivity.class);
            JsVideoWebViewActivity.this.startActivityAndFinish(paramAnonymousView);
            return;
          }
          JsVideoWebViewActivity.this.finish();
        }
      });
      this.mTvTitle.setText(this.f);
      a.getSettings().setJavaScriptEnabled(true);
      a.setWebViewClient(new h(a)
      {
        public WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
        {
          paramAnonymousWebView = super.shouldInterceptRequest(paramAnonymousWebView, paramAnonymousWebResourceRequest);
          if (paramAnonymousWebResourceRequest.getUrl().toString().endsWith("WebViewJavascriptBridge.js")) {
            try
            {
              paramAnonymousWebResourceRequest = new WebResourceResponse("text/javascript", "UTF-8", JsVideoWebViewActivity.this.getAssets().open("WebViewJavascriptBridge.js"));
              return paramAnonymousWebResourceRequest;
            }
            catch (IOException paramAnonymousWebResourceRequest)
            {
              paramAnonymousWebResourceRequest.printStackTrace();
            }
          }
          return paramAnonymousWebView;
        }
      });
      localObject1 = a;
      localObject2 = new WebChromeClient()
      {
        public boolean onJsAlert(com.tencent.smtt.sdk.WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
        {
          return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
        }
      };
      if ((localObject1 instanceof com.tencent.smtt.sdk.WebView)) {
        break label280;
      }
      ((X5_ScrollBridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
    }
    for (;;)
    {
      localObject1 = a;
      localObject2 = this.b;
      if ((localObject1 instanceof android.webkit.WebView)) {
        break label291;
      }
      ((X5_ScrollBridgeWebView)localObject1).loadUrl((String)localObject2);
      return;
      this.b += "?os=android";
      break;
      label280:
      VdsAgent.setWebChromeClient((com.tencent.smtt.sdk.WebView)localObject1, (WebChromeClient)localObject2);
    }
    label291:
    WebviewInstrumentation.loadUrl((android.webkit.WebView)localObject1, (String)localObject2);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903238);
    ButterKnife.bind(this);
    getWindow().setFormat(-3);
    a();
  }
  
  protected void onDestroy()
  {
    if (a != null)
    {
      a.destroy();
      a = null;
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/JsVideoWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */