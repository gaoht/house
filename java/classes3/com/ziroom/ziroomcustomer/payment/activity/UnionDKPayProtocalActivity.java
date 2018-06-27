package com.ziroom.ziroomcustomer.payment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.itrus.raapi.implement.ClientForAndroid;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.payment.d.b;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.payment.e.a.b;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.util.u;
import java.net.URLEncoder;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class UnionDKPayProtocalActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private WebView a;
  private Button b;
  private String c;
  private String d;
  private boolean e = true;
  private String f;
  private String g;
  private String r;
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setMiddleText("委托银联代扣协议");
    localCommonTitle.setLeftButtonType(2);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UnionDKPayProtocalActivity.this.finish();
      }
    });
  }
  
  private void a(Boolean paramBoolean)
  {
    b.getUnionPaySingleProtocolResult(this, this.d, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = (String)com.alibaba.fastjson.e.parseObject(paramAnonymousString).get("htmlStr");
        UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this, paramAnonymousString);
      }
    });
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      if (ApplicationEx.c.k == null) {
        ApplicationEx.c.k = ClientForAndroid.getInstance(this);
      }
      paramString2 = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    } while (paramString2.length <= 0);
    paramString1 = ApplicationEx.c.k.SignMessage(paramString1, paramString2[0], "SHA1", 1);
    if (TextUtils.isEmpty(paramString1))
    {
      d.errorLog(this, "签名失败", "失败原因是:" + ApplicationEx.c.k.GetLastErrInfo());
      return;
    }
    u.d("ikey", "签名成功签名后字符为:" + paramString1);
    if (this.e)
    {
      a(paramString1, this.e);
      return;
    }
    e(paramString1);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    paramString = toURLEncoded(paramString);
    b.getUnionSingleCheckSignResult(this, this.d, paramString, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if ("true".equals(paramAnonymousString))
        {
          u.d("ikey", "验签成功");
          UnionDKPayProtocalActivity.this.setResult(3);
          UnionDKPayProtocalActivity.this.finish();
          return;
        }
        g.textToast(UnionDKPayProtocalActivity.this, "无纸化验签失败," + paramAnonymousString + "请稍后重试!!!");
        u.d("ikey", "验签失败," + paramAnonymousString);
        d.errorLog(UnionDKPayProtocalActivity.this, "验签失败,", "证书导入失败!!!验签失败," + paramAnonymousString);
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    b.getUnionPaySingleAssembleDataResult(this, this.d, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        String str = (String)com.alibaba.fastjson.e.parseObject(paramAnonymousString).get("singStr");
        u.e("yangxj---获取加密元始字符串", paramAnonymousString);
        UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this, str, UnionDKPayProtocalActivity.e(UnionDKPayProtocalActivity.this));
      }
    });
  }
  
  private void b()
  {
    setContentView(2130903538);
    this.a = ((WebView)findViewById(2131690928));
    this.b = ((Button)findViewById(2131692611));
    this.c = getIntent().getStringExtra("contractCode");
    this.e = getIntent().getBooleanExtra("isSingle", true);
    this.d = getIntent().getStringExtra("cwOrderId");
    this.f = getIntent().getStringExtra("mUserName");
    this.g = getIntent().getStringExtra("mUserCertType");
    this.r = getIntent().getStringExtra("mUserCertNum");
  }
  
  private void d(String paramString)
  {
    if (paramString.isEmpty()) {
      return;
    }
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.getSettings().setLoadWithOverviewMode(true);
    this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    this.a.getSettings().setDefaultFontSize(18);
    WebView localWebView = this.a;
    if (!(localWebView instanceof WebView)) {
      localWebView.loadDataWithBaseURL(null, paramString, "text/html", "utf-8", null);
    }
    for (;;)
    {
      this.a.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
          UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this).setEnabled(true);
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
      WebviewInstrumentation.loadDataWithBaseURL((WebView)localWebView, null, paramString, "text/html", "utf-8", null);
    }
  }
  
  private void e()
  {
    this.b.setOnClickListener(this);
  }
  
  private void e(String paramString)
  {
    paramString = toURLEncoded(paramString);
    b.getUnionCheckSignResult(this, this.c, paramString, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if (1 == ((Integer)com.alibaba.fastjson.e.parseObject(paramAnonymousString).get("result")).intValue())
        {
          u.d("ikey", "验签成功");
          UnionDKPayProtocalActivity.f(UnionDKPayProtocalActivity.this);
          return;
        }
        g.textToast(UnionDKPayProtocalActivity.this, "无纸化验签失败," + paramAnonymousString + "请稍后重试!!!");
        u.d("ikey", "验签失败," + paramAnonymousString);
        d.errorLog(UnionDKPayProtocalActivity.this, "验签失败,", "证书导入失败!!!验签失败," + paramAnonymousString);
      }
    });
  }
  
  private void f()
  {
    b.getUnionPayProtocolResult(this, this.c, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = (String)com.alibaba.fastjson.e.parseObject(paramAnonymousString).get("htmlStr");
        UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this, paramAnonymousString);
      }
    });
  }
  
  private void g()
  {
    b.getUnionPayBindBankCardToContractResult(this, this.c, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        UnionDKPayProtocalActivity.this.setResult(3);
        UnionDKPayProtocalActivity.this.finish();
      }
    });
  }
  
  private void h()
  {
    b.getUnionPayAssembleDataResult(this, this.c, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = (String)com.alibaba.fastjson.e.parseObject(paramAnonymousString).get("originStr");
        u.e("yangxj---获取加密元始字符串", paramAnonymousString);
        UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this, paramAnonymousString, UnionDKPayProtocalActivity.d(UnionDKPayProtocalActivity.this));
      }
    });
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = null;
    if (0 == 0)
    {
      paramView = new HashMap();
      paramView.put("name", this.f);
      paramView.put("mCerType2", this.g + "");
      paramView.put("cerNum", this.r);
      ApplicationEx.c.setUserMap(paramView);
      new com.ziroom.ziroomcustomer.payment.e.a(this, paramView, new a.b()
      {
        public void setSignUpdate()
        {
          if (UnionDKPayProtocalActivity.b(UnionDKPayProtocalActivity.this))
          {
            UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this, UnionDKPayProtocalActivity.b(UnionDKPayProtocalActivity.this));
            return;
          }
          UnionDKPayProtocalActivity.c(UnionDKPayProtocalActivity.this);
        }
      });
      return;
    }
    throw new NullPointerException();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    e();
    a();
    if (this.e)
    {
      a(Boolean.valueOf(this.e));
      return;
    }
    f();
  }
  
  public String toURLEncoded(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    try
    {
      String str = URLEncoder.encode(new String(paramString.getBytes(), "UTF-8"), "UTF-8");
      return str;
    }
    catch (Exception localException)
    {
      u.e("yangxj======", "toURLEncoded error:" + paramString + localException);
    }
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/UnionDKPayProtocalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */