package com.facebook.imagepipeline.animated.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;

@TargetApi(11)
public abstract interface AnimatableDrawable
  extends Animatable
{
  public abstract ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener();
  
  public abstract ValueAnimator createValueAnimator();
  
  public abstract ValueAnimator createValueAnimator(int paramInt);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/base/AnimatableDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */