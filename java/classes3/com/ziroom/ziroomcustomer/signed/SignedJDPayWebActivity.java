package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.wxapi.a;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class SignedJDPayWebActivity
  extends BaseActivity
  implements Handler.Callback, PlatformActionListener
{
  private String A;
  private ProgressBar B;
  private LinearLayout C;
  View.OnClickListener a = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      paramAnonymousView = SignedJDPayWebActivity.b(SignedJDPayWebActivity.this);
      String str = SignedJDPayWebActivity.d(SignedJDPayWebActivity.this);
      if (!(paramAnonymousView instanceof WebView)) {
        paramAnonymousView.loadUrl(str);
      }
      for (;;)
      {
        SignedJDPayWebActivity.a(SignedJDPayWebActivity.this).setVisibility(8);
        SignedJDPayWebActivity.b(SignedJDPayWebActivity.this).setVisibility(0);
        return;
        WebviewInstrumentation.loadUrl((WebView)paramAnonymousView, str);
      }
    }
  };
  View.OnClickListener b = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131697535: 
        Log.e("QQ", "QQ");
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(SignedJDPayWebActivity.d(SignedJDPayWebActivity.this));
        paramAnonymousView.setText(SignedJDPayWebActivity.l(SignedJDPayWebActivity.this));
        paramAnonymousView.setImageUrl(SignedJDPayWebActivity.m(SignedJDPayWebActivity.this) + "");
        localObject = ShareSDK.getPlatform(QQ.NAME);
        ((Platform)localObject).setPlatformActionListener(SignedJDPayWebActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697536: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个活动不错。");
        paramAnonymousView.setTitleUrl(SignedJDPayWebActivity.d(SignedJDPayWebActivity.this));
        paramAnonymousView.setText(SignedJDPayWebActivity.l(SignedJDPayWebActivity.this));
        paramAnonymousView.setImageUrl(SignedJDPayWebActivity.m(SignedJDPayWebActivity.this) + "");
        paramAnonymousView.setSite("自如");
        paramAnonymousView.setSiteUrl("www.ziroom.com");
        localObject = ShareSDK.getPlatform(QZone.NAME);
        ((Platform)localObject).setPlatformActionListener(SignedJDPayWebActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697537: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如这个房子不错。");
        paramAnonymousView.setTitleUrl(SignedJDPayWebActivity.d(SignedJDPayWebActivity.this));
        paramAnonymousView.setText("自如这个活动不错. " + SignedJDPayWebActivity.l(SignedJDPayWebActivity.this) + " @自如客 " + SignedJDPayWebActivity.d(SignedJDPayWebActivity.this));
        paramAnonymousView.setImageUrl(SignedJDPayWebActivity.m(SignedJDPayWebActivity.this) + "");
        localObject = ShareSDK.getPlatform(SinaWeibo.NAME);
        ((Platform)localObject).setPlatformActionListener(SignedJDPayWebActivity.this);
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697538: 
        paramAnonymousView = new WXWebpageObject();
        paramAnonymousView.webpageUrl = SignedJDPayWebActivity.d(SignedJDPayWebActivity.this);
        paramAnonymousView = new WXMediaMessage(paramAnonymousView);
        paramAnonymousView.title = ("自如这个活动不错 " + SignedJDPayWebActivity.l(SignedJDPayWebActivity.this));
        paramAnonymousView.description = SignedJDPayWebActivity.l(SignedJDPayWebActivity.this);
        paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(SignedJDPayWebActivity.this.getResources(), 2130838626), true);
        localObject = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
        ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
        ((SendMessageToWX.Req)localObject).scene = 1;
        SignedJDPayWebActivity.e(SignedJDPayWebActivity.this).sendReq((BaseReq)localObject);
        return;
      }
      paramAnonymousView = new WXWebpageObject();
      paramAnonymousView.webpageUrl = SignedJDPayWebActivity.d(SignedJDPayWebActivity.this);
      paramAnonymousView = new WXMediaMessage(paramAnonymousView);
      paramAnonymousView.title = "自如这个活动不错。";
      paramAnonymousView.description = SignedJDPayWebActivity.l(SignedJDPayWebActivity.this);
      paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(SignedJDPayWebActivity.this.getResources(), 2130838626), true);
      Object localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
      SignedJDPayWebActivity.e(SignedJDPayWebActivity.this).sendReq((BaseReq)localObject);
    }
  };
  private Context c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private WebView r;
  private LinearLayout s;
  private LinearLayout t;
  private LinearLayout u;
  private LinearLayout v;
  private LinearLayout w;
  private IWXAPI x;
  private String y;
  private String z;
  
  private void a()
  {
    this.g = ((TextView)findViewById(2131697243));
    this.C = ((LinearLayout)findViewById(2131690929));
    this.B = ((ProgressBar)findViewById(2131690188));
    this.e = ((ImageView)findViewById(2131691042));
    this.r = ((WebView)findViewById(2131695910));
    this.d = ((ImageView)findViewById(2131690105));
    this.f = ((TextView)findViewById(2131689533));
    this.y = getIntent().getStringExtra("url");
    this.z = getIntent().getStringExtra("title");
    this.A = getIntent().getStringExtra("pic");
    WebView localWebView;
    Object localObject;
    if (this.A != null)
    {
      this.e.setVisibility(0);
      this.g.setVisibility(8);
      this.f.setText(this.z);
      localWebView = this.r;
      localObject = this.y;
      if ((localWebView instanceof WebView)) {
        break label284;
      }
      localWebView.loadUrl((String)localObject);
      label187:
      this.r.getSettings().setJavaScriptEnabled(true);
      localWebView = this.r;
      localObject = new a();
      if ((localWebView instanceof WebView)) {
        break label295;
      }
      localWebView.setWebChromeClient((WebChromeClient)localObject);
    }
    for (;;)
    {
      this.r.setLayerType(1, null);
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = SignedJDPayWebActivity.this.getIntent();
          SignedJDPayWebActivity.this.setResult(98, paramAnonymousView);
          SignedJDPayWebActivity.this.finish();
        }
      });
      this.r.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          u.e("WebView_URL", "url = " + paramAnonymousString);
        }
        
        public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          Log.e("url", "错了错了错了错了  ddd" + paramAnonymousString2 + "ddd" + paramAnonymousString1);
          SignedJDPayWebActivity.a(SignedJDPayWebActivity.this).setVisibility(0);
          SignedJDPayWebActivity.b(SignedJDPayWebActivity.this).setVisibility(8);
        }
        
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
      return;
      this.e.setVisibility(8);
      this.g.setVisibility(0);
      break;
      label284:
      WebviewInstrumentation.loadUrl((WebView)localWebView, (String)localObject);
      break label187;
      label295:
      VdsAgent.setWebChromeClient((WebView)localWebView, (WebChromeClient)localObject);
    }
  }
  
  private void b()
  {
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (BaseActivity.checkNet(SignedJDPayWebActivity.this.getApplicationContext()))
        {
          if (SignedJDPayWebActivity.d(SignedJDPayWebActivity.this) != null)
          {
            SignedJDPayWebActivity.a(SignedJDPayWebActivity.this, WXAPIFactory.createWXAPI(SignedJDPayWebActivity.this, "wxc2bae7e8ecb7d70b", true));
            SignedJDPayWebActivity.e(SignedJDPayWebActivity.this).registerApp("wxc2bae7e8ecb7d70b");
            paramAnonymousView = LayoutInflater.from(SignedJDPayWebActivity.f(SignedJDPayWebActivity.this)).inflate(2130905131, null);
            SignedJDPayWebActivity.a(SignedJDPayWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697535));
            SignedJDPayWebActivity.b(SignedJDPayWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697536));
            SignedJDPayWebActivity.c(SignedJDPayWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697537));
            SignedJDPayWebActivity.d(SignedJDPayWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697539));
            SignedJDPayWebActivity.e(SignedJDPayWebActivity.this, (LinearLayout)paramAnonymousView.findViewById(2131697538));
            SignedJDPayWebActivity.g(SignedJDPayWebActivity.this).setOnClickListener(SignedJDPayWebActivity.this.b);
            SignedJDPayWebActivity.h(SignedJDPayWebActivity.this).setOnClickListener(SignedJDPayWebActivity.this.b);
            SignedJDPayWebActivity.i(SignedJDPayWebActivity.this).setOnClickListener(SignedJDPayWebActivity.this.b);
            SignedJDPayWebActivity.j(SignedJDPayWebActivity.this).setOnClickListener(SignedJDPayWebActivity.this.b);
            SignedJDPayWebActivity.k(SignedJDPayWebActivity.this).setOnClickListener(SignedJDPayWebActivity.this.b);
            Dialog localDialog = new Dialog(SignedJDPayWebActivity.this, 2131427781);
            localDialog.setContentView(paramAnonymousView);
            if (!(localDialog instanceof Dialog))
            {
              localDialog.show();
              return;
            }
            VdsAgent.showDialog((Dialog)localDialog);
            return;
          }
          g.textToast(SignedJDPayWebActivity.f(SignedJDPayWebActivity.this), "房源尚未加载完成", 0);
          return;
        }
        g.textToast(SignedJDPayWebActivity.f(SignedJDPayWebActivity.this), "网络连接错误", 0);
      }
    });
    this.g.setOnClickListener(this.a);
    this.C.setOnClickListener(this.a);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      return false;
      showToast("分享成功");
      continue;
      showToast("分享取消");
    }
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    showToast("分享取消");
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904645);
    this.c = this;
    MobSDK.init(this.c);
    a();
    b();
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    showToast("分享失败");
    if ("SinaWeibo".equals(paramPlatform.getName()))
    {
      ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
      ShareSDK.removeCookieOnAuthorize(true);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.r.canGoBack()))
    {
      this.r.goBack();
      return true;
    }
    setResult(98, getIntent());
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a
    extends WebChromeClient
  {
    a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      SignedJDPayWebActivity.c(SignedJDPayWebActivity.this).setProgress(paramInt);
      if (paramInt == 100) {
        SignedJDPayWebActivity.c(SignedJDPayWebActivity.this).setVisibility(8);
      }
      for (;;)
      {
        super.onProgressChanged(paramWebView, paramInt);
        return;
        SignedJDPayWebActivity.c(SignedJDPayWebActivity.this).setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignedJDPayWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */