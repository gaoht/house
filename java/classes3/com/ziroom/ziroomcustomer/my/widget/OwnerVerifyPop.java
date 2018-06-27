package com.ziroom.ziroomcustomer.my.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.my.OwnerContractConfirmActivity;
import com.ziroom.ziroomcustomer.my.model.WeChatLoginStatusBean;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class OwnerVerifyPop
  extends PopupWindow
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private LayoutInflater c;
  private ImageView d;
  private TextView e;
  private EditText f;
  private TextView g;
  private String h;
  private String i;
  private String j;
  private boolean k;
  private b l;
  private int m = 0;
  private Handler n = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        OwnerVerifyPop.a(OwnerVerifyPop.this, true);
        OwnerVerifyPop.h(OwnerVerifyPop.this);
        return;
      }
      OwnerVerifyPop.a(OwnerVerifyPop.this);
    }
  };
  private a o;
  
  public OwnerVerifyPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OwnerVerifyPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OwnerVerifyPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.c = ((Activity)paramContext).getLayoutInflater();
    this.b = this.c.inflate(2130903836, null);
    this.a = paramContext;
    setFocusable(true);
    a();
  }
  
  private void a()
  {
    this.d = ((ImageView)this.b.findViewById(2131689492));
    this.e = ((TextView)this.b.findViewById(2131693857));
    this.g = ((TextView)this.b.findViewById(2131690585));
    this.f = ((EditText)this.b.findViewById(2131693858));
    this.f.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() < 6) {
          return;
        }
        OwnerVerifyPop.a(OwnerVerifyPop.this, paramAnonymousEditable.toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    setContentView(this.b);
  }
  
  private void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ipAddr", ah.getIpAddress(this.a));
    String str = ah.getDeviceId(ApplicationEx.c);
    if (str == null) {}
    for (;;)
    {
      localHashMap.put("lat", ApplicationEx.c.getLocation().getLatitude() + "");
      localHashMap.put("lng", ApplicationEx.c.getLocation().getLongitude() + "");
      localHashMap.put("imei", ah.getDeviceId(this.a));
      localHashMap.put("loanOrderNo", this.h);
      localHashMap.put("macAddr", ah.getMac(this.a));
      localHashMap.put("mobileBrands", Build.MODEL);
      localHashMap.put("osType", "android");
      localHashMap.put("requestOtp", paramString);
      j.confirmLoanContract(this.a, localHashMap, new d(this.a, new f(com.alibaba.fastjson.e.class))
      {
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          OwnerVerifyPop.a(OwnerVerifyPop.this, 0);
          OwnerVerifyPop.a(OwnerVerifyPop.this);
        }
      });
      return;
      if (str.startsWith("0000000")) {
        UUID.randomUUID().toString();
      }
    }
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loanOrderNo", this.h);
    j.queryWeChatLoginStatus(this.a, localHashMap, new d(this.a, new f(WeChatLoginStatusBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, WeChatLoginStatusBean paramAnonymousWeChatLoginStatusBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousWeChatLoginStatusBean);
        OwnerVerifyPop.b(OwnerVerifyPop.this);
        if (paramAnonymousWeChatLoginStatusBean == null) {
          g.textToast(OwnerVerifyPop.c(OwnerVerifyPop.this), "服务器异常，正在努力抢修中，请稍后再试!");
        }
        do
        {
          return;
          if (!"succ".equals(paramAnonymousWeChatLoginStatusBean.getResult())) {
            break;
          }
          paramAnonymousWeChatLoginStatusBean = new Intent(OwnerVerifyPop.c(OwnerVerifyPop.this), OwnerContractConfirmActivity.class);
          paramAnonymousWeChatLoginStatusBean.putExtra("contractCode", OwnerVerifyPop.d(OwnerVerifyPop.this));
          paramAnonymousWeChatLoginStatusBean.putExtra("isLoan", 1);
          OwnerVerifyPop.c(OwnerVerifyPop.this).startActivity(paramAnonymousWeChatLoginStatusBean);
        } while (OwnerVerifyPop.e(OwnerVerifyPop.this) == null);
        OwnerVerifyPop.e(OwnerVerifyPop.this).onFinish();
        return;
        if ("fail".equals(paramAnonymousWeChatLoginStatusBean.getResult()))
        {
          g.textToast(OwnerVerifyPop.c(OwnerVerifyPop.this), paramAnonymousWeChatLoginStatusBean.getDesc());
          OwnerVerifyPop.f(OwnerVerifyPop.this);
          return;
        }
        OwnerVerifyPop.f(OwnerVerifyPop.this);
      }
    });
  }
  
  private void c()
  {
    if (this.m == 3)
    {
      g.textToast(this.a, "服务器异常，正在努力抢修中，请稍后再试!");
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        SystemClock.sleep(2000L);
        OwnerVerifyPop.g(OwnerVerifyPop.this).sendEmptyMessage(1);
      }
    }).start();
  }
  
  private void d()
  {
    this.f.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)OwnerVerifyPop.c(OwnerVerifyPop.this).getSystemService("input_method");
        localInputMethodManager.showSoftInput(OwnerVerifyPop.i(OwnerVerifyPop.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 100L);
  }
  
  private void e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loanOrderNo", this.h);
    j.getOwnerVerifyCode(this.a, localHashMap, new d(this.a, new com.ziroom.ziroomcustomer.e.c.e(Object.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        OwnerVerifyPop.a(OwnerVerifyPop.this, false);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        OwnerVerifyPop.j(OwnerVerifyPop.this);
        OwnerVerifyPop.k(OwnerVerifyPop.this);
      }
    });
  }
  
  private void f()
  {
    if (this.o == null) {
      this.o = new a(60000L, 1000L);
    }
    this.o.start();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      dismiss();
      return;
    } while (this.k);
    this.k = true;
    e();
  }
  
  public void setOnFinishListener(b paramb)
  {
    this.l = paramb;
  }
  
  public void show(View paramView, String paramString1, String paramString2, String paramString3)
  {
    this.e.setText(paramString2);
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    if (!(this instanceof PopupWindow)) {
      super.showAtLocation(paramView, 0, 0, 0);
    }
    for (;;)
    {
      this.g.post(new Runnable()
      {
        public void run()
        {
          OwnerVerifyPop.g(OwnerVerifyPop.this).sendEmptyMessage(0);
        }
      });
      return;
      VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
    }
  }
  
  private class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      OwnerVerifyPop.l(OwnerVerifyPop.this).setBackgroundResource(2130839656);
      OwnerVerifyPop.l(OwnerVerifyPop.this).setText("获取验证码");
      OwnerVerifyPop.a(OwnerVerifyPop.this, false);
    }
    
    public void onTick(long paramLong)
    {
      OwnerVerifyPop.l(OwnerVerifyPop.this).setBackgroundResource(2130839644);
      int i = (int)(paramLong / 1000L);
      OwnerVerifyPop.l(OwnerVerifyPop.this).setText(i + "s重新获取验证码");
    }
  }
  
  public static abstract interface b
  {
    public abstract void onFinish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/OwnerVerifyPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */