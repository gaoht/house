package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;

class j
{
  private static final m a = new k();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new l();
      return;
    }
  }
  
  static void a(ImageView paramImageView)
  {
    a.startAnimateTransform(paramImageView);
  }
  
  static void a(ImageView paramImageView, Animator paramAnimator)
  {
    a.reserveEndAnimateTransform(paramImageView, paramAnimator);
  }
  
  static void a(ImageView paramImageView, Matrix paramMatrix)
  {
    a.animateTransform(paramImageView, paramMatrix);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */