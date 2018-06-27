package com.ziroom.commonlibrary.login;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.ziroom.commonlib.utils.m;
import com.ziroom.commonlibrary.R.drawable;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.string;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import java.util.HashMap;
import java.util.UUID;

public class LoginActivity
  extends BaseLoginActivity
  implements CompoundButton.OnCheckedChangeListener, PlatformActionListener
{
  private boolean A = true;
  private boolean B = true;
  private boolean C = true;
  private boolean D;
  private String E;
  private int F;
  private String G;
  private String H;
  private String I;
  private boolean J;
  private LoginLabeledEditText.a K = new LoginLabeledEditText.a()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (paramAnonymousEditable.length() == 0) {
        LoginActivity.b(LoginActivity.this, true);
      }
      for (;;)
      {
        LoginActivity.j(LoginActivity.this);
        return;
        LoginActivity.b(LoginActivity.this, false);
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private LoginLabeledEditText.a L = new LoginLabeledEditText.a()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      LoginActivity localLoginActivity = LoginActivity.this;
      boolean bool;
      if (paramAnonymousEditable.length() <= 0)
      {
        bool = true;
        LoginActivity.c(localLoginActivity, bool);
        if (!LoginActivity.k(LoginActivity.this)) {
          break label57;
        }
        LoginActivity.l(LoginActivity.this).setVisibility(8);
      }
      for (;;)
      {
        LoginActivity.j(LoginActivity.this);
        return;
        bool = false;
        break;
        label57:
        LoginActivity.l(LoginActivity.this).setVisibility(0);
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private LoginLabeledEditText.a M = new LoginLabeledEditText.a()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      LoginActivity localLoginActivity = LoginActivity.this;
      if (paramAnonymousEditable.length() <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        LoginActivity.d(localLoginActivity, bool);
        LoginActivity.j(LoginActivity.this);
        return;
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private com.ziroom.commonlibrary.a.a.a N = new com.ziroom.commonlibrary.a.a.a(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      LoginActivity.this.dismissProgress();
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
      {
        e locale = ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getData();
        if ((locale != null) && (locale.containsKey("etTimes")))
        {
          if (locale.getInteger("etTimes").intValue() < 5) {
            break label181;
          }
          LoginActivity.p(LoginActivity.this);
          LoginActivity.r(LoginActivity.this).addTextChangedListener(LoginActivity.q(LoginActivity.this));
          LoginActivity.s(LoginActivity.this).setVisibility(0);
          LoginActivity.r(LoginActivity.this).setText("");
        }
      }
      for (;;)
      {
        paramAnonymousThrowable = ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode();
        if ((LoginActivity.t(LoginActivity.this) != 2) || (!paramAnonymousThrowable.equals("40004"))) {
          break;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(LoginActivity.this).setTitle("提示").setContent(LoginActivity.this.getString(R.string.login_msg_phone_unregister)).setBtnConfirmText("直接注册").setBtnCancelText("知道了").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean)
            {
              paramAnonymous2View = new Intent(LoginActivity.this, PhoneMailActivity.class);
              paramAnonymous2View.putExtra("PhoneMailActivity_type", 1);
              LoginActivity.this.startActivity(paramAnonymous2View);
            }
          }
        }).build().show();
        return;
        label181:
        LoginActivity.r(LoginActivity.this).removeTextChangedListener();
        LoginActivity.s(LoginActivity.this).setVisibility(8);
      }
      if ((LoginActivity.t(LoginActivity.this) == 3) && (paramAnonymousThrowable.equals("40004")))
      {
        com.ziroom.commonlibrary.g.a.a.handleMessage(LoginActivity.this, paramAnonymousThrowable, LoginActivity.this.getString(R.string.login_msg_email_unregister));
        return;
      }
      if ((LoginActivity.t(LoginActivity.this) == 1) && (paramAnonymousThrowable.equals("40004")))
      {
        com.ziroom.commonlibrary.g.a.a.handleMessage(LoginActivity.this, paramAnonymousThrowable, LoginActivity.this.getString(R.string.login_msg_error_password));
        return;
      }
      if (paramAnonymousThrowable.equals("40010"))
      {
        new LoginActivity.a(LoginActivity.this, null).execute(new Integer[] { Integer.valueOf(LoginActivity.m(LoginActivity.this)), Integer.valueOf(1) });
        return;
      }
      com.ziroom.commonlibrary.g.a.a.handleMessage(LoginActivity.this, paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null)
      {
        a.setLoginInfo(LoginActivity.this, paramAnonymouse.getString("token"), paramAnonymouse.getString("uid"));
        m.setLoginInfo(paramAnonymouse.getString("token"), paramAnonymouse.getString("uid"));
        com.ziroom.commonlibrary.g.c.saveLastLoginType(LoginActivity.this, LoginActivity.m(LoginActivity.this));
        m.putLastLoginType(LoginActivity.m(LoginActivity.this));
        Intent localIntent = new Intent("com.ziroom.commonlibrary.login.broadcast");
        localIntent.putExtra("type", 1);
        localIntent.putExtra("token", paramAnonymouse.getString("token"));
        localIntent.putExtra("uid", paramAnonymouse.getString("uid"));
        if (!TextUtils.isEmpty(LoginActivity.n(LoginActivity.this))) {
          localIntent.putExtra("three_head_img", LoginActivity.n(LoginActivity.this));
        }
        if (!TextUtils.isEmpty(LoginActivity.o(LoginActivity.this))) {
          localIntent.putExtra("three_nickname", LoginActivity.o(LoginActivity.this));
        }
        LocalBroadcastManager.getInstance(LoginActivity.this).sendBroadcast(localIntent);
        d.d("LoginActivity", "====sendBroadcast");
        return;
      }
      LoginActivity.this.dismissProgress();
    }
  };
  private com.ziroom.commonlibrary.a.a.b<Bitmap> O = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.a())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(LoginActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      LoginActivity.u(LoginActivity.this).setImageDrawable(LoginActivity.this.getResources().getDrawable(R.drawable.common_login_refresh));
    }
    
    public void onSuccess(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousBitmap);
      if (paramAnonymousBitmap != null)
      {
        LoginActivity.u(LoginActivity.this).setImageBitmap(paramAnonymousBitmap);
        return;
      }
      LoginActivity.u(LoginActivity.this).setImageDrawable(LoginActivity.this.getResources().getDrawable(R.drawable.common_login_refresh));
    }
  };
  private Handler P = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        String str;
        do
        {
          return;
          str = paramAnonymousMessage.getData().getString("userId");
          paramAnonymousMessage = paramAnonymousMessage.getData().getString("accessToken");
        } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramAnonymousMessage)));
        LoginActivity.this.dismissProgress();
        LoginActivity.a(LoginActivity.this, LoginActivity.m(LoginActivity.this), str, paramAnonymousMessage);
        return;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        if (paramAnonymousMessage != null)
        {
          paramAnonymousMessage = paramAnonymousMessage.getString("msg");
          if (!TextUtils.isEmpty(paramAnonymousMessage)) {
            g.textToast(LoginActivity.this, paramAnonymousMessage);
          }
        }
        LoginActivity.this.dismissProgress();
        return;
      } while (!LoginActivity.v(LoginActivity.this));
      LoginActivity.e(LoginActivity.this, false);
      LoginActivity.this.dismissProgress();
    }
  };
  private BroadcastReceiver Q = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17)
      {
        LoginActivity.this.dismissProgress();
        if (paramAnonymousIntent.getIntExtra("status", 0) != 1) {
          break label58;
        }
        g.textToast(LoginActivity.this.getApplicationContext(), LoginActivity.this.getString(R.string.login_msg_login_success));
      }
      for (;;)
      {
        LoginActivity.this.finish();
        return;
        label58:
        a.a(LoginActivity.this);
        m.clearLoginInfo();
      }
    }
  };
  private final String b = "LoginActivity";
  private final int c = 1;
  private final int d = 2;
  private final int e = 3;
  private final int f = 1;
  private final int g = 1;
  private final int h = 2;
  private final int i = 3;
  private LinearLayout j;
  private CheckBox k;
  private LinearLayout l;
  private TextView m;
  private LoginLabeledEditText n;
  private LoginLabeledEditText o;
  private RelativeLayout p;
  private LoginLabeledEditText q;
  private ImageButton r;
  private Button s;
  private View t;
  private View u;
  private View v;
  private float w;
  private float x;
  private boolean y;
  private int z;
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    this.z = paramInt;
    com.ziroom.commonlibrary.d.a.threeLogin(this, paramString1, paramString2, paramInt, this.N);
  }
  
  private void a(Context paramContext)
  {
    final AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext).create();
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.dialog_login_problem, null);
    Object localObject1 = (TextView)paramContext.findViewById(R.id.tv_forget_pass);
    Object localObject2 = (TextView)paramContext.findViewById(R.id.tv_appeal);
    TextView localTextView = (TextView)paramContext.findViewById(R.id.tv_cancel);
    ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LoginActivity.this.a("login_forgetpass");
        paramAnonymousView = new Intent(LoginActivity.this, PhoneMailActivity.class);
        paramAnonymousView.putExtra("PhoneMailActivity_type", 2);
        String str = LoginActivity.w(LoginActivity.this).getText().toString();
        if (!TextUtils.isEmpty(str))
        {
          if (!h.isMobile(str)) {
            break label88;
          }
          paramAnonymousView.putExtra("PhoneMailActivity_phone", str);
        }
        for (;;)
        {
          LoginActivity.this.startActivity(paramAnonymousView);
          localAlertDialog.dismiss();
          return;
          label88:
          if (h.isEmail(str)) {
            paramAnonymousView.putExtra("PhoneMailActivity_email", str);
          }
        }
      }
    });
    ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent("android.intent.action.DIAL");
        paramAnonymousView.setData(Uri.parse("tel:4001001111"));
        LoginActivity.this.startActivity(paramAnonymousView);
        localAlertDialog.dismiss();
      }
    });
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localAlertDialog.dismiss();
      }
    });
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localObject1 = localAlertDialog.getWindow();
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      localAlertDialog.getWindow().setContentView(paramContext);
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  private void a(final View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.0F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        if ((paramView != null) && (paramView.getVisibility() == 8)) {
          paramView.setVisibility(0);
        }
      }
    });
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation);
    }
  }
  
  private void b()
  {
    MobSDK.init(getApplicationContext());
  }
  
  private void b(final View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.0F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (paramView != null) {
      paramView.startAnimation(localScaleAnimation);
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, PhoneMailActivity.class);
    localIntent.putExtra("PhoneMailActivity_type", 9);
    startActivity(localIntent);
  }
  
  private void d()
  {
    this.D = false;
    this.F = 0;
    this.z = 0;
    String str1 = this.n.getText().toString().trim();
    String str2 = this.o.getText().toString().trim();
    String str3 = this.q.getText().toString().trim();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      g.textToast(this, "用户名或密码不能为空！");
      return;
    }
    if (h.isMobile(str1))
    {
      this.D = true;
      this.F = 2;
      showProgress("");
      com.ziroom.commonlibrary.d.a.loginV2(this, null, str1, null, str2, this.G, str3, null, this.N);
      return;
    }
    if (h.isEmail(str1))
    {
      this.F = 3;
      showProgress("");
      com.ziroom.commonlibrary.d.a.loginV2(this, null, null, str1, str2, this.G, str3, null, this.N);
      return;
    }
    if (com.ziroom.commonlibrary.g.b.verifyUsername(str1))
    {
      this.F = 1;
      showProgress("");
      com.ziroom.commonlibrary.d.a.loginV2(this, str1, null, null, str2, this.G, str3, null, this.N);
      return;
    }
    g.textToast(getApplication(), getString(R.string.login_msg_username_phone_email_invalid));
  }
  
  private void e()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.j, "translationY", new float[] { -(this.w + com.freelxl.baselibrary.f.b.dip2px(this, 24.0F)) }), ObjectAnimator.ofFloat(this.l, "alpha", new float[] { 0.0F }) });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.start();
  }
  
  private void f()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.j, "translationY", new float[] { this.x }), ObjectAnimator.ofFloat(this.l, "alpha", new float[] { 1.0F }) });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.start();
  }
  
  private void g()
  {
    if (this.p.getVisibility() == 0)
    {
      if ((this.A) || (this.B) || (this.C))
      {
        this.s.setEnabled(false);
        return;
      }
      this.s.setEnabled(true);
      return;
    }
    if ((this.A) || (this.B))
    {
      this.s.setEnabled(false);
      return;
    }
    this.s.setEnabled(true);
  }
  
  private void h()
  {
    this.G = UUID.randomUUID().toString();
    com.ziroom.commonlibrary.d.a.verifyImgCodeGet(this, this.G, this.O);
  }
  
  protected void a()
  {
    super.a();
    this.j = ((LinearLayout)findViewById(R.id.ll));
    this.k = ((CheckBox)findViewById(R.id.cb_pass_visible));
    this.p = ((RelativeLayout)findViewById(R.id.rl_img_code));
    this.q = ((LoginLabeledEditText)findViewById(R.id.llet_img_code));
    this.r = ((ImageButton)findViewById(R.id.ib_img_code));
    this.k.setChecked(false);
    this.k.setOnCheckedChangeListener(this);
    this.l = ((LinearLayout)findViewById(R.id.ll_slogan));
    this.m = ((TextView)findViewById(R.id.tv_register));
    this.n = ((LoginLabeledEditText)findViewById(R.id.llet_name));
    this.o = ((LoginLabeledEditText)findViewById(R.id.llet_pass));
    this.n.addTextChangedListener(this.K);
    this.o.addTextChangedListener(this.L);
    this.n.setFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          LoginActivity.a(LoginActivity.this, LoginActivity.a(LoginActivity.this));
          return;
        }
        LoginActivity.b(LoginActivity.this, LoginActivity.a(LoginActivity.this));
      }
    });
    this.o.setFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          LoginActivity.a(LoginActivity.this, LoginActivity.b(LoginActivity.this));
          return;
        }
        LoginActivity.b(LoginActivity.this, LoginActivity.b(LoginActivity.this));
      }
    });
    this.q.setFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          LoginActivity.a(LoginActivity.this, LoginActivity.c(LoginActivity.this));
          return;
        }
        LoginActivity.b(LoginActivity.this, LoginActivity.c(LoginActivity.this));
      }
    });
    this.s = ((Button)findViewById(R.id.btn_login));
    this.t = findViewById(R.id.v_divider_name_second);
    this.u = findViewById(R.id.v_divider_pass_second);
    this.v = findViewById(R.id.v_divider_img_code_second);
    switch (com.ziroom.commonlibrary.g.c.getLastLoginType(this))
    {
    }
    for (;;)
    {
      b.setListener(this, new b.a()
      {
        public void keyBoardHide(int paramAnonymousInt)
        {
          if ((LoginActivity.d(LoginActivity.this) < 1.0F) || (Math.abs(LoginActivity.e(LoginActivity.this)) < 1.0F))
          {
            LoginActivity.a(LoginActivity.this, LoginActivity.f(LoginActivity.this).getMeasuredHeight());
            LoginActivity.b(LoginActivity.this, LoginActivity.f(LoginActivity.this).getTranslationY());
          }
          if (LoginActivity.g(LoginActivity.this))
          {
            LoginActivity.i(LoginActivity.this);
            LoginActivity.a(LoginActivity.this, false);
          }
        }
        
        public void keyBoardShow(int paramAnonymousInt)
        {
          if ((LoginActivity.d(LoginActivity.this) < 1.0F) || (Math.abs(LoginActivity.e(LoginActivity.this)) < 1.0F))
          {
            LoginActivity.a(LoginActivity.this, LoginActivity.f(LoginActivity.this).getMeasuredHeight());
            LoginActivity.b(LoginActivity.this, LoginActivity.f(LoginActivity.this).getTranslationY());
          }
          if (!LoginActivity.g(LoginActivity.this))
          {
            LoginActivity.a(LoginActivity.this, true);
            LoginActivity.h(LoginActivity.this);
          }
        }
      });
      this.E = getIntent().getStringExtra("LoginActivity_phone");
      if (!TextUtils.isEmpty(this.E))
      {
        this.n.setText(this.E);
        this.n.setSelection(this.E.length());
      }
      return;
      findViewById(R.id.iv_last_qq).setVisibility(0);
      continue;
      findViewById(R.id.iv_last_wechat).setVisibility(0);
      continue;
      findViewById(R.id.iv_last_weibo).setVisibility(0);
    }
  }
  
  public void onBtnClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.ib_wechat)
    {
      a("weChat_login");
      new a(null).execute(new Integer[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
    do
    {
      return;
      if (i1 == R.id.ib_qq)
      {
        a("QQ_login");
        new a(null).execute(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) });
        return;
      }
      if (i1 == R.id.ib_weibo)
      {
        a("weibo_login");
        new a(null).execute(new Integer[] { Integer.valueOf(3), Integer.valueOf(1) });
        return;
      }
      if (i1 == R.id.btn_login)
      {
        a("login_Accountpass_finish");
        d();
        return;
      }
      if (i1 == R.id.iv_login_back)
      {
        a("login_back");
        finish();
        return;
      }
      if (i1 == R.id.tv_problem)
      {
        a(this);
        return;
      }
      if (i1 == R.id.tv_register)
      {
        a("login_phone_register");
        paramView = new Intent(this, PhoneMailActivity.class);
        paramView.putExtra("PhoneMailActivity_type", 1);
        startActivity(paramView);
        return;
      }
      if (i1 == R.id.ib_img_code)
      {
        this.q.setText("");
        h();
        return;
      }
    } while (i1 != R.id.tv_vcode_login);
    c();
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    this.J = false;
    d.d("LoginActivity", "====three:onError:" + paramInt);
    paramPlatform.removeAccount(false);
    this.P.obtainMessage(2).sendToTarget();
  }
  
  @Instrumented
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
    if (paramBoolean)
    {
      this.o.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      this.k.setText("隐藏");
    }
    for (;;)
    {
      this.o.postInvalidate();
      paramCompoundButton = this.o.getText();
      this.o.setSelection(paramCompoundButton.length());
      return;
      this.o.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.k.setText("显示");
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    this.J = false;
    String str1 = paramPlatform.getDb().getUserId();
    String str2 = paramPlatform.getDb().getToken();
    d.d("LoginActivity", "====three:onComplete:userId:" + str1 + ";accessToken:" + str2);
    d.d("LoginActivity", "====three:onComplete:" + paramHashMap);
    Message localMessage;
    Bundle localBundle;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      localMessage = this.P.obtainMessage(1);
      localBundle = new Bundle();
      localBundle.putString("userId", str1);
      localBundle.putString("accessToken", str2);
      if (!paramPlatform.getName().equals(QQ.NAME)) {
        break label240;
      }
      if (!paramHashMap.containsKey("figureurl_qq_2")) {
        break label225;
      }
      str1 = (String)paramHashMap.get("figureurl_qq_2");
      this.H = str1;
      if (!paramHashMap.containsKey("nickname")) {
        break label233;
      }
      paramHashMap = (String)paramHashMap.get("nickname");
      label202:
      this.I = paramHashMap;
    }
    label225:
    label233:
    label240:
    label275:
    label318:
    do
    {
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
      paramPlatform.removeAccount(false);
      return;
      str1 = "";
      break;
      paramHashMap = "";
      break label202;
      if (paramPlatform.getName().equals(Wechat.NAME))
      {
        if (paramHashMap.containsKey("headimgurl"))
        {
          str1 = (String)paramHashMap.get("headimgurl");
          this.H = str1;
          if (!paramHashMap.containsKey("nickname")) {
            break label318;
          }
        }
        for (paramHashMap = (String)paramHashMap.get("nickname");; paramHashMap = "")
        {
          this.I = paramHashMap;
          break;
          str1 = "";
          break label275;
        }
      }
    } while (!paramPlatform.getName().equals(SinaWeibo.NAME));
    if (paramHashMap.containsKey("avatar_large"))
    {
      str1 = (String)paramHashMap.get("avatar_large");
      label360:
      this.H = str1;
      if (!paramHashMap.containsKey("name")) {
        break label403;
      }
    }
    label403:
    for (paramHashMap = (String)paramHashMap.get("name");; paramHashMap = "")
    {
      this.I = paramHashMap;
      break;
      str1 = "";
      break label360;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_login);
    b();
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.Q, paramBundle);
    a();
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.Q);
    super.onDestroy();
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    d.d("LoginActivity", "====three:onError:" + paramInt);
    d.d("LoginActivity", "====three:onError:" + paramThrowable.getMessage());
    this.J = false;
    paramPlatform.removeAccount(false);
    paramPlatform = this.P.obtainMessage(2);
    paramThrowable = paramThrowable.getClass().getSimpleName();
    if (("WechatClientNotExistException".equals(paramThrowable)) || ("WechatTimelineNotSupportedException".equals(paramThrowable)) || ("WechatFavoriteNotSupportedException".equals(paramThrowable)))
    {
      paramThrowable = new Bundle();
      paramThrowable.putString("msg", getString(R.string.login_msg_three_wechat_not_exists));
      paramPlatform.setData(paramThrowable);
    }
    paramPlatform.sendToTarget();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    this.E = paramIntent.getStringExtra("LoginActivity_phone");
    if (!TextUtils.isEmpty(this.E)) {
      this.n.setText(this.E);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.J) {
      this.P.sendEmptyMessageDelayed(3, 2000L);
    }
  }
  
  private class a
    extends AsyncTask<Integer, Integer, Boolean>
  {
    private a() {}
    
    protected Boolean a(Integer... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length < 2)) {
        return Boolean.valueOf(false);
      }
      int i = paramVarArgs[0].intValue();
      paramVarArgs[1].intValue();
      LoginActivity.a(LoginActivity.this, i);
      LoginActivity.a(LoginActivity.this, "");
      LoginActivity.b(LoginActivity.this, "");
      switch (i)
      {
      default: 
        return Boolean.valueOf(false);
      case 2: 
        paramVarArgs = ShareSDK.getPlatform(QQ.NAME);
      }
      for (;;)
      {
        paramVarArgs.removeAccount(false);
        paramVarArgs.setPlatformActionListener(LoginActivity.this);
        paramVarArgs.SSOSetting(false);
        paramVarArgs.showUser(null);
        return Boolean.valueOf(true);
        paramVarArgs = ShareSDK.getPlatform(Wechat.NAME);
        continue;
        paramVarArgs = ShareSDK.getPlatform(SinaWeibo.NAME);
      }
    }
    
    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      if (!paramBoolean.booleanValue())
      {
        LoginActivity.this.dismissProgress();
        return;
      }
      LoginActivity.e(LoginActivity.this, true);
    }
    
    protected void onCancelled()
    {
      super.onCancelled();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      LoginActivity.this.showProgress("");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */