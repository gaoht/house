package com.ziroom.ziroomcustomer.reserve;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.c;
import com.ziroom.commonlibrary.e.c.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.m;
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
import com.ziroom.ziroomcustomer.signed.PaySuccessActivity;
import com.ziroom.ziroomcustomer.signed.SignedJDPayWebActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationPayActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private com.ziroom.commonlibrary.e.d A = new com.ziroom.commonlibrary.e.d();
  private int B;
  private ImageView C;
  private CheckBox D;
  private LinearLayout E;
  private List<Integer> F;
  private Boolean G = Boolean.valueOf(false);
  private HashMap<Integer, String> H;
  private HuiFuIsBandAndBandList I;
  private String J;
  private String K;
  private String L;
  private BroadcastReceiver M = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      ReservationPayActivity.e(ReservationPayActivity.this);
    }
  };
  private View N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private Dialog S;
  private Handler T = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {}
      do
      {
        return;
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        case 69682: 
          ReservationPayActivity.this.dismissProgress();
          paramAnonymousMessage = (l)paramAnonymousMessage.obj;
          if (!paramAnonymousMessage.getSuccess().booleanValue()) {
            break;
          }
          ReservationPayActivity.e(ReservationPayActivity.this);
          return;
        case 8947848: 
          paramAnonymousMessage = (HuifuBackMessage)paramAnonymousMessage.obj;
        }
      } while (paramAnonymousMessage == null);
      ReservationPayActivity.a(ReservationPayActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_id);
      ReservationPayActivity.b(ReservationPayActivity.this, paramAnonymousMessage.mMessageCode);
      ReservationPayActivity.c(ReservationPayActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_date);
      ReservationPayActivity.d(ReservationPayActivity.this, q.s + e.m.h);
      paramAnonymousMessage = com.ziroom.ziroomcustomer.e.g.buildreservePay(ReservationPayActivity.n(ReservationPayActivity.this), ReservationPayActivity.f(ReservationPayActivity.this), (int)(ReservationPayActivity.h(ReservationPayActivity.this).getDeposit() * 100.0F), "1", ah.getMac(ReservationPayActivity.o(ReservationPayActivity.this)), ah.getDeviceId(ReservationPayActivity.o(ReservationPayActivity.this)), ReservationPayActivity.p(ReservationPayActivity.this), ReservationPayActivity.q(ReservationPayActivity.this), ReservationPayActivity.r(ReservationPayActivity.this));
      j.getReservationOrderText(ReservationPayActivity.o(ReservationPayActivity.this), new ReservationPayActivity.a(ReservationPayActivity.this), paramAnonymousMessage, true, ReservationPayActivity.i(ReservationPayActivity.this));
      return;
      paramAnonymousMessage = Toast.makeText(ReservationPayActivity.o(ReservationPayActivity.this), paramAnonymousMessage.getMessage(), 0);
      if (!(paramAnonymousMessage instanceof Toast))
      {
        paramAnonymousMessage.show();
        return;
      }
      VdsAgent.showToast((Toast)paramAnonymousMessage);
    }
  };
  private ListViewForScrollView a;
  private String b;
  private String c;
  private String d;
  private String e;
  private Context f;
  private e g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private Button w;
  private Button x;
  private a y;
  private PayOrder z;
  
  private void a()
  {
    int i = 0;
    this.H = new HashMap();
    this.H.put(Integer.valueOf(1), "支付服务有银联提供（不支持交通、招商）");
    this.H.put(Integer.valueOf(2), "推荐已安装微信客户端的用户使用");
    this.H.put(Integer.valueOf(3), "支付服务由京东提供");
    this.H.put(Integer.valueOf(6), "支付服务有银联提供");
    if (this.G.booleanValue())
    {
      localObject = (HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)this.I.data.hfInfo.bindBanks.get(0);
      this.H.put(Integer.valueOf(7), ((HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)localObject).bankName + "(" + ((HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)localObject).bankNo + ")");
      if (this.y != null) {
        this.y.setmImgHuifuIcon(((HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)localObject).bankIconApp);
      }
    }
    for (;;)
    {
      if (this.y != null) {
        this.y.setmListMsg(this.H);
      }
      if ((this.w != null) && (this.y != null) && (this.y.getmCheck() != null) && (this.y.getmList() != null)) {
        break;
      }
      return;
      this.H.put(Integer.valueOf(7), "一次性完成绑卡，更便捷支付体验");
    }
    Object localObject = this.y.getmCheck();
    int j = 0;
    while (i < ((List)localObject).size())
    {
      if (((Integer)((List)localObject).get(i)).intValue() == 1) {
        j = ((Integer)this.y.getmList().get(i)).intValue();
      }
      i += 1;
    }
    if ((!this.G.booleanValue()) && (j == 7))
    {
      this.w.setText("去绑卡");
      return;
    }
    this.w.setText("去支付");
  }
  
  private void a(PayOrder paramPayOrder)
  {
    this.A.doStartWXPay(this, paramPayOrder.getTrans_id(), paramPayOrder.getMerorder_id(), paramPayOrder.getTimestamp(), paramPayOrder.get_package(), paramPayOrder.getSign(), paramPayOrder.getPartnerid());
  }
  
  private void b()
  {
    if ((this.F == null) || (!this.F.contains(Integer.valueOf(7)))) {
      return;
    }
    com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuPayTypeList(this, "companyCode", "reserve", "", this.b, "", new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        com.freelxl.baselibrary.f.d.e("yangxj--------", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue())
        {
          ReservationPayActivity.c(ReservationPayActivity.this);
          return;
        }
        ReservationPayActivity.a(ReservationPayActivity.this, (HuiFuIsBandAndBandList)paramAnonymousk.getObject());
        if (ReservationPayActivity.d(ReservationPayActivity.this) == null)
        {
          ReservationPayActivity.c(ReservationPayActivity.this);
          return;
        }
        if (!ReservationPayActivity.d(ReservationPayActivity.this).isSuccess())
        {
          ReservationPayActivity.c(ReservationPayActivity.this);
          com.freelxl.baselibrary.f.g.textToast(ReservationPayActivity.this, ReservationPayActivity.d(ReservationPayActivity.this).getError_message());
          return;
        }
        paramAnonymousk = ReservationPayActivity.this;
        if (ReservationPayActivity.d(ReservationPayActivity.this).data.hfInfo.isBind != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ReservationPayActivity.a(paramAnonymousk, Boolean.valueOf(bool));
          ReservationPayActivity.c(ReservationPayActivity.this);
          return;
        }
      }
    });
  }
  
  private void b(PayOrder paramPayOrder)
  {
    Intent localIntent = new Intent(this.f, SignedJDPayWebActivity.class);
    localIntent.putExtra("url", paramPayOrder.getUrl());
    if (this.B == 3) {
      localIntent.putExtra("title", "京东支付");
    }
    startActivity(localIntent);
  }
  
  public static String changeF2Y(String paramString)
  {
    if (!paramString.matches("\\-?[0-9]+")) {
      try
      {
        throw new Exception("金额格式有误");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return BigDecimal.valueOf(Long.valueOf(paramString).longValue()).divide(new BigDecimal(100)).toString();
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this.f, PaySuccessActivity.class);
    localIntent.putExtra("sub_amount", this.g.getDeposit() + "");
    localIntent.putExtra("reserve", "reserve");
    localIntent.putExtra("is_blank", "0");
    startActivity(localIntent);
  }
  
  private void f()
  {
    if ((this.B == 7) && (!this.G.booleanValue()))
    {
      Intent localIntent = new Intent(this, AddBandCardActivity.class);
      localIntent.putExtra("contractCode", "");
      localIntent.putExtra("reserveCode", this.b);
      localIntent.putExtra("backRentOrderCode", "");
      localIntent.putExtra("bizType", "reserve");
      startActivity(localIntent);
      return;
    }
    showProgress("");
    if ((this.D.isChecked()) && (this.g.getDeposit() * 100.0F <= this.g.getAccountBalance())) {}
    for (int i = 0;; i = (int)(this.g.getDeposit() * 100.0F))
    {
      int j = (int)(Double.parseDouble(this.v.getText().toString()) * 100.0D);
      com.ziroom.ziroomcustomer.pay.common.b.a.getIsCanPayResult(this, 5, this.b, 0, i, j, this.B + "", new i.a()
      {
        public void onParse(String paramAnonymousString, k paramAnonymousk) {}
        
        public void onSuccess(k paramAnonymousk)
        {
          ReservationPayActivity.this.dismissProgress();
          if (paramAnonymousk.getSuccess().booleanValue())
          {
            ReservationPayActivity.l(ReservationPayActivity.this);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(ReservationPayActivity.this, paramAnonymousk.getMessage());
        }
      });
      return;
    }
  }
  
  private void g()
  {
    if (this.B == 7)
    {
      if (this.G.booleanValue()) {
        new com.ziroom.ziroomcustomer.pay.huifu.a.a(this, this.T, null, 201, "", this.b, "", "reserve").showMessageDialog();
      }
      return;
    }
    this.e = (q.s + e.m.h);
    Map localMap = com.ziroom.ziroomcustomer.e.g.buildreservePay(this.b, this.B, (int)(this.g.getDeposit() * 100.0F), "1", ah.getMac(this.f), ah.getDeviceId(this.f), this.J, this.K, this.L);
    j.getReservationOrderText(this.f, new a(), localMap, true, this.e);
  }
  
  public void initView()
  {
    this.x = ((Button)findViewById(2131697424));
    this.E = ((LinearLayout)findViewById(2131693336));
    this.D = ((CheckBox)findViewById(2131693315));
    this.C = ((ImageView)findViewById(2131690105));
    this.w = ((Button)findViewById(2131693338));
    this.v = ((TextView)findViewById(2131693269));
    this.u = ((TextView)findViewById(2131693316));
    this.r = ((TextView)findViewById(2131697422));
    this.t = ((TextView)findViewById(2131693309));
    this.s = ((TextView)findViewById(2131692992));
    this.a = ((ListViewForScrollView)findViewById(2131697423));
    this.w.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.D.setEnabled(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new c.a()
    {
      public void doBack()
      {
        ReservationPayActivity.e(ReservationPayActivity.this);
      }
    });
  }
  
  public void onBackPressed()
  {
    if (ae.notNull(this.c))
    {
      showDialog();
      return;
    }
    finish();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693338: 
      paramView = this.y.getmCheck();
      int i = 0;
      int j = 0;
      while (i < paramView.size())
      {
        if (((Integer)paramView.get(i)).intValue() == 1) {
          j = ((Integer)this.y.getmList().get(i)).intValue();
        }
        i += 1;
      }
      if (j == 0)
      {
        showToast("请选择付款方式");
        return;
      }
      this.B = j;
      f();
      return;
    case 2131690105: 
      if (ae.notNull(this.c))
      {
        showDialog();
        return;
      }
      finish();
      return;
    case 2131693315: 
      if (this.D.isChecked())
      {
        u.e("check", "true");
        if (this.g.getDeposit() * 100.0F > this.g.getAccountBalance())
        {
          this.D.setChecked(false);
          showToast("账户余额小于需要支付金额，不可以使用账户余额。");
          return;
        }
        this.E.setVisibility(8);
        this.x.setVisibility(0);
        return;
      }
      this.E.setVisibility(0);
      this.x.setVisibility(8);
      u.e("check", "false");
      return;
    case 2131697424: 
      this.B = 4;
      this.e = (q.s + e.m.h);
      paramView = com.ziroom.ziroomcustomer.e.g.buildreservePay(this.b, this.B, (int)(this.g.getDeposit() * 100.0F), "1", ah.getMac(this.f), ah.getDeviceId(this.f), this.J, this.K, this.L);
      j.getReservationOrderText(this.f, new a(), paramView, true, this.e);
      return;
    case 2131697639: 
      paramView = new Intent(this, MainActivity.class);
      paramView.putExtra("FRAGMENT_TYPE", 7);
      startActivity(paramView);
      ApplicationEx.c.finishAllActivity();
      return;
    }
    this.S.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905097);
    this.f = this;
    this.b = getIntent().getStringExtra("reserveCode");
    this.c = getIntent().getStringExtra("is_reserve");
    initView();
    this.d = (q.s + e.m.g);
    paramBundle = com.ziroom.ziroomcustomer.e.g.buildGetreservePayData(this.b);
    j.getReservationOrderText(this.f, new a(), paramBundle, false, this.d);
    this.A.initWXAPI(this);
    registerReceiver(this.M, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.M);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.B == 0) {}
    while (this.B != 3) {
      return;
    }
    showProgress("");
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (ReservationPayActivity.a(ReservationPayActivity.this) == null) {
          SystemClock.sleep(2000L);
        }
        Handler localHandler = ReservationPayActivity.b(ReservationPayActivity.this);
        if (ReservationPayActivity.a(ReservationPayActivity.this) == null) {}
        for (String str = "";; str = ReservationPayActivity.a(ReservationPayActivity.this).getStand_num())
        {
          com.ziroom.ziroomcustomer.e.d.getWYPayState(localHandler, str);
          return;
        }
      }
    }, 5000L);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
  
  public void onUPPay(PayOrder paramPayOrder)
  {
    if (paramPayOrder == null)
    {
      showToast("获取订单号失败！");
      return;
    }
    c.doStartUnionPayPlugin(this, paramPayOrder.getTrans_id());
  }
  
  public List<Integer> setCheck(e parame)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < parame.getPayTypeList().size())
    {
      localArrayList.add(Integer.valueOf(0));
      i += 1;
    }
    return localArrayList;
  }
  
  public void setText(e parame)
  {
    this.F = new ArrayList();
    int i = 0;
    while (i < parame.getPayTypeList().size())
    {
      if (((Integer)parame.getPayTypeList().get(i)).intValue() != 4) {
        this.F.add(parame.getPayTypeList().get(i));
      }
      i += 1;
    }
    this.v.setText(parame.getDeposit() + "");
    this.u.setText(changeF2Y(parame.getAccountBalance() + ""));
    this.r.setText(parame.getLastPageTime());
    this.t.setText(parame.getHouseAddress());
    this.s.setText(parame.getReserveCode());
    this.y = new a(this.F, this.f, setCheck(parame));
    this.a.setAdapter(this.y);
    this.y.setmPayType(new a.a()
    {
      public void setPayType(int paramAnonymousInt)
      {
        if ((!ReservationPayActivity.j(ReservationPayActivity.this).booleanValue()) && (paramAnonymousInt == 7))
        {
          ReservationPayActivity.k(ReservationPayActivity.this).setText("去绑卡");
          return;
        }
        ReservationPayActivity.k(ReservationPayActivity.this).setText("去支付");
      }
    });
    this.D.setEnabled(true);
    b();
  }
  
  public void showDialog()
  {
    this.N = View.inflate(this.f, 2130905165, null);
    this.O = ((TextView)this.N.findViewById(2131697639));
    this.R = ((TextView)this.N.findViewById(2131697638));
    this.Q = ((TextView)this.N.findViewById(2131697637));
    this.P = ((TextView)this.N.findViewById(2131697634));
    this.O.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.P.setText("提示");
    this.O.setVisibility(0);
    this.R.setVisibility(0);
    this.Q.setGravity(17);
    this.Q.setText("倒计时结束之前，您可以在“我的订单”里找到待支付的长租预订单进行支付。");
    this.O.setText("我知道了");
    this.R.setText("取消");
    Dialog localDialog;
    if (this.S == null)
    {
      this.S = new Dialog(this.f, 2131427781);
      this.S.setContentView(this.N);
      this.S.setCanceledOnTouchOutside(false);
      this.S.setCancelable(false);
      localDialog = this.S;
      if ((localDialog instanceof Dialog)) {
        break label252;
      }
      localDialog.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.S.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          ReservationPayActivity.a(ReservationPayActivity.this, null);
          ReservationPayActivity.m(ReservationPayActivity.this).dismiss();
          ReservationPayActivity.a(ReservationPayActivity.this, null);
        }
      });
      return;
      label252:
      VdsAgent.showDialog((Dialog)localDialog);
    }
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
        if (ReservationPayActivity.g(ReservationPayActivity.this).equals(paramk.getUrl()))
        {
          paramString = (e)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), e.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        while (!ReservationPayActivity.i(ReservationPayActivity.this).equals(paramk.getUrl())) {
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
        if (ReservationPayActivity.f(ReservationPayActivity.this) == 7)
        {
          ReservationPayActivity.a(ReservationPayActivity.this, (PayOrder)paramk.getObject());
          if (ReservationPayActivity.a(ReservationPayActivity.this).getResp_code().equals("201000"))
          {
            com.freelxl.baselibrary.f.g.textToast(ReservationPayActivity.this, ReservationPayActivity.a(ReservationPayActivity.this).getResp_desc());
            ReservationPayActivity.e(ReservationPayActivity.this);
            return;
          }
          if (ReservationPayActivity.a(ReservationPayActivity.this).getResp_code().equals("201002"))
          {
            ReservationPayActivity.this.showProgress("");
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                com.ziroom.ziroomcustomer.e.d.getWYPayState(ReservationPayActivity.b(ReservationPayActivity.this), ReservationPayActivity.a(ReservationPayActivity.this).getOrderCode());
              }
            }, 7000L);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(ReservationPayActivity.this, ReservationPayActivity.a(ReservationPayActivity.this).getResp_desc());
          return;
        }
        if (ReservationPayActivity.g(ReservationPayActivity.this).equals(paramk.getUrl()))
        {
          ReservationPayActivity.a(ReservationPayActivity.this, (e)paramk.getObject());
          ReservationPayActivity.this.setText(ReservationPayActivity.h(ReservationPayActivity.this));
        }
      }
      for (;;)
      {
        ReservationPayActivity.this.dismissProgress();
        return;
        if (ReservationPayActivity.i(ReservationPayActivity.this).equals(paramk.getUrl()))
        {
          ReservationPayActivity.a(ReservationPayActivity.this, (PayOrder)paramk.getObject());
          if (ReservationPayActivity.f(ReservationPayActivity.this) == 1)
          {
            ReservationPayActivity.this.onUPPay(ReservationPayActivity.a(ReservationPayActivity.this));
          }
          else if (ReservationPayActivity.f(ReservationPayActivity.this) == 2)
          {
            ReservationPayActivity.b(ReservationPayActivity.this, ReservationPayActivity.a(ReservationPayActivity.this));
          }
          else if (ReservationPayActivity.f(ReservationPayActivity.this) == 3)
          {
            ReservationPayActivity.c(ReservationPayActivity.this, ReservationPayActivity.a(ReservationPayActivity.this));
          }
          else if (ReservationPayActivity.f(ReservationPayActivity.this) == 4)
          {
            ReservationPayActivity.e(ReservationPayActivity.this);
          }
          else if (ReservationPayActivity.f(ReservationPayActivity.this) == 6)
          {
            ReservationPayActivity.this.onUPPay(ReservationPayActivity.a(ReservationPayActivity.this));
            continue;
            paramk = paramk.getMessage();
            ReservationPayActivity.this.showToast(paramk);
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/reserve/ReservationPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */