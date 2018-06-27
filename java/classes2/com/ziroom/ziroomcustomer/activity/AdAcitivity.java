package com.ziroom.ziroomcustomer.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ZoomButtonsController;
import com.freelxl.baselibrary.f.g;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Instrumented
public class AdAcitivity
  extends BaseActivity
{
  private WebView a = null;
  
  private void a()
  {
    try
    {
      ZoomButtonsController localZoomButtonsController = (ZoomButtonsController)Class.forName("android.webkit.WebView").getMethod("getZoomButtonsController", new Class[0]).invoke(this, new Object[] { Boolean.valueOf(true) });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void back(View paramView)
  {
    setResult(0, getIntent());
    finish();
  }
  
  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903642);
    paramBundle = getIntent().getStringExtra("url");
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置");
      return;
    }
    this.a = ((WebView)findViewById(2131693110));
    this.a.setWebViewClient(new WebViewClient());
    this.a.getSettings().setSupportZoom(true);
    this.a.getSettings().setBuiltInZoomControls(true);
    this.a.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
    this.a.getSettings().setUseWideViewPort(true);
    this.a.getSettings().setLoadWithOverviewMode(true);
    this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.setDownloadListener(new a(null));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.a.getSettings().setBuiltInZoomControls(true);
      this.a.getSettings().setDisplayZoomControls(false);
    }
    WebView localWebView;
    for (;;)
    {
      setZoomControlGone(this.a);
      localWebView = this.a;
      if ((localWebView instanceof WebView)) {
        break;
      }
      localWebView.loadUrl(paramBundle);
      return;
      a();
    }
    WebviewInstrumentation.loadUrl((WebView)localWebView, paramBundle);
  }
  
  public void setZoomControlGone(View paramView)
  {
    try
    {
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(paramView);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      return;
    }
    catch (SecurityException paramView)
    {
      try
      {
        localField.set(paramView, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException paramView)
      {
        paramView.printStackTrace();
        return;
        paramView = paramView;
        paramView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    catch (NoSuchFieldException paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private class a
    implements DownloadListener
  {
    private a() {}
    
    public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      AdAcitivity.this.startActivity(paramString1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/AdAcitivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */