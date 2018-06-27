package com.ziroom.ziroomcustomer.ziroomstation.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.c.a;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.OrderInfo;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.w;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends Dialog
{
  private Context a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  private String j;
  private double k;
  private b l;
  private c m;
  private String n;
  private int o = 0;
  private d p = new d();
  private long q;
  private BroadcastReceiver r = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (b.c(b.this) != null)
      {
        if (paramAnonymousIntent.getIntExtra("code", 1000) != 0) {
          break label59;
        }
        b.c(b.this).onSuccess();
      }
      for (;;)
      {
        b.e(b.this).unregisterReceiver(b.d(b.this));
        b.this.dismiss();
        return;
        label59:
        b.c(b.this).onFailed();
      }
    }
  };
  private a s = new a()
  {
    public void doInActivityResult(Context paramAnonymousContext, int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
    {
      com.ziroom.commonlibrary.e.c.doUnionPayResult(paramAnonymousContext, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, new c.a()
      {
        public void doBack() {}
      });
    }
  };
  
  public b(Context paramContext, String paramString, double paramDouble, int paramInt)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.j = paramString;
    this.k = paramDouble;
    this.o = paramInt;
  }
  
  public b(Context paramContext, String paramString, double paramDouble, b paramb, int paramInt)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.j = paramString;
    this.k = paramDouble;
    this.l = paramb;
    this.o = paramInt;
  }
  
  public b(Context paramContext, String paramString, double paramDouble, c paramc, int paramInt)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.j = paramString;
    this.k = paramDouble;
    this.m = paramc;
    this.o = paramInt;
  }
  
  private void a(View paramView)
  {
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        b.this.dismiss();
      }
    });
    if (this.g) {
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          b.a(b.this, "42");
          com.ziroom.ziroomcustomer.ziroomstation.b.c.payOrder(b.e(b.this), com.ziroom.ziroomcustomer.ziroomstation.b.b.buildPayOrder(b.e(b.this), "42", b.f(b.this), b.g(b.this)), new i.a()
          {
            public void onParse(String paramAnonymous2String, k paramAnonymous2k)
            {
              try
              {
                paramAnonymous2String = new JSONObject(paramAnonymous2String);
                if ("200".equals(paramAnonymous2String.optString("error_code")))
                {
                  paramAnonymous2String = new JSONObject(paramAnonymous2String.optString("data"));
                  OrderInfo localOrderInfo = new OrderInfo();
                  localOrderInfo.set_package(paramAnonymous2String.optString("package"));
                  localOrderInfo.setTrans_id(paramAnonymous2String.optString("prepayid"));
                  localOrderInfo.setMerorder_id(paramAnonymous2String.optString("noncestr"));
                  localOrderInfo.setTimestamp(paramAnonymous2String.optString("timestamp"));
                  localOrderInfo.setSign(paramAnonymous2String.optString("sign"));
                  localOrderInfo.setPartnerid(paramAnonymous2String.optString("partnerid"));
                  paramAnonymous2k.setSuccess(Boolean.valueOf(true));
                  b.h(b.this).doStartWXPay(b.e(b.this), localOrderInfo.getTrans_id(), localOrderInfo.getMerorder_id(), localOrderInfo.getTimestamp(), localOrderInfo.get_package(), localOrderInfo.getSign(), localOrderInfo.getPartnerid());
                  return;
                }
                paramAnonymous2k.setSuccess(Boolean.valueOf(false));
                return;
              }
              catch (JSONException paramAnonymous2String)
              {
                paramAnonymous2k.setSuccess(Boolean.valueOf(false));
              }
            }
            
            public void onSuccess(k paramAnonymous2k)
            {
              if (!paramAnonymous2k.getSuccess().booleanValue()) {
                af.showToast(b.e(b.this), "服务器开小差了，请稍后再试");
              }
            }
          }, true);
          b.this.dismiss();
        }
      });
    }
    if (this.h) {
      this.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          b.a(b.this, "12");
          com.ziroom.ziroomcustomer.ziroomstation.b.c.payOrder(b.e(b.this), com.ziroom.ziroomcustomer.ziroomstation.b.b.buildPayOrder(b.e(b.this), "12", b.f(b.this), b.g(b.this)), new i.a()
          {
            public void onParse(String paramAnonymous2String, k paramAnonymous2k)
            {
              try
              {
                paramAnonymous2String = new JSONObject(paramAnonymous2String);
                if ("200".equals(paramAnonymous2String.optString("error_code")))
                {
                  paramAnonymous2String = new JSONObject(paramAnonymous2String.optString("data"));
                  paramAnonymous2k.setSuccess(Boolean.valueOf(true));
                  com.ziroom.commonlibrary.e.c.doStartUnionPayPlugin((Activity)b.e(b.this), paramAnonymous2String.optString("prepayid"));
                  return;
                }
                paramAnonymous2k.setSuccess(Boolean.valueOf(false));
                return;
              }
              catch (JSONException paramAnonymous2String)
              {
                paramAnonymous2k.setSuccess(Boolean.valueOf(false));
              }
            }
            
            public void onSuccess(k paramAnonymous2k)
            {
              if (!paramAnonymous2k.getSuccess().booleanValue()) {
                af.showToast(b.e(b.this), "服务器开小差了，请稍后再试");
              }
            }
          }, true);
          b.this.dismiss();
        }
      });
    }
    if (this.i) {
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          b.a(b.this, "13");
          com.ziroom.ziroomcustomer.ziroomstation.b.c.payOrder(b.e(b.this), com.ziroom.ziroomcustomer.ziroomstation.b.b.buildPayOrder(b.e(b.this), "13", b.f(b.this), b.g(b.this)), new i.a()
          {
            public void onParse(String paramAnonymous2String, k paramAnonymous2k)
            {
              try
              {
                paramAnonymous2String = new JSONObject(paramAnonymous2String);
                if ("200".equals(paramAnonymous2String.optString("error_code")))
                {
                  paramAnonymous2String = new JSONObject(paramAnonymous2String.optString("data"));
                  paramAnonymous2k.setSuccess(Boolean.valueOf(true));
                  com.ziroom.commonlibrary.e.c.doStartUnionPayPlugin((Activity)b.e(b.this), paramAnonymous2String.optString("prepayid"));
                  return;
                }
                paramAnonymous2k.setSuccess(Boolean.valueOf(false));
                return;
              }
              catch (JSONException paramAnonymous2String)
              {
                paramAnonymous2k.setSuccess(Boolean.valueOf(false));
              }
            }
            
            public void onSuccess(k paramAnonymous2k)
            {
              if (!paramAnonymous2k.getSuccess().booleanValue()) {
                af.showToast(b.e(b.this), "服务器开小差了，请稍后再试");
              }
            }
          }, true);
          b.this.dismiss();
        }
      });
    }
  }
  
  private void a(String paramString)
  {
    int i2 = 0;
    int i1 = -1;
    switch (this.o)
    {
    default: 
      return;
    case 2: 
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i1)
        {
        default: 
          return;
        case 0: 
          w.onEventToZiroomAndUmeng("zinn_book_pay_weixin");
          return;
          if (paramString.equals("42"))
          {
            i1 = 0;
            continue;
            if (paramString.equals("12"))
            {
              i1 = 1;
              continue;
              if (paramString.equals("13")) {
                i1 = 2;
              }
            }
          }
          break;
        }
      }
      w.onEventToZiroomAndUmeng("zinn_book_pay_credit");
      return;
      w.onEventToZiroomAndUmeng("zinn_book_pay_debit");
      return;
    case 1: 
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i1)
        {
        default: 
          return;
        case 0: 
          w.onEventToZiroomAndUmeng("zinn_det_dzf_pay_weixin");
          return;
          if (paramString.equals("42"))
          {
            i1 = 0;
            continue;
            if (paramString.equals("12"))
            {
              i1 = 1;
              continue;
              if (paramString.equals("13")) {
                i1 = 2;
              }
            }
          }
          break;
        }
      }
      w.onEventToZiroomAndUmeng("zinn_det_dzf_pay_credit");
      return;
      w.onEventToZiroomAndUmeng("zinn_det_dzf_pay_debit");
      return;
    }
    switch (paramString.hashCode())
    {
    default: 
      label332:
      i1 = -1;
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return;
      case 0: 
        w.onEventToZiroomAndUmeng("zinn_list_dzf_pay_weixin");
        return;
        if (!paramString.equals("42")) {
          break label332;
        }
        i1 = i2;
        continue;
        if (!paramString.equals("12")) {
          break label332;
        }
        i1 = 1;
        continue;
        if (!paramString.equals("13")) {
          break label332;
        }
        i1 = 2;
      }
    }
    w.onEventToZiroomAndUmeng("zinn_list_dzf_pay_credit");
    return;
    w.onEventToZiroomAndUmeng("zinn_list_dzf_pay_debit");
  }
  
  private void b(View paramView) {}
  
  public a getCallback()
  {
    return this.s;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int i2 = 0;
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.a).inflate(2130903855, null);
    this.e = paramBundle.findViewById(2131690460);
    this.b = paramBundle.findViewById(2131693886);
    this.c = paramBundle.findViewById(2131693888);
    this.d = paramBundle.findViewById(2131693890);
    this.f = paramBundle.findViewById(2131693030);
    View localView = this.b;
    if (this.g)
    {
      i1 = 0;
      localView.setVisibility(i1);
      localView = this.c;
      if (!this.h) {
        break label195;
      }
      i1 = 0;
      label107:
      localView.setVisibility(i1);
      localView = this.d;
      if (!this.i) {
        break label201;
      }
    }
    label195:
    label201:
    for (int i1 = i2;; i1 = 8)
    {
      localView.setVisibility(i1);
      b(paramBundle);
      a(paramBundle);
      setContentView(paramBundle);
      setDefaultSetting();
      this.p.initWXAPI(this.a);
      setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          w.onDuration("zinn_book_pay_duration", (int)((System.currentTimeMillis() - b.a(b.this)) / 1000L));
          if (b.b(b.this) != null) {
            b.b(b.this).callback();
          }
        }
      });
      setOnShowListener(new DialogInterface.OnShowListener()
      {
        public void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          b.a(b.this, System.currentTimeMillis());
        }
      });
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label107;
    }
  }
  
  public void onUPPay()
  {
    com.ziroom.commonlibrary.e.c.doStartUnionPayPlugin((Activity)this.a, this.n);
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(false);
    Object localObject = getWindow();
    ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    ((Window)localObject).setAttributes(localLayoutParams);
    ((Window)localObject).getDecorView().setBackgroundColor(-1);
    ((Window)localObject).setGravity(80);
    int i1 = n.dip2px(this.a, 192.0F);
    int i2 = ((BaseActivity)this.a).getWindow().getDecorView().getWidth();
    localObject = this.f.getLayoutParams();
    if (i1 < i2 * 3 / 4) {
      i1 = i2 * 3 / 4;
    }
    for (;;)
    {
      ((ViewGroup.LayoutParams)localObject).height = i1;
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public void setPayWay(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramBoolean3;
  }
  
  public static abstract interface a
  {
    public abstract void doInActivityResult(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  public static abstract interface b
  {
    public abstract void callback();
  }
  
  public static abstract interface c
  {
    public abstract void onFailed();
    
    public abstract void onSuccess();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/dialog/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */