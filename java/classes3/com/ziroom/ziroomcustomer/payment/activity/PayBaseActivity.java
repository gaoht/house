package com.ziroom.ziroomcustomer.payment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.e.c;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.b.k;
import com.ziroom.ziroomcustomer.payment.b.l;
import com.ziroom.ziroomcustomer.payment.b.n;
import com.ziroom.ziroomcustomer.payment.e.b.a;
import com.ziroom.ziroomcustomer.payment.e.d;
import com.ziroom.ziroomcustomer.payment.e.d.a;
import com.ziroom.ziroomcustomer.util.u;

public class PayBaseActivity
  extends BaseActivity
  implements com.ziroom.commonlibrary.e.b
{
  protected int a;
  protected l b;
  protected String c;
  int d = 0;
  Handler e = new Handler();
  Runnable f = new Runnable()
  {
    public void run()
    {
      PayBaseActivity.this.showProgressNoCancel("", 33000L);
      if (PayBaseActivity.this.d < 10)
      {
        com.ziroom.ziroomcustomer.payment.d.b.SearchPayStatic(PayBaseActivity.this, PayBaseActivity.this.b.getOrderCode(), PayBaseActivity.this.a, new com.ziroom.ziroomcustomer.payment.d.i(PayBaseActivity.this, new com.ziroom.ziroomcustomer.payment.d.e(Object.class))
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            PayBaseActivity localPayBaseActivity = PayBaseActivity.this;
            int i = PayBaseActivity.this.a;
            if (paramAnonymous2Throwable.getMessage() == null) {}
            for (String str = "";; str = paramAnonymous2Throwable.getMessage())
            {
              localPayBaseActivity.onFail(i, new String[] { str });
              super.onFailure(paramAnonymous2Throwable);
              PayBaseActivity.this.dismissProgress();
              return;
            }
          }
          
          public void onSuccess(int paramAnonymous2Int, Object paramAnonymous2Object)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2Object);
            if (paramAnonymous2Object != null)
            {
              com.alibaba.fastjson.e locale = com.alibaba.fastjson.e.parseObject(paramAnonymous2Object.toString());
              if ((locale != null) && ("9".equals(locale.get("status").toString())))
              {
                PayBaseActivity.this.dismissProgress();
                PayBaseActivity.this.onSuccess(PayBaseActivity.this.a, new String[] { paramAnonymous2Object.toString() });
                return;
              }
              if ((locale != null) && ("8".equals(locale.get("status").toString())))
              {
                PayBaseActivity.this.dismissProgress();
                PayBaseActivity.this.onFail(PayBaseActivity.this.a, new String[] { "支付失败" });
                return;
              }
              if ((locale != null) && ("3".equals(locale.get("status").toString())))
              {
                paramAnonymous2Object = PayBaseActivity.this;
                ((PayBaseActivity)paramAnonymous2Object).d += 1;
                PayBaseActivity.this.e.postDelayed(PayBaseActivity.this.f, 3000L);
                return;
              }
              PayBaseActivity.this.dismissProgress();
              PayBaseActivity.this.onFail(PayBaseActivity.this.a, new String[] { "支付结果查询中" });
              return;
            }
            PayBaseActivity.this.dismissProgress();
            PayBaseActivity.this.onFail(PayBaseActivity.this.a, new String[] { "支付结果查询中" });
          }
        });
        return;
      }
      PayBaseActivity.this.dismissProgress();
      PayBaseActivity.this.onFail(PayBaseActivity.this.a, new String[] { "支付中..." });
    }
  };
  protected Handler g = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        g.textToast(PayBaseActivity.this, "用户取消了支付");
        PayBaseActivity.this.b();
        continue;
        g.textToast(PayBaseActivity.this, paramAnonymousMessage.obj.toString());
        continue;
        g.textToast(PayBaseActivity.this, "支付成功");
        PayBaseActivity.this.showProgressNoCancel("", 2000L);
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            PayBaseActivity.this.a(1, "支付成功");
          }
        }, 2000L);
        continue;
        g.textToast(PayBaseActivity.this, "支付中...");
        PayBaseActivity.this.a(2, "支付中...");
        continue;
        PayBaseActivity.this.a(3, "支付已超时，请重新支付");
      }
    }
  };
  private com.ziroom.ziroomcustomer.payment.e.e r;
  
  protected void a()
  {
    this.d = 0;
    this.e.post(this.f);
  }
  
  protected void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.ziroom.ziroomcustomer.payresult");
    localIntent.putExtra("code", paramInt);
    localIntent.putExtra("message", paramString);
    localIntent.putExtra("payType", this.c);
    sendBroadcast(localIntent);
    finish();
  }
  
  protected void a(k paramk)
  {
    com.ziroom.ziroomcustomer.payment.d.b.goToPay(this, paramk, new com.ziroom.ziroomcustomer.payment.d.i(this, new com.ziroom.ziroomcustomer.payment.d.e(l.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, l paramAnonymousl)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousl);
        PayBaseActivity.this.b = paramAnonymousl;
        switch (PayBaseActivity.this.a)
        {
        default: 
        case 42: 
        case 34: 
        case 12: 
        case 13: 
        case 16: 
        case 17: 
          do
          {
            return;
            PayBaseActivity.a(PayBaseActivity.this).wxPay(paramAnonymousl.getPrepayid(), paramAnonymousl.getNoncestr(), paramAnonymousl.getTimestamp(), paramAnonymousl.get_package(), paramAnonymousl.getSign(), paramAnonymousl.getPartnerid());
            return;
            com.ziroom.commonlibrary.e.a.toALiPay(PayBaseActivity.this, paramAnonymousl.getOrderInfo(), PayBaseActivity.this, 34);
            return;
            c.doStartUnionPayPlugin(PayBaseActivity.this, paramAnonymousl.getPrepayid());
            return;
            c.doStartUnionPayPlugin(PayBaseActivity.this, paramAnonymousl.getPrepayid());
            return;
            if ("201000".equals(PayBaseActivity.this.b.getResp_code()))
            {
              PayBaseActivity.this.onSuccess(PayBaseActivity.this.a, new String[] { PayBaseActivity.this.b.getRespCode(), PayBaseActivity.this.b.getRespMsg() });
              return;
            }
            if ("201002".equals(PayBaseActivity.this.b.getResp_code()))
            {
              PayBaseActivity.this.a();
              return;
            }
            PayBaseActivity.this.onFail(PayBaseActivity.this.a, new String[] { PayBaseActivity.this.b.getRespCode(), PayBaseActivity.this.b.getRespMsg() });
            return;
            if ("paying".equals(PayBaseActivity.this.b.getRespCode()))
            {
              PayBaseActivity.this.a();
              return;
            }
          } while (!"fail".equals(PayBaseActivity.this.b.getRespCode()));
          PayBaseActivity.this.onFail(PayBaseActivity.this.a, new String[] { PayBaseActivity.this.b.getRespCode(), PayBaseActivity.this.b.getRespMsg() });
          return;
        case 90: 
          PayBaseActivity.this.onSuccess(PayBaseActivity.this.a, new String[] { "支付成功" });
          return;
        case 95: 
          PayBaseActivity.this.onSuccess(PayBaseActivity.this.a, new String[] { "支付成功" });
          return;
        case 92: 
          PayBaseActivity.this.onSuccess(PayBaseActivity.this.a, new String[] { "支付成功" });
          return;
        case 96: 
          PayBaseActivity.this.onSuccess(PayBaseActivity.this.a, new String[] { "支付成功" });
          return;
        }
        PayBaseActivity.this.onSuccess(PayBaseActivity.this.a, new String[] { "支付成功" });
      }
    });
  }
  
  protected void a(final k paramk, n paramn)
  {
    boolean bool2 = true;
    this.a = paramk.getPayChannel();
    Object localObject;
    boolean bool1;
    if (this.a == 16)
    {
      localObject = new com.ziroom.ziroomcustomer.payment.e.b(this, Boolean.valueOf(true), paramk.getCwOrderIds(), null, new b.a()
      {
        public void onClick(String paramAnonymousString, com.ziroom.ziroomcustomer.payment.b.i paramAnonymousi)
        {
          paramk.setSmsCode(paramAnonymousString);
          paramk.setSmsOrderDate(paramAnonymousi.getOrder_date());
          paramk.setSmsOrderId(paramAnonymousi.getOrder_id());
          PayBaseActivity.this.a(paramk);
        }
      });
      if (paramn.getIsTieCard() != 1) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.ziroom.ziroomcustomer.payment.e.b)localObject).ToPay(Boolean.valueOf(bool1), paramk.getCwOrderIds());
        return;
      }
    }
    if (this.a == 17)
    {
      localObject = new d(this);
      String str = paramk.getCwOrderIds();
      if (paramn.getIsTieCard() != 1)
      {
        bool1 = true;
        if (paramn.getIsAgreement() == 1) {
          break label151;
        }
      }
      for (;;)
      {
        ((d)localObject).ToPay(str, Boolean.valueOf(bool1), Boolean.valueOf(bool2), new d.a()
        {
          public void onSuccess(String paramAnonymousString)
          {
            paramk.setSmsCode(paramAnonymousString);
            PayBaseActivity.this.a(paramk);
          }
        });
        return;
        bool1 = false;
        break;
        label151:
        bool2 = false;
      }
    }
    a(paramk);
  }
  
  protected void b()
  {
    com.ziroom.ziroomcustomer.payment.d.b.sendCancelPayStatus(this, this.b.getOrderCode(), new com.ziroom.ziroomcustomer.payment.d.i(this, new com.ziroom.ziroomcustomer.payment.d.e(Object.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, this, 12);
  }
  
  public void onCancel(int paramInt, String... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      paramVarArgs = "null";
      u.d("payresult--onCancel", paramVarArgs);
      this.g.sendEmptyMessage(-1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramVarArgs[0]).append("msg:");
    if (paramVarArgs.length > 1) {}
    for (paramVarArgs = paramVarArgs[1];; paramVarArgs = "")
    {
      paramVarArgs = paramVarArgs;
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.r = new com.ziroom.ziroomcustomer.payment.e.e(this, this, 42);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.r.UnregisterReceiver();
    this.e.removeCallbacksAndMessages(null);
    this.g.removeCallbacksAndMessages(null);
  }
  
  public void onFail(int paramInt, String... paramVarArgs)
  {
    Object localObject;
    if (paramVarArgs == null)
    {
      localObject = "null";
      u.d("payresult--onFail", (String)localObject);
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label102;
      }
      paramVarArgs = "支付失败";
    }
    for (;;)
    {
      localObject = new Message();
      ((Message)localObject).what = 0;
      ((Message)localObject).obj = paramVarArgs;
      this.g.sendMessage((Message)localObject);
      return;
      StringBuilder localStringBuilder = new StringBuilder().append(paramVarArgs[0]).append("msg:");
      if (paramVarArgs.length > 1) {}
      for (localObject = paramVarArgs[1];; localObject = "")
      {
        localObject = (String)localObject;
        break;
      }
      label102:
      if (paramVarArgs.length == 1)
      {
        if (TextUtils.isEmpty(paramVarArgs[0])) {
          paramVarArgs = "支付失败";
        } else {
          paramVarArgs = paramVarArgs[0];
        }
      }
      else if (TextUtils.isEmpty(paramVarArgs[1])) {
        paramVarArgs = "支付失败";
      } else {
        paramVarArgs = paramVarArgs[1];
      }
    }
  }
  
  public void onSuccess(int paramInt, String... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      paramVarArgs = "null";
      u.d("payresult--onSuccess", paramVarArgs);
      this.g.sendEmptyMessage(1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramVarArgs[0]).append("msg:");
    if (paramVarArgs.length > 1) {}
    for (paramVarArgs = paramVarArgs[1];; paramVarArgs = "")
    {
      paramVarArgs = paramVarArgs;
      break;
    }
  }
  
  public void onWaiting(int paramInt, String... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      paramVarArgs = "null";
      u.d("payresult--onWaiting", paramVarArgs);
      this.g.sendEmptyMessage(2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramVarArgs[0]).append("msg:");
    if (paramVarArgs.length > 1) {}
    for (paramVarArgs = paramVarArgs[1];; paramVarArgs = "")
    {
      paramVarArgs = paramVarArgs;
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/PayBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */