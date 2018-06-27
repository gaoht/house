package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class u
{
  private static final x a = new v();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new w();
      return;
    }
  }
  
  static PropertyValuesHolder a(Property<?, PointF> paramProperty, Path paramPath)
  {
    return a.ofPointF(paramProperty, paramPath);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */