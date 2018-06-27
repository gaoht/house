package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class l
  implements m
{
  private static Method a;
  private static boolean b;
  
  private void a()
  {
    if (!b) {}
    try
    {
      a = ImageView.class.getDeclaredMethod("animateTransform", new Class[] { Matrix.class });
      a.setAccessible(true);
      b = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ImageViewUtilsApi21", "Failed to retrieve animateTransform method", localNoSuchMethodException);
      }
    }
  }
  
  public void animateTransform(ImageView paramImageView, Matrix paramMatrix)
  {
    a();
    if (a != null) {}
    try
    {
      a.invoke(paramImageView, new Object[] { paramMatrix });
      return;
    }
    catch (InvocationTargetException paramImageView)
    {
      throw new RuntimeException(paramImageView.getCause());
    }
    catch (IllegalAccessException paramImageView) {}
  }
  
  public void reserveEndAnimateTransform(ImageView paramImageView, Animator paramAnimator) {}
  
  public void startAnimateTransform(ImageView paramImageView) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */