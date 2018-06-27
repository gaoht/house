package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.Map;

public class ReservationTermsActivity
  extends BaseActivity
{
  View.OnClickListener a = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      }
      ReservationTermsActivity.this.finish();
    }
  };
  private ImageView b;
  private TextView c;
  private WebView d;
  private String e;
  private String f;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131690105));
    this.c = ((TextView)findViewById(2131689533));
    this.d = ((WebView)findViewById(2131693273));
    this.c.setText("预订协议");
  }
  
  private void b()
  {
    this.b.setOnClickListener(this.a);
    this.d.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905098);
    ApplicationEx.c.addActivity(this);
    this.e = getIntent().getStringExtra("reserveCode");
    a();
    b();
    if (!ah.checkNet(getApplicationContext()))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    paramBundle = com.ziroom.ziroomcustomer.e.g.buildGetreserveData(this.e);
    this.f = (q.s + e.q.B);
    j.getOrderLeaseText(getApplicationContext(), new a(), paramBundle, false, this.f);
    showProgress("");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
  }
  
  @com.maa.android.agent.instrumentation.Instrumented
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (ReservationTermsActivity.a(ReservationTermsActivity.this).equals(paramk.getUrl()))
        {
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString.get("data").toString());
        }
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      String str;
      if (paramk.getSuccess().booleanValue())
      {
        str = (String)paramk.getObject();
        if (ReservationTermsActivity.a(ReservationTermsActivity.this).equals(paramk.getUrl()))
        {
          paramk = ReservationTermsActivity.b(ReservationTermsActivity.this);
          if ((paramk instanceof WebView)) {
            break label69;
          }
          paramk.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        }
      }
      for (;;)
      {
        ReservationTermsActivity.this.dismissProgress();
        return;
        label69:
        WebviewInstrumentation.loadDataWithBaseURL((WebView)paramk, null, str, "text/html", "utf-8", null);
        continue;
        ReservationTermsActivity.this.showToast(paramk.getMessage());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/ReservationTermsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */