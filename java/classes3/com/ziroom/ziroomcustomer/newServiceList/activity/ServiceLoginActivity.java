package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import java.util.UUID;

public class ServiceLoginActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private a A;
  private com.ziroom.commonlibrary.a.a.b<Bitmap> B = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.a())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      ServiceLoginActivity.k(ServiceLoginActivity.this).setImageDrawable(ServiceLoginActivity.this.getResources().getDrawable(2130838231));
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(ServiceLoginActivity.b(ServiceLoginActivity.this), ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousBitmap);
      if (paramAnonymousBitmap != null)
      {
        ServiceLoginActivity.k(ServiceLoginActivity.this).setImageBitmap(paramAnonymousBitmap);
        return;
      }
      ServiceLoginActivity.k(ServiceLoginActivity.this).setImageDrawable(ServiceLoginActivity.this.getResources().getDrawable(2130838231));
    }
  };
  private com.ziroom.commonlibrary.a.a.a<e> C = new com.ziroom.commonlibrary.a.a.a(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        ServiceLoginActivity.this.showToast(paramAnonymousThrowable.getMessage());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null)
      {
        com.ziroom.commonlibrary.login.a.setLoginInfo(this.b, paramAnonymouse.getString("token"), paramAnonymouse.getString("uid"));
        Intent localIntent = new Intent("com.ziroom.commonlibrary.login.broadcast");
        localIntent.putExtra("type", 1);
        localIntent.putExtra("token", paramAnonymouse.getString("token"));
        localIntent.putExtra("uid", paramAnonymouse.getString("uid"));
        LocalBroadcastManager.getInstance(this.b).sendBroadcast(localIntent);
      }
    }
  };
  private com.ziroom.commonlibrary.a.a.a<e> D = new com.ziroom.commonlibrary.a.a.a(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if (ServiceLoginActivity.a(ServiceLoginActivity.this) != null)
      {
        if (ServiceLoginActivity.a(ServiceLoginActivity.this).isShowing()) {
          ServiceLoginActivity.a(ServiceLoginActivity.this).dismiss();
        }
        ServiceLoginActivity.a(ServiceLoginActivity.this, null);
      }
      String str;
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
      {
        str = ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode();
        paramAnonymousThrowable = ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getData();
        if (("40001".equals(str)) && (paramAnonymousThrowable != null) && (paramAnonymousThrowable.containsKey("needImgVCode")) && (paramAnonymousThrowable.getBoolean("needImgVCode").booleanValue()))
        {
          if (ServiceLoginActivity.a(ServiceLoginActivity.this) != null) {
            ServiceLoginActivity.a(ServiceLoginActivity.this).dismiss();
          }
          ServiceLoginActivity.l(ServiceLoginActivity.this);
          com.ziroom.commonlibrary.d.a.verifyImgCodeGet(this.b, ServiceLoginActivity.f(ServiceLoginActivity.this), ServiceLoginActivity.m(ServiceLoginActivity.this));
        }
      }
      else
      {
        return;
      }
      com.ziroom.commonlibrary.g.a.a.handleMessage(this.b, str);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (ServiceLoginActivity.a(ServiceLoginActivity.this) != null)
      {
        if (ServiceLoginActivity.a(ServiceLoginActivity.this).isShowing()) {
          ServiceLoginActivity.a(ServiceLoginActivity.this).dismiss();
        }
        ServiceLoginActivity.a(ServiceLoginActivity.this, null);
      }
      if ((paramAnonymouse != null) && (ServiceLoginActivity.a(ServiceLoginActivity.this) != null)) {
        ServiceLoginActivity.a(ServiceLoginActivity.this).dismiss();
      }
    }
  };
  private BroadcastReceiver E = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17)
      {
        ServiceLoginActivity.this.dismissProgress();
        g.textToast(ServiceLoginActivity.this.getApplicationContext(), ServiceLoginActivity.this.getString(2131296934));
        ServiceLoginActivity.this.finish();
      }
    }
  };
  protected boolean a = false;
  private EditText b;
  private TextView c;
  private EditText d;
  private Button e;
  private TextView f;
  private ImageView g;
  private Context r;
  private LinearLayout s;
  private String t;
  private AlertDialog u;
  private ImageButton v;
  private String w;
  private String x;
  private String y;
  private int z;
  
  private void a()
  {
    this.b = ((EditText)findViewById(2131690583));
    this.c = ((TextView)findViewById(2131690585));
    this.d = ((EditText)findViewById(2131690584));
    this.e = ((Button)findViewById(2131690586));
    this.f = ((TextView)findViewById(2131692331));
    this.g = ((ImageView)findViewById(2131690588));
    this.s = ((LinearLayout)findViewById(2131690587));
    this.f = ((TextView)findViewById(2131692331));
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ServiceLoginActivity.this.finish();
      }
    });
    this.s.setVisibility(8);
    this.s.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.A = new a(120000L, 1000L, this.c);
  }
  
  private void b()
  {
    this.u = new AlertDialog.Builder(this, 2131427599).create();
    View localView = LayoutInflater.from(this).inflate(2130903801, null);
    final EditText localEditText = (EditText)localView.findViewById(2131693800);
    this.v = ((ImageButton)localView.findViewById(2131691126));
    Object localObject1 = (Button)localView.findViewById(2131693670);
    Object localObject2 = (Button)localView.findViewById(2131693671);
    ((Button)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ServiceLoginActivity.a(ServiceLoginActivity.this, "");
        ServiceLoginActivity.a(ServiceLoginActivity.this, null);
        if (ServiceLoginActivity.a(ServiceLoginActivity.this) != null) {
          ServiceLoginActivity.a(ServiceLoginActivity.this).dismiss();
        }
        ServiceLoginActivity.a(ServiceLoginActivity.this, null);
      }
    });
    ((Button)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = VdsAgent.trackEditTextSilent(localEditText).toString().trim();
        if (TextUtils.isEmpty(paramAnonymousView))
        {
          ServiceLoginActivity.this.showToast("请输入验证码");
          return;
        }
        ServiceLoginActivity.a(ServiceLoginActivity.this, paramAnonymousView);
        ServiceLoginActivity.a(ServiceLoginActivity.this, 5);
        com.ziroom.commonlibrary.d.a.verifyCodeGetV2(ServiceLoginActivity.b(ServiceLoginActivity.this), ServiceLoginActivity.c(ServiceLoginActivity.this), ServiceLoginActivity.d(ServiceLoginActivity.this), ServiceLoginActivity.e(ServiceLoginActivity.this), ServiceLoginActivity.f(ServiceLoginActivity.this), ServiceLoginActivity.g(ServiceLoginActivity.this), ServiceLoginActivity.h(ServiceLoginActivity.this));
      }
    });
    this.v.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ServiceLoginActivity.i(ServiceLoginActivity.this);
      }
    });
    localObject1 = this.u;
    if (!(localObject1 instanceof AlertDialog)) {
      ((AlertDialog)localObject1).show();
    }
    for (;;)
    {
      e();
      localObject1 = this.u.getWindow();
      ((Window)localObject1).clearFlags(131072);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = ((int)(getResources().getDisplayMetrics().density * 245.0F + 0.5F));
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      ((Window)localObject1).setContentView(localView);
      localEditText.setFocusable(true);
      localEditText.setFocusableInTouchMode(true);
      localEditText.requestFocus();
      return;
      VdsAgent.showDialog((AlertDialog)localObject1);
    }
  }
  
  private void e()
  {
    this.w = UUID.randomUUID().toString();
    com.ziroom.commonlibrary.d.a.verifyImgCodeGet(this, this.w, this.B);
  }
  
  private void f()
  {
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.r);
    finish();
    w.onEvent(this.r, "smslogin_passportlogin");
  }
  
  private void g()
  {
    this.y = VdsAgent.trackEditTextSilent(this.b).toString();
    if ((ae.isNull(this.y)) || (!ah.isMobile(this.y)))
    {
      showToast("请输入正确的手机号！");
      return;
    }
    new Handler().post(new Runnable()
    {
      public void run()
      {
        ServiceLoginActivity.j(ServiceLoginActivity.this).start();
      }
    });
    this.z = 5;
    this.w = "";
    this.x = "";
    com.ziroom.commonlibrary.d.a.verifyCodeGetV2(this.r, this.y, this.t, this.z, this.w, this.x, this.D);
  }
  
  private void h()
  {
    this.y = VdsAgent.trackEditTextSilent(this.b).toString();
    String str = VdsAgent.trackEditTextSilent(this.d).toString();
    if ((ae.isNull(this.y)) || (!ah.isMobile(this.y)))
    {
      showToast("请输入正确的手机号！");
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      showToast("请先输入验证码");
      return;
    }
    com.ziroom.commonlibrary.d.a.loginDynamic(this.r, this.y, str, 5, this.C);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690585: 
      g();
      return;
    case 2131690586: 
      h();
      return;
    case 2131690587: 
      finish();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.r = this;
    setContentView(2130903477);
    a();
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.E, paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(this.E);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  class a
    extends CountDownTimer
  {
    TextView a;
    
    public a(long paramLong1, long paramLong2, TextView paramTextView)
    {
      super(paramLong2);
      this.a = paramTextView;
    }
    
    public void onFinish()
    {
      this.a.setText("重新验证");
      this.a.setClickable(true);
    }
    
    public void onTick(long paramLong)
    {
      this.a.setClickable(false);
      this.a.setText(paramLong / 1000L + "秒");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/ServiceLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */