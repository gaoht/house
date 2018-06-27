package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newServiceList.model.ap;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.LeftMoney;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHPayInfo;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.HashMap;
import java.util.Map;

public class RepairPayActivtiy
  extends BaseActivity
  implements View.OnClickListener
{
  private LinearLayout a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private Button r;
  private MHPayInfo s;
  private String t;
  private boolean u = false;
  private Dialog v;
  private Context w;
  private LeftMoney x;
  private d y = new d();
  private BroadcastReceiver z = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext.equals("refresh_card"))
      {
        RepairPayActivtiy.c(RepairPayActivtiy.this).dismiss();
        RepairPayActivtiy.g(RepairPayActivtiy.this);
      }
      while (!paramAnonymousContext.equals("com.ziroom.ziroomcustomer.activity_1")) {
        return;
      }
      RepairPayActivtiy.this.setResult(512, RepairPayActivtiy.this.getIntent());
      RepairPayActivtiy.this.finish();
    }
  };
  
  private void a()
  {
    j.getRepairCardLeft(this.w, new c());
  }
  
  private void a(ap paramap)
  {
    if (TextUtils.isEmpty(paramap.getPartnerid()))
    {
      this.y.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), "1248814701");
      return;
    }
    this.y.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), paramap.getPartnerid());
  }
  
  private void b()
  {
    Intent localIntent = getIntent();
    this.s = ((MHPayInfo)localIntent.getSerializableExtra("payInfo"));
    this.t = localIntent.getStringExtra("positiveLabels");
    this.a = ((LinearLayout)findViewById(2131689998));
    if ((this.s == null) || (TextUtils.isEmpty(this.t)))
    {
      showEmpty(this.a, "数据异常");
      return;
    }
    this.b = ((TextView)findViewById(2131690306));
    this.b.setText(this.s.getUserName());
    this.c = ((TextView)findViewById(2131690305));
    this.c.setText(this.s.getOrderCode());
    this.d = ((TextView)findViewById(2131690308));
    this.d.setText(this.s.getEnd());
    this.e = ((TextView)findViewById(2131690307));
    this.e.setText(this.s.getMoveDate());
    this.f = ((TextView)findViewById(2131690310));
    this.f.setText(this.s.getMoney() + "");
    this.g = ((ImageView)findViewById(2131689492));
    this.g.setOnClickListener(this);
    this.r = ((Button)findViewById(2131689816));
    this.r.setOnClickListener(this);
  }
  
  private void e()
  {
    this.v = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903775, null);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131691288);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131689846);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131693700);
    RelativeLayout localRelativeLayout1 = (RelativeLayout)((View)localObject1).findViewById(2131693695);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)((View)localObject1).findViewById(2131693701);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131693696);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131693697);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131693698);
    TextView localTextView3 = (TextView)((View)localObject1).findViewById(2131693699);
    float f1 = Float.valueOf(this.f.getText().toString().trim()).floatValue();
    ((TextView)localObject3).setText((int)f1 + ".00");
    if (this.x != null) {
      if ((float)(Long.parseLong(this.x.getAmount()) / 100L) < f1)
      {
        localImageView1.setImageResource(2130838192);
        localImageView2.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView1.setTextColor(-6710887);
        localTextView1.setText(Long.parseLong(this.x.getAmount()) / 100L + ".00");
        localTextView3.setTextColor(-6710887);
        localTextView2.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(RepairPayActivtiy.a(RepairPayActivtiy.this), RepairBuyCardActivity.class);
            RepairPayActivtiy.this.startActivity(paramAnonymousView);
          }
        });
        localRelativeLayout1.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            g.textToast(RepairPayActivtiy.a(RepairPayActivtiy.this), "余额不足，请购买储值卡或联系自如客服");
          }
        });
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RepairPayActivtiy.c(RepairPayActivtiy.this).dismiss();
        }
      });
      localRelativeLayout2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RepairPayActivtiy.this.onConfirm();
        }
      });
      this.v.setCanceledOnTouchOutside(true);
      localObject2 = this.v.getWindow();
      ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
      localObject3 = ((Window)localObject2).getAttributes();
      ((WindowManager.LayoutParams)localObject3).width = -1;
      ((WindowManager.LayoutParams)localObject3).height = -2;
      ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
      ((Window)localObject2).setGravity(80);
      this.v.setContentView((View)localObject1);
      localObject1 = this.v;
      if ((localObject1 instanceof Dialog)) {
        break;
      }
      ((Dialog)localObject1).show();
      return;
      if (Long.parseLong(this.x.getAmount()) / 100L != 0L)
      {
        localTextView3.setTextColor(-12303292);
        localImageView1.setImageResource(2130838192);
        localImageView2.setVisibility(0);
        localTextView2.setVisibility(8);
        localTextView1.setTextColor(40960);
        localTextView1.setText(Long.parseLong(this.x.getAmount()) / 100L + ".00");
        localRelativeLayout1.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            RepairPayActivtiy.b(RepairPayActivtiy.this);
          }
        });
      }
      else
      {
        localRelativeLayout1.setVisibility(8);
        continue;
        localRelativeLayout1.setVisibility(8);
      }
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void f()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.w).setTitle("提示").setContent("您将使用自如维修卡支付").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          int i = RepairPayActivtiy.d(RepairPayActivtiy.this).getMoney();
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("billid", RepairPayActivtiy.d(RepairPayActivtiy.this).getBillId());
          paramAnonymousView.put("money", Integer.valueOf(i));
          paramAnonymousView.put("payKind", Integer.valueOf(4));
          paramAnonymousView.put("strGoodsOrderPrices", RepairPayActivtiy.e(RepairPayActivtiy.this));
          j.payByRepairCard(RepairPayActivtiy.a(RepairPayActivtiy.this), paramAnonymousView, new RepairPayActivtiy.b(RepairPayActivtiy.this));
        }
      }
    }).build().show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.ziroom.commonlibrary.e.c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new com.ziroom.commonlibrary.e.c.a()
    {
      public void doBack()
      {
        RepairPayActivtiy.this.setResult(512, RepairPayActivtiy.this.getIntent());
        RepairPayActivtiy.this.finish();
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
    }
    e();
  }
  
  public void onConfirm()
  {
    if (ae.isNull(this.f.getText().toString()))
    {
      g.textToast(this.w, "金额为空");
      return;
    }
    showProgress("正在请求订单号,请稍候...");
    int i = this.s.getMoney();
    HashMap localHashMap = new HashMap();
    localHashMap.put("billid", this.s.getBillId());
    localHashMap.put("money", Integer.valueOf(i));
    localHashMap.put("payKind", Integer.valueOf(1));
    localHashMap.put("strGoodsOrderPrices", this.t);
    if (i == 0) {
      this.u = true;
    }
    j.PayOrder(this, localHashMap, new a(), this.u);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903147);
    this.w = this;
    b();
    a();
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this.w, "网络请求失败，请检查您的网络设置");
      return;
    }
    this.y.initWXAPI(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("refresh_card");
    paramBundle.addAction("com.ziroom.ziroomcustomer.activity_1");
    registerReceiver(this.z, paramBundle);
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.z != null) {
        unregisterReceiver(this.z);
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
  
  public void onUPPay(ap paramap)
  {
    if (paramap == null)
    {
      g.textToast(this.w, "获取订单号失败！");
      return;
    }
    com.ziroom.commonlibrary.e.c.doStartUnionPayPlugin(this, paramap.getTrans_id());
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        if (RepairPayActivtiy.f(RepairPayActivtiy.this)) {
          paramk.setObject(null);
        }
        for (;;)
        {
          paramk.setSuccess(Boolean.valueOf(true));
          return;
          ap localap = (ap)a.parseObject(paramString.get("data").toString(), ap.class);
          localap.set_package((String)a.parseObject(paramString.get("data").toString()).get("package"));
          paramk.setObject(localap);
        }
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (RepairPayActivtiy.f(RepairPayActivtiy.this))
        {
          g.textToast(RepairPayActivtiy.a(RepairPayActivtiy.this), "支付成功!");
          RepairPayActivtiy.this.dismissProgress();
          RepairPayActivtiy.this.setResult(512, RepairPayActivtiy.this.getIntent());
          RepairPayActivtiy.this.finish();
          return;
        }
        paramk = (ap)paramk.getObject();
        RepairPayActivtiy.a(RepairPayActivtiy.this, paramk);
        RepairPayActivtiy.this.dismissProgress();
        return;
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(RepairPayActivtiy.a(RepairPayActivtiy.this), paramk);
      }
      for (;;)
      {
        RepairPayActivtiy.this.dismissProgress();
        return;
        g.textToast(RepairPayActivtiy.a(RepairPayActivtiy.this), "支付失败，请重试");
      }
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        g.textToast(RepairPayActivtiy.a(RepairPayActivtiy.this), "支付成功!");
        RepairPayActivtiy.this.finish();
      }
      while (TextUtils.isEmpty(paramk.getMessage())) {
        return;
      }
      g.textToast(RepairPayActivtiy.a(RepairPayActivtiy.this), paramk.getMessage());
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((LeftMoney)a.parseObject(paramString.get("data").toString(), LeftMoney.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        RepairPayActivtiy.a(RepairPayActivtiy.this, (LeftMoney)paramk.getObject());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairPayActivtiy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */