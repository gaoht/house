package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseSupportURIActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.i;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.bd;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanerSelectActivity;
import com.ziroom.ziroomcustomer.util.ab;
import com.ziroom.ziroomcustomer.util.p;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.maa.android.agent.instrumentation.Instrumented
public class CleanIndexActivity
  extends BaseSupportURIActivity
  implements View.OnClickListener
{
  private BroadcastReceiver A = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17) {
        CleanIndexActivity.b(CleanIndexActivity.this, true);
      }
    }
  };
  private TextView a;
  private WebView b;
  private String c;
  private String d;
  private String e;
  private Button f;
  private Button g;
  private ImageView r;
  private ImageView s;
  private String t;
  private String u;
  private String v;
  private Context w;
  private boolean x = false;
  private ProgressBar y;
  private PlatformActionListener z = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
    {
      u.d("#########分享取消回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享取消");
    }
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      CleanIndexActivity.this.showToast("分享成功");
      paramAnonymousHashMap = new StringBuilder();
      if (CleanIndexActivity.b(CleanIndexActivity.this) == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.d("#########分享完成回调: 平台  ", bool + "=====" + paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功====" + getClass().getSimpleName());
        return;
      }
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      CleanIndexActivity.this.showToast("分享失败");
      u.d("#########分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败====" + getClass().getSimpleName());
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131689541));
    this.b = ((WebView)findViewById(2131690675));
    this.f = ((Button)findViewById(2131690043));
    this.g = ((Button)findViewById(2131690676));
    this.r = ((ImageView)findViewById(2131690673));
    this.s = ((ImageView)findViewById(2131689492));
    this.y = ((ProgressBar)findViewById(2131690674));
  }
  
  private void a(final boolean paramBoolean)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      if (paramBoolean) {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.w);
      }
      return;
    }
    localObject = ((UserInfo)localObject).getPhone();
    n.requestPeriodToUrl(this.w, (String)localObject, new com.freelxl.baselibrary.d.c.a(new f(bd.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if ((paramBoolean) && (CleanIndexActivity.d(CleanIndexActivity.this)))
        {
          CleanIndexActivity.a(CleanIndexActivity.this, false);
          PeriodCleanerSelectActivity.StartPeriodCleanActivity(CleanIndexActivity.this);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, final bd paramAnonymousbd)
      {
        if (paramAnonymousbd != null)
        {
          if (paramAnonymousbd.getIsReceive().intValue() != 0) {
            break label31;
          }
          CleanIndexActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              new com.ziroom.ziroomcustomer.newServiceList.b.c(CleanIndexActivity.this, paramAnonymousbd).show();
            }
          });
        }
        label31:
        while ((!paramBoolean) || (!CleanIndexActivity.d(CleanIndexActivity.this))) {
          return;
        }
        CleanIndexActivity.a(CleanIndexActivity.this, false);
        PeriodCleanerSelectActivity.StartPeriodCleanActivity(CleanIndexActivity.this);
      }
    });
  }
  
  private void b()
  {
    this.s.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.A, localIntentFilter);
  }
  
  private void d(String paramString)
  {
    n.getServeSuggest(this.w, paramString, new d(this.w, new f(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          CleanIndexActivity.a(CleanIndexActivity.this, paramAnonymouse.getString("serviceIntroduceUrl"));
          if (!TextUtils.isEmpty(CleanIndexActivity.a(CleanIndexActivity.this))) {
            CleanIndexActivity.b(CleanIndexActivity.this, CleanIndexActivity.a(CleanIndexActivity.this));
          }
        }
      }
    });
  }
  
  private void e()
  {
    this.c = getIntent().getStringExtra("isZhengZu");
    this.d = getIntent().getStringExtra("ServiceInfoId");
    this.e = getIntent().getStringExtra("ServiceInfoName");
    Object localObject = getIntent().getStringExtra("enCity");
    this.t = getIntent().getStringExtra("shareImage");
    this.u = getIntent().getStringExtra("serviceContent");
    this.a.setText(this.e + "");
    d(this.d);
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = j.getSplitCityCode((String)localObject, ",").iterator();
      i = 0;
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!b.d.equals(str)) {
          break label352;
        }
        i = 1;
      }
    }
    label339:
    label352:
    for (;;)
    {
      break;
      if (i != 0)
      {
        this.f.setEnabled(true);
        this.r.setVisibility(0);
        if ((("8a90a5d8580a5cb2015822c397920018".equals(this.d)) || ("8a90a5d85841edb0015847dd78a80014".equals(this.d))) && (!"110000".equals(b.d))) {
          this.r.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.t)) {
          this.t = "http://pic.ziroom.com/sms2/pics/20151016/24505b49-894e-43f6-bf8c-9198c33ae16b.png";
        }
        if (TextUtils.isEmpty(this.u)) {
          this.u = "自如这个服务不错，快来预约体验吧~";
        }
        if (!"2c9084454b7835b0014b7841269101a9".equals(this.d)) {
          break label339;
        }
        this.g.setVisibility(0);
        this.f.setText("单次预约");
        this.f.setBackgroundResource(2130839560);
        if (ApplicationEx.c.isLoginState()) {
          f();
        }
      }
      for (;;)
      {
        a(false);
        return;
        this.f.setEnabled(false);
        break;
        this.f.setBackgroundResource(2130837878);
      }
    }
  }
  
  private void e(String paramString)
  {
    this.b.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (!(paramAnonymousWebView instanceof WebView)) {
          paramAnonymousWebView.loadUrl(paramAnonymousString);
        }
        for (;;)
        {
          return true;
          WebviewInstrumentation.loadUrl((WebView)paramAnonymousWebView, paramAnonymousString);
        }
      }
    });
    this.b.setInitialScale(1);
    Object localObject = this.b.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setSupportZoom(true);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setDisplayZoomControls(false);
    this.b.getSettings().setCacheMode(1);
    localObject = this.b;
    if (!(localObject instanceof WebView)) {
      ((WebView)localObject).loadUrl(paramString);
    }
    for (;;)
    {
      paramString = this.b;
      localObject = new WebChromeClient()
      {
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          if ((!CleanIndexActivity.this.isFinishing()) && (CleanIndexActivity.c(CleanIndexActivity.this) != null))
          {
            if ((paramAnonymousInt > 0) && (paramAnonymousInt < 100))
            {
              CleanIndexActivity.c(CleanIndexActivity.this).setProgress(paramAnonymousInt);
              CleanIndexActivity.c(CleanIndexActivity.this).setVisibility(0);
            }
          }
          else {
            return;
          }
          CleanIndexActivity.c(CleanIndexActivity.this).setVisibility(8);
        }
        
        public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        }
      };
      if ((paramString instanceof WebView)) {
        break;
      }
      paramString.setWebChromeClient((WebChromeClient)localObject);
      return;
      WebviewInstrumentation.loadUrl((WebView)localObject, paramString);
    }
    VdsAgent.setWebChromeClient((WebView)paramString, (WebChromeClient)localObject);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.validCycleOrder(this, new d(this, new i())
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if ("0".equals(paramAnonymousString))
        {
          paramAnonymousString = ab.getInstance().getPeriodCleanCheckIn();
          if (!TextUtils.isEmpty(paramAnonymousString)) {
            break label70;
          }
          p.showGuide(CleanIndexActivity.this, "period_clean_01", 2130904688, null, null);
          ab.getInstance().setPeriodCleanCheckIn(System.currentTimeMillis() + "");
        }
        label70:
        while (Long.valueOf(Long.parseLong(paramAnonymousString) - System.currentTimeMillis()).longValue() <= 43200000L) {
          return;
        }
        p.showGuide(CleanIndexActivity.this, "period_clean_01", 2130904688, null, null);
        ab.getInstance().setPeriodCleanCheckIn(System.currentTimeMillis() + "");
      }
    });
  }
  
  private void g()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      startActivity(new Intent(this, ServiceLoginActivity.class));
      g.textToast(this.w, "请先登录");
      return;
    }
    if ("8a90a5d85841edb0015847dd11110000".equals(this.d))
    {
      com.ziroom.ziroomcustomer.newclean.view.a.StartBedroomCleanActivity(this, this.d, this.e);
      return;
    }
    Intent localIntent = new Intent(this, GeneralCleaningActivity.class);
    if ((!TextUtils.isEmpty(this.c)) && ("isZhengZu".equals(this.c))) {
      localIntent.putExtra("isZhengZu", this.c);
    }
    localIntent.putExtra("ServiceInfoId", this.d);
    localIntent.putExtra("ServiceInfoName", this.e);
    startActivity(localIntent);
  }
  
  private void h()
  {
    if (!TextUtils.isEmpty(this.v)) {
      if (!this.v.contains("?")) {
        break label72;
      }
    }
    label72:
    for (String str = this.v + "&plat=web";; str = this.v + "?plat=web")
    {
      com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter(this, str, this.e, this.u, this.t, this.z);
      return;
    }
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690673: 
      h();
      return;
    case 2131690043: 
      g();
      return;
    }
    this.x = true;
    a(true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903186);
    this.w = this;
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(this.A);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanIndexActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */