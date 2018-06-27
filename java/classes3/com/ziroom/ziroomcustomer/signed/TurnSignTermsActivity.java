package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.itrus.raapi.implement.ClientForAndroid;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TurnSignTermsActivity
  extends BaseActivity
{
  List<r> a;
  View.OnClickListener b = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
      case 2131690105: 
      case 2131693395: 
        do
        {
          return;
          TurnSignTermsActivity.this.finish();
          return;
          if (TurnSignTermsActivity.a(TurnSignTermsActivity.this) == 0)
          {
            g.textToast(TurnSignTermsActivity.this.getApplicationContext(), "条款正在加载", 0);
            return;
          }
          if (TurnSignTermsActivity.a(TurnSignTermsActivity.this) == 1)
          {
            paramAnonymousView = a.toJSONString(TurnSignTermsActivity.b(TurnSignTermsActivity.this));
            TurnSignTermsActivity.a(TurnSignTermsActivity.this, TurnSignTermsActivity.c(TurnSignTermsActivity.this), paramAnonymousView);
            TurnSignTermsActivity.this.showProgress("");
            return;
          }
        } while (TurnSignTermsActivity.a(TurnSignTermsActivity.this) != 2);
        g.textToast(TurnSignTermsActivity.this.getApplicationContext(), "合同条款加载失败，请返回重试", 0);
        return;
      }
      TurnSignTermsActivity.d(TurnSignTermsActivity.this).dismiss();
      paramAnonymousView = new Intent(TurnSignTermsActivity.this, MainActivity.class);
      TurnSignTermsActivity.this.startActivity(paramAnonymousView);
      TurnSignTermsActivity.this.finish();
    }
  };
  private ImageView c;
  private TextView d;
  private WebView e;
  private Button f;
  private int g = 0;
  private List<q> r;
  private List<Contract> s;
  private View t;
  private TextView u;
  private TextView v;
  private ListView w;
  private Dialog x;
  private Handler y = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 69697: 
        do
        {
          return;
          paramAnonymousMessage = (l)paramAnonymousMessage.obj;
          if (!paramAnonymousMessage.getSuccess().booleanValue()) {
            break;
          }
          TurnSignTermsActivity.this.a = ((List)paramAnonymousMessage.getObject());
        } while (TurnSignTermsActivity.this.a == null);
        paramAnonymousMessage = TurnSignTermsActivity.this.a.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          localObject = (r)paramAnonymousMessage.next();
          TurnSignTermsActivity.a(TurnSignTermsActivity.this, ((r)localObject).getSign_data(), ((r)localObject).getContract_code());
        }
        TurnSignTermsActivity.this.showToast(paramAnonymousMessage.getMessage());
        TurnSignTermsActivity.this.dismissProgress();
        return;
      case 69698: 
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          d.setTurnSignStyle(TurnSignTermsActivity.c(TurnSignTermsActivity.this), "3", "2", TurnSignTermsActivity.this);
          return;
        }
        g.textToast(TurnSignTermsActivity.this, "无纸化验签失败," + paramAnonymousMessage.getMessage() + "请稍后重试!!!", 1);
        d.errorLog(TurnSignTermsActivity.this, "验签失败,", "证书导入失败!!!验签失败," + paramAnonymousMessage.getMessage());
        TurnSignTermsActivity.a(TurnSignTermsActivity.this, null);
        return;
      case 69654: 
        TurnSignTermsActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          paramAnonymousMessage = (String)paramAnonymousMessage.getObject();
          localObject = TurnSignTermsActivity.e(TurnSignTermsActivity.this);
          if (!(localObject instanceof WebView))
          {
            ((WebView)localObject).loadDataWithBaseURL(null, paramAnonymousMessage, "text/html", "utf-8", null);
            return;
          }
          WebviewInstrumentation.loadDataWithBaseURL((WebView)localObject, null, paramAnonymousMessage, "text/html", "utf-8", null);
          return;
        }
        TurnSignTermsActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
      }
      TurnSignTermsActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        ApplicationEx.setPackState(0, "MZCL_badge");
        ApplicationEx.setPackState(0, "MAC_badge");
        ApplicationEx.setPackState(0, "MZFC_badge");
        ApplicationEx.setPackState(0, "MZCLI_badge");
        ApplicationEx.f = false;
        ApplicationEx.g = 3;
        TurnSignTermsActivity.this.dismissProgress();
        TurnSignTermsActivity.f(TurnSignTermsActivity.this);
        return;
      }
      TurnSignTermsActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131690105));
    this.d = ((TextView)findViewById(2131689533));
    this.e = ((WebView)findViewById(2131693273));
    this.f = ((Button)findViewById(2131693395));
    this.d.setText("合同条款");
  }
  
  private void a(Handler paramHandler, String paramString)
  {
    d.getTurnRaSignInfo(this, paramHandler, paramString);
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    paramString = new SpannableStringBuilder(paramString);
    paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA000")), paramInt1, paramInt1 + paramInt2, 33);
    paramTextView.setText(paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      String[] arrayOfString;
      do
      {
        return;
        if (ApplicationEx.c.k == null) {
          ApplicationEx.c.k = ClientForAndroid.getInstance(this);
        }
        arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
      } while (arrayOfString.length <= 0);
      paramString1 = ApplicationEx.c.k.SignMessage(paramString1, arrayOfString[0], "SHA1", 1);
      if (TextUtils.isEmpty(paramString1))
      {
        d.errorLog(this, "签名失败", "失败原因是:" + ApplicationEx.c.k.GetLastErrInfo());
        this.r = null;
        return;
      }
      u.d("ikey", "签名成功签名后字符为:" + paramString1);
      if (this.r == null) {
        this.r = new ArrayList();
      }
      this.r.add(new q(paramString2, paramString1));
    } while (this.r.size() != this.a.size());
    d.TurnSignature(this, this.y, a.toJSONString(this.r));
  }
  
  private void b()
  {
    this.c.setOnClickListener(this.b);
    this.f.setOnClickListener(this.b);
    this.e.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        TurnSignTermsActivity.a(TurnSignTermsActivity.this, 1);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        TurnSignTermsActivity.a(TurnSignTermsActivity.this, 2);
      }
    });
  }
  
  private int d(String paramString)
  {
    return paramString.length() - 12;
  }
  
  private List<String> e()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Contract)localIterator.next()).getContract_code());
    }
    return localArrayList;
  }
  
  private List<Contract> f()
  {
    Object localObject = ApplicationEx.c.getContracts();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Contract localContract = (Contract)((Iterator)localObject).next();
        if ("0".equals(localContract.getIsZiroom())) {
          localArrayList.add(localContract);
        }
      }
    }
    return localArrayList;
  }
  
  private void g()
  {
    this.t = View.inflate(this, 2130905177, null);
    Object localObject;
    if (this.x == null)
    {
      this.x = new Dialog(this, 2131427781);
      this.x.setContentView(this.t);
      this.u = ((TextView)this.t.findViewById(2131697661));
      this.v = ((TextView)this.t.findViewById(2131697665));
      this.w = ((ListView)this.t.findViewById(2131697663));
      localObject = "以下" + this.s.size() + "套房源将进行合同变更";
      a(this.u, (String)localObject, 2, d((String)localObject));
      localObject = new p(this, this.s);
      this.w.setAdapter((ListAdapter)localObject);
      this.v.setOnClickListener(this.b);
      localObject = this.x;
      if ((localObject instanceof Dialog)) {
        break label210;
      }
      ((Dialog)localObject).show();
    }
    for (;;)
    {
      this.x.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          TurnSignTermsActivity.a(TurnSignTermsActivity.this, null);
          TurnSignTermsActivity.d(TurnSignTermsActivity.this).dismiss();
          TurnSignTermsActivity.a(TurnSignTermsActivity.this, null);
        }
      });
      return;
      label210:
      VdsAgent.showDialog((Dialog)localObject);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905175);
    a();
    b();
    if (!ah.checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    this.s = f();
    d.getTurnSignTerms(this.y, a.toJSONString(e()));
    showProgress("");
  }
  
  public e parseGetRaSignInfo(String paramString)
  {
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        showToast("网络数据请求失败!");
        u.e("parseGetRaSignInfo", paramString.getMessage());
        return null;
      }
    }
    paramString = (e)a.parseObject(paramString, e.class);
    return paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/TurnSignTermsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */