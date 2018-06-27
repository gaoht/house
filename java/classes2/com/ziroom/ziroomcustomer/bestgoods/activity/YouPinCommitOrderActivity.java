package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.u;
import com.ziroom.ziroomcustomer.bestgoods.model.YouPinCommitOrderGoodsInfoMo;
import com.ziroom.ziroomcustomer.bestgoods.model.m;
import com.ziroom.ziroomcustomer.bestgoods.model.t;
import com.ziroom.ziroomcustomer.bestgoods.model.v;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ExpandableListViewForScrollView;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.AddressMo;
import com.ziroom.ziroomcustomer.newServiceList.model.ap;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class YouPinCommitOrderActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private TextView C;
  private Context D;
  private int E = 333;
  private int F = 666;
  private int G = 999;
  private int H = -1;
  private String I = "";
  private String J = "";
  private String K;
  private boolean L = false;
  private Intent M;
  private boolean N = false;
  private AddressMo O;
  private int P = 0;
  private ArrayList<AddressMo> Q;
  private double R = 0.0D;
  private String S;
  private String T;
  private List<YouPinCommitOrderGoodsInfoMo> U = new ArrayList();
  private Double V;
  private DecimalFormat W = new DecimalFormat("0.00");
  private boolean X = false;
  private Double Y = Double.valueOf(0.0D);
  private d Z = null;
  private ImageView a;
  private BroadcastReceiver aa = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.ziroom.ziroomcustomer.activity_1"))
      {
        YouPinCommitOrderActivity.this.toPayListAc(-1);
        return;
      }
      YouPinCommitOrderActivity.this.toPayListAc(0);
    }
  };
  private LabeledEditText b;
  private LabeledEditText c;
  private LabeledEditText d;
  private ExpandableListViewForScrollView e;
  private TextView f;
  private RelativeLayout g;
  private TextView r;
  private RelativeLayout s;
  private TextView t;
  private RelativeLayout u;
  private TextView v;
  private EditText w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.D = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((LabeledEditText)findViewById(2131689982));
    this.c = ((LabeledEditText)findViewById(2131689983));
    this.d = ((LabeledEditText)findViewById(2131689981));
    this.e = ((ExpandableListViewForScrollView)findViewById(2131692707));
    this.f = ((TextView)findViewById(2131692708));
    this.g = ((RelativeLayout)findViewById(2131689984));
    this.r = ((TextView)findViewById(2131689985));
    this.s = ((RelativeLayout)findViewById(2131689986));
    this.t = ((TextView)findViewById(2131689987));
    this.u = ((RelativeLayout)findViewById(2131689988));
    this.v = ((TextView)findViewById(2131689850));
    this.w = ((EditText)findViewById(2131689989));
    this.x = ((TextView)findViewById(2131689991));
    this.y = ((TextView)findViewById(2131689992));
    this.z = ((TextView)findViewById(2131689993));
    this.A = ((TextView)findViewById(2131689994));
    this.B = ((TextView)findViewById(2131689996));
    this.C = ((TextView)findViewById(2131689997));
  }
  
  private void a(com.ziroom.ziroomcustomer.bestgoods.model.l paraml)
  {
    Object localObject = paraml.getList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      this.Y = Double.valueOf(this.Y.doubleValue() + localm.getOrderPrice());
    }
    showProgressNoCancel("", 30000L);
    localObject = new HashMap();
    ((Map)localObject).put("money", new DecimalFormat("0.00").format(this.Y) + "");
    ((Map)localObject).put("payKind", "1");
    ((Map)localObject).put("couponCode", paraml.getPromotionCode());
    ((Map)localObject).put("strGoodsOrderPrices", com.alibaba.fastjson.a.toJSONString(paraml.getList()));
    j.PayGoodsOrder(this, (Map)localObject, new c(new com.ziroom.ziroomcustomer.newrepair.utils.b(ap.class)));
  }
  
  private void a(final ap paramap)
  {
    double d1 = 0.0D;
    final Dialog localDialog = new Dialog(this, 2131427692);
    View localView = getLayoutInflater().inflate(2130903806, null);
    Object localObject = (TextView)localView.findViewById(2131691288);
    TextView localTextView = (TextView)localView.findViewById(2131689846);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131693701);
    if (this.Y.doubleValue() >= 0.0D) {
      d1 = this.Y.doubleValue();
    }
    localTextView.setText(String.format("%.2f", new Object[] { Double.valueOf(d1) }));
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
        YouPinCommitOrderActivity.this.toPayListAc(0);
      }
    });
    localRelativeLayout.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        YouPinCommitOrderActivity.b(YouPinCommitOrderActivity.this, paramap);
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
    this.a.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.C.setOnClickListener(new com.ziroom.ziroomcustomer.bestgoods.b.b()
    {
      public void onMultiClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if (YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this)) {
            YouPinCommitOrderActivity.b(YouPinCommitOrderActivity.this);
          }
          return;
        }
        g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), "订单正在提交，请稍后");
      }
    });
  }
  
  private void b(ap paramap)
  {
    if (TextUtils.isEmpty(paramap.getPartnerid())) {}
    for (int i = this.Z.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), "1248814701");; i = this.Z.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), paramap.getPartnerid()))
    {
      if (i != 0) {
        toPayListAc(0);
      }
      return;
    }
  }
  
  private void e()
  {
    this.V = Double.valueOf(getIntent().getDoubleExtra("totalPrice", -1.0D));
    this.B.setText(this.W.format(this.V) + "");
    List localList = com.alibaba.fastjson.a.parseArray(getIntent().getStringExtra("selectedGoods"), v.class);
    int i;
    Object localObject;
    int j;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i = 0;
      while (i < localList.size())
      {
        localObject = ((v)localList.get(i)).getShoppingCartEntityList();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          j = 0;
          while (j < ((List)localObject).size())
          {
            if (((t)((List)localObject).get(j)).getAmount().intValue() == 0) {
              ((List)localObject).remove(j);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    if ((localList != null) && (!localList.isEmpty())) {
      i = 0;
    }
    for (;;)
    {
      if (i < localList.size())
      {
        localObject = ((v)localList.get(i)).getShoppingCartEntityList();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          j = 0;
        }
      }
      else
      {
        while (j < ((List)localObject).size())
        {
          if (((t)((List)localObject).get(j)).getActivityPrice() != null)
          {
            this.X = true;
            localObject = new u(this.D, localList);
            this.e.setAdapter((ExpandableListAdapter)localObject);
            this.e.setGroupIndicator(null);
            j = this.e.getCount();
            i = 0;
            while (i < j)
            {
              this.e.expandGroup(i);
              i += 1;
            }
          }
          this.X = false;
          j += 1;
        }
      }
      i += 1;
    }
    this.e.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      @Instrumented
      public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onGroupClick(this, paramAnonymousExpandableListView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
      }
    });
    int k;
    if ((localList != null) && (!localList.isEmpty()))
    {
      int m = 0;
      i = 0;
      j = 0;
      int n;
      for (k = 0; m < localList.size(); k = n)
      {
        localObject = ((v)localList.get(m)).getShoppingCartEntityList();
        int i2 = i;
        int i1 = j;
        n = k;
        if (localObject != null)
        {
          i2 = i;
          i1 = j;
          n = k;
          if (!((List)localObject).isEmpty())
          {
            n = j;
            i1 = i;
            i2 = 0;
            j = k;
            i = n;
            k = i1;
            n = i2;
            if (n < ((List)localObject).size())
            {
              i1 = k;
              i2 = i;
              int i3 = j;
              if (((t)((List)localObject).get(n)).isChildSelect())
              {
                YouPinCommitOrderGoodsInfoMo localYouPinCommitOrderGoodsInfoMo = new YouPinCommitOrderGoodsInfoMo();
                localYouPinCommitOrderGoodsInfoMo.setProductCode(((t)((List)localObject).get(n)).getProductCode());
                localYouPinCommitOrderGoodsInfoMo.setSkuCode(((t)((List)localObject).get(n)).getSkuCode());
                localYouPinCommitOrderGoodsInfoMo.setCount(((t)((List)localObject).get(n)).getAmount());
                localYouPinCommitOrderGoodsInfoMo.setShoppingCartCode(((t)((List)localObject).get(n)).getShoppingCartCode());
                localYouPinCommitOrderGoodsInfoMo.setFreight(Integer.valueOf(((t)((List)localObject).get(n)).getFreight()));
                localYouPinCommitOrderGoodsInfoMo.setSkuUrl(((t)((List)localObject).get(n)).getUrl());
                localYouPinCommitOrderGoodsInfoMo.setDeliveryMode(((t)((List)localObject).get(n)).getDeliveryMode());
                this.U.add(localYouPinCommitOrderGoodsInfoMo);
                i3 = j + ((t)((List)localObject).get(n)).getFreight();
                if (((t)((List)localObject).get(n)).getDeliveryMode().intValue() != 0) {
                  break label805;
                }
                i1 = 1;
                i2 = i;
              }
              for (;;)
              {
                n += 1;
                k = i1;
                i = i2;
                j = i3;
                break;
                label805:
                i2 = 1;
                i1 = k;
              }
            }
            n = j;
            i1 = i;
            i2 = k;
          }
        }
        m += 1;
        i = i2;
        j = i1;
      }
      if ((i == 0) || (j == 0)) {
        break label961;
      }
      this.f.setText("送货上门+快递配送");
    }
    for (;;)
    {
      this.z.setText("¥" + this.W.format(k));
      double d1 = this.V.doubleValue();
      double d2 = k;
      this.x.setText("¥" + this.W.format(Double.valueOf(d1 + d2)) + "");
      return;
      label961:
      if (i != 0) {
        this.f.setText("送货上门");
      } else {
        this.f.setText("快递配送");
      }
    }
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    j.getBestGoodsAddressList(this.D, localHashMap, new a(new com.ziroom.ziroomcustomer.newrepair.utils.a(AddressMo.class, false)));
  }
  
  private void g()
  {
    if (this.P == 1)
    {
      this.M = new Intent(this.D, YouPinModifyAddressActivity.class);
      this.M.putExtra("isAllCity", true);
      startActivityForResult(this.M, this.F);
      return;
    }
    if (this.P == 2)
    {
      this.M = new Intent(this.D, YouPinAddressActivity.class);
      this.M.putParcelableArrayListExtra("addressList", this.Q);
      this.M.putExtra("isAllCity", true);
      startActivityForResult(this.M, this.G);
      return;
    }
    f();
  }
  
  private void h()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.D).setTitle("提示").setContent("请阅读商品的配送安装区域，确保下单地址在我们的服务范围内").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          YouPinCommitOrderActivity.h(YouPinCommitOrderActivity.this);
        }
      }
    }).build().show();
  }
  
  private boolean i()
  {
    if (TextUtils.isEmpty(this.K))
    {
      g.textToast(this.D, "请选择物业地址");
      return false;
    }
    if (TextUtils.isEmpty(this.b.getText()))
    {
      g.textToast(this.D, "请输入您的姓名");
      return false;
    }
    String str = this.c.getText();
    if ((TextUtils.isEmpty(str)) || (!ah.isMobile(str)))
    {
      g.textToast(this.D, "请输入正确的联系电话");
      return false;
    }
    return true;
  }
  
  private void j()
  {
    if (checkNet(this.D))
    {
      showProgressNoCancel("", 30000L);
      k();
      HashMap localHashMap = new HashMap();
      localHashMap.put("addressId", this.K);
      localHashMap.put("postCode", "");
      localHashMap.put("connectionPhone", this.c.getText().toString());
      localHashMap.put("connectionName", this.b.getText().toString());
      localHashMap.put("userMessage", VdsAgent.trackEditTextSilent(this.w).toString());
      localHashMap.put("specialNeeds", "");
      localHashMap.put("promotionId", this.T);
      localHashMap.put("promotionCode", this.S);
      localHashMap.put("promotionPrice", this.R + "");
      localHashMap.put("totalPrice", this.V + "");
      localHashMap.put("dispatTypeCode", "第三方配送");
      if (this.H == -1) {}
      for (String str = "0";; str = "1")
      {
        localHashMap.put("invoiceFlag", str);
        localHashMap.put("invoiceType", "0");
        localHashMap.put("payerType", this.H + "");
        localHashMap.put("companyName", this.I);
        localHashMap.put("identityNo", this.J);
        localHashMap.put("drawerPhone", this.c.getText().toString());
        localHashMap.put("drawerEmail", "");
        localHashMap.put("invoiceContent", "明细");
        localHashMap.put("freight", "");
        localHashMap.put("goodsInfo", com.alibaba.fastjson.a.toJSONString(this.U));
        j.confirmGoodsOrder(this, localHashMap, new b(new com.ziroom.ziroomcustomer.newrepair.utils.b(com.ziroom.ziroomcustomer.bestgoods.model.l.class)));
        return;
      }
    }
    g.textToast(this.D, "请保证网络畅通");
  }
  
  private void k()
  {
    this.Z = new d();
    this.Z.initWXAPI(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_1");
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_2");
    registerReceiver(this.aa, localIntentFilter);
  }
  
  private void l()
  {
    if (!this.N)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.D);
      return;
    }
    this.M = new Intent(this.D, YouPinCouponsActivity.class);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.U.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (YouPinCommitOrderGoodsInfoMo)((Iterator)localObject1).next();
      if (!localArrayList.contains(((YouPinCommitOrderGoodsInfoMo)localObject2).getProductCode())) {
        localArrayList.add(((YouPinCommitOrderGoodsInfoMo)localObject2).getProductCode());
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
    this.M.putExtra("serviceInfoId", (String)localObject2);
    this.M.putExtra("totalPrice", this.V);
    this.M.putExtra("addressId", this.K);
    localObject1 = com.alibaba.fastjson.a.toJSONString(this.U);
    this.M.putExtra("goodsInfo", (String)localObject1);
    startActivityForResult(this.M, this.E);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    StringBuilder localStringBuilder;
    Object localObject1;
    label215:
    double d1;
    if ((paramInt1 == this.G) && (paramIntent.getParcelableExtra("address") != null))
    {
      this.O = ((AddressMo)paramIntent.getParcelableExtra("address"));
      this.K = this.O.getFid();
      localObject2 = this.d;
      localStringBuilder = new StringBuilder().append(this.O.getVillage());
      if (ae.notNull(this.O.getDetAddress()))
      {
        localObject1 = this.O.getDetAddress();
        ((LabeledEditText)localObject2).setText((String)localObject1);
        this.d.getTextView().setEllipsize(TextUtils.TruncateAt.END);
      }
    }
    else
    {
      if ((paramInt1 == this.F) && (paramInt2 == -1))
      {
        this.O = ((AddressMo)paramIntent.getParcelableExtra("savaAddress"));
        this.P = 2;
        this.K = this.O.getFid();
        localObject2 = this.d;
        localStringBuilder = new StringBuilder().append(this.O.getVillage());
        if (!ae.notNull(this.O.getDetAddress())) {
          break label578;
        }
        localObject1 = this.O.getDetAddress();
        ((LabeledEditText)localObject2).setText((String)localObject1);
        this.d.getTextView().setEllipsize(TextUtils.TruncateAt.END);
      }
      if ((paramInt1 == this.E) && (paramInt2 == -1))
      {
        if (!paramIntent.getBooleanExtra("useCoupon", false)) {
          break label591;
        }
        localObject1 = (al)paramIntent.getSerializableExtra("couponItem");
        this.T = ((al)localObject1).getPromoId();
        this.S = ((al)localObject1).getPromoCode();
        this.R = ((al)localObject1).getPromoPrice();
        this.r.setText("－¥" + String.format("%.2f", new Object[] { Double.valueOf(this.R) }));
        this.r.setTextColor(this.D.getResources().getColor(2131624039));
        this.A.setText("－¥" + String.format("%.2f", new Object[] { Double.valueOf(this.R) }));
        d1 = this.V.doubleValue() - this.R;
        localObject1 = this.B;
        localObject2 = new StringBuilder().append("");
        if (d1 < 0.0D) {
          break label585;
        }
        label460:
        ((TextView)localObject1).setText(String.format("%.2f", new Object[] { Double.valueOf(d1) }));
      }
      if ((paramInt1 == 111) && (paramInt2 == -1))
      {
        if (!paramIntent.getBooleanExtra("needInvoice", false)) {
          break label863;
        }
        if (paramIntent.getIntExtra("payerType", -1) != 0) {
          break label765;
        }
        this.H = 0;
        this.I = paramIntent.getStringExtra("companyName");
        this.t.setText("个人");
        this.t.setTextColor(this.D.getResources().getColor(2131624039));
      }
    }
    label578:
    label585:
    label591:
    label765:
    while (paramIntent.getIntExtra("payerType", -1) != 1)
    {
      return;
      localObject1 = "";
      break;
      localObject1 = "";
      break label215;
      d1 = 0.0D;
      break label460;
      this.T = "";
      this.S = "";
      this.R = 0.0D;
      this.r.setText("请选择优惠券");
      this.r.setTextColor(this.D.getResources().getColor(2131624042));
      this.A.setText("－¥" + String.format("%.2f", new Object[] { Double.valueOf(this.R) }));
      d1 = this.V.doubleValue() - this.R;
      localObject1 = this.B;
      localObject2 = new StringBuilder().append("");
      if (d1 >= 0.0D) {}
      for (;;)
      {
        ((TextView)localObject1).setText(String.format("%.2f", new Object[] { Double.valueOf(d1) }));
        break;
        d1 = 0.0D;
      }
    }
    this.H = 1;
    this.I = paramIntent.getStringExtra("companyName");
    this.t.setTextColor(this.D.getResources().getColor(2131624039));
    this.t.setText("单位");
    this.J = paramIntent.getStringExtra("companyNum");
    aa.putString(this.D, "companyNum", this.J);
    aa.putString(this.D, "companyName", this.I);
    return;
    label863:
    this.H = -1;
    this.I = "";
    this.t.setText("不开具发票");
    this.t.setTextColor(this.D.getResources().getColor(2131624042));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.N = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131689981: 
      this.L = true;
      if (!this.N)
      {
        this.M = new Intent(this.D, ServiceLoginActivity.class);
        startActivity(this.M);
        return;
      }
      if (this.P < 0)
      {
        if (!checkNet(this.D))
        {
          g.textToast(this.D, "请检查网络后重试");
          return;
        }
        showProgress("");
        f();
        return;
      }
      g();
      return;
    case 2131692708: 
      paramView = com.alibaba.fastjson.a.toJSONString(this.U);
      Intent localIntent = new Intent(this.D, YouPinDeliveryModeActivity.class);
      localIntent.putExtra("goodsInfoString", paramView);
      startActivity(localIntent);
      return;
    case 2131689984: 
    case 2131689985: 
      l();
      return;
    }
    paramView = new Intent(this.D, InvoiceAc.class);
    paramView.putExtra("companyName", this.I);
    paramView.putExtra("companyNum", this.J);
    paramView.putExtra("payerType", this.H);
    startActivityForResult(paramView, 111);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903552);
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.aa != null) {
        unregisterReceiver(this.aa);
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
          if (paramInt == -1)
          {
            Intent localIntent = new Intent(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), YouPinOrderPaySuccessActivity.class);
            localIntent.putExtra("address", YouPinCommitOrderActivity.k(YouPinCommitOrderActivity.this).getText().toString());
            localIntent.putExtra("totalPrice", YouPinCommitOrderActivity.j(YouPinCommitOrderActivity.this));
            localIntent.putExtra("connectionPhone", YouPinCommitOrderActivity.l(YouPinCommitOrderActivity.this).getText().toString());
            localIntent.putExtra("connectionName", YouPinCommitOrderActivity.m(YouPinCommitOrderActivity.this).getText().toString());
            YouPinCommitOrderActivity.this.startActivity(localIntent);
          }
          for (;;)
          {
            YouPinCommitOrderActivity.this.finish();
            return;
            YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this, new Intent(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), ZiroomOrderListActivity.class));
            YouPinCommitOrderActivity.i(YouPinCommitOrderActivity.this).putExtra("orderState", paramInt);
            YouPinCommitOrderActivity.i(YouPinCommitOrderActivity.this).putExtra("order_bus_type", "type_youpin");
            YouPinCommitOrderActivity.this.startActivity(YouPinCommitOrderActivity.i(YouPinCommitOrderActivity.this));
          }
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
      YouPinCommitOrderActivity.this.dismissProgress();
      g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), "请稍后再试");
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this, (ArrayList)paraml.getObject());
        if ((YouPinCommitOrderActivity.d(YouPinCommitOrderActivity.this) != null) && (YouPinCommitOrderActivity.d(YouPinCommitOrderActivity.this).size() > 0)) {
          YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this, 2);
        }
        for (;;)
        {
          if (YouPinCommitOrderActivity.e(YouPinCommitOrderActivity.this)) {
            YouPinCommitOrderActivity.f(YouPinCommitOrderActivity.this);
          }
          YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this, false);
          YouPinCommitOrderActivity.this.dismissProgress();
          return;
          YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this, 1);
        }
      }
      paraml = paraml.getMessage();
      if (paraml != null) {
        g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), paraml);
      }
      for (;;)
      {
        YouPinCommitOrderActivity.g(YouPinCommitOrderActivity.this);
        break;
        g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), "请稍后再试");
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
      YouPinCommitOrderActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        YouPinCommitOrderActivity.this.dismissProgress();
        YouPinCommitOrderActivity.this.setResult(-1, YouPinCommitOrderActivity.i(YouPinCommitOrderActivity.this));
        final String str = paraml.getMessage();
        if (!TextUtils.isEmpty(str))
        {
          af.showToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), str, 1);
          new Thread()
          {
            public void run()
            {
              SystemClock.sleep(2000L);
              YouPinCommitOrderActivity.this.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  af.showToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), YouPinCommitOrderActivity.b.1.this.a, 1);
                }
              });
            }
          }.start();
        }
        paraml = (com.ziroom.ziroomcustomer.bestgoods.model.l)paraml.getObject();
        YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this, paraml);
        return;
      }
      paraml = paraml.getMessage();
      if (!TextUtils.isEmpty(paraml)) {
        g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), paraml);
      }
      for (;;)
      {
        YouPinCommitOrderActivity.this.dismissProgress();
        return;
        g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), "提交订单失败，请稍后再试");
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
      YouPinCommitOrderActivity.this.dismissProgress();
      g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), "支付失败，请重试");
      YouPinCommitOrderActivity.this.toPayListAc(0);
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        paraml = (ap)paraml.getObject();
        if (paraml != null) {
          YouPinCommitOrderActivity.a(YouPinCommitOrderActivity.this, paraml);
        }
        for (;;)
        {
          YouPinCommitOrderActivity.this.dismissProgress();
          return;
          if ((paraml == null) && (YouPinCommitOrderActivity.j(YouPinCommitOrderActivity.this).doubleValue() == 0.0D))
          {
            YouPinCommitOrderActivity.this.dismissProgress();
            YouPinCommitOrderActivity.this.toPayListAc(-1);
          }
          else
          {
            g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), "支付失败，请重试");
            YouPinCommitOrderActivity.this.dismissProgress();
            YouPinCommitOrderActivity.this.toPayListAc(0);
          }
        }
      }
      paraml = paraml.getMessage();
      if (paraml != null) {
        g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), paraml);
      }
      for (;;)
      {
        YouPinCommitOrderActivity.this.dismissProgress();
        YouPinCommitOrderActivity.this.toPayListAc(0);
        break;
        g.textToast(YouPinCommitOrderActivity.c(YouPinCommitOrderActivity.this), "支付失败，请重试");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinCommitOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */