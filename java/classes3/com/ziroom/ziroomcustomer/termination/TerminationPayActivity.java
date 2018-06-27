package com.ziroom.ziroomcustomer.termination;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.e.c;
import com.ziroom.commonlibrary.e.c.a;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.PayOrder;
import com.ziroom.ziroomcustomer.pay.huifu.activity.AddBandCardActivity;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean.HfInfoBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBackMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage.DataBean;
import com.ziroom.ziroomcustomer.reserve.a.a;
import com.ziroom.ziroomcustomer.signed.SignedJDPayWebActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TerminationPayActivity
  extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private TextView A;
  private TextView B;
  private TextView C;
  private RelativeLayout D;
  private com.ziroom.ziroomcustomer.reserve.a E;
  private boolean F;
  private double G = 0.0D;
  private double H = 0.0D;
  private int I;
  private int J;
  private int K;
  private com.ziroom.commonlibrary.e.d L = new com.ziroom.commonlibrary.e.d();
  private PayOrder M;
  private String N;
  private String O;
  private String P;
  private String Q;
  private HashMap<Integer, String> R;
  private HuiFuIsBandAndBandList S;
  private Boolean T = Boolean.valueOf(false);
  private String U;
  private String V;
  private String W;
  private BroadcastReceiver X = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      TerminationPayActivity.f(TerminationPayActivity.this);
    }
  };
  private Handler Y = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 8947848: 
        for (;;)
        {
          return false;
          paramAnonymousMessage = (HuifuBackMessage)paramAnonymousMessage.obj;
          if (paramAnonymousMessage != null)
          {
            TerminationPayActivity.a(TerminationPayActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_id);
            TerminationPayActivity.b(TerminationPayActivity.this, paramAnonymousMessage.mMessageCode);
            TerminationPayActivity.c(TerminationPayActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_date);
            TerminationPayActivity.a(TerminationPayActivity.this, 8);
            int i = (int)ah.setDouble(Double.valueOf(Double.parseDouble(VdsAgent.trackEditTextSilent(TerminationPayActivity.i(TerminationPayActivity.this)).toString()) * 100.0D));
            TerminationPayActivity.d(TerminationPayActivity.this, q.s + e.a.l);
            paramAnonymousMessage = com.ziroom.ziroomcustomer.e.g.getPaymentUrlUrl(TerminationPayActivity.j(TerminationPayActivity.this), TerminationPayActivity.k(TerminationPayActivity.this), TerminationPayActivity.this, TerminationPayActivity.l(TerminationPayActivity.this), i, TerminationPayActivity.m(TerminationPayActivity.this), TerminationPayActivity.n(TerminationPayActivity.this), TerminationPayActivity.o(TerminationPayActivity.this), TerminationPayActivity.p(TerminationPayActivity.this));
            j.getReservationOrderText(TerminationPayActivity.q(TerminationPayActivity.this), new TerminationPayActivity.a(TerminationPayActivity.this), paramAnonymousMessage, true, TerminationPayActivity.r(TerminationPayActivity.this));
          }
        }
      }
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue()) {
        TerminationPayActivity.f(TerminationPayActivity.this);
      }
      for (;;)
      {
        TerminationPayActivity.this.dismissProgress();
        break;
        TerminationPayActivity.this.showToast(paramAnonymousMessage.getMessage());
      }
    }
  });
  private Context a;
  private EditText b;
  private com.ziroom.ziroomcustomer.termination.a.a c;
  private CheckBox d;
  private ImageView e;
  private Button f;
  private Button g;
  private Button r;
  private ListViewForScrollView s;
  private Button t;
  private Button u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.O = getIntent().getStringExtra("backRentOrderCode");
    this.N = getIntent().getStringExtra("contractCode");
  }
  
  private void a(PayOrder paramPayOrder)
  {
    this.L.doStartWXPay(this, paramPayOrder.getTrans_id(), paramPayOrder.getMerorder_id(), paramPayOrder.getTimestamp(), paramPayOrder.get_package(), paramPayOrder.getSign(), paramPayOrder.getPartnerid());
  }
  
  private void b()
  {
    this.e = ((ImageView)findViewById(2131690105));
    this.D = ((RelativeLayout)findViewById(2131693314));
    this.C = ((TextView)findViewById(2131697640));
    this.B = ((TextView)findViewById(2131693312));
    this.A = ((TextView)findViewById(2131693311));
    this.z = ((TextView)findViewById(2131693309));
    this.y = ((TextView)findViewById(2131692992));
    this.x = ((TextView)findViewById(2131693316));
    this.v = ((TextView)findViewById(2131693324));
    this.w = ((TextView)findViewById(2131693327));
    this.t = ((Button)findViewById(2131693323));
    this.u = ((Button)findViewById(2131693326));
    this.r = ((Button)findViewById(2131693338));
    this.s = ((ListViewForScrollView)findViewById(2131693337));
    isUserPay();
    payType();
    this.E = new com.ziroom.ziroomcustomer.reserve.a(this.c.getPayTypeList(), this.a, setCheck(this.c));
    this.s.setAdapter(this.E);
    this.E.setmPayType(new a.a()
    {
      public void setPayType(int paramAnonymousInt)
      {
        if ((!TerminationPayActivity.c(TerminationPayActivity.this).booleanValue()) && (paramAnonymousInt == 8))
        {
          TerminationPayActivity.d(TerminationPayActivity.this).setText("去绑卡");
          return;
        }
        TerminationPayActivity.d(TerminationPayActivity.this).setText("去支付");
      }
    });
    this.N = this.c.getContractCode();
    i();
    h();
    this.d = ((CheckBox)findViewById(2131693315));
    this.b = ((EditText)findViewById(2131693269));
    this.g = ((Button)findViewById(2131693328));
    this.f = ((Button)findViewById(2131693329));
    double d1 = this.c.getShouldPay();
    this.G = d1;
    this.H = d1;
    this.b.setEnabled(false);
    this.b.setText(ah.Number(this.c.getShouldPay()) + "");
    this.x.setText(this.c.getAccountBalance() / 100.0D + "");
    this.B.setText(this.c.getPayFee() + "");
    this.A.setText(this.c.getFee() + "");
    this.z.setText(this.c.getAddress());
    this.y.setText(this.c.getContractCode());
    this.C.setText(this.c.getCheckoutDate());
  }
  
  private void b(PayOrder paramPayOrder)
  {
    Intent localIntent = new Intent(this.a, SignedJDPayWebActivity.class);
    localIntent.putExtra("url", paramPayOrder.getUrl());
    if (this.J == 3) {
      localIntent.putExtra("title", "京东支付");
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      localIntent.putExtra("title", "自如白条");
    }
  }
  
  private double e()
  {
    return ah.Number2(this.G);
  }
  
  private void f()
  {
    if ((this.J == 8) && (!this.T.booleanValue()))
    {
      Intent localIntent = new Intent(this, AddBandCardActivity.class);
      localIntent.putExtra("contractCode", this.N);
      localIntent.putExtra("reserveCode", "");
      localIntent.putExtra("backRentOrderCode", "");
      localIntent.putExtra("bizType", "rentBackPay");
      startActivity(localIntent);
      return;
    }
    showProgress("");
    int j = (int)ah.setDouble(Double.valueOf(Double.parseDouble(VdsAgent.trackEditTextSilent(this.b).toString()) * 100.0D));
    int k = (int)ah.setDouble(Double.valueOf(Double.parseDouble(VdsAgent.trackEditTextSilent(this.b).toString()) * 100.0D));
    int i = j;
    if (this.d.isChecked()) {
      i = j + (int)(Float.parseFloat(this.x.getText().toString()) * 100.0F);
    }
    com.ziroom.ziroomcustomer.pay.common.b.a.getIsCanPayResult(this, 4, this.O, 0, i, k, this.J + "", new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        TerminationPayActivity.this.dismissProgress();
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          TerminationPayActivity.e(TerminationPayActivity.this);
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(TerminationPayActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  private void g()
  {
    if (this.J == 8)
    {
      if (this.T.booleanValue()) {
        new com.ziroom.ziroomcustomer.pay.huifu.a.a(this, this.Y, null, 201, this.N, "", "", "rentBackPay").showMessageDialog();
      }
      return;
    }
    int i = (int)ah.setDouble(Double.valueOf(Double.parseDouble(VdsAgent.trackEditTextSilent(this.b).toString()) * 100.0D));
    this.Q = (q.s + e.a.l);
    Map localMap = com.ziroom.ziroomcustomer.e.g.getPaymentUrlUrl(this.N, this.O, this, this.J, i, this.I, this.U, this.V, this.W);
    j.getReservationOrderText(this.a, new a(), localMap, true, this.Q);
  }
  
  private void h()
  {
    if ((this.c == null) || (this.c.getPayTypeList() == null) || (!this.c.getPayTypeList().contains(Integer.valueOf(8)))) {
      return;
    }
    com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuPayTypeList(this, "companyCode", "rentBackPay", this.N, "", this.O, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        com.freelxl.baselibrary.f.d.e("yangxj--------", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {}
        do
        {
          return;
          TerminationPayActivity.a(TerminationPayActivity.this, (HuiFuIsBandAndBandList)paramAnonymousk.getObject());
        } while (TerminationPayActivity.g(TerminationPayActivity.this) == null);
        if (!TerminationPayActivity.g(TerminationPayActivity.this).isSuccess())
        {
          com.freelxl.baselibrary.f.g.textToast(TerminationPayActivity.this, TerminationPayActivity.g(TerminationPayActivity.this).getError_message());
          return;
        }
        if ((TerminationPayActivity.g(TerminationPayActivity.this).data == null) || (TerminationPayActivity.g(TerminationPayActivity.this).data.hfInfo == null))
        {
          TerminationPayActivity.a(TerminationPayActivity.this, Boolean.valueOf(false));
          return;
        }
        if (TerminationPayActivity.g(TerminationPayActivity.this).data.hfInfo.isBind == 0)
        {
          TerminationPayActivity.a(TerminationPayActivity.this, Boolean.valueOf(false));
          return;
        }
        TerminationPayActivity.a(TerminationPayActivity.this, Boolean.valueOf(true));
        TerminationPayActivity.h(TerminationPayActivity.this);
      }
    });
  }
  
  private void i()
  {
    int i = 0;
    this.R = new HashMap();
    this.R.put(Integer.valueOf(1), "支付服务有银联提供（不支持交通、招商）");
    this.R.put(Integer.valueOf(2), "推荐已安装微信客户端的用户使用");
    this.R.put(Integer.valueOf(3), "支付服务由京东提供");
    this.R.put(Integer.valueOf(6), "支付服务有银联提供");
    if (this.T.booleanValue())
    {
      localObject = (HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)this.S.data.hfInfo.bindBanks.get(0);
      this.R.put(Integer.valueOf(8), ((HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)localObject).bankName + "(" + ((HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)localObject).bankNo + ")");
      if (this.E != null) {
        this.E.setmImgHuifuIcon(((HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)localObject).bankIconApp);
      }
    }
    for (;;)
    {
      if (this.E != null) {
        this.E.setmListMsg(this.R);
      }
      if ((this.r != null) && (this.E != null) && (this.E.getmCheck() != null) && (this.E.getmList() != null)) {
        break;
      }
      return;
      this.R.put(Integer.valueOf(8), "一次性完成绑卡，更便捷支付体验");
    }
    Object localObject = this.E.getmCheck();
    int j = 0;
    while (i < ((List)localObject).size())
    {
      if (((Integer)((List)localObject).get(i)).intValue() == 1) {
        j = ((Integer)this.E.getmList().get(i)).intValue();
      }
      i += 1;
    }
    if ((!this.T.booleanValue()) && (j == 8))
    {
      this.r.setText("去绑卡");
      return;
    }
    this.r.setText("去支付");
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this.a, TerminationPaySuccessActivity.class);
    localIntent.putExtra("backRentOrderCode", this.O);
    localIntent.putExtra("contractCode", this.N);
    float f1 = this.I / 100.0F;
    if (f1 + Double.parseDouble(VdsAgent.trackEditTextSilent(this.b).toString()) < this.c.getShouldPay()) {
      localIntent.putExtra("isFull", "0");
    }
    for (;;)
    {
      localIntent.putExtra("money", ah.setDouble(Double.valueOf(f1 + Double.parseDouble(VdsAgent.trackEditTextSilent(this.b).toString()))) + "");
      startActivity(localIntent);
      return;
      localIntent.putExtra("isFull", "1");
    }
  }
  
  public double getInputAmount()
  {
    String str = VdsAgent.trackEditTextSilent(this.b).toString();
    if (ae.notNull(str)) {}
    for (double d1 = ah.Number2(Double.parseDouble(str));; d1 = 0.0D) {
      return ah.Number2(d1);
    }
  }
  
  public void isUserPay()
  {
    int i = 0;
    while (i < this.c.getPayTypeList().size())
    {
      if (((Integer)this.c.getPayTypeList().get(i)).intValue() == 4) {
        this.D.setVisibility(0);
      }
      i += 1;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new c.a()
    {
      public void doBack()
      {
        TerminationPayActivity.f(TerminationPayActivity.this);
      }
    });
  }
  
  @Instrumented
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
    switch (paramCompoundButton.getId())
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      if (this.c.getAccountBalance() <= 0.0D)
      {
        showToast("您没有账户余额");
        this.d.setChecked(false);
        return;
      }
      double d1 = getInputAmount();
      double d2 = d1 - this.c.getAccountBalance() / 100.0D;
      if (d2 <= 500.0D)
      {
        this.g.setBackgroundResource(2130838347);
        this.g.setEnabled(false);
      }
      if (d2 <= 0.0D)
      {
        this.I = ((int)(d1 * 100.0D));
        this.r.setText("使用账户余额支付");
        this.s.setVisibility(8);
        this.J = 4;
        this.b.setText("0");
        return;
      }
      this.I = ((int)this.c.getAccountBalance());
      setPayType();
      this.b.setText(ah.Number(Float.parseFloat(new StringBuilder().append(d2).append("").toString())) + "");
      return;
    }
    this.I = 0;
    setPayType();
    this.b.setText(ah.Number(this.c.getShouldPay()) + "");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690105: 
      finish();
      return;
    case 2131693338: 
      int j = this.J;
      paramView = this.E.getmCheck();
      int i = 0;
      while (i < paramView.size())
      {
        if (((Integer)paramView.get(i)).intValue() == 1) {
          j = ((Integer)this.E.getmList().get(i)).intValue();
        }
        i += 1;
      }
      if (j == 0)
      {
        showToast("请选择付款方式");
        return;
      }
      this.J = j;
      f();
      return;
    case 2131693328: 
      onDecrease();
      return;
    case 2131693329: 
      onIncrease();
      return;
    case 2131693323: 
      this.v.setBackgroundColor(Color.parseColor("#f56400"));
      this.w.setBackgroundColor(Color.parseColor("#ffffff"));
      this.t.setTextColor(Color.parseColor("#f56400"));
      this.u.setTextColor(Color.parseColor("#9b9b9b"));
      this.K = 1;
      setImage(this.K);
      return;
    }
    this.v.setBackgroundColor(Color.parseColor("#ffffff"));
    this.w.setBackgroundColor(Color.parseColor("#f56400"));
    this.t.setTextColor(Color.parseColor("#9b9b9b"));
    this.u.setTextColor(Color.parseColor("#f56400"));
    this.K = 0;
    setImage(this.K);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905167);
    this.a = this;
    a();
    this.P = (q.s + e.a.p);
    paramBundle = com.ziroom.ziroomcustomer.e.g.getViewPropertyGoosUrl(this.N, this.O);
    j.getReservationOrderText(this.a, new a(), paramBundle, true, this.P);
    this.L.initWXAPI(this);
    registerReceiver(this.X, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
  }
  
  public void onDecrease()
  {
    double d1 = 500.0D;
    double d2 = getInputAmount();
    this.d.setChecked(false);
    this.I = 0;
    if (d2 - 500.0D > 500.0D) {
      d1 = d2 - 500.0D;
    }
    for (;;)
    {
      this.H = d1;
      if (this.H < this.G)
      {
        this.f.setBackgroundResource(2130838871);
        this.f.setEnabled(true);
      }
      setPayType();
      this.b.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(d1)).toString())) + "");
      return;
      this.g.setBackgroundResource(2130838347);
      this.g.setEnabled(false);
    }
  }
  
  public void onIncrease()
  {
    double d1 = getInputAmount();
    double d2 = e();
    this.d.setChecked(false);
    this.I = 0;
    if (d1 + 0.0D + 500.0D >= d2)
    {
      d1 = d2 - 0.0D;
      this.f.setBackgroundResource(2130838872);
      this.f.setEnabled(false);
    }
    for (;;)
    {
      this.H = (0.0D + d1);
      if (this.H > 500.0D)
      {
        this.g.setBackgroundResource(2130838346);
        this.g.setEnabled(true);
      }
      setPayType();
      this.b.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(d1)).toString())) + "");
      return;
      d1 += 500.0D;
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.J == 0) {}
    while (this.J != 3) {
      return;
    }
    showProgress("");
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (TerminationPayActivity.a(TerminationPayActivity.this) == null) {
          SystemClock.sleep(2000L);
        }
        Handler localHandler = TerminationPayActivity.b(TerminationPayActivity.this);
        if (TerminationPayActivity.a(TerminationPayActivity.this) == null) {}
        for (String str = "";; str = TerminationPayActivity.a(TerminationPayActivity.this).getStand_num())
        {
          com.ziroom.ziroomcustomer.e.d.getNewWYPayState(localHandler, str);
          return;
        }
      }
    }, 5000L);
  }
  
  protected void onResume()
  {
    super.onResume();
    h();
  }
  
  public void onToggleStateChange(boolean paramBoolean)
  {
    if (this.G <= 500.0D) {
      return;
    }
    if (paramBoolean)
    {
      this.g.setVisibility(0);
      this.g.setBackgroundResource(2130838346);
      this.g.setEnabled(true);
      this.f.setVisibility(0);
      this.f.setBackgroundResource(2130838872);
      this.f.setEnabled(false);
      this.H = this.G;
    }
    for (;;)
    {
      this.F = paramBoolean;
      setInputAmount();
      return;
      this.g.setVisibility(8);
      this.f.setVisibility(8);
      this.b.setEnabled(false);
    }
  }
  
  public void onUPPay(PayOrder paramPayOrder)
  {
    if (paramPayOrder == null)
    {
      showToast("获取订单号失败！");
      return;
    }
    c.doStartUnionPayPlugin(this, paramPayOrder.getTrans_id());
    MobclickAgent.onEvent(this, "5ZY_zhifubank");
  }
  
  public void payType()
  {
    this.c.getPayTypeList().remove(new Integer(4));
  }
  
  public List<Integer> setCheck(com.ziroom.ziroomcustomer.termination.a.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < parama.getPayTypeList().size())
    {
      localArrayList.add(Integer.valueOf(0));
      i += 1;
    }
    return localArrayList;
  }
  
  public void setImage(int paramInt)
  {
    if (paramInt == 0)
    {
      onToggleStateChange(true);
      this.b.setText(ah.Number(this.c.getShouldPay()) + "");
      setPayType();
    }
    for (;;)
    {
      this.I = 0;
      this.d.setChecked(false);
      return;
      if (paramInt == 1)
      {
        onToggleStateChange(false);
        this.b.setText(ah.Number(this.c.getShouldPay()) + "");
        setPayType();
      }
    }
  }
  
  public void setInputAmount()
  {
    if (this.F)
    {
      d1 = getInputAmount();
      if (d1 - d1 >= 500.0D)
      {
        this.g.setBackgroundResource(2130838346);
        this.g.setEnabled(true);
      }
      this.b.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(this.H)).toString())) + "");
      return;
    }
    double d1 = e();
    this.b.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(d1)).toString())) + "");
  }
  
  public void setOnClick()
  {
    this.r.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.d.setOnCheckedChangeListener(this);
    this.e.setOnClickListener(this);
  }
  
  public void setPayType()
  {
    this.s.setVisibility(0);
    this.r.setText("去支付");
    this.E.setmCheck(setCheck(this.c));
    this.E.notifyDataSetChanged();
    this.J = 0;
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      int j = 0;
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (TerminationPayActivity.s(TerminationPayActivity.this).equals(paramk.getUrl()))
        {
          paramString = (com.ziroom.ziroomcustomer.termination.a.a)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.a.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        while (!TerminationPayActivity.r(TerminationPayActivity.this).equals(paramk.getUrl())) {
          return;
        }
        PayOrder localPayOrder = new PayOrder();
        Map localMap = (Map)paramString.get("data");
        if (localMap == null)
        {
          paramk.setSuccess(Boolean.valueOf(false));
          paramk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        }
        int i;
        if (localMap.get("package") == null)
        {
          paramString = "";
          localPayOrder.set_package(paramString);
          if (localMap.get("card_values") != null) {
            break label460;
          }
          i = 0;
          label171:
          localPayOrder.setCard_values(i);
          if (localMap.get("current_money") != null) {
            break label502;
          }
          i = j;
          label192:
          localPayOrder.setCurrent_money(i);
          if (localMap.get("merorder_id") != null) {
            break label521;
          }
          paramString = "";
          label213:
          localPayOrder.setMerorder_id(paramString);
          if (localMap.get("sign") != null) {
            break label537;
          }
          paramString = "";
          label234:
          localPayOrder.setSign(paramString);
          if (localMap.get("timestamp") != null) {
            break label553;
          }
          paramString = "";
          label255:
          localPayOrder.setTimestamp(paramString);
          if (localMap.get("trans_id") != null) {
            break label569;
          }
          paramString = "";
          label276:
          localPayOrder.setTrans_id(paramString);
          if (localMap.get("url") != null) {
            break label585;
          }
          paramString = "";
          label297:
          localPayOrder.setUrl(paramString);
          if (localMap.get("stand_num") != null) {
            break label601;
          }
          paramString = "";
          label318:
          localPayOrder.setStand_num(paramString);
          if (localMap.get("partnerid") != null) {
            break label617;
          }
          paramString = "";
          label339:
          localPayOrder.setPartnerid(paramString);
          if (localMap.get("orderCode") != null) {
            break label633;
          }
          paramString = "";
          label360:
          localPayOrder.setOrderCode(paramString);
          if (localMap.get("resp_desc") != null) {
            break label649;
          }
          paramString = "";
          label381:
          localPayOrder.setResp_desc(paramString);
          if (localMap.get("resp_code") != null) {
            break label665;
          }
          paramString = "";
          label402:
          localPayOrder.setResp_code(paramString);
          if (localMap.get("bizCode") != null) {
            break label681;
          }
        }
        label460:
        label502:
        label521:
        label537:
        label553:
        label569:
        label585:
        label601:
        label617:
        label633:
        label649:
        label665:
        label681:
        for (paramString = "";; paramString = localMap.get("bizCode").toString())
        {
          localPayOrder.setBizCode(paramString);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(localPayOrder);
          return;
          paramString = localMap.get("package").toString();
          break;
          if (ae.isNull(localMap.get("card_values").toString()))
          {
            i = 0;
            break label171;
          }
          i = Integer.parseInt(localMap.get("card_values").toString());
          break label171;
          i = Integer.parseInt(localMap.get("current_money").toString());
          break label192;
          paramString = localMap.get("merorder_id").toString();
          break label213;
          paramString = localMap.get("sign").toString();
          break label234;
          paramString = localMap.get("timestamp").toString();
          break label255;
          paramString = localMap.get("trans_id").toString();
          break label276;
          paramString = localMap.get("url").toString();
          break label297;
          paramString = localMap.get("stand_num").toString();
          break label318;
          paramString = localMap.get("partnerid").toString();
          break label339;
          paramString = localMap.get("orderCode").toString();
          break label360;
          paramString = localMap.get("resp_desc").toString();
          break label381;
          paramString = localMap.get("resp_code").toString();
          break label402;
        }
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (TerminationPayActivity.l(TerminationPayActivity.this) == 8)
        {
          TerminationPayActivity.a(TerminationPayActivity.this, (PayOrder)paramk.getObject());
          if (TerminationPayActivity.a(TerminationPayActivity.this).getResp_code().equals("201000"))
          {
            com.freelxl.baselibrary.f.g.textToast(TerminationPayActivity.this, TerminationPayActivity.a(TerminationPayActivity.this).getResp_desc());
            TerminationPayActivity.f(TerminationPayActivity.this);
            return;
          }
          if (TerminationPayActivity.a(TerminationPayActivity.this).getResp_code().equals("201002"))
          {
            TerminationPayActivity.this.showProgress("");
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                com.ziroom.ziroomcustomer.e.d.getWYPayState(TerminationPayActivity.b(TerminationPayActivity.this), TerminationPayActivity.a(TerminationPayActivity.this).getOrderCode());
              }
            }, 7000L);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(TerminationPayActivity.this, TerminationPayActivity.a(TerminationPayActivity.this).getResp_desc());
          return;
        }
        if (TerminationPayActivity.s(TerminationPayActivity.this).equals(paramk.getUrl()))
        {
          TerminationPayActivity.a(TerminationPayActivity.this, (com.ziroom.ziroomcustomer.termination.a.a)paramk.getObject());
          TerminationPayActivity.t(TerminationPayActivity.this);
          TerminationPayActivity.this.setOnClick();
        }
      }
      for (;;)
      {
        TerminationPayActivity.this.dismissProgress();
        return;
        if (TerminationPayActivity.r(TerminationPayActivity.this).equals(paramk.getUrl()))
        {
          TerminationPayActivity.a(TerminationPayActivity.this, (PayOrder)paramk.getObject());
          if (TerminationPayActivity.l(TerminationPayActivity.this) == 1)
          {
            TerminationPayActivity.this.onUPPay(TerminationPayActivity.a(TerminationPayActivity.this));
          }
          else if (TerminationPayActivity.l(TerminationPayActivity.this) == 2)
          {
            TerminationPayActivity.b(TerminationPayActivity.this, TerminationPayActivity.a(TerminationPayActivity.this));
          }
          else if (TerminationPayActivity.l(TerminationPayActivity.this) == 3)
          {
            TerminationPayActivity.c(TerminationPayActivity.this, TerminationPayActivity.a(TerminationPayActivity.this));
          }
          else if (TerminationPayActivity.l(TerminationPayActivity.this) == 4)
          {
            TerminationPayActivity.f(TerminationPayActivity.this);
          }
          else if (TerminationPayActivity.l(TerminationPayActivity.this) == 6)
          {
            TerminationPayActivity.this.onUPPay(TerminationPayActivity.a(TerminationPayActivity.this));
            continue;
            paramk = paramk.getMessage();
            TerminationPayActivity.this.showToast(paramk);
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/TerminationPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */