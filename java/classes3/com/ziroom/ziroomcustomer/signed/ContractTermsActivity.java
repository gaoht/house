package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.c;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.c.r;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.e.m;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.sublet.activity.SubletReservationConfirmActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.HashMap;
import java.util.Map;

public class ContractTermsActivity
  extends BaseActivity
{
  private Handler A = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      ContractTermsActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        paramAnonymousMessage = (String)paramAnonymousMessage.getObject();
        WebView localWebView = ContractTermsActivity.b(ContractTermsActivity.this);
        if (!(localWebView instanceof WebView))
        {
          localWebView.loadDataWithBaseURL(null, paramAnonymousMessage, "text/html", "utf-8", null);
          return;
        }
        WebviewInstrumentation.loadDataWithBaseURL((WebView)localWebView, null, paramAnonymousMessage, "text/html", "utf-8", null);
        return;
      }
      ContractTermsActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  private String B;
  private String C;
  private String D;
  View.OnClickListener a = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      }
      label461:
      do
      {
        final Object localObject1;
        String str1;
        do
        {
          return;
          ContractTermsActivity.this.finish();
          return;
          if (ContractTermsActivity.e(ContractTermsActivity.this) == 0)
          {
            com.freelxl.baselibrary.f.g.textToast(ContractTermsActivity.this.getApplicationContext(), "条款正在加载", 0);
            return;
          }
          if (ContractTermsActivity.e(ContractTermsActivity.this) != 1) {
            break label461;
          }
          if (ContractTermsActivity.d(ContractTermsActivity.this) != 3) {
            break;
          }
          localObject1 = com.alibaba.fastjson.a.parseObject(ContractTermsActivity.f(ContractTermsActivity.this).getSubletReserveCode());
          localObject2 = ((e)localObject1).getString("subletCode");
          String str2 = ((e)localObject1).getString("reservationCode");
          String str3 = ((e)localObject1).getString("reserveType");
          String str4 = ((e)localObject1).getString("houseCode");
          String str5 = ((e)localObject1).getString("houseId");
          String str6 = ((e)localObject1).getString("houseType");
          paramAnonymousView = ((e)localObject1).getString("reserveCode");
          str1 = ((e)localObject1).getString("contract_code");
          localObject1 = ((e)localObject1).getString("confirmType");
          if ("ZZYD".equals(localObject1))
          {
            paramAnonymousView = com.ziroom.ziroomcustomer.e.g.buildGetSubletBookingOrderText(str4, str5, str6, (String)localObject2, str2, str3, ContractTermsActivity.g(ContractTermsActivity.this));
            j.setSubletOrderLease(ContractTermsActivity.h(ContractTermsActivity.this), paramAnonymousView, new f(ContractTermsActivity.h(ContractTermsActivity.this), new r())
            {
              public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
              {
                super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
                u.d("OKHttp_ymq", "===" + paramAnonymous2e.toString());
                paramAnonymous2e.getInteger("error_code").intValue();
                String str2 = paramAnonymous2e.getString("status");
                String str1 = paramAnonymous2e.getString("data");
                paramAnonymous2e = paramAnonymous2e.getString("error_message");
                if ("success".equals(str2))
                {
                  paramAnonymous2e = new Intent(ContractTermsActivity.this, SubletReservationConfirmActivity.class);
                  paramAnonymous2e.putExtra("reserveCode", str1);
                  paramAnonymous2e.putExtra("confirmType", localObject1);
                  ContractTermsActivity.h(ContractTermsActivity.this).startActivity(paramAnonymous2e);
                  return;
                }
                af.showToast(ContractTermsActivity.h(ContractTermsActivity.this), paramAnonymous2e);
              }
            });
            return;
          }
        } while (!"QRYD".equals(localObject1));
        Object localObject2 = new Intent(ContractTermsActivity.this, SubletReservationConfirmActivity.class);
        ((Intent)localObject2).putExtra("reserveCode", paramAnonymousView);
        ((Intent)localObject2).putExtra("confirmType", (String)localObject1);
        ((Intent)localObject2).putExtra("contract_code", str1);
        ContractTermsActivity.h(ContractTermsActivity.this).startActivity((Intent)localObject2);
        return;
        if ((ContractTermsActivity.d(ContractTermsActivity.this) != 2) && (ContractTermsActivity.d(ContractTermsActivity.this) != 3))
        {
          ContractTermsActivity.i(ContractTermsActivity.this);
          w.onEvent(ContractTermsActivity.h(ContractTermsActivity.this), "signup_contract_agree");
          return;
        }
        ContractTermsActivity.b(ContractTermsActivity.this, q.s + e.m.c);
        paramAnonymousView = com.ziroom.ziroomcustomer.e.g.buildGetBookingOrderText(ContractTermsActivity.f(ContractTermsActivity.this).getHouse_code(), ContractTermsActivity.f(ContractTermsActivity.this).getHouse_id(), ContractTermsActivity.f(ContractTermsActivity.this).getHouse_type(), ContractTermsActivity.g(ContractTermsActivity.this));
        j.setOrderLease(ContractTermsActivity.this.getApplicationContext(), new ContractTermsActivity.a(ContractTermsActivity.this), paramAnonymousView, false, ContractTermsActivity.c(ContractTermsActivity.this));
        w.onEvent(ContractTermsActivity.h(ContractTermsActivity.this), "book_contract_agree");
        return;
      } while (ContractTermsActivity.e(ContractTermsActivity.this) != 2);
      com.freelxl.baselibrary.f.g.textToast(ContractTermsActivity.this.getApplicationContext(), "合同条款加载失败，请返回重试", 0);
    }
  };
  private Context b;
  private ImageView c;
  private TextView d;
  private WebView e;
  private Button f;
  private HouseDetail g;
  private int r = 0;
  private String s;
  private String t;
  private String u;
  private String v = "0";
  private String w = "0";
  private String x = "0";
  private int y;
  private String z;
  
  private void a()
  {
    this.s = getIntent().getStringExtra("old_contract_code");
    this.c = ((ImageView)findViewById(2131690105));
    this.d = ((TextView)findViewById(2131689533));
    this.e = ((WebView)findViewById(2131693273));
    this.f = ((Button)findViewById(2131693395));
    this.d.setText("合同条款");
  }
  
  private void b()
  {
    this.c.setOnClickListener(this.a);
    this.f.setOnClickListener(this.a);
    this.e.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        ContractTermsActivity.a(ContractTermsActivity.this, 1);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        ContractTermsActivity.a(ContractTermsActivity.this, 2);
      }
    });
  }
  
  private void e()
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    if (this.s == null)
    {
      localHashMap.put("house_id", this.v);
      localHashMap.put("house_code", this.w);
      localHashMap.put("house_type", this.x);
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.g.appendCommenParams(localHashMap);
      com.freelxl.baselibrary.d.a.post(q.s + e.n.f).tag(this).params(ah.ConvertObjMap2String(localHashMap)).enqueue(new f(this, new o())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          String str = paramAnonymouse.getString("url");
          paramAnonymouse = paramAnonymouse.getString("isShow");
          if ("1".equals(paramAnonymouse))
          {
            if (ae.notNull(paramAnonymouse))
            {
              if (paramAnonymouse.length() <= 0) {
                break label168;
              }
              paramAnonymouse = new Intent(ContractTermsActivity.this.getApplicationContext(), SignedWebActivity.class);
              if (ContractTermsActivity.j(ContractTermsActivity.this) != null) {
                break label124;
              }
              paramAnonymouse.putExtra("detail", ContractTermsActivity.f(ContractTermsActivity.this));
              paramAnonymouse.putExtra("contract_code", ContractTermsActivity.k(ContractTermsActivity.this));
            }
            for (;;)
            {
              paramAnonymouse.putExtra("url", str);
              paramAnonymouse.putExtra("title", "租住公约");
              ContractTermsActivity.this.startActivity(paramAnonymouse);
              return;
              label124:
              if (ae.notNull(ContractTermsActivity.j(ContractTermsActivity.this)))
              {
                paramAnonymouse.putExtra("cityCode", ContractTermsActivity.l(ContractTermsActivity.this));
                paramAnonymouse.putExtra("old_contract_code", ContractTermsActivity.j(ContractTermsActivity.this));
              }
            }
            label168:
            ContractTermsActivity.this.showToast("租住公约获取失败");
            return;
          }
          paramAnonymouse = new Intent(ContractTermsActivity.this.getApplicationContext(), PayInformationActivity.class);
          if (ContractTermsActivity.j(ContractTermsActivity.this) == null)
          {
            paramAnonymouse.putExtra("detail", ContractTermsActivity.f(ContractTermsActivity.this));
            paramAnonymouse.putExtra("contract_code", ContractTermsActivity.k(ContractTermsActivity.this));
          }
          for (;;)
          {
            ContractTermsActivity.this.startActivity(paramAnonymouse);
            return;
            if (ae.notNull(ContractTermsActivity.j(ContractTermsActivity.this)))
            {
              paramAnonymouse.putExtra("cityCode", ContractTermsActivity.l(ContractTermsActivity.this));
              paramAnonymouse.putExtra("old_contract_code", ContractTermsActivity.j(ContractTermsActivity.this));
            }
          }
        }
      });
      return;
      localHashMap.put("oldContractCode", this.s);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903699);
    this.b = this;
    ApplicationEx.c.addActivity(this);
    this.u = getIntent().getStringExtra("cityCode");
    this.g = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    this.t = getIntent().getStringExtra("contract_code");
    this.D = getIntent().getStringExtra("group");
    this.y = getIntent().getIntExtra("type", 0);
    a();
    b();
    if (!ah.checkNet(getApplicationContext()))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    if ((this.y != 2) && (this.y != 3))
    {
      if (this.g != null)
      {
        this.v = this.g.getHouse_id();
        this.w = this.g.getHouse_code();
        this.x = this.g.getHouse_type();
      }
      d.getTerms(this.A, this.v, this.x, this.w, this.t, this.s);
    }
    for (;;)
    {
      showProgress("");
      return;
      if (this.y == 3)
      {
        paramBundle = com.ziroom.ziroomcustomer.e.g.buildContractTerms("ZZYD");
        this.C = (q.s + e.m.b);
        j.getOrderLeaseText(getApplicationContext(), new a(), paramBundle, false, this.C);
      }
      else
      {
        paramBundle = com.ziroom.ziroomcustomer.e.g.getCRMCode(new HashMap());
        this.C = (q.s + e.m.b);
        j.getOrderLeaseText(getApplicationContext(), new a(), paramBundle, false, this.C);
      }
    }
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
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (ContractTermsActivity.a(ContractTermsActivity.this).equals(paramk.getUrl()))
        {
          paramString = com.alibaba.fastjson.a.parseObject(paramString.get("data").toString());
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        while (!ContractTermsActivity.c(ContractTermsActivity.this).equals(paramk.getUrl())) {
          return;
        }
        paramString = paramString.get("data").toString();
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      Object localObject;
      if (paramk.getSuccess().booleanValue()) {
        if (ContractTermsActivity.a(ContractTermsActivity.this).equals(paramk.getUrl()))
        {
          localObject = (Map)paramk.getObject();
          paramk = ((Map)localObject).get("html").toString();
          ContractTermsActivity.a(ContractTermsActivity.this, ((Map)localObject).get("templateCode") + "");
          localObject = ContractTermsActivity.b(ContractTermsActivity.this);
          if (!(localObject instanceof WebView)) {
            ((WebView)localObject).loadDataWithBaseURL(null, paramk, "text/html", "utf-8", null);
          }
        }
      }
      for (;;)
      {
        ContractTermsActivity.this.dismissProgress();
        return;
        WebviewInstrumentation.loadDataWithBaseURL((WebView)localObject, null, paramk, "text/html", "utf-8", null);
        continue;
        if (ContractTermsActivity.c(ContractTermsActivity.this).equals(paramk.getUrl()))
        {
          localObject = (String)paramk.getObject();
          localObject = new Intent(ContractTermsActivity.this.getApplicationContext(), ConfirmContractActivity.class);
          ((Intent)localObject).putExtra("reservationCode", (String)paramk.getObject());
          ((Intent)localObject).putExtra("type", ContractTermsActivity.d(ContractTermsActivity.this));
          ContractTermsActivity.this.startActivity((Intent)localObject);
          continue;
          ContractTermsActivity.this.showToast(paramk.getMessage());
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/ContractTermsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */