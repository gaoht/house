package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class y
  implements TypeEvaluator<Rect>
{
  private Rect a;
  
  y() {}
  
  y(Rect paramRect)
  {
    this.a = paramRect;
  }
  
  public Rect evaluate(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    int i = paramRect1.left;
    i = (int)((paramRect2.left - paramRect1.left) * paramFloat) + i;
    int j = paramRect1.top;
    j = (int)((paramRect2.top - paramRect1.top) * paramFloat) + j;
    int k = paramRect1.right;
    k = (int)((paramRect2.right - paramRect1.right) * paramFloat) + k;
    int m = paramRect1.bottom;
    m = (int)((paramRect2.bottom - paramRect1.bottom) * paramFloat) + m;
    if (this.a == null) {
      return new Rect(i, j, k, m);
    }
    this.a.set(i, j, k, m);
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */