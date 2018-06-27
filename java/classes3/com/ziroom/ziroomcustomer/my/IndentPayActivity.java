package com.ziroom.ziroomcustomer.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.c;
import com.ziroom.commonlibrary.e.c.a;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.MoveOrderDetail;
import com.ziroom.ziroomcustomer.model.NotPayEntity;
import com.ziroom.ziroomcustomer.model.OrderInfo;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;

public class IndentPayActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static IndentPayActivity c = null;
  private BroadcastReceiver A = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      IndentPayActivity.this.setResult(512, paramAnonymousIntent);
      IndentPayActivity.this.finish();
    }
  };
  public LinearLayout a;
  public LinearLayout b;
  public NotPayEntity d;
  private TextView e;
  private TextView f;
  private TextView g;
  private EditText r;
  private Button s;
  private Button t;
  private TextView u;
  private MoveOrderDetail v;
  private String w;
  private String x = "";
  private d y = new d();
  private Handler z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {}
      label134:
      do
      {
        do
        {
          do
          {
            return;
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            case 8201: 
              IndentPayActivity.this.dismissProgress();
              paramAnonymousMessage = (l)paramAnonymousMessage.obj;
              if (!paramAnonymousMessage.getSuccess().booleanValue()) {
                break label134;
              }
              paramAnonymousMessage = (OrderInfo)paramAnonymousMessage.getObject();
              if (IndentPayActivity.a(IndentPayActivity.this).equals("2"))
              {
                IndentPayActivity.this.onUPPay(paramAnonymousMessage);
                return;
              }
              break;
            }
          } while (!IndentPayActivity.a(IndentPayActivity.this).equals("1"));
          IndentPayActivity.a(IndentPayActivity.this, paramAnonymousMessage);
          return;
          IndentPayActivity.this.showToast(paramAnonymousMessage.getMessage());
          return;
          IndentPayActivity.this.dismissProgress();
          paramAnonymousMessage = (l)paramAnonymousMessage.obj;
          if (!paramAnonymousMessage.getSuccess().booleanValue()) {
            break;
          }
          paramAnonymousMessage = (OrderInfo)paramAnonymousMessage.getObject();
          if (IndentPayActivity.a(IndentPayActivity.this).equals("2"))
          {
            IndentPayActivity.this.onUPPay(paramAnonymousMessage);
            return;
          }
        } while (!IndentPayActivity.a(IndentPayActivity.this).equals("1"));
        IndentPayActivity.a(IndentPayActivity.this, paramAnonymousMessage);
        return;
        IndentPayActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
        IndentPayActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (!paramAnonymousMessage.getSuccess().booleanValue()) {
          break;
        }
        paramAnonymousMessage = (OrderInfo)paramAnonymousMessage.getObject();
        if (IndentPayActivity.a(IndentPayActivity.this).equals("2"))
        {
          IndentPayActivity.this.onUPPay(paramAnonymousMessage);
          return;
        }
      } while (!IndentPayActivity.a(IndentPayActivity.this).equals("1"));
      IndentPayActivity.a(IndentPayActivity.this, paramAnonymousMessage);
      return;
      IndentPayActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  
  private void a()
  {
    this.u = ((TextView)findViewById(2131697177));
    this.r = ((EditText)findViewById(2131697184));
    this.d = ((NotPayEntity)getIntent().getSerializableExtra("NotPayEntity"));
    this.v = ((MoveOrderDetail)getIntent().getSerializableExtra("orderDetail"));
    this.s = ((Button)findViewById(2131697185));
    this.t = ((Button)findViewById(2131697186));
    this.b = ((LinearLayout)findViewById(2131697178));
    this.a = ((LinearLayout)findViewById(2131697182));
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.e = ((TextView)findViewById(2131697183));
    this.f = ((TextView)findViewById(2131697179));
    this.g = ((TextView)findViewById(2131697181));
    this.a.setVisibility(8);
    g.textToast(getApplicationContext(), "信息错误", 0);
    finish();
  }
  
  private void a(OrderInfo paramOrderInfo)
  {
    this.y.doStartWXPay(this, paramOrderInfo.getTrans_id(), paramOrderInfo.getMerorder_id(), paramOrderInfo.getTimestamp(), paramOrderInfo.get_package(), paramOrderInfo.getSign(), paramOrderInfo.getPartnerid());
  }
  
  public double getInputAmount()
  {
    String str = VdsAgent.trackEditTextSilent(this.r).toString();
    if (ae.notNull(str)) {}
    for (double d1 = ah.Number2(Double.parseDouble(str));; d1 = 0.0D) {
      return ah.Number2(d1);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new c.a()
    {
      public void doBack()
      {
        IndentPayActivity.this.setResult(512, paramIntent);
        IndentPayActivity.this.finish();
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
    finish();
  }
  
  public void onConfirm()
  {
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.r).toString()))
    {
      showToast("金额为空");
      return;
    }
    showProgress("正在请求订单号,请稍候...");
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null)
    {
      localUserInfo.getUid();
      VdsAgent.trackEditTextSilent(this.r).toString();
      return;
    }
    a.startLoginActivity(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905013);
    c = this;
    paramBundle = ((ApplicationEx)getApplication()).getUser();
    if (paramBundle != null) {
      this.w = paramBundle.getUid();
    }
    for (;;)
    {
      a();
      if (this.d.getOrderType() == 4) {
        this.r.setFocusable(false);
      }
      if (checkNet(getApplicationContext())) {
        break;
      }
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
      a.startLoginActivity(this);
    }
    this.y.initWXAPI(this);
    registerReceiver(this.A, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.A);
  }
  
  public void onUPPay(OrderInfo paramOrderInfo)
  {
    if (paramOrderInfo == null)
    {
      showToast("获取订单号失败！");
      return;
    }
    c.doStartUnionPayPlugin(this, paramOrderInfo.getTrans_id());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/IndentPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */