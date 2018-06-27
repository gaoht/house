package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.termination.a.b;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.b;
import com.ziroom.ziroomcustomer.webview.b.a;
import java.util.HashMap;
import java.util.Map;

@com.maa.android.agent.instrumentation.Instrumented
public class SignedWebActivity
  extends BaseActivity
{
  protected BridgeWebView a;
  private com.ziroom.ziroomcustomer.webview.d b;
  private String c;
  private String d = "";
  private TextView e;
  private ImageView f;
  private TextView g;
  private int r;
  private String s;
  private HouseDetail t;
  private String u;
  private String v;
  private e w;
  private com.ziroom.ziroomcustomer.webview.a x;
  
  private void a()
  {
    this.s = getIntent().getStringExtra("contract_code");
    this.u = getIntent().getStringExtra("old_contract_code");
    this.v = getIntent().getStringExtra("cityCode");
    this.t = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    this.c = getIntent().getStringExtra("url");
    this.d = getIntent().getStringExtra("title");
    this.r = getIntent().getIntExtra("houseType", 1);
  }
  
  private void b()
  {
    this.g = ((TextView)findViewById(2131691041));
    this.a = ((BridgeWebView)findViewById(2131689545));
    this.b = new com.ziroom.ziroomcustomer.webview.d(this);
    BridgeWebView localBridgeWebView = this.a;
    Object localObject = this.b;
    if (!(localBridgeWebView instanceof WebView))
    {
      localBridgeWebView.setWebChromeClient((WebChromeClient)localObject);
      this.f = ((ImageView)findViewById(2131689781));
      this.e = ((TextView)findViewById(2131689782));
      a();
      this.e.setText(this.d);
      this.g.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          SignedWebActivity.this.finish();
        }
      });
      this.f.setOnClickListener(new View.OnClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (SignedWebActivity.this.a.canGoBack())
          {
            SignedWebActivity.this.a.goBack();
            SignedWebActivity.a(SignedWebActivity.this).setVisibility(0);
            return;
          }
          SignedWebActivity.this.finish();
        }
      });
      this.x = new com.ziroom.ziroomcustomer.webview.a() {};
      this.x.init(this, this.a);
      com.freelxl.baselibrary.f.d.e("mUrlmUrlmUrlmUrlmUrl", "" + this.c);
      if (this.c != null)
      {
        localBridgeWebView = this.a;
        localObject = this.c;
        if ((localBridgeWebView instanceof WebView)) {
          break label254;
        }
        localBridgeWebView.loadUrl((String)localObject);
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        WebView.setWebContentsDebuggingEnabled(true);
      }
      this.a.setWebViewClient(new a(this.a));
      return;
      VdsAgent.setWebChromeClient((WebView)localBridgeWebView, (WebChromeClient)localObject);
      break;
      label254:
      WebviewInstrumentation.loadUrl((WebView)localBridgeWebView, (String)localObject);
    }
  }
  
  private void e()
  {
    new b().toSign(this.a, new b.a()
    {
      public void onJsLinkCallBack(Object paramAnonymousObject)
      {
        paramAnonymousObject = (String)paramAnonymousObject;
        paramAnonymousObject = new Intent(SignedWebActivity.this.getApplicationContext(), PayInformationActivity.class);
        if (SignedWebActivity.d(SignedWebActivity.this) == null)
        {
          ((Intent)paramAnonymousObject).putExtra("detail", SignedWebActivity.e(SignedWebActivity.this));
          ((Intent)paramAnonymousObject).putExtra("contract_code", SignedWebActivity.f(SignedWebActivity.this));
        }
        for (;;)
        {
          SignedWebActivity.this.startActivity((Intent)paramAnonymousObject);
          w.onEvent(SignedWebActivity.this.getApplicationContext(), "convention_agree");
          return;
          if (ae.notNull(SignedWebActivity.d(SignedWebActivity.this)))
          {
            ((Intent)paramAnonymousObject).putExtra("cityCode", SignedWebActivity.g(SignedWebActivity.this));
            ((Intent)paramAnonymousObject).putExtra("old_contract_code", SignedWebActivity.d(SignedWebActivity.this));
          }
        }
      }
    });
    new b().finishBindCard(this.a, new b.a()
    {
      public void onJsLinkCallBack(Object paramAnonymousObject)
      {
        paramAnonymousObject = new Intent(SignedWebActivity.this.getApplicationContext(), ContractTermsActivity.class);
        if (SignedWebActivity.d(SignedWebActivity.this) == null)
        {
          ((Intent)paramAnonymousObject).putExtra("detail", SignedWebActivity.e(SignedWebActivity.this));
          ((Intent)paramAnonymousObject).putExtra("contract_code", SignedWebActivity.f(SignedWebActivity.this));
        }
        for (;;)
        {
          SignedWebActivity.this.startActivity((Intent)paramAnonymousObject);
          SignedWebActivity.this.finish();
          return;
          if (ae.notNull(SignedWebActivity.d(SignedWebActivity.this)))
          {
            ((Intent)paramAnonymousObject).putExtra("cityCode", SignedWebActivity.g(SignedWebActivity.this));
            ((Intent)paramAnonymousObject).putExtra("old_contract_code", SignedWebActivity.d(SignedWebActivity.this));
          }
        }
      }
    });
    new b().confirmChangeCard(this.a, new b.a()
    {
      public void onJsLinkCallBack(Object paramAnonymousObject)
      {
        if (paramAnonymousObject == null) {}
        com.ziroom.ziroomcustomer.termination.a locala;
        do
        {
          do
          {
            return;
            SignedWebActivity.this.showProgress("无纸化验签", 5000L);
            locala = new com.ziroom.ziroomcustomer.termination.a(SignedWebActivity.this, null, null, SignedWebActivity.this.q, 1);
            locala.setmPaperless(new a.b()
            {
              public void Attestation(String paramAnonymous2String)
              {
                SignedWebActivity.this.dismissProgress();
                com.freelxl.baselibrary.d.a.isLog(true);
                HashMap localHashMap = new HashMap();
                localHashMap.put("encypt", paramAnonymous2String + "");
                localHashMap.put("type", "2");
                localHashMap.put("code", SignedWebActivity.h(SignedWebActivity.this).get("rent_contract_code") + "" + SignedWebActivity.h(SignedWebActivity.this).get("user_bank_no"));
                localHashMap.put("interfaceId", "56");
                g.appendCommenParamsString(localHashMap);
                com.freelxl.baselibrary.d.a.post(q.s + e.n.X).tag(this).params(localHashMap).enqueue(new f(SignedWebActivity.this, new o())
                {
                  public void onSuccess(int paramAnonymous3Int, e paramAnonymous3e)
                  {
                    super.onSuccess(paramAnonymous3Int, paramAnonymous3e);
                    u.d("OKHttp", "===" + paramAnonymous3e.toString());
                    new b().getSignCallback(SignedWebActivity.this.a);
                  }
                });
              }
              
              public void DownloadError() {}
              
              public void DownloadSuccess() {}
            });
            paramAnonymousObject = e.parseObject((String)paramAnonymousObject);
          } while (paramAnonymousObject == null);
          SignedWebActivity.a(SignedWebActivity.this, e.parseObject(((e)paramAnonymousObject).get("param").toString()));
        } while (SignedWebActivity.h(SignedWebActivity.this) == null);
        locala.checkSign(SignedWebActivity.h(SignedWebActivity.this).get("initial_param").toString());
      }
    });
  }
  
  public void onBackPressed()
  {
    if (this.a.canGoBack())
    {
      this.a.goBack();
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903376);
    b();
    e();
  }
  
  protected void onRestart()
  {
    super.onRestart();
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
      if (ae.isNull(SignedWebActivity.b(SignedWebActivity.this))) {
        SignedWebActivity.c(SignedWebActivity.this).setText(paramWebView.getTitle());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignedWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */