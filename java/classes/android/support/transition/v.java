package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class v
  implements x
{
  public PropertyValuesHolder ofPointF(Property<?, PointF> paramProperty, Path paramPath)
  {
    return PropertyValuesHolder.ofFloat(new t(paramProperty, paramPath), new float[] { 0.0F, 1.0F });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */