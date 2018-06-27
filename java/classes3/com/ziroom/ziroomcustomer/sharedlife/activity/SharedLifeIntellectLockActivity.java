package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.sharedlife.b.a.a;
import com.ziroom.ziroomcustomer.sharedlife.c.h;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.CircleWaveView;
import java.util.Timer;
import java.util.TimerTask;

public class SharedLifeIntellectLockActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private TextView C;
  private ImageView D;
  private ImageView E;
  private Timer F;
  private Thread G;
  private String H;
  private String I;
  private h J;
  private com.ziroom.ziroomcustomer.sharedlife.b.a K;
  private boolean L = false;
  public ImageView a;
  public CircleWaveView b;
  Handler c = new Handler();
  boolean d = false;
  boolean e = false;
  boolean f = false;
  a g;
  int r = 59;
  private Context s;
  private TextView t;
  private TextView u;
  private ImageView v;
  private TextView w;
  private RelativeLayout x;
  private RelativeLayout y;
  private TextView z;
  
  private void a(String paramString, final int paramInt)
  {
    c.newBuilder(this.s).setTitle("提示").setContent(paramString).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          if (paramInt != 1) {
            break label20;
          }
          SharedLifeIntellectLockActivity.d(SharedLifeIntellectLockActivity.this);
        }
        label20:
        while (paramInt != 2) {
          return;
        }
        SharedLifeIntellectLockActivity.e(SharedLifeIntellectLockActivity.this);
      }
    }).build().show();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.x.setBackgroundResource(2130838876);
      this.b.setVisibility(0);
      if ((this.r > 0) && (this.r < 59))
      {
        this.a.setOnClickListener(null);
        return;
      }
      this.a.setOnClickListener(this);
      return;
    }
    this.x.setBackgroundResource(2130837723);
    this.b.setVisibility(4);
    this.b.stopAnimat();
    this.b.setTag(null);
    this.a.setOnClickListener(null);
  }
  
  private void b()
  {
    this.u = ((TextView)findViewById(2131692371));
    this.D = ((ImageView)findViewById(2131692373));
    this.a = ((ImageView)findViewById(2131692365));
    this.t = ((TextView)findViewById(2131692361));
    this.b = ((CircleWaveView)findViewById(2131692363));
    this.v = ((ImageView)findViewById(2131692370));
    this.x = ((RelativeLayout)findViewById(2131692364));
    this.y = ((RelativeLayout)findViewById(2131692360));
    this.z = ((TextView)findViewById(2131692366));
    this.A = ((TextView)findViewById(2131692367));
    this.B = ((TextView)findViewById(2131692374));
    this.w = ((TextView)findViewById(2131692368));
    this.E = ((ImageView)findViewById(2131689492));
    this.C = ((TextView)findViewById(2131689541));
  }
  
  private void d(String paramString)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    com.ziroom.ziroomcustomer.sharedlife.a.changeSharedLifeLockPwd(this, localUserInfo.getUid(), this.H, this.I, paramString, new d(this, new f(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if (SharedLifeIntellectLockActivity.f(SharedLifeIntellectLockActivity.this) != null) {
          SharedLifeIntellectLockActivity.f(SharedLifeIntellectLockActivity.this).dismiss();
        }
        SharedLifeIntellectLockActivity.g(SharedLifeIntellectLockActivity.this);
        g.textToast(SharedLifeIntellectLockActivity.b(SharedLifeIntellectLockActivity.this), "密码下发中", 0);
        SharedLifeIntellectLockActivity.a(SharedLifeIntellectLockActivity.this, true);
        SharedLifeIntellectLockActivity.this.f = true;
      }
    });
  }
  
  private void e()
  {
    this.v.setOnClickListener(this);
    this.E.setOnClickListener(this);
  }
  
  private void f()
  {
    this.H = getIntent().getStringExtra("deviceUuid");
    this.I = getIntent().getStringExtra("rentContractCode");
    String str = getIntent().getStringExtra("deviceTypeName");
    this.C.setText(str);
    g();
  }
  
  private void g()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeLockInfo(this, localUserInfo.getUid(), this.H, this.I, new d(this, new f(h.class))
      {
        public void onSuccess(int paramAnonymousInt, h paramAnonymoush)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymoush);
          if (paramAnonymoush != null)
          {
            SharedLifeIntellectLockActivity.a(SharedLifeIntellectLockActivity.this, paramAnonymoush);
            SharedLifeIntellectLockActivity.a(SharedLifeIntellectLockActivity.this);
          }
        }
      });
    }
  }
  
  private void h()
  {
    this.w.setText(this.J.getLockName());
    int i;
    Drawable localDrawable;
    if (this.J != null)
    {
      this.t.setVisibility(4);
      i = this.J.getLockStatus();
      localDrawable = null;
      if ((i == 0) || (i == 1))
      {
        this.t.setVisibility(0);
        this.t.setTextColor(Color.parseColor("#55FAA9"));
        this.t.setText("点击图标刷新密码状态");
        a(true);
        this.u.setVisibility(0);
        this.v.setImageResource(2130840202);
        int j = this.J.getLockPower();
        this.A.setText("电池电量" + j + "%");
        this.A.setTextColor(Color.parseColor("#FFFFFF"));
        this.z.setTextColor(Color.parseColor("#FFFFFF"));
        if (i == 1)
        {
          this.z.setText("低电");
          localDrawable = this.s.getResources().getDrawable(2130837725);
          this.t.setTextColor(Color.parseColor("#FF6262"));
          this.b.setColor("#FF6262");
          n();
          label225:
          localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
          if (Build.VERSION.SDK_INT < 16) {
            break label561;
          }
          this.x.setBackground(localDrawable);
        }
      }
    }
    for (;;)
    {
      this.D.setImageResource(2130838878);
      this.B.setText("智能锁说明");
      this.B.setOnClickListener(this);
      if (this.L)
      {
        this.L = false;
        if ((this.J != null) && (this.J != null) && (!TextUtils.isEmpty(this.J.getPassWordPrompt()))) {
          g.textToast(this.s, this.J.getPassWordPrompt());
        }
        resetRefreshStyle();
      }
      this.D.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          JsBridgeWebActivity.start(SharedLifeIntellectLockActivity.b(SharedLifeIntellectLockActivity.this), "", SharedLifeIntellectLockActivity.c(SharedLifeIntellectLockActivity.this).getUrl(), false, "", "", false);
        }
      });
      return;
      if (i != 0) {
        break;
      }
      this.z.setText("正常");
      this.b.setColor("#55FAA9");
      this.t.setTextColor(Color.parseColor("#999999"));
      localDrawable = this.s.getResources().getDrawable(2130837724);
      break;
      if (i == 2)
      {
        a(false);
        this.v.setImageResource(2130838880);
        this.u.setTextColor(Color.parseColor("#FF8400"));
        this.u.setText("获取临时密码");
        localDrawable = this.s.getResources().getDrawable(2130837723);
        this.t.setVisibility(8);
        this.z.setText("离线");
        this.z.setTextColor(Color.parseColor("#FFFFFF"));
        this.y.setVisibility(0);
        this.t.setText("门锁离线");
        break label225;
      }
      this.t.setVisibility(0);
      this.t.setTextColor(Color.parseColor("#757575"));
      a(false);
      localDrawable = this.s.getResources().getDrawable(2130837723);
      break label225;
      label561:
      this.x.setBackgroundDrawable(localDrawable);
      continue;
      a(false);
      this.t.setText("无访问权限");
      this.t.setVisibility(0);
      localDrawable = this.s.getResources().getDrawable(2130837723);
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    }
  }
  
  private void i()
  {
    int i = this.J.getLockStatus();
    if (this.J != null)
    {
      if ((i == 0) || (i == 1))
      {
        a("为了保证安全,自如不会存放任何明文密码,请牢记您的自定义密码，您的密码将在两分钟内生效", 1);
        return;
      }
      if (i == 2)
      {
        a("门锁离线,使用临时密码紧急进门,接通门锁基站,可再次获取合同密码", 2);
        return;
      }
      g.textToast(this.s, "密码已冻结，请联系您的管家");
      return;
    }
    g.textToast(this.s, "数据错误", 1);
  }
  
  private void j()
  {
    this.K = new com.ziroom.ziroomcustomer.sharedlife.b.a(this.s);
    this.K.show();
    if (this.K.getGridPwdView() != null) {
      this.K.getGridPwdView().postDelayed(new Runnable()
      {
        public void run()
        {
          SharedLifeIntellectLockActivity.f(SharedLifeIntellectLockActivity.this).getGridPwdView().setFocus();
        }
      }, 200L);
    }
    this.K.setOnPassWordListener(new a.a()
    {
      public void passWord(String paramAnonymousString)
      {
        if ((paramAnonymousString == null) || (paramAnonymousString.length() < 6))
        {
          g.textToast(SharedLifeIntellectLockActivity.b(SharedLifeIntellectLockActivity.this), "请输入六位数密码", 0);
          return;
        }
        SharedLifeIntellectLockActivity.a(SharedLifeIntellectLockActivity.this, paramAnonymousString);
      }
    });
  }
  
  private void k()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    String str1 = localUserInfo.getRealName();
    String str2 = localUserInfo.getPhone();
    com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeLockTempPwd(this, localUserInfo.getUid(), this.H, this.I, str1, str2, new d(this, new f(com.ziroom.ziroomcustomer.sharedlife.c.i.class))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.sharedlife.c.i paramAnonymousi)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousi);
        if (paramAnonymousi != null)
        {
          String str = paramAnonymousi.getPassword();
          paramAnonymousi = paramAnonymousi.getInvalidTime() + "";
          paramAnonymousi = "临时密码:" + str + "\n截止时间:" + paramAnonymousi;
          g.textToast(SharedLifeIntellectLockActivity.b(SharedLifeIntellectLockActivity.this), paramAnonymousi, 1);
        }
      }
    });
  }
  
  private void l()
  {
    a();
    if (this.F == null) {
      this.F = new Timer();
    }
    this.g = new a();
    this.F.schedule(this.g, 1000L, 1000L);
    if (ad.getLockLeftTime(this.s) == 0) {
      this.t.setText("60秒后可刷新状态...");
    }
    for (;;)
    {
      ad.saveLockTime(this.s, "", 0);
      this.t.setTextColor(Color.parseColor("#757575"));
      m();
      this.a.setOnClickListener(null);
      this.d = true;
      return;
      if ((this.r > 0) && (this.r < 60)) {
        this.t.setText(this.r + "秒后可刷新状态...");
      }
    }
  }
  
  private void m()
  {
    this.v.setImageResource(2130838877);
    this.v.setOnClickListener(null);
  }
  
  private void n()
  {
    if (this.b.getTag() == null)
    {
      this.b.setTag("true");
      this.G = new Thread(this.b);
      this.b.setThread(this.G);
      this.b.startAnimat();
    }
  }
  
  private void o()
  {
    if (com.ziroom.ziroomcustomer.sharedlife.d.a.getLeftTime(this.s) > 0)
    {
      this.r = com.ziroom.ziroomcustomer.sharedlife.d.a.getLeftTime(this.s);
      l();
    }
  }
  
  void a()
  {
    if (this.F != null) {
      this.F.purge();
    }
    if (this.g != null) {
      this.g.cancel();
    }
    this.e = false;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692370: 
      i();
      return;
    case 2131692365: 
      this.L = true;
      l();
      g();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903489);
    this.s = this;
    b();
    e();
    f();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.b != null) && (this.b.getVisibility() == 0)) {
      this.b.stopAnimat();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.e)
    {
      String str = com.ziroom.ziroomcustomer.newServiceList.utils.i.getNowDateTime();
      ad.saveLockTime(this.s, str, this.r);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    o();
  }
  
  public void resetRefreshStyle()
  {
    a();
    this.t.setText("点击图标刷新密码状态");
    if (this.J != null)
    {
      if (this.J.getLockStatus() != 1) {
        break label78;
      }
      this.t.setTextColor(Color.parseColor("#FF6262"));
    }
    for (;;)
    {
      this.v.setOnClickListener(this);
      this.v.setImageResource(2130840202);
      this.a.setOnClickListener(this);
      this.r = 59;
      return;
      label78:
      this.t.setTextColor(Color.parseColor("#999999"));
    }
  }
  
  class a
    extends TimerTask
  {
    a() {}
    
    public void run()
    {
      SharedLifeIntellectLockActivity.this.c.post(new Runnable()
      {
        public void run()
        {
          if (SharedLifeIntellectLockActivity.this.r > 0)
          {
            TextView localTextView = SharedLifeIntellectLockActivity.h(SharedLifeIntellectLockActivity.this);
            StringBuilder localStringBuilder = new StringBuilder();
            SharedLifeIntellectLockActivity localSharedLifeIntellectLockActivity = SharedLifeIntellectLockActivity.this;
            int i = localSharedLifeIntellectLockActivity.r;
            localSharedLifeIntellectLockActivity.r = (i - 1);
            localTextView.setText(i + "秒后可刷新状态...");
            SharedLifeIntellectLockActivity.this.e = true;
            return;
          }
          SharedLifeIntellectLockActivity.this.r = 0;
          SharedLifeIntellectLockActivity.this.a();
          SharedLifeIntellectLockActivity.this.resetRefreshStyle();
          if (SharedLifeIntellectLockActivity.this.f)
          {
            SharedLifeIntellectLockActivity.this.f = false;
            SharedLifeIntellectLockActivity.i(SharedLifeIntellectLockActivity.this);
          }
          SharedLifeIntellectLockActivity.this.d = true;
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeIntellectLockActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */