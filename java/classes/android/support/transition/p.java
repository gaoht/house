package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class p
  implements s
{
  public <T> ObjectAnimator ofPointF(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    return ObjectAnimator.ofFloat(paramT, new t(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */