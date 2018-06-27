package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.MeterRecharge;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.PayInfo;
import java.text.DecimalFormat;

public class ZryuSdElectricityPayActivity
  extends BaseActivity
{
  private a A;
  private Button a;
  private TextView b;
  private EditText c;
  private View d;
  private TextView e;
  private LinearLayout f;
  private TextView g;
  private LinearLayout r;
  private TextView s;
  private LinearLayout t;
  private TextView u;
  private MeterRecharge v;
  private String w;
  private int x;
  private final int y = 1;
  private final int z = 2;
  
  private void a()
  {
    this.a = ((Button)findViewById(2131690043));
    this.b = ((TextView)findViewById(2131689857));
    this.c = ((EditText)findViewById(2131692950));
    this.e = ((TextView)findViewById(2131689846));
    this.f = ((LinearLayout)findViewById(2131692247));
    this.g = ((TextView)findViewById(2131690053));
    this.r = ((LinearLayout)findViewById(2131692948));
    this.s = ((TextView)findViewById(2131689912));
    this.t = ((LinearLayout)findViewById(2131692949));
    this.u = ((TextView)findViewById(2131690309));
    this.d = findViewById(2131692951);
  }
  
  private void b()
  {
    this.x = 1;
    this.w = getIntent().getStringExtra("contractId");
    j.zryuSdElectricityMeterRecharge(this, this.w, 0, new com.ziroom.commonlibrary.a.a(this, new f(MeterRecharge.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MeterRecharge paramAnonymousMeterRecharge)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMeterRecharge);
        if (paramAnonymousMeterRecharge != null)
        {
          ZryuSdElectricityPayActivity.a(ZryuSdElectricityPayActivity.this).setText(paramAnonymousMeterRecharge.getAddress());
          ZryuSdElectricityPayActivity.b(ZryuSdElectricityPayActivity.this).setText(paramAnonymousMeterRecharge.getPrice());
          ZryuSdElectricityPayActivity.c(ZryuSdElectricityPayActivity.this).setVisibility(8);
          if ((paramAnonymousMeterRecharge.getRechargeMoney() != null) && (paramAnonymousMeterRecharge.getRechargeMoney().intValue() > 0))
          {
            ZryuSdElectricityPayActivity.a(ZryuSdElectricityPayActivity.this, paramAnonymousMeterRecharge.getRechargeMoney().intValue());
            ZryuSdElectricityPayActivity.a(ZryuSdElectricityPayActivity.this, paramAnonymousMeterRecharge);
          }
        }
      }
    });
  }
  
  private void b(int paramInt)
  {
    this.x = 2;
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.b.setText("充值金额");
    DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
    this.e.setText("¥" + localDecimalFormat.format(paramInt / 100.0F));
    this.e.setVisibility(0);
    this.a.setText("去支付");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903600);
    this.A = new a(null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.ziroomcustomer.payresult");
    registerReceiver(this.A, paramBundle);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.A);
    super.onDestroy();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
      if (this.x == 1)
      {
        int i = 0;
        paramView = VdsAgent.trackEditTextSilent(this.c).toString();
        if (TextUtils.isEmpty(paramView))
        {
          g.textToast(this, "请输入充值金额！");
          return;
        }
        try
        {
          int j = Integer.parseInt(paramView);
          i = j;
        }
        catch (NumberFormatException paramView)
        {
          for (;;)
          {
            g.textToast(this, "请输入正确的充值金额！");
          }
          g.textToast(this, "请输入正确的充值金额！");
          return;
        }
        if (i > 0)
        {
          j.zryuSdElectricityMeterRecharge(this, this.w, i * 100, new com.ziroom.commonlibrary.a.a(this, new f(MeterRecharge.class))
          {
            public void onFailure(Throwable paramAnonymousThrowable)
            {
              super.onFailure(paramAnonymousThrowable);
            }
            
            public void onSuccess(int paramAnonymousInt, MeterRecharge paramAnonymousMeterRecharge)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymousMeterRecharge);
              if (paramAnonymousMeterRecharge != null)
              {
                ZryuSdElectricityPayActivity.a(ZryuSdElectricityPayActivity.this).setText(paramAnonymousMeterRecharge.getAddress());
                ZryuSdElectricityPayActivity.b(ZryuSdElectricityPayActivity.this).setText(paramAnonymousMeterRecharge.getPrice());
                if ((!TextUtils.isEmpty(paramAnonymousMeterRecharge.getRechargeReading())) && (paramAnonymousMeterRecharge.getRechargeMoney() != null) && (paramAnonymousMeterRecharge.getRechargeMoney().intValue() != 0)) {
                  break label118;
                }
                ZryuSdElectricityPayActivity.c(ZryuSdElectricityPayActivity.this).setVisibility(8);
              }
              for (;;)
              {
                if ((paramAnonymousMeterRecharge.getRechargeMoney() != null) && (paramAnonymousMeterRecharge.getRechargeMoney().intValue() > 0))
                {
                  ZryuSdElectricityPayActivity.a(ZryuSdElectricityPayActivity.this, paramAnonymousMeterRecharge.getRechargeMoney().intValue());
                  ZryuSdElectricityPayActivity.a(ZryuSdElectricityPayActivity.this, paramAnonymousMeterRecharge);
                }
                return;
                label118:
                ZryuSdElectricityPayActivity.c(ZryuSdElectricityPayActivity.this).setVisibility(0);
                ZryuSdElectricityPayActivity.d(ZryuSdElectricityPayActivity.this).setText(paramAnonymousMeterRecharge.getRechargeReading());
              }
            }
          });
          return;
        }
      }
    } while ((this.x != 2) || (this.v == null));
    j.zryuSdToPay(this, this.v.getAddress(), this.w, this.v.getPrice(), this.v.getRechargeMoney(), this.v.getRechargeReading(), new com.ziroom.commonlibrary.a.a(this, new f(PayInfo.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, PayInfo paramAnonymousPayInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousPayInfo);
        ZryuSdElectricityPayActivity localZryuSdElectricityPayActivity = ZryuSdElectricityPayActivity.this;
        if (paramAnonymousPayInfo.getPayMoney() == null) {}
        for (paramAnonymousInt = 0;; paramAnonymousInt = paramAnonymousPayInfo.getPayMoney().intValue())
        {
          com.ziroom.ziroomcustomer.payment.a.startPayActivty(localZryuSdElectricityPayActivity, paramAnonymousInt, paramAnonymousPayInfo.getBillType(), paramAnonymousPayInfo.getBillNum(), paramAnonymousPayInfo.getSystemId());
          return;
        }
      }
    });
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("code", -1);
      paramContext = paramIntent.getStringExtra("message");
      ZryuSdElectricityPayActivity.this.showToast(paramContext);
      if ((i == 1) && (ZryuSdElectricityPayActivity.e(ZryuSdElectricityPayActivity.this) != null) && (ZryuSdElectricityPayActivity.e(ZryuSdElectricityPayActivity.this).getRechargeMoney() != null))
      {
        paramContext = new Intent(ZryuSdElectricityPayActivity.this, ZryuSignPaySuccessActivity.class);
        paramContext.putExtra("contractId", ZryuSdElectricityPayActivity.f(ZryuSdElectricityPayActivity.this));
        paramContext.putExtra("contractCode", "");
        paramContext.putExtra("payStatusContent", "预计1小时内充值金额会下发到电表，若未及时下发，请联系管家处理");
        paramContext.putExtra("period", "0");
        paramContext.putExtra("type", "1001");
        paramContext.putExtra("isPaySuccess", true);
        paramContext.putExtra("money", new DecimalFormat("0.00").format(ZryuSdElectricityPayActivity.e(ZryuSdElectricityPayActivity.this).getRechargeMoney().intValue() / 100.0F));
        ZryuSdElectricityPayActivity.this.startActivityAndFinish(paramContext);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSdElectricityPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */