package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.b.e;
import com.ziroom.ziroomcustomer.signed.SignerAptitudeActivity;
import com.ziroom.ziroomcustomer.signed.a.i;
import com.ziroom.ziroomcustomer.signed.education.EducationActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.webview.b.a;
import com.ziroom.ziroomcustomer.webview.d;
import java.util.HashMap;
import java.util.Map;

@com.maa.android.agent.instrumentation.Instrumented
public class CreditWebActivity
  extends BaseActivity
{
  protected BridgeWebView a;
  Class b = SignerAptitudeActivity.class;
  private d c;
  private String d;
  private String e = "";
  private TextView f;
  private ImageView g;
  private TextView r;
  private int s;
  
  private void a()
  {
    this.r = ((TextView)findViewById(2131691041));
    this.a = ((BridgeWebView)findViewById(2131689545));
    this.c = new d(this);
    Object localObject1 = this.a;
    Object localObject2 = this.c;
    if (!(localObject1 instanceof WebView)) {
      ((BridgeWebView)localObject1).setWebChromeClient((WebChromeClient)localObject2);
    }
    for (;;)
    {
      this.g = ((ImageView)findViewById(2131689781));
      this.f = ((TextView)findViewById(2131689782));
      this.d = getIntent().getStringExtra("url");
      this.e = getIntent().getStringExtra("title");
      this.s = getIntent().getIntExtra("houseType", 1);
      localObject1 = getIntent().getStringExtra("maimaiClass");
      try
      {
        this.b = Class.forName((String)localObject1);
        this.f.setText(this.e);
        this.r.setOnClickListener(new View.OnClickListener()
        {
          @com.growingio.android.sdk.instrumentation.Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CreditWebActivity.this.finish();
          }
        });
        this.g.setOnClickListener(new View.OnClickListener()
        {
          @com.growingio.android.sdk.instrumentation.Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (CreditWebActivity.this.a.canGoBack())
            {
              CreditWebActivity.this.a.goBack();
              CreditWebActivity.a(CreditWebActivity.this).setVisibility(0);
              return;
            }
            CreditWebActivity.this.finish();
          }
        });
        if (this.d != null)
        {
          localObject1 = this.a;
          localObject2 = this.d;
          if (!(localObject1 instanceof WebView)) {
            ((BridgeWebView)localObject1).loadUrl((String)localObject2);
          }
        }
        else
        {
          localObject1 = this.a.getSettings().getUserAgentString();
          this.a.getSettings().setUserAgentString((String)localObject1 + "HybridAPP/" + "5.6.0" + "/android");
          if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
          }
          return;
          VdsAgent.setWebChromeClient((WebView)localObject1, (WebChromeClient)localObject2);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
          this.b = SignerAptitudeActivity.class;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          localNullPointerException.printStackTrace();
          this.b = SignerAptitudeActivity.class;
          continue;
          WebviewInstrumentation.loadUrl((WebView)localNullPointerException, (String)localObject2);
        }
      }
    }
  }
  
  private void b()
  {
    new com.ziroom.ziroomcustomer.webview.b().toActivity(this.a, new b.a()
    {
      public void onJsLinkCallBack(Object paramAnonymousObject)
      {
        paramAnonymousObject = String.valueOf(paramAnonymousObject);
        if (paramAnonymousObject == null) {
          return;
        }
        int i = -1;
        switch (((String)paramAnonymousObject).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return;
          case 0: 
            new o(CreditWebActivity.this).toDownloadCertificate(0);
            return;
            if (((String)paramAnonymousObject).equals("1"))
            {
              i = 0;
              continue;
              if (((String)paramAnonymousObject).equals("2"))
              {
                i = 1;
                continue;
                if (((String)paramAnonymousObject).equals("3"))
                {
                  i = 2;
                  continue;
                  if (((String)paramAnonymousObject).equals("4")) {
                    i = 3;
                  }
                }
              }
            }
            break;
          }
        }
        paramAnonymousObject = new Intent(CreditWebActivity.this, SignerAptitudeActivity.class);
        ((Intent)paramAnonymousObject).putExtra("activityName", "AccountInfoActivity");
        CreditWebActivity.this.startActivity((Intent)paramAnonymousObject);
        return;
        paramAnonymousObject = new Intent(CreditWebActivity.this, EducationActivity.class);
        CreditWebActivity.this.startActivity((Intent)paramAnonymousObject);
        return;
        CreditWebActivity.b(CreditWebActivity.this);
      }
    });
  }
  
  private void e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this));
    com.freelxl.baselibrary.d.a.get(q.O + "/qualificate/maimai/getmaiinfo.json" + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).tag(this).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.a(this, new e(i.class))
    {
      public void onSuccess(int paramAnonymousInt, i paramAnonymousi)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousi);
        Log.d("maimaiReceive", "maimai= " + paramAnonymousi.toString());
        Intent localIntent = new Intent(CreditWebActivity.this, CreditWebActivity.this.b);
        localIntent.putExtra("maimai", paramAnonymousi);
        CreditWebActivity.this.startActivity(localIntent);
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
    a();
    b();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.a.reload();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/CreditWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */