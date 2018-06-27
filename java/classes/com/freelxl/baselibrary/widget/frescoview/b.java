package com.freelxl.baselibrary.widget.frescoview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;

public class b
  extends a
{
  private static final Class<?> a = b.class;
  private final ValueAnimator b = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  
  @SuppressLint({"NewApi"})
  public b(f paramf)
  {
    super(paramf);
    this.b.setInterpolator(new DecelerateInterpolator());
  }
  
  public static b newInstance()
  {
    return new b(f.newInstance());
  }
  
  protected Class<?> e()
  {
    return a;
  }
  
  @SuppressLint({"NewApi"})
  public void setTransformAnimated(Matrix paramMatrix, long paramLong, final Runnable paramRunnable)
  {
    boolean bool2 = false;
    FLog.v(e(), "setTransformAnimated: duration %d ms", Long.valueOf(paramLong));
    stopAnimation();
    if (paramLong > 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      bool1 = bool2;
      if (!a()) {
        bool1 = true;
      }
      Preconditions.checkState(bool1);
      a(true);
      this.b.setDuration(paramLong);
      getTransform().getValues(b());
      paramMatrix.getValues(c());
      this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          b.this.a(b.this.d(), ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          b.a(b.this, b.this.d());
        }
      });
      this.b.addListener(new AnimatorListenerAdapter()
      {
        private void a()
        {
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          b.this.a(false);
          b.this.f().restartGesture();
        }
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          FLog.v(b.this.e(), "setTransformAnimated: animation cancelled");
          a();
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FLog.v(b.this.e(), "setTransformAnimated: animation finished");
          a();
        }
      });
      this.b.start();
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void stopAnimation()
  {
    if (!a()) {
      return;
    }
    FLog.v(e(), "stopAnimation");
    this.b.cancel();
    this.b.removeAllUpdateListeners();
    this.b.removeAllListeners();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/frescoview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */