package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.j;

public class ZryuSignContractTermsActivity
  extends BaseActivity
{
  private String a;
  private ImageView b;
  private WebView c;
  private Button d;
  private LinearLayout e;
  private TextView f;
  private final int g = 0;
  private final int r = 1;
  private final int s = 2;
  private int t = 0;
  private c u = new c(this, new d())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      dismissProgress();
      ZryuSignContractTermsActivity.a(ZryuSignContractTermsActivity.this, 2);
      ZryuSignContractTermsActivity.a(ZryuSignContractTermsActivity.this).setVisibility(0);
      ZryuSignContractTermsActivity.c(ZryuSignContractTermsActivity.this).setVisibility(8);
      ZryuSignContractTermsActivity.b(ZryuSignContractTermsActivity.this).setVisibility(8);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      ZryuSignContractTermsActivity.a(ZryuSignContractTermsActivity.this).setVisibility(8);
      if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("contractPage")))
      {
        paramAnonymouse = paramAnonymouse.getString("contractPage");
        if (!TextUtils.isEmpty(paramAnonymouse))
        {
          ZryuSignContractTermsActivity.b(ZryuSignContractTermsActivity.this).setVisibility(0);
          WebView localWebView = ZryuSignContractTermsActivity.b(ZryuSignContractTermsActivity.this);
          if (!(localWebView instanceof WebView)) {
            localWebView.loadDataWithBaseURL(null, paramAnonymouse, "text/html", "utf-8", null);
          }
          for (;;)
          {
            ZryuSignContractTermsActivity.c(ZryuSignContractTermsActivity.this).setVisibility(0);
            return;
            WebviewInstrumentation.loadDataWithBaseURL((WebView)localWebView, null, paramAnonymouse, "text/html", "utf-8", null);
          }
        }
      }
      ZryuSignContractTermsActivity.a(ZryuSignContractTermsActivity.this).setVisibility(0);
      ZryuSignContractTermsActivity.c(ZryuSignContractTermsActivity.this).setVisibility(8);
      ZryuSignContractTermsActivity.b(ZryuSignContractTermsActivity.this).setVisibility(8);
      ZryuSignContractTermsActivity.a(ZryuSignContractTermsActivity.this, 2);
    }
  };
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((WebView)findViewById(2131690675));
    this.d = ((Button)findViewById(2131690043));
    this.c.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        ZryuSignContractTermsActivity.a(ZryuSignContractTermsActivity.this, 1);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceError);
        ZryuSignContractTermsActivity.a(ZryuSignContractTermsActivity.this, 2);
      }
    });
    this.e = ((LinearLayout)findViewById(2131693026));
    this.f = ((TextView)findViewById(2131693027));
  }
  
  private void b()
  {
    this.t = 0;
    this.a = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.a)) {
      j.zryuContractTerms(this, this.a, this.u);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903610);
    a();
    b();
    ApplicationEx.c.addToZryuSign(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeFromZryuSign(this);
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
      b();
      return;
      if (this.t == 1)
      {
        paramView = new Intent(this, ZryuLeaseInfoActivity.class);
        paramView.putExtra("contractId", this.a);
        paramView.putExtra("deCode", "QY");
        startActivity(paramView);
        return;
      }
      if (this.t == 0)
      {
        g.textToast(this, "合同正在加载中");
        return;
      }
    } while (this.t != 2);
    g.textToast(this, "合同加载出错");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignContractTermsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */