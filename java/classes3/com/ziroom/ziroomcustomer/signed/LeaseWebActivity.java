package com.ziroom.ziroomcustomer.signed;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import java.util.HashMap;
import java.util.Map;

public class LeaseWebActivity
  extends BaseActivity
{
  private WebView a;
  private String b;
  private RelativeLayout c;
  private Handler d = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        paramAnonymousMessage = LeaseWebActivity.c(LeaseWebActivity.this);
        String str = LeaseWebActivity.b(LeaseWebActivity.this);
        if (!(paramAnonymousMessage instanceof WebView)) {
          paramAnonymousMessage.loadDataWithBaseURL("", str, "text/html", "utf-8", "");
        }
        for (;;)
        {
          LeaseWebActivity.this.dismissProgress();
          return;
          WebviewInstrumentation.loadDataWithBaseURL((WebView)paramAnonymousMessage, "", str, "text/html", "utf-8", "");
        }
      }
      LeaseWebActivity.this.showEmpty(LeaseWebActivity.d(LeaseWebActivity.this), "无合同文本信息");
      LeaseWebActivity.this.dismissProgress();
    }
  };
  
  private void a()
  {
    Object localObject = getIntent();
    String str1 = ((Intent)localObject).getStringExtra("isChangeSign");
    String str2 = ((Intent)localObject).getStringExtra("contractCode");
    localObject = ((Intent)localObject).getStringExtra("sysContractId");
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", str2);
    localHashMap.put("sysContractId", localObject);
    if (str1 != null) {
      localHashMap.put("oldCon", str1);
    }
    localHashMap.put("uid", ApplicationEx.c.getUserId(this));
    showProgress("合同加载中");
    j.getLeaseWebText(this, localHashMap, new a());
  }
  
  private void b()
  {
    this.c = ((RelativeLayout)findViewById(2131692103));
    this.a = ((WebView)findViewById(2131696711));
    this.a.setWebViewClient(new WebViewClient());
    this.a.getSettings().setBuiltInZoomControls(true);
    this.a.getSettings().setDisplayZoomControls(false);
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    this.a.getSettings().setUseWideViewPort(true);
    this.a.getSettings().setLoadWithOverviewMode(true);
  }
  
  public void back(View paramView)
  {
    setResult(0, getIntent());
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904846);
    b();
    a();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      try
      {
        paramString = a.parseObject(paramString);
        if ("success".equals((String)paramString.get("status")))
        {
          LeaseWebActivity.a(LeaseWebActivity.this, paramString.get("data").toString());
          LeaseWebActivity.a(LeaseWebActivity.this).sendEmptyMessage(0);
          return;
        }
        paramString = (String)paramString.get("error_message");
        LeaseWebActivity.a(LeaseWebActivity.this).sendEmptyMessage(1);
        LeaseWebActivity.this.showToast(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        paramString.printStackTrace();
        LeaseWebActivity.a(LeaseWebActivity.this).sendEmptyMessage(1);
        return;
      }
      finally {}
    }
    
    public void onSuccess(k paramk) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/LeaseWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */