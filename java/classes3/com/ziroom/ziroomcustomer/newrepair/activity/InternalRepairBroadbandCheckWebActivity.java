package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlib.utils.h;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;

@com.maa.android.agent.instrumentation.Instrumented
public class InternalRepairBroadbandCheckWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private String B;
  private String C;
  private String D;
  private String E;
  private String F;
  private int G;
  private String H;
  private String I;
  private String J;
  private Context K;
  private boolean L = false;
  private String M = "";
  private ImageView a;
  private WebView b;
  private LinearLayout c;
  private Button d;
  private Button e;
  private String f;
  private String g;
  private String r;
  private String s;
  private boolean t;
  private String u;
  private String v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  private void a()
  {
    this.K = this;
    this.a = ((ImageView)findViewById(2131690588));
    this.b = ((WebView)findViewById(2131690999));
    this.c = ((LinearLayout)findViewById(2131691000));
    this.d = ((Button)findViewById(2131691001));
    this.e = ((Button)findViewById(2131691002));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void e()
  {
    this.L = getIntent().getBooleanExtra("isMyFragment", false);
    this.f = getIntent().getStringExtra("repairFaultPic");
    this.g = getIntent().getStringExtra("repairFaultName");
    this.r = getIntent().getStringExtra("repairFaultArea");
    this.s = getIntent().getStringExtra("repairFaultAreaId");
    this.t = getIntent().getBooleanExtra("isChosenOther", false);
    this.u = getIntent().getStringExtra("isUrgencyOtherRepair");
    this.v = getIntent().getStringExtra("repairFaultDescOtherTagName");
    this.w = getIntent().getStringExtra("repairFaultDescOtherTagId");
    this.x = getIntent().getStringExtra("repairFaultDesc");
    this.y = getIntent().getStringExtra("isUrgencyRepair");
    this.z = getIntent().getStringExtra("repairFaultDescTagName");
    this.A = getIntent().getStringExtra("repairFaultDescTagId");
    this.B = getIntent().getStringExtra("repairGoodsCode");
    this.C = getIntent().getStringExtra("mPicsJsonStr");
    this.D = getIntent().getStringExtra("chosenServiceAddress");
    this.E = getIntent().getStringExtra("chosenServiceDate");
    this.F = getIntent().getStringExtra("orderData");
    this.G = getIntent().getIntExtra("orderPeriod", -1);
    this.H = getIntent().getStringExtra("orderTimeInterval");
    this.I = getIntent().getStringExtra("connectPhone");
    this.J = getIntent().getStringExtra("leaveMessage");
    if (getIntent().getBooleanExtra("isShowButton", false))
    {
      this.c.setVisibility(0);
      if (2 != h.getsEnvironment()) {
        break label344;
      }
      this.M = "http://www.t.ziroom.com/zhuanti/2017/fuwu/weixiu/kdzj/index.html";
    }
    for (;;)
    {
      setWeb(this.M);
      return;
      this.c.setVisibility(8);
      break;
      label344:
      if (4 == h.getsEnvironment()) {
        this.M = "https://zhuanti.ziroom.com/zhuanti/2017/fuwu/weixiu/kdzj/index.html";
      } else {
        this.M = "https://zhuanti.ziroom.com/zhuanti/2017/fuwu/weixiu/kdzj/index.html";
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690588: 
      onBackPressed();
      return;
    case 2131691001: 
      paramView = new Intent(this.K, MainActivity.class);
      if (this.L) {
        paramView.putExtra("FRAGMENT_TYPE", 7);
      }
      for (;;)
      {
        startActivityAndFinish(paramView);
        return;
        paramView.putExtra("FRAGMENT_TYPE", 4);
      }
    }
    paramView = new Intent(this.K, InternalRepairFaultCommitActivity.class);
    paramView.putExtra("repairFaultPic", this.f);
    paramView.putExtra("repairFaultName", this.g);
    paramView.putExtra("repairFaultArea", this.r);
    paramView.putExtra("repairFaultAreaId", this.s);
    paramView.putExtra("isChosenOther", this.t);
    paramView.putExtra("isUrgencyOtherRepair", this.u);
    paramView.putExtra("repairFaultDescOtherTagName", this.v);
    paramView.putExtra("repairFaultDescOtherTagId", this.w);
    paramView.putExtra("repairFaultDesc", this.x);
    paramView.putExtra("isUrgencyRepair", this.y);
    paramView.putExtra("repairFaultDescTagName", this.z);
    paramView.putExtra("repairFaultDescTagId", this.A);
    paramView.putExtra("repairGoodsCode", this.B);
    paramView.putExtra("mPicsJsonStr", this.C);
    paramView.putExtra("chosenServiceAddress", this.D);
    paramView.putExtra("chosenServiceDate", this.E);
    paramView.putExtra("orderData", this.F);
    paramView.putExtra("orderPeriod", this.G);
    paramView.putExtra("orderTimeInterval", this.H);
    paramView.putExtra("connectPhone", this.I);
    paramView.putExtra("leaveMessage", this.J);
    startActivity(paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903226);
    a();
    b();
    e();
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.onResume();
  }
  
  public void setWeb(String paramString)
  {
    this.b.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        InternalRepairBroadbandCheckWebActivity.this.dismissProgress();
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
    if (!(localObject instanceof WebView))
    {
      ((WebView)localObject).loadUrl(paramString);
      return;
    }
    WebviewInstrumentation.loadUrl((WebView)localObject, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairBroadbandCheckWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */