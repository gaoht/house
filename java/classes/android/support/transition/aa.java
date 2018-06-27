package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

public class aa
  extends az
{
  private float a = 3.0F;
  private int b = 80;
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int j = 5;
    int k = 3;
    int m = 1;
    int i = 1;
    if (this.b == 8388611) {
      if (ViewCompat.getLayoutDirection(paramView) == 1)
      {
        label29:
        if (i == 0) {
          break label92;
        }
        i = j;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return 0;
        i = 0;
        break label29;
        label92:
        i = 3;
        continue;
        if (this.b == 8388613)
        {
          if (ViewCompat.getLayoutDirection(paramView) == 1)
          {
            i = m;
            label119:
            if (i == 0) {
              break label137;
            }
          }
          label137:
          for (i = k;; i = 5)
          {
            break;
            i = 0;
            break label119;
          }
        }
        i = this.b;
      }
    }
    return paramInt7 - paramInt1 + Math.abs(paramInt4 - paramInt2);
    return paramInt8 - paramInt2 + Math.abs(paramInt3 - paramInt1);
    return paramInt1 - paramInt5 + Math.abs(paramInt4 - paramInt2);
    return paramInt2 - paramInt6 + Math.abs(paramInt3 - paramInt1);
  }
  
  private int a(ViewGroup paramViewGroup)
  {
    switch (this.b)
    {
    default: 
      return paramViewGroup.getHeight();
    }
    return paramViewGroup.getWidth();
  }
  
  public long getStartDelay(ViewGroup paramViewGroup, Transition paramTransition, ag paramag1, ag paramag2)
  {
    if ((paramag1 == null) && (paramag2 == null)) {
      return 0L;
    }
    Rect localRect = paramTransition.getEpicenter();
    int i;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int j;
    if ((paramag2 == null) || (getViewVisibility(paramag1) == 0))
    {
      i = -1;
      m = getViewX(paramag1);
      n = getViewY(paramag1);
      paramag1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramag1);
      i1 = paramag1[0] + Math.round(paramViewGroup.getTranslationX());
      i2 = paramag1[1] + Math.round(paramViewGroup.getTranslationY());
      i3 = i1 + paramViewGroup.getWidth();
      i4 = i2 + paramViewGroup.getHeight();
      if (localRect == null) {
        break label201;
      }
      j = localRect.centerX();
    }
    for (int k = localRect.centerY();; k = (i2 + i4) / 2)
    {
      float f = a(paramViewGroup, m, n, j, k, i1, i2, i3, i4) / a(paramViewGroup);
      long l2 = paramTransition.getDuration();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 300L;
      }
      return Math.round((float)(l1 * i) / this.a * f);
      i = 1;
      paramag1 = paramag2;
      break;
      label201:
      j = (i1 + i3) / 2;
    }
  }
  
  public void setPropagationSpeed(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
    this.a = paramFloat;
  }
  
  public void setSide(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */