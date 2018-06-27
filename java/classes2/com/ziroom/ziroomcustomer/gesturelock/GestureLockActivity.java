package com.ziroom.ziroomcustomer.gesturelock;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.gesturelock.view.GestureLockMiniView;
import com.ziroom.ziroomcustomer.gesturelock.view.GestureLockViewGroup;
import com.ziroom.ziroomcustomer.gesturelock.view.a.d;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyAccountActivity;

public class GestureLockActivity
  extends BaseActivity
{
  Handler a = new Handler();
  Runnable b = new Runnable()
  {
    public void run()
    {
      if (GestureLockActivity.this.gestureLockViewGroup.b) {
        GestureLockActivity.this.gestureLockViewGroup.resetView();
      }
    }
  };
  private boolean c = false;
  private int d = 100000;
  private String e;
  private int f;
  private String g;
  @BindView(2131690683)
  public GestureLockMiniView gestureLockPathView;
  @BindView(2131690686)
  public GestureLockViewGroup gestureLockViewGroup;
  @BindView(2131690682)
  View rl_container;
  @BindView(2131690684)
  SimpleDraweeView sdv_userIcon;
  @BindView(2131690685)
  TextView tv_errorView;
  @BindView(2131690687)
  TextView tv_forgotten;
  @BindView(2131695950)
  TextView tv_rightButton;
  @BindView(2131695949)
  TextView tv_title;
  
  private void b()
  {
    String str = com.ziroom.commonlibrary.login.a.getToken(this);
    if (!TextUtils.isEmpty(str)) {
      j.getGestureLock(this, str, new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
      {
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            if (!Boolean.valueOf(paramAnonymouse.getString("isOpen")).booleanValue()) {
              break label100;
            }
            paramAnonymouse = paramAnonymouse.getString("password");
            GestureLockActivity.this.gestureLockViewGroup.savePassword(paramAnonymouse);
            GestureLockActivity.this.gestureLockViewGroup.loadPasswordStatus();
            GestureLockActivity.a(GestureLockActivity.this, 2);
            GestureLockActivity.this.tv_errorView.setText("");
          }
          for (;;)
          {
            GestureLockActivity.this.initTitle();
            GestureLockActivity.this.a();
            GestureLockActivity.this.rl_container.setVisibility(0);
            return;
            label100:
            GestureLockActivity.a(GestureLockActivity.this, 1);
            GestureLockActivity.this.tv_errorView.setText("为了您的门锁安全，请先设置手势密码");
          }
        }
      });
    }
  }
  
  private void d(String paramString)
  {
    GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImage(2130839162).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImage(2130839162).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
    this.sdv_userIcon.setHierarchy(localGenericDraweeHierarchy);
    this.sdv_userIcon.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
  }
  
  private void e()
  {
    j();
    i();
    k();
    l();
    if (this.f == 1)
    {
      this.gestureLockViewGroup.clearLocalPwdInfo();
      m();
    }
  }
  
  private void f()
  {
    if (this.f == 1)
    {
      this.sdv_userIcon.setVisibility(8);
      this.tv_forgotten.setVisibility(8);
      this.gestureLockPathView.setVisibility(0);
      this.tv_errorView.setTextColor(Color.parseColor("#FFA000"));
      this.tv_errorView.setText("为了您的门锁安全，请先设置手势密码");
      this.gestureLockPathView.resetPath();
    }
    while (this.f != 2) {
      return;
    }
    this.sdv_userIcon.setVisibility(0);
    this.gestureLockPathView.setVisibility(8);
    this.tv_forgotten.setVisibility(0);
    this.tv_forgotten.setText("忘记手势密码？");
    d(ApplicationEx.c.getUser().getHeadImg());
    this.tv_errorView.setText("请输入原手势密码");
    if (this.e != null) {
      this.tv_errorView.setText("");
    }
    this.tv_errorView.setTextColor(Color.parseColor("#FFA000"));
  }
  
  private void g()
  {
    if (this.f == 1)
    {
      h();
      return;
    }
    if (this.e == null)
    {
      this.gestureLockViewGroup.resetView();
      this.f = 1;
      initTitle();
      a();
      this.tv_errorView.setText("验证成功，请先设置您的手势密码");
      this.gestureLockViewGroup.removePassword();
      return;
    }
    try
    {
      if ((this.g != null) && (this.g.equals(MyAccountActivity.class.getName())))
      {
        this.f = 1;
        initTitle();
        f();
        this.gestureLockViewGroup.clearLocalPwdInfo();
        return;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
      startActivity(new Intent(this, Class.forName(this.e)));
      finish();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void h()
  {
    String str = com.ziroom.commonlibrary.login.a.getToken(this);
    if (!TextUtils.isEmpty(str)) {
      j.setGestureLock(this, str, this.gestureLockViewGroup.getPassword(), new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          String str = paramAnonymousThrowable.getMessage();
          paramAnonymousThrowable = str;
          if (TextUtils.isEmpty(str)) {
            paramAnonymousThrowable = "ERROR";
          }
          g.textToast(GestureLockActivity.this, paramAnonymousThrowable);
          GestureLockActivity.a(GestureLockActivity.this, 1);
          GestureLockActivity.this.initTitle();
          GestureLockActivity.this.a();
          GestureLockActivity.this.gestureLockPathView.resetPath();
          GestureLockActivity.this.gestureLockViewGroup.removePassword();
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (GestureLockActivity.a(GestureLockActivity.this) != null) {
            try
            {
              paramAnonymouse = Toast.makeText(GestureLockActivity.this, "手势密码创建成功!", 0);
              if (!(paramAnonymouse instanceof Toast)) {
                paramAnonymouse.show();
              }
              for (;;)
              {
                GestureLockActivity.this.tv_errorView.setText("手势密码创建成功!");
                paramAnonymouse = new Intent(GestureLockActivity.this, Class.forName(GestureLockActivity.a(GestureLockActivity.this)));
                GestureLockActivity.this.startActivity(paramAnonymouse);
                GestureLockActivity.this.finish();
                return;
                VdsAgent.showToast((Toast)paramAnonymouse);
              }
              GestureLockActivity.this.finish();
            }
            catch (ClassNotFoundException paramAnonymouse)
            {
              paramAnonymouse.printStackTrace();
              return;
            }
          }
        }
      });
    }
  }
  
  private void i()
  {
    this.gestureLockViewGroup.setGesturePasswordSettingListener(new com.ziroom.ziroomcustomer.gesturelock.view.a.b()
    {
      public void onFail()
      {
        GestureLockActivity.this.tv_errorView.setText("与首次输入不一致，请重新输入");
      }
      
      public boolean onFirstInputComplete(int paramAnonymousInt)
      {
        Log.d("GestureLockActivity", "onFirstInputComplete");
        if (paramAnonymousInt > 4)
        {
          GestureLockActivity.this.tv_errorView.setText("首次记录成功，请再次输入密码");
          return true;
        }
        GestureLockActivity.this.tv_errorView.setText("最少连接5个点，请重新输入");
        return false;
      }
      
      public void onSuccess()
      {
        GestureLockActivity.b(GestureLockActivity.this);
      }
    });
  }
  
  private void j()
  {
    this.gestureLockViewGroup.setGestureEventListener(new com.ziroom.ziroomcustomer.gesturelock.view.a.a()
    {
      public void onGestureEvent(boolean paramAnonymousBoolean)
      {
        Log.d("GestureLockActivity", "onGestureEvent matched: " + paramAnonymousBoolean);
        if (!paramAnonymousBoolean)
        {
          GestureLockActivity.this.tv_errorView.setTextColor(Color.parseColor("#F03E3E"));
          GestureLockActivity.this.tv_errorView.setText("密码输入错误，请重新输入");
          GestureLockActivity.this.a.removeCallbacks(GestureLockActivity.this.b);
          GestureLockActivity.this.a.postDelayed(GestureLockActivity.this.b, 2000L);
          return;
        }
        if (GestureLockActivity.c(GestureLockActivity.this))
        {
          GestureLockActivity.a(GestureLockActivity.this, false);
          GestureLockActivity.this.tv_errorView.setText("");
          GestureLockActivity.d(GestureLockActivity.this);
          return;
        }
        GestureLockActivity.this.tv_errorView.setTextColor(Color.parseColor("#FFA000"));
        GestureLockActivity.this.tv_errorView.setText("手势密码正确!");
        GestureLockActivity.b(GestureLockActivity.this);
      }
    });
  }
  
  private void k()
  {
    this.gestureLockViewGroup.setGestureUnmatchedExceedListener(this.d, new com.ziroom.ziroomcustomer.gesturelock.view.a.e()
    {
      public void onUnmatchedExceedBoundary() {}
    });
  }
  
  private void l()
  {
    this.gestureLockViewGroup.setResetListener(new d()
    {
      public void onReset() {}
    });
  }
  
  private void m()
  {
    this.gestureLockViewGroup.setCurrentPathListener(new com.ziroom.ziroomcustomer.gesturelock.view.a.c()
    {
      public void clearPath()
      {
        GestureLockActivity.this.gestureLockPathView.resetPath();
      }
      
      public void drawCurrentPath(String paramAnonymousString)
      {
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          int[] arrayOfInt = new int[paramAnonymousString.length()];
          int i = 0;
          while (i < arrayOfInt.length)
          {
            arrayOfInt[i] = Integer.valueOf(String.valueOf(paramAnonymousString.charAt(i))).intValue();
            i += 1;
          }
          GestureLockActivity.this.gestureLockPathView.setCurrentPath(arrayOfInt);
        }
      }
    });
  }
  
  private void n()
  {
    this.gestureLockViewGroup.removePassword();
    this.gestureLockViewGroup.resetView();
  }
  
  void a()
  {
    f();
    e();
  }
  
  public void initTitle()
  {
    if (this.f == 1) {
      this.tv_title.setText("设置手势密码");
    }
    for (;;)
    {
      this.tv_rightButton.setVisibility(8);
      return;
      if (this.f == 2) {
        this.tv_title.setText("手势密码");
      } else {
        this.tv_title.setText("手势密码");
      }
    }
  }
  
  @OnClick({2131690687, 2131695948})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690687: 
      this.gestureLockPathView.resetPath();
      this.tv_forgotten.setText("忘记手势密码？");
      paramView = new Intent(this, LoginPwdVerifyActivity.class);
      paramView.putExtra("to", this.e);
      paramView.putExtra("from", this.g);
      startActivity(paramView);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903192);
    ButterKnife.bind(this);
    this.e = getIntent().getStringExtra("to");
    this.f = getIntent().getIntExtra("type", -1);
    this.g = getIntent().getStringExtra("from");
    initTitle();
    this.rl_container.setVisibility(8);
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/gesturelock/GestureLockActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */