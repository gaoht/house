package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.DialyCleanMsg;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo.DocumentMo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.LeftMoney;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import java.util.Map;

public class CleanPayActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context A;
  private LeftMoney B;
  private UserInfo C;
  private CleanUesrIsNewMo D;
  private SimpleDraweeView E;
  private String F = "";
  private BroadcastReceiver G = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      CleanPayActivity.this.setResult(512, CleanPayActivity.this.getIntent());
      CleanPayActivity.this.finish();
    }
  };
  private Handler H = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {
        return;
      }
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        CleanPayActivity.a(CleanPayActivity.this, (DialyCleanMsg)locall.getObject());
        CleanPayActivity.d(CleanPayActivity.this).setOrderId(CleanPayActivity.g(CleanPayActivity.this));
        CleanPayActivity.this.a(CleanPayActivity.d(CleanPayActivity.this));
        return;
      }
      g.textToast(CleanPayActivity.a(CleanPayActivity.this), locall.getMessage());
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
  private String t = "";
  private String u = "android";
  private float v = 0.0F;
  private int w = 2;
  private String x;
  private float y;
  private ApplicationEx z;
  
  private void a()
  {
    registerReceiver(this.G, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
    this.s = ((DialyCleanMsg)getIntent().getSerializableExtra("cleanMsg"));
    if (this.s == null)
    {
      this.x = getIntent().getStringExtra("orderId");
      o.getDialyCleanDetail(this, this.H, this.x);
    }
    for (;;)
    {
      this.z = ((ApplicationEx)getApplication());
      UserInfo localUserInfo = this.z.getUser();
      if (localUserInfo == null) {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.A);
      }
      if (localUserInfo != null) {
        n.getCleanCardLeft(this.A, localUserInfo.getUid(), new b(), false);
      }
      n.getUserTypeIsNew(this.A, new a(), j.getUid());
      return;
      a(this.s);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    n.requestServicePayment(this.A, (String)localObject, paramString, 1, 1, paramLong, null, null, new d(this.A, new f(bc.class))
    {
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbc);
        if (paramAnonymousbc.getAmount() == 0)
        {
          g.textToast(CleanPayActivity.a(CleanPayActivity.this), "支付成功");
          CleanPayActivity.this.setResult(512, CleanPayActivity.this.getIntent());
          CleanPayActivity.this.finish();
          return;
        }
        com.ziroom.ziroomcustomer.payment.a.startPayActivty((Activity)CleanPayActivity.a(CleanPayActivity.this), paramAnonymousbc.getAmount(), "baojie_pay", paramAnonymousbc.getOrderIds(), paramAnonymousbc.getSystemId(), paramAnonymousbc.getTimeInterval().toString());
      }
    });
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
    this.E = ((SimpleDraweeView)findViewById(2131690304));
    this.a.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void e()
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
    TextView localTextView4 = (TextView)((View)localObject1).findViewById(2131690073);
    float f1 = Float.valueOf(this.f.getText().toString().trim()).floatValue();
    ((TextView)localObject3).setText((int)f1 + ".00");
    if (!TextUtils.isEmpty(this.F))
    {
      localTextView4.setText(this.F);
      if (this.B == null) {
        break label551;
      }
      if ((float)(Long.parseLong(this.B.getAmount()) / 100L) >= f1) {
        break label460;
      }
      localImageView1.setImageResource(2130838192);
      localImageView2.setVisibility(8);
      localTextView2.setVisibility(0);
      localTextView1.setTextColor(-6710887);
      localTextView1.setText(Long.parseLong(this.B.getAmount()) / 100L + ".00");
      localTextView3.setTextColor(-6710887);
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          w.onEvent("cleanpay_buygiftcard");
          paramAnonymousView = new Intent(CleanPayActivity.a(CleanPayActivity.this), CleanStoredCardBuyActivity.class);
          CleanPayActivity.this.startActivity(paramAnonymousView);
        }
      });
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          g.textToast(CleanPayActivity.a(CleanPayActivity.this), "余额不足");
        }
      });
    }
    for (;;)
    {
      ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CleanPayActivity.c(CleanPayActivity.this).dismiss();
        }
      });
      localRelativeLayout2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (CleanPayActivity.d(CleanPayActivity.this) == null) {
            return;
          }
          CleanPayActivity.a(CleanPayActivity.this, ApplicationEx.c.getUser());
          CleanPayActivity.a(CleanPayActivity.this, CleanPayActivity.d(CleanPayActivity.this).getPrice());
          float f = Float.valueOf(CleanPayActivity.e(CleanPayActivity.this).getText().toString().trim()).floatValue();
          if (f < CleanPayActivity.f(CleanPayActivity.this))
          {
            g.textToast(CleanPayActivity.a(CleanPayActivity.this), "不能低于原价格");
            return;
          }
          long l = f;
          CleanPayActivity.a(CleanPayActivity.this, CleanPayActivity.g(CleanPayActivity.this), 1, 1, 100L * l);
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
        break label617;
      }
      ((Dialog)localObject1).show();
      return;
      localTextView4.setText("推荐使用，极速支付");
      break;
      label460:
      localTextView3.setTextColor(-12303292);
      localImageView1.setImageResource(2130838192);
      localImageView2.setVisibility(0);
      localTextView2.setVisibility(8);
      localTextView1.setTextColor(40960);
      localTextView1.setText(Long.parseLong(this.B.getAmount()) / 100L + ".00");
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CleanPayActivity.b(CleanPayActivity.this);
        }
      });
      continue;
      label551:
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
          w.onEvent("cleanpay_buygiftcard");
          paramAnonymousView = new Intent(CleanPayActivity.a(CleanPayActivity.this), CleanStoredCardBuyActivity.class);
          CleanPayActivity.this.startActivity(paramAnonymousView);
        }
      });
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          g.textToast(CleanPayActivity.a(CleanPayActivity.this), "余额不足");
        }
      });
    }
    label617:
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void f()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.A).setTitle("提示").setContent("您将使用自如保洁卡支付").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if ((!paramAnonymousBoolean) || (CleanPayActivity.d(CleanPayActivity.this) == null)) {
          return;
        }
        CleanPayActivity.b(CleanPayActivity.this, CleanPayActivity.j(CleanPayActivity.this).getUser().getUid());
        CleanPayActivity.a(CleanPayActivity.this, CleanPayActivity.d(CleanPayActivity.this).getPrice());
        float f = Float.valueOf(CleanPayActivity.e(CleanPayActivity.this).getText().toString().trim()).floatValue();
        if (f < CleanPayActivity.f(CleanPayActivity.this))
        {
          g.textToast(CleanPayActivity.a(CleanPayActivity.this), "不能低于原价格");
          return;
        }
        n.getGeneralCleanPay(CleanPayActivity.a(CleanPayActivity.this), CleanPayActivity.g(CleanPayActivity.this), f * 100.0F, CleanPayActivity.k(CleanPayActivity.this), new CleanPayActivity.c(CleanPayActivity.this), false);
      }
    }).build().show();
  }
  
  protected void a(DialyCleanMsg paramDialyCleanMsg)
  {
    this.x = paramDialyCleanMsg.getOrderId();
    this.y = paramDialyCleanMsg.getPrice();
    this.b.setText(paramDialyCleanMsg.getOrderNum());
    this.d.setText(paramDialyCleanMsg.getAppointDate());
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      this.c.setText(localUserInfo.getUser_name());
    }
    this.e.setText(paramDialyCleanMsg.getAddress());
    this.f.setText(paramDialyCleanMsg.getPrice() + ".00");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
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
      a(this.x, 1, 1, 0L);
      return;
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903147);
    this.A = this;
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.G);
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
          paramk.setObject((CleanUesrIsNewMo)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), CleanUesrIsNewMo.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        CleanPayActivity.a(CleanPayActivity.this, (CleanUesrIsNewMo)paramk.getObject());
      }
      if (CleanPayActivity.h(CleanPayActivity.this) != null)
      {
        if (!CleanPayActivity.h(CleanPayActivity.this).isNew()) {
          break label197;
        }
        paramk = CleanPayActivity.h(CleanPayActivity.this).getDocument().getImage();
        if (!TextUtils.isEmpty(paramk)) {
          break label103;
        }
        CleanPayActivity.i(CleanPayActivity.this).setVisibility(8);
      }
      for (;;)
      {
        CleanPayActivity.a(CleanPayActivity.this, CleanPayActivity.h(CleanPayActivity.this).getDocument().getText());
        return;
        label103:
        CleanPayActivity.i(CleanPayActivity.this).setVisibility(0);
        int i = CleanPayActivity.this.getWindowManager().getDefaultDisplay().getWidth() * 3 / 8;
        ViewGroup.LayoutParams localLayoutParams = CleanPayActivity.i(CleanPayActivity.this).getLayoutParams();
        localLayoutParams.height = i;
        CleanPayActivity.i(CleanPayActivity.this).setLayoutParams(localLayoutParams);
        CleanPayActivity.i(CleanPayActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(paramk));
        CleanPayActivity.i(CleanPayActivity.this).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = CleanPayActivity.h(CleanPayActivity.this).getDocument().getUrl();
            String str = CleanPayActivity.h(CleanPayActivity.this).getDocument().getText();
            Intent localIntent = new Intent(CleanPayActivity.a(CleanPayActivity.this), HomeWebActivity.class);
            localIntent.putExtra("title", str);
            localIntent.putExtra("url", paramAnonymousView);
            localIntent.putExtra("ziru", "homeService");
            CleanPayActivity.this.startActivity(localIntent);
          }
        });
        continue;
        label197:
        CleanPayActivity.i(CleanPayActivity.this).setVisibility(8);
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
        CleanPayActivity.a(CleanPayActivity.this, (LeftMoney)paramk.getObject());
      }
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
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
        g.textToast(CleanPayActivity.a(CleanPayActivity.this), "支付成功!");
        CleanPayActivity.this.setResult(512, CleanPayActivity.this.getIntent());
        CleanPayActivity.this.finish();
      }
      while (TextUtils.isEmpty(paramk.getMessage())) {
        return;
      }
      g.textToast(CleanPayActivity.a(CleanPayActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */