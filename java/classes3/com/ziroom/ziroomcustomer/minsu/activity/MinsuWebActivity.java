package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlib.utils.l;
import com.ziroom.threelib.ziroomshare.c.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.e.e;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.c.b;
import com.ziroom.ziroomcustomer.minsu.view.c.d;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class MinsuWebActivity
  extends BaseActivity
{
  private boolean A = false;
  private boolean B = false;
  private com.ziroom.ziroomcustomer.webview.a C;
  private d D;
  private PlatformActionListener E = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      MinsuWebActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      MinsuWebActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  private BroadcastReceiver F = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      paramAnonymousIntent.getIntExtra("status", 0);
      if (i == 17) {
        MinsuWebActivity.k(MinsuWebActivity.this).sendLoginInfo();
      }
    }
  };
  private BridgeWebView a;
  private String b;
  private String c;
  private int d = -1;
  private CommonTitle e;
  private String f;
  private String g;
  private boolean r = true;
  private com.ziroom.ziroomcustomer.minsu.view.c.a s;
  private boolean t = false;
  private String u;
  private String v = "";
  private String w = null;
  private String x;
  private boolean y = true;
  private boolean z = false;
  
  private void a()
  {
    int j = 0;
    this.e = ((CommonTitle)findViewById(2131691272));
    this.e.setMiddleText(this.f);
    this.e.showRightText(false, null);
    CommonTitle localCommonTitle = this.e;
    if (this.z)
    {
      i = 4;
      localCommonTitle.setLeftButtonType(i);
      this.e.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((MinsuWebActivity.a(MinsuWebActivity.this)) && (MinsuWebActivity.b(MinsuWebActivity.this) != null) && (MinsuWebActivity.b(MinsuWebActivity.this).canGoBack()))
          {
            MinsuWebActivity.b(MinsuWebActivity.this).goBack();
            return;
          }
          MinsuWebActivity.this.finish();
        }
      });
      localCommonTitle = this.e;
      if (!this.r) {
        break label126;
      }
    }
    label126:
    for (int i = j;; i = 8)
    {
      localCommonTitle.setVisibility(i);
      if (this.t)
      {
        this.e.showRightIc(true, 2130840338);
        this.e.setOnRightButtonClickListener(new View.OnClickListener()
        {
          @com.growingio.android.sdk.instrumentation.Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            com.ziroom.threelib.ziroomshare.c localc = com.ziroom.threelib.ziroomshare.c.getInstance();
            MinsuWebActivity localMinsuWebActivity;
            if (localc != null)
            {
              localc.setOnPlatformClickListener(new c.a()
              {
                public void onPlatformClick(Platform paramAnonymous2Platform)
                {
                  if (ae.notNull(MinsuWebActivity.c(MinsuWebActivity.this))) {
                    v.onClick(MinsuWebActivity.this, MinsuWebActivity.c(MinsuWebActivity.this));
                  }
                }
              });
              localMinsuWebActivity = MinsuWebActivity.this;
              if (!MinsuWebActivity.d(MinsuWebActivity.this).contains("?")) {
                break label106;
              }
            }
            label106:
            for (paramAnonymousView = MinsuWebActivity.d(MinsuWebActivity.this) + "&shareFlag=2";; paramAnonymousView = MinsuWebActivity.d(MinsuWebActivity.this) + "?shareFlag=2")
            {
              localc.shareFromCenter(localMinsuWebActivity, paramAnonymousView, MinsuWebActivity.e(MinsuWebActivity.this), MinsuWebActivity.f(MinsuWebActivity.this), MinsuWebActivity.g(MinsuWebActivity.this), MinsuWebActivity.h(MinsuWebActivity.this));
              return;
            }
          }
        });
      }
      return;
      i = 0;
      break;
    }
  }
  
  private void b()
  {
    this.a = ((BridgeWebView)findViewById(2131691711));
    this.a.getSettings().setJavaScriptEnabled(true);
    Object localObject1 = new b(this);
    if (this.B)
    {
      this.D = new d()
      {
        public void onReceiverTitle(String paramAnonymousString)
        {
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            MinsuWebActivity.i(MinsuWebActivity.this).setMiddleText(paramAnonymousString);
            MinsuWebActivity.i(MinsuWebActivity.this).setVisibility(0);
          }
        }
      };
      ((b)localObject1).setTitleListener(this.D);
    }
    Object localObject2 = this.a;
    if (!(localObject2 instanceof WebView))
    {
      ((BridgeWebView)localObject2).setWebChromeClient((WebChromeClient)localObject1);
      this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
      this.a.getSettings().setUseWideViewPort(true);
      this.a.setBackgroundColor(0);
      localObject1 = new com.ziroom.ziroomcustomer.minsu.view.c.c(this.a, this, this.y);
      this.a.setWebViewClient((WebViewClient)localObject1);
      this.C = new com.ziroom.ziroomcustomer.webview.a();
      this.C.init(this, this.a);
      localObject1 = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
      LocalBroadcastManager.getInstance(this).registerReceiver(this.F, (IntentFilter)localObject1);
      this.s = new com.ziroom.ziroomcustomer.minsu.view.c.a(this, this.a, this.d);
      this.a.addJavascriptInterface(this.s, "WebViewFunc");
      if (!TextUtils.isEmpty(this.b))
      {
        this.c = this.b;
        if (!this.b.contains("?")) {
          break label376;
        }
      }
    }
    label376:
    for (this.b += "&app_version=5.6.0&os=android";; this.b += "?app_version=5.6.0&os=android")
    {
      if ((this.y) && (!this.b.contains("dWlk")))
      {
        this.x = this.b;
        this.b = e.convertUrl(this.b);
      }
      u.e("url", "url = " + this.b);
      if (!checkNet(this)) {
        break label415;
      }
      localObject1 = this.a;
      localObject2 = this.b;
      if ((localObject1 instanceof WebView)) {
        break label406;
      }
      ((BridgeWebView)localObject1).loadUrl((String)localObject2);
      return;
      VdsAgent.setWebChromeClient((WebView)localObject2, (WebChromeClient)localObject1);
      break;
    }
    label406:
    WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
    return;
    label415:
    af.showToast(this, "网络不佳，请稍后再试");
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      return onBack();
    }
    return false;
  }
  
  public void finish()
  {
    super.finish();
    if (this.z) {
      k.animFinishAlpha(this);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 114)) {
      this.a.reload();
    }
    do
    {
      return;
      if (paramInt1 != 121) {
        break;
      }
    } while (!f.notNull(this.x));
    this.b = e.convertUrl(this.x);
    paramIntent = this.a;
    String str = this.b;
    if (!(paramIntent instanceof WebView))
    {
      paramIntent.loadUrl(str);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)paramIntent, str);
    return;
    if ((paramInt2 == -1) && (this.s != null))
    {
      this.s.onActivityResult(paramInt1, paramIntent);
      return;
    }
    dismissProgress();
  }
  
  public boolean onBack()
  {
    if (this.a != null)
    {
      String str = this.a.getUrl();
      if (f.notNull(str))
      {
        if (str.contains("/houseInput/43e881/findHouseDetail")) {
          this.w = "javascript:goMyHouse()";
        }
        for (;;)
        {
          if (ae.notNull(this.w)) {
            this.a.post(new Runnable()
            {
              public void run()
              {
                BridgeWebView localBridgeWebView = MinsuWebActivity.b(MinsuWebActivity.this);
                String str = MinsuWebActivity.j(MinsuWebActivity.this);
                if (!(localBridgeWebView instanceof WebView))
                {
                  localBridgeWebView.loadUrl(str);
                  return;
                }
                WebviewInstrumentation.loadUrl((WebView)localBridgeWebView, str);
              }
            });
          }
          return true;
          if (!this.a.canGoBack()) {
            break;
          }
          this.a.goBack();
        }
        finish();
        return true;
      }
    }
    finish();
    return true;
  }
  
  public void onBackPressed()
  {
    if ((this.A) && (this.a != null) && (this.a.canGoBack()))
    {
      this.a.goBack();
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903340);
    this.b = getIntent().getStringExtra("url");
    this.f = getIntent().getStringExtra("title");
    this.g = getIntent().getStringExtra("shareTitle");
    this.d = getIntent().getIntExtra("tag", -1);
    this.r = getIntent().getBooleanExtra("isLoadTitle", true);
    this.t = getIntent().getBooleanExtra("isShowShare", false);
    this.u = getIntent().getStringExtra("picUrl");
    this.v = getIntent().getStringExtra("statkey");
    this.y = getIntent().getBooleanExtra("isLogin", true);
    this.z = getIntent().getBooleanExtra("isAnimExit", false);
    this.A = getIntent().getBooleanExtra("needBack", false);
    this.B = getIntent().getBooleanExtra("isInnerUrl", false);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.F);
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */