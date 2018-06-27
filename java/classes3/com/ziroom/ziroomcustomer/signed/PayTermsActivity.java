package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.TenancyInfo;
import com.ziroom.ziroomcustomer.model.TenancyUpdate;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayTermsActivity
  extends BaseActivity
{
  private int A;
  private com.ziroom.ziroomcustomer.signed.a.c B;
  private String C;
  private String D;
  private String E;
  private Handler F = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      PayTermsActivity.d(PayTermsActivity.this).setEnabled(true);
      PayTermsActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        PayTermsActivity.a(PayTermsActivity.this, (String)paramAnonymousMessage.getObject());
        if ("0".equals(PayTermsActivity.e(PayTermsActivity.this)))
        {
          PayTermsActivity.a(PayTermsActivity.this, PayTermsActivity.c(PayTermsActivity.this), PayTermsActivity.f(PayTermsActivity.this).getCertType(), PayTermsActivity.f(PayTermsActivity.this).getCertId(), PayTermsActivity.f(PayTermsActivity.this).getPhone(), PayTermsActivity.f(PayTermsActivity.this).getSex(), PayTermsActivity.f(PayTermsActivity.this).getName());
          return;
        }
        if (PayTermsActivity.g(PayTermsActivity.this) == 1)
        {
          paramAnonymousMessage = new Intent(PayTermsActivity.this.getApplicationContext(), BoundCardActivity.class);
          paramAnonymousMessage.putExtra("mBoundCardType", 2);
          paramAnonymousMessage.putExtra("detail", PayTermsActivity.b(PayTermsActivity.this));
          paramAnonymousMessage.putExtra("contract_code", PayTermsActivity.c(PayTermsActivity.this));
          PayTermsActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        paramAnonymousMessage = new Intent(PayTermsActivity.this.getApplicationContext(), ContractTermsActivity.class);
        paramAnonymousMessage.putExtra("detail", PayTermsActivity.b(PayTermsActivity.this));
        paramAnonymousMessage.putExtra("contract_code", PayTermsActivity.c(PayTermsActivity.this));
        PayTermsActivity.this.startActivity(paramAnonymousMessage);
        return;
      }
      PayTermsActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  private View G;
  private TextView H;
  private TextView I;
  private TextView J;
  private TextView K;
  private Dialog L;
  View.OnClickListener a = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131697235: 
        if (PayTermsActivity.a(PayTermsActivity.this) != null)
        {
          if (PayTermsActivity.this.getCheck() != 0)
          {
            int j;
            int i;
            if (100 == PayTermsActivity.this.getCheck())
            {
              PayTermsActivity.a(PayTermsActivity.this, 0);
              j = 1;
              i = 99;
            }
            for (;;)
            {
              PayTermsActivity.d(PayTermsActivity.this).setEnabled(false);
              e locale = PayTermsActivity.i(PayTermsActivity.this).getzWhiteModel();
              paramAnonymousView = "";
              String str = "";
              if (locale != null)
              {
                paramAnonymousView = locale.getString("loanType");
                str = locale.getString("loanCode");
              }
              com.ziroom.ziroomcustomer.e.d.setPayWay(PayTermsActivity.j(PayTermsActivity.this), PayTermsActivity.b(PayTermsActivity.this).getHouse_code(), PayTermsActivity.b(PayTermsActivity.this).getHouse_id(), PayTermsActivity.b(PayTermsActivity.this).getHouse_type(), i, j, PayTermsActivity.i(PayTermsActivity.this).getSignDate(), PayTermsActivity.i(PayTermsActivity.this).getStopDate(), PayTermsActivity.i(PayTermsActivity.this).getTenancyType(), PayTermsActivity.i(PayTermsActivity.this).getIsShort(), PayTermsActivity.i(PayTermsActivity.this).getPrice(), PayTermsActivity.i(PayTermsActivity.this).getPriceUnit(), PayTermsActivity.g(PayTermsActivity.this) + "", paramAnonymousView, str, PayTermsActivity.e(PayTermsActivity.this), PayTermsActivity.i(PayTermsActivity.this).getTenancyChoice());
              PayTermsActivity.this.showProgressNoCancel("", 30000L);
              return;
              if (101 == PayTermsActivity.this.getCheck())
              {
                PayTermsActivity.a(PayTermsActivity.this, 1);
                j = 0;
                i = 99;
              }
              else
              {
                PayTermsActivity.a(PayTermsActivity.this, 0);
                j = 0;
                i = PayTermsActivity.this.getCheck();
              }
            }
          }
          com.freelxl.baselibrary.f.g.textToast(PayTermsActivity.this.getApplicationContext(), "请选择付款方式", 0);
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(PayTermsActivity.k(PayTermsActivity.this), "服务器错误，未取到付款方式。。。", 0);
        return;
      case 2131690105: 
        PayTermsActivity.this.finish();
        return;
      }
      PayTermsActivity.l(PayTermsActivity.this).dismiss();
      paramAnonymousView = new Intent(PayTermsActivity.this, CreditWebActivity.class);
      paramAnonymousView.putExtra("title", "使用规则");
      paramAnonymousView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/qfgz/index.html");
      PayTermsActivity.this.startActivity(paramAnonymousView);
    }
  };
  private List<String> b;
  private Button c;
  private TextView d;
  private ImageView e;
  private ListView f;
  private j g;
  private Context r;
  private HouseDetail s;
  private TenancyUpdate t;
  private TextView u;
  private TextView v;
  private TenancyInfo w;
  private RelativeLayout x;
  private PayTermsScrollView y;
  private View z;
  
  private void a()
  {
    this.b = new ArrayList();
    int i = 0;
    while (i < 5)
    {
      this.b.add("0");
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.D = (q.s + e.n.aa);
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("certType", paramString2);
    localHashMap.put("certNum", paramString3);
    localHashMap.put("contactWay", paramString4);
    localHashMap.put("userSex", paramString5);
    localHashMap.put("name", paramString6);
    com.ziroom.ziroomcustomer.e.g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.f.d.e("url", this.D + localHashMap.toString());
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(this.D).params(localHashMap).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.r, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        PayTermsActivity.this.showToast("入住人提交失败，请重新再试");
        u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        com.freelxl.baselibrary.f.d.e("json", paramAnonymouse + "");
        if ("success".equals(paramAnonymouse.get("status")))
        {
          paramAnonymouse = new Intent(PayTermsActivity.this.getApplicationContext(), ContractTermsActivity.class);
          paramAnonymouse.putExtra("detail", PayTermsActivity.b(PayTermsActivity.this));
          paramAnonymouse.putExtra("contract_code", PayTermsActivity.c(PayTermsActivity.this));
          PayTermsActivity.this.startActivity(paramAnonymouse);
        }
        for (;;)
        {
          dismissProgress();
          return;
          PayTermsActivity.this.showToast(paramAnonymouse.get("error_message").toString());
        }
      }
    });
  }
  
  private void b()
  {
    a();
    this.y = ((PayTermsScrollView)findViewById(2131690114));
    this.z = findViewById(2131692036);
    this.x = ((RelativeLayout)findViewById(2131692414));
    this.u = ((TextView)findViewById(2131697200));
    this.v = ((TextView)findViewById(2131697201));
    this.u.setText(this.s.getHouse_name());
    String str;
    if (this.s.getIs_duanzu() == 1)
    {
      str = "￥" + this.s.getHouse_price() + "元/天";
      ah.setTextColor(this.v, str, 0, str.length());
    }
    for (;;)
    {
      this.z.setVisibility(8);
      this.e = ((ImageView)findViewById(2131690105));
      this.d = ((TextView)findViewById(2131689533));
      this.d.setText("");
      this.f = ((ListView)findViewById(2131691217));
      this.c = ((Button)findViewById(2131697235));
      return;
      if (this.s.getIs_duanzu() == 0)
      {
        str = "￥" + this.s.getHouse_price() + "元/月";
        ah.setTextColor(this.v, str, 0, str.length());
      }
    }
  }
  
  private void e()
  {
    this.c.setOnClickListener(this.a);
    this.e.setOnClickListener(this.a);
    this.y.setScrollViewListener(new PayTermsScrollView.a()
    {
      public void onScrollChanged(PayTermsScrollView paramAnonymousPayTermsScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (paramAnonymousInt2 == 0)
        {
          PayTermsActivity.h(PayTermsActivity.this).setVisibility(8);
          return;
        }
        PayTermsActivity.h(PayTermsActivity.this).setVisibility(0);
      }
    });
  }
  
  public List<Integer> ListTest()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.t.getPayments().size())
    {
      localArrayList.add(Integer.valueOf(0));
      i += 1;
    }
    return localArrayList;
  }
  
  public int getCheck()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.g.getCount())
      {
        if (((Integer)this.g.getmCheck().get(i)).intValue() == 1) {
          j = ((Integer)this.g.getmList().get(i)).intValue();
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905021);
    this.r = this;
    ApplicationEx.c.addActivity(this);
    this.s = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    this.t = ((TenancyUpdate)getIntent().getSerializableExtra("tenancy"));
    this.w = ((TenancyInfo)getIntent().getSerializableExtra("tenancyInfo"));
    this.B = ((com.ziroom.ziroomcustomer.signed.a.c)getIntent().getSerializableExtra("person"));
    if (this.B != null) {}
    for (this.C = "0";; this.C = "1")
    {
      b();
      e();
      if (ah.checkNet(getApplicationContext())) {
        break;
      }
      com.freelxl.baselibrary.f.g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    if (this.t.getIs_blank() == 1) {
      this.t.getPayments().add(0, Integer.valueOf(100));
    }
    if ("1".equals(this.t.getIsZWhite())) {
      this.t.getPayments().add(0, Integer.valueOf(101));
    }
    this.g = new j(this.r, ListTest(), this.t.getPayments(), this.w.getPaymentsTags());
    this.f.setAdapter(this.g);
    this.f.setDivider(null);
    new com.ziroom.ziroomcustomer.widget.c().setListViewHeightBasedOnChildren(this.f);
    this.g.setmOnCheck(new j.a()
    {
      public void onCheck(List<Integer> paramAnonymousList) {}
      
      public void onItemClick(int paramAnonymousInt)
      {
        List localList = PayTermsActivity.a(PayTermsActivity.this).getmCheck();
        int i = 0;
        if (i < localList.size())
        {
          if (paramAnonymousInt == i) {
            localList.set(i, Integer.valueOf(1));
          }
          for (;;)
          {
            i += 1;
            break;
            localList.set(i, Integer.valueOf(0));
          }
        }
        PayTermsActivity.a(PayTermsActivity.this).setmCheck(localList);
        PayTermsActivity.a(PayTermsActivity.this).notifyDataSetChanged();
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
  }
  
  public void showDialog(String paramString)
  {
    this.G = View.inflate(this.r, 2130905178, null);
    this.H = ((TextView)this.G.findViewById(2131697639));
    this.I = ((TextView)this.G.findViewById(2131697638));
    this.K = ((TextView)this.G.findViewById(2131697637));
    this.J = ((TextView)this.G.findViewById(2131697634));
    this.H.setOnClickListener(this.a);
    this.J.setText("提示");
    this.H.setText("查看使用规则");
    this.I.setVisibility(8);
    this.K.setText(paramString);
    if (this.L == null)
    {
      this.L = new Dialog(this.r, 2131427781);
      this.L.setContentView(this.G);
      this.L.setCanceledOnTouchOutside(false);
      this.L.setCancelable(false);
      paramString = this.L;
      if ((paramString instanceof Dialog)) {
        break label219;
      }
      paramString.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.L.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          PayTermsActivity.a(PayTermsActivity.this, null);
          PayTermsActivity.l(PayTermsActivity.this).dismiss();
          PayTermsActivity.a(PayTermsActivity.this, null);
        }
      });
      return;
      label219:
      VdsAgent.showDialog((Dialog)paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/PayTermsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */