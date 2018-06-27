package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class Fade
  extends Visibility
{
  public Fade() {}
  
  public Fade(int paramInt)
  {
    setMode(paramInt);
  }
  
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ab.f);
    setMode(TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, getMode()));
    paramContext.recycle();
  }
  
  private static float a(ag paramag, float paramFloat)
  {
    float f = paramFloat;
    if (paramag != null)
    {
      paramag = (Float)paramag.a.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramag != null) {
        f = paramag.floatValue();
      }
    }
    return f;
  }
  
  private Animator a(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    as.a(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, as.a, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new a(paramView));
    addListener(new ac()
    {
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        as.a(paramView, 1.0F);
        as.e(paramView);
        paramAnonymousTransition.removeListener(this);
      }
    });
    return localObjectAnimator;
  }
  
  public void captureStartValues(ag paramag)
  {
    super.captureStartValues(paramag);
    paramag.a.put("android:fade:transitionAlpha", Float.valueOf(as.c(paramag.b)));
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, ag paramag1, ag paramag2)
  {
    float f1 = 0.0F;
    float f2 = a(paramag1, 0.0F);
    if (f2 == 1.0F) {}
    for (;;)
    {
      return a(paramView, f1, 1.0F);
      f1 = f2;
    }
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, ag paramag1, ag paramag2)
  {
    as.d(paramView);
    return a(paramView, a(paramag1, 1.0F), 0.0F);
  }
  
  private static class a
    extends AnimatorListenerAdapter
  {
    private final View a;
    private boolean b = false;
    
    a(View paramView)
    {
      this.a = paramView;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      as.a(this.a, 1.0F);
      if (this.b) {
        this.a.setLayerType(0, null);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if ((ViewCompat.hasOverlappingRendering(this.a)) && (this.a.getLayerType() == 0))
      {
        this.b = true;
        this.a.setLayerType(2, null);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/Fade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */