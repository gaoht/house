package com.ziroom.ziroomcustomer.morepage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ZoomButtonsController;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.minsu.view.c.a;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;
import com.ziroom.ziroomcustomer.widget.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@com.maa.android.agent.instrumentation.Instrumented
public class MoreItemView
  extends RelativeLayout
{
  private TextView a;
  private ScrollBridgeWebView b;
  private Context c;
  private ImageView d;
  private ImageView e;
  private d f;
  
  public MoreItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MoreItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.c = paramContext;
  }
  
  public MoreItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    this.c = paramContext;
  }
  
  private void a(Context paramContext)
  {
    View localView = View.inflate(paramContext, 2130904128, this);
    this.a = ((TextView)localView.findViewById(2131691082));
    this.b = ((ScrollBridgeWebView)localView.findViewById(2131690681));
    this.d = ((ImageView)localView.findViewById(2131691081));
    this.e = ((ImageView)localView.findViewById(2131691042));
    this.c = paramContext;
  }
  
  private void getControlls()
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
  
  public d getOpenFileWebChromeClient()
  {
    return this.f;
  }
  
  public WebView getWebView()
  {
    return this.b;
  }
  
  public void setBack(final b paramb)
  {
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramb.backtoActivity();
      }
    });
  }
  
  public void setSharedIconShow(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(4);
  }
  
  public void setTitle(String paramString)
  {
    this.a.setText(paramString);
  }
  
  @SuppressLint({"NewApi"})
  public void setWeb(String paramString)
  {
    Object localObject = new a((Activity)this.c, this.b, 1);
    this.b.addJavascriptInterface(localObject, "WebViewFunc");
    this.b.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.startsWith("tel:"))
        {
          paramAnonymousWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
          MoreItemView.a(MoreItemView.this).startActivity(paramAnonymousWebView);
          return true;
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
      }
    });
    this.b.getSettings().setSupportZoom(true);
    this.b.getSettings().setBuiltInZoomControls(true);
    this.b.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
    this.b.getSettings().setUseWideViewPort(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.setDownloadListener(new a(null));
    d locald;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.b.getSettings().setBuiltInZoomControls(true);
      this.b.getSettings().setDisplayZoomControls(false);
      setZoomControlGone(this.b);
      this.f = new d((Activity)this.c);
      localObject = this.b;
      locald = this.f;
      if ((localObject instanceof WebView)) {
        break label245;
      }
      ((ScrollBridgeWebView)localObject).setWebChromeClient(locald);
    }
    for (;;)
    {
      localObject = this.b;
      if ((localObject instanceof WebView)) {
        break label256;
      }
      ((ScrollBridgeWebView)localObject).loadUrl(paramString);
      return;
      getControlls();
      break;
      label245:
      VdsAgent.setWebChromeClient((WebView)localObject, locald);
    }
    label256:
    WebviewInstrumentation.loadUrl((WebView)localObject, paramString);
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
      MoreItemView.a(MoreItemView.this).startActivity(paramString1);
    }
  }
  
  public static abstract interface b
  {
    public abstract void backtoActivity();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/morepage/MoreItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */