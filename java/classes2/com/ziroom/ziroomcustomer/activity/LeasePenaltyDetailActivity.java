package com.ziroom.ziroomcustomer.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import com.ziroom.ziroomcustomer.model.PayOrder;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyStewardListActivity;
import com.ziroom.ziroomcustomer.pay.huifu.activity.AddBandCardActivity;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean.HfInfoBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBackMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage.DataBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeasePenaltyDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static LeasePenaltyDetailActivity a = null;
  private String A;
  private String B = "";
  private double C = 0.0D;
  private c D;
  private String E;
  private PayOrder F;
  private List<String> G;
  private HashMap<String, String> H;
  private Boolean I = Boolean.valueOf(false);
  private HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean J;
  private com.ziroom.commonlibrary.e.d K = new com.ziroom.commonlibrary.e.d();
  private String L;
  private String M;
  private String N;
  private View O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private TextView S;
  private Dialog T;
  private Handler U = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {}
      label335:
      do
      {
        do
        {
          return;
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          case 4105: 
            LeasePenaltyDetailActivity.this.dismissProgress();
            paramAnonymousMessage = (l)paramAnonymousMessage.obj;
            if (!paramAnonymousMessage.getSuccess().booleanValue()) {
              break label410;
            }
            LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this, (PayOrder)paramAnonymousMessage.getObject());
            if (!LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this).equals("hf_make_order")) {
              break label335;
            }
            if (!LeasePenaltyDetailActivity.h(LeasePenaltyDetailActivity.this).getResp_code().equals("201000")) {
              break;
            }
            g.textToast(LeasePenaltyDetailActivity.this, LeasePenaltyDetailActivity.h(LeasePenaltyDetailActivity.this).getResp_desc());
            LeasePenaltyDetailActivity.g(LeasePenaltyDetailActivity.this);
            return;
          case 8947848: 
            paramAnonymousMessage = (HuifuBackMessage)paramAnonymousMessage.obj;
          }
        } while (paramAnonymousMessage == null);
        LeasePenaltyDetailActivity.b(LeasePenaltyDetailActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_id);
        LeasePenaltyDetailActivity.c(LeasePenaltyDetailActivity.this, paramAnonymousMessage.mMessageCode);
        LeasePenaltyDetailActivity.d(LeasePenaltyDetailActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_date);
        LeasePenaltyDetailActivity.this.onConfirm();
        return;
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue()) {
          LeasePenaltyDetailActivity.g(LeasePenaltyDetailActivity.this);
        }
        for (;;)
        {
          LeasePenaltyDetailActivity.this.dismissProgress();
          return;
          LeasePenaltyDetailActivity.this.showToast(paramAnonymousMessage.getMessage());
        }
        if (LeasePenaltyDetailActivity.h(LeasePenaltyDetailActivity.this).getResp_code().equals("201002"))
        {
          LeasePenaltyDetailActivity.this.showProgress("");
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              com.ziroom.ziroomcustomer.e.d.getWYPayState(LeasePenaltyDetailActivity.i(LeasePenaltyDetailActivity.this), LeasePenaltyDetailActivity.h(LeasePenaltyDetailActivity.this).getOrderCode());
            }
          }, 7000L);
          return;
        }
        g.textToast(LeasePenaltyDetailActivity.this, LeasePenaltyDetailActivity.h(LeasePenaltyDetailActivity.this).getResp_desc());
        return;
        if ((LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this).equals("yl_make_order")) || (LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this).equals("yl_cashCard_make_order")))
        {
          LeasePenaltyDetailActivity.this.onUPPay(LeasePenaltyDetailActivity.h(LeasePenaltyDetailActivity.this));
          return;
        }
      } while (!LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this).equals("wxpay_make_order_v2"));
      LeasePenaltyDetailActivity.b(LeasePenaltyDetailActivity.this, LeasePenaltyDetailActivity.h(LeasePenaltyDetailActivity.this));
      return;
      label410:
      LeasePenaltyDetailActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  private BroadcastReceiver V = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      LeasePenaltyDetailActivity.g(LeasePenaltyDetailActivity.this);
    }
  };
  private Context b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private ImageView t;
  private Button u;
  private Button v;
  private Button w;
  private ListViewForScrollView x;
  private LeaseInfo y;
  private LeasePayPlan z;
  
  private void a()
  {
    this.y = ((LeaseInfo)getIntent().getSerializableExtra("Lease"));
    this.z = ((LeasePayPlan)getIntent().getSerializableExtra("LeasePayPlan"));
    this.e = ((TextView)findViewById(2131696644));
    this.r = ((TextView)findViewById(2131691525));
    this.d = ((TextView)findViewById(2131696624));
    this.g = ((TextView)findViewById(2131696643));
    this.f = ((TextView)findViewById(2131692850));
    this.c = ((TextView)findViewById(2131695164));
    this.w = ((Button)findViewById(2131693338));
    this.x = ((ListViewForScrollView)findViewById(2131693337));
    this.s = ((TextView)findViewById(2131693269));
    this.u = ((Button)findViewById(2131691363));
    this.v = ((Button)findViewById(2131696645));
    this.D = new c(this.G, this.b, setCheck(this.G.size()));
    this.x.setAdapter(this.D);
    this.D.setmPayType(new c.a()
    {
      public void setPayType(String paramAnonymousString)
      {
        LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this, paramAnonymousString);
        if ((LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this).equals("hf_make_order")) && (!LeasePenaltyDetailActivity.b(LeasePenaltyDetailActivity.this).booleanValue()))
        {
          LeasePenaltyDetailActivity.c(LeasePenaltyDetailActivity.this).setText("去绑卡");
          return;
        }
        LeasePenaltyDetailActivity.c(LeasePenaltyDetailActivity.this).setText("去支付");
      }
    });
    this.s.setFocusable(true);
    this.t = ((ImageView)findViewById(2131689492));
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.s.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.s.setEnabled(false);
    LeaseInfo localLeaseInfo = (LeaseInfo)getIntent().getSerializableExtra("Lease");
    if (this.z != null)
    {
      this.c.setText(this.z.getContractCode() + "");
      if (localLeaseInfo != null) {
        this.f.setText(localLeaseInfo.getAddress());
      }
      this.g.setText(this.z.getContractWyjPayInfo().getPenaltyNum() + "天");
      this.r.setText(this.z.getContractWyjPayInfo().getReceivableMoney() + "元");
      this.u.setVisibility(0);
      this.v.setVisibility(0);
      this.C = this.z.getContractWyjPayInfo().getReceivableMoney();
      this.s.setText(this.z.getContractWyjPayInfo().getReceivableMoney() + "");
    }
    this.d.setText(this.d.getText().toString() + "联系管家");
    a(this.d, this.d.length() - 4, 4);
  }
  
  private void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramTextView.getText().toString());
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#55AADD")), paramInt1, paramInt1 + paramInt2, 33);
    paramTextView.setText(localSpannableStringBuilder);
  }
  
  private void a(PayOrder paramPayOrder)
  {
    this.K.doStartWXPay(this, paramPayOrder.getTrans_id(), paramPayOrder.getMerorder_id(), paramPayOrder.getTimestamp(), paramPayOrder.get_package(), paramPayOrder.getSign(), paramPayOrder.getPartnerid());
  }
  
  private void b()
  {
    this.H = new HashMap();
    this.H.put("yl_make_order", "支付服务有银联提供（不支持交通、招商）");
    this.H.put("wxpay_make_order_v2", "推荐已安装微信客户端的用户使用");
    this.H.put("jd_m_pay", "支付服务由京东提供");
    this.H.put("yl_cashCard_make_order", "支付服务有银联提供");
    if (this.I.booleanValue()) {
      this.H.put("hf_make_order", this.J.bankName + "(" + this.J.bankNo + ")");
    }
    for (;;)
    {
      if (this.D != null)
      {
        this.D.setmListMsg(this.H);
        if (this.I.booleanValue()) {
          this.D.setmImgHuifuIcon(this.J.bankIconApp);
        }
      }
      if (this.w != null) {
        break;
      }
      return;
      this.H.put("hf_make_order", "一次性完成绑卡，更便捷支付体验");
    }
    if ((this.B.equals("hf_make_order")) && (!this.I.booleanValue()))
    {
      this.w.setText("去绑卡");
      return;
    }
    this.w.setText("去支付");
  }
  
  private void e()
  {
    if ((this.z == null) || (this.G == null) || (!this.G.contains("hf_make_order"))) {
      return;
    }
    com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuPayTypeList(this, this.z.getCityCode(), "penaltyPay", this.z.getContractCode(), "", "", new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        com.freelxl.baselibrary.f.d.e("yangxj--------", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {}
        do
        {
          do
          {
            return;
            paramAnonymousk = (HuiFuIsBandAndBandList)paramAnonymousk.getObject();
          } while (paramAnonymousk == null);
          if (!paramAnonymousk.isSuccess())
          {
            g.textToast(LeasePenaltyDetailActivity.this, paramAnonymousk.getError_message());
            return;
          }
        } while ((paramAnonymousk.data == null) || (paramAnonymousk.data.hfInfo == null));
        LeasePenaltyDetailActivity localLeasePenaltyDetailActivity = LeasePenaltyDetailActivity.this;
        if (paramAnonymousk.data.hfInfo.isBind != 0) {}
        for (boolean bool = true;; bool = false)
        {
          LeasePenaltyDetailActivity.a(localLeasePenaltyDetailActivity, Boolean.valueOf(bool));
          if (LeasePenaltyDetailActivity.b(LeasePenaltyDetailActivity.this).booleanValue()) {
            LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this, (HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)paramAnonymousk.data.hfInfo.bindBanks.get(0));
          }
          LeasePenaltyDetailActivity.d(LeasePenaltyDetailActivity.this);
          return;
        }
      }
    });
  }
  
  private void f()
  {
    Object localObject2 = this.E;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.z.getContractCode();
    }
    if ((this.B.equals("hf_make_order")) && (!this.I.booleanValue()))
    {
      localObject2 = new Intent(this, AddBandCardActivity.class);
      u.e("yangxj--", (String)localObject1);
      ((Intent)localObject2).putExtra("contractCode", (String)localObject1);
      ((Intent)localObject2).putExtra("reserveCode", "");
      ((Intent)localObject2).putExtra("backRentOrderCode", "");
      ((Intent)localObject2).putExtra("bizType", "penaltyPay");
      startActivity((Intent)localObject2);
      return;
    }
    showProgress("");
    if (this.y != null)
    {
      if (ae.isNull(this.y.getSysContractId())) {
        showToast("合同ID为空");
      }
    }
    else
    {
      showToast("合同ID为空");
      return;
    }
    if (ae.isNull(this.s.getText().toString()))
    {
      showToast("金额为空");
      return;
    }
    com.ziroom.ziroomcustomer.pay.common.b.a.getIsCanPayResult(this, 3, (String)localObject1, 0, (int)ah.Number2(this.C * 100.0D), (int)(Double.parseDouble(this.s.getText().toString()) * 100.0D), this.B, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        LeasePenaltyDetailActivity.this.dismissProgress();
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          LeasePenaltyDetailActivity.e(LeasePenaltyDetailActivity.this);
          return;
        }
        g.textToast(LeasePenaltyDetailActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  private void g()
  {
    if (this.B.equals("hf_make_order"))
    {
      String str2 = this.E;
      String str1 = str2;
      if (str2 == null) {
        str1 = this.z.getContractCode();
      }
      if (this.I.booleanValue()) {
        new com.ziroom.ziroomcustomer.pay.huifu.a.a(this, this.U, null, 201, str1, "", "", "penaltyPay", "确定", "取消", "付款确认").showMessageDialog();
      }
      return;
    }
    onConfirm();
  }
  
  private void h()
  {
    setResult(66, getIntent());
    finish();
  }
  
  public double getInputAmount()
  {
    String str = this.s.getText().toString();
    if (ae.notNull(str)) {}
    for (double d1 = ah.Number2(Double.parseDouble(str));; d1 = 0.0D) {
      return ah.Number2(d1);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.ziroom.commonlibrary.e.c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new com.ziroom.commonlibrary.e.c.a()
    {
      public void doBack()
      {
        LeasePenaltyDetailActivity.g(LeasePenaltyDetailActivity.this);
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131696644: 
      showDialog();
      return;
    case 2131697638: 
      this.T.dismiss();
      return;
    case 2131696624: 
      j.getContactHousekeeper(this.b, new a(), this.z.getContractCode(), true);
      return;
    }
    if (ae.isNull(this.B))
    {
      g.textToast(this.b, "请选择支付方式", 0);
      return;
    }
    f();
  }
  
  public void onConfirm()
  {
    if (this.y != null)
    {
      if (ae.isNull(this.y.getSysContractId())) {
        showToast("合同ID为空");
      }
    }
    else
    {
      showToast("合同ID为空");
      return;
    }
    if (ae.isNull(this.s.getText().toString()))
    {
      showToast("金额为空");
      return;
    }
    showProgress("正在请求订单号,请稍候...");
    String str = ah.Number2(this.C) + "";
    com.ziroom.ziroomcustomer.e.d.penaltyPay(this.U, this.z.getContractWyjPayInfo().getSysContractId() + "", this.z.getContractWyjPayInfo().getSysPenaltyId() + "", str, this.z.getPeriods() + "", this.B, this.L, this.M, this.N);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904836);
    this.b = this;
    a = this;
    paramBundle = ((ApplicationEx)getApplication()).getUser();
    if (paramBundle != null) {
      this.A = paramBundle.getUid();
    }
    this.E = getIntent().getStringExtra("contract_code");
    this.G = getIntent().getStringArrayListExtra("WyjPayTypeList");
    e();
    b();
    a();
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    this.K.initWXAPI(this);
    registerReceiver(this.V, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.V);
  }
  
  protected void onResume()
  {
    super.onResume();
    e();
  }
  
  public void onUPPay(PayOrder paramPayOrder)
  {
    if (paramPayOrder == null)
    {
      showToast("获取订单号失败！");
      return;
    }
    com.ziroom.commonlibrary.e.c.doStartUnionPayPlugin(this, paramPayOrder.getTrans_id());
  }
  
  public List<Integer> setCheck(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(Integer.valueOf(0));
      i += 1;
    }
    return localArrayList;
  }
  
  public void showDialog()
  {
    this.O = View.inflate(this.b, 2130905165, null);
    this.P = ((TextView)this.O.findViewById(2131697639));
    this.S = ((TextView)this.O.findViewById(2131697638));
    this.R = ((TextView)this.O.findViewById(2131697637));
    this.Q = ((TextView)this.O.findViewById(2131697634));
    this.P.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.Q.setVisibility(0);
    this.P.setVisibility(0);
    this.S.setVisibility(0);
    this.R.setGravity(17);
    this.Q.setText("违约金收取规则");
    this.R.setText("未按约定时间支付租金的，每逾期一日，应按照当期应付金额的千分之五/日的标准支付逾期违约金；违约金金额存在小数的，四舍五入，取到整数元。");
    this.P.setText("我知道了");
    this.P.setVisibility(8);
    this.S.setText("知道了");
    Dialog localDialog;
    if (this.T == null)
    {
      this.T = new Dialog(this.b, 2131427781);
      this.T.setContentView(this.O);
      this.T.setCanceledOnTouchOutside(false);
      this.T.setCancelable(false);
      localDialog = this.T;
      if ((localDialog instanceof Dialog)) {
        break label269;
      }
      localDialog.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.T.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this, null);
          LeasePenaltyDetailActivity.f(LeasePenaltyDetailActivity.this).dismiss();
          LeasePenaltyDetailActivity.a(LeasePenaltyDetailActivity.this, null);
        }
      });
      return;
      label269:
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        paramString = com.alibaba.fastjson.a.parseObject(paramString.get("data").toString());
        paramk.setObject(new b(paramString.getString("hire_contract_code"), paramString.getString("hire_commissioner_name"), paramString.getString("hire_commissioner_phone")));
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (ae.notNull(((b)paramk.getObject()).getHire_commissioner_phone()))
        {
          paramk = new Intent(LeasePenaltyDetailActivity.this, MyStewardListActivity.class);
          LeasePenaltyDetailActivity.this.startActivity(paramk);
        }
        return;
      }
      paramk = paramk.getMessage();
      LeasePenaltyDetailActivity.this.showToast(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeasePenaltyDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */