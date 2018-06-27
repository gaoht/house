package com.facebook.imagepipeline.animated.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.view.animation.LinearInterpolator;
import com.facebook.common.time.MonotonicClock;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(11)
public class AnimatedDrawable
  extends AbstractAnimatedDrawable
  implements AnimatableDrawable
{
  public AnimatedDrawable(ScheduledExecutorService paramScheduledExecutorService, AnimatedDrawableCachingBackend paramAnimatedDrawableCachingBackend, AnimatedDrawableDiagnostics paramAnimatedDrawableDiagnostics, MonotonicClock paramMonotonicClock)
  {
    super(paramScheduledExecutorService, paramAnimatedDrawableCachingBackend, paramAnimatedDrawableDiagnostics, paramMonotonicClock);
  }
  
  public ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener()
  {
    new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AnimatedDrawable.this.setLevel(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    };
  }
  
  public ValueAnimator createValueAnimator()
  {
    int i = getAnimatedDrawableBackend().getLoopCount();
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, getDuration() });
    localValueAnimator.setDuration(getDuration());
    if (i != 0) {}
    for (;;)
    {
      localValueAnimator.setRepeatCount(i);
      localValueAnimator.setRepeatMode(1);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(createAnimatorUpdateListener());
      return localValueAnimator;
      i = -1;
    }
  }
  
  public ValueAnimator createValueAnimator(int paramInt)
  {
    ValueAnimator localValueAnimator = createValueAnimator();
    localValueAnimator.setRepeatCount(Math.max(paramInt / getAnimatedDrawableBackend().getDurationMs(), 1));
    return localValueAnimator;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/base/AnimatedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */