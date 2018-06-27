package cn.sharesdk.sina.weibo.sdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.framework.utils.e;
import cn.sharesdk.sina.weibo.sdk.LoadingBar;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;

public class a
{
  private TextView a;
  private TextView b;
  private WebView c;
  private LoadingBar d;
  private LinearLayout e;
  private TextView f;
  private Button g;
  private Context h;
  
  public a(Context paramContext)
  {
    this.h = paramContext;
  }
  
  private void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER).append("-").append(Build.MODEL);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("weibosdk");
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("0031405000");
    ((StringBuilder)localObject).append("_android");
    this.c.getSettings().setJavaScriptEnabled(true);
    this.c.getSettings().setSavePassword(false);
    this.c.getSettings().setUserAgentString(((StringBuilder)localObject).toString());
    this.c.requestFocus();
    this.c.setScrollBarStyle(0);
    if ((Build.VERSION.SDK_INT > 10) && (Build.VERSION.SDK_INT < 17)) {}
    try
    {
      localObject = this.c.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
      localObject = this.c;
      local2 = new WebChromeClient()
      {
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          a.a(a.this).a(paramAnonymousInt);
          if (paramAnonymousInt == 100)
          {
            a.a(a.this).setVisibility(4);
            return;
          }
          a.a(a.this).setVisibility(0);
        }
      };
      if (!(localObject instanceof WebView))
      {
        ((WebView)localObject).setWebChromeClient(local2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      WebChromeClient local2;
      for (;;)
      {
        e.b().d(localThrowable);
      }
      VdsAgent.setWebChromeClient((WebView)localThrowable, local2);
    }
  }
  
  public Button a()
  {
    return this.g;
  }
  
  public RelativeLayout a(int paramInt)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.h);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localRelativeLayout.setBackgroundColor(-1);
    Object localObject1 = new RelativeLayout(this.h);
    ((RelativeLayout)localObject1).setId(ResHelper.getIdRes(this.h, "ssdk_sina_web_title_id"));
    ((RelativeLayout)localObject1).setBackgroundColor(-131587);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, ResHelper.dipToPx(this.h, 55));
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.a = new TextView(this.h);
    this.a.setTextSize(1, 17.0F);
    this.a.setTextColor(cn.sharesdk.sina.weibo.sdk.a.a(33280, 1728020992));
    int i = ResHelper.getStringRes(this.h, "ssdk_sina_web_close");
    if (i > 0) {
      this.a.setText(i);
    }
    i = ResHelper.dipToPx(this.h, 10);
    this.a.setPadding(i, 0, i, 0);
    this.a.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          paramAnonymousView.setBackgroundColor(-1);
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            paramAnonymousView.setBackgroundColor(-131587);
          }
        }
      }
    });
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout)localObject1).addView(this.a, (ViewGroup.LayoutParams)localObject2);
    this.b = new TextView(this.h);
    this.b.setTextColor(-11382190);
    this.b.setTextSize(1, 18.0F);
    if (paramInt > 0) {
      this.b.setText(paramInt);
    }
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((RelativeLayout)localObject1).addView(this.b, (ViewGroup.LayoutParams)localObject2);
    this.c = new WebView(this.h);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((RelativeLayout)localObject1).getId());
    localRelativeLayout.addView(this.c, (ViewGroup.LayoutParams)localObject2);
    this.d = new LoadingBar(this.h);
    localObject2 = new RelativeLayout.LayoutParams(-1, ResHelper.dipToPx(this.h, 3));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((RelativeLayout)localObject1).getId());
    localRelativeLayout.addView(this.d, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(this.h);
    paramInt = ResHelper.getBitmapRes(this.h, "ssdk_weibo_common_shadow_top");
    if (paramInt > 0) {
      ((View)localObject1).setBackgroundResource(paramInt);
    }
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.e = new LinearLayout(this.h);
    this.e.setVisibility(8);
    this.e.setGravity(17);
    this.e.setOrientation(1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    localRelativeLayout.addView(this.e, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ImageView(this.h);
    paramInt = ResHelper.getBitmapRes(this.h, "ssdk_weibo_empty_failed");
    if (paramInt > 0) {
      ((ImageView)localObject1).setImageResource(paramInt);
    }
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = ResHelper.dipToPx(this.h, 8);
    this.e.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.f = new TextView(this.h);
    paramInt = ResHelper.getStringRes(this.h, "ssdk_sina_web_net_error");
    if (paramInt > 0) {
      this.f.setText(paramInt);
    }
    this.f.setTextColor(-4342339);
    this.f.setTextSize(1, 14.0F);
    localObject1 = new LinearLayout.LayoutParams(-2, -2);
    this.e.addView(this.f, (ViewGroup.LayoutParams)localObject1);
    this.g = new Button(this.h);
    this.g.setTextColor(-8882056);
    this.g.setGravity(17);
    this.g.setTextSize(1, 16.0F);
    paramInt = ResHelper.getStringRes(this.h, "ssdk_sina_web_refresh");
    if (paramInt > 0) {
      this.g.setText(paramInt);
    }
    localObject1 = new LinearLayout.LayoutParams(ResHelper.dipToPx(this.h, 142), ResHelper.dipToPx(this.h, 46));
    ((LinearLayout.LayoutParams)localObject1).topMargin = i;
    this.e.addView(this.g, (ViewGroup.LayoutParams)localObject1);
    e();
    return localRelativeLayout;
  }
  
  public TextView b()
  {
    return this.a;
  }
  
  public WebView c()
  {
    return this.c;
  }
  
  public LinearLayout d()
  {
    return this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */