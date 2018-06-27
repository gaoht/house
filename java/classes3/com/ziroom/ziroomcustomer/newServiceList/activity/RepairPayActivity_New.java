package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.DialyCleanMsg;
import com.ziroom.ziroomcustomer.model.OrderInfo;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanBuyCardActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.LeftMoney;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Map;

public class RepairPayActivity_New
  extends BaseActivity
  implements View.OnClickListener
{
  private ApplicationEx A;
  private Context B;
  private LeftMoney C;
  private UserInfo D;
  private BroadcastReceiver E = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      RepairPayActivity_New.this.finish();
    }
  };
  private Handler F = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {
        return;
      }
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      case 69649: 
      default: 
        return;
      case 69648: 
        if (locall.getSuccess().booleanValue())
        {
          RepairPayActivity_New.a(RepairPayActivity_New.this, (DialyCleanMsg)locall.getObject());
          RepairPayActivity_New.d(RepairPayActivity_New.this).setOrderId(RepairPayActivity_New.j(RepairPayActivity_New.this));
          RepairPayActivity_New.this.a(RepairPayActivity_New.d(RepairPayActivity_New.this));
          return;
        }
        break;
      case 69650: 
        RepairPayActivity_New.this.dismissProgress();
        if (locall.getSuccess().booleanValue())
        {
          paramAnonymousMessage = (OrderInfo)locall.getObject();
          if ("0.00".equals(RepairPayActivity_New.e(RepairPayActivity_New.this).getText().toString().trim()))
          {
            g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), "支付成功!");
            RepairPayActivity_New.this.finish();
            return;
          }
          RepairPayActivity_New.a(RepairPayActivity_New.this, paramAnonymousMessage);
          return;
        }
        g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), locall.getMessage());
        return;
      }
      g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), locall.getMessage());
    }
  };
  private ImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private Button g;
  private Dialog r;
  private DialyCleanMsg s;
  private d t = new d();
  private String u = "";
  private String v = "android";
  private float w = 0.0F;
  private int x = 2;
  private String y;
  private float z;
  
  private void a()
  {
    this.s = ((DialyCleanMsg)getIntent().getSerializableExtra("cleanMsg"));
    if (this.s == null)
    {
      this.y = getIntent().getStringExtra("orderId");
      o.getDialyCleanDetail(this, this.F, this.y);
    }
    for (;;)
    {
      this.A = ((ApplicationEx)getApplication());
      UserInfo localUserInfo = this.A.getUser();
      if (localUserInfo == null) {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.B);
      }
      if (localUserInfo != null) {
        n.getCleanCardLeft(this.B, localUserInfo.getUid(), new a(), false);
      }
      this.t.initWXAPI(this);
      registerReceiver(this.E, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
      return;
      a(this.s);
    }
  }
  
  private void a(OrderInfo paramOrderInfo)
  {
    if (TextUtils.isEmpty(paramOrderInfo.getPartnerid()))
    {
      this.t.doStartWXPay(this, paramOrderInfo.getTrans_id(), paramOrderInfo.getMerorder_id(), paramOrderInfo.getTimestamp(), paramOrderInfo.get_package(), paramOrderInfo.getSign(), "1248814701");
      return;
    }
    this.t.doStartWXPay(this, paramOrderInfo.getTrans_id(), paramOrderInfo.getMerorder_id(), paramOrderInfo.getTimestamp(), paramOrderInfo.get_package(), paramOrderInfo.getSign(), paramOrderInfo.getPartnerid());
  }
  
  private void b()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((TextView)findViewById(2131690305));
    this.c = ((TextView)findViewById(2131690306));
    this.d = ((TextView)findViewById(2131690307));
    this.e = ((TextView)findViewById(2131690308));
    this.f = ((TextView)findViewById(2131690310));
    this.g = ((Button)findViewById(2131689816));
    this.a.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void e()
  {
    if (this.s == null) {}
    float f1;
    do
    {
      return;
      this.D = ApplicationEx.c.getUser();
      this.w = this.s.getPrice();
      f1 = Float.valueOf(this.f.getText().toString().trim()).floatValue();
      if (f1 < this.w)
      {
        g.textToast(this.B, "不能低于原价格");
        return;
      }
    } while (this.D == null);
    o.markDialyCleanOrder(this, this.F, this.D.getUid(), this.v, 100.0F * f1, 1, this.y);
    showProgress("");
  }
  
  private void f()
  {
    this.r = new Dialog(this, 2131427692);
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
    if (this.C != null) {
      if ((float)(Long.parseLong(this.C.getAmount()) / 100L) < f1)
      {
        localImageView1.setImageResource(2130838192);
        localImageView2.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView1.setTextColor(-6710887);
        localTextView1.setText(Long.parseLong(this.C.getAmount()) / 100L + ".00");
        localTextView3.setTextColor(-6710887);
        localTextView2.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(RepairPayActivity_New.a(RepairPayActivity_New.this), CleanBuyCardActivity.class);
            RepairPayActivity_New.this.startActivity(paramAnonymousView);
          }
        });
        localRelativeLayout1.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), "余额不足");
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
          RepairPayActivity_New.c(RepairPayActivity_New.this).dismiss();
        }
      });
      localRelativeLayout2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (RepairPayActivity_New.d(RepairPayActivity_New.this) == null) {}
          float f;
          do
          {
            return;
            RepairPayActivity_New.a(RepairPayActivity_New.this, ApplicationEx.c.getUser());
            RepairPayActivity_New.a(RepairPayActivity_New.this, RepairPayActivity_New.d(RepairPayActivity_New.this).getPrice());
            f = Float.valueOf(RepairPayActivity_New.e(RepairPayActivity_New.this).getText().toString().trim()).floatValue();
            if (f < RepairPayActivity_New.f(RepairPayActivity_New.this))
            {
              g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), "不能低于原价格");
              return;
            }
          } while (RepairPayActivity_New.g(RepairPayActivity_New.this) == null);
          o.markDialyCleanOrder(RepairPayActivity_New.this, RepairPayActivity_New.h(RepairPayActivity_New.this), RepairPayActivity_New.g(RepairPayActivity_New.this).getUid(), RepairPayActivity_New.i(RepairPayActivity_New.this), f * 100.0F, 1, RepairPayActivity_New.j(RepairPayActivity_New.this));
          RepairPayActivity_New.this.showProgress("");
        }
      });
      this.r.setCanceledOnTouchOutside(true);
      localObject2 = this.r.getWindow();
      ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
      localObject3 = ((Window)localObject2).getAttributes();
      ((WindowManager.LayoutParams)localObject3).width = -1;
      ((WindowManager.LayoutParams)localObject3).height = -2;
      ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
      ((Window)localObject2).setGravity(80);
      this.r.setContentView((View)localObject1);
      localObject1 = this.r;
      if ((localObject1 instanceof Dialog)) {
        break;
      }
      ((Dialog)localObject1).show();
      return;
      localTextView3.setTextColor(-12303292);
      localImageView1.setImageResource(2130838192);
      localImageView2.setVisibility(0);
      localTextView2.setVisibility(8);
      localTextView1.setTextColor(40960);
      localTextView1.setText(Long.parseLong(this.C.getAmount()) / 100L + ".00");
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RepairPayActivity_New.b(RepairPayActivity_New.this);
        }
      });
      continue;
      localTextView3.setTextColor(-6710887);
      localImageView1.setImageResource(2130838192);
      localImageView2.setVisibility(8);
      localTextView2.setVisibility(0);
      localTextView1.setTextColor(-6710887);
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(RepairPayActivity_New.a(RepairPayActivity_New.this), CleanBuyCardActivity.class);
          RepairPayActivity_New.this.startActivity(paramAnonymousView);
        }
      });
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), "余额不足");
        }
      });
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void g()
  {
    final Dialog localDialog = new Dialog(this, 2131427591);
    View localView = getLayoutInflater().inflate(2130903648, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131691289);
    TextView localTextView2 = (TextView)localView.findViewById(2131691288);
    ((TextView)localView.findViewById(2131693113)).setText("您将使用自如维修卡支付");
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
        if (RepairPayActivity_New.d(RepairPayActivity_New.this) == null) {
          return;
        }
        RepairPayActivity_New.a(RepairPayActivity_New.this, RepairPayActivity_New.k(RepairPayActivity_New.this).getUser().getUid());
        RepairPayActivity_New.a(RepairPayActivity_New.this, RepairPayActivity_New.d(RepairPayActivity_New.this).getPrice());
        float f = Float.valueOf(RepairPayActivity_New.e(RepairPayActivity_New.this).getText().toString().trim()).floatValue();
        if (f < RepairPayActivity_New.f(RepairPayActivity_New.this))
        {
          g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), "不能低于原价格");
          return;
        }
        n.getGeneralCleanPay(RepairPayActivity_New.a(RepairPayActivity_New.this), RepairPayActivity_New.j(RepairPayActivity_New.this), f * 100.0F, RepairPayActivity_New.l(RepairPayActivity_New.this), new RepairPayActivity_New.b(RepairPayActivity_New.this), false);
      }
    });
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  protected void a(DialyCleanMsg paramDialyCleanMsg)
  {
    this.y = paramDialyCleanMsg.getOrderId();
    this.z = paramDialyCleanMsg.getPrice();
    this.b.setText(paramDialyCleanMsg.getOrderNum());
    this.d.setText(paramDialyCleanMsg.getAppointDate());
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      this.c.setText(localUserInfo.getUser_name());
    }
    this.e.setText(paramDialyCleanMsg.getAddress());
    this.f.setText(paramDialyCleanMsg.getPrice() + ".00");
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
    if ("0.00".equals(this.f.getText().toString().trim()))
    {
      e();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903147);
    this.B = this;
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.E);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((LeftMoney)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), LeftMoney.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        RepairPayActivity_New.a(RepairPayActivity_New.this, (LeftMoney)paramk.getObject());
      }
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), "支付成功!");
        RepairPayActivity_New.this.finish();
      }
      while (TextUtils.isEmpty(paramk.getMessage())) {
        return;
      }
      g.textToast(RepairPayActivity_New.a(RepairPayActivity_New.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairPayActivity_New.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */