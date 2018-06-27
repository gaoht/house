package com.ziroom.commonlibrary.login;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.R.anim;
import com.ziroom.commonlibrary.R.drawable;
import com.ziroom.commonlibrary.R.id;
import com.ziroom.commonlibrary.R.layout;
import com.ziroom.commonlibrary.R.string;
import com.ziroom.commonlibrary.g.c;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText;
import com.ziroom.commonlibrary.widget.LoginLabeledEditText.a;
import java.util.UUID;

public class VCodeActivity
  extends BaseLoginActivity
  implements View.OnClickListener
{
  private com.ziroom.commonlibrary.a.a.a<e> A = new com.ziroom.commonlibrary.a.a.a(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      String str;
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
      {
        str = ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode();
        paramAnonymousThrowable = ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getData();
        if ((!"40001".equals(str)) || (paramAnonymousThrowable == null) || (!paramAnonymousThrowable.containsKey("needImgVCode")) || (!paramAnonymousThrowable.getBoolean("needImgVCode").booleanValue())) {
          break label128;
        }
        VCodeActivity.a(VCodeActivity.this, true);
        if ((VCodeActivity.f(VCodeActivity.this) != null) && (VCodeActivity.f(VCodeActivity.this).isShowing()))
        {
          com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, str, VCodeActivity.this.getString(R.string.login_msg_verify_img_code_invalid));
          VCodeActivity.g(VCodeActivity.this);
        }
      }
      else
      {
        return;
      }
      VCodeActivity.h(VCodeActivity.this);
      return;
      label128:
      if ("40012".equals(str))
      {
        g.textToast(VCodeActivity.this, VCodeActivity.this.getString(R.string.login_msg_operation_expired));
        VCodeActivity.this.finish();
        return;
      }
      com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, str);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (VCodeActivity.f(VCodeActivity.this) != null)
      {
        if (VCodeActivity.f(VCodeActivity.this).isShowing()) {
          VCodeActivity.f(VCodeActivity.this).dismiss();
        }
        VCodeActivity.a(VCodeActivity.this, null);
      }
    }
  };
  private com.ziroom.commonlibrary.a.a.b<Bitmap> B = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.a())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      VCodeActivity.o(VCodeActivity.this).setImageDrawable(VCodeActivity.this.getResources().getDrawable(R.drawable.common_login_refresh));
    }
    
    public void onSuccess(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousBitmap);
      if (paramAnonymousBitmap != null)
      {
        VCodeActivity.o(VCodeActivity.this).setImageBitmap(paramAnonymousBitmap);
        return;
      }
      VCodeActivity.o(VCodeActivity.this).setImageDrawable(VCodeActivity.this.getResources().getDrawable(R.drawable.common_login_refresh));
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> C = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      VCodeActivity.p(VCodeActivity.this).setText("");
    }
    
    public void onSuccess(int paramAnonymousInt, final e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      VCodeActivity.a(VCodeActivity.this, new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymous2Animation)
        {
          if (paramAnonymouse != null)
          {
            VCodeActivity.c(VCodeActivity.this, paramAnonymouse.getString("vid"));
            switch (VCodeActivity.d(VCodeActivity.this))
            {
            }
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (VCodeActivity.q(VCodeActivity.this) == null);
                VCodeActivity.q(VCodeActivity.this).putExtra("ValidateCodeActivity_vid", VCodeActivity.r(VCodeActivity.this));
                VCodeActivity.this.startActivity(VCodeActivity.q(VCodeActivity.this));
                VCodeActivity.this.finish();
                VCodeActivity.this.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
                return;
                paramAnonymous2Animation = a.getToken(VCodeActivity.this.getApplicationContext());
                if (!TextUtils.isEmpty(paramAnonymous2Animation))
                {
                  com.ziroom.commonlibrary.d.a.userInfo(VCodeActivity.this, paramAnonymous2Animation, VCodeActivity.s(VCodeActivity.this));
                  return;
                }
                com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, "40005");
                return;
                paramAnonymous2Animation = a.getToken(VCodeActivity.this.getApplicationContext());
                if (VCodeActivity.e(VCodeActivity.this) == 1) {}
                while (TextUtils.isEmpty(paramAnonymous2Animation))
                {
                  com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, "40005");
                  return;
                  if (VCodeActivity.e(VCodeActivity.this) != 2) {}
                }
              } while (VCodeActivity.q(VCodeActivity.this) == null);
              VCodeActivity.q(VCodeActivity.this).putExtra("ValidateCodeActivity_vid", VCodeActivity.r(VCodeActivity.this));
              VCodeActivity.this.startActivity(VCodeActivity.q(VCodeActivity.this));
              VCodeActivity.this.finish();
              VCodeActivity.this.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
              return;
              paramAnonymous2Animation = a.getToken(VCodeActivity.this.getApplicationContext());
              if (TextUtils.isEmpty(paramAnonymous2Animation))
              {
                com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, "40005");
                return;
              }
              if (VCodeActivity.e(VCodeActivity.this) == 1)
              {
                com.ziroom.commonlibrary.d.a.bindPhonePut(VCodeActivity.this, VCodeActivity.i(VCodeActivity.this), VCodeActivity.r(VCodeActivity.this), paramAnonymous2Animation, VCodeActivity.t(VCodeActivity.this));
                return;
              }
            } while (VCodeActivity.e(VCodeActivity.this) != 2);
            com.ziroom.commonlibrary.d.a.bindEmailPut(VCodeActivity.this, VCodeActivity.j(VCodeActivity.this), VCodeActivity.r(VCodeActivity.this), paramAnonymous2Animation, VCodeActivity.t(VCodeActivity.this));
            return;
          } while (VCodeActivity.q(VCodeActivity.this) == null);
          VCodeActivity.q(VCodeActivity.this).putExtra("ValidateCodeActivity_vid", VCodeActivity.r(VCodeActivity.this));
          VCodeActivity.this.startActivity(VCodeActivity.q(VCodeActivity.this));
          VCodeActivity.this.finish();
          VCodeActivity.this.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
        }
        
        public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
        
        public void onAnimationStart(Animation paramAnonymous2Animation) {}
      });
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> D = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      VCodeActivity.this.finish();
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      boolean bool;
      String str;
      if (paramAnonymouse != null)
      {
        bool = paramAnonymouse.containsKey("hasPassword");
        str = a.getToken(VCodeActivity.this.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
          break label47;
        }
        com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, "40005");
      }
      label47:
      do
      {
        do
        {
          return;
          if ((!bool) || (!paramAnonymouse.getBoolean("hasPassword").booleanValue())) {
            break;
          }
          if (VCodeActivity.e(VCodeActivity.this) == 1)
          {
            com.ziroom.commonlibrary.d.a.bindPhone(VCodeActivity.this, VCodeActivity.i(VCodeActivity.this), null, VCodeActivity.r(VCodeActivity.this), str, VCodeActivity.u(VCodeActivity.this));
            return;
          }
        } while (VCodeActivity.e(VCodeActivity.this) != 2);
        com.ziroom.commonlibrary.d.a.bindEmail(VCodeActivity.this, VCodeActivity.j(VCodeActivity.this), null, VCodeActivity.r(VCodeActivity.this), str, VCodeActivity.u(VCodeActivity.this));
        return;
      } while ((!bool) || (paramAnonymouse.getBoolean("hasPassword").booleanValue()) || (VCodeActivity.q(VCodeActivity.this) == null));
      VCodeActivity.q(VCodeActivity.this).putExtra("ValidateCodeActivity_vid", VCodeActivity.r(VCodeActivity.this));
      VCodeActivity.this.startActivity(VCodeActivity.q(VCodeActivity.this));
      VCodeActivity.this.finish();
      VCodeActivity.this.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> E = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      VCodeActivity.this.finish();
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      VCodeActivity.a(VCodeActivity.this, new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymous2Animation)
        {
          if (VCodeActivity.e(VCodeActivity.this) == 1)
          {
            VCodeActivity.this.a("boundphone_verifycode_finish");
            g.textToast(VCodeActivity.this, VCodeActivity.this.getString(R.string.login_msg_bind_phone_success));
          }
          for (;;)
          {
            paramAnonymous2Animation = new Intent("com.ziroom.commonlibrary.login.broadcast");
            paramAnonymous2Animation.putExtra("type", 3);
            LocalBroadcastManager.getInstance(VCodeActivity.this).sendBroadcast(paramAnonymous2Animation);
            return;
            if (VCodeActivity.e(VCodeActivity.this) == 2)
            {
              VCodeActivity.this.a("boundmail_verifycode_finish");
              g.textToast(VCodeActivity.this, VCodeActivity.this.getString(R.string.login_msg_bind_email_success));
            }
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
        
        public void onAnimationStart(Animation paramAnonymous2Animation) {}
      });
    }
  };
  private com.ziroom.commonlibrary.a.a.b<e> F = new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
      VCodeActivity.this.finish();
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      VCodeActivity.a(VCodeActivity.this, new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymous2Animation)
        {
          if (VCodeActivity.e(VCodeActivity.this) == 1) {
            g.textToast(VCodeActivity.this, VCodeActivity.this.getString(R.string.login_msg_modify_bind_phone_success));
          }
          for (;;)
          {
            paramAnonymous2Animation = new Intent("com.ziroom.commonlibrary.login.broadcast");
            paramAnonymous2Animation.putExtra("type", 4);
            LocalBroadcastManager.getInstance(VCodeActivity.this).sendBroadcast(paramAnonymous2Animation);
            return;
            if (VCodeActivity.e(VCodeActivity.this) == 2) {
              g.textToast(VCodeActivity.this, VCodeActivity.this.getString(R.string.login_msg_modify_bind_email_success));
            }
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
        
        public void onAnimationStart(Animation paramAnonymous2Animation) {}
      });
    }
  };
  private com.ziroom.commonlibrary.a.a.a G = new com.ziroom.commonlibrary.a.a.a(this, new com.ziroom.commonlibrary.a.b.b())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        com.ziroom.commonlibrary.g.a.a.handleMessage(VCodeActivity.this, ((com.ziroom.commonlibrary.a.b)paramAnonymousThrowable).getStrCode());
      }
    }
    
    public void onSuccess(int paramAnonymousInt, final e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      VCodeActivity.a(VCodeActivity.this, new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymous2Animation)
        {
          if (paramAnonymouse != null)
          {
            a.setLoginInfo(VCodeActivity.this, paramAnonymouse.getString("token"), paramAnonymouse.getString("uid"));
            c.saveLastLoginType(VCodeActivity.this, 0);
            paramAnonymous2Animation = new Intent("com.ziroom.commonlibrary.login.broadcast");
            paramAnonymous2Animation.putExtra("type", 1);
            paramAnonymous2Animation.putExtra("token", paramAnonymouse.getString("token"));
            paramAnonymous2Animation.putExtra("uid", paramAnonymouse.getString("uid"));
            LocalBroadcastManager.getInstance(VCodeActivity.this).sendBroadcast(paramAnonymous2Animation);
            d.d("VCodeActivity", "====sendBroadcast");
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
        
        public void onAnimationStart(Animation paramAnonymous2Animation) {}
      });
    }
  };
  private BroadcastReceiver H = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17)
      {
        VCodeActivity.this.dismissProgress();
        if (paramAnonymousIntent.getIntExtra("status", 0) != 1) {
          break label58;
        }
        g.textToast(VCodeActivity.this.getApplicationContext(), VCodeActivity.this.getString(R.string.login_msg_login_success));
      }
      for (;;)
      {
        VCodeActivity.this.finish();
        return;
        label58:
        a.a(VCodeActivity.this);
      }
    }
  };
  private final String b = "VCodeActivity";
  private final int c = 60;
  private final int d = 1000;
  private final int e = 1;
  private ImageView f;
  private TextView g;
  private TextView h;
  private LoginLabeledEditText i;
  private Button j;
  private int k;
  private int l;
  private int m;
  private String n;
  private String o;
  private String p;
  private String q;
  private Intent r;
  private String s;
  private String t;
  private String u;
  private String v;
  private ImageButton w;
  private boolean x;
  private AlertDialog y;
  private Handler z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.arg1 > 0)
      {
        VCodeActivity.b(VCodeActivity.this).setText(paramAnonymousMessage.arg1 + VCodeActivity.a(VCodeActivity.this));
        Message localMessage = obtainMessage(1);
        int i = paramAnonymousMessage.arg1 - 1;
        paramAnonymousMessage.arg1 = i;
        localMessage.arg1 = i;
        sendMessageDelayed(localMessage, 1000L);
        return;
      }
      VCodeActivity.b(VCodeActivity.this).setEnabled(true);
      VCodeActivity.b(VCodeActivity.this).setText(VCodeActivity.c(VCodeActivity.this));
      VCodeActivity.b(VCodeActivity.this).setOnClickListener(VCodeActivity.this);
    }
  };
  
  private void a(final Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (paramAnimationListener != null) {
          paramAnimationListener.onAnimationEnd(paramAnonymousAnimation);
        }
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        if ((VCodeActivity.v(VCodeActivity.this) != null) && (VCodeActivity.v(VCodeActivity.this).getVisibility() == 8)) {
          VCodeActivity.v(VCodeActivity.this).setVisibility(0);
        }
      }
    });
    if (this.f != null) {
      this.f.startAnimation(localScaleAnimation);
    }
  }
  
  private void b()
  {
    this.j.setEnabled(false);
    this.z.removeMessages(1);
    Message localMessage = this.z.obtainMessage(1);
    localMessage.arg1 = 60;
    localMessage.sendToTarget();
  }
  
  private void b(String paramString)
  {
    d.d("VCodeActivity", "=====code:" + paramString);
    this.s = null;
    if ((this.l == 18) || (this.l == 4))
    {
      String str = a.getToken(this);
      if (!TextUtils.isEmpty(str))
      {
        com.ziroom.commonlibrary.d.a.verifyCodePostV2(this, this.m, this.k, paramString, str, this.C);
        return;
      }
      com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
      return;
    }
    if (this.l == 5)
    {
      com.ziroom.commonlibrary.d.a.loginDynamic(this, this.n, paramString, true, this.G);
      return;
    }
    com.ziroom.commonlibrary.d.a.verifyCodePost(this, this.n, this.o, this.m, paramString, this.C);
  }
  
  private void c()
  {
    this.y = new AlertDialog.Builder(this).create();
    View localView = LayoutInflater.from(this).inflate(R.layout.dialog_img_code, null);
    final EditText localEditText = (EditText)localView.findViewById(R.id.et_img_code);
    this.w = ((ImageButton)localView.findViewById(R.id.ib_img_code));
    Object localObject1 = (Button)localView.findViewById(R.id.btn_left);
    Object localObject2 = (Button)localView.findViewById(R.id.btn_right);
    ((Button)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        VCodeActivity.b(VCodeActivity.this, "");
        VCodeActivity.a(VCodeActivity.this, null);
        VCodeActivity.f(VCodeActivity.this).dismiss();
        VCodeActivity.a(VCodeActivity.this, null);
      }
    });
    ((Button)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = VdsAgent.trackEditTextSilent(localEditText).toString().trim();
        if (TextUtils.isEmpty(paramAnonymousView)) {
          return;
        }
        VCodeActivity.b(VCodeActivity.this, paramAnonymousView);
        com.ziroom.commonlibrary.d.a.verifyCodeGetV2(VCodeActivity.this, VCodeActivity.i(VCodeActivity.this), VCodeActivity.j(VCodeActivity.this), VCodeActivity.k(VCodeActivity.this), VCodeActivity.l(VCodeActivity.this), VCodeActivity.m(VCodeActivity.this), VCodeActivity.n(VCodeActivity.this));
      }
    });
    this.w.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localEditText.setText("");
        VCodeActivity.g(VCodeActivity.this);
      }
    });
    localObject1 = this.y;
    if (!(localObject1 instanceof AlertDialog)) {
      ((AlertDialog)localObject1).show();
    }
    for (;;)
    {
      d();
      localObject1 = this.y.getWindow();
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
  
  private void d()
  {
    this.t = UUID.randomUUID().toString();
    com.ziroom.commonlibrary.d.a.verifyImgCodeGet(this, this.t, this.B);
  }
  
  protected void a()
  {
    super.a();
    Object localObject1 = getIntent();
    this.k = ((Intent)localObject1).getIntExtra("ValidateCodeActivity_vcode_type", 0);
    this.l = ((Intent)localObject1).getIntExtra("ValidateCodeActivity_vcode_type_busi", 0);
    this.v = ((Intent)localObject1).getStringExtra("ValidateCodeActivity_force_code");
    this.m = this.l;
    if (this.l == 18) {
      this.m = 2;
    }
    for (;;)
    {
      this.r = ((Intent)((Intent)localObject1).getParcelableExtra("ValidateCodeActivity_after_intent"));
      this.f = ((ImageView)findViewById(R.id.iv_correct));
      this.g = ((TextView)findViewById(R.id.tv_tips));
      this.h = ((TextView)findViewById(R.id.tv_hint));
      this.i = ((LoginLabeledEditText)findViewById(R.id.llet));
      this.j = ((Button)findViewById(R.id.btn));
      this.p = "s";
      this.q = "重新获取";
      Object localObject2 = new SpannableString("若无法收到验证码，请拨打客服电话：400-100-1111");
      int i1 = "若无法收到验证码，请拨打客服电话：400-100-1111".length();
      ((SpannableString)localObject2).setSpan(new a(null), i1 - 12, i1, 33);
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFA000")), i1 - 12, i1, 33);
      this.g.setText((CharSequence)localObject2);
      this.g.setMovementMethod(LinkMovementMethod.getInstance());
      switch (this.k)
      {
      default: 
        finish();
        throw new RuntimeException("VCodeActivity:缺少或不存在此种启动类型！");
        if (this.l == 34)
        {
          this.m = 1;
        }
        else if (this.l == 2)
        {
          this.m = 1;
        }
        else if (this.l == 4)
        {
          this.m = 3;
        }
        else if (this.l == 5)
        {
          this.m = 5;
          localObject2 = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
          LocalBroadcastManager.getInstance(this).registerReceiver(this.H, (IntentFilter)localObject2);
        }
        break;
      }
    }
    this.n = ((Intent)localObject1).getStringExtra("ValidateCodeActivity_phone");
    b();
    if ((this.l == 18) || (this.l == 4))
    {
      localObject1 = a.getToken(this);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        com.ziroom.commonlibrary.d.a.verifyCodeGetV3(this, this.m, 1, (String)localObject1, this.A);
        this.h.setVisibility(8);
        if (this.l == 18)
        {
          this.m = 2;
          this.h.setVisibility(0);
          localObject1 = "";
          if (this.k != 1) {
            break label701;
          }
          this.h.setVisibility(0);
          localObject1 = "短信验证码已发送至" + h.hiddenPhone(this.n);
        }
      }
    }
    for (;;)
    {
      this.h.setText((CharSequence)localObject1);
      this.i.addTextChangedListener(new LoginLabeledEditText.a()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() == 6)) {
            switch (VCodeActivity.d(VCodeActivity.this))
            {
            }
          }
          for (;;)
          {
            VCodeActivity.a(VCodeActivity.this, paramAnonymousEditable.toString());
            return;
            VCodeActivity.this.a("phone_register_verifycode_finish");
            continue;
            VCodeActivity.this.a("login_forgetpass_verifycode_finish");
            continue;
            if (VCodeActivity.e(VCodeActivity.this) == 1) {
              VCodeActivity.this.a("changephone_verifycode_finish");
            } else if (VCodeActivity.e(VCodeActivity.this) == 2) {
              VCodeActivity.this.a("changemail_verifycode_finish");
            }
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return;
      com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
      break;
      if (!TextUtils.isEmpty(this.v))
      {
        localObject1 = a.getToken(this);
        com.ziroom.commonlibrary.d.a.phoneBindVerifyCodeGetV1(this, this.n, this.v, (String)localObject1, this.A);
        break;
      }
      com.ziroom.commonlibrary.d.a.verifyCodeGetV2(this, this.n, this.o, this.m, null, null, this.A);
      break;
      this.o = ((Intent)localObject1).getStringExtra("ValidateCodeActivity_email");
      b();
      if ((this.l == 18) || (this.l == 4))
      {
        localObject1 = a.getToken(this);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          com.ziroom.commonlibrary.d.a.verifyCodeGetV3(this, this.m, 2, (String)localObject1, this.A);
          break;
        }
        com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
        break;
      }
      com.ziroom.commonlibrary.d.a.verifyCodeGetV2(this, this.n, this.o, this.m, null, null, this.A);
      break;
      label701:
      if (this.k == 2)
      {
        this.h.setVisibility(0);
        localObject1 = "短信验证码已发送至" + this.o;
      }
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == R.id.btn)
    {
      this.i.setText("");
      b();
      if ((this.l != 18) && (this.l != 4)) {
        break label84;
      }
      paramView = a.getToken(this);
      if (!TextUtils.isEmpty(paramView)) {
        com.ziroom.commonlibrary.d.a.verifyCodeGetV3(this, this.m, this.k, paramView, this.A);
      }
    }
    else
    {
      return;
    }
    com.ziroom.commonlibrary.g.a.a.handleMessage(this, "40005");
    return;
    label84:
    if (this.x)
    {
      c();
      return;
    }
    com.ziroom.commonlibrary.d.a.verifyCodeGetV2(this, this.n, this.o, this.m, null, null, this.A);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(4);
    setContentView(R.layout.activity_validate_code);
    a();
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.H);
    super.onDestroy();
    this.z.removeMessages(1);
  }
  
  private class a
    extends ClickableSpan
  {
    private a() {}
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + "4001001111"));
      VCodeActivity.this.startActivity(paramView);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setColor(Color.parseColor("#FFFFA000"));
      paramTextPaint.bgColor = -1;
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/login/VCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */