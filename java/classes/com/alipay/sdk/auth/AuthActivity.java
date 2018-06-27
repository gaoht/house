package com.alipay.sdk.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.j.k;
import com.alipay.sdk.j.k.a;
import com.alipay.sdk.k.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import java.lang.reflect.Method;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
@Instrumented
public class AuthActivity
  extends Activity
{
  private WebView a;
  private String b;
  private a c;
  private Handler d;
  private boolean e;
  private boolean f;
  private Runnable g = new e(this);
  
  public void onBackPressed()
  {
    if (this.a.canGoBack())
    {
      if (this.f)
      {
        i.a(this, this.b + "?resultCode=150");
        finish();
      }
      return;
    }
    i.a(this, this.b + "?resultCode=150");
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getExtras();
        if (paramBundle == null)
        {
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        finish();
        return;
      }
      try
      {
        this.b = paramBundle.getString("redirectUri");
        paramBundle = paramBundle.getString("params");
        if (!k.b(paramBundle))
        {
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        finish();
        return;
      }
      super.requestWindowFeature(1);
      this.d = new Handler(getMainLooper());
      Object localObject1 = new LinearLayout(this);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout)localObject1).setOrientation(1);
      setContentView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.a = new WebView(this);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      this.a.setVisibility(0);
      ((LinearLayout)localObject1).addView(this.a, (ViewGroup.LayoutParams)localObject2);
      localObject1 = this.a.getSettings();
      ((WebSettings)localObject1).setUserAgentString(((WebSettings)localObject1).getUserAgentString() + k.e(getApplicationContext()));
      ((WebSettings)localObject1).setRenderPriority(WebSettings.RenderPriority.HIGH);
      ((WebSettings)localObject1).setSupportMultipleWindows(true);
      ((WebSettings)localObject1).setJavaScriptEnabled(true);
      ((WebSettings)localObject1).setSavePassword(false);
      ((WebSettings)localObject1).setJavaScriptCanOpenWindowsAutomatically(true);
      ((WebSettings)localObject1).setMinimumFontSize(((WebSettings)localObject1).getMinimumFontSize() + 8);
      ((WebSettings)localObject1).setAllowFileAccess(false);
      ((WebSettings)localObject1).setTextSize(WebSettings.TextSize.NORMAL);
      this.a.setVerticalScrollbarOverlay(true);
      this.a.setWebViewClient(new b((byte)0));
      localObject1 = this.a;
      localObject2 = new a((byte)0);
      if (!(localObject1 instanceof WebView))
      {
        ((WebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
        label288:
        this.a.setDownloadListener(new b(this));
        localObject1 = this.a;
        if ((localObject1 instanceof WebView)) {
          break label443;
        }
        ((WebView)localObject1).loadUrl(paramBundle);
        if (Build.VERSION.SDK_INT < 7) {}
      }
      for (;;)
      {
        try
        {
          paramBundle = this.a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE });
          if (paramBundle != null) {
            paramBundle.invoke(this.a.getSettings(), new Object[] { Boolean.valueOf(true) });
          }
        }
        catch (Exception paramBundle)
        {
          label443:
          continue;
        }
        try
        {
          this.a.removeJavascriptInterface("searchBoxJavaBridge_");
          this.a.removeJavascriptInterface("accessibility");
          this.a.removeJavascriptInterface("accessibilityTraversal");
          if (Build.VERSION.SDK_INT < 19) {
            break;
          }
          this.a.getSettings().setCacheMode(1);
          return;
          VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
          break label288;
          WebviewInstrumentation.loadUrl((WebView)localObject1, paramBundle);
        }
        catch (Throwable paramBundle)
        {
          try
          {
            paramBundle = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (paramBundle == null) {
              continue;
            }
            paramBundle.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
            paramBundle.invoke(this.a, new Object[] { "accessibility" });
            paramBundle.invoke(this.a, new Object[] { "accessibilityTraversal" });
          }
          catch (Throwable paramBundle) {}
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.removeAllViews();
    }
    try
    {
      this.a.destroy();
      this.a = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private final class a
    extends WebChromeClient
  {
    private a() {}
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      String str2 = paramConsoleMessage.message();
      if (TextUtils.isEmpty(str2)) {
        return super.onConsoleMessage(paramConsoleMessage);
      }
      String str1 = null;
      if (str2.startsWith("h5container.message: ")) {
        str1 = str2.replaceFirst("h5container.message: ", "");
      }
      if (TextUtils.isEmpty(str1)) {
        return super.onConsoleMessage(paramConsoleMessage);
      }
      AuthActivity.b(AuthActivity.this, str1);
      return super.onConsoleMessage(paramConsoleMessage);
    }
  }
  
  private final class b
    extends WebViewClient
  {
    private b() {}
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      AuthActivity.g(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).removeCallbacks(AuthActivity.e(AuthActivity.this));
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AuthActivity.d(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).postDelayed(AuthActivity.e(AuthActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AuthActivity.a(AuthActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (AuthActivity.b(AuthActivity.this))
      {
        paramSslErrorHandler.proceed();
        AuthActivity.a(AuthActivity.this, false);
        return;
      }
      AuthActivity.this.runOnUiThread(new f(this, paramSslErrorHandler));
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool = true;
      if ((paramString.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase())) || (paramString.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase()))) {
        try
        {
          paramWebView = k.a(AuthActivity.this);
          if (paramWebView == null) {
            return bool;
          }
          if (paramWebView.a()) {
            return true;
          }
          paramWebView = paramString;
          if (paramString.startsWith("intent://platformapi/startapp")) {
            paramWebView = paramString.replaceFirst("intent://platformapi/startapp?", "alipays://platformapi/startApp?");
          }
          paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramWebView));
          AuthActivity.this.startActivity(paramWebView);
          return true;
        }
        catch (Throwable paramWebView)
        {
          return true;
        }
      }
      if (AuthActivity.a(AuthActivity.this, paramString))
      {
        paramWebView.stopLoading();
        return true;
      }
      bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
      return bool;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/auth/AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */