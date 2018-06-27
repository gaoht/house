package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

class a
{
  private static final d a = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new c();
      return;
    }
  }
  
  static void a(Animator paramAnimator)
  {
    a.pause(paramAnimator);
  }
  
  static void a(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a.addPauseListener(paramAnimator, paramAnimatorListenerAdapter);
  }
  
  static void b(Animator paramAnimator)
  {
    a.resume(paramAnimator);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */