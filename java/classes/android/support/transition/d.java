package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

abstract interface d
{
  public abstract void addPauseListener(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract void pause(Animator paramAnimator);
  
  public abstract void resume(Animator paramAnimator);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */