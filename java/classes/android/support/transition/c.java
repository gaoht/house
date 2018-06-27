package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class c
  implements d
{
  public void addPauseListener(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramAnimator.addPauseListener(paramAnimatorListenerAdapter);
  }
  
  public void pause(Animator paramAnimator)
  {
    paramAnimator.pause();
  }
  
  public void resume(Animator paramAnimator)
  {
    paramAnimator.resume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */