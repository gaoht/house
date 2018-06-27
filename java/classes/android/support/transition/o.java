package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class o
{
  private static final s a = new p();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new q();
      return;
    }
  }
  
  static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    return a.ofPointF(paramT, paramProperty, paramPath);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */