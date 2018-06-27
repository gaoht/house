package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.freelxl.baselibrary.webview.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import java.io.IOException;
import java.util.HashSet;

@com.maa.android.agent.instrumentation.Instrumented
public class MeetaCircleActivity
  extends BaseActivity
{
  private BroadcastReceiver A = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      paramAnonymousIntent.getIntExtra("status", 0);
      if (i == 17) {
        MeetaCircleActivity.g(MeetaCircleActivity.this).sendLoginInfo();
      }
    }
  };
  protected BridgeWebView a;
  private final int b = 1;
  private final int c = 3;
  private final int d = 2;
  private TextView e;
  private ImageView f;
  private ImageView g;
  private ProgressBar r;
  private String s;
  private String t;
  private String u;
  private com.ziroom.ziroomcustomer.webview.a v;
  private Context w;
  private boolean x;
  private boolean y = true;
  private View.OnClickListener z = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      MeetaCircleActivity.this.finish();
    }
  };
  
  private void a()
  {
    this.a = ((BridgeWebView)findViewById(2131689545));
    Object localObject1 = this.a.getSettings().getUserAgentString();
    this.a.getSettings().setUserAgentString((String)localObject1 + "HybridAPP/" + "5.6.0" + "/android");
    this.f = ((ImageView)findViewById(2131689492));
    this.e = ((TextView)findViewById(2131689541));
    this.g = ((ImageView)findViewById(2131692905));
    this.r = ((ProgressBar)findViewById(2131690674));
    this.t = getIntent().getStringExtra("url");
    this.u = getIntent().getStringExtra("title");
    this.s = getIntent().getStringExtra("projectId");
    this.e.setText(this.u);
    this.f.setOnClickListener(this.z);
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ApplicationEx.c.isLoginState())
        {
          paramAnonymousView = new Intent(MeetaCircleActivity.this, MeetaCircleSettingActivity.class);
          paramAnonymousView.putExtra("projectId", MeetaCircleActivity.a(MeetaCircleActivity.this));
          MeetaCircleActivity.this.startActivity(paramAnonymousView);
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(MeetaCircleActivity.b(MeetaCircleActivity.this));
      }
    });
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.getSettings().setSupportZoom(false);
    this.a.getSettings().setBuiltInZoomControls(true);
    this.a.getSettings().setDisplayZoomControls(false);
    this.a.setWebViewClient(new a(this.a));
    localObject1 = this.a;
    Object localObject2 = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        if ((!MeetaCircleActivity.this.isFinishing()) && (MeetaCircleActivity.c(MeetaCircleActivity.this) != null))
        {
          if ((paramAnonymousInt > 0) && (paramAnonymousInt < 100))
          {
            MeetaCircleActivity.c(MeetaCircleActivity.this).setProgress(paramAnonymousInt);
            MeetaCircleActivity.c(MeetaCircleActivity.this).setVisibility(0);
          }
        }
        else {
          return;
        }
        MeetaCircleActivity.c(MeetaCircleActivity.this).setVisibility(8);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        if ((!MeetaCircleActivity.this.isFinishing()) && (MeetaCircleActivity.d(MeetaCircleActivity.this) != null) && (TextUtils.isEmpty(MeetaCircleActivity.e(MeetaCircleActivity.this)))) {
          MeetaCircleActivity.d(MeetaCircleActivity.this).setText(paramAnonymousString);
        }
      }
    };
    if (!(localObject1 instanceof WebView))
    {
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
      this.v = new com.ziroom.ziroomcustomer.webview.a()
      {
        protected void a()
        {
          super.a();
          Intent localIntent = new Intent(MeetaCircleActivity.this, MainActivity.class);
          localIntent.putExtra("FRAGMENT_TYPE", 7);
          MeetaCircleActivity.this.startActivityAndFinish(localIntent);
        }
        
        protected void a(e paramAnonymouse)
        {
          super.a(paramAnonymouse);
          if (paramAnonymouse != null)
          {
            paramAnonymouse.getDouble("radio").doubleValue();
            int i = paramAnonymouse.getInteger("scale_w").intValue();
            int j = paramAnonymouse.getInteger("scale_h").intValue();
            if ((j != 0) && (i != 0))
            {
              int k = j * 600 / i;
              paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(MeetaCircleActivity.this, false, 1, true, 600, k, i, j);
            }
          }
          for (;;)
          {
            MeetaCircleActivity.this.startActivityForResult(paramAnonymouse, 3);
            return;
            paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(MeetaCircleActivity.this, false, 1, false, 0, 0);
            continue;
            paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(MeetaCircleActivity.this, false, 1, false, 0, 0);
          }
        }
        
        protected void b(e paramAnonymouse)
        {
          super.b(paramAnonymouse);
          paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(MeetaCircleActivity.this, false, 1, true, 600, 600);
          MeetaCircleActivity.this.startActivityForResult(paramAnonymouse, 1);
        }
        
        protected void c(e paramAnonymouse)
        {
          super.c(paramAnonymouse);
          paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(MeetaCircleActivity.this, false, 1, false, 0, 0);
          MeetaCircleActivity.this.startActivityForResult(paramAnonymouse, 2);
        }
        
        protected void f()
        {
          super.f();
          HashSet localHashSet = new HashSet();
          localHashSet.add(Integer.valueOf(1));
          Intent localIntent = new Intent(MeetaCircleActivity.this, HouseListActivity.class);
          SearchCondition localSearchCondition = new SearchCondition();
          localSearchCondition.setType("1");
          localSearchCondition.setTypeName("合租");
          localSearchCondition.setTypeSet(localHashSet);
          localSearchCondition.setVersion("5");
          localIntent.putExtra("searchCondition", localSearchCondition);
          localIntent.putExtra("isSpecified", true);
          MeetaCircleActivity.this.startActivity(localIntent);
        }
        
        protected void z(e paramAnonymouse)
        {
          super.z(paramAnonymouse);
          if (paramAnonymouse != null)
          {
            MeetaCircleActivity.a(MeetaCircleActivity.this, paramAnonymouse.getString("projectId"));
            com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(MeetaCircleActivity.this, MeetaCircleActivity.a(MeetaCircleActivity.this));
          }
        }
      };
      this.v.init(this, this.a);
      if (!TextUtils.isEmpty(this.t)) {
        if (!this.t.contains("?")) {
          break label388;
        }
      }
    }
    label388:
    for (localObject1 = this.t + "&app_version=" + "5.6.0" + "&os=android";; localObject1 = this.t + "?app_version=" + "5.6.0" + "&os=android")
    {
      localObject2 = this.a;
      if ((localObject2 instanceof WebView)) {
        break label424;
      }
      ((BridgeWebView)localObject2).loadUrl((String)localObject1);
      return;
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
      break;
    }
    label424:
    WebviewInstrumentation.loadUrl((WebView)localObject2, (String)localObject1);
  }
  
  public void dismissProgress()
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903587);
    this.w = this;
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.A, paramBundle);
    a();
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.A);
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if ((this.x) && (this.y)) {
      this.a.reload();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public boolean showProgress(String paramString)
  {
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
    com.freelxl.baselibrary.widget.a.show(this, paramString, false, true);
    return true;
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
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (!TextUtils.isEmpty(paramString)) {}
      label70:
      for (;;)
      {
        try
        {
          paramWebView = Uri.parse(paramString);
          if (paramWebView != null)
          {
            paramWebView = paramWebView.getQueryParameter("autoRefresh");
            paramString = MeetaCircleActivity.this;
            if (TextUtils.isEmpty(paramWebView)) {
              break label70;
            }
            if (!"false".equals(paramWebView))
            {
              break label70;
              MeetaCircleActivity.a(paramString, bool);
            }
          }
          else
          {
            return;
          }
          boolean bool = false;
          continue;
          bool = true;
        }
        catch (Exception paramWebView)
        {
          return;
        }
      }
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (paramSslError.getPrimaryError() == 5)
      {
        if (b.isSSLCertOk(paramSslError.getCertificate(), b.a)) {
          paramSslErrorHandler.proceed();
        }
        paramWebView = Uri.parse(MeetaCircleActivity.f(MeetaCircleActivity.this));
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
          paramWebResourceRequest = new WebResourceResponse("text/javascript", "UTF-8", MeetaCircleActivity.this.getAssets().open("WebViewJavascriptBridge.js"));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/MeetaCircleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */