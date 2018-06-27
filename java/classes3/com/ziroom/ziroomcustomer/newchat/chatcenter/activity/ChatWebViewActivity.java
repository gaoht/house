package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.MessageCenterActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.minsu.chat.j;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Instrumented
public class ChatWebViewActivity
  extends BaseActivity
{
  BridgeWebView a;
  private final int b = 1;
  private final int c = 3;
  private final int d = 2;
  private ProgressBar e;
  private int f;
  private int g;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690144)
  ImageView myinfoChat;
  @BindView(2131690145)
  ImageView myinfoChatRedPoint;
  @BindView(2131690146)
  TextView myinfoChatRedPointNum;
  @BindView(2131690189)
  ImageView myinfoTitleIcon;
  private int r;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  private int s;
  private int t;
  private String u;
  private com.ziroom.ziroomcustomer.webview.a v;
  private String w = "";
  private com.ziroom.ziroomcustomer.newchat.chatcenter.c.b x;
  private HomeWatcherReceiver y;
  private boolean z = false;
  
  private static long a(File paramFile)
  {
    long l = 0L;
    if (paramFile.exists()) {}
    try
    {
      int i = new FileInputStream(paramFile).available();
      l = i;
      return l;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return 0L;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return 0L;
  }
  
  private void a()
  {
    this.y = new HomeWatcherReceiver();
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    registerReceiver(this.y, localIntentFilter);
  }
  
  private void b()
  {
    this.f = ApplicationEx.c.getUnReadNum();
    this.g = ApplicationEx.c.getMisuNum();
    this.r = j.getUnReadMsgSize(2);
    if (!ae.isNull(this.u))
    {
      f.getUnreadNum(this, new com.freelxl.baselibrary.d.c.a(new m(com.alibaba.fastjson.e.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          ChatWebViewActivity.a(ChatWebViewActivity.this, 0);
          ChatWebViewActivity.b(ChatWebViewActivity.this, ChatWebViewActivity.b(ChatWebViewActivity.this));
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          com.freelxl.baselibrary.f.d.d("OKHttp", "Push ZRK getUnreadNum success,detail as below");
          if (paramAnonymouse != null)
          {
            ChatWebViewActivity.a(ChatWebViewActivity.this, paramAnonymouse.getInteger("unread").intValue());
            com.freelxl.baselibrary.f.d.d("OKHttp", "Push resp sysMessNum: " + ChatWebViewActivity.b(ChatWebViewActivity.this));
          }
          for (;;)
          {
            ChatWebViewActivity.b(ChatWebViewActivity.this, ChatWebViewActivity.b(ChatWebViewActivity.this));
            return;
            ChatWebViewActivity.a(ChatWebViewActivity.this, 0);
          }
        }
      }, com.ziroom.ziroomcustomer.service.d.buildGetUnreadNum(this, com.ziroom.ziroomcustomer.service.d.a, h.toMd5(this.u.getBytes()), com.ziroom.ziroomcustomer.service.e.getLastSyncTime(this)));
      return;
    }
    b(this.s);
  }
  
  private void b(int paramInt)
  {
    this.t = (this.r + this.f + this.g);
    if (this.t > 0)
    {
      this.myinfoChatRedPoint.setVisibility(8);
      this.myinfoChatRedPointNum.setVisibility(0);
      if (this.t <= 99) {
        this.myinfoChatRedPointNum.setText(this.t + "");
      }
      while (this.myinfoChatRedPointNum.getText().toString().trim().length() <= 1)
      {
        this.myinfoChatRedPointNum.setBackgroundResource(2130839386);
        return;
        this.myinfoChatRedPointNum.setText("99+");
      }
      this.myinfoChatRedPointNum.setBackgroundResource(2130837779);
      return;
    }
    if (paramInt > 0) {
      this.myinfoChatRedPoint.setVisibility(0);
    }
    for (;;)
    {
      this.myinfoChatRedPointNum.setVisibility(8);
      return;
      this.myinfoChatRedPoint.setVisibility(8);
    }
  }
  
  private void e()
  {
    localObject1 = ApplicationEx.c.getUser();
    if (localObject1 != null) {
      this.u = ((UserInfo)localObject1).getUid();
    }
    this.a = ((BridgeWebView)findViewById(2131689545));
    localObject1 = this.a;
    Object localObject2 = new WebChromeClient();
    if (!(localObject1 instanceof WebView))
    {
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
      localObject1 = this.a.getSettings().getUserAgentString();
      this.a.getSettings().setUserAgentString((String)localObject1 + "HybridAPP/" + "5.6.0" + "/android");
      this.e = ((ProgressBar)findViewById(2131690674));
      this.a.getSettings().setJavaScriptEnabled(true);
      this.a.setWebViewClient(new a(this.a));
      this.x = new com.ziroom.ziroomcustomer.newchat.chatcenter.c.b(this)
      {
        public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
        {
          super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
          if ((!ChatWebViewActivity.this.isFinishing()) && (ChatWebViewActivity.c(ChatWebViewActivity.this) != null))
          {
            if ((paramAnonymousInt > 0) && (paramAnonymousInt < 100))
            {
              ChatWebViewActivity.c(ChatWebViewActivity.this).setProgress(paramAnonymousInt);
              ChatWebViewActivity.c(ChatWebViewActivity.this).setVisibility(0);
            }
          }
          else {
            return;
          }
          ChatWebViewActivity.c(ChatWebViewActivity.this).setVisibility(8);
        }
        
        public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        }
      };
      localObject1 = this.a;
      localObject2 = this.x;
      if ((localObject1 instanceof WebView)) {
        break label404;
      }
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
      label190:
      this.v = new com.ziroom.ziroomcustomer.webview.a()
      {
        protected void a()
        {
          super.a();
          Intent localIntent = new Intent(ChatWebViewActivity.this, MainActivity.class);
          localIntent.putExtra("FRAGMENT_TYPE", 7);
          ChatWebViewActivity.this.startActivityAndFinish(localIntent);
        }
        
        protected void a(com.alibaba.fastjson.e paramAnonymouse)
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
              paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(ChatWebViewActivity.this, false, 1, true, 600, k, i, j);
            }
          }
          for (;;)
          {
            ChatWebViewActivity.this.startActivityForResult(paramAnonymouse, 3);
            return;
            paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(ChatWebViewActivity.this, false, 1, false, 0, 0);
            continue;
            paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(ChatWebViewActivity.this, false, 1, false, 0, 0);
          }
        }
        
        protected void b(com.alibaba.fastjson.e paramAnonymouse)
        {
          super.b(paramAnonymouse);
          paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(ChatWebViewActivity.this, false, 1, true, 600, 600);
          ChatWebViewActivity.this.startActivityForResult(paramAnonymouse, 1);
        }
        
        protected void c(com.alibaba.fastjson.e paramAnonymouse)
        {
          super.c(paramAnonymouse);
          paramAnonymouse = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(ChatWebViewActivity.this, false, 1, false, 0, 0);
          ChatWebViewActivity.this.startActivityForResult(paramAnonymouse, 2);
        }
        
        protected void d(com.alibaba.fastjson.e paramAnonymouse) {}
        
        protected void e(com.alibaba.fastjson.e paramAnonymouse)
        {
          super.e(paramAnonymouse);
        }
      };
      this.v.init(this, this.a);
      localObject1 = "";
      if (ApplicationEx.c.getUser() != null) {
        localObject1 = ApplicationEx.c.getUser().getNickName();
      }
    }
    for (Object localObject4 = com.ziroom.ziroomcustomer.base.b.d;; localObject4 = localObject1)
    {
      for (;;)
      {
        label404:
        try
        {
          localObject2 = URLEncoder.encode((String)localObject1, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1) {}
        try
        {
          localObject1 = URLEncoder.encode((String)localObject4, "UTF-8");
          localObject4 = localObject2;
          localObject2 = localObject1;
          this.w = q.p;
          if (!TextUtils.isEmpty(this.w))
          {
            localObject2 = "&token=" + com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c) + "&username=" + (String)localObject4 + "&citycode=" + (String)localObject2 + "&cityname=" + com.ziroom.ziroomcustomer.base.b.c + "&app_version=" + "5.6.0" + "&os=android";
            localObject1 = this.a;
            localObject2 = this.w + (String)localObject2;
            if ((localObject1 instanceof WebView)) {
              break label427;
            }
            ((BridgeWebView)localObject1).loadUrl((String)localObject2);
          }
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;)
          {
            localObject1 = localObject3;
            Object localObject3 = localUnsupportedEncodingException2;
          }
        }
      }
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
      break;
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
      break label190;
      localUnsupportedEncodingException1.printStackTrace();
      localObject3 = localObject4;
    }
    label427:
    WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject3);
  }
  
  private void f()
  {
    g();
    finish();
  }
  
  private void g()
  {
    if ((com.ziroom.ziroomcustomer.base.e.isApplicationInForeground()) || (!com.ziroom.ziroomcustomer.base.e.isApplicationVisible()))
    {
      this.z = true;
      this.v.doCallH5("http://zrquestiondetaillinktourltypedidenterbackground.ziroom.com", null);
    }
  }
  
  private void h()
  {
    if (this.z)
    {
      this.z = false;
      this.v.doCallH5("http://zrquestiondetaillinktourltypedidbecomeactive.ziroom.com", null);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      f();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      if (this.x.b == null) {
        break label118;
      }
      if ((paramIntent != null) && (paramInt2 == -1)) {
        break label88;
      }
    }
    label88:
    for (Object localObject = null;; localObject = paramIntent.getData())
    {
      if (localObject == null) {
        break label194;
      }
      localObject = com.ziroom.ziroomcustomer.social.b.b.saveImageToGallery(new File(ah.getImageAbsolutePath(this, (Uri)localObject)));
      if (a((File)localObject) <= 3145728L) {
        break;
      }
      g.textToast(this, "你好，上传图片的大小需不超过3M");
      this.x.b.onReceiveValue(null);
      return;
    }
    localObject = Uri.fromFile((File)localObject);
    this.x.b.onReceiveValue(localObject);
    label118:
    if (this.x.c != null)
    {
      if ((paramIntent == null) || (paramInt2 != -1)) {
        localObject = null;
      }
      for (;;)
      {
        if (localObject != null)
        {
          paramIntent = com.ziroom.ziroomcustomer.social.b.b.saveImageToGallery(new File(ah.getImageAbsolutePath(this, (Uri)localObject)));
          if (a(paramIntent) > 3145728L)
          {
            g.textToast(this, "你好，上传图片的大小需不超过3M");
            this.x.c.onReceiveValue(null);
            return;
            label194:
            this.x.b.onReceiveValue(null);
            break;
            localObject = paramIntent.getData();
            continue;
          }
          paramIntent = Uri.fromFile(paramIntent);
          this.x.c.onReceiveValue(new Uri[] { paramIntent });
        }
      }
    }
    for (;;)
    {
      this.x.b = null;
      this.x.c = null;
      return;
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = com.ziroom.ziroomcustomer.social.b.b.saveImageToGallery(new File(ad.savePic((Bitmap)paramIntent.getExtras().get("data"))));
        if (a(paramIntent) > 3145728L)
        {
          g.textToast(this, "你好，上传图片的大小需不超过3M");
          this.x.c.onReceiveValue(null);
          return;
        }
        paramIntent = Uri.fromFile(paramIntent);
        this.x.c.onReceiveValue(new Uri[] { paramIntent });
      }
      else
      {
        this.x.c.onReceiveValue(null);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903133);
    ButterKnife.bind(this);
    e();
    b();
    a();
  }
  
  protected void onDestroy()
  {
    g();
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
    if (this.y != null) {}
    try
    {
      unregisterReceiver(this.y);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
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
    h();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  @OnClick({2131689492, 2131690144})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    startActivity(new Intent(this, MessageCenterActivity.class));
  }
  
  public class HomeWatcherReceiver
    extends BroadcastReceiver
  {
    public HomeWatcherReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      Log.i("ChatWebViewActivity", "intentAction =" + paramContext);
      if (TextUtils.equals(paramContext, "android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        Log.i("ChatWebViewActivity", "reason =" + paramContext);
        ChatWebViewActivity.a(ChatWebViewActivity.this);
      }
    }
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
      if (ChatWebViewActivity.this.a.canGoBack()) {}
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (paramSslError.getPrimaryError() == 5)
      {
        if (com.freelxl.baselibrary.d.b.isSSLCertOk(paramSslError.getCertificate(), com.freelxl.baselibrary.d.b.a)) {
          paramSslErrorHandler.proceed();
        }
        paramWebView = Uri.parse(ChatWebViewActivity.d(ChatWebViewActivity.this));
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
          paramWebResourceRequest = new WebResourceResponse("text/javascript", "UTF-8", ChatWebViewActivity.this.getAssets().open("WebViewJavascriptBridge.js"));
          return paramWebResourceRequest;
        }
        catch (IOException paramWebResourceRequest)
        {
          paramWebResourceRequest.printStackTrace();
        }
      }
      return paramWebView;
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (paramString.contains("tel:"))
      {
        paramWebView = new Intent("android.intent.action.CALL", Uri.parse(paramString));
        ChatWebViewActivity.this.startActivity(paramWebView);
        return true;
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/ChatWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */