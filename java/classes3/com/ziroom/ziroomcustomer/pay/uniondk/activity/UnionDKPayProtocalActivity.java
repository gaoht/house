package com.ziroom.ziroomcustomer.pay.uniondk.activity;

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
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.itrus.raapi.implement.ClientForAndroid;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.pay.common.c.a.b;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKAssenble;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKAssenble.DataBean;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKCheckSign;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKCheckSign.DataBean;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayProtocol;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayProtocol.DataBean;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.util.u;
import java.net.URLEncoder;
import java.util.HashMap;

@com.maa.android.agent.instrumentation.Instrumented
public class UnionDKPayProtocalActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private CommonTitle a;
  private WebView b;
  private Button c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  private void a()
  {
    this.a = ((CommonTitle)findViewById(2131691272));
    this.a.setMiddleText("委托银联代扣协议");
    this.a.setLeftButtonType(2);
    this.a.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UnionDKPayProtocalActivity.this.setResult(-1);
        UnionDKPayProtocalActivity.this.finish();
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
    e(paramString1);
  }
  
  private void b()
  {
    setContentView(2130903538);
    this.b = ((WebView)findViewById(2131690928));
    this.c = ((Button)findViewById(2131692611));
    this.d = getIntent().getStringExtra("contractCode");
    this.e = getIntent().getStringExtra("mUserName");
    this.f = getIntent().getStringExtra("mUserCertType");
    this.g = getIntent().getStringExtra("mUserCertNum");
  }
  
  private void d(String paramString)
  {
    if (paramString.isEmpty()) {
      return;
    }
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    this.b.getSettings().setDefaultFontSize(18);
    WebView localWebView = this.b;
    if (!(localWebView instanceof WebView)) {
      localWebView.loadDataWithBaseURL(null, paramString, "text/html", "utf-8", null);
    }
    for (;;)
    {
      this.b.setWebViewClient(new WebViewClient()
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
    this.c.setOnClickListener(this);
  }
  
  private void e(String paramString)
  {
    paramString = toURLEncoded(paramString);
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionCheckSignResult(this, this.d, paramString, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        u.e("yangxj---校验加密", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          UnionDKCheckSign localUnionDKCheckSign = (UnionDKCheckSign)paramAnonymousk.getObject();
          if ((localUnionDKCheckSign == null) || (localUnionDKCheckSign.getData() == null)) {
            return;
          }
          if ((localUnionDKCheckSign.isSuccess()) && (localUnionDKCheckSign.getData().getResult() == 1))
          {
            u.d("ikey", "验签成功");
            UnionDKPayProtocalActivity.d(UnionDKPayProtocalActivity.this);
            return;
          }
          g.textToast(UnionDKPayProtocalActivity.this, "无纸化验签失败," + paramAnonymousk.getMessage() + "请稍后重试!!!");
          u.d("ikey", "验签失败," + paramAnonymousk.getMessage());
          d.errorLog(UnionDKPayProtocalActivity.this, "验签失败,", "证书导入失败!!!验签失败," + paramAnonymousk.getMessage());
          return;
        }
        g.textToast(UnionDKPayProtocalActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  private void f()
  {
    showProgress("");
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayProtocolResult(this, this.d, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        UnionDKPayProtocalActivity.this.dismissProgress();
        u.e("yangxj-----", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          paramAnonymousk = (UnionDKPayProtocol)paramAnonymousk.getObject();
          if ((paramAnonymousk == null) || (paramAnonymousk.data == null)) {
            return;
          }
          if (paramAnonymousk.isSuccess())
          {
            UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this, paramAnonymousk.data.htmlStr);
            return;
          }
          g.textToast(UnionDKPayProtocalActivity.this, paramAnonymousk.getError_message());
          return;
        }
        g.textToast(UnionDKPayProtocalActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  private void g()
  {
    showProgress("");
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayBindBankCardToContractResult(this, this.d, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        u.e("yangxj------", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        UnionDKPayProtocalActivity.this.dismissProgress();
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          g.textToast(UnionDKPayProtocalActivity.this, "银联代扣绑定合同成功!");
          UnionDKPayProtocalActivity.this.setResult(-1);
          UnionDKPayProtocalActivity.this.finish();
          return;
        }
        g.textToast(UnionDKPayProtocalActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayAssembleDataResult(this, this.d, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        u.e("yangxj---获取加密元始字符串", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          paramAnonymousk = (UnionDKAssenble)paramAnonymousk.getObject();
          if ((paramAnonymousk == null) || (paramAnonymousk.getData() == null)) {
            return;
          }
          if (paramAnonymousk.isSuccess())
          {
            UnionDKPayProtocalActivity.a(UnionDKPayProtocalActivity.this, paramAnonymousk.getData().getOriginStr(), UnionDKPayProtocalActivity.c(UnionDKPayProtocalActivity.this));
            return;
          }
          g.textToast(UnionDKPayProtocalActivity.this, paramAnonymousk.getError_message());
          return;
        }
        g.textToast(UnionDKPayProtocalActivity.this, paramAnonymousk.getMessage());
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
      paramView.put("name", this.e);
      paramView.put("mCerType2", this.f + "");
      paramView.put("cerNum", this.g);
      ApplicationEx.c.setUserMap(paramView);
      new com.ziroom.ziroomcustomer.pay.common.c.a(this, paramView, new a.b()
      {
        public void setSignUpdate()
        {
          UnionDKPayProtocalActivity.b(UnionDKPayProtocalActivity.this);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/activity/UnionDKPayProtocalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */