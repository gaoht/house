package com.ziroom.ziroomcustomer.home.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;

public class f
  extends d.e
{
  final ValueAnimator a = new ValueAnimator();
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void end()
  {
    this.a.end();
  }
  
  public float getAnimatedFloatValue()
  {
    return ((Float)this.a.getAnimatedValue()).floatValue();
  }
  
  public float getAnimatedFraction()
  {
    return this.a.getAnimatedFraction();
  }
  
  public int getAnimatedIntValue()
  {
    return ((Integer)this.a.getAnimatedValue()).intValue();
  }
  
  public boolean isRunning()
  {
    return this.a.isRunning();
  }
  
  public void setDuration(int paramInt)
  {
    this.a.setDuration(paramInt);
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    this.a.setFloatValues(new float[] { paramFloat1, paramFloat2 });
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    this.a.setIntValues(new int[] { paramInt1, paramInt2 });
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.a.setInterpolator(paramInterpolator);
  }
  
  public void setListener(final d.e.a parama)
  {
    this.a.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        parama.onAnimationCancel();
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        parama.onAnimationEnd();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        parama.onAnimationStart();
      }
    });
  }
  
  public void setUpdateListener(final d.e.b paramb)
  {
    this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        paramb.onAnimationUpdate();
      }
    });
  }
  
  public void start()
  {
    this.a.start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */