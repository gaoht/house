package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

class ai
{
  static Animator a(View paramView, ag paramag, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TimeInterpolator paramTimeInterpolator)
  {
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    Object localObject = (int[])paramag.b.getTag(R.id.transition_position);
    if (localObject != null)
    {
      paramFloat1 = localObject[0] - paramInt1 + f1;
      paramFloat2 = localObject[1] - paramInt2 + f2;
    }
    int i = Math.round(paramFloat1 - f1);
    int j = Math.round(paramFloat2 - f2);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    if ((paramFloat1 == paramFloat3) && (paramFloat2 == paramFloat4)) {
      return null;
    }
    localObject = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat3 }), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat2, paramFloat4 }) });
    paramView = new a(paramView, paramag.b, paramInt1 + i, paramInt2 + j, f1, f2, null);
    ((ObjectAnimator)localObject).addListener(paramView);
    a.a((Animator)localObject, paramView);
    ((ObjectAnimator)localObject).setInterpolator(paramTimeInterpolator);
    return (Animator)localObject;
  }
  
  private static class a
    extends AnimatorListenerAdapter
  {
    private final View a;
    private final View b;
    private final int c;
    private final int d;
    private int[] e;
    private float f;
    private float g;
    private final float h;
    private final float i;
    
    private a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      this.b = paramView1;
      this.a = paramView2;
      this.c = (paramInt1 - Math.round(this.b.getTranslationX()));
      this.d = (paramInt2 - Math.round(this.b.getTranslationY()));
      this.h = paramFloat1;
      this.i = paramFloat2;
      this.e = ((int[])this.a.getTag(R.id.transition_position));
      if (this.e != null) {
        this.a.setTag(R.id.transition_position, null);
      }
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      if (this.e == null) {
        this.e = new int[2];
      }
      this.e[0] = Math.round(this.c + this.b.getTranslationX());
      this.e[1] = Math.round(this.d + this.b.getTranslationY());
      this.a.setTag(R.id.transition_position, this.e);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.b.setTranslationX(this.h);
      this.b.setTranslationY(this.i);
    }
    
    public void onAnimationPause(Animator paramAnimator)
    {
      this.f = this.b.getTranslationX();
      this.g = this.b.getTranslationY();
      this.b.setTranslationX(this.h);
      this.b.setTranslationY(this.i);
    }
    
    public void onAnimationResume(Animator paramAnimator)
    {
      this.b.setTranslationX(this.f);
      this.b.setTranslationY(this.g);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */