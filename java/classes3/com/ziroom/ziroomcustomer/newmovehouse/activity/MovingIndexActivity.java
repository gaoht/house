package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseSupportURIActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.a.h;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveNoPayBean;
import com.ziroom.ziroomcustomer.newmovehouse.mvp.OrderDetailActivity;
import com.ziroom.ziroomcustomer.util.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.maa.android.agent.instrumentation.Instrumented
public class MovingIndexActivity
  extends BaseSupportURIActivity
  implements View.OnClickListener
{
  private ImageView a;
  private ImageView b;
  private BridgeWebView c;
  private Button d;
  private TextView e;
  private String f;
  private String g;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private com.ziroom.ziroomcustomer.webview.a x;
  private ProgressBar y;
  private PlatformActionListener z = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
    {
      u.d("#########分享取消回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享取消");
    }
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      MovingIndexActivity.this.showToast("分享成功");
      u.d("#########分享完成回调: 平台  ", "=====" + paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功====" + getClass().getSimpleName());
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      MovingIndexActivity.this.showToast("分享失败");
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
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((ImageView)findViewById(2131690673));
    this.c = ((BridgeWebView)findViewById(2131690675));
    this.d = ((Button)findViewById(2131690043));
    this.e = ((TextView)findViewById(2131689541));
    this.y = ((ProgressBar)findViewById(2131690674));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void d(String paramString)
  {
    n.getServeSuggest(this, paramString, new d(this, new f(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          MovingIndexActivity.a(MovingIndexActivity.this, paramAnonymouse.getString("serviceIntroduceUrl"));
          if (!TextUtils.isEmpty(MovingIndexActivity.a(MovingIndexActivity.this))) {
            MovingIndexActivity.b(MovingIndexActivity.this, MovingIndexActivity.a(MovingIndexActivity.this));
          }
        }
      }
    });
  }
  
  private void e()
  {
    this.f = getIntent().getStringExtra("productCode");
    this.s = getIntent().getStringExtra("shareImage");
    this.t = getIntent().getStringExtra("serviceContent");
    this.u = getIntent().getStringExtra("enCity");
    this.v = getIntent().getStringExtra("recommendCode");
    this.w = getIntent().getStringExtra("channelCode");
    u.d("onServiceAction_index", "====  recommendCode=" + this.v + "   channelCode=" + this.w);
    int i;
    if (!TextUtils.isEmpty(this.u))
    {
      Iterator localIterator = j.getSplitCityCode(this.u, ",").iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!b.d.equals(str)) {
          break label441;
        }
        i = 1;
      }
    }
    label315:
    label441:
    for (;;)
    {
      break;
      if (i != 0)
      {
        this.d.setEnabled(true);
        this.d.setText("立即预约");
        d(this.f);
        if ((this.f == null) || (!this.f.equals("8a908eb161d66afc0161fa59fd210009"))) {
          break label315;
        }
        this.g = "自如小搬";
        GrowingIO.getInstance().setPageName(this, "xiaomian");
      }
      for (;;)
      {
        this.b.setVisibility(0);
        if (TextUtils.isEmpty(this.s)) {
          this.s = "http://pic.ziroom.com/sms2/pics/20151016/24505b49-894e-43f6-bf8c-9198c33ae16b.png";
        }
        if (TextUtils.isEmpty(this.t)) {
          this.t = "自如这个服务不错，快来预约体验吧~";
        }
        this.e.setText(this.g);
        return;
        this.d.setEnabled(false);
        this.d.setText("敬请期待");
        break;
        if ((this.f != null) && (this.f.equals("2c9085f248ba3f3a0148bb156f6e0004")))
        {
          this.g = "自如中搬";
          GrowingIO.getInstance().setPageName(this, "xiaoban");
        }
        else if ((this.f != null) && (this.f.equals("8a90a5f8593e65b501593e65b5200000")))
        {
          this.g = "自如大搬";
          GrowingIO.getInstance().setPageName(this, "xianghuo");
          if ("330100".equals(b.d))
          {
            this.d.setText("敬请期待");
            findViewById(2131690043).setBackgroundColor(-2236963);
            findViewById(2131690043).setClickable(false);
          }
        }
      }
    }
  }
  
  private void e(String paramString)
  {
    Object localObject = this.c.getSettings().getUserAgentString();
    this.c.getSettings().setUserAgentString((String)localObject + "HybridAPP/" + "5.6.0" + "/android");
    this.c.getSettings().setJavaScriptEnabled(true);
    this.c.getSettings().setSupportZoom(true);
    this.c.getSettings().setBuiltInZoomControls(true);
    this.c.getSettings().setDisplayZoomControls(false);
    this.c.setWebViewClient(new a(this.c));
    localObject = this.c;
    WebChromeClient local5 = new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        if ((!MovingIndexActivity.this.isFinishing()) && (MovingIndexActivity.e(MovingIndexActivity.this) != null))
        {
          if ((paramAnonymousInt > 0) && (paramAnonymousInt < 100))
          {
            MovingIndexActivity.e(MovingIndexActivity.this).setProgress(paramAnonymousInt);
            MovingIndexActivity.e(MovingIndexActivity.this).setVisibility(0);
          }
        }
        else {
          return;
        }
        MovingIndexActivity.e(MovingIndexActivity.this).setVisibility(8);
      }
      
      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
      }
    };
    if (!(localObject instanceof WebView))
    {
      ((BridgeWebView)localObject).setWebChromeClient(local5);
      this.x = new com.ziroom.ziroomcustomer.webview.a();
      this.x.init(this, this.c);
      if (!TextUtils.isEmpty(paramString)) {
        if (!paramString.contains("?")) {
          break label244;
        }
      }
    }
    label244:
    for (paramString = paramString + "&app_version=" + "5.6.0" + "&os=android";; paramString = paramString + "?app_version=" + "5.6.0" + "&os=android")
    {
      localObject = this.c;
      if ((localObject instanceof WebView)) {
        break label280;
      }
      ((BridgeWebView)localObject).loadUrl(paramString);
      return;
      VdsAgent.setWebChromeClient((WebView)localObject, local5);
      break;
    }
    label280:
    WebviewInstrumentation.loadUrl((WebView)localObject, paramString);
  }
  
  private void f()
  {
    Intent localIntent;
    if ("8a908eb161d66afc0161fa59fd210009".equals(this.f))
    {
      localIntent = new Intent(this, RefactorMHMainActivity.class);
      localIntent.putExtra("serviceInfoId", this.f);
      localIntent.putExtra("recommendCode", this.v);
      localIntent.putExtra("channelCode", this.w);
      startActivity(localIntent);
    }
    do
    {
      return;
      if ("2c9085f248ba3f3a0148bb156f6e0004".equals(this.f))
      {
        localIntent = new Intent(this, RefactorMHMainActivity.class);
        localIntent.putExtra("serviceInfoId", this.f);
        localIntent.putExtra("recommendCode", this.v);
        localIntent.putExtra("channelCode", this.w);
        startActivity(localIntent);
        return;
      }
    } while (!"8a90a5f8593e65b501593e65b5200000".equals(this.f));
    h();
  }
  
  private void g()
  {
    if (TextUtils.isEmpty(this.f))
    {
      g.textToast(this, "服务类型为空");
      return;
    }
    if (!ApplicationEx.c.isLoginState())
    {
      startActivity(new Intent(this, ServiceLoginActivity.class));
      g.textToast(this, "请先登录");
      return;
    }
    n.requestIsHaveNoPay(this, new d(this, new f(MoveNoPayBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, final MoveNoPayBean paramAnonymousMoveNoPayBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMoveNoPayBean);
        if ((paramAnonymousMoveNoPayBean != null) && (paramAnonymousMoveNoPayBean.getIsHave() != null))
        {
          if (paramAnonymousMoveNoPayBean.getIsHave().intValue() != 0) {
            break label35;
          }
          MovingIndexActivity.b(MovingIndexActivity.this);
        }
        label35:
        while (paramAnonymousMoveNoPayBean.getIsHave().intValue() != 1) {
          return;
        }
        String str1 = paramAnonymousMoveNoPayBean.getContent();
        final String str2 = paramAnonymousMoveNoPayBean.getLogicCode();
        paramAnonymousMoveNoPayBean = paramAnonymousMoveNoPayBean.getProductCode();
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(MovingIndexActivity.this).setTitle("提示").setBtnCancelText("放弃预约").setBtnConfirmText("去支付").setContent(str1).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2View = new Intent(MovingIndexActivity.this, OrderDetailActivity.class);
              paramAnonymous2View.putExtra("orderId", str2);
              if (!"8a908eb161d66afc0161fa59fd210009".equals(paramAnonymousMoveNoPayBean)) {
                break label65;
              }
              paramAnonymous2View.putExtra("moveOrderType", "move_xiaomian");
            }
            for (;;)
            {
              MovingIndexActivity.this.startActivity(paramAnonymous2View);
              return;
              label65:
              if ("2c9085f248ba3f3a0148bb156f6e0004".equals(paramAnonymousMoveNoPayBean)) {
                paramAnonymous2View.putExtra("moveOrderType", "move_small");
              } else if ("8a90a5f8593e65b501593e65b5200000".equals(paramAnonymousMoveNoPayBean)) {
                paramAnonymous2View.putExtra("moveOrderType", "move_van");
              }
            }
          }
        }).build().show();
      }
    });
  }
  
  private void h()
  {
    Object localObject = ApplicationEx.c.getUser();
    String str1 = "";
    String str2 = "";
    if ((localObject != null) && (ApplicationEx.c.isLoginState()))
    {
      if (!TextUtils.isEmpty(((UserInfo)localObject).getRealName())) {
        str1 = ((UserInfo)localObject).getRealName();
      }
      if (!TextUtils.isEmpty(((UserInfo)localObject).getPhone())) {
        str2 = ((UserInfo)localObject).getPhone();
      }
      localObject = ((UserInfo)localObject).getUid();
      n.getMvToken(this, this.f, (String)localObject, str1, str2, new com.ziroom.ziroomcustomer.e.a.a(this, new k(new h()))
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("userToken")))
          {
            Intent localIntent = new Intent(MovingIndexActivity.this, MovingVanActivity.class);
            localIntent.putExtra("token", paramAnonymouse.getString("userToken"));
            localIntent.putExtra("productCategoryCode", paramAnonymouse.getString("productCategoryCode"));
            localIntent.putExtra("recommendCode", MovingIndexActivity.c(MovingIndexActivity.this));
            localIntent.putExtra("channelCode", MovingIndexActivity.d(MovingIndexActivity.this));
            MovingIndexActivity.this.startActivity(localIntent);
          }
        }
      });
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void i()
  {
    if (!TextUtils.isEmpty(this.r)) {
      if (!this.r.contains("?")) {
        break label72;
      }
    }
    label72:
    for (String str = this.r + "&plat=web";; str = this.r + "?plat=web")
    {
      com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter(this, str, this.g, this.t, this.s, this.z);
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
      i();
      return;
    }
    g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903362);
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    if (this.c != null)
    {
      this.c.destroy();
      this.c = null;
    }
    super.onDestroy();
  }
  
  class a
    extends com.freelxl.baselibrary.webview.c
  {
    public a(BridgeWebView paramBridgeWebView)
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
      if (paramWebResourceRequest.getUrl().toString().endsWith("WebViewJavascriptBridge.js")) {
        try
        {
          paramWebResourceRequest = new WebResourceResponse("text/javascript", "UTF-8", MovingIndexActivity.this.getAssets().open("WebViewJavascriptBridge.js"));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingIndexActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */