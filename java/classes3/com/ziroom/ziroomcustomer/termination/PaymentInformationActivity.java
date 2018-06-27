package com.ziroom.ziroomcustomer.termination;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.EvaluateActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.signed.NewZZItemsActivity;
import com.ziroom.ziroomcustomer.signed.NewZZKeysActivity;
import com.ziroom.ziroomcustomer.signed.NewZZLivingsActivity;
import com.ziroom.ziroomcustomer.termination.a.h;
import com.ziroom.ziroomcustomer.termination.a.i;
import com.ziroom.ziroomcustomer.termination.a.n;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentInformationActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private AlertDialog A;
  private TextView B;
  private LinearLayout C;
  private ListView D;
  private ListView E;
  private ListView F;
  private b G;
  private a H;
  private c I;
  private List<h> J = new ArrayList();
  private List<com.ziroom.ziroomcustomer.termination.a.f> K = new ArrayList();
  private List<com.ziroom.ziroomcustomer.termination.a.j> L = new ArrayList();
  private com.ziroom.ziroomcustomer.termination.a.e M = new com.ziroom.ziroomcustomer.termination.a.e();
  private i N = new i();
  private com.ziroom.ziroomcustomer.termination.a.g O = new com.ziroom.ziroomcustomer.termination.a.g();
  private String P;
  private String Q;
  private String R;
  private String S;
  private String T;
  private String U;
  private Handler V = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return false;
      }
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue()) {
        PaymentInformationActivity.this.showToast("您已经评价过了!");
      }
      for (;;)
      {
        PaymentInformationActivity.this.dismissProgress();
        break;
        localObject = new Intent(PaymentInformationActivity.this, EvaluateActivity.class);
        ((Intent)localObject).putExtra("contract_code", paramAnonymousMessage.getCode());
        ((Intent)localObject).putExtra("questionType", PaymentInformationActivity.l(PaymentInformationActivity.this));
        ((Intent)localObject).putExtra("uid", PaymentInformationActivity.i(PaymentInformationActivity.this));
        ((Intent)localObject).putExtra("stewardType", PaymentInformationActivity.k(PaymentInformationActivity.this));
        ((Intent)localObject).putExtra("type", 2);
        PaymentInformationActivity.this.startActivity((Intent)localObject);
      }
    }
  });
  private String W = null;
  private String X = null;
  private String Y = null;
  private ImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private n y;
  private Context z;
  
  private void a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localView = LayoutInflater.from(paramContext).inflate(2130903793, null);
      this.D = ((ListView)localView.findViewById(2131693767));
      this.B = ((TextView)localView.findViewById(2131693729));
      this.C = ((LinearLayout)localView.findViewById(2131693728));
      if (this.M.getTotalAccount() <= 0.0F) {
        this.C.setVisibility(8);
      }
      for (;;)
      {
        this.D.setAdapter(this.G);
        a(paramContext, localView);
        return;
        this.C.setVisibility(0);
        this.B.setText(this.M.getTotalAccount() + "");
      }
    case 2: 
      localView = LayoutInflater.from(paramContext).inflate(2130903788, null);
      this.B = ((TextView)localView.findViewById(2131693729));
      this.C = ((LinearLayout)localView.findViewById(2131693728));
      this.E = ((ListView)localView.findViewById(2131693730));
      this.E.setAdapter(this.H);
      if (this.O.getTotalAccount() <= 0.0F) {
        this.C.setVisibility(8);
      }
      for (;;)
      {
        a(paramContext, localView);
        return;
        this.C.setVisibility(0);
        this.B.setText(this.O.getTotalAccount() + "");
      }
    }
    View localView = LayoutInflater.from(paramContext).inflate(2130903810, null);
    this.B = ((TextView)localView.findViewById(2131693729));
    this.C = ((LinearLayout)localView.findViewById(2131693728));
    this.F = ((ListView)localView.findViewById(2131693813));
    this.F.setAdapter(this.I);
    if (this.N.getTotalAccount() <= 0.0F) {
      this.C.setVisibility(8);
    }
    for (;;)
    {
      a(paramContext, localView);
      return;
      this.C.setVisibility(0);
      this.B.setText(this.N.getTotalAccount() + "");
    }
  }
  
  private void a(Context paramContext, View paramView)
  {
    this.A = new AlertDialog.Builder(paramContext).create();
    this.A.setView(paramView, 0, 0, 0, 0);
    paramContext = this.A;
    if (!(paramContext instanceof AlertDialog))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)paramContext);
  }
  
  private void d(final String paramString)
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString + "");
    com.ziroom.ziroomcustomer.e.g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.s + e.a.u).tag(this).params(localHashMap).enqueue(new com.ziroom.ziroomcustomer.e.a.f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        PaymentInformationActivity.a(PaymentInformationActivity.this, "fwgj");
        PaymentInformationActivity.b(PaymentInformationActivity.this, "JYPJ");
        PaymentInformationActivity.c(PaymentInformationActivity.this, paramAnonymouse.getString("gjAccount"));
        if (TextUtils.isEmpty(PaymentInformationActivity.i(PaymentInformationActivity.this)))
        {
          PaymentInformationActivity.this.showToast("未找到当前管家信息,无法评价!");
          return;
        }
        d.checkHasEvaluate(PaymentInformationActivity.j(PaymentInformationActivity.this), PaymentInformationActivity.this, ApplicationEx.c.getUserId(PaymentInformationActivity.this), "ziroomer", PaymentInformationActivity.i(PaymentInformationActivity.this), PaymentInformationActivity.k(PaymentInformationActivity.this), PaymentInformationActivity.l(PaymentInformationActivity.this), paramString);
      }
    });
  }
  
  public void initView()
  {
    this.x = ((TextView)findViewById(2131697251));
    this.w = ((TextView)findViewById(2131693349));
    this.v = ((TextView)findViewById(2131693348));
    this.u = ((TextView)findViewById(2131693347));
    this.t = ((TextView)findViewById(2131693346));
    this.s = ((TextView)findViewById(2131693345));
    this.r = ((TextView)findViewById(2131693344));
    this.g = ((TextView)findViewById(2131693343));
    this.f = ((TextView)findViewById(2131697252));
    this.e = ((TextView)findViewById(2131697250));
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((TextView)findViewById(2131697247));
    this.c = ((TextView)findViewById(2131697248));
    this.d = ((TextView)findViewById(2131697249));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (("5".equals(this.y.getHouseType())) || ("8".equals(this.y.getHouseType())))
      {
        paramView = new Intent(this.z, NewZZItemsActivity.class);
        paramView.putExtra("isTermination", "isTermination");
        paramView.putExtra("backRentOrderCode", this.y.getBackRentOrderCode());
        paramView.putExtra("contractCode", this.P);
        paramView.putExtra("isSuccess", "isSuccess");
        startActivity(paramView);
        return;
      }
      this.R = (q.s + e.a.f);
      paramView = com.ziroom.ziroomcustomer.e.g.getViewPropertyGoosUrl(this.P, this.Q);
      com.ziroom.ziroomcustomer.e.j.getReservationOrderText(this.z, new d(), paramView, true, this.R);
      return;
      if (("5".equals(this.y.getHouseType())) || ("8".equals(this.y.getHouseType())))
      {
        paramView = new Intent(this.z, NewZZLivingsActivity.class);
        paramView.putExtra("isTermination", "isTermination");
        paramView.putExtra("backRentOrderCode", this.y.getBackRentOrderCode());
        paramView.putExtra("contractCode", this.P);
        paramView.putExtra("isSuccess", "isSuccess");
        startActivity(paramView);
        return;
      }
      this.S = (q.s + e.a.h);
      paramView = com.ziroom.ziroomcustomer.e.g.getViewPropertyExpendsUrl(this.Q);
      com.ziroom.ziroomcustomer.e.j.getReservationOrderText(this.z, new d(), paramView, true, this.S);
      return;
      if (("5".equals(this.y.getHouseType())) || ("8".equals(this.y.getHouseType())))
      {
        paramView = new Intent(this.z, NewZZKeysActivity.class);
        paramView.putExtra("isTermination", "isTermination");
        paramView.putExtra("backRentOrderCode", this.y.getBackRentOrderCode());
        paramView.putExtra("contractCode", this.P);
        paramView.putExtra("isSuccess", "isSuccess");
        startActivity(paramView);
        return;
      }
      this.T = (q.s + e.a.g);
      paramView = com.ziroom.ziroomcustomer.e.g.getViewPropertyKeyUrl(this.Q);
      com.ziroom.ziroomcustomer.e.j.getReservationOrderText(this.z, new d(), paramView, true, this.T);
      return;
      finish();
      return;
      paramView = new Intent(this.z, CostSettlementActivity.class);
      paramView.putExtra("ToPay", "ToPay");
      paramView.putExtra("backRentOrderCode", this.Q);
      paramView.putExtra("contractCode", this.P);
      startActivity(paramView);
      return;
      if ("支付".equals(this.f.getText().toString()))
      {
        paramView = new Intent(this.z, TerminationPayActivity.class);
        paramView.putExtra("backRentOrderCode", this.Q);
        paramView.putExtra("contractCode", this.P);
        startActivity(paramView);
        return;
      }
    } while (!"去评价管家".equals(this.f.getText().toString()));
    d(this.P);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905026);
    this.z = this;
    this.Q = getIntent().getStringExtra("backRentOrderCode");
    this.P = getIntent().getStringExtra("contractCode");
    this.U = (q.s + e.a.e);
    paramBundle = com.ziroom.ziroomcustomer.e.g.getViewPropertyGoosUrl(this.P, this.Q);
    com.ziroom.ziroomcustomer.e.j.getReservationOrderText(this.z, new d(), paramBundle, true, this.U);
    initView();
    setOnclick();
  }
  
  public void setData()
  {
    if (this.y == null) {
      return;
    }
    this.w.setText(m.StrToNorDate(this.y.getRentBackDate()));
    this.v.setText(m.StrToNorDate(this.y.getApplyDate()));
    this.u.setText(m.StrToNorDate(this.y.getAddress()));
    this.t.setText(this.y.getCertNumber());
    this.s.setText(this.y.getCertType());
    this.r.setText(this.y.getUserPhone());
    this.g.setText(this.y.getCustomerName());
    if (("wfk".equals(this.y.getPayState())) || ("qk".equals(this.y.getPayState())))
    {
      this.f.setText("支付");
      this.x.setVisibility(8);
    }
    for (;;)
    {
      this.Q = this.y.getBackRentOrderCode();
      return;
      this.f.setText("去评价管家");
      this.x.setVisibility(0);
    }
  }
  
  public void setOnclick()
  {
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  public class a
    extends BaseAdapter
  {
    private a b;
    
    public a() {}
    
    public int getCount()
    {
      return PaymentInformationActivity.n(PaymentInformationActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramView = View.inflate(PaymentInformationActivity.c(PaymentInformationActivity.this), 2130904195, null);
        this.b.a = ((TextView)paramView.findViewById(2131694982));
        this.b.b = ((TextView)paramView.findViewById(2131694985));
        this.b.c = ((TextView)paramView.findViewById(2131694983));
        this.b.d = ((TextView)paramView.findViewById(2131694984));
        this.b.e = ((TextView)paramView.findViewById(2131694986));
        paramView.setTag(this.b);
        this.b.a.setText(((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getName());
        if (TextUtils.isEmpty(((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getBalance())) {
          break label394;
        }
        this.b.b.setText("卡显示余额" + ((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getBalance());
        label219:
        if (!ae.notNull(((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getPriceUnit())) {
          break label409;
        }
        this.b.c.setText(((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getPrice() + ((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getPriceUnit());
        label308:
        this.b.e.setText(((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getDisplayNums());
        paramViewGroup = ((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getIsAdvancePay();
        if (!"1".equals(paramViewGroup)) {
          break label459;
        }
        this.b.d.setText(2131296815);
      }
      label394:
      label409:
      label459:
      while (!"2".equals(paramViewGroup))
      {
        return paramView;
        this.b = ((a)paramView.getTag());
        break;
        this.b.b.setText("");
        break label219;
        this.b.c.setText(((h)PaymentInformationActivity.n(PaymentInformationActivity.this).get(paramInt)).getPrice() + "");
        break label308;
      }
      this.b.d.setText(2131296814);
      return paramView;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      
      a() {}
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private a b;
    
    public b() {}
    
    public int getCount()
    {
      return PaymentInformationActivity.m(PaymentInformationActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return PaymentInformationActivity.m(PaymentInformationActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramView = View.inflate(PaymentInformationActivity.c(PaymentInformationActivity.this), 2130904212, null);
        this.b.a = ((TextView)paramView.findViewById(2131695040));
        this.b.b = ((TextView)paramView.findViewById(2131695041));
        this.b.c = ((TextView)paramView.findViewById(2131695043));
        this.b.d = ((TextView)paramView.findViewById(2131695044));
        this.b.e = ((TextView)paramView.findViewById(2131695045));
        paramView.setTag(this.b);
        this.b.a.setText(((com.ziroom.ziroomcustomer.termination.a.f)PaymentInformationActivity.m(PaymentInformationActivity.this).get(paramInt)).getName());
        this.b.b.setText(((com.ziroom.ziroomcustomer.termination.a.f)PaymentInformationActivity.m(PaymentInformationActivity.this).get(paramInt)).getCount());
        this.b.c.setText(((com.ziroom.ziroomcustomer.termination.a.f)PaymentInformationActivity.m(PaymentInformationActivity.this).get(paramInt)).getBrand());
        this.b.d.setText(((com.ziroom.ziroomcustomer.termination.a.f)PaymentInformationActivity.m(PaymentInformationActivity.this).get(paramInt)).getType());
        paramInt = Integer.parseInt(((com.ziroom.ziroomcustomer.termination.a.f)PaymentInformationActivity.m(PaymentInformationActivity.this).get(paramInt)).getState());
        if (paramInt != 1) {
          break label290;
        }
        this.b.e.setText(2131297291);
      }
      label290:
      do
      {
        return paramView;
        this.b = ((a)paramView.getTag());
        break;
        if (paramInt == 2)
        {
          this.b.e.setText(2131297024);
          return paramView;
        }
        if (paramInt == 3)
        {
          this.b.e.setText(2131296606);
          return paramView;
        }
      } while (paramInt != 4);
      this.b.e.setText(2131296605);
      return paramView;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      
      a() {}
    }
  }
  
  public class c
    extends BaseAdapter
  {
    private a b;
    
    public c() {}
    
    public int getCount()
    {
      return PaymentInformationActivity.o(PaymentInformationActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return PaymentInformationActivity.o(PaymentInformationActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramViewGroup = View.inflate(PaymentInformationActivity.c(PaymentInformationActivity.this), 2130904264, null);
        this.b.a = ((TextView)paramViewGroup.findViewById(2131695122));
        this.b.b = ((TextView)paramViewGroup.findViewById(2131695123));
        this.b.c = ((TextView)paramViewGroup.findViewById(2131695124));
        paramViewGroup.setTag(this.b);
        this.b.a.setText(((com.ziroom.ziroomcustomer.termination.a.j)PaymentInformationActivity.o(PaymentInformationActivity.this).get(paramInt)).getName());
        this.b.b.setText(((com.ziroom.ziroomcustomer.termination.a.j)PaymentInformationActivity.o(PaymentInformationActivity.this).get(paramInt)).getCount());
        paramView = ((com.ziroom.ziroomcustomer.termination.a.j)PaymentInformationActivity.o(PaymentInformationActivity.this).get(paramInt)).getState();
        if (!"1".equals(paramView)) {
          break label262;
        }
        paramView = "正常 ";
      }
      for (;;)
      {
        String str = ((com.ziroom.ziroomcustomer.termination.a.j)PaymentInformationActivity.o(PaymentInformationActivity.this).get(paramInt)).getIsDeliver();
        if ((TextUtils.isEmpty(str)) || (!"1".equals(str))) {
          break label313;
        }
        this.b.c.setText(paramView + "已交付");
        return paramViewGroup;
        this.b = ((a)paramView.getTag());
        paramViewGroup = paramView;
        break;
        label262:
        if ("2".equals(paramView)) {
          paramView = "丢失 ";
        } else if ("3".equals(paramView)) {
          paramView = "损坏可维修 ";
        } else if ("4".equals(paramView)) {
          paramView = "损坏不可维修 ";
        } else {
          paramView = "";
        }
      }
      label313:
      this.b.c.setText(paramView + "未交付");
      return paramViewGroup;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      
      a() {}
    }
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (paramk.getUrl().equals(PaymentInformationActivity.a(PaymentInformationActivity.this)))
        {
          paramString = (com.ziroom.ziroomcustomer.termination.a.e)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.e.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        do
        {
          return;
          if (paramk.getUrl().equals(PaymentInformationActivity.d(PaymentInformationActivity.this)))
          {
            paramString = (i)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), i.class);
            paramk.setSuccess(Boolean.valueOf(true));
            paramk.setObject(paramString);
            return;
          }
          if (paramk.getUrl().equals(PaymentInformationActivity.f(PaymentInformationActivity.this)))
          {
            paramString = (com.ziroom.ziroomcustomer.termination.a.g)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.g.class);
            paramk.setSuccess(Boolean.valueOf(true));
            paramk.setObject(paramString);
            return;
          }
        } while (!paramk.getUrl().equals(PaymentInformationActivity.h(PaymentInformationActivity.this)));
        paramString = (n)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), n.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        if (paramk.getUrl().equals(PaymentInformationActivity.a(PaymentInformationActivity.this)))
        {
          PaymentInformationActivity.a(PaymentInformationActivity.this, (com.ziroom.ziroomcustomer.termination.a.e)paramk.getObject());
          PaymentInformationActivity.a(PaymentInformationActivity.this, PaymentInformationActivity.b(PaymentInformationActivity.this).getGoodsList());
          PaymentInformationActivity.a(PaymentInformationActivity.this, new PaymentInformationActivity.b(PaymentInformationActivity.this));
          PaymentInformationActivity.a(PaymentInformationActivity.this, PaymentInformationActivity.c(PaymentInformationActivity.this), 1);
        }
      }
      for (;;)
      {
        PaymentInformationActivity.this.dismissProgress();
        return;
        if (paramk.getUrl().equals(PaymentInformationActivity.d(PaymentInformationActivity.this)))
        {
          PaymentInformationActivity.a(PaymentInformationActivity.this, (i)paramk.getObject());
          PaymentInformationActivity.b(PaymentInformationActivity.this, PaymentInformationActivity.e(PaymentInformationActivity.this).getKeyCardsList());
          PaymentInformationActivity.a(PaymentInformationActivity.this, new PaymentInformationActivity.c(PaymentInformationActivity.this));
          PaymentInformationActivity.a(PaymentInformationActivity.this, PaymentInformationActivity.c(PaymentInformationActivity.this), 3);
        }
        else if (paramk.getUrl().equals(PaymentInformationActivity.f(PaymentInformationActivity.this)))
        {
          PaymentInformationActivity.a(PaymentInformationActivity.this, (com.ziroom.ziroomcustomer.termination.a.g)paramk.getObject());
          PaymentInformationActivity.c(PaymentInformationActivity.this, PaymentInformationActivity.g(PaymentInformationActivity.this).getExpendsList());
          PaymentInformationActivity.a(PaymentInformationActivity.this, new PaymentInformationActivity.a(PaymentInformationActivity.this));
          PaymentInformationActivity.a(PaymentInformationActivity.this, PaymentInformationActivity.c(PaymentInformationActivity.this), 2);
        }
        else if (paramk.getUrl().equals(PaymentInformationActivity.h(PaymentInformationActivity.this)))
        {
          PaymentInformationActivity.a(PaymentInformationActivity.this, (n)paramk.getObject());
          PaymentInformationActivity.this.setData();
          continue;
          paramk = paramk.getMessage();
          PaymentInformationActivity.this.showToast(paramk);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/PaymentInformationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */