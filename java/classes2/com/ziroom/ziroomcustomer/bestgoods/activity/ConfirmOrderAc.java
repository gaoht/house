package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.b.r;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.SKUMo;
import com.ziroom.ziroomcustomer.bestgoods.model.m;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.newServiceList.activity.ModifyNewAddressActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairAddressActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.AddressMo;
import com.ziroom.ziroomcustomer.newServiceList.model.ap;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.newrepair.utils.b;
import com.ziroom.ziroomcustomer.newrepair.widget.ZiScroListView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConfirmOrderAc
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private EditText B;
  private TextView C;
  private TextView D;
  private TextView E;
  private TextView F;
  private TextView G;
  private TextView H;
  private TextView I;
  private TextView J;
  private TextView K;
  private com.ziroom.ziroomcustomer.bestgoods.a.c L;
  private ArrayList<SKUMo> M;
  private ArrayList<AddressMo> N;
  private AddressMo O;
  private String P;
  private boolean Q = false;
  private int R = 0;
  private int S = 0;
  private double T = 0.0D;
  private String U;
  private String V;
  private int W = 100;
  private d X;
  private int Y = -1;
  private String Z = "";
  private Context a;
  private String aa = "";
  private double ab;
  private double ac;
  private boolean ad = false;
  private Intent ae;
  private d af = null;
  private BroadcastReceiver ag = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.ziroom.ziroomcustomer.activity_1"))
      {
        ConfirmOrderAc.this.toPayListAc(-1);
        return;
      }
      ConfirmOrderAc.this.toPayListAc(0);
    }
  };
  private double ah = 0.0D;
  private int b = 333;
  private int c = 666;
  private int d = 999;
  private RelativeLayout e;
  private ImageView f;
  private TextView g;
  private ZiScroListView r;
  private LabeledEditText s;
  private LabeledEditText t;
  private LabeledEditText u;
  private RelativeLayout v;
  private TextView w;
  private RelativeLayout x;
  private TextView y;
  private RelativeLayout z;
  
  private long a(CharSequence paramCharSequence)
  {
    double d1 = 0.0D;
    int i = 0;
    while (i < paramCharSequence.length())
    {
      d1 += 1.0D;
      i += 1;
    }
    return Math.round(d1);
  }
  
  private void a()
  {
    this.af = new d();
    this.af.initWXAPI(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_1");
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_2");
    registerReceiver(this.ag, localIntentFilter);
  }
  
  private void a(com.ziroom.ziroomcustomer.bestgoods.model.l paraml)
  {
    Object localObject = paraml.getList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      this.ah += localm.getOrderPrice();
    }
    showProgressNoCancel("", 30000L);
    localObject = new HashMap();
    ((Map)localObject).put("money", this.ah + "");
    ((Map)localObject).put("payKind", "1");
    ((Map)localObject).put("couponCode", paraml.getPromotionCode());
    ((Map)localObject).put("strGoodsOrderPrices", com.alibaba.fastjson.a.toJSONString(paraml.getList()));
    j.PayGoodsOrder(this, (Map)localObject, new c(new b(ap.class)));
  }
  
  private void a(final ap paramap)
  {
    double d1 = 0.0D;
    final Dialog localDialog = new Dialog(this, 2131427692);
    View localView = getLayoutInflater().inflate(2130903806, null);
    Object localObject = (TextView)localView.findViewById(2131691288);
    TextView localTextView1 = (TextView)localView.findViewById(2131689846);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131693701);
    TextView localTextView2 = (TextView)localView.findViewById(2131693699);
    if (this.ah >= 0.0D) {
      d1 = this.ah;
    }
    localTextView1.setText(String.format("%.2f", new Object[] { Double.valueOf(d1) }));
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
        ConfirmOrderAc.this.toPayListAc(0);
      }
    });
    localRelativeLayout.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ConfirmOrderAc.a(ConfirmOrderAc.this, paramap);
        localDialog.dismiss();
      }
    });
    localDialog.setCancelable(false);
    paramap = localDialog.getWindow();
    paramap.getDecorView().setPadding(0, 0, 0, 0);
    localObject = paramap.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    paramap.setAttributes((WindowManager.LayoutParams)localObject);
    paramap.setGravity(80);
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  private void b()
  {
    this.f = ((ImageView)findViewById(2131689492));
    this.e = ((RelativeLayout)findViewById(2131689808));
    this.g = ((TextView)findViewById(2131689541));
    this.r = ((ZiScroListView)findViewById(2131689980));
    this.s = ((LabeledEditText)findViewById(2131689981));
    this.t = ((LabeledEditText)findViewById(2131689982));
    this.u = ((LabeledEditText)findViewById(2131689983));
    this.v = ((RelativeLayout)findViewById(2131689984));
    this.w = ((TextView)findViewById(2131689985));
    this.x = ((RelativeLayout)findViewById(2131689986));
    this.y = ((TextView)findViewById(2131689987));
    this.z = ((RelativeLayout)findViewById(2131689988));
    this.A = ((TextView)findViewById(2131689850));
    this.B = ((EditText)findViewById(2131689989));
    this.X = new d(this.B, this);
    this.C = ((TextView)findViewById(2131689990));
    this.D = ((TextView)findViewById(2131689991));
    this.E = ((TextView)findViewById(2131689992));
    this.F = ((TextView)findViewById(2131689993));
    this.G = ((TextView)findViewById(2131689761));
    this.H = ((TextView)findViewById(2131689994));
    this.I = ((TextView)findViewById(2131689995));
    this.J = ((TextView)findViewById(2131689996));
    this.K = ((TextView)findViewById(2131689997));
  }
  
  private void b(ap paramap)
  {
    if (TextUtils.isEmpty(paramap.getPartnerid())) {}
    for (int i = this.af.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), "1248814701");; i = this.af.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), paramap.getPartnerid()))
    {
      if (i != 0) {
        toPayListAc(0);
      }
      return;
    }
  }
  
  private void e()
  {
    this.B.addTextChangedListener(this.X);
    this.f.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.v.setOnClickListener(this);
  }
  
  private void f()
  {
    Intent localIntent = getIntent();
    this.ab = localIntent.getDoubleExtra("totalPrice", 0.0D);
    this.ac = localIntent.getDoubleExtra("freightCost", 0.0D);
    this.M = localIntent.getParcelableArrayListExtra("selectedGoods");
    this.D.setText("¥" + String.format("%.2f", new Object[] { Double.valueOf(this.ab) }));
    this.F.setText("+¥" + String.format("%.2f", new Object[] { Double.valueOf(0.0D) }));
    this.J.setText("" + String.format("%.2f", new Object[] { Double.valueOf(this.ab) }));
    this.L = new com.ziroom.ziroomcustomer.bestgoods.a.c(this.a, this.M);
    this.r.setAdapter(this.L);
  }
  
  private void g()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    j.getBestGoodsAddressList(this.a, localHashMap, new a(new com.ziroom.ziroomcustomer.newrepair.utils.a(AddressMo.class, false)));
  }
  
  private void h()
  {
    if (this.R == 1)
    {
      this.ae = new Intent(this.a, ModifyNewAddressActivity.class);
      startActivityForResult(this.ae, this.c);
      return;
    }
    if (this.R == 2)
    {
      this.ae = new Intent(this.a, RepairAddressActivity.class);
      this.ae.putParcelableArrayListExtra("addressList", this.N);
      startActivityForResult(this.ae, this.d);
      return;
    }
    g();
  }
  
  private void i() {}
  
  private void j()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("请阅读商品的配送安装区域，确保下单地址在我们的服务范围内").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          ConfirmOrderAc.h(ConfirmOrderAc.this);
        }
      }
    }).build().show();
  }
  
  private boolean k()
  {
    if (TextUtils.isEmpty(this.P))
    {
      showToast("请选择物业地址");
      return false;
    }
    if (TextUtils.isEmpty(this.t.getText()))
    {
      showToast("请输入您的姓名");
      return false;
    }
    String str = this.u.getText();
    if ((TextUtils.isEmpty(str)) || (!ah.isMobile(str)))
    {
      showToast("请输入正确的联系电话");
      return false;
    }
    return true;
  }
  
  private void l()
  {
    if (checkNet(this.a))
    {
      showProgressNoCancel("", 30000L);
      a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("addressId", this.P);
      localHashMap.put("postCode", "");
      localHashMap.put("connectionPhone", this.u.getText());
      localHashMap.put("connectionName", this.t.getText());
      localHashMap.put("userMessage", VdsAgent.trackEditTextSilent(this.B).toString());
      localHashMap.put("specialNeeds", "");
      localHashMap.put("promotionId", this.V);
      localHashMap.put("promotionCode", this.U);
      localHashMap.put("promotionPrice", this.T + "");
      localHashMap.put("totalPrice", this.ab + "");
      localHashMap.put("dispatTypeCode", "第三方配送");
      if (this.Y == -1) {}
      for (String str = "0";; str = "1")
      {
        localHashMap.put("invoiceFlag", str);
        localHashMap.put("invoiceType", "0");
        localHashMap.put("payerType", this.Y + "");
        localHashMap.put("companyName", this.Z);
        localHashMap.put("identityNo", this.aa);
        localHashMap.put("drawerPhone", this.u.getText());
        localHashMap.put("drawerEmail", "");
        localHashMap.put("invoiceContent", "明细");
        localHashMap.put("goodsInfo", com.alibaba.fastjson.a.toJSONString(this.M));
        j.confirmGoodsOrder(this, localHashMap, new b(new b(com.ziroom.ziroomcustomer.bestgoods.model.l.class)));
        return;
      }
    }
    showToast("请保证网络畅通");
  }
  
  private void m()
  {
    if (!this.ad)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    this.ae = new Intent(this.a, YouPinCouponsActivity.class);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.M.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SKUMo)((Iterator)localObject1).next();
      if (!localArrayList.contains(((SKUMo)localObject2).getProductCode())) {
        localArrayList.add(((SKUMo)localObject2).getProductCode());
      }
    }
    Object localObject2 = "";
    int i = 0;
    if (i < localArrayList.size())
    {
      if (i < localArrayList.size() - 1) {
        localObject1 = (String)localObject2 + (String)localArrayList.get(i) + ",";
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        localObject1 = localObject2;
        if (i == localArrayList.size() - 1) {
          localObject1 = (String)localObject2 + (String)localArrayList.get(i);
        }
      }
    }
    this.ae.putExtra("serviceInfoId", (String)localObject2);
    this.ae.putExtra("totalPrice", this.ab);
    startActivityForResult(this.ae, this.b);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    StringBuilder localStringBuilder;
    Object localObject1;
    label219:
    double d1;
    if ((paramInt1 == this.d) && (paramIntent.getParcelableExtra("address") != null))
    {
      this.O = ((AddressMo)paramIntent.getParcelableExtra("address"));
      this.P = this.O.getFid();
      localObject2 = this.s;
      localStringBuilder = new StringBuilder().append(this.O.getVillage());
      if (ae.notNull(this.O.getDetAddress()))
      {
        localObject1 = this.O.getDetAddress();
        ((LabeledEditText)localObject2).setText((String)localObject1);
        this.s.getTextView().setEllipsize(TextUtils.TruncateAt.END);
        i();
      }
    }
    else
    {
      if ((paramInt1 == this.c) && (paramInt2 == -1))
      {
        this.O = ((AddressMo)paramIntent.getParcelableExtra("savaAddress"));
        this.R = 2;
        this.P = this.O.getFid();
        localObject2 = this.s;
        localStringBuilder = new StringBuilder().append(this.O.getVillage());
        if (!ae.notNull(this.O.getDetAddress())) {
          break label583;
        }
        localObject1 = this.O.getDetAddress();
        ((LabeledEditText)localObject2).setText((String)localObject1);
        this.s.getTextView().setEllipsize(TextUtils.TruncateAt.END);
        i();
      }
      if ((paramInt1 == this.b) && (paramInt2 == -1))
      {
        if (!paramIntent.getBooleanExtra("useCoupon", false)) {
          break label596;
        }
        localObject1 = (al)paramIntent.getSerializableExtra("couponItem");
        this.V = ((al)localObject1).getPromoId();
        this.U = ((al)localObject1).getPromoCode();
        this.T = ((al)localObject1).getPromoPrice();
        this.w.setText("－¥" + String.format("%.2f", new Object[] { Double.valueOf(this.T) }));
        this.w.setTextColor(this.a.getResources().getColor(2131624039));
        this.H.setText("－¥" + String.format("%.2f", new Object[] { Double.valueOf(this.T) }));
        d1 = this.ab - this.T;
        localObject1 = this.J;
        localObject2 = new StringBuilder().append("");
        if (d1 < 0.0D) {
          break label590;
        }
        label465:
        ((TextView)localObject1).setText(String.format("%.2f", new Object[] { Double.valueOf(d1) }));
      }
      if ((paramInt1 == 111) && (paramInt2 == -1))
      {
        if (!paramIntent.getBooleanExtra("needInvoice", false)) {
          break label865;
        }
        if (paramIntent.getIntExtra("payerType", -1) != 0) {
          break label767;
        }
        this.Y = 0;
        this.Z = paramIntent.getStringExtra("companyName");
        this.y.setText("个人");
        this.y.setTextColor(this.a.getResources().getColor(2131624039));
      }
    }
    label583:
    label590:
    label596:
    label767:
    while (paramIntent.getIntExtra("payerType", -1) != 1)
    {
      return;
      localObject1 = "";
      break;
      localObject1 = "";
      break label219;
      d1 = 0.0D;
      break label465;
      this.V = "";
      this.U = "";
      this.T = 0.0D;
      this.w.setText("请选择优惠券");
      this.w.setTextColor(this.a.getResources().getColor(2131624042));
      this.H.setText("¥" + String.format("%.2f", new Object[] { Double.valueOf(this.T) }));
      d1 = this.ab - this.T;
      localObject1 = this.J;
      localObject2 = new StringBuilder().append("");
      if (d1 >= 0.0D) {}
      for (;;)
      {
        ((TextView)localObject1).setText(String.format("%.2f", new Object[] { Double.valueOf(d1) }));
        break;
        d1 = 0.0D;
      }
    }
    this.Y = 1;
    this.Z = paramIntent.getStringExtra("companyName");
    this.y.setTextColor(this.a.getResources().getColor(2131624039));
    this.y.setText("单位");
    this.aa = paramIntent.getStringExtra("companyNum");
    aa.putString(this.a, "companyNum", this.aa);
    aa.putString(this.a, "companyName", this.Z);
    return;
    label865:
    this.Y = -1;
    this.Z = "";
    this.y.setText("不开具发票");
    this.y.setTextColor(this.a.getResources().getColor(2131624042));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.ad = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    default: 
    case 2131689492: 
    case 2131689986: 
    case 2131689984: 
    case 2131689997: 
      do
      {
        return;
        startActivity(new Intent(this.a, ShoppingCartAc.class));
        finish();
        return;
        this.ae = new Intent(this.a, InvoiceAc.class);
        this.ae.putExtra("companyName", this.Z);
        this.ae.putExtra("companyNum", this.aa);
        this.ae.putExtra("payerType", this.Y);
        startActivityForResult(this.ae, 111);
        return;
        m();
        return;
      } while (!k());
      j();
      return;
    }
    this.Q = true;
    if (!this.ad)
    {
      this.ae = new Intent(this.a, ServiceLoginActivity.class);
      startActivity(this.ae);
      return;
    }
    if (this.R < 0)
    {
      if (!checkNet(this.a))
      {
        showToast("请检查网络后重试");
        return;
      }
      showProgress("");
      g();
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(35);
    setContentView(2130903106);
    this.a = this;
    b();
    e();
    f();
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.ag != null) {
        unregisterReceiver(this.ag);
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void toPayListAc(final int paramInt)
  {
    new Thread()
    {
      public void run()
      {
        super.run();
        try
        {
          Thread.sleep(3000L);
          ConfirmOrderAc.a(ConfirmOrderAc.this, new Intent(ConfirmOrderAc.i(ConfirmOrderAc.this), ZiroomOrderListActivity.class));
          ConfirmOrderAc.k(ConfirmOrderAc.this).putExtra("orderState", paramInt);
          ConfirmOrderAc.this.startActivity(ConfirmOrderAc.k(ConfirmOrderAc.this));
          ConfirmOrderAc.this.finish();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }.start();
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      ConfirmOrderAc.this.dismissProgress();
      ConfirmOrderAc.this.showToast("请稍后再试");
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        ConfirmOrderAc.a(ConfirmOrderAc.this, (ArrayList)paraml.getObject());
        if ((ConfirmOrderAc.d(ConfirmOrderAc.this) != null) && (ConfirmOrderAc.d(ConfirmOrderAc.this).size() > 0)) {
          ConfirmOrderAc.a(ConfirmOrderAc.this, 2);
        }
        for (;;)
        {
          if (ConfirmOrderAc.e(ConfirmOrderAc.this)) {
            ConfirmOrderAc.f(ConfirmOrderAc.this);
          }
          ConfirmOrderAc.a(ConfirmOrderAc.this, false);
          ConfirmOrderAc.this.dismissProgress();
          return;
          ConfirmOrderAc.a(ConfirmOrderAc.this, 1);
        }
      }
      paraml = paraml.getMessage();
      if (paraml != null) {
        ConfirmOrderAc.this.showToast(paraml);
      }
      for (;;)
      {
        ConfirmOrderAc.g(ConfirmOrderAc.this);
        break;
        ConfirmOrderAc.this.showToast("请稍后再试");
      }
    }
  }
  
  class b
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public b(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      ConfirmOrderAc.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        r.deleteSkus(ConfirmOrderAc.i(ConfirmOrderAc.this), ConfirmOrderAc.j(ConfirmOrderAc.this));
        ConfirmOrderAc.this.setResult(-1, ConfirmOrderAc.k(ConfirmOrderAc.this));
        final String str = paraml.getMessage();
        if (!TextUtils.isEmpty(str))
        {
          af.showToast(ConfirmOrderAc.i(ConfirmOrderAc.this), str, 1);
          new Thread()
          {
            public void run()
            {
              SystemClock.sleep(2000L);
              ConfirmOrderAc.this.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  af.showToast(ConfirmOrderAc.i(ConfirmOrderAc.this), ConfirmOrderAc.b.1.this.a, 1);
                }
              });
            }
          }.start();
        }
        paraml = (com.ziroom.ziroomcustomer.bestgoods.model.l)paraml.getObject();
        ConfirmOrderAc.a(ConfirmOrderAc.this, paraml);
        return;
      }
      paraml = paraml.getMessage();
      if (!TextUtils.isEmpty(paraml)) {
        ConfirmOrderAc.this.showToast(paraml);
      }
      for (;;)
      {
        ConfirmOrderAc.this.dismissProgress();
        return;
        ConfirmOrderAc.this.showToast("提交订单失败，请稍后再试");
      }
    }
  }
  
  class c
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public c(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      ConfirmOrderAc.this.dismissProgress();
      ConfirmOrderAc.this.showToast("支付失败，请重试");
      ConfirmOrderAc.this.toPayListAc(0);
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        paraml = (ap)paraml.getObject();
        if (paraml != null) {
          ConfirmOrderAc.b(ConfirmOrderAc.this, paraml);
        }
        for (;;)
        {
          ConfirmOrderAc.this.dismissProgress();
          return;
          if ((paraml == null) && (ConfirmOrderAc.l(ConfirmOrderAc.this) == 0.0D))
          {
            ConfirmOrderAc.this.dismissProgress();
            ConfirmOrderAc.this.toPayListAc(-1);
          }
          else
          {
            ConfirmOrderAc.this.showToast("支付失败，请重试");
            ConfirmOrderAc.this.dismissProgress();
            ConfirmOrderAc.this.toPayListAc(0);
          }
        }
      }
      paraml = paraml.getMessage();
      if (paraml != null) {
        ConfirmOrderAc.this.showToast(paraml);
      }
      for (;;)
      {
        ConfirmOrderAc.this.dismissProgress();
        ConfirmOrderAc.this.toPayListAc(0);
        break;
        ConfirmOrderAc.this.showToast("支付失败，请重试");
      }
    }
  }
  
  class d
    extends com.ziroom.ziroomcustomer.newServiceList.view.a
  {
    private int b;
    private int c;
    
    public d(EditText paramEditText, Context paramContext)
    {
      super(paramContext);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      super.afterTextChanged(paramEditable);
      this.b = ConfirmOrderAc.b(ConfirmOrderAc.this).getSelectionStart();
      this.c = ConfirmOrderAc.b(ConfirmOrderAc.this).getSelectionEnd();
      ConfirmOrderAc.b(ConfirmOrderAc.this).removeTextChangedListener(ConfirmOrderAc.c(ConfirmOrderAc.this));
      while (ConfirmOrderAc.a(ConfirmOrderAc.this, paramEditable.toString()) > ConfirmOrderAc.a(ConfirmOrderAc.this))
      {
        paramEditable.delete(this.b - 1, this.c);
        this.b -= 1;
        this.c -= 1;
      }
      ConfirmOrderAc.b(ConfirmOrderAc.this).setSelection(this.b);
      ConfirmOrderAc.b(ConfirmOrderAc.this).addTextChangedListener(ConfirmOrderAc.c(ConfirmOrderAc.this));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (paramCharSequence.length() > ConfirmOrderAc.a(ConfirmOrderAc.this)) {
        ConfirmOrderAc.this.showToast("字数超出限制！");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/ConfirmOrderAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */