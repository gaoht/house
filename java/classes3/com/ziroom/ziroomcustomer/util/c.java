package com.ziroom.ziroomcustomer.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class c
{
  private static void a(View paramView, Animation paramAnimation, long paramLong1, long paramLong2)
  {
    a(paramAnimation, -1, paramLong1, paramLong2);
    paramView.setVisibility(0);
    paramView.startAnimation(paramAnimation);
  }
  
  private static void a(Animation paramAnimation, int paramInt, long paramLong1, long paramLong2)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramAnimation.setDuration(paramLong1);
      paramAnimation.setStartOffset(paramLong2);
      return;
      paramAnimation.setInterpolator(new LinearInterpolator());
      continue;
      paramAnimation.setInterpolator(new AccelerateInterpolator());
      continue;
      paramAnimation.setInterpolator(new DecelerateInterpolator());
      continue;
      paramAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
      continue;
      paramAnimation.setInterpolator(new BounceInterpolator());
      continue;
      paramAnimation.setInterpolator(new OvershootInterpolator());
      continue;
      paramAnimation.setInterpolator(new AnticipateInterpolator());
      continue;
      paramAnimation.setInterpolator(new AnticipateOvershootInterpolator());
    }
  }
  
  private static void b(View paramView, Animation paramAnimation, long paramLong1, long paramLong2)
  {
    a(paramAnimation, -1, paramLong1, paramLong2);
    paramAnimation.setAnimationListener(new b(paramView));
    paramView.startAnimation(paramAnimation);
  }
  
  public static void fadeIn(View paramView, long paramLong1, long paramLong2)
  {
    a(paramView, new AlphaAnimation(0.0F, 1.0F), paramLong1, paramLong2);
  }
  
  public static void fadeOut(View paramView, long paramLong1, long paramLong2)
  {
    b(paramView, new AlphaAnimation(1.0F, 0.0F), paramLong1, paramLong2);
  }
  
  public static void rotateIn(View paramView, long paramLong1, long paramLong2)
  {
    a(paramView, new RotateAnimation(-90.0F, 0.0F, 1, 0.0F, 1, 1.0F), paramLong1, paramLong2);
  }
  
  public static void rotateOut(View paramView, long paramLong1, long paramLong2)
  {
    b(paramView, new RotateAnimation(0.0F, 90.0F, 1, 0.0F, 1, 1.0F), paramLong1, paramLong2);
  }
  
  public static void scale(a parama, View paramView, long paramLong)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.93F, 1.0F, 0.93F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(paramLong);
    paramView.startAnimation(localScaleAnimation);
    localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        this.a.toLoginActivity();
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
  }
  
  public static void scaleIn(View paramView, long paramLong1, long paramLong2)
  {
    a(paramView, new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 2, 0.5F, 2, 0.5F), paramLong1, paramLong2);
  }
  
  public static void scaleOut(View paramView, long paramLong1, long paramLong2)
  {
    b(paramView, new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 2, 0.5F, 2, 0.5F), paramLong1, paramLong2);
  }
  
  public static void scaleRotateIn(View paramView, long paramLong1, long paramLong2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localRotateAnimation);
    a(paramView, localAnimationSet, paramLong1, paramLong2);
  }
  
  public static void scaleRotateOut(View paramView, long paramLong1, long paramLong2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localRotateAnimation);
    b(paramView, localAnimationSet, paramLong1, paramLong2);
  }
  
  public static void slideFadeIn(View paramView, long paramLong1, long paramLong2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    a(paramView, localAnimationSet, paramLong1, paramLong2);
  }
  
  public static void slideFadeOut(View paramView, long paramLong1, long paramLong2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    b(paramView, localAnimationSet, paramLong1, paramLong2);
  }
  
  public static void slideIn(View paramView, long paramLong1, long paramLong2)
  {
    a(paramView, new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F), paramLong1, paramLong2);
  }
  
  public static void slideOut(View paramView, long paramLong1, long paramLong2)
  {
    b(paramView, new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F), paramLong1, paramLong2);
  }
  
  public void hide(View paramView)
  {
    paramView.setVisibility(8);
  }
  
  public void show(View paramView)
  {
    paramView.setVisibility(0);
  }
  
  public void transparent(View paramView)
  {
    paramView.setVisibility(4);
  }
  
  public static abstract interface a
  {
    public abstract void toLoginActivity();
  }
  
  private static class b
    implements Animation.AnimationListener
  {
    private View a;
    
    public b(View paramView)
    {
      this.a = paramView;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      this.a.setVisibility(8);
      ((ViewGroup)this.a.getParent()).removeView(this.a);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */