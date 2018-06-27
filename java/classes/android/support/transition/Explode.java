package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.Map;

public class Explode
  extends Visibility
{
  private static final TimeInterpolator a = new DecelerateInterpolator();
  private static final TimeInterpolator b = new AccelerateInterpolator();
  private int[] c = new int[2];
  
  public Explode()
  {
    setPropagation(new e());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setPropagation(new e());
  }
  
  private static float a(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private static float a(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return a(paramInt1, paramInt2);
  }
  
  private void a(ag paramag)
  {
    View localView = paramag.b;
    localView.getLocationOnScreen(this.c);
    int i = this.c[0];
    int j = this.c[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramag.a.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  private void a(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    paramView.getLocationOnScreen(this.c);
    int k = this.c[0];
    int m = this.c[1];
    Rect localRect = getEpicenter();
    int j;
    if (localRect == null)
    {
      i = paramView.getWidth() / 2;
      j = Math.round(paramView.getTranslationX()) + (i + k);
    }
    for (int i = paramView.getHeight() / 2 + m + Math.round(paramView.getTranslationY());; i = localRect.centerY())
    {
      int n = paramRect.centerX();
      int i1 = paramRect.centerY();
      float f3 = n - j;
      float f4 = i1 - i;
      float f1 = f4;
      float f2 = f3;
      if (f3 == 0.0F)
      {
        f1 = f4;
        f2 = f3;
        if (f4 == 0.0F)
        {
          f2 = (float)(Math.random() * 2.0D) - 1.0F;
          f1 = (float)(Math.random() * 2.0D) - 1.0F;
        }
      }
      f3 = a(f2, f1);
      f2 /= f3;
      f1 /= f3;
      f3 = a(paramView, j - k, i - m);
      paramArrayOfInt[0] = Math.round(f2 * f3);
      paramArrayOfInt[1] = Math.round(f3 * f1);
      return;
      j = localRect.centerX();
    }
  }
  
  public void captureEndValues(ag paramag)
  {
    super.captureEndValues(paramag);
    a(paramag);
  }
  
  public void captureStartValues(ag paramag)
  {
    super.captureStartValues(paramag);
    a(paramag);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, ag paramag1, ag paramag2)
  {
    if (paramag2 == null) {
      return null;
    }
    paramag1 = (Rect)paramag2.a.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    a(paramViewGroup, paramag1, this.c);
    float f3 = this.c[0];
    float f4 = this.c[1];
    return ai.a(paramView, paramag2, paramag1.left, paramag1.top, f1 + f3, f2 + f4, f1, f2, a);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, ag paramag1, ag paramag2)
  {
    if (paramag1 == null) {
      return null;
    }
    paramag2 = (Rect)paramag1.a.get("android:explode:screenBounds");
    int i = paramag2.left;
    int j = paramag2.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramag1.b.getTag(R.id.transition_position);
    float f1;
    if (arrayOfInt != null)
    {
      f2 = arrayOfInt[0] - paramag2.left;
      f1 = arrayOfInt[1] - paramag2.top;
      paramag2.offsetTo(arrayOfInt[0], arrayOfInt[1]);
      f1 += f4;
    }
    for (float f2 = f3 + f2;; f2 = f3)
    {
      a(paramViewGroup, paramag2, this.c);
      return ai.a(paramView, paramag1, i, j, f3, f4, f2 + this.c[0], f1 + this.c[1], b);
      f1 = f4;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/Explode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */