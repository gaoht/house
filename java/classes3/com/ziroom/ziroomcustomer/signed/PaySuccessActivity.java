package com.ziroom.ziroomcustomer.signed;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.account.model.GiftBase;
import com.ziroom.ziroomcustomer.account.model.GiftBase.DataBean;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.PayStateInfo;
import com.ziroom.ziroomcustomer.reserve.BookingOrderListActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class PaySuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private String B;
  private Context C;
  private a D;
  private String E;
  private Handler F = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69670: 
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          PaySuccessActivity.this.a = ((PayStateInfo)paramAnonymousMessage.getObject());
          PaySuccessActivity.h(PaySuccessActivity.this).setText(PaySuccessActivity.this.a.getAlready_price() + "");
          return;
        }
        PaySuccessActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
      }
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        if (PaySuccessActivity.this.b == 2)
        {
          if (ae.notNull(PaySuccessActivity.g(PaySuccessActivity.this)))
          {
            paramAnonymousMessage = new Intent(PaySuccessActivity.this, HandleWaitToDoneActivity.class);
            paramAnonymousMessage.putExtra("new_contract_code", PaySuccessActivity.i(PaySuccessActivity.this));
            paramAnonymousMessage.putExtra("old_contract_code", PaySuccessActivity.g(PaySuccessActivity.this));
            PaySuccessActivity.this.startActivity(paramAnonymousMessage);
            return;
          }
          if ((PaySuccessActivity.f(PaySuccessActivity.this) != null) && (PaySuccessActivity.f(PaySuccessActivity.this).equals("wystate")))
          {
            paramAnonymousMessage = new Intent(PaySuccessActivity.this, HandleWaitToDoneActivity.class);
            paramAnonymousMessage.putExtra("contract_part_code", PaySuccessActivity.j(PaySuccessActivity.this));
            str = PaySuccessActivity.this.getIntent().getStringExtra("pay_status");
            if ((str != null) && (str.equals("yzf"))) {
              paramAnonymousMessage.putExtra("pay_status", str);
            }
            PaySuccessActivity.this.startActivity(paramAnonymousMessage);
            return;
          }
          paramAnonymousMessage = new Intent(PaySuccessActivity.this, ZxingActivity.class);
          paramAnonymousMessage.putExtra("contract_part_code", PaySuccessActivity.j(PaySuccessActivity.this));
          PaySuccessActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        paramAnonymousMessage = new Intent(PaySuccessActivity.this, ShareInformationSecondActivity.class);
        paramAnonymousMessage.putExtra("paycontract_code", PaySuccessActivity.j(PaySuccessActivity.this));
        if (ae.notNull(PaySuccessActivity.g(PaySuccessActivity.this)))
        {
          paramAnonymousMessage.putExtra("new_contract_code", PaySuccessActivity.i(PaySuccessActivity.this));
          paramAnonymousMessage.putExtra("old_contract_code", PaySuccessActivity.g(PaySuccessActivity.this));
        }
        String str = PaySuccessActivity.this.getIntent().getStringExtra("wystate");
        if (str != null) {
          paramAnonymousMessage.putExtra("wystate", str);
        }
        PaySuccessActivity.this.startActivity(paramAnonymousMessage);
        return;
      }
      PaySuccessActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  private String G;
  protected PayStateInfo a;
  public int b;
  View c;
  Dialog d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private Button s;
  private Button t;
  private Button u;
  private String v;
  private TextView w;
  private RelativeLayout x;
  private String y;
  private String z;
  
  private void a()
  {
    this.E = getIntent().getStringExtra("className");
    this.G = getIntent().getStringExtra("wystate");
    this.y = getIntent().getStringExtra("reserve");
    this.A = getIntent().getStringExtra("old_contract_code");
    this.z = getIntent().getStringExtra("new_contract_code");
    String str = getIntent().getStringExtra("sub_amount");
    this.e.setText(str);
    if (ae.notNull(this.y))
    {
      this.x.setVisibility(8);
      this.u.setVisibility(0);
      this.r.setVisibility(8);
    }
    this.B = getIntent().getStringExtra("bizCode");
    g();
  }
  
  private void b()
  {
    if ((!"LeaseConfirmPayActivity".equals(this.E)) || (ae.notNull(this.A))) {
      return;
    }
    j.getSignInfo(this, this.v, new com.ziroom.ziroomcustomer.e.a.e(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("is_display")) && (paramAnonymouse.getInteger("is_display").intValue() == 1) && (paramAnonymouse.containsKey("popup")))
        {
          String str = paramAnonymouse.getString("popup");
          if (!TextUtils.isEmpty(str)) {
            h.creatDialog(this.e, str, false, true, paramAnonymouse.getString("skipUrl"), null, new h.a()
            {
              public void closeDialog() {}
              
              public void toMoveHouseWeb(String paramAnonymous2String)
              {
                if (ae.notNull(paramAnonymous2String)) {
                  JsBridgeWebActivity.start(PaySuccessActivity.1.a(PaySuccessActivity.1.this), null, paramAnonymous2String);
                }
              }
            });
          }
        }
      }
    });
    this.D = new a(2000L, 1000L);
    this.D.start();
  }
  
  private void e()
  {
    this.u = ((Button)findViewById(2131692041));
    this.x = ((RelativeLayout)findViewById(2131692042));
    this.e = ((TextView)findViewById(2131690551));
    this.f = ((TextView)findViewById(2131692044));
    this.g = ((TextView)findViewById(2131692045));
    this.s = ((Button)findViewById(2131692048));
    this.t = ((Button)findViewById(2131692047));
    this.r = ((TextView)findViewById(2131692046));
    this.w = ((TextView)findViewById(2131692400));
    this.v = getIntent().getStringExtra("contract_code");
    this.t.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PaySuccessActivity.this.b = 1;
        PaySuccessActivity.a(PaySuccessActivity.this).setVisibility(0);
        PaySuccessActivity.b(PaySuccessActivity.this).setTextColor(Color.rgb(224, 114, 32));
        PaySuccessActivity.c(PaySuccessActivity.this).setTextColor(Color.rgb(167, 161, 154));
        PaySuccessActivity.a(PaySuccessActivity.this).setVisibility(0);
        PaySuccessActivity.d(PaySuccessActivity.this).setVisibility(0);
        PaySuccessActivity.e(PaySuccessActivity.this).setVisibility(8);
        w.onEvent(PaySuccessActivity.this, "keepcontract_havecotenant,");
      }
    });
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PaySuccessActivity.this.b = 2;
        if ((PaySuccessActivity.f(PaySuccessActivity.this) != null) && (PaySuccessActivity.f(PaySuccessActivity.this).equals("wystate"))) {
          PaySuccessActivity.e(PaySuccessActivity.this).setText("下一步");
        }
        if (ae.notNull(PaySuccessActivity.g(PaySuccessActivity.this))) {
          PaySuccessActivity.e(PaySuccessActivity.this).setText("确定");
        }
        PaySuccessActivity.a(PaySuccessActivity.this).setVisibility(8);
        PaySuccessActivity.c(PaySuccessActivity.this).setTextColor(Color.rgb(224, 114, 32));
        PaySuccessActivity.b(PaySuccessActivity.this).setTextColor(Color.rgb(167, 161, 154));
        PaySuccessActivity.e(PaySuccessActivity.this).setVisibility(0);
        PaySuccessActivity.d(PaySuccessActivity.this).setVisibility(8);
        paramAnonymousView = PaySuccessActivity.this.getIntent().getStringExtra("wystate");
        if ((paramAnonymousView != null) && (paramAnonymousView.equals("wystate"))) {
          PaySuccessActivity.e(PaySuccessActivity.this).setText("下一步");
        }
        w.onEvent(PaySuccessActivity.this, "keepcontract_nocotenant");
      }
    });
  }
  
  private void f()
  {
    this.c = View.inflate(this, 2130905165, null);
    Object localObject = (TextView)this.c.findViewById(2131697639);
    TextView localTextView1 = (TextView)this.c.findViewById(2131697638);
    TextView localTextView2 = (TextView)this.c.findViewById(2131697637);
    TextView localTextView3 = (TextView)this.c.findViewById(2131697634);
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PaySuccessActivity.this.d.dismiss();
      }
    });
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(PaySuccessActivity.this, AccountMainActivity.class);
        PaySuccessActivity.this.startActivity(paramAnonymousView);
        PaySuccessActivity.this.d.dismiss();
      }
    });
    localTextView3.setVisibility(8);
    ((TextView)localObject).setVisibility(0);
    localTextView1.setVisibility(0);
    localTextView2.setGravity(17);
    localTextView2.setText("恭喜您获得一个现金红包，请前往账户查看吧！");
    ((TextView)localObject).setText("立即前往");
    localTextView1.setText("稍后查看");
    this.d = new Dialog(this, 2131427781);
    this.d.setContentView(this.c);
    this.d.setCanceledOnTouchOutside(false);
    this.d.setCancelable(false);
    if (!this.d.isShowing())
    {
      localObject = this.d;
      if ((localObject instanceof Dialog)) {
        break label212;
      }
      ((Dialog)localObject).show();
    }
    for (;;)
    {
      this.d.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          PaySuccessActivity.this.c = null;
          PaySuccessActivity.this.d.dismiss();
          PaySuccessActivity.this.d = null;
        }
      });
      return;
      label212:
      VdsAgent.showDialog((Dialog)localObject);
    }
  }
  
  private void g()
  {
    if ((this.B == null) || (this.B.equals("")))
    {
      b();
      return;
    }
    showProgress("");
    com.ziroom.ziroomcustomer.pay.common.b.a.getGiftForBizCodeResult(this, this.B, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        PaySuccessActivity.this.dismissProgress();
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          paramAnonymousk = (GiftBase)paramAnonymousk.getObject();
          if ((paramAnonymousk != null) && (paramAnonymousk.getData() != null) && (paramAnonymousk.getData().getCode() == 0))
          {
            PaySuccessActivity.l(PaySuccessActivity.this);
            return;
          }
          PaySuccessActivity.m(PaySuccessActivity.this);
          return;
        }
        PaySuccessActivity.m(PaySuccessActivity.this);
        g.textToast(PaySuccessActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  public void onBackPressed() {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692048: 
      showChoseShare();
      return;
    case 2131692047: 
      d.setIsSharer(this, this.F, this.v, this.b + "");
      return;
    }
    startActivity(new Intent(this.C, BookingOrderListActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903417);
    this.C = this;
    e();
    a();
  }
  
  public void showChoseShare()
  {
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    View localView = getLayoutInflater().inflate(2130903650, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131691289);
    TextView localTextView2 = (TextView)localView.findViewById(2131693121);
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.setIsSharer(PaySuccessActivity.this, PaySuccessActivity.k(PaySuccessActivity.this), PaySuccessActivity.j(PaySuccessActivity.this), PaySuccessActivity.this.b + "");
        PaySuccessActivity.this.showProgress("");
      }
    });
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localAlertDialog.dismiss();
      }
    });
    localAlertDialog.setView(localView, 0, 0, 0, 0);
    if (!(localAlertDialog instanceof AlertDialog))
    {
      localAlertDialog.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)localAlertDialog);
  }
  
  class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      com.freelxl.baselibrary.d.a.cancel(PaySuccessActivity.this);
      u.e("关闭", "关闭请求");
    }
    
    public void onTick(long paramLong)
    {
      u.e("关闭", paramLong + "后关闭请求");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/PaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */