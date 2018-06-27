package com.ziroom.ziroomcustomer.webview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.freelxl.baselibrary.webview.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class WebVideoActivity
  extends BaseActivity
  implements PlatformActionListener
{
  protected BridgeWebView a;
  private d b;
  private String c;
  private String d = "";
  private String e = "";
  private String f = "";
  private TextView g;
  private ImageView r;
  private ImageView s;
  private String t;
  
  private void a()
  {
    this.a = ((BridgeWebView)findViewById(2131689545));
    this.b = new d(this);
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    if (!(localObject1 instanceof WebView))
    {
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
      localObject1 = this.a.getSettings().getUserAgentString();
      this.a.getSettings().setUserAgentString((String)localObject1 + "HybridAPP/" + "5.6.0" + "/android");
      this.r = ((ImageView)findViewById(2131689781));
      this.g = ((TextView)findViewById(2131689782));
      this.s = ((ImageView)findViewById(2131691042));
      this.f = getIntent().getStringExtra("ziru");
      this.c = getIntent().getStringExtra("url");
      this.d = getIntent().getStringExtra("title");
      this.e = getIntent().getStringExtra("content");
      this.t = getIntent().getStringExtra("pic");
      u.i("ymq+++", "ziru:" + this.f + ";mUrl:" + this.c);
      this.s.setVisibility(8);
      if (TextUtils.isEmpty(this.t)) {
        this.t = "http://pic.ziroom.com/sms2/pics/20151016/24505b49-894e-43f6-bf8c-9198c33ae16b.png";
      }
      if (TextUtils.isEmpty(this.d)) {
        this.e = "自如APP";
      }
      if (TextUtils.isEmpty(this.e)) {
        this.e = "自如APP";
      }
      this.g.setText(this.d);
      this.r.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          WebVideoActivity.this.finish();
        }
      });
      if (!TextUtils.isEmpty(this.c))
      {
        localObject1 = this.a;
        localObject2 = this.c;
        if ((localObject1 instanceof WebView)) {
          break label386;
        }
        ((BridgeWebView)localObject1).loadUrl((String)localObject2);
      }
    }
    for (;;)
    {
      this.a.setWebViewClient(new a(this.a));
      return;
      VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
      break;
      label386:
      WebviewInstrumentation.loadUrl((WebView)localObject1, (String)localObject2);
    }
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    new Message();
    showToast("分享取消");
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903376);
    a();
  }
  
  protected void onDestroy()
  {
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
    super.onDestroy();
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
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.a.reload();
  }
  
  class a
    extends c
  {
    public a(BridgeWebView paramBridgeWebView)
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (ae.isNull(WebVideoActivity.a(WebVideoActivity.this))) {
        WebVideoActivity.b(WebVideoActivity.this).setText(paramWebView.getTitle());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/WebVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */