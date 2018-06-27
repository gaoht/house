package com.ziroom.ziroomcustomer.social.activity.zz;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.social.activity.zz.card.CardItemView;
import com.ziroom.ziroomcustomer.social.activity.zz.card.ColorView;
import com.ziroom.ziroomcustomer.social.model.p;
import com.ziroom.ziroomcustomer.social.model.r;
import com.ziroom.ziroomcustomer.social.model.t;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.Arrays;
import java.util.List;

public class ZzSocialMatchActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int A;
  private int B;
  private int C;
  private ImageView D;
  private Activity E;
  private Boolean F = Boolean.valueOf(true);
  private List<p> G;
  private int H;
  private int I;
  private int J = 0;
  private int K = 0;
  private int L = 0;
  private p M;
  private List<String> N = Arrays.asList(new String[] { "二", "三", "四", "五", "六", "七", "八", "九", "十" });
  private Boolean O = Boolean.valueOf(false);
  private SimpleDraweeView P;
  private Button Q;
  private Button R;
  private LinearLayout S;
  private p T;
  AnimatorSet a;
  AnimatorSet b;
  AnimatorSet c;
  AnimatorSet d;
  AnimatorSet e;
  AnimatorSet f;
  AnimatorSet g;
  private TextView r;
  private TextView s;
  private TextView t;
  private CardItemView u;
  private CardItemView v;
  private Button w;
  private Button x;
  private ColorView y;
  private FrameLayout z;
  
  private void a()
  {
    Object localObject = (t)getIntent().getSerializableExtra("data");
    this.J = ((t)localObject).getTimes();
    this.K = ((t)localObject).getTotal();
    this.G = ((t)localObject).getList();
    if ((this.G != null) && (this.G.size() > 2))
    {
      this.u.setVisibility(0);
      this.v.setVisibility(0);
      this.w.setVisibility(0);
      this.x.setVisibility(0);
      this.t.setVisibility(0);
      localObject = this.u;
      List localList = this.G;
      int i = this.L;
      this.L = (i + 1);
      ((CardItemView)localObject).setData((p)localList.get(i));
      localObject = this.v;
      localList = this.G;
      i = this.L;
      this.L = (i + 1);
      ((CardItemView)localObject).setData((p)localList.get(i));
      this.I = (this.G.size() / 2);
      this.s.setText("共计" + this.I + "轮，当前第1轮");
      this.H = 1;
      this.t.setText("都不喜欢，直接去第" + (String)this.N.get(this.H - 1) + "轮");
    }
  }
  
  private void a(final View paramView1, View paramView2)
  {
    this.P.setController(com.freelxl.baselibrary.f.c.frescoController(this.T.getAvatar()));
    int i = (ac.getScreenHeight(this) - ah.dip2px(this, 400.0F)) / 7;
    int j = ah.dip2px(this, 75.0F);
    int k = (paramView1.getHeight() - ah.dip2px(this, 120.0F)) / 2;
    this.D.setVisibility(8);
    paramView2.setVisibility(8);
    this.w.setVisibility(8);
    this.x.setVisibility(8);
    this.s.setVisibility(8);
    this.r.setVisibility(8);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramView1.setVisibility(4);
      this.S.setVisibility(0);
      return;
    }
    int m = paramView1.getWidth();
    int n = paramView1.findViewById(2131697563).getHeight();
    paramView2 = ViewAnimationUtils.createCircularReveal(paramView1, m / 2, n / 2, m * 0.8F, ah.dip2px(this, 75.0F));
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { i * 3 + j - k });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramView2, localObjectAnimator });
    localAnimatorSet.setDuration(350L);
    localAnimatorSet.start();
    localAnimatorSet.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramView1.setVisibility(4);
        ZzSocialMatchActivity.e(ZzSocialMatchActivity.this).setVisibility(0);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
  }
  
  private void a(final View paramView1, final CardItemView paramCardItemView1, final CardItemView paramCardItemView2, final View paramView2)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView1, "scaleX", new float[] { 1.0F, 1.2F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView1, "scaleY", new float[] { 1.0F, 1.2F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramCardItemView1, "translationX", new float[] { ah.dip2px(this, 18.0F) });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramCardItemView1, "translationY", new float[] { paramCardItemView1.getTranslationY() - this.A / 2 });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { paramView1.getTranslationY() + this.A / 4 });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { ac.getScreenWidth(this) / 2 - ah.dip2px(this, 43.0F) });
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { this.A * -2 });
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { this.A * -2 });
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(paramCardItemView2, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 1.0F, 0.0F });
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.A, ac.getScreenWidth(this) - ah.dip2px(this, 36.0F) });
    localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().width = i;
        paramCardItemView1.requestLayout();
      }
    });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.B, this.B * 3 / 2 });
    localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().height = i;
        paramCardItemView1.requestLayout();
      }
    });
    ObjectAnimator localObjectAnimator11 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { this.A / 2 + ah.dip2px(this, 18.0F) - ah.dip2px(this, 43.0F) });
    ObjectAnimator localObjectAnimator12 = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { this.C + this.B - ah.dip2px(this, 25.0F) });
    ObjectAnimator localObjectAnimator13 = ObjectAnimator.ofFloat(paramCardItemView1, "translationY", new float[] { this.C });
    ObjectAnimator localObjectAnimator14 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { this.A + ah.dip2px(this, 30.0F) });
    ObjectAnimator localObjectAnimator15 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { this.A / 2 * 3 + ah.dip2px(this, 30.0F) - ah.dip2px(this, 43.0F) });
    ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { ac.getScreenWidth(this) - ah.dip2px(this, 36.0F), this.A });
    localValueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().width = i;
        paramCardItemView1.requestLayout();
      }
    });
    ValueAnimator localValueAnimator4 = ValueAnimator.ofInt(new int[] { this.B * 3 / 2, this.B });
    localValueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().height = i;
        paramCardItemView1.requestLayout();
      }
    });
    ObjectAnimator localObjectAnimator16 = ObjectAnimator.ofFloat(this.t, "translationY", new float[] { ac.getScreenHeight(this) });
    ObjectAnimator localObjectAnimator17 = ObjectAnimator.ofFloat(this.t, "translationY", new float[] { ac.getScreenHeight(this) - ah.dip2px(this, 100.0F) });
    ObjectAnimator localObjectAnimator18 = ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 0.5F });
    ObjectAnimator localObjectAnimator19 = ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator20 = ObjectAnimator.ofFloat(this.s, "alpha", new float[] { 0.3F });
    ObjectAnimator localObjectAnimator21 = ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 0.8F });
    paramView1.setBackgroundResource(2130840306);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator1);
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.start();
    this.d = new AnimatorSet();
    this.d.play(localValueAnimator1).with(localValueAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).with(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).with(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).with(localObjectAnimator16).with(localObjectAnimator18).with(localObjectAnimator20);
    this.d.setDuration(300L);
    this.d.setInterpolator(new DecelerateInterpolator());
    this.e = new AnimatorSet();
    this.e.play(localObjectAnimator11).with(localObjectAnimator12).with(localObjectAnimator13).with(localObjectAnimator14).with(localObjectAnimator15).with(localValueAnimator3).with(localValueAnimator4).with(localObjectAnimator17).with(localObjectAnimator19).with(localObjectAnimator21);
    this.e.setDuration(300L);
    this.e.setInterpolator(new AccelerateInterpolator());
    this.e.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, Boolean.valueOf(false));
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.d.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (ZzSocialMatchActivity.b(ZzSocialMatchActivity.this) == ZzSocialMatchActivity.c(ZzSocialMatchActivity.this))
        {
          ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1.getData());
          ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1, paramCardItemView2);
          return;
        }
        paramCardItemView2.setScaleX(1.0F);
        paramCardItemView2.setScaleY(1.0F);
        paramCardItemView2.setAlpha(1.0F);
        paramView2.setAlpha(1.0F);
        paramCardItemView2.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this));
        paramView2.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this) + ZzSocialMatchActivity.a(ZzSocialMatchActivity.this) / 2 - ah.dip2px(ZzSocialMatchActivity.this, 43.0F));
        ZzSocialMatchActivity.this.e.start();
        paramView1.setBackgroundResource(2130840305);
        ZzSocialMatchActivity.b(ZzSocialMatchActivity.this, paramCardItemView1.getData());
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1.getData().getUid(), 2);
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1, paramCardItemView2);
        paramAnonymousAnimator = ZzSocialMatchActivity.this;
        if (!ZzSocialMatchActivity.d(ZzSocialMatchActivity.this).booleanValue()) {}
        for (boolean bool = true;; bool = false)
        {
          ZzSocialMatchActivity.b(paramAnonymousAnimator, Boolean.valueOf(bool));
          paramCardItemView1.bringToFront();
          paramView1.bringToFront();
          return;
        }
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localAnimatorSet.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ZzSocialMatchActivity.this.d.start();
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
  }
  
  private void a(CardItemView paramCardItemView1, CardItemView paramCardItemView2)
  {
    if (this.H < this.I)
    {
      if (this.M == null)
      {
        List localList = this.G;
        i = this.L;
        this.L = (i + 1);
        paramCardItemView1.setData((p)localList.get(i));
        a(paramCardItemView1.getData().getUid(), 3);
      }
      paramCardItemView1 = this.G;
      int i = this.L;
      this.L = (i + 1);
      paramCardItemView2.setData((p)paramCardItemView1.get(i));
      a(paramCardItemView2.getData().getUid(), 3);
      this.H += 1;
      this.s.setText("共计" + this.I + "轮，当前第" + this.H + "轮");
      this.t.setText("都不喜欢，直接去第" + (String)this.N.get(this.H - 1) + "轮");
      if (this.H >= this.I) {
        this.t.setVisibility(8);
      }
    }
  }
  
  private void a(final CardItemView paramCardItemView1, final CardItemView paramCardItemView2, final View paramView1, final View paramView2)
  {
    this.a = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramCardItemView1, "translationX", new float[] { paramCardItemView1.getTranslationX() + ah.dip2px(this, 24.0F) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { paramCardItemView2.getTranslationX() + ah.dip2px(this, 24.0F) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { paramView1.getTranslationX() + ah.dip2px(this, 24.0F) });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { paramView2.getTranslationX() + ah.dip2px(this, 24.0F) });
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator3).with(localObjectAnimator2).with(localObjectAnimator4);
    ((AnimatorSet)localObject).setDuration(300L);
    ((AnimatorSet)localObject).start();
    ((AnimatorSet)localObject).addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ZzSocialMatchActivity.this.a.start();
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localObjectAnimator1 = ObjectAnimator.ofFloat(paramCardItemView1, "translationX", new float[] { paramCardItemView1.getTranslationX() - ac.getScreenWidth(this) });
    localObjectAnimator2 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { paramCardItemView2.getTranslationX() - ac.getScreenWidth(this) });
    localObjectAnimator3 = ObjectAnimator.ofFloat(paramCardItemView1, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator4 = ObjectAnimator.ofFloat(paramCardItemView2, "alpha", new float[] { 1.0F, 0.0F });
    localObject = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { paramView1.getTranslationX() - ac.getScreenWidth(this) });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { paramView2.getTranslationX() - ac.getScreenWidth(this) });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(paramCardItemView1, "translationX", new float[] { ah.dip2px(this, 18.0F) });
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { this.A / 2 + ah.dip2px(this, 18.0F) - ah.dip2px(this, 43.0F) });
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { this.A + ah.dip2px(this, 24.0F) });
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { this.A / 2 * 3 + ah.dip2px(this, 30.0F) - ah.dip2px(this, 49.0F) });
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { this.A + ah.dip2px(this, 30.0F) });
    ObjectAnimator localObjectAnimator11 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { this.A / 2 * 3 + ah.dip2px(this, 30.0F) - ah.dip2px(this, 43.0F) });
    localObjectAnimator2.setStartDelay(100L);
    localObjectAnimator4.setStartDelay(100L);
    localObjectAnimator5.setStartDelay(100L);
    localObjectAnimator8.setStartDelay(100L);
    localObjectAnimator9.setStartDelay(100L);
    this.a.play(localObjectAnimator1).with(localObjectAnimator3).with((Animator)localObject).with(localObjectAnimator2).with(localObjectAnimator4).with(localObjectAnimator5);
    this.a.setDuration(400L);
    this.a.setInterpolator(new AccelerateInterpolator());
    this.b = new AnimatorSet();
    this.b.play(localObjectAnimator6).with(localObjectAnimator7).with(localObjectAnimator8).with(localObjectAnimator9);
    this.b.setDuration(300L);
    this.b.setInterpolator(new DecelerateInterpolator());
    this.c = new AnimatorSet();
    this.c.play(localObjectAnimator10).with(localObjectAnimator11);
    this.c.setDuration(200L);
    this.c.setInterpolator(new DecelerateInterpolator());
    this.c.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, Boolean.valueOf(false));
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.a.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramCardItemView1.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this));
        paramCardItemView2.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this) + ZzSocialMatchActivity.a(ZzSocialMatchActivity.this) + ah.dip2px(ZzSocialMatchActivity.this, 30.0F));
        paramCardItemView1.setAlpha(1.0F);
        paramCardItemView2.setAlpha(1.0F);
        paramView1.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this) + ZzSocialMatchActivity.a(ZzSocialMatchActivity.this) / 2 + ah.dip2px(ZzSocialMatchActivity.this, 18.0F) - ah.dip2px(ZzSocialMatchActivity.this, 43.0F));
        paramView2.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this) + ZzSocialMatchActivity.a(ZzSocialMatchActivity.this) / 2 * 3 + ah.dip2px(ZzSocialMatchActivity.this, 30.0F) - ah.dip2px(ZzSocialMatchActivity.this, 43.0F));
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1, paramCardItemView2);
        ZzSocialMatchActivity.this.b.start();
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.b.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ZzSocialMatchActivity.this.c.start();
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
  }
  
  private void a(String paramString, int paramInt)
  {
    n.saveUserCollects(this, paramString, paramInt, this.H, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject) {}
    });
  }
  
  private void b()
  {
    this.S = ((LinearLayout)findViewById(2131697574));
    this.P = ((SimpleDraweeView)findViewById(2131690097));
    this.Q = ((Button)findViewById(2131697575));
    this.R = ((Button)findViewById(2131697576));
    this.z = ((FrameLayout)findViewById(2131690069));
    this.D = ((ImageView)findViewById(2131697569));
    this.y = ((ColorView)findViewById(2131697568));
    this.r = ((TextView)findViewById(2131693150));
    this.s = ((TextView)findViewById(2131689857));
    this.t = ((TextView)findViewById(2131691015));
    this.u = ((CardItemView)findViewById(2131697572));
    this.v = ((CardItemView)findViewById(2131697570));
    this.x = ((Button)findViewById(2131697571));
    this.w = ((Button)findViewById(2131697573));
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.A = (ac.getScreenWidth(this) / 2 - ah.dip2px(this, 24.0F));
    this.B = (this.A + ah.dip2px(this, 120.0F));
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(this.A, this.B);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(this.A, this.B);
    this.u.setLayoutParams(localLayoutParams1);
    this.v.setLayoutParams(localLayoutParams2);
    localLayoutParams1 = new FrameLayout.LayoutParams(ah.dip2px(this, 86.0F), ah.dip2px(this, 86.0F));
    localLayoutParams2 = new FrameLayout.LayoutParams(ah.dip2px(this, 86.0F), ah.dip2px(this, 86.0F));
    this.w.setLayoutParams(localLayoutParams1);
    this.x.setLayoutParams(localLayoutParams2);
    this.C = ((ac.getScreenHeight(this) - this.B - ah.dip2px(this, 61.0F)) / 2 + ah.dip2px(this, 25.0F));
    this.u.setTranslationY(this.C);
    this.v.setTranslationY(this.C);
    this.u.setTranslationX(ah.dip2px(this, 18.0F));
    this.v.setTranslationX(this.A + ah.dip2px(this, 30.0F));
    this.w.setTranslationY(this.C + this.B - ah.dip2px(this, 25.0F));
    this.x.setTranslationY(this.C + this.B - ah.dip2px(this, 25.0F));
    this.w.setTranslationX(this.A / 2 + ah.dip2px(this, 18.0F) - ah.dip2px(this, 43.0F));
    this.x.setTranslationX(this.A / 2 * 3 + ah.dip2px(this, 30.0F) - ah.dip2px(this, 43.0F));
    this.t.setTranslationY(ac.getScreenHeight(this) - ah.dip2px(this, 100.0F));
    this.t.setTranslationX(ac.getScreenWidth(this) / 2 - ah.dip2px(this, 115.0F));
  }
  
  private void b(final View paramView1, final CardItemView paramCardItemView1, final CardItemView paramCardItemView2, final View paramView2)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView1, "scaleX", new float[] { 1.0F, 1.2F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView1, "scaleY", new float[] { 1.0F, 1.2F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramCardItemView1, "translationY", new float[] { paramCardItemView1.getTranslationY() - this.A / 2 });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { -this.A });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { ac.getScreenWidth(this) / 2 - ah.dip2px(this, 43.0F) });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { paramView1.getTranslationY() + this.A / 4 });
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { -this.A / 2 - ah.dip2px(this, 43.0F) });
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(paramCardItemView2, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 1.0F, 0.0F });
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.A, this.A * 2 + ah.dip2px(this, 12.0F) });
    localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().width = i;
        paramCardItemView1.requestLayout();
      }
    });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.B, this.B * 3 / 2 });
    localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().height = i;
        paramCardItemView1.requestLayout();
      }
    });
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.t, "translationY", new float[] { ac.getScreenHeight(this) });
    ObjectAnimator localObjectAnimator11 = ObjectAnimator.ofFloat(this.t, "translationY", new float[] { ac.getScreenHeight(this) - ah.dip2px(this, 100.0F) });
    ObjectAnimator localObjectAnimator12 = ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 0.5F });
    ObjectAnimator localObjectAnimator13 = ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator14 = ObjectAnimator.ofFloat(this.s, "alpha", new float[] { 0.3F });
    ObjectAnimator localObjectAnimator15 = ObjectAnimator.ofFloat(this.r, "alpha", new float[] { 0.8F });
    ObjectAnimator localObjectAnimator16 = ObjectAnimator.ofFloat(paramCardItemView1, "translationY", new float[] { this.C });
    ObjectAnimator localObjectAnimator17 = ObjectAnimator.ofFloat(paramCardItemView2, "translationX", new float[] { this.A + ah.dip2px(this, 30.0F) });
    ObjectAnimator localObjectAnimator18 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { this.A / 2 + ah.dip2px(this, 18.0F) - ah.dip2px(this, 43.0F) });
    ObjectAnimator localObjectAnimator19 = ObjectAnimator.ofFloat(paramView1, "translationY", new float[] { this.C + this.B - ah.dip2px(this, 25.0F) });
    ObjectAnimator localObjectAnimator20 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { this.A / 2 * 3 + ah.dip2px(this, 30.0F) - ah.dip2px(this, 43.0F) });
    ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.A * 2 + ah.dip2px(this, 12.0F), this.A });
    localValueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().width = i;
        paramCardItemView1.requestLayout();
      }
    });
    ValueAnimator localValueAnimator4 = ValueAnimator.ofInt(new int[] { this.B * 3 / 2, this.B });
    localValueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramCardItemView1.getLayoutParams().height = i;
        paramCardItemView1.requestLayout();
      }
    });
    localObjectAnimator4.setDuration(400L);
    paramView1.setBackgroundResource(2130840306);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator1);
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.start();
    this.f = new AnimatorSet();
    this.f.play(localValueAnimator1).with(localValueAnimator2).with(localObjectAnimator3).with(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator4).with(localObjectAnimator7).with(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).with(localObjectAnimator12).with(localObjectAnimator14);
    this.f.setDuration(300L);
    this.f.setInterpolator(new DecelerateInterpolator());
    this.g = new AnimatorSet();
    this.g.play(localObjectAnimator16).with(localObjectAnimator17).with(localObjectAnimator18).with(localObjectAnimator19).with(localObjectAnimator20).with(localValueAnimator3).with(localValueAnimator4).with(localObjectAnimator11).with(localObjectAnimator13).with(localObjectAnimator15);
    this.g.setDuration(300L);
    this.g.setInterpolator(new AccelerateInterpolator());
    this.g.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, Boolean.valueOf(false));
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.f.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramCardItemView2.setAlpha(1.0F);
        paramView2.setAlpha(1.0F);
        paramCardItemView2.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this));
        paramView2.setTranslationX(ac.getScreenWidth(ZzSocialMatchActivity.this) + ZzSocialMatchActivity.a(ZzSocialMatchActivity.this) / 2 - -ah.dip2px(ZzSocialMatchActivity.this, 43.0F));
        ZzSocialMatchActivity.b(ZzSocialMatchActivity.this, paramCardItemView1.getData());
        paramView1.setBackgroundResource(2130840305);
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1.getData().getUid(), 2);
        if (ZzSocialMatchActivity.b(ZzSocialMatchActivity.this) == ZzSocialMatchActivity.c(ZzSocialMatchActivity.this))
        {
          ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1.getData());
          ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1, paramCardItemView2);
          return;
        }
        ZzSocialMatchActivity.a(ZzSocialMatchActivity.this, paramCardItemView1, paramCardItemView2);
        ZzSocialMatchActivity.this.g.start();
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localAnimatorSet.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ZzSocialMatchActivity.this.f.start();
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
  }
  
  private void d(String paramString)
  {
    n.getUserHeaders(this, paramString, new com.ziroom.ziroomcustomer.e.a.d(this, new e(r.class))
    {
      public void onSuccess(int paramAnonymousInt, List<r> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          Intent localIntent = new Intent(ZzSocialMatchActivity.this, ZzSocialChatDetailActivity.class);
          localIntent.putExtra("toChatUid", ((r)paramAnonymousList.get(0)).getUid());
          localIntent.putExtra("toChatPic", ((r)paramAnonymousList.get(0)).getHead_img());
          localIntent.putExtra("toChatName", ZzSocialMatchActivity.f(ZzSocialMatchActivity.this).getNick());
          localIntent.putExtra("isFrom", "isFrom_match");
          ZzSocialMatchActivity.this.startActivity(localIntent);
          ZzSocialMatchActivity.this.finish();
        }
      }
    });
  }
  
  public static void startMatchActivity(final Activity paramActivity)
  {
    n.getUserMatchs(paramActivity, new com.ziroom.ziroomcustomer.e.a.d(paramActivity, new f(t.class))
    {
      public void onSuccess(int paramAnonymousInt, t paramAnonymoust)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymoust);
        Intent localIntent = new Intent(paramActivity, ZzSocialMatchActivity.class);
        localIntent.putExtra("data", paramAnonymoust);
        paramActivity.startActivity(localIntent);
      }
    });
  }
  
  public void onBackPressed()
  {
    if (this.S.getVisibility() != 0)
    {
      super.onBackPressed();
      return;
    }
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent("每个用户每天只有" + this.K + "次匹配机会，您只剩下" + (this.K - this.J) + "次机会了，确定要放弃本次匹配？").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          ZzSocialMatchActivity.this.finish();
        }
      }
    }).build().show();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131697569: 
    case 2131691015: 
    case 2131697573: 
    case 2131697571: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent("每个用户每天只有" + this.K + "次匹配机会，您只剩下" + (this.K - this.J) + "次机会了，确定要放弃本次匹配？").setOnConfirmClickListener(new c.b()
              {
                public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
                {
                  if (paramAnonymousBoolean) {
                    ZzSocialMatchActivity.this.finish();
                  }
                }
              }).build().show();
              return;
            } while (this.O.booleanValue());
            this.O = Boolean.valueOf(true);
            this.y.StartAnimation();
          } while (this.H >= this.I);
          this.M = null;
          if (this.F.booleanValue())
          {
            a(this.u, this.v, this.w, this.x);
            return;
          }
          a(this.v, this.u, this.x, this.w);
          return;
        } while (this.O.booleanValue());
        this.O = Boolean.valueOf(true);
        this.y.StartAnimation();
        if (this.F.booleanValue())
        {
          this.z.bringToFront();
          b(paramView, this.u, this.v, this.x);
          return;
        }
        a(paramView, this.u, this.v, this.x);
        return;
      } while (this.O.booleanValue());
      this.O = Boolean.valueOf(true);
      if (!this.F.booleanValue())
      {
        b(paramView, this.v, this.u, this.w);
        return;
      }
      a(paramView, this.v, this.u, this.w);
      return;
    case 2131697575: 
      a(this.T.getUid(), 4);
      d(this.T.getUid());
      return;
    }
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("确定").setContent("每个用户每天只有" + this.K + "次匹配机会，您只剩下" + (this.K - this.J) + "次机会了，确定要放弃本次匹配？").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          ZzSocialMatchActivity.this.finish();
        }
      }
    }).build().show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905140);
    this.E = this;
    b();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMatchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */