package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;

public class RegisterView
  extends ResizeLayout
{
  private TitleLayout a;
  private RelativeLayout b;
  private WebView c;
  private TextView d;
  
  public RegisterView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RegisterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(-1);
    setOrientation(1);
    final int i = b(paramContext);
    this.a = new TitleLayout(paramContext);
    try
    {
      j = ResHelper.getBitmapRes(paramContext, "ssdk_auth_title_back");
      if (j > 0) {
        this.a.setBackgroundResource(j);
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        int j;
        Object localObject1;
        Object localObject2 = this.c.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
        ((Method)localObject2).setAccessible(true);
        ((Method)localObject2).invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
        localObject2 = this.c;
        if ((localObject2 instanceof WebView)) {
          break label493;
        }
        ((WebView)localObject2).setWebChromeClient(paramContext);
        ((LinearLayout)localObject1).addView(this.c);
        this.c.requestFocus();
        return;
        localThrowable1 = localThrowable1;
        e.b().d(localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          e.b().d(localThrowable2);
          continue;
          VdsAgent.setWebChromeClient((WebView)localThrowable2, paramContext);
        }
      }
    }
    this.a.getBtnRight().setVisibility(8);
    j = ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
    if (j > 0) {
      this.a.getTvTitle().setText(j);
    }
    addView(this.a);
    localObject1 = new ImageView(paramContext);
    j = ResHelper.getBitmapRes(paramContext, "ssdk_logo");
    if (j > 0) {
      ((ImageView)localObject1).setImageResource(j);
    }
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject1).setPadding(0, 0, ResHelper.dipToPx(paramContext, 10), 0);
    ((ImageView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        try
        {
          int i = ResHelper.getStringRes(paramAnonymousView.getContext(), "ssdk_website");
          Object localObject = null;
          if (i > 0) {
            localObject = paramAnonymousView.getResources().getString(i);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
            paramAnonymousView.getContext().startActivity((Intent)localObject);
          }
          return;
        }
        catch (Throwable paramAnonymousView)
        {
          e.b().d(paramAnonymousView);
        }
      }
    });
    this.a.addView((View)localObject1);
    this.b = new RelativeLayout(paramContext);
    localObject1 = new LinearLayout.LayoutParams(-1, 0);
    ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    addView(this.b);
    localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.b.addView((View)localObject1);
    this.d = new TextView(paramContext);
    this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
    this.d.setBackgroundColor(-12929302);
    ((LinearLayout)localObject1).addView(this.d);
    this.d.setVisibility(8);
    this.c = new WebView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    paramContext.weight = 1.0F;
    this.c.setLayoutParams(paramContext);
    paramContext = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        paramAnonymousWebView = (LinearLayout.LayoutParams)RegisterView.a(RegisterView.this).getLayoutParams();
        paramAnonymousWebView.width = (i * paramAnonymousInt / 100);
        RegisterView.a(RegisterView.this).setLayoutParams(paramAnonymousWebView);
        if ((paramAnonymousInt > 0) && (paramAnonymousInt < 100))
        {
          RegisterView.a(RegisterView.this).setVisibility(0);
          return;
        }
        RegisterView.a(RegisterView.this).setVisibility(8);
      }
    };
    if ((Build.VERSION.SDK_INT <= 10) || (Build.VERSION.SDK_INT >= 17)) {}
  }
  
  private int b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (!(paramContext instanceof Activity)) {}
    do
    {
      return 0;
      paramContext = ((Activity)paramContext).getWindowManager();
    } while (paramContext == null);
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public View a()
  {
    return this.a.getBtnBack();
  }
  
  public void a(boolean paramBoolean)
  {
    TitleLayout localTitleLayout = this.a;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localTitleLayout.setVisibility(i);
      return;
    }
  }
  
  public WebView b()
  {
    return this.c;
  }
  
  public TitleLayout c()
  {
    return this.a;
  }
  
  public RelativeLayout d()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/authorize/RegisterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */