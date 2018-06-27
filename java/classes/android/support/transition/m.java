package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.widget.ImageView;

abstract interface m
{
  public abstract void animateTransform(ImageView paramImageView, Matrix paramMatrix);
  
  public abstract void reserveEndAnimateTransform(ImageView paramImageView, Animator paramAnimator);
  
  public abstract void startAnimateTransform(ImageView paramImageView);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */