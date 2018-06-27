package com.ziroom.ziroomcustomer.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.PlatformActionListener;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.webview.X5_ScrollBridgeWebView;
import com.ziroom.ziroomcustomer.webview.c;

@Instrumented
public class FiveYearWebViewActivity
  extends BaseActivity
{
  static X5_ScrollBridgeWebView a;
  public static int b = 20;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  @BindView(2131689781)
  ImageView mIvBack;
  @BindView(2131689782)
  TextView mTvTitle;
  private String r;
  private BroadcastReceiver s = new FiveYearWebViewActivity.10(this);
  private PlatformActionListener t = new FiveYearWebViewActivity.2(this);
  
  private void a()
  {
    this.c = getIntent().getStringExtra("url");
    this.g = getIntent().getStringExtra("title");
    this.r = getIntent().getStringExtra("backStack");
    if (TextUtils.isEmpty(this.g)) {
      this.g = "2017咕咕哒";
    }
    Object localObject1;
    Object localObject2;
    if (this.c != null)
    {
      if (this.c.contains("?")) {
        this.c += "&os=android";
      }
    }
    else
    {
      a = (X5_ScrollBridgeWebView)findViewById(2131690590);
      this.d = a.getToken(this);
      this.e = a.getUid(this);
      localObject1 = ((ApplicationEx)getApplication()).getUser();
      if (localObject1 != null) {
        this.f = ((UserInfo)localObject1).getMobile();
      }
      this.mIvBack.setOnClickListener(new FiveYearWebViewActivity.1(this));
      this.mTvTitle.setText(this.g);
      new c().fiveGetToken(a, new FiveYearWebViewActivity.3(this));
      new c().fiveLogin(a, new FiveYearWebViewActivity.4(this));
      new c().fiveShare(a, new FiveYearWebViewActivity.5(this));
      new c().fiveBack(a, new FiveYearWebViewActivity.6(this));
      new c().goListPage(a, new FiveYearWebViewActivity.7(this));
      a.getSettings().setJavaScriptEnabled(true);
      a.setWebViewClient(new FiveYearWebViewActivity.8(this, a));
      localObject1 = a;
      localObject2 = new FiveYearWebViewActivity.9(this);
      if ((localObject1 instanceof com.tencent.smtt.sdk.WebView)) {
        break label385;
      }
      ((X5_ScrollBridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
    }
    for (;;)
    {
      localObject1 = a;
      localObject2 = this.c;
      if ((localObject1 instanceof android.webkit.WebView)) {
        break label396;
      }
      ((X5_ScrollBridgeWebView)localObject1).loadUrl((String)localObject2);
      return;
      this.c += "?os=android";
      break;
      label385:
      VdsAgent.setWebChromeClient((com.tencent.smtt.sdk.WebView)localObject1, (WebChromeClient)localObject2);
    }
    label396:
    WebviewInstrumentation.loadUrl((android.webkit.WebView)localObject1, (String)localObject2);
  }
  
  private void b()
  {
    this.d = a.getToken(this);
    this.e = a.getUid(this);
    Object localObject = ((ApplicationEx)getApplication()).getUser();
    if (localObject != null) {
      this.f = ((UserInfo)localObject).getMobile();
    }
    if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.e)))
    {
      localObject = new e();
      ((e)localObject).put("token", "");
      ((e)localObject).put("uid", "");
      new c().fiveH5LoginCallback(a, ((e)localObject).toJSONString());
      return;
    }
    localObject = new e();
    ((e)localObject).put("token", this.d);
    ((e)localObject).put("uid", this.e);
    new c().fiveH5LoginCallback(a, ((e)localObject).toJSONString());
  }
  
  public static void sendShareCallback()
  {
    if (a != null) {
      new c().fiveH5ShareCallback(a);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0)
    {
      e locale = new e();
      locale.put("token", "");
      locale.put("uid", "");
      locale.put("isLoginCancel", "1");
      new c().fiveH5LoginCallback(a, locale.toJSONString());
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903176);
    ButterKnife.bind(this);
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.s, paramBundle);
    a();
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.s);
    if (a != null)
    {
      a.destroy();
      a = null;
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    b = 20;
  }
  
  protected void onResume()
  {
    super.onResume();
    b = 10;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/FiveYearWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */