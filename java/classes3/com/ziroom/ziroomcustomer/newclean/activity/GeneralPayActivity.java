package com.ziroom.ziroomcustomer.newclean.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo.DocumentMo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.LeftMoney;
import com.ziroom.ziroomcustomer.newclean.d.au;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import java.util.Map;

public class GeneralPayActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private UserInfo A;
  private CleanUesrIsNewMo B;
  private SimpleDraweeView C;
  private String D = "";
  private au E;
  private BroadcastReceiver F = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent != null) && (paramAnonymousIntent.getIntExtra("code", -1) == 1))
      {
        if (GeneralPayActivity.a(GeneralPayActivity.this) != null) {
          GeneralPayActivity.a(GeneralPayActivity.this).dismiss();
        }
        GeneralPayActivity.this.setResult(512, GeneralPayActivity.this.getIntent());
        GeneralPayActivity.this.finish();
      }
      while ((paramAnonymousIntent == null) || (paramAnonymousIntent.getStringExtra("message") == null)) {
        return;
      }
      g.textToast(GeneralPayActivity.this, paramAnonymousIntent.getStringExtra("message"));
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
  private String s = "";
  private String t = "android";
  private float u = 0.0F;
  private int v = 2;
  private String w;
  private ApplicationEx x;
  private Context y;
  private LeftMoney z;
  
  private void a()
  {
    registerReceiver(this.F, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
    this.w = getIntent().getStringExtra("orderId");
    b();
    this.x = ((ApplicationEx)getApplication());
    UserInfo localUserInfo = this.x.getUser();
    if (localUserInfo == null) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.y);
    }
    if (localUserInfo != null) {
      n.getCleanCardLeft(this.y, localUserInfo.getUid(), new b(), false);
    }
    n.getUserTypeIsNew(this.y, new a(), j.getUid());
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    n.requestServicePayment(this.y, (String)localObject, paramString, 1, 1, paramLong, null, null, new d(this.y, new f(bc.class))
    {
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbc);
        if (paramAnonymousbc.getAmount() == 0)
        {
          if (GeneralPayActivity.a(GeneralPayActivity.this) != null) {
            GeneralPayActivity.a(GeneralPayActivity.this).dismiss();
          }
          g.textToast(GeneralPayActivity.b(GeneralPayActivity.this), "支付成功");
          GeneralPayActivity.this.setResult(512, GeneralPayActivity.this.getIntent());
          GeneralPayActivity.this.finish();
          return;
        }
        com.ziroom.ziroomcustomer.payment.a.startPayActivty((Activity)GeneralPayActivity.b(GeneralPayActivity.this), paramAnonymousbc.getAmount(), "baojiepay", paramAnonymousbc.getOrderIds(), paramAnonymousbc.getSystemId(), paramAnonymousbc.getTimeInterval().toString());
      }
    });
  }
  
  private void b()
  {
    if (!ApplicationEx.c.isLoginState()) {
      return;
    }
    n.getGeneralDetail(this, this.w, new com.ziroom.ziroomcustomer.e.a.a(this, new m(au.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, au paramAnonymousau)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousau);
        if (paramAnonymousau != null)
        {
          GeneralPayActivity.a(GeneralPayActivity.this, paramAnonymousau);
          GeneralPayActivity.this.a(paramAnonymousau);
        }
      }
    });
  }
  
  private void e()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((TextView)findViewById(2131690305));
    this.c = ((TextView)findViewById(2131690306));
    this.d = ((TextView)findViewById(2131690307));
    this.e = ((TextView)findViewById(2131690308));
    this.f = ((TextView)findViewById(2131690310));
    this.g = ((Button)findViewById(2131689816));
    this.C = ((SimpleDraweeView)findViewById(2131690304));
    this.a.setOnClickListener(this);
    this.g.setOnClickListener(this);
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
    TextView localTextView4 = (TextView)((View)localObject1).findViewById(2131690073);
    float f1 = Float.valueOf(this.f.getText().toString().trim()).floatValue();
    ((TextView)localObject3).setText((int)f1 + ".00");
    if (!TextUtils.isEmpty(this.D))
    {
      localTextView4.setText(this.D);
      if (this.z == null) {
        break label551;
      }
      if ((float)(Long.parseLong(this.z.getAmount()) / 100L) >= f1) {
        break label460;
      }
      localImageView1.setImageResource(2130838192);
      localImageView2.setVisibility(8);
      localTextView2.setVisibility(0);
      localTextView1.setTextColor(-6710887);
      localTextView1.setText(Long.parseLong(this.z.getAmount()) / 100L + ".00");
      localTextView3.setTextColor(-6710887);
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          w.onEvent("cleanpay_buygiftcard");
          paramAnonymousView = new Intent(GeneralPayActivity.b(GeneralPayActivity.this), CleanStoredCardBuyActivity.class);
          GeneralPayActivity.this.startActivity(paramAnonymousView);
        }
      });
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          g.textToast(GeneralPayActivity.b(GeneralPayActivity.this), "余额不足");
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
          GeneralPayActivity.a(GeneralPayActivity.this).dismiss();
        }
      });
      localRelativeLayout2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          GeneralPayActivity.a(GeneralPayActivity.this, ApplicationEx.c.getUser());
          long l = Float.valueOf(GeneralPayActivity.d(GeneralPayActivity.this).getText().toString().trim()).floatValue();
          GeneralPayActivity.a(GeneralPayActivity.this, GeneralPayActivity.e(GeneralPayActivity.this), 1, 1, 100L * l);
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
      localTextView1.setText(Long.parseLong(this.z.getAmount()) / 100L + ".00");
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          GeneralPayActivity.c(GeneralPayActivity.this);
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
          paramAnonymousView = new Intent(GeneralPayActivity.b(GeneralPayActivity.this), CleanStoredCardBuyActivity.class);
          GeneralPayActivity.this.startActivity(paramAnonymousView);
        }
      });
      localRelativeLayout1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          g.textToast(GeneralPayActivity.b(GeneralPayActivity.this), "余额不足");
        }
      });
    }
    label617:
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void g()
  {
    final Dialog localDialog = new Dialog(this, 2131427591);
    View localView = getLayoutInflater().inflate(2130903648, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131691289);
    TextView localTextView2 = (TextView)localView.findViewById(2131691288);
    ((TextView)localView.findViewById(2131693113)).setText("您将使用储值卡支付");
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
        GeneralPayActivity.b(GeneralPayActivity.this, GeneralPayActivity.h(GeneralPayActivity.this).getUser().getUid());
        float f = Float.valueOf(GeneralPayActivity.d(GeneralPayActivity.this).getText().toString().trim()).floatValue();
        n.getGeneralCleanPay(GeneralPayActivity.b(GeneralPayActivity.this), GeneralPayActivity.e(GeneralPayActivity.this), f * 100.0F, GeneralPayActivity.i(GeneralPayActivity.this), new GeneralPayActivity.c(GeneralPayActivity.this), false);
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
  
  protected void a(au paramau)
  {
    this.b.setText(paramau.getOrderNum());
    this.d.setText(paramau.getAppointTime());
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      this.c.setText(localUserInfo.getUser_name());
    }
    this.e.setText(paramau.getAddress());
    this.f.setText(paramau.getOrderPrice() + ".00");
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
    if (this.E == null)
    {
      g.textToast(this.y, "请求数据失败");
      return;
    }
    if ("0.00".equals(this.f.getText().toString().trim()))
    {
      a(this.w, 1, 1, 0L);
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903147);
    this.y = this;
    e();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.F);
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
        GeneralPayActivity.a(GeneralPayActivity.this, (CleanUesrIsNewMo)paramk.getObject());
      }
      if (GeneralPayActivity.f(GeneralPayActivity.this) != null)
      {
        if (!GeneralPayActivity.f(GeneralPayActivity.this).isNew()) {
          break label197;
        }
        paramk = GeneralPayActivity.f(GeneralPayActivity.this).getDocument().getImage();
        if (!TextUtils.isEmpty(paramk)) {
          break label103;
        }
        GeneralPayActivity.g(GeneralPayActivity.this).setVisibility(8);
      }
      for (;;)
      {
        GeneralPayActivity.a(GeneralPayActivity.this, GeneralPayActivity.f(GeneralPayActivity.this).getDocument().getText());
        return;
        label103:
        GeneralPayActivity.g(GeneralPayActivity.this).setVisibility(0);
        int i = GeneralPayActivity.this.getWindowManager().getDefaultDisplay().getWidth() * 3 / 8;
        ViewGroup.LayoutParams localLayoutParams = GeneralPayActivity.g(GeneralPayActivity.this).getLayoutParams();
        localLayoutParams.height = i;
        GeneralPayActivity.g(GeneralPayActivity.this).setLayoutParams(localLayoutParams);
        GeneralPayActivity.g(GeneralPayActivity.this).setController(c.frescoController(paramk));
        GeneralPayActivity.g(GeneralPayActivity.this).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = GeneralPayActivity.f(GeneralPayActivity.this).getDocument().getUrl();
            String str = GeneralPayActivity.f(GeneralPayActivity.this).getDocument().getText();
            Intent localIntent = new Intent(GeneralPayActivity.b(GeneralPayActivity.this), HomeWebActivity.class);
            localIntent.putExtra("title", str);
            localIntent.putExtra("url", paramAnonymousView);
            localIntent.putExtra("ziru", "homeService");
            GeneralPayActivity.this.startActivity(localIntent);
          }
        });
        continue;
        label197:
        GeneralPayActivity.g(GeneralPayActivity.this).setVisibility(8);
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
        GeneralPayActivity.a(GeneralPayActivity.this, (LeftMoney)paramk.getObject());
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
        if (GeneralPayActivity.a(GeneralPayActivity.this) != null) {
          GeneralPayActivity.a(GeneralPayActivity.this).dismiss();
        }
        g.textToast(GeneralPayActivity.b(GeneralPayActivity.this), "支付成功!");
        GeneralPayActivity.this.setResult(512, GeneralPayActivity.this.getIntent());
        GeneralPayActivity.this.finish();
      }
      while (TextUtils.isEmpty(paramk.getMessage())) {
        return;
      }
      g.textToast(GeneralPayActivity.b(GeneralPayActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/GeneralPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */