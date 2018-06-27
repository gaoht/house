package com.ziroom.ziroomcustomer.newServiceList.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class b
  extends Dialog
{
  private Context a;
  private SimpleDraweeView b;
  private ImageView c;
  private View d;
  private View e;
  private String f;
  private String g;
  private a h;
  private String i;
  private int j;
  private RelativeLayout k;
  
  public b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, 2131427591);
    this.a = paramContext;
    this.f = paramString1;
    this.g = paramString2;
    this.i = paramString3;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903845, null);
    this.b = ((SimpleDraweeView)localView.findViewById(2131693871));
    this.c = ((ImageView)localView.findViewById(2131690588));
    this.d = localView.findViewById(2131690379);
    this.e = localView.findViewById(2131692133);
    this.k = ((RelativeLayout)localView.findViewById(2131693870));
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    this.j = ac.getScreenHeight(this.a);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.height = (this.j * 70 / 667);
    this.e.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.height = (this.j * 126 / 667);
    this.d.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.height = (this.j * 391 / 667);
    this.k.setLayoutParams(localLayoutParams);
    this.b.setController(c.frescoController(this.f));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (b.a(b.this) != null) {
          b.a(b.this).change();
        }
        JsBridgeWebActivity.start(b.b(b.this), "", b.c(b.this), false, "", b.d(b.this), false);
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ((!TextUtils.isEmpty(b.e(b.this))) && ("servicePage".equals(b.e(b.this))))
        {
          b.f(b.this);
          return;
        }
        b.this.dismiss();
      }
    });
  }
  
  private void c()
  {
    float f1 = n.dip2px(this.a, 56.0F) / (this.j * 391 / 667);
    int m = this.j * 195 / 667;
    int n = n.dip2px(this.a, 126.0F);
    int i1 = this.j * 1 / 2;
    this.c.setVisibility(8);
    int i2 = ac.getScreenWidth(this.a) / 2;
    int i3 = n.dip2px(this.a, 56.0F) / 2;
    int i4 = n.dip2px(this.a, 12.0F);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.b, "translationX", new float[] { 0.0F, i2 - i3 - i4 }), ObjectAnimator.ofFloat(this.b, "translationY", new float[] { 0.0F, -(m + n - i1) - n.dip2px(this.a, 26.0F) }), ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 1.0F, 0.2F }), ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.0F, 0.15F }) });
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (b.a(b.this) != null) {
          b.a(b.this).change();
        }
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localAnimatorSet.start();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(false);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(48);
  }
  
  public void setOnAnimationListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void change();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */