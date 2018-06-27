package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class e
  extends az
{
  private float a = 3.0F;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public long getStartDelay(ViewGroup paramViewGroup, Transition paramTransition, ag paramag1, ag paramag2)
  {
    if ((paramag1 == null) && (paramag2 == null)) {
      return 0L;
    }
    int i;
    int m;
    int n;
    int k;
    if ((paramag2 == null) || (getViewVisibility(paramag1) == 0))
    {
      i = -1;
      m = getViewX(paramag1);
      n = getViewY(paramag1);
      paramag1 = paramTransition.getEpicenter();
      if (paramag1 == null) {
        break label146;
      }
      k = paramag1.centerX();
    }
    for (int j = paramag1.centerY();; j = Math.round(paramag1[1] + paramViewGroup.getHeight() / 2 + paramViewGroup.getTranslationY()))
    {
      float f = a(m, n, k, j) / a(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
      long l2 = paramTransition.getDuration();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      return Math.round((float)(l1 * i) / this.a * f);
      i = 1;
      paramag1 = paramag2;
      break;
      label146:
      paramag1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramag1);
      k = Math.round(paramag1[0] + paramViewGroup.getWidth() / 2 + paramViewGroup.getTranslationX());
    }
  }
  
  public void setPropagationSpeed(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
    this.a = paramFloat;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */