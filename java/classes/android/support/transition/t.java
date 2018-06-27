package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class t<T>
  extends Property<T, Float>
{
  private final Property<T, PointF> a;
  private final PathMeasure b;
  private final float c;
  private final float[] d = new float[2];
  private final PointF e = new PointF();
  private float f;
  
  t(Property<T, PointF> paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.a = paramProperty;
    this.b = new PathMeasure(paramPath, false);
    this.c = this.b.getLength();
  }
  
  public Float get(T paramT)
  {
    return Float.valueOf(this.f);
  }
  
  public void set(T paramT, Float paramFloat)
  {
    this.f = paramFloat.floatValue();
    this.b.getPosTan(this.c * paramFloat.floatValue(), this.d, null);
    this.e.x = this.d[0];
    this.e.y = this.d[1];
    this.a.set(paramT, this.e);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */